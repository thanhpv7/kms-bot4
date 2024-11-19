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
	getTariffDefinitionCollectionModels,
	getCountTariffDefinitionModels,
	getTariffDefinitionModelWithId
} from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionCrudModule } from '../tariff-definition-crud.module';
import { TariffDefinitionCrudEditComponent } from './tariff-definition-crud-edit.component';
import {
	TariffDefinitionModelState,
	initialState as initialTariffDefinitionModelState
} from 'src/app/models/tariffDefinition/tariff_definition.model.state';
import { TariffDefinitionDataFactory } from 'src/app/lib/utils/factories/tariff-definition-data-factory';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { CrudTileMode } from '../tariff-definition-crud.component';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getPriceComponentModelWithId } from 'src/app/models/priceComponent/price_component.model.selector';
import { getPriceComponentCollectionModels } from 'src/app/models/priceComponent/price_component.model.selector';
import { PriceComponentModel } from 'src/app/models/priceComponent/price_component.model';
import { PriceComponentDataFactory } from 'src/app/lib/utils/factories/price-component-data-factory';
import { getTariffDefinitionOtherComponentModelWithId } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { getTariffDefinitionOtherComponentCollectionModels } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { TariffDefinitionOtherComponentModel } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model';
import { TariffDefinitionOtherComponentDataFactory } from 'src/app/lib/utils/factories/tariff-definition-other-component-data-factory';
import { getTariffFormulaModelWithId } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { getTariffFormulaCollectionModels } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { TariffFormulaModel } from 'src/app/models/tariffFormula/tariff_formula.model';
import { TariffFormulaDataFactory } from 'src/app/lib/utils/factories/tariff-formula-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';

