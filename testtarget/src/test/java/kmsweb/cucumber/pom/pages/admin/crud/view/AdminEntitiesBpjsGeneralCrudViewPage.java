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
import kmsweb.entities.BpjsGeneralEntity;

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
 * BPJS GeneralPage is a Page POM that is associated with the admin/entities/bpjs-general url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsGeneralCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='consID-field']")
	private WebElement consIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='secretKey-field']")
	private WebElement secretKeyField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsWebServiceURL-field']")
	private WebElement bpjsWebServiceURLField;
	@FindBy(how = How.XPATH, using = "//*[@id='aplicareWebServiceURL-field']")
	private WebElement aplicareWebServiceURLField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityCode-field']")
	private WebElement healthFacilityCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityName-field']")
	private WebElement healthFacilityNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='mjknWSBPJSURL-field']")
	private WebElement mjknWSBPJSURLField;
	@FindBy(how = How.XPATH, using = "//*[@id='mjknWSBPJSUserKey-field']")
	private WebElement mjknWSBPJSUserKeyField;
	@FindBy(how = How.XPATH, using = "//*[@id='vclaimUserKey-field']")
	private WebElement vclaimUserKeyField;
	@FindBy(how = How.XPATH, using = "//*[@id='connectToOtherSystem-field']")
	private WebElement connectToOtherSystemField;
	@FindBy(how = How.XPATH, using = "//*[@id='ismobilejkn-field']")
	private WebElement ismobilejknField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalSystemURL-field']")
	private WebElement externalSystemURLField;
	@FindBy(how = How.XPATH, using = "//*[@id='basicAuth-field']")
	private WebElement basicAuthField;
	@FindBy(how = How.XPATH, using = "//*[@id='basicAuthUsername-field']")
	private WebElement basicAuthUsernameField;
	@FindBy(how = How.XPATH, using = "//*[@id='basicAuthPassword-field']")
	private WebElement basicAuthPasswordField;
	@FindBy(how = How.XPATH, using = "//*[@id='bypassSSLValidation-field']")
	private WebElement bypassSSLValidationField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimStatus-field']")
	private WebElement claimStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityType-field']")
	private WebElement facilityTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sendNonJKN-field']")
	private WebElement sendNonJKNField;
	@FindBy(how = How.XPATH, using = "//*[@id='vclaimIntegration-field']")
	private WebElement vclaimIntegrationField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalVclaimServiceURL-field']")
	private WebElement externalVclaimServiceURLField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsGeneralCrudViewPage(
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
			"admin/entities/bpjs-general/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}