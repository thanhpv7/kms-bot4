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
	getRetailPharmacyInvoiceCollectionModels,
	getCountRetailPharmacyInvoiceModels,
	getRetailPharmacyInvoiceModelWithId
} from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyInvoiceCrudModule } from '../retail-pharmacy-invoice-crud.module';
import { RetailPharmacyInvoiceCrudEditComponent } from './retail-pharmacy-invoice-crud-edit.component';
import {
	RetailPharmacyInvoiceModelState,
	initialState as initialRetailPharmacyInvoiceModelState
} from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.state';
import { RetailPharmacyInvoiceDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-invoice-data-factory';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { CrudTileMode } from '../retail-pharmacy-invoice-crud.component';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
import { getInvoiceItemComponentModelWithId } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { getInvoiceItemComponentCollectionModels } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { InvoiceItemComponentModel } from 'src/app/models/invoiceItemComponent/invoice_item_component.model';
import { InvoiceItemComponentDataFactory } from 'src/app/lib/utils/factories/invoice-item-component-data-factory';
import { getInvoiceSummaryModelWithId } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { getInvoiceSummaryCollectionModels } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { InvoiceSummaryModel } from 'src/app/models/invoiceSummary/invoice_summary.model';
import { InvoiceSummaryDataFactory } from 'src/app/lib/utils/factories/invoice-summary-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getMerchantModelWithId } from 'src/app/models/merchant/merchant.model.selector';
import { getMerchantCollectionModels } from 'src/app/models/merchant/merchant.model.selector';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { MerchantDataFactory } from 'src/app/lib/utils/factories/merchant-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { getRetailPharmacyStockDetailModelWithId } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import { getRetailPharmacyStockDetailCollectionModels } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import { RetailPharmacyStockDetailModel } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import { RetailPharmacyStockDetailDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-stock-detail-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';

describe('Retail Pharmacy Invoice CRUD Edit component tests', () => {
	let fixture: ComponentFixture<RetailPharmacyInvoiceCrudEditComponent>
	let component: RetailPharmacyInvoiceCrudEditComponent;

	let retailPharmacyInvoiceModelState: RetailPharmacyInvoiceModelState;

	let store: MockStore<{ model: RetailPharmacyInvoiceModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let retailPharmacyInvoiceCountBehaviorSubject: BehaviorSubject<number>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceItemComponentModelsBehaviorSubject: BehaviorSubject<InvoiceItemComponentModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let merchantModelsBehaviorSubject: BehaviorSubject<MerchantModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let retailPharmacyStockDetailModelsBehaviorSubject: BehaviorSubject<RetailPharmacyStockDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceItemComponentFactory: InvoiceItemComponentDataFactory = new InvoiceItemComponentDataFactory();
	const defaultInvoiceItemComponentCount: number = 10;
	const defaultInvoiceItemComponentEntities: InvoiceItemComponentModel[] = invoiceItemComponentFactory.createAll(defaultInvoiceItemComponentCount);

	const invoiceSummaryFactory: InvoiceSummaryDataFactory = new InvoiceSummaryDataFactory();
	const defaultInvoiceSummaryCount: number = 10;
	const defaultInvoiceSummaryEntities: InvoiceSummaryModel[] = invoiceSummaryFactory.createAll(defaultInvoiceSummaryCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const merchantFactory: MerchantDataFactory = new MerchantDataFactory();
	const defaultMerchantCount: number = 10;
	const defaultMerchantEntities: MerchantModel[] = merchantFactory.createAll(defaultMerchantCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const retailPharmacyStockDetailFactory: RetailPharmacyStockDetailDataFactory = new RetailPharmacyStockDetailDataFactory();
	const defaultRetailPharmacyStockDetailCount: number = 10;
	const defaultRetailPharmacyStockDetailEntities: RetailPharmacyStockDetailModel[] = retailPharmacyStockDetailFactory.createAll(defaultRetailPharmacyStockDetailCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let retailPharmacyInvoiceWithId: RetailPharmacyInvoiceModel = defaultRetailPharmacyInvoiceEntities[0];
	let retailPharmacyInvoiceModelWithIdBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel>;

	retailPharmacyInvoiceWithId.invoiceSummary = defaultInvoiceSummaryEntities[0];
	retailPharmacyInvoiceWithId.invoiceSummaryId = retailPharmacyInvoiceWithId.invoiceSummary.id;
	let invoiceSummaryWithIdBehaviorSubject: BehaviorSubject<InvoiceSummaryModel>;

	retailPharmacyInvoiceWithId.retailPharmacy = defaultRetailPharmacyEntities[0];
	retailPharmacyInvoiceWithId.retailPharmacyId = retailPharmacyInvoiceWithId.retailPharmacy.id;
	let retailPharmacyWithIdBehaviorSubject: BehaviorSubject<RetailPharmacyModel>;

	retailPharmacyInvoiceWithId.cashReceipts = defaultCashReceiptEntities;
	retailPharmacyInvoiceWithId.cashReceiptsIds = retailPharmacyInvoiceWithId.cashReceipts.map(cashReceipts => cashReceipts.id);

	retailPharmacyInvoiceWithId.invoiceItems = defaultInvoiceItemEntities;
	retailPharmacyInvoiceWithId.invoiceItemsIds = retailPharmacyInvoiceWithId.invoiceItems.map(invoiceItems => invoiceItems.id);


	const routerState: RouterState = {
		url: 'retail-pharmacy-invoice-crud',
		urls: ['retail-pharmacy-invoice-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: RetailPharmacyInvoiceModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		retailPharmacyInvoiceModelState = initialRetailPharmacyInvoiceModelState;
		store.setState({model: retailPharmacyInvoiceModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		retailPharmacyInvoiceCountBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceCount);

		// selectors for all references
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemComponentEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		merchantModelsBehaviorSubject = new BehaviorSubject(defaultMerchantEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		retailPharmacyStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyStockDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);

		// selectors for target entity and its related entity
		retailPharmacyInvoiceModelWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyInvoiceWithId);
		invoiceSummaryWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyInvoiceWithId.invoiceSummary);
		retailPharmacyWithIdBehaviorSubject = new BehaviorSubject(retailPharmacyInvoiceWithId.retailPharmacy);

		spyOn(store, 'select')
			.withArgs(getCountRetailPharmacyInvoiceModels).and.returnValue(retailPharmacyInvoiceCountBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceModelWithId, retailPharmacyInvoiceWithId.id).and.returnValue(retailPharmacyInvoiceModelWithIdBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceItemComponentCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemComponentModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getMerchantCollectionModels, jasmine.any(String)).and.returnValue(merchantModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getRetailPharmacyStockDetailCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyStockDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryModelWithId, retailPharmacyInvoiceWithId.invoiceSummaryId).and.returnValue(invoiceSummaryWithIdBehaviorSubject)
			.withArgs(getRetailPharmacyModelWithId, retailPharmacyInvoiceWithId.retailPharmacyId).and.returnValue(retailPharmacyWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				RetailPharmacyInvoiceCrudModule,
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

			fixture = TestBed.createComponent(RetailPharmacyInvoiceCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new RetailPharmacyInvoiceModel();
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
	it ('Renders the Retail Pharmacy Invoice CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Invoice Summary relation.
	*
	* The button should only exist if invoiceSummaryMultiCrudActive is true
	*/
	it ('Renders Invoice Summary Add Entity button in create mode', fakeAsync(() => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Summary', fakeAsync(() => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceSummaryRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			expect(actualInvoiceSummaryRemoveButtonCount).toEqual(initialInvoiceSummaryRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Summary button', () => {
		const invoiceSummaryButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceSummaryRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceSummaryRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model'));

			expect(actualInvoiceSummaryRemoveButtons.length).toEqual(initialInvoiceSummaryRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Invoice Summary button when one has already been added', () => {

		const invoiceSummaryButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceSummaryButton).toEqual(component.invoiceSummaryMultiCrudActive);

		if (component.invoiceSummaryMultiCrudActive) {
			invoiceSummaryButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceSummaryButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceSummaryDisplayName + ' to Model'));

			expect(updatedinvoiceSummaryButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Invoice Summary entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyInvoiceWithId;
		component.targetModelId = retailPharmacyInvoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceSummaryMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceSummaryRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceSummaryDisplayName + ' from Model')).length;

			expect(invoiceSummaryRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Retail Pharmacy relation.
	*
	* The button should only exist if retailPharmacyMultiCrudActive is true
	*/
	it ('Renders Retail Pharmacy Add Entity button in create mode', fakeAsync(() => {
		const retailPharmacyButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!retailPharmacyButton).toEqual(component.retailPharmacyMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Retail Pharmacy', fakeAsync(() => {
		const retailPharmacyButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyButton).toEqual(component.retailPharmacyMultiCrudActive);

		if (component.retailPharmacyMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRetailPharmacyRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyDisplayName + ' from Model')).length;

			retailPharmacyButton.nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyDisplayName + ' from Model')).length;

			expect(actualRetailPharmacyRemoveButtonCount).toEqual(initialRetailPharmacyRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Retail Pharmacy button', () => {
		const retailPharmacyButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyButton).toEqual(component.retailPharmacyMultiCrudActive);

		if (component.retailPharmacyMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			retailPharmacyButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRetailPharmacyRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRetailPharmacyRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRetailPharmacyRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyDisplayName + ' from Model'));

			expect(actualRetailPharmacyRemoveButtons.length).toEqual(initialRetailPharmacyRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Retail Pharmacy button when one has already been added', () => {

		const retailPharmacyButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!retailPharmacyButton).toEqual(component.retailPharmacyMultiCrudActive);

		if (component.retailPharmacyMultiCrudActive) {
			retailPharmacyButton.nativeElement.click();
			fixture.detectChanges();

			const updatedretailPharmacyButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.retailPharmacyDisplayName + ' to Model'));

			expect(updatedretailPharmacyButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Retail Pharmacy entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyInvoiceWithId;
		component.targetModelId = retailPharmacyInvoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.retailPharmacyMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const retailPharmacyRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.retailPharmacyDisplayName + ' from Model')).length;

			expect(retailPharmacyRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Cash Receipts relation.
	*
	* The button should only exist if cashReceiptsMultiCrudActive is true
	*/
	it ('Renders Cash Receipts Add Entity button in create mode', fakeAsync(() => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Cash Receipts', fakeAsync(() => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCashReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCashReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			expect(actualCashReceiptsRemoveButtonCount).toEqual(initialCashReceiptsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Cash Receipts button', () => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCashReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCashReceiptsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCashReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model'));

			expect(actualCashReceiptsRemoveButtons.length).toEqual(initialCashReceiptsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Cash Receipts button when one has already been added', () => {

		const cashReceiptsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcashReceiptsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

			expect(updatedcashReceiptsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Cash Receipts entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyInvoiceWithId;
		component.targetModelId = retailPharmacyInvoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cashReceiptsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cashReceiptsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			expect(cashReceiptsRemoveButtonCount).toEqual(retailPharmacyInvoiceWithId.cashReceipts.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoice Items relation.
	*
	* The button should only exist if invoiceItemsMultiCrudActive is true
	*/
	it ('Renders Invoice Items Add Entity button in create mode', fakeAsync(() => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoice Items', fakeAsync(() => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoiceItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			expect(actualInvoiceItemsRemoveButtonCount).toEqual(initialInvoiceItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoice Items button', () => {
		const invoiceItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoiceItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoiceItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoiceItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model'));

			expect(actualInvoiceItemsRemoveButtons.length).toEqual(initialInvoiceItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoice Items button when one has already been added', () => {

		const invoiceItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoiceItemsButton).toEqual(component.invoiceItemsMultiCrudActive);

		if (component.invoiceItemsMultiCrudActive) {
			invoiceItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoiceItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoiceItemsDisplayName + ' to Model'));

			expect(updatedinvoiceItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoice Items entities from model when loading in edit mode', () => {
		component.targetModel = retailPharmacyInvoiceWithId;
		component.targetModelId = retailPharmacyInvoiceWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoiceItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoiceItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoiceItemsDisplayName + ' from Model')).length;

			expect(invoiceItemsRemoveButtonCount).toEqual(retailPharmacyInvoiceWithId.invoiceItems.length);
		}
	});

});
