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
import kmsweb.entities.InsuranceBenefitPlanEntity;

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
 * Insurance Benefit PlanPage is a Page POM that is associated with the admin/entities/insurance-benefit-plan url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesInsuranceBenefitPlanCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='benefitPlanNo-field']")
	private WebElement benefitPlanNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='benefitPlanName-field']")
	private WebElement benefitPlanNameField;
	// TODO default handling dataAttribute maximumCoveragePerTreatmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='maximumCoveragePerTreatment-field']")
	private WebElement maximumCoveragePerTreatmentField;
	// TODO default handling dataAttribute maximumCoveragePerYearField;
	@FindBy(how = How.XPATH, using = "//*[@id='maximumCoveragePerYear-field']")
	private WebElement maximumCoveragePerYearField;
	// TODO default handling dataAttribute createdDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='createdDate-field']")
	private WebElement createdDateField;
	// TODO default handling dataAttribute updatedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='updatedDate-field']")
	private WebElement updatedDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoicePaymentInsurancesIds-field']")
	private WebElement invoicePaymentInsurancesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientPaymentInsurancesIds-field']")
	private WebElement patientPaymentInsurancesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVisitPatientPaymentInsurancesIds-field']")
	private WebElement patientVisitPatientPaymentInsurancesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='insuranceProviderId-field']")
	private WebElement insuranceProviderField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesInsuranceBenefitPlanCrudEditPage(
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
			"admin/entities/insurance-benefit-plan/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (InsuranceBenefitPlanEntity) abstractEntity;
		benefitPlanNoField.sendKeys(entity.getBenefitPlanNo());
		benefitPlanNameField.sendKeys(entity.getBenefitPlanName());
		// TODO default handling for dataAttribute maximumCoveragePerTreatmentField
		maximumCoveragePerTreatmentField.sendKeys(entity.getMaximumCoveragePerTreatment().toString());

		// TODO default handling for dataAttribute maximumCoveragePerYearField
		maximumCoveragePerYearField.sendKeys(entity.getMaximumCoveragePerYear().toString());

		// TODO default handling for dataAttribute createdDateField
		createdDateField.sendKeys(entity.getCreatedDate().toString());

		// TODO default handling for dataAttribute updatedDateField
		updatedDateField.sendKeys(entity.getUpdatedDate().toString());

		notesField.sendKeys(entity.getNotes());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}