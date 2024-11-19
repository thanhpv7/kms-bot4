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
import kmsweb.entities.DeliveryProgressEntity;

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
 * Delivery ProgressPage is a Page POM that is associated with the admin/entities/delivery-progress url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDeliveryProgressCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='progressDateTime-field']")
	private WebElement progressDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='fhrPerMinute-field']")
	private WebElement fhrPerMinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='amnioticFluid-field']")
	private WebElement amnioticFluidField;
	@FindBy(how = How.XPATH, using = "//*[@id='moulding-field']")
	private WebElement mouldingField;
	@FindBy(how = How.XPATH, using = "//*[@id='cervicalDilatation-field']")
	private WebElement cervicalDilatationField;
	@FindBy(how = How.XPATH, using = "//*[@id='fetalHeadDescent-field']")
	private WebElement fetalHeadDescentField;
	@FindBy(how = How.XPATH, using = "//*[@id='contractionQty-field']")
	private WebElement contractionQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='contractionMins-field']")
	private WebElement contractionMinsField;
	@FindBy(how = How.XPATH, using = "//*[@id='dripStrength-field']")
	private WebElement dripStrengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='dripNumber-field']")
	private WebElement dripNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='drugIV-field']")
	private WebElement drugIVField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulse-field']")
	private WebElement pulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperature-field']")
	private WebElement temperatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='temperatureUnit-field']")
	private WebElement temperatureUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='urineProtein-field']")
	private WebElement urineProteinField;
	@FindBy(how = How.XPATH, using = "//*[@id='urineAcetone-field']")
	private WebElement urineAcetoneField;
	@FindBy(how = How.XPATH, using = "//*[@id='urineVolume-field']")
	private WebElement urineVolumeField;
	@FindBy(how = How.XPATH, using = "//*[@id='progressNotes-field']")
	private WebElement progressNotesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='deliveryMedicalExaminationRecordId-field']")
	private WebElement deliveryMedicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDeliveryProgressCrudViewPage(
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
			"admin/entities/delivery-progress/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}