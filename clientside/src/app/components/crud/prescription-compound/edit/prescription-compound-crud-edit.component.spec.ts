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
	getPrescriptionCompoundCollectionModels,
	getCountPrescriptionCompoundModels,
	getPrescriptionCompoundModelWithId
} from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { PrescriptionCompoundCrudModule } from '../prescription-compound-crud.module';
import { PrescriptionCompoundCrudEditComponent } from './prescription-compound-crud-edit.component';
import {
	PrescriptionCompoundModelState,
	initialState as initialPrescriptionCompoundModelState
} from 'src/app/models/prescriptionCompound/prescription_compound.model.state';
import { PrescriptionCompoundDataFactory } from 'src/app/lib/utils/factories/prescription-compound-data-factory';
import { PrescriptionCompoundModel } from 'src/app/models/prescriptionCompound/prescription_compound.model';
import { CrudTileMode } from '../prescription-compound-crud.component';
import { getCatalogueUOMModelWithId } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { getCatalogueUOMCollectionModels } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { CatalogueUOMModel } from 'src/app/models/catalogueUOM/catalogue_uom.model';
import { CatalogueUOMDataFactory } from 'src/app/lib/utils/factories/catalogue-uom-data-factory';
import { getCompoundPrescriptionDetailModelWithId } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { getCompoundPrescriptionDetailCollectionModels } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { CompoundPrescriptionDetailModel } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model';
import { CompoundPrescriptionDetailDataFactory } from 'src/app/lib/utils/factories/compound-prescription-detail-data-factory';
import { getCompoundPrescriptionItemModelWithId } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { getCompoundPrescriptionItemCollectionModels } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { CompoundPrescriptionItemModel } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import { CompoundPrescriptionItemDataFactory } from 'src/app/lib/utils/factories/compound-prescription-item-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getMedicationCompoundModelWithId } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { getMedicationCompoundCollectionModels } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { MedicationCompoundModel } from 'src/app/models/medicationCompound/medication_compound.model';
import { MedicationCompoundDataFactory } from 'src/app/lib/utils/factories/medication-compound-data-factory';
import { getMedicationItemModelWithId } from 'src/app/models/medicationItem/medication_item.model.selector';
import { getMedicationItemCollectionModels } from 'src/app/models/medicationItem/medication_item.model.selector';
import { MedicationItemModel } from 'src/app/models/medicationItem/medication_item.model';
import { MedicationItemDataFactory } from 'src/app/lib/utils/factories/medication-item-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getPrescriptionItemModelWithId } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { getPrescriptionItemCollectionModels } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { PrescriptionItemModel } from 'src/app/models/prescriptionItem/prescription_item.model';
import { PrescriptionItemDataFactory } from 'src/app/lib/utils/factories/prescription-item-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getUnitOfMeasurementModelWithId } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { getUnitOfMeasurementCollectionModels } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { UnitOfMeasurementModel } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model';
import { UnitOfMeasurementDataFactory } from 'src/app/lib/utils/factories/unit-of-measurement-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';

