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
import kmsweb.entities.TariffPackageEntity;

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
 * Tariff PackagePage is a Page POM that is associated with the admin/entities/tariff-package url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTariffPackageCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='tariffPackageCode-field']")
	private WebElement tariffPackageCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffPackageName-field']")
	private WebElement tariffPackageNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffPackageClassification-field']")
	private WebElement tariffPackageClassificationField;
	@FindBy(how = How.XPATH, using = "//*[@id='coaSell-field']")
	private WebElement coaSellField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffPackageDescription-field']")
	private WebElement tariffPackageDescriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='applyTo-field']")
	private WebElement applyToField;
	@FindBy(how = How.XPATH, using = "//*[@id='applyToAllServices-field']")
	private WebElement applyToAllServicesField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='serviceItemAssignmentsIds-field']")
	private WebElement serviceItemAssignmentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffPackageItemsIds-field']")
	private WebElement tariffPackageItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffPackageServiceAssignmentsIds-field']")
	private WebElement tariffPackageServiceAssignmentsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTariffPackageCrudViewPage(
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
			"admin/entities/tariff-package/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}