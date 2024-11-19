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
public class BpjsTreatmentRoomEntity extends AbstractEntity {

	public BpjsTreatmentRoomEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsClaimSubmissionOneMany = new EntityReference();
			BpjsClaimSubmissionOneMany.entityName = "BpjsClaimSubmission";
			BpjsClaimSubmissionOneMany.oppositeName = "BpjsClaimSubmission";
			BpjsClaimSubmissionOneMany.name = "BpjsTreatmentRooms";
			BpjsClaimSubmissionOneMany.optional = true;
			BpjsClaimSubmissionOneMany.type = "One";
			BpjsClaimSubmissionOneMany.oppositeType = "Many";

		References.add(BpjsClaimSubmissionOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for kode here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kode here] end
	private String kode;

	// % protected region % [Modify attribute annotation for nama here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for nama here] end
	private String nama;

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

	private BpjsClaimSubmissionEntity bpjsClaimSubmission;

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
	 * Similar to {@link this#setBpjsClaimSubmission(BpjsClaimSubmissionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set to this entity
	 */
	public void setBpjsClaimSubmission(@NonNull BpjsClaimSubmissionEntity entity) {
		setBpjsClaimSubmission(entity, true);
	}

	/**
	 * Set or update the bpjsClaimSubmission in this entity with single BpjsClaimSubmissionEntity.
	 *
	 * @param entity the given BpjsClaimSubmissionEntity to be set or updated to bpjsClaimSubmission
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsClaimSubmission(@NonNull BpjsClaimSubmissionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsClaimSubmission here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsClaimSubmission here] end

		if (sameAsFormer(this.bpjsClaimSubmission, entity)) {
			return;
		}

		if (this.bpjsClaimSubmission != null) {
			this.bpjsClaimSubmission.removeBpjsTreatmentRooms(this, false);
		}
		this.bpjsClaimSubmission = entity;
		if (reverseAdd) {
			this.bpjsClaimSubmission.addBpjsTreatmentRooms(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsClaimSubmission incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsClaimSubmission incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsClaimSubmission(boolean)} but default to true.
	 */
	public void unsetBpjsClaimSubmission() {
		this.unsetBpjsClaimSubmission(true);
	}

	/**
	 * Remove BPJS Claim Submission in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsClaimSubmission(boolean reverse) {
		if (reverse && this.bpjsClaimSubmission != null) {
			this.bpjsClaimSubmission.removeBpjsTreatmentRooms(this, false);
		}
		this.bpjsClaimSubmission = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
