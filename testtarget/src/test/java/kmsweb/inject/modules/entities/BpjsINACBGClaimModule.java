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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for BPJS INACBG Claim used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class BpjsINACBGClaimModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring BpjsINACBGClaimModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured BpjsINACBGClaimModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public BpjsINACBGClaimEntityFactory bpjsINACBGClaimEntityFactory(
			// % protected region % [Apply any additional injected arguments for bpjsINACBGClaimEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for bpjsINACBGClaimEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating BpjsINACBGClaimEntityFactory");

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityFactory before the main body here] end

		BpjsINACBGClaimEntityFactory entityFactory = new BpjsINACBGClaimEntityFactory(
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGClaimEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for BpjsINACBGClaimEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityFactory after the main body here] end

		log.trace("Created BpjsINACBGClaimEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty BPJS INACBG Claim entity with no references set.
	 */
	@Provides
	@Named("bpjsINACBGClaimEntityWithNoRef")
	public BpjsINACBGClaimEntity bpjsINACBGClaimEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type BpjsINACBGClaimEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef before the main body here] end

		BpjsINACBGClaimEntity newEntity = new BpjsINACBGClaimEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Claim No here] off begin
		String randomStringforClaimNo = mock
				.strings()
				.get();
		newEntity.setClaimNo(randomStringforClaimNo);
		// % protected region % [Add customisation for Claim No here] end
		// % protected region % [Add customisation for Patient ID here] off begin
		String randomStringforPatientID = mock
				.strings()
				.get();
		newEntity.setPatientID(randomStringforPatientID);
		// % protected region % [Add customisation for Patient ID here] end
		// % protected region % [Add customisation for Invoice Number here] off begin
		String randomStringforInvoiceNumber = mock
				.strings()
				.get();
		newEntity.setInvoiceNumber(randomStringforInvoiceNumber);
		// % protected region % [Add customisation for Invoice Number here] end
		// % protected region % [Add customisation for BPJS Card No here] off begin
		String randomStringforBpjsCardNo = mock
				.strings()
				.get();
		newEntity.setBpjsCardNo(randomStringforBpjsCardNo);
		// % protected region % [Add customisation for BPJS Card No here] end
		// % protected region % [Add customisation for SEP No here] off begin
		String randomStringforSepNo = mock
				.strings()
				.get();
		newEntity.setSepNo(randomStringforSepNo);
		// % protected region % [Add customisation for SEP No here] end
		// % protected region % [Add customisation for Treatment Type here] off begin
		String randomStringforTreatmentType = mock
				.strings()
				.get();
		newEntity.setTreatmentType(randomStringforTreatmentType);
		// % protected region % [Add customisation for Treatment Type here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Admission Date here] off begin
		newEntity.setAdmissionDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Admission Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for LOS here] off begin
		String randomStringforLos = mock
				.strings()
				.get();
		newEntity.setLos(randomStringforLos);
		// % protected region % [Add customisation for LOS here] end
		// % protected region % [Add customisation for Dismissal here] off begin
		String randomStringforDismissal = mock
				.strings()
				.get();
		newEntity.setDismissal(randomStringforDismissal);
		// % protected region % [Add customisation for Dismissal here] end
		// % protected region % [Add customisation for Responsible Doctor here] off begin
		String randomStringforResponsibleDoctor = mock
				.strings()
				.get();
		newEntity.setResponsibleDoctor(randomStringforResponsibleDoctor);
		// % protected region % [Add customisation for Responsible Doctor here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for ADL here] off begin
		newEntity.setAdl(mock.ints().get());
		// % protected region % [Add customisation for ADL here] end
		// % protected region % [Add customisation for Claim Status here] off begin
		String randomStringforClaimStatus = mock
				.strings()
				.get();
		newEntity.setClaimStatus(randomStringforClaimStatus);
		// % protected region % [Add customisation for Claim Status here] end
		// % protected region % [Add customisation for SEP Status here] off begin
		String randomStringforSepStatus = mock
				.strings()
				.get();
		newEntity.setSepStatus(randomStringforSepStatus);
		// % protected region % [Add customisation for SEP Status here] end
		// % protected region % [Add customisation for Hospital Tariff here] off begin
		newEntity.setHospitalTariff(mock.doubles().get());
		// % protected region % [Add customisation for Hospital Tariff here] end
		// % protected region % [Add customisation for Referral Letter here] off begin
		String randomStringforReferralLetter = mock
				.strings()
				.get();
		newEntity.setReferralLetter(randomStringforReferralLetter);
		// % protected region % [Add customisation for Referral Letter here] end
		// % protected region % [Add customisation for Third Sel Level here] off begin
		String randomStringforThirdSelLevel = mock
				.strings()
				.get();
		newEntity.setThirdSelLevel(randomStringforThirdSelLevel);
		// % protected region % [Add customisation for Third Sel Level here] end
		// % protected region % [Add customisation for Staff Name here] off begin
		String randomStringforStaffName = mock
				.strings()
				.get();
		newEntity.setStaffName(randomStringforStaffName);
		// % protected region % [Add customisation for Staff Name here] end
		// % protected region % [Add customisation for Date Grouping here] off begin
		newEntity.setDateGrouping(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Grouping here] end
		// % protected region % [Add customisation for INACBG Tariff here] off begin
		String randomStringforInacbgTariff = mock
				.strings()
				.get();
		newEntity.setInacbgTariff(randomStringforInacbgTariff);
		// % protected region % [Add customisation for INACBG Tariff here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for CBG Type here] off begin
		String randomStringforCbgType = mock
				.strings()
				.get();
		newEntity.setCbgType(randomStringforCbgType);
		// % protected region % [Add customisation for CBG Type here] end
		// % protected region % [Add customisation for Tariff here] off begin
		newEntity.setTariff(mock.doubles().get());
		// % protected region % [Add customisation for Tariff here] end
		// % protected region % [Add customisation for Sub Acute here] off begin
		String randomStringforSubAcute = mock
				.strings()
				.get();
		newEntity.setSubAcute(randomStringforSubAcute);
		// % protected region % [Add customisation for Sub Acute here] end
		// % protected region % [Add customisation for Sub Acute Code here] off begin
		String randomStringforSubAcuteCode = mock
				.strings()
				.get();
		newEntity.setSubAcuteCode(randomStringforSubAcuteCode);
		// % protected region % [Add customisation for Sub Acute Code here] end
		// % protected region % [Add customisation for Sub Acute Tariff here] off begin
		newEntity.setSubAcuteTariff(mock.doubles().get());
		// % protected region % [Add customisation for Sub Acute Tariff here] end
		// % protected region % [Add customisation for Chronic here] off begin
		String randomStringforChronic = mock
				.strings()
				.get();
		newEntity.setChronic(randomStringforChronic);
		// % protected region % [Add customisation for Chronic here] end
		// % protected region % [Add customisation for Chronic Code here] off begin
		String randomStringforChronicCode = mock
				.strings()
				.get();
		newEntity.setChronicCode(randomStringforChronicCode);
		// % protected region % [Add customisation for Chronic Code here] end
		// % protected region % [Add customisation for Chronic Tariff here] off begin
		newEntity.setChronicTariff(mock.doubles().get());
		// % protected region % [Add customisation for Chronic Tariff here] end
		// % protected region % [Add customisation for Result Spec Procedure here] off begin
		String randomStringforResultSpecProcedure = mock
				.strings()
				.get();
		newEntity.setResultSpecProcedure(randomStringforResultSpecProcedure);
		// % protected region % [Add customisation for Result Spec Procedure here] end
		// % protected region % [Add customisation for Result Spec Drug here] off begin
		String randomStringforResultSpecDrug = mock
				.strings()
				.get();
		newEntity.setResultSpecDrug(randomStringforResultSpecDrug);
		// % protected region % [Add customisation for Result Spec Drug here] end
		// % protected region % [Add customisation for Result Spec Investigation here] off begin
		String randomStringforResultSpecInvestigation = mock
				.strings()
				.get();
		newEntity.setResultSpecInvestigation(randomStringforResultSpecInvestigation);
		// % protected region % [Add customisation for Result Spec Investigation here] end
		// % protected region % [Add customisation for Result Spec Prosthesis here] off begin
		String randomStringforResultSpecProsthesis = mock
				.strings()
				.get();
		newEntity.setResultSpecProsthesis(randomStringforResultSpecProsthesis);
		// % protected region % [Add customisation for Result Spec Prosthesis here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringforHospitalClass = mock
				.strings()
				.get();
		newEntity.setHospitalClass(randomStringforHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for Tariff Type here] off begin
		String randomStringforTariffType = mock
				.strings()
				.get();
		newEntity.setTariffType(randomStringforTariffType);
		// % protected region % [Add customisation for Tariff Type here] end
		// % protected region % [Add customisation for Total Tariff here] off begin
		newEntity.setTotalTariff(mock.doubles().get());
		// % protected region % [Add customisation for Total Tariff here] end
		// % protected region % [Add customisation for Visit Date here] off begin
		newEntity.setVisitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Date here] end
		// % protected region % [Add customisation for Spec Procedure Tariff here] off begin
		newEntity.setSpecProcedureTariff(mock.doubles().get());
		// % protected region % [Add customisation for Spec Procedure Tariff here] end
		// % protected region % [Add customisation for Spec Drug Tariff here] off begin
		newEntity.setSpecDrugTariff(mock.doubles().get());
		// % protected region % [Add customisation for Spec Drug Tariff here] end
		// % protected region % [Add customisation for Spec Investigation Tariff here] off begin
		newEntity.setSpecInvestigationTariff(mock.doubles().get());
		// % protected region % [Add customisation for Spec Investigation Tariff here] end
		// % protected region % [Add customisation for Spec Prosthesis Tariff here] off begin
		newEntity.setSpecProsthesisTariff(mock.doubles().get());
		// % protected region % [Add customisation for Spec Prosthesis Tariff here] end
		// % protected region % [Add customisation for Upgrade Flag here] off begin
		newEntity.setUpgradeFlag(mock.bools().get());
		// % protected region % [Add customisation for Upgrade Flag here] end
		// % protected region % [Add customisation for HCU Flag here] off begin
		newEntity.setHcuFlag(mock.bools().get());
		// % protected region % [Add customisation for HCU Flag here] end
		// % protected region % [Add customisation for Grouper Flag here] off begin
		newEntity.setGrouperFlag(mock.bools().get());
		// % protected region % [Add customisation for Grouper Flag here] end
		// % protected region % [Add customisation for Non Surgery Procedure here] off begin
		newEntity.setNonSurgeryProcedure(mock.doubles().get());
		// % protected region % [Add customisation for Non Surgery Procedure here] end
		// % protected region % [Add customisation for Surgery Procedure here] off begin
		newEntity.setSurgeryProcedure(mock.doubles().get());
		// % protected region % [Add customisation for Surgery Procedure here] end
		// % protected region % [Add customisation for Consultation here] off begin
		newEntity.setConsultation(mock.doubles().get());
		// % protected region % [Add customisation for Consultation here] end
		// % protected region % [Add customisation for Specialist here] off begin
		newEntity.setSpecialist(mock.doubles().get());
		// % protected region % [Add customisation for Specialist here] end
		// % protected region % [Add customisation for Nursing here] off begin
		newEntity.setNursing(mock.doubles().get());
		// % protected region % [Add customisation for Nursing here] end
		// % protected region % [Add customisation for Diagnostic here] off begin
		newEntity.setDiagnostic(mock.doubles().get());
		// % protected region % [Add customisation for Diagnostic here] end
		// % protected region % [Add customisation for Radiology here] off begin
		newEntity.setRadiology(mock.doubles().get());
		// % protected region % [Add customisation for Radiology here] end
		// % protected region % [Add customisation for Laboratory here] off begin
		newEntity.setLaboratory(mock.doubles().get());
		// % protected region % [Add customisation for Laboratory here] end
		// % protected region % [Add customisation for Blood Service here] off begin
		newEntity.setBloodService(mock.doubles().get());
		// % protected region % [Add customisation for Blood Service here] end
		// % protected region % [Add customisation for Rehabilitation here] off begin
		newEntity.setRehabilitation(mock.doubles().get());
		// % protected region % [Add customisation for Rehabilitation here] end
		// % protected region % [Add customisation for Bed Accomodation here] off begin
		newEntity.setBedAccomodation(mock.doubles().get());
		// % protected region % [Add customisation for Bed Accomodation here] end
		// % protected region % [Add customisation for Intensive Care here] off begin
		newEntity.setIntensiveCare(mock.doubles().get());
		// % protected region % [Add customisation for Intensive Care here] end
		// % protected region % [Add customisation for Drugs here] off begin
		newEntity.setDrugs(mock.doubles().get());
		// % protected region % [Add customisation for Drugs here] end
		// % protected region % [Add customisation for Medical Equipment here] off begin
		newEntity.setMedicalEquipment(mock.doubles().get());
		// % protected region % [Add customisation for Medical Equipment here] end
		// % protected region % [Add customisation for Dispensed Disposable here] off begin
		newEntity.setDispensedDisposable(mock.doubles().get());
		// % protected region % [Add customisation for Dispensed Disposable here] end
		// % protected region % [Add customisation for Equipment Rental here] off begin
		newEntity.setEquipmentRental(mock.doubles().get());
		// % protected region % [Add customisation for Equipment Rental here] end
		// % protected region % [Add customisation for ICD10 Code here] off begin
		String randomStringforIcd10Code = mock
				.strings()
				.get();
		newEntity.setIcd10Code(randomStringforIcd10Code);
		// % protected region % [Add customisation for ICD10 Code here] end
		// % protected region % [Add customisation for ICD10 Desc here] off begin
		String randomStringforIcd10Desc = mock
				.strings()
				.get();
		newEntity.setIcd10Desc(randomStringforIcd10Desc);
		// % protected region % [Add customisation for ICD10 Desc here] end
		// % protected region % [Add customisation for ICD10 Tariff here] off begin
		newEntity.setIcd10Tariff(mock.doubles().get());
		// % protected region % [Add customisation for ICD10 Tariff here] end
		// % protected region % [Add customisation for ICD9CM Code here] off begin
		String randomStringforIcd9cmCode = mock
				.strings()
				.get();
		newEntity.setIcd9cmCode(randomStringforIcd9cmCode);
		// % protected region % [Add customisation for ICD9CM Code here] end
		// % protected region % [Add customisation for ICD9CM Desc here] off begin
		String randomStringforIcd9cmDesc = mock
				.strings()
				.get();
		newEntity.setIcd9cmDesc(randomStringforIcd9cmDesc);
		// % protected region % [Add customisation for ICD9CM Desc here] end
		// % protected region % [Add customisation for ICD9CM Tariff here] off begin
		newEntity.setIcd9cmTariff(mock.doubles().get());
		// % protected region % [Add customisation for ICD9CM Tariff here] end
		// % protected region % [Add customisation for Chronic Drugs here] off begin
		newEntity.setChronicDrugs(mock.doubles().get());
		// % protected region % [Add customisation for Chronic Drugs here] end
		// % protected region % [Add customisation for Chemotherapy Drugs here] off begin
		newEntity.setChemotherapyDrugs(mock.doubles().get());
		// % protected region % [Add customisation for Chemotherapy Drugs here] end
		// % protected region % [Add customisation for Class Upgrade here] off begin
		String randomStringforClassUpgrade = mock
				.strings()
				.get();
		newEntity.setClassUpgrade(randomStringforClassUpgrade);
		// % protected region % [Add customisation for Class Upgrade here] end
		// % protected region % [Add customisation for High Care Unit here] off begin
		String randomStringforHighCareUnit = mock
				.strings()
				.get();
		newEntity.setHighCareUnit(randomStringforHighCareUnit);
		// % protected region % [Add customisation for High Care Unit here] end
		// % protected region % [Add customisation for Inacbg Claim Created here] off begin
		newEntity.setInacbgClaimCreated(mock.bools().get());
		// % protected region % [Add customisation for Inacbg Claim Created here] end
		// % protected region % [Add customisation for Inacbg Response here] off begin
		String randomStringforInacbgResponse = mock
				.strings()
				.get();
		newEntity.setInacbgResponse(randomStringforInacbgResponse);
		// % protected region % [Add customisation for Inacbg Response here] end
		// % protected region % [Add customisation for Total Invoice here] off begin
		newEntity.setTotalInvoice(mock.doubles().get());
		// % protected region % [Add customisation for Total Invoice here] end

		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimWithNoRef after the main body here] end

		log.trace("Created entity of type BpjsINACBGClaimEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of BPJS INACBG Claim entities with no reference at all.
	 */
	@Provides
	@Named("bpjsINACBGClaimEntitiesWithNoRef")
	public Collection<BpjsINACBGClaimEntity> bpjsINACBGClaimEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntitiesWithNoRef here] end
		BpjsINACBGClaimEntityFactory bpjsINACBGClaimEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGClaimEntity with no reference");

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithNoRef before the main body here] end

		Collection<BpjsINACBGClaimEntity> newEntities = bpjsINACBGClaimEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type BpjsINACBGClaimEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a BPJS INACBG Claim entity with all references set.
	 */
	@Provides
	@Named("bpjsINACBGClaimEntityWithRefs")
	public BpjsINACBGClaimEntity bpjsINACBGClaimEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type BpjsINACBGClaimEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityWithRefs before the main body here] end

		BpjsINACBGClaimEntity bpjsINACBGClaimEntity = injector.getInstance(Key.get(BpjsINACBGClaimEntity.class, Names.named("bpjsINACBGClaimEntityWithNoRef")));

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntityWithRefs after the main body here] end

		log.trace("Created entity of type BpjsINACBGClaimEntity with references");

		return bpjsINACBGClaimEntity;
	}

	/**
	 * Return a collection of BPJS INACBG Claim entities with all references set.
	 */
	@Provides
	@Named("bpjsINACBGClaimEntitiesWithRefs")
	public Collection<BpjsINACBGClaimEntity> bpjsINACBGClaimEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for bpjsINACBGClaimEntitiesWithRefs here] end
		BpjsINACBGClaimEntityFactory bpjsINACBGClaimEntityFactory
	) {
		log.trace("Creating entities of type BpjsINACBGClaimEntity with references");

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithRefs before the main body here] end

		Collection<BpjsINACBGClaimEntity> newEntities = bpjsINACBGClaimEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for bpjsINACBGClaimEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type BpjsINACBGClaimEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
