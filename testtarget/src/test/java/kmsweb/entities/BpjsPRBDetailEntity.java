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
public class BpjsPRBDetailEntity extends AbstractEntity {

	public BpjsPRBDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "Registration";
			RegistrationOneOne.name = "BpjsPRBDetail";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);

		var BpjsDrugGenericPRBOneMany = new EntityReference();
			BpjsDrugGenericPRBOneMany.entityName = "BpjsDrugGenericPRB";
			BpjsDrugGenericPRBOneMany.oppositeName = "BpjsDrugGenericPRB";
			BpjsDrugGenericPRBOneMany.name = "BpjsPRBDetails";
			BpjsDrugGenericPRBOneMany.optional = true;
			BpjsDrugGenericPRBOneMany.type = "One";
			BpjsDrugGenericPRBOneMany.oppositeType = "Many";

		References.add(BpjsDrugGenericPRBOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SRB No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SRB No here] end
	private String srbNo;

	// % protected region % [Modify attribute annotation for Drug Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Code here] end
	private String drugCode;

	// % protected region % [Modify attribute annotation for Drug Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Name here] end
	private String drugName;

	// % protected region % [Modify attribute annotation for Signa 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa 1 here] end
	private String signa1;

	// % protected region % [Modify attribute annotation for Signa 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa 2 here] end
	private String signa2;

	// % protected region % [Modify attribute annotation for Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Qty here] end
	private String qty;

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

	private RegistrationEntity registration;

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

	private BpjsDrugGenericPRBEntity bpjsDrugGenericPRB;

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
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetBpjsPRBDetail(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setBpjsPRBDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetBpjsPRBDetail();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setBpjsDrugGenericPRB(@NonNull BpjsDrugGenericPRBEntity entity) {
		setBpjsDrugGenericPRB(entity, true);
	}

	/**
	 * Set or update the bpjsDrugGenericPRB in this entity with single BpjsDrugGenericPRBEntity.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set or updated to bpjsDrugGenericPRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDrugGenericPRB(@NonNull BpjsDrugGenericPRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] end

		if (sameAsFormer(this.bpjsDrugGenericPRB, entity)) {
			return;
		}

		if (this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.removeBpjsPRBDetails(this, false);
		}
		this.bpjsDrugGenericPRB = entity;
		if (reverseAdd) {
			this.bpjsDrugGenericPRB.addBpjsPRBDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDrugGenericPRB(boolean)} but default to true.
	 */
	public void unsetBpjsDrugGenericPRB() {
		this.unsetBpjsDrugGenericPRB(true);
	}

	/**
	 * Remove BPJS Drug Generic PRB in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDrugGenericPRB(boolean reverse) {
		if (reverse && this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.removeBpjsPRBDetails(this, false);
		}
		this.bpjsDrugGenericPRB = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
