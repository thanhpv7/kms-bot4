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
import kmsweb.entities.InvoiceItemEntity;

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
 * Invoice ItemPage is a Page POM that is associated with the admin/entities/invoice-item url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInvoiceItemCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute transactionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionDate-field']")
	private WebElement transactionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffCode-field']")
	private WebElement tariffCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffType-field']")
	private WebElement tariffTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalStaffCode-field']")
	private WebElement medicalStaffCodeField;
	// TODO default handling dataAttribute priceField;
	@FindBy(how = How.XPATH, using = "//*[@id='price-field']")
	private WebElement priceField;
	// TODO default handling dataAttribute hospitalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalPrice-field']")
	private WebElement hospitalPriceField;
	// TODO default handling dataAttribute totalOtherComponentPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalOtherComponentPrice-field']")
	private WebElement totalOtherComponentPriceField;
	// TODO default handling dataAttribute quantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantity-field']")
	private WebElement quantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='unit-field']")
	private WebElement unitField;
	// TODO default handling dataAttribute discountField;
	@FindBy(how = How.XPATH, using = "//*[@id='discount-field']")
	private WebElement discountField;
	@FindBy(how = How.XPATH, using = "//*[@id='tax-field']")
	private WebElement taxField;
	// TODO default handling dataAttribute itemTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemTotal-field']")
	private WebElement itemTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemComponentsIds-field']")
	private WebElement invoiceItemComponentsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceId-field']")
	private WebElement invoiceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalFeeId-field']")
	private WebElement medicalFeeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeaderId-field']")
	private WebElement medicationHeaderField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionId-field']")
	private WebElement prescriptionField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyInvoiceId-field']")
	private WebElement retailPharmacyInvoiceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceNumberId-field']")
	private WebElement serviceNumberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffSchemaId-field']")
	private WebElement tariffSchemaField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInvoiceItemCrudEditPage(
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
			"admin/entities/invoice-item/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (InvoiceItemEntity) abstractEntity;
		// TODO default handling for dataAttribute transactionDateField
		transactionDateField.sendKeys(entity.getTransactionDate().toString());

		tariffCodeField.sendKeys(entity.getTariffCode());
		DropdownUtils.selectOptionByName(webDriver, tariffTypeField, entity.getTariffType().getLiteralValue());
		nameField.sendKeys(entity.getName());
		medicalStaffCodeField.sendKeys(entity.getMedicalStaffCode());
		// TODO default handling for dataAttribute priceField
		priceField.sendKeys(entity.getPrice().toString());

		// TODO default handling for dataAttribute hospitalPriceField
		hospitalPriceField.sendKeys(entity.getHospitalPrice().toString());

		// TODO default handling for dataAttribute totalOtherComponentPriceField
		totalOtherComponentPriceField.sendKeys(entity.getTotalOtherComponentPrice().toString());

		// TODO default handling for dataAttribute quantityField
		quantityField.sendKeys(entity.getQuantity().toString());

		unitField.sendKeys(entity.getUnit());
		// TODO default handling for dataAttribute discountField
		discountField.sendKeys(entity.getDiscount().toString());

		if (entity.getTax()) {
			taxField.click();
		}
		// TODO default handling for dataAttribute itemTotalField
		itemTotalField.sendKeys(entity.getItemTotal().toString());

		treatmentClassField.sendKeys(entity.getTreatmentClass());
		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}