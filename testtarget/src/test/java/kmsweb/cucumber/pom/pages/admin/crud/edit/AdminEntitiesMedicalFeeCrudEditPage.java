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
import kmsweb.entities.MedicalFeeEntity;

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
 * Medical FeePage is a Page POM that is associated with the admin/entities/medical-fee url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicalFeeCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='tariffType-field']")
	private WebElement tariffTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffCode-field']")
	private WebElement tariffCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='pharmacyTransactionType-field']")
	private WebElement pharmacyTransactionTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='pharmacyTransactionNumber-field']")
	private WebElement pharmacyTransactionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicationTransactionNumber-field']")
	private WebElement medicationTransactionNumberField;
	// TODO default handling dataAttribute transactionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionDate-field']")
	private WebElement transactionDateField;
	// TODO default handling dataAttribute quantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantity-field']")
	private WebElement quantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='unit-field']")
	private WebElement unitField;
	// TODO default handling dataAttribute unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	// TODO default handling dataAttribute hospitalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalPrice-field']")
	private WebElement hospitalPriceField;
	// TODO default handling dataAttribute otherComponentPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherComponentPrice-field']")
	private WebElement otherComponentPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalStaffCode-field']")
	private WebElement medicalStaffCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalFeeStatus-field']")
	private WebElement medicalFeeStatusField;
	// TODO default handling dataAttribute inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalFeeItemComponentsIds-field']")
	private WebElement medicalFeeItemComponentsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicalFeeCrudEditPage(
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
			"admin/entities/medical-fee/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicalFeeEntity) abstractEntity;
		DropdownUtils.selectOptionByName(webDriver, tariffTypeField, entity.getTariffType().getLiteralValue());
		tariffCodeField.sendKeys(entity.getTariffCode());
		nameField.sendKeys(entity.getName());
		DropdownUtils.selectOptionByName(webDriver, pharmacyTransactionTypeField, entity.getPharmacyTransactionType().getLiteralValue());
		pharmacyTransactionNumberField.sendKeys(entity.getPharmacyTransactionNumber());
		medicationTransactionNumberField.sendKeys(entity.getMedicationTransactionNumber());
		// TODO default handling for dataAttribute transactionDateField
		transactionDateField.sendKeys(entity.getTransactionDate().toString());

		// TODO default handling for dataAttribute quantityField
		quantityField.sendKeys(entity.getQuantity().toString());

		unitField.sendKeys(entity.getUnit());
		// TODO default handling for dataAttribute unitPriceField
		unitPriceField.sendKeys(entity.getUnitPrice().toString());

		// TODO default handling for dataAttribute hospitalPriceField
		hospitalPriceField.sendKeys(entity.getHospitalPrice().toString());

		// TODO default handling for dataAttribute otherComponentPriceField
		otherComponentPriceField.sendKeys(entity.getOtherComponentPrice().toString());

		medicalStaffCodeField.sendKeys(entity.getMedicalStaffCode());
		treatmentClassField.sendKeys(entity.getTreatmentClass());
		notesField.sendKeys(entity.getNotes());
		DropdownUtils.selectOptionByName(webDriver, medicalFeeStatusField, entity.getMedicalFeeStatus().getLiteralValue());
		// TODO default handling for dataAttribute inventoryRoundingValueField
		inventoryRoundingValueField.sendKeys(entity.getInventoryRoundingValue().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}