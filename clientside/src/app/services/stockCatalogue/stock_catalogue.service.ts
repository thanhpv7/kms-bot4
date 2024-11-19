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
import {StockCatalogueModel} from '../../models/stockCatalogue/stock_catalogue.model';
import {StockCatalogueModelAudit} from '../../models/stockCatalogue/stock_catalogue.model.state';
import {AuthenticationService} from '../../lib/services/authentication/authentication.service';
import {QueryParams, PassableStateConfig} from '../../lib/services/http/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {BpjsDrugGenericPRBModel} from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import {BpjsPcareDPHOModel} from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model';
import {BatchStockBalanceModel} from 'src/app/models/batchStockBalance/batch_stock_balance.model';
import {BatchStockBalancePerDateModel} from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model';
import {BatchStockTransactionDetailModel} from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model';
import {CatalogueMedicalModel} from 'src/app/models/catalogueMedical/catalogue_medical.model';
import {CatalogueNonMedicalModel} from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model';
import {CatalogueUOMModel} from 'src/app/models/catalogueUOM/catalogue_uom.model';
import {CompoundPrescriptionItemModel} from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import {GoodsReceiveNoteBatchModel} from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import {GoodsReceiveNoteItemModel} from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model';
import {InternalOrderStockDetailModel} from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model';
import {InventoryAdjusmentBatchModel} from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import {InventoryAdjustmentItemModel} from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model';
import {InventoryBatchCorrectionItemModel} from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model';
import {MedicationItemModel} from 'src/app/models/medicationItem/medication_item.model';
import {PrescriptionItemModel} from 'src/app/models/prescriptionItem/prescription_item.model';
import {PurchaseOrderStockDetailModel} from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model';
import {PurchaseRequisitionStockDetailModel} from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import {RetailPharmacyStockDetailModel} from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import {ReturnSupplierStockDetailModel} from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model';
import {StockControlModel} from 'src/app/models/stockControl/stock_control.model';
import {StockTransactionDetailModel} from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import {StockTransactionPerDateModel} from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model';
import {StockTransactionPerDateTypeModel} from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import {SupplierProductDetailModel} from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import {TransferOrderStockDetailModel} from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import {VaccinationOrderDetailModel} from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import {WarehouseModel} from 'src/app/models/warehouse/warehouse.model';
import {WarehouseInitialStockModel} from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import {WarehouseInventoryModel} from 'src/app/models/warehouseInventory/warehouse_inventory.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Stock Catalogue service used to handle all CRUD operations against this entity.
 */
