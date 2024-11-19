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
import kmsweb.entities.GoodsReceiveNoteEntity;

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
 * Goods Receive NotePage is a Page POM that is associated with the admin/entities/goods-receive-note url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesGoodsReceiveNoteCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='receiveNumber-field']")
	private WebElement receiveNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceDocumentType-field']")
	private WebElement sourceDocumentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceDocumentNumber-field']")
	private WebElement sourceDocumentNumberField;
	// TODO default handling dataAttribute receiveDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='receiveDate-field']")
	private WebElement receiveDateField;
	// TODO default handling dataAttribute voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDate-field']")
	private WebElement voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='supplierInvoiceNumber-field']")
	private WebElement supplierInvoiceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='shippingMethod-field']")
	private WebElement shippingMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='shippingNumber-field']")
	private WebElement shippingNumberField;
	// TODO default handling dataAttribute shippingDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='shippingDate-field']")
	private WebElement shippingDateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteItemsIds-field']")
	private WebElement goodsReceiveNoteItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrdersIds-field']")
	private WebElement purchaseOrdersField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='supplierId-field']")
	private WebElement supplierField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesGoodsReceiveNoteCrudEditPage(
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
			"admin/entities/goods-receive-note/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (GoodsReceiveNoteEntity) abstractEntity;
		receiveNumberField.sendKeys(entity.getReceiveNumber());
		DropdownUtils.selectOptionByName(webDriver, sourceDocumentTypeField, entity.getSourceDocumentType().getLiteralValue());
		sourceDocumentNumberField.sendKeys(entity.getSourceDocumentNumber());
		// TODO default handling for dataAttribute receiveDateField
		receiveDateField.sendKeys(entity.getReceiveDate().toString());

		// TODO default handling for dataAttribute voidDateField
		voidDateField.sendKeys(entity.getVoidDate().toString());

		approvalStatusField.sendKeys(entity.getApprovalStatus());
		notesField.sendKeys(entity.getNotes());
		supplierInvoiceNumberField.sendKeys(entity.getSupplierInvoiceNumber());
		shippingMethodField.sendKeys(entity.getShippingMethod());
		shippingNumberField.sendKeys(entity.getShippingNumber());
		// TODO default handling for dataAttribute shippingDateField
		shippingDateField.sendKeys(entity.getShippingDate().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}