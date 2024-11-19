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
	getTariffSchemaCollectionModels,
	getCountTariffSchemaModels,
	getTariffSchemaModelWithId
} from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaCrudModule } from '../tariff-schema-crud.module';
import { TariffSchemaCrudEditComponent } from './tariff-schema-crud-edit.component';
import {
	TariffSchemaModelState,
	initialState as initialTariffSchemaModelState
} from 'src/app/models/tariffSchema/tariff_schema.model.state';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { CrudTileMode } from '../tariff-schema-crud.component';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
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
import { getInvoicePaymentInsuranceModelWithId } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { getInvoicePaymentInsuranceCollectionModels } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { InvoicePaymentInsuranceModel } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import { InvoicePaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/invoice-payment-insurance-data-factory';
import { getInvoicePaymentOtherModelWithId } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import { getInvoicePaymentOtherCollectionModels } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import { InvoicePaymentOtherModel } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model';
import { InvoicePaymentOtherDataFactory } from 'src/app/lib/utils/factories/invoice-payment-other-data-factory';
import { getInvoicePaymentSelfPayingModelWithId } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import { getInvoicePaymentSelfPayingCollectionModels } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import { InvoicePaymentSelfPayingModel } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model';
import { InvoicePaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/invoice-payment-self-paying-data-factory';
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
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRetailPharmacyInvoiceModelWithId } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { getRetailPharmacyInvoiceCollectionModels } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { RetailPharmacyInvoiceDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-invoice-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getTariffDefinitionModelWithId } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { getTariffDefinitionCollectionModels } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { TariffDefinitionDataFactory } from 'src/app/lib/utils/factories/tariff-definition-data-factory';
import { getTariffDefinitionOtherComponentModelWithId } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { getTariffDefinitionOtherComponentCollectionModels } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { TariffDefinitionOtherComponentModel } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model';
import { TariffDefinitionOtherComponentDataFactory } from 'src/app/lib/utils/factories/tariff-definition-other-component-data-factory';
import { getTariffFormulaModelWithId } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { getTariffFormulaCollectionModels } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { TariffFormulaModel } from 'src/app/models/tariffFormula/tariff_formula.model';
import { TariffFormulaDataFactory } from 'src/app/lib/utils/factories/tariff-formula-data-factory';

describe('Tariff Schema CRUD Edit component tests', () => {
	let fixture: ComponentFixture<TariffSchemaCrudEditComponent>
	let component: TariffSchemaCrudEditComponent;

	let tariffSchemaModelState: TariffSchemaModelState;

	let store: MockStore<{ model: TariffSchemaModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let tariffSchemaCountBehaviorSubject: BehaviorSubject<number>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoiceItemComponentModelsBehaviorSubject: BehaviorSubject<InvoiceItemComponentModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let invoicePaymentOtherModelsBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel[]>;
	let invoicePaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let tariffDefinitionModelsBehaviorSubject: BehaviorSubject<TariffDefinitionModel[]>;
	let tariffDefinitionOtherComponentModelsBehaviorSubject: BehaviorSubject<TariffDefinitionOtherComponentModel[]>;
	let tariffFormulaModelsBehaviorSubject: BehaviorSubject<TariffFormulaModel[]>;

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

	const invoiceItemComponentFactory: InvoiceItemComponentDataFactory = new InvoiceItemComponentDataFactory();
	const defaultInvoiceItemComponentCount: number = 10;
	const defaultInvoiceItemComponentEntities: InvoiceItemComponentModel[] = invoiceItemComponentFactory.createAll(defaultInvoiceItemComponentCount);

	const invoicePaymentInsuranceFactory: InvoicePaymentInsuranceDataFactory = new InvoicePaymentInsuranceDataFactory();
	const defaultInvoicePaymentInsuranceCount: number = 10;
	const defaultInvoicePaymentInsuranceEntities: InvoicePaymentInsuranceModel[] = invoicePaymentInsuranceFactory.createAll(defaultInvoicePaymentInsuranceCount);

	const invoicePaymentOtherFactory: InvoicePaymentOtherDataFactory = new InvoicePaymentOtherDataFactory();
	const defaultInvoicePaymentOtherCount: number = 10;
	const defaultInvoicePaymentOtherEntities: InvoicePaymentOtherModel[] = invoicePaymentOtherFactory.createAll(defaultInvoicePaymentOtherCount);

	const invoicePaymentSelfPayingFactory: InvoicePaymentSelfPayingDataFactory = new InvoicePaymentSelfPayingDataFactory();
	const defaultInvoicePaymentSelfPayingCount: number = 10;
	const defaultInvoicePaymentSelfPayingEntities: InvoicePaymentSelfPayingModel[] = invoicePaymentSelfPayingFactory.createAll(defaultInvoicePaymentSelfPayingCount);

	const invoiceSummaryFactory: InvoiceSummaryDataFactory = new InvoiceSummaryDataFactory();
	const defaultInvoiceSummaryCount: number = 10;
	const defaultInvoiceSummaryEntities: InvoiceSummaryModel[] = invoiceSummaryFactory.createAll(defaultInvoiceSummaryCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const tariffDefinitionFactory: TariffDefinitionDataFactory = new TariffDefinitionDataFactory();
	const defaultTariffDefinitionCount: number = 10;
	const defaultTariffDefinitionEntities: TariffDefinitionModel[] = tariffDefinitionFactory.createAll(defaultTariffDefinitionCount);

	const tariffDefinitionOtherComponentFactory: TariffDefinitionOtherComponentDataFactory = new TariffDefinitionOtherComponentDataFactory();
	const defaultTariffDefinitionOtherComponentCount: number = 10;
	const defaultTariffDefinitionOtherComponentEntities: TariffDefinitionOtherComponentModel[] = tariffDefinitionOtherComponentFactory.createAll(defaultTariffDefinitionOtherComponentCount);

	const tariffFormulaFactory: TariffFormulaDataFactory = new TariffFormulaDataFactory();
	const defaultTariffFormulaCount: number = 10;
	const defaultTariffFormulaEntities: TariffFormulaModel[] = tariffFormulaFactory.createAll(defaultTariffFormulaCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let tariffSchemaWithId: TariffSchemaModel = defaultTariffSchemaEntities[0];
	let tariffSchemaModelWithIdBehaviorSubject: BehaviorSubject<TariffSchemaModel>;

	tariffSchemaWithId.baseScheme = defaultTariffFormulaEntities;
	tariffSchemaWithId.baseSchemeIds = tariffSchemaWithId.baseScheme.map(baseScheme => baseScheme.id);

	tariffSchemaWithId.invoiceItems = defaultInvoiceItemEntities;
	tariffSchemaWithId.invoiceItemsIds = tariffSchemaWithId.invoiceItems.map(invoiceItems => invoiceItems.id);

	tariffSchemaWithId.invoices = defaultInvoiceEntities;
	tariffSchemaWithId.invoicesIds = tariffSchemaWithId.invoices.map(invoices => invoices.id);

	tariffSchemaWithId.tariffDefinitions = defaultTariffDefinitionEntities;
	tariffSchemaWithId.tariffDefinitionsIds = tariffSchemaWithId.tariffDefinitions.map(tariffDefinitions => tariffDefinitions.id);

	tariffSchemaWithId.tariffScheme = defaultTariffFormulaEntities;
	tariffSchemaWithId.tariffSchemeIds = tariffSchemaWithId.tariffScheme.map(tariffScheme => tariffScheme.id);


	const routerState: RouterState = {
		url: 'tariff-schema-crud',
		urls: ['tariff-schema-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: TariffSchemaModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		tariffSchemaModelState = initialTariffSchemaModelState;
		store.setState({model: tariffSchemaModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		tariffSchemaCountBehaviorSubject = new BehaviorSubject(defaultTariffSchemaCount);

		// selectors for all references
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoiceItemComponentModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemComponentEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		invoicePaymentOtherModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentOtherEntities);
		invoicePaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentSelfPayingEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		tariffDefinitionModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionEntities);
		tariffDefinitionOtherComponentModelsBehaviorSubject = new BehaviorSubject(defaultTariffDefinitionOtherComponentEntities);
		tariffFormulaModelsBehaviorSubject = new BehaviorSubject(defaultTariffFormulaEntities);

		// selectors for target entity and its related entity
		tariffSchemaModelWithIdBehaviorSubject = new BehaviorSubject(tariffSchemaWithId);

		spyOn(store, 'select')
			.withArgs(getCountTariffSchemaModels).and.returnValue(tariffSchemaCountBehaviorSubject)
			.withArgs(getTariffSchemaModelWithId, tariffSchemaWithId.id).and.returnValue(tariffSchemaModelWithIdBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoiceItemComponentCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemComponentModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentOtherModelsBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getTariffDefinitionCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionModelsBehaviorSubject)
			.withArgs(getTariffDefinitionOtherComponentCollectionModels, jasmine.any(String)).and.returnValue(tariffDefinitionOtherComponentModelsBehaviorSubject)
			.withArgs(getTariffFormulaCollectionModels, jasmine.any(String)).and.returnValue(tariffFormulaModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				TariffSchemaCrudModule,
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

			fixture = TestBed.createComponent(TariffSchemaCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new TariffSchemaModel();
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
	it ('Renders the Tariff Schema CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Base Scheme relation.
	*
	* The button should only exist if baseSchemeMultiCrudActive is true
	*/
	it ('Renders Base Scheme Add Entity button in create mode', fakeAsync(() => {
		const baseSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!baseSchemeButton).toEqual(component.baseSchemeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Base Scheme', fakeAsync(() => {
		const baseSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemeButton).toEqual(component.baseSchemeMultiCrudActive);

		if (component.baseSchemeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBaseSchemeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemeDisplayName + ' from Model')).length;

			baseSchemeButton.nativeElement.click();
			fixture.detectChanges();

			const actualBaseSchemeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemeDisplayName + ' from Model')).length;

			expect(actualBaseSchemeRemoveButtonCount).toEqual(initialBaseSchemeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Base Scheme button', () => {
		const baseSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemeButton).toEqual(component.baseSchemeMultiCrudActive);

		if (component.baseSchemeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			baseSchemeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBaseSchemeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBaseSchemeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBaseSchemeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemeDisplayName + ' from Model'));

			expect(actualBaseSchemeRemoveButtons.length).toEqual(initialBaseSchemeRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Base Scheme button when one has already been added', () => {

		const baseSchemeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!baseSchemeButton).toEqual(component.baseSchemeMultiCrudActive);

		if (component.baseSchemeMultiCrudActive) {
			baseSchemeButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbaseSchemeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.baseSchemeDisplayName + ' to Model'));

			expect(updatedbaseSchemeButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Base Scheme entities from model when loading in edit mode', () => {
		component.targetModel = tariffSchemaWithId;
		component.targetModelId = tariffSchemaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.baseSchemeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const baseSchemeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.baseSchemeDisplayName + ' from Model')).length;

			expect(baseSchemeRemoveButtonCount).toEqual(tariffSchemaWithId.baseScheme.length);
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
		component.targetModel = tariffSchemaWithId;
		component.targetModelId = tariffSchemaWithId.id;
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

			expect(invoiceItemsRemoveButtonCount).toEqual(tariffSchemaWithId.invoiceItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Invoices relation.
	*
	* The button should only exist if invoicesMultiCrudActive is true
	*/
	it ('Renders Invoices Add Entity button in create mode', fakeAsync(() => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Invoices', fakeAsync(() => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			expect(actualInvoicesRemoveButtonCount).toEqual(initialInvoicesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Invoices button', () => {
		const invoicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInvoicesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInvoicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model'));

			expect(actualInvoicesRemoveButtons.length).toEqual(initialInvoicesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Invoices button when one has already been added', () => {

		const invoicesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!invoicesButton).toEqual(component.invoicesMultiCrudActive);

		if (component.invoicesMultiCrudActive) {
			invoicesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinvoicesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.invoicesDisplayName + ' to Model'));

			expect(updatedinvoicesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Invoices entities from model when loading in edit mode', () => {
		component.targetModel = tariffSchemaWithId;
		component.targetModelId = tariffSchemaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.invoicesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const invoicesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.invoicesDisplayName + ' from Model')).length;

			expect(invoicesRemoveButtonCount).toEqual(tariffSchemaWithId.invoices.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Definitions relation.
	*
	* The button should only exist if tariffDefinitionsMultiCrudActive is true
	*/
	it ('Renders Tariff Definitions Add Entity button in create mode', fakeAsync(() => {
		const tariffDefinitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffDefinitionsButton).toEqual(component.tariffDefinitionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Definitions', fakeAsync(() => {
		const tariffDefinitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionsButton).toEqual(component.tariffDefinitionsMultiCrudActive);

		if (component.tariffDefinitionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffDefinitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionsDisplayName + ' from Model')).length;

			tariffDefinitionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffDefinitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionsDisplayName + ' from Model')).length;

			expect(actualTariffDefinitionsRemoveButtonCount).toEqual(initialTariffDefinitionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Definitions button', () => {
		const tariffDefinitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionsButton).toEqual(component.tariffDefinitionsMultiCrudActive);

		if (component.tariffDefinitionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffDefinitionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffDefinitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffDefinitionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffDefinitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionsDisplayName + ' from Model'));

			expect(actualTariffDefinitionsRemoveButtons.length).toEqual(initialTariffDefinitionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Tariff Definitions button when one has already been added', () => {

		const tariffDefinitionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffDefinitionsButton).toEqual(component.tariffDefinitionsMultiCrudActive);

		if (component.tariffDefinitionsMultiCrudActive) {
			tariffDefinitionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffDefinitionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffDefinitionsDisplayName + ' to Model'));

			expect(updatedtariffDefinitionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Tariff Definitions entities from model when loading in edit mode', () => {
		component.targetModel = tariffSchemaWithId;
		component.targetModelId = tariffSchemaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffDefinitionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffDefinitionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffDefinitionsDisplayName + ' from Model')).length;

			expect(tariffDefinitionsRemoveButtonCount).toEqual(tariffSchemaWithId.tariffDefinitions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Scheme relation.
	*
	* The button should only exist if tariffSchemeMultiCrudActive is true
	*/
	it ('Renders Tariff Scheme Add Entity button in create mode', fakeAsync(() => {
		const tariffSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemeDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffSchemeButton).toEqual(component.tariffSchemeMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Scheme', fakeAsync(() => {
		const tariffSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemeButton).toEqual(component.tariffSchemeMultiCrudActive);

		if (component.tariffSchemeMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffSchemeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemeDisplayName + ' from Model')).length;

			tariffSchemeButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemeRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemeDisplayName + ' from Model')).length;

			expect(actualTariffSchemeRemoveButtonCount).toEqual(initialTariffSchemeRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Scheme button', () => {
		const tariffSchemeButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemeButton).toEqual(component.tariffSchemeMultiCrudActive);

		if (component.tariffSchemeMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffSchemeButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffSchemeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemeDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffSchemeRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffSchemeRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemeDisplayName + ' from Model'));

			expect(actualTariffSchemeRemoveButtons.length).toEqual(initialTariffSchemeRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Tariff Scheme button when one has already been added', () => {

		const tariffSchemeButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemeDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffSchemeButton).toEqual(component.tariffSchemeMultiCrudActive);

		if (component.tariffSchemeMultiCrudActive) {
			tariffSchemeButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffSchemeButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffSchemeDisplayName + ' to Model'));

			expect(updatedtariffSchemeButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Tariff Scheme entities from model when loading in edit mode', () => {
		component.targetModel = tariffSchemaWithId;
		component.targetModelId = tariffSchemaWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffSchemeMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffSchemeRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffSchemeDisplayName + ' from Model')).length;

			expect(tariffSchemeRemoveButtonCount).toEqual(tariffSchemaWithId.tariffScheme.length);
		}
	});

});
