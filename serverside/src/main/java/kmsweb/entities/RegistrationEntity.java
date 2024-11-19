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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.RegistrationEntityDto;
import kmsweb.entities.listeners.RegistrationEntityListener;
import kmsweb.serializers.RegistrationSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import kmsweb.lib.file.models.FileEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({RegistrationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RegistrationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class RegistrationEntity extends AbstractEntity {

	/**
	 * Takes a RegistrationEntityDto and converts it into a RegistrationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param registrationEntityDto
	 */
	public RegistrationEntity(RegistrationEntityDto registrationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (registrationEntityDto.getId() != null) {
			this.setId(registrationEntityDto.getId());
		}

		if (registrationEntityDto.getRegistrationNumber() != null) {
			this.setRegistrationNumber(registrationEntityDto.getRegistrationNumber());
		}

		if (registrationEntityDto.getScheduledDate() != null) {
			this.setScheduledDate(registrationEntityDto.getScheduledDate());
		}

		if (registrationEntityDto.getActualInDate() != null) {
			this.setActualInDate(registrationEntityDto.getActualInDate());
		}

		if (registrationEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(registrationEntityDto.getDismissalDate());
		}

		if (registrationEntityDto.getDismissalType() != null) {
			this.setDismissalType(registrationEntityDto.getDismissalType());
		}

		if (registrationEntityDto.getQueueNo() != null) {
			this.setQueueNo(registrationEntityDto.getQueueNo());
		}

		if (registrationEntityDto.getDuration() != null) {
			this.setDuration(registrationEntityDto.getDuration());
		}

		if (registrationEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(registrationEntityDto.getTreatmentClass());
		}

		if (registrationEntityDto.getBookedTreatmentClass() != null) {
			this.setBookedTreatmentClass(registrationEntityDto.getBookedTreatmentClass());
		}

		if (registrationEntityDto.getShift() != null) {
			this.setShift(registrationEntityDto.getShift());
		}

		if (registrationEntityDto.getCito() != null) {
			this.setCito(registrationEntityDto.getCito());
		}

		if (registrationEntityDto.getOneDayCare() != null) {
			this.setOneDayCare(registrationEntityDto.getOneDayCare());
		}

		if (registrationEntityDto.getReferral() != null) {
			this.setReferral(registrationEntityDto.getReferral());
		}

		if (registrationEntityDto.getRegistrationStatus() != null) {
			this.setRegistrationStatus(registrationEntityDto.getRegistrationStatus());
		}

		if (registrationEntityDto.getReferralType() != null) {
			this.setReferralType(registrationEntityDto.getReferralType());
		}

		if (registrationEntityDto.getPurpose() != null) {
			this.setPurpose(registrationEntityDto.getPurpose());
		}

		if (registrationEntityDto.getReferralNotes() != null) {
			this.setReferralNotes(registrationEntityDto.getReferralNotes());
		}

		if (registrationEntityDto.getAdmissionDiagnosis() != null) {
			this.setAdmissionDiagnosis(registrationEntityDto.getAdmissionDiagnosis());
		}

		if (registrationEntityDto.getUploadedDateTime() != null) {
			this.setUploadedDateTime(registrationEntityDto.getUploadedDateTime());
		}

		if (registrationEntityDto.getVisitStatus() != null) {
			this.setVisitStatus(registrationEntityDto.getVisitStatus());
		}

		if (registrationEntityDto.getInstruction() != null) {
			this.setInstruction(registrationEntityDto.getInstruction());
		}

		if (registrationEntityDto.getIsAnAppointment() != null) {
			this.setIsAnAppointment(registrationEntityDto.getIsAnAppointment());
		}

		if (registrationEntityDto.getReferralNumber() != null) {
			this.setReferralNumber(registrationEntityDto.getReferralNumber());
		}

		if (registrationEntityDto.getNotes() != null) {
			this.setNotes(registrationEntityDto.getNotes());
		}

		if (registrationEntityDto.getKodepoli() != null) {
			this.setKodepoli(registrationEntityDto.getKodepoli());
		}

		if (registrationEntityDto.getDeathCertificateNo() != null) {
			this.setDeathCertificateNo(registrationEntityDto.getDeathCertificateNo());
		}

		if (registrationEntityDto.getTimeOfDeath() != null) {
			this.setTimeOfDeath(registrationEntityDto.getTimeOfDeath());
		}

		if (registrationEntityDto.getDismissalReferral() != null) {
			this.setDismissalReferral(registrationEntityDto.getDismissalReferral());
		}

		if (registrationEntityDto.getDismissalReferralDetail() != null) {
			this.setDismissalReferralDetail(registrationEntityDto.getDismissalReferralDetail());
		}

		if (registrationEntityDto.getDismissalReferralType() != null) {
			this.setDismissalReferralType(registrationEntityDto.getDismissalReferralType());
		}

		if (registrationEntityDto.getDismissalReferringNotes() != null) {
			this.setDismissalReferringNotes(registrationEntityDto.getDismissalReferringNotes());
		}

		if (registrationEntityDto.getPatientIsReferredBack() != null) {
			this.setPatientIsReferredBack(registrationEntityDto.getPatientIsReferredBack());
		}

		if (registrationEntityDto.getMcuPackage() != null) {
			this.setMcuPackage(registrationEntityDto.getMcuPackage());
		}

		if (registrationEntityDto.getParentRegistrationNumber() != null) {
			this.setParentRegistrationNumber(registrationEntityDto.getParentRegistrationNumber());
		}

		if (registrationEntityDto.getIsUnknownPatient() != null) {
			this.setIsUnknownPatient(registrationEntityDto.getIsUnknownPatient());
		}

		if (registrationEntityDto.getOtherReferredFacility() != null) {
			this.setOtherReferredFacility(registrationEntityDto.getOtherReferredFacility());
		}

		if (registrationEntityDto.getOtherReferredStaff() != null) {
			this.setOtherReferredStaff(registrationEntityDto.getOtherReferredStaff());
		}

		if (registrationEntityDto.getBpjsPRBDetail() != null) {
			this.setBpjsPRBDetail(registrationEntityDto.getBpjsPRBDetail());
		}

		if (registrationEntityDto.getBpjsPcareRegistrations() != null) {
			this.setBpjsPcareRegistrations(registrationEntityDto.getBpjsPcareRegistrations());
		}

		if (registrationEntityDto.getBpjsSEP() != null) {
			this.setBpjsSEP(registrationEntityDto.getBpjsSEP());
		}

		if (registrationEntityDto.getBedReserves() != null) {
			this.setBedReserves(registrationEntityDto.getBedReserves());
		}

		if (registrationEntityDto.getDiagnosticExaminationResults() != null) {
			this.setDiagnosticExaminationResults(registrationEntityDto.getDiagnosticExaminationResults());
		}

		if (registrationEntityDto.getFluidBalanceDetails() != null) {
			this.setFluidBalanceDetails(registrationEntityDto.getFluidBalanceDetails());
		}

		if (registrationEntityDto.getInformedConsents() != null) {
			this.setInformedConsents(registrationEntityDto.getInformedConsents());
		}

		if (registrationEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(registrationEntityDto.getInvoiceItems());
		}

		if (registrationEntityDto.getMedicalCertificateDischargeResume() != null) {
			this.setMedicalCertificateDischargeResume(registrationEntityDto.getMedicalCertificateDischargeResume());
		}

		if (registrationEntityDto.getMedicalCertificateBirth() != null) {
			this.setMedicalCertificateBirth(registrationEntityDto.getMedicalCertificateBirth());
		}

		if (registrationEntityDto.getMedicalCertificateHospitalization() != null) {
			this.setMedicalCertificateHospitalization(registrationEntityDto.getMedicalCertificateHospitalization());
		}

		if (registrationEntityDto.getMedicalCertificateMedicalAttendance() != null) {
			this.setMedicalCertificateMedicalAttendance(registrationEntityDto.getMedicalCertificateMedicalAttendance());
		}

		if (registrationEntityDto.getMedicalCertificateMentalHealth() != null) {
			this.setMedicalCertificateMentalHealth(registrationEntityDto.getMedicalCertificateMentalHealth());
		}

		if (registrationEntityDto.getMedicalCertificatePhysicalHealth() != null) {
			this.setMedicalCertificatePhysicalHealth(registrationEntityDto.getMedicalCertificatePhysicalHealth());
		}

		if (registrationEntityDto.getMedicalCertificateRestrictedWork() != null) {
			this.setMedicalCertificateRestrictedWork(registrationEntityDto.getMedicalCertificateRestrictedWork());
		}

		if (registrationEntityDto.getMedicalCertificateSickLeave() != null) {
			this.setMedicalCertificateSickLeave(registrationEntityDto.getMedicalCertificateSickLeave());
		}

		if (registrationEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(registrationEntityDto.getMedicalExaminationRecord());
		}

		if (registrationEntityDto.getMedicalFees() != null) {
			this.setMedicalFees(registrationEntityDto.getMedicalFees());
		}

		if (registrationEntityDto.getMedicationHeaders() != null) {
			this.setMedicationHeaders(registrationEntityDto.getMedicationHeaders());
		}

		if (registrationEntityDto.getPcareExamination() != null) {
			this.setPcareExamination(registrationEntityDto.getPcareExamination());
		}

		if (registrationEntityDto.getPatientVitalInformations() != null) {
			this.setPatientVitalInformations(registrationEntityDto.getPatientVitalInformations());
		}

		if (registrationEntityDto.getPrescriptionHeaders() != null) {
			this.setPrescriptionHeaders(registrationEntityDto.getPrescriptionHeaders());
		}

		if (registrationEntityDto.getSep() != null) {
			this.setSep(registrationEntityDto.getSep());
		}

		if (registrationEntityDto.getSampleCollectionInformations() != null) {
			this.setSampleCollectionInformations(registrationEntityDto.getSampleCollectionInformations());
		}

		if (registrationEntityDto.getVaccinationOrders() != null) {
			this.setVaccinationOrders(registrationEntityDto.getVaccinationOrders());
		}

		if (registrationEntityDto.getAdmissionICD10() != null) {
			this.setAdmissionICD10(registrationEntityDto.getAdmissionICD10());
		}

		if (registrationEntityDto.getAdmissionICD9CM() != null) {
			this.setAdmissionICD9CM(registrationEntityDto.getAdmissionICD9CM());
		}

		if (registrationEntityDto.getDismissalReferringFacility() != null) {
			this.setDismissalReferringFacility(registrationEntityDto.getDismissalReferringFacility());
		}

		if (registrationEntityDto.getDismissalReferringStaff() != null) {
			this.setDismissalReferringStaff(registrationEntityDto.getDismissalReferringStaff());
		}

		if (registrationEntityDto.getReferringUnit() != null) {
			this.setReferringUnit(registrationEntityDto.getReferringUnit());
		}

		if (registrationEntityDto.getReferringFacility() != null) {
			this.setReferringFacility(registrationEntityDto.getReferringFacility());
		}

		if (registrationEntityDto.getDiagnosticStaffExaminationSummary() != null) {
			this.setDiagnosticStaffExaminationSummary(registrationEntityDto.getDiagnosticStaffExaminationSummary());
		}

		if (registrationEntityDto.getBedFacility() != null) {
			this.setBedFacility(registrationEntityDto.getBedFacility());
		}

		if (registrationEntityDto.getExaminationItems() != null) {
			this.setExaminationItems(registrationEntityDto.getExaminationItems());
		}

		if (registrationEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(registrationEntityDto.getPatientVisit());
		}

		if (registrationEntityDto.getService() != null) {
			this.setService(registrationEntityDto.getService());
		}

		if (registrationEntityDto.getStaff() != null) {
			this.setStaff(registrationEntityDto.getStaff());
		}

		if (registrationEntityDto.getRequestedBy() != null) {
			this.setRequestedBy(registrationEntityDto.getRequestedBy());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Registration Number here] off begin
	@CsvBindByName(column = "REGISTRATION_NUMBER", required = true)
	@NotNull(message = "Registration Number must not be empty")
	@Column(name = "registration_number")
	@Schema(description = "The Registration Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Number here] end
	private String registrationNumber;

	// % protected region % [Modify attribute annotation for Scheduled Date here] off begin

	@CsvCustomBindByName(column = "SCHEDULED_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Scheduled Date must not be empty")
	@Column(name = "scheduled_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Scheduled Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Scheduled Date here] end
	private OffsetDateTime scheduledDate;

	// % protected region % [Modify attribute annotation for Actual In Date here] off begin

	@CsvCustomBindByName(column = "ACTUAL_IN_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "actual_in_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Actual In Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Actual In Date here] end
	private OffsetDateTime actualInDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin

	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Dismissal Type here] off begin
	@CsvBindByName(column = "DISMISSAL_TYPE", required = false)
	@Nullable
	@Column(name = "dismissal_type")
	@Schema(description = "The Dismissal Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Type here] end
	private String dismissalType;

	// % protected region % [Modify attribute annotation for Queue No here] off begin
	@CsvBindByName(column = "QUEUE_NO", required = false)
	@Nullable
	@Column(name = "queue_no")
	@Schema(description = "The Queue No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Queue No here] end
	private Integer queueNo;

	// % protected region % [Modify attribute annotation for Duration here] off begin
	@CsvBindByName(column = "DURATION", required = false)
	@Nullable
	@Column(name = "duration")
	@Schema(description = "The Duration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Duration here] end
	private Integer duration;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Booked Treatment Class here] off begin
	@CsvBindByName(column = "BOOKED_TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "booked_treatment_class")
	@Schema(description = "The Booked Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Booked Treatment Class here] end
	private String bookedTreatmentClass;

	// % protected region % [Modify attribute annotation for Shift here] off begin
	@CsvBindByName(column = "SHIFT", required = false)
	@Nullable
	@Column(name = "shift")
	@Schema(description = "The Shift of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shift here] end
	private String shift;

	// % protected region % [Modify attribute annotation for CITO here] off begin
	@CsvBindByName(column = "CITO", required = false)
	@Nullable
	@Column(name = "cito")
	@Schema(description = "The CITO of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for CITO here] end
	private Boolean cito = false ;

	// % protected region % [Modify attribute annotation for One Day Care here] off begin
	@CsvBindByName(column = "ONE_DAY_CARE", required = false)
	@Nullable
	@Column(name = "one_day_care")
	@Schema(description = "The One Day Care of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for One Day Care here] end
	private Boolean oneDayCare = false ;

	// % protected region % [Modify attribute annotation for Referral here] off begin
	@CsvBindByName(column = "REFERRAL", required = false)
	@Nullable
	@Column(name = "referral")
	@Schema(description = "The Referral of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral here] end
	private Boolean referral = false ;

	// % protected region % [Modify attribute annotation for Registration Status here] off begin
	@CsvBindByName(column = "REGISTRATION_STATUS", required = false)
	@Nullable
	@Column(name = "registration_status")
	@Schema(description = "The Registration Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Status here] end
	private String registrationStatus;

	// % protected region % [Modify attribute annotation for Referral Type here] off begin
	@CsvBindByName(column = "REFERRAL_TYPE", required = false)
	@Nullable
	@Column(name = "referral_type")
	@Schema(description = "The Referral Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Type here] end
	private String referralType;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@CsvBindByName(column = "PURPOSE", required = false)
	@Nullable
	@Column(name = "purpose")
	@Schema(description = "The Purpose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Referral Notes here] off begin
	@CsvBindByName(column = "REFERRAL_NOTES", required = false)
	@Nullable
	@Column(name = "referral_notes")
	@Schema(description = "The Referral Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Notes here] end
	private String referralNotes;

	// % protected region % [Modify attribute annotation for Admission Diagnosis here] off begin
	@CsvBindByName(column = "ADMISSION_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "admission_diagnosis")
	@Schema(description = "The Admission Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Admission Diagnosis here] end
	private String admissionDiagnosis;

	// % protected region % [Modify attribute annotation for Uploaded Date Time here] off begin

	@CsvCustomBindByName(column = "UPLOADED_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "uploaded_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Uploaded Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uploaded Date Time here] end
	private OffsetDateTime uploadedDateTime;

	// % protected region % [Modify attribute annotation for Visit Status here] off begin
	@CsvBindByName(column = "VISIT_STATUS", required = false)
	@Nullable
	@Column(name = "visit_status")
	@Schema(description = "The Visit Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Status here] end
	private String visitStatus;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@CsvBindByName(column = "INSTRUCTION", required = false)
	@Nullable
	@Column(name = "instruction")
	@Schema(description = "The Instruction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for is An Appointment here] off begin
	@CsvBindByName(column = "IS_AN_APPOINTMENT", required = false)
	@Nullable
	@Column(name = "is_an_appointment")
	@Schema(description = "The is An Appointment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for is An Appointment here] end
	private Boolean isAnAppointment = false ;

	// % protected region % [Modify attribute annotation for Referral Number here] off begin
	@CsvBindByName(column = "REFERRAL_NUMBER", required = false)
	@Nullable
	@Column(name = "referral_number")
	@Schema(description = "The Referral Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Number here] end
	private String referralNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for kodepoli here] off begin
	@CsvBindByName(column = "KODEPOLI", required = false)
	@Nullable
	@Column(name = "kodepoli")
	@Schema(description = "The kodepoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kodepoli here] end
	private String kodepoli;

	// % protected region % [Modify attribute annotation for Death Certificate No here] off begin
	@CsvBindByName(column = "DEATH_CERTIFICATE_NO", required = false)
	@Nullable
	@Column(name = "death_certificate_no")
	@Schema(description = "The Death Certificate No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Death Certificate No here] end
	private String deathCertificateNo;

	// % protected region % [Modify attribute annotation for Time Of Death here] off begin

	@CsvCustomBindByName(column = "TIME_OF_DEATH", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "time_of_death")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Time Of Death of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Time Of Death here] end
	private OffsetDateTime timeOfDeath;

	// % protected region % [Modify attribute annotation for Dismissal Referral here] off begin
	@CsvBindByName(column = "DISMISSAL_REFERRAL", required = false)
	@Nullable
	@Column(name = "dismissal_referral")
	@Schema(description = "The Dismissal Referral of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Referral here] end
	private Boolean dismissalReferral = false ;

	// % protected region % [Modify attribute annotation for Dismissal Referral Detail here] off begin
	@CsvBindByName(column = "DISMISSAL_REFERRAL_DETAIL", required = false)
	@Nullable
	@Column(name = "dismissal_referral_detail")
	@Schema(description = "The Dismissal Referral Detail of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Referral Detail here] end
	private String dismissalReferralDetail;

	// % protected region % [Modify attribute annotation for Dismissal Referral Type here] off begin
	@CsvBindByName(column = "DISMISSAL_REFERRAL_TYPE", required = false)
	@Nullable
	@Column(name = "dismissal_referral_type")
	@Schema(description = "The Dismissal Referral Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Referral Type here] end
	private String dismissalReferralType;

	// % protected region % [Modify attribute annotation for Dismissal Referring Notes here] off begin
	@CsvBindByName(column = "DISMISSAL_REFERRING_NOTES", required = false)
	@Nullable
	@Column(name = "dismissal_referring_notes")
	@Schema(description = "The Dismissal Referring Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Referring Notes here] end
	private String dismissalReferringNotes;

	// % protected region % [Modify attribute annotation for Patient Is Referred Back here] off begin
	@CsvBindByName(column = "PATIENT_IS_REFERRED_BACK", required = false)
	@Nullable
	@Column(name = "patient_is_referred_back")
	@Schema(description = "The Patient Is Referred Back of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Is Referred Back here] end
	private Boolean patientIsReferredBack = false ;

	// % protected region % [Modify attribute annotation for MCU Package here] off begin
	@CsvBindByName(column = "MCU_PACKAGE", required = false)
	@Nullable
	@Column(name = "mcu_package")
	@Schema(description = "The MCU Package of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for MCU Package here] end
	private String mcuPackage;

	// % protected region % [Modify attribute annotation for Parent Registration Number here] off begin
	@CsvBindByName(column = "PARENT_REGISTRATION_NUMBER", required = false)
	@Nullable
	@Column(name = "parent_registration_number")
	@Schema(description = "The Parent Registration Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Parent Registration Number here] end
	private String parentRegistrationNumber;

	// % protected region % [Modify attribute annotation for Is Unknown Patient here] off begin
	@CsvBindByName(column = "IS_UNKNOWN_PATIENT", required = false)
	@Nullable
	@Column(name = "is_unknown_patient")
	@Schema(description = "The Is Unknown Patient of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Unknown Patient here] end
	private Boolean isUnknownPatient = false ;

	// % protected region % [Modify attribute annotation for Other Referred Facility here] off begin
	@CsvBindByName(column = "OTHER_REFERRED_FACILITY", required = false)
	@Nullable
	@Column(name = "other_referred_facility")
	@Schema(description = "The Other Referred Facility of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Referred Facility here] end
	private String otherReferredFacility;

	// % protected region % [Modify attribute annotation for Other Referred Staff here] off begin
	@CsvBindByName(column = "OTHER_REFERRED_STAFF", required = false)
	@Nullable
	@Column(name = "other_referred_staff")
	@Schema(description = "The Other Referred Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Referred Staff here] end
	private String otherReferredStaff;

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> supportingDocument = new HashSet<>();

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> printWristband = new HashSet<>();

	@CsvIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	private Set<FileEntity> printLabel = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS PRB Detail here] off begin
	@Schema(description = "The BPJS PRB Detail entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS PRB Detail here] end
	private BpjsPRBDetailEntity bpjsPRBDetail;

	// % protected region % [Update the annotation for bpjsPRBDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PRB_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsPRBDetailId here] end
	private UUID bpjsPRBDetailId;

	// % protected region % [Update the annotation for BPJS Pcare Registrations here] off begin
	@Schema(description = "The BPJS Pcare Registrations entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Pcare Registrations here] end
	private BpjsPcareRegistrationsEntity bpjsPcareRegistrations;

	// % protected region % [Update the annotation for bpjsPcareRegistrationsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PCARE_REGISTRATIONS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsPcareRegistrationsId here] end
	private UUID bpjsPcareRegistrationsId;

	// % protected region % [Update the annotation for BPJS SEP here] off begin
	@Schema(description = "The BPJS SEP entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS SEP here] end
	private BpjsSEPEntity bpjsSEP;

	// % protected region % [Update the annotation for bpjsSEPId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_SEP_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsSEPId here] end
	private UUID bpjsSEPId;

	// % protected region % [Update the annotation for Bed Reserves here] off begin
	@Schema(description = "The Bed Reserve entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Reserves here] end
	private Set<BedReserveEntity> bedReserves = new HashSet<>();

	// % protected region % [Update the annotation for bedReservesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_RESERVES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bedReservesIds here] end
	private Set<UUID> bedReservesIds = new HashSet<>();

	// % protected region % [Update the annotation for Diagnostic Examination Results here] off begin
	@Schema(description = "The Diagnostic Examination Results entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Examination Results here] end
	private Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();

	// % protected region % [Update the annotation for diagnosticExaminationResultsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_EXAMINATION_RESULTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosticExaminationResultsIds here] end
	private Set<UUID> diagnosticExaminationResultsIds = new HashSet<>();

	// % protected region % [Update the annotation for Fluid Balance Details here] off begin
	@Schema(description = "The Fluid Balance Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Fluid Balance Details here] end
	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	// % protected region % [Update the annotation for fluidBalanceDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "FLUID_BALANCE_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for fluidBalanceDetailsIds here] end
	private Set<UUID> fluidBalanceDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Informed Consents here] off begin
	@Schema(description = "The Informed Consent entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Informed Consents here] end
	private Set<InformedConsentEntity> informedConsents = new HashSet<>();

	// % protected region % [Update the annotation for informedConsentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INFORMED_CONSENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for informedConsentsIds here] end
	private Set<UUID> informedConsentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "serviceNumber", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Certificate  Discharge Resume here] off begin
	@Schema(description = "The Medical Certificate  Discharge Resume entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate  Discharge Resume here] end
	private MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResume;

	// % protected region % [Update the annotation for medicalCertificateDischargeResumeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateDischargeResumeId here] end
	private UUID medicalCertificateDischargeResumeId;

	// % protected region % [Update the annotation for Medical Certificate Birth here] off begin
	@Schema(description = "The Medical Certificate Birth entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Birth here] end
	private MedicalCertificateBirthEntity medicalCertificateBirth;

	// % protected region % [Update the annotation for medicalCertificateBirthId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_BIRTH_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateBirthId here] end
	private UUID medicalCertificateBirthId;

	// % protected region % [Update the annotation for Medical Certificate Hospitalization here] off begin
	@Schema(description = "The Medical Certificate Hospitalization entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Hospitalization here] end
	private MedicalCertificateHospitalizationEntity medicalCertificateHospitalization;

	// % protected region % [Update the annotation for medicalCertificateHospitalizationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_HOSPITALIZATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateHospitalizationId here] end
	private UUID medicalCertificateHospitalizationId;

	// % protected region % [Update the annotation for Medical Certificate Medical Attendance here] off begin
	@Schema(description = "The Medical Certificate Medical Attendance entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Medical Attendance here] end
	private MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendance;

	// % protected region % [Update the annotation for medicalCertificateMedicalAttendanceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateMedicalAttendanceId here] end
	private UUID medicalCertificateMedicalAttendanceId;

	// % protected region % [Update the annotation for Medical Certificate Mental Health here] off begin
	@Schema(description = "The Medical Certificate Mental Health entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Mental Health here] end
	private MedicalCertificateMentalHealthEntity medicalCertificateMentalHealth;

	// % protected region % [Update the annotation for medicalCertificateMentalHealthId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_MENTAL_HEALTH_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateMentalHealthId here] end
	private UUID medicalCertificateMentalHealthId;

	// % protected region % [Update the annotation for Medical Certificate Physical Health here] off begin
	@Schema(description = "The Medical Certificate Physical Health entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Physical Health here] end
	private MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealth;

	// % protected region % [Update the annotation for medicalCertificatePhysicalHealthId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificatePhysicalHealthId here] end
	private UUID medicalCertificatePhysicalHealthId;

	// % protected region % [Update the annotation for Medical Certificate Restricted Work here] off begin
	@Schema(description = "The Medical Certificate Restricted Work entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Restricted Work here] end
	private MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWork;

	// % protected region % [Update the annotation for medicalCertificateRestrictedWorkId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_RESTRICTED_WORK_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateRestrictedWorkId here] end
	private UUID medicalCertificateRestrictedWorkId;

	// % protected region % [Update the annotation for Medical Certificate Sick Leave here] off begin
	@Schema(description = "The Medical Certificate Sick Leave entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Certificate Sick Leave here] end
	private MedicalCertificateSickLeaveEntity medicalCertificateSickLeave;

	// % protected region % [Update the annotation for medicalCertificateSickLeaveId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_CERTIFICATE_SICK_LEAVE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalCertificateSickLeaveId here] end
	private UUID medicalCertificateSickLeaveId;

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

	// % protected region % [Update the annotation for Medical Fees here] off begin
	@Schema(description = "The Medical Fee entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Fees here] end
	private Set<MedicalFeeEntity> medicalFees = new HashSet<>();

	// % protected region % [Update the annotation for medicalFeesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_FEES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalFeesIds here] end
	private Set<UUID> medicalFeesIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Headers here] off begin
	@Schema(description = "The Medication Header entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Headers here] end
	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	// % protected region % [Update the annotation for medicationHeadersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_HEADERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationHeadersIds here] end
	private Set<UUID> medicationHeadersIds = new HashSet<>();

	// % protected region % [Update the annotation for PCare Examination here] off begin
	@Schema(description = "The PCare Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Examination here] end
	private PcareExaminationEntity pcareExamination;

	// % protected region % [Update the annotation for pcareExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for pcareExaminationId here] end
	private UUID pcareExaminationId;

	// % protected region % [Update the annotation for Patient Vital Informations here] off begin
	@Schema(description = "The Patient Vital Information entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Vital Informations here] end
	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	// % protected region % [Update the annotation for patientVitalInformationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VITAL_INFORMATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for patientVitalInformationsIds here] end
	private Set<UUID> patientVitalInformationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Headers here] off begin
	@Schema(description = "The Prescription Header entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Headers here] end
	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionHeadersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_HEADERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionHeadersIds here] end
	private Set<UUID> prescriptionHeadersIds = new HashSet<>();

	// % protected region % [Update the annotation for SEP here] off begin
	@Schema(description = "The SEP entities that are related to this entity.")
	@OneToOne(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for SEP here] end
	private SepEntity sep;

	// % protected region % [Update the annotation for sepId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SEP_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sepId here] end
	private UUID sepId;

	// % protected region % [Update the annotation for Sample Collection Informations here] off begin
	@Schema(description = "The Sample Collection Information entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Informations here] end
	private Set<SampleCollectionInformationEntity> sampleCollectionInformations = new HashSet<>();

	// % protected region % [Update the annotation for sampleCollectionInformationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_INFORMATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for sampleCollectionInformationsIds here] end
	private Set<UUID> sampleCollectionInformationsIds = new HashSet<>();

	// % protected region % [Update the annotation for Vaccination Orders here] off begin
	@Schema(description = "The Vaccination Order entities that are related to this entity.")
	@OneToMany(mappedBy = "registration", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vaccination Orders here] end
	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	// % protected region % [Update the annotation for vaccinationOrdersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VACCINATION_ORDERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for vaccinationOrdersIds here] end
	private Set<UUID> vaccinationOrdersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Admission ICD 10 here] off begin
	@Schema(description = "The Admission ICD 10 entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Admission ICD 10 here] end
	private DiagnosesAndProceduresEntity admissionICD10;

	// % protected region % [Update the annotation for admissionICD10Id here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADMISSION_ICD_10_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for admissionICD10Id here] end
	private UUID admissionICD10Id;

	// % protected region % [Update the annotation for Admission ICD 9 CM here] off begin
	@Schema(description = "The Admission ICD 9 CM entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Admission ICD 9 CM here] end
	private DiagnosesAndProceduresEntity admissionICD9CM;

	// % protected region % [Update the annotation for admissionICD9CMId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADMISSION_ICD_9_CM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for admissionICD9CMId here] end
	private UUID admissionICD9CMId;

	// % protected region % [Update the annotation for Dismissal Referring Facility here] off begin
	@Schema(description = "The Dismissal Referring Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Dismissal Referring Facility here] end
	private HealthFacilityEntity dismissalReferringFacility;

	// % protected region % [Update the annotation for dismissalReferringFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DISMISSAL_REFERRING_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for dismissalReferringFacilityId here] end
	private UUID dismissalReferringFacilityId;

	// % protected region % [Update the annotation for Dismissal Referring Staff here] off begin
	@Schema(description = "The Dismissal Referring Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Dismissal Referring Staff here] end
	private StaffEntity dismissalReferringStaff;

	// % protected region % [Update the annotation for dismissalReferringStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DISMISSAL_REFERRING_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for dismissalReferringStaffId here] end
	private UUID dismissalReferringStaffId;

	// % protected region % [Update the annotation for Referring Unit here] off begin
	@Schema(description = "The Referring Unit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Referring Unit here] end
	private ServiceEntity referringUnit;

	// % protected region % [Update the annotation for referringUnitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REFERRING_UNIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for referringUnitId here] end
	private UUID referringUnitId;

	// % protected region % [Update the annotation for Referring facility here] off begin
	@Schema(description = "The Referring facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Referring facility here] end
	private HealthFacilityEntity referringFacility;

	// % protected region % [Update the annotation for referringFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REFERRING_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for referringFacilityId here] end
	private UUID referringFacilityId;

	// % protected region % [Update the annotation for Diagnostic Staff Examination Summary here] off begin
	@Schema(description = "The Diagnostic Staff Examination Summary entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnostic Staff Examination Summary here] end
	private DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary;

	// % protected region % [Update the annotation for diagnosticStaffExaminationSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for diagnosticStaffExaminationSummaryId here] end
	private UUID diagnosticStaffExaminationSummaryId;

	// % protected region % [Update the annotation for Bed Facility here] off begin
	@Schema(description = "The Bed Facility entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bed Facility here] end
	private BedFacilityEntity bedFacility;

	// % protected region % [Update the annotation for bedFacilityId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BED_FACILITY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bedFacilityId here] end
	private UUID bedFacilityId;

	// % protected region % [Update the annotation for Examination Items here] off begin
	@Schema(description = "The Examination Items entities that are related to this entity.")
	@ManyToMany(mappedBy = "registrations", fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Items here] end
	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	// % protected region % [Update the annotation for examinationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for examinationItemsIds here] end
	private Set<UUID> examinationItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

	// % protected region % [Update the annotation for Service here] off begin
	@Schema(description = "The Service entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service here] end
	private ServiceEntity service;

	// % protected region % [Update the annotation for serviceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceId here] end
	private UUID serviceId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

	// % protected region % [Update the annotation for Requested By here] off begin
	@Schema(description = "The Requested By entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Requested By here] end
	private StaffEntity requestedBy;

	// % protected region % [Update the annotation for requestedById here] off begin
	@Transient
	@CsvCustomBindByName(column = "REQUESTED_BY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for requestedById here] end
	private UUID requestedById;

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
	public void setBpjsPRBDetail(@NotNull BpjsPRBDetailEntity entity) {
		setBpjsPRBDetail(entity, true);
	}

	/**
	 * Set or update bpjsPRBDetail with the given BpjsPRBDetailEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPRBDetail(@NotNull BpjsPRBDetailEntity entity, boolean reverseAdd) {
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
	public void setBpjsPcareRegistrations(@NotNull BpjsPcareRegistrationsEntity entity) {
		setBpjsPcareRegistrations(entity, true);
	}

	/**
	 * Set or update bpjsPcareRegistrations with the given BpjsPcareRegistrationsEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareRegistrations(@NotNull BpjsPcareRegistrationsEntity entity, boolean reverseAdd) {
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
	public void setBpjsSEP(@NotNull BpjsSEPEntity entity) {
		setBpjsSEP(entity, true);
	}

	/**
	 * Set or update bpjsSEP with the given BpjsSEPEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsSEP(@NotNull BpjsSEPEntity entity, boolean reverseAdd) {
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
	public void addBedReserves(@NotNull BedReserveEntity entity) {
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
	public void addBedReserves(@NotNull Collection<BedReserveEntity> entities) {
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
	public void removeBedReserves(@NotNull BedReserveEntity entity) {
		this.removeBedReserves(entity, true);
	}

	/**
	 * Remove the given BedReserveEntity from this entity.
	 *
	 * @param entity the given BedReserveEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedReserves(@NotNull BedReserveEntity entity, boolean reverse) {
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
	public void removeBedReserves(@NotNull Collection<BedReserveEntity> entities) {
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
	public void setBedReserves(@NotNull Collection<BedReserveEntity> entities) {
		setBedReserves(entities, true);
	}

	/**
	 * Replace the current entities in Bed Reserves with the given ones.
	 *
	 * @param entities the given collection of BedReserveEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedReserves(@NotNull Collection<BedReserveEntity> entities, boolean reverseAdd) {

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
	public void addDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity) {
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
	public void addDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
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
	public void removeDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity) {
		this.removeDiagnosticExaminationResults(entity, true);
	}

	/**
	 * Remove the given DiagnosticExaminationResultsEntity from this entity.
	 *
	 * @param entity the given DiagnosticExaminationResultsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosticExaminationResults(@NotNull DiagnosticExaminationResultsEntity entity, boolean reverse) {
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
	public void removeDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
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
	public void setDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities) {
		setDiagnosticExaminationResults(entities, true);
	}

	/**
	 * Replace the current entities in Diagnostic Examination Results with the given ones.
	 *
	 * @param entities the given collection of DiagnosticExaminationResultsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosticExaminationResults(@NotNull Collection<DiagnosticExaminationResultsEntity> entities, boolean reverseAdd) {

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
	public void addFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity) {
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
	public void addFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
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
	public void removeFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity) {
		this.removeFluidBalanceDetails(entity, true);
	}

	/**
	 * Remove the given FluidBalanceDetailEntity from this entity.
	 *
	 * @param entity the given FluidBalanceDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeFluidBalanceDetails(@NotNull FluidBalanceDetailEntity entity, boolean reverse) {
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
	public void removeFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
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
	public void setFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities) {
		setFluidBalanceDetails(entities, true);
	}

	/**
	 * Replace the current entities in Fluid Balance Details with the given ones.
	 *
	 * @param entities the given collection of FluidBalanceDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setFluidBalanceDetails(@NotNull Collection<FluidBalanceDetailEntity> entities, boolean reverseAdd) {

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
	public void addInformedConsents(@NotNull InformedConsentEntity entity) {
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
	public void addInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
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
	public void removeInformedConsents(@NotNull InformedConsentEntity entity) {
		this.removeInformedConsents(entity, true);
	}

	/**
	 * Remove the given InformedConsentEntity from this entity.
	 *
	 * @param entity the given InformedConsentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInformedConsents(@NotNull InformedConsentEntity entity, boolean reverse) {
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
	public void removeInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
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
	public void setInformedConsents(@NotNull Collection<InformedConsentEntity> entities) {
		setInformedConsents(entities, true);
	}

	/**
	 * Replace the current entities in Informed Consents with the given ones.
	 *
	 * @param entities the given collection of InformedConsentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInformedConsents(@NotNull Collection<InformedConsentEntity> entities, boolean reverseAdd) {

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
	public void addInvoiceItems(@NotNull InvoiceItemEntity entity) {
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
	public void addInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
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
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity, boolean reverse) {
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
	public void removeInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
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
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

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
	public void setMedicalCertificateDischargeResume(@NotNull MedicalCertificateDischargeResumeEntity entity) {
		setMedicalCertificateDischargeResume(entity, true);
	}

	/**
	 * Set or update medicalCertificateDischargeResume with the given MedicalCertificateDischargeResumeEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateDischargeResume(@NotNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateBirth(@NotNull MedicalCertificateBirthEntity entity) {
		setMedicalCertificateBirth(entity, true);
	}

	/**
	 * Set or update medicalCertificateBirth with the given MedicalCertificateBirthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateBirth(@NotNull MedicalCertificateBirthEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateHospitalization(@NotNull MedicalCertificateHospitalizationEntity entity) {
		setMedicalCertificateHospitalization(entity, true);
	}

	/**
	 * Set or update medicalCertificateHospitalization with the given MedicalCertificateHospitalizationEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateHospitalization(@NotNull MedicalCertificateHospitalizationEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateMedicalAttendance(@NotNull MedicalCertificateMedicalAttendanceEntity entity) {
		setMedicalCertificateMedicalAttendance(entity, true);
	}

	/**
	 * Set or update medicalCertificateMedicalAttendance with the given MedicalCertificateMedicalAttendanceEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateMedicalAttendance(@NotNull MedicalCertificateMedicalAttendanceEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateMentalHealth(@NotNull MedicalCertificateMentalHealthEntity entity) {
		setMedicalCertificateMentalHealth(entity, true);
	}

	/**
	 * Set or update medicalCertificateMentalHealth with the given MedicalCertificateMentalHealthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateMentalHealth(@NotNull MedicalCertificateMentalHealthEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificatePhysicalHealth(@NotNull MedicalCertificatePhysicalHealthEntity entity) {
		setMedicalCertificatePhysicalHealth(entity, true);
	}

	/**
	 * Set or update medicalCertificatePhysicalHealth with the given MedicalCertificatePhysicalHealthEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificatePhysicalHealth(@NotNull MedicalCertificatePhysicalHealthEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateRestrictedWork(@NotNull MedicalCertificateRestrictedWorkEntity entity) {
		setMedicalCertificateRestrictedWork(entity, true);
	}

	/**
	 * Set or update medicalCertificateRestrictedWork with the given MedicalCertificateRestrictedWorkEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateRestrictedWork(@NotNull MedicalCertificateRestrictedWorkEntity entity, boolean reverseAdd) {
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
	public void setMedicalCertificateSickLeave(@NotNull MedicalCertificateSickLeaveEntity entity) {
		setMedicalCertificateSickLeave(entity, true);
	}

	/**
	 * Set or update medicalCertificateSickLeave with the given MedicalCertificateSickLeaveEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalCertificateSickLeave(@NotNull MedicalCertificateSickLeaveEntity entity, boolean reverseAdd) {
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
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecord with the given MedicalExaminationRecordEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NotNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
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
	public void addMedicalFees(@NotNull MedicalFeeEntity entity) {
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
	public void addMedicalFees(@NotNull Collection<MedicalFeeEntity> entities) {
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
	public void removeMedicalFees(@NotNull MedicalFeeEntity entity) {
		this.removeMedicalFees(entity, true);
	}

	/**
	 * Remove the given MedicalFeeEntity from this entity.
	 *
	 * @param entity the given MedicalFeeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFees(@NotNull MedicalFeeEntity entity, boolean reverse) {
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
	public void removeMedicalFees(@NotNull Collection<MedicalFeeEntity> entities) {
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
	public void setMedicalFees(@NotNull Collection<MedicalFeeEntity> entities) {
		setMedicalFees(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fees with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFees(@NotNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {

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
	public void addMedicationHeaders(@NotNull MedicationHeaderEntity entity) {
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
	public void addMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
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
	public void removeMedicationHeaders(@NotNull MedicationHeaderEntity entity) {
		this.removeMedicationHeaders(entity, true);
	}

	/**
	 * Remove the given MedicationHeaderEntity from this entity.
	 *
	 * @param entity the given MedicationHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationHeaders(@NotNull MedicationHeaderEntity entity, boolean reverse) {
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
	public void removeMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
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
	public void setMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities) {
		setMedicationHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Medication Headers with the given ones.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationHeaders(@NotNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {

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
	public void setPcareExamination(@NotNull PcareExaminationEntity entity) {
		setPcareExamination(entity, true);
	}

	/**
	 * Set or update pcareExamination with the given PcareExaminationEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareExamination(@NotNull PcareExaminationEntity entity, boolean reverseAdd) {
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
	public void addPatientVitalInformations(@NotNull PatientVitalInformationEntity entity) {
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
	public void addPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
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
	public void removePatientVitalInformations(@NotNull PatientVitalInformationEntity entity) {
		this.removePatientVitalInformations(entity, true);
	}

	/**
	 * Remove the given PatientVitalInformationEntity from this entity.
	 *
	 * @param entity the given PatientVitalInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientVitalInformations(@NotNull PatientVitalInformationEntity entity, boolean reverse) {
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
	public void removePatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
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
	public void setPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities) {
		setPatientVitalInformations(entities, true);
	}

	/**
	 * Replace the current entities in Patient Vital Informations with the given ones.
	 *
	 * @param entities the given collection of PatientVitalInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientVitalInformations(@NotNull Collection<PatientVitalInformationEntity> entities, boolean reverseAdd) {

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
	public void addPrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity) {
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
	public void addPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
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
	public void removePrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity) {
		this.removePrescriptionHeaders(entity, true);
	}

	/**
	 * Remove the given PrescriptionHeaderEntity from this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionHeaders(@NotNull PrescriptionHeaderEntity entity, boolean reverse) {
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
	public void removePrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
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
	public void setPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities) {
		setPrescriptionHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Headers with the given ones.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionHeaders(@NotNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {

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
	public void setSep(@NotNull SepEntity entity) {
		setSep(entity, true);
	}

	/**
	 * Set or update sep with the given SepEntity.
	 *
	 * @param entity the RegistrationEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSep(@NotNull SepEntity entity, boolean reverseAdd) {
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
	public void addSampleCollectionInformations(@NotNull SampleCollectionInformationEntity entity) {
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
	public void addSampleCollectionInformations(@NotNull Collection<SampleCollectionInformationEntity> entities) {
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
	public void removeSampleCollectionInformations(@NotNull SampleCollectionInformationEntity entity) {
		this.removeSampleCollectionInformations(entity, true);
	}

	/**
	 * Remove the given SampleCollectionInformationEntity from this entity.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionInformations(@NotNull SampleCollectionInformationEntity entity, boolean reverse) {
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
	public void removeSampleCollectionInformations(@NotNull Collection<SampleCollectionInformationEntity> entities) {
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
	public void setSampleCollectionInformations(@NotNull Collection<SampleCollectionInformationEntity> entities) {
		setSampleCollectionInformations(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Informations with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionInformations(@NotNull Collection<SampleCollectionInformationEntity> entities, boolean reverseAdd) {

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
	public void addVaccinationOrders(@NotNull VaccinationOrderEntity entity) {
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
	public void addVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
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
	public void removeVaccinationOrders(@NotNull VaccinationOrderEntity entity) {
		this.removeVaccinationOrders(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrders(@NotNull VaccinationOrderEntity entity, boolean reverse) {
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
	public void removeVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
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
	public void setVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities) {
		setVaccinationOrders(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Orders with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrders(@NotNull Collection<VaccinationOrderEntity> entities, boolean reverseAdd) {

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
	public void setAdmissionICD10(@NotNull DiagnosesAndProceduresEntity entity) {
		setAdmissionICD10(entity, true);
	}

	/**
	 * Set or update the admissionICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to admissionICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdmissionICD10(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
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
	public void setAdmissionICD9CM(@NotNull DiagnosesAndProceduresEntity entity) {
		setAdmissionICD9CM(entity, true);
	}

	/**
	 * Set or update the admissionICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to admissionICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdmissionICD9CM(@NotNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
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
	public void setDismissalReferringFacility(@NotNull HealthFacilityEntity entity) {
		setDismissalReferringFacility(entity, true);
	}

	/**
	 * Set or update the dismissalReferringFacility in this entity with single HealthFacilityEntity.
	 *
	 * @param entity the given HealthFacilityEntity to be set or updated to dismissalReferringFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDismissalReferringFacility(@NotNull HealthFacilityEntity entity, boolean reverseAdd) {
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
	public void setDismissalReferringStaff(@NotNull StaffEntity entity) {
		setDismissalReferringStaff(entity, true);
	}

	/**
	 * Set or update the dismissalReferringStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to dismissalReferringStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDismissalReferringStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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
	public void setReferringUnit(@NotNull ServiceEntity entity) {
		setReferringUnit(entity, true);
	}

	/**
	 * Set or update the referringUnit in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to referringUnit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReferringUnit(@NotNull ServiceEntity entity, boolean reverseAdd) {
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
	public void setReferringFacility(@NotNull HealthFacilityEntity entity) {
		setReferringFacility(entity, true);
	}

	/**
	 * Set or update the referringFacility in this entity with single HealthFacilityEntity.
	 *
	 * @param entity the given HealthFacilityEntity to be set or updated to referringFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReferringFacility(@NotNull HealthFacilityEntity entity, boolean reverseAdd) {
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
	public void setBedFacility(@NotNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NotNull BedFacilityEntity entity, boolean reverseAdd) {
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
	public void addExaminationItems(@NotNull ExaminationItemEntity entity) {
		this.addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NotNull ExaminationItemEntity entity, boolean reverseAdd) {
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
	public void addExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
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
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from examinationItems
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NotNull ExaminationItemEntity entity, boolean reverse) {
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
	public void removeExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
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
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities) {
		this.setExaminationItems(entities, true);
	}

	/**
	 * Replace the current collection of ExaminationItemEntity in examinationItems with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NotNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
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
	public void setPatientVisit(@NotNull PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(@NotNull PatientVisitEntity entity, boolean reverseAdd) {
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
	public void setService(@NotNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NotNull ServiceEntity entity, boolean reverseAdd) {
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
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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
	public void setRequestedBy(@NotNull StaffEntity entity) {
		setRequestedBy(entity, true);
	}

	/**
	 * Set or update the requestedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to requestedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRequestedBy(@NotNull StaffEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "REGISTRATION_NUMBER,SCHEDULED_DATE,ACTUAL_IN_DATE,DISMISSAL_DATE,DISMISSAL_TYPE,QUEUE_NO,DURATION,TREATMENT_CLASS,BOOKED_TREATMENT_CLASS,SHIFT,CITO,ONE_DAY_CARE,REFERRAL,REGISTRATION_STATUS,REFERRAL_TYPE,PURPOSE,REFERRAL_NOTES,ADMISSION_DIAGNOSIS,UPLOADED_DATE_TIME,VISIT_STATUS,INSTRUCTION,IS_AN_APPOINTMENT,REFERRAL_NUMBER,NOTES,KODEPOLI,DEATH_CERTIFICATE_NO,TIME_OF_DEATH,DISMISSAL_REFERRAL,DISMISSAL_REFERRAL_DETAIL,DISMISSAL_REFERRAL_TYPE,DISMISSAL_REFERRING_NOTES,PATIENT_IS_REFERRED_BACK,MCU_PACKAGE,PARENT_REGISTRATION_NUMBER,IS_UNKNOWN_PATIENT,OTHER_REFERRED_FACILITY,OTHER_REFERRED_STAFF,ADMISSION_ICD_10_ID,ADMISSION_ICD_9_CM_ID,DISMISSAL_REFERRING_FACILITY_ID,DISMISSAL_REFERRING_STAFF_ID,REFERRING_UNIT_ID,REFERRING_FACILITY_ID,DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ID,BED_FACILITY_ID,EXAMINATION_ITEMS_IDS,PATIENT_VISIT_ID,SERVICE_ID,STAFF_ID,REQUESTED_BY_ID,BPJS_PRB_DETAIL_ID,BPJS_PCARE_REGISTRATIONS_ID,BPJS_SEP_ID,BED_RESERVES_IDS,DIAGNOSTIC_EXAMINATION_RESULTS_IDS,FLUID_BALANCE_DETAILS_IDS,INFORMED_CONSENTS_IDS,INVOICE_ITEMS_IDS,MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ID,MEDICAL_CERTIFICATE_BIRTH_ID,MEDICAL_CERTIFICATE_HOSPITALIZATION_ID,MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ID,MEDICAL_CERTIFICATE_MENTAL_HEALTH_ID,MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ID,MEDICAL_CERTIFICATE_RESTRICTED_WORK_ID,MEDICAL_CERTIFICATE_SICK_LEAVE_ID,MEDICAL_EXAMINATION_RECORD_ID,MEDICAL_FEES_IDS,MEDICATION_HEADERS_IDS,PCARE_EXAMINATION_ID,PATIENT_VITAL_INFORMATIONS_IDS,PRESCRIPTION_HEADERS_IDS,SEP_ID,SAMPLE_COLLECTION_INFORMATIONS_IDS,VACCINATION_ORDERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<DiagnosesAndProceduresEntity> admissionICD10Relation = Optional.ofNullable(this.admissionICD10);
		admissionICD10Relation.ifPresent(entity -> this.admissionICD10Id = entity.getId());

		Optional<DiagnosesAndProceduresEntity> admissionICD9CMRelation = Optional.ofNullable(this.admissionICD9CM);
		admissionICD9CMRelation.ifPresent(entity -> this.admissionICD9CMId = entity.getId());

		Optional<HealthFacilityEntity> dismissalReferringFacilityRelation = Optional.ofNullable(this.dismissalReferringFacility);
		dismissalReferringFacilityRelation.ifPresent(entity -> this.dismissalReferringFacilityId = entity.getId());

		Optional<StaffEntity> dismissalReferringStaffRelation = Optional.ofNullable(this.dismissalReferringStaff);
		dismissalReferringStaffRelation.ifPresent(entity -> this.dismissalReferringStaffId = entity.getId());

		Optional<ServiceEntity> referringUnitRelation = Optional.ofNullable(this.referringUnit);
		referringUnitRelation.ifPresent(entity -> this.referringUnitId = entity.getId());

		Optional<HealthFacilityEntity> referringFacilityRelation = Optional.ofNullable(this.referringFacility);
		referringFacilityRelation.ifPresent(entity -> this.referringFacilityId = entity.getId());

		Optional<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaryRelation = Optional.ofNullable(this.diagnosticStaffExaminationSummary);
		diagnosticStaffExaminationSummaryRelation.ifPresent(entity -> this.diagnosticStaffExaminationSummaryId = entity.getId());

		Optional<BedFacilityEntity> bedFacilityRelation = Optional.ofNullable(this.bedFacility);
		bedFacilityRelation.ifPresent(entity -> this.bedFacilityId = entity.getId());

		this.examinationItemsIds = new HashSet<>();
		for (ExaminationItemEntity examinationItems: this.examinationItems) {
			this.examinationItemsIds.add(examinationItems.getId());
		}

		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		Optional<ServiceEntity> serviceRelation = Optional.ofNullable(this.service);
		serviceRelation.ifPresent(entity -> this.serviceId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		Optional<StaffEntity> requestedByRelation = Optional.ofNullable(this.requestedBy);
		requestedByRelation.ifPresent(entity -> this.requestedById = entity.getId());

		Optional<BpjsPRBDetailEntity> bpjsPRBDetailRelation = Optional.ofNullable(this.bpjsPRBDetail);
		bpjsPRBDetailRelation.ifPresent(entity -> this.bpjsPRBDetailId = entity.getId());

		Optional<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsRelation = Optional.ofNullable(this.bpjsPcareRegistrations);
		bpjsPcareRegistrationsRelation.ifPresent(entity -> this.bpjsPcareRegistrationsId = entity.getId());

		Optional<BpjsSEPEntity> bpjsSEPRelation = Optional.ofNullable(this.bpjsSEP);
		bpjsSEPRelation.ifPresent(entity -> this.bpjsSEPId = entity.getId());

		this.bedReservesIds = new HashSet<>();
		for (BedReserveEntity bedReserves: this.bedReserves) {
			this.bedReservesIds.add(bedReserves.getId());
		}

		this.diagnosticExaminationResultsIds = new HashSet<>();
		for (DiagnosticExaminationResultsEntity diagnosticExaminationResults: this.diagnosticExaminationResults) {
			this.diagnosticExaminationResultsIds.add(diagnosticExaminationResults.getId());
		}

		this.fluidBalanceDetailsIds = new HashSet<>();
		for (FluidBalanceDetailEntity fluidBalanceDetails: this.fluidBalanceDetails) {
			this.fluidBalanceDetailsIds.add(fluidBalanceDetails.getId());
		}

		this.informedConsentsIds = new HashSet<>();
		for (InformedConsentEntity informedConsents: this.informedConsents) {
			this.informedConsentsIds.add(informedConsents.getId());
		}

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		Optional<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumeRelation = Optional.ofNullable(this.medicalCertificateDischargeResume);
		medicalCertificateDischargeResumeRelation.ifPresent(entity -> this.medicalCertificateDischargeResumeId = entity.getId());

		Optional<MedicalCertificateBirthEntity> medicalCertificateBirthRelation = Optional.ofNullable(this.medicalCertificateBirth);
		medicalCertificateBirthRelation.ifPresent(entity -> this.medicalCertificateBirthId = entity.getId());

		Optional<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationRelation = Optional.ofNullable(this.medicalCertificateHospitalization);
		medicalCertificateHospitalizationRelation.ifPresent(entity -> this.medicalCertificateHospitalizationId = entity.getId());

		Optional<MedicalCertificateMedicalAttendanceEntity> medicalCertificateMedicalAttendanceRelation = Optional.ofNullable(this.medicalCertificateMedicalAttendance);
		medicalCertificateMedicalAttendanceRelation.ifPresent(entity -> this.medicalCertificateMedicalAttendanceId = entity.getId());

		Optional<MedicalCertificateMentalHealthEntity> medicalCertificateMentalHealthRelation = Optional.ofNullable(this.medicalCertificateMentalHealth);
		medicalCertificateMentalHealthRelation.ifPresent(entity -> this.medicalCertificateMentalHealthId = entity.getId());

		Optional<MedicalCertificatePhysicalHealthEntity> medicalCertificatePhysicalHealthRelation = Optional.ofNullable(this.medicalCertificatePhysicalHealth);
		medicalCertificatePhysicalHealthRelation.ifPresent(entity -> this.medicalCertificatePhysicalHealthId = entity.getId());

		Optional<MedicalCertificateRestrictedWorkEntity> medicalCertificateRestrictedWorkRelation = Optional.ofNullable(this.medicalCertificateRestrictedWork);
		medicalCertificateRestrictedWorkRelation.ifPresent(entity -> this.medicalCertificateRestrictedWorkId = entity.getId());

		Optional<MedicalCertificateSickLeaveEntity> medicalCertificateSickLeaveRelation = Optional.ofNullable(this.medicalCertificateSickLeave);
		medicalCertificateSickLeaveRelation.ifPresent(entity -> this.medicalCertificateSickLeaveId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		this.medicalFeesIds = new HashSet<>();
		for (MedicalFeeEntity medicalFees: this.medicalFees) {
			this.medicalFeesIds.add(medicalFees.getId());
		}

		this.medicationHeadersIds = new HashSet<>();
		for (MedicationHeaderEntity medicationHeaders: this.medicationHeaders) {
			this.medicationHeadersIds.add(medicationHeaders.getId());
		}

		Optional<PcareExaminationEntity> pcareExaminationRelation = Optional.ofNullable(this.pcareExamination);
		pcareExaminationRelation.ifPresent(entity -> this.pcareExaminationId = entity.getId());

		this.patientVitalInformationsIds = new HashSet<>();
		for (PatientVitalInformationEntity patientVitalInformations: this.patientVitalInformations) {
			this.patientVitalInformationsIds.add(patientVitalInformations.getId());
		}

		this.prescriptionHeadersIds = new HashSet<>();
		for (PrescriptionHeaderEntity prescriptionHeaders: this.prescriptionHeaders) {
			this.prescriptionHeadersIds.add(prescriptionHeaders.getId());
		}

		Optional<SepEntity> sepRelation = Optional.ofNullable(this.sep);
		sepRelation.ifPresent(entity -> this.sepId = entity.getId());

		this.sampleCollectionInformationsIds = new HashSet<>();
		for (SampleCollectionInformationEntity sampleCollectionInformations: this.sampleCollectionInformations) {
			this.sampleCollectionInformationsIds.add(sampleCollectionInformations.getId());
		}

		this.vaccinationOrdersIds = new HashSet<>();
		for (VaccinationOrderEntity vaccinationOrders: this.vaccinationOrders) {
			this.vaccinationOrdersIds.add(vaccinationOrders.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object registration) {
		if (this == registration) {
			return true;
		}
		if (registration == null || this.getClass() != registration.getClass()) {
			return false;
		}
		if (!super.equals(registration)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RegistrationEntity that = (RegistrationEntity) registration;
		return
			Objects.equals(this.registrationNumber, that.registrationNumber) &&
			Objects.equals(
			     this.scheduledDate != null ? this.scheduledDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.scheduledDate != null ? that.scheduledDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.actualInDate != null ? this.actualInDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.actualInDate != null ? that.actualInDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.dismissalType, that.dismissalType) &&
			Objects.equals(this.queueNo, that.queueNo) &&
			Objects.equals(this.duration, that.duration) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.bookedTreatmentClass, that.bookedTreatmentClass) &&
			Objects.equals(this.shift, that.shift) &&
			Objects.equals(this.cito, that.cito) &&
			Objects.equals(this.oneDayCare, that.oneDayCare) &&
			Objects.equals(this.referral, that.referral) &&
			Objects.equals(this.registrationStatus, that.registrationStatus) &&
			Objects.equals(this.referralType, that.referralType) &&
			Objects.equals(this.purpose, that.purpose) &&
			Objects.equals(this.referralNotes, that.referralNotes) &&
			Objects.equals(this.admissionDiagnosis, that.admissionDiagnosis) &&
			Objects.equals(
			     this.uploadedDateTime != null ? this.uploadedDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.uploadedDateTime != null ? that.uploadedDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.visitStatus, that.visitStatus) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(this.isAnAppointment, that.isAnAppointment) &&
			Objects.equals(this.referralNumber, that.referralNumber) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.kodepoli, that.kodepoli) &&
			Objects.equals(this.deathCertificateNo, that.deathCertificateNo) &&
			Objects.equals(
			     this.timeOfDeath != null ? this.timeOfDeath.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.timeOfDeath != null ? that.timeOfDeath.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.dismissalReferral, that.dismissalReferral) &&
			Objects.equals(this.dismissalReferralDetail, that.dismissalReferralDetail) &&
			Objects.equals(this.dismissalReferralType, that.dismissalReferralType) &&
			Objects.equals(this.dismissalReferringNotes, that.dismissalReferringNotes) &&
			Objects.equals(this.patientIsReferredBack, that.patientIsReferredBack) &&
			Objects.equals(this.mcuPackage, that.mcuPackage) &&
			Objects.equals(this.parentRegistrationNumber, that.parentRegistrationNumber) &&
			Objects.equals(this.isUnknownPatient, that.isUnknownPatient) &&
			Objects.equals(this.otherReferredFacility, that.otherReferredFacility) &&
			Objects.equals(this.otherReferredStaff, that.otherReferredStaff) &&
			Objects.equals(this.bpjsPRBDetailId, that.bpjsPRBDetailId) &&
			Objects.equals(this.bpjsPcareRegistrationsId, that.bpjsPcareRegistrationsId) &&
			Objects.equals(this.bpjsSEPId, that.bpjsSEPId) &&
			Objects.equals(this.bedReservesIds, that.bedReservesIds) &&
			Objects.equals(this.diagnosticExaminationResultsIds, that.diagnosticExaminationResultsIds) &&
			Objects.equals(this.fluidBalanceDetailsIds, that.fluidBalanceDetailsIds) &&
			Objects.equals(this.informedConsentsIds, that.informedConsentsIds) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.medicalCertificateDischargeResumeId, that.medicalCertificateDischargeResumeId) &&
			Objects.equals(this.medicalCertificateBirthId, that.medicalCertificateBirthId) &&
			Objects.equals(this.medicalCertificateHospitalizationId, that.medicalCertificateHospitalizationId) &&
			Objects.equals(this.medicalCertificateMedicalAttendanceId, that.medicalCertificateMedicalAttendanceId) &&
			Objects.equals(this.medicalCertificateMentalHealthId, that.medicalCertificateMentalHealthId) &&
			Objects.equals(this.medicalCertificatePhysicalHealthId, that.medicalCertificatePhysicalHealthId) &&
			Objects.equals(this.medicalCertificateRestrictedWorkId, that.medicalCertificateRestrictedWorkId) &&
			Objects.equals(this.medicalCertificateSickLeaveId, that.medicalCertificateSickLeaveId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.medicalFeesIds, that.medicalFeesIds) &&
			Objects.equals(this.medicationHeadersIds, that.medicationHeadersIds) &&
			Objects.equals(this.pcareExaminationId, that.pcareExaminationId) &&
			Objects.equals(this.patientVitalInformationsIds, that.patientVitalInformationsIds) &&
			Objects.equals(this.prescriptionHeadersIds, that.prescriptionHeadersIds) &&
			Objects.equals(this.sepId, that.sepId) &&
			Objects.equals(this.sampleCollectionInformationsIds, that.sampleCollectionInformationsIds) &&
			Objects.equals(this.vaccinationOrdersIds, that.vaccinationOrdersIds) &&
			Objects.equals(this.admissionICD10Id, that.admissionICD10Id) &&
			Objects.equals(this.admissionICD9CMId, that.admissionICD9CMId) &&
			Objects.equals(this.dismissalReferringFacilityId, that.dismissalReferringFacilityId) &&
			Objects.equals(this.dismissalReferringStaffId, that.dismissalReferringStaffId) &&
			Objects.equals(this.referringUnitId, that.referringUnitId) &&
			Objects.equals(this.referringFacilityId, that.referringFacilityId) &&
			Objects.equals(this.diagnosticStaffExaminationSummaryId, that.diagnosticStaffExaminationSummaryId) &&
			Objects.equals(this.bedFacilityId, that.bedFacilityId) &&
			Objects.equals(this.patientVisitId, that.patientVisitId) &&
			Objects.equals(this.serviceId, that.serviceId) &&
			Objects.equals(this.staffId, that.staffId) &&
			Objects.equals(this.requestedById, that.requestedById);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
