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

import kmsweb.entities.ExaminationItemEntity;
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
public interface ExaminationItemRepository extends AbstractRepository<ExaminationItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Item Code.
	 *
	 * @param itemCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Code
	 */
	Optional<ExaminationItemEntity> findByItemCode(@NotNull String itemCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<ExaminationItemEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute Sample.
	 *
	 * @param sample the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample
	 */
	List<ExaminationItemEntity> findBySample(@NotNull String sample);
	/**
	 * Return an entity or a list of entities that have the given attribute Examination Level.
	 *
	 * @param examinationLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Level
	 */
	List<ExaminationItemEntity> findByExaminationLevel(@NotNull String examinationLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Examination Type.
	 *
	 * @param examinationType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Type
	 */
	List<ExaminationItemEntity> findByExaminationType(@NotNull String examinationType);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ExaminationItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ExaminationItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}