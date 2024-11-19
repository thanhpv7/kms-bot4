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
import kmsweb.entities.BpjsSEPInternalDataEntity;

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
 * BPJS SEP Internal DataPage is a Page POM that is associated with the admin/entities/bpjs-sep-internal-data url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsSEPInternalDataCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='referredPolyclinic-field']")
	private WebElement referredPolyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='referringPolyclinic-field']")
	private WebElement referringPolyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='internalReferralDate-field']")
	private WebElement internalReferralDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='refSEPNo-field']")
	private WebElement refSEPNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepHealthFacility-field']")
	private WebElement sepHealthFacilityField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepDate-field']")
	private WebElement sepDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='letterNo-field']")
	private WebElement letterNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='isInternal-field']")
	private WebElement isInternalField;
	@FindBy(how = How.XPATH, using = "//*[@id='referringPolyclinicCode-field']")
	private WebElement referringPolyclinicCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosticSupport-field']")
	private WebElement diagnosticSupportField;
	@FindBy(how = How.XPATH, using = "//*[@id='referringDiagnose-field']")
	private WebElement referringDiagnoseField;
	@FindBy(how = How.XPATH, using = "//*[@id='doctor-field']")
	private WebElement doctorField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsSEPInternalDataCrudEditPage(
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
			"admin/entities/bpjs-sep-internal-data/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsSEPInternalDataEntity) abstractEntity;
		referredPolyclinicField.sendKeys(entity.getReferredPolyclinic());
		referringPolyclinicField.sendKeys(entity.getReferringPolyclinic());
		internalReferralDateField.sendKeys(entity.getInternalReferralDate());
		sepNoField.sendKeys(entity.getSepNo());
		refSEPNoField.sendKeys(entity.getRefSEPNo());
		sepHealthFacilityField.sendKeys(entity.getSepHealthFacility());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		sepDateField.sendKeys(entity.getSepDate());
		letterNoField.sendKeys(entity.getLetterNo());
		isInternalField.sendKeys(entity.getIsInternal());
		referringPolyclinicCodeField.sendKeys(entity.getReferringPolyclinicCode());
		diagnosticSupportField.sendKeys(entity.getDiagnosticSupport());
		referringDiagnoseField.sendKeys(entity.getReferringDiagnose());
		doctorField.sendKeys(entity.getDoctor());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}