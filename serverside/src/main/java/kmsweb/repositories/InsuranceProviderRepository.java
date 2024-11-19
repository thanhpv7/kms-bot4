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

import kmsweb.entities.InsuranceProviderEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface InsuranceProviderRepository extends AbstractRepository<InsuranceProviderEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Provider Code.
	 *
	 * @param providerCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Code
	 */
	Optional<InsuranceProviderEntity> findByProviderCode(@NotNull String providerCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Provider Name.
	 *
	 * @param providerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Name
	 */
	List<InsuranceProviderEntity> findByProviderName(@NotNull String providerName);
	/**
	 * Return an entity or a list of entities that have the given attribute Provider Type.
	 *
	 * @param providerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Provider Type
	 */
	List<InsuranceProviderEntity> findByProviderType(@NotNull String providerType);
	/**
	 * Return an entity or a list of entities that have the given attribute Benefit Provider.
	 *
	 * @param benefitProvider the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Benefit Provider
	 */
	List<InsuranceProviderEntity> findByBenefitProvider(@NotNull String benefitProvider);
	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	List<InsuranceProviderEntity> findByFirstName(@NotNull String firstName);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	List<InsuranceProviderEntity> findByLastName(@NotNull String lastName);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<InsuranceProviderEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone Number.
	 *
	 * @param mobilePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone Number
	 */
	List<InsuranceProviderEntity> findByMobilePhoneNumber(@NotNull String mobilePhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<InsuranceProviderEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Expiry Date.
	 *
	 * @param expiryDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiry Date
	 */
	List<InsuranceProviderEntity> findByExpiryDate(@NotNull OffsetDateTime expiryDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Expiring Date.
	 *
	 * @param expiringDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiring Date
	 */
	List<InsuranceProviderEntity> findByExpiringDate(@NotNull OffsetDateTime expiringDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Created Date.
	 *
	 * @param createdDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Created Date
	 */
	List<InsuranceProviderEntity> findByCreatedDate(@NotNull OffsetDateTime createdDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<InsuranceProviderEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InsuranceProviderEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<InsuranceProviderEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}