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
	getBedFacilityCollectionModels,
	getCountBedFacilityModels,
	getBedFacilityModelWithId
} from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityCrudModule } from '../bed-facility-crud.module';
import { BedFacilityCrudEditComponent } from './bed-facility-crud-edit.component';
import {
	BedFacilityModelState,
	initialState as initialBedFacilityModelState
} from 'src/app/models/bedFacility/bed_facility.model.state';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { CrudTileMode } from '../bed-facility-crud.component';
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
import { getCoTreatingDoctorModelWithId } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { getCoTreatingDoctorCollectionModels } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { CoTreatingDoctorModel } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import { CoTreatingDoctorDataFactory } from 'src/app/lib/utils/factories/co-treating-doctor-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { getDiagnosticExaminationResultsModelWithId } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsDataFactory } from 'src/app/lib/utils/factories/diagnostic-examination-results-data-factory';
import { getDiagnosticStaffExaminationSummaryModelWithId } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { getDiagnosticStaffExaminationSummaryCollectionModels } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { DiagnosticStaffExaminationSummaryModel } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import { DiagnosticStaffExaminationSummaryDataFactory } from 'src/app/lib/utils/factories/diagnostic-staff-examination-summary-data-factory';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getFluidBalanceDetailModelWithId } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { getFluidBalanceDetailCollectionModels } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { FluidBalanceDetailDataFactory } from 'src/app/lib/utils/factories/fluid-balance-detail-data-factory';
import { getHealthFacilityModelWithId } from 'src/app/models/healthFacility/health_facility.model.selector';
import { getHealthFacilityCollectionModels } from 'src/app/models/healthFacility/health_facility.model.selector';
import { HealthFacilityModel } from 'src/app/models/healthFacility/health_facility.model';
import { HealthFacilityDataFactory } from 'src/app/lib/utils/factories/health-facility-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getInpatientMedicalExaminationRecordModelWithId } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/inpatient-medical-examination-record-data-factory';
import { getIntraoperativeRecordsModelWithId } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { getIntraoperativeRecordsCollectionModels } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { IntraoperativeRecordsModel } from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import { IntraoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/intraoperative-records-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
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
import { getMedicalCertificateDischargeResumeModelWithId } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { getMedicalCertificateDischargeResumeCollectionModels } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { MedicalCertificateDischargeResumeModel } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import { MedicalCertificateDischargeResumeDataFactory } from 'src/app/lib/utils/factories/medical-certificate-discharge-resume-data-factory';
import { getMedicalCertificateBirthModelWithId } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import { getMedicalCertificateBirthCollectionModels } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import { MedicalCertificateBirthModel } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import { MedicalCertificateBirthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-birth-data-factory';
import { getMedicalCertificateHospitalizationModelWithId } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import { getMedicalCertificateHospitalizationCollectionModels } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import { MedicalCertificateHospitalizationModel } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import { MedicalCertificateHospitalizationDataFactory } from 'src/app/lib/utils/factories/medical-certificate-hospitalization-data-factory';
import { getMedicalCertificateMedicalAttendanceModelWithId } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import { getMedicalCertificateMedicalAttendanceCollectionModels } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import { MedicalCertificateMedicalAttendanceModel } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import { MedicalCertificateMedicalAttendanceDataFactory } from 'src/app/lib/utils/factories/medical-certificate-medical-attendance-data-factory';
import { getMedicalCertificateMentalHealthModelWithId } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import { getMedicalCertificateMentalHealthCollectionModels } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import { MedicalCertificateMentalHealthModel } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import { MedicalCertificateMentalHealthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-mental-health-data-factory';
import { getMedicalCertificatePhysicalHealthModelWithId } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import { getMedicalCertificatePhysicalHealthCollectionModels } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import { MedicalCertificatePhysicalHealthModel } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import { MedicalCertificatePhysicalHealthDataFactory } from 'src/app/lib/utils/factories/medical-certificate-physical-health-data-factory';
import { getMedicalCertificateRestrictedWorkModelWithId } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import { getMedicalCertificateRestrictedWorkCollectionModels } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import { MedicalCertificateRestrictedWorkModel } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import { MedicalCertificateRestrictedWorkDataFactory } from 'src/app/lib/utils/factories/medical-certificate-restricted-work-data-factory';
import { getMedicalCertificateSickLeaveModelWithId } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import { getMedicalCertificateSickLeaveCollectionModels } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import { MedicalCertificateSickLeaveModel } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import { MedicalCertificateSickLeaveDataFactory } from 'src/app/lib/utils/factories/medical-certificate-sick-leave-data-factory';
import { getMedicalExaminationRecordModelWithId } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { getMedicalExaminationRecordCollectionModels } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { MedicalExaminationRecordModel } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import { MedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/medical-examination-record-data-factory';
import { getMedicalFeeModelWithId } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeDataFactory } from 'src/app/lib/utils/factories/medical-fee-data-factory';
import { getMedicationHeaderModelWithId } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderDataFactory } from 'src/app/lib/utils/factories/medication-header-data-factory';
import { getOperatingTheaterMedicalExaminationRecordModelWithId } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/operating-theater-medical-examination-record-data-factory';
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPatientVitalInformationModelWithId } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationDataFactory } from 'src/app/lib/utils/factories/patient-vital-information-data-factory';
import { getPostOperativeDetailsModelWithId } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsDataFactory } from 'src/app/lib/utils/factories/post-operative-details-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getRoomFacilityModelWithId } from 'src/app/models/roomFacility/room_facility.model.selector';
import { getRoomFacilityCollectionModels } from 'src/app/models/roomFacility/room_facility.model.selector';
import { RoomFacilityModel } from 'src/app/models/roomFacility/room_facility.model';
import { RoomFacilityDataFactory } from 'src/app/lib/utils/factories/room-facility-data-factory';
import { getRoomTransferModelWithId } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { getRoomTransferCollectionModels } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { RoomTransferModel } from 'src/app/models/roomTransfer/room_transfer.model';
import { RoomTransferDataFactory } from 'src/app/lib/utils/factories/room-transfer-data-factory';
import { getSepModelWithId } from 'src/app/models/sep/sep.model.selector';
import { getSepCollectionModels } from 'src/app/models/sep/sep.model.selector';
import { SepModel } from 'src/app/models/sep/sep.model';
import { SepDataFactory } from 'src/app/lib/utils/factories/sep-data-factory';
import { getSampleCollectionInformationModelWithId } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { getSampleCollectionInformationCollectionModels } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { SampleCollectionInformationModel } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import { SampleCollectionInformationDataFactory } from 'src/app/lib/utils/factories/sample-collection-information-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getTariffSchemaModelWithId } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaDataFactory } from 'src/app/lib/utils/factories/tariff-schema-data-factory';
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';

