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
import kmsweb.entities.PriceComponentEntity;

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
 * Price ComponentPage is a Page POM that is associated with the admin/entities/price-component url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPriceComponentCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='componentCode-field']")
	private WebElement componentCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='componentName-field']")
	private WebElement componentNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='coaCOGS-field']")
	private WebElement coaCOGSField;
	@FindBy(how = How.XPATH, using = "//*[@id='coaSell-field']")
	private WebElement coaSellField;
	@FindBy(how = How.XPATH, using = "//*[@id='coaInventory-field']")
	private WebElement coaInventoryField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='invoiceItemComponentsIds-field']")
	private WebElement invoiceItemComponentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalFeeItemComponentsIds-field']")
	private WebElement medicalFeeItemComponentsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='tariffDefinitionOtherComponentsIds-field']")
	private WebElement tariffDefinitionOtherComponentsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPriceComponentCrudEditPage(
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
			"admin/entities/price-component/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (PriceComponentEntity) abstractEntity;
		componentCodeField.sendKeys(entity.getComponentCode());
		componentNameField.sendKeys(entity.getComponentName());
		coaCOGSField.sendKeys(entity.getCoaCOGS());
		coaSellField.sendKeys(entity.getCoaSell());
		coaInventoryField.sendKeys(entity.getCoaInventory());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}