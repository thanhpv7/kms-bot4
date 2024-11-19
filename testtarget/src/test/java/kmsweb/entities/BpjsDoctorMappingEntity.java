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
public class BpjsDoctorMappingEntity extends AbstractEntity {

	public BpjsDoctorMappingEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "BpjsDoctorMapping";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var BpjsControlPlansOneMany = new EntityReference();
			BpjsControlPlansOneMany.entityName = "BpjsControlPlan";
			BpjsControlPlansOneMany.oppositeName = "BpjsDoctorMapping";
			BpjsControlPlansOneMany.name = "BpjsControlPlans";
			BpjsControlPlansOneMany.optional = true;
			BpjsControlPlansOneMany.type = "One";
			BpjsControlPlansOneMany.oppositeType = "Many";

		References.add(BpjsControlPlansOneMany);

		var StaffOneOne = new EntityReference();
			StaffOneOne.entityName = "Staff";
			StaffOneOne.oppositeName = "Staff";
			StaffOneOne.name = "BpjsDoctorMapping";
			StaffOneOne.optional = true;
			StaffOneOne.type = "One";
			StaffOneOne.oppositeType = "One";

		References.add(StaffOneOne);

		var BpjsPRBsOneMany = new EntityReference();
			BpjsPRBsOneMany.entityName = "BpjsPRB";
			BpjsPRBsOneMany.oppositeName = "BpjsDoctorMapping";
			BpjsPRBsOneMany.name = "BpjsPRBs";
			BpjsPRBsOneMany.optional = true;
			BpjsPRBsOneMany.type = "One";
			BpjsPRBsOneMany.oppositeType = "Many";

		References.add(BpjsPRBsOneMany);

		var KodedokterOneMany = new EntityReference();
			KodedokterOneMany.entityName = "BpjsHospitalizationPlan";
			KodedokterOneMany.oppositeName = "BpjsDoctorMapping";
			KodedokterOneMany.name = "Kodedokter";
			KodedokterOneMany.optional = true;
			KodedokterOneMany.type = "One";
			KodedokterOneMany.oppositeType = "Many";

		References.add(KodedokterOneMany);
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

	// % protected region % [Modify attribute annotation for BPJS Medical Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Medical Staff here] end
	private String bpjsMedicalStaff;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Ref Code Service here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ref Code Service here] end
	private String refCodeService;

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

	private StaffEntity staff;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<BpjsControlPlanEntity> bpjsControlPlans = new HashSet<>();

	private Set<BpjsPRBEntity> bpjsPRBs = new HashSet<>();

	private Set<BpjsHospitalizationPlanEntity> kodedokter = new HashSet<>();

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
				entity.setBpjsDoctorMapping(this, false);
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
			entity.unsetBpjsDoctorMapping(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsDoctorMapping(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsDoctorMapping(false));
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
				entity.setBpjsDoctorMapping(this, false);
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
			entity.unsetBpjsDoctorMapping(false);
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
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.setBpjsDoctorMapping(this, false));
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
			this.bpjsControlPlans.forEach(bpjsControlPlansEntity -> bpjsControlPlansEntity.unsetBpjsDoctorMapping(false));
		}
		this.bpjsControlPlans.clear();
	}

