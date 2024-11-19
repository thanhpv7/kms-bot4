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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.StockCatalogueEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class StockCatalogueFactory implements FactoryBean<StockCatalogueEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public StockCatalogueEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public StockCatalogueEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public StockCatalogueEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef before the main body here] end

		StockCatalogueEntity newEntity = new StockCatalogueEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Trackable here] off begin
		newEntity.setTrackable(mockNeat.bools().get());
		// % protected region % [Add customisation for Trackable here] end
		// % protected region % [Add customisation for Stock Code here] off begin
		String randomStringForStockCode = mockNeat
				.strings()
				.get();
		newEntity.setStockCode(randomStringForStockCode);
		// % protected region % [Add customisation for Stock Code here] end
		// % protected region % [Add customisation for Stock Name here] off begin
		String randomStringForStockName = mockNeat
				.strings()
				.get();
		newEntity.setStockName(randomStringForStockName);
		// % protected region % [Add customisation for Stock Name here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Unit here] off begin
		String randomStringForWeightUnit = mockNeat
				.strings()
				.get();
		newEntity.setWeightUnit(randomStringForWeightUnit);
		// % protected region % [Add customisation for Weight Unit here] end
		// % protected region % [Add customisation for Volume here] off begin
		newEntity.setVolume(mockNeat.doubles().get());
		// % protected region % [Add customisation for Volume here] end
		// % protected region % [Add customisation for Volume Unit here] off begin
		String randomStringForVolumeUnit = mockNeat
				.strings()
				.get();
		newEntity.setVolumeUnit(randomStringForVolumeUnit);
		// % protected region % [Add customisation for Volume Unit here] end
		// % protected region % [Add customisation for Stock Group here] off begin
		String randomStringForStockGroup = mockNeat
				.strings()
				.get();
		newEntity.setStockGroup(randomStringForStockGroup);
		// % protected region % [Add customisation for Stock Group here] end
		// % protected region % [Add customisation for Stock Category here] off begin
		String randomStringForStockCategory = mockNeat
				.strings()
				.get();
		newEntity.setStockCategory(randomStringForStockCategory);
		// % protected region % [Add customisation for Stock Category here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringForApprovalStatus = mockNeat
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringForApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Approved By here] off begin
		String randomStringForApprovedBy = mockNeat
				.strings()
				.get();
		newEntity.setApprovedBy(randomStringForApprovedBy);
		// % protected region % [Add customisation for Approved By here] end
		// % protected region % [Add customisation for Approval Date here] off begin
		newEntity.setApprovalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approval Date here] end
		// % protected region % [Add customisation for Approval Notes here] off begin
		String randomStringForApprovalNotes = mockNeat
				.strings()
				.get();
		newEntity.setApprovalNotes(randomStringForApprovalNotes);
		// % protected region % [Add customisation for Approval Notes here] end
		// % protected region % [Add customisation for Quantity Per Pack here] off begin
		newEntity.setQuantityPerPack(mockNeat.ints().get());
		// % protected region % [Add customisation for Quantity Per Pack here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringForUoi = mockNeat
				.strings()
				.get();
		newEntity.setUoi(randomStringForUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Last Buying Price VAT exclude Currency here] off begin
		String randomStringForLastBuyingPriceVATExcludeCurrency = mockNeat
				.strings()
				.get();
		newEntity.setLastBuyingPriceVATExcludeCurrency(randomStringForLastBuyingPriceVATExcludeCurrency);
		// % protected region % [Add customisation for Last Buying Price VAT exclude Currency here] end
		// % protected region % [Add customisation for Last Buying Price VAT exclude Price here] off begin
		newEntity.setLastBuyingPriceVATExcludePrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Last Buying Price VAT exclude Price here] end
		// % protected region % [Add customisation for Last Buying Price VAT include Currency here] off begin
		String randomStringForLastBuyingPriceVATIncludeCurrency = mockNeat
				.strings()
				.get();
		newEntity.setLastBuyingPriceVATIncludeCurrency(randomStringForLastBuyingPriceVATIncludeCurrency);
		// % protected region % [Add customisation for Last Buying Price VAT include Currency here] end
		// % protected region % [Add customisation for Last Buying Price VAT include Price here] off begin
		newEntity.setLastBuyingPriceVATIncludePrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Last Buying Price VAT include Price here] end
		// % protected region % [Add customisation for Medical Type here] off begin
		newEntity.setMedicalType(mockNeat.bools().get());
		// % protected region % [Add customisation for Medical Type here] end
		// % protected region % [Add customisation for Stock Category VAT Excluded here] off begin
		String randomStringForStockCategoryVATExcluded = mockNeat
				.strings()
				.get();
		newEntity.setStockCategoryVATExcluded(randomStringForStockCategoryVATExcluded);
		// % protected region % [Add customisation for Stock Category VAT Excluded here] end
		// % protected region % [Add customisation for Stock Category VAT Included here] off begin
		String randomStringForStockCategoryVATIncluded = mockNeat
				.strings()
				.get();
		newEntity.setStockCategoryVATIncluded(randomStringForStockCategoryVATIncluded);
		// % protected region % [Add customisation for Stock Category VAT Included here] end
		// % protected region % [Add customisation for On Hand Qty here] off begin
		newEntity.setOnHandQty(mockNeat.doubles().get());
		// % protected region % [Add customisation for On Hand Qty here] end
		// % protected region % [Add customisation for Average Cost here] off begin
		newEntity.setAverageCost(mockNeat.doubles().get());
		// % protected region % [Add customisation for Average Cost here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Sales Account here] off begin
		String randomStringForSalesAccount = mockNeat
				.strings()
				.get();
		newEntity.setSalesAccount(randomStringForSalesAccount);
		// % protected region % [Add customisation for Sales Account here] end
		// % protected region % [Add customisation for Inventory Account here] off begin
		String randomStringForInventoryAccount = mockNeat
				.strings()
				.get();
		newEntity.setInventoryAccount(randomStringForInventoryAccount);
		// % protected region % [Add customisation for Inventory Account here] end
		// % protected region % [Add customisation for Purchase Account here] off begin
		String randomStringForPurchaseAccount = mockNeat
				.strings()
				.get();
		newEntity.setPurchaseAccount(randomStringForPurchaseAccount);
		// % protected region % [Add customisation for Purchase Account here] end
		// % protected region % [Add customisation for Lup Supplier Name here] off begin
		String randomStringForLupSupplierName = mockNeat
				.strings()
				.get();
		newEntity.setLupSupplierName(randomStringForLupSupplierName);
		// % protected region % [Add customisation for Lup Supplier Name here] end
		// % protected region % [Add customisation for Lup Unit Price here] off begin
		newEntity.setLupUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lup Unit Price here] end
		// % protected region % [Add customisation for Lup Discount here] off begin
		newEntity.setLupDiscount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lup Discount here] end
		// % protected region % [Add customisation for Lup Item Price here] off begin
		newEntity.setLupItemPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lup Item Price here] end
		// % protected region % [Add customisation for Lup Last Purchase Date here] off begin
		newEntity.setLupLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Lup Last Purchase Date here] end
		// % protected region % [Add customisation for Lpp Supplier Name here] off begin
		String randomStringForLppSupplierName = mockNeat
				.strings()
				.get();
		newEntity.setLppSupplierName(randomStringForLppSupplierName);
		// % protected region % [Add customisation for Lpp Supplier Name here] end
		// % protected region % [Add customisation for Lpp Unit Price here] off begin
		newEntity.setLppUnitPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lpp Unit Price here] end
		// % protected region % [Add customisation for Lpp Discount here] off begin
		newEntity.setLppDiscount(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lpp Discount here] end
		// % protected region % [Add customisation for Lpp Item Price here] off begin
		newEntity.setLppItemPrice(mockNeat.doubles().get());
		// % protected region % [Add customisation for Lpp Item Price here] end
		// % protected region % [Add customisation for Lpp Last Purchase Date here] off begin
		newEntity.setLppLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Lpp Last Purchase Date here] end

		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Drug Generic PRB here] off begin
			// Incoming One to One reference
			var bpjsDrugGenericPRBFactory = new BpjsDrugGenericPRBFactory();
			newEntity.setBpjsDrugGenericPRB(bpjsDrugGenericPRBFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Drug Generic PRB here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Pcare DPHO here] off begin
			// Incoming One to One reference
			var bpjsPcareDPHOFactory = new BpjsPcareDPHOFactory();
			newEntity.setBpjsPcareDPHO(bpjsPcareDPHOFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne BPJS Pcare DPHO here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Stock Catalogue Medical ] off begin
			// Outgoing one to one reference
			var stockCatalogueMedicalFactory = new CatalogueMedicalFactory();
			newEntity.setStockCatalogueMedical(stockCatalogueMedicalFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Stock Catalogue Medical ] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Stock Catalogue Non Medical] off begin
			// Outgoing one to one reference
			var stockCatalogueNonMedicalFactory = new CatalogueNonMedicalFactory();
			newEntity.setStockCatalogueNonMedical(stockCatalogueNonMedicalFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Stock Catalogue Non Medical] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] off begin
			var warehouseFactory = new WarehouseFactory();
			newEntity.setWarehouse(warehouseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyWarehouse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances Catalogue here] off begin
			// Outgoing one to many reference
			var batchStockBalancesCatalogueFactory = new BatchStockBalanceFactory();
			newEntity.setBatchStockBalancesCatalogue(Collections.singletonList(batchStockBalancesCatalogueFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances Catalogue here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances here] off begin
			// Outgoing one to many reference
			var batchStockBalancesFactory = new BatchStockBalancePerDateFactory();
			newEntity.setBatchStockBalances(Collections.singletonList(batchStockBalancesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Transaction Details here] off begin
			// Outgoing one to many reference
			var batchStockTransactionDetailsFactory = new BatchStockTransactionDetailFactory();
			newEntity.setBatchStockTransactionDetails(Collections.singletonList(batchStockTransactionDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Transaction Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Catalogue UOMs here] off begin
			// Outgoing one to many reference
			var catalogueUOMsFactory = new CatalogueUOMFactory();
			newEntity.setCatalogueUOMs(Collections.singletonList(catalogueUOMsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Catalogue UOMs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Items here] off begin
			// Outgoing one to many reference
			var compoundPrescriptionItemsFactory = new CompoundPrescriptionItemFactory();
			newEntity.setCompoundPrescriptionItems(Collections.singletonList(compoundPrescriptionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Compound Prescription Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteBatchsFactory = new GoodsReceiveNoteBatchFactory();
			newEntity.setGoodsReceiveNoteBatchs(Collections.singletonList(goodsReceiveNoteBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteItemsFactory = new GoodsReceiveNoteItemFactory();
			newEntity.setGoodsReceiveNoteItems(Collections.singletonList(goodsReceiveNoteItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Internal Order Stock Details here] off begin
			// Outgoing one to many reference
			var internalOrderStockDetailsFactory = new InternalOrderStockDetailFactory();
			newEntity.setInternalOrderStockDetails(Collections.singletonList(internalOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Internal Order Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] off begin
			// Outgoing one to many reference
			var inventoryAdjusmentBatchsFactory = new InventoryAdjusmentBatchFactory();
			newEntity.setInventoryAdjusmentBatchs(Collections.singletonList(inventoryAdjusmentBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjustment Items here] off begin
			// Outgoing one to many reference
			var inventoryAdjustmentItemsFactory = new InventoryAdjustmentItemFactory();
			newEntity.setInventoryAdjustmentItems(Collections.singletonList(inventoryAdjustmentItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjustment Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Correction Items here] off begin
			// Outgoing one to many reference
			var inventoryBatchCorrectionItemsFactory = new InventoryBatchCorrectionItemFactory();
			newEntity.setInventoryBatchCorrectionItems(Collections.singletonList(inventoryBatchCorrectionItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Correction Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Items here] off begin
			// Outgoing one to many reference
			var medicationItemsFactory = new MedicationItemFactory();
			newEntity.setMedicationItems(Collections.singletonList(medicationItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Item here] off begin
			// Outgoing one to many reference
			var prescriptionItemFactory = new PrescriptionItemFactory();
			newEntity.setPrescriptionItem(Collections.singletonList(prescriptionItemFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Item here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Order Stock Details here] off begin
			// Outgoing one to many reference
			var purchaseOrderStockDetailsFactory = new PurchaseOrderStockDetailFactory();
			newEntity.setPurchaseOrderStockDetails(Collections.singletonList(purchaseOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Order Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisition Stock Details here] off begin
			// Outgoing one to many reference
			var purchaseRequisitionStockDetailsFactory = new PurchaseRequisitionStockDetailFactory();
			newEntity.setPurchaseRequisitionStockDetails(Collections.singletonList(purchaseRequisitionStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisition Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Stock Details here] off begin
			// Outgoing one to many reference
			var retailPharmacyStockDetailsFactory = new RetailPharmacyStockDetailFactory();
			newEntity.setRetailPharmacyStockDetails(Collections.singletonList(retailPharmacyStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacy Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Supplier Stock Details here] off begin
			// Outgoing one to many reference
			var returnSupplierStockDetailsFactory = new ReturnSupplierStockDetailFactory();
			newEntity.setReturnSupplierStockDetails(Collections.singletonList(returnSupplierStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Supplier Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Controls here] off begin
			// Outgoing one to many reference
			var stockControlsFactory = new StockControlFactory();
			newEntity.setStockControls(Collections.singletonList(stockControlsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Controls here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Details here] off begin
			// Outgoing one to many reference
			var stockTransactionDetailsFactory = new StockTransactionDetailFactory();
			newEntity.setStockTransactionDetails(Collections.singletonList(stockTransactionDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Per Date Types here] off begin
			// Outgoing one to many reference
			var stockTransactionPerDateTypesFactory = new StockTransactionPerDateTypeFactory();
			newEntity.setStockTransactionPerDateTypes(Collections.singletonList(stockTransactionPerDateTypesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Per Date Types here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Per Dates here] off begin
			// Outgoing one to many reference
			var stockTransactionPerDatesFactory = new StockTransactionPerDateFactory();
			newEntity.setStockTransactionPerDates(Collections.singletonList(stockTransactionPerDatesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Transaction Per Dates here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Product Details here] off begin
			// Outgoing one to many reference
			var supplierProductDetailsFactory = new SupplierProductDetailFactory();
			newEntity.setSupplierProductDetails(Collections.singletonList(supplierProductDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Supplier Product Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] off begin
			// Outgoing one to many reference
			var transferOrderStockDetailsFactory = new TransferOrderStockDetailFactory();
			newEntity.setTransferOrderStockDetails(Collections.singletonList(transferOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Order Details here] off begin
			// Outgoing one to many reference
			var vaccinationOrderDetailsFactory = new VaccinationOrderDetailFactory();
			newEntity.setVaccinationOrderDetails(Collections.singletonList(vaccinationOrderDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Order Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Initial Stock s here] off begin
			// Outgoing one to many reference
			var warehouseInitialStockSFactory = new WarehouseInitialStockFactory();
			newEntity.setWarehouseInitialStockS(Collections.singletonList(warehouseInitialStockSFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Initial Stock s here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Inventories here] off begin
			// Outgoing one to many reference
			var warehouseInventoriesFactory = new WarehouseInventoryFactory();
			newEntity.setWarehouseInventories(Collections.singletonList(warehouseInventoriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Warehouse Inventories here] end

		}

		// % protected region % [Apply any additional logic for stockCatalogue with ref here] off begin
		// % protected region % [Apply any additional logic for stockCatalogue with ref here] end

		return newEntity;
	}

	@Override
	public Class<StockCatalogueEntity> getObjectType() {
		return StockCatalogueEntity.class;
	}
}