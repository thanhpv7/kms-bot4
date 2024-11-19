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
import {WarehouseInventoryModel} from './warehouse_inventory.model';
import {WarehouseInventoryModelAudit} from './warehouse_inventory.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Warehouse Inventory model actions to be dispatched by NgRx.
 */
export enum WarehouseInventoryModelActionTypes {
	CREATE_WAREHOUSE_INVENTORY = '[ENTITY] Create WarehouseInventoryModel',
	CREATE_WAREHOUSE_INVENTORY_OK = '[ENTITY] Create WarehouseInventoryModel successfully',
	CREATE_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Create WarehouseInventoryModel failed',

	CREATE_ALL_WAREHOUSE_INVENTORY = '[ENTITY] Create All WarehouseInventoryModel',
	CREATE_ALL_WAREHOUSE_INVENTORY_OK = '[ENTITY] Create All WarehouseInventoryModel successfully',
	CREATE_ALL_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Create All WarehouseInventoryModel failed',

	DELETE_WAREHOUSE_INVENTORY = '[ENTITY] Delete WarehouseInventoryModel',
	DELETE_WAREHOUSE_INVENTORY_OK = '[ENTITY] Delete WarehouseInventoryModel successfully',
	DELETE_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Delete WarehouseInventoryModel failed',


	DELETE_WAREHOUSE_INVENTORY_EXCLUDING_IDS = '[ENTITY] Delete WarehouseInventoryModels Excluding Ids',
	DELETE_WAREHOUSE_INVENTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete WarehouseInventoryModels Excluding Ids successfully',
	DELETE_WAREHOUSE_INVENTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete WarehouseInventoryModels Excluding Ids failed',

	DELETE_ALL_WAREHOUSE_INVENTORY = '[ENTITY] Delete all WarehouseInventoryModels',
	DELETE_ALL_WAREHOUSE_INVENTORY_OK = '[ENTITY] Delete all WarehouseInventoryModels successfully',
	DELETE_ALL_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Delete all WarehouseInventoryModels failed',

	UPDATE_WAREHOUSE_INVENTORY = '[ENTITY] Update WarehouseInventoryModel',
	UPDATE_WAREHOUSE_INVENTORY_OK = '[ENTITY] Update WarehouseInventoryModel successfully',
	UPDATE_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Update WarehouseInventoryModel failed',

	UPDATE_ALL_WAREHOUSE_INVENTORY = '[ENTITY] Update all WarehouseInventoryModel',
	UPDATE_ALL_WAREHOUSE_INVENTORY_OK = '[ENTITY] Update all WarehouseInventoryModel successfully',
	UPDATE_ALL_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Update all WarehouseInventoryModel failed',

	FETCH_WAREHOUSE_INVENTORY= '[ENTITY] Fetch WarehouseInventoryModel',
	FETCH_WAREHOUSE_INVENTORY_OK = '[ENTITY] Fetch WarehouseInventoryModel successfully',
	FETCH_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Fetch WarehouseInventoryModel failed',

	FETCH_WAREHOUSE_INVENTORY_AUDIT= '[ENTITY] Fetch WarehouseInventoryModel audit',
	FETCH_WAREHOUSE_INVENTORY_AUDIT_OK = '[ENTITY] Fetch WarehouseInventoryModel audit successfully',
	FETCH_WAREHOUSE_INVENTORY_AUDIT_FAIL = '[ENTITY] Fetch WarehouseInventoryModel audit failed',

	FETCH_WAREHOUSE_INVENTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch WarehouseInventoryModel audits by entity id',
	FETCH_WAREHOUSE_INVENTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch WarehouseInventoryModel audits by entity id successfully',
	FETCH_WAREHOUSE_INVENTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch WarehouseInventoryModel audits by entity id failed',

	FETCH_ALL_WAREHOUSE_INVENTORY = '[ENTITY] Fetch all WarehouseInventoryModel',
	FETCH_ALL_WAREHOUSE_INVENTORY_OK = '[ENTITY] Fetch all WarehouseInventoryModel successfully',
	FETCH_ALL_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Fetch all WarehouseInventoryModel failed',

