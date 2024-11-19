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
import kmsweb.entities.NewbornDetailEntity;

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
 * Newborn DetailPage is a Page POM that is associated with the admin/entities/newborn-detail url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesNewbornDetailCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='newbornFirstName-field']")
	private WebElement newbornFirstNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='newbornLastName-field']")
	private WebElement newbornLastNameField;
	// TODO default handling dataAttribute dateTimeOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateTimeOfBirth-field']")
	private WebElement dateTimeOfBirthField;
	@FindBy(how = How.XPATH, using = "//*[@id='gender-field']")
	private WebElement genderField;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryType-field']")
	private WebElement deliveryTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='deliveryTypeIndication-field']")
	private WebElement deliveryTypeIndicationField;
	// TODO default handling dataAttribute weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	// TODO default handling dataAttribute lengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='length-field']")
	private WebElement lengthField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightOfGestationalAge-field']")
	private WebElement weightOfGestationalAgeField;
	// TODO default handling dataAttribute headCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='headCircumference-field']")
	private WebElement headCircumferenceField;
	// TODO default handling dataAttribute chestCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='chestCircumference-field']")
	private WebElement chestCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='birthCondition-field']")
	private WebElement birthConditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='neonatalCase-field']")
	private WebElement neonatalCaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='congenitalCondition-field']")
	private WebElement congenitalConditionField;
	@FindBy(how = How.XPATH, using = "//*[@id='physicalExamination-field']")
	private WebElement physicalExaminationField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinuteAppearance-field']")
	private WebElement apgar1MinuteAppearanceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinuteAppearance-field']")
	private WebElement apgar5MinuteAppearanceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinuteAppearance-field']")
	private WebElement apgar10MinuteAppearanceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinutePulse-field']")
	private WebElement apgar1MinutePulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinutePulse-field']")
	private WebElement apgar5MinutePulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinutePulse-field']")
	private WebElement apgar10MinutePulseField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinuteGrimace-field']")
	private WebElement apgar1MinuteGrimaceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinuteGrimace-field']")
	private WebElement apgar5MinuteGrimaceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinuteGrimace-field']")
	private WebElement apgar10MinuteGrimaceField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinuteActivity-field']")
	private WebElement apgar1MinuteActivityField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinuteActivity-field']")
	private WebElement apgar5MinuteActivityField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinuteActivity-field']")
	private WebElement apgar10MinuteActivityField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinuteRespiration-field']")
	private WebElement apgar1MinuteRespirationField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinuteRespiration-field']")
	private WebElement apgar5MinuteRespirationField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinuteRespiration-field']")
	private WebElement apgar10MinuteRespirationField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar1MinuteScore-field']")
	private WebElement apgar1MinuteScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar5MinuteScore-field']")
	private WebElement apgar5MinuteScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='apgar10MinuteScore-field']")
	private WebElement apgar10MinuteScoreField;
	@FindBy(how = How.XPATH, using = "//*[@id='pediatricNurse-field']")
	private WebElement pediatricNurseField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientId-field']")
	private WebElement patientIdField;
	@FindBy(how = How.XPATH, using = "//*[@id='registrationId-field']")
	private WebElement registrationIdField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='vitalSignsIds-field']")
	private WebElement vitalSignsField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='deliveryMedicalExaminationRecordId-field']")
	private WebElement deliveryMedicalExaminationRecordField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesNewbornDetailCrudEditPage(
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
			"admin/entities/newborn-detail/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (NewbornDetailEntity) abstractEntity;
		newbornFirstNameField.sendKeys(entity.getNewbornFirstName());
		newbornLastNameField.sendKeys(entity.getNewbornLastName());
		// TODO default handling for dataAttribute dateTimeOfBirthField
		dateTimeOfBirthField.sendKeys(entity.getDateTimeOfBirth().toString());

		genderField.sendKeys(entity.getGender());
		deliveryTypeField.sendKeys(entity.getDeliveryType());
		deliveryTypeIndicationField.sendKeys(entity.getDeliveryTypeIndication());
		// TODO default handling for dataAttribute weightField
		weightField.sendKeys(entity.getWeight().toString());

		// TODO default handling for dataAttribute lengthField
		lengthField.sendKeys(entity.getLength().toString());

		weightOfGestationalAgeField.sendKeys(entity.getWeightOfGestationalAge());
		// TODO default handling for dataAttribute headCircumferenceField
		headCircumferenceField.sendKeys(entity.getHeadCircumference().toString());

		// TODO default handling for dataAttribute chestCircumferenceField
		chestCircumferenceField.sendKeys(entity.getChestCircumference().toString());

		birthConditionField.sendKeys(entity.getBirthCondition());
		neonatalCaseField.sendKeys(entity.getNeonatalCase());
		congenitalConditionField.sendKeys(entity.getCongenitalCondition());
		physicalExaminationField.sendKeys(entity.getPhysicalExamination());
		apgar1MinuteAppearanceField.sendKeys(entity.getApgar1MinuteAppearance());
		apgar5MinuteAppearanceField.sendKeys(entity.getApgar5MinuteAppearance());
		apgar10MinuteAppearanceField.sendKeys(entity.getApgar10MinuteAppearance());
		apgar1MinutePulseField.sendKeys(entity.getApgar1MinutePulse());
		apgar5MinutePulseField.sendKeys(entity.getApgar5MinutePulse());
		apgar10MinutePulseField.sendKeys(entity.getApgar10MinutePulse());
		apgar1MinuteGrimaceField.sendKeys(entity.getApgar1MinuteGrimace());
		apgar5MinuteGrimaceField.sendKeys(entity.getApgar5MinuteGrimace());
		apgar10MinuteGrimaceField.sendKeys(entity.getApgar10MinuteGrimace());
		apgar1MinuteActivityField.sendKeys(entity.getApgar1MinuteActivity());
		apgar5MinuteActivityField.sendKeys(entity.getApgar5MinuteActivity());
		apgar10MinuteActivityField.sendKeys(entity.getApgar10MinuteActivity());
		apgar1MinuteRespirationField.sendKeys(entity.getApgar1MinuteRespiration());
		apgar5MinuteRespirationField.sendKeys(entity.getApgar5MinuteRespiration());
		apgar10MinuteRespirationField.sendKeys(entity.getApgar10MinuteRespiration());
		apgar1MinuteScoreField.sendKeys(entity.getApgar1MinuteScore());
		apgar5MinuteScoreField.sendKeys(entity.getApgar5MinuteScore());
		apgar10MinuteScoreField.sendKeys(entity.getApgar10MinuteScore());
		pediatricNurseField.sendKeys(entity.getPediatricNurse());
		patientIdField.sendKeys(entity.getPatientId());
		registrationIdField.sendKeys(entity.getRegistrationId());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}