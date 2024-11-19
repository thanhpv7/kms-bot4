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
public class ObstetricAndGynecologyHistoryEntity extends AbstractEntity {

	public ObstetricAndGynecologyHistoryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "ObstetricAndGynecologyHistory";
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

	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] end
	private String pregnancyHistoryGravida;

	// % protected region % [Modify attribute annotation for Patient History Para here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient History Para here] end
	private String patientHistoryPara;

	// % protected region % [Modify attribute annotation for Patient History Abortus here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient History Abortus here] end
	private String patientHistoryAbortus;

	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] end
	private String pregnancyHistoryNotes;

	// % protected region % [Modify attribute annotation for Age of Menarche here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age of Menarche here] end
	private String ageOfMenarche;

	// % protected region % [Modify attribute annotation for Age of First Sexual Contact here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Age of First Sexual Contact here] end
	private String ageOfFirstSexualContact;

	// % protected region % [Modify attribute annotation for Start Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Start Date here] end
	private OffsetDateTime startDate;

	// % protected region % [Modify attribute annotation for End Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for End Date here] end
	private OffsetDateTime endDate;

	// % protected region % [Modify attribute annotation for Approximate Birth Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approximate Birth Date here] end
	private OffsetDateTime approximateBirthDate;

	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] end
	private String gestationAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestation Age Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestation Age Days here] end
	private String gestationAgeDays;

	// % protected region % [Modify attribute annotation for Maternity History here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Maternity History here] end
	private String maternityHistory;

	// % protected region % [Modify attribute annotation for Gynecology History here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gynecology History here] end
	private String gynecologyHistory;

	// % protected region % [Modify attribute annotation for Family Plan History here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Family Plan History here] end
	private String familyPlanHistory;

	// % protected region % [Modify attribute annotation for Other Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Notes here] end
	private String otherNotes;

	// % protected region % [Modify attribute annotation for Education Level of Patient here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Education Level of Patient here] end
	private String educationLevelOfPatient;

	// % protected region % [Modify attribute annotation for Name of Husband or Wife here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name of Husband or Wife here] end
	private String nameOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Education Level of Husband or Wife here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Education Level of Husband or Wife here] end
	private String educationLevelOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Occupation of Husband or Wife here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Occupation of Husband or Wife here] end
	private String occupationOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Rupture Of Membrane here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rupture Of Membrane here] end
	private OffsetDateTime ruptureOfMembrane;

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
			this.medicalExaminationRecord.unsetObstetricAndGynecologyHistory(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setObstetricAndGynecologyHistory(this, false);
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
			this.medicalExaminationRecord.unsetObstetricAndGynecologyHistory();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
