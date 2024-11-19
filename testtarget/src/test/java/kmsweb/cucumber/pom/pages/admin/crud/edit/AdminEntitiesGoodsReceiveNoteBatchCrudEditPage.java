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
import kmsweb.entities.GoodsReceiveNoteBatchEntity;

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
 * Goods Receive Note BatchPage is a Page POM that is associated with the admin/entities/goods-receive-note-batch url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesGoodsReceiveNoteBatchCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute itemLineNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemLineNumber-field']")
	private WebElement itemLineNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionNumber-field']")
	private WebElement transactionNumberField;
	// TODO default handling dataAttribute transactionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionDate-field']")
	private WebElement transactionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='batchNumber-field']")
	private WebElement batchNumberField;
	// TODO default handling dataAttribute expirationDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='expirationDate-field']")
	private WebElement expirationDateField;
	// TODO default handling dataAttribute batchQtyUOMTransactionField;
	@FindBy(how = How.XPATH, using = "//*[@id='batchQtyUOMTransaction-field']")
	private WebElement batchQtyUOMTransactionField;
	@FindBy(how = How.XPATH, using = "//*[@id='uomTransaction-field']")
	private WebElement uomTransactionField;
	// TODO default handling dataAttribute batchQtyUOIField;
	@FindBy(how = How.XPATH, using = "//*[@id='batchQtyUOI-field']")
	private WebElement batchQtyUOIField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='batchItemNotes-field']")
	private WebElement batchItemNotesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteItemId-field']")
	private WebElement goodsReceiveNoteItemField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesGoodsReceiveNoteBatchCrudEditPage(
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
			"admin/entities/goods-receive-note-batch/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (GoodsReceiveNoteBatchEntity) abstractEntity;
		// TODO default handling for dataAttribute itemLineNumberField
		itemLineNumberField.sendKeys(entity.getItemLineNumber().toString());

		transactionNumberField.sendKeys(entity.getTransactionNumber());
		// TODO default handling for dataAttribute transactionDateField
		transactionDateField.sendKeys(entity.getTransactionDate().toString());

		batchNumberField.sendKeys(entity.getBatchNumber());
		// TODO default handling for dataAttribute expirationDateField
		expirationDateField.sendKeys(entity.getExpirationDate().toString());

		// TODO default handling for dataAttribute batchQtyUOMTransactionField
		batchQtyUOMTransactionField.sendKeys(entity.getBatchQtyUOMTransaction().toString());

		uomTransactionField.sendKeys(entity.getUomTransaction());
		// TODO default handling for dataAttribute batchQtyUOIField
		batchQtyUOIField.sendKeys(entity.getBatchQtyUOI().toString());

		uoiField.sendKeys(entity.getUoi());
		batchItemNotesField.sendKeys(entity.getBatchItemNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}