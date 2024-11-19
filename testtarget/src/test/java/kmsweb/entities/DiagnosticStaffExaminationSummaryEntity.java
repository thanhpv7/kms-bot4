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
public class DiagnosticStaffExaminationSummaryEntity extends AbstractEntity {

	public DiagnosticStaffExaminationSummaryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "DiagnosticStaffExaminationSummaries";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);

		var DiagnosisExaminationRecordOneOne = new EntityReference();
			DiagnosisExaminationRecordOneOne.entityName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordOneOne.oppositeName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordOneOne.name = "DiagnosticStaffExaminationSummary";
			DiagnosisExaminationRecordOneOne.optional = true;
			DiagnosisExaminationRecordOneOne.type = "One";
			DiagnosisExaminationRecordOneOne.oppositeType = "One";

		References.add(DiagnosisExaminationRecordOneOne);

		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "DiagnosticStaffExaminationSummary";
			RegistrationOneOne.name = "Registration";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Responsible Doctor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Responsible Doctor here] end
	private String responsibleDoctor;

	// % protected region % [Modify attribute annotation for Medical Transcriber here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Transcriber here] end
	private String medicalTranscriber;

	// % protected region % [Modify attribute annotation for Referring Room here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referring Room here] end
	private String referringRoom;

	// % protected region % [Modify attribute annotation for Refering Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Refering Unit here] end
	private String referingUnit;

	// % protected region % [Modify attribute annotation for Examination Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Examination Location here] end
	private String examinationLocation;

	// % protected region % [Modify attribute annotation for Additional Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Notes here] end
	private String additionalNotes;

	// % protected region % [Modify attribute annotation for Conclusion here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Conclusion here] end
	private String conclusion;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RegistrationEntity registration;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosisExaminationRecordEntity diagnosisExaminationRecord;

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

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosticStaffExaminationSummaryEntity to be set to this entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update registration with the given RegistrationEntity.
	 *
	 * @param entity the DiagnosticStaffExaminationSummaryEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetDiagnosticStaffExaminationSummary();
		}

		this.registration = entity;

		if (reverseAdd) {
			this.registration.setDiagnosticStaffExaminationSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity in Registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetDiagnosticStaffExaminationSummary(false);
		}
		this.registration = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.staff.removeDiagnosticStaffExaminationSummaries(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDiagnosticStaffExaminationSummaries(this, false);
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
			this.staff.removeDiagnosticStaffExaminationSummaries(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity) {
		setDiagnosisExaminationRecord(entity, true);
	}

	/**
	 * Set or update the diagnosisExaminationRecord in this entity with single DiagnosisExaminationRecordEntity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set or updated to diagnosisExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] end

		if (sameAsFormer(this.diagnosisExaminationRecord, entity)) {
			return;
		}

		if (this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetDiagnosticStaffExaminationSummary(false);
		}

		this.diagnosisExaminationRecord = entity;
		if (reverseAdd) {
			this.diagnosisExaminationRecord.setDiagnosticStaffExaminationSummary(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosisExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDiagnosisExaminationRecord() {
		this.unsetDiagnosisExaminationRecord(true);
	}

	/**
	 * Remove the DiagnosisExaminationRecordEntity of diagnosisExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosisExaminationRecord(boolean reverse) {
		if (reverse && this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetDiagnosticStaffExaminationSummary();
		}
		this.diagnosisExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
