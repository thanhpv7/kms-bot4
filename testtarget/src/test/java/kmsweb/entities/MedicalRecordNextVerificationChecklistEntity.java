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
public class MedicalRecordNextVerificationChecklistEntity extends AbstractEntity {

	public MedicalRecordNextVerificationChecklistEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "MedicalRecordNextVerificationChecklist";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Out Vital Sign here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Vital Sign here] end
	private Boolean outVitalSign;

	// % protected region % [Modify attribute annotation for Out Anamnesis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Anamnesis here] end
	private Boolean outAnamnesis;

	// % protected region % [Modify attribute annotation for Out Physical Examination here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Physical Examination here] end
	private Boolean outPhysicalExamination;

	// % protected region % [Modify attribute annotation for Out Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Diagnosis here] end
	private Boolean outDiagnosis;

	// % protected region % [Modify attribute annotation for Out Dismissal Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Dismissal Type here] end
	private Boolean outDismissalType;

	// % protected region % [Modify attribute annotation for Out Dismissal Date and Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Out Dismissal Date and Time here] end
	private Boolean outDismissalDateAndTime;

	// % protected region % [Modify attribute annotation for Inp Vital Sign here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Vital Sign here] end
	private Boolean inpVitalSign;

	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes here] end
	private Boolean inpDailyCareDoctorNotes;

	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes NA here] end
	private Boolean inpDailyCareDoctorNotesNA;

	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes here] end
	private Boolean inpDailyCareNursingNotes;

	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes NA here] end
	private Boolean inpDailyCareNursingNotesNA;

	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes here] end
	private Boolean inpDailyCareProgressNotes;

	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes NA here] end
	private Boolean inpDailyCareProgressNotesNA;

	// % protected region % [Modify attribute annotation for Inp Dismissal Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Dismissal Diagnosis here] end
	private Boolean inpDismissalDiagnosis;

	// % protected region % [Modify attribute annotation for Inp Dismissal Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Dismissal Type here] end
	private Boolean inpDismissalType;

	// % protected region % [Modify attribute annotation for Inp Dismissal Date and Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Dismissal Date and Time here] end
	private Boolean inpDismissalDateAndTime;

	// % protected region % [Modify attribute annotation for Inp Dismissal Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inp Dismissal Condition here] end
	private Boolean inpDismissalCondition;

	// % protected region % [Modify attribute annotation for DR Admission Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Admission Diagnosis here] end
	private Boolean drAdmissionDiagnosis;

	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes here] end
	private Boolean drObservationDoctorNotes;

	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes NA here] end
	private Boolean drObservationDoctorNotesNA;

	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes here] end
	private Boolean drObservationNursingNotes;

	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes NA here] end
	private Boolean drObservationNursingNotesNA;

	// % protected region % [Modify attribute annotation for DR Observation Progress Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Progress Notes here] end
	private Boolean drObservationProgressNotes;

	// % protected region % [Modify attribute annotation for DR Observation Progress Notes NA here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Observation Progress Notes NA here] end
	private Boolean drObservationProgressNotesNA;

	// % protected region % [Modify attribute annotation for DR Dismissal Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Dismissal Diagnosis here] end
	private Boolean drDismissalDiagnosis;

	// % protected region % [Modify attribute annotation for DR Dismissal Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Dismissal Type here] end
	private Boolean drDismissalType;

	// % protected region % [Modify attribute annotation for DR Dismissal Date and Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DR Dismissal Date and Time here] end
	private Boolean drDismissalDateAndTime;

	// % protected region % [Modify attribute annotation for OT Pre Operative Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Pre Operative Diagnosis here] end
	private Boolean otPreOperativeDiagnosis;

	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Surgery here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Surgery here] end
	private Boolean otPreOperativeNotesSurgery;

	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Anaesthesiology here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Anaesthesiology here] end
	private Boolean otPreOperativeNotesAnaesthesiology;

	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Surgery here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Surgery here] end
	private Boolean otIntraOperativeNotesSurgery;

	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Anaesthesiology here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Anaesthesiology here] end
	private Boolean otIntraOperativeNotesAnaesthesiology;

	// % protected region % [Modify attribute annotation for OT Post Operative Notes Surgery here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Post Operative Notes Surgery here] end
	private Boolean otPostOperativeNotesSurgery;

	// % protected region % [Modify attribute annotation for OT Post Operative Notes Anaesthesiology here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Post Operative Notes Anaesthesiology here] end
	private Boolean otPostOperativeNotesAnaesthesiology;

	// % protected region % [Modify attribute annotation for OT Post Operative Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Post Operative Diagnosis here] end
	private Boolean otPostOperativeDiagnosis;

	// % protected region % [Modify attribute annotation for OT Dismissal Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Dismissal Type here] end
	private Boolean otDismissalType;

	// % protected region % [Modify attribute annotation for OT Dismissal Date and Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for OT Dismissal Date and Time here] end
	private Boolean otDismissalDateAndTime;

	// % protected region % [Modify attribute annotation for DS Responsible Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DS Responsible Staff here] end
	private Boolean dsResponsibleStaff;

	// % protected region % [Modify attribute annotation for DS Interpretation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DS Interpretation here] end
	private Boolean dsInterpretation;

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

	private MedicalExaminationRecordEntity medicalExaminationRecord;

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
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetMedicalRecordNextVerificationChecklist(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setMedicalRecordNextVerificationChecklist(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetMedicalRecordNextVerificationChecklist();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
