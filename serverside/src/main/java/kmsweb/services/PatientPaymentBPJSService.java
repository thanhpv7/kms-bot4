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
import kmsweb.repositories.PatientPaymentBPJSRepository;
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
import kmsweb.entities.BpjsAccidentMasterEntity;
import kmsweb.repositories.BpjsAccidentMasterRepository;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import kmsweb.repositories.BpjsHospitalizationPlanRepository;
import kmsweb.entities.BpjsJasaRaharjaEntity;
import kmsweb.repositories.BpjsJasaRaharjaRepository;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.repositories.BpjsSEPRepository;
import kmsweb.entities.BpjsSEPSubmissionEntity;
import kmsweb.repositories.BpjsSEPSubmissionRepository;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PatientPaymentBPJSService extends AbstractService<PatientPaymentBPJSEntity, PatientPaymentBPJSRepository, PatientPaymentBPJSEntityAudit> {

	private final String[] referenceNamesInPatientPaymentBPJSEntity = {
		"bpjsAccidentMasters",
		"bpjsClaimSubmissions",
		"bpjsHospitalizationPlans",
		"bpjsJasaRaharjas",
		"bpjsPatientReferrals",
		"bpjsSEPSubmissions",
		"bpjsSEPs",
		"patientGeneralInfo",
	};

	private final BpjsAccidentMasterRepository bpjsAccidentMasterRepository;

	private final BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	private final BpjsHospitalizationPlanRepository bpjsHospitalizationPlanRepository;

	private final BpjsJasaRaharjaRepository bpjsJasaRaharjaRepository;

	private final BpjsPatientReferralRepository bpjsPatientReferralRepository;

	private final BpjsSEPRepository bpjsSEPRepository;

	private final BpjsSEPSubmissionRepository bpjsSEPSubmissionRepository;

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientPaymentBPJSService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsAccidentMasterRepository bpjsAccidentMasterRepository,
		BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository,
		BpjsHospitalizationPlanRepository bpjsHospitalizationPlanRepository,
		BpjsJasaRaharjaRepository bpjsJasaRaharjaRepository,
		BpjsPatientReferralRepository bpjsPatientReferralRepository,
		BpjsSEPRepository bpjsSEPRepository,
		BpjsSEPSubmissionRepository bpjsSEPSubmissionRepository,
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PatientPaymentBPJSRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsAccidentMasterRepository = bpjsAccidentMasterRepository;

		this.bpjsClaimSubmissionRepository = bpjsClaimSubmissionRepository;

		this.bpjsHospitalizationPlanRepository = bpjsHospitalizationPlanRepository;

		this.bpjsJasaRaharjaRepository = bpjsJasaRaharjaRepository;

		this.bpjsPatientReferralRepository = bpjsPatientReferralRepository;

		this.bpjsSEPRepository = bpjsSEPRepository;

		this.bpjsSEPSubmissionRepository = bpjsSEPSubmissionRepository;

		this.patientGeneralInfoRepository = patientGeneralInfoRepository;

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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<PatientPaymentBPJSEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<PatientPaymentBPJSEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientPaymentBPJSEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PatientPaymentBPJSEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PatientPaymentBPJSEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PatientPaymentBPJSEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PatientPaymentBPJSEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create')")
	public PatientPaymentBPJSEntity create(PatientPaymentBPJSEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PatientPaymentBPJSEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create')")
	public PatientPaymentBPJSEntity create(PatientPaymentBPJSEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PatientPaymentBPJSEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PatientPaymentBPJSEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create')")
	public List<PatientPaymentBPJSEntity> createAll(Iterable<PatientPaymentBPJSEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PatientPaymentBPJSEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PatientPaymentBPJSEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'update')")
	public PatientPaymentBPJSEntity update(PatientPaymentBPJSEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PatientPaymentBPJSEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'update')")
	public PatientPaymentBPJSEntity update(PatientPaymentBPJSEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PatientPaymentBPJSEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PatientPaymentBPJSEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'update')")
	public List<PatientPaymentBPJSEntity> updateAll(Iterable<PatientPaymentBPJSEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PatientPaymentBPJSEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PatientPaymentBPJSEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create') or hasPermission('PatientPaymentBPJSEntity', 'update')")
	public PatientPaymentBPJSEntity save(PatientPaymentBPJSEntity entity) throws ConstraintViolationException
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

		PatientPaymentBPJSEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'create') or hasPermission('PatientPaymentBPJSEntity', 'update')")
	public List<PatientPaymentBPJSEntity> saveAll(Iterable<PatientPaymentBPJSEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PatientPaymentBPJSEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	public List<PatientPaymentBPJSEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	public List<PatientPaymentBPJSEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PatientPaymentBPJSEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PatientPaymentBPJSEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientPaymentBPJSEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientPaymentBPJSEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PatientPaymentBPJSEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientPaymentBPJSEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PatientPaymentBPJSEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PatientPaymentBPJSEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PatientPaymentBPJSEntityAudits
	 */
	private List<PatientPaymentBPJSEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PatientPaymentBPJSEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param patientPaymentBPJS patientPaymentBPJS to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PatientPaymentBPJSEntity updateAuditData(PatientPaymentBPJSEntity patientPaymentBPJS)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return patientPaymentBPJS;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PatientPaymentBPJSEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PatientPaymentBPJSEntity entityAtRevision = updateAuditData((PatientPaymentBPJSEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PatientPaymentBPJSEntityAudit(
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

		QPatientPaymentBPJSEntity entity = QPatientPaymentBPJSEntity.patientPaymentBPJSEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Payment BPJS here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Payment BPJS here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientGeneralInfo.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Payment BPJS here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Payment BPJS here] end

				break;
			case "bpjsAccidentMastersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Accident Masters here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Accident Masters here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsAccidentMasters.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Accident Masters here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Accident Masters here] end

				break;
			case "bpjsClaimSubmissionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsClaimSubmissions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] end

				break;
			case "bpjsHospitalizationPlansId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsHospitalizationPlans.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Hospitalization Plans here] end

				break;
			case "bpjsJasaRaharjasId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Jasa Raharjas here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Jasa Raharjas here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsJasaRaharjas.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Jasa Raharjas here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Jasa Raharjas here] end

				break;
			case "bpjsPatientReferralsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Patient Referrals here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Patient Referrals here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPatientReferrals.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Patient Referrals here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Patient Referrals here] end

				break;
			case "bpjsSEPSubmissionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS SEP Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS SEP Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsSEPSubmissions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS SEP Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS SEP Submissions here] end

				break;
			case "bpjsSEPsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS SEPs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS SEPs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsSEPs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS SEPs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS SEPs here] end

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
	public PatientPaymentBPJSEntity updateOldData(PatientPaymentBPJSEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PatientPaymentBPJSEntity updateOldData(PatientPaymentBPJSEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PatientPaymentBPJSEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPatientPaymentBPJSEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
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
				entityToUpdate.getPatientGeneralInfo().unsetPatientPaymentBPJS();
			}
		}

		// Outgoing one to many reference
		if (entity.getBpjsAccidentMastersIds().isEmpty() && entity.getBpjsAccidentMasters().isEmpty()) {
			entityToUpdate.setBpjsAccidentMasters(new HashSet<>());
		} else if (!entity.getBpjsAccidentMastersIds().isEmpty() && entity.getBpjsAccidentMasters().isEmpty()) {
			Iterable<BpjsAccidentMasterEntity> bpjsAccidentMastersEntities =
					this.bpjsAccidentMasterRepository.findAllById(entity.getBpjsAccidentMastersIds());
			entityToUpdate.setBpjsAccidentMasters(Sets.newHashSet(bpjsAccidentMastersEntities));
		}
		if (persistRelations && !entity.getBpjsAccidentMasters().isEmpty()) {
			Set<BpjsAccidentMasterEntity> updatedEntities = new HashSet<>();
			entity.getBpjsAccidentMasters().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsAccidentMasterRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsAccidentMasters(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsClaimSubmissionsIds().isEmpty() && entity.getBpjsClaimSubmissions().isEmpty()) {
			entityToUpdate.setBpjsClaimSubmissions(new HashSet<>());
		} else if (!entity.getBpjsClaimSubmissionsIds().isEmpty() && entity.getBpjsClaimSubmissions().isEmpty()) {
			Iterable<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities =
					this.bpjsClaimSubmissionRepository.findAllById(entity.getBpjsClaimSubmissionsIds());
			entityToUpdate.setBpjsClaimSubmissions(Sets.newHashSet(bpjsClaimSubmissionsEntities));
		}
		if (persistRelations && !entity.getBpjsClaimSubmissions().isEmpty()) {
			Set<BpjsClaimSubmissionEntity> updatedEntities = new HashSet<>();
			entity.getBpjsClaimSubmissions().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsClaimSubmissionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsClaimSubmissions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsHospitalizationPlansIds().isEmpty() && entity.getBpjsHospitalizationPlans().isEmpty()) {
			entityToUpdate.setBpjsHospitalizationPlans(new HashSet<>());
		} else if (!entity.getBpjsHospitalizationPlansIds().isEmpty() && entity.getBpjsHospitalizationPlans().isEmpty()) {
			Iterable<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlansEntities =
					this.bpjsHospitalizationPlanRepository.findAllById(entity.getBpjsHospitalizationPlansIds());
			entityToUpdate.setBpjsHospitalizationPlans(Sets.newHashSet(bpjsHospitalizationPlansEntities));
		}
		if (persistRelations && !entity.getBpjsHospitalizationPlans().isEmpty()) {
			Set<BpjsHospitalizationPlanEntity> updatedEntities = new HashSet<>();
			entity.getBpjsHospitalizationPlans().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsHospitalizationPlanRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsHospitalizationPlans(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsJasaRaharjasIds().isEmpty() && entity.getBpjsJasaRaharjas().isEmpty()) {
			entityToUpdate.setBpjsJasaRaharjas(new HashSet<>());
		} else if (!entity.getBpjsJasaRaharjasIds().isEmpty() && entity.getBpjsJasaRaharjas().isEmpty()) {
			Iterable<BpjsJasaRaharjaEntity> bpjsJasaRaharjasEntities =
					this.bpjsJasaRaharjaRepository.findAllById(entity.getBpjsJasaRaharjasIds());
			entityToUpdate.setBpjsJasaRaharjas(Sets.newHashSet(bpjsJasaRaharjasEntities));
		}
		if (persistRelations && !entity.getBpjsJasaRaharjas().isEmpty()) {
			Set<BpjsJasaRaharjaEntity> updatedEntities = new HashSet<>();
			entity.getBpjsJasaRaharjas().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsJasaRaharjaRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsJasaRaharjas(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsPatientReferralsIds().isEmpty() && entity.getBpjsPatientReferrals().isEmpty()) {
			entityToUpdate.setBpjsPatientReferrals(new HashSet<>());
		} else if (!entity.getBpjsPatientReferralsIds().isEmpty() && entity.getBpjsPatientReferrals().isEmpty()) {
			Iterable<BpjsPatientReferralEntity> bpjsPatientReferralsEntities =
					this.bpjsPatientReferralRepository.findAllById(entity.getBpjsPatientReferralsIds());
			entityToUpdate.setBpjsPatientReferrals(Sets.newHashSet(bpjsPatientReferralsEntities));
		}
		if (persistRelations && !entity.getBpjsPatientReferrals().isEmpty()) {
			Set<BpjsPatientReferralEntity> updatedEntities = new HashSet<>();
			entity.getBpjsPatientReferrals().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsPatientReferralRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsPatientReferrals(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsSEPSubmissionsIds().isEmpty() && entity.getBpjsSEPSubmissions().isEmpty()) {
			entityToUpdate.setBpjsSEPSubmissions(new HashSet<>());
		} else if (!entity.getBpjsSEPSubmissionsIds().isEmpty() && entity.getBpjsSEPSubmissions().isEmpty()) {
			Iterable<BpjsSEPSubmissionEntity> bpjsSEPSubmissionsEntities =
					this.bpjsSEPSubmissionRepository.findAllById(entity.getBpjsSEPSubmissionsIds());
			entityToUpdate.setBpjsSEPSubmissions(Sets.newHashSet(bpjsSEPSubmissionsEntities));
		}
		if (persistRelations && !entity.getBpjsSEPSubmissions().isEmpty()) {
			Set<BpjsSEPSubmissionEntity> updatedEntities = new HashSet<>();
			entity.getBpjsSEPSubmissions().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsSEPSubmissionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsSEPSubmissions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsSEPsIds().isEmpty() && entity.getBpjsSEPs().isEmpty()) {
			entityToUpdate.setBpjsSEPs(new HashSet<>());
		} else if (!entity.getBpjsSEPsIds().isEmpty() && entity.getBpjsSEPs().isEmpty()) {
			Iterable<BpjsSEPEntity> bpjsSEPsEntities =
					this.bpjsSEPRepository.findAllById(entity.getBpjsSEPsIds());
			entityToUpdate.setBpjsSEPs(Sets.newHashSet(bpjsSEPsEntities));
		}
		if (persistRelations && !entity.getBpjsSEPs().isEmpty()) {
			Set<BpjsSEPEntity> updatedEntities = new HashSet<>();
			entity.getBpjsSEPs().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsSEPRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsSEPs(updatedEntities);
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
	public void validateEntity(PatientPaymentBPJSEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PatientPaymentBPJSEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PatientPaymentBPJSEntity.
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

	public Set<String> validateEntityRelations(PatientPaymentBPJSEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientGeneralInfoId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientGeneralInfoId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientGeneralInfoId() + " is not associated with a Patient General Info Entity");
		}

		for (UUID id : entity.getBpjsAccidentMastersIds()) {
			if (this.bpjsAccidentMasterRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Accident Master Entity");
			}
		}

		for (UUID id : entity.getBpjsClaimSubmissionsIds()) {
			if (this.bpjsClaimSubmissionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Claim Submission Entity");
			}
		}

		for (UUID id : entity.getBpjsHospitalizationPlansIds()) {
			if (this.bpjsHospitalizationPlanRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Hospitalization Plan Entity");
			}
		}

		for (UUID id : entity.getBpjsJasaRaharjasIds()) {
			if (this.bpjsJasaRaharjaRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Jasa Raharja Entity");
			}
		}

		for (UUID id : entity.getBpjsPatientReferralsIds()) {
			if (this.bpjsPatientReferralRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Patient Referral Entity");
			}
		}

		for (UUID id : entity.getBpjsSEPSubmissionsIds()) {
			if (this.bpjsSEPSubmissionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS SEP Submission Entity");
			}
		}

		for (UUID id : entity.getBpjsSEPsIds()) {
			if (this.bpjsSEPRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS SEP Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
