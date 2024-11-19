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
import kmsweb.entities.OphthalmologyExaminationEntity;

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
 * Ophthalmology ExaminationPage is a Page POM that is associated with the admin/entities/ophthalmology-examination url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesOphthalmologyExaminationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='rightEyelidSubjective-field']")
	private WebElement rightEyelidSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEyelidObjective-field']")
	private WebElement rightEyelidObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPupilSubjective-field']")
	private WebElement rightPupilSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPupilObjective-field']")
	private WebElement rightPupilObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightScleraSubjective-field']")
	private WebElement rightScleraSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightScleraObjective-field']")
	private WebElement rightScleraObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightIrisSubjective-field']")
	private WebElement rightIrisSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightIrisObjective-field']")
	private WebElement rightIrisObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEyelidSubjective-field']")
	private WebElement leftEyelidSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEyelidObjective-field']")
	private WebElement leftEyelidObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPupilSubjective-field']")
	private WebElement leftPupilSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPupilObjective-field']")
	private WebElement leftPupilObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftScleraSubjective-field']")
	private WebElement leftScleraSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftScleraObjective-field']")
	private WebElement leftScleraObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftIrisSubjective-field']")
	private WebElement leftIrisSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftIrisObjective-field']")
	private WebElement leftIrisObjectiveField;
	

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
	public AdminEntitiesOphthalmologyExaminationCrudEditPage(
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
			"admin/entities/ophthalmology-examination/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (OphthalmologyExaminationEntity) abstractEntity;
		rightEyelidSubjectiveField.sendKeys(entity.getRightEyelidSubjective());
		rightEyelidObjectiveField.sendKeys(entity.getRightEyelidObjective());
		rightPupilSubjectiveField.sendKeys(entity.getRightPupilSubjective());
		rightPupilObjectiveField.sendKeys(entity.getRightPupilObjective());
		rightScleraSubjectiveField.sendKeys(entity.getRightScleraSubjective());
		rightScleraObjectiveField.sendKeys(entity.getRightScleraObjective());
		rightIrisSubjectiveField.sendKeys(entity.getRightIrisSubjective());
		rightIrisObjectiveField.sendKeys(entity.getRightIrisObjective());
		leftEyelidSubjectiveField.sendKeys(entity.getLeftEyelidSubjective());
		leftEyelidObjectiveField.sendKeys(entity.getLeftEyelidObjective());
		leftPupilSubjectiveField.sendKeys(entity.getLeftPupilSubjective());
		leftPupilObjectiveField.sendKeys(entity.getLeftPupilObjective());
		leftScleraSubjectiveField.sendKeys(entity.getLeftScleraSubjective());
		leftScleraObjectiveField.sendKeys(entity.getLeftScleraObjective());
		leftIrisSubjectiveField.sendKeys(entity.getLeftIrisSubjective());
		leftIrisObjectiveField.sendKeys(entity.getLeftIrisObjective());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}