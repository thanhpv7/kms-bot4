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
import kmsweb.entities.InventoryAdjustmentItemEntity;

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
 * Inventory Adjustment ItemPage is a Page POM that is associated with the admin/entities/inventory-adjustment-item url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInventoryAdjustmentItemCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='itemLineNumber-field']")
	private WebElement itemLineNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='originalSOH-field']")
	private WebElement originalSOHField;
	@FindBy(how = How.XPATH, using = "//*[@id='originalInventoryValue-field']")
	private WebElement originalInventoryValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='qty-field']")
	private WebElement qtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='uom-field']")
	private WebElement uomField;
	@FindBy(how = How.XPATH, using = "//*[@id='price-field']")
	private WebElement priceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalCost-field']")
	private WebElement totalCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='adjustedSoh-field']")
	private WebElement adjustedSohField;
	@FindBy(how = How.XPATH, using = "//*[@id='adjustedInventoryValue-field']")
	private WebElement adjustedInventoryValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='minimalLevel-field']")
	private WebElement minimalLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='maximalLevel-field']")
	private WebElement maximalLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='qtyUoi-field']")
	private WebElement qtyUoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='priceUoi-field']")
	private WebElement priceUoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjusmentBatchsIds-field']")
	private WebElement inventoryAdjusmentBatchsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjustmentId-field']")
	private WebElement inventoryAdjustmentField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInventoryAdjustmentItemCrudViewPage(
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
			"admin/entities/inventory-adjustment-item/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}