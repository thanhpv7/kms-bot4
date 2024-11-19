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

import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Observable, of} from 'rxjs';
import {map, tap} from 'rxjs/operators';
import {Apollo, gql} from 'apollo-angular';
import {ToastrService} from 'ngx-toastr';
import {AbstractHttpService} from '../../lib/services/http/abstract-http.service';
import {WarehouseModel} from '../../models/warehouse/warehouse.model';
import {WarehouseModelAudit} from '../../models/warehouse/warehouse.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BatchStockBalanceModel} from 'src/app/models/batchStockBalance/batch_stock_balance.model';
import {BatchStockBalancePerDateModel} from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model';
import {BatchStockTransactionDetailModel} from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model';
import {GoodsReceiveNoteModel} from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import {GoodsReceiveNoteBatchModel} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import {InternalOrderModel} from 'src/app/models/internalOrder/internal_order.model';
import {InventoryAdjusmentBatchModel} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import {InventoryAdjustmentModel} from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import {InventoryBatchCorrectionModel} from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import {LocationModel} from 'src/app/models/location/location.model';
import {MedicalFeeModel} from 'src/app/models/medicalFee/medical_fee.model';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import {PurchaseOrderModel} from 'src/app/models/purchaseOrder/purchase_order.model';
import {PurchaseRequisitionModel} from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import {RetailPharmacyModel} from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import {ReturnSupplierModel} from 'src/app/models/returnSupplier/return_supplier.model';
import {StockCatalogueModel} from 'src/app/models/stockCatalogue/stock_catalogue.model';
import {StockControlModel} from 'src/app/models/stockControl/stock_control.model';
import {StockTransactionDetailModel} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import {StockTransactionPerDateModel} from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model';
import {StockTransactionPerDateTypeModel} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import {TransferOrderModel} from 'src/app/models/transferOrder/transfer_order.model';
import {VaccinationOrderDetailModel} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import {WarehouseInitialStockModel} from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import {WarehouseInventoryModel} from 'src/app/models/warehouseInventory/warehouse_inventory.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Warehouse service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class WarehouseService extends AbstractHttpService<WarehouseModel, WarehouseModelAudit> {
	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		apollo: Apollo,
		router: Router,
		authService: AuthenticationService,
		toastrService: ToastrService,
		http: HttpClient,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			apollo,
			router,
			authService,
			toastrService,
			http,
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * @inheritDoc
	 */
	protected readonly classFragments = {
		properties: gql`
			# % protected region % [Modify the WarehouseProperties classFragment here] off begin
			fragment WarehouseProperties on Warehouse {
				...WarehouseBaseProperties
				warehouseNumber
				warehouseName
				description
				address
				contactPerson
				phoneNumber
				ext
				mobilePhoneNumber
				email
				revenueCenter
			}
			# % protected region % [Modify the WarehouseProperties classFragment here] end
			${super.fragments('Warehouse').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query Count {
						totalCount: countWarehouses

						# % protected region % [Add any additional queries for count here] off begin
						# % protected region % [Add any additional queries for count here] end
					}

					# % protected region % [Add any additional GraphQL info for count here] off begin
					# % protected region % [Add any additional GraphQL info for count here] end
				`,
				variables: {
					// % protected region % [Add any additional variables for count here] off begin
					// % protected region % [Add any additional variables for count here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for count here] off begin
				// % protected region % [Add any additional processing of the result for count here] end

				return {
					totalCount: result.data.totalCount as number,
					// % protected region % [Add any additional info to be passed up for count here] off begin
					// % protected region % [Add any additional info to be passed up for count here] end
				};
			}),
			// % protected region % [Add any additional piping logic for count here] off begin
			// % protected region % [Add any additional piping logic for count here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAll(): Observable<PassableStateConfig<WarehouseModel>> {
		return this.getWithQuery({
			pageIndex: 0,
			pageSize: 10,
			orderBy: [
				{
					path: 'created',
					descending: true
				},
				// % protected region % [Add any additional orders here] off begin
				// % protected region % [Add any additional orders here] end
			]
		}).pipe(
			// % protected region % [Add any additional piping logic for getAll here] off begin
			// % protected region % [Add any additional piping logic for getAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						WarehouseById: warehouseById(id: $id) {
							...WarehouseProperties
							${this.getExpands(expands)}
						}

						# % protected region % [Add any additional queries for get here] off begin
						# % protected region % [Add any additional queries for get here] end
					}

					# % protected region % [Add any additional GraphQL info for get here] off begin
					# % protected region % [Add any additional GraphQL info for get here] end

					${this.classFragments.properties}
				`,
				variables: {
					id: id,
					// % protected region % [Add any additional variables for get here] off begin
					// % protected region % [Add any additional variables for get here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for get here] off begin
				// % protected region % [Add any additional processing of the result for get here] end

				return {
					targetModelId: id,
					targetModel: result.data.WarehouseById as WarehouseModel,
					// % protected region % [Add any additional info to be passed up for get here] off begin
					// % protected region % [Add any additional info to be passed up for get here] end
				};
			}),
			// % protected region % [Add any additional piping logic for get here] off begin
			// % protected region % [Add any additional piping logic for get here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						warehouses: warehouses(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...WarehouseProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countWarehouses(where: $where)

						# % protected region % [Add any additional queries for getWithQuery here] off begin
						# % protected region % [Add any additional queries for getWithQuery here] end
					}

					# % protected region % [Add any additional GraphQL info for getWithQuery here] off begin
					# % protected region % [Add any additional GraphQL info for getWithQuery here] end

					${this.classFragments.properties}
				`,
				variables: {
					pageIndex: queryParams.pageIndex,
					pageSize: queryParams.pageSize,
					orderBy: queryParams.orderBy || [],
					where: queryParams.where || [],
					// % protected region % [Add any additional variables for getWithQuery here] off begin
					// % protected region % [Add any additional variables for getWithQuery here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for getWithQuery here] off begin
				// % protected region % [Add any additional processing of the result for getWithQuery here] end

				return {
					collectionCount: result.data.totalCount,
					targetModels: result.data.warehouses as WarehouseModel[],
					queryParams: queryParams,
					// % protected region % [Add any additional info to be passed up for getWithQuery here] off begin
					// % protected region % [Add any additional info to be passed up for getWithQuery here] end
				};
			}),
			// % protected region % [Add any additional piping logic for getWithQuery here] off begin
			// % protected region % [Add any additional piping logic for getWithQuery here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						warehouses: lastWarehouses(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...WarehouseProperties
						}

						totalCount: countWarehouses

						# % protected region % [Add any additional queries for getLastWithQuery here] off begin
						# % protected region % [Add any additional queries for getLastWithQuery here] end
					}

					# % protected region % [Add any additional GraphQL info for getLastWithQuery here] off begin
					# % protected region % [Add any additional GraphQL info for getLastWithQuery here] end

					${this.classFragments.properties}
				`,
				variables: {
					pageIndex: queryParams.pageIndex,
					pageSize: queryParams.pageSize,
					orderBy: queryParams.orderBy || [],
					where: queryParams.where || [],
					// % protected region % [Add any additional variables for getLastWithQuery here] off begin
					// % protected region % [Add any additional variables for getLastWithQuery here] end
				}
			}
		).pipe(
			map(result => {
				// % protected region % [Add any additional processing of the result for getLastWithQuery here] off begin
				// % protected region % [Add any additional processing of the result for getLastWithQuery here] end

				return {
					totalCount: result.data.totalCount,
					targetModels: result.data.warehouses as WarehouseModel[],
					queryParams: queryParams,
					// % protected region % [Add any additional info to be passed up for getLastWithQuery here] off begin
					// % protected region % [Add any additional info to be passed up for getLastWithQuery here] end
				};
			}),
			// % protected region % [Add any additional piping logic for getLastWithQuery here] off begin
			// % protected region % [Add any additional piping logic for getLastWithQuery here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	create(entity: WarehouseModel, queryParams?: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Warehouse entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($warehouse: WarehouseInput!, $persistRelations: Boolean) {
						warehouse: createWarehouse(warehouse: $warehouse, persistRelations: $persistRelations) {
							...WarehouseProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for create here] off begin
						# % protected region % [Add any additional mutations for create here] end
				}

					# % protected region % [Add any additional GraphQL info for create here] off begin
					# % protected region % [Add any additional GraphQL info for create here] end

					${this.classFragments.properties}
				`,
				variables: {
					warehouse: {
						...entity.toJSON(),
						batchStockBalancesWarehouse: entity.batchStockBalancesWarehouse ? entity.batchStockBalancesWarehouse?.map((model: BatchStockBalanceModel) => new BatchStockBalanceModel(model).toJSON()) : [],
						batchStockBalances: entity.batchStockBalances ? entity.batchStockBalances?.map((model: BatchStockBalancePerDateModel) => new BatchStockBalancePerDateModel(model).toJSON()) : [],
						batchStockTransactionDetails: entity.batchStockTransactionDetails ? entity.batchStockTransactionDetails?.map((model: BatchStockTransactionDetailModel) => new BatchStockTransactionDetailModel(model).toJSON()) : [],
						destinationWarehouses: entity.destinationWarehouses ? entity.destinationWarehouses?.map((model: TransferOrderModel) => new TransferOrderModel(model).toJSON()) : [],
						goodsReceiveNoteBatchs: entity.goodsReceiveNoteBatchs ? entity.goodsReceiveNoteBatchs?.map((model: GoodsReceiveNoteBatchModel) => new GoodsReceiveNoteBatchModel(model).toJSON()) : [],
						goodsReceiveNotes: entity.goodsReceiveNotes ? entity.goodsReceiveNotes?.map((model: GoodsReceiveNoteModel) => new GoodsReceiveNoteModel(model).toJSON()) : [],
						internalOrders: entity.internalOrders ? entity.internalOrders?.map((model: InternalOrderModel) => new InternalOrderModel(model).toJSON()) : [],
						inventoryAdjusmentBatchs: entity.inventoryAdjusmentBatchs ? entity.inventoryAdjusmentBatchs?.map((model: InventoryAdjusmentBatchModel) => new InventoryAdjusmentBatchModel(model).toJSON()) : [],
						inventoryAdjustments: entity.inventoryAdjustments ? entity.inventoryAdjustments?.map((model: InventoryAdjustmentModel) => new InventoryAdjustmentModel(model).toJSON()) : [],
						inventoryBatchCorrections: entity.inventoryBatchCorrections ? entity.inventoryBatchCorrections?.map((model: InventoryBatchCorrectionModel) => new InventoryBatchCorrectionModel(model).toJSON()) : [],
						locations: entity.locations ? entity.locations?.map((model: LocationModel) => new LocationModel(model).toJSON()) : [],
						medicalFees: entity.medicalFees ? entity.medicalFees?.map((model: MedicalFeeModel) => new MedicalFeeModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						purchaseOrders: entity.purchaseOrders ? entity.purchaseOrders?.map((model: PurchaseOrderModel) => new PurchaseOrderModel(model).toJSON()) : [],
						purchaseRequisitions: entity.purchaseRequisitions ? entity.purchaseRequisitions?.map((model: PurchaseRequisitionModel) => new PurchaseRequisitionModel(model).toJSON()) : [],
						retailPharmacies: entity.retailPharmacies ? entity.retailPharmacies?.map((model: RetailPharmacyModel) => new RetailPharmacyModel(model).toJSON()) : [],
						returnSuppliers: entity.returnSuppliers ? entity.returnSuppliers?.map((model: ReturnSupplierModel) => new ReturnSupplierModel(model).toJSON()) : [],
						sourceWarehouses: entity.sourceWarehouses ? entity.sourceWarehouses?.map((model: TransferOrderModel) => new TransferOrderModel(model).toJSON()) : [],
						stockCatalogues: entity.stockCatalogues ? entity.stockCatalogues?.map((model: StockCatalogueModel) => new StockCatalogueModel(model).toJSON()) : [],
						stockControls: entity.stockControls ? entity.stockControls?.map((model: StockControlModel) => new StockControlModel(model).toJSON()) : [],
						stockTransactionDetails: entity.stockTransactionDetails ? entity.stockTransactionDetails?.map((model: StockTransactionDetailModel) => new StockTransactionDetailModel(model).toJSON()) : [],
						stockTransactionPerDateTypes: entity.stockTransactionPerDateTypes ? entity.stockTransactionPerDateTypes?.map((model: StockTransactionPerDateTypeModel) => new StockTransactionPerDateTypeModel(model).toJSON()) : [],
						stockTransactionPerDates: entity.stockTransactionPerDates ? entity.stockTransactionPerDates?.map((model: StockTransactionPerDateModel) => new StockTransactionPerDateModel(model).toJSON()) : [],
						vaccinationOrderDetails: entity.vaccinationOrderDetails ? entity.vaccinationOrderDetails?.map((model: VaccinationOrderDetailModel) => new VaccinationOrderDetailModel(model).toJSON()) : [],
						warehouseInitialStockS: entity.warehouseInitialStockS ? entity.warehouseInitialStockS?.map((model: WarehouseInitialStockModel) => new WarehouseInitialStockModel(model).toJSON()) : [],
						warehouseInventories: entity.warehouseInventories ? entity.warehouseInventories?.map((model: WarehouseInventoryModel) => new WarehouseInventoryModel(model).toJSON()) : [],
					},
					persistRelations: queryParams ? queryParams.persistRelations : false,
					// % protected region % [Add any additional variables for create here] off begin
					// % protected region % [Add any additional variables for create here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for create here] off begin
				// % protected region % [Add any additional processing of the result for create here] end

				return {
					targetModel: result.data.warehouse as WarehouseModel,
					// % protected region % [Add any additional info to be passed up for create here] off begin
					// % protected region % [Add any additional info to be passed up for create here] end
				};
			}),
			// % protected region % [Add any additional piping logic for create here] off begin
			// % protected region % [Add any additional piping logic for create here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	createAll(entities: WarehouseModel[], queryParams?: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Warehouse entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($warehouses: [WarehouseInput!]!) {
						warehouse: createAllWarehouse(warehouses: $warehouses) {
							...WarehouseProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for createAll here] off begin
						# % protected region % [Add any additional mutations for createAll here] end
					}

					# % protected region % [Add any additional GraphQL info for createAll here] off begin
					# % protected region % [Add any additional GraphQL info for createAll here] end

					${this.classFragments.properties}
				`,
				variables: {
					warehouses: entities.map(entity => entity.toJSON()),
					// % protected region % [Add any additional variables for createAll here] off begin
					// % protected region % [Add any additional variables for createAll here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for createAll here] off begin
				// % protected region % [Add any additional processing of the result for createAll here] end

				return {
					targetModels: result.data.warehouse as WarehouseModel[],
					// % protected region % [Add any additional info to be passed up for createAll here] off begin
					// % protected region % [Add any additional info to be passed up for createAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for createAll here] off begin
			// % protected region % [Add any additional piping logic for createAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	update(entity: WarehouseModel, queryParams?: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Warehouse entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($warehouse: WarehouseInput!, $persistRelations: Boolean) {
						warehouse: updateWarehouse(warehouse: $warehouse, persistRelations: $persistRelations) {
							...WarehouseProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for update here] off begin
						# % protected region % [Add any additional mutations for update here] end
					}

					# % protected region % [Add any additional GraphQL info for update here] off begin
					# % protected region % [Add any additional GraphQL info for update here] end

					${this.classFragments.properties}
				`,
				variables: {
					warehouse: {
						...entity.toJSON(),
						batchStockBalancesWarehouse: entity.batchStockBalancesWarehouse ? entity.batchStockBalancesWarehouse?.map((model: BatchStockBalanceModel) => new BatchStockBalanceModel(model).toJSON()) : [],
						batchStockBalances: entity.batchStockBalances ? entity.batchStockBalances?.map((model: BatchStockBalancePerDateModel) => new BatchStockBalancePerDateModel(model).toJSON()) : [],
						batchStockTransactionDetails: entity.batchStockTransactionDetails ? entity.batchStockTransactionDetails?.map((model: BatchStockTransactionDetailModel) => new BatchStockTransactionDetailModel(model).toJSON()) : [],
						destinationWarehouses: entity.destinationWarehouses ? entity.destinationWarehouses?.map((model: TransferOrderModel) => new TransferOrderModel(model).toJSON()) : [],
						goodsReceiveNoteBatchs: entity.goodsReceiveNoteBatchs ? entity.goodsReceiveNoteBatchs?.map((model: GoodsReceiveNoteBatchModel) => new GoodsReceiveNoteBatchModel(model).toJSON()) : [],
						goodsReceiveNotes: entity.goodsReceiveNotes ? entity.goodsReceiveNotes?.map((model: GoodsReceiveNoteModel) => new GoodsReceiveNoteModel(model).toJSON()) : [],
						internalOrders: entity.internalOrders ? entity.internalOrders?.map((model: InternalOrderModel) => new InternalOrderModel(model).toJSON()) : [],
						inventoryAdjusmentBatchs: entity.inventoryAdjusmentBatchs ? entity.inventoryAdjusmentBatchs?.map((model: InventoryAdjusmentBatchModel) => new InventoryAdjusmentBatchModel(model).toJSON()) : [],
						inventoryAdjustments: entity.inventoryAdjustments ? entity.inventoryAdjustments?.map((model: InventoryAdjustmentModel) => new InventoryAdjustmentModel(model).toJSON()) : [],
						inventoryBatchCorrections: entity.inventoryBatchCorrections ? entity.inventoryBatchCorrections?.map((model: InventoryBatchCorrectionModel) => new InventoryBatchCorrectionModel(model).toJSON()) : [],
						locations: entity.locations ? entity.locations?.map((model: LocationModel) => new LocationModel(model).toJSON()) : [],
						medicalFees: entity.medicalFees ? entity.medicalFees?.map((model: MedicalFeeModel) => new MedicalFeeModel(model).toJSON()) : [],
						medicationHeaders: entity.medicationHeaders ? entity.medicationHeaders?.map((model: MedicationHeaderModel) => new MedicationHeaderModel(model).toJSON()) : [],
						prescriptionHeaders: entity.prescriptionHeaders ? entity.prescriptionHeaders?.map((model: PrescriptionHeaderModel) => new PrescriptionHeaderModel(model).toJSON()) : [],
						purchaseOrders: entity.purchaseOrders ? entity.purchaseOrders?.map((model: PurchaseOrderModel) => new PurchaseOrderModel(model).toJSON()) : [],
						purchaseRequisitions: entity.purchaseRequisitions ? entity.purchaseRequisitions?.map((model: PurchaseRequisitionModel) => new PurchaseRequisitionModel(model).toJSON()) : [],
						retailPharmacies: entity.retailPharmacies ? entity.retailPharmacies?.map((model: RetailPharmacyModel) => new RetailPharmacyModel(model).toJSON()) : [],
						returnSuppliers: entity.returnSuppliers ? entity.returnSuppliers?.map((model: ReturnSupplierModel) => new ReturnSupplierModel(model).toJSON()) : [],
						sourceWarehouses: entity.sourceWarehouses ? entity.sourceWarehouses?.map((model: TransferOrderModel) => new TransferOrderModel(model).toJSON()) : [],
						stockCatalogues: entity.stockCatalogues ? entity.stockCatalogues?.map((model: StockCatalogueModel) => new StockCatalogueModel(model).toJSON()) : [],
						stockControls: entity.stockControls ? entity.stockControls?.map((model: StockControlModel) => new StockControlModel(model).toJSON()) : [],
						stockTransactionDetails: entity.stockTransactionDetails ? entity.stockTransactionDetails?.map((model: StockTransactionDetailModel) => new StockTransactionDetailModel(model).toJSON()) : [],
						stockTransactionPerDateTypes: entity.stockTransactionPerDateTypes ? entity.stockTransactionPerDateTypes?.map((model: StockTransactionPerDateTypeModel) => new StockTransactionPerDateTypeModel(model).toJSON()) : [],
						stockTransactionPerDates: entity.stockTransactionPerDates ? entity.stockTransactionPerDates?.map((model: StockTransactionPerDateModel) => new StockTransactionPerDateModel(model).toJSON()) : [],
						vaccinationOrderDetails: entity.vaccinationOrderDetails ? entity.vaccinationOrderDetails?.map((model: VaccinationOrderDetailModel) => new VaccinationOrderDetailModel(model).toJSON()) : [],
						warehouseInitialStockS: entity.warehouseInitialStockS ? entity.warehouseInitialStockS?.map((model: WarehouseInitialStockModel) => new WarehouseInitialStockModel(model).toJSON()) : [],
						warehouseInventories: entity.warehouseInventories ? entity.warehouseInventories?.map((model: WarehouseInventoryModel) => new WarehouseInventoryModel(model).toJSON()) : [],
					},
					persistRelations: queryParams ? queryParams.persistRelations : false,
					// % protected region % [Add any additional variables for update here] off begin
					// % protected region % [Add any additional variables for update here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for update here] off begin
				// % protected region % [Add any additional processing of the result for update here] end

				return {
					targetModel: result.data.warehouse as WarehouseModel,
					// % protected region % [Add any additional info to be passed up for update here] off begin
					// % protected region % [Add any additional info to be passed up for update here] end
				};
			}),
			// % protected region % [Add any additional piping logic for update here] off begin
			// % protected region % [Add any additional piping logic for update here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	updateAll(entities: WarehouseModel[], queryParams?: QueryParams): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Warehouse entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($warehouses: [WarehouseInput!]!) {
						warehouse: updateAllWarehouse(warehouses: $warehouses) {
							...WarehouseProperties,
							${this.getExpands(queryParams ? queryParams.expands : [])}
						}

						# % protected region % [Add any additional mutations for updateAll here] off begin
						# % protected region % [Add any additional mutations for updateAll here] end
					}

					# % protected region % [Add any additional GraphQL info for updateAll here] off begin
					# % protected region % [Add any additional GraphQL info for updateAll here] end

					${this.classFragments.properties}
				`,
				variables: {
					warehouses: entities.map(entity => entity.toJSON()),
					// % protected region % [Add any additional variables for updateAll here] off begin
					// % protected region % [Add any additional variables for updateAll here] end
				}
			},
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for updateAll here] off begin
				// % protected region % [Add any additional processing of the result for updateAll here] end

				return {
					targetModels: result.data.warehouse as WarehouseModel[],
					// % protected region % [Add any additional info to be passed up for updateAll here] off begin
					// % protected region % [Add any additional info to be passed up for updateAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for updateAll here] off begin
			// % protected region % [Add any additional piping logic for updateAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	delete(id: string): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Warehouse entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($warehouseId: ID!) {
						warehouseId: deleteWarehouseById(warehouseId: $warehouseId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					warehouseId: id,
					// % protected region % [Add any additional variables for delete here] off begin
					// % protected region % [Add any additional variables for delete here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for delete here] off begin
				// % protected region % [Add any additional processing of the result for delete here] end

				return {
					targetModelId: result.data.warehouseId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Warehouse entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($warehouseIds: [ID!]!){
						deleteWarehouseExcludingIds(warehouseIds: $warehouseIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					warehouseIds: ids,
					// % protected region % [Add any additional variables for delete excluding here] off begin
					// % protected region % [Add any additional variables for delete excluding here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additionsl processing of the result for delete excluding here] off begin
				// % protected region % [Add any additionsl processing of the result for delete excluding here] end
				return {
					targetModelIds: result.data.warehouseIds as string[],
					// % protected region % [Add any additional info to be passed up for delete excluding here] off begin
					// % protected region % [Add any additional info to be passed up for delete excluding here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete excluding here] off begin
			// % protected region % [Add any additional piping logic for delete excluding here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	deleteAll(ids: string[]): Observable<PassableStateConfig<WarehouseModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Warehouse entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($warehouseIds: [ID!]!) {
						warehouseIds: deleteAllWarehouseByIds(warehouseIds: $warehouseIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					warehouseIds: ids,
					// % protected region % [Add any additional variables for deleteAll here] off begin
					// % protected region % [Add any additional variables for deleteAll here] end
				}
			}
		).pipe(
			tap(() => this.toastrService.success(successMessage)),
			map(result => {
				// % protected region % [Add any additional processing of the result for deleteAll here] off begin
				// % protected region % [Add any additional processing of the result for deleteAll here] end

				return {
					targetModelIds: result.data.warehouseIds as string[],
					// % protected region % [Add any additional info to be passed up for deleteAll here] off begin
					// % protected region % [Add any additional info to be passed up for deleteAll here] end
				};
			}),
			// % protected region % [Add any additional piping logic for deleteAll here] off begin
			// % protected region % [Add any additional piping logic for deleteAll here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAudits(): Observable<WarehouseModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query GetAudits {
						audits: warehouseAudits {
							entity {
								...WarehouseProperties
							}
							timestamp
							type
							authorId
							authorFirstName
							authorLastName
						}

						# % protected region % [Add any additional queries for getAudits here] off begin
						# % protected region % [Add any additional queries for getAudits here] end
					}

					# % protected region % [Add any additional GraphQL info for getAudits here] off begin
					# % protected region % [Add any additional GraphQL info for getAudits here] end

					${this.classFragments.properties}
				`,
				// % protected region % [Add any query configuration for getAudits here] off begin
				// % protected region % [Add any query configuration for getAudits here] end
			}
		).pipe(
			map(result => {
				let audits: WarehouseModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new WarehouseModel(audit.entity),
						timestamp: audit.timestamp,
						type: audit.type,
						authorId: audit.authorId,
						authorFirstName: audit.authorFirstName,
						authorLastName: audit.authorLastName
					};
				});

				// % protected region % [Add any additional processing of the audits here] off begin
				// % protected region % [Add any additional processing of the audits here] end

				return audits;
			}),
			// % protected region % [Add any additional piping logic for getAudits here] off begin
			// % protected region % [Add any additional piping logic for getAudits here] end
		);
	}

	/**
	 * @inheritDoc
	 */
	getAuditsByEntityId(id: string): Observable<WarehouseModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<WarehouseModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($warehouseId: ID!) {
						audits: warehouseAuditsByEntityId(warehouseId: $warehouseId) {
							entity {
								...WarehouseProperties
							}
							timestamp
							type
							authorId
							authorFirstName
							authorLastName
						}

						# % protected region % [Add any additional queries for getAuditsByEntityId here] off begin
						# % protected region % [Add any additional queries for getAuditsByEntityId here] end
					},

					# % protected region % [Add any additional GraphQL info for getAuditsByEntityId here] off begin
					# % protected region % [Add any additional GraphQL info for getAuditsByEntityId here] end

					${this.classFragments.properties},

				`,
				// % protected region % [Add any query configuration for getAuditsByEntityId here] off begin
				// % protected region % [Add any query configuration for getAuditsByEntityId here] end
				variables: {
					warehouseId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: WarehouseModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new WarehouseModel(audit.entity),
						timestamp: audit.timestamp,
						type: audit.type,
						authorId: audit.authorId,
						authorFirstName: audit.authorFirstName,
						authorLastName: audit.authorLastName
					};
				});

				// % protected region % [Add any additional processing of the audits of entity here] off begin
				// % protected region % [Add any additional processing of the audits of entity here] end

				return audits;
			}),
			// % protected region % [Add any additional piping logic for getAuditsByEntityId here] off begin
			// % protected region % [Add any additional piping logic for getAuditsByEntityId here] end
		);
	}

	/**
	 * @inheritdoc
	 */
	export(id: string): Observable<PassableStateConfig<WarehouseModel>> {
		const url = environment.API_URL + '/api/warehouse/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<WarehouseModel>> {
		const url = environment.API_URL + '/api/warehouse/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<WarehouseModel>> {
		let apiUrl = environment.API_URL + '/api/warehouse/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<WarehouseModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/warehouse/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Warehouse entities')),

			map(result => {
				return of({
					targetModelIds: result.split(',')
				});
			}),
		);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
