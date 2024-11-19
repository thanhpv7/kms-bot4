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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;

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
 * Delivery Medical Examination RecordPage is a Page POM that is associated with the admin/entities/delivery-medical-examination-record url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDeliveryMedicalExaminationRecordCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryGravida-field']")
	private WebElement pregnancyHistoryGravidaField;
	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryPartum-field']")
	private WebElement pregnancyHistoryPartumField;
	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryAbortum-field']")
	private WebElement pregnancyHistoryAbortumField;
	@FindBy(how = How.XPATH, using = "//*[@id='pregnancyHistoryNotes-field']")
	private WebElement pregnancyHistoryNotesField;
	@FindBy(how = How.XPATH, using = "//*[@id='lnmpStartDate-field']")
	private WebElement lnmpStartDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lnmpEndDate-field']")
	private WebElement lnmpEndDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approximateBirthDate-field']")
	private WebElement approximateBirthDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationAgeWeeks-field']")
	private WebElement gestationAgeWeeksField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationAgeDays-field']")
	private WebElement gestationAgeDaysField;
	@FindBy(how = How.XPATH, using = "//*[@id='tetanusVaccine1-field']")
	private WebElement tetanusVaccine1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='tetanusVaccine2-field']")
	private WebElement tetanusVaccine2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryType-field']")
	private WebElement deliveryTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='complicationsInPregnancy-field']")
	private WebElement complicationsInPregnancyField;
	@FindBy(how = How.XPATH, using = "//*[@id='riskFactor-field']")
	private WebElement riskFactorField;
	@FindBy(how = How.XPATH, using = "//*[@id='fetalPresentation-field']")
	private WebElement fetalPresentationField;
	@FindBy(how = How.XPATH, using = "//*[@id='abdomenExamination-field']")
	private WebElement abdomenExaminationField;
	@FindBy(how = How.XPATH, using = "//*[@id='fundalHeight-field']")
	private WebElement fundalHeightField;
	@FindBy(how = How.XPATH, using = "//*[@id='fhrPerMinute-field']")
	private WebElement fhrPerMinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='estimatedFetalWeight-field']")
	private WebElement estimatedFetalWeightField;
	@FindBy(how = How.XPATH, using = "//*[@id='leopold1-field']")
	private WebElement leopold1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='leopold2-field']")
	private WebElement leopold2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='leopold3-field']")
	private WebElement leopold3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='leopold4-field']")
	private WebElement leopold4Field;
	@FindBy(how = How.XPATH, using = "//*[@id='geniteliaExterna-field']")
	private WebElement geniteliaExternaField;
	@FindBy(how = How.XPATH, using = "//*[@id='geniteliaInterna-field']")
	private WebElement geniteliaInternaField;
	@FindBy(how = How.XPATH, using = "//*[@id='vaginalExamination-field']")
	private WebElement vaginalExaminationField;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryComplication-field']")
	private WebElement deliveryComplicationField;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryNote-field']")
	private WebElement deliveryNoteField;
	@FindBy(how = How.XPATH, using = "//*[@id='normalDeliveryCase-field']")
	private WebElement normalDeliveryCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage1Hour-field']")
	private WebElement stage1HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='unnamedInteger1-field']")
	private WebElement unnamedInteger1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='stage3Hour-field']")
	private WebElement stage3HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage4Hour-field']")
	private WebElement stage4HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage1Minute-field']")
	private WebElement stage1MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage2Minute-field']")
	private WebElement stage2MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage3Minute-field']")
	private WebElement stage3MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage4Minute-field']")
	private WebElement stage4MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='placenta-field']")
	private WebElement placentaField;
	@FindBy(how = How.XPATH, using = "//*[@id='perineum-field']")
	private WebElement perineumField;
	@FindBy(how = How.XPATH, using = "//*[@id='bleeding-field']")
	private WebElement bleedingField;
	@FindBy(how = How.XPATH, using = "//*[@id='postpartumComplication-field']")
	private WebElement postpartumComplicationField;
	@FindBy(how = How.XPATH, using = "//*[@id='newbornDelivered-field']")
	private WebElement newbornDeliveredField;
	@FindBy(how = How.XPATH, using = "//*[@id='perineumInfection-field']")
	private WebElement perineumInfectionField;
	@FindBy(how = How.XPATH, using = "//*[@id='earlyBreastfeedingIntiation-field']")
	private WebElement earlyBreastfeedingIntiationField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='additionalMidwivesIds-field']")
	private WebElement additionalMidwivesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='deliveryProgressesIds-field']")
	private WebElement deliveryProgressesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='newbornDetailsIds-field']")
	private WebElement newbornDetailsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='midwifeId-field']")
	private WebElement midwifeField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDeliveryMedicalExaminationRecordCrudViewPage(
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
			"admin/entities/delivery-medical-examination-record/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}