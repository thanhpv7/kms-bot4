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
import kmsweb.entities.BpjsClaimSubmissionEntity;

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
 * BPJS Claim SubmissionPage is a Page POM that is associated with the admin/entities/bpjs-claim-submission url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsClaimSubmissionCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	// TODO default handling dataAttribute admissionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDate-field']")
	private WebElement admissionDateField;
	// TODO default handling dataAttribute dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='insuranceProvider-field']")
	private WebElement insuranceProviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentType-field']")
	private WebElement treatmentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='followUpPlan-field']")
	private WebElement followUpPlanField;
	// TODO default handling dataAttribute controlDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='controlDate-field']")
	private WebElement controlDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='additionalDiagnosis-field']")
	private WebElement additionalDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='additionalProcedure-field']")
	private WebElement additionalProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='kelasRawat-field']")
	private WebElement kelasRawatField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDismissalConditionsIds-field']")
	private WebElement bpjsDismissalConditionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDismissalMappingsIds-field']")
	private WebElement bpjsDismissalMappingsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsTreatmentRoomsIds-field']")
	private WebElement bpjsTreatmentRoomsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDiagnoseId-field']")
	private WebElement bpjsDiagnoseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDoctorMappingId-field']")
	private WebElement bpjsDoctorMappingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsHealthFacilityId-field']")
	private WebElement bpjsHealthFacilityField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsProcedureId-field']")
	private WebElement bpjsProcedureField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsServiceMappingId-field']")
	private WebElement bpjsServiceMappingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInfoId-field']")
	private WebElement patientGeneralInfoField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPaymentBPJSId-field']")
	private WebElement patientPaymentBPJSField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsClaimSubmissionCrudEditPage(
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
			"admin/entities/bpjs-claim-submission/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsClaimSubmissionEntity) abstractEntity;
		sepNoField.sendKeys(entity.getSepNo());
		// TODO default handling for dataAttribute admissionDateField
		admissionDateField.sendKeys(entity.getAdmissionDate().toString());

		// TODO default handling for dataAttribute dismissalDateField
		dismissalDateField.sendKeys(entity.getDismissalDate().toString());

		insuranceProviderField.sendKeys(entity.getInsuranceProvider());
		treatmentTypeField.sendKeys(entity.getTreatmentType());
		followUpPlanField.sendKeys(entity.getFollowUpPlan());
		// TODO default handling for dataAttribute controlDateField
		controlDateField.sendKeys(entity.getControlDate().toString());

		additionalDiagnosisField.sendKeys(entity.getAdditionalDiagnosis());
		additionalProcedureField.sendKeys(entity.getAdditionalProcedure());
		DropdownUtils.selectOptionByName(webDriver, kelasRawatField, entity.getKelasRawat().getLiteralValue());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}