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
import kmsweb.repositories.BpjsSearchControlLetterRepository;
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
public class BpjsSearchControlLetterService extends AbstractService<BpjsSearchControlLetterEntity, BpjsSearchControlLetterRepository, BpjsSearchControlLetterEntityAudit> {

	private final String[] referenceNamesInBpjsSearchControlLetterEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsSearchControlLetterService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsSearchControlLetterRepository repository
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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Control Letter No.
	 *
	 * @param controlLetterNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Letter No
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByControlLetterNo(String controlLetterNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlLetterNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlLetterNo here] end
	{
		// % protected region % [Add any additional logic for findByControlLetterNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlLetterNo before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByControlLetterNo(controlLetterNo));

		// % protected region % [Add any additional logic for findByControlLetterNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlLetterNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Control Plan Date.
	 *
	 * @param controlPlanDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Plan Date
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByControlPlanDate(String controlPlanDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlPlanDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlPlanDate here] end
	{
		// % protected region % [Add any additional logic for findByControlPlanDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlPlanDate before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByControlPlanDate(controlPlanDate));

		// % protected region % [Add any additional logic for findByControlPlanDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlPlanDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date.
	 *
	 * @param date the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDate(String date)
	// % protected region % [Add any throwables, implementations, or extensions for findByDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDate here] end
	{
		// % protected region % [Add any additional logic for findByDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDate before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDate(date));

		// % protected region % [Add any additional logic for findByDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Control Type.
	 *
	 * @param controlType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Control Type
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByControlType(String controlType)
	// % protected region % [Add any throwables, implementations, or extensions for findByControlType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByControlType here] end
	{
		// % protected region % [Add any additional logic for findByControlType before the main body here] off begin
		// % protected region % [Add any additional logic for findByControlType before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByControlType(controlType));

		// % protected region % [Add any additional logic for findByControlType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByControlType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic.
	 *
	 * @param polyclinic the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByPolyclinic(String polyclinic)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinic here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByPolyclinic(polyclinic));

		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinic before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor.
	 *
	 * @param doctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDoctor(String doctor)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctor here] end
	{
		// % protected region % [Add any additional logic for findByDoctor before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctor before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDoctor(doctor));

		// % protected region % [Add any additional logic for findByDoctor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP No.
	 *
	 * @param sepNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP No
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findBySepNo(String sepNo)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepNo here] end
	{
		// % protected region % [Add any additional logic for findBySepNo before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepNo before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findBySepNo(sepNo));

		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Card No.
	 *
	 * @param bpjsCardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Card No
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByBpjsCardNo(String bpjsCardNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsCardNo here] end
	{
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByBpjsCardNo(bpjsCardNo));

		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsCardNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic Destination.
	 *
	 * @param polyclinicDestination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic Destination
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByPolyclinicDestination(String polyclinicDestination)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicDestination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicDestination here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinicDestination before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicDestination before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByPolyclinicDestination(polyclinicDestination));

		// % protected region % [Add any additional logic for findByPolyclinicDestination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicDestination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Destination.
	 *
	 * @param doctorDestination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Destination
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDoctorDestination(String doctorDestination)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorDestination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorDestination here] end
	{
		// % protected region % [Add any additional logic for findByDoctorDestination before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorDestination before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDoctorDestination(doctorDestination));

		// % protected region % [Add any additional logic for findByDoctorDestination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorDestination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Polyclinic Source.
	 *
	 * @param polyclinicSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Polyclinic Source
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByPolyclinicSource(String polyclinicSource)
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicSource here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPolyclinicSource here] end
	{
		// % protected region % [Add any additional logic for findByPolyclinicSource before the main body here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicSource before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByPolyclinicSource(polyclinicSource));

		// % protected region % [Add any additional logic for findByPolyclinicSource before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPolyclinicSource before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Source.
	 *
	 * @param doctorSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Source
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDoctorSource(String doctorSource)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSource here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSource here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSource before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSource before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDoctorSource(doctorSource));

		// % protected region % [Add any additional logic for findByDoctorSource before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSource before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SEP Date.
	 *
	 * @param sepDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SEP Date
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findBySepDate(String sepDate)
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySepDate here] end
	{
		// % protected region % [Add any additional logic for findBySepDate before the main body here] off begin
		// % protected region % [Add any additional logic for findBySepDate before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findBySepDate(sepDate));

		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySepDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Type.
	 *
	 * @param treatmentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Type
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByTreatmentType(String treatmentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentType here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentType before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByTreatmentType(treatmentType));

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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Name.
	 *
	 * @param name the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Name
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByName(String name)
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByName here] end
	{
		// % protected region % [Add any additional logic for findByName before the main body here] off begin
		// % protected region % [Add any additional logic for findByName before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByName(name));

		// % protected region % [Add any additional logic for findByName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDateOfBirth(String dateOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDateOfBirth(dateOfBirth));

		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Provider.
	 *
	 * @param provider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByProvider(String provider)
	// % protected region % [Add any throwables, implementations, or extensions for findByProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProvider here] end
	{
		// % protected region % [Add any additional logic for findByProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByProvider before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByProvider(provider));

		// % protected region % [Add any additional logic for findByProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Provider.
	 *
	 * @param referralProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Provider
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByReferralProvider(String referralProvider)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralProvider here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralProvider here] end
	{
		// % protected region % [Add any additional logic for findByReferralProvider before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralProvider before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByReferralProvider(referralProvider));

		// % protected region % [Add any additional logic for findByReferralProvider before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralProvider before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Source.
	 *
	 * @param referralSource the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Source
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByReferralSource(String referralSource)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralSource here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralSource here] end
	{
		// % protected region % [Add any additional logic for findByReferralSource before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralSource before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByReferralSource(referralSource));

		// % protected region % [Add any additional logic for findByReferralSource before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralSource before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral No.
	 *
	 * @param referralNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral No
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByReferralNo(String referralNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNo here] end
	{
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByReferralNo(referralNo));

		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Date.
	 *
	 * @param referralDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Date
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByReferralDate(String referralDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralDate here] end
	{
		// % protected region % [Add any additional logic for findByReferralDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralDate before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByReferralDate(referralDate));

		// % protected region % [Add any additional logic for findByReferralDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findByDiagnose(String diagnose)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] end
	{
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findByDiagnose(diagnose));

		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsSearchControlLetterEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsSearchControlLetterEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsSearchControlLetterEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'create')")
	public BpjsSearchControlLetterEntity create(BpjsSearchControlLetterEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsSearchControlLetterEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'create')")
	public BpjsSearchControlLetterEntity create(BpjsSearchControlLetterEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsSearchControlLetterEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsSearchControlLetterEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'create')")
	public List<BpjsSearchControlLetterEntity> createAll(Iterable<BpjsSearchControlLetterEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsSearchControlLetterEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsSearchControlLetterEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'update')")
	public BpjsSearchControlLetterEntity update(BpjsSearchControlLetterEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsSearchControlLetterEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'update')")
	public BpjsSearchControlLetterEntity update(BpjsSearchControlLetterEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsSearchControlLetterEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsSearchControlLetterEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'update')")
	public List<BpjsSearchControlLetterEntity> updateAll(Iterable<BpjsSearchControlLetterEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsSearchControlLetterEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsSearchControlLetterEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'create') or hasPermission('BpjsSearchControlLetterEntity', 'update')")
	public BpjsSearchControlLetterEntity save(BpjsSearchControlLetterEntity entity) throws ConstraintViolationException
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

		BpjsSearchControlLetterEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'create') or hasPermission('BpjsSearchControlLetterEntity', 'update')")
	public List<BpjsSearchControlLetterEntity> saveAll(Iterable<BpjsSearchControlLetterEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsSearchControlLetterEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	public List<BpjsSearchControlLetterEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	public List<BpjsSearchControlLetterEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsSearchControlLetterEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsSearchControlLetterEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSearchControlLetterEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsSearchControlLetterEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsSearchControlLetterEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsSearchControlLetterEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsSearchControlLetterEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsSearchControlLetterEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsSearchControlLetterEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsSearchControlLetterEntityAudits
	 */
	private List<BpjsSearchControlLetterEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsSearchControlLetterEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsSearchControlLetter bpjsSearchControlLetter to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsSearchControlLetterEntity updateAuditData(BpjsSearchControlLetterEntity bpjsSearchControlLetter)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsSearchControlLetter;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsSearchControlLetterEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsSearchControlLetterEntity entityAtRevision = updateAuditData((BpjsSearchControlLetterEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsSearchControlLetterEntityAudit(
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

		QBpjsSearchControlLetterEntity entity = QBpjsSearchControlLetterEntity.bpjsSearchControlLetterEntity;

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
			case "controlLetterNo":
				// % protected region % [Add any additional logic before the query parameters of controlLetterNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlLetterNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlLetterNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlLetterNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlLetterNo here] end

				break;
			case "controlPlanDate":
				// % protected region % [Add any additional logic before the query parameters of controlPlanDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlPlanDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlPlanDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlPlanDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlPlanDate here] end

				break;
			case "date":
				// % protected region % [Add any additional logic before the query parameters of date here] off begin
				// % protected region % [Add any additional logic before the query parameters of date here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.date, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of date here] off begin
				// % protected region % [Add any additional logic after the query parameters of date here] end

				break;
			case "controlType":
				// % protected region % [Add any additional logic before the query parameters of controlType here] off begin
				// % protected region % [Add any additional logic before the query parameters of controlType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.controlType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of controlType here] off begin
				// % protected region % [Add any additional logic after the query parameters of controlType here] end

				break;
			case "polyclinic":
				// % protected region % [Add any additional logic before the query parameters of polyclinic here] off begin
				// % protected region % [Add any additional logic before the query parameters of polyclinic here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.polyclinic, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of polyclinic here] off begin
				// % protected region % [Add any additional logic after the query parameters of polyclinic here] end

				break;
			case "doctor":
				// % protected region % [Add any additional logic before the query parameters of doctor here] off begin
				// % protected region % [Add any additional logic before the query parameters of doctor here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctor, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of doctor here] off begin
				// % protected region % [Add any additional logic after the query parameters of doctor here] end

				break;
			case "sepNo":
				// % protected region % [Add any additional logic before the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepNo here] end

				break;
			case "bpjsCardNo":
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of bpjsCardNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsCardNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of bpjsCardNo here] end

				break;
			case "polyclinicDestination":
				// % protected region % [Add any additional logic before the query parameters of polyclinicDestination here] off begin
				// % protected region % [Add any additional logic before the query parameters of polyclinicDestination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.polyclinicDestination, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of polyclinicDestination here] off begin
				// % protected region % [Add any additional logic after the query parameters of polyclinicDestination here] end

				break;
			case "doctorDestination":
				// % protected region % [Add any additional logic before the query parameters of doctorDestination here] off begin
				// % protected region % [Add any additional logic before the query parameters of doctorDestination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorDestination, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of doctorDestination here] off begin
				// % protected region % [Add any additional logic after the query parameters of doctorDestination here] end

				break;
			case "polyclinicSource":
				// % protected region % [Add any additional logic before the query parameters of polyclinicSource here] off begin
				// % protected region % [Add any additional logic before the query parameters of polyclinicSource here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.polyclinicSource, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of polyclinicSource here] off begin
				// % protected region % [Add any additional logic after the query parameters of polyclinicSource here] end

				break;
			case "doctorSource":
				// % protected region % [Add any additional logic before the query parameters of doctorSource here] off begin
				// % protected region % [Add any additional logic before the query parameters of doctorSource here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorSource, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of doctorSource here] off begin
				// % protected region % [Add any additional logic after the query parameters of doctorSource here] end

				break;
			case "sepDate":
				// % protected region % [Add any additional logic before the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of sepDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sepDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of sepDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of sepDate here] end

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
			case "name":
				// % protected region % [Add any additional logic before the query parameters of name here] off begin
				// % protected region % [Add any additional logic before the query parameters of name here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.name, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of name here] off begin
				// % protected region % [Add any additional logic after the query parameters of name here] end

				break;
			case "gender":
				// % protected region % [Add any additional logic before the query parameters of gender here] off begin
				// % protected region % [Add any additional logic before the query parameters of gender here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.gender, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of gender here] off begin
				// % protected region % [Add any additional logic after the query parameters of gender here] end

				break;
			case "dateOfBirth":
				// % protected region % [Add any additional logic before the query parameters of dateOfBirth here] off begin
				// % protected region % [Add any additional logic before the query parameters of dateOfBirth here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dateOfBirth, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dateOfBirth here] off begin
				// % protected region % [Add any additional logic after the query parameters of dateOfBirth here] end

				break;
			case "provider":
				// % protected region % [Add any additional logic before the query parameters of provider here] off begin
				// % protected region % [Add any additional logic before the query parameters of provider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.provider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of provider here] off begin
				// % protected region % [Add any additional logic after the query parameters of provider here] end

				break;
			case "referralProvider":
				// % protected region % [Add any additional logic before the query parameters of referralProvider here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralProvider here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralProvider, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralProvider here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralProvider here] end

				break;
			case "referralSource":
				// % protected region % [Add any additional logic before the query parameters of referralSource here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralSource here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralSource, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralSource here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralSource here] end

				break;
			case "referralNo":
				// % protected region % [Add any additional logic before the query parameters of referralNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralNo here] end

				break;
			case "referralDate":
				// % protected region % [Add any additional logic before the query parameters of referralDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of referralDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referralDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referralDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of referralDate here] end

				break;
			case "diagnose":
				// % protected region % [Add any additional logic before the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of diagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnose, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of diagnose here] end

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
	public BpjsSearchControlLetterEntity updateOldData(BpjsSearchControlLetterEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsSearchControlLetterEntity updateOldData(BpjsSearchControlLetterEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsSearchControlLetterEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsSearchControlLetterEntity);

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
	public void validateEntity(BpjsSearchControlLetterEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsSearchControlLetterEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsSearchControlLetterEntity.
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

	public Set<String> validateEntityRelations(BpjsSearchControlLetterEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}