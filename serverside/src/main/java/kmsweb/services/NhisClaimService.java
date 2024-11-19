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
import kmsweb.repositories.NhisClaimRepository;
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
public class NhisClaimService extends AbstractService<NhisClaimEntity, NhisClaimRepository, NhisClaimEntityAudit> {

	private final String[] referenceNamesInNhisClaimEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public NhisClaimService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		NhisClaimRepository repository
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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute System Claim ID.
	 *
	 * @param systemClaimID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute System Claim ID
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findBySystemClaimID(String systemClaimID)
	// % protected region % [Add any throwables, implementations, or extensions for findBySystemClaimID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySystemClaimID here] end
	{
		// % protected region % [Add any additional logic for findBySystemClaimID before the main body here] off begin
		// % protected region % [Add any additional logic for findBySystemClaimID before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findBySystemClaimID(systemClaimID));

		// % protected region % [Add any additional logic for findBySystemClaimID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySystemClaimID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ref Invoice No.
	 *
	 * @param refInvoiceNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ref Invoice No
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByRefInvoiceNo(String refInvoiceNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByRefInvoiceNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRefInvoiceNo here] end
	{
		// % protected region % [Add any additional logic for findByRefInvoiceNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByRefInvoiceNo before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByRefInvoiceNo(refInvoiceNo));

		// % protected region % [Add any additional logic for findByRefInvoiceNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRefInvoiceNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Form No.
	 *
	 * @param formNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Form No
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByFormNo(String formNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByFormNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFormNo here] end
	{
		// % protected region % [Add any additional logic for findByFormNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByFormNo before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByFormNo(formNo));

		// % protected region % [Add any additional logic for findByFormNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFormNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim ID.
	 *
	 * @param claimID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim ID
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByClaimID(String claimID)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimID here] end
	{
		// % protected region % [Add any additional logic for findByClaimID before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimID before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByClaimID(claimID));

		// % protected region % [Add any additional logic for findByClaimID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim Check Code.
	 *
	 * @param claimCheckCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Check Code
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByClaimCheckCode(String claimCheckCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimCheckCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimCheckCode here] end
	{
		// % protected region % [Add any additional logic for findByClaimCheckCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimCheckCode before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByClaimCheckCode(claimCheckCode));

		// % protected region % [Add any additional logic for findByClaimCheckCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimCheckCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Batch Number.
	 *
	 * @param batchNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Number
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByBatchNumber(String batchNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByBatchNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBatchNumber here] end
	{
		// % protected region % [Add any additional logic for findByBatchNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByBatchNumber before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByBatchNumber(batchNumber));

		// % protected region % [Add any additional logic for findByBatchNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBatchNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Surname.
	 *
	 * @param surname the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surname
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findBySurname(String surname)
	// % protected region % [Add any throwables, implementations, or extensions for findBySurname here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySurname here] end
	{
		// % protected region % [Add any additional logic for findBySurname before the main body here] off begin
		// % protected region % [Add any additional logic for findBySurname before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findBySurname(surname));

		// % protected region % [Add any additional logic for findBySurname before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySurname before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Names.
	 *
	 * @param otherNames the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Names
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByOtherNames(String otherNames)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNames here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNames here] end
	{
		// % protected region % [Add any additional logic for findByOtherNames before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherNames before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByOtherNames(otherNames));

		// % protected region % [Add any additional logic for findByOtherNames before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherNames before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date Of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date Of Birth
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByDateOfBirth(OffsetDateTime dateOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByDateOfBirth(dateOfBirth));

		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Member No.
	 *
	 * @param memberNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Member No
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByMemberNo(String memberNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByMemberNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMemberNo here] end
	{
		// % protected region % [Add any additional logic for findByMemberNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByMemberNo before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByMemberNo(memberNo));

		// % protected region % [Add any additional logic for findByMemberNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMemberNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Record No.
	 *
	 * @param hospitalRecordNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Record No
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByHospitalRecordNo(String hospitalRecordNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalRecordNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalRecordNo here] end
	{
		// % protected region % [Add any additional logic for findByHospitalRecordNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalRecordNo before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByHospitalRecordNo(hospitalRecordNo));

		// % protected region % [Add any additional logic for findByHospitalRecordNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalRecordNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Card Serial Number.
	 *
	 * @param cardSerialNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Serial Number
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByCardSerialNumber(String cardSerialNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByCardSerialNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCardSerialNumber here] end
	{
		// % protected region % [Add any additional logic for findByCardSerialNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByCardSerialNumber before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByCardSerialNumber(cardSerialNumber));

		// % protected region % [Add any additional logic for findByCardSerialNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCardSerialNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dependant.
	 *
	 * @param dependant the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByDependant(Boolean dependant)
	// % protected region % [Add any throwables, implementations, or extensions for findByDependant here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDependant here] end
	{
		// % protected region % [Add any additional logic for findByDependant before the main body here] off begin
		// % protected region % [Add any additional logic for findByDependant before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByDependant(dependant));

		// % protected region % [Add any additional logic for findByDependant before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDependant before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unbundled.
	 *
	 * @param unbundled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unbundled
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByUnbundled(Boolean unbundled)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnbundled here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnbundled here] end
	{
		// % protected region % [Add any additional logic for findByUnbundled before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnbundled before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByUnbundled(unbundled));

		// % protected region % [Add any additional logic for findByUnbundled before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnbundled before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Includes Pharmacy.
	 *
	 * @param includesPharmacy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Includes Pharmacy
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByIncludesPharmacy(Boolean includesPharmacy)
	// % protected region % [Add any throwables, implementations, or extensions for findByIncludesPharmacy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIncludesPharmacy here] end
	{
		// % protected region % [Add any additional logic for findByIncludesPharmacy before the main body here] off begin
		// % protected region % [Add any additional logic for findByIncludesPharmacy before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByIncludesPharmacy(includesPharmacy));

		// % protected region % [Add any additional logic for findByIncludesPharmacy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIncludesPharmacy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Type Of Attendance.
	 *
	 * @param typeOfAttendance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Type Of Attendance
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByTypeOfAttendance(String typeOfAttendance)
	// % protected region % [Add any throwables, implementations, or extensions for findByTypeOfAttendance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTypeOfAttendance here] end
	{
		// % protected region % [Add any additional logic for findByTypeOfAttendance before the main body here] off begin
		// % protected region % [Add any additional logic for findByTypeOfAttendance before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByTypeOfAttendance(typeOfAttendance));

		// % protected region % [Add any additional logic for findByTypeOfAttendance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTypeOfAttendance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute First Visit Admission.
	 *
	 * @param firstVisitAdmission the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Visit Admission
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByFirstVisitAdmission(OffsetDateTime firstVisitAdmission)
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstVisitAdmission here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstVisitAdmission here] end
	{
		// % protected region % [Add any additional logic for findByFirstVisitAdmission before the main body here] off begin
		// % protected region % [Add any additional logic for findByFirstVisitAdmission before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByFirstVisitAdmission(firstVisitAdmission));

		// % protected region % [Add any additional logic for findByFirstVisitAdmission before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFirstVisitAdmission before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Second Visit Discharge.
	 *
	 * @param secondVisitDischarge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Second Visit Discharge
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findBySecondVisitDischarge(OffsetDateTime secondVisitDischarge)
	// % protected region % [Add any throwables, implementations, or extensions for findBySecondVisitDischarge here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySecondVisitDischarge here] end
	{
		// % protected region % [Add any additional logic for findBySecondVisitDischarge before the main body here] off begin
		// % protected region % [Add any additional logic for findBySecondVisitDischarge before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findBySecondVisitDischarge(secondVisitDischarge));

		// % protected region % [Add any additional logic for findBySecondVisitDischarge before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySecondVisitDischarge before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Third Visit.
	 *
	 * @param thirdVisit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Third Visit
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByThirdVisit(OffsetDateTime thirdVisit)
	// % protected region % [Add any throwables, implementations, or extensions for findByThirdVisit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByThirdVisit here] end
	{
		// % protected region % [Add any additional logic for findByThirdVisit before the main body here] off begin
		// % protected region % [Add any additional logic for findByThirdVisit before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByThirdVisit(thirdVisit));

		// % protected region % [Add any additional logic for findByThirdVisit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByThirdVisit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fourth Visit.
	 *
	 * @param fourthVisit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fourth Visit
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByFourthVisit(OffsetDateTime fourthVisit)
	// % protected region % [Add any throwables, implementations, or extensions for findByFourthVisit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFourthVisit here] end
	{
		// % protected region % [Add any additional logic for findByFourthVisit before the main body here] off begin
		// % protected region % [Add any additional logic for findByFourthVisit before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByFourthVisit(fourthVisit));

		// % protected region % [Add any additional logic for findByFourthVisit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFourthVisit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Physician Name.
	 *
	 * @param physicianName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physician Name
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByPhysicianName(String physicianName)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicianName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicianName here] end
	{
		// % protected region % [Add any additional logic for findByPhysicianName before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhysicianName before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByPhysicianName(physicianName));

		// % protected region % [Add any additional logic for findByPhysicianName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhysicianName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Physician Code.
	 *
	 * @param physicianCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Physician Code
	 */
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findByPhysicianCode(String physicianCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicianCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhysicianCode here] end
	{
		// % protected region % [Add any additional logic for findByPhysicianCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhysicianCode before the main body here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findByPhysicianCode(physicianCode));

		// % protected region % [Add any additional logic for findByPhysicianCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhysicianCode before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<NhisClaimEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<NhisClaimEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<NhisClaimEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@Transactional(readOnly = true)
	public List<NhisClaimEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<NhisClaimEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NhisClaimEntity', 'create')")
	public NhisClaimEntity create(NhisClaimEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		NhisClaimEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NhisClaimEntity', 'create')")
	public NhisClaimEntity create(NhisClaimEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		NhisClaimEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		NhisClaimEntity newEntity;

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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'create')")
	public List<NhisClaimEntity> createAll(Iterable<NhisClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<NhisClaimEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<NhisClaimEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('NhisClaimEntity', 'update')")
	public NhisClaimEntity update(NhisClaimEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		NhisClaimEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('NhisClaimEntity', 'update')")
	public NhisClaimEntity update(NhisClaimEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		NhisClaimEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		NhisClaimEntity newEntity;

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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'update')")
	public List<NhisClaimEntity> updateAll(Iterable<NhisClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<NhisClaimEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<NhisClaimEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'create') or hasPermission('NhisClaimEntity', 'update')")
	public NhisClaimEntity save(NhisClaimEntity entity) throws ConstraintViolationException
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

		NhisClaimEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'create') or hasPermission('NhisClaimEntity', 'update')")
	public List<NhisClaimEntity> saveAll(Iterable<NhisClaimEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<NhisClaimEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'delete')")
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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	public List<NhisClaimEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	public List<NhisClaimEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NhisClaimEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(NhisClaimEntity.class);

		// % protected region % [Add any additional processing before converting to a list of NhisClaimEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of NhisClaimEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('NhisClaimEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<NhisClaimEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of NhisClaimEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of NhisClaimEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(NhisClaimEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of NhisClaimEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of NhisClaimEntityAudits
	 */
	private List<NhisClaimEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<NhisClaimEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param nhisClaim nhisClaim to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private NhisClaimEntity updateAuditData(NhisClaimEntity nhisClaim)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return nhisClaim;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private NhisClaimEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		NhisClaimEntity entityAtRevision = updateAuditData((NhisClaimEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new NhisClaimEntityAudit(
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

		QNhisClaimEntity entity = QNhisClaimEntity.nhisClaimEntity;

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
	public NhisClaimEntity updateOldData(NhisClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public NhisClaimEntity updateOldData(NhisClaimEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		NhisClaimEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInNhisClaimEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDependant() == null) {
			entityToUpdate.setDependant(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getUnbundled() == null) {
			entityToUpdate.setUnbundled(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIncludesPharmacy() == null) {
			entityToUpdate.setIncludesPharmacy(false);
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
	public void validateEntity(NhisClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<NhisClaimEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the NhisClaimEntity.
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

	public Set<String> validateEntityRelations(NhisClaimEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
