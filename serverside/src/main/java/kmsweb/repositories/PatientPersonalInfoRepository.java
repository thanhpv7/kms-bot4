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

import kmsweb.entities.PatientPersonalInfoEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface PatientPersonalInfoRepository extends AbstractRepository<PatientPersonalInfoEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Religion.
	 *
	 * @param religion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Religion
	 */
	List<PatientPersonalInfoEntity> findByReligion(@NotNull String religion);
	/**
	 * Return an entity or a list of entities that have the given attribute Nationality.
	 *
	 * @param nationality the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nationality
	 */
	List<PatientPersonalInfoEntity> findByNationality(@NotNull String nationality);
	/**
	 * Return an entity or a list of entities that have the given attribute Ethnicity.
	 *
	 * @param ethnicity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ethnicity
	 */
	List<PatientPersonalInfoEntity> findByEthnicity(@NotNull String ethnicity);
	/**
	 * Return an entity or a list of entities that have the given attribute Blood Type.
	 *
	 * @param bloodType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Type
	 */
	List<PatientPersonalInfoEntity> findByBloodType(@NotNull BloodTypeEnum bloodType);
	/**
	 * Return an entity or a list of entities that have the given attribute Rhesus.
	 *
	 * @param rhesus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rhesus
	 */
	List<PatientPersonalInfoEntity> findByRhesus(@NotNull RhesusEnum rhesus);
	/**
	 * Return an entity or a list of entities that have the given attribute ID Number.
	 *
	 * @param idNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ID Number
	 */
	List<PatientPersonalInfoEntity> findByIdNumber(@NotNull String idNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Occupation.
	 *
	 * @param occupation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Occupation
	 */
	List<PatientPersonalInfoEntity> findByOccupation(@NotNull String occupation);
	/**
	 * Return an entity or a list of entities that have the given attribute External Patient.
	 *
	 * @param externalPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Patient
	 */
	List<PatientPersonalInfoEntity> findByExternalPatient(@NotNull Boolean externalPatient);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Dead.
	 *
	 * @param isDead the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Dead
	 */
	List<PatientPersonalInfoEntity> findByIsDead(@NotNull Boolean isDead);
	/**
	 * Return an entity or a list of entities that have the given attribute External Notes.
	 *
	 * @param externalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Notes
	 */
	List<PatientPersonalInfoEntity> findByExternalNotes(@NotNull String externalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Other ID Number.
	 *
	 * @param otherIDNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other ID Number
	 */
	List<PatientPersonalInfoEntity> findByOtherIDNumber(@NotNull String otherIDNumber);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientPersonalInfoEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PatientPersonalInfoEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}