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
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;

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
 * Medical Certificate Physical HealthPage is a Page POM that is associated with the admin/entities/medical-certificate-physical-health url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesMedicalCertificatePhysicalHealthCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute examinationDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='examinationDateTime-field']")
	private WebElement examinationDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='examinationResult-field']")
	private WebElement examinationResultField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='purpose-field']")
	private WebElement purposeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalStaffId-field']")
	private WebElement medicalStaffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesMedicalCertificatePhysicalHealthCrudEditPage(
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
			"admin/entities/medical-certificate-physical-health/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (MedicalCertificatePhysicalHealthEntity) abstractEntity;
		// TODO default handling for dataAttribute examinationDateTimeField
		examinationDateTimeField.sendKeys(entity.getExaminationDateTime().toString());

		if (entity.getExaminationResult()) {
			examinationResultField.click();
		}
		notesField.sendKeys(entity.getNotes());
		purposeField.sendKeys(entity.getPurpose());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}