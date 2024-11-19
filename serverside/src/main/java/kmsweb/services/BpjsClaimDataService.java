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
import kmsweb.repositories.BpjsClaimDataRepository;
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
public class BpjsClaimDataService extends AbstractService<BpjsClaimDataEntity, BpjsClaimDataRepository, BpjsClaimDataEntityAudit> {

	private final String[] referenceNamesInBpjsClaimDataEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsClaimDataService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsClaimDataRepository repository
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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute INACBG Code.
	 *
	 * @param inacbgCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Code
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByInacbgCode(String inacbgCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgCode here] end
	{
		// % protected region % [Add any additional logic for findByInacbgCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgCode before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByInacbgCode(inacbgCode));

		// % protected region % [Add any additional logic for findByInacbgCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Name.
	 *
	 * @param inacbgName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Name
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByInacbgName(String inacbgName)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgName here] end
	{
		// % protected region % [Add any additional logic for findByInacbgName before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgName before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByInacbgName(inacbgName));

		// % protected region % [Add any additional logic for findByInacbgName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Submitted Tariff.
	 *
	 * @param submittedTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Submitted Tariff
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findBySubmittedTariff(String submittedTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubmittedTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubmittedTariff here] end
	{
		// % protected region % [Add any additional logic for findBySubmittedTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubmittedTariff before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findBySubmittedTariff(submittedTariff));

		// % protected region % [Add any additional logic for findBySubmittedTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubmittedTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval.
	 *
	 * @param approval the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByApproval(String approval)
	// % protected region % [Add any throwables, implementations, or extensions for findByApproval here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApproval here] end
	{
		// % protected region % [Add any additional logic for findByApproval before the main body here] off begin
		// % protected region % [Add any additional logic for findByApproval before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByApproval(approval));

		// % protected region % [Add any additional logic for findByApproval before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApproval before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Grouper Tariff.
	 *
	 * @param grouperTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Grouper Tariff
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByGrouperTariff(String grouperTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByGrouperTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGrouperTariff here] end
	{
		// % protected region % [Add any additional logic for findByGrouperTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByGrouperTariff before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByGrouperTariff(grouperTariff));

		// % protected region % [Add any additional logic for findByGrouperTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGrouperTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Tariff.
	 *
	 * @param hospitalTariff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Tariff
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByHospitalTariff(String hospitalTariff)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalTariff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalTariff here] end
	{
		// % protected region % [Add any additional logic for findByHospitalTariff before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalTariff before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByHospitalTariff(hospitalTariff));

		// % protected region % [Add any additional logic for findByHospitalTariff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalTariff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Top Up.
	 *
	 * @param topUp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Top Up
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByTopUp(String topUp)
	// % protected region % [Add any throwables, implementations, or extensions for findByTopUp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTopUp here] end
	{
		// % protected region % [Add any additional logic for findByTopUp before the main body here] off begin
		// % protected region % [Add any additional logic for findByTopUp before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByTopUp(topUp));

		// % protected region % [Add any additional logic for findByTopUp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTopUp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute FPK No.
	 *
	 * @param fpkNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FPK No
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByFpkNo(String fpkNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByFpkNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFpkNo here] end
	{
		// % protected region % [Add any additional logic for findByFpkNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByFpkNo before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByFpkNo(fpkNo));

		// % protected region % [Add any additional logic for findByFpkNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFpkNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByName(name));

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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByPatientID(String patientID)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] end
	{
		// % protected region % [Add any additional logic for findByPatientID before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientID before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByPatientID(patientID));

		// % protected region % [Add any additional logic for findByPatientID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByPolyclinic(String polyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByPolyclinic(polyclinic));

		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findByDismissalDate(OffsetDateTime dismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findByDismissalDate(dismissalDate));

		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findBySepDate(OffsetDateTime sepDate)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] end
	{
		// % protected region % [Add any additional logic for findBySepDate before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepDate before the main body here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findBySepDate(sepDate));

		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsClaimDataEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsClaimDataEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsClaimDataEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'create')")
	public BpjsClaimDataEntity create(BpjsClaimDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsClaimDataEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'create')")
	public BpjsClaimDataEntity create(BpjsClaimDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsClaimDataEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsClaimDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'create')")
	public List<BpjsClaimDataEntity> createAll(Iterable<BpjsClaimDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsClaimDataEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsClaimDataEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'update')")
	public BpjsClaimDataEntity update(BpjsClaimDataEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsClaimDataEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'update')")
	public BpjsClaimDataEntity update(BpjsClaimDataEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsClaimDataEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsClaimDataEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'update')")
	public List<BpjsClaimDataEntity> updateAll(Iterable<BpjsClaimDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsClaimDataEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsClaimDataEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'create') or hasPermission('BpjsClaimDataEntity', 'update')")
	public BpjsClaimDataEntity save(BpjsClaimDataEntity entity) throws ConstraintViolationException
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

		BpjsClaimDataEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'create') or hasPermission('BpjsClaimDataEntity', 'update')")
	public List<BpjsClaimDataEntity> saveAll(Iterable<BpjsClaimDataEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsClaimDataEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	public List<BpjsClaimDataEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	public List<BpjsClaimDataEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsClaimDataEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsClaimDataEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsClaimDataEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsClaimDataEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsClaimDataEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsClaimDataEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsClaimDataEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsClaimDataEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsClaimDataEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsClaimDataEntityAudits
	 */
	private List<BpjsClaimDataEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsClaimDataEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsClaimData bpjsClaimData to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsClaimDataEntity updateAuditData(BpjsClaimDataEntity bpjsClaimData)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsClaimData;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsClaimDataEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsClaimDataEntity entityAtRevision = updateAuditData((BpjsClaimDataEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsClaimDataEntityAudit(
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

		QBpjsClaimDataEntity entity = QBpjsClaimDataEntity.bpjsClaimDataEntity;

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
			case "inacbgCode":
				// % protected region % [Add any additional logic before the query parameters of inacbgCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of inacbgCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inacbgCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inacbgCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of inacbgCode here] end

				break;
			case "inacbgName":
				// % protected region % [Add any additional logic before the query parameters of inacbgName here] off begin
				// % protected region % [Add any additional logic before the query parameters of inacbgName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inacbgName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inacbgName here] off begin
				// % protected region % [Add any additional logic after the query parameters of inacbgName here] end

				break;
			case "submittedTariff":
				// % protected region % [Add any additional logic before the query parameters of submittedTariff here] off begin
				// % protected region % [Add any additional logic before the query parameters of submittedTariff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.submittedTariff, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of submittedTariff here] off begin
				// % protected region % [Add any additional logic after the query parameters of submittedTariff here] end

				break;
			case "approval":
				// % protected region % [Add any additional logic before the query parameters of approval here] off begin
				// % protected region % [Add any additional logic before the query parameters of approval here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.approval, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of approval here] off begin
				// % protected region % [Add any additional logic after the query parameters of approval here] end

				break;
			case "grouperTariff":
				// % protected region % [Add any additional logic before the query parameters of grouperTariff here] off begin
				// % protected region % [Add any additional logic before the query parameters of grouperTariff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.grouperTariff, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of grouperTariff here] off begin
				// % protected region % [Add any additional logic after the query parameters of grouperTariff here] end

				break;
			case "hospitalTariff":
				// % protected region % [Add any additional logic before the query parameters of hospitalTariff here] off begin
				// % protected region % [Add any additional logic before the query parameters of hospitalTariff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalTariff, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hospitalTariff here] off begin
				// % protected region % [Add any additional logic after the query parameters of hospitalTariff here] end

				break;
			case "topUp":
				// % protected region % [Add any additional logic before the query parameters of topUp here] off begin
				// % protected region % [Add any additional logic before the query parameters of topUp here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.topUp, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of topUp here] off begin
				// % protected region % [Add any additional logic after the query parameters of topUp here] end

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
			case "patientID":
				// % protected region % [Add any additional logic before the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic before the query parameters of patientID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic after the query parameters of patientID here] end

				break;
			case "status":
				// % protected region % [Add any additional logic before the query parameters of status here] off begin
				// % protected region % [Add any additional logic before the query parameters of status here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.status, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of status here] off begin
				// % protected region % [Add any additional logic after the query parameters of status here] end

				break;
			case "dismissalDate":
				// % protected region % [Add any additional logic before the query parameters of dismissalDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of dismissalDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dismissalDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of dismissalDate here] end

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
	public BpjsClaimDataEntity updateOldData(BpjsClaimDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsClaimDataEntity updateOldData(BpjsClaimDataEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsClaimDataEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsClaimDataEntity);

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
	public void validateEntity(BpjsClaimDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsClaimDataEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsClaimDataEntity.
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

	public Set<String> validateEntityRelations(BpjsClaimDataEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
