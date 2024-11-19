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
public class PatientVitalInformationEntity extends AbstractEntity {

	public PatientVitalInformationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "PatientVitalInformations";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "PatientVitalInformations";
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

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Systole here] end
	private Double systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Double diastole;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature Scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Double pulse;

	// % protected region % [Modify attribute annotation for Pulse Rhythm here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Rhythm here] end
	private String pulseRhythm;

	// % protected region % [Modify attribute annotation for Strength here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Strength here] end
	private String strength;

	// % protected region % [Modify attribute annotation for Gcs Eyes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gcs Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for Gcs Verbal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gcs Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for Gcs Motor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gcs Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total Gcs Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Gcs Score here] end
	private Double totalGcsScore;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private String respiratory;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Height Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Height Scale here] end
	private String heightScale;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Scale here] end
	private String weightScale;

	// % protected region % [Modify attribute annotation for Bmi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bmi here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Oxygen Saturation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Oxygen Saturation here] end
	private Double oxygenSaturation;

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] end
	private String waistCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Pain Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pain Scale here] end
	private Double painScale;

	// % protected region % [Modify attribute annotation for Pain Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pain Scale Used here] end
	private String painScaleUsed;

	// % protected region % [Modify attribute annotation for Risk Fall Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale here] end
	private Double riskFallScale;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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
			this.registration.removePatientVitalInformations(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addPatientVitalInformations(this, false);
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
			this.registration.removePatientVitalInformations(this, false);
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
			this.staff.removePatientVitalInformations(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPatientVitalInformations(this, false);
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
			this.staff.removePatientVitalInformations(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
