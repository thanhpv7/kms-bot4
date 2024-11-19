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
import {WarehouseInitialStockModel} from './warehouse_initial_stock.model';
import {WarehouseInitialStockModelAudit} from './warehouse_initial_stock.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Warehouse Initial Stock  model actions to be dispatched by NgRx.
 */
export enum WarehouseInitialStockModelActionTypes {
	CREATE_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Create WarehouseInitialStockModel',
	CREATE_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Create WarehouseInitialStockModel successfully',
	CREATE_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Create WarehouseInitialStockModel failed',

	CREATE_ALL_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Create All WarehouseInitialStockModel',
	CREATE_ALL_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Create All WarehouseInitialStockModel successfully',
	CREATE_ALL_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Create All WarehouseInitialStockModel failed',

	DELETE_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Delete WarehouseInitialStockModel',
	DELETE_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Delete WarehouseInitialStockModel successfully',
	DELETE_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Delete WarehouseInitialStockModel failed',


	DELETE_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS = '[ENTITY] Delete WarehouseInitialStockModels Excluding Ids',
	DELETE_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS_OK = '[ENTITY] Delete WarehouseInitialStockModels Excluding Ids successfully',
	DELETE_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS_FAIL = '[ENTITY] Delete WarehouseInitialStockModels Excluding Ids failed',

	DELETE_ALL_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Delete all WarehouseInitialStockModels',
	DELETE_ALL_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Delete all WarehouseInitialStockModels successfully',
	DELETE_ALL_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Delete all WarehouseInitialStockModels failed',

	UPDATE_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Update WarehouseInitialStockModel',
	UPDATE_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Update WarehouseInitialStockModel successfully',
	UPDATE_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Update WarehouseInitialStockModel failed',

	UPDATE_ALL_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Update all WarehouseInitialStockModel',
	UPDATE_ALL_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Update all WarehouseInitialStockModel successfully',
	UPDATE_ALL_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Update all WarehouseInitialStockModel failed',

	FETCH_WAREHOUSE_INITIAL_STOCK= '[ENTITY] Fetch WarehouseInitialStockModel',
	FETCH_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Fetch WarehouseInitialStockModel successfully',
	FETCH_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Fetch WarehouseInitialStockModel failed',

	FETCH_WAREHOUSE_INITIAL_STOCK_AUDIT= '[ENTITY] Fetch WarehouseInitialStockModel audit',
	FETCH_WAREHOUSE_INITIAL_STOCK_AUDIT_OK = '[ENTITY] Fetch WarehouseInitialStockModel audit successfully',
	FETCH_WAREHOUSE_INITIAL_STOCK_AUDIT_FAIL = '[ENTITY] Fetch WarehouseInitialStockModel audit failed',

	FETCH_WAREHOUSE_INITIAL_STOCK_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch WarehouseInitialStockModel audits by entity id',
	FETCH_WAREHOUSE_INITIAL_STOCK_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch WarehouseInitialStockModel audits by entity id successfully',
	FETCH_WAREHOUSE_INITIAL_STOCK_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch WarehouseInitialStockModel audits by entity id failed',

	FETCH_ALL_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Fetch all WarehouseInitialStockModel',
	FETCH_ALL_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Fetch all WarehouseInitialStockModel successfully',
	FETCH_ALL_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Fetch all WarehouseInitialStockModel failed',

	FETCH_WAREHOUSE_INITIAL_STOCK_WITH_QUERY = '[ENTITY] Fetch WarehouseInitialStockModel with query',
	FETCH_WAREHOUSE_INITIAL_STOCK_WITH_QUERY_OK = '[ENTITY] Fetch WarehouseInitialStockModel with query successfully',
	FETCH_WAREHOUSE_INITIAL_STOCK_WITH_QUERY_FAIL = '[ENTITY] Fetch WarehouseInitialStockModel with query failed',

