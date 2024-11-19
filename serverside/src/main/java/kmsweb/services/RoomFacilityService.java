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
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.RoomFacilityRepository;
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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.services.AbstractFileService;
// % protected region % [Override your file service import here] off begin
import kmsweb.lib.file.services.S3FileService;
// % protected region % [Override your file service import here] end

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class RoomFacilityService extends AbstractService<RoomFacilityEntity, RoomFacilityRepository, RoomFacilityEntityAudit> {

	private final String[] referenceNamesInRoomFacilityEntity = {
		"bedFacilities",
		"operatingRoom",
		"preoperativeRooms",
		"recoveryRooms",
	};

	private AbstractFileService<FileEntity> fileService;

	private final BedFacilityRepository bedFacilityRepository;

	private final IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	private final PostOperativeDetailsRepository postOperativeDetailsRepository;

	private final PreoperativeRecordsRepository preoperativeRecordsRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RoomFacilityService(
		// % protected region % [Add any additional constructor parameters here] off begin
		S3FileService s3FileService,
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		IntraoperativeRecordsRepository intraoperativeRecordsRepository,
		PostOperativeDetailsRepository postOperativeDetailsRepository,
		PreoperativeRecordsRepository preoperativeRecordsRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		RoomFacilityRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.intraoperativeRecordsRepository = intraoperativeRecordsRepository;

		this.postOperativeDetailsRepository = postOperativeDetailsRepository;

		this.preoperativeRecordsRepository = preoperativeRecordsRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		this.fileService = s3FileService;
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Room Number.
	 *
	 * @param roomNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Room Number
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<RoomFacilityEntity> findByRoomNumber(String roomNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByRoomNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRoomNumber here] end
	{
		// % protected region % [Add any additional logic for findByRoomNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByRoomNumber before the main body here] end

		Optional<RoomFacilityEntity> entity = repository.findByRoomNumber(roomNumber);

		// % protected region % [Add any additional logic for findByRoomNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByRoomNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Room Name.
	 *
	 * @param roomName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Room Name
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByRoomName(String roomName)
	// % protected region % [Add any throwables, implementations, or extensions for findByRoomName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRoomName here] end
	{
		// % protected region % [Add any additional logic for findByRoomName before the main body here] off begin
		// % protected region % [Add any additional logic for findByRoomName before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByRoomName(roomName));

		// % protected region % [Add any additional logic for findByRoomName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRoomName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Department.
	 *
	 * @param department the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Department
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByDepartment(String department)
	// % protected region % [Add any throwables, implementations, or extensions for findByDepartment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDepartment here] end
	{
		// % protected region % [Add any additional logic for findByDepartment before the main body here] off begin
		// % protected region % [Add any additional logic for findByDepartment before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByDepartment(department));

		// % protected region % [Add any additional logic for findByDepartment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDepartment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender Allocation.
	 *
	 * @param genderAllocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender Allocation
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByGenderAllocation(String genderAllocation)
	// % protected region % [Add any throwables, implementations, or extensions for findByGenderAllocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGenderAllocation here] end
	{
		// % protected region % [Add any additional logic for findByGenderAllocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByGenderAllocation before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByGenderAllocation(genderAllocation));

		// % protected region % [Add any additional logic for findByGenderAllocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGenderAllocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Location.
	 *
	 * @param location the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Location
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByLocation(String location)
	// % protected region % [Add any throwables, implementations, or extensions for findByLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLocation here] end
	{
		// % protected region % [Add any additional logic for findByLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByLocation before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByLocation(location));

		// % protected region % [Add any additional logic for findByLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Category.
	 *
	 * @param category the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Category
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByCategory(String category)
	// % protected region % [Add any throwables, implementations, or extensions for findByCategory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCategory here] end
	{
		// % protected region % [Add any additional logic for findByCategory before the main body here] off begin
		// % protected region % [Add any additional logic for findByCategory before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByCategory(category));

		// % protected region % [Add any additional logic for findByCategory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCategory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<RoomFacilityEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<RoomFacilityEntity> entity = repository.findById(id);

		entity.ifPresent(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<RoomFacilityEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<RoomFacilityEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create')")
	public RoomFacilityEntity create(RoomFacilityEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		RoomFacilityEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create')")
	public RoomFacilityEntity create(RoomFacilityEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		RoomFacilityEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		RoomFacilityEntity newEntity;

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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create')")
	public List<RoomFacilityEntity> createAll(Iterable<RoomFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<RoomFacilityEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<RoomFacilityEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'update')")
	public RoomFacilityEntity update(RoomFacilityEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		RoomFacilityEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'update')")
	public RoomFacilityEntity update(RoomFacilityEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		RoomFacilityEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		RoomFacilityEntity newEntity;

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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'update')")
	public List<RoomFacilityEntity> updateAll(Iterable<RoomFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<RoomFacilityEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<RoomFacilityEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create') or hasPermission('RoomFacilityEntity', 'update')")
	public RoomFacilityEntity save(RoomFacilityEntity entity) throws ConstraintViolationException
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

		RoomFacilityEntity newEntity = repository.save(entity);

		generateSignedFileUrls(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'create') or hasPermission('RoomFacilityEntity', 'update')")
	public List<RoomFacilityEntity> saveAll(Iterable<RoomFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<RoomFacilityEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	public List<RoomFacilityEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	public List<RoomFacilityEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(RoomFacilityEntity.class);

		// % protected region % [Add any additional processing before converting to a list of RoomFacilityEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of RoomFacilityEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('RoomFacilityEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RoomFacilityEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of RoomFacilityEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of RoomFacilityEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(RoomFacilityEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of RoomFacilityEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of RoomFacilityEntityAudits
	 */
	private List<RoomFacilityEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<RoomFacilityEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param roomFacility roomFacility to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private RoomFacilityEntity updateAuditData(RoomFacilityEntity roomFacility)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{

		roomFacility.setRoomFacilityPicture(new HashSet<>(roomFacility.getRoomFacilityPicture()));

		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return roomFacility;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private RoomFacilityEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		RoomFacilityEntity entityAtRevision = updateAuditData((RoomFacilityEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new RoomFacilityEntityAudit(
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
	 * Generate signed URL for all files so that the user can download them.
	 */
	private void generateSignedFileUrls(RoomFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] end
	{
		Set<FileEntity> roomFacilityPicture = entity.getRoomFacilityPicture();

		for (FileEntity individualRoomFacilityPicture : roomFacilityPicture) {
			String url = fileService.generateUrl(individualRoomFacilityPicture.getId());
			individualRoomFacilityPicture.setUrl(url);
		}
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

		QRoomFacilityEntity entity = QRoomFacilityEntity.roomFacilityEntity;

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
			case "bedFacilitiesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Room Facility to Bed Facilities here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Room Facility to Bed Facilities here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacilities.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Room Facility to Bed Facilities here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Room Facility to Bed Facilities here] end

				break;
			case "operatingRoomId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Room to Operating Room here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Room to Operating Room here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingRoom.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Room to Operating Room here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Room to Operating Room here] end

				break;
			case "preoperativeRoomsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.preoperativeRooms.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Preoperative Rooms to Preoperative Rooms here] end

				break;
			case "recoveryRoomsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Recovery Rooms to Recovery Rooms here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Recovery Rooms to Recovery Rooms here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.recoveryRooms.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Recovery Rooms to Recovery Rooms here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Recovery Rooms to Recovery Rooms here] end

				break;
			case "roomNumber":
				// % protected region % [Add any additional logic before the query parameters of roomNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of roomNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.roomNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of roomNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of roomNumber here] end

				break;
			case "roomName":
				// % protected region % [Add any additional logic before the query parameters of roomName here] off begin
				// % protected region % [Add any additional logic before the query parameters of roomName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.roomName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of roomName here] off begin
				// % protected region % [Add any additional logic after the query parameters of roomName here] end

				break;
			case "department":
				// % protected region % [Add any additional logic before the query parameters of department here] off begin
				// % protected region % [Add any additional logic before the query parameters of department here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.department, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of department here] off begin
				// % protected region % [Add any additional logic after the query parameters of department here] end

				break;
			case "genderAllocation":
				// % protected region % [Add any additional logic before the query parameters of genderAllocation here] off begin
				// % protected region % [Add any additional logic before the query parameters of genderAllocation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.genderAllocation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of genderAllocation here] off begin
				// % protected region % [Add any additional logic after the query parameters of genderAllocation here] end

				break;
			case "location":
				// % protected region % [Add any additional logic before the query parameters of location here] off begin
				// % protected region % [Add any additional logic before the query parameters of location here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.location, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of location here] off begin
				// % protected region % [Add any additional logic after the query parameters of location here] end

				break;
			case "treatmentClass":
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentClass, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] end

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
	public RoomFacilityEntity updateOldData(RoomFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public RoomFacilityEntity updateOldData(RoomFacilityEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		RoomFacilityEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInRoomFacilityEntity);


			// % protected region % [Add any additional logic for update before uploading files here] off begin
			// % protected region % [Add any additional logic for update before uploading files here] end

			Set<FileEntity> roomFacilityPictureFiles = entity.getRoomFacilityPicture();

			// Delete any file that requires deletion.
			Set<FileEntity> roomFacilityPicturefilesToDelete = roomFacilityPictureFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsRoomFacilityPicture) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			roomFacilityPicturefilesToDelete.stream()
					.peek(entity::removeRoomFacilityPicture) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> roomFacilityPictureFilesToUpload = roomFacilityPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(roomFacilityPictureFilesToUpload).forEach(entity::addRoomFacilityPicture);
		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			Set<FileEntity> roomFacilityPictureFiles = entityToUpdate.getRoomFacilityPicture();
			// Merge the rest of the files together
			Set<FileEntity> roomFacilityPictureFilesToUpload = roomFacilityPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllRoomFacilityPicture();
			fileService.uploadMultiple(roomFacilityPictureFilesToUpload).forEach(entity::addRoomFacilityPicture);

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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

		// Outgoing one to many reference
		if (entity.getOperatingRoomIds().isEmpty() && entity.getOperatingRoom().isEmpty()) {
			entityToUpdate.setOperatingRoom(new HashSet<>());
		} else if (!entity.getOperatingRoomIds().isEmpty() && entity.getOperatingRoom().isEmpty()) {
			Iterable<IntraoperativeRecordsEntity> operatingRoomEntities =
					this.intraoperativeRecordsRepository.findAllById(entity.getOperatingRoomIds());
			entityToUpdate.setOperatingRoom(Sets.newHashSet(operatingRoomEntities));
		}
		if (persistRelations && !entity.getOperatingRoom().isEmpty()) {
			Set<IntraoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getOperatingRoom().forEach(model -> {
				if (model.getId() != null) {
					model = this.intraoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setOperatingRoom(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPreoperativeRoomsIds().isEmpty() && entity.getPreoperativeRooms().isEmpty()) {
			entityToUpdate.setPreoperativeRooms(new HashSet<>());
		} else if (!entity.getPreoperativeRoomsIds().isEmpty() && entity.getPreoperativeRooms().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> preoperativeRoomsEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getPreoperativeRoomsIds());
			entityToUpdate.setPreoperativeRooms(Sets.newHashSet(preoperativeRoomsEntities));
		}
		if (persistRelations && !entity.getPreoperativeRooms().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getPreoperativeRooms().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPreoperativeRooms(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRecoveryRoomsIds().isEmpty() && entity.getRecoveryRooms().isEmpty()) {
			entityToUpdate.setRecoveryRooms(new HashSet<>());
		} else if (!entity.getRecoveryRoomsIds().isEmpty() && entity.getRecoveryRooms().isEmpty()) {
			Iterable<PostOperativeDetailsEntity> recoveryRoomsEntities =
					this.postOperativeDetailsRepository.findAllById(entity.getRecoveryRoomsIds());
			entityToUpdate.setRecoveryRooms(Sets.newHashSet(recoveryRoomsEntities));
		}
		if (persistRelations && !entity.getRecoveryRooms().isEmpty()) {
			Set<PostOperativeDetailsEntity> updatedEntities = new HashSet<>();
			entity.getRecoveryRooms().forEach(model -> {
				if (model.getId() != null) {
					model = this.postOperativeDetailsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRecoveryRooms(updatedEntities);
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
	public void validateEntity(RoomFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<RoomFacilityEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByRoomNumberOpt = this.findByRoomNumber(entity.getRoomNumber());
			if (entityByRoomNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<RoomFacilityEntity>(
						"Room Number",
						entity.getRoomNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"RoomNumber"
				);
				errors.add(uniquenessViolation);
			}
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
	 * Get the sort as given by the sort by for the RoomFacilityEntity.
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

	public Set<String> validateEntityRelations(RoomFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getBedFacilitiesIds()) {
			if (this.bedFacilityRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bed Facility Entity");
			}
		}

		for (UUID id : entity.getOperatingRoomIds()) {
			if (this.intraoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Intraoperative Records Entity");
			}
		}

		for (UUID id : entity.getPreoperativeRoomsIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getRecoveryRoomsIds()) {
			if (this.postOperativeDetailsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Post Operative Details Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
