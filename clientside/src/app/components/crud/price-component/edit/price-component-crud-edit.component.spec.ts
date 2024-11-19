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
	getPriceComponentCollectionModels,
	getCountPriceComponentModels,
	getPriceComponentModelWithId
} from 'src/app/models/priceComponent/price_component.model.selector';
import { PriceComponentCrudModule } from '../price-component-crud.module';
import { PriceComponentCrudEditComponent } from './price-component-crud-edit.component';
import {
	PriceComponentModelState,
	initialState as initialPriceComponentModelState
} from 'src/app/models/priceComponent/price_component.model.state';
import { PriceComponentDataFactory } from 'src/app/lib/utils/factories/price-component-data-factory';
import { PriceComponentModel } from 'src/app/models/priceComponent/price_component.model';
import { CrudTileMode } from '../price-component-crud.component';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getInvoiceItemComponentModelWithId } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { getInvoiceItemComponentCollectionModels } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { InvoiceItemComponentModel } from 'src/app/models/invoiceItemComponent/invoice_item_component.model';
import { InvoiceItemComponentDataFactory } from 'src/app/lib/utils/factories/invoice-item-component-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicalFeeItemComponentModelWithId } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { getMedicalFeeItemComponentCollectionModels } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { MedicalFeeItemComponentModel } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model';
import { MedicalFeeItemComponentDataFactory } from 'src/app/lib/utils/factories/medical-fee-item-component-data-factory';
import { getTariffDefinitionModelWithId } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { getTariffDefinitionCollectionModels } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { TariffDefinitionDataFactory } from 'src/app/lib/utils/factories/tariff-definition-data-factory';
import { getTariffDefinitionOtherComponentModelWithId } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { getTariffDefinitionOtherComponentCollectionModels } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { TariffDefinitionOtherComponentModel } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model';
import { TariffDefinitionOtherComponentDataFactory } from 'src/app/lib/utils/factories/tariff-definition-other-component-data-factory';

