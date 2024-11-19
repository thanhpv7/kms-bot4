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
import {BatchStockBalanceModel} from './batch_stock_balance.model';
import {BatchStockBalanceModelAudit} from './batch_stock_balance.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Batch Stock Balance model actions to be dispatched by NgRx.
 */
export enum BatchStockBalanceModelActionTypes {
	CREATE_BATCH_STOCK_BALANCE = '[ENTITY] Create BatchStockBalanceModel',
	CREATE_BATCH_STOCK_BALANCE_OK = '[ENTITY] Create BatchStockBalanceModel successfully',
	CREATE_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Create BatchStockBalanceModel failed',

	CREATE_ALL_BATCH_STOCK_BALANCE = '[ENTITY] Create All BatchStockBalanceModel',
	CREATE_ALL_BATCH_STOCK_BALANCE_OK = '[ENTITY] Create All BatchStockBalanceModel successfully',
	CREATE_ALL_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Create All BatchStockBalanceModel failed',

	DELETE_BATCH_STOCK_BALANCE = '[ENTITY] Delete BatchStockBalanceModel',
	DELETE_BATCH_STOCK_BALANCE_OK = '[ENTITY] Delete BatchStockBalanceModel successfully',
	DELETE_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Delete BatchStockBalanceModel failed',


	DELETE_BATCH_STOCK_BALANCE_EXCLUDING_IDS = '[ENTITY] Delete BatchStockBalanceModels Excluding Ids',
	DELETE_BATCH_STOCK_BALANCE_EXCLUDING_IDS_OK = '[ENTITY] Delete BatchStockBalanceModels Excluding Ids successfully',
	DELETE_BATCH_STOCK_BALANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BatchStockBalanceModels Excluding Ids failed',

	DELETE_ALL_BATCH_STOCK_BALANCE = '[ENTITY] Delete all BatchStockBalanceModels',
	DELETE_ALL_BATCH_STOCK_BALANCE_OK = '[ENTITY] Delete all BatchStockBalanceModels successfully',
	DELETE_ALL_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Delete all BatchStockBalanceModels failed',

	UPDATE_BATCH_STOCK_BALANCE = '[ENTITY] Update BatchStockBalanceModel',
	UPDATE_BATCH_STOCK_BALANCE_OK = '[ENTITY] Update BatchStockBalanceModel successfully',
	UPDATE_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Update BatchStockBalanceModel failed',

	UPDATE_ALL_BATCH_STOCK_BALANCE = '[ENTITY] Update all BatchStockBalanceModel',
	UPDATE_ALL_BATCH_STOCK_BALANCE_OK = '[ENTITY] Update all BatchStockBalanceModel successfully',
	UPDATE_ALL_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Update all BatchStockBalanceModel failed',

	FETCH_BATCH_STOCK_BALANCE= '[ENTITY] Fetch BatchStockBalanceModel',
	FETCH_BATCH_STOCK_BALANCE_OK = '[ENTITY] Fetch BatchStockBalanceModel successfully',
	FETCH_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Fetch BatchStockBalanceModel failed',

	FETCH_BATCH_STOCK_BALANCE_AUDIT= '[ENTITY] Fetch BatchStockBalanceModel audit',
	FETCH_BATCH_STOCK_BALANCE_AUDIT_OK = '[ENTITY] Fetch BatchStockBalanceModel audit successfully',
	FETCH_BATCH_STOCK_BALANCE_AUDIT_FAIL = '[ENTITY] Fetch BatchStockBalanceModel audit failed',

	FETCH_BATCH_STOCK_BALANCE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BatchStockBalanceModel audits by entity id',
	FETCH_BATCH_STOCK_BALANCE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BatchStockBalanceModel audits by entity id successfully',
	FETCH_BATCH_STOCK_BALANCE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BatchStockBalanceModel audits by entity id failed',

	FETCH_ALL_BATCH_STOCK_BALANCE = '[ENTITY] Fetch all BatchStockBalanceModel',
	FETCH_ALL_BATCH_STOCK_BALANCE_OK = '[ENTITY] Fetch all BatchStockBalanceModel successfully',
	FETCH_ALL_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Fetch all BatchStockBalanceModel failed',

