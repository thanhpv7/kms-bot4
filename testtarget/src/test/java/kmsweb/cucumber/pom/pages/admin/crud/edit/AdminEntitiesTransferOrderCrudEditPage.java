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
import kmsweb.entities.TransferOrderEntity;

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
 * Transfer OrderPage is a Page POM that is associated with the admin/entities/transfer-order url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTransferOrderCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='transferOrderNumber-field']")
	private WebElement transferOrderNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionStatus-field']")
	private WebElement transactionStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	// TODO default handling dataAttribute orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDate-field']")
	private WebElement orderDateField;
	// TODO default handling dataAttribute expectedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='expectedDate-field']")
	private WebElement expectedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceNumber-field']")
	private WebElement referenceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDate-field']")
	private WebElement voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceDocument-field']")
	private WebElement referenceDocumentField;
	// TODO default handling dataAttribute requiredDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='requiredDate-field']")
	private WebElement requiredDateField;
	// TODO default handling dataAttribute issuedDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedDateTime-field']")
	private WebElement issuedDateTimeField;
	// TODO default handling dataAttribute receivedDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='receivedDateTime-field']")
	private WebElement receivedDateTimeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='transferOrderStockDetailsIds-field']")
	private WebElement transferOrderStockDetailsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='destinationWarehouseId-field']")
	private WebElement destinationWarehouseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sourceWarehouseId-field']")
	private WebElement sourceWarehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTransferOrderCrudEditPage(
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
			"admin/entities/transfer-order/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (TransferOrderEntity) abstractEntity;
		transferOrderNumberField.sendKeys(entity.getTransferOrderNumber());
		transactionStatusField.sendKeys(entity.getTransactionStatus());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		// TODO default handling for dataAttribute orderDateField
		orderDateField.sendKeys(entity.getOrderDate().toString());

		// TODO default handling for dataAttribute expectedDateField
		expectedDateField.sendKeys(entity.getExpectedDate().toString());

		referenceNumberField.sendKeys(entity.getReferenceNumber());
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute voidDateField
		voidDateField.sendKeys(entity.getVoidDate().toString());

		referenceDocumentField.sendKeys(entity.getReferenceDocument());
		// TODO default handling for dataAttribute requiredDateField
		requiredDateField.sendKeys(entity.getRequiredDate().toString());

		// TODO default handling for dataAttribute issuedDateTimeField
		issuedDateTimeField.sendKeys(entity.getIssuedDateTime().toString());

		// TODO default handling for dataAttribute receivedDateTimeField
		receivedDateTimeField.sendKeys(entity.getReceivedDateTime().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}