describe('Tariff Definition CRUD Edit component tests', () => {
	let fixture: ComponentFixture<TariffDefinitionCrudEditComponent>
	let component: TariffDefinitionCrudEditComponent;

	let tariffDefinitionModelState: TariffDefinitionModelState;

	let store: MockStore<{ model: TariffDefinitionModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let tariffDefinitionCountBehaviorSubject: BehaviorSubject<number>;
	let tariffDefinitionModelsBehaviorSubject: BehaviorSubject<TariffDefinitionModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let priceComponentModelsBehaviorSubject: BehaviorSubject<PriceComponentModel[]>;
	let tariffDefinitionOtherComponentModelsBehaviorSubject: BehaviorSubject<TariffDefinitionOtherComponentModel[]>;
	let tariffFormulaModelsBehaviorSubject: BehaviorSubject<TariffFormulaModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;

	const tariffDefinitionFactory: TariffDefinitionDataFactory = new TariffDefinitionDataFactory();
	const defaultTariffDefinitionCount: number = 10;
	const defaultTariffDefinitionEntities: TariffDefinitionModel[] = tariffDefinitionFactory.createAll(defaultTariffDefinitionCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const priceComponentFactory: PriceComponentDataFactory = new PriceComponentDataFactory();
	const defaultPriceComponentCount: number = 10;
	const defaultPriceComponentEntities: PriceComponentModel[] = priceComponentFactory.createAll(defaultPriceComponentCount);

	const tariffDefinitionOtherComponentFactory: TariffDefinitionOtherComponentDataFactory = new TariffDefinitionOtherComponentDataFactory();
	const defaultTariffDefinitionOtherComponentCount: number = 10;
	const defaultTariffDefinitionOtherComponentEntities: TariffDefinitionOtherComponentModel[] = tariffDefinitionOtherComponentFactory.createAll(defaultTariffDefinitionOtherComponentCount);

	const tariffFormulaFactory: TariffFormulaDataFactory = new TariffFormulaDataFactory();
	const defaultTariffFormulaCount: number = 10;
	const defaultTariffFormulaEntities: TariffFormulaModel[] = tariffFormulaFactory.createAll(defaultTariffFormulaCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let tariffDefinitionWithId: TariffDefinitionModel = defaultTariffDefinitionEntities[0];
	let tariffDefinitionModelWithIdBehaviorSubject: BehaviorSubject<TariffDefinitionModel>;

	tariffDefinitionWithId.priceSchema = defaultTariffSchemaEntities[0];
	tariffDefinitionWithId.priceSchemaId = tariffDefinitionWithId.priceSchema.id;
	let priceSchemaWithIdBehaviorSubject: BehaviorSubject<TariffSchemaModel>;

	tariffDefinitionWithId.tariffDefinitionOtherComponents = defaultTariffDefinitionOtherComponentEntities;
	tariffDefinitionWithId.tariffDefinitionOtherComponentsIds = tariffDefinitionWithId.tariffDefinitionOtherComponents.map(tariffDefinitionOtherComponents => tariffDefinitionOtherComponents.id);


	const routerState: RouterState = {
		url: 'tariff-definition-crud',
		urls: ['tariff-definition-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: TariffDefinitionModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		tariffDefinitionModelState = initialTariffDefinitionModelState;
		store.setState({model: tariffDefinitionModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		tariffDefinitionCountBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionCount);

		// selectors for all references
		tariffDefinitionModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		priceComponentModelsBehaviorSubject = new BehaviorSubject(defaultPriceComponentEntities);
		tariffDefinitionOtherComponentModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionOtherComponentEntities);
		tariffFormulaModelsBehaviorSubject = new BehaviorSubject(defaultTariffFormulaEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);

		// selectors for target entity and its related entity
		tariffDefinitionModelWithIdBehaviorSubject = new BehaviorSubject(tariffDefinitionWithId);
		priceSchemaWithIdBehaviorSubject = new BehaviorSubject(tariffDefinitionWithId.priceSchema);

		spyOn(store, 'select')
			.withArgs(getCountTariffDefinitionModels).and.returnValue(tariffDefinitionCountBehaviorSubject)
			.withArgs(getTariffDefinitionModelWithId, tariffDefinitionWithId.id).and.returnValue(tariffDefinitionModelWithIdBehaviorSubject)
			.withArgs(getTariffDefinitionCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getPriceComponentCollectionModels, jasmine.any(String)).and.returnValue(priceComponentModelsBehaviorSubject)
			.withArgs(getTariffDefinitionOtherComponentCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionOtherComponentModelsBehaviorSubject)
			.withArgs(getTariffFormulaCollectionModels, jasmine.any(String)).and.returnValue(tariffFormulaModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getTariffSchemaModelWithId, tariffDefinitionWithId.priceSchemaId).and.returnValue(priceSchemaWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				TariffDefinitionCrudModule,
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

			fixture = TestBed.createComponent(TariffDefinitionCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new TariffDefinitionModel();
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
	it ('Renders the Tariff Definition CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Price Schema relation.
	*
	* The button should only exist if priceSchemaMultiCrudActive is true
	*/
	it ('Renders Price Schema Add Entity button in create mode', fakeAsync(() => {
		const priceSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.priceSchemaDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!priceSchemaButton).toEqual(component.priceSchemaMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Price Schema', fakeAsync(() => {
		const priceSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.priceSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!priceSchemaButton).toEqual(component.priceSchemaMultiCrudActive);

		if (component.priceSchemaMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPriceSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.priceSchemaDisplayName + ' from Model')).length;

			priceSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const actualPriceSchemaRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.priceSchemaDisplayName + ' from Model')).length;

			expect(actualPriceSchemaRemoveButtonCount).toEqual(initialPriceSchemaRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Price Schema button', () => {
		const priceSchemaButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.priceSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!priceSchemaButton).toEqual(component.priceSchemaMultiCrudActive);

		if (component.priceSchemaMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			priceSchemaButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPriceSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.priceSchemaDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPriceSchemaRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPriceSchemaRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.priceSchemaDisplayName + ' from Model'));

			expect(actualPriceSchemaRemoveButtons.length).toEqual(initialPriceSchemaRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Price Schema button when one has already been added', () => {

		const priceSchemaButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.priceSchemaDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!priceSchemaButton).toEqual(component.priceSchemaMultiCrudActive);

		if (component.priceSchemaMultiCrudActive) {
			priceSchemaButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpriceSchemaButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.priceSchemaDisplayName + ' to Model'));

			expect(updatedpriceSchemaButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Price Schema entities from model when loading in edit mode', () => {
		component.targetModel = tariffDefinitionWithId;
		component.targetModelId = tariffDefinitionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.priceSchemaMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const priceSchemaRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.priceSchemaDisplayName + ' from Model')).length;

			expect(priceSchemaRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Definition Other Components relation.
	*
	* The button should only exist if tariffDefinitionOtherComponentsMultiCrudActive is true
	*/
	it ('Renders Tariff Definition Other Components Add Entity button in create mode', fakeAsync(() => {
		const tariffDefinitionOtherComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionOtherComponentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffDefinitionOtherComponentsButton).toEqual(component.tariffDefinitionOtherComponentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Definition Other Components', fakeAsync(() => {
		const tariffDefinitionOtherComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionOtherComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionOtherComponentsButton).toEqual(component.tariffDefinitionOtherComponentsMultiCrudActive);

		if (component.tariffDefinitionOtherComponentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffDefinitionOtherComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionOtherComponentsDisplayName + ' from Model')).length;

			tariffDefinitionOtherComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffDefinitionOtherComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionOtherComponentsDisplayName + ' from Model')).length;

			expect(actualTariffDefinitionOtherComponentsRemoveButtonCount).toEqual(initialTariffDefinitionOtherComponentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Definition Other Components button', () => {
		const tariffDefinitionOtherComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionOtherComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionOtherComponentsButton).toEqual(component.tariffDefinitionOtherComponentsMultiCrudActive);

		if (component.tariffDefinitionOtherComponentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffDefinitionOtherComponentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffDefinitionOtherComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionOtherComponentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffDefinitionOtherComponentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffDefinitionOtherComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionOtherComponentsDisplayName + ' from Model'));

			expect(actualTariffDefinitionOtherComponentsRemoveButtons.length).toEqual(initialTariffDefinitionOtherComponentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Tariff Definition Other Components button when one has already been added', () => {

		const tariffDefinitionOtherComponentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionOtherComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionOtherComponentsButton).toEqual(component.tariffDefinitionOtherComponentsMultiCrudActive);

		if (component.tariffDefinitionOtherComponentsMultiCrudActive) {
			tariffDefinitionOtherComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffDefinitionOtherComponentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionOtherComponentsDisplayName + ' to Model'));

			expect(updatedtariffDefinitionOtherComponentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Tariff Definition Other Components entities from model when loading in edit mode', () => {
		component.targetModel = tariffDefinitionWithId;
		component.targetModelId = tariffDefinitionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffDefinitionOtherComponentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffDefinitionOtherComponentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionOtherComponentsDisplayName + ' from Model')).length;

			expect(tariffDefinitionOtherComponentsRemoveButtonCount).toEqual(tariffDefinitionWithId.tariffDefinitionOtherComponents.length);
		}
	});

});
