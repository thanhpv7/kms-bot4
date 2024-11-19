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
import {InventoryAdjustmentModel} from './inventory_adjustment.model';
import {InventoryAdjustmentModelAudit} from './inventory_adjustment.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inventory Adjustment model actions to be dispatched by NgRx.
 */
export enum InventoryAdjustmentModelActionTypes {
	CREATE_INVENTORY_ADJUSTMENT = '[ENTITY] Create InventoryAdjustmentModel',
	CREATE_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Create InventoryAdjustmentModel successfully',
	CREATE_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Create InventoryAdjustmentModel failed',

	CREATE_ALL_INVENTORY_ADJUSTMENT = '[ENTITY] Create All InventoryAdjustmentModel',
	CREATE_ALL_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Create All InventoryAdjustmentModel successfully',
	CREATE_ALL_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Create All InventoryAdjustmentModel failed',

	DELETE_INVENTORY_ADJUSTMENT = '[ENTITY] Delete InventoryAdjustmentModel',
	DELETE_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Delete InventoryAdjustmentModel successfully',
	DELETE_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Delete InventoryAdjustmentModel failed',


	DELETE_INVENTORY_ADJUSTMENT_EXCLUDING_IDS = '[ENTITY] Delete InventoryAdjustmentModels Excluding Ids',
	DELETE_INVENTORY_ADJUSTMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete InventoryAdjustmentModels Excluding Ids successfully',
	DELETE_INVENTORY_ADJUSTMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InventoryAdjustmentModels Excluding Ids failed',

	DELETE_ALL_INVENTORY_ADJUSTMENT = '[ENTITY] Delete all InventoryAdjustmentModels',
	DELETE_ALL_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Delete all InventoryAdjustmentModels successfully',
	DELETE_ALL_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Delete all InventoryAdjustmentModels failed',

	UPDATE_INVENTORY_ADJUSTMENT = '[ENTITY] Update InventoryAdjustmentModel',
	UPDATE_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Update InventoryAdjustmentModel successfully',
	UPDATE_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Update InventoryAdjustmentModel failed',

	UPDATE_ALL_INVENTORY_ADJUSTMENT = '[ENTITY] Update all InventoryAdjustmentModel',
	UPDATE_ALL_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Update all InventoryAdjustmentModel successfully',
	UPDATE_ALL_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Update all InventoryAdjustmentModel failed',

	FETCH_INVENTORY_ADJUSTMENT= '[ENTITY] Fetch InventoryAdjustmentModel',
	FETCH_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Fetch InventoryAdjustmentModel successfully',
	FETCH_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Fetch InventoryAdjustmentModel failed',

	FETCH_INVENTORY_ADJUSTMENT_AUDIT= '[ENTITY] Fetch InventoryAdjustmentModel audit',
	FETCH_INVENTORY_ADJUSTMENT_AUDIT_OK = '[ENTITY] Fetch InventoryAdjustmentModel audit successfully',
	FETCH_INVENTORY_ADJUSTMENT_AUDIT_FAIL = '[ENTITY] Fetch InventoryAdjustmentModel audit failed',

	FETCH_INVENTORY_ADJUSTMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InventoryAdjustmentModel audits by entity id',
	FETCH_INVENTORY_ADJUSTMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InventoryAdjustmentModel audits by entity id successfully',
	FETCH_INVENTORY_ADJUSTMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InventoryAdjustmentModel audits by entity id failed',

	FETCH_ALL_INVENTORY_ADJUSTMENT = '[ENTITY] Fetch all InventoryAdjustmentModel',
	FETCH_ALL_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Fetch all InventoryAdjustmentModel successfully',
	FETCH_ALL_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Fetch all InventoryAdjustmentModel failed',

