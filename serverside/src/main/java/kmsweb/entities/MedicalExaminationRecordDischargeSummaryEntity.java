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
import kmsweb.dtos.MedicalExaminationRecordDischargeSummaryEntityDto;
import kmsweb.entities.listeners.MedicalExaminationRecordDischargeSummaryEntityListener;
import kmsweb.serializers.MedicalExaminationRecordDischargeSummarySerializer;
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

import java.util.*;
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
@EntityListeners({MedicalExaminationRecordDischargeSummaryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalExaminationRecordDischargeSummarySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalExaminationRecordDischargeSummaryEntity extends AbstractEntity {

	/**
	 * Takes a MedicalExaminationRecordDischargeSummaryEntityDto and converts it into a MedicalExaminationRecordDischargeSummaryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalExaminationRecordDischargeSummaryEntityDto
	 */
	public MedicalExaminationRecordDischargeSummaryEntity(MedicalExaminationRecordDischargeSummaryEntityDto medicalExaminationRecordDischargeSummaryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalExaminationRecordDischargeSummaryEntityDto.getId() != null) {
			this.setId(medicalExaminationRecordDischargeSummaryEntityDto.getId());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getDiastole() != null) {
			this.setDiastole(medicalExaminationRecordDischargeSummaryEntityDto.getDiastole());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getSystole() != null) {
			this.setSystole(medicalExaminationRecordDischargeSummaryEntityDto.getSystole());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPulse() != null) {
			this.setPulse(medicalExaminationRecordDischargeSummaryEntityDto.getPulse());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getBpStandingSystole() != null) {
			this.setBpStandingSystole(medicalExaminationRecordDischargeSummaryEntityDto.getBpStandingSystole());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getBpStandingDiastole() != null) {
			this.setBpStandingDiastole(medicalExaminationRecordDischargeSummaryEntityDto.getBpStandingDiastole());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPulseRegularity() != null) {
			this.setPulseRegularity(medicalExaminationRecordDischargeSummaryEntityDto.getPulseRegularity());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPulseStrength() != null) {
			this.setPulseStrength(medicalExaminationRecordDischargeSummaryEntityDto.getPulseStrength());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getTemperature() != null) {
			this.setTemperature(medicalExaminationRecordDischargeSummaryEntityDto.getTemperature());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getTemperatureScale() != null) {
			this.setTemperatureScale(medicalExaminationRecordDischargeSummaryEntityDto.getTemperatureScale());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getGcsEyes() != null) {
			this.setGcsEyes(medicalExaminationRecordDischargeSummaryEntityDto.getGcsEyes());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getGcsVerbal() != null) {
			this.setGcsVerbal(medicalExaminationRecordDischargeSummaryEntityDto.getGcsVerbal());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getGcsMotor() != null) {
			this.setGcsMotor(medicalExaminationRecordDischargeSummaryEntityDto.getGcsMotor());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getTotalGCSScore() != null) {
			this.setTotalGCSScore(medicalExaminationRecordDischargeSummaryEntityDto.getTotalGCSScore());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getConsciousness() != null) {
			this.setConsciousness(medicalExaminationRecordDischargeSummaryEntityDto.getConsciousness());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getHeight() != null) {
			this.setHeight(medicalExaminationRecordDischargeSummaryEntityDto.getHeight());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getHeightScale() != null) {
			this.setHeightScale(medicalExaminationRecordDischargeSummaryEntityDto.getHeightScale());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getWeight() != null) {
			this.setWeight(medicalExaminationRecordDischargeSummaryEntityDto.getWeight());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getWeightScale() != null) {
			this.setWeightScale(medicalExaminationRecordDischargeSummaryEntityDto.getWeightScale());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getBmi() != null) {
			this.setBmi(medicalExaminationRecordDischargeSummaryEntityDto.getBmi());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getRespiratory() != null) {
			this.setRespiratory(medicalExaminationRecordDischargeSummaryEntityDto.getRespiratory());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getOxygenSaturation() != null) {
			this.setOxygenSaturation(medicalExaminationRecordDischargeSummaryEntityDto.getOxygenSaturation());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getWaistCircumference() != null) {
			this.setWaistCircumference(medicalExaminationRecordDischargeSummaryEntityDto.getWaistCircumference());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getWaistCircumferenceUnit() != null) {
			this.setWaistCircumferenceUnit(medicalExaminationRecordDischargeSummaryEntityDto.getWaistCircumferenceUnit());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getNutritionStatus() != null) {
			this.setNutritionStatus(medicalExaminationRecordDischargeSummaryEntityDto.getNutritionStatus());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPainScale() != null) {
			this.setPainScale(medicalExaminationRecordDischargeSummaryEntityDto.getPainScale());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPainScaleUsed() != null) {
			this.setPainScaleUsed(medicalExaminationRecordDischargeSummaryEntityDto.getPainScaleUsed());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getRiskFallScale() != null) {
			this.setRiskFallScale(medicalExaminationRecordDischargeSummaryEntityDto.getRiskFallScale());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getObjective() != null) {
			this.setObjective(medicalExaminationRecordDischargeSummaryEntityDto.getObjective());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getRiskFallScaleUsed() != null) {
			this.setRiskFallScaleUsed(medicalExaminationRecordDischargeSummaryEntityDto.getRiskFallScaleUsed());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getSubjective() != null) {
			this.setSubjective(medicalExaminationRecordDischargeSummaryEntityDto.getSubjective());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPlan() != null) {
			this.setPlan(medicalExaminationRecordDischargeSummaryEntityDto.getPlan());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getPurpose() != null) {
			this.setPurpose(medicalExaminationRecordDischargeSummaryEntityDto.getPurpose());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getExaminationSubCase() != null) {
			this.setExaminationSubCase(medicalExaminationRecordDischargeSummaryEntityDto.getExaminationSubCase());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getAccidentalType() != null) {
			this.setAccidentalType(medicalExaminationRecordDischargeSummaryEntityDto.getAccidentalType());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getServiceCase() != null) {
			this.setServiceCase(medicalExaminationRecordDischargeSummaryEntityDto.getServiceCase());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getAccidentalSubType() != null) {
			this.setAccidentalSubType(medicalExaminationRecordDischargeSummaryEntityDto.getAccidentalSubType());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getAdditionalNotes() != null) {
			this.setAdditionalNotes(medicalExaminationRecordDischargeSummaryEntityDto.getAdditionalNotes());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getDischargeSummary() != null) {
			this.setDischargeSummary(medicalExaminationRecordDischargeSummaryEntityDto.getDischargeSummary());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getConditionUponDischarge() != null) {
			this.setConditionUponDischarge(medicalExaminationRecordDischargeSummaryEntityDto.getConditionUponDischarge());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getEscortedBy() != null) {
			this.setEscortedBy(medicalExaminationRecordDischargeSummaryEntityDto.getEscortedBy());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getDischargeReason() != null) {
			this.setDischargeReason(medicalExaminationRecordDischargeSummaryEntityDto.getDischargeReason());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getDiagnosisExaminationRecords() != null) {
			this.setDiagnosisExaminationRecords(medicalExaminationRecordDischargeSummaryEntityDto.getDiagnosisExaminationRecords());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(medicalExaminationRecordDischargeSummaryEntityDto.getMedicalExaminationRecord());
		}

		if (medicalExaminationRecordDischargeSummaryEntityDto.getDischargingDoctor() != null) {
			this.setDischargingDoctor(medicalExaminationRecordDischargeSummaryEntityDto.getDischargingDoctor());
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

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@CsvBindByName(column = "PULSE", required = false)
	@Nullable
	@Column(name = "pulse")
	@Schema(description = "The Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for BP Standing Systole here] off begin
	@CsvBindByName(column = "BP_STANDING_SYSTOLE", required = false)
	@Nullable
	@Column(name = "bp_standing_systole")
	@Schema(description = "The BP Standing Systole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BP Standing Systole here] end
	private Integer bpStandingSystole;

	// % protected region % [Modify attribute annotation for BP Standing Diastole here] off begin
	@CsvBindByName(column = "BP_STANDING_DIASTOLE", required = false)
	@Nullable
	@Column(name = "bp_standing_diastole")
	@Schema(description = "The BP Standing Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BP Standing Diastole here] end
	private Integer bpStandingDiastole;

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

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@CsvBindByName(column = "TEMPERATURE", required = false)
	@Nullable
	@Column(name = "temperature")
	@Schema(description = "The Temperature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature scale here] off begin
	@CsvBindByName(column = "TEMPERATURE_SCALE", required = false)
	@Nullable
	@Column(name = "temperature_scale")
	@Schema(description = "The Temperature scale of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature scale here] end
	private String temperatureScale;

	// % protected region % [Modify attribute annotation for GCS Eyes here] off begin
	@CsvBindByName(column = "GCS_EYES", required = false)
	@Nullable
	@Column(name = "gcs_eyes")
	@Schema(description = "The GCS Eyes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for GCS Eyes here] end
	private String gcsEyes;

	// % protected region % [Modify attribute annotation for GCS Verbal here] off begin
	@CsvBindByName(column = "GCS_VERBAL", required = false)
	@Nullable
	@Column(name = "gcs_verbal")
	@Schema(description = "The GCS Verbal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for GCS Verbal here] end
	private String gcsVerbal;

	// % protected region % [Modify attribute annotation for GCS Motor here] off begin
	@CsvBindByName(column = "GCS_MOTOR", required = false)
	@Nullable
	@Column(name = "gcs_motor")
	@Schema(description = "The GCS Motor of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for GCS Motor here] end
	private String gcsMotor;

	// % protected region % [Modify attribute annotation for Total GCS Score here] off begin
	@CsvBindByName(column = "TOTAL_GCS_SCORE", required = false)
	@Nullable
	@Column(name = "total_gcs_score")
	@Schema(description = "The Total GCS Score of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total GCS Score here] end
	private Double totalGCSScore;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@CsvBindByName(column = "CONSCIOUSNESS", required = false)
	@Nullable
	@Column(name = "consciousness")
	@Schema(description = "The Consciousness of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

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

	// % protected region % [Modify attribute annotation for BMI here] off begin
	@CsvBindByName(column = "BMI", required = false)
	@Nullable
	@Column(name = "bmi")
	@Schema(description = "The BMI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BMI here] end
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

	// % protected region % [Modify attribute annotation for Nutrition Status here] off begin
	@CsvBindByName(column = "NUTRITION_STATUS", required = false)
	@Nullable
	@Column(name = "nutrition_status")
	@Schema(description = "The Nutrition Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nutrition Status here] end
	private String nutritionStatus;

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

	// % protected region % [Modify attribute annotation for Objective here] off begin
	@CsvBindByName(column = "OBJECTIVE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "objective")
	@Schema(description = "The Objective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Objective here] end
	private String objective;

	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] off begin
	@CsvBindByName(column = "RISK_FALL_SCALE_USED", required = false)
	@Nullable
	@Column(name = "risk_fall_scale_used")
	@Schema(description = "The Risk Fall Scale Used of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Risk Fall Scale Used here] end
	private String riskFallScaleUsed;

	// % protected region % [Modify attribute annotation for Subjective here] off begin
	@CsvBindByName(column = "SUBJECTIVE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "subjective")
	@Schema(description = "The Subjective of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Subjective here] end
	private String subjective;

	// % protected region % [Modify attribute annotation for Plan here] off begin
	@CsvBindByName(column = "PLAN", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "plan")
	@Schema(description = "The Plan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Plan here] end
	private String plan;

	// % protected region % [Modify attribute annotation for Purpose here] off begin
	@CsvBindByName(column = "PURPOSE", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "purpose")
	@Schema(description = "The Purpose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purpose here] end
	private String purpose;

	// % protected region % [Modify attribute annotation for Examination Sub Case here] off begin
	@CsvBindByName(column = "EXAMINATION_SUB_CASE", required = false)
	@Nullable
	@Column(name = "examination_sub_case")
	@Schema(description = "The Examination Sub Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Examination Sub Case here] end
	private String examinationSubCase;

	// % protected region % [Modify attribute annotation for Accidental Type here] off begin
	@CsvBindByName(column = "ACCIDENTAL_TYPE", required = false)
	@Nullable
	@Column(name = "accidental_type")
	@Schema(description = "The Accidental Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accidental Type here] end
	private String accidentalType;

	// % protected region % [Modify attribute annotation for Service Case here] off begin
	@CsvBindByName(column = "SERVICE_CASE", required = false)
	@Nullable
	@Column(name = "service_case")
	@Schema(description = "The Service Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Service Case here] end
	private String serviceCase;

	// % protected region % [Modify attribute annotation for Accidental Sub Type here] off begin
	@CsvBindByName(column = "ACCIDENTAL_SUB_TYPE", required = false)
	@Nullable
	@Column(name = "accidental_sub_type")
	@Schema(description = "The Accidental Sub Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accidental Sub Type here] end
	private String accidentalSubType;

	// % protected region % [Modify attribute annotation for Additional Notes here] off begin
	@CsvBindByName(column = "ADDITIONAL_NOTES", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 5000", max = 5000)
	@Column(name = "additional_notes")
	@Schema(description = "The Additional Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Additional Notes here] end
	private String additionalNotes;

	// % protected region % [Modify attribute annotation for Discharge Summary here] off begin
	@CsvBindByName(column = "DISCHARGE_SUMMARY", required = false)
	@Nullable
	@Column(name = "discharge_summary")
	@Schema(description = "The Discharge Summary of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discharge Summary here] end
	private String dischargeSummary;

	// % protected region % [Modify attribute annotation for Condition Upon Discharge here] off begin
	@CsvBindByName(column = "CONDITION_UPON_DISCHARGE", required = false)
	@Nullable
	@Column(name = "condition_upon_discharge")
	@Schema(description = "The Condition Upon Discharge of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Condition Upon Discharge here] end
	private String conditionUponDischarge;

	// % protected region % [Modify attribute annotation for Escorted By here] off begin
	@CsvBindByName(column = "ESCORTED_BY", required = false)
	@Nullable
	@Column(name = "escorted_by")
	@Schema(description = "The Escorted By of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Escorted By here] end
	private String escortedBy;

	// % protected region % [Modify attribute annotation for Discharge Reason here] off begin
	@CsvBindByName(column = "DISCHARGE_REASON", required = false)
	@Nullable
	@Column(name = "discharge_reason")
	@Schema(description = "The Discharge Reason of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discharge Reason here] end
	private String dischargeReason;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Diagnosis Examination Records here] off begin
	@Schema(description = "The Diagnosis Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecordDischargeSummary", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnosis Examination Records here] end
	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	// % protected region % [Update the annotation for diagnosisExaminationRecordsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSIS_EXAMINATION_RECORDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosisExaminationRecordsIds here] end
	private Set<UUID> diagnosisExaminationRecordsIds = new HashSet<>();

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

	// % protected region % [Update the annotation for Discharging Doctor here] off begin
	@Schema(description = "The Discharging Doctor entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Discharging Doctor here] end
	private StaffEntity dischargingDoctor;

	// % protected region % [Update the annotation for dischargingDoctorId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DISCHARGING_DOCTOR_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for dischargingDoctorId here] end
	private UUID dischargingDoctorId;

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
	public void addDiagnosisExaminationRecords(@NotNull DiagnosisExaminationRecordEntity entity) {
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
	public void addDiagnosisExaminationRecords(@NotNull Collection<DiagnosisExaminationRecordEntity> entities) {
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
	public void removeDiagnosisExaminationRecords(@NotNull DiagnosisExaminationRecordEntity entity) {
		this.removeDiagnosisExaminationRecords(entity, true);
	}

	/**
	 * Remove the given DiagnosisExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisExaminationRecords(@NotNull DiagnosisExaminationRecordEntity entity, boolean reverse) {
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
	public void removeDiagnosisExaminationRecords(@NotNull Collection<DiagnosisExaminationRecordEntity> entities) {
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
	public void setDiagnosisExaminationRecords(@NotNull Collection<DiagnosisExaminationRecordEntity> entities) {
		setDiagnosisExaminationRecords(entities, true);
	}

	/**
	 * Replace the current entities in Diagnosis Examination Records with the given ones.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisExaminationRecords(@NotNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {

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
	public void setDischargingDoctor(@NotNull StaffEntity entity) {
		setDischargingDoctor(entity, true);
	}

	/**
	 * Set or update the dischargingDoctor in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to dischargingDoctor
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDischargingDoctor(@NotNull StaffEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "DIASTOLE,SYSTOLE,PULSE,BP_STANDING_SYSTOLE,BP_STANDING_DIASTOLE,PULSE_REGULARITY,PULSE_STRENGTH,TEMPERATURE,TEMPERATURE_SCALE,GCS_EYES,GCS_VERBAL,GCS_MOTOR,TOTAL_GCS_SCORE,CONSCIOUSNESS,HEIGHT,HEIGHT_SCALE,WEIGHT,WEIGHT_SCALE,BMI,RESPIRATORY,OXYGEN_SATURATION,WAIST_CIRCUMFERENCE,WAIST_CIRCUMFERENCE_UNIT,NUTRITION_STATUS,PAIN_SCALE,PAIN_SCALE_USED,RISK_FALL_SCALE,OBJECTIVE,RISK_FALL_SCALE_USED,SUBJECTIVE,PLAN,PURPOSE,EXAMINATION_SUB_CASE,ACCIDENTAL_TYPE,SERVICE_CASE,ACCIDENTAL_SUB_TYPE,ADDITIONAL_NOTES,DISCHARGE_SUMMARY,CONDITION_UPON_DISCHARGE,ESCORTED_BY,DISCHARGE_REASON,MEDICAL_EXAMINATION_RECORD_ID,DISCHARGING_DOCTOR_ID,DIAGNOSIS_EXAMINATION_RECORDS_IDS,ID";
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

		Optional<StaffEntity> dischargingDoctorRelation = Optional.ofNullable(this.dischargingDoctor);
		dischargingDoctorRelation.ifPresent(entity -> this.dischargingDoctorId = entity.getId());

		this.diagnosisExaminationRecordsIds = new HashSet<>();
		for (DiagnosisExaminationRecordEntity diagnosisExaminationRecords: this.diagnosisExaminationRecords) {
			this.diagnosisExaminationRecordsIds.add(diagnosisExaminationRecords.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalExaminationRecordDischargeSummary) {
		if (this == medicalExaminationRecordDischargeSummary) {
			return true;
		}
		if (medicalExaminationRecordDischargeSummary == null || this.getClass() != medicalExaminationRecordDischargeSummary.getClass()) {
			return false;
		}
		if (!super.equals(medicalExaminationRecordDischargeSummary)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalExaminationRecordDischargeSummaryEntity that = (MedicalExaminationRecordDischargeSummaryEntity) medicalExaminationRecordDischargeSummary;
		return
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.pulse, that.pulse) &&
			Objects.equals(this.bpStandingSystole, that.bpStandingSystole) &&
			Objects.equals(this.bpStandingDiastole, that.bpStandingDiastole) &&
			Objects.equals(this.pulseRegularity, that.pulseRegularity) &&
			Objects.equals(this.pulseStrength, that.pulseStrength) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.temperatureScale, that.temperatureScale) &&
			Objects.equals(this.gcsEyes, that.gcsEyes) &&
			Objects.equals(this.gcsVerbal, that.gcsVerbal) &&
			Objects.equals(this.gcsMotor, that.gcsMotor) &&
			Objects.equals(this.totalGCSScore, that.totalGCSScore) &&
			Objects.equals(this.consciousness, that.consciousness) &&
			Objects.equals(this.height, that.height) &&
			Objects.equals(this.heightScale, that.heightScale) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.weightScale, that.weightScale) &&
			Objects.equals(this.bmi, that.bmi) &&
			Objects.equals(this.respiratory, that.respiratory) &&
			Objects.equals(this.oxygenSaturation, that.oxygenSaturation) &&
			Objects.equals(this.waistCircumference, that.waistCircumference) &&
			Objects.equals(this.waistCircumferenceUnit, that.waistCircumferenceUnit) &&
			Objects.equals(this.nutritionStatus, that.nutritionStatus) &&
			Objects.equals(this.painScale, that.painScale) &&
			Objects.equals(this.painScaleUsed, that.painScaleUsed) &&
			Objects.equals(this.riskFallScale, that.riskFallScale) &&
			Objects.equals(this.objective, that.objective) &&
			Objects.equals(this.riskFallScaleUsed, that.riskFallScaleUsed) &&
			Objects.equals(this.subjective, that.subjective) &&
			Objects.equals(this.plan, that.plan) &&
			Objects.equals(this.purpose, that.purpose) &&
			Objects.equals(this.examinationSubCase, that.examinationSubCase) &&
			Objects.equals(this.accidentalType, that.accidentalType) &&
			Objects.equals(this.serviceCase, that.serviceCase) &&
			Objects.equals(this.accidentalSubType, that.accidentalSubType) &&
			Objects.equals(this.additionalNotes, that.additionalNotes) &&
			Objects.equals(this.dischargeSummary, that.dischargeSummary) &&
			Objects.equals(this.conditionUponDischarge, that.conditionUponDischarge) &&
			Objects.equals(this.escortedBy, that.escortedBy) &&
			Objects.equals(this.dischargeReason, that.dischargeReason) &&
			Objects.equals(this.diagnosisExaminationRecordsIds, that.diagnosisExaminationRecordsIds) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId) &&
			Objects.equals(this.dischargingDoctorId, that.dischargingDoctorId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
