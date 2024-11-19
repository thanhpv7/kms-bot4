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
public class ExaminationItemDetailEntity extends AbstractEntity {

	public ExaminationItemDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ExaminationItemOneMany = new EntityReference();
			ExaminationItemOneMany.entityName = "ExaminationItem";
			ExaminationItemOneMany.oppositeName = "ExaminationItem";
			ExaminationItemOneMany.name = "ExaminationItemDetails";
			ExaminationItemOneMany.optional = true;
			ExaminationItemOneMany.type = "One";
			ExaminationItemOneMany.oppositeType = "Many";

		References.add(ExaminationItemOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Age Minimum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age Minimum here] end
	private Integer ageMinimum;

	// % protected region % [Modify attribute annotation for Age Maximum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age Maximum here] end
	private Integer ageMaximum;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Normal Range Low here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Normal Range Low here] end
	private Double normalRangeLow;

	// % protected region % [Modify attribute annotation for Normal Range High here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Normal Range High here] end
	private Double normalRangeHigh;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Critical Value Low here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Critical Value Low here] end
	private Double criticalValueLow;

	// % protected region % [Modify attribute annotation for Critical Value High here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Critical Value High here] end
	private Double criticalValueHigh;

	// % protected region % [Modify attribute annotation for Age Min Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age Min Unit here] end
	private String ageMinUnit;

	// % protected region % [Modify attribute annotation for Age Max Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age Max Unit here] end
	private String ageMaxUnit;

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

	private ExaminationItemEntity examinationItem;

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
	 * Similar to {@link this#setExaminationItem(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItem(@NonNull ExaminationItemEntity entity) {
		setExaminationItem(entity, true);
	}

	/**
	 * Set or update the examinationItem in this entity with single ExaminationItemEntity.
	 *
	 * @param entity the given ExaminationItemEntity to be set or updated to examinationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationItem(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] end

		if (sameAsFormer(this.examinationItem, entity)) {
			return;
		}

		if (this.examinationItem != null) {
			this.examinationItem.removeExaminationItemDetails(this, false);
		}
		this.examinationItem = entity;
		if (reverseAdd) {
			this.examinationItem.addExaminationItemDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetExaminationItem(boolean)} but default to true.
	 */
	public void unsetExaminationItem() {
		this.unsetExaminationItem(true);
	}

	/**
	 * Remove Examination Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetExaminationItem(boolean reverse) {
		if (reverse && this.examinationItem != null) {
			this.examinationItem.removeExaminationItemDetails(this, false);
		}
		this.examinationItem = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
