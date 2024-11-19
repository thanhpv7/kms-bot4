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
import kmsweb.entities.InformedConsentEntity;

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
 * Informed ConsentPage is a Page POM that is associated with the admin/entities/informed-consent url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInformedConsentCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='patientFamilyGuardianName-field']")
	private WebElement patientFamilyGuardianNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientFamilyGuardianRelationship-field']")
	private WebElement patientFamilyGuardianRelationshipField;
	@FindBy(how = How.XPATH, using = "//*[@id='procedureToBePerformed-field']")
	private WebElement procedureToBePerformedField;
	@FindBy(how = How.XPATH, using = "//*[@id='consequenceOfProcedure-field']")
	private WebElement consequenceOfProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentOnProcedure-field']")
	private WebElement consentOnProcedureField;
	// TODO default handling dataAttribute consentDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentDateTime-field']")
	private WebElement consentDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='informingStaffSignature-field']")
	private WebElement informingStaffSignatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartySignature-field']")
	private WebElement consentingPartySignatureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartyType-field']")
	private WebElement consentingPartyTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='consentingPartyName-field']")
	private WebElement consentingPartyNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='witnessSignature1-field']")
	private WebElement witnessSignature1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='witnessName1-field']")
	private WebElement witnessName1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='witnessSignature2-field']")
	private WebElement witnessSignature2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='witnessName2-field']")
	private WebElement witnessName2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='accompanyingStaffId-field']")
	private WebElement accompanyingStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInfoId-field']")
	private WebElement patientGeneralInfoField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='informingStaffId-field']")
	private WebElement informingStaffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInformedConsentCrudEditPage(
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
			"admin/entities/informed-consent/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (InformedConsentEntity) abstractEntity;
		patientFamilyGuardianNameField.sendKeys(entity.getPatientFamilyGuardianName());
		patientFamilyGuardianRelationshipField.sendKeys(entity.getPatientFamilyGuardianRelationship());
		procedureToBePerformedField.sendKeys(entity.getProcedureToBePerformed());
		consequenceOfProcedureField.sendKeys(entity.getConsequenceOfProcedure());
		consentOnProcedureField.sendKeys(entity.getConsentOnProcedure());
		// TODO default handling for dataAttribute consentDateTimeField
		consentDateTimeField.sendKeys(entity.getConsentDateTime().toString());

		informingStaffSignatureField.sendKeys(entity.getInformingStaffSignature());
		consentingPartySignatureField.sendKeys(entity.getConsentingPartySignature());
		consentingPartyTypeField.sendKeys(entity.getConsentingPartyType());
		consentingPartyNameField.sendKeys(entity.getConsentingPartyName());
		witnessSignature1Field.sendKeys(entity.getWitnessSignature1());
		witnessName1Field.sendKeys(entity.getWitnessName1());
		witnessSignature2Field.sendKeys(entity.getWitnessSignature2());
		witnessName2Field.sendKeys(entity.getWitnessName2());
		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}