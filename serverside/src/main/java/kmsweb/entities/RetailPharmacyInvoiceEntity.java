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
import kmsweb.dtos.RetailPharmacyInvoiceEntityDto;
import kmsweb.entities.listeners.RetailPharmacyInvoiceEntityListener;
import kmsweb.serializers.RetailPharmacyInvoiceSerializer;
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
@EntityListeners({RetailPharmacyInvoiceEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RetailPharmacyInvoiceSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class RetailPharmacyInvoiceEntity extends AbstractEntity {

	/**
	 * Takes a RetailPharmacyInvoiceEntityDto and converts it into a RetailPharmacyInvoiceEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param retailPharmacyInvoiceEntityDto
	 */
	public RetailPharmacyInvoiceEntity(RetailPharmacyInvoiceEntityDto retailPharmacyInvoiceEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (retailPharmacyInvoiceEntityDto.getId() != null) {
			this.setId(retailPharmacyInvoiceEntityDto.getId());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceNumber() != null) {
			this.setInvoiceNumber(retailPharmacyInvoiceEntityDto.getInvoiceNumber());
		}

		if (retailPharmacyInvoiceEntityDto.getRevisionNumber() != null) {
			this.setRevisionNumber(retailPharmacyInvoiceEntityDto.getRevisionNumber());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceStatus() != null) {
			this.setInvoiceStatus(retailPharmacyInvoiceEntityDto.getInvoiceStatus());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceDate() != null) {
			this.setInvoiceDate(retailPharmacyInvoiceEntityDto.getInvoiceDate());
		}

		if (retailPharmacyInvoiceEntityDto.getCancelDate() != null) {
			this.setCancelDate(retailPharmacyInvoiceEntityDto.getCancelDate());
		}

		if (retailPharmacyInvoiceEntityDto.getBillingLocation() != null) {
			this.setBillingLocation(retailPharmacyInvoiceEntityDto.getBillingLocation());
		}

		if (retailPharmacyInvoiceEntityDto.getNotes() != null) {
			this.setNotes(retailPharmacyInvoiceEntityDto.getNotes());
		}

		if (retailPharmacyInvoiceEntityDto.getPatientPaymentType() != null) {
			this.setPatientPaymentType(retailPharmacyInvoiceEntityDto.getPatientPaymentType());
		}

		if (retailPharmacyInvoiceEntityDto.getVerificationDate() != null) {
			this.setVerificationDate(retailPharmacyInvoiceEntityDto.getVerificationDate());
		}

		if (retailPharmacyInvoiceEntityDto.getDisplayDoctorOnPrint() != null) {
			this.setDisplayDoctorOnPrint(retailPharmacyInvoiceEntityDto.getDisplayDoctorOnPrint());
		}

		if (retailPharmacyInvoiceEntityDto.getClaimNo() != null) {
			this.setClaimNo(retailPharmacyInvoiceEntityDto.getClaimNo());
		}

		if (retailPharmacyInvoiceEntityDto.getPaymentStatus() != null) {
			this.setPaymentStatus(retailPharmacyInvoiceEntityDto.getPaymentStatus());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceAmount() != null) {
			this.setInvoiceAmount(retailPharmacyInvoiceEntityDto.getInvoiceAmount());
		}

		if (retailPharmacyInvoiceEntityDto.getOutstandingAmount() != null) {
			this.setOutstandingAmount(retailPharmacyInvoiceEntityDto.getOutstandingAmount());
		}

		if (retailPharmacyInvoiceEntityDto.getCustomerName() != null) {
			this.setCustomerName(retailPharmacyInvoiceEntityDto.getCustomerName());
		}

		if (retailPharmacyInvoiceEntityDto.getCashReceipts() != null) {
			this.setCashReceipts(retailPharmacyInvoiceEntityDto.getCashReceipts());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(retailPharmacyInvoiceEntityDto.getInvoiceItems());
		}

		if (retailPharmacyInvoiceEntityDto.getInvoiceSummary() != null) {
			this.setInvoiceSummary(retailPharmacyInvoiceEntityDto.getInvoiceSummary());
		}

		if (retailPharmacyInvoiceEntityDto.getRetailPharmacy() != null) {
			this.setRetailPharmacy(retailPharmacyInvoiceEntityDto.getRetailPharmacy());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@CsvBindByName(column = "INVOICE_NUMBER", required = false)
	@Nullable
	@Column(name = "invoice_number")
	@Schema(description = "The Invoice Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

	// % protected region % [Modify attribute annotation for Revision Number here] off begin
	@CsvBindByName(column = "REVISION_NUMBER", required = false)
	@Nullable
	@Column(name = "revision_number")
	@Schema(description = "The Revision Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revision Number here] end
	private Integer revisionNumber;

	// % protected region % [Modify attribute annotation for Invoice Status here] off begin
	@CsvBindByName(column = "INVOICE_STATUS", required = false)
	@Nullable
	@Column(name = "invoice_status")
	@Schema(description = "The Invoice Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Status here] end
	private String invoiceStatus;

	// % protected region % [Modify attribute annotation for Invoice Date here] off begin
	@CsvCustomBindByName(column = "INVOICE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "invoice_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Invoice Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Date here] end
	private OffsetDateTime invoiceDate;

	// % protected region % [Modify attribute annotation for Cancel Date here] off begin
	@CsvCustomBindByName(column = "CANCEL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "cancel_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Cancel Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cancel Date here] end
	private OffsetDateTime cancelDate;

	// % protected region % [Modify attribute annotation for Billing Location here] off begin
	@CsvBindByName(column = "BILLING_LOCATION", required = false)
	@Nullable
	@Column(name = "billing_location")
	@Schema(description = "The Billing Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Billing Location here] end
	private String billingLocation;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@CsvBindByName(column = "PATIENT_PAYMENT_TYPE", required = false)
	@Nullable
	@Column(name = "patient_payment_type")
	@Schema(description = "The Patient Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Verification Date here] off begin
	@CsvCustomBindByName(column = "VERIFICATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "verification_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Verification Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Verification Date here] end
	private OffsetDateTime verificationDate;

	// % protected region % [Modify attribute annotation for Display Doctor on Print here] off begin
	@CsvBindByName(column = "DISPLAY_DOCTOR_ON_PRINT", required = false)
	@Nullable
	@Column(name = "display_doctor_on_print")
	@Schema(description = "The Display Doctor on Print of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Display Doctor on Print here] end
	private Boolean displayDoctorOnPrint = false ;

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@CsvBindByName(column = "CLAIM_NO", required = false)
	@Nullable
	@Column(name = "claim_no")
	@Schema(description = "The Claim No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	// % protected region % [Modify attribute annotation for Payment Status here] off begin
	@CsvBindByName(column = "PAYMENT_STATUS", required = false)
	@Nullable
	@Column(name = "payment_status")
	@Schema(description = "The Payment Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Status here] end
	private String paymentStatus;

	// % protected region % [Modify attribute annotation for Invoice Amount here] off begin
	@CsvBindByName(column = "INVOICE_AMOUNT", required = false)
	@Nullable
	@Column(name = "invoice_amount")
	@Schema(description = "The Invoice Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Invoice Amount here] end
	private Double invoiceAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@CsvBindByName(column = "OUTSTANDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "outstanding_amount")
	@Schema(description = "The Outstanding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@CsvBindByName(column = "CUSTOMER_NAME", required = false)
	@Nullable
	@Column(name = "customer_name")
	@Schema(description = "The Customer Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Cash Receipts here] off begin
	@Schema(description = "The Cash Receipt entities that are related to this entity.")
	@OneToMany(mappedBy = "retailPharmacyInvoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cash Receipts here] end
	private Set<CashReceiptEntity> cashReceipts = new HashSet<>();

	// % protected region % [Update the annotation for cashReceiptsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASH_RECEIPTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for cashReceiptsIds here] end
	private Set<UUID> cashReceiptsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "retailPharmacyInvoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice Summary here] off begin
	@Schema(description = "The Invoice Summary entities that are related to this entity.")
	@OneToOne(mappedBy = "retailPharmacyInvoice", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Summary here] end
	private InvoiceSummaryEntity invoiceSummary;

	// % protected region % [Update the annotation for invoiceSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceSummaryId here] end
	private UUID invoiceSummaryId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Retail Pharmacy here] off begin
	@Schema(description = "The Retail Pharmacy entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy here] end
	private RetailPharmacyEntity retailPharmacy;

	// % protected region % [Update the annotation for retailPharmacyId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for retailPharmacyId here] end
	private UUID retailPharmacyId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NotNull CashReceiptEntity entity) {
		addCashReceipts(entity, true);
	}

	/**
	 * Add a new CashReceiptEntity to cashReceipts in this entity.
	 *
	 * @param entity the given CashReceiptEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCashReceipts(@NonNull CashReceiptEntity entity, boolean reverseAdd) {
		if (!this.cashReceipts.contains(entity)) {
			cashReceipts.add(entity);
			if (reverseAdd) {
				entity.setRetailPharmacyInvoice(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCashReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		addCashReceipts(entities, true);
	}

	/**
	 * Add a new collection of CashReceiptEntity to Cash Receipts in this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCashReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be set to this entity
	 */
	public void removeCashReceipts(@NotNull CashReceiptEntity entity) {
		this.removeCashReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashReceipts(@NotNull CashReceiptEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRetailPharmacyInvoice(false);
		}
		this.cashReceipts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCashReceipts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 */
	public void removeCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		this.removeCashReceipts(entities, true);
	}

	/**
	 * Remove the given collection of CashReceiptEntity from  to this entity.
	 *
	 * @param entities the given collection of CashReceiptEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCashReceipts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCashReceipts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CashReceiptEntity to be set to this entity
	 */
	public void setCashReceipts(@NotNull Collection<CashReceiptEntity> entities) {
		setCashReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Cash Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashReceipts(@NotNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

		this.unsetCashReceipts();
		this.cashReceipts = new HashSet<>(entities);
		if (reverseAdd) {
			this.cashReceipts.forEach(cashReceiptsEntity -> cashReceiptsEntity.setRetailPharmacyInvoice(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCashReceipts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCashReceipts() {
		this.unsetCashReceipts(true);
	}

	/**
	 * Remove all the entities in Cash Receipts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCashReceipts(boolean doReverse) {
		if (doReverse) {
			this.cashReceipts.forEach(cashReceiptsEntity -> cashReceiptsEntity.unsetRetailPharmacyInvoice(false));
		}
		this.cashReceipts.clear();
	}

/**
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setRetailPharmacyInvoice(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetRetailPharmacyInvoice(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setRetailPharmacyInvoice(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetRetailPharmacyInvoice(false));
		}
		this.invoiceItems.clear();
	}

	/**
	 * Similar to {@link this#setInvoiceSummary(InvoiceSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setInvoiceSummary(@NotNull InvoiceSummaryEntity entity) {
		setInvoiceSummary(entity, true);
	}

	/**
	 * Set or update invoiceSummary with the given InvoiceSummaryEntity.
	 *
	 * @param entity the RetailPharmacyInvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoiceSummary(@NotNull InvoiceSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoiceSummary here] end

		if (sameAsFormer(this.invoiceSummary, entity)) {
			return;
		}

		if (this.invoiceSummary != null) {
			this.invoiceSummary.unsetRetailPharmacyInvoice();
		}

		this.invoiceSummary = entity;

		if (reverseAdd) {
			this.invoiceSummary.setRetailPharmacyInvoice(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoiceSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoiceSummary(boolean)} but default to true.
	 */
	public void unsetInvoiceSummary() {
		this.unsetInvoiceSummary(true);
	}

	/**
	 * Remove the InvoiceSummaryEntity in Invoice Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoiceSummary(boolean reverse) {
		if (reverse && this.invoiceSummary != null) {
			this.invoiceSummary.unsetRetailPharmacyInvoice(false);
		}
		this.invoiceSummary = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRetailPharmacy(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacy(@NotNull RetailPharmacyEntity entity) {
		setRetailPharmacy(entity, true);
	}

	/**
	 * Set or update the retailPharmacy in this entity with single RetailPharmacyEntity.
	 *
	 * @param entity the given RetailPharmacyEntity to be set or updated to retailPharmacy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacy(@NotNull RetailPharmacyEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] end

		if (sameAsFormer(this.retailPharmacy, entity)) {
			return;
		}

		if (this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyInvoices(this, false);
		}
		this.retailPharmacy = entity;
		if (reverseAdd) {
			this.retailPharmacy.addRetailPharmacyInvoices(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacy(boolean)} but default to true.
	 */
	public void unsetRetailPharmacy() {
		this.unsetRetailPharmacy(true);
	}

	/**
	 * Remove Retail Pharmacy in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacy(boolean reverse) {
		if (reverse && this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyInvoices(this, false);
		}
		this.retailPharmacy = null;
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
		return "INVOICE_NUMBER,REVISION_NUMBER,INVOICE_STATUS,INVOICE_DATE,CANCEL_DATE,BILLING_LOCATION,NOTES,PATIENT_PAYMENT_TYPE,VERIFICATION_DATE,DISPLAY_DOCTOR_ON_PRINT,CLAIM_NO,PAYMENT_STATUS,INVOICE_AMOUNT,OUTSTANDING_AMOUNT,CUSTOMER_NAME,RETAIL_PHARMACY_ID,CASH_RECEIPTS_IDS,INVOICE_ITEMS_IDS,INVOICE_SUMMARY_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<RetailPharmacyEntity> retailPharmacyRelation = Optional.ofNullable(this.retailPharmacy);
		retailPharmacyRelation.ifPresent(entity -> this.retailPharmacyId = entity.getId());

		this.cashReceiptsIds = new HashSet<>();
		for (CashReceiptEntity cashReceipts: this.cashReceipts) {
			this.cashReceiptsIds.add(cashReceipts.getId());
		}

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		Optional<InvoiceSummaryEntity> invoiceSummaryRelation = Optional.ofNullable(this.invoiceSummary);
		invoiceSummaryRelation.ifPresent(entity -> this.invoiceSummaryId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object retailPharmacyInvoice) {
		if (this == retailPharmacyInvoice) {
			return true;
		}
		if (retailPharmacyInvoice == null || this.getClass() != retailPharmacyInvoice.getClass()) {
			return false;
		}
		if (!super.equals(retailPharmacyInvoice)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RetailPharmacyInvoiceEntity that = (RetailPharmacyInvoiceEntity) retailPharmacyInvoice;
		return
			Objects.equals(this.invoiceNumber, that.invoiceNumber) &&
			Objects.equals(this.revisionNumber, that.revisionNumber) &&
			Objects.equals(this.invoiceStatus, that.invoiceStatus) &&
			Objects.equals(
			     this.invoiceDate != null ? this.invoiceDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.invoiceDate != null ? that.invoiceDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.cancelDate != null ? this.cancelDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.cancelDate != null ? that.cancelDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.billingLocation, that.billingLocation) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientPaymentType, that.patientPaymentType) &&
			Objects.equals(
			     this.verificationDate != null ? this.verificationDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.verificationDate != null ? that.verificationDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.displayDoctorOnPrint, that.displayDoctorOnPrint) &&
			Objects.equals(this.claimNo, that.claimNo) &&
			Objects.equals(this.paymentStatus, that.paymentStatus) &&
			Objects.equals(this.invoiceAmount, that.invoiceAmount) &&
			Objects.equals(this.outstandingAmount, that.outstandingAmount) &&
			Objects.equals(this.customerName, that.customerName) &&
			Objects.equals(this.cashReceiptsIds, that.cashReceiptsIds) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.invoiceSummaryId, that.invoiceSummaryId) &&
			Objects.equals(this.retailPharmacyId, that.retailPharmacyId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
