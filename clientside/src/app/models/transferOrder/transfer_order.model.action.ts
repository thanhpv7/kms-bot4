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
import {TransferOrderModel} from './transfer_order.model';
import {TransferOrderModelAudit} from './transfer_order.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Transfer Order model actions to be dispatched by NgRx.
 */
export enum TransferOrderModelActionTypes {
	CREATE_TRANSFER_ORDER = '[ENTITY] Create TransferOrderModel',
	CREATE_TRANSFER_ORDER_OK = '[ENTITY] Create TransferOrderModel successfully',
	CREATE_TRANSFER_ORDER_FAIL = '[ENTITY] Create TransferOrderModel failed',

	CREATE_ALL_TRANSFER_ORDER = '[ENTITY] Create All TransferOrderModel',
	CREATE_ALL_TRANSFER_ORDER_OK = '[ENTITY] Create All TransferOrderModel successfully',
	CREATE_ALL_TRANSFER_ORDER_FAIL = '[ENTITY] Create All TransferOrderModel failed',

	DELETE_TRANSFER_ORDER = '[ENTITY] Delete TransferOrderModel',
	DELETE_TRANSFER_ORDER_OK = '[ENTITY] Delete TransferOrderModel successfully',
	DELETE_TRANSFER_ORDER_FAIL = '[ENTITY] Delete TransferOrderModel failed',


	DELETE_TRANSFER_ORDER_EXCLUDING_IDS = '[ENTITY] Delete TransferOrderModels Excluding Ids',
	DELETE_TRANSFER_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Delete TransferOrderModels Excluding Ids successfully',
	DELETE_TRANSFER_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TransferOrderModels Excluding Ids failed',

	DELETE_ALL_TRANSFER_ORDER = '[ENTITY] Delete all TransferOrderModels',
	DELETE_ALL_TRANSFER_ORDER_OK = '[ENTITY] Delete all TransferOrderModels successfully',
	DELETE_ALL_TRANSFER_ORDER_FAIL = '[ENTITY] Delete all TransferOrderModels failed',

	UPDATE_TRANSFER_ORDER = '[ENTITY] Update TransferOrderModel',
	UPDATE_TRANSFER_ORDER_OK = '[ENTITY] Update TransferOrderModel successfully',
	UPDATE_TRANSFER_ORDER_FAIL = '[ENTITY] Update TransferOrderModel failed',

	UPDATE_ALL_TRANSFER_ORDER = '[ENTITY] Update all TransferOrderModel',
	UPDATE_ALL_TRANSFER_ORDER_OK = '[ENTITY] Update all TransferOrderModel successfully',
	UPDATE_ALL_TRANSFER_ORDER_FAIL = '[ENTITY] Update all TransferOrderModel failed',

	FETCH_TRANSFER_ORDER= '[ENTITY] Fetch TransferOrderModel',
	FETCH_TRANSFER_ORDER_OK = '[ENTITY] Fetch TransferOrderModel successfully',
	FETCH_TRANSFER_ORDER_FAIL = '[ENTITY] Fetch TransferOrderModel failed',

	FETCH_TRANSFER_ORDER_AUDIT= '[ENTITY] Fetch TransferOrderModel audit',
	FETCH_TRANSFER_ORDER_AUDIT_OK = '[ENTITY] Fetch TransferOrderModel audit successfully',
	FETCH_TRANSFER_ORDER_AUDIT_FAIL = '[ENTITY] Fetch TransferOrderModel audit failed',

	FETCH_TRANSFER_ORDER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TransferOrderModel audits by entity id',
	FETCH_TRANSFER_ORDER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TransferOrderModel audits by entity id successfully',
	FETCH_TRANSFER_ORDER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TransferOrderModel audits by entity id failed',

	FETCH_ALL_TRANSFER_ORDER = '[ENTITY] Fetch all TransferOrderModel',
	FETCH_ALL_TRANSFER_ORDER_OK = '[ENTITY] Fetch all TransferOrderModel successfully',
	FETCH_ALL_TRANSFER_ORDER_FAIL = '[ENTITY] Fetch all TransferOrderModel failed',

