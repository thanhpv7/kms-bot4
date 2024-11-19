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
import kmsweb.repositories.BpjsControlPlanRepository;
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
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsControlPlanService extends AbstractService<BpjsControlPlanEntity, BpjsControlPlanRepository, BpjsControlPlanEntityAudit> {

	private final String[] referenceNamesInBpjsControlPlanEntity = {
		"bpjsDoctorMapping",
		"bpjsServiceMapping",
	};

	private final BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	private final BpjsServiceMappingRepository bpjsServiceMappingRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsControlPlanService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsDoctorMappingRepository bpjsDoctorMappingRepository,
		BpjsServiceMappingRepository bpjsServiceMappingRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsControlPlanRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsDoctorMappingRepository = bpjsDoctorMappingRepository;

		this.bpjsServiceMappingRepository = bpjsServiceMappingRepository;

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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute No SEP.
	 *
	 * @param noSEP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute No SEP
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByNoSEP(String noSEP)
	// % protected region % [Add any throwables, implementations, or extensions for findByNoSEP here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNoSEP here] end
	{
		// % protected region % [Add any additional logic for findByNoSEP before the main body here] off begin
		// % protected region % [Add any additional logic for findByNoSEP before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByNoSEP(noSEP));

		// % protected region % [Add any additional logic for findByNoSEP before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNoSEP before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Control Letter No.
	 *
	 * @param controlLetterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Letter No
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByControlLetterNo(String controlLetterNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlLetterNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlLetterNo here] end
	{
		// % protected region % [Add any additional logic for findByControlLetterNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlLetterNo before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByControlLetterNo(controlLetterNo));

		// % protected region % [Add any additional logic for findByControlLetterNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlLetterNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Control Plan Date.
	 *
	 * @param controlPlanDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Plan Date
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByControlPlanDate(String controlPlanDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlPlanDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlPlanDate here] end
	{
		// % protected region % [Add any additional logic for findByControlPlanDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlPlanDate before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByControlPlanDate(controlPlanDate));

		// % protected region % [Add any additional logic for findByControlPlanDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlPlanDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date Of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Of Birth
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByDateOfBirth(String dateOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByDateOfBirth(dateOfBirth));

		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Code.
	 *
	 * @param doctorCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Code
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByDoctorCode(String doctorCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorCode here] end
	{
		// % protected region % [Add any additional logic for findByDoctorCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorCode before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByDoctorCode(doctorCode));

		// % protected region % [Add any additional logic for findByDoctorCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic Code.
	 *
	 * @param polyclinicCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic Code
	 */
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findByPolyclinicCode(String polyclinicCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicCode here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinicCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicCode before the main body here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findByPolyclinicCode(polyclinicCode));

		// % protected region % [Add any additional logic for findByPolyclinicCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicCode before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsControlPlanEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsControlPlanEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsControlPlanEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'create')")
	public BpjsControlPlanEntity create(BpjsControlPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsControlPlanEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'create')")
	public BpjsControlPlanEntity create(BpjsControlPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsControlPlanEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsControlPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'create')")
	public List<BpjsControlPlanEntity> createAll(Iterable<BpjsControlPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsControlPlanEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsControlPlanEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'update')")
	public BpjsControlPlanEntity update(BpjsControlPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsControlPlanEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'update')")
	public BpjsControlPlanEntity update(BpjsControlPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsControlPlanEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsControlPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'update')")
	public List<BpjsControlPlanEntity> updateAll(Iterable<BpjsControlPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsControlPlanEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsControlPlanEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'create') or hasPermission('BpjsControlPlanEntity', 'update')")
	public BpjsControlPlanEntity save(BpjsControlPlanEntity entity) throws ConstraintViolationException
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

		BpjsControlPlanEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'create') or hasPermission('BpjsControlPlanEntity', 'update')")
	public List<BpjsControlPlanEntity> saveAll(Iterable<BpjsControlPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsControlPlanEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	public List<BpjsControlPlanEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	public List<BpjsControlPlanEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsControlPlanEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsControlPlanEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsControlPlanEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsControlPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsControlPlanEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsControlPlanEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsControlPlanEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsControlPlanEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsControlPlanEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsControlPlanEntityAudits
	 */
	private List<BpjsControlPlanEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsControlPlanEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsControlPlan bpjsControlPlan to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsControlPlanEntity updateAuditData(BpjsControlPlanEntity bpjsControlPlan)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsControlPlan;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsControlPlanEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsControlPlanEntity entityAtRevision = updateAuditData((BpjsControlPlanEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsControlPlanEntityAudit(
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

		QBpjsControlPlanEntity entity = QBpjsControlPlanEntity.bpjsControlPlanEntity;

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
			case "bpjsDoctorMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to BPJS Control Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to BPJS Control Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDoctorMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to BPJS Control Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to BPJS Control Plans here] end

				break;
			case "bpjsServiceMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to BPJS Control Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to BPJS Control Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsServiceMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to BPJS Control Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to BPJS Control Plans here] end

				break;
			case "noSEP":
				// % protected region % [Add any additional logic before the query parameters of noSEP here] off begin
				// % protected region % [Add any additional logic before the query parameters of noSEP here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.noSEP, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of noSEP here] off begin
				// % protected region % [Add any additional logic after the query parameters of noSEP here] end

				break;
			case "controlLetterNo":
				// % protected region % [Add any additional logic before the query parameters of controlLetterNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlLetterNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlLetterNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlLetterNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlLetterNo here] end

				break;
			case "controlPlanDate":
				// % protected region % [Add any additional logic before the query parameters of controlPlanDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlPlanDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlPlanDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlPlanDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlPlanDate here] end

				break;
			case "bpjsCardNo":
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsCardNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] end

				break;
			case "name":
				// % protected region % [Add any additional logic before the query parameters of name here] off begin
				// % protected region % [Add any additional logic before the query parameters of name here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.name, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of name here] off begin
				// % protected region % [Add any additional logic after the query parameters of name here] end

				break;
			case "gender":
				// % protected region % [Add any additional logic before the query parameters of gender here] off begin
				// % protected region % [Add any additional logic before the query parameters of gender here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.gender, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of gender here] off begin
				// % protected region % [Add any additional logic after the query parameters of gender here] end

				break;
			case "dateOfBirth":
				// % protected region % [Add any additional logic before the query parameters of dateOfBirth here] off begin
				// % protected region % [Add any additional logic before the query parameters of dateOfBirth here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dateOfBirth, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dateOfBirth here] off begin
				// % protected region % [Add any additional logic after the query parameters of dateOfBirth here] end

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
	public BpjsControlPlanEntity updateOldData(BpjsControlPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsControlPlanEntity updateOldData(BpjsControlPlanEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsControlPlanEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsControlPlanEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getBpjsDoctorMapping() == null && entity.getBpjsDoctorMappingId() == null) {
			entityToUpdate.unsetBpjsDoctorMapping();
		} else if (entity.getBpjsDoctorMappingId() != null && entity.getBpjsDoctorMapping() == null) {
			Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingEntity = this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId());
			entityToUpdate.setBpjsDoctorMapping(bpjsDoctorMappingEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsDoctorMapping() != null) {
			entityToUpdate.setBpjsDoctorMapping(entity.getBpjsDoctorMapping(), false);
			if (entityToUpdate.getBpjsDoctorMappingId() != null) {
				this.bpjsDoctorMappingRepository.save(entityToUpdate.getBpjsDoctorMapping());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsDoctorMapping().unsetBpjsControlPlans();
			}
		}

		// Incoming One to Many reference
		if (entity.getBpjsServiceMapping() == null && entity.getBpjsServiceMappingId() == null) {
			entityToUpdate.unsetBpjsServiceMapping();
		} else if (entity.getBpjsServiceMappingId() != null && entity.getBpjsServiceMapping() == null) {
			Optional<BpjsServiceMappingEntity> bpjsServiceMappingEntity = this.bpjsServiceMappingRepository.findById(entity.getBpjsServiceMappingId());
			entityToUpdate.setBpjsServiceMapping(bpjsServiceMappingEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsServiceMapping() != null) {
			entityToUpdate.setBpjsServiceMapping(entity.getBpjsServiceMapping(), false);
			if (entityToUpdate.getBpjsServiceMappingId() != null) {
				this.bpjsServiceMappingRepository.save(entityToUpdate.getBpjsServiceMapping());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsServiceMapping().unsetBpjsControlPlans();
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
	public void validateEntity(BpjsControlPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsControlPlanEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsControlPlanEntity.
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

	public Set<String> validateEntityRelations(BpjsControlPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getBpjsDoctorMappingId() != null && this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsDoctorMappingId() + " is not associated with a BPJS Doctor Mapping Entity");
		}

		if (entity.getBpjsServiceMappingId() != null && this.bpjsServiceMappingRepository.findById(entity.getBpjsServiceMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsServiceMappingId() + " is not associated with a BPJS Service Mapping Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
