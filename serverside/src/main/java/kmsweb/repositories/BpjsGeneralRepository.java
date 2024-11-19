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
package kmsweb.repositories;

import kmsweb.entities.BpjsGeneralEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface BpjsGeneralRepository extends AbstractRepository<BpjsGeneralEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Cons ID.
	 *
	 * @param consID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cons ID
	 */
	List<BpjsGeneralEntity> findByConsID(@NotNull String consID);
	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	List<BpjsGeneralEntity> findBySecretKey(@NotNull String secretKey);
	/**
	 * Return an entity or a list of entities that have the given attribute BPJS Web Service URL.
	 *
	 * @param bpjsWebServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BPJS Web Service URL
	 */
	List<BpjsGeneralEntity> findByBpjsWebServiceURL(@NotNull String bpjsWebServiceURL);
	/**
	 * Return an entity or a list of entities that have the given attribute Aplicare Web Service URL.
	 *
	 * @param aplicareWebServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Aplicare Web Service URL
	 */
	List<BpjsGeneralEntity> findByAplicareWebServiceURL(@NotNull String aplicareWebServiceURL);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Code.
	 *
	 * @param healthFacilityCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Code
	 */
	List<BpjsGeneralEntity> findByHealthFacilityCode(@NotNull String healthFacilityCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Name.
	 *
	 * @param healthFacilityName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Name
	 */
	List<BpjsGeneralEntity> findByHealthFacilityName(@NotNull String healthFacilityName);
	/**
	 * Return an entity or a list of entities that have the given attribute MJKN WS BPJS URL.
	 *
	 * @param mjknWSBPJSURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MJKN WS BPJS URL
	 */
	List<BpjsGeneralEntity> findByMjknWSBPJSURL(@NotNull String mjknWSBPJSURL);
	/**
	 * Return an entity or a list of entities that have the given attribute MJKN WS BPJS User Key.
	 *
	 * @param mjknWSBPJSUserKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MJKN WS BPJS User Key
	 */
	List<BpjsGeneralEntity> findByMjknWSBPJSUserKey(@NotNull String mjknWSBPJSUserKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Vclaim User Key.
	 *
	 * @param vclaimUserKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vclaim User Key
	 */
	List<BpjsGeneralEntity> findByVclaimUserKey(@NotNull String vclaimUserKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Connect To Other System.
	 *
	 * @param connectToOtherSystem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Connect To Other System
	 */
	List<BpjsGeneralEntity> findByConnectToOtherSystem(@NotNull Boolean connectToOtherSystem);
	/**
	 * Return an entity or a list of entities that have the given attribute IsMobileJKN.
	 *
	 * @param ismobilejkn the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IsMobileJKN
	 */
	List<BpjsGeneralEntity> findByIsmobilejkn(@NotNull Boolean ismobilejkn);
	/**
	 * Return an entity or a list of entities that have the given attribute External System URL.
	 *
	 * @param externalSystemURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External System URL
	 */
	List<BpjsGeneralEntity> findByExternalSystemURL(@NotNull String externalSystemURL);
	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth.
	 *
	 * @param basicAuth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth
	 */
	List<BpjsGeneralEntity> findByBasicAuth(@NotNull Boolean basicAuth);
	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth Username.
	 *
	 * @param basicAuthUsername the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth Username
	 */
	Optional<BpjsGeneralEntity> findByBasicAuthUsername(@NotNull String basicAuthUsername);
	/**
	 * Return an entity or a list of entities that have the given attribute Basic Auth Password.
	 *
	 * @param basicAuthPassword the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Basic Auth Password
	 */
	Optional<BpjsGeneralEntity> findByBasicAuthPassword(@NotNull String basicAuthPassword);
	/**
	 * Return an entity or a list of entities that have the given attribute Bypass SSL Validation.
	 *
	 * @param bypassSSLValidation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bypass SSL Validation
	 */
	List<BpjsGeneralEntity> findByBypassSSLValidation(@NotNull Boolean bypassSSLValidation);
	/**
	 * Return an entity or a list of entities that have the given attribute Claim Status.
	 *
	 * @param claimStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim Status
	 */
	List<BpjsGeneralEntity> findByClaimStatus(@NotNull Boolean claimStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility Type.
	 *
	 * @param facilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Type
	 */
	List<BpjsGeneralEntity> findByFacilityType(@NotNull String facilityType);
	/**
	 * Return an entity or a list of entities that have the given attribute Send Non JKN.
	 *
	 * @param sendNonJKN the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Send Non JKN
	 */
	List<BpjsGeneralEntity> findBySendNonJKN(@NotNull Boolean sendNonJKN);
	/**
	 * Return an entity or a list of entities that have the given attribute Vclaim Integration.
	 *
	 * @param vclaimIntegration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vclaim Integration
	 */
	List<BpjsGeneralEntity> findByVclaimIntegration(@NotNull Boolean vclaimIntegration);
	/**
	 * Return an entity or a list of entities that have the given attribute External Vclaim Service URL.
	 *
	 * @param externalVclaimServiceURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Vclaim Service URL
	 */
	List<BpjsGeneralEntity> findByExternalVclaimServiceURL(@NotNull String externalVclaimServiceURL);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsGeneralEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BpjsGeneralEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}