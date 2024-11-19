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
import kmsweb.entities.BpjsPRBEntity;

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
 * BPJS PRBPage is a Page POM that is associated with the admin/entities/bpjs-prb url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPRBCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='srbNo-field']")
	private WebElement srbNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='address-field']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='prbProgramCode-field']")
	private WebElement prbProgramCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='prbProgramName-field']")
	private WebElement prbProgramNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorCode-field']")
	private WebElement doctorCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctorName-field']")
	private WebElement doctorNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	@FindBy(how = How.XPATH, using = "//*[@id='recommendation-field']")
	private WebElement recommendationField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDiagnosePRBId-field']")
	private WebElement bpjsDiagnosePRBField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDoctorMappingId-field']")
	private WebElement bpjsDoctorMappingField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPRBCrudEditPage(
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
			"admin/entities/bpjs-prb/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsPRBEntity) abstractEntity;
		srbNoField.sendKeys(entity.getSrbNo());
		sepNoField.sendKeys(entity.getSepNo());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		addressField.sendKeys(entity.getAddress());
		emailField.sendKeys(entity.getEmail());
		prbProgramCodeField.sendKeys(entity.getPrbProgramCode());
		prbProgramNameField.sendKeys(entity.getPrbProgramName());
		doctorCodeField.sendKeys(entity.getDoctorCode());
		doctorNameField.sendKeys(entity.getDoctorName());
		notesField.sendKeys(entity.getNotes());
		recommendationField.sendKeys(entity.getRecommendation());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}