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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PurchaseOrderEntity extends AbstractEntity {

	public PurchaseOrderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PurchaseOrderStockDetailsOneMany = new EntityReference();
			PurchaseOrderStockDetailsOneMany.entityName = "PurchaseOrderStockDetail";
			PurchaseOrderStockDetailsOneMany.oppositeName = "PurchaseOrder";
			PurchaseOrderStockDetailsOneMany.name = "PurchaseOrderStockDetails";
			PurchaseOrderStockDetailsOneMany.optional = true;
			PurchaseOrderStockDetailsOneMany.type = "One";
			PurchaseOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(PurchaseOrderStockDetailsOneMany);

		var GoodsReceiveNoteOneMany = new EntityReference();
			GoodsReceiveNoteOneMany.entityName = "GoodsReceiveNote";
			GoodsReceiveNoteOneMany.oppositeName = "GoodsReceiveNote";
			GoodsReceiveNoteOneMany.name = "PurchaseOrders";
			GoodsReceiveNoteOneMany.optional = true;
			GoodsReceiveNoteOneMany.type = "One";
			GoodsReceiveNoteOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteOneMany);

		var SupplierOneMany = new EntityReference();
			SupplierOneMany.entityName = "Supplier";
			SupplierOneMany.oppositeName = "Supplier";
			SupplierOneMany.name = "PurchaseOrders";
			SupplierOneMany.optional = true;
			SupplierOneMany.type = "One";
			SupplierOneMany.oppositeType = "Many";

		References.add(SupplierOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "PurchaseOrders";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var PurchaseRequisitionsOneMany = new EntityReference();
			PurchaseRequisitionsOneMany.entityName = "PurchaseRequisition";
			PurchaseRequisitionsOneMany.oppositeName = "PurchaseOrder";
			PurchaseRequisitionsOneMany.name = "PurchaseRequisitions";
			PurchaseRequisitionsOneMany.optional = true;
			PurchaseRequisitionsOneMany.type = "One";
			PurchaseRequisitionsOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionsOneMany);

		var ReturnSuppliersOneMany = new EntityReference();
			ReturnSuppliersOneMany.entityName = "ReturnSupplier";
			ReturnSuppliersOneMany.oppositeName = "PurchaseOrder";
			ReturnSuppliersOneMany.name = "ReturnSuppliers";
			ReturnSuppliersOneMany.optional = true;
			ReturnSuppliersOneMany.type = "One";
			ReturnSuppliersOneMany.oppositeType = "Many";

		References.add(ReturnSuppliersOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Purchase Order Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Order Type here] end
	private String purchaseOrderType;

	// % protected region % [Modify attribute annotation for Purchase Order Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Order Number here] end
	private String purchaseOrderNumber;

	// % protected region % [Modify attribute annotation for status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Expected Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expected Date here] end
	private OffsetDateTime expectedDate;

	// % protected region % [Modify attribute annotation for Price VAT Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price VAT Included here] end
	private Boolean priceVATIncluded;

	// % protected region % [Modify attribute annotation for Inventory VAT Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory VAT Included here] end
	private Boolean inventoryVATIncluded;

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Supplier Reference Document here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Reference Document here] end
	private String supplierReferenceDocument;

	// % protected region % [Modify attribute annotation for Payment Terms here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Terms here] end
	private String paymentTerms;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Extra Discount In Percent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount In Percent here] end
	private Boolean extraDiscountInPercent;

	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] end
	private Boolean extraDiscountIncludeTax;

	// % protected region % [Modify attribute annotation for Extra Discount Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount Value here] end
	private Double extraDiscountValue;

	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] end
	private Boolean freightFeeIncludeTax;

	// % protected region % [Modify attribute annotation for Freight Fee Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Freight Fee Value here] end
	private Double freightFeeValue;

	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] end
	private Boolean otherFeeIncludeTax;

	// % protected region % [Modify attribute annotation for Other Fee Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Fee Value here] end
	private Double otherFeeValue;

	// % protected region % [Modify attribute annotation for Tax Base here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Base here] end
	private Double taxBase;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

	// % protected region % [Modify attribute annotation for Total Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Amount here] end
	private Double totalAmount;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private GoodsReceiveNoteEntity goodsReceiveNote;

	private SupplierEntity supplier;

	private WarehouseEntity warehouse;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		addPurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseOrderStockDetailEntity to purchaseOrderStockDetails in this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrderStockDetails.contains(entity)) {
			purchaseOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		addPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderStockDetailEntity to Purchase Order Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		this.removePurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.purchaseOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		this.removePurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		setPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrderStockDetails();
		this.purchaseOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrderStockDetails() {
		this.unsetPurchaseOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetPurchaseOrder(false));
		}
		this.purchaseOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		addPurchaseRequisitions(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionEntity to purchaseRequisitions in this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitions.contains(entity)) {
			purchaseRequisitions.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		addPurchaseRequisitions(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionEntity to Purchase Requisitions in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		this.removePurchaseRequisitions(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.purchaseRequisitions.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		this.removePurchaseRequisitions(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		setPurchaseRequisitions(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisitions with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitions();
		this.purchaseRequisitions = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitions() {
		this.unsetPurchaseRequisitions(true);
	}

	/**
	 * Remove all the entities in Purchase Requisitions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitions(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.unsetPurchaseOrder(false));
		}
		this.purchaseRequisitions.clear();
	}

/**
	 * Similar to {@link this#addReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		addReturnSuppliers(entity, true);
	}

	/**
	 * Add a new ReturnSupplierEntity to returnSuppliers in this entity.
	 *
	 * @param entity the given ReturnSupplierEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverseAdd) {
		if (!this.returnSuppliers.contains(entity)) {
			returnSuppliers.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		addReturnSuppliers(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierEntity to Return Suppliers in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		this.removeReturnSuppliers(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.returnSuppliers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		this.removeReturnSuppliers(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		setReturnSuppliers(entities, true);
	}

	/**
	 * Replace the current entities in Return Suppliers with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {

		this.unsetReturnSuppliers();
		this.returnSuppliers = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSuppliers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSuppliers() {
		this.unsetReturnSuppliers(true);
	}

	/**
	 * Remove all the entities in Return Suppliers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSuppliers(boolean doReverse) {
		if (doReverse) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.unsetPurchaseOrder(false));
		}
		this.returnSuppliers.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setGoodsReceiveNote(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNote(@NonNull GoodsReceiveNoteEntity entity) {
		setGoodsReceiveNote(entity, true);
	}

	/**
	 * Set or update the goodsReceiveNote in this entity with single GoodsReceiveNoteEntity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set or updated to goodsReceiveNote
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setGoodsReceiveNote(@NonNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] off begin
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] end

		if (sameAsFormer(this.goodsReceiveNote, entity)) {
			return;
		}

		if (this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removePurchaseOrders(this, false);
		}
		this.goodsReceiveNote = entity;
		if (reverseAdd) {
			this.goodsReceiveNote.addPurchaseOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNote(boolean)} but default to true.
	 */
	public void unsetGoodsReceiveNote() {
		this.unsetGoodsReceiveNote(true);
	}

	/**
	 * Remove Goods Receive Note in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetGoodsReceiveNote(boolean reverse) {
		if (reverse && this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removePurchaseOrders(this, false);
		}
		this.goodsReceiveNote = null;
	}
	/**
	 * Similar to {@link this#setSupplier(SupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierEntity to be set to this entity
	 */
	public void setSupplier(@NonNull SupplierEntity entity) {
		setSupplier(entity, true);
	}

	/**
	 * Set or update the supplier in this entity with single SupplierEntity.
	 *
	 * @param entity the given SupplierEntity to be set or updated to supplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSupplier(@NonNull SupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] end

		if (sameAsFormer(this.supplier, entity)) {
			return;
		}

		if (this.supplier != null) {
			this.supplier.removePurchaseOrders(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addPurchaseOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSupplier(boolean)} but default to true.
	 */
	public void unsetSupplier() {
		this.unsetSupplier(true);
	}

	/**
	 * Remove Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSupplier(boolean reverse) {
		if (reverse && this.supplier != null) {
			this.supplier.removePurchaseOrders(this, false);
		}
		this.supplier = null;
	}
	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removePurchaseOrders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addPurchaseOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removePurchaseOrders(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
