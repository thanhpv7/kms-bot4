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
import kmsweb.repositories.BpjsGeneralRepository;
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
public class BpjsGeneralService extends AbstractService<BpjsGeneralEntity, BpjsGeneralRepository, BpjsGeneralEntityAudit> {

	private final String[] referenceNamesInBpjsGeneralEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BpjsGeneralService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		BpjsGeneralRepository repository
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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Cons ID.
	 *
	 * @param consID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cons ID
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByConsID(String consID)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsID here] end
	{
		// % protected region % [Add any additional logic for findByConsID before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsID before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByConsID(consID));

		// % protected region % [Add any additional logic for findByConsID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findBySecretKey(String secretKey)
	// % protected region % [Add any throwables, implementations, or extensions for findBySecretKey here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySecretKey here] end
	{
		// % protected region % [Add any additional logic for findBySecretKey before the main body here] off begin
		// % protected region % [Add any additional logic for findBySecretKey before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findBySecretKey(secretKey));

		// % protected region % [Add any additional logic for findBySecretKey before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySecretKey before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Web Service URL.
	 *
	 * @param bpjsWebServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Web Service URL
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByBpjsWebServiceURL(String bpjsWebServiceURL)
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsWebServiceURL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBpjsWebServiceURL here] end
	{
		// % protected region % [Add any additional logic for findByBpjsWebServiceURL before the main body here] off begin
		// % protected region % [Add any additional logic for findByBpjsWebServiceURL before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByBpjsWebServiceURL(bpjsWebServiceURL));

		// % protected region % [Add any additional logic for findByBpjsWebServiceURL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBpjsWebServiceURL before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Aplicare Web Service URL.
	 *
	 * @param aplicareWebServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Aplicare Web Service URL
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByAplicareWebServiceURL(String aplicareWebServiceURL)
	// % protected region % [Add any throwables, implementations, or extensions for findByAplicareWebServiceURL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAplicareWebServiceURL here] end
	{
		// % protected region % [Add any additional logic for findByAplicareWebServiceURL before the main body here] off begin
		// % protected region % [Add any additional logic for findByAplicareWebServiceURL before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByAplicareWebServiceURL(aplicareWebServiceURL));

		// % protected region % [Add any additional logic for findByAplicareWebServiceURL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAplicareWebServiceURL before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Code.
	 *
	 * @param healthFacilityCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Code
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByHealthFacilityCode(String healthFacilityCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityCode here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityCode before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByHealthFacilityCode(healthFacilityCode));

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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByHealthFacilityName(String healthFacilityName)
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHealthFacilityName here] end
	{
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityName before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByHealthFacilityName(healthFacilityName));

		// % protected region % [Add any additional logic for findByHealthFacilityName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHealthFacilityName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute MJKN WS BPJS URL.
	 *
	 * @param mjknWSBPJSURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MJKN WS BPJS URL
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByMjknWSBPJSURL(String mjknWSBPJSURL)
	// % protected region % [Add any throwables, implementations, or extensions for findByMjknWSBPJSURL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMjknWSBPJSURL here] end
	{
		// % protected region % [Add any additional logic for findByMjknWSBPJSURL before the main body here] off begin
		// % protected region % [Add any additional logic for findByMjknWSBPJSURL before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByMjknWSBPJSURL(mjknWSBPJSURL));

		// % protected region % [Add any additional logic for findByMjknWSBPJSURL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMjknWSBPJSURL before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute MJKN WS BPJS User Key.
	 *
	 * @param mjknWSBPJSUserKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MJKN WS BPJS User Key
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByMjknWSBPJSUserKey(String mjknWSBPJSUserKey)
	// % protected region % [Add any throwables, implementations, or extensions for findByMjknWSBPJSUserKey here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMjknWSBPJSUserKey here] end
	{
		// % protected region % [Add any additional logic for findByMjknWSBPJSUserKey before the main body here] off begin
		// % protected region % [Add any additional logic for findByMjknWSBPJSUserKey before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByMjknWSBPJSUserKey(mjknWSBPJSUserKey));

		// % protected region % [Add any additional logic for findByMjknWSBPJSUserKey before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMjknWSBPJSUserKey before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Vclaim User Key.
	 *
	 * @param vclaimUserKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vclaim User Key
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByVclaimUserKey(String vclaimUserKey)
	// % protected region % [Add any throwables, implementations, or extensions for findByVclaimUserKey here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVclaimUserKey here] end
	{
		// % protected region % [Add any additional logic for findByVclaimUserKey before the main body here] off begin
		// % protected region % [Add any additional logic for findByVclaimUserKey before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByVclaimUserKey(vclaimUserKey));

		// % protected region % [Add any additional logic for findByVclaimUserKey before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVclaimUserKey before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Connect To Other System.
	 *
	 * @param connectToOtherSystem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Connect To Other System
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByConnectToOtherSystem(Boolean connectToOtherSystem)
	// % protected region % [Add any throwables, implementations, or extensions for findByConnectToOtherSystem here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConnectToOtherSystem here] end
	{
		// % protected region % [Add any additional logic for findByConnectToOtherSystem before the main body here] off begin
		// % protected region % [Add any additional logic for findByConnectToOtherSystem before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByConnectToOtherSystem(connectToOtherSystem));

		// % protected region % [Add any additional logic for findByConnectToOtherSystem before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConnectToOtherSystem before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute IsMobileJKN.
	 *
	 * @param ismobilejkn the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IsMobileJKN
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByIsmobilejkn(Boolean ismobilejkn)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsmobilejkn here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsmobilejkn here] end
	{
		// % protected region % [Add any additional logic for findByIsmobilejkn before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsmobilejkn before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByIsmobilejkn(ismobilejkn));

		// % protected region % [Add any additional logic for findByIsmobilejkn before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsmobilejkn before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute External System URL.
	 *
	 * @param externalSystemURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External System URL
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByExternalSystemURL(String externalSystemURL)
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalSystemURL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalSystemURL here] end
	{
		// % protected region % [Add any additional logic for findByExternalSystemURL before the main body here] off begin
		// % protected region % [Add any additional logic for findByExternalSystemURL before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByExternalSystemURL(externalSystemURL));

		// % protected region % [Add any additional logic for findByExternalSystemURL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExternalSystemURL before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth.
	 *
	 * @param basicAuth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByBasicAuth(Boolean basicAuth)
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuth here] end
	{
		// % protected region % [Add any additional logic for findByBasicAuth before the main body here] off begin
		// % protected region % [Add any additional logic for findByBasicAuth before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByBasicAuth(basicAuth));

		// % protected region % [Add any additional logic for findByBasicAuth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBasicAuth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth Username.
	 *
	 * @param basicAuthUsername the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth Username
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsGeneralEntity> findByBasicAuthUsername(String basicAuthUsername)
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuthUsername here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuthUsername here] end
	{
		// % protected region % [Add any additional logic for findByBasicAuthUsername before the main body here] off begin
		// % protected region % [Add any additional logic for findByBasicAuthUsername before the main body here] end

		Optional<BpjsGeneralEntity> entity = repository.findByBasicAuthUsername(basicAuthUsername);

		// % protected region % [Add any additional logic for findByBasicAuthUsername before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByBasicAuthUsername before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth Password.
	 *
	 * @param basicAuthPassword the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth Password
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsGeneralEntity> findByBasicAuthPassword(String basicAuthPassword)
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuthPassword here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBasicAuthPassword here] end
	{
		// % protected region % [Add any additional logic for findByBasicAuthPassword before the main body here] off begin
		// % protected region % [Add any additional logic for findByBasicAuthPassword before the main body here] end

		Optional<BpjsGeneralEntity> entity = repository.findByBasicAuthPassword(basicAuthPassword);

		// % protected region % [Add any additional logic for findByBasicAuthPassword before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByBasicAuthPassword before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bypass SSL Validation.
	 *
	 * @param bypassSSLValidation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bypass SSL Validation
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByBypassSSLValidation(Boolean bypassSSLValidation)
	// % protected region % [Add any throwables, implementations, or extensions for findByBypassSSLValidation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBypassSSLValidation here] end
	{
		// % protected region % [Add any additional logic for findByBypassSSLValidation before the main body here] off begin
		// % protected region % [Add any additional logic for findByBypassSSLValidation before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByBypassSSLValidation(bypassSSLValidation));

		// % protected region % [Add any additional logic for findByBypassSSLValidation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBypassSSLValidation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim Status.
	 *
	 * @param claimStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Status
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByClaimStatus(Boolean claimStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimStatus here] end
	{
		// % protected region % [Add any additional logic for findByClaimStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimStatus before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByClaimStatus(claimStatus));

		// % protected region % [Add any additional logic for findByClaimStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility Type.
	 *
	 * @param facilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Type
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByFacilityType(String facilityType)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityType here] end
	{
		// % protected region % [Add any additional logic for findByFacilityType before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityType before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByFacilityType(facilityType));

		// % protected region % [Add any additional logic for findByFacilityType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Send Non JKN.
	 *
	 * @param sendNonJKN the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Send Non JKN
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findBySendNonJKN(Boolean sendNonJKN)
	// % protected region % [Add any throwables, implementations, or extensions for findBySendNonJKN here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySendNonJKN here] end
	{
		// % protected region % [Add any additional logic for findBySendNonJKN before the main body here] off begin
		// % protected region % [Add any additional logic for findBySendNonJKN before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findBySendNonJKN(sendNonJKN));

		// % protected region % [Add any additional logic for findBySendNonJKN before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySendNonJKN before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Vclaim Integration.
	 *
	 * @param vclaimIntegration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vclaim Integration
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByVclaimIntegration(Boolean vclaimIntegration)
	// % protected region % [Add any throwables, implementations, or extensions for findByVclaimIntegration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVclaimIntegration here] end
	{
		// % protected region % [Add any additional logic for findByVclaimIntegration before the main body here] off begin
		// % protected region % [Add any additional logic for findByVclaimIntegration before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByVclaimIntegration(vclaimIntegration));

		// % protected region % [Add any additional logic for findByVclaimIntegration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVclaimIntegration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute External Vclaim Service URL.
	 *
	 * @param externalVclaimServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Vclaim Service URL
	 */
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findByExternalVclaimServiceURL(String externalVclaimServiceURL)
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalVclaimServiceURL here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExternalVclaimServiceURL here] end
	{
		// % protected region % [Add any additional logic for findByExternalVclaimServiceURL before the main body here] off begin
		// % protected region % [Add any additional logic for findByExternalVclaimServiceURL before the main body here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findByExternalVclaimServiceURL(externalVclaimServiceURL));

		// % protected region % [Add any additional logic for findByExternalVclaimServiceURL before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExternalVclaimServiceURL before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BpjsGeneralEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BpjsGeneralEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BpjsGeneralEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BpjsGeneralEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'create')")
	public BpjsGeneralEntity create(BpjsGeneralEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BpjsGeneralEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'create')")
	public BpjsGeneralEntity create(BpjsGeneralEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BpjsGeneralEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BpjsGeneralEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'create')")
	public List<BpjsGeneralEntity> createAll(Iterable<BpjsGeneralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BpjsGeneralEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BpjsGeneralEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'update')")
	public BpjsGeneralEntity update(BpjsGeneralEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BpjsGeneralEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'update')")
	public BpjsGeneralEntity update(BpjsGeneralEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BpjsGeneralEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BpjsGeneralEntity newEntity;

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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'update')")
	public List<BpjsGeneralEntity> updateAll(Iterable<BpjsGeneralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BpjsGeneralEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BpjsGeneralEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'create') or hasPermission('BpjsGeneralEntity', 'update')")
	public BpjsGeneralEntity save(BpjsGeneralEntity entity) throws ConstraintViolationException
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

		BpjsGeneralEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'create') or hasPermission('BpjsGeneralEntity', 'update')")
	public List<BpjsGeneralEntity> saveAll(Iterable<BpjsGeneralEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BpjsGeneralEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	public List<BpjsGeneralEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	public List<BpjsGeneralEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BpjsGeneralEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BpjsGeneralEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsGeneralEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BpjsGeneralEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BpjsGeneralEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BpjsGeneralEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BpjsGeneralEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BpjsGeneralEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BpjsGeneralEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BpjsGeneralEntityAudits
	 */
	private List<BpjsGeneralEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BpjsGeneralEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bpjsGeneral bpjsGeneral to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BpjsGeneralEntity updateAuditData(BpjsGeneralEntity bpjsGeneral)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bpjsGeneral;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BpjsGeneralEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BpjsGeneralEntity entityAtRevision = updateAuditData((BpjsGeneralEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BpjsGeneralEntityAudit(
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

		QBpjsGeneralEntity entity = QBpjsGeneralEntity.bpjsGeneralEntity;

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
			case "consID":
				// % protected region % [Add any additional logic before the query parameters of consID here] off begin
				// % protected region % [Add any additional logic before the query parameters of consID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.consID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of consID here] off begin
				// % protected region % [Add any additional logic after the query parameters of consID here] end

				break;
			case "secretKey":
				// % protected region % [Add any additional logic before the query parameters of secretKey here] off begin
				// % protected region % [Add any additional logic before the query parameters of secretKey here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.secretKey, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of secretKey here] off begin
				// % protected region % [Add any additional logic after the query parameters of secretKey here] end

				break;
			case "aplicareWebServiceURL":
				// % protected region % [Add any additional logic before the query parameters of aplicareWebServiceURL here] off begin
				// % protected region % [Add any additional logic before the query parameters of aplicareWebServiceURL here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.aplicareWebServiceURL, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of aplicareWebServiceURL here] off begin
				// % protected region % [Add any additional logic after the query parameters of aplicareWebServiceURL here] end

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
			case "vclaimUserKey":
				// % protected region % [Add any additional logic before the query parameters of vclaimUserKey here] off begin
				// % protected region % [Add any additional logic before the query parameters of vclaimUserKey here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vclaimUserKey, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of vclaimUserKey here] off begin
				// % protected region % [Add any additional logic after the query parameters of vclaimUserKey here] end

				break;
			case "connectToOtherSystem":
				// % protected region % [Add any additional logic before the query parameters of connectToOtherSystem here] off begin
				// % protected region % [Add any additional logic before the query parameters of connectToOtherSystem here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.connectToOtherSystem, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of connectToOtherSystem here] off begin
				// % protected region % [Add any additional logic after the query parameters of connectToOtherSystem here] end

				break;
			case "ismobilejkn":
				// % protected region % [Add any additional logic before the query parameters of ismobilejkn here] off begin
				// % protected region % [Add any additional logic before the query parameters of ismobilejkn here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.ismobilejkn, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of ismobilejkn here] off begin
				// % protected region % [Add any additional logic after the query parameters of ismobilejkn here] end

				break;
			case "externalSystemURL":
				// % protected region % [Add any additional logic before the query parameters of externalSystemURL here] off begin
				// % protected region % [Add any additional logic before the query parameters of externalSystemURL here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.externalSystemURL, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of externalSystemURL here] off begin
				// % protected region % [Add any additional logic after the query parameters of externalSystemURL here] end

				break;
			case "basicAuthUsername":
				// % protected region % [Add any additional logic before the query parameters of basicAuthUsername here] off begin
				// % protected region % [Add any additional logic before the query parameters of basicAuthUsername here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.basicAuthUsername, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of basicAuthUsername here] off begin
				// % protected region % [Add any additional logic after the query parameters of basicAuthUsername here] end

				break;
			case "basicAuthPassword":
				// % protected region % [Add any additional logic before the query parameters of basicAuthPassword here] off begin
				// % protected region % [Add any additional logic before the query parameters of basicAuthPassword here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.basicAuthPassword, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of basicAuthPassword here] off begin
				// % protected region % [Add any additional logic after the query parameters of basicAuthPassword here] end

				break;
			case "externalVclaimServiceURL":
				// % protected region % [Add any additional logic before the query parameters of externalVclaimServiceURL here] off begin
				// % protected region % [Add any additional logic before the query parameters of externalVclaimServiceURL here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.externalVclaimServiceURL, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of externalVclaimServiceURL here] off begin
				// % protected region % [Add any additional logic after the query parameters of externalVclaimServiceURL here] end

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
	public BpjsGeneralEntity updateOldData(BpjsGeneralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BpjsGeneralEntity updateOldData(BpjsGeneralEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BpjsGeneralEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBpjsGeneralEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getConnectToOtherSystem() == null) {
			entityToUpdate.setConnectToOtherSystem(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsmobilejkn() == null) {
			entityToUpdate.setIsmobilejkn(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getBasicAuth() == null) {
			entityToUpdate.setBasicAuth(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getBypassSSLValidation() == null) {
			entityToUpdate.setBypassSSLValidation(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getClaimStatus() == null) {
			entityToUpdate.setClaimStatus(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getSendNonJKN() == null) {
			entityToUpdate.setSendNonJKN(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getVclaimIntegration() == null) {
			entityToUpdate.setVclaimIntegration(false);
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
	public void validateEntity(BpjsGeneralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BpjsGeneralEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByBasicAuthUsernameOpt = this.findByBasicAuthUsername(entity.getBasicAuthUsername());
			if (entityByBasicAuthUsernameOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<BpjsGeneralEntity>(
						"Basic Auth Username",
						entity.getBasicAuthUsername(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"BasicAuthUsername"
				);
				errors.add(uniquenessViolation);
			}
			var entityByBasicAuthPasswordOpt = this.findByBasicAuthPassword(entity.getBasicAuthPassword());
			if (entityByBasicAuthPasswordOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<BpjsGeneralEntity>(
						"Basic Auth Password",
						entity.getBasicAuthPassword(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"BasicAuthPassword"
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
	 * Get the sort as given by the sort by for the BpjsGeneralEntity.
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

	public Set<String> validateEntityRelations(BpjsGeneralEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
