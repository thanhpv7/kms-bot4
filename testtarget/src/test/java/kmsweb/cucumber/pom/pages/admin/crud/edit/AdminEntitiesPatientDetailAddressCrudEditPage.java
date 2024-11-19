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
import kmsweb.entities.PatientDetailAddressEntity;

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
 * Patient Detail AddressPage is a Page POM that is associated with the admin/entities/patient-detail-address url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientDetailAddressCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='country-field']")
	private WebElement countryField;
	@FindBy(how = How.XPATH, using = "//*[@id='state-field']")
	private WebElement stateField;
	@FindBy(how = How.XPATH, using = "//*[@id='regency-field']")
	private WebElement regencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='district-field']")
	private WebElement districtField;
	@FindBy(how = How.XPATH, using = "//*[@id='village-field']")
	private WebElement villageField;
	@FindBy(how = How.XPATH, using = "//*[@id='postCode-field']")
	private WebElement postCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='rt-field']")
	private WebElement rtField;
	@FindBy(how = How.XPATH, using = "//*[@id='rw-field']")
	private WebElement rwField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInformationId-field']")
	private WebElement patientGeneralInformationField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPatientDetailAddressCrudEditPage(
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
			"admin/entities/patient-detail-address/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientDetailAddressEntity) abstractEntity;
		countryField.sendKeys(entity.getCountry());
		stateField.sendKeys(entity.getState());
		regencyField.sendKeys(entity.getRegency());
		districtField.sendKeys(entity.getDistrict());
		villageField.sendKeys(entity.getVillage());
		postCodeField.sendKeys(entity.getPostCode());
		rtField.sendKeys(entity.getRt());
		rwField.sendKeys(entity.getRw());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}