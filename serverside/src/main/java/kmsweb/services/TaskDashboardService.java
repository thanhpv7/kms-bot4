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
import kmsweb.repositories.TaskDashboardRepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TaskDashboardService extends AbstractService<TaskDashboardEntity, TaskDashboardRepository, TaskDashboardEntityAudit> {

	private final String[] referenceNamesInTaskDashboardEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TaskDashboardService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		TaskDashboardRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Kdppk.
	 *
	 * @param kdppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kdppk
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByKdppk(String kdppk)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdppk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdppk here] end
	{
		// % protected region % [Add any additional logic for findByKdppk before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdppk before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByKdppk(kdppk));

		// % protected region % [Add any additional logic for findByKdppk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdppk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Jumlah antrean.
	 *
	 * @param jumlahAntrean the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Jumlah antrean
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByJumlahAntrean(Integer jumlahAntrean)
	// % protected region % [Add any throwables, implementations, or extensions for findByJumlahAntrean here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJumlahAntrean here] end
	{
		// % protected region % [Add any additional logic for findByJumlahAntrean before the main body here] off begin
		// % protected region % [Add any additional logic for findByJumlahAntrean before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByJumlahAntrean(jumlahAntrean));

		// % protected region % [Add any additional logic for findByJumlahAntrean before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJumlahAntrean before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Namapoli.
	 *
	 * @param namapoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Namapoli
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByNamapoli(String namapoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamapoli here] end
	{
		// % protected region % [Add any additional logic for findByNamapoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamapoli before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByNamapoli(namapoli));

		// % protected region % [Add any additional logic for findByNamapoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamapoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nmppk.
	 *
	 * @param nmppk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nmppk
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByNmppk(String nmppk)
	// % protected region % [Add any throwables, implementations, or extensions for findByNmppk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNmppk here] end
	{
		// % protected region % [Add any additional logic for findByNmppk before the main body here] off begin
		// % protected region % [Add any additional logic for findByNmppk before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByNmppk(nmppk));

		// % protected region % [Add any additional logic for findByNmppk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNmppk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Kodepoli.
	 *
	 * @param kodepoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kodepoli
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByKodepoli(String kodepoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepoli here] end
	{
		// % protected region % [Add any additional logic for findByKodepoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodepoli before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByKodepoli(kodepoli));

		// % protected region % [Add any additional logic for findByKodepoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodepoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Insert Date.
	 *
	 * @param insertDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Insert Date
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByInsertDate(OffsetDateTime insertDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByInsertDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInsertDate here] end
	{
		// % protected region % [Add any additional logic for findByInsertDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByInsertDate before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByInsertDate(insertDate));

		// % protected region % [Add any additional logic for findByInsertDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInsertDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tanggal.
	 *
	 * @param tanggal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tanggal
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByTanggal(OffsetDateTime tanggal)
	// % protected region % [Add any throwables, implementations, or extensions for findByTanggal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTanggal here] end
	{
		// % protected region % [Add any additional logic for findByTanggal before the main body here] off begin
		// % protected region % [Add any additional logic for findByTanggal before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByTanggal(tanggal));

		// % protected region % [Add any additional logic for findByTanggal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTanggal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task1.
	 *
	 * @param waktuTask1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task1
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask1(Integer waktuTask1)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask1 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask1 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask1(waktuTask1));

		// % protected region % [Add any additional logic for findByWaktuTask1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task2.
	 *
	 * @param waktuTask2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task2
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask2(Integer waktuTask2)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask2 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask2 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask2(waktuTask2));

		// % protected region % [Add any additional logic for findByWaktuTask2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task3.
	 *
	 * @param waktuTask3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task3
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask3(Integer waktuTask3)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask3 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask3 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask3(waktuTask3));

		// % protected region % [Add any additional logic for findByWaktuTask3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task4.
	 *
	 * @param waktuTask4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task4
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask4(Integer waktuTask4)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask4 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask4 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask4 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask4 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask4(waktuTask4));

		// % protected region % [Add any additional logic for findByWaktuTask4 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask4 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task5.
	 *
	 * @param waktuTask5 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task5
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask5(Integer waktuTask5)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask5 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask5 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask5 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask5 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask5(waktuTask5));

		// % protected region % [Add any additional logic for findByWaktuTask5 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask5 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waktu Task6.
	 *
	 * @param waktuTask6 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waktu Task6
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByWaktuTask6(Integer waktuTask6)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask6 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaktuTask6 here] end
	{
		// % protected region % [Add any additional logic for findByWaktuTask6 before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask6 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByWaktuTask6(waktuTask6));

		// % protected region % [Add any additional logic for findByWaktuTask6 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaktuTask6 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task1.
	 *
	 * @param avgWaktuTask1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task1
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask1(Integer avgWaktuTask1)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask1 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask1 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask1(avgWaktuTask1));

		// % protected region % [Add any additional logic for findByAvgWaktuTask1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task2.
	 *
	 * @param avgWaktuTask2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task2
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask2(Integer avgWaktuTask2)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask2 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask2 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask2(avgWaktuTask2));

		// % protected region % [Add any additional logic for findByAvgWaktuTask2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task3.
	 *
	 * @param avgWaktuTask3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task3
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask3(Integer avgWaktuTask3)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask3 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask3 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask3(avgWaktuTask3));

		// % protected region % [Add any additional logic for findByAvgWaktuTask3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task4.
	 *
	 * @param avgWaktuTask4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task4
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask4(Integer avgWaktuTask4)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask4 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask4 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask4 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask4 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask4(avgWaktuTask4));

		// % protected region % [Add any additional logic for findByAvgWaktuTask4 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask4 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task5.
	 *
	 * @param avgWaktuTask5 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task5
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask5(Integer avgWaktuTask5)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask5 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask5 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask5 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask5 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask5(avgWaktuTask5));

		// % protected region % [Add any additional logic for findByAvgWaktuTask5 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask5 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute avg waktu task6.
	 *
	 * @param avgWaktuTask6 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute avg waktu task6
	 */
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findByAvgWaktuTask6(Integer avgWaktuTask6)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask6 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvgWaktuTask6 here] end
	{
		// % protected region % [Add any additional logic for findByAvgWaktuTask6 before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask6 before the main body here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findByAvgWaktuTask6(avgWaktuTask6));

		// % protected region % [Add any additional logic for findByAvgWaktuTask6 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvgWaktuTask6 before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TaskDashboardEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TaskDashboardEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TaskDashboardEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TaskDashboardEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'create')")
	public TaskDashboardEntity create(TaskDashboardEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TaskDashboardEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'create')")
	public TaskDashboardEntity create(TaskDashboardEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TaskDashboardEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TaskDashboardEntity newEntity;

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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'create')")
	public List<TaskDashboardEntity> createAll(Iterable<TaskDashboardEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TaskDashboardEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TaskDashboardEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'update')")
	public TaskDashboardEntity update(TaskDashboardEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TaskDashboardEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'update')")
	public TaskDashboardEntity update(TaskDashboardEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TaskDashboardEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TaskDashboardEntity newEntity;

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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'update')")
	public List<TaskDashboardEntity> updateAll(Iterable<TaskDashboardEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TaskDashboardEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TaskDashboardEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'create') or hasPermission('TaskDashboardEntity', 'update')")
	public TaskDashboardEntity save(TaskDashboardEntity entity) throws ConstraintViolationException
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

		TaskDashboardEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'create') or hasPermission('TaskDashboardEntity', 'update')")
	public List<TaskDashboardEntity> saveAll(Iterable<TaskDashboardEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TaskDashboardEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	public List<TaskDashboardEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	public List<TaskDashboardEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TaskDashboardEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TaskDashboardEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TaskDashboardEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TaskDashboardEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TaskDashboardEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TaskDashboardEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TaskDashboardEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TaskDashboardEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TaskDashboardEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TaskDashboardEntityAudits
	 */
	private List<TaskDashboardEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TaskDashboardEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param taskDashboard taskDashboard to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TaskDashboardEntity updateAuditData(TaskDashboardEntity taskDashboard)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return taskDashboard;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TaskDashboardEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TaskDashboardEntity entityAtRevision = updateAuditData((TaskDashboardEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TaskDashboardEntityAudit(
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

		QTaskDashboardEntity entity = QTaskDashboardEntity.taskDashboardEntity;

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
			case "kdppk":
				// % protected region % [Add any additional logic before the query parameters of kdppk here] off begin
				// % protected region % [Add any additional logic before the query parameters of kdppk here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.kdppk, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of kdppk here] off begin
				// % protected region % [Add any additional logic after the query parameters of kdppk here] end

				break;
			case "jumlahAntrean":
				// % protected region % [Add any additional logic before the query parameters of jumlahAntrean here] off begin
				// % protected region % [Add any additional logic before the query parameters of jumlahAntrean here] end


				// % protected region % [Add any additional logic after the query parameters of jumlahAntrean here] off begin
				// % protected region % [Add any additional logic after the query parameters of jumlahAntrean here] end

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
	public TaskDashboardEntity updateOldData(TaskDashboardEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TaskDashboardEntity updateOldData(TaskDashboardEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TaskDashboardEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTaskDashboardEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
	public void validateEntity(TaskDashboardEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TaskDashboardEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the TaskDashboardEntity.
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

	public Set<String> validateEntityRelations(TaskDashboardEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
