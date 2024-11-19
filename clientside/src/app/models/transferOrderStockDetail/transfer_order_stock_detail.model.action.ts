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
import {TransferOrderStockDetailModel} from './transfer_order_stock_detail.model';
import {TransferOrderStockDetailModelAudit} from './transfer_order_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Transfer Order Stock Detail model actions to be dispatched by NgRx.
 */
export enum TransferOrderStockDetailModelActionTypes {
	CREATE_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Create TransferOrderStockDetailModel',
	CREATE_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create TransferOrderStockDetailModel successfully',
	CREATE_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create TransferOrderStockDetailModel failed',

	CREATE_ALL_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Create All TransferOrderStockDetailModel',
	CREATE_ALL_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create All TransferOrderStockDetailModel successfully',
	CREATE_ALL_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create All TransferOrderStockDetailModel failed',

	DELETE_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Delete TransferOrderStockDetailModel',
	DELETE_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete TransferOrderStockDetailModel successfully',
	DELETE_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete TransferOrderStockDetailModel failed',


	DELETE_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete TransferOrderStockDetailModels Excluding Ids',
	DELETE_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete TransferOrderStockDetailModels Excluding Ids successfully',
	DELETE_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TransferOrderStockDetailModels Excluding Ids failed',

	DELETE_ALL_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Delete all TransferOrderStockDetailModels',
	DELETE_ALL_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete all TransferOrderStockDetailModels successfully',
	DELETE_ALL_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete all TransferOrderStockDetailModels failed',

	UPDATE_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Update TransferOrderStockDetailModel',
	UPDATE_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update TransferOrderStockDetailModel successfully',
	UPDATE_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update TransferOrderStockDetailModel failed',

	UPDATE_ALL_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Update all TransferOrderStockDetailModel',
	UPDATE_ALL_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update all TransferOrderStockDetailModel successfully',
	UPDATE_ALL_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update all TransferOrderStockDetailModel failed',

	FETCH_TRANSFER_ORDER_STOCK_DETAIL= '[ENTITY] Fetch TransferOrderStockDetailModel',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch TransferOrderStockDetailModel successfully',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch TransferOrderStockDetailModel failed',

	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch TransferOrderStockDetailModel audit',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch TransferOrderStockDetailModel audit successfully',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch TransferOrderStockDetailModel audit failed',

	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TransferOrderStockDetailModel audits by entity id',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TransferOrderStockDetailModel audits by entity id successfully',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TransferOrderStockDetailModel audits by entity id failed',

	FETCH_ALL_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Fetch all TransferOrderStockDetailModel',
	FETCH_ALL_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch all TransferOrderStockDetailModel successfully',
	FETCH_ALL_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all TransferOrderStockDetailModel failed',

	FETCH_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch TransferOrderStockDetailModel with query',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch TransferOrderStockDetailModel with query successfully',
	FETCH_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch TransferOrderStockDetailModel with query failed',

	FETCH_LAST_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last TransferOrderStockDetailModel with query',
	FETCH_LAST_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last TransferOrderStockDetailModel with query successfully',
	FETCH_LAST_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last TransferOrderStockDetailModel with query failed',

	EXPORT_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Export TransferOrderStockDetailModel',
	EXPORT_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export TransferOrderStockDetailModel successfully',
	EXPORT_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export TransferOrderStockDetailModel failed',

	EXPORT_ALL_TRANSFER_ORDER_STOCK_DETAIL = '[ENTITY] Export All TransferOrderStockDetailModels',
	EXPORT_ALL_TRANSFER_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export All TransferOrderStockDetailModels successfully',
	EXPORT_ALL_TRANSFER_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export All TransferOrderStockDetailModels failed',

	EXPORT_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export TransferOrderStockDetailModels excluding Ids',
	EXPORT_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export TransferOrderStockDetailModel excluding Ids successfully',
	EXPORT_TRANSFER_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export TransferOrderStockDetailModel excluding Ids failed',

	COUNT_TRANSFER_ORDER_STOCK_DETAILS = '[ENTITY] Fetch number of TransferOrderStockDetailModel records',
	COUNT_TRANSFER_ORDER_STOCK_DETAILS_OK = '[ENTITY] Fetch number of TransferOrderStockDetailModel records successfully ',
	COUNT_TRANSFER_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of TransferOrderStockDetailModel records failed',

	IMPORT_TRANSFER_ORDER_STOCK_DETAILS = '[ENTITY] Import TransferOrderStockDetailModels',
	IMPORT_TRANSFER_ORDER_STOCK_DETAILS_OK = '[ENTITY] Import TransferOrderStockDetailModels successfully',
	IMPORT_TRANSFER_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Import TransferOrderStockDetailModels fail',


	INITIALISE_TRANSFER_ORDER_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TransferOrderStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTransferOrderStockDetailAction implements Action {
	readonly className: string = 'TransferOrderStockDetailModel';

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

export class TransferOrderStockDetailAction extends BaseTransferOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for TransferOrderStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransferOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for TransferOrderStockDetailAction here] end
}

export class TransferOrderStockDetailActionOK extends BaseTransferOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for TransferOrderStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransferOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TransferOrderStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for TransferOrderStockDetailActionOK here] end
}

export class TransferOrderStockDetailActionFail extends BaseTransferOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for TransferOrderStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TransferOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for TransferOrderStockDetailActionFail here] end
}

export function isTransferOrderStockDetailModelAction(e: any): e is BaseTransferOrderStockDetailAction {
	return Object.values(TransferOrderStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
