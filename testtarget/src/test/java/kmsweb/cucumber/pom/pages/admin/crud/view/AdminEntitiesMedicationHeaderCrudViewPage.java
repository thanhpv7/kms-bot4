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
import kmsweb.entities.MedicationHeaderEntity;

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
 * Medication HeaderPage is a Page POM that is associated with the admin/entities/medication-header url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicationHeaderCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='medicationNumber-field']")
	private WebElement medicationNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='dispensingType-field']")
	private WebElement dispensingTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='originalMedicationNumber-field']")
	private WebElement originalMedicationNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='orderDate-field']")
	private WebElement orderDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='isUrgent-field']")
	private WebElement isUrgentField;
	@FindBy(how = How.XPATH, using = "//*[@id='isCompound-field']")
	private WebElement isCompoundField;
	@FindBy(how = How.XPATH, using = "//*[@id='revisionNo-field']")
	private WebElement revisionNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='isInvoiced-field']")
	private WebElement isInvoicedField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalWarehouse-field']")
	private WebElement externalWarehouseField;
	@FindBy(how = How.XPATH, using = "//*[@id='restricted-field']")
	private WebElement restrictedField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoice-field']")
	private WebElement invoiceField;

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemsIds-field']")
	private WebElement invoiceItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationCompoundsIds-field']")
	private WebElement medicationCompoundsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationItemsIds-field']")
	private WebElement medicationItemsField;

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
	public AdminEntitiesMedicationHeaderCrudViewPage(
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
			"admin/entities/medication-header/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}