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
import kmsweb.entities.FluidBalanceDetailEntity;

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
 * Fluid Balance DetailPage is a Page POM that is associated with the admin/entities/fluid-balance-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesFluidBalanceDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute recordDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='recordDateTime-field']")
	private WebElement recordDateTimeField;
	// TODO default handling dataAttribute intakeOralField;
	@FindBy(how = How.XPATH, using = "//*[@id='intakeOral-field']")
	private WebElement intakeOralField;
	// TODO default handling dataAttribute intakeNGTField;
	@FindBy(how = How.XPATH, using = "//*[@id='intakeNGT-field']")
	private WebElement intakeNGTField;
	// TODO default handling dataAttribute intakeIVLineField;
	@FindBy(how = How.XPATH, using = "//*[@id='intakeIVLine-field']")
	private WebElement intakeIVLineField;
	// TODO default handling dataAttribute intakeOthersField;
	@FindBy(how = How.XPATH, using = "//*[@id='intakeOthers-field']")
	private WebElement intakeOthersField;
	// TODO default handling dataAttribute outputUrineField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputUrine-field']")
	private WebElement outputUrineField;
	// TODO default handling dataAttribute outputNGTField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputNGT-field']")
	private WebElement outputNGTField;
	// TODO default handling dataAttribute outputDrainField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputDrain-field']")
	private WebElement outputDrainField;
	// TODO default handling dataAttribute outputStoolField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputStool-field']")
	private WebElement outputStoolField;
	// TODO default handling dataAttribute outputBloodField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputBlood-field']")
	private WebElement outputBloodField;
	// TODO default handling dataAttribute outputIWLField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputIWL-field']")
	private WebElement outputIWLField;
	// TODO default handling dataAttribute outputOthersField;
	@FindBy(how = How.XPATH, using = "//*[@id='outputOthers-field']")
	private WebElement outputOthersField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute totalInputField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalInput-field']")
	private WebElement totalInputField;
	// TODO default handling dataAttribute totalOutputField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalOutput-field']")
	private WebElement totalOutputField;
	// TODO default handling dataAttribute totalBalanceFluidField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalBalanceFluid-field']")
	private WebElement totalBalanceFluidField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesFluidBalanceDetailCrudEditPage(
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
			"admin/entities/fluid-balance-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (FluidBalanceDetailEntity) abstractEntity;
		// TODO default handling for dataAttribute recordDateTimeField
		recordDateTimeField.sendKeys(entity.getRecordDateTime().toString());

		// TODO default handling for dataAttribute intakeOralField
		intakeOralField.sendKeys(entity.getIntakeOral().toString());

		// TODO default handling for dataAttribute intakeNGTField
		intakeNGTField.sendKeys(entity.getIntakeNGT().toString());

		// TODO default handling for dataAttribute intakeIVLineField
		intakeIVLineField.sendKeys(entity.getIntakeIVLine().toString());

		// TODO default handling for dataAttribute intakeOthersField
		intakeOthersField.sendKeys(entity.getIntakeOthers().toString());

		// TODO default handling for dataAttribute outputUrineField
		outputUrineField.sendKeys(entity.getOutputUrine().toString());

		// TODO default handling for dataAttribute outputNGTField
		outputNGTField.sendKeys(entity.getOutputNGT().toString());

		// TODO default handling for dataAttribute outputDrainField
		outputDrainField.sendKeys(entity.getOutputDrain().toString());

		// TODO default handling for dataAttribute outputStoolField
		outputStoolField.sendKeys(entity.getOutputStool().toString());

		// TODO default handling for dataAttribute outputBloodField
		outputBloodField.sendKeys(entity.getOutputBlood().toString());

		// TODO default handling for dataAttribute outputIWLField
		outputIWLField.sendKeys(entity.getOutputIWL().toString());

		// TODO default handling for dataAttribute outputOthersField
		outputOthersField.sendKeys(entity.getOutputOthers().toString());

		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute totalInputField
		totalInputField.sendKeys(entity.getTotalInput().toString());

		// TODO default handling for dataAttribute totalOutputField
		totalOutputField.sendKeys(entity.getTotalOutput().toString());

		// TODO default handling for dataAttribute totalBalanceFluidField
		totalBalanceFluidField.sendKeys(entity.getTotalBalanceFluid().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}