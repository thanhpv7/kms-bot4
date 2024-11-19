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
	getCompoundPrescriptionDetailCollectionModels,
	getCountCompoundPrescriptionDetailModels,
	getCompoundPrescriptionDetailModelWithId
} from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { CompoundPrescriptionDetailCrudModule } from '../compound-prescription-detail-crud.module';
import { CompoundPrescriptionDetailCrudEditComponent } from './compound-prescription-detail-crud-edit.component';
import {
	CompoundPrescriptionDetailModelState,
	initialState as initialCompoundPrescriptionDetailModelState
} from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.state';
import { CompoundPrescriptionDetailDataFactory } from 'src/app/lib/utils/factories/compound-prescription-detail-data-factory';
import { CompoundPrescriptionDetailModel } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model';
import { CrudTileMode } from '../compound-prescription-detail-crud.component';
import { getCatalogueUOMModelWithId } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { getCatalogueUOMCollectionModels } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { CatalogueUOMModel } from 'src/app/models/catalogueUOM/catalogue_uom.model';
import { CatalogueUOMDataFactory } from 'src/app/lib/utils/factories/catalogue-uom-data-factory';
import { getCompoundPrescriptionItemModelWithId } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { getCompoundPrescriptionItemCollectionModels } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { CompoundPrescriptionItemModel } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import { CompoundPrescriptionItemDataFactory } from 'src/app/lib/utils/factories/compound-prescription-item-data-factory';
import { getMedicationCompoundModelWithId } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { getMedicationCompoundCollectionModels } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { MedicationCompoundModel } from 'src/app/models/medicationCompound/medication_compound.model';
import { MedicationCompoundDataFactory } from 'src/app/lib/utils/factories/medication-compound-data-factory';
import { getMedicationItemModelWithId } from 'src/app/models/medicationItem/medication_item.model.selector';
import { getMedicationItemCollectionModels } from 'src/app/models/medicationItem/medication_item.model.selector';
import { MedicationItemModel } from 'src/app/models/medicationItem/medication_item.model';
import { MedicationItemDataFactory } from 'src/app/lib/utils/factories/medication-item-data-factory';
import { getPrescriptionCompoundModelWithId } from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { getPrescriptionCompoundCollectionModels } from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { PrescriptionCompoundModel } from 'src/app/models/prescriptionCompound/prescription_compound.model';
import { PrescriptionCompoundDataFactory } from 'src/app/lib/utils/factories/prescription-compound-data-factory';
import { getPrescriptionItemModelWithId } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { getPrescriptionItemCollectionModels } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { PrescriptionItemModel } from 'src/app/models/prescriptionItem/prescription_item.model';
import { PrescriptionItemDataFactory } from 'src/app/lib/utils/factories/prescription-item-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getUnitOfMeasurementModelWithId } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { getUnitOfMeasurementCollectionModels } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { UnitOfMeasurementModel } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model';
import { UnitOfMeasurementDataFactory } from 'src/app/lib/utils/factories/unit-of-measurement-data-factory';

