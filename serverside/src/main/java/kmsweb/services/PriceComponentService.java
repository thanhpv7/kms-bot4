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
import kmsweb.repositories.PriceComponentRepository;
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
import kmsweb.entities.InvoiceItemComponentEntity;
import kmsweb.repositories.InvoiceItemComponentRepository;
import kmsweb.entities.MedicalFeeItemComponentEntity;
import kmsweb.repositories.MedicalFeeItemComponentRepository;
import kmsweb.entities.TariffDefinitionOtherComponentEntity;
import kmsweb.repositories.TariffDefinitionOtherComponentRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PriceComponentService extends AbstractService<PriceComponentEntity, PriceComponentRepository, PriceComponentEntityAudit> {

	private final String[] referenceNamesInPriceComponentEntity = {
		"invoiceItemComponents",
		"medicalFeeItemComponents",
		"tariffDefinitionOtherComponents",
	};

	private final InvoiceItemComponentRepository invoiceItemComponentRepository;

	private final MedicalFeeItemComponentRepository medicalFeeItemComponentRepository;

	private final TariffDefinitionOtherComponentRepository tariffDefinitionOtherComponentRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PriceComponentService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceItemComponentRepository invoiceItemComponentRepository,
		MedicalFeeItemComponentRepository medicalFeeItemComponentRepository,
		TariffDefinitionOtherComponentRepository tariffDefinitionOtherComponentRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PriceComponentRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceItemComponentRepository = invoiceItemComponentRepository;

		this.medicalFeeItemComponentRepository = medicalFeeItemComponentRepository;

		this.tariffDefinitionOtherComponentRepository = tariffDefinitionOtherComponentRepository;

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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Component Code.
	 *
	 * @param componentCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Component Code
	 */
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PriceComponentEntity> findByComponentCode(String componentCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByComponentCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComponentCode here] end
	{
		// % protected region % [Add any additional logic for findByComponentCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByComponentCode before the main body here] end

		Optional<PriceComponentEntity> entity = repository.findByComponentCode(componentCode);

		// % protected region % [Add any additional logic for findByComponentCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByComponentCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Component Name.
	 *
	 * @param componentName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Component Name
	 */
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findByComponentName(String componentName)
	// % protected region % [Add any throwables, implementations, or extensions for findByComponentName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComponentName here] end
	{
		// % protected region % [Add any additional logic for findByComponentName before the main body here] off begin
		// % protected region % [Add any additional logic for findByComponentName before the main body here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findByComponentName(componentName));

		// % protected region % [Add any additional logic for findByComponentName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByComponentName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA COGS.
	 *
	 * @param coaCOGS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA COGS
	 */
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findByCoaCOGS(String coaCOGS)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaCOGS here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaCOGS here] end
	{
		// % protected region % [Add any additional logic for findByCoaCOGS before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaCOGS before the main body here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findByCoaCOGS(coaCOGS));

		// % protected region % [Add any additional logic for findByCoaCOGS before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaCOGS before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findByCoaSell(String coaSell)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] end
	{
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findByCoaSell(coaSell));

		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA Inventory.
	 *
	 * @param coaInventory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Inventory
	 */
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findByCoaInventory(String coaInventory)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaInventory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaInventory here] end
	{
		// % protected region % [Add any additional logic for findByCoaInventory before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaInventory before the main body here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findByCoaInventory(coaInventory));

		// % protected region % [Add any additional logic for findByCoaInventory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaInventory before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PriceComponentEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PriceComponentEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PriceComponentEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PriceComponentEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PriceComponentEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PriceComponentEntity', 'create')")
	public PriceComponentEntity create(PriceComponentEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PriceComponentEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PriceComponentEntity', 'create')")
	public PriceComponentEntity create(PriceComponentEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PriceComponentEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PriceComponentEntity newEntity;

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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'create')")
	public List<PriceComponentEntity> createAll(Iterable<PriceComponentEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PriceComponentEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PriceComponentEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PriceComponentEntity', 'update')")
	public PriceComponentEntity update(PriceComponentEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PriceComponentEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PriceComponentEntity', 'update')")
	public PriceComponentEntity update(PriceComponentEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PriceComponentEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PriceComponentEntity newEntity;

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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'update')")
	public List<PriceComponentEntity> updateAll(Iterable<PriceComponentEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PriceComponentEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PriceComponentEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'create') or hasPermission('PriceComponentEntity', 'update')")
	public PriceComponentEntity save(PriceComponentEntity entity) throws ConstraintViolationException
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

		PriceComponentEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'create') or hasPermission('PriceComponentEntity', 'update')")
	public List<PriceComponentEntity> saveAll(Iterable<PriceComponentEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PriceComponentEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	public List<PriceComponentEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	public List<PriceComponentEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PriceComponentEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PriceComponentEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PriceComponentEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PriceComponentEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PriceComponentEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PriceComponentEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PriceComponentEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PriceComponentEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PriceComponentEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PriceComponentEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PriceComponentEntityAudits
	 */
	private List<PriceComponentEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PriceComponentEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param priceComponent priceComponent to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PriceComponentEntity updateAuditData(PriceComponentEntity priceComponent)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return priceComponent;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PriceComponentEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PriceComponentEntity entityAtRevision = updateAuditData((PriceComponentEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PriceComponentEntityAudit(
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

		QPriceComponentEntity entity = QPriceComponentEntity.priceComponentEntity;

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
			case "invoiceItemComponentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Invoice Item Components here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Invoice Item Components here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItemComponents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Invoice Item Components here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Invoice Item Components here] end

				break;
			case "medicalFeeItemComponentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Medical Fee Item Components here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Medical Fee Item Components here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalFeeItemComponents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Medical Fee Item Components here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Medical Fee Item Components here] end

				break;
			case "tariffDefinitionOtherComponentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Tariff Definition Other Components here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Price Component to Tariff Definition Other Components here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffDefinitionOtherComponents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Tariff Definition Other Components here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Price Component to Tariff Definition Other Components here] end

				break;
			case "componentCode":
				// % protected region % [Add any additional logic before the query parameters of componentCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of componentCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.componentCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of componentCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of componentCode here] end

				break;
			case "componentName":
				// % protected region % [Add any additional logic before the query parameters of componentName here] off begin
				// % protected region % [Add any additional logic before the query parameters of componentName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.componentName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of componentName here] off begin
				// % protected region % [Add any additional logic after the query parameters of componentName here] end

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
	public PriceComponentEntity updateOldData(PriceComponentEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PriceComponentEntity updateOldData(PriceComponentEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PriceComponentEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPriceComponentEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemComponentsIds().isEmpty() && entity.getInvoiceItemComponents().isEmpty()) {
			entityToUpdate.setInvoiceItemComponents(new HashSet<>());
		} else if (!entity.getInvoiceItemComponentsIds().isEmpty() && entity.getInvoiceItemComponents().isEmpty()) {
			Iterable<InvoiceItemComponentEntity> invoiceItemComponentsEntities =
					this.invoiceItemComponentRepository.findAllById(entity.getInvoiceItemComponentsIds());
			entityToUpdate.setInvoiceItemComponents(Sets.newHashSet(invoiceItemComponentsEntities));
		}
		if (persistRelations && !entity.getInvoiceItemComponents().isEmpty()) {
			Set<InvoiceItemComponentEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItemComponents().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemComponentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItemComponents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalFeeItemComponentsIds().isEmpty() && entity.getMedicalFeeItemComponents().isEmpty()) {
			entityToUpdate.setMedicalFeeItemComponents(new HashSet<>());
		} else if (!entity.getMedicalFeeItemComponentsIds().isEmpty() && entity.getMedicalFeeItemComponents().isEmpty()) {
			Iterable<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities =
					this.medicalFeeItemComponentRepository.findAllById(entity.getMedicalFeeItemComponentsIds());
			entityToUpdate.setMedicalFeeItemComponents(Sets.newHashSet(medicalFeeItemComponentsEntities));
		}
		if (persistRelations && !entity.getMedicalFeeItemComponents().isEmpty()) {
			Set<MedicalFeeItemComponentEntity> updatedEntities = new HashSet<>();
			entity.getMedicalFeeItemComponents().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalFeeItemComponentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalFeeItemComponents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTariffDefinitionOtherComponentsIds().isEmpty() && entity.getTariffDefinitionOtherComponents().isEmpty()) {
			entityToUpdate.setTariffDefinitionOtherComponents(new HashSet<>());
		} else if (!entity.getTariffDefinitionOtherComponentsIds().isEmpty() && entity.getTariffDefinitionOtherComponents().isEmpty()) {
			Iterable<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponentsEntities =
					this.tariffDefinitionOtherComponentRepository.findAllById(entity.getTariffDefinitionOtherComponentsIds());
			entityToUpdate.setTariffDefinitionOtherComponents(Sets.newHashSet(tariffDefinitionOtherComponentsEntities));
		}
		if (persistRelations && !entity.getTariffDefinitionOtherComponents().isEmpty()) {
			Set<TariffDefinitionOtherComponentEntity> updatedEntities = new HashSet<>();
			entity.getTariffDefinitionOtherComponents().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffDefinitionOtherComponentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTariffDefinitionOtherComponents(updatedEntities);
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
	public void validateEntity(PriceComponentEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PriceComponentEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByComponentCodeOpt = this.findByComponentCode(entity.getComponentCode());
			if (entityByComponentCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<PriceComponentEntity>(
						"Component Code",
						entity.getComponentCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ComponentCode"
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
	 * Get the sort as given by the sort by for the PriceComponentEntity.
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

	public Set<String> validateEntityRelations(PriceComponentEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getInvoiceItemComponentsIds()) {
			if (this.invoiceItemComponentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Component Entity");
			}
		}

		for (UUID id : entity.getMedicalFeeItemComponentsIds()) {
			if (this.medicalFeeItemComponentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Fee Item Component Entity");
			}
		}

		for (UUID id : entity.getTariffDefinitionOtherComponentsIds()) {
			if (this.tariffDefinitionOtherComponentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Definition Other Component Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
