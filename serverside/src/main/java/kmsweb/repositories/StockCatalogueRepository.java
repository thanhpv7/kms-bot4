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

import kmsweb.entities.StockCatalogueEntity;
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
public interface StockCatalogueRepository extends AbstractRepository<StockCatalogueEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Trackable.
	 *
	 * @param trackable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trackable
	 */
	List<StockCatalogueEntity> findByTrackable(@NotNull Boolean trackable);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Code.
	 *
	 * @param stockCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Code
	 */
	Optional<StockCatalogueEntity> findByStockCode(@NotNull String stockCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Name.
	 *
	 * @param stockName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Name
	 */
	List<StockCatalogueEntity> findByStockName(@NotNull String stockName);
	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	List<StockCatalogueEntity> findByDescription(@NotNull String description);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight.
	 *
	 * @param weight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight
	 */
	List<StockCatalogueEntity> findByWeight(@NotNull Double weight);
	/**
	 * Return an entity or a list of entities that have the given attribute Weight Unit.
	 *
	 * @param weightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Unit
	 */
	List<StockCatalogueEntity> findByWeightUnit(@NotNull String weightUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Volume.
	 *
	 * @param volume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume
	 */
	List<StockCatalogueEntity> findByVolume(@NotNull Double volume);
	/**
	 * Return an entity or a list of entities that have the given attribute Volume Unit.
	 *
	 * @param volumeUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Volume Unit
	 */
	List<StockCatalogueEntity> findByVolumeUnit(@NotNull String volumeUnit);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Group.
	 *
	 * @param stockGroup the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Group
	 */
	List<StockCatalogueEntity> findByStockGroup(@NotNull String stockGroup);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category.
	 *
	 * @param stockCategory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category
	 */
	List<StockCatalogueEntity> findByStockCategory(@NotNull String stockCategory);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	List<StockCatalogueEntity> findByApprovalStatus(@NotNull String approvalStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Approved By.
	 *
	 * @param approvedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approved By
	 */
	List<StockCatalogueEntity> findByApprovedBy(@NotNull String approvedBy);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Date.
	 *
	 * @param approvalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Date
	 */
	List<StockCatalogueEntity> findByApprovalDate(@NotNull OffsetDateTime approvalDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Approval Notes.
	 *
	 * @param approvalNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Notes
	 */
	List<StockCatalogueEntity> findByApprovalNotes(@NotNull String approvalNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Per Pack.
	 *
	 * @param quantityPerPack the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Per Pack
	 */
	List<StockCatalogueEntity> findByQuantityPerPack(@NotNull Integer quantityPerPack);
	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	List<StockCatalogueEntity> findByUoi(@NotNull String uoi);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT exclude Currency.
	 *
	 * @param lastBuyingPriceVATExcludeCurrency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT exclude Currency
	 */
	List<StockCatalogueEntity> findByLastBuyingPriceVATExcludeCurrency(@NotNull String lastBuyingPriceVATExcludeCurrency);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT exclude Price.
	 *
	 * @param lastBuyingPriceVATExcludePrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT exclude Price
	 */
	List<StockCatalogueEntity> findByLastBuyingPriceVATExcludePrice(@NotNull Double lastBuyingPriceVATExcludePrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT include Currency.
	 *
	 * @param lastBuyingPriceVATIncludeCurrency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT include Currency
	 */
	List<StockCatalogueEntity> findByLastBuyingPriceVATIncludeCurrency(@NotNull String lastBuyingPriceVATIncludeCurrency);
	/**
	 * Return an entity or a list of entities that have the given attribute Last Buying Price VAT include Price.
	 *
	 * @param lastBuyingPriceVATIncludePrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Buying Price VAT include Price
	 */
	List<StockCatalogueEntity> findByLastBuyingPriceVATIncludePrice(@NotNull Double lastBuyingPriceVATIncludePrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Medical Type.
	 *
	 * @param medicalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Medical Type
	 */
	List<StockCatalogueEntity> findByMedicalType(@NotNull Boolean medicalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category VAT Excluded.
	 *
	 * @param stockCategoryVATExcluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category VAT Excluded
	 */
	List<StockCatalogueEntity> findByStockCategoryVATExcluded(@NotNull String stockCategoryVATExcluded);
	/**
	 * Return an entity or a list of entities that have the given attribute Stock Category VAT Included.
	 *
	 * @param stockCategoryVATIncluded the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stock Category VAT Included
	 */
	List<StockCatalogueEntity> findByStockCategoryVATIncluded(@NotNull String stockCategoryVATIncluded);
	/**
	 * Return an entity or a list of entities that have the given attribute On Hand Qty.
	 *
	 * @param onHandQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute On Hand Qty
	 */
	List<StockCatalogueEntity> findByOnHandQty(@NotNull Double onHandQty);
	/**
	 * Return an entity or a list of entities that have the given attribute Average Cost.
	 *
	 * @param averageCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Average Cost
	 */
	List<StockCatalogueEntity> findByAverageCost(@NotNull Double averageCost);
	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	List<StockCatalogueEntity> findByTotalCost(@NotNull Double totalCost);
	/**
	 * Return an entity or a list of entities that have the given attribute Sales Account.
	 *
	 * @param salesAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sales Account
	 */
	List<StockCatalogueEntity> findBySalesAccount(@NotNull String salesAccount);
	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Account.
	 *
	 * @param inventoryAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Account
	 */
	List<StockCatalogueEntity> findByInventoryAccount(@NotNull String inventoryAccount);
	/**
	 * Return an entity or a list of entities that have the given attribute Purchase Account.
	 *
	 * @param purchaseAccount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Account
	 */
	List<StockCatalogueEntity> findByPurchaseAccount(@NotNull String purchaseAccount);
	/**
	 * Return an entity or a list of entities that have the given attribute Lup Supplier Name.
	 *
	 * @param lupSupplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Supplier Name
	 */
	List<StockCatalogueEntity> findByLupSupplierName(@NotNull String lupSupplierName);
	/**
	 * Return an entity or a list of entities that have the given attribute Lup Unit Price.
	 *
	 * @param lupUnitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Unit Price
	 */
	List<StockCatalogueEntity> findByLupUnitPrice(@NotNull Double lupUnitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Lup Discount.
	 *
	 * @param lupDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Discount
	 */
	List<StockCatalogueEntity> findByLupDiscount(@NotNull Double lupDiscount);
	/**
	 * Return an entity or a list of entities that have the given attribute Lup Item Price.
	 *
	 * @param lupItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Item Price
	 */
	List<StockCatalogueEntity> findByLupItemPrice(@NotNull Double lupItemPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Lup Last Purchase Date.
	 *
	 * @param lupLastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lup Last Purchase Date
	 */
	List<StockCatalogueEntity> findByLupLastPurchaseDate(@NotNull OffsetDateTime lupLastPurchaseDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Supplier Name.
	 *
	 * @param lppSupplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Supplier Name
	 */
	List<StockCatalogueEntity> findByLppSupplierName(@NotNull String lppSupplierName);
	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Unit Price.
	 *
	 * @param lppUnitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Unit Price
	 */
	List<StockCatalogueEntity> findByLppUnitPrice(@NotNull Double lppUnitPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Discount.
	 *
	 * @param lppDiscount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Discount
	 */
	List<StockCatalogueEntity> findByLppDiscount(@NotNull Double lppDiscount);
	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Item Price.
	 *
	 * @param lppItemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Item Price
	 */
	List<StockCatalogueEntity> findByLppItemPrice(@NotNull Double lppItemPrice);
	/**
	 * Return an entity or a list of entities that have the given attribute Lpp Last Purchase Date.
	 *
	 * @param lppLastPurchaseDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lpp Last Purchase Date
	 */
	List<StockCatalogueEntity> findByLppLastPurchaseDate(@NotNull OffsetDateTime lppLastPurchaseDate);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockCatalogueEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<StockCatalogueEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}