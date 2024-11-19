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
public class InsuranceBenefitPlanEntity extends AbstractEntity {

	public InsuranceBenefitPlanEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InsuranceProviderOneMany = new EntityReference();
			InsuranceProviderOneMany.entityName = "InsuranceProvider";
			InsuranceProviderOneMany.oppositeName = "InsuranceProvider";
			InsuranceProviderOneMany.name = "InsuranceBenefitPlans";
			InsuranceProviderOneMany.optional = true;
			InsuranceProviderOneMany.type = "One";
			InsuranceProviderOneMany.oppositeType = "Many";

		References.add(InsuranceProviderOneMany);

		var InvoicePaymentInsurancesOneMany = new EntityReference();
			InvoicePaymentInsurancesOneMany.entityName = "InvoicePaymentInsurance";
			InvoicePaymentInsurancesOneMany.oppositeName = "InsuranceBenefitPlan";
			InvoicePaymentInsurancesOneMany.name = "InvoicePaymentInsurances";
			InvoicePaymentInsurancesOneMany.optional = true;
			InvoicePaymentInsurancesOneMany.type = "One";
			InvoicePaymentInsurancesOneMany.oppositeType = "Many";

		References.add(InvoicePaymentInsurancesOneMany);

		var PatientPaymentInsurancesOneMany = new EntityReference();
			PatientPaymentInsurancesOneMany.entityName = "PatientPaymentInsurance";
			PatientPaymentInsurancesOneMany.oppositeName = "InsuranceBenefitPlan";
			PatientPaymentInsurancesOneMany.name = "PatientPaymentInsurances";
			PatientPaymentInsurancesOneMany.optional = true;
			PatientPaymentInsurancesOneMany.type = "One";
			PatientPaymentInsurancesOneMany.oppositeType = "Many";

		References.add(PatientPaymentInsurancesOneMany);

		var PatientVisitPatientPaymentInsurancesOneMany = new EntityReference();
			PatientVisitPatientPaymentInsurancesOneMany.entityName = "PatientVisitPatientPaymentInsurance";
			PatientVisitPatientPaymentInsurancesOneMany.oppositeName = "InsuranceBenefitPlan";
			PatientVisitPatientPaymentInsurancesOneMany.name = "PatientVisitPatientPaymentInsurances";
			PatientVisitPatientPaymentInsurancesOneMany.optional = true;
			PatientVisitPatientPaymentInsurancesOneMany.type = "One";
			PatientVisitPatientPaymentInsurancesOneMany.oppositeType = "Many";

		References.add(PatientVisitPatientPaymentInsurancesOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Benefit Plan No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Benefit Plan No here] end
	private String benefitPlanNo;

	// % protected region % [Modify attribute annotation for Benefit Plan Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Benefit Plan Name here] end
	private String benefitPlanName;

	// % protected region % [Modify attribute annotation for Maximum Coverage per Treatment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Maximum Coverage per Treatment here] end
	private Double maximumCoveragePerTreatment;

	// % protected region % [Modify attribute annotation for Maximum Coverage per Year here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Maximum Coverage per Year here] end
	private Double maximumCoveragePerYear;

	// % protected region % [Modify attribute annotation for Created Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Created Date here] end
	private OffsetDateTime createdDate;

	// % protected region % [Modify attribute annotation for Updated Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Updated Date here] end
	private OffsetDateTime updatedDate;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoicePaymentInsuranceEntity> invoicePaymentInsurances = new HashSet<>();

	private Set<PatientPaymentInsuranceEntity> patientPaymentInsurances = new HashSet<>();

