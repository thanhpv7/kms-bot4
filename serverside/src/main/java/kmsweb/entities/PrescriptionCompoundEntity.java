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
import kmsweb.dtos.PrescriptionCompoundEntityDto;
import kmsweb.entities.listeners.PrescriptionCompoundEntityListener;
import kmsweb.serializers.PrescriptionCompoundSerializer;
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
@EntityListeners({PrescriptionCompoundEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PrescriptionCompoundSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PrescriptionCompoundEntity extends AbstractEntity {

	/**
	 * Takes a PrescriptionCompoundEntityDto and converts it into a PrescriptionCompoundEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param prescriptionCompoundEntityDto
	 */
	public PrescriptionCompoundEntity(PrescriptionCompoundEntityDto prescriptionCompoundEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (prescriptionCompoundEntityDto.getId() != null) {
			this.setId(prescriptionCompoundEntityDto.getId());
		}

		if (prescriptionCompoundEntityDto.getIterationStart() != null) {
			this.setIterationStart(prescriptionCompoundEntityDto.getIterationStart());
		}

		if (prescriptionCompoundEntityDto.getIterationEnd() != null) {
			this.setIterationEnd(prescriptionCompoundEntityDto.getIterationEnd());
		}

		if (prescriptionCompoundEntityDto.getCompoundCode() != null) {
			this.setCompoundCode(prescriptionCompoundEntityDto.getCompoundCode());
		}

		if (prescriptionCompoundEntityDto.getCompoundName() != null) {
			this.setCompoundName(prescriptionCompoundEntityDto.getCompoundName());
		}

		if (prescriptionCompoundEntityDto.getDosageTimes() != null) {
			this.setDosageTimes(prescriptionCompoundEntityDto.getDosageTimes());
		}

		if (prescriptionCompoundEntityDto.getDosageDays() != null) {
			this.setDosageDays(prescriptionCompoundEntityDto.getDosageDays());
		}

		if (prescriptionCompoundEntityDto.getFrequency() != null) {
			this.setFrequency(prescriptionCompoundEntityDto.getFrequency());
		}

		if (prescriptionCompoundEntityDto.getIsDtd() != null) {
			this.setIsDtd(prescriptionCompoundEntityDto.getIsDtd());
		}

		if (prescriptionCompoundEntityDto.getRequestedQuantity() != null) {
			this.setRequestedQuantity(prescriptionCompoundEntityDto.getRequestedQuantity());
		}

		if (prescriptionCompoundEntityDto.getAllocatedQuantity() != null) {
			this.setAllocatedQuantity(prescriptionCompoundEntityDto.getAllocatedQuantity());
		}

		if (prescriptionCompoundEntityDto.getIssuedQuantity() != null) {
			this.setIssuedQuantity(prescriptionCompoundEntityDto.getIssuedQuantity());
		}

		if (prescriptionCompoundEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(prescriptionCompoundEntityDto.getConsumptionMethod());
		}

		if (prescriptionCompoundEntityDto.getInstruction() != null) {
			this.setInstruction(prescriptionCompoundEntityDto.getInstruction());
		}

		if (prescriptionCompoundEntityDto.getNotes() != null) {
			this.setNotes(prescriptionCompoundEntityDto.getNotes());
		}

		if (prescriptionCompoundEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(prescriptionCompoundEntityDto.getTotalPrice());
		}

		if (prescriptionCompoundEntityDto.getExternalCompoundName() != null) {
			this.setExternalCompoundName(prescriptionCompoundEntityDto.getExternalCompoundName());
		}

		if (prescriptionCompoundEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(prescriptionCompoundEntityDto.getApprovalStatus());
		}

		if (prescriptionCompoundEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(prescriptionCompoundEntityDto.getInventoryRoundingValue());
		}

		if (prescriptionCompoundEntityDto.getCompoundItems() != null) {
			this.setCompoundItems(prescriptionCompoundEntityDto.getCompoundItems());
		}

		if (prescriptionCompoundEntityDto.getUnit() != null) {
			this.setUnit(prescriptionCompoundEntityDto.getUnit());
		}

		if (prescriptionCompoundEntityDto.getPrescriptionHeader() != null) {
			this.setPrescriptionHeader(prescriptionCompoundEntityDto.getPrescriptionHeader());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@CsvBindByName(column = "IS_DTD", required = false)
	@Nullable
	@Column(name = "is_dtd")
	@Schema(description = "The Is dtd of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd = false ;

	// % protected region % [Modify attribute annotation for Requested Quantity here] off begin
	@CsvBindByName(column = "REQUESTED_QUANTITY", required = false)
	@Nullable
	@Column(name = "requested_quantity")
	@Schema(description = "The Requested Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Requested Quantity here] end
	private Double requestedQuantity;

	// % protected region % [Modify attribute annotation for Allocated Quantity here] off begin
	@CsvBindByName(column = "ALLOCATED_QUANTITY", required = false)
	@Nullable
	@Column(name = "allocated_quantity")
	@Schema(description = "The Allocated Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Allocated Quantity here] end
	private Double allocatedQuantity;

	// % protected region % [Modify attribute annotation for Issued Quantity here] off begin
	@CsvBindByName(column = "ISSUED_QUANTITY", required = false)
	@Nullable
	@Column(name = "issued_quantity")
	@Schema(description = "The Issued Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Issued Quantity here] end
	private Double issuedQuantity;

	// % protected region % [Modify attribute annotation for Consumption Method here] off begin
	@CsvBindByName(column = "CONSUMPTION_METHOD", required = false)
	@Nullable
	@Column(name = "consumption_method")
	@Schema(description = "The Consumption Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consumption Method here] end
	private String consumptionMethod;

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

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@CsvBindByName(column = "TOTAL_PRICE", required = false)
	@Nullable
	@Column(name = "total_price")
	@Schema(description = "The Total Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for External Compound Name here] off begin
	@CsvBindByName(column = "EXTERNAL_COMPOUND_NAME", required = false)
	@Nullable
	@Column(name = "external_compound_name")
	@Schema(description = "The External Compound Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Compound Name here] end
	private String externalCompoundName;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING_VALUE", required = false)
	@Nullable
	@Column(name = "inventory_rounding_value")
	@Schema(description = "The Inventory Rounding Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Compound Items here] off begin
	@Schema(description = "The Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "compound", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Items here] end
	private Set<PrescriptionItemEntity> compoundItems = new HashSet<>();

	// % protected region % [Update the annotation for compoundItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundItemsIds here] end
	private Set<UUID> compoundItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Unit here] off begin
	@Schema(description = "The Unit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Unit here] end
	private UnitOfMeasurementEntity unit;

	// % protected region % [Update the annotation for unitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "UNIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for unitId here] end
	private UUID unitId;

	// % protected region % [Update the annotation for Prescription Header here] off begin
	@Schema(description = "The Prescription Header entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Header here] end
	private PrescriptionHeaderEntity prescriptionHeader;

	// % protected region % [Update the annotation for prescriptionHeaderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_HEADER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for prescriptionHeaderId here] end
	private UUID prescriptionHeaderId;

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
	public void addCompoundItems(@NotNull PrescriptionItemEntity entity) {
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
	public void addCompoundItems(@NotNull Collection<PrescriptionItemEntity> entities) {
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
	public void removeCompoundItems(@NotNull PrescriptionItemEntity entity) {
		this.removeCompoundItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundItems(@NotNull PrescriptionItemEntity entity, boolean reverse) {
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
	public void removeCompoundItems(@NotNull Collection<PrescriptionItemEntity> entities) {
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
	public void setCompoundItems(@NotNull Collection<PrescriptionItemEntity> entities) {
		setCompoundItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundItems(@NotNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

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
	public void setUnit(@NotNull UnitOfMeasurementEntity entity) {
		setUnit(entity, true);
	}

	/**
	 * Set or update the unit in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to unit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnit(@NotNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
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
	public void setPrescriptionHeader(@NotNull PrescriptionHeaderEntity entity) {
		setPrescriptionHeader(entity, true);
	}

	/**
	 * Set or update the prescriptionHeader in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescriptionHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescriptionHeader(@NotNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "ITERATION_START,ITERATION_END,COMPOUND_CODE,COMPOUND_NAME,DOSAGE_TIMES,DOSAGE_DAYS,FREQUENCY,IS_DTD,REQUESTED_QUANTITY,ALLOCATED_QUANTITY,ISSUED_QUANTITY,CONSUMPTION_METHOD,INSTRUCTION,NOTES,TOTAL_PRICE,EXTERNAL_COMPOUND_NAME,APPROVAL_STATUS,INVENTORY_ROUNDING_VALUE,UNIT_ID,PRESCRIPTION_HEADER_ID,COMPOUND_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<UnitOfMeasurementEntity> unitRelation = Optional.ofNullable(this.unit);
		unitRelation.ifPresent(entity -> this.unitId = entity.getId());

		Optional<PrescriptionHeaderEntity> prescriptionHeaderRelation = Optional.ofNullable(this.prescriptionHeader);
		prescriptionHeaderRelation.ifPresent(entity -> this.prescriptionHeaderId = entity.getId());

		this.compoundItemsIds = new HashSet<>();
		for (PrescriptionItemEntity compoundItems: this.compoundItems) {
			this.compoundItemsIds.add(compoundItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object prescriptionCompound) {
		if (this == prescriptionCompound) {
			return true;
		}
		if (prescriptionCompound == null || this.getClass() != prescriptionCompound.getClass()) {
			return false;
		}
		if (!super.equals(prescriptionCompound)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PrescriptionCompoundEntity that = (PrescriptionCompoundEntity) prescriptionCompound;
		return
			Objects.equals(this.iterationStart, that.iterationStart) &&
			Objects.equals(this.iterationEnd, that.iterationEnd) &&
			Objects.equals(this.compoundCode, that.compoundCode) &&
			Objects.equals(this.compoundName, that.compoundName) &&
			Objects.equals(this.dosageTimes, that.dosageTimes) &&
			Objects.equals(this.dosageDays, that.dosageDays) &&
			Objects.equals(this.frequency, that.frequency) &&
			Objects.equals(this.isDtd, that.isDtd) &&
			Objects.equals(this.requestedQuantity, that.requestedQuantity) &&
			Objects.equals(this.allocatedQuantity, that.allocatedQuantity) &&
			Objects.equals(this.issuedQuantity, that.issuedQuantity) &&
			Objects.equals(this.consumptionMethod, that.consumptionMethod) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.externalCompoundName, that.externalCompoundName) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.compoundItemsIds, that.compoundItemsIds) &&
			Objects.equals(this.unitId, that.unitId) &&
			Objects.equals(this.prescriptionHeaderId, that.prescriptionHeaderId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
