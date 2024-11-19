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
import kmsweb.entities.PcareMCUEntity;

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
 * PCare MCUPage is a Page POM that is associated with the admin/entities/pcare-mcu url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPcareMCUCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='kodeMCU-field']")
	private WebElement kodeMCUField;
	@FindBy(how = How.XPATH, using = "//*[@id='noKunjungan-field']")
	private WebElement noKunjunganField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodeProvider-field']")
	private WebElement kodeProviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='namaProvider-field']")
	private WebElement namaProviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='tanggalPelayanan-field']")
	private WebElement tanggalPelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='sistole-field']")
	private WebElement sistoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='radiologiFoto-field']")
	private WebElement radiologiFotoField;
	@FindBy(how = How.XPATH, using = "//*[@id='hemoglobin-field']")
	private WebElement hemoglobinField;
	@FindBy(how = How.XPATH, using = "//*[@id='leukosit-field']")
	private WebElement leukositField;
	@FindBy(how = How.XPATH, using = "//*[@id='eritrosit-field']")
	private WebElement eritrositField;
	@FindBy(how = How.XPATH, using = "//*[@id='lajuEndapDarah-field']")
	private WebElement lajuEndapDarahField;
	@FindBy(how = How.XPATH, using = "//*[@id='hematokrit-field']")
	private WebElement hematokritField;
	@FindBy(how = How.XPATH, using = "//*[@id='trombosit-field']")
	private WebElement trombositField;
	@FindBy(how = How.XPATH, using = "//*[@id='hdl-field']")
	private WebElement hdlField;
	@FindBy(how = How.XPATH, using = "//*[@id='ldl-field']")
	private WebElement ldlField;
	@FindBy(how = How.XPATH, using = "//*[@id='cholesterol-field']")
	private WebElement cholesterolField;
	@FindBy(how = How.XPATH, using = "//*[@id='trigliserida-field']")
	private WebElement trigliseridaField;
	@FindBy(how = How.XPATH, using = "//*[@id='sewaktu-field']")
	private WebElement sewaktuField;
	@FindBy(how = How.XPATH, using = "//*[@id='puasa-field']")
	private WebElement puasaField;
	@FindBy(how = How.XPATH, using = "//*[@id='postPrandial-field']")
	private WebElement postPrandialField;
	@FindBy(how = How.XPATH, using = "//*[@id='hba1c-field']")
	private WebElement hba1cField;
	@FindBy(how = How.XPATH, using = "//*[@id='sgot-field']")
	private WebElement sgotField;
	@FindBy(how = How.XPATH, using = "//*[@id='sgpt-field']")
	private WebElement sgptField;
	@FindBy(how = How.XPATH, using = "//*[@id='gamma-field']")
	private WebElement gammaField;
	@FindBy(how = How.XPATH, using = "//*[@id='proteinKualitatif-field']")
	private WebElement proteinKualitatifField;
	@FindBy(how = How.XPATH, using = "//*[@id='albumin-field']")
	private WebElement albuminField;
	@FindBy(how = How.XPATH, using = "//*[@id='creatinine-field']")
	private WebElement creatinineField;
	@FindBy(how = How.XPATH, using = "//*[@id='ureum-field']")
	private WebElement ureumField;
	@FindBy(how = How.XPATH, using = "//*[@id='asam-field']")
	private WebElement asamField;
	@FindBy(how = How.XPATH, using = "//*[@id='abi-field']")
	private WebElement abiField;
	@FindBy(how = How.XPATH, using = "//*[@id='ekg-field']")
	private WebElement ekgField;
	@FindBy(how = How.XPATH, using = "//*[@id='echo-field']")
	private WebElement echoField;
	@FindBy(how = How.XPATH, using = "//*[@id='funduskopi-field']")
	private WebElement funduskopiField;
	@FindBy(how = How.XPATH, using = "//*[@id='pemeriksaanLain-field']")
	private WebElement pemeriksaanLainField;
	@FindBy(how = How.XPATH, using = "//*[@id='keterangan-field']")
	private WebElement keteranganField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPcareMCUCrudViewPage(
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
			"admin/entities/pcare-mcu/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}