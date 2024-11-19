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
import kmsweb.entities.MedicationItemEntity;

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
 * Medication ItemPage is a Page POM that is associated with the admin/entities/medication-item url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicationItemCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='requestedQty-field']")
	private WebElement requestedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='outstandingQty-field']")
	private WebElement outstandingQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='returnedQty-field']")
	private WebElement returnedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='issuedQty-field']")
	private WebElement issuedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='administeredQty-field']")
	private WebElement administeredQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='takenHomeQty-field']")
	private WebElement takenHomeQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageFrequency-field']")
	private WebElement dosageFrequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dosageQty-field']")
	private WebElement dosageQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dose-field']")
	private WebElement doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='frequency-field']")
	private WebElement frequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionMethod-field']")
	private WebElement consumptionMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalPrice-field']")
	private WebElement totalPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='isDtd-field']")
	private WebElement isDtdField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalIssuedQuantity-field']")
	private WebElement totalIssuedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalAdministeredQuantity-field']")
	private WebElement totalAdministeredQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalTakenHomeQuantity-field']")
	private WebElement totalTakenHomeQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalReturnedQuantity-field']")
	private WebElement totalReturnedQuantityField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalMedicationName-field']")
	private WebElement externalMedicationNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingValue-field']")
	private WebElement inventoryRoundingValueField;
	@FindBy(how = How.XPATH, using = "//*[@id='dtdQuantity-field']")
	private WebElement dtdQuantityField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationAdministeredHisotriesIds-field']")
	private WebElement medicationAdministeredHisotriesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationCompoundId-field']")
	private WebElement medicationCompoundField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeaderId-field']")
	private WebElement medicationHeaderField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='unitOfMeasurementId-field']")
	private WebElement unitOfMeasurementField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicationItemCrudViewPage(
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
			"admin/entities/medication-item/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}