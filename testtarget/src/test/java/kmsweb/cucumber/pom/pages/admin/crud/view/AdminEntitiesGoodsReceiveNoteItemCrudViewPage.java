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
import kmsweb.entities.GoodsReceiveNoteItemEntity;

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
 * Goods Receive Note ItemPage is a Page POM that is associated with the admin/entities/goods-receive-note-item url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesGoodsReceiveNoteItemCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='itemLineNumber-field']")
	private WebElement itemLineNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='uop-field']")
	private WebElement uopField;
	@FindBy(how = How.XPATH, using = "//*[@id='qtyReceived-field']")
	private WebElement qtyReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='qtyOrdered-field']")
	private WebElement qtyOrderedField;
	@FindBy(how = How.XPATH, using = "//*[@id='price-field']")
	private WebElement priceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalItemPrice-field']")
	private WebElement totalItemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemNotes-field']")
	private WebElement itemNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='prevQtyReceived-field']")
	private WebElement prevQtyReceivedField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='qtyReceivedUOI-field']")
	private WebElement qtyReceivedUOIField;
	@FindBy(how = How.XPATH, using = "//*[@id='priceUOI-field']")
	private WebElement priceUOIField;
	@FindBy(how = How.XPATH, using = "//*[@id='onHandQtyUOP-field']")
	private WebElement onHandQtyUOPField;
	@FindBy(how = How.XPATH, using = "//*[@id='maxLevelUOP-field']")
	private WebElement maxLevelUOPField;
	@FindBy(how = How.XPATH, using = "//*[@id='discountValue-field']")
	private WebElement discountValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxValue-field']")
	private WebElement taxValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='discountInPercent-field']")
	private WebElement discountInPercentField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxInPercent-field']")
	private WebElement taxInPercentField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteBatchsIds-field']")
	private WebElement goodsReceiveNoteBatchsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteId-field']")
	private WebElement goodsReceiveNoteField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrderStockDetailId-field']")
	private WebElement purchaseOrderStockDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesGoodsReceiveNoteItemCrudViewPage(
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
			"admin/entities/goods-receive-note-item/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}