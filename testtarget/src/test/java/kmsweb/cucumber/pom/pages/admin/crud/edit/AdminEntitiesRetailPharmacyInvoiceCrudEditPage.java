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
import kmsweb.entities.RetailPharmacyInvoiceEntity;

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
 * Retail Pharmacy InvoicePage is a Page POM that is associated with the admin/entities/retail-pharmacy-invoice url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesRetailPharmacyInvoiceCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='invoiceNumber-field']")
	private WebElement invoiceNumberField;
	// TODO default handling dataAttribute revisionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='revisionNumber-field']")
	private WebElement revisionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceStatus-field']")
	private WebElement invoiceStatusField;
	// TODO default handling dataAttribute invoiceDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceDate-field']")
	private WebElement invoiceDateField;
	// TODO default handling dataAttribute cancelDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='cancelDate-field']")
	private WebElement cancelDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='billingLocation-field']")
	private WebElement billingLocationField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientPaymentType-field']")
	private WebElement patientPaymentTypeField;
	// TODO default handling dataAttribute verificationDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='verificationDate-field']")
	private WebElement verificationDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='displayDoctorOnPrint-field']")
	private WebElement displayDoctorOnPrintField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimNo-field']")
	private WebElement claimNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentStatus-field']")
	private WebElement paymentStatusField;
	// TODO default handling dataAttribute invoiceAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceAmount-field']")
	private WebElement invoiceAmountField;
	// TODO default handling dataAttribute outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingAmount-field']")
	private WebElement outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='customerName-field']")
	private WebElement customerNameField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceSummary-field']")
	private WebElement invoiceSummaryField;

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cashReceiptsIds-field']")
	private WebElement cashReceiptsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyId-field']")
	private WebElement retailPharmacyField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesRetailPharmacyInvoiceCrudEditPage(
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
			"admin/entities/retail-pharmacy-invoice/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (RetailPharmacyInvoiceEntity) abstractEntity;
		invoiceNumberField.sendKeys(entity.getInvoiceNumber());
		// TODO default handling for dataAttribute revisionNumberField
		revisionNumberField.sendKeys(entity.getRevisionNumber().toString());

		invoiceStatusField.sendKeys(entity.getInvoiceStatus());
		// TODO default handling for dataAttribute invoiceDateField
		invoiceDateField.sendKeys(entity.getInvoiceDate().toString());

		// TODO default handling for dataAttribute cancelDateField
		cancelDateField.sendKeys(entity.getCancelDate().toString());

		billingLocationField.sendKeys(entity.getBillingLocation());
		notesField.sendKeys(entity.getNotes());
		patientPaymentTypeField.sendKeys(entity.getPatientPaymentType());
		// TODO default handling for dataAttribute verificationDateField
		verificationDateField.sendKeys(entity.getVerificationDate().toString());

		if (entity.getDisplayDoctorOnPrint()) {
			displayDoctorOnPrintField.click();
		}
		claimNoField.sendKeys(entity.getClaimNo());
		paymentStatusField.sendKeys(entity.getPaymentStatus());
		// TODO default handling for dataAttribute invoiceAmountField
		invoiceAmountField.sendKeys(entity.getInvoiceAmount().toString());

		// TODO default handling for dataAttribute outstandingAmountField
		outstandingAmountField.sendKeys(entity.getOutstandingAmount().toString());

		customerNameField.sendKeys(entity.getCustomerName());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}