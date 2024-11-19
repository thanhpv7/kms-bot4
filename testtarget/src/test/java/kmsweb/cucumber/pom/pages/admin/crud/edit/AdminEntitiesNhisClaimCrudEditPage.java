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
import kmsweb.entities.NhisClaimEntity;

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
 * NHIS ClaimPage is a Page POM that is associated with the admin/entities/nhis-claim url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesNhisClaimCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='systemClaimID-field']")
	private WebElement systemClaimIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='refInvoiceNo-field']")
	private WebElement refInvoiceNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='formNo-field']")
	private WebElement formNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimID-field']")
	private WebElement claimIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimCheckCode-field']")
	private WebElement claimCheckCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='batchNumber-field']")
	private WebElement batchNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='surname-field']")
	private WebElement surnameField;
	@FindBy(how = How.XPATH, using = "//*[@id='otherNames-field']")
	private WebElement otherNamesField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	// TODO default handling dataAttribute dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateOfBirth-field']")
	private WebElement dateOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='memberNo-field']")
	private WebElement memberNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalRecordNo-field']")
	private WebElement hospitalRecordNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='cardSerialNumber-field']")
	private WebElement cardSerialNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='dependant-field']")
	private WebElement dependantField;
	@FindBy(how = How.XPATH, using = "//*[@id='unbundled-field']")
	private WebElement unbundledField;
	@FindBy(how = How.XPATH, using = "//*[@id='includesPharmacy-field']")
	private WebElement includesPharmacyField;
	@FindBy(how = How.XPATH, using = "//*[@id='typeOfAttendance-field']")
	private WebElement typeOfAttendanceField;
	// TODO default handling dataAttribute firstVisitAdmissionField;
	@FindBy(how = How.XPATH, using = "//*[@id='firstVisitAdmission-field']")
	private WebElement firstVisitAdmissionField;
	// TODO default handling dataAttribute secondVisitDischargeField;
	@FindBy(how = How.XPATH, using = "//*[@id='secondVisitDischarge-field']")
	private WebElement secondVisitDischargeField;
	// TODO default handling dataAttribute thirdVisitField;
	@FindBy(how = How.XPATH, using = "//*[@id='thirdVisit-field']")
	private WebElement thirdVisitField;
	// TODO default handling dataAttribute fourthVisitField;
	@FindBy(how = How.XPATH, using = "//*[@id='fourthVisit-field']")
	private WebElement fourthVisitField;
	@FindBy(how = How.XPATH, using = "//*[@id='physicianName-field']")
	private WebElement physicianNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='physicianCode-field']")
	private WebElement physicianCodeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesNhisClaimCrudEditPage(
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
			"admin/entities/nhis-claim/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (NhisClaimEntity) abstractEntity;
		systemClaimIDField.sendKeys(entity.getSystemClaimID());
		refInvoiceNoField.sendKeys(entity.getRefInvoiceNo());
		formNoField.sendKeys(entity.getFormNo());
		claimIDField.sendKeys(entity.getClaimID());
		claimCheckCodeField.sendKeys(entity.getClaimCheckCode());
		batchNumberField.sendKeys(entity.getBatchNumber());
		surnameField.sendKeys(entity.getSurname());
		otherNamesField.sendKeys(entity.getOtherNames());
		genderField.sendKeys(entity.getGender());
		// TODO default handling for dataAttribute dateOfBirthField
		dateOfBirthField.sendKeys(entity.getDateOfBirth().toString());

		memberNoField.sendKeys(entity.getMemberNo());
		hospitalRecordNoField.sendKeys(entity.getHospitalRecordNo());
		cardSerialNumberField.sendKeys(entity.getCardSerialNumber());
		if (entity.getDependant()) {
			dependantField.click();
		}
		if (entity.getUnbundled()) {
			unbundledField.click();
		}
		if (entity.getIncludesPharmacy()) {
			includesPharmacyField.click();
		}
		typeOfAttendanceField.sendKeys(entity.getTypeOfAttendance());
		// TODO default handling for dataAttribute firstVisitAdmissionField
		firstVisitAdmissionField.sendKeys(entity.getFirstVisitAdmission().toString());

		// TODO default handling for dataAttribute secondVisitDischargeField
		secondVisitDischargeField.sendKeys(entity.getSecondVisitDischarge().toString());

		// TODO default handling for dataAttribute thirdVisitField
		thirdVisitField.sendKeys(entity.getThirdVisit().toString());

		// TODO default handling for dataAttribute fourthVisitField
		fourthVisitField.sendKeys(entity.getFourthVisit().toString());

		physicianNameField.sendKeys(entity.getPhysicianName());
		physicianCodeField.sendKeys(entity.getPhysicianCode());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}