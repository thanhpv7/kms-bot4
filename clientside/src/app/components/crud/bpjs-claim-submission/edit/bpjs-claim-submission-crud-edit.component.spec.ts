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
	getBpjsClaimSubmissionCollectionModels,
	getCountBpjsClaimSubmissionModels,
	getBpjsClaimSubmissionModelWithId
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionCrudModule } from '../bpjs-claim-submission-crud.module';
import { BpjsClaimSubmissionCrudEditComponent } from './bpjs-claim-submission-crud-edit.component';
import {
	BpjsClaimSubmissionModelState,
	initialState as initialBpjsClaimSubmissionModelState
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.state';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { CrudTileMode } from '../bpjs-claim-submission-crud.component';
import { getBpjsAccidentMasterModelWithId } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { getBpjsAccidentMasterCollectionModels } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { BpjsAccidentMasterModel } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import { BpjsAccidentMasterDataFactory } from 'src/app/lib/utils/factories/bpjs-accident-master-data-factory';
import { getBpjsControlPlanModelWithId } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { getBpjsControlPlanCollectionModels } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { BpjsControlPlanModel } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import { BpjsControlPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-control-plan-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDismissalConditionModelWithId } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { getBpjsDismissalConditionCollectionModels } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { BpjsDismissalConditionModel } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model';
import { BpjsDismissalConditionDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-condition-data-factory';
import { getBpjsDismissalMappingModelWithId } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { getBpjsDismissalMappingCollectionModels } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { BpjsDismissalMappingModel } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import { BpjsDismissalMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-mapping-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsFacilityListModelWithId } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { getBpjsFacilityListCollectionModels } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { BpjsFacilityListModel } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model';
import { BpjsFacilityListDataFactory } from 'src/app/lib/utils/factories/bpjs-facility-list-data-factory';
import { getBpjsHealthFacilityModelWithId } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getBpjsJasaRaharjaModelWithId } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaDataFactory } from 'src/app/lib/utils/factories/bpjs-jasa-raharja-data-factory';
import { getBpjsPRBModelWithId } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsProcedureModelWithId } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureDataFactory } from 'src/app/lib/utils/factories/bpjs-procedure-data-factory';
import { getBpjsReferralSpecialistModelWithId } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { getBpjsReferralSpecialistCollectionModels } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { BpjsReferralSpecialistModel } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model';
import { BpjsReferralSpecialistDataFactory } from 'src/app/lib/utils/factories/bpjs-referral-specialist-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBpjsSEPSubmissionModelWithId } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { getBpjsSEPSubmissionCollectionModels } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { BpjsSEPSubmissionModel } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import { BpjsSEPSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-submission-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getBpjsSpecialReferralModelWithId } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { getBpjsSpecialReferralCollectionModels } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { BpjsSpecialReferralModel } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import { BpjsSpecialReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-special-referral-data-factory';
import { getBpjsTreatmentRoomModelWithId } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { getBpjsTreatmentRoomCollectionModels } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { BpjsTreatmentRoomModel } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import { BpjsTreatmentRoomDataFactory } from 'src/app/lib/utils/factories/bpjs-treatment-room-data-factory';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getCashRefundModelWithId } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { getCashRefundCollectionModels } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { CashRefundModel } from 'src/app/models/cashRefund/cash_refund.model';
import { CashRefundDataFactory } from 'src/app/lib/utils/factories/cash-refund-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getPatientCaseHistoryModelWithId } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { getPatientCaseHistoryCollectionModels } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { PatientCaseHistoryModel } from 'src/app/models/patientCaseHistory/patient_case_history.model';
import { PatientCaseHistoryDataFactory } from 'src/app/lib/utils/factories/patient-case-history-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientContactInfoModelWithId } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { getPatientContactInfoCollectionModels } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { PatientContactInfoModel } from 'src/app/models/patientContactInfo/patient_contact_info.model';
import { PatientContactInfoDataFactory } from 'src/app/lib/utils/factories/patient-contact-info-data-factory';
import { getPatientDetailModelWithId } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { getPatientDetailCollectionModels } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { PatientDetailModel } from 'src/app/models/patientDetail/patient_detail.model';
import { PatientDetailDataFactory } from 'src/app/lib/utils/factories/patient-detail-data-factory';
import { getPatientDetailAddressModelWithId } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { getPatientDetailAddressCollectionModels } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { PatientDetailAddressModel } from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import { PatientDetailAddressDataFactory } from 'src/app/lib/utils/factories/patient-detail-address-data-factory';
import { getPatientEmergencyContactDetailModelWithId } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { getPatientEmergencyContactDetailCollectionModels } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { PatientEmergencyContactDetailModel } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import { PatientEmergencyContactDetailDataFactory } from 'src/app/lib/utils/factories/patient-emergency-contact-detail-data-factory';
import { getPatientEmploymentDetailModelWithId } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { getPatientEmploymentDetailCollectionModels } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { PatientEmploymentDetailModel } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import { PatientEmploymentDetailDataFactory } from 'src/app/lib/utils/factories/patient-employment-detail-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentSelfPayingModelWithId } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { getPatientPaymentSelfPayingCollectionModels } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { PatientPaymentSelfPayingModel } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import { PatientPaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/patient-payment-self-paying-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';
import { getPatientPaymentInsuranceModelWithId } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-payment-insurance-data-factory';
import { getPatientPaymentOthersModelWithId } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { getPatientPaymentOthersCollectionModels } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { PatientPaymentOthersModel } from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import { PatientPaymentOthersDataFactory } from 'src/app/lib/utils/factories/patient-payment-others-data-factory';
import { getPatientPersonalInfoModelWithId } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { getPatientPersonalInfoCollectionModels } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { PatientPersonalInfoModel } from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import { PatientPersonalInfoDataFactory } from 'src/app/lib/utils/factories/patient-personal-info-data-factory';
import { getPatientSupportingDocumentModelWithId } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { getPatientSupportingDocumentCollectionModels } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { PatientSupportingDocumentModel } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import { PatientSupportingDocumentDataFactory } from 'src/app/lib/utils/factories/patient-supporting-document-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('BPJS Claim Submission CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsClaimSubmissionCrudEditComponent>
	let component: BpjsClaimSubmissionCrudEditComponent;

	let bpjsClaimSubmissionModelState: BpjsClaimSubmissionModelState;

	let store: MockStore<{ model: BpjsClaimSubmissionModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsClaimSubmissionCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsAccidentMasterModelsBehaviorSubject: BehaviorSubject<BpjsAccidentMasterModel[]>;
	let bpjsControlPlanModelsBehaviorSubject: BehaviorSubject<BpjsControlPlanModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDismissalConditionModelsBehaviorSubject: BehaviorSubject<BpjsDismissalConditionModel[]>;
	let bpjsDismissalMappingModelsBehaviorSubject: BehaviorSubject<BpjsDismissalMappingModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsFacilityListModelsBehaviorSubject: BehaviorSubject<BpjsFacilityListModel[]>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsJasaRaharjaModelsBehaviorSubject: BehaviorSubject<BpjsJasaRaharjaModel[]>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsProcedureModelsBehaviorSubject: BehaviorSubject<BpjsProcedureModel[]>;
	let bpjsReferralSpecialistModelsBehaviorSubject: BehaviorSubject<BpjsReferralSpecialistModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsSEPSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsSEPSubmissionModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bpjsSpecialReferralModelsBehaviorSubject: BehaviorSubject<BpjsSpecialReferralModel[]>;
	let bpjsTreatmentRoomModelsBehaviorSubject: BehaviorSubject<BpjsTreatmentRoomModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let cashRefundModelsBehaviorSubject: BehaviorSubject<CashRefundModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let patientCaseHistoryModelsBehaviorSubject: BehaviorSubject<PatientCaseHistoryModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientContactInfoModelsBehaviorSubject: BehaviorSubject<PatientContactInfoModel[]>;
	let patientDetailModelsBehaviorSubject: BehaviorSubject<PatientDetailModel[]>;
	let patientDetailAddressModelsBehaviorSubject: BehaviorSubject<PatientDetailAddressModel[]>;
	let patientEmergencyContactDetailModelsBehaviorSubject: BehaviorSubject<PatientEmergencyContactDetailModel[]>;
	let patientEmploymentDetailModelsBehaviorSubject: BehaviorSubject<PatientEmploymentDetailModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientPaymentSelfPayingModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientPaymentOthersModel[]>;
	let patientPersonalInfoModelsBehaviorSubject: BehaviorSubject<PatientPersonalInfoModel[]>;
	let patientSupportingDocumentModelsBehaviorSubject: BehaviorSubject<PatientSupportingDocumentModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsAccidentMasterFactory: BpjsAccidentMasterDataFactory = new BpjsAccidentMasterDataFactory();
	const defaultBpjsAccidentMasterCount: number = 10;
	const defaultBpjsAccidentMasterEntities: BpjsAccidentMasterModel[] = bpjsAccidentMasterFactory.createAll(defaultBpjsAccidentMasterCount);

	const bpjsControlPlanFactory: BpjsControlPlanDataFactory = new BpjsControlPlanDataFactory();
	const defaultBpjsControlPlanCount: number = 10;
	const defaultBpjsControlPlanEntities: BpjsControlPlanModel[] = bpjsControlPlanFactory.createAll(defaultBpjsControlPlanCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDismissalConditionFactory: BpjsDismissalConditionDataFactory = new BpjsDismissalConditionDataFactory();
	const defaultBpjsDismissalConditionCount: number = 10;
	const defaultBpjsDismissalConditionEntities: BpjsDismissalConditionModel[] = bpjsDismissalConditionFactory.createAll(defaultBpjsDismissalConditionCount);

	const bpjsDismissalMappingFactory: BpjsDismissalMappingDataFactory = new BpjsDismissalMappingDataFactory();
	const defaultBpjsDismissalMappingCount: number = 10;
	const defaultBpjsDismissalMappingEntities: BpjsDismissalMappingModel[] = bpjsDismissalMappingFactory.createAll(defaultBpjsDismissalMappingCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsFacilityListFactory: BpjsFacilityListDataFactory = new BpjsFacilityListDataFactory();
	const defaultBpjsFacilityListCount: number = 10;
	const defaultBpjsFacilityListEntities: BpjsFacilityListModel[] = bpjsFacilityListFactory.createAll(defaultBpjsFacilityListCount);

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsJasaRaharjaFactory: BpjsJasaRaharjaDataFactory = new BpjsJasaRaharjaDataFactory();
	const defaultBpjsJasaRaharjaCount: number = 10;
	const defaultBpjsJasaRaharjaEntities: BpjsJasaRaharjaModel[] = bpjsJasaRaharjaFactory.createAll(defaultBpjsJasaRaharjaCount);

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsProcedureFactory: BpjsProcedureDataFactory = new BpjsProcedureDataFactory();
	const defaultBpjsProcedureCount: number = 10;
	const defaultBpjsProcedureEntities: BpjsProcedureModel[] = bpjsProcedureFactory.createAll(defaultBpjsProcedureCount);

	const bpjsReferralSpecialistFactory: BpjsReferralSpecialistDataFactory = new BpjsReferralSpecialistDataFactory();
	const defaultBpjsReferralSpecialistCount: number = 10;
	const defaultBpjsReferralSpecialistEntities: BpjsReferralSpecialistModel[] = bpjsReferralSpecialistFactory.createAll(defaultBpjsReferralSpecialistCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsSEPSubmissionFactory: BpjsSEPSubmissionDataFactory = new BpjsSEPSubmissionDataFactory();
	const defaultBpjsSEPSubmissionCount: number = 10;
	const defaultBpjsSEPSubmissionEntities: BpjsSEPSubmissionModel[] = bpjsSEPSubmissionFactory.createAll(defaultBpjsSEPSubmissionCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const bpjsSpecialReferralFactory: BpjsSpecialReferralDataFactory = new BpjsSpecialReferralDataFactory();
	const defaultBpjsSpecialReferralCount: number = 10;
	const defaultBpjsSpecialReferralEntities: BpjsSpecialReferralModel[] = bpjsSpecialReferralFactory.createAll(defaultBpjsSpecialReferralCount);

	const bpjsTreatmentRoomFactory: BpjsTreatmentRoomDataFactory = new BpjsTreatmentRoomDataFactory();
	const defaultBpjsTreatmentRoomCount: number = 10;
	const defaultBpjsTreatmentRoomEntities: BpjsTreatmentRoomModel[] = bpjsTreatmentRoomFactory.createAll(defaultBpjsTreatmentRoomCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const cashRefundFactory: CashRefundDataFactory = new CashRefundDataFactory();
	const defaultCashRefundCount: number = 10;
	const defaultCashRefundEntities: CashRefundModel[] = cashRefundFactory.createAll(defaultCashRefundCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const patientCaseHistoryFactory: PatientCaseHistoryDataFactory = new PatientCaseHistoryDataFactory();
	const defaultPatientCaseHistoryCount: number = 10;
	const defaultPatientCaseHistoryEntities: PatientCaseHistoryModel[] = patientCaseHistoryFactory.createAll(defaultPatientCaseHistoryCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientContactInfoFactory: PatientContactInfoDataFactory = new PatientContactInfoDataFactory();
	const defaultPatientContactInfoCount: number = 10;
	const defaultPatientContactInfoEntities: PatientContactInfoModel[] = patientContactInfoFactory.createAll(defaultPatientContactInfoCount);

	const patientDetailFactory: PatientDetailDataFactory = new PatientDetailDataFactory();
	const defaultPatientDetailCount: number = 10;
	const defaultPatientDetailEntities: PatientDetailModel[] = patientDetailFactory.createAll(defaultPatientDetailCount);

	const patientDetailAddressFactory: PatientDetailAddressDataFactory = new PatientDetailAddressDataFactory();
	const defaultPatientDetailAddressCount: number = 10;
	const defaultPatientDetailAddressEntities: PatientDetailAddressModel[] = patientDetailAddressFactory.createAll(defaultPatientDetailAddressCount);

	const patientEmergencyContactDetailFactory: PatientEmergencyContactDetailDataFactory = new PatientEmergencyContactDetailDataFactory();
	const defaultPatientEmergencyContactDetailCount: number = 10;
	const defaultPatientEmergencyContactDetailEntities: PatientEmergencyContactDetailModel[] = patientEmergencyContactDetailFactory.createAll(defaultPatientEmergencyContactDetailCount);

	const patientEmploymentDetailFactory: PatientEmploymentDetailDataFactory = new PatientEmploymentDetailDataFactory();
	const defaultPatientEmploymentDetailCount: number = 10;
	const defaultPatientEmploymentDetailEntities: PatientEmploymentDetailModel[] = patientEmploymentDetailFactory.createAll(defaultPatientEmploymentDetailCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentSelfPayingFactory: PatientPaymentSelfPayingDataFactory = new PatientPaymentSelfPayingDataFactory();
	const defaultPatientPaymentSelfPayingCount: number = 10;
	const defaultPatientPaymentSelfPayingEntities: PatientPaymentSelfPayingModel[] = patientPaymentSelfPayingFactory.createAll(defaultPatientPaymentSelfPayingCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const patientPaymentInsuranceFactory: PatientPaymentInsuranceDataFactory = new PatientPaymentInsuranceDataFactory();
	const defaultPatientPaymentInsuranceCount: number = 10;
	const defaultPatientPaymentInsuranceEntities: PatientPaymentInsuranceModel[] = patientPaymentInsuranceFactory.createAll(defaultPatientPaymentInsuranceCount);

	const patientPaymentOthersFactory: PatientPaymentOthersDataFactory = new PatientPaymentOthersDataFactory();
	const defaultPatientPaymentOthersCount: number = 10;
	const defaultPatientPaymentOthersEntities: PatientPaymentOthersModel[] = patientPaymentOthersFactory.createAll(defaultPatientPaymentOthersCount);

	const patientPersonalInfoFactory: PatientPersonalInfoDataFactory = new PatientPersonalInfoDataFactory();
	const defaultPatientPersonalInfoCount: number = 10;
	const defaultPatientPersonalInfoEntities: PatientPersonalInfoModel[] = patientPersonalInfoFactory.createAll(defaultPatientPersonalInfoCount);

	const patientSupportingDocumentFactory: PatientSupportingDocumentDataFactory = new PatientSupportingDocumentDataFactory();
	const defaultPatientSupportingDocumentCount: number = 10;
	const defaultPatientSupportingDocumentEntities: PatientSupportingDocumentModel[] = patientSupportingDocumentFactory.createAll(defaultPatientSupportingDocumentCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsClaimSubmissionWithId: BpjsClaimSubmissionModel = defaultBpjsClaimSubmissionEntities[0];
	let bpjsClaimSubmissionModelWithIdBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel>;

	bpjsClaimSubmissionWithId.bpjsDiagnose = defaultBpjsDiagnoseEntities[0];
	bpjsClaimSubmissionWithId.bpjsDiagnoseId = bpjsClaimSubmissionWithId.bpjsDiagnose.id;
	let bpjsDiagnoseWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel>;

	bpjsClaimSubmissionWithId.bpjsDoctorMapping = defaultBpjsDoctorMappingEntities[0];
	bpjsClaimSubmissionWithId.bpjsDoctorMappingId = bpjsClaimSubmissionWithId.bpjsDoctorMapping.id;
	let bpjsDoctorMappingWithIdBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel>;

	bpjsClaimSubmissionWithId.bpjsHealthFacility = defaultBpjsHealthFacilityEntities[0];
	bpjsClaimSubmissionWithId.bpjsHealthFacilityId = bpjsClaimSubmissionWithId.bpjsHealthFacility.id;
	let bpjsHealthFacilityWithIdBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel>;

	bpjsClaimSubmissionWithId.bpjsProcedure = defaultBpjsProcedureEntities[0];
	bpjsClaimSubmissionWithId.bpjsProcedureId = bpjsClaimSubmissionWithId.bpjsProcedure.id;
	let bpjsProcedureWithIdBehaviorSubject: BehaviorSubject<BpjsProcedureModel>;

	bpjsClaimSubmissionWithId.bpjsServiceMapping = defaultBpjsServiceMappingEntities[0];
	bpjsClaimSubmissionWithId.bpjsServiceMappingId = bpjsClaimSubmissionWithId.bpjsServiceMapping.id;
	let bpjsServiceMappingWithIdBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel>;

	bpjsClaimSubmissionWithId.patientGeneralInfo = defaultPatientGeneralInfoEntities[0];
	bpjsClaimSubmissionWithId.patientGeneralInfoId = bpjsClaimSubmissionWithId.patientGeneralInfo.id;
	let patientGeneralInfoWithIdBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel>;

	bpjsClaimSubmissionWithId.patientPaymentBPJS = defaultPatientPaymentBPJSEntities[0];
	bpjsClaimSubmissionWithId.patientPaymentBPJSId = bpjsClaimSubmissionWithId.patientPaymentBPJS.id;
	let patientPaymentBPJSWithIdBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel>;

	bpjsClaimSubmissionWithId.bpjsDismissalConditions = defaultBpjsDismissalConditionEntities;
	bpjsClaimSubmissionWithId.bpjsDismissalConditionsIds = bpjsClaimSubmissionWithId.bpjsDismissalConditions.map(bpjsDismissalConditions => bpjsDismissalConditions.id);

	bpjsClaimSubmissionWithId.bpjsDismissalMappings = defaultBpjsDismissalMappingEntities;
	bpjsClaimSubmissionWithId.bpjsDismissalMappingsIds = bpjsClaimSubmissionWithId.bpjsDismissalMappings.map(bpjsDismissalMappings => bpjsDismissalMappings.id);

	bpjsClaimSubmissionWithId.bpjsTreatmentRooms = defaultBpjsTreatmentRoomEntities;
	bpjsClaimSubmissionWithId.bpjsTreatmentRoomsIds = bpjsClaimSubmissionWithId.bpjsTreatmentRooms.map(bpjsTreatmentRooms => bpjsTreatmentRooms.id);


	const routerState: RouterState = {
		url: 'bpjs-claim-submission-crud',
		urls: ['bpjs-claim-submission-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsClaimSubmissionModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsClaimSubmissionModelState = initialBpjsClaimSubmissionModelState;
		store.setState({model: bpjsClaimSubmissionModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsClaimSubmissionCountBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionCount);

		// selectors for all references
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsAccidentMasterModelsBehaviorSubject = new BehaviorSubject(defaultBpjsAccidentMasterEntities);
		bpjsControlPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsControlPlanEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDismissalConditionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalConditionEntities);
		bpjsDismissalMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalMappingEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsFacilityListModelsBehaviorSubject = new BehaviorSubject(defaultBpjsFacilityListEntities);
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsJasaRaharjaModelsBehaviorSubject = new BehaviorSubject(defaultBpjsJasaRaharjaEntities);
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsProcedureModelsBehaviorSubject = new BehaviorSubject(defaultBpjsProcedureEntities);
		bpjsReferralSpecialistModelsBehaviorSubject = new BehaviorSubject(defaultBpjsReferralSpecialistEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsSEPSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPSubmissionEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bpjsSpecialReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSpecialReferralEntities);
		bpjsTreatmentRoomModelsBehaviorSubject = new BehaviorSubject(defaultBpjsTreatmentRoomEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		cashRefundModelsBehaviorSubject = new BehaviorSubject(defaultCashRefundEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		patientCaseHistoryModelsBehaviorSubject = new BehaviorSubject(defaultPatientCaseHistoryEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientContactInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientContactInfoEntities);
		patientDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailEntities);
		patientDetailAddressModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailAddressEntities);
		patientEmergencyContactDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmergencyContactDetailEntities);
		patientEmploymentDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmploymentDetailEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentSelfPayingEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentOthersEntities);
		patientPersonalInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientPersonalInfoEntities);
		patientSupportingDocumentModelsBehaviorSubject = new BehaviorSubject(defaultPatientSupportingDocumentEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		bpjsClaimSubmissionModelWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId);
		bpjsDiagnoseWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.bpjsDiagnose);
		bpjsDoctorMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.bpjsDoctorMapping);
		bpjsHealthFacilityWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.bpjsHealthFacility);
		bpjsProcedureWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.bpjsProcedure);
		bpjsServiceMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.bpjsServiceMapping);
		patientGeneralInfoWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.patientGeneralInfo);
		patientPaymentBPJSWithIdBehaviorSubject = new BehaviorSubject(bpjsClaimSubmissionWithId.patientPaymentBPJS);

		spyOn(store, 'select')
			.withArgs(getCountBpjsClaimSubmissionModels).and.returnValue(bpjsClaimSubmissionCountBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionModelWithId, bpjsClaimSubmissionWithId.id).and.returnValue(bpjsClaimSubmissionModelWithIdBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsAccidentMasterCollectionModels, jasmine.any(String)).and.returnValue(bpjsAccidentMasterModelsBehaviorSubject)
			.withArgs(getBpjsControlPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsControlPlanModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDismissalConditionCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalConditionModelsBehaviorSubject)
			.withArgs(getBpjsDismissalMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalMappingModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsFacilityListCollectionModels, jasmine.any(String)).and.returnValue(bpjsFacilityListModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsJasaRaharjaCollectionModels, jasmine.any(String)).and.returnValue(bpjsJasaRaharjaModelsBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsProcedureCollectionModels, jasmine.any(String)).and.returnValue(bpjsProcedureModelsBehaviorSubject)
			.withArgs(getBpjsReferralSpecialistCollectionModels, jasmine.any(String)).and.returnValue(bpjsReferralSpecialistModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsSEPSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBpjsSpecialReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsSpecialReferralModelsBehaviorSubject)
			.withArgs(getBpjsTreatmentRoomCollectionModels, jasmine.any(String)).and.returnValue(bpjsTreatmentRoomModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getCashRefundCollectionModels, jasmine.any(String)).and.returnValue(cashRefundModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getPatientCaseHistoryCollectionModels, jasmine.any(String)).and.returnValue(patientCaseHistoryModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientContactInfoCollectionModels, jasmine.any(String)).and.returnValue(patientContactInfoModelsBehaviorSubject)
			.withArgs(getPatientDetailCollectionModels, jasmine.any(String)).and.returnValue(patientDetailModelsBehaviorSubject)
			.withArgs(getPatientDetailAddressCollectionModels, jasmine.any(String)).and.returnValue(patientDetailAddressModelsBehaviorSubject)
			.withArgs(getPatientEmergencyContactDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmergencyContactDetailModelsBehaviorSubject)
			.withArgs(getPatientEmploymentDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmploymentDetailModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientPersonalInfoCollectionModels, jasmine.any(String)).and.returnValue(patientPersonalInfoModelsBehaviorSubject)
			.withArgs(getPatientSupportingDocumentCollectionModels, jasmine.any(String)).and.returnValue(patientSupportingDocumentModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseModelWithId, bpjsClaimSubmissionWithId.bpjsDiagnoseId).and.returnValue(bpjsDiagnoseWithIdBehaviorSubject)
			.withArgs(getBpjsDoctorMappingModelWithId, bpjsClaimSubmissionWithId.bpjsDoctorMappingId).and.returnValue(bpjsDoctorMappingWithIdBehaviorSubject)
			.withArgs(getBpjsHealthFacilityModelWithId, bpjsClaimSubmissionWithId.bpjsHealthFacilityId).and.returnValue(bpjsHealthFacilityWithIdBehaviorSubject)
			.withArgs(getBpjsProcedureModelWithId, bpjsClaimSubmissionWithId.bpjsProcedureId).and.returnValue(bpjsProcedureWithIdBehaviorSubject)
			.withArgs(getBpjsServiceMappingModelWithId, bpjsClaimSubmissionWithId.bpjsServiceMappingId).and.returnValue(bpjsServiceMappingWithIdBehaviorSubject)
			.withArgs(getPatientGeneralInfoModelWithId, bpjsClaimSubmissionWithId.patientGeneralInfoId).and.returnValue(patientGeneralInfoWithIdBehaviorSubject)
			.withArgs(getPatientPaymentBPJSModelWithId, bpjsClaimSubmissionWithId.patientPaymentBPJSId).and.returnValue(patientPaymentBPJSWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsClaimSubmissionCrudModule,
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

			fixture = TestBed.createComponent(BpjsClaimSubmissionCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsClaimSubmissionModel();
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
	it ('Renders the BPJS Claim Submission CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Diagnose relation.
	*
	* The button should only exist if bpjsDiagnoseMultiCrudActive is true
	*/
	it ('Renders BPJS Diagnose Add Entity button in create mode', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Diagnose', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(actualBpjsDiagnoseRemoveButtonCount).toEqual(initialBpjsDiagnoseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Diagnose button', () => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDiagnoseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			expect(actualBpjsDiagnoseRemoveButtons.length).toEqual(initialBpjsDiagnoseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Diagnose button when one has already been added', () => {

		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDiagnoseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

			expect(updatedbpjsDiagnoseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Diagnose entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDiagnoseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDiagnoseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(bpjsDiagnoseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Doctor Mapping relation.
	*
	* The button should only exist if bpjsDoctorMappingMultiCrudActive is true
	*/
	it ('Renders BPJS Doctor Mapping Add Entity button in create mode', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Doctor Mapping', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(actualBpjsDoctorMappingRemoveButtonCount).toEqual(initialBpjsDoctorMappingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Doctor Mapping button', () => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDoctorMappingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			expect(actualBpjsDoctorMappingRemoveButtons.length).toEqual(initialBpjsDoctorMappingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Doctor Mapping button when one has already been added', () => {

		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDoctorMappingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

			expect(updatedbpjsDoctorMappingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Doctor Mapping entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDoctorMappingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(bpjsDoctorMappingRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Health Facility relation.
	*
	* The button should only exist if bpjsHealthFacilityMultiCrudActive is true
	*/
	it ('Renders BPJS Health Facility Add Entity button in create mode', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Health Facility', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(actualBpjsHealthFacilityRemoveButtonCount).toEqual(initialBpjsHealthFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Health Facility button', () => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsHealthFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			expect(actualBpjsHealthFacilityRemoveButtons.length).toEqual(initialBpjsHealthFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Health Facility button when one has already been added', () => {

		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsHealthFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

			expect(updatedbpjsHealthFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Health Facility entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsHealthFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(bpjsHealthFacilityRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Procedure relation.
	*
	* The button should only exist if bpjsProcedureMultiCrudActive is true
	*/
	it ('Renders BPJS Procedure Add Entity button in create mode', fakeAsync(() => {
		const bpjsProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsProcedureDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsProcedureButton).toEqual(component.bpjsProcedureMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Procedure', fakeAsync(() => {
		const bpjsProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsProcedureButton).toEqual(component.bpjsProcedureMultiCrudActive);

		if (component.bpjsProcedureMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsProcedureDisplayName + ' from Model')).length;

			bpjsProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsProcedureDisplayName + ' from Model')).length;

			expect(actualBpjsProcedureRemoveButtonCount).toEqual(initialBpjsProcedureRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Procedure button', () => {
		const bpjsProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsProcedureButton).toEqual(component.bpjsProcedureMultiCrudActive);

		if (component.bpjsProcedureMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsProcedureButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsProcedureDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsProcedureRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsProcedureDisplayName + ' from Model'));

			expect(actualBpjsProcedureRemoveButtons.length).toEqual(initialBpjsProcedureRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Procedure button when one has already been added', () => {

		const bpjsProcedureButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsProcedureButton).toEqual(component.bpjsProcedureMultiCrudActive);

		if (component.bpjsProcedureMultiCrudActive) {
			bpjsProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsProcedureButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsProcedureDisplayName + ' to Model'));

			expect(updatedbpjsProcedureButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Procedure entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsProcedureMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsProcedureRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsProcedureDisplayName + ' from Model')).length;

			expect(bpjsProcedureRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Service Mapping relation.
	*
	* The button should only exist if bpjsServiceMappingMultiCrudActive is true
	*/
	it ('Renders BPJS Service Mapping Add Entity button in create mode', fakeAsync(() => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Service Mapping', fakeAsync(() => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsServiceMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsServiceMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			expect(actualBpjsServiceMappingRemoveButtonCount).toEqual(initialBpjsServiceMappingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Service Mapping button', () => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsServiceMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsServiceMappingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsServiceMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model'));

			expect(actualBpjsServiceMappingRemoveButtons.length).toEqual(initialBpjsServiceMappingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Service Mapping button when one has already been added', () => {

		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsServiceMappingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

			expect(updatedbpjsServiceMappingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Service Mapping entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsServiceMappingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsServiceMappingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			expect(bpjsServiceMappingRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Patient General Info relation.
	*
	* The button should only exist if patientGeneralInfoMultiCrudActive is true
	*/
	it ('Renders Patient General Info Add Entity button in create mode', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient General Info', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(actualPatientGeneralInfoRemoveButtonCount).toEqual(initialPatientGeneralInfoRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient General Info button', () => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientGeneralInfoRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			expect(actualPatientGeneralInfoRemoveButtons.length).toEqual(initialPatientGeneralInfoRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient General Info button when one has already been added', () => {

		const patientGeneralInfoButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientGeneralInfoButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

			expect(updatedpatientGeneralInfoButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient General Info entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientGeneralInfoMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientGeneralInfoRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(patientGeneralInfoRemoveButtonCount).toEqual(1);
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
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
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

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Dismissal Conditions relation.
	*
	* The button should only exist if bpjsDismissalConditionsMultiCrudActive is true
	*/
	it ('Renders BPJS Dismissal Conditions Add Entity button in create mode', fakeAsync(() => {
		const bpjsDismissalConditionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalConditionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDismissalConditionsButton).toEqual(component.bpjsDismissalConditionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Dismissal Conditions', fakeAsync(() => {
		const bpjsDismissalConditionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalConditionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalConditionsButton).toEqual(component.bpjsDismissalConditionsMultiCrudActive);

		if (component.bpjsDismissalConditionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDismissalConditionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalConditionsDisplayName + ' from Model')).length;

			bpjsDismissalConditionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDismissalConditionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalConditionsDisplayName + ' from Model')).length;

			expect(actualBpjsDismissalConditionsRemoveButtonCount).toEqual(initialBpjsDismissalConditionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Dismissal Conditions button', () => {
		const bpjsDismissalConditionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalConditionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalConditionsButton).toEqual(component.bpjsDismissalConditionsMultiCrudActive);

		if (component.bpjsDismissalConditionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDismissalConditionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDismissalConditionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalConditionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDismissalConditionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDismissalConditionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalConditionsDisplayName + ' from Model'));

			expect(actualBpjsDismissalConditionsRemoveButtons.length).toEqual(initialBpjsDismissalConditionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Dismissal Conditions button when one has already been added', () => {

		const bpjsDismissalConditionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalConditionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalConditionsButton).toEqual(component.bpjsDismissalConditionsMultiCrudActive);

		if (component.bpjsDismissalConditionsMultiCrudActive) {
			bpjsDismissalConditionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDismissalConditionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalConditionsDisplayName + ' to Model'));

			expect(updatedbpjsDismissalConditionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Dismissal Conditions entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDismissalConditionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDismissalConditionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalConditionsDisplayName + ' from Model')).length;

			expect(bpjsDismissalConditionsRemoveButtonCount).toEqual(bpjsClaimSubmissionWithId.bpjsDismissalConditions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Dismissal Mappings relation.
	*
	* The button should only exist if bpjsDismissalMappingsMultiCrudActive is true
	*/
	it ('Renders BPJS Dismissal Mappings Add Entity button in create mode', fakeAsync(() => {
		const bpjsDismissalMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalMappingsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDismissalMappingsButton).toEqual(component.bpjsDismissalMappingsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Dismissal Mappings', fakeAsync(() => {
		const bpjsDismissalMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalMappingsButton).toEqual(component.bpjsDismissalMappingsMultiCrudActive);

		if (component.bpjsDismissalMappingsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDismissalMappingsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalMappingsDisplayName + ' from Model')).length;

			bpjsDismissalMappingsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDismissalMappingsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalMappingsDisplayName + ' from Model')).length;

			expect(actualBpjsDismissalMappingsRemoveButtonCount).toEqual(initialBpjsDismissalMappingsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Dismissal Mappings button', () => {
		const bpjsDismissalMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalMappingsButton).toEqual(component.bpjsDismissalMappingsMultiCrudActive);

		if (component.bpjsDismissalMappingsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDismissalMappingsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDismissalMappingsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalMappingsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDismissalMappingsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDismissalMappingsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalMappingsDisplayName + ' from Model'));

			expect(actualBpjsDismissalMappingsRemoveButtons.length).toEqual(initialBpjsDismissalMappingsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Dismissal Mappings button when one has already been added', () => {

		const bpjsDismissalMappingsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDismissalMappingsButton).toEqual(component.bpjsDismissalMappingsMultiCrudActive);

		if (component.bpjsDismissalMappingsMultiCrudActive) {
			bpjsDismissalMappingsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDismissalMappingsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDismissalMappingsDisplayName + ' to Model'));

			expect(updatedbpjsDismissalMappingsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Dismissal Mappings entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDismissalMappingsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDismissalMappingsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDismissalMappingsDisplayName + ' from Model')).length;

			expect(bpjsDismissalMappingsRemoveButtonCount).toEqual(bpjsClaimSubmissionWithId.bpjsDismissalMappings.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Treatment Rooms relation.
	*
	* The button should only exist if bpjsTreatmentRoomsMultiCrudActive is true
	*/
	it ('Renders BPJS Treatment Rooms Add Entity button in create mode', fakeAsync(() => {
		const bpjsTreatmentRoomsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsTreatmentRoomsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsTreatmentRoomsButton).toEqual(component.bpjsTreatmentRoomsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Treatment Rooms', fakeAsync(() => {
		const bpjsTreatmentRoomsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsTreatmentRoomsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsTreatmentRoomsButton).toEqual(component.bpjsTreatmentRoomsMultiCrudActive);

		if (component.bpjsTreatmentRoomsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsTreatmentRoomsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsTreatmentRoomsDisplayName + ' from Model')).length;

			bpjsTreatmentRoomsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsTreatmentRoomsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsTreatmentRoomsDisplayName + ' from Model')).length;

			expect(actualBpjsTreatmentRoomsRemoveButtonCount).toEqual(initialBpjsTreatmentRoomsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Treatment Rooms button', () => {
		const bpjsTreatmentRoomsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsTreatmentRoomsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsTreatmentRoomsButton).toEqual(component.bpjsTreatmentRoomsMultiCrudActive);

		if (component.bpjsTreatmentRoomsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsTreatmentRoomsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsTreatmentRoomsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsTreatmentRoomsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsTreatmentRoomsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsTreatmentRoomsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsTreatmentRoomsDisplayName + ' from Model'));

			expect(actualBpjsTreatmentRoomsRemoveButtons.length).toEqual(initialBpjsTreatmentRoomsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Treatment Rooms button when one has already been added', () => {

		const bpjsTreatmentRoomsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsTreatmentRoomsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsTreatmentRoomsButton).toEqual(component.bpjsTreatmentRoomsMultiCrudActive);

		if (component.bpjsTreatmentRoomsMultiCrudActive) {
			bpjsTreatmentRoomsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsTreatmentRoomsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsTreatmentRoomsDisplayName + ' to Model'));

			expect(updatedbpjsTreatmentRoomsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Treatment Rooms entities from model when loading in edit mode', () => {
		component.targetModel = bpjsClaimSubmissionWithId;
		component.targetModelId = bpjsClaimSubmissionWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsTreatmentRoomsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsTreatmentRoomsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsTreatmentRoomsDisplayName + ' from Model')).length;

			expect(bpjsTreatmentRoomsRemoveButtonCount).toEqual(bpjsClaimSubmissionWithId.bpjsTreatmentRooms.length);
		}
	});

});
