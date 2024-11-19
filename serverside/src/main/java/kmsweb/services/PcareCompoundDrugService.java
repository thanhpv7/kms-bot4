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
import kmsweb.repositories.PcareCompoundDrugRepository;
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
import kmsweb.entities.PcareCompoundDrugItemEntity;
import kmsweb.repositories.PcareCompoundDrugItemRepository;
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.repositories.PcareExaminationRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PcareCompoundDrugService extends AbstractService<PcareCompoundDrugEntity, PcareCompoundDrugRepository, PcareCompoundDrugEntityAudit> {

	private final String[] referenceNamesInPcareCompoundDrugEntity = {
		"pcareCompoundDrugItems",
		"pcareExamination",
	};

	private final PcareCompoundDrugItemRepository pcareCompoundDrugItemRepository;

	private final PcareExaminationRepository pcareExaminationRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PcareCompoundDrugService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PcareCompoundDrugItemRepository pcareCompoundDrugItemRepository,
		PcareExaminationRepository pcareExaminationRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PcareCompoundDrugRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.pcareCompoundDrugItemRepository = pcareCompoundDrugItemRepository;

		this.pcareExaminationRepository = pcareExaminationRepository;

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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Compound Name.
	 *
	 * @param compoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Name
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByCompoundName(String compoundName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] end
	{
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByCompoundName(compoundName));

		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Signa Days.
	 *
	 * @param signaDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Signa Days
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findBySignaDays(Double signaDays)
	// % protected region % [Add any throwables, implementations, or extensions for findBySignaDays here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySignaDays here] end
	{
		// % protected region % [Add any additional logic for findBySignaDays before the main body here] off begin
		// % protected region % [Add any additional logic for findBySignaDays before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findBySignaDays(signaDays));

		// % protected region % [Add any additional logic for findBySignaDays before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySignaDays before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Signa Times.
	 *
	 * @param signaTimes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Signa Times
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findBySignaTimes(Integer signaTimes)
	// % protected region % [Add any throwables, implementations, or extensions for findBySignaTimes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySignaTimes here] end
	{
		// % protected region % [Add any additional logic for findBySignaTimes before the main body here] off begin
		// % protected region % [Add any additional logic for findBySignaTimes before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findBySignaTimes(signaTimes));

		// % protected region % [Add any additional logic for findBySignaTimes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySignaTimes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Package Qty.
	 *
	 * @param packageQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Package Qty
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByPackageQty(Double packageQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByPackageQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPackageQty here] end
	{
		// % protected region % [Add any additional logic for findByPackageQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByPackageQty before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByPackageQty(packageQty));

		// % protected region % [Add any additional logic for findByPackageQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPackageQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Day.
	 *
	 * @param day the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Day
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByDay(Double day)
	// % protected region % [Add any throwables, implementations, or extensions for findByDay here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDay here] end
	{
		// % protected region % [Add any additional logic for findByDay before the main body here] off begin
		// % protected region % [Add any additional logic for findByDay before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByDay(day));

		// % protected region % [Add any additional logic for findByDay before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDay before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Request Qty.
	 *
	 * @param requestQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Request Qty
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByRequestQty(Integer requestQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestQty here] end
	{
		// % protected region % [Add any additional logic for findByRequestQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByRequestQty before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByRequestQty(requestQty));

		// % protected region % [Add any additional logic for findByRequestQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRequestQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Kd Obat SK.
	 *
	 * @param kdObatSK the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kd Obat SK
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByKdObatSK(String kdObatSK)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdObatSK here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdObatSK here] end
	{
		// % protected region % [Add any additional logic for findByKdObatSK before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdObatSK before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByKdObatSK(kdObatSK));

		// % protected region % [Add any additional logic for findByKdObatSK before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdObatSK before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Racikan.
	 *
	 * @param racikan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Racikan
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByRacikan(Boolean racikan)
	// % protected region % [Add any throwables, implementations, or extensions for findByRacikan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRacikan here] end
	{
		// % protected region % [Add any additional logic for findByRacikan before the main body here] off begin
		// % protected region % [Add any additional logic for findByRacikan before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByRacikan(racikan));

		// % protected region % [Add any additional logic for findByRacikan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRacikan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Kd Racikan.
	 *
	 * @param kdRacikan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kd Racikan
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByKdRacikan(String kdRacikan)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdRacikan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdRacikan here] end
	{
		// % protected region % [Add any additional logic for findByKdRacikan before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdRacikan before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByKdRacikan(kdRacikan));

		// % protected region % [Add any additional logic for findByKdRacikan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdRacikan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nama Obat Non DPHO.
	 *
	 * @param namaObatNonDPHO the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nama Obat Non DPHO
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByNamaObatNonDPHO(String namaObatNonDPHO)
	// % protected region % [Add any throwables, implementations, or extensions for findByNamaObatNonDPHO here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNamaObatNonDPHO here] end
	{
		// % protected region % [Add any additional logic for findByNamaObatNonDPHO before the main body here] off begin
		// % protected region % [Add any additional logic for findByNamaObatNonDPHO before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByNamaObatNonDPHO(namaObatNonDPHO));

		// % protected region % [Add any additional logic for findByNamaObatNonDPHO before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNamaObatNonDPHO before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Drug Qty.
	 *
	 * @param drugQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drug Qty
	 */
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findByDrugQty(Double drugQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugQty here] end
	{
		// % protected region % [Add any additional logic for findByDrugQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrugQty before the main body here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findByDrugQty(drugQty));

		// % protected region % [Add any additional logic for findByDrugQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrugQty before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PcareCompoundDrugEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PcareCompoundDrugEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PcareCompoundDrugEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'create')")
	public PcareCompoundDrugEntity create(PcareCompoundDrugEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PcareCompoundDrugEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'create')")
	public PcareCompoundDrugEntity create(PcareCompoundDrugEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PcareCompoundDrugEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PcareCompoundDrugEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'create')")
	public List<PcareCompoundDrugEntity> createAll(Iterable<PcareCompoundDrugEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PcareCompoundDrugEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PcareCompoundDrugEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'update')")
	public PcareCompoundDrugEntity update(PcareCompoundDrugEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PcareCompoundDrugEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'update')")
	public PcareCompoundDrugEntity update(PcareCompoundDrugEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PcareCompoundDrugEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PcareCompoundDrugEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'update')")
	public List<PcareCompoundDrugEntity> updateAll(Iterable<PcareCompoundDrugEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PcareCompoundDrugEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PcareCompoundDrugEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'create') or hasPermission('PcareCompoundDrugEntity', 'update')")
	public PcareCompoundDrugEntity save(PcareCompoundDrugEntity entity) throws ConstraintViolationException
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

		PcareCompoundDrugEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'create') or hasPermission('PcareCompoundDrugEntity', 'update')")
	public List<PcareCompoundDrugEntity> saveAll(Iterable<PcareCompoundDrugEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PcareCompoundDrugEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	public List<PcareCompoundDrugEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	public List<PcareCompoundDrugEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PcareCompoundDrugEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PcareCompoundDrugEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareCompoundDrugEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PcareCompoundDrugEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareCompoundDrugEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PcareCompoundDrugEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareCompoundDrugEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PcareCompoundDrugEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PcareCompoundDrugEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PcareCompoundDrugEntityAudits
	 */
	private List<PcareCompoundDrugEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PcareCompoundDrugEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param pcareCompoundDrug pcareCompoundDrug to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PcareCompoundDrugEntity updateAuditData(PcareCompoundDrugEntity pcareCompoundDrug)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return pcareCompoundDrug;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PcareCompoundDrugEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PcareCompoundDrugEntity entityAtRevision = updateAuditData((PcareCompoundDrugEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PcareCompoundDrugEntityAudit(
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

		QPcareCompoundDrugEntity entity = QPcareCompoundDrugEntity.pcareCompoundDrugEntity;

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
			case "pcareExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Compound Drugs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Compound Drugs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Compound Drugs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Compound Drugs here] end

				break;
			case "pcareCompoundDrugItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Compound Drug to PCare Compound Drug Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Compound Drug to PCare Compound Drug Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareCompoundDrugItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from PCare Compound Drug to PCare Compound Drug Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from PCare Compound Drug to PCare Compound Drug Items here] end

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
	public PcareCompoundDrugEntity updateOldData(PcareCompoundDrugEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PcareCompoundDrugEntity updateOldData(PcareCompoundDrugEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PcareCompoundDrugEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPcareCompoundDrugEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getRacikan() == null) {
			entityToUpdate.setRacikan(false);
		}

		// Incoming One to Many reference
		if (entity.getPcareExamination() == null && entity.getPcareExaminationId() == null) {
			entityToUpdate.unsetPcareExamination();
		} else if (entity.getPcareExaminationId() != null && entity.getPcareExamination() == null) {
			Optional<PcareExaminationEntity> pcareExaminationEntity = this.pcareExaminationRepository.findById(entity.getPcareExaminationId());
			entityToUpdate.setPcareExamination(pcareExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getPcareExamination() != null) {
			entityToUpdate.setPcareExamination(entity.getPcareExamination(), false);
			if (entityToUpdate.getPcareExaminationId() != null) {
				this.pcareExaminationRepository.save(entityToUpdate.getPcareExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPcareExamination().unsetPcareCompoundDrugs();
			}
		}

		// Outgoing one to many reference
		if (entity.getPcareCompoundDrugItemsIds().isEmpty() && entity.getPcareCompoundDrugItems().isEmpty()) {
			entityToUpdate.setPcareCompoundDrugItems(new HashSet<>());
		} else if (!entity.getPcareCompoundDrugItemsIds().isEmpty() && entity.getPcareCompoundDrugItems().isEmpty()) {
			Iterable<PcareCompoundDrugItemEntity> pcareCompoundDrugItemsEntities =
					this.pcareCompoundDrugItemRepository.findAllById(entity.getPcareCompoundDrugItemsIds());
			entityToUpdate.setPcareCompoundDrugItems(Sets.newHashSet(pcareCompoundDrugItemsEntities));
		}
		if (persistRelations && !entity.getPcareCompoundDrugItems().isEmpty()) {
			Set<PcareCompoundDrugItemEntity> updatedEntities = new HashSet<>();
			entity.getPcareCompoundDrugItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.pcareCompoundDrugItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPcareCompoundDrugItems(updatedEntities);
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
	public void validateEntity(PcareCompoundDrugEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PcareCompoundDrugEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PcareCompoundDrugEntity.
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

	public Set<String> validateEntityRelations(PcareCompoundDrugEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPcareExaminationId() != null && this.pcareExaminationRepository.findById(entity.getPcareExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getPcareExaminationId() + " is not associated with a PCare Examination Entity");
		}

		for (UUID id : entity.getPcareCompoundDrugItemsIds()) {
			if (this.pcareCompoundDrugItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a PCare Compound Drug Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
