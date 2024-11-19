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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class GoodsReceiveNoteEntity extends AbstractEntity {

	public GoodsReceiveNoteEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var GoodsReceiveNoteItemsOneMany = new EntityReference();
			GoodsReceiveNoteItemsOneMany.entityName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteItemsOneMany.oppositeName = "GoodsReceiveNote";
			GoodsReceiveNoteItemsOneMany.name = "GoodsReceiveNoteItems";
			GoodsReceiveNoteItemsOneMany.optional = true;
			GoodsReceiveNoteItemsOneMany.type = "One";
			GoodsReceiveNoteItemsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteItemsOneMany);

		var SupplierOneMany = new EntityReference();
			SupplierOneMany.entityName = "Supplier";
			SupplierOneMany.oppositeName = "Supplier";
			SupplierOneMany.name = "GoodsReceiveNotes";
			SupplierOneMany.optional = true;
			SupplierOneMany.type = "One";
			SupplierOneMany.oppositeType = "Many";

		References.add(SupplierOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "GoodsReceiveNotes";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var PurchaseOrdersOneMany = new EntityReference();
			PurchaseOrdersOneMany.entityName = "PurchaseOrder";
			PurchaseOrdersOneMany.oppositeName = "GoodsReceiveNote";
			PurchaseOrdersOneMany.name = "PurchaseOrders";
			PurchaseOrdersOneMany.optional = true;
			PurchaseOrdersOneMany.type = "One";
			PurchaseOrdersOneMany.oppositeType = "Many";

		References.add(PurchaseOrdersOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Receive Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Receive Number here] end
	private String receiveNumber;

	// % protected region % [Modify attribute annotation for Source Document Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Document Type here] end
	private GrnSourceTypeEnum sourceDocumentType;

	// % protected region % [Modify attribute annotation for Source Document Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Document Number here] end
	private String sourceDocumentNumber;

	// % protected region % [Modify attribute annotation for Receive Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Receive Date here] end
	private OffsetDateTime receiveDate;

	// % protected region % [Modify attribute annotation for Void Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Void Date here] end
	private OffsetDateTime voidDate;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Supplier Invoice Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Invoice Number here] end
	private String supplierInvoiceNumber;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Shipping Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shipping Number here] end
	private String shippingNumber;

	// % protected region % [Modify attribute annotation for Shipping Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shipping Date here] end
	private OffsetDateTime shippingDate;

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

	private Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();

	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity) {
		addGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteItemEntity to goodsReceiveNoteItems in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteItems.contains(entity)) {
			goodsReceiveNoteItems.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNote(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		addGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteItemEntity to Goods Receive Note Items in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity) {
		this.removeGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteItemEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNote(false);
		}
		this.goodsReceiveNoteItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		this.removeGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteItemEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		setGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Items with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteItems();
		this.goodsReceiveNoteItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setGoodsReceiveNote(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteItems() {
		this.unsetGoodsReceiveNoteItems(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteItems(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetGoodsReceiveNote(false));
		}
		this.goodsReceiveNoteItems.clear();
	}

/**
	 * Similar to {@link this#addPurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		addPurchaseOrders(entity, true);
	}

	/**
	 * Add a new PurchaseOrderEntity to purchaseOrders in this entity.
	 *
	 * @param entity the given PurchaseOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrders.contains(entity)) {
			purchaseOrders.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNote(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		addPurchaseOrders(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderEntity to Purchase Orders in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		this.removePurchaseOrders(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNote(false);
		}
		this.purchaseOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		this.removePurchaseOrders(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		setPurchaseOrders(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Orders with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrders();
		this.purchaseOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.setGoodsReceiveNote(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrders() {
		this.unsetPurchaseOrders(true);
	}

	/**
	 * Remove all the entities in Purchase Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrders(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.unsetGoodsReceiveNote(false));
		}
		this.purchaseOrders.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.supplier.removeGoodsReceiveNotes(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addGoodsReceiveNotes(this, false);
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
			this.supplier.removeGoodsReceiveNotes(this, false);
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
			this.warehouse.removeGoodsReceiveNotes(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addGoodsReceiveNotes(this, false);
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
			this.warehouse.removeGoodsReceiveNotes(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
