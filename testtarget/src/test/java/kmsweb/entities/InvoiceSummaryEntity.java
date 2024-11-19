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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InvoiceSummaryEntity extends AbstractEntity {

	public InvoiceSummaryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceOneOne = new EntityReference();
			InvoiceOneOne.entityName = "Invoice";
			InvoiceOneOne.oppositeName = "Invoice";
			InvoiceOneOne.name = "InvoiceSummary";
			InvoiceOneOne.optional = true;
			InvoiceOneOne.type = "One";
			InvoiceOneOne.oppositeType = "One";

		References.add(InvoiceOneOne);

		var RetailPharmacyInvoiceOneOne = new EntityReference();
			RetailPharmacyInvoiceOneOne.entityName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneOne.oppositeName = "RetailPharmacyInvoice";
			RetailPharmacyInvoiceOneOne.name = "InvoiceSummary";
			RetailPharmacyInvoiceOneOne.optional = true;
			RetailPharmacyInvoiceOneOne.type = "One";
			RetailPharmacyInvoiceOneOne.oppositeType = "One";

		References.add(RetailPharmacyInvoiceOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Tax On Other Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax On Other Discount here] end
	private Boolean taxOnOtherDiscount;

	// % protected region % [Modify attribute annotation for Other Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Discount here] end
	private Double otherDiscount;

	// % protected region % [Modify attribute annotation for Tax On Other Fee here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax On Other Fee here] end
	private Boolean taxOnOtherFee;

	// % protected region % [Modify attribute annotation for Other Fee here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Fee here] end
	private Double otherFee;

	// % protected region % [Modify attribute annotation for Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax here] end
	private Double tax;

	// % protected region % [Modify attribute annotation for Total Invoice here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Invoice here] end
	private Double totalInvoice;

	// % protected region % [Modify attribute annotation for Available Down Payment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Available Down Payment here] end
	private Double availableDownPayment;

	// % protected region % [Modify attribute annotation for Total Coverage here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Coverage here] end
	private Double totalCoverage;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for BPJS Coverage here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Coverage here] end
	private Double bpjsCoverage;

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

	private InvoiceEntity invoice;

	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

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
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoice(InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.unsetInvoiceSummary(false);
		}

		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.setInvoiceSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove the InvoiceEntity of invoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.unsetInvoiceSummary();
		}
		this.invoice = null;
	}
	/**
	 * Similar to {@link this#setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] end

		if (sameAsFormer(this.retailPharmacyInvoice, entity)) {
			return;
		}

		if (this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.unsetInvoiceSummary(false);
		}

		this.retailPharmacyInvoice = entity;
		if (reverseAdd) {
			this.retailPharmacyInvoice.setInvoiceSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoice(boolean)} but default to true.
	 */
	public void unsetRetailPharmacyInvoice() {
		this.unsetRetailPharmacyInvoice(true);
	}

	/**
	 * Remove the RetailPharmacyInvoiceEntity of retailPharmacyInvoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacyInvoice(boolean reverse) {
		if (reverse && this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.unsetInvoiceSummary();
		}
		this.retailPharmacyInvoice = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
