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
import kmsweb.dtos.MedicalExaminationRecordEntityDto;
import kmsweb.entities.listeners.MedicalExaminationRecordEntityListener;
import kmsweb.serializers.MedicalExaminationRecordSerializer;
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
@EntityListeners({MedicalExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a MedicalExaminationRecordEntityDto and converts it into a MedicalExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalExaminationRecordEntityDto
	 */
	public MedicalExaminationRecordEntity(MedicalExaminationRecordEntityDto medicalExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalExaminationRecordEntityDto.getId() != null) {
			this.setId(medicalExaminationRecordEntityDto.getId());
		}

		if (medicalExaminationRecordEntityDto.getDiastole() != null) {
			this.setDiastole(medicalExaminationRecordEntityDto.getDiastole());
		}

		if (medicalExaminationRecordEntityDto.getSystole() != null) {
			this.setSystole(medicalExaminationRecordEntityDto.getSystole());
		}

		if (medicalExaminationRecordEntityDto.getPulse() != null) {
			this.setPulse(medicalExaminationRecordEntityDto.getPulse());
		}

		if (medicalExaminationRecordEntityDto.getBpStandingSystole() != null) {
			this.setBpStandingSystole(medicalExaminationRecordEntityDto.getBpStandingSystole());
		}

		if (medicalExaminationRecordEntityDto.getBpStandingDiastole() != null) {
			this.setBpStandingDiastole(medicalExaminationRecordEntityDto.getBpStandingDiastole());
		}

		if (medicalExaminationRecordEntityDto.getPulseRegularity() != null) {
			this.setPulseRegularity(medicalExaminationRecordEntityDto.getPulseRegularity());
		}

		if (medicalExaminationRecordEntityDto.getPulseStrength() != null) {
			this.setPulseStrength(medicalExaminationRecordEntityDto.getPulseStrength());
		}

		if (medicalExaminationRecordEntityDto.getTemperature() != null) {
			this.setTemperature(medicalExaminationRecordEntityDto.getTemperature());
		}

		if (medicalExaminationRecordEntityDto.getTemperatureScale() != null) {
			this.setTemperatureScale(medicalExaminationRecordEntityDto.getTemperatureScale());
		}

		if (medicalExaminationRecordEntityDto.getGcsEyes() != null) {
			this.setGcsEyes(medicalExaminationRecordEntityDto.getGcsEyes());
		}

		if (medicalExaminationRecordEntityDto.getGcsVerbal() != null) {
			this.setGcsVerbal(medicalExaminationRecordEntityDto.getGcsVerbal());
		}

		if (medicalExaminationRecordEntityDto.getGcsMotor() != null) {
			this.setGcsMotor(medicalExaminationRecordEntityDto.getGcsMotor());
		}

		if (medicalExaminationRecordEntityDto.getTotalGCSScore() != null) {
			this.setTotalGCSScore(medicalExaminationRecordEntityDto.getTotalGCSScore());
		}

		if (medicalExaminationRecordEntityDto.getConsciousness() != null) {
			this.setConsciousness(medicalExaminationRecordEntityDto.getConsciousness());
		}

		if (medicalExaminationRecordEntityDto.getHeight() != null) {
			this.setHeight(medicalExaminationRecordEntityDto.getHeight());
		}

		if (medicalExaminationRecordEntityDto.getHeightScale() != null) {
			this.setHeightScale(medicalExaminationRecordEntityDto.getHeightScale());
		}

		if (medicalExaminationRecordEntityDto.getWeight() != null) {
			this.setWeight(medicalExaminationRecordEntityDto.getWeight());
		}

		if (medicalExaminationRecordEntityDto.getWeightScale() != null) {
			this.setWeightScale(medicalExaminationRecordEntityDto.getWeightScale());
		}

		if (medicalExaminationRecordEntityDto.getBmi() != null) {
			this.setBmi(medicalExaminationRecordEntityDto.getBmi());
		}

		if (medicalExaminationRecordEntityDto.getRespiratory() != null) {
			this.setRespiratory(medicalExaminationRecordEntityDto.getRespiratory());
		}

		if (medicalExaminationRecordEntityDto.getOxygenSaturation() != null) {
			this.setOxygenSaturation(medicalExaminationRecordEntityDto.getOxygenSaturation());
		}

		if (medicalExaminationRecordEntityDto.getWaistCircumference() != null) {
			this.setWaistCircumference(medicalExaminationRecordEntityDto.getWaistCircumference());
		}

		if (medicalExaminationRecordEntityDto.getWaistCircumferenceUnit() != null) {
			this.setWaistCircumferenceUnit(medicalExaminationRecordEntityDto.getWaistCircumferenceUnit());
		}

		if (medicalExaminationRecordEntityDto.getNutritionStatus() != null) {
			this.setNutritionStatus(medicalExaminationRecordEntityDto.getNutritionStatus());
		}

		if (medicalExaminationRecordEntityDto.getPainScale() != null) {
			this.setPainScale(medicalExaminationRecordEntityDto.getPainScale());
		}

		if (medicalExaminationRecordEntityDto.getPainScaleUsed() != null) {
			this.setPainScaleUsed(medicalExaminationRecordEntityDto.getPainScaleUsed());
		}

		if (medicalExaminationRecordEntityDto.getRiskFallScale() != null) {
			this.setRiskFallScale(medicalExaminationRecordEntityDto.getRiskFallScale());
		}

		if (medicalExaminationRecordEntityDto.getObjective() != null) {
			this.setObjective(medicalExaminationRecordEntityDto.getObjective());
		}

		if (medicalExaminationRecordEntityDto.getRiskFallScaleUsed() != null) {
			this.setRiskFallScaleUsed(medicalExaminationRecordEntityDto.getRiskFallScaleUsed());
		}

		if (medicalExaminationRecordEntityDto.getSubjective() != null) {
			this.setSubjective(medicalExaminationRecordEntityDto.getSubjective());
		}

		if (medicalExaminationRecordEntityDto.getPlan() != null) {
			this.setPlan(medicalExaminationRecordEntityDto.getPlan());
		}

		if (medicalExaminationRecordEntityDto.getPurpose() != null) {
			this.setPurpose(medicalExaminationRecordEntityDto.getPurpose());
		}

		if (medicalExaminationRecordEntityDto.getExaminationSubCase() != null) {
			this.setExaminationSubCase(medicalExaminationRecordEntityDto.getExaminationSubCase());
		}

		if (medicalExaminationRecordEntityDto.getAccidentalType() != null) {
			this.setAccidentalType(medicalExaminationRecordEntityDto.getAccidentalType());
		}

		if (medicalExaminationRecordEntityDto.getServiceCase() != null) {
			this.setServiceCase(medicalExaminationRecordEntityDto.getServiceCase());
		}

		if (medicalExaminationRecordEntityDto.getAccidentalSubType() != null) {
			this.setAccidentalSubType(medicalExaminationRecordEntityDto.getAccidentalSubType());
		}

		if (medicalExaminationRecordEntityDto.getAdditionalNotes() != null) {
			this.setAdditionalNotes(medicalExaminationRecordEntityDto.getAdditionalNotes());
		}

		if (medicalExaminationRecordEntityDto.getDentalProcedure() != null) {
			this.setDentalProcedure(medicalExaminationRecordEntityDto.getDentalProcedure());
		}

		if (medicalExaminationRecordEntityDto.getPsychiatryCase() != null) {
			this.setPsychiatryCase(medicalExaminationRecordEntityDto.getPsychiatryCase());
		}

		if (medicalExaminationRecordEntityDto.getTherapy() != null) {
			this.setTherapy(medicalExaminationRecordEntityDto.getTherapy());
		}

		if (medicalExaminationRecordEntityDto.getFamilyPlanning() != null) {
			this.setFamilyPlanning(medicalExaminationRecordEntityDto.getFamilyPlanning());
		}

		if (medicalExaminationRecordEntityDto.getCondition() != null) {
			this.setCondition(medicalExaminationRecordEntityDto.getCondition());
		}

		if (medicalExaminationRecordEntityDto.getFamilyPlanningCase() != null) {
			this.setFamilyPlanningCase(medicalExaminationRecordEntityDto.getFamilyPlanningCase());
		}

		if (medicalExaminationRecordEntityDto.getPreviousContraceptiveMethod() != null) {
			this.setPreviousContraceptiveMethod(medicalExaminationRecordEntityDto.getPreviousContraceptiveMethod());
		}

		if (medicalExaminationRecordEntityDto.getSideEffects() != null) {
			this.setSideEffects(medicalExaminationRecordEntityDto.getSideEffects());
		}

		if (medicalExaminationRecordEntityDto.getComplication() != null) {
			this.setComplication(medicalExaminationRecordEntityDto.getComplication());
		}

		if (medicalExaminationRecordEntityDto.getContraseptiveMethod() != null) {
			this.setContraseptiveMethod(medicalExaminationRecordEntityDto.getContraseptiveMethod());
		}

		if (medicalExaminationRecordEntityDto.getVisitType() != null) {
			this.setVisitType(medicalExaminationRecordEntityDto.getVisitType());
		}

		if (medicalExaminationRecordEntityDto.getHearingTestMethod() != null) {
			this.setHearingTestMethod(medicalExaminationRecordEntityDto.getHearingTestMethod());
		}

		if (medicalExaminationRecordEntityDto.getHearingTestNotes() != null) {
			this.setHearingTestNotes(medicalExaminationRecordEntityDto.getHearingTestNotes());
		}

		if (medicalExaminationRecordEntityDto.getHearingLossCategory() != null) {
			this.setHearingLossCategory(medicalExaminationRecordEntityDto.getHearingLossCategory());
		}

		if (medicalExaminationRecordEntityDto.getHearingLossNotes() != null) {
			this.setHearingLossNotes(medicalExaminationRecordEntityDto.getHearingLossNotes());
		}

		if (medicalExaminationRecordEntityDto.getEyePositionRightEye() != null) {
			this.setEyePositionRightEye(medicalExaminationRecordEntityDto.getEyePositionRightEye());
		}

		if (medicalExaminationRecordEntityDto.getEyePositionLeftEye() != null) {
			this.setEyePositionLeftEye(medicalExaminationRecordEntityDto.getEyePositionLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getMuscleBalanceRightEye() != null) {
			this.setMuscleBalanceRightEye(medicalExaminationRecordEntityDto.getMuscleBalanceRightEye());
		}

		if (medicalExaminationRecordEntityDto.getMuscleBalanceLeftEye() != null) {
			this.setMuscleBalanceLeftEye(medicalExaminationRecordEntityDto.getMuscleBalanceLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getVisualFieldRightEye() != null) {
			this.setVisualFieldRightEye(medicalExaminationRecordEntityDto.getVisualFieldRightEye());
		}

		if (medicalExaminationRecordEntityDto.getVisualFieldLeftEye() != null) {
			this.setVisualFieldLeftEye(medicalExaminationRecordEntityDto.getVisualFieldLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getOcularFunduscopyRightEye() != null) {
			this.setOcularFunduscopyRightEye(medicalExaminationRecordEntityDto.getOcularFunduscopyRightEye());
		}

		if (medicalExaminationRecordEntityDto.getOcularFunduscopyLeftEye() != null) {
			this.setOcularFunduscopyLeftEye(medicalExaminationRecordEntityDto.getOcularFunduscopyLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getIntraocularPressureRightEye() != null) {
			this.setIntraocularPressureRightEye(medicalExaminationRecordEntityDto.getIntraocularPressureRightEye());
		}

		if (medicalExaminationRecordEntityDto.getIntraocularPressureLeftEye() != null) {
			this.setIntraocularPressureLeftEye(medicalExaminationRecordEntityDto.getIntraocularPressureLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getColorBlindness() != null) {
			this.setColorBlindness(medicalExaminationRecordEntityDto.getColorBlindness());
		}

		if (medicalExaminationRecordEntityDto.getVisualAcuityRightEye() != null) {
			this.setVisualAcuityRightEye(medicalExaminationRecordEntityDto.getVisualAcuityRightEye());
		}

		if (medicalExaminationRecordEntityDto.getVisualAcuityLeftEye() != null) {
			this.setVisualAcuityLeftEye(medicalExaminationRecordEntityDto.getVisualAcuityLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getCorrectionRightEye() != null) {
			this.setCorrectionRightEye(medicalExaminationRecordEntityDto.getCorrectionRightEye());
		}

		if (medicalExaminationRecordEntityDto.getCorrectionLeftEye() != null) {
			this.setCorrectionLeftEye(medicalExaminationRecordEntityDto.getCorrectionLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getAdditionRightEye() != null) {
			this.setAdditionRightEye(medicalExaminationRecordEntityDto.getAdditionRightEye());
		}

		if (medicalExaminationRecordEntityDto.getAdditionLeftEye() != null) {
			this.setAdditionLeftEye(medicalExaminationRecordEntityDto.getAdditionLeftEye());
		}

		if (medicalExaminationRecordEntityDto.getOcclusion() != null) {
			this.setOcclusion(medicalExaminationRecordEntityDto.getOcclusion());
		}

		if (medicalExaminationRecordEntityDto.getTorusPalatinus() != null) {
			this.setTorusPalatinus(medicalExaminationRecordEntityDto.getTorusPalatinus());
		}

		if (medicalExaminationRecordEntityDto.getTorusMandibularis() != null) {
			this.setTorusMandibularis(medicalExaminationRecordEntityDto.getTorusMandibularis());
		}

		if (medicalExaminationRecordEntityDto.getPalatum() != null) {
			this.setPalatum(medicalExaminationRecordEntityDto.getPalatum());
		}

		if (medicalExaminationRecordEntityDto.getDiastema() != null) {
			this.setDiastema(medicalExaminationRecordEntityDto.getDiastema());
		}

		if (medicalExaminationRecordEntityDto.getDiastemaNotes() != null) {
			this.setDiastemaNotes(medicalExaminationRecordEntityDto.getDiastemaNotes());
		}

		if (medicalExaminationRecordEntityDto.getToothAnomaly() != null) {
			this.setToothAnomaly(medicalExaminationRecordEntityDto.getToothAnomaly());
		}

		if (medicalExaminationRecordEntityDto.getToothAnomalyNotes() != null) {
			this.setToothAnomalyNotes(medicalExaminationRecordEntityDto.getToothAnomalyNotes());
		}

		if (medicalExaminationRecordEntityDto.getOtherDentalNotes() != null) {
			this.setOtherDentalNotes(medicalExaminationRecordEntityDto.getOtherDentalNotes());
		}

		if (medicalExaminationRecordEntityDto.getDecayed() != null) {
			this.setDecayed(medicalExaminationRecordEntityDto.getDecayed());
		}

		if (medicalExaminationRecordEntityDto.getMissing() != null) {
			this.setMissing(medicalExaminationRecordEntityDto.getMissing());
		}

		if (medicalExaminationRecordEntityDto.getFilled() != null) {
			this.setFilled(medicalExaminationRecordEntityDto.getFilled());
		}

		if (medicalExaminationRecordEntityDto.getTotalPhotograph() != null) {
			this.setTotalPhotograph(medicalExaminationRecordEntityDto.getTotalPhotograph());
		}

		if (medicalExaminationRecordEntityDto.getPhotographType() != null) {
			this.setPhotographType(medicalExaminationRecordEntityDto.getPhotographType());
		}

		if (medicalExaminationRecordEntityDto.getTotalRontgenPhotograph() != null) {
			this.setTotalRontgenPhotograph(medicalExaminationRecordEntityDto.getTotalRontgenPhotograph());
		}

		if (medicalExaminationRecordEntityDto.getRontgenPhotographType() != null) {
			this.setRontgenPhotographType(medicalExaminationRecordEntityDto.getRontgenPhotographType());
		}

		if (medicalExaminationRecordEntityDto.getAmendmentDetails() != null) {
			this.setAmendmentDetails(medicalExaminationRecordEntityDto.getAmendmentDetails());
		}

		if (medicalExaminationRecordEntityDto.getBirthHistory() != null) {
			this.setBirthHistory(medicalExaminationRecordEntityDto.getBirthHistory());
		}

		if (medicalExaminationRecordEntityDto.getBodyChartExamination() != null) {
			this.setBodyChartExamination(medicalExaminationRecordEntityDto.getBodyChartExamination());
		}

		if (medicalExaminationRecordEntityDto.getCoTreatingDoctors() != null) {
			this.setCoTreatingDoctors(medicalExaminationRecordEntityDto.getCoTreatingDoctors());
		}

		if (medicalExaminationRecordEntityDto.getDailyCareCPPTs() != null) {
			this.setDailyCareCPPTs(medicalExaminationRecordEntityDto.getDailyCareCPPTs());
		}

		if (medicalExaminationRecordEntityDto.getDeliveryMedicalExaminationRecord() != null) {
			this.setDeliveryMedicalExaminationRecord(medicalExaminationRecordEntityDto.getDeliveryMedicalExaminationRecord());
		}

		if (medicalExaminationRecordEntityDto.getDiagnosisExaminationRecords() != null) {
			this.setDiagnosisExaminationRecords(medicalExaminationRecordEntityDto.getDiagnosisExaminationRecords());
		}

		if (medicalExaminationRecordEntityDto.getDiagnosisNandas() != null) {
			this.setDiagnosisNandas(medicalExaminationRecordEntityDto.getDiagnosisNandas());
		}

		if (medicalExaminationRecordEntityDto.getEntExamination() != null) {
			this.setEntExamination(medicalExaminationRecordEntityDto.getEntExamination());
		}

		if (medicalExaminationRecordEntityDto.getEmergencyMedicationExaminationRecord() != null) {
			this.setEmergencyMedicationExaminationRecord(medicalExaminationRecordEntityDto.getEmergencyMedicationExaminationRecord());
		}

		if (medicalExaminationRecordEntityDto.getFormulirKonselingTesHiv() != null) {
			this.setFormulirKonselingTesHiv(medicalExaminationRecordEntityDto.getFormulirKonselingTesHiv());
		}

		if (medicalExaminationRecordEntityDto.getHemodialysisExamination() != null) {
			this.setHemodialysisExamination(medicalExaminationRecordEntityDto.getHemodialysisExamination());
		}

		if (medicalExaminationRecordEntityDto.getMedicalExaminationRecordDischargeSummary() != null) {
			this.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordEntityDto.getMedicalExaminationRecordDischargeSummary());
		}

		if (medicalExaminationRecordEntityDto.getMedicalRecordInitialChecklist() != null) {
			this.setMedicalRecordInitialChecklist(medicalExaminationRecordEntityDto.getMedicalRecordInitialChecklist());
		}

		if (medicalExaminationRecordEntityDto.getMedicalRecordNextVerificationChecklist() != null) {
			this.setMedicalRecordNextVerificationChecklist(medicalExaminationRecordEntityDto.getMedicalRecordNextVerificationChecklist());
		}

		if (medicalExaminationRecordEntityDto.getNurseVitalSignMeasurement() != null) {
			this.setNurseVitalSignMeasurement(medicalExaminationRecordEntityDto.getNurseVitalSignMeasurement());
		}

		if (medicalExaminationRecordEntityDto.getObstetricAndGynecologyHistory() != null) {
			this.setObstetricAndGynecologyHistory(medicalExaminationRecordEntityDto.getObstetricAndGynecologyHistory());
		}

		if (medicalExaminationRecordEntityDto.getOdontogramExamination() != null) {
			this.setOdontogramExamination(medicalExaminationRecordEntityDto.getOdontogramExamination());
		}

		if (medicalExaminationRecordEntityDto.getOperatingTheaterMedicalExaminationRecord() != null) {
			this.setOperatingTheaterMedicalExaminationRecord(medicalExaminationRecordEntityDto.getOperatingTheaterMedicalExaminationRecord());
		}

		if (medicalExaminationRecordEntityDto.getOphthalmologyExamination() != null) {
			this.setOphthalmologyExamination(medicalExaminationRecordEntityDto.getOphthalmologyExamination());
		}

		if (medicalExaminationRecordEntityDto.getRoomTransfers() != null) {
			this.setRoomTransfers(medicalExaminationRecordEntityDto.getRoomTransfers());
		}

		if (medicalExaminationRecordEntityDto.getDoctor() != null) {
			this.setDoctor(medicalExaminationRecordEntityDto.getDoctor());
		}

		if (medicalExaminationRecordEntityDto.getInpatientMedicalExaminationRecord() != null) {
			this.setInpatientMedicalExaminationRecord(medicalExaminationRecordEntityDto.getInpatientMedicalExaminationRecord());
		}

		if (medicalExaminationRecordEntityDto.getRegistration() != null) {
			this.setRegistration(medicalExaminationRecordEntityDto.getRegistration());
		}

		if (medicalExaminationRecordEntityDto.getMedicalTranscriber() != null) {
			this.setMedicalTranscriber(medicalExaminationRecordEntityDto.getMedicalTranscriber());
		}

		if (medicalExaminationRecordEntityDto.getNurse() != null) {
			this.setNurse(medicalExaminationRecordEntityDto.getNurse());
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

	// % protected region % [Modify attribute annotation for Dental Procedure here] off begin
	@CsvBindByName(column = "DENTAL_PROCEDURE", required = false)
	@Nullable
	@Column(name = "dental_procedure")
	@Schema(description = "The Dental Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dental Procedure here] end
	private String dentalProcedure;

	// % protected region % [Modify attribute annotation for Psychiatry Case here] off begin
	@CsvBindByName(column = "PSYCHIATRY_CASE", required = false)
	@Nullable
	@Column(name = "psychiatry_case")
	@Schema(description = "The Psychiatry Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Psychiatry Case here] end
	private String psychiatryCase;

	// % protected region % [Modify attribute annotation for Therapy here] off begin
	@CsvBindByName(column = "THERAPY", required = false)
	@Nullable
	@Column(name = "therapy")
	@Schema(description = "The Therapy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Therapy here] end
	private String therapy;

	// % protected region % [Modify attribute annotation for Family Planning here] off begin
	@CsvBindByName(column = "FAMILY_PLANNING", required = false)
	@Nullable
	@Column(name = "family_planning")
	@Schema(description = "The Family Planning of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Family Planning here] end
	private Boolean familyPlanning = false ;

	// % protected region % [Modify attribute annotation for Condition here] off begin
	@CsvBindByName(column = "CONDITION", required = false)
	@Nullable
	@Column(name = "condition")
	@Schema(description = "The Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Condition here] end
	private String condition;

	// % protected region % [Modify attribute annotation for Family Planning Case here] off begin
	@CsvBindByName(column = "FAMILY_PLANNING_CASE", required = false)
	@Nullable
	@Column(name = "family_planning_case")
	@Schema(description = "The Family Planning Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Family Planning Case here] end
	private String familyPlanningCase;

	// % protected region % [Modify attribute annotation for Previous Contraceptive Method here] off begin
	@CsvBindByName(column = "PREVIOUS_CONTRACEPTIVE_METHOD", required = false)
	@Nullable
	@Column(name = "previous_contraceptive_method")
	@Schema(description = "The Previous Contraceptive Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Previous Contraceptive Method here] end
	private String previousContraceptiveMethod;

	// % protected region % [Modify attribute annotation for Side Effects here] off begin
	@CsvBindByName(column = "SIDE_EFFECTS", required = false)
	@Nullable
	@Column(name = "side_effects")
	@Schema(description = "The Side Effects of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Side Effects here] end
	private String sideEffects;

	// % protected region % [Modify attribute annotation for Complication here] off begin
	@CsvBindByName(column = "COMPLICATION", required = false)
	@Nullable
	@Column(name = "complication")
	@Schema(description = "The Complication of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Complication here] end
	private String complication;

	// % protected region % [Modify attribute annotation for Contraseptive Method here] off begin
	@CsvBindByName(column = "CONTRASEPTIVE_METHOD", required = false)
	@Nullable
	@Column(name = "contraseptive_method")
	@Schema(description = "The Contraseptive Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contraseptive Method here] end
	private String contraseptiveMethod;

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@CsvBindByName(column = "VISIT_TYPE", required = false)
	@Nullable
	@Column(name = "visit_type")
	@Schema(description = "The Visit Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	// % protected region % [Modify attribute annotation for Hearing Test Method here] off begin
	@CsvBindByName(column = "HEARING_TEST_METHOD", required = false)
	@Nullable
	@Column(name = "hearing_test_method")
	@Schema(description = "The Hearing Test Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hearing Test Method here] end
	private String hearingTestMethod;

	// % protected region % [Modify attribute annotation for Hearing Test Notes here] off begin
	@CsvBindByName(column = "HEARING_TEST_NOTES", required = false)
	@Nullable
	@Column(name = "hearing_test_notes")
	@Schema(description = "The Hearing Test Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hearing Test Notes here] end
	private String hearingTestNotes;

	// % protected region % [Modify attribute annotation for Hearing Loss Category here] off begin
	@CsvBindByName(column = "HEARING_LOSS_CATEGORY", required = false)
	@Nullable
	@Column(name = "hearing_loss_category")
	@Schema(description = "The Hearing Loss Category of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hearing Loss Category here] end
	private String hearingLossCategory;

	// % protected region % [Modify attribute annotation for Hearing Loss Notes here] off begin
	@CsvBindByName(column = "HEARING_LOSS_NOTES", required = false)
	@Nullable
	@Column(name = "hearing_loss_notes")
	@Schema(description = "The Hearing Loss Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hearing Loss Notes here] end
	private String hearingLossNotes;

	// % protected region % [Modify attribute annotation for Eye Position Right Eye here] off begin
	@CsvBindByName(column = "EYE_POSITION_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "eye_position_right_eye")
	@Schema(description = "The Eye Position Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Eye Position Right Eye here] end
	private String eyePositionRightEye;

	// % protected region % [Modify attribute annotation for Eye Position Left Eye here] off begin
	@CsvBindByName(column = "EYE_POSITION_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "eye_position_left_eye")
	@Schema(description = "The Eye Position Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Eye Position Left Eye here] end
	private String eyePositionLeftEye;

	// % protected region % [Modify attribute annotation for Muscle Balance Right Eye here] off begin
	@CsvBindByName(column = "MUSCLE_BALANCE_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "muscle_balance_right_eye")
	@Schema(description = "The Muscle Balance Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Muscle Balance Right Eye here] end
	private String muscleBalanceRightEye;

	// % protected region % [Modify attribute annotation for Muscle Balance Left Eye here] off begin
	@CsvBindByName(column = "MUSCLE_BALANCE_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "muscle_balance_left_eye")
	@Schema(description = "The Muscle Balance Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Muscle Balance Left Eye here] end
	private String muscleBalanceLeftEye;

	// % protected region % [Modify attribute annotation for Visual Field Right Eye here] off begin
	@CsvBindByName(column = "VISUAL_FIELD_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "visual_field_right_eye")
	@Schema(description = "The Visual Field Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visual Field Right Eye here] end
	private String visualFieldRightEye;

	// % protected region % [Modify attribute annotation for Visual Field Left Eye here] off begin
	@CsvBindByName(column = "VISUAL_FIELD_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "visual_field_left_eye")
	@Schema(description = "The Visual Field Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visual Field Left Eye here] end
	private String visualFieldLeftEye;

	// % protected region % [Modify attribute annotation for Ocular Funduscopy Right Eye here] off begin
	@CsvBindByName(column = "OCULAR_FUNDUSCOPY_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "ocular_funduscopy_right_eye")
	@Schema(description = "The Ocular Funduscopy Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ocular Funduscopy Right Eye here] end
	private String ocularFunduscopyRightEye;

	// % protected region % [Modify attribute annotation for Ocular Funduscopy Left Eye here] off begin
	@CsvBindByName(column = "OCULAR_FUNDUSCOPY_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "ocular_funduscopy_left_eye")
	@Schema(description = "The Ocular Funduscopy Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ocular Funduscopy Left Eye here] end
	private String ocularFunduscopyLeftEye;

	// % protected region % [Modify attribute annotation for Intraocular Pressure Right Eye here] off begin
	@CsvBindByName(column = "INTRAOCULAR_PRESSURE_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "intraocular_pressure_right_eye")
	@Schema(description = "The Intraocular Pressure Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intraocular Pressure Right Eye here] end
	private String intraocularPressureRightEye;

	// % protected region % [Modify attribute annotation for Intraocular Pressure Left Eye here] off begin
	@CsvBindByName(column = "INTRAOCULAR_PRESSURE_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "intraocular_pressure_left_eye")
	@Schema(description = "The Intraocular Pressure Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Intraocular Pressure Left Eye here] end
	private String intraocularPressureLeftEye;

	// % protected region % [Modify attribute annotation for Color Blindness here] off begin
	@CsvBindByName(column = "COLOR_BLINDNESS", required = false)
	@Nullable
	@Column(name = "color_blindness")
	@Schema(description = "The Color Blindness of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Color Blindness here] end
	private String colorBlindness;

	// % protected region % [Modify attribute annotation for Visual Acuity Right Eye here] off begin
	@CsvBindByName(column = "VISUAL_ACUITY_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "visual_acuity_right_eye")
	@Schema(description = "The Visual Acuity Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visual Acuity Right Eye here] end
	private String visualAcuityRightEye;

	// % protected region % [Modify attribute annotation for Visual Acuity Left Eye here] off begin
	@CsvBindByName(column = "VISUAL_ACUITY_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "visual_acuity_left_eye")
	@Schema(description = "The Visual Acuity Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visual Acuity Left Eye here] end
	private String visualAcuityLeftEye;

	// % protected region % [Modify attribute annotation for Correction Right Eye here] off begin
	@CsvBindByName(column = "CORRECTION_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "correction_right_eye")
	@Schema(description = "The Correction Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Correction Right Eye here] end
	private String correctionRightEye;

	// % protected region % [Modify attribute annotation for Correction Left Eye here] off begin
	@CsvBindByName(column = "CORRECTION_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "correction_left_eye")
	@Schema(description = "The Correction Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Correction Left Eye here] end
	private String correctionLeftEye;

	// % protected region % [Modify attribute annotation for Addition Right Eye here] off begin
	@CsvBindByName(column = "ADDITION_RIGHT_EYE", required = false)
	@Nullable
	@Column(name = "addition_right_eye")
	@Schema(description = "The Addition Right Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Addition Right Eye here] end
	private String additionRightEye;

	// % protected region % [Modify attribute annotation for Addition Left Eye here] off begin
	@CsvBindByName(column = "ADDITION_LEFT_EYE", required = false)
	@Nullable
	@Column(name = "addition_left_eye")
	@Schema(description = "The Addition Left Eye of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Addition Left Eye here] end
	private String additionLeftEye;

	// % protected region % [Modify attribute annotation for Occlusion here] off begin
	@CsvBindByName(column = "OCCLUSION", required = false)
	@Nullable
	@Column(name = "occlusion")
	@Schema(description = "The Occlusion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Occlusion here] end
	private String occlusion;

	// % protected region % [Modify attribute annotation for Torus Palatinus here] off begin
	@CsvBindByName(column = "TORUS_PALATINUS", required = false)
	@Nullable
	@Column(name = "torus_palatinus")
	@Schema(description = "The Torus Palatinus of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Torus Palatinus here] end
	private String torusPalatinus;

	// % protected region % [Modify attribute annotation for Torus Mandibularis here] off begin
	@CsvBindByName(column = "TORUS_MANDIBULARIS", required = false)
	@Nullable
	@Column(name = "torus_mandibularis")
	@Schema(description = "The Torus Mandibularis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Torus Mandibularis here] end
	private String torusMandibularis;

	// % protected region % [Modify attribute annotation for Palatum here] off begin
	@CsvBindByName(column = "PALATUM", required = false)
	@Nullable
	@Column(name = "palatum")
	@Schema(description = "The Palatum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Palatum here] end
	private String palatum;

	// % protected region % [Modify attribute annotation for Diastema here] off begin
	@CsvBindByName(column = "DIASTEMA", required = false)
	@Nullable
	@Column(name = "diastema")
	@Schema(description = "The Diastema of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastema here] end
	private Boolean diastema = false ;

	// % protected region % [Modify attribute annotation for Diastema Notes here] off begin
	@CsvBindByName(column = "DIASTEMA_NOTES", required = false)
	@Nullable
	@Column(name = "diastema_notes")
	@Schema(description = "The Diastema Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastema Notes here] end
	private String diastemaNotes;

	// % protected region % [Modify attribute annotation for Tooth Anomaly here] off begin
	@CsvBindByName(column = "TOOTH_ANOMALY", required = false)
	@Nullable
	@Column(name = "tooth_anomaly")
	@Schema(description = "The Tooth Anomaly of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tooth Anomaly here] end
	private Boolean toothAnomaly = false ;

	// % protected region % [Modify attribute annotation for Tooth Anomaly Notes here] off begin
	@CsvBindByName(column = "TOOTH_ANOMALY_NOTES", required = false)
	@Nullable
	@Column(name = "tooth_anomaly_notes")
	@Schema(description = "The Tooth Anomaly Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tooth Anomaly Notes here] end
	private String toothAnomalyNotes;

	// % protected region % [Modify attribute annotation for Other Dental Notes here] off begin
	@CsvBindByName(column = "OTHER_DENTAL_NOTES", required = false)
	@Nullable
	@Column(name = "other_dental_notes")
	@Schema(description = "The Other Dental Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Dental Notes here] end
	private String otherDentalNotes;

	// % protected region % [Modify attribute annotation for Decayed here] off begin
	@CsvBindByName(column = "DECAYED", required = false)
	@Nullable
	@Column(name = "decayed")
	@Schema(description = "The Decayed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Decayed here] end
	private String decayed;

	// % protected region % [Modify attribute annotation for Missing here] off begin
	@CsvBindByName(column = "MISSING", required = false)
	@Nullable
	@Column(name = "missing")
	@Schema(description = "The Missing of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Missing here] end
	private String missing;

	// % protected region % [Modify attribute annotation for Filled here] off begin
	@CsvBindByName(column = "FILLED", required = false)
	@Nullable
	@Column(name = "filled")
	@Schema(description = "The Filled of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Filled here] end
	private String filled;

	// % protected region % [Modify attribute annotation for Total Photograph here] off begin
	@CsvBindByName(column = "TOTAL_PHOTOGRAPH", required = false)
	@Nullable
	@Column(name = "total_photograph")
	@Schema(description = "The Total Photograph of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Photograph here] end
	private String totalPhotograph;

	// % protected region % [Modify attribute annotation for Photograph Type here] off begin
	@CsvBindByName(column = "PHOTOGRAPH_TYPE", required = false)
	@Nullable
	@Column(name = "photograph_type")
	@Schema(description = "The Photograph Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Photograph Type here] end
	private String photographType;

	// % protected region % [Modify attribute annotation for Total Rontgen Photograph here] off begin
	@CsvBindByName(column = "TOTAL_RONTGEN_PHOTOGRAPH", required = false)
	@Nullable
	@Column(name = "total_rontgen_photograph")
	@Schema(description = "The Total Rontgen Photograph of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Rontgen Photograph here] end
	private String totalRontgenPhotograph;

	// % protected region % [Modify attribute annotation for Rontgen Photograph Type here] off begin
	@CsvBindByName(column = "RONTGEN_PHOTOGRAPH_TYPE", required = false)
	@Nullable
	@Column(name = "rontgen_photograph_type")
	@Schema(description = "The Rontgen Photograph Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rontgen Photograph Type here] end
	private String rontgenPhotographType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Amendment Details here] off begin
	@Schema(description = "The Amendment Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Amendment Details here] end
	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	// % protected region % [Update the annotation for amendmentDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "AMENDMENT_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for amendmentDetailsIds here] end
	private Set<UUID> amendmentDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Birth History here] off begin
	@Schema(description = "The Birth History entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Birth History here] end
	private BirthHistoryEntity birthHistory;

	// % protected region % [Update the annotation for birthHistoryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BIRTH_HISTORY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for birthHistoryId here] end
	private UUID birthHistoryId;

	// % protected region % [Update the annotation for Body Chart Examination here] off begin
	@Schema(description = "The Body Chart Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Body Chart Examination here] end
	private BodyChartExaminationEntity bodyChartExamination;

	// % protected region % [Update the annotation for bodyChartExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BODY_CHART_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bodyChartExaminationId here] end
	private UUID bodyChartExaminationId;

	// % protected region % [Update the annotation for Co Treating Doctors here] off begin
	@Schema(description = "The Co Treating Doctor entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Co Treating Doctors here] end
	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	// % protected region % [Update the annotation for coTreatingDoctorsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CO_TREATING_DOCTORS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for coTreatingDoctorsIds here] end
	private Set<UUID> coTreatingDoctorsIds = new HashSet<>();

	// % protected region % [Update the annotation for Daily Care CPPTs here] off begin
	@Schema(description = "The Daily Care CPPT entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Daily Care CPPTs here] end
	private Set<DailyCareCPPTEntity> dailyCareCPPTs = new HashSet<>();

	// % protected region % [Update the annotation for dailyCareCPPTsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DAILY_CARE_CPPTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dailyCareCPPTsIds here] end
	private Set<UUID> dailyCareCPPTsIds = new HashSet<>();

	// % protected region % [Update the annotation for Delivery Medical Examination Record here] off begin
	@Schema(description = "The Delivery Medical Examination Record entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Delivery Medical Examination Record here] end
	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DELIVERY_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] end
	private UUID deliveryMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Diagnosis Examination Records here] off begin
	@Schema(description = "The Diagnosis Examination Record entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnosis Examination Records here] end
	private Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecords = new HashSet<>();

	// % protected region % [Update the annotation for diagnosisExaminationRecordsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSIS_EXAMINATION_RECORDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosisExaminationRecordsIds here] end
	private Set<UUID> diagnosisExaminationRecordsIds = new HashSet<>();

	// % protected region % [Update the annotation for Diagnosis Nandas here] off begin
	@Schema(description = "The Diagnosis Nanda entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Diagnosis Nandas here] end
	private Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();

	// % protected region % [Update the annotation for diagnosisNandasIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DIAGNOSIS_NANDAS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for diagnosisNandasIds here] end
	private Set<UUID> diagnosisNandasIds = new HashSet<>();

	// % protected region % [Update the annotation for ENT Examination here] off begin
	@Schema(description = "The ENT Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for ENT Examination here] end
	private EntExaminationEntity entExamination;

	// % protected region % [Update the annotation for entExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ENT_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for entExaminationId here] end
	private UUID entExaminationId;

	// % protected region % [Update the annotation for Emergency Medication Examination Record here] off begin
	@Schema(description = "The Emergency Medical Examination Record entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Emergency Medication Examination Record here] end
	private EmergencyMedicalExaminationRecordEntity emergencyMedicationExaminationRecord;

	// % protected region % [Update the annotation for emergencyMedicationExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "EMERGENCY_MEDICATION_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for emergencyMedicationExaminationRecordId here] end
	private UUID emergencyMedicationExaminationRecordId;

	// % protected region % [Update the annotation for Formulir Konseling Tes Hiv here] off begin
	@Schema(description = "The Formulir Konseling Tes Hiv entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Formulir Konseling Tes Hiv here] end
	private FormulirKonselingTesHivEntity formulirKonselingTesHiv;

	// % protected region % [Update the annotation for formulirKonselingTesHivId here] off begin
	@Transient
	@CsvCustomBindByName(column = "FORMULIR_KONSELING_TES_HIV_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for formulirKonselingTesHivId here] end
	private UUID formulirKonselingTesHivId;

	// % protected region % [Update the annotation for Hemodialysis Examination here] off begin
	@Schema(description = "The Hemodialysis Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hemodialysis Examination here] end
	private HemodialysisExaminationEntity hemodialysisExamination;

	// % protected region % [Update the annotation for hemodialysisExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "HEMODIALYSIS_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for hemodialysisExaminationId here] end
	private UUID hemodialysisExaminationId;

	// % protected region % [Update the annotation for Medical Examination Record Discharge Summary here] off begin
	@Schema(description = "The Medical Examination Record Discharge Summary entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record Discharge Summary here] end
	private MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummary;

	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummaryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordDischargeSummaryId here] end
	private UUID medicalExaminationRecordDischargeSummaryId;

	// % protected region % [Update the annotation for Medical Record Initial Checklist here] off begin
	@Schema(description = "The Medical Record Initial Checklist entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Record Initial Checklist here] end
	private MedicalRecordInitialChecklistEntity medicalRecordInitialChecklist;

	// % protected region % [Update the annotation for medicalRecordInitialChecklistId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_RECORD_INITIAL_CHECKLIST_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalRecordInitialChecklistId here] end
	private UUID medicalRecordInitialChecklistId;

	// % protected region % [Update the annotation for Medical Record Next Verification Checklist here] off begin
	@Schema(description = "The Medical Record Next Verification Checklist entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Record Next Verification Checklist here] end
	private MedicalRecordNextVerificationChecklistEntity medicalRecordNextVerificationChecklist;

	// % protected region % [Update the annotation for medicalRecordNextVerificationChecklistId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalRecordNextVerificationChecklistId here] end
	private UUID medicalRecordNextVerificationChecklistId;

	// % protected region % [Update the annotation for Nurse Vital Sign Measurement here] off begin
	@Schema(description = "The Nurse Vital Sign Measurement entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nurse Vital Sign Measurement here] end
	private NurseVitalSignMeasurementEntity nurseVitalSignMeasurement;

	// % protected region % [Update the annotation for nurseVitalSignMeasurementId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSE_VITAL_SIGN_MEASUREMENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nurseVitalSignMeasurementId here] end
	private UUID nurseVitalSignMeasurementId;

	// % protected region % [Update the annotation for Obstetric And Gynecology History here] off begin
	@Schema(description = "The Obstetric And Gynecology History entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Obstetric And Gynecology History here] end
	private ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistory;

	// % protected region % [Update the annotation for obstetricAndGynecologyHistoryId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OBSTETRIC_AND_GYNECOLOGY_HISTORY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for obstetricAndGynecologyHistoryId here] end
	private UUID obstetricAndGynecologyHistoryId;

	// % protected region % [Update the annotation for Odontogram Examination here] off begin
	@Schema(description = "The Odontogram Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Odontogram Examination here] end
	private OdontogramExaminationEntity odontogramExamination;

	// % protected region % [Update the annotation for odontogramExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ODONTOGRAM_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for odontogramExaminationId here] end
	private UUID odontogramExaminationId;

	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] off begin
	@Schema(description = "The Operating Theater Medical Examination Record entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Operating Theater Medical Examination Record here] end
	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for operatingTheaterMedicalExaminationRecordId here] end
	private UUID operatingTheaterMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Ophthalmology Examination here] off begin
	@Schema(description = "The Ophthalmology Examination entities that are related to this entity.")
	@OneToOne(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Ophthalmology Examination here] end
	private OphthalmologyExaminationEntity ophthalmologyExamination;

	// % protected region % [Update the annotation for ophthalmologyExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "OPHTHALMOLOGY_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for ophthalmologyExaminationId here] end
	private UUID ophthalmologyExaminationId;

	// % protected region % [Update the annotation for Room Transfers here] off begin
	@Schema(description = "The Room Transfer entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Room Transfers here] end
	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	// % protected region % [Update the annotation for roomTransfersIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "ROOM_TRANSFERS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for roomTransfersIds here] end
	private Set<UUID> roomTransfersIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Doctor here] off begin
	@Schema(description = "The Doctor entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Doctor here] end
	private StaffEntity doctor;

	// % protected region % [Update the annotation for doctorId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DOCTOR_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for doctorId here] end
	private UUID doctorId;

	// % protected region % [Update the annotation for Inpatient Medical Examination Record here] off begin
	@Schema(description = "The Inpatient Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inpatient Medical Examination Record here] end
	private InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecord;

	// % protected region % [Update the annotation for inpatientMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INPATIENT_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for inpatientMedicalExaminationRecordId here] end
	private UUID inpatientMedicalExaminationRecordId;

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Update the annotation for Medical Transcriber here] off begin
	@Schema(description = "The Medical Transcriber entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Transcriber here] end
	private StaffEntity medicalTranscriber;

	// % protected region % [Update the annotation for medicalTranscriberId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_TRANSCRIBER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalTranscriberId here] end
	private UUID medicalTranscriberId;

	// % protected region % [Update the annotation for Nurse here] off begin
	@Schema(description = "The Nurse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nurse here] end
	private StaffEntity nurse;

	// % protected region % [Update the annotation for nurseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nurseId here] end
	private UUID nurseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NotNull AmendmentDetailEntity entity) {
		addAmendmentDetails(entity, true);
	}

	/**
	 * Add a new AmendmentDetailEntity to amendmentDetails in this entity.
	 *
	 * @param entity the given AmendmentDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAmendmentDetails(@NonNull AmendmentDetailEntity entity, boolean reverseAdd) {
		if (!this.amendmentDetails.contains(entity)) {
			amendmentDetails.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 */
	public void addAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		addAmendmentDetails(entities, true);
	}

	/**
	 * Add a new collection of AmendmentDetailEntity to Amendment Details in this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(AmendmentDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given AmendmentDetailEntity to be set to this entity
	 */
	public void removeAmendmentDetails(@NotNull AmendmentDetailEntity entity) {
		this.removeAmendmentDetails(entity, true);
	}

	/**
	 * Remove the given AmendmentDetailEntity from this entity.
	 *
	 * @param entity the given AmendmentDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAmendmentDetails(@NotNull AmendmentDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.amendmentDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 */
	public void removeAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		this.removeAmendmentDetails(entities, true);
	}

	/**
	 * Remove the given collection of AmendmentDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAmendmentDetails(@NonNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAmendmentDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAmendmentDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to be set to this entity
	 */
	public void setAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities) {
		setAmendmentDetails(entities, true);
	}

	/**
	 * Replace the current entities in Amendment Details with the given ones.
	 *
	 * @param entities the given collection of AmendmentDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAmendmentDetails(@NotNull Collection<AmendmentDetailEntity> entities, boolean reverseAdd) {

		this.unsetAmendmentDetails();
		this.amendmentDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAmendmentDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAmendmentDetails() {
		this.unsetAmendmentDetails(true);
	}

	/**
	 * Remove all the entities in Amendment Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAmendmentDetails(boolean doReverse) {
		if (doReverse) {
			this.amendmentDetails.forEach(amendmentDetailsEntity -> amendmentDetailsEntity.unsetMedicalExaminationRecord(false));
		}
		this.amendmentDetails.clear();
	}

	/**
	 * Similar to {@link this#setBirthHistory(BirthHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setBirthHistory(@NotNull BirthHistoryEntity entity) {
		setBirthHistory(entity, true);
	}

	/**
	 * Set or update birthHistory with the given BirthHistoryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBirthHistory(@NotNull BirthHistoryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBirthHistory here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBirthHistory here] end

		if (sameAsFormer(this.birthHistory, entity)) {
			return;
		}

		if (this.birthHistory != null) {
			this.birthHistory.unsetMedicalExaminationRecord();
		}

		this.birthHistory = entity;

		if (reverseAdd) {
			this.birthHistory.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBirthHistory outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBirthHistory outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBirthHistory(boolean)} but default to true.
	 */
	public void unsetBirthHistory() {
		this.unsetBirthHistory(true);
	}

	/**
	 * Remove the BirthHistoryEntity in Birth History from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBirthHistory(boolean reverse) {
		if (reverse && this.birthHistory != null) {
			this.birthHistory.unsetMedicalExaminationRecord(false);
		}
		this.birthHistory = null;
	}

	/**
	 * Similar to {@link this#setBodyChartExamination(BodyChartExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setBodyChartExamination(@NotNull BodyChartExaminationEntity entity) {
		setBodyChartExamination(entity, true);
	}

	/**
	 * Set or update bodyChartExamination with the given BodyChartExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBodyChartExamination(@NotNull BodyChartExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBodyChartExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBodyChartExamination here] end

		if (sameAsFormer(this.bodyChartExamination, entity)) {
			return;
		}

		if (this.bodyChartExamination != null) {
			this.bodyChartExamination.unsetMedicalExaminationRecord();
		}

		this.bodyChartExamination = entity;

		if (reverseAdd) {
			this.bodyChartExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBodyChartExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBodyChartExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBodyChartExamination(boolean)} but default to true.
	 */
	public void unsetBodyChartExamination() {
		this.unsetBodyChartExamination(true);
	}

	/**
	 * Remove the BodyChartExaminationEntity in Body Chart Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBodyChartExamination(boolean reverse) {
		if (reverse && this.bodyChartExamination != null) {
			this.bodyChartExamination.unsetMedicalExaminationRecord(false);
		}
		this.bodyChartExamination = null;
	}

/**
	 * Similar to {@link this#addCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity) {
		addCoTreatingDoctors(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingDoctors in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingDoctors(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingDoctors.contains(entity)) {
			coTreatingDoctors.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingDoctors(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Doctors in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingDoctors(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingDoctors(@NotNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.coTreatingDoctors.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingDoctors(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingDoctors(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingDoctors(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingDoctors(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingDoctors(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Doctors with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingDoctors(@NotNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingDoctors();
		this.coTreatingDoctors = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingDoctors(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingDoctors() {
		this.unsetCoTreatingDoctors(true);
	}

	/**
	 * Remove all the entities in Co Treating Doctors from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingDoctors(boolean doReverse) {
		if (doReverse) {
			this.coTreatingDoctors.forEach(coTreatingDoctorsEntity -> coTreatingDoctorsEntity.unsetMedicalExaminationRecord(false));
		}
		this.coTreatingDoctors.clear();
	}

/**
	 * Similar to {@link this#addDailyCareCPPTs(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTs(@NotNull DailyCareCPPTEntity entity) {
		addDailyCareCPPTs(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to dailyCareCPPTs in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDailyCareCPPTs(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.dailyCareCPPTs.contains(entity)) {
			dailyCareCPPTs.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addDailyCareCPPTs(@NotNull Collection<DailyCareCPPTEntity> entities) {
		addDailyCareCPPTs(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to Daily Care CPPTs in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDailyCareCPPTs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTs(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeDailyCareCPPTs(@NotNull DailyCareCPPTEntity entity) {
		this.removeDailyCareCPPTs(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDailyCareCPPTs(@NotNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.dailyCareCPPTs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeDailyCareCPPTs(@NotNull Collection<DailyCareCPPTEntity> entities) {
		this.removeDailyCareCPPTs(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDailyCareCPPTs(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDailyCareCPPTs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDailyCareCPPTs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setDailyCareCPPTs(@NotNull Collection<DailyCareCPPTEntity> entities) {
		setDailyCareCPPTs(entities, true);
	}

	/**
	 * Replace the current entities in Daily Care CPPTs with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDailyCareCPPTs(@NotNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetDailyCareCPPTs();
		this.dailyCareCPPTs = new HashSet<>(entities);
		if (reverseAdd) {
			this.dailyCareCPPTs.forEach(dailyCareCPPTsEntity -> dailyCareCPPTsEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDailyCareCPPTs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDailyCareCPPTs() {
		this.unsetDailyCareCPPTs(true);
	}

	/**
	 * Remove all the entities in Daily Care CPPTs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDailyCareCPPTs(boolean doReverse) {
		if (doReverse) {
			this.dailyCareCPPTs.forEach(dailyCareCPPTsEntity -> dailyCareCPPTsEntity.unsetMedicalExaminationRecord(false));
		}
		this.dailyCareCPPTs.clear();
	}

	/**
	 * Similar to {@link this#setDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		setDeliveryMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update deliveryMedicalExaminationRecord with the given DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] end

		if (sameAsFormer(this.deliveryMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.deliveryMedicalExaminationRecord = entity;

		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDeliveryMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDeliveryMedicalExaminationRecord() {
		this.unsetDeliveryMedicalExaminationRecord(true);
	}

	/**
	 * Remove the DeliveryMedicalExaminationRecordEntity in Delivery Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDeliveryMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.deliveryMedicalExaminationRecord = null;
	}

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
				entity.setMedicalExaminationRecord(this, false);
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
			entity.unsetMedicalExaminationRecord(false);
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
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.setMedicalExaminationRecord(this, false));
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
			this.diagnosisExaminationRecords.forEach(diagnosisExaminationRecordsEntity -> diagnosisExaminationRecordsEntity.unsetMedicalExaminationRecord(false));
		}
		this.diagnosisExaminationRecords.clear();
	}

/**
	 * Similar to {@link this#addDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be added to this entity
	 */
	public void addDiagnosisNandas(@NotNull DiagnosisNandaEntity entity) {
		addDiagnosisNandas(entity, true);
	}

	/**
	 * Add a new DiagnosisNandaEntity to diagnosisNandas in this entity.
	 *
	 * @param entity the given DiagnosisNandaEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosisNandas(@NonNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		if (!this.diagnosisNandas.contains(entity)) {
			diagnosisNandas.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be added to this entity
	 */
	public void addDiagnosisNandas(@NotNull Collection<DiagnosisNandaEntity> entities) {
		addDiagnosisNandas(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisNandaEntity to Diagnosis Nandas in this entity.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void removeDiagnosisNandas(@NotNull DiagnosisNandaEntity entity) {
		this.removeDiagnosisNandas(entity, true);
	}

	/**
	 * Remove the given DiagnosisNandaEntity from this entity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisNandas(@NotNull DiagnosisNandaEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.diagnosisNandas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be removed to this entity
	 */
	public void removeDiagnosisNandas(@NotNull Collection<DiagnosisNandaEntity> entities) {
		this.removeDiagnosisNandas(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisNandaEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to be set to this entity
	 */
	public void setDiagnosisNandas(@NotNull Collection<DiagnosisNandaEntity> entities) {
		setDiagnosisNandas(entities, true);
	}

	/**
	 * Replace the current entities in Diagnosis Nandas with the given ones.
	 *
	 * @param entities the given collection of DiagnosisNandaEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisNandas(@NotNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {

		this.unsetDiagnosisNandas();
		this.diagnosisNandas = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosisNandas.forEach(diagnosisNandasEntity -> diagnosisNandasEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosisNandas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosisNandas() {
		this.unsetDiagnosisNandas(true);
	}

	/**
	 * Remove all the entities in Diagnosis Nandas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosisNandas(boolean doReverse) {
		if (doReverse) {
			this.diagnosisNandas.forEach(diagnosisNandasEntity -> diagnosisNandasEntity.unsetMedicalExaminationRecord(false));
		}
		this.diagnosisNandas.clear();
	}

	/**
	 * Similar to {@link this#setEntExamination(EntExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setEntExamination(@NotNull EntExaminationEntity entity) {
		setEntExamination(entity, true);
	}

	/**
	 * Set or update entExamination with the given EntExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setEntExamination(@NotNull EntExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setEntExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setEntExamination here] end

		if (sameAsFormer(this.entExamination, entity)) {
			return;
		}

		if (this.entExamination != null) {
			this.entExamination.unsetMedicalExaminationRecord();
		}

		this.entExamination = entity;

		if (reverseAdd) {
			this.entExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setEntExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setEntExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetEntExamination(boolean)} but default to true.
	 */
	public void unsetEntExamination() {
		this.unsetEntExamination(true);
	}

	/**
	 * Remove the EntExaminationEntity in ENT Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetEntExamination(boolean reverse) {
		if (reverse && this.entExamination != null) {
			this.entExamination.unsetMedicalExaminationRecord(false);
		}
		this.entExamination = null;
	}

	/**
	 * Similar to {@link this#setEmergencyMedicationExaminationRecord(EmergencyMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setEmergencyMedicationExaminationRecord(@NotNull EmergencyMedicalExaminationRecordEntity entity) {
		setEmergencyMedicationExaminationRecord(entity, true);
	}

	/**
	 * Set or update emergencyMedicationExaminationRecord with the given EmergencyMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setEmergencyMedicationExaminationRecord(@NotNull EmergencyMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setEmergencyMedicationExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setEmergencyMedicationExaminationRecord here] end

		if (sameAsFormer(this.emergencyMedicationExaminationRecord, entity)) {
			return;
		}

		if (this.emergencyMedicationExaminationRecord != null) {
			this.emergencyMedicationExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.emergencyMedicationExaminationRecord = entity;

		if (reverseAdd) {
			this.emergencyMedicationExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setEmergencyMedicationExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setEmergencyMedicationExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetEmergencyMedicationExaminationRecord(boolean)} but default to true.
	 */
	public void unsetEmergencyMedicationExaminationRecord() {
		this.unsetEmergencyMedicationExaminationRecord(true);
	}

	/**
	 * Remove the EmergencyMedicalExaminationRecordEntity in Emergency Medication Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetEmergencyMedicationExaminationRecord(boolean reverse) {
		if (reverse && this.emergencyMedicationExaminationRecord != null) {
			this.emergencyMedicationExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.emergencyMedicationExaminationRecord = null;
	}

	/**
	 * Similar to {@link this#setFormulirKonselingTesHiv(FormulirKonselingTesHivEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setFormulirKonselingTesHiv(@NotNull FormulirKonselingTesHivEntity entity) {
		setFormulirKonselingTesHiv(entity, true);
	}

	/**
	 * Set or update formulirKonselingTesHiv with the given FormulirKonselingTesHivEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setFormulirKonselingTesHiv(@NotNull FormulirKonselingTesHivEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setFormulirKonselingTesHiv here] off begin
		// % protected region % [Add any additional logic here before the main logic for setFormulirKonselingTesHiv here] end

		if (sameAsFormer(this.formulirKonselingTesHiv, entity)) {
			return;
		}

		if (this.formulirKonselingTesHiv != null) {
			this.formulirKonselingTesHiv.unsetMedicalExaminationRecord();
		}

		this.formulirKonselingTesHiv = entity;

		if (reverseAdd) {
			this.formulirKonselingTesHiv.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setFormulirKonselingTesHiv outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setFormulirKonselingTesHiv outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetFormulirKonselingTesHiv(boolean)} but default to true.
	 */
	public void unsetFormulirKonselingTesHiv() {
		this.unsetFormulirKonselingTesHiv(true);
	}

	/**
	 * Remove the FormulirKonselingTesHivEntity in Formulir Konseling Tes Hiv from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetFormulirKonselingTesHiv(boolean reverse) {
		if (reverse && this.formulirKonselingTesHiv != null) {
			this.formulirKonselingTesHiv.unsetMedicalExaminationRecord(false);
		}
		this.formulirKonselingTesHiv = null;
	}

	/**
	 * Similar to {@link this#setHemodialysisExamination(HemodialysisExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setHemodialysisExamination(@NotNull HemodialysisExaminationEntity entity) {
		setHemodialysisExamination(entity, true);
	}

	/**
	 * Set or update hemodialysisExamination with the given HemodialysisExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHemodialysisExamination(@NotNull HemodialysisExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] end

		if (sameAsFormer(this.hemodialysisExamination, entity)) {
			return;
		}

		if (this.hemodialysisExamination != null) {
			this.hemodialysisExamination.unsetMedicalExaminationRecord();
		}

		this.hemodialysisExamination = entity;

		if (reverseAdd) {
			this.hemodialysisExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetHemodialysisExamination(boolean)} but default to true.
	 */
	public void unsetHemodialysisExamination() {
		this.unsetHemodialysisExamination(true);
	}

	/**
	 * Remove the HemodialysisExaminationEntity in Hemodialysis Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHemodialysisExamination(boolean reverse) {
		if (reverse && this.hemodialysisExamination != null) {
			this.hemodialysisExamination.unsetMedicalExaminationRecord(false);
		}
		this.hemodialysisExamination = null;
	}

	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummary(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		setMedicalExaminationRecordDischargeSummary(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecordDischargeSummary with the given MedicalExaminationRecordDischargeSummaryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NotNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] end

		if (sameAsFormer(this.medicalExaminationRecordDischargeSummary, entity)) {
			return;
		}

		if (this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.unsetMedicalExaminationRecord();
		}

		this.medicalExaminationRecordDischargeSummary = entity;

		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummary.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummary(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecordDischargeSummary() {
		this.unsetMedicalExaminationRecordDischargeSummary(true);
	}

	/**
	 * Remove the MedicalExaminationRecordDischargeSummaryEntity in Medical Examination Record Discharge Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecordDischargeSummary(boolean reverse) {
		if (reverse && this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.unsetMedicalExaminationRecord(false);
		}
		this.medicalExaminationRecordDischargeSummary = null;
	}

	/**
	 * Similar to {@link this#setMedicalRecordInitialChecklist(MedicalRecordInitialChecklistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordInitialChecklist(@NotNull MedicalRecordInitialChecklistEntity entity) {
		setMedicalRecordInitialChecklist(entity, true);
	}

	/**
	 * Set or update medicalRecordInitialChecklist with the given MedicalRecordInitialChecklistEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordInitialChecklist(@NotNull MedicalRecordInitialChecklistEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordInitialChecklist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordInitialChecklist here] end

		if (sameAsFormer(this.medicalRecordInitialChecklist, entity)) {
			return;
		}

		if (this.medicalRecordInitialChecklist != null) {
			this.medicalRecordInitialChecklist.unsetMedicalExaminationRecord();
		}

		this.medicalRecordInitialChecklist = entity;

		if (reverseAdd) {
			this.medicalRecordInitialChecklist.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordInitialChecklist outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordInitialChecklist outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordInitialChecklist(boolean)} but default to true.
	 */
	public void unsetMedicalRecordInitialChecklist() {
		this.unsetMedicalRecordInitialChecklist(true);
	}

	/**
	 * Remove the MedicalRecordInitialChecklistEntity in Medical Record Initial Checklist from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordInitialChecklist(boolean reverse) {
		if (reverse && this.medicalRecordInitialChecklist != null) {
			this.medicalRecordInitialChecklist.unsetMedicalExaminationRecord(false);
		}
		this.medicalRecordInitialChecklist = null;
	}

	/**
	 * Similar to {@link this#setMedicalRecordNextVerificationChecklist(MedicalRecordNextVerificationChecklistEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalRecordNextVerificationChecklist(@NotNull MedicalRecordNextVerificationChecklistEntity entity) {
		setMedicalRecordNextVerificationChecklist(entity, true);
	}

	/**
	 * Set or update medicalRecordNextVerificationChecklist with the given MedicalRecordNextVerificationChecklistEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalRecordNextVerificationChecklist(@NotNull MedicalRecordNextVerificationChecklistEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordNextVerificationChecklist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalRecordNextVerificationChecklist here] end

		if (sameAsFormer(this.medicalRecordNextVerificationChecklist, entity)) {
			return;
		}

		if (this.medicalRecordNextVerificationChecklist != null) {
			this.medicalRecordNextVerificationChecklist.unsetMedicalExaminationRecord();
		}

		this.medicalRecordNextVerificationChecklist = entity;

		if (reverseAdd) {
			this.medicalRecordNextVerificationChecklist.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordNextVerificationChecklist outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalRecordNextVerificationChecklist outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalRecordNextVerificationChecklist(boolean)} but default to true.
	 */
	public void unsetMedicalRecordNextVerificationChecklist() {
		this.unsetMedicalRecordNextVerificationChecklist(true);
	}

	/**
	 * Remove the MedicalRecordNextVerificationChecklistEntity in Medical Record Next Verification Checklist from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalRecordNextVerificationChecklist(boolean reverse) {
		if (reverse && this.medicalRecordNextVerificationChecklist != null) {
			this.medicalRecordNextVerificationChecklist.unsetMedicalExaminationRecord(false);
		}
		this.medicalRecordNextVerificationChecklist = null;
	}

	/**
	 * Similar to {@link this#setNurseVitalSignMeasurement(NurseVitalSignMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setNurseVitalSignMeasurement(@NotNull NurseVitalSignMeasurementEntity entity) {
		setNurseVitalSignMeasurement(entity, true);
	}

	/**
	 * Set or update nurseVitalSignMeasurement with the given NurseVitalSignMeasurementEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurseVitalSignMeasurement(@NotNull NurseVitalSignMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurseVitalSignMeasurement here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurseVitalSignMeasurement here] end

		if (sameAsFormer(this.nurseVitalSignMeasurement, entity)) {
			return;
		}

		if (this.nurseVitalSignMeasurement != null) {
			this.nurseVitalSignMeasurement.unsetMedicalExaminationRecord();
		}

		this.nurseVitalSignMeasurement = entity;

		if (reverseAdd) {
			this.nurseVitalSignMeasurement.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurseVitalSignMeasurement outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurseVitalSignMeasurement outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetNurseVitalSignMeasurement(boolean)} but default to true.
	 */
	public void unsetNurseVitalSignMeasurement() {
		this.unsetNurseVitalSignMeasurement(true);
	}

	/**
	 * Remove the NurseVitalSignMeasurementEntity in Nurse Vital Sign Measurement from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurseVitalSignMeasurement(boolean reverse) {
		if (reverse && this.nurseVitalSignMeasurement != null) {
			this.nurseVitalSignMeasurement.unsetMedicalExaminationRecord(false);
		}
		this.nurseVitalSignMeasurement = null;
	}

	/**
	 * Similar to {@link this#setObstetricAndGynecologyHistory(ObstetricAndGynecologyHistoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setObstetricAndGynecologyHistory(@NotNull ObstetricAndGynecologyHistoryEntity entity) {
		setObstetricAndGynecologyHistory(entity, true);
	}

	/**
	 * Set or update obstetricAndGynecologyHistory with the given ObstetricAndGynecologyHistoryEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setObstetricAndGynecologyHistory(@NotNull ObstetricAndGynecologyHistoryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setObstetricAndGynecologyHistory here] off begin
		// % protected region % [Add any additional logic here before the main logic for setObstetricAndGynecologyHistory here] end

		if (sameAsFormer(this.obstetricAndGynecologyHistory, entity)) {
			return;
		}

		if (this.obstetricAndGynecologyHistory != null) {
			this.obstetricAndGynecologyHistory.unsetMedicalExaminationRecord();
		}

		this.obstetricAndGynecologyHistory = entity;

		if (reverseAdd) {
			this.obstetricAndGynecologyHistory.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setObstetricAndGynecologyHistory outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setObstetricAndGynecologyHistory outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetObstetricAndGynecologyHistory(boolean)} but default to true.
	 */
	public void unsetObstetricAndGynecologyHistory() {
		this.unsetObstetricAndGynecologyHistory(true);
	}

	/**
	 * Remove the ObstetricAndGynecologyHistoryEntity in Obstetric And Gynecology History from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetObstetricAndGynecologyHistory(boolean reverse) {
		if (reverse && this.obstetricAndGynecologyHistory != null) {
			this.obstetricAndGynecologyHistory.unsetMedicalExaminationRecord(false);
		}
		this.obstetricAndGynecologyHistory = null;
	}

	/**
	 * Similar to {@link this#setOdontogramExamination(OdontogramExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOdontogramExamination(@NotNull OdontogramExaminationEntity entity) {
		setOdontogramExamination(entity, true);
	}

	/**
	 * Set or update odontogramExamination with the given OdontogramExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOdontogramExamination(@NotNull OdontogramExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOdontogramExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOdontogramExamination here] end

		if (sameAsFormer(this.odontogramExamination, entity)) {
			return;
		}

		if (this.odontogramExamination != null) {
			this.odontogramExamination.unsetMedicalExaminationRecord();
		}

		this.odontogramExamination = entity;

		if (reverseAdd) {
			this.odontogramExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOdontogramExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOdontogramExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOdontogramExamination(boolean)} but default to true.
	 */
	public void unsetOdontogramExamination() {
		this.unsetOdontogramExamination(true);
	}

	/**
	 * Remove the OdontogramExaminationEntity in Odontogram Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOdontogramExamination(boolean reverse) {
		if (reverse && this.odontogramExamination != null) {
			this.odontogramExamination.unsetMedicalExaminationRecord(false);
		}
		this.odontogramExamination = null;
	}

	/**
	 * Similar to {@link this#setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity) {
		setOperatingTheaterMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update operatingTheaterMedicalExaminationRecord with the given OperatingTheaterMedicalExaminationRecordEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(@NotNull OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] end

		if (sameAsFormer(this.operatingTheaterMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}

		this.operatingTheaterMedicalExaminationRecord = entity;

		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingTheaterMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord() {
		this.unsetOperatingTheaterMedicalExaminationRecord(true);
	}

	/**
	 * Remove the OperatingTheaterMedicalExaminationRecordEntity in Operating Theater Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}

	/**
	 * Similar to {@link this#setOphthalmologyExamination(OphthalmologyExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOphthalmologyExamination(@NotNull OphthalmologyExaminationEntity entity) {
		setOphthalmologyExamination(entity, true);
	}

	/**
	 * Set or update ophthalmologyExamination with the given OphthalmologyExaminationEntity.
	 *
	 * @param entity the MedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOphthalmologyExamination(@NotNull OphthalmologyExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOphthalmologyExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOphthalmologyExamination here] end

		if (sameAsFormer(this.ophthalmologyExamination, entity)) {
			return;
		}

		if (this.ophthalmologyExamination != null) {
			this.ophthalmologyExamination.unsetMedicalExaminationRecord();
		}

		this.ophthalmologyExamination = entity;

		if (reverseAdd) {
			this.ophthalmologyExamination.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOphthalmologyExamination outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOphthalmologyExamination outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOphthalmologyExamination(boolean)} but default to true.
	 */
	public void unsetOphthalmologyExamination() {
		this.unsetOphthalmologyExamination(true);
	}

	/**
	 * Remove the OphthalmologyExaminationEntity in Ophthalmology Examination from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOphthalmologyExamination(boolean reverse) {
		if (reverse && this.ophthalmologyExamination != null) {
			this.ophthalmologyExamination.unsetMedicalExaminationRecord(false);
		}
		this.ophthalmologyExamination = null;
	}

/**
	 * Similar to {@link this#addRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NotNull RoomTransferEntity entity) {
		addRoomTransfers(entity, true);
	}

	/**
	 * Add a new RoomTransferEntity to roomTransfers in this entity.
	 *
	 * @param entity the given RoomTransferEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRoomTransfers(@NonNull RoomTransferEntity entity, boolean reverseAdd) {
		if (!this.roomTransfers.contains(entity)) {
			roomTransfers.add(entity);
			if (reverseAdd) {
				entity.setMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 */
	public void addRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		addRoomTransfers(entities, true);
	}

	/**
	 * Add a new collection of RoomTransferEntity to Room Transfers in this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(RoomTransferEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomTransferEntity to be set to this entity
	 */
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity) {
		this.removeRoomTransfers(entity, true);
	}

	/**
	 * Remove the given RoomTransferEntity from this entity.
	 *
	 * @param entity the given RoomTransferEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRoomTransfers(@NotNull RoomTransferEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalExaminationRecord(false);
		}
		this.roomTransfers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRoomTransfers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 */
	public void removeRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		this.removeRoomTransfers(entities, true);
	}

	/**
	 * Remove the given collection of RoomTransferEntity from  to this entity.
	 *
	 * @param entities the given collection of RoomTransferEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRoomTransfers(@NonNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRoomTransfers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRoomTransfers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RoomTransferEntity to be set to this entity
	 */
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities) {
		setRoomTransfers(entities, true);
	}

	/**
	 * Replace the current entities in Room Transfers with the given ones.
	 *
	 * @param entities the given collection of RoomTransferEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRoomTransfers(@NotNull Collection<RoomTransferEntity> entities, boolean reverseAdd) {

		this.unsetRoomTransfers();
		this.roomTransfers = new HashSet<>(entities);
		if (reverseAdd) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.setMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRoomTransfers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRoomTransfers() {
		this.unsetRoomTransfers(true);
	}

	/**
	 * Remove all the entities in Room Transfers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRoomTransfers(boolean doReverse) {
		if (doReverse) {
			this.roomTransfers.forEach(roomTransfersEntity -> roomTransfersEntity.unsetMedicalExaminationRecord(false));
		}
		this.roomTransfers.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDoctor(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDoctor(@NotNull StaffEntity entity) {
		setDoctor(entity, true);
	}

	/**
	 * Set or update the doctor in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to doctor
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctor(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctor here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctor here] end

		if (sameAsFormer(this.doctor, entity)) {
			return;
		}

		if (this.doctor != null) {
			this.doctor.removeDoctorOnExamination(this, false);
		}
		this.doctor = entity;
		if (reverseAdd) {
			this.doctor.addDoctorOnExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctor incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctor incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDoctor(boolean)} but default to true.
	 */
	public void unsetDoctor() {
		this.unsetDoctor(true);
	}

	/**
	 * Remove Doctor in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctor(boolean reverse) {
		if (reverse && this.doctor != null) {
			this.doctor.removeDoctorOnExamination(this, false);
		}
		this.doctor = null;
	}
	/**
	 * Similar to {@link this#setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity entity) {
		setInpatientMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the inpatientMedicalExaminationRecord in this entity with single InpatientMedicalExaminationRecordEntity.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set or updated to inpatientMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInpatientMedicalExaminationRecord(InpatientMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInpatientMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInpatientMedicalExaminationRecord here] end

		if (sameAsFormer(this.inpatientMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.inpatientMedicalExaminationRecord != null) {
			this.inpatientMedicalExaminationRecord.unsetMedicalExaminationRecord(false);
		}

		this.inpatientMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.inpatientMedicalExaminationRecord.setMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInpatientMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInpatientMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInpatientMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetInpatientMedicalExaminationRecord() {
		this.unsetInpatientMedicalExaminationRecord(true);
	}

	/**
	 * Remove the InpatientMedicalExaminationRecordEntity of inpatientMedicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInpatientMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.inpatientMedicalExaminationRecord != null) {
			this.inpatientMedicalExaminationRecord.unsetMedicalExaminationRecord();
		}
		this.inpatientMedicalExaminationRecord = null;
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
			this.registration.unsetMedicalExaminationRecord(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setMedicalExaminationRecord(this, false);
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
			this.registration.unsetMedicalExaminationRecord();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalTranscriber(@NotNull StaffEntity entity) {
		setMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the medicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriber(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] end

		if (sameAsFormer(this.medicalTranscriber, entity)) {
			return;
		}

		if (this.medicalTranscriber != null) {
			this.medicalTranscriber.removeMedicalRecordTranscriber(this, false);
		}
		this.medicalTranscriber = entity;
		if (reverseAdd) {
			this.medicalTranscriber.addMedicalRecordTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriber() {
		this.unsetMedicalTranscriber(true);
	}

	/**
	 * Remove Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriber(boolean reverse) {
		if (reverse && this.medicalTranscriber != null) {
			this.medicalTranscriber.removeMedicalRecordTranscriber(this, false);
		}
		this.medicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNurse(@NotNull StaffEntity entity) {
		setNurse(entity, true);
	}

	/**
	 * Set or update the nurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNurse(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNurse here] end

		if (sameAsFormer(this.nurse, entity)) {
			return;
		}

		if (this.nurse != null) {
			this.nurse.removeNurse(this, false);
		}
		this.nurse = entity;
		if (reverseAdd) {
			this.nurse.addNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNurse(boolean)} but default to true.
	 */
	public void unsetNurse() {
		this.unsetNurse(true);
	}

	/**
	 * Remove Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNurse(boolean reverse) {
		if (reverse && this.nurse != null) {
			this.nurse.removeNurse(this, false);
		}
		this.nurse = null;
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
		return "DIASTOLE,SYSTOLE,PULSE,BP_STANDING_SYSTOLE,BP_STANDING_DIASTOLE,PULSE_REGULARITY,PULSE_STRENGTH,TEMPERATURE,TEMPERATURE_SCALE,GCS_EYES,GCS_VERBAL,GCS_MOTOR,TOTAL_GCS_SCORE,CONSCIOUSNESS,HEIGHT,HEIGHT_SCALE,WEIGHT,WEIGHT_SCALE,BMI,RESPIRATORY,OXYGEN_SATURATION,WAIST_CIRCUMFERENCE,WAIST_CIRCUMFERENCE_UNIT,NUTRITION_STATUS,PAIN_SCALE,PAIN_SCALE_USED,RISK_FALL_SCALE,OBJECTIVE,RISK_FALL_SCALE_USED,SUBJECTIVE,PLAN,PURPOSE,EXAMINATION_SUB_CASE,ACCIDENTAL_TYPE,SERVICE_CASE,ACCIDENTAL_SUB_TYPE,ADDITIONAL_NOTES,DENTAL_PROCEDURE,PSYCHIATRY_CASE,THERAPY,FAMILY_PLANNING,CONDITION,FAMILY_PLANNING_CASE,PREVIOUS_CONTRACEPTIVE_METHOD,SIDE_EFFECTS,COMPLICATION,CONTRASEPTIVE_METHOD,VISIT_TYPE,HEARING_TEST_METHOD,HEARING_TEST_NOTES,HEARING_LOSS_CATEGORY,HEARING_LOSS_NOTES,EYE_POSITION_RIGHT_EYE,EYE_POSITION_LEFT_EYE,MUSCLE_BALANCE_RIGHT_EYE,MUSCLE_BALANCE_LEFT_EYE,VISUAL_FIELD_RIGHT_EYE,VISUAL_FIELD_LEFT_EYE,OCULAR_FUNDUSCOPY_RIGHT_EYE,OCULAR_FUNDUSCOPY_LEFT_EYE,INTRAOCULAR_PRESSURE_RIGHT_EYE,INTRAOCULAR_PRESSURE_LEFT_EYE,COLOR_BLINDNESS,VISUAL_ACUITY_RIGHT_EYE,VISUAL_ACUITY_LEFT_EYE,CORRECTION_RIGHT_EYE,CORRECTION_LEFT_EYE,ADDITION_RIGHT_EYE,ADDITION_LEFT_EYE,OCCLUSION,TORUS_PALATINUS,TORUS_MANDIBULARIS,PALATUM,DIASTEMA,DIASTEMA_NOTES,TOOTH_ANOMALY,TOOTH_ANOMALY_NOTES,OTHER_DENTAL_NOTES,DECAYED,MISSING,FILLED,TOTAL_PHOTOGRAPH,PHOTOGRAPH_TYPE,TOTAL_RONTGEN_PHOTOGRAPH,RONTGEN_PHOTOGRAPH_TYPE,DOCTOR_ID,INPATIENT_MEDICAL_EXAMINATION_RECORD_ID,REGISTRATION_ID,MEDICAL_TRANSCRIBER_ID,NURSE_ID,AMENDMENT_DETAILS_IDS,BIRTH_HISTORY_ID,BODY_CHART_EXAMINATION_ID,CO_TREATING_DOCTORS_IDS,DAILY_CARE_CPPTS_IDS,DELIVERY_MEDICAL_EXAMINATION_RECORD_ID,DIAGNOSIS_EXAMINATION_RECORDS_IDS,DIAGNOSIS_NANDAS_IDS,ENT_EXAMINATION_ID,EMERGENCY_MEDICATION_EXAMINATION_RECORD_ID,FORMULIR_KONSELING_TES_HIV_ID,HEMODIALYSIS_EXAMINATION_ID,MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ID,MEDICAL_RECORD_INITIAL_CHECKLIST_ID,MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ID,NURSE_VITAL_SIGN_MEASUREMENT_ID,OBSTETRIC_AND_GYNECOLOGY_HISTORY_ID,ODONTOGRAM_EXAMINATION_ID,OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ID,OPHTHALMOLOGY_EXAMINATION_ID,ROOM_TRANSFERS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StaffEntity> doctorRelation = Optional.ofNullable(this.doctor);
		doctorRelation.ifPresent(entity -> this.doctorId = entity.getId());

		Optional<InpatientMedicalExaminationRecordEntity> inpatientMedicalExaminationRecordRelation = Optional.ofNullable(this.inpatientMedicalExaminationRecord);
		inpatientMedicalExaminationRecordRelation.ifPresent(entity -> this.inpatientMedicalExaminationRecordId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<StaffEntity> medicalTranscriberRelation = Optional.ofNullable(this.medicalTranscriber);
		medicalTranscriberRelation.ifPresent(entity -> this.medicalTranscriberId = entity.getId());

		Optional<StaffEntity> nurseRelation = Optional.ofNullable(this.nurse);
		nurseRelation.ifPresent(entity -> this.nurseId = entity.getId());

		this.amendmentDetailsIds = new HashSet<>();
		for (AmendmentDetailEntity amendmentDetails: this.amendmentDetails) {
			this.amendmentDetailsIds.add(amendmentDetails.getId());
		}

		Optional<BirthHistoryEntity> birthHistoryRelation = Optional.ofNullable(this.birthHistory);
		birthHistoryRelation.ifPresent(entity -> this.birthHistoryId = entity.getId());

		Optional<BodyChartExaminationEntity> bodyChartExaminationRelation = Optional.ofNullable(this.bodyChartExamination);
		bodyChartExaminationRelation.ifPresent(entity -> this.bodyChartExaminationId = entity.getId());

		this.coTreatingDoctorsIds = new HashSet<>();
		for (CoTreatingDoctorEntity coTreatingDoctors: this.coTreatingDoctors) {
			this.coTreatingDoctorsIds.add(coTreatingDoctors.getId());
		}

		this.dailyCareCPPTsIds = new HashSet<>();
		for (DailyCareCPPTEntity dailyCareCPPTs: this.dailyCareCPPTs) {
			this.dailyCareCPPTsIds.add(dailyCareCPPTs.getId());
		}

		Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordRelation = Optional.ofNullable(this.deliveryMedicalExaminationRecord);
		deliveryMedicalExaminationRecordRelation.ifPresent(entity -> this.deliveryMedicalExaminationRecordId = entity.getId());

		this.diagnosisExaminationRecordsIds = new HashSet<>();
		for (DiagnosisExaminationRecordEntity diagnosisExaminationRecords: this.diagnosisExaminationRecords) {
			this.diagnosisExaminationRecordsIds.add(diagnosisExaminationRecords.getId());
		}

		this.diagnosisNandasIds = new HashSet<>();
		for (DiagnosisNandaEntity diagnosisNandas: this.diagnosisNandas) {
			this.diagnosisNandasIds.add(diagnosisNandas.getId());
		}

		Optional<EntExaminationEntity> entExaminationRelation = Optional.ofNullable(this.entExamination);
		entExaminationRelation.ifPresent(entity -> this.entExaminationId = entity.getId());

		Optional<EmergencyMedicalExaminationRecordEntity> emergencyMedicationExaminationRecordRelation = Optional.ofNullable(this.emergencyMedicationExaminationRecord);
		emergencyMedicationExaminationRecordRelation.ifPresent(entity -> this.emergencyMedicationExaminationRecordId = entity.getId());

		Optional<FormulirKonselingTesHivEntity> formulirKonselingTesHivRelation = Optional.ofNullable(this.formulirKonselingTesHiv);
		formulirKonselingTesHivRelation.ifPresent(entity -> this.formulirKonselingTesHivId = entity.getId());

		Optional<HemodialysisExaminationEntity> hemodialysisExaminationRelation = Optional.ofNullable(this.hemodialysisExamination);
		hemodialysisExaminationRelation.ifPresent(entity -> this.hemodialysisExaminationId = entity.getId());

		Optional<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummaryRelation = Optional.ofNullable(this.medicalExaminationRecordDischargeSummary);
		medicalExaminationRecordDischargeSummaryRelation.ifPresent(entity -> this.medicalExaminationRecordDischargeSummaryId = entity.getId());

		Optional<MedicalRecordInitialChecklistEntity> medicalRecordInitialChecklistRelation = Optional.ofNullable(this.medicalRecordInitialChecklist);
		medicalRecordInitialChecklistRelation.ifPresent(entity -> this.medicalRecordInitialChecklistId = entity.getId());

		Optional<MedicalRecordNextVerificationChecklistEntity> medicalRecordNextVerificationChecklistRelation = Optional.ofNullable(this.medicalRecordNextVerificationChecklist);
		medicalRecordNextVerificationChecklistRelation.ifPresent(entity -> this.medicalRecordNextVerificationChecklistId = entity.getId());

		Optional<NurseVitalSignMeasurementEntity> nurseVitalSignMeasurementRelation = Optional.ofNullable(this.nurseVitalSignMeasurement);
		nurseVitalSignMeasurementRelation.ifPresent(entity -> this.nurseVitalSignMeasurementId = entity.getId());

		Optional<ObstetricAndGynecologyHistoryEntity> obstetricAndGynecologyHistoryRelation = Optional.ofNullable(this.obstetricAndGynecologyHistory);
		obstetricAndGynecologyHistoryRelation.ifPresent(entity -> this.obstetricAndGynecologyHistoryId = entity.getId());

		Optional<OdontogramExaminationEntity> odontogramExaminationRelation = Optional.ofNullable(this.odontogramExamination);
		odontogramExaminationRelation.ifPresent(entity -> this.odontogramExaminationId = entity.getId());

		Optional<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordRelation = Optional.ofNullable(this.operatingTheaterMedicalExaminationRecord);
		operatingTheaterMedicalExaminationRecordRelation.ifPresent(entity -> this.operatingTheaterMedicalExaminationRecordId = entity.getId());

		Optional<OphthalmologyExaminationEntity> ophthalmologyExaminationRelation = Optional.ofNullable(this.ophthalmologyExamination);
		ophthalmologyExaminationRelation.ifPresent(entity -> this.ophthalmologyExaminationId = entity.getId());

		this.roomTransfersIds = new HashSet<>();
		for (RoomTransferEntity roomTransfers: this.roomTransfers) {
			this.roomTransfersIds.add(roomTransfers.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalExaminationRecord) {
		if (this == medicalExaminationRecord) {
			return true;
		}
		if (medicalExaminationRecord == null || this.getClass() != medicalExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(medicalExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalExaminationRecordEntity that = (MedicalExaminationRecordEntity) medicalExaminationRecord;
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
			Objects.equals(this.dentalProcedure, that.dentalProcedure) &&
			Objects.equals(this.psychiatryCase, that.psychiatryCase) &&
			Objects.equals(this.therapy, that.therapy) &&
			Objects.equals(this.familyPlanning, that.familyPlanning) &&
			Objects.equals(this.condition, that.condition) &&
			Objects.equals(this.familyPlanningCase, that.familyPlanningCase) &&
			Objects.equals(this.previousContraceptiveMethod, that.previousContraceptiveMethod) &&
			Objects.equals(this.sideEffects, that.sideEffects) &&
			Objects.equals(this.complication, that.complication) &&
			Objects.equals(this.contraseptiveMethod, that.contraseptiveMethod) &&
			Objects.equals(this.visitType, that.visitType) &&
			Objects.equals(this.hearingTestMethod, that.hearingTestMethod) &&
			Objects.equals(this.hearingTestNotes, that.hearingTestNotes) &&
			Objects.equals(this.hearingLossCategory, that.hearingLossCategory) &&
			Objects.equals(this.hearingLossNotes, that.hearingLossNotes) &&
			Objects.equals(this.eyePositionRightEye, that.eyePositionRightEye) &&
			Objects.equals(this.eyePositionLeftEye, that.eyePositionLeftEye) &&
			Objects.equals(this.muscleBalanceRightEye, that.muscleBalanceRightEye) &&
			Objects.equals(this.muscleBalanceLeftEye, that.muscleBalanceLeftEye) &&
			Objects.equals(this.visualFieldRightEye, that.visualFieldRightEye) &&
			Objects.equals(this.visualFieldLeftEye, that.visualFieldLeftEye) &&
			Objects.equals(this.ocularFunduscopyRightEye, that.ocularFunduscopyRightEye) &&
			Objects.equals(this.ocularFunduscopyLeftEye, that.ocularFunduscopyLeftEye) &&
			Objects.equals(this.intraocularPressureRightEye, that.intraocularPressureRightEye) &&
			Objects.equals(this.intraocularPressureLeftEye, that.intraocularPressureLeftEye) &&
			Objects.equals(this.colorBlindness, that.colorBlindness) &&
			Objects.equals(this.visualAcuityRightEye, that.visualAcuityRightEye) &&
			Objects.equals(this.visualAcuityLeftEye, that.visualAcuityLeftEye) &&
			Objects.equals(this.correctionRightEye, that.correctionRightEye) &&
			Objects.equals(this.correctionLeftEye, that.correctionLeftEye) &&
			Objects.equals(this.additionRightEye, that.additionRightEye) &&
			Objects.equals(this.additionLeftEye, that.additionLeftEye) &&
			Objects.equals(this.occlusion, that.occlusion) &&
			Objects.equals(this.torusPalatinus, that.torusPalatinus) &&
			Objects.equals(this.torusMandibularis, that.torusMandibularis) &&
			Objects.equals(this.palatum, that.palatum) &&
			Objects.equals(this.diastema, that.diastema) &&
			Objects.equals(this.diastemaNotes, that.diastemaNotes) &&
			Objects.equals(this.toothAnomaly, that.toothAnomaly) &&
			Objects.equals(this.toothAnomalyNotes, that.toothAnomalyNotes) &&
			Objects.equals(this.otherDentalNotes, that.otherDentalNotes) &&
			Objects.equals(this.decayed, that.decayed) &&
			Objects.equals(this.missing, that.missing) &&
			Objects.equals(this.filled, that.filled) &&
			Objects.equals(this.totalPhotograph, that.totalPhotograph) &&
			Objects.equals(this.photographType, that.photographType) &&
			Objects.equals(this.totalRontgenPhotograph, that.totalRontgenPhotograph) &&
			Objects.equals(this.rontgenPhotographType, that.rontgenPhotographType) &&
			Objects.equals(this.amendmentDetailsIds, that.amendmentDetailsIds) &&
			Objects.equals(this.birthHistoryId, that.birthHistoryId) &&
			Objects.equals(this.bodyChartExaminationId, that.bodyChartExaminationId) &&
			Objects.equals(this.coTreatingDoctorsIds, that.coTreatingDoctorsIds) &&
			Objects.equals(this.dailyCareCPPTsIds, that.dailyCareCPPTsIds) &&
			Objects.equals(this.deliveryMedicalExaminationRecordId, that.deliveryMedicalExaminationRecordId) &&
			Objects.equals(this.diagnosisExaminationRecordsIds, that.diagnosisExaminationRecordsIds) &&
			Objects.equals(this.diagnosisNandasIds, that.diagnosisNandasIds) &&
			Objects.equals(this.entExaminationId, that.entExaminationId) &&
			Objects.equals(this.emergencyMedicationExaminationRecordId, that.emergencyMedicationExaminationRecordId) &&
			Objects.equals(this.formulirKonselingTesHivId, that.formulirKonselingTesHivId) &&
			Objects.equals(this.hemodialysisExaminationId, that.hemodialysisExaminationId) &&
			Objects.equals(this.medicalExaminationRecordDischargeSummaryId, that.medicalExaminationRecordDischargeSummaryId) &&
			Objects.equals(this.medicalRecordInitialChecklistId, that.medicalRecordInitialChecklistId) &&
			Objects.equals(this.medicalRecordNextVerificationChecklistId, that.medicalRecordNextVerificationChecklistId) &&
			Objects.equals(this.nurseVitalSignMeasurementId, that.nurseVitalSignMeasurementId) &&
			Objects.equals(this.obstetricAndGynecologyHistoryId, that.obstetricAndGynecologyHistoryId) &&
			Objects.equals(this.odontogramExaminationId, that.odontogramExaminationId) &&
			Objects.equals(this.operatingTheaterMedicalExaminationRecordId, that.operatingTheaterMedicalExaminationRecordId) &&
			Objects.equals(this.ophthalmologyExaminationId, that.ophthalmologyExaminationId) &&
			Objects.equals(this.roomTransfersIds, that.roomTransfersIds) &&
			Objects.equals(this.doctorId, that.doctorId) &&
			Objects.equals(this.inpatientMedicalExaminationRecordId, that.inpatientMedicalExaminationRecordId) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.medicalTranscriberId, that.medicalTranscriberId) &&
			Objects.equals(this.nurseId, that.nurseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
