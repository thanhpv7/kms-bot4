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
public class InsuranceProviderEntity extends AbstractEntity {

	public InsuranceProviderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InsuranceBenefitPlansOneMany = new EntityReference();
			InsuranceBenefitPlansOneMany.entityName = "InsuranceBenefitPlan";
			InsuranceBenefitPlansOneMany.oppositeName = "InsuranceProvider";
			InsuranceBenefitPlansOneMany.name = "InsuranceBenefitPlans";
			InsuranceBenefitPlansOneMany.optional = true;
			InsuranceBenefitPlansOneMany.type = "One";
			InsuranceBenefitPlansOneMany.oppositeType = "Many";

		References.add(InsuranceBenefitPlansOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Provider Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Provider Code here] end
	private String providerCode;

	// % protected region % [Modify attribute annotation for Provider Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Provider Name here] end
	private String providerName;

	// % protected region % [Modify attribute annotation for Provider Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Provider Type here] end
	private String providerType;

	// % protected region % [Modify attribute annotation for Benefit Provider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Benefit Provider here] end
	private String benefitProvider;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Mobile Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone Number here] end
	private String mobilePhoneNumber;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Expiry Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expiry Date here] end
	private OffsetDateTime expiryDate;

	// % protected region % [Modify attribute annotation for Expiring Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expiring Date here] end
	private OffsetDateTime expiringDate;

	// % protected region % [Modify attribute annotation for Created Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Created Date here] end
	private OffsetDateTime createdDate;

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

	private Set<InsuranceBenefitPlanEntity> insuranceBenefitPlans = new HashSet<>();

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

/**
	 * Similar to {@link this#addInsuranceBenefitPlans(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be added to this entity
	 */
	public void addInsuranceBenefitPlans(@NonNull InsuranceBenefitPlanEntity entity) {
		addInsuranceBenefitPlans(entity, true);
	}

	/**
	 * Add a new InsuranceBenefitPlanEntity to insuranceBenefitPlans in this entity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInsuranceBenefitPlans(@NonNull InsuranceBenefitPlanEntity entity, boolean reverseAdd) {
		if (!this.insuranceBenefitPlans.contains(entity)) {
			insuranceBenefitPlans.add(entity);
			if (reverseAdd) {
				entity.setInsuranceProvider(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be added to this entity
	 */
	public void addInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities) {
		addInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Add a new collection of InsuranceBenefitPlanEntity to Insurance Benefit Plans in this entity.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInsuranceBenefitPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInsuranceBenefitPlans(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void removeInsuranceBenefitPlans(@NonNull InsuranceBenefitPlanEntity entity) {
		this.removeInsuranceBenefitPlans(entity, true);
	}

	/**
	 * Remove the given InsuranceBenefitPlanEntity from this entity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInsuranceBenefitPlans(@NonNull InsuranceBenefitPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceProvider(false);
		}
		this.insuranceBenefitPlans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be removed to this entity
	 */
	public void removeInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities) {
		this.removeInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Remove the given collection of InsuranceBenefitPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInsuranceBenefitPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void setInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities) {
		setInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Replace the current entities in Insurance Benefit Plans with the given ones.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {

		this.unsetInsuranceBenefitPlans();
		this.insuranceBenefitPlans = new HashSet<>(entities);
		if (reverseAdd) {
			this.insuranceBenefitPlans.forEach(insuranceBenefitPlansEntity -> insuranceBenefitPlansEntity.setInsuranceProvider(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInsuranceBenefitPlans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInsuranceBenefitPlans() {
		this.unsetInsuranceBenefitPlans(true);
	}

	/**
	 * Remove all the entities in Insurance Benefit Plans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInsuranceBenefitPlans(boolean doReverse) {
		if (doReverse) {
			this.insuranceBenefitPlans.forEach(insuranceBenefitPlansEntity -> insuranceBenefitPlansEntity.unsetInsuranceProvider(false));
		}
		this.insuranceBenefitPlans.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
