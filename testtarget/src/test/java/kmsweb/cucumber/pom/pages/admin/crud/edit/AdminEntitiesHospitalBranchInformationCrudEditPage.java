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
import kmsweb.entities.HospitalBranchInformationEntity;

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
 * Hospital Branch InformationPage is a Page POM that is associated with the admin/entities/hospital-branch-information url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesHospitalBranchInformationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='hospitalCode-field']")
	private WebElement hospitalCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalName-field']")
	private WebElement hospitalNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalType-field']")
	private WebElement hospitalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalClass-field']")
	private WebElement hospitalClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalDirectorName-field']")
	private WebElement hospitalDirectorNameField;
	// TODO default handling dataAttribute dateOfRegistrationField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfRegistration-field']")
	private WebElement dateOfRegistrationField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalCorporationName-field']")
	private WebElement hospitalCorporationNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='isBPJSFacility-field']")
	private WebElement isBPJSFacilityField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='city-field']")
	private WebElement cityField;
	@FindBy(how = How.XPATH, using = "//*[@id='postcode-field']")
	private WebElement postcodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber-field']")
	private WebElement phoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='fax-field']")
	private WebElement faxField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='website-field']")
	private WebElement websiteField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPerson-field']")
	private WebElement contactPersonField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPersonPhoneNumber-field']")
	private WebElement contactPersonPhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='contactPersonEmail-field']")
	private WebElement contactPersonEmailField;
	@FindBy(how = How.XPATH, using = "//*[@id='landSize-field']")
	private WebElement landSizeField;
	@FindBy(how = How.XPATH, using = "//*[@id='buildingSize-field']")
	private WebElement buildingSizeField;
	@FindBy(how = How.XPATH, using = "//*[@id='permitNumber-field']")
	private WebElement permitNumberField;
	// TODO default handling dataAttribute permitDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='permitDate-field']")
	private WebElement permitDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='authorizedBy-field']")
	private WebElement authorizedByField;
	@FindBy(how = How.XPATH, using = "//*[@id='permitType-field']")
	private WebElement permitTypeField;
	// TODO default handling dataAttribute validUntilField;
	@FindBy(how = How.XPATH, using = "//*[@id='validUntil-field']")
	private WebElement validUntilField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalBranchCorporationName-field']")
	private WebElement hospitalBranchCorporationNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalBranchCorporationStatus-field']")
	private WebElement hospitalBranchCorporationStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='accreditationType-field']")
	private WebElement accreditationTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='accreditationLevel-field']")
	private WebElement accreditationLevelField;
	// TODO default handling dataAttribute accreditationDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='accreditationDate-field']")
	private WebElement accreditationDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='bedPerinatology-field']")
	private WebElement bedPerinatologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='suiteClass-field']")
	private WebElement suiteClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='vvipClass-field']")
	private WebElement vvipClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='vipAClass-field']")
	private WebElement vipAClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='vipBClass-field']")
	private WebElement vipBClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='vipCClass-field']")
	private WebElement vipCClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='mainClass-field']")
	private WebElement mainClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='classI-field']")
	private WebElement classIField;
	@FindBy(how = How.XPATH, using = "//*[@id='iiClass-field']")
	private WebElement iiClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='iiiAClass-field']")
	private WebElement iiiAClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='iiiBClass-field']")
	private WebElement iiiBClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='specialClass-field']")
	private WebElement specialClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='icu-field']")
	private WebElement icuField;
	@FindBy(how = How.XPATH, using = "//*[@id='picu-field']")
	private WebElement picuField;
	@FindBy(how = How.XPATH, using = "//*[@id='nicu-field']")
	private WebElement nicuField;
	@FindBy(how = How.XPATH, using = "//*[@id='hcu-field']")
	private WebElement hcuField;
	@FindBy(how = How.XPATH, using = "//*[@id='iccu-field']")
	private WebElement iccuField;
	@FindBy(how = How.XPATH, using = "//*[@id='isolationRoom-field']")
	private WebElement isolationRoomField;
	@FindBy(how = How.XPATH, using = "//*[@id='emergencyRoom-field']")
	private WebElement emergencyRoomField;
	@FindBy(how = How.XPATH, using = "//*[@id='maternityRoom-field']")
	private WebElement maternityRoomField;
	@FindBy(how = How.XPATH, using = "//*[@id='operatingRoom-field']")
	private WebElement operatingRoomField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpA-field']")
	private WebElement doctorSpAField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpOG-field']")
	private WebElement doctorSpOGField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpPD-field']")
	private WebElement doctorSpPDField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpB-field']")
	private WebElement doctorSpBField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpRad-field']")
	private WebElement doctorSpRadField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpRm-field']")
	private WebElement doctorSpRmField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpAn-field']")
	private WebElement doctorSpAnField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpJp-field']")
	private WebElement doctorSpJpField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpM-field']")
	private WebElement doctorSpMField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpTHT-field']")
	private WebElement doctorSpTHTField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpKj-field']")
	private WebElement doctorSpKjField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpP-field']")
	private WebElement doctorSpPField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpPK-field']")
	private WebElement doctorSpPKField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorSpS-field']")
	private WebElement doctorSpSField;
	@FindBy(how = How.XPATH, using = "//*[@id='subSpecialistDoctor-field']")
	private WebElement subSpecialistDoctorField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherSpecialistDoctor-field']")
	private WebElement otherSpecialistDoctorField;
	@FindBy(how = How.XPATH, using = "//*[@id='generalPractice-field']")
	private WebElement generalPracticeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dentist-field']")
	private WebElement dentistField;
	@FindBy(how = How.XPATH, using = "//*[@id='specialistDentist-field']")
	private WebElement specialistDentistField;
	@FindBy(how = How.XPATH, using = "//*[@id='nurse-field']")
	private WebElement nurseField;
	@FindBy(how = How.XPATH, using = "//*[@id='midwife-field']")
	private WebElement midwifeField;
	@FindBy(how = How.XPATH, using = "//*[@id='pharmacist-field']")
	private WebElement pharmacistField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherMedicalStaff-field']")
	private WebElement otherMedicalStaffField;
	@FindBy(how = How.XPATH, using = "//*[@id='nonMedicalStaff-field']")
	private WebElement nonMedicalStaffField;
	// TODO default handling dataAttribute leftLogoField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftLogo-field']")
	private WebElement leftLogoField;
	// TODO default handling dataAttribute rightLogoField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightLogo-field']")
	private WebElement rightLogoField;
	@FindBy(how = How.XPATH, using = "//*[@id='timezone-field']")
	private WebElement timezoneField;
	@FindBy(how = How.XPATH, using = "//*[@id='healthFacilityLevel-field']")
	private WebElement healthFacilityLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='satuSehatIntegration-field']")
	private WebElement satuSehatIntegrationField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxIdentification-field']")
	private WebElement taxIdentificationField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hospitalGroupId-field']")
	private WebElement hospitalGroupField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesHospitalBranchInformationCrudEditPage(
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
			"admin/entities/hospital-branch-information/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (HospitalBranchInformationEntity) abstractEntity;
		hospitalCodeField.sendKeys(entity.getHospitalCode());
		hospitalNameField.sendKeys(entity.getHospitalName());
		hospitalTypeField.sendKeys(entity.getHospitalType());
		hospitalClassField.sendKeys(entity.getHospitalClass());
		hospitalDirectorNameField.sendKeys(entity.getHospitalDirectorName());
		// TODO default handling for dataAttribute dateOfRegistrationField
		dateOfRegistrationField.sendKeys(entity.getDateOfRegistration().toString());

		hospitalCorporationNameField.sendKeys(entity.getHospitalCorporationName());
		if (entity.getIsBPJSFacility()) {
			isBPJSFacilityField.click();
		}
		addressField.sendKeys(entity.getAddress());
		cityField.sendKeys(entity.getCity());
		postcodeField.sendKeys(entity.getPostcode());
		phoneNumberField.sendKeys(entity.getPhoneNumber());
		faxField.sendKeys(entity.getFax());
		emailField.sendKeys(entity.getEmail());
		websiteField.sendKeys(entity.getWebsite());
		contactPersonField.sendKeys(entity.getContactPerson());
		contactPersonPhoneNumberField.sendKeys(entity.getContactPersonPhoneNumber());
		contactPersonEmailField.sendKeys(entity.getContactPersonEmail());
		landSizeField.sendKeys(entity.getLandSize());
		buildingSizeField.sendKeys(entity.getBuildingSize());
		permitNumberField.sendKeys(entity.getPermitNumber());
		// TODO default handling for dataAttribute permitDateField
		permitDateField.sendKeys(entity.getPermitDate().toString());

		authorizedByField.sendKeys(entity.getAuthorizedBy());
		permitTypeField.sendKeys(entity.getPermitType());
		// TODO default handling for dataAttribute validUntilField
		validUntilField.sendKeys(entity.getValidUntil().toString());

		hospitalBranchCorporationNameField.sendKeys(entity.getHospitalBranchCorporationName());
		hospitalBranchCorporationStatusField.sendKeys(entity.getHospitalBranchCorporationStatus());
		accreditationTypeField.sendKeys(entity.getAccreditationType());
		accreditationLevelField.sendKeys(entity.getAccreditationLevel());
		// TODO default handling for dataAttribute accreditationDateField
		accreditationDateField.sendKeys(entity.getAccreditationDate().toString());

		bedPerinatologyField.sendKeys(entity.getBedPerinatology());
		suiteClassField.sendKeys(entity.getSuiteClass());
		vvipClassField.sendKeys(entity.getVvipClass());
		vipAClassField.sendKeys(entity.getVipAClass());
		vipBClassField.sendKeys(entity.getVipBClass());
		vipCClassField.sendKeys(entity.getVipCClass());
		mainClassField.sendKeys(entity.getMainClass());
		classIField.sendKeys(entity.getClassI());
		iiClassField.sendKeys(entity.getIiClass());
		iiiAClassField.sendKeys(entity.getIiiAClass());
		iiiBClassField.sendKeys(entity.getIiiBClass());
		specialClassField.sendKeys(entity.getSpecialClass());
		icuField.sendKeys(entity.getIcu());
		picuField.sendKeys(entity.getPicu());
		nicuField.sendKeys(entity.getNicu());
		hcuField.sendKeys(entity.getHcu());
		iccuField.sendKeys(entity.getIccu());
		isolationRoomField.sendKeys(entity.getIsolationRoom());
		emergencyRoomField.sendKeys(entity.getEmergencyRoom());
		maternityRoomField.sendKeys(entity.getMaternityRoom());
		operatingRoomField.sendKeys(entity.getOperatingRoom());
		doctorSpAField.sendKeys(entity.getDoctorSpA());
		doctorSpOGField.sendKeys(entity.getDoctorSpOG());
		doctorSpPDField.sendKeys(entity.getDoctorSpPD());
		doctorSpBField.sendKeys(entity.getDoctorSpB());
		doctorSpRadField.sendKeys(entity.getDoctorSpRad());
		doctorSpRmField.sendKeys(entity.getDoctorSpRm());
		doctorSpAnField.sendKeys(entity.getDoctorSpAn());
		doctorSpJpField.sendKeys(entity.getDoctorSpJp());
		doctorSpMField.sendKeys(entity.getDoctorSpM());
		doctorSpTHTField.sendKeys(entity.getDoctorSpTHT());
		doctorSpKjField.sendKeys(entity.getDoctorSpKj());
		doctorSpPField.sendKeys(entity.getDoctorSpP());
		doctorSpPKField.sendKeys(entity.getDoctorSpPK());
		doctorSpSField.sendKeys(entity.getDoctorSpS());
		subSpecialistDoctorField.sendKeys(entity.getSubSpecialistDoctor());
		otherSpecialistDoctorField.sendKeys(entity.getOtherSpecialistDoctor());
		generalPracticeField.sendKeys(entity.getGeneralPractice());
		dentistField.sendKeys(entity.getDentist());
		specialistDentistField.sendKeys(entity.getSpecialistDentist());
		nurseField.sendKeys(entity.getNurse());
		midwifeField.sendKeys(entity.getMidwife());
		pharmacistField.sendKeys(entity.getPharmacist());
		otherMedicalStaffField.sendKeys(entity.getOtherMedicalStaff());
		nonMedicalStaffField.sendKeys(entity.getNonMedicalStaff());
		// TODO default handling for dataAttribute leftLogoField
		leftLogoField.sendKeys(entity.getLeftLogo().toString());

		// TODO default handling for dataAttribute rightLogoField
		rightLogoField.sendKeys(entity.getRightLogo().toString());

		timezoneField.sendKeys(entity.getTimezone());
		healthFacilityLevelField.sendKeys(entity.getHealthFacilityLevel());
		if (entity.getSatuSehatIntegration()) {
			satuSehatIntegrationField.click();
		}
		taxIdentificationField.sendKeys(entity.getTaxIdentification());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}