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

import kmsweb.entities.CatalogueUOMEntity;
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
public interface CatalogueUOMRepository extends AbstractRepository<CatalogueUOMEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Unit Name.
	 *
	 * @param unitName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Name
	 */
	List<CatalogueUOMEntity> findByUnitName(@NotNull String unitName);
	/**
	 * Return an entity or a list of entities that have the given attribute Conversion.
	 *
	 * @param conversion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Conversion
	 */
	List<CatalogueUOMEntity> findByConversion(@NotNull String conversion);
	/**
	 * Return an entity or a list of entities that have the given attribute Default Transaction.
	 *
	 * @param defaultTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Default Transaction
	 */
	List<CatalogueUOMEntity> findByDefaultTransaction(@NotNull Boolean defaultTransaction);
	/**
	 * Return an entity or a list of entities that have the given attribute Default Stock Card.
	 *
	 * @param defaultStockCard the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Default Stock Card
	 */
	List<CatalogueUOMEntity> findByDefaultStockCard(@NotNull Boolean defaultStockCard);
	/**
	 * Return an entity or a list of entities that have the given attribute Default Purchasing.
	 *
	 * @param defaultPurchasing the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Default Purchasing
	 */
	List<CatalogueUOMEntity> findByDefaultPurchasing(@NotNull Boolean defaultPurchasing);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueUOMEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueUOMEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}