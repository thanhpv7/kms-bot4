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
public class MedicationCompoundEntity extends AbstractEntity {

	public MedicationCompoundEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicationAdministeredHistoriesOneMany = new EntityReference();
			MedicationAdministeredHistoriesOneMany.entityName = "MedicationAdministeredHistory";
			MedicationAdministeredHistoriesOneMany.oppositeName = "MedicationCompound";
			MedicationAdministeredHistoriesOneMany.name = "MedicationAdministeredHistories";
			MedicationAdministeredHistoriesOneMany.optional = true;
			MedicationAdministeredHistoriesOneMany.type = "One";
			MedicationAdministeredHistoriesOneMany.oppositeType = "Many";

		References.add(MedicationAdministeredHistoriesOneMany);

		var MedicationHeaderOneMany = new EntityReference();
			MedicationHeaderOneMany.entityName = "MedicationHeader";
			MedicationHeaderOneMany.oppositeName = "MedicationHeader";
			MedicationHeaderOneMany.name = "MedicationCompounds";
			MedicationHeaderOneMany.optional = true;
			MedicationHeaderOneMany.type = "One";
			MedicationHeaderOneMany.oppositeType = "Many";

		References.add(MedicationHeaderOneMany);

		var UnitOfMeasurementOneMany = new EntityReference();
			UnitOfMeasurementOneMany.entityName = "UnitOfMeasurement";
			UnitOfMeasurementOneMany.oppositeName = "UnitOfMeasurement";
			UnitOfMeasurementOneMany.name = "MedicationCompounds";
			UnitOfMeasurementOneMany.optional = true;
			UnitOfMeasurementOneMany.type = "One";
			UnitOfMeasurementOneMany.oppositeType = "Many";

		References.add(UnitOfMeasurementOneMany);

		var MedicationItemsOneMany = new EntityReference();
			MedicationItemsOneMany.entityName = "MedicationItem";
			MedicationItemsOneMany.oppositeName = "MedicationCompound";
			MedicationItemsOneMany.name = "MedicationItems";
			MedicationItemsOneMany.optional = true;
			MedicationItemsOneMany.type = "One";
			MedicationItemsOneMany.oppositeType = "Many";

		References.add(MedicationItemsOneMany);
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

	// % protected region % [Modify attribute annotation for Requested Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Requested Qty here] end
	private Double requestedQty;

	// % protected region % [Modify attribute annotation for Outstanding Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outstanding Qty here] end
	private Double outstandingQty;

	// % protected region % [Modify attribute annotation for Returned Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Returned Qty here] end
	private Double returnedQty;

	// % protected region % [Modify attribute annotation for Issued Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Issued Qty here] end
	private Double issuedQty;

	// % protected region % [Modify attribute annotation for Administered Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Administered Qty here] end
	private Double administeredQty;

	// % protected region % [Modify attribute annotation for Taken Home Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Taken Home Qty here] end
	private Double takenHomeQty;

	// % protected region % [Modify attribute annotation for Dosage Frequency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dosage Frequency here] end
	private Double dosageFrequency;

