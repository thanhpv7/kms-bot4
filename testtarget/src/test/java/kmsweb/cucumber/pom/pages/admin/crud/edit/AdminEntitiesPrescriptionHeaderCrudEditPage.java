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
import kmsweb.entities.PrescriptionHeaderEntity;

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
 * Prescription HeaderPage is a Page POM that is associated with the admin/entities/prescription-header url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPrescriptionHeaderCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='prescriptionNumber-field']")
	private WebElement prescriptionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='prescriptionType-field']")
	private WebElement prescriptionTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='queueNo-field']")
	private WebElement queueNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='originalPrescriptionNumber-field']")
	private WebElement originalPrescriptionNumberField;
	// TODO default handling dataAttribute prescriptionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='prescriptionDate-field']")
	private WebElement prescriptionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='isCompound-field']")
	private WebElement isCompoundField;
	@FindBy(how = How.XPATH, using = "//*[@id='isIteration-field']")
	private WebElement isIterationField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
	@FindBy(how = How.XPATH, using = "//*[@id='isUrgent-field']")
	private WebElement isUrgentField;
	@FindBy(how = How.XPATH, using = "//*[@id='restricted-field']")
	private WebElement restrictedField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute revisionNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='revisionNo-field']")
	private WebElement revisionNoField;
	// TODO default handling dataAttribute copyNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='copyNo-field']")
	private WebElement copyNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='isInvoiced-field']")
	private WebElement isInvoicedField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalWarehouse-field']")
	private WebElement externalWarehouseField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes2-field']")
	private WebElement notes2Field;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceId-field']")
	private WebElement invoiceField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionCompoundsIds-field']")
	private WebElement prescriptionCompoundsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionItemsIds-field']")
	private WebElement prescriptionItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='requestedById-field']")
	private WebElement requestedByField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPrescriptionHeaderCrudEditPage(
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
			"admin/entities/prescription-header/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PrescriptionHeaderEntity) abstractEntity;
		prescriptionNumberField.sendKeys(entity.getPrescriptionNumber());
		prescriptionTypeField.sendKeys(entity.getPrescriptionType());
		queueNoField.sendKeys(entity.getQueueNo());
		originalPrescriptionNumberField.sendKeys(entity.getOriginalPrescriptionNumber());
		// TODO default handling for dataAttribute prescriptionDateField
		prescriptionDateField.sendKeys(entity.getPrescriptionDate().toString());

		if (entity.getIsCompound()) {
			isCompoundField.click();
		}
		if (entity.getIsIteration()) {
			isIterationField.click();
		}
		statusField.sendKeys(entity.getStatus());
		if (entity.getIsUrgent()) {
			isUrgentField.click();
		}
		if (entity.getRestricted()) {
			restrictedField.click();
		}
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute revisionNoField
		revisionNoField.sendKeys(entity.getRevisionNo().toString());

		// TODO default handling for dataAttribute copyNoField
		copyNoField.sendKeys(entity.getCopyNo().toString());

		if (entity.getIsInvoiced()) {
			isInvoicedField.click();
		}
		if (entity.getExternalWarehouse()) {
			externalWarehouseField.click();
		}
		notes2Field.sendKeys(entity.getNotes2());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}