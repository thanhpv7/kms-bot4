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
import kmsweb.repositories.BpjsINACBGRepository;
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
public class BpjsINACBGService extends AbstractService<BpjsINACBGEntity, BpjsINACBGRepository, BpjsINACBGEntityAudit> {

	private final String[] referenceNamesInBpjsINACBGEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsINACBGService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsINACBGRepository repository
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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Health Facility Code.
	 *
	 * @param healthFacilityCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByHealthFacilityCode(String healthFacilityCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityCode here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityCode before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByHealthFacilityCode(healthFacilityCode));

		// % protected region % [Add any additional logic for findByHealthFacilityCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Name.
	 *
	 * @param healthFacilityName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Name
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByHealthFacilityName(String healthFacilityName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByHealthFacilityName(healthFacilityName));

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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute State Province.
	 *
	 * @param stateProvince the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State Province
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByStateProvince(String stateProvince)
	// % protected region % [Add any throwables, implementations, or extensions for findByStateProvince here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStateProvince here] end
	{
		// % protected region % [Add any additional logic for findByStateProvince before the main body here] off begin
		// % protected region % [Add any additional logic for findByStateProvince before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByStateProvince(stateProvince));

		// % protected region % [Add any additional logic for findByStateProvince before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStateProvince before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute City Regency.
	 *
	 * @param cityRegency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City Regency
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByCityRegency(String cityRegency)
	// % protected region % [Add any throwables, implementations, or extensions for findByCityRegency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCityRegency here] end
	{
		// % protected region % [Add any additional logic for findByCityRegency before the main body here] off begin
		// % protected region % [Add any additional logic for findByCityRegency before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByCityRegency(cityRegency));

		// % protected region % [Add any additional logic for findByCityRegency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCityRegency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Regional.
	 *
	 * @param regional the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Regional
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByRegional(String regional)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegional here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegional here] end
	{
		// % protected region % [Add any additional logic for findByRegional before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegional before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByRegional(regional));

		// % protected region % [Add any additional logic for findByRegional before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegional before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByHospitalClass(String hospitalClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHospitalClass here] end
	{
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByHospitalClass(hospitalClass));

		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHospitalClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff 1.
	 *
	 * @param inacbgTariff1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff 1
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByInacbgTariff1(String inacbgTariff1)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff1 here] end
	{
		// % protected region % [Add any additional logic for findByInacbgTariff1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff1 before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByInacbgTariff1(inacbgTariff1));

		// % protected region % [Add any additional logic for findByInacbgTariff1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute INACBG Tariff 2.
	 *
	 * @param inacbgTariff2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute INACBG Tariff 2
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByInacbgTariff2(String inacbgTariff2)
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInacbgTariff2 here] end
	{
		// % protected region % [Add any additional logic for findByInacbgTariff2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff2 before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByInacbgTariff2(inacbgTariff2));

		// % protected region % [Add any additional logic for findByInacbgTariff2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInacbgTariff2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Additional Upgrade VIP.
	 *
	 * @param additionalUpgradeVIP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Additional Upgrade VIP
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByAdditionalUpgradeVIP(String additionalUpgradeVIP)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalUpgradeVIP here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdditionalUpgradeVIP here] end
	{
		// % protected region % [Add any additional logic for findByAdditionalUpgradeVIP before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdditionalUpgradeVIP before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByAdditionalUpgradeVIP(additionalUpgradeVIP));

		// % protected region % [Add any additional logic for findByAdditionalUpgradeVIP before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdditionalUpgradeVIP before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payplan ID.
	 *
	 * @param payplanID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payplan ID
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByPayplanID(String payplanID)
	// % protected region % [Add any throwables, implementations, or extensions for findByPayplanID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPayplanID here] end
	{
		// % protected region % [Add any additional logic for findByPayplanID before the main body here] off begin
		// % protected region % [Add any additional logic for findByPayplanID before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByPayplanID(payplanID));

		// % protected region % [Add any additional logic for findByPayplanID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPayplanID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Plan Code.
	 *
	 * @param paymentPlanCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Plan Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByPaymentPlanCode(String paymentPlanCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentPlanCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentPlanCode here] end
	{
		// % protected region % [Add any additional logic for findByPaymentPlanCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentPlanCode before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByPaymentPlanCode(paymentPlanCode));

		// % protected region % [Add any additional logic for findByPaymentPlanCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentPlanCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Code.
	 *
	 * @param tariffCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Code
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByTariffCode(String tariffCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffCode here] end
	{
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByTariffCode(tariffCode));

		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute URL.
	 *
	 * @param url the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute URL
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByUrl(String url)
	// % protected region % [Add any throwables, implementations, or extensions for findByUrl here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUrl here] end
	{
		// % protected region % [Add any additional logic for findByUrl before the main body here] off begin
		// % protected region % [Add any additional logic for findByUrl before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByUrl(url));

		// % protected region % [Add any additional logic for findByUrl before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUrl before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Username.
	 *
	 * @param username the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Username
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByUsername(String username)
	// % protected region % [Add any throwables, implementations, or extensions for findByUsername here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUsername here] end
	{
		// % protected region % [Add any additional logic for findByUsername before the main body here] off begin
		// % protected region % [Add any additional logic for findByUsername before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByUsername(username));

		// % protected region % [Add any additional logic for findByUsername before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUsername before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Password.
	 *
	 * @param password the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Password
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByPassword(String password)
	// % protected region % [Add any throwables, implementations, or extensions for findByPassword here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPassword here] end
	{
		// % protected region % [Add any additional logic for findByPassword before the main body here] off begin
		// % protected region % [Add any additional logic for findByPassword before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByPassword(password));

		// % protected region % [Add any additional logic for findByPassword before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPassword before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findBySecretKey(String secretKey)
	// % protected region % [Add any throwables, implementations, or extensions for findBySecretKey here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySecretKey here] end
	{
		// % protected region % [Add any additional logic for findBySecretKey before the main body here] off begin
		// % protected region % [Add any additional logic for findBySecretKey before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findBySecretKey(secretKey));

		// % protected region % [Add any additional logic for findBySecretKey before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySecretKey before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Coder ID.
	 *
	 * @param coderID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Coder ID
	 */
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findByCoderID(String coderID)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoderID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoderID here] end
	{
		// % protected region % [Add any additional logic for findByCoderID before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoderID before the main body here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findByCoderID(coderID));

		// % protected region % [Add any additional logic for findByCoderID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoderID before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsINACBGEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsINACBGEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsINACBGEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsINACBGEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'create')")
	public BpjsINACBGEntity create(BpjsINACBGEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsINACBGEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'create')")
	public BpjsINACBGEntity create(BpjsINACBGEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsINACBGEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsINACBGEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'create')")
	public List<BpjsINACBGEntity> createAll(Iterable<BpjsINACBGEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsINACBGEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsINACBGEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'update')")
	public BpjsINACBGEntity update(BpjsINACBGEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsINACBGEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'update')")
	public BpjsINACBGEntity update(BpjsINACBGEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsINACBGEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsINACBGEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'update')")
	public List<BpjsINACBGEntity> updateAll(Iterable<BpjsINACBGEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsINACBGEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsINACBGEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'create') or hasPermission('BpjsINACBGEntity', 'update')")
	public BpjsINACBGEntity save(BpjsINACBGEntity entity) throws ConstraintViolationException
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

		BpjsINACBGEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'create') or hasPermission('BpjsINACBGEntity', 'update')")
	public List<BpjsINACBGEntity> saveAll(Iterable<BpjsINACBGEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsINACBGEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	public List<BpjsINACBGEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	public List<BpjsINACBGEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsINACBGEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsINACBGEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsINACBGEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsINACBGEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsINACBGEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsINACBGEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsINACBGEntityAudits
	 */
	private List<BpjsINACBGEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsINACBGEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsINACBG bpjsINACBG to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsINACBGEntity updateAuditData(BpjsINACBGEntity bpjsINACBG)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsINACBG;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsINACBGEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsINACBGEntity entityAtRevision = updateAuditData((BpjsINACBGEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsINACBGEntityAudit(
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

		QBpjsINACBGEntity entity = QBpjsINACBGEntity.bpjsINACBGEntity;

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
			case "healthFacilityCode":
				// % protected region % [Add any additional logic before the query parameters of healthFacilityCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of healthFacilityCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.healthFacilityCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of healthFacilityCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of healthFacilityCode here] end

				break;
			case "healthFacilityName":
				// % protected region % [Add any additional logic before the query parameters of healthFacilityName here] off begin
				// % protected region % [Add any additional logic before the query parameters of healthFacilityName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.healthFacilityName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of healthFacilityName here] off begin
				// % protected region % [Add any additional logic after the query parameters of healthFacilityName here] end

				break;
			case "address":
				// % protected region % [Add any additional logic before the query parameters of address here] off begin
				// % protected region % [Add any additional logic before the query parameters of address here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.address, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of address here] off begin
				// % protected region % [Add any additional logic after the query parameters of address here] end

				break;
			case "stateProvince":
				// % protected region % [Add any additional logic before the query parameters of stateProvince here] off begin
				// % protected region % [Add any additional logic before the query parameters of stateProvince here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stateProvince, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of stateProvince here] off begin
				// % protected region % [Add any additional logic after the query parameters of stateProvince here] end

				break;
			case "cityRegency":
				// % protected region % [Add any additional logic before the query parameters of cityRegency here] off begin
				// % protected region % [Add any additional logic before the query parameters of cityRegency here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cityRegency, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of cityRegency here] off begin
				// % protected region % [Add any additional logic after the query parameters of cityRegency here] end

				break;
			case "regional":
				// % protected region % [Add any additional logic before the query parameters of regional here] off begin
				// % protected region % [Add any additional logic before the query parameters of regional here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.regional, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of regional here] off begin
				// % protected region % [Add any additional logic after the query parameters of regional here] end

				break;
			case "hospitalClass":
				// % protected region % [Add any additional logic before the query parameters of hospitalClass here] off begin
				// % protected region % [Add any additional logic before the query parameters of hospitalClass here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalClass, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of hospitalClass here] off begin
				// % protected region % [Add any additional logic after the query parameters of hospitalClass here] end

				break;
			case "inacbgTariff1":
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff1 here] off begin
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff1 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inacbgTariff1, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inacbgTariff1 here] off begin
				// % protected region % [Add any additional logic after the query parameters of inacbgTariff1 here] end

				break;
			case "inacbgTariff2":
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff2 here] off begin
				// % protected region % [Add any additional logic before the query parameters of inacbgTariff2 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inacbgTariff2, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inacbgTariff2 here] off begin
				// % protected region % [Add any additional logic after the query parameters of inacbgTariff2 here] end

				break;
			case "additionalUpgradeVIP":
				// % protected region % [Add any additional logic before the query parameters of additionalUpgradeVIP here] off begin
				// % protected region % [Add any additional logic before the query parameters of additionalUpgradeVIP here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalUpgradeVIP, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of additionalUpgradeVIP here] off begin
				// % protected region % [Add any additional logic after the query parameters of additionalUpgradeVIP here] end

				break;
			case "payplanID":
				// % protected region % [Add any additional logic before the query parameters of payplanID here] off begin
				// % protected region % [Add any additional logic before the query parameters of payplanID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.payplanID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of payplanID here] off begin
				// % protected region % [Add any additional logic after the query parameters of payplanID here] end

				break;
			case "paymentPlanCode":
				// % protected region % [Add any additional logic before the query parameters of paymentPlanCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of paymentPlanCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.paymentPlanCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of paymentPlanCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of paymentPlanCode here] end

				break;
			case "tariffCode":
				// % protected region % [Add any additional logic before the query parameters of tariffCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of tariffCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tariffCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of tariffCode here] end

				break;
			case "url":
				// % protected region % [Add any additional logic before the query parameters of url here] off begin
				// % protected region % [Add any additional logic before the query parameters of url here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.url, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of url here] off begin
				// % protected region % [Add any additional logic after the query parameters of url here] end

				break;
			case "username":
				// % protected region % [Add any additional logic before the query parameters of username here] off begin
				// % protected region % [Add any additional logic before the query parameters of username here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.username, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of username here] off begin
				// % protected region % [Add any additional logic after the query parameters of username here] end

				break;
			case "password":
				// % protected region % [Add any additional logic before the query parameters of password here] off begin
				// % protected region % [Add any additional logic before the query parameters of password here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.password, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of password here] off begin
				// % protected region % [Add any additional logic after the query parameters of password here] end

				break;
			case "secretKey":
				// % protected region % [Add any additional logic before the query parameters of secretKey here] off begin
				// % protected region % [Add any additional logic before the query parameters of secretKey here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.secretKey, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of secretKey here] off begin
				// % protected region % [Add any additional logic after the query parameters of secretKey here] end

				break;
			case "coderID":
				// % protected region % [Add any additional logic before the query parameters of coderID here] off begin
				// % protected region % [Add any additional logic before the query parameters of coderID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coderID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of coderID here] off begin
				// % protected region % [Add any additional logic after the query parameters of coderID here] end

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
	public BpjsINACBGEntity updateOldData(BpjsINACBGEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsINACBGEntity updateOldData(BpjsINACBGEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsINACBGEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsINACBGEntity);

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
	public void validateEntity(BpjsINACBGEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsINACBGEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BpjsINACBGEntity.
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

	public Set<String> validateEntityRelations(BpjsINACBGEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
