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
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.services.TransactionDetailTypeService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.InventoryAdjustmentService;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.services.StockTransactionDetailService;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.services.StockTransactionPerDateTypeService;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.services.TransactionDetailTypeMappingService;
import kmsweb.entities.TransactionDetailTypeMappingEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class TransactionDetailTypeMutationResolver implements GraphQLMutationResolver {

	private final TransactionDetailTypeService transactionDetailTypeService;

	private final InventoryAdjustmentService inventoryAdjustmentService;

	private final StockTransactionDetailService stockTransactionDetailService;

	private final StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	private final TransactionDetailTypeMappingService transactionDetailTypeMappingService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TransactionDetailTypeMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			InventoryAdjustmentService inventoryAdjustmentService,
			StockTransactionDetailService stockTransactionDetailService,
			StockTransactionPerDateTypeService stockTransactionPerDateTypeService,
			TransactionDetailTypeMappingService transactionDetailTypeMappingService,
			TransactionDetailTypeService transactionDetailTypeService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.transactionDetailTypeService = transactionDetailTypeService;

		this.inventoryAdjustmentService = inventoryAdjustmentService;

		this.stockTransactionDetailService = stockTransactionDetailService;

		this.stockTransactionPerDateTypeService = stockTransactionPerDateTypeService;

		this.transactionDetailTypeMappingService = transactionDetailTypeMappingService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create')")
	public TransactionDetailTypeEntity createTransactionDetailType(@NonNull TransactionDetailTypeEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();
		rawEntity.getInventoryAdjustments().forEach(entity -> {
			inventoryAdjustments.add(inventoryAdjustmentService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustments(inventoryAdjustments);

		Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();
		rawEntity.getStockTransactionDetails().forEach(entity -> {
			stockTransactionDetails.add(stockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setStockTransactionDetails(stockTransactionDetails);

		Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();
		rawEntity.getStockTransactionPerDateTypes().forEach(entity -> {
			stockTransactionPerDateTypes.add(stockTransactionPerDateTypeService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDateTypes(stockTransactionPerDateTypes);

		Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappings = new HashSet<>();
		rawEntity.getTransactionDetailTypeMappings().forEach(entity -> {
			transactionDetailTypeMappings.add(transactionDetailTypeMappingService.updateOldData(entity));
		});
		rawEntity.setTransactionDetailTypeMappings(transactionDetailTypeMappings);

		TransactionDetailTypeEntity newEntity = transactionDetailTypeService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TransactionDetailTypeMutationResolver#createTransactionDetailType(TransactionDetailTypeEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create')")
	public List<TransactionDetailTypeEntity> createAllTransactionDetailType(@NonNull List<TransactionDetailTypeEntity> rawEntities) {
		List<TransactionDetailTypeEntity> newEntities = Lists.newArrayList(transactionDetailTypeService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'update')")
	public TransactionDetailTypeEntity updateTransactionDetailType(@NonNull TransactionDetailTypeEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();
		rawEntity.getInventoryAdjustments().forEach(entity -> {
			inventoryAdjustments.add(inventoryAdjustmentService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustments(inventoryAdjustments);

		Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();
		rawEntity.getStockTransactionDetails().forEach(entity -> {
			stockTransactionDetails.add(stockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setStockTransactionDetails(stockTransactionDetails);

		Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();
		rawEntity.getStockTransactionPerDateTypes().forEach(entity -> {
			stockTransactionPerDateTypes.add(stockTransactionPerDateTypeService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDateTypes(stockTransactionPerDateTypes);

		Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappings = new HashSet<>();
		rawEntity.getTransactionDetailTypeMappings().forEach(entity -> {
			transactionDetailTypeMappings.add(transactionDetailTypeMappingService.updateOldData(entity));
		});
		rawEntity.setTransactionDetailTypeMappings(transactionDetailTypeMappings);

		TransactionDetailTypeEntity entityFromDb = transactionDetailTypeService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		TransactionDetailTypeEntity newEntity = transactionDetailTypeService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TransactionDetailTypeMutationResolver#updateTransactionDetailType(TransactionDetailTypeEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'update')")
	public List<TransactionDetailTypeEntity> updateAllTransactionDetailType(@NonNull List<TransactionDetailTypeEntity> rawEntities) {
		List<TransactionDetailTypeEntity> newEntities = Lists.newArrayList(transactionDetailTypeService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
	public String deleteTransactionDetailTypeById(@NonNull String id) {
		transactionDetailTypeService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link TransactionDetailTypeMutationResolver#deleteTransactionDetailTypeById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
	public List<String> deleteAllTransactionDetailTypeByIds(@NonNull List<String> ids) {
		transactionDetailTypeService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
	public List<String> deleteTransactionDetailTypeExcludingIds(@NonNull List<String> ids) {
		transactionDetailTypeService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
