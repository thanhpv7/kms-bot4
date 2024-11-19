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
import kmsweb.entities.IntraoperativeRecordsEntity;

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
 * Intraoperative RecordsPage is a Page POM that is associated with the admin/entities/intraoperative-records url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesIntraoperativeRecordsCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute startDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='startDateTime-field']")
	private WebElement startDateTimeField;
	// TODO default handling dataAttribute endDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='endDateTime-field']")
	private WebElement endDateTimeField;
	// TODO default handling dataAttribute surgeryStartDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryStartDateTime-field']")
	private WebElement surgeryStartDateTimeField;
	// TODO default handling dataAttribute surgeryEndDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryEndDateTime-field']")
	private WebElement surgeryEndDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryDetails-field']")
	private WebElement surgeryDetailsField;
	@FindBy(how = How.XPATH, using = "//*[@id='bloodTransfusion-field']")
	private WebElement bloodTransfusionField;
	@FindBy(how = How.XPATH, using = "//*[@id='instrumentsUsed-field']")
	private WebElement instrumentsUsedField;
	// TODO default handling dataAttribute anesthesiaStartDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaStartDateTime-field']")
	private WebElement anesthesiaStartDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaType-field']")
	private WebElement anesthesiaTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaMethod-field']")
	private WebElement anesthesiaMethodField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaAgents-field']")
	private WebElement anesthesiaAgentsField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaObservations-field']")
	private WebElement anesthesiaObservationsField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaNotes-field']")
	private WebElement anesthesiaNotesField;
	// TODO default handling dataAttribute anesthesiaEndDateTimeField;
	@FindBy(how = How.XPATH, using = "//*[@id='anesthesiaEndDateTime-field']")
	private WebElement anesthesiaEndDateTimeField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingTheaterMedicalExaminationRecordId-field']")
	private WebElement operatingTheaterMedicalExaminationRecordField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilitiesIds-field']")
	private WebElement bedFacilitiesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingRoomId-field']")
	private WebElement operatingRoomField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesIntraoperativeRecordsCrudEditPage(
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
			"admin/entities/intraoperative-records/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (IntraoperativeRecordsEntity) abstractEntity;
		// TODO default handling for dataAttribute startDateTimeField
		startDateTimeField.sendKeys(entity.getStartDateTime().toString());

		// TODO default handling for dataAttribute endDateTimeField
		endDateTimeField.sendKeys(entity.getEndDateTime().toString());

		// TODO default handling for dataAttribute surgeryStartDateTimeField
		surgeryStartDateTimeField.sendKeys(entity.getSurgeryStartDateTime().toString());

		// TODO default handling for dataAttribute surgeryEndDateTimeField
		surgeryEndDateTimeField.sendKeys(entity.getSurgeryEndDateTime().toString());

		surgeryDetailsField.sendKeys(entity.getSurgeryDetails());
		bloodTransfusionField.sendKeys(entity.getBloodTransfusion());
		instrumentsUsedField.sendKeys(entity.getInstrumentsUsed());
		// TODO default handling for dataAttribute anesthesiaStartDateTimeField
		anesthesiaStartDateTimeField.sendKeys(entity.getAnesthesiaStartDateTime().toString());

		anesthesiaTypeField.sendKeys(entity.getAnesthesiaType());
		anesthesiaMethodField.sendKeys(entity.getAnesthesiaMethod());
		anesthesiaAgentsField.sendKeys(entity.getAnesthesiaAgents());
		anesthesiaObservationsField.sendKeys(entity.getAnesthesiaObservations());
		anesthesiaNotesField.sendKeys(entity.getAnesthesiaNotes());
		// TODO default handling for dataAttribute anesthesiaEndDateTimeField
		anesthesiaEndDateTimeField.sendKeys(entity.getAnesthesiaEndDateTime().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}