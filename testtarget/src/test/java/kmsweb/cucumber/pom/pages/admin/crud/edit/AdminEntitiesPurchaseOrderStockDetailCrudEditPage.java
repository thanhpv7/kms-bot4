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
import kmsweb.entities.PurchaseOrderStockDetailEntity;

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
 * Purchase Order Stock DetailPage is a Page POM that is associated with the admin/entities/purchase-order-stock-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPurchaseOrderStockDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	// TODO default handling dataAttribute quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityOrdered-field']")
	private WebElement quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='uop-field']")
	private WebElement uopField;
	@FindBy(how = How.XPATH, using = "//*[@id='discountInPercent-field']")
	private WebElement discountInPercentField;
	// TODO default handling dataAttribute discountValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='discountValue-field']")
	private WebElement discountValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxable-field']")
	private WebElement taxableField;
	// TODO default handling dataAttribute itemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemPrice-field']")
	private WebElement itemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemStatus-field']")
	private WebElement itemStatusField;
	// TODO default handling dataAttribute sohField;
	@FindBy(how = How.XPATH, using = "//*[@id='soh-field']")
	private WebElement sohField;
	// TODO default handling dataAttribute maxLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='maxLevel-field']")
	private WebElement maxLevelField;
	// TODO default handling dataAttribute quantityReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReceived-field']")
	private WebElement quantityReceivedField;
	// TODO default handling dataAttribute quantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReturned-field']")
	private WebElement quantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	// TODO default handling dataAttribute remainingQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='remainingQuantity-field']")
	private WebElement remainingQuantityField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteItemsIds-field']")
	private WebElement goodsReceiveNoteItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrderId-field']")
	private WebElement purchaseOrderField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionStockDetailId-field']")
	private WebElement purchaseRequisitionStockDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPurchaseOrderStockDetailCrudEditPage(
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
			"admin/entities/purchase-order-stock-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PurchaseOrderStockDetailEntity) abstractEntity;
		// TODO default handling for dataAttribute unitPriceField
		unitPriceField.sendKeys(entity.getUnitPrice().toString());

		// TODO default handling for dataAttribute quantityOrderedField
		quantityOrderedField.sendKeys(entity.getQuantityOrdered().toString());

		uopField.sendKeys(entity.getUop());
		if (entity.getDiscountInPercent()) {
			discountInPercentField.click();
		}
		// TODO default handling for dataAttribute discountValueField
		discountValueField.sendKeys(entity.getDiscountValue().toString());

		if (entity.getTaxable()) {
			taxableField.click();
		}
		// TODO default handling for dataAttribute itemPriceField
		itemPriceField.sendKeys(entity.getItemPrice().toString());

		itemStatusField.sendKeys(entity.getItemStatus());
		// TODO default handling for dataAttribute sohField
		sohField.sendKeys(entity.getSoh().toString());

		// TODO default handling for dataAttribute maxLevelField
		maxLevelField.sendKeys(entity.getMaxLevel().toString());

		// TODO default handling for dataAttribute quantityReceivedField
		quantityReceivedField.sendKeys(entity.getQuantityReceived().toString());

		// TODO default handling for dataAttribute quantityReturnedField
		quantityReturnedField.sendKeys(entity.getQuantityReturned().toString());

		itemNotesField.sendKeys(entity.getItemNotes());
		// TODO default handling for dataAttribute remainingQuantityField
		remainingQuantityField.sendKeys(entity.getRemainingQuantity().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}