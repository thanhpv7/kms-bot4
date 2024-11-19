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
public class BpjsHealthFacilityEntity extends AbstractEntity {

	public BpjsHealthFacilityEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "BpjsHealthFacility";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var BpjsFacilityListsOneMany = new EntityReference();
			BpjsFacilityListsOneMany.entityName = "BpjsFacilityList";
			BpjsFacilityListsOneMany.oppositeName = "BpjsHealthFacility";
			BpjsFacilityListsOneMany.name = "BpjsFacilityLists";
			BpjsFacilityListsOneMany.optional = true;
			BpjsFacilityListsOneMany.type = "One";
			BpjsFacilityListsOneMany.oppositeType = "Many";

		References.add(BpjsFacilityListsOneMany);

		var BpjsPatientReferralsOneMany = new EntityReference();
			BpjsPatientReferralsOneMany.entityName = "BpjsPatientReferral";
			BpjsPatientReferralsOneMany.oppositeName = "BpjsHealthFacility";
			BpjsPatientReferralsOneMany.name = "BpjsPatientReferrals";
			BpjsPatientReferralsOneMany.optional = true;
			BpjsPatientReferralsOneMany.type = "One";
			BpjsPatientReferralsOneMany.oppositeType = "Many";

		References.add(BpjsPatientReferralsOneMany);

		var BpjsReferralSpecialistsOneMany = new EntityReference();
			BpjsReferralSpecialistsOneMany.entityName = "BpjsReferralSpecialist";
			BpjsReferralSpecialistsOneMany.oppositeName = "BpjsHealthFacility";
			BpjsReferralSpecialistsOneMany.name = "BpjsReferralSpecialists";
			BpjsReferralSpecialistsOneMany.optional = true;
			BpjsReferralSpecialistsOneMany.type = "One";
			BpjsReferralSpecialistsOneMany.oppositeType = "Many";

		References.add(BpjsReferralSpecialistsOneMany);
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

