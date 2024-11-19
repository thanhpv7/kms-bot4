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
import {GoodsReceiveNoteModel} from './goods_receive_note.model';
import {GoodsReceiveNoteModelAudit} from './goods_receive_note.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Goods Receive Note model actions to be dispatched by NgRx.
 */
export enum GoodsReceiveNoteModelActionTypes {
	CREATE_GOODS_RECEIVE_NOTE = '[ENTITY] Create GoodsReceiveNoteModel',
	CREATE_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Create GoodsReceiveNoteModel successfully',
	CREATE_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Create GoodsReceiveNoteModel failed',

	CREATE_ALL_GOODS_RECEIVE_NOTE = '[ENTITY] Create All GoodsReceiveNoteModel',
	CREATE_ALL_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Create All GoodsReceiveNoteModel successfully',
	CREATE_ALL_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Create All GoodsReceiveNoteModel failed',

	DELETE_GOODS_RECEIVE_NOTE = '[ENTITY] Delete GoodsReceiveNoteModel',
	DELETE_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Delete GoodsReceiveNoteModel successfully',
	DELETE_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Delete GoodsReceiveNoteModel failed',


	DELETE_GOODS_RECEIVE_NOTE_EXCLUDING_IDS = '[ENTITY] Delete GoodsReceiveNoteModels Excluding Ids',
	DELETE_GOODS_RECEIVE_NOTE_EXCLUDING_IDS_OK = '[ENTITY] Delete GoodsReceiveNoteModels Excluding Ids successfully',
	DELETE_GOODS_RECEIVE_NOTE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete GoodsReceiveNoteModels Excluding Ids failed',

	DELETE_ALL_GOODS_RECEIVE_NOTE = '[ENTITY] Delete all GoodsReceiveNoteModels',
	DELETE_ALL_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Delete all GoodsReceiveNoteModels successfully',
	DELETE_ALL_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Delete all GoodsReceiveNoteModels failed',

	UPDATE_GOODS_RECEIVE_NOTE = '[ENTITY] Update GoodsReceiveNoteModel',
	UPDATE_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Update GoodsReceiveNoteModel successfully',
	UPDATE_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Update GoodsReceiveNoteModel failed',

	UPDATE_ALL_GOODS_RECEIVE_NOTE = '[ENTITY] Update all GoodsReceiveNoteModel',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Update all GoodsReceiveNoteModel successfully',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Update all GoodsReceiveNoteModel failed',

	FETCH_GOODS_RECEIVE_NOTE= '[ENTITY] Fetch GoodsReceiveNoteModel',
	FETCH_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Fetch GoodsReceiveNoteModel successfully',
	FETCH_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Fetch GoodsReceiveNoteModel failed',

	FETCH_GOODS_RECEIVE_NOTE_AUDIT= '[ENTITY] Fetch GoodsReceiveNoteModel audit',
	FETCH_GOODS_RECEIVE_NOTE_AUDIT_OK = '[ENTITY] Fetch GoodsReceiveNoteModel audit successfully',
	FETCH_GOODS_RECEIVE_NOTE_AUDIT_FAIL = '[ENTITY] Fetch GoodsReceiveNoteModel audit failed',

	FETCH_GOODS_RECEIVE_NOTE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch GoodsReceiveNoteModel audits by entity id',
	FETCH_GOODS_RECEIVE_NOTE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch GoodsReceiveNoteModel audits by entity id successfully',
	FETCH_GOODS_RECEIVE_NOTE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch GoodsReceiveNoteModel audits by entity id failed',

	FETCH_ALL_GOODS_RECEIVE_NOTE = '[ENTITY] Fetch all GoodsReceiveNoteModel',
	FETCH_ALL_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Fetch all GoodsReceiveNoteModel successfully',
	FETCH_ALL_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Fetch all GoodsReceiveNoteModel failed',

