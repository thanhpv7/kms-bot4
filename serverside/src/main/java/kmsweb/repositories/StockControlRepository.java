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

import kmsweb.entities.StockControlEntity;
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
public interface StockControlRepository extends AbstractRepository<StockControlEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute On Hand Qty.
	 *
	 * @param onHandQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute On Hand Qty
	 */
	List<StockControlEntity> findByOnHandQty(@NotNull Double onHandQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Qty.
	 *
	 * @param availableQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Qty
	 */
	List<StockControlEntity> findByAvailableQty(@NotNull Double availableQty);
	/**
	 * Return an entity or a list of entities that have the given attribute On Reserved Qty.
	 *
	 * @param onReservedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute On Reserved Qty
	 */
	List<StockControlEntity> findByOnReservedQty(@NotNull Double onReservedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	List<StockControlEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Min Level.
	 *
	 * @param minLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Min Level
	 */
	List<StockControlEntity> findByMinLevel(@NotNull Double minLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Max Level.
	 *
	 * @param maxLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Max Level
	 */
	List<StockControlEntity> findByMaxLevel(@NotNull Double maxLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute In Transit Qty.
	 *
	 * @param inTransitQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute In Transit Qty
	 */
	List<StockControlEntity> findByInTransitQty(@NotNull Double inTransitQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Average Cost.
	 *
	 * @param averageCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Average Cost
	 */
	List<StockControlEntity> findByAverageCost(@NotNull Double averageCost);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockControlEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockControlEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}