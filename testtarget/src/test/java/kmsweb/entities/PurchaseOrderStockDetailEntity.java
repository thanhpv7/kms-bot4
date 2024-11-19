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

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PurchaseOrderStockDetailEntity extends AbstractEntity {

	public PurchaseOrderStockDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var GoodsReceiveNoteItemsOneMany = new EntityReference();
			GoodsReceiveNoteItemsOneMany.entityName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteItemsOneMany.oppositeName = "PurchaseOrderStockDetail";
			GoodsReceiveNoteItemsOneMany.name = "GoodsReceiveNoteItems";
			GoodsReceiveNoteItemsOneMany.optional = true;
			GoodsReceiveNoteItemsOneMany.type = "One";
			GoodsReceiveNoteItemsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteItemsOneMany);

		var PurchaseOrderOneMany = new EntityReference();
			PurchaseOrderOneMany.entityName = "PurchaseOrder";
			PurchaseOrderOneMany.oppositeName = "PurchaseOrder";
			PurchaseOrderOneMany.name = "PurchaseOrderStockDetails";
			PurchaseOrderOneMany.optional = true;
			PurchaseOrderOneMany.type = "One";
			PurchaseOrderOneMany.oppositeType = "Many";

		References.add(PurchaseOrderOneMany);

		var PurchaseRequisitionStockDetailOneMany = new EntityReference();
			PurchaseRequisitionStockDetailOneMany.entityName = "PurchaseRequisitionStockDetail";
			PurchaseRequisitionStockDetailOneMany.oppositeName = "PurchaseRequisitionStockDetail";
			PurchaseRequisitionStockDetailOneMany.name = "PurchaseOrderStockDetails";
			PurchaseRequisitionStockDetailOneMany.optional = true;
			PurchaseRequisitionStockDetailOneMany.type = "One";
			PurchaseRequisitionStockDetailOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionStockDetailOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "PurchaseOrderStockDetails";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Discount In Percent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount In Percent here] end
	private Boolean discountInPercent;

	// % protected region % [Modify attribute annotation for Discount Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount Value here] end
	private Double discountValue;

	// % protected region % [Modify attribute annotation for Taxable here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Taxable here] end
	private Boolean taxable;

	// % protected region % [Modify attribute annotation for Item Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Price here] end
	private Double itemPrice;

	// % protected region % [Modify attribute annotation for Item Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Status here] end
	private String itemStatus;

	// % protected region % [Modify attribute annotation for SOH here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SOH here] end
	private Double soh;

	// % protected region % [Modify attribute annotation for Max Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Max Level here] end
	private Double maxLevel;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Quantity Returned here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Returned here] end
	private Double quantityReturned;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Remaining Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Remaining Quantity here] end
	private Double remainingQuantity;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PurchaseOrderEntity purchaseOrder;

	private PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetail;

	private StockCatalogueEntity stockCatalogue;

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
				entity.setPurchaseOrderStockDetail(this, false);
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
			entity.unsetPurchaseOrderStockDetail(false);
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
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setPurchaseOrderStockDetail(this, false));
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
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetPurchaseOrderStockDetail(false));
		}
		this.goodsReceiveNoteItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPurchaseOrder(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrder(@NonNull PurchaseOrderEntity entity) {
		setPurchaseOrder(entity, true);
	}

	/**
	 * Set or update the purchaseOrder in this entity with single PurchaseOrderEntity.
	 *
	 * @param entity the given PurchaseOrderEntity to be set or updated to purchaseOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrder(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] end

		if (sameAsFormer(this.purchaseOrder, entity)) {
			return;
		}

		if (this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addPurchaseOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrder(boolean)} but default to true.
	 */
	public void unsetPurchaseOrder() {
		this.unsetPurchaseOrder(true);
	}

	/**
	 * Remove Purchase Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseOrder(boolean reverse) {
		if (reverse && this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseOrder = null;
	}
	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetail(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetail(@NonNull PurchaseRequisitionStockDetailEntity entity) {
		setPurchaseRequisitionStockDetail(entity, true);
	}

	/**
	 * Set or update the purchaseRequisitionStockDetail in this entity with single PurchaseRequisitionStockDetailEntity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set or updated to purchaseRequisitionStockDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseRequisitionStockDetail(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisitionStockDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisitionStockDetail here] end

		if (sameAsFormer(this.purchaseRequisitionStockDetail, entity)) {
			return;
		}

		if (this.purchaseRequisitionStockDetail != null) {
			this.purchaseRequisitionStockDetail.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseRequisitionStockDetail = entity;
		if (reverseAdd) {
			this.purchaseRequisitionStockDetail.addPurchaseOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisitionStockDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisitionStockDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetail(boolean)} but default to true.
	 */
	public void unsetPurchaseRequisitionStockDetail() {
		this.unsetPurchaseRequisitionStockDetail(true);
	}

	/**
	 * Remove Purchase Requisition Stock Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseRequisitionStockDetail(boolean reverse) {
		if (reverse && this.purchaseRequisitionStockDetail != null) {
			this.purchaseRequisitionStockDetail.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseRequisitionStockDetail = null;
	}
	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.removePurchaseOrderStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addPurchaseOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove Stock Catalogue in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.removePurchaseOrderStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
