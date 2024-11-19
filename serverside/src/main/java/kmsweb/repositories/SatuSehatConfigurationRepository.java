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

import kmsweb.entities.SatuSehatConfigurationEntity;
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
public interface SatuSehatConfigurationRepository extends AbstractRepository<SatuSehatConfigurationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Organization ID.
	 *
	 * @param organizationID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Organization ID
	 */
	List<SatuSehatConfigurationEntity> findByOrganizationID(@NotNull String organizationID);
	/**
	 * Return an entity or a list of entities that have the given attribute Client ID.
	 *
	 * @param clientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Client ID
	 */
	List<SatuSehatConfigurationEntity> findByClientID(@NotNull String clientID);
	/**
	 * Return an entity or a list of entities that have the given attribute Secret Key.
	 *
	 * @param secretKey the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Secret Key
	 */
	List<SatuSehatConfigurationEntity> findBySecretKey(@NotNull String secretKey);
	/**
	 * Return an entity or a list of entities that have the given attribute Token Request.
	 *
	 * @param tokenRequest the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Token Request
	 */
	List<SatuSehatConfigurationEntity> findByTokenRequest(@NotNull String tokenRequest);
	/**
	 * Return an entity or a list of entities that have the given attribute Base URL.
	 *
	 * @param baseURL the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Base URL
	 */
	List<SatuSehatConfigurationEntity> findByBaseURL(@NotNull String baseURL);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SatuSehatConfigurationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<SatuSehatConfigurationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}