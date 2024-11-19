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
import kmsweb.entities.BpjsSpecialReferralEntity;

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
 * BPJS Special ReferralPage is a Page POM that is associated with the admin/entities/bpjs-special-referral url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsSpecialReferralCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='referralID-field']")
	private WebElement referralIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralNo-field']")
	private WebElement referralNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='name-field']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//*[@id='ppkDiagnose-field']")
	private WebElement ppkDiagnoseField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralStartDate-field']")
	private WebElement referralStartDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralEndDate-field']")
	private WebElement referralEndDateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='additionalDiagnoseId-field']")
	private WebElement additionalDiagnoseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='additionalProcedureId-field']")
	private WebElement additionalProcedureField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='primaryDiagnoseId-field']")
	private WebElement primaryDiagnoseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='primaryProcedureId-field']")
	private WebElement primaryProcedureField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsSpecialReferralCrudEditPage(
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
			"admin/entities/bpjs-special-referral/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsSpecialReferralEntity) abstractEntity;
		referralIDField.sendKeys(entity.getReferralID());
		referralNoField.sendKeys(entity.getReferralNo());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		nameField.sendKeys(entity.getName());
		ppkDiagnoseField.sendKeys(entity.getPpkDiagnose());
		referralStartDateField.sendKeys(entity.getReferralStartDate());
		referralEndDateField.sendKeys(entity.getReferralEndDate());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}