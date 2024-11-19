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
import {InventoryBatchCorrectionModel} from './inventory_batch_correction.model';
import {InventoryBatchCorrectionModelAudit} from './inventory_batch_correction.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inventory Batch Correction model actions to be dispatched by NgRx.
 */
export enum InventoryBatchCorrectionModelActionTypes {
	CREATE_INVENTORY_BATCH_CORRECTION = '[ENTITY] Create InventoryBatchCorrectionModel',
	CREATE_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Create InventoryBatchCorrectionModel successfully',
	CREATE_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Create InventoryBatchCorrectionModel failed',

	CREATE_ALL_INVENTORY_BATCH_CORRECTION = '[ENTITY] Create All InventoryBatchCorrectionModel',
	CREATE_ALL_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Create All InventoryBatchCorrectionModel successfully',
	CREATE_ALL_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Create All InventoryBatchCorrectionModel failed',

	DELETE_INVENTORY_BATCH_CORRECTION = '[ENTITY] Delete InventoryBatchCorrectionModel',
	DELETE_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Delete InventoryBatchCorrectionModel successfully',
	DELETE_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Delete InventoryBatchCorrectionModel failed',


	DELETE_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS = '[ENTITY] Delete InventoryBatchCorrectionModels Excluding Ids',
	DELETE_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS_OK = '[ENTITY] Delete InventoryBatchCorrectionModels Excluding Ids successfully',
	DELETE_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InventoryBatchCorrectionModels Excluding Ids failed',

	DELETE_ALL_INVENTORY_BATCH_CORRECTION = '[ENTITY] Delete all InventoryBatchCorrectionModels',
	DELETE_ALL_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Delete all InventoryBatchCorrectionModels successfully',
	DELETE_ALL_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Delete all InventoryBatchCorrectionModels failed',

	UPDATE_INVENTORY_BATCH_CORRECTION = '[ENTITY] Update InventoryBatchCorrectionModel',
	UPDATE_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Update InventoryBatchCorrectionModel successfully',
	UPDATE_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Update InventoryBatchCorrectionModel failed',

	UPDATE_ALL_INVENTORY_BATCH_CORRECTION = '[ENTITY] Update all InventoryBatchCorrectionModel',
	UPDATE_ALL_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Update all InventoryBatchCorrectionModel successfully',
	UPDATE_ALL_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Update all InventoryBatchCorrectionModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION= '[ENTITY] Fetch InventoryBatchCorrectionModel',
	FETCH_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Fetch InventoryBatchCorrectionModel successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION_AUDIT= '[ENTITY] Fetch InventoryBatchCorrectionModel audit',
	FETCH_INVENTORY_BATCH_CORRECTION_AUDIT_OK = '[ENTITY] Fetch InventoryBatchCorrectionModel audit successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_AUDIT_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionModel audit failed',

	FETCH_INVENTORY_BATCH_CORRECTION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InventoryBatchCorrectionModel audits by entity id',
	FETCH_INVENTORY_BATCH_CORRECTION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InventoryBatchCorrectionModel audits by entity id successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionModel audits by entity id failed',

	FETCH_ALL_INVENTORY_BATCH_CORRECTION = '[ENTITY] Fetch all InventoryBatchCorrectionModel',
	FETCH_ALL_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Fetch all InventoryBatchCorrectionModel successfully',
	FETCH_ALL_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Fetch all InventoryBatchCorrectionModel failed',

	FETCH_INVENTORY_BATCH_CORRECTION_WITH_QUERY = '[ENTITY] Fetch InventoryBatchCorrectionModel with query',
	FETCH_INVENTORY_BATCH_CORRECTION_WITH_QUERY_OK = '[ENTITY] Fetch InventoryBatchCorrectionModel with query successfully',
	FETCH_INVENTORY_BATCH_CORRECTION_WITH_QUERY_FAIL = '[ENTITY] Fetch InventoryBatchCorrectionModel with query failed',

