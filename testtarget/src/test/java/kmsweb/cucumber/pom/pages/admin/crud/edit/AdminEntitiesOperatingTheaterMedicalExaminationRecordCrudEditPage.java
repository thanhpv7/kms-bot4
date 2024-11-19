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
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;

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
 * Operating Theater Medical Examination RecordPage is a Page POM that is associated with the admin/entities/operating-theater-medical-examination-record url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesOperatingTheaterMedicalExaminationRecordCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='hasConfirmedIdentity-field']")
	private WebElement hasConfirmedIdentityField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaSafetyCheckCompleted-field']")
	private WebElement anesthesiaSafetyCheckCompletedField;
	@FindBy(how = How.XPATH, using = "//*[@id='pulseOxymeterFunctioning-field']")
	private WebElement pulseOxymeterFunctioningField;
	@FindBy(how = How.XPATH, using = "//*[@id='siteMarked-field']")
	private WebElement siteMarkedField;
	@FindBy(how = How.XPATH, using = "//*[@id='hasKnownAllergy-field']")
	private WebElement hasKnownAllergyField;
	@FindBy(how = How.XPATH, using = "//*[@id='hasDifficultAirwayRisk-field']")
	private WebElement hasDifficultAirwayRiskField;
	@FindBy(how = How.XPATH, using = "//*[@id='hasRiskOfBloodLoss-field']")
	private WebElement hasRiskOfBloodLossField;
	@FindBy(how = How.XPATH, using = "//*[@id='teamMemberIntroduced-field']")
	private WebElement teamMemberIntroducedField;
	@FindBy(how = How.XPATH, using = "//*[@id='professionalConfirmedPatient-field']")
	private WebElement professionalConfirmedPatientField;
	@FindBy(how = How.XPATH, using = "//*[@id='antibioticProphylaxisGiven-field']")
	private WebElement antibioticProphylaxisGivenField;
	@FindBy(how = How.XPATH, using = "//*[@id='essentialImagingDisplayed-field']")
	private WebElement essentialImagingDisplayedField;
	@FindBy(how = How.XPATH, using = "//*[@id='whareAreCriticalSteps-field']")
	private WebElement whareAreCriticalStepsField;
	@FindBy(how = How.XPATH, using = "//*[@id='howLongCaseTake-field']")
	private WebElement howLongCaseTakeField;
	@FindBy(how = How.XPATH, using = "//*[@id='whatIsAnticipatedBloodLoss-field']")
	private WebElement whatIsAnticipatedBloodLossField;
	@FindBy(how = How.XPATH, using = "//*[@id='anyPatientSpecificConcerns-field']")
	private WebElement anyPatientSpecificConcernsField;
	@FindBy(how = How.XPATH, using = "//*[@id='sterlityBeenConfirmed-field']")
	private WebElement sterlityBeenConfirmedField;
	@FindBy(how = How.XPATH, using = "//*[@id='equipmentIssuesAnyConcern-field']")
	private WebElement equipmentIssuesAnyConcernField;
	@FindBy(how = How.XPATH, using = "//*[@id='nameOfProcedure-field']")
	private WebElement nameOfProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='instrumentsNeedCountCorrect-field']")
	private WebElement instrumentsNeedCountCorrectField;
	@FindBy(how = How.XPATH, using = "//*[@id='specimenIsLabeled-field']")
	private WebElement specimenIsLabeledField;
	@FindBy(how = How.XPATH, using = "//*[@id='equipmentProblemsAddressed-field']")
	private WebElement equipmentProblemsAddressedField;
	@FindBy(how = How.XPATH, using = "//*[@id='keyConcernsForRecovery-field']")
	private WebElement keyConcernsForRecoveryField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='intraoperativeRecords-field']")
	private WebElement intraoperativeRecordsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='postOperativeDetails-field']")
	private WebElement postOperativeDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preoperativeRecords-field']")
	private WebElement preoperativeRecordsField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingAnesthesiaDetailId-field']")
	private WebElement nursingAnesthesiaDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingDetailSurgicalNursingsId-field']")
	private WebElement nursingDetailSurgicalNursingsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingDetailsAnesthesiaNursingsId-field']")
	private WebElement nursingDetailsAnesthesiaNursingsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingSurgicalDetailId-field']")
	private WebElement nursingSurgicalDetailField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesOperatingTheaterMedicalExaminationRecordCrudEditPage(
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
			"admin/entities/operating-theater-medical-examination-record/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (OperatingTheaterMedicalExaminationRecordEntity) abstractEntity;
		if (entity.getHasConfirmedIdentity()) {
			hasConfirmedIdentityField.click();
		}
		if (entity.getAnesthesiaSafetyCheckCompleted()) {
			anesthesiaSafetyCheckCompletedField.click();
		}
		if (entity.getPulseOxymeterFunctioning()) {
			pulseOxymeterFunctioningField.click();
		}
		siteMarkedField.sendKeys(entity.getSiteMarked());
		hasKnownAllergyField.sendKeys(entity.getHasKnownAllergy());
		hasDifficultAirwayRiskField.sendKeys(entity.getHasDifficultAirwayRisk());
		hasRiskOfBloodLossField.sendKeys(entity.getHasRiskOfBloodLoss());
		if (entity.getTeamMemberIntroduced()) {
			teamMemberIntroducedField.click();
		}
		if (entity.getProfessionalConfirmedPatient()) {
			professionalConfirmedPatientField.click();
		}
		antibioticProphylaxisGivenField.sendKeys(entity.getAntibioticProphylaxisGiven());
		essentialImagingDisplayedField.sendKeys(entity.getEssentialImagingDisplayed());
		if (entity.getWhareAreCriticalSteps()) {
			whareAreCriticalStepsField.click();
		}
		if (entity.getHowLongCaseTake()) {
			howLongCaseTakeField.click();
		}
		if (entity.getWhatIsAnticipatedBloodLoss()) {
			whatIsAnticipatedBloodLossField.click();
		}
		if (entity.getAnyPatientSpecificConcerns()) {
			anyPatientSpecificConcernsField.click();
		}
		if (entity.getSterlityBeenConfirmed()) {
			sterlityBeenConfirmedField.click();
		}
		if (entity.getEquipmentIssuesAnyConcern()) {
			equipmentIssuesAnyConcernField.click();
		}
		if (entity.getNameOfProcedure()) {
			nameOfProcedureField.click();
		}
		if (entity.getInstrumentsNeedCountCorrect()) {
			instrumentsNeedCountCorrectField.click();
		}
		if (entity.getSpecimenIsLabeled()) {
			specimenIsLabeledField.click();
		}
		if (entity.getEquipmentProblemsAddressed()) {
			equipmentProblemsAddressedField.click();
		}
		if (entity.getKeyConcernsForRecovery()) {
			keyConcernsForRecoveryField.click();
		}

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}