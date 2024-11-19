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
import kmsweb.repositories.SampleCollectionItemsRepository;
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
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
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
public class SampleCollectionItemsService extends AbstractService<SampleCollectionItemsEntity, SampleCollectionItemsRepository, SampleCollectionItemsEntityAudit> {

	private final String[] referenceNamesInSampleCollectionItemsEntity = {
		"sampleCollectionInformation",
		"sampleCollectionStaff",
		"sampleDeliveryStaff",
		"sampleProcessingStaff",
	};

	private final SampleCollectionInformationRepository sampleCollectionInformationRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SampleCollectionItemsService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		SampleCollectionInformationRepository sampleCollectionInformationRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		SampleCollectionItemsRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.sampleCollectionInformationRepository = sampleCollectionInformationRepository;

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Sample Type.
	 *
	 * @param sampleType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Type
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleType(String sampleType)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleType here] end
	{
		// % protected region % [Add any additional logic for findBySampleType before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleType before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleType(sampleType));

		// % protected region % [Add any additional logic for findBySampleType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample Number.
	 *
	 * @param sampleNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Number
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleNumber(String sampleNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleNumber here] end
	{
		// % protected region % [Add any additional logic for findBySampleNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleNumber before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleNumber(sampleNumber));

		// % protected region % [Add any additional logic for findBySampleNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample Taking Location.
	 *
	 * @param sampleTakingLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Taking Location
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleTakingLocation(String sampleTakingLocation)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleTakingLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleTakingLocation here] end
	{
		// % protected region % [Add any additional logic for findBySampleTakingLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleTakingLocation before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleTakingLocation(sampleTakingLocation));

		// % protected region % [Add any additional logic for findBySampleTakingLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleTakingLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Volume.
	 *
	 * @param volume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findByVolume(String volume)
	// % protected region % [Add any throwables, implementations, or extensions for findByVolume here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVolume here] end
	{
		// % protected region % [Add any additional logic for findByVolume before the main body here] off begin
		// % protected region % [Add any additional logic for findByVolume before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findByVolume(volume));

		// % protected region % [Add any additional logic for findByVolume before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVolume before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Container.
	 *
	 * @param container the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Container
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findByContainer(String container)
	// % protected region % [Add any throwables, implementations, or extensions for findByContainer here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContainer here] end
	{
		// % protected region % [Add any additional logic for findByContainer before the main body here] off begin
		// % protected region % [Add any additional logic for findByContainer before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findByContainer(container));

		// % protected region % [Add any additional logic for findByContainer before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContainer before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transport.
	 *
	 * @param transport the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transport
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findByTransport(String transport)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransport here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransport here] end
	{
		// % protected region % [Add any additional logic for findByTransport before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransport before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findByTransport(transport));

		// % protected region % [Add any additional logic for findByTransport before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransport before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample Collection Date Time.
	 *
	 * @param sampleCollectionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Collection Date Time
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleCollectionDateTime(OffsetDateTime sampleCollectionDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleCollectionDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleCollectionDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySampleCollectionDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleCollectionDateTime before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleCollectionDateTime(sampleCollectionDateTime));

		// % protected region % [Add any additional logic for findBySampleCollectionDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleCollectionDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample Processing Date Time.
	 *
	 * @param sampleProcessingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Processing Date Time
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleProcessingDateTime(OffsetDateTime sampleProcessingDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleProcessingDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleProcessingDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySampleProcessingDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleProcessingDateTime before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleProcessingDateTime(sampleProcessingDateTime));

		// % protected region % [Add any additional logic for findBySampleProcessingDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleProcessingDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample Delivery Date Time.
	 *
	 * @param sampleDeliveryDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample Delivery Date Time
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findBySampleDeliveryDateTime(OffsetDateTime sampleDeliveryDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleDeliveryDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySampleDeliveryDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySampleDeliveryDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySampleDeliveryDateTime before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findBySampleDeliveryDateTime(sampleDeliveryDateTime));

		// % protected region % [Add any additional logic for findBySampleDeliveryDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySampleDeliveryDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<SampleCollectionItemsEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<SampleCollectionItemsEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<SampleCollectionItemsEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create')")
	public SampleCollectionItemsEntity create(SampleCollectionItemsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		SampleCollectionItemsEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create')")
	public SampleCollectionItemsEntity create(SampleCollectionItemsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		SampleCollectionItemsEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		SampleCollectionItemsEntity newEntity;

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create')")
	public List<SampleCollectionItemsEntity> createAll(Iterable<SampleCollectionItemsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<SampleCollectionItemsEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<SampleCollectionItemsEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'update')")
	public SampleCollectionItemsEntity update(SampleCollectionItemsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		SampleCollectionItemsEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'update')")
	public SampleCollectionItemsEntity update(SampleCollectionItemsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		SampleCollectionItemsEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		SampleCollectionItemsEntity newEntity;

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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'update')")
	public List<SampleCollectionItemsEntity> updateAll(Iterable<SampleCollectionItemsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<SampleCollectionItemsEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<SampleCollectionItemsEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create') or hasPermission('SampleCollectionItemsEntity', 'update')")
	public SampleCollectionItemsEntity save(SampleCollectionItemsEntity entity) throws ConstraintViolationException
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

		SampleCollectionItemsEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'create') or hasPermission('SampleCollectionItemsEntity', 'update')")
	public List<SampleCollectionItemsEntity> saveAll(Iterable<SampleCollectionItemsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<SampleCollectionItemsEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	public List<SampleCollectionItemsEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	public List<SampleCollectionItemsEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(SampleCollectionItemsEntity.class);

		// % protected region % [Add any additional processing before converting to a list of SampleCollectionItemsEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of SampleCollectionItemsEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SampleCollectionItemsEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of SampleCollectionItemsEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of SampleCollectionItemsEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(SampleCollectionItemsEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of SampleCollectionItemsEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of SampleCollectionItemsEntityAudits
	 */
	private List<SampleCollectionItemsEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<SampleCollectionItemsEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param sampleCollectionItems sampleCollectionItems to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private SampleCollectionItemsEntity updateAuditData(SampleCollectionItemsEntity sampleCollectionItems)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return sampleCollectionItems;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private SampleCollectionItemsEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		SampleCollectionItemsEntity entityAtRevision = updateAuditData((SampleCollectionItemsEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new SampleCollectionItemsEntityAudit(
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

		QSampleCollectionItemsEntity entity = QSampleCollectionItemsEntity.sampleCollectionItemsEntity;

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
			case "sampleCollectionInformationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Information to Sample Collection Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Information to Sample Collection Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleCollectionInformation.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Information to Sample Collection Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Information to Sample Collection Items here] end

				break;
			case "sampleCollectionStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleCollectionStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] end

				break;
			case "sampleDeliveryStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleDeliveryStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] end

				break;
			case "sampleProcessingStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleProcessingStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] end

				break;
			case "sampleDeliveryDateTime":
				// % protected region % [Add any additional logic before the query parameters of sampleDeliveryDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of sampleDeliveryDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleDeliveryDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sampleDeliveryDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of sampleDeliveryDateTime here] end

				break;
			case "notes":
				// % protected region % [Add any additional logic before the query parameters of notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.notes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of notes here] end

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
	public SampleCollectionItemsEntity updateOldData(SampleCollectionItemsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public SampleCollectionItemsEntity updateOldData(SampleCollectionItemsEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		SampleCollectionItemsEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInSampleCollectionItemsEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getSampleCollectionInformation() == null && entity.getSampleCollectionInformationId() == null) {
			entityToUpdate.unsetSampleCollectionInformation();
		} else if (entity.getSampleCollectionInformationId() != null && entity.getSampleCollectionInformation() == null) {
			Optional<SampleCollectionInformationEntity> sampleCollectionInformationEntity = this.sampleCollectionInformationRepository.findById(entity.getSampleCollectionInformationId());
			entityToUpdate.setSampleCollectionInformation(sampleCollectionInformationEntity.orElseThrow());
		}
		if (persistRelations && entity.getSampleCollectionInformation() != null) {
			entityToUpdate.setSampleCollectionInformation(entity.getSampleCollectionInformation(), false);
			if (entityToUpdate.getSampleCollectionInformationId() != null) {
				this.sampleCollectionInformationRepository.save(entityToUpdate.getSampleCollectionInformation());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSampleCollectionInformation().unsetSampleCollectionItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getSampleCollectionStaff() == null && entity.getSampleCollectionStaffId() == null) {
			entityToUpdate.unsetSampleCollectionStaff();
		} else if (entity.getSampleCollectionStaffId() != null && entity.getSampleCollectionStaff() == null) {
			Optional<StaffEntity> sampleCollectionStaffEntity = this.staffRepository.findById(entity.getSampleCollectionStaffId());
			entityToUpdate.setSampleCollectionStaff(sampleCollectionStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getSampleCollectionStaff() != null) {
			entityToUpdate.setSampleCollectionStaff(entity.getSampleCollectionStaff(), false);
			if (entityToUpdate.getSampleCollectionStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getSampleCollectionStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSampleCollectionStaff().unsetSampleCollectionStaffs();
			}
		}

		// Incoming One to Many reference
		if (entity.getSampleDeliveryStaff() == null && entity.getSampleDeliveryStaffId() == null) {
			entityToUpdate.unsetSampleDeliveryStaff();
		} else if (entity.getSampleDeliveryStaffId() != null && entity.getSampleDeliveryStaff() == null) {
			Optional<StaffEntity> sampleDeliveryStaffEntity = this.staffRepository.findById(entity.getSampleDeliveryStaffId());
			entityToUpdate.setSampleDeliveryStaff(sampleDeliveryStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getSampleDeliveryStaff() != null) {
			entityToUpdate.setSampleDeliveryStaff(entity.getSampleDeliveryStaff(), false);
			if (entityToUpdate.getSampleDeliveryStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getSampleDeliveryStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSampleDeliveryStaff().unsetSampleDeliveryStaffs();
			}
		}

		// Incoming One to Many reference
		if (entity.getSampleProcessingStaff() == null && entity.getSampleProcessingStaffId() == null) {
			entityToUpdate.unsetSampleProcessingStaff();
		} else if (entity.getSampleProcessingStaffId() != null && entity.getSampleProcessingStaff() == null) {
			Optional<StaffEntity> sampleProcessingStaffEntity = this.staffRepository.findById(entity.getSampleProcessingStaffId());
			entityToUpdate.setSampleProcessingStaff(sampleProcessingStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getSampleProcessingStaff() != null) {
			entityToUpdate.setSampleProcessingStaff(entity.getSampleProcessingStaff(), false);
			if (entityToUpdate.getSampleProcessingStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getSampleProcessingStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSampleProcessingStaff().unsetSampleProcessingStaffs();
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
	public void validateEntity(SampleCollectionItemsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<SampleCollectionItemsEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the SampleCollectionItemsEntity.
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

	public Set<String> validateEntityRelations(SampleCollectionItemsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getSampleCollectionInformationId() != null && this.sampleCollectionInformationRepository.findById(entity.getSampleCollectionInformationId()).isEmpty()) {
			errors.add("The UUID " + entity.getSampleCollectionInformationId() + " is not associated with a Sample Collection Information Entity");
		}

		if (entity.getSampleCollectionStaffId() != null && this.staffRepository.findById(entity.getSampleCollectionStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getSampleCollectionStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getSampleDeliveryStaffId() != null && this.staffRepository.findById(entity.getSampleDeliveryStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getSampleDeliveryStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getSampleProcessingStaffId() != null && this.staffRepository.findById(entity.getSampleProcessingStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getSampleProcessingStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
