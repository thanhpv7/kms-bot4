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
import kmsweb.repositories.BpjsSpecialReferralRepository;
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
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.repositories.BpjsProcedureRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsSpecialReferralService extends AbstractService<BpjsSpecialReferralEntity, BpjsSpecialReferralRepository, BpjsSpecialReferralEntityAudit> {

	private final String[] referenceNamesInBpjsSpecialReferralEntity = {
		"additionalDiagnose",
		"additionalProcedure",
		"primaryDiagnose",
		"primaryProcedure",
	};

	private final BpjsDiagnoseRepository bpjsDiagnoseRepository;

	private final BpjsProcedureRepository bpjsProcedureRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsSpecialReferralService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsDiagnoseRepository bpjsDiagnoseRepository,
		BpjsProcedureRepository bpjsProcedureRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsSpecialReferralRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsDiagnoseRepository = bpjsDiagnoseRepository;

		this.bpjsProcedureRepository = bpjsProcedureRepository;

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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Referral ID.
	 *
	 * @param referralID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral ID
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByReferralID(String referralID)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralID here] end
	{
		// % protected region % [Add any additional logic for findByReferralID before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralID before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByReferralID(referralID));

		// % protected region % [Add any additional logic for findByReferralID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByReferralNo(String referralNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] end
	{
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByReferralNo(referralNo));

		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute PPK Diagnose.
	 *
	 * @param ppkDiagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PPK Diagnose
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByPpkDiagnose(String ppkDiagnose)
	// % protected region % [Add any throwables, implementations, or extensions for findByPpkDiagnose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPpkDiagnose here] end
	{
		// % protected region % [Add any additional logic for findByPpkDiagnose before the main body here] off begin
		// % protected region % [Add any additional logic for findByPpkDiagnose before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByPpkDiagnose(ppkDiagnose));

		// % protected region % [Add any additional logic for findByPpkDiagnose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPpkDiagnose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Start Date.
	 *
	 * @param referralStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Start Date
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByReferralStartDate(String referralStartDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralStartDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralStartDate here] end
	{
		// % protected region % [Add any additional logic for findByReferralStartDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralStartDate before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByReferralStartDate(referralStartDate));

		// % protected region % [Add any additional logic for findByReferralStartDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralStartDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral End Date.
	 *
	 * @param referralEndDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral End Date
	 */
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findByReferralEndDate(String referralEndDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralEndDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralEndDate here] end
	{
		// % protected region % [Add any additional logic for findByReferralEndDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralEndDate before the main body here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findByReferralEndDate(referralEndDate));

		// % protected region % [Add any additional logic for findByReferralEndDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralEndDate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsSpecialReferralEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsSpecialReferralEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsSpecialReferralEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'create')")
	public BpjsSpecialReferralEntity create(BpjsSpecialReferralEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsSpecialReferralEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'create')")
	public BpjsSpecialReferralEntity create(BpjsSpecialReferralEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsSpecialReferralEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsSpecialReferralEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'create')")
	public List<BpjsSpecialReferralEntity> createAll(Iterable<BpjsSpecialReferralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsSpecialReferralEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsSpecialReferralEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'update')")
	public BpjsSpecialReferralEntity update(BpjsSpecialReferralEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsSpecialReferralEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'update')")
	public BpjsSpecialReferralEntity update(BpjsSpecialReferralEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsSpecialReferralEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsSpecialReferralEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'update')")
	public List<BpjsSpecialReferralEntity> updateAll(Iterable<BpjsSpecialReferralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsSpecialReferralEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsSpecialReferralEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'create') or hasPermission('BpjsSpecialReferralEntity', 'update')")
	public BpjsSpecialReferralEntity save(BpjsSpecialReferralEntity entity) throws ConstraintViolationException
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

		BpjsSpecialReferralEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'create') or hasPermission('BpjsSpecialReferralEntity', 'update')")
	public List<BpjsSpecialReferralEntity> saveAll(Iterable<BpjsSpecialReferralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsSpecialReferralEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	public List<BpjsSpecialReferralEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	public List<BpjsSpecialReferralEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsSpecialReferralEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsSpecialReferralEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSpecialReferralEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSpecialReferralEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSpecialReferralEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsSpecialReferralEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSpecialReferralEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsSpecialReferralEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsSpecialReferralEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsSpecialReferralEntityAudits
	 */
	private List<BpjsSpecialReferralEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsSpecialReferralEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsSpecialReferral bpjsSpecialReferral to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsSpecialReferralEntity updateAuditData(BpjsSpecialReferralEntity bpjsSpecialReferral)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsSpecialReferral;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsSpecialReferralEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsSpecialReferralEntity entityAtRevision = updateAuditData((BpjsSpecialReferralEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsSpecialReferralEntityAudit(
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

		QBpjsSpecialReferralEntity entity = QBpjsSpecialReferralEntity.bpjsSpecialReferralEntity;

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
			case "additionalDiagnoseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Diagnose to Additional Diagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Diagnose to Additional Diagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalDiagnose.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Diagnose to Additional Diagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Diagnose to Additional Diagnose here] end

				break;
			case "additionalProcedureId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Procedure to Additional Procedure here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Procedure to Additional Procedure here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalProcedure.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Procedure to Additional Procedure here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Procedure to Additional Procedure here] end

				break;
			case "primaryDiagnoseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Primary Diagnose to Primary Diagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Primary Diagnose to Primary Diagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.primaryDiagnose.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Primary Diagnose to Primary Diagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Primary Diagnose to Primary Diagnose here] end

				break;
			case "primaryProcedureId":
				// % protected region % [Add any additional logic before the query parameters of relation from Primary Procedure to Primary Procedure here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Primary Procedure to Primary Procedure here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.primaryProcedure.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Primary Procedure to Primary Procedure here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Primary Procedure to Primary Procedure here] end

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
			case "ppkDiagnose":
				// % protected region % [Add any additional logic before the query parameters of ppkDiagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of ppkDiagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ppkDiagnose, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ppkDiagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of ppkDiagnose here] end

				break;
			case "referralStartDate":
				// % protected region % [Add any additional logic before the query parameters of referralStartDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralStartDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralStartDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralStartDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralStartDate here] end

				break;
			case "referralEndDate":
				// % protected region % [Add any additional logic before the query parameters of referralEndDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralEndDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralEndDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralEndDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralEndDate here] end

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
	public BpjsSpecialReferralEntity updateOldData(BpjsSpecialReferralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsSpecialReferralEntity updateOldData(BpjsSpecialReferralEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsSpecialReferralEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsSpecialReferralEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getAdditionalDiagnose() == null && entity.getAdditionalDiagnoseId() == null) {
			entityToUpdate.unsetAdditionalDiagnose();
		} else if (entity.getAdditionalDiagnoseId() != null && entity.getAdditionalDiagnose() == null) {
			Optional<BpjsDiagnoseEntity> additionalDiagnoseEntity = this.bpjsDiagnoseRepository.findById(entity.getAdditionalDiagnoseId());
			entityToUpdate.setAdditionalDiagnose(additionalDiagnoseEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdditionalDiagnose() != null) {
			entityToUpdate.setAdditionalDiagnose(entity.getAdditionalDiagnose(), false);
			if (entityToUpdate.getAdditionalDiagnoseId() != null) {
				this.bpjsDiagnoseRepository.save(entityToUpdate.getAdditionalDiagnose());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdditionalDiagnose().unsetAdditionalDiagnose();
			}
		}

		// Incoming One to Many reference
		if (entity.getAdditionalProcedure() == null && entity.getAdditionalProcedureId() == null) {
			entityToUpdate.unsetAdditionalProcedure();
		} else if (entity.getAdditionalProcedureId() != null && entity.getAdditionalProcedure() == null) {
			Optional<BpjsProcedureEntity> additionalProcedureEntity = this.bpjsProcedureRepository.findById(entity.getAdditionalProcedureId());
			entityToUpdate.setAdditionalProcedure(additionalProcedureEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdditionalProcedure() != null) {
			entityToUpdate.setAdditionalProcedure(entity.getAdditionalProcedure(), false);
			if (entityToUpdate.getAdditionalProcedureId() != null) {
				this.bpjsProcedureRepository.save(entityToUpdate.getAdditionalProcedure());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdditionalProcedure().unsetAdditionalProcedure();
			}
		}

		// Incoming One to Many reference
		if (entity.getPrimaryDiagnose() == null && entity.getPrimaryDiagnoseId() == null) {
			entityToUpdate.unsetPrimaryDiagnose();
		} else if (entity.getPrimaryDiagnoseId() != null && entity.getPrimaryDiagnose() == null) {
			Optional<BpjsDiagnoseEntity> primaryDiagnoseEntity = this.bpjsDiagnoseRepository.findById(entity.getPrimaryDiagnoseId());
			entityToUpdate.setPrimaryDiagnose(primaryDiagnoseEntity.orElseThrow());
		}
		if (persistRelations && entity.getPrimaryDiagnose() != null) {
			entityToUpdate.setPrimaryDiagnose(entity.getPrimaryDiagnose(), false);
			if (entityToUpdate.getPrimaryDiagnoseId() != null) {
				this.bpjsDiagnoseRepository.save(entityToUpdate.getPrimaryDiagnose());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPrimaryDiagnose().unsetPrimaryDiagnose();
			}
		}

		// Incoming One to Many reference
		if (entity.getPrimaryProcedure() == null && entity.getPrimaryProcedureId() == null) {
			entityToUpdate.unsetPrimaryProcedure();
		} else if (entity.getPrimaryProcedureId() != null && entity.getPrimaryProcedure() == null) {
			Optional<BpjsProcedureEntity> primaryProcedureEntity = this.bpjsProcedureRepository.findById(entity.getPrimaryProcedureId());
			entityToUpdate.setPrimaryProcedure(primaryProcedureEntity.orElseThrow());
		}
		if (persistRelations && entity.getPrimaryProcedure() != null) {
			entityToUpdate.setPrimaryProcedure(entity.getPrimaryProcedure(), false);
			if (entityToUpdate.getPrimaryProcedureId() != null) {
				this.bpjsProcedureRepository.save(entityToUpdate.getPrimaryProcedure());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPrimaryProcedure().unsetPrimaryProcedure();
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
	public void validateEntity(BpjsSpecialReferralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsSpecialReferralEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsSpecialReferralEntity.
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

	public Set<String> validateEntityRelations(BpjsSpecialReferralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getAdditionalDiagnoseId() != null && this.bpjsDiagnoseRepository.findById(entity.getAdditionalDiagnoseId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdditionalDiagnoseId() + " is not associated with a BPJS Diagnose Entity");
		}

		if (entity.getAdditionalProcedureId() != null && this.bpjsProcedureRepository.findById(entity.getAdditionalProcedureId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdditionalProcedureId() + " is not associated with a BPJS Procedure Entity");
		}

		if (entity.getPrimaryDiagnoseId() != null && this.bpjsDiagnoseRepository.findById(entity.getPrimaryDiagnoseId()).isEmpty()) {
			errors.add("The UUID " + entity.getPrimaryDiagnoseId() + " is not associated with a BPJS Diagnose Entity");
		}

		if (entity.getPrimaryProcedureId() != null && this.bpjsProcedureRepository.findById(entity.getPrimaryProcedureId()).isEmpty()) {
			errors.add("The UUID " + entity.getPrimaryProcedureId() + " is not associated with a BPJS Procedure Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
