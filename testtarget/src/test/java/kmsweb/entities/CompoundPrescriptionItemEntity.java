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
public class CompoundPrescriptionItemEntity extends AbstractEntity {

	public CompoundPrescriptionItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CompoundPrescriptionDetailOneMany = new EntityReference();
			CompoundPrescriptionDetailOneMany.entityName = "CompoundPrescriptionDetail";
			CompoundPrescriptionDetailOneMany.oppositeName = "CompoundPrescriptionDetail";
			CompoundPrescriptionDetailOneMany.name = "CompoundPrescriptionItems";
			CompoundPrescriptionDetailOneMany.optional = true;
			CompoundPrescriptionDetailOneMany.type = "One";
			CompoundPrescriptionDetailOneMany.oppositeType = "Many";

		References.add(CompoundPrescriptionDetailOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "CompoundPrescriptionItems";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);

		var UnitOneMany = new EntityReference();
			UnitOneMany.entityName = "UnitOfMeasurement";
			UnitOneMany.oppositeName = "Unit";
			UnitOneMany.name = "CompoundPrescriptionItems";
			UnitOneMany.optional = true;
			UnitOneMany.type = "One";
			UnitOneMany.oppositeType = "Many";

		References.add(UnitOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dose here] end
	private Integer dose;

	// % protected region % [Modify attribute annotation for Requested Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Requested Quantity here] end
	private Double requestedQuantity;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	private CompoundPrescriptionDetailEntity compoundPrescriptionDetail;

	private StockCatalogueEntity stockCatalogue;

	private UnitOfMeasurementEntity unit;

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
	 * Similar to {@link this#setCompoundPrescriptionDetail(CompoundPrescriptionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be set to this entity
	 */
	public void setCompoundPrescriptionDetail(@NonNull CompoundPrescriptionDetailEntity entity) {
		setCompoundPrescriptionDetail(entity, true);
	}

	/**
	 * Set or update the compoundPrescriptionDetail in this entity with single CompoundPrescriptionDetailEntity.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be set or updated to compoundPrescriptionDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCompoundPrescriptionDetail(@NonNull CompoundPrescriptionDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCompoundPrescriptionDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCompoundPrescriptionDetail here] end

		if (sameAsFormer(this.compoundPrescriptionDetail, entity)) {
			return;
		}

		if (this.compoundPrescriptionDetail != null) {
			this.compoundPrescriptionDetail.removeCompoundPrescriptionItems(this, false);
		}
		this.compoundPrescriptionDetail = entity;
		if (reverseAdd) {
			this.compoundPrescriptionDetail.addCompoundPrescriptionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCompoundPrescriptionDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCompoundPrescriptionDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionDetail(boolean)} but default to true.
	 */
	public void unsetCompoundPrescriptionDetail() {
		this.unsetCompoundPrescriptionDetail(true);
	}

	/**
	 * Remove Compound Prescription Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCompoundPrescriptionDetail(boolean reverse) {
		if (reverse && this.compoundPrescriptionDetail != null) {
			this.compoundPrescriptionDetail.removeCompoundPrescriptionItems(this, false);
		}
		this.compoundPrescriptionDetail = null;
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
			this.stockCatalogue.removeCompoundPrescriptionItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addCompoundPrescriptionItems(this, false);
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
			this.stockCatalogue.removeCompoundPrescriptionItems(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setUnit(UnitOfMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set to this entity
	 */
	public void setUnit(@NonNull UnitOfMeasurementEntity entity) {
		setUnit(entity, true);
	}

	/**
	 * Set or update the unit in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to unit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnit(@NonNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setUnit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setUnit here] end

		if (sameAsFormer(this.unit, entity)) {
			return;
		}

		if (this.unit != null) {
			this.unit.removeCompoundPrescriptionItems(this, false);
		}
		this.unit = entity;
		if (reverseAdd) {
			this.unit.addCompoundPrescriptionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setUnit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setUnit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetUnit(boolean)} but default to true.
	 */
	public void unsetUnit() {
		this.unsetUnit(true);
	}

	/**
	 * Remove Unit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetUnit(boolean reverse) {
		if (reverse && this.unit != null) {
			this.unit.removeCompoundPrescriptionItems(this, false);
		}
		this.unit = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
