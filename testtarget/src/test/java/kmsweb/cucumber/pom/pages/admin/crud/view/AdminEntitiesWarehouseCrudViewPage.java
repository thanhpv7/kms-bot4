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
package kmsweb.cucumber.pom.pages.admin.crud.view;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.WarehouseEntity;

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
 * WarehousePage is a Page POM that is associated with the admin/entities/warehouse url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesWarehouseCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='warehouseNumber-field']")
	private WebElement warehouseNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='warehouseName-field']")
	private WebElement warehouseNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPerson-field']")
	private WebElement contactPersonField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='ext-field']")
	private WebElement extField;
	@FindBy(how = How.XPATH, using = "//*[@id='mobilePhoneNumber-field']")
	private WebElement mobilePhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='revenueCenter-field']")
	private WebElement revenueCenterField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockBalancesWarehouseIds-field']")
	private WebElement batchStockBalancesWarehouseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockBalancesIds-field']")
	private WebElement batchStockBalancesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockTransactionDetailsIds-field']")
	private WebElement batchStockTransactionDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='destinationWarehousesIds-field']")
	private WebElement destinationWarehousesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteBatchsIds-field']")
	private WebElement goodsReceiveNoteBatchsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNotesIds-field']")
	private WebElement goodsReceiveNotesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='internalOrdersIds-field']")
	private WebElement internalOrdersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjusmentBatchsIds-field']")
	private WebElement inventoryAdjusmentBatchsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjustmentsIds-field']")
	private WebElement inventoryAdjustmentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryBatchCorrectionsIds-field']")
	private WebElement inventoryBatchCorrectionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='locationsIds-field']")
	private WebElement locationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalFeesIds-field']")
	private WebElement medicalFeesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeadersIds-field']")
	private WebElement medicationHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionHeadersIds-field']")
	private WebElement prescriptionHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrdersIds-field']")
	private WebElement purchaseOrdersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionsIds-field']")
	private WebElement purchaseRequisitionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmaciesIds-field']")
	private WebElement retailPharmaciesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='returnSuppliersIds-field']")
	private WebElement returnSuppliersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sourceWarehousesIds-field']")
	private WebElement sourceWarehousesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCataloguesIds-field']")
	private WebElement stockCataloguesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockControlsIds-field']")
	private WebElement stockControlsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionDetailsIds-field']")
	private WebElement stockTransactionDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionPerDateTypesIds-field']")
	private WebElement stockTransactionPerDateTypesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionPerDatesIds-field']")
	private WebElement stockTransactionPerDatesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='vaccinationOrderDetailsIds-field']")
	private WebElement vaccinationOrderDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseInitialStockSIds-field']")
	private WebElement warehouseInitialStockSField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseInventoriesIds-field']")
	private WebElement warehouseInventoriesField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesWarehouseCrudViewPage(
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
			"admin/entities/warehouse/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}