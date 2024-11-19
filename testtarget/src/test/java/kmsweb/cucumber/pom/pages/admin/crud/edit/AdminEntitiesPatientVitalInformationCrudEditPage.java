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
import kmsweb.entities.PatientVitalInformationEntity;

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
 * Patient Vital InformationPage is a Page POM that is associated with the admin/entities/patient-vital-information url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientVitalInformationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute recordDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='recordDateTime-field']")
	private WebElement recordDateTimeField;
	// TODO default handling dataAttribute systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	// TODO default handling dataAttribute diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	// TODO default handling dataAttribute temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperature-field']")
	private WebElement temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperatureScale-field']")
	private WebElement temperatureScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='consciousness-field']")
	private WebElement consciousnessField;
	// TODO default handling dataAttribute pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulse-field']")
	private WebElement pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseRhythm-field']")
	private WebElement pulseRhythmField;
	@FindBy(how = How.XPATH, using = "//*[@id='strength-field']")
	private WebElement strengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsEyes-field']")
	private WebElement gcsEyesField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsVerbal-field']")
	private WebElement gcsVerbalField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsMotor-field']")
	private WebElement gcsMotorField;
	// TODO default handling dataAttribute totalGcsScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalGcsScore-field']")
	private WebElement totalGcsScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='respiratory-field']")
	private WebElement respiratoryField;
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
	// TODO default handling dataAttribute oxygenSaturationField;
	@FindBy(how = How.XPATH, using = "//*[@id='oxygenSaturation-field']")
	private WebElement oxygenSaturationField;
	@FindBy(how = How.XPATH, using = "//*[@id='nutritionStatus-field']")
	private WebElement nutritionStatusField;
	// TODO default handling dataAttribute waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumference-field']")
	private WebElement waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumferenceUnit-field']")
	private WebElement waistCircumferenceUnitField;
	// TODO default handling dataAttribute painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScale-field']")
	private WebElement painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScaleUsed-field']")
	private WebElement painScaleUsedField;
	// TODO default handling dataAttribute riskFallScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScale-field']")
	private WebElement riskFallScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScaleUsed-field']")
	private WebElement riskFallScaleUsedField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPatientVitalInformationCrudEditPage(
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
			"admin/entities/patient-vital-information/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientVitalInformationEntity) abstractEntity;
		// TODO default handling for dataAttribute recordDateTimeField
		recordDateTimeField.sendKeys(entity.getRecordDateTime().toString());

		// TODO default handling for dataAttribute systoleField
		systoleField.sendKeys(entity.getSystole().toString());

		// TODO default handling for dataAttribute diastoleField
		diastoleField.sendKeys(entity.getDiastole().toString());

		// TODO default handling for dataAttribute temperatureField
		temperatureField.sendKeys(entity.getTemperature().toString());

		temperatureScaleField.sendKeys(entity.getTemperatureScale());
		consciousnessField.sendKeys(entity.getConsciousness());
		// TODO default handling for dataAttribute pulseField
		pulseField.sendKeys(entity.getPulse().toString());

		pulseRhythmField.sendKeys(entity.getPulseRhythm());
		strengthField.sendKeys(entity.getStrength());
		gcsEyesField.sendKeys(entity.getGcsEyes());
		gcsVerbalField.sendKeys(entity.getGcsVerbal());
		gcsMotorField.sendKeys(entity.getGcsMotor());
		// TODO default handling for dataAttribute totalGcsScoreField
		totalGcsScoreField.sendKeys(entity.getTotalGcsScore().toString());

		respiratoryField.sendKeys(entity.getRespiratory());
		// TODO default handling for dataAttribute heightField
		heightField.sendKeys(entity.getHeight().toString());

		heightScaleField.sendKeys(entity.getHeightScale());
		// TODO default handling for dataAttribute weightField
		weightField.sendKeys(entity.getWeight().toString());

		weightScaleField.sendKeys(entity.getWeightScale());
		// TODO default handling for dataAttribute bmiField
		bmiField.sendKeys(entity.getBmi().toString());

		// TODO default handling for dataAttribute oxygenSaturationField
		oxygenSaturationField.sendKeys(entity.getOxygenSaturation().toString());

		nutritionStatusField.sendKeys(entity.getNutritionStatus());
		// TODO default handling for dataAttribute waistCircumferenceField
		waistCircumferenceField.sendKeys(entity.getWaistCircumference().toString());

		waistCircumferenceUnitField.sendKeys(entity.getWaistCircumferenceUnit());
		// TODO default handling for dataAttribute painScaleField
		painScaleField.sendKeys(entity.getPainScale().toString());

		painScaleUsedField.sendKeys(entity.getPainScaleUsed());
		// TODO default handling for dataAttribute riskFallScaleField
		riskFallScaleField.sendKeys(entity.getRiskFallScale().toString());

		riskFallScaleUsedField.sendKeys(entity.getRiskFallScaleUsed());
		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}