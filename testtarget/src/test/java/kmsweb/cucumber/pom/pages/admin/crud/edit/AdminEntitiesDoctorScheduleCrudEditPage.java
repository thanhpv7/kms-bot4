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
import kmsweb.entities.DoctorScheduleEntity;

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
 * Doctor SchedulePage is a Page POM that is associated with the admin/entities/doctor-schedule url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesDoctorScheduleCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute startDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='startDateTime-field']")
	private WebElement startDateTimeField;
	// TODO default handling dataAttribute endDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='endDateTime-field']")
	private WebElement endDateTimeField;
	// TODO default handling dataAttribute intervalInMinutesField;
	@FindBy(how = How.XPATH, using = "//*[@id='intervalInMinutes-field']")
	private WebElement intervalInMinutesField;
	@FindBy(how = How.XPATH, using = "//*[@id='location-field']")
	private WebElement locationField;
	@FindBy(how = How.XPATH, using = "//*[@id='schedulerType-field']")
	private WebElement schedulerTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='monday-field']")
	private WebElement mondayField;
	@FindBy(how = How.XPATH, using = "//*[@id='tuesday-field']")
	private WebElement tuesdayField;
	@FindBy(how = How.XPATH, using = "//*[@id='wednesday-field']")
	private WebElement wednesdayField;
	@FindBy(how = How.XPATH, using = "//*[@id='thursday-field']")
	private WebElement thursdayField;
	@FindBy(how = How.XPATH, using = "//*[@id='friday-field']")
	private WebElement fridayField;
	@FindBy(how = How.XPATH, using = "//*[@id='saturday-field']")
	private WebElement saturdayField;
	@FindBy(how = How.XPATH, using = "//*[@id='sunday-field']")
	private WebElement sundayField;
	@FindBy(how = How.XPATH, using = "//*[@id='email-field']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//*[@id='training-field']")
	private WebElement trainingField;
	// TODO default handling dataAttribute dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='shift-field']")
	private WebElement shiftField;
	// TODO default handling dataAttribute intervalsField;
	@FindBy(how = How.XPATH, using = "//*[@id='intervals-field']")
	private WebElement intervalsField;
	@FindBy(how = How.XPATH, using = "//*[@id='repetition-field']")
	private WebElement repetitionField;
	// TODO default handling dataAttribute numberOfRepetitionField;
	@FindBy(how = How.XPATH, using = "//*[@id='numberOfRepetition-field']")
	private WebElement numberOfRepetitionField;
	// TODO default handling dataAttribute finalScheduleField;
	@FindBy(how = How.XPATH, using = "//*[@id='finalSchedule-field']")
	private WebElement finalScheduleField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceId-field']")
	private WebElement serviceField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='staffId-field']")
	private WebElement staffField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesDoctorScheduleCrudEditPage(
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
			"admin/entities/doctor-schedule/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (DoctorScheduleEntity) abstractEntity;
		// TODO default handling for dataAttribute startDateTimeField
		startDateTimeField.sendKeys(entity.getStartDateTime().toString());

		// TODO default handling for dataAttribute endDateTimeField
		endDateTimeField.sendKeys(entity.getEndDateTime().toString());

		// TODO default handling for dataAttribute intervalInMinutesField
		intervalInMinutesField.sendKeys(entity.getIntervalInMinutes().toString());

		locationField.sendKeys(entity.getLocation());
		schedulerTypeField.sendKeys(entity.getSchedulerType());
		if (entity.getMonday()) {
			mondayField.click();
		}
		if (entity.getTuesday()) {
			tuesdayField.click();
		}
		if (entity.getWednesday()) {
			wednesdayField.click();
		}
		if (entity.getThursday()) {
			thursdayField.click();
		}
		if (entity.getFriday()) {
			fridayField.click();
		}
		if (entity.getSaturday()) {
			saturdayField.click();
		}
		if (entity.getSunday()) {
			sundayField.click();
		}
		emailField.sendKeys(entity.getEmail());
		trainingField.sendKeys(entity.getTraining());
		// TODO default handling for dataAttribute dismissalDateField
		dismissalDateField.sendKeys(entity.getDismissalDate().toString());

		shiftField.sendKeys(entity.getShift());
		// TODO default handling for dataAttribute intervalsField
		intervalsField.sendKeys(entity.getIntervals().toString());

		if (entity.getRepetition()) {
			repetitionField.click();
		}
		// TODO default handling for dataAttribute numberOfRepetitionField
		numberOfRepetitionField.sendKeys(entity.getNumberOfRepetition().toString());

		// TODO default handling for dataAttribute finalScheduleField
		finalScheduleField.sendKeys(entity.getFinalSchedule().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}