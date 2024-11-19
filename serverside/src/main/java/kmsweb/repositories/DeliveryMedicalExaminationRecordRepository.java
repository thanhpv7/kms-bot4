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

import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
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
public interface DeliveryMedicalExaminationRecordRepository extends AbstractRepository<DeliveryMedicalExaminationRecordEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Gravida.
	 *
	 * @param pregnancyHistoryGravida the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Gravida
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryGravida(@NotNull String pregnancyHistoryGravida);
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Partum .
	 *
	 * @param pregnancyHistoryPartum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Partum 
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryPartum(@NotNull String pregnancyHistoryPartum);
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Abortum .
	 *
	 * @param pregnancyHistoryAbortum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Abortum 
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryAbortum(@NotNull String pregnancyHistoryAbortum);
	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Notes.
	 *
	 * @param pregnancyHistoryNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Notes
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryNotes(@NotNull String pregnancyHistoryNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute LNMP Start Date.
	 *
	 * @param lnmpStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LNMP Start Date
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLnmpStartDate(@NotNull OffsetDateTime lnmpStartDate);
	/**
	 * Return an entity or a list of entities that have the given attribute LNMP End Date.
	 *
	 * @param lnmpEndDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LNMP End Date
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLnmpEndDate(@NotNull OffsetDateTime lnmpEndDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Approximate Birth Date.
	 *
	 * @param approximateBirthDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approximate Birth Date
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByApproximateBirthDate(@NotNull OffsetDateTime approximateBirthDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Weeks.
	 *
	 * @param gestationAgeWeeks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Weeks
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByGestationAgeWeeks(@NotNull Integer gestationAgeWeeks);
	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Days.
	 *
	 * @param gestationAgeDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Days
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByGestationAgeDays(@NotNull Integer gestationAgeDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Tetanus Vaccine 1.
	 *
	 * @param tetanusVaccine1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tetanus Vaccine 1
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByTetanusVaccine1(@NotNull Boolean tetanusVaccine1);
	/**
	 * Return an entity or a list of entities that have the given attribute Tetanus Vaccine 2.
	 *
	 * @param tetanusVaccine2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tetanus Vaccine 2
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByTetanusVaccine2(@NotNull Boolean tetanusVaccine2);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByDeliveryType(@NotNull String deliveryType);
	/**
	 * Return an entity or a list of entities that have the given attribute Complications In Pregnancy.
	 *
	 * @param complicationsInPregnancy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complications In Pregnancy
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByComplicationsInPregnancy(@NotNull String complicationsInPregnancy);
	/**
	 * Return an entity or a list of entities that have the given attribute Risk Factor.
	 *
	 * @param riskFactor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Factor
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByRiskFactor(@NotNull String riskFactor);
	/**
	 * Return an entity or a list of entities that have the given attribute Fetal Presentation.
	 *
	 * @param fetalPresentation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fetal Presentation
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByFetalPresentation(@NotNull String fetalPresentation);
	/**
	 * Return an entity or a list of entities that have the given attribute Abdomen Examination.
	 *
	 * @param abdomenExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Abdomen Examination
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByAbdomenExamination(@NotNull String abdomenExamination);
	/**
	 * Return an entity or a list of entities that have the given attribute Fundal Height.
	 *
	 * @param fundalHeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fundal Height
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByFundalHeight(@NotNull String fundalHeight);
	/**
	 * Return an entity or a list of entities that have the given attribute FHR Per Minute.
	 *
	 * @param fhrPerMinute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FHR Per Minute
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByFhrPerMinute(@NotNull String fhrPerMinute);
	/**
	 * Return an entity or a list of entities that have the given attribute Estimated Fetal Weight.
	 *
	 * @param estimatedFetalWeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Estimated Fetal Weight
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByEstimatedFetalWeight(@NotNull String estimatedFetalWeight);
	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 1.
	 *
	 * @param leopold1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 1
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLeopold1(@NotNull String leopold1);
	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 2.
	 *
	 * @param leopold2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 2
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLeopold2(@NotNull String leopold2);
	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 3.
	 *
	 * @param leopold3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 3
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLeopold3(@NotNull String leopold3);
	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 4.
	 *
	 * @param leopold4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 4
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByLeopold4(@NotNull String leopold4);
	/**
	 * Return an entity or a list of entities that have the given attribute Genitelia Externa.
	 *
	 * @param geniteliaExterna the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Genitelia Externa
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByGeniteliaExterna(@NotNull String geniteliaExterna);
	/**
	 * Return an entity or a list of entities that have the given attribute Genitelia Interna.
	 *
	 * @param geniteliaInterna the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Genitelia Interna
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByGeniteliaInterna(@NotNull String geniteliaInterna);
	/**
	 * Return an entity or a list of entities that have the given attribute Vaginal Examination.
	 *
	 * @param vaginalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vaginal Examination
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByVaginalExamination(@NotNull String vaginalExamination);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Complication.
	 *
	 * @param deliveryComplication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Complication
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByDeliveryComplication(@NotNull String deliveryComplication);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Note.
	 *
	 * @param deliveryNote the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Note
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByDeliveryNote(@NotNull String deliveryNote);
	/**
	 * Return an entity or a list of entities that have the given attribute Normal Delivery Case.
	 *
	 * @param normalDeliveryCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Normal Delivery Case
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByNormalDeliveryCase(@NotNull Boolean normalDeliveryCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 1 Hour.
	 *
	 * @param stage1Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 1 Hour
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage1Hour(@NotNull Integer stage1Hour);
	/**
	 * Return an entity or a list of entities that have the given attribute Unnamed Integer 1.
	 *
	 * @param unnamedInteger1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unnamed Integer 1
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByUnnamedInteger1(@NotNull Integer unnamedInteger1);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 3 Hour.
	 *
	 * @param stage3Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 3 Hour
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage3Hour(@NotNull Integer stage3Hour);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 4 Hour.
	 *
	 * @param stage4Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 4 Hour
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage4Hour(@NotNull Integer stage4Hour);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 1 Minute.
	 *
	 * @param stage1Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 1 Minute
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage1Minute(@NotNull Integer stage1Minute);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 2 Minute.
	 *
	 * @param stage2Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 2 Minute
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage2Minute(@NotNull Integer stage2Minute);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 3 Minute.
	 *
	 * @param stage3Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 3 Minute
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage3Minute(@NotNull Integer stage3Minute);
	/**
	 * Return an entity or a list of entities that have the given attribute Stage 4 Minute.
	 *
	 * @param stage4Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 4 Minute
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByStage4Minute(@NotNull Integer stage4Minute);
	/**
	 * Return an entity or a list of entities that have the given attribute Placenta.
	 *
	 * @param placenta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Placenta
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPlacenta(@NotNull String placenta);
	/**
	 * Return an entity or a list of entities that have the given attribute Perineum.
	 *
	 * @param perineum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Perineum
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPerineum(@NotNull String perineum);
	/**
	 * Return an entity or a list of entities that have the given attribute Bleeding.
	 *
	 * @param bleeding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bleeding
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByBleeding(@NotNull String bleeding);
	/**
	 * Return an entity or a list of entities that have the given attribute Postpartum Complication.
	 *
	 * @param postpartumComplication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postpartum Complication
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPostpartumComplication(@NotNull String postpartumComplication);
	/**
	 * Return an entity or a list of entities that have the given attribute Newborn Delivered.
	 *
	 * @param newbornDelivered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn Delivered
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByNewbornDelivered(@NotNull Integer newbornDelivered);
	/**
	 * Return an entity or a list of entities that have the given attribute Perineum Infection.
	 *
	 * @param perineumInfection the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Perineum Infection
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByPerineumInfection(@NotNull Boolean perineumInfection);
	/**
	 * Return an entity or a list of entities that have the given attribute Early Breastfeeding Intiation.
	 *
	 * @param earlyBreastfeedingIntiation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Early Breastfeeding Intiation
	 */
	List<DeliveryMedicalExaminationRecordEntity> findByEarlyBreastfeedingIntiation(@NotNull Boolean earlyBreastfeedingIntiation);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DeliveryMedicalExaminationRecordEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<DeliveryMedicalExaminationRecordEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}