	FETCH_BATCH_STOCK_BALANCE_WITH_QUERY = '[ENTITY] Fetch BatchStockBalanceModel with query',
	FETCH_BATCH_STOCK_BALANCE_WITH_QUERY_OK = '[ENTITY] Fetch BatchStockBalanceModel with query successfully',
	FETCH_BATCH_STOCK_BALANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch BatchStockBalanceModel with query failed',

	FETCH_LAST_BATCH_STOCK_BALANCE_WITH_QUERY = '[ENTITY] Fetch last BatchStockBalanceModel with query',
	FETCH_LAST_BATCH_STOCK_BALANCE_WITH_QUERY_OK = '[ENTITY] Fetch last BatchStockBalanceModel with query successfully',
	FETCH_LAST_BATCH_STOCK_BALANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BatchStockBalanceModel with query failed',

	EXPORT_BATCH_STOCK_BALANCE = '[ENTITY] Export BatchStockBalanceModel',
	EXPORT_BATCH_STOCK_BALANCE_OK = '[ENTITY] Export BatchStockBalanceModel successfully',
	EXPORT_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Export BatchStockBalanceModel failed',

	EXPORT_ALL_BATCH_STOCK_BALANCE = '[ENTITY] Export All BatchStockBalanceModels',
	EXPORT_ALL_BATCH_STOCK_BALANCE_OK = '[ENTITY] Export All BatchStockBalanceModels successfully',
	EXPORT_ALL_BATCH_STOCK_BALANCE_FAIL = '[ENTITY] Export All BatchStockBalanceModels failed',

	EXPORT_BATCH_STOCK_BALANCE_EXCLUDING_IDS = '[ENTITY] Export BatchStockBalanceModels excluding Ids',
	EXPORT_BATCH_STOCK_BALANCE_EXCLUDING_IDS_OK = '[ENTITY] Export BatchStockBalanceModel excluding Ids successfully',
	EXPORT_BATCH_STOCK_BALANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BatchStockBalanceModel excluding Ids failed',

	COUNT_BATCH_STOCK_BALANCES = '[ENTITY] Fetch number of BatchStockBalanceModel records',
	COUNT_BATCH_STOCK_BALANCES_OK = '[ENTITY] Fetch number of BatchStockBalanceModel records successfully ',
	COUNT_BATCH_STOCK_BALANCES_FAIL = '[ENTITY] Fetch number of BatchStockBalanceModel records failed',

	IMPORT_BATCH_STOCK_BALANCES = '[ENTITY] Import BatchStockBalanceModels',
	IMPORT_BATCH_STOCK_BALANCES_OK = '[ENTITY] Import BatchStockBalanceModels successfully',
	IMPORT_BATCH_STOCK_BALANCES_FAIL = '[ENTITY] Import BatchStockBalanceModels fail',


	INITIALISE_BATCH_STOCK_BALANCE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BatchStockBalanceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBatchStockBalanceAction implements Action {
	readonly className: string = 'BatchStockBalanceModel';

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

export class BatchStockBalanceAction extends BaseBatchStockBalanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalanceAction here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalanceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockBalanceModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceAction here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceAction here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalanceAction here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalanceAction here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalanceAction here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalanceAction here] end
}

export class BatchStockBalanceActionOK extends BaseBatchStockBalanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalanceActionOK here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalanceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockBalanceModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BatchStockBalanceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalanceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalanceActionOK here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalanceActionOK here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalanceActionOK here] end
}

export class BatchStockBalanceActionFail extends BaseBatchStockBalanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalanceActionFail here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalanceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BatchStockBalanceModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalanceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalanceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalanceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalanceActionFail here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalanceActionFail here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalanceActionFail here] end
}

export function isBatchStockBalanceModelAction(e: any): e is BaseBatchStockBalanceAction {
	return Object.values(BatchStockBalanceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
