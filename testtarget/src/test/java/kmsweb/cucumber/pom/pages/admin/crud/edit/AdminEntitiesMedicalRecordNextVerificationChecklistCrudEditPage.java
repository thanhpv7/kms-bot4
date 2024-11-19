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
import kmsweb.entities.MedicalRecordNextVerificationChecklistEntity;

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
 * Medical Record Next Verification ChecklistPage is a Page POM that is associated with the admin/entities/medical-record-next-verification-checklist url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicalRecordNextVerificationChecklistCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='outVitalSign-field']")
	private WebElement outVitalSignField;
	@FindBy(how = How.XPATH, using = "//*[@id='outAnamnesis-field']")
	private WebElement outAnamnesisField;
	@FindBy(how = How.XPATH, using = "//*[@id='outPhysicalExamination-field']")
	private WebElement outPhysicalExaminationField;
	@FindBy(how = How.XPATH, using = "//*[@id='outDiagnosis-field']")
	private WebElement outDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='outDismissalType-field']")
	private WebElement outDismissalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='outDismissalDateAndTime-field']")
	private WebElement outDismissalDateAndTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpVitalSign-field']")
	private WebElement inpVitalSignField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareDoctorNotes-field']")
	private WebElement inpDailyCareDoctorNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareDoctorNotesNA-field']")
	private WebElement inpDailyCareDoctorNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareNursingNotes-field']")
	private WebElement inpDailyCareNursingNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareNursingNotesNA-field']")
	private WebElement inpDailyCareNursingNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareProgressNotes-field']")
	private WebElement inpDailyCareProgressNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDailyCareProgressNotesNA-field']")
	private WebElement inpDailyCareProgressNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDismissalDiagnosis-field']")
	private WebElement inpDismissalDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDismissalType-field']")
	private WebElement inpDismissalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDismissalDateAndTime-field']")
	private WebElement inpDismissalDateAndTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='inpDismissalCondition-field']")
	private WebElement inpDismissalConditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='drAdmissionDiagnosis-field']")
	private WebElement drAdmissionDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationDoctorNotes-field']")
	private WebElement drObservationDoctorNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationDoctorNotesNA-field']")
	private WebElement drObservationDoctorNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationNursingNotes-field']")
	private WebElement drObservationNursingNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationNursingNotesNA-field']")
	private WebElement drObservationNursingNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationProgressNotes-field']")
	private WebElement drObservationProgressNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='drObservationProgressNotesNA-field']")
	private WebElement drObservationProgressNotesNAField;
	@FindBy(how = How.XPATH, using = "//*[@id='drDismissalDiagnosis-field']")
	private WebElement drDismissalDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='drDismissalType-field']")
	private WebElement drDismissalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='drDismissalDateAndTime-field']")
	private WebElement drDismissalDateAndTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPreOperativeDiagnosis-field']")
	private WebElement otPreOperativeDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPreOperativeNotesSurgery-field']")
	private WebElement otPreOperativeNotesSurgeryField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPreOperativeNotesAnaesthesiology-field']")
	private WebElement otPreOperativeNotesAnaesthesiologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='otIntraOperativeNotesSurgery-field']")
	private WebElement otIntraOperativeNotesSurgeryField;
	@FindBy(how = How.XPATH, using = "//*[@id='otIntraOperativeNotesAnaesthesiology-field']")
	private WebElement otIntraOperativeNotesAnaesthesiologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPostOperativeNotesSurgery-field']")
	private WebElement otPostOperativeNotesSurgeryField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPostOperativeNotesAnaesthesiology-field']")
	private WebElement otPostOperativeNotesAnaesthesiologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='otPostOperativeDiagnosis-field']")
	private WebElement otPostOperativeDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='otDismissalType-field']")
	private WebElement otDismissalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='otDismissalDateAndTime-field']")
	private WebElement otDismissalDateAndTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dsResponsibleStaff-field']")
	private WebElement dsResponsibleStaffField;
	@FindBy(how = How.XPATH, using = "//*[@id='dsInterpretation-field']")
	private WebElement dsInterpretationField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

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
	public AdminEntitiesMedicalRecordNextVerificationChecklistCrudEditPage(
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
			"admin/entities/medical-record-next-verification-checklist/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicalRecordNextVerificationChecklistEntity) abstractEntity;
		if (entity.getOutVitalSign()) {
			outVitalSignField.click();
		}
		if (entity.getOutAnamnesis()) {
			outAnamnesisField.click();
		}
		if (entity.getOutPhysicalExamination()) {
			outPhysicalExaminationField.click();
		}
		if (entity.getOutDiagnosis()) {
			outDiagnosisField.click();
		}
		if (entity.getOutDismissalType()) {
			outDismissalTypeField.click();
		}
		if (entity.getOutDismissalDateAndTime()) {
			outDismissalDateAndTimeField.click();
		}
		if (entity.getInpVitalSign()) {
			inpVitalSignField.click();
		}
		if (entity.getInpDailyCareDoctorNotes()) {
			inpDailyCareDoctorNotesField.click();
		}
		if (entity.getInpDailyCareDoctorNotesNA()) {
			inpDailyCareDoctorNotesNAField.click();
		}
		if (entity.getInpDailyCareNursingNotes()) {
			inpDailyCareNursingNotesField.click();
		}
		if (entity.getInpDailyCareNursingNotesNA()) {
			inpDailyCareNursingNotesNAField.click();
		}
		if (entity.getInpDailyCareProgressNotes()) {
			inpDailyCareProgressNotesField.click();
		}
		if (entity.getInpDailyCareProgressNotesNA()) {
			inpDailyCareProgressNotesNAField.click();
		}
		if (entity.getInpDismissalDiagnosis()) {
			inpDismissalDiagnosisField.click();
		}
		if (entity.getInpDismissalType()) {
			inpDismissalTypeField.click();
		}
		if (entity.getInpDismissalDateAndTime()) {
			inpDismissalDateAndTimeField.click();
		}
		if (entity.getInpDismissalCondition()) {
			inpDismissalConditionField.click();
		}
		if (entity.getDrAdmissionDiagnosis()) {
			drAdmissionDiagnosisField.click();
		}
		if (entity.getDrObservationDoctorNotes()) {
			drObservationDoctorNotesField.click();
		}
		if (entity.getDrObservationDoctorNotesNA()) {
			drObservationDoctorNotesNAField.click();
		}
		if (entity.getDrObservationNursingNotes()) {
			drObservationNursingNotesField.click();
		}
		if (entity.getDrObservationNursingNotesNA()) {
			drObservationNursingNotesNAField.click();
		}
		if (entity.getDrObservationProgressNotes()) {
			drObservationProgressNotesField.click();
		}
		if (entity.getDrObservationProgressNotesNA()) {
			drObservationProgressNotesNAField.click();
		}
		if (entity.getDrDismissalDiagnosis()) {
			drDismissalDiagnosisField.click();
		}
		if (entity.getDrDismissalType()) {
			drDismissalTypeField.click();
		}
		if (entity.getDrDismissalDateAndTime()) {
			drDismissalDateAndTimeField.click();
		}
		if (entity.getOtPreOperativeDiagnosis()) {
			otPreOperativeDiagnosisField.click();
		}
		if (entity.getOtPreOperativeNotesSurgery()) {
			otPreOperativeNotesSurgeryField.click();
		}
		if (entity.getOtPreOperativeNotesAnaesthesiology()) {
			otPreOperativeNotesAnaesthesiologyField.click();
		}
		if (entity.getOtIntraOperativeNotesSurgery()) {
			otIntraOperativeNotesSurgeryField.click();
		}
		if (entity.getOtIntraOperativeNotesAnaesthesiology()) {
			otIntraOperativeNotesAnaesthesiologyField.click();
		}
		if (entity.getOtPostOperativeNotesSurgery()) {
			otPostOperativeNotesSurgeryField.click();
		}
		if (entity.getOtPostOperativeNotesAnaesthesiology()) {
			otPostOperativeNotesAnaesthesiologyField.click();
		}
		if (entity.getOtPostOperativeDiagnosis()) {
			otPostOperativeDiagnosisField.click();
		}
		if (entity.getOtDismissalType()) {
			otDismissalTypeField.click();
		}
		if (entity.getOtDismissalDateAndTime()) {
			otDismissalDateAndTimeField.click();
		}
		if (entity.getDsResponsibleStaff()) {
			dsResponsibleStaffField.click();
		}
		if (entity.getDsInterpretation()) {
			dsInterpretationField.click();
		}
		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}