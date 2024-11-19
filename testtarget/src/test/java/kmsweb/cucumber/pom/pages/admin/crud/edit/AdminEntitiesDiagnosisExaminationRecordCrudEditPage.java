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
import kmsweb.entities.DiagnosisExaminationRecordEntity;

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
 * Diagnosis Examination RecordPage is a Page POM that is associated with the admin/entities/diagnosis-examination-record url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDiagnosisExaminationRecordCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute diagnosisSequenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosisSequence-field']")
	private WebElement diagnosisSequenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosisNotes-field']")
	private WebElement diagnosisNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='actionNotes-field']")
	private WebElement actionNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='newCase-field']")
	private WebElement newCaseField;
	// TODO default handling dataAttribute printingNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='printingNumber-field']")
	private WebElement printingNumberField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosticStaffExaminationSummary-field']")
	private WebElement diagnosticStaffExaminationSummaryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleCollectionInformation-field']")
	private WebElement sampleCollectionInformationField;

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordDischargeSummaryId-field']")
	private WebElement medicalExaminationRecordDischargeSummaryField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd10Id-field']")
	private WebElement icd10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd9CMId-field']")
	private WebElement icd9CMField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDiagnosisExaminationRecordCrudEditPage(
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
			"admin/entities/diagnosis-examination-record/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (DiagnosisExaminationRecordEntity) abstractEntity;
		// TODO default handling for dataAttribute diagnosisSequenceField
		diagnosisSequenceField.sendKeys(entity.getDiagnosisSequence().toString());

		diagnosisNotesField.sendKeys(entity.getDiagnosisNotes());
		actionNotesField.sendKeys(entity.getActionNotes());
		if (entity.getNewCase()) {
			newCaseField.click();
		}
		// TODO default handling for dataAttribute printingNumberField
		printingNumberField.sendKeys(entity.getPrintingNumber().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}