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
import kmsweb.entities.BpjsPcareKunjunganRujukanEntity;

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
 * Bpjs Pcare Kunjungan RujukanPage is a Page POM that is associated with the admin/entities/bpjs-pcare-kunjungan-rujukan url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsPcareKunjunganRujukanCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='norujukan-field']")
	private WebElement norujukanField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdppk-field']")
	private WebElement kdppkField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmppk-field']")
	private WebElement nmppkField;
	@FindBy(how = How.XPATH, using = "//*[@id='alamat-field']")
	private WebElement alamatField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdkc-field']")
	private WebElement kdkcField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmkc-field']")
	private WebElement nmkcField;
	@FindBy(how = How.XPATH, using = "//*[@id='alamatkc-field']")
	private WebElement alamatkcField;
	@FindBy(how = How.XPATH, using = "//*[@id='telpkc-field']")
	private WebElement telpkcField;
	@FindBy(how = How.XPATH, using = "//*[@id='faxkc-field']")
	private WebElement faxkcField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdprop-field']")
	private WebElement kdpropField;
	@FindBy(how = How.XPATH, using = "//*[@id='kddati-field']")
	private WebElement kddatiField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmdati-field']")
	private WebElement nmdatiField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdkr-field']")
	private WebElement kdkrField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmkr-field']")
	private WebElement nmkrField;
	@FindBy(how = How.XPATH, using = "//*[@id='alamatkr-field']")
	private WebElement alamatkrField;
	@FindBy(how = How.XPATH, using = "//*[@id='telpkr-field']")
	private WebElement telpkrField;
	@FindBy(how = How.XPATH, using = "//*[@id='faxkr-field']")
	private WebElement faxkrField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglkunjungan-field']")
	private WebElement tglkunjunganField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdpoli-field']")
	private WebElement kdpoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmpoli-field']")
	private WebElement nmpoliField;
	@FindBy(how = How.XPATH, using = "//*[@id='nokapst-field']")
	private WebElement nokapstField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmpst-field']")
	private WebElement nmpstField;
	@FindBy(how = How.XPATH, using = "//*[@id='tgllahir-field']")
	private WebElement tgllahirField;
	@FindBy(how = How.XPATH, using = "//*[@id='pisa-field']")
	private WebElement pisaField;
	@FindBy(how = How.XPATH, using = "//*[@id='ketpisa-field']")
	private WebElement ketpisaField;
	@FindBy(how = How.XPATH, using = "//*[@id='sex-field']")
	private WebElement sexField;
	@FindBy(how = How.XPATH, using = "//*[@id='kddiag1-field']")
	private WebElement kddiag1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='nmdiag1-field']")
	private WebElement nmdiag1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='kddiag2-field']")
	private WebElement kddiag2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='nmdiag2-field']")
	private WebElement nmdiag2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='kddiag3-field']")
	private WebElement kddiag3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='nmdiag3-field']")
	private WebElement nmdiag3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='catatan-field']")
	private WebElement catatanField;
	@FindBy(how = How.XPATH, using = "//*[@id='kddokter-field']")
	private WebElement kddokterField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmdokter-field']")
	private WebElement nmdokterField;
	@FindBy(how = How.XPATH, using = "//*[@id='nmtacc-field']")
	private WebElement nmtaccField;
	@FindBy(how = How.XPATH, using = "//*[@id='alasantacc-field']")
	private WebElement alasantaccField;
	@FindBy(how = How.XPATH, using = "//*[@id='infodenda-field']")
	private WebElement infodendaField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsPcareKunjunganRujukanCrudViewPage(
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
			"admin/entities/bpjs-pcare-kunjungan-rujukan/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}