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
import kmsweb.entities.PatientEmploymentDetailEntity;

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
 * Patient Employment Detail Page is a Page POM that is associated with the admin/entities/patient-employment-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPatientEmploymentDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='employeeID-field']")
	private WebElement employeeIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='universalID-field']")
	private WebElement universalIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='employeeType-field']")
	private WebElement employeeTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='onsiteStatus-field']")
	private WebElement onsiteStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='occupationalType-field']")
	private WebElement occupationalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dependantID-field']")
	private WebElement dependantIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='dependantType-field']")
	private WebElement dependantTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='sponsor-field']")
	private WebElement sponsorField;
	@FindBy(how = How.XPATH, using = "//*[@id='relationship-field']")
	private WebElement relationshipField;
	@FindBy(how = How.XPATH, using = "//*[@id='company-field']")
	private WebElement companyField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalStaffCode-field']")
	private WebElement medicalStaffCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='department-field']")
	private WebElement departmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='position-field']")
	private WebElement positionField;
	@FindBy(how = How.XPATH, using = "//*[@id='costCenter-field']")
	private WebElement costCenterField;
	@FindBy(how = How.XPATH, using = "//*[@id='district-field']")
	private WebElement districtField;
	@FindBy(how = How.XPATH, using = "//*[@id='designatedWorkPlace-field']")
	private WebElement designatedWorkPlaceField;
	@FindBy(how = How.XPATH, using = "//*[@id='bureauNo-field']")
	private WebElement bureauNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='industryNo-field']")
	private WebElement industryNoField;
	// TODO default handling dataAttribute employmentStartDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='employmentStartDate-field']")
	private WebElement employmentStartDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='passportNo-field']")
	private WebElement passportNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='passportCountry-field']")
	private WebElement passportCountryField;
	@FindBy(how = How.XPATH, using = "//*[@id='postalAddress-field']")
	private WebElement postalAddressField;
	@FindBy(how = How.XPATH, using = "//*[@id='forwardingAddress-field']")
	private WebElement forwardingAddressField;
	@FindBy(how = How.XPATH, using = "//*[@id='legalDIsability-field']")
	private WebElement legalDIsabilityField;
	@FindBy(how = How.XPATH, using = "//*[@id='legalDisabilityNotes-field']")
	private WebElement legalDisabilityNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='workerInsurance-field']")
	private WebElement workerInsuranceField;
	@FindBy(how = How.XPATH, using = "//*[@id='workerInsuranceNo-field']")
	private WebElement workerInsuranceNoField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientGeneralInfoId-field']")
	private WebElement patientGeneralInfoField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPatientEmploymentDetailCrudEditPage(
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
			"admin/entities/patient-employment-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PatientEmploymentDetailEntity) abstractEntity;
		employeeIDField.sendKeys(entity.getEmployeeID());
		universalIDField.sendKeys(entity.getUniversalID());
		employeeTypeField.sendKeys(entity.getEmployeeType());
		onsiteStatusField.sendKeys(entity.getOnsiteStatus());
		occupationalTypeField.sendKeys(entity.getOccupationalType());
		dependantIDField.sendKeys(entity.getDependantID());
		dependantTypeField.sendKeys(entity.getDependantType());
		sponsorField.sendKeys(entity.getSponsor());
		relationshipField.sendKeys(entity.getRelationship());
		companyField.sendKeys(entity.getCompany());
		medicalStaffCodeField.sendKeys(entity.getMedicalStaffCode());
		departmentField.sendKeys(entity.getDepartment());
		positionField.sendKeys(entity.getPosition());
		costCenterField.sendKeys(entity.getCostCenter());
		districtField.sendKeys(entity.getDistrict());
		designatedWorkPlaceField.sendKeys(entity.getDesignatedWorkPlace());
		bureauNoField.sendKeys(entity.getBureauNo());
		industryNoField.sendKeys(entity.getIndustryNo());
		// TODO default handling for dataAttribute employmentStartDateField
		employmentStartDateField.sendKeys(entity.getEmploymentStartDate().toString());

		passportNoField.sendKeys(entity.getPassportNo());
		nameField.sendKeys(entity.getName());
		passportCountryField.sendKeys(entity.getPassportCountry());
		postalAddressField.sendKeys(entity.getPostalAddress());
		forwardingAddressField.sendKeys(entity.getForwardingAddress());
		legalDIsabilityField.sendKeys(entity.getLegalDIsability());
		legalDisabilityNotesField.sendKeys(entity.getLegalDisabilityNotes());
		workerInsuranceField.sendKeys(entity.getWorkerInsurance());
		workerInsuranceNoField.sendKeys(entity.getWorkerInsuranceNo());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}