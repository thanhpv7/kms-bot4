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
import kmsweb.repositories.InvoiceSummaryRepository;
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
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InvoiceSummaryService extends AbstractService<InvoiceSummaryEntity, InvoiceSummaryRepository, InvoiceSummaryEntityAudit> {

	private final String[] referenceNamesInInvoiceSummaryEntity = {
		"invoice",
		"retailPharmacyInvoice",
	};

	private final InvoiceRepository invoiceRepository;

	private final RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceSummaryService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceRepository invoiceRepository,
		RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InvoiceSummaryRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceRepository = invoiceRepository;

		this.retailPharmacyInvoiceRepository = retailPharmacyInvoiceRepository;

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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findBySubTotal(Double subTotal)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubTotal here] end
	{
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findBySubTotal(subTotal));

		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubTotal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax On Other Discount.
	 *
	 * @param taxOnOtherDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax On Other Discount
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByTaxOnOtherDiscount(Boolean taxOnOtherDiscount)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxOnOtherDiscount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxOnOtherDiscount here] end
	{
		// % protected region % [Add any additional logic for findByTaxOnOtherDiscount before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxOnOtherDiscount before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByTaxOnOtherDiscount(taxOnOtherDiscount));

		// % protected region % [Add any additional logic for findByTaxOnOtherDiscount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxOnOtherDiscount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Discount.
	 *
	 * @param otherDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Discount
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByOtherDiscount(Double otherDiscount)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherDiscount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherDiscount here] end
	{
		// % protected region % [Add any additional logic for findByOtherDiscount before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherDiscount before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByOtherDiscount(otherDiscount));

		// % protected region % [Add any additional logic for findByOtherDiscount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherDiscount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax On Other Fee.
	 *
	 * @param taxOnOtherFee the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax On Other Fee
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByTaxOnOtherFee(Boolean taxOnOtherFee)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxOnOtherFee here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxOnOtherFee here] end
	{
		// % protected region % [Add any additional logic for findByTaxOnOtherFee before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxOnOtherFee before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByTaxOnOtherFee(taxOnOtherFee));

		// % protected region % [Add any additional logic for findByTaxOnOtherFee before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxOnOtherFee before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee.
	 *
	 * @param otherFee the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByOtherFee(Double otherFee)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFee here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherFee here] end
	{
		// % protected region % [Add any additional logic for findByOtherFee before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherFee before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByOtherFee(otherFee));

		// % protected region % [Add any additional logic for findByOtherFee before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherFee before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax.
	 *
	 * @param tax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByTax(Double tax)
	// % protected region % [Add any throwables, implementations, or extensions for findByTax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTax here] end
	{
		// % protected region % [Add any additional logic for findByTax before the main body here] off begin
		// % protected region % [Add any additional logic for findByTax before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByTax(tax));

		// % protected region % [Add any additional logic for findByTax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Invoice.
	 *
	 * @param totalInvoice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Invoice
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByTotalInvoice(Double totalInvoice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInvoice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInvoice here] end
	{
		// % protected region % [Add any additional logic for findByTotalInvoice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalInvoice before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByTotalInvoice(totalInvoice));

		// % protected region % [Add any additional logic for findByTotalInvoice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalInvoice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Available Down Payment.
	 *
	 * @param availableDownPayment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Down Payment
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByAvailableDownPayment(Double availableDownPayment)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableDownPayment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableDownPayment here] end
	{
		// % protected region % [Add any additional logic for findByAvailableDownPayment before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvailableDownPayment before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByAvailableDownPayment(availableDownPayment));

		// % protected region % [Add any additional logic for findByAvailableDownPayment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvailableDownPayment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Coverage.
	 *
	 * @param totalCoverage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Coverage
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByTotalCoverage(Double totalCoverage)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCoverage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCoverage here] end
	{
		// % protected region % [Add any additional logic for findByTotalCoverage before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalCoverage before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByTotalCoverage(totalCoverage));

		// % protected region % [Add any additional logic for findByTotalCoverage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalCoverage before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByOutstandingAmount(Double outstandingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] end
	{
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByOutstandingAmount(outstandingAmount));

		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Coverage.
	 *
	 * @param bpjsCoverage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Coverage
	 */
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findByBpjsCoverage(Double bpjsCoverage)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCoverage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCoverage here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCoverage before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCoverage before the main body here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findByBpjsCoverage(bpjsCoverage));

		// % protected region % [Add any additional logic for findByBpjsCoverage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCoverage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InvoiceSummaryEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InvoiceSummaryEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InvoiceSummaryEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create')")
	public InvoiceSummaryEntity create(InvoiceSummaryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InvoiceSummaryEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create')")
	public InvoiceSummaryEntity create(InvoiceSummaryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InvoiceSummaryEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InvoiceSummaryEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create')")
	public List<InvoiceSummaryEntity> createAll(Iterable<InvoiceSummaryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InvoiceSummaryEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InvoiceSummaryEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'update')")
	public InvoiceSummaryEntity update(InvoiceSummaryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InvoiceSummaryEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'update')")
	public InvoiceSummaryEntity update(InvoiceSummaryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InvoiceSummaryEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InvoiceSummaryEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'update')")
	public List<InvoiceSummaryEntity> updateAll(Iterable<InvoiceSummaryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InvoiceSummaryEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InvoiceSummaryEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create') or hasPermission('InvoiceSummaryEntity', 'update')")
	public InvoiceSummaryEntity save(InvoiceSummaryEntity entity) throws ConstraintViolationException
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

		InvoiceSummaryEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'create') or hasPermission('InvoiceSummaryEntity', 'update')")
	public List<InvoiceSummaryEntity> saveAll(Iterable<InvoiceSummaryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InvoiceSummaryEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	public List<InvoiceSummaryEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	public List<InvoiceSummaryEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InvoiceSummaryEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InvoiceSummaryEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceSummaryEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceSummaryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceSummaryEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InvoiceSummaryEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceSummaryEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InvoiceSummaryEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InvoiceSummaryEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InvoiceSummaryEntityAudits
	 */
	private List<InvoiceSummaryEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InvoiceSummaryEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param invoiceSummary invoiceSummary to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InvoiceSummaryEntity updateAuditData(InvoiceSummaryEntity invoiceSummary)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return invoiceSummary;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InvoiceSummaryEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InvoiceSummaryEntity entityAtRevision = updateAuditData((InvoiceSummaryEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InvoiceSummaryEntityAudit(
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

		QInvoiceSummaryEntity entity = QInvoiceSummaryEntity.invoiceSummaryEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Summary here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Summary here] end

				break;
			case "retailPharmacyInvoiceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacyInvoice.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] end

				break;
			case "totalInvoice":
				// % protected region % [Add any additional logic before the query parameters of totalInvoice here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalInvoice here] end


				// % protected region % [Add any additional logic after the query parameters of totalInvoice here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalInvoice here] end

				break;
			case "outstandingAmount":
				// % protected region % [Add any additional logic before the query parameters of outstandingAmount here] off begin
				// % protected region % [Add any additional logic before the query parameters of outstandingAmount here] end


				// % protected region % [Add any additional logic after the query parameters of outstandingAmount here] off begin
				// % protected region % [Add any additional logic after the query parameters of outstandingAmount here] end

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
	public InvoiceSummaryEntity updateOldData(InvoiceSummaryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InvoiceSummaryEntity updateOldData(InvoiceSummaryEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InvoiceSummaryEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInvoiceSummaryEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTaxOnOtherDiscount() == null) {
			entityToUpdate.setTaxOnOtherDiscount(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTaxOnOtherFee() == null) {
			entityToUpdate.setTaxOnOtherFee(false);
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
				entityToUpdate.getInvoice().unsetInvoiceSummary();
			}
		}

		// Incoming One to One reference
		if (entity.getRetailPharmacyInvoice() == null && entity.getRetailPharmacyInvoiceId() == null) {
			entityToUpdate.unsetRetailPharmacyInvoice();
		} else if (entity.getRetailPharmacyInvoiceId() != null && entity.getRetailPharmacyInvoice() == null) {
			Optional<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceEntity = this.retailPharmacyInvoiceRepository.findById(entity.getRetailPharmacyInvoiceId());
			entityToUpdate.setRetailPharmacyInvoice(retailPharmacyInvoiceEntity.orElseThrow());
		}
		if (persistRelations && entity.getRetailPharmacyInvoice() != null) {
			entityToUpdate.setRetailPharmacyInvoice(entity.getRetailPharmacyInvoice(), false);
			if (entityToUpdate.getRetailPharmacyInvoiceId() != null) {
				this.retailPharmacyInvoiceRepository.save(entityToUpdate.getRetailPharmacyInvoice());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRetailPharmacyInvoice().unsetInvoiceSummary();
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
	public void validateEntity(InvoiceSummaryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InvoiceSummaryEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InvoiceSummaryEntity.
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

	public Set<String> validateEntityRelations(InvoiceSummaryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInvoiceId() != null && this.invoiceRepository.findById(entity.getInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoiceId() + " is not associated with a Invoice Entity");
		}

		if (entity.getRetailPharmacyInvoiceId() != null && this.retailPharmacyInvoiceRepository.findById(entity.getRetailPharmacyInvoiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getRetailPharmacyInvoiceId() + " is not associated with a Retail Pharmacy Invoice Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
