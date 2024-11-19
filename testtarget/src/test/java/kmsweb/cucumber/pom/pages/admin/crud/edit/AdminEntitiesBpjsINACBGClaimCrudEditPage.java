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
public class AdminEntitiesBpjsINACBGClaimCrudEditPage extends CrudEdit {

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
	// TODO default handling dataAttribute admissionDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='admissionDate-field']")
	private WebElement admissionDateField;
	// TODO default handling dataAttribute dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissalDate-field']")
	private WebElement dismissalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='los-field']")
	private WebElement losField;
	@FindBy(how = How.XPATH, using = "//*[@id='dismissal-field']")
	private WebElement dismissalField;
	@FindBy(how = How.XPATH, using = "//*[@id='responsibleDoctor-field']")
	private WebElement responsibleDoctorField;
	// TODO default handling dataAttribute weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	// TODO default handling dataAttribute adlField;
	@FindBy(how = How.XPATH, using = "//*[@id='adl-field']")
	private WebElement adlField;
	@FindBy(how = How.XPATH, using = "//*[@id='claimStatus-field']")
	private WebElement claimStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='sepStatus-field']")
	private WebElement sepStatusField;
	// TODO default handling dataAttribute hospitalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='hospitalTariff-field']")
	private WebElement hospitalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='referralLetter-field']")
	private WebElement referralLetterField;
	@FindBy(how = How.XPATH, using = "//*[@id='thirdSelLevel-field']")
	private WebElement thirdSelLevelField;
	@FindBy(how = How.XPATH, using = "//*[@id='staffName-field']")
	private WebElement staffNameField;
	// TODO default handling dataAttribute dateGroupingField;
	@FindBy(how = How.XPATH, using = "//*[@id='dateGrouping-field']")
	private WebElement dateGroupingField;
	@FindBy(how = How.XPATH, using = "//*[@id='inacbgTariff-field']")
	private WebElement inacbgTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='cbgType-field']")
	private WebElement cbgTypeField;
	// TODO default handling dataAttribute tariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='tariff-field']")
	private WebElement tariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcute-field']")
	private WebElement subAcuteField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcuteCode-field']")
	private WebElement subAcuteCodeField;
	// TODO default handling dataAttribute subAcuteTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='subAcuteTariff-field']")
	private WebElement subAcuteTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronic-field']")
	private WebElement chronicField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronicCode-field']")
	private WebElement chronicCodeField;
	// TODO default handling dataAttribute chronicTariffField;
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
	// TODO default handling dataAttribute totalTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalTariff-field']")
	private WebElement totalTariffField;
	// TODO default handling dataAttribute visitDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='visitDate-field']")
	private WebElement visitDateField;
	// TODO default handling dataAttribute specProcedureTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specProcedureTariff-field']")
	private WebElement specProcedureTariffField;
	// TODO default handling dataAttribute specDrugTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specDrugTariff-field']")
	private WebElement specDrugTariffField;
	// TODO default handling dataAttribute specInvestigationTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specInvestigationTariff-field']")
	private WebElement specInvestigationTariffField;
	// TODO default handling dataAttribute specProsthesisTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='specProsthesisTariff-field']")
	private WebElement specProsthesisTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='upgradeFlag-field']")
	private WebElement upgradeFlagField;
	@FindBy(how = How.XPATH, using = "//*[@id='hcuFlag-field']")
	private WebElement hcuFlagField;
	@FindBy(how = How.XPATH, using = "//*[@id='grouperFlag-field']")
	private WebElement grouperFlagField;
	// TODO default handling dataAttribute nonSurgeryProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='nonSurgeryProcedure-field']")
	private WebElement nonSurgeryProcedureField;
	// TODO default handling dataAttribute surgeryProcedureField;
	@FindBy(how = How.XPATH, using = "//*[@id='surgeryProcedure-field']")
	private WebElement surgeryProcedureField;
	// TODO default handling dataAttribute consultationField;
	@FindBy(how = How.XPATH, using = "//*[@id='consultation-field']")
	private WebElement consultationField;
	// TODO default handling dataAttribute specialistField;
	@FindBy(how = How.XPATH, using = "//*[@id='specialist-field']")
	private WebElement specialistField;
	// TODO default handling dataAttribute nursingField;
	@FindBy(how = How.XPATH, using = "//*[@id='nursing-field']")
	private WebElement nursingField;
	// TODO default handling dataAttribute diagnosticField;
	@FindBy(how = How.XPATH, using = "//*[@id='diagnostic-field']")
	private WebElement diagnosticField;
	// TODO default handling dataAttribute radiologyField;
	@FindBy(how = How.XPATH, using = "//*[@id='radiology-field']")
	private WebElement radiologyField;
	// TODO default handling dataAttribute laboratoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='laboratory-field']")
	private WebElement laboratoryField;
	// TODO default handling dataAttribute bloodServiceField;
	@FindBy(how = How.XPATH, using = "//*[@id='bloodService-field']")
	private WebElement bloodServiceField;
	// TODO default handling dataAttribute rehabilitationField;
	@FindBy(how = How.XPATH, using = "//*[@id='rehabilitation-field']")
	private WebElement rehabilitationField;
	// TODO default handling dataAttribute bedAccomodationField;
	@FindBy(how = How.XPATH, using = "//*[@id='bedAccomodation-field']")
	private WebElement bedAccomodationField;
	// TODO default handling dataAttribute intensiveCareField;
	@FindBy(how = How.XPATH, using = "//*[@id='intensiveCare-field']")
	private WebElement intensiveCareField;
	// TODO default handling dataAttribute drugsField;
	@FindBy(how = How.XPATH, using = "//*[@id='drugs-field']")
	private WebElement drugsField;
	// TODO default handling dataAttribute medicalEquipmentField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalEquipment-field']")
	private WebElement medicalEquipmentField;
	// TODO default handling dataAttribute dispensedDisposableField;
	@FindBy(how = How.XPATH, using = "//*[@id='dispensedDisposable-field']")
	private WebElement dispensedDisposableField;
	// TODO default handling dataAttribute equipmentRentalField;
	@FindBy(how = How.XPATH, using = "//*[@id='equipmentRental-field']")
	private WebElement equipmentRentalField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Code-field']")
	private WebElement icd10CodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Desc-field']")
	private WebElement icd10DescField;
	// TODO default handling dataAttribute icd10TariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd10Tariff-field']")
	private WebElement icd10TariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmCode-field']")
	private WebElement icd9cmCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmDesc-field']")
	private WebElement icd9cmDescField;
	// TODO default handling dataAttribute icd9cmTariffField;
	@FindBy(how = How.XPATH, using = "//*[@id='icd9cmTariff-field']")
	private WebElement icd9cmTariffField;
	// TODO default handling dataAttribute chronicDrugsField;
	@FindBy(how = How.XPATH, using = "//*[@id='chronicDrugs-field']")
	private WebElement chronicDrugsField;
	// TODO default handling dataAttribute chemotherapyDrugsField;
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
	// TODO default handling dataAttribute totalInvoiceField;
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
	public AdminEntitiesBpjsINACBGClaimCrudEditPage(
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
			"admin/entities/bpjs-inacbg-claim/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BpjsINACBGClaimEntity) abstractEntity;
		claimNoField.sendKeys(entity.getClaimNo());
		patientIDField.sendKeys(entity.getPatientID());
		invoiceNumberField.sendKeys(entity.getInvoiceNumber());
		bpjsCardNoField.sendKeys(entity.getBpjsCardNo());
		sepNoField.sendKeys(entity.getSepNo());
		treatmentTypeField.sendKeys(entity.getTreatmentType());
		treatmentClassField.sendKeys(entity.getTreatmentClass());
		// TODO default handling for dataAttribute admissionDateField
		admissionDateField.sendKeys(entity.getAdmissionDate().toString());

		// TODO default handling for dataAttribute dismissalDateField
		dismissalDateField.sendKeys(entity.getDismissalDate().toString());

		losField.sendKeys(entity.getLos());
		dismissalField.sendKeys(entity.getDismissal());
		responsibleDoctorField.sendKeys(entity.getResponsibleDoctor());
		// TODO default handling for dataAttribute weightField
		weightField.sendKeys(entity.getWeight().toString());

		// TODO default handling for dataAttribute adlField
		adlField.sendKeys(entity.getAdl().toString());

		claimStatusField.sendKeys(entity.getClaimStatus());
		sepStatusField.sendKeys(entity.getSepStatus());
		// TODO default handling for dataAttribute hospitalTariffField
		hospitalTariffField.sendKeys(entity.getHospitalTariff().toString());

		referralLetterField.sendKeys(entity.getReferralLetter());
		thirdSelLevelField.sendKeys(entity.getThirdSelLevel());
		staffNameField.sendKeys(entity.getStaffName());
		// TODO default handling for dataAttribute dateGroupingField
		dateGroupingField.sendKeys(entity.getDateGrouping().toString());

		inacbgTariffField.sendKeys(entity.getInacbgTariff());
		descriptionField.sendKeys(entity.getDescription());
		cbgTypeField.sendKeys(entity.getCbgType());
		// TODO default handling for dataAttribute tariffField
		tariffField.sendKeys(entity.getTariff().toString());

		subAcuteField.sendKeys(entity.getSubAcute());
		subAcuteCodeField.sendKeys(entity.getSubAcuteCode());
		// TODO default handling for dataAttribute subAcuteTariffField
		subAcuteTariffField.sendKeys(entity.getSubAcuteTariff().toString());

		chronicField.sendKeys(entity.getChronic());
		chronicCodeField.sendKeys(entity.getChronicCode());
		// TODO default handling for dataAttribute chronicTariffField
		chronicTariffField.sendKeys(entity.getChronicTariff().toString());

		resultSpecProcedureField.sendKeys(entity.getResultSpecProcedure());
		resultSpecDrugField.sendKeys(entity.getResultSpecDrug());
		resultSpecInvestigationField.sendKeys(entity.getResultSpecInvestigation());
		resultSpecProsthesisField.sendKeys(entity.getResultSpecProsthesis());
		hospitalClassField.sendKeys(entity.getHospitalClass());
		tariffTypeField.sendKeys(entity.getTariffType());
		// TODO default handling for dataAttribute totalTariffField
		totalTariffField.sendKeys(entity.getTotalTariff().toString());

		// TODO default handling for dataAttribute visitDateField
		visitDateField.sendKeys(entity.getVisitDate().toString());

		// TODO default handling for dataAttribute specProcedureTariffField
		specProcedureTariffField.sendKeys(entity.getSpecProcedureTariff().toString());

		// TODO default handling for dataAttribute specDrugTariffField
		specDrugTariffField.sendKeys(entity.getSpecDrugTariff().toString());

		// TODO default handling for dataAttribute specInvestigationTariffField
		specInvestigationTariffField.sendKeys(entity.getSpecInvestigationTariff().toString());

		// TODO default handling for dataAttribute specProsthesisTariffField
		specProsthesisTariffField.sendKeys(entity.getSpecProsthesisTariff().toString());

		if (entity.getUpgradeFlag()) {
			upgradeFlagField.click();
		}
		if (entity.getHcuFlag()) {
			hcuFlagField.click();
		}
		if (entity.getGrouperFlag()) {
			grouperFlagField.click();
		}
		// TODO default handling for dataAttribute nonSurgeryProcedureField
		nonSurgeryProcedureField.sendKeys(entity.getNonSurgeryProcedure().toString());

		// TODO default handling for dataAttribute surgeryProcedureField
		surgeryProcedureField.sendKeys(entity.getSurgeryProcedure().toString());

		// TODO default handling for dataAttribute consultationField
		consultationField.sendKeys(entity.getConsultation().toString());

		// TODO default handling for dataAttribute specialistField
		specialistField.sendKeys(entity.getSpecialist().toString());

		// TODO default handling for dataAttribute nursingField
		nursingField.sendKeys(entity.getNursing().toString());

		// TODO default handling for dataAttribute diagnosticField
		diagnosticField.sendKeys(entity.getDiagnostic().toString());

		// TODO default handling for dataAttribute radiologyField
		radiologyField.sendKeys(entity.getRadiology().toString());

		// TODO default handling for dataAttribute laboratoryField
		laboratoryField.sendKeys(entity.getLaboratory().toString());

		// TODO default handling for dataAttribute bloodServiceField
		bloodServiceField.sendKeys(entity.getBloodService().toString());

		// TODO default handling for dataAttribute rehabilitationField
		rehabilitationField.sendKeys(entity.getRehabilitation().toString());

		// TODO default handling for dataAttribute bedAccomodationField
		bedAccomodationField.sendKeys(entity.getBedAccomodation().toString());

		// TODO default handling for dataAttribute intensiveCareField
		intensiveCareField.sendKeys(entity.getIntensiveCare().toString());

		// TODO default handling for dataAttribute drugsField
		drugsField.sendKeys(entity.getDrugs().toString());

		// TODO default handling for dataAttribute medicalEquipmentField
		medicalEquipmentField.sendKeys(entity.getMedicalEquipment().toString());

		// TODO default handling for dataAttribute dispensedDisposableField
		dispensedDisposableField.sendKeys(entity.getDispensedDisposable().toString());

		// TODO default handling for dataAttribute equipmentRentalField
		equipmentRentalField.sendKeys(entity.getEquipmentRental().toString());

		icd10CodeField.sendKeys(entity.getIcd10Code());
		icd10DescField.sendKeys(entity.getIcd10Desc());
		// TODO default handling for dataAttribute icd10TariffField
		icd10TariffField.sendKeys(entity.getIcd10Tariff().toString());

		icd9cmCodeField.sendKeys(entity.getIcd9cmCode());
		icd9cmDescField.sendKeys(entity.getIcd9cmDesc());
		// TODO default handling for dataAttribute icd9cmTariffField
		icd9cmTariffField.sendKeys(entity.getIcd9cmTariff().toString());

		// TODO default handling for dataAttribute chronicDrugsField
		chronicDrugsField.sendKeys(entity.getChronicDrugs().toString());

		// TODO default handling for dataAttribute chemotherapyDrugsField
		chemotherapyDrugsField.sendKeys(entity.getChemotherapyDrugs().toString());

		classUpgradeField.sendKeys(entity.getClassUpgrade());
		highCareUnitField.sendKeys(entity.getHighCareUnit());
		if (entity.getInacbgClaimCreated()) {
			inacbgClaimCreatedField.click();
		}
		inacbgResponseField.sendKeys(entity.getInacbgResponse());
		// TODO default handling for dataAttribute totalInvoiceField
		totalInvoiceField.sendKeys(entity.getTotalInvoice().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}