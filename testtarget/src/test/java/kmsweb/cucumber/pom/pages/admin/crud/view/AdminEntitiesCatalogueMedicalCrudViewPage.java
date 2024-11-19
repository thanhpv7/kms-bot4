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
import kmsweb.entities.CatalogueMedicalEntity;

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
 * Catalogue Medical Page is a Page POM that is associated with the admin/entities/catalogue-medical url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesCatalogueMedicalCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='composition-field']")
	private WebElement compositionField;
	@FindBy(how = How.XPATH, using = "//*[@id='canBePrescribed-field']")
	private WebElement canBePrescribedField;
	@FindBy(how = How.XPATH, using = "//*[@id='isHospitalFormulary-field']")
	private WebElement isHospitalFormularyField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalNotes-field']")
	private WebElement approvalNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='isGeneric-field']")
	private WebElement isGenericField;
	@FindBy(how = How.XPATH, using = "//*[@id='isRestricted-field']")
	private WebElement isRestrictedField;
	@FindBy(how = How.XPATH, using = "//*[@id='isVaccine-field']")
	private WebElement isVaccineField;
	@FindBy(how = How.XPATH, using = "//*[@id='vaccineType-field']")
	private WebElement vaccineTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionMethod-field']")
	private WebElement consumptionMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='consumptionUnit-field']")
	private WebElement consumptionUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='compoundChargingRounding-field']")
	private WebElement compoundChargingRoundingField;
	@FindBy(how = How.XPATH, using = "//*[@id='compoundChargingRoundingAmount-field']")
	private WebElement compoundChargingRoundingAmountField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRounding-field']")
	private WebElement inventoryRoundingField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryRoundingAmount-field']")
	private WebElement inventoryRoundingAmountField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesCatalogueMedicalCrudViewPage(
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
			"admin/entities/catalogue-medical/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}