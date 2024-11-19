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
import kmsweb.entities.BpjsBedAvailabilityEntity;

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
 * BPJS Bed AvailabilityPage is a Page POM that is associated with the admin/entities/bpjs-bed-availability url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsBedAvailabilityCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='koderuang-field']")
	private WebElement koderuangField;
	@FindBy(how = How.XPATH, using = "//*[@id='namaruang-field']")
	private WebElement namaruangField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodekelas-field']")
	private WebElement kodekelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='namakelas-field']")
	private WebElement namakelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastupdate-field']")
	private WebElement lastupdateField;
	// TODO default handling dataAttribute kapasitasField;
	@FindBy(how = How.XPATH, using = "//*[@id='kapasitas-field']")
	private WebElement kapasitasField;
	// TODO default handling dataAttribute tersediaField;
	@FindBy(how = How.XPATH, using = "//*[@id='tersedia-field']")
	private WebElement tersediaField;
	// TODO default handling dataAttribute tersediapriaField;
	@FindBy(how = How.XPATH, using = "//*[@id='tersediapria-field']")
	private WebElement tersediapriaField;
	// TODO default handling dataAttribute tersediawanitaField;
	@FindBy(how = How.XPATH, using = "//*[@id='tersediawanita-field']")
	private WebElement tersediawanitaField;
	// TODO default handling dataAttribute tersediapriawanitaField;
	@FindBy(how = How.XPATH, using = "//*[@id='tersediapriawanita-field']")
	private WebElement tersediapriawanitaField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsBedAvailabilityCrudEditPage(
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
			"admin/entities/bpjs-bed-availability/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsBedAvailabilityEntity) abstractEntity;
		koderuangField.sendKeys(entity.getKoderuang());
		namaruangField.sendKeys(entity.getNamaruang());
		kodekelasField.sendKeys(entity.getKodekelas());
		namakelasField.sendKeys(entity.getNamakelas());
		lastupdateField.sendKeys(entity.getLastupdate());
		// TODO default handling for dataAttribute kapasitasField
		kapasitasField.sendKeys(entity.getKapasitas().toString());

		// TODO default handling for dataAttribute tersediaField
		tersediaField.sendKeys(entity.getTersedia().toString());

		// TODO default handling for dataAttribute tersediapriaField
		tersediapriaField.sendKeys(entity.getTersediapria().toString());

		// TODO default handling for dataAttribute tersediawanitaField
		tersediawanitaField.sendKeys(entity.getTersediawanita().toString());

		// TODO default handling for dataAttribute tersediapriawanitaField
		tersediapriawanitaField.sendKeys(entity.getTersediapriawanita().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}