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
import kmsweb.repositories.BpjsHospitalizationPlanRepository;
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
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsHospitalizationPlanService extends AbstractService<BpjsHospitalizationPlanEntity, BpjsHospitalizationPlanRepository, BpjsHospitalizationPlanEntityAudit> {

	private final String[] referenceNamesInBpjsHospitalizationPlanEntity = {
		"patientPaymentBPJS",
		"bpjsDoctorMapping",
		"bpjsServiceMapping",
	};

	private final BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	private final BpjsServiceMappingRepository bpjsServiceMappingRepository;

	private final PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsHospitalizationPlanService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsDoctorMappingRepository bpjsDoctorMappingRepository,
		BpjsServiceMappingRepository bpjsServiceMappingRepository,
		PatientPaymentBPJSRepository patientPaymentBPJSRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsHospitalizationPlanRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsDoctorMappingRepository = bpjsDoctorMappingRepository;

		this.bpjsServiceMappingRepository = bpjsServiceMappingRepository;

		this.patientPaymentBPJSRepository = patientPaymentBPJSRepository;

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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute noKartu.
	 *
	 * @param nokartu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKartu
	 */
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findByNokartu(String nokartu)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokartu here] end
	{
		// % protected region % [Add any additional logic for findByNokartu before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokartu before the main body here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findByNokartu(nokartu));

		// % protected region % [Add any additional logic for findByNokartu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNokartu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglRencanaKontrol.
	 *
	 * @param tglrencanakontrol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglRencanaKontrol
	 */
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findByTglrencanakontrol(OffsetDateTime tglrencanakontrol)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglrencanakontrol here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglrencanakontrol here] end
	{
		// % protected region % [Add any additional logic for findByTglrencanakontrol before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglrencanakontrol before the main body here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findByTglrencanakontrol(tglrencanakontrol));

		// % protected region % [Add any additional logic for findByTglrencanakontrol before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglrencanakontrol before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noSPRI.
	 *
	 * @param nospri the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noSPRI
	 */
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findByNospri(String nospri)
	// % protected region % [Add any throwables, implementations, or extensions for findByNospri here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNospri here] end
	{
		// % protected region % [Add any additional logic for findByNospri before the main body here] off begin
		// % protected region % [Add any additional logic for findByNospri before the main body here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findByNospri(nospri));

		// % protected region % [Add any additional logic for findByNospri before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNospri before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute diagnosa.
	 *
	 * @param diagnosa the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute diagnosa
	 */
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findByDiagnosa(String diagnosa)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosa here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosa before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa before the main body here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findByDiagnosa(diagnosa));

		// % protected region % [Add any additional logic for findByDiagnosa before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosa before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsHospitalizationPlanEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsHospitalizationPlanEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsHospitalizationPlanEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'create')")
	public BpjsHospitalizationPlanEntity create(BpjsHospitalizationPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsHospitalizationPlanEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'create')")
	public BpjsHospitalizationPlanEntity create(BpjsHospitalizationPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsHospitalizationPlanEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsHospitalizationPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'create')")
	public List<BpjsHospitalizationPlanEntity> createAll(Iterable<BpjsHospitalizationPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsHospitalizationPlanEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsHospitalizationPlanEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'update')")
	public BpjsHospitalizationPlanEntity update(BpjsHospitalizationPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsHospitalizationPlanEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'update')")
	public BpjsHospitalizationPlanEntity update(BpjsHospitalizationPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsHospitalizationPlanEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsHospitalizationPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'update')")
	public List<BpjsHospitalizationPlanEntity> updateAll(Iterable<BpjsHospitalizationPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsHospitalizationPlanEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsHospitalizationPlanEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'create') or hasPermission('BpjsHospitalizationPlanEntity', 'update')")
	public BpjsHospitalizationPlanEntity save(BpjsHospitalizationPlanEntity entity) throws ConstraintViolationException
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

		BpjsHospitalizationPlanEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'create') or hasPermission('BpjsHospitalizationPlanEntity', 'update')")
	public List<BpjsHospitalizationPlanEntity> saveAll(Iterable<BpjsHospitalizationPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsHospitalizationPlanEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	public List<BpjsHospitalizationPlanEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	public List<BpjsHospitalizationPlanEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsHospitalizationPlanEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsHospitalizationPlanEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsHospitalizationPlanEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsHospitalizationPlanEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsHospitalizationPlanEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsHospitalizationPlanEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsHospitalizationPlanEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsHospitalizationPlanEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsHospitalizationPlanEntityAudits
	 */
	private List<BpjsHospitalizationPlanEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsHospitalizationPlanEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsHospitalizationPlan bpjsHospitalizationPlan to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsHospitalizationPlanEntity updateAuditData(BpjsHospitalizationPlanEntity bpjsHospitalizationPlan)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsHospitalizationPlan;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsHospitalizationPlanEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsHospitalizationPlanEntity entityAtRevision = updateAuditData((BpjsHospitalizationPlanEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsHospitalizationPlanEntityAudit(
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

		QBpjsHospitalizationPlanEntity entity = QBpjsHospitalizationPlanEntity.bpjsHospitalizationPlanEntity;

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
			case "patientPaymentBPJSId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentBPJS.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] end

				break;
			case "bpjsDoctorMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to kodeDokter here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to kodeDokter here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDoctorMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to kodeDokter here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to kodeDokter here] end

				break;
			case "bpjsServiceMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to poliKontrol here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to poliKontrol here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsServiceMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to poliKontrol here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to poliKontrol here] end

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
	public BpjsHospitalizationPlanEntity updateOldData(BpjsHospitalizationPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsHospitalizationPlanEntity updateOldData(BpjsHospitalizationPlanEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsHospitalizationPlanEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsHospitalizationPlanEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPatientPaymentBPJS() == null && entity.getPatientPaymentBPJSId() == null) {
			entityToUpdate.unsetPatientPaymentBPJS();
		} else if (entity.getPatientPaymentBPJSId() != null && entity.getPatientPaymentBPJS() == null) {
			Optional<PatientPaymentBPJSEntity> patientPaymentBPJSEntity = this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId());
			entityToUpdate.setPatientPaymentBPJS(patientPaymentBPJSEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPaymentBPJS() != null) {
			entityToUpdate.setPatientPaymentBPJS(entity.getPatientPaymentBPJS(), false);
			if (entityToUpdate.getPatientPaymentBPJSId() != null) {
				this.patientPaymentBPJSRepository.save(entityToUpdate.getPatientPaymentBPJS());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPaymentBPJS().unsetBpjsHospitalizationPlans();
			}
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
				entityToUpdate.getBpjsDoctorMapping().unsetKodedokter();
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
				entityToUpdate.getBpjsServiceMapping().unsetPolikontrol();
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
	public void validateEntity(BpjsHospitalizationPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsHospitalizationPlanEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsHospitalizationPlanEntity.
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

	public Set<String> validateEntityRelations(BpjsHospitalizationPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientPaymentBPJSId() != null && this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPaymentBPJSId() + " is not associated with a Patient Payment BPJS Entity");
		}

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
