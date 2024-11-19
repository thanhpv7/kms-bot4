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
public class AdminEntitiesDeliveryMedicalExaminationRecordCrudEditPage extends CrudEdit {

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
	// TODO default handling dataAttribute lnmpStartDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lnmpStartDate-field']")
	private WebElement lnmpStartDateField;
	// TODO default handling dataAttribute lnmpEndDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lnmpEndDate-field']")
	private WebElement lnmpEndDateField;
	// TODO default handling dataAttribute approximateBirthDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approximateBirthDate-field']")
	private WebElement approximateBirthDateField;
	// TODO default handling dataAttribute gestationAgeWeeksField;
	@FindBy(how = How.XPATH, using = "//*[@id='gestationAgeWeeks-field']")
	private WebElement gestationAgeWeeksField;
	// TODO default handling dataAttribute gestationAgeDaysField;
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
	// TODO default handling dataAttribute stage1HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage1Hour-field']")
	private WebElement stage1HourField;
	// TODO default handling dataAttribute unnamedInteger1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='unnamedInteger1-field']")
	private WebElement unnamedInteger1Field;
	// TODO default handling dataAttribute stage3HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage3Hour-field']")
	private WebElement stage3HourField;
	// TODO default handling dataAttribute stage4HourField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage4Hour-field']")
	private WebElement stage4HourField;
	// TODO default handling dataAttribute stage1MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage1Minute-field']")
	private WebElement stage1MinuteField;
	// TODO default handling dataAttribute stage2MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage2Minute-field']")
	private WebElement stage2MinuteField;
	// TODO default handling dataAttribute stage3MinuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='stage3Minute-field']")
	private WebElement stage3MinuteField;
	// TODO default handling dataAttribute stage4MinuteField;
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
	// TODO default handling dataAttribute newbornDeliveredField;
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
	public AdminEntitiesDeliveryMedicalExaminationRecordCrudEditPage(
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
			"admin/entities/delivery-medical-examination-record/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (DeliveryMedicalExaminationRecordEntity) abstractEntity;
		pregnancyHistoryGravidaField.sendKeys(entity.getPregnancyHistoryGravida());
		pregnancyHistoryPartumField.sendKeys(entity.getPregnancyHistoryPartum());
		pregnancyHistoryAbortumField.sendKeys(entity.getPregnancyHistoryAbortum());
		pregnancyHistoryNotesField.sendKeys(entity.getPregnancyHistoryNotes());
		// TODO default handling for dataAttribute lnmpStartDateField
		lnmpStartDateField.sendKeys(entity.getLnmpStartDate().toString());

		// TODO default handling for dataAttribute lnmpEndDateField
		lnmpEndDateField.sendKeys(entity.getLnmpEndDate().toString());

		// TODO default handling for dataAttribute approximateBirthDateField
		approximateBirthDateField.sendKeys(entity.getApproximateBirthDate().toString());

		// TODO default handling for dataAttribute gestationAgeWeeksField
		gestationAgeWeeksField.sendKeys(entity.getGestationAgeWeeks().toString());

		// TODO default handling for dataAttribute gestationAgeDaysField
		gestationAgeDaysField.sendKeys(entity.getGestationAgeDays().toString());

		if (entity.getTetanusVaccine1()) {
			tetanusVaccine1Field.click();
		}
		if (entity.getTetanusVaccine2()) {
			tetanusVaccine2Field.click();
		}
		deliveryTypeField.sendKeys(entity.getDeliveryType());
		complicationsInPregnancyField.sendKeys(entity.getComplicationsInPregnancy());
		riskFactorField.sendKeys(entity.getRiskFactor());
		fetalPresentationField.sendKeys(entity.getFetalPresentation());
		abdomenExaminationField.sendKeys(entity.getAbdomenExamination());
		fundalHeightField.sendKeys(entity.getFundalHeight());
		fhrPerMinuteField.sendKeys(entity.getFhrPerMinute());
		estimatedFetalWeightField.sendKeys(entity.getEstimatedFetalWeight());
		leopold1Field.sendKeys(entity.getLeopold1());
		leopold2Field.sendKeys(entity.getLeopold2());
		leopold3Field.sendKeys(entity.getLeopold3());
		leopold4Field.sendKeys(entity.getLeopold4());
		geniteliaExternaField.sendKeys(entity.getGeniteliaExterna());
		geniteliaInternaField.sendKeys(entity.getGeniteliaInterna());
		vaginalExaminationField.sendKeys(entity.getVaginalExamination());
		deliveryComplicationField.sendKeys(entity.getDeliveryComplication());
		deliveryNoteField.sendKeys(entity.getDeliveryNote());
		if (entity.getNormalDeliveryCase()) {
			normalDeliveryCaseField.click();
		}
		// TODO default handling for dataAttribute stage1HourField
		stage1HourField.sendKeys(entity.getStage1Hour().toString());

		// TODO default handling for dataAttribute unnamedInteger1Field
		unnamedInteger1Field.sendKeys(entity.getUnnamedInteger1().toString());

		// TODO default handling for dataAttribute stage3HourField
		stage3HourField.sendKeys(entity.getStage3Hour().toString());

		// TODO default handling for dataAttribute stage4HourField
		stage4HourField.sendKeys(entity.getStage4Hour().toString());

		// TODO default handling for dataAttribute stage1MinuteField
		stage1MinuteField.sendKeys(entity.getStage1Minute().toString());

		// TODO default handling for dataAttribute stage2MinuteField
		stage2MinuteField.sendKeys(entity.getStage2Minute().toString());

		// TODO default handling for dataAttribute stage3MinuteField
		stage3MinuteField.sendKeys(entity.getStage3Minute().toString());

		// TODO default handling for dataAttribute stage4MinuteField
		stage4MinuteField.sendKeys(entity.getStage4Minute().toString());

		placentaField.sendKeys(entity.getPlacenta());
		perineumField.sendKeys(entity.getPerineum());
		bleedingField.sendKeys(entity.getBleeding());
		postpartumComplicationField.sendKeys(entity.getPostpartumComplication());
		// TODO default handling for dataAttribute newbornDeliveredField
		newbornDeliveredField.sendKeys(entity.getNewbornDelivered().toString());

		if (entity.getPerineumInfection()) {
			perineumInfectionField.click();
		}
		if (entity.getEarlyBreastfeedingIntiation()) {
			earlyBreastfeedingIntiationField.click();
		}

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}