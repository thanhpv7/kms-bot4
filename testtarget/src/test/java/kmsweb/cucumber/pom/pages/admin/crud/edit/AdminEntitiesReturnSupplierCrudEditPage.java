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
import kmsweb.entities.ReturnSupplierEntity;

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
 * Return SupplierPage is a Page POM that is associated with the admin/entities/return-supplier url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesReturnSupplierCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='returnNumber-field']")
	private WebElement returnNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	// TODO default handling dataAttribute returnDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='returnDate-field']")
	private WebElement returnDateField;
	// TODO default handling dataAttribute orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDate-field']")
	private WebElement orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceReturnNumber-field']")
	private WebElement invoiceReturnNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxInvoiceNumber-field']")
	private WebElement taxInvoiceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='priceVATIncluded-field']")
	private WebElement priceVATIncludedField;
	// TODO default handling dataAttribute voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDate-field']")
	private WebElement voidDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidReason-field']")
	private WebElement voidReasonField;
	// TODO default handling dataAttribute subTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='subTotal-field']")
	private WebElement subTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='extraDiscountInPercentage-field']")
	private WebElement extraDiscountInPercentageField;
	@FindBy(how = How.XPATH, using = "//*[@id='extraDiscountIncludeTax-field']")
	private WebElement extraDiscountIncludeTaxField;
	// TODO default handling dataAttribute extraDiscountValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='extraDiscountValue-field']")
	private WebElement extraDiscountValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='freightFeeIncludeTax-field']")
	private WebElement freightFeeIncludeTaxField;
	// TODO default handling dataAttribute freightFeeValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='freightFeeValue-field']")
	private WebElement freightFeeValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherFeeIncludeTax-field']")
	private WebElement otherFeeIncludeTaxField;
	// TODO default handling dataAttribute otherFeeValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherFeeValue-field']")
	private WebElement otherFeeValueField;
	// TODO default handling dataAttribute taxBaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxBase-field']")
	private WebElement taxBaseField;
	// TODO default handling dataAttribute taxAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxAmount-field']")
	private WebElement taxAmountField;
	// TODO default handling dataAttribute totalAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalAmount-field']")
	private WebElement totalAmountField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='returnSupplierStockDetailsIds-field']")
	private WebElement returnSupplierStockDetailsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrderId-field']")
	private WebElement purchaseOrderField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='supplierId-field']")
	private WebElement supplierField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesReturnSupplierCrudEditPage(
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
			"admin/entities/return-supplier/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (ReturnSupplierEntity) abstractEntity;
		returnNumberField.sendKeys(entity.getReturnNumber());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		// TODO default handling for dataAttribute returnDateField
		returnDateField.sendKeys(entity.getReturnDate().toString());

		// TODO default handling for dataAttribute orderDateField
		orderDateField.sendKeys(entity.getOrderDate().toString());

		notesField.sendKeys(entity.getNotes());
		invoiceReturnNumberField.sendKeys(entity.getInvoiceReturnNumber());
		taxInvoiceNumberField.sendKeys(entity.getTaxInvoiceNumber());
		if (entity.getPriceVATIncluded()) {
			priceVATIncludedField.click();
		}
		// TODO default handling for dataAttribute voidDateField
		voidDateField.sendKeys(entity.getVoidDate().toString());

		voidReasonField.sendKeys(entity.getVoidReason());
		// TODO default handling for dataAttribute subTotalField
		subTotalField.sendKeys(entity.getSubTotal().toString());

		if (entity.getExtraDiscountInPercentage()) {
			extraDiscountInPercentageField.click();
		}
		if (entity.getExtraDiscountIncludeTax()) {
			extraDiscountIncludeTaxField.click();
		}
		// TODO default handling for dataAttribute extraDiscountValueField
		extraDiscountValueField.sendKeys(entity.getExtraDiscountValue().toString());

		if (entity.getFreightFeeIncludeTax()) {
			freightFeeIncludeTaxField.click();
		}
		// TODO default handling for dataAttribute freightFeeValueField
		freightFeeValueField.sendKeys(entity.getFreightFeeValue().toString());

		if (entity.getOtherFeeIncludeTax()) {
			otherFeeIncludeTaxField.click();
		}
		// TODO default handling for dataAttribute otherFeeValueField
		otherFeeValueField.sendKeys(entity.getOtherFeeValue().toString());

		// TODO default handling for dataAttribute taxBaseField
		taxBaseField.sendKeys(entity.getTaxBase().toString());

		// TODO default handling for dataAttribute taxAmountField
		taxAmountField.sendKeys(entity.getTaxAmount().toString());

		// TODO default handling for dataAttribute totalAmountField
		totalAmountField.sendKeys(entity.getTotalAmount().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}