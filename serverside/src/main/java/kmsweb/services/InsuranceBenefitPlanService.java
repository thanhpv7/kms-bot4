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
import kmsweb.repositories.InsuranceBenefitPlanRepository;
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
import kmsweb.entities.InsuranceProviderEntity;
import kmsweb.repositories.InsuranceProviderRepository;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.repositories.InvoicePaymentInsuranceRepository;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientPaymentInsuranceRepository;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InsuranceBenefitPlanService extends AbstractService<InsuranceBenefitPlanEntity, InsuranceBenefitPlanRepository, InsuranceBenefitPlanEntityAudit> {

	private final String[] referenceNamesInInsuranceBenefitPlanEntity = {
		"invoicePaymentInsurances",
		"patientPaymentInsurances",
		"patientVisitPatientPaymentInsurances",
		"insuranceProvider",
	};

	private final InsuranceProviderRepository insuranceProviderRepository;

	private final InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository;

	private final PatientPaymentInsuranceRepository patientPaymentInsuranceRepository;

	private final PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InsuranceBenefitPlanService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InsuranceProviderRepository insuranceProviderRepository,
		InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository,
		PatientPaymentInsuranceRepository patientPaymentInsuranceRepository,
		PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InsuranceBenefitPlanRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.insuranceProviderRepository = insuranceProviderRepository;

		this.invoicePaymentInsuranceRepository = invoicePaymentInsuranceRepository;

		this.patientPaymentInsuranceRepository = patientPaymentInsuranceRepository;

		this.patientVisitPatientPaymentInsuranceRepository = patientVisitPatientPaymentInsuranceRepository;

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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Benefit Plan No.
	 *
	 * @param benefitPlanNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Plan No
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InsuranceBenefitPlanEntity> findByBenefitPlanNo(String benefitPlanNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitPlanNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitPlanNo here] end
	{
		// % protected region % [Add any additional logic for findByBenefitPlanNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBenefitPlanNo before the main body here] end

		Optional<InsuranceBenefitPlanEntity> entity = repository.findByBenefitPlanNo(benefitPlanNo);

		// % protected region % [Add any additional logic for findByBenefitPlanNo before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByBenefitPlanNo before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Benefit Plan Name.
	 *
	 * @param benefitPlanName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Plan Name
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByBenefitPlanName(String benefitPlanName)
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitPlanName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitPlanName here] end
	{
		// % protected region % [Add any additional logic for findByBenefitPlanName before the main body here] off begin
		// % protected region % [Add any additional logic for findByBenefitPlanName before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByBenefitPlanName(benefitPlanName));

		// % protected region % [Add any additional logic for findByBenefitPlanName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBenefitPlanName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Maximum Coverage per Treatment.
	 *
	 * @param maximumCoveragePerTreatment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximum Coverage per Treatment
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByMaximumCoveragePerTreatment(Double maximumCoveragePerTreatment)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximumCoveragePerTreatment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximumCoveragePerTreatment here] end
	{
		// % protected region % [Add any additional logic for findByMaximumCoveragePerTreatment before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaximumCoveragePerTreatment before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByMaximumCoveragePerTreatment(maximumCoveragePerTreatment));

		// % protected region % [Add any additional logic for findByMaximumCoveragePerTreatment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaximumCoveragePerTreatment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Maximum Coverage per Year.
	 *
	 * @param maximumCoveragePerYear the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximum Coverage per Year
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByMaximumCoveragePerYear(Double maximumCoveragePerYear)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximumCoveragePerYear here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximumCoveragePerYear here] end
	{
		// % protected region % [Add any additional logic for findByMaximumCoveragePerYear before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaximumCoveragePerYear before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByMaximumCoveragePerYear(maximumCoveragePerYear));

		// % protected region % [Add any additional logic for findByMaximumCoveragePerYear before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaximumCoveragePerYear before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Created Date.
	 *
	 * @param createdDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Created Date
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByCreatedDate(OffsetDateTime createdDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatedDate here] end
	{
		// % protected region % [Add any additional logic for findByCreatedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByCreatedDate before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByCreatedDate(createdDate));

		// % protected region % [Add any additional logic for findByCreatedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCreatedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Updated Date.
	 *
	 * @param updatedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Updated Date
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByUpdatedDate(OffsetDateTime updatedDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpdatedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpdatedDate here] end
	{
		// % protected region % [Add any additional logic for findByUpdatedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpdatedDate before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByUpdatedDate(updatedDate));

		// % protected region % [Add any additional logic for findByUpdatedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpdatedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InsuranceBenefitPlanEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InsuranceBenefitPlanEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InsuranceBenefitPlanEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create')")
	public InsuranceBenefitPlanEntity create(InsuranceBenefitPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InsuranceBenefitPlanEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create')")
	public InsuranceBenefitPlanEntity create(InsuranceBenefitPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InsuranceBenefitPlanEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InsuranceBenefitPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create')")
	public List<InsuranceBenefitPlanEntity> createAll(Iterable<InsuranceBenefitPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InsuranceBenefitPlanEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InsuranceBenefitPlanEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public InsuranceBenefitPlanEntity update(InsuranceBenefitPlanEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InsuranceBenefitPlanEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public InsuranceBenefitPlanEntity update(InsuranceBenefitPlanEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InsuranceBenefitPlanEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InsuranceBenefitPlanEntity newEntity;

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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public List<InsuranceBenefitPlanEntity> updateAll(Iterable<InsuranceBenefitPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InsuranceBenefitPlanEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InsuranceBenefitPlanEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create') or hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public InsuranceBenefitPlanEntity save(InsuranceBenefitPlanEntity entity) throws ConstraintViolationException
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

		InsuranceBenefitPlanEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'create') or hasPermission('InsuranceBenefitPlanEntity', 'update')")
	public List<InsuranceBenefitPlanEntity> saveAll(Iterable<InsuranceBenefitPlanEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InsuranceBenefitPlanEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	public List<InsuranceBenefitPlanEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	public List<InsuranceBenefitPlanEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InsuranceBenefitPlanEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InsuranceBenefitPlanEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InsuranceBenefitPlanEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceBenefitPlanEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InsuranceBenefitPlanEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InsuranceBenefitPlanEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InsuranceBenefitPlanEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InsuranceBenefitPlanEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InsuranceBenefitPlanEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InsuranceBenefitPlanEntityAudits
	 */
	private List<InsuranceBenefitPlanEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InsuranceBenefitPlanEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param insuranceBenefitPlan insuranceBenefitPlan to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InsuranceBenefitPlanEntity updateAuditData(InsuranceBenefitPlanEntity insuranceBenefitPlan)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return insuranceBenefitPlan;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InsuranceBenefitPlanEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InsuranceBenefitPlanEntity entityAtRevision = updateAuditData((InsuranceBenefitPlanEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InsuranceBenefitPlanEntityAudit(
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

		QInsuranceBenefitPlanEntity entity = QInsuranceBenefitPlanEntity.insuranceBenefitPlanEntity;

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
			case "insuranceProviderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.insuranceProvider.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] end

				break;
			case "invoicePaymentInsurancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Invoice Payment Insurances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoicePaymentInsurances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Invoice Payment Insurances here] end

				break;
			case "patientPaymentInsurancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Patient Payment Insurances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Patient Payment Insurances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentInsurances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Patient Payment Insurances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Patient Payment Insurances here] end

				break;
			case "patientVisitPatientPaymentInsurancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Patient Visit Patient Payment Insurances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Benefit Plan to Patient Visit Patient Payment Insurances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisitPatientPaymentInsurances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Patient Visit Patient Payment Insurances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Benefit Plan to Patient Visit Patient Payment Insurances here] end

				break;
			case "benefitPlanNo":
				// % protected region % [Add any additional logic before the query parameters of benefitPlanNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of benefitPlanNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.benefitPlanNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of benefitPlanNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of benefitPlanNo here] end

				break;
			case "maximumCoveragePerTreatment":
				// % protected region % [Add any additional logic before the query parameters of maximumCoveragePerTreatment here] off begin
				// % protected region % [Add any additional logic before the query parameters of maximumCoveragePerTreatment here] end


				// % protected region % [Add any additional logic after the query parameters of maximumCoveragePerTreatment here] off begin
				// % protected region % [Add any additional logic after the query parameters of maximumCoveragePerTreatment here] end

				break;
			case "maximumCoveragePerYear":
				// % protected region % [Add any additional logic before the query parameters of maximumCoveragePerYear here] off begin
				// % protected region % [Add any additional logic before the query parameters of maximumCoveragePerYear here] end


				// % protected region % [Add any additional logic after the query parameters of maximumCoveragePerYear here] off begin
				// % protected region % [Add any additional logic after the query parameters of maximumCoveragePerYear here] end

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
	public InsuranceBenefitPlanEntity updateOldData(InsuranceBenefitPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InsuranceBenefitPlanEntity updateOldData(InsuranceBenefitPlanEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InsuranceBenefitPlanEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInsuranceBenefitPlanEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getInsuranceProvider() == null && entity.getInsuranceProviderId() == null) {
			entityToUpdate.unsetInsuranceProvider();
		} else if (entity.getInsuranceProviderId() != null && entity.getInsuranceProvider() == null) {
			Optional<InsuranceProviderEntity> insuranceProviderEntity = this.insuranceProviderRepository.findById(entity.getInsuranceProviderId());
			entityToUpdate.setInsuranceProvider(insuranceProviderEntity.orElseThrow());
		}
		if (persistRelations && entity.getInsuranceProvider() != null) {
			entityToUpdate.setInsuranceProvider(entity.getInsuranceProvider(), false);
			if (entityToUpdate.getInsuranceProviderId() != null) {
				this.insuranceProviderRepository.save(entityToUpdate.getInsuranceProvider());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInsuranceProvider().unsetInsuranceBenefitPlans();
			}
		}

		// Outgoing one to many reference
		if (entity.getInvoicePaymentInsurancesIds().isEmpty() && entity.getInvoicePaymentInsurances().isEmpty()) {
			entityToUpdate.setInvoicePaymentInsurances(new HashSet<>());
		} else if (!entity.getInvoicePaymentInsurancesIds().isEmpty() && entity.getInvoicePaymentInsurances().isEmpty()) {
			Iterable<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities =
					this.invoicePaymentInsuranceRepository.findAllById(entity.getInvoicePaymentInsurancesIds());
			entityToUpdate.setInvoicePaymentInsurances(Sets.newHashSet(invoicePaymentInsurancesEntities));
		}
		if (persistRelations && !entity.getInvoicePaymentInsurances().isEmpty()) {
			Set<InvoicePaymentInsuranceEntity> updatedEntities = new HashSet<>();
			entity.getInvoicePaymentInsurances().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoicePaymentInsuranceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoicePaymentInsurances(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPatientPaymentInsurancesIds().isEmpty() && entity.getPatientPaymentInsurances().isEmpty()) {
			entityToUpdate.setPatientPaymentInsurances(new HashSet<>());
		} else if (!entity.getPatientPaymentInsurancesIds().isEmpty() && entity.getPatientPaymentInsurances().isEmpty()) {
			Iterable<PatientPaymentInsuranceEntity> patientPaymentInsurancesEntities =
					this.patientPaymentInsuranceRepository.findAllById(entity.getPatientPaymentInsurancesIds());
			entityToUpdate.setPatientPaymentInsurances(Sets.newHashSet(patientPaymentInsurancesEntities));
		}
		if (persistRelations && !entity.getPatientPaymentInsurances().isEmpty()) {
			Set<PatientPaymentInsuranceEntity> updatedEntities = new HashSet<>();
			entity.getPatientPaymentInsurances().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientPaymentInsuranceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientPaymentInsurances(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPatientVisitPatientPaymentInsurancesIds().isEmpty() && entity.getPatientVisitPatientPaymentInsurances().isEmpty()) {
			entityToUpdate.setPatientVisitPatientPaymentInsurances(new HashSet<>());
		} else if (!entity.getPatientVisitPatientPaymentInsurancesIds().isEmpty() && entity.getPatientVisitPatientPaymentInsurances().isEmpty()) {
			Iterable<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsurancesEntities =
					this.patientVisitPatientPaymentInsuranceRepository.findAllById(entity.getPatientVisitPatientPaymentInsurancesIds());
			entityToUpdate.setPatientVisitPatientPaymentInsurances(Sets.newHashSet(patientVisitPatientPaymentInsurancesEntities));
		}
		if (persistRelations && !entity.getPatientVisitPatientPaymentInsurances().isEmpty()) {
			Set<PatientVisitPatientPaymentInsuranceEntity> updatedEntities = new HashSet<>();
			entity.getPatientVisitPatientPaymentInsurances().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientVisitPatientPaymentInsuranceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientVisitPatientPaymentInsurances(updatedEntities);
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
	public void validateEntity(InsuranceBenefitPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InsuranceBenefitPlanEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByBenefitPlanNoOpt = this.findByBenefitPlanNo(entity.getBenefitPlanNo());
			if (entityByBenefitPlanNoOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<InsuranceBenefitPlanEntity>(
						"Benefit Plan No",
						entity.getBenefitPlanNo(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"BenefitPlanNo"
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
	 * Get the sort as given by the sort by for the InsuranceBenefitPlanEntity.
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

	public Set<String> validateEntityRelations(InsuranceBenefitPlanEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInsuranceProviderId() != null && this.insuranceProviderRepository.findById(entity.getInsuranceProviderId()).isEmpty()) {
			errors.add("The UUID " + entity.getInsuranceProviderId() + " is not associated with a Insurance Provider Entity");
		}

		for (UUID id : entity.getInvoicePaymentInsurancesIds()) {
			if (this.invoicePaymentInsuranceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Payment Insurance Entity");
			}
		}

		for (UUID id : entity.getPatientPaymentInsurancesIds()) {
			if (this.patientPaymentInsuranceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Payment Insurance Entity");
			}
		}

		for (UUID id : entity.getPatientVisitPatientPaymentInsurancesIds()) {
			if (this.patientVisitPatientPaymentInsuranceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Visit Patient Payment Insurance Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
