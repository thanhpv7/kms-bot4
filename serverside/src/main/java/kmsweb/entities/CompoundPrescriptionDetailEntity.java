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
import kmsweb.dtos.CompoundPrescriptionDetailEntityDto;
import kmsweb.entities.listeners.CompoundPrescriptionDetailEntityListener;
import kmsweb.serializers.CompoundPrescriptionDetailSerializer;
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
@EntityListeners({CompoundPrescriptionDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CompoundPrescriptionDetailSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"compound_code"}, name = "compound_code"),
	}
)
public class CompoundPrescriptionDetailEntity extends AbstractEntity {

	/**
	 * Takes a CompoundPrescriptionDetailEntityDto and converts it into a CompoundPrescriptionDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param compoundPrescriptionDetailEntityDto
	 */
	public CompoundPrescriptionDetailEntity(CompoundPrescriptionDetailEntityDto compoundPrescriptionDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (compoundPrescriptionDetailEntityDto.getId() != null) {
			this.setId(compoundPrescriptionDetailEntityDto.getId());
		}

		if (compoundPrescriptionDetailEntityDto.getCompoundCode() != null) {
			this.setCompoundCode(compoundPrescriptionDetailEntityDto.getCompoundCode());
		}

		if (compoundPrescriptionDetailEntityDto.getCompoundName() != null) {
			this.setCompoundName(compoundPrescriptionDetailEntityDto.getCompoundName());
		}

		if (compoundPrescriptionDetailEntityDto.getRequestQuantity() != null) {
			this.setRequestQuantity(compoundPrescriptionDetailEntityDto.getRequestQuantity());
		}

		if (compoundPrescriptionDetailEntityDto.getDosageTimes() != null) {
			this.setDosageTimes(compoundPrescriptionDetailEntityDto.getDosageTimes());
		}

		if (compoundPrescriptionDetailEntityDto.getDosageDays() != null) {
			this.setDosageDays(compoundPrescriptionDetailEntityDto.getDosageDays());
		}

		if (compoundPrescriptionDetailEntityDto.getFrequency() != null) {
			this.setFrequency(compoundPrescriptionDetailEntityDto.getFrequency());
		}

		if (compoundPrescriptionDetailEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(compoundPrescriptionDetailEntityDto.getConsumptionMethod());
		}

		if (compoundPrescriptionDetailEntityDto.getIterationStart() != null) {
			this.setIterationStart(compoundPrescriptionDetailEntityDto.getIterationStart());
		}

		if (compoundPrescriptionDetailEntityDto.getIterationEnd() != null) {
			this.setIterationEnd(compoundPrescriptionDetailEntityDto.getIterationEnd());
		}

		if (compoundPrescriptionDetailEntityDto.getIsDtd() != null) {
			this.setIsDtd(compoundPrescriptionDetailEntityDto.getIsDtd());
		}

		if (compoundPrescriptionDetailEntityDto.getInstruction() != null) {
			this.setInstruction(compoundPrescriptionDetailEntityDto.getInstruction());
		}

		if (compoundPrescriptionDetailEntityDto.getNotes() != null) {
			this.setNotes(compoundPrescriptionDetailEntityDto.getNotes());
		}

		if (compoundPrescriptionDetailEntityDto.getCompoundPrescriptionItems() != null) {
			this.setCompoundPrescriptionItems(compoundPrescriptionDetailEntityDto.getCompoundPrescriptionItems());
		}

		if (compoundPrescriptionDetailEntityDto.getConsumptionUnit() != null) {
			this.setConsumptionUnit(compoundPrescriptionDetailEntityDto.getConsumptionUnit());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Compound Code here] off begin
	@CsvBindByName(column = "COMPOUND_CODE", required = false)
	@Nullable
	@Column(name = "compound_code")
	@Schema(description = "The Compound Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Compound Code here] end
	private String compoundCode;

	// % protected region % [Modify attribute annotation for Compound Name here] off begin
	@CsvBindByName(column = "COMPOUND_NAME", required = false)
	@Nullable
	@Column(name = "compound_name")
	@Schema(description = "The Compound Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Compound Name here] end
	private String compoundName;

	// % protected region % [Modify attribute annotation for Request Quantity here] off begin
	@CsvBindByName(column = "REQUEST_QUANTITY", required = false)
	@Nullable
	@Column(name = "request_quantity")
	@Schema(description = "The Request Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Request Quantity here] end
	private Double requestQuantity;

	// % protected region % [Modify attribute annotation for Dosage Times here] off begin
	@CsvBindByName(column = "DOSAGE_TIMES", required = false)
	@Nullable
	@Column(name = "dosage_times")
	@Schema(description = "The Dosage Times of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dosage Times here] end
	private Integer dosageTimes;

	// % protected region % [Modify attribute annotation for Dosage Days here] off begin
	@CsvBindByName(column = "DOSAGE_DAYS", required = false)
	@Nullable
	@Column(name = "dosage_days")
	@Schema(description = "The Dosage Days of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dosage Days here] end
	private Double dosageDays;

	// % protected region % [Modify attribute annotation for Frequency here] off begin
	@CsvBindByName(column = "FREQUENCY", required = false)
	@Nullable
	@Column(name = "frequency")
	@Schema(description = "The Frequency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Frequency here] end
	private String frequency;

	// % protected region % [Modify attribute annotation for Consumption Method here] off begin
	@CsvBindByName(column = "CONSUMPTION_METHOD", required = false)
	@Nullable
	@Column(name = "consumption_method")
	@Schema(description = "The Consumption Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consumption Method here] end
	private String consumptionMethod;

	// % protected region % [Modify attribute annotation for Iteration Start here] off begin
	@CsvBindByName(column = "ITERATION_START", required = false)
	@Nullable
	@Column(name = "iteration_start")
	@Schema(description = "The Iteration Start of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Iteration Start here] end
	private Integer iterationStart;

	// % protected region % [Modify attribute annotation for Iteration End here] off begin
	@CsvBindByName(column = "ITERATION_END", required = false)
	@Nullable
	@Column(name = "iteration_end")
	@Schema(description = "The Iteration End of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Iteration End here] end
	private Integer iterationEnd;

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@CsvBindByName(column = "IS_DTD", required = false)
	@Nullable
	@Column(name = "is_dtd")
	@Schema(description = "The Is dtd of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd = false ;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@CsvBindByName(column = "INSTRUCTION", required = false)
	@Nullable
	@Column(name = "instruction")
	@Schema(description = "The Instruction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Compound Prescription Items here] off begin
	@Schema(description = "The Compound Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "compoundPrescriptionDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Prescription Items here] end
	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_PRESCRIPTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] end
	private Set<UUID> compoundPrescriptionItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Consumption Unit here] off begin
	@Schema(description = "The Consumption Unit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Consumption Unit here] end
	private UnitOfMeasurementEntity consumptionUnit;

	// % protected region % [Update the annotation for consumptionUnitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CONSUMPTION_UNIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for consumptionUnitId here] end
	private UUID consumptionUnitId;

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
	public void setConsumptionUnit(@NotNull UnitOfMeasurementEntity entity) {
		setConsumptionUnit(entity, true);
	}

	/**
	 * Set or update the consumptionUnit in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to consumptionUnit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setConsumptionUnit(@NotNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "COMPOUND_CODE,COMPOUND_NAME,REQUEST_QUANTITY,DOSAGE_TIMES,DOSAGE_DAYS,FREQUENCY,CONSUMPTION_METHOD,ITERATION_START,ITERATION_END,IS_DTD,INSTRUCTION,NOTES,CONSUMPTION_UNIT_ID,COMPOUND_PRESCRIPTION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<UnitOfMeasurementEntity> consumptionUnitRelation = Optional.ofNullable(this.consumptionUnit);
		consumptionUnitRelation.ifPresent(entity -> this.consumptionUnitId = entity.getId());

		this.compoundPrescriptionItemsIds = new HashSet<>();
		for (CompoundPrescriptionItemEntity compoundPrescriptionItems: this.compoundPrescriptionItems) {
			this.compoundPrescriptionItemsIds.add(compoundPrescriptionItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object compoundPrescriptionDetail) {
		if (this == compoundPrescriptionDetail) {
			return true;
		}
		if (compoundPrescriptionDetail == null || this.getClass() != compoundPrescriptionDetail.getClass()) {
			return false;
		}
		if (!super.equals(compoundPrescriptionDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CompoundPrescriptionDetailEntity that = (CompoundPrescriptionDetailEntity) compoundPrescriptionDetail;
		return
			Objects.equals(this.compoundCode, that.compoundCode) &&
			Objects.equals(this.compoundName, that.compoundName) &&
			Objects.equals(this.requestQuantity, that.requestQuantity) &&
			Objects.equals(this.dosageTimes, that.dosageTimes) &&
			Objects.equals(this.dosageDays, that.dosageDays) &&
			Objects.equals(this.frequency, that.frequency) &&
			Objects.equals(this.consumptionMethod, that.consumptionMethod) &&
			Objects.equals(this.iterationStart, that.iterationStart) &&
			Objects.equals(this.iterationEnd, that.iterationEnd) &&
			Objects.equals(this.isDtd, that.isDtd) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.compoundPrescriptionItemsIds, that.compoundPrescriptionItemsIds) &&
			Objects.equals(this.consumptionUnitId, that.consumptionUnitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
