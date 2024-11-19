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
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.services.BatchStockBalanceService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.StockCatalogueService;
import kmsweb.entities.StockCatalogueEntity;
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
public class BatchStockBalanceMutationResolver implements GraphQLMutationResolver {

	private final BatchStockBalanceService batchStockBalanceService;

	private final StockCatalogueService stockCatalogueService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BatchStockBalanceMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			StockCatalogueService stockCatalogueService,
			WarehouseService warehouseService,
			BatchStockBalanceService batchStockBalanceService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.batchStockBalanceService = batchStockBalanceService;

		this.stockCatalogueService = stockCatalogueService;

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
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'create')")
	public BatchStockBalanceEntity createBatchStockBalance(@NonNull BatchStockBalanceEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		BatchStockBalanceEntity newEntity = batchStockBalanceService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BatchStockBalanceMutationResolver#createBatchStockBalance(BatchStockBalanceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'create')")
	public List<BatchStockBalanceEntity> createAllBatchStockBalance(@NonNull List<BatchStockBalanceEntity> rawEntities) {
		List<BatchStockBalanceEntity> newEntities = Lists.newArrayList(batchStockBalanceService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'update')")
	public BatchStockBalanceEntity updateBatchStockBalance(@NonNull BatchStockBalanceEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		BatchStockBalanceEntity entityFromDb = batchStockBalanceService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		BatchStockBalanceEntity newEntity = batchStockBalanceService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link BatchStockBalanceMutationResolver#updateBatchStockBalance(BatchStockBalanceEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'update')")
	public List<BatchStockBalanceEntity> updateAllBatchStockBalance(@NonNull List<BatchStockBalanceEntity> rawEntities) {
		List<BatchStockBalanceEntity> newEntities = Lists.newArrayList(batchStockBalanceService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'delete')")
	public String deleteBatchStockBalanceById(@NonNull String id) {
		batchStockBalanceService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link BatchStockBalanceMutationResolver#deleteBatchStockBalanceById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'delete')")
	public List<String> deleteAllBatchStockBalanceByIds(@NonNull List<String> ids) {
		batchStockBalanceService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'delete')")
	public List<String> deleteBatchStockBalanceExcludingIds(@NonNull List<String> ids) {
		batchStockBalanceService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
