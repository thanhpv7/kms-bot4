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
import kmsweb.entities.PostOperativeDetailsEntity;

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
 * Post Operative DetailsPage is a Page POM that is associated with the admin/entities/post-operative-details url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPostOperativeDetailsCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute recoveryStartDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='recoveryStartDateTime-field']")
	private WebElement recoveryStartDateTimeField;
	// TODO default handling dataAttribute recoveryEndDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='recoveryEndDateTime-field']")
	private WebElement recoveryEndDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='postoperativeMainDiagnosis-field']")
	private WebElement postoperativeMainDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='postoperativeAction-field']")
	private WebElement postoperativeActionField;
	@FindBy(how = How.XPATH, using = "//*[@id='newCase-field']")
	private WebElement newCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='postoperativeDiagnosisSupportOrder-field']")
	private WebElement postoperativeDiagnosisSupportOrderField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaPostoperativeMonitoring-field']")
	private WebElement anesthesiaPostoperativeMonitoringField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaPostoperativeAction-field']")
	private WebElement anesthesiaPostoperativeActionField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingTheaterMedicalExaminationRecordId-field']")
	private WebElement operatingTheaterMedicalExaminationRecordField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilitiesIds-field']")
	private WebElement bedFacilitiesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='postOperativeICD10Id-field']")
	private WebElement postOperativeICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='postOperativeICD9CMId-field']")
	private WebElement postOperativeICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='recoveryRoomsId-field']")
	private WebElement recoveryRoomsField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPostOperativeDetailsCrudEditPage(
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
			"admin/entities/post-operative-details/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PostOperativeDetailsEntity) abstractEntity;
		// TODO default handling for dataAttribute recoveryStartDateTimeField
		recoveryStartDateTimeField.sendKeys(entity.getRecoveryStartDateTime().toString());

		// TODO default handling for dataAttribute recoveryEndDateTimeField
		recoveryEndDateTimeField.sendKeys(entity.getRecoveryEndDateTime().toString());

		postoperativeMainDiagnosisField.sendKeys(entity.getPostoperativeMainDiagnosis());
		postoperativeActionField.sendKeys(entity.getPostoperativeAction());
		if (entity.getNewCase()) {
			newCaseField.click();
		}
		postoperativeDiagnosisSupportOrderField.sendKeys(entity.getPostoperativeDiagnosisSupportOrder());
		anesthesiaPostoperativeMonitoringField.sendKeys(entity.getAnesthesiaPostoperativeMonitoring());
		anesthesiaPostoperativeActionField.sendKeys(entity.getAnesthesiaPostoperativeAction());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}