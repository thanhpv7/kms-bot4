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
import kmsweb.entities.UnitOfMeasurementEntity;

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
 * Unit Of MeasurementPage is a Page POM that is associated with the admin/entities/unit-of-measurement url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesUnitOfMeasurementCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='unitName-field']")
	private WebElement unitNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='symbol-field']")
	private WebElement symbolField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitCategory-field']")
	private WebElement unitCategoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionUnit-field']")
	private WebElement consumptionUnitField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='catalogueUOMId-field']")
	private WebElement catalogueUOMField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundPrescriptionDetailsIds-field']")
	private WebElement compoundPrescriptionDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundPrescriptionItemsIds-field']")
	private WebElement compoundPrescriptionItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundsUnitIds-field']")
	private WebElement compoundsUnitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationCompoundsIds-field']")
	private WebElement medicationCompoundsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationItemsIds-field']")
	private WebElement medicationItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionItemsIds-field']")
	private WebElement prescriptionItemsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesUnitOfMeasurementCrudEditPage(
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
			"admin/entities/unit-of-measurement/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (UnitOfMeasurementEntity) abstractEntity;
		unitNameField.sendKeys(entity.getUnitName());
		symbolField.sendKeys(entity.getSymbol());
		descriptionField.sendKeys(entity.getDescription());
		unitCategoryField.sendKeys(entity.getUnitCategory());
		if (entity.getConsumptionUnit()) {
			consumptionUnitField.click();
		}

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}