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
import kmsweb.repositories.PatientEmploymentDetailRepository;
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
public class PatientEmploymentDetailService extends AbstractService<PatientEmploymentDetailEntity, PatientEmploymentDetailRepository, PatientEmploymentDetailEntityAudit> {

	private final String[] referenceNamesInPatientEmploymentDetailEntity = {
		"patientGeneralInfo",
	};

	private final PatientGeneralInfoRepository patientGeneralInfoRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientEmploymentDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PatientGeneralInfoRepository patientGeneralInfoRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PatientEmploymentDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Employee ID.
	 *
	 * @param employeeID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee ID
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByEmployeeID(String employeeID)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeID here] end
	{
		// % protected region % [Add any additional logic for findByEmployeeID before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmployeeID before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByEmployeeID(employeeID));

		// % protected region % [Add any additional logic for findByEmployeeID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmployeeID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Universal ID.
	 *
	 * @param universalID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Universal ID
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByUniversalID(String universalID)
	// % protected region % [Add any throwables, implementations, or extensions for findByUniversalID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUniversalID here] end
	{
		// % protected region % [Add any additional logic for findByUniversalID before the main body here] off begin
		// % protected region % [Add any additional logic for findByUniversalID before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByUniversalID(universalID));

		// % protected region % [Add any additional logic for findByUniversalID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUniversalID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Employee Type.
	 *
	 * @param employeeType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee Type
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByEmployeeType(String employeeType)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeType here] end
	{
		// % protected region % [Add any additional logic for findByEmployeeType before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmployeeType before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByEmployeeType(employeeType));

		// % protected region % [Add any additional logic for findByEmployeeType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmployeeType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Onsite Status.
	 *
	 * @param onsiteStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Onsite Status
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByOnsiteStatus(String onsiteStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByOnsiteStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOnsiteStatus here] end
	{
		// % protected region % [Add any additional logic for findByOnsiteStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByOnsiteStatus before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByOnsiteStatus(onsiteStatus));

		// % protected region % [Add any additional logic for findByOnsiteStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOnsiteStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Occupational Type.
	 *
	 * @param occupationalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Occupational Type
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByOccupationalType(String occupationalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByOccupationalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOccupationalType here] end
	{
		// % protected region % [Add any additional logic for findByOccupationalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByOccupationalType before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByOccupationalType(occupationalType));

		// % protected region % [Add any additional logic for findByOccupationalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOccupationalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dependant ID.
	 *
	 * @param dependantID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant ID
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByDependantID(String dependantID)
	// % protected region % [Add any throwables, implementations, or extensions for findByDependantID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDependantID here] end
	{
		// % protected region % [Add any additional logic for findByDependantID before the main body here] off begin
		// % protected region % [Add any additional logic for findByDependantID before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByDependantID(dependantID));

		// % protected region % [Add any additional logic for findByDependantID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDependantID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dependant Type.
	 *
	 * @param dependantType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependant Type
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByDependantType(String dependantType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDependantType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDependantType here] end
	{
		// % protected region % [Add any additional logic for findByDependantType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDependantType before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByDependantType(dependantType));

		// % protected region % [Add any additional logic for findByDependantType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDependantType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sponsor.
	 *
	 * @param sponsor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sponsor
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findBySponsor(String sponsor)
	// % protected region % [Add any throwables, implementations, or extensions for findBySponsor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySponsor here] end
	{
		// % protected region % [Add any additional logic for findBySponsor before the main body here] off begin
		// % protected region % [Add any additional logic for findBySponsor before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findBySponsor(sponsor));

		// % protected region % [Add any additional logic for findBySponsor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySponsor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Relationship.
	 *
	 * @param relationship the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Relationship
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByRelationship(String relationship)
	// % protected region % [Add any throwables, implementations, or extensions for findByRelationship here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRelationship here] end
	{
		// % protected region % [Add any additional logic for findByRelationship before the main body here] off begin
		// % protected region % [Add any additional logic for findByRelationship before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByRelationship(relationship));

		// % protected region % [Add any additional logic for findByRelationship before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRelationship before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Company.
	 *
	 * @param company the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Company
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByCompany(String company)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompany here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompany here] end
	{
		// % protected region % [Add any additional logic for findByCompany before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompany before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByCompany(company));

		// % protected region % [Add any additional logic for findByCompany before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompany before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Medical Staff Code.
	 *
	 * @param medicalStaffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Staff Code
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByMedicalStaffCode(String medicalStaffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMedicalStaffCode here] end
	{
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByMedicalStaffCode(medicalStaffCode));

		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMedicalStaffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Department.
	 *
	 * @param department the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Department
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByDepartment(String department)
	// % protected region % [Add any throwables, implementations, or extensions for findByDepartment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDepartment here] end
	{
		// % protected region % [Add any additional logic for findByDepartment before the main body here] off begin
		// % protected region % [Add any additional logic for findByDepartment before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByDepartment(department));

		// % protected region % [Add any additional logic for findByDepartment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDepartment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Position.
	 *
	 * @param position the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Position
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByPosition(String position)
	// % protected region % [Add any throwables, implementations, or extensions for findByPosition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPosition here] end
	{
		// % protected region % [Add any additional logic for findByPosition before the main body here] off begin
		// % protected region % [Add any additional logic for findByPosition before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByPosition(position));

		// % protected region % [Add any additional logic for findByPosition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPosition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cost Center.
	 *
	 * @param costCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cost Center
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByCostCenter(String costCenter)
	// % protected region % [Add any throwables, implementations, or extensions for findByCostCenter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCostCenter here] end
	{
		// % protected region % [Add any additional logic for findByCostCenter before the main body here] off begin
		// % protected region % [Add any additional logic for findByCostCenter before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByCostCenter(costCenter));

		// % protected region % [Add any additional logic for findByCostCenter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCostCenter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute District.
	 *
	 * @param district the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute District
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByDistrict(String district)
	// % protected region % [Add any throwables, implementations, or extensions for findByDistrict here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDistrict here] end
	{
		// % protected region % [Add any additional logic for findByDistrict before the main body here] off begin
		// % protected region % [Add any additional logic for findByDistrict before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByDistrict(district));

		// % protected region % [Add any additional logic for findByDistrict before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDistrict before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Designated Work Place.
	 *
	 * @param designatedWorkPlace the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Designated Work Place
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByDesignatedWorkPlace(String designatedWorkPlace)
	// % protected region % [Add any throwables, implementations, or extensions for findByDesignatedWorkPlace here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDesignatedWorkPlace here] end
	{
		// % protected region % [Add any additional logic for findByDesignatedWorkPlace before the main body here] off begin
		// % protected region % [Add any additional logic for findByDesignatedWorkPlace before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByDesignatedWorkPlace(designatedWorkPlace));

		// % protected region % [Add any additional logic for findByDesignatedWorkPlace before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDesignatedWorkPlace before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bureau No.
	 *
	 * @param bureauNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bureau No
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByBureauNo(String bureauNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBureauNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBureauNo here] end
	{
		// % protected region % [Add any additional logic for findByBureauNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBureauNo before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByBureauNo(bureauNo));

		// % protected region % [Add any additional logic for findByBureauNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBureauNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Industry No.
	 *
	 * @param industryNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Industry No
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByIndustryNo(String industryNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByIndustryNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIndustryNo here] end
	{
		// % protected region % [Add any additional logic for findByIndustryNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByIndustryNo before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByIndustryNo(industryNo));

		// % protected region % [Add any additional logic for findByIndustryNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIndustryNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Employment Start Date.
	 *
	 * @param employmentStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employment Start Date
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByEmploymentStartDate(OffsetDateTime employmentStartDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmploymentStartDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmploymentStartDate here] end
	{
		// % protected region % [Add any additional logic for findByEmploymentStartDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmploymentStartDate before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByEmploymentStartDate(employmentStartDate));

		// % protected region % [Add any additional logic for findByEmploymentStartDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmploymentStartDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Passport No.
	 *
	 * @param passportNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Passport No
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByPassportNo(String passportNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByPassportNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPassportNo here] end
	{
		// % protected region % [Add any additional logic for findByPassportNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByPassportNo before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByPassportNo(passportNo));

		// % protected region % [Add any additional logic for findByPassportNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPassportNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Passport Country.
	 *
	 * @param passportCountry the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Passport Country
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByPassportCountry(String passportCountry)
	// % protected region % [Add any throwables, implementations, or extensions for findByPassportCountry here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPassportCountry here] end
	{
		// % protected region % [Add any additional logic for findByPassportCountry before the main body here] off begin
		// % protected region % [Add any additional logic for findByPassportCountry before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByPassportCountry(passportCountry));

		// % protected region % [Add any additional logic for findByPassportCountry before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPassportCountry before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postal Address.
	 *
	 * @param postalAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postal Address
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByPostalAddress(String postalAddress)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostalAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostalAddress here] end
	{
		// % protected region % [Add any additional logic for findByPostalAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostalAddress before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByPostalAddress(postalAddress));

		// % protected region % [Add any additional logic for findByPostalAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostalAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Forwarding Address.
	 *
	 * @param forwardingAddress the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Forwarding Address
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByForwardingAddress(String forwardingAddress)
	// % protected region % [Add any throwables, implementations, or extensions for findByForwardingAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByForwardingAddress here] end
	{
		// % protected region % [Add any additional logic for findByForwardingAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByForwardingAddress before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByForwardingAddress(forwardingAddress));

		// % protected region % [Add any additional logic for findByForwardingAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByForwardingAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Legal DIsability.
	 *
	 * @param legalDIsability the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Legal DIsability
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByLegalDIsability(String legalDIsability)
	// % protected region % [Add any throwables, implementations, or extensions for findByLegalDIsability here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLegalDIsability here] end
	{
		// % protected region % [Add any additional logic for findByLegalDIsability before the main body here] off begin
		// % protected region % [Add any additional logic for findByLegalDIsability before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByLegalDIsability(legalDIsability));

		// % protected region % [Add any additional logic for findByLegalDIsability before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLegalDIsability before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Legal Disability Notes.
	 *
	 * @param legalDisabilityNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Legal Disability Notes
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByLegalDisabilityNotes(String legalDisabilityNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByLegalDisabilityNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLegalDisabilityNotes here] end
	{
		// % protected region % [Add any additional logic for findByLegalDisabilityNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByLegalDisabilityNotes before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByLegalDisabilityNotes(legalDisabilityNotes));

		// % protected region % [Add any additional logic for findByLegalDisabilityNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLegalDisabilityNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Worker Insurance.
	 *
	 * @param workerInsurance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Worker Insurance
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByWorkerInsurance(String workerInsurance)
	// % protected region % [Add any throwables, implementations, or extensions for findByWorkerInsurance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWorkerInsurance here] end
	{
		// % protected region % [Add any additional logic for findByWorkerInsurance before the main body here] off begin
		// % protected region % [Add any additional logic for findByWorkerInsurance before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByWorkerInsurance(workerInsurance));

		// % protected region % [Add any additional logic for findByWorkerInsurance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWorkerInsurance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Worker Insurance No.
	 *
	 * @param workerInsuranceNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Worker Insurance No
	 */
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findByWorkerInsuranceNo(String workerInsuranceNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByWorkerInsuranceNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWorkerInsuranceNo here] end
	{
		// % protected region % [Add any additional logic for findByWorkerInsuranceNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByWorkerInsuranceNo before the main body here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findByWorkerInsuranceNo(workerInsuranceNo));

		// % protected region % [Add any additional logic for findByWorkerInsuranceNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWorkerInsuranceNo before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientEmploymentDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PatientEmploymentDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PatientEmploymentDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'create')")
	public PatientEmploymentDetailEntity create(PatientEmploymentDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PatientEmploymentDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'create')")
	public PatientEmploymentDetailEntity create(PatientEmploymentDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PatientEmploymentDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PatientEmploymentDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'create')")
	public List<PatientEmploymentDetailEntity> createAll(Iterable<PatientEmploymentDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PatientEmploymentDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PatientEmploymentDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'update')")
	public PatientEmploymentDetailEntity update(PatientEmploymentDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PatientEmploymentDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'update')")
	public PatientEmploymentDetailEntity update(PatientEmploymentDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PatientEmploymentDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PatientEmploymentDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'update')")
	public List<PatientEmploymentDetailEntity> updateAll(Iterable<PatientEmploymentDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PatientEmploymentDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PatientEmploymentDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'create') or hasPermission('PatientEmploymentDetailEntity', 'update')")
	public PatientEmploymentDetailEntity save(PatientEmploymentDetailEntity entity) throws ConstraintViolationException
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

		PatientEmploymentDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'create') or hasPermission('PatientEmploymentDetailEntity', 'update')")
	public List<PatientEmploymentDetailEntity> saveAll(Iterable<PatientEmploymentDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PatientEmploymentDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public List<PatientEmploymentDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PatientEmploymentDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PatientEmploymentDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientEmploymentDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientEmploymentDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PatientEmploymentDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientEmploymentDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PatientEmploymentDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PatientEmploymentDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PatientEmploymentDetailEntityAudits
	 */
	private List<PatientEmploymentDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PatientEmploymentDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param patientEmploymentDetail patientEmploymentDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PatientEmploymentDetailEntity updateAuditData(PatientEmploymentDetailEntity patientEmploymentDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return patientEmploymentDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PatientEmploymentDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PatientEmploymentDetailEntity entityAtRevision = updateAuditData((PatientEmploymentDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PatientEmploymentDetailEntityAudit(
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

		QPatientEmploymentDetailEntity entity = QPatientEmploymentDetailEntity.patientEmploymentDetailEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Employment Detail  here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Employment Detail  here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientGeneralInfo.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Employment Detail  here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Employment Detail  here] end

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
	public PatientEmploymentDetailEntity updateOldData(PatientEmploymentDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PatientEmploymentDetailEntity updateOldData(PatientEmploymentDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PatientEmploymentDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPatientEmploymentDetailEntity);

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
				entityToUpdate.getPatientGeneralInfo().unsetPatientEmploymentDetail();
			}
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
	public void validateEntity(PatientEmploymentDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PatientEmploymentDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PatientEmploymentDetailEntity.
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

	public Set<String> validateEntityRelations(PatientEmploymentDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPatientGeneralInfoId() != null && this.patientGeneralInfoRepository.findById(entity.getPatientGeneralInfoId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientGeneralInfoId() + " is not associated with a Patient General Info Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
