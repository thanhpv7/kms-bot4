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
public class PrescriptionItemEntity extends AbstractEntity {

	public PrescriptionItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CompoundOneMany = new EntityReference();
			CompoundOneMany.entityName = "PrescriptionCompound";
			CompoundOneMany.oppositeName = "Compound";
			CompoundOneMany.name = "CompoundItems";
			CompoundOneMany.optional = true;
			CompoundOneMany.type = "One";
			CompoundOneMany.oppositeType = "Many";

		References.add(CompoundOneMany);

		var StockCatalogueIdOneMany = new EntityReference();
			StockCatalogueIdOneMany.entityName = "StockCatalogue";
			StockCatalogueIdOneMany.oppositeName = "StockCatalogueId";
			StockCatalogueIdOneMany.name = "PrescriptionItem";
			StockCatalogueIdOneMany.optional = true;
			StockCatalogueIdOneMany.type = "One";
			StockCatalogueIdOneMany.oppositeType = "Many";

		References.add(StockCatalogueIdOneMany);

		var PrescriptionOneMany = new EntityReference();
			PrescriptionOneMany.entityName = "PrescriptionHeader";
			PrescriptionOneMany.oppositeName = "Prescription";
			PrescriptionOneMany.name = "PrescriptionItems";
			PrescriptionOneMany.optional = true;
			PrescriptionOneMany.type = "One";
			PrescriptionOneMany.oppositeType = "Many";

		References.add(PrescriptionOneMany);

		var UnitOneMany = new EntityReference();
			UnitOneMany.entityName = "UnitOfMeasurement";
			UnitOneMany.oppositeName = "Unit";
			UnitOneMany.name = "PrescriptionItems";
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

	// % protected region % [Modify attribute annotation for Iteration Start here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Iteration Start here] end
	private Integer iterationStart;

	// % protected region % [Modify attribute annotation for Iteration End here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Iteration End here] end
	private Integer iterationEnd;

	// % protected region % [Modify attribute annotation for Requested Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Requested Quantity here] end
	private Double requestedQuantity;

	// % protected region % [Modify attribute annotation for Allocated Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Allocated Quantity here] end
	private Double allocatedQuantity;

	// % protected region % [Modify attribute annotation for Issued Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Issued Quantity here] end
	private Double issuedQuantity;

	// % protected region % [Modify attribute annotation for Frequency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Frequency here] end
	private String frequency;

	// % protected region % [Modify attribute annotation for Consumption Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consumption Method here] end
	private String consumptionMethod;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for Dosage Times here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dosage Times here] end
	private Integer dosageTimes;

	// % protected region % [Modify attribute annotation for Dosage Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dosage Days here] end
	private Double dosageDays;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dose here] end
	private Integer dose;

	// % protected region % [Modify attribute annotation for External Stock Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Stock Name here] end
	private String externalStockName;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	// % protected region % [Modify attribute annotation for DTD Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DTD Quantity here] end
	private Double dtdQuantity;

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

	private PrescriptionCompoundEntity compound;

	private StockCatalogueEntity stockCatalogueId;

	private PrescriptionHeaderEntity prescription;

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
	 * Similar to {@link this#setCompound(PrescriptionCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be set to this entity
	 */
	public void setCompound(@NonNull PrescriptionCompoundEntity entity) {
		setCompound(entity, true);
	}

	/**
	 * Set or update the compound in this entity with single PrescriptionCompoundEntity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be set or updated to compound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCompound(@NonNull PrescriptionCompoundEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCompound here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCompound here] end

		if (sameAsFormer(this.compound, entity)) {
			return;
		}

		if (this.compound != null) {
			this.compound.removeCompoundItems(this, false);
		}
		this.compound = entity;
		if (reverseAdd) {
			this.compound.addCompoundItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCompound incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCompound incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCompound(boolean)} but default to true.
	 */
	public void unsetCompound() {
		this.unsetCompound(true);
	}

	/**
	 * Remove Compound in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCompound(boolean reverse) {
		if (reverse && this.compound != null) {
			this.compound.removeCompoundItems(this, false);
		}
		this.compound = null;
	}
	/**
	 * Similar to {@link this#setStockCatalogueId(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogueId(@NonNull StockCatalogueEntity entity) {
		setStockCatalogueId(entity, true);
	}

	/**
	 * Set or update the stockCatalogueId in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogueId
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueId(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueId here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueId here] end

		if (sameAsFormer(this.stockCatalogueId, entity)) {
			return;
		}

		if (this.stockCatalogueId != null) {
			this.stockCatalogueId.removePrescriptionItem(this, false);
		}
		this.stockCatalogueId = entity;
		if (reverseAdd) {
			this.stockCatalogueId.addPrescriptionItem(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueId incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueId incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogueId(boolean)} but default to true.
	 */
	public void unsetStockCatalogueId() {
		this.unsetStockCatalogueId(true);
	}

	/**
	 * Remove Stock Catalogue Id in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogueId(boolean reverse) {
		if (reverse && this.stockCatalogueId != null) {
			this.stockCatalogueId.removePrescriptionItem(this, false);
		}
		this.stockCatalogueId = null;
	}
	/**
	 * Similar to {@link this#setPrescription(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescription(@NonNull PrescriptionHeaderEntity entity) {
		setPrescription(entity, true);
	}

	/**
	 * Set or update the prescription in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescription
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescription(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] end

		if (sameAsFormer(this.prescription, entity)) {
			return;
		}

		if (this.prescription != null) {
			this.prescription.removePrescriptionItems(this, false);
		}
		this.prescription = entity;
		if (reverseAdd) {
			this.prescription.addPrescriptionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrescription(boolean)} but default to true.
	 */
	public void unsetPrescription() {
		this.unsetPrescription(true);
	}

	/**
	 * Remove Prescription in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescription(boolean reverse) {
		if (reverse && this.prescription != null) {
			this.prescription.removePrescriptionItems(this, false);
		}
		this.prescription = null;
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
			this.unit.removePrescriptionItems(this, false);
		}
		this.unit = entity;
		if (reverseAdd) {
			this.unit.addPrescriptionItems(this, false);
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
			this.unit.removePrescriptionItems(this, false);
		}
		this.unit = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
