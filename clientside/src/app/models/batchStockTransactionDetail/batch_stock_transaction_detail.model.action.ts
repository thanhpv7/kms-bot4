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
import {BatchStockTransactionDetailModel} from './batch_stock_transaction_detail.model';
import {BatchStockTransactionDetailModelAudit} from './batch_stock_transaction_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Batch Stock Transaction Detail model actions to be dispatched by NgRx.
 */
export enum BatchStockTransactionDetailModelActionTypes {
	CREATE_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Create BatchStockTransactionDetailModel',
	CREATE_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Create BatchStockTransactionDetailModel successfully',
	CREATE_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Create BatchStockTransactionDetailModel failed',

	CREATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Create All BatchStockTransactionDetailModel',
	CREATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Create All BatchStockTransactionDetailModel successfully',
	CREATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Create All BatchStockTransactionDetailModel failed',

	DELETE_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Delete BatchStockTransactionDetailModel',
	DELETE_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Delete BatchStockTransactionDetailModel successfully',
	DELETE_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Delete BatchStockTransactionDetailModel failed',


	DELETE_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete BatchStockTransactionDetailModels Excluding Ids',
	DELETE_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete BatchStockTransactionDetailModels Excluding Ids successfully',
	DELETE_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BatchStockTransactionDetailModels Excluding Ids failed',

	DELETE_ALL_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Delete all BatchStockTransactionDetailModels',
	DELETE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Delete all BatchStockTransactionDetailModels successfully',
	DELETE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Delete all BatchStockTransactionDetailModels failed',

	UPDATE_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Update BatchStockTransactionDetailModel',
	UPDATE_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Update BatchStockTransactionDetailModel successfully',
	UPDATE_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Update BatchStockTransactionDetailModel failed',

	UPDATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Update all BatchStockTransactionDetailModel',
	UPDATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Update all BatchStockTransactionDetailModel successfully',
	UPDATE_ALL_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Update all BatchStockTransactionDetailModel failed',

	FETCH_BATCH_STOCK_TRANSACTION_DETAIL= '[ENTITY] Fetch BatchStockTransactionDetailModel',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Fetch BatchStockTransactionDetailModel successfully',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Fetch BatchStockTransactionDetailModel failed',

	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDIT= '[ENTITY] Fetch BatchStockTransactionDetailModel audit',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDIT_OK = '[ENTITY] Fetch BatchStockTransactionDetailModel audit successfully',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch BatchStockTransactionDetailModel audit failed',

	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BatchStockTransactionDetailModel audits by entity id',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BatchStockTransactionDetailModel audits by entity id successfully',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BatchStockTransactionDetailModel audits by entity id failed',

	FETCH_ALL_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Fetch all BatchStockTransactionDetailModel',
	FETCH_ALL_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Fetch all BatchStockTransactionDetailModel successfully',
	FETCH_ALL_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Fetch all BatchStockTransactionDetailModel failed',

	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch BatchStockTransactionDetailModel with query',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch BatchStockTransactionDetailModel with query successfully',
	FETCH_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch BatchStockTransactionDetailModel with query failed',

	FETCH_LAST_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch last BatchStockTransactionDetailModel with query',
	FETCH_LAST_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last BatchStockTransactionDetailModel with query successfully',
	FETCH_LAST_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BatchStockTransactionDetailModel with query failed',

	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Export BatchStockTransactionDetailModel',
	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Export BatchStockTransactionDetailModel successfully',
	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Export BatchStockTransactionDetailModel failed',

	EXPORT_ALL_BATCH_STOCK_TRANSACTION_DETAIL = '[ENTITY] Export All BatchStockTransactionDetailModels',
	EXPORT_ALL_BATCH_STOCK_TRANSACTION_DETAIL_OK = '[ENTITY] Export All BatchStockTransactionDetailModels successfully',
	EXPORT_ALL_BATCH_STOCK_TRANSACTION_DETAIL_FAIL = '[ENTITY] Export All BatchStockTransactionDetailModels failed',

	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Export BatchStockTransactionDetailModels excluding Ids',
	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export BatchStockTransactionDetailModel excluding Ids successfully',
	EXPORT_BATCH_STOCK_TRANSACTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BatchStockTransactionDetailModel excluding Ids failed',

	COUNT_BATCH_STOCK_TRANSACTION_DETAILS = '[ENTITY] Fetch number of BatchStockTransactionDetailModel records',
	COUNT_BATCH_STOCK_TRANSACTION_DETAILS_OK = '[ENTITY] Fetch number of BatchStockTransactionDetailModel records successfully ',
	COUNT_BATCH_STOCK_TRANSACTION_DETAILS_FAIL = '[ENTITY] Fetch number of BatchStockTransactionDetailModel records failed',

	IMPORT_BATCH_STOCK_TRANSACTION_DETAILS = '[ENTITY] Import BatchStockTransactionDetailModels',
	IMPORT_BATCH_STOCK_TRANSACTION_DETAILS_OK = '[ENTITY] Import BatchStockTransactionDetailModels successfully',
	IMPORT_BATCH_STOCK_TRANSACTION_DETAILS_FAIL = '[ENTITY] Import BatchStockTransactionDetailModels fail',


	INITIALISE_BATCH_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BatchStockTransactionDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBatchStockTransactionDetailAction implements Action {
	readonly className: string = 'BatchStockTransactionDetailModel';

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

export class BatchStockTransactionDetailAction extends BaseBatchStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockTransactionDetailAction here] off begin
	// % protected region % [Add any additional class fields for BatchStockTransactionDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailAction here] end
	}

	// % protected region % [Add any additional class methods for BatchStockTransactionDetailAction here] off begin
	// % protected region % [Add any additional class methods for BatchStockTransactionDetailAction here] end
}

export class BatchStockTransactionDetailActionOK extends BaseBatchStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockTransactionDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for BatchStockTransactionDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BatchStockTransactionDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for BatchStockTransactionDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for BatchStockTransactionDetailActionOK here] end
}

export class BatchStockTransactionDetailActionFail extends BaseBatchStockTransactionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockTransactionDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for BatchStockTransactionDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BatchStockTransactionDetailModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockTransactionDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockTransactionDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockTransactionDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for BatchStockTransactionDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for BatchStockTransactionDetailActionFail here] end
}

export function isBatchStockTransactionDetailModelAction(e: any): e is BaseBatchStockTransactionDetailAction {
	return Object.values(BatchStockTransactionDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
