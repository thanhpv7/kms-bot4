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
import kmsweb.entities.MedicationCompoundEntity;

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
 * Medication CompoundPage is a Page POM that is associated with the admin/entities/medication-compound url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicationCompoundCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='compoundCode-field']")
	private WebElement compoundCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='compoundName-field']")
	private WebElement compoundNameField;
	// TODO default handling dataAttribute requestedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='requestedQty-field']")
	private WebElement requestedQtyField;
	// TODO default handling dataAttribute outstandingQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingQty-field']")
	private WebElement outstandingQtyField;
	// TODO default handling dataAttribute returnedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='returnedQty-field']")
	private WebElement returnedQtyField;
	// TODO default handling dataAttribute issuedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedQty-field']")
	private WebElement issuedQtyField;
	// TODO default handling dataAttribute administeredQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='administeredQty-field']")
	private WebElement administeredQtyField;
	// TODO default handling dataAttribute takenHomeQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='takenHomeQty-field']")
	private WebElement takenHomeQtyField;
	// TODO default handling dataAttribute dosageFrequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageFrequency-field']")
	private WebElement dosageFrequencyField;
	// TODO default handling dataAttribute dosageQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageQty-field']")
	private WebElement dosageQtyField;
	// TODO default handling dataAttribute doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='dose-field']")
	private WebElement doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='frequency-field']")
	private WebElement frequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionMethod-field']")
	private WebElement consumptionMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='isDtd-field']")
	private WebElement isDtdField;
	// TODO default handling dataAttribute totalAdministeredQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalAdministeredQuantity-field']")
	private WebElement totalAdministeredQuantityField;
	// TODO default handling dataAttribute totalIssuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalIssuedQuantity-field']")
	private WebElement totalIssuedQuantityField;
	// TODO default handling dataAttribute totalTakenHomeQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalTakenHomeQuantity-field']")
	private WebElement totalTakenHomeQuantityField;
	// TODO default handling dataAttribute totalReturnedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalReturnedQuantity-field']")
	private WebElement totalReturnedQuantityField;
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
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationAdministeredHistoriesIds-field']")
	private WebElement medicationAdministeredHistoriesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationItemsIds-field']")
	private WebElement medicationItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeaderId-field']")
	private WebElement medicationHeaderField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='unitOfMeasurementId-field']")
	private WebElement unitOfMeasurementField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicationCompoundCrudEditPage(
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
			"admin/entities/medication-compound/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicationCompoundEntity) abstractEntity;
		compoundCodeField.sendKeys(entity.getCompoundCode());
		compoundNameField.sendKeys(entity.getCompoundName());
		// TODO default handling for dataAttribute requestedQtyField
		requestedQtyField.sendKeys(entity.getRequestedQty().toString());

		// TODO default handling for dataAttribute outstandingQtyField
		outstandingQtyField.sendKeys(entity.getOutstandingQty().toString());

		// TODO default handling for dataAttribute returnedQtyField
		returnedQtyField.sendKeys(entity.getReturnedQty().toString());

		// TODO default handling for dataAttribute issuedQtyField
		issuedQtyField.sendKeys(entity.getIssuedQty().toString());

		// TODO default handling for dataAttribute administeredQtyField
		administeredQtyField.sendKeys(entity.getAdministeredQty().toString());

		// TODO default handling for dataAttribute takenHomeQtyField
		takenHomeQtyField.sendKeys(entity.getTakenHomeQty().toString());

		// TODO default handling for dataAttribute dosageFrequencyField
		dosageFrequencyField.sendKeys(entity.getDosageFrequency().toString());

		// TODO default handling for dataAttribute dosageQtyField
		dosageQtyField.sendKeys(entity.getDosageQty().toString());

		// TODO default handling for dataAttribute doseField
		doseField.sendKeys(entity.getDose().toString());

		frequencyField.sendKeys(entity.getFrequency());
		consumptionMethodField.sendKeys(entity.getConsumptionMethod());
		instructionField.sendKeys(entity.getInstruction());
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute totalPriceField
		totalPriceField.sendKeys(entity.getTotalPrice().toString());

		if (entity.getIsDtd()) {
			isDtdField.click();
		}
		// TODO default handling for dataAttribute totalAdministeredQuantityField
		totalAdministeredQuantityField.sendKeys(entity.getTotalAdministeredQuantity().toString());

		// TODO default handling for dataAttribute totalIssuedQuantityField
		totalIssuedQuantityField.sendKeys(entity.getTotalIssuedQuantity().toString());

		// TODO default handling for dataAttribute totalTakenHomeQuantityField
		totalTakenHomeQuantityField.sendKeys(entity.getTotalTakenHomeQuantity().toString());

		// TODO default handling for dataAttribute totalReturnedQuantityField
		totalReturnedQuantityField.sendKeys(entity.getTotalReturnedQuantity().toString());

		externalCompoundNameField.sendKeys(entity.getExternalCompoundName());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		// TODO default handling for dataAttribute inventoryRoundingValueField
		inventoryRoundingValueField.sendKeys(entity.getInventoryRoundingValue().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}