describe('Price Component CRUD Edit component tests', () => {
	let fixture: ComponentFixture<PriceComponentCrudEditComponent>
	let component: PriceComponentCrudEditComponent;

	let priceComponentModelState: PriceComponentModelState;

	let store: MockStore<{ model: PriceComponentModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let priceComponentCountBehaviorSubject: BehaviorSubject<number>;
	let priceComponentModelsBehaviorSubject: BehaviorSubject<PriceComponentModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceItemComponentModelsBehaviorSubject: BehaviorSubject<InvoiceItemComponentModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicalFeeItemComponentModelsBehaviorSubject: BehaviorSubject<MedicalFeeItemComponentModel[]>;
	let tariffDefinitionModelsBehaviorSubject: BehaviorSubject<TariffDefinitionModel[]>;
	let tariffDefinitionOtherComponentModelsBehaviorSubject: BehaviorSubject<TariffDefinitionOtherComponentModel[]>;

	const priceComponentFactory: PriceComponentDataFactory = new PriceComponentDataFactory();
	const defaultPriceComponentCount: number = 10;
	const defaultPriceComponentEntities: PriceComponentModel[] = priceComponentFactory.createAll(defaultPriceComponentCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceItemComponentFactory: InvoiceItemComponentDataFactory = new InvoiceItemComponentDataFactory();
	const defaultInvoiceItemComponentCount: number = 10;
	const defaultInvoiceItemComponentEntities: InvoiceItemComponentModel[] = invoiceItemComponentFactory.createAll(defaultInvoiceItemComponentCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicalFeeItemComponentFactory: MedicalFeeItemComponentDataFactory = new MedicalFeeItemComponentDataFactory();
	const defaultMedicalFeeItemComponentCount: number = 10;
	const defaultMedicalFeeItemComponentEntities: MedicalFeeItemComponentModel[] = medicalFeeItemComponentFactory.createAll(defaultMedicalFeeItemComponentCount);

	const tariffDefinitionFactory: TariffDefinitionDataFactory = new TariffDefinitionDataFactory();
	const defaultTariffDefinitionCount: number = 10;
	const defaultTariffDefinitionEntities: TariffDefinitionModel[] = tariffDefinitionFactory.createAll(defaultTariffDefinitionCount);

	const tariffDefinitionOtherComponentFactory: TariffDefinitionOtherComponentDataFactory = new TariffDefinitionOtherComponentDataFactory();
	const defaultTariffDefinitionOtherComponentCount: number = 10;
	const defaultTariffDefinitionOtherComponentEntities: TariffDefinitionOtherComponentModel[] = tariffDefinitionOtherComponentFactory.createAll(defaultTariffDefinitionOtherComponentCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let priceComponentWithId: PriceComponentModel = defaultPriceComponentEntities[0];
	let priceComponentModelWithIdBehaviorSubject: BehaviorSubject<PriceComponentModel>;

	priceComponentWithId.invoiceItemComponents = defaultInvoiceItemComponentEntities;
	priceComponentWithId.invoiceItemComponentsIds = priceComponentWithId.invoiceItemComponents.map(invoiceItemComponents => invoiceItemComponents.id);

	priceComponentWithId.medicalFeeItemComponents = defaultMedicalFeeItemComponentEntities;
	priceComponentWithId.medicalFeeItemComponentsIds = priceComponentWithId.medicalFeeItemComponents.map(medicalFeeItemComponents => medicalFeeItemComponents.id);

	priceComponentWithId.tariffDefinitionOtherComponents = defaultTariffDefinitionOtherComponentEntities;
	priceComponentWithId.tariffDefinitionOtherComponentsIds = priceComponentWithId.tariffDefinitionOtherComponents.map(tariffDefinitionOtherComponents => tariffDefinitionOtherComponents.id);


	const routerState: RouterState = {
		url: 'price-component-crud',
		urls: ['price-component-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: PriceComponentModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		priceComponentModelState = initialPriceComponentModelState;
		store.setState({model: priceComponentModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		priceComponentCountBehaviorSubject = new BehaviorSubject(defaultPriceComponentCount);

		// selectors for all references
		priceComponentModelsBehaviorSubject = new BehaviorSubject(defaultPriceComponentEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemComponentEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicalFeeItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeItemComponentEntities);
		tariffDefinitionModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionEntities);
		tariffDefinitionOtherComponentModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionOtherComponentEntities);

		// selectors for target entity and its related entity
		priceComponentModelWithIdBehaviorSubject = new BehaviorSubject(priceComponentWithId);

		spyOn(store, 'select')
			.withArgs(getCountPriceComponentModels).and.returnValue(priceComponentCountBehaviorSubject)
			.withArgs(getPriceComponentModelWithId, priceComponentWithId.id).and.returnValue(priceComponentModelWithIdBehaviorSubject)
			.withArgs(getPriceComponentCollectionModels, jasmine.any(String)).and.returnValue(priceComponentModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceItemComponentCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemComponentModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicalFeeItemComponentCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeItemComponentModelsBehaviorSubject)
			.withArgs(getTariffDefinitionCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionModelsBehaviorSubject)
			.withArgs(getTariffDefinitionOtherComponentCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionOtherComponentModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				PriceComponentCrudModule,
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

			fixture = TestBed.createComponent(PriceComponentCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new PriceComponentModel();
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
	it ('Renders the Price Component CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Invoice Item Components relation.
	*
	* The button should only exist if invoiceItemComponentsMultiCrudActive is true
	*/
	it ('Renders Invoice Item Components Add Entity button in create mode', fakeAsync(() => {
		const invoiceItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemComponentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceItemComponentsButton).toEqual(component.invoiceItemComponentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Item Components', fakeAsync(() => {
		const invoiceItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemComponentsButton).toEqual(component.invoiceItemComponentsMultiCrudActive);

		if (component.invoiceItemComponentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceItemComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemComponentsDisplayName + ' from Model')).length;

			invoiceItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemComponentsDisplayName + ' from Model')).length;

			expect(actualInvoiceItemComponentsRemoveButtonCount).toEqual(initialInvoiceItemComponentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Item Components button', () => {
		const invoiceItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemComponentsButton).toEqual(component.invoiceItemComponentsMultiCrudActive);

		if (component.invoiceItemComponentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceItemComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemComponentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceItemComponentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemComponentsDisplayName + ' from Model'));

			expect(actualInvoiceItemComponentsRemoveButtons.length).toEqual(initialInvoiceItemComponentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Item Components button when one has already been added', () => {

		const invoiceItemComponentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemComponentsButton).toEqual(component.invoiceItemComponentsMultiCrudActive);

		if (component.invoiceItemComponentsMultiCrudActive) {
			invoiceItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceItemComponentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemComponentsDisplayName + ' to Model'));

			expect(updatedinvoiceItemComponentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Item Components entities from model when loading in edit mode', () => {
		component.targetModel = priceComponentWithId;
		component.targetModelId = priceComponentWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceItemComponentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceItemComponentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemComponentsDisplayName + ' from Model')).length;

			expect(invoiceItemComponentsRemoveButtonCount).toEqual(priceComponentWithId.invoiceItemComponents.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Medical Fee Item Components relation.
	*
	* The button should only exist if medicalFeeItemComponentsMultiCrudActive is true
	*/
	it ('Renders Medical Fee Item Components Add Entity button in create mode', fakeAsync(() => {
		const medicalFeeItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeeItemComponentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!medicalFeeItemComponentsButton).toEqual(component.medicalFeeItemComponentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Medical Fee Item Components', fakeAsync(() => {
		const medicalFeeItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeeItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeeItemComponentsButton).toEqual(component.medicalFeeItemComponentsMultiCrudActive);

		if (component.medicalFeeItemComponentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMedicalFeeItemComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeeItemComponentsDisplayName + ' from Model')).length;

			medicalFeeItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMedicalFeeItemComponentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeeItemComponentsDisplayName + ' from Model')).length;

			expect(actualMedicalFeeItemComponentsRemoveButtonCount).toEqual(initialMedicalFeeItemComponentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Medical Fee Item Components button', () => {
		const medicalFeeItemComponentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeeItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeeItemComponentsButton).toEqual(component.medicalFeeItemComponentsMultiCrudActive);

		if (component.medicalFeeItemComponentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			medicalFeeItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMedicalFeeItemComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeeItemComponentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMedicalFeeItemComponentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMedicalFeeItemComponentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeeItemComponentsDisplayName + ' from Model'));

			expect(actualMedicalFeeItemComponentsRemoveButtons.length).toEqual(initialMedicalFeeItemComponentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Medical Fee Item Components button when one has already been added', () => {

		const medicalFeeItemComponentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeeItemComponentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!medicalFeeItemComponentsButton).toEqual(component.medicalFeeItemComponentsMultiCrudActive);

		if (component.medicalFeeItemComponentsMultiCrudActive) {
			medicalFeeItemComponentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmedicalFeeItemComponentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.medicalFeeItemComponentsDisplayName + ' to Model'));

			expect(updatedmedicalFeeItemComponentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Medical Fee Item Components entities from model when loading in edit mode', () => {
		component.targetModel = priceComponentWithId;
		component.targetModelId = priceComponentWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.medicalFeeItemComponentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const medicalFeeItemComponentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.medicalFeeItemComponentsDisplayName + ' from Model')).length;

			expect(medicalFeeItemComponentsRemoveButtonCount).toEqual(priceComponentWithId.medicalFeeItemComponents.length);
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
		component.targetModel = priceComponentWithId;
		component.targetModelId = priceComponentWithId.id;
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

			expect(tariffDefinitionOtherComponentsRemoveButtonCount).toEqual(priceComponentWithId.tariffDefinitionOtherComponents.length);
		}
	});

});
