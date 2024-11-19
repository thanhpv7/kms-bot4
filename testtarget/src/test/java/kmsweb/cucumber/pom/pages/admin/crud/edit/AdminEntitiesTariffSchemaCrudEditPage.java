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
import kmsweb.entities.TariffSchemaEntity;

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
 * Tariff SchemaPage is a Page POM that is associated with the admin/entities/tariff-schema url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTariffSchemaCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='schemaCode-field']")
	private WebElement schemaCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='schemeName-field']")
	private WebElement schemeNameField;
	// TODO default handling dataAttribute startDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='startDate-field']")
	private WebElement startDateField;
	// TODO default handling dataAttribute endDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='endDate-field']")
	private WebElement endDateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='baseSchemeIds-field']")
	private WebElement baseSchemeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicesIds-field']")
	private WebElement invoicesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffDefinitionsIds-field']")
	private WebElement tariffDefinitionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffSchemeIds-field']")
	private WebElement tariffSchemeField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTariffSchemaCrudEditPage(
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
			"admin/entities/tariff-schema/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (TariffSchemaEntity) abstractEntity;
		schemaCodeField.sendKeys(entity.getSchemaCode());
		schemeNameField.sendKeys(entity.getSchemeName());
		// TODO default handling for dataAttribute startDateField
		startDateField.sendKeys(entity.getStartDate().toString());

		// TODO default handling for dataAttribute endDateField
		endDateField.sendKeys(entity.getEndDate().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}