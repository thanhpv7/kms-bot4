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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InvoicePaymentInsuranceEntity extends AbstractEntity {

	public InvoicePaymentInsuranceEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InsuranceBenefitPlanOneMany = new EntityReference();
			InsuranceBenefitPlanOneMany.entityName = "InsuranceBenefitPlan";
			InsuranceBenefitPlanOneMany.oppositeName = "InsuranceBenefitPlan";
			InsuranceBenefitPlanOneMany.name = "InvoicePaymentInsurances";
			InsuranceBenefitPlanOneMany.optional = true;
			InsuranceBenefitPlanOneMany.type = "One";
			InsuranceBenefitPlanOneMany.oppositeType = "Many";

		References.add(InsuranceBenefitPlanOneMany);

		var InvoiceOneMany = new EntityReference();
			InvoiceOneMany.entityName = "Invoice";
			InvoiceOneMany.oppositeName = "Invoice";
			InvoiceOneMany.name = "InvoicePaymentInsurances";
			InvoiceOneMany.optional = true;
			InvoiceOneMany.type = "One";
			InvoiceOneMany.oppositeType = "Many";

		References.add(InvoiceOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Member No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Member No here] end
	private String memberNo;

	// % protected region % [Modify attribute annotation for Policy Holder No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Policy Holder No here] end
	private String policyHolderNo;

	// % protected region % [Modify attribute annotation for Eligility Verification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Eligility Verification here] end
	private String eligilityVerification;

	// % protected region % [Modify attribute annotation for Verification Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Verification Date here] end
	private OffsetDateTime verificationDate;

	// % protected region % [Modify attribute annotation for Guarantee Letter No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Guarantee Letter No here] end
	private String guaranteeLetterNo;

	// % protected region % [Modify attribute annotation for Coverage Balance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Coverage Balance here] end
	private Double coverageBalance;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Main Insurance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Main Insurance here] end
	private Boolean mainInsurance;

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

	private InsuranceBenefitPlanEntity insuranceBenefitPlan;

	private InvoiceEntity invoice;

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
	 * Similar to {@link this#setInsuranceBenefitPlan(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void setInsuranceBenefitPlan(@NonNull InsuranceBenefitPlanEntity entity) {
		setInsuranceBenefitPlan(entity, true);
	}

	/**
	 * Set or update the insuranceBenefitPlan in this entity with single InsuranceBenefitPlanEntity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set or updated to insuranceBenefitPlan
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInsuranceBenefitPlan(@NonNull InsuranceBenefitPlanEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInsuranceBenefitPlan here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInsuranceBenefitPlan here] end

		if (sameAsFormer(this.insuranceBenefitPlan, entity)) {
			return;
		}

		if (this.insuranceBenefitPlan != null) {
			this.insuranceBenefitPlan.removeInvoicePaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = entity;
		if (reverseAdd) {
			this.insuranceBenefitPlan.addInvoicePaymentInsurances(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInsuranceBenefitPlan incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInsuranceBenefitPlan incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInsuranceBenefitPlan(boolean)} but default to true.
	 */
	public void unsetInsuranceBenefitPlan() {
		this.unsetInsuranceBenefitPlan(true);
	}

	/**
	 * Remove Insurance Benefit Plan in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInsuranceBenefitPlan(boolean reverse) {
		if (reverse && this.insuranceBenefitPlan != null) {
			this.insuranceBenefitPlan.removeInvoicePaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = null;
	}
	/**
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoice(@NonNull InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.removeInvoicePaymentInsurances(this, false);
		}
		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.addInvoicePaymentInsurances(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.removeInvoicePaymentInsurances(this, false);
		}
		this.invoice = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
