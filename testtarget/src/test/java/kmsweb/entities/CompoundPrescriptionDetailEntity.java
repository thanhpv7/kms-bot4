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
public class CompoundPrescriptionDetailEntity extends AbstractEntity {

	public CompoundPrescriptionDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ConsumptionUnitOneMany = new EntityReference();
			ConsumptionUnitOneMany.entityName = "UnitOfMeasurement";
			ConsumptionUnitOneMany.oppositeName = "ConsumptionUnit";
			ConsumptionUnitOneMany.name = "CompoundPrescriptionDetails";
			ConsumptionUnitOneMany.optional = true;
			ConsumptionUnitOneMany.type = "One";
			ConsumptionUnitOneMany.oppositeType = "Many";

		References.add(ConsumptionUnitOneMany);

		var CompoundPrescriptionItemsOneMany = new EntityReference();
			CompoundPrescriptionItemsOneMany.entityName = "CompoundPrescriptionItem";
			CompoundPrescriptionItemsOneMany.oppositeName = "CompoundPrescriptionDetail";
			CompoundPrescriptionItemsOneMany.name = "CompoundPrescriptionItems";
			CompoundPrescriptionItemsOneMany.optional = true;
			CompoundPrescriptionItemsOneMany.type = "One";
			CompoundPrescriptionItemsOneMany.oppositeType = "Many";

		References.add(CompoundPrescriptionItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Request Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request Quantity here] end
	private Double requestQuantity;

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

	// % protected region % [Modify attribute annotation for Consumption Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consumption Method here] end
	private String consumptionMethod;

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

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd;

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

	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private UnitOfMeasurementEntity consumptionUnit;

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
	 * Similar to {@link this#addCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity) {
		addCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Add a new CompoundPrescriptionItemEntity to compoundPrescriptionItems in this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.compoundPrescriptionItems.contains(entity)) {
			compoundPrescriptionItems.add(entity);
			if (reverseAdd) {
				entity.setCompoundPrescriptionDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		addCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Add a new collection of CompoundPrescriptionItemEntity to Compound Prescription Items in this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity) {
		this.removeCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionItemEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCompoundPrescriptionDetail(false);
		}
		this.compoundPrescriptionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		this.removeCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Remove the given collection of CompoundPrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void setCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		setCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Items with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetCompoundPrescriptionItems();
		this.compoundPrescriptionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.setCompoundPrescriptionDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundPrescriptionItems() {
		this.unsetCompoundPrescriptionItems(true);
	}

	/**
	 * Remove all the entities in Compound Prescription Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundPrescriptionItems(boolean doReverse) {
		if (doReverse) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.unsetCompoundPrescriptionDetail(false));
		}
		this.compoundPrescriptionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setConsumptionUnit(UnitOfMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set to this entity
	 */
	public void setConsumptionUnit(@NonNull UnitOfMeasurementEntity entity) {
		setConsumptionUnit(entity, true);
	}

	/**
	 * Set or update the consumptionUnit in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to consumptionUnit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setConsumptionUnit(@NonNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setConsumptionUnit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setConsumptionUnit here] end

		if (sameAsFormer(this.consumptionUnit, entity)) {
			return;
		}

		if (this.consumptionUnit != null) {
			this.consumptionUnit.removeCompoundPrescriptionDetails(this, false);
		}
		this.consumptionUnit = entity;
		if (reverseAdd) {
			this.consumptionUnit.addCompoundPrescriptionDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setConsumptionUnit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setConsumptionUnit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetConsumptionUnit(boolean)} but default to true.
	 */
	public void unsetConsumptionUnit() {
		this.unsetConsumptionUnit(true);
	}

	/**
	 * Remove Consumption Unit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetConsumptionUnit(boolean reverse) {
		if (reverse && this.consumptionUnit != null) {
			this.consumptionUnit.removeCompoundPrescriptionDetails(this, false);
		}
		this.consumptionUnit = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
