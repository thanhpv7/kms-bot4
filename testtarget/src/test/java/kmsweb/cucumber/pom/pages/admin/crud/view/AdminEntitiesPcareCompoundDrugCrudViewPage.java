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
import kmsweb.entities.PcareCompoundDrugEntity;

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
 * PCare Compound DrugPage is a Page POM that is associated with the admin/entities/pcare-compound-drug url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPcareCompoundDrugCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='compoundName-field']")
	private WebElement compoundNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='signaDays-field']")
	private WebElement signaDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='signaTimes-field']")
	private WebElement signaTimesField;
	@FindBy(how = How.XPATH, using = "//*[@id='packageQty-field']")
	private WebElement packageQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='day-field']")
	private WebElement dayField;
	@FindBy(how = How.XPATH, using = "//*[@id='requestQty-field']")
	private WebElement requestQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdObatSK-field']")
	private WebElement kdObatSKField;
	@FindBy(how = How.XPATH, using = "//*[@id='racikan-field']")
	private WebElement racikanField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdRacikan-field']")
	private WebElement kdRacikanField;
	@FindBy(how = How.XPATH, using = "//*[@id='namaObatNonDPHO-field']")
	private WebElement namaObatNonDPHOField;
	@FindBy(how = How.XPATH, using = "//*[@id='drugQty-field']")
	private WebElement drugQtyField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareCompoundDrugItemsIds-field']")
	private WebElement pcareCompoundDrugItemsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareExaminationId-field']")
	private WebElement pcareExaminationField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPcareCompoundDrugCrudViewPage(
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
			"admin/entities/pcare-compound-drug/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}