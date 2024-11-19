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
import kmsweb.repositories.InsuranceProviderRepository;
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
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.repositories.InsuranceBenefitPlanRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InsuranceProviderService extends AbstractService<InsuranceProviderEntity, InsuranceProviderRepository, InsuranceProviderEntityAudit> {

	private final String[] referenceNamesInInsuranceProviderEntity = {
		"insuranceBenefitPlans",
	};

	private final InsuranceBenefitPlanRepository insuranceBenefitPlanRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InsuranceProviderService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InsuranceBenefitPlanRepository insuranceBenefitPlanRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InsuranceProviderRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.insuranceBenefitPlanRepository = insuranceBenefitPlanRepository;

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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Provider Code.
	 *
	 * @param providerCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Code
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InsuranceProviderEntity> findByProviderCode(String providerCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderCode here] end
	{
		// % protected region % [Add any additional logic for findByProviderCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderCode before the main body here] end

		Optional<InsuranceProviderEntity> entity = repository.findByProviderCode(providerCode);

		// % protected region % [Add any additional logic for findByProviderCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByProviderCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Provider Name.
	 *
	 * @param providerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Name
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByProviderName(String providerName)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderName here] end
	{
		// % protected region % [Add any additional logic for findByProviderName before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderName before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByProviderName(providerName));

		// % protected region % [Add any additional logic for findByProviderName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProviderName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Provider Type.
	 *
	 * @param providerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Type
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByProviderType(String providerType)
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProviderType here] end
	{
		// % protected region % [Add any additional logic for findByProviderType before the main body here] off begin
		// % protected region % [Add any additional logic for findByProviderType before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByProviderType(providerType));

		// % protected region % [Add any additional logic for findByProviderType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProviderType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Benefit Provider.
	 *
	 * @param benefitProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Provider
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByBenefitProvider(String benefitProvider)
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBenefitProvider here] end
	{
		// % protected region % [Add any additional logic for findByBenefitProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByBenefitProvider before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByBenefitProvider(benefitProvider));

		// % protected region % [Add any additional logic for findByBenefitProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBenefitProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByFirstName(String firstName)
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] end
	{
		// % protected region % [Add any additional logic for findByFirstName before the main body here] off begin
		// % protected region % [Add any additional logic for findByFirstName before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByFirstName(firstName));

		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByLastName(String lastName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] end
	{
		// % protected region % [Add any additional logic for findByLastName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastName before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByLastName(lastName));

		// % protected region % [Add any additional logic for findByLastName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByMobilePhoneNumber(String mobilePhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByMobilePhoneNumber(mobilePhoneNumber));

		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Expiry Date.
	 *
	 * @param expiryDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiry Date
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByExpiryDate(OffsetDateTime expiryDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByExpiryDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExpiryDate here] end
	{
		// % protected region % [Add any additional logic for findByExpiryDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByExpiryDate before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByExpiryDate(expiryDate));

		// % protected region % [Add any additional logic for findByExpiryDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExpiryDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Expiring Date.
	 *
	 * @param expiringDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiring Date
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByExpiringDate(OffsetDateTime expiringDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByExpiringDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExpiringDate here] end
	{
		// % protected region % [Add any additional logic for findByExpiringDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByExpiringDate before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByExpiringDate(expiringDate));

		// % protected region % [Add any additional logic for findByExpiringDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExpiringDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Created Date.
	 *
	 * @param createdDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Created Date
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByCreatedDate(OffsetDateTime createdDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCreatedDate here] end
	{
		// % protected region % [Add any additional logic for findByCreatedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByCreatedDate before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByCreatedDate(createdDate));

		// % protected region % [Add any additional logic for findByCreatedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCreatedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InsuranceProviderEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InsuranceProviderEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InsuranceProviderEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InsuranceProviderEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'create')")
	public InsuranceProviderEntity create(InsuranceProviderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InsuranceProviderEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'create')")
	public InsuranceProviderEntity create(InsuranceProviderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InsuranceProviderEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InsuranceProviderEntity newEntity;

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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'create')")
	public List<InsuranceProviderEntity> createAll(Iterable<InsuranceProviderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InsuranceProviderEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InsuranceProviderEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'update')")
	public InsuranceProviderEntity update(InsuranceProviderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InsuranceProviderEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'update')")
	public InsuranceProviderEntity update(InsuranceProviderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InsuranceProviderEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InsuranceProviderEntity newEntity;

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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'update')")
	public List<InsuranceProviderEntity> updateAll(Iterable<InsuranceProviderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InsuranceProviderEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InsuranceProviderEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'create') or hasPermission('InsuranceProviderEntity', 'update')")
	public InsuranceProviderEntity save(InsuranceProviderEntity entity) throws ConstraintViolationException
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

		InsuranceProviderEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'create') or hasPermission('InsuranceProviderEntity', 'update')")
	public List<InsuranceProviderEntity> saveAll(Iterable<InsuranceProviderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InsuranceProviderEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	public List<InsuranceProviderEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	public List<InsuranceProviderEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InsuranceProviderEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InsuranceProviderEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InsuranceProviderEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InsuranceProviderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InsuranceProviderEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InsuranceProviderEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InsuranceProviderEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InsuranceProviderEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InsuranceProviderEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InsuranceProviderEntityAudits
	 */
	private List<InsuranceProviderEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InsuranceProviderEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param insuranceProvider insuranceProvider to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InsuranceProviderEntity updateAuditData(InsuranceProviderEntity insuranceProvider)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return insuranceProvider;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InsuranceProviderEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InsuranceProviderEntity entityAtRevision = updateAuditData((InsuranceProviderEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InsuranceProviderEntityAudit(
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

		QInsuranceProviderEntity entity = QInsuranceProviderEntity.insuranceProviderEntity;

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
			case "insuranceBenefitPlansId":
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.insuranceBenefitPlans.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Insurance Provider to Insurance Benefit Plans here] end

				break;
			case "providerCode":
				// % protected region % [Add any additional logic before the query parameters of providerCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of providerCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.providerCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of providerCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of providerCode here] end

				break;
			case "providerName":
				// % protected region % [Add any additional logic before the query parameters of providerName here] off begin
				// % protected region % [Add any additional logic before the query parameters of providerName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.providerName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of providerName here] off begin
				// % protected region % [Add any additional logic after the query parameters of providerName here] end

				break;
			case "providerType":
				// % protected region % [Add any additional logic before the query parameters of providerType here] off begin
				// % protected region % [Add any additional logic before the query parameters of providerType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.providerType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of providerType here] off begin
				// % protected region % [Add any additional logic after the query parameters of providerType here] end

				break;
			case "benefitProvider":
				// % protected region % [Add any additional logic before the query parameters of benefitProvider here] off begin
				// % protected region % [Add any additional logic before the query parameters of benefitProvider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.benefitProvider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of benefitProvider here] off begin
				// % protected region % [Add any additional logic after the query parameters of benefitProvider here] end

				break;
			case "expiryDate":
				// % protected region % [Add any additional logic before the query parameters of expiryDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of expiryDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.expiryDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of expiryDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of expiryDate here] end

				break;
			case "expiringDate":
				// % protected region % [Add any additional logic before the query parameters of expiringDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of expiringDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.expiringDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of expiringDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of expiringDate here] end

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
	public InsuranceProviderEntity updateOldData(InsuranceProviderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InsuranceProviderEntity updateOldData(InsuranceProviderEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InsuranceProviderEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInsuranceProviderEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getInsuranceBenefitPlansIds().isEmpty() && entity.getInsuranceBenefitPlans().isEmpty()) {
			entityToUpdate.setInsuranceBenefitPlans(new HashSet<>());
		} else if (!entity.getInsuranceBenefitPlansIds().isEmpty() && entity.getInsuranceBenefitPlans().isEmpty()) {
			Iterable<InsuranceBenefitPlanEntity> insuranceBenefitPlansEntities =
					this.insuranceBenefitPlanRepository.findAllById(entity.getInsuranceBenefitPlansIds());
			entityToUpdate.setInsuranceBenefitPlans(Sets.newHashSet(insuranceBenefitPlansEntities));
		}
		if (persistRelations && !entity.getInsuranceBenefitPlans().isEmpty()) {
			Set<InsuranceBenefitPlanEntity> updatedEntities = new HashSet<>();
			entity.getInsuranceBenefitPlans().forEach(model -> {
				if (model.getId() != null) {
					model = this.insuranceBenefitPlanRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInsuranceBenefitPlans(updatedEntities);
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
	public void validateEntity(InsuranceProviderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InsuranceProviderEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByProviderCodeOpt = this.findByProviderCode(entity.getProviderCode());
			if (entityByProviderCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<InsuranceProviderEntity>(
						"Provider Code",
						entity.getProviderCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ProviderCode"
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
	 * Get the sort as given by the sort by for the InsuranceProviderEntity.
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

	public Set<String> validateEntityRelations(InsuranceProviderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getInsuranceBenefitPlansIds()) {
			if (this.insuranceBenefitPlanRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Insurance Benefit Plan Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
