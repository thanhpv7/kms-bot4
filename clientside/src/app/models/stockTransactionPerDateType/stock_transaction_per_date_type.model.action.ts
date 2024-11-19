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
import {StockTransactionPerDateTypeModel} from './stock_transaction_per_date_type.model';
import {StockTransactionPerDateTypeModelAudit} from './stock_transaction_per_date_type.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Stock Transaction Per Date Type model actions to be dispatched by NgRx.
 */
export enum StockTransactionPerDateTypeModelActionTypes {
	CREATE_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Create StockTransactionPerDateTypeModel',
	CREATE_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Create StockTransactionPerDateTypeModel successfully',
	CREATE_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Create StockTransactionPerDateTypeModel failed',

	CREATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Create All StockTransactionPerDateTypeModel',
	CREATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Create All StockTransactionPerDateTypeModel successfully',
	CREATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Create All StockTransactionPerDateTypeModel failed',

	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Delete StockTransactionPerDateTypeModel',
	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Delete StockTransactionPerDateTypeModel successfully',
	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Delete StockTransactionPerDateTypeModel failed',


	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS = '[ENTITY] Delete StockTransactionPerDateTypeModels Excluding Ids',
	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS_OK = '[ENTITY] Delete StockTransactionPerDateTypeModels Excluding Ids successfully',
	DELETE_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StockTransactionPerDateTypeModels Excluding Ids failed',

	DELETE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Delete all StockTransactionPerDateTypeModels',
	DELETE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Delete all StockTransactionPerDateTypeModels successfully',
	DELETE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Delete all StockTransactionPerDateTypeModels failed',

	UPDATE_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Update StockTransactionPerDateTypeModel',
	UPDATE_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Update StockTransactionPerDateTypeModel successfully',
	UPDATE_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Update StockTransactionPerDateTypeModel failed',

	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Update all StockTransactionPerDateTypeModel',
	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Update all StockTransactionPerDateTypeModel successfully',
	UPDATE_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Update all StockTransactionPerDateTypeModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE= '[ENTITY] Fetch StockTransactionPerDateTypeModel',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Fetch StockTransactionPerDateTypeModel successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Fetch StockTransactionPerDateTypeModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDIT= '[ENTITY] Fetch StockTransactionPerDateTypeModel audit',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDIT_OK = '[ENTITY] Fetch StockTransactionPerDateTypeModel audit successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDIT_FAIL = '[ENTITY] Fetch StockTransactionPerDateTypeModel audit failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StockTransactionPerDateTypeModel audits by entity id',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StockTransactionPerDateTypeModel audits by entity id successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StockTransactionPerDateTypeModel audits by entity id failed',

	FETCH_ALL_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Fetch all StockTransactionPerDateTypeModel',
	FETCH_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Fetch all StockTransactionPerDateTypeModel successfully',
	FETCH_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Fetch all StockTransactionPerDateTypeModel failed',

	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY = '[ENTITY] Fetch StockTransactionPerDateTypeModel with query',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY_OK = '[ENTITY] Fetch StockTransactionPerDateTypeModel with query successfully',
	FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY_FAIL = '[ENTITY] Fetch StockTransactionPerDateTypeModel with query failed',

	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY = '[ENTITY] Fetch last StockTransactionPerDateTypeModel with query',
	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY_OK = '[ENTITY] Fetch last StockTransactionPerDateTypeModel with query successfully',
	FETCH_LAST_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY_FAIL = '[ENTITY] Fetch last StockTransactionPerDateTypeModel with query failed',

	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Export StockTransactionPerDateTypeModel',
	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Export StockTransactionPerDateTypeModel successfully',
	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Export StockTransactionPerDateTypeModel failed',

	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE_TYPE = '[ENTITY] Export All StockTransactionPerDateTypeModels',
	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_OK = '[ENTITY] Export All StockTransactionPerDateTypeModels successfully',
	EXPORT_ALL_STOCK_TRANSACTION_PER_DATE_TYPE_FAIL = '[ENTITY] Export All StockTransactionPerDateTypeModels failed',

	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS = '[ENTITY] Export StockTransactionPerDateTypeModels excluding Ids',
	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS_OK = '[ENTITY] Export StockTransactionPerDateTypeModel excluding Ids successfully',
	EXPORT_STOCK_TRANSACTION_PER_DATE_TYPE_EXCLUDING_IDS_FAIL = '[ENTITY] Export StockTransactionPerDateTypeModel excluding Ids failed',

	COUNT_STOCK_TRANSACTION_PER_DATE_TYPES = '[ENTITY] Fetch number of StockTransactionPerDateTypeModel records',
	COUNT_STOCK_TRANSACTION_PER_DATE_TYPES_OK = '[ENTITY] Fetch number of StockTransactionPerDateTypeModel records successfully ',
	COUNT_STOCK_TRANSACTION_PER_DATE_TYPES_FAIL = '[ENTITY] Fetch number of StockTransactionPerDateTypeModel records failed',

	IMPORT_STOCK_TRANSACTION_PER_DATE_TYPES = '[ENTITY] Import StockTransactionPerDateTypeModels',
	IMPORT_STOCK_TRANSACTION_PER_DATE_TYPES_OK = '[ENTITY] Import StockTransactionPerDateTypeModels successfully',
	IMPORT_STOCK_TRANSACTION_PER_DATE_TYPES_FAIL = '[ENTITY] Import StockTransactionPerDateTypeModels fail',


	INITIALISE_STOCK_TRANSACTION_PER_DATE_TYPE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StockTransactionPerDateTypeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStockTransactionPerDateTypeAction implements Action {
	readonly className: string = 'StockTransactionPerDateTypeModel';

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

export class StockTransactionPerDateTypeAction extends BaseStockTransactionPerDateTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeAction here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionPerDateTypeModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeAction here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeAction here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeAction here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeAction here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeAction here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeAction here] end
}

export class StockTransactionPerDateTypeActionOK extends BaseStockTransactionPerDateTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeActionOK here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockTransactionPerDateTypeModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StockTransactionPerDateTypeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeActionOK here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeActionOK here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeActionOK here] end
}

export class StockTransactionPerDateTypeActionFail extends BaseStockTransactionPerDateTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeActionFail here] off begin
	// % protected region % [Add any additional class fields for StockTransactionPerDateTypeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StockTransactionPerDateTypeModel>,
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StockTransactionPerDateTypeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StockTransactionPerDateTypeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StockTransactionPerDateTypeActionFail here] end
	}

	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeActionFail here] off begin
	// % protected region % [Add any additional class methods for StockTransactionPerDateTypeActionFail here] end
}

export function isStockTransactionPerDateTypeModelAction(e: any): e is BaseStockTransactionPerDateTypeAction {
	return Object.values(StockTransactionPerDateTypeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
