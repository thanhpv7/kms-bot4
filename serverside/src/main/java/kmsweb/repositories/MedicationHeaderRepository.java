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

import kmsweb.entities.MedicationHeaderEntity;
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
public interface MedicationHeaderRepository extends AbstractRepository<MedicationHeaderEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Medication Number.
	 *
	 * @param medicationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medication Number
	 */
	List<MedicationHeaderEntity> findByMedicationNumber(@NotNull String medicationNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Dispensing Type.
	 *
	 * @param dispensingType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dispensing Type
	 */
	List<MedicationHeaderEntity> findByDispensingType(@NotNull String dispensingType);
	/**
	 * Return an entity or a list of entities that have the given attribute Original Medication Number.
	 *
	 * @param originalMedicationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original Medication Number
	 */
	List<MedicationHeaderEntity> findByOriginalMedicationNumber(@NotNull String originalMedicationNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	List<MedicationHeaderEntity> findByOrderDate(@NotNull OffsetDateTime orderDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	List<MedicationHeaderEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<MedicationHeaderEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Urgent.
	 *
	 * @param isUrgent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Urgent
	 */
	List<MedicationHeaderEntity> findByIsUrgent(@NotNull Boolean isUrgent);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Compound.
	 *
	 * @param isCompound the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Compound
	 */
	List<MedicationHeaderEntity> findByIsCompound(@NotNull Boolean isCompound);
	/**
	 * Return an entity or a list of entities that have the given attribute Revision No.
	 *
	 * @param revisionNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision No
	 */
	List<MedicationHeaderEntity> findByRevisionNo(@NotNull Integer revisionNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Invoiced.
	 *
	 * @param isInvoiced the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Invoiced
	 */
	List<MedicationHeaderEntity> findByIsInvoiced(@NotNull Boolean isInvoiced);
	/**
	 * Return an entity or a list of entities that have the given attribute External Warehouse.
	 *
	 * @param externalWarehouse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Warehouse
	 */
	List<MedicationHeaderEntity> findByExternalWarehouse(@NotNull Boolean externalWarehouse);
	/**
	 * Return an entity or a list of entities that have the given attribute Restricted.
	 *
	 * @param restricted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Restricted
	 */
	List<MedicationHeaderEntity> findByRestricted(@NotNull Boolean restricted);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicationHeaderEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicationHeaderEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}