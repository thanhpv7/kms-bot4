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
import kmsweb.repositories.BpjsClaimSubmissionRepository;
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
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.entities.BpjsDismissalConditionEntity;
import kmsweb.repositories.BpjsDismissalConditionRepository;
import kmsweb.entities.BpjsDismissalMappingEntity;
import kmsweb.repositories.BpjsDismissalMappingRepository;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.repositories.BpjsProcedureRepository;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.entities.BpjsTreatmentRoomEntity;
import kmsweb.repositories.BpjsTreatmentRoomRepository;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsClaimSubmissionService extends AbstractService<BpjsClaimSubmissionEntity, BpjsClaimSubmissionRepository, BpjsClaimSubmissionEntityAudit> {

	private final String[] referenceNamesInBpjsClaimSubmissionEntity = {
		"bpjsDismissalConditions",
		"bpjsDismissalMappings",
		"bpjsTreatmentRooms",
		"bpjsDiagnose",
		"bpjsDoctorMapping",
		"bpjsHealthFacility",
		"bpjsProcedure",
		"bpjsServiceMapping",
		"patientGeneralInfo",
		"patientPaymentBPJS",
	};

	private final BpjsDiagnoseRepository bpjsDiagnoseRepository;

	private final BpjsDismissalConditionRepository bpjsDismissalConditionRepository;

	private final BpjsDismissalMappingRepository bpjsDismissalMappingRepository;

	private final BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	private final BpjsHealthFacilityRepository bpjsHealthFacilityRepository;

	private final BpjsProcedureRepository bpjsProcedureRepository;

	private final BpjsServiceMappingRepository bpjsServiceMappingRepository;

	private final BpjsTreatmentRoomRepository bpjsTreatmentRoomRepository;

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private final PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsClaimSubmissionService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BpjsDiagnoseRepository bpjsDiagnoseRepository,
		BpjsDismissalConditionRepository bpjsDismissalConditionRepository,
		BpjsDismissalMappingRepository bpjsDismissalMappingRepository,
		BpjsDoctorMappingRepository bpjsDoctorMappingRepository,
		BpjsHealthFacilityRepository bpjsHealthFacilityRepository,
		BpjsProcedureRepository bpjsProcedureRepository,
		BpjsServiceMappingRepository bpjsServiceMappingRepository,
		BpjsTreatmentRoomRepository bpjsTreatmentRoomRepository,
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		PatientPaymentBPJSRepository patientPaymentBPJSRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsClaimSubmissionRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsDiagnoseRepository = bpjsDiagnoseRepository;

		this.bpjsDismissalConditionRepository = bpjsDismissalConditionRepository;

		this.bpjsDismissalMappingRepository = bpjsDismissalMappingRepository;

		this.bpjsDoctorMappingRepository = bpjsDoctorMappingRepository;

		this.bpjsHealthFacilityRepository = bpjsHealthFacilityRepository;

		this.bpjsProcedureRepository = bpjsProcedureRepository;

		this.bpjsServiceMappingRepository = bpjsServiceMappingRepository;

		this.bpjsTreatmentRoomRepository = bpjsTreatmentRoomRepository;

		this.patientGeneralInfoRepository = patientGeneralInfoRepository;

		this.patientPaymentBPJSRepository = patientPaymentBPJSRepository;

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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Admission Date.
	 *
	 * @param admissionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByAdmissionDate(OffsetDateTime admissionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] end
	{
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByAdmissionDate(admissionDate));

		// % protected region % [Add any additional logic for findByAdmissionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByDismissalDate(OffsetDateTime dismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByDismissalDate(dismissalDate));

		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Insurance Provider.
	 *
	 * @param insuranceProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Insurance Provider
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByInsuranceProvider(String insuranceProvider)
	// % protected region % [Add any throwables, implementations, or extensions for findByInsuranceProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInsuranceProvider here] end
	{
		// % protected region % [Add any additional logic for findByInsuranceProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByInsuranceProvider before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByInsuranceProvider(insuranceProvider));

		// % protected region % [Add any additional logic for findByInsuranceProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInsuranceProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByTreatmentType(String treatmentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByTreatmentType(treatmentType));

		// % protected region % [Add any additional logic for findByTreatmentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Follow Up Plan.
	 *
	 * @param followUpPlan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Follow Up Plan
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByFollowUpPlan(String followUpPlan)
	// % protected region % [Add any throwables, implementations, or extensions for findByFollowUpPlan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFollowUpPlan here] end
	{
		// % protected region % [Add any additional logic for findByFollowUpPlan before the main body here] off begin
		// % protected region % [Add any additional logic for findByFollowUpPlan before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByFollowUpPlan(followUpPlan));

		// % protected region % [Add any additional logic for findByFollowUpPlan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFollowUpPlan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Control Date.
	 *
	 * @param controlDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Date
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByControlDate(OffsetDateTime controlDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlDate here] end
	{
		// % protected region % [Add any additional logic for findByControlDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlDate before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByControlDate(controlDate));

		// % protected region % [Add any additional logic for findByControlDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Additional Diagnosis.
	 *
	 * @param additionalDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Diagnosis
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByAdditionalDiagnosis(String additionalDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByAdditionalDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionalDiagnosis before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByAdditionalDiagnosis(additionalDiagnosis));

		// % protected region % [Add any additional logic for findByAdditionalDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionalDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Additional Procedure.
	 *
	 * @param additionalProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Procedure
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByAdditionalProcedure(String additionalProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalProcedure here] end
	{
		// % protected region % [Add any additional logic for findByAdditionalProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionalProcedure before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByAdditionalProcedure(additionalProcedure));

		// % protected region % [Add any additional logic for findByAdditionalProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionalProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Kelas Rawat.
	 *
	 * @param kelasRawat the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Kelas Rawat
	 */
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findByKelasRawat(KelasRawatEnum kelasRawat)
	// % protected region % [Add any throwables, implementations, or extensions for findByKelasRawat here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKelasRawat here] end
	{
		// % protected region % [Add any additional logic for findByKelasRawat before the main body here] off begin
		// % protected region % [Add any additional logic for findByKelasRawat before the main body here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findByKelasRawat(kelasRawat));

		// % protected region % [Add any additional logic for findByKelasRawat before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKelasRawat before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsClaimSubmissionEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsClaimSubmissionEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsClaimSubmissionEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create')")
	public BpjsClaimSubmissionEntity create(BpjsClaimSubmissionEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsClaimSubmissionEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create')")
	public BpjsClaimSubmissionEntity create(BpjsClaimSubmissionEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsClaimSubmissionEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsClaimSubmissionEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create')")
	public List<BpjsClaimSubmissionEntity> createAll(Iterable<BpjsClaimSubmissionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsClaimSubmissionEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsClaimSubmissionEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public BpjsClaimSubmissionEntity update(BpjsClaimSubmissionEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsClaimSubmissionEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public BpjsClaimSubmissionEntity update(BpjsClaimSubmissionEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsClaimSubmissionEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsClaimSubmissionEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public List<BpjsClaimSubmissionEntity> updateAll(Iterable<BpjsClaimSubmissionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsClaimSubmissionEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsClaimSubmissionEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create') or hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public BpjsClaimSubmissionEntity save(BpjsClaimSubmissionEntity entity) throws ConstraintViolationException
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

		BpjsClaimSubmissionEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'create') or hasPermission('BpjsClaimSubmissionEntity', 'update')")
	public List<BpjsClaimSubmissionEntity> saveAll(Iterable<BpjsClaimSubmissionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsClaimSubmissionEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	public List<BpjsClaimSubmissionEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	public List<BpjsClaimSubmissionEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsClaimSubmissionEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsClaimSubmissionEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsClaimSubmissionEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsClaimSubmissionEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsClaimSubmissionEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsClaimSubmissionEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsClaimSubmissionEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsClaimSubmissionEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsClaimSubmissionEntityAudits
	 */
	private List<BpjsClaimSubmissionEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsClaimSubmissionEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsClaimSubmission bpjsClaimSubmission to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsClaimSubmissionEntity updateAuditData(BpjsClaimSubmissionEntity bpjsClaimSubmission)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsClaimSubmission;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsClaimSubmissionEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsClaimSubmissionEntity entityAtRevision = updateAuditData((BpjsClaimSubmissionEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsClaimSubmissionEntityAudit(
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

		QBpjsClaimSubmissionEntity entity = QBpjsClaimSubmissionEntity.bpjsClaimSubmissionEntity;

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
			case "bpjsDiagnoseId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Diagnose to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Diagnose to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDiagnose.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Diagnose to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Diagnose to BPJS Claim Submissions here] end

				break;
			case "bpjsDoctorMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Doctor Mapping to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDoctorMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Doctor Mapping to BPJS Claim Submissions here] end

				break;
			case "bpjsHealthFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Health Facility to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Health Facility to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsHealthFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Health Facility to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Health Facility to BPJS Claim Submissions here] end

				break;
			case "bpjsProcedureId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Procedure to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Procedure to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsProcedure.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Procedure to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Procedure to BPJS Claim Submissions here] end

				break;
			case "bpjsServiceMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Service Mapping to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsServiceMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Service Mapping to BPJS Claim Submissions here] end

				break;
			case "patientGeneralInfoId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientGeneralInfo.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to BPJS Claim Submissions here] end

				break;
			case "patientPaymentBPJSId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentBPJS.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Payment BPJS to BPJS Claim Submissions here] end

				break;
			case "bpjsDismissalConditionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Conditions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Conditions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDismissalConditions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Conditions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Conditions here] end

				break;
			case "bpjsDismissalMappingsId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Mappings here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Mappings here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDismissalMappings.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Mappings here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Dismissal Mappings here] end

				break;
			case "bpjsTreatmentRoomsId":
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Treatment Rooms here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from BPJS Claim Submission to BPJS Treatment Rooms here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsTreatmentRooms.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Treatment Rooms here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from BPJS Claim Submission to BPJS Treatment Rooms here] end

				break;
			case "sepNo":
				// % protected region % [Add any additional logic before the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepNo here] end

				break;
			case "admissionDate":
				// % protected region % [Add any additional logic before the query parameters of admissionDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of admissionDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.admissionDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of admissionDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of admissionDate here] end

				break;
			case "dismissalDate":
				// % protected region % [Add any additional logic before the query parameters of dismissalDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of dismissalDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dismissalDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of dismissalDate here] end

				break;
			case "insuranceProvider":
				// % protected region % [Add any additional logic before the query parameters of insuranceProvider here] off begin
				// % protected region % [Add any additional logic before the query parameters of insuranceProvider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.insuranceProvider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of insuranceProvider here] off begin
				// % protected region % [Add any additional logic after the query parameters of insuranceProvider here] end

				break;
			case "treatmentType":
				// % protected region % [Add any additional logic before the query parameters of treatmentType here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentType here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentType here] end

				break;
			case "followUpPlan":
				// % protected region % [Add any additional logic before the query parameters of followUpPlan here] off begin
				// % protected region % [Add any additional logic before the query parameters of followUpPlan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.followUpPlan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of followUpPlan here] off begin
				// % protected region % [Add any additional logic after the query parameters of followUpPlan here] end

				break;
			case "controlDate":
				// % protected region % [Add any additional logic before the query parameters of controlDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlDate here] end

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
	public BpjsClaimSubmissionEntity updateOldData(BpjsClaimSubmissionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsClaimSubmissionEntity updateOldData(BpjsClaimSubmissionEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsClaimSubmissionEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsClaimSubmissionEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getBpjsDiagnose() == null && entity.getBpjsDiagnoseId() == null) {
			entityToUpdate.unsetBpjsDiagnose();
		} else if (entity.getBpjsDiagnoseId() != null && entity.getBpjsDiagnose() == null) {
			Optional<BpjsDiagnoseEntity> bpjsDiagnoseEntity = this.bpjsDiagnoseRepository.findById(entity.getBpjsDiagnoseId());
			entityToUpdate.setBpjsDiagnose(bpjsDiagnoseEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsDiagnose() != null) {
			entityToUpdate.setBpjsDiagnose(entity.getBpjsDiagnose(), false);
			if (entityToUpdate.getBpjsDiagnoseId() != null) {
				this.bpjsDiagnoseRepository.save(entityToUpdate.getBpjsDiagnose());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsDiagnose().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
		if (entity.getBpjsDoctorMapping() == null && entity.getBpjsDoctorMappingId() == null) {
			entityToUpdate.unsetBpjsDoctorMapping();
		} else if (entity.getBpjsDoctorMappingId() != null && entity.getBpjsDoctorMapping() == null) {
			Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingEntity = this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId());
			entityToUpdate.setBpjsDoctorMapping(bpjsDoctorMappingEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsDoctorMapping() != null) {
			entityToUpdate.setBpjsDoctorMapping(entity.getBpjsDoctorMapping(), false);
			if (entityToUpdate.getBpjsDoctorMappingId() != null) {
				this.bpjsDoctorMappingRepository.save(entityToUpdate.getBpjsDoctorMapping());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsDoctorMapping().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
		if (entity.getBpjsHealthFacility() == null && entity.getBpjsHealthFacilityId() == null) {
			entityToUpdate.unsetBpjsHealthFacility();
		} else if (entity.getBpjsHealthFacilityId() != null && entity.getBpjsHealthFacility() == null) {
			Optional<BpjsHealthFacilityEntity> bpjsHealthFacilityEntity = this.bpjsHealthFacilityRepository.findById(entity.getBpjsHealthFacilityId());
			entityToUpdate.setBpjsHealthFacility(bpjsHealthFacilityEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsHealthFacility() != null) {
			entityToUpdate.setBpjsHealthFacility(entity.getBpjsHealthFacility(), false);
			if (entityToUpdate.getBpjsHealthFacilityId() != null) {
				this.bpjsHealthFacilityRepository.save(entityToUpdate.getBpjsHealthFacility());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsHealthFacility().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
		if (entity.getBpjsProcedure() == null && entity.getBpjsProcedureId() == null) {
			entityToUpdate.unsetBpjsProcedure();
		} else if (entity.getBpjsProcedureId() != null && entity.getBpjsProcedure() == null) {
			Optional<BpjsProcedureEntity> bpjsProcedureEntity = this.bpjsProcedureRepository.findById(entity.getBpjsProcedureId());
			entityToUpdate.setBpjsProcedure(bpjsProcedureEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsProcedure() != null) {
			entityToUpdate.setBpjsProcedure(entity.getBpjsProcedure(), false);
			if (entityToUpdate.getBpjsProcedureId() != null) {
				this.bpjsProcedureRepository.save(entityToUpdate.getBpjsProcedure());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsProcedure().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
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
				entityToUpdate.getBpjsServiceMapping().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
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
				entityToUpdate.getPatientGeneralInfo().unsetBpjsClaimSubmissions();
			}
		}

		// Incoming One to Many reference
		if (entity.getPatientPaymentBPJS() == null && entity.getPatientPaymentBPJSId() == null) {
			entityToUpdate.unsetPatientPaymentBPJS();
		} else if (entity.getPatientPaymentBPJSId() != null && entity.getPatientPaymentBPJS() == null) {
			Optional<PatientPaymentBPJSEntity> patientPaymentBPJSEntity = this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId());
			entityToUpdate.setPatientPaymentBPJS(patientPaymentBPJSEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPaymentBPJS() != null) {
			entityToUpdate.setPatientPaymentBPJS(entity.getPatientPaymentBPJS(), false);
			if (entityToUpdate.getPatientPaymentBPJSId() != null) {
				this.patientPaymentBPJSRepository.save(entityToUpdate.getPatientPaymentBPJS());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPaymentBPJS().unsetBpjsClaimSubmissions();
			}
		}

		// Outgoing one to many reference
		if (entity.getBpjsDismissalConditionsIds().isEmpty() && entity.getBpjsDismissalConditions().isEmpty()) {
			entityToUpdate.setBpjsDismissalConditions(new HashSet<>());
		} else if (!entity.getBpjsDismissalConditionsIds().isEmpty() && entity.getBpjsDismissalConditions().isEmpty()) {
			Iterable<BpjsDismissalConditionEntity> bpjsDismissalConditionsEntities =
					this.bpjsDismissalConditionRepository.findAllById(entity.getBpjsDismissalConditionsIds());
			entityToUpdate.setBpjsDismissalConditions(Sets.newHashSet(bpjsDismissalConditionsEntities));
		}
		if (persistRelations && !entity.getBpjsDismissalConditions().isEmpty()) {
			Set<BpjsDismissalConditionEntity> updatedEntities = new HashSet<>();
			entity.getBpjsDismissalConditions().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsDismissalConditionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsDismissalConditions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsDismissalMappingsIds().isEmpty() && entity.getBpjsDismissalMappings().isEmpty()) {
			entityToUpdate.setBpjsDismissalMappings(new HashSet<>());
		} else if (!entity.getBpjsDismissalMappingsIds().isEmpty() && entity.getBpjsDismissalMappings().isEmpty()) {
			Iterable<BpjsDismissalMappingEntity> bpjsDismissalMappingsEntities =
					this.bpjsDismissalMappingRepository.findAllById(entity.getBpjsDismissalMappingsIds());
			entityToUpdate.setBpjsDismissalMappings(Sets.newHashSet(bpjsDismissalMappingsEntities));
		}
		if (persistRelations && !entity.getBpjsDismissalMappings().isEmpty()) {
			Set<BpjsDismissalMappingEntity> updatedEntities = new HashSet<>();
			entity.getBpjsDismissalMappings().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsDismissalMappingRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsDismissalMappings(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getBpjsTreatmentRoomsIds().isEmpty() && entity.getBpjsTreatmentRooms().isEmpty()) {
			entityToUpdate.setBpjsTreatmentRooms(new HashSet<>());
		} else if (!entity.getBpjsTreatmentRoomsIds().isEmpty() && entity.getBpjsTreatmentRooms().isEmpty()) {
			Iterable<BpjsTreatmentRoomEntity> bpjsTreatmentRoomsEntities =
					this.bpjsTreatmentRoomRepository.findAllById(entity.getBpjsTreatmentRoomsIds());
			entityToUpdate.setBpjsTreatmentRooms(Sets.newHashSet(bpjsTreatmentRoomsEntities));
		}
		if (persistRelations && !entity.getBpjsTreatmentRooms().isEmpty()) {
			Set<BpjsTreatmentRoomEntity> updatedEntities = new HashSet<>();
			entity.getBpjsTreatmentRooms().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsTreatmentRoomRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsTreatmentRooms(updatedEntities);
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
	public void validateEntity(BpjsClaimSubmissionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsClaimSubmissionEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsClaimSubmissionEntity.
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

	public Set<String> validateEntityRelations(BpjsClaimSubmissionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getBpjsDiagnoseId() != null && this.bpjsDiagnoseRepository.findById(entity.getBpjsDiagnoseId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsDiagnoseId() + " is not associated with a BPJS Diagnose Entity");
		}

		if (entity.getBpjsDoctorMappingId() != null && this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsDoctorMappingId() + " is not associated with a BPJS Doctor Mapping Entity");
		}

		if (entity.getBpjsHealthFacilityId() != null && this.bpjsHealthFacilityRepository.findById(entity.getBpjsHealthFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsHealthFacilityId() + " is not associated with a BPJS Health Facility Entity");
		}

		if (entity.getBpjsProcedureId() != null && this.bpjsProcedureRepository.findById(entity.getBpjsProcedureId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsProcedureId() + " is not associated with a BPJS Procedure Entity");
		}

		if (entity.getBpjsServiceMappingId() != null && this.bpjsServiceMappingRepository.findById(entity.getBpjsServiceMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsServiceMappingId() + " is not associated with a BPJS Service Mapping Entity");
		}

		if (entity.getPatientGeneralInfoId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientGeneralInfoId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientGeneralInfoId() + " is not associated with a Patient General Info Entity");
		}

		if (entity.getPatientPaymentBPJSId() != null && this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPaymentBPJSId() + " is not associated with a Patient Payment BPJS Entity");
		}

		for (UUID id : entity.getBpjsDismissalConditionsIds()) {
			if (this.bpjsDismissalConditionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Dismissal Condition Entity");
			}
		}

		for (UUID id : entity.getBpjsDismissalMappingsIds()) {
			if (this.bpjsDismissalMappingRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Dismissal Mapping Entity");
			}
		}

		for (UUID id : entity.getBpjsTreatmentRoomsIds()) {
			if (this.bpjsTreatmentRoomRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Treatment Room Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
