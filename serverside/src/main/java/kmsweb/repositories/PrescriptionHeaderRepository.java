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

import kmsweb.entities.PrescriptionHeaderEntity;
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
public interface PrescriptionHeaderRepository extends AbstractRepository<PrescriptionHeaderEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Prescription Number.
	 *
	 * @param prescriptionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Number
	 */
	List<PrescriptionHeaderEntity> findByPrescriptionNumber(@NotNull String prescriptionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Prescription Type.
	 *
	 * @param prescriptionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Type
	 */
	List<PrescriptionHeaderEntity> findByPrescriptionType(@NotNull String prescriptionType);
	/**
	 * Return an entity or a list of entities that have the given attribute Queue No.
	 *
	 * @param queueNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Queue No
	 */
	List<PrescriptionHeaderEntity> findByQueueNo(@NotNull String queueNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Original Prescription Number.
	 *
	 * @param originalPrescriptionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original Prescription Number
	 */
	List<PrescriptionHeaderEntity> findByOriginalPrescriptionNumber(@NotNull String originalPrescriptionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Prescription Date.
	 *
	 * @param prescriptionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Prescription Date
	 */
	List<PrescriptionHeaderEntity> findByPrescriptionDate(@NotNull OffsetDateTime prescriptionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Compound.
	 *
	 * @param isCompound the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Compound
	 */
	List<PrescriptionHeaderEntity> findByIsCompound(@NotNull Boolean isCompound);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Iteration.
	 *
	 * @param isIteration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Iteration
	 */
	List<PrescriptionHeaderEntity> findByIsIteration(@NotNull Boolean isIteration);
	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	List<PrescriptionHeaderEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Urgent.
	 *
	 * @param isUrgent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Urgent
	 */
	List<PrescriptionHeaderEntity> findByIsUrgent(@NotNull Boolean isUrgent);
	/**
	 * Return an entity or a list of entities that have the given attribute Restricted.
	 *
	 * @param restricted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Restricted
	 */
	List<PrescriptionHeaderEntity> findByRestricted(@NotNull Boolean restricted);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<PrescriptionHeaderEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Revision No.
	 *
	 * @param revisionNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision No
	 */
	List<PrescriptionHeaderEntity> findByRevisionNo(@NotNull Integer revisionNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Copy No.
	 *
	 * @param copyNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Copy No
	 */
	List<PrescriptionHeaderEntity> findByCopyNo(@NotNull Integer copyNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Is Invoiced.
	 *
	 * @param isInvoiced the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Invoiced
	 */
	List<PrescriptionHeaderEntity> findByIsInvoiced(@NotNull Boolean isInvoiced);
	/**
	 * Return an entity or a list of entities that have the given attribute External Warehouse.
	 *
	 * @param externalWarehouse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute External Warehouse
	 */
	List<PrescriptionHeaderEntity> findByExternalWarehouse(@NotNull Boolean externalWarehouse);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionHeaderEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PrescriptionHeaderEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}