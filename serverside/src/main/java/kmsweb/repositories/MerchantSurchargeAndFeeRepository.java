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

import kmsweb.entities.MerchantSurchargeAndFeeEntity;
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
public interface MerchantSurchargeAndFeeRepository extends AbstractRepository<MerchantSurchargeAndFeeEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Bank Name.
	 *
	 * @param bankName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bank Name
	 */
	List<MerchantSurchargeAndFeeEntity> findByBankName(@NotNull String bankName);
	/**
	 * Return an entity or a list of entities that have the given attribute Card Type.
	 *
	 * @param cardType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Type
	 */
	List<MerchantSurchargeAndFeeEntity> findByCardType(@NotNull String cardType);
	/**
	 * Return an entity or a list of entities that have the given attribute Surcharge.
	 *
	 * @param surcharge the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surcharge
	 */
	List<MerchantSurchargeAndFeeEntity> findBySurcharge(@NotNull Double surcharge);
	/**
	 * Return an entity or a list of entities that have the given attribute Fee.
	 *
	 * @param fee the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fee
	 */
	List<MerchantSurchargeAndFeeEntity> findByFee(@NotNull String fee);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MerchantSurchargeAndFeeEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MerchantSurchargeAndFeeEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}