	FETCH_INVENTORY_ADJUSTMENT_WITH_QUERY = '[ENTITY] Fetch InventoryAdjustmentModel with query',
	FETCH_INVENTORY_ADJUSTMENT_WITH_QUERY_OK = '[ENTITY] Fetch InventoryAdjustmentModel with query successfully',
	FETCH_INVENTORY_ADJUSTMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch InventoryAdjustmentModel with query failed',

	FETCH_LAST_INVENTORY_ADJUSTMENT_WITH_QUERY = '[ENTITY] Fetch last InventoryAdjustmentModel with query',
	FETCH_LAST_INVENTORY_ADJUSTMENT_WITH_QUERY_OK = '[ENTITY] Fetch last InventoryAdjustmentModel with query successfully',
	FETCH_LAST_INVENTORY_ADJUSTMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last InventoryAdjustmentModel with query failed',

	EXPORT_INVENTORY_ADJUSTMENT = '[ENTITY] Export InventoryAdjustmentModel',
	EXPORT_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Export InventoryAdjustmentModel successfully',
	EXPORT_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Export InventoryAdjustmentModel failed',

	EXPORT_ALL_INVENTORY_ADJUSTMENT = '[ENTITY] Export All InventoryAdjustmentModels',
	EXPORT_ALL_INVENTORY_ADJUSTMENT_OK = '[ENTITY] Export All InventoryAdjustmentModels successfully',
	EXPORT_ALL_INVENTORY_ADJUSTMENT_FAIL = '[ENTITY] Export All InventoryAdjustmentModels failed',

	EXPORT_INVENTORY_ADJUSTMENT_EXCLUDING_IDS = '[ENTITY] Export InventoryAdjustmentModels excluding Ids',
	EXPORT_INVENTORY_ADJUSTMENT_EXCLUDING_IDS_OK = '[ENTITY] Export InventoryAdjustmentModel excluding Ids successfully',
	EXPORT_INVENTORY_ADJUSTMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export InventoryAdjustmentModel excluding Ids failed',

	COUNT_INVENTORY_ADJUSTMENTS = '[ENTITY] Fetch number of InventoryAdjustmentModel records',
	COUNT_INVENTORY_ADJUSTMENTS_OK = '[ENTITY] Fetch number of InventoryAdjustmentModel records successfully ',
	COUNT_INVENTORY_ADJUSTMENTS_FAIL = '[ENTITY] Fetch number of InventoryAdjustmentModel records failed',

	IMPORT_INVENTORY_ADJUSTMENTS = '[ENTITY] Import InventoryAdjustmentModels',
	IMPORT_INVENTORY_ADJUSTMENTS_OK = '[ENTITY] Import InventoryAdjustmentModels successfully',
	IMPORT_INVENTORY_ADJUSTMENTS_FAIL = '[ENTITY] Import InventoryAdjustmentModels fail',


	INITIALISE_INVENTORY_ADJUSTMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InventoryAdjustmentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInventoryAdjustmentAction implements Action {
	readonly className: string = 'InventoryAdjustmentModel';

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

export class InventoryAdjustmentAction extends BaseInventoryAdjustmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentAction here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjustmentModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentAction here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentAction here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentAction here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentAction here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentAction here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentAction here] end
}

export class InventoryAdjustmentActionOK extends BaseInventoryAdjustmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentActionOK here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InventoryAdjustmentModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InventoryAdjustmentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentActionOK here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentActionOK here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentActionOK here] end
}

export class InventoryAdjustmentActionFail extends BaseInventoryAdjustmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InventoryAdjustmentActionFail here] off begin
	// % protected region % [Add any additional class fields for InventoryAdjustmentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InventoryAdjustmentModel>,
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InventoryAdjustmentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InventoryAdjustmentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InventoryAdjustmentActionFail here] end
	}

	// % protected region % [Add any additional class methods for InventoryAdjustmentActionFail here] off begin
	// % protected region % [Add any additional class methods for InventoryAdjustmentActionFail here] end
}

export function isInventoryAdjustmentModelAction(e: any): e is BaseInventoryAdjustmentAction {
	return Object.values(InventoryAdjustmentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
