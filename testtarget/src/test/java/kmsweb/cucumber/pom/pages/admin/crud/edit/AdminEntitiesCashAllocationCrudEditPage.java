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
import kmsweb.entities.CashAllocationEntity;

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
 * Cash AllocationPage is a Page POM that is associated with the admin/entities/cash-allocation url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesCashAllocationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='cashType-field']")
	private WebElement cashTypeField;
	// TODO default handling dataAttribute allocatedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedDate-field']")
	private WebElement allocatedDateField;
	// TODO default handling dataAttribute sourceDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceDate-field']")
	private WebElement sourceDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='cashNumber-field']")
	private WebElement cashNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceDocumentType-field']")
	private WebElement sourceDocumentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceNumber-field']")
	private WebElement sourceNumberField;
	// TODO default handling dataAttribute sourceAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='sourceAmount-field']")
	private WebElement sourceAmountField;
	// TODO default handling dataAttribute outstandingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingAmount-field']")
	private WebElement outstandingAmountField;
	// TODO default handling dataAttribute allocatedAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='allocatedAmount-field']")
	private WebElement allocatedAmountField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesCashAllocationCrudEditPage(
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
			"admin/entities/cash-allocation/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (CashAllocationEntity) abstractEntity;
		DropdownUtils.selectOptionByName(webDriver, cashTypeField, entity.getCashType().getLiteralValue());
		// TODO default handling for dataAttribute allocatedDateField
		allocatedDateField.sendKeys(entity.getAllocatedDate().toString());

		// TODO default handling for dataAttribute sourceDateField
		sourceDateField.sendKeys(entity.getSourceDate().toString());

		cashNumberField.sendKeys(entity.getCashNumber());
		DropdownUtils.selectOptionByName(webDriver, sourceDocumentTypeField, entity.getSourceDocumentType().getLiteralValue());
		sourceNumberField.sendKeys(entity.getSourceNumber());
		// TODO default handling for dataAttribute sourceAmountField
		sourceAmountField.sendKeys(entity.getSourceAmount().toString());

		// TODO default handling for dataAttribute outstandingAmountField
		outstandingAmountField.sendKeys(entity.getOutstandingAmount().toString());

		// TODO default handling for dataAttribute allocatedAmountField
		allocatedAmountField.sendKeys(entity.getAllocatedAmount().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}