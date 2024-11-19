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
public class OphthalmologyExaminationEntity extends AbstractEntity {

	public OphthalmologyExaminationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "OphthalmologyExamination";
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

	// % protected region % [Modify attribute annotation for Right Eyelid Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Eyelid Subjective here] end
	private String rightEyelidSubjective;

	// % protected region % [Modify attribute annotation for Right Eyelid Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Eyelid Objective here] end
	private String rightEyelidObjective;

	// % protected region % [Modify attribute annotation for Right Pupil Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Pupil Subjective here] end
	private String rightPupilSubjective;

	// % protected region % [Modify attribute annotation for Right Pupil Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Pupil Objective here] end
	private String rightPupilObjective;

	// % protected region % [Modify attribute annotation for Right Sclera Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Sclera Subjective here] end
	private String rightScleraSubjective;

	// % protected region % [Modify attribute annotation for Right Sclera Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Sclera Objective here] end
	private String rightScleraObjective;

	// % protected region % [Modify attribute annotation for Right Iris Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Iris Subjective here] end
	private String rightIrisSubjective;

	// % protected region % [Modify attribute annotation for Right Iris Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Right Iris Objective here] end
	private String rightIrisObjective;

	// % protected region % [Modify attribute annotation for Left Eyelid Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Eyelid Subjective here] end
	private String leftEyelidSubjective;

	// % protected region % [Modify attribute annotation for Left Eyelid Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Eyelid Objective here] end
	private String leftEyelidObjective;

	// % protected region % [Modify attribute annotation for Left Pupil Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Pupil Subjective here] end
	private String leftPupilSubjective;

	// % protected region % [Modify attribute annotation for Left Pupil Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Pupil Objective here] end
	private String leftPupilObjective;

	// % protected region % [Modify attribute annotation for Left Sclera Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Sclera Subjective here] end
	private String leftScleraSubjective;

	// % protected region % [Modify attribute annotation for Left Sclera Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Sclera Objective here] end
	private String leftScleraObjective;

	// % protected region % [Modify attribute annotation for Left Iris Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Iris Subjective here] end
	private String leftIrisSubjective;

	// % protected region % [Modify attribute annotation for Left Iris Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Left Iris Objective here] end
	private String leftIrisObjective;

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
			this.medicalExaminationRecord.unsetOphthalmologyExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setOphthalmologyExamination(this, false);
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
			this.medicalExaminationRecord.unsetOphthalmologyExamination();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
