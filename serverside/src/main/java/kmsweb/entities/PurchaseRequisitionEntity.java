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
import kmsweb.dtos.PurchaseRequisitionEntityDto;
import kmsweb.entities.listeners.PurchaseRequisitionEntityListener;
import kmsweb.serializers.PurchaseRequisitionSerializer;
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
@EntityListeners({PurchaseRequisitionEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PurchaseRequisitionSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PurchaseRequisitionEntity extends AbstractEntity {

	/**
	 * Takes a PurchaseRequisitionEntityDto and converts it into a PurchaseRequisitionEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param purchaseRequisitionEntityDto
	 */
	public PurchaseRequisitionEntity(PurchaseRequisitionEntityDto purchaseRequisitionEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (purchaseRequisitionEntityDto.getId() != null) {
			this.setId(purchaseRequisitionEntityDto.getId());
		}

		if (purchaseRequisitionEntityDto.getPurchaseRequisitionNumber() != null) {
			this.setPurchaseRequisitionNumber(purchaseRequisitionEntityDto.getPurchaseRequisitionNumber());
		}

		if (purchaseRequisitionEntityDto.getTransactionStatus() != null) {
			this.setTransactionStatus(purchaseRequisitionEntityDto.getTransactionStatus());
		}

		if (purchaseRequisitionEntityDto.getReferenceDocument() != null) {
			this.setReferenceDocument(purchaseRequisitionEntityDto.getReferenceDocument());
		}

		if (purchaseRequisitionEntityDto.getNotes() != null) {
			this.setNotes(purchaseRequisitionEntityDto.getNotes());
		}

		if (purchaseRequisitionEntityDto.getOrderDate() != null) {
			this.setOrderDate(purchaseRequisitionEntityDto.getOrderDate());
		}

		if (purchaseRequisitionEntityDto.getRequiredDate() != null) {
			this.setRequiredDate(purchaseRequisitionEntityDto.getRequiredDate());
		}

		if (purchaseRequisitionEntityDto.getTotalEstimationOrder() != null) {
			this.setTotalEstimationOrder(purchaseRequisitionEntityDto.getTotalEstimationOrder());
		}

		if (purchaseRequisitionEntityDto.getRedraftingDateTime() != null) {
			this.setRedraftingDateTime(purchaseRequisitionEntityDto.getRedraftingDateTime());
		}

		if (purchaseRequisitionEntityDto.getSubmissionDateTime() != null) {
			this.setSubmissionDateTime(purchaseRequisitionEntityDto.getSubmissionDateTime());
		}

		if (purchaseRequisitionEntityDto.getApprovalDateTime() != null) {
			this.setApprovalDateTime(purchaseRequisitionEntityDto.getApprovalDateTime());
		}

		if (purchaseRequisitionEntityDto.getRejectionDateTime() != null) {
			this.setRejectionDateTime(purchaseRequisitionEntityDto.getRejectionDateTime());
		}

		if (purchaseRequisitionEntityDto.getVoidingDateTime() != null) {
			this.setVoidingDateTime(purchaseRequisitionEntityDto.getVoidingDateTime());
		}

		if (purchaseRequisitionEntityDto.getPurchaseRequisitionStockDetails() != null) {
			this.setPurchaseRequisitionStockDetails(purchaseRequisitionEntityDto.getPurchaseRequisitionStockDetails());
		}

		if (purchaseRequisitionEntityDto.getPurchaseOrder() != null) {
			this.setPurchaseOrder(purchaseRequisitionEntityDto.getPurchaseOrder());
		}

		if (purchaseRequisitionEntityDto.getSupplier() != null) {
			this.setSupplier(purchaseRequisitionEntityDto.getSupplier());
		}

		if (purchaseRequisitionEntityDto.getWarehouse() != null) {
			this.setWarehouse(purchaseRequisitionEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Purchase Requisition Number here] off begin
	@CsvBindByName(column = "PURCHASE_REQUISITION_NUMBER", required = false)
	@Nullable
	@Column(name = "purchase_requisition_number")
	@Schema(description = "The Purchase Requisition Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Requisition Number here] end
	private String purchaseRequisitionNumber;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@CsvBindByName(column = "TRANSACTION_STATUS", required = false)
	@Nullable
	@Column(name = "transaction_status")
	@Schema(description = "The Transaction Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@CsvBindByName(column = "REFERENCE_DOCUMENT", required = false)
	@Nullable
	@Column(name = "reference_document")
	@Schema(description = "The Reference Document of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Order Date here] off begin

	@CsvCustomBindByName(column = "ORDER_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "order_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Order Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Required Date here] off begin

	@CsvCustomBindByName(column = "REQUIRED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "required_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Required Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Required Date here] end
	private OffsetDateTime requiredDate;

	// % protected region % [Modify attribute annotation for Total Estimation Order here] off begin
	@CsvBindByName(column = "TOTAL_ESTIMATION_ORDER", required = false)
	@Nullable
	@Column(name = "total_estimation_order")
	@Schema(description = "The Total Estimation Order of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Estimation Order here] end
	private Double totalEstimationOrder;

	// % protected region % [Modify attribute annotation for Redrafting Date Time here] off begin

	@CsvCustomBindByName(column = "REDRAFTING_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "redrafting_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Redrafting Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Redrafting Date Time here] end
	private OffsetDateTime redraftingDateTime;

	// % protected region % [Modify attribute annotation for Submission Date Time here] off begin

	@CsvCustomBindByName(column = "SUBMISSION_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "submission_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Submission Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Submission Date Time here] end
	private OffsetDateTime submissionDateTime;

	// % protected region % [Modify attribute annotation for Approval Date Time here] off begin

	@CsvCustomBindByName(column = "APPROVAL_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "approval_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Approval Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Date Time here] end
	private OffsetDateTime approvalDateTime;

	// % protected region % [Modify attribute annotation for Rejection Date Time here] off begin

	@CsvCustomBindByName(column = "REJECTION_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "rejection_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Rejection Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rejection Date Time here] end
	private OffsetDateTime rejectionDateTime;

	// % protected region % [Modify attribute annotation for Voiding Date Time here] off begin

	@CsvCustomBindByName(column = "VOIDING_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "voiding_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Voiding Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Voiding Date Time here] end
	private OffsetDateTime voidingDateTime;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Purchase Requisition Stock Details here] off begin
	@Schema(description = "The Purchase Requisition Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseRequisition", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Requisition Stock Details here] end
	private Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for purchaseRequisitionStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_REQUISITION_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseRequisitionStockDetailsIds here] end
	private Set<UUID> purchaseRequisitionStockDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Purchase Order here] off begin
	@Schema(description = "The Purchase Order entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order here] end
	private PurchaseOrderEntity purchaseOrder;

	// % protected region % [Update the annotation for purchaseOrderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchaseOrderId here] end
	private UUID purchaseOrderId;

	// % protected region % [Update the annotation for Supplier here] off begin
	@Schema(description = "The Supplier entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier here] end
	private SupplierEntity supplier;

	// % protected region % [Update the annotation for supplierId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for supplierId here] end
	private UUID supplierId;

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
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity) {
		addPurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionStockDetailEntity to purchaseRequisitionStockDetails in this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitionStockDetails.contains(entity)) {
			purchaseRequisitionStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseRequisition(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		addPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionStockDetailEntity to Purchase Requisition Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity) {
		this.removePurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseRequisition(false);
		}
		this.purchaseRequisitionStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		this.removePurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		setPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisition Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitionStockDetails();
		this.purchaseRequisitionStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.setPurchaseRequisition(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitionStockDetails() {
		this.unsetPurchaseRequisitionStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Requisition Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitionStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.unsetPurchaseRequisition(false));
		}
		this.purchaseRequisitionStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPurchaseOrder(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrder(@NotNull PurchaseOrderEntity entity) {
		setPurchaseOrder(entity, true);
	}

	/**
	 * Set or update the purchaseOrder in this entity with single PurchaseOrderEntity.
	 *
	 * @param entity the given PurchaseOrderEntity to be set or updated to purchaseOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrder(@NotNull PurchaseOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] end

		if (sameAsFormer(this.purchaseOrder, entity)) {
			return;
		}

		if (this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseRequisitions(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addPurchaseRequisitions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrder(boolean)} but default to true.
	 */
	public void unsetPurchaseOrder() {
		this.unsetPurchaseOrder(true);
	}

	/**
	 * Remove Purchase Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseOrder(boolean reverse) {
		if (reverse && this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseRequisitions(this, false);
		}
		this.purchaseOrder = null;
	}
	/**
	 * Similar to {@link this#setSupplier(SupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierEntity to be set to this entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity) {
		setSupplier(entity, true);
	}

	/**
	 * Set or update the supplier in this entity with single SupplierEntity.
	 *
	 * @param entity the given SupplierEntity to be set or updated to supplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] end

		if (sameAsFormer(this.supplier, entity)) {
			return;
		}

		if (this.supplier != null) {
			this.supplier.removePurchaseRequisitions(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addPurchaseRequisitions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSupplier(boolean)} but default to true.
	 */
	public void unsetSupplier() {
		this.unsetSupplier(true);
	}

	/**
	 * Remove Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSupplier(boolean reverse) {
		if (reverse && this.supplier != null) {
			this.supplier.removePurchaseRequisitions(this, false);
		}
		this.supplier = null;
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
			this.warehouse.removePurchaseRequisitions(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addPurchaseRequisitions(this, false);
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
			this.warehouse.removePurchaseRequisitions(this, false);
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
		return "PURCHASE_REQUISITION_NUMBER,TRANSACTION_STATUS,REFERENCE_DOCUMENT,NOTES,ORDER_DATE,REQUIRED_DATE,TOTAL_ESTIMATION_ORDER,REDRAFTING_DATE_TIME,SUBMISSION_DATE_TIME,APPROVAL_DATE_TIME,REJECTION_DATE_TIME,VOIDING_DATE_TIME,PURCHASE_ORDER_ID,SUPPLIER_ID,WAREHOUSE_ID,PURCHASE_REQUISITION_STOCK_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PurchaseOrderEntity> purchaseOrderRelation = Optional.ofNullable(this.purchaseOrder);
		purchaseOrderRelation.ifPresent(entity -> this.purchaseOrderId = entity.getId());

		Optional<SupplierEntity> supplierRelation = Optional.ofNullable(this.supplier);
		supplierRelation.ifPresent(entity -> this.supplierId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.purchaseRequisitionStockDetailsIds = new HashSet<>();
		for (PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetails: this.purchaseRequisitionStockDetails) {
			this.purchaseRequisitionStockDetailsIds.add(purchaseRequisitionStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object purchaseRequisition) {
		if (this == purchaseRequisition) {
			return true;
		}
		if (purchaseRequisition == null || this.getClass() != purchaseRequisition.getClass()) {
			return false;
		}
		if (!super.equals(purchaseRequisition)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PurchaseRequisitionEntity that = (PurchaseRequisitionEntity) purchaseRequisition;
		return
			Objects.equals(this.purchaseRequisitionNumber, that.purchaseRequisitionNumber) &&
			Objects.equals(this.transactionStatus, that.transactionStatus) &&
			Objects.equals(this.referenceDocument, that.referenceDocument) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(
			     this.orderDate != null ? this.orderDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.orderDate != null ? that.orderDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.requiredDate != null ? this.requiredDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.requiredDate != null ? that.requiredDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.totalEstimationOrder, that.totalEstimationOrder) &&
			Objects.equals(
			     this.redraftingDateTime != null ? this.redraftingDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.redraftingDateTime != null ? that.redraftingDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.submissionDateTime != null ? this.submissionDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.submissionDateTime != null ? that.submissionDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.approvalDateTime != null ? this.approvalDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.approvalDateTime != null ? that.approvalDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.rejectionDateTime != null ? this.rejectionDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.rejectionDateTime != null ? that.rejectionDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.voidingDateTime != null ? this.voidingDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.voidingDateTime != null ? that.voidingDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.purchaseRequisitionStockDetailsIds, that.purchaseRequisitionStockDetailsIds) &&
			Objects.equals(this.purchaseOrderId, that.purchaseOrderId) &&
			Objects.equals(this.supplierId, that.supplierId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
