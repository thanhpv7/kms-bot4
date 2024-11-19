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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class GoodsReceiveNoteBatchEntity extends AbstractEntity {

	public GoodsReceiveNoteBatchEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var GoodsReceiveNoteItemOneMany = new EntityReference();
			GoodsReceiveNoteItemOneMany.entityName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteItemOneMany.oppositeName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteItemOneMany.name = "GoodsReceiveNoteBatchs";
			GoodsReceiveNoteItemOneMany.optional = true;
			GoodsReceiveNoteItemOneMany.type = "One";
			GoodsReceiveNoteItemOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteItemOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "GoodsReceiveNoteBatchs";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "GoodsReceiveNoteBatchs";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);
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

	// % protected region % [Modify attribute annotation for Transaction Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Number here] end
	private String transactionNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Batch Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Number here] end
	private String batchNumber;

	// % protected region % [Modify attribute annotation for Expiration Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expiration Date here] end
	private OffsetDateTime expirationDate;

	// % protected region % [Modify attribute annotation for Batch Qty UOM Transaction here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Qty UOM Transaction here] end
	private Double batchQtyUOMTransaction;

	// % protected region % [Modify attribute annotation for UOM Transaction here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOM Transaction here] end
	private String uomTransaction;

	// % protected region % [Modify attribute annotation for Batch Qty UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Qty UOI here] end
	private Double batchQtyUOI;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Batch Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Item Notes here] end
	private String batchItemNotes;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private GoodsReceiveNoteItemEntity goodsReceiveNoteItem;

	private StockCatalogueEntity stockCatalogue;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItem(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItem(@NonNull GoodsReceiveNoteItemEntity entity) {
		setGoodsReceiveNoteItem(entity, true);
	}

	/**
	 * Set or update the goodsReceiveNoteItem in this entity with single GoodsReceiveNoteItemEntity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set or updated to goodsReceiveNoteItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setGoodsReceiveNoteItem(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNoteItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNoteItem here] end

		if (sameAsFormer(this.goodsReceiveNoteItem, entity)) {
			return;
		}

		if (this.goodsReceiveNoteItem != null) {
			this.goodsReceiveNoteItem.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.goodsReceiveNoteItem = entity;
		if (reverseAdd) {
			this.goodsReceiveNoteItem.addGoodsReceiveNoteBatchs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNoteItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNoteItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItem(boolean)} but default to true.
	 */
	public void unsetGoodsReceiveNoteItem() {
		this.unsetGoodsReceiveNoteItem(true);
	}

	/**
	 * Remove Goods Receive Note Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetGoodsReceiveNoteItem(boolean reverse) {
		if (reverse && this.goodsReceiveNoteItem != null) {
			this.goodsReceiveNoteItem.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.goodsReceiveNoteItem = null;
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
			this.stockCatalogue.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addGoodsReceiveNoteBatchs(this, false);
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
			this.stockCatalogue.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.stockCatalogue = null;
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
			this.warehouse.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addGoodsReceiveNoteBatchs(this, false);
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
			this.warehouse.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
