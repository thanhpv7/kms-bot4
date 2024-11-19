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
import kmsweb.dtos.CashReceiptEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.CashReceiptEntityListener;
import kmsweb.serializers.CashReceiptSerializer;
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
@EntityListeners({CashReceiptEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CashReceiptSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CashReceiptEntity extends AbstractEntity {

	/**
	 * Takes a CashReceiptEntityDto and converts it into a CashReceiptEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param cashReceiptEntityDto
	 */
	public CashReceiptEntity(CashReceiptEntityDto cashReceiptEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (cashReceiptEntityDto.getId() != null) {
			this.setId(cashReceiptEntityDto.getId());
		}

		if (cashReceiptEntityDto.getReceiptType() != null) {
			this.setReceiptType(cashReceiptEntityDto.getReceiptType());
		}

		if (cashReceiptEntityDto.getReceiptNumber() != null) {
			this.setReceiptNumber(cashReceiptEntityDto.getReceiptNumber());
		}

		if (cashReceiptEntityDto.getPaymentDate() != null) {
			this.setPaymentDate(cashReceiptEntityDto.getPaymentDate());
		}

		if (cashReceiptEntityDto.getDescription() != null) {
			this.setDescription(cashReceiptEntityDto.getDescription());
		}

		if (cashReceiptEntityDto.getPaymentType() != null) {
			this.setPaymentType(cashReceiptEntityDto.getPaymentType());
		}

		if (cashReceiptEntityDto.getReceiveAmount() != null) {
			this.setReceiveAmount(cashReceiptEntityDto.getReceiveAmount());
		}

		if (cashReceiptEntityDto.getIsvoid() != null) {
			this.setIsvoid(cashReceiptEntityDto.getIsvoid());
		}

		if (cashReceiptEntityDto.getCashierLocation() != null) {
			this.setCashierLocation(cashReceiptEntityDto.getCashierLocation());
		}

		if (cashReceiptEntityDto.getVoidDateTime() != null) {
			this.setVoidDateTime(cashReceiptEntityDto.getVoidDateTime());
		}

		if (cashReceiptEntityDto.getCashChangeType() != null) {
			this.setCashChangeType(cashReceiptEntityDto.getCashChangeType());
		}

		if (cashReceiptEntityDto.getChangeAmount() != null) {
			this.setChangeAmount(cashReceiptEntityDto.getChangeAmount());
		}

		if (cashReceiptEntityDto.getAllocatedAmount() != null) {
			this.setAllocatedAmount(cashReceiptEntityDto.getAllocatedAmount());
		}

		if (cashReceiptEntityDto.getRoundingAmount() != null) {
			this.setRoundingAmount(cashReceiptEntityDto.getRoundingAmount());
		}

		if (cashReceiptEntityDto.getAvailableAmount() != null) {
			this.setAvailableAmount(cashReceiptEntityDto.getAvailableAmount());
		}

		if (cashReceiptEntityDto.getBankName() != null) {
			this.setBankName(cashReceiptEntityDto.getBankName());
		}

		if (cashReceiptEntityDto.getCardType() != null) {
			this.setCardType(cashReceiptEntityDto.getCardType());
		}

		if (cashReceiptEntityDto.getCardNo() != null) {
			this.setCardNo(cashReceiptEntityDto.getCardNo());
		}

		if (cashReceiptEntityDto.getCardHolder() != null) {
			this.setCardHolder(cashReceiptEntityDto.getCardHolder());
		}

		if (cashReceiptEntityDto.getReferenceNumber() != null) {
			this.setReferenceNumber(cashReceiptEntityDto.getReferenceNumber());
		}

		if (cashReceiptEntityDto.getHospitalBankAccount() != null) {
			this.setHospitalBankAccount(cashReceiptEntityDto.getHospitalBankAccount());
		}

		if (cashReceiptEntityDto.getSurchargeAmount() != null) {
			this.setSurchargeAmount(cashReceiptEntityDto.getSurchargeAmount());
		}

		if (cashReceiptEntityDto.getOutstandingAmount() != null) {
			this.setOutstandingAmount(cashReceiptEntityDto.getOutstandingAmount());
		}

		if (cashReceiptEntityDto.getReceivedFrom() != null) {
			this.setReceivedFrom(cashReceiptEntityDto.getReceivedFrom());
		}

		if (cashReceiptEntityDto.getPatientOrCustomerName() != null) {
			this.setPatientOrCustomerName(cashReceiptEntityDto.getPatientOrCustomerName());
		}

		if (cashReceiptEntityDto.getMerchant() != null) {
			this.setMerchant(cashReceiptEntityDto.getMerchant());
		}

		if (cashReceiptEntityDto.getRetailPharmacyInvoice() != null) {
			this.setRetailPharmacyInvoice(cashReceiptEntityDto.getRetailPharmacyInvoice());
		}

		if (cashReceiptEntityDto.getCashierStaff() != null) {
			this.setCashierStaff(cashReceiptEntityDto.getCashierStaff());
		}

		if (cashReceiptEntityDto.getPatient() != null) {
			this.setPatient(cashReceiptEntityDto.getPatient());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Receipt Type here] off begin
	@CsvCustomBindByName(column = "RECEIPT_TYPE", required = true, converter = ReceiptTypeEnumConverter.class)
	@NotNull(message = "Receipt Type must not be empty")
	@Column(name = "receipt_type")
	@Schema(description = "The Receipt Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Receipt Type here] end
	private ReceiptTypeEnum receiptType;

	// % protected region % [Modify attribute annotation for Receipt Number here] off begin
	@CsvBindByName(column = "RECEIPT_NUMBER", required = false)
	@Nullable
	@Column(name = "receipt_number")
	@Schema(description = "The Receipt Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Receipt Number here] end
	private String receiptNumber;

	// % protected region % [Modify attribute annotation for Payment Date here] off begin
	@CsvCustomBindByName(column = "PAYMENT_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Payment Date must not be empty")
	@Column(name = "payment_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Payment Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Date here] end
	private OffsetDateTime paymentDate;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Payment Type here] off begin
	@CsvBindByName(column = "PAYMENT_TYPE", required = false)
	@Nullable
	@Column(name = "payment_type")
	@Schema(description = "The Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Type here] end
	private String paymentType;

	// % protected region % [Modify attribute annotation for Receive Amount here] off begin
	@CsvBindByName(column = "RECEIVE_AMOUNT", required = false)
	@Nullable
	@Column(name = "receive_amount")
	@Schema(description = "The Receive Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Receive Amount here] end
	private Double receiveAmount;

	// % protected region % [Modify attribute annotation for IsVoid here] off begin
	@CsvBindByName(column = "ISVOID", required = false)
	@Nullable
	@Column(name = "isvoid")
	@Schema(description = "The IsVoid of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for IsVoid here] end
	private Boolean isvoid = false ;

	// % protected region % [Modify attribute annotation for Cashier Location here] off begin
	@CsvBindByName(column = "CASHIER_LOCATION", required = true)
	@NotNull(message = "Cashier Location must not be empty")
	@Column(name = "cashier_location")
	@Schema(description = "The Cashier Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cashier Location here] end
	private String cashierLocation;

	// % protected region % [Modify attribute annotation for Void Date Time here] off begin
	@CsvCustomBindByName(column = "VOID_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "void_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Void Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Void Date Time here] end
	private OffsetDateTime voidDateTime;

	// % protected region % [Modify attribute annotation for Cash Change Type here] off begin
	@CsvCustomBindByName(column = "CASH_CHANGE_TYPE", required = false, converter = CashChangeTypeEnumConverter.class)
	@Nullable
	@Column(name = "cash_change_type")
	@Schema(description = "The Cash Change Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Cash Change Type here] end
	private CashChangeTypeEnum cashChangeType;

	// % protected region % [Modify attribute annotation for Change Amount here] off begin
	@CsvBindByName(column = "CHANGE_AMOUNT", required = false)
	@Nullable
	@Column(name = "change_amount")
	@Schema(description = "The Change Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Change Amount here] end
	private Double changeAmount;

	// % protected region % [Modify attribute annotation for Allocated Amount here] off begin
	@CsvBindByName(column = "ALLOCATED_AMOUNT", required = false)
	@Nullable
	@Column(name = "allocated_amount")
	@Schema(description = "The Allocated Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Allocated Amount here] end
	private Double allocatedAmount;

	// % protected region % [Modify attribute annotation for Rounding Amount here] off begin
	@CsvBindByName(column = "ROUNDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "rounding_amount")
	@Schema(description = "The Rounding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rounding Amount here] end
	private Double roundingAmount;

	// % protected region % [Modify attribute annotation for Available Amount here] off begin
	@CsvBindByName(column = "AVAILABLE_AMOUNT", required = false)
	@Nullable
	@Column(name = "available_amount")
	@Schema(description = "The Available Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Amount here] end
	private Double availableAmount;

	// % protected region % [Modify attribute annotation for Bank Name here] off begin
	@CsvBindByName(column = "BANK_NAME", required = false)
	@Nullable
	@Column(name = "bank_name")
	@Schema(description = "The Bank Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bank Name here] end
	private String bankName;

	// % protected region % [Modify attribute annotation for Card Type here] off begin
	@CsvBindByName(column = "CARD_TYPE", required = false)
	@Nullable
	@Column(name = "card_type")
	@Schema(description = "The Card Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Card Type here] end
	private String cardType;

	// % protected region % [Modify attribute annotation for Card No here] off begin
	@CsvBindByName(column = "CARD_NO", required = false)
	@Nullable
	@Column(name = "card_no")
	@Schema(description = "The Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Card No here] end
	private String cardNo;

	// % protected region % [Modify attribute annotation for Card Holder here] off begin
	@CsvBindByName(column = "CARD_HOLDER", required = false)
	@Nullable
	@Column(name = "card_holder")
	@Schema(description = "The Card Holder of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Card Holder here] end
	private String cardHolder;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@CsvBindByName(column = "REFERENCE_NUMBER", required = false)
	@Nullable
	@Column(name = "reference_number")
	@Schema(description = "The Reference Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Hospital Bank Account here] off begin
	@CsvBindByName(column = "HOSPITAL_BANK_ACCOUNT", required = false)
	@Nullable
	@Column(name = "hospital_bank_account")
	@Schema(description = "The Hospital Bank Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Bank Account here] end
	private String hospitalBankAccount;

	// % protected region % [Modify attribute annotation for Surcharge Amount here] off begin
	@CsvBindByName(column = "SURCHARGE_AMOUNT", required = false)
	@Nullable
	@Column(name = "surcharge_amount")
	@Schema(description = "The Surcharge Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surcharge Amount here] end
	private Double surchargeAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@CsvBindByName(column = "OUTSTANDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "outstanding_amount")
	@Schema(description = "The Outstanding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Received From here] off begin
	@CsvBindByName(column = "RECEIVED_FROM", required = false)
	@Nullable
	@Column(name = "received_from")
	@Schema(description = "The Received From of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Received From here] end
	private String receivedFrom;

	// % protected region % [Modify attribute annotation for Patient Or Customer Name here] off begin
	@CsvBindByName(column = "PATIENT_OR_CUSTOMER_NAME", required = false)
	@Nullable
	@Column(name = "patient_or_customer_name")
	@Schema(description = "The Patient Or Customer Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Or Customer Name here] end
	private String patientOrCustomerName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Merchant here] off begin
	@Schema(description = "The Merchant entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Merchant here] end
	private MerchantEntity merchant;

	// % protected region % [Update the annotation for merchantId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MERCHANT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for merchantId here] end
	private UUID merchantId;

	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] off begin
	@Schema(description = "The Retail Pharmacy Invoice entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] end
	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] end
	private UUID retailPharmacyInvoiceId;

	// % protected region % [Update the annotation for Cashier Staff here] off begin
	@Schema(description = "The Cashier Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Cashier Staff here] end
	private StaffEntity cashierStaff;

	// % protected region % [Update the annotation for cashierStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CASHIER_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for cashierStaffId here] end
	private UUID cashierStaffId;

	// % protected region % [Update the annotation for Patient here] off begin
	@Schema(description = "The Patient entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient here] end
	private PatientGeneralInfoEntity patient;

	// % protected region % [Update the annotation for patientId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientId here] end
	private UUID patientId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMerchant(MerchantEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MerchantEntity to be set to this entity
	 */
	public void setMerchant(@NotNull MerchantEntity entity) {
		setMerchant(entity, true);
	}

	/**
	 * Set or update the merchant in this entity with single MerchantEntity.
	 *
	 * @param entity the given MerchantEntity to be set or updated to merchant
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMerchant(@NotNull MerchantEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMerchant here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMerchant here] end

		if (sameAsFormer(this.merchant, entity)) {
			return;
		}

		if (this.merchant != null) {
			this.merchant.removeCashReceipts(this, false);
		}
		this.merchant = entity;
		if (reverseAdd) {
			this.merchant.addCashReceipts(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMerchant incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMerchant incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMerchant(boolean)} but default to true.
	 */
	public void unsetMerchant() {
		this.unsetMerchant(true);
	}

	/**
	 * Remove Merchant in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMerchant(boolean reverse) {
		if (reverse && this.merchant != null) {
			this.merchant.removeCashReceipts(this, false);
		}
		this.merchant = null;
	}
	/**
	 * Similar to {@link this#setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoice(@NotNull RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(@NotNull RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] end

		if (sameAsFormer(this.retailPharmacyInvoice, entity)) {
			return;
		}

		if (this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeCashReceipts(this, false);
		}
		this.retailPharmacyInvoice = entity;
		if (reverseAdd) {
			this.retailPharmacyInvoice.addCashReceipts(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoice(boolean)} but default to true.
	 */
	public void unsetRetailPharmacyInvoice() {
		this.unsetRetailPharmacyInvoice(true);
	}

	/**
	 * Remove Retail Pharmacy Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacyInvoice(boolean reverse) {
		if (reverse && this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeCashReceipts(this, false);
		}
		this.retailPharmacyInvoice = null;
	}
	/**
	 * Similar to {@link this#setCashierStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setCashierStaff(@NotNull StaffEntity entity) {
		setCashierStaff(entity, true);
	}

	/**
	 * Set or update the cashierStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to cashierStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCashierStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCashierStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCashierStaff here] end

		if (sameAsFormer(this.cashierStaff, entity)) {
			return;
		}

		if (this.cashierStaff != null) {
			this.cashierStaff.removeCashierStaff(this, false);
		}
		this.cashierStaff = entity;
		if (reverseAdd) {
			this.cashierStaff.addCashierStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCashierStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCashierStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCashierStaff(boolean)} but default to true.
	 */
	public void unsetCashierStaff() {
		this.unsetCashierStaff(true);
	}

	/**
	 * Remove Cashier Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCashierStaff(boolean reverse) {
		if (reverse && this.cashierStaff != null) {
			this.cashierStaff.removeCashierStaff(this, false);
		}
		this.cashierStaff = null;
	}
	/**
	 * Similar to {@link this#setPatient(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatient(@NotNull PatientGeneralInfoEntity entity) {
		setPatient(entity, true);
	}

	/**
	 * Set or update the patient in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patient
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatient(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatient here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatient here] end

		if (sameAsFormer(this.patient, entity)) {
			return;
		}

		if (this.patient != null) {
			this.patient.removeInvoiceReceipts(this, false);
		}
		this.patient = entity;
		if (reverseAdd) {
			this.patient.addInvoiceReceipts(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatient(boolean)} but default to true.
	 */
	public void unsetPatient() {
		this.unsetPatient(true);
	}

	/**
	 * Remove Patient in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatient(boolean reverse) {
		if (reverse && this.patient != null) {
			this.patient.removeInvoiceReceipts(this, false);
		}
		this.patient = null;
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
		return "RECEIPT_TYPE,RECEIPT_NUMBER,PAYMENT_DATE,DESCRIPTION,PAYMENT_TYPE,RECEIVE_AMOUNT,ISVOID,CASHIER_LOCATION,VOID_DATE_TIME,CASH_CHANGE_TYPE,CHANGE_AMOUNT,ALLOCATED_AMOUNT,ROUNDING_AMOUNT,AVAILABLE_AMOUNT,BANK_NAME,CARD_TYPE,CARD_NO,CARD_HOLDER,REFERENCE_NUMBER,HOSPITAL_BANK_ACCOUNT,SURCHARGE_AMOUNT,OUTSTANDING_AMOUNT,RECEIVED_FROM,PATIENT_OR_CUSTOMER_NAME,MERCHANT_ID,RETAIL_PHARMACY_INVOICE_ID,CASHIER_STAFF_ID,PATIENT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MerchantEntity> merchantRelation = Optional.ofNullable(this.merchant);
		merchantRelation.ifPresent(entity -> this.merchantId = entity.getId());

		Optional<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceRelation = Optional.ofNullable(this.retailPharmacyInvoice);
		retailPharmacyInvoiceRelation.ifPresent(entity -> this.retailPharmacyInvoiceId = entity.getId());

		Optional<StaffEntity> cashierStaffRelation = Optional.ofNullable(this.cashierStaff);
		cashierStaffRelation.ifPresent(entity -> this.cashierStaffId = entity.getId());

		Optional<PatientGeneralInfoEntity> patientRelation = Optional.ofNullable(this.patient);
		patientRelation.ifPresent(entity -> this.patientId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object cashReceipt) {
		if (this == cashReceipt) {
			return true;
		}
		if (cashReceipt == null || this.getClass() != cashReceipt.getClass()) {
			return false;
		}
		if (!super.equals(cashReceipt)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CashReceiptEntity that = (CashReceiptEntity) cashReceipt;
		return
			Objects.equals(this.receiptType, that.receiptType) &&
			Objects.equals(this.receiptNumber, that.receiptNumber) &&
			Objects.equals(
			     this.paymentDate != null ? this.paymentDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.paymentDate != null ? that.paymentDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.paymentType, that.paymentType) &&
			Objects.equals(this.receiveAmount, that.receiveAmount) &&
			Objects.equals(this.isvoid, that.isvoid) &&
			Objects.equals(this.cashierLocation, that.cashierLocation) &&
			Objects.equals(
			     this.voidDateTime != null ? this.voidDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.voidDateTime != null ? that.voidDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.cashChangeType, that.cashChangeType) &&
			Objects.equals(this.changeAmount, that.changeAmount) &&
			Objects.equals(this.allocatedAmount, that.allocatedAmount) &&
			Objects.equals(this.roundingAmount, that.roundingAmount) &&
			Objects.equals(this.availableAmount, that.availableAmount) &&
			Objects.equals(this.bankName, that.bankName) &&
			Objects.equals(this.cardType, that.cardType) &&
			Objects.equals(this.cardNo, that.cardNo) &&
			Objects.equals(this.cardHolder, that.cardHolder) &&
			Objects.equals(this.referenceNumber, that.referenceNumber) &&
			Objects.equals(this.hospitalBankAccount, that.hospitalBankAccount) &&
			Objects.equals(this.surchargeAmount, that.surchargeAmount) &&
			Objects.equals(this.outstandingAmount, that.outstandingAmount) &&
			Objects.equals(this.receivedFrom, that.receivedFrom) &&
			Objects.equals(this.patientOrCustomerName, that.patientOrCustomerName) &&
			Objects.equals(this.merchantId, that.merchantId) &&
			Objects.equals(this.retailPharmacyInvoiceId, that.retailPharmacyInvoiceId) &&
			Objects.equals(this.cashierStaffId, that.cashierStaffId) &&
			Objects.equals(this.patientId, that.patientId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
