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
import kmsweb.repositories.BpjsSEPInternalDataRepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class BpjsSEPInternalDataService extends AbstractService<BpjsSEPInternalDataEntity, BpjsSEPInternalDataRepository, BpjsSEPInternalDataEntityAudit> {

	private final String[] referenceNamesInBpjsSEPInternalDataEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsSEPInternalDataService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsSEPInternalDataRepository repository
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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Referred Polyclinic.
	 *
	 * @param referredPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referred Polyclinic
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByReferredPolyclinic(String referredPolyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferredPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferredPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByReferredPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferredPolyclinic before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByReferredPolyclinic(referredPolyclinic));

		// % protected region % [Add any additional logic for findByReferredPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferredPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referring Polyclinic.
	 *
	 * @param referringPolyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Polyclinic
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByReferringPolyclinic(String referringPolyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByReferringPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferringPolyclinic before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByReferringPolyclinic(referringPolyclinic));

		// % protected region % [Add any additional logic for findByReferringPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferringPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Internal Referral Date.
	 *
	 * @param internalReferralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Internal Referral Date
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByInternalReferralDate(String internalReferralDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByInternalReferralDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInternalReferralDate here] end
	{
		// % protected region % [Add any additional logic for findByInternalReferralDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByInternalReferralDate before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByInternalReferralDate(internalReferralDate));

		// % protected region % [Add any additional logic for findByInternalReferralDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInternalReferralDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ref SEP No.
	 *
	 * @param refSEPNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ref SEP No
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByRefSEPNo(String refSEPNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByRefSEPNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRefSEPNo here] end
	{
		// % protected region % [Add any additional logic for findByRefSEPNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByRefSEPNo before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByRefSEPNo(refSEPNo));

		// % protected region % [Add any additional logic for findByRefSEPNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRefSEPNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Health Facility.
	 *
	 * @param sepHealthFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Health Facility
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findBySepHealthFacility(String sepHealthFacility)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepHealthFacility here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepHealthFacility here] end
	{
		// % protected region % [Add any additional logic for findBySepHealthFacility before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepHealthFacility before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findBySepHealthFacility(sepHealthFacility));

		// % protected region % [Add any additional logic for findBySepHealthFacility before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepHealthFacility before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findBySepDate(String sepDate)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] end
	{
		// % protected region % [Add any additional logic for findBySepDate before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepDate before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findBySepDate(sepDate));

		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Letter No.
	 *
	 * @param letterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Letter No
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByLetterNo(String letterNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByLetterNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLetterNo here] end
	{
		// % protected region % [Add any additional logic for findByLetterNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByLetterNo before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByLetterNo(letterNo));

		// % protected region % [Add any additional logic for findByLetterNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLetterNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Internal.
	 *
	 * @param isInternal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Internal
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByIsInternal(String isInternal)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsInternal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsInternal here] end
	{
		// % protected region % [Add any additional logic for findByIsInternal before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsInternal before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByIsInternal(isInternal));

		// % protected region % [Add any additional logic for findByIsInternal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsInternal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referring Polyclinic Code.
	 *
	 * @param referringPolyclinicCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Polyclinic Code
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByReferringPolyclinicCode(String referringPolyclinicCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringPolyclinicCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringPolyclinicCode here] end
	{
		// % protected region % [Add any additional logic for findByReferringPolyclinicCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferringPolyclinicCode before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByReferringPolyclinicCode(referringPolyclinicCode));

		// % protected region % [Add any additional logic for findByReferringPolyclinicCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferringPolyclinicCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnostic Support.
	 *
	 * @param diagnosticSupport the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnostic Support
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByDiagnosticSupport(String diagnosticSupport)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosticSupport here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnosticSupport here] end
	{
		// % protected region % [Add any additional logic for findByDiagnosticSupport before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnosticSupport before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByDiagnosticSupport(diagnosticSupport));

		// % protected region % [Add any additional logic for findByDiagnosticSupport before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnosticSupport before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referring Diagnose.
	 *
	 * @param referringDiagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referring Diagnose
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByReferringDiagnose(String referringDiagnose)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringDiagnose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferringDiagnose here] end
	{
		// % protected region % [Add any additional logic for findByReferringDiagnose before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferringDiagnose before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByReferringDiagnose(referringDiagnose));

		// % protected region % [Add any additional logic for findByReferringDiagnose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferringDiagnose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor.
	 *
	 * @param doctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor
	 */
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findByDoctor(String doctor)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctor here] end
	{
		// % protected region % [Add any additional logic for findByDoctor before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctor before the main body here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findByDoctor(doctor));

		// % protected region % [Add any additional logic for findByDoctor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctor before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsSEPInternalDataEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsSEPInternalDataEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsSEPInternalDataEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'create')")
	public BpjsSEPInternalDataEntity create(BpjsSEPInternalDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsSEPInternalDataEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'create')")
	public BpjsSEPInternalDataEntity create(BpjsSEPInternalDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsSEPInternalDataEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsSEPInternalDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'create')")
	public List<BpjsSEPInternalDataEntity> createAll(Iterable<BpjsSEPInternalDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsSEPInternalDataEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsSEPInternalDataEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'update')")
	public BpjsSEPInternalDataEntity update(BpjsSEPInternalDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsSEPInternalDataEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'update')")
	public BpjsSEPInternalDataEntity update(BpjsSEPInternalDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsSEPInternalDataEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsSEPInternalDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'update')")
	public List<BpjsSEPInternalDataEntity> updateAll(Iterable<BpjsSEPInternalDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsSEPInternalDataEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsSEPInternalDataEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'create') or hasPermission('BpjsSEPInternalDataEntity', 'update')")
	public BpjsSEPInternalDataEntity save(BpjsSEPInternalDataEntity entity) throws ConstraintViolationException
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

		BpjsSEPInternalDataEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'create') or hasPermission('BpjsSEPInternalDataEntity', 'update')")
	public List<BpjsSEPInternalDataEntity> saveAll(Iterable<BpjsSEPInternalDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsSEPInternalDataEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	public List<BpjsSEPInternalDataEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	public List<BpjsSEPInternalDataEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsSEPInternalDataEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsSEPInternalDataEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSEPInternalDataEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSEPInternalDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSEPInternalDataEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsSEPInternalDataEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSEPInternalDataEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsSEPInternalDataEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsSEPInternalDataEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsSEPInternalDataEntityAudits
	 */
	private List<BpjsSEPInternalDataEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsSEPInternalDataEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsSEPInternalData bpjsSEPInternalData to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsSEPInternalDataEntity updateAuditData(BpjsSEPInternalDataEntity bpjsSEPInternalData)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsSEPInternalData;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsSEPInternalDataEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsSEPInternalDataEntity entityAtRevision = updateAuditData((BpjsSEPInternalDataEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsSEPInternalDataEntityAudit(
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

		QBpjsSEPInternalDataEntity entity = QBpjsSEPInternalDataEntity.bpjsSEPInternalDataEntity;

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
			case "referredPolyclinic":
				// % protected region % [Add any additional logic before the query parameters of referredPolyclinic here] off begin
				// % protected region % [Add any additional logic before the query parameters of referredPolyclinic here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referredPolyclinic, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referredPolyclinic here] off begin
				// % protected region % [Add any additional logic after the query parameters of referredPolyclinic here] end

				break;
			case "referringPolyclinic":
				// % protected region % [Add any additional logic before the query parameters of referringPolyclinic here] off begin
				// % protected region % [Add any additional logic before the query parameters of referringPolyclinic here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringPolyclinic, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referringPolyclinic here] off begin
				// % protected region % [Add any additional logic after the query parameters of referringPolyclinic here] end

				break;
			case "internalReferralDate":
				// % protected region % [Add any additional logic before the query parameters of internalReferralDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of internalReferralDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.internalReferralDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of internalReferralDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of internalReferralDate here] end

				break;
			case "sepNo":
				// % protected region % [Add any additional logic before the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepNo here] end

				break;
			case "refSEPNo":
				// % protected region % [Add any additional logic before the query parameters of refSEPNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of refSEPNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.refSEPNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of refSEPNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of refSEPNo here] end

				break;
			case "sepHealthFacility":
				// % protected region % [Add any additional logic before the query parameters of sepHealthFacility here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepHealthFacility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepHealthFacility, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepHealthFacility here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepHealthFacility here] end

				break;
			case "bpjsCardNo":
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsCardNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] end

				break;
			case "sepDate":
				// % protected region % [Add any additional logic before the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepDate here] end

				break;
			case "letterNo":
				// % protected region % [Add any additional logic before the query parameters of letterNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of letterNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.letterNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of letterNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of letterNo here] end

				break;
			case "isInternal":
				// % protected region % [Add any additional logic before the query parameters of isInternal here] off begin
				// % protected region % [Add any additional logic before the query parameters of isInternal here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isInternal, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isInternal here] off begin
				// % protected region % [Add any additional logic after the query parameters of isInternal here] end

				break;
			case "referringPolyclinicCode":
				// % protected region % [Add any additional logic before the query parameters of referringPolyclinicCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of referringPolyclinicCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringPolyclinicCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referringPolyclinicCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of referringPolyclinicCode here] end

				break;
			case "diagnosticSupport":
				// % protected region % [Add any additional logic before the query parameters of diagnosticSupport here] off begin
				// % protected region % [Add any additional logic before the query parameters of diagnosticSupport here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticSupport, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of diagnosticSupport here] off begin
				// % protected region % [Add any additional logic after the query parameters of diagnosticSupport here] end

				break;
			case "referringDiagnose":
				// % protected region % [Add any additional logic before the query parameters of referringDiagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of referringDiagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringDiagnose, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referringDiagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of referringDiagnose here] end

				break;
			case "doctor":
				// % protected region % [Add any additional logic before the query parameters of doctor here] off begin
				// % protected region % [Add any additional logic before the query parameters of doctor here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctor, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of doctor here] off begin
				// % protected region % [Add any additional logic after the query parameters of doctor here] end

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
	public BpjsSEPInternalDataEntity updateOldData(BpjsSEPInternalDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsSEPInternalDataEntity updateOldData(BpjsSEPInternalDataEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsSEPInternalDataEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsSEPInternalDataEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
	public void validateEntity(BpjsSEPInternalDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsSEPInternalDataEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsSEPInternalDataEntity.
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

	public Set<String> validateEntityRelations(BpjsSEPInternalDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
