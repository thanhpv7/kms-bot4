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
import kmsweb.dtos.MedicationItemEntityDto;
import kmsweb.entities.listeners.MedicationItemEntityListener;
import kmsweb.serializers.MedicationItemSerializer;
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
@EntityListeners({MedicationItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicationItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicationItemEntity extends AbstractEntity {

	/**
	 * Takes a MedicationItemEntityDto and converts it into a MedicationItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicationItemEntityDto
	 */
	public MedicationItemEntity(MedicationItemEntityDto medicationItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicationItemEntityDto.getId() != null) {
			this.setId(medicationItemEntityDto.getId());
		}

		if (medicationItemEntityDto.getRequestedQty() != null) {
			this.setRequestedQty(medicationItemEntityDto.getRequestedQty());
		}

		if (medicationItemEntityDto.getOutstandingQty() != null) {
			this.setOutstandingQty(medicationItemEntityDto.getOutstandingQty());
		}

		if (medicationItemEntityDto.getReturnedQty() != null) {
			this.setReturnedQty(medicationItemEntityDto.getReturnedQty());
		}

		if (medicationItemEntityDto.getIssuedQty() != null) {
			this.setIssuedQty(medicationItemEntityDto.getIssuedQty());
		}

		if (medicationItemEntityDto.getAdministeredQty() != null) {
			this.setAdministeredQty(medicationItemEntityDto.getAdministeredQty());
		}

		if (medicationItemEntityDto.getTakenHomeQty() != null) {
			this.setTakenHomeQty(medicationItemEntityDto.getTakenHomeQty());
		}

		if (medicationItemEntityDto.getDosageFrequency() != null) {
			this.setDosageFrequency(medicationItemEntityDto.getDosageFrequency());
		}

		if (medicationItemEntityDto.getDosageQty() != null) {
			this.setDosageQty(medicationItemEntityDto.getDosageQty());
		}

		if (medicationItemEntityDto.getDose() != null) {
			this.setDose(medicationItemEntityDto.getDose());
		}

		if (medicationItemEntityDto.getFrequency() != null) {
			this.setFrequency(medicationItemEntityDto.getFrequency());
		}

		if (medicationItemEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(medicationItemEntityDto.getConsumptionMethod());
		}

		if (medicationItemEntityDto.getInstruction() != null) {
			this.setInstruction(medicationItemEntityDto.getInstruction());
		}

		if (medicationItemEntityDto.getNotes() != null) {
			this.setNotes(medicationItemEntityDto.getNotes());
		}

		if (medicationItemEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(medicationItemEntityDto.getUnitPrice());
		}

		if (medicationItemEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(medicationItemEntityDto.getTotalPrice());
		}

		if (medicationItemEntityDto.getIsDtd() != null) {
			this.setIsDtd(medicationItemEntityDto.getIsDtd());
		}

		if (medicationItemEntityDto.getTotalIssuedQuantity() != null) {
			this.setTotalIssuedQuantity(medicationItemEntityDto.getTotalIssuedQuantity());
		}

		if (medicationItemEntityDto.getTotalAdministeredQuantity() != null) {
			this.setTotalAdministeredQuantity(medicationItemEntityDto.getTotalAdministeredQuantity());
		}

		if (medicationItemEntityDto.getTotalTakenHomeQuantity() != null) {
			this.setTotalTakenHomeQuantity(medicationItemEntityDto.getTotalTakenHomeQuantity());
		}

		if (medicationItemEntityDto.getTotalReturnedQuantity() != null) {
			this.setTotalReturnedQuantity(medicationItemEntityDto.getTotalReturnedQuantity());
		}

		if (medicationItemEntityDto.getExternalMedicationName() != null) {
			this.setExternalMedicationName(medicationItemEntityDto.getExternalMedicationName());
		}

		if (medicationItemEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(medicationItemEntityDto.getApprovalStatus());
		}

		if (medicationItemEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(medicationItemEntityDto.getInventoryRoundingValue());
		}

		if (medicationItemEntityDto.getDtdQuantity() != null) {
			this.setDtdQuantity(medicationItemEntityDto.getDtdQuantity());
		}

		if (medicationItemEntityDto.getMedicationAdministeredHisotries() != null) {
			this.setMedicationAdministeredHisotries(medicationItemEntityDto.getMedicationAdministeredHisotries());
		}

		if (medicationItemEntityDto.getMedicationCompound() != null) {
			this.setMedicationCompound(medicationItemEntityDto.getMedicationCompound());
		}

		if (medicationItemEntityDto.getMedicationHeader() != null) {
			this.setMedicationHeader(medicationItemEntityDto.getMedicationHeader());
		}

		if (medicationItemEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(medicationItemEntityDto.getStockCatalogue());
		}

		if (medicationItemEntityDto.getUnitOfMeasurement() != null) {
			this.setUnitOfMeasurement(medicationItemEntityDto.getUnitOfMeasurement());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Requested Qty here] off begin
	@CsvBindByName(column = "REQUESTED_QTY", required = false)
	@Nullable
	@Column(name = "requested_qty")
	@Schema(description = "The Requested Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Requested Qty here] end
	private Double requestedQty;

	// % protected region % [Modify attribute annotation for Outstanding Qty here] off begin
	@CsvBindByName(column = "OUTSTANDING_QTY", required = false)
	@Nullable
	@Column(name = "outstanding_qty")
	@Schema(description = "The Outstanding Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outstanding Qty here] end
	private Double outstandingQty;

	// % protected region % [Modify attribute annotation for Returned Qty here] off begin
	@CsvBindByName(column = "RETURNED_QTY", required = false)
	@Nullable
	@Column(name = "returned_qty")
	@Schema(description = "The Returned Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Returned Qty here] end
	private Double returnedQty;

	// % protected region % [Modify attribute annotation for Issued Qty here] off begin
	@CsvBindByName(column = "ISSUED_QTY", required = false)
	@Nullable
	@Column(name = "issued_qty")
	@Schema(description = "The Issued Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Issued Qty here] end
	private Double issuedQty;

	// % protected region % [Modify attribute annotation for Administered Qty here] off begin
	@CsvBindByName(column = "ADMINISTERED_QTY", required = false)
	@Nullable
	@Column(name = "administered_qty")
	@Schema(description = "The Administered Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Administered Qty here] end
	private Double administeredQty;

	// % protected region % [Modify attribute annotation for Taken Home Qty here] off begin
	@CsvBindByName(column = "TAKEN_HOME_QTY", required = false)
	@Nullable
	@Column(name = "taken_home_qty")
	@Schema(description = "The Taken Home Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Taken Home Qty here] end
	private Double takenHomeQty;

	// % protected region % [Modify attribute annotation for Dosage Frequency here] off begin
	@CsvBindByName(column = "DOSAGE_FREQUENCY", required = false)
	@Nullable
	@Column(name = "dosage_frequency")
	@Schema(description = "The Dosage Frequency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dosage Frequency here] end
	private Double dosageFrequency;

	// % protected region % [Modify attribute annotation for Dosage Qty here] off begin
	@CsvBindByName(column = "DOSAGE_QTY", required = false)
	@Nullable
	@Column(name = "dosage_qty")
	@Schema(description = "The Dosage Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dosage Qty here] end
	private Double dosageQty;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@CsvBindByName(column = "DOSE", required = false)
	@Nullable
	@Column(name = "dose")
	@Schema(description = "The Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dose here] end
	private Double dose;

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

	// % protected region % [Modify attribute annotation for Total Issued Quantity here] off begin
	@CsvBindByName(column = "TOTAL_ISSUED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_issued_quantity")
	@Schema(description = "The Total Issued Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Issued Quantity here] end
	private Double totalIssuedQuantity;

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@CsvBindByName(column = "TOTAL_ADMINISTERED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_administered_quantity")
	@Schema(description = "The Total Administered Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

	// % protected region % [Modify attribute annotation for Total Taken Home Quantity here] off begin
	@CsvBindByName(column = "TOTAL_TAKEN_HOME_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_taken_home_quantity")
	@Schema(description = "The Total Taken Home Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Taken Home Quantity here] end
	private Integer totalTakenHomeQuantity;

	// % protected region % [Modify attribute annotation for Total Returned Quantity here] off begin
	@CsvBindByName(column = "TOTAL_RETURNED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_returned_quantity")
	@Schema(description = "The Total Returned Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Returned Quantity here] end
	private Integer totalReturnedQuantity;

	// % protected region % [Modify attribute annotation for External Medication Name here] off begin
	@CsvBindByName(column = "EXTERNAL_MEDICATION_NAME", required = false)
	@Nullable
	@Column(name = "external_medication_name")
	@Schema(description = "The External Medication Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Medication Name here] end
	private String externalMedicationName;

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

	// % protected region % [Update the annotation for Medication Administered Hisotries here] off begin
	@Schema(description = "The Medication Administered History entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Administered Hisotries here] end
	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();

	// % protected region % [Update the annotation for medicationAdministeredHisotriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ADMINISTERED_HISOTRIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationAdministeredHisotriesIds here] end
	private Set<UUID> medicationAdministeredHisotriesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medication Compound here] off begin
	@Schema(description = "The Medication Compound entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Compound here] end
	private MedicationCompoundEntity medicationCompound;

	// % protected region % [Update the annotation for medicationCompoundId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_COMPOUND_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationCompoundId here] end
	private UUID medicationCompoundId;

	// % protected region % [Update the annotation for Medication Header here] off begin
	@Schema(description = "The Medication Header entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Header here] end
	private MedicationHeaderEntity medicationHeader;

	// % protected region % [Update the annotation for medicationHeaderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_HEADER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationHeaderId here] end
	private UUID medicationHeaderId;

	// % protected region % [Update the annotation for Stock Catalogue here] off begin
	@Schema(description = "The Stock Catalogue entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue here] end
	private StockCatalogueEntity stockCatalogue;

	// % protected region % [Update the annotation for stockCatalogueId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueId here] end
	private UUID stockCatalogueId;

	// % protected region % [Update the annotation for Unit Of Measurement here] off begin
	@Schema(description = "The Unit Of Measurement entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Unit Of Measurement here] end
	private UnitOfMeasurementEntity unitOfMeasurement;

	// % protected region % [Update the annotation for unitOfMeasurementId here] off begin
	@Transient
	@CsvCustomBindByName(column = "UNIT_OF_MEASUREMENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for unitOfMeasurementId here] end
	private UUID unitOfMeasurementId;

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
	public void addMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity) {
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
	public void addMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
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
	public void removeMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHisotries(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHisotries(@NotNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
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
	public void removeMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
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
	public void setMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHisotries(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Hisotries with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHisotries(@NotNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

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
	public void setMedicationCompound(@NotNull MedicationCompoundEntity entity) {
		setMedicationCompound(entity, true);
	}

	/**
	 * Set or update the medicationCompound in this entity with single MedicationCompoundEntity.
	 *
	 * @param entity the given MedicationCompoundEntity to be set or updated to medicationCompound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationCompound(@NotNull MedicationCompoundEntity entity, boolean reverseAdd) {
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
	public void setMedicationHeader(@NotNull MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(@NotNull MedicationHeaderEntity entity, boolean reverseAdd) {
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
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
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
	public void setUnitOfMeasurement(@NotNull UnitOfMeasurementEntity entity) {
		setUnitOfMeasurement(entity, true);
	}

	/**
	 * Set or update the unitOfMeasurement in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to unitOfMeasurement
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnitOfMeasurement(@NotNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "REQUESTED_QTY,OUTSTANDING_QTY,RETURNED_QTY,ISSUED_QTY,ADMINISTERED_QTY,TAKEN_HOME_QTY,DOSAGE_FREQUENCY,DOSAGE_QTY,DOSE,FREQUENCY,CONSUMPTION_METHOD,INSTRUCTION,NOTES,UNIT_PRICE,TOTAL_PRICE,IS_DTD,TOTAL_ISSUED_QUANTITY,TOTAL_ADMINISTERED_QUANTITY,TOTAL_TAKEN_HOME_QUANTITY,TOTAL_RETURNED_QUANTITY,EXTERNAL_MEDICATION_NAME,APPROVAL_STATUS,INVENTORY_ROUNDING_VALUE,DTD_QUANTITY,MEDICATION_COMPOUND_ID,MEDICATION_HEADER_ID,STOCK_CATALOGUE_ID,UNIT_OF_MEASUREMENT_ID,MEDICATION_ADMINISTERED_HISOTRIES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicationCompoundEntity> medicationCompoundRelation = Optional.ofNullable(this.medicationCompound);
		medicationCompoundRelation.ifPresent(entity -> this.medicationCompoundId = entity.getId());

		Optional<MedicationHeaderEntity> medicationHeaderRelation = Optional.ofNullable(this.medicationHeader);
		medicationHeaderRelation.ifPresent(entity -> this.medicationHeaderId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<UnitOfMeasurementEntity> unitOfMeasurementRelation = Optional.ofNullable(this.unitOfMeasurement);
		unitOfMeasurementRelation.ifPresent(entity -> this.unitOfMeasurementId = entity.getId());

		this.medicationAdministeredHisotriesIds = new HashSet<>();
		for (MedicationAdministeredHistoryEntity medicationAdministeredHisotries: this.medicationAdministeredHisotries) {
			this.medicationAdministeredHisotriesIds.add(medicationAdministeredHisotries.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicationItem) {
		if (this == medicationItem) {
			return true;
		}
		if (medicationItem == null || this.getClass() != medicationItem.getClass()) {
			return false;
		}
		if (!super.equals(medicationItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicationItemEntity that = (MedicationItemEntity) medicationItem;
		return
			Objects.equals(this.requestedQty, that.requestedQty) &&
			Objects.equals(this.outstandingQty, that.outstandingQty) &&
			Objects.equals(this.returnedQty, that.returnedQty) &&
			Objects.equals(this.issuedQty, that.issuedQty) &&
			Objects.equals(this.administeredQty, that.administeredQty) &&
			Objects.equals(this.takenHomeQty, that.takenHomeQty) &&
			Objects.equals(this.dosageFrequency, that.dosageFrequency) &&
			Objects.equals(this.dosageQty, that.dosageQty) &&
			Objects.equals(this.dose, that.dose) &&
			Objects.equals(this.frequency, that.frequency) &&
			Objects.equals(this.consumptionMethod, that.consumptionMethod) &&
			Objects.equals(this.instruction, that.instruction) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.isDtd, that.isDtd) &&
			Objects.equals(this.totalIssuedQuantity, that.totalIssuedQuantity) &&
			Objects.equals(this.totalAdministeredQuantity, that.totalAdministeredQuantity) &&
			Objects.equals(this.totalTakenHomeQuantity, that.totalTakenHomeQuantity) &&
			Objects.equals(this.totalReturnedQuantity, that.totalReturnedQuantity) &&
			Objects.equals(this.externalMedicationName, that.externalMedicationName) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.dtdQuantity, that.dtdQuantity) &&
			Objects.equals(this.medicationAdministeredHisotriesIds, that.medicationAdministeredHisotriesIds) &&
			Objects.equals(this.medicationCompoundId, that.medicationCompoundId) &&
			Objects.equals(this.medicationHeaderId, that.medicationHeaderId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.unitOfMeasurementId, that.unitOfMeasurementId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
