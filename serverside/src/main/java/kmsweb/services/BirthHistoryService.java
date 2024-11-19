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
package kmsweb.services;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.querydsl.QSort;
import kmsweb.entities.*;
import kmsweb.repositories.BirthHistoryRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.graphql.utils.Where;
import kmsweb.graphql.utils.AuditQueryType;
import kmsweb.services.utils.QuerydslUtils;
import kmsweb.configs.security.auditing.CustomRevisionEntity;
import com.google.common.collect.Lists;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import com.google.common.collect.Sets;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BirthHistoryService extends AbstractService<BirthHistoryEntity, BirthHistoryRepository, BirthHistoryEntityAudit> {

	private final String[] referenceNamesInBirthHistoryEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BirthHistoryService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BirthHistoryRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public long count()
	// % protected region % [Add any throwables, implementations, or extensions for count here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count here] end
	{
		// % protected region % [Add any additional logic for count before the main body here] off begin
		// % protected region % [Add any additional logic for count before the main body here] end

		long count = repository.count();

		// % protected region % [Add any additional logic for count before returning the count here] off begin
		// % protected region % [Add any additional logic for count before returning the count here] end

		return count;
	}

	/**
	 * Return the number of records available in the database with filters
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public long count(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] end
	{
		// % protected region % [Add any additional logic for count with query before the main body here] off begin
		// % protected region % [Add any additional logic for count with query before the main body here] end

		long count = (CollectionUtils.isEmpty(conditions) || CollectionUtils.isEmpty(conditions.get(0)))
				? repository.count() : repository.count(this.getQueryConditions(conditions));

		// % protected region % [Add any additional logic for count with query before returning the count here] off begin
		// % protected region % [Add any additional logic for count with query before returning the count here] end

		return count;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gestational Age Weeks.
	 *
	 * @param gestationalAgeWeeks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestational Age Weeks
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByGestationalAgeWeeks(Integer gestationalAgeWeeks)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationalAgeWeeks here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationalAgeWeeks here] end
	{
		// % protected region % [Add any additional logic for findByGestationalAgeWeeks before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationalAgeWeeks before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByGestationalAgeWeeks(gestationalAgeWeeks));

		// % protected region % [Add any additional logic for findByGestationalAgeWeeks before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGestationalAgeWeeks before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gestational Age Days.
	 *
	 * @param gestationalAgeDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestational Age Days
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByGestationalAgeDays(Integer gestationalAgeDays)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationalAgeDays here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationalAgeDays here] end
	{
		// % protected region % [Add any additional logic for findByGestationalAgeDays before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationalAgeDays before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByGestationalAgeDays(gestationalAgeDays));

		// % protected region % [Add any additional logic for findByGestationalAgeDays before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGestationalAgeDays before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByDeliveryType(String deliveryType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByDeliveryType(deliveryType));

		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Length.
	 *
	 * @param length the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByLength(Double length)
	// % protected region % [Add any throwables, implementations, or extensions for findByLength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLength here] end
	{
		// % protected region % [Add any additional logic for findByLength before the main body here] off begin
		// % protected region % [Add any additional logic for findByLength before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByLength(length));

		// % protected region % [Add any additional logic for findByLength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Length Unit.
	 *
	 * @param lengthUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByLengthUnit(String lengthUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByLengthUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLengthUnit here] end
	{
		// % protected region % [Add any additional logic for findByLengthUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByLengthUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByLengthUnit(lengthUnit));

		// % protected region % [Add any additional logic for findByLengthUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLengthUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Unit.
	 *
	 * @param weightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByWeightUnit(String weightUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUnit here] end
	{
		// % protected region % [Add any additional logic for findByWeightUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByWeightUnit(weightUnit));

		// % protected region % [Add any additional logic for findByWeightUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Birth.
	 *
	 * @param headCircumferenceBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Birth
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByHeadCircumferenceBirth(Double headCircumferenceBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceBirth here] end
	{
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirth before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByHeadCircumferenceBirth(headCircumferenceBirth));

		// % protected region % [Add any additional logic for findByHeadCircumferenceBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Birth Unit.
	 *
	 * @param headCircumferenceBirthUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Birth Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByHeadCircumferenceBirthUnit(String headCircumferenceBirthUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceBirthUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceBirthUnit here] end
	{
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirthUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirthUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByHeadCircumferenceBirthUnit(headCircumferenceBirthUnit));

		// % protected region % [Add any additional logic for findByHeadCircumferenceBirthUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceBirthUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference.
	 *
	 * @param chestCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByChestCircumference(Double chestCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumference here] end
	{
		// % protected region % [Add any additional logic for findByChestCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByChestCircumference before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByChestCircumference(chestCircumference));

		// % protected region % [Add any additional logic for findByChestCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChestCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference Unit.
	 *
	 * @param chestCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByChestCircumferenceUnit(String chestCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByChestCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByChestCircumferenceUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByChestCircumferenceUnit(chestCircumferenceUnit));

		// % protected region % [Add any additional logic for findByChestCircumferenceUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChestCircumferenceUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Birth Condition.
	 *
	 * @param birthCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Birth Condition
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByBirthCondition(String birthCondition)
	// % protected region % [Add any throwables, implementations, or extensions for findByBirthCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBirthCondition here] end
	{
		// % protected region % [Add any additional logic for findByBirthCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByBirthCondition before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByBirthCondition(birthCondition));

		// % protected region % [Add any additional logic for findByBirthCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBirthCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Neonatal Case.
	 *
	 * @param neonatalCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Neonatal Case
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByNeonatalCase(String neonatalCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] end
	{
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByNeonatalCase(neonatalCase));

		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pediatric Case.
	 *
	 * @param pediatricCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pediatric Case
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByPediatricCase(String pediatricCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByPediatricCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPediatricCase here] end
	{
		// % protected region % [Add any additional logic for findByPediatricCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByPediatricCase before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByPediatricCase(pediatricCase));

		// % protected region % [Add any additional logic for findByPediatricCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPediatricCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Food Type.
	 *
	 * @param foodType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Food Type
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByFoodType(String foodType)
	// % protected region % [Add any throwables, implementations, or extensions for findByFoodType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFoodType here] end
	{
		// % protected region % [Add any additional logic for findByFoodType before the main body here] off begin
		// % protected region % [Add any additional logic for findByFoodType before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByFoodType(foodType));

		// % protected region % [Add any additional logic for findByFoodType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFoodType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference.
	 *
	 * @param headCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByHeadCircumference(Double headCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumference here] end
	{
		// % protected region % [Add any additional logic for findByHeadCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumference before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByHeadCircumference(headCircumference));

		// % protected region % [Add any additional logic for findByHeadCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference Unit.
	 *
	 * @param headCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByHeadCircumferenceUnit(String headCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByHeadCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByHeadCircumferenceUnit(headCircumferenceUnit));

		// % protected region % [Add any additional logic for findByHeadCircumferenceUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumferenceUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Upper Arm Circumference.
	 *
	 * @param upperArmCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Arm Circumference
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByUpperArmCircumference(Double upperArmCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperArmCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperArmCircumference here] end
	{
		// % protected region % [Add any additional logic for findByUpperArmCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpperArmCircumference before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByUpperArmCircumference(upperArmCircumference));

		// % protected region % [Add any additional logic for findByUpperArmCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpperArmCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Upper Arm Circumference Unit.
	 *
	 * @param upperArmCircumferenceUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Arm Circumference Unit
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByUpperArmCircumferenceUnit(String upperArmCircumferenceUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperArmCircumferenceUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperArmCircumferenceUnit here] end
	{
		// % protected region % [Add any additional logic for findByUpperArmCircumferenceUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpperArmCircumferenceUnit before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByUpperArmCircumferenceUnit(upperArmCircumferenceUnit));

		// % protected region % [Add any additional logic for findByUpperArmCircumferenceUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpperArmCircumferenceUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Action Taken.
	 *
	 * @param actionTaken the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Action Taken
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByActionTaken(String actionTaken)
	// % protected region % [Add any throwables, implementations, or extensions for findByActionTaken here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByActionTaken here] end
	{
		// % protected region % [Add any additional logic for findByActionTaken before the main body here] off begin
		// % protected region % [Add any additional logic for findByActionTaken before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByActionTaken(actionTaken));

		// % protected region % [Add any additional logic for findByActionTaken before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByActionTaken before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Gestational Age.
	 *
	 * @param weightGestationalAge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Gestational Age
	 */
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findByWeightGestationalAge(String weightGestationalAge)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightGestationalAge here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightGestationalAge here] end
	{
		// % protected region % [Add any additional logic for findByWeightGestationalAge before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightGestationalAge before the main body here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findByWeightGestationalAge(weightGestationalAge));

		// % protected region % [Add any additional logic for findByWeightGestationalAge before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightGestationalAge before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BirthHistoryEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BirthHistoryEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BirthHistoryEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BirthHistoryEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'create')")
	public BirthHistoryEntity create(BirthHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BirthHistoryEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'create')")
	public BirthHistoryEntity create(BirthHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BirthHistoryEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BirthHistoryEntity newEntity;

		try {
			newEntity = this.save(entityToCreate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for create before returning the entity here] off begin
		// % protected region % [Add any additional logic for create before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'create')")
	public List<BirthHistoryEntity> createAll(Iterable<BirthHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BirthHistoryEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BirthHistoryEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'update')")
	public BirthHistoryEntity update(BirthHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BirthHistoryEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'update')")
	public BirthHistoryEntity update(BirthHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BirthHistoryEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BirthHistoryEntity newEntity;

		try {
			newEntity = this.save(entityToUpdate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for update before returning the entity here] off begin
		// % protected region % [Add any additional logic for update before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'update')")
	public List<BirthHistoryEntity> updateAll(Iterable<BirthHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BirthHistoryEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BirthHistoryEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'create') or hasPermission('BirthHistoryEntity', 'update')")
	public BirthHistoryEntity save(BirthHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for save here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for save here] end
	{
		// % protected region % [Add any additional logic for save before the main logic here] off begin
		// % protected region % [Add any additional logic for save before the main logic here] end

		try {
			validateEntity(entity);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for save before saving the entity here] off begin
		// % protected region % [Add any additional logic for save before saving the entity here] end

		BirthHistoryEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'create') or hasPermission('BirthHistoryEntity', 'update')")
	public List<BirthHistoryEntity> saveAll(Iterable<BirthHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BirthHistoryEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'delete')")
	public void deleteAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] end
	{
		// % protected region % [Add any additional logic for deleteAll before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAll before the main logic here] end

		repository.deleteAllByIdIn(ids);
	}

	/**
	 * Delete all entities that do not have an id in the list of ids provided, if no ids provided, delete all.
	 *
	 * @param ids the IDs of the entities to exclude from deletion
	 */
	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'delete')")
	public void deleteAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] end
	{
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] end

		if (!ids.iterator().hasNext()) {
			repository.deleteAll();
		} else {
			repository.deleteAllByIdNotIn(ids);
		}
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	public List<BirthHistoryEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	public List<BirthHistoryEntity> findAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] end
	{
		if (!ids.iterator().hasNext()) {
			return Lists.newArrayList(repository.findAll());
		} else {
			return Lists.newArrayList(repository.findAllByIdNotIn(ids));
		}
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BirthHistoryEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BirthHistoryEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BirthHistoryEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BirthHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BirthHistoryEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BirthHistoryEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BirthHistoryEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BirthHistoryEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BirthHistoryEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BirthHistoryEntityAudits
	 */
	private List<BirthHistoryEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BirthHistoryEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param birthHistory birthHistory to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BirthHistoryEntity updateAuditData(BirthHistoryEntity birthHistory)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return birthHistory;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BirthHistoryEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BirthHistoryEntity entityAtRevision = updateAuditData((BirthHistoryEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BirthHistoryEntityAudit(
				entityAtRevision,
				revision.getModifiedAt(),
				auditType,

				// We don't care about what the UUID is if it is the system.
				(isSystem) ? UUID.randomUUID() : revision.getAuthor().getId(),

				// % protected region % [Customise our revision author name here] off begin
				(isSystem) ? "System" : revision.getAuthor().getName(),
				""
				// % protected region % [Customise our revision author name here] end
		);
	}

	/**
	 * Create the predicate for the querydsl based on one condition
	 *
	 * @param condition Single condition used in the query
	 * @return querydsl predicate
	 */
	protected Predicate processCondition(Where condition)
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] end
	{
		// % protected region % [Add any additional logic for processCondition before the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition before the main logic here] end

		Predicate predicate = null;

		QBirthHistoryEntity entity = QBirthHistoryEntity.birthHistoryEntity;

		switch (condition.getPath()) {
			case "created":
				// % protected region % [Add any additional logic before the query parameters of created here] off begin
				// % protected region % [Add any additional logic before the query parameters of created here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.created, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of created here] off begin
				// % protected region % [Add any additional logic after the query parameters of created here] end

				break;
			case "createdBy":
				// % protected region % [Add any additional logic before the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of createdBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.createdBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of createdBy here] end

				break;
			case "modified":
				// % protected region % [Add any additional logic before the query parameters of modified here] off begin
				// % protected region % [Add any additional logic before the query parameters of modified here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modified, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of modified here] off begin
				// % protected region % [Add any additional logic after the query parameters of modified here] end

				break;
			case "modifiedBy":
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modifiedBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] end

				break;
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Birth History here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Birth History here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Birth History here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Birth History here] end

				break;
			case "deliveryType":
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryType here] end

				break;
			case "headCircumferenceBirth":
				// % protected region % [Add any additional logic before the query parameters of headCircumferenceBirth here] off begin
				// % protected region % [Add any additional logic before the query parameters of headCircumferenceBirth here] end


				// % protected region % [Add any additional logic after the query parameters of headCircumferenceBirth here] off begin
				// % protected region % [Add any additional logic after the query parameters of headCircumferenceBirth here] end

				break;
			case "headCircumferenceBirthUnit":
				// % protected region % [Add any additional logic before the query parameters of headCircumferenceBirthUnit here] off begin
				// % protected region % [Add any additional logic before the query parameters of headCircumferenceBirthUnit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.headCircumferenceBirthUnit, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of headCircumferenceBirthUnit here] off begin
				// % protected region % [Add any additional logic after the query parameters of headCircumferenceBirthUnit here] end

				break;
			case "neonatalCase":
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.neonatalCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] end

				break;
			// % protected region % [Add any additional cases for the custom query parameters here] off begin
			// % protected region % [Add any additional cases for the custom query parameters here] end
		}

		// % protected region % [Add any additional logic for processCondition after the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition after the main logic here] end

		return predicate;
	}

	/**
	 * Create the predicate for the querydsl based on one single List of Where
	 * The List are connect with 'and' statement
	 *
	 * @param conditions Single list of where statement. The conditions are connected with "or"
	 * @return querydsl predicate
	 */
	protected Predicate processConditionList(List<Where> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] end
	{
		List<Predicate> predicates = conditions.stream()
				.map(this::processCondition)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		return ExpressionUtils.anyOf(predicates);
	}

	/**
	 * Transfer a list of conditions to one querydsl predicate
	 *
	 * @param conditions A list of conditions
	 * @return a single query dsl predicate
	 */
	@Override
	protected Predicate getQueryConditions(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] end
	{
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] end

		List<Predicate> predicates = conditions.stream()
				.map(this::processConditionList)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] end
		return ExpressionUtils.allOf(predicates);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BirthHistoryEntity updateOldData(BirthHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BirthHistoryEntity updateOldData(BirthHistoryEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BirthHistoryEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBirthHistoryEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
		if (entity.getMedicalExaminationRecord() == null && entity.getMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetMedicalExaminationRecord();
		} else if (entity.getMedicalExaminationRecordId() != null && entity.getMedicalExaminationRecord() == null) {
			Optional<MedicalExaminationRecordEntity> medicalExaminationRecordEntity = this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId());
			entityToUpdate.setMedicalExaminationRecord(medicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalExaminationRecord() != null) {
			entityToUpdate.setMedicalExaminationRecord(entity.getMedicalExaminationRecord(), false);
			if (entityToUpdate.getMedicalExaminationRecordId() != null) {
				this.medicalExaminationRecordRepository.save(entityToUpdate.getMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalExaminationRecord().unsetBirthHistory();
			}
		}

		// % protected region % [Add any additional logic for update references after the main logic here] off begin
		// % protected region % [Add any additional logic for update references after the main logic here] end

		return entityToUpdate;
	}

	/**
	 * Validate the entity using database constraint checks as well as input constraint checks.
	 * Has the side effect of round trip requests to the database for constraints such as uniqueness.
	 * @param entity The entity to validate
	 * @throws ConstraintViolationException Throw ConstraintViolationException when entity is invalid
	 */
	public void validateEntity(BirthHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BirthHistoryEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// % protected region % [Add custom validation errors here] off begin
		// % protected region % [Add custom validation errors here] end

		if (!errors.isEmpty()) {
			throw new ConstraintViolationException(errors);
		}

		// % protected region % [Add any additional logic for validate entity after the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity after the main logic here] end
	}


	/**
	 * Get the sort as given by the sort by for the BirthHistoryEntity.
	 * This allows fore more advanced sorting algorithms and methods to be compiled and returned.
	 *
	 * In the case that a custom sort is provided, only a single sort is returned.
	 *
	 * @param sortBy Submitted sort by
	 * @return sortBy if simple, for custom sort return a QSort.by(QSort Method).
	 */
	private Sort getSort (Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] end
	{
		Iterator it = sortBy.iterator();

		while (it.hasNext()) {
			Sort.Order currentOrder = (Sort.Order)it.next();

			// % protected region % [Customise your sort method here by returning early] off begin
			// % protected region % [Customise your sort method here by returning early] end
		}
		return sortBy;
	}

	public Set<String> validateEntityRelations(BirthHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
