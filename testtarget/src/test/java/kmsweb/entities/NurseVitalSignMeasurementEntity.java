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
public class NurseVitalSignMeasurementEntity extends AbstractEntity {

	public NurseVitalSignMeasurementEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "NurseVitalSignMeasurement";
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

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

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
	private Integer pulse;

	// % protected region % [Modify attribute annotation for Pulse Regularity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Regularity here] end
	private String pulseRegularity;

	// % protected region % [Modify attribute annotation for Pulse Strength here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Strength here] end
	private String pulseStrength;

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

	// % protected region % [Modify attribute annotation for Total GCS Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total GCS Score here] end
	private Double totalGCSScore;

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

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private Double respiratory;

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
	private Integer painScale;

	// % protected region % [Modify attribute annotation for Pain Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pain Scale Used here] end
	private String painScaleUsed;

	// % protected region % [Modify attribute annotation for Risk Fall Scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale here] end
	private Integer riskFallScale;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

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
			this.medicalExaminationRecord.unsetNurseVitalSignMeasurement(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setNurseVitalSignMeasurement(this, false);
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
			this.medicalExaminationRecord.unsetNurseVitalSignMeasurement();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
