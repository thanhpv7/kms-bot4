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
	getBpjsSEPCollectionModels,
	getCountBpjsSEPModels,
	getBpjsSEPModelWithId
} from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPCrudModule } from '../bpjs-sep-crud.module';
import { BpjsSEPCrudEditComponent } from './bpjs-sep-crud-edit.component';
import {
	BpjsSEPModelState,
	initialState as initialBpjsSEPModelState
} from 'src/app/models/bpjsSEP/bpjs_sep.model.state';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { CrudTileMode } from '../bpjs-sep-crud.component';
import { getBpjsAccidentMasterModelWithId } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { getBpjsAccidentMasterCollectionModels } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { BpjsAccidentMasterModel } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import { BpjsAccidentMasterDataFactory } from 'src/app/lib/utils/factories/bpjs-accident-master-data-factory';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getBpjsJasaRaharjaModelWithId } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaDataFactory } from 'src/app/lib/utils/factories/bpjs-jasa-raharja-data-factory';
import { getBpjsPRBDetailModelWithId } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-detail-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsPcareRegistrationsModelWithId } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-registrations-data-factory';
import { getBpjsSEPSubmissionModelWithId } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { getBpjsSEPSubmissionCollectionModels } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { BpjsSEPSubmissionModel } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import { BpjsSEPSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-submission-data-factory';
import { getBedFacilityModelWithId } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityDataFactory } from 'src/app/lib/utils/factories/bed-facility-data-factory';
import { getBedReserveModelWithId } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveDataFactory } from 'src/app/lib/utils/factories/bed-reserve-data-factory';
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
import { getInvoiceItemModelWithId } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemDataFactory } from 'src/app/lib/utils/factories/invoice-item-data-factory';
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
import { getPcareExaminationModelWithId } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationDataFactory } from 'src/app/lib/utils/factories/pcare-examination-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getPatientVitalInformationModelWithId } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationDataFactory } from 'src/app/lib/utils/factories/patient-vital-information-data-factory';
import { getPrescriptionHeaderModelWithId } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderDataFactory } from 'src/app/lib/utils/factories/prescription-header-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
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
import { getVaccinationOrderModelWithId } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderDataFactory } from 'src/app/lib/utils/factories/vaccination-order-data-factory';

