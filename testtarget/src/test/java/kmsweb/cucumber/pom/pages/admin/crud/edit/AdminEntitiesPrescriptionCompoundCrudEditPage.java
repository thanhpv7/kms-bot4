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
import kmsweb.entities.PrescriptionCompoundEntity;

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
 * Prescription CompoundPage is a Page POM that is associated with the admin/entities/prescription-compound url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPrescriptionCompoundCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute iterationStartField;
	@FindBy(how = How.XPATH, using = "//*[@id='iterationStart-field']")
	private WebElement iterationStartField;
	// TODO default handling dataAttribute iterationEndField;
	@FindBy(how = How.XPATH, using = "//*[@id='iterationEnd-field']")
	private WebElement iterationEndField;
	@FindBy(how = How.XPATH, using = "//*[@id='compoundCode-field']")
	private WebElement compoundCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='compoundName-field']")
	private WebElement compoundNameField;
	// TODO default handling dataAttribute dosageTimesField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageTimes-field']")
	private WebElement dosageTimesField;
	// TODO default handling dataAttribute dosageDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageDays-field']")
	private WebElement dosageDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='frequency-field']")
	private WebElement frequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='isDtd-field']")
	private WebElement isDtdField;
	// TODO default handling dataAttribute requestedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='requestedQuantity-field']")
	private WebElement requestedQuantityField;
	// TODO default handling dataAttribute allocatedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedQuantity-field']")
	private WebElement allocatedQuantityField;
	// TODO default handling dataAttribute issuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedQuantity-field']")
	private WebElement issuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionMethod-field']")
	private WebElement consumptionMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalCompoundName-field']")
	private WebElement externalCompoundNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	// TODO default handling dataAttribute inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundItemsIds-field']")
	private WebElement compoundItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='unitId-field']")
	private WebElement unitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionHeaderId-field']")
	private WebElement prescriptionHeaderField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPrescriptionCompoundCrudEditPage(
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
			"admin/entities/prescription-compound/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PrescriptionCompoundEntity) abstractEntity;
		// TODO default handling for dataAttribute iterationStartField
		iterationStartField.sendKeys(entity.getIterationStart().toString());

		// TODO default handling for dataAttribute iterationEndField
		iterationEndField.sendKeys(entity.getIterationEnd().toString());

		compoundCodeField.sendKeys(entity.getCompoundCode());
		compoundNameField.sendKeys(entity.getCompoundName());
		// TODO default handling for dataAttribute dosageTimesField
		dosageTimesField.sendKeys(entity.getDosageTimes().toString());

		// TODO default handling for dataAttribute dosageDaysField
		dosageDaysField.sendKeys(entity.getDosageDays().toString());

		frequencyField.sendKeys(entity.getFrequency());
		if (entity.getIsDtd()) {
			isDtdField.click();
		}
		// TODO default handling for dataAttribute requestedQuantityField
		requestedQuantityField.sendKeys(entity.getRequestedQuantity().toString());

		// TODO default handling for dataAttribute allocatedQuantityField
		allocatedQuantityField.sendKeys(entity.getAllocatedQuantity().toString());

		// TODO default handling for dataAttribute issuedQuantityField
		issuedQuantityField.sendKeys(entity.getIssuedQuantity().toString());

		consumptionMethodField.sendKeys(entity.getConsumptionMethod());
		instructionField.sendKeys(entity.getInstruction());
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute totalPriceField
		totalPriceField.sendKeys(entity.getTotalPrice().toString());

		externalCompoundNameField.sendKeys(entity.getExternalCompoundName());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		// TODO default handling for dataAttribute inventoryRoundingValueField
		inventoryRoundingValueField.sendKeys(entity.getInventoryRoundingValue().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}