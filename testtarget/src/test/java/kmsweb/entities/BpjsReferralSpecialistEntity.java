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
public class BpjsReferralSpecialistEntity extends AbstractEntity {

	public BpjsReferralSpecialistEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsHealthFacilityOneMany = new EntityReference();
			BpjsHealthFacilityOneMany.entityName = "BpjsHealthFacility";
			BpjsHealthFacilityOneMany.oppositeName = "BpjsHealthFacility";
			BpjsHealthFacilityOneMany.name = "BpjsReferralSpecialists";
			BpjsHealthFacilityOneMany.optional = true;
			BpjsHealthFacilityOneMany.type = "One";
			BpjsHealthFacilityOneMany.oppositeType = "Many";

		References.add(BpjsHealthFacilityOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Specialist Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specialist Code here] end
	private String specialistCode;

	// % protected region % [Modify attribute annotation for Specialist Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specialist Name here] end
	private String specialistName;

	// % protected region % [Modify attribute annotation for Capacity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Capacity here] end
	private String capacity;

	// % protected region % [Modify attribute annotation for Total Referral here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Referral here] end
	private String totalReferral;

	// % protected region % [Modify attribute annotation for Percentage here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Percentage here] end
	private String percentage;

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

	private BpjsHealthFacilityEntity bpjsHealthFacility;

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
	 * Similar to {@link this#setBpjsHealthFacility(BpjsHealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set to this entity
	 */
	public void setBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity entity) {
		setBpjsHealthFacility(entity, true);
	}

	/**
	 * Set or update the bpjsHealthFacility in this entity with single BpjsHealthFacilityEntity.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set or updated to bpjsHealthFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] end

		if (sameAsFormer(this.bpjsHealthFacility, entity)) {
			return;
		}

		if (this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsReferralSpecialists(this, false);
		}
		this.bpjsHealthFacility = entity;
		if (reverseAdd) {
			this.bpjsHealthFacility.addBpjsReferralSpecialists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsHealthFacility(boolean)} but default to true.
	 */
	public void unsetBpjsHealthFacility() {
		this.unsetBpjsHealthFacility(true);
	}

	/**
	 * Remove BPJS Health Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsHealthFacility(boolean reverse) {
		if (reverse && this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsReferralSpecialists(this, false);
		}
		this.bpjsHealthFacility = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
