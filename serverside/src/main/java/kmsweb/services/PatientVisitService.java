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
import kmsweb.repositories.PatientVisitRepository;
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
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.repositories.BpjsPcareRegistrationsRepository;
import kmsweb.entities.BpjsVisitDataEntity;
import kmsweb.repositories.BpjsVisitDataRepository;
import kmsweb.entities.BpjsPcarePendaftaranEntity;
import kmsweb.repositories.BpjsPcarePendaftaranRepository;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;
import kmsweb.entities.PatientVisitPatientPaymentOthersEntity;
import kmsweb.repositories.PatientVisitPatientPaymentOthersRepository;
import kmsweb.entities.PatientVisitPaymentSelfPayingEntity;
import kmsweb.repositories.PatientVisitPaymentSelfPayingRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PatientVisitService extends AbstractService<PatientVisitEntity, PatientVisitRepository, PatientVisitEntityAudit> {

	private final String[] referenceNamesInPatientVisitEntity = {
		"bpjsPcareRegistrations",
		"bpjsVisitDatas",
		"bpjsPcarePendaftarans",
		"invoices",
		"patientVisitPatientPaymentInsurance",
		"patientVisitPatientPaymentOthers",
		"patientVisitPaymentSelfPaying",
		"registrations",
		"patient",
	};

	private final BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository;

	private final BpjsVisitDataRepository bpjsVisitDataRepository;

	private final BpjsPcarePendaftaranRepository bpjsPcarePendaftaranRepository;

	private final InvoiceRepository invoiceRepository;

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private final PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	private final PatientVisitPatientPaymentOthersRepository patientVisitPatientPaymentOthersRepository;

	private final PatientVisitPaymentSelfPayingRepository patientVisitPaymentSelfPayingRepository;

	private final RegistrationRepository registrationRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientVisitService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository,
		BpjsVisitDataRepository bpjsVisitDataRepository,
		BpjsPcarePendaftaranRepository bpjsPcarePendaftaranRepository,
		InvoiceRepository invoiceRepository,
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository,
		PatientVisitPatientPaymentOthersRepository patientVisitPatientPaymentOthersRepository,
		PatientVisitPaymentSelfPayingRepository patientVisitPaymentSelfPayingRepository,
		RegistrationRepository registrationRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PatientVisitRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsPcareRegistrationsRepository = bpjsPcareRegistrationsRepository;

		this.bpjsVisitDataRepository = bpjsVisitDataRepository;

		this.bpjsPcarePendaftaranRepository = bpjsPcarePendaftaranRepository;

		this.invoiceRepository = invoiceRepository;

		this.patientGeneralInfoRepository = patientGeneralInfoRepository;

		this.patientVisitPatientPaymentInsuranceRepository = patientVisitPatientPaymentInsuranceRepository;

		this.patientVisitPatientPaymentOthersRepository = patientVisitPatientPaymentOthersRepository;

		this.patientVisitPaymentSelfPayingRepository = patientVisitPaymentSelfPayingRepository;

		this.registrationRepository = registrationRepository;

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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Visit Number.
	 *
	 * @param visitNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Number
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByVisitNumber(String visitNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitNumber here] end
	{
		// % protected region % [Add any additional logic for findByVisitNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitNumber before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByVisitNumber(visitNumber));

		// % protected region % [Add any additional logic for findByVisitNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Registration Type.
	 *
	 * @param registrationType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Type
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByRegistrationType(String registrationType)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationType here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationType before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationType before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByRegistrationType(registrationType));

		// % protected region % [Add any additional logic for findByRegistrationType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visit Date.
	 *
	 * @param visitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Date
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByVisitDate(OffsetDateTime visitDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitDate here] end
	{
		// % protected region % [Add any additional logic for findByVisitDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitDate before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByVisitDate(visitDate));

		// % protected region % [Add any additional logic for findByVisitDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Registration Location.
	 *
	 * @param registrationLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Location
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByRegistrationLocation(String registrationLocation)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationLocation here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationLocation before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByRegistrationLocation(registrationLocation));

		// % protected region % [Add any additional logic for findByRegistrationLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByPatientPaymentType(String patientPaymentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] end
	{
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByPatientPaymentType(patientPaymentType));

		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visit Type.
	 *
	 * @param visitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Type
	 */
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findByVisitType(String visitType)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] end
	{
		// % protected region % [Add any additional logic for findByVisitType before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitType before the main body here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findByVisitType(visitType));

		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientVisitEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PatientVisitEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PatientVisitEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientVisitEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PatientVisitEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create')")
	public PatientVisitEntity create(PatientVisitEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PatientVisitEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create')")
	public PatientVisitEntity create(PatientVisitEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PatientVisitEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PatientVisitEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create')")
	public List<PatientVisitEntity> createAll(Iterable<PatientVisitEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PatientVisitEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PatientVisitEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientVisitEntity', 'update')")
	public PatientVisitEntity update(PatientVisitEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PatientVisitEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientVisitEntity', 'update')")
	public PatientVisitEntity update(PatientVisitEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PatientVisitEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PatientVisitEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'update')")
	public List<PatientVisitEntity> updateAll(Iterable<PatientVisitEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PatientVisitEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PatientVisitEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create') or hasPermission('PatientVisitEntity', 'update')")
	public PatientVisitEntity save(PatientVisitEntity entity) throws ConstraintViolationException
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

		PatientVisitEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'create') or hasPermission('PatientVisitEntity', 'update')")
	public List<PatientVisitEntity> saveAll(Iterable<PatientVisitEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PatientVisitEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	public List<PatientVisitEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	public List<PatientVisitEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientVisitEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PatientVisitEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PatientVisitEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientVisitEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientVisitEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PatientVisitEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientVisitEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PatientVisitEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PatientVisitEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PatientVisitEntityAudits
	 */
	private List<PatientVisitEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PatientVisitEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param patientVisit patientVisit to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PatientVisitEntity updateAuditData(PatientVisitEntity patientVisit)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return patientVisit;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PatientVisitEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PatientVisitEntity entityAtRevision = updateAuditData((PatientVisitEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PatientVisitEntityAudit(
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

		QPatientVisitEntity entity = QPatientVisitEntity.patientVisitEntity;

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
			case "bpjsPcareRegistrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Pcare Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPcareRegistrations.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Pcare Registrations here] end

				break;
			case "patientVisitPatientPaymentInsuranceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Patient Payment Insurance here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Patient Payment Insurance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisitPatientPaymentInsurance.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Patient Payment Insurance here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Patient Payment Insurance here] end

				break;
			case "patientVisitPatientPaymentOthersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Patient Payment Others here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Patient Payment Others here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisitPatientPaymentOthers.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Patient Payment Others here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Patient Payment Others here] end

				break;
			case "patientVisitPaymentSelfPayingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Payment Self Paying here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Patient Visit Payment Self Paying here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisitPaymentSelfPaying.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Payment Self Paying here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Patient Visit Payment Self Paying here] end

				break;
			case "patientId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Visits here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Visits here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patient.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Visits here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Visits here] end

				break;
			case "bpjsVisitDatasId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Visit Datas here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to BPJS Visit Datas here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsVisitDatas.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Visit Datas here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to BPJS Visit Datas here] end

				break;
			case "bpjsPcarePendaftaransId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPcarePendaftarans.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Bpjs Pcare Pendaftarans here] end

				break;
			case "invoicesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoices.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Invoices here] end

				break;
			case "registrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Registrations here] end

				break;
			case "visitNumber":
				// % protected region % [Add any additional logic before the query parameters of visitNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of visitNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.visitNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of visitNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of visitNumber here] end

				break;
			case "visitDate":
				// % protected region % [Add any additional logic before the query parameters of visitDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of visitDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.visitDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of visitDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of visitDate here] end

				break;
			case "registrationLocation":
				// % protected region % [Add any additional logic before the query parameters of registrationLocation here] off begin
				// % protected region % [Add any additional logic before the query parameters of registrationLocation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrationLocation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of registrationLocation here] off begin
				// % protected region % [Add any additional logic after the query parameters of registrationLocation here] end

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
	public PatientVisitEntity updateOldData(PatientVisitEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PatientVisitEntity updateOldData(PatientVisitEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PatientVisitEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPatientVisitEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to one reference
		if (entity.getBpjsPcareRegistrations() == null && entity.getBpjsPcareRegistrationsId() == null) {
			entityToUpdate.unsetBpjsPcareRegistrations();
		} else if (entity.getBpjsPcareRegistrationsId() != null && entity.getBpjsPcareRegistrations() == null) {
			Optional<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsEntity = this.bpjsPcareRegistrationsRepository.findById(entity.getBpjsPcareRegistrationsId());
			entityToUpdate.setBpjsPcareRegistrations(bpjsPcareRegistrationsEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsPcareRegistrations() != null) {
			entityToUpdate.setBpjsPcareRegistrations(entity.getBpjsPcareRegistrations(), false);
			if (entityToUpdate.getBpjsPcareRegistrationsId() != null) {
				this.bpjsPcareRegistrationsRepository.save(entityToUpdate.getBpjsPcareRegistrations());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsPcareRegistrations().unsetPatientVisit();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientVisitPatientPaymentInsurance() == null && entity.getPatientVisitPatientPaymentInsuranceId() == null) {
			entityToUpdate.unsetPatientVisitPatientPaymentInsurance();
		} else if (entity.getPatientVisitPatientPaymentInsuranceId() != null && entity.getPatientVisitPatientPaymentInsurance() == null) {
			Optional<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsuranceEntity = this.patientVisitPatientPaymentInsuranceRepository.findById(entity.getPatientVisitPatientPaymentInsuranceId());
			entityToUpdate.setPatientVisitPatientPaymentInsurance(patientVisitPatientPaymentInsuranceEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisitPatientPaymentInsurance() != null) {
			entityToUpdate.setPatientVisitPatientPaymentInsurance(entity.getPatientVisitPatientPaymentInsurance(), false);
			if (entityToUpdate.getPatientVisitPatientPaymentInsuranceId() != null) {
				this.patientVisitPatientPaymentInsuranceRepository.save(entityToUpdate.getPatientVisitPatientPaymentInsurance());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisitPatientPaymentInsurance().unsetPatientVisit();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientVisitPatientPaymentOthers() == null && entity.getPatientVisitPatientPaymentOthersId() == null) {
			entityToUpdate.unsetPatientVisitPatientPaymentOthers();
		} else if (entity.getPatientVisitPatientPaymentOthersId() != null && entity.getPatientVisitPatientPaymentOthers() == null) {
			Optional<PatientVisitPatientPaymentOthersEntity> patientVisitPatientPaymentOthersEntity = this.patientVisitPatientPaymentOthersRepository.findById(entity.getPatientVisitPatientPaymentOthersId());
			entityToUpdate.setPatientVisitPatientPaymentOthers(patientVisitPatientPaymentOthersEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisitPatientPaymentOthers() != null) {
			entityToUpdate.setPatientVisitPatientPaymentOthers(entity.getPatientVisitPatientPaymentOthers(), false);
			if (entityToUpdate.getPatientVisitPatientPaymentOthersId() != null) {
				this.patientVisitPatientPaymentOthersRepository.save(entityToUpdate.getPatientVisitPatientPaymentOthers());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisitPatientPaymentOthers().unsetPatientVisit();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientVisitPaymentSelfPaying() == null && entity.getPatientVisitPaymentSelfPayingId() == null) {
			entityToUpdate.unsetPatientVisitPaymentSelfPaying();
		} else if (entity.getPatientVisitPaymentSelfPayingId() != null && entity.getPatientVisitPaymentSelfPaying() == null) {
			Optional<PatientVisitPaymentSelfPayingEntity> patientVisitPaymentSelfPayingEntity = this.patientVisitPaymentSelfPayingRepository.findById(entity.getPatientVisitPaymentSelfPayingId());
			entityToUpdate.setPatientVisitPaymentSelfPaying(patientVisitPaymentSelfPayingEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisitPaymentSelfPaying() != null) {
			entityToUpdate.setPatientVisitPaymentSelfPaying(entity.getPatientVisitPaymentSelfPaying(), false);
			if (entityToUpdate.getPatientVisitPaymentSelfPayingId() != null) {
				this.patientVisitPaymentSelfPayingRepository.save(entityToUpdate.getPatientVisitPaymentSelfPaying());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisitPaymentSelfPaying().unsetPatientVisit();
			}
		}

		// Incoming One to Many reference
		if (entity.getPatient() == null && entity.getPatientId() == null) {
			entityToUpdate.unsetPatient();
		} else if (entity.getPatientId() != null && entity.getPatient() == null) {
			Optional<PatientGeneralInfoEntity> patientEntity = this.patientGeneralInfoRepository.findById(entity.getPatientId());
			entityToUpdate.setPatient(patientEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatient() != null) {
			entityToUpdate.setPatient(entity.getPatient(), false);
			if (entityToUpdate.getPatientId() != null) {
				this.patientGeneralInfoRepository.save(entityToUpdate.getPatient());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatient().unsetVisits();
			}
		}

		// Outgoing one to many reference
		if (entity.getBpjsVisitDatasIds().isEmpty() && entity.getBpjsVisitDatas().isEmpty()) {
			entityToUpdate.setBpjsVisitDatas(new HashSet<>());
		} else if (!entity.getBpjsVisitDatasIds().isEmpty() && entity.getBpjsVisitDatas().isEmpty()) {
			Iterable<BpjsVisitDataEntity> bpjsVisitDatasEntities =
					this.bpjsVisitDataRepository.findAllById(entity.getBpjsVisitDatasIds());
			entityToUpdate.setBpjsVisitDatas(Sets.newHashSet(bpjsVisitDatasEntities));
		}
		if (persistRelations && !entity.getBpjsVisitDatas().isEmpty()) {
			Set<BpjsVisitDataEntity> updatedEntities = new HashSet<>();
			entity.getBpjsVisitDatas().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsVisitDataRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsVisitDatas(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsPcarePendaftaransIds().isEmpty() && entity.getBpjsPcarePendaftarans().isEmpty()) {
			entityToUpdate.setBpjsPcarePendaftarans(new HashSet<>());
		} else if (!entity.getBpjsPcarePendaftaransIds().isEmpty() && entity.getBpjsPcarePendaftarans().isEmpty()) {
			Iterable<BpjsPcarePendaftaranEntity> bpjsPcarePendaftaransEntities =
					this.bpjsPcarePendaftaranRepository.findAllById(entity.getBpjsPcarePendaftaransIds());
			entityToUpdate.setBpjsPcarePendaftarans(Sets.newHashSet(bpjsPcarePendaftaransEntities));
		}
		if (persistRelations && !entity.getBpjsPcarePendaftarans().isEmpty()) {
			Set<BpjsPcarePendaftaranEntity> updatedEntities = new HashSet<>();
			entity.getBpjsPcarePendaftarans().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsPcarePendaftaranRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsPcarePendaftarans(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			entityToUpdate.setInvoices(new HashSet<>());
		} else if (!entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			Iterable<InvoiceEntity> invoicesEntities =
					this.invoiceRepository.findAllById(entity.getInvoicesIds());
			entityToUpdate.setInvoices(Sets.newHashSet(invoicesEntities));
		}
		if (persistRelations && !entity.getInvoices().isEmpty()) {
			Set<InvoiceEntity> updatedEntities = new HashSet<>();
			entity.getInvoices().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoices(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			entityToUpdate.setRegistrations(new HashSet<>());
		} else if (!entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			Iterable<RegistrationEntity> registrationsEntities =
					this.registrationRepository.findAllById(entity.getRegistrationsIds());
			entityToUpdate.setRegistrations(Sets.newHashSet(registrationsEntities));
		}
		if (persistRelations && !entity.getRegistrations().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getRegistrations().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRegistrations(updatedEntities);
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
	public void validateEntity(PatientVisitEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PatientVisitEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PatientVisitEntity.
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

	public Set<String> validateEntityRelations(PatientVisitEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientId() + " is not associated with a Patient General Info Entity");
		}

		if (entity.getBpjsPcareRegistrationsId() != null && this.bpjsPcareRegistrationsRepository.findById(entity.getBpjsPcareRegistrationsId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsPcareRegistrationsId() + " is not associated with a BPJS Pcare Registrations Entity");
		}

		for (UUID id : entity.getBpjsVisitDatasIds()) {
			if (this.bpjsVisitDataRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Visit Data Entity");
			}
		}

		for (UUID id : entity.getBpjsPcarePendaftaransIds()) {
			if (this.bpjsPcarePendaftaranRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bpjs Pcare Pendaftaran Entity");
			}
		}

		for (UUID id : entity.getInvoicesIds()) {
			if (this.invoiceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Entity");
			}
		}

		if (entity.getPatientVisitPatientPaymentInsuranceId() != null && this.patientVisitPatientPaymentInsuranceRepository.findById(entity.getPatientVisitPatientPaymentInsuranceId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitPatientPaymentInsuranceId() + " is not associated with a Patient Visit Patient Payment Insurance Entity");
		}

		if (entity.getPatientVisitPatientPaymentOthersId() != null && this.patientVisitPatientPaymentOthersRepository.findById(entity.getPatientVisitPatientPaymentOthersId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitPatientPaymentOthersId() + " is not associated with a Patient Visit Patient Payment Others Entity");
		}

		if (entity.getPatientVisitPaymentSelfPayingId() != null && this.patientVisitPaymentSelfPayingRepository.findById(entity.getPatientVisitPaymentSelfPayingId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitPaymentSelfPayingId() + " is not associated with a Patient Visit Payment Self Paying Entity");
		}

		for (UUID id : entity.getRegistrationsIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
