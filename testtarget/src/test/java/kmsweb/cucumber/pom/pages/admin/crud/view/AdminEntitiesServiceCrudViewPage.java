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
import kmsweb.entities.ServiceEntity;

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
 * ServicePage is a Page POM that is associated with the admin/entities/service url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesServiceCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='serviceNumber-field']")
	private WebElement serviceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='serviceName-field']")
	private WebElement serviceNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='sectionCode-field']")
	private WebElement sectionCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='byPassDoctorAssignment-field']")
	private WebElement byPassDoctorAssignmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='hasExaminationItem-field']")
	private WebElement hasExaminationItemField;
	@FindBy(how = How.XPATH, using = "//*[@id='revenueCenter-field']")
	private WebElement revenueCenterField;
	@FindBy(how = How.XPATH, using = "//*[@id='serviceCode-field']")
	private WebElement serviceCodeField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsPcarePoli-field']")
	private WebElement bpjsPcarePoliField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsServiceMapping-field']")
	private WebElement bpjsServiceMappingField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='defaultMedicalStaffId-field']")
	private WebElement defaultMedicalStaffField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='doctorSchedulesIds-field']")
	private WebElement doctorSchedulesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='examinationGroupsIds-field']")
	private WebElement examinationGroupsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='mcuPackageItemsIds-field']")
	private WebElement mcuPackageItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='referringUnitIds-field']")
	private WebElement referringUnitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationsIds-field']")
	private WebElement registrationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceFacilityCategoriesIds-field']")
	private WebElement serviceFacilityCategoriesField;

	// Incoming one-to-many

	// Outgoing many-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceItemsIds-field']")
	private WebElement serviceItemsField;

	// Incoming many-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='assignedMedicalStaffIds-field']")
	private WebElement assignedMedicalStaffField;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesServiceCrudViewPage(
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
			"admin/entities/service/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}