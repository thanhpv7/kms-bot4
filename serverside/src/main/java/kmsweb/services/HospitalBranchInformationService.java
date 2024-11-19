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
import kmsweb.repositories.HospitalBranchInformationRepository;
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
import kmsweb.entities.HospitalGroupInformationEntity;
import kmsweb.repositories.HospitalGroupInformationRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.services.AbstractFileService;
// % protected region % [Override your file service import here] off begin
import kmsweb.lib.file.services.S3FileService;
// % protected region % [Override your file service import here] end

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class HospitalBranchInformationService extends AbstractService<HospitalBranchInformationEntity, HospitalBranchInformationRepository, HospitalBranchInformationEntityAudit> {

	private final String[] referenceNamesInHospitalBranchInformationEntity = {
		"hospitalGroup",
		"staff",
	};

	private AbstractFileService<FileEntity> fileService;

	private final HospitalGroupInformationRepository hospitalGroupInformationRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public HospitalBranchInformationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		S3FileService s3FileService,
		// % protected region % [Add any additional constructor parameters here] end
		HospitalGroupInformationRepository hospitalGroupInformationRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		HospitalBranchInformationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.hospitalGroupInformationRepository = hospitalGroupInformationRepository;

		this.staffRepository = staffRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		this.fileService = s3FileService;
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Hospital Code.
	 *
	 * @param hospitalCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Code
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HospitalBranchInformationEntity> findByHospitalCode(String hospitalCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalCode here] end
	{
		// % protected region % [Add any additional logic for findByHospitalCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalCode before the main body here] end

		Optional<HospitalBranchInformationEntity> entity = repository.findByHospitalCode(hospitalCode);

		// % protected region % [Add any additional logic for findByHospitalCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByHospitalCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Name.
	 *
	 * @param hospitalName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Name
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalName(String hospitalName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalName here] end
	{
		// % protected region % [Add any additional logic for findByHospitalName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalName before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalName(hospitalName));

		// % protected region % [Add any additional logic for findByHospitalName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Type.
	 *
	 * @param hospitalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Type
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalType(String hospitalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalType here] end
	{
		// % protected region % [Add any additional logic for findByHospitalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalType before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalType(hospitalType));

		// % protected region % [Add any additional logic for findByHospitalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalClass(String hospitalClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] end
	{
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalClass(hospitalClass));

		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Director Name.
	 *
	 * @param hospitalDirectorName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Director Name
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalDirectorName(String hospitalDirectorName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalDirectorName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalDirectorName here] end
	{
		// % protected region % [Add any additional logic for findByHospitalDirectorName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalDirectorName before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalDirectorName(hospitalDirectorName));

		// % protected region % [Add any additional logic for findByHospitalDirectorName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalDirectorName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date of Registration.
	 *
	 * @param dateOfRegistration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Registration
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDateOfRegistration(OffsetDateTime dateOfRegistration)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfRegistration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfRegistration here] end
	{
		// % protected region % [Add any additional logic for findByDateOfRegistration before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfRegistration before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDateOfRegistration(dateOfRegistration));

		// % protected region % [Add any additional logic for findByDateOfRegistration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfRegistration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Corporation Name.
	 *
	 * @param hospitalCorporationName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Corporation Name
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalCorporationName(String hospitalCorporationName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalCorporationName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalCorporationName here] end
	{
		// % protected region % [Add any additional logic for findByHospitalCorporationName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalCorporationName before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalCorporationName(hospitalCorporationName));

		// % protected region % [Add any additional logic for findByHospitalCorporationName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalCorporationName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is BPJS Facility.
	 *
	 * @param isBPJSFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is BPJS Facility
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIsBPJSFacility(Boolean isBPJSFacility)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsBPJSFacility here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsBPJSFacility here] end
	{
		// % protected region % [Add any additional logic for findByIsBPJSFacility before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsBPJSFacility before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIsBPJSFacility(isBPJSFacility));

		// % protected region % [Add any additional logic for findByIsBPJSFacility before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsBPJSFacility before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByCity(String city)
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] end
	{
		// % protected region % [Add any additional logic for findByCity before the main body here] off begin
		// % protected region % [Add any additional logic for findByCity before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByCity(city));

		// % protected region % [Add any additional logic for findByCity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postcode.
	 *
	 * @param postcode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postcode
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPostcode(String postcode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostcode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostcode here] end
	{
		// % protected region % [Add any additional logic for findByPostcode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostcode before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPostcode(postcode));

		// % protected region % [Add any additional logic for findByPostcode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostcode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fax.
	 *
	 * @param fax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fax
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByFax(String fax)
	// % protected region % [Add any throwables, implementations, or extensions for findByFax here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFax here] end
	{
		// % protected region % [Add any additional logic for findByFax before the main body here] off begin
		// % protected region % [Add any additional logic for findByFax before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByFax(fax));

		// % protected region % [Add any additional logic for findByFax before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFax before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Website
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByWebsite(String website)
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] end
	{
		// % protected region % [Add any additional logic for findByWebsite before the main body here] off begin
		// % protected region % [Add any additional logic for findByWebsite before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByWebsite(website));

		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person.
	 *
	 * @param contactPerson the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByContactPerson(String contactPerson)
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPerson here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPerson here] end
	{
		// % protected region % [Add any additional logic for findByContactPerson before the main body here] off begin
		// % protected region % [Add any additional logic for findByContactPerson before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByContactPerson(contactPerson));

		// % protected region % [Add any additional logic for findByContactPerson before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContactPerson before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Phone Number.
	 *
	 * @param contactPersonPhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Phone Number
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByContactPersonPhoneNumber(String contactPersonPhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPersonPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPersonPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByContactPersonPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByContactPersonPhoneNumber before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByContactPersonPhoneNumber(contactPersonPhoneNumber));

		// % protected region % [Add any additional logic for findByContactPersonPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContactPersonPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Email.
	 *
	 * @param contactPersonEmail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Email
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByContactPersonEmail(String contactPersonEmail)
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPersonEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByContactPersonEmail here] end
	{
		// % protected region % [Add any additional logic for findByContactPersonEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByContactPersonEmail before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByContactPersonEmail(contactPersonEmail));

		// % protected region % [Add any additional logic for findByContactPersonEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByContactPersonEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Land Size.
	 *
	 * @param landSize the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Land Size
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByLandSize(String landSize)
	// % protected region % [Add any throwables, implementations, or extensions for findByLandSize here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLandSize here] end
	{
		// % protected region % [Add any additional logic for findByLandSize before the main body here] off begin
		// % protected region % [Add any additional logic for findByLandSize before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByLandSize(landSize));

		// % protected region % [Add any additional logic for findByLandSize before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLandSize before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Building Size.
	 *
	 * @param buildingSize the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Building Size
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByBuildingSize(String buildingSize)
	// % protected region % [Add any throwables, implementations, or extensions for findByBuildingSize here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBuildingSize here] end
	{
		// % protected region % [Add any additional logic for findByBuildingSize before the main body here] off begin
		// % protected region % [Add any additional logic for findByBuildingSize before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByBuildingSize(buildingSize));

		// % protected region % [Add any additional logic for findByBuildingSize before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBuildingSize before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Permit Number.
	 *
	 * @param permitNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Number
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPermitNumber(String permitNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitNumber here] end
	{
		// % protected region % [Add any additional logic for findByPermitNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPermitNumber before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPermitNumber(permitNumber));

		// % protected region % [Add any additional logic for findByPermitNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPermitNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Permit Date.
	 *
	 * @param permitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Date
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPermitDate(OffsetDateTime permitDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitDate here] end
	{
		// % protected region % [Add any additional logic for findByPermitDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByPermitDate before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPermitDate(permitDate));

		// % protected region % [Add any additional logic for findByPermitDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPermitDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Authorized By.
	 *
	 * @param authorizedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Authorized By
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByAuthorizedBy(String authorizedBy)
	// % protected region % [Add any throwables, implementations, or extensions for findByAuthorizedBy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAuthorizedBy here] end
	{
		// % protected region % [Add any additional logic for findByAuthorizedBy before the main body here] off begin
		// % protected region % [Add any additional logic for findByAuthorizedBy before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByAuthorizedBy(authorizedBy));

		// % protected region % [Add any additional logic for findByAuthorizedBy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAuthorizedBy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Permit Type.
	 *
	 * @param permitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Type
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPermitType(String permitType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPermitType here] end
	{
		// % protected region % [Add any additional logic for findByPermitType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPermitType before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPermitType(permitType));

		// % protected region % [Add any additional logic for findByPermitType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPermitType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Valid Until.
	 *
	 * @param validUntil the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Valid Until
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByValidUntil(OffsetDateTime validUntil)
	// % protected region % [Add any throwables, implementations, or extensions for findByValidUntil here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByValidUntil here] end
	{
		// % protected region % [Add any additional logic for findByValidUntil before the main body here] off begin
		// % protected region % [Add any additional logic for findByValidUntil before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByValidUntil(validUntil));

		// % protected region % [Add any additional logic for findByValidUntil before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByValidUntil before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Branch Corporation Name.
	 *
	 * @param hospitalBranchCorporationName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Branch Corporation Name
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalBranchCorporationName(String hospitalBranchCorporationName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBranchCorporationName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBranchCorporationName here] end
	{
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationName before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalBranchCorporationName(hospitalBranchCorporationName));

		// % protected region % [Add any additional logic for findByHospitalBranchCorporationName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Branch Corporation Status.
	 *
	 * @param hospitalBranchCorporationStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Branch Corporation Status
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHospitalBranchCorporationStatus(String hospitalBranchCorporationStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBranchCorporationStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalBranchCorporationStatus here] end
	{
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationStatus before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHospitalBranchCorporationStatus(hospitalBranchCorporationStatus));

		// % protected region % [Add any additional logic for findByHospitalBranchCorporationStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalBranchCorporationStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Type.
	 *
	 * @param accreditationType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Type
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByAccreditationType(String accreditationType)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationType here] end
	{
		// % protected region % [Add any additional logic for findByAccreditationType before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccreditationType before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByAccreditationType(accreditationType));

		// % protected region % [Add any additional logic for findByAccreditationType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccreditationType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Level.
	 *
	 * @param accreditationLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Level
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByAccreditationLevel(String accreditationLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationLevel here] end
	{
		// % protected region % [Add any additional logic for findByAccreditationLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccreditationLevel before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByAccreditationLevel(accreditationLevel));

		// % protected region % [Add any additional logic for findByAccreditationLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccreditationLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Date.
	 *
	 * @param accreditationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Date
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByAccreditationDate(OffsetDateTime accreditationDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccreditationDate here] end
	{
		// % protected region % [Add any additional logic for findByAccreditationDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccreditationDate before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByAccreditationDate(accreditationDate));

		// % protected region % [Add any additional logic for findByAccreditationDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccreditationDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bed Perinatology.
	 *
	 * @param bedPerinatology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Perinatology
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByBedPerinatology(String bedPerinatology)
	// % protected region % [Add any throwables, implementations, or extensions for findByBedPerinatology here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBedPerinatology here] end
	{
		// % protected region % [Add any additional logic for findByBedPerinatology before the main body here] off begin
		// % protected region % [Add any additional logic for findByBedPerinatology before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByBedPerinatology(bedPerinatology));

		// % protected region % [Add any additional logic for findByBedPerinatology before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBedPerinatology before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Suite Class.
	 *
	 * @param suiteClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Suite Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findBySuiteClass(String suiteClass)
	// % protected region % [Add any throwables, implementations, or extensions for findBySuiteClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySuiteClass here] end
	{
		// % protected region % [Add any additional logic for findBySuiteClass before the main body here] off begin
		// % protected region % [Add any additional logic for findBySuiteClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findBySuiteClass(suiteClass));

		// % protected region % [Add any additional logic for findBySuiteClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySuiteClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute VVIP Class.
	 *
	 * @param vvipClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VVIP Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByVvipClass(String vvipClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByVvipClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVvipClass here] end
	{
		// % protected region % [Add any additional logic for findByVvipClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByVvipClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByVvipClass(vvipClass));

		// % protected region % [Add any additional logic for findByVvipClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVvipClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute VIP A Class.
	 *
	 * @param vipAClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP A Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByVipAClass(String vipAClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByVipAClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVipAClass here] end
	{
		// % protected region % [Add any additional logic for findByVipAClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByVipAClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByVipAClass(vipAClass));

		// % protected region % [Add any additional logic for findByVipAClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVipAClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute VIP B Class.
	 *
	 * @param vipBClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP B Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByVipBClass(String vipBClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByVipBClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVipBClass here] end
	{
		// % protected region % [Add any additional logic for findByVipBClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByVipBClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByVipBClass(vipBClass));

		// % protected region % [Add any additional logic for findByVipBClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVipBClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute VIP C Class.
	 *
	 * @param vipCClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP C Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByVipCClass(String vipCClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByVipCClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVipCClass here] end
	{
		// % protected region % [Add any additional logic for findByVipCClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByVipCClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByVipCClass(vipCClass));

		// % protected region % [Add any additional logic for findByVipCClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVipCClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Main Class.
	 *
	 * @param mainClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Main Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByMainClass(String mainClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByMainClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMainClass here] end
	{
		// % protected region % [Add any additional logic for findByMainClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByMainClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByMainClass(mainClass));

		// % protected region % [Add any additional logic for findByMainClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMainClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Class I.
	 *
	 * @param classI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Class I
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByClassI(String classI)
	// % protected region % [Add any throwables, implementations, or extensions for findByClassI here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClassI here] end
	{
		// % protected region % [Add any additional logic for findByClassI before the main body here] off begin
		// % protected region % [Add any additional logic for findByClassI before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByClassI(classI));

		// % protected region % [Add any additional logic for findByClassI before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClassI before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute II Class.
	 *
	 * @param iiClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute II Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIiClass(String iiClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByIiClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIiClass here] end
	{
		// % protected region % [Add any additional logic for findByIiClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByIiClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIiClass(iiClass));

		// % protected region % [Add any additional logic for findByIiClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIiClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute III A Class.
	 *
	 * @param iiiAClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute III A Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIiiAClass(String iiiAClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByIiiAClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIiiAClass here] end
	{
		// % protected region % [Add any additional logic for findByIiiAClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByIiiAClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIiiAClass(iiiAClass));

		// % protected region % [Add any additional logic for findByIiiAClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIiiAClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute III B Class.
	 *
	 * @param iiiBClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute III B Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIiiBClass(String iiiBClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByIiiBClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIiiBClass here] end
	{
		// % protected region % [Add any additional logic for findByIiiBClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByIiiBClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIiiBClass(iiiBClass));

		// % protected region % [Add any additional logic for findByIiiBClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIiiBClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Special Class.
	 *
	 * @param specialClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Special Class
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findBySpecialClass(String specialClass)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialClass here] end
	{
		// % protected region % [Add any additional logic for findBySpecialClass before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecialClass before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findBySpecialClass(specialClass));

		// % protected region % [Add any additional logic for findBySpecialClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecialClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICU.
	 *
	 * @param icu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICU
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIcu(String icu)
	// % protected region % [Add any throwables, implementations, or extensions for findByIcu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIcu here] end
	{
		// % protected region % [Add any additional logic for findByIcu before the main body here] off begin
		// % protected region % [Add any additional logic for findByIcu before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIcu(icu));

		// % protected region % [Add any additional logic for findByIcu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIcu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute PICU.
	 *
	 * @param picu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PICU
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPicu(String picu)
	// % protected region % [Add any throwables, implementations, or extensions for findByPicu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPicu here] end
	{
		// % protected region % [Add any additional logic for findByPicu before the main body here] off begin
		// % protected region % [Add any additional logic for findByPicu before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPicu(picu));

		// % protected region % [Add any additional logic for findByPicu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPicu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute NICU.
	 *
	 * @param nicu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute NICU
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByNicu(String nicu)
	// % protected region % [Add any throwables, implementations, or extensions for findByNicu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNicu here] end
	{
		// % protected region % [Add any additional logic for findByNicu before the main body here] off begin
		// % protected region % [Add any additional logic for findByNicu before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByNicu(nicu));

		// % protected region % [Add any additional logic for findByNicu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNicu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute HCU.
	 *
	 * @param hcu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HCU
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHcu(String hcu)
	// % protected region % [Add any throwables, implementations, or extensions for findByHcu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHcu here] end
	{
		// % protected region % [Add any additional logic for findByHcu before the main body here] off begin
		// % protected region % [Add any additional logic for findByHcu before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHcu(hcu));

		// % protected region % [Add any additional logic for findByHcu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHcu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute ICCU.
	 *
	 * @param iccu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICCU
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIccu(String iccu)
	// % protected region % [Add any throwables, implementations, or extensions for findByIccu here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIccu here] end
	{
		// % protected region % [Add any additional logic for findByIccu before the main body here] off begin
		// % protected region % [Add any additional logic for findByIccu before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIccu(iccu));

		// % protected region % [Add any additional logic for findByIccu before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIccu before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Isolation Room.
	 *
	 * @param isolationRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Isolation Room
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByIsolationRoom(String isolationRoom)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsolationRoom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsolationRoom here] end
	{
		// % protected region % [Add any additional logic for findByIsolationRoom before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsolationRoom before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByIsolationRoom(isolationRoom));

		// % protected region % [Add any additional logic for findByIsolationRoom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsolationRoom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Emergency Room.
	 *
	 * @param emergencyRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Emergency Room
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByEmergencyRoom(String emergencyRoom)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmergencyRoom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmergencyRoom here] end
	{
		// % protected region % [Add any additional logic for findByEmergencyRoom before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmergencyRoom before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByEmergencyRoom(emergencyRoom));

		// % protected region % [Add any additional logic for findByEmergencyRoom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmergencyRoom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Maternity Room.
	 *
	 * @param maternityRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maternity Room
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByMaternityRoom(String maternityRoom)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaternityRoom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaternityRoom here] end
	{
		// % protected region % [Add any additional logic for findByMaternityRoom before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaternityRoom before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByMaternityRoom(maternityRoom));

		// % protected region % [Add any additional logic for findByMaternityRoom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaternityRoom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Operating Room.
	 *
	 * @param operatingRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Operating Room
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByOperatingRoom(String operatingRoom)
	// % protected region % [Add any throwables, implementations, or extensions for findByOperatingRoom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOperatingRoom here] end
	{
		// % protected region % [Add any additional logic for findByOperatingRoom before the main body here] off begin
		// % protected region % [Add any additional logic for findByOperatingRoom before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByOperatingRoom(operatingRoom));

		// % protected region % [Add any additional logic for findByOperatingRoom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOperatingRoom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpA.
	 *
	 * @param doctorSpA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpA
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpA(String doctorSpA)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpA here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpA here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpA before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpA before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpA(doctorSpA));

		// % protected region % [Add any additional logic for findByDoctorSpA before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpA before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpOG.
	 *
	 * @param doctorSpOG the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpOG
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpOG(String doctorSpOG)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpOG here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpOG here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpOG before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpOG before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpOG(doctorSpOG));

		// % protected region % [Add any additional logic for findByDoctorSpOG before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpOG before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpPD.
	 *
	 * @param doctorSpPD the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpPD
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpPD(String doctorSpPD)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpPD here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpPD here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpPD before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpPD before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpPD(doctorSpPD));

		// % protected region % [Add any additional logic for findByDoctorSpPD before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpPD before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpB.
	 *
	 * @param doctorSpB the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpB
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpB(String doctorSpB)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpB here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpB here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpB before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpB before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpB(doctorSpB));

		// % protected region % [Add any additional logic for findByDoctorSpB before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpB before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpRad.
	 *
	 * @param doctorSpRad the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpRad
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpRad(String doctorSpRad)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpRad here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpRad here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpRad before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpRad before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpRad(doctorSpRad));

		// % protected region % [Add any additional logic for findByDoctorSpRad before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpRad before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpRm.
	 *
	 * @param doctorSpRm the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpRm
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpRm(String doctorSpRm)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpRm here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpRm here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpRm before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpRm before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpRm(doctorSpRm));

		// % protected region % [Add any additional logic for findByDoctorSpRm before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpRm before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpAn.
	 *
	 * @param doctorSpAn the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpAn
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpAn(String doctorSpAn)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpAn here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpAn here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpAn before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpAn before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpAn(doctorSpAn));

		// % protected region % [Add any additional logic for findByDoctorSpAn before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpAn before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpJp.
	 *
	 * @param doctorSpJp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpJp
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpJp(String doctorSpJp)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpJp here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpJp here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpJp before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpJp before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpJp(doctorSpJp));

		// % protected region % [Add any additional logic for findByDoctorSpJp before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpJp before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpM.
	 *
	 * @param doctorSpM the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpM
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpM(String doctorSpM)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpM here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpM here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpM before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpM before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpM(doctorSpM));

		// % protected region % [Add any additional logic for findByDoctorSpM before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpM before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpTHT.
	 *
	 * @param doctorSpTHT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpTHT
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpTHT(String doctorSpTHT)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpTHT here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpTHT here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpTHT before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpTHT before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpTHT(doctorSpTHT));

		// % protected region % [Add any additional logic for findByDoctorSpTHT before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpTHT before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpKj.
	 *
	 * @param doctorSpKj the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpKj
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpKj(String doctorSpKj)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpKj here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpKj here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpKj before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpKj before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpKj(doctorSpKj));

		// % protected region % [Add any additional logic for findByDoctorSpKj before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpKj before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpP.
	 *
	 * @param doctorSpP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpP
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpP(String doctorSpP)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpP here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpP here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpP before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpP before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpP(doctorSpP));

		// % protected region % [Add any additional logic for findByDoctorSpP before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpP before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpPK.
	 *
	 * @param doctorSpPK the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpPK
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpPK(String doctorSpPK)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpPK here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpPK here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpPK before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpPK before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpPK(doctorSpPK));

		// % protected region % [Add any additional logic for findByDoctorSpPK before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpPK before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpS.
	 *
	 * @param doctorSpS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpS
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDoctorSpS(String doctorSpS)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpS here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorSpS here] end
	{
		// % protected region % [Add any additional logic for findByDoctorSpS before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpS before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDoctorSpS(doctorSpS));

		// % protected region % [Add any additional logic for findByDoctorSpS before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorSpS before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sub Specialist Doctor.
	 *
	 * @param subSpecialistDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Specialist Doctor
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findBySubSpecialistDoctor(String subSpecialistDoctor)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubSpecialistDoctor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubSpecialistDoctor here] end
	{
		// % protected region % [Add any additional logic for findBySubSpecialistDoctor before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubSpecialistDoctor before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findBySubSpecialistDoctor(subSpecialistDoctor));

		// % protected region % [Add any additional logic for findBySubSpecialistDoctor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubSpecialistDoctor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Specialist Doctor.
	 *
	 * @param otherSpecialistDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Specialist Doctor
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByOtherSpecialistDoctor(String otherSpecialistDoctor)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherSpecialistDoctor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherSpecialistDoctor here] end
	{
		// % protected region % [Add any additional logic for findByOtherSpecialistDoctor before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherSpecialistDoctor before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByOtherSpecialistDoctor(otherSpecialistDoctor));

		// % protected region % [Add any additional logic for findByOtherSpecialistDoctor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherSpecialistDoctor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute General Practice.
	 *
	 * @param generalPractice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute General Practice
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByGeneralPractice(String generalPractice)
	// % protected region % [Add any throwables, implementations, or extensions for findByGeneralPractice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGeneralPractice here] end
	{
		// % protected region % [Add any additional logic for findByGeneralPractice before the main body here] off begin
		// % protected region % [Add any additional logic for findByGeneralPractice before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByGeneralPractice(generalPractice));

		// % protected region % [Add any additional logic for findByGeneralPractice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGeneralPractice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dentist.
	 *
	 * @param dentist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dentist
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByDentist(String dentist)
	// % protected region % [Add any throwables, implementations, or extensions for findByDentist here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDentist here] end
	{
		// % protected region % [Add any additional logic for findByDentist before the main body here] off begin
		// % protected region % [Add any additional logic for findByDentist before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByDentist(dentist));

		// % protected region % [Add any additional logic for findByDentist before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDentist before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Specialist Dentist.
	 *
	 * @param specialistDentist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialist Dentist
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findBySpecialistDentist(String specialistDentist)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialistDentist here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialistDentist here] end
	{
		// % protected region % [Add any additional logic for findBySpecialistDentist before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecialistDentist before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findBySpecialistDentist(specialistDentist));

		// % protected region % [Add any additional logic for findBySpecialistDentist before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecialistDentist before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nurse.
	 *
	 * @param nurse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nurse
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByNurse(String nurse)
	// % protected region % [Add any throwables, implementations, or extensions for findByNurse here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNurse here] end
	{
		// % protected region % [Add any additional logic for findByNurse before the main body here] off begin
		// % protected region % [Add any additional logic for findByNurse before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByNurse(nurse));

		// % protected region % [Add any additional logic for findByNurse before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNurse before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Midwife.
	 *
	 * @param midwife the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Midwife
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByMidwife(String midwife)
	// % protected region % [Add any throwables, implementations, or extensions for findByMidwife here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMidwife here] end
	{
		// % protected region % [Add any additional logic for findByMidwife before the main body here] off begin
		// % protected region % [Add any additional logic for findByMidwife before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByMidwife(midwife));

		// % protected region % [Add any additional logic for findByMidwife before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMidwife before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacist.
	 *
	 * @param pharmacist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacist
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByPharmacist(String pharmacist)
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacist here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPharmacist here] end
	{
		// % protected region % [Add any additional logic for findByPharmacist before the main body here] off begin
		// % protected region % [Add any additional logic for findByPharmacist before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByPharmacist(pharmacist));

		// % protected region % [Add any additional logic for findByPharmacist before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPharmacist before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Medical Staff.
	 *
	 * @param otherMedicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Medical Staff
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByOtherMedicalStaff(String otherMedicalStaff)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherMedicalStaff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherMedicalStaff here] end
	{
		// % protected region % [Add any additional logic for findByOtherMedicalStaff before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherMedicalStaff before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByOtherMedicalStaff(otherMedicalStaff));

		// % protected region % [Add any additional logic for findByOtherMedicalStaff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherMedicalStaff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Non Medical Staff.
	 *
	 * @param nonMedicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Non Medical Staff
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByNonMedicalStaff(String nonMedicalStaff)
	// % protected region % [Add any throwables, implementations, or extensions for findByNonMedicalStaff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNonMedicalStaff here] end
	{
		// % protected region % [Add any additional logic for findByNonMedicalStaff before the main body here] off begin
		// % protected region % [Add any additional logic for findByNonMedicalStaff before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByNonMedicalStaff(nonMedicalStaff));

		// % protected region % [Add any additional logic for findByNonMedicalStaff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNonMedicalStaff before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Timezone.
	 *
	 * @param timezone the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Timezone
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByTimezone(String timezone)
	// % protected region % [Add any throwables, implementations, or extensions for findByTimezone here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTimezone here] end
	{
		// % protected region % [Add any additional logic for findByTimezone before the main body here] off begin
		// % protected region % [Add any additional logic for findByTimezone before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByTimezone(timezone));

		// % protected region % [Add any additional logic for findByTimezone before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTimezone before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Level.
	 *
	 * @param healthFacilityLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Level
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findByHealthFacilityLevel(String healthFacilityLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityLevel here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityLevel before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findByHealthFacilityLevel(healthFacilityLevel));

		// % protected region % [Add any additional logic for findByHealthFacilityLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Satu Sehat Integration.
	 *
	 * @param satuSehatIntegration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Satu Sehat Integration
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findBySatuSehatIntegration(Boolean satuSehatIntegration)
	// % protected region % [Add any throwables, implementations, or extensions for findBySatuSehatIntegration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySatuSehatIntegration here] end
	{
		// % protected region % [Add any additional logic for findBySatuSehatIntegration before the main body here] off begin
		// % protected region % [Add any additional logic for findBySatuSehatIntegration before the main body here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findBySatuSehatIntegration(satuSehatIntegration));

		// % protected region % [Add any additional logic for findBySatuSehatIntegration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySatuSehatIntegration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax Identification.
	 *
	 * @param taxIdentification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Identification
	 */
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HospitalBranchInformationEntity> findByTaxIdentification(String taxIdentification)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxIdentification here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxIdentification here] end
	{
		// % protected region % [Add any additional logic for findByTaxIdentification before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxIdentification before the main body here] end

		Optional<HospitalBranchInformationEntity> entity = repository.findByTaxIdentification(taxIdentification);

		// % protected region % [Add any additional logic for findByTaxIdentification before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByTaxIdentification before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HospitalBranchInformationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<HospitalBranchInformationEntity> entity = repository.findById(id);

		entity.ifPresent(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<HospitalBranchInformationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create')")
	public HospitalBranchInformationEntity create(HospitalBranchInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		HospitalBranchInformationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create')")
	public HospitalBranchInformationEntity create(HospitalBranchInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		HospitalBranchInformationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		HospitalBranchInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create')")
	public List<HospitalBranchInformationEntity> createAll(Iterable<HospitalBranchInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<HospitalBranchInformationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<HospitalBranchInformationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'update')")
	public HospitalBranchInformationEntity update(HospitalBranchInformationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		HospitalBranchInformationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'update')")
	public HospitalBranchInformationEntity update(HospitalBranchInformationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		HospitalBranchInformationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		HospitalBranchInformationEntity newEntity;

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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'update')")
	public List<HospitalBranchInformationEntity> updateAll(Iterable<HospitalBranchInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<HospitalBranchInformationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<HospitalBranchInformationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create') or hasPermission('HospitalBranchInformationEntity', 'update')")
	public HospitalBranchInformationEntity save(HospitalBranchInformationEntity entity) throws ConstraintViolationException
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

		HospitalBranchInformationEntity newEntity = repository.save(entity);

		generateSignedFileUrls(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'create') or hasPermission('HospitalBranchInformationEntity', 'update')")
	public List<HospitalBranchInformationEntity> saveAll(Iterable<HospitalBranchInformationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<HospitalBranchInformationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	public List<HospitalBranchInformationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	public List<HospitalBranchInformationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(HospitalBranchInformationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of HospitalBranchInformationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of HospitalBranchInformationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HospitalBranchInformationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of HospitalBranchInformationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of HospitalBranchInformationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(HospitalBranchInformationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of HospitalBranchInformationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of HospitalBranchInformationEntityAudits
	 */
	private List<HospitalBranchInformationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<HospitalBranchInformationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param hospitalBranchInformation hospitalBranchInformation to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private HospitalBranchInformationEntity updateAuditData(HospitalBranchInformationEntity hospitalBranchInformation)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{

		hospitalBranchInformation.setLeftLogo(new HashSet<>(hospitalBranchInformation.getLeftLogo()));
		hospitalBranchInformation.setRightLogo(new HashSet<>(hospitalBranchInformation.getRightLogo()));

		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return hospitalBranchInformation;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private HospitalBranchInformationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		HospitalBranchInformationEntity entityAtRevision = updateAuditData((HospitalBranchInformationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new HospitalBranchInformationEntityAudit(
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
	 * Generate signed URL for all files so that the user can download them.
	 */
	private void generateSignedFileUrls(HospitalBranchInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] end
	{
		Set<FileEntity> leftLogo = entity.getLeftLogo();

		for (FileEntity individualLeftLogo : leftLogo) {
			String url = fileService.generateUrl(individualLeftLogo.getId());
			individualLeftLogo.setUrl(url);
		}
		Set<FileEntity> rightLogo = entity.getRightLogo();

		for (FileEntity individualRightLogo : rightLogo) {
			String url = fileService.generateUrl(individualRightLogo.getId());
			individualRightLogo.setUrl(url);
		}
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

		QHospitalBranchInformationEntity entity = QHospitalBranchInformationEntity.hospitalBranchInformationEntity;

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
			case "hospitalGroupId":
				// % protected region % [Add any additional logic before the query parameters of relation from Hospital Group to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Hospital Group to Hospital Branch Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalGroup.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Hospital Group to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Hospital Group to Hospital Branch Informations here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Hospital Branch Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Hospital Branch Informations here] end

				break;
			case "hospitalCode":
				// % protected region % [Add any additional logic before the query parameters of hospitalCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of hospitalCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hospitalCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of hospitalCode here] end

				break;
			case "hospitalName":
				// % protected region % [Add any additional logic before the query parameters of hospitalName here] off begin
				// % protected region % [Add any additional logic before the query parameters of hospitalName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hospitalName here] off begin
				// % protected region % [Add any additional logic after the query parameters of hospitalName here] end

				break;
			case "hospitalType":
				// % protected region % [Add any additional logic before the query parameters of hospitalType here] off begin
				// % protected region % [Add any additional logic before the query parameters of hospitalType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hospitalType here] off begin
				// % protected region % [Add any additional logic after the query parameters of hospitalType here] end

				break;
			case "isBPJSFacility":
				// % protected region % [Add any additional logic before the query parameters of isBPJSFacility here] off begin
				// % protected region % [Add any additional logic before the query parameters of isBPJSFacility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isBPJSFacility, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isBPJSFacility here] off begin
				// % protected region % [Add any additional logic after the query parameters of isBPJSFacility here] end

				break;
			case "taxIdentification":
				// % protected region % [Add any additional logic before the query parameters of taxIdentification here] off begin
				// % protected region % [Add any additional logic before the query parameters of taxIdentification here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.taxIdentification, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of taxIdentification here] off begin
				// % protected region % [Add any additional logic after the query parameters of taxIdentification here] end

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
	public HospitalBranchInformationEntity updateOldData(HospitalBranchInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public HospitalBranchInformationEntity updateOldData(HospitalBranchInformationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		HospitalBranchInformationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInHospitalBranchInformationEntity);


			// % protected region % [Add any additional logic for update before uploading files here] off begin
			// % protected region % [Add any additional logic for update before uploading files here] end

			Set<FileEntity> leftLogoFiles = entity.getLeftLogo();

			// Delete any file that requires deletion.
			Set<FileEntity> leftLogofilesToDelete = leftLogoFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsLeftLogo) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			leftLogofilesToDelete.stream()
					.peek(entity::removeLeftLogo) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> leftLogoFilesToUpload = leftLogoFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(leftLogoFilesToUpload).forEach(entity::addLeftLogo);

			Set<FileEntity> rightLogoFiles = entity.getRightLogo();

			// Delete any file that requires deletion.
			Set<FileEntity> rightLogofilesToDelete = rightLogoFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsRightLogo) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			rightLogofilesToDelete.stream()
					.peek(entity::removeRightLogo) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> rightLogoFilesToUpload = rightLogoFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(rightLogoFilesToUpload).forEach(entity::addRightLogo);
		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			Set<FileEntity> leftLogoFiles = entityToUpdate.getLeftLogo();
			// Merge the rest of the files together
			Set<FileEntity> leftLogoFilesToUpload = leftLogoFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllLeftLogo();
			fileService.uploadMultiple(leftLogoFilesToUpload).forEach(entity::addLeftLogo);

			Set<FileEntity> rightLogoFiles = entityToUpdate.getRightLogo();
			// Merge the rest of the files together
			Set<FileEntity> rightLogoFilesToUpload = rightLogoFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllRightLogo();
			fileService.uploadMultiple(rightLogoFilesToUpload).forEach(entity::addRightLogo);

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsBPJSFacility() == null) {
			entityToUpdate.setIsBPJSFacility(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSatuSehatIntegration() == null) {
			entityToUpdate.setSatuSehatIntegration(false);
		}

		// Incoming One to Many reference
		if (entity.getHospitalGroup() == null && entity.getHospitalGroupId() == null) {
			entityToUpdate.unsetHospitalGroup();
		} else if (entity.getHospitalGroupId() != null && entity.getHospitalGroup() == null) {
			Optional<HospitalGroupInformationEntity> hospitalGroupEntity = this.hospitalGroupInformationRepository.findById(entity.getHospitalGroupId());
			entityToUpdate.setHospitalGroup(hospitalGroupEntity.orElseThrow());
		}
		if (persistRelations && entity.getHospitalGroup() != null) {
			entityToUpdate.setHospitalGroup(entity.getHospitalGroup(), false);
			if (entityToUpdate.getHospitalGroupId() != null) {
				this.hospitalGroupInformationRepository.save(entityToUpdate.getHospitalGroup());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getHospitalGroup().unsetHospitalBranchInformations();
			}
		}

		// Incoming One to Many reference
		if (entity.getStaff() == null && entity.getStaffId() == null) {
			entityToUpdate.unsetStaff();
		} else if (entity.getStaffId() != null && entity.getStaff() == null) {
			Optional<StaffEntity> staffEntity = this.staffRepository.findById(entity.getStaffId());
			entityToUpdate.setStaff(staffEntity.orElseThrow());
		}
		if (persistRelations && entity.getStaff() != null) {
			entityToUpdate.setStaff(entity.getStaff(), false);
			if (entityToUpdate.getStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStaff().unsetHospitalBranchInformations();
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
	public void validateEntity(HospitalBranchInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<HospitalBranchInformationEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByHospitalCodeOpt = this.findByHospitalCode(entity.getHospitalCode());
			if (entityByHospitalCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
						"Hospital Code",
						entity.getHospitalCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"HospitalCode"
				);
				errors.add(uniquenessViolation);
			}
			var entityByTaxIdentificationOpt = this.findByTaxIdentification(entity.getTaxIdentification());
			if (entityByTaxIdentificationOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<HospitalBranchInformationEntity>(
						"Tax Identification",
						entity.getTaxIdentification(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"TaxIdentification"
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
	 * Get the sort as given by the sort by for the HospitalBranchInformationEntity.
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

	public Set<String> validateEntityRelations(HospitalBranchInformationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getHospitalGroupId() != null && this.hospitalGroupInformationRepository.findById(entity.getHospitalGroupId()).isEmpty()) {
			errors.add("The UUID " + entity.getHospitalGroupId() + " is not associated with a Hospital Group Information Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
