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

import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
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
public interface InpatientMedicalExaminationRecordRepository extends AbstractRepository<InpatientMedicalExaminationRecordEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	List<InpatientMedicalExaminationRecordEntity> findByStartDateTime(@NotNull OffsetDateTime startDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	List<InpatientMedicalExaminationRecordEntity> findByEndDateTime(@NotNull OffsetDateTime endDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<InpatientMedicalExaminationRecordEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Inpatient Case.
	 *
	 * @param inpatientCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inpatient Case
	 */
	List<InpatientMedicalExaminationRecordEntity> findByInpatientCase(@NotNull String inpatientCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Case.
	 *
	 * @param serviceCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Case
	 */
	List<InpatientMedicalExaminationRecordEntity> findByServiceCase(@NotNull String serviceCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Dependency Level.
	 *
	 * @param dependencyLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependency Level
	 */
	List<InpatientMedicalExaminationRecordEntity> findByDependencyLevel(@NotNull String dependencyLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Current Dependency.
	 *
	 * @param currentDependency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Current Dependency
	 */
	List<InpatientMedicalExaminationRecordEntity> findByCurrentDependency(@NotNull String currentDependency);
	/**
	 * Return an entity or a list of entities that have the given attribute Infant Condition.
	 *
	 * @param infantCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Infant Condition
	 */
	List<InpatientMedicalExaminationRecordEntity> findByInfantCondition(@NotNull String infantCondition);
	/**
	 * Return an entity or a list of entities that have the given attribute Neonatal Case.
	 *
	 * @param neonatalCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Neonatal Case
	 */
	List<InpatientMedicalExaminationRecordEntity> findByNeonatalCase(@NotNull String neonatalCase);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InpatientMedicalExaminationRecordEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InpatientMedicalExaminationRecordEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}