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
import kmsweb.repositories.PcareExaminationRepository;
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
import kmsweb.entities.PcareActionExaminationEntity;
import kmsweb.repositories.PcareActionExaminationRepository;
import kmsweb.entities.PcareCompoundDrugEntity;
import kmsweb.repositories.PcareCompoundDrugRepository;
import kmsweb.entities.PcareNonCompoundDrugEntity;
import kmsweb.repositories.PcareNonCompoundDrugRepository;
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
public class PcareExaminationService extends AbstractService<PcareExaminationEntity, PcareExaminationRepository, PcareExaminationEntityAudit> {

	private final String[] referenceNamesInPcareExaminationEntity = {
		"pcareActionExaminations",
		"pcareCompoundDrugs",
		"pcareNonCompoundDrugs",
		"registration",
	};

	private final PcareActionExaminationRepository pcareActionExaminationRepository;

	private final PcareCompoundDrugRepository pcareCompoundDrugRepository;

	private final PcareNonCompoundDrugRepository pcareNonCompoundDrugRepository;

	private final RegistrationRepository registrationRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PcareExaminationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PcareActionExaminationRepository pcareActionExaminationRepository,
		PcareCompoundDrugRepository pcareCompoundDrugRepository,
		PcareNonCompoundDrugRepository pcareNonCompoundDrugRepository,
		RegistrationRepository registrationRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PcareExaminationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.pcareActionExaminationRepository = pcareActionExaminationRepository;

		this.pcareCompoundDrugRepository = pcareCompoundDrugRepository;

