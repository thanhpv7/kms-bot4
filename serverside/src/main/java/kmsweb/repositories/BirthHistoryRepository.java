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

import kmsweb.entities.BirthHistoryEntity;
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
public interface BirthHistoryRepository extends AbstractRepository<BirthHistoryEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Gestational Age Weeks.
	 *
	 * @param gestationalAgeWeeks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestational Age Weeks
	 */
	List<BirthHistoryEntity> findByGestationalAgeWeeks(@NotNull Integer gestationalAgeWeeks);
	/**
	 * Return an entity or a list of entities that have the given attribute Gestational Age Days.
	 *
	 * @param gestationalAgeDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestational Age Days
	 */
	List<BirthHistoryEntity> findByGestationalAgeDays(@NotNull Integer gestationalAgeDays);
	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	List<BirthHistoryEntity> findByDeliveryType(@NotNull String deliveryType);
	/**
	 * Return an entity or a list of entities that have the given attribute Length.
	 *
	 * @param length the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length
	 */
	List<BirthHistoryEntity> findByLength(@NotNull Double length);
	/**
	 * Return an entity or a list of entities that have the given attribute Length Unit.
	 *
	 * @param lengthUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length Unit
	 */
	List<BirthHistoryEntity> findByLengthUnit(@NotNull String lengthUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<BirthHistoryEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Unit.
	 *
	 * @param weightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Unit
	 */
	List<BirthHistoryEntity> findByWeightUnit(@NotNull String weightUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Birth.
	 *
	 * @param headCircumferenceBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Birth
	 */
	List<BirthHistoryEntity> findByHeadCircumferenceBirth(@NotNull Double headCircumferenceBirth);
	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Birth Unit.
	 *
	 * @param headCircumferenceBirthUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Birth Unit
	 */
	List<BirthHistoryEntity> findByHeadCircumferenceBirthUnit(@NotNull String headCircumferenceBirthUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference.
	 *
	 * @param chestCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference
	 */
	List<BirthHistoryEntity> findByChestCircumference(@NotNull Double chestCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference Unit.
	 *
	 * @param chestCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference Unit
	 */
	List<BirthHistoryEntity> findByChestCircumferenceUnit(@NotNull String chestCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Birth Condition.
	 *
	 * @param birthCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Birth Condition
	 */
	List<BirthHistoryEntity> findByBirthCondition(@NotNull String birthCondition);
	/**
	 * Return an entity or a list of entities that have the given attribute Neonatal Case.
	 *
	 * @param neonatalCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Neonatal Case
	 */
	List<BirthHistoryEntity> findByNeonatalCase(@NotNull String neonatalCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Pediatric Case.
	 *
	 * @param pediatricCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pediatric Case
	 */
	List<BirthHistoryEntity> findByPediatricCase(@NotNull String pediatricCase);
	/**
	 * Return an entity or a list of entities that have the given attribute Food Type.
	 *
	 * @param foodType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Food Type
	 */
	List<BirthHistoryEntity> findByFoodType(@NotNull String foodType);
	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference.
	 *
	 * @param headCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference
	 */
	List<BirthHistoryEntity> findByHeadCircumference(@NotNull Double headCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Unit.
	 *
	 * @param headCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Unit
	 */
	List<BirthHistoryEntity> findByHeadCircumferenceUnit(@NotNull String headCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Upper Arm Circumference.
	 *
	 * @param upperArmCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Arm Circumference
	 */
	List<BirthHistoryEntity> findByUpperArmCircumference(@NotNull Double upperArmCircumference);
	/**
	 * Return an entity or a list of entities that have the given attribute Upper Arm Circumference Unit.
	 *
	 * @param upperArmCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Arm Circumference Unit
	 */
	List<BirthHistoryEntity> findByUpperArmCircumferenceUnit(@NotNull String upperArmCircumferenceUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Action Taken.
	 *
	 * @param actionTaken the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Action Taken
	 */
	List<BirthHistoryEntity> findByActionTaken(@NotNull String actionTaken);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Gestational Age.
	 *
	 * @param weightGestationalAge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Gestational Age
	 */
	List<BirthHistoryEntity> findByWeightGestationalAge(@NotNull String weightGestationalAge);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BirthHistoryEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BirthHistoryEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}