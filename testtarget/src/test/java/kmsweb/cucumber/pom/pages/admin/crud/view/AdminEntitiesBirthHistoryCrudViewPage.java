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
import kmsweb.entities.BirthHistoryEntity;

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
 * Birth HistoryPage is a Page POM that is associated with the admin/entities/birth-history url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBirthHistoryCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='gestationalAgeWeeks-field']")
	private WebElement gestationalAgeWeeksField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationalAgeDays-field']")
	private WebElement gestationalAgeDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryType-field']")
	private WebElement deliveryTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='length-field']")
	private WebElement lengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='lengthUnit-field']")
	private WebElement lengthUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUnit-field']")
	private WebElement weightUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='headCircumferenceBirth-field']")
	private WebElement headCircumferenceBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='headCircumferenceBirthUnit-field']")
	private WebElement headCircumferenceBirthUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='chestCircumference-field']")
	private WebElement chestCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='chestCircumferenceUnit-field']")
	private WebElement chestCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='birthCondition-field']")
	private WebElement birthConditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='neonatalCase-field']")
	private WebElement neonatalCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='pediatricCase-field']")
	private WebElement pediatricCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='foodType-field']")
	private WebElement foodTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='headCircumference-field']")
	private WebElement headCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='headCircumferenceUnit-field']")
	private WebElement headCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='upperArmCircumference-field']")
	private WebElement upperArmCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='upperArmCircumferenceUnit-field']")
	private WebElement upperArmCircumferenceUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='actionTaken-field']")
	private WebElement actionTakenField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightGestationalAge-field']")
	private WebElement weightGestationalAgeField;
	

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
	public AdminEntitiesBirthHistoryCrudViewPage(
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
			"admin/entities/birth-history/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}