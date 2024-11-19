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
public class AdminEntitiesTransferOrderCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='transferOrderNumber-field']")
	private WebElement transferOrderNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionStatus-field']")
	private WebElement transactionStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDate-field']")
	private WebElement orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='expectedDate-field']")
	private WebElement expectedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceNumber-field']")
	private WebElement referenceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDate-field']")
	private WebElement voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceDocument-field']")
	private WebElement referenceDocumentField;
	@FindBy(how = How.XPATH, using = "//*[@id='requiredDate-field']")
	private WebElement requiredDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedDateTime-field']")
	private WebElement issuedDateTimeField;
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
	public AdminEntitiesTransferOrderCrudViewPage(
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
			"admin/entities/transfer-order/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}