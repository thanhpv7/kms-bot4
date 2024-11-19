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

import kmsweb.entities.BedFacilityEntity;
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
public interface BedFacilityRepository extends AbstractRepository<BedFacilityEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Bed Number.
	 *
	 * @param bedNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Number
	 */
	Optional<BedFacilityEntity> findByBedNumber(@NotNull String bedNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Bed Name.
	 *
	 * @param bedName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Name
	 */
	List<BedFacilityEntity> findByBedName(@NotNull String bedName);
	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	List<BedFacilityEntity> findByTreatmentClass(@NotNull String treatmentClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Availability.
	 *
	 * @param availability the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Availability
	 */
	List<BedFacilityEntity> findByAvailability(@NotNull String availability);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<BedFacilityEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute COA COGS.
	 *
	 * @param coaCOGS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA COGS
	 */
	List<BedFacilityEntity> findByCoaCOGS(@NotNull String coaCOGS);
	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	List<BedFacilityEntity> findByCoaSell(@NotNull String coaSell);
	/**
	 * Return an entity or a list of entities that have the given attribute COA Inventory.
	 *
	 * @param coaInventory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Inventory
	 */
	List<BedFacilityEntity> findByCoaInventory(@NotNull String coaInventory);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BedFacilityEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<BedFacilityEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}