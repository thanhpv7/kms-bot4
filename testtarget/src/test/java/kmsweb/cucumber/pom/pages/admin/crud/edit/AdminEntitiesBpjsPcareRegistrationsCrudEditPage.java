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
import kmsweb.entities.BpjsPcareRegistrationsEntity;

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
 * BPJS Pcare RegistrationsPage is a Page POM that is associated with the admin/entities/bpjs-pcare-registrations url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcareRegistrationsCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='kdproviderpeserta-field']")
	private WebElement kdproviderpesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='tgldaftar-field']")
	private WebElement tgldaftarField;
	@FindBy(how = How.XPATH, using = "//*[@id='nokartu-field']")
	private WebElement nokartuField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdpoli-field']")
	private WebElement kdpoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='keluhan-field']")
	private WebElement keluhanField;
	@FindBy(how = How.XPATH, using = "//*[@id='kunjsakit-field']")
	private WebElement kunjsakitField;
	@FindBy(how = How.XPATH, using = "//*[@id='sistole-field']")
	private WebElement sistoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='beratbadan-field']")
	private WebElement beratbadanField;
	@FindBy(how = How.XPATH, using = "//*[@id='tinggibadan-field']")
	private WebElement tinggibadanField;
	@FindBy(how = How.XPATH, using = "//*[@id='resprate-field']")
	private WebElement resprateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lingkarperut-field']")
	private WebElement lingkarperutField;
	@FindBy(how = How.XPATH, using = "//*[@id='rujukinternal-field']")
	private WebElement rujukinternalField;
	@FindBy(how = How.XPATH, using = "//*[@id='heartrate-field']")
	private WebElement heartrateField;
	@FindBy(how = How.XPATH, using = "//*[@id='rujukbalik-field']")
	private WebElement rujukbalikField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdtkp-field']")
	private WebElement kdtkpField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVisitId-field']")
	private WebElement patientVisitField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcareRegistrationsCrudEditPage(
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
			"admin/entities/bpjs-pcare-registrations/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsPcareRegistrationsEntity) abstractEntity;
		kdproviderpesertaField.sendKeys(entity.getKdproviderpeserta());
		tgldaftarField.sendKeys(entity.getTgldaftar());
		nokartuField.sendKeys(entity.getNokartu());
		kdpoliField.sendKeys(entity.getKdpoli());
		keluhanField.sendKeys(entity.getKeluhan());
		kunjsakitField.sendKeys(entity.getKunjsakit());
		sistoleField.sendKeys(entity.getSistole());
		diastoleField.sendKeys(entity.getDiastole());
		beratbadanField.sendKeys(entity.getBeratbadan());
		tinggibadanField.sendKeys(entity.getTinggibadan());
		resprateField.sendKeys(entity.getResprate());
		lingkarperutField.sendKeys(entity.getLingkarperut());
		rujukinternalField.sendKeys(entity.getRujukinternal());
		heartrateField.sendKeys(entity.getHeartrate());
		rujukbalikField.sendKeys(entity.getRujukbalik());
		kdtkpField.sendKeys(entity.getKdtkp());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}