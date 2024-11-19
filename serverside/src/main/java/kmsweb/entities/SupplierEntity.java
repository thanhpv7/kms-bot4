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
import kmsweb.dtos.SupplierEntityDto;
import kmsweb.entities.listeners.SupplierEntityListener;
import kmsweb.serializers.SupplierSerializer;
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
@EntityListeners({SupplierEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SupplierSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"supplier_number"}, name = "supplier_number"),
	}
)
public class SupplierEntity extends AbstractEntity {

	/**
	 * Takes a SupplierEntityDto and converts it into a SupplierEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param supplierEntityDto
	 */
	public SupplierEntity(SupplierEntityDto supplierEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (supplierEntityDto.getId() != null) {
			this.setId(supplierEntityDto.getId());
		}

		if (supplierEntityDto.getSupplierNumber() != null) {
			this.setSupplierNumber(supplierEntityDto.getSupplierNumber());
		}

		if (supplierEntityDto.getSupplierName() != null) {
			this.setSupplierName(supplierEntityDto.getSupplierName());
		}

		if (supplierEntityDto.getTaxID() != null) {
			this.setTaxID(supplierEntityDto.getTaxID());
		}

		if (supplierEntityDto.getSupplyStockGroup() != null) {
			this.setSupplyStockGroup(supplierEntityDto.getSupplyStockGroup());
		}

		if (supplierEntityDto.getAdress() != null) {
			this.setAdress(supplierEntityDto.getAdress());
		}

		if (supplierEntityDto.getCountry() != null) {
			this.setCountry(supplierEntityDto.getCountry());
		}

		if (supplierEntityDto.getStateProvince() != null) {
			this.setStateProvince(supplierEntityDto.getStateProvince());
		}

		if (supplierEntityDto.getCity() != null) {
			this.setCity(supplierEntityDto.getCity());
		}

		if (supplierEntityDto.getPostalCode() != null) {
			this.setPostalCode(supplierEntityDto.getPostalCode());
		}

		if (supplierEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(supplierEntityDto.getPhoneNumber());
		}

		if (supplierEntityDto.getOtherPhoneNumber() != null) {
			this.setOtherPhoneNumber(supplierEntityDto.getOtherPhoneNumber());
		}

		if (supplierEntityDto.getFax() != null) {
			this.setFax(supplierEntityDto.getFax());
		}

		if (supplierEntityDto.getEmail() != null) {
			this.setEmail(supplierEntityDto.getEmail());
		}

		if (supplierEntityDto.getWebsite() != null) {
			this.setWebsite(supplierEntityDto.getWebsite());
		}

		if (supplierEntityDto.getNotes() != null) {
			this.setNotes(supplierEntityDto.getNotes());
		}

		if (supplierEntityDto.getPurchaseOrderHold() != null) {
			this.setPurchaseOrderHold(supplierEntityDto.getPurchaseOrderHold());
		}

		if (supplierEntityDto.getPurchaseOrderHoldReason() != null) {
			this.setPurchaseOrderHoldReason(supplierEntityDto.getPurchaseOrderHoldReason());
		}

		if (supplierEntityDto.getVatIncluded() != null) {
			this.setVatIncluded(supplierEntityDto.getVatIncluded());
		}

		if (supplierEntityDto.getShippingMethod() != null) {
			this.setShippingMethod(supplierEntityDto.getShippingMethod());
		}

		if (supplierEntityDto.getLeadTimeMinimum() != null) {
			this.setLeadTimeMinimum(supplierEntityDto.getLeadTimeMinimum());
		}

		if (supplierEntityDto.getLeadTimeMaximum() != null) {
			this.setLeadTimeMaximum(supplierEntityDto.getLeadTimeMaximum());
		}

		if (supplierEntityDto.getLastPurchaseDate() != null) {
			this.setLastPurchaseDate(supplierEntityDto.getLastPurchaseDate());
		}

		if (supplierEntityDto.getLastPurchaseOrderNumber() != null) {
			this.setLastPurchaseOrderNumber(supplierEntityDto.getLastPurchaseOrderNumber());
		}

		if (supplierEntityDto.getLeadTimeMeasurement() != null) {
			this.setLeadTimeMeasurement(supplierEntityDto.getLeadTimeMeasurement());
		}

		if (supplierEntityDto.getGoodsReceiveNotes() != null) {
			this.setGoodsReceiveNotes(supplierEntityDto.getGoodsReceiveNotes());
		}

		if (supplierEntityDto.getPurchaseOrders() != null) {
			this.setPurchaseOrders(supplierEntityDto.getPurchaseOrders());
		}

		if (supplierEntityDto.getPurchaseRequisitions() != null) {
			this.setPurchaseRequisitions(supplierEntityDto.getPurchaseRequisitions());
		}

		if (supplierEntityDto.getReturnSuppliers() != null) {
			this.setReturnSuppliers(supplierEntityDto.getReturnSuppliers());
		}

		if (supplierEntityDto.getSuplierContactDetails() != null) {
			this.setSuplierContactDetails(supplierEntityDto.getSuplierContactDetails());
		}

		if (supplierEntityDto.getSupplierBankAccounts() != null) {
			this.setSupplierBankAccounts(supplierEntityDto.getSupplierBankAccounts());
		}

		if (supplierEntityDto.getSupplierProductDetails() != null) {
			this.setSupplierProductDetails(supplierEntityDto.getSupplierProductDetails());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Supplier Number here] off begin
	@CsvBindByName(column = "SUPPLIER_NUMBER", required = true)
	@NotNull(message = "Supplier Number must not be empty")
	@Column(name = "supplier_number")
	@Schema(description = "The Supplier Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Number here] end
	private String supplierNumber;

	// % protected region % [Modify attribute annotation for Supplier Name here] off begin
	@CsvBindByName(column = "SUPPLIER_NAME", required = true)
	@NotNull(message = "Supplier Name must not be empty")
	@Column(name = "supplier_name")
	@Schema(description = "The Supplier Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supplier Name here] end
	private String supplierName;

	// % protected region % [Modify attribute annotation for Tax ID here] off begin
	@CsvBindByName(column = "TAX_ID", required = false)
	@Nullable
	@Column(name = "tax_id")
	@Schema(description = "The Tax ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax ID here] end
	private String taxID;

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@CsvBindByName(column = "SUPPLY_STOCK_GROUP", required = true)
	@NotNull(message = "Supply Stock Group must not be empty")
	@Column(name = "supply_stock_group")
	@Schema(description = "The Supply Stock Group of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

	// % protected region % [Modify attribute annotation for Adress here] off begin
	@CsvBindByName(column = "ADRESS", required = true)
	@NotNull(message = "Adress must not be empty")
	@Column(name = "adress")
	@Schema(description = "The Adress of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Adress here] end
	private String adress;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@CsvBindByName(column = "COUNTRY", required = false)
	@Nullable
	@Column(name = "country")
	@Schema(description = "The Country of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for State Province here] off begin
	@CsvBindByName(column = "STATE_PROVINCE", required = false)
	@Nullable
	@Column(name = "state_province")
	@Schema(description = "The State Province of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for State Province here] end
	private String stateProvince;

	// % protected region % [Modify attribute annotation for City here] off begin
	@CsvBindByName(column = "CITY", required = false)
	@Nullable
	@Column(name = "city")
	@Schema(description = "The City of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Postal Code here] off begin
	@CsvBindByName(column = "POSTAL_CODE", required = false)
	@Nullable
	@Column(name = "postal_code")
	@Schema(description = "The Postal Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postal Code here] end
	private String postalCode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = true)
	@NotNull(message = "Phone Number must not be empty")
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Other Phone Number here] off begin
	@CsvBindByName(column = "OTHER_PHONE_NUMBER", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "other_phone_number")
	@Schema(description = "The Other Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Phone Number here] end
	private String otherPhoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@CsvBindByName(column = "FAX", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "fax")
	@Schema(description = "The Fax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Email
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@CsvBindByName(column = "WEBSITE", required = false)
	@Nullable
	@Column(name = "website")
	@Schema(description = "The Website of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Purchase Order Hold here] off begin
	@CsvBindByName(column = "PURCHASE_ORDER_HOLD", required = false)
	@Nullable
	@Column(name = "purchase_order_hold")
	@Schema(description = "The Purchase Order Hold of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Order Hold here] end
	private Boolean purchaseOrderHold = false ;

	// % protected region % [Modify attribute annotation for Purchase Order Hold Reason here] off begin
	@CsvBindByName(column = "PURCHASE_ORDER_HOLD_REASON", required = false)
	@Nullable
	@Column(name = "purchase_order_hold_reason")
	@Schema(description = "The Purchase Order Hold Reason of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Order Hold Reason here] end
	private String purchaseOrderHoldReason;

	// % protected region % [Modify attribute annotation for VAT Included here] off begin
	@CsvBindByName(column = "VAT_INCLUDED", required = false)
	@Nullable
	@Column(name = "vat_included")
	@Schema(description = "The VAT Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for VAT Included here] end
	private Boolean vatIncluded = false ;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@CsvBindByName(column = "SHIPPING_METHOD", required = false)
	@Nullable
	@Column(name = "shipping_method")
	@Schema(description = "The Shipping Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Lead Time Minimum here] off begin
	@CsvBindByName(column = "LEAD_TIME_MINIMUM", required = false)
	@Nullable
	@Column(name = "lead_time_minimum")
	@Schema(description = "The Lead Time Minimum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lead Time Minimum here] end
	private Double leadTimeMinimum;

	// % protected region % [Modify attribute annotation for Lead Time Maximum here] off begin
	@CsvBindByName(column = "LEAD_TIME_MAXIMUM", required = false)
	@Nullable
	@Column(name = "lead_time_maximum")
	@Schema(description = "The Lead Time Maximum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lead Time Maximum here] end
	private Double leadTimeMaximum;

	// % protected region % [Modify attribute annotation for Last Purchase Date here] off begin
	@CsvCustomBindByName(column = "LAST_PURCHASE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "last_purchase_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Last Purchase Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Purchase Date here] end
	private OffsetDateTime lastPurchaseDate;

	// % protected region % [Modify attribute annotation for Last Purchase Order Number here] off begin
	@CsvBindByName(column = "LAST_PURCHASE_ORDER_NUMBER", required = false)
	@Nullable
	@Column(name = "last_purchase_order_number")
	@Schema(description = "The Last Purchase Order Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Purchase Order Number here] end
	private String lastPurchaseOrderNumber;

	// % protected region % [Modify attribute annotation for Lead Time Measurement here] off begin
	@CsvBindByName(column = "LEAD_TIME_MEASUREMENT", required = false)
	@Nullable
	@Column(name = "lead_time_measurement")
	@Schema(description = "The Lead Time Measurement of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lead Time Measurement here] end
	private String leadTimeMeasurement;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Notes here] off begin
	@Schema(description = "The Goods Receive Note entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Notes here] end
	private Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNotesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNotesIds here] end
	private Set<UUID> goodsReceiveNotesIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Orders here] off begin
	@Schema(description = "The Purchase Order entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Orders here] end
	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	// % protected region % [Update the annotation for purchaseOrdersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseOrdersIds here] end
	private Set<UUID> purchaseOrdersIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Requisitions here] off begin
	@Schema(description = "The Purchase Requisition entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
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
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Return Suppliers here] end
	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	// % protected region % [Update the annotation for returnSuppliersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETURN_SUPPLIERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for returnSuppliersIds here] end
	private Set<UUID> returnSuppliersIds = new HashSet<>();

	// % protected region % [Update the annotation for Suplier Contact Details here] off begin
	@Schema(description = "The Supplier Contact Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Suplier Contact Details here] end
	private Set<SupplierContactDetailEntity> suplierContactDetails = new HashSet<>();

	// % protected region % [Update the annotation for suplierContactDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPLIER_CONTACT_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for suplierContactDetailsIds here] end
	private Set<UUID> suplierContactDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Supplier Bank Accounts here] off begin
	@Schema(description = "The Supplier Bank Account entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier Bank Accounts here] end
	private Set<SupplierBankAccountEntity> supplierBankAccounts = new HashSet<>();

	// % protected region % [Update the annotation for supplierBankAccountsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_BANK_ACCOUNTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for supplierBankAccountsIds here] end
	private Set<UUID> supplierBankAccountsIds = new HashSet<>();

	// % protected region % [Update the annotation for Supplier Product Details here] off begin
	@Schema(description = "The Supplier Product Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "supplier", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier Product Details here] end
	private Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();

	// % protected region % [Update the annotation for supplierProductDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_PRODUCT_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for supplierProductDetailsIds here] end
	private Set<UUID> supplierProductDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NotNull GoodsReceiveNoteEntity entity) {
		addGoodsReceiveNotes(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteEntity to goodsReceiveNotes in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNotes.contains(entity)) {
			goodsReceiveNotes.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NotNull Collection<GoodsReceiveNoteEntity> entities) {
		addGoodsReceiveNotes(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteEntity to Goods Receive Notes in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void removeGoodsReceiveNotes(@NotNull GoodsReceiveNoteEntity entity) {
		this.removeGoodsReceiveNotes(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNotes(@NotNull GoodsReceiveNoteEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.goodsReceiveNotes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNotes(@NotNull Collection<GoodsReceiveNoteEntity> entities) {
		this.removeGoodsReceiveNotes(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNotes(@NotNull Collection<GoodsReceiveNoteEntity> entities) {
		setGoodsReceiveNotes(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Notes with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNotes(@NotNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNotes();
		this.goodsReceiveNotes = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNotes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNotes() {
		this.unsetGoodsReceiveNotes(true);
	}

	/**
	 * Remove all the entities in Goods Receive Notes from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNotes(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.unsetSupplier(false));
		}
		this.goodsReceiveNotes.clear();
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
				entity.setSupplier(this, false);
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
			entity.unsetSupplier(false);
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
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.setSupplier(this, false));
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
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.unsetSupplier(false));
		}
		this.purchaseOrders.clear();
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
				entity.setSupplier(this, false);
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
			entity.unsetSupplier(false);
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
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.setSupplier(this, false));
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
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.unsetSupplier(false));
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
				entity.setSupplier(this, false);
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
			entity.unsetSupplier(false);
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
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.setSupplier(this, false));
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
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.unsetSupplier(false));
		}
		this.returnSuppliers.clear();
	}

/**
	 * Similar to {@link this#addSuplierContactDetails(SupplierContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierContactDetailEntity to be added to this entity
	 */
	public void addSuplierContactDetails(@NotNull SupplierContactDetailEntity entity) {
		addSuplierContactDetails(entity, true);
	}

	/**
	 * Add a new SupplierContactDetailEntity to suplierContactDetails in this entity.
	 *
	 * @param entity the given SupplierContactDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSuplierContactDetails(@NonNull SupplierContactDetailEntity entity, boolean reverseAdd) {
		if (!this.suplierContactDetails.contains(entity)) {
			suplierContactDetails.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be added to this entity
	 */
	public void addSuplierContactDetails(@NotNull Collection<SupplierContactDetailEntity> entities) {
		addSuplierContactDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierContactDetailEntity to Suplier Contact Details in this entity.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSuplierContactDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSuplierContactDetails(SupplierContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierContactDetailEntity to be set to this entity
	 */
	public void removeSuplierContactDetails(@NotNull SupplierContactDetailEntity entity) {
		this.removeSuplierContactDetails(entity, true);
	}

	/**
	 * Remove the given SupplierContactDetailEntity from this entity.
	 *
	 * @param entity the given SupplierContactDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSuplierContactDetails(@NotNull SupplierContactDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.suplierContactDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be removed to this entity
	 */
	public void removeSuplierContactDetails(@NotNull Collection<SupplierContactDetailEntity> entities) {
		this.removeSuplierContactDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierContactDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSuplierContactDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be set to this entity
	 */
	public void setSuplierContactDetails(@NotNull Collection<SupplierContactDetailEntity> entities) {
		setSuplierContactDetails(entities, true);
	}

	/**
	 * Replace the current entities in Suplier Contact Details with the given ones.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSuplierContactDetails(@NotNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {

		this.unsetSuplierContactDetails();
		this.suplierContactDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.suplierContactDetails.forEach(suplierContactDetailsEntity -> suplierContactDetailsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSuplierContactDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSuplierContactDetails() {
		this.unsetSuplierContactDetails(true);
	}

	/**
	 * Remove all the entities in Suplier Contact Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSuplierContactDetails(boolean doReverse) {
		if (doReverse) {
			this.suplierContactDetails.forEach(suplierContactDetailsEntity -> suplierContactDetailsEntity.unsetSupplier(false));
		}
		this.suplierContactDetails.clear();
	}

/**
	 * Similar to {@link this#addSupplierBankAccounts(SupplierBankAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierBankAccountEntity to be added to this entity
	 */
	public void addSupplierBankAccounts(@NotNull SupplierBankAccountEntity entity) {
		addSupplierBankAccounts(entity, true);
	}

	/**
	 * Add a new SupplierBankAccountEntity to supplierBankAccounts in this entity.
	 *
	 * @param entity the given SupplierBankAccountEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierBankAccounts(@NonNull SupplierBankAccountEntity entity, boolean reverseAdd) {
		if (!this.supplierBankAccounts.contains(entity)) {
			supplierBankAccounts.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be added to this entity
	 */
	public void addSupplierBankAccounts(@NotNull Collection<SupplierBankAccountEntity> entities) {
		addSupplierBankAccounts(entities, true);
	}

	/**
	 * Add a new collection of SupplierBankAccountEntity to Supplier Bank Accounts in this entity.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierBankAccounts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierBankAccounts(SupplierBankAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierBankAccountEntity to be set to this entity
	 */
	public void removeSupplierBankAccounts(@NotNull SupplierBankAccountEntity entity) {
		this.removeSupplierBankAccounts(entity, true);
	}

	/**
	 * Remove the given SupplierBankAccountEntity from this entity.
	 *
	 * @param entity the given SupplierBankAccountEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierBankAccounts(@NotNull SupplierBankAccountEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.supplierBankAccounts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be removed to this entity
	 */
	public void removeSupplierBankAccounts(@NotNull Collection<SupplierBankAccountEntity> entities) {
		this.removeSupplierBankAccounts(entities, true);
	}

	/**
	 * Remove the given collection of SupplierBankAccountEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierBankAccounts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be set to this entity
	 */
	public void setSupplierBankAccounts(@NotNull Collection<SupplierBankAccountEntity> entities) {
		setSupplierBankAccounts(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Bank Accounts with the given ones.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierBankAccounts(@NotNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {

		this.unsetSupplierBankAccounts();
		this.supplierBankAccounts = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierBankAccounts.forEach(supplierBankAccountsEntity -> supplierBankAccountsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierBankAccounts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierBankAccounts() {
		this.unsetSupplierBankAccounts(true);
	}

	/**
	 * Remove all the entities in Supplier Bank Accounts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierBankAccounts(boolean doReverse) {
		if (doReverse) {
			this.supplierBankAccounts.forEach(supplierBankAccountsEntity -> supplierBankAccountsEntity.unsetSupplier(false));
		}
		this.supplierBankAccounts.clear();
	}

/**
	 * Similar to {@link this#addSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NotNull SupplierProductDetailEntity entity) {
		addSupplierProductDetails(entity, true);
	}

	/**
	 * Add a new SupplierProductDetailEntity to supplierProductDetails in this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverseAdd) {
		if (!this.supplierProductDetails.contains(entity)) {
			supplierProductDetails.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		addSupplierProductDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierProductDetailEntity to Supplier Product Details in this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be set to this entity
	 */
	public void removeSupplierProductDetails(@NotNull SupplierProductDetailEntity entity) {
		this.removeSupplierProductDetails(entity, true);
	}

	/**
	 * Remove the given SupplierProductDetailEntity from this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierProductDetails(@NotNull SupplierProductDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.supplierProductDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 */
	public void removeSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		this.removeSupplierProductDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierProductDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be set to this entity
	 */
	public void setSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		setSupplierProductDetails(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Product Details with the given ones.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {

		this.unsetSupplierProductDetails();
		this.supplierProductDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierProductDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierProductDetails() {
		this.unsetSupplierProductDetails(true);
	}

	/**
	 * Remove all the entities in Supplier Product Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierProductDetails(boolean doReverse) {
		if (doReverse) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.unsetSupplier(false));
		}
		this.supplierProductDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "SUPPLIER_NUMBER,SUPPLIER_NAME,TAX_ID,SUPPLY_STOCK_GROUP,ADRESS,COUNTRY,STATE_PROVINCE,CITY,POSTAL_CODE,PHONE_NUMBER,OTHER_PHONE_NUMBER,FAX,EMAIL,WEBSITE,NOTES,PURCHASE_ORDER_HOLD,PURCHASE_ORDER_HOLD_REASON,VAT_INCLUDED,SHIPPING_METHOD,LEAD_TIME_MINIMUM,LEAD_TIME_MAXIMUM,LAST_PURCHASE_DATE,LAST_PURCHASE_ORDER_NUMBER,LEAD_TIME_MEASUREMENT,GOODS_RECEIVE_NOTES_IDS,PURCHASE_ORDERS_IDS,PURCHASE_REQUISITIONS_IDS,RETURN_SUPPLIERS_IDS,SUPLIER_CONTACT_DETAILS_IDS,SUPPLIER_BANK_ACCOUNTS_IDS,SUPPLIER_PRODUCT_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.goodsReceiveNotesIds = new HashSet<>();
		for (GoodsReceiveNoteEntity goodsReceiveNotes: this.goodsReceiveNotes) {
			this.goodsReceiveNotesIds.add(goodsReceiveNotes.getId());
		}

		this.purchaseOrdersIds = new HashSet<>();
		for (PurchaseOrderEntity purchaseOrders: this.purchaseOrders) {
			this.purchaseOrdersIds.add(purchaseOrders.getId());
		}

		this.purchaseRequisitionsIds = new HashSet<>();
		for (PurchaseRequisitionEntity purchaseRequisitions: this.purchaseRequisitions) {
			this.purchaseRequisitionsIds.add(purchaseRequisitions.getId());
		}

		this.returnSuppliersIds = new HashSet<>();
		for (ReturnSupplierEntity returnSuppliers: this.returnSuppliers) {
			this.returnSuppliersIds.add(returnSuppliers.getId());
		}

		this.suplierContactDetailsIds = new HashSet<>();
		for (SupplierContactDetailEntity suplierContactDetails: this.suplierContactDetails) {
			this.suplierContactDetailsIds.add(suplierContactDetails.getId());
		}

		this.supplierBankAccountsIds = new HashSet<>();
		for (SupplierBankAccountEntity supplierBankAccounts: this.supplierBankAccounts) {
			this.supplierBankAccountsIds.add(supplierBankAccounts.getId());
		}

		this.supplierProductDetailsIds = new HashSet<>();
		for (SupplierProductDetailEntity supplierProductDetails: this.supplierProductDetails) {
			this.supplierProductDetailsIds.add(supplierProductDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object supplier) {
		if (this == supplier) {
			return true;
		}
		if (supplier == null || this.getClass() != supplier.getClass()) {
			return false;
		}
		if (!super.equals(supplier)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SupplierEntity that = (SupplierEntity) supplier;
		return
			Objects.equals(this.supplierNumber, that.supplierNumber) &&
			Objects.equals(this.supplierName, that.supplierName) &&
			Objects.equals(this.taxID, that.taxID) &&
			Objects.equals(this.supplyStockGroup, that.supplyStockGroup) &&
			Objects.equals(this.adress, that.adress) &&
			Objects.equals(this.country, that.country) &&
			Objects.equals(this.stateProvince, that.stateProvince) &&
			Objects.equals(this.city, that.city) &&
			Objects.equals(this.postalCode, that.postalCode) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.otherPhoneNumber, that.otherPhoneNumber) &&
			Objects.equals(this.fax, that.fax) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.website, that.website) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.purchaseOrderHold, that.purchaseOrderHold) &&
			Objects.equals(this.purchaseOrderHoldReason, that.purchaseOrderHoldReason) &&
			Objects.equals(this.vatIncluded, that.vatIncluded) &&
			Objects.equals(this.shippingMethod, that.shippingMethod) &&
			Objects.equals(this.leadTimeMinimum, that.leadTimeMinimum) &&
			Objects.equals(this.leadTimeMaximum, that.leadTimeMaximum) &&
			Objects.equals(
			     this.lastPurchaseDate != null ? this.lastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lastPurchaseDate != null ? that.lastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.lastPurchaseOrderNumber, that.lastPurchaseOrderNumber) &&
			Objects.equals(this.leadTimeMeasurement, that.leadTimeMeasurement) &&
			Objects.equals(this.goodsReceiveNotesIds, that.goodsReceiveNotesIds) &&
			Objects.equals(this.purchaseOrdersIds, that.purchaseOrdersIds) &&
			Objects.equals(this.purchaseRequisitionsIds, that.purchaseRequisitionsIds) &&
			Objects.equals(this.returnSuppliersIds, that.returnSuppliersIds) &&
			Objects.equals(this.suplierContactDetailsIds, that.suplierContactDetailsIds) &&
			Objects.equals(this.supplierBankAccountsIds, that.supplierBankAccountsIds) &&
			Objects.equals(this.supplierProductDetailsIds, that.supplierProductDetailsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
