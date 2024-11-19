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
import kmsweb.entities.SupplierEntity;

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
 * SupplierPage is a Page POM that is associated with the admin/entities/supplier url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesSupplierCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='supplierNumber-field']")
	private WebElement supplierNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='supplierName-field']")
	private WebElement supplierNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxID-field']")
	private WebElement taxIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='supplyStockGroup-field']")
	private WebElement supplyStockGroupField;
	@FindBy(how = How.XPATH, using = "//*[@id='adress-field']")
	private WebElement adressField;
	@FindBy(how = How.XPATH, using = "//*[@id='country-field']")
	private WebElement countryField;
	@FindBy(how = How.XPATH, using = "//*[@id='stateProvince-field']")
	private WebElement stateProvinceField;
	@FindBy(how = How.XPATH, using = "//*[@id='city-field']")
	private WebElement cityField;
	@FindBy(how = How.XPATH, using = "//*[@id='postalCode-field']")
	private WebElement postalCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherPhoneNumber-field']")
	private WebElement otherPhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='fax-field']")
	private WebElement faxField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='website-field']")
	private WebElement websiteField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='purchaseOrderHold-field']")
	private WebElement purchaseOrderHoldField;
	@FindBy(how = How.XPATH, using = "//*[@id='purchaseOrderHoldReason-field']")
	private WebElement purchaseOrderHoldReasonField;
	@FindBy(how = How.XPATH, using = "//*[@id='vatIncluded-field']")
	private WebElement vatIncludedField;
	@FindBy(how = How.XPATH, using = "//*[@id='shippingMethod-field']")
	private WebElement shippingMethodField;
	// TODO default handling dataAttribute leadTimeMinimumField;
	@FindBy(how = How.XPATH, using = "//*[@id='leadTimeMinimum-field']")
	private WebElement leadTimeMinimumField;
	// TODO default handling dataAttribute leadTimeMaximumField;
	@FindBy(how = How.XPATH, using = "//*[@id='leadTimeMaximum-field']")
	private WebElement leadTimeMaximumField;
	// TODO default handling dataAttribute lastPurchaseDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastPurchaseDate-field']")
	private WebElement lastPurchaseDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastPurchaseOrderNumber-field']")
	private WebElement lastPurchaseOrderNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='leadTimeMeasurement-field']")
	private WebElement leadTimeMeasurementField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNotesIds-field']")
	private WebElement goodsReceiveNotesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrdersIds-field']")
	private WebElement purchaseOrdersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionsIds-field']")
	private WebElement purchaseRequisitionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='returnSuppliersIds-field']")
	private WebElement returnSuppliersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='suplierContactDetailsIds-field']")
	private WebElement suplierContactDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='supplierBankAccountsIds-field']")
	private WebElement supplierBankAccountsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='supplierProductDetailsIds-field']")
	private WebElement supplierProductDetailsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesSupplierCrudEditPage(
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
			"admin/entities/supplier/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (SupplierEntity) abstractEntity;
		supplierNumberField.sendKeys(entity.getSupplierNumber());
		supplierNameField.sendKeys(entity.getSupplierName());
		taxIDField.sendKeys(entity.getTaxID());
		supplyStockGroupField.sendKeys(entity.getSupplyStockGroup());
		adressField.sendKeys(entity.getAdress());
		countryField.sendKeys(entity.getCountry());
		stateProvinceField.sendKeys(entity.getStateProvince());
		cityField.sendKeys(entity.getCity());
		postalCodeField.sendKeys(entity.getPostalCode());
		phoneNumberField.sendKeys(entity.getPhoneNumber());
		otherPhoneNumberField.sendKeys(entity.getOtherPhoneNumber());
		faxField.sendKeys(entity.getFax());
		emailField.sendKeys(entity.getEmail());
		websiteField.sendKeys(entity.getWebsite());
		notesField.sendKeys(entity.getNotes());
		if (entity.getPurchaseOrderHold()) {
			purchaseOrderHoldField.click();
		}
		purchaseOrderHoldReasonField.sendKeys(entity.getPurchaseOrderHoldReason());
		if (entity.getVatIncluded()) {
			vatIncludedField.click();
		}
		shippingMethodField.sendKeys(entity.getShippingMethod());
		// TODO default handling for dataAttribute leadTimeMinimumField
		leadTimeMinimumField.sendKeys(entity.getLeadTimeMinimum().toString());

		// TODO default handling for dataAttribute leadTimeMaximumField
		leadTimeMaximumField.sendKeys(entity.getLeadTimeMaximum().toString());

		// TODO default handling for dataAttribute lastPurchaseDateField
		lastPurchaseDateField.sendKeys(entity.getLastPurchaseDate().toString());

		lastPurchaseOrderNumberField.sendKeys(entity.getLastPurchaseOrderNumber());
		leadTimeMeasurementField.sendKeys(entity.getLeadTimeMeasurement());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}