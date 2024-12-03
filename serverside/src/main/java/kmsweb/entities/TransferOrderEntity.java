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
import kmsweb.dtos.TransferOrderEntityDto;
import kmsweb.entities.listeners.TransferOrderEntityListener;
import kmsweb.serializers.TransferOrderSerializer;
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
@EntityListeners({TransferOrderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TransferOrderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TransferOrderEntity extends AbstractEntity {

	/**
	 * Takes a TransferOrderEntityDto and converts it into a TransferOrderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param transferOrderEntityDto
	 */
	public TransferOrderEntity(TransferOrderEntityDto transferOrderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (transferOrderEntityDto.getId() != null) {
			this.setId(transferOrderEntityDto.getId());
		}

		if (transferOrderEntityDto.getTransferOrderNumber() != null) {
			this.setTransferOrderNumber(transferOrderEntityDto.getTransferOrderNumber());
		}

		if (transferOrderEntityDto.getTransactionStatus() != null) {
			this.setTransactionStatus(transferOrderEntityDto.getTransactionStatus());
		}

		if (transferOrderEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(transferOrderEntityDto.getApprovalStatus());
		}

		if (transferOrderEntityDto.getOrderDate() != null) {
			this.setOrderDate(transferOrderEntityDto.getOrderDate());
		}

		if (transferOrderEntityDto.getExpectedDate() != null) {
			this.setExpectedDate(transferOrderEntityDto.getExpectedDate());
		}

		if (transferOrderEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(transferOrderEntityDto.getReferenceNumber());
		}

		if (transferOrderEntityDto.getNotes() != null) {
			this.setNotes(transferOrderEntityDto.getNotes());
		}

		if (transferOrderEntityDto.getVoidDate() != null) {
			this.setVoidDate(transferOrderEntityDto.getVoidDate());
		}

		if (transferOrderEntityDto.getReferenceDocument() != null) {
			this.setReferenceDocument(transferOrderEntityDto.getReferenceDocument());
		}

		if (transferOrderEntityDto.getRequiredDate() != null) {
			this.setRequiredDate(transferOrderEntityDto.getRequiredDate());
		}

		if (transferOrderEntityDto.getIssuedDateTime() != null) {
			this.setIssuedDateTime(transferOrderEntityDto.getIssuedDateTime());
		}

		if (transferOrderEntityDto.getReceivedDateTime() != null) {
			this.setReceivedDateTime(transferOrderEntityDto.getReceivedDateTime());
		}

		if (transferOrderEntityDto.getTransferOrderStockDetails() != null) {
			this.setTransferOrderStockDetails(transferOrderEntityDto.getTransferOrderStockDetails());
		}

		if (transferOrderEntityDto.getDestinationWarehouse() != null) {
			this.setDestinationWarehouse(transferOrderEntityDto.getDestinationWarehouse());
		}

		if (transferOrderEntityDto.getSourceWarehouse() != null) {
			this.setSourceWarehouse(transferOrderEntityDto.getSourceWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transfer Order Number here] off begin
	@CsvBindByName(column = "TRANSFER_ORDER_NUMBER", required = false)
	@Nullable
	@Column(name = "transfer_order_number")
	@Schema(description = "The Transfer Order Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transfer Order Number here] end
	private String transferOrderNumber;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@CsvBindByName(column = "TRANSACTION_STATUS", required = false)
	@Nullable
	@Column(name = "transaction_status")
	@Schema(description = "The Transaction Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Order Date here] off begin

	@CsvCustomBindByName(column = "ORDER_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "order_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Order Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Expected Date here] off begin

	@CsvCustomBindByName(column = "EXPECTED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expected_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expected Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expected Date here] end
	private OffsetDateTime expectedDate;

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

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@CsvBindByName(column = "REFERENCE_DOCUMENT", required = false)
	@Nullable
	@Column(name = "reference_document")
	@Schema(description = "The Reference Document of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Required Date here] off begin

	@CsvCustomBindByName(column = "REQUIRED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "required_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Required Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Required Date here] end
	private OffsetDateTime requiredDate;

	// % protected region % [Modify attribute annotation for Issued Date Time here] off begin

	@CsvCustomBindByName(column = "ISSUED_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "issued_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Issued Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Issued Date Time here] end
	private OffsetDateTime issuedDateTime;

	// % protected region % [Modify attribute annotation for Received Date Time here] off begin

	@CsvCustomBindByName(column = "RECEIVED_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "received_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Received Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Received Date Time here] end
	private OffsetDateTime receivedDateTime;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Transfer Order Stock Details here] off begin
	@Schema(description = "The Transfer Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "transferOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transfer Order Stock Details here] end
	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSFER_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] end
	private Set<UUID> transferOrderStockDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Destination Warehouse here] off begin
	@Schema(description = "The Destination Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Destination Warehouse here] end
	private WarehouseEntity destinationWarehouse;

	// % protected region % [Update the annotation for destinationWarehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DESTINATION_WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for destinationWarehouseId here] end
	private UUID destinationWarehouseId;

	// % protected region % [Update the annotation for Source Warehouse here] off begin
	@Schema(description = "The Source Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Source Warehouse here] end
	private WarehouseEntity sourceWarehouse;

	// % protected region % [Update the annotation for sourceWarehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SOURCE_WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sourceWarehouseId here] end
	private UUID sourceWarehouseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setTransferOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransferOrder(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setTransferOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetTransferOrder(false));
		}
		this.transferOrderStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDestinationWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setDestinationWarehouse(@NotNull WarehouseEntity entity) {
		setDestinationWarehouse(entity, true);
	}

	/**
	 * Set or update the destinationWarehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to destinationWarehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDestinationWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDestinationWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDestinationWarehouse here] end

		if (sameAsFormer(this.destinationWarehouse, entity)) {
			return;
		}

		if (this.destinationWarehouse != null) {
			this.destinationWarehouse.removeDestinationWarehouses(this, false);
		}
		this.destinationWarehouse = entity;
		if (reverseAdd) {
			this.destinationWarehouse.addDestinationWarehouses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDestinationWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDestinationWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDestinationWarehouse(boolean)} but default to true.
	 */
	public void unsetDestinationWarehouse() {
		this.unsetDestinationWarehouse(true);
	}

	/**
	 * Remove Destination Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDestinationWarehouse(boolean reverse) {
		if (reverse && this.destinationWarehouse != null) {
			this.destinationWarehouse.removeDestinationWarehouses(this, false);
		}
		this.destinationWarehouse = null;
	}
	/**
	 * Similar to {@link this#setSourceWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setSourceWarehouse(@NotNull WarehouseEntity entity) {
		setSourceWarehouse(entity, true);
	}

	/**
	 * Set or update the sourceWarehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to sourceWarehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSourceWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSourceWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSourceWarehouse here] end

		if (sameAsFormer(this.sourceWarehouse, entity)) {
			return;
		}

		if (this.sourceWarehouse != null) {
			this.sourceWarehouse.removeSourceWarehouses(this, false);
		}
		this.sourceWarehouse = entity;
		if (reverseAdd) {
			this.sourceWarehouse.addSourceWarehouses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSourceWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSourceWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSourceWarehouse(boolean)} but default to true.
	 */
	public void unsetSourceWarehouse() {
		this.unsetSourceWarehouse(true);
	}

	/**
	 * Remove Source Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSourceWarehouse(boolean reverse) {
		if (reverse && this.sourceWarehouse != null) {
			this.sourceWarehouse.removeSourceWarehouses(this, false);
		}
		this.sourceWarehouse = null;
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
		return "TRANSFER_ORDER_NUMBER,TRANSACTION_STATUS,APPROVAL_STATUS,ORDER_DATE,EXPECTED_DATE,REFERENCE_NUMBER,NOTES,VOID_DATE,REFERENCE_DOCUMENT,REQUIRED_DATE,ISSUED_DATE_TIME,RECEIVED_DATE_TIME,DESTINATION_WAREHOUSE_ID,SOURCE_WAREHOUSE_ID,TRANSFER_ORDER_STOCK_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<WarehouseEntity> destinationWarehouseRelation = Optional.ofNullable(this.destinationWarehouse);
		destinationWarehouseRelation.ifPresent(entity -> this.destinationWarehouseId = entity.getId());

		Optional<WarehouseEntity> sourceWarehouseRelation = Optional.ofNullable(this.sourceWarehouse);
		sourceWarehouseRelation.ifPresent(entity -> this.sourceWarehouseId = entity.getId());

		this.transferOrderStockDetailsIds = new HashSet<>();
		for (TransferOrderStockDetailEntity transferOrderStockDetails: this.transferOrderStockDetails) {
			this.transferOrderStockDetailsIds.add(transferOrderStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object transferOrder) {
		if (this == transferOrder) {
			return true;
		}
		if (transferOrder == null || this.getClass() != transferOrder.getClass()) {
			return false;
		}
		if (!super.equals(transferOrder)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TransferOrderEntity that = (TransferOrderEntity) transferOrder;
		return
			Objects.equals(this.transferOrderNumber, that.transferOrderNumber) &&
			Objects.equals(this.transactionStatus, that.transactionStatus) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(
			     this.orderDate != null ? this.orderDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.orderDate != null ? that.orderDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.expectedDate != null ? this.expectedDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expectedDate != null ? that.expectedDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(
			     this.voidDate != null ? this.voidDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.voidDate != null ? that.voidDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.referenceDocument, that.referenceDocument) &&
			Objects.equals(
			     this.requiredDate != null ? this.requiredDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.requiredDate != null ? that.requiredDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.issuedDateTime != null ? this.issuedDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.issuedDateTime != null ? that.issuedDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.receivedDateTime != null ? this.receivedDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.receivedDateTime != null ? that.receivedDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.transferOrderStockDetailsIds, that.transferOrderStockDetailsIds) &&
			Objects.equals(this.destinationWarehouseId, that.destinationWarehouseId) &&
			Objects.equals(this.sourceWarehouseId, that.sourceWarehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
