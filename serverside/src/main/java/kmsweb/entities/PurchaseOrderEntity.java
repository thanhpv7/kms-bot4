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
import kmsweb.dtos.PurchaseOrderEntityDto;
import kmsweb.entities.listeners.PurchaseOrderEntityListener;
import kmsweb.serializers.PurchaseOrderSerializer;
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
@EntityListeners({PurchaseOrderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PurchaseOrderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PurchaseOrderEntity extends AbstractEntity {

	/**
	 * Takes a PurchaseOrderEntityDto and converts it into a PurchaseOrderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param purchaseOrderEntityDto
	 */
	public PurchaseOrderEntity(PurchaseOrderEntityDto purchaseOrderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (purchaseOrderEntityDto.getId() != null) {
			this.setId(purchaseOrderEntityDto.getId());
		}

		if (purchaseOrderEntityDto.getPurchaseOrderType() != null) {
			this.setPurchaseOrderType(purchaseOrderEntityDto.getPurchaseOrderType());
		}

		if (purchaseOrderEntityDto.getPurchaseOrderNumber() != null) {
			this.setPurchaseOrderNumber(purchaseOrderEntityDto.getPurchaseOrderNumber());
		}

		if (purchaseOrderEntityDto.getStatus() != null) {
			this.setStatus(purchaseOrderEntityDto.getStatus());
		}

		if (purchaseOrderEntityDto.getSupplyStockGroup() != null) {
			this.setSupplyStockGroup(purchaseOrderEntityDto.getSupplyStockGroup());
		}

		if (purchaseOrderEntityDto.getOrderDate() != null) {
			this.setOrderDate(purchaseOrderEntityDto.getOrderDate());
		}

		if (purchaseOrderEntityDto.getExpectedDate() != null) {
			this.setExpectedDate(purchaseOrderEntityDto.getExpectedDate());
		}

		if (purchaseOrderEntityDto.getPriceVATIncluded() != null) {
			this.setPriceVATIncluded(purchaseOrderEntityDto.getPriceVATIncluded());
		}

		if (purchaseOrderEntityDto.getInventoryVATIncluded() != null) {
			this.setInventoryVATIncluded(purchaseOrderEntityDto.getInventoryVATIncluded());
		}

		if (purchaseOrderEntityDto.getReferenceDocument() != null) {
			this.setReferenceDocument(purchaseOrderEntityDto.getReferenceDocument());
		}

		if (purchaseOrderEntityDto.getSupplierReferenceDocument() != null) {
			this.setSupplierReferenceDocument(purchaseOrderEntityDto.getSupplierReferenceDocument());
		}

		if (purchaseOrderEntityDto.getPaymentTerms() != null) {
			this.setPaymentTerms(purchaseOrderEntityDto.getPaymentTerms());
		}

		if (purchaseOrderEntityDto.getShippingMethod() != null) {
			this.setShippingMethod(purchaseOrderEntityDto.getShippingMethod());
		}

		if (purchaseOrderEntityDto.getNotes() != null) {
			this.setNotes(purchaseOrderEntityDto.getNotes());
		}

		if (purchaseOrderEntityDto.getSubTotal() != null) {
			this.setSubTotal(purchaseOrderEntityDto.getSubTotal());
		}

		if (purchaseOrderEntityDto.getExtraDiscountInPercent() != null) {
			this.setExtraDiscountInPercent(purchaseOrderEntityDto.getExtraDiscountInPercent());
		}

		if (purchaseOrderEntityDto.getExtraDiscountIncludeTax() != null) {
			this.setExtraDiscountIncludeTax(purchaseOrderEntityDto.getExtraDiscountIncludeTax());
		}

		if (purchaseOrderEntityDto.getExtraDiscountValue() != null) {
			this.setExtraDiscountValue(purchaseOrderEntityDto.getExtraDiscountValue());
		}

		if (purchaseOrderEntityDto.getFreightFeeIncludeTax() != null) {
			this.setFreightFeeIncludeTax(purchaseOrderEntityDto.getFreightFeeIncludeTax());
		}

		if (purchaseOrderEntityDto.getFreightFeeValue() != null) {
			this.setFreightFeeValue(purchaseOrderEntityDto.getFreightFeeValue());
		}

		if (purchaseOrderEntityDto.getOtherFeeIncludeTax() != null) {
			this.setOtherFeeIncludeTax(purchaseOrderEntityDto.getOtherFeeIncludeTax());
		}

		if (purchaseOrderEntityDto.getOtherFeeValue() != null) {
			this.setOtherFeeValue(purchaseOrderEntityDto.getOtherFeeValue());
		}

		if (purchaseOrderEntityDto.getTaxBase() != null) {
			this.setTaxBase(purchaseOrderEntityDto.getTaxBase());
		}

		if (purchaseOrderEntityDto.getTaxAmount() != null) {
			this.setTaxAmount(purchaseOrderEntityDto.getTaxAmount());
		}

		if (purchaseOrderEntityDto.getTotalAmount() != null) {
			this.setTotalAmount(purchaseOrderEntityDto.getTotalAmount());
		}

		if (purchaseOrderEntityDto.getPurchaseOrderStockDetails() != null) {
			this.setPurchaseOrderStockDetails(purchaseOrderEntityDto.getPurchaseOrderStockDetails());
		}

		if (purchaseOrderEntityDto.getPurchaseRequisitions() != null) {
			this.setPurchaseRequisitions(purchaseOrderEntityDto.getPurchaseRequisitions());
		}

		if (purchaseOrderEntityDto.getReturnSuppliers() != null) {
			this.setReturnSuppliers(purchaseOrderEntityDto.getReturnSuppliers());
		}

		if (purchaseOrderEntityDto.getGoodsReceiveNote() != null) {
			this.setGoodsReceiveNote(purchaseOrderEntityDto.getGoodsReceiveNote());
		}

		if (purchaseOrderEntityDto.getSupplier() != null) {
			this.setSupplier(purchaseOrderEntityDto.getSupplier());
		}

		if (purchaseOrderEntityDto.getWarehouse() != null) {
			this.setWarehouse(purchaseOrderEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Purchase Order Type here] off begin
	@CsvBindByName(column = "PURCHASE_ORDER_TYPE", required = false)
	@Nullable
	@Column(name = "purchase_order_type")
	@Schema(description = "The Purchase Order Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Order Type here] end
	private String purchaseOrderType;

	// % protected region % [Modify attribute annotation for Purchase Order Number here] off begin
	@CsvBindByName(column = "PURCHASE_ORDER_NUMBER", required = false)
	@Nullable
	@Column(name = "purchase_order_number")
	@Schema(description = "The Purchase Order Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Order Number here] end
	private String purchaseOrderNumber;

	// % protected region % [Modify attribute annotation for status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@CsvBindByName(column = "SUPPLY_STOCK_GROUP", required = false)
	@Nullable
	@Column(name = "supply_stock_group")
	@Schema(description = "The Supply Stock Group of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

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

	// % protected region % [Modify attribute annotation for Price VAT Included here] off begin
	@CsvBindByName(column = "PRICE_VAT_INCLUDED", required = false)
	@Nullable
	@Column(name = "price_vat_included")
	@Schema(description = "The Price VAT Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price VAT Included here] end
	private Boolean priceVATIncluded = false ;

	// % protected region % [Modify attribute annotation for Inventory VAT Included here] off begin
	@CsvBindByName(column = "INVENTORY_VAT_INCLUDED", required = false)
	@Nullable
	@Column(name = "inventory_vat_included")
	@Schema(description = "The Inventory VAT Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory VAT Included here] end
	private Boolean inventoryVATIncluded = false ;

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@CsvBindByName(column = "REFERENCE_DOCUMENT", required = false)
	@Nullable
	@Column(name = "reference_document")
	@Schema(description = "The Reference Document of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Supplier Reference Document here] off begin
	@CsvBindByName(column = "SUPPLIER_REFERENCE_DOCUMENT", required = false)
	@Nullable
	@Column(name = "supplier_reference_document")
	@Schema(description = "The Supplier Reference Document of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Reference Document here] end
	private String supplierReferenceDocument;

	// % protected region % [Modify attribute annotation for Payment Terms here] off begin
	@CsvBindByName(column = "PAYMENT_TERMS", required = false)
	@Nullable
	@Column(name = "payment_terms")
	@Schema(description = "The Payment Terms of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Terms here] end
	private String paymentTerms;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@CsvBindByName(column = "SHIPPING_METHOD", required = false)
	@Nullable
	@Column(name = "shipping_method")
	@Schema(description = "The Shipping Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@CsvBindByName(column = "SUB_TOTAL", required = false)
	@Nullable
	@Column(name = "sub_total")
	@Schema(description = "The Sub Total of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Extra Discount In Percent here] off begin
	@CsvBindByName(column = "EXTRA_DISCOUNT_IN_PERCENT", required = false)
	@Nullable
	@Column(name = "extra_discount_in_percent")
	@Schema(description = "The Extra Discount In Percent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Extra Discount In Percent here] end
	private Boolean extraDiscountInPercent = false ;

	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] off begin
	@CsvBindByName(column = "EXTRA_DISCOUNT_INCLUDE_TAX", required = false)
	@Nullable
	@Column(name = "extra_discount_include_tax")
	@Schema(description = "The Extra Discount Include Tax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] end
	private Boolean extraDiscountIncludeTax = false ;

	// % protected region % [Modify attribute annotation for Extra Discount Value here] off begin
	@CsvBindByName(column = "EXTRA_DISCOUNT_VALUE", required = false)
	@Nullable
	@Column(name = "extra_discount_value")
	@Schema(description = "The Extra Discount Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Extra Discount Value here] end
	private Double extraDiscountValue;

	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] off begin
	@CsvBindByName(column = "FREIGHT_FEE_INCLUDE_TAX", required = false)
	@Nullable
	@Column(name = "freight_fee_include_tax")
	@Schema(description = "The Freight Fee Include Tax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] end
	private Boolean freightFeeIncludeTax = false ;

	// % protected region % [Modify attribute annotation for Freight Fee Value here] off begin
	@CsvBindByName(column = "FREIGHT_FEE_VALUE", required = false)
	@Nullable
	@Column(name = "freight_fee_value")
	@Schema(description = "The Freight Fee Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Freight Fee Value here] end
	private Double freightFeeValue;

	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] off begin
	@CsvBindByName(column = "OTHER_FEE_INCLUDE_TAX", required = false)
	@Nullable
	@Column(name = "other_fee_include_tax")
	@Schema(description = "The Other Fee Include Tax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] end
	private Boolean otherFeeIncludeTax = false ;

	// % protected region % [Modify attribute annotation for Other Fee Value here] off begin
	@CsvBindByName(column = "OTHER_FEE_VALUE", required = false)
	@Nullable
	@Column(name = "other_fee_value")
	@Schema(description = "The Other Fee Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Fee Value here] end
	private Double otherFeeValue;

	// % protected region % [Modify attribute annotation for Tax Base here] off begin
	@CsvBindByName(column = "TAX_BASE", required = false)
	@Nullable
	@Column(name = "tax_base")
	@Schema(description = "The Tax Base of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Base here] end
	private Double taxBase;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@CsvBindByName(column = "TAX_AMOUNT", required = false)
	@Nullable
	@Column(name = "tax_amount")
	@Schema(description = "The Tax Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

	// % protected region % [Modify attribute annotation for Total Amount here] off begin
	@CsvBindByName(column = "TOTAL_AMOUNT", required = false)
	@Nullable
	@Column(name = "total_amount")
	@Schema(description = "The Total Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Amount here] end
	private Double totalAmount;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Purchase Order Stock Details here] off begin
	@Schema(description = "The Purchase Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order Stock Details here] end
	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] end
	private Set<UUID> purchaseOrderStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Requisitions here] off begin
	@Schema(description = "The Purchase Requisition entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Requisitions here] end
	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	// % protected region % [Update the annotation for purchaseRequisitionsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_REQUISITIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseRequisitionsIds here] end
	private Set<UUID> purchaseRequisitionsIds = new HashSet<>();

	// % protected region % [Update the annotation for Return Suppliers here] off begin
	@Schema(description = "The Return Supplier entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Return Suppliers here] end
	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	// % protected region % [Update the annotation for returnSuppliersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETURN_SUPPLIERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for returnSuppliersIds here] end
	private Set<UUID> returnSuppliersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note here] off begin
	@Schema(description = "The Goods Receive Note entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note here] end
	private GoodsReceiveNoteEntity goodsReceiveNote;

	// % protected region % [Update the annotation for goodsReceiveNoteId here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteId here] end
	private UUID goodsReceiveNoteId;

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
	 * Similar to {@link this#addPurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity) {
		addPurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseOrderStockDetailEntity to purchaseOrderStockDetails in this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrderStockDetails.contains(entity)) {
			purchaseOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		addPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderStockDetailEntity to Purchase Order Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity) {
		this.removePurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.purchaseOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		this.removePurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		setPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrderStockDetails();
		this.purchaseOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrderStockDetails() {
		this.unsetPurchaseOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetPurchaseOrder(false));
		}
		this.purchaseOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NotNull PurchaseRequisitionEntity entity) {
		addPurchaseRequisitions(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionEntity to purchaseRequisitions in this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitions.contains(entity)) {
			purchaseRequisitions.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NotNull Collection<PurchaseRequisitionEntity> entities) {
		addPurchaseRequisitions(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionEntity to Purchase Requisitions in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void removePurchaseRequisitions(@NotNull PurchaseRequisitionEntity entity) {
		this.removePurchaseRequisitions(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitions(@NotNull PurchaseRequisitionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.purchaseRequisitions.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 */
	public void removePurchaseRequisitions(@NotNull Collection<PurchaseRequisitionEntity> entities) {
		this.removePurchaseRequisitions(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisitions(@NotNull Collection<PurchaseRequisitionEntity> entities) {
		setPurchaseRequisitions(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisitions with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitions(@NotNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitions();
		this.purchaseRequisitions = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitions() {
		this.unsetPurchaseRequisitions(true);
	}

	/**
	 * Remove all the entities in Purchase Requisitions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitions(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.unsetPurchaseOrder(false));
		}
		this.purchaseRequisitions.clear();
	}

/**
	 * Similar to {@link this#addReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NotNull ReturnSupplierEntity entity) {
		addReturnSuppliers(entity, true);
	}

	/**
	 * Add a new ReturnSupplierEntity to returnSuppliers in this entity.
	 *
	 * @param entity the given ReturnSupplierEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverseAdd) {
		if (!this.returnSuppliers.contains(entity)) {
			returnSuppliers.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NotNull Collection<ReturnSupplierEntity> entities) {
		addReturnSuppliers(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierEntity to Return Suppliers in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void removeReturnSuppliers(@NotNull ReturnSupplierEntity entity) {
		this.removeReturnSuppliers(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSuppliers(@NotNull ReturnSupplierEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrder(false);
		}
		this.returnSuppliers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 */
	public void removeReturnSuppliers(@NotNull Collection<ReturnSupplierEntity> entities) {
		this.removeReturnSuppliers(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSuppliers(@NotNull Collection<ReturnSupplierEntity> entities) {
		setReturnSuppliers(entities, true);
	}

	/**
	 * Replace the current entities in Return Suppliers with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSuppliers(@NotNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {

		this.unsetReturnSuppliers();
		this.returnSuppliers = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.setPurchaseOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSuppliers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSuppliers() {
		this.unsetReturnSuppliers(true);
	}

	/**
	 * Remove all the entities in Return Suppliers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSuppliers(boolean doReverse) {
		if (doReverse) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.unsetPurchaseOrder(false));
		}
		this.returnSuppliers.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setGoodsReceiveNote(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNote(@NotNull GoodsReceiveNoteEntity entity) {
		setGoodsReceiveNote(entity, true);
	}

	/**
	 * Set or update the goodsReceiveNote in this entity with single GoodsReceiveNoteEntity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set or updated to goodsReceiveNote
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setGoodsReceiveNote(@NotNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] off begin
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] end

		if (sameAsFormer(this.goodsReceiveNote, entity)) {
			return;
		}

		if (this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removePurchaseOrders(this, false);
		}
		this.goodsReceiveNote = entity;
		if (reverseAdd) {
			this.goodsReceiveNote.addPurchaseOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNote(boolean)} but default to true.
	 */
	public void unsetGoodsReceiveNote() {
		this.unsetGoodsReceiveNote(true);
	}

	/**
	 * Remove Goods Receive Note in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetGoodsReceiveNote(boolean reverse) {
		if (reverse && this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removePurchaseOrders(this, false);
		}
		this.goodsReceiveNote = null;
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
			this.supplier.removePurchaseOrders(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addPurchaseOrders(this, false);
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
			this.supplier.removePurchaseOrders(this, false);
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
			this.warehouse.removePurchaseOrders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addPurchaseOrders(this, false);
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
			this.warehouse.removePurchaseOrders(this, false);
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
		return "PURCHASE_ORDER_TYPE,PURCHASE_ORDER_NUMBER,STATUS,SUPPLY_STOCK_GROUP,ORDER_DATE,EXPECTED_DATE,PRICE_VAT_INCLUDED,INVENTORY_VAT_INCLUDED,REFERENCE_DOCUMENT,SUPPLIER_REFERENCE_DOCUMENT,PAYMENT_TERMS,SHIPPING_METHOD,NOTES,SUB_TOTAL,EXTRA_DISCOUNT_IN_PERCENT,EXTRA_DISCOUNT_INCLUDE_TAX,EXTRA_DISCOUNT_VALUE,FREIGHT_FEE_INCLUDE_TAX,FREIGHT_FEE_VALUE,OTHER_FEE_INCLUDE_TAX,OTHER_FEE_VALUE,TAX_BASE,TAX_AMOUNT,TOTAL_AMOUNT,GOODS_RECEIVE_NOTE_ID,SUPPLIER_ID,WAREHOUSE_ID,PURCHASE_ORDER_STOCK_DETAILS_IDS,PURCHASE_REQUISITIONS_IDS,RETURN_SUPPLIERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<GoodsReceiveNoteEntity> goodsReceiveNoteRelation = Optional.ofNullable(this.goodsReceiveNote);
		goodsReceiveNoteRelation.ifPresent(entity -> this.goodsReceiveNoteId = entity.getId());

		Optional<SupplierEntity> supplierRelation = Optional.ofNullable(this.supplier);
		supplierRelation.ifPresent(entity -> this.supplierId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.purchaseOrderStockDetailsIds = new HashSet<>();
		for (PurchaseOrderStockDetailEntity purchaseOrderStockDetails: this.purchaseOrderStockDetails) {
			this.purchaseOrderStockDetailsIds.add(purchaseOrderStockDetails.getId());
		}

		this.purchaseRequisitionsIds = new HashSet<>();
		for (PurchaseRequisitionEntity purchaseRequisitions: this.purchaseRequisitions) {
			this.purchaseRequisitionsIds.add(purchaseRequisitions.getId());
		}

		this.returnSuppliersIds = new HashSet<>();
		for (ReturnSupplierEntity returnSuppliers: this.returnSuppliers) {
			this.returnSuppliersIds.add(returnSuppliers.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object purchaseOrder) {
		if (this == purchaseOrder) {
			return true;
		}
		if (purchaseOrder == null || this.getClass() != purchaseOrder.getClass()) {
			return false;
		}
		if (!super.equals(purchaseOrder)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PurchaseOrderEntity that = (PurchaseOrderEntity) purchaseOrder;
		return
			Objects.equals(this.purchaseOrderType, that.purchaseOrderType) &&
			Objects.equals(this.purchaseOrderNumber, that.purchaseOrderNumber) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.supplyStockGroup, that.supplyStockGroup) &&
			Objects.equals(
			     this.orderDate != null ? this.orderDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.orderDate != null ? that.orderDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.expectedDate != null ? this.expectedDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expectedDate != null ? that.expectedDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.priceVATIncluded, that.priceVATIncluded) &&
			Objects.equals(this.inventoryVATIncluded, that.inventoryVATIncluded) &&
			Objects.equals(this.referenceDocument, that.referenceDocument) &&
			Objects.equals(this.supplierReferenceDocument, that.supplierReferenceDocument) &&
			Objects.equals(this.paymentTerms, that.paymentTerms) &&
			Objects.equals(this.shippingMethod, that.shippingMethod) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.subTotal, that.subTotal) &&
			Objects.equals(this.extraDiscountInPercent, that.extraDiscountInPercent) &&
			Objects.equals(this.extraDiscountIncludeTax, that.extraDiscountIncludeTax) &&
			Objects.equals(this.extraDiscountValue, that.extraDiscountValue) &&
			Objects.equals(this.freightFeeIncludeTax, that.freightFeeIncludeTax) &&
			Objects.equals(this.freightFeeValue, that.freightFeeValue) &&
			Objects.equals(this.otherFeeIncludeTax, that.otherFeeIncludeTax) &&
			Objects.equals(this.otherFeeValue, that.otherFeeValue) &&
			Objects.equals(this.taxBase, that.taxBase) &&
			Objects.equals(this.taxAmount, that.taxAmount) &&
			Objects.equals(this.totalAmount, that.totalAmount) &&
			Objects.equals(this.purchaseOrderStockDetailsIds, that.purchaseOrderStockDetailsIds) &&
			Objects.equals(this.purchaseRequisitionsIds, that.purchaseRequisitionsIds) &&
			Objects.equals(this.returnSuppliersIds, that.returnSuppliersIds) &&
			Objects.equals(this.goodsReceiveNoteId, that.goodsReceiveNoteId) &&
			Objects.equals(this.supplierId, that.supplierId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
