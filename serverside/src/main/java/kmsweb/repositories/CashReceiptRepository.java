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

import kmsweb.entities.CashReceiptEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import kmsweb.entities.enums.*;
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
public interface CashReceiptRepository extends AbstractRepository<CashReceiptEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Receipt Type.
	 *
	 * @param receiptType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receipt Type
	 */
	List<CashReceiptEntity> findByReceiptType(@NotNull ReceiptTypeEnum receiptType);
	/**
	 * Return an entity or a list of entities that have the given attribute Receipt Number.
	 *
	 * @param receiptNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receipt Number
	 */
	List<CashReceiptEntity> findByReceiptNumber(@NotNull String receiptNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Date.
	 *
	 * @param paymentDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Date
	 */
	List<CashReceiptEntity> findByPaymentDate(@NotNull OffsetDateTime paymentDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<CashReceiptEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Type.
	 *
	 * @param paymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Type
	 */
	List<CashReceiptEntity> findByPaymentType(@NotNull String paymentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Receive Amount.
	 *
	 * @param receiveAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Receive Amount
	 */
	List<CashReceiptEntity> findByReceiveAmount(@NotNull Double receiveAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute IsVoid.
	 *
	 * @param isvoid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IsVoid
	 */
	List<CashReceiptEntity> findByIsvoid(@NotNull Boolean isvoid);
	/**
	 * Return an entity or a list of entities that have the given attribute Cashier Location.
	 *
	 * @param cashierLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cashier Location
	 */
	List<CashReceiptEntity> findByCashierLocation(@NotNull String cashierLocation);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date Time.
	 *
	 * @param voidDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date Time
	 */
	List<CashReceiptEntity> findByVoidDateTime(@NotNull OffsetDateTime voidDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Cash Change Type.
	 *
	 * @param cashChangeType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cash Change Type
	 */
	List<CashReceiptEntity> findByCashChangeType(@NotNull CashChangeTypeEnum cashChangeType);
	/**
	 * Return an entity or a list of entities that have the given attribute Change Amount.
	 *
	 * @param changeAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Change Amount
	 */
	List<CashReceiptEntity> findByChangeAmount(@NotNull Double changeAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Allocated Amount.
	 *
	 * @param allocatedAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Allocated Amount
	 */
	List<CashReceiptEntity> findByAllocatedAmount(@NotNull Double allocatedAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Rounding Amount.
	 *
	 * @param roundingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rounding Amount
	 */
	List<CashReceiptEntity> findByRoundingAmount(@NotNull Double roundingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Available Amount.
	 *
	 * @param availableAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Amount
	 */
	List<CashReceiptEntity> findByAvailableAmount(@NotNull Double availableAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Bank Name.
	 *
	 * @param bankName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bank Name
	 */
	List<CashReceiptEntity> findByBankName(@NotNull String bankName);
	/**
	 * Return an entity or a list of entities that have the given attribute Card Type.
	 *
	 * @param cardType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Type
	 */
	List<CashReceiptEntity> findByCardType(@NotNull String cardType);
	/**
	 * Return an entity or a list of entities that have the given attribute Card No.
	 *
	 * @param cardNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card No
	 */
	List<CashReceiptEntity> findByCardNo(@NotNull String cardNo);
	/**
	 * Return an entity or a list of entities that have the given attribute Card Holder.
	 *
	 * @param cardHolder the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Card Holder
	 */
	List<CashReceiptEntity> findByCardHolder(@NotNull String cardHolder);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	List<CashReceiptEntity> findByReferenceNumber(@NotNull String referenceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Bank Account.
	 *
	 * @param hospitalBankAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Bank Account
	 */
	List<CashReceiptEntity> findByHospitalBankAccount(@NotNull String hospitalBankAccount);
	/**
	 * Return an entity or a list of entities that have the given attribute Surcharge Amount.
	 *
	 * @param surchargeAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Surcharge Amount
	 */
	List<CashReceiptEntity> findBySurchargeAmount(@NotNull Double surchargeAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	List<CashReceiptEntity> findByOutstandingAmount(@NotNull Double outstandingAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Received From.
	 *
	 * @param receivedFrom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Received From
	 */
	List<CashReceiptEntity> findByReceivedFrom(@NotNull String receivedFrom);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashReceiptEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashReceiptEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}