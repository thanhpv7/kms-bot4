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
public class GoodsReceiveNoteItemEntity extends AbstractEntity {

	public GoodsReceiveNoteItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var GoodsReceiveNoteBatchsOneMany = new EntityReference();
			GoodsReceiveNoteBatchsOneMany.entityName = "GoodsReceiveNoteBatch";
			GoodsReceiveNoteBatchsOneMany.oppositeName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteBatchsOneMany.name = "GoodsReceiveNoteBatchs";
			GoodsReceiveNoteBatchsOneMany.optional = true;
			GoodsReceiveNoteBatchsOneMany.type = "One";
			GoodsReceiveNoteBatchsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteBatchsOneMany);

		var GoodsReceiveNoteOneMany = new EntityReference();
			GoodsReceiveNoteOneMany.entityName = "GoodsReceiveNote";
			GoodsReceiveNoteOneMany.oppositeName = "GoodsReceiveNote";
			GoodsReceiveNoteOneMany.name = "GoodsReceiveNoteItems";
			GoodsReceiveNoteOneMany.optional = true;
			GoodsReceiveNoteOneMany.type = "One";
			GoodsReceiveNoteOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteOneMany);

		var PurchaseOrderStockDetailOneMany = new EntityReference();
			PurchaseOrderStockDetailOneMany.entityName = "PurchaseOrderStockDetail";
			PurchaseOrderStockDetailOneMany.oppositeName = "PurchaseOrderStockDetail";
			PurchaseOrderStockDetailOneMany.name = "GoodsReceiveNoteItems";
			PurchaseOrderStockDetailOneMany.optional = true;
			PurchaseOrderStockDetailOneMany.type = "One";
			PurchaseOrderStockDetailOneMany.oppositeType = "Many";

		References.add(PurchaseOrderStockDetailOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "GoodsReceiveNoteItems";
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

	// % protected region % [Modify attribute annotation for Item Line Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Line Number here] end
	private Integer itemLineNumber;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Qty Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty Received here] end
	private Double qtyReceived;

	// % protected region % [Modify attribute annotation for Qty Ordered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty Ordered here] end
	private Double qtyOrdered;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Total Item Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Item Price here] end
	private Double totalItemPrice;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Prev Qty Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Prev Qty Received here] end
	private Double prevQtyReceived;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty Received UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty Received UOI here] end
	private Double qtyReceivedUOI;

	// % protected region % [Modify attribute annotation for Price UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price UOI here] end
	private Double priceUOI;

	// % protected region % [Modify attribute annotation for On Hand Qty UOP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for On Hand Qty UOP here] end
	private Double onHandQtyUOP;

	// % protected region % [Modify attribute annotation for Max Level UOP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Max Level UOP here] end
	private Double maxLevelUOP;

	// % protected region % [Modify attribute annotation for Discount Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount Value here] end
	private Double discountValue;

	// % protected region % [Modify attribute annotation for Tax Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Value here] end
	private Double taxValue;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	// % protected region % [Modify attribute annotation for Discount In Percent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount In Percent here] end
	private Boolean discountInPercent;

	// % protected region % [Modify attribute annotation for Tax In Percent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax In Percent here] end
	private Boolean taxInPercent;

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

	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private GoodsReceiveNoteEntity goodsReceiveNote;

	private PurchaseOrderStockDetailEntity purchaseOrderStockDetail;

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
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		addGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteBatchEntity to goodsReceiveNoteBatchs in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteBatchs.contains(entity)) {
			goodsReceiveNoteBatchs.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNoteItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		addGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteBatchEntity to Goods Receive Note Batchs in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		this.removeGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteBatchEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNoteItem(false);
		}
		this.goodsReceiveNoteBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		this.removeGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		setGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Batchs with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteBatchs();
		this.goodsReceiveNoteBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.setGoodsReceiveNoteItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteBatchs() {
		this.unsetGoodsReceiveNoteBatchs(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteBatchs(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.unsetGoodsReceiveNoteItem(false));
		}
		this.goodsReceiveNoteBatchs.clear();
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
			this.goodsReceiveNote.removeGoodsReceiveNoteItems(this, false);
		}
		this.goodsReceiveNote = entity;
		if (reverseAdd) {
			this.goodsReceiveNote.addGoodsReceiveNoteItems(this, false);
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
			this.goodsReceiveNote.removeGoodsReceiveNoteItems(this, false);
		}
		this.goodsReceiveNote = null;
	}
	/**
	 * Similar to {@link this#setPurchaseOrderStockDetail(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetail(@NonNull PurchaseOrderStockDetailEntity entity) {
		setPurchaseOrderStockDetail(entity, true);
	}

	/**
	 * Set or update the purchaseOrderStockDetail in this entity with single PurchaseOrderStockDetailEntity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set or updated to purchaseOrderStockDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrderStockDetail(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrderStockDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrderStockDetail here] end

		if (sameAsFormer(this.purchaseOrderStockDetail, entity)) {
			return;
		}

		if (this.purchaseOrderStockDetail != null) {
			this.purchaseOrderStockDetail.removeGoodsReceiveNoteItems(this, false);
		}
		this.purchaseOrderStockDetail = entity;
		if (reverseAdd) {
			this.purchaseOrderStockDetail.addGoodsReceiveNoteItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrderStockDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrderStockDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetail(boolean)} but default to true.
	 */
	public void unsetPurchaseOrderStockDetail() {
		this.unsetPurchaseOrderStockDetail(true);
	}

	/**
	 * Remove Purchase Order Stock Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseOrderStockDetail(boolean reverse) {
		if (reverse && this.purchaseOrderStockDetail != null) {
			this.purchaseOrderStockDetail.removeGoodsReceiveNoteItems(this, false);
		}
		this.purchaseOrderStockDetail = null;
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
			this.stockCatalogue.removeGoodsReceiveNoteItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addGoodsReceiveNoteItems(this, false);
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
			this.stockCatalogue.removeGoodsReceiveNoteItems(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
