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
public class BpjsSpecialReferralEntity extends AbstractEntity {

	public BpjsSpecialReferralEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalDiagnoseOneMany = new EntityReference();
			AdditionalDiagnoseOneMany.entityName = "BpjsDiagnose";
			AdditionalDiagnoseOneMany.oppositeName = "AdditionalDiagnose";
			AdditionalDiagnoseOneMany.name = "AdditionalDiagnose";
			AdditionalDiagnoseOneMany.optional = true;
			AdditionalDiagnoseOneMany.type = "One";
			AdditionalDiagnoseOneMany.oppositeType = "Many";

		References.add(AdditionalDiagnoseOneMany);

		var AdditionalProcedureOneMany = new EntityReference();
			AdditionalProcedureOneMany.entityName = "BpjsProcedure";
			AdditionalProcedureOneMany.oppositeName = "AdditionalProcedure";
			AdditionalProcedureOneMany.name = "AdditionalProcedure";
			AdditionalProcedureOneMany.optional = true;
			AdditionalProcedureOneMany.type = "One";
			AdditionalProcedureOneMany.oppositeType = "Many";

		References.add(AdditionalProcedureOneMany);

		var PrimaryDiagnoseOneMany = new EntityReference();
			PrimaryDiagnoseOneMany.entityName = "BpjsDiagnose";
			PrimaryDiagnoseOneMany.oppositeName = "PrimaryDiagnose";
			PrimaryDiagnoseOneMany.name = "PrimaryDiagnose";
			PrimaryDiagnoseOneMany.optional = true;
			PrimaryDiagnoseOneMany.type = "One";
			PrimaryDiagnoseOneMany.oppositeType = "Many";

		References.add(PrimaryDiagnoseOneMany);

		var PrimaryProcedureOneMany = new EntityReference();
			PrimaryProcedureOneMany.entityName = "BpjsProcedure";
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

	// % protected region % [Modify attribute annotation for Referral ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral ID here] end
	private String referralID;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for PPK Diagnose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for PPK Diagnose here] end
	private String ppkDiagnose;

	// % protected region % [Modify attribute annotation for Referral Start Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral Start Date here] end
	private String referralStartDate;

	// % protected region % [Modify attribute annotation for Referral End Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referral End Date here] end
	private String referralEndDate;

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

	private BpjsDiagnoseEntity additionalDiagnose;

	private BpjsProcedureEntity additionalProcedure;

	private BpjsDiagnoseEntity primaryDiagnose;

	private BpjsProcedureEntity primaryProcedure;

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
	 * Similar to {@link this#setAdditionalDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setAdditionalDiagnose(@NonNull BpjsDiagnoseEntity entity) {
		setAdditionalDiagnose(entity, true);
	}

	/**
	 * Set or update the additionalDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to additionalDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalDiagnose(@NonNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalDiagnose here] end

		if (sameAsFormer(this.additionalDiagnose, entity)) {
			return;
		}

		if (this.additionalDiagnose != null) {
			this.additionalDiagnose.removeAdditionalDiagnose(this, false);
		}
		this.additionalDiagnose = entity;
		if (reverseAdd) {
			this.additionalDiagnose.addAdditionalDiagnose(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalDiagnose(boolean)} but default to true.
	 */
	public void unsetAdditionalDiagnose() {
		this.unsetAdditionalDiagnose(true);
	}

	/**
	 * Remove Additional Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalDiagnose(boolean reverse) {
		if (reverse && this.additionalDiagnose != null) {
			this.additionalDiagnose.removeAdditionalDiagnose(this, false);
		}
		this.additionalDiagnose = null;
	}
	/**
	 * Similar to {@link this#setAdditionalProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setAdditionalProcedure(@NonNull BpjsProcedureEntity entity) {
		setAdditionalProcedure(entity, true);
	}

	/**
	 * Set or update the additionalProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to additionalProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalProcedure(@NonNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalProcedure here] end

		if (sameAsFormer(this.additionalProcedure, entity)) {
			return;
		}

		if (this.additionalProcedure != null) {
			this.additionalProcedure.removeAdditionalProcedure(this, false);
		}
		this.additionalProcedure = entity;
		if (reverseAdd) {
			this.additionalProcedure.addAdditionalProcedure(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalProcedure(boolean)} but default to true.
	 */
	public void unsetAdditionalProcedure() {
		this.unsetAdditionalProcedure(true);
	}

	/**
	 * Remove Additional Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalProcedure(boolean reverse) {
		if (reverse && this.additionalProcedure != null) {
			this.additionalProcedure.removeAdditionalProcedure(this, false);
		}
		this.additionalProcedure = null;
	}
	/**
	 * Similar to {@link this#setPrimaryDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setPrimaryDiagnose(@NonNull BpjsDiagnoseEntity entity) {
		setPrimaryDiagnose(entity, true);
	}

	/**
	 * Set or update the primaryDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to primaryDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrimaryDiagnose(@NonNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrimaryDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrimaryDiagnose here] end

		if (sameAsFormer(this.primaryDiagnose, entity)) {
			return;
		}

		if (this.primaryDiagnose != null) {
			this.primaryDiagnose.removePrimaryDiagnose(this, false);
		}
		this.primaryDiagnose = entity;
		if (reverseAdd) {
			this.primaryDiagnose.addPrimaryDiagnose(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrimaryDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrimaryDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrimaryDiagnose(boolean)} but default to true.
	 */
	public void unsetPrimaryDiagnose() {
		this.unsetPrimaryDiagnose(true);
	}

	/**
	 * Remove Primary Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrimaryDiagnose(boolean reverse) {
		if (reverse && this.primaryDiagnose != null) {
			this.primaryDiagnose.removePrimaryDiagnose(this, false);
		}
		this.primaryDiagnose = null;
	}
	/**
	 * Similar to {@link this#setPrimaryProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setPrimaryProcedure(@NonNull BpjsProcedureEntity entity) {
		setPrimaryProcedure(entity, true);
	}

	/**
	 * Set or update the primaryProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to primaryProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrimaryProcedure(@NonNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrimaryProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrimaryProcedure here] end

		if (sameAsFormer(this.primaryProcedure, entity)) {
			return;
		}

		if (this.primaryProcedure != null) {
			this.primaryProcedure.removePrimaryProcedure(this, false);
		}
		this.primaryProcedure = entity;
		if (reverseAdd) {
			this.primaryProcedure.addPrimaryProcedure(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrimaryProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrimaryProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrimaryProcedure(boolean)} but default to true.
	 */
	public void unsetPrimaryProcedure() {
		this.unsetPrimaryProcedure(true);
	}

	/**
	 * Remove Primary Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrimaryProcedure(boolean reverse) {
		if (reverse && this.primaryProcedure != null) {
			this.primaryProcedure.removePrimaryProcedure(this, false);
		}
		this.primaryProcedure = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