describe('Prescription Compound CRUD Edit component tests', () => {
	let fixture: ComponentFixture<PrescriptionCompoundCrudEditComponent>
	let component: PrescriptionCompoundCrudEditComponent;

	let prescriptionCompoundModelState: PrescriptionCompoundModelState;

	let store: MockStore<{ model: PrescriptionCompoundModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let prescriptionCompoundCountBehaviorSubject: BehaviorSubject<number>;
	let prescriptionCompoundModelsBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel[]>;
	let catalogueUOMModelsBehaviorSubject: BehaviorSubject<CatalogueUOMModel[]>;
	let compoundPrescriptionDetailModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionDetailModel[]>;
	let compoundPrescriptionItemModelsBehaviorSubject: BehaviorSubject<CompoundPrescriptionItemModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let medicationCompoundModelsBehaviorSubject: BehaviorSubject<MedicationCompoundModel[]>;
	let medicationItemModelsBehaviorSubject: BehaviorSubject<MedicationItemModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let prescriptionItemModelsBehaviorSubject: BehaviorSubject<PrescriptionItemModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let unitOfMeasurementModelsBehaviorSubject: BehaviorSubject<UnitOfMeasurementModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;

	const prescriptionCompoundFactory: PrescriptionCompoundDataFactory = new PrescriptionCompoundDataFactory();
	const defaultPrescriptionCompoundCount: number = 10;
	const defaultPrescriptionCompoundEntities: PrescriptionCompoundModel[] = prescriptionCompoundFactory.createAll(defaultPrescriptionCompoundCount);

	const catalogueUOMFactory: CatalogueUOMDataFactory = new CatalogueUOMDataFactory();
	const defaultCatalogueUOMCount: number = 10;
	const defaultCatalogueUOMEntities: CatalogueUOMModel[] = catalogueUOMFactory.createAll(defaultCatalogueUOMCount);

	const compoundPrescriptionDetailFactory: CompoundPrescriptionDetailDataFactory = new CompoundPrescriptionDetailDataFactory();
	const defaultCompoundPrescriptionDetailCount: number = 10;
	const defaultCompoundPrescriptionDetailEntities: CompoundPrescriptionDetailModel[] = compoundPrescriptionDetailFactory.createAll(defaultCompoundPrescriptionDetailCount);

	const compoundPrescriptionItemFactory: CompoundPrescriptionItemDataFactory = new CompoundPrescriptionItemDataFactory();
	const defaultCompoundPrescriptionItemCount: number = 10;
	const defaultCompoundPrescriptionItemEntities: CompoundPrescriptionItemModel[] = compoundPrescriptionItemFactory.createAll(defaultCompoundPrescriptionItemCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const medicationCompoundFactory: MedicationCompoundDataFactory = new MedicationCompoundDataFactory();
	const defaultMedicationCompoundCount: number = 10;
	const defaultMedicationCompoundEntities: MedicationCompoundModel[] = medicationCompoundFactory.createAll(defaultMedicationCompoundCount);

	const medicationItemFactory: MedicationItemDataFactory = new MedicationItemDataFactory();
	const defaultMedicationItemCount: number = 10;
	const defaultMedicationItemEntities: MedicationItemModel[] = medicationItemFactory.createAll(defaultMedicationItemCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const prescriptionItemFactory: PrescriptionItemDataFactory = new PrescriptionItemDataFactory();
	const defaultPrescriptionItemCount: number = 10;
	const defaultPrescriptionItemEntities: PrescriptionItemModel[] = prescriptionItemFactory.createAll(defaultPrescriptionItemCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const unitOfMeasurementFactory: UnitOfMeasurementDataFactory = new UnitOfMeasurementDataFactory();
	const defaultUnitOfMeasurementCount: number = 10;
	const defaultUnitOfMeasurementEntities: UnitOfMeasurementModel[] = unitOfMeasurementFactory.createAll(defaultUnitOfMeasurementCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let prescriptionCompoundWithId: PrescriptionCompoundModel = defaultPrescriptionCompoundEntities[0];
	let prescriptionCompoundModelWithIdBehaviorSubject: BehaviorSubject<PrescriptionCompoundModel>;

	prescriptionCompoundWithId.unit = defaultUnitOfMeasurementEntities[0];
	prescriptionCompoundWithId.unitId = prescriptionCompoundWithId.unit.id;
	let unitWithIdBehaviorSubject: BehaviorSubject<UnitOfMeasurementModel>;

	prescriptionCompoundWithId.prescriptionHeader = defaultPrescriptionHeaderEntities[0];
	prescriptionCompoundWithId.prescriptionHeaderId = prescriptionCompoundWithId.prescriptionHeader.id;
	let prescriptionHeaderWithIdBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel>;

	prescriptionCompoundWithId.compoundItems = defaultPrescriptionItemEntities;
	prescriptionCompoundWithId.compoundItemsIds = prescriptionCompoundWithId.compoundItems.map(compoundItems => compoundItems.id);


	const routerState: RouterState = {
		url: 'prescription-compound-crud',
		urls: ['prescription-compound-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: PrescriptionCompoundModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		prescriptionCompoundModelState = initialPrescriptionCompoundModelState;
		store.setState({model: prescriptionCompoundModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		prescriptionCompoundCountBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundCount);

		// selectors for all references
		prescriptionCompoundModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionCompoundEntities);
		catalogueUOMModelsBehaviorSubject = new BehaviorSubject(defaultCatalogueUOMEntities);
		compoundPrescriptionDetailModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionDetailEntities);
		compoundPrescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultCompoundPrescriptionItemEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		medicationCompoundModelsBehaviorSubject = new BehaviorSubject(defaultMedicationCompoundEntities);
		medicationItemModelsBehaviorSubject = new BehaviorSubject(defaultMedicationItemEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		prescriptionItemModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionItemEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		unitOfMeasurementModelsBehaviorSubject = new BehaviorSubject(defaultUnitOfMeasurementEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);

		// selectors for target entity and its related entity
		prescriptionCompoundModelWithIdBehaviorSubject = new BehaviorSubject(prescriptionCompoundWithId);
		unitWithIdBehaviorSubject = new BehaviorSubject(prescriptionCompoundWithId.unit);
		prescriptionHeaderWithIdBehaviorSubject = new BehaviorSubject(prescriptionCompoundWithId.prescriptionHeader);

		spyOn(store, 'select')
			.withArgs(getCountPrescriptionCompoundModels).and.returnValue(prescriptionCompoundCountBehaviorSubject)
			.withArgs(getPrescriptionCompoundModelWithId, prescriptionCompoundWithId.id).and.returnValue(prescriptionCompoundModelWithIdBehaviorSubject)
			.withArgs(getPrescriptionCompoundCollectionModels, jasmine.any(String)).and.returnValue(prescriptionCompoundModelsBehaviorSubject)
			.withArgs(getCatalogueUOMCollectionModels, jasmine.any(String)).and.returnValue(catalogueUOMModelsBehaviorSubject)
			.withArgs(getCompoundPrescriptionDetailCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionDetailModelsBehaviorSubject)
			.withArgs(getCompoundPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(compoundPrescriptionItemModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getMedicationCompoundCollectionModels, jasmine.any(String)).and.returnValue(medicationCompoundModelsBehaviorSubject)
			.withArgs(getMedicationItemCollectionModels, jasmine.any(String)).and.returnValue(medicationItemModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getPrescriptionItemCollectionModels, jasmine.any(String)).and.returnValue(prescriptionItemModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getUnitOfMeasurementCollectionModels, jasmine.any(String)).and.returnValue(unitOfMeasurementModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getUnitOfMeasurementModelWithId, prescriptionCompoundWithId.unitId).and.returnValue(unitWithIdBehaviorSubject)
			.withArgs(getPrescriptionHeaderModelWithId, prescriptionCompoundWithId.prescriptionHeaderId).and.returnValue(prescriptionHeaderWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				PrescriptionCompoundCrudModule,
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

			fixture = TestBed.createComponent(PrescriptionCompoundCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new PrescriptionCompoundModel();
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
	it ('Renders the Prescription Compound CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Unit relation.
	*
	* The button should only exist if unitMultiCrudActive is true
	*/
	it ('Renders Unit Add Entity button in create mode', fakeAsync(() => {
		const unitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.unitDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!unitButton).toEqual(component.unitMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Unit', fakeAsync(() => {
		const unitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.unitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!unitButton).toEqual(component.unitMultiCrudActive);

		if (component.unitMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.unitDisplayName + ' from Model')).length;

			unitButton.nativeElement.click();
			fixture.detectChanges();

			const actualUnitRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.unitDisplayName + ' from Model')).length;

			expect(actualUnitRemoveButtonCount).toEqual(initialUnitRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Unit button', () => {
		const unitButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.unitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!unitButton).toEqual(component.unitMultiCrudActive);

		if (component.unitMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			unitButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.unitDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialUnitRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualUnitRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.unitDisplayName + ' from Model'));

			expect(actualUnitRemoveButtons.length).toEqual(initialUnitRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Unit button when one has already been added', () => {

		const unitButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.unitDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!unitButton).toEqual(component.unitMultiCrudActive);

		if (component.unitMultiCrudActive) {
			unitButton.nativeElement.click();
			fixture.detectChanges();

			const updatedunitButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.unitDisplayName + ' to Model'));

			expect(updatedunitButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Unit entities from model when loading in edit mode', () => {
		component.targetModel = prescriptionCompoundWithId;
		component.targetModelId = prescriptionCompoundWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.unitMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const unitRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.unitDisplayName + ' from Model')).length;

			expect(unitRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Prescription Header relation.
	*
	* The button should only exist if prescriptionHeaderMultiCrudActive is true
	*/
	it ('Renders Prescription Header Add Entity button in create mode', fakeAsync(() => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Prescription Header', fakeAsync(() => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrescriptionHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeaderRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			expect(actualPrescriptionHeaderRemoveButtonCount).toEqual(initialPrescriptionHeaderRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Prescription Header button', () => {
		const prescriptionHeaderButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrescriptionHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrescriptionHeaderRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrescriptionHeaderRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model'));

			expect(actualPrescriptionHeaderRemoveButtons.length).toEqual(initialPrescriptionHeaderRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Prescription Header button when one has already been added', () => {

		const prescriptionHeaderButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!prescriptionHeaderButton).toEqual(component.prescriptionHeaderMultiCrudActive);

		if (component.prescriptionHeaderMultiCrudActive) {
			prescriptionHeaderButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprescriptionHeaderButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.prescriptionHeaderDisplayName + ' to Model'));

			expect(updatedprescriptionHeaderButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Prescription Header entities from model when loading in edit mode', () => {
		component.targetModel = prescriptionCompoundWithId;
		component.targetModelId = prescriptionCompoundWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.prescriptionHeaderMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const prescriptionHeaderRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.prescriptionHeaderDisplayName + ' from Model')).length;

			expect(prescriptionHeaderRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Compound Items relation.
	*
	* The button should only exist if compoundItemsMultiCrudActive is true
	*/
	it ('Renders Compound Items Add Entity button in create mode', fakeAsync(() => {
		const compoundItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!compoundItemsButton).toEqual(component.compoundItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Compound Items', fakeAsync(() => {
		const compoundItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundItemsButton).toEqual(component.compoundItemsMultiCrudActive);

		if (component.compoundItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCompoundItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundItemsDisplayName + ' from Model')).length;

			compoundItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCompoundItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundItemsDisplayName + ' from Model')).length;

			expect(actualCompoundItemsRemoveButtonCount).toEqual(initialCompoundItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Compound Items button', () => {
		const compoundItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundItemsButton).toEqual(component.compoundItemsMultiCrudActive);

		if (component.compoundItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			compoundItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCompoundItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCompoundItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCompoundItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundItemsDisplayName + ' from Model'));

			expect(actualCompoundItemsRemoveButtons.length).toEqual(initialCompoundItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Compound Items button when one has already been added', () => {

		const compoundItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!compoundItemsButton).toEqual(component.compoundItemsMultiCrudActive);

		if (component.compoundItemsMultiCrudActive) {
			compoundItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcompoundItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.compoundItemsDisplayName + ' to Model'));

			expect(updatedcompoundItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Compound Items entities from model when loading in edit mode', () => {
		component.targetModel = prescriptionCompoundWithId;
		component.targetModelId = prescriptionCompoundWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.compoundItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const compoundItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.compoundItemsDisplayName + ' from Model')).length;

			expect(compoundItemsRemoveButtonCount).toEqual(prescriptionCompoundWithId.compoundItems.length);
		}
	});

});
