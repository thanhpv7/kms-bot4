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
import kmsweb.entities.BpjsINACBGClaimEntity;

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
 * BPJS INACBG ClaimPage is a Page POM that is associated with the admin/entities/bpjs-inacbg-claim url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBpjsINACBGClaimCrudViewPage extends CrudView {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end



	@FindBy(how = How.XPATH, using = "//*[@id='claimNo-field']")
	private WebElement claimNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='patientID-field']")
	private WebElement patientIDField;
	@FindBy(how = How.XPATH, using = "//*[@id='invoiceNumber-field']")
	private WebElement invoiceNumberField;
	@FindBy(how = How.XPATH, using = "//*[@id='bpjsCardNo-field']")
	private WebElement bpjsCardNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepNo-field']")
	private WebElement sepNoField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentType-field']")
	private WebElement treatmentTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='treatmentClass-field']")
	private WebElement treatmentClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDate-field']")
	private WebElement admissionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='los-field']")
	private WebElement losField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissal-field']")
	private WebElement dismissalField;
	@FindBy(how = How.XPATH, using = "//*[@id='responsibleDoctor-field']")
	private WebElement responsibleDoctorField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='adl-field']")
	private WebElement adlField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimStatus-field']")
	private WebElement claimStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepStatus-field']")
	private WebElement sepStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalTariff-field']")
	private WebElement hospitalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralLetter-field']")
	private WebElement referralLetterField;
	@FindBy(how = How.XPATH, using = "//*[@id='thirdSelLevel-field']")
	private WebElement thirdSelLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='staffName-field']")
	private WebElement staffNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateGrouping-field']")
	private WebElement dateGroupingField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgTariff-field']")
	private WebElement inacbgTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='cbgType-field']")
	private WebElement cbgTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariff-field']")
	private WebElement tariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcute-field']")
	private WebElement subAcuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcuteCode-field']")
	private WebElement subAcuteCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcuteTariff-field']")
	private WebElement subAcuteTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronic-field']")
	private WebElement chronicField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronicCode-field']")
	private WebElement chronicCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronicTariff-field']")
	private WebElement chronicTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='resultSpecProcedure-field']")
	private WebElement resultSpecProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='resultSpecDrug-field']")
	private WebElement resultSpecDrugField;
	@FindBy(how = How.XPATH, using = "//*[@id='resultSpecInvestigation-field']")
	private WebElement resultSpecInvestigationField;
	@FindBy(how = How.XPATH, using = "//*[@id='resultSpecProsthesis-field']")
	private WebElement resultSpecProsthesisField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalClass-field']")
	private WebElement hospitalClassField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariffType-field']")
	private WebElement tariffTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalTariff-field']")
	private WebElement totalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='visitDate-field']")
	private WebElement visitDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='specProcedureTariff-field']")
	private WebElement specProcedureTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specDrugTariff-field']")
	private WebElement specDrugTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specInvestigationTariff-field']")
	private WebElement specInvestigationTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specProsthesisTariff-field']")
	private WebElement specProsthesisTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='upgradeFlag-field']")
	private WebElement upgradeFlagField;
	@FindBy(how = How.XPATH, using = "//*[@id='hcuFlag-field']")
	private WebElement hcuFlagField;
	@FindBy(how = How.XPATH, using = "//*[@id='grouperFlag-field']")
	private WebElement grouperFlagField;
	@FindBy(how = How.XPATH, using = "//*[@id='nonSurgeryProcedure-field']")
	private WebElement nonSurgeryProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryProcedure-field']")
	private WebElement surgeryProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='consultation-field']")
	private WebElement consultationField;
	@FindBy(how = How.XPATH, using = "//*[@id='specialist-field']")
	private WebElement specialistField;
	@FindBy(how = How.XPATH, using = "//*[@id='nursing-field']")
	private WebElement nursingField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnostic-field']")
	private WebElement diagnosticField;
	@FindBy(how = How.XPATH, using = "//*[@id='radiology-field']")
	private WebElement radiologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='laboratory-field']")
	private WebElement laboratoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='bloodService-field']")
	private WebElement bloodServiceField;
	@FindBy(how = How.XPATH, using = "//*[@id='rehabilitation-field']")
	private WebElement rehabilitationField;
	@FindBy(how = How.XPATH, using = "//*[@id='bedAccomodation-field']")
	private WebElement bedAccomodationField;
	@FindBy(how = How.XPATH, using = "//*[@id='intensiveCare-field']")
	private WebElement intensiveCareField;
	@FindBy(how = How.XPATH, using = "//*[@id='drugs-field']")
	private WebElement drugsField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalEquipment-field']")
	private WebElement medicalEquipmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='dispensedDisposable-field']")
	private WebElement dispensedDisposableField;
	@FindBy(how = How.XPATH, using = "//*[@id='equipmentRental-field']")
	private WebElement equipmentRentalField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Code-field']")
	private WebElement icd10CodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Desc-field']")
	private WebElement icd10DescField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Tariff-field']")
	private WebElement icd10TariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmCode-field']")
	private WebElement icd9cmCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmDesc-field']")
	private WebElement icd9cmDescField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmTariff-field']")
	private WebElement icd9cmTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronicDrugs-field']")
	private WebElement chronicDrugsField;
	@FindBy(how = How.XPATH, using = "//*[@id='chemotherapyDrugs-field']")
	private WebElement chemotherapyDrugsField;
	@FindBy(how = How.XPATH, using = "//*[@id='classUpgrade-field']")
	private WebElement classUpgradeField;
	@FindBy(how = How.XPATH, using = "//*[@id='highCareUnit-field']")
	private WebElement highCareUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgClaimCreated-field']")
	private WebElement inacbgClaimCreatedField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgResponse-field']")
	private WebElement inacbgResponseField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalInvoice-field']")
	private WebElement totalInvoiceField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBpjsINACBGClaimCrudViewPage(
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
			"admin/entities/bpjs-inacbg-claim/view"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}