describe('Compound Prescription Detail CRUD Edit component tests', () => {
	let fixture: ComponentFixture<CompoundPrescriptionDetailCrudEditComponent>
	let component: CompoundPrescriptionDetailCrudEditComponent;

	let compoundPrescriptionDetailModelState: CompoundPrescriptionDetailModelState;

	let store: MockStore<{ model: CompoundPrescriptionDetailModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let compoundPrescriptionDetailCountBehaviorSubject: BehaviorSubject<number>;
	let compoundPrescriptionDetailModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionDetailModel[]>;
	let catalogueUOMModelsBehaviorSubject: BehaviorSubject<CatalogueUOMModel[]>;
	let compoundPrescriptionItemModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionItemModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let prescriptionCompoundModelsBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let unitOfMeasurementModelsBehaviorSubject: BehaviorSubject<UnitOfMeasurementModel[]>;

	const compoundPrescriptionDetailFactory: CompoundPrescriptionDetailDataFactory = new CompoundPrescriptionDetailDataFactory();
	const defaultCompoundPrescriptionDetailCount: number = 10;
	const defaultCompoundPrescriptionDetailEntities: CompoundPrescriptionDetailModel[] = compoundPrescriptionDetailFactory.createAll(defaultCompoundPrescriptionDetailCount);

	const catalogueUOMFactory: CatalogueUOMDataFactory = new CatalogueUOMDataFactory();
	const defaultCatalogueUOMCount: number = 10;
	const defaultCatalogueUOMEntities: CatalogueUOMModel[] = catalogueUOMFactory.createAll(defaultCatalogueUOMCount);

	const compoundPrescriptionItemFactory: CompoundPrescriptionItemDataFactory = new CompoundPrescriptionItemDataFactory();
	const defaultCompoundPrescriptionItemCount: number = 10;
	const defaultCompoundPrescriptionItemEntities: CompoundPrescriptionItemModel[] = compoundPrescriptionItemFactory.createAll(defaultCompoundPrescriptionItemCount);

	const medicationCompoundFactory: MedicationCompoundDataFactory = new MedicationCompoundDataFactory();
	const defaultMedicationCompoundCount: number = 10;
	const defaultMedicationCompoundEntities: MedicationCompoundModel[] = medicationCompoundFactory.createAll(defaultMedicationCompoundCount);

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const prescriptionCompoundFactory: PrescriptionCompoundDataFactory = new PrescriptionCompoundDataFactory();
	const defaultPrescriptionCompoundCount: number = 10;
	const defaultPrescriptionCompoundEntities: PrescriptionCompoundModel[] = prescriptionCompoundFactory.createAll(defaultPrescriptionCompoundCount);

	const prescriptionItemFactory: PrescriptionItemDataFactory = new PrescriptionItemDataFactory();
	const defaultPrescriptionItemCount: number = 10;
	const defaultPrescriptionItemEntities: PrescriptionItemModel[] = prescriptionItemFactory.createAll(defaultPrescriptionItemCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const unitOfMeasurementFactory: UnitOfMeasurementDataFactory = new UnitOfMeasurementDataFactory();
	const defaultUnitOfMeasurementCount: number = 10;
	const defaultUnitOfMeasurementEntities: UnitOfMeasurementModel[] = unitOfMeasurementFactory.createAll(defaultUnitOfMeasurementCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let compoundPrescriptionDetailWithId: CompoundPrescriptionDetailModel = defaultCompoundPrescriptionDetailEntities[0];
	let compoundPrescriptionDetailModelWithIdBehaviorSubject: BehaviorSubject<CompoundPrescriptionDetailModel>;

	compoundPrescriptionDetailWithId.consumptionUnit = defaultUnitOfMeasurementEntities[0];
	compoundPrescriptionDetailWithId.consumptionUnitId = compoundPrescriptionDetailWithId.consumptionUnit.id;
	let consumptionUnitWithIdBehaviorSubject: BehaviorSubject<UnitOfMeasurementModel>;

	compoundPrescriptionDetailWithId.compoundPrescriptionItems = defaultCompoundPrescriptionItemEntities;
	compoundPrescriptionDetailWithId.compoundPrescriptionItemsIds = compoundPrescriptionDetailWithId.compoundPrescriptionItems.map(compoundPrescriptionItems => compoundPrescriptionItems.id);


	const routerState: RouterState = {
		url: 'compound-prescription-detail-crud',
		urls: ['compound-prescription-detail-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: CompoundPrescriptionDetailModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		compoundPrescriptionDetailModelState = initialCompoundPrescriptionDetailModelState;
		store.setState({model: compoundPrescriptionDetailModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		compoundPrescriptionDetailCountBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionDetailCount);

		// selectors for all references
		compoundPrescriptionDetailModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionDetailEntities);
		catalogueUOMModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueUOMEntities);
		compoundPrescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionItemEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		prescriptionCompoundModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		unitOfMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultUnitOfMeasurementEntities);

		// selectors for target entity and its related entity
		compoundPrescriptionDetailModelWithIdBehaviorSubject = new BehaviorSubject(compoundPrescriptionDetailWithId);
		consumptionUnitWithIdBehaviorSubject = new BehaviorSubject(compoundPrescriptionDetailWithId.consumptionUnit);

		spyOn(store, 'select')
			.withArgs(getCountCompoundPrescriptionDetailModels).and.returnValue(compoundPrescriptionDetailCountBehaviorSubject)
			.withArgs(getCompoundPrescriptionDetailModelWithId, compoundPrescriptionDetailWithId.id).and.returnValue(compoundPrescriptionDetailModelWithIdBehaviorSubject)
			.withArgs(getCompoundPrescriptionDetailCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionDetailModelsBehaviorSubject)
			.withArgs(getCatalogueUOMCollectionModels, jasmine.any(String)).and.returnValue(catalogueUOMModelsBehaviorSubject)
			.withArgs(getCompoundPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionItemModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getPrescriptionCompoundCollectionModels, jasmine.any(String)).and.returnValue(prescriptionCompoundModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getUnitOfMeasurementCollectionModels, jasmine.any(String)).and.returnValue(unitOfMeasurementModelsBehaviorSubject)
			.withArgs(getUnitOfMeasurementModelWithId, compoundPrescriptionDetailWithId.consumptionUnitId).and.returnValue(consumptionUnitWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				CompoundPrescriptionDetailCrudModule,
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

			fixture = TestBed.createComponent(CompoundPrescriptionDetailCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new CompoundPrescriptionDetailModel();
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
	it ('Renders the Compound Prescription Detail CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Consumption Unit relation.
	*
	* The button should only exist if consumptionUnitMultiCrudActive is true
	*/
	it ('Renders Consumption Unit Add Entity button in create mode', fakeAsync(() => {
		const consumptionUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.consumptionUnitDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!consumptionUnitButton).toEqual(component.consumptionUnitMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Consumption Unit', fakeAsync(() => {
		const consumptionUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.consumptionUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!consumptionUnitButton).toEqual(component.consumptionUnitMultiCrudActive);

		if (component.consumptionUnitMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialConsumptionUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.consumptionUnitDisplayName + ' from Model')).length;

			consumptionUnitButton.nativeElement.click();
			fixture.detectChanges();

			const actualConsumptionUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.consumptionUnitDisplayName + ' from Model')).length;

			expect(actualConsumptionUnitRemoveButtonCount).toEqual(initialConsumptionUnitRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Consumption Unit button', () => {
		const consumptionUnitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.consumptionUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!consumptionUnitButton).toEqual(component.consumptionUnitMultiCrudActive);

		if (component.consumptionUnitMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			consumptionUnitButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialConsumptionUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.consumptionUnitDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialConsumptionUnitRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualConsumptionUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.consumptionUnitDisplayName + ' from Model'));

			expect(actualConsumptionUnitRemoveButtons.length).toEqual(initialConsumptionUnitRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Consumption Unit button when one has already been added', () => {

		const consumptionUnitButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.consumptionUnitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!consumptionUnitButton).toEqual(component.consumptionUnitMultiCrudActive);

		if (component.consumptionUnitMultiCrudActive) {
			consumptionUnitButton.nativeElement.click();
			fixture.detectChanges();

			const updatedconsumptionUnitButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.consumptionUnitDisplayName + ' to Model'));

			expect(updatedconsumptionUnitButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Consumption Unit entities from model when loading in edit mode', () => {
		component.targetModel = compoundPrescriptionDetailWithId;
		component.targetModelId = compoundPrescriptionDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.consumptionUnitMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const consumptionUnitRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.consumptionUnitDisplayName + ' from Model')).length;

			expect(consumptionUnitRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Compound Prescription Items relation.
	*
	* The button should only exist if compoundPrescriptionItemsMultiCrudActive is true
	*/
	it ('Renders Compound Prescription Items Add Entity button in create mode', fakeAsync(() => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Compound Prescription Items', fakeAsync(() => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCompoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCompoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			expect(actualCompoundPrescriptionItemsRemoveButtonCount).toEqual(initialCompoundPrescriptionItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Compound Prescription Items button', () => {
		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCompoundPrescriptionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCompoundPrescriptionItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCompoundPrescriptionItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model'));

			expect(actualCompoundPrescriptionItemsRemoveButtons.length).toEqual(initialCompoundPrescriptionItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Compound Prescription Items button when one has already been added', () => {

		const compoundPrescriptionItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundPrescriptionItemsButton).toEqual(component.compoundPrescriptionItemsMultiCrudActive);

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			compoundPrescriptionItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcompoundPrescriptionItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundPrescriptionItemsDisplayName + ' to Model'));

			expect(updatedcompoundPrescriptionItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Compound Prescription Items entities from model when loading in edit mode', () => {
		component.targetModel = compoundPrescriptionDetailWithId;
		component.targetModelId = compoundPrescriptionDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.compoundPrescriptionItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const compoundPrescriptionItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundPrescriptionItemsDisplayName + ' from Model')).length;

			expect(compoundPrescriptionItemsRemoveButtonCount).toEqual(compoundPrescriptionDetailWithId.compoundPrescriptionItems.length);
		}
	});

});