describe('Bed Facility CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BedFacilityCrudEditComponent>
	let component: BedFacilityCrudEditComponent;

	let bedFacilityModelState: BedFacilityModelState;

	let store: MockStore<{ model: BedFacilityModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bedFacilityCountBehaviorSubject: BehaviorSubject<number>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let coTreatingDoctorModelsBehaviorSubject: BehaviorSubject<CoTreatingDoctorModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let inpatientMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<InpatientMedicalExaminationRecordModel[]>;
	let intraoperativeRecordsModelsBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
	let invoicePaymentInsuranceModelsBehaviorSubject: BehaviorSubject<InvoicePaymentInsuranceModel[]>;
	let invoicePaymentOtherModelsBehaviorSubject: BehaviorSubject<InvoicePaymentOtherModel[]>;
	let invoicePaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<InvoicePaymentSelfPayingModel[]>;
	let invoiceSummaryModelsBehaviorSubject: BehaviorSubject<InvoiceSummaryModel[]>;
	let medicalCertificateDischargeResumeModelsBehaviorSubject: BehaviorSubject<MedicalCertificateDischargeResumeModel[]>;
	let medicalCertificateBirthModelsBehaviorSubject: BehaviorSubject<MedicalCertificateBirthModel[]>;
	let medicalCertificateHospitalizationModelsBehaviorSubject: BehaviorSubject<MedicalCertificateHospitalizationModel[]>;
	let medicalCertificateMedicalAttendanceModelsBehaviorSubject: BehaviorSubject<MedicalCertificateMedicalAttendanceModel[]>;
	let medicalCertificateMentalHealthModelsBehaviorSubject: BehaviorSubject<MedicalCertificateMentalHealthModel[]>;
	let medicalCertificatePhysicalHealthModelsBehaviorSubject: BehaviorSubject<MedicalCertificatePhysicalHealthModel[]>;
	let medicalCertificateRestrictedWorkModelsBehaviorSubject: BehaviorSubject<MedicalCertificateRestrictedWorkModel[]>;
	let medicalCertificateSickLeaveModelsBehaviorSubject: BehaviorSubject<MedicalCertificateSickLeaveModel[]>;
	let medicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<MedicalExaminationRecordModel[]>;
	let medicalFeeModelsBehaviorSubject: BehaviorSubject<MedicalFeeModel[]>;
	let medicationHeaderModelsBehaviorSubject: BehaviorSubject<MedicationHeaderModel[]>;
	let operatingTheaterMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<OperatingTheaterMedicalExaminationRecordModel[]>;
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let postOperativeDetailsModelsBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let roomFacilityModelsBehaviorSubject: BehaviorSubject<RoomFacilityModel[]>;
	let roomTransferModelsBehaviorSubject: BehaviorSubject<RoomTransferModel[]>;
	let sepModelsBehaviorSubject: BehaviorSubject<SepModel[]>;
	let sampleCollectionInformationModelsBehaviorSubject: BehaviorSubject<SampleCollectionInformationModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let tariffSchemaModelsBehaviorSubject: BehaviorSubject<TariffSchemaModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

	const coTreatingDoctorFactory: CoTreatingDoctorDataFactory = new CoTreatingDoctorDataFactory();
	const defaultCoTreatingDoctorCount: number = 10;
	const defaultCoTreatingDoctorEntities: CoTreatingDoctorModel[] = coTreatingDoctorFactory.createAll(defaultCoTreatingDoctorCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const diagnosticExaminationResultsFactory: DiagnosticExaminationResultsDataFactory = new DiagnosticExaminationResultsDataFactory();
	const defaultDiagnosticExaminationResultsCount: number = 10;
	const defaultDiagnosticExaminationResultsEntities: DiagnosticExaminationResultsModel[] = diagnosticExaminationResultsFactory.createAll(defaultDiagnosticExaminationResultsCount);

	const diagnosticStaffExaminationSummaryFactory: DiagnosticStaffExaminationSummaryDataFactory = new DiagnosticStaffExaminationSummaryDataFactory();
	const defaultDiagnosticStaffExaminationSummaryCount: number = 10;
	const defaultDiagnosticStaffExaminationSummaryEntities: DiagnosticStaffExaminationSummaryModel[] = diagnosticStaffExaminationSummaryFactory.createAll(defaultDiagnosticStaffExaminationSummaryCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const fluidBalanceDetailFactory: FluidBalanceDetailDataFactory = new FluidBalanceDetailDataFactory();
	const defaultFluidBalanceDetailCount: number = 10;
	const defaultFluidBalanceDetailEntities: FluidBalanceDetailModel[] = fluidBalanceDetailFactory.createAll(defaultFluidBalanceDetailCount);

	const healthFacilityFactory: HealthFacilityDataFactory = new HealthFacilityDataFactory();
	const defaultHealthFacilityCount: number = 10;
	const defaultHealthFacilityEntities: HealthFacilityModel[] = healthFacilityFactory.createAll(defaultHealthFacilityCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const inpatientMedicalExaminationRecordFactory: InpatientMedicalExaminationRecordDataFactory = new InpatientMedicalExaminationRecordDataFactory();
	const defaultInpatientMedicalExaminationRecordCount: number = 10;
	const defaultInpatientMedicalExaminationRecordEntities: InpatientMedicalExaminationRecordModel[] = inpatientMedicalExaminationRecordFactory.createAll(defaultInpatientMedicalExaminationRecordCount);

	const intraoperativeRecordsFactory: IntraoperativeRecordsDataFactory = new IntraoperativeRecordsDataFactory();
	const defaultIntraoperativeRecordsCount: number = 10;
	const defaultIntraoperativeRecordsEntities: IntraoperativeRecordsModel[] = intraoperativeRecordsFactory.createAll(defaultIntraoperativeRecordsCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

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

	const medicalCertificateDischargeResumeFactory: MedicalCertificateDischargeResumeDataFactory = new MedicalCertificateDischargeResumeDataFactory();
	const defaultMedicalCertificateDischargeResumeCount: number = 10;
	const defaultMedicalCertificateDischargeResumeEntities: MedicalCertificateDischargeResumeModel[] = medicalCertificateDischargeResumeFactory.createAll(defaultMedicalCertificateDischargeResumeCount);

	const medicalCertificateBirthFactory: MedicalCertificateBirthDataFactory = new MedicalCertificateBirthDataFactory();
	const defaultMedicalCertificateBirthCount: number = 10;
	const defaultMedicalCertificateBirthEntities: MedicalCertificateBirthModel[] = medicalCertificateBirthFactory.createAll(defaultMedicalCertificateBirthCount);

	const medicalCertificateHospitalizationFactory: MedicalCertificateHospitalizationDataFactory = new MedicalCertificateHospitalizationDataFactory();
	const defaultMedicalCertificateHospitalizationCount: number = 10;
	const defaultMedicalCertificateHospitalizationEntities: MedicalCertificateHospitalizationModel[] = medicalCertificateHospitalizationFactory.createAll(defaultMedicalCertificateHospitalizationCount);

	const medicalCertificateMedicalAttendanceFactory: MedicalCertificateMedicalAttendanceDataFactory = new MedicalCertificateMedicalAttendanceDataFactory();
	const defaultMedicalCertificateMedicalAttendanceCount: number = 10;
	const defaultMedicalCertificateMedicalAttendanceEntities: MedicalCertificateMedicalAttendanceModel[] = medicalCertificateMedicalAttendanceFactory.createAll(defaultMedicalCertificateMedicalAttendanceCount);

	const medicalCertificateMentalHealthFactory: MedicalCertificateMentalHealthDataFactory = new MedicalCertificateMentalHealthDataFactory();
	const defaultMedicalCertificateMentalHealthCount: number = 10;
	const defaultMedicalCertificateMentalHealthEntities: MedicalCertificateMentalHealthModel[] = medicalCertificateMentalHealthFactory.createAll(defaultMedicalCertificateMentalHealthCount);

	const medicalCertificatePhysicalHealthFactory: MedicalCertificatePhysicalHealthDataFactory = new MedicalCertificatePhysicalHealthDataFactory();
	const defaultMedicalCertificatePhysicalHealthCount: number = 10;
	const defaultMedicalCertificatePhysicalHealthEntities: MedicalCertificatePhysicalHealthModel[] = medicalCertificatePhysicalHealthFactory.createAll(defaultMedicalCertificatePhysicalHealthCount);

	const medicalCertificateRestrictedWorkFactory: MedicalCertificateRestrictedWorkDataFactory = new MedicalCertificateRestrictedWorkDataFactory();
	const defaultMedicalCertificateRestrictedWorkCount: number = 10;
	const defaultMedicalCertificateRestrictedWorkEntities: MedicalCertificateRestrictedWorkModel[] = medicalCertificateRestrictedWorkFactory.createAll(defaultMedicalCertificateRestrictedWorkCount);

	const medicalCertificateSickLeaveFactory: MedicalCertificateSickLeaveDataFactory = new MedicalCertificateSickLeaveDataFactory();
	const defaultMedicalCertificateSickLeaveCount: number = 10;
	const defaultMedicalCertificateSickLeaveEntities: MedicalCertificateSickLeaveModel[] = medicalCertificateSickLeaveFactory.createAll(defaultMedicalCertificateSickLeaveCount);

	const medicalExaminationRecordFactory: MedicalExaminationRecordDataFactory = new MedicalExaminationRecordDataFactory();
	const defaultMedicalExaminationRecordCount: number = 10;
	const defaultMedicalExaminationRecordEntities: MedicalExaminationRecordModel[] = medicalExaminationRecordFactory.createAll(defaultMedicalExaminationRecordCount);

	const medicalFeeFactory: MedicalFeeDataFactory = new MedicalFeeDataFactory();
	const defaultMedicalFeeCount: number = 10;
	const defaultMedicalFeeEntities: MedicalFeeModel[] = medicalFeeFactory.createAll(defaultMedicalFeeCount);

	const medicationHeaderFactory: MedicationHeaderDataFactory = new MedicationHeaderDataFactory();
	const defaultMedicationHeaderCount: number = 10;
	const defaultMedicationHeaderEntities: MedicationHeaderModel[] = medicationHeaderFactory.createAll(defaultMedicationHeaderCount);

	const operatingTheaterMedicalExaminationRecordFactory: OperatingTheaterMedicalExaminationRecordDataFactory = new OperatingTheaterMedicalExaminationRecordDataFactory();
	const defaultOperatingTheaterMedicalExaminationRecordCount: number = 10;
	const defaultOperatingTheaterMedicalExaminationRecordEntities: OperatingTheaterMedicalExaminationRecordModel[] = operatingTheaterMedicalExaminationRecordFactory.createAll(defaultOperatingTheaterMedicalExaminationRecordCount);

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const patientVitalInformationFactory: PatientVitalInformationDataFactory = new PatientVitalInformationDataFactory();
	const defaultPatientVitalInformationCount: number = 10;
	const defaultPatientVitalInformationEntities: PatientVitalInformationModel[] = patientVitalInformationFactory.createAll(defaultPatientVitalInformationCount);

	const postOperativeDetailsFactory: PostOperativeDetailsDataFactory = new PostOperativeDetailsDataFactory();
	const defaultPostOperativeDetailsCount: number = 10;
	const defaultPostOperativeDetailsEntities: PostOperativeDetailsModel[] = postOperativeDetailsFactory.createAll(defaultPostOperativeDetailsCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const roomFacilityFactory: RoomFacilityDataFactory = new RoomFacilityDataFactory();
	const defaultRoomFacilityCount: number = 10;
	const defaultRoomFacilityEntities: RoomFacilityModel[] = roomFacilityFactory.createAll(defaultRoomFacilityCount);

	const roomTransferFactory: RoomTransferDataFactory = new RoomTransferDataFactory();
	const defaultRoomTransferCount: number = 10;
	const defaultRoomTransferEntities: RoomTransferModel[] = roomTransferFactory.createAll(defaultRoomTransferCount);

	const sepFactory: SepDataFactory = new SepDataFactory();
	const defaultSepCount: number = 10;
	const defaultSepEntities: SepModel[] = sepFactory.createAll(defaultSepCount);

	const sampleCollectionInformationFactory: SampleCollectionInformationDataFactory = new SampleCollectionInformationDataFactory();
	const defaultSampleCollectionInformationCount: number = 10;
	const defaultSampleCollectionInformationEntities: SampleCollectionInformationModel[] = sampleCollectionInformationFactory.createAll(defaultSampleCollectionInformationCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const tariffSchemaFactory: TariffSchemaDataFactory = new TariffSchemaDataFactory();
	const defaultTariffSchemaCount: number = 10;
	const defaultTariffSchemaEntities: TariffSchemaModel[] = tariffSchemaFactory.createAll(defaultTariffSchemaCount);

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bedFacilityWithId: BedFacilityModel = defaultBedFacilityEntities[0];
	let bedFacilityModelWithIdBehaviorSubject: BehaviorSubject<BedFacilityModel>;

	bedFacilityWithId.intraoperativeRecords = defaultIntraoperativeRecordsEntities[0];
	bedFacilityWithId.intraoperativeRecordsId = bedFacilityWithId.intraoperativeRecords.id;
	let intraoperativeRecordsWithIdBehaviorSubject: BehaviorSubject<IntraoperativeRecordsModel>;

	bedFacilityWithId.postOperativeDetails = defaultPostOperativeDetailsEntities[0];
	bedFacilityWithId.postOperativeDetailsId = bedFacilityWithId.postOperativeDetails.id;
	let postOperativeDetailsWithIdBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel>;

	bedFacilityWithId.preoperativeRecords = defaultPreoperativeRecordsEntities[0];
	bedFacilityWithId.preoperativeRecordsId = bedFacilityWithId.preoperativeRecords.id;
	let preoperativeRecordsWithIdBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel>;

	bedFacilityWithId.roomFacility = defaultRoomFacilityEntities[0];
	bedFacilityWithId.roomFacilityId = bedFacilityWithId.roomFacility.id;
	let roomFacilityWithIdBehaviorSubject: BehaviorSubject<RoomFacilityModel>;

	bedFacilityWithId.bedReserves = defaultBedReserveEntities;
	bedFacilityWithId.bedReservesIds = bedFacilityWithId.bedReserves.map(bedReserves => bedReserves.id);

	bedFacilityWithId.inpatientMedicalExaminationRecords = defaultInpatientMedicalExaminationRecordEntities;
	bedFacilityWithId.inpatientMedicalExaminationRecordsIds = bedFacilityWithId.inpatientMedicalExaminationRecords.map(inpatientMedicalExaminationRecords => inpatientMedicalExaminationRecords.id);

	bedFacilityWithId.invoices = defaultInvoiceEntities;
	bedFacilityWithId.invoicesIds = bedFacilityWithId.invoices.map(invoices => invoices.id);

	bedFacilityWithId.registrations = defaultRegistrationEntities;
	bedFacilityWithId.registrationsIds = bedFacilityWithId.registrations.map(registrations => registrations.id);

	bedFacilityWithId.roomTransfers = defaultRoomTransferEntities;
	bedFacilityWithId.roomTransfersIds = bedFacilityWithId.roomTransfers.map(roomTransfers => roomTransfers.id);


	const routerState: RouterState = {
		url: 'bed-facility-crud',
		urls: ['bed-facility-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BedFacilityModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bedFacilityModelState = initialBedFacilityModelState;
		store.setState({model: bedFacilityModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bedFacilityCountBehaviorSubject = new BehaviorSubject(defaultBedFacilityCount);

		// selectors for all references
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		coTreatingDoctorModelsBehaviorSubject = new BehaviorSubject(defaultCoTreatingDoctorEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		inpatientMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultInpatientMedicalExaminationRecordEntities);
		intraoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultIntraoperativeRecordsEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
		invoicePaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentInsuranceEntities);
		invoicePaymentOtherModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentOtherEntities);
		invoicePaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultInvoicePaymentSelfPayingEntities);
		invoiceSummaryModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceSummaryEntities);
		medicalCertificateDischargeResumeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateDischargeResumeEntities);
		medicalCertificateBirthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateBirthEntities);
		medicalCertificateHospitalizationModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateHospitalizationEntities);
		medicalCertificateMedicalAttendanceModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateMedicalAttendanceEntities);
		medicalCertificateMentalHealthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateMentalHealthEntities);
		medicalCertificatePhysicalHealthModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificatePhysicalHealthEntities);
		medicalCertificateRestrictedWorkModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateRestrictedWorkEntities);
		medicalCertificateSickLeaveModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateSickLeaveEntities);
		medicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultMedicalExaminationRecordEntities);
		medicalFeeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalFeeEntities);
		medicationHeaderModelsBehaviorSubject = new BehaviorSubject(defaultMedicationHeaderEntities);
		operatingTheaterMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultOperatingTheaterMedicalExaminationRecordEntities);
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		postOperativeDetailsModelsBehaviorSubject = new BehaviorSubject(defaultPostOperativeDetailsEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		roomFacilityModelsBehaviorSubject = new BehaviorSubject(defaultRoomFacilityEntities);
		roomTransferModelsBehaviorSubject = new BehaviorSubject(defaultRoomTransferEntities);
		sepModelsBehaviorSubject = new BehaviorSubject(defaultSepEntities);
		sampleCollectionInformationModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionInformationEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		tariffSchemaModelsBehaviorSubject = new BehaviorSubject(defaultTariffSchemaEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);

		// selectors for target entity and its related entity
		bedFacilityModelWithIdBehaviorSubject = new BehaviorSubject(bedFacilityWithId);
		intraoperativeRecordsWithIdBehaviorSubject = new BehaviorSubject(bedFacilityWithId.intraoperativeRecords);
		postOperativeDetailsWithIdBehaviorSubject = new BehaviorSubject(bedFacilityWithId.postOperativeDetails);
		preoperativeRecordsWithIdBehaviorSubject = new BehaviorSubject(bedFacilityWithId.preoperativeRecords);
		roomFacilityWithIdBehaviorSubject = new BehaviorSubject(bedFacilityWithId.roomFacility);

		spyOn(store, 'select')
			.withArgs(getCountBedFacilityModels).and.returnValue(bedFacilityCountBehaviorSubject)
			.withArgs(getBedFacilityModelWithId, bedFacilityWithId.id).and.returnValue(bedFacilityModelWithIdBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getCoTreatingDoctorCollectionModels, jasmine.any(String)).and.returnValue(coTreatingDoctorModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInpatientMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(inpatientMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getIntraoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(intraoperativeRecordsModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
			.withArgs(getInvoicePaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentInsuranceModelsBehaviorSubject)
			.withArgs(getInvoicePaymentOtherCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentOtherModelsBehaviorSubject)
			.withArgs(getInvoicePaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(invoicePaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getInvoiceSummaryCollectionModels, jasmine.any(String)).and.returnValue(invoiceSummaryModelsBehaviorSubject)
			.withArgs(getMedicalCertificateDischargeResumeCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateDischargeResumeModelsBehaviorSubject)
			.withArgs(getMedicalCertificateBirthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateBirthModelsBehaviorSubject)
			.withArgs(getMedicalCertificateHospitalizationCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateHospitalizationModelsBehaviorSubject)
			.withArgs(getMedicalCertificateMedicalAttendanceCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateMedicalAttendanceModelsBehaviorSubject)
			.withArgs(getMedicalCertificateMentalHealthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateMentalHealthModelsBehaviorSubject)
			.withArgs(getMedicalCertificatePhysicalHealthCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificatePhysicalHealthModelsBehaviorSubject)
			.withArgs(getMedicalCertificateRestrictedWorkCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateRestrictedWorkModelsBehaviorSubject)
			.withArgs(getMedicalCertificateSickLeaveCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateSickLeaveModelsBehaviorSubject)
			.withArgs(getMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(medicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getMedicalFeeCollectionModels, jasmine.any(String)).and.returnValue(medicalFeeModelsBehaviorSubject)
			.withArgs(getMedicationHeaderCollectionModels, jasmine.any(String)).and.returnValue(medicationHeaderModelsBehaviorSubject)
			.withArgs(getOperatingTheaterMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(operatingTheaterMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPostOperativeDetailsCollectionModels, jasmine.any(String)).and.returnValue(postOperativeDetailsModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getRoomFacilityCollectionModels, jasmine.any(String)).and.returnValue(roomFacilityModelsBehaviorSubject)
			.withArgs(getRoomTransferCollectionModels, jasmine.any(String)).and.returnValue(roomTransferModelsBehaviorSubject)
			.withArgs(getSepCollectionModels, jasmine.any(String)).and.returnValue(sepModelsBehaviorSubject)
			.withArgs(getSampleCollectionInformationCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionInformationModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getTariffSchemaCollectionModels, jasmine.any(String)).and.returnValue(tariffSchemaModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getIntraoperativeRecordsModelWithId, bedFacilityWithId.intraoperativeRecordsId).and.returnValue(intraoperativeRecordsWithIdBehaviorSubject)
			.withArgs(getPostOperativeDetailsModelWithId, bedFacilityWithId.postOperativeDetailsId).and.returnValue(postOperativeDetailsWithIdBehaviorSubject)
			.withArgs(getPreoperativeRecordsModelWithId, bedFacilityWithId.preoperativeRecordsId).and.returnValue(preoperativeRecordsWithIdBehaviorSubject)
			.withArgs(getRoomFacilityModelWithId, bedFacilityWithId.roomFacilityId).and.returnValue(roomFacilityWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BedFacilityCrudModule,
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

			fixture = TestBed.createComponent(BedFacilityCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BedFacilityModel();
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
	it ('Renders the Bed Facility CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Intraoperative Records relation.
	*
	* The button should only exist if intraoperativeRecordsMultiCrudActive is true
	*/
	it ('Renders Intraoperative Records Add Entity button in create mode', fakeAsync(() => {
		const intraoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.intraoperativeRecordsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!intraoperativeRecordsButton).toEqual(component.intraoperativeRecordsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Intraoperative Records', fakeAsync(() => {
		const intraoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.intraoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!intraoperativeRecordsButton).toEqual(component.intraoperativeRecordsMultiCrudActive);

		if (component.intraoperativeRecordsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialIntraoperativeRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.intraoperativeRecordsDisplayName + ' from Model')).length;

			intraoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const actualIntraoperativeRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.intraoperativeRecordsDisplayName + ' from Model')).length;

			expect(actualIntraoperativeRecordsRemoveButtonCount).toEqual(initialIntraoperativeRecordsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Intraoperative Records button', () => {
		const intraoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.intraoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!intraoperativeRecordsButton).toEqual(component.intraoperativeRecordsMultiCrudActive);

		if (component.intraoperativeRecordsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			intraoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialIntraoperativeRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.intraoperativeRecordsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialIntraoperativeRecordsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualIntraoperativeRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.intraoperativeRecordsDisplayName + ' from Model'));

			expect(actualIntraoperativeRecordsRemoveButtons.length).toEqual(initialIntraoperativeRecordsRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Intraoperative Records button when one has already been added', () => {

		const intraoperativeRecordsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.intraoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!intraoperativeRecordsButton).toEqual(component.intraoperativeRecordsMultiCrudActive);

		if (component.intraoperativeRecordsMultiCrudActive) {
			intraoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedintraoperativeRecordsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.intraoperativeRecordsDisplayName + ' to Model'));

			expect(updatedintraoperativeRecordsButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Intraoperative Records entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.intraoperativeRecordsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const intraoperativeRecordsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.intraoperativeRecordsDisplayName + ' from Model')).length;

			expect(intraoperativeRecordsRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Post Operative Details relation.
	*
	* The button should only exist if postOperativeDetailsMultiCrudActive is true
	*/
	it ('Renders Post Operative Details Add Entity button in create mode', fakeAsync(() => {
		const postOperativeDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!postOperativeDetailsButton).toEqual(component.postOperativeDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Post Operative Details', fakeAsync(() => {
		const postOperativeDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeDetailsButton).toEqual(component.postOperativeDetailsMultiCrudActive);

		if (component.postOperativeDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPostOperativeDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeDetailsDisplayName + ' from Model')).length;

			postOperativeDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeDetailsDisplayName + ' from Model')).length;

			expect(actualPostOperativeDetailsRemoveButtonCount).toEqual(initialPostOperativeDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Post Operative Details button', () => {
		const postOperativeDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeDetailsButton).toEqual(component.postOperativeDetailsMultiCrudActive);

		if (component.postOperativeDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			postOperativeDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPostOperativeDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPostOperativeDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPostOperativeDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeDetailsDisplayName + ' from Model'));

			expect(actualPostOperativeDetailsRemoveButtons.length).toEqual(initialPostOperativeDetailsRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Post Operative Details button when one has already been added', () => {

		const postOperativeDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!postOperativeDetailsButton).toEqual(component.postOperativeDetailsMultiCrudActive);

		if (component.postOperativeDetailsMultiCrudActive) {
			postOperativeDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpostOperativeDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.postOperativeDetailsDisplayName + ' to Model'));

			expect(updatedpostOperativeDetailsButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Post Operative Details entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.postOperativeDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const postOperativeDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.postOperativeDetailsDisplayName + ' from Model')).length;

			expect(postOperativeDetailsRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Preoperative Records relation.
	*
	* The button should only exist if preoperativeRecordsMultiCrudActive is true
	*/
	it ('Renders Preoperative Records Add Entity button in create mode', fakeAsync(() => {
		const preoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preoperativeRecordsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!preoperativeRecordsButton).toEqual(component.preoperativeRecordsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Preoperative Records', fakeAsync(() => {
		const preoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preoperativeRecordsButton).toEqual(component.preoperativeRecordsMultiCrudActive);

		if (component.preoperativeRecordsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPreoperativeRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preoperativeRecordsDisplayName + ' from Model')).length;

			preoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPreoperativeRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preoperativeRecordsDisplayName + ' from Model')).length;

			expect(actualPreoperativeRecordsRemoveButtonCount).toEqual(initialPreoperativeRecordsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Preoperative Records button', () => {
		const preoperativeRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.preoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preoperativeRecordsButton).toEqual(component.preoperativeRecordsMultiCrudActive);

		if (component.preoperativeRecordsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			preoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPreoperativeRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preoperativeRecordsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPreoperativeRecordsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPreoperativeRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preoperativeRecordsDisplayName + ' from Model'));

			expect(actualPreoperativeRecordsRemoveButtons.length).toEqual(initialPreoperativeRecordsRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Preoperative Records button when one has already been added', () => {

		const preoperativeRecordsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.preoperativeRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!preoperativeRecordsButton).toEqual(component.preoperativeRecordsMultiCrudActive);

		if (component.preoperativeRecordsMultiCrudActive) {
			preoperativeRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpreoperativeRecordsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.preoperativeRecordsDisplayName + ' to Model'));

			expect(updatedpreoperativeRecordsButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Preoperative Records entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.preoperativeRecordsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const preoperativeRecordsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.preoperativeRecordsDisplayName + ' from Model')).length;

			expect(preoperativeRecordsRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Room Facility relation.
	*
	* The button should only exist if roomFacilityMultiCrudActive is true
	*/
	it ('Renders Room Facility Add Entity button in create mode', fakeAsync(() => {
		const roomFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!roomFacilityButton).toEqual(component.roomFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Room Facility', fakeAsync(() => {
		const roomFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomFacilityButton).toEqual(component.roomFacilityMultiCrudActive);

		if (component.roomFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRoomFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomFacilityDisplayName + ' from Model')).length;

			roomFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualRoomFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomFacilityDisplayName + ' from Model')).length;

			expect(actualRoomFacilityRemoveButtonCount).toEqual(initialRoomFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Room Facility button', () => {
		const roomFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomFacilityButton).toEqual(component.roomFacilityMultiCrudActive);

		if (component.roomFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			roomFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRoomFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRoomFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRoomFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomFacilityDisplayName + ' from Model'));

			expect(actualRoomFacilityRemoveButtons.length).toEqual(initialRoomFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Room Facility button when one has already been added', () => {

		const roomFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomFacilityButton).toEqual(component.roomFacilityMultiCrudActive);

		if (component.roomFacilityMultiCrudActive) {
			roomFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedroomFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomFacilityDisplayName + ' to Model'));

			expect(updatedroomFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Room Facility entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.roomFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const roomFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomFacilityDisplayName + ' from Model')).length;

			expect(roomFacilityRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Bed Reserves relation.
	*
	* The button should only exist if bedReservesMultiCrudActive is true
	*/
	it ('Renders Bed Reserves Add Entity button in create mode', fakeAsync(() => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Bed Reserves', fakeAsync(() => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBedReservesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			const actualBedReservesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			expect(actualBedReservesRemoveButtonCount).toEqual(initialBedReservesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Bed Reserves button', () => {
		const bedReservesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBedReservesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBedReservesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBedReservesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model'));

			expect(actualBedReservesRemoveButtons.length).toEqual(initialBedReservesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Bed Reserves button when one has already been added', () => {

		const bedReservesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bedReservesButton).toEqual(component.bedReservesMultiCrudActive);

		if (component.bedReservesMultiCrudActive) {
			bedReservesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbedReservesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bedReservesDisplayName + ' to Model'));

			expect(updatedbedReservesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Bed Reserves entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bedReservesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bedReservesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bedReservesDisplayName + ' from Model')).length;

			expect(bedReservesRemoveButtonCount).toEqual(bedFacilityWithId.bedReserves.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inpatient Medical Examination Records relation.
	*
	* The button should only exist if inpatientMedicalExaminationRecordsMultiCrudActive is true
	*/
	it ('Renders Inpatient Medical Examination Records Add Entity button in create mode', fakeAsync(() => {
		const inpatientMedicalExaminationRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inpatientMedicalExaminationRecordsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inpatientMedicalExaminationRecordsButton).toEqual(component.inpatientMedicalExaminationRecordsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inpatient Medical Examination Records', fakeAsync(() => {
		const inpatientMedicalExaminationRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inpatientMedicalExaminationRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inpatientMedicalExaminationRecordsButton).toEqual(component.inpatientMedicalExaminationRecordsMultiCrudActive);

		if (component.inpatientMedicalExaminationRecordsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInpatientMedicalExaminationRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inpatientMedicalExaminationRecordsDisplayName + ' from Model')).length;

			inpatientMedicalExaminationRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInpatientMedicalExaminationRecordsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inpatientMedicalExaminationRecordsDisplayName + ' from Model')).length;

			expect(actualInpatientMedicalExaminationRecordsRemoveButtonCount).toEqual(initialInpatientMedicalExaminationRecordsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inpatient Medical Examination Records button', () => {
		const inpatientMedicalExaminationRecordsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inpatientMedicalExaminationRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inpatientMedicalExaminationRecordsButton).toEqual(component.inpatientMedicalExaminationRecordsMultiCrudActive);

		if (component.inpatientMedicalExaminationRecordsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inpatientMedicalExaminationRecordsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInpatientMedicalExaminationRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inpatientMedicalExaminationRecordsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInpatientMedicalExaminationRecordsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInpatientMedicalExaminationRecordsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inpatientMedicalExaminationRecordsDisplayName + ' from Model'));

			expect(actualInpatientMedicalExaminationRecordsRemoveButtons.length).toEqual(initialInpatientMedicalExaminationRecordsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inpatient Medical Examination Records button when one has already been added', () => {

		const inpatientMedicalExaminationRecordsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inpatientMedicalExaminationRecordsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inpatientMedicalExaminationRecordsButton).toEqual(component.inpatientMedicalExaminationRecordsMultiCrudActive);

		if (component.inpatientMedicalExaminationRecordsMultiCrudActive) {
			inpatientMedicalExaminationRecordsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinpatientMedicalExaminationRecordsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inpatientMedicalExaminationRecordsDisplayName + ' to Model'));

			expect(updatedinpatientMedicalExaminationRecordsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inpatient Medical Examination Records entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inpatientMedicalExaminationRecordsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inpatientMedicalExaminationRecordsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inpatientMedicalExaminationRecordsDisplayName + ' from Model')).length;

			expect(inpatientMedicalExaminationRecordsRemoveButtonCount).toEqual(bedFacilityWithId.inpatientMedicalExaminationRecords.length);
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
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
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

			expect(invoicesRemoveButtonCount).toEqual(bedFacilityWithId.invoices.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Registrations relation.
	*
	* The button should only exist if registrationsMultiCrudActive is true
	*/
	it ('Renders Registrations Add Entity button in create mode', fakeAsync(() => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Registrations', fakeAsync(() => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			expect(actualRegistrationsRemoveButtonCount).toEqual(initialRegistrationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Registrations button', () => {
		const registrationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRegistrationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model'));

			expect(actualRegistrationsRemoveButtons.length).toEqual(initialRegistrationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Registrations button when one has already been added', () => {

		const registrationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationsButton).toEqual(component.registrationsMultiCrudActive);

		if (component.registrationsMultiCrudActive) {
			registrationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedregistrationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationsDisplayName + ' to Model'));

			expect(updatedregistrationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Registrations entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.registrationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const registrationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationsDisplayName + ' from Model')).length;

			expect(registrationsRemoveButtonCount).toEqual(bedFacilityWithId.registrations.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Room Transfers relation.
	*
	* The button should only exist if roomTransfersMultiCrudActive is true
	*/
	it ('Renders Room Transfers Add Entity button in create mode', fakeAsync(() => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Room Transfers', fakeAsync(() => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRoomTransfersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			const actualRoomTransfersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			expect(actualRoomTransfersRemoveButtonCount).toEqual(initialRoomTransfersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Room Transfers button', () => {
		const roomTransfersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRoomTransfersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRoomTransfersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRoomTransfersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model'));

			expect(actualRoomTransfersRemoveButtons.length).toEqual(initialRoomTransfersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Room Transfers button when one has already been added', () => {

		const roomTransfersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!roomTransfersButton).toEqual(component.roomTransfersMultiCrudActive);

		if (component.roomTransfersMultiCrudActive) {
			roomTransfersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedroomTransfersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.roomTransfersDisplayName + ' to Model'));

			expect(updatedroomTransfersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Room Transfers entities from model when loading in edit mode', () => {
		component.targetModel = bedFacilityWithId;
		component.targetModelId = bedFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.roomTransfersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const roomTransfersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.roomTransfersDisplayName + ' from Model')).length;

			expect(roomTransfersRemoveButtonCount).toEqual(bedFacilityWithId.roomTransfers.length);
		}
	});

});
