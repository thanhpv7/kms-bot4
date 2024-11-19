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
import kmsweb.entities.BpjsPcarePesertaKegiatanKelompokEntity;

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
 * BPJS Pcare Peserta Kegiatan KelompokPage is a Page POM that is associated with the admin/entities/bpjs-pcare-peserta-kegiatan-kelompok url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcarePesertaKegiatanKelompokCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='eduid-field']")
	private WebElement eduidField;
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
	@FindBy(how = How.XPATH, using = "//*[@id='kdprovider-field']")
	private WebElement kdproviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmprovider-field']")
	private WebElement nmproviderField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdprovidergigi-field']")
	private WebElement kdprovidergigiField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmprovidergigi-field']")
	private WebElement nmprovidergigiField;
	@FindBy(how = How.XPATH, using = "//*[@id='namakelas-field']")
	private WebElement namakelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodekelas-field']")
	private WebElement kodekelasField;
	@FindBy(how = How.XPATH, using = "//*[@id='namapeserta-field']")
	private WebElement namapesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='kodepeserta-field']")
	private WebElement kodepesertaField;
	@FindBy(how = How.XPATH, using = "//*[@id='goldarah-field']")
	private WebElement goldarahField;
	@FindBy(how = How.XPATH, using = "//*[@id='nohp-field']")
	private WebElement nohpField;
	@FindBy(how = How.XPATH, using = "//*[@id='noktp-field']")
	private WebElement noktpField;
	@FindBy(how = How.XPATH, using = "//*[@id='pstprol-field']")
	private WebElement pstprolField;
	@FindBy(how = How.XPATH, using = "//*[@id='pstprb-field']")
	private WebElement pstprbField;
	@FindBy(how = How.XPATH, using = "//*[@id='ketaktif-field']")
	private WebElement ketaktifField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdasuransi-field']")
	private WebElement kdasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmasuransi-field']")
	private WebElement nmasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='noasuransi-field']")
	private WebElement noasuransiField;
	@FindBy(how = How.XPATH, using = "//*[@id='cob-field']")
	private WebElement cobField;
	@FindBy(how = How.XPATH, using = "//*[@id='tunggakan-field']")
	private WebElement tunggakanField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcarePesertaKegiatanKelompokCrudViewPage(
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
			"admin/entities/bpjs-pcare-peserta-kegiatan-kelompok/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}