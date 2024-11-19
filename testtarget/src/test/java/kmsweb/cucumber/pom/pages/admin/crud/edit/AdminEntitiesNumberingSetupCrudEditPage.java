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
import kmsweb.entities.NumberingSetupEntity;

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
 * Numbering SetupPage is a Page POM that is associated with the admin/entities/numbering-setup url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesNumberingSetupCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='numberingType-field']")
	private WebElement numberingTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='prefix-field']")
	private WebElement prefixField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateFormat-field']")
	private WebElement dateFormatField;
	@FindBy(how = How.XPATH, using = "//*[@id='sufix-field']")
	private WebElement sufixField;
	// TODO default handling dataAttribute lastCounterField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastCounter-field']")
	private WebElement lastCounterField;
	@FindBy(how = How.XPATH, using = "//*[@id='editable-field']")
	private WebElement editableField;
	@FindBy(how = How.XPATH, using = "//*[@id='resetPerDay-field']")
	private WebElement resetPerDayField;
	// TODO default handling dataAttribute counterLengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='counterLength-field']")
	private WebElement counterLengthField;
	// TODO default handling dataAttribute lastUpdatedField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastUpdated-field']")
	private WebElement lastUpdatedField;
	@FindBy(how = How.XPATH, using = "//*[@id='preview-field']")
	private WebElement previewField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesNumberingSetupCrudEditPage(
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
			"admin/entities/numbering-setup/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (NumberingSetupEntity) abstractEntity;
		DropdownUtils.selectOptionByName(webDriver, numberingTypeField, entity.getNumberingType().getLiteralValue());
		prefixField.sendKeys(entity.getPrefix());
		DropdownUtils.selectOptionByName(webDriver, dateFormatField, entity.getDateFormat().getLiteralValue());
		sufixField.sendKeys(entity.getSufix());
		// TODO default handling for dataAttribute lastCounterField
		lastCounterField.sendKeys(entity.getLastCounter().toString());

		if (entity.getEditable()) {
			editableField.click();
		}
		if (entity.getResetPerDay()) {
			resetPerDayField.click();
		}
		// TODO default handling for dataAttribute counterLengthField
		counterLengthField.sendKeys(entity.getCounterLength().toString());

		// TODO default handling for dataAttribute lastUpdatedField
		lastUpdatedField.sendKeys(entity.getLastUpdated().toString());

		previewField.sendKeys(entity.getPreview());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}