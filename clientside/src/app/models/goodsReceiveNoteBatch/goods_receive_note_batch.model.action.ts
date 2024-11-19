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
import {GoodsReceiveNoteBatchModel} from './goods_receive_note_batch.model';
import {GoodsReceiveNoteBatchModelAudit} from './goods_receive_note_batch.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Goods Receive Note Batch model actions to be dispatched by NgRx.
 */
export enum GoodsReceiveNoteBatchModelActionTypes {
	CREATE_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Create GoodsReceiveNoteBatchModel',
	CREATE_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Create GoodsReceiveNoteBatchModel successfully',
	CREATE_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Create GoodsReceiveNoteBatchModel failed',

	CREATE_ALL_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Create All GoodsReceiveNoteBatchModel',
	CREATE_ALL_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Create All GoodsReceiveNoteBatchModel successfully',
	CREATE_ALL_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Create All GoodsReceiveNoteBatchModel failed',

	DELETE_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Delete GoodsReceiveNoteBatchModel',
	DELETE_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Delete GoodsReceiveNoteBatchModel successfully',
	DELETE_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Delete GoodsReceiveNoteBatchModel failed',


	DELETE_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS = '[ENTITY] Delete GoodsReceiveNoteBatchModels Excluding Ids',
	DELETE_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS_OK = '[ENTITY] Delete GoodsReceiveNoteBatchModels Excluding Ids successfully',
	DELETE_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS_FAIL = '[ENTITY] Delete GoodsReceiveNoteBatchModels Excluding Ids failed',

	DELETE_ALL_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Delete all GoodsReceiveNoteBatchModels',
	DELETE_ALL_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Delete all GoodsReceiveNoteBatchModels successfully',
	DELETE_ALL_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Delete all GoodsReceiveNoteBatchModels failed',

	UPDATE_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Update GoodsReceiveNoteBatchModel',
	UPDATE_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Update GoodsReceiveNoteBatchModel successfully',
	UPDATE_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Update GoodsReceiveNoteBatchModel failed',

	UPDATE_ALL_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Update all GoodsReceiveNoteBatchModel',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Update all GoodsReceiveNoteBatchModel successfully',
	UPDATE_ALL_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Update all GoodsReceiveNoteBatchModel failed',

	FETCH_GOODS_RECEIVE_NOTE_BATCH= '[ENTITY] Fetch GoodsReceiveNoteBatchModel',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Fetch GoodsReceiveNoteBatchModel successfully',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Fetch GoodsReceiveNoteBatchModel failed',

	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDIT= '[ENTITY] Fetch GoodsReceiveNoteBatchModel audit',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDIT_OK = '[ENTITY] Fetch GoodsReceiveNoteBatchModel audit successfully',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDIT_FAIL = '[ENTITY] Fetch GoodsReceiveNoteBatchModel audit failed',

	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch GoodsReceiveNoteBatchModel audits by entity id',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch GoodsReceiveNoteBatchModel audits by entity id successfully',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch GoodsReceiveNoteBatchModel audits by entity id failed',

	FETCH_ALL_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Fetch all GoodsReceiveNoteBatchModel',
	FETCH_ALL_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Fetch all GoodsReceiveNoteBatchModel successfully',
	FETCH_ALL_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Fetch all GoodsReceiveNoteBatchModel failed',

	FETCH_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY = '[ENTITY] Fetch GoodsReceiveNoteBatchModel with query',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY_OK = '[ENTITY] Fetch GoodsReceiveNoteBatchModel with query successfully',
	FETCH_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY_FAIL = '[ENTITY] Fetch GoodsReceiveNoteBatchModel with query failed',

	FETCH_LAST_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY = '[ENTITY] Fetch last GoodsReceiveNoteBatchModel with query',
	FETCH_LAST_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY_OK = '[ENTITY] Fetch last GoodsReceiveNoteBatchModel with query successfully',
	FETCH_LAST_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY_FAIL = '[ENTITY] Fetch last GoodsReceiveNoteBatchModel with query failed',

	EXPORT_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Export GoodsReceiveNoteBatchModel',
	EXPORT_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Export GoodsReceiveNoteBatchModel successfully',
	EXPORT_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Export GoodsReceiveNoteBatchModel failed',

	EXPORT_ALL_GOODS_RECEIVE_NOTE_BATCH = '[ENTITY] Export All GoodsReceiveNoteBatchModels',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_BATCH_OK = '[ENTITY] Export All GoodsReceiveNoteBatchModels successfully',
	EXPORT_ALL_GOODS_RECEIVE_NOTE_BATCH_FAIL = '[ENTITY] Export All GoodsReceiveNoteBatchModels failed',

	EXPORT_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS = '[ENTITY] Export GoodsReceiveNoteBatchModels excluding Ids',
	EXPORT_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS_OK = '[ENTITY] Export GoodsReceiveNoteBatchModel excluding Ids successfully',
	EXPORT_GOODS_RECEIVE_NOTE_BATCH_EXCLUDING_IDS_FAIL = '[ENTITY] Export GoodsReceiveNoteBatchModel excluding Ids failed',

	COUNT_GOODS_RECEIVE_NOTE_BATCHS = '[ENTITY] Fetch number of GoodsReceiveNoteBatchModel records',
	COUNT_GOODS_RECEIVE_NOTE_BATCHS_OK = '[ENTITY] Fetch number of GoodsReceiveNoteBatchModel records successfully ',
	COUNT_GOODS_RECEIVE_NOTE_BATCHS_FAIL = '[ENTITY] Fetch number of GoodsReceiveNoteBatchModel records failed',

	IMPORT_GOODS_RECEIVE_NOTE_BATCHS = '[ENTITY] Import GoodsReceiveNoteBatchModels',
	IMPORT_GOODS_RECEIVE_NOTE_BATCHS_OK = '[ENTITY] Import GoodsReceiveNoteBatchModels successfully',
	IMPORT_GOODS_RECEIVE_NOTE_BATCHS_FAIL = '[ENTITY] Import GoodsReceiveNoteBatchModels fail',


	INITIALISE_GOODS_RECEIVE_NOTE_BATCH_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of GoodsReceiveNoteBatchModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseGoodsReceiveNoteBatchAction implements Action {
	readonly className: string = 'GoodsReceiveNoteBatchModel';

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

export class GoodsReceiveNoteBatchAction extends BaseGoodsReceiveNoteBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchAction here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteBatchModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchAction here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchAction here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchAction here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchAction here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchAction here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchAction here] end
}

export class GoodsReceiveNoteBatchActionOK extends BaseGoodsReceiveNoteBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchActionOK here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<GoodsReceiveNoteBatchModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: GoodsReceiveNoteBatchModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchActionOK here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchActionOK here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchActionOK here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchActionOK here] end
}

export class GoodsReceiveNoteBatchActionFail extends BaseGoodsReceiveNoteBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchActionFail here] off begin
	// % protected region % [Add any additional class fields for GoodsReceiveNoteBatchActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<GoodsReceiveNoteBatchModel>,
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for GoodsReceiveNoteBatchActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for GoodsReceiveNoteBatchActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchActionFail here] off begin
		// % protected region % [Add any additional constructor logic for GoodsReceiveNoteBatchActionFail here] end
	}

	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchActionFail here] off begin
	// % protected region % [Add any additional class methods for GoodsReceiveNoteBatchActionFail here] end
}

export function isGoodsReceiveNoteBatchModelAction(e: any): e is BaseGoodsReceiveNoteBatchAction {
	return Object.values(GoodsReceiveNoteBatchModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
