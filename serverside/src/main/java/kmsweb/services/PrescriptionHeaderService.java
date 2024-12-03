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
import kmsweb.repositories.PrescriptionHeaderRepository;
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
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
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
public class PrescriptionHeaderService extends AbstractService<PrescriptionHeaderEntity, PrescriptionHeaderRepository, PrescriptionHeaderEntityAudit> {

	private final String[] referenceNamesInPrescriptionHeaderEntity = {
		"invoiceItems",
		"prescriptionCompounds",
		"prescriptionItems",
		"invoice",
		"registration",
		"requestedBy",
		"warehouse",
	};

	private final InvoiceRepository invoiceRepository;

	private final InvoiceItemRepository invoiceItemRepository;

	private final PrescriptionCompoundRepository prescriptionCompoundRepository;

	private final PrescriptionItemRepository prescriptionItemRepository;

	private final RegistrationRepository registrationRepository;

	private final StaffRepository staffRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PrescriptionHeaderService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceRepository invoiceRepository,
		InvoiceItemRepository invoiceItemRepository,
		PrescriptionCompoundRepository prescriptionCompoundRepository,
		PrescriptionItemRepository prescriptionItemRepository,
		RegistrationRepository registrationRepository,
		StaffRepository staffRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PrescriptionHeaderRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceRepository = invoiceRepository;

		this.invoiceItemRepository = invoiceItemRepository;

		this.prescriptionCompoundRepository = prescriptionCompoundRepository;

		this.prescriptionItemRepository = prescriptionItemRepository;

		this.registrationRepository = registrationRepository;

