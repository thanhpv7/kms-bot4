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
import kmsweb.entities.BpjsINACBGEntity;

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
 * BPJS INACBGPage is a Page POM that is associated with the admin/entities/bpjs-inacbg url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsINACBGCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityCode-field']")
	private WebElement healthFacilityCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityName-field']")
	private WebElement healthFacilityNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='stateProvince-field']")
	private WebElement stateProvinceField;
	@FindBy(how = How.XPATH, using = "//*[@id='cityRegency-field']")
	private WebElement cityRegencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='regional-field']")
	private WebElement regionalField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalClass-field']")
	private WebElement hospitalClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgTariff1-field']")
	private WebElement inacbgTariff1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgTariff2-field']")
	private WebElement inacbgTariff2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='additionalUpgradeVIP-field']")
	private WebElement additionalUpgradeVIPField;
	@FindBy(how = How.XPATH, using = "//*[@id='payplanID-field']")
	private WebElement payplanIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='paymentPlanCode-field']")
	private WebElement paymentPlanCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffCode-field']")
	private WebElement tariffCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='url-field']")
	private WebElement urlField;
	@FindBy(how = How.XPATH, using = "//*[@id='username-field']")
	private WebElement usernameField;
	@FindBy(how = How.XPATH, using = "//*[@id='password-field']")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//*[@id='secretKey-field']")
	private WebElement secretKeyField;
	@FindBy(how = How.XPATH, using = "//*[@id='coderID-field']")
	private WebElement coderIDField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsINACBGCrudEditPage(
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
			"admin/entities/bpjs-inacbg/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsINACBGEntity) abstractEntity;
		healthFacilityCodeField.sendKeys(entity.getHealthFacilityCode());
		healthFacilityNameField.sendKeys(entity.getHealthFacilityName());
		addressField.sendKeys(entity.getAddress());
		stateProvinceField.sendKeys(entity.getStateProvince());
		cityRegencyField.sendKeys(entity.getCityRegency());
		regionalField.sendKeys(entity.getRegional());
		hospitalClassField.sendKeys(entity.getHospitalClass());
		inacbgTariff1Field.sendKeys(entity.getInacbgTariff1());
		inacbgTariff2Field.sendKeys(entity.getInacbgTariff2());
		additionalUpgradeVIPField.sendKeys(entity.getAdditionalUpgradeVIP());
		payplanIDField.sendKeys(entity.getPayplanID());
		paymentPlanCodeField.sendKeys(entity.getPaymentPlanCode());
		tariffCodeField.sendKeys(entity.getTariffCode());
		urlField.sendKeys(entity.getUrl());
		usernameField.sendKeys(entity.getUsername());
		passwordField.sendKeys(entity.getPassword());
		secretKeyField.sendKeys(entity.getSecretKey());
		coderIDField.sendKeys(entity.getCoderID());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}