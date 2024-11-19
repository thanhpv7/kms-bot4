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
import kmsweb.entities.RetailPharmacyEntity;

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
 * Retail PharmacyPage is a Page POM that is associated with the admin/entities/retail-pharmacy url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesRetailPharmacyCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='customerType-field']")
	private WebElement customerTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='retailNumber-field']")
	private WebElement retailNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
	@FindBy(how = How.XPATH, using = "//*[@id='customerName-field']")
	private WebElement customerNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentStatus-field']")
	private WebElement paymentStatusField;
	// TODO default handling dataAttribute totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyInvoicesIds-field']")
	private WebElement retailPharmacyInvoicesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyStockDetailsIds-field']")
	private WebElement retailPharmacyStockDetailsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInfoId-field']")
	private WebElement patientGeneralInfoField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesRetailPharmacyCrudEditPage(
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
			"admin/entities/retail-pharmacy/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (RetailPharmacyEntity) abstractEntity;
		customerTypeField.sendKeys(entity.getCustomerType());
		retailNumberField.sendKeys(entity.getRetailNumber());
		statusField.sendKeys(entity.getStatus());
		customerNameField.sendKeys(entity.getCustomerName());
		addressField.sendKeys(entity.getAddress());
		phoneNumberField.sendKeys(entity.getPhoneNumber());
		notesField.sendKeys(entity.getNotes());
		paymentStatusField.sendKeys(entity.getPaymentStatus());
		// TODO default handling for dataAttribute totalPriceField
		totalPriceField.sendKeys(entity.getTotalPrice().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}