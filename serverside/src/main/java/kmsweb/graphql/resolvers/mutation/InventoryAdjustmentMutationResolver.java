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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.services.InventoryAdjustmentService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InventoryAdjustmentItemService;
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.services.TransactionDetailTypeService;
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.services.WarehouseService;
import kmsweb.entities.WarehouseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class InventoryAdjustmentMutationResolver implements GraphQLMutationResolver {

	private final InventoryAdjustmentService inventoryAdjustmentService;

	private final InventoryAdjustmentItemService inventoryAdjustmentItemService;

	private final TransactionDetailTypeService transactionDetailTypeService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InventoryAdjustmentMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InventoryAdjustmentItemService inventoryAdjustmentItemService,
			TransactionDetailTypeService transactionDetailTypeService,
			WarehouseService warehouseService,
			InventoryAdjustmentService inventoryAdjustmentService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.inventoryAdjustmentService = inventoryAdjustmentService;

		this.inventoryAdjustmentItemService = inventoryAdjustmentItemService;

		this.transactionDetailTypeService = transactionDetailTypeService;

		this.warehouseService = warehouseService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'create')")
	public InventoryAdjustmentEntity createInventoryAdjustment(@NonNull InventoryAdjustmentEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getTransactionDetailType() != null) {
			rawEntity.setTransactionDetailType(transactionDetailTypeService.updateOldData(rawEntity.getTransactionDetailType()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();
		rawEntity.getInventoryAdjustmentItems().forEach(entity -> {
			inventoryAdjustmentItems.add(inventoryAdjustmentItemService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustmentItems(inventoryAdjustmentItems);

		InventoryAdjustmentEntity newEntity = inventoryAdjustmentService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InventoryAdjustmentMutationResolver#createInventoryAdjustment(InventoryAdjustmentEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'create')")
	public List<InventoryAdjustmentEntity> createAllInventoryAdjustment(@NonNull List<InventoryAdjustmentEntity> rawEntities) {
		List<InventoryAdjustmentEntity> newEntities = Lists.newArrayList(inventoryAdjustmentService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'update')")
	public InventoryAdjustmentEntity updateInventoryAdjustment(@NonNull InventoryAdjustmentEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getTransactionDetailType() != null) {
			rawEntity.setTransactionDetailType(transactionDetailTypeService.updateOldData(rawEntity.getTransactionDetailType()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();
		rawEntity.getInventoryAdjustmentItems().forEach(entity -> {
			inventoryAdjustmentItems.add(inventoryAdjustmentItemService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustmentItems(inventoryAdjustmentItems);

		InventoryAdjustmentEntity entityFromDb = inventoryAdjustmentService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		InventoryAdjustmentEntity newEntity = inventoryAdjustmentService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link InventoryAdjustmentMutationResolver#updateInventoryAdjustment(InventoryAdjustmentEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'update')")
	public List<InventoryAdjustmentEntity> updateAllInventoryAdjustment(@NonNull List<InventoryAdjustmentEntity> rawEntities) {
		List<InventoryAdjustmentEntity> newEntities = Lists.newArrayList(inventoryAdjustmentService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'delete')")
	public String deleteInventoryAdjustmentById(@NonNull String id) {
		inventoryAdjustmentService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link InventoryAdjustmentMutationResolver#deleteInventoryAdjustmentById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'delete')")
	public List<String> deleteAllInventoryAdjustmentByIds(@NonNull List<String> ids) {
		inventoryAdjustmentService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'delete')")
	public List<String> deleteInventoryAdjustmentExcludingIds(@NonNull List<String> ids) {
		inventoryAdjustmentService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
