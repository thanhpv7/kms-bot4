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
import kmsweb.entities.BpjsSearchSEPEntity;

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
 * BPJS Search SEPPage is a Page POM that is associated with the admin/entities/bpjs-search-sep url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsSearchSEPCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepDate-field']")
	private WebElement sepDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentType-field']")
	private WebElement treatmentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='polyclinic-field']")
	private WebElement polyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfBirth-field']")
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='provider-field']")
	private WebElement providerField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralProvider-field']")
	private WebElement referralProviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralSource-field']")
	private WebElement referralSourceField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralNo-field']")
	private WebElement referralNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralDate-field']")
	private WebElement referralDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnose-field']")
	private WebElement diagnoseField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsSearchSEPCrudEditPage(
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
			"admin/entities/bpjs-search-sep/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsSearchSEPEntity) abstractEntity;
		sepNoField.sendKeys(entity.getSepNo());
		sepDateField.sendKeys(entity.getSepDate());
		treatmentTypeField.sendKeys(entity.getTreatmentType());
		polyclinicField.sendKeys(entity.getPolyclinic());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		nameField.sendKeys(entity.getName());
		genderField.sendKeys(entity.getGender());
		dateOfBirthField.sendKeys(entity.getDateOfBirth());
		treatmentClassField.sendKeys(entity.getTreatmentClass());
		providerField.sendKeys(entity.getProvider());
		referralProviderField.sendKeys(entity.getReferralProvider());
		referralSourceField.sendKeys(entity.getReferralSource());
		referralNoField.sendKeys(entity.getReferralNo());
		referralDateField.sendKeys(entity.getReferralDate());
		diagnoseField.sendKeys(entity.getDiagnose());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}