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
import {StockControlModel} from './stock_control.model';
import {StockControlModelAudit} from './stock_control.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Stock Control model actions to be dispatched by NgRx.
 */
export enum StockControlModelActionTypes {
	CREATE_STOCK_CONTROL = '[ENTITY] Create StockControlModel',
	CREATE_STOCK_CONTROL_OK = '[ENTITY] Create StockControlModel successfully',
	CREATE_STOCK_CONTROL_FAIL = '[ENTITY] Create StockControlModel failed',

	CREATE_ALL_STOCK_CONTROL = '[ENTITY] Create All StockControlModel',
	CREATE_ALL_STOCK_CONTROL_OK = '[ENTITY] Create All StockControlModel successfully',
	CREATE_ALL_STOCK_CONTROL_FAIL = '[ENTITY] Create All StockControlModel failed',

	DELETE_STOCK_CONTROL = '[ENTITY] Delete StockControlModel',
	DELETE_STOCK_CONTROL_OK = '[ENTITY] Delete StockControlModel successfully',
	DELETE_STOCK_CONTROL_FAIL = '[ENTITY] Delete StockControlModel failed',


	DELETE_STOCK_CONTROL_EXCLUDING_IDS = '[ENTITY] Delete StockControlModels Excluding Ids',
	DELETE_STOCK_CONTROL_EXCLUDING_IDS_OK = '[ENTITY] Delete StockControlModels Excluding Ids successfully',
	DELETE_STOCK_CONTROL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StockControlModels Excluding Ids failed',

	DELETE_ALL_STOCK_CONTROL = '[ENTITY] Delete all StockControlModels',
	DELETE_ALL_STOCK_CONTROL_OK = '[ENTITY] Delete all StockControlModels successfully',
	DELETE_ALL_STOCK_CONTROL_FAIL = '[ENTITY] Delete all StockControlModels failed',

	UPDATE_STOCK_CONTROL = '[ENTITY] Update StockControlModel',
	UPDATE_STOCK_CONTROL_OK = '[ENTITY] Update StockControlModel successfully',
	UPDATE_STOCK_CONTROL_FAIL = '[ENTITY] Update StockControlModel failed',

	UPDATE_ALL_STOCK_CONTROL = '[ENTITY] Update all StockControlModel',
	UPDATE_ALL_STOCK_CONTROL_OK = '[ENTITY] Update all StockControlModel successfully',
	UPDATE_ALL_STOCK_CONTROL_FAIL = '[ENTITY] Update all StockControlModel failed',

	FETCH_STOCK_CONTROL= '[ENTITY] Fetch StockControlModel',
	FETCH_STOCK_CONTROL_OK = '[ENTITY] Fetch StockControlModel successfully',
	FETCH_STOCK_CONTROL_FAIL = '[ENTITY] Fetch StockControlModel failed',

	FETCH_STOCK_CONTROL_AUDIT= '[ENTITY] Fetch StockControlModel audit',
	FETCH_STOCK_CONTROL_AUDIT_OK = '[ENTITY] Fetch StockControlModel audit successfully',
	FETCH_STOCK_CONTROL_AUDIT_FAIL = '[ENTITY] Fetch StockControlModel audit failed',

	FETCH_STOCK_CONTROL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StockControlModel audits by entity id',
	FETCH_STOCK_CONTROL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StockControlModel audits by entity id successfully',
	FETCH_STOCK_CONTROL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StockControlModel audits by entity id failed',

	FETCH_ALL_STOCK_CONTROL = '[ENTITY] Fetch all StockControlModel',
	FETCH_ALL_STOCK_CONTROL_OK = '[ENTITY] Fetch all StockControlModel successfully',
	FETCH_ALL_STOCK_CONTROL_FAIL = '[ENTITY] Fetch all StockControlModel failed',

	FETCH_STOCK_CONTROL_WITH_QUERY = '[ENTITY] Fetch StockControlModel with query',
	FETCH_STOCK_CONTROL_WITH_QUERY_OK = '[ENTITY] Fetch StockControlModel with query successfully',
	FETCH_STOCK_CONTROL_WITH_QUERY_FAIL = '[ENTITY] Fetch StockControlModel with query failed',

