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
import kmsweb.entities.StaffEntity;

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
 * StaffPage is a Page POM that is associated with the admin/entities/staff url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesStaffCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='staffNumber-field']")
	private WebElement staffNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='firstName-field']")
	private WebElement firstNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastName-field']")
	private WebElement lastNameField;
	// TODO default handling dataAttribute dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfBirth-field']")
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='staffType-field']")
	private WebElement staffTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='specialization-field']")
	private WebElement specializationField;
	// TODO default handling dataAttribute staffPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='staffPicture-field']")
	private WebElement staffPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='education-field']")
	private WebElement educationField;
	@FindBy(how = How.XPATH, using = "//*[@id='licenseNo-field']")
	private WebElement licenseNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='letterOfReg-field']")
	private WebElement letterOfRegField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	@FindBy(how = How.XPATH, using = "//*[@id='employeeID-field']")
	private WebElement employeeIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='title-field']")
	private WebElement titleField;
	@FindBy(how = How.XPATH, using = "//*[@id='defaultServiceNumber-field']")
	private WebElement defaultServiceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='placeOfBirth-field']")
	private WebElement placeOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='religion-field']")
	private WebElement religionField;
	@FindBy(how = How.XPATH, using = "//*[@id='bloodType-field']")
	private WebElement bloodTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='rhesus-field']")
	private WebElement rhesusField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='country-field']")
	private WebElement countryField;
	@FindBy(how = How.XPATH, using = "//*[@id='state-field']")
	private WebElement stateField;
	@FindBy(how = How.XPATH, using = "//*[@id='regency-field']")
	private WebElement regencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='district-field']")
	private WebElement districtField;
	@FindBy(how = How.XPATH, using = "//*[@id='homePhoneNo-field']")
	private WebElement homePhoneNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='village-field']")
	private WebElement villageField;
	@FindBy(how = How.XPATH, using = "//*[@id='postcode-field']")
	private WebElement postcodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='officePhoneNumber-field']")
	private WebElement officePhoneNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='taxIdentificationNo-field']")
	private WebElement taxIdentificationNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='mobilePhoneNo-field']")
	private WebElement mobilePhoneNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherNotes-field']")
	private WebElement otherNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='training-field']")
	private WebElement trainingField;
	@FindBy(how = How.XPATH, using = "//*[@id='nationality-field']")
	private WebElement nationalityField;
	@FindBy(how = How.XPATH, using = "//*[@id='certification-field']")
	private WebElement certificationField;
	@FindBy(how = How.XPATH, using = "//*[@id='extNo-field']")
	private WebElement extNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='maritalStatus-field']")
	private WebElement maritalStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='administrator-field']")
	private WebElement administratorField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDoctorMapping-field']")
	private WebElement bpjsDoctorMappingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareDokter-field']")
	private WebElement pcareDokterField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='service-field']")
	private WebElement serviceField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='administrationUserId-field']")
	private WebElement administrationUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cashierUserId-field']")
	private WebElement cashierUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='claimUserId-field']")
	private WebElement claimUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosticSupportUserId-field']")
	private WebElement diagnosticSupportUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorUserId-field']")
	private WebElement doctorUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='facilityUserId-field']")
	private WebElement facilityUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='managementUserId-field']")
	private WebElement managementUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalRecordUserId-field']")
	private WebElement medicalRecordUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalTranscriberUserId-field']")
	private WebElement medicalTranscriberUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nurseUserId-field']")
	private WebElement nurseUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pharmacyUserId-field']")
	private WebElement pharmacyUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchasingUserId-field']")
	private WebElement purchasingUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationUserId-field']")
	private WebElement registrationUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='systemAdminUserId-field']")
	private WebElement systemAdminUserField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseUserId-field']")
	private WebElement warehouseUserField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='accompanyingConsentsIds-field']")
	private WebElement accompanyingConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='amendmentDetailsIds-field']")
	private WebElement amendmentDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiaMedicalTranscriberIds-field']")
	private WebElement anesthesiaMedicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiologistIds-field']")
	private WebElement anesthesiologistField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='anesthesiologyNurseIds-field']")
	private WebElement anesthesiologyNurseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cashierStaffIds-field']")
	private WebElement cashierStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='coTreatingDoctorsIds-field']")
	private WebElement coTreatingDoctorsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dailyCareCPPTsCreatedByStaffIds-field']")
	private WebElement dailyCareCPPTsCreatedByStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dailyCareCPPTsDoctorInChargeIds-field']")
	private WebElement dailyCareCPPTsDoctorInChargeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dailyCareCPPTsMedicalTranscriberIds-field']")
	private WebElement dailyCareCPPTsMedicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='deliveryProgressesIds-field']")
	private WebElement deliveryProgressesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosticStaffExaminationSummariesIds-field']")
	private WebElement diagnosticStaffExaminationSummariesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dismissalReferringStaffIds-field']")
	private WebElement dismissalReferringStaffField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorSchedulesIds-field']")
	private WebElement doctorSchedulesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorOnExaminationIds-field']")
	private WebElement doctorOnExaminationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='fluidBalanceDetailsIds-field']")
	private WebElement fluidBalanceDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hemodialysisMonitoringsIds-field']")
	private WebElement hemodialysisMonitoringsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hospitalBranchInformationsIds-field']")
	private WebElement hospitalBranchInformationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='informingConsentsIds-field']")
	private WebElement informingConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicesIds-field']")
	private WebElement invoicesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='mcuPackageItemsIds-field']")
	private WebElement mcuPackageItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateDischargeResumesIds-field']")
	private WebElement medicalCertificateDischargeResumesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateBirthsIds-field']")
	private WebElement medicalCertificateBirthsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalCertificateHospitalizationsIds-field']")
	private WebElement medicalCertificateHospitalizationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordDischargeSummarysIds-field']")
	private WebElement medicalExaminationRecordDischargeSummarysField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalRecordTranscriberIds-field']")
	private WebElement medicalRecordTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffOfMedicalAttendancesCertificateIds-field']")
	private WebElement medicalStaffOfMedicalAttendancesCertificateField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffOfMentalHealthsIds-field']")
	private WebElement medicalStaffOfMentalHealthsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffOfPhysicalHealthsIds-field']")
	private WebElement medicalStaffOfPhysicalHealthsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffOfRestrictedWorksCertificateIds-field']")
	private WebElement medicalStaffOfRestrictedWorksCertificateField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffOfSickLeavesCertificateIds-field']")
	private WebElement medicalStaffOfSickLeavesCertificateField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationAdministeredHisotriesIds-field']")
	private WebElement medicationAdministeredHisotriesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationHeadersIds-field']")
	private WebElement medicationHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='midwivesIds-field']")
	private WebElement midwivesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nurseIds-field']")
	private WebElement nurseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingDetailSurgicalNursingIds-field']")
	private WebElement nursingDetailSurgicalNursingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='nursingDetailsAnesthesiaNursingIds-field']")
	private WebElement nursingDetailsAnesthesiaNursingField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientConsentsIds-field']")
	private WebElement patientConsentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVitalInformationsIds-field']")
	private WebElement patientVitalInformationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pediatricianInChargeIds-field']")
	private WebElement pediatricianInChargeField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionHeadersIds-field']")
	private WebElement prescriptionHeadersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='processWorkflowLogsIds-field']")
	private WebElement processWorkflowLogsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationsIds-field']")
	private WebElement registrationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='requestedByIds-field']")
	private WebElement requestedByField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='roomTransfersIds-field']")
	private WebElement roomTransfersField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleCollectionStaffsIds-field']")
	private WebElement sampleCollectionStaffsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleDeliveryStaffsIds-field']")
	private WebElement sampleDeliveryStaffsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='sampleProcessingStaffsIds-field']")
	private WebElement sampleProcessingStaffsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgeonIds-field']")
	private WebElement surgeonField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgicalMedicalTranscriberIds-field']")
	private WebElement surgicalMedicalTranscriberField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='surgicalNurseIds-field']")
	private WebElement surgicalNurseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='transferOrderStockDetailsIds-field']")
	private WebElement transferOrderStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='vaccinationOrdersIds-field']")
	private WebElement vaccinationOrdersField;

	// Incoming one-to-many

	// Outgoing many-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='servicesIds-field']")
	private WebElement servicesField;

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesStaffCrudEditPage(
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
			"admin/entities/staff/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (StaffEntity) abstractEntity;
		staffNumberField.sendKeys(entity.getStaffNumber());
		firstNameField.sendKeys(entity.getFirstName());
		lastNameField.sendKeys(entity.getLastName());
		// TODO default handling for dataAttribute dateOfBirthField
		dateOfBirthField.sendKeys(entity.getDateOfBirth().toString());

		staffTypeField.sendKeys(entity.getStaffType());
		specializationField.sendKeys(entity.getSpecialization());
		// TODO default handling for dataAttribute staffPictureField
		staffPictureField.sendKeys(entity.getStaffPicture().toString());

		educationField.sendKeys(entity.getEducation());
		licenseNoField.sendKeys(entity.getLicenseNo());
		letterOfRegField.sendKeys(entity.getLetterOfReg());
		genderField.sendKeys(entity.getGender());
		employeeIDField.sendKeys(entity.getEmployeeID());
		titleField.sendKeys(entity.getTitle());
		defaultServiceNumberField.sendKeys(entity.getDefaultServiceNumber());
		placeOfBirthField.sendKeys(entity.getPlaceOfBirth());
		religionField.sendKeys(entity.getReligion());
		DropdownUtils.selectOptionByName(webDriver, bloodTypeField, entity.getBloodType().getLiteralValue());
		DropdownUtils.selectOptionByName(webDriver, rhesusField, entity.getRhesus().getLiteralValue());
		addressField.sendKeys(entity.getAddress());
		countryField.sendKeys(entity.getCountry());
		stateField.sendKeys(entity.getState());
		regencyField.sendKeys(entity.getRegency());
		districtField.sendKeys(entity.getDistrict());
		homePhoneNoField.sendKeys(entity.getHomePhoneNo());
		villageField.sendKeys(entity.getVillage());
		postcodeField.sendKeys(entity.getPostcode());
		officePhoneNumberField.sendKeys(entity.getOfficePhoneNumber());
		taxIdentificationNoField.sendKeys(entity.getTaxIdentificationNo());
		mobilePhoneNoField.sendKeys(entity.getMobilePhoneNo());
		otherNotesField.sendKeys(entity.getOtherNotes());
		trainingField.sendKeys(entity.getTraining());
		nationalityField.sendKeys(entity.getNationality());
		certificationField.sendKeys(entity.getCertification());
		extNoField.sendKeys(entity.getExtNo());
		maritalStatusField.sendKeys(entity.getMaritalStatus());
		emailField.sendKeys(entity.getEmail());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}