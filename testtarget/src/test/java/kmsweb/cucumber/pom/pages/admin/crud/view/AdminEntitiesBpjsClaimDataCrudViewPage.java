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
import kmsweb.entities.BpjsClaimDataEntity;

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
 * BPJS Claim DataPage is a Page POM that is associated with the admin/entities/bpjs-claim-data url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsClaimDataCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='inacbgCode-field']")
	private WebElement inacbgCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgName-field']")
	private WebElement inacbgNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='submittedTariff-field']")
	private WebElement submittedTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='approval-field']")
	private WebElement approvalField;
	@FindBy(how = How.XPATH, using = "//*[@id='grouperTariff-field']")
	private WebElement grouperTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalTariff-field']")
	private WebElement hospitalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='topUp-field']")
	private WebElement topUpField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='fpkNo-field']")
	private WebElement fpkNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientID-field']")
	private WebElement patientIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='polyclinic-field']")
	private WebElement polyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepDate-field']")
	private WebElement sepDateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsClaimDataCrudViewPage(
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
			"admin/entities/bpjs-claim-data/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}