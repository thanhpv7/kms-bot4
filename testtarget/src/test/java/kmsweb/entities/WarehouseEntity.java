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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class WarehouseEntity extends AbstractEntity {

	public WarehouseEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BatchStockBalancesWarehouseOneMany = new EntityReference();
			BatchStockBalancesWarehouseOneMany.entityName = "BatchStockBalance";
			BatchStockBalancesWarehouseOneMany.oppositeName = "Warehouse";
			BatchStockBalancesWarehouseOneMany.name = "BatchStockBalancesWarehouse";
			BatchStockBalancesWarehouseOneMany.optional = true;
			BatchStockBalancesWarehouseOneMany.type = "One";
			BatchStockBalancesWarehouseOneMany.oppositeType = "Many";

		References.add(BatchStockBalancesWarehouseOneMany);

		var BatchStockBalancesOneMany = new EntityReference();
			BatchStockBalancesOneMany.entityName = "BatchStockBalancePerDate";
			BatchStockBalancesOneMany.oppositeName = "Warehouse";
			BatchStockBalancesOneMany.name = "BatchStockBalances";
			BatchStockBalancesOneMany.optional = true;
			BatchStockBalancesOneMany.type = "One";
			BatchStockBalancesOneMany.oppositeType = "Many";

		References.add(BatchStockBalancesOneMany);

		var BatchStockTransactionDetailsOneMany = new EntityReference();
			BatchStockTransactionDetailsOneMany.entityName = "BatchStockTransactionDetail";
			BatchStockTransactionDetailsOneMany.oppositeName = "Warehouse";
			BatchStockTransactionDetailsOneMany.name = "BatchStockTransactionDetails";
			BatchStockTransactionDetailsOneMany.optional = true;
			BatchStockTransactionDetailsOneMany.type = "One";
			BatchStockTransactionDetailsOneMany.oppositeType = "Many";

		References.add(BatchStockTransactionDetailsOneMany);

		var DestinationWarehousesOneMany = new EntityReference();
			DestinationWarehousesOneMany.entityName = "TransferOrder";
			DestinationWarehousesOneMany.oppositeName = "DestinationWarehouse";
			DestinationWarehousesOneMany.name = "DestinationWarehouses";
			DestinationWarehousesOneMany.optional = true;
			DestinationWarehousesOneMany.type = "One";
			DestinationWarehousesOneMany.oppositeType = "Many";

		References.add(DestinationWarehousesOneMany);

		var GoodsReceiveNoteBatchsOneMany = new EntityReference();
			GoodsReceiveNoteBatchsOneMany.entityName = "GoodsReceiveNoteBatch";
			GoodsReceiveNoteBatchsOneMany.oppositeName = "Warehouse";
			GoodsReceiveNoteBatchsOneMany.name = "GoodsReceiveNoteBatchs";
			GoodsReceiveNoteBatchsOneMany.optional = true;
			GoodsReceiveNoteBatchsOneMany.type = "One";
			GoodsReceiveNoteBatchsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteBatchsOneMany);

		var GoodsReceiveNotesOneMany = new EntityReference();
			GoodsReceiveNotesOneMany.entityName = "GoodsReceiveNote";
			GoodsReceiveNotesOneMany.oppositeName = "Warehouse";
			GoodsReceiveNotesOneMany.name = "GoodsReceiveNotes";
			GoodsReceiveNotesOneMany.optional = true;
			GoodsReceiveNotesOneMany.type = "One";
			GoodsReceiveNotesOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNotesOneMany);

		var InternalOrdersOneMany = new EntityReference();
			InternalOrdersOneMany.entityName = "InternalOrder";
			InternalOrdersOneMany.oppositeName = "Warehouse";
			InternalOrdersOneMany.name = "InternalOrders";
			InternalOrdersOneMany.optional = true;
			InternalOrdersOneMany.type = "One";
			InternalOrdersOneMany.oppositeType = "Many";

		References.add(InternalOrdersOneMany);

		var InventoryAdjusmentBatchsOneMany = new EntityReference();
			InventoryAdjusmentBatchsOneMany.entityName = "InventoryAdjusmentBatch";
			InventoryAdjusmentBatchsOneMany.oppositeName = "Warehouse";
			InventoryAdjusmentBatchsOneMany.name = "InventoryAdjusmentBatchs";
			InventoryAdjusmentBatchsOneMany.optional = true;
			InventoryAdjusmentBatchsOneMany.type = "One";
			InventoryAdjusmentBatchsOneMany.oppositeType = "Many";

		References.add(InventoryAdjusmentBatchsOneMany);

		var InventoryAdjustmentsOneMany = new EntityReference();
			InventoryAdjustmentsOneMany.entityName = "InventoryAdjustment";
			InventoryAdjustmentsOneMany.oppositeName = "Warehouse";
			InventoryAdjustmentsOneMany.name = "InventoryAdjustments";
			InventoryAdjustmentsOneMany.optional = true;
			InventoryAdjustmentsOneMany.type = "One";
			InventoryAdjustmentsOneMany.oppositeType = "Many";

		References.add(InventoryAdjustmentsOneMany);

		var InventoryBatchCorrectionsOneMany = new EntityReference();
			InventoryBatchCorrectionsOneMany.entityName = "InventoryBatchCorrection";
			InventoryBatchCorrectionsOneMany.oppositeName = "Warehouse";
			InventoryBatchCorrectionsOneMany.name = "InventoryBatchCorrections";
			InventoryBatchCorrectionsOneMany.optional = true;
			InventoryBatchCorrectionsOneMany.type = "One";
			InventoryBatchCorrectionsOneMany.oppositeType = "Many";

		References.add(InventoryBatchCorrectionsOneMany);

		var LocationsOneMany = new EntityReference();
			LocationsOneMany.entityName = "Location";
			LocationsOneMany.oppositeName = "Warehouse";
			LocationsOneMany.name = "Locations";
			LocationsOneMany.optional = true;
			LocationsOneMany.type = "One";
			LocationsOneMany.oppositeType = "Many";

		References.add(LocationsOneMany);

		var MedicalFeesOneMany = new EntityReference();
			MedicalFeesOneMany.entityName = "MedicalFee";
			MedicalFeesOneMany.oppositeName = "Warehouse";
			MedicalFeesOneMany.name = "MedicalFees";
			MedicalFeesOneMany.optional = true;
			MedicalFeesOneMany.type = "One";
			MedicalFeesOneMany.oppositeType = "Many";

		References.add(MedicalFeesOneMany);

		var MedicationHeadersOneMany = new EntityReference();
			MedicationHeadersOneMany.entityName = "MedicationHeader";
			MedicationHeadersOneMany.oppositeName = "Warehouse";
			MedicationHeadersOneMany.name = "MedicationHeaders";
			MedicationHeadersOneMany.optional = true;
			MedicationHeadersOneMany.type = "One";
			MedicationHeadersOneMany.oppositeType = "Many";

		References.add(MedicationHeadersOneMany);

		var PrescriptionHeadersOneMany = new EntityReference();
			PrescriptionHeadersOneMany.entityName = "PrescriptionHeader";
			PrescriptionHeadersOneMany.oppositeName = "Warehouse";
			PrescriptionHeadersOneMany.name = "PrescriptionHeaders";
			PrescriptionHeadersOneMany.optional = true;
			PrescriptionHeadersOneMany.type = "One";
			PrescriptionHeadersOneMany.oppositeType = "Many";

		References.add(PrescriptionHeadersOneMany);

		var PurchaseOrdersOneMany = new EntityReference();
			PurchaseOrdersOneMany.entityName = "PurchaseOrder";
			PurchaseOrdersOneMany.oppositeName = "Warehouse";
			PurchaseOrdersOneMany.name = "PurchaseOrders";
			PurchaseOrdersOneMany.optional = true;
			PurchaseOrdersOneMany.type = "One";
			PurchaseOrdersOneMany.oppositeType = "Many";

		References.add(PurchaseOrdersOneMany);

		var PurchaseRequisitionsOneMany = new EntityReference();
			PurchaseRequisitionsOneMany.entityName = "PurchaseRequisition";
			PurchaseRequisitionsOneMany.oppositeName = "Warehouse";
			PurchaseRequisitionsOneMany.name = "PurchaseRequisitions";
			PurchaseRequisitionsOneMany.optional = true;
			PurchaseRequisitionsOneMany.type = "One";
			PurchaseRequisitionsOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionsOneMany);

		var RetailPharmaciesOneMany = new EntityReference();
			RetailPharmaciesOneMany.entityName = "RetailPharmacy";
			RetailPharmaciesOneMany.oppositeName = "Warehouse";
			RetailPharmaciesOneMany.name = "RetailPharmacies";
			RetailPharmaciesOneMany.optional = true;
			RetailPharmaciesOneMany.type = "One";
			RetailPharmaciesOneMany.oppositeType = "Many";

		References.add(RetailPharmaciesOneMany);

		var ReturnSuppliersOneMany = new EntityReference();
			ReturnSuppliersOneMany.entityName = "ReturnSupplier";
			ReturnSuppliersOneMany.oppositeName = "Warehouse";
			ReturnSuppliersOneMany.name = "ReturnSuppliers";
			ReturnSuppliersOneMany.optional = true;
			ReturnSuppliersOneMany.type = "One";
			ReturnSuppliersOneMany.oppositeType = "Many";

		References.add(ReturnSuppliersOneMany);

		var SourceWarehousesOneMany = new EntityReference();
			SourceWarehousesOneMany.entityName = "TransferOrder";
			SourceWarehousesOneMany.oppositeName = "SourceWarehouse";
			SourceWarehousesOneMany.name = "SourceWarehouses";
			SourceWarehousesOneMany.optional = true;
			SourceWarehousesOneMany.type = "One";
			SourceWarehousesOneMany.oppositeType = "Many";

		References.add(SourceWarehousesOneMany);

		var StockCataloguesOneMany = new EntityReference();
			StockCataloguesOneMany.entityName = "StockCatalogue";
			StockCataloguesOneMany.oppositeName = "Warehouse";
			StockCataloguesOneMany.name = "StockCatalogues";
			StockCataloguesOneMany.optional = true;
			StockCataloguesOneMany.type = "One";
			StockCataloguesOneMany.oppositeType = "Many";

		References.add(StockCataloguesOneMany);

		var StockControlsOneMany = new EntityReference();
			StockControlsOneMany.entityName = "StockControl";
			StockControlsOneMany.oppositeName = "Warehouse";
			StockControlsOneMany.name = "StockControls";
			StockControlsOneMany.optional = true;
			StockControlsOneMany.type = "One";
			StockControlsOneMany.oppositeType = "Many";

		References.add(StockControlsOneMany);

		var StockTransactionDetailsOneMany = new EntityReference();
			StockTransactionDetailsOneMany.entityName = "StockTransactionDetail";
			StockTransactionDetailsOneMany.oppositeName = "Warehouse";
			StockTransactionDetailsOneMany.name = "StockTransactionDetails";
			StockTransactionDetailsOneMany.optional = true;
			StockTransactionDetailsOneMany.type = "One";
			StockTransactionDetailsOneMany.oppositeType = "Many";

		References.add(StockTransactionDetailsOneMany);

		var StockTransactionPerDateTypesOneMany = new EntityReference();
			StockTransactionPerDateTypesOneMany.entityName = "StockTransactionPerDateType";
			StockTransactionPerDateTypesOneMany.oppositeName = "Warehouse";
			StockTransactionPerDateTypesOneMany.name = "StockTransactionPerDateTypes";
			StockTransactionPerDateTypesOneMany.optional = true;
			StockTransactionPerDateTypesOneMany.type = "One";
			StockTransactionPerDateTypesOneMany.oppositeType = "Many";

		References.add(StockTransactionPerDateTypesOneMany);

		var StockTransactionPerDatesOneMany = new EntityReference();
			StockTransactionPerDatesOneMany.entityName = "StockTransactionPerDate";
			StockTransactionPerDatesOneMany.oppositeName = "Warehouse";
			StockTransactionPerDatesOneMany.name = "StockTransactionPerDates";
			StockTransactionPerDatesOneMany.optional = true;
			StockTransactionPerDatesOneMany.type = "One";
			StockTransactionPerDatesOneMany.oppositeType = "Many";

		References.add(StockTransactionPerDatesOneMany);

		var VaccinationOrderDetailsOneMany = new EntityReference();
			VaccinationOrderDetailsOneMany.entityName = "VaccinationOrderDetail";
			VaccinationOrderDetailsOneMany.oppositeName = "Warehouse";
			VaccinationOrderDetailsOneMany.name = "VaccinationOrderDetails";
			VaccinationOrderDetailsOneMany.optional = true;
			VaccinationOrderDetailsOneMany.type = "One";
			VaccinationOrderDetailsOneMany.oppositeType = "Many";

		References.add(VaccinationOrderDetailsOneMany);

		var WarehouseInitialStockSOneMany = new EntityReference();
			WarehouseInitialStockSOneMany.entityName = "WarehouseInitialStock";
			WarehouseInitialStockSOneMany.oppositeName = "Warehouse";
			WarehouseInitialStockSOneMany.name = "WarehouseInitialStockS";
			WarehouseInitialStockSOneMany.optional = true;
			WarehouseInitialStockSOneMany.type = "One";
			WarehouseInitialStockSOneMany.oppositeType = "Many";

		References.add(WarehouseInitialStockSOneMany);

		var WarehouseInventoriesOneMany = new EntityReference();
			WarehouseInventoriesOneMany.entityName = "WarehouseInventory";
			WarehouseInventoriesOneMany.oppositeName = "Warehouse";
			WarehouseInventoriesOneMany.name = "WarehouseInventories";
			WarehouseInventoriesOneMany.optional = true;
			WarehouseInventoriesOneMany.type = "One";
			WarehouseInventoriesOneMany.oppositeType = "Many";

		References.add(WarehouseInventoriesOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Warehouse Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Warehouse Number here] end
	private String warehouseNumber;

	// % protected region % [Modify attribute annotation for Warehouse Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Warehouse Name here] end
	private String warehouseName;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Contact Person here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contact Person here] end
	private String contactPerson;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Ext here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Ext here] end
	private String ext;

	// % protected region % [Modify attribute annotation for Mobile Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Mobile Phone Number here] end
	private String mobilePhoneNumber;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Revenue Center here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revenue Center here] end
	private String revenueCenter;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BatchStockBalanceEntity> batchStockBalancesWarehouse = new HashSet<>();

	private Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();

	private Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();

	private Set<TransferOrderEntity> destinationWarehouses = new HashSet<>();

	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	private Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();

	private Set<InternalOrderEntity> internalOrders = new HashSet<>();

	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	private Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();

	private Set<InventoryBatchCorrectionEntity> inventoryBatchCorrections = new HashSet<>();

	private Set<LocationEntity> locations = new HashSet<>();

	private Set<MedicalFeeEntity> medicalFees = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	private Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();

	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	private Set<TransferOrderEntity> sourceWarehouses = new HashSet<>();

	private Set<StockCatalogueEntity> stockCatalogues = new HashSet<>();

	private Set<StockControlEntity> stockControls = new HashSet<>();

	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	private Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();

	private Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();

	private Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();

	private Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBatchStockBalancesWarehouse(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesWarehouse(@NonNull BatchStockBalanceEntity entity) {
		addBatchStockBalancesWarehouse(entity, true);
	}

	/**
	 * Add a new BatchStockBalanceEntity to batchStockBalancesWarehouse in this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalancesWarehouse(@NonNull BatchStockBalanceEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalancesWarehouse.contains(entity)) {
			batchStockBalancesWarehouse.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalancesWarehouse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities) {
		addBatchStockBalancesWarehouse(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalanceEntity to Batch Stock Balances Warehouse in this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalancesWarehouse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesWarehouse(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be set to this entity
	 */
	public void removeBatchStockBalancesWarehouse(@NonNull BatchStockBalanceEntity entity) {
		this.removeBatchStockBalancesWarehouse(entity, true);
	}

	/**
	 * Remove the given BatchStockBalanceEntity from this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalancesWarehouse(@NonNull BatchStockBalanceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.batchStockBalancesWarehouse.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesWarehouse(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 */
	public void removeBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities) {
		this.removeBatchStockBalancesWarehouse(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalanceEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalancesWarehouse(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalancesWarehouse(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be set to this entity
	 */
	public void setBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities) {
		setBatchStockBalancesWarehouse(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances Warehouse with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalancesWarehouse(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalancesWarehouse();
		this.batchStockBalancesWarehouse = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalancesWarehouse.forEach(batchStockBalancesWarehouseEntity -> batchStockBalancesWarehouseEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalancesWarehouse(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalancesWarehouse() {
		this.unsetBatchStockBalancesWarehouse(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances Warehouse from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalancesWarehouse(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalancesWarehouse.forEach(batchStockBalancesWarehouseEntity -> batchStockBalancesWarehouseEntity.unsetWarehouse(false));
		}
		this.batchStockBalancesWarehouse.clear();
	}

/**
	 * Similar to {@link this#addBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity) {
		addBatchStockBalances(entity, true);
	}

	/**
	 * Add a new BatchStockBalancePerDateEntity to batchStockBalances in this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalances.contains(entity)) {
			batchStockBalances.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		addBatchStockBalances(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalancePerDateEntity to Batch Stock Balances in this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void removeBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity) {
		this.removeBatchStockBalances(entity, true);
	}

	/**
	 * Remove the given BatchStockBalancePerDateEntity from this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.batchStockBalances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 */
	public void removeBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		this.removeBatchStockBalances(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalancePerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void setBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		setBatchStockBalances(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalances();
		this.batchStockBalances = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalances() {
		this.unsetBatchStockBalances(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalances(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.unsetWarehouse(false));
		}
		this.batchStockBalances.clear();
	}

/**
	 * Similar to {@link this#addBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity) {
		addBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new BatchStockTransactionDetailEntity to batchStockTransactionDetails in this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.batchStockTransactionDetails.contains(entity)) {
			batchStockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		addBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of BatchStockTransactionDetailEntity to Batch Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity) {
		this.removeBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given BatchStockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.batchStockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		this.removeBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void setBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		setBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockTransactionDetails();
		this.batchStockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockTransactionDetails() {
		this.unsetBatchStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Batch Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.unsetWarehouse(false));
		}
		this.batchStockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addDestinationWarehouses(TransferOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderEntity to be added to this entity
	 */
	public void addDestinationWarehouses(@NonNull TransferOrderEntity entity) {
		addDestinationWarehouses(entity, true);
	}

	/**
	 * Add a new TransferOrderEntity to destinationWarehouses in this entity.
	 *
	 * @param entity the given TransferOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDestinationWarehouses(@NonNull TransferOrderEntity entity, boolean reverseAdd) {
		if (!this.destinationWarehouses.contains(entity)) {
			destinationWarehouses.add(entity);
			if (reverseAdd) {
				entity.setDestinationWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDestinationWarehouses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderEntity to be added to this entity
	 */
	public void addDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		addDestinationWarehouses(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderEntity to Destination Warehouses in this entity.
	 *
	 * @param entities the given collection of TransferOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDestinationWarehouses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDestinationWarehouses(TransferOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderEntity to be set to this entity
	 */
	public void removeDestinationWarehouses(@NonNull TransferOrderEntity entity) {
		this.removeDestinationWarehouses(entity, true);
	}

	/**
	 * Remove the given TransferOrderEntity from this entity.
	 *
	 * @param entity the given TransferOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDestinationWarehouses(@NonNull TransferOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDestinationWarehouse(false);
		}
		this.destinationWarehouses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDestinationWarehouses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderEntity to be removed to this entity
	 */
	public void removeDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		this.removeDestinationWarehouses(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDestinationWarehouses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDestinationWarehouses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderEntity to be set to this entity
	 */
	public void setDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		setDestinationWarehouses(entities, true);
	}

	/**
	 * Replace the current entities in Destination Warehouses with the given ones.
	 *
	 * @param entities the given collection of TransferOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDestinationWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {

		this.unsetDestinationWarehouses();
		this.destinationWarehouses = new HashSet<>(entities);
		if (reverseAdd) {
			this.destinationWarehouses.forEach(destinationWarehousesEntity -> destinationWarehousesEntity.setDestinationWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDestinationWarehouses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDestinationWarehouses() {
		this.unsetDestinationWarehouses(true);
	}

	/**
	 * Remove all the entities in Destination Warehouses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDestinationWarehouses(boolean doReverse) {
		if (doReverse) {
			this.destinationWarehouses.forEach(destinationWarehousesEntity -> destinationWarehousesEntity.unsetDestinationWarehouse(false));
		}
		this.destinationWarehouses.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		addGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteBatchEntity to goodsReceiveNoteBatchs in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteBatchs.contains(entity)) {
			goodsReceiveNoteBatchs.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		addGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteBatchEntity to Goods Receive Note Batchs in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		this.removeGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteBatchEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.goodsReceiveNoteBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		this.removeGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		setGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Batchs with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteBatchs();
		this.goodsReceiveNoteBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteBatchs() {
		this.unsetGoodsReceiveNoteBatchs(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteBatchs(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.unsetWarehouse(false));
		}
		this.goodsReceiveNoteBatchs.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity) {
		addGoodsReceiveNotes(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteEntity to goodsReceiveNotes in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNotes.contains(entity)) {
			goodsReceiveNotes.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		addGoodsReceiveNotes(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteEntity to Goods Receive Notes in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void removeGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity) {
		this.removeGoodsReceiveNotes(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.goodsReceiveNotes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		this.removeGoodsReceiveNotes(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		setGoodsReceiveNotes(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Notes with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNotes();
		this.goodsReceiveNotes = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNotes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNotes() {
		this.unsetGoodsReceiveNotes(true);
	}

	/**
	 * Remove all the entities in Goods Receive Notes from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNotes(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.unsetWarehouse(false));
		}
		this.goodsReceiveNotes.clear();
	}

/**
	 * Similar to {@link this#addInternalOrders(InternalOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderEntity to be added to this entity
	 */
	public void addInternalOrders(@NonNull InternalOrderEntity entity) {
		addInternalOrders(entity, true);
	}

	/**
	 * Add a new InternalOrderEntity to internalOrders in this entity.
	 *
	 * @param entity the given InternalOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInternalOrders(@NonNull InternalOrderEntity entity, boolean reverseAdd) {
		if (!this.internalOrders.contains(entity)) {
			internalOrders.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInternalOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderEntity to be added to this entity
	 */
	public void addInternalOrders(@NonNull Collection<InternalOrderEntity> entities) {
		addInternalOrders(entities, true);
	}

	/**
	 * Add a new collection of InternalOrderEntity to Internal Orders in this entity.
	 *
	 * @param entities the given collection of InternalOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInternalOrders(@NonNull Collection<InternalOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInternalOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInternalOrders(InternalOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderEntity to be set to this entity
	 */
	public void removeInternalOrders(@NonNull InternalOrderEntity entity) {
		this.removeInternalOrders(entity, true);
	}

	/**
	 * Remove the given InternalOrderEntity from this entity.
	 *
	 * @param entity the given InternalOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInternalOrders(@NonNull InternalOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.internalOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInternalOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InternalOrderEntity to be removed to this entity
	 */
	public void removeInternalOrders(@NonNull Collection<InternalOrderEntity> entities) {
		this.removeInternalOrders(entities, true);
	}

	/**
	 * Remove the given collection of InternalOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of InternalOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInternalOrders(@NonNull Collection<InternalOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInternalOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInternalOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderEntity to be set to this entity
	 */
	public void setInternalOrders(@NonNull Collection<InternalOrderEntity> entities) {
		setInternalOrders(entities, true);
	}

	/**
	 * Replace the current entities in Internal Orders with the given ones.
	 *
	 * @param entities the given collection of InternalOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInternalOrders(@NonNull Collection<InternalOrderEntity> entities, boolean reverseAdd) {

		this.unsetInternalOrders();
		this.internalOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.internalOrders.forEach(internalOrdersEntity -> internalOrdersEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInternalOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInternalOrders() {
		this.unsetInternalOrders(true);
	}

	/**
	 * Remove all the entities in Internal Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInternalOrders(boolean doReverse) {
		if (doReverse) {
			this.internalOrders.forEach(internalOrdersEntity -> internalOrdersEntity.unsetWarehouse(false));
		}
		this.internalOrders.clear();
	}

/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		addInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Add a new InventoryAdjusmentBatchEntity to inventoryAdjusmentBatchs in this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjusmentBatchs.contains(entity)) {
			inventoryAdjusmentBatchs.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		addInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjusmentBatchEntity to Inventory Adjusment Batchs in this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		this.removeInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Remove the given InventoryAdjusmentBatchEntity from this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.inventoryAdjusmentBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		this.removeInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjusmentBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		setInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjusment Batchs with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjusmentBatchs();
		this.inventoryAdjusmentBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjusmentBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjusmentBatchs() {
		this.unsetInventoryAdjusmentBatchs(true);
	}

	/**
	 * Remove all the entities in Inventory Adjusment Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjusmentBatchs(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.unsetWarehouse(false));
		}
		this.inventoryAdjusmentBatchs.clear();
	}

/**
	 * Similar to {@link this#addInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity) {
		addInventoryAdjustments(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentEntity to inventoryAdjustments in this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustments.contains(entity)) {
			inventoryAdjustments.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		addInventoryAdjustments(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentEntity to Inventory Adjustments in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set to this entity
	 */
	public void removeInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity) {
		this.removeInventoryAdjustments(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.inventoryAdjustments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 */
	public void removeInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		this.removeInventoryAdjustments(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be set to this entity
	 */
	public void setInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		setInventoryAdjustments(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustments with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustments();
		this.inventoryAdjustments = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustments() {
		this.unsetInventoryAdjustments(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustments(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.unsetWarehouse(false));
		}
		this.inventoryAdjustments.clear();
	}

/**
	 * Similar to {@link this#addInventoryBatchCorrections(InventoryBatchCorrectionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be added to this entity
	 */
	public void addInventoryBatchCorrections(@NonNull InventoryBatchCorrectionEntity entity) {
		addInventoryBatchCorrections(entity, true);
	}

	/**
	 * Add a new InventoryBatchCorrectionEntity to inventoryBatchCorrections in this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryBatchCorrections(@NonNull InventoryBatchCorrectionEntity entity, boolean reverseAdd) {
		if (!this.inventoryBatchCorrections.contains(entity)) {
			inventoryBatchCorrections.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryBatchCorrections(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to be added to this entity
	 */
	public void addInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities) {
		addInventoryBatchCorrections(entities, true);
	}

	/**
	 * Add a new collection of InventoryBatchCorrectionEntity to Inventory Batch Corrections in this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryBatchCorrections(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrections(InventoryBatchCorrectionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be set to this entity
	 */
	public void removeInventoryBatchCorrections(@NonNull InventoryBatchCorrectionEntity entity) {
		this.removeInventoryBatchCorrections(entity, true);
	}

	/**
	 * Remove the given InventoryBatchCorrectionEntity from this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryBatchCorrections(@NonNull InventoryBatchCorrectionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.inventoryBatchCorrections.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrections(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to be removed to this entity
	 */
	public void removeInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities) {
		this.removeInventoryBatchCorrections(entities, true);
	}

	/**
	 * Remove the given collection of InventoryBatchCorrectionEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryBatchCorrections(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryBatchCorrections(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to be set to this entity
	 */
	public void setInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities) {
		setInventoryBatchCorrections(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Batch Corrections with the given ones.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryBatchCorrections(@NonNull Collection<InventoryBatchCorrectionEntity> entities, boolean reverseAdd) {

		this.unsetInventoryBatchCorrections();
		this.inventoryBatchCorrections = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryBatchCorrections.forEach(inventoryBatchCorrectionsEntity -> inventoryBatchCorrectionsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrections(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryBatchCorrections() {
		this.unsetInventoryBatchCorrections(true);
	}

	/**
	 * Remove all the entities in Inventory Batch Corrections from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryBatchCorrections(boolean doReverse) {
		if (doReverse) {
			this.inventoryBatchCorrections.forEach(inventoryBatchCorrectionsEntity -> inventoryBatchCorrectionsEntity.unsetWarehouse(false));
		}
		this.inventoryBatchCorrections.clear();
	}

/**
	 * Similar to {@link this#addLocations(LocationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given LocationEntity to be added to this entity
	 */
	public void addLocations(@NonNull LocationEntity entity) {
		addLocations(entity, true);
	}

	/**
	 * Add a new LocationEntity to locations in this entity.
	 *
	 * @param entity the given LocationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addLocations(@NonNull LocationEntity entity, boolean reverseAdd) {
		if (!this.locations.contains(entity)) {
			locations.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addLocations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of LocationEntity to be added to this entity
	 */
	public void addLocations(@NonNull Collection<LocationEntity> entities) {
		addLocations(entities, true);
	}

	/**
	 * Add a new collection of LocationEntity to Locations in this entity.
	 *
	 * @param entities the given collection of LocationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addLocations(@NonNull Collection<LocationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addLocations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeLocations(LocationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given LocationEntity to be set to this entity
	 */
	public void removeLocations(@NonNull LocationEntity entity) {
		this.removeLocations(entity, true);
	}

	/**
	 * Remove the given LocationEntity from this entity.
	 *
	 * @param entity the given LocationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeLocations(@NonNull LocationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.locations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeLocations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of LocationEntity to be removed to this entity
	 */
	public void removeLocations(@NonNull Collection<LocationEntity> entities) {
		this.removeLocations(entities, true);
	}

	/**
	 * Remove the given collection of LocationEntity from  to this entity.
	 *
	 * @param entities the given collection of LocationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeLocations(@NonNull Collection<LocationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeLocations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setLocations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of LocationEntity to be set to this entity
	 */
	public void setLocations(@NonNull Collection<LocationEntity> entities) {
		setLocations(entities, true);
	}

	/**
	 * Replace the current entities in Locations with the given ones.
	 *
	 * @param entities the given collection of LocationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setLocations(@NonNull Collection<LocationEntity> entities, boolean reverseAdd) {

		this.unsetLocations();
		this.locations = new HashSet<>(entities);
		if (reverseAdd) {
			this.locations.forEach(locationsEntity -> locationsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetLocations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetLocations() {
		this.unsetLocations(true);
	}

	/**
	 * Remove all the entities in Locations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetLocations(boolean doReverse) {
		if (doReverse) {
			this.locations.forEach(locationsEntity -> locationsEntity.unsetWarehouse(false));
		}
		this.locations.clear();
	}

/**
	 * Similar to {@link this#addMedicalFees(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be added to this entity
	 */
	public void addMedicalFees(@NonNull MedicalFeeEntity entity) {
		addMedicalFees(entity, true);
	}

	/**
	 * Add a new MedicalFeeEntity to medicalFees in this entity.
	 *
	 * @param entity the given MedicalFeeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalFees(@NonNull MedicalFeeEntity entity, boolean reverseAdd) {
		if (!this.medicalFees.contains(entity)) {
			medicalFees.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be added to this entity
	 */
	public void addMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		addMedicalFees(entities, true);
	}

	/**
	 * Add a new collection of MedicalFeeEntity to Medical Fees in this entity.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalFees(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be set to this entity
	 */
	public void removeMedicalFees(@NonNull MedicalFeeEntity entity) {
		this.removeMedicalFees(entity, true);
	}

	/**
	 * Remove the given MedicalFeeEntity from this entity.
	 *
	 * @param entity the given MedicalFeeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFees(@NonNull MedicalFeeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.medicalFees.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalFees(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be removed to this entity
	 */
	public void removeMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		this.removeMedicalFees(entities, true);
	}

	/**
	 * Remove the given collection of MedicalFeeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalFees(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalFees(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeEntity to be set to this entity
	 */
	public void setMedicalFees(@NonNull Collection<MedicalFeeEntity> entities) {
		setMedicalFees(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fees with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFees(@NonNull Collection<MedicalFeeEntity> entities, boolean reverseAdd) {

		this.unsetMedicalFees();
		this.medicalFees = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalFees.forEach(medicalFeesEntity -> medicalFeesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalFees(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalFees() {
		this.unsetMedicalFees(true);
	}

	/**
	 * Remove all the entities in Medical Fees from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalFees(boolean doReverse) {
		if (doReverse) {
			this.medicalFees.forEach(medicalFeesEntity -> medicalFeesEntity.unsetWarehouse(false));
		}
		this.medicalFees.clear();
	}

/**
	 * Similar to {@link this#addMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NonNull MedicationHeaderEntity entity) {
		addMedicationHeaders(entity, true);
	}

	/**
	 * Add a new MedicationHeaderEntity to medicationHeaders in this entity.
	 *
	 * @param entity the given MedicationHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationHeaders(@NonNull MedicationHeaderEntity entity, boolean reverseAdd) {
		if (!this.medicationHeaders.contains(entity)) {
			medicationHeaders.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 */
	public void addMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		addMedicationHeaders(entities, true);
	}

	/**
	 * Add a new collection of MedicationHeaderEntity to Medication Headers in this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void removeMedicationHeaders(@NonNull MedicationHeaderEntity entity) {
		this.removeMedicationHeaders(entity, true);
	}

	/**
	 * Remove the given MedicationHeaderEntity from this entity.
	 *
	 * @param entity the given MedicationHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationHeaders(@NonNull MedicationHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.medicationHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 */
	public void removeMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		this.removeMedicationHeaders(entities, true);
	}

	/**
	 * Remove the given collection of MedicationHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities) {
		setMedicationHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Medication Headers with the given ones.
	 *
	 * @param entities the given collection of MedicationHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationHeaders(@NonNull Collection<MedicationHeaderEntity> entities, boolean reverseAdd) {

		this.unsetMedicationHeaders();
		this.medicationHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationHeaders() {
		this.unsetMedicationHeaders(true);
	}

	/**
	 * Remove all the entities in Medication Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationHeaders(boolean doReverse) {
		if (doReverse) {
			this.medicationHeaders.forEach(medicationHeadersEntity -> medicationHeadersEntity.unsetWarehouse(false));
		}
		this.medicationHeaders.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity) {
		addPrescriptionHeaders(entity, true);
	}

	/**
	 * Add a new PrescriptionHeaderEntity to prescriptionHeaders in this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		if (!this.prescriptionHeaders.contains(entity)) {
			prescriptionHeaders.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 */
	public void addPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		addPrescriptionHeaders(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionHeaderEntity to Prescription Headers in this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void removePrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity) {
		this.removePrescriptionHeaders(entity, true);
	}

	/**
	 * Remove the given PrescriptionHeaderEntity from this entity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionHeaders(@NonNull PrescriptionHeaderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.prescriptionHeaders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 */
	public void removePrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		this.removePrescriptionHeaders(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionHeaderEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionHeaders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionHeaders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities) {
		setPrescriptionHeaders(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Headers with the given ones.
	 *
	 * @param entities the given collection of PrescriptionHeaderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionHeaders(@NonNull Collection<PrescriptionHeaderEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionHeaders();
		this.prescriptionHeaders = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionHeaders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionHeaders() {
		this.unsetPrescriptionHeaders(true);
	}

	/**
	 * Remove all the entities in Prescription Headers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionHeaders(boolean doReverse) {
		if (doReverse) {
			this.prescriptionHeaders.forEach(prescriptionHeadersEntity -> prescriptionHeadersEntity.unsetWarehouse(false));
		}
		this.prescriptionHeaders.clear();
	}

/**
	 * Similar to {@link this#addPurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		addPurchaseOrders(entity, true);
	}

	/**
	 * Add a new PurchaseOrderEntity to purchaseOrders in this entity.
	 *
	 * @param entity the given PurchaseOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrders.contains(entity)) {
			purchaseOrders.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		addPurchaseOrders(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderEntity to Purchase Orders in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		this.removePurchaseOrders(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.purchaseOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		this.removePurchaseOrders(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		setPurchaseOrders(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Orders with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrders();
		this.purchaseOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrders() {
		this.unsetPurchaseOrders(true);
	}

	/**
	 * Remove all the entities in Purchase Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrders(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.unsetWarehouse(false));
		}
		this.purchaseOrders.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		addPurchaseRequisitions(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionEntity to purchaseRequisitions in this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitions.contains(entity)) {
			purchaseRequisitions.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		addPurchaseRequisitions(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionEntity to Purchase Requisitions in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		this.removePurchaseRequisitions(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.purchaseRequisitions.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		this.removePurchaseRequisitions(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		setPurchaseRequisitions(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisitions with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitions();
		this.purchaseRequisitions = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitions() {
		this.unsetPurchaseRequisitions(true);
	}

	/**
	 * Remove all the entities in Purchase Requisitions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitions(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.unsetWarehouse(false));
		}
		this.purchaseRequisitions.clear();
	}

/**
	 * Similar to {@link this#addRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NonNull RetailPharmacyEntity entity) {
		addRetailPharmacies(entity, true);
	}

	/**
	 * Add a new RetailPharmacyEntity to retailPharmacies in this entity.
	 *
	 * @param entity the given RetailPharmacyEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacies(@NonNull RetailPharmacyEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacies.contains(entity)) {
			retailPharmacies.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 */
	public void addRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		addRetailPharmacies(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyEntity to Retail Pharmacies in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void removeRetailPharmacies(@NonNull RetailPharmacyEntity entity) {
		this.removeRetailPharmacies(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacies(@NonNull RetailPharmacyEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.retailPharmacies.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 */
	public void removeRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		this.removeRetailPharmacies(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacies(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacies(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities) {
		setRetailPharmacies(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacies with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacies(@NonNull Collection<RetailPharmacyEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacies();
		this.retailPharmacies = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacies(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacies() {
		this.unsetRetailPharmacies(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacies from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacies(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacies.forEach(retailPharmaciesEntity -> retailPharmaciesEntity.unsetWarehouse(false));
		}
		this.retailPharmacies.clear();
	}

/**
	 * Similar to {@link this#addReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		addReturnSuppliers(entity, true);
	}

	/**
	 * Add a new ReturnSupplierEntity to returnSuppliers in this entity.
	 *
	 * @param entity the given ReturnSupplierEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverseAdd) {
		if (!this.returnSuppliers.contains(entity)) {
			returnSuppliers.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		addReturnSuppliers(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierEntity to Return Suppliers in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		this.removeReturnSuppliers(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.returnSuppliers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		this.removeReturnSuppliers(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		setReturnSuppliers(entities, true);
	}

	/**
	 * Replace the current entities in Return Suppliers with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {

		this.unsetReturnSuppliers();
		this.returnSuppliers = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSuppliers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSuppliers() {
		this.unsetReturnSuppliers(true);
	}

	/**
	 * Remove all the entities in Return Suppliers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSuppliers(boolean doReverse) {
		if (doReverse) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.unsetWarehouse(false));
		}
		this.returnSuppliers.clear();
	}

/**
	 * Similar to {@link this#addSourceWarehouses(TransferOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderEntity to be added to this entity
	 */
	public void addSourceWarehouses(@NonNull TransferOrderEntity entity) {
		addSourceWarehouses(entity, true);
	}

	/**
	 * Add a new TransferOrderEntity to sourceWarehouses in this entity.
	 *
	 * @param entity the given TransferOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSourceWarehouses(@NonNull TransferOrderEntity entity, boolean reverseAdd) {
		if (!this.sourceWarehouses.contains(entity)) {
			sourceWarehouses.add(entity);
			if (reverseAdd) {
				entity.setSourceWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSourceWarehouses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderEntity to be added to this entity
	 */
	public void addSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		addSourceWarehouses(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderEntity to Source Warehouses in this entity.
	 *
	 * @param entities the given collection of TransferOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSourceWarehouses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSourceWarehouses(TransferOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderEntity to be set to this entity
	 */
	public void removeSourceWarehouses(@NonNull TransferOrderEntity entity) {
		this.removeSourceWarehouses(entity, true);
	}

	/**
	 * Remove the given TransferOrderEntity from this entity.
	 *
	 * @param entity the given TransferOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSourceWarehouses(@NonNull TransferOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSourceWarehouse(false);
		}
		this.sourceWarehouses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSourceWarehouses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderEntity to be removed to this entity
	 */
	public void removeSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		this.removeSourceWarehouses(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSourceWarehouses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSourceWarehouses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderEntity to be set to this entity
	 */
	public void setSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities) {
		setSourceWarehouses(entities, true);
	}

	/**
	 * Replace the current entities in Source Warehouses with the given ones.
	 *
	 * @param entities the given collection of TransferOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSourceWarehouses(@NonNull Collection<TransferOrderEntity> entities, boolean reverseAdd) {

		this.unsetSourceWarehouses();
		this.sourceWarehouses = new HashSet<>(entities);
		if (reverseAdd) {
			this.sourceWarehouses.forEach(sourceWarehousesEntity -> sourceWarehousesEntity.setSourceWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSourceWarehouses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSourceWarehouses() {
		this.unsetSourceWarehouses(true);
	}

	/**
	 * Remove all the entities in Source Warehouses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSourceWarehouses(boolean doReverse) {
		if (doReverse) {
			this.sourceWarehouses.forEach(sourceWarehousesEntity -> sourceWarehousesEntity.unsetSourceWarehouse(false));
		}
		this.sourceWarehouses.clear();
	}

/**
	 * Similar to {@link this#addStockCatalogues(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be added to this entity
	 */
	public void addStockCatalogues(@NonNull StockCatalogueEntity entity) {
		addStockCatalogues(entity, true);
	}

	/**
	 * Add a new StockCatalogueEntity to stockCatalogues in this entity.
	 *
	 * @param entity the given StockCatalogueEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockCatalogues(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		if (!this.stockCatalogues.contains(entity)) {
			stockCatalogues.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockCatalogues(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockCatalogueEntity to be added to this entity
	 */
	public void addStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities) {
		addStockCatalogues(entities, true);
	}

	/**
	 * Add a new collection of StockCatalogueEntity to Stock Catalogues in this entity.
	 *
	 * @param entities the given collection of StockCatalogueEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockCatalogues(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockCatalogues(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void removeStockCatalogues(@NonNull StockCatalogueEntity entity) {
		this.removeStockCatalogues(entity, true);
	}

	/**
	 * Remove the given StockCatalogueEntity from this entity.
	 *
	 * @param entity the given StockCatalogueEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockCatalogues(@NonNull StockCatalogueEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.stockCatalogues.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockCatalogues(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockCatalogueEntity to be removed to this entity
	 */
	public void removeStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities) {
		this.removeStockCatalogues(entities, true);
	}

	/**
	 * Remove the given collection of StockCatalogueEntity from  to this entity.
	 *
	 * @param entities the given collection of StockCatalogueEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockCatalogues(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockCatalogues(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities) {
		setStockCatalogues(entities, true);
	}

	/**
	 * Replace the current entities in Stock Catalogues with the given ones.
	 *
	 * @param entities the given collection of StockCatalogueEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockCatalogues(@NonNull Collection<StockCatalogueEntity> entities, boolean reverseAdd) {

		this.unsetStockCatalogues();
		this.stockCatalogues = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockCatalogues.forEach(stockCataloguesEntity -> stockCataloguesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockCatalogues(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockCatalogues() {
		this.unsetStockCatalogues(true);
	}

	/**
	 * Remove all the entities in Stock Catalogues from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockCatalogues(boolean doReverse) {
		if (doReverse) {
			this.stockCatalogues.forEach(stockCataloguesEntity -> stockCataloguesEntity.unsetWarehouse(false));
		}
		this.stockCatalogues.clear();
	}

/**
	 * Similar to {@link this#addStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity) {
		addStockControls(entity, true);
	}

	/**
	 * Add a new StockControlEntity to stockControls in this entity.
	 *
	 * @param entity the given StockControlEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity, boolean reverseAdd) {
		if (!this.stockControls.contains(entity)) {
			stockControls.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities) {
		addStockControls(entities, true);
	}

	/**
	 * Add a new collection of StockControlEntity to Stock Controls in this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be set to this entity
	 */
	public void removeStockControls(@NonNull StockControlEntity entity) {
		this.removeStockControls(entity, true);
	}

	/**
	 * Remove the given StockControlEntity from this entity.
	 *
	 * @param entity the given StockControlEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockControls(@NonNull StockControlEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.stockControls.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockControls(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities) {
		this.removeStockControls(entities, true);
	}

	/**
	 * Remove the given collection of StockControlEntity from  to this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be set to this entity
	 */
	public void setStockControls(@NonNull Collection<StockControlEntity> entities) {
		setStockControls(entities, true);
	}

	/**
	 * Replace the current entities in Stock Controls with the given ones.
	 *
	 * @param entities the given collection of StockControlEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {

		this.unsetStockControls();
		this.stockControls = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockControls(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockControls() {
		this.unsetStockControls(true);
	}

	/**
	 * Remove all the entities in Stock Controls from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockControls(boolean doReverse) {
		if (doReverse) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.unsetWarehouse(false));
		}
		this.stockControls.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		addStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new StockTransactionDetailEntity to stockTransactionDetails in this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionDetails.contains(entity)) {
			stockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		addStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionDetailEntity to Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be set to this entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		this.removeStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given StockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.stockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		this.removeStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be set to this entity
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		setStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionDetails();
		this.stockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionDetails() {
		this.unsetStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.unsetWarehouse(false));
		}
		this.stockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		addStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateTypeEntity to stockTransactionPerDateTypes in this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDateTypes.contains(entity)) {
			stockTransactionPerDateTypes.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		addStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateTypeEntity to Stock Transaction Per Date Types in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		this.removeStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateTypeEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.stockTransactionPerDateTypes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		this.removeStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateTypeEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		setStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Date Types with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDateTypes();
		this.stockTransactionPerDateTypes = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDateTypes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDateTypes() {
		this.unsetStockTransactionPerDateTypes(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Date Types from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDateTypes(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.unsetWarehouse(false));
		}
		this.stockTransactionPerDateTypes.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity) {
		addStockTransactionPerDates(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateEntity to stockTransactionPerDates in this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDates.contains(entity)) {
			stockTransactionPerDates.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		addStockTransactionPerDates(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateEntity to Stock Transaction Per Dates in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be set to this entity
	 */
	public void removeStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity) {
		this.removeStockTransactionPerDates(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.stockTransactionPerDates.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		this.removeStockTransactionPerDates(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be set to this entity
	 */
	public void setStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		setStockTransactionPerDates(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Dates with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDates();
		this.stockTransactionPerDates = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDates(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDates() {
		this.unsetStockTransactionPerDates(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Dates from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDates(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.unsetWarehouse(false));
		}
		this.stockTransactionPerDates.clear();
	}

/**
	 * Similar to {@link this#addVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity) {
		addVaccinationOrderDetails(entity, true);
	}

	/**
	 * Add a new VaccinationOrderDetailEntity to vaccinationOrderDetails in this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrderDetails.contains(entity)) {
			vaccinationOrderDetails.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		addVaccinationOrderDetails(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderDetailEntity to Vaccination Order Details in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be set to this entity
	 */
	public void removeVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity) {
		this.removeVaccinationOrderDetails(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderDetailEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.vaccinationOrderDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		this.removeVaccinationOrderDetails(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be set to this entity
	 */
	public void setVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		setVaccinationOrderDetails(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Order Details with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrderDetails();
		this.vaccinationOrderDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrderDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrderDetails() {
		this.unsetVaccinationOrderDetails(true);
	}

	/**
	 * Remove all the entities in Vaccination Order Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrderDetails(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.unsetWarehouse(false));
		}
		this.vaccinationOrderDetails.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity) {
		addWarehouseInitialStockS(entity, true);
	}

	/**
	 * Add a new WarehouseInitialStockEntity to warehouseInitialStockS in this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverseAdd) {
		if (!this.warehouseInitialStockS.contains(entity)) {
			warehouseInitialStockS.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		addWarehouseInitialStockS(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInitialStockEntity to Warehouse Initial Stock s in this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be set to this entity
	 */
	public void removeWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity) {
		this.removeWarehouseInitialStockS(entity, true);
	}

	/**
	 * Remove the given WarehouseInitialStockEntity from this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.warehouseInitialStockS.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		this.removeWarehouseInitialStockS(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInitialStockEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be set to this entity
	 */
	public void setWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		setWarehouseInitialStockS(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Initial Stock s with the given ones.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInitialStockS();
		this.warehouseInitialStockS = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInitialStockS(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInitialStockS() {
		this.unsetWarehouseInitialStockS(true);
	}

	/**
	 * Remove all the entities in Warehouse Initial Stock s from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInitialStockS(boolean doReverse) {
		if (doReverse) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.unsetWarehouse(false));
		}
		this.warehouseInitialStockS.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity) {
		addWarehouseInventories(entity, true);
	}

	/**
	 * Add a new WarehouseInventoryEntity to warehouseInventories in this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverseAdd) {
		if (!this.warehouseInventories.contains(entity)) {
			warehouseInventories.add(entity);
			if (reverseAdd) {
				entity.setWarehouse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		addWarehouseInventories(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInventoryEntity to Warehouse Inventories in this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be set to this entity
	 */
	public void removeWarehouseInventories(@NonNull WarehouseInventoryEntity entity) {
		this.removeWarehouseInventories(entity, true);
	}

	/**
	 * Remove the given WarehouseInventoryEntity from this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetWarehouse(false);
		}
		this.warehouseInventories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		this.removeWarehouseInventories(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInventoryEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be set to this entity
	 */
	public void setWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		setWarehouseInventories(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Inventories with the given ones.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInventories();
		this.warehouseInventories = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.setWarehouse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInventories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInventories() {
		this.unsetWarehouseInventories(true);
	}

	/**
	 * Remove all the entities in Warehouse Inventories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInventories(boolean doReverse) {
		if (doReverse) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.unsetWarehouse(false));
		}
		this.warehouseInventories.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
