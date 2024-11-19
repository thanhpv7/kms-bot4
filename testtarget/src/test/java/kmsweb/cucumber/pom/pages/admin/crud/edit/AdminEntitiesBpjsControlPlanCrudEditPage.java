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
import kmsweb.entities.BpjsControlPlanEntity;

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
 * BPJS Control PlanPage is a Page POM that is associated with the admin/entities/bpjs-control-plan url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsControlPlanCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='noSEP-field']")
	private WebElement noSEPField;
	@FindBy(how = How.XPATH, using = "//*[@id='controlLetterNo-field']")
	private WebElement controlLetterNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='controlPlanDate-field']")
	private WebElement controlPlanDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfBirth-field']")
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorCode-field']")
	private WebElement doctorCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='polyclinicCode-field']")
	private WebElement polyclinicCodeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDoctorMappingId-field']")
	private WebElement bpjsDoctorMappingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsServiceMappingId-field']")
	private WebElement bpjsServiceMappingField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsControlPlanCrudEditPage(
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
			"admin/entities/bpjs-control-plan/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsControlPlanEntity) abstractEntity;
		noSEPField.sendKeys(entity.getNoSEP());
		controlLetterNoField.sendKeys(entity.getControlLetterNo());
		controlPlanDateField.sendKeys(entity.getControlPlanDate());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		nameField.sendKeys(entity.getName());
		genderField.sendKeys(entity.getGender());
		dateOfBirthField.sendKeys(entity.getDateOfBirth());
		doctorCodeField.sendKeys(entity.getDoctorCode());
		polyclinicCodeField.sendKeys(entity.getPolyclinicCode());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}