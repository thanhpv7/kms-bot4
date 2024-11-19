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
import kmsweb.dtos.MedicationCompoundEntityDto;
import kmsweb.entities.listeners.MedicationCompoundEntityListener;
import kmsweb.serializers.MedicationCompoundSerializer;
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
@EntityListeners({MedicationCompoundEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicationCompoundSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicationCompoundEntity extends AbstractEntity {

	/**
	 * Takes a MedicationCompoundEntityDto and converts it into a MedicationCompoundEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicationCompoundEntityDto
	 */
	public MedicationCompoundEntity(MedicationCompoundEntityDto medicationCompoundEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicationCompoundEntityDto.getId() != null) {
			this.setId(medicationCompoundEntityDto.getId());
		}

		if (medicationCompoundEntityDto.getCompoundCode() != null) {
			this.setCompoundCode(medicationCompoundEntityDto.getCompoundCode());
		}

		if (medicationCompoundEntityDto.getCompoundName() != null) {
			this.setCompoundName(medicationCompoundEntityDto.getCompoundName());
		}

		if (medicationCompoundEntityDto.getRequestedQty() != null) {
			this.setRequestedQty(medicationCompoundEntityDto.getRequestedQty());
		}

		if (medicationCompoundEntityDto.getOutstandingQty() != null) {
			this.setOutstandingQty(medicationCompoundEntityDto.getOutstandingQty());
		}

		if (medicationCompoundEntityDto.getReturnedQty() != null) {
			this.setReturnedQty(medicationCompoundEntityDto.getReturnedQty());
		}

		if (medicationCompoundEntityDto.getIssuedQty() != null) {
			this.setIssuedQty(medicationCompoundEntityDto.getIssuedQty());
		}

		if (medicationCompoundEntityDto.getAdministeredQty() != null) {
			this.setAdministeredQty(medicationCompoundEntityDto.getAdministeredQty());
		}

		if (medicationCompoundEntityDto.getTakenHomeQty() != null) {
			this.setTakenHomeQty(medicationCompoundEntityDto.getTakenHomeQty());
		}

		if (medicationCompoundEntityDto.getDosageFrequency() != null) {
			this.setDosageFrequency(medicationCompoundEntityDto.getDosageFrequency());
		}

		if (medicationCompoundEntityDto.getDosageQty() != null) {
			this.setDosageQty(medicationCompoundEntityDto.getDosageQty());
		}

		if (medicationCompoundEntityDto.getDose() != null) {
			this.setDose(medicationCompoundEntityDto.getDose());
		}

		if (medicationCompoundEntityDto.getFrequency() != null) {
			this.setFrequency(medicationCompoundEntityDto.getFrequency());
		}

		if (medicationCompoundEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(medicationCompoundEntityDto.getConsumptionMethod());
		}

		if (medicationCompoundEntityDto.getInstruction() != null) {
			this.setInstruction(medicationCompoundEntityDto.getInstruction());
		}

		if (medicationCompoundEntityDto.getNotes() != null) {
			this.setNotes(medicationCompoundEntityDto.getNotes());
		}

		if (medicationCompoundEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(medicationCompoundEntityDto.getTotalPrice());
		}

		if (medicationCompoundEntityDto.getIsDtd() != null) {
			this.setIsDtd(medicationCompoundEntityDto.getIsDtd());
		}

		if (medicationCompoundEntityDto.getTotalAdministeredQuantity() != null) {
			this.setTotalAdministeredQuantity(medicationCompoundEntityDto.getTotalAdministeredQuantity());
		}

		if (medicationCompoundEntityDto.getTotalIssuedQuantity() != null) {
			this.setTotalIssuedQuantity(medicationCompoundEntityDto.getTotalIssuedQuantity());
		}

		if (medicationCompoundEntityDto.getTotalTakenHomeQuantity() != null) {
			this.setTotalTakenHomeQuantity(medicationCompoundEntityDto.getTotalTakenHomeQuantity());
		}

		if (medicationCompoundEntityDto.getTotalReturnedQuantity() != null) {
			this.setTotalReturnedQuantity(medicationCompoundEntityDto.getTotalReturnedQuantity());
		}

		if (medicationCompoundEntityDto.getExternalCompoundName() != null) {
			this.setExternalCompoundName(medicationCompoundEntityDto.getExternalCompoundName());
		}

		if (medicationCompoundEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(medicationCompoundEntityDto.getApprovalStatus());
		}

		if (medicationCompoundEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(medicationCompoundEntityDto.getInventoryRoundingValue());
		}

		if (medicationCompoundEntityDto.getMedicationAdministeredHistories() != null) {
			this.setMedicationAdministeredHistories(medicationCompoundEntityDto.getMedicationAdministeredHistories());
		}

		if (medicationCompoundEntityDto.getMedicationItems() != null) {
			this.setMedicationItems(medicationCompoundEntityDto.getMedicationItems());
		}

		if (medicationCompoundEntityDto.getMedicationHeader() != null) {
			this.setMedicationHeader(medicationCompoundEntityDto.getMedicationHeader());
		}

		if (medicationCompoundEntityDto.getUnitOfMeasurement() != null) {
			this.setUnitOfMeasurement(medicationCompoundEntityDto.getUnitOfMeasurement());
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

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@CsvBindByName(column = "TOTAL_ADMINISTERED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_administered_quantity")
	@Schema(description = "The Total Administered Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

	// % protected region % [Modify attribute annotation for Total Issued Quantity here] off begin
	@CsvBindByName(column = "TOTAL_ISSUED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_issued_quantity")
	@Schema(description = "The Total Issued Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Issued Quantity here] end
	private Double totalIssuedQuantity;

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

	// % protected region % [Update the annotation for Medication Administered Histories here] off begin
	@Schema(description = "The Medication Administered History entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationCompound", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Administered Histories here] end
	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHistories = new HashSet<>();

	// % protected region % [Update the annotation for medicationAdministeredHistoriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ADMINISTERED_HISTORIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationAdministeredHistoriesIds here] end
	private Set<UUID> medicationAdministeredHistoriesIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Items here] off begin
	@Schema(description = "The Medication Item entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationCompound", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Items here] end
	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	// % protected region % [Update the annotation for medicationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationItemsIds here] end
	private Set<UUID> medicationItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addMedicationAdministeredHistories(MedicationAdministeredHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be added to this entity
	 */
	public void addMedicationAdministeredHistories(@NotNull MedicationAdministeredHistoryEntity entity) {
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
	public void addMedicationAdministeredHistories(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
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
	public void removeMedicationAdministeredHistories(@NotNull MedicationAdministeredHistoryEntity entity) {
		this.removeMedicationAdministeredHistories(entity, true);
	}

	/**
	 * Remove the given MedicationAdministeredHistoryEntity from this entity.
	 *
	 * @param entity the given MedicationAdministeredHistoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationAdministeredHistories(@NotNull MedicationAdministeredHistoryEntity entity, boolean reverse) {
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
	public void removeMedicationAdministeredHistories(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
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
	public void setMedicationAdministeredHistories(@NotNull Collection<MedicationAdministeredHistoryEntity> entities) {
		setMedicationAdministeredHistories(entities, true);
	}

	/**
	 * Replace the current entities in Medication Administered Histories with the given ones.
	 *
	 * @param entities the given collection of MedicationAdministeredHistoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationAdministeredHistories(@NotNull Collection<MedicationAdministeredHistoryEntity> entities, boolean reverseAdd) {

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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "COMPOUND_CODE,COMPOUND_NAME,REQUESTED_QTY,OUTSTANDING_QTY,RETURNED_QTY,ISSUED_QTY,ADMINISTERED_QTY,TAKEN_HOME_QTY,DOSAGE_FREQUENCY,DOSAGE_QTY,DOSE,FREQUENCY,CONSUMPTION_METHOD,INSTRUCTION,NOTES,TOTAL_PRICE,IS_DTD,TOTAL_ADMINISTERED_QUANTITY,TOTAL_ISSUED_QUANTITY,TOTAL_TAKEN_HOME_QUANTITY,TOTAL_RETURNED_QUANTITY,EXTERNAL_COMPOUND_NAME,APPROVAL_STATUS,INVENTORY_ROUNDING_VALUE,MEDICATION_HEADER_ID,UNIT_OF_MEASUREMENT_ID,MEDICATION_ADMINISTERED_HISTORIES_IDS,MEDICATION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicationHeaderEntity> medicationHeaderRelation = Optional.ofNullable(this.medicationHeader);
		medicationHeaderRelation.ifPresent(entity -> this.medicationHeaderId = entity.getId());

		Optional<UnitOfMeasurementEntity> unitOfMeasurementRelation = Optional.ofNullable(this.unitOfMeasurement);
		unitOfMeasurementRelation.ifPresent(entity -> this.unitOfMeasurementId = entity.getId());

		this.medicationAdministeredHistoriesIds = new HashSet<>();
		for (MedicationAdministeredHistoryEntity medicationAdministeredHistories: this.medicationAdministeredHistories) {
			this.medicationAdministeredHistoriesIds.add(medicationAdministeredHistories.getId());
		}

		this.medicationItemsIds = new HashSet<>();
		for (MedicationItemEntity medicationItems: this.medicationItems) {
			this.medicationItemsIds.add(medicationItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicationCompound) {
		if (this == medicationCompound) {
			return true;
		}
		if (medicationCompound == null || this.getClass() != medicationCompound.getClass()) {
			return false;
		}
		if (!super.equals(medicationCompound)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicationCompoundEntity that = (MedicationCompoundEntity) medicationCompound;
		return
			Objects.equals(this.compoundCode, that.compoundCode) &&
			Objects.equals(this.compoundName, that.compoundName) &&
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
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.isDtd, that.isDtd) &&
			Objects.equals(this.totalAdministeredQuantity, that.totalAdministeredQuantity) &&
			Objects.equals(this.totalIssuedQuantity, that.totalIssuedQuantity) &&
			Objects.equals(this.totalTakenHomeQuantity, that.totalTakenHomeQuantity) &&
			Objects.equals(this.totalReturnedQuantity, that.totalReturnedQuantity) &&
			Objects.equals(this.externalCompoundName, that.externalCompoundName) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.medicationAdministeredHistoriesIds, that.medicationAdministeredHistoriesIds) &&
			Objects.equals(this.medicationItemsIds, that.medicationItemsIds) &&
			Objects.equals(this.medicationHeaderId, that.medicationHeaderId) &&
			Objects.equals(this.unitOfMeasurementId, that.unitOfMeasurementId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
