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

import kmsweb.entities.ServiceItemEntity;
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
public interface ServiceItemRepository extends AbstractRepository<ServiceItemEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Service Item Code.
	 *
	 * @param serviceItemCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Item Code
	 */
	List<ServiceItemEntity> findByServiceItemCode(@NotNull String serviceItemCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Service Item Name.
	 *
	 * @param serviceItemName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Item Name
	 */
	List<ServiceItemEntity> findByServiceItemName(@NotNull String serviceItemName);
	/**
	 * Return an entity or a list of entities that have the given attribute Classification.
	 *
	 * @param classification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Classification
	 */
	List<ServiceItemEntity> findByClassification(@NotNull String classification);
	/**
	 * Return an entity or a list of entities that have the given attribute Apply to all Service.
	 *
	 * @param applyToAllService the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Apply to all Service
	 */
	List<ServiceItemEntity> findByApplyToAllService(@NotNull Boolean applyToAllService);
	/**
	 * Return an entity or a list of entities that have the given attribute Apply To.
	 *
	 * @param applyTo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Apply To
	 */
	List<ServiceItemEntity> findByApplyTo(@NotNull ApplyToEnum applyTo);
	/**
	 * Return an entity or a list of entities that have the given attribute COA COGS.
	 *
	 * @param coaCOGS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA COGS
	 */
	List<ServiceItemEntity> findByCoaCOGS(@NotNull String coaCOGS);
	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	List<ServiceItemEntity> findByCoaSell(@NotNull String coaSell);
	/**
	 * Return an entity or a list of entities that have the given attribute COA Inventory.
	 *
	 * @param coaInventory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Inventory
	 */
	List<ServiceItemEntity> findByCoaInventory(@NotNull String coaInventory);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ServiceItemEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ServiceItemEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}