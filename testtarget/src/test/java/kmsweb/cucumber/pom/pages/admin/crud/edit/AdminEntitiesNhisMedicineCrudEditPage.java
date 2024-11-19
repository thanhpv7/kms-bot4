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
import kmsweb.entities.NhisMedicineEntity;

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
 * NHIS MedicinePage is a Page POM that is associated with the admin/entities/nhis-medicine url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesNhisMedicineCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='medicineCode-field']")
	private WebElement medicineCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicineName-field']")
	private WebElement medicineNameField;
	// TODO default handling dataAttribute doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='dose-field']")
	private WebElement doseField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='frequency-field']")
	private WebElement frequencyField;
	// TODO default handling dataAttribute durationField;
	@FindBy(how = How.XPATH, using = "//*[@id='duration-field']")
	private WebElement durationField;
	// TODO default handling dataAttribute unitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='unitPrice-field']")
	private WebElement unitPriceField;
	// TODO default handling dataAttribute dispensedQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='dispensedQty-field']")
	private WebElement dispensedQtyField;
	// TODO default handling dataAttribute totalCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalCost-field']")
	private WebElement totalCostField;
	// TODO default handling dataAttribute serviceDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='serviceDate-field']")
	private WebElement serviceDateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesNhisMedicineCrudEditPage(
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
			"admin/entities/nhis-medicine/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (NhisMedicineEntity) abstractEntity;
		medicineCodeField.sendKeys(entity.getMedicineCode());
		medicineNameField.sendKeys(entity.getMedicineName());
		// TODO default handling for dataAttribute doseField
		doseField.sendKeys(entity.getDose().toString());

		uoiField.sendKeys(entity.getUoi());
		frequencyField.sendKeys(entity.getFrequency());
		// TODO default handling for dataAttribute durationField
		durationField.sendKeys(entity.getDuration().toString());

		// TODO default handling for dataAttribute unitPriceField
		unitPriceField.sendKeys(entity.getUnitPrice().toString());

		// TODO default handling for dataAttribute dispensedQtyField
		dispensedQtyField.sendKeys(entity.getDispensedQty().toString());

		// TODO default handling for dataAttribute totalCostField
		totalCostField.sendKeys(entity.getTotalCost().toString());

		// TODO default handling for dataAttribute serviceDateField
		serviceDateField.sendKeys(entity.getServiceDate().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}