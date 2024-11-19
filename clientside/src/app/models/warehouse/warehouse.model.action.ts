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
import {WarehouseModel} from './warehouse.model';
import {WarehouseModelAudit} from './warehouse.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Warehouse model actions to be dispatched by NgRx.
 */
export enum WarehouseModelActionTypes {
	CREATE_WAREHOUSE = '[ENTITY] Create WarehouseModel',
	CREATE_WAREHOUSE_OK = '[ENTITY] Create WarehouseModel successfully',
	CREATE_WAREHOUSE_FAIL = '[ENTITY] Create WarehouseModel failed',

	CREATE_ALL_WAREHOUSE = '[ENTITY] Create All WarehouseModel',
	CREATE_ALL_WAREHOUSE_OK = '[ENTITY] Create All WarehouseModel successfully',
	CREATE_ALL_WAREHOUSE_FAIL = '[ENTITY] Create All WarehouseModel failed',

	DELETE_WAREHOUSE = '[ENTITY] Delete WarehouseModel',
	DELETE_WAREHOUSE_OK = '[ENTITY] Delete WarehouseModel successfully',
	DELETE_WAREHOUSE_FAIL = '[ENTITY] Delete WarehouseModel failed',


	DELETE_WAREHOUSE_EXCLUDING_IDS = '[ENTITY] Delete WarehouseModels Excluding Ids',
	DELETE_WAREHOUSE_EXCLUDING_IDS_OK = '[ENTITY] Delete WarehouseModels Excluding Ids successfully',
	DELETE_WAREHOUSE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete WarehouseModels Excluding Ids failed',

	DELETE_ALL_WAREHOUSE = '[ENTITY] Delete all WarehouseModels',
	DELETE_ALL_WAREHOUSE_OK = '[ENTITY] Delete all WarehouseModels successfully',
	DELETE_ALL_WAREHOUSE_FAIL = '[ENTITY] Delete all WarehouseModels failed',

	UPDATE_WAREHOUSE = '[ENTITY] Update WarehouseModel',
	UPDATE_WAREHOUSE_OK = '[ENTITY] Update WarehouseModel successfully',
	UPDATE_WAREHOUSE_FAIL = '[ENTITY] Update WarehouseModel failed',

	UPDATE_ALL_WAREHOUSE = '[ENTITY] Update all WarehouseModel',
	UPDATE_ALL_WAREHOUSE_OK = '[ENTITY] Update all WarehouseModel successfully',
	UPDATE_ALL_WAREHOUSE_FAIL = '[ENTITY] Update all WarehouseModel failed',

	FETCH_WAREHOUSE= '[ENTITY] Fetch WarehouseModel',
	FETCH_WAREHOUSE_OK = '[ENTITY] Fetch WarehouseModel successfully',
	FETCH_WAREHOUSE_FAIL = '[ENTITY] Fetch WarehouseModel failed',

	FETCH_WAREHOUSE_AUDIT= '[ENTITY] Fetch WarehouseModel audit',
	FETCH_WAREHOUSE_AUDIT_OK = '[ENTITY] Fetch WarehouseModel audit successfully',
	FETCH_WAREHOUSE_AUDIT_FAIL = '[ENTITY] Fetch WarehouseModel audit failed',

	FETCH_WAREHOUSE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch WarehouseModel audits by entity id',
	FETCH_WAREHOUSE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch WarehouseModel audits by entity id successfully',
	FETCH_WAREHOUSE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch WarehouseModel audits by entity id failed',

	FETCH_ALL_WAREHOUSE = '[ENTITY] Fetch all WarehouseModel',
	FETCH_ALL_WAREHOUSE_OK = '[ENTITY] Fetch all WarehouseModel successfully',
	FETCH_ALL_WAREHOUSE_FAIL = '[ENTITY] Fetch all WarehouseModel failed',

	FETCH_WAREHOUSE_WITH_QUERY = '[ENTITY] Fetch WarehouseModel with query',
	FETCH_WAREHOUSE_WITH_QUERY_OK = '[ENTITY] Fetch WarehouseModel with query successfully',
	FETCH_WAREHOUSE_WITH_QUERY_FAIL = '[ENTITY] Fetch WarehouseModel with query failed',

	FETCH_LAST_WAREHOUSE_WITH_QUERY = '[ENTITY] Fetch last WarehouseModel with query',
	FETCH_LAST_WAREHOUSE_WITH_QUERY_OK = '[ENTITY] Fetch last WarehouseModel with query successfully',
	FETCH_LAST_WAREHOUSE_WITH_QUERY_FAIL = '[ENTITY] Fetch last WarehouseModel with query failed',

	EXPORT_WAREHOUSE = '[ENTITY] Export WarehouseModel',
	EXPORT_WAREHOUSE_OK = '[ENTITY] Export WarehouseModel successfully',
	EXPORT_WAREHOUSE_FAIL = '[ENTITY] Export WarehouseModel failed',

	EXPORT_ALL_WAREHOUSE = '[ENTITY] Export All WarehouseModels',
	EXPORT_ALL_WAREHOUSE_OK = '[ENTITY] Export All WarehouseModels successfully',
	EXPORT_ALL_WAREHOUSE_FAIL = '[ENTITY] Export All WarehouseModels failed',

	EXPORT_WAREHOUSE_EXCLUDING_IDS = '[ENTITY] Export WarehouseModels excluding Ids',
	EXPORT_WAREHOUSE_EXCLUDING_IDS_OK = '[ENTITY] Export WarehouseModel excluding Ids successfully',
	EXPORT_WAREHOUSE_EXCLUDING_IDS_FAIL = '[ENTITY] Export WarehouseModel excluding Ids failed',

	COUNT_WAREHOUSES = '[ENTITY] Fetch number of WarehouseModel records',
	COUNT_WAREHOUSES_OK = '[ENTITY] Fetch number of WarehouseModel records successfully ',
	COUNT_WAREHOUSES_FAIL = '[ENTITY] Fetch number of WarehouseModel records failed',

	IMPORT_WAREHOUSES = '[ENTITY] Import WarehouseModels',
	IMPORT_WAREHOUSES_OK = '[ENTITY] Import WarehouseModels successfully',
	IMPORT_WAREHOUSES_FAIL = '[ENTITY] Import WarehouseModels fail',


	INITIALISE_WAREHOUSE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of WarehouseModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseWarehouseAction implements Action {
	readonly className: string = 'WarehouseModel';

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

export class WarehouseAction extends BaseWarehouseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseAction here] off begin
	// % protected region % [Add any additional class fields for WarehouseAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseAction here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseAction here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseAction here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseAction here] end
	}

	// % protected region % [Add any additional class methods for WarehouseAction here] off begin
	// % protected region % [Add any additional class methods for WarehouseAction here] end
}

export class WarehouseActionOK extends BaseWarehouseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseActionOK here] off begin
	// % protected region % [Add any additional class fields for WarehouseActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: WarehouseModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseActionOK here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseActionOK here] end
	}

	// % protected region % [Add any additional class methods for WarehouseActionOK here] off begin
	// % protected region % [Add any additional class methods for WarehouseActionOK here] end
}

export class WarehouseActionFail extends BaseWarehouseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseActionFail here] off begin
	// % protected region % [Add any additional class fields for WarehouseActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<WarehouseModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseActionFail here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseActionFail here] end
	}

	// % protected region % [Add any additional class methods for WarehouseActionFail here] off begin
	// % protected region % [Add any additional class methods for WarehouseActionFail here] end
}

export function isWarehouseModelAction(e: any): e is BaseWarehouseAction {
	return Object.values(WarehouseModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
