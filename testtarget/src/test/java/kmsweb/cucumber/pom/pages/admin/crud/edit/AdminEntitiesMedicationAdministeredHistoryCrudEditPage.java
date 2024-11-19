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
import kmsweb.entities.MedicationAdministeredHistoryEntity;

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
 * Medication Administered HistoryPage is a Page POM that is associated with the admin/entities/medication-administered-history url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicationAdministeredHistoryCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute datetimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='datetime-field']")
	private WebElement datetimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='administrationNotes-field']")
	private WebElement administrationNotesField;
	// TODO default handling dataAttribute administeredQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='administeredQuantity-field']")
	private WebElement administeredQuantityField;
	// TODO default handling dataAttribute takenHomeQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='takenHomeQuantity-field']")
	private WebElement takenHomeQuantityField;
	// TODO default handling dataAttribute returnedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='returnedQuantity-field']")
	private WebElement returnedQuantityField;
	// TODO default handling dataAttribute totalAdministeredQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalAdministeredQuantity-field']")
	private WebElement totalAdministeredQuantityField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationItemId-field']")
	private WebElement medicationItemField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationCompoundId-field']")
	private WebElement medicationCompoundField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicationAdministeredHistoryCrudEditPage(
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
			"admin/entities/medication-administered-history/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicationAdministeredHistoryEntity) abstractEntity;
		// TODO default handling for dataAttribute datetimeField
		datetimeField.sendKeys(entity.getDatetime().toString());

		administrationNotesField.sendKeys(entity.getAdministrationNotes());
		// TODO default handling for dataAttribute administeredQuantityField
		administeredQuantityField.sendKeys(entity.getAdministeredQuantity().toString());

		// TODO default handling for dataAttribute takenHomeQuantityField
		takenHomeQuantityField.sendKeys(entity.getTakenHomeQuantity().toString());

		// TODO default handling for dataAttribute returnedQuantityField
		returnedQuantityField.sendKeys(entity.getReturnedQuantity().toString());

		// TODO default handling for dataAttribute totalAdministeredQuantityField
		totalAdministeredQuantityField.sendKeys(entity.getTotalAdministeredQuantity().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}