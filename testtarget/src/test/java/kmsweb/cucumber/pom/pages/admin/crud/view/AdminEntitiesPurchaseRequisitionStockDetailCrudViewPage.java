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
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;

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
 * Purchase Requisition Stock DetailPage is a Page POM that is associated with the admin/entities/purchase-requisition-stock-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPurchaseRequisitionStockDetailCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='soh-field']")
	private WebElement sohField;
	@FindBy(how = How.XPATH, using = "//*[@id='maxLevel-field']")
	private WebElement maxLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityRequested-field']")
	private WebElement quantityRequestedField;
	@FindBy(how = How.XPATH, using = "//*[@id='uop-field']")
	private WebElement uopField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemStatus-field']")
	private WebElement itemStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityOrdered-field']")
	private WebElement quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReceived-field']")
	private WebElement quantityReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReturned-field']")
	private WebElement quantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='remainingQuantity-field']")
	private WebElement remainingQuantityField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrderStockDetailsIds-field']")
	private WebElement purchaseOrderStockDetailsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionId-field']")
	private WebElement purchaseRequisitionField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPurchaseRequisitionStockDetailCrudViewPage(
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
			"admin/entities/purchase-requisition-stock-detail/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}