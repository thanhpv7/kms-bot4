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
package kmsweb.entities;

import kmsweb.entities.enums.*;
import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class StaffEntity extends AbstractEntity {

	public StaffEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AccompanyingConsentsOneMany = new EntityReference();
			AccompanyingConsentsOneMany.entityName = "InformedConsent";
			AccompanyingConsentsOneMany.oppositeName = "AccompanyingStaff";
			AccompanyingConsentsOneMany.name = "AccompanyingConsents";
			AccompanyingConsentsOneMany.optional = true;
			AccompanyingConsentsOneMany.type = "One";
			AccompanyingConsentsOneMany.oppositeType = "Many";

		References.add(AccompanyingConsentsOneMany);

		var AdministratorOneOne = new EntityReference();
			AdministratorOneOne.entityName = "Administrator";
			AdministratorOneOne.oppositeName = "Staff";
			AdministratorOneOne.name = "Administrator";
			AdministratorOneOne.optional = true;
			AdministratorOneOne.type = "One";
			AdministratorOneOne.oppositeType = "One";

		References.add(AdministratorOneOne);

		var AmendmentDetailsOneMany = new EntityReference();
			AmendmentDetailsOneMany.entityName = "AmendmentDetail";
			AmendmentDetailsOneMany.oppositeName = "Staff";
			AmendmentDetailsOneMany.name = "AmendmentDetails";
			AmendmentDetailsOneMany.optional = true;
			AmendmentDetailsOneMany.type = "One";
			AmendmentDetailsOneMany.oppositeType = "Many";

		References.add(AmendmentDetailsOneMany);

		var AnesthesiaMedicalTranscriberOneMany = new EntityReference();
			AnesthesiaMedicalTranscriberOneMany.entityName = "PreoperativeRecords";
			AnesthesiaMedicalTranscriberOneMany.oppositeName = "AnesthesiaMedicalTranscriber";
			AnesthesiaMedicalTranscriberOneMany.name = "AnesthesiaMedicalTranscriber";
			AnesthesiaMedicalTranscriberOneMany.optional = true;
			AnesthesiaMedicalTranscriberOneMany.type = "One";
			AnesthesiaMedicalTranscriberOneMany.oppositeType = "Many";

		References.add(AnesthesiaMedicalTranscriberOneMany);

		var AnesthesiologistOneMany = new EntityReference();
			AnesthesiologistOneMany.entityName = "PreoperativeRecords";
			AnesthesiologistOneMany.oppositeName = "Anesthesiologist";
			AnesthesiologistOneMany.name = "Anesthesiologist";
			AnesthesiologistOneMany.optional = true;
			AnesthesiologistOneMany.type = "One";
			AnesthesiologistOneMany.oppositeType = "Many";

		References.add(AnesthesiologistOneMany);

		var AnesthesiologyNurseOneMany = new EntityReference();
			AnesthesiologyNurseOneMany.entityName = "PreoperativeRecords";
			AnesthesiologyNurseOneMany.oppositeName = "AnesthesiologyNurse";
			AnesthesiologyNurseOneMany.name = "AnesthesiologyNurse";
			AnesthesiologyNurseOneMany.optional = true;
			AnesthesiologyNurseOneMany.type = "One";
			AnesthesiologyNurseOneMany.oppositeType = "Many";

		References.add(AnesthesiologyNurseOneMany);

		var BpjsDoctorMappingOneOne = new EntityReference();
			BpjsDoctorMappingOneOne.entityName = "BpjsDoctorMapping";
			BpjsDoctorMappingOneOne.oppositeName = "Staff";
			BpjsDoctorMappingOneOne.name = "BpjsDoctorMapping";
			BpjsDoctorMappingOneOne.optional = true;
			BpjsDoctorMappingOneOne.type = "One";
			BpjsDoctorMappingOneOne.oppositeType = "One";

		References.add(BpjsDoctorMappingOneOne);

		var CashierStaffOneMany = new EntityReference();
			CashierStaffOneMany.entityName = "CashReceipt";
			CashierStaffOneMany.oppositeName = "CashierStaff";
			CashierStaffOneMany.name = "CashierStaff";
			CashierStaffOneMany.optional = true;
			CashierStaffOneMany.type = "One";
			CashierStaffOneMany.oppositeType = "Many";

		References.add(CashierStaffOneMany);

		var CoTreatingDoctorsOneMany = new EntityReference();
			CoTreatingDoctorsOneMany.entityName = "CoTreatingDoctor";
			CoTreatingDoctorsOneMany.oppositeName = "Staff";
			CoTreatingDoctorsOneMany.name = "CoTreatingDoctors";
			CoTreatingDoctorsOneMany.optional = true;
			CoTreatingDoctorsOneMany.type = "One";
			CoTreatingDoctorsOneMany.oppositeType = "Many";

		References.add(CoTreatingDoctorsOneMany);

		var DailyCareCPPTsCreatedByStaffOneMany = new EntityReference();
			DailyCareCPPTsCreatedByStaffOneMany.entityName = "DailyCareCPPT";
			DailyCareCPPTsCreatedByStaffOneMany.oppositeName = "CreatedByStaff";
			DailyCareCPPTsCreatedByStaffOneMany.name = "DailyCareCPPTsCreatedByStaff";
			DailyCareCPPTsCreatedByStaffOneMany.optional = true;
			DailyCareCPPTsCreatedByStaffOneMany.type = "One";
			DailyCareCPPTsCreatedByStaffOneMany.oppositeType = "Many";

		References.add(DailyCareCPPTsCreatedByStaffOneMany);

		var DailyCareCPPTsDoctorInChargeOneMany = new EntityReference();
			DailyCareCPPTsDoctorInChargeOneMany.entityName = "DailyCareCPPT";
			DailyCareCPPTsDoctorInChargeOneMany.oppositeName = "DoctorInCharge";
			DailyCareCPPTsDoctorInChargeOneMany.name = "DailyCareCPPTsDoctorInCharge";
			DailyCareCPPTsDoctorInChargeOneMany.optional = true;
			DailyCareCPPTsDoctorInChargeOneMany.type = "One";
			DailyCareCPPTsDoctorInChargeOneMany.oppositeType = "Many";

		References.add(DailyCareCPPTsDoctorInChargeOneMany);

		var DailyCareCPPTsMedicalTranscriberOneMany = new EntityReference();
			DailyCareCPPTsMedicalTranscriberOneMany.entityName = "DailyCareCPPT";
			DailyCareCPPTsMedicalTranscriberOneMany.oppositeName = "MedicalTranscriber";
			DailyCareCPPTsMedicalTranscriberOneMany.name = "DailyCareCPPTsMedicalTranscriber";
			DailyCareCPPTsMedicalTranscriberOneMany.optional = true;
			DailyCareCPPTsMedicalTranscriberOneMany.type = "One";
			DailyCareCPPTsMedicalTranscriberOneMany.oppositeType = "Many";

		References.add(DailyCareCPPTsMedicalTranscriberOneMany);

		var DeliveryProgressesOneMany = new EntityReference();
			DeliveryProgressesOneMany.entityName = "DeliveryProgress";
			DeliveryProgressesOneMany.oppositeName = "Staff";
			DeliveryProgressesOneMany.name = "DeliveryProgresses";
			DeliveryProgressesOneMany.optional = true;
			DeliveryProgressesOneMany.type = "One";
			DeliveryProgressesOneMany.oppositeType = "Many";

		References.add(DeliveryProgressesOneMany);

		var DiagnosticStaffExaminationSummariesOneMany = new EntityReference();
			DiagnosticStaffExaminationSummariesOneMany.entityName = "DiagnosticStaffExaminationSummary";
			DiagnosticStaffExaminationSummariesOneMany.oppositeName = "Staff";
			DiagnosticStaffExaminationSummariesOneMany.name = "DiagnosticStaffExaminationSummaries";
			DiagnosticStaffExaminationSummariesOneMany.optional = true;
			DiagnosticStaffExaminationSummariesOneMany.type = "One";
			DiagnosticStaffExaminationSummariesOneMany.oppositeType = "Many";

		References.add(DiagnosticStaffExaminationSummariesOneMany);

		var DismissalReferringStaffOneMany = new EntityReference();
			DismissalReferringStaffOneMany.entityName = "Registration";
			DismissalReferringStaffOneMany.oppositeName = "DismissalReferringStaff";
			DismissalReferringStaffOneMany.name = "DismissalReferringStaff";
			DismissalReferringStaffOneMany.optional = true;
			DismissalReferringStaffOneMany.type = "One";
			DismissalReferringStaffOneMany.oppositeType = "Many";

		References.add(DismissalReferringStaffOneMany);

		var DoctorSchedulesOneMany = new EntityReference();
			DoctorSchedulesOneMany.entityName = "DoctorSchedule";
			DoctorSchedulesOneMany.oppositeName = "Staff";
			DoctorSchedulesOneMany.name = "DoctorSchedules";
			DoctorSchedulesOneMany.optional = true;
			DoctorSchedulesOneMany.type = "One";
			DoctorSchedulesOneMany.oppositeType = "Many";

		References.add(DoctorSchedulesOneMany);

		var DoctorOnExaminationOneMany = new EntityReference();
			DoctorOnExaminationOneMany.entityName = "MedicalExaminationRecord";
			DoctorOnExaminationOneMany.oppositeName = "Doctor";
			DoctorOnExaminationOneMany.name = "DoctorOnExamination";
			DoctorOnExaminationOneMany.optional = true;
			DoctorOnExaminationOneMany.type = "One";
			DoctorOnExaminationOneMany.oppositeType = "Many";

		References.add(DoctorOnExaminationOneMany);

		var FluidBalanceDetailsOneMany = new EntityReference();
			FluidBalanceDetailsOneMany.entityName = "FluidBalanceDetail";
			FluidBalanceDetailsOneMany.oppositeName = "Staff";
			FluidBalanceDetailsOneMany.name = "FluidBalanceDetails";
			FluidBalanceDetailsOneMany.optional = true;
			FluidBalanceDetailsOneMany.type = "One";
			FluidBalanceDetailsOneMany.oppositeType = "Many";

		References.add(FluidBalanceDetailsOneMany);

		var HemodialysisMonitoringsOneMany = new EntityReference();
			HemodialysisMonitoringsOneMany.entityName = "HemodialysisMonitoring";
			HemodialysisMonitoringsOneMany.oppositeName = "MedicalStaff";
			HemodialysisMonitoringsOneMany.name = "HemodialysisMonitorings";
			HemodialysisMonitoringsOneMany.optional = true;
			HemodialysisMonitoringsOneMany.type = "One";
			HemodialysisMonitoringsOneMany.oppositeType = "Many";

		References.add(HemodialysisMonitoringsOneMany);

		var HospitalBranchInformationsOneMany = new EntityReference();
			HospitalBranchInformationsOneMany.entityName = "HospitalBranchInformation";
			HospitalBranchInformationsOneMany.oppositeName = "Staff";
			HospitalBranchInformationsOneMany.name = "HospitalBranchInformations";
			HospitalBranchInformationsOneMany.optional = true;
			HospitalBranchInformationsOneMany.type = "One";
			HospitalBranchInformationsOneMany.oppositeType = "Many";

		References.add(HospitalBranchInformationsOneMany);

		var InformingConsentsOneMany = new EntityReference();
			InformingConsentsOneMany.entityName = "InformedConsent";
			InformingConsentsOneMany.oppositeName = "InformingStaff";
			InformingConsentsOneMany.name = "InformingConsents";
			InformingConsentsOneMany.optional = true;
			InformingConsentsOneMany.type = "One";
			InformingConsentsOneMany.oppositeType = "Many";

		References.add(InformingConsentsOneMany);

		var InvoicesOneMany = new EntityReference();
			InvoicesOneMany.entityName = "Invoice";
			InvoicesOneMany.oppositeName = "VerifiedBy";
			InvoicesOneMany.name = "Invoices";
			InvoicesOneMany.optional = true;
			InvoicesOneMany.type = "One";
			InvoicesOneMany.oppositeType = "Many";

		References.add(InvoicesOneMany);

		var McuPackageItemsOneMany = new EntityReference();
			McuPackageItemsOneMany.entityName = "McuPackageItem";
			McuPackageItemsOneMany.oppositeName = "Staff";
			McuPackageItemsOneMany.name = "McuPackageItems";
			McuPackageItemsOneMany.optional = true;
			McuPackageItemsOneMany.type = "One";
			McuPackageItemsOneMany.oppositeType = "Many";

		References.add(McuPackageItemsOneMany);

		var MedicalCertificateDischargeResumesOneMany = new EntityReference();
			MedicalCertificateDischargeResumesOneMany.entityName = "MedicalCertificateDischargeResume";
			MedicalCertificateDischargeResumesOneMany.oppositeName = "MedicalStaff";
			MedicalCertificateDischargeResumesOneMany.name = "MedicalCertificateDischargeResumes";
			MedicalCertificateDischargeResumesOneMany.optional = true;
			MedicalCertificateDischargeResumesOneMany.type = "One";
			MedicalCertificateDischargeResumesOneMany.oppositeType = "Many";

		References.add(MedicalCertificateDischargeResumesOneMany);

		var MedicalCertificateBirthsOneMany = new EntityReference();
			MedicalCertificateBirthsOneMany.entityName = "MedicalCertificateBirth";
			MedicalCertificateBirthsOneMany.oppositeName = "MedicalStaff";
			MedicalCertificateBirthsOneMany.name = "MedicalCertificateBirths";
			MedicalCertificateBirthsOneMany.optional = true;
			MedicalCertificateBirthsOneMany.type = "One";
			MedicalCertificateBirthsOneMany.oppositeType = "Many";

		References.add(MedicalCertificateBirthsOneMany);

		var MedicalCertificateHospitalizationsOneMany = new EntityReference();
			MedicalCertificateHospitalizationsOneMany.entityName = "MedicalCertificateHospitalization";
			MedicalCertificateHospitalizationsOneMany.oppositeName = "MedicalStaff";
			MedicalCertificateHospitalizationsOneMany.name = "MedicalCertificateHospitalizations";
			MedicalCertificateHospitalizationsOneMany.optional = true;
			MedicalCertificateHospitalizationsOneMany.type = "One";
			MedicalCertificateHospitalizationsOneMany.oppositeType = "Many";

		References.add(MedicalCertificateHospitalizationsOneMany);

		var MedicalExaminationRecordDischargeSummarysOneMany = new EntityReference();
			MedicalExaminationRecordDischargeSummarysOneMany.entityName = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordDischargeSummarysOneMany.oppositeName = "DischargingDoctor";
			MedicalExaminationRecordDischargeSummarysOneMany.name = "MedicalExaminationRecordDischargeSummarys";
			MedicalExaminationRecordDischargeSummarysOneMany.optional = true;
			MedicalExaminationRecordDischargeSummarysOneMany.type = "One";
			MedicalExaminationRecordDischargeSummarysOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordDischargeSummarysOneMany);

		var MedicalRecordTranscriberOneMany = new EntityReference();
			MedicalRecordTranscriberOneMany.entityName = "MedicalExaminationRecord";
			MedicalRecordTranscriberOneMany.oppositeName = "MedicalTranscriber";
			MedicalRecordTranscriberOneMany.name = "MedicalRecordTranscriber";
			MedicalRecordTranscriberOneMany.optional = true;
			MedicalRecordTranscriberOneMany.type = "One";
			MedicalRecordTranscriberOneMany.oppositeType = "Many";

		References.add(MedicalRecordTranscriberOneMany);

		var MedicalStaffOfMedicalAttendancesCertificateOneMany = new EntityReference();
			MedicalStaffOfMedicalAttendancesCertificateOneMany.entityName = "MedicalCertificateMedicalAttendance";
			MedicalStaffOfMedicalAttendancesCertificateOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOfMedicalAttendancesCertificateOneMany.name = "MedicalStaffOfMedicalAttendancesCertificate";
			MedicalStaffOfMedicalAttendancesCertificateOneMany.optional = true;
			MedicalStaffOfMedicalAttendancesCertificateOneMany.type = "One";
			MedicalStaffOfMedicalAttendancesCertificateOneMany.oppositeType = "Many";

		References.add(MedicalStaffOfMedicalAttendancesCertificateOneMany);

		var MedicalStaffOfMentalHealthsOneMany = new EntityReference();
			MedicalStaffOfMentalHealthsOneMany.entityName = "MedicalCertificateMentalHealth";
			MedicalStaffOfMentalHealthsOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOfMentalHealthsOneMany.name = "MedicalStaffOfMentalHealths";
			MedicalStaffOfMentalHealthsOneMany.optional = true;
			MedicalStaffOfMentalHealthsOneMany.type = "One";
			MedicalStaffOfMentalHealthsOneMany.oppositeType = "Many";

		References.add(MedicalStaffOfMentalHealthsOneMany);

		var MedicalStaffOfPhysicalHealthsOneMany = new EntityReference();
			MedicalStaffOfPhysicalHealthsOneMany.entityName = "MedicalCertificatePhysicalHealth";
			MedicalStaffOfPhysicalHealthsOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOfPhysicalHealthsOneMany.name = "MedicalStaffOfPhysicalHealths";
			MedicalStaffOfPhysicalHealthsOneMany.optional = true;
			MedicalStaffOfPhysicalHealthsOneMany.type = "One";
			MedicalStaffOfPhysicalHealthsOneMany.oppositeType = "Many";

		References.add(MedicalStaffOfPhysicalHealthsOneMany);

		var MedicalStaffOfRestrictedWorksCertificateOneMany = new EntityReference();
			MedicalStaffOfRestrictedWorksCertificateOneMany.entityName = "MedicalCertificateRestrictedWork";
			MedicalStaffOfRestrictedWorksCertificateOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOfRestrictedWorksCertificateOneMany.name = "MedicalStaffOfRestrictedWorksCertificate";
			MedicalStaffOfRestrictedWorksCertificateOneMany.optional = true;
			MedicalStaffOfRestrictedWorksCertificateOneMany.type = "One";
			MedicalStaffOfRestrictedWorksCertificateOneMany.oppositeType = "Many";

		References.add(MedicalStaffOfRestrictedWorksCertificateOneMany);

		var MedicalStaffOfSickLeavesCertificateOneMany = new EntityReference();
			MedicalStaffOfSickLeavesCertificateOneMany.entityName = "MedicalCertificateSickLeave";
			MedicalStaffOfSickLeavesCertificateOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOfSickLeavesCertificateOneMany.name = "MedicalStaffOfSickLeavesCertificate";
			MedicalStaffOfSickLeavesCertificateOneMany.optional = true;
			MedicalStaffOfSickLeavesCertificateOneMany.type = "One";
			MedicalStaffOfSickLeavesCertificateOneMany.oppositeType = "Many";

		References.add(MedicalStaffOfSickLeavesCertificateOneMany);

		var MedicationAdministeredHisotriesOneMany = new EntityReference();
			MedicationAdministeredHisotriesOneMany.entityName = "MedicationAdministeredHistory";
			MedicationAdministeredHisotriesOneMany.oppositeName = "Staff";
			MedicationAdministeredHisotriesOneMany.name = "MedicationAdministeredHisotries";
			MedicationAdministeredHisotriesOneMany.optional = true;
			MedicationAdministeredHisotriesOneMany.type = "One";
			MedicationAdministeredHisotriesOneMany.oppositeType = "Many";

		References.add(MedicationAdministeredHisotriesOneMany);

		var MedicationHeadersOneMany = new EntityReference();
			MedicationHeadersOneMany.entityName = "MedicationHeader";
			MedicationHeadersOneMany.oppositeName = "RequestedBy";
			MedicationHeadersOneMany.name = "MedicationHeaders";
			MedicationHeadersOneMany.optional = true;
			MedicationHeadersOneMany.type = "One";
			MedicationHeadersOneMany.oppositeType = "Many";

		References.add(MedicationHeadersOneMany);

		var MidwivesOneMany = new EntityReference();
			MidwivesOneMany.entityName = "DeliveryMedicalExaminationRecord";
			MidwivesOneMany.oppositeName = "Midwife";
			MidwivesOneMany.name = "Midwives";
			MidwivesOneMany.optional = true;
			MidwivesOneMany.type = "One";
			MidwivesOneMany.oppositeType = "Many";

		References.add(MidwivesOneMany);

		var NurseOneMany = new EntityReference();
			NurseOneMany.entityName = "MedicalExaminationRecord";
			NurseOneMany.oppositeName = "Nurse";
			NurseOneMany.name = "Nurse";
			NurseOneMany.optional = true;
			NurseOneMany.type = "One";
			NurseOneMany.oppositeType = "Many";

		References.add(NurseOneMany);

		var NursingDetailSurgicalNursingOneMany = new EntityReference();
			NursingDetailSurgicalNursingOneMany.entityName = "OperatingTheaterMedicalExaminationRecord";
			NursingDetailSurgicalNursingOneMany.oppositeName = "NursingDetailSurgicalNursings";
			NursingDetailSurgicalNursingOneMany.name = "NursingDetailSurgicalNursing";
			NursingDetailSurgicalNursingOneMany.optional = true;
			NursingDetailSurgicalNursingOneMany.type = "One";
			NursingDetailSurgicalNursingOneMany.oppositeType = "Many";

		References.add(NursingDetailSurgicalNursingOneMany);

		var NursingDetailsAnesthesiaNursingOneMany = new EntityReference();
			NursingDetailsAnesthesiaNursingOneMany.entityName = "OperatingTheaterMedicalExaminationRecord";
			NursingDetailsAnesthesiaNursingOneMany.oppositeName = "NursingDetailsAnesthesiaNursings";
			NursingDetailsAnesthesiaNursingOneMany.name = "NursingDetailsAnesthesiaNursing";
			NursingDetailsAnesthesiaNursingOneMany.optional = true;
			NursingDetailsAnesthesiaNursingOneMany.type = "One";
			NursingDetailsAnesthesiaNursingOneMany.oppositeType = "Many";

		References.add(NursingDetailsAnesthesiaNursingOneMany);

		var PcareDokterOneOne = new EntityReference();
			PcareDokterOneOne.entityName = "PcareDokter";
			PcareDokterOneOne.oppositeName = "Staff";
			PcareDokterOneOne.name = "PcareDokter";
			PcareDokterOneOne.optional = true;
			PcareDokterOneOne.type = "One";
			PcareDokterOneOne.oppositeType = "One";

		References.add(PcareDokterOneOne);

		var PatientConsentsOneMany = new EntityReference();
			PatientConsentsOneMany.entityName = "PatientConsent";
			PatientConsentsOneMany.oppositeName = "Staff";
			PatientConsentsOneMany.name = "PatientConsents";
			PatientConsentsOneMany.optional = true;
			PatientConsentsOneMany.type = "One";
			PatientConsentsOneMany.oppositeType = "Many";

		References.add(PatientConsentsOneMany);

		var PatientVitalInformationsOneMany = new EntityReference();
			PatientVitalInformationsOneMany.entityName = "PatientVitalInformation";
			PatientVitalInformationsOneMany.oppositeName = "Staff";
			PatientVitalInformationsOneMany.name = "PatientVitalInformations";
			PatientVitalInformationsOneMany.optional = true;
			PatientVitalInformationsOneMany.type = "One";
			PatientVitalInformationsOneMany.oppositeType = "Many";

		References.add(PatientVitalInformationsOneMany);

		var PediatricianInChargeOneMany = new EntityReference();
			PediatricianInChargeOneMany.entityName = "NewbornDetail";
			PediatricianInChargeOneMany.oppositeName = "Staff";
			PediatricianInChargeOneMany.name = "PediatricianInCharge";
			PediatricianInChargeOneMany.optional = true;
			PediatricianInChargeOneMany.type = "One";
			PediatricianInChargeOneMany.oppositeType = "Many";

		References.add(PediatricianInChargeOneMany);

		var PrescriptionHeadersOneMany = new EntityReference();
			PrescriptionHeadersOneMany.entityName = "PrescriptionHeader";
			PrescriptionHeadersOneMany.oppositeName = "RequestedBy";
			PrescriptionHeadersOneMany.name = "PrescriptionHeaders";
			PrescriptionHeadersOneMany.optional = true;
			PrescriptionHeadersOneMany.type = "One";
			PrescriptionHeadersOneMany.oppositeType = "Many";

		References.add(PrescriptionHeadersOneMany);

		var ProcessWorkflowLogsOneMany = new EntityReference();
			ProcessWorkflowLogsOneMany.entityName = "ProcessWorkflow";
			ProcessWorkflowLogsOneMany.oppositeName = "Staff";
			ProcessWorkflowLogsOneMany.name = "ProcessWorkflowLogs";
			ProcessWorkflowLogsOneMany.optional = true;
			ProcessWorkflowLogsOneMany.type = "One";
			ProcessWorkflowLogsOneMany.oppositeType = "Many";

		References.add(ProcessWorkflowLogsOneMany);

		var RegistrationsOneMany = new EntityReference();
			RegistrationsOneMany.entityName = "Registration";
			RegistrationsOneMany.oppositeName = "Staff";
			RegistrationsOneMany.name = "Registrations";
			RegistrationsOneMany.optional = true;
			RegistrationsOneMany.type = "One";
			RegistrationsOneMany.oppositeType = "Many";

		References.add(RegistrationsOneMany);

		var RequestedByOneMany = new EntityReference();
			RequestedByOneMany.entityName = "Registration";
			RequestedByOneMany.oppositeName = "RequestedBy";
			RequestedByOneMany.name = "RequestedBy";
			RequestedByOneMany.optional = true;
			RequestedByOneMany.type = "One";
			RequestedByOneMany.oppositeType = "Many";

		References.add(RequestedByOneMany);

		var RoomTransfersOneMany = new EntityReference();
			RoomTransfersOneMany.entityName = "RoomTransfer";
			RoomTransfersOneMany.oppositeName = "TransferringStaff";
			RoomTransfersOneMany.name = "RoomTransfers";
			RoomTransfersOneMany.optional = true;
			RoomTransfersOneMany.type = "One";
			RoomTransfersOneMany.oppositeType = "Many";

		References.add(RoomTransfersOneMany);

		var SampleCollectionStaffsOneMany = new EntityReference();
			SampleCollectionStaffsOneMany.entityName = "SampleCollectionItems";
			SampleCollectionStaffsOneMany.oppositeName = "SampleCollectionStaff";
			SampleCollectionStaffsOneMany.name = "SampleCollectionStaffs";
			SampleCollectionStaffsOneMany.optional = true;
			SampleCollectionStaffsOneMany.type = "One";
			SampleCollectionStaffsOneMany.oppositeType = "Many";

		References.add(SampleCollectionStaffsOneMany);

		var SampleDeliveryStaffsOneMany = new EntityReference();
			SampleDeliveryStaffsOneMany.entityName = "SampleCollectionItems";
			SampleDeliveryStaffsOneMany.oppositeName = "SampleDeliveryStaff";
			SampleDeliveryStaffsOneMany.name = "SampleDeliveryStaffs";
			SampleDeliveryStaffsOneMany.optional = true;
			SampleDeliveryStaffsOneMany.type = "One";
			SampleDeliveryStaffsOneMany.oppositeType = "Many";

		References.add(SampleDeliveryStaffsOneMany);

		var SampleProcessingStaffsOneMany = new EntityReference();
			SampleProcessingStaffsOneMany.entityName = "SampleCollectionItems";
			SampleProcessingStaffsOneMany.oppositeName = "SampleProcessingStaff";
			SampleProcessingStaffsOneMany.name = "SampleProcessingStaffs";
			SampleProcessingStaffsOneMany.optional = true;
			SampleProcessingStaffsOneMany.type = "One";
			SampleProcessingStaffsOneMany.oppositeType = "Many";

		References.add(SampleProcessingStaffsOneMany);

		var ServiceOneOne = new EntityReference();
			ServiceOneOne.entityName = "Service";
			ServiceOneOne.oppositeName = "DefaultMedicalStaff";
			ServiceOneOne.name = "Service";
			ServiceOneOne.optional = true;
			ServiceOneOne.type = "One";
			ServiceOneOne.oppositeType = "One";

		References.add(ServiceOneOne);

		var ServicesManyMany = new EntityReference();
			ServicesManyMany.entityName = "Service";
			ServicesManyMany.oppositeName = "AssignedMedicalStaff";
			ServicesManyMany.name = "Services";
			ServicesManyMany.optional = true;
			ServicesManyMany.type = "Many";
			ServicesManyMany.oppositeType = "Many";

		References.add(ServicesManyMany);

		var AdministrationUserOneOne = new EntityReference();
			AdministrationUserOneOne.entityName = "AdministrationUser";
			AdministrationUserOneOne.oppositeName = "AdministrationUser";
			AdministrationUserOneOne.name = "Staff";
			AdministrationUserOneOne.optional = true;
			AdministrationUserOneOne.type = "One";
			AdministrationUserOneOne.oppositeType = "One";

		References.add(AdministrationUserOneOne);

		var CashierUserOneOne = new EntityReference();
			CashierUserOneOne.entityName = "CashierUser";
			CashierUserOneOne.oppositeName = "CashierUser";
			CashierUserOneOne.name = "Staff";
			CashierUserOneOne.optional = true;
			CashierUserOneOne.type = "One";
			CashierUserOneOne.oppositeType = "One";

		References.add(CashierUserOneOne);

		var ClaimUserOneOne = new EntityReference();
			ClaimUserOneOne.entityName = "ClaimUser";
			ClaimUserOneOne.oppositeName = "ClaimUser";
			ClaimUserOneOne.name = "Staff";
			ClaimUserOneOne.optional = true;
			ClaimUserOneOne.type = "One";
			ClaimUserOneOne.oppositeType = "One";

		References.add(ClaimUserOneOne);

		var DiagnosticSupportUserOneOne = new EntityReference();
			DiagnosticSupportUserOneOne.entityName = "DiagnosticSupportUser";
			DiagnosticSupportUserOneOne.oppositeName = "DiagnosticSupportUser";
			DiagnosticSupportUserOneOne.name = "Staff";
			DiagnosticSupportUserOneOne.optional = true;
			DiagnosticSupportUserOneOne.type = "One";
			DiagnosticSupportUserOneOne.oppositeType = "One";

		References.add(DiagnosticSupportUserOneOne);

		var DoctorUserOneOne = new EntityReference();
			DoctorUserOneOne.entityName = "DoctorUser";
			DoctorUserOneOne.oppositeName = "DoctorUser";
			DoctorUserOneOne.name = "Staff";
			DoctorUserOneOne.optional = true;
			DoctorUserOneOne.type = "One";
			DoctorUserOneOne.oppositeType = "One";

		References.add(DoctorUserOneOne);

		var FacilityUserOneOne = new EntityReference();
			FacilityUserOneOne.entityName = "FacilityUser";
			FacilityUserOneOne.oppositeName = "FacilityUser";
			FacilityUserOneOne.name = "Staff";
			FacilityUserOneOne.optional = true;
			FacilityUserOneOne.type = "One";
			FacilityUserOneOne.oppositeType = "One";

		References.add(FacilityUserOneOne);

		var ManagementUserOneOne = new EntityReference();
			ManagementUserOneOne.entityName = "ManagementUser";
			ManagementUserOneOne.oppositeName = "ManagementUser";
			ManagementUserOneOne.name = "Staff";
			ManagementUserOneOne.optional = true;
			ManagementUserOneOne.type = "One";
			ManagementUserOneOne.oppositeType = "One";

		References.add(ManagementUserOneOne);

		var MedicalRecordUserOneOne = new EntityReference();
			MedicalRecordUserOneOne.entityName = "MedicalRecordUser";
			MedicalRecordUserOneOne.oppositeName = "MedicalRecordUser";
			MedicalRecordUserOneOne.name = "Staff";
			MedicalRecordUserOneOne.optional = true;
			MedicalRecordUserOneOne.type = "One";
			MedicalRecordUserOneOne.oppositeType = "One";

		References.add(MedicalRecordUserOneOne);

		var MedicalTranscriberUserOneOne = new EntityReference();
			MedicalTranscriberUserOneOne.entityName = "MedicalTranscriberUser";
			MedicalTranscriberUserOneOne.oppositeName = "MedicalTranscriberUser";
			MedicalTranscriberUserOneOne.name = "Staff";
			MedicalTranscriberUserOneOne.optional = true;
			MedicalTranscriberUserOneOne.type = "One";
			MedicalTranscriberUserOneOne.oppositeType = "One";

		References.add(MedicalTranscriberUserOneOne);

		var NurseUserOneOne = new EntityReference();
			NurseUserOneOne.entityName = "NurseUser";
			NurseUserOneOne.oppositeName = "NurseUser";
			NurseUserOneOne.name = "Staff";
			NurseUserOneOne.optional = true;
			NurseUserOneOne.type = "One";
			NurseUserOneOne.oppositeType = "One";

		References.add(NurseUserOneOne);

		var PharmacyUserOneOne = new EntityReference();
			PharmacyUserOneOne.entityName = "PharmacyUser";
			PharmacyUserOneOne.oppositeName = "PharmacyUser";
			PharmacyUserOneOne.name = "Staff";
			PharmacyUserOneOne.optional = true;
			PharmacyUserOneOne.type = "One";
			PharmacyUserOneOne.oppositeType = "One";

		References.add(PharmacyUserOneOne);

		var PurchasingUserOneOne = new EntityReference();
			PurchasingUserOneOne.entityName = "PurchasingUser";
			PurchasingUserOneOne.oppositeName = "PurchasingUser";
			PurchasingUserOneOne.name = "Staff";
			PurchasingUserOneOne.optional = true;
			PurchasingUserOneOne.type = "One";
			PurchasingUserOneOne.oppositeType = "One";

		References.add(PurchasingUserOneOne);

		var RegistrationUserOneOne = new EntityReference();
			RegistrationUserOneOne.entityName = "RegistrationUser";
			RegistrationUserOneOne.oppositeName = "RegistrationUser";
			RegistrationUserOneOne.name = "Staff";
			RegistrationUserOneOne.optional = true;
			RegistrationUserOneOne.type = "One";
			RegistrationUserOneOne.oppositeType = "One";

		References.add(RegistrationUserOneOne);

		var SystemAdminUserOneOne = new EntityReference();
			SystemAdminUserOneOne.entityName = "SystemAdminUser";
			SystemAdminUserOneOne.oppositeName = "SystemAdminUser";
			SystemAdminUserOneOne.name = "Staff";
			SystemAdminUserOneOne.optional = true;
			SystemAdminUserOneOne.type = "One";
			SystemAdminUserOneOne.oppositeType = "One";

		References.add(SystemAdminUserOneOne);

		var WarehouseUserOneOne = new EntityReference();
			WarehouseUserOneOne.entityName = "WarehouseUser";
			WarehouseUserOneOne.oppositeName = "WarehouseUser";
			WarehouseUserOneOne.name = "Staff";
			WarehouseUserOneOne.optional = true;
			WarehouseUserOneOne.type = "One";
			WarehouseUserOneOne.oppositeType = "One";

		References.add(WarehouseUserOneOne);

		var SurgeonOneMany = new EntityReference();
			SurgeonOneMany.entityName = "PreoperativeRecords";
			SurgeonOneMany.oppositeName = "Surgeon";
			SurgeonOneMany.name = "Surgeon";
			SurgeonOneMany.optional = true;
			SurgeonOneMany.type = "One";
			SurgeonOneMany.oppositeType = "Many";

		References.add(SurgeonOneMany);

		var SurgicalMedicalTranscriberOneMany = new EntityReference();
			SurgicalMedicalTranscriberOneMany.entityName = "PreoperativeRecords";
			SurgicalMedicalTranscriberOneMany.oppositeName = "SurgicalMedicalTranscriber";
			SurgicalMedicalTranscriberOneMany.name = "SurgicalMedicalTranscriber";
			SurgicalMedicalTranscriberOneMany.optional = true;
			SurgicalMedicalTranscriberOneMany.type = "One";
			SurgicalMedicalTranscriberOneMany.oppositeType = "Many";

		References.add(SurgicalMedicalTranscriberOneMany);

		var SurgicalNurseOneMany = new EntityReference();
			SurgicalNurseOneMany.entityName = "PreoperativeRecords";
			SurgicalNurseOneMany.oppositeName = "SurgicalNurse";
			SurgicalNurseOneMany.name = "SurgicalNurse";
			SurgicalNurseOneMany.optional = true;
			SurgicalNurseOneMany.type = "One";
			SurgicalNurseOneMany.oppositeType = "Many";

		References.add(SurgicalNurseOneMany);

		var TransferOrderStockDetailsOneMany = new EntityReference();
			TransferOrderStockDetailsOneMany.entityName = "TransferOrderStockDetail";
			TransferOrderStockDetailsOneMany.oppositeName = "Staff";
			TransferOrderStockDetailsOneMany.name = "TransferOrderStockDetails";
			TransferOrderStockDetailsOneMany.optional = true;
			TransferOrderStockDetailsOneMany.type = "One";
			TransferOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(TransferOrderStockDetailsOneMany);

		var VaccinationOrdersOneMany = new EntityReference();
			VaccinationOrdersOneMany.entityName = "VaccinationOrder";
			VaccinationOrdersOneMany.oppositeName = "Staff";
			VaccinationOrdersOneMany.name = "VaccinationOrders";
			VaccinationOrdersOneMany.optional = true;
			VaccinationOrdersOneMany.type = "One";
			VaccinationOrdersOneMany.oppositeType = "Many";

		References.add(VaccinationOrdersOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Staff Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Staff Number here] end
	private String staffNumber;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Date of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Staff Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Staff Type here] end
	private String staffType;

	// % protected region % [Modify attribute annotation for Specialization here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specialization here] end
	private String specialization;

	// % protected region % [Modify attribute annotation for Education here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Education here] end
	private String education;

	// % protected region % [Modify attribute annotation for License No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for License No here] end
	private String licenseNo;

	// % protected region % [Modify attribute annotation for Letter of Reg here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Letter of Reg here] end
	private String letterOfReg;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Employee ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Employee ID here] end
	private String employeeID;

	// % protected region % [Modify attribute annotation for Title here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Default Service Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Default Service Number here] end
	private String defaultServiceNumber;

	// % protected region % [Modify attribute annotation for Place of birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Place of birth here] end
	private String placeOfBirth;

	// % protected region % [Modify attribute annotation for Religion here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Religion here] end
	private String religion;

	// % protected region % [Modify attribute annotation for Blood Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Blood Type here] end
	private BloodTypeEnum bloodType;

	// % protected region % [Modify attribute annotation for Rhesus here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rhesus here] end
	private RhesusEnum rhesus;

	// % protected region % [Modify attribute annotation for address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for State here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for State here] end
	private String state;

	// % protected region % [Modify attribute annotation for Regency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Regency here] end
	private String regency;

	// % protected region % [Modify attribute annotation for District here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for District here] end
	private String district;

	// % protected region % [Modify attribute annotation for Home phone no here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Home phone no here] end
	private String homePhoneNo;

	// % protected region % [Modify attribute annotation for Village here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Village here] end
	private String village;

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Office Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Office Phone Number here] end
	private String officePhoneNumber;

	// % protected region % [Modify attribute annotation for Tax Identification No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Identification No here] end
	private String taxIdentificationNo;

	// % protected region % [Modify attribute annotation for Mobile Phone No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone No here] end
	private String mobilePhoneNo;

	// % protected region % [Modify attribute annotation for Other Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Notes here] end
	private String otherNotes;

	// % protected region % [Modify attribute annotation for Training here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Training here] end
	private String training;

	// % protected region % [Modify attribute annotation for Nationality here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nationality here] end
	private String nationality;

	// % protected region % [Modify attribute annotation for Certification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Certification here] end
	private String certification;

	// % protected region % [Modify attribute annotation for Ext No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ext No here] end
	private String extNo;

	// % protected region % [Modify attribute annotation for Marital Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Marital Status here] end
	private String maritalStatus;

	// % protected region % [Modify attribute annotation for email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for email here] end
	private String email;

	private Set<FileEntity> staffPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private AdministratorEntity administrator;

	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	private PcareDokterEntity pcareDokter;

	private ServiceEntity service;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private AdministrationUserEntity administrationUser;

	private CashierUserEntity cashierUser;

	private ClaimUserEntity claimUser;

	private DiagnosticSupportUserEntity diagnosticSupportUser;

	private DoctorUserEntity doctorUser;

	private FacilityUserEntity facilityUser;

	private ManagementUserEntity managementUser;

	private MedicalRecordUserEntity medicalRecordUser;

	private MedicalTranscriberUserEntity medicalTranscriberUser;

	private NurseUserEntity nurseUser;

	private PharmacyUserEntity pharmacyUser;

	private PurchasingUserEntity purchasingUser;

	private RegistrationUserEntity registrationUser;

	private SystemAdminUserEntity systemAdminUser;

	private WarehouseUserEntity warehouseUser;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InformedConsentEntity> accompanyingConsents = new HashSet<>();

	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiologist = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiologyNurse = new HashSet<>();

	private Set<CashReceiptEntity> cashierStaff = new HashSet<>();

	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber = new HashSet<>();

	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	private Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries = new HashSet<>();

	private Set<RegistrationEntity> dismissalReferringStaff = new HashSet<>();

	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> doctorOnExamination = new HashSet<>();

	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	private Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();

	private Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();

	private Set<InformedConsentEntity> informingConsents = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes = new HashSet<>();

	private Set<MedicalCertificateBirthEntity> medicalCertificateBirths = new HashSet<>();

	private Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations = new HashSet<>();

	private Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> medicalRecordTranscriber = new HashSet<>();

	private Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate = new HashSet<>();

	private Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths = new HashSet<>();

	private Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths = new HashSet<>();

	private Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate = new HashSet<>();

	private Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate = new HashSet<>();

	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private Set<DeliveryMedicalExaminationRecordEntity> midwives = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> nurse = new HashSet<>();

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing = new HashSet<>();

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing = new HashSet<>();

	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	private Set<NewbornDetailEntity> pediatricianInCharge = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private Set<ProcessWorkflowEntity> processWorkflowLogs = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<RegistrationEntity> requestedBy = new HashSet<>();

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleCollectionStaffs = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleDeliveryStaffs = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleProcessingStaffs = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgeon = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgicalNurse = new HashSet<>();

	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<ServiceEntity> services = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAccompanyingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addAccompanyingConsents(@NonNull InformedConsentEntity entity) {
		addAccompanyingConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to accompanyingConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAccompanyingConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.accompanyingConsents.contains(entity)) {
			accompanyingConsents.add(entity);
			if (reverseAdd) {
				entity.setAccompanyingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		addAccompanyingConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Accompanying Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAccompanyingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAccompanyingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeAccompanyingConsents(@NonNull InformedConsentEntity entity) {
		this.removeAccompanyingConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAccompanyingConsents(@NonNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAccompanyingStaff(false);
		}
		this.accompanyingConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		this.removeAccompanyingConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAccompanyingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAccompanyingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		setAccompanyingConsents(entities, true);
	}

	/**
	 * Replace the current entities in Accompanying Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAccompanyingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetAccompanyingConsents();
		this.accompanyingConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.accompanyingConsents.forEach(accompanyingConsentsEntity -> accompanyingConsentsEntity.setAccompanyingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAccompanyingConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAccompanyingConsents() {
		this.unsetAccompanyingConsents(true);
	}

	/**
	 * Remove all the entities in Accompanying Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAccompanyingConsents(boolean doReverse) {
		if (doReverse) {
			this.accompanyingConsents.forEach(accompanyingConsentsEntity -> accompanyingConsentsEntity.unsetAccompanyingStaff(false));
		}
		this.accompanyingConsents.clear();
	}

	/**
	 * Similar to {@link this#setAdministrator(AdministratorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAdministrator(@NonNull AdministratorEntity entity) {
		setAdministrator(entity, true);
	}

	/**
	 * Set or update administrator with the given AdministratorEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdministrator(@NonNull AdministratorEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdministrator here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdministrator here] end

		if (sameAsFormer(this.administrator, entity)) {
			return;
		}

		if (this.administrator != null) {
			this.administrator.unsetStaff();
		}

		this.administrator = entity;

		if (reverseAdd) {
			this.administrator.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdministrator outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdministrator outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetAdministrator(boolean)} but default to true.
	 */
	public void unsetAdministrator() {
		this.unsetAdministrator(true);
	}

	/**
	 * Remove the AdministratorEntity in Administrator from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdministrator(boolean reverse) {
		if (reverse && this.administrator != null) {
			this.administrator.unsetStaff(false);
		}
		this.administrator = null;
	}

/**
	 * Similar to {@link this#addAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity) {
		addAmendmentDetails(entity, true);
	}

	/**
	 * Add a new AmendmentDetailEntity to amendmentDetails in this entity.
	 *
	 * @param entity the given AmendmentDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverseAdd) {
		if (!this.amendmentDetails.contains(entity)) {
			amendmentDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		addAmendmentDetails(entities, true);
	}

	/**
	 * Add a new collection of AmendmentDetailEntity to Amendment Details in this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be set to this entity
	 */
	public void removeAmendmentDetails(@NonNull AmendmentDetailEntity entity) {
		this.removeAmendmentDetails(entity, true);
	}

	/**
	 * Remove the given AmendmentDetailEntity from this entity.
	 *
	 * @param entity the given AmendmentDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.amendmentDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		this.removeAmendmentDetails(entities, true);
	}

	/**
	 * Remove the given collection of AmendmentDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be set to this entity
	 */
	public void setAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities) {
		setAmendmentDetails(entities, true);
	}

	/**
	 * Replace the current entities in Amendment Details with the given ones.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {

		this.unsetAmendmentDetails();
		this.amendmentDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAmendmentDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAmendmentDetails() {
		this.unsetAmendmentDetails(true);
	}

	/**
	 * Remove all the entities in Amendment Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAmendmentDetails(boolean doReverse) {
		if (doReverse) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.unsetStaff(false));
		}
		this.amendmentDetails.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiaMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity) {
		addAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiaMedicalTranscriber in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiaMedicalTranscriber.contains(entity)) {
			anesthesiaMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiaMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesia Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiaMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiaMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiaMedicalTranscriber(false);
		}
		this.anesthesiaMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiaMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiaMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiaMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesia Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiaMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiaMedicalTranscriber();
		this.anesthesiaMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiaMedicalTranscriber.forEach(anesthesiaMedicalTranscriberEntity -> anesthesiaMedicalTranscriberEntity.setAnesthesiaMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiaMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiaMedicalTranscriber() {
		this.unsetAnesthesiaMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Anesthesia Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiaMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.anesthesiaMedicalTranscriber.forEach(anesthesiaMedicalTranscriberEntity -> anesthesiaMedicalTranscriberEntity.unsetAnesthesiaMedicalTranscriber(false));
		}
		this.anesthesiaMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologist(@NonNull PreoperativeRecordsEntity entity) {
		addAnesthesiologist(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiologist in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiologist(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiologist.contains(entity)) {
			anesthesiologist.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiologist(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesiologist in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiologist(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiologist(@NonNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiologist(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiologist(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiologist(false);
		}
		this.anesthesiologist.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiologist(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiologist(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiologist(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiologist(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesiologist with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiologist(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiologist();
		this.anesthesiologist = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiologist.forEach(anesthesiologistEntity -> anesthesiologistEntity.setAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologist(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiologist() {
		this.unsetAnesthesiologist(true);
	}

	/**
	 * Remove all the entities in Anesthesiologist from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiologist(boolean doReverse) {
		if (doReverse) {
			this.anesthesiologist.forEach(anesthesiologistEntity -> anesthesiologistEntity.unsetAnesthesiologist(false));
		}
		this.anesthesiologist.clear();
	}

/**
	 * Similar to {@link this#addAnesthesiologyNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologyNurse(@NonNull PreoperativeRecordsEntity entity) {
		addAnesthesiologyNurse(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to anesthesiologyNurse in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAnesthesiologyNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.anesthesiologyNurse.contains(entity)) {
			anesthesiologyNurse.add(entity);
			if (reverseAdd) {
				entity.setAnesthesiologyNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addAnesthesiologyNurse(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Anesthesiology Nurse in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAnesthesiologyNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAnesthesiologyNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeAnesthesiologyNurse(@NonNull PreoperativeRecordsEntity entity) {
		this.removeAnesthesiologyNurse(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAnesthesiologyNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAnesthesiologyNurse(false);
		}
		this.anesthesiologyNurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeAnesthesiologyNurse(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAnesthesiologyNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAnesthesiologyNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setAnesthesiologyNurse(entities, true);
	}

	/**
	 * Replace the current entities in Anesthesiology Nurse with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAnesthesiologyNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetAnesthesiologyNurse();
		this.anesthesiologyNurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.anesthesiologyNurse.forEach(anesthesiologyNurseEntity -> anesthesiologyNurseEntity.setAnesthesiologyNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologyNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAnesthesiologyNurse() {
		this.unsetAnesthesiologyNurse(true);
	}

	/**
	 * Remove all the entities in Anesthesiology Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAnesthesiologyNurse(boolean doReverse) {
		if (doReverse) {
			this.anesthesiologyNurse.forEach(anesthesiologyNurseEntity -> anesthesiologyNurseEntity.unsetAnesthesiologyNurse(false));
		}
		this.anesthesiologyNurse.clear();
	}

	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update bpjsDoctorMapping with the given BpjsDoctorMappingEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.unsetStaff();
		}

		this.bpjsDoctorMapping = entity;

		if (reverseAdd) {
			this.bpjsDoctorMapping.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove the BpjsDoctorMappingEntity in BPJS Doctor Mapping from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.unsetStaff(false);
		}
		this.bpjsDoctorMapping = null;
	}

/**
	 * Similar to {@link this#addCashierStaff(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashierStaff(@NonNull CashReceiptEntity entity) {
		addCashierStaff(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to cashierStaff in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashierStaff(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.cashierStaff.contains(entity)) {
			cashierStaff.add(entity);
			if (reverseAdd) {
				entity.setCashierStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashierStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addCashierStaff(@NonNull Collection<CashReceiptEntity> entities) {
		addCashierStaff(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Cashier Staff in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashierStaff(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashierStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashierStaff(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeCashierStaff(@NonNull CashReceiptEntity entity) {
		this.removeCashierStaff(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashierStaff(@NonNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCashierStaff(false);
		}
		this.cashierStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashierStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeCashierStaff(@NonNull Collection<CashReceiptEntity> entities) {
		this.removeCashierStaff(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashierStaff(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashierStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashierStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setCashierStaff(@NonNull Collection<CashReceiptEntity> entities) {
		setCashierStaff(entities, true);
	}

	/**
	 * Replace the current entities in Cashier Staff with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashierStaff(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetCashierStaff();
		this.cashierStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashierStaff.forEach(cashierStaffEntity -> cashierStaffEntity.setCashierStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashierStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashierStaff() {
		this.unsetCashierStaff(true);
	}

	/**
	 * Remove all the entities in Cashier Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashierStaff(boolean doReverse) {
		if (doReverse) {
			this.cashierStaff.forEach(cashierStaffEntity -> cashierStaffEntity.unsetCashierStaff(false));
		}
		this.cashierStaff.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity) {
		addCoTreatingDoctors(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingDoctors in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingDoctors.contains(entity)) {
			coTreatingDoctors.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingDoctors(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Doctors in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingDoctors(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.coTreatingDoctors.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingDoctors(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingDoctors(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Doctors with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingDoctors();
		this.coTreatingDoctors = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingDoctors(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingDoctors() {
		this.unsetCoTreatingDoctors(true);
	}

	/**
	 * Remove all the entities in Co Treating Doctors from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingDoctors(boolean doReverse) {
		if (doReverse) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.unsetStaff(false));
		}
		this.coTreatingDoctors.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsCreatedByStaff(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsCreatedByStaff(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsCreatedByStaff in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsCreatedByStaff.contains(entity)) {
			dailyCareCPPTsCreatedByStaff.add(entity);
			if (reverseAdd) {
				entity.setCreatedByStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Created By Staff in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsCreatedByStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsCreatedByStaff(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NonNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsCreatedByStaff(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCreatedByStaff(false);
		}
		this.dailyCareCPPTsCreatedByStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsCreatedByStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsCreatedByStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsCreatedByStaff(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Created By Staff with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsCreatedByStaff(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsCreatedByStaff();
		this.dailyCareCPPTsCreatedByStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsCreatedByStaff.forEach(dailyCareCPPTsCreatedByStaffEntity -> dailyCareCPPTsCreatedByStaffEntity.setCreatedByStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsCreatedByStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsCreatedByStaff() {
		this.unsetDailyCareCPPTsCreatedByStaff(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Created By Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsCreatedByStaff(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsCreatedByStaff.forEach(dailyCareCPPTsCreatedByStaffEntity -> dailyCareCPPTsCreatedByStaffEntity.unsetCreatedByStaff(false));
		}
		this.dailyCareCPPTsCreatedByStaff.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsDoctorInCharge(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsDoctorInCharge(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsDoctorInCharge in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsDoctorInCharge.contains(entity)) {
			dailyCareCPPTsDoctorInCharge.add(entity);
			if (reverseAdd) {
				entity.setDoctorInCharge(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Doctor in Charge in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsDoctorInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsDoctorInCharge(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NonNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsDoctorInCharge(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDoctorInCharge(false);
		}
		this.dailyCareCPPTsDoctorInCharge.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsDoctorInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsDoctorInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsDoctorInCharge(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Doctor in Charge with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsDoctorInCharge(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsDoctorInCharge();
		this.dailyCareCPPTsDoctorInCharge = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsDoctorInCharge.forEach(dailyCareCPPTsDoctorInChargeEntity -> dailyCareCPPTsDoctorInChargeEntity.setDoctorInCharge(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsDoctorInCharge(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsDoctorInCharge() {
		this.unsetDailyCareCPPTsDoctorInCharge(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Doctor in Charge from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsDoctorInCharge(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsDoctorInCharge.forEach(dailyCareCPPTsDoctorInChargeEntity -> dailyCareCPPTsDoctorInChargeEntity.unsetDoctorInCharge(false));
		}
		this.dailyCareCPPTsDoctorInCharge.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTsMedicalTranscriber(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTsMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTsMedicalTranscriber in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTsMedicalTranscriber.contains(entity)) {
			dailyCareCPPTsMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTsMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsMedicalTranscriber(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NonNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTsMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalTranscriber(false);
		}
		this.dailyCareCPPTsMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTsMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTsMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTsMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTsMedicalTranscriber(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTsMedicalTranscriber();
		this.dailyCareCPPTsMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTsMedicalTranscriber.forEach(dailyCareCPPTsMedicalTranscriberEntity -> dailyCareCPPTsMedicalTranscriberEntity.setMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTsMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTsMedicalTranscriber() {
		this.unsetDailyCareCPPTsMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTsMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTsMedicalTranscriber.forEach(dailyCareCPPTsMedicalTranscriberEntity -> dailyCareCPPTsMedicalTranscriberEntity.unsetMedicalTranscriber(false));
		}
		this.dailyCareCPPTsMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity) {
		addDeliveryProgresses(entity, true);
	}

	/**
	 * Add a new DeliveryProgressEntity to deliveryProgresses in this entity.
	 *
	 * @param entity the given DeliveryProgressEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverseAdd) {
		if (!this.deliveryProgresses.contains(entity)) {
			deliveryProgresses.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		addDeliveryProgresses(entities, true);
	}

	/**
	 * Add a new collection of DeliveryProgressEntity to Delivery Progresses in this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be set to this entity
	 */
	public void removeDeliveryProgresses(@NonNull DeliveryProgressEntity entity) {
		this.removeDeliveryProgresses(entity, true);
	}

	/**
	 * Remove the given DeliveryProgressEntity from this entity.
	 *
	 * @param entity the given DeliveryProgressEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.deliveryProgresses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		this.removeDeliveryProgresses(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryProgressEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be set to this entity
	 */
	public void setDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		setDeliveryProgresses(entities, true);
	}

	/**
	 * Replace the current entities in Delivery Progresses with the given ones.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {

		this.unsetDeliveryProgresses();
		this.deliveryProgresses = new HashSet<>(entities);
		if (reverseAdd) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDeliveryProgresses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDeliveryProgresses() {
		this.unsetDeliveryProgresses(true);
	}

	/**
	 * Remove all the entities in Delivery Progresses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDeliveryProgresses(boolean doReverse) {
		if (doReverse) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.unsetStaff(false));
		}
		this.deliveryProgresses.clear();
	}

/**
	 * Similar to {@link this#addDiagnosticStaffExaminationSummaries(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull DiagnosticStaffExaminationSummaryEntity entity) {
		addDiagnosticStaffExaminationSummaries(entity, true);
	}

	/**
	 * Add a new DiagnosticStaffExaminationSummaryEntity to diagnosticStaffExaminationSummaries in this entity.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverseAdd) {
		if (!this.diagnosticStaffExaminationSummaries.contains(entity)) {
			diagnosticStaffExaminationSummaries.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		addDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Add a new collection of DiagnosticStaffExaminationSummaryEntity to Diagnostic Staff Examination Summaries in this entity.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosticStaffExaminationSummaries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosticStaffExaminationSummaries(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NonNull DiagnosticStaffExaminationSummaryEntity entity) {
		this.removeDiagnosticStaffExaminationSummaries(entity, true);
	}

	/**
	 * Remove the given DiagnosticStaffExaminationSummaryEntity from this entity.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NonNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.diagnosticStaffExaminationSummaries.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be removed to this entity
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		this.removeDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosticStaffExaminationSummaryEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosticStaffExaminationSummaries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosticStaffExaminationSummaries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void setDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities) {
		setDiagnosticStaffExaminationSummaries(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Staff Examination Summaries with the given ones.
	 *
	 * @param entities the given collection of DiagnosticStaffExaminationSummaryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticStaffExaminationSummaries(@NonNull Collection<DiagnosticStaffExaminationSummaryEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosticStaffExaminationSummaries();
		this.diagnosticStaffExaminationSummaries = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosticStaffExaminationSummaries.forEach(diagnosticStaffExaminationSummariesEntity -> diagnosticStaffExaminationSummariesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosticStaffExaminationSummaries(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosticStaffExaminationSummaries() {
		this.unsetDiagnosticStaffExaminationSummaries(true);
	}

	/**
	 * Remove all the entities in Diagnostic Staff Examination Summaries from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosticStaffExaminationSummaries(boolean doReverse) {
		if (doReverse) {
			this.diagnosticStaffExaminationSummaries.forEach(diagnosticStaffExaminationSummariesEntity -> diagnosticStaffExaminationSummariesEntity.unsetStaff(false));
		}
		this.diagnosticStaffExaminationSummaries.clear();
	}

/**
	 * Similar to {@link this#addDismissalReferringStaff(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringStaff(@NonNull RegistrationEntity entity) {
		addDismissalReferringStaff(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to dismissalReferringStaff in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDismissalReferringStaff(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.dismissalReferringStaff.contains(entity)) {
			dismissalReferringStaff.add(entity);
			if (reverseAdd) {
				entity.setDismissalReferringStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities) {
		addDismissalReferringStaff(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Dismissal Referring Staff in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDismissalReferringStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDismissalReferringStaff(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeDismissalReferringStaff(@NonNull RegistrationEntity entity) {
		this.removeDismissalReferringStaff(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDismissalReferringStaff(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDismissalReferringStaff(false);
		}
		this.dismissalReferringStaff.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities) {
		this.removeDismissalReferringStaff(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDismissalReferringStaff(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDismissalReferringStaff(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities) {
		setDismissalReferringStaff(entities, true);
	}

	/**
	 * Replace the current entities in Dismissal Referring Staff with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDismissalReferringStaff(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetDismissalReferringStaff();
		this.dismissalReferringStaff = new HashSet<>(entities);
		if (reverseAdd) {
			this.dismissalReferringStaff.forEach(dismissalReferringStaffEntity -> dismissalReferringStaffEntity.setDismissalReferringStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringStaff(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDismissalReferringStaff() {
		this.unsetDismissalReferringStaff(true);
	}

	/**
	 * Remove all the entities in Dismissal Referring Staff from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDismissalReferringStaff(boolean doReverse) {
		if (doReverse) {
			this.dismissalReferringStaff.forEach(dismissalReferringStaffEntity -> dismissalReferringStaffEntity.unsetDismissalReferringStaff(false));
		}
		this.dismissalReferringStaff.clear();
	}

/**
	 * Similar to {@link this#addDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NonNull DoctorScheduleEntity entity) {
		addDoctorSchedules(entity, true);
	}

	/**
	 * Add a new DoctorScheduleEntity to doctorSchedules in this entity.
	 *
	 * @param entity the given DoctorScheduleEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDoctorSchedules(@NonNull DoctorScheduleEntity entity, boolean reverseAdd) {
		if (!this.doctorSchedules.contains(entity)) {
			doctorSchedules.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 */
	public void addDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		addDoctorSchedules(entities, true);
	}

	/**
	 * Add a new collection of DoctorScheduleEntity to Doctor Schedules in this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(DoctorScheduleEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorScheduleEntity to be set to this entity
	 */
	public void removeDoctorSchedules(@NonNull DoctorScheduleEntity entity) {
		this.removeDoctorSchedules(entity, true);
	}

	/**
	 * Remove the given DoctorScheduleEntity from this entity.
	 *
	 * @param entity the given DoctorScheduleEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorSchedules(@NonNull DoctorScheduleEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.doctorSchedules.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 */
	public void removeDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		this.removeDoctorSchedules(entities, true);
	}

	/**
	 * Remove the given collection of DoctorScheduleEntity from  to this entity.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDoctorSchedules(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDoctorSchedules(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to be set to this entity
	 */
	public void setDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities) {
		setDoctorSchedules(entities, true);
	}

	/**
	 * Replace the current entities in Doctor Schedules with the given ones.
	 *
	 * @param entities the given collection of DoctorScheduleEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorSchedules(@NonNull Collection<DoctorScheduleEntity> entities, boolean reverseAdd) {

		this.unsetDoctorSchedules();
		this.doctorSchedules = new HashSet<>(entities);
		if (reverseAdd) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDoctorSchedules(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDoctorSchedules() {
		this.unsetDoctorSchedules(true);
	}

	/**
	 * Remove all the entities in Doctor Schedules from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDoctorSchedules(boolean doReverse) {
		if (doReverse) {
			this.doctorSchedules.forEach(doctorSchedulesEntity -> doctorSchedulesEntity.unsetStaff(false));
		}
		this.doctorSchedules.clear();
	}

/**
	 * Similar to {@link this#addDoctorOnExamination(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addDoctorOnExamination(@NonNull MedicalExaminationRecordEntity entity) {
		addDoctorOnExamination(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to doctorOnExamination in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDoctorOnExamination(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.doctorOnExamination.contains(entity)) {
			doctorOnExamination.add(entity);
			if (reverseAdd) {
				entity.setDoctor(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		addDoctorOnExamination(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Doctor on examination in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDoctorOnExamination(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDoctorOnExamination(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeDoctorOnExamination(@NonNull MedicalExaminationRecordEntity entity) {
		this.removeDoctorOnExamination(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDoctorOnExamination(@NonNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDoctor(false);
		}
		this.doctorOnExamination.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeDoctorOnExamination(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDoctorOnExamination(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDoctorOnExamination(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		setDoctorOnExamination(entities, true);
	}

	/**
	 * Replace the current entities in Doctor on examination with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDoctorOnExamination(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetDoctorOnExamination();
		this.doctorOnExamination = new HashSet<>(entities);
		if (reverseAdd) {
			this.doctorOnExamination.forEach(doctorOnExaminationEntity -> doctorOnExaminationEntity.setDoctor(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDoctorOnExamination(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDoctorOnExamination() {
		this.unsetDoctorOnExamination(true);
	}

	/**
	 * Remove all the entities in Doctor on examination from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDoctorOnExamination(boolean doReverse) {
		if (doReverse) {
			this.doctorOnExamination.forEach(doctorOnExaminationEntity -> doctorOnExaminationEntity.unsetDoctor(false));
		}
		this.doctorOnExamination.clear();
	}

/**
	 * Similar to {@link this#addFluidBalanceDetails(FluidBalanceDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be added to this entity
	 */
	public void addFluidBalanceDetails(@NonNull FluidBalanceDetailEntity entity) {
		addFluidBalanceDetails(entity, true);
	}

	/**
	 * Add a new FluidBalanceDetailEntity to fluidBalanceDetails in this entity.
	 *
	 * @param entity the given FluidBalanceDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addFluidBalanceDetails(@NonNull FluidBalanceDetailEntity entity, boolean reverseAdd) {
		if (!this.fluidBalanceDetails.contains(entity)) {
			fluidBalanceDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be added to this entity
	 */
	public void addFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities) {
		addFluidBalanceDetails(entities, true);
	}

	/**
	 * Add a new collection of FluidBalanceDetailEntity to Fluid Balance Details in this entity.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addFluidBalanceDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeFluidBalanceDetails(FluidBalanceDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be set to this entity
	 */
	public void removeFluidBalanceDetails(@NonNull FluidBalanceDetailEntity entity) {
		this.removeFluidBalanceDetails(entity, true);
	}

	/**
	 * Remove the given FluidBalanceDetailEntity from this entity.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeFluidBalanceDetails(@NonNull FluidBalanceDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.fluidBalanceDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be removed to this entity
	 */
	public void removeFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities) {
		this.removeFluidBalanceDetails(entities, true);
	}

	/**
	 * Remove the given collection of FluidBalanceDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeFluidBalanceDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setFluidBalanceDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to be set to this entity
	 */
	public void setFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities) {
		setFluidBalanceDetails(entities, true);
	}

	/**
	 * Replace the current entities in Fluid Balance Details with the given ones.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setFluidBalanceDetails(@NonNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {

		this.unsetFluidBalanceDetails();
		this.fluidBalanceDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetFluidBalanceDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetFluidBalanceDetails() {
		this.unsetFluidBalanceDetails(true);
	}

	/**
	 * Remove all the entities in Fluid Balance Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetFluidBalanceDetails(boolean doReverse) {
		if (doReverse) {
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.unsetStaff(false));
		}
		this.fluidBalanceDetails.clear();
	}

/**
	 * Similar to {@link this#addHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity) {
		addHemodialysisMonitorings(entity, true);
	}

	/**
	 * Add a new HemodialysisMonitoringEntity to hemodialysisMonitorings in this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverseAdd) {
		if (!this.hemodialysisMonitorings.contains(entity)) {
			hemodialysisMonitorings.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		addHemodialysisMonitorings(entities, true);
	}

	/**
	 * Add a new collection of HemodialysisMonitoringEntity to Hemodialysis Monitorings in this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be set to this entity
	 */
	public void removeHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity) {
		this.removeHemodialysisMonitorings(entity, true);
	}

	/**
	 * Remove the given HemodialysisMonitoringEntity from this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.hemodialysisMonitorings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		this.removeHemodialysisMonitorings(entities, true);
	}

	/**
	 * Remove the given collection of HemodialysisMonitoringEntity from  to this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be set to this entity
	 */
	public void setHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		setHemodialysisMonitorings(entities, true);
	}

	/**
	 * Replace the current entities in Hemodialysis Monitorings with the given ones.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {

		this.unsetHemodialysisMonitorings();
		this.hemodialysisMonitorings = new HashSet<>(entities);
		if (reverseAdd) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHemodialysisMonitorings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHemodialysisMonitorings() {
		this.unsetHemodialysisMonitorings(true);
	}

	/**
	 * Remove all the entities in Hemodialysis Monitorings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHemodialysisMonitorings(boolean doReverse) {
		if (doReverse) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.unsetMedicalStaff(false));
		}
		this.hemodialysisMonitorings.clear();
	}

/**
	 * Similar to {@link this#addHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity) {
		addHospitalBranchInformations(entity, true);
	}

	/**
	 * Add a new HospitalBranchInformationEntity to hospitalBranchInformations in this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverseAdd) {
		if (!this.hospitalBranchInformations.contains(entity)) {
			hospitalBranchInformations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		addHospitalBranchInformations(entities, true);
	}

	/**
	 * Add a new collection of HospitalBranchInformationEntity to Hospital Branch Informations in this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be set to this entity
	 */
	public void removeHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity) {
		this.removeHospitalBranchInformations(entity, true);
	}

	/**
	 * Remove the given HospitalBranchInformationEntity from this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.hospitalBranchInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		this.removeHospitalBranchInformations(entities, true);
	}

	/**
	 * Remove the given collection of HospitalBranchInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be set to this entity
	 */
	public void setHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities) {
		setHospitalBranchInformations(entities, true);
	}

	/**
	 * Replace the current entities in Hospital Branch Informations with the given ones.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {

		this.unsetHospitalBranchInformations();
		this.hospitalBranchInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHospitalBranchInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHospitalBranchInformations() {
		this.unsetHospitalBranchInformations(true);
	}

	/**
	 * Remove all the entities in Hospital Branch Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHospitalBranchInformations(boolean doReverse) {
		if (doReverse) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.unsetStaff(false));
		}
		this.hospitalBranchInformations.clear();
	}

/**
	 * Similar to {@link this#addInformingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addInformingConsents(@NonNull InformedConsentEntity entity) {
		addInformingConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to informingConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInformingConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.informingConsents.contains(entity)) {
			informingConsents.add(entity);
			if (reverseAdd) {
				entity.setInformingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInformingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addInformingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		addInformingConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Informing Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInformingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInformingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInformingConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeInformingConsents(@NonNull InformedConsentEntity entity) {
		this.removeInformingConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformingConsents(@NonNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInformingStaff(false);
		}
		this.informingConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInformingConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeInformingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		this.removeInformingConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInformingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInformingConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInformingConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setInformingConsents(@NonNull Collection<InformedConsentEntity> entities) {
		setInformingConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informing Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformingConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetInformingConsents();
		this.informingConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.informingConsents.forEach(informingConsentsEntity -> informingConsentsEntity.setInformingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInformingConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInformingConsents() {
		this.unsetInformingConsents(true);
	}

	/**
	 * Remove all the entities in Informing Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInformingConsents(boolean doReverse) {
		if (doReverse) {
			this.informingConsents.forEach(informingConsentsEntity -> informingConsentsEntity.unsetInformingStaff(false));
		}
		this.informingConsents.clear();
	}

/**
	 * Similar to {@link this#addInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity) {
		addInvoices(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoices in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoices.contains(entity)) {
			invoices.add(entity);
			if (reverseAdd) {
				entity.setVerifiedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities) {
		addInvoices(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoices(@NonNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NonNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetVerifiedBy(false);
		}
		this.invoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities) {
		this.removeInvoices(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoices();
		this.invoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setVerifiedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoices() {
		this.unsetInvoices(true);
	}

	/**
	 * Remove all the entities in Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoices(boolean doReverse) {
		if (doReverse) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetVerifiedBy(false));
		}
		this.invoices.clear();
	}

/**
	 * Similar to {@link this#addMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		addMcuPackageItems(entity, true);
	}

	/**
	 * Add a new McuPackageItemEntity to mcuPackageItems in this entity.
	 *
	 * @param entity the given McuPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverseAdd) {
		if (!this.mcuPackageItems.contains(entity)) {
			mcuPackageItems.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		addMcuPackageItems(entities, true);
	}

	/**
	 * Add a new collection of McuPackageItemEntity to MCU Package Items in this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be set to this entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		this.removeMcuPackageItems(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.mcuPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		this.removeMcuPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of McuPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be set to this entity
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		setMcuPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in MCU Package Items with the given ones.
	 *
	 * @param entities the given collection of McuPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetMcuPackageItems();
		this.mcuPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMcuPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMcuPackageItems() {
		this.unsetMcuPackageItems(true);
	}

	/**
	 * Remove all the entities in MCU Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMcuPackageItems(boolean doReverse) {
		if (doReverse) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.unsetStaff(false));
		}
		this.mcuPackageItems.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateDischargeResumes(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		addMedicalCertificateDischargeResumes(entity, true);
	}

	/**
	 * Add a new MedicalCertificateDischargeResumeEntity to medicalCertificateDischargeResumes in this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateDischargeResumes.contains(entity)) {
			medicalCertificateDischargeResumes.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		addMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateDischargeResumeEntity to Medical Certificate  Discharge Resumes in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateDischargeResumes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateDischargeResumes(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		this.removeMedicalCertificateDischargeResumes(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateDischargeResumeEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateDischargeResumes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 */
	public void removeMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		this.removeMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateDischargeResumeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateDischargeResumes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateDischargeResumes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void setMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		setMedicalCertificateDischargeResumes(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate  Discharge Resumes with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateDischargeResumes(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateDischargeResumes();
		this.medicalCertificateDischargeResumes = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateDischargeResumes.forEach(medicalCertificateDischargeResumesEntity -> medicalCertificateDischargeResumesEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateDischargeResumes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateDischargeResumes() {
		this.unsetMedicalCertificateDischargeResumes(true);
	}

	/**
	 * Remove all the entities in Medical Certificate  Discharge Resumes from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateDischargeResumes(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateDischargeResumes.forEach(medicalCertificateDischargeResumesEntity -> medicalCertificateDischargeResumesEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateDischargeResumes.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateBirths(MedicalCertificateBirthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be added to this entity
	 */
	public void addMedicalCertificateBirths(@NonNull MedicalCertificateBirthEntity entity) {
		addMedicalCertificateBirths(entity, true);
	}

	/**
	 * Add a new MedicalCertificateBirthEntity to medicalCertificateBirths in this entity.
	 *
	 * @param entity the given MedicalCertificateBirthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateBirths(@NonNull MedicalCertificateBirthEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateBirths.contains(entity)) {
			medicalCertificateBirths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be added to this entity
	 */
	public void addMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities) {
		addMedicalCertificateBirths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateBirthEntity to Medical Certificate Births in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateBirths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateBirths(MedicalCertificateBirthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be set to this entity
	 */
	public void removeMedicalCertificateBirths(@NonNull MedicalCertificateBirthEntity entity) {
		this.removeMedicalCertificateBirths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateBirthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateBirthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateBirths(@NonNull MedicalCertificateBirthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateBirths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be removed to this entity
	 */
	public void removeMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities) {
		this.removeMedicalCertificateBirths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateBirthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateBirths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateBirths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to be set to this entity
	 */
	public void setMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities) {
		setMedicalCertificateBirths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate Births with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateBirthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateBirths(@NonNull Collection<MedicalCertificateBirthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateBirths();
		this.medicalCertificateBirths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateBirths.forEach(medicalCertificateBirthsEntity -> medicalCertificateBirthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateBirths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateBirths() {
		this.unsetMedicalCertificateBirths(true);
	}

	/**
	 * Remove all the entities in Medical Certificate Births from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateBirths(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateBirths.forEach(medicalCertificateBirthsEntity -> medicalCertificateBirthsEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateBirths.clear();
	}

/**
	 * Similar to {@link this#addMedicalCertificateHospitalizations(MedicalCertificateHospitalizationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be added to this entity
	 */
	public void addMedicalCertificateHospitalizations(@NonNull MedicalCertificateHospitalizationEntity entity) {
		addMedicalCertificateHospitalizations(entity, true);
	}

	/**
	 * Add a new MedicalCertificateHospitalizationEntity to medicalCertificateHospitalizations in this entity.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalCertificateHospitalizations(@NonNull MedicalCertificateHospitalizationEntity entity, boolean reverseAdd) {
		if (!this.medicalCertificateHospitalizations.contains(entity)) {
			medicalCertificateHospitalizations.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be added to this entity
	 */
	public void addMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		addMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateHospitalizationEntity to Medical Certificate Hospitalizations in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalCertificateHospitalizations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateHospitalizations(MedicalCertificateHospitalizationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be set to this entity
	 */
	public void removeMedicalCertificateHospitalizations(@NonNull MedicalCertificateHospitalizationEntity entity) {
		this.removeMedicalCertificateHospitalizations(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateHospitalizationEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateHospitalizationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalCertificateHospitalizations(@NonNull MedicalCertificateHospitalizationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalCertificateHospitalizations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be removed to this entity
	 */
	public void removeMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		this.removeMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateHospitalizationEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalCertificateHospitalizations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalCertificateHospitalizations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to be set to this entity
	 */
	public void setMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities) {
		setMedicalCertificateHospitalizations(entities, true);
	}

	/**
	 * Replace the current entities in Medical Certificate Hospitalizations with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateHospitalizationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalCertificateHospitalizations(@NonNull Collection<MedicalCertificateHospitalizationEntity> entities, boolean reverseAdd) {

		this.unsetMedicalCertificateHospitalizations();
		this.medicalCertificateHospitalizations = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalCertificateHospitalizations.forEach(medicalCertificateHospitalizationsEntity -> medicalCertificateHospitalizationsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateHospitalizations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalCertificateHospitalizations() {
		this.unsetMedicalCertificateHospitalizations(true);
	}

	/**
	 * Remove all the entities in Medical Certificate Hospitalizations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalCertificateHospitalizations(boolean doReverse) {
		if (doReverse) {
			this.medicalCertificateHospitalizations.forEach(medicalCertificateHospitalizationsEntity -> medicalCertificateHospitalizationsEntity.unsetMedicalStaff(false));
		}
		this.medicalCertificateHospitalizations.clear();
	}

/**
	 * Similar to {@link this#addMedicalExaminationRecordDischargeSummarys(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		addMedicalExaminationRecordDischargeSummarys(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordDischargeSummaryEntity to medicalExaminationRecordDischargeSummarys in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		if (!this.medicalExaminationRecordDischargeSummarys.contains(entity)) {
			medicalExaminationRecordDischargeSummarys.add(entity);
			if (reverseAdd) {
				entity.setDischargingDoctor(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		addMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordDischargeSummaryEntity to Medical Examination Record Discharge Summarys in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalExaminationRecordDischargeSummarys(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalExaminationRecordDischargeSummarys(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		this.removeMedicalExaminationRecordDischargeSummarys(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordDischargeSummaryEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDischargingDoctor(false);
		}
		this.medicalExaminationRecordDischargeSummarys.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be removed to this entity
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		this.removeMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordDischargeSummaryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalExaminationRecordDischargeSummarys(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummarys(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities) {
		setMedicalExaminationRecordDischargeSummarys(entities, true);
	}

	/**
	 * Replace the current entities in Medical Examination Record Discharge Summarys with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordDischargeSummaryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalExaminationRecordDischargeSummarys(@NonNull Collection<MedicalExaminationRecordDischargeSummaryEntity> entities, boolean reverseAdd) {

		this.unsetMedicalExaminationRecordDischargeSummarys();
		this.medicalExaminationRecordDischargeSummarys = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummarys.forEach(medicalExaminationRecordDischargeSummarysEntity -> medicalExaminationRecordDischargeSummarysEntity.setDischargingDoctor(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummarys(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalExaminationRecordDischargeSummarys() {
		this.unsetMedicalExaminationRecordDischargeSummarys(true);
	}

	/**
	 * Remove all the entities in Medical Examination Record Discharge Summarys from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalExaminationRecordDischargeSummarys(boolean doReverse) {
		if (doReverse) {
			this.medicalExaminationRecordDischargeSummarys.forEach(medicalExaminationRecordDischargeSummarysEntity -> medicalExaminationRecordDischargeSummarysEntity.unsetDischargingDoctor(false));
		}
		this.medicalExaminationRecordDischargeSummarys.clear();
	}

/**
	 * Similar to {@link this#addMedicalRecordTranscriber(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMedicalRecordTranscriber(@NonNull MedicalExaminationRecordEntity entity) {
		addMedicalRecordTranscriber(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to medicalRecordTranscriber in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalRecordTranscriber(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.medicalRecordTranscriber.contains(entity)) {
			medicalRecordTranscriber.add(entity);
			if (reverseAdd) {
				entity.setMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		addMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Medical Record Transcriber in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalRecordTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalRecordTranscriber(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeMedicalRecordTranscriber(@NonNull MedicalExaminationRecordEntity entity) {
		this.removeMedicalRecordTranscriber(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalRecordTranscriber(@NonNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalTranscriber(false);
		}
		this.medicalRecordTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalRecordTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalRecordTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		setMedicalRecordTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Medical Record Transcriber with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalRecordTranscriber(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetMedicalRecordTranscriber();
		this.medicalRecordTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalRecordTranscriber.forEach(medicalRecordTranscriberEntity -> medicalRecordTranscriberEntity.setMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalRecordTranscriber() {
		this.unsetMedicalRecordTranscriber(true);
	}

	/**
	 * Remove all the entities in Medical Record Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalRecordTranscriber(boolean doReverse) {
		if (doReverse) {
			this.medicalRecordTranscriber.forEach(medicalRecordTranscriberEntity -> medicalRecordTranscriberEntity.unsetMedicalTranscriber(false));
		}
		this.medicalRecordTranscriber.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfMedicalAttendancesCertificate(MedicalCertificateMedicalAttendanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull MedicalCertificateMedicalAttendanceEntity entity) {
		addMedicalStaffOfMedicalAttendancesCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateMedicalAttendanceEntity to medicalStaffOfMedicalAttendancesCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfMedicalAttendancesCertificate.contains(entity)) {
			medicalStaffOfMedicalAttendancesCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		addMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateMedicalAttendanceEntity to Medical Staff of Medical Attendances certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfMedicalAttendancesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMedicalAttendancesCertificate(MedicalCertificateMedicalAttendanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be set to this entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NonNull MedicalCertificateMedicalAttendanceEntity entity) {
		this.removeMedicalStaffOfMedicalAttendancesCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateMedicalAttendanceEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateMedicalAttendanceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NonNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfMedicalAttendancesCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		this.removeMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateMedicalAttendanceEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfMedicalAttendancesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfMedicalAttendancesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to be set to this entity
	 */
	public void setMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities) {
		setMedicalStaffOfMedicalAttendancesCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Medical Attendances certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateMedicalAttendanceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfMedicalAttendancesCertificate(@NonNull Collection<MedicalCertificateMedicalAttendanceEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfMedicalAttendancesCertificate();
		this.medicalStaffOfMedicalAttendancesCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfMedicalAttendancesCertificate.forEach(medicalStaffOfMedicalAttendancesCertificateEntity -> medicalStaffOfMedicalAttendancesCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfMedicalAttendancesCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfMedicalAttendancesCertificate() {
		this.unsetMedicalStaffOfMedicalAttendancesCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Medical Attendances certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfMedicalAttendancesCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfMedicalAttendancesCertificate.forEach(medicalStaffOfMedicalAttendancesCertificateEntity -> medicalStaffOfMedicalAttendancesCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfMedicalAttendancesCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfMentalHealths(MedicalCertificateMentalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull MedicalCertificateMentalHealthEntity entity) {
		addMedicalStaffOfMentalHealths(entity, true);
	}

	/**
	 * Add a new MedicalCertificateMentalHealthEntity to medicalStaffOfMentalHealths in this entity.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull MedicalCertificateMentalHealthEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfMentalHealths.contains(entity)) {
			medicalStaffOfMentalHealths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		addMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateMentalHealthEntity to Medical Staff of Mental Healths in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfMentalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMentalHealths(MedicalCertificateMentalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be set to this entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NonNull MedicalCertificateMentalHealthEntity entity) {
		this.removeMedicalStaffOfMentalHealths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateMentalHealthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateMentalHealthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NonNull MedicalCertificateMentalHealthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfMentalHealths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		this.removeMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateMentalHealthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfMentalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfMentalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to be set to this entity
	 */
	public void setMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities) {
		setMedicalStaffOfMentalHealths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Mental Healths with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateMentalHealthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfMentalHealths(@NonNull Collection<MedicalCertificateMentalHealthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfMentalHealths();
		this.medicalStaffOfMentalHealths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfMentalHealths.forEach(medicalStaffOfMentalHealthsEntity -> medicalStaffOfMentalHealthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfMentalHealths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfMentalHealths() {
		this.unsetMedicalStaffOfMentalHealths(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Mental Healths from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfMentalHealths(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfMentalHealths.forEach(medicalStaffOfMentalHealthsEntity -> medicalStaffOfMentalHealthsEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfMentalHealths.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfPhysicalHealths(MedicalCertificatePhysicalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull MedicalCertificatePhysicalHealthEntity entity) {
		addMedicalStaffOfPhysicalHealths(entity, true);
	}

	/**
	 * Add a new MedicalCertificatePhysicalHealthEntity to medicalStaffOfPhysicalHealths in this entity.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull MedicalCertificatePhysicalHealthEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfPhysicalHealths.contains(entity)) {
			medicalStaffOfPhysicalHealths.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be added to this entity
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		addMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificatePhysicalHealthEntity to Medical Staff of Physical Healths in this entity.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfPhysicalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfPhysicalHealths(MedicalCertificatePhysicalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be set to this entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NonNull MedicalCertificatePhysicalHealthEntity entity) {
		this.removeMedicalStaffOfPhysicalHealths(entity, true);
	}

	/**
	 * Remove the given MedicalCertificatePhysicalHealthEntity from this entity.
	 *
	 * @param entity the given MedicalCertificatePhysicalHealthEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NonNull MedicalCertificatePhysicalHealthEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfPhysicalHealths.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		this.removeMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificatePhysicalHealthEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfPhysicalHealths(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfPhysicalHealths(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to be set to this entity
	 */
	public void setMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities) {
		setMedicalStaffOfPhysicalHealths(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Physical Healths with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificatePhysicalHealthEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfPhysicalHealths(@NonNull Collection<MedicalCertificatePhysicalHealthEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfPhysicalHealths();
		this.medicalStaffOfPhysicalHealths = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfPhysicalHealths.forEach(medicalStaffOfPhysicalHealthsEntity -> medicalStaffOfPhysicalHealthsEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfPhysicalHealths(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfPhysicalHealths() {
		this.unsetMedicalStaffOfPhysicalHealths(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Physical Healths from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfPhysicalHealths(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfPhysicalHealths.forEach(medicalStaffOfPhysicalHealthsEntity -> medicalStaffOfPhysicalHealthsEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfPhysicalHealths.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfRestrictedWorksCertificate(MedicalCertificateRestrictedWorkEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be added to this entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull MedicalCertificateRestrictedWorkEntity entity) {
		addMedicalStaffOfRestrictedWorksCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateRestrictedWorkEntity to medicalStaffOfRestrictedWorksCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull MedicalCertificateRestrictedWorkEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfRestrictedWorksCertificate.contains(entity)) {
			medicalStaffOfRestrictedWorksCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be added to this entity
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		addMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateRestrictedWorkEntity to Medical Staff of Restricted Works certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfRestrictedWorksCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfRestrictedWorksCertificate(MedicalCertificateRestrictedWorkEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be set to this entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NonNull MedicalCertificateRestrictedWorkEntity entity) {
		this.removeMedicalStaffOfRestrictedWorksCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateRestrictedWorkEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateRestrictedWorkEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NonNull MedicalCertificateRestrictedWorkEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfRestrictedWorksCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		this.removeMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateRestrictedWorkEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfRestrictedWorksCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfRestrictedWorksCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to be set to this entity
	 */
	public void setMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities) {
		setMedicalStaffOfRestrictedWorksCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Restricted Works certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateRestrictedWorkEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfRestrictedWorksCertificate(@NonNull Collection<MedicalCertificateRestrictedWorkEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfRestrictedWorksCertificate();
		this.medicalStaffOfRestrictedWorksCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfRestrictedWorksCertificate.forEach(medicalStaffOfRestrictedWorksCertificateEntity -> medicalStaffOfRestrictedWorksCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfRestrictedWorksCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfRestrictedWorksCertificate() {
		this.unsetMedicalStaffOfRestrictedWorksCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Restricted Works certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfRestrictedWorksCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfRestrictedWorksCertificate.forEach(medicalStaffOfRestrictedWorksCertificateEntity -> medicalStaffOfRestrictedWorksCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfRestrictedWorksCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicalStaffOfSickLeavesCertificate(MedicalCertificateSickLeaveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be added to this entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull MedicalCertificateSickLeaveEntity entity) {
		addMedicalStaffOfSickLeavesCertificate(entity, true);
	}

	/**
	 * Add a new MedicalCertificateSickLeaveEntity to medicalStaffOfSickLeavesCertificate in this entity.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull MedicalCertificateSickLeaveEntity entity, boolean reverseAdd) {
		if (!this.medicalStaffOfSickLeavesCertificate.contains(entity)) {
			medicalStaffOfSickLeavesCertificate.add(entity);
			if (reverseAdd) {
				entity.setMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be added to this entity
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		addMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateSickLeaveEntity to Medical Staff of Sick Leaves certificate in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalStaffOfSickLeavesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfSickLeavesCertificate(MedicalCertificateSickLeaveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be set to this entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NonNull MedicalCertificateSickLeaveEntity entity) {
		this.removeMedicalStaffOfSickLeavesCertificate(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateSickLeaveEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateSickLeaveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NonNull MedicalCertificateSickLeaveEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalStaff(false);
		}
		this.medicalStaffOfSickLeavesCertificate.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be removed to this entity
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		this.removeMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateSickLeaveEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalStaffOfSickLeavesCertificate(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalStaffOfSickLeavesCertificate(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to be set to this entity
	 */
	public void setMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities) {
		setMedicalStaffOfSickLeavesCertificate(entities, true);
	}

	/**
	 * Replace the current entities in Medical Staff of Sick Leaves certificate with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateSickLeaveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalStaffOfSickLeavesCertificate(@NonNull Collection<MedicalCertificateSickLeaveEntity> entities, boolean reverseAdd) {

		this.unsetMedicalStaffOfSickLeavesCertificate();
		this.medicalStaffOfSickLeavesCertificate = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalStaffOfSickLeavesCertificate.forEach(medicalStaffOfSickLeavesCertificateEntity -> medicalStaffOfSickLeavesCertificateEntity.setMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalStaffOfSickLeavesCertificate(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalStaffOfSickLeavesCertificate() {
		this.unsetMedicalStaffOfSickLeavesCertificate(true);
	}

	/**
	 * Remove all the entities in Medical Staff of Sick Leaves certificate from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalStaffOfSickLeavesCertificate(boolean doReverse) {
		if (doReverse) {
			this.medicalStaffOfSickLeavesCertificate.forEach(medicalStaffOfSickLeavesCertificateEntity -> medicalStaffOfSickLeavesCertificateEntity.unsetMedicalStaff(false));
		}
		this.medicalStaffOfSickLeavesCertificate.clear();
	}

/**
	 * Similar to {@link this#addMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity) {
		addMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Add a new MedicationAdministeredHistoryEntity to medicationAdministeredHisotries in this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverseAdd) {
		if (!this.medicationAdministeredHisotries.contains(entity)) {
			medicationAdministeredHisotries.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		addMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Add a new collection of MedicationAdministeredHistoryEntity to Medication Administered Hisotries in this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.medicationAdministeredHisotries.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		this.removeMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Remove the given collection of MedicationAdministeredHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void setMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Hisotries with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

		this.unsetMedicationAdministeredHisotries();
		this.medicationAdministeredHisotries = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationAdministeredHisotries(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationAdministeredHisotries() {
		this.unsetMedicationAdministeredHisotries(true);
	}

	/**
	 * Remove all the entities in Medication Administered Hisotries from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationAdministeredHisotries(boolean doReverse) {
		if (doReverse) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.unsetStaff(false));
		}
		this.medicationAdministeredHisotries.clear();
	}

/**
	 * Similar to {@link this#addMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NonNull MedicationHeaderEntity entity) {
		addMedicationHeaders(entity, true);
	}

	/**
	 * Add a new MedicationHeaderEntity to medicationHeaders in this entity.
	 *
	 * @param entity the given MedicationHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationHeaders(@NonNull MedicationHeaderEntity entity, boolean reverseAdd) {
		if (!this.medicationHeaders.contains(entity)) {
			medicationHeaders.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		addMedicationHeaders(entities, true);
	}

	/**
	 * Add a new collection of MedicationHeaderEntity to Medication Headers in this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void removeMedicationHeaders(@NonNull MedicationHeaderEntity entity) {
		this.removeMedicationHeaders(entity, true);
	}

	/**
	 * Remove the given MedicationHeaderEntity from this entity.
	 *
	 * @param entity the given MedicationHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationHeaders(@NonNull MedicationHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.medicationHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 */
	public void removeMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		this.removeMedicationHeaders(entities, true);
	}

	/**
	 * Remove the given collection of MedicationHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		setMedicationHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Medication Headers with the given ones.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {

		this.unsetMedicationHeaders();
		this.medicationHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationHeaders() {
		this.unsetMedicationHeaders(true);
	}

	/**
	 * Remove all the entities in Medication Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationHeaders(boolean doReverse) {
		if (doReverse) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.unsetRequestedBy(false));
		}
		this.medicationHeaders.clear();
	}

/**
	 * Similar to {@link this#addMidwives(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMidwives(@NonNull DeliveryMedicalExaminationRecordEntity entity) {
		addMidwives(entity, true);
	}

	/**
	 * Add a new DeliveryMedicalExaminationRecordEntity to midwives in this entity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMidwives(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.midwives.contains(entity)) {
			midwives.add(entity);
			if (reverseAdd) {
				entity.setMidwife(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		addMidwives(entities, true);
	}

	/**
	 * Add a new collection of DeliveryMedicalExaminationRecordEntity to Midwives in this entity.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMidwives(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeMidwives(@NonNull DeliveryMedicalExaminationRecordEntity entity) {
		this.removeMidwives(entity, true);
	}

	/**
	 * Remove the given DeliveryMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMidwives(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMidwife(false);
		}
		this.midwives.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMidwives(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		this.removeMidwives(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities) {
		setMidwives(entities, true);
	}

	/**
	 * Replace the current entities in Midwives with the given ones.
	 *
	 * @param entities the given collection of DeliveryMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMidwives(@NonNull Collection<DeliveryMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetMidwives();
		this.midwives = new HashSet<>(entities);
		if (reverseAdd) {
			this.midwives.forEach(midwivesEntity -> midwivesEntity.setMidwife(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMidwives(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMidwives() {
		this.unsetMidwives(true);
	}

	/**
	 * Remove all the entities in Midwives from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMidwives(boolean doReverse) {
		if (doReverse) {
			this.midwives.forEach(midwivesEntity -> midwivesEntity.unsetMidwife(false));
		}
		this.midwives.clear();
	}

/**
	 * Similar to {@link this#addNurse(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNurse(@NonNull MedicalExaminationRecordEntity entity) {
		addNurse(entity, true);
	}

	/**
	 * Add a new MedicalExaminationRecordEntity to nurse in this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNurse(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nurse.contains(entity)) {
			nurse.add(entity);
			if (reverseAdd) {
				entity.setNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		addNurse(entities, true);
	}

	/**
	 * Add a new collection of MedicalExaminationRecordEntity to Nurse in this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNurse(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNurse(@NonNull MedicalExaminationRecordEntity entity) {
		this.removeNurse(entity, true);
	}

	/**
	 * Remove the given MedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNurse(@NonNull MedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNurse(false);
		}
		this.nurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		this.removeNurse(entities, true);
	}

	/**
	 * Remove the given collection of MedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities) {
		setNurse(entities, true);
	}

	/**
	 * Replace the current entities in Nurse with the given ones.
	 *
	 * @param entities the given collection of MedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNurse(@NonNull Collection<MedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNurse();
		this.nurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.nurse.forEach(nurseEntity -> nurseEntity.setNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNurse() {
		this.unsetNurse(true);
	}

	/**
	 * Remove all the entities in Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNurse(boolean doReverse) {
		if (doReverse) {
			this.nurse.forEach(nurseEntity -> nurseEntity.unsetNurse(false));
		}
		this.nurse.clear();
	}

/**
	 * Similar to {@link this#addNursingDetailSurgicalNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailSurgicalNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingDetailSurgicalNursing(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingDetailSurgicalNursing in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingDetailSurgicalNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingDetailSurgicalNursing.contains(entity)) {
			nursingDetailSurgicalNursing.add(entity);
			if (reverseAdd) {
				entity.setNursingDetailSurgicalNursings(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Detail Surgical Nursing in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingDetailSurgicalNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingDetailSurgicalNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingDetailSurgicalNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingDetailSurgicalNursing(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingDetailSurgicalNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingDetailSurgicalNursings(false);
		}
		this.nursingDetailSurgicalNursing.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingDetailSurgicalNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingDetailSurgicalNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingDetailSurgicalNursing(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Detail Surgical Nursing with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingDetailSurgicalNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingDetailSurgicalNursing();
		this.nursingDetailSurgicalNursing = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingDetailSurgicalNursing.forEach(nursingDetailSurgicalNursingEntity -> nursingDetailSurgicalNursingEntity.setNursingDetailSurgicalNursings(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingDetailSurgicalNursing(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingDetailSurgicalNursing() {
		this.unsetNursingDetailSurgicalNursing(true);
	}

	/**
	 * Remove all the entities in Nursing Detail Surgical Nursing from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingDetailSurgicalNursing(boolean doReverse) {
		if (doReverse) {
			this.nursingDetailSurgicalNursing.forEach(nursingDetailSurgicalNursingEntity -> nursingDetailSurgicalNursingEntity.unsetNursingDetailSurgicalNursings(false));
		}
		this.nursingDetailSurgicalNursing.clear();
	}

/**
	 * Similar to {@link this#addNursingDetailsAnesthesiaNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		addNursingDetailsAnesthesiaNursing(entity, true);
	}

	/**
	 * Add a new OperatingTheaterMedicalExaminationRecordEntity to nursingDetailsAnesthesiaNursing in this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.nursingDetailsAnesthesiaNursing.contains(entity)) {
			nursingDetailsAnesthesiaNursing.add(entity);
			if (reverseAdd) {
				entity.setNursingDetailsAnesthesiaNursings(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		addNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Add a new collection of OperatingTheaterMedicalExaminationRecordEntity to Nursing Details Anesthesia Nursing in this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNursingDetailsAnesthesiaNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNursingDetailsAnesthesiaNursing(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		this.removeNursingDetailsAnesthesiaNursing(entity, true);
	}

	/**
	 * Remove the given OperatingTheaterMedicalExaminationRecordEntity from this entity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NonNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNursingDetailsAnesthesiaNursings(false);
		}
		this.nursingDetailsAnesthesiaNursing.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		this.removeNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Remove the given collection of OperatingTheaterMedicalExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNursingDetailsAnesthesiaNursing(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNursingDetailsAnesthesiaNursing(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities) {
		setNursingDetailsAnesthesiaNursing(entities, true);
	}

	/**
	 * Replace the current entities in Nursing Details Anesthesia Nursing with the given ones.
	 *
	 * @param entities the given collection of OperatingTheaterMedicalExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNursingDetailsAnesthesiaNursing(@NonNull Collection<OperatingTheaterMedicalExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetNursingDetailsAnesthesiaNursing();
		this.nursingDetailsAnesthesiaNursing = new HashSet<>(entities);
		if (reverseAdd) {
			this.nursingDetailsAnesthesiaNursing.forEach(nursingDetailsAnesthesiaNursingEntity -> nursingDetailsAnesthesiaNursingEntity.setNursingDetailsAnesthesiaNursings(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNursingDetailsAnesthesiaNursing(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNursingDetailsAnesthesiaNursing() {
		this.unsetNursingDetailsAnesthesiaNursing(true);
	}

	/**
	 * Remove all the entities in Nursing Details Anesthesia Nursing from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNursingDetailsAnesthesiaNursing(boolean doReverse) {
		if (doReverse) {
			this.nursingDetailsAnesthesiaNursing.forEach(nursingDetailsAnesthesiaNursingEntity -> nursingDetailsAnesthesiaNursingEntity.unsetNursingDetailsAnesthesiaNursings(false));
		}
		this.nursingDetailsAnesthesiaNursing.clear();
	}

	/**
	 * Similar to {@link this#setPcareDokter(PcareDokterEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setPcareDokter(@NonNull PcareDokterEntity entity) {
		setPcareDokter(entity, true);
	}

	/**
	 * Set or update pcareDokter with the given PcareDokterEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareDokter(@NonNull PcareDokterEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareDokter here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareDokter here] end

		if (sameAsFormer(this.pcareDokter, entity)) {
			return;
		}

		if (this.pcareDokter != null) {
			this.pcareDokter.unsetStaff();
		}

		this.pcareDokter = entity;

		if (reverseAdd) {
			this.pcareDokter.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareDokter outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareDokter outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPcareDokter(boolean)} but default to true.
	 */
	public void unsetPcareDokter() {
		this.unsetPcareDokter(true);
	}

	/**
	 * Remove the PcareDokterEntity in PCare Dokter from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareDokter(boolean reverse) {
		if (reverse && this.pcareDokter != null) {
			this.pcareDokter.unsetStaff(false);
		}
		this.pcareDokter = null;
	}

/**
	 * Similar to {@link this#addPatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity) {
		addPatientConsents(entity, true);
	}

	/**
	 * Add a new PatientConsentEntity to patientConsents in this entity.
	 *
	 * @param entity the given PatientConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientConsents(@NonNull PatientConsentEntity entity, boolean reverseAdd) {
		if (!this.patientConsents.contains(entity)) {
			patientConsents.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		addPatientConsents(entities, true);
	}

	/**
	 * Add a new collection of PatientConsentEntity to Patient Consents in this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientConsents(PatientConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientConsentEntity to be set to this entity
	 */
	public void removePatientConsents(@NonNull PatientConsentEntity entity) {
		this.removePatientConsents(entity, true);
	}

	/**
	 * Remove the given PatientConsentEntity from this entity.
	 *
	 * @param entity the given PatientConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientConsents(@NonNull PatientConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.patientConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		this.removePatientConsents(entities, true);
	}

	/**
	 * Remove the given collection of PatientConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientConsentEntity to be set to this entity
	 */
	public void setPatientConsents(@NonNull Collection<PatientConsentEntity> entities) {
		setPatientConsents(entities, true);
	}

	/**
	 * Replace the current entities in Patient Consents with the given ones.
	 *
	 * @param entities the given collection of PatientConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientConsents(@NonNull Collection<PatientConsentEntity> entities, boolean reverseAdd) {

		this.unsetPatientConsents();
		this.patientConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientConsents() {
		this.unsetPatientConsents(true);
	}

	/**
	 * Remove all the entities in Patient Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientConsents(boolean doReverse) {
		if (doReverse) {
			this.patientConsents.forEach(patientConsentsEntity -> patientConsentsEntity.unsetStaff(false));
		}
		this.patientConsents.clear();
	}

/**
	 * Similar to {@link this#addPatientVitalInformations(PatientVitalInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVitalInformationEntity to be added to this entity
	 */
	public void addPatientVitalInformations(@NonNull PatientVitalInformationEntity entity) {
		addPatientVitalInformations(entity, true);
	}

	/**
	 * Add a new PatientVitalInformationEntity to patientVitalInformations in this entity.
	 *
	 * @param entity the given PatientVitalInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientVitalInformations(@NonNull PatientVitalInformationEntity entity, boolean reverseAdd) {
		if (!this.patientVitalInformations.contains(entity)) {
			patientVitalInformations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be added to this entity
	 */
	public void addPatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities) {
		addPatientVitalInformations(entities, true);
	}

	/**
	 * Add a new collection of PatientVitalInformationEntity to Patient Vital Informations in this entity.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientVitalInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientVitalInformations(PatientVitalInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVitalInformationEntity to be set to this entity
	 */
	public void removePatientVitalInformations(@NonNull PatientVitalInformationEntity entity) {
		this.removePatientVitalInformations(entity, true);
	}

	/**
	 * Remove the given PatientVitalInformationEntity from this entity.
	 *
	 * @param entity the given PatientVitalInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientVitalInformations(@NonNull PatientVitalInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.patientVitalInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be removed to this entity
	 */
	public void removePatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities) {
		this.removePatientVitalInformations(entities, true);
	}

	/**
	 * Remove the given collection of PatientVitalInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientVitalInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientVitalInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to be set to this entity
	 */
	public void setPatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities) {
		setPatientVitalInformations(entities, true);
	}

	/**
	 * Replace the current entities in Patient Vital Informations with the given ones.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientVitalInformations(@NonNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {

		this.unsetPatientVitalInformations();
		this.patientVitalInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientVitalInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientVitalInformations() {
		this.unsetPatientVitalInformations(true);
	}

	/**
	 * Remove all the entities in Patient Vital Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientVitalInformations(boolean doReverse) {
		if (doReverse) {
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.unsetStaff(false));
		}
		this.patientVitalInformations.clear();
	}

/**
	 * Similar to {@link this#addPediatricianInCharge(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be added to this entity
	 */
	public void addPediatricianInCharge(@NonNull NewbornDetailEntity entity) {
		addPediatricianInCharge(entity, true);
	}

	/**
	 * Add a new NewbornDetailEntity to pediatricianInCharge in this entity.
	 *
	 * @param entity the given NewbornDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPediatricianInCharge(@NonNull NewbornDetailEntity entity, boolean reverseAdd) {
		if (!this.pediatricianInCharge.contains(entity)) {
			pediatricianInCharge.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 */
	public void addPediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities) {
		addPediatricianInCharge(entities, true);
	}

	/**
	 * Add a new collection of NewbornDetailEntity to Pediatrician In Charge in this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPediatricianInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePediatricianInCharge(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void removePediatricianInCharge(@NonNull NewbornDetailEntity entity) {
		this.removePediatricianInCharge(entity, true);
	}

	/**
	 * Remove the given NewbornDetailEntity from this entity.
	 *
	 * @param entity the given NewbornDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePediatricianInCharge(@NonNull NewbornDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.pediatricianInCharge.remove(entity);
	}

	/**
	 * Similar to {@link this#removePediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 */
	public void removePediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities) {
		this.removePediatricianInCharge(entities, true);
	}

	/**
	 * Remove the given collection of NewbornDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePediatricianInCharge(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPediatricianInCharge(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be set to this entity
	 */
	public void setPediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities) {
		setPediatricianInCharge(entities, true);
	}

	/**
	 * Replace the current entities in Pediatrician In Charge with the given ones.
	 *
	 * @param entities the given collection of NewbornDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPediatricianInCharge(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {

		this.unsetPediatricianInCharge();
		this.pediatricianInCharge = new HashSet<>(entities);
		if (reverseAdd) {
			this.pediatricianInCharge.forEach(pediatricianInChargeEntity -> pediatricianInChargeEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPediatricianInCharge(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPediatricianInCharge() {
		this.unsetPediatricianInCharge(true);
	}

	/**
	 * Remove all the entities in Pediatrician In Charge from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPediatricianInCharge(boolean doReverse) {
		if (doReverse) {
			this.pediatricianInCharge.forEach(pediatricianInChargeEntity -> pediatricianInChargeEntity.unsetStaff(false));
		}
		this.pediatricianInCharge.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity) {
		addPrescriptionHeaders(entity, true);
	}

	/**
	 * Add a new PrescriptionHeaderEntity to prescriptionHeaders in this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		if (!this.prescriptionHeaders.contains(entity)) {
			prescriptionHeaders.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		addPrescriptionHeaders(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionHeaderEntity to Prescription Headers in this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void removePrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity) {
		this.removePrescriptionHeaders(entity, true);
	}

	/**
	 * Remove the given PrescriptionHeaderEntity from this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.prescriptionHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 */
	public void removePrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		this.removePrescriptionHeaders(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		setPrescriptionHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Headers with the given ones.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionHeaders();
		this.prescriptionHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionHeaders() {
		this.unsetPrescriptionHeaders(true);
	}

	/**
	 * Remove all the entities in Prescription Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionHeaders(boolean doReverse) {
		if (doReverse) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.unsetRequestedBy(false));
		}
		this.prescriptionHeaders.clear();
	}

/**
	 * Similar to {@link this#addProcessWorkflowLogs(ProcessWorkflowEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ProcessWorkflowEntity to be added to this entity
	 */
	public void addProcessWorkflowLogs(@NonNull ProcessWorkflowEntity entity) {
		addProcessWorkflowLogs(entity, true);
	}

	/**
	 * Add a new ProcessWorkflowEntity to processWorkflowLogs in this entity.
	 *
	 * @param entity the given ProcessWorkflowEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addProcessWorkflowLogs(@NonNull ProcessWorkflowEntity entity, boolean reverseAdd) {
		if (!this.processWorkflowLogs.contains(entity)) {
			processWorkflowLogs.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be added to this entity
	 */
	public void addProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities) {
		addProcessWorkflowLogs(entities, true);
	}

	/**
	 * Add a new collection of ProcessWorkflowEntity to Process Workflow Logs in this entity.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addProcessWorkflowLogs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeProcessWorkflowLogs(ProcessWorkflowEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ProcessWorkflowEntity to be set to this entity
	 */
	public void removeProcessWorkflowLogs(@NonNull ProcessWorkflowEntity entity) {
		this.removeProcessWorkflowLogs(entity, true);
	}

	/**
	 * Remove the given ProcessWorkflowEntity from this entity.
	 *
	 * @param entity the given ProcessWorkflowEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeProcessWorkflowLogs(@NonNull ProcessWorkflowEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.processWorkflowLogs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be removed to this entity
	 */
	public void removeProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities) {
		this.removeProcessWorkflowLogs(entities, true);
	}

	/**
	 * Remove the given collection of ProcessWorkflowEntity from  to this entity.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeProcessWorkflowLogs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setProcessWorkflowLogs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to be set to this entity
	 */
	public void setProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities) {
		setProcessWorkflowLogs(entities, true);
	}

	/**
	 * Replace the current entities in Process Workflow Logs with the given ones.
	 *
	 * @param entities the given collection of ProcessWorkflowEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setProcessWorkflowLogs(@NonNull Collection<ProcessWorkflowEntity> entities, boolean reverseAdd) {

		this.unsetProcessWorkflowLogs();
		this.processWorkflowLogs = new HashSet<>(entities);
		if (reverseAdd) {
			this.processWorkflowLogs.forEach(processWorkflowLogsEntity -> processWorkflowLogsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetProcessWorkflowLogs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetProcessWorkflowLogs() {
		this.unsetProcessWorkflowLogs(true);
	}

	/**
	 * Remove all the entities in Process Workflow Logs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetProcessWorkflowLogs(boolean doReverse) {
		if (doReverse) {
			this.processWorkflowLogs.forEach(processWorkflowLogsEntity -> processWorkflowLogsEntity.unsetStaff(false));
		}
		this.processWorkflowLogs.clear();
	}

/**
	 * Similar to {@link this#addRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity) {
		addRegistrations(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			registrations.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Registrations in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRegistrations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRegistrations() {
		this.unsetRegistrations(true);
	}

	/**
	 * Remove all the entities in Registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetStaff(false));
		}
		this.registrations.clear();
	}

/**
	 * Similar to {@link this#addRequestedBy(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRequestedBy(@NonNull RegistrationEntity entity) {
		addRequestedBy(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to requestedBy in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRequestedBy(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.requestedBy.contains(entity)) {
			requestedBy.add(entity);
			if (reverseAdd) {
				entity.setRequestedBy(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRequestedBy(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRequestedBy(@NonNull Collection<RegistrationEntity> entities) {
		addRequestedBy(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Requested By in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRequestedBy(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRequestedBy(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRequestedBy(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRequestedBy(@NonNull RegistrationEntity entity) {
		this.removeRequestedBy(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRequestedBy(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRequestedBy(false);
		}
		this.requestedBy.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRequestedBy(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRequestedBy(@NonNull Collection<RegistrationEntity> entities) {
		this.removeRequestedBy(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRequestedBy(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRequestedBy(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRequestedBy(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRequestedBy(@NonNull Collection<RegistrationEntity> entities) {
		setRequestedBy(entities, true);
	}

	/**
	 * Replace the current entities in Requested By with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRequestedBy(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRequestedBy();
		this.requestedBy = new HashSet<>(entities);
		if (reverseAdd) {
			this.requestedBy.forEach(requestedByEntity -> requestedByEntity.setRequestedBy(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRequestedBy(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRequestedBy() {
		this.unsetRequestedBy(true);
	}

	/**
	 * Remove all the entities in Requested By from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRequestedBy(boolean doReverse) {
		if (doReverse) {
			this.requestedBy.forEach(requestedByEntity -> requestedByEntity.unsetRequestedBy(false));
		}
		this.requestedBy.clear();
	}

/**
	 * Similar to {@link this#addRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity) {
		addRoomTransfers(entity, true);
	}

	/**
	 * Add a new RoomTransferEntity to roomTransfers in this entity.
	 *
	 * @param entity the given RoomTransferEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverseAdd) {
		if (!this.roomTransfers.contains(entity)) {
			roomTransfers.add(entity);
			if (reverseAdd) {
				entity.setTransferringStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		addRoomTransfers(entities, true);
	}

	/**
	 * Add a new collection of RoomTransferEntity to Room Transfers in this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be set to this entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransferringStaff(false);
		}
		this.roomTransfers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		this.removeRoomTransfers(entities, true);
	}

	/**
	 * Remove the given collection of RoomTransferEntity from  to this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be set to this entity
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

		this.unsetRoomTransfers();
		this.roomTransfers = new HashSet<>(entities);
		if (reverseAdd) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.setTransferringStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoomTransfers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoomTransfers() {
		this.unsetRoomTransfers(true);
	}

	/**
	 * Remove all the entities in Room Transfers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoomTransfers(boolean doReverse) {
		if (doReverse) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.unsetTransferringStaff(false));
		}
		this.roomTransfers.clear();
	}

/**
	 * Similar to {@link this#addSampleCollectionStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionStaffs(@NonNull SampleCollectionItemsEntity entity) {
		addSampleCollectionStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleCollectionStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleCollectionStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleCollectionStaffs.contains(entity)) {
			sampleCollectionStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleCollectionStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleCollectionStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Collection Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleCollectionStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleCollectionStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleCollectionStaffs(@NonNull SampleCollectionItemsEntity entity) {
		this.removeSampleCollectionStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleCollectionStaff(false);
		}
		this.sampleCollectionStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleCollectionStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleCollectionStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleCollectionStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleCollectionStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleCollectionStaffs();
		this.sampleCollectionStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleCollectionStaffs.forEach(sampleCollectionStaffsEntity -> sampleCollectionStaffsEntity.setSampleCollectionStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleCollectionStaffs() {
		this.unsetSampleCollectionStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Collection Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleCollectionStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleCollectionStaffs.forEach(sampleCollectionStaffsEntity -> sampleCollectionStaffsEntity.unsetSampleCollectionStaff(false));
		}
		this.sampleCollectionStaffs.clear();
	}

/**
	 * Similar to {@link this#addSampleDeliveryStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleDeliveryStaffs(@NonNull SampleCollectionItemsEntity entity) {
		addSampleDeliveryStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleDeliveryStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleDeliveryStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleDeliveryStaffs.contains(entity)) {
			sampleDeliveryStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleDeliveryStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Delivery Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleDeliveryStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleDeliveryStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleDeliveryStaffs(@NonNull SampleCollectionItemsEntity entity) {
		this.removeSampleDeliveryStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleDeliveryStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleDeliveryStaff(false);
		}
		this.sampleDeliveryStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleDeliveryStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleDeliveryStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleDeliveryStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Delivery Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleDeliveryStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleDeliveryStaffs();
		this.sampleDeliveryStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleDeliveryStaffs.forEach(sampleDeliveryStaffsEntity -> sampleDeliveryStaffsEntity.setSampleDeliveryStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleDeliveryStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleDeliveryStaffs() {
		this.unsetSampleDeliveryStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Delivery Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleDeliveryStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleDeliveryStaffs.forEach(sampleDeliveryStaffsEntity -> sampleDeliveryStaffsEntity.unsetSampleDeliveryStaff(false));
		}
		this.sampleDeliveryStaffs.clear();
	}

/**
	 * Similar to {@link this#addSampleProcessingStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleProcessingStaffs(@NonNull SampleCollectionItemsEntity entity) {
		addSampleProcessingStaffs(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleProcessingStaffs in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleProcessingStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleProcessingStaffs.contains(entity)) {
			sampleProcessingStaffs.add(entity);
			if (reverseAdd) {
				entity.setSampleProcessingStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleProcessingStaffs(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Processing Staffs in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleProcessingStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleProcessingStaffs(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleProcessingStaffs(@NonNull SampleCollectionItemsEntity entity) {
		this.removeSampleProcessingStaffs(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleProcessingStaffs(@NonNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleProcessingStaff(false);
		}
		this.sampleProcessingStaffs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleProcessingStaffs(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleProcessingStaffs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleProcessingStaffs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleProcessingStaffs(entities, true);
	}

	/**
	 * Replace the current entities in Sample Processing Staffs with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleProcessingStaffs(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleProcessingStaffs();
		this.sampleProcessingStaffs = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleProcessingStaffs.forEach(sampleProcessingStaffsEntity -> sampleProcessingStaffsEntity.setSampleProcessingStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleProcessingStaffs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleProcessingStaffs() {
		this.unsetSampleProcessingStaffs(true);
	}

	/**
	 * Remove all the entities in Sample Processing Staffs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleProcessingStaffs(boolean doReverse) {
		if (doReverse) {
			this.sampleProcessingStaffs.forEach(sampleProcessingStaffsEntity -> sampleProcessingStaffsEntity.unsetSampleProcessingStaff(false));
		}
		this.sampleProcessingStaffs.clear();
	}

	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setService(@NonNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update service with the given ServiceEntity.
	 *
	 * @param entity the StaffEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NonNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.unsetDefaultMedicalStaff();
		}

		this.service = entity;

		if (reverseAdd) {
			this.service.setDefaultMedicalStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove the ServiceEntity in Service from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.unsetDefaultMedicalStaff(false);
		}
		this.service = null;
	}

	/**
	 * Similar to {@link this#addServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be added to this entity
	 */
	public void addServices(@NonNull ServiceEntity entity) {
		addServices(entity, true);
	}

	/**
	 * Add a new ServiceEntity to Services in this entity.
	 *
	 * @param entity the given ServiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServices(@NonNull ServiceEntity entity, boolean reverseAdd) {
		if (!this.services.contains(entity)) {
			this.services.add(entity);
			if (reverseAdd) {
				entity.addAssignedMedicalStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities) {
		addServices(entities, true);
	}

	/**
	 * Add new collection of ServiceEntity to services in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void removeServices(@NonNull ServiceEntity entity) {
		this.removeServices(entity, true);
	}

	/**
	 * Remove the given ServiceEntity from this entity.
	 *
	 * @param entity the give ServiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServices(@NonNull ServiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeAssignedMedicalStaff(this, false);
		}
		this.services.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities) {
		this.removeServices(entities, true);
	}

	/**
	 * Remove the given collection of ServiceEntity in services from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setServices(@NonNull Collection<ServiceEntity> entities) {
		this.setServices(entities, true);
	}

	/**
	 * Replace the current entities in services with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		this.unsetServices();
		this.services = new HashSet<>(entities);
		if (reverseAdd) {
			this.services.forEach(entity -> entity.addAssignedMedicalStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServices() {
		this.unsetServices(true);
	}

	/**
	 * Remove all entities in services from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServices(boolean doReverse) {
		if (doReverse) {
			this.services.forEach(entity -> entity.removeAssignedMedicalStaff(this, false));
		}
		this.services.clear();
	}

/**
	 * Similar to {@link this#addSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgeon(@NonNull PreoperativeRecordsEntity entity) {
		addSurgeon(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgeon in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgeon(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgeon.contains(entity)) {
			surgeon.add(entity);
			if (reverseAdd) {
				entity.setSurgeon(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgeon(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgeon(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgeon in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgeon(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgeon(@NonNull PreoperativeRecordsEntity entity) {
		this.removeSurgeon(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgeon(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgeon(false);
		}
		this.surgeon.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgeon(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgeon(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgeon(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgeon(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgeon(entities, true);
	}

	/**
	 * Replace the current entities in Surgeon with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgeon(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgeon();
		this.surgeon = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgeon.forEach(surgeonEntity -> surgeonEntity.setSurgeon(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgeon(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgeon() {
		this.unsetSurgeon(true);
	}

	/**
	 * Remove all the entities in Surgeon from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgeon(boolean doReverse) {
		if (doReverse) {
			this.surgeon.forEach(surgeonEntity -> surgeonEntity.unsetSurgeon(false));
		}
		this.surgeon.clear();
	}

/**
	 * Similar to {@link this#addSurgicalMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity) {
		addSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgicalMedicalTranscriber in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgicalMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgicalMedicalTranscriber.contains(entity)) {
			surgicalMedicalTranscriber.add(entity);
			if (reverseAdd) {
				entity.setSurgicalMedicalTranscriber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgical Medical Transcriber in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgicalMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgicalMedicalTranscriber(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgicalMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity) {
		this.removeSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgicalMedicalTranscriber(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgicalMedicalTranscriber(false);
		}
		this.surgicalMedicalTranscriber.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgicalMedicalTranscriber(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgicalMedicalTranscriber(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgicalMedicalTranscriber(entities, true);
	}

	/**
	 * Replace the current entities in Surgical Medical Transcriber with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgicalMedicalTranscriber(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgicalMedicalTranscriber();
		this.surgicalMedicalTranscriber = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgicalMedicalTranscriber.forEach(surgicalMedicalTranscriberEntity -> surgicalMedicalTranscriberEntity.setSurgicalMedicalTranscriber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgicalMedicalTranscriber(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgicalMedicalTranscriber() {
		this.unsetSurgicalMedicalTranscriber(true);
	}

	/**
	 * Remove all the entities in Surgical Medical Transcriber from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgicalMedicalTranscriber(boolean doReverse) {
		if (doReverse) {
			this.surgicalMedicalTranscriber.forEach(surgicalMedicalTranscriberEntity -> surgicalMedicalTranscriberEntity.unsetSurgicalMedicalTranscriber(false));
		}
		this.surgicalMedicalTranscriber.clear();
	}

/**
	 * Similar to {@link this#addSurgicalNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalNurse(@NonNull PreoperativeRecordsEntity entity) {
		addSurgicalNurse(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to surgicalNurse in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSurgicalNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.surgicalNurse.contains(entity)) {
			surgicalNurse.add(entity);
			if (reverseAdd) {
				entity.setSurgicalNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addSurgicalNurse(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Surgical Nurse in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSurgicalNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSurgicalNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removeSurgicalNurse(@NonNull PreoperativeRecordsEntity entity) {
		this.removeSurgicalNurse(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSurgicalNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSurgicalNurse(false);
		}
		this.surgicalNurse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removeSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removeSurgicalNurse(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSurgicalNurse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSurgicalNurse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setSurgicalNurse(entities, true);
	}

	/**
	 * Replace the current entities in Surgical Nurse with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSurgicalNurse(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetSurgicalNurse();
		this.surgicalNurse = new HashSet<>(entities);
		if (reverseAdd) {
			this.surgicalNurse.forEach(surgicalNurseEntity -> surgicalNurseEntity.setSurgicalNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSurgicalNurse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSurgicalNurse() {
		this.unsetSurgicalNurse(true);
	}

	/**
	 * Remove all the entities in Surgical Nurse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSurgicalNurse(boolean doReverse) {
		if (doReverse) {
			this.surgicalNurse.forEach(surgicalNurseEntity -> surgicalNurseEntity.unsetSurgicalNurse(false));
		}
		this.surgicalNurse.clear();
	}

/**
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetStaff(false));
		}
		this.transferOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addVaccinationOrders(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be added to this entity
	 */
	public void addVaccinationOrders(@NonNull VaccinationOrderEntity entity) {
		addVaccinationOrders(entity, true);
	}

	/**
	 * Add a new VaccinationOrderEntity to vaccinationOrders in this entity.
	 *
	 * @param entity the given VaccinationOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrders(@NonNull VaccinationOrderEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrders.contains(entity)) {
			vaccinationOrders.add(entity);
			if (reverseAdd) {
				entity.setStaff(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be added to this entity
	 */
	public void addVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities) {
		addVaccinationOrders(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderEntity to Vaccination Orders in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrders(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be set to this entity
	 */
	public void removeVaccinationOrders(@NonNull VaccinationOrderEntity entity) {
		this.removeVaccinationOrders(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrders(@NonNull VaccinationOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStaff(false);
		}
		this.vaccinationOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be removed to this entity
	 */
	public void removeVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities) {
		this.removeVaccinationOrders(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to be set to this entity
	 */
	public void setVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities) {
		setVaccinationOrders(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Orders with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrders(@NonNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrders();
		this.vaccinationOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.setStaff(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrders() {
		this.unsetVaccinationOrders(true);
	}

	/**
	 * Remove all the entities in Vaccination Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrders(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.unsetStaff(false));
		}
		this.vaccinationOrders.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setAdministrationUser(AdministrationUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AdministrationUserEntity to be set to this entity
	 */
	public void setAdministrationUser(AdministrationUserEntity entity) {
		setAdministrationUser(entity, true);
	}

	/**
	 * Set or update the administrationUser in this entity with single AdministrationUserEntity.
	 *
	 * @param entity the given AdministrationUserEntity to be set or updated to administrationUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdministrationUser(AdministrationUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdministrationUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdministrationUser here] end

		if (sameAsFormer(this.administrationUser, entity)) {
			return;
		}

		if (this.administrationUser != null) {
			this.administrationUser.unsetStaff(false);
		}

		this.administrationUser = entity;
		if (reverseAdd) {
			this.administrationUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdministrationUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdministrationUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetAdministrationUser(boolean)} but default to true.
	 */
	public void unsetAdministrationUser() {
		this.unsetAdministrationUser(true);
	}

	/**
	 * Remove the AdministrationUserEntity of administrationUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdministrationUser(boolean reverse) {
		if (reverse && this.administrationUser != null) {
			this.administrationUser.unsetStaff();
		}
		this.administrationUser = null;
	}
	/**
	 * Similar to {@link this#setCashierUser(CashierUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashierUserEntity to be set to this entity
	 */
	public void setCashierUser(CashierUserEntity entity) {
		setCashierUser(entity, true);
	}

	/**
	 * Set or update the cashierUser in this entity with single CashierUserEntity.
	 *
	 * @param entity the given CashierUserEntity to be set or updated to cashierUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCashierUser(CashierUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCashierUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCashierUser here] end

		if (sameAsFormer(this.cashierUser, entity)) {
			return;
		}

		if (this.cashierUser != null) {
			this.cashierUser.unsetStaff(false);
		}

		this.cashierUser = entity;
		if (reverseAdd) {
			this.cashierUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCashierUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCashierUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetCashierUser(boolean)} but default to true.
	 */
	public void unsetCashierUser() {
		this.unsetCashierUser(true);
	}

	/**
	 * Remove the CashierUserEntity of cashierUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCashierUser(boolean reverse) {
		if (reverse && this.cashierUser != null) {
			this.cashierUser.unsetStaff();
		}
		this.cashierUser = null;
	}
	/**
	 * Similar to {@link this#setClaimUser(ClaimUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ClaimUserEntity to be set to this entity
	 */
	public void setClaimUser(ClaimUserEntity entity) {
		setClaimUser(entity, true);
	}

	/**
	 * Set or update the claimUser in this entity with single ClaimUserEntity.
	 *
	 * @param entity the given ClaimUserEntity to be set or updated to claimUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setClaimUser(ClaimUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setClaimUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setClaimUser here] end

		if (sameAsFormer(this.claimUser, entity)) {
			return;
		}

		if (this.claimUser != null) {
			this.claimUser.unsetStaff(false);
		}

		this.claimUser = entity;
		if (reverseAdd) {
			this.claimUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setClaimUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setClaimUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetClaimUser(boolean)} but default to true.
	 */
	public void unsetClaimUser() {
		this.unsetClaimUser(true);
	}

	/**
	 * Remove the ClaimUserEntity of claimUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetClaimUser(boolean reverse) {
		if (reverse && this.claimUser != null) {
			this.claimUser.unsetStaff();
		}
		this.claimUser = null;
	}
	/**
	 * Similar to {@link this#setDiagnosticSupportUser(DiagnosticSupportUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticSupportUserEntity to be set to this entity
	 */
	public void setDiagnosticSupportUser(DiagnosticSupportUserEntity entity) {
		setDiagnosticSupportUser(entity, true);
	}

	/**
	 * Set or update the diagnosticSupportUser in this entity with single DiagnosticSupportUserEntity.
	 *
	 * @param entity the given DiagnosticSupportUserEntity to be set or updated to diagnosticSupportUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosticSupportUser(DiagnosticSupportUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticSupportUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticSupportUser here] end

		if (sameAsFormer(this.diagnosticSupportUser, entity)) {
			return;
		}

		if (this.diagnosticSupportUser != null) {
			this.diagnosticSupportUser.unsetStaff(false);
		}

		this.diagnosticSupportUser = entity;
		if (reverseAdd) {
			this.diagnosticSupportUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosticSupportUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosticSupportUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosticSupportUser(boolean)} but default to true.
	 */
	public void unsetDiagnosticSupportUser() {
		this.unsetDiagnosticSupportUser(true);
	}

	/**
	 * Remove the DiagnosticSupportUserEntity of diagnosticSupportUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosticSupportUser(boolean reverse) {
		if (reverse && this.diagnosticSupportUser != null) {
			this.diagnosticSupportUser.unsetStaff();
		}
		this.diagnosticSupportUser = null;
	}
	/**
	 * Similar to {@link this#setDoctorUser(DoctorUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DoctorUserEntity to be set to this entity
	 */
	public void setDoctorUser(DoctorUserEntity entity) {
		setDoctorUser(entity, true);
	}

	/**
	 * Set or update the doctorUser in this entity with single DoctorUserEntity.
	 *
	 * @param entity the given DoctorUserEntity to be set or updated to doctorUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctorUser(DoctorUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctorUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctorUser here] end

		if (sameAsFormer(this.doctorUser, entity)) {
			return;
		}

		if (this.doctorUser != null) {
			this.doctorUser.unsetStaff(false);
		}

		this.doctorUser = entity;
		if (reverseAdd) {
			this.doctorUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctorUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctorUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDoctorUser(boolean)} but default to true.
	 */
	public void unsetDoctorUser() {
		this.unsetDoctorUser(true);
	}

	/**
	 * Remove the DoctorUserEntity of doctorUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctorUser(boolean reverse) {
		if (reverse && this.doctorUser != null) {
			this.doctorUser.unsetStaff();
		}
		this.doctorUser = null;
	}
	/**
	 * Similar to {@link this#setFacilityUser(FacilityUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given FacilityUserEntity to be set to this entity
	 */
	public void setFacilityUser(FacilityUserEntity entity) {
		setFacilityUser(entity, true);
	}

	/**
	 * Set or update the facilityUser in this entity with single FacilityUserEntity.
	 *
	 * @param entity the given FacilityUserEntity to be set or updated to facilityUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setFacilityUser(FacilityUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setFacilityUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setFacilityUser here] end

		if (sameAsFormer(this.facilityUser, entity)) {
			return;
		}

		if (this.facilityUser != null) {
			this.facilityUser.unsetStaff(false);
		}

		this.facilityUser = entity;
		if (reverseAdd) {
			this.facilityUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setFacilityUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setFacilityUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetFacilityUser(boolean)} but default to true.
	 */
	public void unsetFacilityUser() {
		this.unsetFacilityUser(true);
	}

	/**
	 * Remove the FacilityUserEntity of facilityUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetFacilityUser(boolean reverse) {
		if (reverse && this.facilityUser != null) {
			this.facilityUser.unsetStaff();
		}
		this.facilityUser = null;
	}
	/**
	 * Similar to {@link this#setManagementUser(ManagementUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ManagementUserEntity to be set to this entity
	 */
	public void setManagementUser(ManagementUserEntity entity) {
		setManagementUser(entity, true);
	}

	/**
	 * Set or update the managementUser in this entity with single ManagementUserEntity.
	 *
	 * @param entity the given ManagementUserEntity to be set or updated to managementUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setManagementUser(ManagementUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setManagementUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setManagementUser here] end

		if (sameAsFormer(this.managementUser, entity)) {
			return;
		}

		if (this.managementUser != null) {
			this.managementUser.unsetStaff(false);
		}

		this.managementUser = entity;
		if (reverseAdd) {
			this.managementUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setManagementUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setManagementUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetManagementUser(boolean)} but default to true.
	 */
	public void unsetManagementUser() {
		this.unsetManagementUser(true);
	}

	/**
	 * Remove the ManagementUserEntity of managementUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetManagementUser(boolean reverse) {
		if (reverse && this.managementUser != null) {
			this.managementUser.unsetStaff();
		}
		this.managementUser = null;
	}
	/**
	 * Similar to {@link this#setMedicalRecordUser(MedicalRecordUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalRecordUserEntity to be set to this entity
	 */
	public void setMedicalRecordUser(MedicalRecordUserEntity entity) {
		setMedicalRecordUser(entity, true);
	}

	/**
	 * Set or update the medicalRecordUser in this entity with single MedicalRecordUserEntity.
	 *
	 * @param entity the given MedicalRecordUserEntity to be set or updated to medicalRecordUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordUser(MedicalRecordUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordUser here] end

		if (sameAsFormer(this.medicalRecordUser, entity)) {
			return;
		}

		if (this.medicalRecordUser != null) {
			this.medicalRecordUser.unsetStaff(false);
		}

		this.medicalRecordUser = entity;
		if (reverseAdd) {
			this.medicalRecordUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordUser(boolean)} but default to true.
	 */
	public void unsetMedicalRecordUser() {
		this.unsetMedicalRecordUser(true);
	}

	/**
	 * Remove the MedicalRecordUserEntity of medicalRecordUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordUser(boolean reverse) {
		if (reverse && this.medicalRecordUser != null) {
			this.medicalRecordUser.unsetStaff();
		}
		this.medicalRecordUser = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriberUser(MedicalTranscriberUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalTranscriberUserEntity to be set to this entity
	 */
	public void setMedicalTranscriberUser(MedicalTranscriberUserEntity entity) {
		setMedicalTranscriberUser(entity, true);
	}

	/**
	 * Set or update the medicalTranscriberUser in this entity with single MedicalTranscriberUserEntity.
	 *
	 * @param entity the given MedicalTranscriberUserEntity to be set or updated to medicalTranscriberUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriberUser(MedicalTranscriberUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriberUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriberUser here] end

		if (sameAsFormer(this.medicalTranscriberUser, entity)) {
			return;
		}

		if (this.medicalTranscriberUser != null) {
			this.medicalTranscriberUser.unsetStaff(false);
		}

		this.medicalTranscriberUser = entity;
		if (reverseAdd) {
			this.medicalTranscriberUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriberUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriberUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriberUser(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriberUser() {
		this.unsetMedicalTranscriberUser(true);
	}

	/**
	 * Remove the MedicalTranscriberUserEntity of medicalTranscriberUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriberUser(boolean reverse) {
		if (reverse && this.medicalTranscriberUser != null) {
			this.medicalTranscriberUser.unsetStaff();
		}
		this.medicalTranscriberUser = null;
	}
	/**
	 * Similar to {@link this#setNurseUser(NurseUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NurseUserEntity to be set to this entity
	 */
	public void setNurseUser(NurseUserEntity entity) {
		setNurseUser(entity, true);
	}

	/**
	 * Set or update the nurseUser in this entity with single NurseUserEntity.
	 *
	 * @param entity the given NurseUserEntity to be set or updated to nurseUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurseUser(NurseUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurseUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurseUser here] end

		if (sameAsFormer(this.nurseUser, entity)) {
			return;
		}

		if (this.nurseUser != null) {
			this.nurseUser.unsetStaff(false);
		}

		this.nurseUser = entity;
		if (reverseAdd) {
			this.nurseUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurseUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurseUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetNurseUser(boolean)} but default to true.
	 */
	public void unsetNurseUser() {
		this.unsetNurseUser(true);
	}

	/**
	 * Remove the NurseUserEntity of nurseUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurseUser(boolean reverse) {
		if (reverse && this.nurseUser != null) {
			this.nurseUser.unsetStaff();
		}
		this.nurseUser = null;
	}
	/**
	 * Similar to {@link this#setPharmacyUser(PharmacyUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PharmacyUserEntity to be set to this entity
	 */
	public void setPharmacyUser(PharmacyUserEntity entity) {
		setPharmacyUser(entity, true);
	}

	/**
	 * Set or update the pharmacyUser in this entity with single PharmacyUserEntity.
	 *
	 * @param entity the given PharmacyUserEntity to be set or updated to pharmacyUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPharmacyUser(PharmacyUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPharmacyUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPharmacyUser here] end

		if (sameAsFormer(this.pharmacyUser, entity)) {
			return;
		}

		if (this.pharmacyUser != null) {
			this.pharmacyUser.unsetStaff(false);
		}

		this.pharmacyUser = entity;
		if (reverseAdd) {
			this.pharmacyUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPharmacyUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPharmacyUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPharmacyUser(boolean)} but default to true.
	 */
	public void unsetPharmacyUser() {
		this.unsetPharmacyUser(true);
	}

	/**
	 * Remove the PharmacyUserEntity of pharmacyUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPharmacyUser(boolean reverse) {
		if (reverse && this.pharmacyUser != null) {
			this.pharmacyUser.unsetStaff();
		}
		this.pharmacyUser = null;
	}
	/**
	 * Similar to {@link this#setPurchasingUser(PurchasingUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchasingUserEntity to be set to this entity
	 */
	public void setPurchasingUser(PurchasingUserEntity entity) {
		setPurchasingUser(entity, true);
	}

	/**
	 * Set or update the purchasingUser in this entity with single PurchasingUserEntity.
	 *
	 * @param entity the given PurchasingUserEntity to be set or updated to purchasingUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchasingUser(PurchasingUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchasingUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchasingUser here] end

		if (sameAsFormer(this.purchasingUser, entity)) {
			return;
		}

		if (this.purchasingUser != null) {
			this.purchasingUser.unsetStaff(false);
		}

		this.purchasingUser = entity;
		if (reverseAdd) {
			this.purchasingUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchasingUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchasingUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPurchasingUser(boolean)} but default to true.
	 */
	public void unsetPurchasingUser() {
		this.unsetPurchasingUser(true);
	}

	/**
	 * Remove the PurchasingUserEntity of purchasingUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchasingUser(boolean reverse) {
		if (reverse && this.purchasingUser != null) {
			this.purchasingUser.unsetStaff();
		}
		this.purchasingUser = null;
	}
	/**
	 * Similar to {@link this#setRegistrationUser(RegistrationUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationUserEntity to be set to this entity
	 */
	public void setRegistrationUser(RegistrationUserEntity entity) {
		setRegistrationUser(entity, true);
	}

	/**
	 * Set or update the registrationUser in this entity with single RegistrationUserEntity.
	 *
	 * @param entity the given RegistrationUserEntity to be set or updated to registrationUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistrationUser(RegistrationUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistrationUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistrationUser here] end

		if (sameAsFormer(this.registrationUser, entity)) {
			return;
		}

		if (this.registrationUser != null) {
			this.registrationUser.unsetStaff(false);
		}

		this.registrationUser = entity;
		if (reverseAdd) {
			this.registrationUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistrationUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistrationUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistrationUser(boolean)} but default to true.
	 */
	public void unsetRegistrationUser() {
		this.unsetRegistrationUser(true);
	}

	/**
	 * Remove the RegistrationUserEntity of registrationUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistrationUser(boolean reverse) {
		if (reverse && this.registrationUser != null) {
			this.registrationUser.unsetStaff();
		}
		this.registrationUser = null;
	}
	/**
	 * Similar to {@link this#setSystemAdminUser(SystemAdminUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SystemAdminUserEntity to be set to this entity
	 */
	public void setSystemAdminUser(SystemAdminUserEntity entity) {
		setSystemAdminUser(entity, true);
	}

	/**
	 * Set or update the systemAdminUser in this entity with single SystemAdminUserEntity.
	 *
	 * @param entity the given SystemAdminUserEntity to be set or updated to systemAdminUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSystemAdminUser(SystemAdminUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSystemAdminUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSystemAdminUser here] end

		if (sameAsFormer(this.systemAdminUser, entity)) {
			return;
		}

		if (this.systemAdminUser != null) {
			this.systemAdminUser.unsetStaff(false);
		}

		this.systemAdminUser = entity;
		if (reverseAdd) {
			this.systemAdminUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSystemAdminUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSystemAdminUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetSystemAdminUser(boolean)} but default to true.
	 */
	public void unsetSystemAdminUser() {
		this.unsetSystemAdminUser(true);
	}

	/**
	 * Remove the SystemAdminUserEntity of systemAdminUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSystemAdminUser(boolean reverse) {
		if (reverse && this.systemAdminUser != null) {
			this.systemAdminUser.unsetStaff();
		}
		this.systemAdminUser = null;
	}
	/**
	 * Similar to {@link this#setWarehouseUser(WarehouseUserEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseUserEntity to be set to this entity
	 */
	public void setWarehouseUser(WarehouseUserEntity entity) {
		setWarehouseUser(entity, true);
	}

	/**
	 * Set or update the warehouseUser in this entity with single WarehouseUserEntity.
	 *
	 * @param entity the given WarehouseUserEntity to be set or updated to warehouseUser
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouseUser(WarehouseUserEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouseUser here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouseUser here] end

		if (sameAsFormer(this.warehouseUser, entity)) {
			return;
		}

		if (this.warehouseUser != null) {
			this.warehouseUser.unsetStaff(false);
		}

		this.warehouseUser = entity;
		if (reverseAdd) {
			this.warehouseUser.setStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouseUser incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouseUser incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouseUser(boolean)} but default to true.
	 */
	public void unsetWarehouseUser() {
		this.unsetWarehouseUser(true);
	}

	/**
	 * Remove the WarehouseUserEntity of warehouseUser from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouseUser(boolean reverse) {
		if (reverse && this.warehouseUser != null) {
			this.warehouseUser.unsetStaff();
		}
		this.warehouseUser = null;
	}

	public void addStaffPicture(FileEntity newFile) {
		staffPicture.add(newFile);
	}

	public void addAllStaffPicture(Collection<FileEntity> newFiles) {
		staffPicture.addAll(newFiles);
	}

	public void removeStaffPicture(FileEntity newFile) {
		staffPicture.remove(newFile);
	}

	public boolean containsStaffPicture(FileEntity newFile) {
		return staffPicture.contains(newFile);
	}

	public void clearAllStaffPicture() {
		staffPicture.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
