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
public class RegistrationEntity extends AbstractEntity {

	public RegistrationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdmissionICD10OneMany = new EntityReference();
			AdmissionICD10OneMany.entityName = "DiagnosesAndProcedures";
			AdmissionICD10OneMany.oppositeName = "AdmissionICD10";
			AdmissionICD10OneMany.name = "AdmissionICD10";
			AdmissionICD10OneMany.optional = true;
			AdmissionICD10OneMany.type = "One";
			AdmissionICD10OneMany.oppositeType = "Many";

		References.add(AdmissionICD10OneMany);

		var AdmissionICD9CMOneMany = new EntityReference();
			AdmissionICD9CMOneMany.entityName = "DiagnosesAndProcedures";
			AdmissionICD9CMOneMany.oppositeName = "AdmissionICD9CM";
			AdmissionICD9CMOneMany.name = "AdmissionICD9CM";
			AdmissionICD9CMOneMany.optional = true;
			AdmissionICD9CMOneMany.type = "One";
			AdmissionICD9CMOneMany.oppositeType = "Many";

		References.add(AdmissionICD9CMOneMany);

		var BpjsPRBDetailOneOne = new EntityReference();
			BpjsPRBDetailOneOne.entityName = "BpjsPRBDetail";
			BpjsPRBDetailOneOne.oppositeName = "Registration";
			BpjsPRBDetailOneOne.name = "BpjsPRBDetail";
			BpjsPRBDetailOneOne.optional = true;
			BpjsPRBDetailOneOne.type = "One";
			BpjsPRBDetailOneOne.oppositeType = "One";

		References.add(BpjsPRBDetailOneOne);

		var BpjsPcareRegistrationsOneOne = new EntityReference();
			BpjsPcareRegistrationsOneOne.entityName = "BpjsPcareRegistrations";
			BpjsPcareRegistrationsOneOne.oppositeName = "Registration";
			BpjsPcareRegistrationsOneOne.name = "BpjsPcareRegistrations";
			BpjsPcareRegistrationsOneOne.optional = true;
			BpjsPcareRegistrationsOneOne.type = "One";
			BpjsPcareRegistrationsOneOne.oppositeType = "One";

		References.add(BpjsPcareRegistrationsOneOne);

		var BpjsSEPOneOne = new EntityReference();
			BpjsSEPOneOne.entityName = "BpjsSEP";
			BpjsSEPOneOne.oppositeName = "Registration";
			BpjsSEPOneOne.name = "BpjsSEP";
			BpjsSEPOneOne.optional = true;
			BpjsSEPOneOne.type = "One";
			BpjsSEPOneOne.oppositeType = "One";

		References.add(BpjsSEPOneOne);

		var BedReservesOneMany = new EntityReference();
			BedReservesOneMany.entityName = "BedReserve";
			BedReservesOneMany.oppositeName = "Registration";
			BedReservesOneMany.name = "BedReserves";
			BedReservesOneMany.optional = true;
			BedReservesOneMany.type = "One";
			BedReservesOneMany.oppositeType = "Many";

		References.add(BedReservesOneMany);

		var DiagnosticExaminationResultsOneMany = new EntityReference();
			DiagnosticExaminationResultsOneMany.entityName = "DiagnosticExaminationResults";
			DiagnosticExaminationResultsOneMany.oppositeName = "Registration";
			DiagnosticExaminationResultsOneMany.name = "DiagnosticExaminationResults";
			DiagnosticExaminationResultsOneMany.optional = true;
			DiagnosticExaminationResultsOneMany.type = "One";
			DiagnosticExaminationResultsOneMany.oppositeType = "Many";

		References.add(DiagnosticExaminationResultsOneMany);

		var DismissalReferringFacilityOneMany = new EntityReference();
			DismissalReferringFacilityOneMany.entityName = "HealthFacility";
			DismissalReferringFacilityOneMany.oppositeName = "DismissalReferringFacility";
			DismissalReferringFacilityOneMany.name = "DismissalReferringFacility";
			DismissalReferringFacilityOneMany.optional = true;
			DismissalReferringFacilityOneMany.type = "One";
			DismissalReferringFacilityOneMany.oppositeType = "Many";

		References.add(DismissalReferringFacilityOneMany);

		var DismissalReferringStaffOneMany = new EntityReference();
			DismissalReferringStaffOneMany.entityName = "Staff";
			DismissalReferringStaffOneMany.oppositeName = "DismissalReferringStaff";
			DismissalReferringStaffOneMany.name = "DismissalReferringStaff";
			DismissalReferringStaffOneMany.optional = true;
			DismissalReferringStaffOneMany.type = "One";
			DismissalReferringStaffOneMany.oppositeType = "Many";

		References.add(DismissalReferringStaffOneMany);

		var FluidBalanceDetailsOneMany = new EntityReference();
			FluidBalanceDetailsOneMany.entityName = "FluidBalanceDetail";
			FluidBalanceDetailsOneMany.oppositeName = "Registration";
			FluidBalanceDetailsOneMany.name = "FluidBalanceDetails";
			FluidBalanceDetailsOneMany.optional = true;
			FluidBalanceDetailsOneMany.type = "One";
			FluidBalanceDetailsOneMany.oppositeType = "Many";

		References.add(FluidBalanceDetailsOneMany);

		var InformedConsentsOneMany = new EntityReference();
			InformedConsentsOneMany.entityName = "InformedConsent";
			InformedConsentsOneMany.oppositeName = "Registration";
			InformedConsentsOneMany.name = "InformedConsents";
			InformedConsentsOneMany.optional = true;
			InformedConsentsOneMany.type = "One";
			InformedConsentsOneMany.oppositeType = "Many";

		References.add(InformedConsentsOneMany);

		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "ServiceNumber";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var MedicalCertificateDischargeResumeOneOne = new EntityReference();
			MedicalCertificateDischargeResumeOneOne.entityName = "MedicalCertificateDischargeResume";
			MedicalCertificateDischargeResumeOneOne.oppositeName = "Registration";
			MedicalCertificateDischargeResumeOneOne.name = "MedicalCertificateDischargeResume";
			MedicalCertificateDischargeResumeOneOne.optional = true;
			MedicalCertificateDischargeResumeOneOne.type = "One";
			MedicalCertificateDischargeResumeOneOne.oppositeType = "One";

		References.add(MedicalCertificateDischargeResumeOneOne);

		var MedicalCertificateBirthOneOne = new EntityReference();
			MedicalCertificateBirthOneOne.entityName = "MedicalCertificateBirth";
			MedicalCertificateBirthOneOne.oppositeName = "Registration";
			MedicalCertificateBirthOneOne.name = "MedicalCertificateBirth";
			MedicalCertificateBirthOneOne.optional = true;
			MedicalCertificateBirthOneOne.type = "One";
			MedicalCertificateBirthOneOne.oppositeType = "One";

		References.add(MedicalCertificateBirthOneOne);

		var MedicalCertificateHospitalizationOneOne = new EntityReference();
			MedicalCertificateHospitalizationOneOne.entityName = "MedicalCertificateHospitalization";
			MedicalCertificateHospitalizationOneOne.oppositeName = "Registration";
			MedicalCertificateHospitalizationOneOne.name = "MedicalCertificateHospitalization";
			MedicalCertificateHospitalizationOneOne.optional = true;
			MedicalCertificateHospitalizationOneOne.type = "One";
			MedicalCertificateHospitalizationOneOne.oppositeType = "One";

		References.add(MedicalCertificateHospitalizationOneOne);

		var MedicalCertificateMedicalAttendanceOneOne = new EntityReference();
			MedicalCertificateMedicalAttendanceOneOne.entityName = "MedicalCertificateMedicalAttendance";
			MedicalCertificateMedicalAttendanceOneOne.oppositeName = "Registration";
			MedicalCertificateMedicalAttendanceOneOne.name = "MedicalCertificateMedicalAttendance";
			MedicalCertificateMedicalAttendanceOneOne.optional = true;
			MedicalCertificateMedicalAttendanceOneOne.type = "One";
			MedicalCertificateMedicalAttendanceOneOne.oppositeType = "One";

