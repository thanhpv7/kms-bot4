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
public class AdminEntitiesCashReceiptCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='receiptType-field']")
	private WebElement receiptTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='receiptNumber-field']")
	private WebElement receiptNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentDate-field']")
	private WebElement paymentDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentType-field']")
	private WebElement paymentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='receiveAmount-field']")
	private WebElement receiveAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='isvoid-field']")
	private WebElement isvoidField;
	@FindBy(how = How.XPATH, using = "//*[@id='cashierLocation-field']")
	private WebElement cashierLocationField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidDateTime-field']")
	private WebElement voidDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='cashChangeType-field']")
	private WebElement cashChangeTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='changeAmount-field']")
	private WebElement changeAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedAmount-field']")
	private WebElement allocatedAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='roundingAmount-field']")
	private WebElement roundingAmountField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='surchargeAmount-field']")
	private WebElement surchargeAmountField;
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
	public AdminEntitiesCashReceiptCrudViewPage(
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
			"admin/entities/cash-receipt/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}