	FETCH_TRANSFER_ORDER_WITH_QUERY = '[ENTITY] Fetch TransferOrderModel with query',
	FETCH_TRANSFER_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch TransferOrderModel with query successfully',
	FETCH_TRANSFER_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch TransferOrderModel with query failed',

	FETCH_LAST_TRANSFER_ORDER_WITH_QUERY = '[ENTITY] Fetch last TransferOrderModel with query',
	FETCH_LAST_TRANSFER_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch last TransferOrderModel with query successfully',
	FETCH_LAST_TRANSFER_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch last TransferOrderModel with query failed',

	EXPORT_TRANSFER_ORDER = '[ENTITY] Export TransferOrderModel',
	EXPORT_TRANSFER_ORDER_OK = '[ENTITY] Export TransferOrderModel successfully',
	EXPORT_TRANSFER_ORDER_FAIL = '[ENTITY] Export TransferOrderModel failed',

	EXPORT_ALL_TRANSFER_ORDER = '[ENTITY] Export All TransferOrderModels',
	EXPORT_ALL_TRANSFER_ORDER_OK = '[ENTITY] Export All TransferOrderModels successfully',
	EXPORT_ALL_TRANSFER_ORDER_FAIL = '[ENTITY] Export All TransferOrderModels failed',

	EXPORT_TRANSFER_ORDER_EXCLUDING_IDS = '[ENTITY] Export TransferOrderModels excluding Ids',
	EXPORT_TRANSFER_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Export TransferOrderModel excluding Ids successfully',
	EXPORT_TRANSFER_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Export TransferOrderModel excluding Ids failed',

	COUNT_TRANSFER_ORDERS = '[ENTITY] Fetch number of TransferOrderModel records',
	COUNT_TRANSFER_ORDERS_OK = '[ENTITY] Fetch number of TransferOrderModel records successfully ',
	COUNT_TRANSFER_ORDERS_FAIL = '[ENTITY] Fetch number of TransferOrderModel records failed',

	IMPORT_TRANSFER_ORDERS = '[ENTITY] Import TransferOrderModels',
	IMPORT_TRANSFER_ORDERS_OK = '[ENTITY] Import TransferOrderModels successfully',
	IMPORT_TRANSFER_ORDERS_FAIL = '[ENTITY] Import TransferOrderModels fail',


	INITIALISE_TRANSFER_ORDER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TransferOrderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTransferOrderAction implements Action {
	readonly className: string = 'TransferOrderModel';

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

export class TransferOrderAction extends BaseTransferOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderAction here] off begin
	// % protected region % [Add any additional class fields for TransferOrderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransferOrderModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderAction here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderAction here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderAction here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderAction here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderAction here] off begin
	// % protected region % [Add any additional class methods for TransferOrderAction here] end
}

export class TransferOrderActionOK extends BaseTransferOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderActionOK here] off begin
	// % protected region % [Add any additional class fields for TransferOrderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransferOrderModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TransferOrderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderActionOK here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderActionOK here] off begin
	// % protected region % [Add any additional class methods for TransferOrderActionOK here] end
}

export class TransferOrderActionFail extends BaseTransferOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransferOrderActionFail here] off begin
	// % protected region % [Add any additional class fields for TransferOrderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TransferOrderModel>,
		// % protected region % [Add any additional constructor parameters for TransferOrderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TransferOrderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransferOrderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TransferOrderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransferOrderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TransferOrderActionFail here] end
	}

	// % protected region % [Add any additional class methods for TransferOrderActionFail here] off begin
	// % protected region % [Add any additional class methods for TransferOrderActionFail here] end
}

export function isTransferOrderModelAction(e: any): e is BaseTransferOrderAction {
	return Object.values(TransferOrderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
