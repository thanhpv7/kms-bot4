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
import kmsweb.entities.DailyCareCPPTEntity;

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
 * Daily Care CPPTPage is a Page POM that is associated with the admin/entities/daily-care-cppt url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDailyCareCPPTCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='subjective-field']")
	private WebElement subjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='objective-field']")
	private WebElement objectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnose-field']")
	private WebElement diagnoseField;
	@FindBy(how = How.XPATH, using = "//*[@id='plan-field']")
	private WebElement planField;
	@FindBy(how = How.XPATH, using = "//*[@id='instruction-field']")
	private WebElement instructionField;
	// TODO default handling dataAttribute verifiedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='verifiedDate-field']")
	private WebElement verifiedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='verifiedBy-field']")
	private WebElement verifiedByField;
	// TODO default handling dataAttribute canceledDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='canceledDate-field']")
	private WebElement canceledDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='canceledBy-field']")
	private WebElement canceledByField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
	// TODO default handling dataAttribute cpptDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='cpptDateTime-field']")
	private WebElement cpptDateTimeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd10Id-field']")
	private WebElement icd10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd9CMId-field']")
	private WebElement icd9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='createdByStaffId-field']")
	private WebElement createdByStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorInChargeId-field']")
	private WebElement doctorInChargeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalTranscriberId-field']")
	private WebElement medicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDailyCareCPPTCrudEditPage(
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
			"admin/entities/daily-care-cppt/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (DailyCareCPPTEntity) abstractEntity;
		subjectiveField.sendKeys(entity.getSubjective());
		objectiveField.sendKeys(entity.getObjective());
		diagnoseField.sendKeys(entity.getDiagnose());
		planField.sendKeys(entity.getPlan());
		instructionField.sendKeys(entity.getInstruction());
		// TODO default handling for dataAttribute verifiedDateField
		verifiedDateField.sendKeys(entity.getVerifiedDate().toString());

		verifiedByField.sendKeys(entity.getVerifiedBy());
		// TODO default handling for dataAttribute canceledDateField
		canceledDateField.sendKeys(entity.getCanceledDate().toString());

		canceledByField.sendKeys(entity.getCanceledBy());
		statusField.sendKeys(entity.getStatus());
		// TODO default handling for dataAttribute cpptDateTimeField
		cpptDateTimeField.sendKeys(entity.getCpptDateTime().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}