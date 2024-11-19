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
import kmsweb.entities.ExaminationItemDetailEntity;

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
 * Examination Item DetailPage is a Page POM that is associated with the admin/entities/examination-item-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesExaminationItemDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute ageMinimumField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageMinimum-field']")
	private WebElement ageMinimumField;
	// TODO default handling dataAttribute ageMaximumField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageMaximum-field']")
	private WebElement ageMaximumField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	// TODO default handling dataAttribute normalRangeLowField;
	@FindBy(how = How.XPATH, using = "//*[@id='normalRangeLow-field']")
	private WebElement normalRangeLowField;
	// TODO default handling dataAttribute normalRangeHighField;
	@FindBy(how = How.XPATH, using = "//*[@id='normalRangeHigh-field']")
	private WebElement normalRangeHighField;
	@FindBy(how = How.XPATH, using = "//*[@id='unit-field']")
	private WebElement unitField;
	// TODO default handling dataAttribute criticalValueLowField;
	@FindBy(how = How.XPATH, using = "//*[@id='criticalValueLow-field']")
	private WebElement criticalValueLowField;
	// TODO default handling dataAttribute criticalValueHighField;
	@FindBy(how = How.XPATH, using = "//*[@id='criticalValueHigh-field']")
	private WebElement criticalValueHighField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageMinUnit-field']")
	private WebElement ageMinUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageMaxUnit-field']")
	private WebElement ageMaxUnitField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='examinationItemId-field']")
	private WebElement examinationItemField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesExaminationItemDetailCrudEditPage(
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
			"admin/entities/examination-item-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (ExaminationItemDetailEntity) abstractEntity;
		// TODO default handling for dataAttribute ageMinimumField
		ageMinimumField.sendKeys(entity.getAgeMinimum().toString());

		// TODO default handling for dataAttribute ageMaximumField
		ageMaximumField.sendKeys(entity.getAgeMaximum().toString());

		genderField.sendKeys(entity.getGender());
		// TODO default handling for dataAttribute normalRangeLowField
		normalRangeLowField.sendKeys(entity.getNormalRangeLow().toString());

		// TODO default handling for dataAttribute normalRangeHighField
		normalRangeHighField.sendKeys(entity.getNormalRangeHigh().toString());

		unitField.sendKeys(entity.getUnit());
		// TODO default handling for dataAttribute criticalValueLowField
		criticalValueLowField.sendKeys(entity.getCriticalValueLow().toString());

		// TODO default handling for dataAttribute criticalValueHighField
		criticalValueHighField.sendKeys(entity.getCriticalValueHigh().toString());

		ageMinUnitField.sendKeys(entity.getAgeMinUnit());
		ageMaxUnitField.sendKeys(entity.getAgeMaxUnit());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}