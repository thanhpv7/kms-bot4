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
import kmsweb.dtos.InternalOrderEntityDto;
import kmsweb.entities.listeners.InternalOrderEntityListener;
import kmsweb.serializers.InternalOrderSerializer;
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
@EntityListeners({InternalOrderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InternalOrderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InternalOrderEntity extends AbstractEntity {

	/**
	 * Takes a InternalOrderEntityDto and converts it into a InternalOrderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param internalOrderEntityDto
	 */
	public InternalOrderEntity(InternalOrderEntityDto internalOrderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (internalOrderEntityDto.getId() != null) {
			this.setId(internalOrderEntityDto.getId());
		}

		if (internalOrderEntityDto.getInternalOrderNumber() != null) {
			this.setInternalOrderNumber(internalOrderEntityDto.getInternalOrderNumber());
		}

		if (internalOrderEntityDto.getTransactionStatus() != null) {
			this.setTransactionStatus(internalOrderEntityDto.getTransactionStatus());
		}

		if (internalOrderEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(internalOrderEntityDto.getApprovalStatus());
		}

		if (internalOrderEntityDto.getOrderDate() != null) {
			this.setOrderDate(internalOrderEntityDto.getOrderDate());
		}

		if (internalOrderEntityDto.getExpectedDate() != null) {
			this.setExpectedDate(internalOrderEntityDto.getExpectedDate());
		}

		if (internalOrderEntityDto.getRequestUnit() != null) {
			this.setRequestUnit(internalOrderEntityDto.getRequestUnit());
		}

		if (internalOrderEntityDto.getRequestPerson() != null) {
			this.setRequestPerson(internalOrderEntityDto.getRequestPerson());
		}

		if (internalOrderEntityDto.getTransactionDetailType() != null) {
			this.setTransactionDetailType(internalOrderEntityDto.getTransactionDetailType());
		}

		if (internalOrderEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(internalOrderEntityDto.getReferenceNumber());
		}

		if (internalOrderEntityDto.getNotes() != null) {
			this.setNotes(internalOrderEntityDto.getNotes());
		}

		if (internalOrderEntityDto.getVoidDate() != null) {
			this.setVoidDate(internalOrderEntityDto.getVoidDate());
		}

		if (internalOrderEntityDto.getIssuedDateTime() != null) {
			this.setIssuedDateTime(internalOrderEntityDto.getIssuedDateTime());
		}

		if (internalOrderEntityDto.getReceivedDateTime() != null) {
			this.setReceivedDateTime(internalOrderEntityDto.getReceivedDateTime());
		}

		if (internalOrderEntityDto.getInternalOrderStockDetails() != null) {
			this.setInternalOrderStockDetails(internalOrderEntityDto.getInternalOrderStockDetails());
		}

		if (internalOrderEntityDto.getWarehouse() != null) {
			this.setWarehouse(internalOrderEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Internal Order Number here] off begin
	@CsvBindByName(column = "INTERNAL_ORDER_NUMBER", required = false)
	@Nullable
	@Column(name = "internal_order_number")
	@Schema(description = "The Internal Order Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Internal Order Number here] end
	private String internalOrderNumber;

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

	// % protected region % [Modify attribute annotation for Request Unit here] off begin
	@CsvBindByName(column = "REQUEST_UNIT", required = false)
	@Nullable
	@Column(name = "request_unit")
	@Schema(description = "The Request Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Request Unit here] end
	private String requestUnit;

	// % protected region % [Modify attribute annotation for Request Person here] off begin
	@CsvBindByName(column = "REQUEST_PERSON", required = false)
	@Nullable
	@Column(name = "request_person")
	@Schema(description = "The Request Person of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Request Person here] end
	private String requestPerson;

	// % protected region % [Modify attribute annotation for Transaction Detail Type here] off begin
	@CsvBindByName(column = "TRANSACTION_DETAIL_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_detail_type")
	@Schema(description = "The Transaction Detail Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Detail Type here] end
	private String transactionDetailType;

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

	// % protected region % [Update the annotation for Internal Order Stock Details here] off begin
	@Schema(description = "The Internal Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "internalOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Internal Order Stock Details here] end
	private Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for internalOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INTERNAL_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for internalOrderStockDetailsIds here] end
	private Set<UUID> internalOrderStockDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity) {
		addInternalOrderStockDetails(entity, true);
	}

	/**
	 * Add a new InternalOrderStockDetailEntity to internalOrderStockDetails in this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.internalOrderStockDetails.contains(entity)) {
			internalOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setInternalOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		addInternalOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of InternalOrderStockDetailEntity to Internal Order Stock Details in this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be set to this entity
	 */
	public void removeInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity) {
		this.removeInternalOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given InternalOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInternalOrder(false);
		}
		this.internalOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 */
	public void removeInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		this.removeInternalOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of InternalOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be set to this entity
	 */
	public void setInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		setInternalOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Internal Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetInternalOrderStockDetails();
		this.internalOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.setInternalOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInternalOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInternalOrderStockDetails() {
		this.unsetInternalOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Internal Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInternalOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.unsetInternalOrder(false));
		}
		this.internalOrderStockDetails.clear();
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
			this.warehouse.removeInternalOrders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInternalOrders(this, false);
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
			this.warehouse.removeInternalOrders(this, false);
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
		return "INTERNAL_ORDER_NUMBER,TRANSACTION_STATUS,APPROVAL_STATUS,ORDER_DATE,EXPECTED_DATE,REQUEST_UNIT,REQUEST_PERSON,TRANSACTION_DETAIL_TYPE,REFERENCE_NUMBER,NOTES,VOID_DATE,ISSUED_DATE_TIME,RECEIVED_DATE_TIME,WAREHOUSE_ID,INTERNAL_ORDER_STOCK_DETAILS_IDS,ID";
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

		this.internalOrderStockDetailsIds = new HashSet<>();
		for (InternalOrderStockDetailEntity internalOrderStockDetails: this.internalOrderStockDetails) {
			this.internalOrderStockDetailsIds.add(internalOrderStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object internalOrder) {
		if (this == internalOrder) {
			return true;
		}
		if (internalOrder == null || this.getClass() != internalOrder.getClass()) {
			return false;
		}
		if (!super.equals(internalOrder)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InternalOrderEntity that = (InternalOrderEntity) internalOrder;
		return
			Objects.equals(this.internalOrderNumber, that.internalOrderNumber) &&
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
			Objects.equals(this.requestUnit, that.requestUnit) &&
			Objects.equals(this.requestPerson, that.requestPerson) &&
			Objects.equals(this.transactionDetailType, that.transactionDetailType) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(
			     this.voidDate != null ? this.voidDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.voidDate != null ? that.voidDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.issuedDateTime != null ? this.issuedDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.issuedDateTime != null ? that.issuedDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.receivedDateTime != null ? this.receivedDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.receivedDateTime != null ? that.receivedDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.internalOrderStockDetailsIds, that.internalOrderStockDetailsIds) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
