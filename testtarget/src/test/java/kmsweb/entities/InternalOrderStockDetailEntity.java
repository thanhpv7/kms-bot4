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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InternalOrderStockDetailEntity extends AbstractEntity {

	public InternalOrderStockDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InternalOrderOneMany = new EntityReference();
			InternalOrderOneMany.entityName = "InternalOrder";
			InternalOrderOneMany.oppositeName = "InternalOrder";
			InternalOrderOneMany.name = "InternalOrderStockDetails";
			InternalOrderOneMany.optional = true;
			InternalOrderOneMany.type = "One";
			InternalOrderOneMany.oppositeType = "Many";

		References.add(InternalOrderOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "InternalOrderStockDetails";
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

	// % protected region % [Modify attribute annotation for Item Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Number here] end
	private Integer itemNumber;

	// % protected region % [Modify attribute annotation for Source Available Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Available Quantity here] end
	private Double sourceAvailableQuantity;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for uom here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for uom here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Quantity Issued here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Issued here] end
	private Double quantityIssued;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Source Min Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Min Level here] end
	private Double sourceMinLevel;

	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] end
	private Double quantityFulfilled;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InternalOrderEntity internalOrder;

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
	 * Similar to {@link this#setInternalOrder(InternalOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderEntity to be set to this entity
	 */
	public void setInternalOrder(@NonNull InternalOrderEntity entity) {
		setInternalOrder(entity, true);
	}

	/**
	 * Set or update the internalOrder in this entity with single InternalOrderEntity.
	 *
	 * @param entity the given InternalOrderEntity to be set or updated to internalOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInternalOrder(@NonNull InternalOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInternalOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInternalOrder here] end

		if (sameAsFormer(this.internalOrder, entity)) {
			return;
		}

		if (this.internalOrder != null) {
			this.internalOrder.removeInternalOrderStockDetails(this, false);
		}
		this.internalOrder = entity;
		if (reverseAdd) {
			this.internalOrder.addInternalOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInternalOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInternalOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInternalOrder(boolean)} but default to true.
	 */
	public void unsetInternalOrder() {
		this.unsetInternalOrder(true);
	}

	/**
	 * Remove Internal Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInternalOrder(boolean reverse) {
		if (reverse && this.internalOrder != null) {
			this.internalOrder.removeInternalOrderStockDetails(this, false);
		}
		this.internalOrder = null;
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
			this.stockCatalogue.removeInternalOrderStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInternalOrderStockDetails(this, false);
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
			this.stockCatalogue.removeInternalOrderStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
