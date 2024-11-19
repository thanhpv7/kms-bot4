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
public class EmergencyMedicalExaminationRecordEntity extends AbstractEntity {

	public EmergencyMedicalExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "EmergencyMedicationExaminationRecord";
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

	// % protected region % [Modify attribute annotation for Surgical Or Non Surgical here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgical Or Non Surgical here] end
	private String surgicalOrNonSurgical;

	// % protected region % [Modify attribute annotation for Case Specification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Case Specification here] end
	private String caseSpecification;

	// % protected region % [Modify attribute annotation for Accident Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accident Type here] end
	private String accidentType;

	// % protected region % [Modify attribute annotation for Accident Cause here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accident Cause here] end
	private String accidentCause;

	// % protected region % [Modify attribute annotation for Emergency Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Emergency Level here] end
	private String emergencyLevel;

	// % protected region % [Modify attribute annotation for Date Time of Instructions here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Time of Instructions here] end
	private OffsetDateTime dateTimeOfInstructions;

	// % protected region % [Modify attribute annotation for Is Doctor Taking Over here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Doctor Taking Over here] end
	private Boolean isDoctorTakingOver;

	// % protected region % [Modify attribute annotation for Date Time of Drug Administration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Time of Drug Administration here] end
	private OffsetDateTime dateTimeOfDrugAdministration;

	// % protected region % [Modify attribute annotation for Is Autopay here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Autopay here] end
	private Boolean isAutopay;

	// % protected region % [Modify attribute annotation for Response Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Response Time here] end
	private Integer responseTime;

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
			this.medicalExaminationRecord.unsetEmergencyMedicationExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setEmergencyMedicationExaminationRecord(this, false);
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
			this.medicalExaminationRecord.unsetEmergencyMedicationExaminationRecord();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
