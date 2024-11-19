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

import kmsweb.entities.JournalEntity;
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
public interface JournalRepository extends AbstractRepository<JournalEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Journal Number.
	 *
	 * @param journalNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Journal Number
	 */
	List<JournalEntity> findByJournalNumber(@NotNull String journalNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	List<JournalEntity> findByTransactionDate(@NotNull OffsetDateTime transactionDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	List<JournalEntity> findByReferenceNumber(@NotNull String referenceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Type.
	 *
	 * @param transactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Type
	 */
	List<JournalEntity> findByTransactionType(@NotNull String transactionType);
	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Detail Type.
	 *
	 * @param transactionDetailType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Detail Type
	 */
	List<JournalEntity> findByTransactionDetailType(@NotNull String transactionDetailType);
	/**
	 * Return an entity or a list of entities that have the given attribute Account Number.
	 *
	 * @param accountNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Account Number
	 */
	List<JournalEntity> findByAccountNumber(@NotNull String accountNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Debit.
	 *
	 * @param debit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Debit
	 */
	List<JournalEntity> findByDebit(@NotNull Double debit);
	/**
	 * Return an entity or a list of entities that have the given attribute Credit.
	 *
	 * @param credit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Credit
	 */
	List<JournalEntity> findByCredit(@NotNull Double credit);
	/**
	 * Return an entity or a list of entities that have the given attribute Posting Status.
	 *
	 * @param postingStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Posting Status
	 */
	List<JournalEntity> findByPostingStatus(@NotNull String postingStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Posting Date Time.
	 *
	 * @param postingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Posting Date Time
	 */
	List<JournalEntity> findByPostingDateTime(@NotNull OffsetDateTime postingDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Number.
	 *
	 * @param supplierNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Number
	 */
	List<JournalEntity> findBySupplierNumber(@NotNull String supplierNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Name.
	 *
	 * @param supplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Name
	 */
	List<JournalEntity> findBySupplierName(@NotNull String supplierName);
	/**
	 * Return an entity or a list of entities that have the given attribute Customer Number.
	 *
	 * @param customerNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Number
	 */
	List<JournalEntity> findByCustomerNumber(@NotNull String customerNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	List<JournalEntity> findByCustomerName(@NotNull String customerName);
	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	List<JournalEntity> findByRevenueCenter(@NotNull String revenueCenter);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<JournalEntity> findByDescription(@NotNull String description);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<JournalEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<JournalEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}