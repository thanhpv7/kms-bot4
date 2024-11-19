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

import kmsweb.entities.WarehouseEntity;
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
public interface WarehouseRepository extends AbstractRepository<WarehouseEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Warehouse Number.
	 *
	 * @param warehouseNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Warehouse Number
	 */
	Optional<WarehouseEntity> findByWarehouseNumber(@NotNull String warehouseNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Warehouse Name.
	 *
	 * @param warehouseName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Warehouse Name
	 */
	List<WarehouseEntity> findByWarehouseName(@NotNull String warehouseName);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<WarehouseEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<WarehouseEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person.
	 *
	 * @param contactPerson the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person
	 */
	List<WarehouseEntity> findByContactPerson(@NotNull String contactPerson);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<WarehouseEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Ext.
	 *
	 * @param ext the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ext
	 */
	List<WarehouseEntity> findByExt(@NotNull String ext);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	List<WarehouseEntity> findByMobilePhoneNumber(@NotNull String mobilePhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<WarehouseEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	List<WarehouseEntity> findByRevenueCenter(@NotNull String revenueCenter);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<WarehouseEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<WarehouseEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}