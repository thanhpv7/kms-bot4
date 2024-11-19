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

import kmsweb.entities.FacilityHistoryEntity;
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
public interface FacilityHistoryRepository extends AbstractRepository<FacilityHistoryEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Change Date.
	 *
	 * @param changeDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Change Date
	 */
	List<FacilityHistoryEntity> findByChangeDate(@NotNull OffsetDateTime changeDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility No.
	 *
	 * @param facilityNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility No
	 */
	List<FacilityHistoryEntity> findByFacilityNo(@NotNull String facilityNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Current Qty.
	 *
	 * @param currentQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Current Qty
	 */
	List<FacilityHistoryEntity> findByCurrentQty(@NotNull Integer currentQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Changed Qty.
	 *
	 * @param changedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Changed Qty
	 */
	List<FacilityHistoryEntity> findByChangedQty(@NotNull Integer changedQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility Status.
	 *
	 * @param facilityStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Status
	 */
	List<FacilityHistoryEntity> findByFacilityStatus(@NotNull String facilityStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility Class.
	 *
	 * @param facilityClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Class
	 */
	List<FacilityHistoryEntity> findByFacilityClass(@NotNull String facilityClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility Type.
	 *
	 * @param facilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Type
	 */
	List<FacilityHistoryEntity> findByFacilityType(@NotNull String facilityType);
	/**
	 * Return an entity or a list of entities that have the given attribute Facility Service.
	 *
	 * @param facilityService the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Service
	 */
	List<FacilityHistoryEntity> findByFacilityService(@NotNull String facilityService);
	/**
	 * Return an entity or a list of entities that have the given attribute Bed Facility Id.
	 *
	 * @param bedFacilityId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Facility Id
	 */
	List<FacilityHistoryEntity> findByBedFacilityId(@NotNull String bedFacilityId);
	/**
	 * Return an entity or a list of entities that have the given attribute Registration Id.
	 *
	 * @param registrationId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Id
	 */
	List<FacilityHistoryEntity> findByRegistrationId(@NotNull String registrationId);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<FacilityHistoryEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<FacilityHistoryEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}