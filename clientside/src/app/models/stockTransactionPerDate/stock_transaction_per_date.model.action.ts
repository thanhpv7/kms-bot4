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
import {StockTransactionPerDateModel} from './stock_transaction_per_date.model';
import {StockTransactionPerDateModelAudit} from './stock_transaction_per_date.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Stock Transaction Per Date model actions to be dispatched by NgRx.
 */
export enum StockTransactionPerDateModelActionTypes {
	CREATE_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Create StockTransactionPerDateModel',
	CREATE_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Create StockTransactionPerDateModel successfully',
	CREATE_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Create StockTransactionPerDateModel failed',

	CREATE_ALL_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Create All StockTransactionPerDateModel',
	CREATE_ALL_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Create All StockTransactionPerDateModel successfully',
	CREATE_ALL_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Create All StockTransactionPerDateModel failed',

	DELETE_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Delete StockTransactionPerDateModel',
	DELETE_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Delete StockTransactionPerDateModel successfully',
	DELETE_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Delete StockTransactionPerDateModel failed',


	DELETE_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS = '[ENTITY] Delete StockTransactionPerDateModels Excluding Ids',
	DELETE_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS_OK = '[ENTITY] Delete StockTransactionPerDateModels Excluding Ids successfully',
	DELETE_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StockTransactionPerDateModels Excluding Ids failed',

	DELETE_ALL_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Delete all StockTransactionPerDateModels',
	DELETE_ALL_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Delete all StockTransactionPerDateModels successfully',
	DELETE_ALL_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Delete all StockTransactionPerDateModels failed',

	UPDATE_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Update StockTransactionPerDateModel',
	UPDATE_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Update StockTransactionPerDateModel successfully',
	UPDATE_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Update StockTransactionPerDateModel failed',

	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Update all StockTransactionPerDateModel',
	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Update all StockTransactionPerDateModel successfully',
	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Update all StockTransactionPerDateModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE= '[ENTITY] Fetch StockTransactionPerDateModel',
	FETCH_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Fetch StockTransactionPerDateModel successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Fetch StockTransactionPerDateModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_AUDIT= '[ENTITY] Fetch StockTransactionPerDateModel audit',
	FETCH_STOCK_TRANSACTION_PER_DATE_AUDIT_OK = '[ENTITY] Fetch StockTransactionPerDateModel audit successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_AUDIT_FAIL = '[ENTITY] Fetch StockTransactionPerDateModel audit failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StockTransactionPerDateModel audits by entity id',
	FETCH_STOCK_TRANSACTION_PER_DATE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StockTransactionPerDateModel audits by entity id successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StockTransactionPerDateModel audits by entity id failed',

	FETCH_ALL_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Fetch all StockTransactionPerDateModel',
	FETCH_ALL_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Fetch all StockTransactionPerDateModel successfully',
	FETCH_ALL_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Fetch all StockTransactionPerDateModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_WITH_QUERY = '[ENTITY] Fetch StockTransactionPerDateModel with query',
	FETCH_STOCK_TRANSACTION_PER_DATE_WITH_QUERY_OK = '[ENTITY] Fetch StockTransactionPerDateModel with query successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch StockTransactionPerDateModel with query failed',

	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_WITH_QUERY = '[ENTITY] Fetch last StockTransactionPerDateModel with query',
	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_WITH_QUERY_OK = '[ENTITY] Fetch last StockTransactionPerDateModel with query successfully',
	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch last StockTransactionPerDateModel with query failed',

	EXPORT_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Export StockTransactionPerDateModel',
	EXPORT_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Export StockTransactionPerDateModel successfully',
	EXPORT_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Export StockTransactionPerDateModel failed',

	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE = '[ENTITY] Export All StockTransactionPerDateModels',
	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE_OK = '[ENTITY] Export All StockTransactionPerDateModels successfully',
	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE_FAIL = '[ENTITY] Export All StockTransactionPerDateModels failed',

	EXPORT_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS = '[ENTITY] Export StockTransactionPerDateModels excluding Ids',
	EXPORT_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS_OK = '[ENTITY] Export StockTransactionPerDateModel excluding Ids successfully',
	EXPORT_STOCK_TRANSACTION_PER_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Export StockTransactionPerDateModel excluding Ids failed',

	COUNT_STOCK_TRANSACTION_PER_DATES = '[ENTITY] Fetch number of StockTransactionPerDateModel records',
	COUNT_STOCK_TRANSACTION_PER_DATES_OK = '[ENTITY] Fetch number of StockTransactionPerDateModel records successfully ',
	COUNT_STOCK_TRANSACTION_PER_DATES_FAIL = '[ENTITY] Fetch number of StockTransactionPerDateModel records failed',

	IMPORT_STOCK_TRANSACTION_PER_DATES = '[ENTITY] Import StockTransactionPerDateModels',
	IMPORT_STOCK_TRANSACTION_PER_DATES_OK = '[ENTITY] Import StockTransactionPerDateModels successfully',
	IMPORT_STOCK_TRANSACTION_PER_DATES_FAIL = '[ENTITY] Import StockTransactionPerDateModels fail',


	INITIALISE_STOCK_TRANSACTION_PER_DATE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StockTransactionPerDateModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStockTransactionPerDateAction implements Action {
	readonly className: string = 'StockTransactionPerDateModel';

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

export class StockTransactionPerDateAction extends BaseStockTransactionPerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateAction here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionPerDateModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateAction here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateAction here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateAction here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateAction here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateAction here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateAction here] end
}

export class StockTransactionPerDateActionOK extends BaseStockTransactionPerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateActionOK here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionPerDateModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StockTransactionPerDateModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateActionOK here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateActionOK here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateActionOK here] end
}

export class StockTransactionPerDateActionFail extends BaseStockTransactionPerDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateActionFail here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StockTransactionPerDateModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateActionFail here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateActionFail here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateActionFail here] end
}

export function isStockTransactionPerDateModelAction(e: any): e is BaseStockTransactionPerDateAction {
	return Object.values(StockTransactionPerDateModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
