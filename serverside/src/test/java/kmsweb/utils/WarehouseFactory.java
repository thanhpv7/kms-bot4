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
import kmsweb.entities.WarehouseEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class WarehouseFactory implements FactoryBean<WarehouseEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public WarehouseEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public WarehouseEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public WarehouseEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for warehouseWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseWithNoRef before the main body here] end

		WarehouseEntity newEntity = new WarehouseEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Warehouse Number here] off begin
		String randomStringForWarehouseNumber = mockNeat
				.strings()
				.get();
		newEntity.setWarehouseNumber(randomStringForWarehouseNumber);
		// % protected region % [Add customisation for Warehouse Number here] end
		// % protected region % [Add customisation for Warehouse Name here] off begin
		String randomStringForWarehouseName = mockNeat
				.strings()
				.get();
		newEntity.setWarehouseName(randomStringForWarehouseName);
		// % protected region % [Add customisation for Warehouse Name here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringForDescription = mockNeat
				.strings()
				.size(2000)
				.get();
		newEntity.setDescription(randomStringForDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringForContactPerson = mockNeat
				.strings()
				.get();
		newEntity.setContactPerson(randomStringForContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Ext here] off begin
		String randomStringForExt = mockNeat
				.strings()
				.get();
		newEntity.setExt(randomStringForExt);
		// % protected region % [Add customisation for Ext here] end
		// % protected region % [Add customisation for Mobile Phone Number here] off begin
		String randomStringForMobilePhoneNumber = mockNeat
				.strings()
				.type(StringType.valueOf("NUMBERS"))
				.get();
		newEntity.setMobilePhoneNumber(randomStringForMobilePhoneNumber);
		// % protected region % [Add customisation for Mobile Phone Number here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.emails()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Revenue Center here] off begin
		String randomStringForRevenueCenter = mockNeat
				.strings()
				.get();
		newEntity.setRevenueCenter(randomStringForRevenueCenter);
		// % protected region % [Add customisation for Revenue Center here] end

		// % protected region % [Apply any additional logic for warehouseWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for warehouseWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances Warehouse here] off begin
			// Outgoing one to many reference
			var batchStockBalancesWarehouseFactory = new BatchStockBalanceFactory();
			newEntity.setBatchStockBalancesWarehouse(Collections.singletonList(batchStockBalancesWarehouseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Batch Stock Balances Warehouse here] end

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

			// % protected region % [Override the reference inclusion for outgoingOneToMany Destination Warehouses here] off begin
			// Outgoing one to many reference
			var destinationWarehousesFactory = new TransferOrderFactory();
			newEntity.setDestinationWarehouses(Collections.singletonList(destinationWarehousesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Destination Warehouses here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] off begin
			// Outgoing one to many reference
			var goodsReceiveNoteBatchsFactory = new GoodsReceiveNoteBatchFactory();
			newEntity.setGoodsReceiveNoteBatchs(Collections.singletonList(goodsReceiveNoteBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Note Batchs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Notes here] off begin
			// Outgoing one to many reference
			var goodsReceiveNotesFactory = new GoodsReceiveNoteFactory();
			newEntity.setGoodsReceiveNotes(Collections.singletonList(goodsReceiveNotesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Goods Receive Notes here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Internal Orders here] off begin
			// Outgoing one to many reference
			var internalOrdersFactory = new InternalOrderFactory();
			newEntity.setInternalOrders(Collections.singletonList(internalOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Internal Orders here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] off begin
			// Outgoing one to many reference
			var inventoryAdjusmentBatchsFactory = new InventoryAdjusmentBatchFactory();
			newEntity.setInventoryAdjusmentBatchs(Collections.singletonList(inventoryAdjusmentBatchsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjusment Batchs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjustments here] off begin
			// Outgoing one to many reference
			var inventoryAdjustmentsFactory = new InventoryAdjustmentFactory();
			newEntity.setInventoryAdjustments(Collections.singletonList(inventoryAdjustmentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Adjustments here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Corrections here] off begin
			// Outgoing one to many reference
			var inventoryBatchCorrectionsFactory = new InventoryBatchCorrectionFactory();
			newEntity.setInventoryBatchCorrections(Collections.singletonList(inventoryBatchCorrectionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Inventory Batch Corrections here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Locations here] off begin
			// Outgoing one to many reference
			var locationsFactory = new LocationFactory();
			newEntity.setLocations(Collections.singletonList(locationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Locations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fees here] off begin
			// Outgoing one to many reference
			var medicalFeesFactory = new MedicalFeeFactory();
			newEntity.setMedicalFees(Collections.singletonList(medicalFeesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fees here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] off begin
			// Outgoing one to many reference
			var medicationHeadersFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeaders(Collections.singletonList(medicationHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] off begin
			// Outgoing one to many reference
			var prescriptionHeadersFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescriptionHeaders(Collections.singletonList(prescriptionHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] off begin
			// Outgoing one to many reference
			var purchaseOrdersFactory = new PurchaseOrderFactory();
			newEntity.setPurchaseOrders(Collections.singletonList(purchaseOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Orders here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisitions here] off begin
			// Outgoing one to many reference
			var purchaseRequisitionsFactory = new PurchaseRequisitionFactory();
			newEntity.setPurchaseRequisitions(Collections.singletonList(purchaseRequisitionsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Purchase Requisitions here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacies here] off begin
			// Outgoing one to many reference
			var retailPharmaciesFactory = new RetailPharmacyFactory();
			newEntity.setRetailPharmacies(Collections.singletonList(retailPharmaciesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Retail Pharmacies here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Suppliers here] off begin
			// Outgoing one to many reference
			var returnSuppliersFactory = new ReturnSupplierFactory();
			newEntity.setReturnSuppliers(Collections.singletonList(returnSuppliersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Return Suppliers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Source Warehouses here] off begin
			// Outgoing one to many reference
			var sourceWarehousesFactory = new TransferOrderFactory();
			newEntity.setSourceWarehouses(Collections.singletonList(sourceWarehousesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Source Warehouses here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Catalogues here] off begin
			// Outgoing one to many reference
			var stockCataloguesFactory = new StockCatalogueFactory();
			newEntity.setStockCatalogues(Collections.singletonList(stockCataloguesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Stock Catalogues here] end

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

		// % protected region % [Apply any additional logic for warehouse with ref here] off begin
		// % protected region % [Apply any additional logic for warehouse with ref here] end

		return newEntity;
	}

	@Override
	public Class<WarehouseEntity> getObjectType() {
		return WarehouseEntity.class;
	}
}