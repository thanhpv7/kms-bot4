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
import kmsweb.repositories.RetailPharmacyRepository;
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
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class RetailPharmacyService extends AbstractService<RetailPharmacyEntity, RetailPharmacyRepository, RetailPharmacyEntityAudit> {

	private final String[] referenceNamesInRetailPharmacyEntity = {
		"retailPharmacyInvoices",
		"retailPharmacyStockDetails",
		"patientGeneralInfo",
		"warehouse",
	};

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private final RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	private final RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RetailPharmacyService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository,
		RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		RetailPharmacyRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.patientGeneralInfoRepository = patientGeneralInfoRepository;

		this.retailPharmacyInvoiceRepository = retailPharmacyInvoiceRepository;

		this.retailPharmacyStockDetailRepository = retailPharmacyStockDetailRepository;

		this.warehouseRepository = warehouseRepository;

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Customer Type.
	 *
	 * @param customerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Type
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByCustomerType(String customerType)
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerType here] end
	{
		// % protected region % [Add any additional logic for findByCustomerType before the main body here] off begin
		// % protected region % [Add any additional logic for findByCustomerType before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByCustomerType(customerType));

		// % protected region % [Add any additional logic for findByCustomerType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCustomerType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Retail Number.
	 *
	 * @param retailNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Retail Number
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByRetailNumber(String retailNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByRetailNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRetailNumber here] end
	{
		// % protected region % [Add any additional logic for findByRetailNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByRetailNumber before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByRetailNumber(retailNumber));

		// % protected region % [Add any additional logic for findByRetailNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRetailNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByCustomerName(String customerName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] end
	{
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByCustomerName(customerName));

		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Status.
	 *
	 * @param paymentStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Status
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByPaymentStatus(String paymentStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentStatus here] end
	{
		// % protected region % [Add any additional logic for findByPaymentStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentStatus before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByPaymentStatus(paymentStatus));

		// % protected region % [Add any additional logic for findByPaymentStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findByTotalPrice(Double totalPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] end
	{
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findByTotalPrice(totalPrice));

		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<RetailPharmacyEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<RetailPharmacyEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<RetailPharmacyEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<RetailPharmacyEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create')")
	public RetailPharmacyEntity create(RetailPharmacyEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		RetailPharmacyEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create')")
	public RetailPharmacyEntity create(RetailPharmacyEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		RetailPharmacyEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		RetailPharmacyEntity newEntity;

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create')")
	public List<RetailPharmacyEntity> createAll(Iterable<RetailPharmacyEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<RetailPharmacyEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<RetailPharmacyEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'update')")
	public RetailPharmacyEntity update(RetailPharmacyEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		RetailPharmacyEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'update')")
	public RetailPharmacyEntity update(RetailPharmacyEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		RetailPharmacyEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		RetailPharmacyEntity newEntity;

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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'update')")
	public List<RetailPharmacyEntity> updateAll(Iterable<RetailPharmacyEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<RetailPharmacyEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<RetailPharmacyEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create') or hasPermission('RetailPharmacyEntity', 'update')")
	public RetailPharmacyEntity save(RetailPharmacyEntity entity) throws ConstraintViolationException
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

		RetailPharmacyEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'create') or hasPermission('RetailPharmacyEntity', 'update')")
	public List<RetailPharmacyEntity> saveAll(Iterable<RetailPharmacyEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<RetailPharmacyEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	public List<RetailPharmacyEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	public List<RetailPharmacyEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(RetailPharmacyEntity.class);

		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RetailPharmacyEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(RetailPharmacyEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of RetailPharmacyEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of RetailPharmacyEntityAudits
	 */
	private List<RetailPharmacyEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<RetailPharmacyEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param retailPharmacy retailPharmacy to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private RetailPharmacyEntity updateAuditData(RetailPharmacyEntity retailPharmacy)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return retailPharmacy;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private RetailPharmacyEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		RetailPharmacyEntity entityAtRevision = updateAuditData((RetailPharmacyEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new RetailPharmacyEntityAudit(
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

		QRetailPharmacyEntity entity = QRetailPharmacyEntity.retailPharmacyEntity;

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
			case "patientGeneralInfoId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Retail Pharmacies here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientGeneralInfo.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Retail Pharmacies here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Retail Pharmacies here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Retail Pharmacies here] end

				break;
			case "retailPharmacyInvoicesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyInvoices.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] end

				break;
			case "retailPharmacyStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Stock Details here] end

				break;
			case "customerType":
				// % protected region % [Add any additional logic before the query parameters of customerType here] off begin
				// % protected region % [Add any additional logic before the query parameters of customerType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.customerType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of customerType here] off begin
				// % protected region % [Add any additional logic after the query parameters of customerType here] end

				break;
			case "status":
				// % protected region % [Add any additional logic before the query parameters of status here] off begin
				// % protected region % [Add any additional logic before the query parameters of status here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.status, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of status here] off begin
				// % protected region % [Add any additional logic after the query parameters of status here] end

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
	public RetailPharmacyEntity updateOldData(RetailPharmacyEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public RetailPharmacyEntity updateOldData(RetailPharmacyEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		RetailPharmacyEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInRetailPharmacyEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPatientGeneralInfo() == null && entity.getPatientGeneralInfoId() == null) {
			entityToUpdate.unsetPatientGeneralInfo();
		} else if (entity.getPatientGeneralInfoId() != null && entity.getPatientGeneralInfo() == null) {
			Optional<PatientGeneralInfoEntity> patientGeneralInfoEntity = this.patientGeneralInfoRepository.findById(entity.getPatientGeneralInfoId());
			entityToUpdate.setPatientGeneralInfo(patientGeneralInfoEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientGeneralInfo() != null) {
			entityToUpdate.setPatientGeneralInfo(entity.getPatientGeneralInfo(), false);
			if (entityToUpdate.getPatientGeneralInfoId() != null) {
				this.patientGeneralInfoRepository.save(entityToUpdate.getPatientGeneralInfo());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientGeneralInfo().unsetRetailPharmacies();
			}
		}

		// Incoming One to Many reference
		if (entity.getWarehouse() == null && entity.getWarehouseId() == null) {
			entityToUpdate.unsetWarehouse();
		} else if (entity.getWarehouseId() != null && entity.getWarehouse() == null) {
			Optional<WarehouseEntity> warehouseEntity = this.warehouseRepository.findById(entity.getWarehouseId());
			entityToUpdate.setWarehouse(warehouseEntity.orElseThrow());
		}
		if (persistRelations && entity.getWarehouse() != null) {
			entityToUpdate.setWarehouse(entity.getWarehouse(), false);
			if (entityToUpdate.getWarehouseId() != null) {
				this.warehouseRepository.save(entityToUpdate.getWarehouse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getWarehouse().unsetRetailPharmacies();
			}
		}

		// Outgoing one to many reference
		if (entity.getRetailPharmacyInvoicesIds().isEmpty() && entity.getRetailPharmacyInvoices().isEmpty()) {
			entityToUpdate.setRetailPharmacyInvoices(new HashSet<>());
		} else if (!entity.getRetailPharmacyInvoicesIds().isEmpty() && entity.getRetailPharmacyInvoices().isEmpty()) {
			Iterable<RetailPharmacyInvoiceEntity> retailPharmacyInvoicesEntities =
					this.retailPharmacyInvoiceRepository.findAllById(entity.getRetailPharmacyInvoicesIds());
			entityToUpdate.setRetailPharmacyInvoices(Sets.newHashSet(retailPharmacyInvoicesEntities));
		}
		if (persistRelations && !entity.getRetailPharmacyInvoices().isEmpty()) {
			Set<RetailPharmacyInvoiceEntity> updatedEntities = new HashSet<>();
			entity.getRetailPharmacyInvoices().forEach(model -> {
				if (model.getId() != null) {
					model = this.retailPharmacyInvoiceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRetailPharmacyInvoices(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRetailPharmacyStockDetailsIds().isEmpty() && entity.getRetailPharmacyStockDetails().isEmpty()) {
			entityToUpdate.setRetailPharmacyStockDetails(new HashSet<>());
		} else if (!entity.getRetailPharmacyStockDetailsIds().isEmpty() && entity.getRetailPharmacyStockDetails().isEmpty()) {
			Iterable<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities =
					this.retailPharmacyStockDetailRepository.findAllById(entity.getRetailPharmacyStockDetailsIds());
			entityToUpdate.setRetailPharmacyStockDetails(Sets.newHashSet(retailPharmacyStockDetailsEntities));
		}
		if (persistRelations && !entity.getRetailPharmacyStockDetails().isEmpty()) {
			Set<RetailPharmacyStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getRetailPharmacyStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.retailPharmacyStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRetailPharmacyStockDetails(updatedEntities);
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
	public void validateEntity(RetailPharmacyEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<RetailPharmacyEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the RetailPharmacyEntity.
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

	public Set<String> validateEntityRelations(RetailPharmacyEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientGeneralInfoId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientGeneralInfoId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientGeneralInfoId() + " is not associated with a Patient General Info Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getRetailPharmacyInvoicesIds()) {
			if (this.retailPharmacyInvoiceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Retail Pharmacy Invoice Entity");
			}
		}

		for (UUID id : entity.getRetailPharmacyStockDetailsIds()) {
			if (this.retailPharmacyStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Retail Pharmacy Stock Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
