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
import kmsweb.dtos.PrescriptionItemEntityDto;
import kmsweb.entities.listeners.PrescriptionItemEntityListener;
import kmsweb.serializers.PrescriptionItemSerializer;
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
@EntityListeners({PrescriptionItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PrescriptionItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PrescriptionItemEntity extends AbstractEntity {

	/**
	 * Takes a PrescriptionItemEntityDto and converts it into a PrescriptionItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param prescriptionItemEntityDto
	 */
	public PrescriptionItemEntity(PrescriptionItemEntityDto prescriptionItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (prescriptionItemEntityDto.getId() != null) {
			this.setId(prescriptionItemEntityDto.getId());
		}

		if (prescriptionItemEntityDto.getIterationStart() != null) {
			this.setIterationStart(prescriptionItemEntityDto.getIterationStart());
		}

		if (prescriptionItemEntityDto.getIterationEnd() != null) {
			this.setIterationEnd(prescriptionItemEntityDto.getIterationEnd());
		}

		if (prescriptionItemEntityDto.getRequestedQuantity() != null) {
			this.setRequestedQuantity(prescriptionItemEntityDto.getRequestedQuantity());
		}

		if (prescriptionItemEntityDto.getAllocatedQuantity() != null) {
			this.setAllocatedQuantity(prescriptionItemEntityDto.getAllocatedQuantity());
		}

		if (prescriptionItemEntityDto.getIssuedQuantity() != null) {
			this.setIssuedQuantity(prescriptionItemEntityDto.getIssuedQuantity());
		}

		if (prescriptionItemEntityDto.getFrequency() != null) {
			this.setFrequency(prescriptionItemEntityDto.getFrequency());
		}

		if (prescriptionItemEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(prescriptionItemEntityDto.getConsumptionMethod());
		}

		if (prescriptionItemEntityDto.getInstruction() != null) {
			this.setInstruction(prescriptionItemEntityDto.getInstruction());
		}

		if (prescriptionItemEntityDto.getDosageTimes() != null) {
			this.setDosageTimes(prescriptionItemEntityDto.getDosageTimes());
		}

		if (prescriptionItemEntityDto.getDosageDays() != null) {
			this.setDosageDays(prescriptionItemEntityDto.getDosageDays());
		}

		if (prescriptionItemEntityDto.getNotes() != null) {
			this.setNotes(prescriptionItemEntityDto.getNotes());
		}

		if (prescriptionItemEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(prescriptionItemEntityDto.getUnitPrice());
		}

		if (prescriptionItemEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(prescriptionItemEntityDto.getTotalPrice());
		}

		if (prescriptionItemEntityDto.getIsDtd() != null) {
			this.setIsDtd(prescriptionItemEntityDto.getIsDtd());
		}

		if (prescriptionItemEntityDto.getDose() != null) {
			this.setDose(prescriptionItemEntityDto.getDose());
		}

		if (prescriptionItemEntityDto.getExternalStockName() != null) {
			this.setExternalStockName(prescriptionItemEntityDto.getExternalStockName());
		}

		if (prescriptionItemEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(prescriptionItemEntityDto.getApprovalStatus());
		}

		if (prescriptionItemEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(prescriptionItemEntityDto.getInventoryRoundingValue());
		}

		if (prescriptionItemEntityDto.getDtdQuantity() != null) {
			this.setDtdQuantity(prescriptionItemEntityDto.getDtdQuantity());
		}

		if (prescriptionItemEntityDto.getCompound() != null) {
			this.setCompound(prescriptionItemEntityDto.getCompound());
		}

		if (prescriptionItemEntityDto.getStockCatalogueId() != null) {
			this.setStockCatalogueId(prescriptionItemEntityDto.getStockCatalogueId());
		}

		if (prescriptionItemEntityDto.getPrescription() != null) {
			this.setPrescription(prescriptionItemEntityDto.getPrescription());
		}

		if (prescriptionItemEntityDto.getUnit() != null) {
			this.setUnit(prescriptionItemEntityDto.getUnit());
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

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@CsvBindByName(column = "INSTRUCTION", required = false)
	@Nullable
	@Column(name = "instruction")
	@Schema(description = "The Instruction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

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

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@CsvBindByName(column = "TOTAL_PRICE", required = false)
	@Nullable
	@Column(name = "total_price")
	@Schema(description = "The Total Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for Is dtd here] off begin
	@CsvBindByName(column = "IS_DTD", required = false)
	@Nullable
	@Column(name = "is_dtd")
	@Schema(description = "The Is dtd of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is dtd here] end
	private Boolean isDtd = false ;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@CsvBindByName(column = "DOSE", required = false)
	@Nullable
	@Column(name = "dose")
	@Schema(description = "The Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dose here] end
	private Integer dose;

	// % protected region % [Modify attribute annotation for External Stock Name here] off begin
	@CsvBindByName(column = "EXTERNAL_STOCK_NAME", required = false)
	@Nullable
	@Column(name = "external_stock_name")
	@Schema(description = "The External Stock Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Stock Name here] end
	private String externalStockName;

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

	// % protected region % [Modify attribute annotation for DTD Quantity here] off begin
	@CsvBindByName(column = "DTD_QUANTITY", required = false)
	@Nullable
	@Column(name = "dtd_quantity")
	@Schema(description = "The DTD Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DTD Quantity here] end
	private Double dtdQuantity;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Compound here] off begin
	@Schema(description = "The Compound entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound here] end
	private PrescriptionCompoundEntity compound;

	// % protected region % [Update the annotation for compoundId here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for compoundId here] end
	private UUID compoundId;

	// % protected region % [Update the annotation for Stock Catalogue Id here] off begin
	@Schema(description = "The Stock Catalogue Id entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue Id here] end
	private StockCatalogueEntity stockCatalogueId;

	// % protected region % [Update the annotation for stockCatalogueIdId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_ID_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueIdId here] end
	private UUID stockCatalogueIdId;

	// % protected region % [Update the annotation for Prescription here] off begin
	@Schema(description = "The Prescription entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription here] end
	private PrescriptionHeaderEntity prescription;

	// % protected region % [Update the annotation for prescriptionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for prescriptionId here] end
	private UUID prescriptionId;

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
	public void setCompound(@NotNull PrescriptionCompoundEntity entity) {
		setCompound(entity, true);
	}

	/**
	 * Set or update the compound in this entity with single PrescriptionCompoundEntity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be set or updated to compound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCompound(@NotNull PrescriptionCompoundEntity entity, boolean reverseAdd) {
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
	public void setStockCatalogueId(@NotNull StockCatalogueEntity entity) {
		setStockCatalogueId(entity, true);
	}

	/**
	 * Set or update the stockCatalogueId in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogueId
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueId(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
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
	public void setPrescription(@NotNull PrescriptionHeaderEntity entity) {
		setPrescription(entity, true);
	}

	/**
	 * Set or update the prescription in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescription
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescription(@NotNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "ITERATION_START,ITERATION_END,REQUESTED_QUANTITY,ALLOCATED_QUANTITY,ISSUED_QUANTITY,FREQUENCY,CONSUMPTION_METHOD,INSTRUCTION,DOSAGE_TIMES,DOSAGE_DAYS,NOTES,UNIT_PRICE,TOTAL_PRICE,IS_DTD,DOSE,EXTERNAL_STOCK_NAME,APPROVAL_STATUS,INVENTORY_ROUNDING_VALUE,DTD_QUANTITY,COMPOUND_ID,STOCK_CATALOGUE_ID_ID,PRESCRIPTION_ID,UNIT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PrescriptionCompoundEntity> compoundRelation = Optional.ofNullable(this.compound);
		compoundRelation.ifPresent(entity -> this.compoundId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueIdRelation = Optional.ofNullable(this.stockCatalogueId);
		stockCatalogueIdRelation.ifPresent(entity -> this.stockCatalogueIdId = entity.getId());

		Optional<PrescriptionHeaderEntity> prescriptionRelation = Optional.ofNullable(this.prescription);
		prescriptionRelation.ifPresent(entity -> this.prescriptionId = entity.getId());

		Optional<UnitOfMeasurementEntity> unitRelation = Optional.ofNullable(this.unit);
		unitRelation.ifPresent(entity -> this.unitId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object prescriptionItem) {
		if (this == prescriptionItem) {
			return true;
		}
		if (prescriptionItem == null || this.getClass() != prescriptionItem.getClass()) {
			return false;
		}
		if (!super.equals(prescriptionItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PrescriptionItemEntity that = (PrescriptionItemEntity) prescriptionItem;
		return
			Objects.equals(this.iterationStart, that.iterationStart) &&
			Objects.equals(this.iterationEnd, that.iterationEnd) &&
			Objects.equals(this.requestedQuantity, that.requestedQuantity) &&
			Objects.equals(this.allocatedQuantity, that.allocatedQuantity) &&
			Objects.equals(this.issuedQuantity, that.issuedQuantity) &&
			Objects.equals(this.frequency, that.frequency) &&
			Objects.equals(this.consumptionMethod, that.consumptionMethod) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(this.dosageTimes, that.dosageTimes) &&
			Objects.equals(this.dosageDays, that.dosageDays) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.isDtd, that.isDtd) &&
			Objects.equals(this.dose, that.dose) &&
			Objects.equals(this.externalStockName, that.externalStockName) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.dtdQuantity, that.dtdQuantity) &&
			Objects.equals(this.compoundId, that.compoundId) &&
			Objects.equals(this.stockCatalogueIdId, that.stockCatalogueIdId) &&
			Objects.equals(this.prescriptionId, that.prescriptionId) &&
			Objects.equals(this.unitId, that.unitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
