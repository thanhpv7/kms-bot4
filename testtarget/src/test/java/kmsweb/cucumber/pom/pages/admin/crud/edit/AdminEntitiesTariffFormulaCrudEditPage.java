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
import kmsweb.entities.TariffFormulaEntity;

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
 * Tariff FormulaPage is a Page POM that is associated with the admin/entities/tariff-formula url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTariffFormulaCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='tariffType-field']")
	private WebElement tariffTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='classification-field']")
	private WebElement classificationField;
	// TODO default handling dataAttribute multiplierField;
	@FindBy(how = How.XPATH, using = "//*[@id='multiplier-field']")
	private WebElement multiplierField;
	// TODO default handling dataAttribute roundingField;
	@FindBy(how = How.XPATH, using = "//*[@id='rounding-field']")
	private WebElement roundingField;
	@FindBy(how = How.XPATH, using = "//*[@id='roundingMethod-field']")
	private WebElement roundingMethodField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='baseSchemaId-field']")
	private WebElement baseSchemaField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffSchemaId-field']")
	private WebElement tariffSchemaField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTariffFormulaCrudEditPage(
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
			"admin/entities/tariff-formula/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (TariffFormulaEntity) abstractEntity;
		DropdownUtils.selectOptionByName(webDriver, tariffTypeField, entity.getTariffType().getLiteralValue());
		classificationField.sendKeys(entity.getClassification());
		// TODO default handling for dataAttribute multiplierField
		multiplierField.sendKeys(entity.getMultiplier().toString());

		// TODO default handling for dataAttribute roundingField
		roundingField.sendKeys(entity.getRounding().toString());

		DropdownUtils.selectOptionByName(webDriver, roundingMethodField, entity.getRoundingMethod().getLiteralValue());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}