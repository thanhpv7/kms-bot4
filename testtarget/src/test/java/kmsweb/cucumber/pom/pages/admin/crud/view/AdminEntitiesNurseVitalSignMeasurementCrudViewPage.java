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
import kmsweb.entities.NurseVitalSignMeasurementEntity;

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
 * Nurse Vital Sign MeasurementPage is a Page POM that is associated with the admin/entities/nurse-vital-sign-measurement url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesNurseVitalSignMeasurementCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperature-field']")
	private WebElement temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperatureScale-field']")
	private WebElement temperatureScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='consciousness-field']")
	private WebElement consciousnessField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulse-field']")
	private WebElement pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseRegularity-field']")
	private WebElement pulseRegularityField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseStrength-field']")
	private WebElement pulseStrengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsEyes-field']")
	private WebElement gcsEyesField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsVerbal-field']")
	private WebElement gcsVerbalField;
	@FindBy(how = How.XPATH, using = "//*[@id='gcsMotor-field']")
	private WebElement gcsMotorField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalGCSScore-field']")
	private WebElement totalGCSScoreField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='nutritionStatus-field']")
	private WebElement nutritionStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumference-field']")
	private WebElement waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumferenceUnit-field']")
	private WebElement waistCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScale-field']")
	private WebElement painScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='painScaleUsed-field']")
	private WebElement painScaleUsedField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScale-field']")
	private WebElement riskFallScaleField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFallScaleUsed-field']")
	private WebElement riskFallScaleUsedField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesNurseVitalSignMeasurementCrudViewPage(
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
			"admin/entities/nurse-vital-sign-measurement/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}