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
public class DoctorScheduleEntity extends AbstractEntity {

	public DoctorScheduleEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ServiceOneMany = new EntityReference();
			ServiceOneMany.entityName = "Service";
			ServiceOneMany.oppositeName = "Service";
			ServiceOneMany.name = "DoctorSchedules";
			ServiceOneMany.optional = true;
			ServiceOneMany.type = "One";
			ServiceOneMany.oppositeType = "Many";

		References.add(ServiceOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "DoctorSchedules";
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

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Interval in minutes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Interval in minutes here] end
	private Integer intervalInMinutes;

	// % protected region % [Modify attribute annotation for Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Location here] end
	private String location;

	// % protected region % [Modify attribute annotation for Scheduler Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Scheduler Type here] end
	private String schedulerType;

	// % protected region % [Modify attribute annotation for Monday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Monday here] end
	private Boolean monday;

	// % protected region % [Modify attribute annotation for Tuesday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tuesday here] end
	private Boolean tuesday;

	// % protected region % [Modify attribute annotation for Wednesday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Wednesday here] end
	private Boolean wednesday;

	// % protected region % [Modify attribute annotation for Thursday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Thursday here] end
	private Boolean thursday;

	// % protected region % [Modify attribute annotation for Friday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Friday here] end
	private Boolean friday;

	// % protected region % [Modify attribute annotation for Saturday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Saturday here] end
	private Boolean saturday;

	// % protected region % [Modify attribute annotation for Sunday here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sunday here] end
	private Boolean sunday;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Training here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Training here] end
	private String training;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Shift here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shift here] end
	private String shift;

	// % protected region % [Modify attribute annotation for Intervals here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Intervals here] end
	private Integer intervals;

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

	private ServiceEntity service;

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
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(@NonNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NonNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.removeDoctorSchedules(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addDoctorSchedules(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove Service in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.removeDoctorSchedules(this, false);
		}
		this.service = null;
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
			this.staff.removeDoctorSchedules(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDoctorSchedules(this, false);
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
			this.staff.removeDoctorSchedules(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
