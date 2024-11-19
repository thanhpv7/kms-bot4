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
import kmsweb.entities.PrescriptionItemEntity;

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
 * Prescription ItemPage is a Page POM that is associated with the admin/entities/prescription-item url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPrescriptionItemCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute iterationStartField;
	@FindBy(how = How.XPATH, using = "//*[@id='iterationStart-field']")
	private WebElement iterationStartField;
	// TODO default handling dataAttribute iterationEndField;
	@FindBy(how = How.XPATH, using = "//*[@id='iterationEnd-field']")
	private WebElement iterationEndField;
	// TODO default handling dataAttribute requestedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='requestedQuantity-field']")
	private WebElement requestedQuantityField;
	// TODO default handling dataAttribute allocatedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedQuantity-field']")
	private WebElement allocatedQuantityField;
	// TODO default handling dataAttribute issuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedQuantity-field']")
	private WebElement issuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='frequency-field']")
	private WebElement frequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionMethod-field']")
	private WebElement consumptionMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	// TODO default handling dataAttribute dosageTimesField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageTimes-field']")
	private WebElement dosageTimesField;
	// TODO default handling dataAttribute dosageDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageDays-field']")
	private WebElement dosageDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	// TODO default handling dataAttribute totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='isDtd-field']")
	private WebElement isDtdField;
	// TODO default handling dataAttribute doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='dose-field']")
	private WebElement doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalStockName-field']")
	private WebElement externalStockNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	// TODO default handling dataAttribute inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	// TODO default handling dataAttribute dtdQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='dtdQuantity-field']")
	private WebElement dtdQuantityField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundId-field']")
	private WebElement compoundField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueIdId-field']")
	private WebElement stockCatalogueIdField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionId-field']")
	private WebElement prescriptionField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='unitId-field']")
	private WebElement unitField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPrescriptionItemCrudEditPage(
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
			"admin/entities/prescription-item/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PrescriptionItemEntity) abstractEntity;
		// TODO default handling for dataAttribute iterationStartField
		iterationStartField.sendKeys(entity.getIterationStart().toString());

		// TODO default handling for dataAttribute iterationEndField
		iterationEndField.sendKeys(entity.getIterationEnd().toString());

		// TODO default handling for dataAttribute requestedQuantityField
		requestedQuantityField.sendKeys(entity.getRequestedQuantity().toString());

		// TODO default handling for dataAttribute allocatedQuantityField
		allocatedQuantityField.sendKeys(entity.getAllocatedQuantity().toString());

		// TODO default handling for dataAttribute issuedQuantityField
		issuedQuantityField.sendKeys(entity.getIssuedQuantity().toString());

		frequencyField.sendKeys(entity.getFrequency());
		consumptionMethodField.sendKeys(entity.getConsumptionMethod());
		instructionField.sendKeys(entity.getInstruction());
		// TODO default handling for dataAttribute dosageTimesField
		dosageTimesField.sendKeys(entity.getDosageTimes().toString());

		// TODO default handling for dataAttribute dosageDaysField
		dosageDaysField.sendKeys(entity.getDosageDays().toString());

		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute unitPriceField
		unitPriceField.sendKeys(entity.getUnitPrice().toString());

		// TODO default handling for dataAttribute totalPriceField
		totalPriceField.sendKeys(entity.getTotalPrice().toString());

		if (entity.getIsDtd()) {
			isDtdField.click();
		}
		// TODO default handling for dataAttribute doseField
		doseField.sendKeys(entity.getDose().toString());

		externalStockNameField.sendKeys(entity.getExternalStockName());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		// TODO default handling for dataAttribute inventoryRoundingValueField
		inventoryRoundingValueField.sendKeys(entity.getInventoryRoundingValue().toString());

		// TODO default handling for dataAttribute dtdQuantityField
		dtdQuantityField.sendKeys(entity.getDtdQuantity().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}