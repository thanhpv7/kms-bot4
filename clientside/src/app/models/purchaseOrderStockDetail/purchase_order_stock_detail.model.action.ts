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

import {Action} from '@ngrx/store';
import {PurchaseOrderStockDetailModel} from './purchase_order_stock_detail.model';
import {PurchaseOrderStockDetailModelAudit} from './purchase_order_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Purchase Order Stock Detail model actions to be dispatched by NgRx.
 */
export enum PurchaseOrderStockDetailModelActionTypes {
	CREATE_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Create PurchaseOrderStockDetailModel',
	CREATE_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create PurchaseOrderStockDetailModel successfully',
	CREATE_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create PurchaseOrderStockDetailModel failed',

	CREATE_ALL_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Create All PurchaseOrderStockDetailModel',
	CREATE_ALL_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create All PurchaseOrderStockDetailModel successfully',
	CREATE_ALL_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create All PurchaseOrderStockDetailModel failed',

	DELETE_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Delete PurchaseOrderStockDetailModel',
	DELETE_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete PurchaseOrderStockDetailModel successfully',
	DELETE_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete PurchaseOrderStockDetailModel failed',


	DELETE_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete PurchaseOrderStockDetailModels Excluding Ids',
	DELETE_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete PurchaseOrderStockDetailModels Excluding Ids successfully',
	DELETE_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PurchaseOrderStockDetailModels Excluding Ids failed',

	DELETE_ALL_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Delete all PurchaseOrderStockDetailModels',
	DELETE_ALL_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete all PurchaseOrderStockDetailModels successfully',
	DELETE_ALL_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete all PurchaseOrderStockDetailModels failed',

	UPDATE_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Update PurchaseOrderStockDetailModel',
	UPDATE_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update PurchaseOrderStockDetailModel successfully',
	UPDATE_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update PurchaseOrderStockDetailModel failed',

	UPDATE_ALL_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Update all PurchaseOrderStockDetailModel',
	UPDATE_ALL_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update all PurchaseOrderStockDetailModel successfully',
	UPDATE_ALL_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update all PurchaseOrderStockDetailModel failed',

	FETCH_PURCHASE_ORDER_STOCK_DETAIL= '[ENTITY] Fetch PurchaseOrderStockDetailModel',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch PurchaseOrderStockDetailModel successfully',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch PurchaseOrderStockDetailModel failed',

	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch PurchaseOrderStockDetailModel audit',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch PurchaseOrderStockDetailModel audit successfully',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch PurchaseOrderStockDetailModel audit failed',

	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PurchaseOrderStockDetailModel audits by entity id',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PurchaseOrderStockDetailModel audits by entity id successfully',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PurchaseOrderStockDetailModel audits by entity id failed',

	FETCH_ALL_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Fetch all PurchaseOrderStockDetailModel',
	FETCH_ALL_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch all PurchaseOrderStockDetailModel successfully',
	FETCH_ALL_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all PurchaseOrderStockDetailModel failed',

	FETCH_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch PurchaseOrderStockDetailModel with query',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch PurchaseOrderStockDetailModel with query successfully',
	FETCH_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch PurchaseOrderStockDetailModel with query failed',

	FETCH_LAST_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last PurchaseOrderStockDetailModel with query',
	FETCH_LAST_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last PurchaseOrderStockDetailModel with query successfully',
	FETCH_LAST_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last PurchaseOrderStockDetailModel with query failed',

	EXPORT_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Export PurchaseOrderStockDetailModel',
	EXPORT_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export PurchaseOrderStockDetailModel successfully',
	EXPORT_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export PurchaseOrderStockDetailModel failed',

	EXPORT_ALL_PURCHASE_ORDER_STOCK_DETAIL = '[ENTITY] Export All PurchaseOrderStockDetailModels',
	EXPORT_ALL_PURCHASE_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export All PurchaseOrderStockDetailModels successfully',
	EXPORT_ALL_PURCHASE_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export All PurchaseOrderStockDetailModels failed',

	EXPORT_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export PurchaseOrderStockDetailModels excluding Ids',
	EXPORT_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export PurchaseOrderStockDetailModel excluding Ids successfully',
	EXPORT_PURCHASE_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export PurchaseOrderStockDetailModel excluding Ids failed',

	COUNT_PURCHASE_ORDER_STOCK_DETAILS = '[ENTITY] Fetch number of PurchaseOrderStockDetailModel records',
	COUNT_PURCHASE_ORDER_STOCK_DETAILS_OK = '[ENTITY] Fetch number of PurchaseOrderStockDetailModel records successfully ',
	COUNT_PURCHASE_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of PurchaseOrderStockDetailModel records failed',

	IMPORT_PURCHASE_ORDER_STOCK_DETAILS = '[ENTITY] Import PurchaseOrderStockDetailModels',
	IMPORT_PURCHASE_ORDER_STOCK_DETAILS_OK = '[ENTITY] Import PurchaseOrderStockDetailModels successfully',
	IMPORT_PURCHASE_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Import PurchaseOrderStockDetailModels fail',


	INITIALISE_PURCHASE_ORDER_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PurchaseOrderStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePurchaseOrderStockDetailAction implements Action {
	readonly className: string = 'PurchaseOrderStockDetailModel';

	abstract readonly type: string;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	protected constructor(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		public readonly afterwardActions: Action[] = []
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}
}

export class PurchaseOrderStockDetailAction extends BasePurchaseOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailAction here] end
}

export class PurchaseOrderStockDetailActionOK extends BasePurchaseOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PurchaseOrderStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailActionOK here] end
}

export class PurchaseOrderStockDetailActionFail extends BasePurchaseOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PurchaseOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderStockDetailActionFail here] end
}

export function isPurchaseOrderStockDetailModelAction(e: any): e is BasePurchaseOrderStockDetailAction {
	return Object.values(PurchaseOrderStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
