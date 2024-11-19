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
import kmsweb.repositories.SampleCollectionInformationRepository;
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
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.repositories.SampleCollectionItemsRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class SampleCollectionInformationService extends AbstractService<SampleCollectionInformationEntity, SampleCollectionInformationRepository, SampleCollectionInformationEntityAudit> {

	private final String[] referenceNamesInSampleCollectionInformationEntity = {
		"sampleCollectionItems",
		"diagnosisExaminationRecord",
		"registration",
	};

	private final DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	private final RegistrationRepository registrationRepository;

	private final SampleCollectionItemsRepository sampleCollectionItemsRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SampleCollectionInformationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository,
		RegistrationRepository registrationRepository,
		SampleCollectionItemsRepository sampleCollectionItemsRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		SampleCollectionInformationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.diagnosisExaminationRecordRepository = diagnosisExaminationRecordRepository;

		this.registrationRepository = registrationRepository;

		this.sampleCollectionItemsRepository = sampleCollectionItemsRepository;

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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Patient Informed.
	 *
	 * @param patientInformed the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Informed
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findByPatientInformed(Boolean patientInformed)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientInformed here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientInformed here] end
	{
		// % protected region % [Add any additional logic for findByPatientInformed before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientInformed before the main body here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findByPatientInformed(patientInformed));

		// % protected region % [Add any additional logic for findByPatientInformed before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientInformed before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Consented.
	 *
	 * @param patientConsented the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Consented
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findByPatientConsented(Boolean patientConsented)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientConsented here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientConsented here] end
	{
		// % protected region % [Add any additional logic for findByPatientConsented before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientConsented before the main body here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findByPatientConsented(patientConsented));

		// % protected region % [Add any additional logic for findByPatientConsented before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientConsented before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Fasted Enough.
	 *
	 * @param patientFastedEnough the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Fasted Enough
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findByPatientFastedEnough(Boolean patientFastedEnough)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientFastedEnough here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientFastedEnough here] end
	{
		// % protected region % [Add any additional logic for findByPatientFastedEnough before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientFastedEnough before the main body here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findByPatientFastedEnough(patientFastedEnough));

		// % protected region % [Add any additional logic for findByPatientFastedEnough before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientFastedEnough before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medication Taken In 24 Hours.
	 *
	 * @param medicationTakenIn24Hours the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Taken In 24 Hours
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findByMedicationTakenIn24Hours(Boolean medicationTakenIn24Hours)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTakenIn24Hours here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTakenIn24Hours here] end
	{
		// % protected region % [Add any additional logic for findByMedicationTakenIn24Hours before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicationTakenIn24Hours before the main body here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findByMedicationTakenIn24Hours(medicationTakenIn24Hours));

		// % protected region % [Add any additional logic for findByMedicationTakenIn24Hours before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicationTakenIn24Hours before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medication Taken In 72 Hours.
	 *
	 * @param medicationTakenIn72Hours the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Taken In 72 Hours
	 */
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findByMedicationTakenIn72Hours(Boolean medicationTakenIn72Hours)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTakenIn72Hours here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicationTakenIn72Hours here] end
	{
		// % protected region % [Add any additional logic for findByMedicationTakenIn72Hours before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicationTakenIn72Hours before the main body here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findByMedicationTakenIn72Hours(medicationTakenIn72Hours));

		// % protected region % [Add any additional logic for findByMedicationTakenIn72Hours before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicationTakenIn72Hours before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<SampleCollectionInformationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<SampleCollectionInformationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<SampleCollectionInformationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create')")
	public SampleCollectionInformationEntity create(SampleCollectionInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		SampleCollectionInformationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create')")
	public SampleCollectionInformationEntity create(SampleCollectionInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		SampleCollectionInformationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		SampleCollectionInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create')")
	public List<SampleCollectionInformationEntity> createAll(Iterable<SampleCollectionInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<SampleCollectionInformationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<SampleCollectionInformationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'update')")
	public SampleCollectionInformationEntity update(SampleCollectionInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		SampleCollectionInformationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'update')")
	public SampleCollectionInformationEntity update(SampleCollectionInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		SampleCollectionInformationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		SampleCollectionInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'update')")
	public List<SampleCollectionInformationEntity> updateAll(Iterable<SampleCollectionInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<SampleCollectionInformationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<SampleCollectionInformationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create') or hasPermission('SampleCollectionInformationEntity', 'update')")
	public SampleCollectionInformationEntity save(SampleCollectionInformationEntity entity) throws ConstraintViolationException
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

		SampleCollectionInformationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'create') or hasPermission('SampleCollectionInformationEntity', 'update')")
	public List<SampleCollectionInformationEntity> saveAll(Iterable<SampleCollectionInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<SampleCollectionInformationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	public List<SampleCollectionInformationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	public List<SampleCollectionInformationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(SampleCollectionInformationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of SampleCollectionInformationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of SampleCollectionInformationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SampleCollectionInformationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of SampleCollectionInformationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of SampleCollectionInformationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(SampleCollectionInformationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of SampleCollectionInformationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of SampleCollectionInformationEntityAudits
	 */
	private List<SampleCollectionInformationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<SampleCollectionInformationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param sampleCollectionInformation sampleCollectionInformation to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private SampleCollectionInformationEntity updateAuditData(SampleCollectionInformationEntity sampleCollectionInformation)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return sampleCollectionInformation;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private SampleCollectionInformationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		SampleCollectionInformationEntity entityAtRevision = updateAuditData((SampleCollectionInformationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new SampleCollectionInformationEntityAudit(
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

		QSampleCollectionInformationEntity entity = QSampleCollectionInformationEntity.sampleCollectionInformationEntity;

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
			case "diagnosisExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnosis Examination Record to Sample Collection Information here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnosis Examination Record to Sample Collection Information here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosisExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Diagnosis Examination Record to Sample Collection Information here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Diagnosis Examination Record to Sample Collection Information here] end

				break;
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Sample Collection Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Sample Collection Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Sample Collection Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Sample Collection Informations here] end

				break;
			case "sampleCollectionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Information to Sample Collection Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Information to Sample Collection Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleCollectionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Information to Sample Collection Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Information to Sample Collection Items here] end

				break;
			case "patientInformed":
				// % protected region % [Add any additional logic before the query parameters of patientInformed here] off begin
				// % protected region % [Add any additional logic before the query parameters of patientInformed here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientInformed, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of patientInformed here] off begin
				// % protected region % [Add any additional logic after the query parameters of patientInformed here] end

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
	public SampleCollectionInformationEntity updateOldData(SampleCollectionInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public SampleCollectionInformationEntity updateOldData(SampleCollectionInformationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		SampleCollectionInformationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInSampleCollectionInformationEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPatientInformed() == null) {
			entityToUpdate.setPatientInformed(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPatientConsented() == null) {
			entityToUpdate.setPatientConsented(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPatientFastedEnough() == null) {
			entityToUpdate.setPatientFastedEnough(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getMedicationTakenIn24Hours() == null) {
			entityToUpdate.setMedicationTakenIn24Hours(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getMedicationTakenIn72Hours() == null) {
			entityToUpdate.setMedicationTakenIn72Hours(false);
		}

		// Incoming One to One reference
		if (entity.getDiagnosisExaminationRecord() == null && entity.getDiagnosisExaminationRecordId() == null) {
			entityToUpdate.unsetDiagnosisExaminationRecord();
		} else if (entity.getDiagnosisExaminationRecordId() != null && entity.getDiagnosisExaminationRecord() == null) {
			Optional<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordEntity = this.diagnosisExaminationRecordRepository.findById(entity.getDiagnosisExaminationRecordId());
			entityToUpdate.setDiagnosisExaminationRecord(diagnosisExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getDiagnosisExaminationRecord() != null) {
			entityToUpdate.setDiagnosisExaminationRecord(entity.getDiagnosisExaminationRecord(), false);
			if (entityToUpdate.getDiagnosisExaminationRecordId() != null) {
				this.diagnosisExaminationRecordRepository.save(entityToUpdate.getDiagnosisExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDiagnosisExaminationRecord().unsetSampleCollectionInformation();
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
				entityToUpdate.getRegistration().unsetSampleCollectionInformations();
			}
		}

		// Outgoing one to many reference
		if (entity.getSampleCollectionItemsIds().isEmpty() && entity.getSampleCollectionItems().isEmpty()) {
			entityToUpdate.setSampleCollectionItems(new HashSet<>());
		} else if (!entity.getSampleCollectionItemsIds().isEmpty() && entity.getSampleCollectionItems().isEmpty()) {
			Iterable<SampleCollectionItemsEntity> sampleCollectionItemsEntities =
					this.sampleCollectionItemsRepository.findAllById(entity.getSampleCollectionItemsIds());
			entityToUpdate.setSampleCollectionItems(Sets.newHashSet(sampleCollectionItemsEntities));
		}
		if (persistRelations && !entity.getSampleCollectionItems().isEmpty()) {
			Set<SampleCollectionItemsEntity> updatedEntities = new HashSet<>();
			entity.getSampleCollectionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.sampleCollectionItemsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSampleCollectionItems(updatedEntities);
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
	public void validateEntity(SampleCollectionInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<SampleCollectionInformationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the SampleCollectionInformationEntity.
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

	public Set<String> validateEntityRelations(SampleCollectionInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDiagnosisExaminationRecordId() != null && this.diagnosisExaminationRecordRepository.findById(entity.getDiagnosisExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getDiagnosisExaminationRecordId() + " is not associated with a Diagnosis Examination Record Entity");
		}

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		for (UUID id : entity.getSampleCollectionItemsIds()) {
			if (this.sampleCollectionItemsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Sample Collection Items Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
