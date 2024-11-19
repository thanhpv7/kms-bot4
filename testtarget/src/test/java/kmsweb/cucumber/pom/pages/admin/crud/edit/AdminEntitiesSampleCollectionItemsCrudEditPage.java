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
import kmsweb.entities.SampleCollectionItemsEntity;

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
 * Sample Collection ItemsPage is a Page POM that is associated with the admin/entities/sample-collection-items url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesSampleCollectionItemsCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='sampleType-field']")
	private WebElement sampleTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sampleNumber-field']")
	private WebElement sampleNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='sampleTakingLocation-field']")
	private WebElement sampleTakingLocationField;
	@FindBy(how = How.XPATH, using = "//*[@id='volume-field']")
	private WebElement volumeField;
	@FindBy(how = How.XPATH, using = "//*[@id='container-field']")
	private WebElement containerField;
	@FindBy(how = How.XPATH, using = "//*[@id='transport-field']")
	private WebElement transportField;
	// TODO default handling dataAttribute sampleCollectionDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sampleCollectionDateTime-field']")
	private WebElement sampleCollectionDateTimeField;
	// TODO default handling dataAttribute sampleProcessingDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sampleProcessingDateTime-field']")
	private WebElement sampleProcessingDateTimeField;
	// TODO default handling dataAttribute sampleDeliveryDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sampleDeliveryDateTime-field']")
	private WebElement sampleDeliveryDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleCollectionInformationId-field']")
	private WebElement sampleCollectionInformationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleCollectionStaffId-field']")
	private WebElement sampleCollectionStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleDeliveryStaffId-field']")
	private WebElement sampleDeliveryStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleProcessingStaffId-field']")
	private WebElement sampleProcessingStaffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesSampleCollectionItemsCrudEditPage(
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
			"admin/entities/sample-collection-items/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (SampleCollectionItemsEntity) abstractEntity;
		sampleTypeField.sendKeys(entity.getSampleType());
		sampleNumberField.sendKeys(entity.getSampleNumber());
		sampleTakingLocationField.sendKeys(entity.getSampleTakingLocation());
		volumeField.sendKeys(entity.getVolume());
		containerField.sendKeys(entity.getContainer());
		transportField.sendKeys(entity.getTransport());
		// TODO default handling for dataAttribute sampleCollectionDateTimeField
		sampleCollectionDateTimeField.sendKeys(entity.getSampleCollectionDateTime().toString());

		// TODO default handling for dataAttribute sampleProcessingDateTimeField
		sampleProcessingDateTimeField.sendKeys(entity.getSampleProcessingDateTime().toString());

		// TODO default handling for dataAttribute sampleDeliveryDateTimeField
		sampleDeliveryDateTimeField.sendKeys(entity.getSampleDeliveryDateTime().toString());

		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}