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
import kmsweb.repositories.GoodsReceiveNoteRepository;
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
import kmsweb.entities.enums.*;
import java.time.*;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
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
public class GoodsReceiveNoteService extends AbstractService<GoodsReceiveNoteEntity, GoodsReceiveNoteRepository, GoodsReceiveNoteEntityAudit> {

	private final String[] referenceNamesInGoodsReceiveNoteEntity = {
		"goodsReceiveNoteItems",
		"purchaseOrders",
		"supplier",
		"warehouse",
	};

	private final GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final SupplierRepository supplierRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public GoodsReceiveNoteService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository,
		PurchaseOrderRepository purchaseOrderRepository,
		SupplierRepository supplierRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		GoodsReceiveNoteRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.goodsReceiveNoteItemRepository = goodsReceiveNoteItemRepository;

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.supplierRepository = supplierRepository;

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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Receive Number.
	 *
	 * @param receiveNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Number
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<GoodsReceiveNoteEntity> findByReceiveNumber(String receiveNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveNumber here] end
	{
		// % protected region % [Add any additional logic for findByReceiveNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceiveNumber before the main body here] end

		Optional<GoodsReceiveNoteEntity> entity = repository.findByReceiveNumber(receiveNumber);

		// % protected region % [Add any additional logic for findByReceiveNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByReceiveNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Source Document Type.
	 *
	 * @param sourceDocumentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Document Type
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findBySourceDocumentType(GrnSourceTypeEnum sourceDocumentType)
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceDocumentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceDocumentType here] end
	{
		// % protected region % [Add any additional logic for findBySourceDocumentType before the main body here] off begin
		// % protected region % [Add any additional logic for findBySourceDocumentType before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findBySourceDocumentType(sourceDocumentType));

		// % protected region % [Add any additional logic for findBySourceDocumentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySourceDocumentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Source Document Number.
	 *
	 * @param sourceDocumentNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Document Number
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findBySourceDocumentNumber(String sourceDocumentNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceDocumentNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceDocumentNumber here] end
	{
		// % protected region % [Add any additional logic for findBySourceDocumentNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySourceDocumentNumber before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findBySourceDocumentNumber(sourceDocumentNumber));

		// % protected region % [Add any additional logic for findBySourceDocumentNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySourceDocumentNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Receive Date.
	 *
	 * @param receiveDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Date
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByReceiveDate(OffsetDateTime receiveDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceiveDate here] end
	{
		// % protected region % [Add any additional logic for findByReceiveDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceiveDate before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByReceiveDate(receiveDate));

		// % protected region % [Add any additional logic for findByReceiveDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceiveDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByVoidDate(OffsetDateTime voidDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] end
	{
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByVoidDate(voidDate));

		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByApprovalStatus(String approvalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] end
	{
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByApprovalStatus(approvalStatus));

		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Invoice Number.
	 *
	 * @param supplierInvoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Invoice Number
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findBySupplierInvoiceNumber(String supplierInvoiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierInvoiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierInvoiceNumber here] end
	{
		// % protected region % [Add any additional logic for findBySupplierInvoiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierInvoiceNumber before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findBySupplierInvoiceNumber(supplierInvoiceNumber));

		// % protected region % [Add any additional logic for findBySupplierInvoiceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplierInvoiceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByShippingMethod(String shippingMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingMethod here] end
	{
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByShippingMethod(shippingMethod));

		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShippingMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Number.
	 *
	 * @param shippingNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Number
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByShippingNumber(String shippingNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingNumber here] end
	{
		// % protected region % [Add any additional logic for findByShippingNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByShippingNumber before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByShippingNumber(shippingNumber));

		// % protected region % [Add any additional logic for findByShippingNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShippingNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Date.
	 *
	 * @param shippingDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Date
	 */
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findByShippingDate(OffsetDateTime shippingDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShippingDate here] end
	{
		// % protected region % [Add any additional logic for findByShippingDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByShippingDate before the main body here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findByShippingDate(shippingDate));

		// % protected region % [Add any additional logic for findByShippingDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShippingDate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<GoodsReceiveNoteEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<GoodsReceiveNoteEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<GoodsReceiveNoteEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'create')")
	public GoodsReceiveNoteEntity create(GoodsReceiveNoteEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		GoodsReceiveNoteEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'create')")
	public GoodsReceiveNoteEntity create(GoodsReceiveNoteEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		GoodsReceiveNoteEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		GoodsReceiveNoteEntity newEntity;

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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'create')")
	public List<GoodsReceiveNoteEntity> createAll(Iterable<GoodsReceiveNoteEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<GoodsReceiveNoteEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<GoodsReceiveNoteEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'update')")
	public GoodsReceiveNoteEntity update(GoodsReceiveNoteEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		GoodsReceiveNoteEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'update')")
	public GoodsReceiveNoteEntity update(GoodsReceiveNoteEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		GoodsReceiveNoteEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		GoodsReceiveNoteEntity newEntity;

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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'update')")
	public List<GoodsReceiveNoteEntity> updateAll(Iterable<GoodsReceiveNoteEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<GoodsReceiveNoteEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<GoodsReceiveNoteEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'create') or hasPermission('GoodsReceiveNoteEntity', 'update')")
	public GoodsReceiveNoteEntity save(GoodsReceiveNoteEntity entity) throws ConstraintViolationException
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

		GoodsReceiveNoteEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'create') or hasPermission('GoodsReceiveNoteEntity', 'update')")
	public List<GoodsReceiveNoteEntity> saveAll(Iterable<GoodsReceiveNoteEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<GoodsReceiveNoteEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'delete')")
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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'delete')")
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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	public List<GoodsReceiveNoteEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	public List<GoodsReceiveNoteEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(GoodsReceiveNoteEntity.class);

		// % protected region % [Add any additional processing before converting to a list of GoodsReceiveNoteEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of GoodsReceiveNoteEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<GoodsReceiveNoteEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of GoodsReceiveNoteEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of GoodsReceiveNoteEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(GoodsReceiveNoteEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of GoodsReceiveNoteEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of GoodsReceiveNoteEntityAudits
	 */
	private List<GoodsReceiveNoteEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<GoodsReceiveNoteEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param goodsReceiveNote goodsReceiveNote to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private GoodsReceiveNoteEntity updateAuditData(GoodsReceiveNoteEntity goodsReceiveNote)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return goodsReceiveNote;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private GoodsReceiveNoteEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		GoodsReceiveNoteEntity entityAtRevision = updateAuditData((GoodsReceiveNoteEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new GoodsReceiveNoteEntityAudit(
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

		QGoodsReceiveNoteEntity entity = QGoodsReceiveNoteEntity.goodsReceiveNoteEntity;

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
			case "supplierId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Goods Receive Notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplier.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Goods Receive Notes here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Goods Receive Notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Goods Receive Notes here] end

				break;
			case "goodsReceiveNoteItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Goods Receive Note Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNoteItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Goods Receive Note Items here] end

				break;
			case "purchaseOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Purchase Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Goods Receive Note to Purchase Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Purchase Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Goods Receive Note to Purchase Orders here] end

				break;
			case "receiveNumber":
				// % protected region % [Add any additional logic before the query parameters of receiveNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of receiveNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.receiveNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of receiveNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of receiveNumber here] end

				break;
			case "sourceDocumentType":
				// % protected region % [Add any additional logic before the query parameters of sourceDocumentType here] off begin
				// % protected region % [Add any additional logic before the query parameters of sourceDocumentType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sourceDocumentType, GrnSourceTypeEnum.class, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sourceDocumentType here] off begin
				// % protected region % [Add any additional logic after the query parameters of sourceDocumentType here] end

				break;
			case "sourceDocumentNumber":
				// % protected region % [Add any additional logic before the query parameters of sourceDocumentNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of sourceDocumentNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sourceDocumentNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sourceDocumentNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of sourceDocumentNumber here] end

				break;
			case "receiveDate":
				// % protected region % [Add any additional logic before the query parameters of receiveDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of receiveDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.receiveDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of receiveDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of receiveDate here] end

				break;
			case "approvalStatus":
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.approvalStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] end

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
	public GoodsReceiveNoteEntity updateOldData(GoodsReceiveNoteEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public GoodsReceiveNoteEntity updateOldData(GoodsReceiveNoteEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		GoodsReceiveNoteEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInGoodsReceiveNoteEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getSupplier() == null && entity.getSupplierId() == null) {
			entityToUpdate.unsetSupplier();
		} else if (entity.getSupplierId() != null && entity.getSupplier() == null) {
			Optional<SupplierEntity> supplierEntity = this.supplierRepository.findById(entity.getSupplierId());
			entityToUpdate.setSupplier(supplierEntity.orElseThrow());
		}
		if (persistRelations && entity.getSupplier() != null) {
			entityToUpdate.setSupplier(entity.getSupplier(), false);
			if (entityToUpdate.getSupplierId() != null) {
				this.supplierRepository.save(entityToUpdate.getSupplier());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSupplier().unsetGoodsReceiveNotes();
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
				entityToUpdate.getWarehouse().unsetGoodsReceiveNotes();
			}
		}

		// Outgoing one to many reference
		if (entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			entityToUpdate.setGoodsReceiveNoteItems(new HashSet<>());
		} else if (!entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			Iterable<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities =
					this.goodsReceiveNoteItemRepository.findAllById(entity.getGoodsReceiveNoteItemsIds());
			entityToUpdate.setGoodsReceiveNoteItems(Sets.newHashSet(goodsReceiveNoteItemsEntities));
		}
		if (persistRelations && !entity.getGoodsReceiveNoteItems().isEmpty()) {
			Set<GoodsReceiveNoteItemEntity> updatedEntities = new HashSet<>();
			entity.getGoodsReceiveNoteItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.goodsReceiveNoteItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setGoodsReceiveNoteItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPurchaseOrdersIds().isEmpty() && entity.getPurchaseOrders().isEmpty()) {
			entityToUpdate.setPurchaseOrders(new HashSet<>());
		} else if (!entity.getPurchaseOrdersIds().isEmpty() && entity.getPurchaseOrders().isEmpty()) {
			Iterable<PurchaseOrderEntity> purchaseOrdersEntities =
					this.purchaseOrderRepository.findAllById(entity.getPurchaseOrdersIds());
			entityToUpdate.setPurchaseOrders(Sets.newHashSet(purchaseOrdersEntities));
		}
		if (persistRelations && !entity.getPurchaseOrders().isEmpty()) {
			Set<PurchaseOrderEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseOrders().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseOrders(updatedEntities);
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
	public void validateEntity(GoodsReceiveNoteEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<GoodsReceiveNoteEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByReceiveNumberOpt = this.findByReceiveNumber(entity.getReceiveNumber());
			if (entityByReceiveNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<GoodsReceiveNoteEntity>(
						"Receive Number",
						entity.getReceiveNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ReceiveNumber"
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
	 * Get the sort as given by the sort by for the GoodsReceiveNoteEntity.
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

	public Set<String> validateEntityRelations(GoodsReceiveNoteEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getSupplierId() != null && this.supplierRepository.findById(entity.getSupplierId()).isEmpty()) {
			errors.add("The UUID " + entity.getSupplierId() + " is not associated with a Supplier Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getGoodsReceiveNoteItemsIds()) {
			if (this.goodsReceiveNoteItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Item Entity");
			}
		}

		for (UUID id : entity.getPurchaseOrdersIds()) {
			if (this.purchaseOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Order Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}