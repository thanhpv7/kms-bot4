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
import kmsweb.dtos.InventoryAdjustmentEntityDto;
import kmsweb.entities.listeners.InventoryAdjustmentEntityListener;
import kmsweb.serializers.InventoryAdjustmentSerializer;
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
@EntityListeners({InventoryAdjustmentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InventoryAdjustmentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InventoryAdjustmentEntity extends AbstractEntity {

	/**
	 * Takes a InventoryAdjustmentEntityDto and converts it into a InventoryAdjustmentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inventoryAdjustmentEntityDto
	 */
	public InventoryAdjustmentEntity(InventoryAdjustmentEntityDto inventoryAdjustmentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inventoryAdjustmentEntityDto.getId() != null) {
			this.setId(inventoryAdjustmentEntityDto.getId());
		}

		if (inventoryAdjustmentEntityDto.getAdjustmentNumber() != null) {
			this.setAdjustmentNumber(inventoryAdjustmentEntityDto.getAdjustmentNumber());
		}

		if (inventoryAdjustmentEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(inventoryAdjustmentEntityDto.getApprovalStatus());
		}

		if (inventoryAdjustmentEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(inventoryAdjustmentEntityDto.getTransactionDate());
		}

		if (inventoryAdjustmentEntityDto.getTransactionType() != null) {
			this.setTransactionType(inventoryAdjustmentEntityDto.getTransactionType());
		}

		if (inventoryAdjustmentEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(inventoryAdjustmentEntityDto.getReferenceNumber());
		}

		if (inventoryAdjustmentEntityDto.getNotes() != null) {
			this.setNotes(inventoryAdjustmentEntityDto.getNotes());
		}

		if (inventoryAdjustmentEntityDto.getVoidDate() != null) {
			this.setVoidDate(inventoryAdjustmentEntityDto.getVoidDate());
		}

		if (inventoryAdjustmentEntityDto.getVoidReason() != null) {
			this.setVoidReason(inventoryAdjustmentEntityDto.getVoidReason());
		}

		if (inventoryAdjustmentEntityDto.getAdjustmentType() != null) {
			this.setAdjustmentType(inventoryAdjustmentEntityDto.getAdjustmentType());
		}

		if (inventoryAdjustmentEntityDto.getInventoryAdjustmentItems() != null) {
			this.setInventoryAdjustmentItems(inventoryAdjustmentEntityDto.getInventoryAdjustmentItems());
		}

		if (inventoryAdjustmentEntityDto.getTransactionDetailType() != null) {
			this.setTransactionDetailType(inventoryAdjustmentEntityDto.getTransactionDetailType());
		}

		if (inventoryAdjustmentEntityDto.getWarehouse() != null) {
			this.setWarehouse(inventoryAdjustmentEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Adjustment Number here] off begin
	@CsvBindByName(column = "ADJUSTMENT_NUMBER", required = false)
	@Nullable
	@Column(name = "adjustment_number")
	@Schema(description = "The Adjustment Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Adjustment Number here] end
	private String adjustmentNumber;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@CsvBindByName(column = "TRANSACTION_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_type")
	@Schema(description = "The Transaction Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

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

	// % protected region % [Modify attribute annotation for Adjustment Type here] off begin
	@CsvBindByName(column = "ADJUSTMENT_TYPE", required = false)
	@Nullable
	@Column(name = "adjustment_type")
	@Schema(description = "The Adjustment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Adjustment Type here] end
	private String adjustmentType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Inventory Adjustment Items here] off begin
	@Schema(description = "The Inventory Adjustment Item entities that are related to this entity.")
	@OneToMany(mappedBy = "inventoryAdjustment", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjustment Items here] end
	private Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();

	// % protected region % [Update the annotation for inventoryAdjustmentItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSTMENT_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryAdjustmentItemsIds here] end
	private Set<UUID> inventoryAdjustmentItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Transaction Detail Type here] off begin
	@Schema(description = "The Transaction Detail Type entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transaction Detail Type here] end
	private TransactionDetailTypeEntity transactionDetailType;

	// % protected region % [Update the annotation for transactionDetailTypeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSACTION_DETAIL_TYPE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for transactionDetailTypeId here] end
	private UUID transactionDetailTypeId;

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
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
	 * Similar to {@link this#addInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity) {
		addInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentItemEntity to inventoryAdjustmentItems in this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustmentItems.contains(entity)) {
			inventoryAdjustmentItems.add(entity);
			if (reverseAdd) {
				entity.setInventoryAdjustment(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		addInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentItemEntity to Inventory Adjustment Items in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity) {
		this.removeInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentItemEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryAdjustment(false);
		}
		this.inventoryAdjustmentItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		this.removeInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void setInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		setInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustment Items with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustmentItems();
		this.inventoryAdjustmentItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.setInventoryAdjustment(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustmentItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustmentItems() {
		this.unsetInventoryAdjustmentItems(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustment Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustmentItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.unsetInventoryAdjustment(false));
		}
		this.inventoryAdjustmentItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setTransactionDetailType(TransactionDetailTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set to this entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity) {
		setTransactionDetailType(entity, true);
	}

	/**
	 * Set or update the transactionDetailType in this entity with single TransactionDetailTypeEntity.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set or updated to transactionDetailType
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] end

		if (sameAsFormer(this.transactionDetailType, entity)) {
			return;
		}

		if (this.transactionDetailType != null) {
			this.transactionDetailType.removeInventoryAdjustments(this, false);
		}
		this.transactionDetailType = entity;
		if (reverseAdd) {
			this.transactionDetailType.addInventoryAdjustments(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailType(boolean)} but default to true.
	 */
	public void unsetTransactionDetailType() {
		this.unsetTransactionDetailType(true);
	}

	/**
	 * Remove Transaction Detail Type in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransactionDetailType(boolean reverse) {
		if (reverse && this.transactionDetailType != null) {
			this.transactionDetailType.removeInventoryAdjustments(this, false);
		}
		this.transactionDetailType = null;
	}
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
			this.warehouse.removeInventoryAdjustments(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInventoryAdjustments(this, false);
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
			this.warehouse.removeInventoryAdjustments(this, false);
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
		return "ADJUSTMENT_NUMBER,APPROVAL_STATUS,TRANSACTION_DATE,TRANSACTION_TYPE,REFERENCE_NUMBER,NOTES,VOID_DATE,VOID_REASON,ADJUSTMENT_TYPE,TRANSACTION_DETAIL_TYPE_ID,WAREHOUSE_ID,INVENTORY_ADJUSTMENT_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<TransactionDetailTypeEntity> transactionDetailTypeRelation = Optional.ofNullable(this.transactionDetailType);
		transactionDetailTypeRelation.ifPresent(entity -> this.transactionDetailTypeId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.inventoryAdjustmentItemsIds = new HashSet<>();
		for (InventoryAdjustmentItemEntity inventoryAdjustmentItems: this.inventoryAdjustmentItems) {
			this.inventoryAdjustmentItemsIds.add(inventoryAdjustmentItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inventoryAdjustment) {
		if (this == inventoryAdjustment) {
			return true;
		}
		if (inventoryAdjustment == null || this.getClass() != inventoryAdjustment.getClass()) {
			return false;
		}
		if (!super.equals(inventoryAdjustment)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InventoryAdjustmentEntity that = (InventoryAdjustmentEntity) inventoryAdjustment;
		return
			Objects.equals(this.adjustmentNumber, that.adjustmentNumber) &&
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
			Objects.equals(this.adjustmentType, that.adjustmentType) &&
			Objects.equals(this.inventoryAdjustmentItemsIds, that.inventoryAdjustmentItemsIds) &&
			Objects.equals(this.transactionDetailTypeId, that.transactionDetailTypeId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
