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

import kmsweb.entities.RetailPharmacyStockDetailEntity;
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
public interface RetailPharmacyStockDetailRepository extends AbstractRepository<RetailPharmacyStockDetailEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Supply Stock Group.
	 *
	 * @param supplyStockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supply Stock Group
	 */
	List<RetailPharmacyStockDetailEntity> findBySupplyStockGroup(@NotNull String supplyStockGroup);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<RetailPharmacyStockDetailEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Quantity.
	 *
	 * @param availableQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Quantity
	 */
	List<RetailPharmacyStockDetailEntity> findByAvailableQuantity(@NotNull Double availableQuantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity.
	 *
	 * @param quantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity
	 */
	List<RetailPharmacyStockDetailEntity> findByQuantity(@NotNull Double quantity);
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	List<RetailPharmacyStockDetailEntity> findByUnitPrice(@NotNull Double unitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Discount.
	 *
	 * @param discount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount
	 */
	List<RetailPharmacyStockDetailEntity> findByDiscount(@NotNull Double discount);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Included.
	 *
	 * @param taxIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Included
	 */
	List<RetailPharmacyStockDetailEntity> findByTaxIncluded(@NotNull Boolean taxIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Amount.
	 *
	 * @param taxAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Amount
	 */
	List<RetailPharmacyStockDetailEntity> findByTaxAmount(@NotNull Double taxAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Item Price.
	 *
	 * @param totalItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Item Price
	 */
	List<RetailPharmacyStockDetailEntity> findByTotalItemPrice(@NotNull Double totalItemPrice);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyStockDetailEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<RetailPharmacyStockDetailEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}