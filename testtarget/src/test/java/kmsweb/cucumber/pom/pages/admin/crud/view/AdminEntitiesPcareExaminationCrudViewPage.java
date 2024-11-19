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
import kmsweb.entities.PcareExaminationEntity;

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
 * PCare ExaminationPage is a Page POM that is associated with the admin/entities/pcare-examination url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesPcareExaminationCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='visitType-field']")
	private WebElement visitTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatment-field']")
	private WebElement treatmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='destinationPolyclinic-field']")
	private WebElement destinationPolyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='disease-field']")
	private WebElement diseaseField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosis-field']")
	private WebElement diagnosisField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosis2-field']")
	private WebElement diagnosis2Field;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnosis3-field']")
	private WebElement diagnosis3Field;
	@FindBy(how = How.XPATH, using = "//*[@id='therapy-field']")
	private WebElement therapyField;
	@FindBy(how = How.XPATH, using = "//*[@id='consciousness-field']")
	private WebElement consciousnessField;
	@FindBy(how = How.XPATH, using = "//*[@id='dischargeStatus-field']")
	private WebElement dischargeStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='internalReferralPolyclinic-field']")
	private WebElement internalReferralPolyclinicField;
	@FindBy(how = How.XPATH, using = "//*[@id='referringDate-field']")
	private WebElement referringDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='pkk-field']")
	private WebElement pkkField;
	@FindBy(how = How.XPATH, using = "//*[@id='subSpecialist-field']")
	private WebElement subSpecialistField;
	@FindBy(how = How.XPATH, using = "//*[@id='facility-field']")
	private WebElement facilityField;
	@FindBy(how = How.XPATH, using = "//*[@id='tacc-field']")
	private WebElement taccField;
	@FindBy(how = How.XPATH, using = "//*[@id='taccReason-field']")
	private WebElement taccReasonField;
	@FindBy(how = How.XPATH, using = "//*[@id='special-field']")
	private WebElement specialField;
	@FindBy(how = How.XPATH, using = "//*[@id='height-field']")
	private WebElement heightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='waistCircumference-field']")
	private WebElement waistCircumferenceField;
	@FindBy(how = How.XPATH, using = "//*[@id='bmi-field']")
	private WebElement bmiField;
	@FindBy(how = How.XPATH, using = "//*[@id='systole-field']")
	private WebElement systoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='diastole-field']")
	private WebElement diastoleField;
	@FindBy(how = How.XPATH, using = "//*[@id='respiratoryRate-field']")
	private WebElement respiratoryRateField;
	@FindBy(how = How.XPATH, using = "//*[@id='heartRate-field']")
	private WebElement heartRateField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalStaff-field']")
	private WebElement medicalStaffField;
	@FindBy(how = How.XPATH, using = "//*[@id='tglpulang-field']")
	private WebElement tglpulangField;
	@FindBy(how = How.XPATH, using = "//*[@id='kdsubspesialis1-field']")
	private WebElement kdsubspesialis1Field;
	@FindBy(how = How.XPATH, using = "//*[@id='rujuklanjut-field']")
	private WebElement rujuklanjutField;
	@FindBy(how = How.XPATH, using = "//*[@id='catatan-field']")
	private WebElement catatanField;
	@FindBy(how = How.XPATH, using = "//*[@id='nokunjungan-field']")
	private WebElement nokunjunganField;
	@FindBy(how = How.XPATH, using = "//*[@id='jsoninsert-field']")
	private WebElement jsoninsertField;
	@FindBy(how = How.XPATH, using = "//*[@id='jsonupdate-field']")
	private WebElement jsonupdateField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='registrationId-field']")
	private WebElement registrationField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareActionExaminationsIds-field']")
	private WebElement pcareActionExaminationsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareCompoundDrugsIds-field']")
	private WebElement pcareCompoundDrugsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='pcareNonCompoundDrugsIds-field']")
	private WebElement pcareNonCompoundDrugsField;

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesPcareExaminationCrudViewPage(
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
			"admin/entities/pcare-examination/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}