	FETCH_WAREHOUSE_INVENTORY_WITH_QUERY = '[ENTITY] Fetch WarehouseInventoryModel with query',
	FETCH_WAREHOUSE_INVENTORY_WITH_QUERY_OK = '[ENTITY] Fetch WarehouseInventoryModel with query successfully',
	FETCH_WAREHOUSE_INVENTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch WarehouseInventoryModel with query failed',

	FETCH_LAST_WAREHOUSE_INVENTORY_WITH_QUERY = '[ENTITY] Fetch last WarehouseInventoryModel with query',
	FETCH_LAST_WAREHOUSE_INVENTORY_WITH_QUERY_OK = '[ENTITY] Fetch last WarehouseInventoryModel with query successfully',
	FETCH_LAST_WAREHOUSE_INVENTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last WarehouseInventoryModel with query failed',

	EXPORT_WAREHOUSE_INVENTORY = '[ENTITY] Export WarehouseInventoryModel',
	EXPORT_WAREHOUSE_INVENTORY_OK = '[ENTITY] Export WarehouseInventoryModel successfully',
	EXPORT_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Export WarehouseInventoryModel failed',

	EXPORT_ALL_WAREHOUSE_INVENTORY = '[ENTITY] Export All WarehouseInventoryModels',
	EXPORT_ALL_WAREHOUSE_INVENTORY_OK = '[ENTITY] Export All WarehouseInventoryModels successfully',
	EXPORT_ALL_WAREHOUSE_INVENTORY_FAIL = '[ENTITY] Export All WarehouseInventoryModels failed',

	EXPORT_WAREHOUSE_INVENTORY_EXCLUDING_IDS = '[ENTITY] Export WarehouseInventoryModels excluding Ids',
	EXPORT_WAREHOUSE_INVENTORY_EXCLUDING_IDS_OK = '[ENTITY] Export WarehouseInventoryModel excluding Ids successfully',
	EXPORT_WAREHOUSE_INVENTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export WarehouseInventoryModel excluding Ids failed',

	COUNT_WAREHOUSE_INVENTORYS = '[ENTITY] Fetch number of WarehouseInventoryModel records',
	COUNT_WAREHOUSE_INVENTORYS_OK = '[ENTITY] Fetch number of WarehouseInventoryModel records successfully ',
	COUNT_WAREHOUSE_INVENTORYS_FAIL = '[ENTITY] Fetch number of WarehouseInventoryModel records failed',

	IMPORT_WAREHOUSE_INVENTORYS = '[ENTITY] Import WarehouseInventoryModels',
	IMPORT_WAREHOUSE_INVENTORYS_OK = '[ENTITY] Import WarehouseInventoryModels successfully',
	IMPORT_WAREHOUSE_INVENTORYS_FAIL = '[ENTITY] Import WarehouseInventoryModels fail',


	INITIALISE_WAREHOUSE_INVENTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of WarehouseInventoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseWarehouseInventoryAction implements Action {
	readonly className: string = 'WarehouseInventoryModel';

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

export class WarehouseInventoryAction extends BaseWarehouseInventoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInventoryAction here] off begin
	// % protected region % [Add any additional class fields for WarehouseInventoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseInventoryModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInventoryAction here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInventoryAction here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInventoryAction here] off begin
	// % protected region % [Add any additional class methods for WarehouseInventoryAction here] end
}

export class WarehouseInventoryActionOK extends BaseWarehouseInventoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInventoryActionOK here] off begin
	// % protected region % [Add any additional class fields for WarehouseInventoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseInventoryModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: WarehouseInventoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInventoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInventoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInventoryActionOK here] off begin
	// % protected region % [Add any additional class methods for WarehouseInventoryActionOK here] end
}

export class WarehouseInventoryActionFail extends BaseWarehouseInventoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseInventoryActionFail here] off begin
	// % protected region % [Add any additional class fields for WarehouseInventoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<WarehouseInventoryModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseInventoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseInventoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseInventoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseInventoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for WarehouseInventoryActionFail here] off begin
	// % protected region % [Add any additional class methods for WarehouseInventoryActionFail here] end
}

export function isWarehouseInventoryModelAction(e: any): e is BaseWarehouseInventoryAction {
	return Object.values(WarehouseInventoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
