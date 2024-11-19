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
import kmsweb.dtos.InventoryBatchCorrectionEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.InventoryBatchCorrectionEntityListener;
import kmsweb.serializers.InventoryBatchCorrectionSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({InventoryBatchCorrectionEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InventoryBatchCorrectionSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"batch_correction_number"}, name = "batch_correction_number"),
	}
)
public class InventoryBatchCorrectionEntity extends AbstractEntity {

	/**
	 * Takes a InventoryBatchCorrectionEntityDto and converts it into a InventoryBatchCorrectionEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inventoryBatchCorrectionEntityDto
	 */
	public InventoryBatchCorrectionEntity(InventoryBatchCorrectionEntityDto inventoryBatchCorrectionEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inventoryBatchCorrectionEntityDto.getId() != null) {
			this.setId(inventoryBatchCorrectionEntityDto.getId());
		}

		if (inventoryBatchCorrectionEntityDto.getBatchCorrectionNumber() != null) {
			this.setBatchCorrectionNumber(inventoryBatchCorrectionEntityDto.getBatchCorrectionNumber());
		}

		if (inventoryBatchCorrectionEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(inventoryBatchCorrectionEntityDto.getApprovalStatus());
		}

		if (inventoryBatchCorrectionEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(inventoryBatchCorrectionEntityDto.getTransactionDate());
		}

		if (inventoryBatchCorrectionEntityDto.getTransactionType() != null) {
			this.setTransactionType(inventoryBatchCorrectionEntityDto.getTransactionType());
		}

		if (inventoryBatchCorrectionEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(inventoryBatchCorrectionEntityDto.getReferenceNumber());
		}

		if (inventoryBatchCorrectionEntityDto.getNotes() != null) {
			this.setNotes(inventoryBatchCorrectionEntityDto.getNotes());
		}

		if (inventoryBatchCorrectionEntityDto.getVoidDate() != null) {
			this.setVoidDate(inventoryBatchCorrectionEntityDto.getVoidDate());
		}

		if (inventoryBatchCorrectionEntityDto.getVoidReason() != null) {
			this.setVoidReason(inventoryBatchCorrectionEntityDto.getVoidReason());
		}

		if (inventoryBatchCorrectionEntityDto.getInventoryBatchCorrectionItems() != null) {
			this.setInventoryBatchCorrectionItems(inventoryBatchCorrectionEntityDto.getInventoryBatchCorrectionItems());
		}

		if (inventoryBatchCorrectionEntityDto.getWarehouse() != null) {
			this.setWarehouse(inventoryBatchCorrectionEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Batch Correction Number here] off begin
	@CsvBindByName(column = "BATCH_CORRECTION_NUMBER", required = false)
	@Nullable
	@Column(name = "batch_correction_number")
	@Schema(description = "The Batch Correction Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Correction Number here] end
	private String batchCorrectionNumber;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Transaction Date must not be empty")
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@CsvCustomBindByName(column = "TRANSACTION_TYPE", required = true, converter = BatchCorrectionTypeEnumConverter.class)
	@NotNull(message = "Transaction Type must not be empty")
	@Column(name = "transaction_type")
	@Schema(description = "The Transaction Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private BatchCorrectionTypeEnum transactionType;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@CsvBindByName(column = "REFERENCE_NUMBER", required = false)
	@Nullable
	@Column(name = "reference_number")
	@Schema(description = "The Reference Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Void Date here] off begin
	@CsvCustomBindByName(column = "VOID_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "void_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Void Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Void Date here] end
	private OffsetDateTime voidDate;

	// % protected region % [Modify attribute annotation for Void Reason here] off begin
	@CsvBindByName(column = "VOID_REASON", required = false)
	@Nullable
	@Column(name = "void_reason")
	@Schema(description = "The Void Reason of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Void Reason here] end
	private String voidReason;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Inventory Batch Correction Items here] off begin
	@Schema(description = "The Inventory Batch Correction Item entities that are related to this entity.")
	@OneToMany(mappedBy = "inventoryBatchCorrection", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Batch Correction Items here] end
	private Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();

	// % protected region % [Update the annotation for inventoryBatchCorrectionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_BATCH_CORRECTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryBatchCorrectionItemsIds here] end
	private Set<UUID> inventoryBatchCorrectionItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@NotNull(message = "Reference Warehouse is required")
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse here] end
	private WarehouseEntity warehouse;

	// % protected region % [Update the annotation for warehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseId here] end
	private UUID warehouseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity) {
		addInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Add a new InventoryBatchCorrectionItemEntity to inventoryBatchCorrectionItems in this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryBatchCorrectionItems.contains(entity)) {
			inventoryBatchCorrectionItems.add(entity);
			if (reverseAdd) {
				entity.setInventoryBatchCorrection(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		addInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryBatchCorrectionItemEntity to Inventory Batch Correction Items in this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity) {
		this.removeInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Remove the given InventoryBatchCorrectionItemEntity from this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryBatchCorrection(false);
		}
		this.inventoryBatchCorrectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		this.removeInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryBatchCorrectionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void setInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		setInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Batch Correction Items with the given ones.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryBatchCorrectionItems();
		this.inventoryBatchCorrectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.setInventoryBatchCorrection(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryBatchCorrectionItems() {
		this.unsetInventoryBatchCorrectionItems(true);
	}

	/**
	 * Remove all the entities in Inventory Batch Correction Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryBatchCorrectionItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.unsetInventoryBatchCorrection(false));
		}
		this.inventoryBatchCorrectionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeInventoryBatchCorrections(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInventoryBatchCorrections(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removeInventoryBatchCorrections(this, false);
		}
		this.warehouse = null;
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
		return "BATCH_CORRECTION_NUMBER,APPROVAL_STATUS,TRANSACTION_DATE,TRANSACTION_TYPE,REFERENCE_NUMBER,NOTES,VOID_DATE,VOID_REASON,WAREHOUSE_ID,INVENTORY_BATCH_CORRECTION_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.inventoryBatchCorrectionItemsIds = new HashSet<>();
		for (InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItems: this.inventoryBatchCorrectionItems) {
			this.inventoryBatchCorrectionItemsIds.add(inventoryBatchCorrectionItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inventoryBatchCorrection) {
		if (this == inventoryBatchCorrection) {
			return true;
		}
		if (inventoryBatchCorrection == null || this.getClass() != inventoryBatchCorrection.getClass()) {
			return false;
		}
		if (!super.equals(inventoryBatchCorrection)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InventoryBatchCorrectionEntity that = (InventoryBatchCorrectionEntity) inventoryBatchCorrection;
		return
			Objects.equals(this.batchCorrectionNumber, that.batchCorrectionNumber) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.transactionType, that.transactionType) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(
			     this.voidDate != null ? this.voidDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.voidDate != null ? that.voidDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.voidReason, that.voidReason) &&
			Objects.equals(this.inventoryBatchCorrectionItemsIds, that.inventoryBatchCorrectionItemsIds) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
