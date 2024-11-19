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
package kmsweb.repositories;

import kmsweb.entities.BpjsINACBGClaimEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface BpjsINACBGClaimRepository extends AbstractRepository<BpjsINACBGClaimEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	Optional<BpjsINACBGClaimEntity> findByClaimNo(@NotNull String claimNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	List<BpjsINACBGClaimEntity> findByPatientID(@NotNull String patientID);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Number.
	 *
	 * @param invoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Number
	 */
	List<BpjsINACBGClaimEntity> findByInvoiceNumber(@NotNull String invoiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	List<BpjsINACBGClaimEntity> findByBpjsCardNo(@NotNull String bpjsCardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	List<BpjsINACBGClaimEntity> findBySepNo(@NotNull String sepNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	List<BpjsINACBGClaimEntity> findByTreatmentType(@NotNull String treatmentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BpjsINACBGClaimEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Admission Date.
	 *
	 * @param admissionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date
	 */
	List<BpjsINACBGClaimEntity> findByAdmissionDate(@NotNull OffsetDateTime admissionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	List<BpjsINACBGClaimEntity> findByDismissalDate(@NotNull OffsetDateTime dismissalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute LOS.
	 *
	 * @param los the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LOS
	 */
	List<BpjsINACBGClaimEntity> findByLos(@NotNull String los);
	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal.
	 *
	 * @param dismissal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal
	 */
	List<BpjsINACBGClaimEntity> findByDismissal(@NotNull String dismissal);
	/**
	 * Return an entity or a list of entities that have the given attribute Responsible Doctor.
	 *
	 * @param responsibleDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Responsible Doctor
	 */
	List<BpjsINACBGClaimEntity> findByResponsibleDoctor(@NotNull String responsibleDoctor);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<BpjsINACBGClaimEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute ADL.
	 *
	 * @param adl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ADL
	 */
	List<BpjsINACBGClaimEntity> findByAdl(@NotNull Integer adl);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim Status.
	 *
	 * @param claimStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Status
	 */
	List<BpjsINACBGClaimEntity> findByClaimStatus(@NotNull String claimStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute SEP Status.
	 *
	 * @param sepStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Status
	 */
	List<BpjsINACBGClaimEntity> findBySepStatus(@NotNull String sepStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Tariff.
	 *
	 * @param hospitalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Tariff
	 */
	List<BpjsINACBGClaimEntity> findByHospitalTariff(@NotNull Double hospitalTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Referral Letter.
	 *
	 * @param referralLetter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Letter
	 */
	List<BpjsINACBGClaimEntity> findByReferralLetter(@NotNull String referralLetter);
	/**
	 * Return an entity or a list of entities that have the given attribute Third Sel Level.
	 *
	 * @param thirdSelLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Third Sel Level
	 */
	List<BpjsINACBGClaimEntity> findByThirdSelLevel(@NotNull String thirdSelLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Staff Name.
	 *
	 * @param staffName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Name
	 */
	List<BpjsINACBGClaimEntity> findByStaffName(@NotNull String staffName);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Grouping.
	 *
	 * @param dateGrouping the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Grouping
	 */
	List<BpjsINACBGClaimEntity> findByDateGrouping(@NotNull OffsetDateTime dateGrouping);
	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff.
	 *
	 * @param inacbgTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff
	 */
	List<BpjsINACBGClaimEntity> findByInacbgTariff(@NotNull String inacbgTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<BpjsINACBGClaimEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute CBG Type.
	 *
	 * @param cbgType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CBG Type
	 */
	List<BpjsINACBGClaimEntity> findByCbgType(@NotNull String cbgType);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff.
	 *
	 * @param tariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff
	 */
	List<BpjsINACBGClaimEntity> findByTariff(@NotNull Double tariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute.
	 *
	 * @param subAcute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute
	 */
	List<BpjsINACBGClaimEntity> findBySubAcute(@NotNull String subAcute);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute Code.
	 *
	 * @param subAcuteCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute Code
	 */
	List<BpjsINACBGClaimEntity> findBySubAcuteCode(@NotNull String subAcuteCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute Tariff.
	 *
	 * @param subAcuteTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute Tariff
	 */
	List<BpjsINACBGClaimEntity> findBySubAcuteTariff(@NotNull Double subAcuteTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Chronic.
	 *
	 * @param chronic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic
	 */
	List<BpjsINACBGClaimEntity> findByChronic(@NotNull String chronic);
	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Code.
	 *
	 * @param chronicCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Code
	 */
	List<BpjsINACBGClaimEntity> findByChronicCode(@NotNull String chronicCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Tariff.
	 *
	 * @param chronicTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Tariff
	 */
	List<BpjsINACBGClaimEntity> findByChronicTariff(@NotNull Double chronicTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Procedure.
	 *
	 * @param resultSpecProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Procedure
	 */
	List<BpjsINACBGClaimEntity> findByResultSpecProcedure(@NotNull String resultSpecProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Drug.
	 *
	 * @param resultSpecDrug the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Drug
	 */
	List<BpjsINACBGClaimEntity> findByResultSpecDrug(@NotNull String resultSpecDrug);
	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Investigation.
	 *
	 * @param resultSpecInvestigation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Investigation
	 */
	List<BpjsINACBGClaimEntity> findByResultSpecInvestigation(@NotNull String resultSpecInvestigation);
	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Prosthesis.
	 *
	 * @param resultSpecProsthesis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Prosthesis
	 */
	List<BpjsINACBGClaimEntity> findByResultSpecProsthesis(@NotNull String resultSpecProsthesis);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	List<BpjsINACBGClaimEntity> findByHospitalClass(@NotNull String hospitalClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	List<BpjsINACBGClaimEntity> findByTariffType(@NotNull String tariffType);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Tariff.
	 *
	 * @param totalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Tariff
	 */
	List<BpjsINACBGClaimEntity> findByTotalTariff(@NotNull Double totalTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Visit Date.
	 *
	 * @param visitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Date
	 */
	List<BpjsINACBGClaimEntity> findByVisitDate(@NotNull OffsetDateTime visitDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Spec Procedure Tariff.
	 *
	 * @param specProcedureTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Procedure Tariff
	 */
	List<BpjsINACBGClaimEntity> findBySpecProcedureTariff(@NotNull Double specProcedureTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Spec Drug Tariff.
	 *
	 * @param specDrugTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Drug Tariff
	 */
	List<BpjsINACBGClaimEntity> findBySpecDrugTariff(@NotNull Double specDrugTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Spec Investigation Tariff.
	 *
	 * @param specInvestigationTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Investigation Tariff
	 */
	List<BpjsINACBGClaimEntity> findBySpecInvestigationTariff(@NotNull Double specInvestigationTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Spec Prosthesis Tariff.
	 *
	 * @param specProsthesisTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Prosthesis Tariff
	 */
	List<BpjsINACBGClaimEntity> findBySpecProsthesisTariff(@NotNull Double specProsthesisTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Upgrade Flag.
	 *
	 * @param upgradeFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upgrade Flag
	 */
	List<BpjsINACBGClaimEntity> findByUpgradeFlag(@NotNull Boolean upgradeFlag);
	/**
	 * Return an entity or a list of entities that have the given attribute HCU Flag.
	 *
	 * @param hcuFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HCU Flag
	 */
	List<BpjsINACBGClaimEntity> findByHcuFlag(@NotNull Boolean hcuFlag);
	/**
	 * Return an entity or a list of entities that have the given attribute Grouper Flag.
	 *
	 * @param grouperFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Grouper Flag
	 */
	List<BpjsINACBGClaimEntity> findByGrouperFlag(@NotNull Boolean grouperFlag);
	/**
	 * Return an entity or a list of entities that have the given attribute Non Surgery Procedure.
	 *
	 * @param nonSurgeryProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Non Surgery Procedure
	 */
	List<BpjsINACBGClaimEntity> findByNonSurgeryProcedure(@NotNull Double nonSurgeryProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Procedure.
	 *
	 * @param surgeryProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Procedure
	 */
	List<BpjsINACBGClaimEntity> findBySurgeryProcedure(@NotNull Double surgeryProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Consultation.
	 *
	 * @param consultation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consultation
	 */
	List<BpjsINACBGClaimEntity> findByConsultation(@NotNull Double consultation);
	/**
	 * Return an entity or a list of entities that have the given attribute Specialist.
	 *
	 * @param specialist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialist
	 */
	List<BpjsINACBGClaimEntity> findBySpecialist(@NotNull Double specialist);
	/**
	 * Return an entity or a list of entities that have the given attribute Nursing.
	 *
	 * @param nursing the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nursing
	 */
	List<BpjsINACBGClaimEntity> findByNursing(@NotNull Double nursing);
	/**
	 * Return an entity or a list of entities that have the given attribute Diagnostic.
	 *
	 * @param diagnostic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnostic
	 */
	List<BpjsINACBGClaimEntity> findByDiagnostic(@NotNull Double diagnostic);
	/**
	 * Return an entity or a list of entities that have the given attribute Radiology.
	 *
	 * @param radiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Radiology
	 */
	List<BpjsINACBGClaimEntity> findByRadiology(@NotNull Double radiology);
	/**
	 * Return an entity or a list of entities that have the given attribute Laboratory.
	 *
	 * @param laboratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Laboratory
	 */
	List<BpjsINACBGClaimEntity> findByLaboratory(@NotNull Double laboratory);
	/**
	 * Return an entity or a list of entities that have the given attribute Blood Service.
	 *
	 * @param bloodService the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Service
	 */
	List<BpjsINACBGClaimEntity> findByBloodService(@NotNull Double bloodService);
	/**
	 * Return an entity or a list of entities that have the given attribute Rehabilitation.
	 *
	 * @param rehabilitation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rehabilitation
	 */
	List<BpjsINACBGClaimEntity> findByRehabilitation(@NotNull Double rehabilitation);
	/**
	 * Return an entity or a list of entities that have the given attribute Bed Accomodation.
	 *
	 * @param bedAccomodation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Accomodation
	 */
	List<BpjsINACBGClaimEntity> findByBedAccomodation(@NotNull Double bedAccomodation);
	/**
	 * Return an entity or a list of entities that have the given attribute Intensive Care.
	 *
	 * @param intensiveCare the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intensive Care
	 */
	List<BpjsINACBGClaimEntity> findByIntensiveCare(@NotNull Double intensiveCare);
	/**
	 * Return an entity or a list of entities that have the given attribute Drugs.
	 *
	 * @param drugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drugs
	 */
	List<BpjsINACBGClaimEntity> findByDrugs(@NotNull Double drugs);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Equipment.
	 *
	 * @param medicalEquipment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Equipment
	 */
	List<BpjsINACBGClaimEntity> findByMedicalEquipment(@NotNull Double medicalEquipment);
	/**
	 * Return an entity or a list of entities that have the given attribute Dispensed Disposable.
	 *
	 * @param dispensedDisposable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dispensed Disposable
	 */
	List<BpjsINACBGClaimEntity> findByDispensedDisposable(@NotNull Double dispensedDisposable);
	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Rental.
	 *
	 * @param equipmentRental the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Rental
	 */
	List<BpjsINACBGClaimEntity> findByEquipmentRental(@NotNull Double equipmentRental);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Code.
	 *
	 * @param icd10Code the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Code
	 */
	List<BpjsINACBGClaimEntity> findByIcd10Code(@NotNull String icd10Code);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Desc.
	 *
	 * @param icd10Desc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Desc
	 */
	List<BpjsINACBGClaimEntity> findByIcd10Desc(@NotNull String icd10Desc);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Tariff.
	 *
	 * @param icd10Tariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Tariff
	 */
	List<BpjsINACBGClaimEntity> findByIcd10Tariff(@NotNull Double icd10Tariff);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Code.
	 *
	 * @param icd9cmCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Code
	 */
	List<BpjsINACBGClaimEntity> findByIcd9cmCode(@NotNull String icd9cmCode);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Desc.
	 *
	 * @param icd9cmDesc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Desc
	 */
	List<BpjsINACBGClaimEntity> findByIcd9cmDesc(@NotNull String icd9cmDesc);
	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Tariff.
	 *
	 * @param icd9cmTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Tariff
	 */
	List<BpjsINACBGClaimEntity> findByIcd9cmTariff(@NotNull Double icd9cmTariff);
	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Drugs.
	 *
	 * @param chronicDrugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Drugs
	 */
	List<BpjsINACBGClaimEntity> findByChronicDrugs(@NotNull Double chronicDrugs);
	/**
	 * Return an entity or a list of entities that have the given attribute Chemotherapy Drugs.
	 *
	 * @param chemotherapyDrugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chemotherapy Drugs
	 */
	List<BpjsINACBGClaimEntity> findByChemotherapyDrugs(@NotNull Double chemotherapyDrugs);
	/**
	 * Return an entity or a list of entities that have the given attribute Class Upgrade.
	 *
	 * @param classUpgrade the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Class Upgrade
	 */
	List<BpjsINACBGClaimEntity> findByClassUpgrade(@NotNull String classUpgrade);
	/**
	 * Return an entity or a list of entities that have the given attribute High Care Unit.
	 *
	 * @param highCareUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute High Care Unit
	 */
	List<BpjsINACBGClaimEntity> findByHighCareUnit(@NotNull String highCareUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Inacbg Claim Created.
	 *
	 * @param inacbgClaimCreated the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inacbg Claim Created
	 */
	List<BpjsINACBGClaimEntity> findByInacbgClaimCreated(@NotNull Boolean inacbgClaimCreated);
	/**
	 * Return an entity or a list of entities that have the given attribute Inacbg Response.
	 *
	 * @param inacbgResponse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inacbg Response
	 */
	List<BpjsINACBGClaimEntity> findByInacbgResponse(@NotNull String inacbgResponse);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Invoice.
	 *
	 * @param totalInvoice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Invoice
	 */
	List<BpjsINACBGClaimEntity> findByTotalInvoice(@NotNull Double totalInvoice);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsINACBGClaimEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsINACBGClaimEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}