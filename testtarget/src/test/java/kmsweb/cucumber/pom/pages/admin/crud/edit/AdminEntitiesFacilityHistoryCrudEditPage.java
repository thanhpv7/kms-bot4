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
import kmsweb.entities.FacilityHistoryEntity;

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
 * Facility HistoryPage is a Page POM that is associated with the admin/entities/facility-history url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesFacilityHistoryCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute changeDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='changeDate-field']")
	private WebElement changeDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityNo-field']")
	private WebElement facilityNoField;
	// TODO default handling dataAttribute currentQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='currentQty-field']")
	private WebElement currentQtyField;
	// TODO default handling dataAttribute changedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='changedQty-field']")
	private WebElement changedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityStatus-field']")
	private WebElement facilityStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityClass-field']")
	private WebElement facilityClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityType-field']")
	private WebElement facilityTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='facilityService-field']")
	private WebElement facilityServiceField;
	@FindBy(how = How.XPATH, using = "//*[@id='bedFacilityId-field']")
	private WebElement bedFacilityIdField;
	@FindBy(how = How.XPATH, using = "//*[@id='registrationId-field']")
	private WebElement registrationIdField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesFacilityHistoryCrudEditPage(
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
			"admin/entities/facility-history/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (FacilityHistoryEntity) abstractEntity;
		// TODO default handling for dataAttribute changeDateField
		changeDateField.sendKeys(entity.getChangeDate().toString());

		facilityNoField.sendKeys(entity.getFacilityNo());
		// TODO default handling for dataAttribute currentQtyField
		currentQtyField.sendKeys(entity.getCurrentQty().toString());

		// TODO default handling for dataAttribute changedQtyField
		changedQtyField.sendKeys(entity.getChangedQty().toString());

		facilityStatusField.sendKeys(entity.getFacilityStatus());
		facilityClassField.sendKeys(entity.getFacilityClass());
		facilityTypeField.sendKeys(entity.getFacilityType());
		facilityServiceField.sendKeys(entity.getFacilityService());
		bedFacilityIdField.sendKeys(entity.getBedFacilityId());
		registrationIdField.sendKeys(entity.getRegistrationId());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}