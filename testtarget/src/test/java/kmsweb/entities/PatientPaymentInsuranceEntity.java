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
public class PatientPaymentInsuranceEntity extends AbstractEntity {

	public PatientPaymentInsuranceEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InsuranceBenefitPlanOneMany = new EntityReference();
			InsuranceBenefitPlanOneMany.entityName = "InsuranceBenefitPlan";
			InsuranceBenefitPlanOneMany.oppositeName = "InsuranceBenefitPlan";
			InsuranceBenefitPlanOneMany.name = "PatientPaymentInsurances";
			InsuranceBenefitPlanOneMany.optional = true;
			InsuranceBenefitPlanOneMany.type = "One";
			InsuranceBenefitPlanOneMany.oppositeType = "Many";

		References.add(InsuranceBenefitPlanOneMany);

		var PatientGeneralInformationOneOne = new EntityReference();
			PatientGeneralInformationOneOne.entityName = "PatientGeneralInfo";
			PatientGeneralInformationOneOne.oppositeName = "PatientGeneralInformation";
			PatientGeneralInformationOneOne.name = "PatientPaymentTypeInsurance";
			PatientGeneralInformationOneOne.optional = true;
			PatientGeneralInformationOneOne.type = "One";
			PatientGeneralInformationOneOne.oppositeType = "One";

		References.add(PatientGeneralInformationOneOne);
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

	private PatientGeneralInfoEntity patientGeneralInformation;

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
			this.insuranceBenefitPlan.removePatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = entity;
		if (reverseAdd) {
			this.insuranceBenefitPlan.addPatientPaymentInsurances(this, false);
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
			this.insuranceBenefitPlan.removePatientPaymentInsurances(this, false);
		}
		this.insuranceBenefitPlan = null;
	}
	/**
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPaymentTypeInsurance(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientPaymentTypeInsurance(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInformation from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientPaymentTypeInsurance();
		}
		this.patientGeneralInformation = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