		References.add(MedicalCertificateMedicalAttendanceOneOne);

		var MedicalCertificateMentalHealthOneOne = new EntityReference();
			MedicalCertificateMentalHealthOneOne.entityName = "MedicalCertificateMentalHealth";
			MedicalCertificateMentalHealthOneOne.oppositeName = "Registration";
			MedicalCertificateMentalHealthOneOne.name = "MedicalCertificateMentalHealth";
			MedicalCertificateMentalHealthOneOne.optional = true;
			MedicalCertificateMentalHealthOneOne.type = "One";
			MedicalCertificateMentalHealthOneOne.oppositeType = "One";

		References.add(MedicalCertificateMentalHealthOneOne);

		var MedicalCertificatePhysicalHealthOneOne = new EntityReference();
			MedicalCertificatePhysicalHealthOneOne.entityName = "MedicalCertificatePhysicalHealth";
			MedicalCertificatePhysicalHealthOneOne.oppositeName = "Registration";
			MedicalCertificatePhysicalHealthOneOne.name = "MedicalCertificatePhysicalHealth";
			MedicalCertificatePhysicalHealthOneOne.optional = true;
			MedicalCertificatePhysicalHealthOneOne.type = "One";
			MedicalCertificatePhysicalHealthOneOne.oppositeType = "One";

		References.add(MedicalCertificatePhysicalHealthOneOne);

		var MedicalCertificateRestrictedWorkOneOne = new EntityReference();
			MedicalCertificateRestrictedWorkOneOne.entityName = "MedicalCertificateRestrictedWork";
			MedicalCertificateRestrictedWorkOneOne.oppositeName = "Registration";
			MedicalCertificateRestrictedWorkOneOne.name = "MedicalCertificateRestrictedWork";
			MedicalCertificateRestrictedWorkOneOne.optional = true;
			MedicalCertificateRestrictedWorkOneOne.type = "One";
			MedicalCertificateRestrictedWorkOneOne.oppositeType = "One";

		References.add(MedicalCertificateRestrictedWorkOneOne);

		var MedicalCertificateSickLeaveOneOne = new EntityReference();
			MedicalCertificateSickLeaveOneOne.entityName = "MedicalCertificateSickLeave";
			MedicalCertificateSickLeaveOneOne.oppositeName = "Registration";
			MedicalCertificateSickLeaveOneOne.name = "MedicalCertificateSickLeave";
			MedicalCertificateSickLeaveOneOne.optional = true;
			MedicalCertificateSickLeaveOneOne.type = "One";
			MedicalCertificateSickLeaveOneOne.oppositeType = "One";

