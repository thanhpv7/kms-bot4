/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { By } from '@angular/platform-browser';
import { ComponentFixture, TestBed, waitForAsync, fakeAsync } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Store } from '@ngrx/store';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
import { 
	getTariffFormulaCollectionModels,
	getCountTariffFormulaModels,
	getTariffFormulaModelWithId
} from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { TariffFormulaCrudModule } from '../tariff-formula-crud.module';
import { TariffFormulaCrudEditComponent } from './tariff-formula-crud-edit.component';
import {
	TariffFormulaModelState,
	initialState as initialTariffFormulaModelState
} from 'src/app/models/tariffFormula/tariff_formula.model.state';
import { TariffFormulaDataFactory } from 'src/app/lib/utils/factories/tariff-formula-data-factory';
import { TariffFormulaModel } from 'src/app/models/tariffFormula/tariff_formula.model';
import { CrudTileMode } from '../tariff-formula-crud.component';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getTariffDefinitionModelWithId } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { getTariffDefinitionCollectionModels } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { TariffDefinitionDataFactory } from 'src/app/lib/utils/factories/tariff-definition-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';

describe('Tariff Formula CRUD Edit component tests', () => {
	let fixture: ComponentFixture<TariffFormulaCrudEditComponent>
	let component: TariffFormulaCrudEditComponent;

	let tariffFormulaModelState: TariffFormulaModelState;

	let store: MockStore<{ model: TariffFormulaModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let tariffFormulaCountBehaviorSubject: BehaviorSubject<number>;
	let tariffFormulaModelsBehaviorSubject: BehaviorSubject<TariffFormulaModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let tariffDefinitionModelsBehaviorSubject: BehaviorSubject<TariffDefinitionModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;

	const tariffFormulaFactory: TariffFormulaDataFactory = new TariffFormulaDataFactory();
	const defaultTariffFormulaCount: number = 10;
	const defaultTariffFormulaEntities: TariffFormulaModel[] = tariffFormulaFactory.createAll(defaultTariffFormulaCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const tariffDefinitionFactory: TariffDefinitionDataFactory = new TariffDefinitionDataFactory();
	const defaultTariffDefinitionCount: number = 10;
	const defaultTariffDefinitionEntities: TariffDefinitionModel[] = tariffDefinitionFactory.createAll(defaultTariffDefinitionCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let tariffFormulaWithId: TariffFormulaModel = defaultTariffFormulaEntities[0];
	let tariffFormulaModelWithIdBehaviorSubject: BehaviorSubject<TariffFormulaModel>;

	tariffFormulaWithId.baseSchema = defaultTariffSchemaEntities[0];
	tariffFormulaWithId.baseSchemaId = tariffFormulaWithId.baseSchema.id;
	let baseSchemaWithIdBehaviorSubject: BehaviorSubject<TariffSchemaModel>;

	tariffFormulaWithId.tariffSchema = defaultTariffSchemaEntities[0];
	tariffFormulaWithId.tariffSchemaId = tariffFormulaWithId.tariffSchema.id;
	let tariffSchemaWithIdBehaviorSubject: BehaviorSubject<TariffSchemaModel>;


	const routerState: RouterState = {
		url: 'tariff-formula-crud',
		urls: ['tariff-formula-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: TariffFormulaModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		tariffFormulaModelState = initialTariffFormulaModelState;
		store.setState({model: tariffFormulaModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		tariffFormulaCountBehaviorSubject = new BehaviorSubject(defaultTariffFormulaCount);

		// selectors for all references
		tariffFormulaModelsBehaviorSubject = new BehaviorSubject(defaultTariffFormulaEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		tariffDefinitionModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);

		// selectors for target entity and its related entity
		tariffFormulaModelWithIdBehaviorSubject = new BehaviorSubject(tariffFormulaWithId);
		baseSchemaWithIdBehaviorSubject = new BehaviorSubject(tariffFormulaWithId.baseSchema);
		tariffSchemaWithIdBehaviorSubject = new BehaviorSubject(tariffFormulaWithId.tariffSchema);

		spyOn(store, 'select')
			.withArgs(getCountTariffFormulaModels).and.returnValue(tariffFormulaCountBehaviorSubject)
			.withArgs(getTariffFormulaModelWithId, tariffFormulaWithId.id).and.returnValue(tariffFormulaModelWithIdBehaviorSubject)
			.withArgs(getTariffFormulaCollectionModels, jasmine.any(String)).and.returnValue(tariffFormulaModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getTariffDefinitionCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getTariffSchemaModelWithId, tariffFormulaWithId.baseSchemaId).and.returnValue(baseSchemaWithIdBehaviorSubject)
			.withArgs(getTariffSchemaModelWithId, tariffFormulaWithId.tariffSchemaId).and.returnValue(tariffSchemaWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				TariffFormulaCrudModule,
				CommonComponentModule,
				FormsModule,
				ReactiveFormsModule,
			],
			providers: [
				provideMockStore(),
				{
					provide: ActivatedRoute,
					useValue: activatedRouteStub,
				},
				CookieService,
				ModalDialogService,
				ModalDialogInstanceService,
			]
		}).compileComponents().then(() => {

			spySelectorsInStore();

			fixture = TestBed.createComponent(TariffFormulaCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new TariffFormulaModel();
			component.createReactiveForm();
			fixture.detectChanges();


		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
		component.ngOnDestroy();
	});

	/**
	 * Checks that the component is created by the test initialisation
	 */
	it ('Renders the Tariff Formula CRUD Edit Component', () => {
		expect(component).toBeTruthy();
	});

	/**
	 * Checks that there are no add additional model buttons present in the component when in view mode.
	 *
	 * This test does not require checking whether multi crud is active for a given relation, as the expected outcome
	 * is identical for components with multi entity crud active and for components without it
	 */
	it ('Does not render any add entity buttons when in view mode', fakeAsync(() => {
		component.tileMode = CrudTileMode.View;
		fixture.detectChanges();

		const addEntityButtons: DebugElement[] = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'));

		expect(addEntityButtons.length).toEqual(0);
	}));

	/**
	* Checks that the status of the add model button matches the multi entity status for the Base Schema relation.
	*
	* The button should only exist if baseSchemaMultiCrudActive is true
	*/
	it ('Renders Base Schema Add Entity button in create mode', fakeAsync(() => {
		const baseSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemaDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!baseSchemaButton).toEqual(component.baseSchemaMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Base Schema', fakeAsync(() => {
		const baseSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemaButton).toEqual(component.baseSchemaMultiCrudActive);

		if (component.baseSchemaMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBaseSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemaDisplayName + ' from Model')).length;

			baseSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const actualBaseSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemaDisplayName + ' from Model')).length;

			expect(actualBaseSchemaRemoveButtonCount).toEqual(initialBaseSchemaRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Base Schema button', () => {
		const baseSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemaButton).toEqual(component.baseSchemaMultiCrudActive);

		if (component.baseSchemaMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			baseSchemaButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBaseSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemaDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBaseSchemaRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBaseSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemaDisplayName + ' from Model'));

			expect(actualBaseSchemaRemoveButtons.length).toEqual(initialBaseSchemaRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Base Schema button when one has already been added', () => {

		const baseSchemaButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemaButton).toEqual(component.baseSchemaMultiCrudActive);

		if (component.baseSchemaMultiCrudActive) {
			baseSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbaseSchemaButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemaDisplayName + ' to Model'));

			expect(updatedbaseSchemaButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Base Schema entities from model when loading in edit mode', () => {
		component.targetModel = tariffFormulaWithId;
		component.targetModelId = tariffFormulaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.baseSchemaMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const baseSchemaRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemaDisplayName + ' from Model')).length;

			expect(baseSchemaRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Schema relation.
	*
	* The button should only exist if tariffSchemaMultiCrudActive is true
	*/
	it ('Renders Tariff Schema Add Entity button in create mode', fakeAsync(() => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Schema', fakeAsync(() => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			expect(actualTariffSchemaRemoveButtonCount).toEqual(initialTariffSchemaRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Schema button', () => {
		const tariffSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffSchemaRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model'));

			expect(actualTariffSchemaRemoveButtons.length).toEqual(initialTariffSchemaRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Tariff Schema button when one has already been added', () => {

		const tariffSchemaButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemaButton).toEqual(component.tariffSchemaMultiCrudActive);

		if (component.tariffSchemaMultiCrudActive) {
			tariffSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffSchemaButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemaDisplayName + ' to Model'));

			expect(updatedtariffSchemaButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Tariff Schema entities from model when loading in edit mode', () => {
		component.targetModel = tariffFormulaWithId;
		component.targetModelId = tariffFormulaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffSchemaMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffSchemaRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemaDisplayName + ' from Model')).length;

			expect(tariffSchemaRemoveButtonCount).toEqual(1);
		}
	});

});
