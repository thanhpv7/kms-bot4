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
import kmsweb.entities.TaskDashboardEntity;

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
 * Task DashboardPage is a Page POM that is associated with the admin/entities/task-dashboard url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesTaskDashboardCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='kdppk-field']")
	private WebElement kdppkField;
	// TODO default handling dataAttribute jumlahAntreanField;
	@FindBy(how = How.XPATH, using = "//*[@id='jumlahAntrean-field']")
	private WebElement jumlahAntreanField;
	@FindBy(how = How.XPATH, using = "//*[@id='namapoli-field']")
	private WebElement namapoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmppk-field']")
	private WebElement nmppkField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodepoli-field']")
	private WebElement kodepoliField;
	// TODO default handling dataAttribute insertDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='insertDate-field']")
	private WebElement insertDateField;
	// TODO default handling dataAttribute tanggalField;
	@FindBy(how = How.XPATH, using = "//*[@id='tanggal-field']")
	private WebElement tanggalField;
	// TODO default handling dataAttribute waktuTask1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask1-field']")
	private WebElement waktuTask1Field;
	// TODO default handling dataAttribute waktuTask2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask2-field']")
	private WebElement waktuTask2Field;
	// TODO default handling dataAttribute waktuTask3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask3-field']")
	private WebElement waktuTask3Field;
	// TODO default handling dataAttribute waktuTask4Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask4-field']")
	private WebElement waktuTask4Field;
	// TODO default handling dataAttribute waktuTask5Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask5-field']")
	private WebElement waktuTask5Field;
	// TODO default handling dataAttribute waktuTask6Field;
	@FindBy(how = How.XPATH, using = "//*[@id='waktuTask6-field']")
	private WebElement waktuTask6Field;
	// TODO default handling dataAttribute avgWaktuTask1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask1-field']")
	private WebElement avgWaktuTask1Field;
	// TODO default handling dataAttribute avgWaktuTask2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask2-field']")
	private WebElement avgWaktuTask2Field;
	// TODO default handling dataAttribute avgWaktuTask3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask3-field']")
	private WebElement avgWaktuTask3Field;
	// TODO default handling dataAttribute avgWaktuTask4Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask4-field']")
	private WebElement avgWaktuTask4Field;
	// TODO default handling dataAttribute avgWaktuTask5Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask5-field']")
	private WebElement avgWaktuTask5Field;
	// TODO default handling dataAttribute avgWaktuTask6Field;
	@FindBy(how = How.XPATH, using = "//*[@id='avgWaktuTask6-field']")
	private WebElement avgWaktuTask6Field;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesTaskDashboardCrudEditPage(
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
			"admin/entities/task-dashboard/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (TaskDashboardEntity) abstractEntity;
		kdppkField.sendKeys(entity.getKdppk());
		// TODO default handling for dataAttribute jumlahAntreanField
		jumlahAntreanField.sendKeys(entity.getJumlahAntrean().toString());

		namapoliField.sendKeys(entity.getNamapoli());
		nmppkField.sendKeys(entity.getNmppk());
		kodepoliField.sendKeys(entity.getKodepoli());
		// TODO default handling for dataAttribute insertDateField
		insertDateField.sendKeys(entity.getInsertDate().toString());

		// TODO default handling for dataAttribute tanggalField
		tanggalField.sendKeys(entity.getTanggal().toString());

		// TODO default handling for dataAttribute waktuTask1Field
		waktuTask1Field.sendKeys(entity.getWaktuTask1().toString());

		// TODO default handling for dataAttribute waktuTask2Field
		waktuTask2Field.sendKeys(entity.getWaktuTask2().toString());

		// TODO default handling for dataAttribute waktuTask3Field
		waktuTask3Field.sendKeys(entity.getWaktuTask3().toString());

		// TODO default handling for dataAttribute waktuTask4Field
		waktuTask4Field.sendKeys(entity.getWaktuTask4().toString());

		// TODO default handling for dataAttribute waktuTask5Field
		waktuTask5Field.sendKeys(entity.getWaktuTask5().toString());

		// TODO default handling for dataAttribute waktuTask6Field
		waktuTask6Field.sendKeys(entity.getWaktuTask6().toString());

		// TODO default handling for dataAttribute avgWaktuTask1Field
		avgWaktuTask1Field.sendKeys(entity.getAvgWaktuTask1().toString());

		// TODO default handling for dataAttribute avgWaktuTask2Field
		avgWaktuTask2Field.sendKeys(entity.getAvgWaktuTask2().toString());

		// TODO default handling for dataAttribute avgWaktuTask3Field
		avgWaktuTask3Field.sendKeys(entity.getAvgWaktuTask3().toString());

		// TODO default handling for dataAttribute avgWaktuTask4Field
		avgWaktuTask4Field.sendKeys(entity.getAvgWaktuTask4().toString());

		// TODO default handling for dataAttribute avgWaktuTask5Field
		avgWaktuTask5Field.sendKeys(entity.getAvgWaktuTask5().toString());

		// TODO default handling for dataAttribute avgWaktuTask6Field
		avgWaktuTask6Field.sendKeys(entity.getAvgWaktuTask6().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}