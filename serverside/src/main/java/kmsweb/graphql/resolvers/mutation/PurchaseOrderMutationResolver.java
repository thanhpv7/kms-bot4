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
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.services.PurchaseOrderService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.GoodsReceiveNoteService;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.services.PurchaseOrderStockDetailService;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.services.PurchaseRequisitionService;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.services.ReturnSupplierService;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.services.SupplierService;
import kmsweb.entities.SupplierEntity;
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
public class PurchaseOrderMutationResolver implements GraphQLMutationResolver {

	private final PurchaseOrderService purchaseOrderService;

	private final GoodsReceiveNoteService goodsReceiveNoteService;

	private final PurchaseOrderStockDetailService purchaseOrderStockDetailService;

	private final PurchaseRequisitionService purchaseRequisitionService;

	private final ReturnSupplierService returnSupplierService;

	private final SupplierService supplierService;

	private final WarehouseService warehouseService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseOrderMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			GoodsReceiveNoteService goodsReceiveNoteService,
			PurchaseOrderStockDetailService purchaseOrderStockDetailService,
			PurchaseRequisitionService purchaseRequisitionService,
			ReturnSupplierService returnSupplierService,
			SupplierService supplierService,
			WarehouseService warehouseService,
			PurchaseOrderService purchaseOrderService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.purchaseOrderService = purchaseOrderService;

		this.goodsReceiveNoteService = goodsReceiveNoteService;

		this.purchaseOrderStockDetailService = purchaseOrderStockDetailService;

		this.purchaseRequisitionService = purchaseRequisitionService;

		this.returnSupplierService = returnSupplierService;

		this.supplierService = supplierService;

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create')")
	public PurchaseOrderEntity createPurchaseOrder(@NonNull PurchaseOrderEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getGoodsReceiveNote() != null) {
			rawEntity.setGoodsReceiveNote(goodsReceiveNoteService.updateOldData(rawEntity.getGoodsReceiveNote()));
		}

		if (rawEntity.getSupplier() != null) {
			rawEntity.setSupplier(supplierService.updateOldData(rawEntity.getSupplier()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();
		rawEntity.getPurchaseOrderStockDetails().forEach(entity -> {
			purchaseOrderStockDetails.add(purchaseOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrderStockDetails(purchaseOrderStockDetails);

		Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();
		rawEntity.getPurchaseRequisitions().forEach(entity -> {
			purchaseRequisitions.add(purchaseRequisitionService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitions(purchaseRequisitions);

		Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();
		rawEntity.getReturnSuppliers().forEach(entity -> {
			returnSuppliers.add(returnSupplierService.updateOldData(entity));
		});
		rawEntity.setReturnSuppliers(returnSuppliers);

		PurchaseOrderEntity newEntity = purchaseOrderService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PurchaseOrderMutationResolver#createPurchaseOrder(PurchaseOrderEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'create')")
	public List<PurchaseOrderEntity> createAllPurchaseOrder(@NonNull List<PurchaseOrderEntity> rawEntities) {
		List<PurchaseOrderEntity> newEntities = Lists.newArrayList(purchaseOrderService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'update')")
	public PurchaseOrderEntity updatePurchaseOrder(@NonNull PurchaseOrderEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getGoodsReceiveNote() != null) {
			rawEntity.setGoodsReceiveNote(goodsReceiveNoteService.updateOldData(rawEntity.getGoodsReceiveNote()));
		}

		if (rawEntity.getSupplier() != null) {
			rawEntity.setSupplier(supplierService.updateOldData(rawEntity.getSupplier()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();
		rawEntity.getPurchaseOrderStockDetails().forEach(entity -> {
			purchaseOrderStockDetails.add(purchaseOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrderStockDetails(purchaseOrderStockDetails);

		Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();
		rawEntity.getPurchaseRequisitions().forEach(entity -> {
			purchaseRequisitions.add(purchaseRequisitionService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitions(purchaseRequisitions);

		Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();
		rawEntity.getReturnSuppliers().forEach(entity -> {
			returnSuppliers.add(returnSupplierService.updateOldData(entity));
		});
		rawEntity.setReturnSuppliers(returnSuppliers);

		PurchaseOrderEntity entityFromDb = purchaseOrderService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PurchaseOrderEntity newEntity = purchaseOrderService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PurchaseOrderMutationResolver#updatePurchaseOrder(PurchaseOrderEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'update')")
	public List<PurchaseOrderEntity> updateAllPurchaseOrder(@NonNull List<PurchaseOrderEntity> rawEntities) {
		List<PurchaseOrderEntity> newEntities = Lists.newArrayList(purchaseOrderService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
	public String deletePurchaseOrderById(@NonNull String id) {
		purchaseOrderService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PurchaseOrderMutationResolver#deletePurchaseOrderById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
	public List<String> deleteAllPurchaseOrderByIds(@NonNull List<String> ids) {
		purchaseOrderService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'delete')")
	public List<String> deletePurchaseOrderExcludingIds(@NonNull List<String> ids) {
		purchaseOrderService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
