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
import {StockTransactionDetailModel} from './stock_transaction_detail.model';
import {StockTransactionDetailModelAudit} from './stock_transaction_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Stock Transaction Detail model actions to be dispatched by NgRx.
 */
export enum StockTransactionDetailModelActionTypes {
	CREATE_STOCK_TRANSACTION_DETAIL = '[ENTITY] Create StockTransactionDetailModel',
	CREATE_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Create StockTransactionDetailModel successfully',
	CREATE_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Create StockTransactionDetailModel failed',

	CREATE_ALL_STOCK_TRANSACTION_DETAIL = '[ENTITY] Create All StockTransactionDetailModel',
	CREATE_ALL_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Create All StockTransactionDetailModel successfully',
	CREATE_ALL_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Create All StockTransactionDetailModel failed',

	DELETE_STOCK_TRANSACTION_DETAIL = '[ENTITY] Delete StockTransactionDetailModel',
	DELETE_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Delete StockTransactionDetailModel successfully',
	DELETE_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Delete StockTransactionDetailModel failed',


	DELETE_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete StockTransactionDetailModels Excluding Ids',
	DELETE_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete StockTransactionDetailModels Excluding Ids successfully',
	DELETE_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StockTransactionDetailModels Excluding Ids failed',

	DELETE_ALL_STOCK_TRANSACTION_DETAIL = '[ENTITY] Delete all StockTransactionDetailModels',
	DELETE_ALL_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Delete all StockTransactionDetailModels successfully',
	DELETE_ALL_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Delete all StockTransactionDetailModels failed',

	UPDATE_STOCK_TRANSACTION_DETAIL = '[ENTITY] Update StockTransactionDetailModel',
	UPDATE_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Update StockTransactionDetailModel successfully',
	UPDATE_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Update StockTransactionDetailModel failed',

	UPDATE_ALL_STOCK_TRANSACTION_DETAIL = '[ENTITY] Update all StockTransactionDetailModel',
	UPDATE_ALL_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Update all StockTransactionDetailModel successfully',
	UPDATE_ALL_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Update all StockTransactionDetailModel failed',

	FETCH_STOCK_TRANSACTION_DETAIL= '[ENTITY] Fetch StockTransactionDetailModel',
	FETCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Fetch StockTransactionDetailModel successfully',
	FETCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Fetch StockTransactionDetailModel failed',

	FETCH_STOCK_TRANSACTION_DETAIL_AUDIT= '[ENTITY] Fetch StockTransactionDetailModel audit',
	FETCH_STOCK_TRANSACTION_DETAIL_AUDIT_OK = '[ENTITY] Fetch StockTransactionDetailModel audit successfully',
	FETCH_STOCK_TRANSACTION_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch StockTransactionDetailModel audit failed',

	FETCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StockTransactionDetailModel audits by entity id',
	FETCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StockTransactionDetailModel audits by entity id successfully',
	FETCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StockTransactionDetailModel audits by entity id failed',

	FETCH_ALL_STOCK_TRANSACTION_DETAIL = '[ENTITY] Fetch all StockTransactionDetailModel',
	FETCH_ALL_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Fetch all StockTransactionDetailModel successfully',
	FETCH_ALL_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Fetch all StockTransactionDetailModel failed',

	FETCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch StockTransactionDetailModel with query',
	FETCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch StockTransactionDetailModel with query successfully',
	FETCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch StockTransactionDetailModel with query failed',

	FETCH_LAST_STOCK_TRANSACTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch last StockTransactionDetailModel with query',
	FETCH_LAST_STOCK_TRANSACTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last StockTransactionDetailModel with query successfully',
	FETCH_LAST_STOCK_TRANSACTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last StockTransactionDetailModel with query failed',

	EXPORT_STOCK_TRANSACTION_DETAIL = '[ENTITY] Export StockTransactionDetailModel',
	EXPORT_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Export StockTransactionDetailModel successfully',
	EXPORT_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Export StockTransactionDetailModel failed',

	EXPORT_ALL_STOCK_TRANSACTION_DETAIL = '[ENTITY] Export All StockTransactionDetailModels',
	EXPORT_ALL_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Export All StockTransactionDetailModels successfully',
	EXPORT_ALL_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Export All StockTransactionDetailModels failed',

	EXPORT_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Export StockTransactionDetailModels excluding Ids',
	EXPORT_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export StockTransactionDetailModel excluding Ids successfully',
	EXPORT_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export StockTransactionDetailModel excluding Ids failed',

	COUNT_STOCK_TRANSACTION_DETAILS = '[ENTITY] Fetch number of StockTransactionDetailModel records',
	COUNT_STOCK_TRANSACTION_DETAILS_OK = '[ENTITY] Fetch number of StockTransactionDetailModel records successfully ',
	COUNT_STOCK_TRANSACTION_DETAILS_FAIL = '[ENTITY] Fetch number of StockTransactionDetailModel records failed',

	IMPORT_STOCK_TRANSACTION_DETAILS = '[ENTITY] Import StockTransactionDetailModels',
	IMPORT_STOCK_TRANSACTION_DETAILS_OK = '[ENTITY] Import StockTransactionDetailModels successfully',
	IMPORT_STOCK_TRANSACTION_DETAILS_FAIL = '[ENTITY] Import StockTransactionDetailModels fail',


	INITIALISE_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StockTransactionDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStockTransactionDetailAction implements Action {
	readonly className: string = 'StockTransactionDetailModel';

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

export class StockTransactionDetailAction extends BaseStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionDetailAction here] off begin
	// % protected region % [Add any additional class fields for StockTransactionDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionDetailAction here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionDetailAction here] off begin
	// % protected region % [Add any additional class methods for StockTransactionDetailAction here] end
}

export class StockTransactionDetailActionOK extends BaseStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for StockTransactionDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StockTransactionDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for StockTransactionDetailActionOK here] end
}

export class StockTransactionDetailActionFail extends BaseStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for StockTransactionDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for StockTransactionDetailActionFail here] end
}

export function isStockTransactionDetailModelAction(e: any): e is BaseStockTransactionDetailAction {
	return Object.values(StockTransactionDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
