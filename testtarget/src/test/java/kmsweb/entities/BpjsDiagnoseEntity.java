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
public class BpjsDiagnoseEntity extends AbstractEntity {

	public BpjsDiagnoseEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalDiagnoseOneMany = new EntityReference();
			AdditionalDiagnoseOneMany.entityName = "BpjsSpecialReferral";
			AdditionalDiagnoseOneMany.oppositeName = "AdditionalDiagnose";
			AdditionalDiagnoseOneMany.name = "AdditionalDiagnose";
			AdditionalDiagnoseOneMany.optional = true;
			AdditionalDiagnoseOneMany.type = "One";
			AdditionalDiagnoseOneMany.oppositeType = "Many";

		References.add(AdditionalDiagnoseOneMany);

		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "BpjsDiagnose";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var BpjsPatientReferralsOneMany = new EntityReference();
			BpjsPatientReferralsOneMany.entityName = "BpjsPatientReferral";
			BpjsPatientReferralsOneMany.oppositeName = "BpjsDiagnose";
			BpjsPatientReferralsOneMany.name = "BpjsPatientReferrals";
			BpjsPatientReferralsOneMany.optional = true;
			BpjsPatientReferralsOneMany.type = "One";
			BpjsPatientReferralsOneMany.oppositeType = "Many";

		References.add(BpjsPatientReferralsOneMany);

		var DiagnosesAndProceduresOneOne = new EntityReference();
			DiagnosesAndProceduresOneOne.entityName = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.oppositeName = "BpjsDiagnose";
			DiagnosesAndProceduresOneOne.name = "DiagnosesAndProcedures";
			DiagnosesAndProceduresOneOne.optional = true;
			DiagnosesAndProceduresOneOne.type = "One";
			DiagnosesAndProceduresOneOne.oppositeType = "One";

		References.add(DiagnosesAndProceduresOneOne);

		var PrimaryDiagnoseOneMany = new EntityReference();
			PrimaryDiagnoseOneMany.entityName = "BpjsSpecialReferral";
			PrimaryDiagnoseOneMany.oppositeName = "PrimaryDiagnose";
			PrimaryDiagnoseOneMany.name = "PrimaryDiagnose";
			PrimaryDiagnoseOneMany.optional = true;
			PrimaryDiagnoseOneMany.type = "One";
			PrimaryDiagnoseOneMany.oppositeType = "Many";

		References.add(PrimaryDiagnoseOneMany);
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

	private DiagnosesAndProceduresEntity diagnosesAndProcedures;

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

	private Set<BpjsSpecialReferralEntity> additionalDiagnose = new HashSet<>();

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<BpjsPatientReferralEntity> bpjsPatientReferrals = new HashSet<>();

	private Set<BpjsSpecialReferralEntity> primaryDiagnose = new HashSet<>();

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
	 * Similar to {@link this#addAdditionalDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalDiagnose(@NonNull BpjsSpecialReferralEntity entity) {
		addAdditionalDiagnose(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to additionalDiagnose in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.additionalDiagnose.contains(entity)) {
			additionalDiagnose.add(entity);
			if (reverseAdd) {
				entity.setAdditionalDiagnose(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		addAdditionalDiagnose(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Additional Diagnose in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removeAdditionalDiagnose(@NonNull BpjsSpecialReferralEntity entity) {
		this.removeAdditionalDiagnose(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalDiagnose(false);
		}
		this.additionalDiagnose.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removeAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removeAdditionalDiagnose(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		setAdditionalDiagnose(entities, true);
	}

	/**
	 * Replace the current entities in Additional Diagnose with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalDiagnose();
		this.additionalDiagnose = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalDiagnose.forEach(additionalDiagnoseEntity -> additionalDiagnoseEntity.setAdditionalDiagnose(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalDiagnose(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalDiagnose() {
		this.unsetAdditionalDiagnose(true);
	}

	/**
	 * Remove all the entities in Additional Diagnose from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalDiagnose(boolean doReverse) {
		if (doReverse) {
			this.additionalDiagnose.forEach(additionalDiagnoseEntity -> additionalDiagnoseEntity.unsetAdditionalDiagnose(false));
		}
		this.additionalDiagnose.clear();
	}

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
				entity.setBpjsDiagnose(this, false);
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
			entity.unsetBpjsDiagnose(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsDiagnose(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsDiagnose(false));
		}
		this.bpjsClaimSubmissions.clear();
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
				entity.setBpjsDiagnose(this, false);
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
			entity.unsetBpjsDiagnose(false);
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.setBpjsDiagnose(this, false));
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
			this.bpjsPatientReferrals.forEach(bpjsPatientReferralsEntity -> bpjsPatientReferralsEntity.unsetBpjsDiagnose(false));
		}
		this.bpjsPatientReferrals.clear();
	}

	/**
	 * Similar to {@link this#setDiagnosesAndProcedures(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity entity) {
		setDiagnosesAndProcedures(entity, true);
	}

	/**
	 * Set or update diagnosesAndProcedures with the given DiagnosesAndProceduresEntity.
	 *
	 * @param entity the BpjsDiagnoseEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosesAndProcedures here] end

		if (sameAsFormer(this.diagnosesAndProcedures, entity)) {
			return;
		}

		if (this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnose();
		}

		this.diagnosesAndProcedures = entity;

		if (reverseAdd) {
			this.diagnosesAndProcedures.setBpjsDiagnose(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosesAndProcedures outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosesAndProcedures(boolean)} but default to true.
	 */
	public void unsetDiagnosesAndProcedures() {
		this.unsetDiagnosesAndProcedures(true);
	}

	/**
	 * Remove the DiagnosesAndProceduresEntity in Diagnoses and Procedures from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosesAndProcedures(boolean reverse) {
		if (reverse && this.diagnosesAndProcedures != null) {
			this.diagnosesAndProcedures.unsetBpjsDiagnose(false);
		}
		this.diagnosesAndProcedures = null;
	}

/**
	 * Similar to {@link this#addPrimaryDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryDiagnose(@NonNull BpjsSpecialReferralEntity entity) {
		addPrimaryDiagnose(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to primaryDiagnose in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrimaryDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.primaryDiagnose.contains(entity)) {
			primaryDiagnose.add(entity);
			if (reverseAdd) {
				entity.setPrimaryDiagnose(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		addPrimaryDiagnose(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Primary Diagnose in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrimaryDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrimaryDiagnose(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removePrimaryDiagnose(@NonNull BpjsSpecialReferralEntity entity) {
		this.removePrimaryDiagnose(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrimaryDiagnose(@NonNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrimaryDiagnose(false);
		}
		this.primaryDiagnose.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removePrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removePrimaryDiagnose(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrimaryDiagnose(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrimaryDiagnose(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setPrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		setPrimaryDiagnose(entities, true);
	}

	/**
	 * Replace the current entities in Primary Diagnose with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrimaryDiagnose(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetPrimaryDiagnose();
		this.primaryDiagnose = new HashSet<>(entities);
		if (reverseAdd) {
			this.primaryDiagnose.forEach(primaryDiagnoseEntity -> primaryDiagnoseEntity.setPrimaryDiagnose(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrimaryDiagnose(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrimaryDiagnose() {
		this.unsetPrimaryDiagnose(true);
	}

	/**
	 * Remove all the entities in Primary Diagnose from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrimaryDiagnose(boolean doReverse) {
		if (doReverse) {
			this.primaryDiagnose.forEach(primaryDiagnoseEntity -> primaryDiagnoseEntity.unsetPrimaryDiagnose(false));
		}
		this.primaryDiagnose.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
