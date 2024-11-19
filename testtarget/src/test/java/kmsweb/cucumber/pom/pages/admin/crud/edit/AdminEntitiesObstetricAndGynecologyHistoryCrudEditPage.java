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
import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;

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
 * Obstetric And Gynecology HistoryPage is a Page POM that is associated with the admin/entities/obstetric-and-gynecology-history url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesObstetricAndGynecologyHistoryCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryGravida-field']")
	private WebElement pregnancyHistoryGravidaField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientHistoryPara-field']")
	private WebElement patientHistoryParaField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientHistoryAbortus-field']")
	private WebElement patientHistoryAbortusField;
	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryNotes-field']")
	private WebElement pregnancyHistoryNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageOfMenarche-field']")
	private WebElement ageOfMenarcheField;
	@FindBy(how = How.XPATH, using = "//*[@id='ageOfFirstSexualContact-field']")
	private WebElement ageOfFirstSexualContactField;
	// TODO default handling dataAttribute startDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='startDate-field']")
	private WebElement startDateField;
	// TODO default handling dataAttribute endDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='endDate-field']")
	private WebElement endDateField;
	// TODO default handling dataAttribute approximateBirthDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approximateBirthDate-field']")
	private WebElement approximateBirthDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationAgeWeeks-field']")
	private WebElement gestationAgeWeeksField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationAgeDays-field']")
	private WebElement gestationAgeDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='maternityHistory-field']")
	private WebElement maternityHistoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='gynecologyHistory-field']")
	private WebElement gynecologyHistoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='familyPlanHistory-field']")
	private WebElement familyPlanHistoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherNotes-field']")
	private WebElement otherNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='educationLevelOfPatient-field']")
	private WebElement educationLevelOfPatientField;
	@FindBy(how = How.XPATH, using = "//*[@id='nameOfHusbandOrWife-field']")
	private WebElement nameOfHusbandOrWifeField;
	@FindBy(how = How.XPATH, using = "//*[@id='educationLevelOfHusbandOrWife-field']")
	private WebElement educationLevelOfHusbandOrWifeField;
	@FindBy(how = How.XPATH, using = "//*[@id='occupationOfHusbandOrWife-field']")
	private WebElement occupationOfHusbandOrWifeField;
	// TODO default handling dataAttribute ruptureOfMembraneField;
	@FindBy(how = How.XPATH, using = "//*[@id='ruptureOfMembrane-field']")
	private WebElement ruptureOfMembraneField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesObstetricAndGynecologyHistoryCrudEditPage(
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
			"admin/entities/obstetric-and-gynecology-history/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (ObstetricAndGynecologyHistoryEntity) abstractEntity;
		pregnancyHistoryGravidaField.sendKeys(entity.getPregnancyHistoryGravida());
		patientHistoryParaField.sendKeys(entity.getPatientHistoryPara());
		patientHistoryAbortusField.sendKeys(entity.getPatientHistoryAbortus());
		pregnancyHistoryNotesField.sendKeys(entity.getPregnancyHistoryNotes());
		ageOfMenarcheField.sendKeys(entity.getAgeOfMenarche());
		ageOfFirstSexualContactField.sendKeys(entity.getAgeOfFirstSexualContact());
		// TODO default handling for dataAttribute startDateField
		startDateField.sendKeys(entity.getStartDate().toString());

		// TODO default handling for dataAttribute endDateField
		endDateField.sendKeys(entity.getEndDate().toString());

		// TODO default handling for dataAttribute approximateBirthDateField
		approximateBirthDateField.sendKeys(entity.getApproximateBirthDate().toString());

		gestationAgeWeeksField.sendKeys(entity.getGestationAgeWeeks());
		gestationAgeDaysField.sendKeys(entity.getGestationAgeDays());
		maternityHistoryField.sendKeys(entity.getMaternityHistory());
		gynecologyHistoryField.sendKeys(entity.getGynecologyHistory());
		familyPlanHistoryField.sendKeys(entity.getFamilyPlanHistory());
		otherNotesField.sendKeys(entity.getOtherNotes());
		educationLevelOfPatientField.sendKeys(entity.getEducationLevelOfPatient());
		nameOfHusbandOrWifeField.sendKeys(entity.getNameOfHusbandOrWife());
		educationLevelOfHusbandOrWifeField.sendKeys(entity.getEducationLevelOfHusbandOrWife());
		occupationOfHusbandOrWifeField.sendKeys(entity.getOccupationOfHusbandOrWife());
		// TODO default handling for dataAttribute ruptureOfMembraneField
		ruptureOfMembraneField.sendKeys(entity.getRuptureOfMembrane().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}