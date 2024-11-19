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
import kmsweb.entities.RoomFacilityEntity;

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
 * Room FacilityPage is a Page POM that is associated with the admin/entities/room-facility url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesRoomFacilityCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='roomNumber-field']")
	private WebElement roomNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='roomName-field']")
	private WebElement roomNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='department-field']")
	private WebElement departmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='genderAllocation-field']")
	private WebElement genderAllocationField;
	@FindBy(how = How.XPATH, using = "//*[@id='location-field']")
	private WebElement locationField;
	@FindBy(how = How.XPATH, using = "//*[@id='notes-field']")
	private WebElement notesField;
	// TODO default handling dataAttribute roomFacilityPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='roomFacilityPicture-field']")
	private WebElement roomFacilityPictureField;
	@FindBy(how = How.XPATH, using = "//*[@id='category-field']")
	private WebElement categoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bedFacilitiesIds-field']")
	private WebElement bedFacilitiesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='operatingRoomIds-field']")
	private WebElement operatingRoomField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='preoperativeRoomsIds-field']")
	private WebElement preoperativeRoomsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='recoveryRoomsIds-field']")
	private WebElement recoveryRoomsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesRoomFacilityCrudEditPage(
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
			"admin/entities/room-facility/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (RoomFacilityEntity) abstractEntity;
		roomNumberField.sendKeys(entity.getRoomNumber());
		roomNameField.sendKeys(entity.getRoomName());
		departmentField.sendKeys(entity.getDepartment());
		genderAllocationField.sendKeys(entity.getGenderAllocation());
		locationField.sendKeys(entity.getLocation());
		notesField.sendKeys(entity.getNotes());
		// TODO default handling for dataAttribute roomFacilityPictureField
		roomFacilityPictureField.sendKeys(entity.getRoomFacilityPicture().toString());

		categoryField.sendKeys(entity.getCategory());
		treatmentClassField.sendKeys(entity.getTreatmentClass());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}