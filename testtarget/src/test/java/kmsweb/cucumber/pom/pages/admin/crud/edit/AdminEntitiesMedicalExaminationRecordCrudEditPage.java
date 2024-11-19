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
package kmsweb.cucumber.pom.pages.admin.crud.edit;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.MedicalExaminationRecordEntity;

import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Medical Examination RecordPage is a Page POM that is associated with the admin/entities/medical-examination-record url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicalExaminationRecordCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	// TODO default handling dataAttribute systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	// TODO default handling dataAttribute pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulse-field']")
	private WebElement pulseField;
	// TODO default handling dataAttribute bpStandingSystoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpStandingSystole-field']")
	private WebElement bpStandingSystoleField;
	// TODO default handling dataAttribute bpStandingDiastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpStandingDiastole-field']")
	private WebElement bpStandingDiastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseRegularity-field']")
	private WebElement pulseRegularityField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseStrength-field']")
	private WebElement pulseStrengthField;
	// TODO default handling dataAttribute temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperature-field']")
	private WebElement temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperatureScale-field']")
	private WebElement temperatureScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsEyes-field']")
	private WebElement gcsEyesField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsVerbal-field']")
	private WebElement gcsVerbalField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsMotor-field']")
	private WebElement gcsMotorField;
	// TODO default handling dataAttribute totalGCSScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalGCSScore-field']")
	private WebElement totalGCSScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='consciousness-field']")
	private WebElement consciousnessField;
	// TODO default handling dataAttribute heightField;
	@FindBy(how = How.XPATH, using = "//*[@id='height-field']")
	private WebElement heightField;
	@FindBy(how = How.XPATH, using = "//*[@id='heightScale-field']")
	private WebElement heightScaleField;
	// TODO default handling dataAttribute weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightScale-field']")
	private WebElement weightScaleField;
	// TODO default handling dataAttribute bmiField;
	@FindBy(how = How.XPATH, using = "//*[@id='bmi-field']")
	private WebElement bmiField;
	// TODO default handling dataAttribute respiratoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='respiratory-field']")
	private WebElement respiratoryField;
	// TODO default handling dataAttribute oxygenSaturationField;
	@FindBy(how = How.XPATH, using = "//*[@id='oxygenSaturation-field']")
	private WebElement oxygenSaturationField;
	// TODO default handling dataAttribute waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumference-field']")
	private WebElement waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumferenceUnit-field']")
	private WebElement waistCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='nutritionStatus-field']")
	private WebElement nutritionStatusField;
	// TODO default handling dataAttribute painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScale-field']")
	private WebElement painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScaleUsed-field']")
	private WebElement painScaleUsedField;
	// TODO default handling dataAttribute riskFallScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScale-field']")
	private WebElement riskFallScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='objective-field']")
	private WebElement objectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScaleUsed-field']")
	private WebElement riskFallScaleUsedField;
	@FindBy(how = How.XPATH, using = "//*[@id='subjective-field']")
	private WebElement subjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='plan-field']")
	private WebElement planField;
	@FindBy(how = How.XPATH, using = "//*[@id='purpose-field']")
	private WebElement purposeField;
	@FindBy(how = How.XPATH, using = "//*[@id='examinationSubCase-field']")
	private WebElement examinationSubCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='accidentalType-field']")
	private WebElement accidentalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='serviceCase-field']")
	private WebElement serviceCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='accidentalSubType-field']")
	private WebElement accidentalSubTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='additionalNotes-field']")
	private WebElement additionalNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='dentalProcedure-field']")
	private WebElement dentalProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='psychiatryCase-field']")
	private WebElement psychiatryCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='therapy-field']")
	private WebElement therapyField;
	@FindBy(how = How.XPATH, using = "//*[@id='familyPlanning-field']")
	private WebElement familyPlanningField;
	@FindBy(how = How.XPATH, using = "//*[@id='condition-field']")
	private WebElement conditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='familyPlanningCase-field']")
	private WebElement familyPlanningCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='previousContraceptiveMethod-field']")
	private WebElement previousContraceptiveMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='sideEffects-field']")
	private WebElement sideEffectsField;
	@FindBy(how = How.XPATH, using = "//*[@id='complication-field']")
	private WebElement complicationField;
	@FindBy(how = How.XPATH, using = "//*[@id='contraseptiveMethod-field']")
	private WebElement contraseptiveMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='visitType-field']")
	private WebElement visitTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='hearingTestMethod-field']")
	private WebElement hearingTestMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='hearingTestNotes-field']")
	private WebElement hearingTestNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='hearingLossCategory-field']")
	private WebElement hearingLossCategoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='hearingLossNotes-field']")
	private WebElement hearingLossNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='eyePositionRightEye-field']")
	private WebElement eyePositionRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='eyePositionLeftEye-field']")
	private WebElement eyePositionLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='muscleBalanceRightEye-field']")
	private WebElement muscleBalanceRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='muscleBalanceLeftEye-field']")
	private WebElement muscleBalanceLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='visualFieldRightEye-field']")
	private WebElement visualFieldRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='visualFieldLeftEye-field']")
	private WebElement visualFieldLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='ocularFunduscopyRightEye-field']")
	private WebElement ocularFunduscopyRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='ocularFunduscopyLeftEye-field']")
	private WebElement ocularFunduscopyLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='intraocularPressureRightEye-field']")
	private WebElement intraocularPressureRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='intraocularPressureLeftEye-field']")
	private WebElement intraocularPressureLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='colorBlindness-field']")
	private WebElement colorBlindnessField;
	@FindBy(how = How.XPATH, using = "//*[@id='visualAcuityRightEye-field']")
	private WebElement visualAcuityRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='visualAcuityLeftEye-field']")
	private WebElement visualAcuityLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='correctionRightEye-field']")
	private WebElement correctionRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='correctionLeftEye-field']")
	private WebElement correctionLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='additionRightEye-field']")
	private WebElement additionRightEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='additionLeftEye-field']")
	private WebElement additionLeftEyeField;
	@FindBy(how = How.XPATH, using = "//*[@id='occlusion-field']")
	private WebElement occlusionField;
	@FindBy(how = How.XPATH, using = "//*[@id='torusPalatinus-field']")
	private WebElement torusPalatinusField;
	@FindBy(how = How.XPATH, using = "//*[@id='torusMandibularis-field']")
	private WebElement torusMandibularisField;
	@FindBy(how = How.XPATH, using = "//*[@id='palatum-field']")
	private WebElement palatumField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastema-field']")
	private WebElement diastemaField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastemaNotes-field']")
	private WebElement diastemaNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='toothAnomaly-field']")
	private WebElement toothAnomalyField;
	@FindBy(how = How.XPATH, using = "//*[@id='toothAnomalyNotes-field']")
	private WebElement toothAnomalyNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherDentalNotes-field']")
	private WebElement otherDentalNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='decayed-field']")
	private WebElement decayedField;
	@FindBy(how = How.XPATH, using = "//*[@id='missing-field']")
	private WebElement missingField;
	@FindBy(how = How.XPATH, using = "//*[@id='filled-field']")
	private WebElement filledField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPhotograph-field']")
	private WebElement totalPhotographField;
	@FindBy(how = How.XPATH, using = "//*[@id='photographType-field']")
	private WebElement photographTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalRontgenPhotograph-field']")
	private WebElement totalRontgenPhotographField;
	@FindBy(how = How.XPATH, using = "//*[@id='rontgenPhotographType-field']")
	private WebElement rontgenPhotographTypeField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='birthHistory-field']")
	private WebElement birthHistoryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bodyChartExamination-field']")
	private WebElement bodyChartExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='deliveryMedicalExaminationRecord-field']")
	private WebElement deliveryMedicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='entExamination-field']")
	private WebElement entExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='emergencyMedicationExaminationRecord-field']")
	private WebElement emergencyMedicationExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='formulirKonselingTesHiv-field']")
	private WebElement formulirKonselingTesHivField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hemodialysisExamination-field']")
	private WebElement hemodialysisExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordDischargeSummary-field']")
	private WebElement medicalExaminationRecordDischargeSummaryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalRecordInitialChecklist-field']")
	private WebElement medicalRecordInitialChecklistField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalRecordNextVerificationChecklist-field']")
	private WebElement medicalRecordNextVerificationChecklistField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nurseVitalSignMeasurement-field']")
	private WebElement nurseVitalSignMeasurementField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='obstetricAndGynecologyHistory-field']")
	private WebElement obstetricAndGynecologyHistoryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='odontogramExamination-field']")
	private WebElement odontogramExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingTheaterMedicalExaminationRecord-field']")
	private WebElement operatingTheaterMedicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='ophthalmologyExamination-field']")
	private WebElement ophthalmologyExaminationField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inpatientMedicalExaminationRecordId-field']")
	private WebElement inpatientMedicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='amendmentDetailsIds-field']")
	private WebElement amendmentDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='coTreatingDoctorsIds-field']")
	private WebElement coTreatingDoctorsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dailyCareCPPTsIds-field']")
	private WebElement dailyCareCPPTsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosisExaminationRecordsIds-field']")
	private WebElement diagnosisExaminationRecordsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosisNandasIds-field']")
	private WebElement diagnosisNandasField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='roomTransfersIds-field']")
	private WebElement roomTransfersField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorId-field']")
	private WebElement doctorField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalTranscriberId-field']")
	private WebElement medicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nurseId-field']")
	private WebElement nurseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicalExaminationRecordCrudEditPage(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
			webDriver,
			properties,
			"admin/entities/medical-examination-record/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicalExaminationRecordEntity) abstractEntity;
		// TODO default handling for dataAttribute diastoleField
		diastoleField.sendKeys(entity.getDiastole().toString());

		// TODO default handling for dataAttribute systoleField
		systoleField.sendKeys(entity.getSystole().toString());

		// TODO default handling for dataAttribute pulseField
		pulseField.sendKeys(entity.getPulse().toString());

		// TODO default handling for dataAttribute bpStandingSystoleField
		bpStandingSystoleField.sendKeys(entity.getBpStandingSystole().toString());

		// TODO default handling for dataAttribute bpStandingDiastoleField
		bpStandingDiastoleField.sendKeys(entity.getBpStandingDiastole().toString());

		pulseRegularityField.sendKeys(entity.getPulseRegularity());
		pulseStrengthField.sendKeys(entity.getPulseStrength());
		// TODO default handling for dataAttribute temperatureField
		temperatureField.sendKeys(entity.getTemperature().toString());

		temperatureScaleField.sendKeys(entity.getTemperatureScale());
		gcsEyesField.sendKeys(entity.getGcsEyes());
		gcsVerbalField.sendKeys(entity.getGcsVerbal());
		gcsMotorField.sendKeys(entity.getGcsMotor());
		// TODO default handling for dataAttribute totalGCSScoreField
		totalGCSScoreField.sendKeys(entity.getTotalGCSScore().toString());

		consciousnessField.sendKeys(entity.getConsciousness());
		// TODO default handling for dataAttribute heightField
		heightField.sendKeys(entity.getHeight().toString());

		heightScaleField.sendKeys(entity.getHeightScale());
		// TODO default handling for dataAttribute weightField
		weightField.sendKeys(entity.getWeight().toString());

		weightScaleField.sendKeys(entity.getWeightScale());
		// TODO default handling for dataAttribute bmiField
		bmiField.sendKeys(entity.getBmi().toString());

		// TODO default handling for dataAttribute respiratoryField
		respiratoryField.sendKeys(entity.getRespiratory().toString());

		// TODO default handling for dataAttribute oxygenSaturationField
		oxygenSaturationField.sendKeys(entity.getOxygenSaturation().toString());

		// TODO default handling for dataAttribute waistCircumferenceField
		waistCircumferenceField.sendKeys(entity.getWaistCircumference().toString());

		waistCircumferenceUnitField.sendKeys(entity.getWaistCircumferenceUnit());
		nutritionStatusField.sendKeys(entity.getNutritionStatus());
		// TODO default handling for dataAttribute painScaleField
		painScaleField.sendKeys(entity.getPainScale().toString());

		painScaleUsedField.sendKeys(entity.getPainScaleUsed());
		// TODO default handling for dataAttribute riskFallScaleField
		riskFallScaleField.sendKeys(entity.getRiskFallScale().toString());

		objectiveField.sendKeys(entity.getObjective());
		riskFallScaleUsedField.sendKeys(entity.getRiskFallScaleUsed());
		subjectiveField.sendKeys(entity.getSubjective());
		planField.sendKeys(entity.getPlan());
		purposeField.sendKeys(entity.getPurpose());
		examinationSubCaseField.sendKeys(entity.getExaminationSubCase());
		accidentalTypeField.sendKeys(entity.getAccidentalType());
		serviceCaseField.sendKeys(entity.getServiceCase());
		accidentalSubTypeField.sendKeys(entity.getAccidentalSubType());
		additionalNotesField.sendKeys(entity.getAdditionalNotes());
		dentalProcedureField.sendKeys(entity.getDentalProcedure());
		psychiatryCaseField.sendKeys(entity.getPsychiatryCase());
		therapyField.sendKeys(entity.getTherapy());
		if (entity.getFamilyPlanning()) {
			familyPlanningField.click();
		}
		conditionField.sendKeys(entity.getCondition());
		familyPlanningCaseField.sendKeys(entity.getFamilyPlanningCase());
		previousContraceptiveMethodField.sendKeys(entity.getPreviousContraceptiveMethod());
		sideEffectsField.sendKeys(entity.getSideEffects());
		complicationField.sendKeys(entity.getComplication());
		contraseptiveMethodField.sendKeys(entity.getContraseptiveMethod());
		visitTypeField.sendKeys(entity.getVisitType());
		hearingTestMethodField.sendKeys(entity.getHearingTestMethod());
		hearingTestNotesField.sendKeys(entity.getHearingTestNotes());
		hearingLossCategoryField.sendKeys(entity.getHearingLossCategory());
		hearingLossNotesField.sendKeys(entity.getHearingLossNotes());
		eyePositionRightEyeField.sendKeys(entity.getEyePositionRightEye());
		eyePositionLeftEyeField.sendKeys(entity.getEyePositionLeftEye());
		muscleBalanceRightEyeField.sendKeys(entity.getMuscleBalanceRightEye());
		muscleBalanceLeftEyeField.sendKeys(entity.getMuscleBalanceLeftEye());
		visualFieldRightEyeField.sendKeys(entity.getVisualFieldRightEye());
		visualFieldLeftEyeField.sendKeys(entity.getVisualFieldLeftEye());
		ocularFunduscopyRightEyeField.sendKeys(entity.getOcularFunduscopyRightEye());
		ocularFunduscopyLeftEyeField.sendKeys(entity.getOcularFunduscopyLeftEye());
		intraocularPressureRightEyeField.sendKeys(entity.getIntraocularPressureRightEye());
		intraocularPressureLeftEyeField.sendKeys(entity.getIntraocularPressureLeftEye());
		colorBlindnessField.sendKeys(entity.getColorBlindness());
		visualAcuityRightEyeField.sendKeys(entity.getVisualAcuityRightEye());
		visualAcuityLeftEyeField.sendKeys(entity.getVisualAcuityLeftEye());
		correctionRightEyeField.sendKeys(entity.getCorrectionRightEye());
		correctionLeftEyeField.sendKeys(entity.getCorrectionLeftEye());
		additionRightEyeField.sendKeys(entity.getAdditionRightEye());
		additionLeftEyeField.sendKeys(entity.getAdditionLeftEye());
		occlusionField.sendKeys(entity.getOcclusion());
		torusPalatinusField.sendKeys(entity.getTorusPalatinus());
		torusMandibularisField.sendKeys(entity.getTorusMandibularis());
		palatumField.sendKeys(entity.getPalatum());
		if (entity.getDiastema()) {
			diastemaField.click();
		}
		diastemaNotesField.sendKeys(entity.getDiastemaNotes());
		if (entity.getToothAnomaly()) {
			toothAnomalyField.click();
		}
		toothAnomalyNotesField.sendKeys(entity.getToothAnomalyNotes());
		otherDentalNotesField.sendKeys(entity.getOtherDentalNotes());
		decayedField.sendKeys(entity.getDecayed());
		missingField.sendKeys(entity.getMissing());
		filledField.sendKeys(entity.getFilled());
		totalPhotographField.sendKeys(entity.getTotalPhotograph());
		photographTypeField.sendKeys(entity.getPhotographType());
		totalRontgenPhotographField.sendKeys(entity.getTotalRontgenPhotograph());
		rontgenPhotographTypeField.sendKeys(entity.getRontgenPhotographType());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}