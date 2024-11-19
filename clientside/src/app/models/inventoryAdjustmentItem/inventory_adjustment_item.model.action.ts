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
import {InventoryAdjustmentItemModel} from './inventory_adjustment_item.model';
import {InventoryAdjustmentItemModelAudit} from './inventory_adjustment_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inventory Adjustment Item model actions to be dispatched by NgRx.
 */
export enum InventoryAdjustmentItemModelActionTypes {
	CREATE_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Create InventoryAdjustmentItemModel',
	CREATE_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Create InventoryAdjustmentItemModel successfully',
	CREATE_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Create InventoryAdjustmentItemModel failed',

	CREATE_ALL_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Create All InventoryAdjustmentItemModel',
	CREATE_ALL_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Create All InventoryAdjustmentItemModel successfully',
	CREATE_ALL_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Create All InventoryAdjustmentItemModel failed',

	DELETE_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Delete InventoryAdjustmentItemModel',
	DELETE_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Delete InventoryAdjustmentItemModel successfully',
	DELETE_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Delete InventoryAdjustmentItemModel failed',


	DELETE_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS = '[ENTITY] Delete InventoryAdjustmentItemModels Excluding Ids',
	DELETE_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete InventoryAdjustmentItemModels Excluding Ids successfully',
	DELETE_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InventoryAdjustmentItemModels Excluding Ids failed',

	DELETE_ALL_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Delete all InventoryAdjustmentItemModels',
	DELETE_ALL_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Delete all InventoryAdjustmentItemModels successfully',
	DELETE_ALL_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Delete all InventoryAdjustmentItemModels failed',

	UPDATE_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Update InventoryAdjustmentItemModel',
	UPDATE_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Update InventoryAdjustmentItemModel successfully',
	UPDATE_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Update InventoryAdjustmentItemModel failed',

	UPDATE_ALL_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Update all InventoryAdjustmentItemModel',
	UPDATE_ALL_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Update all InventoryAdjustmentItemModel successfully',
	UPDATE_ALL_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Update all InventoryAdjustmentItemModel failed',

	FETCH_INVENTORY_ADJUSTMENT_ITEM= '[ENTITY] Fetch InventoryAdjustmentItemModel',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Fetch InventoryAdjustmentItemModel successfully',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Fetch InventoryAdjustmentItemModel failed',

	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDIT= '[ENTITY] Fetch InventoryAdjustmentItemModel audit',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDIT_OK = '[ENTITY] Fetch InventoryAdjustmentItemModel audit successfully',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDIT_FAIL = '[ENTITY] Fetch InventoryAdjustmentItemModel audit failed',

	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InventoryAdjustmentItemModel audits by entity id',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InventoryAdjustmentItemModel audits by entity id successfully',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InventoryAdjustmentItemModel audits by entity id failed',

	FETCH_ALL_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Fetch all InventoryAdjustmentItemModel',
	FETCH_ALL_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Fetch all InventoryAdjustmentItemModel successfully',
	FETCH_ALL_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Fetch all InventoryAdjustmentItemModel failed',

	FETCH_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY = '[ENTITY] Fetch InventoryAdjustmentItemModel with query',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch InventoryAdjustmentItemModel with query successfully',
	FETCH_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch InventoryAdjustmentItemModel with query failed',

	FETCH_LAST_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY = '[ENTITY] Fetch last InventoryAdjustmentItemModel with query',
	FETCH_LAST_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last InventoryAdjustmentItemModel with query successfully',
	FETCH_LAST_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last InventoryAdjustmentItemModel with query failed',

	EXPORT_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Export InventoryAdjustmentItemModel',
	EXPORT_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Export InventoryAdjustmentItemModel successfully',
	EXPORT_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Export InventoryAdjustmentItemModel failed',

	EXPORT_ALL_INVENTORY_ADJUSTMENT_ITEM = '[ENTITY] Export All InventoryAdjustmentItemModels',
	EXPORT_ALL_INVENTORY_ADJUSTMENT_ITEM_OK = '[ENTITY] Export All InventoryAdjustmentItemModels successfully',
	EXPORT_ALL_INVENTORY_ADJUSTMENT_ITEM_FAIL = '[ENTITY] Export All InventoryAdjustmentItemModels failed',

	EXPORT_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS = '[ENTITY] Export InventoryAdjustmentItemModels excluding Ids',
	EXPORT_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export InventoryAdjustmentItemModel excluding Ids successfully',
	EXPORT_INVENTORY_ADJUSTMENT_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export InventoryAdjustmentItemModel excluding Ids failed',

	COUNT_INVENTORY_ADJUSTMENT_ITEMS = '[ENTITY] Fetch number of InventoryAdjustmentItemModel records',
	COUNT_INVENTORY_ADJUSTMENT_ITEMS_OK = '[ENTITY] Fetch number of InventoryAdjustmentItemModel records successfully ',
	COUNT_INVENTORY_ADJUSTMENT_ITEMS_FAIL = '[ENTITY] Fetch number of InventoryAdjustmentItemModel records failed',

	IMPORT_INVENTORY_ADJUSTMENT_ITEMS = '[ENTITY] Import InventoryAdjustmentItemModels',
	IMPORT_INVENTORY_ADJUSTMENT_ITEMS_OK = '[ENTITY] Import InventoryAdjustmentItemModels successfully',
	IMPORT_INVENTORY_ADJUSTMENT_ITEMS_FAIL = '[ENTITY] Import InventoryAdjustmentItemModels fail',


	INITIALISE_INVENTORY_ADJUSTMENT_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InventoryAdjustmentItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInventoryAdjustmentItemAction implements Action {
	readonly className: string = 'InventoryAdjustmentItemModel';

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

export class InventoryAdjustmentItemAction extends BaseInventoryAdjustmentItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentItemAction here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjustmentItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemAction here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemAction here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentItemAction here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentItemAction here] end
}

export class InventoryAdjustmentItemActionOK extends BaseInventoryAdjustmentItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentItemActionOK here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjustmentItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InventoryAdjustmentItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentItemActionOK here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentItemActionOK here] end
}

export class InventoryAdjustmentItemActionFail extends BaseInventoryAdjustmentItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentItemActionFail here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InventoryAdjustmentItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentItemActionFail here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentItemActionFail here] end
}

export function isInventoryAdjustmentItemModelAction(e: any): e is BaseInventoryAdjustmentItemAction {
	return Object.values(InventoryAdjustmentItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
