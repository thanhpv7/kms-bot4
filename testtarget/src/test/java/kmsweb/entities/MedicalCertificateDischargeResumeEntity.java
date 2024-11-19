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
public class MedicalCertificateDischargeResumeEntity extends AbstractEntity {

	public MedicalCertificateDischargeResumeEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DischargeICD10OneMany = new EntityReference();
			DischargeICD10OneMany.entityName = "DiagnosesAndProcedures";
			DischargeICD10OneMany.oppositeName = "DischargeICD10";
			DischargeICD10OneMany.name = "DischargeICD10";
			DischargeICD10OneMany.optional = true;
			DischargeICD10OneMany.type = "One";
			DischargeICD10OneMany.oppositeType = "Many";

		References.add(DischargeICD10OneMany);

		var DischargeICD9CMOneMany = new EntityReference();
			DischargeICD9CMOneMany.entityName = "DiagnosesAndProcedures";
			DischargeICD9CMOneMany.oppositeName = "DischargeICD9CM";
			DischargeICD9CMOneMany.name = "DischargeICD9CM";
			DischargeICD9CMOneMany.optional = true;
			DischargeICD9CMOneMany.type = "One";
			DischargeICD9CMOneMany.oppositeType = "Many";

		References.add(DischargeICD9CMOneMany);

		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "Registration";
			RegistrationOneOne.name = "MedicalCertificateDischargeResume";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);

		var MedicalStaffOneMany = new EntityReference();
			MedicalStaffOneMany.entityName = "Staff";
			MedicalStaffOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOneMany.name = "MedicalCertificateDischargeResumes";
			MedicalStaffOneMany.optional = true;
			MedicalStaffOneMany.type = "One";
			MedicalStaffOneMany.oppositeType = "Many";

		References.add(MedicalStaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Admission Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Admission Date Time here] end
	private OffsetDateTime admissionDateTime;

	// % protected region % [Modify attribute annotation for Discharge Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discharge Date Time here] end
	private OffsetDateTime dischargeDateTime;

	// % protected region % [Modify attribute annotation for Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Condition here] end
	private String condition;

	// % protected region % [Modify attribute annotation for Main Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Main Diagnosis here] end
	private String mainDiagnosis;

	// % protected region % [Modify attribute annotation for Action here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Action here] end
	private String action;

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

	private DiagnosesAndProceduresEntity dischargeICD10;

	private DiagnosesAndProceduresEntity dischargeICD9CM;

	private StaffEntity medicalStaff;

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
	 * Similar to {@link this#setDischargeICD10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setDischargeICD10(@NonNull DiagnosesAndProceduresEntity entity) {
		setDischargeICD10(entity, true);
	}

	/**
	 * Set or update the dischargeICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to dischargeICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDischargeICD10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDischargeICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDischargeICD10 here] end

		if (sameAsFormer(this.dischargeICD10, entity)) {
			return;
		}

		if (this.dischargeICD10 != null) {
			this.dischargeICD10.removeDischargeICD10(this, false);
		}
		this.dischargeICD10 = entity;
		if (reverseAdd) {
			this.dischargeICD10.addDischargeICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDischargeICD10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDischargeICD10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDischargeICD10(boolean)} but default to true.
	 */
	public void unsetDischargeICD10() {
		this.unsetDischargeICD10(true);
	}

	/**
	 * Remove Discharge ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDischargeICD10(boolean reverse) {
		if (reverse && this.dischargeICD10 != null) {
			this.dischargeICD10.removeDischargeICD10(this, false);
		}
		this.dischargeICD10 = null;
	}
	/**
	 * Similar to {@link this#setDischargeICD9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setDischargeICD9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setDischargeICD9CM(entity, true);
	}

	/**
	 * Set or update the dischargeICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to dischargeICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDischargeICD9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDischargeICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDischargeICD9CM here] end

		if (sameAsFormer(this.dischargeICD9CM, entity)) {
			return;
		}

		if (this.dischargeICD9CM != null) {
			this.dischargeICD9CM.removeDischargeICD9CM(this, false);
		}
		this.dischargeICD9CM = entity;
		if (reverseAdd) {
			this.dischargeICD9CM.addDischargeICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDischargeICD9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDischargeICD9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDischargeICD9CM(boolean)} but default to true.
	 */
	public void unsetDischargeICD9CM() {
		this.unsetDischargeICD9CM(true);
	}

	/**
	 * Remove Discharge ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDischargeICD9CM(boolean reverse) {
		if (reverse && this.dischargeICD9CM != null) {
			this.dischargeICD9CM.removeDischargeICD9CM(this, false);
		}
		this.dischargeICD9CM = null;
	}
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
			this.registration.unsetMedicalCertificateDischargeResume(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setMedicalCertificateDischargeResume(this, false);
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
			this.registration.unsetMedicalCertificateDischargeResume();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalStaff(@NonNull StaffEntity entity) {
		setMedicalStaff(entity, true);
	}

	/**
	 * Set or update the medicalStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] end

		if (sameAsFormer(this.medicalStaff, entity)) {
			return;
		}

		if (this.medicalStaff != null) {
			this.medicalStaff.removeMedicalCertificateDischargeResumes(this, false);
		}
		this.medicalStaff = entity;
		if (reverseAdd) {
			this.medicalStaff.addMedicalCertificateDischargeResumes(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalStaff(boolean)} but default to true.
	 */
	public void unsetMedicalStaff() {
		this.unsetMedicalStaff(true);
	}

	/**
	 * Remove Medical Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalStaff(boolean reverse) {
		if (reverse && this.medicalStaff != null) {
			this.medicalStaff.removeMedicalCertificateDischargeResumes(this, false);
		}
		this.medicalStaff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
