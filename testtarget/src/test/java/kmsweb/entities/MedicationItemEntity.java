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
public class MedicationItemEntity extends AbstractEntity {

	public MedicationItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicationAdministeredHisotriesOneMany = new EntityReference();
			MedicationAdministeredHisotriesOneMany.entityName = "MedicationAdministeredHistory";
			MedicationAdministeredHisotriesOneMany.oppositeName = "MedicationItem";
			MedicationAdministeredHisotriesOneMany.name = "MedicationAdministeredHisotries";
			MedicationAdministeredHisotriesOneMany.optional = true;
			MedicationAdministeredHisotriesOneMany.type = "One";
			MedicationAdministeredHisotriesOneMany.oppositeType = "Many";

		References.add(MedicationAdministeredHisotriesOneMany);

		var MedicationCompoundOneMany = new EntityReference();
			MedicationCompoundOneMany.entityName = "MedicationCompound";
			MedicationCompoundOneMany.oppositeName = "MedicationCompound";
			MedicationCompoundOneMany.name = "MedicationItems";
			MedicationCompoundOneMany.optional = true;
			MedicationCompoundOneMany.type = "One";
			MedicationCompoundOneMany.oppositeType = "Many";

		References.add(MedicationCompoundOneMany);

		var MedicationHeaderOneMany = new EntityReference();
			MedicationHeaderOneMany.entityName = "MedicationHeader";
			MedicationHeaderOneMany.oppositeName = "MedicationHeader";
			MedicationHeaderOneMany.name = "MedicationItems";
			MedicationHeaderOneMany.optional = true;
			MedicationHeaderOneMany.type = "One";
			MedicationHeaderOneMany.oppositeType = "Many";

		References.add(MedicationHeaderOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "MedicationItems";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);

		var UnitOfMeasurementOneMany = new EntityReference();
			UnitOfMeasurementOneMany.entityName = "UnitOfMeasurement";
			UnitOfMeasurementOneMany.oppositeName = "UnitOfMeasurement";
			UnitOfMeasurementOneMany.name = "MedicationItems";
			UnitOfMeasurementOneMany.optional = true;
			UnitOfMeasurementOneMany.type = "One";
			UnitOfMeasurementOneMany.oppositeType = "Many";

		References.add(UnitOfMeasurementOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Total Issued Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Issued Quantity here] end
	private Double totalIssuedQuantity;

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

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

	// % protected region % [Modify attribute annotation for External Medication Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Medication Name here] end
	private String externalMedicationName;

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

	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicationCompoundEntity medicationCompound;

	private MedicationHeaderEntity medicationHeader;

	private StockCatalogueEntity stockCatalogue;

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
	 * Similar to {@link this#addMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity) {
		addMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Add a new MedicationAdministeredHistoryEntity to medicationAdministeredHisotries in this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverseAdd) {
		if (!this.medicationAdministeredHisotries.contains(entity)) {
			medicationAdministeredHisotries.add(entity);
			if (reverseAdd) {
				entity.setMedicationItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		addMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Add a new collection of MedicationAdministeredHistoryEntity to Medication Administered Hisotries in this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicationItem(false);
		}
		this.medicationAdministeredHisotries.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 */
	public void removeMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		this.removeMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Remove the given collection of MedicationAdministeredHistoryEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationAdministeredHisotries(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationAdministeredHisotries(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to be set to this entity
	 */
	public void setMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Hisotries with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHisotries(@NonNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

		this.unsetMedicationAdministeredHisotries();
		this.medicationAdministeredHisotries = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.setMedicationItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationAdministeredHisotries(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationAdministeredHisotries() {
		this.unsetMedicationAdministeredHisotries(true);
	}

	/**
	 * Remove all the entities in Medication Administered Hisotries from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationAdministeredHisotries(boolean doReverse) {
		if (doReverse) {
			this.medicationAdministeredHisotries.forEach(medicationAdministeredHisotriesEntity -> medicationAdministeredHisotriesEntity.unsetMedicationItem(false));
		}
		this.medicationAdministeredHisotries.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicationCompound(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be set to this entity
	 */
	public void setMedicationCompound(@NonNull MedicationCompoundEntity entity) {
		setMedicationCompound(entity, true);
	}

	/**
	 * Set or update the medicationCompound in this entity with single MedicationCompoundEntity.
	 *
	 * @param entity the given MedicationCompoundEntity to be set or updated to medicationCompound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationCompound(@NonNull MedicationCompoundEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] end

		if (sameAsFormer(this.medicationCompound, entity)) {
			return;
		}

		if (this.medicationCompound != null) {
			this.medicationCompound.removeMedicationItems(this, false);
		}
		this.medicationCompound = entity;
		if (reverseAdd) {
			this.medicationCompound.addMedicationItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationCompound(boolean)} but default to true.
	 */
	public void unsetMedicationCompound() {
		this.unsetMedicationCompound(true);
	}

	/**
	 * Remove Medication Compound in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationCompound(boolean reverse) {
		if (reverse && this.medicationCompound != null) {
			this.medicationCompound.removeMedicationItems(this, false);
		}
		this.medicationCompound = null;
	}
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
			this.medicationHeader.removeMedicationItems(this, false);
		}
		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.addMedicationItems(this, false);
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
			this.medicationHeader.removeMedicationItems(this, false);
		}
		this.medicationHeader = null;
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
			this.stockCatalogue.removeMedicationItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addMedicationItems(this, false);
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
			this.stockCatalogue.removeMedicationItems(this, false);
		}
		this.stockCatalogue = null;
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
			this.unitOfMeasurement.removeMedicationItems(this, false);
		}
		this.unitOfMeasurement = entity;
		if (reverseAdd) {
			this.unitOfMeasurement.addMedicationItems(this, false);
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
			this.unitOfMeasurement.removeMedicationItems(this, false);
		}
		this.unitOfMeasurement = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
