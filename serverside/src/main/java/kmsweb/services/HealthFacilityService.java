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
import kmsweb.repositories.HealthFacilityRepository;
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
public class HealthFacilityService extends AbstractService<HealthFacilityEntity, HealthFacilityRepository, HealthFacilityEntityAudit> {

	private final String[] referenceNamesInHealthFacilityEntity = {
		"dismissalReferringFacility",
		"referringFacility",
	};

	private final RegistrationRepository registrationRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public HealthFacilityService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		RegistrationRepository registrationRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		HealthFacilityRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Health Facility ID.
	 *
	 * @param healthFacilityID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility ID
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HealthFacilityEntity> findByHealthFacilityID(String healthFacilityID)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityID here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityID before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityID before the main body here] end

		Optional<HealthFacilityEntity> entity = repository.findByHealthFacilityID(healthFacilityID);

		// % protected region % [Add any additional logic for findByHealthFacilityID before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityID before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Name.
	 *
	 * @param healthFacilityName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Name
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByHealthFacilityName(String healthFacilityName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByHealthFacilityName(healthFacilityName));

		// % protected region % [Add any additional logic for findByHealthFacilityName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByAddress(address));

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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByCity(String city)
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCity here] end
	{
		// % protected region % [Add any additional logic for findByCity before the main body here] off begin
		// % protected region % [Add any additional logic for findByCity before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByCity(city));

		// % protected region % [Add any additional logic for findByCity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Post Code.
	 *
	 * @param postCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Code
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByPostCode(String postCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostCode here] end
	{
		// % protected region % [Add any additional logic for findByPostCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostCode before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByPostCode(postCode));

		// % protected region % [Add any additional logic for findByPostCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Province.
	 *
	 * @param province the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Province
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByProvince(String province)
	// % protected region % [Add any throwables, implementations, or extensions for findByProvince here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByProvince here] end
	{
		// % protected region % [Add any additional logic for findByProvince before the main body here] off begin
		// % protected region % [Add any additional logic for findByProvince before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByProvince(province));

		// % protected region % [Add any additional logic for findByProvince before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByProvince before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByCountry(String country)
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] end
	{
		// % protected region % [Add any additional logic for findByCountry before the main body here] off begin
		// % protected region % [Add any additional logic for findByCountry before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByCountry(country));

		// % protected region % [Add any additional logic for findByCountry before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCountry before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByPhoneNumber(String phoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByPhoneNumber(phoneNumber));

		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByMobilePhoneNumber(String mobilePhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByMobilePhoneNumber(mobilePhoneNumber));

		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute website
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByWebsite(String website)
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWebsite here] end
	{
		// % protected region % [Add any additional logic for findByWebsite before the main body here] off begin
		// % protected region % [Add any additional logic for findByWebsite before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByWebsite(website));

		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWebsite before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Salutation.
	 *
	 * @param salutation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Salutation
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findBySalutation(String salutation)
	// % protected region % [Add any throwables, implementations, or extensions for findBySalutation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySalutation here] end
	{
		// % protected region % [Add any additional logic for findBySalutation before the main body here] off begin
		// % protected region % [Add any additional logic for findBySalutation before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findBySalutation(salutation));

		// % protected region % [Add any additional logic for findBySalutation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySalutation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByFirstName(String firstName)
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] end
	{
		// % protected region % [Add any additional logic for findByFirstName before the main body here] off begin
		// % protected region % [Add any additional logic for findByFirstName before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByFirstName(firstName));

		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByLastName(String lastName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] end
	{
		// % protected region % [Add any additional logic for findByLastName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastName before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByLastName(lastName));

		// % protected region % [Add any additional logic for findByLastName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number POC.
	 *
	 * @param phoneNumberPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number POC
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByPhoneNumberPOC(String phoneNumberPOC)
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumberPOC here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPhoneNumberPOC here] end
	{
		// % protected region % [Add any additional logic for findByPhoneNumberPOC before the main body here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumberPOC before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByPhoneNumberPOC(phoneNumberPOC));

		// % protected region % [Add any additional logic for findByPhoneNumberPOC before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPhoneNumberPOC before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number POC.
	 *
	 * @param mobilePhoneNumberPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number POC
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByMobilePhoneNumberPOC(String mobilePhoneNumberPOC)
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumberPOC here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNumberPOC here] end
	{
		// % protected region % [Add any additional logic for findByMobilePhoneNumberPOC before the main body here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumberPOC before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByMobilePhoneNumberPOC(mobilePhoneNumberPOC));

		// % protected region % [Add any additional logic for findByMobilePhoneNumberPOC before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNumberPOC before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Email POC.
	 *
	 * @param emailPOC the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email POC
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByEmailPOC(String emailPOC)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmailPOC here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmailPOC here] end
	{
		// % protected region % [Add any additional logic for findByEmailPOC before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmailPOC before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByEmailPOC(emailPOC));

		// % protected region % [Add any additional logic for findByEmailPOC before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmailPOC before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Type.
	 *
	 * @param healthFacilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Type
	 */
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findByHealthFacilityType(String healthFacilityType)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityType here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityType before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityType before the main body here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findByHealthFacilityType(healthFacilityType));

		// % protected region % [Add any additional logic for findByHealthFacilityType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityType before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HealthFacilityEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<HealthFacilityEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<HealthFacilityEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<HealthFacilityEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'create')")
	public HealthFacilityEntity create(HealthFacilityEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		HealthFacilityEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'create')")
	public HealthFacilityEntity create(HealthFacilityEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		HealthFacilityEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		HealthFacilityEntity newEntity;

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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'create')")
	public List<HealthFacilityEntity> createAll(Iterable<HealthFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<HealthFacilityEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<HealthFacilityEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'update')")
	public HealthFacilityEntity update(HealthFacilityEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		HealthFacilityEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'update')")
	public HealthFacilityEntity update(HealthFacilityEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		HealthFacilityEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		HealthFacilityEntity newEntity;

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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'update')")
	public List<HealthFacilityEntity> updateAll(Iterable<HealthFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<HealthFacilityEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<HealthFacilityEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'create') or hasPermission('HealthFacilityEntity', 'update')")
	public HealthFacilityEntity save(HealthFacilityEntity entity) throws ConstraintViolationException
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

		HealthFacilityEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'create') or hasPermission('HealthFacilityEntity', 'update')")
	public List<HealthFacilityEntity> saveAll(Iterable<HealthFacilityEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<HealthFacilityEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	public List<HealthFacilityEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	public List<HealthFacilityEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(HealthFacilityEntity.class);

		// % protected region % [Add any additional processing before converting to a list of HealthFacilityEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of HealthFacilityEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HealthFacilityEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of HealthFacilityEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of HealthFacilityEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(HealthFacilityEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of HealthFacilityEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of HealthFacilityEntityAudits
	 */
	private List<HealthFacilityEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<HealthFacilityEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param healthFacility healthFacility to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private HealthFacilityEntity updateAuditData(HealthFacilityEntity healthFacility)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return healthFacility;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private HealthFacilityEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		HealthFacilityEntity entityAtRevision = updateAuditData((HealthFacilityEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new HealthFacilityEntityAudit(
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

		QHealthFacilityEntity entity = QHealthFacilityEntity.healthFacilityEntity;

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
			case "dismissalReferringFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalReferringFacility.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] end

				break;
			case "referringFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Referring facility to Referring facility here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Referring facility to Referring facility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringFacility.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Referring facility to Referring facility here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Referring facility to Referring facility here] end

				break;
			case "healthFacilityID":
				// % protected region % [Add any additional logic before the query parameters of healthFacilityID here] off begin
				// % protected region % [Add any additional logic before the query parameters of healthFacilityID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.healthFacilityID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of healthFacilityID here] off begin
				// % protected region % [Add any additional logic after the query parameters of healthFacilityID here] end

				break;
			case "healthFacilityName":
				// % protected region % [Add any additional logic before the query parameters of healthFacilityName here] off begin
				// % protected region % [Add any additional logic before the query parameters of healthFacilityName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.healthFacilityName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of healthFacilityName here] off begin
				// % protected region % [Add any additional logic after the query parameters of healthFacilityName here] end

				break;
			case "phoneNumber":
				// % protected region % [Add any additional logic before the query parameters of phoneNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of phoneNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.phoneNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of phoneNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of phoneNumber here] end

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
	public HealthFacilityEntity updateOldData(HealthFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public HealthFacilityEntity updateOldData(HealthFacilityEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		HealthFacilityEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInHealthFacilityEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getDismissalReferringFacilityIds().isEmpty() && entity.getDismissalReferringFacility().isEmpty()) {
			entityToUpdate.setDismissalReferringFacility(new HashSet<>());
		} else if (!entity.getDismissalReferringFacilityIds().isEmpty() && entity.getDismissalReferringFacility().isEmpty()) {
			Iterable<RegistrationEntity> dismissalReferringFacilityEntities =
					this.registrationRepository.findAllById(entity.getDismissalReferringFacilityIds());
			entityToUpdate.setDismissalReferringFacility(Sets.newHashSet(dismissalReferringFacilityEntities));
		}
		if (persistRelations && !entity.getDismissalReferringFacility().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getDismissalReferringFacility().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDismissalReferringFacility(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getReferringFacilityIds().isEmpty() && entity.getReferringFacility().isEmpty()) {
			entityToUpdate.setReferringFacility(new HashSet<>());
		} else if (!entity.getReferringFacilityIds().isEmpty() && entity.getReferringFacility().isEmpty()) {
			Iterable<RegistrationEntity> referringFacilityEntities =
					this.registrationRepository.findAllById(entity.getReferringFacilityIds());
			entityToUpdate.setReferringFacility(Sets.newHashSet(referringFacilityEntities));
		}
		if (persistRelations && !entity.getReferringFacility().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getReferringFacility().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setReferringFacility(updatedEntities);
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
	public void validateEntity(HealthFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<HealthFacilityEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByHealthFacilityIDOpt = this.findByHealthFacilityID(entity.getHealthFacilityID());
			if (entityByHealthFacilityIDOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<HealthFacilityEntity>(
						"Health Facility ID",
						entity.getHealthFacilityID(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"HealthFacilityID"
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
	 * Get the sort as given by the sort by for the HealthFacilityEntity.
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

	public Set<String> validateEntityRelations(HealthFacilityEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getDismissalReferringFacilityIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getReferringFacilityIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