		this.staffRepository = staffRepository;

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Prescription Number.
	 *
	 * @param prescriptionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Number
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByPrescriptionNumber(String prescriptionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionNumber here] end
	{
		// % protected region % [Add any additional logic for findByPrescriptionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionNumber before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByPrescriptionNumber(prescriptionNumber));

		// % protected region % [Add any additional logic for findByPrescriptionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Prescription Type.
	 *
	 * @param prescriptionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Type
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByPrescriptionType(String prescriptionType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionType here] end
	{
		// % protected region % [Add any additional logic for findByPrescriptionType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionType before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByPrescriptionType(prescriptionType));

		// % protected region % [Add any additional logic for findByPrescriptionType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Queue No.
	 *
	 * @param queueNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Queue No
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByQueueNo(String queueNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByQueueNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQueueNo here] end
	{
		// % protected region % [Add any additional logic for findByQueueNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByQueueNo before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByQueueNo(queueNo));

		// % protected region % [Add any additional logic for findByQueueNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQueueNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Original Prescription Number.
	 *
	 * @param originalPrescriptionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original Prescription Number
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByOriginalPrescriptionNumber(String originalPrescriptionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalPrescriptionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalPrescriptionNumber here] end
	{
		// % protected region % [Add any additional logic for findByOriginalPrescriptionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByOriginalPrescriptionNumber before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByOriginalPrescriptionNumber(originalPrescriptionNumber));

		// % protected region % [Add any additional logic for findByOriginalPrescriptionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOriginalPrescriptionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Prescription Date.
	 *
	 * @param prescriptionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Date
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByPrescriptionDate(OffsetDateTime prescriptionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrescriptionDate here] end
	{
		// % protected region % [Add any additional logic for findByPrescriptionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionDate before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByPrescriptionDate(prescriptionDate));

		// % protected region % [Add any additional logic for findByPrescriptionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrescriptionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Compound.
	 *
	 * @param isCompound the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Compound
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByIsCompound(Boolean isCompound)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsCompound here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsCompound here] end
	{
		// % protected region % [Add any additional logic for findByIsCompound before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsCompound before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByIsCompound(isCompound));

		// % protected region % [Add any additional logic for findByIsCompound before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsCompound before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Iteration.
	 *
	 * @param isIteration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Iteration
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByIsIteration(Boolean isIteration)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsIteration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsIteration here] end
	{
		// % protected region % [Add any additional logic for findByIsIteration before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsIteration before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByIsIteration(isIteration));

		// % protected region % [Add any additional logic for findByIsIteration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsIteration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Urgent.
	 *
	 * @param isUrgent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Urgent
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByIsUrgent(Boolean isUrgent)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsUrgent here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsUrgent here] end
	{
		// % protected region % [Add any additional logic for findByIsUrgent before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsUrgent before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByIsUrgent(isUrgent));

		// % protected region % [Add any additional logic for findByIsUrgent before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsUrgent before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Restricted.
	 *
	 * @param restricted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Restricted
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByRestricted(Boolean restricted)
	// % protected region % [Add any throwables, implementations, or extensions for findByRestricted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRestricted here] end
	{
		// % protected region % [Add any additional logic for findByRestricted before the main body here] off begin
		// % protected region % [Add any additional logic for findByRestricted before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByRestricted(restricted));

		// % protected region % [Add any additional logic for findByRestricted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRestricted before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Revision No.
	 *
	 * @param revisionNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision No
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByRevisionNo(Integer revisionNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNo here] end
	{
		// % protected region % [Add any additional logic for findByRevisionNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevisionNo before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByRevisionNo(revisionNo));

		// % protected region % [Add any additional logic for findByRevisionNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRevisionNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Copy No.
	 *
	 * @param copyNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Copy No
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByCopyNo(Integer copyNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByCopyNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCopyNo here] end
	{
		// % protected region % [Add any additional logic for findByCopyNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByCopyNo before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByCopyNo(copyNo));

		// % protected region % [Add any additional logic for findByCopyNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCopyNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Invoiced.
	 *
	 * @param isInvoiced the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Invoiced
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByIsInvoiced(Boolean isInvoiced)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsInvoiced here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsInvoiced here] end
	{
		// % protected region % [Add any additional logic for findByIsInvoiced before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsInvoiced before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByIsInvoiced(isInvoiced));

		// % protected region % [Add any additional logic for findByIsInvoiced before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsInvoiced before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute External Warehouse.
	 *
	 * @param externalWarehouse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Warehouse
	 */
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findByExternalWarehouse(Boolean externalWarehouse)
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalWarehouse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalWarehouse here] end
	{
		// % protected region % [Add any additional logic for findByExternalWarehouse before the main body here] off begin
		// % protected region % [Add any additional logic for findByExternalWarehouse before the main body here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findByExternalWarehouse(externalWarehouse));

		// % protected region % [Add any additional logic for findByExternalWarehouse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExternalWarehouse before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PrescriptionHeaderEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PrescriptionHeaderEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PrescriptionHeaderEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create')")
	public PrescriptionHeaderEntity create(PrescriptionHeaderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PrescriptionHeaderEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create')")
	public PrescriptionHeaderEntity create(PrescriptionHeaderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PrescriptionHeaderEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PrescriptionHeaderEntity newEntity;

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create')")
	public List<PrescriptionHeaderEntity> createAll(Iterable<PrescriptionHeaderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PrescriptionHeaderEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PrescriptionHeaderEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'update')")
	public PrescriptionHeaderEntity update(PrescriptionHeaderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PrescriptionHeaderEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'update')")
	public PrescriptionHeaderEntity update(PrescriptionHeaderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PrescriptionHeaderEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PrescriptionHeaderEntity newEntity;

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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'update')")
	public List<PrescriptionHeaderEntity> updateAll(Iterable<PrescriptionHeaderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PrescriptionHeaderEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PrescriptionHeaderEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create') or hasPermission('PrescriptionHeaderEntity', 'update')")
	public PrescriptionHeaderEntity save(PrescriptionHeaderEntity entity) throws ConstraintViolationException
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

		PrescriptionHeaderEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'create') or hasPermission('PrescriptionHeaderEntity', 'update')")
	public List<PrescriptionHeaderEntity> saveAll(Iterable<PrescriptionHeaderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PrescriptionHeaderEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public List<PrescriptionHeaderEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public List<PrescriptionHeaderEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PrescriptionHeaderEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PrescriptionHeaderEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PrescriptionHeaderEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PrescriptionHeaderEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PrescriptionHeaderEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PrescriptionHeaderEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PrescriptionHeaderEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PrescriptionHeaderEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PrescriptionHeaderEntityAudits
	 */
	private List<PrescriptionHeaderEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PrescriptionHeaderEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param prescriptionHeader prescriptionHeader to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PrescriptionHeaderEntity updateAuditData(PrescriptionHeaderEntity prescriptionHeader)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return prescriptionHeader;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PrescriptionHeaderEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PrescriptionHeaderEntity entityAtRevision = updateAuditData((PrescriptionHeaderEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PrescriptionHeaderEntityAudit(
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

		QPrescriptionHeaderEntity entity = QPrescriptionHeaderEntity.prescriptionHeaderEntity;

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
			case "invoiceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Prescription Header here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Prescription Header here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Prescription Header here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Prescription Header here] end

				break;
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Prescription Headers here] end

				break;
			case "requestedById":
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.requestedBy.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Prescription Headers here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Prescription Headers here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Invoice Items here] end

				break;
			case "prescriptionCompoundsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription Header to Prescription Compounds here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription Header to Prescription Compounds here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionCompounds.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Prescription Header to Prescription Compounds here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Prescription Header to Prescription Compounds here] end

				break;
			case "prescriptionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Prescription Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Prescription to Prescription Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Prescription Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Prescription to Prescription Items here] end

				break;
			case "prescriptionNumber":
				// % protected region % [Add any additional logic before the query parameters of prescriptionNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of prescriptionNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of prescriptionNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of prescriptionNumber here] end

				break;
			case "prescriptionType":
				// % protected region % [Add any additional logic before the query parameters of prescriptionType here] off begin
				// % protected region % [Add any additional logic before the query parameters of prescriptionType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of prescriptionType here] off begin
				// % protected region % [Add any additional logic after the query parameters of prescriptionType here] end

				break;
			case "queueNo":
				// % protected region % [Add any additional logic before the query parameters of queueNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of queueNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.queueNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of queueNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of queueNo here] end

				break;
			case "originalPrescriptionNumber":
				// % protected region % [Add any additional logic before the query parameters of originalPrescriptionNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of originalPrescriptionNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.originalPrescriptionNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of originalPrescriptionNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of originalPrescriptionNumber here] end

				break;
			case "prescriptionDate":
				// % protected region % [Add any additional logic before the query parameters of prescriptionDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of prescriptionDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of prescriptionDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of prescriptionDate here] end

				break;
			case "isCompound":
				// % protected region % [Add any additional logic before the query parameters of isCompound here] off begin
				// % protected region % [Add any additional logic before the query parameters of isCompound here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isCompound, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isCompound here] off begin
				// % protected region % [Add any additional logic after the query parameters of isCompound here] end

				break;
			case "isIteration":
				// % protected region % [Add any additional logic before the query parameters of isIteration here] off begin
				// % protected region % [Add any additional logic before the query parameters of isIteration here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isIteration, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isIteration here] off begin
				// % protected region % [Add any additional logic after the query parameters of isIteration here] end

				break;
			case "status":
				// % protected region % [Add any additional logic before the query parameters of status here] off begin
				// % protected region % [Add any additional logic before the query parameters of status here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.status, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of status here] off begin
				// % protected region % [Add any additional logic after the query parameters of status here] end

				break;
			case "isUrgent":
				// % protected region % [Add any additional logic before the query parameters of isUrgent here] off begin
				// % protected region % [Add any additional logic before the query parameters of isUrgent here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isUrgent, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isUrgent here] off begin
				// % protected region % [Add any additional logic after the query parameters of isUrgent here] end

				break;
			case "restricted":
				// % protected region % [Add any additional logic before the query parameters of restricted here] off begin
				// % protected region % [Add any additional logic before the query parameters of restricted here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.restricted, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of restricted here] off begin
				// % protected region % [Add any additional logic after the query parameters of restricted here] end

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
	public PrescriptionHeaderEntity updateOldData(PrescriptionHeaderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PrescriptionHeaderEntity updateOldData(PrescriptionHeaderEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PrescriptionHeaderEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPrescriptionHeaderEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsCompound() == null) {
			entityToUpdate.setIsCompound(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsIteration() == null) {
			entityToUpdate.setIsIteration(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsUrgent() == null) {
			entityToUpdate.setIsUrgent(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getRestricted() == null) {
			entityToUpdate.setRestricted(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsInvoiced() == null) {
			entityToUpdate.setIsInvoiced(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getExternalWarehouse() == null) {
			entityToUpdate.setExternalWarehouse(false);
		}

		// Incoming One to One reference
		if (entity.getInvoice() == null && entity.getInvoiceId() == null) {
			entityToUpdate.unsetInvoice();
		} else if (entity.getInvoiceId() != null && entity.getInvoice() == null) {
			Optional<InvoiceEntity> invoiceEntity = this.invoiceRepository.findById(entity.getInvoiceId());
			entityToUpdate.setInvoice(invoiceEntity.orElseThrow());
		}
		if (persistRelations && entity.getInvoice() != null) {
			entityToUpdate.setInvoice(entity.getInvoice(), false);
			if (entityToUpdate.getInvoiceId() != null) {
				this.invoiceRepository.save(entityToUpdate.getInvoice());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInvoice().unsetPrescriptionHeader();
			}
		}

		// Incoming One to Many reference
		if (entity.getRegistration() == null && entity.getRegistrationId() == null) {
			entityToUpdate.unsetRegistration();
		} else if (entity.getRegistrationId() != null && entity.getRegistration() == null) {
			Optional<RegistrationEntity> registrationEntity = this.registrationRepository.findById(entity.getRegistrationId());
			entityToUpdate.setRegistration(registrationEntity.orElseThrow());
		}
		if (persistRelations && entity.getRegistration() != null) {
			entityToUpdate.setRegistration(entity.getRegistration(), false);
			if (entityToUpdate.getRegistrationId() != null) {
				this.registrationRepository.save(entityToUpdate.getRegistration());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRegistration().unsetPrescriptionHeaders();
			}
		}

		// Incoming One to Many reference
		if (entity.getRequestedBy() == null && entity.getRequestedById() == null) {
			entityToUpdate.unsetRequestedBy();
		} else if (entity.getRequestedById() != null && entity.getRequestedBy() == null) {
			Optional<StaffEntity> requestedByEntity = this.staffRepository.findById(entity.getRequestedById());
			entityToUpdate.setRequestedBy(requestedByEntity.orElseThrow());
		}
		if (persistRelations && entity.getRequestedBy() != null) {
			entityToUpdate.setRequestedBy(entity.getRequestedBy(), false);
			if (entityToUpdate.getRequestedById() != null) {
				this.staffRepository.save(entityToUpdate.getRequestedBy());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRequestedBy().unsetPrescriptionHeaders();
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
				entityToUpdate.getWarehouse().unsetPrescriptionHeaders();
			}
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			entityToUpdate.setInvoiceItems(new HashSet<>());
		} else if (!entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			Iterable<InvoiceItemEntity> invoiceItemsEntities =
					this.invoiceItemRepository.findAllById(entity.getInvoiceItemsIds());
			entityToUpdate.setInvoiceItems(Sets.newHashSet(invoiceItemsEntities));
		}
		if (persistRelations && !entity.getInvoiceItems().isEmpty()) {
			Set<InvoiceItemEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionCompoundsIds().isEmpty() && entity.getPrescriptionCompounds().isEmpty()) {
			entityToUpdate.setPrescriptionCompounds(new HashSet<>());
		} else if (!entity.getPrescriptionCompoundsIds().isEmpty() && entity.getPrescriptionCompounds().isEmpty()) {
			Iterable<PrescriptionCompoundEntity> prescriptionCompoundsEntities =
					this.prescriptionCompoundRepository.findAllById(entity.getPrescriptionCompoundsIds());
			entityToUpdate.setPrescriptionCompounds(Sets.newHashSet(prescriptionCompoundsEntities));
		}
		if (persistRelations && !entity.getPrescriptionCompounds().isEmpty()) {
			Set<PrescriptionCompoundEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionCompounds().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionCompoundRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionCompounds(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionItemsIds().isEmpty() && entity.getPrescriptionItems().isEmpty()) {
			entityToUpdate.setPrescriptionItems(new HashSet<>());
		} else if (!entity.getPrescriptionItemsIds().isEmpty() && entity.getPrescriptionItems().isEmpty()) {
			Iterable<PrescriptionItemEntity> prescriptionItemsEntities =
					this.prescriptionItemRepository.findAllById(entity.getPrescriptionItemsIds());
			entityToUpdate.setPrescriptionItems(Sets.newHashSet(prescriptionItemsEntities));
		}
		if (persistRelations && !entity.getPrescriptionItems().isEmpty()) {
			Set<PrescriptionItemEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionItems(updatedEntities);
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
	public void validateEntity(PrescriptionHeaderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PrescriptionHeaderEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PrescriptionHeaderEntity.
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

	public Set<String> validateEntityRelations(PrescriptionHeaderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInvoiceId() != null && this.invoiceRepository.findById(entity.getInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoiceId() + " is not associated with a Invoice Entity");
		}

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getRequestedById() != null && this.staffRepository.findById(entity.getRequestedById()).isEmpty()) {
			errors.add("The UUID " + entity.getRequestedById() + " is not associated with a Staff Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		for (UUID id : entity.getPrescriptionCompoundsIds()) {
			if (this.prescriptionCompoundRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Compound Entity");
			}
		}

		for (UUID id : entity.getPrescriptionItemsIds()) {
			if (this.prescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
