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
import {GoodsReceiveNoteItemModel} from './goods_receive_note_item.model';
import {GoodsReceiveNoteItemModelAudit} from './goods_receive_note_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Goods Receive Note Item model actions to be dispatched by NgRx.
 */
export enum GoodsReceiveNoteItemModelActionTypes {
	CREATE_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Create GoodsReceiveNoteItemModel',
	CREATE_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Create GoodsReceiveNoteItemModel successfully',
	CREATE_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Create GoodsReceiveNoteItemModel failed',

	CREATE_ALL_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Create All GoodsReceiveNoteItemModel',
	CREATE_ALL_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Create All GoodsReceiveNoteItemModel successfully',
	CREATE_ALL_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Create All GoodsReceiveNoteItemModel failed',

	DELETE_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Delete GoodsReceiveNoteItemModel',
	DELETE_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Delete GoodsReceiveNoteItemModel successfully',
	DELETE_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Delete GoodsReceiveNoteItemModel failed',


	DELETE_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS = '[ENTITY] Delete GoodsReceiveNoteItemModels Excluding Ids',
	DELETE_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete GoodsReceiveNoteItemModels Excluding Ids successfully',
	DELETE_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete GoodsReceiveNoteItemModels Excluding Ids failed',

	DELETE_ALL_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Delete all GoodsReceiveNoteItemModels',
	DELETE_ALL_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Delete all GoodsReceiveNoteItemModels successfully',
	DELETE_ALL_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Delete all GoodsReceiveNoteItemModels failed',

	UPDATE_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Update GoodsReceiveNoteItemModel',
	UPDATE_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Update GoodsReceiveNoteItemModel successfully',
	UPDATE_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Update GoodsReceiveNoteItemModel failed',

	UPDATE_ALL_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Update all GoodsReceiveNoteItemModel',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Update all GoodsReceiveNoteItemModel successfully',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Update all GoodsReceiveNoteItemModel failed',

	FETCH_GOODS_RECEIVE_NOTE_ITEM= '[ENTITY] Fetch GoodsReceiveNoteItemModel',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Fetch GoodsReceiveNoteItemModel successfully',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Fetch GoodsReceiveNoteItemModel failed',

	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDIT= '[ENTITY] Fetch GoodsReceiveNoteItemModel audit',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDIT_OK = '[ENTITY] Fetch GoodsReceiveNoteItemModel audit successfully',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDIT_FAIL = '[ENTITY] Fetch GoodsReceiveNoteItemModel audit failed',

	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch GoodsReceiveNoteItemModel audits by entity id',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch GoodsReceiveNoteItemModel audits by entity id successfully',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch GoodsReceiveNoteItemModel audits by entity id failed',

	FETCH_ALL_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Fetch all GoodsReceiveNoteItemModel',
	FETCH_ALL_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Fetch all GoodsReceiveNoteItemModel successfully',
	FETCH_ALL_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Fetch all GoodsReceiveNoteItemModel failed',

	FETCH_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY = '[ENTITY] Fetch GoodsReceiveNoteItemModel with query',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch GoodsReceiveNoteItemModel with query successfully',
	FETCH_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch GoodsReceiveNoteItemModel with query failed',

	FETCH_LAST_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY = '[ENTITY] Fetch last GoodsReceiveNoteItemModel with query',
	FETCH_LAST_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last GoodsReceiveNoteItemModel with query successfully',
	FETCH_LAST_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last GoodsReceiveNoteItemModel with query failed',

	EXPORT_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Export GoodsReceiveNoteItemModel',
	EXPORT_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Export GoodsReceiveNoteItemModel successfully',
	EXPORT_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Export GoodsReceiveNoteItemModel failed',

	EXPORT_ALL_GOODS_RECEIVE_NOTE_ITEM = '[ENTITY] Export All GoodsReceiveNoteItemModels',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_ITEM_OK = '[ENTITY] Export All GoodsReceiveNoteItemModels successfully',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_ITEM_FAIL = '[ENTITY] Export All GoodsReceiveNoteItemModels failed',

	EXPORT_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS = '[ENTITY] Export GoodsReceiveNoteItemModels excluding Ids',
	EXPORT_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export GoodsReceiveNoteItemModel excluding Ids successfully',
	EXPORT_GOODS_RECEIVE_NOTE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export GoodsReceiveNoteItemModel excluding Ids failed',

	COUNT_GOODS_RECEIVE_NOTE_ITEMS = '[ENTITY] Fetch number of GoodsReceiveNoteItemModel records',
	COUNT_GOODS_RECEIVE_NOTE_ITEMS_OK = '[ENTITY] Fetch number of GoodsReceiveNoteItemModel records successfully ',
	COUNT_GOODS_RECEIVE_NOTE_ITEMS_FAIL = '[ENTITY] Fetch number of GoodsReceiveNoteItemModel records failed',

	IMPORT_GOODS_RECEIVE_NOTE_ITEMS = '[ENTITY] Import GoodsReceiveNoteItemModels',
	IMPORT_GOODS_RECEIVE_NOTE_ITEMS_OK = '[ENTITY] Import GoodsReceiveNoteItemModels successfully',
	IMPORT_GOODS_RECEIVE_NOTE_ITEMS_FAIL = '[ENTITY] Import GoodsReceiveNoteItemModels fail',


	INITIALISE_GOODS_RECEIVE_NOTE_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of GoodsReceiveNoteItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseGoodsReceiveNoteItemAction implements Action {
	readonly className: string = 'GoodsReceiveNoteItemModel';

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

export class GoodsReceiveNoteItemAction extends BaseGoodsReceiveNoteItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemAction here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteItemModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemAction here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemAction here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemAction here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemAction here] end
}

export class GoodsReceiveNoteItemActionOK extends BaseGoodsReceiveNoteItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemActionOK here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteItemModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: GoodsReceiveNoteItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemActionOK here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemActionOK here] end
}

export class GoodsReceiveNoteItemActionFail extends BaseGoodsReceiveNoteItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemActionFail here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<GoodsReceiveNoteItemModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemActionFail here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteItemActionFail here] end
}

export function isGoodsReceiveNoteItemModelAction(e: any): e is BaseGoodsReceiveNoteItemAction {
	return Object.values(GoodsReceiveNoteItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