		References.add(MedicalCertificateSickLeaveOneOne);

		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "Registration";
			MedicalExaminationRecordOneOne.name = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);

		var MedicalFeesOneMany = new EntityReference();
			MedicalFeesOneMany.entityName = "MedicalFee";
			MedicalFeesOneMany.oppositeName = "Registration";
			MedicalFeesOneMany.name = "MedicalFees";
			MedicalFeesOneMany.optional = true;
			MedicalFeesOneMany.type = "One";
			MedicalFeesOneMany.oppositeType = "Many";

		References.add(MedicalFeesOneMany);

		var MedicationHeadersOneMany = new EntityReference();
			MedicationHeadersOneMany.entityName = "MedicationHeader";
			MedicationHeadersOneMany.oppositeName = "Registration";
			MedicationHeadersOneMany.name = "MedicationHeaders";
			MedicationHeadersOneMany.optional = true;
			MedicationHeadersOneMany.type = "One";
			MedicationHeadersOneMany.oppositeType = "Many";

		References.add(MedicationHeadersOneMany);

		var PcareExaminationOneOne = new EntityReference();
			PcareExaminationOneOne.entityName = "PcareExamination";
			PcareExaminationOneOne.oppositeName = "Registration";
			PcareExaminationOneOne.name = "PcareExamination";
			PcareExaminationOneOne.optional = true;
			PcareExaminationOneOne.type = "One";
			PcareExaminationOneOne.oppositeType = "One";

		References.add(PcareExaminationOneOne);

		var PatientVitalInformationsOneMany = new EntityReference();
			PatientVitalInformationsOneMany.entityName = "PatientVitalInformation";
			PatientVitalInformationsOneMany.oppositeName = "Registration";
			PatientVitalInformationsOneMany.name = "PatientVitalInformations";
			PatientVitalInformationsOneMany.optional = true;
			PatientVitalInformationsOneMany.type = "One";
			PatientVitalInformationsOneMany.oppositeType = "Many";

		References.add(PatientVitalInformationsOneMany);

		var PrescriptionHeadersOneMany = new EntityReference();
			PrescriptionHeadersOneMany.entityName = "PrescriptionHeader";
			PrescriptionHeadersOneMany.oppositeName = "Registration";
			PrescriptionHeadersOneMany.name = "PrescriptionHeaders";
			PrescriptionHeadersOneMany.optional = true;
			PrescriptionHeadersOneMany.type = "One";
			PrescriptionHeadersOneMany.oppositeType = "Many";

		References.add(PrescriptionHeadersOneMany);

		var ReferringUnitOneMany = new EntityReference();
			ReferringUnitOneMany.entityName = "Service";
			ReferringUnitOneMany.oppositeName = "ReferringUnit";
			ReferringUnitOneMany.name = "ReferringUnit";
			ReferringUnitOneMany.optional = true;
			ReferringUnitOneMany.type = "One";
			ReferringUnitOneMany.oppositeType = "Many";

		References.add(ReferringUnitOneMany);

		var ReferringFacilityOneMany = new EntityReference();
			ReferringFacilityOneMany.entityName = "HealthFacility";
			ReferringFacilityOneMany.oppositeName = "ReferringFacility";
			ReferringFacilityOneMany.name = "ReferringFacility";
			ReferringFacilityOneMany.optional = true;
			ReferringFacilityOneMany.type = "One";
			ReferringFacilityOneMany.oppositeType = "Many";

		References.add(ReferringFacilityOneMany);

		var DiagnosticStaffExaminationSummaryOneOne = new EntityReference();
			DiagnosticStaffExaminationSummaryOneOne.entityName = "DiagnosticStaffExaminationSummary";
			DiagnosticStaffExaminationSummaryOneOne.oppositeName = "DiagnosticStaffExaminationSummary";
			DiagnosticStaffExaminationSummaryOneOne.name = "Registration";
			DiagnosticStaffExaminationSummaryOneOne.optional = true;
			DiagnosticStaffExaminationSummaryOneOne.type = "One";
			DiagnosticStaffExaminationSummaryOneOne.oppositeType = "One";

		References.add(DiagnosticStaffExaminationSummaryOneOne);

		var BedFacilityOneMany = new EntityReference();
			BedFacilityOneMany.entityName = "BedFacility";
			BedFacilityOneMany.oppositeName = "BedFacility";
			BedFacilityOneMany.name = "Registrations";
			BedFacilityOneMany.optional = true;
			BedFacilityOneMany.type = "One";
			BedFacilityOneMany.oppositeType = "Many";

		References.add(BedFacilityOneMany);

		var ExaminationItemsManyMany = new EntityReference();
			ExaminationItemsManyMany.entityName = "ExaminationItem";
			ExaminationItemsManyMany.oppositeName = "ExaminationItems";
			ExaminationItemsManyMany.name = "Registrations";
			ExaminationItemsManyMany.optional = true;
			ExaminationItemsManyMany.type = "Many";
			ExaminationItemsManyMany.oppositeType = "Many";

		References.add(ExaminationItemsManyMany);

		var PatientVisitOneMany = new EntityReference();
			PatientVisitOneMany.entityName = "PatientVisit";
			PatientVisitOneMany.oppositeName = "PatientVisit";
			PatientVisitOneMany.name = "Registrations";
			PatientVisitOneMany.optional = true;
			PatientVisitOneMany.type = "One";
			PatientVisitOneMany.oppositeType = "Many";

		References.add(PatientVisitOneMany);

		var ServiceOneMany = new EntityReference();
			ServiceOneMany.entityName = "Service";
			ServiceOneMany.oppositeName = "Service";
			ServiceOneMany.name = "Registrations";
			ServiceOneMany.optional = true;
			ServiceOneMany.type = "One";
			ServiceOneMany.oppositeType = "Many";

		References.add(ServiceOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "Registrations";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);

		var RequestedByOneMany = new EntityReference();
			RequestedByOneMany.entityName = "Staff";
			RequestedByOneMany.oppositeName = "RequestedBy";
			RequestedByOneMany.name = "RequestedBy";
			RequestedByOneMany.optional = true;
			RequestedByOneMany.type = "One";
			RequestedByOneMany.oppositeType = "Many";

		References.add(RequestedByOneMany);

		var SepOneOne = new EntityReference();
			SepOneOne.entityName = "Sep";
			SepOneOne.oppositeName = "Registration";
			SepOneOne.name = "Sep";
			SepOneOne.optional = true;
			SepOneOne.type = "One";
			SepOneOne.oppositeType = "One";

		References.add(SepOneOne);

		var SampleCollectionInformationsOneMany = new EntityReference();
			SampleCollectionInformationsOneMany.entityName = "SampleCollectionInformation";
			SampleCollectionInformationsOneMany.oppositeName = "Registration";
			SampleCollectionInformationsOneMany.name = "SampleCollectionInformations";
			SampleCollectionInformationsOneMany.optional = true;
			SampleCollectionInformationsOneMany.type = "One";
			SampleCollectionInformationsOneMany.oppositeType = "Many";

		References.add(SampleCollectionInformationsOneMany);

		var VaccinationOrdersOneMany = new EntityReference();
			VaccinationOrdersOneMany.entityName = "VaccinationOrder";
			VaccinationOrdersOneMany.oppositeName = "Registration";
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

	// % protected region % [Modify attribute annotation for Registration Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Number here] end
	private String registrationNumber;

	// % protected region % [Modify attribute annotation for Scheduled Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Scheduled Date here] end
	private OffsetDateTime scheduledDate;

	// % protected region % [Modify attribute annotation for Actual In Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Actual In Date here] end
	private OffsetDateTime actualInDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Dismissal Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Type here] end
	private String dismissalType;

	// % protected region % [Modify attribute annotation for Queue No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Queue No here] end
	private Integer queueNo;

	// % protected region % [Modify attribute annotation for Duration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Duration here] end
	private Integer duration;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Booked Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Booked Treatment Class here] end
	private String bookedTreatmentClass;

	// % protected region % [Modify attribute annotation for Shift here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shift here] end
	private String shift;

	// % protected region % [Modify attribute annotation for CITO here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for CITO here] end
	private Boolean cito;

	// % protected region % [Modify attribute annotation for One Day Care here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for One Day Care here] end
	private Boolean oneDayCare;

	// % protected region % [Modify attribute annotation for Referral here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral here] end
	private Boolean referral;

	// % protected region % [Modify attribute annotation for Registration Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Status here] end
	private String registrationStatus;

	// % protected region % [Modify attribute annotation for Referral Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral Type here] end
	private String referralType;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Referral Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral Notes here] end
	private String referralNotes;

	// % protected region % [Modify attribute annotation for Admission Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Admission Diagnosis here] end
	private String admissionDiagnosis;

	// % protected region % [Modify attribute annotation for Uploaded Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Uploaded Date Time here] end
	private OffsetDateTime uploadedDateTime;

	// % protected region % [Modify attribute annotation for Visit Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Status here] end
	private String visitStatus;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for is An Appointment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for is An Appointment here] end
	private Boolean isAnAppointment;

	// % protected region % [Modify attribute annotation for Referral Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral Number here] end
	private String referralNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for kodepoli here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for Death Certificate No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Death Certificate No here] end
	private String deathCertificateNo;

	// % protected region % [Modify attribute annotation for Time Of Death here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Time Of Death here] end
	private OffsetDateTime timeOfDeath;

	// % protected region % [Modify attribute annotation for Dismissal Referral here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Referral here] end
	private Boolean dismissalReferral;

	// % protected region % [Modify attribute annotation for Dismissal Referral Detail here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Referral Detail here] end
	private String dismissalReferralDetail;

	// % protected region % [Modify attribute annotation for Dismissal Referral Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Referral Type here] end
	private String dismissalReferralType;

	// % protected region % [Modify attribute annotation for Dismissal Referring Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Referring Notes here] end
	private String dismissalReferringNotes;

	// % protected region % [Modify attribute annotation for Patient Is Referred Back here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Is Referred Back here] end
	private Boolean patientIsReferredBack;

	// % protected region % [Modify attribute annotation for MCU Package here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for MCU Package here] end
	private String mcuPackage;

	// % protected region % [Modify attribute annotation for Parent Registration Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Parent Registration Number here] end
	private String parentRegistrationNumber;

	// % protected region % [Modify attribute annotation for Is Unknown Patient here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Unknown Patient here] end
	private Boolean isUnknownPatient;

	// % protected region % [Modify attribute annotation for Other Referred Facility here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Referred Facility here] end
	private String otherReferredFacility;

	// % protected region % [Modify attribute annotation for Other Referred Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Referred Staff here] end
	private String otherReferredStaff;

	private Set<FileEntity> supportingDocument = new HashSet<>();

	private Set<FileEntity> printWristband = new HashSet<>();

	private Set<FileEntity> printLabel = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsPRBDetailEntity bpjsPRBDetail;

	private BpjsPcareRegistrationsEntity bpjsPcareRegistrations;

	private BpjsSEPEntity bpjsSEP;

	private MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResume;

	private MedicalCertificateBirthEntity medicalCertificateBirth;

	private MedicalCertificateHospitalizationEntity medicalCertificateHospitalization;

	private MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendance;

	private MedicalCertificateMentalHealthEntity medicalCertificateMentalHealth;

	private MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealth;

	private MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWork;

	private MedicalCertificateSickLeaveEntity medicalCertificateSickLeave;

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private PcareExaminationEntity pcareExamination;

	private SepEntity sep;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	private Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();

	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<MedicalFeeEntity> medicalFees = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private Set<SampleCollectionInformationEntity> sampleCollectionInformations = new HashSet<>();

	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosesAndProceduresEntity admissionICD10;

	private DiagnosesAndProceduresEntity admissionICD9CM;

	private HealthFacilityEntity dismissalReferringFacility;

	private StaffEntity dismissalReferringStaff;

	private ServiceEntity referringUnit;

	private HealthFacilityEntity referringFacility;

	private BedFacilityEntity bedFacility;

	private PatientVisitEntity patientVisit;

	private ServiceEntity service;

	private StaffEntity staff;

	private StaffEntity requestedBy;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsPRBDetail(BpjsPRBDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setBpjsPRBDetail(@NonNull BpjsPRBDetailEntity entity) {
		setBpjsPRBDetail(entity, true);
	}

	/**
	 * Set or update bpjsPRBDetail with the given BpjsPRBDetailEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPRBDetail(@NonNull BpjsPRBDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPRBDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPRBDetail here] end

		if (sameAsFormer(this.bpjsPRBDetail, entity)) {
			return;
		}

		if (this.bpjsPRBDetail != null) {
			this.bpjsPRBDetail.unsetRegistration();
		}

		this.bpjsPRBDetail = entity;

		if (reverseAdd) {
			this.bpjsPRBDetail.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPRBDetail outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPRBDetail outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBDetail(boolean)} but default to true.
	 */
	public void unsetBpjsPRBDetail() {
		this.unsetBpjsPRBDetail(true);
	}

	/**
	 * Remove the BpjsPRBDetailEntity in BPJS PRB Detail from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPRBDetail(boolean reverse) {
		if (reverse && this.bpjsPRBDetail != null) {
			this.bpjsPRBDetail.unsetRegistration(false);
		}
		this.bpjsPRBDetail = null;
	}

	/**
	 * Similar to {@link this#setBpjsPcareRegistrations(BpjsPcareRegistrationsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setBpjsPcareRegistrations(@NonNull BpjsPcareRegistrationsEntity entity) {
		setBpjsPcareRegistrations(entity, true);
	}

	/**
	 * Set or update bpjsPcareRegistrations with the given BpjsPcareRegistrationsEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareRegistrations(@NonNull BpjsPcareRegistrationsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] end

		if (sameAsFormer(this.bpjsPcareRegistrations, entity)) {
			return;
		}

		if (this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetRegistration();
		}

		this.bpjsPcareRegistrations = entity;

		if (reverseAdd) {
			this.bpjsPcareRegistrations.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcareRegistrations(boolean)} but default to true.
	 */
	public void unsetBpjsPcareRegistrations() {
		this.unsetBpjsPcareRegistrations(true);
	}

	/**
	 * Remove the BpjsPcareRegistrationsEntity in BPJS Pcare Registrations from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcareRegistrations(boolean reverse) {
		if (reverse && this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetRegistration(false);
		}
		this.bpjsPcareRegistrations = null;
	}

	/**
	 * Similar to {@link this#setBpjsSEP(BpjsSEPEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setBpjsSEP(@NonNull BpjsSEPEntity entity) {
		setBpjsSEP(entity, true);
	}

	/**
	 * Set or update bpjsSEP with the given BpjsSEPEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsSEP(@NonNull BpjsSEPEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsSEP here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsSEP here] end

		if (sameAsFormer(this.bpjsSEP, entity)) {
			return;
		}

		if (this.bpjsSEP != null) {
			this.bpjsSEP.unsetRegistration();
		}

		this.bpjsSEP = entity;

		if (reverseAdd) {
			this.bpjsSEP.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsSEP outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsSEP outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsSEP(boolean)} but default to true.
	 */
	public void unsetBpjsSEP() {
		this.unsetBpjsSEP(true);
	}

	/**
	 * Remove the BpjsSEPEntity in BPJS SEP from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsSEP(boolean reverse) {
		if (reverse && this.bpjsSEP != null) {
			this.bpjsSEP.unsetRegistration(false);
		}
		this.bpjsSEP = null;
	}

/**
	 * Similar to {@link this#addBedReserves(BedReserveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedReserveEntity to be added to this entity
	 */
	public void addBedReserves(@NonNull BedReserveEntity entity) {
		addBedReserves(entity, true);
	}

	/**
	 * Add a new BedReserveEntity to bedReserves in this entity.
	 *
	 * @param entity the given BedReserveEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBedReserves(@NonNull BedReserveEntity entity, boolean reverseAdd) {
		if (!this.bedReserves.contains(entity)) {
			bedReserves.add(entity);
			if (reverseAdd) {
				entity.setRegistration(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBedReserves(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedReserveEntity to be added to this entity
	 */
	public void addBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		addBedReserves(entities, true);
	}

	/**
	 * Add a new collection of BedReserveEntity to Bed Reserves in this entity.
	 *
	 * @param entities the given collection of BedReserveEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBedReserves(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBedReserves(BedReserveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedReserveEntity to be set to this entity
	 */
	public void removeBedReserves(@NonNull BedReserveEntity entity) {
		this.removeBedReserves(entity, true);
	}

	/**
	 * Remove the given BedReserveEntity from this entity.
	 *
	 * @param entity the given BedReserveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedReserves(@NonNull BedReserveEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRegistration(false);
		}
		this.bedReserves.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBedReserves(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BedReserveEntity to be removed to this entity
	 */
	public void removeBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		this.removeBedReserves(entities, true);
	}

	/**
	 * Remove the given collection of BedReserveEntity from  to this entity.
	 *
	 * @param entities the given collection of BedReserveEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBedReserves(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBedReserves(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedReserveEntity to be set to this entity
	 */
	public void setBedReserves(@NonNull Collection<BedReserveEntity> entities) {
		setBedReserves(entities, true);
	}

	/**
	 * Replace the current entities in Bed Reserves with the given ones.
	 *
	 * @param entities the given collection of BedReserveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedReserves(@NonNull Collection<BedReserveEntity> entities, boolean reverseAdd) {

		this.unsetBedReserves();
		this.bedReserves = new HashSet<>(entities);
		if (reverseAdd) {
			this.bedReserves.forEach(bedReservesEntity -> bedReservesEntity.setRegistration(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBedReserves(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBedReserves() {
		this.unsetBedReserves(true);
	}

	/**
	 * Remove all the entities in Bed Reserves from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBedReserves(boolean doReverse) {
		if (doReverse) {
			this.bedReserves.forEach(bedReservesEntity -> bedReservesEntity.unsetRegistration(false));
		}
		this.bedReserves.clear();
	}

/**
	 * Similar to {@link this#addDiagnosticExaminationResults(DiagnosticExaminationResultsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be added to this entity
	 */
	public void addDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity) {
		addDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Add a new DiagnosticExaminationResultsEntity to diagnosticExaminationResults in this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity, boolean reverseAdd) {
		if (!this.diagnosticExaminationResults.contains(entity)) {
			diagnosticExaminationResults.add(entity);
			if (reverseAdd) {
				entity.setRegistration(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be added to this entity
	 */
	public void addDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
		addDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Add a new collection of DiagnosticExaminationResultsEntity to Diagnostic Examination Results in this entity.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosticExaminationResults(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosticExaminationResults(DiagnosticExaminationResultsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be set to this entity
	 */
	public void removeDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity) {
		this.removeDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Remove the given DiagnosticExaminationResultsEntity from this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticExaminationResults(@NonNull DiagnosticExaminationResultsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRegistration(false);
		}
		this.diagnosticExaminationResults.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be removed to this entity
	 */
	public void removeDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
		this.removeDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosticExaminationResultsEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosticExaminationResults(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosticExaminationResults(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to be set to this entity
	 */
	public void setDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities) {
		setDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Examination Results with the given ones.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticExaminationResults(@NonNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosticExaminationResults();
		this.diagnosticExaminationResults = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosticExaminationResults.forEach(diagnosticExaminationResultsEntity -> diagnosticExaminationResultsEntity.setRegistration(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosticExaminationResults(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosticExaminationResults() {
		this.unsetDiagnosticExaminationResults(true);
	}

	/**
	 * Remove all the entities in Diagnostic Examination Results from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosticExaminationResults(boolean doReverse) {
		if (doReverse) {
			this.diagnosticExaminationResults.forEach(diagnosticExaminationResultsEntity -> diagnosticExaminationResultsEntity.unsetRegistration(false));
		}
		this.diagnosticExaminationResults.clear();
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
				entity.setRegistration(this, false);
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
			entity.unsetRegistration(false);
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
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.setRegistration(this, false));
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
			this.fluidBalanceDetails.forEach(fluidBalanceDetailsEntity -> fluidBalanceDetailsEntity.unsetRegistration(false));
		}
		this.fluidBalanceDetails.clear();
	}

/**
	 * Similar to {@link this#addInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NonNull InformedConsentEntity entity) {
		addInformedConsents(entity, true);
	}

	/**
	 * Add a new InformedConsentEntity to informedConsents in this entity.
	 *
	 * @param entity the given InformedConsentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInformedConsents(@NonNull InformedConsentEntity entity, boolean reverseAdd) {
		if (!this.informedConsents.contains(entity)) {
			informedConsents.add(entity);
			if (reverseAdd) {
				entity.setRegistration(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 */
	public void addInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		addInformedConsents(entities, true);
	}

	/**
	 * Add a new collection of InformedConsentEntity to Informed Consents in this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInformedConsents(InformedConsentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InformedConsentEntity to be set to this entity
	 */
	public void removeInformedConsents(@NonNull InformedConsentEntity entity) {
		this.removeInformedConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformedConsents(@NonNull InformedConsentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRegistration(false);
		}
		this.informedConsents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInformedConsents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 */
	public void removeInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		this.removeInformedConsents(entities, true);
	}

	/**
	 * Remove the given collection of InformedConsentEntity from  to this entity.
	 *
	 * @param entities the given collection of InformedConsentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInformedConsents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInformedConsents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InformedConsentEntity to be set to this entity
	 */
	public void setInformedConsents(@NonNull Collection<InformedConsentEntity> entities) {
		setInformedConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informed Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformedConsents(@NonNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

		this.unsetInformedConsents();
		this.informedConsents = new HashSet<>(entities);
		if (reverseAdd) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.setRegistration(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInformedConsents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInformedConsents() {
		this.unsetInformedConsents(true);
	}

	/**
	 * Remove all the entities in Informed Consents from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInformedConsents(boolean doReverse) {
		if (doReverse) {
			this.informedConsents.forEach(informedConsentsEntity -> informedConsentsEntity.unsetRegistration(false));
		}
		this.informedConsents.clear();
	}

/**
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setServiceNumber(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetServiceNumber(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setServiceNumber(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetServiceNumber(false));
		}
		this.invoiceItems.clear();
	}

	/**
	 * Similar to {@link this#setMedicalCertificateDischargeResume(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateDischargeResume(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		setMedicalCertificateDischargeResume(entity, true);
	}

	/**
	 * Set or update medicalCertificateDischargeResume with the given MedicalCertificateDischargeResumeEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateDischargeResume(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateDischargeResume here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateDischargeResume here] end

		if (sameAsFormer(this.medicalCertificateDischargeResume, entity)) {
			return;
		}

		if (this.medicalCertificateDischargeResume != null) {
			this.medicalCertificateDischargeResume.unsetRegistration();
		}

		this.medicalCertificateDischargeResume = entity;

		if (reverseAdd) {
			this.medicalCertificateDischargeResume.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateDischargeResume outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateDischargeResume outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateDischargeResume(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateDischargeResume() {
		this.unsetMedicalCertificateDischargeResume(true);
	}

	/**
	 * Remove the MedicalCertificateDischargeResumeEntity in Medical Certificate  Discharge Resume from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateDischargeResume(boolean reverse) {
		if (reverse && this.medicalCertificateDischargeResume != null) {
			this.medicalCertificateDischargeResume.unsetRegistration(false);
		}
		this.medicalCertificateDischargeResume = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateBirth(MedicalCertificateBirthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateBirth(@NonNull MedicalCertificateBirthEntity entity) {
		setMedicalCertificateBirth(entity, true);
	}

	/**
	 * Set or update medicalCertificateBirth with the given MedicalCertificateBirthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateBirth(@NonNull MedicalCertificateBirthEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateBirth here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateBirth here] end

		if (sameAsFormer(this.medicalCertificateBirth, entity)) {
			return;
		}

		if (this.medicalCertificateBirth != null) {
			this.medicalCertificateBirth.unsetRegistration();
		}

		this.medicalCertificateBirth = entity;

		if (reverseAdd) {
			this.medicalCertificateBirth.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateBirth outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateBirth outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateBirth(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateBirth() {
		this.unsetMedicalCertificateBirth(true);
	}

	/**
	 * Remove the MedicalCertificateBirthEntity in Medical Certificate Birth from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateBirth(boolean reverse) {
		if (reverse && this.medicalCertificateBirth != null) {
			this.medicalCertificateBirth.unsetRegistration(false);
		}
		this.medicalCertificateBirth = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateHospitalization(MedicalCertificateHospitalizationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateHospitalization(@NonNull MedicalCertificateHospitalizationEntity entity) {
		setMedicalCertificateHospitalization(entity, true);
	}

	/**
	 * Set or update medicalCertificateHospitalization with the given MedicalCertificateHospitalizationEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateHospitalization(@NonNull MedicalCertificateHospitalizationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateHospitalization here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateHospitalization here] end

		if (sameAsFormer(this.medicalCertificateHospitalization, entity)) {
			return;
		}

		if (this.medicalCertificateHospitalization != null) {
			this.medicalCertificateHospitalization.unsetRegistration();
		}

		this.medicalCertificateHospitalization = entity;

		if (reverseAdd) {
			this.medicalCertificateHospitalization.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateHospitalization outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateHospitalization outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateHospitalization(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateHospitalization() {
		this.unsetMedicalCertificateHospitalization(true);
	}

	/**
	 * Remove the MedicalCertificateHospitalizationEntity in Medical Certificate Hospitalization from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateHospitalization(boolean reverse) {
		if (reverse && this.medicalCertificateHospitalization != null) {
			this.medicalCertificateHospitalization.unsetRegistration(false);
		}
		this.medicalCertificateHospitalization = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateMedicalAttendance(MedicalCertificateMedicalAttendanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateMedicalAttendance(@NonNull MedicalCertificateMedicalAttendanceEntity entity) {
		setMedicalCertificateMedicalAttendance(entity, true);
	}

	/**
	 * Set or update medicalCertificateMedicalAttendance with the given MedicalCertificateMedicalAttendanceEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateMedicalAttendance(@NonNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateMedicalAttendance here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateMedicalAttendance here] end

		if (sameAsFormer(this.medicalCertificateMedicalAttendance, entity)) {
			return;
		}

		if (this.medicalCertificateMedicalAttendance != null) {
			this.medicalCertificateMedicalAttendance.unsetRegistration();
		}

		this.medicalCertificateMedicalAttendance = entity;

		if (reverseAdd) {
			this.medicalCertificateMedicalAttendance.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateMedicalAttendance outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateMedicalAttendance outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateMedicalAttendance(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateMedicalAttendance() {
		this.unsetMedicalCertificateMedicalAttendance(true);
	}

	/**
	 * Remove the MedicalCertificateMedicalAttendanceEntity in Medical Certificate Medical Attendance from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateMedicalAttendance(boolean reverse) {
		if (reverse && this.medicalCertificateMedicalAttendance != null) {
			this.medicalCertificateMedicalAttendance.unsetRegistration(false);
		}
		this.medicalCertificateMedicalAttendance = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateMentalHealth(MedicalCertificateMentalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateMentalHealth(@NonNull MedicalCertificateMentalHealthEntity entity) {
		setMedicalCertificateMentalHealth(entity, true);
	}

	/**
	 * Set or update medicalCertificateMentalHealth with the given MedicalCertificateMentalHealthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateMentalHealth(@NonNull MedicalCertificateMentalHealthEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateMentalHealth here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateMentalHealth here] end

		if (sameAsFormer(this.medicalCertificateMentalHealth, entity)) {
			return;
		}

		if (this.medicalCertificateMentalHealth != null) {
			this.medicalCertificateMentalHealth.unsetRegistration();
		}

		this.medicalCertificateMentalHealth = entity;

		if (reverseAdd) {
			this.medicalCertificateMentalHealth.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateMentalHealth outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateMentalHealth outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateMentalHealth(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateMentalHealth() {
		this.unsetMedicalCertificateMentalHealth(true);
	}

	/**
	 * Remove the MedicalCertificateMentalHealthEntity in Medical Certificate Mental Health from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateMentalHealth(boolean reverse) {
		if (reverse && this.medicalCertificateMentalHealth != null) {
			this.medicalCertificateMentalHealth.unsetRegistration(false);
		}
		this.medicalCertificateMentalHealth = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificatePhysicalHealth(MedicalCertificatePhysicalHealthEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificatePhysicalHealth(@NonNull MedicalCertificatePhysicalHealthEntity entity) {
		setMedicalCertificatePhysicalHealth(entity, true);
	}

	/**
	 * Set or update medicalCertificatePhysicalHealth with the given MedicalCertificatePhysicalHealthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificatePhysicalHealth(@NonNull MedicalCertificatePhysicalHealthEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificatePhysicalHealth here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificatePhysicalHealth here] end

		if (sameAsFormer(this.medicalCertificatePhysicalHealth, entity)) {
			return;
		}

		if (this.medicalCertificatePhysicalHealth != null) {
			this.medicalCertificatePhysicalHealth.unsetRegistration();
		}

		this.medicalCertificatePhysicalHealth = entity;

		if (reverseAdd) {
			this.medicalCertificatePhysicalHealth.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificatePhysicalHealth outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificatePhysicalHealth outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificatePhysicalHealth(boolean)} but default to true.
	 */
	public void unsetMedicalCertificatePhysicalHealth() {
		this.unsetMedicalCertificatePhysicalHealth(true);
	}

	/**
	 * Remove the MedicalCertificatePhysicalHealthEntity in Medical Certificate Physical Health from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificatePhysicalHealth(boolean reverse) {
		if (reverse && this.medicalCertificatePhysicalHealth != null) {
			this.medicalCertificatePhysicalHealth.unsetRegistration(false);
		}
		this.medicalCertificatePhysicalHealth = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateRestrictedWork(MedicalCertificateRestrictedWorkEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateRestrictedWork(@NonNull MedicalCertificateRestrictedWorkEntity entity) {
		setMedicalCertificateRestrictedWork(entity, true);
	}

	/**
	 * Set or update medicalCertificateRestrictedWork with the given MedicalCertificateRestrictedWorkEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateRestrictedWork(@NonNull MedicalCertificateRestrictedWorkEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateRestrictedWork here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateRestrictedWork here] end

		if (sameAsFormer(this.medicalCertificateRestrictedWork, entity)) {
			return;
		}

		if (this.medicalCertificateRestrictedWork != null) {
			this.medicalCertificateRestrictedWork.unsetRegistration();
		}

		this.medicalCertificateRestrictedWork = entity;

		if (reverseAdd) {
			this.medicalCertificateRestrictedWork.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateRestrictedWork outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateRestrictedWork outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateRestrictedWork(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateRestrictedWork() {
		this.unsetMedicalCertificateRestrictedWork(true);
	}

	/**
	 * Remove the MedicalCertificateRestrictedWorkEntity in Medical Certificate Restricted Work from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateRestrictedWork(boolean reverse) {
		if (reverse && this.medicalCertificateRestrictedWork != null) {
			this.medicalCertificateRestrictedWork.unsetRegistration(false);
		}
		this.medicalCertificateRestrictedWork = null;
	}

	/**
	 * Similar to {@link this#setMedicalCertificateSickLeave(MedicalCertificateSickLeaveEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalCertificateSickLeave(@NonNull MedicalCertificateSickLeaveEntity entity) {
		setMedicalCertificateSickLeave(entity, true);
	}

	/**
	 * Set or update medicalCertificateSickLeave with the given MedicalCertificateSickLeaveEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateSickLeave(@NonNull MedicalCertificateSickLeaveEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateSickLeave here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalCertificateSickLeave here] end

		if (sameAsFormer(this.medicalCertificateSickLeave, entity)) {
			return;
		}

		if (this.medicalCertificateSickLeave != null) {
			this.medicalCertificateSickLeave.unsetRegistration();
		}

		this.medicalCertificateSickLeave = entity;

		if (reverseAdd) {
			this.medicalCertificateSickLeave.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateSickLeave outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalCertificateSickLeave outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalCertificateSickLeave(boolean)} but default to true.
	 */
	public void unsetMedicalCertificateSickLeave() {
		this.unsetMedicalCertificateSickLeave(true);
	}

	/**
	 * Remove the MedicalCertificateSickLeaveEntity in Medical Certificate Sick Leave from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalCertificateSickLeave(boolean reverse) {
		if (reverse && this.medicalCertificateSickLeave != null) {
			this.medicalCertificateSickLeave.unsetRegistration(false);
		}
		this.medicalCertificateSickLeave = null;
	}

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecord with the given MedicalExaminationRecordEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetRegistration();
		}

		this.medicalExaminationRecord = entity;

		if (reverseAdd) {
			this.medicalExaminationRecord.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity in Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetRegistration(false);
		}
		this.medicalExaminationRecord = null;
	}

/**
	 * Similar to {@link this#addMedicalFees(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be added to this entity
	 */
	public void addMedicalFees(@NonNull MedicalFeeEntity entity) {
		addMedicalFees(entity, true);
	}

	/**
	 * Add a new MedicalFeeEntity to medicalFees in this entity.
	 *
	 * @param entity the given MedicalFeeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalFees(@NonNull MedicalFeeEntity entity, boolean reverseAdd) {
		if (!this.medicalFees.contains(entity)) {
			medicalFees.add(entity);
			if (reverseAdd) {
				entity.setRegistration(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be added to this entity
	 */
	public void addMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		addMedicalFees(entities, true);
	}

	/**
	 * Add a new collection of MedicalFeeEntity to Medical Fees in this entity.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalFees(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be set to this entity
	 */
	public void removeMedicalFees(@NonNull MedicalFeeEntity entity) {
		this.removeMedicalFees(entity, true);
	}

	/**
	 * Remove the given MedicalFeeEntity from this entity.
	 *
	 * @param entity the given MedicalFeeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFees(@NonNull MedicalFeeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRegistration(false);
		}
		this.medicalFees.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalFees(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be removed to this entity
	 */
	public void removeMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		this.removeMedicalFees(entities, true);
	}

	/**
	 * Remove the given collection of MedicalFeeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be set to this entity
	 */
	public void setMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		setMedicalFees(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fees with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {

		this.unsetMedicalFees();
		this.medicalFees = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalFees.forEach(medicalFeesEntity -> medicalFeesEntity.setRegistration(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalFees(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalFees() {
		this.unsetMedicalFees(true);
	}

	/**
	 * Remove all the entities in Medical Fees from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalFees(boolean doReverse) {
		if (doReverse) {
			this.medicalFees.forEach(medicalFeesEntity -> medicalFeesEntity.unsetRegistration(false));
		}
		this.medicalFees.clear();
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
				entity.setRegistration(this, false);
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
			entity.unsetRegistration(false);
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
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.setRegistration(this, false));
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
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.unsetRegistration(false));
		}
		this.medicationHeaders.clear();
	}

	/**
	 * Similar to {@link this#setPcareExamination(PcareExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity) {
		setPcareExamination(entity, true);
	}

	/**
	 * Set or update pcareExamination with the given PcareExaminationEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] end

		if (sameAsFormer(this.pcareExamination, entity)) {
			return;
		}

		if (this.pcareExamination != null) {
			this.pcareExamination.unsetRegistration();
		}

		this.pcareExamination = entity;

		if (reverseAdd) {
			this.pcareExamination.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPcareExamination(boolean)} but default to true.
	 */
	public void unsetPcareExamination() {
		this.unsetPcareExamination(true);
	}

	/**
	 * Remove the PcareExaminationEntity in PCare Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareExamination(boolean reverse) {
		if (reverse && this.pcareExamination != null) {
			this.pcareExamination.unsetRegistration(false);
		}
		this.pcareExamination = null;
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
				entity.setRegistration(this, false);
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
			entity.unsetRegistration(false);
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
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.setRegistration(this, false));
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
			this.patientVitalInformations.forEach(patientVitalInformationsEntity -> patientVitalInformationsEntity.unsetRegistration(false));
		}
		this.patientVitalInformations.clear();
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
				entity.setRegistration(this, false);
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
			entity.unsetRegistration(false);
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
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.setRegistration(this, false));
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
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.unsetRegistration(false));
		}
		this.prescriptionHeaders.clear();
	}

	/**
	 * Similar to {@link this#setSep(SepEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setSep(@NonNull SepEntity entity) {
		setSep(entity, true);
	}

	/**
	 * Set or update sep with the given SepEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSep(@NonNull SepEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSep here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSep here] end

		if (sameAsFormer(this.sep, entity)) {
			return;
		}

		if (this.sep != null) {
			this.sep.unsetRegistration();
		}

		this.sep = entity;

		if (reverseAdd) {
			this.sep.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSep outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSep outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetSep(boolean)} but default to true.
	 */
	public void unsetSep() {
		this.unsetSep(true);
	}

	/**
	 * Remove the SepEntity in SEP from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSep(boolean reverse) {
		if (reverse && this.sep != null) {
			this.sep.unsetRegistration(false);
		}
		this.sep = null;
	}

/**
	 * Similar to {@link this#addSampleCollectionInformations(SampleCollectionInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be added to this entity
	 */
	public void addSampleCollectionInformations(@NonNull SampleCollectionInformationEntity entity) {
		addSampleCollectionInformations(entity, true);
	}

	/**
	 * Add a new SampleCollectionInformationEntity to sampleCollectionInformations in this entity.
	 *
	 * @param entity the given SampleCollectionInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleCollectionInformations(@NonNull SampleCollectionInformationEntity entity, boolean reverseAdd) {
		if (!this.sampleCollectionInformations.contains(entity)) {
			sampleCollectionInformations.add(entity);
			if (reverseAdd) {
				entity.setRegistration(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleCollectionInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to be added to this entity
	 */
	public void addSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities) {
		addSampleCollectionInformations(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionInformationEntity to Sample Collection Informations in this entity.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleCollectionInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleCollectionInformations(SampleCollectionInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be set to this entity
	 */
	public void removeSampleCollectionInformations(@NonNull SampleCollectionInformationEntity entity) {
		this.removeSampleCollectionInformations(entity, true);
	}

	/**
	 * Remove the given SampleCollectionInformationEntity from this entity.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionInformations(@NonNull SampleCollectionInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRegistration(false);
		}
		this.sampleCollectionInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleCollectionInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to be removed to this entity
	 */
	public void removeSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities) {
		this.removeSampleCollectionInformations(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleCollectionInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleCollectionInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to be set to this entity
	 */
	public void setSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities) {
		setSampleCollectionInformations(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Informations with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionInformations(@NonNull Collection<SampleCollectionInformationEntity> entities, boolean reverseAdd) {

		this.unsetSampleCollectionInformations();
		this.sampleCollectionInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleCollectionInformations.forEach(sampleCollectionInformationsEntity -> sampleCollectionInformationsEntity.setRegistration(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleCollectionInformations() {
		this.unsetSampleCollectionInformations(true);
	}

	/**
	 * Remove all the entities in Sample Collection Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleCollectionInformations(boolean doReverse) {
		if (doReverse) {
			this.sampleCollectionInformations.forEach(sampleCollectionInformationsEntity -> sampleCollectionInformationsEntity.unsetRegistration(false));
		}
		this.sampleCollectionInformations.clear();
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
				entity.setRegistration(this, false);
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
			entity.unsetRegistration(false);
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
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.setRegistration(this, false));
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
			this.vaccinationOrders.forEach(vaccinationOrdersEntity -> vaccinationOrdersEntity.unsetRegistration(false));
		}
		this.vaccinationOrders.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setAdmissionICD10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setAdmissionICD10(@NonNull DiagnosesAndProceduresEntity entity) {
		setAdmissionICD10(entity, true);
	}

	/**
	 * Set or update the admissionICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to admissionICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdmissionICD10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdmissionICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdmissionICD10 here] end

		if (sameAsFormer(this.admissionICD10, entity)) {
			return;
		}

		if (this.admissionICD10 != null) {
			this.admissionICD10.removeAdmissionICD10(this, false);
		}
		this.admissionICD10 = entity;
		if (reverseAdd) {
			this.admissionICD10.addAdmissionICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdmissionICD10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdmissionICD10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdmissionICD10(boolean)} but default to true.
	 */
	public void unsetAdmissionICD10() {
		this.unsetAdmissionICD10(true);
	}

	/**
	 * Remove Admission ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdmissionICD10(boolean reverse) {
		if (reverse && this.admissionICD10 != null) {
			this.admissionICD10.removeAdmissionICD10(this, false);
		}
		this.admissionICD10 = null;
	}
	/**
	 * Similar to {@link this#setAdmissionICD9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setAdmissionICD9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setAdmissionICD9CM(entity, true);
	}

	/**
	 * Set or update the admissionICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to admissionICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdmissionICD9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdmissionICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdmissionICD9CM here] end

		if (sameAsFormer(this.admissionICD9CM, entity)) {
			return;
		}

		if (this.admissionICD9CM != null) {
			this.admissionICD9CM.removeAdmissionICD9CM(this, false);
		}
		this.admissionICD9CM = entity;
		if (reverseAdd) {
			this.admissionICD9CM.addAdmissionICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdmissionICD9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdmissionICD9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdmissionICD9CM(boolean)} but default to true.
	 */
	public void unsetAdmissionICD9CM() {
		this.unsetAdmissionICD9CM(true);
	}

	/**
	 * Remove Admission ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdmissionICD9CM(boolean reverse) {
		if (reverse && this.admissionICD9CM != null) {
			this.admissionICD9CM.removeAdmissionICD9CM(this, false);
		}
		this.admissionICD9CM = null;
	}
	/**
	 * Similar to {@link this#setDismissalReferringFacility(HealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HealthFacilityEntity to be set to this entity
	 */
	public void setDismissalReferringFacility(@NonNull HealthFacilityEntity entity) {
		setDismissalReferringFacility(entity, true);
	}

	/**
	 * Set or update the dismissalReferringFacility in this entity with single HealthFacilityEntity.
	 *
	 * @param entity the given HealthFacilityEntity to be set or updated to dismissalReferringFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDismissalReferringFacility(@NonNull HealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDismissalReferringFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDismissalReferringFacility here] end

		if (sameAsFormer(this.dismissalReferringFacility, entity)) {
			return;
		}

		if (this.dismissalReferringFacility != null) {
			this.dismissalReferringFacility.removeDismissalReferringFacility(this, false);
		}
		this.dismissalReferringFacility = entity;
		if (reverseAdd) {
			this.dismissalReferringFacility.addDismissalReferringFacility(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDismissalReferringFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDismissalReferringFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringFacility(boolean)} but default to true.
	 */
	public void unsetDismissalReferringFacility() {
		this.unsetDismissalReferringFacility(true);
	}

	/**
	 * Remove Dismissal Referring Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDismissalReferringFacility(boolean reverse) {
		if (reverse && this.dismissalReferringFacility != null) {
			this.dismissalReferringFacility.removeDismissalReferringFacility(this, false);
		}
		this.dismissalReferringFacility = null;
	}
	/**
	 * Similar to {@link this#setDismissalReferringStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDismissalReferringStaff(@NonNull StaffEntity entity) {
		setDismissalReferringStaff(entity, true);
	}

	/**
	 * Set or update the dismissalReferringStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to dismissalReferringStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDismissalReferringStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDismissalReferringStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDismissalReferringStaff here] end

		if (sameAsFormer(this.dismissalReferringStaff, entity)) {
			return;
		}

		if (this.dismissalReferringStaff != null) {
			this.dismissalReferringStaff.removeDismissalReferringStaff(this, false);
		}
		this.dismissalReferringStaff = entity;
		if (reverseAdd) {
			this.dismissalReferringStaff.addDismissalReferringStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDismissalReferringStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDismissalReferringStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringStaff(boolean)} but default to true.
	 */
	public void unsetDismissalReferringStaff() {
		this.unsetDismissalReferringStaff(true);
	}

	/**
	 * Remove Dismissal Referring Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDismissalReferringStaff(boolean reverse) {
		if (reverse && this.dismissalReferringStaff != null) {
			this.dismissalReferringStaff.removeDismissalReferringStaff(this, false);
		}
		this.dismissalReferringStaff = null;
	}
	/**
	 * Similar to {@link this#setReferringUnit(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setReferringUnit(@NonNull ServiceEntity entity) {
		setReferringUnit(entity, true);
	}

	/**
	 * Set or update the referringUnit in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to referringUnit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReferringUnit(@NonNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setReferringUnit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setReferringUnit here] end

		if (sameAsFormer(this.referringUnit, entity)) {
			return;
		}

		if (this.referringUnit != null) {
			this.referringUnit.removeReferringUnit(this, false);
		}
		this.referringUnit = entity;
		if (reverseAdd) {
			this.referringUnit.addReferringUnit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setReferringUnit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setReferringUnit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetReferringUnit(boolean)} but default to true.
	 */
	public void unsetReferringUnit() {
		this.unsetReferringUnit(true);
	}

	/**
	 * Remove Referring Unit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetReferringUnit(boolean reverse) {
		if (reverse && this.referringUnit != null) {
			this.referringUnit.removeReferringUnit(this, false);
		}
		this.referringUnit = null;
	}
	/**
	 * Similar to {@link this#setReferringFacility(HealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HealthFacilityEntity to be set to this entity
	 */
	public void setReferringFacility(@NonNull HealthFacilityEntity entity) {
		setReferringFacility(entity, true);
	}

	/**
	 * Set or update the referringFacility in this entity with single HealthFacilityEntity.
	 *
	 * @param entity the given HealthFacilityEntity to be set or updated to referringFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReferringFacility(@NonNull HealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setReferringFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setReferringFacility here] end

		if (sameAsFormer(this.referringFacility, entity)) {
			return;
		}

		if (this.referringFacility != null) {
			this.referringFacility.removeReferringFacility(this, false);
		}
		this.referringFacility = entity;
		if (reverseAdd) {
			this.referringFacility.addReferringFacility(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setReferringFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setReferringFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetReferringFacility(boolean)} but default to true.
	 */
	public void unsetReferringFacility() {
		this.unsetReferringFacility(true);
	}

	/**
	 * Remove Referring facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetReferringFacility(boolean reverse) {
		if (reverse && this.referringFacility != null) {
			this.referringFacility.removeReferringFacility(this, false);
		}
		this.referringFacility = null;
	}
	/**
	 * Similar to {@link this#setDiagnosticStaffExaminationSummary(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void setDiagnosticStaffExaminationSummary(DiagnosticStaffExaminationSummaryEntity entity) {
		setDiagnosticStaffExaminationSummary(entity, true);
	}

	/**
	 * Set or update the diagnosticStaffExaminationSummary in this entity with single DiagnosticStaffExaminationSummaryEntity.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set or updated to diagnosticStaffExaminationSummary
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosticStaffExaminationSummary(DiagnosticStaffExaminationSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] end

		if (sameAsFormer(this.diagnosticStaffExaminationSummary, entity)) {
			return;
		}

		if (this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetRegistration(false);
		}

		this.diagnosticStaffExaminationSummary = entity;
		if (reverseAdd) {
			this.diagnosticStaffExaminationSummary.setRegistration(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosticStaffExaminationSummary(boolean)} but default to true.
	 */
	public void unsetDiagnosticStaffExaminationSummary() {
		this.unsetDiagnosticStaffExaminationSummary(true);
	}

	/**
	 * Remove the DiagnosticStaffExaminationSummaryEntity of diagnosticStaffExaminationSummary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosticStaffExaminationSummary(boolean reverse) {
		if (reverse && this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetRegistration();
		}
		this.diagnosticStaffExaminationSummary = null;
	}
	/**
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeRegistrations(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeRegistrations(this, false);
		}
		this.bedFacility = null;
	}
	/**
	 * Similar to {@link this#addExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity) {
		this.addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItems.contains(entity)) {
			this.examinationItems.add(entity);
			if (reverseAdd) {
				entity.addRegistrations(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.addExaminationItems(entities, true);
	}

	/**
	 * Add new collection of ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to examinationItems in this entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from examinationItems
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeRegistrations(this, false);
		}
		this.examinationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems in this entity
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.removeExaminationItems(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeExaminationItems(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.setExaminationItems(entities, true);
	}

	/**
	 * Replace the current collection of ExaminationItemEntity in examinationItems with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		unsetExaminationItems();
		this.examinationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.addRegistrations(this, false));
		}
	}

	/**
	 * Remove all entities in Examination Items from this entity.
	 */
	public void unsetExaminationItems() {
		this.examinationItems.forEach(entity -> entity.removeRegistrations(this, false));
		this.examinationItems.clear();
	}
	/**
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NonNull PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.removeRegistrations(this, false);
		}
		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.addRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove Patient Visit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.removeRegistrations(this, false);
		}
		this.patientVisit = null;
	}
	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(@NonNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NonNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.removeRegistrations(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove Service in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.removeRegistrations(this, false);
		}
		this.service = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NonNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeRegistrations(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeRegistrations(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setRequestedBy(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setRequestedBy(@NonNull StaffEntity entity) {
		setRequestedBy(entity, true);
	}

	/**
	 * Set or update the requestedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to requestedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRequestedBy(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRequestedBy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRequestedBy here] end

		if (sameAsFormer(this.requestedBy, entity)) {
			return;
		}

		if (this.requestedBy != null) {
			this.requestedBy.removeRequestedBy(this, false);
		}
		this.requestedBy = entity;
		if (reverseAdd) {
			this.requestedBy.addRequestedBy(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRequestedBy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRequestedBy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRequestedBy(boolean)} but default to true.
	 */
	public void unsetRequestedBy() {
		this.unsetRequestedBy(true);
	}

	/**
	 * Remove Requested By in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRequestedBy(boolean reverse) {
		if (reverse && this.requestedBy != null) {
			this.requestedBy.removeRequestedBy(this, false);
		}
		this.requestedBy = null;
	}

	public void addSupportingDocument(FileEntity newFile) {
		supportingDocument.add(newFile);
	}

	public void addAllSupportingDocument(Collection<FileEntity> newFiles) {
		supportingDocument.addAll(newFiles);
	}

	public void removeSupportingDocument(FileEntity newFile) {
		supportingDocument.remove(newFile);
	}

	public boolean containsSupportingDocument(FileEntity newFile) {
		return supportingDocument.contains(newFile);
	}

	public void clearAllSupportingDocument() {
		supportingDocument.clear();
	}

	public void addPrintWristband(FileEntity newFile) {
		printWristband.add(newFile);
	}

	public void addAllPrintWristband(Collection<FileEntity> newFiles) {
		printWristband.addAll(newFiles);
	}

	public void removePrintWristband(FileEntity newFile) {
		printWristband.remove(newFile);
	}

	public boolean containsPrintWristband(FileEntity newFile) {
		return printWristband.contains(newFile);
	}

	public void clearAllPrintWristband() {
		printWristband.clear();
	}

	public void addPrintLabel(FileEntity newFile) {
		printLabel.add(newFile);
	}

	public void addAllPrintLabel(Collection<FileEntity> newFiles) {
		printLabel.addAll(newFiles);
	}

	public void removePrintLabel(FileEntity newFile) {
		printLabel.remove(newFile);
	}

	public boolean containsPrintLabel(FileEntity newFile) {
		return printLabel.contains(newFile);
	}

	public void clearAllPrintLabel() {
		printLabel.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
