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
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.services.TransferOrderStockDetailService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;
import kmsweb.services.StockCatalogueService;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.services.TransferOrderService;
import kmsweb.entities.TransferOrderEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class TransferOrderStockDetailMutationResolver implements GraphQLMutationResolver {

	private final TransferOrderStockDetailService transferOrderStockDetailService;

	private final StaffService staffService;

	private final StockCatalogueService stockCatalogueService;

	private final TransferOrderService transferOrderService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TransferOrderStockDetailMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			StaffService staffService,
			StockCatalogueService stockCatalogueService,
			TransferOrderService transferOrderService,
			TransferOrderStockDetailService transferOrderStockDetailService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.transferOrderStockDetailService = transferOrderStockDetailService;

		this.staffService = staffService;

		this.stockCatalogueService = stockCatalogueService;

		this.transferOrderService = transferOrderService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create')")
	public TransferOrderStockDetailEntity createTransferOrderStockDetail(@NonNull TransferOrderStockDetailEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getTransferOrder() != null) {
			rawEntity.setTransferOrder(transferOrderService.updateOldData(rawEntity.getTransferOrder()));
		}

		TransferOrderStockDetailEntity newEntity = transferOrderStockDetailService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TransferOrderStockDetailMutationResolver#createTransferOrderStockDetail(TransferOrderStockDetailEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create')")
	public List<TransferOrderStockDetailEntity> createAllTransferOrderStockDetail(@NonNull List<TransferOrderStockDetailEntity> rawEntities) {
		List<TransferOrderStockDetailEntity> newEntities = Lists.newArrayList(transferOrderStockDetailService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'update')")
	public TransferOrderStockDetailEntity updateTransferOrderStockDetail(@NonNull TransferOrderStockDetailEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getStockCatalogue() != null) {
			rawEntity.setStockCatalogue(stockCatalogueService.updateOldData(rawEntity.getStockCatalogue()));
		}

		if (rawEntity.getTransferOrder() != null) {
			rawEntity.setTransferOrder(transferOrderService.updateOldData(rawEntity.getTransferOrder()));
		}

		TransferOrderStockDetailEntity entityFromDb = transferOrderStockDetailService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		TransferOrderStockDetailEntity newEntity = transferOrderStockDetailService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link TransferOrderStockDetailMutationResolver#updateTransferOrderStockDetail(TransferOrderStockDetailEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'update')")
	public List<TransferOrderStockDetailEntity> updateAllTransferOrderStockDetail(@NonNull List<TransferOrderStockDetailEntity> rawEntities) {
		List<TransferOrderStockDetailEntity> newEntities = Lists.newArrayList(transferOrderStockDetailService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
	public String deleteTransferOrderStockDetailById(@NonNull String id) {
		transferOrderStockDetailService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link TransferOrderStockDetailMutationResolver#deleteTransferOrderStockDetailById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
	public List<String> deleteAllTransferOrderStockDetailByIds(@NonNull List<String> ids) {
		transferOrderStockDetailService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
	public List<String> deleteTransferOrderStockDetailExcludingIds(@NonNull List<String> ids) {
		transferOrderStockDetailService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
