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
import kmsweb.entities.InvoiceSummaryEntity;

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
 * Invoice SummaryPage is a Page POM that is associated with the admin/entities/invoice-summary url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInvoiceSummaryCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute subTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='subTotal-field']")
	private WebElement subTotalField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxOnOtherDiscount-field']")
	private WebElement taxOnOtherDiscountField;
	// TODO default handling dataAttribute otherDiscountField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherDiscount-field']")
	private WebElement otherDiscountField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxOnOtherFee-field']")
	private WebElement taxOnOtherFeeField;
	// TODO default handling dataAttribute otherFeeField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherFee-field']")
	private WebElement otherFeeField;
	// TODO default handling dataAttribute taxField;
	@FindBy(how = How.XPATH, using = "//*[@id='tax-field']")
	private WebElement taxField;
	// TODO default handling dataAttribute totalInvoiceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalInvoice-field']")
	private WebElement totalInvoiceField;
	// TODO default handling dataAttribute availableDownPaymentField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableDownPayment-field']")
	private WebElement availableDownPaymentField;
	// TODO default handling dataAttribute totalCoverageField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalCoverage-field']")
	private WebElement totalCoverageField;
	// TODO default handling dataAttribute outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingAmount-field']")
	private WebElement outstandingAmountField;
	// TODO default handling dataAttribute bpjsCoverageField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCoverage-field']")
	private WebElement bpjsCoverageField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceId-field']")
	private WebElement invoiceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyInvoiceId-field']")
	private WebElement retailPharmacyInvoiceField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInvoiceSummaryCrudEditPage(
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
			"admin/entities/invoice-summary/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (InvoiceSummaryEntity) abstractEntity;
		// TODO default handling for dataAttribute subTotalField
		subTotalField.sendKeys(entity.getSubTotal().toString());

		if (entity.getTaxOnOtherDiscount()) {
			taxOnOtherDiscountField.click();
		}
		// TODO default handling for dataAttribute otherDiscountField
		otherDiscountField.sendKeys(entity.getOtherDiscount().toString());

		if (entity.getTaxOnOtherFee()) {
			taxOnOtherFeeField.click();
		}
		// TODO default handling for dataAttribute otherFeeField
		otherFeeField.sendKeys(entity.getOtherFee().toString());

		// TODO default handling for dataAttribute taxField
		taxField.sendKeys(entity.getTax().toString());

		// TODO default handling for dataAttribute totalInvoiceField
		totalInvoiceField.sendKeys(entity.getTotalInvoice().toString());

		// TODO default handling for dataAttribute availableDownPaymentField
		availableDownPaymentField.sendKeys(entity.getAvailableDownPayment().toString());

		// TODO default handling for dataAttribute totalCoverageField
		totalCoverageField.sendKeys(entity.getTotalCoverage().toString());

		// TODO default handling for dataAttribute outstandingAmountField
		outstandingAmountField.sendKeys(entity.getOutstandingAmount().toString());

		// TODO default handling for dataAttribute bpjsCoverageField
		bpjsCoverageField.sendKeys(entity.getBpjsCoverage().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}