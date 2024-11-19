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
import kmsweb.entities.HemodialysisExaminationEntity;

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
 * Hemodialysis ExaminationPage is a Page POM that is associated with the admin/entities/hemodialysis-examination url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesHemodialysisExaminationCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='firstDialysis-field']")
	private WebElement firstDialysisField;
	@FindBy(how = How.XPATH, using = "//*[@id='dialysisFrequency-field']")
	private WebElement dialysisFrequencyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dialysisNo-field']")
	private WebElement dialysisNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='hemodialysisType-field']")
	private WebElement hemodialysisTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='condition-field']")
	private WebElement conditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='vascularAccess-field']")
	private WebElement vascularAccessField;
	@FindBy(how = How.XPATH, using = "//*[@id='heparinization-field']")
	private WebElement heparinizationField;
	@FindBy(how = How.XPATH, using = "//*[@id='heparinizationInitialDose-field']")
	private WebElement heparinizationInitialDoseField;
	@FindBy(how = How.XPATH, using = "//*[@id='heparinizationFollowUpDose-field']")
	private WebElement heparinizationFollowUpDoseField;
	@FindBy(how = How.XPATH, using = "//*[@id='dialyzer-field']")
	private WebElement dialyzerField;
	@FindBy(how = How.XPATH, using = "//*[@id='dialyzerType-field']")
	private WebElement dialyzerTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='dialysisFluid-field']")
	private WebElement dialysisFluidField;
	@FindBy(how = How.XPATH, using = "//*[@id='dryWeight-field']")
	private WebElement dryWeightField;
	@FindBy(how = How.XPATH, using = "//*[@id='dryWeightUnit-field']")
	private WebElement dryWeightUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUponArrival-field']")
	private WebElement weightUponArrivalField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUponArrivalUnit-field']")
	private WebElement weightUponArrivalUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightDuringPreviousHemodialysis-field']")
	private WebElement weightDuringPreviousHemodialysisField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightDuringPreviousHemodialysisUnit-field']")
	private WebElement weightDuringPreviousHemodialysisUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='antiHIV-field']")
	private WebElement antiHIVField;
	@FindBy(how = How.XPATH, using = "//*[@id='hbsag-field']")
	private WebElement hbsagField;
	@FindBy(how = How.XPATH, using = "//*[@id='antiHCV-field']")
	private WebElement antiHCVField;
	@FindBy(how = How.XPATH, using = "//*[@id='hemodialysisStartTime-field']")
	private WebElement hemodialysisStartTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='hemodialysisEndTime-field']")
	private WebElement hemodialysisEndTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='target-field']")
	private WebElement targetField;
	@FindBy(how = How.XPATH, using = "//*[@id='primingVolume-field']")
	private WebElement primingVolumeField;
	@FindBy(how = How.XPATH, using = "//*[@id='remainingPriming-field']")
	private WebElement remainingPrimingField;
	@FindBy(how = How.XPATH, using = "//*[@id='complication-field']")
	private WebElement complicationField;
	@FindBy(how = How.XPATH, using = "//*[@id='hemodialysisDetails-field']")
	private WebElement hemodialysisDetailsField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUponDismissal-field']")
	private WebElement weightUponDismissalField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUponDismissalUnit-field']")
	private WebElement weightUponDismissalUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='priming-field']")
	private WebElement primingField;
	@FindBy(how = How.XPATH, using = "//*[@id='blood-field']")
	private WebElement bloodField;
	@FindBy(how = How.XPATH, using = "//*[@id='ivLine-field']")
	private WebElement ivLineField;
	@FindBy(how = How.XPATH, using = "//*[@id='oral-field']")
	private WebElement oralField;
	@FindBy(how = How.XPATH, using = "//*[@id='washOut-field']")
	private WebElement washOutField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalFluidIntake-field']")
	private WebElement totalFluidIntakeField;
	@FindBy(how = How.XPATH, using = "//*[@id='urine-field']")
	private WebElement urineField;
	@FindBy(how = How.XPATH, using = "//*[@id='others-field']")
	private WebElement othersField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalFluidOutput-field']")
	private WebElement totalFluidOutputField;
	@FindBy(how = How.XPATH, using = "//*[@id='fluidBalance-field']")
	private WebElement fluidBalanceField;
	@FindBy(how = How.XPATH, using = "//*[@id='postHemodialysisEvaluation-field']")
	private WebElement postHemodialysisEvaluationField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='hemodialysisMonitoringsIds-field']")
	private WebElement hemodialysisMonitoringsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesHemodialysisExaminationCrudViewPage(
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
			"admin/entities/hemodialysis-examination/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}