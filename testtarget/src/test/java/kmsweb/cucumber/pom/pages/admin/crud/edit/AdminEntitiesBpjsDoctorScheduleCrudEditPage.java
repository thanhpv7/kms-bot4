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
import kmsweb.entities.BpjsDoctorScheduleEntity;

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
 * BPJS Doctor SchedulePage is a Page POM that is associated with the admin/entities/bpjs-doctor-schedule url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsDoctorScheduleCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute hariField;
	@FindBy(how = How.XPATH, using = "//*[@id='hari-field']")
	private WebElement hariField;
	@FindBy(how = How.XPATH, using = "//*[@id='namaHari-field']")
	private WebElement namaHariField;
	// TODO default handling dataAttribute kapasitasField;
	@FindBy(how = How.XPATH, using = "//*[@id='kapasitas-field']")
	private WebElement kapasitasField;
	// TODO default handling dataAttribute jknQuotaField;
	@FindBy(how = How.XPATH, using = "//*[@id='jknQuota-field']")
	private WebElement jknQuotaField;
	// TODO default handling dataAttribute jknNonQuotaField;
	@FindBy(how = How.XPATH, using = "//*[@id='jknNonQuota-field']")
	private WebElement jknNonQuotaField;
	// TODO default handling dataAttribute intervalField;
	@FindBy(how = How.XPATH, using = "//*[@id='interval-field']")
	private WebElement intervalField;
	@FindBy(how = How.XPATH, using = "//*[@id='libur-field']")
	private WebElement liburField;
	@FindBy(how = How.XPATH, using = "//*[@id='jamBuka-field']")
	private WebElement jamBukaField;
	@FindBy(how = How.XPATH, using = "//*[@id='jamTutup-field']")
	private WebElement jamTutupField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodepoli-field']")
	private WebElement kodepoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='namapoli-field']")
	private WebElement namapoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodesubspesialis-field']")
	private WebElement kodesubspesialisField;
	@FindBy(how = How.XPATH, using = "//*[@id='namasubspesialis-field']")
	private WebElement namasubspesialisField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodedokter-field']")
	private WebElement kodedokterField;
	@FindBy(how = How.XPATH, using = "//*[@id='namadokter-field']")
	private WebElement namadokterField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsDoctorScheduleCrudEditPage(
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
			"admin/entities/bpjs-doctor-schedule/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsDoctorScheduleEntity) abstractEntity;
		// TODO default handling for dataAttribute hariField
		hariField.sendKeys(entity.getHari().toString());

		namaHariField.sendKeys(entity.getNamaHari());
		// TODO default handling for dataAttribute kapasitasField
		kapasitasField.sendKeys(entity.getKapasitas().toString());

		// TODO default handling for dataAttribute jknQuotaField
		jknQuotaField.sendKeys(entity.getJknQuota().toString());

		// TODO default handling for dataAttribute jknNonQuotaField
		jknNonQuotaField.sendKeys(entity.getJknNonQuota().toString());

		// TODO default handling for dataAttribute intervalField
		intervalField.sendKeys(entity.getInterval().toString());

		if (entity.getLibur()) {
			liburField.click();
		}
		jamBukaField.sendKeys(entity.getJamBuka());
		jamTutupField.sendKeys(entity.getJamTutup());
		kodepoliField.sendKeys(entity.getKodepoli());
		namapoliField.sendKeys(entity.getNamapoli());
		kodesubspesialisField.sendKeys(entity.getKodesubspesialis());
		namasubspesialisField.sendKeys(entity.getNamasubspesialis());
		kodedokterField.sendKeys(entity.getKodedokter());
		namadokterField.sendKeys(entity.getNamadokter());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}