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
public class InventoryBatchCorrectionItemEntity extends AbstractEntity {

	public InventoryBatchCorrectionItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InventoryBatchCorrectionOneMany = new EntityReference();
			InventoryBatchCorrectionOneMany.entityName = "InventoryBatchCorrection";
			InventoryBatchCorrectionOneMany.oppositeName = "InventoryBatchCorrection";
			InventoryBatchCorrectionOneMany.name = "InventoryBatchCorrectionItems";
			InventoryBatchCorrectionOneMany.optional = true;
			InventoryBatchCorrectionOneMany.type = "One";
			InventoryBatchCorrectionOneMany.oppositeType = "Many";

		References.add(InventoryBatchCorrectionOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "InventoryBatchCorrectionItems";
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

	// % protected region % [Modify attribute annotation for UOM here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOM here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Available Qty Batch here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Qty Batch here] end
	private Double availableQtyBatch;

	// % protected region % [Modify attribute annotation for Actual Qty Batch here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Actual Qty Batch here] end
	private Double actualQtyBatch;

	// % protected region % [Modify attribute annotation for Qty Adjusted here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty Adjusted here] end
	private Double qtyAdjusted;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty UOI here] end
	private Double qtyUOI;

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

	private InventoryBatchCorrectionEntity inventoryBatchCorrection;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInventoryBatchCorrection(InventoryBatchCorrectionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be set to this entity
	 */
	public void setInventoryBatchCorrection(@NonNull InventoryBatchCorrectionEntity entity) {
		setInventoryBatchCorrection(entity, true);
	}

	/**
	 * Set or update the inventoryBatchCorrection in this entity with single InventoryBatchCorrectionEntity.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be set or updated to inventoryBatchCorrection
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInventoryBatchCorrection(@NonNull InventoryBatchCorrectionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInventoryBatchCorrection here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInventoryBatchCorrection here] end

		if (sameAsFormer(this.inventoryBatchCorrection, entity)) {
			return;
		}

		if (this.inventoryBatchCorrection != null) {
			this.inventoryBatchCorrection.removeInventoryBatchCorrectionItems(this, false);
		}
		this.inventoryBatchCorrection = entity;
		if (reverseAdd) {
			this.inventoryBatchCorrection.addInventoryBatchCorrectionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInventoryBatchCorrection incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInventoryBatchCorrection incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrection(boolean)} but default to true.
	 */
	public void unsetInventoryBatchCorrection() {
		this.unsetInventoryBatchCorrection(true);
	}

	/**
	 * Remove Inventory Batch Correction in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInventoryBatchCorrection(boolean reverse) {
		if (reverse && this.inventoryBatchCorrection != null) {
			this.inventoryBatchCorrection.removeInventoryBatchCorrectionItems(this, false);
		}
		this.inventoryBatchCorrection = null;
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
			this.stockCatalogue.removeInventoryBatchCorrectionItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInventoryBatchCorrectionItems(this, false);
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
			this.stockCatalogue.removeInventoryBatchCorrectionItems(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}