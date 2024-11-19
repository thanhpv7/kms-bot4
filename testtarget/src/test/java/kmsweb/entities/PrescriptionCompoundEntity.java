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
public class PrescriptionCompoundEntity extends AbstractEntity {

	public PrescriptionCompoundEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CompoundItemsOneMany = new EntityReference();
			CompoundItemsOneMany.entityName = "PrescriptionItem";
			CompoundItemsOneMany.oppositeName = "Compound";
			CompoundItemsOneMany.name = "CompoundItems";
			CompoundItemsOneMany.optional = true;
			CompoundItemsOneMany.type = "One";
			CompoundItemsOneMany.oppositeType = "Many";

		References.add(CompoundItemsOneMany);

		var UnitOneMany = new EntityReference();
			UnitOneMany.entityName = "UnitOfMeasurement";
			UnitOneMany.oppositeName = "Unit";
			UnitOneMany.name = "CompoundsUnit";
			UnitOneMany.optional = true;
			UnitOneMany.type = "One";
			UnitOneMany.oppositeType = "Many";

		References.add(UnitOneMany);

		var PrescriptionHeaderOneMany = new EntityReference();
			PrescriptionHeaderOneMany.entityName = "PrescriptionHeader";
			PrescriptionHeaderOneMany.oppositeName = "PrescriptionHeader";
			PrescriptionHeaderOneMany.name = "PrescriptionCompounds";
			PrescriptionHeaderOneMany.optional = true;
			PrescriptionHeaderOneMany.type = "One";
			PrescriptionHeaderOneMany.oppositeType = "Many";

		References.add(PrescriptionHeaderOneMany);
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

	// % protected region % [Modify attribute annotation for Compound Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Compound Code here] end
	private String compoundCode;

	// % protected region % [Modify attribute annotation for Compound Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Compound Name here] end
	private String compoundName;

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

	// % protected region % [Modify attribute annotation for Frequency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Frequency here] end
	private String frequency;

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd;

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

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for External Compound Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Compound Name here] end
	private String externalCompoundName;

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

	private Set<PrescriptionItemEntity> compoundItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private UnitOfMeasurementEntity unit;

	private PrescriptionHeaderEntity prescriptionHeader;

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
	 * Similar to {@link this#addCompoundItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundItems(@NonNull PrescriptionItemEntity entity) {
		addCompoundItems(entity, true);
	}

	/**
	 * Add a new PrescriptionItemEntity to compoundItems in this entity.
	 *
	 * @param entity the given PrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundItems(@NonNull PrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.compoundItems.contains(entity)) {
			compoundItems.add(entity);
			if (reverseAdd) {
				entity.setCompound(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		addCompoundItems(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionItemEntity to Compound Items in this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be set to this entity
	 */
	public void removeCompoundItems(@NonNull PrescriptionItemEntity entity) {
		this.removeCompoundItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundItems(@NonNull PrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCompound(false);
		}
		this.compoundItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 */
	public void removeCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		this.removeCompoundItems(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be set to this entity
	 */
	public void setCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		setCompoundItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetCompoundItems();
		this.compoundItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundItems.forEach(compoundItemsEntity -> compoundItemsEntity.setCompound(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundItems() {
		this.unsetCompoundItems(true);
	}

	/**
	 * Remove all the entities in Compound Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundItems(boolean doReverse) {
		if (doReverse) {
			this.compoundItems.forEach(compoundItemsEntity -> compoundItemsEntity.unsetCompound(false));
		}
		this.compoundItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.unit.removeCompoundsUnit(this, false);
		}
		this.unit = entity;
		if (reverseAdd) {
			this.unit.addCompoundsUnit(this, false);
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
			this.unit.removeCompoundsUnit(this, false);
		}
		this.unit = null;
	}
	/**
	 * Similar to {@link this#setPrescriptionHeader(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescriptionHeader(@NonNull PrescriptionHeaderEntity entity) {
		setPrescriptionHeader(entity, true);
	}

	/**
	 * Set or update the prescriptionHeader in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescriptionHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescriptionHeader(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescriptionHeader here] end

		if (sameAsFormer(this.prescriptionHeader, entity)) {
			return;
		}

		if (this.prescriptionHeader != null) {
			this.prescriptionHeader.removePrescriptionCompounds(this, false);
		}
		this.prescriptionHeader = entity;
		if (reverseAdd) {
			this.prescriptionHeader.addPrescriptionCompounds(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescriptionHeader incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeader(boolean)} but default to true.
	 */
	public void unsetPrescriptionHeader() {
		this.unsetPrescriptionHeader(true);
	}

	/**
	 * Remove Prescription Header in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescriptionHeader(boolean reverse) {
		if (reverse && this.prescriptionHeader != null) {
			this.prescriptionHeader.removePrescriptionCompounds(this, false);
		}
		this.prescriptionHeader = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
