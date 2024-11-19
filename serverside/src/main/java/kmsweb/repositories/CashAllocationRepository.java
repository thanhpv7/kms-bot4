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

import kmsweb.entities.CashAllocationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
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
public interface CashAllocationRepository extends AbstractRepository<CashAllocationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Cash Type.
	 *
	 * @param cashType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cash Type
	 */
	List<CashAllocationEntity> findByCashType(@NotNull CashTypeEnum cashType);
	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Date.
	 *
	 * @param allocatedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Date
	 */
	List<CashAllocationEntity> findByAllocatedDate(@NotNull OffsetDateTime allocatedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Date.
	 *
	 * @param sourceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Date
	 */
	List<CashAllocationEntity> findBySourceDate(@NotNull OffsetDateTime sourceDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Cash Number.
	 *
	 * @param cashNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cash Number
	 */
	List<CashAllocationEntity> findByCashNumber(@NotNull String cashNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Document Type.
	 *
	 * @param sourceDocumentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Document Type
	 */
	List<CashAllocationEntity> findBySourceDocumentType(@NotNull SourceDocumentTypeEnum sourceDocumentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Number.
	 *
	 * @param sourceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Number
	 */
	List<CashAllocationEntity> findBySourceNumber(@NotNull String sourceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Source Amount.
	 *
	 * @param sourceAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Amount
	 */
	List<CashAllocationEntity> findBySourceAmount(@NotNull Double sourceAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	List<CashAllocationEntity> findByOutstandingAmount(@NotNull Double outstandingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Amount.
	 *
	 * @param allocatedAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Amount
	 */
	List<CashAllocationEntity> findByAllocatedAmount(@NotNull Double allocatedAmount);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashAllocationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashAllocationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}