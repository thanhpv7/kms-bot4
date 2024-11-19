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
import kmsweb.entities.ReturnSupplierStockDetailEntity;

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
 * Return Supplier Stock DetailPage is a Page POM that is associated with the admin/entities/return-supplier-stock-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesReturnSupplierStockDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute priceField;
	@FindBy(how = How.XPATH, using = "//*[@id='price-field']")
	private WebElement priceField;
	// TODO default handling dataAttribute availableQuantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableQuantityReturned-field']")
	private WebElement availableQuantityReturnedField;
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
	// TODO default handling dataAttribute availableQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableQuantity-field']")
	private WebElement availableQuantityField;
	// TODO default handling dataAttribute quantityOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityOrdered-field']")
	private WebElement quantityOrderedField;
	// TODO default handling dataAttribute quantityReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityReceived-field']")
	private WebElement quantityReceivedField;
	// TODO default handling dataAttribute previousQuantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='previousQuantityReturned-field']")
	private WebElement previousQuantityReturnedField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='returnSupplierId-field']")
	private WebElement returnSupplierField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesReturnSupplierStockDetailCrudEditPage(
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
			"admin/entities/return-supplier-stock-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (ReturnSupplierStockDetailEntity) abstractEntity;
		// TODO default handling for dataAttribute priceField
		priceField.sendKeys(entity.getPrice().toString());

		// TODO default handling for dataAttribute availableQuantityReturnedField
		availableQuantityReturnedField.sendKeys(entity.getAvailableQuantityReturned().toString());

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

		// TODO default handling for dataAttribute availableQuantityField
		availableQuantityField.sendKeys(entity.getAvailableQuantity().toString());

		// TODO default handling for dataAttribute quantityOrderedField
		quantityOrderedField.sendKeys(entity.getQuantityOrdered().toString());

		// TODO default handling for dataAttribute quantityReceivedField
		quantityReceivedField.sendKeys(entity.getQuantityReceived().toString());

		// TODO default handling for dataAttribute previousQuantityReturnedField
		previousQuantityReturnedField.sendKeys(entity.getPreviousQuantityReturned().toString());

		itemNotesField.sendKeys(entity.getItemNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}