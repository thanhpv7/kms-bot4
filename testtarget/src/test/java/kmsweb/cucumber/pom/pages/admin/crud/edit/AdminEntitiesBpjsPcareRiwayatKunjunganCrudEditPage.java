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
import kmsweb.entities.BpjsPcareRiwayatKunjunganEntity;

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
 * Bpjs Pcare Riwayat KunjunganPage is a Page POM that is associated with the admin/entities/bpjs-pcare-riwayat-kunjungan url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcareRiwayatKunjunganCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='nokunjungan-field']")
	private WebElement nokunjunganField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglkunjungan-field']")
	private WebElement tglkunjunganField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='kodeppkpeserta-field']")
	private WebElement kodeppkpesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodeppkgigi-field']")
	private WebElement kodeppkgigiField;
	@FindBy(how = How.XPATH, using = "//*[@id='jeniskelas-field']")
	private WebElement jeniskelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='jenispeserta-field']")
	private WebElement jenispesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='goldarah-field']")
	private WebElement goldarahField;
	@FindBy(how = How.XPATH, using = "//*[@id='nohp-field']")
	private WebElement nohpField;
	@FindBy(how = How.XPATH, using = "//*[@id='noktp-field']")
	private WebElement noktpField;
	@FindBy(how = How.XPATH, using = "//*[@id='asuransi-field']")
	private WebElement asuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='poli-field']")
	private WebElement poliField;
	@FindBy(how = How.XPATH, using = "//*[@id='jeniskunjungan-field']")
	private WebElement jeniskunjunganField;
	@FindBy(how = How.XPATH, using = "//*[@id='progprolanis-field']")
	private WebElement progprolanisField;
	@FindBy(how = How.XPATH, using = "//*[@id='keluhan-field']")
	private WebElement keluhanField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosa-field']")
	private WebElement diagnosaField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosa2-field']")
	private WebElement diagnosa2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosa3-field']")
	private WebElement diagnosa3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='kesadaran-field']")
	private WebElement kesadaranField;
	@FindBy(how = How.XPATH, using = "//*[@id='sistole-field']")
	private WebElement sistoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='beratbadan-field']")
	private WebElement beratbadanField;
	@FindBy(how = How.XPATH, using = "//*[@id='tinggibadan-field']")
	private WebElement tinggibadanField;
	@FindBy(how = How.XPATH, using = "//*[@id='respiratoryrate-field']")
	private WebElement respiratoryrateField;
	@FindBy(how = How.XPATH, using = "//*[@id='heartrate-field']")
	private WebElement heartrateField;
	@FindBy(how = How.XPATH, using = "//*[@id='catatan-field']")
	private WebElement catatanField;
	@FindBy(how = How.XPATH, using = "//*[@id='pemeriksaanfisiklain-field']")
	private WebElement pemeriksaanfisiklainField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglpulang-field']")
	private WebElement tglpulangField;
	@FindBy(how = How.XPATH, using = "//*[@id='dokter-field']")
	private WebElement dokterField;
	@FindBy(how = How.XPATH, using = "//*[@id='statuspulang-field']")
	private WebElement statuspulangField;
	@FindBy(how = How.XPATH, using = "//*[@id='tingkatpelayanan-field']")
	private WebElement tingkatpelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='rujukbalik-field']")
	private WebElement rujukbalikField;
	@FindBy(how = How.XPATH, using = "//*[@id='providerasalrujuk-field']")
	private WebElement providerasalrujukField;
	@FindBy(how = How.XPATH, using = "//*[@id='providerrujuklanjut-field']")
	private WebElement providerrujuklanjutField;
	@FindBy(how = How.XPATH, using = "//*[@id='polirujukinternal-field']")
	private WebElement polirujukinternalField;
	@FindBy(how = How.XPATH, using = "//*[@id='polirujuklanjut-field']")
	private WebElement polirujuklanjutField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcareRiwayatKunjunganCrudEditPage(
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
			"admin/entities/bpjs-pcare-riwayat-kunjungan/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsPcareRiwayatKunjunganEntity) abstractEntity;
		nokunjunganField.sendKeys(entity.getNokunjungan());
		tglkunjunganField.sendKeys(entity.getTglkunjungan());
		providerpelayananField.sendKeys(entity.getProviderpelayanan());
		nokartuField.sendKeys(entity.getNokartu());
		namaField.sendKeys(entity.getNama());
		hubungankeluargaField.sendKeys(entity.getHubungankeluarga());
		sexField.sendKeys(entity.getSex());
		tgllahirField.sendKeys(entity.getTgllahir());
		tglmulaiaktifField.sendKeys(entity.getTglmulaiaktif());
		tglakhirberlakuField.sendKeys(entity.getTglakhirberlaku());
		kodeppkpesertaField.sendKeys(entity.getKodeppkpeserta());
		kodeppkgigiField.sendKeys(entity.getKodeppkgigi());
		jeniskelasField.sendKeys(entity.getJeniskelas());
		jenispesertaField.sendKeys(entity.getJenispeserta());
		goldarahField.sendKeys(entity.getGoldarah());
		nohpField.sendKeys(entity.getNohp());
		noktpField.sendKeys(entity.getNoktp());
		asuransiField.sendKeys(entity.getAsuransi());
		poliField.sendKeys(entity.getPoli());
		jeniskunjunganField.sendKeys(entity.getJeniskunjungan());
		progprolanisField.sendKeys(entity.getProgprolanis());
		keluhanField.sendKeys(entity.getKeluhan());
		diagnosaField.sendKeys(entity.getDiagnosa());
		diagnosa2Field.sendKeys(entity.getDiagnosa2());
		diagnosa3Field.sendKeys(entity.getDiagnosa3());
		kesadaranField.sendKeys(entity.getKesadaran());
		sistoleField.sendKeys(entity.getSistole());
		diastoleField.sendKeys(entity.getDiastole());
		beratbadanField.sendKeys(entity.getBeratbadan());
		tinggibadanField.sendKeys(entity.getTinggibadan());
		respiratoryrateField.sendKeys(entity.getRespiratoryrate());
		heartrateField.sendKeys(entity.getHeartrate());
		catatanField.sendKeys(entity.getCatatan());
		pemeriksaanfisiklainField.sendKeys(entity.getPemeriksaanfisiklain());
		tglpulangField.sendKeys(entity.getTglpulang());
		dokterField.sendKeys(entity.getDokter());
		statuspulangField.sendKeys(entity.getStatuspulang());
		tingkatpelayananField.sendKeys(entity.getTingkatpelayanan());
		rujukbalikField.sendKeys(entity.getRujukbalik());
		providerasalrujukField.sendKeys(entity.getProviderasalrujuk());
		providerrujuklanjutField.sendKeys(entity.getProviderrujuklanjut());
		polirujukinternalField.sendKeys(entity.getPolirujukinternal());
		polirujuklanjutField.sendKeys(entity.getPolirujuklanjut());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}