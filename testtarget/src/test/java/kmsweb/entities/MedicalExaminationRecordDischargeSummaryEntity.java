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

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class MedicalExaminationRecordDischargeSummaryEntity extends AbstractEntity {

	public MedicalExaminationRecordDischargeSummaryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DiagnosisExaminationRecordsOneMany = new EntityReference();
			DiagnosisExaminationRecordsOneMany.entityName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordsOneMany.oppositeName = "MedicalExaminationRecordDischargeSummary";
			DiagnosisExaminationRecordsOneMany.name = "DiagnosisExaminationRecords";
			DiagnosisExaminationRecordsOneMany.optional = true;
			DiagnosisExaminationRecordsOneMany.type = "One";
			DiagnosisExaminationRecordsOneMany.oppositeType = "Many";

		References.add(DiagnosisExaminationRecordsOneMany);

		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);

		var DischargingDoctorOneMany = new EntityReference();
			DischargingDoctorOneMany.entityName = "Staff";
			DischargingDoctorOneMany.oppositeName = "DischargingDoctor";
			DischargingDoctorOneMany.name = "MedicalExaminationRecordDischargeSummarys";
			DischargingDoctorOneMany.optional = true;
			DischargingDoctorOneMany.type = "One";
			DischargingDoctorOneMany.oppositeType = "Many";

		References.add(DischargingDoctorOneMany);
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

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for BP Standing Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BP Standing Systole here] end
	private Integer bpStandingSystole;

	// % protected region % [Modify attribute annotation for BP Standing Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BP Standing Diastole here] end
	private Integer bpStandingDiastole;

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

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature scale here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for GCS Eyes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for GCS Verbal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for GCS Motor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for GCS Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total GCS Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total GCS Score here] end
	private Double totalGCSScore;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

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

	// % protected region % [Modify attribute annotation for BMI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BMI here] end
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

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

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

	// % protected region % [Modify attribute annotation for Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Objective here] end
	private String objective;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	// % protected region % [Modify attribute annotation for Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Subjective here] end
	private String subjective;

	// % protected region % [Modify attribute annotation for Plan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Plan here] end
	private String plan;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Examination Sub Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Examination Sub Case here] end
	private String examinationSubCase;

	// % protected region % [Modify attribute annotation for Accidental Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accidental Type here] end
	private String accidentalType;

	// % protected region % [Modify attribute annotation for Service Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Case here] end
	private String serviceCase;

	// % protected region % [Modify attribute annotation for Accidental Sub Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Accidental Sub Type here] end
	private String accidentalSubType;

	// % protected region % [Modify attribute annotation for Additional Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Notes here] end
	private String additionalNotes;

	// % protected region % [Modify attribute annotation for Discharge Summary here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discharge Summary here] end
	private String dischargeSummary;

	// % protected region % [Modify attribute annotation for Condition Upon Discharge here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Condition Upon Discharge here] end
	private String conditionUponDischarge;

	// % protected region % [Modify attribute annotation for Escorted By here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Escorted By here] end
	private String escortedBy;

	// % protected region % [Modify attribute annotation for Discharge Reason here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discharge Reason here] end
	private String dischargeReason;

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

	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity dischargingDoctor;

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
	 * Similar to {@link this#addDiagnosisExaminationRecords(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity) {
		addDiagnosisExaminationRecords(entity, true);
	}

	/**
	 * Add a new DiagnosisExaminationRecordEntity to diagnosisExaminationRecords in this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.diagnosisExaminationRecords.contains(entity)) {
			diagnosisExaminationRecords.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecordDischargeSummary(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		addDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisExaminationRecordEntity to Diagnosis Examination Records in this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosisExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosisExaminationRecords(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity) {
		this.removeDiagnosisExaminationRecords(entity, true);
	}

	/**
	 * Remove the given DiagnosisExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecordDischargeSummary(false);
		}
		this.diagnosisExaminationRecords.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 */
	public void removeDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		this.removeDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosisExaminationRecords(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosisExaminationRecords(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		setDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Replace the current entities in Diagnosis Examination Records with the given ones.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisExaminationRecords(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosisExaminationRecords();
		this.diagnosisExaminationRecords = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.setMedicalExaminationRecordDischargeSummary(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosisExaminationRecords(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosisExaminationRecords() {
		this.unsetDiagnosisExaminationRecords(true);
	}

	/**
	 * Remove all the entities in Diagnosis Examination Records from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosisExaminationRecords(boolean doReverse) {
		if (doReverse) {
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.unsetMedicalExaminationRecordDischargeSummary(false));
		}
		this.diagnosisExaminationRecords.clear();
	}
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
			this.medicalExaminationRecord.unsetMedicalExaminationRecordDischargeSummary(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setMedicalExaminationRecordDischargeSummary(this, false);
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
			this.medicalExaminationRecord.unsetMedicalExaminationRecordDischargeSummary();
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setDischargingDoctor(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDischargingDoctor(@NonNull StaffEntity entity) {
		setDischargingDoctor(entity, true);
	}

	/**
	 * Set or update the dischargingDoctor in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to dischargingDoctor
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDischargingDoctor(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDischargingDoctor here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDischargingDoctor here] end

		if (sameAsFormer(this.dischargingDoctor, entity)) {
			return;
		}

		if (this.dischargingDoctor != null) {
			this.dischargingDoctor.removeMedicalExaminationRecordDischargeSummarys(this, false);
		}
		this.dischargingDoctor = entity;
		if (reverseAdd) {
			this.dischargingDoctor.addMedicalExaminationRecordDischargeSummarys(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDischargingDoctor incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDischargingDoctor incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDischargingDoctor(boolean)} but default to true.
	 */
	public void unsetDischargingDoctor() {
		this.unsetDischargingDoctor(true);
	}

	/**
	 * Remove Discharging Doctor in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDischargingDoctor(boolean reverse) {
		if (reverse && this.dischargingDoctor != null) {
			this.dischargingDoctor.removeMedicalExaminationRecordDischargeSummarys(this, false);
		}
		this.dischargingDoctor = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
