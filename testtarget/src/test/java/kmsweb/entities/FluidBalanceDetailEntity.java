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
public class FluidBalanceDetailEntity extends AbstractEntity {

	public FluidBalanceDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "FluidBalanceDetails";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "FluidBalanceDetails";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Record Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Record Date Time here] end
	private OffsetDateTime recordDateTime;

	// % protected region % [Modify attribute annotation for Intake Oral here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intake Oral here] end
	private Double intakeOral;

	// % protected region % [Modify attribute annotation for Intake NGT here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intake NGT here] end
	private Double intakeNGT;

	// % protected region % [Modify attribute annotation for Intake IV Line here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intake IV Line here] end
	private Double intakeIVLine;

	// % protected region % [Modify attribute annotation for Intake Others here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intake Others here] end
	private Double intakeOthers;

	// % protected region % [Modify attribute annotation for Output Urine here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output Urine here] end
	private Double outputUrine;

	// % protected region % [Modify attribute annotation for Output NGT here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output NGT here] end
	private Double outputNGT;

	// % protected region % [Modify attribute annotation for Output Drain here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output Drain here] end
	private Double outputDrain;

	// % protected region % [Modify attribute annotation for Output Stool here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output Stool here] end
	private Double outputStool;

	// % protected region % [Modify attribute annotation for Output Blood here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output Blood here] end
	private Double outputBlood;

	// % protected region % [Modify attribute annotation for Output IWL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output IWL here] end
	private Double outputIWL;

	// % protected region % [Modify attribute annotation for Output Others here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Output Others here] end
	private Double outputOthers;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Total Input here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Input here] end
	private Double totalInput;

	// % protected region % [Modify attribute annotation for Total Output here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Output here] end
	private Double totalOutput;

	// % protected region % [Modify attribute annotation for Total Balance Fluid here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Balance Fluid here] end
	private Double totalBalanceFluid;

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

	private RegistrationEntity registration;

	private StaffEntity staff;

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
	public void setRegistration(@NonNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeFluidBalanceDetails(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addFluidBalanceDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeFluidBalanceDetails(this, false);
		}
		this.registration = null;
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
			this.staff.removeFluidBalanceDetails(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addFluidBalanceDetails(this, false);
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
			this.staff.removeFluidBalanceDetails(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