describe('BPJS SEP CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsSEPCrudEditComponent>
	let component: BpjsSEPCrudEditComponent;

	let bpjsSEPModelState: BpjsSEPModelState;

	let store: MockStore<{ model: BpjsSEPModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsSEPCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsAccidentMasterModelsBehaviorSubject: BehaviorSubject<BpjsAccidentMasterModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsJasaRaharjaModelsBehaviorSubject: BehaviorSubject<BpjsJasaRaharjaModel[]>;
	let bpjsPRBDetailModelsBehaviorSubject: BehaviorSubject<BpjsPRBDetailModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsPcareRegistrationsModelsBehaviorSubject: BehaviorSubject<BpjsPcareRegistrationsModel[]>;
	let bpjsSEPSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsSEPSubmissionModel[]>;
	let bedFacilityModelsBehaviorSubject: BehaviorSubject<BedFacilityModel[]>;
	let bedReserveModelsBehaviorSubject: BehaviorSubject<BedReserveModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let diagnosticStaffExaminationSummaryModelsBehaviorSubject: BehaviorSubject<DiagnosticStaffExaminationSummaryModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let fluidBalanceDetailModelsBehaviorSubject: BehaviorSubject<FluidBalanceDetailModel[]>;
	let healthFacilityModelsBehaviorSubject: BehaviorSubject<HealthFacilityModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let invoiceItemModelsBehaviorSubject: BehaviorSubject<InvoiceItemModel[]>;
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
	let pcareExaminationModelsBehaviorSubject: BehaviorSubject<PcareExaminationModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let patientVitalInformationModelsBehaviorSubject: BehaviorSubject<PatientVitalInformationModel[]>;
	let prescriptionHeaderModelsBehaviorSubject: BehaviorSubject<PrescriptionHeaderModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let sepModelsBehaviorSubject: BehaviorSubject<SepModel[]>;
	let sampleCollectionInformationModelsBehaviorSubject: BehaviorSubject<SampleCollectionInformationModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let vaccinationOrderModelsBehaviorSubject: BehaviorSubject<VaccinationOrderModel[]>;

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsAccidentMasterFactory: BpjsAccidentMasterDataFactory = new BpjsAccidentMasterDataFactory();
	const defaultBpjsAccidentMasterCount: number = 10;
	const defaultBpjsAccidentMasterEntities: BpjsAccidentMasterModel[] = bpjsAccidentMasterFactory.createAll(defaultBpjsAccidentMasterCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsJasaRaharjaFactory: BpjsJasaRaharjaDataFactory = new BpjsJasaRaharjaDataFactory();
	const defaultBpjsJasaRaharjaCount: number = 10;
	const defaultBpjsJasaRaharjaEntities: BpjsJasaRaharjaModel[] = bpjsJasaRaharjaFactory.createAll(defaultBpjsJasaRaharjaCount);

	const bpjsPRBDetailFactory: BpjsPRBDetailDataFactory = new BpjsPRBDetailDataFactory();
	const defaultBpjsPRBDetailCount: number = 10;
	const defaultBpjsPRBDetailEntities: BpjsPRBDetailModel[] = bpjsPRBDetailFactory.createAll(defaultBpjsPRBDetailCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsPcareRegistrationsFactory: BpjsPcareRegistrationsDataFactory = new BpjsPcareRegistrationsDataFactory();
	const defaultBpjsPcareRegistrationsCount: number = 10;
	const defaultBpjsPcareRegistrationsEntities: BpjsPcareRegistrationsModel[] = bpjsPcareRegistrationsFactory.createAll(defaultBpjsPcareRegistrationsCount);

	const bpjsSEPSubmissionFactory: BpjsSEPSubmissionDataFactory = new BpjsSEPSubmissionDataFactory();
	const defaultBpjsSEPSubmissionCount: number = 10;
	const defaultBpjsSEPSubmissionEntities: BpjsSEPSubmissionModel[] = bpjsSEPSubmissionFactory.createAll(defaultBpjsSEPSubmissionCount);

	const bedFacilityFactory: BedFacilityDataFactory = new BedFacilityDataFactory();
	const defaultBedFacilityCount: number = 10;
	const defaultBedFacilityEntities: BedFacilityModel[] = bedFacilityFactory.createAll(defaultBedFacilityCount);

	const bedReserveFactory: BedReserveDataFactory = new BedReserveDataFactory();
	const defaultBedReserveCount: number = 10;
	const defaultBedReserveEntities: BedReserveModel[] = bedReserveFactory.createAll(defaultBedReserveCount);

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

	const invoiceItemFactory: InvoiceItemDataFactory = new InvoiceItemDataFactory();
	const defaultInvoiceItemCount: number = 10;
	const defaultInvoiceItemEntities: InvoiceItemModel[] = invoiceItemFactory.createAll(defaultInvoiceItemCount);

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

	const pcareExaminationFactory: PcareExaminationDataFactory = new PcareExaminationDataFactory();
	const defaultPcareExaminationCount: number = 10;
	const defaultPcareExaminationEntities: PcareExaminationModel[] = pcareExaminationFactory.createAll(defaultPcareExaminationCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const patientVitalInformationFactory: PatientVitalInformationDataFactory = new PatientVitalInformationDataFactory();
	const defaultPatientVitalInformationCount: number = 10;
	const defaultPatientVitalInformationEntities: PatientVitalInformationModel[] = patientVitalInformationFactory.createAll(defaultPatientVitalInformationCount);

	const prescriptionHeaderFactory: PrescriptionHeaderDataFactory = new PrescriptionHeaderDataFactory();
	const defaultPrescriptionHeaderCount: number = 10;
	const defaultPrescriptionHeaderEntities: PrescriptionHeaderModel[] = prescriptionHeaderFactory.createAll(defaultPrescriptionHeaderCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

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

	const vaccinationOrderFactory: VaccinationOrderDataFactory = new VaccinationOrderDataFactory();
	const defaultVaccinationOrderCount: number = 10;
	const defaultVaccinationOrderEntities: VaccinationOrderModel[] = vaccinationOrderFactory.createAll(defaultVaccinationOrderCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsSEPWithId: BpjsSEPModel = defaultBpjsSEPEntities[0];
	let bpjsSEPModelWithIdBehaviorSubject: BehaviorSubject<BpjsSEPModel>;

	bpjsSEPWithId.registration = defaultRegistrationEntities[0];
	bpjsSEPWithId.registrationId = bpjsSEPWithId.registration.id;
	let registrationWithIdBehaviorSubject: BehaviorSubject<RegistrationModel>;

	bpjsSEPWithId.patientPaymentBPJS = defaultPatientPaymentBPJSEntities[0];
	bpjsSEPWithId.patientPaymentBPJSId = bpjsSEPWithId.patientPaymentBPJS.id;
	let patientPaymentBPJSWithIdBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel>;


	const routerState: RouterState = {
		url: 'bpjs-sep-crud',
		urls: ['bpjs-sep-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsSEPModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsSEPModelState = initialBpjsSEPModelState;
		store.setState({model: bpjsSEPModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsSEPCountBehaviorSubject = new BehaviorSubject(defaultBpjsSEPCount);

		// selectors for all references
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsAccidentMasterModelsBehaviorSubject = new BehaviorSubject(defaultBpjsAccidentMasterEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsJasaRaharjaModelsBehaviorSubject = new BehaviorSubject(defaultBpjsJasaRaharjaEntities);
		bpjsPRBDetailModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBDetailEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsPcareRegistrationsModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcareRegistrationsEntities);
		bpjsSEPSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPSubmissionEntities);
		bedFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBedFacilityEntities);
		bedReserveModelsBehaviorSubject = new BehaviorSubject(defaultBedReserveEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		diagnosticStaffExaminationSummaryModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticStaffExaminationSummaryEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		fluidBalanceDetailModelsBehaviorSubject = new BehaviorSubject(defaultFluidBalanceDetailEntities);
		healthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultHealthFacilityEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		invoiceItemModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceItemEntities);
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
		pcareExaminationModelsBehaviorSubject = new BehaviorSubject(defaultPcareExaminationEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		patientVitalInformationModelsBehaviorSubject = new BehaviorSubject(defaultPatientVitalInformationEntities);
		prescriptionHeaderModelsBehaviorSubject = new BehaviorSubject(defaultPrescriptionHeaderEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		sepModelsBehaviorSubject = new BehaviorSubject(defaultSepEntities);
		sampleCollectionInformationModelsBehaviorSubject = new BehaviorSubject(defaultSampleCollectionInformationEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		vaccinationOrderModelsBehaviorSubject = new BehaviorSubject(defaultVaccinationOrderEntities);

		// selectors for target entity and its related entity
		bpjsSEPModelWithIdBehaviorSubject = new BehaviorSubject(bpjsSEPWithId);
		registrationWithIdBehaviorSubject = new BehaviorSubject(bpjsSEPWithId.registration);
		patientPaymentBPJSWithIdBehaviorSubject = new BehaviorSubject(bpjsSEPWithId.patientPaymentBPJS);

		spyOn(store, 'select')
			.withArgs(getCountBpjsSEPModels).and.returnValue(bpjsSEPCountBehaviorSubject)
			.withArgs(getBpjsSEPModelWithId, bpjsSEPWithId.id).and.returnValue(bpjsSEPModelWithIdBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsAccidentMasterCollectionModels, jasmine.any(String)).and.returnValue(bpjsAccidentMasterModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsJasaRaharjaCollectionModels, jasmine.any(String)).and.returnValue(bpjsJasaRaharjaModelsBehaviorSubject)
			.withArgs(getBpjsPRBDetailCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBDetailModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsPcareRegistrationsCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcareRegistrationsModelsBehaviorSubject)
			.withArgs(getBpjsSEPSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPSubmissionModelsBehaviorSubject)
			.withArgs(getBedFacilityCollectionModels, jasmine.any(String)).and.returnValue(bedFacilityModelsBehaviorSubject)
			.withArgs(getBedReserveCollectionModels, jasmine.any(String)).and.returnValue(bedReserveModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDiagnosticStaffExaminationSummaryCollectionModels, jasmine.any(String)).and.returnValue(diagnosticStaffExaminationSummaryModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getFluidBalanceDetailCollectionModels, jasmine.any(String)).and.returnValue(fluidBalanceDetailModelsBehaviorSubject)
			.withArgs(getHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(healthFacilityModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getInvoiceItemCollectionModels, jasmine.any(String)).and.returnValue(invoiceItemModelsBehaviorSubject)
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
			.withArgs(getPcareExaminationCollectionModels, jasmine.any(String)).and.returnValue(pcareExaminationModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getPatientVitalInformationCollectionModels, jasmine.any(String)).and.returnValue(patientVitalInformationModelsBehaviorSubject)
			.withArgs(getPrescriptionHeaderCollectionModels, jasmine.any(String)).and.returnValue(prescriptionHeaderModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getSepCollectionModels, jasmine.any(String)).and.returnValue(sepModelsBehaviorSubject)
			.withArgs(getSampleCollectionInformationCollectionModels, jasmine.any(String)).and.returnValue(sampleCollectionInformationModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getVaccinationOrderCollectionModels, jasmine.any(String)).and.returnValue(vaccinationOrderModelsBehaviorSubject)
			.withArgs(getRegistrationModelWithId, bpjsSEPWithId.registrationId).and.returnValue(registrationWithIdBehaviorSubject)
			.withArgs(getPatientPaymentBPJSModelWithId, bpjsSEPWithId.patientPaymentBPJSId).and.returnValue(patientPaymentBPJSWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsSEPCrudModule,
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

			fixture = TestBed.createComponent(BpjsSEPCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsSEPModel();
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
	it ('Renders the BPJS SEP CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Registration relation.
	*
	* The button should only exist if registrationMultiCrudActive is true
	*/
	it ('Renders Registration Add Entity button in create mode', fakeAsync(() => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Registration', fakeAsync(() => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialRegistrationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			registrationButton.nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			expect(actualRegistrationRemoveButtonCount).toEqual(initialRegistrationRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Registration button', () => {
		const registrationButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			registrationButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialRegistrationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialRegistrationRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualRegistrationRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model'));

			expect(actualRegistrationRemoveButtons.length).toEqual(initialRegistrationRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Registration button when one has already been added', () => {

		const registrationButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!registrationButton).toEqual(component.registrationMultiCrudActive);

		if (component.registrationMultiCrudActive) {
			registrationButton.nativeElement.click();
			fixture.detectChanges();

			const updatedregistrationButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.registrationDisplayName + ' to Model'));

			expect(updatedregistrationButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Registration entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSEPWithId;
		component.targetModelId = bpjsSEPWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.registrationMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const registrationRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.registrationDisplayName + ' from Model')).length;

			expect(registrationRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment BPJS relation.
	*
	* The button should only exist if patientPaymentBPJSMultiCrudActive is true
	*/
	it ('Renders Patient Payment BPJS Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment BPJS', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(actualPatientPaymentBPJSRemoveButtonCount).toEqual(initialPatientPaymentBPJSRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment BPJS button', () => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentBPJSRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			expect(actualPatientPaymentBPJSRemoveButtons.length).toEqual(initialPatientPaymentBPJSRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Payment BPJS button when one has already been added', () => {

		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentBPJSButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

			expect(updatedpatientPaymentBPJSButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Payment BPJS entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSEPWithId;
		component.targetModelId = bpjsSEPWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentBPJSMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentBPJSRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(patientPaymentBPJSRemoveButtonCount).toEqual(1);
		}
	});

});
