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
public class UnitOfMeasurementEntity extends AbstractEntity {

	public UnitOfMeasurementEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CompoundPrescriptionDetailsOneMany = new EntityReference();
			CompoundPrescriptionDetailsOneMany.entityName = "CompoundPrescriptionDetail";
			CompoundPrescriptionDetailsOneMany.oppositeName = "ConsumptionUnit";
			CompoundPrescriptionDetailsOneMany.name = "CompoundPrescriptionDetails";
			CompoundPrescriptionDetailsOneMany.optional = true;
			CompoundPrescriptionDetailsOneMany.type = "One";
			CompoundPrescriptionDetailsOneMany.oppositeType = "Many";

		References.add(CompoundPrescriptionDetailsOneMany);

		var CompoundPrescriptionItemsOneMany = new EntityReference();
			CompoundPrescriptionItemsOneMany.entityName = "CompoundPrescriptionItem";
			CompoundPrescriptionItemsOneMany.oppositeName = "Unit";
			CompoundPrescriptionItemsOneMany.name = "CompoundPrescriptionItems";
			CompoundPrescriptionItemsOneMany.optional = true;
			CompoundPrescriptionItemsOneMany.type = "One";
			CompoundPrescriptionItemsOneMany.oppositeType = "Many";

		References.add(CompoundPrescriptionItemsOneMany);

		var CompoundsUnitOneMany = new EntityReference();
			CompoundsUnitOneMany.entityName = "PrescriptionCompound";
			CompoundsUnitOneMany.oppositeName = "Unit";
			CompoundsUnitOneMany.name = "CompoundsUnit";
			CompoundsUnitOneMany.optional = true;
			CompoundsUnitOneMany.type = "One";
			CompoundsUnitOneMany.oppositeType = "Many";

		References.add(CompoundsUnitOneMany);

		var MedicationCompoundsOneMany = new EntityReference();
			MedicationCompoundsOneMany.entityName = "MedicationCompound";
			MedicationCompoundsOneMany.oppositeName = "UnitOfMeasurement";
			MedicationCompoundsOneMany.name = "MedicationCompounds";
			MedicationCompoundsOneMany.optional = true;
			MedicationCompoundsOneMany.type = "One";
			MedicationCompoundsOneMany.oppositeType = "Many";

		References.add(MedicationCompoundsOneMany);

		var MedicationItemsOneMany = new EntityReference();
			MedicationItemsOneMany.entityName = "MedicationItem";
			MedicationItemsOneMany.oppositeName = "UnitOfMeasurement";
			MedicationItemsOneMany.name = "MedicationItems";
			MedicationItemsOneMany.optional = true;
			MedicationItemsOneMany.type = "One";
			MedicationItemsOneMany.oppositeType = "Many";

		References.add(MedicationItemsOneMany);

		var PrescriptionItemsOneMany = new EntityReference();
			PrescriptionItemsOneMany.entityName = "PrescriptionItem";
			PrescriptionItemsOneMany.oppositeName = "Unit";
			PrescriptionItemsOneMany.name = "PrescriptionItems";
			PrescriptionItemsOneMany.optional = true;
			PrescriptionItemsOneMany.type = "One";
			PrescriptionItemsOneMany.oppositeType = "Many";

		References.add(PrescriptionItemsOneMany);

		var CatalogueUOMOneOne = new EntityReference();
			CatalogueUOMOneOne.entityName = "CatalogueUOM";
			CatalogueUOMOneOne.oppositeName = "CatalogueUOM";
			CatalogueUOMOneOne.name = "UnitOfMeasurement";
			CatalogueUOMOneOne.optional = true;
			CatalogueUOMOneOne.type = "One";
			CatalogueUOMOneOne.oppositeType = "One";

		References.add(CatalogueUOMOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Unit Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Name here] end
	private String unitName;

	// % protected region % [Modify attribute annotation for Symbol here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Symbol here] end
	private String symbol;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Unit Category here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Category here] end
	private String unitCategory;

	// % protected region % [Modify attribute annotation for Consumption Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consumption Unit here] end
	private Boolean consumptionUnit;

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

	private CatalogueUOMEntity catalogueUOM;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetails = new HashSet<>();

	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	private Set<PrescriptionCompoundEntity> compoundsUnit = new HashSet<>();

	private Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();

	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	private Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();

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

