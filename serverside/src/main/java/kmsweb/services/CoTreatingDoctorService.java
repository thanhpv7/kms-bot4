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
import kmsweb.repositories.CoTreatingDoctorRepository;
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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
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
public class CoTreatingDoctorService extends AbstractService<CoTreatingDoctorEntity, CoTreatingDoctorRepository, CoTreatingDoctorEntityAudit> {

	private final String[] referenceNamesInCoTreatingDoctorEntity = {
		"additionalAnesthesiologist",
		"additionalMidwife",
		"additionalSurgeryNurse",
		"coTreatingAnesthesiologist",
		"medicalExaminationRecord",
		"staff",
		"coTreatingSurgeon",
	};

	private final DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final PreoperativeRecordsRepository preoperativeRecordsRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CoTreatingDoctorService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		PreoperativeRecordsRepository preoperativeRecordsRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		CoTreatingDoctorRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.deliveryMedicalExaminationRecordRepository = deliveryMedicalExaminationRecordRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.preoperativeRecordsRepository = preoperativeRecordsRepository;

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Doctor Notes.
	 *
	 * @param doctorNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Notes
	 */
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntity> findByDoctorNotes(String doctorNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorNotes here] end
	{
		// % protected region % [Add any additional logic for findByDoctorNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorNotes before the main body here] end

		List<CoTreatingDoctorEntity> entities = Lists.newArrayList(repository.findByDoctorNotes(doctorNotes));

		// % protected region % [Add any additional logic for findByDoctorNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<CoTreatingDoctorEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<CoTreatingDoctorEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<CoTreatingDoctorEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<CoTreatingDoctorEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<CoTreatingDoctorEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create')")
	public CoTreatingDoctorEntity create(CoTreatingDoctorEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		CoTreatingDoctorEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create')")
	public CoTreatingDoctorEntity create(CoTreatingDoctorEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		CoTreatingDoctorEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		CoTreatingDoctorEntity newEntity;

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create')")
	public List<CoTreatingDoctorEntity> createAll(Iterable<CoTreatingDoctorEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<CoTreatingDoctorEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<CoTreatingDoctorEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'update')")
	public CoTreatingDoctorEntity update(CoTreatingDoctorEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		CoTreatingDoctorEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'update')")
	public CoTreatingDoctorEntity update(CoTreatingDoctorEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		CoTreatingDoctorEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		CoTreatingDoctorEntity newEntity;

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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'update')")
	public List<CoTreatingDoctorEntity> updateAll(Iterable<CoTreatingDoctorEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<CoTreatingDoctorEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<CoTreatingDoctorEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create') or hasPermission('CoTreatingDoctorEntity', 'update')")
	public CoTreatingDoctorEntity save(CoTreatingDoctorEntity entity) throws ConstraintViolationException
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

		CoTreatingDoctorEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'create') or hasPermission('CoTreatingDoctorEntity', 'update')")
	public List<CoTreatingDoctorEntity> saveAll(Iterable<CoTreatingDoctorEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<CoTreatingDoctorEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public List<CoTreatingDoctorEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public List<CoTreatingDoctorEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(CoTreatingDoctorEntity.class);

		// % protected region % [Add any additional processing before converting to a list of CoTreatingDoctorEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of CoTreatingDoctorEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CoTreatingDoctorEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of CoTreatingDoctorEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of CoTreatingDoctorEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(CoTreatingDoctorEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of CoTreatingDoctorEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of CoTreatingDoctorEntityAudits
	 */
	private List<CoTreatingDoctorEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<CoTreatingDoctorEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param coTreatingDoctor coTreatingDoctor to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private CoTreatingDoctorEntity updateAuditData(CoTreatingDoctorEntity coTreatingDoctor)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return coTreatingDoctor;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private CoTreatingDoctorEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		CoTreatingDoctorEntity entityAtRevision = updateAuditData((CoTreatingDoctorEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new CoTreatingDoctorEntityAudit(
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

		QCoTreatingDoctorEntity entity = QCoTreatingDoctorEntity.coTreatingDoctorEntity;

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
			case "additionalAnesthesiologistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalAnesthesiologist.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Anesthesiologist to Additional Anesthesiologists here] end

				break;
			case "additionalMidwifeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Midwife to Additional Midwives here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Midwife to Additional Midwives here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalMidwife.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Midwife to Additional Midwives here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Midwife to Additional Midwives here] end

				break;
			case "additionalSurgeryNurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalSurgeryNurse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Surgery Nurse to Additional Surgery Nurses here] end

				break;
			case "coTreatingAnesthesiologistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingAnesthesiologist.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Anesthesiologist to Co Treating Anesthesiologists here] end

				break;
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Co Treating Doctors here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Co Treating Doctors here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Co Treating Doctors here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Co Treating Doctors here] end

				break;
			case "coTreatingSurgeonId":
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingSurgeon.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Co Treating Surgeon to Co Treating Surgeons here] end

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
	public CoTreatingDoctorEntity updateOldData(CoTreatingDoctorEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public CoTreatingDoctorEntity updateOldData(CoTreatingDoctorEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		CoTreatingDoctorEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInCoTreatingDoctorEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getAdditionalAnesthesiologist() == null && entity.getAdditionalAnesthesiologistId() == null) {
			entityToUpdate.unsetAdditionalAnesthesiologist();
		} else if (entity.getAdditionalAnesthesiologistId() != null && entity.getAdditionalAnesthesiologist() == null) {
			Optional<PreoperativeRecordsEntity> additionalAnesthesiologistEntity = this.preoperativeRecordsRepository.findById(entity.getAdditionalAnesthesiologistId());
			entityToUpdate.setAdditionalAnesthesiologist(additionalAnesthesiologistEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdditionalAnesthesiologist() != null) {
			entityToUpdate.setAdditionalAnesthesiologist(entity.getAdditionalAnesthesiologist(), false);
			if (entityToUpdate.getAdditionalAnesthesiologistId() != null) {
				this.preoperativeRecordsRepository.save(entityToUpdate.getAdditionalAnesthesiologist());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdditionalAnesthesiologist().unsetAdditionalAnesthesiologists();
			}
		}

		// Incoming One to Many reference
		if (entity.getAdditionalMidwife() == null && entity.getAdditionalMidwifeId() == null) {
			entityToUpdate.unsetAdditionalMidwife();
		} else if (entity.getAdditionalMidwifeId() != null && entity.getAdditionalMidwife() == null) {
			Optional<DeliveryMedicalExaminationRecordEntity> additionalMidwifeEntity = this.deliveryMedicalExaminationRecordRepository.findById(entity.getAdditionalMidwifeId());
			entityToUpdate.setAdditionalMidwife(additionalMidwifeEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdditionalMidwife() != null) {
			entityToUpdate.setAdditionalMidwife(entity.getAdditionalMidwife(), false);
			if (entityToUpdate.getAdditionalMidwifeId() != null) {
				this.deliveryMedicalExaminationRecordRepository.save(entityToUpdate.getAdditionalMidwife());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdditionalMidwife().unsetAdditionalMidwives();
			}
		}

		// Incoming One to Many reference
		if (entity.getAdditionalSurgeryNurse() == null && entity.getAdditionalSurgeryNurseId() == null) {
			entityToUpdate.unsetAdditionalSurgeryNurse();
		} else if (entity.getAdditionalSurgeryNurseId() != null && entity.getAdditionalSurgeryNurse() == null) {
			Optional<PreoperativeRecordsEntity> additionalSurgeryNurseEntity = this.preoperativeRecordsRepository.findById(entity.getAdditionalSurgeryNurseId());
			entityToUpdate.setAdditionalSurgeryNurse(additionalSurgeryNurseEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdditionalSurgeryNurse() != null) {
			entityToUpdate.setAdditionalSurgeryNurse(entity.getAdditionalSurgeryNurse(), false);
			if (entityToUpdate.getAdditionalSurgeryNurseId() != null) {
				this.preoperativeRecordsRepository.save(entityToUpdate.getAdditionalSurgeryNurse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdditionalSurgeryNurse().unsetAdditionalSurgeryNurses();
			}
		}

		// Incoming One to Many reference
		if (entity.getCoTreatingAnesthesiologist() == null && entity.getCoTreatingAnesthesiologistId() == null) {
			entityToUpdate.unsetCoTreatingAnesthesiologist();
		} else if (entity.getCoTreatingAnesthesiologistId() != null && entity.getCoTreatingAnesthesiologist() == null) {
			Optional<PreoperativeRecordsEntity> coTreatingAnesthesiologistEntity = this.preoperativeRecordsRepository.findById(entity.getCoTreatingAnesthesiologistId());
			entityToUpdate.setCoTreatingAnesthesiologist(coTreatingAnesthesiologistEntity.orElseThrow());
		}
		if (persistRelations && entity.getCoTreatingAnesthesiologist() != null) {
			entityToUpdate.setCoTreatingAnesthesiologist(entity.getCoTreatingAnesthesiologist(), false);
			if (entityToUpdate.getCoTreatingAnesthesiologistId() != null) {
				this.preoperativeRecordsRepository.save(entityToUpdate.getCoTreatingAnesthesiologist());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCoTreatingAnesthesiologist().unsetCoTreatingAnesthesiologists();
			}
		}

		// Incoming One to Many reference
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
				entityToUpdate.getMedicalExaminationRecord().unsetCoTreatingDoctors();
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
				entityToUpdate.getStaff().unsetCoTreatingDoctors();
			}
		}

		// Incoming One to Many reference
		if (entity.getCoTreatingSurgeon() == null && entity.getCoTreatingSurgeonId() == null) {
			entityToUpdate.unsetCoTreatingSurgeon();
		} else if (entity.getCoTreatingSurgeonId() != null && entity.getCoTreatingSurgeon() == null) {
			Optional<PreoperativeRecordsEntity> coTreatingSurgeonEntity = this.preoperativeRecordsRepository.findById(entity.getCoTreatingSurgeonId());
			entityToUpdate.setCoTreatingSurgeon(coTreatingSurgeonEntity.orElseThrow());
		}
		if (persistRelations && entity.getCoTreatingSurgeon() != null) {
			entityToUpdate.setCoTreatingSurgeon(entity.getCoTreatingSurgeon(), false);
			if (entityToUpdate.getCoTreatingSurgeonId() != null) {
				this.preoperativeRecordsRepository.save(entityToUpdate.getCoTreatingSurgeon());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCoTreatingSurgeon().unsetCoTreatingSurgeons();
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
	public void validateEntity(CoTreatingDoctorEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<CoTreatingDoctorEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the CoTreatingDoctorEntity.
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

	public Set<String> validateEntityRelations(CoTreatingDoctorEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getAdditionalAnesthesiologistId() != null && this.preoperativeRecordsRepository.findById(entity.getAdditionalAnesthesiologistId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdditionalAnesthesiologistId() + " is not associated with a Preoperative Records Entity");
		}

		if (entity.getAdditionalMidwifeId() != null && this.deliveryMedicalExaminationRecordRepository.findById(entity.getAdditionalMidwifeId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdditionalMidwifeId() + " is not associated with a Delivery Medical Examination Record Entity");
		}

		if (entity.getAdditionalSurgeryNurseId() != null && this.preoperativeRecordsRepository.findById(entity.getAdditionalSurgeryNurseId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdditionalSurgeryNurseId() + " is not associated with a Preoperative Records Entity");
		}

		if (entity.getCoTreatingAnesthesiologistId() != null && this.preoperativeRecordsRepository.findById(entity.getCoTreatingAnesthesiologistId()).isEmpty()) {
			errors.add("The UUID " + entity.getCoTreatingAnesthesiologistId() + " is not associated with a Preoperative Records Entity");
		}

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getCoTreatingSurgeonId() != null && this.preoperativeRecordsRepository.findById(entity.getCoTreatingSurgeonId()).isEmpty()) {
			errors.add("The UUID " + entity.getCoTreatingSurgeonId() + " is not associated with a Preoperative Records Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
