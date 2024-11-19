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
import kmsweb.entities.SupplierEntity;
import kmsweb.services.SupplierService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.GoodsReceiveNoteService;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.services.PurchaseOrderService;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.services.PurchaseRequisitionService;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.services.ReturnSupplierService;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.services.SupplierBankAccountService;
import kmsweb.entities.SupplierBankAccountEntity;
import kmsweb.services.SupplierContactDetailService;
import kmsweb.entities.SupplierContactDetailEntity;
import kmsweb.services.SupplierProductDetailService;
import kmsweb.entities.SupplierProductDetailEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class SupplierMutationResolver implements GraphQLMutationResolver {

	private final SupplierService supplierService;

	private final GoodsReceiveNoteService goodsReceiveNoteService;

	private final PurchaseOrderService purchaseOrderService;

	private final PurchaseRequisitionService purchaseRequisitionService;

	private final ReturnSupplierService returnSupplierService;

	private final SupplierBankAccountService supplierBankAccountService;

	private final SupplierContactDetailService supplierContactDetailService;

	private final SupplierProductDetailService supplierProductDetailService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SupplierMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			GoodsReceiveNoteService goodsReceiveNoteService,
			PurchaseOrderService purchaseOrderService,
			PurchaseRequisitionService purchaseRequisitionService,
			ReturnSupplierService returnSupplierService,
			SupplierBankAccountService supplierBankAccountService,
			SupplierContactDetailService supplierContactDetailService,
			SupplierProductDetailService supplierProductDetailService,
			SupplierService supplierService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.supplierService = supplierService;

		this.goodsReceiveNoteService = goodsReceiveNoteService;

		this.purchaseOrderService = purchaseOrderService;

		this.purchaseRequisitionService = purchaseRequisitionService;

		this.returnSupplierService = returnSupplierService;

		this.supplierBankAccountService = supplierBankAccountService;

		this.supplierContactDetailService = supplierContactDetailService;

		this.supplierProductDetailService = supplierProductDetailService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'create')")
	public SupplierEntity createSupplier(@NonNull SupplierEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();
		rawEntity.getGoodsReceiveNotes().forEach(entity -> {
			goodsReceiveNotes.add(goodsReceiveNoteService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNotes(goodsReceiveNotes);

		Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();
		rawEntity.getPurchaseOrders().forEach(entity -> {
			purchaseOrders.add(purchaseOrderService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrders(purchaseOrders);

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

		Set<SupplierContactDetailEntity> suplierContactDetails = new HashSet<>();
		rawEntity.getSuplierContactDetails().forEach(entity -> {
			suplierContactDetails.add(supplierContactDetailService.updateOldData(entity));
		});
		rawEntity.setSuplierContactDetails(suplierContactDetails);

		Set<SupplierBankAccountEntity> supplierBankAccounts = new HashSet<>();
		rawEntity.getSupplierBankAccounts().forEach(entity -> {
			supplierBankAccounts.add(supplierBankAccountService.updateOldData(entity));
		});
		rawEntity.setSupplierBankAccounts(supplierBankAccounts);

		Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();
		rawEntity.getSupplierProductDetails().forEach(entity -> {
			supplierProductDetails.add(supplierProductDetailService.updateOldData(entity));
		});
		rawEntity.setSupplierProductDetails(supplierProductDetails);

		SupplierEntity newEntity = supplierService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SupplierMutationResolver#createSupplier(SupplierEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'create')")
	public List<SupplierEntity> createAllSupplier(@NonNull List<SupplierEntity> rawEntities) {
		List<SupplierEntity> newEntities = Lists.newArrayList(supplierService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('SupplierEntity', 'update')")
	public SupplierEntity updateSupplier(@NonNull SupplierEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();
		rawEntity.getGoodsReceiveNotes().forEach(entity -> {
			goodsReceiveNotes.add(goodsReceiveNoteService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNotes(goodsReceiveNotes);

		Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();
		rawEntity.getPurchaseOrders().forEach(entity -> {
			purchaseOrders.add(purchaseOrderService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrders(purchaseOrders);

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

		Set<SupplierContactDetailEntity> suplierContactDetails = new HashSet<>();
		rawEntity.getSuplierContactDetails().forEach(entity -> {
			suplierContactDetails.add(supplierContactDetailService.updateOldData(entity));
		});
		rawEntity.setSuplierContactDetails(suplierContactDetails);

		Set<SupplierBankAccountEntity> supplierBankAccounts = new HashSet<>();
		rawEntity.getSupplierBankAccounts().forEach(entity -> {
			supplierBankAccounts.add(supplierBankAccountService.updateOldData(entity));
		});
		rawEntity.setSupplierBankAccounts(supplierBankAccounts);

		Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();
		rawEntity.getSupplierProductDetails().forEach(entity -> {
			supplierProductDetails.add(supplierProductDetailService.updateOldData(entity));
		});
		rawEntity.setSupplierProductDetails(supplierProductDetails);

		SupplierEntity entityFromDb = supplierService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		SupplierEntity newEntity = supplierService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link SupplierMutationResolver#updateSupplier(SupplierEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'update')")
	public List<SupplierEntity> updateAllSupplier(@NonNull List<SupplierEntity> rawEntities) {
		List<SupplierEntity> newEntities = Lists.newArrayList(supplierService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
	public String deleteSupplierById(@NonNull String id) {
		supplierService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link SupplierMutationResolver#deleteSupplierById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
	public List<String> deleteAllSupplierByIds(@NonNull List<String> ids) {
		supplierService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('SupplierEntity', 'delete')")
	public List<String> deleteSupplierExcludingIds(@NonNull List<String> ids) {
		supplierService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
