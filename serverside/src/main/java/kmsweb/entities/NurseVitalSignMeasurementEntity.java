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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.NurseVitalSignMeasurementEntityDto;
import kmsweb.entities.listeners.NurseVitalSignMeasurementEntityListener;
import kmsweb.serializers.NurseVitalSignMeasurementSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({NurseVitalSignMeasurementEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = NurseVitalSignMeasurementSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class NurseVitalSignMeasurementEntity extends AbstractEntity {

	/**
	 * Takes a NurseVitalSignMeasurementEntityDto and converts it into a NurseVitalSignMeasurementEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param nurseVitalSignMeasurementEntityDto
	 */
	public NurseVitalSignMeasurementEntity(NurseVitalSignMeasurementEntityDto nurseVitalSignMeasurementEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (nurseVitalSignMeasurementEntityDto.getId() != null) {
			this.setId(nurseVitalSignMeasurementEntityDto.getId());
		}

		if (nurseVitalSignMeasurementEntityDto.getDiastole() != null) {
			this.setDiastole(nurseVitalSignMeasurementEntityDto.getDiastole());
		}

		if (nurseVitalSignMeasurementEntityDto.getSystole() != null) {
			this.setSystole(nurseVitalSignMeasurementEntityDto.getSystole());
		}

		if (nurseVitalSignMeasurementEntityDto.getTemperature() != null) {
			this.setTemperature(nurseVitalSignMeasurementEntityDto.getTemperature());
		}

		if (nurseVitalSignMeasurementEntityDto.getTemperatureScale() != null) {
			this.setTemperatureScale(nurseVitalSignMeasurementEntityDto.getTemperatureScale());
		}

		if (nurseVitalSignMeasurementEntityDto.getConsciousness() != null) {
			this.setConsciousness(nurseVitalSignMeasurementEntityDto.getConsciousness());
		}

		if (nurseVitalSignMeasurementEntityDto.getPulse() != null) {
			this.setPulse(nurseVitalSignMeasurementEntityDto.getPulse());
		}

		if (nurseVitalSignMeasurementEntityDto.getPulseRegularity() != null) {
			this.setPulseRegularity(nurseVitalSignMeasurementEntityDto.getPulseRegularity());
		}

		if (nurseVitalSignMeasurementEntityDto.getPulseStrength() != null) {
			this.setPulseStrength(nurseVitalSignMeasurementEntityDto.getPulseStrength());
		}

		if (nurseVitalSignMeasurementEntityDto.getGcsEyes() != null) {
			this.setGcsEyes(nurseVitalSignMeasurementEntityDto.getGcsEyes());
		}

		if (nurseVitalSignMeasurementEntityDto.getGcsVerbal() != null) {
			this.setGcsVerbal(nurseVitalSignMeasurementEntityDto.getGcsVerbal());
		}

		if (nurseVitalSignMeasurementEntityDto.getGcsMotor() != null) {
			this.setGcsMotor(nurseVitalSignMeasurementEntityDto.getGcsMotor());
		}

		if (nurseVitalSignMeasurementEntityDto.getTotalGCSScore() != null) {
			this.setTotalGCSScore(nurseVitalSignMeasurementEntityDto.getTotalGCSScore());
		}

		if (nurseVitalSignMeasurementEntityDto.getHeight() != null) {
			this.setHeight(nurseVitalSignMeasurementEntityDto.getHeight());
		}

		if (nurseVitalSignMeasurementEntityDto.getHeightScale() != null) {
			this.setHeightScale(nurseVitalSignMeasurementEntityDto.getHeightScale());
		}

		if (nurseVitalSignMeasurementEntityDto.getWeight() != null) {
			this.setWeight(nurseVitalSignMeasurementEntityDto.getWeight());
		}

		if (nurseVitalSignMeasurementEntityDto.getWeightScale() != null) {
			this.setWeightScale(nurseVitalSignMeasurementEntityDto.getWeightScale());
		}

		if (nurseVitalSignMeasurementEntityDto.getBmi() != null) {
			this.setBmi(nurseVitalSignMeasurementEntityDto.getBmi());
		}

		if (nurseVitalSignMeasurementEntityDto.getRespiratory() != null) {
			this.setRespiratory(nurseVitalSignMeasurementEntityDto.getRespiratory());
		}

		if (nurseVitalSignMeasurementEntityDto.getOxygenSaturation() != null) {
			this.setOxygenSaturation(nurseVitalSignMeasurementEntityDto.getOxygenSaturation());
		}

		if (nurseVitalSignMeasurementEntityDto.getNutritionStatus() != null) {
			this.setNutritionStatus(nurseVitalSignMeasurementEntityDto.getNutritionStatus());
		}

		if (nurseVitalSignMeasurementEntityDto.getWaistCircumference() != null) {
			this.setWaistCircumference(nurseVitalSignMeasurementEntityDto.getWaistCircumference());
		}

		if (nurseVitalSignMeasurementEntityDto.getWaistCircumferenceUnit() != null) {
			this.setWaistCircumferenceUnit(nurseVitalSignMeasurementEntityDto.getWaistCircumferenceUnit());
		}

		if (nurseVitalSignMeasurementEntityDto.getPainScale() != null) {
			this.setPainScale(nurseVitalSignMeasurementEntityDto.getPainScale());
		}

		if (nurseVitalSignMeasurementEntityDto.getPainScaleUsed() != null) {
			this.setPainScaleUsed(nurseVitalSignMeasurementEntityDto.getPainScaleUsed());
		}

		if (nurseVitalSignMeasurementEntityDto.getRiskFallScale() != null) {
			this.setRiskFallScale(nurseVitalSignMeasurementEntityDto.getRiskFallScale());
		}

		if (nurseVitalSignMeasurementEntityDto.getRiskFallScaleUsed() != null) {
			this.setRiskFallScaleUsed(nurseVitalSignMeasurementEntityDto.getRiskFallScaleUsed());
		}

		if (nurseVitalSignMeasurementEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(nurseVitalSignMeasurementEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@CsvBindByName(column = "SYSTOLE", required = false)
	@Nullable
	@Column(name = "systole")
	@Schema(description = "The Systole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@CsvBindByName(column = "TEMPERATURE", required = false)
	@Nullable
	@Column(name = "temperature")
	@Schema(description = "The Temperature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Scale here] off begin
	@CsvBindByName(column = "TEMPERATURE_SCALE", required = false)
	@Nullable
	@Column(name = "temperature_scale")
	@Schema(description = "The Temperature Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature Scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@CsvBindByName(column = "CONSCIOUSNESS", required = false)
	@Nullable
	@Column(name = "consciousness")
	@Schema(description = "The Consciousness of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@CsvBindByName(column = "PULSE", required = false)
	@Nullable
	@Column(name = "pulse")
	@Schema(description = "The Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for Pulse Regularity here] off begin
	@CsvBindByName(column = "PULSE_REGULARITY", required = false)
	@Nullable
	@Column(name = "pulse_regularity")
	@Schema(description = "The Pulse Regularity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse Regularity here] end
	private String pulseRegularity;

	// % protected region % [Modify attribute annotation for Pulse Strength here] off begin
	@CsvBindByName(column = "PULSE_STRENGTH", required = false)
	@Nullable
	@Column(name = "pulse_strength")
	@Schema(description = "The Pulse Strength of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse Strength here] end
	private String pulseStrength;

	// % protected region % [Modify attribute annotation for Gcs Eyes here] off begin
	@CsvBindByName(column = "GCS_EYES", required = false)
	@Nullable
	@Column(name = "gcs_eyes")
	@Schema(description = "The Gcs Eyes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for Gcs Verbal here] off begin
	@CsvBindByName(column = "GCS_VERBAL", required = false)
	@Nullable
	@Column(name = "gcs_verbal")
	@Schema(description = "The Gcs Verbal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for Gcs Motor here] off begin
	@CsvBindByName(column = "GCS_MOTOR", required = false)
	@Nullable
	@Column(name = "gcs_motor")
	@Schema(description = "The Gcs Motor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gcs Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total GCS Score here] off begin
	@CsvBindByName(column = "TOTAL_GCS_SCORE", required = false)
	@Nullable
	@Column(name = "total_gcs_score")
	@Schema(description = "The Total GCS Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total GCS Score here] end
	private Double totalGCSScore;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@CsvBindByName(column = "HEIGHT", required = false)
	@Nullable
	@Column(name = "height")
	@Schema(description = "The Height of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Height Scale here] off begin
	@CsvBindByName(column = "HEIGHT_SCALE", required = false)
	@Nullable
	@Column(name = "height_scale")
	@Schema(description = "The Height Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Height Scale here] end
	private String heightScale;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Scale here] off begin
	@CsvBindByName(column = "WEIGHT_SCALE", required = false)
	@Nullable
	@Column(name = "weight_scale")
	@Schema(description = "The Weight Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Scale here] end
	private String weightScale;

	// % protected region % [Modify attribute annotation for Bmi here] off begin
	@CsvBindByName(column = "BMI", required = false)
	@Nullable
	@Column(name = "bmi")
	@Schema(description = "The Bmi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bmi here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@CsvBindByName(column = "RESPIRATORY", required = false)
	@Nullable
	@Column(name = "respiratory")
	@Schema(description = "The Respiratory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private Double respiratory;

	// % protected region % [Modify attribute annotation for Oxygen Saturation here] off begin
	@CsvBindByName(column = "OXYGEN_SATURATION", required = false)
	@Nullable
	@Column(name = "oxygen_saturation")
	@Schema(description = "The Oxygen Saturation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Oxygen Saturation here] end
	private Double oxygenSaturation;

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@CsvBindByName(column = "NUTRITION_STATUS", required = false)
	@Nullable
	@Column(name = "nutrition_status")
	@Schema(description = "The Nutrition Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@CsvBindByName(column = "WAIST_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "waist_circumference")
	@Schema(description = "The Waist Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] off begin
	@CsvBindByName(column = "WAIST_CIRCUMFERENCE_UNIT", required = false)
	@Nullable
	@Column(name = "waist_circumference_unit")
	@Schema(description = "The Waist Circumference Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Waist Circumference Unit here] end
	private String waistCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Pain Scale here] off begin
	@CsvBindByName(column = "PAIN_SCALE", required = false)
	@Nullable
	@Column(name = "pain_scale")
	@Schema(description = "The Pain Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pain Scale here] end
	private Integer painScale;

	// % protected region % [Modify attribute annotation for Pain Scale Used here] off begin
	@CsvBindByName(column = "PAIN_SCALE_USED", required = false)
	@Nullable
	@Column(name = "pain_scale_used")
	@Schema(description = "The Pain Scale Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pain Scale Used here] end
	private String painScaleUsed;

	// % protected region % [Modify attribute annotation for Risk Fall Scale here] off begin
	@CsvBindByName(column = "RISK_FALL_SCALE", required = false)
	@Nullable
	@Column(name = "risk_fall_scale")
	@Schema(description = "The Risk Fall Scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Fall Scale here] end
	private Integer riskFallScale;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@CsvBindByName(column = "RISK_FALL_SCALE_USED", required = false)
	@Nullable
	@Column(name = "risk_fall_scale_used")
	@Schema(description = "The Risk Fall Scale Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "DIASTOLE,SYSTOLE,TEMPERATURE,TEMPERATURE_SCALE,CONSCIOUSNESS,PULSE,PULSE_REGULARITY,PULSE_STRENGTH,GCS_EYES,GCS_VERBAL,GCS_MOTOR,TOTAL_GCS_SCORE,HEIGHT,HEIGHT_SCALE,WEIGHT,WEIGHT_SCALE,BMI,RESPIRATORY,OXYGEN_SATURATION,NUTRITION_STATUS,WAIST_CIRCUMFERENCE,WAIST_CIRCUMFERENCE_UNIT,PAIN_SCALE,PAIN_SCALE_USED,RISK_FALL_SCALE,RISK_FALL_SCALE_USED,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object nurseVitalSignMeasurement) {
		if (this == nurseVitalSignMeasurement) {
			return true;
		}
		if (nurseVitalSignMeasurement == null || this.getClass() != nurseVitalSignMeasurement.getClass()) {
			return false;
		}
		if (!super.equals(nurseVitalSignMeasurement)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		NurseVitalSignMeasurementEntity that = (NurseVitalSignMeasurementEntity) nurseVitalSignMeasurement;
		return
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.temperatureScale, that.temperatureScale) &&
			Objects.equals(this.consciousness, that.consciousness) &&
			Objects.equals(this.pulse, that.pulse) &&
			Objects.equals(this.pulseRegularity, that.pulseRegularity) &&
			Objects.equals(this.pulseStrength, that.pulseStrength) &&
			Objects.equals(this.gcsEyes, that.gcsEyes) &&
			Objects.equals(this.gcsVerbal, that.gcsVerbal) &&
			Objects.equals(this.gcsMotor, that.gcsMotor) &&
			Objects.equals(this.totalGCSScore, that.totalGCSScore) &&
			Objects.equals(this.height, that.height) &&
			Objects.equals(this.heightScale, that.heightScale) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.weightScale, that.weightScale) &&
			Objects.equals(this.bmi, that.bmi) &&
			Objects.equals(this.respiratory, that.respiratory) &&
			Objects.equals(this.oxygenSaturation, that.oxygenSaturation) &&
			Objects.equals(this.nutritionStatus, that.nutritionStatus) &&
			Objects.equals(this.waistCircumference, that.waistCircumference) &&
			Objects.equals(this.waistCircumferenceUnit, that.waistCircumferenceUnit) &&
			Objects.equals(this.painScale, that.painScale) &&
			Objects.equals(this.painScaleUsed, that.painScaleUsed) &&
			Objects.equals(this.riskFallScale, that.riskFallScale) &&
			Objects.equals(this.riskFallScaleUsed, that.riskFallScaleUsed) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
