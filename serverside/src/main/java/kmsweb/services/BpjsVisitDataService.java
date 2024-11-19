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
import kmsweb.repositories.BpjsVisitDataRepository;
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
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsVisitDataService extends AbstractService<BpjsVisitDataEntity, BpjsVisitDataRepository, BpjsVisitDataEntityAudit> {

	private final String[] referenceNamesInBpjsVisitDataEntity = {
		"patientVisit",
	};

	private final PatientVisitRepository patientVisitRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsVisitDataService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PatientVisitRepository patientVisitRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsVisitDataRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.patientVisitRepository = patientVisitRepository;

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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByDiagnose(String diagnose)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] end
	{
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByDiagnose(diagnose));

		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByTreatmentType(String treatmentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByTreatmentType(treatmentType));

		// % protected region % [Add any additional logic for findByTreatmentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByReferralNo(String referralNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] end
	{
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByReferralNo(referralNo));

		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByPolyclinic(String polyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByPolyclinic(polyclinic));

		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findBySepDate(String sepDate)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] end
	{
		// % protected region % [Add any additional logic for findBySepDate before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepDate before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findBySepDate(sepDate));

		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Dismissal Date.
	 *
	 * @param sepDismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Dismissal Date
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findBySepDismissalDate(String sepDismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findBySepDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepDismissalDate before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findBySepDismissalDate(sepDismissalDate));

		// % protected region % [Add any additional logic for findBySepDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Json Insert.
	 *
	 * @param jsonInsert the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Json Insert
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByJsonInsert(String jsonInsert)
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonInsert here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonInsert here] end
	{
		// % protected region % [Add any additional logic for findByJsonInsert before the main body here] off begin
		// % protected region % [Add any additional logic for findByJsonInsert before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByJsonInsert(jsonInsert));

		// % protected region % [Add any additional logic for findByJsonInsert before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJsonInsert before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Json Update.
	 *
	 * @param jsonUpdate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Json Update
	 */
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findByJsonUpdate(String jsonUpdate)
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonUpdate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonUpdate here] end
	{
		// % protected region % [Add any additional logic for findByJsonUpdate before the main body here] off begin
		// % protected region % [Add any additional logic for findByJsonUpdate before the main body here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findByJsonUpdate(jsonUpdate));

		// % protected region % [Add any additional logic for findByJsonUpdate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJsonUpdate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsVisitDataEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsVisitDataEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsVisitDataEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'create')")
	public BpjsVisitDataEntity create(BpjsVisitDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsVisitDataEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'create')")
	public BpjsVisitDataEntity create(BpjsVisitDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsVisitDataEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsVisitDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'create')")
	public List<BpjsVisitDataEntity> createAll(Iterable<BpjsVisitDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsVisitDataEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsVisitDataEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'update')")
	public BpjsVisitDataEntity update(BpjsVisitDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsVisitDataEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'update')")
	public BpjsVisitDataEntity update(BpjsVisitDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsVisitDataEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsVisitDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'update')")
	public List<BpjsVisitDataEntity> updateAll(Iterable<BpjsVisitDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsVisitDataEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsVisitDataEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'create') or hasPermission('BpjsVisitDataEntity', 'update')")
	public BpjsVisitDataEntity save(BpjsVisitDataEntity entity) throws ConstraintViolationException
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

		BpjsVisitDataEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'create') or hasPermission('BpjsVisitDataEntity', 'update')")
	public List<BpjsVisitDataEntity> saveAll(Iterable<BpjsVisitDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsVisitDataEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	public List<BpjsVisitDataEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	public List<BpjsVisitDataEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsVisitDataEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsVisitDataEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsVisitDataEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsVisitDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsVisitDataEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsVisitDataEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsVisitDataEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsVisitDataEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsVisitDataEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsVisitDataEntityAudits
	 */
	private List<BpjsVisitDataEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsVisitDataEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsVisitData bpjsVisitData to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsVisitDataEntity updateAuditData(BpjsVisitDataEntity bpjsVisitData)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsVisitData;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsVisitDataEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsVisitDataEntity entityAtRevision = updateAuditData((BpjsVisitDataEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsVisitDataEntityAudit(
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

		QBpjsVisitDataEntity entity = QBpjsVisitDataEntity.bpjsVisitDataEntity;

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
			case "patientVisitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Visit Datas here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Visit Datas here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Visit Datas here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Visit Datas here] end

				break;
			case "diagnose":
				// % protected region % [Add any additional logic before the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of diagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnose, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of diagnose here] end

				break;
			case "treatmentType":
				// % protected region % [Add any additional logic before the query parameters of treatmentType here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentType here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentType here] end

				break;
			case "treatmentClass":
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentClass, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] end

				break;
			case "name":
				// % protected region % [Add any additional logic before the query parameters of name here] off begin
				// % protected region % [Add any additional logic before the query parameters of name here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.name, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of name here] off begin
				// % protected region % [Add any additional logic after the query parameters of name here] end

				break;
			case "bpjsCardNo":
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsCardNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] end

				break;
			case "sepNo":
				// % protected region % [Add any additional logic before the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepNo here] end

				break;
			case "referralNo":
				// % protected region % [Add any additional logic before the query parameters of referralNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralNo here] end

				break;
			case "polyclinic":
				// % protected region % [Add any additional logic before the query parameters of polyclinic here] off begin
				// % protected region % [Add any additional logic before the query parameters of polyclinic here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.polyclinic, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of polyclinic here] off begin
				// % protected region % [Add any additional logic after the query parameters of polyclinic here] end

				break;
			case "sepDate":
				// % protected region % [Add any additional logic before the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepDate here] end

				break;
			case "sepDismissalDate":
				// % protected region % [Add any additional logic before the query parameters of sepDismissalDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepDismissalDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepDismissalDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepDismissalDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepDismissalDate here] end

				break;
			case "jsonInsert":
				// % protected region % [Add any additional logic before the query parameters of jsonInsert here] off begin
				// % protected region % [Add any additional logic before the query parameters of jsonInsert here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.jsonInsert, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of jsonInsert here] off begin
				// % protected region % [Add any additional logic after the query parameters of jsonInsert here] end

				break;
			case "jsonUpdate":
				// % protected region % [Add any additional logic before the query parameters of jsonUpdate here] off begin
				// % protected region % [Add any additional logic before the query parameters of jsonUpdate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.jsonUpdate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of jsonUpdate here] off begin
				// % protected region % [Add any additional logic after the query parameters of jsonUpdate here] end

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
	public BpjsVisitDataEntity updateOldData(BpjsVisitDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsVisitDataEntity updateOldData(BpjsVisitDataEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsVisitDataEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsVisitDataEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPatientVisit() == null && entity.getPatientVisitId() == null) {
			entityToUpdate.unsetPatientVisit();
		} else if (entity.getPatientVisitId() != null && entity.getPatientVisit() == null) {
			Optional<PatientVisitEntity> patientVisitEntity = this.patientVisitRepository.findById(entity.getPatientVisitId());
			entityToUpdate.setPatientVisit(patientVisitEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisit() != null) {
			entityToUpdate.setPatientVisit(entity.getPatientVisit(), false);
			if (entityToUpdate.getPatientVisitId() != null) {
				this.patientVisitRepository.save(entityToUpdate.getPatientVisit());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisit().unsetBpjsVisitDatas();
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
	public void validateEntity(BpjsVisitDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsVisitDataEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsVisitDataEntity.
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

	public Set<String> validateEntityRelations(BpjsVisitDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientVisitId() != null && this.patientVisitRepository.findById(entity.getPatientVisitId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitId() + " is not associated with a Patient Visit Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
