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

import kmsweb.entities.MerchantEntity;
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
public interface MerchantRepository extends AbstractRepository<MerchantEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Merchant Name.
	 *
	 * @param merchantName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Merchant Name
	 */
	List<MerchantEntity> findByMerchantName(@NotNull String merchantName);
	/**
	 * Return an entity or a list of entities that have the given attribute Merchant Number.
	 *
	 * @param merchantNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Merchant Number
	 */
	Optional<MerchantEntity> findByMerchantNumber(@NotNull String merchantNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Bank Account.
	 *
	 * @param bankAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bank Account
	 */
	List<MerchantEntity> findByBankAccount(@NotNull String bankAccount);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MerchantEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MerchantEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}