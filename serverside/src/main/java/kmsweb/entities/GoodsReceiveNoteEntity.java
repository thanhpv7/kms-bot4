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
import kmsweb.dtos.GoodsReceiveNoteEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.GoodsReceiveNoteEntityListener;
import kmsweb.serializers.GoodsReceiveNoteSerializer;
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
@EntityListeners({GoodsReceiveNoteEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = GoodsReceiveNoteSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"receive_number"}, name = "receive_number"),
	}
)
public class GoodsReceiveNoteEntity extends AbstractEntity {

	/**
	 * Takes a GoodsReceiveNoteEntityDto and converts it into a GoodsReceiveNoteEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param goodsReceiveNoteEntityDto
	 */
	public GoodsReceiveNoteEntity(GoodsReceiveNoteEntityDto goodsReceiveNoteEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (goodsReceiveNoteEntityDto.getId() != null) {
			this.setId(goodsReceiveNoteEntityDto.getId());
		}

		if (goodsReceiveNoteEntityDto.getReceiveNumber() != null) {
			this.setReceiveNumber(goodsReceiveNoteEntityDto.getReceiveNumber());
		}

		if (goodsReceiveNoteEntityDto.getSourceDocumentType() != null) {
			this.setSourceDocumentType(goodsReceiveNoteEntityDto.getSourceDocumentType());
		}

		if (goodsReceiveNoteEntityDto.getSourceDocumentNumber() != null) {
			this.setSourceDocumentNumber(goodsReceiveNoteEntityDto.getSourceDocumentNumber());
		}

		if (goodsReceiveNoteEntityDto.getReceiveDate() != null) {
			this.setReceiveDate(goodsReceiveNoteEntityDto.getReceiveDate());
		}

		if (goodsReceiveNoteEntityDto.getVoidDate() != null) {
			this.setVoidDate(goodsReceiveNoteEntityDto.getVoidDate());
		}

		if (goodsReceiveNoteEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(goodsReceiveNoteEntityDto.getApprovalStatus());
		}

		if (goodsReceiveNoteEntityDto.getNotes() != null) {
			this.setNotes(goodsReceiveNoteEntityDto.getNotes());
		}

		if (goodsReceiveNoteEntityDto.getSupplierInvoiceNumber() != null) {
			this.setSupplierInvoiceNumber(goodsReceiveNoteEntityDto.getSupplierInvoiceNumber());
		}

		if (goodsReceiveNoteEntityDto.getShippingMethod() != null) {
			this.setShippingMethod(goodsReceiveNoteEntityDto.getShippingMethod());
		}

		if (goodsReceiveNoteEntityDto.getShippingNumber() != null) {
			this.setShippingNumber(goodsReceiveNoteEntityDto.getShippingNumber());
		}

		if (goodsReceiveNoteEntityDto.getShippingDate() != null) {
			this.setShippingDate(goodsReceiveNoteEntityDto.getShippingDate());
		}

		if (goodsReceiveNoteEntityDto.getGoodsReceiveNoteItems() != null) {
			this.setGoodsReceiveNoteItems(goodsReceiveNoteEntityDto.getGoodsReceiveNoteItems());
		}

		if (goodsReceiveNoteEntityDto.getPurchaseOrders() != null) {
			this.setPurchaseOrders(goodsReceiveNoteEntityDto.getPurchaseOrders());
		}

		if (goodsReceiveNoteEntityDto.getSupplier() != null) {
			this.setSupplier(goodsReceiveNoteEntityDto.getSupplier());
		}

		if (goodsReceiveNoteEntityDto.getWarehouse() != null) {
			this.setWarehouse(goodsReceiveNoteEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Receive Number here] off begin
	@CsvBindByName(column = "RECEIVE_NUMBER", required = false)
	@Nullable
	@Column(name = "receive_number")
	@Schema(description = "The Receive Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Receive Number here] end
	private String receiveNumber;

	// % protected region % [Modify attribute annotation for Source Document Type here] off begin
	@CsvCustomBindByName(column = "SOURCE_DOCUMENT_TYPE", required = false, converter = GrnSourceTypeEnumConverter.class)
	@Nullable
	@Column(name = "source_document_type")
	@Schema(description = "The Source Document Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Source Document Type here] end
	private GrnSourceTypeEnum sourceDocumentType;

	// % protected region % [Modify attribute annotation for Source Document Number here] off begin
	@CsvBindByName(column = "SOURCE_DOCUMENT_NUMBER", required = false)
	@Nullable
	@Column(name = "source_document_number")
	@Schema(description = "The Source Document Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Document Number here] end
	private String sourceDocumentNumber;

	// % protected region % [Modify attribute annotation for Receive Date here] off begin

	@CsvCustomBindByName(column = "RECEIVE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "receive_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Receive Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Receive Date here] end
	private OffsetDateTime receiveDate;

	// % protected region % [Modify attribute annotation for Void Date here] off begin

	@CsvCustomBindByName(column = "VOID_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "void_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Void Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Void Date here] end
	private OffsetDateTime voidDate;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Supplier Invoice Number here] off begin
	@CsvBindByName(column = "SUPPLIER_INVOICE_NUMBER", required = false)
	@Nullable
	@Column(name = "supplier_invoice_number")
	@Schema(description = "The Supplier Invoice Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Invoice Number here] end
	private String supplierInvoiceNumber;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@CsvBindByName(column = "SHIPPING_METHOD", required = false)
	@Nullable
	@Column(name = "shipping_method")
	@Schema(description = "The Shipping Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Shipping Number here] off begin
	@CsvBindByName(column = "SHIPPING_NUMBER", required = false)
	@Nullable
	@Column(name = "shipping_number")
	@Schema(description = "The Shipping Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shipping Number here] end
	private String shippingNumber;

	// % protected region % [Modify attribute annotation for Shipping Date here] off begin

	@CsvCustomBindByName(column = "SHIPPING_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "shipping_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Shipping Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shipping Date here] end
	private OffsetDateTime shippingDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note Items here] off begin
	@Schema(description = "The Goods Receive Note Item entities that are related to this entity.")
	@OneToMany(mappedBy = "goodsReceiveNote", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Items here] end
	private Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] end
	private Set<UUID> goodsReceiveNoteItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Orders here] off begin
	@Schema(description = "The Purchase Order entities that are related to this entity.")
	@OneToMany(mappedBy = "goodsReceiveNote", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Orders here] end
	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	// % protected region % [Update the annotation for purchaseOrdersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseOrdersIds here] end
	private Set<UUID> purchaseOrdersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		addGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteItemEntity to goodsReceiveNoteItems in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteItems.contains(entity)) {
			goodsReceiveNoteItems.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNote(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		addGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteItemEntity to Goods Receive Note Items in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		this.removeGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteItemEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNote(false);
		}
		this.goodsReceiveNoteItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		this.removeGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteItemEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		setGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Items with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteItems();
		this.goodsReceiveNoteItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setGoodsReceiveNote(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteItems() {
		this.unsetGoodsReceiveNoteItems(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteItems(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetGoodsReceiveNote(false));
		}
		this.goodsReceiveNoteItems.clear();
	}

/**
	 * Similar to {@link this#addPurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NotNull PurchaseOrderEntity entity) {
		addPurchaseOrders(entity, true);
	}

	/**
	 * Add a new PurchaseOrderEntity to purchaseOrders in this entity.
	 *
	 * @param entity the given PurchaseOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrders.contains(entity)) {
			purchaseOrders.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNote(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NotNull Collection<PurchaseOrderEntity> entities) {
		addPurchaseOrders(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderEntity to Purchase Orders in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void removePurchaseOrders(@NotNull PurchaseOrderEntity entity) {
		this.removePurchaseOrders(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrders(@NotNull PurchaseOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNote(false);
		}
		this.purchaseOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 */
	public void removePurchaseOrders(@NotNull Collection<PurchaseOrderEntity> entities) {
		this.removePurchaseOrders(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrders(@NotNull Collection<PurchaseOrderEntity> entities) {
		setPurchaseOrders(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Orders with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrders(@NotNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrders();
		this.purchaseOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.setGoodsReceiveNote(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrders() {
		this.unsetPurchaseOrders(true);
	}

	/**
	 * Remove all the entities in Purchase Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrders(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.unsetGoodsReceiveNote(false));
		}
		this.purchaseOrders.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.supplier.removeGoodsReceiveNotes(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addGoodsReceiveNotes(this, false);
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
			this.supplier.removeGoodsReceiveNotes(this, false);
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
			this.warehouse.removeGoodsReceiveNotes(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addGoodsReceiveNotes(this, false);
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
			this.warehouse.removeGoodsReceiveNotes(this, false);
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
		return "RECEIVE_NUMBER,SOURCE_DOCUMENT_TYPE,SOURCE_DOCUMENT_NUMBER,RECEIVE_DATE,VOID_DATE,APPROVAL_STATUS,NOTES,SUPPLIER_INVOICE_NUMBER,SHIPPING_METHOD,SHIPPING_NUMBER,SHIPPING_DATE,SUPPLIER_ID,WAREHOUSE_ID,GOODS_RECEIVE_NOTE_ITEMS_IDS,PURCHASE_ORDERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<SupplierEntity> supplierRelation = Optional.ofNullable(this.supplier);
		supplierRelation.ifPresent(entity -> this.supplierId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.goodsReceiveNoteItemsIds = new HashSet<>();
		for (GoodsReceiveNoteItemEntity goodsReceiveNoteItems: this.goodsReceiveNoteItems) {
			this.goodsReceiveNoteItemsIds.add(goodsReceiveNoteItems.getId());
		}

		this.purchaseOrdersIds = new HashSet<>();
		for (PurchaseOrderEntity purchaseOrders: this.purchaseOrders) {
			this.purchaseOrdersIds.add(purchaseOrders.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object goodsReceiveNote) {
		if (this == goodsReceiveNote) {
			return true;
		}
		if (goodsReceiveNote == null || this.getClass() != goodsReceiveNote.getClass()) {
			return false;
		}
		if (!super.equals(goodsReceiveNote)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		GoodsReceiveNoteEntity that = (GoodsReceiveNoteEntity) goodsReceiveNote;
		return
			Objects.equals(this.receiveNumber, that.receiveNumber) &&
			Objects.equals(this.sourceDocumentType, that.sourceDocumentType) &&
			Objects.equals(this.sourceDocumentNumber, that.sourceDocumentNumber) &&
			Objects.equals(
			     this.receiveDate != null ? this.receiveDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.receiveDate != null ? that.receiveDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.voidDate != null ? this.voidDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.voidDate != null ? that.voidDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.supplierInvoiceNumber, that.supplierInvoiceNumber) &&
			Objects.equals(this.shippingMethod, that.shippingMethod) &&
			Objects.equals(this.shippingNumber, that.shippingNumber) &&
			Objects.equals(
			     this.shippingDate != null ? this.shippingDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.shippingDate != null ? that.shippingDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.goodsReceiveNoteItemsIds, that.goodsReceiveNoteItemsIds) &&
			Objects.equals(this.purchaseOrdersIds, that.purchaseOrdersIds) &&
			Objects.equals(this.supplierId, that.supplierId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
