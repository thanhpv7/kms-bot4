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
package kmsweb.cucumber.pom.pages.admin.crud.view;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.PreoperativeRecordsEntity;

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
 * Preoperative RecordsPage is a Page POM that is associated with the admin/entities/preoperative-records url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPreoperativeRecordsCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='startDateTime-field']")
	private WebElement startDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='endDateTime-field']")
	private WebElement endDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='physicalStatusEvaluation-field']")
	private WebElement physicalStatusEvaluationField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryRisk-field']")
	private WebElement surgeryRiskField;
	@FindBy(how = How.XPATH, using = "//*[@id='psychologicalState-field']")
	private WebElement psychologicalStateField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaSurgeryRisk-field']")
	private WebElement anesthesiaSurgeryRiskField;
	@FindBy(how = How.XPATH, using = "//*[@id='preoperativeEvaluation-field']")
	private WebElement preoperativeEvaluationField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaNotes-field']")
	private WebElement anesthesiaNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgicalSpecialty-field']")
	private WebElement surgicalSpecialtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='antibioticProphylaxisGiven-field']")
	private WebElement antibioticProphylaxisGivenField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryType-field']")
	private WebElement surgeryTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryClass-field']")
	private WebElement surgeryClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgicalSurgeryRisk-field']")
	private WebElement surgicalSurgeryRiskField;
	@FindBy(how = How.XPATH, using = "//*[@id='physicalStatusClassification-field']")
	private WebElement physicalStatusClassificationField;
	@FindBy(how = How.XPATH, using = "//*[@id='preSurgeryDiagnosis-field']")
	private WebElement preSurgeryDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='preoperativeInstructions-field']")
	private WebElement preoperativeInstructionsField;
	@FindBy(how = How.XPATH, using = "//*[@id='preoperativeSurgicalNotes-field']")
	private WebElement preoperativeSurgicalNotesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingTheaterMedicalExaminationRecordId-field']")
	private WebElement operatingTheaterMedicalExaminationRecordField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='additionalAnesthesiologistsIds-field']")
	private WebElement additionalAnesthesiologistsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='additionalSurgeryNursesIds-field']")
	private WebElement additionalSurgeryNursesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilitiesIds-field']")
	private WebElement bedFacilitiesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='coTreatingAnesthesiologistsIds-field']")
	private WebElement coTreatingAnesthesiologistsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='coTreatingSurgeonsIds-field']")
	private WebElement coTreatingSurgeonsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiaMedicalTranscriberId-field']")
	private WebElement anesthesiaMedicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiologistId-field']")
	private WebElement anesthesiologistField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiologyNurseId-field']")
	private WebElement anesthesiologyNurseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preSurgeryICD10Id-field']")
	private WebElement preSurgeryICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preSurgeryICD9CMId-field']")
	private WebElement preSurgeryICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preoperativeRoomsId-field']")
	private WebElement preoperativeRoomsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgeonId-field']")
	private WebElement surgeonField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgicalMedicalTranscriberId-field']")
	private WebElement surgicalMedicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgicalNurseId-field']")
	private WebElement surgicalNurseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPreoperativeRecordsCrudViewPage(
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
			"admin/entities/preoperative-records/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}