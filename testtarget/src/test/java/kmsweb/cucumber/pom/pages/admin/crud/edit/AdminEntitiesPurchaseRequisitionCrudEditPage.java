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
import kmsweb.entities.PurchaseRequisitionEntity;

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
 * Purchase RequisitionPage is a Page POM that is associated with the admin/entities/purchase-requisition url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPurchaseRequisitionCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='purchaseRequisitionNumber-field']")
	private WebElement purchaseRequisitionNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='transactionStatus-field']")
	private WebElement transactionStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='referenceDocument-field']")
	private WebElement referenceDocumentField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDate-field']")
	private WebElement orderDateField;
	// TODO default handling dataAttribute requiredDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='requiredDate-field']")
	private WebElement requiredDateField;
	// TODO default handling dataAttribute totalEstimationOrderField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalEstimationOrder-field']")
	private WebElement totalEstimationOrderField;
	// TODO default handling dataAttribute redraftingDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='redraftingDateTime-field']")
	private WebElement redraftingDateTimeField;
	// TODO default handling dataAttribute submissionDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='submissionDateTime-field']")
	private WebElement submissionDateTimeField;
	// TODO default handling dataAttribute approvalDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalDateTime-field']")
	private WebElement approvalDateTimeField;
	// TODO default handling dataAttribute rejectionDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='rejectionDateTime-field']")
	private WebElement rejectionDateTimeField;
	// TODO default handling dataAttribute voidingDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='voidingDateTime-field']")
	private WebElement voidingDateTimeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionStockDetailsIds-field']")
	private WebElement purchaseRequisitionStockDetailsField;

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
	public AdminEntitiesPurchaseRequisitionCrudEditPage(
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
			"admin/entities/purchase-requisition/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PurchaseRequisitionEntity) abstractEntity;
		purchaseRequisitionNumberField.sendKeys(entity.getPurchaseRequisitionNumber());
		transactionStatusField.sendKeys(entity.getTransactionStatus());
		referenceDocumentField.sendKeys(entity.getReferenceDocument());
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute orderDateField
		orderDateField.sendKeys(entity.getOrderDate().toString());

		// TODO default handling for dataAttribute requiredDateField
		requiredDateField.sendKeys(entity.getRequiredDate().toString());

		// TODO default handling for dataAttribute totalEstimationOrderField
		totalEstimationOrderField.sendKeys(entity.getTotalEstimationOrder().toString());

		// TODO default handling for dataAttribute redraftingDateTimeField
		redraftingDateTimeField.sendKeys(entity.getRedraftingDateTime().toString());

		// TODO default handling for dataAttribute submissionDateTimeField
		submissionDateTimeField.sendKeys(entity.getSubmissionDateTime().toString());

		// TODO default handling for dataAttribute approvalDateTimeField
		approvalDateTimeField.sendKeys(entity.getApprovalDateTime().toString());

		// TODO default handling for dataAttribute rejectionDateTimeField
		rejectionDateTimeField.sendKeys(entity.getRejectionDateTime().toString());

		// TODO default handling for dataAttribute voidingDateTimeField
		voidingDateTimeField.sendKeys(entity.getVoidingDateTime().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}