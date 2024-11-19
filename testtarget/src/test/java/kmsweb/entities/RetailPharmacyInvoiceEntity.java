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

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class RetailPharmacyInvoiceEntity extends AbstractEntity {

	public RetailPharmacyInvoiceEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var CashReceiptsOneMany = new EntityReference();
			CashReceiptsOneMany.entityName = "CashReceipt";
			CashReceiptsOneMany.oppositeName = "RetailPharmacyInvoice";
			CashReceiptsOneMany.name = "CashReceipts";
			CashReceiptsOneMany.optional = true;
			CashReceiptsOneMany.type = "One";
			CashReceiptsOneMany.oppositeType = "Many";

		References.add(CashReceiptsOneMany);

		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "RetailPharmacyInvoice";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var InvoiceSummaryOneOne = new EntityReference();
			InvoiceSummaryOneOne.entityName = "InvoiceSummary";
			InvoiceSummaryOneOne.oppositeName = "RetailPharmacyInvoice";
			InvoiceSummaryOneOne.name = "InvoiceSummary";
			InvoiceSummaryOneOne.optional = true;
			InvoiceSummaryOneOne.type = "One";
			InvoiceSummaryOneOne.oppositeType = "One";

		References.add(InvoiceSummaryOneOne);

		var RetailPharmacyOneMany = new EntityReference();
			RetailPharmacyOneMany.entityName = "RetailPharmacy";
			RetailPharmacyOneMany.oppositeName = "RetailPharmacy";
			RetailPharmacyOneMany.name = "RetailPharmacyInvoices";
			RetailPharmacyOneMany.optional = true;
			RetailPharmacyOneMany.type = "One";
			RetailPharmacyOneMany.oppositeType = "Many";

		References.add(RetailPharmacyOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Invoice Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Number here] end
	private String invoiceNumber;

	// % protected region % [Modify attribute annotation for Revision Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revision Number here] end
	private Integer revisionNumber;

	// % protected region % [Modify attribute annotation for Invoice Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Status here] end
	private String invoiceStatus;

	// % protected region % [Modify attribute annotation for Invoice Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Date here] end
	private OffsetDateTime invoiceDate;

	// % protected region % [Modify attribute annotation for Cancel Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cancel Date here] end
	private OffsetDateTime cancelDate;

	// % protected region % [Modify attribute annotation for Billing Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Billing Location here] end
	private String billingLocation;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Verification Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Verification Date here] end
	private OffsetDateTime verificationDate;

	// % protected region % [Modify attribute annotation for Display Doctor on Print here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Display Doctor on Print here] end
	private Boolean displayDoctorOnPrint;

	// % protected region % [Modify attribute annotation for Claim No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim No here] end
	private String claimNo;

	// % protected region % [Modify attribute annotation for Payment Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Status here] end
	private String paymentStatus;

	// % protected region % [Modify attribute annotation for Invoice Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Amount here] end
	private Double invoiceAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceSummaryEntity invoiceSummary;

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

	private Set<CashReceiptEntity> cashReceipts = new HashSet<>();

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RetailPharmacyEntity retailPharmacy;

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

/**
	 * Similar to {@link this#addCashReceipts(CashReceiptEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CashReceiptEntity to be added to this entity
	 */
	public void addCashReceipts(@NonNull CashReceiptEntity entity) {
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
	public void addCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
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
	public void removeCashReceipts(@NonNull CashReceiptEntity entity) {
		this.removeCashReceipts(entity, true);
	}

	/**
	 * Remove the given CashReceiptEntity from this entity.
	 *
	 * @param entity the given CashReceiptEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCashReceipts(@NonNull CashReceiptEntity entity, boolean reverse) {
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
	public void removeCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
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
	public void setCashReceipts(@NonNull Collection<CashReceiptEntity> entities) {
		setCashReceipts(entities, true);
	}

	/**
	 * Replace the current entities in Cash Receipts with the given ones.
	 *
	 * @param entities the given collection of CashReceiptEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCashReceipts(@NonNull Collection<CashReceiptEntity> entities, boolean reverseAdd) {

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
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity) {
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
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverse) {
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
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

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
	public void setInvoiceSummary(@NonNull InvoiceSummaryEntity entity) {
		setInvoiceSummary(entity, true);
	}

	/**
	 * Set or update invoiceSummary with the given InvoiceSummaryEntity.
	 *
	 * @param entity the RetailPharmacyInvoiceEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoiceSummary(@NonNull InvoiceSummaryEntity entity, boolean reverseAdd) {
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
	public void setRetailPharmacy(@NonNull RetailPharmacyEntity entity) {
		setRetailPharmacy(entity, true);
	}

	/**
	 * Set or update the retailPharmacy in this entity with single RetailPharmacyEntity.
	 *
	 * @param entity the given RetailPharmacyEntity to be set or updated to retailPharmacy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacy(@NonNull RetailPharmacyEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
