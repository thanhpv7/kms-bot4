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

import kmsweb.entities.TransferOrderEntity;
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
public interface TransferOrderRepository extends AbstractRepository<TransferOrderEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Transfer Order Number.
	 *
	 * @param transferOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transfer Order Number
	 */
	List<TransferOrderEntity> findByTransferOrderNumber(@NotNull String transferOrderNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	List<TransferOrderEntity> findByTransactionStatus(@NotNull String transactionStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<TransferOrderEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	List<TransferOrderEntity> findByOrderDate(@NotNull OffsetDateTime orderDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Expected Date.
	 *
	 * @param expectedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expected Date
	 */
	List<TransferOrderEntity> findByExpectedDate(@NotNull OffsetDateTime expectedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	List<TransferOrderEntity> findByReferenceNumber(@NotNull String referenceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<TransferOrderEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	List<TransferOrderEntity> findByVoidDate(@NotNull OffsetDateTime voidDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	List<TransferOrderEntity> findByReferenceDocument(@NotNull String referenceDocument);
	/**
	 * Return an entity or a list of entities that have the given attribute Required Date.
	 *
	 * @param requiredDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Required Date
	 */
	List<TransferOrderEntity> findByRequiredDate(@NotNull OffsetDateTime requiredDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Issued Date Time.
	 *
	 * @param issuedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Date Time
	 */
	List<TransferOrderEntity> findByIssuedDateTime(@NotNull OffsetDateTime issuedDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Received Date Time.
	 *
	 * @param receivedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Received Date Time
	 */
	List<TransferOrderEntity> findByReceivedDateTime(@NotNull OffsetDateTime receivedDateTime);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TransferOrderEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<TransferOrderEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}