	FETCH_GOODS_RECEIVE_NOTE_WITH_QUERY = '[ENTITY] Fetch GoodsReceiveNoteModel with query',
	FETCH_GOODS_RECEIVE_NOTE_WITH_QUERY_OK = '[ENTITY] Fetch GoodsReceiveNoteModel with query successfully',
	FETCH_GOODS_RECEIVE_NOTE_WITH_QUERY_FAIL = '[ENTITY] Fetch GoodsReceiveNoteModel with query failed',

	FETCH_LAST_GOODS_RECEIVE_NOTE_WITH_QUERY = '[ENTITY] Fetch last GoodsReceiveNoteModel with query',
	FETCH_LAST_GOODS_RECEIVE_NOTE_WITH_QUERY_OK = '[ENTITY] Fetch last GoodsReceiveNoteModel with query successfully',
	FETCH_LAST_GOODS_RECEIVE_NOTE_WITH_QUERY_FAIL = '[ENTITY] Fetch last GoodsReceiveNoteModel with query failed',

	EXPORT_GOODS_RECEIVE_NOTE = '[ENTITY] Export GoodsReceiveNoteModel',
	EXPORT_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Export GoodsReceiveNoteModel successfully',
	EXPORT_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Export GoodsReceiveNoteModel failed',

	EXPORT_ALL_GOODS_RECEIVE_NOTE = '[ENTITY] Export All GoodsReceiveNoteModels',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_OK = '[ENTITY] Export All GoodsReceiveNoteModels successfully',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_FAIL = '[ENTITY] Export All GoodsReceiveNoteModels failed',

	EXPORT_GOODS_RECEIVE_NOTE_EXCLUDING_IDS = '[ENTITY] Export GoodsReceiveNoteModels excluding Ids',
	EXPORT_GOODS_RECEIVE_NOTE_EXCLUDING_IDS_OK = '[ENTITY] Export GoodsReceiveNoteModel excluding Ids successfully',
	EXPORT_GOODS_RECEIVE_NOTE_EXCLUDING_IDS_FAIL = '[ENTITY] Export GoodsReceiveNoteModel excluding Ids failed',

	COUNT_GOODS_RECEIVE_NOTES = '[ENTITY] Fetch number of GoodsReceiveNoteModel records',
	COUNT_GOODS_RECEIVE_NOTES_OK = '[ENTITY] Fetch number of GoodsReceiveNoteModel records successfully ',
	COUNT_GOODS_RECEIVE_NOTES_FAIL = '[ENTITY] Fetch number of GoodsReceiveNoteModel records failed',

	IMPORT_GOODS_RECEIVE_NOTES = '[ENTITY] Import GoodsReceiveNoteModels',
	IMPORT_GOODS_RECEIVE_NOTES_OK = '[ENTITY] Import GoodsReceiveNoteModels successfully',
	IMPORT_GOODS_RECEIVE_NOTES_FAIL = '[ENTITY] Import GoodsReceiveNoteModels fail',


	INITIALISE_GOODS_RECEIVE_NOTE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of GoodsReceiveNoteModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseGoodsReceiveNoteAction implements Action {
	readonly className: string = 'GoodsReceiveNoteModel';

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

export class GoodsReceiveNoteAction extends BaseGoodsReceiveNoteAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteAction here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteAction here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteAction here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteAction here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteAction here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteAction here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteAction here] end
}

export class GoodsReceiveNoteActionOK extends BaseGoodsReceiveNoteAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteActionOK here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: GoodsReceiveNoteModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteActionOK here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteActionOK here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteActionOK here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteActionOK here] end
}

export class GoodsReceiveNoteActionFail extends BaseGoodsReceiveNoteAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteActionFail here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<GoodsReceiveNoteModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteActionFail here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteActionFail here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteActionFail here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteActionFail here] end
}

export function isGoodsReceiveNoteModelAction(e: any): e is BaseGoodsReceiveNoteAction {
	return Object.values(GoodsReceiveNoteModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
