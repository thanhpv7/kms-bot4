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
public class BpjsProcedureEntity extends AbstractEntity {

	public BpjsProcedureEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalProcedureOneMany = new EntityReference();
			AdditionalProcedureOneMany.entityName = "BpjsSpecialReferral";
			AdditionalProcedureOneMany.oppositeName = "AdditionalProcedure";
			AdditionalProcedureOneMany.name = "AdditionalProcedure";
			AdditionalProcedureOneMany.optional = true;
			AdditionalProcedureOneMany.type = "One";
			AdditionalProcedureOneMany.oppositeType = "Many";

		References.add(AdditionalProcedureOneMany);

		var BpjsClaimSubmissionsOneMany = new EntityReference();
			BpjsClaimSubmissionsOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionsOneMany.oppositeName = "BpjsProcedure";
			BpjsClaimSubmissionsOneMany.name = "BpjsClaimSubmissions";
			BpjsClaimSubmissionsOneMany.optional = true;
			BpjsClaimSubmissionsOneMany.type = "One";
			BpjsClaimSubmissionsOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionsOneMany);

		var PrimaryProcedureOneMany = new EntityReference();
			PrimaryProcedureOneMany.entityName = "BpjsSpecialReferral";
			PrimaryProcedureOneMany.oppositeName = "PrimaryProcedure";
			PrimaryProcedureOneMany.name = "PrimaryProcedure";
			PrimaryProcedureOneMany.optional = true;
			PrimaryProcedureOneMany.type = "One";
			PrimaryProcedureOneMany.oppositeType = "Many";

		References.add(PrimaryProcedureOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Procedure Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Procedure Code here] end
	private String procedureCode;

	// % protected region % [Modify attribute annotation for Procedure Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Procedure Name here] end
	private String procedureName;

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

	private Set<BpjsSpecialReferralEntity> additionalProcedure = new HashSet<>();

	private Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();

	private Set<BpjsSpecialReferralEntity> primaryProcedure = new HashSet<>();

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
	 * Similar to {@link this#addAdditionalProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalProcedure(@NonNull BpjsSpecialReferralEntity entity) {
		addAdditionalProcedure(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to additionalProcedure in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.additionalProcedure.contains(entity)) {
			additionalProcedure.add(entity);
			if (reverseAdd) {
				entity.setAdditionalProcedure(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		addAdditionalProcedure(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Additional Procedure in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removeAdditionalProcedure(@NonNull BpjsSpecialReferralEntity entity) {
		this.removeAdditionalProcedure(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalProcedure(false);
		}
		this.additionalProcedure.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removeAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removeAdditionalProcedure(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		setAdditionalProcedure(entities, true);
	}

	/**
	 * Replace the current entities in Additional Procedure with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalProcedure();
		this.additionalProcedure = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalProcedure.forEach(additionalProcedureEntity -> additionalProcedureEntity.setAdditionalProcedure(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalProcedure(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalProcedure() {
		this.unsetAdditionalProcedure(true);
	}

	/**
	 * Remove all the entities in Additional Procedure from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalProcedure(boolean doReverse) {
		if (doReverse) {
			this.additionalProcedure.forEach(additionalProcedureEntity -> additionalProcedureEntity.unsetAdditionalProcedure(false));
		}
		this.additionalProcedure.clear();
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
				entity.setBpjsProcedure(this, false);
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
			entity.unsetBpjsProcedure(false);
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.setBpjsProcedure(this, false));
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
			this.bpjsClaimSubmissions.forEach(bpjsClaimSubmissionsEntity -> bpjsClaimSubmissionsEntity.unsetBpjsProcedure(false));
		}
		this.bpjsClaimSubmissions.clear();
	}

/**
	 * Similar to {@link this#addPrimaryProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryProcedure(@NonNull BpjsSpecialReferralEntity entity) {
		addPrimaryProcedure(entity, true);
	}

	/**
	 * Add a new BpjsSpecialReferralEntity to primaryProcedure in this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrimaryProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverseAdd) {
		if (!this.primaryProcedure.contains(entity)) {
			primaryProcedure.add(entity);
			if (reverseAdd) {
				entity.setPrimaryProcedure(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 */
	public void addPrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		addPrimaryProcedure(entities, true);
	}

	/**
	 * Add a new collection of BpjsSpecialReferralEntity to Primary Procedure in this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrimaryProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrimaryProcedure(BpjsSpecialReferralEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be set to this entity
	 */
	public void removePrimaryProcedure(@NonNull BpjsSpecialReferralEntity entity) {
		this.removePrimaryProcedure(entity, true);
	}

	/**
	 * Remove the given BpjsSpecialReferralEntity from this entity.
	 *
	 * @param entity the given BpjsSpecialReferralEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrimaryProcedure(@NonNull BpjsSpecialReferralEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrimaryProcedure(false);
		}
		this.primaryProcedure.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 */
	public void removePrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		this.removePrimaryProcedure(entities, true);
	}

	/**
	 * Remove the given collection of BpjsSpecialReferralEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrimaryProcedure(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrimaryProcedure(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to be set to this entity
	 */
	public void setPrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities) {
		setPrimaryProcedure(entities, true);
	}

	/**
	 * Replace the current entities in Primary Procedure with the given ones.
	 *
	 * @param entities the given collection of BpjsSpecialReferralEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrimaryProcedure(@NonNull Collection<BpjsSpecialReferralEntity> entities, boolean reverseAdd) {

		this.unsetPrimaryProcedure();
		this.primaryProcedure = new HashSet<>(entities);
		if (reverseAdd) {
			this.primaryProcedure.forEach(primaryProcedureEntity -> primaryProcedureEntity.setPrimaryProcedure(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrimaryProcedure(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrimaryProcedure() {
		this.unsetPrimaryProcedure(true);
	}

	/**
	 * Remove all the entities in Primary Procedure from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrimaryProcedure(boolean doReverse) {
		if (doReverse) {
			this.primaryProcedure.forEach(primaryProcedureEntity -> primaryProcedureEntity.unsetPrimaryProcedure(false));
		}
		this.primaryProcedure.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