	// % protected region % [Modify attribute annotation for Dosage Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dosage Qty here] end
	private Double dosageQty;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dose here] end
	private Double dose;

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

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd;

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

	// % protected region % [Modify attribute annotation for Total Issued Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Issued Quantity here] end
	private Double totalIssuedQuantity;

	// % protected region % [Modify attribute annotation for Total Taken Home Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Taken Home Quantity here] end
	private Integer totalTakenHomeQuantity;

	// % protected region % [Modify attribute annotation for Total Returned Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Returned Quantity here] end
	private Integer totalReturnedQuantity;

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

	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHistories = new HashSet<>();

	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicationHeaderEntity medicationHeader;

	private UnitOfMeasurementEntity unitOfMeasurement;

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
	 * Similar to {@link this#addMedicationAdministeredHistories(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHistories(@NonNull MedicationAdministeredHistoryEntity entity) {
		addMedicationAdministeredHistories(entity, true);
	}

	/**
	 * Add a new MedicationAdministeredHistoryEntity to medicationAdministeredHistories in this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationAdministeredHistories(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverseAdd) {
		if (!this.medicationAdministeredHistories.contains(entity)) {
			medicationAdministeredHistories.add(entity);
			if (reverseAdd) {
				entity.setMedicationCompound(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationAdministeredHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		addMedicationAdministeredHistories(entities, true);
	}

	/**
	 * Add a new collection of MedicationAdministeredHistoryEntity to Medication Administered Histories in this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationAdministeredHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHistories(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void removeMedicationAdministeredHistories(@NonNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHistories(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHistories(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicationCompound(false);
		}
		this.medicationAdministeredHistories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHistories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 */
	public void removeMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		this.removeMedicationAdministeredHistories(entities, true);
	}

	/**
	 * Remove the given collection of MedicationAdministeredHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationAdministeredHistories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationAdministeredHistories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void setMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHistories(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Histories with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHistories(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

		this.unsetMedicationAdministeredHistories();
		this.medicationAdministeredHistories = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationAdministeredHistories.forEach(medicationAdministeredHistoriesEntity -> medicationAdministeredHistoriesEntity.setMedicationCompound(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationAdministeredHistories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationAdministeredHistories() {
		this.unsetMedicationAdministeredHistories(true);
	}

	/**
	 * Remove all the entities in Medication Administered Histories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationAdministeredHistories(boolean doReverse) {
		if (doReverse) {
			this.medicationAdministeredHistories.forEach(medicationAdministeredHistoriesEntity -> medicationAdministeredHistoriesEntity.unsetMedicationCompound(false));
		}
		this.medicationAdministeredHistories.clear();
	}

/**
	 * Similar to {@link this#addMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity) {
		addMedicationItems(entity, true);
	}

	/**
	 * Add a new MedicationItemEntity to medicationItems in this entity.
	 *
	 * @param entity the given MedicationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity, boolean reverseAdd) {
		if (!this.medicationItems.contains(entity)) {
			medicationItems.add(entity);
			if (reverseAdd) {
				entity.setMedicationCompound(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		addMedicationItems(entities, true);
	}

	/**
	 * Add a new collection of MedicationItemEntity to Medication Items in this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void removeMedicationItems(@NonNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NonNull MedicationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicationCompound(false);
		}
		this.medicationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		this.removeMedicationItems(entities, true);
	}

	/**
	 * Remove the given collection of MedicationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

		this.unsetMedicationItems();
		this.medicationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.setMedicationCompound(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationItems() {
		this.unsetMedicationItems(true);
	}

	/**
	 * Remove all the entities in Medication Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationItems(boolean doReverse) {
		if (doReverse) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.unsetMedicationCompound(false));
		}
		this.medicationItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicationHeader(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeader(@NonNull MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(@NonNull MedicationHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] end

		if (sameAsFormer(this.medicationHeader, entity)) {
			return;
		}

		if (this.medicationHeader != null) {
			this.medicationHeader.removeMedicationCompounds(this, false);
		}
		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.addMedicationCompounds(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationHeader(boolean)} but default to true.
	 */
	public void unsetMedicationHeader() {
		this.unsetMedicationHeader(true);
	}

	/**
	 * Remove Medication Header in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationHeader(boolean reverse) {
		if (reverse && this.medicationHeader != null) {
			this.medicationHeader.removeMedicationCompounds(this, false);
		}
		this.medicationHeader = null;
	}
	/**
	 * Similar to {@link this#setUnitOfMeasurement(UnitOfMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set to this entity
	 */
	public void setUnitOfMeasurement(@NonNull UnitOfMeasurementEntity entity) {
		setUnitOfMeasurement(entity, true);
	}

	/**
	 * Set or update the unitOfMeasurement in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to unitOfMeasurement
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnitOfMeasurement(@NonNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setUnitOfMeasurement here] off begin
		// % protected region % [Add any additional logic here before the main logic for setUnitOfMeasurement here] end

		if (sameAsFormer(this.unitOfMeasurement, entity)) {
			return;
		}

		if (this.unitOfMeasurement != null) {
			this.unitOfMeasurement.removeMedicationCompounds(this, false);
		}
		this.unitOfMeasurement = entity;
		if (reverseAdd) {
			this.unitOfMeasurement.addMedicationCompounds(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setUnitOfMeasurement incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setUnitOfMeasurement incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetUnitOfMeasurement(boolean)} but default to true.
	 */
	public void unsetUnitOfMeasurement() {
		this.unsetUnitOfMeasurement(true);
	}

	/**
	 * Remove Unit Of Measurement in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetUnitOfMeasurement(boolean reverse) {
		if (reverse && this.unitOfMeasurement != null) {
			this.unitOfMeasurement.removeMedicationCompounds(this, false);
		}
		this.unitOfMeasurement = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
