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
public class ReturnSupplierStockDetailEntity extends AbstractEntity {

	public ReturnSupplierStockDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ReturnSupplierOneMany = new EntityReference();
			ReturnSupplierOneMany.entityName = "ReturnSupplier";
			ReturnSupplierOneMany.oppositeName = "ReturnSupplier";
			ReturnSupplierOneMany.name = "ReturnSupplierStockDetails";
			ReturnSupplierOneMany.optional = true;
			ReturnSupplierOneMany.type = "One";
			ReturnSupplierOneMany.oppositeType = "Many";

		References.add(ReturnSupplierOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "ReturnSupplierStockDetails";
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

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Available Quantity Returned here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Quantity Returned here] end
	private Double availableQuantityReturned;

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

	// % protected region % [Modify attribute annotation for Available Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Quantity here] end
	private Double availableQuantity;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Previous Quantity Returned here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Previous Quantity Returned here] end
	private Double previousQuantityReturned;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

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

	private ReturnSupplierEntity returnSupplier;

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
	 * Similar to {@link this#setReturnSupplier(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSupplier(@NonNull ReturnSupplierEntity entity) {
		setReturnSupplier(entity, true);
	}

	/**
	 * Set or update the returnSupplier in this entity with single ReturnSupplierEntity.
	 *
	 * @param entity the given ReturnSupplierEntity to be set or updated to returnSupplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReturnSupplier(@NonNull ReturnSupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setReturnSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setReturnSupplier here] end

		if (sameAsFormer(this.returnSupplier, entity)) {
			return;
		}

		if (this.returnSupplier != null) {
			this.returnSupplier.removeReturnSupplierStockDetails(this, false);
		}
		this.returnSupplier = entity;
		if (reverseAdd) {
			this.returnSupplier.addReturnSupplierStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setReturnSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setReturnSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetReturnSupplier(boolean)} but default to true.
	 */
	public void unsetReturnSupplier() {
		this.unsetReturnSupplier(true);
	}

	/**
	 * Remove Return Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetReturnSupplier(boolean reverse) {
		if (reverse && this.returnSupplier != null) {
			this.returnSupplier.removeReturnSupplierStockDetails(this, false);
		}
		this.returnSupplier = null;
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
			this.stockCatalogue.removeReturnSupplierStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addReturnSupplierStockDetails(this, false);
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
			this.stockCatalogue.removeReturnSupplierStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
