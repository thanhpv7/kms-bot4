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
import kmsweb.entities.TransferOrderStockDetailEntity;

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
 * Transfer Order Stock DetailPage is a Page POM that is associated with the admin/entities/transfer-order-stock-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTransferOrderStockDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute itemNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNumber-field']")
	private WebElement itemNumberField;
	// TODO default handling dataAttribute sourceAvailableQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceAvailableQuantity-field']")
	private WebElement sourceAvailableQuantityField;
	// TODO default handling dataAttribute destinationSOHField;
	@FindBy(how = How.XPATH, using = "//*[@id='destinationSOH-field']")
	private WebElement destinationSOHField;
	// TODO default handling dataAttribute quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityOrdered-field']")
	private WebElement quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='uom-field']")
	private WebElement uomField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionStatus-field']")
	private WebElement transactionStatusField;
	// TODO default handling dataAttribute quantityIssuedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityIssued-field']")
	private WebElement quantityIssuedField;
	// TODO default handling dataAttribute quantityReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReceived-field']")
	private WebElement quantityReceivedField;
	// TODO default handling dataAttribute sourceMinLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceMinLevel-field']")
	private WebElement sourceMinLevelField;
	// TODO default handling dataAttribute destinationMaxLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='destinationMaxLevel-field']")
	private WebElement destinationMaxLevelField;
	// TODO default handling dataAttribute quantityTransferredField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityTransferred-field']")
	private WebElement quantityTransferredField;
	// TODO default handling dataAttribute quantityFulfilledField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityFulfilled-field']")
	private WebElement quantityFulfilledField;
	// TODO default handling dataAttribute orderDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDateTime-field']")
	private WebElement orderDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	// TODO default handling dataAttribute inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='transferOrderId-field']")
	private WebElement transferOrderField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTransferOrderStockDetailCrudEditPage(
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
			"admin/entities/transfer-order-stock-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (TransferOrderStockDetailEntity) abstractEntity;
		// TODO default handling for dataAttribute itemNumberField
		itemNumberField.sendKeys(entity.getItemNumber().toString());

		// TODO default handling for dataAttribute sourceAvailableQuantityField
		sourceAvailableQuantityField.sendKeys(entity.getSourceAvailableQuantity().toString());

		// TODO default handling for dataAttribute destinationSOHField
		destinationSOHField.sendKeys(entity.getDestinationSOH().toString());

		// TODO default handling for dataAttribute quantityOrderedField
		quantityOrderedField.sendKeys(entity.getQuantityOrdered().toString());

		uomField.sendKeys(entity.getUom());
		transactionStatusField.sendKeys(entity.getTransactionStatus());
		// TODO default handling for dataAttribute quantityIssuedField
		quantityIssuedField.sendKeys(entity.getQuantityIssued().toString());

		// TODO default handling for dataAttribute quantityReceivedField
		quantityReceivedField.sendKeys(entity.getQuantityReceived().toString());

		// TODO default handling for dataAttribute sourceMinLevelField
		sourceMinLevelField.sendKeys(entity.getSourceMinLevel().toString());

		// TODO default handling for dataAttribute destinationMaxLevelField
		destinationMaxLevelField.sendKeys(entity.getDestinationMaxLevel().toString());

		// TODO default handling for dataAttribute quantityTransferredField
		quantityTransferredField.sendKeys(entity.getQuantityTransferred().toString());

		// TODO default handling for dataAttribute quantityFulfilledField
		quantityFulfilledField.sendKeys(entity.getQuantityFulfilled().toString());

		// TODO default handling for dataAttribute orderDateTimeField
		orderDateTimeField.sendKeys(entity.getOrderDateTime().toString());

		itemNotesField.sendKeys(entity.getItemNotes());
		// TODO default handling for dataAttribute inventoryRoundingValueField
		inventoryRoundingValueField.sendKeys(entity.getInventoryRoundingValue().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}