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

import kmsweb.entities.CatalogueNonMedicalEntity;
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
public interface CatalogueNonMedicalRepository extends AbstractRepository<CatalogueNonMedicalEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Manufacturer.
	 *
	 * @param manufacturer the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Manufacturer
	 */
	List<CatalogueNonMedicalEntity> findByManufacturer(@NotNull String manufacturer);
	/**
	 * Return an entity or a list of entities that have the given attribute Manufacturer Item Number.
	 *
	 * @param manufacturerItemNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Manufacturer Item Number
	 */
	List<CatalogueNonMedicalEntity> findByManufacturerItemNumber(@NotNull String manufacturerItemNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Expensive Item.
	 *
	 * @param isExpensiveItem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Expensive Item
	 */
	List<CatalogueNonMedicalEntity> findByIsExpensiveItem(@NotNull Boolean isExpensiveItem);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Consignment Item.
	 *
	 * @param isConsignmentItem the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Consignment Item
	 */
	List<CatalogueNonMedicalEntity> findByIsConsignmentItem(@NotNull Boolean isConsignmentItem);
	/**
	 * Return an entity or a list of entities that have the given attribute Model.
	 *
	 * @param model the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Model
	 */
	List<CatalogueNonMedicalEntity> findByModel(@NotNull String model);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueNonMedicalEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CatalogueNonMedicalEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}