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

import kmsweb.entities.ReturnSupplierEntity;
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
public interface ReturnSupplierRepository extends AbstractRepository<ReturnSupplierEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Return Number.
	 *
	 * @param returnNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Return Number
	 */
	List<ReturnSupplierEntity> findByReturnNumber(@NotNull String returnNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<ReturnSupplierEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Return Date.
	 *
	 * @param returnDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Return Date
	 */
	List<ReturnSupplierEntity> findByReturnDate(@NotNull OffsetDateTime returnDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	List<ReturnSupplierEntity> findByOrderDate(@NotNull OffsetDateTime orderDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<ReturnSupplierEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Return Number.
	 *
	 * @param invoiceReturnNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Return Number
	 */
	List<ReturnSupplierEntity> findByInvoiceReturnNumber(@NotNull String invoiceReturnNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Invoice Number.
	 *
	 * @param taxInvoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Invoice Number
	 */
	List<ReturnSupplierEntity> findByTaxInvoiceNumber(@NotNull String taxInvoiceNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Price VAT Included.
	 *
	 * @param priceVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price VAT Included
	 */
	List<ReturnSupplierEntity> findByPriceVATIncluded(@NotNull Boolean priceVATIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	List<ReturnSupplierEntity> findByVoidDate(@NotNull OffsetDateTime voidDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Void Reason.
	 *
	 * @param voidReason the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Reason
	 */
	List<ReturnSupplierEntity> findByVoidReason(@NotNull String voidReason);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	List<ReturnSupplierEntity> findBySubTotal(@NotNull Double subTotal);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount In Percentage.
	 *
	 * @param extraDiscountInPercentage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount In Percentage
	 */
	List<ReturnSupplierEntity> findByExtraDiscountInPercentage(@NotNull Boolean extraDiscountInPercentage);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Include Tax.
	 *
	 * @param extraDiscountIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Include Tax
	 */
	List<ReturnSupplierEntity> findByExtraDiscountIncludeTax(@NotNull Boolean extraDiscountIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Value.
	 *
	 * @param extraDiscountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Value
	 */
	List<ReturnSupplierEntity> findByExtraDiscountValue(@NotNull Double extraDiscountValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Include Tax.
	 *
	 * @param freightFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Include Tax
	 */
	List<ReturnSupplierEntity> findByFreightFeeIncludeTax(@NotNull Boolean freightFeeIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Value.
	 *
	 * @param freightFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Value
	 */
	List<ReturnSupplierEntity> findByFreightFeeValue(@NotNull Double freightFeeValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Include Tax.
	 *
	 * @param otherFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Include Tax
	 */
	List<ReturnSupplierEntity> findByOtherFeeIncludeTax(@NotNull Boolean otherFeeIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Value.
	 *
	 * @param otherFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Value
	 */
	List<ReturnSupplierEntity> findByOtherFeeValue(@NotNull Double otherFeeValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Base.
	 *
	 * @param taxBase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Base
	 */
	List<ReturnSupplierEntity> findByTaxBase(@NotNull Double taxBase);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Amount.
	 *
	 * @param taxAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Amount
	 */
	List<ReturnSupplierEntity> findByTaxAmount(@NotNull Double taxAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Amount.
	 *
	 * @param totalAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Amount
	 */
	List<ReturnSupplierEntity> findByTotalAmount(@NotNull Double totalAmount);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ReturnSupplierEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<ReturnSupplierEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}