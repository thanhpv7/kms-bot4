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
import kmsweb.entities.HealthFacilityEntity;

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
 * Health FacilityPage is a Page POM that is associated with the admin/entities/health-facility url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesHealthFacilityCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityID-field']")
	private WebElement healthFacilityIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityName-field']")
	private WebElement healthFacilityNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='city-field']")
	private WebElement cityField;
	@FindBy(how = How.XPATH, using = "//*[@id='postCode-field']")
	private WebElement postCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='province-field']")
	private WebElement provinceField;
	@FindBy(how = How.XPATH, using = "//*[@id='country-field']")
	private WebElement countryField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='mobilePhoneNumber-field']")
	private WebElement mobilePhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='website-field']")
	private WebElement websiteField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='salutation-field']")
	private WebElement salutationField;
	@FindBy(how = How.XPATH, using = "//*[@id='firstName-field']")
	private WebElement firstNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastName-field']")
	private WebElement lastNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumberPOC-field']")
	private WebElement phoneNumberPOCField;
	@FindBy(how = How.XPATH, using = "//*[@id='mobilePhoneNumberPOC-field']")
	private WebElement mobilePhoneNumberPOCField;
	@FindBy(how = How.XPATH, using = "//*[@id='emailPOC-field']")
	private WebElement emailPOCField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityType-field']")
	private WebElement healthFacilityTypeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dismissalReferringFacilityIds-field']")
	private WebElement dismissalReferringFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='referringFacilityIds-field']")
	private WebElement referringFacilityField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesHealthFacilityCrudEditPage(
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
			"admin/entities/health-facility/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (HealthFacilityEntity) abstractEntity;
		healthFacilityIDField.sendKeys(entity.getHealthFacilityID());
		healthFacilityNameField.sendKeys(entity.getHealthFacilityName());
		addressField.sendKeys(entity.getAddress());
		cityField.sendKeys(entity.getCity());
		postCodeField.sendKeys(entity.getPostCode());
		provinceField.sendKeys(entity.getProvince());
		countryField.sendKeys(entity.getCountry());
		phoneNumberField.sendKeys(entity.getPhoneNumber());
		mobilePhoneNumberField.sendKeys(entity.getMobilePhoneNumber());
		websiteField.sendKeys(entity.getWebsite());
		emailField.sendKeys(entity.getEmail());
		salutationField.sendKeys(entity.getSalutation());
		firstNameField.sendKeys(entity.getFirstName());
		lastNameField.sendKeys(entity.getLastName());
		phoneNumberPOCField.sendKeys(entity.getPhoneNumberPOC());
		mobilePhoneNumberPOCField.sendKeys(entity.getMobilePhoneNumberPOC());
		emailPOCField.sendKeys(entity.getEmailPOC());
		healthFacilityTypeField.sendKeys(entity.getHealthFacilityType());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}