/**
	 * Similar to {@link this#addBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NonNull BpjsPRBEntity entity) {
		addBpjsPRBs(entity, true);
	}

	/**
	 * Add a new BpjsPRBEntity to bpjsPRBs in this entity.
	 *
	 * @param entity the given BpjsPRBEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPRBs(@NonNull BpjsPRBEntity entity, boolean reverseAdd) {
		if (!this.bpjsPRBs.contains(entity)) {
			bpjsPRBs.add(entity);
			if (reverseAdd) {
				entity.setBpjsDoctorMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 */
	public void addBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		addBpjsPRBs(entities, true);
	}

	/**
	 * Add a new collection of BpjsPRBEntity to BPJS PRBs in this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(BpjsPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBEntity to be set to this entity
	 */
	public void removeBpjsPRBs(@NonNull BpjsPRBEntity entity) {
		this.removeBpjsPRBs(entity, true);
	}

	/**
	 * Remove the given BpjsPRBEntity from this entity.
	 *
	 * @param entity the given BpjsPRBEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPRBs(@NonNull BpjsPRBEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDoctorMapping(false);
		}
		this.bpjsPRBs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 */
	public void removeBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		this.removeBpjsPRBs(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPRBEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPRBs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPRBs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBEntity to be set to this entity
	 */
	public void setBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities) {
		setBpjsPRBs(entities, true);
	}

	/**
	 * Replace the current entities in BPJS PRBs with the given ones.
	 *
	 * @param entities the given collection of BpjsPRBEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPRBs(@NonNull Collection<BpjsPRBEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPRBs();
		this.bpjsPRBs = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.setBpjsDoctorMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPRBs() {
		this.unsetBpjsPRBs(true);
	}

	/**
	 * Remove all the entities in BPJS PRBs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPRBs(boolean doReverse) {
		if (doReverse) {
			this.bpjsPRBs.forEach(bpjsPRBsEntity -> bpjsPRBsEntity.unsetBpjsDoctorMapping(false));
		}
		this.bpjsPRBs.clear();
	}

/**
	 * Similar to {@link this#addKodedokter(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addKodedokter(@NonNull BpjsHospitalizationPlanEntity entity) {
		addKodedokter(entity, true);
	}

	/**
	 * Add a new BpjsHospitalizationPlanEntity to kodedokter in this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addKodedokter(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverseAdd) {
		if (!this.kodedokter.contains(entity)) {
			kodedokter.add(entity);
			if (reverseAdd) {
				entity.setBpjsDoctorMapping(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addKodedokter(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 */
	public void addKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		addKodedokter(entities, true);
	}

	/**
	 * Add a new collection of BpjsHospitalizationPlanEntity to kodeDokter in this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addKodedokter(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeKodedokter(BpjsHospitalizationPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void removeKodedokter(@NonNull BpjsHospitalizationPlanEntity entity) {
		this.removeKodedokter(entity, true);
	}

	/**
	 * Remove the given BpjsHospitalizationPlanEntity from this entity.
	 *
	 * @param entity the given BpjsHospitalizationPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeKodedokter(@NonNull BpjsHospitalizationPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDoctorMapping(false);
		}
		this.kodedokter.remove(entity);
	}

	/**
	 * Similar to {@link this#removeKodedokter(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 */
	public void removeKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		this.removeKodedokter(entities, true);
	}

	/**
	 * Remove the given collection of BpjsHospitalizationPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeKodedokter(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setKodedokter(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to be set to this entity
	 */
	public void setKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities) {
		setKodedokter(entities, true);
	}

	/**
	 * Replace the current entities in kodeDokter with the given ones.
	 *
	 * @param entities the given collection of BpjsHospitalizationPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setKodedokter(@NonNull Collection<BpjsHospitalizationPlanEntity> entities, boolean reverseAdd) {

		this.unsetKodedokter();
		this.kodedokter = new HashSet<>(entities);
		if (reverseAdd) {
			this.kodedokter.forEach(kodedokterEntity -> kodedokterEntity.setBpjsDoctorMapping(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetKodedokter(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetKodedokter() {
		this.unsetKodedokter(true);
	}

	/**
	 * Remove all the entities in kodeDokter from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetKodedokter(boolean doReverse) {
		if (doReverse) {
			this.kodedokter.forEach(kodedokterEntity -> kodedokterEntity.unsetBpjsDoctorMapping(false));
		}
		this.kodedokter.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.unsetBpjsDoctorMapping(false);
		}

		this.staff = entity;
		if (reverseAdd) {
			this.staff.setBpjsDoctorMapping(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove the StaffEntity of staff from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.unsetBpjsDoctorMapping();
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
