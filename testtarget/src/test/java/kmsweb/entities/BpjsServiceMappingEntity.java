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

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class BpjsServiceMappingEntity extends AbstractEntity {

	public BpjsServiceMappingEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "BpjsServiceMapping";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var BpjsControlPlansOneMany = new EntityReference();
			BpjsControlPlansOneMany.entityName = "BpjsControlPlan";
			BpjsControlPlansOneMany.oppositeName = "BpjsServiceMapping";
			BpjsControlPlansOneMany.name = "BpjsControlPlans";
			BpjsControlPlansOneMany.optional = true;
			BpjsControlPlansOneMany.type = "One";
			BpjsControlPlansOneMany.oppositeType = "Many";

		References.add(BpjsControlPlansOneMany);

		var BpjsPatientReferralsOneMany = new EntityReference();
			BpjsPatientReferralsOneMany.entityName = "BpjsPatientReferral";
			BpjsPatientReferralsOneMany.oppositeName = "BpjsServiceMapping";
			BpjsPatientReferralsOneMany.name = "BpjsPatientReferrals";
			BpjsPatientReferralsOneMany.optional = true;
			BpjsPatientReferralsOneMany.type = "One";
			BpjsPatientReferralsOneMany.oppositeType = "Many";

		References.add(BpjsPatientReferralsOneMany);

		var ServiceOneOne = new EntityReference();
			ServiceOneOne.entityName = "Service";
			ServiceOneOne.oppositeName = "Service";
			ServiceOneOne.name = "BpjsServiceMapping";
			ServiceOneOne.optional = true;
			ServiceOneOne.type = "One";
			ServiceOneOne.oppositeType = "One";

		References.add(ServiceOneOne);

		var PolikontrolOneMany = new EntityReference();
			PolikontrolOneMany.entityName = "BpjsHospitalizationPlan";
			PolikontrolOneMany.oppositeName = "BpjsServiceMapping";
			PolikontrolOneMany.name = "Polikontrol";
			PolikontrolOneMany.optional = true;
			PolikontrolOneMany.type = "One";
			PolikontrolOneMany.oppositeType = "Many";

		References.add(PolikontrolOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Code here] end
	private String refCode;

	// % protected region % [Modify attribute annotation for Ref Service here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Service here] end
	private String refService;

	// % protected region % [Modify attribute annotation for Kode Subspesialis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kode Subspesialis here] end
	private String kodeSubspesialis;

	// % protected region % [Modify attribute annotation for Nama Subspesialis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nama Subspesialis here] end
	private String namaSubspesialis;

	// % protected region % [Modify attribute annotation for Categorized as Surgery here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Categorized as Surgery here] end
	private Boolean categorizedAsSurgery;

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

	private ServiceEntity service;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<BpjsControlPlanEntity> bpjsControlPlans = new HashSet<>();

	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	private Set<BpjsHospitalizationPlanEntity> polikontrol = new HashSet<>();

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
	 * Similar to {@link this#addBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity) {
		addBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Add a new BpjsClaimSubmissionEntity to bpjsClaimSubmissions in this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity, boolean reverseAdd) {
		if (!this.bpjsClaimSubmissions.contains(entity)) {
			bpjsClaimSubmissions.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 */
	public void addBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		addBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Add a new collection of BpjsClaimSubmissionEntity to BPJS Claim Submissions in this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity) {
		this.removeBpjsClaimSubmissions(entity, true);
	}

	/**
	 * Remove the given BpjsClaimSubmissionEntity from this entity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull BpjsClaimSubmissionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.bpjsClaimSubmissions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 */
	public void removeBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		this.removeBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsClaimSubmissionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsClaimSubmissions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsClaimSubmissions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void setBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities) {
		setBpjsClaimSubmissions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Claim Submissions with the given ones.
	 *
	 * @param entities the given collection of BpjsClaimSubmissionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsClaimSubmissions(@NonNull Collection<BpjsClaimSubmissionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsClaimSubmissions();
		this.bpjsClaimSubmissions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsClaimSubmissions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsClaimSubmissions() {
		this.unsetBpjsClaimSubmissions(true);
	}

	/**
	 * Remove all the entities in BPJS Claim Submissions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsClaimSubmissions(boolean doReverse) {
		if (doReverse) {
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsControlPlans(BpjsControlPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsControlPlanEntity to be added to this entity
	 */
	public void addBpjsControlPlans(@NonNull BpjsControlPlanEntity entity) {
		addBpjsControlPlans(entity, true);
	}

	/**
	 * Add a new BpjsControlPlanEntity to bpjsControlPlans in this entity.
	 *
	 * @param entity the given BpjsControlPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsControlPlans(@NonNull BpjsControlPlanEntity entity, boolean reverseAdd) {
		if (!this.bpjsControlPlans.contains(entity)) {
			bpjsControlPlans.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be added to this entity
	 */
	public void addBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities) {
		addBpjsControlPlans(entities, true);
	}

	/**
	 * Add a new collection of BpjsControlPlanEntity to BPJS Control Plans in this entity.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsControlPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsControlPlans(BpjsControlPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsControlPlanEntity to be set to this entity
	 */
	public void removeBpjsControlPlans(@NonNull BpjsControlPlanEntity entity) {
		this.removeBpjsControlPlans(entity, true);
	}

	/**
	 * Remove the given BpjsControlPlanEntity from this entity.
	 *
	 * @param entity the given BpjsControlPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsControlPlans(@NonNull BpjsControlPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.bpjsControlPlans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be removed to this entity
	 */
	public void removeBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities) {
		this.removeBpjsControlPlans(entities, true);
	}

	/**
	 * Remove the given collection of BpjsControlPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsControlPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsControlPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to be set to this entity
	 */
	public void setBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities) {
		setBpjsControlPlans(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Control Plans with the given ones.
	 *
	 * @param entities the given collection of BpjsControlPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsControlPlans(@NonNull Collection<BpjsControlPlanEntity> entities, boolean reverseAdd) {

		this.unsetBpjsControlPlans();
		this.bpjsControlPlans = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsControlPlans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsControlPlans() {
		this.unsetBpjsControlPlans(true);
	}

	/**
	 * Remove all the entities in BPJS Control Plans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsControlPlans(boolean doReverse) {
		if (doReverse) {
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsControlPlans.clear();
	}

/**
	 * Similar to {@link this#addBpjsPatientReferrals(BpjsPatientReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be added to this entity
	 */
	public void addBpjsPatientReferrals(@NonNull BpjsPatientReferralEntity entity) {
		addBpjsPatientReferrals(entity, true);
	}

	/**
	 * Add a new BpjsPatientReferralEntity to bpjsPatientReferrals in this entity.
	 *
	 * @param entity the given BpjsPatientReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPatientReferrals(@NonNull BpjsPatientReferralEntity entity, boolean reverseAdd) {
		if (!this.bpjsPatientReferrals.contains(entity)) {
			bpjsPatientReferrals.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be added to this entity
	 */
	public void addBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities) {
		addBpjsPatientReferrals(entities, true);
	}

	/**
	 * Add a new collection of BpjsPatientReferralEntity to BPJS Patient Referrals in this entity.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPatientReferrals(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPatientReferrals(BpjsPatientReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be set to this entity
	 */
	public void removeBpjsPatientReferrals(@NonNull BpjsPatientReferralEntity entity) {
		this.removeBpjsPatientReferrals(entity, true);
	}

	/**
	 * Remove the given BpjsPatientReferralEntity from this entity.
	 *
	 * @param entity the given BpjsPatientReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPatientReferrals(@NonNull BpjsPatientReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.bpjsPatientReferrals.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be removed to this entity
	 */
	public void removeBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities) {
		this.removeBpjsPatientReferrals(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPatientReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPatientReferrals(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPatientReferrals(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to be set to this entity
	 */
	public void setBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities) {
		setBpjsPatientReferrals(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Patient Referrals with the given ones.
	 *
	 * @param entities the given collection of BpjsPatientReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPatientReferrals(@NonNull Collection<BpjsPatientReferralEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPatientReferrals();
		this.bpjsPatientReferrals = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPatientReferrals(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPatientReferrals() {
		this.unsetBpjsPatientReferrals(true);
	}

	/**
	 * Remove all the entities in BPJS Patient Referrals from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPatientReferrals(boolean doReverse) {
		if (doReverse) {
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsServiceMapping(false));
		}
		this.bpjsPatientReferrals.clear();
	}

/**
	 * Similar to {@link this#addPolikontrol(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addPolikontrol(@NonNull BpjsHospitalizationPlanEntity entity) {
		addPolikontrol(entity, true);
	}

	/**
	 * Add a new BpjsHospitalizationPlanEntity to polikontrol in this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPolikontrol(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverseAdd) {
		if (!this.polikontrol.contains(entity)) {
			polikontrol.add(entity);
			if (reverseAdd) {
				entity.setBpjsServiceMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPolikontrol(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addPolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		addPolikontrol(entities, true);
	}

	/**
	 * Add a new collection of BpjsHospitalizationPlanEntity to poliKontrol in this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPolikontrol(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePolikontrol(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void removePolikontrol(@NonNull BpjsHospitalizationPlanEntity entity) {
		this.removePolikontrol(entity, true);
	}

	/**
	 * Remove the given BpjsHospitalizationPlanEntity from this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePolikontrol(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsServiceMapping(false);
		}
		this.polikontrol.remove(entity);
	}

	/**
	 * Similar to {@link this#removePolikontrol(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 */
	public void removePolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		this.removePolikontrol(entities, true);
	}

	/**
	 * Remove the given collection of BpjsHospitalizationPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePolikontrol(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPolikontrol(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void setPolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		setPolikontrol(entities, true);
	}

	/**
	 * Replace the current entities in poliKontrol with the given ones.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPolikontrol(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {

		this.unsetPolikontrol();
		this.polikontrol = new HashSet<>(entities);
		if (reverseAdd) {
			this.polikontrol.forEach(polikontrolEntity -> polikontrolEntity.setBpjsServiceMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPolikontrol(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPolikontrol() {
		this.unsetPolikontrol(true);
	}

	/**
	 * Remove all the entities in poliKontrol from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPolikontrol(boolean doReverse) {
		if (doReverse) {
			this.polikontrol.forEach(polikontrolEntity -> polikontrolEntity.unsetBpjsServiceMapping(false));
		}
		this.polikontrol.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.unsetBpjsServiceMapping(false);
		}

		this.service = entity;
		if (reverseAdd) {
			this.service.setBpjsServiceMapping(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove the ServiceEntity of service from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.unsetBpjsServiceMapping();
		}
		this.service = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
