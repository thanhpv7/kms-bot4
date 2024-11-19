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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class CashReceiptEntity extends AbstractEntity {

	public CashReceiptEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MerchantOneMany = new EntityReference();
			MerchantOneMany.entityName = "Merchant";
			MerchantOneMany.oppositeName = "Merchant";
			MerchantOneMany.name = "CashReceipts";
			MerchantOneMany.optional = true;
			MerchantOneMany.type = "One";
			MerchantOneMany.oppositeType = "Many";

		References.add(MerchantOneMany);

		var RetailPharmacyInvoiceOneMany = new EntityReference();
			RetailPharmacyInvoiceOneMany.entityName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneMany.oppositeName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneMany.name = "CashReceipts";
			RetailPharmacyInvoiceOneMany.optional = true;
			RetailPharmacyInvoiceOneMany.type = "One";
			RetailPharmacyInvoiceOneMany.oppositeType = "Many";

		References.add(RetailPharmacyInvoiceOneMany);

		var CashierStaffOneMany = new EntityReference();
			CashierStaffOneMany.entityName = "Staff";
			CashierStaffOneMany.oppositeName = "CashierStaff";
			CashierStaffOneMany.name = "CashierStaff";
			CashierStaffOneMany.optional = true;
			CashierStaffOneMany.type = "One";
			CashierStaffOneMany.oppositeType = "Many";

		References.add(CashierStaffOneMany);

		var PatientOneMany = new EntityReference();
			PatientOneMany.entityName = "PatientGeneralInfo";
			PatientOneMany.oppositeName = "Patient";
			PatientOneMany.name = "InvoiceReceipts";
			PatientOneMany.optional = true;
			PatientOneMany.type = "One";
			PatientOneMany.oppositeType = "Many";

		References.add(PatientOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Receipt Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Receipt Type here] end
	private ReceiptTypeEnum receiptType;

	// % protected region % [Modify attribute annotation for Receipt Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Receipt Number here] end
	private String receiptNumber;

	// % protected region % [Modify attribute annotation for Payment Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Date here] end
	private OffsetDateTime paymentDate;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Payment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Type here] end
	private String paymentType;

	// % protected region % [Modify attribute annotation for Receive Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Receive Amount here] end
	private Double receiveAmount;

	// % protected region % [Modify attribute annotation for IsVoid here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for IsVoid here] end
	private Boolean isvoid;

	// % protected region % [Modify attribute annotation for Cashier Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cashier Location here] end
	private String cashierLocation;

	// % protected region % [Modify attribute annotation for Void Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Void Date Time here] end
	private OffsetDateTime voidDateTime;

	// % protected region % [Modify attribute annotation for Cash Change Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cash Change Type here] end
	private CashChangeTypeEnum cashChangeType;

	// % protected region % [Modify attribute annotation for Change Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Change Amount here] end
	private Double changeAmount;

	// % protected region % [Modify attribute annotation for Allocated Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Allocated Amount here] end
	private Double allocatedAmount;

	// % protected region % [Modify attribute annotation for Rounding Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rounding Amount here] end
	private Double roundingAmount;

	// % protected region % [Modify attribute annotation for Available Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Amount here] end
	private Double availableAmount;

	// % protected region % [Modify attribute annotation for Bank Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bank Name here] end
	private String bankName;

	// % protected region % [Modify attribute annotation for Card Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Card Type here] end
	private String cardType;

	// % protected region % [Modify attribute annotation for Card No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Card No here] end
	private String cardNo;

	// % protected region % [Modify attribute annotation for Card Holder here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Card Holder here] end
	private String cardHolder;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Hospital Bank Account here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Bank Account here] end
	private String hospitalBankAccount;

	// % protected region % [Modify attribute annotation for Surcharge Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surcharge Amount here] end
	private Double surchargeAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Received From here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Received From here] end
	private String receivedFrom;

	// % protected region % [Modify attribute annotation for Patient Or Customer Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Or Customer Name here] end
	private String patientOrCustomerName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MerchantEntity merchant;

	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	private StaffEntity cashierStaff;

	private PatientGeneralInfoEntity patient;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	public void setMerchant(@NonNull MerchantEntity entity) {
		setMerchant(entity, true);
	}

	/**
	 * Set or update the merchant in this entity with single MerchantEntity.
	 *
	 * @param entity the given MerchantEntity to be set or updated to merchant
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMerchant(@NonNull MerchantEntity entity, boolean reverseAdd) {
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
	public void setRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(@NonNull RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
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
	public void setCashierStaff(@NonNull StaffEntity entity) {
		setCashierStaff(entity, true);
	}

	/**
	 * Set or update the cashierStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to cashierStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCashierStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
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
	public void setPatient(@NonNull PatientGeneralInfoEntity entity) {
		setPatient(entity, true);
	}

	/**
	 * Set or update the patient in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patient
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatient(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
