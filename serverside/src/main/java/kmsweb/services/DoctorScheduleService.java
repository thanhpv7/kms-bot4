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
import kmsweb.repositories.DoctorScheduleRepository;
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
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class DoctorScheduleService extends AbstractService<DoctorScheduleEntity, DoctorScheduleRepository, DoctorScheduleEntityAudit> {

	private final String[] referenceNamesInDoctorScheduleEntity = {
		"service",
		"staff",
	};

	private final ServiceRepository serviceRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DoctorScheduleService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		ServiceRepository serviceRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		DoctorScheduleRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.serviceRepository = serviceRepository;

		this.staffRepository = staffRepository;

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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByStartDateTime(OffsetDateTime startDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByStartDateTime(startDateTime));

		// % protected region % [Add any additional logic for findByStartDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByEndDateTime(OffsetDateTime endDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByEndDateTime(endDateTime));

		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Interval in minutes.
	 *
	 * @param intervalInMinutes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Interval in minutes
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByIntervalInMinutes(Integer intervalInMinutes)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntervalInMinutes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntervalInMinutes here] end
	{
		// % protected region % [Add any additional logic for findByIntervalInMinutes before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntervalInMinutes before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByIntervalInMinutes(intervalInMinutes));

		// % protected region % [Add any additional logic for findByIntervalInMinutes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntervalInMinutes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Location.
	 *
	 * @param location the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Location
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByLocation(String location)
	// % protected region % [Add any throwables, implementations, or extensions for findByLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLocation here] end
	{
		// % protected region % [Add any additional logic for findByLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByLocation before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByLocation(location));

		// % protected region % [Add any additional logic for findByLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Scheduler Type.
	 *
	 * @param schedulerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Scheduler Type
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findBySchedulerType(String schedulerType)
	// % protected region % [Add any throwables, implementations, or extensions for findBySchedulerType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySchedulerType here] end
	{
		// % protected region % [Add any additional logic for findBySchedulerType before the main body here] off begin
		// % protected region % [Add any additional logic for findBySchedulerType before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findBySchedulerType(schedulerType));

		// % protected region % [Add any additional logic for findBySchedulerType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySchedulerType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Monday.
	 *
	 * @param monday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Monday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByMonday(Boolean monday)
	// % protected region % [Add any throwables, implementations, or extensions for findByMonday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMonday here] end
	{
		// % protected region % [Add any additional logic for findByMonday before the main body here] off begin
		// % protected region % [Add any additional logic for findByMonday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByMonday(monday));

		// % protected region % [Add any additional logic for findByMonday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMonday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tuesday.
	 *
	 * @param tuesday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tuesday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByTuesday(Boolean tuesday)
	// % protected region % [Add any throwables, implementations, or extensions for findByTuesday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTuesday here] end
	{
		// % protected region % [Add any additional logic for findByTuesday before the main body here] off begin
		// % protected region % [Add any additional logic for findByTuesday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByTuesday(tuesday));

		// % protected region % [Add any additional logic for findByTuesday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTuesday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Wednesday.
	 *
	 * @param wednesday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Wednesday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByWednesday(Boolean wednesday)
	// % protected region % [Add any throwables, implementations, or extensions for findByWednesday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWednesday here] end
	{
		// % protected region % [Add any additional logic for findByWednesday before the main body here] off begin
		// % protected region % [Add any additional logic for findByWednesday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByWednesday(wednesday));

		// % protected region % [Add any additional logic for findByWednesday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWednesday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Thursday.
	 *
	 * @param thursday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Thursday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByThursday(Boolean thursday)
	// % protected region % [Add any throwables, implementations, or extensions for findByThursday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByThursday here] end
	{
		// % protected region % [Add any additional logic for findByThursday before the main body here] off begin
		// % protected region % [Add any additional logic for findByThursday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByThursday(thursday));

		// % protected region % [Add any additional logic for findByThursday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByThursday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Friday.
	 *
	 * @param friday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Friday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByFriday(Boolean friday)
	// % protected region % [Add any throwables, implementations, or extensions for findByFriday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFriday here] end
	{
		// % protected region % [Add any additional logic for findByFriday before the main body here] off begin
		// % protected region % [Add any additional logic for findByFriday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByFriday(friday));

		// % protected region % [Add any additional logic for findByFriday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFriday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Saturday.
	 *
	 * @param saturday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Saturday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findBySaturday(Boolean saturday)
	// % protected region % [Add any throwables, implementations, or extensions for findBySaturday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySaturday here] end
	{
		// % protected region % [Add any additional logic for findBySaturday before the main body here] off begin
		// % protected region % [Add any additional logic for findBySaturday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findBySaturday(saturday));

		// % protected region % [Add any additional logic for findBySaturday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySaturday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sunday.
	 *
	 * @param sunday the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sunday
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findBySunday(Boolean sunday)
	// % protected region % [Add any throwables, implementations, or extensions for findBySunday here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySunday here] end
	{
		// % protected region % [Add any additional logic for findBySunday before the main body here] off begin
		// % protected region % [Add any additional logic for findBySunday before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findBySunday(sunday));

		// % protected region % [Add any additional logic for findBySunday before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySunday before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Training.
	 *
	 * @param training the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Training
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByTraining(String training)
	// % protected region % [Add any throwables, implementations, or extensions for findByTraining here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTraining here] end
	{
		// % protected region % [Add any additional logic for findByTraining before the main body here] off begin
		// % protected region % [Add any additional logic for findByTraining before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByTraining(training));

		// % protected region % [Add any additional logic for findByTraining before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTraining before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByDismissalDate(OffsetDateTime dismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByDismissalDate(dismissalDate));

		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shift.
	 *
	 * @param shift the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shift
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByShift(String shift)
	// % protected region % [Add any throwables, implementations, or extensions for findByShift here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShift here] end
	{
		// % protected region % [Add any additional logic for findByShift before the main body here] off begin
		// % protected region % [Add any additional logic for findByShift before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByShift(shift));

		// % protected region % [Add any additional logic for findByShift before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShift before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intervals.
	 *
	 * @param intervals the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intervals
	 */
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findByIntervals(Integer intervals)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntervals here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntervals here] end
	{
		// % protected region % [Add any additional logic for findByIntervals before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntervals before the main body here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findByIntervals(intervals));

		// % protected region % [Add any additional logic for findByIntervals before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntervals before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<DoctorScheduleEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<DoctorScheduleEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<DoctorScheduleEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<DoctorScheduleEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'create')")
	public DoctorScheduleEntity create(DoctorScheduleEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		DoctorScheduleEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'create')")
	public DoctorScheduleEntity create(DoctorScheduleEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		DoctorScheduleEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		DoctorScheduleEntity newEntity;

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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'create')")
	public List<DoctorScheduleEntity> createAll(Iterable<DoctorScheduleEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<DoctorScheduleEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<DoctorScheduleEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'update')")
	public DoctorScheduleEntity update(DoctorScheduleEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		DoctorScheduleEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'update')")
	public DoctorScheduleEntity update(DoctorScheduleEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		DoctorScheduleEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		DoctorScheduleEntity newEntity;

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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'update')")
	public List<DoctorScheduleEntity> updateAll(Iterable<DoctorScheduleEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<DoctorScheduleEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<DoctorScheduleEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'create') or hasPermission('DoctorScheduleEntity', 'update')")
	public DoctorScheduleEntity save(DoctorScheduleEntity entity) throws ConstraintViolationException
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

		DoctorScheduleEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'create') or hasPermission('DoctorScheduleEntity', 'update')")
	public List<DoctorScheduleEntity> saveAll(Iterable<DoctorScheduleEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<DoctorScheduleEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	public List<DoctorScheduleEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	public List<DoctorScheduleEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(DoctorScheduleEntity.class);

		// % protected region % [Add any additional processing before converting to a list of DoctorScheduleEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of DoctorScheduleEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DoctorScheduleEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of DoctorScheduleEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of DoctorScheduleEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(DoctorScheduleEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of DoctorScheduleEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of DoctorScheduleEntityAudits
	 */
	private List<DoctorScheduleEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<DoctorScheduleEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param doctorSchedule doctorSchedule to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private DoctorScheduleEntity updateAuditData(DoctorScheduleEntity doctorSchedule)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return doctorSchedule;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private DoctorScheduleEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		DoctorScheduleEntity entityAtRevision = updateAuditData((DoctorScheduleEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new DoctorScheduleEntityAudit(
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

		QDoctorScheduleEntity entity = QDoctorScheduleEntity.doctorScheduleEntity;

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
			case "serviceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Doctor Schedules here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.service.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Doctor Schedules here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Doctor Schedules here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Doctor Schedules here] end

				break;
			case "shift":
				// % protected region % [Add any additional logic before the query parameters of shift here] off begin
				// % protected region % [Add any additional logic before the query parameters of shift here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.shift, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of shift here] off begin
				// % protected region % [Add any additional logic after the query parameters of shift here] end

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
	public DoctorScheduleEntity updateOldData(DoctorScheduleEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public DoctorScheduleEntity updateOldData(DoctorScheduleEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		DoctorScheduleEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInDoctorScheduleEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getMonday() == null) {
			entityToUpdate.setMonday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTuesday() == null) {
			entityToUpdate.setTuesday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getWednesday() == null) {
			entityToUpdate.setWednesday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getThursday() == null) {
			entityToUpdate.setThursday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getFriday() == null) {
			entityToUpdate.setFriday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSaturday() == null) {
			entityToUpdate.setSaturday(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSunday() == null) {
			entityToUpdate.setSunday(false);
		}

		// Incoming One to Many reference
		if (entity.getService() == null && entity.getServiceId() == null) {
			entityToUpdate.unsetService();
		} else if (entity.getServiceId() != null && entity.getService() == null) {
			Optional<ServiceEntity> serviceEntity = this.serviceRepository.findById(entity.getServiceId());
			entityToUpdate.setService(serviceEntity.orElseThrow());
		}
		if (persistRelations && entity.getService() != null) {
			entityToUpdate.setService(entity.getService(), false);
			if (entityToUpdate.getServiceId() != null) {
				this.serviceRepository.save(entityToUpdate.getService());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getService().unsetDoctorSchedules();
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
				entityToUpdate.getStaff().unsetDoctorSchedules();
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
	public void validateEntity(DoctorScheduleEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<DoctorScheduleEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the DoctorScheduleEntity.
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

	public Set<String> validateEntityRelations(DoctorScheduleEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getServiceId() != null && this.serviceRepository.findById(entity.getServiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getServiceId() + " is not associated with a Service Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