	// % protected region % [Modify attribute annotation for Ref Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Name here] end
	private String refName;

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

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<BpjsFacilityListEntity> bpjsFacilityLists = new HashSet<>();

	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	private Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialists = new HashSet<>();

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
				entity.setBpjsHealthFacility(this, false);
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
			entity.unsetBpjsHealthFacility(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsHealthFacility(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addBpjsFacilityLists(BpjsFacilityListEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsFacilityListEntity to be added to this entity
	 */
	public void addBpjsFacilityLists(@NonNull BpjsFacilityListEntity entity) {
		addBpjsFacilityLists(entity, true);
	}

	/**
	 * Add a new BpjsFacilityListEntity to bpjsFacilityLists in this entity.
	 *
	 * @param entity the given BpjsFacilityListEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsFacilityLists(@NonNull BpjsFacilityListEntity entity, boolean reverseAdd) {
		if (!this.bpjsFacilityLists.contains(entity)) {
			bpjsFacilityLists.add(entity);
			if (reverseAdd) {
				entity.setBpjsHealthFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be added to this entity
	 */
	public void addBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities) {
		addBpjsFacilityLists(entities, true);
	}

	/**
	 * Add a new collection of BpjsFacilityListEntity to BPJS Facility Lists in this entity.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsFacilityLists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsFacilityLists(BpjsFacilityListEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsFacilityListEntity to be set to this entity
	 */
	public void removeBpjsFacilityLists(@NonNull BpjsFacilityListEntity entity) {
		this.removeBpjsFacilityLists(entity, true);
	}

	/**
	 * Remove the given BpjsFacilityListEntity from this entity.
	 *
	 * @param entity the given BpjsFacilityListEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsFacilityLists(@NonNull BpjsFacilityListEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsHealthFacility(false);
		}
		this.bpjsFacilityLists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be removed to this entity
	 */
	public void removeBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities) {
		this.removeBpjsFacilityLists(entities, true);
	}

	/**
	 * Remove the given collection of BpjsFacilityListEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsFacilityLists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsFacilityLists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to be set to this entity
	 */
	public void setBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities) {
		setBpjsFacilityLists(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Facility Lists with the given ones.
	 *
	 * @param entities the given collection of BpjsFacilityListEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsFacilityLists(@NonNull Collection<BpjsFacilityListEntity> entities, boolean reverseAdd) {

		this.unsetBpjsFacilityLists();
		this.bpjsFacilityLists = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsFacilityLists.forEach(bpjsFacilityListsEntity -> bpjsFacilityListsEntity.setBpjsHealthFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsFacilityLists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsFacilityLists() {
		this.unsetBpjsFacilityLists(true);
	}

	/**
	 * Remove all the entities in BPJS Facility Lists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsFacilityLists(boolean doReverse) {
		if (doReverse) {
			this.bpjsFacilityLists.forEach(bpjsFacilityListsEntity -> bpjsFacilityListsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsFacilityLists.clear();
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
				entity.setBpjsHealthFacility(this, false);
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
			entity.unsetBpjsHealthFacility(false);
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsHealthFacility(this, false));
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsPatientReferrals.clear();
	}

/**
	 * Similar to {@link this#addBpjsReferralSpecialists(BpjsReferralSpecialistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be added to this entity
	 */
	public void addBpjsReferralSpecialists(@NonNull BpjsReferralSpecialistEntity entity) {
		addBpjsReferralSpecialists(entity, true);
	}

	/**
	 * Add a new BpjsReferralSpecialistEntity to bpjsReferralSpecialists in this entity.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsReferralSpecialists(@NonNull BpjsReferralSpecialistEntity entity, boolean reverseAdd) {
		if (!this.bpjsReferralSpecialists.contains(entity)) {
			bpjsReferralSpecialists.add(entity);
			if (reverseAdd) {
				entity.setBpjsHealthFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be added to this entity
	 */
	public void addBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities) {
		addBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Add a new collection of BpjsReferralSpecialistEntity to BPJS Referral Specialists in this entity.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsReferralSpecialists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsReferralSpecialists(BpjsReferralSpecialistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be set to this entity
	 */
	public void removeBpjsReferralSpecialists(@NonNull BpjsReferralSpecialistEntity entity) {
		this.removeBpjsReferralSpecialists(entity, true);
	}

	/**
	 * Remove the given BpjsReferralSpecialistEntity from this entity.
	 *
	 * @param entity the given BpjsReferralSpecialistEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsReferralSpecialists(@NonNull BpjsReferralSpecialistEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsHealthFacility(false);
		}
		this.bpjsReferralSpecialists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be removed to this entity
	 */
	public void removeBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities) {
		this.removeBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Remove the given collection of BpjsReferralSpecialistEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsReferralSpecialists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsReferralSpecialists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to be set to this entity
	 */
	public void setBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities) {
		setBpjsReferralSpecialists(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Referral Specialists with the given ones.
	 *
	 * @param entities the given collection of BpjsReferralSpecialistEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsReferralSpecialists(@NonNull Collection<BpjsReferralSpecialistEntity> entities, boolean reverseAdd) {

		this.unsetBpjsReferralSpecialists();
		this.bpjsReferralSpecialists = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsReferralSpecialists.forEach(bpjsReferralSpecialistsEntity -> bpjsReferralSpecialistsEntity.setBpjsHealthFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsReferralSpecialists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsReferralSpecialists() {
		this.unsetBpjsReferralSpecialists(true);
	}

	/**
	 * Remove all the entities in BPJS Referral Specialists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsReferralSpecialists(boolean doReverse) {
		if (doReverse) {
			this.bpjsReferralSpecialists.forEach(bpjsReferralSpecialistsEntity -> bpjsReferralSpecialistsEntity.unsetBpjsHealthFacility(false));
		}
		this.bpjsReferralSpecialists.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
