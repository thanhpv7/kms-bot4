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
import kmsweb.entities.PatientGeneralInfoEntity;

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
 * Patient General InfoPage is a Page POM that is associated with the admin/entities/patient-general-info url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientGeneralInfoCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='patientID-field']")
	private WebElement patientIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='title-field']")
	private WebElement titleField;
	@FindBy(how = How.XPATH, using = "//*[@id='givenName-field']")
	private WebElement givenNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastName-field']")
	private WebElement lastNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='placeOfBirth-field']")
	private WebElement placeOfBirthField;
	// TODO default handling dataAttribute dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfBirth-field']")
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientPaymentType-field']")
	private WebElement patientPaymentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='importantNotes-field']")
	private WebElement importantNotesField;
	// TODO default handling dataAttribute patientPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientPicture-field']")
	private WebElement patientPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='hasOutstandingPayment-field']")
	private WebElement hasOutstandingPaymentField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientContactInformation-field']")
	private WebElement patientContactInformationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientDetailAddress-field']")
	private WebElement patientDetailAddressField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientDetail-field']")
	private WebElement patientDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientEmergencyContactDetail-field']")
	private WebElement patientEmergencyContactDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientEmploymentDetail-field']")
	private WebElement patientEmploymentDetailField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPaymentBPJS-field']")
	private WebElement patientPaymentBPJSField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPaymentTypeInsurance-field']")
	private WebElement patientPaymentTypeInsuranceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPaymentTypeOthers-field']")
	private WebElement patientPaymentTypeOthersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPersonalInformation-field']")
	private WebElement patientPersonalInformationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientSelfPaying-field']")
	private WebElement patientSelfPayingField;

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsClaimSubmissionsIds-field']")
	private WebElement bpjsClaimSubmissionsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cashRefundsIds-field']")
	private WebElement cashRefundsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='informedConsentsIds-field']")
	private WebElement informedConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceReceiptsIds-field']")
	private WebElement invoiceReceiptsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientCaseHistoriesIds-field']")
	private WebElement patientCaseHistoriesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientConsentsIds-field']")
	private WebElement patientConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientFinalizeProfilesIds-field']")
	private WebElement patientFinalizeProfilesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmaciesIds-field']")
	private WebElement retailPharmaciesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='visitsIds-field']")
	private WebElement visitsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPatientGeneralInfoCrudEditPage(
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
			"admin/entities/patient-general-info/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientGeneralInfoEntity) abstractEntity;
		patientIDField.sendKeys(entity.getPatientID());
		titleField.sendKeys(entity.getTitle());
		givenNameField.sendKeys(entity.getGivenName());
		lastNameField.sendKeys(entity.getLastName());
		placeOfBirthField.sendKeys(entity.getPlaceOfBirth());
		// TODO default handling for dataAttribute dateOfBirthField
		dateOfBirthField.sendKeys(entity.getDateOfBirth().toString());

		genderField.sendKeys(entity.getGender());
		addressField.sendKeys(entity.getAddress());
		patientPaymentTypeField.sendKeys(entity.getPatientPaymentType());
		importantNotesField.sendKeys(entity.getImportantNotes());
		// TODO default handling for dataAttribute patientPictureField
		patientPictureField.sendKeys(entity.getPatientPicture().toString());

		if (entity.getHasOutstandingPayment()) {
			hasOutstandingPaymentField.click();
		}

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}