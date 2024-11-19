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
import {PurchaseRequisitionStockDetailModel} from './purchase_requisition_stock_detail.model';
import {PurchaseRequisitionStockDetailModelAudit} from './purchase_requisition_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Purchase Requisition Stock Detail model actions to be dispatched by NgRx.
 */
export enum PurchaseRequisitionStockDetailModelActionTypes {
	CREATE_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Create PurchaseRequisitionStockDetailModel',
	CREATE_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Create PurchaseRequisitionStockDetailModel successfully',
	CREATE_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Create PurchaseRequisitionStockDetailModel failed',

	CREATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Create All PurchaseRequisitionStockDetailModel',
	CREATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Create All PurchaseRequisitionStockDetailModel successfully',
	CREATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Create All PurchaseRequisitionStockDetailModel failed',

	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Delete PurchaseRequisitionStockDetailModel',
	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Delete PurchaseRequisitionStockDetailModel successfully',
	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Delete PurchaseRequisitionStockDetailModel failed',


	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete PurchaseRequisitionStockDetailModels Excluding Ids',
	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete PurchaseRequisitionStockDetailModels Excluding Ids successfully',
	DELETE_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PurchaseRequisitionStockDetailModels Excluding Ids failed',

	DELETE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Delete all PurchaseRequisitionStockDetailModels',
	DELETE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Delete all PurchaseRequisitionStockDetailModels successfully',
	DELETE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Delete all PurchaseRequisitionStockDetailModels failed',

	UPDATE_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Update PurchaseRequisitionStockDetailModel',
	UPDATE_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Update PurchaseRequisitionStockDetailModel successfully',
	UPDATE_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Update PurchaseRequisitionStockDetailModel failed',

	UPDATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Update all PurchaseRequisitionStockDetailModel',
	UPDATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Update all PurchaseRequisitionStockDetailModel successfully',
	UPDATE_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Update all PurchaseRequisitionStockDetailModel failed',

	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL= '[ENTITY] Fetch PurchaseRequisitionStockDetailModel',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel successfully',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel failed',

	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audit',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audit successfully',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audit failed',

	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audits by entity id',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audits by entity id successfully',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel audits by entity id failed',

	FETCH_ALL_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Fetch all PurchaseRequisitionStockDetailModel',
	FETCH_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Fetch all PurchaseRequisitionStockDetailModel successfully',
	FETCH_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all PurchaseRequisitionStockDetailModel failed',

	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel with query',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel with query successfully',
	FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch PurchaseRequisitionStockDetailModel with query failed',

	FETCH_LAST_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last PurchaseRequisitionStockDetailModel with query',
	FETCH_LAST_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last PurchaseRequisitionStockDetailModel with query successfully',
	FETCH_LAST_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last PurchaseRequisitionStockDetailModel with query failed',

	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Export PurchaseRequisitionStockDetailModel',
	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Export PurchaseRequisitionStockDetailModel successfully',
	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Export PurchaseRequisitionStockDetailModel failed',

	EXPORT_ALL_PURCHASE_REQUISITION_STOCK_DETAIL = '[ENTITY] Export All PurchaseRequisitionStockDetailModels',
	EXPORT_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_OK = '[ENTITY] Export All PurchaseRequisitionStockDetailModels successfully',
	EXPORT_ALL_PURCHASE_REQUISITION_STOCK_DETAIL_FAIL = '[ENTITY] Export All PurchaseRequisitionStockDetailModels failed',

	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export PurchaseRequisitionStockDetailModels excluding Ids',
	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export PurchaseRequisitionStockDetailModel excluding Ids successfully',
	EXPORT_PURCHASE_REQUISITION_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export PurchaseRequisitionStockDetailModel excluding Ids failed',

	COUNT_PURCHASE_REQUISITION_STOCK_DETAILS = '[ENTITY] Fetch number of PurchaseRequisitionStockDetailModel records',
	COUNT_PURCHASE_REQUISITION_STOCK_DETAILS_OK = '[ENTITY] Fetch number of PurchaseRequisitionStockDetailModel records successfully ',
	COUNT_PURCHASE_REQUISITION_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of PurchaseRequisitionStockDetailModel records failed',

	IMPORT_PURCHASE_REQUISITION_STOCK_DETAILS = '[ENTITY] Import PurchaseRequisitionStockDetailModels',
	IMPORT_PURCHASE_REQUISITION_STOCK_DETAILS_OK = '[ENTITY] Import PurchaseRequisitionStockDetailModels successfully',
	IMPORT_PURCHASE_REQUISITION_STOCK_DETAILS_FAIL = '[ENTITY] Import PurchaseRequisitionStockDetailModels fail',


	INITIALISE_PURCHASE_REQUISITION_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PurchaseRequisitionStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePurchaseRequisitionStockDetailAction implements Action {
	readonly className: string = 'PurchaseRequisitionStockDetailModel';

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

export class PurchaseRequisitionStockDetailAction extends BasePurchaseRequisitionStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseRequisitionStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailAction here] end
}

export class PurchaseRequisitionStockDetailActionOK extends BasePurchaseRequisitionStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseRequisitionStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PurchaseRequisitionStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailActionOK here] end
}

export class PurchaseRequisitionStockDetailActionFail extends BasePurchaseRequisitionStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PurchaseRequisitionStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionStockDetailActionFail here] end
}

export function isPurchaseRequisitionStockDetailModelAction(e: any): e is BasePurchaseRequisitionStockDetailAction {
	return Object.values(PurchaseRequisitionStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
