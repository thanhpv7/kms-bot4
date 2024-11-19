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
import {InventoryBatchCorrectionItemModel} from './inventory_batch_correction_item.model';
import {InventoryBatchCorrectionItemModelAudit} from './inventory_batch_correction_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inventory Batch Correction Item model actions to be dispatched by NgRx.
 */
export enum InventoryBatchCorrectionItemModelActionTypes {
	CREATE_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Create InventoryBatchCorrectionItemModel',
	CREATE_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Create InventoryBatchCorrectionItemModel successfully',
	CREATE_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Create InventoryBatchCorrectionItemModel failed',

	CREATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Create All InventoryBatchCorrectionItemModel',
	CREATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Create All InventoryBatchCorrectionItemModel successfully',
	CREATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Create All InventoryBatchCorrectionItemModel failed',

	DELETE_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Delete InventoryBatchCorrectionItemModel',
	DELETE_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Delete InventoryBatchCorrectionItemModel successfully',
	DELETE_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Delete InventoryBatchCorrectionItemModel failed',


	DELETE_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS = '[ENTITY] Delete InventoryBatchCorrectionItemModels Excluding Ids',
	DELETE_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete InventoryBatchCorrectionItemModels Excluding Ids successfully',
	DELETE_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InventoryBatchCorrectionItemModels Excluding Ids failed',

	DELETE_ALL_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Delete all InventoryBatchCorrectionItemModels',
	DELETE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Delete all InventoryBatchCorrectionItemModels successfully',
	DELETE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Delete all InventoryBatchCorrectionItemModels failed',

	UPDATE_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Update InventoryBatchCorrectionItemModel',
	UPDATE_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Update InventoryBatchCorrectionItemModel successfully',
	UPDATE_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Update InventoryBatchCorrectionItemModel failed',

	UPDATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Update all InventoryBatchCorrectionItemModel',
	UPDATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Update all InventoryBatchCorrectionItemModel successfully',
	UPDATE_ALL_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Update all InventoryBatchCorrectionItemModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION_ITEM= '[ENTITY] Fetch InventoryBatchCorrectionItemModel',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Fetch InventoryBatchCorrectionItemModel successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionItemModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDIT= '[ENTITY] Fetch InventoryBatchCorrectionItemModel audit',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDIT_OK = '[ENTITY] Fetch InventoryBatchCorrectionItemModel audit successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDIT_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionItemModel audit failed',

	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InventoryBatchCorrectionItemModel audits by entity id',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InventoryBatchCorrectionItemModel audits by entity id successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionItemModel audits by entity id failed',

	FETCH_ALL_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Fetch all InventoryBatchCorrectionItemModel',
	FETCH_ALL_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Fetch all InventoryBatchCorrectionItemModel successfully',
	FETCH_ALL_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Fetch all InventoryBatchCorrectionItemModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY = '[ENTITY] Fetch InventoryBatchCorrectionItemModel with query',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch InventoryBatchCorrectionItemModel with query successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionItemModel with query failed',

	FETCH_LAST_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY = '[ENTITY] Fetch last InventoryBatchCorrectionItemModel with query',
	FETCH_LAST_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last InventoryBatchCorrectionItemModel with query successfully',
	FETCH_LAST_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last InventoryBatchCorrectionItemModel with query failed',

	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Export InventoryBatchCorrectionItemModel',
	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Export InventoryBatchCorrectionItemModel successfully',
	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Export InventoryBatchCorrectionItemModel failed',

	EXPORT_ALL_INVENTORY_BATCH_CORRECTION_ITEM = '[ENTITY] Export All InventoryBatchCorrectionItemModels',
	EXPORT_ALL_INVENTORY_BATCH_CORRECTION_ITEM_OK = '[ENTITY] Export All InventoryBatchCorrectionItemModels successfully',
	EXPORT_ALL_INVENTORY_BATCH_CORRECTION_ITEM_FAIL = '[ENTITY] Export All InventoryBatchCorrectionItemModels failed',

	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS = '[ENTITY] Export InventoryBatchCorrectionItemModels excluding Ids',
	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export InventoryBatchCorrectionItemModel excluding Ids successfully',
	EXPORT_INVENTORY_BATCH_CORRECTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export InventoryBatchCorrectionItemModel excluding Ids failed',

	COUNT_INVENTORY_BATCH_CORRECTION_ITEMS = '[ENTITY] Fetch number of InventoryBatchCorrectionItemModel records',
	COUNT_INVENTORY_BATCH_CORRECTION_ITEMS_OK = '[ENTITY] Fetch number of InventoryBatchCorrectionItemModel records successfully ',
	COUNT_INVENTORY_BATCH_CORRECTION_ITEMS_FAIL = '[ENTITY] Fetch number of InventoryBatchCorrectionItemModel records failed',

	IMPORT_INVENTORY_BATCH_CORRECTION_ITEMS = '[ENTITY] Import InventoryBatchCorrectionItemModels',
	IMPORT_INVENTORY_BATCH_CORRECTION_ITEMS_OK = '[ENTITY] Import InventoryBatchCorrectionItemModels successfully',
	IMPORT_INVENTORY_BATCH_CORRECTION_ITEMS_FAIL = '[ENTITY] Import InventoryBatchCorrectionItemModels fail',


	INITIALISE_INVENTORY_BATCH_CORRECTION_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InventoryBatchCorrectionItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInventoryBatchCorrectionItemAction implements Action {
	readonly className: string = 'InventoryBatchCorrectionItemModel';

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

export class InventoryBatchCorrectionItemAction extends BaseInventoryBatchCorrectionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemAction here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryBatchCorrectionItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemAction here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemAction here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemAction here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemAction here] end
}

export class InventoryBatchCorrectionItemActionOK extends BaseInventoryBatchCorrectionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemActionOK here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryBatchCorrectionItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InventoryBatchCorrectionItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemActionOK here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemActionOK here] end
}

export class InventoryBatchCorrectionItemActionFail extends BaseInventoryBatchCorrectionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemActionFail here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InventoryBatchCorrectionItemModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemActionFail here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionItemActionFail here] end
}

export function isInventoryBatchCorrectionItemModelAction(e: any): e is BaseInventoryBatchCorrectionItemAction {
	return Object.values(InventoryBatchCorrectionItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