	FETCH_LAST_WAREHOUSE_INITIAL_STOCK_WITH_QUERY = '[ENTITY] Fetch last WarehouseInitialStockModel with query',
	FETCH_LAST_WAREHOUSE_INITIAL_STOCK_WITH_QUERY_OK = '[ENTITY] Fetch last WarehouseInitialStockModel with query successfully',
	FETCH_LAST_WAREHOUSE_INITIAL_STOCK_WITH_QUERY_FAIL = '[ENTITY] Fetch last WarehouseInitialStockModel with query failed',

	EXPORT_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Export WarehouseInitialStockModel',
	EXPORT_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Export WarehouseInitialStockModel successfully',
	EXPORT_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Export WarehouseInitialStockModel failed',

	EXPORT_ALL_WAREHOUSE_INITIAL_STOCK = '[ENTITY] Export All WarehouseInitialStockModels',
	EXPORT_ALL_WAREHOUSE_INITIAL_STOCK_OK = '[ENTITY] Export All WarehouseInitialStockModels successfully',
	EXPORT_ALL_WAREHOUSE_INITIAL_STOCK_FAIL = '[ENTITY] Export All WarehouseInitialStockModels failed',

	EXPORT_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS = '[ENTITY] Export WarehouseInitialStockModels excluding Ids',
	EXPORT_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS_OK = '[ENTITY] Export WarehouseInitialStockModel excluding Ids successfully',
	EXPORT_WAREHOUSE_INITIAL_STOCK_EXCLUDING_IDS_FAIL = '[ENTITY] Export WarehouseInitialStockModel excluding Ids failed',

	COUNT_WAREHOUSE_INITIAL_STOCKS = '[ENTITY] Fetch number of WarehouseInitialStockModel records',
	COUNT_WAREHOUSE_INITIAL_STOCKS_OK = '[ENTITY] Fetch number of WarehouseInitialStockModel records successfully ',
	COUNT_WAREHOUSE_INITIAL_STOCKS_FAIL = '[ENTITY] Fetch number of WarehouseInitialStockModel records failed',

	IMPORT_WAREHOUSE_INITIAL_STOCKS = '[ENTITY] Import WarehouseInitialStockModels',
	IMPORT_WAREHOUSE_INITIAL_STOCKS_OK = '[ENTITY] Import WarehouseInitialStockModels successfully',
	IMPORT_WAREHOUSE_INITIAL_STOCKS_FAIL = '[ENTITY] Import WarehouseInitialStockModels fail',


	INITIALISE_WAREHOUSE_INITIAL_STOCK_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of WarehouseInitialStockModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseWarehouseInitialStockAction implements Action {
	readonly className: string = 'WarehouseInitialStockModel';

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

export class WarehouseInitialStockAction extends BaseWarehouseInitialStockAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInitialStockAction here] off begin
	// % protected region % [Add any additional class fields for WarehouseInitialStockAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseInitialStockModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockAction here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockAction here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockAction here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockAction here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInitialStockAction here] off begin
	// % protected region % [Add any additional class methods for WarehouseInitialStockAction here] end
}

export class WarehouseInitialStockActionOK extends BaseWarehouseInitialStockAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInitialStockActionOK here] off begin
	// % protected region % [Add any additional class fields for WarehouseInitialStockActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseInitialStockModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: WarehouseInitialStockModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockActionOK here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockActionOK here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInitialStockActionOK here] off begin
	// % protected region % [Add any additional class methods for WarehouseInitialStockActionOK here] end
}

export class WarehouseInitialStockActionFail extends BaseWarehouseInitialStockAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInitialStockActionFail here] off begin
	// % protected region % [Add any additional class fields for WarehouseInitialStockActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<WarehouseInitialStockModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInitialStockActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInitialStockActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockActionFail here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInitialStockActionFail here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInitialStockActionFail here] off begin
	// % protected region % [Add any additional class methods for WarehouseInitialStockActionFail here] end
}

export function isWarehouseInitialStockModelAction(e: any): e is BaseWarehouseInitialStockAction {
	return Object.values(WarehouseInitialStockModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