	FETCH_LAST_STOCK_CONTROL_WITH_QUERY = '[ENTITY] Fetch last StockControlModel with query',
	FETCH_LAST_STOCK_CONTROL_WITH_QUERY_OK = '[ENTITY] Fetch last StockControlModel with query successfully',
	FETCH_LAST_STOCK_CONTROL_WITH_QUERY_FAIL = '[ENTITY] Fetch last StockControlModel with query failed',

	EXPORT_STOCK_CONTROL = '[ENTITY] Export StockControlModel',
	EXPORT_STOCK_CONTROL_OK = '[ENTITY] Export StockControlModel successfully',
	EXPORT_STOCK_CONTROL_FAIL = '[ENTITY] Export StockControlModel failed',

	EXPORT_ALL_STOCK_CONTROL = '[ENTITY] Export All StockControlModels',
	EXPORT_ALL_STOCK_CONTROL_OK = '[ENTITY] Export All StockControlModels successfully',
	EXPORT_ALL_STOCK_CONTROL_FAIL = '[ENTITY] Export All StockControlModels failed',

	EXPORT_STOCK_CONTROL_EXCLUDING_IDS = '[ENTITY] Export StockControlModels excluding Ids',
	EXPORT_STOCK_CONTROL_EXCLUDING_IDS_OK = '[ENTITY] Export StockControlModel excluding Ids successfully',
	EXPORT_STOCK_CONTROL_EXCLUDING_IDS_FAIL = '[ENTITY] Export StockControlModel excluding Ids failed',

	COUNT_STOCK_CONTROLS = '[ENTITY] Fetch number of StockControlModel records',
	COUNT_STOCK_CONTROLS_OK = '[ENTITY] Fetch number of StockControlModel records successfully ',
	COUNT_STOCK_CONTROLS_FAIL = '[ENTITY] Fetch number of StockControlModel records failed',

	IMPORT_STOCK_CONTROLS = '[ENTITY] Import StockControlModels',
	IMPORT_STOCK_CONTROLS_OK = '[ENTITY] Import StockControlModels successfully',
	IMPORT_STOCK_CONTROLS_FAIL = '[ENTITY] Import StockControlModels fail',


	INITIALISE_STOCK_CONTROL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StockControlModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStockControlAction implements Action {
	readonly className: string = 'StockControlModel';

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

export class StockControlAction extends BaseStockControlAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockControlAction here] off begin
	// % protected region % [Add any additional class fields for StockControlAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockControlModel>,
		// % protected region % [Add any additional constructor parameters for StockControlAction here] off begin
		// % protected region % [Add any additional constructor parameters for StockControlAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockControlAction here] off begin
			// % protected region % [Add any additional constructor arguments for StockControlAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockControlAction here] off begin
		// % protected region % [Add any additional constructor logic for StockControlAction here] end
	}

	// % protected region % [Add any additional class methods for StockControlAction here] off begin
	// % protected region % [Add any additional class methods for StockControlAction here] end
}

export class StockControlActionOK extends BaseStockControlAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockControlActionOK here] off begin
	// % protected region % [Add any additional class fields for StockControlActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockControlModel>,
		// % protected region % [Add any additional constructor parameters for StockControlActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StockControlActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StockControlModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockControlActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StockControlActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockControlActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StockControlActionOK here] end
	}

	// % protected region % [Add any additional class methods for StockControlActionOK here] off begin
	// % protected region % [Add any additional class methods for StockControlActionOK here] end
}

export class StockControlActionFail extends BaseStockControlAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockControlActionFail here] off begin
	// % protected region % [Add any additional class fields for StockControlActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StockControlModel>,
		// % protected region % [Add any additional constructor parameters for StockControlActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StockControlActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockControlActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StockControlActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockControlActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StockControlActionFail here] end
	}

	// % protected region % [Add any additional class methods for StockControlActionFail here] off begin
	// % protected region % [Add any additional class methods for StockControlActionFail here] end
}

export function isStockControlModelAction(e: any): e is BaseStockControlAction {
	return Object.values(StockControlModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
