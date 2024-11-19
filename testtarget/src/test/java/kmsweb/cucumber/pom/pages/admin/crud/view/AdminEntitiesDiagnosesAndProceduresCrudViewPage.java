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
package kmsweb.cucumber.pom.pages.admin.crud.view;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.DiagnosesAndProceduresEntity;

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
 * Diagnoses and ProceduresPage is a Page POM that is associated with the admin/entities/diagnoses-and-procedures url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDiagnosesAndProceduresCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='itemType-field']")
	private WebElement itemTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='itemCode-field']")
	private WebElement itemCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='masterICD10-field']")
	private WebElement masterICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='masterICD9CM-field']")
	private WebElement masterICD9CMField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDiagnoseId-field']")
	private WebElement bpjsDiagnoseField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDiagnosePRBId-field']")
	private WebElement bpjsDiagnosePRBField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='admissionICD10Ids-field']")
	private WebElement admissionICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='admissionICD9CMIds-field']")
	private WebElement admissionICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cpptICD10Ids-field']")
	private WebElement cpptICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='cpptICD9CMIds-field']")
	private WebElement cpptICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dischargeICD10Ids-field']")
	private WebElement dischargeICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='dischargeICD9CMIds-field']")
	private WebElement dischargeICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd10Ids-field']")
	private WebElement icd10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='icd9CMIds-field']")
	private WebElement icd9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicesICD10Ids-field']")
	private WebElement invoicesICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicesICD9CMIds-field']")
	private WebElement invoicesICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='postOperativeICD10Ids-field']")
	private WebElement postOperativeICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='postOperativeICD9CMIds-field']")
	private WebElement postOperativeICD9CMField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preSurgeryICD10Ids-field']")
	private WebElement preSurgeryICD10Field;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preSurgeryICD9CMIds-field']")
	private WebElement preSurgeryICD9CMField;

	// Incoming one-to-many

	// Outgoing many-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='diagnosisNandasIds-field']")
	private WebElement diagnosisNandasField;

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDiagnosesAndProceduresCrudViewPage(
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
			"admin/entities/diagnoses-and-procedures/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}