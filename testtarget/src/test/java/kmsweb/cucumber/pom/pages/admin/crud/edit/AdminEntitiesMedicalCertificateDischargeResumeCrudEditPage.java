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
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;

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
 * Medical Certificate  Discharge ResumePage is a Page POM that is associated with the admin/entities/medical-certificate-discharge-resume url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicalCertificateDischargeResumeCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute admissionDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDateTime-field']")
	private WebElement admissionDateTimeField;
	// TODO default handling dataAttribute dischargeDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dischargeDateTime-field']")
	private WebElement dischargeDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='condition-field']")
	private WebElement conditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='mainDiagnosis-field']")
	private WebElement mainDiagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='action-field']")
	private WebElement actionField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dischargeICD10Id-field']")
	private WebElement dischargeICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dischargeICD9CMId-field']")
	private WebElement dischargeICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffId-field']")
	private WebElement medicalStaffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicalCertificateDischargeResumeCrudEditPage(
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
			"admin/entities/medical-certificate-discharge-resume/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicalCertificateDischargeResumeEntity) abstractEntity;
		// TODO default handling for dataAttribute admissionDateTimeField
		admissionDateTimeField.sendKeys(entity.getAdmissionDateTime().toString());

		// TODO default handling for dataAttribute dischargeDateTimeField
		dischargeDateTimeField.sendKeys(entity.getDischargeDateTime().toString());

		conditionField.sendKeys(entity.getCondition());
		mainDiagnosisField.sendKeys(entity.getMainDiagnosis());
		actionField.sendKeys(entity.getAction());
		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}