/**
	 * Similar to {@link this#addCompoundPrescriptionDetails(CompoundPrescriptionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be added to this entity
	 */
	public void addCompoundPrescriptionDetails(@NonNull CompoundPrescriptionDetailEntity entity) {
		addCompoundPrescriptionDetails(entity, true);
	}

	/**
	 * Add a new CompoundPrescriptionDetailEntity to compoundPrescriptionDetails in this entity.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundPrescriptionDetails(@NonNull CompoundPrescriptionDetailEntity entity, boolean reverseAdd) {
		if (!this.compoundPrescriptionDetails.contains(entity)) {
			compoundPrescriptionDetails.add(entity);
			if (reverseAdd) {
				entity.setConsumptionUnit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundPrescriptionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to be added to this entity
	 */
	public void addCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities) {
		addCompoundPrescriptionDetails(entities, true);
	}

	/**
	 * Add a new collection of CompoundPrescriptionDetailEntity to Compound Prescription Details in this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundPrescriptionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionDetails(CompoundPrescriptionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be set to this entity
	 */
	public void removeCompoundPrescriptionDetails(@NonNull CompoundPrescriptionDetailEntity entity) {
		this.removeCompoundPrescriptionDetails(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionDetailEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionDetails(@NonNull CompoundPrescriptionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetConsumptionUnit(false);
		}
		this.compoundPrescriptionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to be removed to this entity
	 */
	public void removeCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities) {
		this.removeCompoundPrescriptionDetails(entities, true);
	}

	/**
	 * Remove the given collection of CompoundPrescriptionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundPrescriptionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundPrescriptionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to be set to this entity
	 */
	public void setCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities) {
		setCompoundPrescriptionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Details with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionDetails(@NonNull Collection<CompoundPrescriptionDetailEntity> entities, boolean reverseAdd) {

		this.unsetCompoundPrescriptionDetails();
		this.compoundPrescriptionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundPrescriptionDetails.forEach(compoundPrescriptionDetailsEntity -> compoundPrescriptionDetailsEntity.setConsumptionUnit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundPrescriptionDetails() {
		this.unsetCompoundPrescriptionDetails(true);
	}

	/**
	 * Remove all the entities in Compound Prescription Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundPrescriptionDetails(boolean doReverse) {
		if (doReverse) {
			this.compoundPrescriptionDetails.forEach(compoundPrescriptionDetailsEntity -> compoundPrescriptionDetailsEntity.unsetConsumptionUnit(false));
		}
		this.compoundPrescriptionDetails.clear();
	}

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
				entity.setUnit(this, false);
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
			entity.unsetUnit(false);
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
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.setUnit(this, false));
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
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.unsetUnit(false));
		}
		this.compoundPrescriptionItems.clear();
	}

/**
	 * Similar to {@link this#addCompoundsUnit(PrescriptionCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be added to this entity
	 */
	public void addCompoundsUnit(@NonNull PrescriptionCompoundEntity entity) {
		addCompoundsUnit(entity, true);
	}

	/**
	 * Add a new PrescriptionCompoundEntity to compoundsUnit in this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundsUnit(@NonNull PrescriptionCompoundEntity entity, boolean reverseAdd) {
		if (!this.compoundsUnit.contains(entity)) {
			compoundsUnit.add(entity);
			if (reverseAdd) {
				entity.setUnit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundsUnit(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be added to this entity
	 */
	public void addCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities) {
		addCompoundsUnit(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionCompoundEntity to Compounds Unit in this entity.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundsUnit(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundsUnit(PrescriptionCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be set to this entity
	 */
	public void removeCompoundsUnit(@NonNull PrescriptionCompoundEntity entity) {
		this.removeCompoundsUnit(entity, true);
	}

	/**
	 * Remove the given PrescriptionCompoundEntity from this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundsUnit(@NonNull PrescriptionCompoundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetUnit(false);
		}
		this.compoundsUnit.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundsUnit(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be removed to this entity
	 */
	public void removeCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities) {
		this.removeCompoundsUnit(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionCompoundEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundsUnit(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundsUnit(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be set to this entity
	 */
	public void setCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities) {
		setCompoundsUnit(entities, true);
	}

	/**
	 * Replace the current entities in Compounds Unit with the given ones.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundsUnit(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {

		this.unsetCompoundsUnit();
		this.compoundsUnit = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundsUnit.forEach(compoundsUnitEntity -> compoundsUnitEntity.setUnit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundsUnit(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundsUnit() {
		this.unsetCompoundsUnit(true);
	}

	/**
	 * Remove all the entities in Compounds Unit from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundsUnit(boolean doReverse) {
		if (doReverse) {
			this.compoundsUnit.forEach(compoundsUnitEntity -> compoundsUnitEntity.unsetUnit(false));
		}
		this.compoundsUnit.clear();
	}

/**
	 * Similar to {@link this#addMedicationCompounds(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be added to this entity
	 */
	public void addMedicationCompounds(@NonNull MedicationCompoundEntity entity) {
		addMedicationCompounds(entity, true);
	}

	/**
	 * Add a new MedicationCompoundEntity to medicationCompounds in this entity.
	 *
	 * @param entity the given MedicationCompoundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationCompounds(@NonNull MedicationCompoundEntity entity, boolean reverseAdd) {
		if (!this.medicationCompounds.contains(entity)) {
			medicationCompounds.add(entity);
			if (reverseAdd) {
				entity.setUnitOfMeasurement(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be added to this entity
	 */
	public void addMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
		addMedicationCompounds(entities, true);
	}

	/**
	 * Add a new collection of MedicationCompoundEntity to Medication Compounds in this entity.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationCompounds(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be set to this entity
	 */
	public void removeMedicationCompounds(@NonNull MedicationCompoundEntity entity) {
		this.removeMedicationCompounds(entity, true);
	}

	/**
	 * Remove the given MedicationCompoundEntity from this entity.
	 *
	 * @param entity the given MedicationCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationCompounds(@NonNull MedicationCompoundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetUnitOfMeasurement(false);
		}
		this.medicationCompounds.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be removed to this entity
	 */
	public void removeMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
		this.removeMedicationCompounds(entities, true);
	}

	/**
	 * Remove the given collection of MedicationCompoundEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be set to this entity
	 */
	public void setMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
		setMedicationCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Medication Compounds with the given ones.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {

		this.unsetMedicationCompounds();
		this.medicationCompounds = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationCompounds.forEach(medicationCompoundsEntity -> medicationCompoundsEntity.setUnitOfMeasurement(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationCompounds(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationCompounds() {
		this.unsetMedicationCompounds(true);
	}

	/**
	 * Remove all the entities in Medication Compounds from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationCompounds(boolean doReverse) {
		if (doReverse) {
			this.medicationCompounds.forEach(medicationCompoundsEntity -> medicationCompoundsEntity.unsetUnitOfMeasurement(false));
		}
		this.medicationCompounds.clear();
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
				entity.setUnitOfMeasurement(this, false);
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
			entity.unsetUnitOfMeasurement(false);
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
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.setUnitOfMeasurement(this, false));
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
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.unsetUnitOfMeasurement(false));
		}
		this.medicationItems.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItems(@NonNull PrescriptionItemEntity entity) {
		addPrescriptionItems(entity, true);
	}

	/**
	 * Add a new PrescriptionItemEntity to prescriptionItems in this entity.
	 *
	 * @param entity the given PrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionItems(@NonNull PrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.prescriptionItems.contains(entity)) {
			prescriptionItems.add(entity);
			if (reverseAdd) {
				entity.setUnit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		addPrescriptionItems(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionItemEntity to Prescription Items in this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be set to this entity
	 */
	public void removePrescriptionItems(@NonNull PrescriptionItemEntity entity) {
		this.removePrescriptionItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItems(@NonNull PrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetUnit(false);
		}
		this.prescriptionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 */
	public void removePrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		this.removePrescriptionItems(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be set to this entity
	 */
	public void setPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionItems();
		this.prescriptionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionItems.forEach(prescriptionItemsEntity -> prescriptionItemsEntity.setUnit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionItems() {
		this.unsetPrescriptionItems(true);
	}

	/**
	 * Remove all the entities in Prescription Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionItems(boolean doReverse) {
		if (doReverse) {
			this.prescriptionItems.forEach(prescriptionItemsEntity -> prescriptionItemsEntity.unsetUnit(false));
		}
		this.prescriptionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setCatalogueUOM(CatalogueUOMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be set to this entity
	 */
	public void setCatalogueUOM(CatalogueUOMEntity entity) {
		setCatalogueUOM(entity, true);
	}

	/**
	 * Set or update the catalogueUOM in this entity with single CatalogueUOMEntity.
	 *
	 * @param entity the given CatalogueUOMEntity to be set or updated to catalogueUOM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCatalogueUOM(CatalogueUOMEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCatalogueUOM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCatalogueUOM here] end

		if (sameAsFormer(this.catalogueUOM, entity)) {
			return;
		}

		if (this.catalogueUOM != null) {
			this.catalogueUOM.unsetUnitOfMeasurement(false);
		}

		this.catalogueUOM = entity;
		if (reverseAdd) {
			this.catalogueUOM.setUnitOfMeasurement(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCatalogueUOM incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCatalogueUOM incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetCatalogueUOM(boolean)} but default to true.
	 */
	public void unsetCatalogueUOM() {
		this.unsetCatalogueUOM(true);
	}

	/**
	 * Remove the CatalogueUOMEntity of catalogueUOM from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCatalogueUOM(boolean reverse) {
		if (reverse && this.catalogueUOM != null) {
			this.catalogueUOM.unsetUnitOfMeasurement();
		}
		this.catalogueUOM = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
