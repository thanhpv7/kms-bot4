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
import kmsweb.entities.BpjsPcareKegiatanKelompokEntity;

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
 * BPJS Pcare Kegiatan KelompokPage is a Page POM that is associated with the admin/entities/bpjs-pcare-kegiatan-kelompok url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcareKegiatanKelompokCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='ketuanama-field']")
	private WebElement ketuanamaField;
	@FindBy(how = How.XPATH, using = "//*[@id='nama-field']")
	private WebElement namaField;
	@FindBy(how = How.XPATH, using = "//*[@id='eduid-field']")
	private WebElement eduidField;
	@FindBy(how = How.XPATH, using = "//*[@id='clubid-field']")
	private WebElement clubidField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdprogram-field']")
	private WebElement kdprogramField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmprogram-field']")
	private WebElement nmprogramField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglmulai-field']")
	private WebElement tglmulaiField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglakhir-field']")
	private WebElement tglakhirField;
	@FindBy(how = How.XPATH, using = "//*[@id='alamat-field']")
	private WebElement alamatField;
	@FindBy(how = How.XPATH, using = "//*[@id='ketuanohp-field']")
	private WebElement ketuanohpField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglpelayanan-field']")
	private WebElement tglpelayananField;
	@FindBy(how = How.XPATH, using = "//*[@id='kegiatannama-field']")
	private WebElement kegiatannamaField;
	@FindBy(how = How.XPATH, using = "//*[@id='kegiatankode-field']")
	private WebElement kegiatankodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='kelompoknama-field']")
	private WebElement kelompoknamaField;
	@FindBy(how = How.XPATH, using = "//*[@id='kelompokkode-field']")
	private WebElement kelompokkodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='materi-field']")
	private WebElement materiField;
	@FindBy(how = How.XPATH, using = "//*[@id='pembicara-field']")
	private WebElement pembicaraField;
	@FindBy(how = How.XPATH, using = "//*[@id='lokasi-field']")
	private WebElement lokasiField;
	@FindBy(how = How.XPATH, using = "//*[@id='keterangan-field']")
	private WebElement keteranganField;
	@FindBy(how = How.XPATH, using = "//*[@id='biaya-field']")
	private WebElement biayaField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcareKegiatanKelompokCrudEditPage(
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
			"admin/entities/bpjs-pcare-kegiatan-kelompok/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsPcareKegiatanKelompokEntity) abstractEntity;
		ketuanamaField.sendKeys(entity.getKetuanama());
		namaField.sendKeys(entity.getNama());
		eduidField.sendKeys(entity.getEduid());
		clubidField.sendKeys(entity.getClubid());
		kdprogramField.sendKeys(entity.getKdprogram());
		nmprogramField.sendKeys(entity.getNmprogram());
		tglmulaiField.sendKeys(entity.getTglmulai());
		tglakhirField.sendKeys(entity.getTglakhir());
		alamatField.sendKeys(entity.getAlamat());
		ketuanohpField.sendKeys(entity.getKetuanohp());
		tglpelayananField.sendKeys(entity.getTglpelayanan());
		kegiatannamaField.sendKeys(entity.getKegiatannama());
		kegiatankodeField.sendKeys(entity.getKegiatankode());
		kelompoknamaField.sendKeys(entity.getKelompoknama());
		kelompokkodeField.sendKeys(entity.getKelompokkode());
		materiField.sendKeys(entity.getMateri());
		pembicaraField.sendKeys(entity.getPembicara());
		lokasiField.sendKeys(entity.getLokasi());
		keteranganField.sendKeys(entity.getKeterangan());
		biayaField.sendKeys(entity.getBiaya());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}