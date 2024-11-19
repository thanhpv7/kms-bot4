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

import kmsweb.entities.PatientConsentEntity;
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
public interface PatientConsentRepository extends AbstractRepository<PatientConsentEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Consent Date Time.
	 *
	 * @param consentDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consent Date Time
	 */
	List<PatientConsentEntity> findByConsentDateTime(@NotNull OffsetDateTime consentDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Consent On Payment Terms.
	 *
	 * @param consentOnPaymentTerms the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consent On Payment Terms
	 */
	List<PatientConsentEntity> findByConsentOnPaymentTerms(@NotNull String consentOnPaymentTerms);
	/**
	 * Return an entity or a list of entities that have the given attribute Consent On Hospital Regulations.
	 *
	 * @param consentOnHospitalRegulations the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consent On Hospital Regulations
	 */
	List<PatientConsentEntity> findByConsentOnHospitalRegulations(@NotNull String consentOnHospitalRegulations);
	/**
	 * Return an entity or a list of entities that have the given attribute Need Interpreter.
	 *
	 * @param needInterpreter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Need Interpreter
	 */
	List<PatientConsentEntity> findByNeedInterpreter(@NotNull String needInterpreter);
	/**
	 * Return an entity or a list of entities that have the given attribute Need Religious Counselor.
	 *
	 * @param needReligiousCounselor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Need Religious Counselor
	 */
	List<PatientConsentEntity> findByNeedReligiousCounselor(@NotNull String needReligiousCounselor);
	/**
	 * Return an entity or a list of entities that have the given attribute Dgs Results Released To Insurer.
	 *
	 * @param dgsResultsReleasedToInsurer the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dgs Results Released To Insurer
	 */
	List<PatientConsentEntity> findByDgsResultsReleasedToInsurer(@NotNull String dgsResultsReleasedToInsurer);
	/**
	 * Return an entity or a list of entities that have the given attribute Dgs Results Released To Students.
	 *
	 * @param dgsResultsReleasedToStudents the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dgs Results Released To Students
	 */
	List<PatientConsentEntity> findByDgsResultsReleasedToStudents(@NotNull String dgsResultsReleasedToStudents);
	/**
	 * Return an entity or a list of entities that have the given attribute Record Released To Family Member.
	 *
	 * @param recordReleasedToFamilyMember the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Record Released To Family Member
	 */
	List<PatientConsentEntity> findByRecordReleasedToFamilyMember(@NotNull String recordReleasedToFamilyMember);
	/**
	 * Return an entity or a list of entities that have the given attribute Record Released To Certain Health Facilities.
	 *
	 * @param recordReleasedToCertainHealthFacilities the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Record Released To Certain Health Facilities
	 */
	List<PatientConsentEntity> findByRecordReleasedToCertainHealthFacilities(@NotNull String recordReleasedToCertainHealthFacilities);
	/**
	 * Return an entity or a list of entities that have the given attribute Staff Signature.
	 *
	 * @param staffSignature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Signature
	 */
	List<PatientConsentEntity> findByStaffSignature(@NotNull String staffSignature);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Signature.
	 *
	 * @param consentingPartySignature the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Signature
	 */
	List<PatientConsentEntity> findByConsentingPartySignature(@NotNull String consentingPartySignature);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Type.
	 *
	 * @param consentingPartyType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Type
	 */
	List<PatientConsentEntity> findByConsentingPartyType(@NotNull String consentingPartyType);
	/**
	 * Return an entity or a list of entities that have the given attribute Consenting Party Name.
	 *
	 * @param consentingPartyName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consenting Party Name
	 */
	List<PatientConsentEntity> findByConsentingPartyName(@NotNull String consentingPartyName);
	/**
	 * Return an entity or a list of entities that have the given attribute Information Released To Satusehat.
	 *
	 * @param informationReleasedToSatusehat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Information Released To Satusehat
	 */
	List<PatientConsentEntity> findByInformationReleasedToSatusehat(@NotNull String informationReleasedToSatusehat);
	/**
	 * Return an entity or a list of entities that have the given attribute Emr Released To Satusehat.
	 *
	 * @param emrReleasedToSatusehat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Emr Released To Satusehat
	 */
	List<PatientConsentEntity> findByEmrReleasedToSatusehat(@NotNull String emrReleasedToSatusehat);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientConsentEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientConsentEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}