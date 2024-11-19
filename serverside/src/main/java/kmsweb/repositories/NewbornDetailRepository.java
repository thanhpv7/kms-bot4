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

import kmsweb.entities.NewbornDetailEntity;
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
public interface NewbornDetailRepository extends AbstractRepository<NewbornDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Newborn First Name.
	 *
	 * @param newbornFirstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn First Name
	 */
	List<NewbornDetailEntity> findByNewbornFirstName(@NotNull String newbornFirstName);
	/**
	 * Return an entity or a list of entities that have the given attribute Newborn Last Name.
	 *
	 * @param newbornLastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn Last Name
	 */
	List<NewbornDetailEntity> findByNewbornLastName(@NotNull String newbornLastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Date Time Of Birth.
	 *
	 * @param dateTimeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Time Of Birth
	 */
	List<NewbornDetailEntity> findByDateTimeOfBirth(@NotNull OffsetDateTime dateTimeOfBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	List<NewbornDetailEntity> findByGender(@NotNull String gender);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	List<NewbornDetailEntity> findByDeliveryType(@NotNull String deliveryType);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type Indication.
	 *
	 * @param deliveryTypeIndication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type Indication
	 */
	List<NewbornDetailEntity> findByDeliveryTypeIndication(@NotNull String deliveryTypeIndication);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<NewbornDetailEntity> findByWeight(@NotNull Integer weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Length.
	 *
	 * @param length the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length
	 */
	List<NewbornDetailEntity> findByLength(@NotNull Integer length);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Of Gestational Age.
	 *
	 * @param weightOfGestationalAge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Of Gestational Age
	 */
	List<NewbornDetailEntity> findByWeightOfGestationalAge(@NotNull String weightOfGestationalAge);
	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference.
	 *
	 * @param headCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference
	 */
	List<NewbornDetailEntity> findByHeadCircumference(@NotNull Integer headCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference.
	 *
	 * @param chestCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference
	 */
	List<NewbornDetailEntity> findByChestCircumference(@NotNull Integer chestCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Birth Condition.
	 *
	 * @param birthCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Birth Condition
	 */
	List<NewbornDetailEntity> findByBirthCondition(@NotNull String birthCondition);
	/**
	 * Return an entity or a list of entities that have the given attribute Neonatal Case.
	 *
	 * @param neonatalCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Neonatal Case
	 */
	List<NewbornDetailEntity> findByNeonatalCase(@NotNull String neonatalCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Congenital Condition.
	 *
	 * @param congenitalCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Congenital Condition
	 */
	List<NewbornDetailEntity> findByCongenitalCondition(@NotNull String congenitalCondition);
	/**
	 * Return an entity or a list of entities that have the given attribute Physical Examination.
	 *
	 * @param physicalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Examination
	 */
	List<NewbornDetailEntity> findByPhysicalExamination(@NotNull String physicalExamination);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Appearance.
	 *
	 * @param apgar1MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Appearance
	 */
	List<NewbornDetailEntity> findByApgar1MinuteAppearance(@NotNull String apgar1MinuteAppearance);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Appearance.
	 *
	 * @param apgar5MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Appearance
	 */
	List<NewbornDetailEntity> findByApgar5MinuteAppearance(@NotNull String apgar5MinuteAppearance);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Appearance.
	 *
	 * @param apgar10MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Appearance
	 */
	List<NewbornDetailEntity> findByApgar10MinuteAppearance(@NotNull String apgar10MinuteAppearance);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Pulse.
	 *
	 * @param apgar1MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Pulse
	 */
	List<NewbornDetailEntity> findByApgar1MinutePulse(@NotNull String apgar1MinutePulse);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Pulse.
	 *
	 * @param apgar5MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Pulse
	 */
	List<NewbornDetailEntity> findByApgar5MinutePulse(@NotNull String apgar5MinutePulse);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Pulse.
	 *
	 * @param apgar10MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Pulse
	 */
	List<NewbornDetailEntity> findByApgar10MinutePulse(@NotNull String apgar10MinutePulse);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Grimace.
	 *
	 * @param apgar1MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Grimace
	 */
	List<NewbornDetailEntity> findByApgar1MinuteGrimace(@NotNull String apgar1MinuteGrimace);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Grimace.
	 *
	 * @param apgar5MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Grimace
	 */
	List<NewbornDetailEntity> findByApgar5MinuteGrimace(@NotNull String apgar5MinuteGrimace);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Grimace.
	 *
	 * @param apgar10MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Grimace
	 */
	List<NewbornDetailEntity> findByApgar10MinuteGrimace(@NotNull String apgar10MinuteGrimace);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Activity.
	 *
	 * @param apgar1MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Activity
	 */
	List<NewbornDetailEntity> findByApgar1MinuteActivity(@NotNull String apgar1MinuteActivity);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Activity.
	 *
	 * @param apgar5MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Activity
	 */
	List<NewbornDetailEntity> findByApgar5MinuteActivity(@NotNull String apgar5MinuteActivity);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Activity.
	 *
	 * @param apgar10MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Activity
	 */
	List<NewbornDetailEntity> findByApgar10MinuteActivity(@NotNull String apgar10MinuteActivity);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Respiration.
	 *
	 * @param apgar1MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Respiration
	 */
	List<NewbornDetailEntity> findByApgar1MinuteRespiration(@NotNull String apgar1MinuteRespiration);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Respiration.
	 *
	 * @param apgar5MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Respiration
	 */
	List<NewbornDetailEntity> findByApgar5MinuteRespiration(@NotNull String apgar5MinuteRespiration);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Respiration.
	 *
	 * @param apgar10MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Respiration
	 */
	List<NewbornDetailEntity> findByApgar10MinuteRespiration(@NotNull String apgar10MinuteRespiration);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Score.
	 *
	 * @param apgar1MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Score
	 */
	List<NewbornDetailEntity> findByApgar1MinuteScore(@NotNull String apgar1MinuteScore);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Score.
	 *
	 * @param apgar5MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Score
	 */
	List<NewbornDetailEntity> findByApgar5MinuteScore(@NotNull String apgar5MinuteScore);
	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Score.
	 *
	 * @param apgar10MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Score
	 */
	List<NewbornDetailEntity> findByApgar10MinuteScore(@NotNull String apgar10MinuteScore);
	/**
	 * Return an entity or a list of entities that have the given attribute Pediatric Nurse.
	 *
	 * @param pediatricNurse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pediatric Nurse
	 */
	List<NewbornDetailEntity> findByPediatricNurse(@NotNull String pediatricNurse);
	/**
	 * Return an entity or a list of entities that have the given attribute Patient Id.
	 *
	 * @param patientId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Id
	 */
	List<NewbornDetailEntity> findByPatientId(@NotNull String patientId);
	/**
	 * Return an entity or a list of entities that have the given attribute Registration Id.
	 *
	 * @param registrationId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Id
	 */
	List<NewbornDetailEntity> findByRegistrationId(@NotNull String registrationId);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NewbornDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<NewbornDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}