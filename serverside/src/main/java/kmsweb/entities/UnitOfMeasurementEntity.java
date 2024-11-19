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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.UnitOfMeasurementEntityDto;
import kmsweb.entities.listeners.UnitOfMeasurementEntityListener;
import kmsweb.serializers.UnitOfMeasurementSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({UnitOfMeasurementEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = UnitOfMeasurementSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class UnitOfMeasurementEntity extends AbstractEntity {

	/**
	 * Takes a UnitOfMeasurementEntityDto and converts it into a UnitOfMeasurementEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param unitOfMeasurementEntityDto
	 */
	public UnitOfMeasurementEntity(UnitOfMeasurementEntityDto unitOfMeasurementEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (unitOfMeasurementEntityDto.getId() != null) {
			this.setId(unitOfMeasurementEntityDto.getId());
		}

		if (unitOfMeasurementEntityDto.getUnitName() != null) {
			this.setUnitName(unitOfMeasurementEntityDto.getUnitName());
		}

		if (unitOfMeasurementEntityDto.getSymbol() != null) {
			this.setSymbol(unitOfMeasurementEntityDto.getSymbol());
		}

		if (unitOfMeasurementEntityDto.getDescription() != null) {
			this.setDescription(unitOfMeasurementEntityDto.getDescription());
		}

		if (unitOfMeasurementEntityDto.getUnitCategory() != null) {
			this.setUnitCategory(unitOfMeasurementEntityDto.getUnitCategory());
		}

		if (unitOfMeasurementEntityDto.getConsumptionUnit() != null) {
			this.setConsumptionUnit(unitOfMeasurementEntityDto.getConsumptionUnit());
		}

		if (unitOfMeasurementEntityDto.getCompoundPrescriptionDetails() != null) {
			this.setCompoundPrescriptionDetails(unitOfMeasurementEntityDto.getCompoundPrescriptionDetails());
		}

		if (unitOfMeasurementEntityDto.getCompoundPrescriptionItems() != null) {
			this.setCompoundPrescriptionItems(unitOfMeasurementEntityDto.getCompoundPrescriptionItems());
		}

		if (unitOfMeasurementEntityDto.getCompoundsUnit() != null) {
			this.setCompoundsUnit(unitOfMeasurementEntityDto.getCompoundsUnit());
		}

		if (unitOfMeasurementEntityDto.getMedicationCompounds() != null) {
			this.setMedicationCompounds(unitOfMeasurementEntityDto.getMedicationCompounds());
		}

		if (unitOfMeasurementEntityDto.getMedicationItems() != null) {
			this.setMedicationItems(unitOfMeasurementEntityDto.getMedicationItems());
		}

		if (unitOfMeasurementEntityDto.getPrescriptionItems() != null) {
			this.setPrescriptionItems(unitOfMeasurementEntityDto.getPrescriptionItems());
		}

		if (unitOfMeasurementEntityDto.getCatalogueUOM() != null) {
			this.setCatalogueUOM(unitOfMeasurementEntityDto.getCatalogueUOM());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Unit Name here] off begin
	@CsvBindByName(column = "UNIT_NAME", required = true)
	@NotNull(message = "Unit Name must not be empty")
	@Column(name = "unit_name")
	@Schema(description = "The Unit Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Name here] end
	private String unitName;

	// % protected region % [Modify attribute annotation for Symbol here] off begin
	@CsvBindByName(column = "SYMBOL", required = false)
	@Nullable
	@Column(name = "symbol")
	@Schema(description = "The Symbol of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Symbol here] end
	private String symbol;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Unit Category here] off begin
	@CsvBindByName(column = "UNIT_CATEGORY", required = false)
	@Nullable
	@Column(name = "unit_category")
	@Schema(description = "The Unit Category of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Category here] end
	private String unitCategory;

	// % protected region % [Modify attribute annotation for Consumption Unit here] off begin
	@CsvBindByName(column = "CONSUMPTION_UNIT", required = false)
	@Nullable
	@Column(name = "consumption_unit")
	@Schema(description = "The Consumption Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consumption Unit here] end
	private Boolean consumptionUnit = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Compound Prescription Details here] off begin
	@Schema(description = "The Compound Prescription Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "consumptionUnit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Prescription Details here] end
	private Set<CompoundPrescriptionDetailEntity> compoundPrescriptionDetails = new HashSet<>();

	// % protected region % [Update the annotation for compoundPrescriptionDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_PRESCRIPTION_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundPrescriptionDetailsIds here] end
	private Set<UUID> compoundPrescriptionDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Compound Prescription Items here] off begin
	@Schema(description = "The Compound Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "unit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Prescription Items here] end
	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_PRESCRIPTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] end
	private Set<UUID> compoundPrescriptionItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Compounds Unit here] off begin
	@Schema(description = "The Prescription Compound entities that are related to this entity.")
	@OneToMany(mappedBy = "unit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compounds Unit here] end
	private Set<PrescriptionCompoundEntity> compoundsUnit = new HashSet<>();

	// % protected region % [Update the annotation for compoundsUnitIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUNDS_UNIT_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundsUnitIds here] end
	private Set<UUID> compoundsUnitIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Compounds here] off begin
	@Schema(description = "The Medication Compound entities that are related to this entity.")
	@OneToMany(mappedBy = "unitOfMeasurement", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Compounds here] end
	private Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();

	// % protected region % [Update the annotation for medicationCompoundsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_COMPOUNDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationCompoundsIds here] end
	private Set<UUID> medicationCompoundsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Items here] off begin
	@Schema(description = "The Medication Item entities that are related to this entity.")
	@OneToMany(mappedBy = "unitOfMeasurement", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Items here] end
	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	// % protected region % [Update the annotation for medicationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationItemsIds here] end
	private Set<UUID> medicationItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Items here] off begin
	@Schema(description = "The Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "unit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Items here] end
	private Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionItemsIds here] end
	private Set<UUID> prescriptionItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Catalogue UOM here] off begin
	@Schema(description = "The Catalogue UOM entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Catalogue UOM here] end
	private CatalogueUOMEntity catalogueUOM;

	// % protected region % [Update the annotation for catalogueUOMId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CATALOGUE_UOM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for catalogueUOMId here] end
	private UUID catalogueUOMId;

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
	public void addCompoundPrescriptionDetails(@NotNull CompoundPrescriptionDetailEntity entity) {
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
	public void addCompoundPrescriptionDetails(@NotNull Collection<CompoundPrescriptionDetailEntity> entities) {
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
	public void removeCompoundPrescriptionDetails(@NotNull CompoundPrescriptionDetailEntity entity) {
		this.removeCompoundPrescriptionDetails(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionDetailEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionDetails(@NotNull CompoundPrescriptionDetailEntity entity, boolean reverse) {
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
	public void removeCompoundPrescriptionDetails(@NotNull Collection<CompoundPrescriptionDetailEntity> entities) {
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
	public void setCompoundPrescriptionDetails(@NotNull Collection<CompoundPrescriptionDetailEntity> entities) {
		setCompoundPrescriptionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Details with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionDetails(@NotNull Collection<CompoundPrescriptionDetailEntity> entities, boolean reverseAdd) {

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
	public void addCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity) {
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
	public void addCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
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
	public void removeCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity) {
		this.removeCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionItemEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity, boolean reverse) {
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
	public void removeCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
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
	public void setCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
		setCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Items with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {

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
	public void addCompoundsUnit(@NotNull PrescriptionCompoundEntity entity) {
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
	public void addCompoundsUnit(@NotNull Collection<PrescriptionCompoundEntity> entities) {
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
	public void removeCompoundsUnit(@NotNull PrescriptionCompoundEntity entity) {
		this.removeCompoundsUnit(entity, true);
	}

	/**
	 * Remove the given PrescriptionCompoundEntity from this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundsUnit(@NotNull PrescriptionCompoundEntity entity, boolean reverse) {
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
	public void removeCompoundsUnit(@NotNull Collection<PrescriptionCompoundEntity> entities) {
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
	public void setCompoundsUnit(@NotNull Collection<PrescriptionCompoundEntity> entities) {
		setCompoundsUnit(entities, true);
	}

	/**
	 * Replace the current entities in Compounds Unit with the given ones.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundsUnit(@NotNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {

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
	public void addMedicationCompounds(@NotNull MedicationCompoundEntity entity) {
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
	public void addMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
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
	public void removeMedicationCompounds(@NotNull MedicationCompoundEntity entity) {
		this.removeMedicationCompounds(entity, true);
	}

	/**
	 * Remove the given MedicationCompoundEntity from this entity.
	 *
	 * @param entity the given MedicationCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationCompounds(@NotNull MedicationCompoundEntity entity, boolean reverse) {
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
	public void removeMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
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
	public void setMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
		setMedicationCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Medication Compounds with the given ones.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {

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
	public void addMedicationItems(@NotNull MedicationItemEntity entity) {
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
	public void addMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
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
	public void removeMedicationItems(@NotNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NotNull MedicationItemEntity entity, boolean reverse) {
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
	public void removeMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
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
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

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
	public void addPrescriptionItems(@NotNull PrescriptionItemEntity entity) {
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
	public void addPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
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
	public void removePrescriptionItems(@NotNull PrescriptionItemEntity entity) {
		this.removePrescriptionItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItems(@NotNull PrescriptionItemEntity entity, boolean reverse) {
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
	public void removePrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
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
	public void setPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "UNIT_NAME,SYMBOL,DESCRIPTION,UNIT_CATEGORY,CONSUMPTION_UNIT,CATALOGUE_UOM_ID,COMPOUND_PRESCRIPTION_DETAILS_IDS,COMPOUND_PRESCRIPTION_ITEMS_IDS,COMPOUNDS_UNIT_IDS,MEDICATION_COMPOUNDS_IDS,MEDICATION_ITEMS_IDS,PRESCRIPTION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<CatalogueUOMEntity> catalogueUOMRelation = Optional.ofNullable(this.catalogueUOM);
		catalogueUOMRelation.ifPresent(entity -> this.catalogueUOMId = entity.getId());

		this.compoundPrescriptionDetailsIds = new HashSet<>();
		for (CompoundPrescriptionDetailEntity compoundPrescriptionDetails: this.compoundPrescriptionDetails) {
			this.compoundPrescriptionDetailsIds.add(compoundPrescriptionDetails.getId());
		}

		this.compoundPrescriptionItemsIds = new HashSet<>();
		for (CompoundPrescriptionItemEntity compoundPrescriptionItems: this.compoundPrescriptionItems) {
			this.compoundPrescriptionItemsIds.add(compoundPrescriptionItems.getId());
		}

		this.compoundsUnitIds = new HashSet<>();
		for (PrescriptionCompoundEntity compoundsUnit: this.compoundsUnit) {
			this.compoundsUnitIds.add(compoundsUnit.getId());
		}

		this.medicationCompoundsIds = new HashSet<>();
		for (MedicationCompoundEntity medicationCompounds: this.medicationCompounds) {
			this.medicationCompoundsIds.add(medicationCompounds.getId());
		}

		this.medicationItemsIds = new HashSet<>();
		for (MedicationItemEntity medicationItems: this.medicationItems) {
			this.medicationItemsIds.add(medicationItems.getId());
		}

		this.prescriptionItemsIds = new HashSet<>();
		for (PrescriptionItemEntity prescriptionItems: this.prescriptionItems) {
			this.prescriptionItemsIds.add(prescriptionItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object unitOfMeasurement) {
		if (this == unitOfMeasurement) {
			return true;
		}
		if (unitOfMeasurement == null || this.getClass() != unitOfMeasurement.getClass()) {
			return false;
		}
		if (!super.equals(unitOfMeasurement)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		UnitOfMeasurementEntity that = (UnitOfMeasurementEntity) unitOfMeasurement;
		return
			Objects.equals(this.unitName, that.unitName) &&
			Objects.equals(this.symbol, that.symbol) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.unitCategory, that.unitCategory) &&
			Objects.equals(this.consumptionUnit, that.consumptionUnit) &&
			Objects.equals(this.compoundPrescriptionDetailsIds, that.compoundPrescriptionDetailsIds) &&
			Objects.equals(this.compoundPrescriptionItemsIds, that.compoundPrescriptionItemsIds) &&
			Objects.equals(this.compoundsUnitIds, that.compoundsUnitIds) &&
			Objects.equals(this.medicationCompoundsIds, that.medicationCompoundsIds) &&
			Objects.equals(this.medicationItemsIds, that.medicationItemsIds) &&
			Objects.equals(this.prescriptionItemsIds, that.prescriptionItemsIds) &&
			Objects.equals(this.catalogueUOMId, that.catalogueUOMId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
