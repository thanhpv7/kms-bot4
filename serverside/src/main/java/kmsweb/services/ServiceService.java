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
import kmsweb.repositories.ServiceRepository;
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
import kmsweb.entities.BpjsPcarePoliEntity;
import kmsweb.repositories.BpjsPcarePoliRepository;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.ServiceFacilityCategoryEntity;
import kmsweb.repositories.ServiceFacilityCategoryRepository;
import kmsweb.entities.ServiceItemEntity;
import kmsweb.repositories.ServiceItemRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class ServiceService extends AbstractService<ServiceEntity, ServiceRepository, ServiceEntityAudit> {

	private final String[] referenceNamesInServiceEntity = {
		"bpjsPcarePoli",
		"bpjsServiceMapping",
		"doctorSchedules",
		"examinationGroups",
		"mcuPackageItems",
		"referringUnit",
		"registrations",
		"serviceFacilityCategories",
		"serviceItems",
		"defaultMedicalStaff",
		"assignedMedicalStaff",
	};

	private final BpjsPcarePoliRepository bpjsPcarePoliRepository;

	private final BpjsServiceMappingRepository bpjsServiceMappingRepository;

	private final DoctorScheduleRepository doctorScheduleRepository;

	private final ExaminationGroupRepository examinationGroupRepository;

	private final McuPackageItemRepository mcuPackageItemRepository;

	private final RegistrationRepository registrationRepository;

	private final ServiceFacilityCategoryRepository serviceFacilityCategoryRepository;

	private final ServiceItemRepository serviceItemRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ServiceService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsPcarePoliRepository bpjsPcarePoliRepository,
		BpjsServiceMappingRepository bpjsServiceMappingRepository,
		DoctorScheduleRepository doctorScheduleRepository,
		ExaminationGroupRepository examinationGroupRepository,
		McuPackageItemRepository mcuPackageItemRepository,
		RegistrationRepository registrationRepository,
		ServiceFacilityCategoryRepository serviceFacilityCategoryRepository,
		ServiceItemRepository serviceItemRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		ServiceRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsPcarePoliRepository = bpjsPcarePoliRepository;

		this.bpjsServiceMappingRepository = bpjsServiceMappingRepository;

		this.doctorScheduleRepository = doctorScheduleRepository;

		this.examinationGroupRepository = examinationGroupRepository;

		this.mcuPackageItemRepository = mcuPackageItemRepository;

		this.registrationRepository = registrationRepository;

		this.serviceFacilityCategoryRepository = serviceFacilityCategoryRepository;

		this.serviceItemRepository = serviceItemRepository;

		this.staffRepository = staffRepository;

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
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
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
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Service Number.
	 *
	 * @param serviceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Number
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ServiceEntity> findByServiceNumber(String serviceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByServiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByServiceNumber before the main body here] end

		Optional<ServiceEntity> entity = repository.findByServiceNumber(serviceNumber);

		// % protected region % [Add any additional logic for findByServiceNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByServiceNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Service Name.
	 *
	 * @param serviceName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Name
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findByServiceName(String serviceName)
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceName here] end
	{
		// % protected region % [Add any additional logic for findByServiceName before the main body here] off begin
		// % protected region % [Add any additional logic for findByServiceName before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findByServiceName(serviceName));

		// % protected region % [Add any additional logic for findByServiceName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByServiceName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Section Code.
	 *
	 * @param sectionCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Section Code
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findBySectionCode(String sectionCode)
	// % protected region % [Add any throwables, implementations, or extensions for findBySectionCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySectionCode here] end
	{
		// % protected region % [Add any additional logic for findBySectionCode before the main body here] off begin
		// % protected region % [Add any additional logic for findBySectionCode before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findBySectionCode(sectionCode));

		// % protected region % [Add any additional logic for findBySectionCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySectionCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute By pass Doctor Assignment.
	 *
	 * @param byPassDoctorAssignment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute By pass Doctor Assignment
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findByByPassDoctorAssignment(Boolean byPassDoctorAssignment)
	// % protected region % [Add any throwables, implementations, or extensions for findByByPassDoctorAssignment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByByPassDoctorAssignment here] end
	{
		// % protected region % [Add any additional logic for findByByPassDoctorAssignment before the main body here] off begin
		// % protected region % [Add any additional logic for findByByPassDoctorAssignment before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findByByPassDoctorAssignment(byPassDoctorAssignment));

		// % protected region % [Add any additional logic for findByByPassDoctorAssignment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByByPassDoctorAssignment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Has Examination Item.
	 *
	 * @param hasExaminationItem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Examination Item
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findByHasExaminationItem(Boolean hasExaminationItem)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasExaminationItem here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasExaminationItem here] end
	{
		// % protected region % [Add any additional logic for findByHasExaminationItem before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasExaminationItem before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findByHasExaminationItem(hasExaminationItem));

		// % protected region % [Add any additional logic for findByHasExaminationItem before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasExaminationItem before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findByRevenueCenter(String revenueCenter)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] end
	{
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findByRevenueCenter(revenueCenter));

		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Service Code.
	 *
	 * @param serviceCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Code
	 */
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findByServiceCode(String serviceCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCode here] end
	{
		// % protected region % [Add any additional logic for findByServiceCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByServiceCode before the main body here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findByServiceCode(serviceCode));

		// % protected region % [Add any additional logic for findByServiceCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByServiceCode before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ServiceEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<ServiceEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<ServiceEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ServiceEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<ServiceEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ServiceEntity', 'create')")
	public ServiceEntity create(ServiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		ServiceEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ServiceEntity', 'create')")
	public ServiceEntity create(ServiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		ServiceEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		ServiceEntity newEntity;

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
	@PreAuthorize("hasPermission('ServiceEntity', 'create')")
	public List<ServiceEntity> createAll(Iterable<ServiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<ServiceEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<ServiceEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ServiceEntity', 'update')")
	public ServiceEntity update(ServiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		ServiceEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ServiceEntity', 'update')")
	public ServiceEntity update(ServiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		ServiceEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		ServiceEntity newEntity;

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
	@PreAuthorize("hasPermission('ServiceEntity', 'update')")
	public List<ServiceEntity> updateAll(Iterable<ServiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<ServiceEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<ServiceEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'create') or hasPermission('ServiceEntity', 'update')")
	public ServiceEntity save(ServiceEntity entity) throws ConstraintViolationException
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

		ServiceEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'create') or hasPermission('ServiceEntity', 'update')")
	public List<ServiceEntity> saveAll(Iterable<ServiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<ServiceEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ServiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public List<ServiceEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public List<ServiceEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ServiceEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(ServiceEntity.class);

		// % protected region % [Add any additional processing before converting to a list of ServiceEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of ServiceEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ServiceEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of ServiceEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of ServiceEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(ServiceEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of ServiceEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of ServiceEntityAudits
	 */
	private List<ServiceEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<ServiceEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param service service to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private ServiceEntity updateAuditData(ServiceEntity service)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return service;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private ServiceEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		ServiceEntity entityAtRevision = updateAuditData((ServiceEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new ServiceEntityAudit(
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

		QServiceEntity entity = QServiceEntity.serviceEntity;

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
			case "bpjsPcarePoliId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to BPJS Pcare Poli here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to BPJS Pcare Poli here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPcarePoli.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to BPJS Pcare Poli here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to BPJS Pcare Poli here] end

				break;
			case "bpjsServiceMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to BPJS Service Mapping here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to BPJS Service Mapping here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsServiceMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to BPJS Service Mapping here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to BPJS Service Mapping here] end

				break;
			case "defaultMedicalStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Default Medical Staff to Service here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Default Medical Staff to Service here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.defaultMedicalStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Default Medical Staff to Service here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Default Medical Staff to Service here] end

				break;
			case "doctorSchedulesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Doctor Schedules here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorSchedules.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Doctor Schedules here] end

				break;
			case "examinationGroupsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Examination Groups here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Examination Groups here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationGroups.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Examination Groups here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Examination Groups here] end

				break;
			case "mcuPackageItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to MCU Package Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to MCU Package Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.mcuPackageItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to MCU Package Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to MCU Package Items here] end

				break;
			case "referringUnitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Referring Unit to Referring Unit here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Referring Unit to Referring Unit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringUnit.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Referring Unit to Referring Unit here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Referring Unit to Referring Unit here] end

				break;
			case "registrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Registrations here] end

				break;
			case "serviceFacilityCategoriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Service Facility Categories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Service Facility Categories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceFacilityCategories.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Service Facility Categories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Service Facility Categories here] end

				break;
			case "serviceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Services to Service Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Services to Service Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Services to Service Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Services to Service Items here] end

				break;
			case "assignedMedicalStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Assigned Medical Staff to Services here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Assigned Medical Staff to Services here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.assignedMedicalStaff.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Assigned Medical Staff to Services here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Assigned Medical Staff to Services here] end

				break;
			case "serviceName":
				// % protected region % [Add any additional logic before the query parameters of serviceName here] off begin
				// % protected region % [Add any additional logic before the query parameters of serviceName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of serviceName here] off begin
				// % protected region % [Add any additional logic after the query parameters of serviceName here] end

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
	public ServiceEntity updateOldData(ServiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public ServiceEntity updateOldData(ServiceEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		ServiceEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInServiceEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getByPassDoctorAssignment() == null) {
			entityToUpdate.setByPassDoctorAssignment(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHasExaminationItem() == null) {
			entityToUpdate.setHasExaminationItem(false);
		}

		// Incoming One to One reference
		if (entity.getDefaultMedicalStaff() == null && entity.getDefaultMedicalStaffId() == null) {
			entityToUpdate.unsetDefaultMedicalStaff();
		} else if (entity.getDefaultMedicalStaffId() != null && entity.getDefaultMedicalStaff() == null) {
			Optional<StaffEntity> defaultMedicalStaffEntity = this.staffRepository.findById(entity.getDefaultMedicalStaffId());
			entityToUpdate.setDefaultMedicalStaff(defaultMedicalStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getDefaultMedicalStaff() != null) {
			entityToUpdate.setDefaultMedicalStaff(entity.getDefaultMedicalStaff(), false);
			if (entityToUpdate.getDefaultMedicalStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getDefaultMedicalStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDefaultMedicalStaff().unsetService();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsPcarePoli() == null && entity.getBpjsPcarePoliId() == null) {
			entityToUpdate.unsetBpjsPcarePoli();
		} else if (entity.getBpjsPcarePoliId() != null && entity.getBpjsPcarePoli() == null) {
			Optional<BpjsPcarePoliEntity> bpjsPcarePoliEntity = this.bpjsPcarePoliRepository.findById(entity.getBpjsPcarePoliId());
			entityToUpdate.setBpjsPcarePoli(bpjsPcarePoliEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsPcarePoli() != null) {
			entityToUpdate.setBpjsPcarePoli(entity.getBpjsPcarePoli(), false);
			if (entityToUpdate.getBpjsPcarePoliId() != null) {
				this.bpjsPcarePoliRepository.save(entityToUpdate.getBpjsPcarePoli());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsPcarePoli().unsetService();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsServiceMapping() == null && entity.getBpjsServiceMappingId() == null) {
			entityToUpdate.unsetBpjsServiceMapping();
		} else if (entity.getBpjsServiceMappingId() != null && entity.getBpjsServiceMapping() == null) {
			Optional<BpjsServiceMappingEntity> bpjsServiceMappingEntity = this.bpjsServiceMappingRepository.findById(entity.getBpjsServiceMappingId());
			entityToUpdate.setBpjsServiceMapping(bpjsServiceMappingEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsServiceMapping() != null) {
			entityToUpdate.setBpjsServiceMapping(entity.getBpjsServiceMapping(), false);
			if (entityToUpdate.getBpjsServiceMappingId() != null) {
				this.bpjsServiceMappingRepository.save(entityToUpdate.getBpjsServiceMapping());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsServiceMapping().unsetService();
			}
		}

		// Outgoing one to many reference
		if (entity.getDoctorSchedulesIds().isEmpty() && entity.getDoctorSchedules().isEmpty()) {
			entityToUpdate.setDoctorSchedules(new HashSet<>());
		} else if (!entity.getDoctorSchedulesIds().isEmpty() && entity.getDoctorSchedules().isEmpty()) {
			Iterable<DoctorScheduleEntity> doctorSchedulesEntities =
					this.doctorScheduleRepository.findAllById(entity.getDoctorSchedulesIds());
			entityToUpdate.setDoctorSchedules(Sets.newHashSet(doctorSchedulesEntities));
		}
		if (persistRelations && !entity.getDoctorSchedules().isEmpty()) {
			Set<DoctorScheduleEntity> updatedEntities = new HashSet<>();
			entity.getDoctorSchedules().forEach(model -> {
				if (model.getId() != null) {
					model = this.doctorScheduleRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDoctorSchedules(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getExaminationGroupsIds().isEmpty() && entity.getExaminationGroups().isEmpty()) {
			entityToUpdate.setExaminationGroups(new HashSet<>());
		} else if (!entity.getExaminationGroupsIds().isEmpty() && entity.getExaminationGroups().isEmpty()) {
			Iterable<ExaminationGroupEntity> examinationGroupsEntities =
					this.examinationGroupRepository.findAllById(entity.getExaminationGroupsIds());
			entityToUpdate.setExaminationGroups(Sets.newHashSet(examinationGroupsEntities));
		}
		if (persistRelations && !entity.getExaminationGroups().isEmpty()) {
			Set<ExaminationGroupEntity> updatedEntities = new HashSet<>();
			entity.getExaminationGroups().forEach(model -> {
				if (model.getId() != null) {
					model = this.examinationGroupRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setExaminationGroups(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMcuPackageItemsIds().isEmpty() && entity.getMcuPackageItems().isEmpty()) {
			entityToUpdate.setMcuPackageItems(new HashSet<>());
		} else if (!entity.getMcuPackageItemsIds().isEmpty() && entity.getMcuPackageItems().isEmpty()) {
			Iterable<McuPackageItemEntity> mcuPackageItemsEntities =
					this.mcuPackageItemRepository.findAllById(entity.getMcuPackageItemsIds());
			entityToUpdate.setMcuPackageItems(Sets.newHashSet(mcuPackageItemsEntities));
		}
		if (persistRelations && !entity.getMcuPackageItems().isEmpty()) {
			Set<McuPackageItemEntity> updatedEntities = new HashSet<>();
			entity.getMcuPackageItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.mcuPackageItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMcuPackageItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getReferringUnitIds().isEmpty() && entity.getReferringUnit().isEmpty()) {
			entityToUpdate.setReferringUnit(new HashSet<>());
		} else if (!entity.getReferringUnitIds().isEmpty() && entity.getReferringUnit().isEmpty()) {
			Iterable<RegistrationEntity> referringUnitEntities =
					this.registrationRepository.findAllById(entity.getReferringUnitIds());
			entityToUpdate.setReferringUnit(Sets.newHashSet(referringUnitEntities));
		}
		if (persistRelations && !entity.getReferringUnit().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getReferringUnit().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setReferringUnit(updatedEntities);
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

		// Outgoing one to many reference
		if (entity.getServiceFacilityCategoriesIds().isEmpty() && entity.getServiceFacilityCategories().isEmpty()) {
			entityToUpdate.setServiceFacilityCategories(new HashSet<>());
		} else if (!entity.getServiceFacilityCategoriesIds().isEmpty() && entity.getServiceFacilityCategories().isEmpty()) {
			Iterable<ServiceFacilityCategoryEntity> serviceFacilityCategoriesEntities =
					this.serviceFacilityCategoryRepository.findAllById(entity.getServiceFacilityCategoriesIds());
			entityToUpdate.setServiceFacilityCategories(Sets.newHashSet(serviceFacilityCategoriesEntities));
		}
		if (persistRelations && !entity.getServiceFacilityCategories().isEmpty()) {
			Set<ServiceFacilityCategoryEntity> updatedEntities = new HashSet<>();
			entity.getServiceFacilityCategories().forEach(model -> {
				if (model.getId() != null) {
					model = this.serviceFacilityCategoryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setServiceFacilityCategories(updatedEntities);
		}

		// Outgoing many to many reference
		if (entity.getServiceItemsIds().isEmpty() && entity.getServiceItems().isEmpty()) {
			entityToUpdate.setServiceItems(new HashSet<>());
		} else if (!entity.getServiceItemsIds().isEmpty() && entity.getServiceItems().isEmpty()) {
			Iterable<ServiceItemEntity> serviceItemsEntities =
					this.serviceItemRepository.findAllById(entity.getServiceItemsIds());
			entityToUpdate.setServiceItems(Sets.newHashSet(serviceItemsEntities));
		}
		if (persistRelations && !entity.getServiceItems().isEmpty()) {
			Set<ServiceItemEntity> updatedEntities = new HashSet<>();
			entity.getServiceItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.serviceItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setServiceItems(updatedEntities);
		}

		// Incoming many to many reference
		if (entity.getAssignedMedicalStaffIds().isEmpty() && entity.getAssignedMedicalStaff().isEmpty()) {
			entityToUpdate.setAssignedMedicalStaff(new HashSet<>());
		} else if (!entity.getAssignedMedicalStaffIds().isEmpty() && entity.getAssignedMedicalStaff().isEmpty()) {
			Iterable<StaffEntity> assignedMedicalStaffEntities =
					this.staffRepository.findAllById(entity.getAssignedMedicalStaffIds());
			entityToUpdate.setAssignedMedicalStaff(Sets.newHashSet(assignedMedicalStaffEntities));
		}
		if (persistRelations && !entity.getAssignedMedicalStaff().isEmpty()) {
			Set<StaffEntity> updatedEntities = new HashSet<>();
			entity.getAssignedMedicalStaff().forEach(model -> {
				if (model.getId() != null) {
					model = this.staffRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAssignedMedicalStaff(updatedEntities);
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
	public void validateEntity(ServiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<ServiceEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByServiceNumberOpt = this.findByServiceNumber(entity.getServiceNumber());
			if (entityByServiceNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<ServiceEntity>(
						"Service Number",
						entity.getServiceNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ServiceNumber"
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
	 * Get the sort as given by the sort by for the ServiceEntity.
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

	public Set<String> validateEntityRelations(ServiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDefaultMedicalStaffId() != null && this.staffRepository.findById(entity.getDefaultMedicalStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getDefaultMedicalStaffId() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getAssignedMedicalStaffIds()) {
			if (this.staffRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Staff Entity");
			}
		}

		if (entity.getBpjsPcarePoliId() != null && this.bpjsPcarePoliRepository.findById(entity.getBpjsPcarePoliId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsPcarePoliId() + " is not associated with a BPJS Pcare Poli Entity");
		}

		if (entity.getBpjsServiceMappingId() != null && this.bpjsServiceMappingRepository.findById(entity.getBpjsServiceMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsServiceMappingId() + " is not associated with a BPJS Service Mapping Entity");
		}

		for (UUID id : entity.getDoctorSchedulesIds()) {
			if (this.doctorScheduleRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Doctor Schedule Entity");
			}
		}

		for (UUID id : entity.getExaminationGroupsIds()) {
			if (this.examinationGroupRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Examination Group Entity");
			}
		}

		for (UUID id : entity.getMcuPackageItemsIds()) {
			if (this.mcuPackageItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a MCU Package Item Entity");
			}
		}

		for (UUID id : entity.getReferringUnitIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getRegistrationsIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getServiceFacilityCategoriesIds()) {
			if (this.serviceFacilityCategoryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Service Facility Category Entity");
			}
		}

		for (UUID id : entity.getServiceItemsIds()) {
			if (this.serviceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Service Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
