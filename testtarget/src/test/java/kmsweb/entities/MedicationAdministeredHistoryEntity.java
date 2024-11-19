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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class MedicationAdministeredHistoryEntity extends AbstractEntity {

	public MedicationAdministeredHistoryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicationItemOneMany = new EntityReference();
			MedicationItemOneMany.entityName = "MedicationItem";
			MedicationItemOneMany.oppositeName = "MedicationItem";
			MedicationItemOneMany.name = "MedicationAdministeredHisotries";
			MedicationItemOneMany.optional = true;
			MedicationItemOneMany.type = "One";
			MedicationItemOneMany.oppositeType = "Many";

		References.add(MedicationItemOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "MedicationAdministeredHisotries";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);

		var MedicationCompoundOneMany = new EntityReference();
			MedicationCompoundOneMany.entityName = "MedicationCompound";
			MedicationCompoundOneMany.oppositeName = "MedicationCompound";
			MedicationCompoundOneMany.name = "MedicationAdministeredHistories";
			MedicationCompoundOneMany.optional = true;
			MedicationCompoundOneMany.type = "One";
			MedicationCompoundOneMany.oppositeType = "Many";

		References.add(MedicationCompoundOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for DateTime here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DateTime here] end
	private OffsetDateTime datetime;

	// % protected region % [Modify attribute annotation for Administration Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Administration Notes here] end
	private String administrationNotes;

	// % protected region % [Modify attribute annotation for Administered Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Administered Quantity here] end
	private Integer administeredQuantity;

	// % protected region % [Modify attribute annotation for Taken Home Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Taken Home Quantity here] end
	private Integer takenHomeQuantity;

	// % protected region % [Modify attribute annotation for Returned Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Returned Quantity here] end
	private Integer returnedQuantity;

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

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

	private MedicationItemEntity medicationItem;

	private StaffEntity staff;

	private MedicationCompoundEntity medicationCompound;

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
	 * Similar to {@link this#setMedicationItem(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItem(@NonNull MedicationItemEntity entity) {
		setMedicationItem(entity, true);
	}

	/**
	 * Set or update the medicationItem in this entity with single MedicationItemEntity.
	 *
	 * @param entity the given MedicationItemEntity to be set or updated to medicationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationItem(@NonNull MedicationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationItem here] end

		if (sameAsFormer(this.medicationItem, entity)) {
			return;
		}

		if (this.medicationItem != null) {
			this.medicationItem.removeMedicationAdministeredHisotries(this, false);
		}
		this.medicationItem = entity;
		if (reverseAdd) {
			this.medicationItem.addMedicationAdministeredHisotries(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationItem(boolean)} but default to true.
	 */
	public void unsetMedicationItem() {
		this.unsetMedicationItem(true);
	}

	/**
	 * Remove Medication Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationItem(boolean reverse) {
		if (reverse && this.medicationItem != null) {
			this.medicationItem.removeMedicationAdministeredHisotries(this, false);
		}
		this.medicationItem = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NonNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeMedicationAdministeredHisotries(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addMedicationAdministeredHisotries(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeMedicationAdministeredHisotries(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setMedicationCompound(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be set to this entity
	 */
	public void setMedicationCompound(@NonNull MedicationCompoundEntity entity) {
		setMedicationCompound(entity, true);
	}

	/**
	 * Set or update the medicationCompound in this entity with single MedicationCompoundEntity.
	 *
	 * @param entity the given MedicationCompoundEntity to be set or updated to medicationCompound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationCompound(@NonNull MedicationCompoundEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] end

		if (sameAsFormer(this.medicationCompound, entity)) {
			return;
		}

		if (this.medicationCompound != null) {
			this.medicationCompound.removeMedicationAdministeredHistories(this, false);
		}
		this.medicationCompound = entity;
		if (reverseAdd) {
			this.medicationCompound.addMedicationAdministeredHistories(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationCompound(boolean)} but default to true.
	 */
	public void unsetMedicationCompound() {
		this.unsetMedicationCompound(true);
	}

	/**
	 * Remove Medication Compound in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationCompound(boolean reverse) {
		if (reverse && this.medicationCompound != null) {
			this.medicationCompound.removeMedicationAdministeredHistories(this, false);
		}
		this.medicationCompound = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
