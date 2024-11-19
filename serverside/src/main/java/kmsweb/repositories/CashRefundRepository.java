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

import kmsweb.entities.CashRefundEntity;
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
public interface CashRefundRepository extends AbstractRepository<CashRefundEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Refund Number.
	 *
	 * @param refundNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Refund Number
	 */
	List<CashRefundEntity> findByRefundNumber(@NotNull String refundNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Refund Date.
	 *
	 * @param refundDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Refund Date
	 */
	List<CashRefundEntity> findByRefundDate(@NotNull OffsetDateTime refundDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<CashRefundEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute Cashier Location.
	 *
	 * @param cashierLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cashier Location
	 */
	List<CashRefundEntity> findByCashierLocation(@NotNull String cashierLocation);
	/**
	 * Return an entity or a list of entities that have the given attribute IsVoid.
	 *
	 * @param isvoid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IsVoid
	 */
	List<CashRefundEntity> findByIsvoid(@NotNull Boolean isvoid);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date Time.
	 *
	 * @param voidDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date Time
	 */
	List<CashRefundEntity> findByVoidDateTime(@NotNull OffsetDateTime voidDateTime);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Type.
	 *
	 * @param paymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Type
	 */
	List<CashRefundEntity> findByPaymentType(@NotNull String paymentType);
	/**
	 * Return an entity or a list of entities that have the given attribute Refund Amount.
	 *
	 * @param refundAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Refund Amount
	 */
	List<CashRefundEntity> findByRefundAmount(@NotNull Double refundAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Bank Account.
	 *
	 * @param hospitalBankAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Bank Account
	 */
	List<CashRefundEntity> findByHospitalBankAccount(@NotNull String hospitalBankAccount);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	List<CashRefundEntity> findByReferenceNumber(@NotNull String referenceNumber);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashRefundEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<CashRefundEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}