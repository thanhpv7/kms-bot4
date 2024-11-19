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
import kmsweb.entities.HospitalGroupInformationEntity;

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
 * Hospital Group InformationPage is a Page POM that is associated with the admin/entities/hospital-group-information url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesHospitalGroupInformationCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='hospitalGroupCode-field']")
	private WebElement hospitalGroupCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalGroupName-field']")
	private WebElement hospitalGroupNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalGroupCorporationName-field']")
	private WebElement hospitalGroupCorporationNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalGroupDirector-field']")
	private WebElement hospitalGroupDirectorField;
	@FindBy(how = How.XPATH, using = "//*[@id='operationalLicenseNo-field']")
	private WebElement operationalLicenseNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalGroupCorporationStatus-field']")
	private WebElement hospitalGroupCorporationStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='city-field']")
	private WebElement cityField;
	@FindBy(how = How.XPATH, using = "//*[@id='postcode-field']")
	private WebElement postcodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='fax-field']")
	private WebElement faxField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='website-field']")
	private WebElement websiteField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPerson-field']")
	private WebElement contactPersonField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPersonPhoneNumber-field']")
	private WebElement contactPersonPhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPersonEmail-field']")
	private WebElement contactPersonEmailField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hospitalBranchInformationsIds-field']")
	private WebElement hospitalBranchInformationsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesHospitalGroupInformationCrudViewPage(
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
			"admin/entities/hospital-group-information/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}