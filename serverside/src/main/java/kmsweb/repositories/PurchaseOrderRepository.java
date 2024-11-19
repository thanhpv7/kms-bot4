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

import kmsweb.entities.PurchaseOrderEntity;
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
public interface PurchaseOrderRepository extends AbstractRepository<PurchaseOrderEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Type.
	 *
	 * @param purchaseOrderType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Type
	 */
	List<PurchaseOrderEntity> findByPurchaseOrderType(@NotNull String purchaseOrderType);
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Order Number.
	 *
	 * @param purchaseOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Order Number
	 */
	List<PurchaseOrderEntity> findByPurchaseOrderNumber(@NotNull String purchaseOrderNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute status
	 */
	List<PurchaseOrderEntity> findByStatus(@NotNull String status);
	/**
	 * Return an entity or a list of entities that have the given attribute Supply Stock Group.
	 *
	 * @param supplyStockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supply Stock Group
	 */
	List<PurchaseOrderEntity> findBySupplyStockGroup(@NotNull String supplyStockGroup);
	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	List<PurchaseOrderEntity> findByOrderDate(@NotNull OffsetDateTime orderDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Expected Date.
	 *
	 * @param expectedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expected Date
	 */
	List<PurchaseOrderEntity> findByExpectedDate(@NotNull OffsetDateTime expectedDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Price VAT Included.
	 *
	 * @param priceVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price VAT Included
	 */
	List<PurchaseOrderEntity> findByPriceVATIncluded(@NotNull Boolean priceVATIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory VAT Included.
	 *
	 * @param inventoryVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory VAT Included
	 */
	List<PurchaseOrderEntity> findByInventoryVATIncluded(@NotNull Boolean inventoryVATIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	List<PurchaseOrderEntity> findByReferenceDocument(@NotNull String referenceDocument);
	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Reference Document.
	 *
	 * @param supplierReferenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Reference Document
	 */
	List<PurchaseOrderEntity> findBySupplierReferenceDocument(@NotNull String supplierReferenceDocument);
	/**
	 * Return an entity or a list of entities that have the given attribute Payment Terms.
	 *
	 * @param paymentTerms the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Terms
	 */
	List<PurchaseOrderEntity> findByPaymentTerms(@NotNull String paymentTerms);
	/**
	 * Return an entity or a list of entities that have the given attribute Shipping Method.
	 *
	 * @param shippingMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shipping Method
	 */
	List<PurchaseOrderEntity> findByShippingMethod(@NotNull String shippingMethod);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<PurchaseOrderEntity> findByNotes(@NotNull String notes);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Total.
	 *
	 * @param subTotal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Total
	 */
	List<PurchaseOrderEntity> findBySubTotal(@NotNull Double subTotal);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount In Percent.
	 *
	 * @param extraDiscountInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount In Percent
	 */
	List<PurchaseOrderEntity> findByExtraDiscountInPercent(@NotNull Boolean extraDiscountInPercent);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Include Tax.
	 *
	 * @param extraDiscountIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Include Tax
	 */
	List<PurchaseOrderEntity> findByExtraDiscountIncludeTax(@NotNull Boolean extraDiscountIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Extra Discount Value.
	 *
	 * @param extraDiscountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Extra Discount Value
	 */
	List<PurchaseOrderEntity> findByExtraDiscountValue(@NotNull Double extraDiscountValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Include Tax.
	 *
	 * @param freightFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Include Tax
	 */
	List<PurchaseOrderEntity> findByFreightFeeIncludeTax(@NotNull Boolean freightFeeIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Freight Fee Value.
	 *
	 * @param freightFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Freight Fee Value
	 */
	List<PurchaseOrderEntity> findByFreightFeeValue(@NotNull Double freightFeeValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Include Tax.
	 *
	 * @param otherFeeIncludeTax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Include Tax
	 */
	List<PurchaseOrderEntity> findByOtherFeeIncludeTax(@NotNull Boolean otherFeeIncludeTax);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Fee Value.
	 *
	 * @param otherFeeValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Fee Value
	 */
	List<PurchaseOrderEntity> findByOtherFeeValue(@NotNull Double otherFeeValue);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Base.
	 *
	 * @param taxBase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Base
	 */
	List<PurchaseOrderEntity> findByTaxBase(@NotNull Double taxBase);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Amount.
	 *
	 * @param taxAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Amount
	 */
	List<PurchaseOrderEntity> findByTaxAmount(@NotNull Double taxAmount);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Amount.
	 *
	 * @param totalAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Amount
	 */
	List<PurchaseOrderEntity> findByTotalAmount(@NotNull Double totalAmount);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseOrderEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<PurchaseOrderEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}