@Injectable({
	providedIn: 'root'
})
export class StockCatalogueService extends AbstractHttpService<StockCatalogueModel, StockCatalogueModelAudit> {
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
			# % protected region % [Modify the StockCatalogueProperties classFragment here] off begin
			fragment StockCatalogueProperties on StockCatalogue {
				...StockCatalogueBaseProperties
				trackable
				stockCode
				stockName
				description
				weight
				weightUnit
				volume
				volumeUnit
				stockGroup
				stockCategory
				approvalStatus
				approvedBy
				approvalDate
				approvalNotes
				quantityPerPack
				uoi
				lastBuyingPriceVATExcludeCurrency
				lastBuyingPriceVATExcludePrice
				lastBuyingPriceVATIncludeCurrency
				lastBuyingPriceVATIncludePrice
				medicalType
				stockCategoryVATExcluded
				stockCategoryVATIncluded
				onHandQty
				averageCost
				totalCost
				salesAccount
				inventoryAccount
				purchaseAccount
				lupSupplierName
				lupUnitPrice
				lupDiscount
				lupItemPrice
				lupLastPurchaseDate
				lppSupplierName
				lppUnitPrice
				lppDiscount
				lppItemPrice
				lppLastPurchaseDate
			}
			# % protected region % [Modify the StockCatalogueProperties classFragment here] end
			${super.fragments('StockCatalogue').properties}
		`,
		// % protected region % [Add any additional fragments here] off begin
		// % protected region % [Add any additional fragments here] end
	};

	/**
	 * @inheritDoc
	 */
	count(): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for count here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for count here] end

		return  this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query Count {
						totalCount: countStockCatalogues

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
	getAll(): Observable<PassableStateConfig<StockCatalogueModel>> {
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
	get(id: string, queryParams?: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for get here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for get here] end

		const expands = queryParams && queryParams.expands ? queryParams.expands : [];

		return this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query Get($id: ID!) {
						StockCatalogueById: stockCatalogueById(id: $id) {
							...StockCatalogueProperties
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
					targetModel: result.data.StockCatalogueById as StockCatalogueModel,
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
	getWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getWithQuery here] end

		return this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query GetWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!], $where: [[Where!]!]) {
						stockCatalogues: stockCatalogues(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy, where: $where) {
							...StockCatalogueProperties
							${this.getExpands(queryParams.expands)}
						}

						totalCount: countStockCatalogues(where: $where)

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
					targetModels: result.data.stockCatalogues as StockCatalogueModel[],
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
	getLastWithQuery(queryParams: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getLastWithQuery here] end

		return this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query GetLastWithQuery($pageIndex: Int, $pageSize: Int, $orderBy: [OrderBy!]!) {
						stockCatalogues: lastStockCatalogues(pageIndex: $pageIndex, pageSize: $pageSize, orderBy: $orderBy) {
							...StockCatalogueProperties
						}

						totalCount: countStockCatalogues

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
					targetModels: result.data.stockCatalogues as StockCatalogueModel[],
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
	create(entity: StockCatalogueModel, queryParams?: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for create here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for create here] end

		// % protected region % [Customise the success message for create here] off begin
		const successMessage = 'Created Stock Catalogue entity successfully';
		// % protected region % [Customise the success message for create here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Create($stockCatalogue: StockCatalogueInput!, $persistRelations: Boolean) {
						stockCatalogue: createStockCatalogue(stockCatalogue: $stockCatalogue, persistRelations: $persistRelations) {
							...StockCatalogueProperties,
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
					stockCatalogue: {
						...entity.toJSON(),
						bpjsDrugGenericPRB: entity.bpjsDrugGenericPRB ? new BpjsDrugGenericPRBModel(entity.bpjsDrugGenericPRB).toJSON() : undefined,
						bpjsPcareDPHO: entity.bpjsPcareDPHO ? new BpjsPcareDPHOModel(entity.bpjsPcareDPHO).toJSON() : undefined,
						stockCatalogueMedical: entity.stockCatalogueMedical ? new CatalogueMedicalModel(entity.stockCatalogueMedical).toJSON() : undefined,
						stockCatalogueNonMedical: entity.stockCatalogueNonMedical ? new CatalogueNonMedicalModel(entity.stockCatalogueNonMedical).toJSON() : undefined,
						warehouse: entity.warehouse ? new WarehouseModel(entity.warehouse).toJSON() : undefined,
						batchStockBalancesCatalogue: entity.batchStockBalancesCatalogue ? entity.batchStockBalancesCatalogue?.map((model: BatchStockBalanceModel) => new BatchStockBalanceModel(model).toJSON()) : [],
						batchStockBalances: entity.batchStockBalances ? entity.batchStockBalances?.map((model: BatchStockBalancePerDateModel) => new BatchStockBalancePerDateModel(model).toJSON()) : [],
						batchStockTransactionDetails: entity.batchStockTransactionDetails ? entity.batchStockTransactionDetails?.map((model: BatchStockTransactionDetailModel) => new BatchStockTransactionDetailModel(model).toJSON()) : [],
						catalogueUOMs: entity.catalogueUOMs ? entity.catalogueUOMs?.map((model: CatalogueUOMModel) => new CatalogueUOMModel(model).toJSON()) : [],
						compoundPrescriptionItems: entity.compoundPrescriptionItems ? entity.compoundPrescriptionItems?.map((model: CompoundPrescriptionItemModel) => new CompoundPrescriptionItemModel(model).toJSON()) : [],
						goodsReceiveNoteBatchs: entity.goodsReceiveNoteBatchs ? entity.goodsReceiveNoteBatchs?.map((model: GoodsReceiveNoteBatchModel) => new GoodsReceiveNoteBatchModel(model).toJSON()) : [],
						goodsReceiveNoteItems: entity.goodsReceiveNoteItems ? entity.goodsReceiveNoteItems?.map((model: GoodsReceiveNoteItemModel) => new GoodsReceiveNoteItemModel(model).toJSON()) : [],
						internalOrderStockDetails: entity.internalOrderStockDetails ? entity.internalOrderStockDetails?.map((model: InternalOrderStockDetailModel) => new InternalOrderStockDetailModel(model).toJSON()) : [],
						inventoryAdjusmentBatchs: entity.inventoryAdjusmentBatchs ? entity.inventoryAdjusmentBatchs?.map((model: InventoryAdjusmentBatchModel) => new InventoryAdjusmentBatchModel(model).toJSON()) : [],
						inventoryAdjustmentItems: entity.inventoryAdjustmentItems ? entity.inventoryAdjustmentItems?.map((model: InventoryAdjustmentItemModel) => new InventoryAdjustmentItemModel(model).toJSON()) : [],
						inventoryBatchCorrectionItems: entity.inventoryBatchCorrectionItems ? entity.inventoryBatchCorrectionItems?.map((model: InventoryBatchCorrectionItemModel) => new InventoryBatchCorrectionItemModel(model).toJSON()) : [],
						medicationItems: entity.medicationItems ? entity.medicationItems?.map((model: MedicationItemModel) => new MedicationItemModel(model).toJSON()) : [],
						prescriptionItem: entity.prescriptionItem ? entity.prescriptionItem?.map((model: PrescriptionItemModel) => new PrescriptionItemModel(model).toJSON()) : [],
						purchaseOrderStockDetails: entity.purchaseOrderStockDetails ? entity.purchaseOrderStockDetails?.map((model: PurchaseOrderStockDetailModel) => new PurchaseOrderStockDetailModel(model).toJSON()) : [],
						purchaseRequisitionStockDetails: entity.purchaseRequisitionStockDetails ? entity.purchaseRequisitionStockDetails?.map((model: PurchaseRequisitionStockDetailModel) => new PurchaseRequisitionStockDetailModel(model).toJSON()) : [],
						retailPharmacyStockDetails: entity.retailPharmacyStockDetails ? entity.retailPharmacyStockDetails?.map((model: RetailPharmacyStockDetailModel) => new RetailPharmacyStockDetailModel(model).toJSON()) : [],
						returnSupplierStockDetails: entity.returnSupplierStockDetails ? entity.returnSupplierStockDetails?.map((model: ReturnSupplierStockDetailModel) => new ReturnSupplierStockDetailModel(model).toJSON()) : [],
						stockControls: entity.stockControls ? entity.stockControls?.map((model: StockControlModel) => new StockControlModel(model).toJSON()) : [],
						stockTransactionDetails: entity.stockTransactionDetails ? entity.stockTransactionDetails?.map((model: StockTransactionDetailModel) => new StockTransactionDetailModel(model).toJSON()) : [],
						stockTransactionPerDateTypes: entity.stockTransactionPerDateTypes ? entity.stockTransactionPerDateTypes?.map((model: StockTransactionPerDateTypeModel) => new StockTransactionPerDateTypeModel(model).toJSON()) : [],
						stockTransactionPerDates: entity.stockTransactionPerDates ? entity.stockTransactionPerDates?.map((model: StockTransactionPerDateModel) => new StockTransactionPerDateModel(model).toJSON()) : [],
						supplierProductDetails: entity.supplierProductDetails ? entity.supplierProductDetails?.map((model: SupplierProductDetailModel) => new SupplierProductDetailModel(model).toJSON()) : [],
						transferOrderStockDetails: entity.transferOrderStockDetails ? entity.transferOrderStockDetails?.map((model: TransferOrderStockDetailModel) => new TransferOrderStockDetailModel(model).toJSON()) : [],
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
					targetModel: result.data.stockCatalogue as StockCatalogueModel,
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
	createAll(entities: StockCatalogueModel[], queryParams?: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for createAll here] end

		// % protected region % [Customise the success message for createAll here] off begin
		const successMessage = 'Created Multiple Stock Catalogue entities successfully';
		// % protected region % [Customise the success message for createAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation createAll($stockCatalogues: [StockCatalogueInput!]!) {
						stockCatalogue: createAllStockCatalogue(stockCatalogues: $stockCatalogues) {
							...StockCatalogueProperties,
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
					stockCatalogues: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.stockCatalogue as StockCatalogueModel[],
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
	update(entity: StockCatalogueModel, queryParams?: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for update here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for update here] end

		// % protected region % [Customise the success message for update here] off begin
		const successMessage = 'Updated Stock Catalogue entity successfully';
		// % protected region % [Customise the success message for update here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Update($stockCatalogue: StockCatalogueInput!, $persistRelations: Boolean) {
						stockCatalogue: updateStockCatalogue(stockCatalogue: $stockCatalogue, persistRelations: $persistRelations) {
							...StockCatalogueProperties,
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
					stockCatalogue: {
						...entity.toJSON(),
						bpjsDrugGenericPRB: entity.bpjsDrugGenericPRB ? new BpjsDrugGenericPRBModel(entity.bpjsDrugGenericPRB).toJSON() : undefined,
						bpjsPcareDPHO: entity.bpjsPcareDPHO ? new BpjsPcareDPHOModel(entity.bpjsPcareDPHO).toJSON() : undefined,
						stockCatalogueMedical: entity.stockCatalogueMedical ? new CatalogueMedicalModel(entity.stockCatalogueMedical).toJSON() : undefined,
						stockCatalogueNonMedical: entity.stockCatalogueNonMedical ? new CatalogueNonMedicalModel(entity.stockCatalogueNonMedical).toJSON() : undefined,
						warehouse: entity.warehouse ? new WarehouseModel(entity.warehouse).toJSON() : undefined,
						batchStockBalancesCatalogue: entity.batchStockBalancesCatalogue ? entity.batchStockBalancesCatalogue?.map((model: BatchStockBalanceModel) => new BatchStockBalanceModel(model).toJSON()) : [],
						batchStockBalances: entity.batchStockBalances ? entity.batchStockBalances?.map((model: BatchStockBalancePerDateModel) => new BatchStockBalancePerDateModel(model).toJSON()) : [],
						batchStockTransactionDetails: entity.batchStockTransactionDetails ? entity.batchStockTransactionDetails?.map((model: BatchStockTransactionDetailModel) => new BatchStockTransactionDetailModel(model).toJSON()) : [],
						catalogueUOMs: entity.catalogueUOMs ? entity.catalogueUOMs?.map((model: CatalogueUOMModel) => new CatalogueUOMModel(model).toJSON()) : [],
						compoundPrescriptionItems: entity.compoundPrescriptionItems ? entity.compoundPrescriptionItems?.map((model: CompoundPrescriptionItemModel) => new CompoundPrescriptionItemModel(model).toJSON()) : [],
						goodsReceiveNoteBatchs: entity.goodsReceiveNoteBatchs ? entity.goodsReceiveNoteBatchs?.map((model: GoodsReceiveNoteBatchModel) => new GoodsReceiveNoteBatchModel(model).toJSON()) : [],
						goodsReceiveNoteItems: entity.goodsReceiveNoteItems ? entity.goodsReceiveNoteItems?.map((model: GoodsReceiveNoteItemModel) => new GoodsReceiveNoteItemModel(model).toJSON()) : [],
						internalOrderStockDetails: entity.internalOrderStockDetails ? entity.internalOrderStockDetails?.map((model: InternalOrderStockDetailModel) => new InternalOrderStockDetailModel(model).toJSON()) : [],
						inventoryAdjusmentBatchs: entity.inventoryAdjusmentBatchs ? entity.inventoryAdjusmentBatchs?.map((model: InventoryAdjusmentBatchModel) => new InventoryAdjusmentBatchModel(model).toJSON()) : [],
						inventoryAdjustmentItems: entity.inventoryAdjustmentItems ? entity.inventoryAdjustmentItems?.map((model: InventoryAdjustmentItemModel) => new InventoryAdjustmentItemModel(model).toJSON()) : [],
						inventoryBatchCorrectionItems: entity.inventoryBatchCorrectionItems ? entity.inventoryBatchCorrectionItems?.map((model: InventoryBatchCorrectionItemModel) => new InventoryBatchCorrectionItemModel(model).toJSON()) : [],
						medicationItems: entity.medicationItems ? entity.medicationItems?.map((model: MedicationItemModel) => new MedicationItemModel(model).toJSON()) : [],
						prescriptionItem: entity.prescriptionItem ? entity.prescriptionItem?.map((model: PrescriptionItemModel) => new PrescriptionItemModel(model).toJSON()) : [],
						purchaseOrderStockDetails: entity.purchaseOrderStockDetails ? entity.purchaseOrderStockDetails?.map((model: PurchaseOrderStockDetailModel) => new PurchaseOrderStockDetailModel(model).toJSON()) : [],
						purchaseRequisitionStockDetails: entity.purchaseRequisitionStockDetails ? entity.purchaseRequisitionStockDetails?.map((model: PurchaseRequisitionStockDetailModel) => new PurchaseRequisitionStockDetailModel(model).toJSON()) : [],
						retailPharmacyStockDetails: entity.retailPharmacyStockDetails ? entity.retailPharmacyStockDetails?.map((model: RetailPharmacyStockDetailModel) => new RetailPharmacyStockDetailModel(model).toJSON()) : [],
						returnSupplierStockDetails: entity.returnSupplierStockDetails ? entity.returnSupplierStockDetails?.map((model: ReturnSupplierStockDetailModel) => new ReturnSupplierStockDetailModel(model).toJSON()) : [],
						stockControls: entity.stockControls ? entity.stockControls?.map((model: StockControlModel) => new StockControlModel(model).toJSON()) : [],
						stockTransactionDetails: entity.stockTransactionDetails ? entity.stockTransactionDetails?.map((model: StockTransactionDetailModel) => new StockTransactionDetailModel(model).toJSON()) : [],
						stockTransactionPerDateTypes: entity.stockTransactionPerDateTypes ? entity.stockTransactionPerDateTypes?.map((model: StockTransactionPerDateTypeModel) => new StockTransactionPerDateTypeModel(model).toJSON()) : [],
						stockTransactionPerDates: entity.stockTransactionPerDates ? entity.stockTransactionPerDates?.map((model: StockTransactionPerDateModel) => new StockTransactionPerDateModel(model).toJSON()) : [],
						supplierProductDetails: entity.supplierProductDetails ? entity.supplierProductDetails?.map((model: SupplierProductDetailModel) => new SupplierProductDetailModel(model).toJSON()) : [],
						transferOrderStockDetails: entity.transferOrderStockDetails ? entity.transferOrderStockDetails?.map((model: TransferOrderStockDetailModel) => new TransferOrderStockDetailModel(model).toJSON()) : [],
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
					targetModel: result.data.stockCatalogue as StockCatalogueModel,
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
	updateAll(entities: StockCatalogueModel[], queryParams?: QueryParams): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for updateAll here] end

		// % protected region % [Customise the success message for updateAll here] off begin
		const successMessage = 'Update Multiple Stock Catalogue entities successfully';
		// % protected region % [Customise the success message for updateAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation updateAll($stockCatalogues: [StockCatalogueInput!]!) {
						stockCatalogue: updateAllStockCatalogue(stockCatalogues: $stockCatalogues) {
							...StockCatalogueProperties,
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
					stockCatalogues: entities.map(entity => entity.toJSON()),
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
					targetModels: result.data.stockCatalogue as StockCatalogueModel[],
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
	delete(id: string): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete here] end

		// % protected region % [Customise the success message for delete here] off begin
		const successMessage = 'Deleted Stock Catalogue entity successfully';
		// % protected region % [Customise the success message for delete here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation Delete($stockCatalogueId: ID!) {
						stockCatalogueId: deleteStockCatalogueById(stockCatalogueId: $stockCatalogueId)

						# % protected region % [Add any additional mutations for delete here] off begin
						# % protected region % [Add any additional mutations for delete here] end
					}

					# % protected region % [Add any additional GraphQL info for delete here] off begin
					# % protected region % [Add any additional GraphQL info for delete here] end
				`,
				variables: {
					stockCatalogueId: id,
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
					targetModelId: result.data.stockCatalogueId as string,
					// % protected region % [Add any additional info to be passed up for delete here] off begin
					// % protected region % [Add any additional info to be passed up for delete here] end
				};
			}),
			// % protected region % [Add any additional piping logic for delete here] off begin
			// % protected region % [Add any additional piping logic for delete here] end
		);
	}

	deleteExcludingIds(ids: string[]): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for delete excluding here] end

		// % protected region % [Customise the success message for delete excluding here] off begin
		const successMessage = 'Deleted selected Stock Catalogue entities successfully';
		// % protected region % [Customise the success message for delete excluding here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation deleteAll($stockCatalogueIds: [ID!]!){
						deleteStockCatalogueExcludingIds(stockCatalogueIds: $stockCatalogueIds)

						# % protected region % [Add any additional mutations for delete excluding here] off begin
						# % protected region % [Add any additional mutations for delete excluding here] end
					}

					# % protected region % [Add any additional GraphQL info for delete excluding here] off begin
					# % protected region % [Add any additional GraphQL info for delete excluding here] end
				`,
				variables: {
					stockCatalogueIds: ids,
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
					targetModelIds: result.data.stockCatalogueIds as string[],
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
	deleteAll(ids: string[]): Observable<PassableStateConfig<StockCatalogueModel>> {
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for deleteAll here] end

		// % protected region % [Customise the success message for deleteAll here] off begin
		const successMessage = 'Deleted selected Stock Catalogue entities successfully';
		// % protected region % [Customise the success message for deleteAll here] end

		return this.apollo.mutate<any>(
			{
				mutation: gql`
					mutation DeleteAll($stockCatalogueIds: [ID!]!) {
						stockCatalogueIds: deleteAllStockCatalogueByIds(stockCatalogueIds: $stockCatalogueIds)

						# % protected region % [Add any additional mutations for deleteAll here] off begin
						# % protected region % [Add any additional mutations for deleteAll here] end
					}

					# % protected region % [Add any additional GraphQL info for deleteAll here] off begin
					# % protected region % [Add any additional GraphQL info for deleteAll here] end
				`,
				variables: {
					stockCatalogueIds: ids,
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
					targetModelIds: result.data.stockCatalogueIds as string[],
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
	getAudits(): Observable<StockCatalogueModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAudits here] end

		return this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query GetAudits {
						audits: stockCatalogueAudits {
							entity {
								...StockCatalogueProperties
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
				let audits: StockCatalogueModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new StockCatalogueModel(audit.entity),
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
	getAuditsByEntityId(id: string): Observable<StockCatalogueModelAudit[]> {
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] off begin
		// % protected region % [Add any additional pre-processing before sending the query for getAuditsByEntityId here] end

		return this.apollo.query<PassableStateConfig<StockCatalogueModel>>(
			{
				query: gql`
					query GetAuditsByEntityId($stockCatalogueId: ID!) {
						audits: stockCatalogueAuditsByEntityId(stockCatalogueId: $stockCatalogueId) {
							entity {
								...StockCatalogueProperties
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
					stockCatalogueId: id,
					// % protected region % [Add any additional variables for getAuditsByEntityId here] off begin
					// % protected region % [Add any additional variables for getAuditsByEntityId here] end
				}
			}
		).pipe(
			map(result => {
				let audits: StockCatalogueModelAudit[] = result.data.audits.map(audit => {
					return {
						entity: new StockCatalogueModel(audit.entity),
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
	export(id: string): Observable<PassableStateConfig<StockCatalogueModel>> {
		const url = environment.API_URL + '/api/stockcatalogue/export';
		const idParams = '?id=' + id;

		window.open(url + idParams);
		return of({
			targetModelId: id
		});
	}

	/**
	 * @inheritdoc
	 */
	exportAll(ids: string[]): Observable<PassableStateConfig<StockCatalogueModel>> {
		const url = environment.API_URL + '/api/stockcatalogue/export';
		const idParams = '?ids=' + ids.join();

		window.open(url + idParams);

		return of({
			targetModelIds: ids
		});
	}

	exportModelsExcludingIds(ids: string[]): Observable<PassableStateConfig<StockCatalogueModel>> {
		let apiUrl = environment.API_URL + '/api/stockcatalogue/export-excluding?ids=';

		if (ids.length > 0) {
			const idParams = ids.join();
			apiUrl = apiUrl.concat(idParams);
		}

		window.open(apiUrl);
		return of({
			targetModelIds: ids
		});
	}

	importModels(file: File): Observable<PassableStateConfig<StockCatalogueModel>> {
		const requestData: FormData = new FormData();
		requestData.append('file', file);

		let apiUrl = environment.API_URL + '/api/stockcatalogue/import-csv';

		// % protected region % [Overwrite the url of the import api here] off begin
		// % protected region % [Overwrite the url of the import api here] end

		return this.http.post(apiUrl, requestData, {withCredentials: true, responseType: 'text'}).pipe(
			tap(result => this.toastrService.success('Successfully Imported ' + result.split(',').length + ' Stock Catalogue entities')),

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
