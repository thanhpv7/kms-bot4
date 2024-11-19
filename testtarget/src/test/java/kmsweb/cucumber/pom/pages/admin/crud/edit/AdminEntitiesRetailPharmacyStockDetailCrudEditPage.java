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
import kmsweb.entities.RetailPharmacyStockDetailEntity;

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
 * Retail Pharmacy Stock DetailPage is a Page POM that is associated with the admin/entities/retail-pharmacy-stock-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesRetailPharmacyStockDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='supplyStockGroup-field']")
	private WebElement supplyStockGroupField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	// TODO default handling dataAttribute availableQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableQuantity-field']")
	private WebElement availableQuantityField;
	// TODO default handling dataAttribute quantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantity-field']")
	private WebElement quantityField;
	// TODO default handling dataAttribute unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	// TODO default handling dataAttribute discountField;
	@FindBy(how = How.XPATH, using = "//*[@id='discount-field']")
	private WebElement discountField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxIncluded-field']")
	private WebElement taxIncludedField;
	// TODO default handling dataAttribute taxAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxAmount-field']")
	private WebElement taxAmountField;
	// TODO default handling dataAttribute totalItemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalItemPrice-field']")
	private WebElement totalItemPriceField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyId-field']")
	private WebElement retailPharmacyField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesRetailPharmacyStockDetailCrudEditPage(
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
			"admin/entities/retail-pharmacy-stock-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (RetailPharmacyStockDetailEntity) abstractEntity;
		supplyStockGroupField.sendKeys(entity.getSupplyStockGroup());
		uoiField.sendKeys(entity.getUoi());
		// TODO default handling for dataAttribute availableQuantityField
		availableQuantityField.sendKeys(entity.getAvailableQuantity().toString());

		// TODO default handling for dataAttribute quantityField
		quantityField.sendKeys(entity.getQuantity().toString());

		// TODO default handling for dataAttribute unitPriceField
		unitPriceField.sendKeys(entity.getUnitPrice().toString());

		// TODO default handling for dataAttribute discountField
		discountField.sendKeys(entity.getDiscount().toString());

		if (entity.getTaxIncluded()) {
			taxIncludedField.click();
		}
		// TODO default handling for dataAttribute taxAmountField
		taxAmountField.sendKeys(entity.getTaxAmount().toString());

		// TODO default handling for dataAttribute totalItemPriceField
		totalItemPriceField.sendKeys(entity.getTotalItemPrice().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}