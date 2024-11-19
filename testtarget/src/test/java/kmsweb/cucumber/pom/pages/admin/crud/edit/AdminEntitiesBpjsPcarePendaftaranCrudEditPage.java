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
import kmsweb.entities.BpjsPcarePendaftaranEntity;

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
 * Bpjs Pcare PendaftaranPage is a Page POM that is associated with the admin/entities/bpjs-pcare-pendaftaran url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcarePendaftaranCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='nourut-field']")
	private WebElement nourutField;
	@FindBy(how = How.XPATH, using = "//*[@id='tgldaftar-field']")
	private WebElement tgldaftarField;
	@FindBy(how = How.XPATH, using = "//*[@id='providerpelayanan-field']")
	private WebElement providerpelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='nokartu-field']")
	private WebElement nokartuField;
	@FindBy(how = How.XPATH, using = "//*[@id='nama-field']")
	private WebElement namaField;
	@FindBy(how = How.XPATH, using = "//*[@id='hubungankeluarga-field']")
	private WebElement hubungankeluargaField;
	@FindBy(how = How.XPATH, using = "//*[@id='sex-field']")
	private WebElement sexField;
	@FindBy(how = How.XPATH, using = "//*[@id='tgllahir-field']")
	private WebElement tgllahirField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglmulaiaktif-field']")
	private WebElement tglmulaiaktifField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglakhirberlaku-field']")
	private WebElement tglakhirberlakuField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdproviderpst-field']")
	private WebElement kdproviderpstField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdprovidergigi-field']")
	private WebElement kdprovidergigiField;
	@FindBy(how = How.XPATH, using = "//*[@id='jnskelas-field']")
	private WebElement jnskelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='jnspeserta-field']")
	private WebElement jnspesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='goldarah-field']")
	private WebElement goldarahField;
	@FindBy(how = How.XPATH, using = "//*[@id='nohp-field']")
	private WebElement nohpField;
	@FindBy(how = How.XPATH, using = "//*[@id='noktp-field']")
	private WebElement noktpField;
	@FindBy(how = How.XPATH, using = "//*[@id='aktif-field']")
	private WebElement aktifField;
	@FindBy(how = How.XPATH, using = "//*[@id='ketaktif-field']")
	private WebElement ketaktifField;
	@FindBy(how = How.XPATH, using = "//*[@id='asuransi-field']")
	private WebElement asuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdpoli-field']")
	private WebElement kdpoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmpoli-field']")
	private WebElement nmpoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='polisakit-field']")
	private WebElement polisakitField;
	@FindBy(how = How.XPATH, using = "//*[@id='keluhan-field']")
	private WebElement keluhanField;
	@FindBy(how = How.XPATH, using = "//*[@id='kunjsakit-field']")
	private WebElement kunjsakitField;
	@FindBy(how = How.XPATH, using = "//*[@id='status-field']")
	private WebElement statusField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='heartrate-field']")
	private WebElement heartrateField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdtkp-field']")
	private WebElement kdtkpField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmtkp-field']")
	private WebElement nmtkpField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdproviderpelayanan-field']")
	private WebElement kdproviderpelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmproviderpelayanan-field']")
	private WebElement nmproviderpelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmproviderpst-field']")
	private WebElement nmproviderpstField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmprovidergigi-field']")
	private WebElement nmprovidergigiField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodekls-field']")
	private WebElement kodeklsField;
	@FindBy(how = How.XPATH, using = "//*[@id='namakls-field']")
	private WebElement namaklsField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodepeserta-field']")
	private WebElement kodepesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='namapeserta-field']")
	private WebElement namapesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdasuransi-field']")
	private WebElement kdasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmasuransi-field']")
	private WebElement nmasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='noasuransi-field']")
	private WebElement noasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='lingkarperut-field']")
	private WebElement lingkarperutField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='patientVisitId-field']")
	private WebElement patientVisitField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcarePendaftaranCrudEditPage(
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
			"admin/entities/bpjs-pcare-pendaftaran/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsPcarePendaftaranEntity) abstractEntity;
		nourutField.sendKeys(entity.getNourut());
		tgldaftarField.sendKeys(entity.getTgldaftar());
		providerpelayananField.sendKeys(entity.getProviderpelayanan());
		nokartuField.sendKeys(entity.getNokartu());
		namaField.sendKeys(entity.getNama());
		hubungankeluargaField.sendKeys(entity.getHubungankeluarga());
		sexField.sendKeys(entity.getSex());
		tgllahirField.sendKeys(entity.getTgllahir());
		tglmulaiaktifField.sendKeys(entity.getTglmulaiaktif());
		tglakhirberlakuField.sendKeys(entity.getTglakhirberlaku());
		kdproviderpstField.sendKeys(entity.getKdproviderpst());
		kdprovidergigiField.sendKeys(entity.getKdprovidergigi());
		jnskelasField.sendKeys(entity.getJnskelas());
		jnspesertaField.sendKeys(entity.getJnspeserta());
		goldarahField.sendKeys(entity.getGoldarah());
		nohpField.sendKeys(entity.getNohp());
		noktpField.sendKeys(entity.getNoktp());
		aktifField.sendKeys(entity.getAktif());
		ketaktifField.sendKeys(entity.getKetaktif());
		asuransiField.sendKeys(entity.getAsuransi());
		kdpoliField.sendKeys(entity.getKdpoli());
		nmpoliField.sendKeys(entity.getNmpoli());
		polisakitField.sendKeys(entity.getPolisakit());
		keluhanField.sendKeys(entity.getKeluhan());
		kunjsakitField.sendKeys(entity.getKunjsakit());
		statusField.sendKeys(entity.getStatus());
		sistoleField.sendKeys(entity.getSistole());
		diastoleField.sendKeys(entity.getDiastole());
		beratbadanField.sendKeys(entity.getBeratbadan());
		tinggibadanField.sendKeys(entity.getTinggibadan());
		resprateField.sendKeys(entity.getResprate());
		heartrateField.sendKeys(entity.getHeartrate());
		kdtkpField.sendKeys(entity.getKdtkp());
		nmtkpField.sendKeys(entity.getNmtkp());
		kdproviderpelayananField.sendKeys(entity.getKdproviderpelayanan());
		nmproviderpelayananField.sendKeys(entity.getNmproviderpelayanan());
		nmproviderpstField.sendKeys(entity.getNmproviderpst());
		nmprovidergigiField.sendKeys(entity.getNmprovidergigi());
		kodeklsField.sendKeys(entity.getKodekls());
		namaklsField.sendKeys(entity.getNamakls());
		kodepesertaField.sendKeys(entity.getKodepeserta());
		namapesertaField.sendKeys(entity.getNamapeserta());
		kdasuransiField.sendKeys(entity.getKdasuransi());
		nmasuransiField.sendKeys(entity.getNmasuransi());
		noasuransiField.sendKeys(entity.getNoasuransi());
		lingkarperutField.sendKeys(entity.getLingkarperut());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}