	FETCH_LAST_INVENTORY_BATCH_CORRECTION_WITH_QUERY = '[ENTITY] Fetch last InventoryBatchCorrectionModel with query',
	FETCH_LAST_INVENTORY_BATCH_CORRECTION_WITH_QUERY_OK = '[ENTITY] Fetch last InventoryBatchCorrectionModel with query successfully',
	FETCH_LAST_INVENTORY_BATCH_CORRECTION_WITH_QUERY_FAIL = '[ENTITY] Fetch last InventoryBatchCorrectionModel with query failed',

	EXPORT_INVENTORY_BATCH_CORRECTION = '[ENTITY] Export InventoryBatchCorrectionModel',
	EXPORT_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Export InventoryBatchCorrectionModel successfully',
	EXPORT_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Export InventoryBatchCorrectionModel failed',

	EXPORT_ALL_INVENTORY_BATCH_CORRECTION = '[ENTITY] Export All InventoryBatchCorrectionModels',
	EXPORT_ALL_INVENTORY_BATCH_CORRECTION_OK = '[ENTITY] Export All InventoryBatchCorrectionModels successfully',
	EXPORT_ALL_INVENTORY_BATCH_CORRECTION_FAIL = '[ENTITY] Export All InventoryBatchCorrectionModels failed',

	EXPORT_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS = '[ENTITY] Export InventoryBatchCorrectionModels excluding Ids',
	EXPORT_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS_OK = '[ENTITY] Export InventoryBatchCorrectionModel excluding Ids successfully',
	EXPORT_INVENTORY_BATCH_CORRECTION_EXCLUDING_IDS_FAIL = '[ENTITY] Export InventoryBatchCorrectionModel excluding Ids failed',

	COUNT_INVENTORY_BATCH_CORRECTIONS = '[ENTITY] Fetch number of InventoryBatchCorrectionModel records',
	COUNT_INVENTORY_BATCH_CORRECTIONS_OK = '[ENTITY] Fetch number of InventoryBatchCorrectionModel records successfully ',
	COUNT_INVENTORY_BATCH_CORRECTIONS_FAIL = '[ENTITY] Fetch number of InventoryBatchCorrectionModel records failed',

	IMPORT_INVENTORY_BATCH_CORRECTIONS = '[ENTITY] Import InventoryBatchCorrectionModels',
	IMPORT_INVENTORY_BATCH_CORRECTIONS_OK = '[ENTITY] Import InventoryBatchCorrectionModels successfully',
	IMPORT_INVENTORY_BATCH_CORRECTIONS_FAIL = '[ENTITY] Import InventoryBatchCorrectionModels fail',


	INITIALISE_INVENTORY_BATCH_CORRECTION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InventoryBatchCorrectionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInventoryBatchCorrectionAction implements Action {
	readonly className: string = 'InventoryBatchCorrectionModel';

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

export class InventoryBatchCorrectionAction extends BaseInventoryBatchCorrectionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionAction here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryBatchCorrectionModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionAction here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionAction here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionAction here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionAction here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionAction here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionAction here] end
}

export class InventoryBatchCorrectionActionOK extends BaseInventoryBatchCorrectionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionActionOK here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryBatchCorrectionModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InventoryBatchCorrectionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionActionOK here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionActionOK here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionActionOK here] end
}

export class InventoryBatchCorrectionActionFail extends BaseInventoryBatchCorrectionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryBatchCorrectionActionFail here] off begin
	// % protected region % [Add any additional class fields for InventoryBatchCorrectionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InventoryBatchCorrectionModel>,
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryBatchCorrectionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryBatchCorrectionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InventoryBatchCorrectionActionFail here] end
	}

	// % protected region % [Add any additional class methods for InventoryBatchCorrectionActionFail here] off begin
	// % protected region % [Add any additional class methods for InventoryBatchCorrectionActionFail here] end
}

export function isInventoryBatchCorrectionModelAction(e: any): e is BaseInventoryBatchCorrectionAction {
	return Object.values(InventoryBatchCorrectionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
