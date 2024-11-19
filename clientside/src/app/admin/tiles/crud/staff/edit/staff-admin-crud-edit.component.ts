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

import {Component, EventEmitter, Input, OnChanges, OnInit, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subject, Subscription} from 'rxjs';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import {debounceTime, distinctUntilChanged, map, filter} from 'rxjs/operators';
import {Store, Action as NgRxAction} from '@ngrx/store';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {Group, ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import * as modelAction from 'src/app/models/staff/staff.model.action';
import {StaffModelState, StaffModelAudit} from 'src/app/models/staff/staff.model.state';
import {StaffModel} from 'src/app/models/staff/staff.model';
import {
	getStaffModelAuditsByEntityId,
	getStaffModelWithId,
	getCountStaffModels,
} from 'src/app/models/staff/staff.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {AdministrationUserModel} from 'src/app/models/administrationUser/administration_user.model';
import * as administrationUserModelAction from 'src/app/models/administrationUser/administration_user.model.action';
import {
	getAdministrationUserCollectionModels, getAdministrationUserModelWithId,
} from 'src/app/models/administrationUser/administration_user.model.selector';
import {AdministratorModel} from 'src/app/models/administrator/administrator.model';
import * as administratorModelAction from 'src/app/models/administrator/administrator.model.action';
import {
	getAdministratorCollectionModels, getAdministratorModelWithId,
} from 'src/app/models/administrator/administrator.model.selector';
import {AmendmentDetailModel} from 'src/app/models/amendmentDetail/amendment_detail.model';
import * as amendmentDetailModelAction from 'src/app/models/amendmentDetail/amendment_detail.model.action';
import {
	getAmendmentDetailCollectionModels, getAmendmentDetailModelWithId,
} from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import {BpjsDoctorMappingModel} from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import * as bpjsDoctorMappingModelAction from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.action';
import {
	getBpjsDoctorMappingCollectionModels, getBpjsDoctorMappingModelWithId,
} from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import {CashReceiptModel} from 'src/app/models/cashReceipt/cash_receipt.model';
import * as cashReceiptModelAction from 'src/app/models/cashReceipt/cash_receipt.model.action';
import {
	getCashReceiptCollectionModels, getCashReceiptModelWithId,
} from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import {CashierUserModel} from 'src/app/models/cashierUser/cashier_user.model';
import * as cashierUserModelAction from 'src/app/models/cashierUser/cashier_user.model.action';
import {
	getCashierUserCollectionModels, getCashierUserModelWithId,
} from 'src/app/models/cashierUser/cashier_user.model.selector';
import {ClaimUserModel} from 'src/app/models/claimUser/claim_user.model';
import * as claimUserModelAction from 'src/app/models/claimUser/claim_user.model.action';
import {
	getClaimUserCollectionModels, getClaimUserModelWithId,
} from 'src/app/models/claimUser/claim_user.model.selector';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import * as coTreatingDoctorModelAction from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.action';
import {
	getCoTreatingDoctorCollectionModels, getCoTreatingDoctorModelWithId,
} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import * as dailyCareCPPTModelAction from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.action';
import {
	getDailyCareCPPTCollectionModels, getDailyCareCPPTModelWithId,
} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import {DeliveryMedicalExaminationRecordModel} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import * as deliveryMedicalExaminationRecordModelAction from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.action';
import {
	getDeliveryMedicalExaminationRecordCollectionModels, getDeliveryMedicalExaminationRecordModelWithId,
} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import {DeliveryProgressModel} from 'src/app/models/deliveryProgress/delivery_progress.model';
import * as deliveryProgressModelAction from 'src/app/models/deliveryProgress/delivery_progress.model.action';
import {
	getDeliveryProgressCollectionModels, getDeliveryProgressModelWithId,
} from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import {DiagnosticStaffExaminationSummaryModel} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import * as diagnosticStaffExaminationSummaryModelAction from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.action';
import {
	getDiagnosticStaffExaminationSummaryCollectionModels, getDiagnosticStaffExaminationSummaryModelWithId,
} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import {DiagnosticSupportUserModel} from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model';
import * as diagnosticSupportUserModelAction from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.action';
import {
	getDiagnosticSupportUserCollectionModels, getDiagnosticSupportUserModelWithId,
} from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.selector';
import {DoctorScheduleModel} from 'src/app/models/doctorSchedule/doctor_schedule.model';
import * as doctorScheduleModelAction from 'src/app/models/doctorSchedule/doctor_schedule.model.action';
import {
	getDoctorScheduleCollectionModels, getDoctorScheduleModelWithId,
} from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import {DoctorUserModel} from 'src/app/models/doctorUser/doctor_user.model';
import * as doctorUserModelAction from 'src/app/models/doctorUser/doctor_user.model.action';
import {
	getDoctorUserCollectionModels, getDoctorUserModelWithId,
} from 'src/app/models/doctorUser/doctor_user.model.selector';
import {FacilityUserModel} from 'src/app/models/facilityUser/facility_user.model';
import * as facilityUserModelAction from 'src/app/models/facilityUser/facility_user.model.action';
import {
	getFacilityUserCollectionModels, getFacilityUserModelWithId,
} from 'src/app/models/facilityUser/facility_user.model.selector';
import {FluidBalanceDetailModel} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import * as fluidBalanceDetailModelAction from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.action';
import {
	getFluidBalanceDetailCollectionModels, getFluidBalanceDetailModelWithId,
} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import {HemodialysisMonitoringModel} from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model';
import * as hemodialysisMonitoringModelAction from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.action';
import {
	getHemodialysisMonitoringCollectionModels, getHemodialysisMonitoringModelWithId,
} from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import {HospitalBranchInformationModel} from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import * as hospitalBranchInformationModelAction from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.action';
import {
	getHospitalBranchInformationCollectionModels, getHospitalBranchInformationModelWithId,
} from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import * as informedConsentModelAction from 'src/app/models/informedConsent/informed_consent.model.action';
import {
	getInformedConsentCollectionModels, getInformedConsentModelWithId,
} from 'src/app/models/informedConsent/informed_consent.model.selector';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import * as invoiceModelAction from 'src/app/models/invoice/invoice.model.action';
import {
	getInvoiceCollectionModels, getInvoiceModelWithId,
} from 'src/app/models/invoice/invoice.model.selector';
import {McuPackageItemModel} from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import * as mcuPackageItemModelAction from 'src/app/models/mcuPackageItem/mcu_package_item.model.action';
import {
	getMcuPackageItemCollectionModels, getMcuPackageItemModelWithId,
} from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import {ManagementUserModel} from 'src/app/models/managementUser/management_user.model';
import * as managementUserModelAction from 'src/app/models/managementUser/management_user.model.action';
import {
	getManagementUserCollectionModels, getManagementUserModelWithId,
} from 'src/app/models/managementUser/management_user.model.selector';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import * as medicalCertificateDischargeResumeModelAction from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.action';
import {
	getMedicalCertificateDischargeResumeCollectionModels, getMedicalCertificateDischargeResumeModelWithId,
} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import {MedicalCertificateBirthModel} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import * as medicalCertificateBirthModelAction from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.action';
import {
	getMedicalCertificateBirthCollectionModels, getMedicalCertificateBirthModelWithId,
} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import {MedicalCertificateHospitalizationModel} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import * as medicalCertificateHospitalizationModelAction from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.action';
import {
	getMedicalCertificateHospitalizationCollectionModels, getMedicalCertificateHospitalizationModelWithId,
} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import {MedicalCertificateMedicalAttendanceModel} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import * as medicalCertificateMedicalAttendanceModelAction from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.action';
import {
	getMedicalCertificateMedicalAttendanceCollectionModels, getMedicalCertificateMedicalAttendanceModelWithId,
} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import {MedicalCertificateMentalHealthModel} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import * as medicalCertificateMentalHealthModelAction from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.action';
import {
	getMedicalCertificateMentalHealthCollectionModels, getMedicalCertificateMentalHealthModelWithId,
} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import {MedicalCertificatePhysicalHealthModel} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import * as medicalCertificatePhysicalHealthModelAction from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.action';
import {
	getMedicalCertificatePhysicalHealthCollectionModels, getMedicalCertificatePhysicalHealthModelWithId,
} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import {MedicalCertificateRestrictedWorkModel} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import * as medicalCertificateRestrictedWorkModelAction from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.action';
import {
	getMedicalCertificateRestrictedWorkCollectionModels, getMedicalCertificateRestrictedWorkModelWithId,
} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import {MedicalCertificateSickLeaveModel} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import * as medicalCertificateSickLeaveModelAction from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.action';
import {
	getMedicalCertificateSickLeaveCollectionModels, getMedicalCertificateSickLeaveModelWithId,
} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import * as medicalExaminationRecordModelAction from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.action';
import {
	getMedicalExaminationRecordCollectionModels, getMedicalExaminationRecordModelWithId,
} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import {MedicalExaminationRecordDischargeSummaryModel} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import * as medicalExaminationRecordDischargeSummaryModelAction from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.action';
import {
	getMedicalExaminationRecordDischargeSummaryCollectionModels, getMedicalExaminationRecordDischargeSummaryModelWithId,
} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import {MedicalRecordUserModel} from 'src/app/models/medicalRecordUser/medical_record_user.model';
import * as medicalRecordUserModelAction from 'src/app/models/medicalRecordUser/medical_record_user.model.action';
import {
	getMedicalRecordUserCollectionModels, getMedicalRecordUserModelWithId,
} from 'src/app/models/medicalRecordUser/medical_record_user.model.selector';
import {MedicalTranscriberUserModel} from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model';
import * as medicalTranscriberUserModelAction from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.action';
import {
	getMedicalTranscriberUserCollectionModels, getMedicalTranscriberUserModelWithId,
} from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.selector';
import {MedicationAdministeredHistoryModel} from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model';
import * as medicationAdministeredHistoryModelAction from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.action';
import {
	getMedicationAdministeredHistoryCollectionModels, getMedicationAdministeredHistoryModelWithId,
} from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.selector';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import * as medicationHeaderModelAction from 'src/app/models/medicationHeader/medication_header.model.action';
import {
	getMedicationHeaderCollectionModels, getMedicationHeaderModelWithId,
} from 'src/app/models/medicationHeader/medication_header.model.selector';
import {NewbornDetailModel} from 'src/app/models/newbornDetail/newborn_detail.model';
import * as newbornDetailModelAction from 'src/app/models/newbornDetail/newborn_detail.model.action';
import {
	getNewbornDetailCollectionModels, getNewbornDetailModelWithId,
} from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import {NurseUserModel} from 'src/app/models/nurseUser/nurse_user.model';
import * as nurseUserModelAction from 'src/app/models/nurseUser/nurse_user.model.action';
import {
	getNurseUserCollectionModels, getNurseUserModelWithId,
} from 'src/app/models/nurseUser/nurse_user.model.selector';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import * as operatingTheaterMedicalExaminationRecordModelAction from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.action';
import {
	getOperatingTheaterMedicalExaminationRecordCollectionModels, getOperatingTheaterMedicalExaminationRecordModelWithId,
} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import {PcareDokterModel} from 'src/app/models/pcareDokter/pcare_dokter.model';
import * as pcareDokterModelAction from 'src/app/models/pcareDokter/pcare_dokter.model.action';
import {
	getPcareDokterCollectionModels, getPcareDokterModelWithId,
} from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import {PatientConsentModel} from 'src/app/models/patientConsent/patient_consent.model';
import * as patientConsentModelAction from 'src/app/models/patientConsent/patient_consent.model.action';
import {
	getPatientConsentCollectionModels, getPatientConsentModelWithId,
} from 'src/app/models/patientConsent/patient_consent.model.selector';
import {PatientVitalInformationModel} from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import * as patientVitalInformationModelAction from 'src/app/models/patientVitalInformation/patient_vital_information.model.action';
import {
	getPatientVitalInformationCollectionModels, getPatientVitalInformationModelWithId,
} from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import {PharmacyUserModel} from 'src/app/models/pharmacyUser/pharmacy_user.model';
import * as pharmacyUserModelAction from 'src/app/models/pharmacyUser/pharmacy_user.model.action';
import {
	getPharmacyUserCollectionModels, getPharmacyUserModelWithId,
} from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import * as preoperativeRecordsModelAction from 'src/app/models/preoperativeRecords/preoperative_records.model.action';
import {
	getPreoperativeRecordsCollectionModels, getPreoperativeRecordsModelWithId,
} from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import * as prescriptionHeaderModelAction from 'src/app/models/prescriptionHeader/prescription_header.model.action';
import {
	getPrescriptionHeaderCollectionModels, getPrescriptionHeaderModelWithId,
} from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import {ProcessWorkflowModel} from 'src/app/models/processWorkflow/process_workflow.model';
import * as processWorkflowModelAction from 'src/app/models/processWorkflow/process_workflow.model.action';
import {
	getProcessWorkflowCollectionModels, getProcessWorkflowModelWithId,
} from 'src/app/models/processWorkflow/process_workflow.model.selector';
import {PurchasingUserModel} from 'src/app/models/purchasingUser/purchasing_user.model';
import * as purchasingUserModelAction from 'src/app/models/purchasingUser/purchasing_user.model.action';
import {
	getPurchasingUserCollectionModels, getPurchasingUserModelWithId,
} from 'src/app/models/purchasingUser/purchasing_user.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {RegistrationUserModel} from 'src/app/models/registrationUser/registration_user.model';
import * as registrationUserModelAction from 'src/app/models/registrationUser/registration_user.model.action';
import {
	getRegistrationUserCollectionModels, getRegistrationUserModelWithId,
} from 'src/app/models/registrationUser/registration_user.model.selector';
import {RoomTransferModel} from 'src/app/models/roomTransfer/room_transfer.model';
import * as roomTransferModelAction from 'src/app/models/roomTransfer/room_transfer.model.action';
import {
	getRoomTransferCollectionModels, getRoomTransferModelWithId,
} from 'src/app/models/roomTransfer/room_transfer.model.selector';
import {SampleCollectionItemsModel} from 'src/app/models/sampleCollectionItems/sample_collection_items.model';
import * as sampleCollectionItemsModelAction from 'src/app/models/sampleCollectionItems/sample_collection_items.model.action';
import {
	getSampleCollectionItemsCollectionModels, getSampleCollectionItemsModelWithId,
} from 'src/app/models/sampleCollectionItems/sample_collection_items.model.selector';
import {ServiceModel} from 'src/app/models/service/service.model';
import * as serviceModelAction from 'src/app/models/service/service.model.action';
import {
	getServiceCollectionModels, getServiceModelWithId,
} from 'src/app/models/service/service.model.selector';
import {SystemAdminUserModel} from 'src/app/models/systemAdminUser/system_admin_user.model';
import * as systemAdminUserModelAction from 'src/app/models/systemAdminUser/system_admin_user.model.action';
import {
	getSystemAdminUserCollectionModels, getSystemAdminUserModelWithId,
} from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import {TransferOrderStockDetailModel} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import * as transferOrderStockDetailModelAction from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.action';
import {
	getTransferOrderStockDetailCollectionModels, getTransferOrderStockDetailModelWithId,
} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import {VaccinationOrderModel} from 'src/app/models/vaccinationOrder/vaccination_order.model';
import * as vaccinationOrderModelAction from 'src/app/models/vaccinationOrder/vaccination_order.model.action';
import {
	getVaccinationOrderCollectionModels, getVaccinationOrderModelWithId,
} from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import {WarehouseUserModel} from 'src/app/models/warehouseUser/warehouse_user.model';
import * as warehouseUserModelAction from 'src/app/models/warehouseUser/warehouse_user.model.action';
import {
	getWarehouseUserCollectionModels, getWarehouseUserModelWithId,
} from 'src/app/models/warehouseUser/warehouse_user.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../staff-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-staff-admin-crud-edit',
	templateUrl: './staff-admin-crud-edit.component.html',
	styleUrls: [
		'./staff-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminStaffCrudEditComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnChanges, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	/************************************************************************
	 *	   _____             __ _         ______ _      _     _
	 *  / ____|           / _(_)       |  ____(_)    | |   | |
	 * | |     ___  _ __ | |_ _  __ _  | |__   _  ___| | __| |___
	 * | |    / _ \| '_ \|  _| |/ _` | |  __| | |/ _ \ |/ _` / __|
	 * | |___| (_) | | | | | | | (_| | | |    | |  __/ | (_| \__ \
	 *  \_____\___/|_| |_|_| |_|\__, | |_|    |_|\___|_|\__,_|___/
	 *                           __/ |
	 *                          |___/
	 ************************************************************************/
	/**
	 * Whether route component
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether in create/edit/view mode
	 * Only used when singlePageComponent is turned on
	 * Routing will overwrite this according to the url path
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.Create;

	/**
	 * Id of entity to display
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 *
	 */
	@Input()
	collectionId: string = '8f257cf4-7e6a-4b9e-b8f8-403fd34b6479';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	/**
	 * Whether componet is view only
	 */
	get isViewOnly(): boolean {
		return this.tileMode === CrudTileMode.View;
	}

	/**
	 * Entity audits to be fetched from the server.
	 */
	staffAudits$: Observable<StaffModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Administrator here] off begin
	administratorMultiCrudActive: boolean = false;
	administratorDisplayName = 'Administrator';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Administrator here] end
	administratorOppositeRelation = 'staff';
	administratorRelations: ModelRelation[] = this.administratorMultiCrudActive ? AdministratorModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.administratorOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and BPJS Doctor Mapping here] off begin
	bpjsDoctorMappingMultiCrudActive: boolean = false;
	bpjsDoctorMappingDisplayName = 'BPJS Doctor Mapping';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and BPJS Doctor Mapping here] end
	bpjsDoctorMappingOppositeRelation = 'staff';
	bpjsDoctorMappingRelations: ModelRelation[] = this.bpjsDoctorMappingMultiCrudActive ? BpjsDoctorMappingModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDoctorMappingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and PCare Dokter here] off begin
	pcareDokterMultiCrudActive: boolean = false;
	pcareDokterDisplayName = 'PCare Dokter';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and PCare Dokter here] end
	pcareDokterOppositeRelation = 'staff';
	pcareDokterRelations: ModelRelation[] = this.pcareDokterMultiCrudActive ? PcareDokterModel.getRelations()
		.map(relation => {
			if (relation.id === this.pcareDokterOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Default Medical Staff and Service here] off begin
	serviceMultiCrudActive: boolean = false;
	serviceDisplayName = 'Service';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Default Medical Staff and Service here] end
	serviceOppositeRelation = 'defaultMedicalStaff';
	serviceRelations: ModelRelation[] = this.serviceMultiCrudActive ? ServiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.serviceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Administration User and Staff here] off begin
	administrationUserMultiCrudActive: boolean = false;
	administrationUserDisplayName = 'Administration User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Administration User and Staff here] end
	administrationUserOppositeRelation = 'staff';
	administrationUserRelations: ModelRelation[] = this.administrationUserMultiCrudActive ? AdministrationUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.administrationUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Cashier User and Staff here] off begin
	cashierUserMultiCrudActive: boolean = false;
	cashierUserDisplayName = 'Cashier User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Cashier User and Staff here] end
	cashierUserOppositeRelation = 'staff';
	cashierUserRelations: ModelRelation[] = this.cashierUserMultiCrudActive ? CashierUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.cashierUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Claim User and Staff here] off begin
	claimUserMultiCrudActive: boolean = false;
	claimUserDisplayName = 'Claim User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Claim User and Staff here] end
	claimUserOppositeRelation = 'staff';
	claimUserRelations: ModelRelation[] = this.claimUserMultiCrudActive ? ClaimUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.claimUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnostic Support User and Staff here] off begin
	diagnosticSupportUserMultiCrudActive: boolean = false;
	diagnosticSupportUserDisplayName = 'Diagnostic Support User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnostic Support User and Staff here] end
	diagnosticSupportUserOppositeRelation = 'staff';
	diagnosticSupportUserRelations: ModelRelation[] = this.diagnosticSupportUserMultiCrudActive ? DiagnosticSupportUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.diagnosticSupportUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor User and Staff here] off begin
	doctorUserMultiCrudActive: boolean = false;
	doctorUserDisplayName = 'Doctor User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor User and Staff here] end
	doctorUserOppositeRelation = 'staff';
	doctorUserRelations: ModelRelation[] = this.doctorUserMultiCrudActive ? DoctorUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.doctorUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Facility User and Staff here] off begin
	facilityUserMultiCrudActive: boolean = false;
	facilityUserDisplayName = 'Facility User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Facility User and Staff here] end
	facilityUserOppositeRelation = 'staff';
	facilityUserRelations: ModelRelation[] = this.facilityUserMultiCrudActive ? FacilityUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.facilityUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Management User and Staff here] off begin
	managementUserMultiCrudActive: boolean = false;
	managementUserDisplayName = 'Management User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Management User and Staff here] end
	managementUserOppositeRelation = 'staff';
	managementUserRelations: ModelRelation[] = this.managementUserMultiCrudActive ? ManagementUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.managementUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Record user and Staff here] off begin
	medicalRecordUserMultiCrudActive: boolean = false;
	medicalRecordUserDisplayName = 'Medical Record user';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Record user and Staff here] end
	medicalRecordUserOppositeRelation = 'staff';
	medicalRecordUserRelations: ModelRelation[] = this.medicalRecordUserMultiCrudActive ? MedicalRecordUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.medicalRecordUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber User and Staff here] off begin
	medicalTranscriberUserMultiCrudActive: boolean = false;
	medicalTranscriberUserDisplayName = 'Medical Transcriber User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber User and Staff here] end
	medicalTranscriberUserOppositeRelation = 'staff';
	medicalTranscriberUserRelations: ModelRelation[] = this.medicalTranscriberUserMultiCrudActive ? MedicalTranscriberUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.medicalTranscriberUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse User and Staff here] off begin
	nurseUserMultiCrudActive: boolean = false;
	nurseUserDisplayName = 'Nurse User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse User and Staff here] end
	nurseUserOppositeRelation = 'staff';
	nurseUserRelations: ModelRelation[] = this.nurseUserMultiCrudActive ? NurseUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.nurseUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pharmacy User and Staff here] off begin
	pharmacyUserMultiCrudActive: boolean = false;
	pharmacyUserDisplayName = 'Pharmacy User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pharmacy User and Staff here] end
	pharmacyUserOppositeRelation = 'staff';
	pharmacyUserRelations: ModelRelation[] = this.pharmacyUserMultiCrudActive ? PharmacyUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.pharmacyUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Purchasing User and Staff here] off begin
	purchasingUserMultiCrudActive: boolean = false;
	purchasingUserDisplayName = 'Purchasing User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Purchasing User and Staff here] end
	purchasingUserOppositeRelation = 'staff';
	purchasingUserRelations: ModelRelation[] = this.purchasingUserMultiCrudActive ? PurchasingUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.purchasingUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration User and Staff here] off begin
	registrationUserMultiCrudActive: boolean = false;
	registrationUserDisplayName = 'Registration User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration User and Staff here] end
	registrationUserOppositeRelation = 'staff';
	registrationUserRelations: ModelRelation[] = this.registrationUserMultiCrudActive ? RegistrationUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.registrationUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between System Admin User and Staff here] off begin
	systemAdminUserMultiCrudActive: boolean = false;
	systemAdminUserDisplayName = 'System Admin User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between System Admin User and Staff here] end
	systemAdminUserOppositeRelation = 'staff';
	systemAdminUserRelations: ModelRelation[] = this.systemAdminUserMultiCrudActive ? SystemAdminUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.systemAdminUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse User and Staff here] off begin
	warehouseUserMultiCrudActive: boolean = false;
	warehouseUserDisplayName = 'Warehouse User';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Warehouse User and Staff here] end
	warehouseUserOppositeRelation = 'staff';
	warehouseUserRelations: ModelRelation[] = this.warehouseUserMultiCrudActive ? WarehouseUserModel.getRelations()
		.filter(r => r.entityName != 'RoleModel')
		.map(relation => {
			if (relation.id === this.warehouseUserOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Accompanying Staff and Accompanying Consents here] off begin
	accompanyingConsentsMultiCrudActive: boolean = false;
	accompanyingConsentsDisplayName = 'Accompanying Consents';
	accompanyingConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Accompanying Staff and Accompanying Consents here] end
	accompanyingConsentsOppositeRelation = 'accompanyingStaff';
	accompanyingConsentsRelations: ModelRelation[] = this.accompanyingConsentsMultiCrudActive ? InformedConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.accompanyingConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Amendment Details here] off begin
	amendmentDetailsMultiCrudActive: boolean = false;
	amendmentDetailsDisplayName = 'Amendment Details';
	amendmentDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Amendment Details here] end
	amendmentDetailsOppositeRelation = 'staff';
	amendmentDetailsRelations: ModelRelation[] = this.amendmentDetailsMultiCrudActive ? AmendmentDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.amendmentDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesia Medical Transcriber and Anesthesia Medical Transcriber here] off begin
	anesthesiaMedicalTranscriberMultiCrudActive: boolean = false;
	anesthesiaMedicalTranscriberDisplayName = 'Anesthesia Medical Transcriber';
	anesthesiaMedicalTranscriberCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesia Medical Transcriber and Anesthesia Medical Transcriber here] end
	anesthesiaMedicalTranscriberOppositeRelation = 'anesthesiaMedicalTranscriber';
	anesthesiaMedicalTranscriberRelations: ModelRelation[] = this.anesthesiaMedicalTranscriberMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiaMedicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiologist and Anesthesiologist here] off begin
	anesthesiologistMultiCrudActive: boolean = false;
	anesthesiologistDisplayName = 'Anesthesiologist';
	anesthesiologistCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiologist and Anesthesiologist here] end
	anesthesiologistOppositeRelation = 'anesthesiologist';
	anesthesiologistRelations: ModelRelation[] = this.anesthesiologistMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiologistOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiology Nurse and Anesthesiology Nurse here] off begin
	anesthesiologyNurseMultiCrudActive: boolean = false;
	anesthesiologyNurseDisplayName = 'Anesthesiology Nurse';
	anesthesiologyNurseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Anesthesiology Nurse and Anesthesiology Nurse here] end
	anesthesiologyNurseOppositeRelation = 'anesthesiologyNurse';
	anesthesiologyNurseRelations: ModelRelation[] = this.anesthesiologyNurseMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.anesthesiologyNurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Cashier Staff and Cashier Staff here] off begin
	cashierStaffMultiCrudActive: boolean = false;
	cashierStaffDisplayName = 'Cashier Staff';
	cashierStaffCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Cashier Staff and Cashier Staff here] end
	cashierStaffOppositeRelation = 'cashierStaff';
	cashierStaffRelations: ModelRelation[] = this.cashierStaffMultiCrudActive ? CashReceiptModel.getRelations()
		.map(relation => {
			if (relation.id === this.cashierStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Co Treating Doctors here] off begin
	coTreatingDoctorsMultiCrudActive: boolean = false;
	coTreatingDoctorsDisplayName = 'Co Treating Doctors';
	coTreatingDoctorsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Co Treating Doctors here] end
	coTreatingDoctorsOppositeRelation = 'staff';
	coTreatingDoctorsRelations: ModelRelation[] = this.coTreatingDoctorsMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.coTreatingDoctorsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Created By Staff and Daily Care CPPTs Created By Staff here] off begin
	dailyCareCPPTsCreatedByStaffMultiCrudActive: boolean = false;
	dailyCareCPPTsCreatedByStaffDisplayName = 'Daily Care CPPTs Created By Staff';
	dailyCareCPPTsCreatedByStaffCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Created By Staff and Daily Care CPPTs Created By Staff here] end
	dailyCareCPPTsCreatedByStaffOppositeRelation = 'createdByStaff';
	dailyCareCPPTsCreatedByStaffRelations: ModelRelation[] = this.dailyCareCPPTsCreatedByStaffMultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.dailyCareCPPTsCreatedByStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor in Charge and Daily Care CPPTs Doctor in Charge here] off begin
	dailyCareCPPTsDoctorInChargeMultiCrudActive: boolean = false;
	dailyCareCPPTsDoctorInChargeDisplayName = 'Daily Care CPPTs Doctor in Charge';
	dailyCareCPPTsDoctorInChargeCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor in Charge and Daily Care CPPTs Doctor in Charge here] end
	dailyCareCPPTsDoctorInChargeOppositeRelation = 'doctorInCharge';
	dailyCareCPPTsDoctorInChargeRelations: ModelRelation[] = this.dailyCareCPPTsDoctorInChargeMultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.dailyCareCPPTsDoctorInChargeOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Daily Care CPPTs Medical Transcriber here] off begin
	dailyCareCPPTsMedicalTranscriberMultiCrudActive: boolean = false;
	dailyCareCPPTsMedicalTranscriberDisplayName = 'Daily Care CPPTs Medical Transcriber';
	dailyCareCPPTsMedicalTranscriberCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Daily Care CPPTs Medical Transcriber here] end
	dailyCareCPPTsMedicalTranscriberOppositeRelation = 'medicalTranscriber';
	dailyCareCPPTsMedicalTranscriberRelations: ModelRelation[] = this.dailyCareCPPTsMedicalTranscriberMultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.dailyCareCPPTsMedicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Delivery Progresses here] off begin
	deliveryProgressesMultiCrudActive: boolean = false;
	deliveryProgressesDisplayName = 'Delivery Progresses';
	deliveryProgressesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Delivery Progresses here] end
	deliveryProgressesOppositeRelation = 'staff';
	deliveryProgressesRelations: ModelRelation[] = this.deliveryProgressesMultiCrudActive ? DeliveryProgressModel.getRelations()
		.map(relation => {
			if (relation.id === this.deliveryProgressesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Diagnostic Staff Examination Summaries here] off begin
	diagnosticStaffExaminationSummariesMultiCrudActive: boolean = false;
	diagnosticStaffExaminationSummariesDisplayName = 'Diagnostic Staff Examination Summaries';
	diagnosticStaffExaminationSummariesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Diagnostic Staff Examination Summaries here] end
	diagnosticStaffExaminationSummariesOppositeRelation = 'staff';
	diagnosticStaffExaminationSummariesRelations: ModelRelation[] = this.diagnosticStaffExaminationSummariesMultiCrudActive ? DiagnosticStaffExaminationSummaryModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosticStaffExaminationSummariesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Staff and Dismissal Referring Staff here] off begin
	dismissalReferringStaffMultiCrudActive: boolean = false;
	dismissalReferringStaffDisplayName = 'Dismissal Referring Staff';
	dismissalReferringStaffCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Staff and Dismissal Referring Staff here] end
	dismissalReferringStaffOppositeRelation = 'dismissalReferringStaff';
	dismissalReferringStaffRelations: ModelRelation[] = this.dismissalReferringStaffMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.dismissalReferringStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Doctor Schedules here] off begin
	doctorSchedulesMultiCrudActive: boolean = false;
	doctorSchedulesDisplayName = 'Doctor Schedules';
	doctorSchedulesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Doctor Schedules here] end
	doctorSchedulesOppositeRelation = 'staff';
	doctorSchedulesRelations: ModelRelation[] = this.doctorSchedulesMultiCrudActive ? DoctorScheduleModel.getRelations()
		.map(relation => {
			if (relation.id === this.doctorSchedulesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor and Doctor on examination here] off begin
	doctorOnExaminationMultiCrudActive: boolean = false;
	doctorOnExaminationDisplayName = 'Doctor on examination';
	doctorOnExaminationCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor and Doctor on examination here] end
	doctorOnExaminationOppositeRelation = 'doctor';
	doctorOnExaminationRelations: ModelRelation[] = this.doctorOnExaminationMultiCrudActive ? MedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.doctorOnExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Fluid Balance Details here] off begin
	fluidBalanceDetailsMultiCrudActive: boolean = false;
	fluidBalanceDetailsDisplayName = 'Fluid Balance Details';
	fluidBalanceDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Fluid Balance Details here] end
	fluidBalanceDetailsOppositeRelation = 'staff';
	fluidBalanceDetailsRelations: ModelRelation[] = this.fluidBalanceDetailsMultiCrudActive ? FluidBalanceDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.fluidBalanceDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Hemodialysis Monitorings here] off begin
	hemodialysisMonitoringsMultiCrudActive: boolean = false;
	hemodialysisMonitoringsDisplayName = 'Hemodialysis Monitorings';
	hemodialysisMonitoringsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Hemodialysis Monitorings here] end
	hemodialysisMonitoringsOppositeRelation = 'medicalStaff';
	hemodialysisMonitoringsRelations: ModelRelation[] = this.hemodialysisMonitoringsMultiCrudActive ? HemodialysisMonitoringModel.getRelations()
		.map(relation => {
			if (relation.id === this.hemodialysisMonitoringsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Hospital Branch Informations here] off begin
	hospitalBranchInformationsMultiCrudActive: boolean = false;
	hospitalBranchInformationsDisplayName = 'Hospital Branch Informations';
	hospitalBranchInformationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Hospital Branch Informations here] end
	hospitalBranchInformationsOppositeRelation = 'staff';
	hospitalBranchInformationsRelations: ModelRelation[] = this.hospitalBranchInformationsMultiCrudActive ? HospitalBranchInformationModel.getRelations()
		.map(relation => {
			if (relation.id === this.hospitalBranchInformationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Informing Staff and Informing Consents here] off begin
	informingConsentsMultiCrudActive: boolean = false;
	informingConsentsDisplayName = 'Informing Consents';
	informingConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Informing Staff and Informing Consents here] end
	informingConsentsOppositeRelation = 'informingStaff';
	informingConsentsRelations: ModelRelation[] = this.informingConsentsMultiCrudActive ? InformedConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.informingConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Verified By and Invoices here] off begin
	invoicesMultiCrudActive: boolean = false;
	invoicesDisplayName = 'Invoices';
	invoicesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Verified By and Invoices here] end
	invoicesOppositeRelation = 'verifiedBy';
	invoicesRelations: ModelRelation[] = this.invoicesMultiCrudActive ? InvoiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and MCU Package Items here] off begin
	mcuPackageItemsMultiCrudActive: boolean = false;
	mcuPackageItemsDisplayName = 'MCU Package Items';
	mcuPackageItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and MCU Package Items here] end
	mcuPackageItemsOppositeRelation = 'staff';
	mcuPackageItemsRelations: ModelRelation[] = this.mcuPackageItemsMultiCrudActive ? McuPackageItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.mcuPackageItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate  Discharge Resumes here] off begin
	medicalCertificateDischargeResumesMultiCrudActive: boolean = false;
	medicalCertificateDischargeResumesDisplayName = 'Medical Certificate  Discharge Resumes';
	medicalCertificateDischargeResumesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate  Discharge Resumes here] end
	medicalCertificateDischargeResumesOppositeRelation = 'medicalStaff';
	medicalCertificateDischargeResumesRelations: ModelRelation[] = this.medicalCertificateDischargeResumesMultiCrudActive ? MedicalCertificateDischargeResumeModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateDischargeResumesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate Births here] off begin
	medicalCertificateBirthsMultiCrudActive: boolean = false;
	medicalCertificateBirthsDisplayName = 'Medical Certificate Births';
	medicalCertificateBirthsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate Births here] end
	medicalCertificateBirthsOppositeRelation = 'medicalStaff';
	medicalCertificateBirthsRelations: ModelRelation[] = this.medicalCertificateBirthsMultiCrudActive ? MedicalCertificateBirthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateBirthsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate Hospitalizations here] off begin
	medicalCertificateHospitalizationsMultiCrudActive: boolean = false;
	medicalCertificateHospitalizationsDisplayName = 'Medical Certificate Hospitalizations';
	medicalCertificateHospitalizationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Certificate Hospitalizations here] end
	medicalCertificateHospitalizationsOppositeRelation = 'medicalStaff';
	medicalCertificateHospitalizationsRelations: ModelRelation[] = this.medicalCertificateHospitalizationsMultiCrudActive ? MedicalCertificateHospitalizationModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateHospitalizationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharging Doctor and Medical Examination Record Discharge Summarys here] off begin
	medicalExaminationRecordDischargeSummarysMultiCrudActive: boolean = false;
	medicalExaminationRecordDischargeSummarysDisplayName = 'Medical Examination Record Discharge Summarys';
	medicalExaminationRecordDischargeSummarysCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharging Doctor and Medical Examination Record Discharge Summarys here] end
	medicalExaminationRecordDischargeSummarysOppositeRelation = 'dischargingDoctor';
	medicalExaminationRecordDischargeSummarysRelations: ModelRelation[] = this.medicalExaminationRecordDischargeSummarysMultiCrudActive ? MedicalExaminationRecordDischargeSummaryModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalExaminationRecordDischargeSummarysOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Medical Record Transcriber here] off begin
	medicalRecordTranscriberMultiCrudActive: boolean = false;
	medicalRecordTranscriberDisplayName = 'Medical Record Transcriber';
	medicalRecordTranscriberCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Medical Record Transcriber here] end
	medicalRecordTranscriberOppositeRelation = 'medicalTranscriber';
	medicalRecordTranscriberRelations: ModelRelation[] = this.medicalRecordTranscriberMultiCrudActive ? MedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalRecordTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Medical Attendances certificate here] off begin
	medicalStaffOfMedicalAttendancesCertificateMultiCrudActive: boolean = false;
	medicalStaffOfMedicalAttendancesCertificateDisplayName = 'Medical Staff of Medical Attendances certificate';
	medicalStaffOfMedicalAttendancesCertificateCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Medical Attendances certificate here] end
	medicalStaffOfMedicalAttendancesCertificateOppositeRelation = 'medicalStaff';
	medicalStaffOfMedicalAttendancesCertificateRelations: ModelRelation[] = this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive ? MedicalCertificateMedicalAttendanceModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalStaffOfMedicalAttendancesCertificateOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Mental Healths here] off begin
	medicalStaffOfMentalHealthsMultiCrudActive: boolean = false;
	medicalStaffOfMentalHealthsDisplayName = 'Medical Staff of Mental Healths';
	medicalStaffOfMentalHealthsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Mental Healths here] end
	medicalStaffOfMentalHealthsOppositeRelation = 'medicalStaff';
	medicalStaffOfMentalHealthsRelations: ModelRelation[] = this.medicalStaffOfMentalHealthsMultiCrudActive ? MedicalCertificateMentalHealthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalStaffOfMentalHealthsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Physical Healths here] off begin
	medicalStaffOfPhysicalHealthsMultiCrudActive: boolean = false;
	medicalStaffOfPhysicalHealthsDisplayName = 'Medical Staff of Physical Healths';
	medicalStaffOfPhysicalHealthsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Physical Healths here] end
	medicalStaffOfPhysicalHealthsOppositeRelation = 'medicalStaff';
	medicalStaffOfPhysicalHealthsRelations: ModelRelation[] = this.medicalStaffOfPhysicalHealthsMultiCrudActive ? MedicalCertificatePhysicalHealthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalStaffOfPhysicalHealthsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Restricted Works certificate here] off begin
	medicalStaffOfRestrictedWorksCertificateMultiCrudActive: boolean = false;
	medicalStaffOfRestrictedWorksCertificateDisplayName = 'Medical Staff of Restricted Works certificate';
	medicalStaffOfRestrictedWorksCertificateCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Restricted Works certificate here] end
	medicalStaffOfRestrictedWorksCertificateOppositeRelation = 'medicalStaff';
	medicalStaffOfRestrictedWorksCertificateRelations: ModelRelation[] = this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive ? MedicalCertificateRestrictedWorkModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalStaffOfRestrictedWorksCertificateOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Sick Leaves certificate here] off begin
	medicalStaffOfSickLeavesCertificateMultiCrudActive: boolean = false;
	medicalStaffOfSickLeavesCertificateDisplayName = 'Medical Staff of Sick Leaves certificate';
	medicalStaffOfSickLeavesCertificateCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Staff and Medical Staff of Sick Leaves certificate here] end
	medicalStaffOfSickLeavesCertificateOppositeRelation = 'medicalStaff';
	medicalStaffOfSickLeavesCertificateRelations: ModelRelation[] = this.medicalStaffOfSickLeavesCertificateMultiCrudActive ? MedicalCertificateSickLeaveModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalStaffOfSickLeavesCertificateOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Medication Administered Hisotries here] off begin
	medicationAdministeredHisotriesMultiCrudActive: boolean = false;
	medicationAdministeredHisotriesDisplayName = 'Medication Administered Hisotries';
	medicationAdministeredHisotriesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Medication Administered Hisotries here] end
	medicationAdministeredHisotriesOppositeRelation = 'staff';
	medicationAdministeredHisotriesRelations: ModelRelation[] = this.medicationAdministeredHisotriesMultiCrudActive ? MedicationAdministeredHistoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationAdministeredHisotriesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Medication Headers here] off begin
	medicationHeadersMultiCrudActive: boolean = false;
	medicationHeadersDisplayName = 'Medication Headers';
	medicationHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Medication Headers here] end
	medicationHeadersOppositeRelation = 'requestedBy';
	medicationHeadersRelations: ModelRelation[] = this.medicationHeadersMultiCrudActive ? MedicationHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Midwife and Midwives here] off begin
	midwivesMultiCrudActive: boolean = false;
	midwivesDisplayName = 'Midwives';
	midwivesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Midwife and Midwives here] end
	midwivesOppositeRelation = 'midwife';
	midwivesRelations: ModelRelation[] = this.midwivesMultiCrudActive ? DeliveryMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.midwivesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse and Nurse here] off begin
	nurseMultiCrudActive: boolean = false;
	nurseDisplayName = 'Nurse';
	nurseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse and Nurse here] end
	nurseOppositeRelation = 'nurse';
	nurseRelations: ModelRelation[] = this.nurseMultiCrudActive ? MedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.nurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nursing Detail Surgical Nursings and Nursing Detail Surgical Nursing here] off begin
	nursingDetailSurgicalNursingMultiCrudActive: boolean = false;
	nursingDetailSurgicalNursingDisplayName = 'Nursing Detail Surgical Nursing';
	nursingDetailSurgicalNursingCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nursing Detail Surgical Nursings and Nursing Detail Surgical Nursing here] end
	nursingDetailSurgicalNursingOppositeRelation = 'nursingDetailSurgicalNursings';
	nursingDetailSurgicalNursingRelations: ModelRelation[] = this.nursingDetailSurgicalNursingMultiCrudActive ? OperatingTheaterMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.nursingDetailSurgicalNursingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nursing Details Anesthesia Nursings and Nursing Details Anesthesia Nursing here] off begin
	nursingDetailsAnesthesiaNursingMultiCrudActive: boolean = false;
	nursingDetailsAnesthesiaNursingDisplayName = 'Nursing Details Anesthesia Nursing';
	nursingDetailsAnesthesiaNursingCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nursing Details Anesthesia Nursings and Nursing Details Anesthesia Nursing here] end
	nursingDetailsAnesthesiaNursingOppositeRelation = 'nursingDetailsAnesthesiaNursings';
	nursingDetailsAnesthesiaNursingRelations: ModelRelation[] = this.nursingDetailsAnesthesiaNursingMultiCrudActive ? OperatingTheaterMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.nursingDetailsAnesthesiaNursingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Patient Consents here] off begin
	patientConsentsMultiCrudActive: boolean = false;
	patientConsentsDisplayName = 'Patient Consents';
	patientConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Patient Consents here] end
	patientConsentsOppositeRelation = 'staff';
	patientConsentsRelations: ModelRelation[] = this.patientConsentsMultiCrudActive ? PatientConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Patient Vital Informations here] off begin
	patientVitalInformationsMultiCrudActive: boolean = false;
	patientVitalInformationsDisplayName = 'Patient Vital Informations';
	patientVitalInformationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Patient Vital Informations here] end
	patientVitalInformationsOppositeRelation = 'staff';
	patientVitalInformationsRelations: ModelRelation[] = this.patientVitalInformationsMultiCrudActive ? PatientVitalInformationModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVitalInformationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Pediatrician In Charge here] off begin
	pediatricianInChargeMultiCrudActive: boolean = false;
	pediatricianInChargeDisplayName = 'Pediatrician In Charge';
	pediatricianInChargeCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Pediatrician In Charge here] end
	pediatricianInChargeOppositeRelation = 'staff';
	pediatricianInChargeRelations: ModelRelation[] = this.pediatricianInChargeMultiCrudActive ? NewbornDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.pediatricianInChargeOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Prescription Headers here] off begin
	prescriptionHeadersMultiCrudActive: boolean = false;
	prescriptionHeadersDisplayName = 'Prescription Headers';
	prescriptionHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Prescription Headers here] end
	prescriptionHeadersOppositeRelation = 'requestedBy';
	prescriptionHeadersRelations: ModelRelation[] = this.prescriptionHeadersMultiCrudActive ? PrescriptionHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.prescriptionHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Process Workflow Logs here] off begin
	processWorkflowLogsMultiCrudActive: boolean = false;
	processWorkflowLogsDisplayName = 'Process Workflow Logs';
	processWorkflowLogsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Process Workflow Logs here] end
	processWorkflowLogsOppositeRelation = 'staff';
	processWorkflowLogsRelations: ModelRelation[] = this.processWorkflowLogsMultiCrudActive ? ProcessWorkflowModel.getRelations()
		.map(relation => {
			if (relation.id === this.processWorkflowLogsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Registrations here] off begin
	registrationsMultiCrudActive: boolean = false;
	registrationsDisplayName = 'Registrations';
	registrationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Registrations here] end
	registrationsOppositeRelation = 'staff';
	registrationsRelations: ModelRelation[] = this.registrationsMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.registrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Requested By here] off begin
	requestedByMultiCrudActive: boolean = false;
	requestedByDisplayName = 'Requested By';
	requestedByCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Requested By here] end
	requestedByOppositeRelation = 'requestedBy';
	requestedByRelations: ModelRelation[] = this.requestedByMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.requestedByOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transferring Staff and Room Transfers here] off begin
	roomTransfersMultiCrudActive: boolean = false;
	roomTransfersDisplayName = 'Room Transfers';
	roomTransfersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Transferring Staff and Room Transfers here] end
	roomTransfersOppositeRelation = 'transferringStaff';
	roomTransfersRelations: ModelRelation[] = this.roomTransfersMultiCrudActive ? RoomTransferModel.getRelations()
		.map(relation => {
			if (relation.id === this.roomTransfersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Collection Staff and Sample Collection Staffs here] off begin
	sampleCollectionStaffsMultiCrudActive: boolean = false;
	sampleCollectionStaffsDisplayName = 'Sample Collection Staffs';
	sampleCollectionStaffsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Collection Staff and Sample Collection Staffs here] end
	sampleCollectionStaffsOppositeRelation = 'sampleCollectionStaff';
	sampleCollectionStaffsRelations: ModelRelation[] = this.sampleCollectionStaffsMultiCrudActive ? SampleCollectionItemsModel.getRelations()
		.map(relation => {
			if (relation.id === this.sampleCollectionStaffsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Delivery Staff and Sample Delivery Staffs here] off begin
	sampleDeliveryStaffsMultiCrudActive: boolean = false;
	sampleDeliveryStaffsDisplayName = 'Sample Delivery Staffs';
	sampleDeliveryStaffsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Delivery Staff and Sample Delivery Staffs here] end
	sampleDeliveryStaffsOppositeRelation = 'sampleDeliveryStaff';
	sampleDeliveryStaffsRelations: ModelRelation[] = this.sampleDeliveryStaffsMultiCrudActive ? SampleCollectionItemsModel.getRelations()
		.map(relation => {
			if (relation.id === this.sampleDeliveryStaffsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Processing Staff and Sample Processing Staffs here] off begin
	sampleProcessingStaffsMultiCrudActive: boolean = false;
	sampleProcessingStaffsDisplayName = 'Sample Processing Staffs';
	sampleProcessingStaffsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Sample Processing Staff and Sample Processing Staffs here] end
	sampleProcessingStaffsOppositeRelation = 'sampleProcessingStaff';
	sampleProcessingStaffsRelations: ModelRelation[] = this.sampleProcessingStaffsMultiCrudActive ? SampleCollectionItemsModel.getRelations()
		.map(relation => {
			if (relation.id === this.sampleProcessingStaffsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgeon and Surgeon here] off begin
	surgeonMultiCrudActive: boolean = false;
	surgeonDisplayName = 'Surgeon';
	surgeonCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgeon and Surgeon here] end
	surgeonOppositeRelation = 'surgeon';
	surgeonRelations: ModelRelation[] = this.surgeonMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgeonOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Medical Transcriber and Surgical Medical Transcriber here] off begin
	surgicalMedicalTranscriberMultiCrudActive: boolean = false;
	surgicalMedicalTranscriberDisplayName = 'Surgical Medical Transcriber';
	surgicalMedicalTranscriberCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Medical Transcriber and Surgical Medical Transcriber here] end
	surgicalMedicalTranscriberOppositeRelation = 'surgicalMedicalTranscriber';
	surgicalMedicalTranscriberRelations: ModelRelation[] = this.surgicalMedicalTranscriberMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgicalMedicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Nurse and Surgical Nurse here] off begin
	surgicalNurseMultiCrudActive: boolean = false;
	surgicalNurseDisplayName = 'Surgical Nurse';
	surgicalNurseCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Surgical Nurse and Surgical Nurse here] end
	surgicalNurseOppositeRelation = 'surgicalNurse';
	surgicalNurseRelations: ModelRelation[] = this.surgicalNurseMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.surgicalNurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Transfer Order Stock Details here] off begin
	transferOrderStockDetailsMultiCrudActive: boolean = false;
	transferOrderStockDetailsDisplayName = 'Transfer Order Stock Details';
	transferOrderStockDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Transfer Order Stock Details here] end
	transferOrderStockDetailsOppositeRelation = 'staff';
	transferOrderStockDetailsRelations: ModelRelation[] = this.transferOrderStockDetailsMultiCrudActive ? TransferOrderStockDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.transferOrderStockDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Vaccination Orders here] off begin
	vaccinationOrdersMultiCrudActive: boolean = false;
	vaccinationOrdersDisplayName = 'Vaccination Orders';
	vaccinationOrdersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Vaccination Orders here] end
	vaccinationOrdersOppositeRelation = 'staff';
	vaccinationOrdersRelations: ModelRelation[] = this.vaccinationOrdersMultiCrudActive ? VaccinationOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.vaccinationOrdersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Assigned Medical Staff and Services here] off begin
	servicesMultiCrudActive: boolean = false;
	servicesDisplayName = 'Services';
	servicesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Assigned Medical Staff and Services here] end
	servicesOppositeRelation = 'assignedMedicalStaff';
	servicesRelations: ModelRelation[] = this.servicesMultiCrudActive ? ServiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.servicesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = StaffModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = StaffModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = StaffModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'administrator' && this.administratorMultiCrudActive) {
					exp.fields = AdministratorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDoctorMapping' && this.bpjsDoctorMappingMultiCrudActive) {
					exp.fields = BpjsDoctorMappingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'pcareDokter' && this.pcareDokterMultiCrudActive) {
					exp.fields = PcareDokterModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'service' && this.serviceMultiCrudActive) {
					exp.fields = ServiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'administrationUser' && this.administrationUserMultiCrudActive) {
					exp.fields = AdministrationUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'cashierUser' && this.cashierUserMultiCrudActive) {
					exp.fields = CashierUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'claimUser' && this.claimUserMultiCrudActive) {
					exp.fields = ClaimUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosticSupportUser' && this.diagnosticSupportUserMultiCrudActive) {
					exp.fields = DiagnosticSupportUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'doctorUser' && this.doctorUserMultiCrudActive) {
					exp.fields = DoctorUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'facilityUser' && this.facilityUserMultiCrudActive) {
					exp.fields = FacilityUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'managementUser' && this.managementUserMultiCrudActive) {
					exp.fields = ManagementUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalRecordUser' && this.medicalRecordUserMultiCrudActive) {
					exp.fields = MedicalRecordUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalTranscriberUser' && this.medicalTranscriberUserMultiCrudActive) {
					exp.fields = MedicalTranscriberUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nurseUser' && this.nurseUserMultiCrudActive) {
					exp.fields = NurseUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'pharmacyUser' && this.pharmacyUserMultiCrudActive) {
					exp.fields = PharmacyUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'purchasingUser' && this.purchasingUserMultiCrudActive) {
					exp.fields = PurchasingUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'registrationUser' && this.registrationUserMultiCrudActive) {
					exp.fields = RegistrationUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'systemAdminUser' && this.systemAdminUserMultiCrudActive) {
					exp.fields = SystemAdminUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'warehouseUser' && this.warehouseUserMultiCrudActive) {
					exp.fields = WarehouseUserModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'accompanyingConsents' && this.accompanyingConsentsMultiCrudActive) {
					exp.fields = InformedConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'amendmentDetails' && this.amendmentDetailsMultiCrudActive) {
					exp.fields = AmendmentDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiaMedicalTranscriber' && this.anesthesiaMedicalTranscriberMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiologist' && this.anesthesiologistMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'anesthesiologyNurse' && this.anesthesiologyNurseMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'cashierStaff' && this.cashierStaffMultiCrudActive) {
					exp.fields = CashReceiptModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'coTreatingDoctors' && this.coTreatingDoctorsMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dailyCareCPPTsCreatedByStaff' && this.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dailyCareCPPTsDoctorInCharge' && this.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dailyCareCPPTsMedicalTranscriber' && this.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'deliveryProgresses' && this.deliveryProgressesMultiCrudActive) {
					exp.fields = DeliveryProgressModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosticStaffExaminationSummaries' && this.diagnosticStaffExaminationSummariesMultiCrudActive) {
					exp.fields = DiagnosticStaffExaminationSummaryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dismissalReferringStaff' && this.dismissalReferringStaffMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'doctorSchedules' && this.doctorSchedulesMultiCrudActive) {
					exp.fields = DoctorScheduleModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'doctorOnExamination' && this.doctorOnExaminationMultiCrudActive) {
					exp.fields = MedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'fluidBalanceDetails' && this.fluidBalanceDetailsMultiCrudActive) {
					exp.fields = FluidBalanceDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'hemodialysisMonitorings' && this.hemodialysisMonitoringsMultiCrudActive) {
					exp.fields = HemodialysisMonitoringModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'hospitalBranchInformations' && this.hospitalBranchInformationsMultiCrudActive) {
					exp.fields = HospitalBranchInformationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'informingConsents' && this.informingConsentsMultiCrudActive) {
					exp.fields = InformedConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoices' && this.invoicesMultiCrudActive) {
					exp.fields = InvoiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'mcuPackageItems' && this.mcuPackageItemsMultiCrudActive) {
					exp.fields = McuPackageItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateDischargeResumes' && this.medicalCertificateDischargeResumesMultiCrudActive) {
					exp.fields = MedicalCertificateDischargeResumeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateBirths' && this.medicalCertificateBirthsMultiCrudActive) {
					exp.fields = MedicalCertificateBirthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateHospitalizations' && this.medicalCertificateHospitalizationsMultiCrudActive) {
					exp.fields = MedicalCertificateHospitalizationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalExaminationRecordDischargeSummarys' && this.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
					exp.fields = MedicalExaminationRecordDischargeSummaryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalRecordTranscriber' && this.medicalRecordTranscriberMultiCrudActive) {
					exp.fields = MedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalStaffOfMedicalAttendancesCertificate' && this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
					exp.fields = MedicalCertificateMedicalAttendanceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalStaffOfMentalHealths' && this.medicalStaffOfMentalHealthsMultiCrudActive) {
					exp.fields = MedicalCertificateMentalHealthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalStaffOfPhysicalHealths' && this.medicalStaffOfPhysicalHealthsMultiCrudActive) {
					exp.fields = MedicalCertificatePhysicalHealthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalStaffOfRestrictedWorksCertificate' && this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
					exp.fields = MedicalCertificateRestrictedWorkModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalStaffOfSickLeavesCertificate' && this.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
					exp.fields = MedicalCertificateSickLeaveModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationAdministeredHisotries' && this.medicationAdministeredHisotriesMultiCrudActive) {
					exp.fields = MedicationAdministeredHistoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationHeaders' && this.medicationHeadersMultiCrudActive) {
					exp.fields = MedicationHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'midwives' && this.midwivesMultiCrudActive) {
					exp.fields = DeliveryMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nurse' && this.nurseMultiCrudActive) {
					exp.fields = MedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nursingDetailSurgicalNursing' && this.nursingDetailSurgicalNursingMultiCrudActive) {
					exp.fields = OperatingTheaterMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nursingDetailsAnesthesiaNursing' && this.nursingDetailsAnesthesiaNursingMultiCrudActive) {
					exp.fields = OperatingTheaterMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientConsents' && this.patientConsentsMultiCrudActive) {
					exp.fields = PatientConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVitalInformations' && this.patientVitalInformationsMultiCrudActive) {
					exp.fields = PatientVitalInformationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'pediatricianInCharge' && this.pediatricianInChargeMultiCrudActive) {
					exp.fields = NewbornDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'prescriptionHeaders' && this.prescriptionHeadersMultiCrudActive) {
					exp.fields = PrescriptionHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'processWorkflowLogs' && this.processWorkflowLogsMultiCrudActive) {
					exp.fields = ProcessWorkflowModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'registrations' && this.registrationsMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'requestedBy' && this.requestedByMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'roomTransfers' && this.roomTransfersMultiCrudActive) {
					exp.fields = RoomTransferModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sampleCollectionStaffs' && this.sampleCollectionStaffsMultiCrudActive) {
					exp.fields = SampleCollectionItemsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sampleDeliveryStaffs' && this.sampleDeliveryStaffsMultiCrudActive) {
					exp.fields = SampleCollectionItemsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sampleProcessingStaffs' && this.sampleProcessingStaffsMultiCrudActive) {
					exp.fields = SampleCollectionItemsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgeon' && this.surgeonMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgicalMedicalTranscriber' && this.surgicalMedicalTranscriberMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'surgicalNurse' && this.surgicalNurseMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'transferOrderStockDetails' && this.transferOrderStockDetailsMultiCrudActive) {
					exp.fields = TransferOrderStockDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'vaccinationOrders' && this.vaccinationOrdersMultiCrudActive) {
					exp.fields = VaccinationOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'services' && this.servicesMultiCrudActive) {
					exp.fields = ServiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				return exp;
			}
		);
		return expands;
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * The model to be created or edited depending on what the model currently is.
	 */
	targetModel: StaffModel;

	/**
	 * The form group created from the target model
	 */
	modelFormGroup: FormGroup;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * The Names of the buttons to be passed to the crud edit page for adding additional entities to the multi crud view.
	 * This requires a list of strings, where each string will become a button which sends an event back to onMultiEntityAction()
	 */
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: StaffModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChanges logic before the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic before the main body here] end

		// % protected region % [Customise the ngOnChanges main body here] off begin
		if (changes.hasOwnProperty('tileMode') || changes.hasOwnProperty('targetModelId')) {
			this.initializeTargetModel();
		}
		// % protected region % [Customise the ngOnChanges main body here] end

		// % protected region % [Add any additional ngOnChanges logic after the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.initialiseMultiEntityCollections();

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
				this.routerState = routerState;
				this.initializeTargetModel();
			}
		);

		let firstTime = true; // ensures that the user isn't instantly navigated back to the list page
		/**
		 * Tile Mode Change will not be triggered until the creation action has been dispatched and completed
		 * Subscribing in ngOnInit ensures that a count models action can be passed as an afterwards action, so the
		 * subscribed code will not be triggered until after the creation has been completed
		 */
		this.creationNavigationSubscription$.add(this.store.select(getCountStaffModels).subscribe(count => {
			if (this.singlePageComponent && !firstTime) {
				this.triggerTileModeChange(CrudTileMode.List);
			}

			firstTime = false;
		}));

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		if (this.routerStateSubscription$) {
			this.routerStateSubscription$.unsubscribe();
		}

		if (this.creationNavigationSubscription$) {
			this.creationNavigationSubscription$.unsubscribe();
		}

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end
	}

	/**
	 * Initialize target model when input fields changed or router changed
	 */
	private initializeTargetModel() {
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] end

		if (!this.singlePageComponent) {
			this.initWithRouting();
		}

		// When tile mode is not defiend, reutrn directly without fetching data
		if (this.tileMode === undefined) {
			return;
		}

		this.resetPropsAndRels();
		this.prepareReferenceCollections();
		this.createReactiveForm();

		if (this.tileMode === CrudTileMode.Edit || this.tileMode === CrudTileMode.View) {
			// % protected region % [Add additional processing for View and Edit mode before the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode before the main body here] end

			this.fetchEntity();

			// % protected region % [Add additional processing for View and Edit mode after the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode after the main body here] end
		} else if (this.tileMode === CrudTileMode.Create) {
			// % protected region % [Add additional processing for Create mode before the main body here] off begin
			// % protected region % [Add additional processing for Create mode before the main body here] end

			this.targetModel = new StaffModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.staffAudits$ = this.store.select(getStaffModelAuditsByEntityId, this.targetModelId);
		}

		// % protected region % [Add any additional initializeTargetModel logic after the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic after the main body here] end
	}

	/**
	 * Function to initialize the component fields according to the routing
	 * Method only be invoked when routing is enabled
	 */
	private initWithRouting() {
		// % protected region % [Override the initWithRouting method body here] off begin
		this.targetModelId = this.routerState.params.id;
		if (this.routerState.urls.includes('view')) {
			this.tileMode = CrudTileMode.View;
		} else if (this.routerState.urls.includes('edit')) {
			this.tileMode = CrudTileMode.Edit;
		} else if (this.routerState.urls.includes('create')) {
			this.tileMode = CrudTileMode.Create;
		} else {
			this.tileMode = undefined;
		}
		// % protected region % [Override the initWithRouting method body here] end
	}

	/**
	 * Initialize and dispatch event to fetch data from serverside
	 */
	private fetchEntity() {
		const stateConfig: PassableStateConfig<StaffModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.StaffAction(
			modelAction.StaffModelActionTypes.FETCH_STAFF,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new StaffModel(model);
			model.syncRelations();

			this.targetModel = model;
			if (this.targetModel) {
				this.modelFormGroup.patchValue(this.targetModel);
			}

			this.multiCrudFetchAdditionalEntities();

			// % protected region % [Add additional actions after setting targetModel here] off begin
			// % protected region % [Add additional actions after setting targetModel here] end
		}));
	}

	/**
	 * This method iterates through all of the relations in the relations array and performs logic to fetch all of the entities to be shown
	 * in the dropdowns. This method does not need to be modified if you add additional entities to your crud list, as it will process all
	 * relations given to it
	 */
	private prepareReferenceCollections() {
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] end

		let updatedRelationsArray: ModelRelation[] = [];

		this.modelRelations.forEach(relation => {
			updatedRelationsArray.push(this.prepareSingleReferenceCollection(relation));
		});

		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] end

		this.modelRelations = updatedRelationsArray;
	}

	/**
	 * Prepare the collection for a single Model Relation.  This method is called once for each relation in the modelRelations array,
	 * although there are use cases for processing other relations individually.  Calling prepareReferenceCollections within a subscription
	 * is not recommended, as it will cause a feedback loop which will require a reload to fix.  Therefore, abstracting this logic out allows
	 * for preparing reference collections for multi entity crud for 1:M relations.
	 *
	 * @param relation The relation to prepare the collection for
	 * @returns the same relation, with some additional parameters added following the creation of the collection
	 */
	prepareSingleReferenceCollection(relation: ModelRelation, uniqueCollectionId?: string) {
		let referenceRequirements: PrepareReferenceRequirements;
		referenceRequirements = fetchPrepareReferenceRequirements(relation.entityName);
		relation.stateConfig = {
			pageIndex: 0,
			pageSize: this.pageSize,
			collectionId: uniqueCollectionId ? uniqueCollectionId : this.collectionId
		} as PassableStateConfig<any>;

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.initCollectionAction,
			relation.stateConfig
		));

		this.addSearchFunction(relation,
				referenceRequirements.collectionModelsSelector,
				referenceRequirements.baseAction,
				referenceRequirements.fetchWithQueryAction);

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.fetchAllAction,
			relation.stateConfig
		));

		return relation;
	}

	/**
	 * Add the search function for each of the relations.
	 *
	 */
	private addSearchFunction(modelRelation: ModelRelation, modelSelector: any, action: new (...args: any[]) => NgRxAction, actionType: string) {
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] end

		modelRelation.searchFunction = new Subject<string>();
		modelRelation.collection = this.store.select(modelSelector, this.collectionId);
		this.creationNavigationSubscription$.add(modelRelation.searchFunction.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			filter(value => value != null)
		).subscribe(
			(term: string) => {
				modelRelation.stateConfig.queryParams = {
					pageSize: this.pageSize,
					pageIndex: 0,
					where: [
						[
							{
								path: modelRelation.displayName,
								operation: QueryOperation.CONTAINS,
								value: term
							}
						]
					]
				};

				// % protected region % [Add any additional logic to the search subscription before dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription before dispatch here] end

				this.store.dispatch(new action(
					actionType,
					modelRelation.stateConfig
				));

				// % protected region % [Add any additional logic to the search subscription after dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription after dispatch here] end
			}
		));

		// % protected region % [Add any additional code after the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code after the main logic of addSearchFunction here] end
	}

	/**
	 * Chang tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					...other
				}
			});
		} else {
			let extras: NavigationExtras = {};

			if (this.routerState.queryParams.listPage) {
				extras.queryParams = {listPage: this.routerState.queryParams.listPage};
			}

			const commands = [];

			commands.push('admin');
			commands.push('entities');
			commands.push('staff');

			if (tileMode !== CrudTileMode.List) {
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}

			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, extras));
		}
	}

	/**
	 * Triggered when the user clicks on the "View History" button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.store.dispatch(new modelAction.StaffAction(
			modelAction.StaffModelActionTypes.FETCH_STAFF_AUDITS_BY_ENTITY_ID,
			{
				targetModelId: this.targetModelId
			}
		));

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the `Create` or `Save` button is clicked in the child create/edit view.
	 */
	onCreateOrSaveClicked(event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }) {
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] end

		this.targetModel = this.addAdditionalEntitiesToModel(this.targetModel, event);

		if (event.isCreate) {
			let stateConfig: PassableStateConfig<StaffModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.administrationUserMultiCrudActive || this.cashierUserMultiCrudActive || this.claimUserMultiCrudActive || this.diagnosticSupportUserMultiCrudActive || this.doctorUserMultiCrudActive || this.facilityUserMultiCrudActive || this.managementUserMultiCrudActive || this.medicalRecordUserMultiCrudActive || this.medicalTranscriberUserMultiCrudActive || this.nurseUserMultiCrudActive || this.pharmacyUserMultiCrudActive || this.purchasingUserMultiCrudActive || this.registrationUserMultiCrudActive || this.systemAdminUserMultiCrudActive || this.warehouseUserMultiCrudActive || this.administratorMultiCrudActive || this.bpjsDoctorMappingMultiCrudActive || this.pcareDokterMultiCrudActive || this.serviceMultiCrudActive || this.accompanyingConsentsMultiCrudActive || this.amendmentDetailsMultiCrudActive || this.anesthesiaMedicalTranscriberMultiCrudActive || this.anesthesiologistMultiCrudActive || this.anesthesiologyNurseMultiCrudActive || this.cashierStaffMultiCrudActive || this.coTreatingDoctorsMultiCrudActive || this.dailyCareCPPTsCreatedByStaffMultiCrudActive || this.dailyCareCPPTsDoctorInChargeMultiCrudActive || this.dailyCareCPPTsMedicalTranscriberMultiCrudActive || this.deliveryProgressesMultiCrudActive || this.diagnosticStaffExaminationSummariesMultiCrudActive || this.dismissalReferringStaffMultiCrudActive || this.doctorSchedulesMultiCrudActive || this.doctorOnExaminationMultiCrudActive || this.fluidBalanceDetailsMultiCrudActive || this.hemodialysisMonitoringsMultiCrudActive || this.hospitalBranchInformationsMultiCrudActive || this.informingConsentsMultiCrudActive || this.invoicesMultiCrudActive || this.mcuPackageItemsMultiCrudActive || this.medicalCertificateDischargeResumesMultiCrudActive || this.medicalCertificateBirthsMultiCrudActive || this.medicalCertificateHospitalizationsMultiCrudActive || this.medicalExaminationRecordDischargeSummarysMultiCrudActive || this.medicalRecordTranscriberMultiCrudActive || this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive || this.medicalStaffOfMentalHealthsMultiCrudActive || this.medicalStaffOfPhysicalHealthsMultiCrudActive || this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive || this.medicalStaffOfSickLeavesCertificateMultiCrudActive || this.medicationAdministeredHisotriesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.midwivesMultiCrudActive || this.nurseMultiCrudActive || this.nursingDetailSurgicalNursingMultiCrudActive || this.nursingDetailsAnesthesiaNursingMultiCrudActive || this.patientConsentsMultiCrudActive || this.patientVitalInformationsMultiCrudActive || this.pediatricianInChargeMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.processWorkflowLogsMultiCrudActive || this.registrationsMultiCrudActive || this.requestedByMultiCrudActive || this.roomTransfersMultiCrudActive || this.sampleCollectionStaffsMultiCrudActive || this.sampleDeliveryStaffsMultiCrudActive || this.sampleProcessingStaffsMultiCrudActive || this.surgeonMultiCrudActive || this.surgicalMedicalTranscriberMultiCrudActive || this.surgicalNurseMultiCrudActive || this.transferOrderStockDetailsMultiCrudActive || this.vaccinationOrdersMultiCrudActive || this.servicesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the creation state config here] off begin
				// % protected region % [Add any additional attributes to the creation state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for single page creation here] off begin
					// % protected region % [Add any additional afterwards actions for single page creation here] end
					// Count the models to trigger the tile mode change, as the count will have changed after creation
					new modelAction.StaffAction(
						modelAction.StaffModelActionTypes.COUNT_STAFFS,
						null
					)
				];
			} else {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for creation here] off begin
					// % protected region % [Add any additional afterwards actions for creation here] end
					new routingAction.BackRoutingAction()
				];
			}

			// % protected region % [Add any additional logic before creating a new model here] off begin
			// % protected region % [Add any additional logic before creating a new model here] end

			this.store.dispatch(new modelAction.StaffAction(
				modelAction.StaffModelActionTypes.CREATE_STAFF,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<StaffModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.administrationUserMultiCrudActive || this.cashierUserMultiCrudActive || this.claimUserMultiCrudActive || this.diagnosticSupportUserMultiCrudActive || this.doctorUserMultiCrudActive || this.facilityUserMultiCrudActive || this.managementUserMultiCrudActive || this.medicalRecordUserMultiCrudActive || this.medicalTranscriberUserMultiCrudActive || this.nurseUserMultiCrudActive || this.pharmacyUserMultiCrudActive || this.purchasingUserMultiCrudActive || this.registrationUserMultiCrudActive || this.systemAdminUserMultiCrudActive || this.warehouseUserMultiCrudActive || this.administratorMultiCrudActive || this.bpjsDoctorMappingMultiCrudActive || this.pcareDokterMultiCrudActive || this.serviceMultiCrudActive || this.accompanyingConsentsMultiCrudActive || this.amendmentDetailsMultiCrudActive || this.anesthesiaMedicalTranscriberMultiCrudActive || this.anesthesiologistMultiCrudActive || this.anesthesiologyNurseMultiCrudActive || this.cashierStaffMultiCrudActive || this.coTreatingDoctorsMultiCrudActive || this.dailyCareCPPTsCreatedByStaffMultiCrudActive || this.dailyCareCPPTsDoctorInChargeMultiCrudActive || this.dailyCareCPPTsMedicalTranscriberMultiCrudActive || this.deliveryProgressesMultiCrudActive || this.diagnosticStaffExaminationSummariesMultiCrudActive || this.dismissalReferringStaffMultiCrudActive || this.doctorSchedulesMultiCrudActive || this.doctorOnExaminationMultiCrudActive || this.fluidBalanceDetailsMultiCrudActive || this.hemodialysisMonitoringsMultiCrudActive || this.hospitalBranchInformationsMultiCrudActive || this.informingConsentsMultiCrudActive || this.invoicesMultiCrudActive || this.mcuPackageItemsMultiCrudActive || this.medicalCertificateDischargeResumesMultiCrudActive || this.medicalCertificateBirthsMultiCrudActive || this.medicalCertificateHospitalizationsMultiCrudActive || this.medicalExaminationRecordDischargeSummarysMultiCrudActive || this.medicalRecordTranscriberMultiCrudActive || this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive || this.medicalStaffOfMentalHealthsMultiCrudActive || this.medicalStaffOfPhysicalHealthsMultiCrudActive || this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive || this.medicalStaffOfSickLeavesCertificateMultiCrudActive || this.medicationAdministeredHisotriesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.midwivesMultiCrudActive || this.nurseMultiCrudActive || this.nursingDetailSurgicalNursingMultiCrudActive || this.nursingDetailsAnesthesiaNursingMultiCrudActive || this.patientConsentsMultiCrudActive || this.patientVitalInformationsMultiCrudActive || this.pediatricianInChargeMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.processWorkflowLogsMultiCrudActive || this.registrationsMultiCrudActive || this.requestedByMultiCrudActive || this.roomTransfersMultiCrudActive || this.sampleCollectionStaffsMultiCrudActive || this.sampleDeliveryStaffsMultiCrudActive || this.sampleProcessingStaffsMultiCrudActive || this.surgeonMultiCrudActive || this.surgicalMedicalTranscriberMultiCrudActive || this.surgicalNurseMultiCrudActive || this.transferOrderStockDetailsMultiCrudActive || this.vaccinationOrdersMultiCrudActive || this.servicesMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.StaffAction(
					modelAction.StaffModelActionTypes.FETCH_STAFF,
					{
						targetModelId: this.targetModelId,
						queryParams: {
							expands: this.defaultExpands
						}
					}
				));
			} else {
				afterwardActions = [
					new routingAction.BackRoutingAction(),
					// % protected region % [Add any additional afterwards actions for updates here] off begin
					// % protected region % [Add any additional afterwards actions for updates here] end
				];
			}

			// % protected region % [Add any additional logic before update the current model here] off begin
			// % protected region % [Add any additional logic before update the current model here] end

			this.store.dispatch(new modelAction.StaffAction(
				modelAction.StaffModelActionTypes.UPDATE_STAFF,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: StaffModel = new StaffModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModelId).subscribe(model => {
					let differences = new StaffModel(model).difference(updatedModel);

					// Object has been updated when differences is empty.
					// Differences excludes values such as references.  As these aren't visible on the list they do not need to be checked
					// When the user naivgates to a page which displays references, they will be fetched from the database with the correct values
					if (Object.keys(differences).length === 0) {
						this.triggerTileModeChange(CrudTileMode.List);
					}
				}));
			}
		}

		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] end
	}

	/**
	 * Removes form elements whose group id matches the group Id passed into the event, or adds a new
	 * group based on the entityName parameter
	 *
	 * @param event The event emitted from the base crud edit page
	 */
	onMultiEntityAction(event: { groupId: string, entityName: string, payload?: { [s: string]: any } }) {
		if (event.groupId) { // This path deletes the group with the specified id from the list
			this.modelProperties = this.modelProperties.filter(prop => {
				if (prop.group) {
					return prop.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});

			this.modelRelations = this.modelRelations.filter(relation => {
				if (relation.group) {
					return relation.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});
		} else {
			// This will add a new entity of the specified type to the list of props/relations
			if (event.entityName === this.administrationUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AdministrationUserModel.getProps(), this.administrationUserRelations, this.isViewOnly),
					new AdministrationUserModel(),
					AdministrationUserModel,
					this.administrationUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.administrationUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.cashierUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CashierUserModel.getProps(), this.cashierUserRelations, this.isViewOnly),
					new CashierUserModel(),
					CashierUserModel,
					this.cashierUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cashierUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.claimUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ClaimUserModel.getProps(), this.claimUserRelations, this.isViewOnly),
					new ClaimUserModel(),
					ClaimUserModel,
					this.claimUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.claimUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.diagnosticSupportUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticSupportUserModel.getProps(), this.diagnosticSupportUserRelations, this.isViewOnly),
					new DiagnosticSupportUserModel(),
					DiagnosticSupportUserModel,
					this.diagnosticSupportUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticSupportUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.doctorUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DoctorUserModel.getProps(), this.doctorUserRelations, this.isViewOnly),
					new DoctorUserModel(),
					DoctorUserModel,
					this.doctorUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.facilityUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FacilityUserModel.getProps(), this.facilityUserRelations, this.isViewOnly),
					new FacilityUserModel(),
					FacilityUserModel,
					this.facilityUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.facilityUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.managementUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ManagementUserModel.getProps(), this.managementUserRelations, this.isViewOnly),
					new ManagementUserModel(),
					ManagementUserModel,
					this.managementUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.managementUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalRecordUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordUserModel.getProps(), this.medicalRecordUserRelations, this.isViewOnly),
					new MedicalRecordUserModel(),
					MedicalRecordUserModel,
					this.medicalRecordUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalTranscriberUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalTranscriberUserModel.getProps(), this.medicalTranscriberUserRelations, this.isViewOnly),
					new MedicalTranscriberUserModel(),
					MedicalTranscriberUserModel,
					this.medicalTranscriberUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalTranscriberUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nurseUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(NurseUserModel.getProps(), this.nurseUserRelations, this.isViewOnly),
					new NurseUserModel(),
					NurseUserModel,
					this.nurseUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.pharmacyUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PharmacyUserModel.getProps(), this.pharmacyUserRelations, this.isViewOnly),
					new PharmacyUserModel(),
					PharmacyUserModel,
					this.pharmacyUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pharmacyUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.purchasingUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchasingUserModel.getProps(), this.purchasingUserRelations, this.isViewOnly),
					new PurchasingUserModel(),
					PurchasingUserModel,
					this.purchasingUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchasingUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.registrationUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationUserModel.getProps(), this.registrationUserRelations, this.isViewOnly),
					new RegistrationUserModel(),
					RegistrationUserModel,
					this.registrationUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.systemAdminUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SystemAdminUserModel.getProps(), this.systemAdminUserRelations, this.isViewOnly),
					new SystemAdminUserModel(),
					SystemAdminUserModel,
					this.systemAdminUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.systemAdminUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.warehouseUserDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseUserModel.getProps(), this.warehouseUserRelations, this.isViewOnly),
					new WarehouseUserModel(),
					WarehouseUserModel,
					this.warehouseUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseUserRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.administratorDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AdministratorModel.getProps(), this.administratorRelations, this.isViewOnly),
					new AdministratorModel(),
					AdministratorModel,
					this.administratorDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.administratorRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsDoctorMappingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDoctorMappingModel.getProps(), this.bpjsDoctorMappingRelations, this.isViewOnly),
					new BpjsDoctorMappingModel(),
					BpjsDoctorMappingModel,
					this.bpjsDoctorMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDoctorMappingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.pcareDokterDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PcareDokterModel.getProps(), this.pcareDokterRelations, this.isViewOnly),
					new PcareDokterModel(),
					PcareDokterModel,
					this.pcareDokterDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pcareDokterRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.serviceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					new ServiceModel(),
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.accompanyingConsentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InformedConsentModel.getProps(), this.accompanyingConsentsRelations, this.isViewOnly),
					new InformedConsentModel(),
					InformedConsentModel,
					this.accompanyingConsentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.accompanyingConsentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.amendmentDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AmendmentDetailModel.getProps(), this.amendmentDetailsRelations, this.isViewOnly),
					new AmendmentDetailModel(),
					AmendmentDetailModel,
					this.amendmentDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.amendmentDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiaMedicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiaMedicalTranscriberRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.anesthesiaMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiaMedicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiologistDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiologistRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.anesthesiologistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologistRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.anesthesiologyNurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiologyNurseRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.anesthesiologyNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.anesthesiologyNurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.cashierStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CashReceiptModel.getProps(), this.cashierStaffRelations, this.isViewOnly),
					new CashReceiptModel(),
					CashReceiptModel,
					this.cashierStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cashierStaffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.coTreatingDoctorsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingDoctorsRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.coTreatingDoctorsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.coTreatingDoctorsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dailyCareCPPTsCreatedByStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsCreatedByStaffRelations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.dailyCareCPPTsCreatedByStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dailyCareCPPTsCreatedByStaffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dailyCareCPPTsDoctorInChargeDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsDoctorInChargeRelations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.dailyCareCPPTsDoctorInChargeDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dailyCareCPPTsDoctorInChargeRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dailyCareCPPTsMedicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsMedicalTranscriberRelations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.dailyCareCPPTsMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dailyCareCPPTsMedicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.deliveryProgressesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DeliveryProgressModel.getProps(), this.deliveryProgressesRelations, this.isViewOnly),
					new DeliveryProgressModel(),
					DeliveryProgressModel,
					this.deliveryProgressesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.deliveryProgressesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.diagnosticStaffExaminationSummariesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticStaffExaminationSummaryModel.getProps(), this.diagnosticStaffExaminationSummariesRelations, this.isViewOnly),
					new DiagnosticStaffExaminationSummaryModel(),
					DiagnosticStaffExaminationSummaryModel,
					this.diagnosticStaffExaminationSummariesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticStaffExaminationSummariesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dismissalReferringStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.dismissalReferringStaffRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.dismissalReferringStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dismissalReferringStaffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.doctorSchedulesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DoctorScheduleModel.getProps(), this.doctorSchedulesRelations, this.isViewOnly),
					new DoctorScheduleModel(),
					DoctorScheduleModel,
					this.doctorSchedulesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorSchedulesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.doctorOnExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.doctorOnExaminationRelations, this.isViewOnly),
					new MedicalExaminationRecordModel(),
					MedicalExaminationRecordModel,
					this.doctorOnExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorOnExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.fluidBalanceDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FluidBalanceDetailModel.getProps(), this.fluidBalanceDetailsRelations, this.isViewOnly),
					new FluidBalanceDetailModel(),
					FluidBalanceDetailModel,
					this.fluidBalanceDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.fluidBalanceDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.hemodialysisMonitoringsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HemodialysisMonitoringModel.getProps(), this.hemodialysisMonitoringsRelations, this.isViewOnly),
					new HemodialysisMonitoringModel(),
					HemodialysisMonitoringModel,
					this.hemodialysisMonitoringsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.hemodialysisMonitoringsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.hospitalBranchInformationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HospitalBranchInformationModel.getProps(), this.hospitalBranchInformationsRelations, this.isViewOnly),
					new HospitalBranchInformationModel(),
					HospitalBranchInformationModel,
					this.hospitalBranchInformationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.hospitalBranchInformationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.informingConsentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InformedConsentModel.getProps(), this.informingConsentsRelations, this.isViewOnly),
					new InformedConsentModel(),
					InformedConsentModel,
					this.informingConsentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.informingConsentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesRelations, this.isViewOnly),
					new InvoiceModel(),
					InvoiceModel,
					this.invoicesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.mcuPackageItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(McuPackageItemModel.getProps(), this.mcuPackageItemsRelations, this.isViewOnly),
					new McuPackageItemModel(),
					McuPackageItemModel,
					this.mcuPackageItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.mcuPackageItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateDischargeResumesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.medicalCertificateDischargeResumesRelations, this.isViewOnly),
					new MedicalCertificateDischargeResumeModel(),
					MedicalCertificateDischargeResumeModel,
					this.medicalCertificateDischargeResumesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateDischargeResumesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateBirthsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateBirthModel.getProps(), this.medicalCertificateBirthsRelations, this.isViewOnly),
					new MedicalCertificateBirthModel(),
					MedicalCertificateBirthModel,
					this.medicalCertificateBirthsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateBirthsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateHospitalizationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateHospitalizationModel.getProps(), this.medicalCertificateHospitalizationsRelations, this.isViewOnly),
					new MedicalCertificateHospitalizationModel(),
					MedicalCertificateHospitalizationModel,
					this.medicalCertificateHospitalizationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateHospitalizationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalExaminationRecordDischargeSummarysDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordDischargeSummaryModel.getProps(), this.medicalExaminationRecordDischargeSummarysRelations, this.isViewOnly),
					new MedicalExaminationRecordDischargeSummaryModel(),
					MedicalExaminationRecordDischargeSummaryModel,
					this.medicalExaminationRecordDischargeSummarysDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalExaminationRecordDischargeSummarysRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalRecordTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.medicalRecordTranscriberRelations, this.isViewOnly),
					new MedicalExaminationRecordModel(),
					MedicalExaminationRecordModel,
					this.medicalRecordTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalStaffOfMedicalAttendancesCertificateDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMedicalAttendanceModel.getProps(), this.medicalStaffOfMedicalAttendancesCertificateRelations, this.isViewOnly),
					new MedicalCertificateMedicalAttendanceModel(),
					MedicalCertificateMedicalAttendanceModel,
					this.medicalStaffOfMedicalAttendancesCertificateDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalStaffOfMedicalAttendancesCertificateRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalStaffOfMentalHealthsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMentalHealthModel.getProps(), this.medicalStaffOfMentalHealthsRelations, this.isViewOnly),
					new MedicalCertificateMentalHealthModel(),
					MedicalCertificateMentalHealthModel,
					this.medicalStaffOfMentalHealthsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalStaffOfMentalHealthsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalStaffOfPhysicalHealthsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificatePhysicalHealthModel.getProps(), this.medicalStaffOfPhysicalHealthsRelations, this.isViewOnly),
					new MedicalCertificatePhysicalHealthModel(),
					MedicalCertificatePhysicalHealthModel,
					this.medicalStaffOfPhysicalHealthsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalStaffOfPhysicalHealthsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalStaffOfRestrictedWorksCertificateDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateRestrictedWorkModel.getProps(), this.medicalStaffOfRestrictedWorksCertificateRelations, this.isViewOnly),
					new MedicalCertificateRestrictedWorkModel(),
					MedicalCertificateRestrictedWorkModel,
					this.medicalStaffOfRestrictedWorksCertificateDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalStaffOfRestrictedWorksCertificateRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalStaffOfSickLeavesCertificateDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateSickLeaveModel.getProps(), this.medicalStaffOfSickLeavesCertificateRelations, this.isViewOnly),
					new MedicalCertificateSickLeaveModel(),
					MedicalCertificateSickLeaveModel,
					this.medicalStaffOfSickLeavesCertificateDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalStaffOfSickLeavesCertificateRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicationAdministeredHisotriesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationAdministeredHistoryModel.getProps(), this.medicationAdministeredHisotriesRelations, this.isViewOnly),
					new MedicationAdministeredHistoryModel(),
					MedicationAdministeredHistoryModel,
					this.medicationAdministeredHisotriesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationAdministeredHisotriesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicationHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
					new MedicationHeaderModel(),
					MedicationHeaderModel,
					this.medicationHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.midwivesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DeliveryMedicalExaminationRecordModel.getProps(), this.midwivesRelations, this.isViewOnly),
					new DeliveryMedicalExaminationRecordModel(),
					DeliveryMedicalExaminationRecordModel,
					this.midwivesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.midwivesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.nurseRelations, this.isViewOnly),
					new MedicalExaminationRecordModel(),
					MedicalExaminationRecordModel,
					this.nurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nursingDetailSurgicalNursingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.nursingDetailSurgicalNursingRelations, this.isViewOnly),
					new OperatingTheaterMedicalExaminationRecordModel(),
					OperatingTheaterMedicalExaminationRecordModel,
					this.nursingDetailSurgicalNursingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nursingDetailSurgicalNursingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nursingDetailsAnesthesiaNursingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.nursingDetailsAnesthesiaNursingRelations, this.isViewOnly),
					new OperatingTheaterMedicalExaminationRecordModel(),
					OperatingTheaterMedicalExaminationRecordModel,
					this.nursingDetailsAnesthesiaNursingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nursingDetailsAnesthesiaNursingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientConsentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientConsentModel.getProps(), this.patientConsentsRelations, this.isViewOnly),
					new PatientConsentModel(),
					PatientConsentModel,
					this.patientConsentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientConsentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVitalInformationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVitalInformationModel.getProps(), this.patientVitalInformationsRelations, this.isViewOnly),
					new PatientVitalInformationModel(),
					PatientVitalInformationModel,
					this.patientVitalInformationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVitalInformationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.pediatricianInChargeDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(NewbornDetailModel.getProps(), this.pediatricianInChargeRelations, this.isViewOnly),
					new NewbornDetailModel(),
					NewbornDetailModel,
					this.pediatricianInChargeDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pediatricianInChargeRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.prescriptionHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
					new PrescriptionHeaderModel(),
					PrescriptionHeaderModel,
					this.prescriptionHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.processWorkflowLogsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ProcessWorkflowModel.getProps(), this.processWorkflowLogsRelations, this.isViewOnly),
					new ProcessWorkflowModel(),
					ProcessWorkflowModel,
					this.processWorkflowLogsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.processWorkflowLogsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.registrationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationsRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.registrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.requestedByDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.requestedByRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.requestedByDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.requestedByRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.roomTransfersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
					new RoomTransferModel(),
					RoomTransferModel,
					this.roomTransfersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.roomTransfersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sampleCollectionStaffsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleCollectionStaffsRelations, this.isViewOnly),
					new SampleCollectionItemsModel(),
					SampleCollectionItemsModel,
					this.sampleCollectionStaffsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sampleCollectionStaffsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sampleDeliveryStaffsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleDeliveryStaffsRelations, this.isViewOnly),
					new SampleCollectionItemsModel(),
					SampleCollectionItemsModel,
					this.sampleDeliveryStaffsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sampleDeliveryStaffsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sampleProcessingStaffsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleProcessingStaffsRelations, this.isViewOnly),
					new SampleCollectionItemsModel(),
					SampleCollectionItemsModel,
					this.sampleProcessingStaffsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sampleProcessingStaffsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgeonDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgeonRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.surgeonDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgeonRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgicalMedicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgicalMedicalTranscriberRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.surgicalMedicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalMedicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.surgicalNurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgicalNurseRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.surgicalNurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.surgicalNurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.transferOrderStockDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(TransferOrderStockDetailModel.getProps(), this.transferOrderStockDetailsRelations, this.isViewOnly),
					new TransferOrderStockDetailModel(),
					TransferOrderStockDetailModel,
					this.transferOrderStockDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.transferOrderStockDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.vaccinationOrdersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(VaccinationOrderModel.getProps(), this.vaccinationOrdersRelations, this.isViewOnly),
					new VaccinationOrderModel(),
					VaccinationOrderModel,
					this.vaccinationOrdersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.vaccinationOrdersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.servicesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.servicesRelations, this.isViewOnly),
					new ServiceModel(),
					ServiceModel,
					this.servicesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.servicesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			}
	}

	/**
	 * Triggered when the user switches from view mode to edit mode.
	 */
	onSwitchEdit() {
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.Edit, this.targetModelId);

		// % protected region % [Add any additional onSwitchEdit logic after the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic after the main body here] end
	}

	/**
	 * Triggered whenever the `Cancel` of the create/edit child component is clicked.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.List);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Create the reactive form from the input model
	 */
	createReactiveForm() {
		// % protected region % [Add any additional createReactiveForm logic before the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic before the main body here] end

		this.modelFormGroup = createReactiveFormFromModel(this.modelProperties, this.modelRelations, this.isViewOnly);

		// % protected region % [Add any additional createReactiveForm logic after the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic after the main body here] end
	}

	/**
	 * Returns the props and relations lists back to their default state.  This is called in fetchEntity to ensure that
	 * any time the entity changes these lists remain stable.  If you are adding additional entities to your crud page the
	 * placement of this method ensures that no duplicate attributes will be added on repeat runs of fetch entity
	 */
	resetPropsAndRels() {
		this.modelProperties = StaffModel.getProps();
		this.modelRelations = StaffModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'administrationUser';
		}).hideElement = this.administrationUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'administrationUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'cashierUser';
		}).hideElement = this.cashierUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'cashierUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'claimUser';
		}).hideElement = this.claimUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'claimUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosticSupportUser';
		}).hideElement = this.diagnosticSupportUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosticSupportUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'doctorUser';
		}).hideElement = this.doctorUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'doctorUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'facilityUser';
		}).hideElement = this.facilityUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'facilityUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'managementUser';
		}).hideElement = this.managementUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'managementUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalRecordUser';
		}).hideElement = this.medicalRecordUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalRecordUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalTranscriberUser';
		}).hideElement = this.medicalTranscriberUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalTranscriberUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nurseUser';
		}).hideElement = this.nurseUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nurseUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'pharmacyUser';
		}).hideElement = this.pharmacyUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'pharmacyUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'purchasingUser';
		}).hideElement = this.purchasingUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'purchasingUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registrationUser';
		}).hideElement = this.registrationUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registrationUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'systemAdminUser';
		}).hideElement = this.systemAdminUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'systemAdminUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'warehouseUser';
		}).hideElement = this.warehouseUserMultiCrudActive || this.modelRelations.find(rel => rel.id === 'warehouseUser').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'administrator';
		}).hideElement = this.administratorMultiCrudActive || this.modelRelations.find(rel => rel.id === 'administrator').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDoctorMapping';
		}).hideElement = this.bpjsDoctorMappingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDoctorMapping').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'pcareDokter';
		}).hideElement = this.pcareDokterMultiCrudActive || this.modelRelations.find(rel => rel.id === 'pcareDokter').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'service';
		}).hideElement = this.serviceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'service').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'accompanyingConsents';
		}).hideElement = this.accompanyingConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'accompanyingConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'amendmentDetails';
		}).hideElement = this.amendmentDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'amendmentDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiaMedicalTranscriber';
		}).hideElement = this.anesthesiaMedicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiaMedicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiologist';
		}).hideElement = this.anesthesiologistMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiologist').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'anesthesiologyNurse';
		}).hideElement = this.anesthesiologyNurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'anesthesiologyNurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'cashierStaff';
		}).hideElement = this.cashierStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'cashierStaff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'coTreatingDoctors';
		}).hideElement = this.coTreatingDoctorsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'coTreatingDoctors').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dailyCareCPPTsCreatedByStaff';
		}).hideElement = this.dailyCareCPPTsCreatedByStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dailyCareCPPTsCreatedByStaff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dailyCareCPPTsDoctorInCharge';
		}).hideElement = this.dailyCareCPPTsDoctorInChargeMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dailyCareCPPTsDoctorInCharge').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dailyCareCPPTsMedicalTranscriber';
		}).hideElement = this.dailyCareCPPTsMedicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dailyCareCPPTsMedicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'deliveryProgresses';
		}).hideElement = this.deliveryProgressesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'deliveryProgresses').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosticStaffExaminationSummaries';
		}).hideElement = this.diagnosticStaffExaminationSummariesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosticStaffExaminationSummaries').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dismissalReferringStaff';
		}).hideElement = this.dismissalReferringStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dismissalReferringStaff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'doctorSchedules';
		}).hideElement = this.doctorSchedulesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'doctorSchedules').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'doctorOnExamination';
		}).hideElement = this.doctorOnExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'doctorOnExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'fluidBalanceDetails';
		}).hideElement = this.fluidBalanceDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'fluidBalanceDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'hemodialysisMonitorings';
		}).hideElement = this.hemodialysisMonitoringsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'hemodialysisMonitorings').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'hospitalBranchInformations';
		}).hideElement = this.hospitalBranchInformationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'hospitalBranchInformations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'informingConsents';
		}).hideElement = this.informingConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'informingConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoices';
		}).hideElement = this.invoicesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoices').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'mcuPackageItems';
		}).hideElement = this.mcuPackageItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'mcuPackageItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateDischargeResumes';
		}).hideElement = this.medicalCertificateDischargeResumesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateDischargeResumes').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateBirths';
		}).hideElement = this.medicalCertificateBirthsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateBirths').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateHospitalizations';
		}).hideElement = this.medicalCertificateHospitalizationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateHospitalizations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalExaminationRecordDischargeSummarys';
		}).hideElement = this.medicalExaminationRecordDischargeSummarysMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalExaminationRecordDischargeSummarys').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalRecordTranscriber';
		}).hideElement = this.medicalRecordTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalRecordTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalStaffOfMedicalAttendancesCertificate';
		}).hideElement = this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalStaffOfMedicalAttendancesCertificate').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalStaffOfMentalHealths';
		}).hideElement = this.medicalStaffOfMentalHealthsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalStaffOfMentalHealths').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalStaffOfPhysicalHealths';
		}).hideElement = this.medicalStaffOfPhysicalHealthsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalStaffOfPhysicalHealths').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalStaffOfRestrictedWorksCertificate';
		}).hideElement = this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalStaffOfRestrictedWorksCertificate').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalStaffOfSickLeavesCertificate';
		}).hideElement = this.medicalStaffOfSickLeavesCertificateMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalStaffOfSickLeavesCertificate').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicationAdministeredHisotries';
		}).hideElement = this.medicationAdministeredHisotriesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationAdministeredHisotries').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicationHeaders';
		}).hideElement = this.medicationHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'midwives';
		}).hideElement = this.midwivesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'midwives').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nurse';
		}).hideElement = this.nurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nursingDetailSurgicalNursing';
		}).hideElement = this.nursingDetailSurgicalNursingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nursingDetailSurgicalNursing').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nursingDetailsAnesthesiaNursing';
		}).hideElement = this.nursingDetailsAnesthesiaNursingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nursingDetailsAnesthesiaNursing').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientConsents';
		}).hideElement = this.patientConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVitalInformations';
		}).hideElement = this.patientVitalInformationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVitalInformations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'pediatricianInCharge';
		}).hideElement = this.pediatricianInChargeMultiCrudActive || this.modelRelations.find(rel => rel.id === 'pediatricianInCharge').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'prescriptionHeaders';
		}).hideElement = this.prescriptionHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'prescriptionHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'processWorkflowLogs';
		}).hideElement = this.processWorkflowLogsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'processWorkflowLogs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registrations';
		}).hideElement = this.registrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registrations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'requestedBy';
		}).hideElement = this.requestedByMultiCrudActive || this.modelRelations.find(rel => rel.id === 'requestedBy').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'roomTransfers';
		}).hideElement = this.roomTransfersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'roomTransfers').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sampleCollectionStaffs';
		}).hideElement = this.sampleCollectionStaffsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sampleCollectionStaffs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sampleDeliveryStaffs';
		}).hideElement = this.sampleDeliveryStaffsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sampleDeliveryStaffs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sampleProcessingStaffs';
		}).hideElement = this.sampleProcessingStaffsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sampleProcessingStaffs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgeon';
		}).hideElement = this.surgeonMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgeon').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgicalMedicalTranscriber';
		}).hideElement = this.surgicalMedicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgicalMedicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'surgicalNurse';
		}).hideElement = this.surgicalNurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'surgicalNurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'transferOrderStockDetails';
		}).hideElement = this.transferOrderStockDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'transferOrderStockDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'vaccinationOrders';
		}).hideElement = this.vaccinationOrdersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'vaccinationOrders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'services';
		}).hideElement = this.servicesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'services').hideElement;

	}

	/**
	 * Initialises the collections used for fetching the entities to display in multi entity crud for many relations.
	 * The same collection used to fetch entities for the relation dropdown cannot be reused, as we need to fetch a
	 * subset for these relations, and using the same collection will result in all entities being returned instead of the
	 * subset we are looking for.
	 *
	 * This method will only be populated if this entity has a many relation (i.e. it is the target of a 1:M relation, or is part of a
	 * M:M relation)
	 */
	initialiseMultiEntityCollections() {
		if (this.administrationUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.administrationUserDisplayName, many: false});
		}

		if (this.cashierUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.cashierUserDisplayName, many: false});
		}

		if (this.claimUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.claimUserDisplayName, many: false});
		}

		if (this.diagnosticSupportUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosticSupportUserDisplayName, many: false});
		}

		if (this.doctorUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.doctorUserDisplayName, many: false});
		}

		if (this.facilityUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.facilityUserDisplayName, many: false});
		}

		if (this.managementUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.managementUserDisplayName, many: false});
		}

		if (this.medicalRecordUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalRecordUserDisplayName, many: false});
		}

		if (this.medicalTranscriberUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalTranscriberUserDisplayName, many: false});
		}

		if (this.nurseUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nurseUserDisplayName, many: false});
		}

		if (this.pharmacyUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.pharmacyUserDisplayName, many: false});
		}

		if (this.purchasingUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.purchasingUserDisplayName, many: false});
		}

		if (this.registrationUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.registrationUserDisplayName, many: false});
		}

		if (this.systemAdminUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.systemAdminUserDisplayName, many: false});
		}

		if (this.warehouseUserMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.warehouseUserDisplayName, many: false});
		}

		if (this.administratorMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.administratorDisplayName, many: false});
		}

		if (this.bpjsDoctorMappingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDoctorMappingDisplayName, many: false});
		}

		if (this.pcareDokterMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.pcareDokterDisplayName, many: false});
		}

		if (this.serviceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.serviceDisplayName, many: false});
		}

		if (this.accompanyingConsentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.accompanyingConsentsDisplayName, many: true});
			this.store.dispatch(new informedConsentModelAction.InformedConsentAction(
				informedConsentModelAction.InformedConsentModelActionTypes.INITIALISE_INFORMED_CONSENT_COLLECTION_STATE,
				{
					collectionId: this.accompanyingConsentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInformedConsentCollectionModels, this.accompanyingConsentsCollectionId).subscribe(models => {
				models.forEach(accompanyingConsents => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InformedConsentModel.getProps(), this.accompanyingConsentsRelations, this.isViewOnly),
						accompanyingConsents,
						InformedConsentModel,
						this.accompanyingConsentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.accompanyingConsentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.amendmentDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.amendmentDetailsDisplayName, many: true});
			this.store.dispatch(new amendmentDetailModelAction.AmendmentDetailAction(
				amendmentDetailModelAction.AmendmentDetailModelActionTypes.INITIALISE_AMENDMENT_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.amendmentDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getAmendmentDetailCollectionModels, this.amendmentDetailsCollectionId).subscribe(models => {
				models.forEach(amendmentDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(AmendmentDetailModel.getProps(), this.amendmentDetailsRelations, this.isViewOnly),
						amendmentDetails,
						AmendmentDetailModel,
						this.amendmentDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.amendmentDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.anesthesiaMedicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiaMedicalTranscriberDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.anesthesiaMedicalTranscriberCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.anesthesiaMedicalTranscriberCollectionId).subscribe(models => {
				models.forEach(anesthesiaMedicalTranscriber => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiaMedicalTranscriberRelations, this.isViewOnly),
						anesthesiaMedicalTranscriber,
						PreoperativeRecordsModel,
						this.anesthesiaMedicalTranscriberDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.anesthesiaMedicalTranscriberRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.anesthesiologistMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiologistDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.anesthesiologistCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.anesthesiologistCollectionId).subscribe(models => {
				models.forEach(anesthesiologist => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiologistRelations, this.isViewOnly),
						anesthesiologist,
						PreoperativeRecordsModel,
						this.anesthesiologistDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.anesthesiologistRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.anesthesiologyNurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.anesthesiologyNurseDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.anesthesiologyNurseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.anesthesiologyNurseCollectionId).subscribe(models => {
				models.forEach(anesthesiologyNurse => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.anesthesiologyNurseRelations, this.isViewOnly),
						anesthesiologyNurse,
						PreoperativeRecordsModel,
						this.anesthesiologyNurseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.anesthesiologyNurseRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.cashierStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.cashierStaffDisplayName, many: true});
			this.store.dispatch(new cashReceiptModelAction.CashReceiptAction(
				cashReceiptModelAction.CashReceiptModelActionTypes.INITIALISE_CASH_RECEIPT_COLLECTION_STATE,
				{
					collectionId: this.cashierStaffCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCashReceiptCollectionModels, this.cashierStaffCollectionId).subscribe(models => {
				models.forEach(cashierStaff => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CashReceiptModel.getProps(), this.cashierStaffRelations, this.isViewOnly),
						cashierStaff,
						CashReceiptModel,
						this.cashierStaffDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.cashierStaffRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.coTreatingDoctorsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.coTreatingDoctorsDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.coTreatingDoctorsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.coTreatingDoctorsCollectionId).subscribe(models => {
				models.forEach(coTreatingDoctors => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingDoctorsRelations, this.isViewOnly),
						coTreatingDoctors,
						CoTreatingDoctorModel,
						this.coTreatingDoctorsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.coTreatingDoctorsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dailyCareCPPTsCreatedByStaffDisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.dailyCareCPPTsCreatedByStaffCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.dailyCareCPPTsCreatedByStaffCollectionId).subscribe(models => {
				models.forEach(dailyCareCPPTsCreatedByStaff => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsCreatedByStaffRelations, this.isViewOnly),
						dailyCareCPPTsCreatedByStaff,
						DailyCareCPPTModel,
						this.dailyCareCPPTsCreatedByStaffDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dailyCareCPPTsCreatedByStaffRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dailyCareCPPTsDoctorInChargeDisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.dailyCareCPPTsDoctorInChargeCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.dailyCareCPPTsDoctorInChargeCollectionId).subscribe(models => {
				models.forEach(dailyCareCPPTsDoctorInCharge => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsDoctorInChargeRelations, this.isViewOnly),
						dailyCareCPPTsDoctorInCharge,
						DailyCareCPPTModel,
						this.dailyCareCPPTsDoctorInChargeDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dailyCareCPPTsDoctorInChargeRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dailyCareCPPTsMedicalTranscriberDisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.dailyCareCPPTsMedicalTranscriberCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.dailyCareCPPTsMedicalTranscriberCollectionId).subscribe(models => {
				models.forEach(dailyCareCPPTsMedicalTranscriber => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsMedicalTranscriberRelations, this.isViewOnly),
						dailyCareCPPTsMedicalTranscriber,
						DailyCareCPPTModel,
						this.dailyCareCPPTsMedicalTranscriberDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dailyCareCPPTsMedicalTranscriberRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.deliveryProgressesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.deliveryProgressesDisplayName, many: true});
			this.store.dispatch(new deliveryProgressModelAction.DeliveryProgressAction(
				deliveryProgressModelAction.DeliveryProgressModelActionTypes.INITIALISE_DELIVERY_PROGRESS_COLLECTION_STATE,
				{
					collectionId: this.deliveryProgressesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDeliveryProgressCollectionModels, this.deliveryProgressesCollectionId).subscribe(models => {
				models.forEach(deliveryProgresses => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DeliveryProgressModel.getProps(), this.deliveryProgressesRelations, this.isViewOnly),
						deliveryProgresses,
						DeliveryProgressModel,
						this.deliveryProgressesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.deliveryProgressesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.diagnosticStaffExaminationSummariesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosticStaffExaminationSummariesDisplayName, many: true});
			this.store.dispatch(new diagnosticStaffExaminationSummaryModelAction.DiagnosticStaffExaminationSummaryAction(
				diagnosticStaffExaminationSummaryModelAction.DiagnosticStaffExaminationSummaryModelActionTypes.INITIALISE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_COLLECTION_STATE,
				{
					collectionId: this.diagnosticStaffExaminationSummariesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosticStaffExaminationSummaryCollectionModels, this.diagnosticStaffExaminationSummariesCollectionId).subscribe(models => {
				models.forEach(diagnosticStaffExaminationSummaries => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosticStaffExaminationSummaryModel.getProps(), this.diagnosticStaffExaminationSummariesRelations, this.isViewOnly),
						diagnosticStaffExaminationSummaries,
						DiagnosticStaffExaminationSummaryModel,
						this.diagnosticStaffExaminationSummariesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.diagnosticStaffExaminationSummariesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dismissalReferringStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dismissalReferringStaffDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.dismissalReferringStaffCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.dismissalReferringStaffCollectionId).subscribe(models => {
				models.forEach(dismissalReferringStaff => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.dismissalReferringStaffRelations, this.isViewOnly),
						dismissalReferringStaff,
						RegistrationModel,
						this.dismissalReferringStaffDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dismissalReferringStaffRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.doctorSchedulesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.doctorSchedulesDisplayName, many: true});
			this.store.dispatch(new doctorScheduleModelAction.DoctorScheduleAction(
				doctorScheduleModelAction.DoctorScheduleModelActionTypes.INITIALISE_DOCTOR_SCHEDULE_COLLECTION_STATE,
				{
					collectionId: this.doctorSchedulesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDoctorScheduleCollectionModels, this.doctorSchedulesCollectionId).subscribe(models => {
				models.forEach(doctorSchedules => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DoctorScheduleModel.getProps(), this.doctorSchedulesRelations, this.isViewOnly),
						doctorSchedules,
						DoctorScheduleModel,
						this.doctorSchedulesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.doctorSchedulesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.doctorOnExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.doctorOnExaminationDisplayName, many: true});
			this.store.dispatch(new medicalExaminationRecordModelAction.MedicalExaminationRecordAction(
				medicalExaminationRecordModelAction.MedicalExaminationRecordModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.doctorOnExaminationCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordCollectionModels, this.doctorOnExaminationCollectionId).subscribe(models => {
				models.forEach(doctorOnExamination => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.doctorOnExaminationRelations, this.isViewOnly),
						doctorOnExamination,
						MedicalExaminationRecordModel,
						this.doctorOnExaminationDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.doctorOnExaminationRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.fluidBalanceDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.fluidBalanceDetailsDisplayName, many: true});
			this.store.dispatch(new fluidBalanceDetailModelAction.FluidBalanceDetailAction(
				fluidBalanceDetailModelAction.FluidBalanceDetailModelActionTypes.INITIALISE_FLUID_BALANCE_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.fluidBalanceDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getFluidBalanceDetailCollectionModels, this.fluidBalanceDetailsCollectionId).subscribe(models => {
				models.forEach(fluidBalanceDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(FluidBalanceDetailModel.getProps(), this.fluidBalanceDetailsRelations, this.isViewOnly),
						fluidBalanceDetails,
						FluidBalanceDetailModel,
						this.fluidBalanceDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.fluidBalanceDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.hemodialysisMonitoringsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.hemodialysisMonitoringsDisplayName, many: true});
			this.store.dispatch(new hemodialysisMonitoringModelAction.HemodialysisMonitoringAction(
				hemodialysisMonitoringModelAction.HemodialysisMonitoringModelActionTypes.INITIALISE_HEMODIALYSIS_MONITORING_COLLECTION_STATE,
				{
					collectionId: this.hemodialysisMonitoringsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getHemodialysisMonitoringCollectionModels, this.hemodialysisMonitoringsCollectionId).subscribe(models => {
				models.forEach(hemodialysisMonitorings => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(HemodialysisMonitoringModel.getProps(), this.hemodialysisMonitoringsRelations, this.isViewOnly),
						hemodialysisMonitorings,
						HemodialysisMonitoringModel,
						this.hemodialysisMonitoringsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.hemodialysisMonitoringsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.hospitalBranchInformationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.hospitalBranchInformationsDisplayName, many: true});
			this.store.dispatch(new hospitalBranchInformationModelAction.HospitalBranchInformationAction(
				hospitalBranchInformationModelAction.HospitalBranchInformationModelActionTypes.INITIALISE_HOSPITAL_BRANCH_INFORMATION_COLLECTION_STATE,
				{
					collectionId: this.hospitalBranchInformationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getHospitalBranchInformationCollectionModels, this.hospitalBranchInformationsCollectionId).subscribe(models => {
				models.forEach(hospitalBranchInformations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(HospitalBranchInformationModel.getProps(), this.hospitalBranchInformationsRelations, this.isViewOnly),
						hospitalBranchInformations,
						HospitalBranchInformationModel,
						this.hospitalBranchInformationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.hospitalBranchInformationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.informingConsentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.informingConsentsDisplayName, many: true});
			this.store.dispatch(new informedConsentModelAction.InformedConsentAction(
				informedConsentModelAction.InformedConsentModelActionTypes.INITIALISE_INFORMED_CONSENT_COLLECTION_STATE,
				{
					collectionId: this.informingConsentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInformedConsentCollectionModels, this.informingConsentsCollectionId).subscribe(models => {
				models.forEach(informingConsents => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InformedConsentModel.getProps(), this.informingConsentsRelations, this.isViewOnly),
						informingConsents,
						InformedConsentModel,
						this.informingConsentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.informingConsentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoicesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicesDisplayName, many: true});
			this.store.dispatch(new invoiceModelAction.InvoiceAction(
				invoiceModelAction.InvoiceModelActionTypes.INITIALISE_INVOICE_COLLECTION_STATE,
				{
					collectionId: this.invoicesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceCollectionModels, this.invoicesCollectionId).subscribe(models => {
				models.forEach(invoices => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesRelations, this.isViewOnly),
						invoices,
						InvoiceModel,
						this.invoicesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoicesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.mcuPackageItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.mcuPackageItemsDisplayName, many: true});
			this.store.dispatch(new mcuPackageItemModelAction.McuPackageItemAction(
				mcuPackageItemModelAction.McuPackageItemModelActionTypes.INITIALISE_MCU_PACKAGE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.mcuPackageItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMcuPackageItemCollectionModels, this.mcuPackageItemsCollectionId).subscribe(models => {
				models.forEach(mcuPackageItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(McuPackageItemModel.getProps(), this.mcuPackageItemsRelations, this.isViewOnly),
						mcuPackageItems,
						McuPackageItemModel,
						this.mcuPackageItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.mcuPackageItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalCertificateDischargeResumesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateDischargeResumesDisplayName, many: true});
			this.store.dispatch(new medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeAction(
				medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_COLLECTION_STATE,
				{
					collectionId: this.medicalCertificateDischargeResumesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateDischargeResumeCollectionModels, this.medicalCertificateDischargeResumesCollectionId).subscribe(models => {
				models.forEach(medicalCertificateDischargeResumes => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.medicalCertificateDischargeResumesRelations, this.isViewOnly),
						medicalCertificateDischargeResumes,
						MedicalCertificateDischargeResumeModel,
						this.medicalCertificateDischargeResumesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalCertificateDischargeResumesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalCertificateBirthsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateBirthsDisplayName, many: true});
			this.store.dispatch(new medicalCertificateBirthModelAction.MedicalCertificateBirthAction(
				medicalCertificateBirthModelAction.MedicalCertificateBirthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_BIRTH_COLLECTION_STATE,
				{
					collectionId: this.medicalCertificateBirthsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateBirthCollectionModels, this.medicalCertificateBirthsCollectionId).subscribe(models => {
				models.forEach(medicalCertificateBirths => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateBirthModel.getProps(), this.medicalCertificateBirthsRelations, this.isViewOnly),
						medicalCertificateBirths,
						MedicalCertificateBirthModel,
						this.medicalCertificateBirthsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalCertificateBirthsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalCertificateHospitalizationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateHospitalizationsDisplayName, many: true});
			this.store.dispatch(new medicalCertificateHospitalizationModelAction.MedicalCertificateHospitalizationAction(
				medicalCertificateHospitalizationModelAction.MedicalCertificateHospitalizationModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_HOSPITALIZATION_COLLECTION_STATE,
				{
					collectionId: this.medicalCertificateHospitalizationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateHospitalizationCollectionModels, this.medicalCertificateHospitalizationsCollectionId).subscribe(models => {
				models.forEach(medicalCertificateHospitalizations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateHospitalizationModel.getProps(), this.medicalCertificateHospitalizationsRelations, this.isViewOnly),
						medicalCertificateHospitalizations,
						MedicalCertificateHospitalizationModel,
						this.medicalCertificateHospitalizationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalCertificateHospitalizationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalExaminationRecordDischargeSummarysDisplayName, many: true});
			this.store.dispatch(new medicalExaminationRecordDischargeSummaryModelAction.MedicalExaminationRecordDischargeSummaryAction(
				medicalExaminationRecordDischargeSummaryModelAction.MedicalExaminationRecordDischargeSummaryModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_COLLECTION_STATE,
				{
					collectionId: this.medicalExaminationRecordDischargeSummarysCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordDischargeSummaryCollectionModels, this.medicalExaminationRecordDischargeSummarysCollectionId).subscribe(models => {
				models.forEach(medicalExaminationRecordDischargeSummarys => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalExaminationRecordDischargeSummaryModel.getProps(), this.medicalExaminationRecordDischargeSummarysRelations, this.isViewOnly),
						medicalExaminationRecordDischargeSummarys,
						MedicalExaminationRecordDischargeSummaryModel,
						this.medicalExaminationRecordDischargeSummarysDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalExaminationRecordDischargeSummarysRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalRecordTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalRecordTranscriberDisplayName, many: true});
			this.store.dispatch(new medicalExaminationRecordModelAction.MedicalExaminationRecordAction(
				medicalExaminationRecordModelAction.MedicalExaminationRecordModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.medicalRecordTranscriberCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordCollectionModels, this.medicalRecordTranscriberCollectionId).subscribe(models => {
				models.forEach(medicalRecordTranscriber => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.medicalRecordTranscriberRelations, this.isViewOnly),
						medicalRecordTranscriber,
						MedicalExaminationRecordModel,
						this.medicalRecordTranscriberDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalRecordTranscriberRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalStaffOfMedicalAttendancesCertificateDisplayName, many: true});
			this.store.dispatch(new medicalCertificateMedicalAttendanceModelAction.MedicalCertificateMedicalAttendanceAction(
				medicalCertificateMedicalAttendanceModelAction.MedicalCertificateMedicalAttendanceModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_COLLECTION_STATE,
				{
					collectionId: this.medicalStaffOfMedicalAttendancesCertificateCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateMedicalAttendanceCollectionModels, this.medicalStaffOfMedicalAttendancesCertificateCollectionId).subscribe(models => {
				models.forEach(medicalStaffOfMedicalAttendancesCertificate => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateMedicalAttendanceModel.getProps(), this.medicalStaffOfMedicalAttendancesCertificateRelations, this.isViewOnly),
						medicalStaffOfMedicalAttendancesCertificate,
						MedicalCertificateMedicalAttendanceModel,
						this.medicalStaffOfMedicalAttendancesCertificateDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalStaffOfMedicalAttendancesCertificateRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalStaffOfMentalHealthsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalStaffOfMentalHealthsDisplayName, many: true});
			this.store.dispatch(new medicalCertificateMentalHealthModelAction.MedicalCertificateMentalHealthAction(
				medicalCertificateMentalHealthModelAction.MedicalCertificateMentalHealthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_COLLECTION_STATE,
				{
					collectionId: this.medicalStaffOfMentalHealthsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateMentalHealthCollectionModels, this.medicalStaffOfMentalHealthsCollectionId).subscribe(models => {
				models.forEach(medicalStaffOfMentalHealths => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateMentalHealthModel.getProps(), this.medicalStaffOfMentalHealthsRelations, this.isViewOnly),
						medicalStaffOfMentalHealths,
						MedicalCertificateMentalHealthModel,
						this.medicalStaffOfMentalHealthsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalStaffOfMentalHealthsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalStaffOfPhysicalHealthsDisplayName, many: true});
			this.store.dispatch(new medicalCertificatePhysicalHealthModelAction.MedicalCertificatePhysicalHealthAction(
				medicalCertificatePhysicalHealthModelAction.MedicalCertificatePhysicalHealthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_COLLECTION_STATE,
				{
					collectionId: this.medicalStaffOfPhysicalHealthsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificatePhysicalHealthCollectionModels, this.medicalStaffOfPhysicalHealthsCollectionId).subscribe(models => {
				models.forEach(medicalStaffOfPhysicalHealths => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificatePhysicalHealthModel.getProps(), this.medicalStaffOfPhysicalHealthsRelations, this.isViewOnly),
						medicalStaffOfPhysicalHealths,
						MedicalCertificatePhysicalHealthModel,
						this.medicalStaffOfPhysicalHealthsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalStaffOfPhysicalHealthsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalStaffOfRestrictedWorksCertificateDisplayName, many: true});
			this.store.dispatch(new medicalCertificateRestrictedWorkModelAction.MedicalCertificateRestrictedWorkAction(
				medicalCertificateRestrictedWorkModelAction.MedicalCertificateRestrictedWorkModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_COLLECTION_STATE,
				{
					collectionId: this.medicalStaffOfRestrictedWorksCertificateCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateRestrictedWorkCollectionModels, this.medicalStaffOfRestrictedWorksCertificateCollectionId).subscribe(models => {
				models.forEach(medicalStaffOfRestrictedWorksCertificate => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateRestrictedWorkModel.getProps(), this.medicalStaffOfRestrictedWorksCertificateRelations, this.isViewOnly),
						medicalStaffOfRestrictedWorksCertificate,
						MedicalCertificateRestrictedWorkModel,
						this.medicalStaffOfRestrictedWorksCertificateDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalStaffOfRestrictedWorksCertificateRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalStaffOfSickLeavesCertificateDisplayName, many: true});
			this.store.dispatch(new medicalCertificateSickLeaveModelAction.MedicalCertificateSickLeaveAction(
				medicalCertificateSickLeaveModelAction.MedicalCertificateSickLeaveModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_SICK_LEAVE_COLLECTION_STATE,
				{
					collectionId: this.medicalStaffOfSickLeavesCertificateCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateSickLeaveCollectionModels, this.medicalStaffOfSickLeavesCertificateCollectionId).subscribe(models => {
				models.forEach(medicalStaffOfSickLeavesCertificate => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateSickLeaveModel.getProps(), this.medicalStaffOfSickLeavesCertificateRelations, this.isViewOnly),
						medicalStaffOfSickLeavesCertificate,
						MedicalCertificateSickLeaveModel,
						this.medicalStaffOfSickLeavesCertificateDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalStaffOfSickLeavesCertificateRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicationAdministeredHisotriesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationAdministeredHisotriesDisplayName, many: true});
			this.store.dispatch(new medicationAdministeredHistoryModelAction.MedicationAdministeredHistoryAction(
				medicationAdministeredHistoryModelAction.MedicationAdministeredHistoryModelActionTypes.INITIALISE_MEDICATION_ADMINISTERED_HISTORY_COLLECTION_STATE,
				{
					collectionId: this.medicationAdministeredHisotriesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationAdministeredHistoryCollectionModels, this.medicationAdministeredHisotriesCollectionId).subscribe(models => {
				models.forEach(medicationAdministeredHisotries => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicationAdministeredHistoryModel.getProps(), this.medicationAdministeredHisotriesRelations, this.isViewOnly),
						medicationAdministeredHisotries,
						MedicationAdministeredHistoryModel,
						this.medicationAdministeredHisotriesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicationAdministeredHisotriesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicationHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationHeadersDisplayName, many: true});
			this.store.dispatch(new medicationHeaderModelAction.MedicationHeaderAction(
				medicationHeaderModelAction.MedicationHeaderModelActionTypes.INITIALISE_MEDICATION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.medicationHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationHeaderCollectionModels, this.medicationHeadersCollectionId).subscribe(models => {
				models.forEach(medicationHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
						medicationHeaders,
						MedicationHeaderModel,
						this.medicationHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicationHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.midwivesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.midwivesDisplayName, many: true});
			this.store.dispatch(new deliveryMedicalExaminationRecordModelAction.DeliveryMedicalExaminationRecordAction(
				deliveryMedicalExaminationRecordModelAction.DeliveryMedicalExaminationRecordModelActionTypes.INITIALISE_DELIVERY_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.midwivesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDeliveryMedicalExaminationRecordCollectionModels, this.midwivesCollectionId).subscribe(models => {
				models.forEach(midwives => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DeliveryMedicalExaminationRecordModel.getProps(), this.midwivesRelations, this.isViewOnly),
						midwives,
						DeliveryMedicalExaminationRecordModel,
						this.midwivesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.midwivesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.nurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nurseDisplayName, many: true});
			this.store.dispatch(new medicalExaminationRecordModelAction.MedicalExaminationRecordAction(
				medicalExaminationRecordModelAction.MedicalExaminationRecordModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.nurseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordCollectionModels, this.nurseCollectionId).subscribe(models => {
				models.forEach(nurse => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.nurseRelations, this.isViewOnly),
						nurse,
						MedicalExaminationRecordModel,
						this.nurseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.nurseRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.nursingDetailSurgicalNursingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nursingDetailSurgicalNursingDisplayName, many: true});
			this.store.dispatch(new operatingTheaterMedicalExaminationRecordModelAction.OperatingTheaterMedicalExaminationRecordAction(
				operatingTheaterMedicalExaminationRecordModelAction.OperatingTheaterMedicalExaminationRecordModelActionTypes.INITIALISE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.nursingDetailSurgicalNursingCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getOperatingTheaterMedicalExaminationRecordCollectionModels, this.nursingDetailSurgicalNursingCollectionId).subscribe(models => {
				models.forEach(nursingDetailSurgicalNursing => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.nursingDetailSurgicalNursingRelations, this.isViewOnly),
						nursingDetailSurgicalNursing,
						OperatingTheaterMedicalExaminationRecordModel,
						this.nursingDetailSurgicalNursingDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.nursingDetailSurgicalNursingRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nursingDetailsAnesthesiaNursingDisplayName, many: true});
			this.store.dispatch(new operatingTheaterMedicalExaminationRecordModelAction.OperatingTheaterMedicalExaminationRecordAction(
				operatingTheaterMedicalExaminationRecordModelAction.OperatingTheaterMedicalExaminationRecordModelActionTypes.INITIALISE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.nursingDetailsAnesthesiaNursingCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getOperatingTheaterMedicalExaminationRecordCollectionModels, this.nursingDetailsAnesthesiaNursingCollectionId).subscribe(models => {
				models.forEach(nursingDetailsAnesthesiaNursing => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.nursingDetailsAnesthesiaNursingRelations, this.isViewOnly),
						nursingDetailsAnesthesiaNursing,
						OperatingTheaterMedicalExaminationRecordModel,
						this.nursingDetailsAnesthesiaNursingDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.nursingDetailsAnesthesiaNursingRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientConsentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientConsentsDisplayName, many: true});
			this.store.dispatch(new patientConsentModelAction.PatientConsentAction(
				patientConsentModelAction.PatientConsentModelActionTypes.INITIALISE_PATIENT_CONSENT_COLLECTION_STATE,
				{
					collectionId: this.patientConsentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientConsentCollectionModels, this.patientConsentsCollectionId).subscribe(models => {
				models.forEach(patientConsents => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientConsentModel.getProps(), this.patientConsentsRelations, this.isViewOnly),
						patientConsents,
						PatientConsentModel,
						this.patientConsentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientConsentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientVitalInformationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVitalInformationsDisplayName, many: true});
			this.store.dispatch(new patientVitalInformationModelAction.PatientVitalInformationAction(
				patientVitalInformationModelAction.PatientVitalInformationModelActionTypes.INITIALISE_PATIENT_VITAL_INFORMATION_COLLECTION_STATE,
				{
					collectionId: this.patientVitalInformationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVitalInformationCollectionModels, this.patientVitalInformationsCollectionId).subscribe(models => {
				models.forEach(patientVitalInformations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientVitalInformationModel.getProps(), this.patientVitalInformationsRelations, this.isViewOnly),
						patientVitalInformations,
						PatientVitalInformationModel,
						this.patientVitalInformationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientVitalInformationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.pediatricianInChargeMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.pediatricianInChargeDisplayName, many: true});
			this.store.dispatch(new newbornDetailModelAction.NewbornDetailAction(
				newbornDetailModelAction.NewbornDetailModelActionTypes.INITIALISE_NEWBORN_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.pediatricianInChargeCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getNewbornDetailCollectionModels, this.pediatricianInChargeCollectionId).subscribe(models => {
				models.forEach(pediatricianInCharge => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(NewbornDetailModel.getProps(), this.pediatricianInChargeRelations, this.isViewOnly),
						pediatricianInCharge,
						NewbornDetailModel,
						this.pediatricianInChargeDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.pediatricianInChargeRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.prescriptionHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.prescriptionHeadersDisplayName, many: true});
			this.store.dispatch(new prescriptionHeaderModelAction.PrescriptionHeaderAction(
				prescriptionHeaderModelAction.PrescriptionHeaderModelActionTypes.INITIALISE_PRESCRIPTION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.prescriptionHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPrescriptionHeaderCollectionModels, this.prescriptionHeadersCollectionId).subscribe(models => {
				models.forEach(prescriptionHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
						prescriptionHeaders,
						PrescriptionHeaderModel,
						this.prescriptionHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.prescriptionHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.processWorkflowLogsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.processWorkflowLogsDisplayName, many: true});
			this.store.dispatch(new processWorkflowModelAction.ProcessWorkflowAction(
				processWorkflowModelAction.ProcessWorkflowModelActionTypes.INITIALISE_PROCESS_WORKFLOW_COLLECTION_STATE,
				{
					collectionId: this.processWorkflowLogsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getProcessWorkflowCollectionModels, this.processWorkflowLogsCollectionId).subscribe(models => {
				models.forEach(processWorkflowLogs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ProcessWorkflowModel.getProps(), this.processWorkflowLogsRelations, this.isViewOnly),
						processWorkflowLogs,
						ProcessWorkflowModel,
						this.processWorkflowLogsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.processWorkflowLogsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.registrationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.registrationsDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.registrationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.registrationsCollectionId).subscribe(models => {
				models.forEach(registrations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationsRelations, this.isViewOnly),
						registrations,
						RegistrationModel,
						this.registrationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.registrationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.requestedByMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.requestedByDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.requestedByCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.requestedByCollectionId).subscribe(models => {
				models.forEach(requestedBy => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.requestedByRelations, this.isViewOnly),
						requestedBy,
						RegistrationModel,
						this.requestedByDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.requestedByRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.roomTransfersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.roomTransfersDisplayName, many: true});
			this.store.dispatch(new roomTransferModelAction.RoomTransferAction(
				roomTransferModelAction.RoomTransferModelActionTypes.INITIALISE_ROOM_TRANSFER_COLLECTION_STATE,
				{
					collectionId: this.roomTransfersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRoomTransferCollectionModels, this.roomTransfersCollectionId).subscribe(models => {
				models.forEach(roomTransfers => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
						roomTransfers,
						RoomTransferModel,
						this.roomTransfersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.roomTransfersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.sampleCollectionStaffsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sampleCollectionStaffsDisplayName, many: true});
			this.store.dispatch(new sampleCollectionItemsModelAction.SampleCollectionItemsAction(
				sampleCollectionItemsModelAction.SampleCollectionItemsModelActionTypes.INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE,
				{
					collectionId: this.sampleCollectionStaffsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSampleCollectionItemsCollectionModels, this.sampleCollectionStaffsCollectionId).subscribe(models => {
				models.forEach(sampleCollectionStaffs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleCollectionStaffsRelations, this.isViewOnly),
						sampleCollectionStaffs,
						SampleCollectionItemsModel,
						this.sampleCollectionStaffsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.sampleCollectionStaffsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.sampleDeliveryStaffsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sampleDeliveryStaffsDisplayName, many: true});
			this.store.dispatch(new sampleCollectionItemsModelAction.SampleCollectionItemsAction(
				sampleCollectionItemsModelAction.SampleCollectionItemsModelActionTypes.INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE,
				{
					collectionId: this.sampleDeliveryStaffsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSampleCollectionItemsCollectionModels, this.sampleDeliveryStaffsCollectionId).subscribe(models => {
				models.forEach(sampleDeliveryStaffs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleDeliveryStaffsRelations, this.isViewOnly),
						sampleDeliveryStaffs,
						SampleCollectionItemsModel,
						this.sampleDeliveryStaffsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.sampleDeliveryStaffsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.sampleProcessingStaffsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sampleProcessingStaffsDisplayName, many: true});
			this.store.dispatch(new sampleCollectionItemsModelAction.SampleCollectionItemsAction(
				sampleCollectionItemsModelAction.SampleCollectionItemsModelActionTypes.INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE,
				{
					collectionId: this.sampleProcessingStaffsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSampleCollectionItemsCollectionModels, this.sampleProcessingStaffsCollectionId).subscribe(models => {
				models.forEach(sampleProcessingStaffs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SampleCollectionItemsModel.getProps(), this.sampleProcessingStaffsRelations, this.isViewOnly),
						sampleProcessingStaffs,
						SampleCollectionItemsModel,
						this.sampleProcessingStaffsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.sampleProcessingStaffsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.surgeonMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgeonDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.surgeonCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.surgeonCollectionId).subscribe(models => {
				models.forEach(surgeon => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgeonRelations, this.isViewOnly),
						surgeon,
						PreoperativeRecordsModel,
						this.surgeonDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.surgeonRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.surgicalMedicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgicalMedicalTranscriberDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.surgicalMedicalTranscriberCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.surgicalMedicalTranscriberCollectionId).subscribe(models => {
				models.forEach(surgicalMedicalTranscriber => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgicalMedicalTranscriberRelations, this.isViewOnly),
						surgicalMedicalTranscriber,
						PreoperativeRecordsModel,
						this.surgicalMedicalTranscriberDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.surgicalMedicalTranscriberRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.surgicalNurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.surgicalNurseDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.surgicalNurseCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.surgicalNurseCollectionId).subscribe(models => {
				models.forEach(surgicalNurse => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.surgicalNurseRelations, this.isViewOnly),
						surgicalNurse,
						PreoperativeRecordsModel,
						this.surgicalNurseDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.surgicalNurseRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.transferOrderStockDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.transferOrderStockDetailsDisplayName, many: true});
			this.store.dispatch(new transferOrderStockDetailModelAction.TransferOrderStockDetailAction(
				transferOrderStockDetailModelAction.TransferOrderStockDetailModelActionTypes.INITIALISE_TRANSFER_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.transferOrderStockDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getTransferOrderStockDetailCollectionModels, this.transferOrderStockDetailsCollectionId).subscribe(models => {
				models.forEach(transferOrderStockDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(TransferOrderStockDetailModel.getProps(), this.transferOrderStockDetailsRelations, this.isViewOnly),
						transferOrderStockDetails,
						TransferOrderStockDetailModel,
						this.transferOrderStockDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.transferOrderStockDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.vaccinationOrdersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.vaccinationOrdersDisplayName, many: true});
			this.store.dispatch(new vaccinationOrderModelAction.VaccinationOrderAction(
				vaccinationOrderModelAction.VaccinationOrderModelActionTypes.INITIALISE_VACCINATION_ORDER_COLLECTION_STATE,
				{
					collectionId: this.vaccinationOrdersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getVaccinationOrderCollectionModels, this.vaccinationOrdersCollectionId).subscribe(models => {
				models.forEach(vaccinationOrders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(VaccinationOrderModel.getProps(), this.vaccinationOrdersRelations, this.isViewOnly),
						vaccinationOrders,
						VaccinationOrderModel,
						this.vaccinationOrdersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.vaccinationOrdersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.servicesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.servicesDisplayName, many: true});
			this.store.dispatch(new serviceModelAction.ServiceAction(
				serviceModelAction.ServiceModelActionTypes.INITIALISE_SERVICE_COLLECTION_STATE,
				{
					collectionId: this.servicesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceCollectionModels, this.servicesCollectionId).subscribe(models => {
				models.forEach(services => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ServiceModel.getProps(), this.servicesRelations, this.isViewOnly),
						services,
						ServiceModel,
						this.servicesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.servicesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.administrator && this.targetModel.administrator.id && this.administratorMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				AdministratorModel,
				this.administratorOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.administrator.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getAdministratorModelWithId, this.targetModel.administratorId).subscribe(administrator => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AdministratorModel.getProps(), this.administratorRelations, this.isViewOnly),
					administrator,
					AdministratorModel,
					this.administratorDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.administratorRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDoctorMapping && this.targetModel.bpjsDoctorMapping.id && this.bpjsDoctorMappingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDoctorMappingModel,
				this.bpjsDoctorMappingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDoctorMapping.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDoctorMappingModelWithId, this.targetModel.bpjsDoctorMappingId).subscribe(bpjsDoctorMapping => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDoctorMappingModel.getProps(), this.bpjsDoctorMappingRelations, this.isViewOnly),
					bpjsDoctorMapping,
					BpjsDoctorMappingModel,
					this.bpjsDoctorMappingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDoctorMappingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.pcareDokter && this.targetModel.pcareDokter.id && this.pcareDokterMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PcareDokterModel,
				this.pcareDokterOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.pcareDokter.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPcareDokterModelWithId, this.targetModel.pcareDokterId).subscribe(pcareDokter => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PcareDokterModel.getProps(), this.pcareDokterRelations, this.isViewOnly),
					pcareDokter,
					PcareDokterModel,
					this.pcareDokterDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pcareDokterRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.service && this.targetModel.service.id && this.serviceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceModel,
				this.serviceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.service.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModel.serviceId).subscribe(service => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					service,
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.administrationUser && this.targetModel.administrationUser.id && this.administrationUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				AdministrationUserModel,
				this.administrationUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.administrationUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getAdministrationUserModelWithId, this.targetModel.administrationUserId).subscribe(administrationUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AdministrationUserModel.getProps(), this.administrationUserRelations, this.isViewOnly),
					administrationUser,
					AdministrationUserModel,
					this.administrationUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.administrationUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.cashierUser && this.targetModel.cashierUser.id && this.cashierUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CashierUserModel,
				this.cashierUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.cashierUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getCashierUserModelWithId, this.targetModel.cashierUserId).subscribe(cashierUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CashierUserModel.getProps(), this.cashierUserRelations, this.isViewOnly),
					cashierUser,
					CashierUserModel,
					this.cashierUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cashierUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.claimUser && this.targetModel.claimUser.id && this.claimUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ClaimUserModel,
				this.claimUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.claimUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getClaimUserModelWithId, this.targetModel.claimUserId).subscribe(claimUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ClaimUserModel.getProps(), this.claimUserRelations, this.isViewOnly),
					claimUser,
					ClaimUserModel,
					this.claimUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.claimUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.diagnosticSupportUser && this.targetModel.diagnosticSupportUser.id && this.diagnosticSupportUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosticSupportUserModel,
				this.diagnosticSupportUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.diagnosticSupportUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosticSupportUserModelWithId, this.targetModel.diagnosticSupportUserId).subscribe(diagnosticSupportUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticSupportUserModel.getProps(), this.diagnosticSupportUserRelations, this.isViewOnly),
					diagnosticSupportUser,
					DiagnosticSupportUserModel,
					this.diagnosticSupportUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticSupportUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.doctorUser && this.targetModel.doctorUser.id && this.doctorUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DoctorUserModel,
				this.doctorUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.doctorUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDoctorUserModelWithId, this.targetModel.doctorUserId).subscribe(doctorUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DoctorUserModel.getProps(), this.doctorUserRelations, this.isViewOnly),
					doctorUser,
					DoctorUserModel,
					this.doctorUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.facilityUser && this.targetModel.facilityUser.id && this.facilityUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				FacilityUserModel,
				this.facilityUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.facilityUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getFacilityUserModelWithId, this.targetModel.facilityUserId).subscribe(facilityUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FacilityUserModel.getProps(), this.facilityUserRelations, this.isViewOnly),
					facilityUser,
					FacilityUserModel,
					this.facilityUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.facilityUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.managementUser && this.targetModel.managementUser.id && this.managementUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ManagementUserModel,
				this.managementUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.managementUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getManagementUserModelWithId, this.targetModel.managementUserId).subscribe(managementUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ManagementUserModel.getProps(), this.managementUserRelations, this.isViewOnly),
					managementUser,
					ManagementUserModel,
					this.managementUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.managementUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalRecordUser && this.targetModel.medicalRecordUser.id && this.medicalRecordUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalRecordUserModel,
				this.medicalRecordUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalRecordUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalRecordUserModelWithId, this.targetModel.medicalRecordUserId).subscribe(medicalRecordUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordUserModel.getProps(), this.medicalRecordUserRelations, this.isViewOnly),
					medicalRecordUser,
					MedicalRecordUserModel,
					this.medicalRecordUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalTranscriberUser && this.targetModel.medicalTranscriberUser.id && this.medicalTranscriberUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalTranscriberUserModel,
				this.medicalTranscriberUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalTranscriberUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalTranscriberUserModelWithId, this.targetModel.medicalTranscriberUserId).subscribe(medicalTranscriberUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalTranscriberUserModel.getProps(), this.medicalTranscriberUserRelations, this.isViewOnly),
					medicalTranscriberUser,
					MedicalTranscriberUserModel,
					this.medicalTranscriberUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalTranscriberUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.nurseUser && this.targetModel.nurseUser.id && this.nurseUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				NurseUserModel,
				this.nurseUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.nurseUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getNurseUserModelWithId, this.targetModel.nurseUserId).subscribe(nurseUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(NurseUserModel.getProps(), this.nurseUserRelations, this.isViewOnly),
					nurseUser,
					NurseUserModel,
					this.nurseUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.pharmacyUser && this.targetModel.pharmacyUser.id && this.pharmacyUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PharmacyUserModel,
				this.pharmacyUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.pharmacyUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPharmacyUserModelWithId, this.targetModel.pharmacyUserId).subscribe(pharmacyUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PharmacyUserModel.getProps(), this.pharmacyUserRelations, this.isViewOnly),
					pharmacyUser,
					PharmacyUserModel,
					this.pharmacyUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pharmacyUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.purchasingUser && this.targetModel.purchasingUser.id && this.purchasingUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PurchasingUserModel,
				this.purchasingUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.purchasingUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPurchasingUserModelWithId, this.targetModel.purchasingUserId).subscribe(purchasingUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PurchasingUserModel.getProps(), this.purchasingUserRelations, this.isViewOnly),
					purchasingUser,
					PurchasingUserModel,
					this.purchasingUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.purchasingUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.registrationUser && this.targetModel.registrationUser.id && this.registrationUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationUserModel,
				this.registrationUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.registrationUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationUserModelWithId, this.targetModel.registrationUserId).subscribe(registrationUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationUserModel.getProps(), this.registrationUserRelations, this.isViewOnly),
					registrationUser,
					RegistrationUserModel,
					this.registrationUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.systemAdminUser && this.targetModel.systemAdminUser.id && this.systemAdminUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SystemAdminUserModel,
				this.systemAdminUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.systemAdminUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getSystemAdminUserModelWithId, this.targetModel.systemAdminUserId).subscribe(systemAdminUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SystemAdminUserModel.getProps(), this.systemAdminUserRelations, this.isViewOnly),
					systemAdminUser,
					SystemAdminUserModel,
					this.systemAdminUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.systemAdminUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.warehouseUser && this.targetModel.warehouseUser.id && this.warehouseUserMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				WarehouseUserModel,
				this.warehouseUserOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.warehouseUser.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getWarehouseUserModelWithId, this.targetModel.warehouseUserId).subscribe(warehouseUser => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(WarehouseUserModel.getProps(), this.warehouseUserRelations, this.isViewOnly),
					warehouseUser,
					WarehouseUserModel,
					this.warehouseUserDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.warehouseUserRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.accompanyingConsentsIds && this.targetModel.accompanyingConsentsIds.length > 0 && this.accompanyingConsentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InformedConsentModel,
				this.accompanyingConsentsOppositeRelation,
				this.accompanyingConsentsCollectionId,
				this.targetModel.accompanyingConsentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.amendmentDetailsIds && this.targetModel.amendmentDetailsIds.length > 0 && this.amendmentDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				AmendmentDetailModel,
				this.amendmentDetailsOppositeRelation,
				this.amendmentDetailsCollectionId,
				this.targetModel.amendmentDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.anesthesiaMedicalTranscriberIds && this.targetModel.anesthesiaMedicalTranscriberIds.length > 0 && this.anesthesiaMedicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.anesthesiaMedicalTranscriberOppositeRelation,
				this.anesthesiaMedicalTranscriberCollectionId,
				this.targetModel.anesthesiaMedicalTranscriberIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.anesthesiologistIds && this.targetModel.anesthesiologistIds.length > 0 && this.anesthesiologistMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.anesthesiologistOppositeRelation,
				this.anesthesiologistCollectionId,
				this.targetModel.anesthesiologistIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.anesthesiologyNurseIds && this.targetModel.anesthesiologyNurseIds.length > 0 && this.anesthesiologyNurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.anesthesiologyNurseOppositeRelation,
				this.anesthesiologyNurseCollectionId,
				this.targetModel.anesthesiologyNurseIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.cashierStaffIds && this.targetModel.cashierStaffIds.length > 0 && this.cashierStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CashReceiptModel,
				this.cashierStaffOppositeRelation,
				this.cashierStaffCollectionId,
				this.targetModel.cashierStaffIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.coTreatingDoctorsIds && this.targetModel.coTreatingDoctorsIds.length > 0 && this.coTreatingDoctorsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.coTreatingDoctorsOppositeRelation,
				this.coTreatingDoctorsCollectionId,
				this.targetModel.coTreatingDoctorsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dailyCareCPPTsCreatedByStaffIds && this.targetModel.dailyCareCPPTsCreatedByStaffIds.length > 0 && this.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.dailyCareCPPTsCreatedByStaffOppositeRelation,
				this.dailyCareCPPTsCreatedByStaffCollectionId,
				this.targetModel.dailyCareCPPTsCreatedByStaffIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dailyCareCPPTsDoctorInChargeIds && this.targetModel.dailyCareCPPTsDoctorInChargeIds.length > 0 && this.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.dailyCareCPPTsDoctorInChargeOppositeRelation,
				this.dailyCareCPPTsDoctorInChargeCollectionId,
				this.targetModel.dailyCareCPPTsDoctorInChargeIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dailyCareCPPTsMedicalTranscriberIds && this.targetModel.dailyCareCPPTsMedicalTranscriberIds.length > 0 && this.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.dailyCareCPPTsMedicalTranscriberOppositeRelation,
				this.dailyCareCPPTsMedicalTranscriberCollectionId,
				this.targetModel.dailyCareCPPTsMedicalTranscriberIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.deliveryProgressesIds && this.targetModel.deliveryProgressesIds.length > 0 && this.deliveryProgressesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DeliveryProgressModel,
				this.deliveryProgressesOppositeRelation,
				this.deliveryProgressesCollectionId,
				this.targetModel.deliveryProgressesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.diagnosticStaffExaminationSummariesIds && this.targetModel.diagnosticStaffExaminationSummariesIds.length > 0 && this.diagnosticStaffExaminationSummariesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosticStaffExaminationSummaryModel,
				this.diagnosticStaffExaminationSummariesOppositeRelation,
				this.diagnosticStaffExaminationSummariesCollectionId,
				this.targetModel.diagnosticStaffExaminationSummariesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dismissalReferringStaffIds && this.targetModel.dismissalReferringStaffIds.length > 0 && this.dismissalReferringStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.dismissalReferringStaffOppositeRelation,
				this.dismissalReferringStaffCollectionId,
				this.targetModel.dismissalReferringStaffIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.doctorSchedulesIds && this.targetModel.doctorSchedulesIds.length > 0 && this.doctorSchedulesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DoctorScheduleModel,
				this.doctorSchedulesOppositeRelation,
				this.doctorSchedulesCollectionId,
				this.targetModel.doctorSchedulesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.doctorOnExaminationIds && this.targetModel.doctorOnExaminationIds.length > 0 && this.doctorOnExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordModel,
				this.doctorOnExaminationOppositeRelation,
				this.doctorOnExaminationCollectionId,
				this.targetModel.doctorOnExaminationIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.fluidBalanceDetailsIds && this.targetModel.fluidBalanceDetailsIds.length > 0 && this.fluidBalanceDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				FluidBalanceDetailModel,
				this.fluidBalanceDetailsOppositeRelation,
				this.fluidBalanceDetailsCollectionId,
				this.targetModel.fluidBalanceDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.hemodialysisMonitoringsIds && this.targetModel.hemodialysisMonitoringsIds.length > 0 && this.hemodialysisMonitoringsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				HemodialysisMonitoringModel,
				this.hemodialysisMonitoringsOppositeRelation,
				this.hemodialysisMonitoringsCollectionId,
				this.targetModel.hemodialysisMonitoringsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.hospitalBranchInformationsIds && this.targetModel.hospitalBranchInformationsIds.length > 0 && this.hospitalBranchInformationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				HospitalBranchInformationModel,
				this.hospitalBranchInformationsOppositeRelation,
				this.hospitalBranchInformationsCollectionId,
				this.targetModel.hospitalBranchInformationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.informingConsentsIds && this.targetModel.informingConsentsIds.length > 0 && this.informingConsentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InformedConsentModel,
				this.informingConsentsOppositeRelation,
				this.informingConsentsCollectionId,
				this.targetModel.informingConsentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoicesIds && this.targetModel.invoicesIds.length > 0 && this.invoicesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceModel,
				this.invoicesOppositeRelation,
				this.invoicesCollectionId,
				this.targetModel.invoicesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.mcuPackageItemsIds && this.targetModel.mcuPackageItemsIds.length > 0 && this.mcuPackageItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				McuPackageItemModel,
				this.mcuPackageItemsOppositeRelation,
				this.mcuPackageItemsCollectionId,
				this.targetModel.mcuPackageItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalCertificateDischargeResumesIds && this.targetModel.medicalCertificateDischargeResumesIds.length > 0 && this.medicalCertificateDischargeResumesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateDischargeResumeModel,
				this.medicalCertificateDischargeResumesOppositeRelation,
				this.medicalCertificateDischargeResumesCollectionId,
				this.targetModel.medicalCertificateDischargeResumesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalCertificateBirthsIds && this.targetModel.medicalCertificateBirthsIds.length > 0 && this.medicalCertificateBirthsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateBirthModel,
				this.medicalCertificateBirthsOppositeRelation,
				this.medicalCertificateBirthsCollectionId,
				this.targetModel.medicalCertificateBirthsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalCertificateHospitalizationsIds && this.targetModel.medicalCertificateHospitalizationsIds.length > 0 && this.medicalCertificateHospitalizationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateHospitalizationModel,
				this.medicalCertificateHospitalizationsOppositeRelation,
				this.medicalCertificateHospitalizationsCollectionId,
				this.targetModel.medicalCertificateHospitalizationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalExaminationRecordDischargeSummarysIds && this.targetModel.medicalExaminationRecordDischargeSummarysIds.length > 0 && this.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordDischargeSummaryModel,
				this.medicalExaminationRecordDischargeSummarysOppositeRelation,
				this.medicalExaminationRecordDischargeSummarysCollectionId,
				this.targetModel.medicalExaminationRecordDischargeSummarysIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalRecordTranscriberIds && this.targetModel.medicalRecordTranscriberIds.length > 0 && this.medicalRecordTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordModel,
				this.medicalRecordTranscriberOppositeRelation,
				this.medicalRecordTranscriberCollectionId,
				this.targetModel.medicalRecordTranscriberIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalStaffOfMedicalAttendancesCertificateIds && this.targetModel.medicalStaffOfMedicalAttendancesCertificateIds.length > 0 && this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateMedicalAttendanceModel,
				this.medicalStaffOfMedicalAttendancesCertificateOppositeRelation,
				this.medicalStaffOfMedicalAttendancesCertificateCollectionId,
				this.targetModel.medicalStaffOfMedicalAttendancesCertificateIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalStaffOfMentalHealthsIds && this.targetModel.medicalStaffOfMentalHealthsIds.length > 0 && this.medicalStaffOfMentalHealthsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateMentalHealthModel,
				this.medicalStaffOfMentalHealthsOppositeRelation,
				this.medicalStaffOfMentalHealthsCollectionId,
				this.targetModel.medicalStaffOfMentalHealthsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalStaffOfPhysicalHealthsIds && this.targetModel.medicalStaffOfPhysicalHealthsIds.length > 0 && this.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificatePhysicalHealthModel,
				this.medicalStaffOfPhysicalHealthsOppositeRelation,
				this.medicalStaffOfPhysicalHealthsCollectionId,
				this.targetModel.medicalStaffOfPhysicalHealthsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalStaffOfRestrictedWorksCertificateIds && this.targetModel.medicalStaffOfRestrictedWorksCertificateIds.length > 0 && this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateRestrictedWorkModel,
				this.medicalStaffOfRestrictedWorksCertificateOppositeRelation,
				this.medicalStaffOfRestrictedWorksCertificateCollectionId,
				this.targetModel.medicalStaffOfRestrictedWorksCertificateIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalStaffOfSickLeavesCertificateIds && this.targetModel.medicalStaffOfSickLeavesCertificateIds.length > 0 && this.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateSickLeaveModel,
				this.medicalStaffOfSickLeavesCertificateOppositeRelation,
				this.medicalStaffOfSickLeavesCertificateCollectionId,
				this.targetModel.medicalStaffOfSickLeavesCertificateIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicationAdministeredHisotriesIds && this.targetModel.medicationAdministeredHisotriesIds.length > 0 && this.medicationAdministeredHisotriesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationAdministeredHistoryModel,
				this.medicationAdministeredHisotriesOppositeRelation,
				this.medicationAdministeredHisotriesCollectionId,
				this.targetModel.medicationAdministeredHisotriesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicationHeadersIds && this.targetModel.medicationHeadersIds.length > 0 && this.medicationHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationHeaderModel,
				this.medicationHeadersOppositeRelation,
				this.medicationHeadersCollectionId,
				this.targetModel.medicationHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.midwivesIds && this.targetModel.midwivesIds.length > 0 && this.midwivesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DeliveryMedicalExaminationRecordModel,
				this.midwivesOppositeRelation,
				this.midwivesCollectionId,
				this.targetModel.midwivesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.nurseIds && this.targetModel.nurseIds.length > 0 && this.nurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordModel,
				this.nurseOppositeRelation,
				this.nurseCollectionId,
				this.targetModel.nurseIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.nursingDetailSurgicalNursingIds && this.targetModel.nursingDetailSurgicalNursingIds.length > 0 && this.nursingDetailSurgicalNursingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OperatingTheaterMedicalExaminationRecordModel,
				this.nursingDetailSurgicalNursingOppositeRelation,
				this.nursingDetailSurgicalNursingCollectionId,
				this.targetModel.nursingDetailSurgicalNursingIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.nursingDetailsAnesthesiaNursingIds && this.targetModel.nursingDetailsAnesthesiaNursingIds.length > 0 && this.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OperatingTheaterMedicalExaminationRecordModel,
				this.nursingDetailsAnesthesiaNursingOppositeRelation,
				this.nursingDetailsAnesthesiaNursingCollectionId,
				this.targetModel.nursingDetailsAnesthesiaNursingIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientConsentsIds && this.targetModel.patientConsentsIds.length > 0 && this.patientConsentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientConsentModel,
				this.patientConsentsOppositeRelation,
				this.patientConsentsCollectionId,
				this.targetModel.patientConsentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientVitalInformationsIds && this.targetModel.patientVitalInformationsIds.length > 0 && this.patientVitalInformationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVitalInformationModel,
				this.patientVitalInformationsOppositeRelation,
				this.patientVitalInformationsCollectionId,
				this.targetModel.patientVitalInformationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.pediatricianInChargeIds && this.targetModel.pediatricianInChargeIds.length > 0 && this.pediatricianInChargeMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				NewbornDetailModel,
				this.pediatricianInChargeOppositeRelation,
				this.pediatricianInChargeCollectionId,
				this.targetModel.pediatricianInChargeIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.prescriptionHeadersIds && this.targetModel.prescriptionHeadersIds.length > 0 && this.prescriptionHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PrescriptionHeaderModel,
				this.prescriptionHeadersOppositeRelation,
				this.prescriptionHeadersCollectionId,
				this.targetModel.prescriptionHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.processWorkflowLogsIds && this.targetModel.processWorkflowLogsIds.length > 0 && this.processWorkflowLogsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ProcessWorkflowModel,
				this.processWorkflowLogsOppositeRelation,
				this.processWorkflowLogsCollectionId,
				this.targetModel.processWorkflowLogsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.registrationsIds && this.targetModel.registrationsIds.length > 0 && this.registrationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.registrationsOppositeRelation,
				this.registrationsCollectionId,
				this.targetModel.registrationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.requestedByIds && this.targetModel.requestedByIds.length > 0 && this.requestedByMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.requestedByOppositeRelation,
				this.requestedByCollectionId,
				this.targetModel.requestedByIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.roomTransfersIds && this.targetModel.roomTransfersIds.length > 0 && this.roomTransfersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RoomTransferModel,
				this.roomTransfersOppositeRelation,
				this.roomTransfersCollectionId,
				this.targetModel.roomTransfersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.sampleCollectionStaffsIds && this.targetModel.sampleCollectionStaffsIds.length > 0 && this.sampleCollectionStaffsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SampleCollectionItemsModel,
				this.sampleCollectionStaffsOppositeRelation,
				this.sampleCollectionStaffsCollectionId,
				this.targetModel.sampleCollectionStaffsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.sampleDeliveryStaffsIds && this.targetModel.sampleDeliveryStaffsIds.length > 0 && this.sampleDeliveryStaffsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SampleCollectionItemsModel,
				this.sampleDeliveryStaffsOppositeRelation,
				this.sampleDeliveryStaffsCollectionId,
				this.targetModel.sampleDeliveryStaffsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.sampleProcessingStaffsIds && this.targetModel.sampleProcessingStaffsIds.length > 0 && this.sampleProcessingStaffsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SampleCollectionItemsModel,
				this.sampleProcessingStaffsOppositeRelation,
				this.sampleProcessingStaffsCollectionId,
				this.targetModel.sampleProcessingStaffsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.surgeonIds && this.targetModel.surgeonIds.length > 0 && this.surgeonMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.surgeonOppositeRelation,
				this.surgeonCollectionId,
				this.targetModel.surgeonIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.surgicalMedicalTranscriberIds && this.targetModel.surgicalMedicalTranscriberIds.length > 0 && this.surgicalMedicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.surgicalMedicalTranscriberOppositeRelation,
				this.surgicalMedicalTranscriberCollectionId,
				this.targetModel.surgicalMedicalTranscriberIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.surgicalNurseIds && this.targetModel.surgicalNurseIds.length > 0 && this.surgicalNurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.surgicalNurseOppositeRelation,
				this.surgicalNurseCollectionId,
				this.targetModel.surgicalNurseIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.transferOrderStockDetailsIds && this.targetModel.transferOrderStockDetailsIds.length > 0 && this.transferOrderStockDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				TransferOrderStockDetailModel,
				this.transferOrderStockDetailsOppositeRelation,
				this.transferOrderStockDetailsCollectionId,
				this.targetModel.transferOrderStockDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.vaccinationOrdersIds && this.targetModel.vaccinationOrdersIds.length > 0 && this.vaccinationOrdersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				VaccinationOrderModel,
				this.vaccinationOrdersOppositeRelation,
				this.vaccinationOrdersCollectionId,
				this.targetModel.vaccinationOrdersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.servicesIds && this.targetModel.servicesIds.length > 0 && this.servicesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceModel,
				this.servicesOppositeRelation,
				this.servicesCollectionId,
				this.targetModel.servicesIds.length,
				this.targetModel.id,
				true
			));
		}

	}

	/**
	 * The crud create edit page will handle all potential multi entity crud permutations by returning an
	 * `additionalEntities` parameter in its returned event.  This attribute will contain any entities which
	 * were added to the crud edit page for multi entity model.  Once this attribute has been returned, we need
	 * to process it, and transfer any additional entities from this attribute into the target model, so that these
	 * additional entities can be sent to the serverside for processing.
	 *
	 * @param model The model to inject the additional entities into.  This will usually be the targetModel attribute for this component
	 * @param event The event returned from the crud edit page when clicking create or save.  We only care about the additionalEntities param here
	 * @returns the model passed in as input, but with the entities from the additionalEntities attribute added to that model.
	 */
	addAdditionalEntitiesToModel(model: StaffModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): StaffModel {
		let updatedModel: StaffModel = new StaffModel(model);

		if (this.administrationUserMultiCrudActive) {
			updatedModel.administrationUser = event.additionalEntities.administrationUser ? event.additionalEntities.administrationUser : undefined;

			if (!updatedModel.administrationUser && event.payload) {
				event.payload.administrationUserId = null;
			}
		} else if (event.payload?.administrationUserId !== undefined) {
			event.payload.administrationUser = null;
			updatedModel.administrationUser = null;
		}

		if (this.cashierUserMultiCrudActive) {
			updatedModel.cashierUser = event.additionalEntities.cashierUser ? event.additionalEntities.cashierUser : undefined;

			if (!updatedModel.cashierUser && event.payload) {
				event.payload.cashierUserId = null;
			}
		} else if (event.payload?.cashierUserId !== undefined) {
			event.payload.cashierUser = null;
			updatedModel.cashierUser = null;
		}

		if (this.claimUserMultiCrudActive) {
			updatedModel.claimUser = event.additionalEntities.claimUser ? event.additionalEntities.claimUser : undefined;

			if (!updatedModel.claimUser && event.payload) {
				event.payload.claimUserId = null;
			}
		} else if (event.payload?.claimUserId !== undefined) {
			event.payload.claimUser = null;
			updatedModel.claimUser = null;
		}

		if (this.diagnosticSupportUserMultiCrudActive) {
			updatedModel.diagnosticSupportUser = event.additionalEntities.diagnosticSupportUser ? event.additionalEntities.diagnosticSupportUser : undefined;

			if (!updatedModel.diagnosticSupportUser && event.payload) {
				event.payload.diagnosticSupportUserId = null;
			}
		} else if (event.payload?.diagnosticSupportUserId !== undefined) {
			event.payload.diagnosticSupportUser = null;
			updatedModel.diagnosticSupportUser = null;
		}

		if (this.doctorUserMultiCrudActive) {
			updatedModel.doctorUser = event.additionalEntities.doctorUser ? event.additionalEntities.doctorUser : undefined;

			if (!updatedModel.doctorUser && event.payload) {
				event.payload.doctorUserId = null;
			}
		} else if (event.payload?.doctorUserId !== undefined) {
			event.payload.doctorUser = null;
			updatedModel.doctorUser = null;
		}

		if (this.facilityUserMultiCrudActive) {
			updatedModel.facilityUser = event.additionalEntities.facilityUser ? event.additionalEntities.facilityUser : undefined;

			if (!updatedModel.facilityUser && event.payload) {
				event.payload.facilityUserId = null;
			}
		} else if (event.payload?.facilityUserId !== undefined) {
			event.payload.facilityUser = null;
			updatedModel.facilityUser = null;
		}

		if (this.managementUserMultiCrudActive) {
			updatedModel.managementUser = event.additionalEntities.managementUser ? event.additionalEntities.managementUser : undefined;

			if (!updatedModel.managementUser && event.payload) {
				event.payload.managementUserId = null;
			}
		} else if (event.payload?.managementUserId !== undefined) {
			event.payload.managementUser = null;
			updatedModel.managementUser = null;
		}

		if (this.medicalRecordUserMultiCrudActive) {
			updatedModel.medicalRecordUser = event.additionalEntities.medicalRecordUser ? event.additionalEntities.medicalRecordUser : undefined;

			if (!updatedModel.medicalRecordUser && event.payload) {
				event.payload.medicalRecordUserId = null;
			}
		} else if (event.payload?.medicalRecordUserId !== undefined) {
			event.payload.medicalRecordUser = null;
			updatedModel.medicalRecordUser = null;
		}

		if (this.medicalTranscriberUserMultiCrudActive) {
			updatedModel.medicalTranscriberUser = event.additionalEntities.medicalTranscriberUser ? event.additionalEntities.medicalTranscriberUser : undefined;

			if (!updatedModel.medicalTranscriberUser && event.payload) {
				event.payload.medicalTranscriberUserId = null;
			}
		} else if (event.payload?.medicalTranscriberUserId !== undefined) {
			event.payload.medicalTranscriberUser = null;
			updatedModel.medicalTranscriberUser = null;
		}

		if (this.nurseUserMultiCrudActive) {
			updatedModel.nurseUser = event.additionalEntities.nurseUser ? event.additionalEntities.nurseUser : undefined;

			if (!updatedModel.nurseUser && event.payload) {
				event.payload.nurseUserId = null;
			}
		} else if (event.payload?.nurseUserId !== undefined) {
			event.payload.nurseUser = null;
			updatedModel.nurseUser = null;
		}

		if (this.pharmacyUserMultiCrudActive) {
			updatedModel.pharmacyUser = event.additionalEntities.pharmacyUser ? event.additionalEntities.pharmacyUser : undefined;

			if (!updatedModel.pharmacyUser && event.payload) {
				event.payload.pharmacyUserId = null;
			}
		} else if (event.payload?.pharmacyUserId !== undefined) {
			event.payload.pharmacyUser = null;
			updatedModel.pharmacyUser = null;
		}

		if (this.purchasingUserMultiCrudActive) {
			updatedModel.purchasingUser = event.additionalEntities.purchasingUser ? event.additionalEntities.purchasingUser : undefined;

			if (!updatedModel.purchasingUser && event.payload) {
				event.payload.purchasingUserId = null;
			}
		} else if (event.payload?.purchasingUserId !== undefined) {
			event.payload.purchasingUser = null;
			updatedModel.purchasingUser = null;
		}

		if (this.registrationUserMultiCrudActive) {
			updatedModel.registrationUser = event.additionalEntities.registrationUser ? event.additionalEntities.registrationUser : undefined;

			if (!updatedModel.registrationUser && event.payload) {
				event.payload.registrationUserId = null;
			}
		} else if (event.payload?.registrationUserId !== undefined) {
			event.payload.registrationUser = null;
			updatedModel.registrationUser = null;
		}

		if (this.systemAdminUserMultiCrudActive) {
			updatedModel.systemAdminUser = event.additionalEntities.systemAdminUser ? event.additionalEntities.systemAdminUser : undefined;

			if (!updatedModel.systemAdminUser && event.payload) {
				event.payload.systemAdminUserId = null;
			}
		} else if (event.payload?.systemAdminUserId !== undefined) {
			event.payload.systemAdminUser = null;
			updatedModel.systemAdminUser = null;
		}

		if (this.warehouseUserMultiCrudActive) {
			updatedModel.warehouseUser = event.additionalEntities.warehouseUser ? event.additionalEntities.warehouseUser : undefined;

			if (!updatedModel.warehouseUser && event.payload) {
				event.payload.warehouseUserId = null;
			}
		} else if (event.payload?.warehouseUserId !== undefined) {
			event.payload.warehouseUser = null;
			updatedModel.warehouseUser = null;
		}

		if (this.administratorMultiCrudActive) {
			updatedModel.administrator = event.additionalEntities.administrator ? event.additionalEntities.administrator : undefined;

			if (!updatedModel.administrator && event.payload) {
				event.payload.administratorId = null;
			}
		} else if (event.payload?.administratorId !== undefined) {
			event.payload.administrator = null;
			updatedModel.administrator = null;
		}

		if (this.bpjsDoctorMappingMultiCrudActive) {
			updatedModel.bpjsDoctorMapping = event.additionalEntities.bpjsDoctorMapping ? event.additionalEntities.bpjsDoctorMapping : undefined;

			if (!updatedModel.bpjsDoctorMapping && event.payload) {
				event.payload.bpjsDoctorMappingId = null;
			}
		} else if (event.payload?.bpjsDoctorMappingId !== undefined) {
			event.payload.bpjsDoctorMapping = null;
			updatedModel.bpjsDoctorMapping = null;
		}

		if (this.pcareDokterMultiCrudActive) {
			updatedModel.pcareDokter = event.additionalEntities.pcareDokter ? event.additionalEntities.pcareDokter : undefined;

			if (!updatedModel.pcareDokter && event.payload) {
				event.payload.pcareDokterId = null;
			}
		} else if (event.payload?.pcareDokterId !== undefined) {
			event.payload.pcareDokter = null;
			updatedModel.pcareDokter = null;
		}

		if (this.serviceMultiCrudActive) {
			updatedModel.service = event.additionalEntities.service ? event.additionalEntities.service : undefined;

			if (!updatedModel.service && event.payload) {
				event.payload.serviceId = null;
			}
		} else if (event.payload?.serviceId !== undefined) {
			event.payload.service = null;
			updatedModel.service = null;
		}

		updatedModel.accompanyingConsents = [];
		if (this.accompanyingConsentsMultiCrudActive) {
			if (event.additionalEntities.accompanyingConsents) {
				event.additionalEntities.accompanyingConsents.forEach(entity => {
					updatedModel.accompanyingConsents.push(entity);
				});
			}

			if (!updatedModel.accompanyingConsents.length) {
				updatedModel.accompanyingConsentsIds = [];
			}
		}
		updatedModel.amendmentDetails = [];
		if (this.amendmentDetailsMultiCrudActive) {
			if (event.additionalEntities.amendmentDetails) {
				event.additionalEntities.amendmentDetails.forEach(entity => {
					updatedModel.amendmentDetails.push(entity);
				});
			}

			if (!updatedModel.amendmentDetails.length) {
				updatedModel.amendmentDetailsIds = [];
			}
		}
		updatedModel.anesthesiaMedicalTranscriber = [];
		if (this.anesthesiaMedicalTranscriberMultiCrudActive) {
			if (event.additionalEntities.anesthesiaMedicalTranscriber) {
				event.additionalEntities.anesthesiaMedicalTranscriber.forEach(entity => {
					updatedModel.anesthesiaMedicalTranscriber.push(entity);
				});
			}

			if (!updatedModel.anesthesiaMedicalTranscriber.length) {
				updatedModel.anesthesiaMedicalTranscriberIds = [];
			}
		}
		updatedModel.anesthesiologist = [];
		if (this.anesthesiologistMultiCrudActive) {
			if (event.additionalEntities.anesthesiologist) {
				event.additionalEntities.anesthesiologist.forEach(entity => {
					updatedModel.anesthesiologist.push(entity);
				});
			}

			if (!updatedModel.anesthesiologist.length) {
				updatedModel.anesthesiologistIds = [];
			}
		}
		updatedModel.anesthesiologyNurse = [];
		if (this.anesthesiologyNurseMultiCrudActive) {
			if (event.additionalEntities.anesthesiologyNurse) {
				event.additionalEntities.anesthesiologyNurse.forEach(entity => {
					updatedModel.anesthesiologyNurse.push(entity);
				});
			}

			if (!updatedModel.anesthesiologyNurse.length) {
				updatedModel.anesthesiologyNurseIds = [];
			}
		}
		updatedModel.cashierStaff = [];
		if (this.cashierStaffMultiCrudActive) {
			if (event.additionalEntities.cashierStaff) {
				event.additionalEntities.cashierStaff.forEach(entity => {
					updatedModel.cashierStaff.push(entity);
				});
			}

			if (!updatedModel.cashierStaff.length) {
				updatedModel.cashierStaffIds = [];
			}
		}
		updatedModel.coTreatingDoctors = [];
		if (this.coTreatingDoctorsMultiCrudActive) {
			if (event.additionalEntities.coTreatingDoctors) {
				event.additionalEntities.coTreatingDoctors.forEach(entity => {
					updatedModel.coTreatingDoctors.push(entity);
				});
			}

			if (!updatedModel.coTreatingDoctors.length) {
				updatedModel.coTreatingDoctorsIds = [];
			}
		}
		updatedModel.dailyCareCPPTsCreatedByStaff = [];
		if (this.dailyCareCPPTsCreatedByStaffMultiCrudActive) {
			if (event.additionalEntities.dailyCareCPPTsCreatedByStaff) {
				event.additionalEntities.dailyCareCPPTsCreatedByStaff.forEach(entity => {
					updatedModel.dailyCareCPPTsCreatedByStaff.push(entity);
				});
			}

			if (!updatedModel.dailyCareCPPTsCreatedByStaff.length) {
				updatedModel.dailyCareCPPTsCreatedByStaffIds = [];
			}
		}
		updatedModel.dailyCareCPPTsDoctorInCharge = [];
		if (this.dailyCareCPPTsDoctorInChargeMultiCrudActive) {
			if (event.additionalEntities.dailyCareCPPTsDoctorInCharge) {
				event.additionalEntities.dailyCareCPPTsDoctorInCharge.forEach(entity => {
					updatedModel.dailyCareCPPTsDoctorInCharge.push(entity);
				});
			}

			if (!updatedModel.dailyCareCPPTsDoctorInCharge.length) {
				updatedModel.dailyCareCPPTsDoctorInChargeIds = [];
			}
		}
		updatedModel.dailyCareCPPTsMedicalTranscriber = [];
		if (this.dailyCareCPPTsMedicalTranscriberMultiCrudActive) {
			if (event.additionalEntities.dailyCareCPPTsMedicalTranscriber) {
				event.additionalEntities.dailyCareCPPTsMedicalTranscriber.forEach(entity => {
					updatedModel.dailyCareCPPTsMedicalTranscriber.push(entity);
				});
			}

			if (!updatedModel.dailyCareCPPTsMedicalTranscriber.length) {
				updatedModel.dailyCareCPPTsMedicalTranscriberIds = [];
			}
		}
		updatedModel.deliveryProgresses = [];
		if (this.deliveryProgressesMultiCrudActive) {
			if (event.additionalEntities.deliveryProgresses) {
				event.additionalEntities.deliveryProgresses.forEach(entity => {
					updatedModel.deliveryProgresses.push(entity);
				});
			}

			if (!updatedModel.deliveryProgresses.length) {
				updatedModel.deliveryProgressesIds = [];
			}
		}
		updatedModel.diagnosticStaffExaminationSummaries = [];
		if (this.diagnosticStaffExaminationSummariesMultiCrudActive) {
			if (event.additionalEntities.diagnosticStaffExaminationSummaries) {
				event.additionalEntities.diagnosticStaffExaminationSummaries.forEach(entity => {
					updatedModel.diagnosticStaffExaminationSummaries.push(entity);
				});
			}

			if (!updatedModel.diagnosticStaffExaminationSummaries.length) {
				updatedModel.diagnosticStaffExaminationSummariesIds = [];
			}
		}
		updatedModel.dismissalReferringStaff = [];
		if (this.dismissalReferringStaffMultiCrudActive) {
			if (event.additionalEntities.dismissalReferringStaff) {
				event.additionalEntities.dismissalReferringStaff.forEach(entity => {
					updatedModel.dismissalReferringStaff.push(entity);
				});
			}

			if (!updatedModel.dismissalReferringStaff.length) {
				updatedModel.dismissalReferringStaffIds = [];
			}
		}
		updatedModel.doctorSchedules = [];
		if (this.doctorSchedulesMultiCrudActive) {
			if (event.additionalEntities.doctorSchedules) {
				event.additionalEntities.doctorSchedules.forEach(entity => {
					updatedModel.doctorSchedules.push(entity);
				});
			}

			if (!updatedModel.doctorSchedules.length) {
				updatedModel.doctorSchedulesIds = [];
			}
		}
		updatedModel.doctorOnExamination = [];
		if (this.doctorOnExaminationMultiCrudActive) {
			if (event.additionalEntities.doctorOnExamination) {
				event.additionalEntities.doctorOnExamination.forEach(entity => {
					updatedModel.doctorOnExamination.push(entity);
				});
			}

			if (!updatedModel.doctorOnExamination.length) {
				updatedModel.doctorOnExaminationIds = [];
			}
		}
		updatedModel.fluidBalanceDetails = [];
		if (this.fluidBalanceDetailsMultiCrudActive) {
			if (event.additionalEntities.fluidBalanceDetails) {
				event.additionalEntities.fluidBalanceDetails.forEach(entity => {
					updatedModel.fluidBalanceDetails.push(entity);
				});
			}

			if (!updatedModel.fluidBalanceDetails.length) {
				updatedModel.fluidBalanceDetailsIds = [];
			}
		}
		updatedModel.hemodialysisMonitorings = [];
		if (this.hemodialysisMonitoringsMultiCrudActive) {
			if (event.additionalEntities.hemodialysisMonitorings) {
				event.additionalEntities.hemodialysisMonitorings.forEach(entity => {
					updatedModel.hemodialysisMonitorings.push(entity);
				});
			}

			if (!updatedModel.hemodialysisMonitorings.length) {
				updatedModel.hemodialysisMonitoringsIds = [];
			}
		}
		updatedModel.hospitalBranchInformations = [];
		if (this.hospitalBranchInformationsMultiCrudActive) {
			if (event.additionalEntities.hospitalBranchInformations) {
				event.additionalEntities.hospitalBranchInformations.forEach(entity => {
					updatedModel.hospitalBranchInformations.push(entity);
				});
			}

			if (!updatedModel.hospitalBranchInformations.length) {
				updatedModel.hospitalBranchInformationsIds = [];
			}
		}
		updatedModel.informingConsents = [];
		if (this.informingConsentsMultiCrudActive) {
			if (event.additionalEntities.informingConsents) {
				event.additionalEntities.informingConsents.forEach(entity => {
					updatedModel.informingConsents.push(entity);
				});
			}

			if (!updatedModel.informingConsents.length) {
				updatedModel.informingConsentsIds = [];
			}
		}
		updatedModel.invoices = [];
		if (this.invoicesMultiCrudActive) {
			if (event.additionalEntities.invoices) {
				event.additionalEntities.invoices.forEach(entity => {
					updatedModel.invoices.push(entity);
				});
			}

			if (!updatedModel.invoices.length) {
				updatedModel.invoicesIds = [];
			}
		}
		updatedModel.mcuPackageItems = [];
		if (this.mcuPackageItemsMultiCrudActive) {
			if (event.additionalEntities.mcuPackageItems) {
				event.additionalEntities.mcuPackageItems.forEach(entity => {
					updatedModel.mcuPackageItems.push(entity);
				});
			}

			if (!updatedModel.mcuPackageItems.length) {
				updatedModel.mcuPackageItemsIds = [];
			}
		}
		updatedModel.medicalCertificateDischargeResumes = [];
		if (this.medicalCertificateDischargeResumesMultiCrudActive) {
			if (event.additionalEntities.medicalCertificateDischargeResumes) {
				event.additionalEntities.medicalCertificateDischargeResumes.forEach(entity => {
					updatedModel.medicalCertificateDischargeResumes.push(entity);
				});
			}

			if (!updatedModel.medicalCertificateDischargeResumes.length) {
				updatedModel.medicalCertificateDischargeResumesIds = [];
			}
		}
		updatedModel.medicalCertificateBirths = [];
		if (this.medicalCertificateBirthsMultiCrudActive) {
			if (event.additionalEntities.medicalCertificateBirths) {
				event.additionalEntities.medicalCertificateBirths.forEach(entity => {
					updatedModel.medicalCertificateBirths.push(entity);
				});
			}

			if (!updatedModel.medicalCertificateBirths.length) {
				updatedModel.medicalCertificateBirthsIds = [];
			}
		}
		updatedModel.medicalCertificateHospitalizations = [];
		if (this.medicalCertificateHospitalizationsMultiCrudActive) {
			if (event.additionalEntities.medicalCertificateHospitalizations) {
				event.additionalEntities.medicalCertificateHospitalizations.forEach(entity => {
					updatedModel.medicalCertificateHospitalizations.push(entity);
				});
			}

			if (!updatedModel.medicalCertificateHospitalizations.length) {
				updatedModel.medicalCertificateHospitalizationsIds = [];
			}
		}
		updatedModel.medicalExaminationRecordDischargeSummarys = [];
		if (this.medicalExaminationRecordDischargeSummarysMultiCrudActive) {
			if (event.additionalEntities.medicalExaminationRecordDischargeSummarys) {
				event.additionalEntities.medicalExaminationRecordDischargeSummarys.forEach(entity => {
					updatedModel.medicalExaminationRecordDischargeSummarys.push(entity);
				});
			}

			if (!updatedModel.medicalExaminationRecordDischargeSummarys.length) {
				updatedModel.medicalExaminationRecordDischargeSummarysIds = [];
			}
		}
		updatedModel.medicalRecordTranscriber = [];
		if (this.medicalRecordTranscriberMultiCrudActive) {
			if (event.additionalEntities.medicalRecordTranscriber) {
				event.additionalEntities.medicalRecordTranscriber.forEach(entity => {
					updatedModel.medicalRecordTranscriber.push(entity);
				});
			}

			if (!updatedModel.medicalRecordTranscriber.length) {
				updatedModel.medicalRecordTranscriberIds = [];
			}
		}
		updatedModel.medicalStaffOfMedicalAttendancesCertificate = [];
		if (this.medicalStaffOfMedicalAttendancesCertificateMultiCrudActive) {
			if (event.additionalEntities.medicalStaffOfMedicalAttendancesCertificate) {
				event.additionalEntities.medicalStaffOfMedicalAttendancesCertificate.forEach(entity => {
					updatedModel.medicalStaffOfMedicalAttendancesCertificate.push(entity);
				});
			}

			if (!updatedModel.medicalStaffOfMedicalAttendancesCertificate.length) {
				updatedModel.medicalStaffOfMedicalAttendancesCertificateIds = [];
			}
		}
		updatedModel.medicalStaffOfMentalHealths = [];
		if (this.medicalStaffOfMentalHealthsMultiCrudActive) {
			if (event.additionalEntities.medicalStaffOfMentalHealths) {
				event.additionalEntities.medicalStaffOfMentalHealths.forEach(entity => {
					updatedModel.medicalStaffOfMentalHealths.push(entity);
				});
			}

			if (!updatedModel.medicalStaffOfMentalHealths.length) {
				updatedModel.medicalStaffOfMentalHealthsIds = [];
			}
		}
		updatedModel.medicalStaffOfPhysicalHealths = [];
		if (this.medicalStaffOfPhysicalHealthsMultiCrudActive) {
			if (event.additionalEntities.medicalStaffOfPhysicalHealths) {
				event.additionalEntities.medicalStaffOfPhysicalHealths.forEach(entity => {
					updatedModel.medicalStaffOfPhysicalHealths.push(entity);
				});
			}

			if (!updatedModel.medicalStaffOfPhysicalHealths.length) {
				updatedModel.medicalStaffOfPhysicalHealthsIds = [];
			}
		}
		updatedModel.medicalStaffOfRestrictedWorksCertificate = [];
		if (this.medicalStaffOfRestrictedWorksCertificateMultiCrudActive) {
			if (event.additionalEntities.medicalStaffOfRestrictedWorksCertificate) {
				event.additionalEntities.medicalStaffOfRestrictedWorksCertificate.forEach(entity => {
					updatedModel.medicalStaffOfRestrictedWorksCertificate.push(entity);
				});
			}

			if (!updatedModel.medicalStaffOfRestrictedWorksCertificate.length) {
				updatedModel.medicalStaffOfRestrictedWorksCertificateIds = [];
			}
		}
		updatedModel.medicalStaffOfSickLeavesCertificate = [];
		if (this.medicalStaffOfSickLeavesCertificateMultiCrudActive) {
			if (event.additionalEntities.medicalStaffOfSickLeavesCertificate) {
				event.additionalEntities.medicalStaffOfSickLeavesCertificate.forEach(entity => {
					updatedModel.medicalStaffOfSickLeavesCertificate.push(entity);
				});
			}

			if (!updatedModel.medicalStaffOfSickLeavesCertificate.length) {
				updatedModel.medicalStaffOfSickLeavesCertificateIds = [];
			}
		}
		updatedModel.medicationAdministeredHisotries = [];
		if (this.medicationAdministeredHisotriesMultiCrudActive) {
			if (event.additionalEntities.medicationAdministeredHisotries) {
				event.additionalEntities.medicationAdministeredHisotries.forEach(entity => {
					updatedModel.medicationAdministeredHisotries.push(entity);
				});
			}

			if (!updatedModel.medicationAdministeredHisotries.length) {
				updatedModel.medicationAdministeredHisotriesIds = [];
			}
		}
		updatedModel.medicationHeaders = [];
		if (this.medicationHeadersMultiCrudActive) {
			if (event.additionalEntities.medicationHeaders) {
				event.additionalEntities.medicationHeaders.forEach(entity => {
					updatedModel.medicationHeaders.push(entity);
				});
			}

			if (!updatedModel.medicationHeaders.length) {
				updatedModel.medicationHeadersIds = [];
			}
		}
		updatedModel.midwives = [];
		if (this.midwivesMultiCrudActive) {
			if (event.additionalEntities.midwives) {
				event.additionalEntities.midwives.forEach(entity => {
					updatedModel.midwives.push(entity);
				});
			}

			if (!updatedModel.midwives.length) {
				updatedModel.midwivesIds = [];
			}
		}
		updatedModel.nurse = [];
		if (this.nurseMultiCrudActive) {
			if (event.additionalEntities.nurse) {
				event.additionalEntities.nurse.forEach(entity => {
					updatedModel.nurse.push(entity);
				});
			}

			if (!updatedModel.nurse.length) {
				updatedModel.nurseIds = [];
			}
		}
		updatedModel.nursingDetailSurgicalNursing = [];
		if (this.nursingDetailSurgicalNursingMultiCrudActive) {
			if (event.additionalEntities.nursingDetailSurgicalNursing) {
				event.additionalEntities.nursingDetailSurgicalNursing.forEach(entity => {
					updatedModel.nursingDetailSurgicalNursing.push(entity);
				});
			}

			if (!updatedModel.nursingDetailSurgicalNursing.length) {
				updatedModel.nursingDetailSurgicalNursingIds = [];
			}
		}
		updatedModel.nursingDetailsAnesthesiaNursing = [];
		if (this.nursingDetailsAnesthesiaNursingMultiCrudActive) {
			if (event.additionalEntities.nursingDetailsAnesthesiaNursing) {
				event.additionalEntities.nursingDetailsAnesthesiaNursing.forEach(entity => {
					updatedModel.nursingDetailsAnesthesiaNursing.push(entity);
				});
			}

			if (!updatedModel.nursingDetailsAnesthesiaNursing.length) {
				updatedModel.nursingDetailsAnesthesiaNursingIds = [];
			}
		}
		updatedModel.patientConsents = [];
		if (this.patientConsentsMultiCrudActive) {
			if (event.additionalEntities.patientConsents) {
				event.additionalEntities.patientConsents.forEach(entity => {
					updatedModel.patientConsents.push(entity);
				});
			}

			if (!updatedModel.patientConsents.length) {
				updatedModel.patientConsentsIds = [];
			}
		}
		updatedModel.patientVitalInformations = [];
		if (this.patientVitalInformationsMultiCrudActive) {
			if (event.additionalEntities.patientVitalInformations) {
				event.additionalEntities.patientVitalInformations.forEach(entity => {
					updatedModel.patientVitalInformations.push(entity);
				});
			}

			if (!updatedModel.patientVitalInformations.length) {
				updatedModel.patientVitalInformationsIds = [];
			}
		}
		updatedModel.pediatricianInCharge = [];
		if (this.pediatricianInChargeMultiCrudActive) {
			if (event.additionalEntities.pediatricianInCharge) {
				event.additionalEntities.pediatricianInCharge.forEach(entity => {
					updatedModel.pediatricianInCharge.push(entity);
				});
			}

			if (!updatedModel.pediatricianInCharge.length) {
				updatedModel.pediatricianInChargeIds = [];
			}
		}
		updatedModel.prescriptionHeaders = [];
		if (this.prescriptionHeadersMultiCrudActive) {
			if (event.additionalEntities.prescriptionHeaders) {
				event.additionalEntities.prescriptionHeaders.forEach(entity => {
					updatedModel.prescriptionHeaders.push(entity);
				});
			}

			if (!updatedModel.prescriptionHeaders.length) {
				updatedModel.prescriptionHeadersIds = [];
			}
		}
		updatedModel.processWorkflowLogs = [];
		if (this.processWorkflowLogsMultiCrudActive) {
			if (event.additionalEntities.processWorkflowLogs) {
				event.additionalEntities.processWorkflowLogs.forEach(entity => {
					updatedModel.processWorkflowLogs.push(entity);
				});
			}

			if (!updatedModel.processWorkflowLogs.length) {
				updatedModel.processWorkflowLogsIds = [];
			}
		}
		updatedModel.registrations = [];
		if (this.registrationsMultiCrudActive) {
			if (event.additionalEntities.registrations) {
				event.additionalEntities.registrations.forEach(entity => {
					updatedModel.registrations.push(entity);
				});
			}

			if (!updatedModel.registrations.length) {
				updatedModel.registrationsIds = [];
			}
		}
		updatedModel.requestedBy = [];
		if (this.requestedByMultiCrudActive) {
			if (event.additionalEntities.requestedBy) {
				event.additionalEntities.requestedBy.forEach(entity => {
					updatedModel.requestedBy.push(entity);
				});
			}

			if (!updatedModel.requestedBy.length) {
				updatedModel.requestedByIds = [];
			}
		}
		updatedModel.roomTransfers = [];
		if (this.roomTransfersMultiCrudActive) {
			if (event.additionalEntities.roomTransfers) {
				event.additionalEntities.roomTransfers.forEach(entity => {
					updatedModel.roomTransfers.push(entity);
				});
			}

			if (!updatedModel.roomTransfers.length) {
				updatedModel.roomTransfersIds = [];
			}
		}
		updatedModel.sampleCollectionStaffs = [];
		if (this.sampleCollectionStaffsMultiCrudActive) {
			if (event.additionalEntities.sampleCollectionStaffs) {
				event.additionalEntities.sampleCollectionStaffs.forEach(entity => {
					updatedModel.sampleCollectionStaffs.push(entity);
				});
			}

			if (!updatedModel.sampleCollectionStaffs.length) {
				updatedModel.sampleCollectionStaffsIds = [];
			}
		}
		updatedModel.sampleDeliveryStaffs = [];
		if (this.sampleDeliveryStaffsMultiCrudActive) {
			if (event.additionalEntities.sampleDeliveryStaffs) {
				event.additionalEntities.sampleDeliveryStaffs.forEach(entity => {
					updatedModel.sampleDeliveryStaffs.push(entity);
				});
			}

			if (!updatedModel.sampleDeliveryStaffs.length) {
				updatedModel.sampleDeliveryStaffsIds = [];
			}
		}
		updatedModel.sampleProcessingStaffs = [];
		if (this.sampleProcessingStaffsMultiCrudActive) {
			if (event.additionalEntities.sampleProcessingStaffs) {
				event.additionalEntities.sampleProcessingStaffs.forEach(entity => {
					updatedModel.sampleProcessingStaffs.push(entity);
				});
			}

			if (!updatedModel.sampleProcessingStaffs.length) {
				updatedModel.sampleProcessingStaffsIds = [];
			}
		}
		updatedModel.surgeon = [];
		if (this.surgeonMultiCrudActive) {
			if (event.additionalEntities.surgeon) {
				event.additionalEntities.surgeon.forEach(entity => {
					updatedModel.surgeon.push(entity);
				});
			}

			if (!updatedModel.surgeon.length) {
				updatedModel.surgeonIds = [];
			}
		}
		updatedModel.surgicalMedicalTranscriber = [];
		if (this.surgicalMedicalTranscriberMultiCrudActive) {
			if (event.additionalEntities.surgicalMedicalTranscriber) {
				event.additionalEntities.surgicalMedicalTranscriber.forEach(entity => {
					updatedModel.surgicalMedicalTranscriber.push(entity);
				});
			}

			if (!updatedModel.surgicalMedicalTranscriber.length) {
				updatedModel.surgicalMedicalTranscriberIds = [];
			}
		}
		updatedModel.surgicalNurse = [];
		if (this.surgicalNurseMultiCrudActive) {
			if (event.additionalEntities.surgicalNurse) {
				event.additionalEntities.surgicalNurse.forEach(entity => {
					updatedModel.surgicalNurse.push(entity);
				});
			}

			if (!updatedModel.surgicalNurse.length) {
				updatedModel.surgicalNurseIds = [];
			}
		}
		updatedModel.transferOrderStockDetails = [];
		if (this.transferOrderStockDetailsMultiCrudActive) {
			if (event.additionalEntities.transferOrderStockDetails) {
				event.additionalEntities.transferOrderStockDetails.forEach(entity => {
					updatedModel.transferOrderStockDetails.push(entity);
				});
			}

			if (!updatedModel.transferOrderStockDetails.length) {
				updatedModel.transferOrderStockDetailsIds = [];
			}
		}
		updatedModel.vaccinationOrders = [];
		if (this.vaccinationOrdersMultiCrudActive) {
			if (event.additionalEntities.vaccinationOrders) {
				event.additionalEntities.vaccinationOrders.forEach(entity => {
					updatedModel.vaccinationOrders.push(entity);
				});
			}

			if (!updatedModel.vaccinationOrders.length) {
				updatedModel.vaccinationOrdersIds = [];
			}
		}
		updatedModel.services = [];
		if (this.servicesMultiCrudActive) {
			if (event.additionalEntities.services) {
				event.additionalEntities.services.forEach(entity => {
					updatedModel.services.push(entity);
				});
			}

			if (!updatedModel.services.length) {
				updatedModel.servicesIds = [];
			}
		}

		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
