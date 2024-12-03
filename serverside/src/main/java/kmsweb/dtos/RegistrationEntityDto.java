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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for RegistrationEntity")
@EqualsAndHashCode(callSuper = false)
public class RegistrationEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String registrationNumber;

	private OffsetDateTime scheduledDate;

	private OffsetDateTime actualInDate;

	private OffsetDateTime dismissalDate;

	private String dismissalType;

	private Integer queueNo;

	private Integer duration;

	private String treatmentClass;

	private String bookedTreatmentClass;

	private String shift;

	private Boolean cito;

	private Boolean oneDayCare;

	private Boolean referral;

	private String registrationStatus;

	private String referralType;

	private String purpose;

	private String referralNotes;

	private String admissionDiagnosis;

	private OffsetDateTime uploadedDateTime;

	private String visitStatus;

	private String instruction;

	private Boolean isAnAppointment;

	private String referralNumber;

	private String notes;

	private String kodepoli;

	private String deathCertificateNo;

	private OffsetDateTime timeOfDeath;

	private Boolean dismissalReferral;

	private String dismissalReferralDetail;

	private String dismissalReferralType;

	private String dismissalReferringNotes;

	private Boolean patientIsReferredBack;

	private String mcuPackage;

	private String parentRegistrationNumber;

	private Boolean isUnknownPatient;

	private String otherReferredFacility;

	private String otherReferredStaff;

	private Set<FileEntity> supportingDocument = new HashSet<>();

	private Set<FileEntity> printWristband = new HashSet<>();

	private Set<FileEntity> printLabel = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsPRBDetailEntity bpjsPRBDetail;

	private BpjsPcareRegistrationsEntity bpjsPcareRegistrations;

	private BpjsSEPEntity bpjsSEP;

	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	private Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();

	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResume;

	private MedicalCertificateBirthEntity medicalCertificateBirth;

	private MedicalCertificateHospitalizationEntity medicalCertificateHospitalization;

	private MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendance;

	private MedicalCertificateMentalHealthEntity medicalCertificateMentalHealth;

	private MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealth;

	private MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWork;

	private MedicalCertificateSickLeaveEntity medicalCertificateSickLeave;

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private Set<MedicalFeeEntity> medicalFees = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private PcareExaminationEntity pcareExamination;

	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private SepEntity sep;

	private Set<SampleCollectionInformationEntity> sampleCollectionInformations = new HashSet<>();

	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosesAndProceduresEntity admissionICD10;

	private DiagnosesAndProceduresEntity admissionICD9CM;

	private HealthFacilityEntity dismissalReferringFacility;

	private StaffEntity dismissalReferringStaff;

	private ServiceEntity referringUnit;

	private HealthFacilityEntity referringFacility;

	private DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary;

	private BedFacilityEntity bedFacility;

	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	private PatientVisitEntity patientVisit;

	private ServiceEntity service;

	private StaffEntity staff;

	private StaffEntity requestedBy;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
