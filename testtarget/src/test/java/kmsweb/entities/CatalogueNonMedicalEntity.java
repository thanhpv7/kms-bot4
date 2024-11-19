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
public class CatalogueNonMedicalEntity extends AbstractEntity {

	public CatalogueNonMedicalEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var StockCatalogueOneOne = new EntityReference();
			StockCatalogueOneOne.entityName = "StockCatalogue";
			StockCatalogueOneOne.oppositeName = "StockCatalogue";
			StockCatalogueOneOne.name = "StockCatalogueNonMedical";
			StockCatalogueOneOne.optional = true;
			StockCatalogueOneOne.type = "One";
			StockCatalogueOneOne.oppositeType = "One";

		References.add(StockCatalogueOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Manufacturer here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Manufacturer here] end
	private String manufacturer;

	// % protected region % [Modify attribute annotation for Manufacturer Item Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Manufacturer Item Number here] end
	private String manufacturerItemNumber;

	// % protected region % [Modify attribute annotation for Is Expensive Item here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Expensive Item here] end
	private Boolean isExpensiveItem;

	// % protected region % [Modify attribute annotation for Is Consignment Item here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Consignment Item here] end
	private Boolean isConsignmentItem;

	// % protected region % [Modify attribute annotation for Model here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Model here] end
	private String model;

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

	private StockCatalogueEntity stockCatalogue;

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
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.unsetStockCatalogueNonMedical(false);
		}

		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.setStockCatalogueNonMedical(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove the StockCatalogueEntity of stockCatalogue from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.unsetStockCatalogueNonMedical();
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
