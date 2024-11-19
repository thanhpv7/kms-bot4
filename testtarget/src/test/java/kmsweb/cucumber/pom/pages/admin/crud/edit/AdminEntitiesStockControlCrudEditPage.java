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
import kmsweb.entities.StockControlEntity;

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
 * Stock ControlPage is a Page POM that is associated with the admin/entities/stock-control url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesStockControlCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute onHandQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='onHandQty-field']")
	private WebElement onHandQtyField;
	// TODO default handling dataAttribute availableQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='availableQty-field']")
	private WebElement availableQtyField;
	// TODO default handling dataAttribute onReservedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='onReservedQty-field']")
	private WebElement onReservedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	// TODO default handling dataAttribute minLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='minLevel-field']")
	private WebElement minLevelField;
	// TODO default handling dataAttribute maxLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='maxLevel-field']")
	private WebElement maxLevelField;
	// TODO default handling dataAttribute inTransitQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='inTransitQty-field']")
	private WebElement inTransitQtyField;
	// TODO default handling dataAttribute averageCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='averageCost-field']")
	private WebElement averageCostField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='locationId-field']")
	private WebElement locationField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueId-field']")
	private WebElement stockCatalogueField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesStockControlCrudEditPage(
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
			"admin/entities/stock-control/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (StockControlEntity) abstractEntity;
		// TODO default handling for dataAttribute onHandQtyField
		onHandQtyField.sendKeys(entity.getOnHandQty().toString());

		// TODO default handling for dataAttribute availableQtyField
		availableQtyField.sendKeys(entity.getAvailableQty().toString());

		// TODO default handling for dataAttribute onReservedQtyField
		onReservedQtyField.sendKeys(entity.getOnReservedQty().toString());

		uoiField.sendKeys(entity.getUoi());
		// TODO default handling for dataAttribute minLevelField
		minLevelField.sendKeys(entity.getMinLevel().toString());

		// TODO default handling for dataAttribute maxLevelField
		maxLevelField.sendKeys(entity.getMaxLevel().toString());

		// TODO default handling for dataAttribute inTransitQtyField
		inTransitQtyField.sendKeys(entity.getInTransitQty().toString());

		// TODO default handling for dataAttribute averageCostField
		averageCostField.sendKeys(entity.getAverageCost().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}