		this.pcareNonCompoundDrugRepository = pcareNonCompoundDrugRepository;

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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Visit Type.
	 *
	 * @param visitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Type
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByVisitType(String visitType)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitType here] end
	{
		// % protected region % [Add any additional logic for findByVisitType before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitType before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByVisitType(visitType));

		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment.
	 *
	 * @param treatment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByTreatment(String treatment)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatment here] end
	{
		// % protected region % [Add any additional logic for findByTreatment before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatment before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByTreatment(treatment));

		// % protected region % [Add any additional logic for findByTreatment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Destination Polyclinic.
	 *
	 * @param destinationPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination Polyclinic
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDestinationPolyclinic(String destinationPolyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByDestinationPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByDestinationPolyclinic before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDestinationPolyclinic(destinationPolyclinic));

		// % protected region % [Add any additional logic for findByDestinationPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDestinationPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Disease.
	 *
	 * @param disease the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Disease
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDisease(String disease)
	// % protected region % [Add any throwables, implementations, or extensions for findByDisease here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDisease here] end
	{
		// % protected region % [Add any additional logic for findByDisease before the main body here] off begin
		// % protected region % [Add any additional logic for findByDisease before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDisease(disease));

		// % protected region % [Add any additional logic for findByDisease before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDisease before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis.
	 *
	 * @param diagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDiagnosis(String diagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDiagnosis(diagnosis));

		// % protected region % [Add any additional logic for findByDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis 2.
	 *
	 * @param diagnosis2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis 2
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDiagnosis2(String diagnosis2)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis2 here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosis2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis2 before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDiagnosis2(diagnosis2));

		// % protected region % [Add any additional logic for findByDiagnosis2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnosis 3.
	 *
	 * @param diagnosis3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnosis 3
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDiagnosis3(String diagnosis3)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosis3 here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosis3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis3 before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDiagnosis3(diagnosis3));

		// % protected region % [Add any additional logic for findByDiagnosis3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosis3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Therapy.
	 *
	 * @param therapy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Therapy
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByTherapy(String therapy)
	// % protected region % [Add any throwables, implementations, or extensions for findByTherapy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTherapy here] end
	{
		// % protected region % [Add any additional logic for findByTherapy before the main body here] off begin
		// % protected region % [Add any additional logic for findByTherapy before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByTherapy(therapy));

		// % protected region % [Add any additional logic for findByTherapy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTherapy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consciousness.
	 *
	 * @param consciousness the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consciousness
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByConsciousness(String consciousness)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsciousness here] end
	{
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByConsciousness(consciousness));

		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsciousness before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discharge Status.
	 *
	 * @param dischargeStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharge Status
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDischargeStatus(String dischargeStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargeStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargeStatus here] end
	{
		// % protected region % [Add any additional logic for findByDischargeStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByDischargeStatus before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDischargeStatus(dischargeStatus));

		// % protected region % [Add any additional logic for findByDischargeStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDischargeStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Internal Referral Polyclinic.
	 *
	 * @param internalReferralPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Internal Referral Polyclinic
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByInternalReferralPolyclinic(String internalReferralPolyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByInternalReferralPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInternalReferralPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByInternalReferralPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByInternalReferralPolyclinic before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByInternalReferralPolyclinic(internalReferralPolyclinic));

		// % protected region % [Add any additional logic for findByInternalReferralPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInternalReferralPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referring Date.
	 *
	 * @param referringDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Date
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByReferringDate(OffsetDateTime referringDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringDate here] end
	{
		// % protected region % [Add any additional logic for findByReferringDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferringDate before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByReferringDate(referringDate));

		// % protected region % [Add any additional logic for findByReferringDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferringDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute PKK.
	 *
	 * @param pkk the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PKK
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByPkk(String pkk)
	// % protected region % [Add any throwables, implementations, or extensions for findByPkk here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPkk here] end
	{
		// % protected region % [Add any additional logic for findByPkk before the main body here] off begin
		// % protected region % [Add any additional logic for findByPkk before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByPkk(pkk));

		// % protected region % [Add any additional logic for findByPkk before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPkk before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Specialist.
	 *
	 * @param subSpecialist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Specialist
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findBySubSpecialist(String subSpecialist)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubSpecialist here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubSpecialist here] end
	{
		// % protected region % [Add any additional logic for findBySubSpecialist before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubSpecialist before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findBySubSpecialist(subSpecialist));

		// % protected region % [Add any additional logic for findBySubSpecialist before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubSpecialist before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility.
	 *
	 * @param facility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByFacility(String facility)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacility here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacility here] end
	{
		// % protected region % [Add any additional logic for findByFacility before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacility before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByFacility(facility));

		// % protected region % [Add any additional logic for findByFacility before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacility before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute TACC.
	 *
	 * @param tacc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute TACC
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByTacc(String tacc)
	// % protected region % [Add any throwables, implementations, or extensions for findByTacc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTacc here] end
	{
		// % protected region % [Add any additional logic for findByTacc before the main body here] off begin
		// % protected region % [Add any additional logic for findByTacc before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByTacc(tacc));

		// % protected region % [Add any additional logic for findByTacc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTacc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute TACC Reason.
	 *
	 * @param taccReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute TACC Reason
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByTaccReason(String taccReason)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaccReason here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaccReason here] end
	{
		// % protected region % [Add any additional logic for findByTaccReason before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaccReason before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByTaccReason(taccReason));

		// % protected region % [Add any additional logic for findByTaccReason before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaccReason before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Special.
	 *
	 * @param special the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Special
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findBySpecial(String special)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecial here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecial here] end
	{
		// % protected region % [Add any additional logic for findBySpecial before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecial before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findBySpecial(special));

		// % protected region % [Add any additional logic for findBySpecial before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecial before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Height.
	 *
	 * @param height the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Height
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByHeight(Double height)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeight here] end
	{
		// % protected region % [Add any additional logic for findByHeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeight before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByHeight(height));

		// % protected region % [Add any additional logic for findByHeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Waist Circumference.
	 *
	 * @param waistCircumference the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Waist Circumference
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByWaistCircumference(Double waistCircumference)
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWaistCircumference here] end
	{
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByWaistCircumference(waistCircumference));

		// % protected region % [Add any additional logic for findByWaistCircumference before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWaistCircumference before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BMI.
	 *
	 * @param bmi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BMI
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByBmi(Double bmi)
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBmi here] end
	{
		// % protected region % [Add any additional logic for findByBmi before the main body here] off begin
		// % protected region % [Add any additional logic for findByBmi before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByBmi(bmi));

		// % protected region % [Add any additional logic for findByBmi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBmi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Systole.
	 *
	 * @param systole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Systole
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findBySystole(Integer systole)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystole here] end
	{
		// % protected region % [Add any additional logic for findBySystole before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystole before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findBySystole(systole));

		// % protected region % [Add any additional logic for findBySystole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diastole.
	 *
	 * @param diastole the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diastole
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByDiastole(Integer diastole)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiastole here] end
	{
		// % protected region % [Add any additional logic for findByDiastole before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiastole before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByDiastole(diastole));

		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiastole before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Respiratory Rate.
	 *
	 * @param respiratoryRate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Respiratory Rate
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByRespiratoryRate(Double respiratoryRate)
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratoryRate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRespiratoryRate here] end
	{
		// % protected region % [Add any additional logic for findByRespiratoryRate before the main body here] off begin
		// % protected region % [Add any additional logic for findByRespiratoryRate before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByRespiratoryRate(respiratoryRate));

		// % protected region % [Add any additional logic for findByRespiratoryRate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRespiratoryRate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Heart Rate.
	 *
	 * @param heartRate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heart Rate
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByHeartRate(Double heartRate)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartRate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeartRate here] end
	{
		// % protected region % [Add any additional logic for findByHeartRate before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeartRate before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByHeartRate(heartRate));

		// % protected region % [Add any additional logic for findByHeartRate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeartRate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff.
	 *
	 * @param medicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByMedicalStaff(String medicalStaff)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaff here] end
	{
		// % protected region % [Add any additional logic for findByMedicalStaff before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaff before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByMedicalStaff(medicalStaff));

		// % protected region % [Add any additional logic for findByMedicalStaff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute tglPulang.
	 *
	 * @param tglpulang the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute tglPulang
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByTglpulang(String tglpulang)
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpulang here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTglpulang here] end
	{
		// % protected region % [Add any additional logic for findByTglpulang before the main body here] off begin
		// % protected region % [Add any additional logic for findByTglpulang before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByTglpulang(tglpulang));

		// % protected region % [Add any additional logic for findByTglpulang before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTglpulang before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kdSubSpesialis1.
	 *
	 * @param kdsubspesialis1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kdSubSpesialis1
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByKdsubspesialis1(String kdsubspesialis1)
	// % protected region % [Add any throwables, implementations, or extensions for findByKdsubspesialis1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKdsubspesialis1 here] end
	{
		// % protected region % [Add any additional logic for findByKdsubspesialis1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByKdsubspesialis1 before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByKdsubspesialis1(kdsubspesialis1));

		// % protected region % [Add any additional logic for findByKdsubspesialis1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKdsubspesialis1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute rujukLanjut.
	 *
	 * @param rujuklanjut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute rujukLanjut
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByRujuklanjut(String rujuklanjut)
	// % protected region % [Add any throwables, implementations, or extensions for findByRujuklanjut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRujuklanjut here] end
	{
		// % protected region % [Add any additional logic for findByRujuklanjut before the main body here] off begin
		// % protected region % [Add any additional logic for findByRujuklanjut before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByRujuklanjut(rujuklanjut));

		// % protected region % [Add any additional logic for findByRujuklanjut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRujuklanjut before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute catatan.
	 *
	 * @param catatan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute catatan
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByCatatan(String catatan)
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCatatan here] end
	{
		// % protected region % [Add any additional logic for findByCatatan before the main body here] off begin
		// % protected region % [Add any additional logic for findByCatatan before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByCatatan(catatan));

		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCatatan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute noKunjungan.
	 *
	 * @param nokunjungan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute noKunjungan
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByNokunjungan(String nokunjungan)
	// % protected region % [Add any throwables, implementations, or extensions for findByNokunjungan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNokunjungan here] end
	{
		// % protected region % [Add any additional logic for findByNokunjungan before the main body here] off begin
		// % protected region % [Add any additional logic for findByNokunjungan before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByNokunjungan(nokunjungan));

		// % protected region % [Add any additional logic for findByNokunjungan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNokunjungan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute JsonInsert.
	 *
	 * @param jsoninsert the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JsonInsert
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByJsoninsert(String jsoninsert)
	// % protected region % [Add any throwables, implementations, or extensions for findByJsoninsert here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJsoninsert here] end
	{
		// % protected region % [Add any additional logic for findByJsoninsert before the main body here] off begin
		// % protected region % [Add any additional logic for findByJsoninsert before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByJsoninsert(jsoninsert));

		// % protected region % [Add any additional logic for findByJsoninsert before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJsoninsert before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute JsonUpdate.
	 *
	 * @param jsonupdate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute JsonUpdate
	 */
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findByJsonupdate(String jsonupdate)
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonupdate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJsonupdate here] end
	{
		// % protected region % [Add any additional logic for findByJsonupdate before the main body here] off begin
		// % protected region % [Add any additional logic for findByJsonupdate before the main body here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findByJsonupdate(jsonupdate));

		// % protected region % [Add any additional logic for findByJsonupdate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJsonupdate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PcareExaminationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PcareExaminationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PcareExaminationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PcareExaminationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create')")
	public PcareExaminationEntity create(PcareExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PcareExaminationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create')")
	public PcareExaminationEntity create(PcareExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PcareExaminationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PcareExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create')")
	public List<PcareExaminationEntity> createAll(Iterable<PcareExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PcareExaminationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PcareExaminationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'update')")
	public PcareExaminationEntity update(PcareExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PcareExaminationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'update')")
	public PcareExaminationEntity update(PcareExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PcareExaminationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PcareExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'update')")
	public List<PcareExaminationEntity> updateAll(Iterable<PcareExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PcareExaminationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PcareExaminationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create') or hasPermission('PcareExaminationEntity', 'update')")
	public PcareExaminationEntity save(PcareExaminationEntity entity) throws ConstraintViolationException
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

		PcareExaminationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'create') or hasPermission('PcareExaminationEntity', 'update')")
	public List<PcareExaminationEntity> saveAll(Iterable<PcareExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PcareExaminationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	public List<PcareExaminationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	public List<PcareExaminationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PcareExaminationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PcareExaminationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareExaminationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PcareExaminationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PcareExaminationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PcareExaminationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PcareExaminationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PcareExaminationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PcareExaminationEntityAudits
	 */
	private List<PcareExaminationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PcareExaminationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param pcareExamination pcareExamination to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PcareExaminationEntity updateAuditData(PcareExaminationEntity pcareExamination)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return pcareExamination;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PcareExaminationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PcareExaminationEntity entityAtRevision = updateAuditData((PcareExaminationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PcareExaminationEntityAudit(
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

		QPcareExaminationEntity entity = QPcareExaminationEntity.pcareExaminationEntity;

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
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to PCare Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to PCare Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to PCare Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to PCare Examination here] end

				break;
			case "pcareActionExaminationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Action Examinations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Action Examinations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareActionExaminations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Action Examinations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Action Examinations here] end

				break;
			case "pcareCompoundDrugsId":
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Compound Drugs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare Compound Drugs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareCompoundDrugs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Compound Drugs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare Compound Drugs here] end

				break;
			case "pcareNonCompoundDrugsId":
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare NonCompound Drugs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from PCare Examination to PCare NonCompound Drugs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareNonCompoundDrugs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare NonCompound Drugs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from PCare Examination to PCare NonCompound Drugs here] end

				break;
			case "tglpulang":
				// % protected region % [Add any additional logic before the query parameters of tglpulang here] off begin
				// % protected region % [Add any additional logic before the query parameters of tglpulang here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tglpulang, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tglpulang here] off begin
				// % protected region % [Add any additional logic after the query parameters of tglpulang here] end

				break;
			case "nokunjungan":
				// % protected region % [Add any additional logic before the query parameters of nokunjungan here] off begin
				// % protected region % [Add any additional logic before the query parameters of nokunjungan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nokunjungan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of nokunjungan here] off begin
				// % protected region % [Add any additional logic after the query parameters of nokunjungan here] end

				break;
			case "jsoninsert":
				// % protected region % [Add any additional logic before the query parameters of jsoninsert here] off begin
				// % protected region % [Add any additional logic before the query parameters of jsoninsert here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.jsoninsert, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of jsoninsert here] off begin
				// % protected region % [Add any additional logic after the query parameters of jsoninsert here] end

				break;
			case "jsonupdate":
				// % protected region % [Add any additional logic before the query parameters of jsonupdate here] off begin
				// % protected region % [Add any additional logic before the query parameters of jsonupdate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.jsonupdate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of jsonupdate here] off begin
				// % protected region % [Add any additional logic after the query parameters of jsonupdate here] end

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
	public PcareExaminationEntity updateOldData(PcareExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PcareExaminationEntity updateOldData(PcareExaminationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PcareExaminationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPcareExaminationEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
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
				entityToUpdate.getRegistration().unsetPcareExamination();
			}
		}

		// Outgoing one to many reference
		if (entity.getPcareActionExaminationsIds().isEmpty() && entity.getPcareActionExaminations().isEmpty()) {
			entityToUpdate.setPcareActionExaminations(new HashSet<>());
		} else if (!entity.getPcareActionExaminationsIds().isEmpty() && entity.getPcareActionExaminations().isEmpty()) {
			Iterable<PcareActionExaminationEntity> pcareActionExaminationsEntities =
					this.pcareActionExaminationRepository.findAllById(entity.getPcareActionExaminationsIds());
			entityToUpdate.setPcareActionExaminations(Sets.newHashSet(pcareActionExaminationsEntities));
		}
		if (persistRelations && !entity.getPcareActionExaminations().isEmpty()) {
			Set<PcareActionExaminationEntity> updatedEntities = new HashSet<>();
			entity.getPcareActionExaminations().forEach(model -> {
				if (model.getId() != null) {
					model = this.pcareActionExaminationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPcareActionExaminations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPcareCompoundDrugsIds().isEmpty() && entity.getPcareCompoundDrugs().isEmpty()) {
			entityToUpdate.setPcareCompoundDrugs(new HashSet<>());
		} else if (!entity.getPcareCompoundDrugsIds().isEmpty() && entity.getPcareCompoundDrugs().isEmpty()) {
			Iterable<PcareCompoundDrugEntity> pcareCompoundDrugsEntities =
					this.pcareCompoundDrugRepository.findAllById(entity.getPcareCompoundDrugsIds());
			entityToUpdate.setPcareCompoundDrugs(Sets.newHashSet(pcareCompoundDrugsEntities));
		}
		if (persistRelations && !entity.getPcareCompoundDrugs().isEmpty()) {
			Set<PcareCompoundDrugEntity> updatedEntities = new HashSet<>();
			entity.getPcareCompoundDrugs().forEach(model -> {
				if (model.getId() != null) {
					model = this.pcareCompoundDrugRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPcareCompoundDrugs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPcareNonCompoundDrugsIds().isEmpty() && entity.getPcareNonCompoundDrugs().isEmpty()) {
			entityToUpdate.setPcareNonCompoundDrugs(new HashSet<>());
		} else if (!entity.getPcareNonCompoundDrugsIds().isEmpty() && entity.getPcareNonCompoundDrugs().isEmpty()) {
			Iterable<PcareNonCompoundDrugEntity> pcareNonCompoundDrugsEntities =
					this.pcareNonCompoundDrugRepository.findAllById(entity.getPcareNonCompoundDrugsIds());
			entityToUpdate.setPcareNonCompoundDrugs(Sets.newHashSet(pcareNonCompoundDrugsEntities));
		}
		if (persistRelations && !entity.getPcareNonCompoundDrugs().isEmpty()) {
			Set<PcareNonCompoundDrugEntity> updatedEntities = new HashSet<>();
			entity.getPcareNonCompoundDrugs().forEach(model -> {
				if (model.getId() != null) {
					model = this.pcareNonCompoundDrugRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPcareNonCompoundDrugs(updatedEntities);
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
	public void validateEntity(PcareExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PcareExaminationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PcareExaminationEntity.
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

	public Set<String> validateEntityRelations(PcareExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		for (UUID id : entity.getPcareActionExaminationsIds()) {
			if (this.pcareActionExaminationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a PCare Action Examination Entity");
			}
		}

		for (UUID id : entity.getPcareCompoundDrugsIds()) {
			if (this.pcareCompoundDrugRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a PCare Compound Drug Entity");
			}
		}

		for (UUID id : entity.getPcareNonCompoundDrugsIds()) {
			if (this.pcareNonCompoundDrugRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a PCare NonCompound Drug Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
