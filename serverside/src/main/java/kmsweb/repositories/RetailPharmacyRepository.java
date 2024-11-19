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

import kmsweb.entities.RetailPharmacyEntity;
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
public interface RetailPharmacyRepository extends AbstractRepository<RetailPharmacyEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Customer Type.
	 *
	 * @param customerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Type
	 */
	List<RetailPharmacyEntity> findByCustomerType(@NotNull String customerType);
	/**
	 * Return an entity or a list of entities that have the given attribute Retail Number.
	 *
	 * @param retailNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Retail Number
	 */
	List<RetailPharmacyEntity> findByRetailNumber(@NotNull String retailNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	List<RetailPharmacyEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	List<RetailPharmacyEntity> findByCustomerName(@NotNull String customerName);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<RetailPharmacyEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<RetailPharmacyEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<RetailPharmacyEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Status.
	 *
	 * @param paymentStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Status
	 */
	List<RetailPharmacyEntity> findByPaymentStatus(@NotNull String paymentStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	List<RetailPharmacyEntity> findByTotalPrice(@NotNull Double totalPrice);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}