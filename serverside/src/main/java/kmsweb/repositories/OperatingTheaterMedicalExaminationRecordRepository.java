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

import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface OperatingTheaterMedicalExaminationRecordRepository extends AbstractRepository<OperatingTheaterMedicalExaminationRecordEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Has Confirmed Identity.
	 *
	 * @param hasConfirmedIdentity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Confirmed Identity
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByHasConfirmedIdentity(@NotNull Boolean hasConfirmedIdentity);
	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Safety Check Completed.
	 *
	 * @param anesthesiaSafetyCheckCompleted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Safety Check Completed
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByAnesthesiaSafetyCheckCompleted(@NotNull Boolean anesthesiaSafetyCheckCompleted);
	/**
	 * Return an entity or a list of entities that have the given attribute Pulse Oxymeter Functioning.
	 *
	 * @param pulseOxymeterFunctioning the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pulse Oxymeter Functioning
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByPulseOxymeterFunctioning(@NotNull Boolean pulseOxymeterFunctioning);
	/**
	 * Return an entity or a list of entities that have the given attribute Site Marked.
	 *
	 * @param siteMarked the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Site Marked
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findBySiteMarked(@NotNull String siteMarked);
	/**
	 * Return an entity or a list of entities that have the given attribute Has Known Allergy.
	 *
	 * @param hasKnownAllergy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Known Allergy
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByHasKnownAllergy(@NotNull String hasKnownAllergy);
	/**
	 * Return an entity or a list of entities that have the given attribute Has Difficult Airway Risk.
	 *
	 * @param hasDifficultAirwayRisk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Difficult Airway Risk
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByHasDifficultAirwayRisk(@NotNull String hasDifficultAirwayRisk);
	/**
	 * Return an entity or a list of entities that have the given attribute Has Risk Of Blood Loss.
	 *
	 * @param hasRiskOfBloodLoss the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Risk Of Blood Loss
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByHasRiskOfBloodLoss(@NotNull String hasRiskOfBloodLoss);
	/**
	 * Return an entity or a list of entities that have the given attribute Team Member Introduced.
	 *
	 * @param teamMemberIntroduced the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Team Member Introduced
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByTeamMemberIntroduced(@NotNull Boolean teamMemberIntroduced);
	/**
	 * Return an entity or a list of entities that have the given attribute Professional Confirmed Patient.
	 *
	 * @param professionalConfirmedPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Professional Confirmed Patient
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByProfessionalConfirmedPatient(@NotNull Boolean professionalConfirmedPatient);
	/**
	 * Return an entity or a list of entities that have the given attribute Antibiotic Prophylaxis Given.
	 *
	 * @param antibioticProphylaxisGiven the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Antibiotic Prophylaxis Given
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByAntibioticProphylaxisGiven(@NotNull String antibioticProphylaxisGiven);
	/**
	 * Return an entity or a list of entities that have the given attribute Essential Imaging Displayed.
	 *
	 * @param essentialImagingDisplayed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Essential Imaging Displayed
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByEssentialImagingDisplayed(@NotNull String essentialImagingDisplayed);
	/**
	 * Return an entity or a list of entities that have the given attribute Whare Are Critical Steps.
	 *
	 * @param whareAreCriticalSteps the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Whare Are Critical Steps
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByWhareAreCriticalSteps(@NotNull Boolean whareAreCriticalSteps);
	/**
	 * Return an entity or a list of entities that have the given attribute How Long Case Take.
	 *
	 * @param howLongCaseTake the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute How Long Case Take
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByHowLongCaseTake(@NotNull Boolean howLongCaseTake);
	/**
	 * Return an entity or a list of entities that have the given attribute What Is Anticipated Blood Loss.
	 *
	 * @param whatIsAnticipatedBloodLoss the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute What Is Anticipated Blood Loss
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByWhatIsAnticipatedBloodLoss(@NotNull Boolean whatIsAnticipatedBloodLoss);
	/**
	 * Return an entity or a list of entities that have the given attribute Any Patient Specific Concerns.
	 *
	 * @param anyPatientSpecificConcerns the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Any Patient Specific Concerns
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByAnyPatientSpecificConcerns(@NotNull Boolean anyPatientSpecificConcerns);
	/**
	 * Return an entity or a list of entities that have the given attribute Sterlity Been Confirmed.
	 *
	 * @param sterlityBeenConfirmed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sterlity Been Confirmed
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findBySterlityBeenConfirmed(@NotNull Boolean sterlityBeenConfirmed);
	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Issues Any Concern.
	 *
	 * @param equipmentIssuesAnyConcern the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Issues Any Concern
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByEquipmentIssuesAnyConcern(@NotNull Boolean equipmentIssuesAnyConcern);
	/**
	 * Return an entity or a list of entities that have the given attribute Name Of Procedure.
	 *
	 * @param nameOfProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name Of Procedure
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByNameOfProcedure(@NotNull Boolean nameOfProcedure);
	/**
	 * Return an entity or a list of entities that have the given attribute Instruments Need Count Correct.
	 *
	 * @param instrumentsNeedCountCorrect the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruments Need Count Correct
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByInstrumentsNeedCountCorrect(@NotNull Boolean instrumentsNeedCountCorrect);
	/**
	 * Return an entity or a list of entities that have the given attribute Specimen Is Labeled.
	 *
	 * @param specimenIsLabeled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specimen Is Labeled
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findBySpecimenIsLabeled(@NotNull Boolean specimenIsLabeled);
	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Problems Addressed.
	 *
	 * @param equipmentProblemsAddressed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Problems Addressed
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByEquipmentProblemsAddressed(@NotNull Boolean equipmentProblemsAddressed);
	/**
	 * Return an entity or a list of entities that have the given attribute Key Concerns For Recovery.
	 *
	 * @param keyConcernsForRecovery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Key Concerns For Recovery
	 */
	List<OperatingTheaterMedicalExaminationRecordEntity> findByKeyConcernsForRecovery(@NotNull Boolean keyConcernsForRecovery);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<OperatingTheaterMedicalExaminationRecordEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<OperatingTheaterMedicalExaminationRecordEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}