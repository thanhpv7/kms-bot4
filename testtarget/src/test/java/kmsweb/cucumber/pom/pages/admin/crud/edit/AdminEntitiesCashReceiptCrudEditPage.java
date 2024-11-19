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
import kmsweb.entities.CashReceiptEntity;

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
 * Cash ReceiptPage is a Page POM that is associated with the admin/entities/cash-receipt url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesCashReceiptCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='receiptType-field']")
	private WebElement receiptTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='receiptNumber-field']")
	private WebElement receiptNumberField;
	// TODO default handling dataAttribute paymentDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentDate-field']")
	private WebElement paymentDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentType-field']")
	private WebElement paymentTypeField;
	// TODO default handling dataAttribute receiveAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='receiveAmount-field']")
	private WebElement receiveAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='isvoid-field']")
	private WebElement isvoidField;
	@FindBy(how = How.XPATH, using = "//*[@id='cashierLocation-field']")
	private WebElement cashierLocationField;
	// TODO default handling dataAttribute voidDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDateTime-field']")
	private WebElement voidDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='cashChangeType-field']")
	private WebElement cashChangeTypeField;
	// TODO default handling dataAttribute changeAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='changeAmount-field']")
	private WebElement changeAmountField;
	// TODO default handling dataAttribute allocatedAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedAmount-field']")
	private WebElement allocatedAmountField;
	// TODO default handling dataAttribute roundingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='roundingAmount-field']")
	private WebElement roundingAmountField;
	// TODO default handling dataAttribute availableAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableAmount-field']")
	private WebElement availableAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='bankName-field']")
	private WebElement bankNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='cardType-field']")
	private WebElement cardTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='cardNo-field']")
	private WebElement cardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='cardHolder-field']")
	private WebElement cardHolderField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceNumber-field']")
	private WebElement referenceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalBankAccount-field']")
	private WebElement hospitalBankAccountField;
	// TODO default handling dataAttribute surchargeAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='surchargeAmount-field']")
	private WebElement surchargeAmountField;
	// TODO default handling dataAttribute outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingAmount-field']")
	private WebElement outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='receivedFrom-field']")
	private WebElement receivedFromField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientOrCustomerName-field']")
	private WebElement patientOrCustomerNameField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='merchantId-field']")
	private WebElement merchantField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyInvoiceId-field']")
	private WebElement retailPharmacyInvoiceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cashierStaffId-field']")
	private WebElement cashierStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientId-field']")
	private WebElement patientField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesCashReceiptCrudEditPage(
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
			"admin/entities/cash-receipt/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (CashReceiptEntity) abstractEntity;
		DropdownUtils.selectOptionByName(webDriver, receiptTypeField, entity.getReceiptType().getLiteralValue());
		receiptNumberField.sendKeys(entity.getReceiptNumber());
		// TODO default handling for dataAttribute paymentDateField
		paymentDateField.sendKeys(entity.getPaymentDate().toString());

		descriptionField.sendKeys(entity.getDescription());
		paymentTypeField.sendKeys(entity.getPaymentType());
		// TODO default handling for dataAttribute receiveAmountField
		receiveAmountField.sendKeys(entity.getReceiveAmount().toString());

		if (entity.getIsvoid()) {
			isvoidField.click();
		}
		cashierLocationField.sendKeys(entity.getCashierLocation());
		// TODO default handling for dataAttribute voidDateTimeField
		voidDateTimeField.sendKeys(entity.getVoidDateTime().toString());

		DropdownUtils.selectOptionByName(webDriver, cashChangeTypeField, entity.getCashChangeType().getLiteralValue());
		// TODO default handling for dataAttribute changeAmountField
		changeAmountField.sendKeys(entity.getChangeAmount().toString());

		// TODO default handling for dataAttribute allocatedAmountField
		allocatedAmountField.sendKeys(entity.getAllocatedAmount().toString());

		// TODO default handling for dataAttribute roundingAmountField
		roundingAmountField.sendKeys(entity.getRoundingAmount().toString());

		// TODO default handling for dataAttribute availableAmountField
		availableAmountField.sendKeys(entity.getAvailableAmount().toString());

		bankNameField.sendKeys(entity.getBankName());
		cardTypeField.sendKeys(entity.getCardType());
		cardNoField.sendKeys(entity.getCardNo());
		cardHolderField.sendKeys(entity.getCardHolder());
		referenceNumberField.sendKeys(entity.getReferenceNumber());
		hospitalBankAccountField.sendKeys(entity.getHospitalBankAccount());
		// TODO default handling for dataAttribute surchargeAmountField
		surchargeAmountField.sendKeys(entity.getSurchargeAmount().toString());

		// TODO default handling for dataAttribute outstandingAmountField
		outstandingAmountField.sendKeys(entity.getOutstandingAmount().toString());

		receivedFromField.sendKeys(entity.getReceivedFrom());
		patientOrCustomerNameField.sendKeys(entity.getPatientOrCustomerName());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}