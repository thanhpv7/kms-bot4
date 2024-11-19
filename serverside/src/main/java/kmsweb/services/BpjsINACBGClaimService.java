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
import kmsweb.repositories.BpjsINACBGClaimRepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsINACBGClaimService extends AbstractService<BpjsINACBGClaimEntity, BpjsINACBGClaimRepository, BpjsINACBGClaimEntityAudit> {

	private final String[] referenceNamesInBpjsINACBGClaimEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsINACBGClaimService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsINACBGClaimRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsINACBGClaimEntity> findByClaimNo(String claimNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] end
	{
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] end

		Optional<BpjsINACBGClaimEntity> entity = repository.findByClaimNo(claimNo);

		// % protected region % [Add any additional logic for findByClaimNo before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByPatientID(String patientID)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] end
	{
		// % protected region % [Add any additional logic for findByPatientID before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientID before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByPatientID(patientID));

		// % protected region % [Add any additional logic for findByPatientID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Number.
	 *
	 * @param invoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Number
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByInvoiceNumber(String invoiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByInvoiceNumber(invoiceNumber));

		// % protected region % [Add any additional logic for findByInvoiceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTreatmentType(String treatmentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTreatmentType(treatmentType));

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Admission Date.
	 *
	 * @param admissionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByAdmissionDate(OffsetDateTime admissionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] end
	{
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByAdmissionDate(admissionDate));

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDismissalDate(OffsetDateTime dismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDismissalDate(dismissalDate));

		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute LOS.
	 *
	 * @param los the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LOS
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByLos(String los)
	// % protected region % [Add any throwables, implementations, or extensions for findByLos here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLos here] end
	{
		// % protected region % [Add any additional logic for findByLos before the main body here] off begin
		// % protected region % [Add any additional logic for findByLos before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByLos(los));

		// % protected region % [Add any additional logic for findByLos before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLos before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal.
	 *
	 * @param dismissal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDismissal(String dismissal)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissal here] end
	{
		// % protected region % [Add any additional logic for findByDismissal before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissal before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDismissal(dismissal));

		// % protected region % [Add any additional logic for findByDismissal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Responsible Doctor.
	 *
	 * @param responsibleDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Responsible Doctor
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByResponsibleDoctor(String responsibleDoctor)
	// % protected region % [Add any throwables, implementations, or extensions for findByResponsibleDoctor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResponsibleDoctor here] end
	{
		// % protected region % [Add any additional logic for findByResponsibleDoctor before the main body here] off begin
		// % protected region % [Add any additional logic for findByResponsibleDoctor before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByResponsibleDoctor(responsibleDoctor));

		// % protected region % [Add any additional logic for findByResponsibleDoctor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResponsibleDoctor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByWeight(Double weight)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeight here] end
	{
		// % protected region % [Add any additional logic for findByWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeight before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByWeight(weight));

		// % protected region % [Add any additional logic for findByWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ADL.
	 *
	 * @param adl the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ADL
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByAdl(Integer adl)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdl here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdl here] end
	{
		// % protected region % [Add any additional logic for findByAdl before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdl before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByAdl(adl));

		// % protected region % [Add any additional logic for findByAdl before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdl before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim Status.
	 *
	 * @param claimStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Status
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByClaimStatus(String claimStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimStatus here] end
	{
		// % protected region % [Add any additional logic for findByClaimStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimStatus before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByClaimStatus(claimStatus));

		// % protected region % [Add any additional logic for findByClaimStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Status.
	 *
	 * @param sepStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Status
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySepStatus(String sepStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepStatus here] end
	{
		// % protected region % [Add any additional logic for findBySepStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepStatus before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySepStatus(sepStatus));

		// % protected region % [Add any additional logic for findBySepStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Tariff.
	 *
	 * @param hospitalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByHospitalTariff(Double hospitalTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalTariff here] end
	{
		// % protected region % [Add any additional logic for findByHospitalTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByHospitalTariff(hospitalTariff));

		// % protected region % [Add any additional logic for findByHospitalTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Letter.
	 *
	 * @param referralLetter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Letter
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByReferralLetter(String referralLetter)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralLetter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralLetter here] end
	{
		// % protected region % [Add any additional logic for findByReferralLetter before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralLetter before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByReferralLetter(referralLetter));

		// % protected region % [Add any additional logic for findByReferralLetter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralLetter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Third Sel Level.
	 *
	 * @param thirdSelLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Third Sel Level
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByThirdSelLevel(String thirdSelLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByThirdSelLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByThirdSelLevel here] end
	{
		// % protected region % [Add any additional logic for findByThirdSelLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByThirdSelLevel before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByThirdSelLevel(thirdSelLevel));

		// % protected region % [Add any additional logic for findByThirdSelLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByThirdSelLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Staff Name.
	 *
	 * @param staffName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Name
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByStaffName(String staffName)
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffName here] end
	{
		// % protected region % [Add any additional logic for findByStaffName before the main body here] off begin
		// % protected region % [Add any additional logic for findByStaffName before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByStaffName(staffName));

		// % protected region % [Add any additional logic for findByStaffName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStaffName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date Grouping.
	 *
	 * @param dateGrouping the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Grouping
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDateGrouping(OffsetDateTime dateGrouping)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateGrouping here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateGrouping here] end
	{
		// % protected region % [Add any additional logic for findByDateGrouping before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateGrouping before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDateGrouping(dateGrouping));

		// % protected region % [Add any additional logic for findByDateGrouping before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateGrouping before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff.
	 *
	 * @param inacbgTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByInacbgTariff(String inacbgTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff here] end
	{
		// % protected region % [Add any additional logic for findByInacbgTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByInacbgTariff(inacbgTariff));

		// % protected region % [Add any additional logic for findByInacbgTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute CBG Type.
	 *
	 * @param cbgType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CBG Type
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByCbgType(String cbgType)
	// % protected region % [Add any throwables, implementations, or extensions for findByCbgType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCbgType here] end
	{
		// % protected region % [Add any additional logic for findByCbgType before the main body here] off begin
		// % protected region % [Add any additional logic for findByCbgType before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByCbgType(cbgType));

		// % protected region % [Add any additional logic for findByCbgType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCbgType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff.
	 *
	 * @param tariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTariff(Double tariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariff here] end
	{
		// % protected region % [Add any additional logic for findByTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTariff(tariff));

		// % protected region % [Add any additional logic for findByTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute.
	 *
	 * @param subAcute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySubAcute(String subAcute)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcute here] end
	{
		// % protected region % [Add any additional logic for findBySubAcute before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubAcute before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySubAcute(subAcute));

		// % protected region % [Add any additional logic for findBySubAcute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubAcute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute Code.
	 *
	 * @param subAcuteCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySubAcuteCode(String subAcuteCode)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcuteCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcuteCode here] end
	{
		// % protected region % [Add any additional logic for findBySubAcuteCode before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubAcuteCode before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySubAcuteCode(subAcuteCode));

		// % protected region % [Add any additional logic for findBySubAcuteCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubAcuteCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Acute Tariff.
	 *
	 * @param subAcuteTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Acute Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySubAcuteTariff(Double subAcuteTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcuteTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubAcuteTariff here] end
	{
		// % protected region % [Add any additional logic for findBySubAcuteTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubAcuteTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySubAcuteTariff(subAcuteTariff));

		// % protected region % [Add any additional logic for findBySubAcuteTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubAcuteTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chronic.
	 *
	 * @param chronic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByChronic(String chronic)
	// % protected region % [Add any throwables, implementations, or extensions for findByChronic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChronic here] end
	{
		// % protected region % [Add any additional logic for findByChronic before the main body here] off begin
		// % protected region % [Add any additional logic for findByChronic before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByChronic(chronic));

		// % protected region % [Add any additional logic for findByChronic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChronic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Code.
	 *
	 * @param chronicCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByChronicCode(String chronicCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicCode here] end
	{
		// % protected region % [Add any additional logic for findByChronicCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByChronicCode before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByChronicCode(chronicCode));

		// % protected region % [Add any additional logic for findByChronicCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChronicCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Tariff.
	 *
	 * @param chronicTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByChronicTariff(Double chronicTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicTariff here] end
	{
		// % protected region % [Add any additional logic for findByChronicTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByChronicTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByChronicTariff(chronicTariff));

		// % protected region % [Add any additional logic for findByChronicTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChronicTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Procedure.
	 *
	 * @param resultSpecProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Procedure
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByResultSpecProcedure(String resultSpecProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecProcedure here] end
	{
		// % protected region % [Add any additional logic for findByResultSpecProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findByResultSpecProcedure before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByResultSpecProcedure(resultSpecProcedure));

		// % protected region % [Add any additional logic for findByResultSpecProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResultSpecProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Drug.
	 *
	 * @param resultSpecDrug the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Drug
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByResultSpecDrug(String resultSpecDrug)
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecDrug here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecDrug here] end
	{
		// % protected region % [Add any additional logic for findByResultSpecDrug before the main body here] off begin
		// % protected region % [Add any additional logic for findByResultSpecDrug before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByResultSpecDrug(resultSpecDrug));

		// % protected region % [Add any additional logic for findByResultSpecDrug before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResultSpecDrug before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Investigation.
	 *
	 * @param resultSpecInvestigation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Investigation
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByResultSpecInvestigation(String resultSpecInvestigation)
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecInvestigation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecInvestigation here] end
	{
		// % protected region % [Add any additional logic for findByResultSpecInvestigation before the main body here] off begin
		// % protected region % [Add any additional logic for findByResultSpecInvestigation before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByResultSpecInvestigation(resultSpecInvestigation));

		// % protected region % [Add any additional logic for findByResultSpecInvestigation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResultSpecInvestigation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Result Spec Prosthesis.
	 *
	 * @param resultSpecProsthesis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Result Spec Prosthesis
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByResultSpecProsthesis(String resultSpecProsthesis)
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecProsthesis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByResultSpecProsthesis here] end
	{
		// % protected region % [Add any additional logic for findByResultSpecProsthesis before the main body here] off begin
		// % protected region % [Add any additional logic for findByResultSpecProsthesis before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByResultSpecProsthesis(resultSpecProsthesis));

		// % protected region % [Add any additional logic for findByResultSpecProsthesis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByResultSpecProsthesis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByHospitalClass(String hospitalClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] end
	{
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByHospitalClass(hospitalClass));

		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Type.
	 *
	 * @param tariffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Type
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTariffType(String tariffType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffType here] end
	{
		// % protected region % [Add any additional logic for findByTariffType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffType before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTariffType(tariffType));

		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Tariff.
	 *
	 * @param totalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTotalTariff(Double totalTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalTariff here] end
	{
		// % protected region % [Add any additional logic for findByTotalTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTotalTariff(totalTariff));

		// % protected region % [Add any additional logic for findByTotalTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visit Date.
	 *
	 * @param visitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Date
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByVisitDate(OffsetDateTime visitDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitDate here] end
	{
		// % protected region % [Add any additional logic for findByVisitDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitDate before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByVisitDate(visitDate));

		// % protected region % [Add any additional logic for findByVisitDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Spec Procedure Tariff.
	 *
	 * @param specProcedureTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Procedure Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySpecProcedureTariff(Double specProcedureTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecProcedureTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecProcedureTariff here] end
	{
		// % protected region % [Add any additional logic for findBySpecProcedureTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecProcedureTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySpecProcedureTariff(specProcedureTariff));

		// % protected region % [Add any additional logic for findBySpecProcedureTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecProcedureTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Spec Drug Tariff.
	 *
	 * @param specDrugTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Drug Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySpecDrugTariff(Double specDrugTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecDrugTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecDrugTariff here] end
	{
		// % protected region % [Add any additional logic for findBySpecDrugTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecDrugTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySpecDrugTariff(specDrugTariff));

		// % protected region % [Add any additional logic for findBySpecDrugTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecDrugTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Spec Investigation Tariff.
	 *
	 * @param specInvestigationTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Investigation Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySpecInvestigationTariff(Double specInvestigationTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecInvestigationTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecInvestigationTariff here] end
	{
		// % protected region % [Add any additional logic for findBySpecInvestigationTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecInvestigationTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySpecInvestigationTariff(specInvestigationTariff));

		// % protected region % [Add any additional logic for findBySpecInvestigationTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecInvestigationTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Spec Prosthesis Tariff.
	 *
	 * @param specProsthesisTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Spec Prosthesis Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySpecProsthesisTariff(Double specProsthesisTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecProsthesisTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecProsthesisTariff here] end
	{
		// % protected region % [Add any additional logic for findBySpecProsthesisTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecProsthesisTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySpecProsthesisTariff(specProsthesisTariff));

		// % protected region % [Add any additional logic for findBySpecProsthesisTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecProsthesisTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Upgrade Flag.
	 *
	 * @param upgradeFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upgrade Flag
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByUpgradeFlag(Boolean upgradeFlag)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpgradeFlag here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpgradeFlag here] end
	{
		// % protected region % [Add any additional logic for findByUpgradeFlag before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpgradeFlag before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByUpgradeFlag(upgradeFlag));

		// % protected region % [Add any additional logic for findByUpgradeFlag before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpgradeFlag before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute HCU Flag.
	 *
	 * @param hcuFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HCU Flag
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByHcuFlag(Boolean hcuFlag)
	// % protected region % [Add any throwables, implementations, or extensions for findByHcuFlag here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHcuFlag here] end
	{
		// % protected region % [Add any additional logic for findByHcuFlag before the main body here] off begin
		// % protected region % [Add any additional logic for findByHcuFlag before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByHcuFlag(hcuFlag));

		// % protected region % [Add any additional logic for findByHcuFlag before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHcuFlag before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Grouper Flag.
	 *
	 * @param grouperFlag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Grouper Flag
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByGrouperFlag(Boolean grouperFlag)
	// % protected region % [Add any throwables, implementations, or extensions for findByGrouperFlag here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGrouperFlag here] end
	{
		// % protected region % [Add any additional logic for findByGrouperFlag before the main body here] off begin
		// % protected region % [Add any additional logic for findByGrouperFlag before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByGrouperFlag(grouperFlag));

		// % protected region % [Add any additional logic for findByGrouperFlag before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGrouperFlag before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Non Surgery Procedure.
	 *
	 * @param nonSurgeryProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Non Surgery Procedure
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByNonSurgeryProcedure(Double nonSurgeryProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findByNonSurgeryProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNonSurgeryProcedure here] end
	{
		// % protected region % [Add any additional logic for findByNonSurgeryProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findByNonSurgeryProcedure before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByNonSurgeryProcedure(nonSurgeryProcedure));

		// % protected region % [Add any additional logic for findByNonSurgeryProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNonSurgeryProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surgery Procedure.
	 *
	 * @param surgeryProcedure the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surgery Procedure
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySurgeryProcedure(Double surgeryProcedure)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryProcedure here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurgeryProcedure here] end
	{
		// % protected region % [Add any additional logic for findBySurgeryProcedure before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurgeryProcedure before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySurgeryProcedure(surgeryProcedure));

		// % protected region % [Add any additional logic for findBySurgeryProcedure before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurgeryProcedure before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consultation.
	 *
	 * @param consultation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consultation
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByConsultation(Double consultation)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsultation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsultation here] end
	{
		// % protected region % [Add any additional logic for findByConsultation before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsultation before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByConsultation(consultation));

		// % protected region % [Add any additional logic for findByConsultation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsultation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Specialist.
	 *
	 * @param specialist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialist
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findBySpecialist(Double specialist)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialist here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialist here] end
	{
		// % protected region % [Add any additional logic for findBySpecialist before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecialist before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findBySpecialist(specialist));

		// % protected region % [Add any additional logic for findBySpecialist before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecialist before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nursing.
	 *
	 * @param nursing the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nursing
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByNursing(Double nursing)
	// % protected region % [Add any throwables, implementations, or extensions for findByNursing here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNursing here] end
	{
		// % protected region % [Add any additional logic for findByNursing before the main body here] off begin
		// % protected region % [Add any additional logic for findByNursing before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByNursing(nursing));

		// % protected region % [Add any additional logic for findByNursing before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNursing before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnostic.
	 *
	 * @param diagnostic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnostic
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDiagnostic(Double diagnostic)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnostic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnostic here] end
	{
		// % protected region % [Add any additional logic for findByDiagnostic before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnostic before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDiagnostic(diagnostic));

		// % protected region % [Add any additional logic for findByDiagnostic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnostic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Radiology.
	 *
	 * @param radiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Radiology
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByRadiology(Double radiology)
	// % protected region % [Add any throwables, implementations, or extensions for findByRadiology here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRadiology here] end
	{
		// % protected region % [Add any additional logic for findByRadiology before the main body here] off begin
		// % protected region % [Add any additional logic for findByRadiology before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByRadiology(radiology));

		// % protected region % [Add any additional logic for findByRadiology before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRadiology before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Laboratory.
	 *
	 * @param laboratory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Laboratory
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByLaboratory(Double laboratory)
	// % protected region % [Add any throwables, implementations, or extensions for findByLaboratory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLaboratory here] end
	{
		// % protected region % [Add any additional logic for findByLaboratory before the main body here] off begin
		// % protected region % [Add any additional logic for findByLaboratory before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByLaboratory(laboratory));

		// % protected region % [Add any additional logic for findByLaboratory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLaboratory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Blood Service.
	 *
	 * @param bloodService the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Service
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByBloodService(Double bloodService)
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodService here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodService here] end
	{
		// % protected region % [Add any additional logic for findByBloodService before the main body here] off begin
		// % protected region % [Add any additional logic for findByBloodService before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByBloodService(bloodService));

		// % protected region % [Add any additional logic for findByBloodService before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBloodService before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rehabilitation.
	 *
	 * @param rehabilitation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rehabilitation
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByRehabilitation(Double rehabilitation)
	// % protected region % [Add any throwables, implementations, or extensions for findByRehabilitation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRehabilitation here] end
	{
		// % protected region % [Add any additional logic for findByRehabilitation before the main body here] off begin
		// % protected region % [Add any additional logic for findByRehabilitation before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByRehabilitation(rehabilitation));

		// % protected region % [Add any additional logic for findByRehabilitation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRehabilitation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bed Accomodation.
	 *
	 * @param bedAccomodation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Accomodation
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByBedAccomodation(Double bedAccomodation)
	// % protected region % [Add any throwables, implementations, or extensions for findByBedAccomodation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBedAccomodation here] end
	{
		// % protected region % [Add any additional logic for findByBedAccomodation before the main body here] off begin
		// % protected region % [Add any additional logic for findByBedAccomodation before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByBedAccomodation(bedAccomodation));

		// % protected region % [Add any additional logic for findByBedAccomodation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBedAccomodation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Intensive Care.
	 *
	 * @param intensiveCare the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Intensive Care
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIntensiveCare(Double intensiveCare)
	// % protected region % [Add any throwables, implementations, or extensions for findByIntensiveCare here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIntensiveCare here] end
	{
		// % protected region % [Add any additional logic for findByIntensiveCare before the main body here] off begin
		// % protected region % [Add any additional logic for findByIntensiveCare before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIntensiveCare(intensiveCare));

		// % protected region % [Add any additional logic for findByIntensiveCare before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIntensiveCare before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Drugs.
	 *
	 * @param drugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Drugs
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDrugs(Double drugs)
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugs here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDrugs here] end
	{
		// % protected region % [Add any additional logic for findByDrugs before the main body here] off begin
		// % protected region % [Add any additional logic for findByDrugs before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDrugs(drugs));

		// % protected region % [Add any additional logic for findByDrugs before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDrugs before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Equipment.
	 *
	 * @param medicalEquipment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Equipment
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByMedicalEquipment(Double medicalEquipment)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalEquipment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalEquipment here] end
	{
		// % protected region % [Add any additional logic for findByMedicalEquipment before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalEquipment before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByMedicalEquipment(medicalEquipment));

		// % protected region % [Add any additional logic for findByMedicalEquipment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalEquipment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dispensed Disposable.
	 *
	 * @param dispensedDisposable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dispensed Disposable
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByDispensedDisposable(Double dispensedDisposable)
	// % protected region % [Add any throwables, implementations, or extensions for findByDispensedDisposable here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDispensedDisposable here] end
	{
		// % protected region % [Add any additional logic for findByDispensedDisposable before the main body here] off begin
		// % protected region % [Add any additional logic for findByDispensedDisposable before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByDispensedDisposable(dispensedDisposable));

		// % protected region % [Add any additional logic for findByDispensedDisposable before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDispensedDisposable before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Equipment Rental.
	 *
	 * @param equipmentRental the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Equipment Rental
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByEquipmentRental(Double equipmentRental)
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentRental here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEquipmentRental here] end
	{
		// % protected region % [Add any additional logic for findByEquipmentRental before the main body here] off begin
		// % protected region % [Add any additional logic for findByEquipmentRental before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByEquipmentRental(equipmentRental));

		// % protected region % [Add any additional logic for findByEquipmentRental before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEquipmentRental before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Code.
	 *
	 * @param icd10Code the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd10Code(String icd10Code)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Code here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Code here] end
	{
		// % protected region % [Add any additional logic for findByIcd10Code before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd10Code before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd10Code(icd10Code));

		// % protected region % [Add any additional logic for findByIcd10Code before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd10Code before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Desc.
	 *
	 * @param icd10Desc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Desc
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd10Desc(String icd10Desc)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Desc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Desc here] end
	{
		// % protected region % [Add any additional logic for findByIcd10Desc before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd10Desc before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd10Desc(icd10Desc));

		// % protected region % [Add any additional logic for findByIcd10Desc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd10Desc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD10 Tariff.
	 *
	 * @param icd10Tariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD10 Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd10Tariff(Double icd10Tariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Tariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd10Tariff here] end
	{
		// % protected region % [Add any additional logic for findByIcd10Tariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd10Tariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd10Tariff(icd10Tariff));

		// % protected region % [Add any additional logic for findByIcd10Tariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd10Tariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Code.
	 *
	 * @param icd9cmCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd9cmCode(String icd9cmCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmCode here] end
	{
		// % protected region % [Add any additional logic for findByIcd9cmCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmCode before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd9cmCode(icd9cmCode));

		// % protected region % [Add any additional logic for findByIcd9cmCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Desc.
	 *
	 * @param icd9cmDesc the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Desc
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd9cmDesc(String icd9cmDesc)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmDesc here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmDesc here] end
	{
		// % protected region % [Add any additional logic for findByIcd9cmDesc before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmDesc before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd9cmDesc(icd9cmDesc));

		// % protected region % [Add any additional logic for findByIcd9cmDesc before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmDesc before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICD9CM Tariff.
	 *
	 * @param icd9cmTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICD9CM Tariff
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByIcd9cmTariff(Double icd9cmTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcd9cmTariff here] end
	{
		// % protected region % [Add any additional logic for findByIcd9cmTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmTariff before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByIcd9cmTariff(icd9cmTariff));

		// % protected region % [Add any additional logic for findByIcd9cmTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcd9cmTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chronic Drugs.
	 *
	 * @param chronicDrugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chronic Drugs
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByChronicDrugs(Double chronicDrugs)
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicDrugs here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChronicDrugs here] end
	{
		// % protected region % [Add any additional logic for findByChronicDrugs before the main body here] off begin
		// % protected region % [Add any additional logic for findByChronicDrugs before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByChronicDrugs(chronicDrugs));

		// % protected region % [Add any additional logic for findByChronicDrugs before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChronicDrugs before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Chemotherapy Drugs.
	 *
	 * @param chemotherapyDrugs the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Chemotherapy Drugs
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByChemotherapyDrugs(Double chemotherapyDrugs)
	// % protected region % [Add any throwables, implementations, or extensions for findByChemotherapyDrugs here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChemotherapyDrugs here] end
	{
		// % protected region % [Add any additional logic for findByChemotherapyDrugs before the main body here] off begin
		// % protected region % [Add any additional logic for findByChemotherapyDrugs before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByChemotherapyDrugs(chemotherapyDrugs));

		// % protected region % [Add any additional logic for findByChemotherapyDrugs before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChemotherapyDrugs before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Class Upgrade.
	 *
	 * @param classUpgrade the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Class Upgrade
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByClassUpgrade(String classUpgrade)
	// % protected region % [Add any throwables, implementations, or extensions for findByClassUpgrade here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClassUpgrade here] end
	{
		// % protected region % [Add any additional logic for findByClassUpgrade before the main body here] off begin
		// % protected region % [Add any additional logic for findByClassUpgrade before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByClassUpgrade(classUpgrade));

		// % protected region % [Add any additional logic for findByClassUpgrade before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClassUpgrade before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute High Care Unit.
	 *
	 * @param highCareUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute High Care Unit
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByHighCareUnit(String highCareUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByHighCareUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHighCareUnit here] end
	{
		// % protected region % [Add any additional logic for findByHighCareUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByHighCareUnit before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByHighCareUnit(highCareUnit));

		// % protected region % [Add any additional logic for findByHighCareUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHighCareUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inacbg Claim Created.
	 *
	 * @param inacbgClaimCreated the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inacbg Claim Created
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByInacbgClaimCreated(Boolean inacbgClaimCreated)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgClaimCreated here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgClaimCreated here] end
	{
		// % protected region % [Add any additional logic for findByInacbgClaimCreated before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgClaimCreated before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByInacbgClaimCreated(inacbgClaimCreated));

		// % protected region % [Add any additional logic for findByInacbgClaimCreated before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgClaimCreated before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inacbg Response.
	 *
	 * @param inacbgResponse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inacbg Response
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByInacbgResponse(String inacbgResponse)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgResponse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgResponse here] end
	{
		// % protected region % [Add any additional logic for findByInacbgResponse before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgResponse before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByInacbgResponse(inacbgResponse));

		// % protected region % [Add any additional logic for findByInacbgResponse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgResponse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Invoice.
	 *
	 * @param totalInvoice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Invoice
	 */
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findByTotalInvoice(Double totalInvoice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInvoice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalInvoice here] end
	{
		// % protected region % [Add any additional logic for findByTotalInvoice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalInvoice before the main body here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findByTotalInvoice(totalInvoice));

		// % protected region % [Add any additional logic for findByTotalInvoice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalInvoice before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsINACBGClaimEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsINACBGClaimEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsINACBGClaimEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'create')")
	public BpjsINACBGClaimEntity create(BpjsINACBGClaimEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsINACBGClaimEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'create')")
	public BpjsINACBGClaimEntity create(BpjsINACBGClaimEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsINACBGClaimEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsINACBGClaimEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'create')")
	public List<BpjsINACBGClaimEntity> createAll(Iterable<BpjsINACBGClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsINACBGClaimEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsINACBGClaimEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'update')")
	public BpjsINACBGClaimEntity update(BpjsINACBGClaimEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsINACBGClaimEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'update')")
	public BpjsINACBGClaimEntity update(BpjsINACBGClaimEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsINACBGClaimEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsINACBGClaimEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'update')")
	public List<BpjsINACBGClaimEntity> updateAll(Iterable<BpjsINACBGClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsINACBGClaimEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsINACBGClaimEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'create') or hasPermission('BpjsINACBGClaimEntity', 'update')")
	public BpjsINACBGClaimEntity save(BpjsINACBGClaimEntity entity) throws ConstraintViolationException
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

		BpjsINACBGClaimEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'create') or hasPermission('BpjsINACBGClaimEntity', 'update')")
	public List<BpjsINACBGClaimEntity> saveAll(Iterable<BpjsINACBGClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsINACBGClaimEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	public List<BpjsINACBGClaimEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	public List<BpjsINACBGClaimEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsINACBGClaimEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGClaimEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGClaimEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGClaimEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsINACBGClaimEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGClaimEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGClaimEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsINACBGClaimEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsINACBGClaimEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsINACBGClaimEntityAudits
	 */
	private List<BpjsINACBGClaimEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsINACBGClaimEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsINACBGClaim bpjsINACBGClaim to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsINACBGClaimEntity updateAuditData(BpjsINACBGClaimEntity bpjsINACBGClaim)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsINACBGClaim;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsINACBGClaimEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsINACBGClaimEntity entityAtRevision = updateAuditData((BpjsINACBGClaimEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsINACBGClaimEntityAudit(
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

		QBpjsINACBGClaimEntity entity = QBpjsINACBGClaimEntity.bpjsINACBGClaimEntity;

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
			case "claimNo":
				// % protected region % [Add any additional logic before the query parameters of claimNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of claimNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.claimNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of claimNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of claimNo here] end

				break;
			case "patientID":
				// % protected region % [Add any additional logic before the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic before the query parameters of patientID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic after the query parameters of patientID here] end

				break;
			case "invoiceNumber":
				// % protected region % [Add any additional logic before the query parameters of invoiceNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceNumber here] end

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
			case "los":
				// % protected region % [Add any additional logic before the query parameters of los here] off begin
				// % protected region % [Add any additional logic before the query parameters of los here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.los, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of los here] off begin
				// % protected region % [Add any additional logic after the query parameters of los here] end

				break;
			case "dismissal":
				// % protected region % [Add any additional logic before the query parameters of dismissal here] off begin
				// % protected region % [Add any additional logic before the query parameters of dismissal here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissal, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dismissal here] off begin
				// % protected region % [Add any additional logic after the query parameters of dismissal here] end

				break;
			case "responsibleDoctor":
				// % protected region % [Add any additional logic before the query parameters of responsibleDoctor here] off begin
				// % protected region % [Add any additional logic before the query parameters of responsibleDoctor here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.responsibleDoctor, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of responsibleDoctor here] off begin
				// % protected region % [Add any additional logic after the query parameters of responsibleDoctor here] end

				break;
			case "weight":
				// % protected region % [Add any additional logic before the query parameters of weight here] off begin
				// % protected region % [Add any additional logic before the query parameters of weight here] end


				// % protected region % [Add any additional logic after the query parameters of weight here] off begin
				// % protected region % [Add any additional logic after the query parameters of weight here] end

				break;
			case "adl":
				// % protected region % [Add any additional logic before the query parameters of adl here] off begin
				// % protected region % [Add any additional logic before the query parameters of adl here] end


				// % protected region % [Add any additional logic after the query parameters of adl here] off begin
				// % protected region % [Add any additional logic after the query parameters of adl here] end

				break;
			case "claimStatus":
				// % protected region % [Add any additional logic before the query parameters of claimStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of claimStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.claimStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of claimStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of claimStatus here] end

				break;
			case "sepStatus":
				// % protected region % [Add any additional logic before the query parameters of sepStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepStatus here] end

				break;
			case "staffName":
				// % protected region % [Add any additional logic before the query parameters of staffName here] off begin
				// % protected region % [Add any additional logic before the query parameters of staffName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staffName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of staffName here] off begin
				// % protected region % [Add any additional logic after the query parameters of staffName here] end

				break;
			case "dateGrouping":
				// % protected region % [Add any additional logic before the query parameters of dateGrouping here] off begin
				// % protected region % [Add any additional logic before the query parameters of dateGrouping here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dateGrouping, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dateGrouping here] off begin
				// % protected region % [Add any additional logic after the query parameters of dateGrouping here] end

				break;
			case "inacbgTariff":
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff here] off begin
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inacbgTariff, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inacbgTariff here] off begin
				// % protected region % [Add any additional logic after the query parameters of inacbgTariff here] end

				break;
			case "description":
				// % protected region % [Add any additional logic before the query parameters of description here] off begin
				// % protected region % [Add any additional logic before the query parameters of description here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.description, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of description here] off begin
				// % protected region % [Add any additional logic after the query parameters of description here] end

				break;
			case "cbgType":
				// % protected region % [Add any additional logic before the query parameters of cbgType here] off begin
				// % protected region % [Add any additional logic before the query parameters of cbgType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cbgType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of cbgType here] off begin
				// % protected region % [Add any additional logic after the query parameters of cbgType here] end

				break;
			case "tariff":
				// % protected region % [Add any additional logic before the query parameters of tariff here] off begin
				// % protected region % [Add any additional logic before the query parameters of tariff here] end


				// % protected region % [Add any additional logic after the query parameters of tariff here] off begin
				// % protected region % [Add any additional logic after the query parameters of tariff here] end

				break;
			case "subAcute":
				// % protected region % [Add any additional logic before the query parameters of subAcute here] off begin
				// % protected region % [Add any additional logic before the query parameters of subAcute here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.subAcute, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of subAcute here] off begin
				// % protected region % [Add any additional logic after the query parameters of subAcute here] end

				break;
			case "subAcuteCode":
				// % protected region % [Add any additional logic before the query parameters of subAcuteCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of subAcuteCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.subAcuteCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of subAcuteCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of subAcuteCode here] end

				break;
			case "chronic":
				// % protected region % [Add any additional logic before the query parameters of chronic here] off begin
				// % protected region % [Add any additional logic before the query parameters of chronic here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.chronic, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of chronic here] off begin
				// % protected region % [Add any additional logic after the query parameters of chronic here] end

				break;
			case "chronicCode":
				// % protected region % [Add any additional logic before the query parameters of chronicCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of chronicCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.chronicCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of chronicCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of chronicCode here] end

				break;
			case "tariffType":
				// % protected region % [Add any additional logic before the query parameters of tariffType here] off begin
				// % protected region % [Add any additional logic before the query parameters of tariffType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tariffType here] off begin
				// % protected region % [Add any additional logic after the query parameters of tariffType here] end

				break;
			case "visitDate":
				// % protected region % [Add any additional logic before the query parameters of visitDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of visitDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.visitDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of visitDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of visitDate here] end

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
	public BpjsINACBGClaimEntity updateOldData(BpjsINACBGClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsINACBGClaimEntity updateOldData(BpjsINACBGClaimEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsINACBGClaimEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsINACBGClaimEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getUpgradeFlag() == null) {
			entityToUpdate.setUpgradeFlag(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHcuFlag() == null) {
			entityToUpdate.setHcuFlag(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getGrouperFlag() == null) {
			entityToUpdate.setGrouperFlag(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getInacbgClaimCreated() == null) {
			entityToUpdate.setInacbgClaimCreated(false);
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
	public void validateEntity(BpjsINACBGClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsINACBGClaimEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByClaimNoOpt = this.findByClaimNo(entity.getClaimNo());
			if (entityByClaimNoOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<BpjsINACBGClaimEntity>(
						"Claim No",
						entity.getClaimNo(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ClaimNo"
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
	 * Get the sort as given by the sort by for the BpjsINACBGClaimEntity.
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

	public Set<String> validateEntityRelations(BpjsINACBGClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
