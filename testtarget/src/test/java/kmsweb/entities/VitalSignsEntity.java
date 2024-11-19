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
public class VitalSignsEntity extends AbstractEntity {

	public VitalSignsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var NewbornDetailOneMany = new EntityReference();
			NewbornDetailOneMany.entityName = "NewbornDetail";
			NewbornDetailOneMany.oppositeName = "NewbornDetail";
			NewbornDetailOneMany.name = "VitalSigns";
			NewbornDetailOneMany.optional = true;
			NewbornDetailOneMany.type = "One";
			NewbornDetailOneMany.oppositeType = "Many";

		References.add(NewbornDetailOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Time here] end
	private String time;

	// % protected region % [Modify attribute annotation for HR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HR here] end
	private String hr;

	// % protected region % [Modify attribute annotation for RR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for RR here] end
	private String rr;

	// % protected region % [Modify attribute annotation for Temprature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temprature here] end
	private String temprature;

	// % protected region % [Modify attribute annotation for O2 Saturation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for O2 Saturation here] end
	private String o2Saturation;

	// % protected region % [Modify attribute annotation for Remarks here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Remarks here] end
	private String remarks;

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

	private NewbornDetailEntity newbornDetail;

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
	 * Similar to {@link this#setNewbornDetail(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void setNewbornDetail(@NonNull NewbornDetailEntity entity) {
		setNewbornDetail(entity, true);
	}

	/**
	 * Set or update the newbornDetail in this entity with single NewbornDetailEntity.
	 *
	 * @param entity the given NewbornDetailEntity to be set or updated to newbornDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNewbornDetail(@NonNull NewbornDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNewbornDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNewbornDetail here] end

		if (sameAsFormer(this.newbornDetail, entity)) {
			return;
		}

		if (this.newbornDetail != null) {
			this.newbornDetail.removeVitalSigns(this, false);
		}
		this.newbornDetail = entity;
		if (reverseAdd) {
			this.newbornDetail.addVitalSigns(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNewbornDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNewbornDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNewbornDetail(boolean)} but default to true.
	 */
	public void unsetNewbornDetail() {
		this.unsetNewbornDetail(true);
	}

	/**
	 * Remove Newborn Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNewbornDetail(boolean reverse) {
		if (reverse && this.newbornDetail != null) {
			this.newbornDetail.removeVitalSigns(this, false);
		}
		this.newbornDetail = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
