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
import kmsweb.entities.PatientPersonalInfoEntity;

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
 * Patient Personal InfoPage is a Page POM that is associated with the admin/entities/patient-personal-info url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientPersonalInfoCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='religion-field']")
	private WebElement religionField;
	@FindBy(how = How.XPATH, using = "//*[@id='nationality-field']")
	private WebElement nationalityField;
	@FindBy(how = How.XPATH, using = "//*[@id='ethnicity-field']")
	private WebElement ethnicityField;
	@FindBy(how = How.XPATH, using = "//*[@id='bloodType-field']")
	private WebElement bloodTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='rhesus-field']")
	private WebElement rhesusField;
	@FindBy(how = How.XPATH, using = "//*[@id='idNumber-field']")
	private WebElement idNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='occupation-field']")
	private WebElement occupationField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalPatient-field']")
	private WebElement externalPatientField;
	@FindBy(how = How.XPATH, using = "//*[@id='isDead-field']")
	private WebElement isDeadField;
	@FindBy(how = How.XPATH, using = "//*[@id='externalNotes-field']")
	private WebElement externalNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherIDNumber-field']")
	private WebElement otherIDNumberField;
	

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
	public AdminEntitiesPatientPersonalInfoCrudEditPage(
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
			"admin/entities/patient-personal-info/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientPersonalInfoEntity) abstractEntity;
		religionField.sendKeys(entity.getReligion());
		nationalityField.sendKeys(entity.getNationality());
		ethnicityField.sendKeys(entity.getEthnicity());
		DropdownUtils.selectOptionByName(webDriver, bloodTypeField, entity.getBloodType().getLiteralValue());
		DropdownUtils.selectOptionByName(webDriver, rhesusField, entity.getRhesus().getLiteralValue());
		idNumberField.sendKeys(entity.getIdNumber());
		occupationField.sendKeys(entity.getOccupation());
		if (entity.getExternalPatient()) {
			externalPatientField.click();
		}
		if (entity.getIsDead()) {
			isDeadField.click();
		}
		externalNotesField.sendKeys(entity.getExternalNotes());
		otherIDNumberField.sendKeys(entity.getOtherIDNumber());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}