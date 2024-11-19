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
import {BatchStockBalancePerDateModel} from './batch_stock_balance_per_date.model';
import {BatchStockBalancePerDateModelAudit} from './batch_stock_balance_per_date.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Batch Stock Balance Per Date model actions to be dispatched by NgRx.
 */
export enum BatchStockBalancePerDateModelActionTypes {
	CREATE_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Create BatchStockBalancePerDateModel',
	CREATE_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Create BatchStockBalancePerDateModel successfully',
	CREATE_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Create BatchStockBalancePerDateModel failed',

	CREATE_ALL_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Create All BatchStockBalancePerDateModel',
	CREATE_ALL_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Create All BatchStockBalancePerDateModel successfully',
	CREATE_ALL_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Create All BatchStockBalancePerDateModel failed',

	DELETE_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Delete BatchStockBalancePerDateModel',
	DELETE_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Delete BatchStockBalancePerDateModel successfully',
	DELETE_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Delete BatchStockBalancePerDateModel failed',


	DELETE_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS = '[ENTITY] Delete BatchStockBalancePerDateModels Excluding Ids',
	DELETE_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS_OK = '[ENTITY] Delete BatchStockBalancePerDateModels Excluding Ids successfully',
	DELETE_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BatchStockBalancePerDateModels Excluding Ids failed',

	DELETE_ALL_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Delete all BatchStockBalancePerDateModels',
	DELETE_ALL_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Delete all BatchStockBalancePerDateModels successfully',
	DELETE_ALL_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Delete all BatchStockBalancePerDateModels failed',

	UPDATE_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Update BatchStockBalancePerDateModel',
	UPDATE_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Update BatchStockBalancePerDateModel successfully',
	UPDATE_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Update BatchStockBalancePerDateModel failed',

	UPDATE_ALL_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Update all BatchStockBalancePerDateModel',
	UPDATE_ALL_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Update all BatchStockBalancePerDateModel successfully',
	UPDATE_ALL_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Update all BatchStockBalancePerDateModel failed',

	FETCH_BATCH_STOCK_BALANCE_PER_DATE= '[ENTITY] Fetch BatchStockBalancePerDateModel',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Fetch BatchStockBalancePerDateModel successfully',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Fetch BatchStockBalancePerDateModel failed',

	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDIT= '[ENTITY] Fetch BatchStockBalancePerDateModel audit',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDIT_OK = '[ENTITY] Fetch BatchStockBalancePerDateModel audit successfully',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDIT_FAIL = '[ENTITY] Fetch BatchStockBalancePerDateModel audit failed',

	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BatchStockBalancePerDateModel audits by entity id',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BatchStockBalancePerDateModel audits by entity id successfully',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BatchStockBalancePerDateModel audits by entity id failed',

	FETCH_ALL_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Fetch all BatchStockBalancePerDateModel',
	FETCH_ALL_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Fetch all BatchStockBalancePerDateModel successfully',
	FETCH_ALL_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Fetch all BatchStockBalancePerDateModel failed',

	FETCH_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY = '[ENTITY] Fetch BatchStockBalancePerDateModel with query',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY_OK = '[ENTITY] Fetch BatchStockBalancePerDateModel with query successfully',
	FETCH_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch BatchStockBalancePerDateModel with query failed',

	FETCH_LAST_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY = '[ENTITY] Fetch last BatchStockBalancePerDateModel with query',
	FETCH_LAST_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY_OK = '[ENTITY] Fetch last BatchStockBalancePerDateModel with query successfully',
	FETCH_LAST_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BatchStockBalancePerDateModel with query failed',

	EXPORT_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Export BatchStockBalancePerDateModel',
	EXPORT_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Export BatchStockBalancePerDateModel successfully',
	EXPORT_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Export BatchStockBalancePerDateModel failed',

	EXPORT_ALL_BATCH_STOCK_BALANCE_PER_DATE = '[ENTITY] Export All BatchStockBalancePerDateModels',
	EXPORT_ALL_BATCH_STOCK_BALANCE_PER_DATE_OK = '[ENTITY] Export All BatchStockBalancePerDateModels successfully',
	EXPORT_ALL_BATCH_STOCK_BALANCE_PER_DATE_FAIL = '[ENTITY] Export All BatchStockBalancePerDateModels failed',

	EXPORT_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS = '[ENTITY] Export BatchStockBalancePerDateModels excluding Ids',
	EXPORT_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS_OK = '[ENTITY] Export BatchStockBalancePerDateModel excluding Ids successfully',
	EXPORT_BATCH_STOCK_BALANCE_PER_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BatchStockBalancePerDateModel excluding Ids failed',

	COUNT_BATCH_STOCK_BALANCE_PER_DATES = '[ENTITY] Fetch number of BatchStockBalancePerDateModel records',
	COUNT_BATCH_STOCK_BALANCE_PER_DATES_OK = '[ENTITY] Fetch number of BatchStockBalancePerDateModel records successfully ',
	COUNT_BATCH_STOCK_BALANCE_PER_DATES_FAIL = '[ENTITY] Fetch number of BatchStockBalancePerDateModel records failed',

	IMPORT_BATCH_STOCK_BALANCE_PER_DATES = '[ENTITY] Import BatchStockBalancePerDateModels',
	IMPORT_BATCH_STOCK_BALANCE_PER_DATES_OK = '[ENTITY] Import BatchStockBalancePerDateModels successfully',
	IMPORT_BATCH_STOCK_BALANCE_PER_DATES_FAIL = '[ENTITY] Import BatchStockBalancePerDateModels fail',


	INITIALISE_BATCH_STOCK_BALANCE_PER_DATE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BatchStockBalancePerDateModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBatchStockBalancePerDateAction implements Action {
	readonly className: string = 'BatchStockBalancePerDateModel';

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

export class BatchStockBalancePerDateAction extends BaseBatchStockBalancePerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalancePerDateAction here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalancePerDateAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockBalancePerDateModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateAction here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateAction here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateAction here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateAction here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalancePerDateAction here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalancePerDateAction here] end
}

export class BatchStockBalancePerDateActionOK extends BaseBatchStockBalancePerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalancePerDateActionOK here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalancePerDateActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BatchStockBalancePerDateModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BatchStockBalancePerDateModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateActionOK here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalancePerDateActionOK here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalancePerDateActionOK here] end
}

export class BatchStockBalancePerDateActionFail extends BaseBatchStockBalancePerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BatchStockBalancePerDateActionFail here] off begin
	// % protected region % [Add any additional class fields for BatchStockBalancePerDateActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BatchStockBalancePerDateModel>,
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BatchStockBalancePerDateActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BatchStockBalancePerDateActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BatchStockBalancePerDateActionFail here] end
	}

	// % protected region % [Add any additional class methods for BatchStockBalancePerDateActionFail here] off begin
	// % protected region % [Add any additional class methods for BatchStockBalancePerDateActionFail here] end
}

export function isBatchStockBalancePerDateModelAction(e: any): e is BaseBatchStockBalancePerDateAction {
	return Object.values(BatchStockBalancePerDateModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
