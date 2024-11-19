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
import kmsweb.repositories.IntraoperativeRecordsRepository;
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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class IntraoperativeRecordsService extends AbstractService<IntraoperativeRecordsEntity, IntraoperativeRecordsRepository, IntraoperativeRecordsEntityAudit> {

	private final String[] referenceNamesInIntraoperativeRecordsEntity = {
		"bedFacilities",
		"operatingTheaterMedicalExaminationRecord",
		"operatingRoom",
	};

	private final BedFacilityRepository bedFacilityRepository;

	private final OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	private final RoomFacilityRepository roomFacilityRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public IntraoperativeRecordsService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository,
		RoomFacilityRepository roomFacilityRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		IntraoperativeRecordsRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.operatingTheaterMedicalExaminationRecordRepository = operatingTheaterMedicalExaminationRecordRepository;

		this.roomFacilityRepository = roomFacilityRepository;

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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByStartDateTime(OffsetDateTime startDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByStartDateTime(startDateTime));

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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByEndDateTime(OffsetDateTime endDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByEndDateTime(endDateTime));

		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Start Date Time.
	 *
	 * @param surgeryStartDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Start Date Time
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findBySurgeryStartDateTime(OffsetDateTime surgeryStartDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryStartDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryStartDateTime(surgeryStartDateTime));

		// % protected region % [Add any additional logic for findBySurgeryStartDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryStartDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery End Date Time.
	 *
	 * @param surgeryEndDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery End Date Time
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findBySurgeryEndDateTime(OffsetDateTime surgeryEndDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryEndDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryEndDateTime(surgeryEndDateTime));

		// % protected region % [Add any additional logic for findBySurgeryEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Details.
	 *
	 * @param surgeryDetails the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Details
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findBySurgeryDetails(String surgeryDetails)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryDetails here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryDetails here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryDetails before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryDetails before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findBySurgeryDetails(surgeryDetails));

		// % protected region % [Add any additional logic for findBySurgeryDetails before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryDetails before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Blood Transfusion.
	 *
	 * @param bloodTransfusion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Transfusion
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByBloodTransfusion(String bloodTransfusion)
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodTransfusion here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodTransfusion here] end
	{
		// % protected region % [Add any additional logic for findByBloodTransfusion before the main body here] off begin
		// % protected region % [Add any additional logic for findByBloodTransfusion before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByBloodTransfusion(bloodTransfusion));

		// % protected region % [Add any additional logic for findByBloodTransfusion before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBloodTransfusion before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruments Used.
	 *
	 * @param instrumentsUsed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruments Used
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByInstrumentsUsed(String instrumentsUsed)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstrumentsUsed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstrumentsUsed here] end
	{
		// % protected region % [Add any additional logic for findByInstrumentsUsed before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstrumentsUsed before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByInstrumentsUsed(instrumentsUsed));

		// % protected region % [Add any additional logic for findByInstrumentsUsed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstrumentsUsed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Start Date Time.
	 *
	 * @param anesthesiaStartDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Start Date Time
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaStartDateTime(OffsetDateTime anesthesiaStartDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaStartDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaStartDateTime(anesthesiaStartDateTime));

		// % protected region % [Add any additional logic for findByAnesthesiaStartDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaStartDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Type.
	 *
	 * @param anesthesiaType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Type
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaType(String anesthesiaType)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaType here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaType before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaType before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaType(anesthesiaType));

		// % protected region % [Add any additional logic for findByAnesthesiaType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Method.
	 *
	 * @param anesthesiaMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Method
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaMethod(String anesthesiaMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaMethod here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaMethod before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaMethod(anesthesiaMethod));

		// % protected region % [Add any additional logic for findByAnesthesiaMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Agents.
	 *
	 * @param anesthesiaAgents the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Agents
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaAgents(String anesthesiaAgents)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaAgents here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaAgents here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaAgents before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaAgents before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaAgents(anesthesiaAgents));

		// % protected region % [Add any additional logic for findByAnesthesiaAgents before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaAgents before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Observations.
	 *
	 * @param anesthesiaObservations the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Observations
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaObservations(String anesthesiaObservations)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaObservations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaObservations here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaObservations before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaObservations before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaObservations(anesthesiaObservations));

		// % protected region % [Add any additional logic for findByAnesthesiaObservations before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaObservations before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Notes.
	 *
	 * @param anesthesiaNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Notes
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaNotes(String anesthesiaNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaNotes here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaNotes(anesthesiaNotes));

		// % protected region % [Add any additional logic for findByAnesthesiaNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia End Date Time.
	 *
	 * @param anesthesiaEndDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia End Date Time
	 */
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findByAnesthesiaEndDateTime(OffsetDateTime anesthesiaEndDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaEndDateTime before the main body here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaEndDateTime(anesthesiaEndDateTime));

		// % protected region % [Add any additional logic for findByAnesthesiaEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaEndDateTime before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<IntraoperativeRecordsEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<IntraoperativeRecordsEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<IntraoperativeRecordsEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'create')")
	public IntraoperativeRecordsEntity create(IntraoperativeRecordsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		IntraoperativeRecordsEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'create')")
	public IntraoperativeRecordsEntity create(IntraoperativeRecordsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		IntraoperativeRecordsEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		IntraoperativeRecordsEntity newEntity;

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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'create')")
	public List<IntraoperativeRecordsEntity> createAll(Iterable<IntraoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<IntraoperativeRecordsEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<IntraoperativeRecordsEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'update')")
	public IntraoperativeRecordsEntity update(IntraoperativeRecordsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		IntraoperativeRecordsEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'update')")
	public IntraoperativeRecordsEntity update(IntraoperativeRecordsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		IntraoperativeRecordsEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		IntraoperativeRecordsEntity newEntity;

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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'update')")
	public List<IntraoperativeRecordsEntity> updateAll(Iterable<IntraoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<IntraoperativeRecordsEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<IntraoperativeRecordsEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'create') or hasPermission('IntraoperativeRecordsEntity', 'update')")
	public IntraoperativeRecordsEntity save(IntraoperativeRecordsEntity entity) throws ConstraintViolationException
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

		IntraoperativeRecordsEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'create') or hasPermission('IntraoperativeRecordsEntity', 'update')")
	public List<IntraoperativeRecordsEntity> saveAll(Iterable<IntraoperativeRecordsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<IntraoperativeRecordsEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	public List<IntraoperativeRecordsEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	public List<IntraoperativeRecordsEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(IntraoperativeRecordsEntity.class);

		// % protected region % [Add any additional processing before converting to a list of IntraoperativeRecordsEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of IntraoperativeRecordsEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('IntraoperativeRecordsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<IntraoperativeRecordsEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of IntraoperativeRecordsEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of IntraoperativeRecordsEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(IntraoperativeRecordsEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of IntraoperativeRecordsEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of IntraoperativeRecordsEntityAudits
	 */
	private List<IntraoperativeRecordsEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<IntraoperativeRecordsEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param intraoperativeRecords intraoperativeRecords to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private IntraoperativeRecordsEntity updateAuditData(IntraoperativeRecordsEntity intraoperativeRecords)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return intraoperativeRecords;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private IntraoperativeRecordsEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		IntraoperativeRecordsEntity entityAtRevision = updateAuditData((IntraoperativeRecordsEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new IntraoperativeRecordsEntityAudit(
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

		QIntraoperativeRecordsEntity entity = QIntraoperativeRecordsEntity.intraoperativeRecordsEntity;

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
			case "operatingTheaterMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingTheaterMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Intraoperative Records here] end

				break;
			case "operatingRoomId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Room to Operating Room here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Room to Operating Room here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingRoom.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Room to Operating Room here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Room to Operating Room here] end

				break;
			case "bedFacilitiesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Intraoperative Records to Bed Facilities here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Intraoperative Records to Bed Facilities here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacilities.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Intraoperative Records to Bed Facilities here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Intraoperative Records to Bed Facilities here] end

				break;
			case "surgeryDetails":
				// % protected region % [Add any additional logic before the query parameters of surgeryDetails here] off begin
				// % protected region % [Add any additional logic before the query parameters of surgeryDetails here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgeryDetails, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of surgeryDetails here] off begin
				// % protected region % [Add any additional logic after the query parameters of surgeryDetails here] end

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
	public IntraoperativeRecordsEntity updateOldData(IntraoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public IntraoperativeRecordsEntity updateOldData(IntraoperativeRecordsEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		IntraoperativeRecordsEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInIntraoperativeRecordsEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
		if (entity.getOperatingTheaterMedicalExaminationRecord() == null && entity.getOperatingTheaterMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetOperatingTheaterMedicalExaminationRecord();
		} else if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && entity.getOperatingTheaterMedicalExaminationRecord() == null) {
			Optional<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordEntity = this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId());
			entityToUpdate.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getOperatingTheaterMedicalExaminationRecord() != null) {
			entityToUpdate.setOperatingTheaterMedicalExaminationRecord(entity.getOperatingTheaterMedicalExaminationRecord(), false);
			if (entityToUpdate.getOperatingTheaterMedicalExaminationRecordId() != null) {
				this.operatingTheaterMedicalExaminationRecordRepository.save(entityToUpdate.getOperatingTheaterMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getOperatingTheaterMedicalExaminationRecord().unsetIntraoperativeRecords();
			}
		}

		// Incoming One to Many reference
		if (entity.getOperatingRoom() == null && entity.getOperatingRoomId() == null) {
			entityToUpdate.unsetOperatingRoom();
		} else if (entity.getOperatingRoomId() != null && entity.getOperatingRoom() == null) {
			Optional<RoomFacilityEntity> operatingRoomEntity = this.roomFacilityRepository.findById(entity.getOperatingRoomId());
			entityToUpdate.setOperatingRoom(operatingRoomEntity.orElseThrow());
		}
		if (persistRelations && entity.getOperatingRoom() != null) {
			entityToUpdate.setOperatingRoom(entity.getOperatingRoom(), false);
			if (entityToUpdate.getOperatingRoomId() != null) {
				this.roomFacilityRepository.save(entityToUpdate.getOperatingRoom());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getOperatingRoom().unsetOperatingRoom();
			}
		}

		// Outgoing one to many reference
		if (entity.getBedFacilitiesIds().isEmpty() && entity.getBedFacilities().isEmpty()) {
			entityToUpdate.setBedFacilities(new HashSet<>());
		} else if (!entity.getBedFacilitiesIds().isEmpty() && entity.getBedFacilities().isEmpty()) {
			Iterable<BedFacilityEntity> bedFacilitiesEntities =
					this.bedFacilityRepository.findAllById(entity.getBedFacilitiesIds());
			entityToUpdate.setBedFacilities(Sets.newHashSet(bedFacilitiesEntities));
		}
		if (persistRelations && !entity.getBedFacilities().isEmpty()) {
			Set<BedFacilityEntity> updatedEntities = new HashSet<>();
			entity.getBedFacilities().forEach(model -> {
				if (model.getId() != null) {
					model = this.bedFacilityRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBedFacilities(updatedEntities);
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
	public void validateEntity(IntraoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<IntraoperativeRecordsEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the IntraoperativeRecordsEntity.
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

	public Set<String> validateEntityRelations(IntraoperativeRecordsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getOperatingTheaterMedicalExaminationRecordId() + " is not associated with a Operating Theater Medical Examination Record Entity");
		}

		if (entity.getOperatingRoomId() != null && this.roomFacilityRepository.findById(entity.getOperatingRoomId()).isEmpty()) {
			errors.add("The UUID " + entity.getOperatingRoomId() + " is not associated with a Room Facility Entity");
		}

		for (UUID id : entity.getBedFacilitiesIds()) {
			if (this.bedFacilityRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bed Facility Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
