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
import kmsweb.entities.PatientConsentEntity;

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
 * Patient ConsentPage is a Page POM that is associated with the admin/entities/patient-consent url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientConsentCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute consentDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentDateTime-field']")
	private WebElement consentDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentOnPaymentTerms-field']")
	private WebElement consentOnPaymentTermsField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentOnRightsAndObligations-field']")
	private WebElement consentOnRightsAndObligationsField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentOnHospitalRegulations-field']")
	private WebElement consentOnHospitalRegulationsField;
	@FindBy(how = How.XPATH, using = "//*[@id='needInterpreter-field']")
	private WebElement needInterpreterField;
	@FindBy(how = How.XPATH, using = "//*[@id='needReligiousCounselor-field']")
	private WebElement needReligiousCounselorField;
	@FindBy(how = How.XPATH, using = "//*[@id='dgsResultsReleasedToInsurer-field']")
	private WebElement dgsResultsReleasedToInsurerField;
	@FindBy(how = How.XPATH, using = "//*[@id='dgsResultsReleasedToStudents-field']")
	private WebElement dgsResultsReleasedToStudentsField;
	@FindBy(how = How.XPATH, using = "//*[@id='recordReleasedToFamilyMember-field']")
	private WebElement recordReleasedToFamilyMemberField;
	@FindBy(how = How.XPATH, using = "//*[@id='recordReleasedToCertainHealthFacilities-field']")
	private WebElement recordReleasedToCertainHealthFacilitiesField;
	@FindBy(how = How.XPATH, using = "//*[@id='staffSignature-field']")
	private WebElement staffSignatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartySignature-field']")
	private WebElement consentingPartySignatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartyType-field']")
	private WebElement consentingPartyTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartyName-field']")
	private WebElement consentingPartyNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='readAndSignSatusehat-field']")
	private WebElement readAndSignSatusehatField;
	@FindBy(how = How.XPATH, using = "//*[@id='informationReleasedToSatusehat-field']")
	private WebElement informationReleasedToSatusehatField;
	@FindBy(how = How.XPATH, using = "//*[@id='emrReleasedToSatusehat-field']")
	private WebElement emrReleasedToSatusehatField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInfoId-field']")
	private WebElement patientGeneralInfoField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPatientConsentCrudEditPage(
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
			"admin/entities/patient-consent/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientConsentEntity) abstractEntity;
		// TODO default handling for dataAttribute consentDateTimeField
		consentDateTimeField.sendKeys(entity.getConsentDateTime().toString());

		consentOnPaymentTermsField.sendKeys(entity.getConsentOnPaymentTerms());
		consentOnRightsAndObligationsField.sendKeys(entity.getConsentOnRightsAndObligations());
		consentOnHospitalRegulationsField.sendKeys(entity.getConsentOnHospitalRegulations());
		needInterpreterField.sendKeys(entity.getNeedInterpreter());
		needReligiousCounselorField.sendKeys(entity.getNeedReligiousCounselor());
		dgsResultsReleasedToInsurerField.sendKeys(entity.getDgsResultsReleasedToInsurer());
		dgsResultsReleasedToStudentsField.sendKeys(entity.getDgsResultsReleasedToStudents());
		recordReleasedToFamilyMemberField.sendKeys(entity.getRecordReleasedToFamilyMember());
		recordReleasedToCertainHealthFacilitiesField.sendKeys(entity.getRecordReleasedToCertainHealthFacilities());
		staffSignatureField.sendKeys(entity.getStaffSignature());
		consentingPartySignatureField.sendKeys(entity.getConsentingPartySignature());
		consentingPartyTypeField.sendKeys(entity.getConsentingPartyType());
		consentingPartyNameField.sendKeys(entity.getConsentingPartyName());
		if (entity.getReadAndSignSatusehat()) {
			readAndSignSatusehatField.click();
		}
		informationReleasedToSatusehatField.sendKeys(entity.getInformationReleasedToSatusehat());
		emrReleasedToSatusehatField.sendKeys(entity.getEmrReleasedToSatusehat());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}