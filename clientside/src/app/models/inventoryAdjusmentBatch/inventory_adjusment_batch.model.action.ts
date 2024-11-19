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
import {InventoryAdjusmentBatchModel} from './inventory_adjusment_batch.model';
import {InventoryAdjusmentBatchModelAudit} from './inventory_adjusment_batch.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inventory Adjusment Batch model actions to be dispatched by NgRx.
 */
export enum InventoryAdjusmentBatchModelActionTypes {
	CREATE_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Create InventoryAdjusmentBatchModel',
	CREATE_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Create InventoryAdjusmentBatchModel successfully',
	CREATE_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Create InventoryAdjusmentBatchModel failed',

	CREATE_ALL_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Create All InventoryAdjusmentBatchModel',
	CREATE_ALL_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Create All InventoryAdjusmentBatchModel successfully',
	CREATE_ALL_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Create All InventoryAdjusmentBatchModel failed',

	DELETE_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Delete InventoryAdjusmentBatchModel',
	DELETE_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Delete InventoryAdjusmentBatchModel successfully',
	DELETE_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Delete InventoryAdjusmentBatchModel failed',


	DELETE_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS = '[ENTITY] Delete InventoryAdjusmentBatchModels Excluding Ids',
	DELETE_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS_OK = '[ENTITY] Delete InventoryAdjusmentBatchModels Excluding Ids successfully',
	DELETE_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InventoryAdjusmentBatchModels Excluding Ids failed',

	DELETE_ALL_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Delete all InventoryAdjusmentBatchModels',
	DELETE_ALL_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Delete all InventoryAdjusmentBatchModels successfully',
	DELETE_ALL_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Delete all InventoryAdjusmentBatchModels failed',

	UPDATE_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Update InventoryAdjusmentBatchModel',
	UPDATE_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Update InventoryAdjusmentBatchModel successfully',
	UPDATE_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Update InventoryAdjusmentBatchModel failed',

	UPDATE_ALL_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Update all InventoryAdjusmentBatchModel',
	UPDATE_ALL_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Update all InventoryAdjusmentBatchModel successfully',
	UPDATE_ALL_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Update all InventoryAdjusmentBatchModel failed',

	FETCH_INVENTORY_ADJUSMENT_BATCH= '[ENTITY] Fetch InventoryAdjusmentBatchModel',
	FETCH_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Fetch InventoryAdjusmentBatchModel successfully',
	FETCH_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Fetch InventoryAdjusmentBatchModel failed',

	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDIT= '[ENTITY] Fetch InventoryAdjusmentBatchModel audit',
	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDIT_OK = '[ENTITY] Fetch InventoryAdjusmentBatchModel audit successfully',
	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDIT_FAIL = '[ENTITY] Fetch InventoryAdjusmentBatchModel audit failed',

	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InventoryAdjusmentBatchModel audits by entity id',
	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InventoryAdjusmentBatchModel audits by entity id successfully',
	FETCH_INVENTORY_ADJUSMENT_BATCH_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InventoryAdjusmentBatchModel audits by entity id failed',

	FETCH_ALL_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Fetch all InventoryAdjusmentBatchModel',
	FETCH_ALL_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Fetch all InventoryAdjusmentBatchModel successfully',
	FETCH_ALL_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Fetch all InventoryAdjusmentBatchModel failed',

	FETCH_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY = '[ENTITY] Fetch InventoryAdjusmentBatchModel with query',
	FETCH_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY_OK = '[ENTITY] Fetch InventoryAdjusmentBatchModel with query successfully',
	FETCH_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY_FAIL = '[ENTITY] Fetch InventoryAdjusmentBatchModel with query failed',

	FETCH_LAST_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY = '[ENTITY] Fetch last InventoryAdjusmentBatchModel with query',
	FETCH_LAST_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY_OK = '[ENTITY] Fetch last InventoryAdjusmentBatchModel with query successfully',
	FETCH_LAST_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY_FAIL = '[ENTITY] Fetch last InventoryAdjusmentBatchModel with query failed',

	EXPORT_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Export InventoryAdjusmentBatchModel',
	EXPORT_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Export InventoryAdjusmentBatchModel successfully',
	EXPORT_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Export InventoryAdjusmentBatchModel failed',

	EXPORT_ALL_INVENTORY_ADJUSMENT_BATCH = '[ENTITY] Export All InventoryAdjusmentBatchModels',
	EXPORT_ALL_INVENTORY_ADJUSMENT_BATCH_OK = '[ENTITY] Export All InventoryAdjusmentBatchModels successfully',
	EXPORT_ALL_INVENTORY_ADJUSMENT_BATCH_FAIL = '[ENTITY] Export All InventoryAdjusmentBatchModels failed',

	EXPORT_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS = '[ENTITY] Export InventoryAdjusmentBatchModels excluding Ids',
	EXPORT_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS_OK = '[ENTITY] Export InventoryAdjusmentBatchModel excluding Ids successfully',
	EXPORT_INVENTORY_ADJUSMENT_BATCH_EXCLUDING_IDS_FAIL = '[ENTITY] Export InventoryAdjusmentBatchModel excluding Ids failed',

	COUNT_INVENTORY_ADJUSMENT_BATCHS = '[ENTITY] Fetch number of InventoryAdjusmentBatchModel records',
	COUNT_INVENTORY_ADJUSMENT_BATCHS_OK = '[ENTITY] Fetch number of InventoryAdjusmentBatchModel records successfully ',
	COUNT_INVENTORY_ADJUSMENT_BATCHS_FAIL = '[ENTITY] Fetch number of InventoryAdjusmentBatchModel records failed',

	IMPORT_INVENTORY_ADJUSMENT_BATCHS = '[ENTITY] Import InventoryAdjusmentBatchModels',
	IMPORT_INVENTORY_ADJUSMENT_BATCHS_OK = '[ENTITY] Import InventoryAdjusmentBatchModels successfully',
	IMPORT_INVENTORY_ADJUSMENT_BATCHS_FAIL = '[ENTITY] Import InventoryAdjusmentBatchModels fail',


	INITIALISE_INVENTORY_ADJUSMENT_BATCH_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InventoryAdjusmentBatchModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInventoryAdjusmentBatchAction implements Action {
	readonly className: string = 'InventoryAdjusmentBatchModel';

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

export class InventoryAdjusmentBatchAction extends BaseInventoryAdjusmentBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchAction here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjusmentBatchModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchAction here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchAction here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchAction here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchAction here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchAction here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchAction here] end
}

export class InventoryAdjusmentBatchActionOK extends BaseInventoryAdjusmentBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchActionOK here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjusmentBatchModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InventoryAdjusmentBatchModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchActionOK here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchActionOK here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchActionOK here] end
}

export class InventoryAdjusmentBatchActionFail extends BaseInventoryAdjusmentBatchAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchActionFail here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjusmentBatchActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InventoryAdjusmentBatchModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjusmentBatchActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjusmentBatchActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjusmentBatchActionFail here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchActionFail here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjusmentBatchActionFail here] end
}

export function isInventoryAdjusmentBatchModelAction(e: any): e is BaseInventoryAdjusmentBatchAction {
	return Object.values(InventoryAdjusmentBatchModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
