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
public class RetailPharmacyStockDetailEntity extends AbstractEntity {

	public RetailPharmacyStockDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var RetailPharmacyOneMany = new EntityReference();
			RetailPharmacyOneMany.entityName = "RetailPharmacy";
			RetailPharmacyOneMany.oppositeName = "RetailPharmacy";
			RetailPharmacyOneMany.name = "RetailPharmacyStockDetails";
			RetailPharmacyOneMany.optional = true;
			RetailPharmacyOneMany.type = "One";
			RetailPharmacyOneMany.oppositeType = "Many";

		References.add(RetailPharmacyOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "RetailPharmacyStockDetails";
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

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Available Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Quantity here] end
	private Double availableQuantity;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discount here] end
	private Double discount;

	// % protected region % [Modify attribute annotation for Tax Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Included here] end
	private Boolean taxIncluded;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

	// % protected region % [Modify attribute annotation for Total Item Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Item Price here] end
	private Double totalItemPrice;

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

	private RetailPharmacyEntity retailPharmacy;

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
	 * Similar to {@link this#setRetailPharmacy(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacy(@NonNull RetailPharmacyEntity entity) {
		setRetailPharmacy(entity, true);
	}

	/**
	 * Set or update the retailPharmacy in this entity with single RetailPharmacyEntity.
	 *
	 * @param entity the given RetailPharmacyEntity to be set or updated to retailPharmacy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacy(@NonNull RetailPharmacyEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] end

		if (sameAsFormer(this.retailPharmacy, entity)) {
			return;
		}

		if (this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyStockDetails(this, false);
		}
		this.retailPharmacy = entity;
		if (reverseAdd) {
			this.retailPharmacy.addRetailPharmacyStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacy(boolean)} but default to true.
	 */
	public void unsetRetailPharmacy() {
		this.unsetRetailPharmacy(true);
	}

	/**
	 * Remove Retail Pharmacy in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacy(boolean reverse) {
		if (reverse && this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyStockDetails(this, false);
		}
		this.retailPharmacy = null;
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
			this.stockCatalogue.removeRetailPharmacyStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addRetailPharmacyStockDetails(this, false);
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
			this.stockCatalogue.removeRetailPharmacyStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
