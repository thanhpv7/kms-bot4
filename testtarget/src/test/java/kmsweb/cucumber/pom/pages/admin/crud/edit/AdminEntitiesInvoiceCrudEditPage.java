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
import kmsweb.entities.InvoiceEntity;

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
 * InvoicePage is a Page POM that is associated with the admin/entities/invoice url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInvoiceCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='invoiceNumber-field']")
	private WebElement invoiceNumberField;
	// TODO default handling dataAttribute revisionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='revisionNumber-field']")
	private WebElement revisionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceStatus-field']")
	private WebElement invoiceStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceType-field']")
	private WebElement invoiceTypeField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='displayICD10OnPrint-field']")
	private WebElement displayICD10OnPrintField;
	@FindBy(how = How.XPATH, using = "//*[@id='displayICD9CMOnPrint-field']")
	private WebElement displayICD9CMOnPrintField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorCode-field']")
	private WebElement doctorCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	// TODO default handling dataAttribute admissionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDate-field']")
	private WebElement admissionDateField;
	// TODO default handling dataAttribute dischargedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dischargedDate-field']")
	private WebElement dischargedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimNo-field']")
	private WebElement claimNoField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicePaymentOther-field']")
	private WebElement invoicePaymentOtherField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicePaymentSelfPaying-field']")
	private WebElement invoicePaymentSelfPayingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceSummary-field']")
	private WebElement invoiceSummaryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionHeader-field']")
	private WebElement prescriptionHeaderField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeaderId-field']")
	private WebElement medicationHeaderField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicePaymentInsurancesIds-field']")
	private WebElement invoicePaymentInsurancesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd10Id-field']")
	private WebElement icd10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd9CMId-field']")
	private WebElement icd9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilityId-field']")
	private WebElement bedFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVisitId-field']")
	private WebElement patientVisitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffSchemaId-field']")
	private WebElement tariffSchemaField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='verifiedById-field']")
	private WebElement verifiedByField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInvoiceCrudEditPage(
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
			"admin/entities/invoice/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (InvoiceEntity) abstractEntity;
		invoiceNumberField.sendKeys(entity.getInvoiceNumber());
		// TODO default handling for dataAttribute revisionNumberField
		revisionNumberField.sendKeys(entity.getRevisionNumber().toString());

		invoiceStatusField.sendKeys(entity.getInvoiceStatus());
		DropdownUtils.selectOptionByName(webDriver, invoiceTypeField, entity.getInvoiceType().getLiteralValue());
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
		if (entity.getDisplayICD10OnPrint()) {
			displayICD10OnPrintField.click();
		}
		if (entity.getDisplayICD9CMOnPrint()) {
			displayICD9CMOnPrintField.click();
		}
		doctorCodeField.sendKeys(entity.getDoctorCode());
		treatmentClassField.sendKeys(entity.getTreatmentClass());
		// TODO default handling for dataAttribute admissionDateField
		admissionDateField.sendKeys(entity.getAdmissionDate().toString());

		// TODO default handling for dataAttribute dischargedDateField
		dischargedDateField.sendKeys(entity.getDischargedDate().toString());

		claimNoField.sendKeys(entity.getClaimNo());

		tariffSchemaField.click();
		(new Actions(webDriver)).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}