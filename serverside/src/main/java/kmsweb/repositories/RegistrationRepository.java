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
package kmsweb.repositories;

import kmsweb.entities.RegistrationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface RegistrationRepository extends AbstractRepository<RegistrationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Registration Number.
	 *
	 * @param registrationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Number
	 */
	List<RegistrationEntity> findByRegistrationNumber(@NotNull String registrationNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Scheduled Date.
	 *
	 * @param scheduledDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Scheduled Date
	 */
	List<RegistrationEntity> findByScheduledDate(@NotNull OffsetDateTime scheduledDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Actual In Date.
	 *
	 * @param actualInDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Actual In Date
	 */
	List<RegistrationEntity> findByActualInDate(@NotNull OffsetDateTime actualInDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<RegistrationEntity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Type.
	 *
	 * @param dismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Type
	 */
	List<RegistrationEntity> findByDismissalType(@NotNull String dismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Queue No.
	 *
	 * @param queueNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Queue No
	 */
	List<RegistrationEntity> findByQueueNo(@NotNull Integer queueNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Duration.
	 *
	 * @param duration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Duration
	 */
	List<RegistrationEntity> findByDuration(@NotNull Integer duration);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<RegistrationEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Booked Treatment Class.
	 *
	 * @param bookedTreatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Booked Treatment Class
	 */
	List<RegistrationEntity> findByBookedTreatmentClass(@NotNull String bookedTreatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Shift.
	 *
	 * @param shift the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shift
	 */
	List<RegistrationEntity> findByShift(@NotNull String shift);
	/**
	 * Return an entity or a list of entities that have the given attribute CITO.
	 *
	 * @param cito the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CITO
	 */
	List<RegistrationEntity> findByCito(@NotNull Boolean cito);
	/**
	 * Return an entity or a list of entities that have the given attribute One Day Care.
	 *
	 * @param oneDayCare the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute One Day Care
	 */
	List<RegistrationEntity> findByOneDayCare(@NotNull Boolean oneDayCare);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral.
	 *
	 * @param referral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral
	 */
	List<RegistrationEntity> findByReferral(@NotNull Boolean referral);
	/**
	 * Return an entity or a list of entities that have the given attribute Registration Status.
	 *
	 * @param registrationStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Status
	 */
	List<RegistrationEntity> findByRegistrationStatus(@NotNull String registrationStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Type.
	 *
	 * @param referralType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Type
	 */
	List<RegistrationEntity> findByReferralType(@NotNull String referralType);
	/**
	 * Return an entity or a list of entities that have the given attribute Purpose.
	 *
	 * @param purpose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purpose
	 */
	List<RegistrationEntity> findByPurpose(@NotNull String purpose);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Notes.
	 *
	 * @param referralNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Notes
	 */
	List<RegistrationEntity> findByReferralNotes(@NotNull String referralNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Admission Diagnosis.
	 *
	 * @param admissionDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Diagnosis
	 */
	List<RegistrationEntity> findByAdmissionDiagnosis(@NotNull String admissionDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute Uploaded Date Time.
	 *
	 * @param uploadedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uploaded Date Time
	 */
	List<RegistrationEntity> findByUploadedDateTime(@NotNull OffsetDateTime uploadedDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Status.
	 *
	 * @param visitStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Status
	 */
	List<RegistrationEntity> findByVisitStatus(@NotNull String visitStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	List<RegistrationEntity> findByInstruction(@NotNull String instruction);
	/**
	 * Return an entity or a list of entities that have the given attribute is An Appointment.
	 *
	 * @param isAnAppointment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute is An Appointment
	 */
	List<RegistrationEntity> findByIsAnAppointment(@NotNull Boolean isAnAppointment);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Number.
	 *
	 * @param referralNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Number
	 */
	List<RegistrationEntity> findByReferralNumber(@NotNull String referralNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<RegistrationEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute kodepoli.
	 *
	 * @param kodepoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodepoli
	 */
	List<RegistrationEntity> findByKodepoli(@NotNull String kodepoli);
	/**
	 * Return an entity or a list of entities that have the given attribute Death Certificate No.
	 *
	 * @param deathCertificateNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Death Certificate No
	 */
	List<RegistrationEntity> findByDeathCertificateNo(@NotNull String deathCertificateNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Time Of Death.
	 *
	 * @param timeOfDeath the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Time Of Death
	 */
	List<RegistrationEntity> findByTimeOfDeath(@NotNull OffsetDateTime timeOfDeath);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral.
	 *
	 * @param dismissalReferral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral
	 */
	List<RegistrationEntity> findByDismissalReferral(@NotNull Boolean dismissalReferral);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral Detail.
	 *
	 * @param dismissalReferralDetail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral Detail
	 */
	List<RegistrationEntity> findByDismissalReferralDetail(@NotNull String dismissalReferralDetail);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral Type.
	 *
	 * @param dismissalReferralType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral Type
	 */
	List<RegistrationEntity> findByDismissalReferralType(@NotNull String dismissalReferralType);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referring Notes.
	 *
	 * @param dismissalReferringNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referring Notes
	 */
	List<RegistrationEntity> findByDismissalReferringNotes(@NotNull String dismissalReferringNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Is Referred Back.
	 *
	 * @param patientIsReferredBack the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Is Referred Back
	 */
	List<RegistrationEntity> findByPatientIsReferredBack(@NotNull Boolean patientIsReferredBack);
	/**
	 * Return an entity or a list of entities that have the given attribute MCU Package.
	 *
	 * @param mcuPackage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MCU Package
	 */
	List<RegistrationEntity> findByMcuPackage(@NotNull String mcuPackage);
	/**
	 * Return an entity or a list of entities that have the given attribute Parent Registration Number.
	 *
	 * @param parentRegistrationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Parent Registration Number
	 */
	List<RegistrationEntity> findByParentRegistrationNumber(@NotNull String parentRegistrationNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Unknown Patient.
	 *
	 * @param isUnknownPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Unknown Patient
	 */
	List<RegistrationEntity> findByIsUnknownPatient(@NotNull Boolean isUnknownPatient);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Referred Facility.
	 *
	 * @param otherReferredFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Referred Facility
	 */
	List<RegistrationEntity> findByOtherReferredFacility(@NotNull String otherReferredFacility);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Referred Staff.
	 *
	 * @param otherReferredStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Referred Staff
	 */
	List<RegistrationEntity> findByOtherReferredStaff(@NotNull String otherReferredStaff);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RegistrationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RegistrationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}