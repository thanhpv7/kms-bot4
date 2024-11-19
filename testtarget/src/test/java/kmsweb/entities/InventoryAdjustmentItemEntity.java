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
public class InventoryAdjustmentItemEntity extends AbstractEntity {

	public InventoryAdjustmentItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InventoryAdjusmentBatchsOneMany = new EntityReference();
			InventoryAdjusmentBatchsOneMany.entityName = "InventoryAdjusmentBatch";
			InventoryAdjusmentBatchsOneMany.oppositeName = "InventoryAdjustmentItem";
			InventoryAdjusmentBatchsOneMany.name = "InventoryAdjusmentBatchs";
			InventoryAdjusmentBatchsOneMany.optional = true;
			InventoryAdjusmentBatchsOneMany.type = "One";
			InventoryAdjusmentBatchsOneMany.oppositeType = "Many";

		References.add(InventoryAdjusmentBatchsOneMany);

		var InventoryAdjustmentOneMany = new EntityReference();
			InventoryAdjustmentOneMany.entityName = "InventoryAdjustment";
			InventoryAdjustmentOneMany.oppositeName = "InventoryAdjustment";
			InventoryAdjustmentOneMany.name = "InventoryAdjustmentItems";
			InventoryAdjustmentOneMany.optional = true;
			InventoryAdjustmentOneMany.type = "One";
			InventoryAdjustmentOneMany.oppositeType = "Many";

		References.add(InventoryAdjustmentOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "InventoryAdjustmentItems";
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

	// % protected region % [Modify attribute annotation for Original SOH here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Original SOH here] end
	private Double originalSOH;

	// % protected region % [Modify attribute annotation for Original Inventory Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Original Inventory Value here] end
	private Double originalInventoryValue;

	// % protected region % [Modify attribute annotation for Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty here] end
	private Double qty;

	// % protected region % [Modify attribute annotation for Uom here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Uom here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Adjusted Soh here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Adjusted Soh here] end
	private Double adjustedSoh;

	// % protected region % [Modify attribute annotation for Adjusted Inventory Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Adjusted Inventory Value here] end
	private Double adjustedInventoryValue;

	// % protected region % [Modify attribute annotation for Minimal Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Minimal Level here] end
	private Double minimalLevel;

	// % protected region % [Modify attribute annotation for Maximal Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Maximal Level here] end
	private Double maximalLevel;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Uoi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Uoi here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty Uoi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty Uoi here] end
	private Double qtyUoi;

	// % protected region % [Modify attribute annotation for Price Uoi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price Uoi here] end
	private Double priceUoi;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

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

	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InventoryAdjustmentEntity inventoryAdjustment;

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
	 * Similar to {@link this#addInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		addInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Add a new InventoryAdjusmentBatchEntity to inventoryAdjusmentBatchs in this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjusmentBatchs.contains(entity)) {
			inventoryAdjusmentBatchs.add(entity);
			if (reverseAdd) {
				entity.setInventoryAdjustmentItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		addInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjusmentBatchEntity to Inventory Adjusment Batchs in this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		this.removeInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Remove the given InventoryAdjusmentBatchEntity from this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryAdjustmentItem(false);
		}
		this.inventoryAdjusmentBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		this.removeInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjusmentBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		setInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjusment Batchs with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjusmentBatchs();
		this.inventoryAdjusmentBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.setInventoryAdjustmentItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjusmentBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjusmentBatchs() {
		this.unsetInventoryAdjusmentBatchs(true);
	}

	/**
	 * Remove all the entities in Inventory Adjusment Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjusmentBatchs(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.unsetInventoryAdjustmentItem(false));
		}
		this.inventoryAdjusmentBatchs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInventoryAdjustment(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set to this entity
	 */
	public void setInventoryAdjustment(@NonNull InventoryAdjustmentEntity entity) {
		setInventoryAdjustment(entity, true);
	}

	/**
	 * Set or update the inventoryAdjustment in this entity with single InventoryAdjustmentEntity.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set or updated to inventoryAdjustment
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInventoryAdjustment(@NonNull InventoryAdjustmentEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustment here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustment here] end

		if (sameAsFormer(this.inventoryAdjustment, entity)) {
			return;
		}

		if (this.inventoryAdjustment != null) {
			this.inventoryAdjustment.removeInventoryAdjustmentItems(this, false);
		}
		this.inventoryAdjustment = entity;
		if (reverseAdd) {
			this.inventoryAdjustment.addInventoryAdjustmentItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustment incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustment incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustment(boolean)} but default to true.
	 */
	public void unsetInventoryAdjustment() {
		this.unsetInventoryAdjustment(true);
	}

	/**
	 * Remove Inventory Adjustment in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInventoryAdjustment(boolean reverse) {
		if (reverse && this.inventoryAdjustment != null) {
			this.inventoryAdjustment.removeInventoryAdjustmentItems(this, false);
		}
		this.inventoryAdjustment = null;
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
			this.stockCatalogue.removeInventoryAdjustmentItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInventoryAdjustmentItems(this, false);
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
			this.stockCatalogue.removeInventoryAdjustmentItems(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
