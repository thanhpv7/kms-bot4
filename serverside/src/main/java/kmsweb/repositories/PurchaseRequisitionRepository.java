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

import kmsweb.entities.PurchaseRequisitionEntity;
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
public interface PurchaseRequisitionRepository extends AbstractRepository<PurchaseRequisitionEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Requisition Number.
	 *
	 * @param purchaseRequisitionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Requisition Number
	 */
	List<PurchaseRequisitionEntity> findByPurchaseRequisitionNumber(@NotNull String purchaseRequisitionNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	List<PurchaseRequisitionEntity> findByTransactionStatus(@NotNull String transactionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	List<PurchaseRequisitionEntity> findByReferenceDocument(@NotNull String referenceDocument);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<PurchaseRequisitionEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	List<PurchaseRequisitionEntity> findByOrderDate(@NotNull OffsetDateTime orderDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Required Date.
	 *
	 * @param requiredDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Required Date
	 */
	List<PurchaseRequisitionEntity> findByRequiredDate(@NotNull OffsetDateTime requiredDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Estimation Order.
	 *
	 * @param totalEstimationOrder the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Estimation Order
	 */
	List<PurchaseRequisitionEntity> findByTotalEstimationOrder(@NotNull Double totalEstimationOrder);
	/**
	 * Return an entity or a list of entities that have the given attribute Redrafting Date Time.
	 *
	 * @param redraftingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Redrafting Date Time
	 */
	List<PurchaseRequisitionEntity> findByRedraftingDateTime(@NotNull OffsetDateTime redraftingDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Submission Date Time.
	 *
	 * @param submissionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Submission Date Time
	 */
	List<PurchaseRequisitionEntity> findBySubmissionDateTime(@NotNull OffsetDateTime submissionDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Date Time.
	 *
	 * @param approvalDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Date Time
	 */
	List<PurchaseRequisitionEntity> findByApprovalDateTime(@NotNull OffsetDateTime approvalDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Rejection Date Time.
	 *
	 * @param rejectionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rejection Date Time
	 */
	List<PurchaseRequisitionEntity> findByRejectionDateTime(@NotNull OffsetDateTime rejectionDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Voiding Date Time.
	 *
	 * @param voidingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Voiding Date Time
	 */
	List<PurchaseRequisitionEntity> findByVoidingDateTime(@NotNull OffsetDateTime voidingDateTime);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseRequisitionEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseRequisitionEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}