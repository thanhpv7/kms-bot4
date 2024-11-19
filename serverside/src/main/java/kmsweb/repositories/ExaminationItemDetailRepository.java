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

import kmsweb.entities.ExaminationItemDetailEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface ExaminationItemDetailRepository extends AbstractRepository<ExaminationItemDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Age Minimum.
	 *
	 * @param ageMinimum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age Minimum
	 */
	List<ExaminationItemDetailEntity> findByAgeMinimum(@NotNull Integer ageMinimum);
	/**
	 * Return an entity or a list of entities that have the given attribute Age Maximum.
	 *
	 * @param ageMaximum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age Maximum
	 */
	List<ExaminationItemDetailEntity> findByAgeMaximum(@NotNull Integer ageMaximum);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<ExaminationItemDetailEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Normal Range Low.
	 *
	 * @param normalRangeLow the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Normal Range Low
	 */
	List<ExaminationItemDetailEntity> findByNormalRangeLow(@NotNull Double normalRangeLow);
	/**
	 * Return an entity or a list of entities that have the given attribute Normal Range High.
	 *
	 * @param normalRangeHigh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Normal Range High
	 */
	List<ExaminationItemDetailEntity> findByNormalRangeHigh(@NotNull Double normalRangeHigh);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit.
	 *
	 * @param unit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit
	 */
	List<ExaminationItemDetailEntity> findByUnit(@NotNull String unit);
	/**
	 * Return an entity or a list of entities that have the given attribute Critical Value Low.
	 *
	 * @param criticalValueLow the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Critical Value Low
	 */
	List<ExaminationItemDetailEntity> findByCriticalValueLow(@NotNull Double criticalValueLow);
	/**
	 * Return an entity or a list of entities that have the given attribute Critical Value High.
	 *
	 * @param criticalValueHigh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Critical Value High
	 */
	List<ExaminationItemDetailEntity> findByCriticalValueHigh(@NotNull Double criticalValueHigh);
	/**
	 * Return an entity or a list of entities that have the given attribute Age Min Unit.
	 *
	 * @param ageMinUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age Min Unit
	 */
	List<ExaminationItemDetailEntity> findByAgeMinUnit(@NotNull String ageMinUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Age Max Unit.
	 *
	 * @param ageMaxUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age Max Unit
	 */
	List<ExaminationItemDetailEntity> findByAgeMaxUnit(@NotNull String ageMaxUnit);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ExaminationItemDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ExaminationItemDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}