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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.BpjsINACBGClaimEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class BpjsINACBGClaimFactory implements FactoryBean<BpjsINACBGClaimEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public BpjsINACBGClaimEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public BpjsINACBGClaimEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public BpjsINACBGClaimEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef before the main body here] end

		BpjsINACBGClaimEntity newEntity = new BpjsINACBGClaimEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringForClaimNo = mockNeat
				.strings()
				.get();
		newEntity.setClaimNo(randomStringForClaimNo);
		// % protected region % [Add customisation for Claim No here] end
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringForPatientID = mockNeat
				.strings()
				.get();
		newEntity.setPatientID(randomStringForPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringForInvoiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringForInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringForBpjsCardNo = mockNeat
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringForBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringForSepNo = mockNeat
				.strings()
				.get();
		newEntity.setSepNo(randomStringForSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringForTreatmentType = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringForTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for LOS here] off begin
		String randomStringForLos = mockNeat
				.strings()
				.get();
		newEntity.setLos(randomStringForLos);
		// % protected region % [Add customisation for LOS here] end
		// % protected region % [Add customisation for Dismissal here] off begin
		String randomStringForDismissal = mockNeat
				.strings()
				.get();
		newEntity.setDismissal(randomStringForDismissal);
		// % protected region % [Add customisation for Dismissal here] end
		// % protected region % [Add customisation for Responsible Doctor here] off begin
		String randomStringForResponsibleDoctor = mockNeat
				.strings()
				.get();
		newEntity.setResponsibleDoctor(randomStringForResponsibleDoctor);
		// % protected region % [Add customisation for Responsible Doctor here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for ADL here] off begin
		newEntity.setAdl(mockNeat.ints().get());
		// % protected region % [Add customisation for ADL here] end
		// % protected region % [Add customisation for Claim Status here] off begin
		String randomStringForClaimStatus = mockNeat
				.strings()
				.get();
		newEntity.setClaimStatus(randomStringForClaimStatus);
		// % protected region % [Add customisation for Claim Status here] end
		// % protected region % [Add customisation for SEP Status here] off begin
		String randomStringForSepStatus = mockNeat
				.strings()
				.get();
		newEntity.setSepStatus(randomStringForSepStatus);
		// % protected region % [Add customisation for SEP Status here] end
		// % protected region % [Add customisation for Hospital Tariff here] off begin
		newEntity.setHospitalTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Hospital Tariff here] end
		// % protected region % [Add customisation for Referral Letter here] off begin
		String randomStringForReferralLetter = mockNeat
				.strings()
				.get();
		newEntity.setReferralLetter(randomStringForReferralLetter);
		// % protected region % [Add customisation for Referral Letter here] end
		// % protected region % [Add customisation for Third Sel Level here] off begin
		String randomStringForThirdSelLevel = mockNeat
				.strings()
				.get();
		newEntity.setThirdSelLevel(randomStringForThirdSelLevel);
		// % protected region % [Add customisation for Third Sel Level here] end
		// % protected region % [Add customisation for Staff Name here] off begin
		String randomStringForStaffName = mockNeat
				.strings()
				.get();
		newEntity.setStaffName(randomStringForStaffName);
		// % protected region % [Add customisation for Staff Name here] end
		// % protected region % [Add customisation for Date Grouping here] off begin
		newEntity.setDateGrouping(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Grouping here] end
		// % protected region % [Add customisation for INACBG Tariff here] off begin
		String randomStringForInacbgTariff = mockNeat
				.strings()
				.get();
		newEntity.setInacbgTariff(randomStringForInacbgTariff);
		// % protected region % [Add customisation for INACBG Tariff here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for CBG Type here] off begin
		String randomStringForCbgType = mockNeat
				.strings()
				.get();
		newEntity.setCbgType(randomStringForCbgType);
		// % protected region % [Add customisation for CBG Type here] end
		// % protected region % [Add customisation for Tariff here] off begin
		newEntity.setTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Tariff here] end
		// % protected region % [Add customisation for Sub Acute here] off begin
		String randomStringForSubAcute = mockNeat
				.strings()
				.get();
		newEntity.setSubAcute(randomStringForSubAcute);
		// % protected region % [Add customisation for Sub Acute here] end
		// % protected region % [Add customisation for Sub Acute Code here] off begin
		String randomStringForSubAcuteCode = mockNeat
				.strings()
				.get();
		newEntity.setSubAcuteCode(randomStringForSubAcuteCode);
		// % protected region % [Add customisation for Sub Acute Code here] end
		// % protected region % [Add customisation for Sub Acute Tariff here] off begin
		newEntity.setSubAcuteTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Sub Acute Tariff here] end
		// % protected region % [Add customisation for Chronic here] off begin
		String randomStringForChronic = mockNeat
				.strings()
				.get();
		newEntity.setChronic(randomStringForChronic);
		// % protected region % [Add customisation for Chronic here] end
		// % protected region % [Add customisation for Chronic Code here] off begin
		String randomStringForChronicCode = mockNeat
				.strings()
				.get();
		newEntity.setChronicCode(randomStringForChronicCode);
		// % protected region % [Add customisation for Chronic Code here] end
		// % protected region % [Add customisation for Chronic Tariff here] off begin
		newEntity.setChronicTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Chronic Tariff here] end
		// % protected region % [Add customisation for Result Spec Procedure here] off begin
		String randomStringForResultSpecProcedure = mockNeat
				.strings()
				.get();
		newEntity.setResultSpecProcedure(randomStringForResultSpecProcedure);
		// % protected region % [Add customisation for Result Spec Procedure here] end
		// % protected region % [Add customisation for Result Spec Drug here] off begin
		String randomStringForResultSpecDrug = mockNeat
				.strings()
				.get();
		newEntity.setResultSpecDrug(randomStringForResultSpecDrug);
		// % protected region % [Add customisation for Result Spec Drug here] end
		// % protected region % [Add customisation for Result Spec Investigation here] off begin
		String randomStringForResultSpecInvestigation = mockNeat
				.strings()
				.get();
		newEntity.setResultSpecInvestigation(randomStringForResultSpecInvestigation);
		// % protected region % [Add customisation for Result Spec Investigation here] end
		// % protected region % [Add customisation for Result Spec Prosthesis here] off begin
		String randomStringForResultSpecProsthesis = mockNeat
				.strings()
				.get();
		newEntity.setResultSpecProsthesis(randomStringForResultSpecProsthesis);
		// % protected region % [Add customisation for Result Spec Prosthesis here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringForHospitalClass = mockNeat
				.strings()
				.get();
		newEntity.setHospitalClass(randomStringForHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for Tariff Type here] off begin
		String randomStringForTariffType = mockNeat
				.strings()
				.get();
		newEntity.setTariffType(randomStringForTariffType);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Total Tariff here] off begin
		newEntity.setTotalTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Tariff here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		newEntity.setVisitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Spec Procedure Tariff here] off begin
		newEntity.setSpecProcedureTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Spec Procedure Tariff here] end
		// % protected region % [Add customisation for Spec Drug Tariff here] off begin
		newEntity.setSpecDrugTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Spec Drug Tariff here] end
		// % protected region % [Add customisation for Spec Investigation Tariff here] off begin
		newEntity.setSpecInvestigationTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Spec Investigation Tariff here] end
		// % protected region % [Add customisation for Spec Prosthesis Tariff here] off begin
		newEntity.setSpecProsthesisTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for Spec Prosthesis Tariff here] end
		// % protected region % [Add customisation for Upgrade Flag here] off begin
		newEntity.setUpgradeFlag(mockNeat.bools().get());
		// % protected region % [Add customisation for Upgrade Flag here] end
		// % protected region % [Add customisation for HCU Flag here] off begin
		newEntity.setHcuFlag(mockNeat.bools().get());
		// % protected region % [Add customisation for HCU Flag here] end
		// % protected region % [Add customisation for Grouper Flag here] off begin
		newEntity.setGrouperFlag(mockNeat.bools().get());
		// % protected region % [Add customisation for Grouper Flag here] end
		// % protected region % [Add customisation for Non Surgery Procedure here] off begin
		newEntity.setNonSurgeryProcedure(mockNeat.doubles().get());
		// % protected region % [Add customisation for Non Surgery Procedure here] end
		// % protected region % [Add customisation for Surgery Procedure here] off begin
		newEntity.setSurgeryProcedure(mockNeat.doubles().get());
		// % protected region % [Add customisation for Surgery Procedure here] end
		// % protected region % [Add customisation for Consultation here] off begin
		newEntity.setConsultation(mockNeat.doubles().get());
		// % protected region % [Add customisation for Consultation here] end
		// % protected region % [Add customisation for Specialist here] off begin
		newEntity.setSpecialist(mockNeat.doubles().get());
		// % protected region % [Add customisation for Specialist here] end
		// % protected region % [Add customisation for Nursing here] off begin
		newEntity.setNursing(mockNeat.doubles().get());
		// % protected region % [Add customisation for Nursing here] end
		// % protected region % [Add customisation for Diagnostic here] off begin
		newEntity.setDiagnostic(mockNeat.doubles().get());
		// % protected region % [Add customisation for Diagnostic here] end
		// % protected region % [Add customisation for Radiology here] off begin
		newEntity.setRadiology(mockNeat.doubles().get());
		// % protected region % [Add customisation for Radiology here] end
		// % protected region % [Add customisation for Laboratory here] off begin
		newEntity.setLaboratory(mockNeat.doubles().get());
		// % protected region % [Add customisation for Laboratory here] end
		// % protected region % [Add customisation for Blood Service here] off begin
		newEntity.setBloodService(mockNeat.doubles().get());
		// % protected region % [Add customisation for Blood Service here] end
		// % protected region % [Add customisation for Rehabilitation here] off begin
		newEntity.setRehabilitation(mockNeat.doubles().get());
		// % protected region % [Add customisation for Rehabilitation here] end
		// % protected region % [Add customisation for Bed Accomodation here] off begin
		newEntity.setBedAccomodation(mockNeat.doubles().get());
		// % protected region % [Add customisation for Bed Accomodation here] end
		// % protected region % [Add customisation for Intensive Care here] off begin
		newEntity.setIntensiveCare(mockNeat.doubles().get());
		// % protected region % [Add customisation for Intensive Care here] end
		// % protected region % [Add customisation for Drugs here] off begin
		newEntity.setDrugs(mockNeat.doubles().get());
		// % protected region % [Add customisation for Drugs here] end
		// % protected region % [Add customisation for Medical Equipment here] off begin
		newEntity.setMedicalEquipment(mockNeat.doubles().get());
		// % protected region % [Add customisation for Medical Equipment here] end
		// % protected region % [Add customisation for Dispensed Disposable here] off begin
		newEntity.setDispensedDisposable(mockNeat.doubles().get());
		// % protected region % [Add customisation for Dispensed Disposable here] end
		// % protected region % [Add customisation for Equipment Rental here] off begin
		newEntity.setEquipmentRental(mockNeat.doubles().get());
		// % protected region % [Add customisation for Equipment Rental here] end
		// % protected region % [Add customisation for ICD10 Code here] off begin
		String randomStringForIcd10Code = mockNeat
				.strings()
				.get();
		newEntity.setIcd10Code(randomStringForIcd10Code);
		// % protected region % [Add customisation for ICD10 Code here] end
		// % protected region % [Add customisation for ICD10 Desc here] off begin
		String randomStringForIcd10Desc = mockNeat
				.strings()
				.get();
		newEntity.setIcd10Desc(randomStringForIcd10Desc);
		// % protected region % [Add customisation for ICD10 Desc here] end
		// % protected region % [Add customisation for ICD10 Tariff here] off begin
		newEntity.setIcd10Tariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for ICD10 Tariff here] end
		// % protected region % [Add customisation for ICD9CM Code here] off begin
		String randomStringForIcd9cmCode = mockNeat
				.strings()
				.get();
		newEntity.setIcd9cmCode(randomStringForIcd9cmCode);
		// % protected region % [Add customisation for ICD9CM Code here] end
		// % protected region % [Add customisation for ICD9CM Desc here] off begin
		String randomStringForIcd9cmDesc = mockNeat
				.strings()
				.get();
		newEntity.setIcd9cmDesc(randomStringForIcd9cmDesc);
		// % protected region % [Add customisation for ICD9CM Desc here] end
		// % protected region % [Add customisation for ICD9CM Tariff here] off begin
		newEntity.setIcd9cmTariff(mockNeat.doubles().get());
		// % protected region % [Add customisation for ICD9CM Tariff here] end
		// % protected region % [Add customisation for Chronic Drugs here] off begin
		newEntity.setChronicDrugs(mockNeat.doubles().get());
		// % protected region % [Add customisation for Chronic Drugs here] end
		// % protected region % [Add customisation for Chemotherapy Drugs here] off begin
		newEntity.setChemotherapyDrugs(mockNeat.doubles().get());
		// % protected region % [Add customisation for Chemotherapy Drugs here] end
		// % protected region % [Add customisation for Class Upgrade here] off begin
		String randomStringForClassUpgrade = mockNeat
				.strings()
				.get();
		newEntity.setClassUpgrade(randomStringForClassUpgrade);
		// % protected region % [Add customisation for Class Upgrade here] end
		// % protected region % [Add customisation for High Care Unit here] off begin
		String randomStringForHighCareUnit = mockNeat
				.strings()
				.get();
		newEntity.setHighCareUnit(randomStringForHighCareUnit);
		// % protected region % [Add customisation for High Care Unit here] end
		// % protected region % [Add customisation for Inacbg Claim Created here] off begin
		newEntity.setInacbgClaimCreated(mockNeat.bools().get());
		// % protected region % [Add customisation for Inacbg Claim Created here] end
		// % protected region % [Add customisation for Inacbg Response here] off begin
		String randomStringForInacbgResponse = mockNeat
				.strings()
				.get();
		newEntity.setInacbgResponse(randomStringForInacbgResponse);
		// % protected region % [Add customisation for Inacbg Response here] end
		// % protected region % [Add customisation for Total Invoice here] off begin
		newEntity.setTotalInvoice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Invoice here] end

		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<BpjsINACBGClaimEntity> getObjectType() {
		return BpjsINACBGClaimEntity.class;
	}
}