	private Set<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurances = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InsuranceProviderEntity insuranceProvider;

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
	 * Similar to {@link this#addInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity) {
		addInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Add a new InvoicePaymentInsuranceEntity to invoicePaymentInsurances in this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.invoicePaymentInsurances.contains(entity)) {
			invoicePaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 */
	public void addInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		addInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of InvoicePaymentInsuranceEntity to Invoice Payment Insurances in this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(InvoicePaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity) {
		this.removeInvoicePaymentInsurances(entity, true);
	}

	/**
	 * Remove the given InvoicePaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given InvoicePaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull InvoicePaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.invoicePaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 */
	public void removeInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		this.removeInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of InvoicePaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoicePaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoicePaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to be set to this entity
	 */
	public void setInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities) {
		setInvoicePaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of InvoicePaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoicePaymentInsurances(@NonNull Collection<InvoicePaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetInvoicePaymentInsurances();
		this.invoicePaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoicePaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoicePaymentInsurances() {
		this.unsetInvoicePaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Invoice Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoicePaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.invoicePaymentInsurances.forEach(invoicePaymentInsurancesEntity -> invoicePaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.invoicePaymentInsurances.clear();
	}

/**
	 * Similar to {@link this#addPatientPaymentInsurances(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientPaymentInsurances(@NonNull PatientPaymentInsuranceEntity entity) {
		addPatientPaymentInsurances(entity, true);
	}

	/**
	 * Add a new PatientPaymentInsuranceEntity to patientPaymentInsurances in this entity.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientPaymentInsurances(@NonNull PatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.patientPaymentInsurances.contains(entity)) {
			patientPaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities) {
		addPatientPaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of PatientPaymentInsuranceEntity to Patient Payment Insurances in this entity.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientPaymentInsurances(PatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be set to this entity
	 */
	public void removePatientPaymentInsurances(@NonNull PatientPaymentInsuranceEntity entity) {
		this.removePatientPaymentInsurances(entity, true);
	}

	/**
	 * Remove the given PatientPaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given PatientPaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientPaymentInsurances(@NonNull PatientPaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.patientPaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be removed to this entity
	 */
	public void removePatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities) {
		this.removePatientPaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of PatientPaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to be set to this entity
	 */
	public void setPatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities) {
		setPatientPaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Patient Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of PatientPaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientPaymentInsurances(@NonNull Collection<PatientPaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetPatientPaymentInsurances();
		this.patientPaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientPaymentInsurances.forEach(patientPaymentInsurancesEntity -> patientPaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientPaymentInsurances() {
		this.unsetPatientPaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Patient Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientPaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.patientPaymentInsurances.forEach(patientPaymentInsurancesEntity -> patientPaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.patientPaymentInsurances.clear();
	}

/**
	 * Similar to {@link this#addPatientVisitPatientPaymentInsurances(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull PatientVisitPatientPaymentInsuranceEntity entity) {
		addPatientVisitPatientPaymentInsurances(entity, true);
	}

	/**
	 * Add a new PatientVisitPatientPaymentInsuranceEntity to patientVisitPatientPaymentInsurances in this entity.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		if (!this.patientVisitPatientPaymentInsurances.contains(entity)) {
			patientVisitPatientPaymentInsurances.add(entity);
			if (reverseAdd) {
				entity.setInsuranceBenefitPlan(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		addPatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Add a new collection of PatientVisitPatientPaymentInsuranceEntity to Patient Visit Patient Payment Insurances in this entity.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPatientVisitPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePatientVisitPatientPaymentInsurances(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be set to this entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NonNull PatientVisitPatientPaymentInsuranceEntity entity) {
		this.removePatientVisitPatientPaymentInsurances(entity, true);
	}

	/**
	 * Remove the given PatientVisitPatientPaymentInsuranceEntity from this entity.
	 *
	 * @param entity the given PatientVisitPatientPaymentInsuranceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NonNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceBenefitPlan(false);
		}
		this.patientVisitPatientPaymentInsurances.remove(entity);
	}

	/**
	 * Similar to {@link this#removePatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be removed to this entity
	 */
	public void removePatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		this.removePatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Remove the given collection of PatientVisitPatientPaymentInsuranceEntity from  to this entity.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePatientVisitPatientPaymentInsurances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentInsurances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities) {
		setPatientVisitPatientPaymentInsurances(entities, true);
	}

	/**
	 * Replace the current entities in Patient Visit Patient Payment Insurances with the given ones.
	 *
	 * @param entities the given collection of PatientVisitPatientPaymentInsuranceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPatientVisitPatientPaymentInsurances(@NonNull Collection<PatientVisitPatientPaymentInsuranceEntity> entities, boolean reverseAdd) {

		this.unsetPatientVisitPatientPaymentInsurances();
		this.patientVisitPatientPaymentInsurances = new HashSet<>(entities);
		if (reverseAdd) {
			this.patientVisitPatientPaymentInsurances.forEach(patientVisitPatientPaymentInsurancesEntity -> patientVisitPatientPaymentInsurancesEntity.setInsuranceBenefitPlan(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentInsurances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPatientVisitPatientPaymentInsurances() {
		this.unsetPatientVisitPatientPaymentInsurances(true);
	}

	/**
	 * Remove all the entities in Patient Visit Patient Payment Insurances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPatientVisitPatientPaymentInsurances(boolean doReverse) {
		if (doReverse) {
			this.patientVisitPatientPaymentInsurances.forEach(patientVisitPatientPaymentInsurancesEntity -> patientVisitPatientPaymentInsurancesEntity.unsetInsuranceBenefitPlan(false));
		}
		this.patientVisitPatientPaymentInsurances.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInsuranceProvider(InsuranceProviderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceProviderEntity to be set to this entity
	 */
	public void setInsuranceProvider(@NonNull InsuranceProviderEntity entity) {
		setInsuranceProvider(entity, true);
	}

	/**
	 * Set or update the insuranceProvider in this entity with single InsuranceProviderEntity.
	 *
	 * @param entity the given InsuranceProviderEntity to be set or updated to insuranceProvider
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInsuranceProvider(@NonNull InsuranceProviderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInsuranceProvider here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInsuranceProvider here] end

		if (sameAsFormer(this.insuranceProvider, entity)) {
			return;
		}

		if (this.insuranceProvider != null) {
			this.insuranceProvider.removeInsuranceBenefitPlans(this, false);
		}
		this.insuranceProvider = entity;
		if (reverseAdd) {
			this.insuranceProvider.addInsuranceBenefitPlans(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInsuranceProvider incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInsuranceProvider incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInsuranceProvider(boolean)} but default to true.
	 */
	public void unsetInsuranceProvider() {
		this.unsetInsuranceProvider(true);
	}

	/**
	 * Remove Insurance Provider in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInsuranceProvider(boolean reverse) {
		if (reverse && this.insuranceProvider != null) {
			this.insuranceProvider.removeInsuranceBenefitPlans(this, false);
		}
		this.insuranceProvider = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
