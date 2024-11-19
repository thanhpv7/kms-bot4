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

import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
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
public interface ObstetricAndGynecologyHistoryRepository extends AbstractRepository<ObstetricAndGynecologyHistoryEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Gravida.
	 *
	 * @param pregnancyHistoryGravida the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Gravida
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByPregnancyHistoryGravida(@NotNull String pregnancyHistoryGravida);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient History Para.
	 *
	 * @param patientHistoryPara the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient History Para
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByPatientHistoryPara(@NotNull String patientHistoryPara);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient History Abortus.
	 *
	 * @param patientHistoryAbortus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient History Abortus
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByPatientHistoryAbortus(@NotNull String patientHistoryAbortus);
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Notes.
	 *
	 * @param pregnancyHistoryNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Notes
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByPregnancyHistoryNotes(@NotNull String pregnancyHistoryNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Age of Menarche.
	 *
	 * @param ageOfMenarche the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age of Menarche
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByAgeOfMenarche(@NotNull String ageOfMenarche);
	/**
	 * Return an entity or a list of entities that have the given attribute Age of First Sexual Contact.
	 *
	 * @param ageOfFirstSexualContact the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age of First Sexual Contact
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByAgeOfFirstSexualContact(@NotNull String ageOfFirstSexualContact);
	/**
	 * Return an entity or a list of entities that have the given attribute Start Date.
	 *
	 * @param startDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByStartDate(@NotNull OffsetDateTime startDate);
	/**
	 * Return an entity or a list of entities that have the given attribute End Date.
	 *
	 * @param endDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByEndDate(@NotNull OffsetDateTime endDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Approximate Birth Date.
	 *
	 * @param approximateBirthDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approximate Birth Date
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByApproximateBirthDate(@NotNull OffsetDateTime approximateBirthDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Weeks.
	 *
	 * @param gestationAgeWeeks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Weeks
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByGestationAgeWeeks(@NotNull String gestationAgeWeeks);
	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Days.
	 *
	 * @param gestationAgeDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Days
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByGestationAgeDays(@NotNull String gestationAgeDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Maternity History.
	 *
	 * @param maternityHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maternity History
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByMaternityHistory(@NotNull String maternityHistory);
	/**
	 * Return an entity or a list of entities that have the given attribute Gynecology History.
	 *
	 * @param gynecologyHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gynecology History
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByGynecologyHistory(@NotNull String gynecologyHistory);
	/**
	 * Return an entity or a list of entities that have the given attribute Family Plan History.
	 *
	 * @param familyPlanHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Plan History
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByFamilyPlanHistory(@NotNull String familyPlanHistory);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Notes.
	 *
	 * @param otherNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Notes
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByOtherNotes(@NotNull String otherNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Education Level of Patient.
	 *
	 * @param educationLevelOfPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Education Level of Patient
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByEducationLevelOfPatient(@NotNull String educationLevelOfPatient);
	/**
	 * Return an entity or a list of entities that have the given attribute Rupture Of Membrane.
	 *
	 * @param ruptureOfMembrane the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rupture Of Membrane
	 */
	List<ObstetricAndGynecologyHistoryEntity> findByRuptureOfMembrane(@NotNull OffsetDateTime ruptureOfMembrane);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ObstetricAndGynecologyHistoryEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ObstetricAndGynecologyHistoryEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}