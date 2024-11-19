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
import kmsweb.repositories.NewbornDetailRepository;
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
import java.time.*;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.entities.VitalSignsEntity;
import kmsweb.repositories.VitalSignsRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class NewbornDetailService extends AbstractService<NewbornDetailEntity, NewbornDetailRepository, NewbornDetailEntityAudit> {

	private final String[] referenceNamesInNewbornDetailEntity = {
		"vitalSigns",
		"deliveryMedicalExaminationRecord",
		"staff",
	};

	private final DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	private final StaffRepository staffRepository;

	private final VitalSignsRepository vitalSignsRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public NewbornDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository,
		StaffRepository staffRepository,
		VitalSignsRepository vitalSignsRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		NewbornDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.deliveryMedicalExaminationRecordRepository = deliveryMedicalExaminationRecordRepository;

		this.staffRepository = staffRepository;

		this.vitalSignsRepository = vitalSignsRepository;

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Newborn First Name.
	 *
	 * @param newbornFirstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn First Name
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByNewbornFirstName(String newbornFirstName)
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornFirstName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornFirstName here] end
	{
		// % protected region % [Add any additional logic for findByNewbornFirstName before the main body here] off begin
		// % protected region % [Add any additional logic for findByNewbornFirstName before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByNewbornFirstName(newbornFirstName));

		// % protected region % [Add any additional logic for findByNewbornFirstName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNewbornFirstName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Newborn Last Name.
	 *
	 * @param newbornLastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn Last Name
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByNewbornLastName(String newbornLastName)
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornLastName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornLastName here] end
	{
		// % protected region % [Add any additional logic for findByNewbornLastName before the main body here] off begin
		// % protected region % [Add any additional logic for findByNewbornLastName before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByNewbornLastName(newbornLastName));

		// % protected region % [Add any additional logic for findByNewbornLastName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNewbornLastName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date Time Of Birth.
	 *
	 * @param dateTimeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Time Of Birth
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByDateTimeOfBirth(OffsetDateTime dateTimeOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateTimeOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateTimeOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateTimeOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateTimeOfBirth before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByDateTimeOfBirth(dateTimeOfBirth));

		// % protected region % [Add any additional logic for findByDateTimeOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateTimeOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByDeliveryType(String deliveryType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByDeliveryType(deliveryType));

		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type Indication.
	 *
	 * @param deliveryTypeIndication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type Indication
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByDeliveryTypeIndication(String deliveryTypeIndication)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryTypeIndication here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryTypeIndication here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryTypeIndication before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryTypeIndication before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByDeliveryTypeIndication(deliveryTypeIndication));

		// % protected region % [Add any additional logic for findByDeliveryTypeIndication before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryTypeIndication before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByWeight(Integer weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Length.
	 *
	 * @param length the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Length
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByLength(Integer length)
	// % protected region % [Add any throwables, implementations, or extensions for findByLength here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLength here] end
	{
		// % protected region % [Add any additional logic for findByLength before the main body here] off begin
		// % protected region % [Add any additional logic for findByLength before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByLength(length));

		// % protected region % [Add any additional logic for findByLength before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLength before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Of Gestational Age.
	 *
	 * @param weightOfGestationalAge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Of Gestational Age
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByWeightOfGestationalAge(String weightOfGestationalAge)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightOfGestationalAge here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightOfGestationalAge here] end
	{
		// % protected region % [Add any additional logic for findByWeightOfGestationalAge before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightOfGestationalAge before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByWeightOfGestationalAge(weightOfGestationalAge));

		// % protected region % [Add any additional logic for findByWeightOfGestationalAge before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightOfGestationalAge before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Head Circumference.
	 *
	 * @param headCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Head Circumference
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByHeadCircumference(Integer headCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeadCircumference here] end
	{
		// % protected region % [Add any additional logic for findByHeadCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumference before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByHeadCircumference(headCircumference));

		// % protected region % [Add any additional logic for findByHeadCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeadCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chest Circumference.
	 *
	 * @param chestCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chest Circumference
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByChestCircumference(Integer chestCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChestCircumference here] end
	{
		// % protected region % [Add any additional logic for findByChestCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByChestCircumference before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByChestCircumference(chestCircumference));

		// % protected region % [Add any additional logic for findByChestCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChestCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Birth Condition.
	 *
	 * @param birthCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Birth Condition
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByBirthCondition(String birthCondition)
	// % protected region % [Add any throwables, implementations, or extensions for findByBirthCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBirthCondition here] end
	{
		// % protected region % [Add any additional logic for findByBirthCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByBirthCondition before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByBirthCondition(birthCondition));

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByNeonatalCase(String neonatalCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] end
	{
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByNeonatalCase(neonatalCase));

		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Congenital Condition.
	 *
	 * @param congenitalCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Congenital Condition
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByCongenitalCondition(String congenitalCondition)
	// % protected region % [Add any throwables, implementations, or extensions for findByCongenitalCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCongenitalCondition here] end
	{
		// % protected region % [Add any additional logic for findByCongenitalCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByCongenitalCondition before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByCongenitalCondition(congenitalCondition));

		// % protected region % [Add any additional logic for findByCongenitalCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCongenitalCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Physical Examination.
	 *
	 * @param physicalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physical Examination
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByPhysicalExamination(String physicalExamination)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalExamination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicalExamination here] end
	{
		// % protected region % [Add any additional logic for findByPhysicalExamination before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhysicalExamination before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByPhysicalExamination(physicalExamination));

		// % protected region % [Add any additional logic for findByPhysicalExamination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhysicalExamination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Appearance.
	 *
	 * @param apgar1MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Appearance
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinuteAppearance(String apgar1MinuteAppearance)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteAppearance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteAppearance here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinuteAppearance before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteAppearance before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinuteAppearance(apgar1MinuteAppearance));

		// % protected region % [Add any additional logic for findByApgar1MinuteAppearance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteAppearance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Appearance.
	 *
	 * @param apgar5MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Appearance
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinuteAppearance(String apgar5MinuteAppearance)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteAppearance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteAppearance here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinuteAppearance before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteAppearance before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinuteAppearance(apgar5MinuteAppearance));

		// % protected region % [Add any additional logic for findByApgar5MinuteAppearance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteAppearance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Appearance.
	 *
	 * @param apgar10MinuteAppearance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Appearance
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinuteAppearance(String apgar10MinuteAppearance)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteAppearance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteAppearance here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinuteAppearance before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteAppearance before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinuteAppearance(apgar10MinuteAppearance));

		// % protected region % [Add any additional logic for findByApgar10MinuteAppearance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteAppearance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Pulse.
	 *
	 * @param apgar1MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Pulse
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinutePulse(String apgar1MinutePulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinutePulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinutePulse here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinutePulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinutePulse before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinutePulse(apgar1MinutePulse));

		// % protected region % [Add any additional logic for findByApgar1MinutePulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinutePulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Pulse.
	 *
	 * @param apgar5MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Pulse
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinutePulse(String apgar5MinutePulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinutePulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinutePulse here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinutePulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinutePulse before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinutePulse(apgar5MinutePulse));

		// % protected region % [Add any additional logic for findByApgar5MinutePulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinutePulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Pulse.
	 *
	 * @param apgar10MinutePulse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Pulse
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinutePulse(String apgar10MinutePulse)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinutePulse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinutePulse here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinutePulse before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinutePulse before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinutePulse(apgar10MinutePulse));

		// % protected region % [Add any additional logic for findByApgar10MinutePulse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinutePulse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Grimace.
	 *
	 * @param apgar1MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Grimace
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinuteGrimace(String apgar1MinuteGrimace)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteGrimace here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteGrimace here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinuteGrimace before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteGrimace before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinuteGrimace(apgar1MinuteGrimace));

		// % protected region % [Add any additional logic for findByApgar1MinuteGrimace before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteGrimace before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Grimace.
	 *
	 * @param apgar5MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Grimace
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinuteGrimace(String apgar5MinuteGrimace)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteGrimace here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteGrimace here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinuteGrimace before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteGrimace before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinuteGrimace(apgar5MinuteGrimace));

		// % protected region % [Add any additional logic for findByApgar5MinuteGrimace before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteGrimace before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Grimace.
	 *
	 * @param apgar10MinuteGrimace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Grimace
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinuteGrimace(String apgar10MinuteGrimace)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteGrimace here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteGrimace here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinuteGrimace before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteGrimace before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinuteGrimace(apgar10MinuteGrimace));

		// % protected region % [Add any additional logic for findByApgar10MinuteGrimace before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteGrimace before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Activity.
	 *
	 * @param apgar1MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Activity
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinuteActivity(String apgar1MinuteActivity)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteActivity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteActivity here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinuteActivity before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteActivity before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinuteActivity(apgar1MinuteActivity));

		// % protected region % [Add any additional logic for findByApgar1MinuteActivity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteActivity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Activity.
	 *
	 * @param apgar5MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Activity
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinuteActivity(String apgar5MinuteActivity)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteActivity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteActivity here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinuteActivity before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteActivity before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinuteActivity(apgar5MinuteActivity));

		// % protected region % [Add any additional logic for findByApgar5MinuteActivity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteActivity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Activity.
	 *
	 * @param apgar10MinuteActivity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Activity
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinuteActivity(String apgar10MinuteActivity)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteActivity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteActivity here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinuteActivity before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteActivity before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinuteActivity(apgar10MinuteActivity));

		// % protected region % [Add any additional logic for findByApgar10MinuteActivity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteActivity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Respiration.
	 *
	 * @param apgar1MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Respiration
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinuteRespiration(String apgar1MinuteRespiration)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteRespiration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteRespiration here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinuteRespiration before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteRespiration before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinuteRespiration(apgar1MinuteRespiration));

		// % protected region % [Add any additional logic for findByApgar1MinuteRespiration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteRespiration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Respiration.
	 *
	 * @param apgar5MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Respiration
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinuteRespiration(String apgar5MinuteRespiration)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteRespiration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteRespiration here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinuteRespiration before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteRespiration before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinuteRespiration(apgar5MinuteRespiration));

		// % protected region % [Add any additional logic for findByApgar5MinuteRespiration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteRespiration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Respiration.
	 *
	 * @param apgar10MinuteRespiration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Respiration
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinuteRespiration(String apgar10MinuteRespiration)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteRespiration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteRespiration here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinuteRespiration before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteRespiration before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinuteRespiration(apgar10MinuteRespiration));

		// % protected region % [Add any additional logic for findByApgar10MinuteRespiration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteRespiration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 1 Minute Score.
	 *
	 * @param apgar1MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 1 Minute Score
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar1MinuteScore(String apgar1MinuteScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar1MinuteScore here] end
	{
		// % protected region % [Add any additional logic for findByApgar1MinuteScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteScore before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar1MinuteScore(apgar1MinuteScore));

		// % protected region % [Add any additional logic for findByApgar1MinuteScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar1MinuteScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 5 Minute Score.
	 *
	 * @param apgar5MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 5 Minute Score
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar5MinuteScore(String apgar5MinuteScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar5MinuteScore here] end
	{
		// % protected region % [Add any additional logic for findByApgar5MinuteScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteScore before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar5MinuteScore(apgar5MinuteScore));

		// % protected region % [Add any additional logic for findByApgar5MinuteScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar5MinuteScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute APGAR 10 Minute Score.
	 *
	 * @param apgar10MinuteScore the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute APGAR 10 Minute Score
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByApgar10MinuteScore(String apgar10MinuteScore)
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteScore here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApgar10MinuteScore here] end
	{
		// % protected region % [Add any additional logic for findByApgar10MinuteScore before the main body here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteScore before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByApgar10MinuteScore(apgar10MinuteScore));

		// % protected region % [Add any additional logic for findByApgar10MinuteScore before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApgar10MinuteScore before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pediatric Nurse.
	 *
	 * @param pediatricNurse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pediatric Nurse
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByPediatricNurse(String pediatricNurse)
	// % protected region % [Add any throwables, implementations, or extensions for findByPediatricNurse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPediatricNurse here] end
	{
		// % protected region % [Add any additional logic for findByPediatricNurse before the main body here] off begin
		// % protected region % [Add any additional logic for findByPediatricNurse before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByPediatricNurse(pediatricNurse));

		// % protected region % [Add any additional logic for findByPediatricNurse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPediatricNurse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Id.
	 *
	 * @param patientId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Id
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByPatientId(String patientId)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientId here] end
	{
		// % protected region % [Add any additional logic for findByPatientId before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientId before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByPatientId(patientId));

		// % protected region % [Add any additional logic for findByPatientId before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientId before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Registration Id.
	 *
	 * @param registrationId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Id
	 */
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findByRegistrationId(String registrationId)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationId here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationId before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationId before the main body here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findByRegistrationId(registrationId));

		// % protected region % [Add any additional logic for findByRegistrationId before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationId before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<NewbornDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<NewbornDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<NewbornDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<NewbornDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create')")
	public NewbornDetailEntity create(NewbornDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		NewbornDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create')")
	public NewbornDetailEntity create(NewbornDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		NewbornDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		NewbornDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create')")
	public List<NewbornDetailEntity> createAll(Iterable<NewbornDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<NewbornDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<NewbornDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'update')")
	public NewbornDetailEntity update(NewbornDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		NewbornDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'update')")
	public NewbornDetailEntity update(NewbornDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		NewbornDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		NewbornDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'update')")
	public List<NewbornDetailEntity> updateAll(Iterable<NewbornDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<NewbornDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<NewbornDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create') or hasPermission('NewbornDetailEntity', 'update')")
	public NewbornDetailEntity save(NewbornDetailEntity entity) throws ConstraintViolationException
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

		NewbornDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'create') or hasPermission('NewbornDetailEntity', 'update')")
	public List<NewbornDetailEntity> saveAll(Iterable<NewbornDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<NewbornDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	public List<NewbornDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	public List<NewbornDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(NewbornDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of NewbornDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of NewbornDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NewbornDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of NewbornDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of NewbornDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(NewbornDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of NewbornDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of NewbornDetailEntityAudits
	 */
	private List<NewbornDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<NewbornDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param newbornDetail newbornDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private NewbornDetailEntity updateAuditData(NewbornDetailEntity newbornDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return newbornDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private NewbornDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		NewbornDetailEntity entityAtRevision = updateAuditData((NewbornDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new NewbornDetailEntityAudit(
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

		QNewbornDetailEntity entity = QNewbornDetailEntity.newbornDetailEntity;

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
			case "deliveryMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Pediatrician In Charge here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Pediatrician In Charge here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Pediatrician In Charge here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Pediatrician In Charge here] end

				break;
			case "vitalSignsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Newborn Detail to Vital Signs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Newborn Detail to Vital Signs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vitalSigns.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Newborn Detail to Vital Signs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Newborn Detail to Vital Signs here] end

				break;
			case "newbornFirstName":
				// % protected region % [Add any additional logic before the query parameters of newbornFirstName here] off begin
				// % protected region % [Add any additional logic before the query parameters of newbornFirstName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.newbornFirstName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of newbornFirstName here] off begin
				// % protected region % [Add any additional logic after the query parameters of newbornFirstName here] end

				break;
			case "newbornLastName":
				// % protected region % [Add any additional logic before the query parameters of newbornLastName here] off begin
				// % protected region % [Add any additional logic before the query parameters of newbornLastName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.newbornLastName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of newbornLastName here] off begin
				// % protected region % [Add any additional logic after the query parameters of newbornLastName here] end

				break;
			case "dateTimeOfBirth":
				// % protected region % [Add any additional logic before the query parameters of dateTimeOfBirth here] off begin
				// % protected region % [Add any additional logic before the query parameters of dateTimeOfBirth here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dateTimeOfBirth, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dateTimeOfBirth here] off begin
				// % protected region % [Add any additional logic after the query parameters of dateTimeOfBirth here] end

				break;
			case "gender":
				// % protected region % [Add any additional logic before the query parameters of gender here] off begin
				// % protected region % [Add any additional logic before the query parameters of gender here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.gender, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of gender here] off begin
				// % protected region % [Add any additional logic after the query parameters of gender here] end

				break;
			case "deliveryType":
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryType here] end

				break;
			case "deliveryTypeIndication":
				// % protected region % [Add any additional logic before the query parameters of deliveryTypeIndication here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryTypeIndication here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryTypeIndication, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryTypeIndication here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryTypeIndication here] end

				break;
			case "weight":
				// % protected region % [Add any additional logic before the query parameters of weight here] off begin
				// % protected region % [Add any additional logic before the query parameters of weight here] end


				// % protected region % [Add any additional logic after the query parameters of weight here] off begin
				// % protected region % [Add any additional logic after the query parameters of weight here] end

				break;
			case "length":
				// % protected region % [Add any additional logic before the query parameters of length here] off begin
				// % protected region % [Add any additional logic before the query parameters of length here] end


				// % protected region % [Add any additional logic after the query parameters of length here] off begin
				// % protected region % [Add any additional logic after the query parameters of length here] end

				break;
			case "weightOfGestationalAge":
				// % protected region % [Add any additional logic before the query parameters of weightOfGestationalAge here] off begin
				// % protected region % [Add any additional logic before the query parameters of weightOfGestationalAge here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.weightOfGestationalAge, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of weightOfGestationalAge here] off begin
				// % protected region % [Add any additional logic after the query parameters of weightOfGestationalAge here] end

				break;
			case "headCircumference":
				// % protected region % [Add any additional logic before the query parameters of headCircumference here] off begin
				// % protected region % [Add any additional logic before the query parameters of headCircumference here] end


				// % protected region % [Add any additional logic after the query parameters of headCircumference here] off begin
				// % protected region % [Add any additional logic after the query parameters of headCircumference here] end

				break;
			case "chestCircumference":
				// % protected region % [Add any additional logic before the query parameters of chestCircumference here] off begin
				// % protected region % [Add any additional logic before the query parameters of chestCircumference here] end


				// % protected region % [Add any additional logic after the query parameters of chestCircumference here] off begin
				// % protected region % [Add any additional logic after the query parameters of chestCircumference here] end

				break;
			case "birthCondition":
				// % protected region % [Add any additional logic before the query parameters of birthCondition here] off begin
				// % protected region % [Add any additional logic before the query parameters of birthCondition here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.birthCondition, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of birthCondition here] off begin
				// % protected region % [Add any additional logic after the query parameters of birthCondition here] end

				break;
			case "neonatalCase":
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.neonatalCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] end

				break;
			case "congenitalCondition":
				// % protected region % [Add any additional logic before the query parameters of congenitalCondition here] off begin
				// % protected region % [Add any additional logic before the query parameters of congenitalCondition here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.congenitalCondition, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of congenitalCondition here] off begin
				// % protected region % [Add any additional logic after the query parameters of congenitalCondition here] end

				break;
			case "physicalExamination":
				// % protected region % [Add any additional logic before the query parameters of physicalExamination here] off begin
				// % protected region % [Add any additional logic before the query parameters of physicalExamination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.physicalExamination, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of physicalExamination here] off begin
				// % protected region % [Add any additional logic after the query parameters of physicalExamination here] end

				break;
			case "apgar1MinuteAppearance":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteAppearance here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteAppearance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinuteAppearance, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteAppearance here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteAppearance here] end

				break;
			case "apgar5MinuteAppearance":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteAppearance here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteAppearance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinuteAppearance, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteAppearance here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteAppearance here] end

				break;
			case "apgar10MinuteAppearance":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteAppearance here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteAppearance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinuteAppearance, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteAppearance here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteAppearance here] end

				break;
			case "apgar1MinutePulse":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinutePulse here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinutePulse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinutePulse, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinutePulse here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinutePulse here] end

				break;
			case "apgar5MinutePulse":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinutePulse here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinutePulse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinutePulse, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinutePulse here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinutePulse here] end

				break;
			case "apgar10MinutePulse":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinutePulse here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinutePulse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinutePulse, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinutePulse here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinutePulse here] end

				break;
			case "apgar1MinuteGrimace":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteGrimace here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteGrimace here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinuteGrimace, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteGrimace here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteGrimace here] end

				break;
			case "apgar5MinuteGrimace":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteGrimace here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteGrimace here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinuteGrimace, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteGrimace here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteGrimace here] end

				break;
			case "apgar10MinuteGrimace":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteGrimace here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteGrimace here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinuteGrimace, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteGrimace here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteGrimace here] end

				break;
			case "apgar1MinuteActivity":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteActivity here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteActivity here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinuteActivity, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteActivity here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteActivity here] end

				break;
			case "apgar5MinuteActivity":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteActivity here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteActivity here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinuteActivity, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteActivity here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteActivity here] end

				break;
			case "apgar10MinuteActivity":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteActivity here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteActivity here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinuteActivity, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteActivity here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteActivity here] end

				break;
			case "apgar1MinuteRespiration":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteRespiration here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteRespiration here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinuteRespiration, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteRespiration here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteRespiration here] end

				break;
			case "apgar5MinuteRespiration":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteRespiration here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteRespiration here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinuteRespiration, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteRespiration here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteRespiration here] end

				break;
			case "apgar10MinuteRespiration":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteRespiration here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteRespiration here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinuteRespiration, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteRespiration here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteRespiration here] end

				break;
			case "apgar1MinuteScore":
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteScore here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar1MinuteScore here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar1MinuteScore, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteScore here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar1MinuteScore here] end

				break;
			case "apgar5MinuteScore":
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteScore here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar5MinuteScore here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar5MinuteScore, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteScore here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar5MinuteScore here] end

				break;
			case "apgar10MinuteScore":
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteScore here] off begin
				// % protected region % [Add any additional logic before the query parameters of apgar10MinuteScore here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.apgar10MinuteScore, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteScore here] off begin
				// % protected region % [Add any additional logic after the query parameters of apgar10MinuteScore here] end

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
	public NewbornDetailEntity updateOldData(NewbornDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public NewbornDetailEntity updateOldData(NewbornDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		NewbornDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInNewbornDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getDeliveryMedicalExaminationRecord() == null && entity.getDeliveryMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetDeliveryMedicalExaminationRecord();
		} else if (entity.getDeliveryMedicalExaminationRecordId() != null && entity.getDeliveryMedicalExaminationRecord() == null) {
			Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordEntity = this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId());
			entityToUpdate.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getDeliveryMedicalExaminationRecord() != null) {
			entityToUpdate.setDeliveryMedicalExaminationRecord(entity.getDeliveryMedicalExaminationRecord(), false);
			if (entityToUpdate.getDeliveryMedicalExaminationRecordId() != null) {
				this.deliveryMedicalExaminationRecordRepository.save(entityToUpdate.getDeliveryMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDeliveryMedicalExaminationRecord().unsetNewbornDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getStaff() == null && entity.getStaffId() == null) {
			entityToUpdate.unsetStaff();
		} else if (entity.getStaffId() != null && entity.getStaff() == null) {
			Optional<StaffEntity> staffEntity = this.staffRepository.findById(entity.getStaffId());
			entityToUpdate.setStaff(staffEntity.orElseThrow());
		}
		if (persistRelations && entity.getStaff() != null) {
			entityToUpdate.setStaff(entity.getStaff(), false);
			if (entityToUpdate.getStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStaff().unsetPediatricianInCharge();
			}
		}

		// Outgoing one to many reference
		if (entity.getVitalSignsIds().isEmpty() && entity.getVitalSigns().isEmpty()) {
			entityToUpdate.setVitalSigns(new HashSet<>());
		} else if (!entity.getVitalSignsIds().isEmpty() && entity.getVitalSigns().isEmpty()) {
			Iterable<VitalSignsEntity> vitalSignsEntities =
					this.vitalSignsRepository.findAllById(entity.getVitalSignsIds());
			entityToUpdate.setVitalSigns(Sets.newHashSet(vitalSignsEntities));
		}
		if (persistRelations && !entity.getVitalSigns().isEmpty()) {
			Set<VitalSignsEntity> updatedEntities = new HashSet<>();
			entity.getVitalSigns().forEach(model -> {
				if (model.getId() != null) {
					model = this.vitalSignsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setVitalSigns(updatedEntities);
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
	public void validateEntity(NewbornDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<NewbornDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the NewbornDetailEntity.
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

	public Set<String> validateEntityRelations(NewbornDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDeliveryMedicalExaminationRecordId() != null && this.deliveryMedicalExaminationRecordRepository.findById(entity.getDeliveryMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getDeliveryMedicalExaminationRecordId() + " is not associated with a Delivery Medical Examination Record Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getVitalSignsIds()) {
			if (this.vitalSignsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Vital Signs Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
