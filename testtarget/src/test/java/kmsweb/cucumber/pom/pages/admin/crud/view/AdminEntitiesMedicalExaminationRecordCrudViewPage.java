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
package kmsweb.cucumber.pom.pages.admin.crud.view;

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
public class AdminEntitiesMedicalExaminationRecordCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulse-field']")
	private WebElement pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpStandingSystole-field']")
	private WebElement bpStandingSystoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpStandingDiastole-field']")
	private WebElement bpStandingDiastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseRegularity-field']")
	private WebElement pulseRegularityField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseStrength-field']")
	private WebElement pulseStrengthField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='totalGCSScore-field']")
	private WebElement totalGCSScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='consciousness-field']")
	private WebElement consciousnessField;
	@FindBy(how = How.XPATH, using = "//*[@id='height-field']")
	private WebElement heightField;
	@FindBy(how = How.XPATH, using = "//*[@id='heightScale-field']")
	private WebElement heightScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightScale-field']")
	private WebElement weightScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='bmi-field']")
	private WebElement bmiField;
	@FindBy(how = How.XPATH, using = "//*[@id='respiratory-field']")
	private WebElement respiratoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='oxygenSaturation-field']")
	private WebElement oxygenSaturationField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumference-field']")
	private WebElement waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumferenceUnit-field']")
	private WebElement waistCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='nutritionStatus-field']")
	private WebElement nutritionStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScale-field']")
	private WebElement painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScaleUsed-field']")
	private WebElement painScaleUsedField;
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
	public AdminEntitiesMedicalExaminationRecordCrudViewPage(
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
			"admin/entities/medical-examination-record/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}