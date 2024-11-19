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
import kmsweb.dtos.ReturnSupplierEntityDto;
import kmsweb.entities.listeners.ReturnSupplierEntityListener;
import kmsweb.serializers.ReturnSupplierSerializer;
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
@EntityListeners({ReturnSupplierEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ReturnSupplierSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ReturnSupplierEntity extends AbstractEntity {

	/**
	 * Takes a ReturnSupplierEntityDto and converts it into a ReturnSupplierEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param returnSupplierEntityDto
	 */
	public ReturnSupplierEntity(ReturnSupplierEntityDto returnSupplierEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (returnSupplierEntityDto.getId() != null) {
			this.setId(returnSupplierEntityDto.getId());
		}

		if (returnSupplierEntityDto.getReturnNumber() != null) {
			this.setReturnNumber(returnSupplierEntityDto.getReturnNumber());
		}

		if (returnSupplierEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(returnSupplierEntityDto.getApprovalStatus());
		}

		if (returnSupplierEntityDto.getReturnDate() != null) {
			this.setReturnDate(returnSupplierEntityDto.getReturnDate());
		}

		if (returnSupplierEntityDto.getOrderDate() != null) {
			this.setOrderDate(returnSupplierEntityDto.getOrderDate());
		}

		if (returnSupplierEntityDto.getNotes() != null) {
			this.setNotes(returnSupplierEntityDto.getNotes());
		}

		if (returnSupplierEntityDto.getInvoiceReturnNumber() != null) {
			this.setInvoiceReturnNumber(returnSupplierEntityDto.getInvoiceReturnNumber());
		}

		if (returnSupplierEntityDto.getTaxInvoiceNumber() != null) {
			this.setTaxInvoiceNumber(returnSupplierEntityDto.getTaxInvoiceNumber());
		}

		if (returnSupplierEntityDto.getPriceVATIncluded() != null) {
			this.setPriceVATIncluded(returnSupplierEntityDto.getPriceVATIncluded());
		}

		if (returnSupplierEntityDto.getVoidDate() != null) {
			this.setVoidDate(returnSupplierEntityDto.getVoidDate());
		}

		if (returnSupplierEntityDto.getVoidReason() != null) {
			this.setVoidReason(returnSupplierEntityDto.getVoidReason());
		}

		if (returnSupplierEntityDto.getSubTotal() != null) {
			this.setSubTotal(returnSupplierEntityDto.getSubTotal());
		}

		if (returnSupplierEntityDto.getExtraDiscountInPercentage() != null) {
			this.setExtraDiscountInPercentage(returnSupplierEntityDto.getExtraDiscountInPercentage());
		}

		if (returnSupplierEntityDto.getExtraDiscountIncludeTax() != null) {
			this.setExtraDiscountIncludeTax(returnSupplierEntityDto.getExtraDiscountIncludeTax());
		}

		if (returnSupplierEntityDto.getExtraDiscountValue() != null) {
			this.setExtraDiscountValue(returnSupplierEntityDto.getExtraDiscountValue());
		}

		if (returnSupplierEntityDto.getFreightFeeIncludeTax() != null) {
			this.setFreightFeeIncludeTax(returnSupplierEntityDto.getFreightFeeIncludeTax());
		}

		if (returnSupplierEntityDto.getFreightFeeValue() != null) {
			this.setFreightFeeValue(returnSupplierEntityDto.getFreightFeeValue());
		}

		if (returnSupplierEntityDto.getOtherFeeIncludeTax() != null) {
			this.setOtherFeeIncludeTax(returnSupplierEntityDto.getOtherFeeIncludeTax());
		}

		if (returnSupplierEntityDto.getOtherFeeValue() != null) {
			this.setOtherFeeValue(returnSupplierEntityDto.getOtherFeeValue());
		}

		if (returnSupplierEntityDto.getTaxBase() != null) {
			this.setTaxBase(returnSupplierEntityDto.getTaxBase());
		}

		if (returnSupplierEntityDto.getTaxAmount() != null) {
			this.setTaxAmount(returnSupplierEntityDto.getTaxAmount());
		}

		if (returnSupplierEntityDto.getTotalAmount() != null) {
			this.setTotalAmount(returnSupplierEntityDto.getTotalAmount());
		}

		if (returnSupplierEntityDto.getReturnSupplierStockDetails() != null) {
			this.setReturnSupplierStockDetails(returnSupplierEntityDto.getReturnSupplierStockDetails());
		}

		if (returnSupplierEntityDto.getPurchaseOrder() != null) {
			this.setPurchaseOrder(returnSupplierEntityDto.getPurchaseOrder());
		}

		if (returnSupplierEntityDto.getSupplier() != null) {
			this.setSupplier(returnSupplierEntityDto.getSupplier());
		}

		if (returnSupplierEntityDto.getWarehouse() != null) {
			this.setWarehouse(returnSupplierEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Return Number here] off begin
	@CsvBindByName(column = "RETURN_NUMBER", required = false)
	@Nullable
	@Column(name = "return_number")
	@Schema(description = "The Return Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Return Number here] end
	private String returnNumber;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Return Date here] off begin
	@CsvCustomBindByName(column = "RETURN_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "return_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Return Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Return Date here] end
	private OffsetDateTime returnDate;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@CsvCustomBindByName(column = "ORDER_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "order_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Order Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Invoice Return Number here] off begin
	@CsvBindByName(column = "INVOICE_RETURN_NUMBER", required = false)
	@Nullable
	@Column(name = "invoice_return_number")
	@Schema(description = "The Invoice Return Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Return Number here] end
	private String invoiceReturnNumber;

	// % protected region % [Modify attribute annotation for Tax Invoice Number here] off begin
	@CsvBindByName(column = "TAX_INVOICE_NUMBER", required = false)
	@Nullable
	@Column(name = "tax_invoice_number")
	@Schema(description = "The Tax Invoice Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Invoice Number here] end
	private String taxInvoiceNumber;

	// % protected region % [Modify attribute annotation for Price VAT Included here] off begin
	@CsvBindByName(column = "PRICE_VAT_INCLUDED", required = false)
	@Nullable
	@Column(name = "price_vat_included")
	@Schema(description = "The Price VAT Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price VAT Included here] end
	private Boolean priceVATIncluded = false ;

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

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@CsvBindByName(column = "SUB_TOTAL", required = false)
	@Nullable
	@Column(name = "sub_total")
	@Schema(description = "The Sub Total of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Extra Discount In Percentage here] off begin
	@CsvBindByName(column = "EXTRA_DISCOUNT_IN_PERCENTAGE", required = false)
	@Nullable
	@Column(name = "extra_discount_in_percentage")
	@Schema(description = "The Extra Discount In Percentage of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Extra Discount In Percentage here] end
	private Boolean extraDiscountInPercentage = false ;

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

	// % protected region % [Update the annotation for Return Supplier Stock Details here] off begin
	@Schema(description = "The Return Supplier Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "returnSupplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Return Supplier Stock Details here] end
	private Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for returnSupplierStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETURN_SUPPLIER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for returnSupplierStockDetailsIds here] end
	private Set<UUID> returnSupplierStockDetailsIds = new HashSet<>();

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
	 * Similar to {@link this#addReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity) {
		addReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Add a new ReturnSupplierStockDetailEntity to returnSupplierStockDetails in this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverseAdd) {
		if (!this.returnSupplierStockDetails.contains(entity)) {
			returnSupplierStockDetails.add(entity);
			if (reverseAdd) {
				entity.setReturnSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		addReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierStockDetailEntity to Return Supplier Stock Details in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity) {
		this.removeReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierStockDetailEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetReturnSupplier(false);
		}
		this.returnSupplierStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		this.removeReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void setReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		setReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Return Supplier Stock Details with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetReturnSupplierStockDetails();
		this.returnSupplierStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.setReturnSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSupplierStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSupplierStockDetails() {
		this.unsetReturnSupplierStockDetails(true);
	}

	/**
	 * Remove all the entities in Return Supplier Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSupplierStockDetails(boolean doReverse) {
		if (doReverse) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.unsetReturnSupplier(false));
		}
		this.returnSupplierStockDetails.clear();
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
			this.purchaseOrder.removeReturnSuppliers(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addReturnSuppliers(this, false);
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
			this.purchaseOrder.removeReturnSuppliers(this, false);
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
			this.supplier.removeReturnSuppliers(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addReturnSuppliers(this, false);
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
			this.supplier.removeReturnSuppliers(this, false);
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
			this.warehouse.removeReturnSuppliers(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addReturnSuppliers(this, false);
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
			this.warehouse.removeReturnSuppliers(this, false);
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
		return "RETURN_NUMBER,APPROVAL_STATUS,RETURN_DATE,ORDER_DATE,NOTES,INVOICE_RETURN_NUMBER,TAX_INVOICE_NUMBER,PRICE_VAT_INCLUDED,VOID_DATE,VOID_REASON,SUB_TOTAL,EXTRA_DISCOUNT_IN_PERCENTAGE,EXTRA_DISCOUNT_INCLUDE_TAX,EXTRA_DISCOUNT_VALUE,FREIGHT_FEE_INCLUDE_TAX,FREIGHT_FEE_VALUE,OTHER_FEE_INCLUDE_TAX,OTHER_FEE_VALUE,TAX_BASE,TAX_AMOUNT,TOTAL_AMOUNT,PURCHASE_ORDER_ID,SUPPLIER_ID,WAREHOUSE_ID,RETURN_SUPPLIER_STOCK_DETAILS_IDS,ID";
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

		this.returnSupplierStockDetailsIds = new HashSet<>();
		for (ReturnSupplierStockDetailEntity returnSupplierStockDetails: this.returnSupplierStockDetails) {
			this.returnSupplierStockDetailsIds.add(returnSupplierStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object returnSupplier) {
		if (this == returnSupplier) {
			return true;
		}
		if (returnSupplier == null || this.getClass() != returnSupplier.getClass()) {
			return false;
		}
		if (!super.equals(returnSupplier)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ReturnSupplierEntity that = (ReturnSupplierEntity) returnSupplier;
		return
			Objects.equals(this.returnNumber, that.returnNumber) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(
			     this.returnDate != null ? this.returnDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.returnDate != null ? that.returnDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.orderDate != null ? this.orderDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.orderDate != null ? that.orderDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.invoiceReturnNumber, that.invoiceReturnNumber) &&
			Objects.equals(this.taxInvoiceNumber, that.taxInvoiceNumber) &&
			Objects.equals(this.priceVATIncluded, that.priceVATIncluded) &&
			Objects.equals(
			     this.voidDate != null ? this.voidDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.voidDate != null ? that.voidDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.voidReason, that.voidReason) &&
			Objects.equals(this.subTotal, that.subTotal) &&
			Objects.equals(this.extraDiscountInPercentage, that.extraDiscountInPercentage) &&
			Objects.equals(this.extraDiscountIncludeTax, that.extraDiscountIncludeTax) &&
			Objects.equals(this.extraDiscountValue, that.extraDiscountValue) &&
			Objects.equals(this.freightFeeIncludeTax, that.freightFeeIncludeTax) &&
			Objects.equals(this.freightFeeValue, that.freightFeeValue) &&
			Objects.equals(this.otherFeeIncludeTax, that.otherFeeIncludeTax) &&
			Objects.equals(this.otherFeeValue, that.otherFeeValue) &&
			Objects.equals(this.taxBase, that.taxBase) &&
			Objects.equals(this.taxAmount, that.taxAmount) &&
			Objects.equals(this.totalAmount, that.totalAmount) &&
			Objects.equals(this.returnSupplierStockDetailsIds, that.returnSupplierStockDetailsIds) &&
			Objects.equals(this.purchaseOrderId, that.purchaseOrderId) &&
			Objects.equals(this.supplierId, that.supplierId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
