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
import {PurchaseOrderModel} from './purchase_order.model';
import {PurchaseOrderModelAudit} from './purchase_order.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Purchase Order model actions to be dispatched by NgRx.
 */
export enum PurchaseOrderModelActionTypes {
	CREATE_PURCHASE_ORDER = '[ENTITY] Create PurchaseOrderModel',
	CREATE_PURCHASE_ORDER_OK = '[ENTITY] Create PurchaseOrderModel successfully',
	CREATE_PURCHASE_ORDER_FAIL = '[ENTITY] Create PurchaseOrderModel failed',

	CREATE_ALL_PURCHASE_ORDER = '[ENTITY] Create All PurchaseOrderModel',
	CREATE_ALL_PURCHASE_ORDER_OK = '[ENTITY] Create All PurchaseOrderModel successfully',
	CREATE_ALL_PURCHASE_ORDER_FAIL = '[ENTITY] Create All PurchaseOrderModel failed',

	DELETE_PURCHASE_ORDER = '[ENTITY] Delete PurchaseOrderModel',
	DELETE_PURCHASE_ORDER_OK = '[ENTITY] Delete PurchaseOrderModel successfully',
	DELETE_PURCHASE_ORDER_FAIL = '[ENTITY] Delete PurchaseOrderModel failed',


	DELETE_PURCHASE_ORDER_EXCLUDING_IDS = '[ENTITY] Delete PurchaseOrderModels Excluding Ids',
	DELETE_PURCHASE_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Delete PurchaseOrderModels Excluding Ids successfully',
	DELETE_PURCHASE_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PurchaseOrderModels Excluding Ids failed',

	DELETE_ALL_PURCHASE_ORDER = '[ENTITY] Delete all PurchaseOrderModels',
	DELETE_ALL_PURCHASE_ORDER_OK = '[ENTITY] Delete all PurchaseOrderModels successfully',
	DELETE_ALL_PURCHASE_ORDER_FAIL = '[ENTITY] Delete all PurchaseOrderModels failed',

	UPDATE_PURCHASE_ORDER = '[ENTITY] Update PurchaseOrderModel',
	UPDATE_PURCHASE_ORDER_OK = '[ENTITY] Update PurchaseOrderModel successfully',
	UPDATE_PURCHASE_ORDER_FAIL = '[ENTITY] Update PurchaseOrderModel failed',

	UPDATE_ALL_PURCHASE_ORDER = '[ENTITY] Update all PurchaseOrderModel',
	UPDATE_ALL_PURCHASE_ORDER_OK = '[ENTITY] Update all PurchaseOrderModel successfully',
	UPDATE_ALL_PURCHASE_ORDER_FAIL = '[ENTITY] Update all PurchaseOrderModel failed',

	FETCH_PURCHASE_ORDER= '[ENTITY] Fetch PurchaseOrderModel',
	FETCH_PURCHASE_ORDER_OK = '[ENTITY] Fetch PurchaseOrderModel successfully',
	FETCH_PURCHASE_ORDER_FAIL = '[ENTITY] Fetch PurchaseOrderModel failed',

	FETCH_PURCHASE_ORDER_AUDIT= '[ENTITY] Fetch PurchaseOrderModel audit',
	FETCH_PURCHASE_ORDER_AUDIT_OK = '[ENTITY] Fetch PurchaseOrderModel audit successfully',
	FETCH_PURCHASE_ORDER_AUDIT_FAIL = '[ENTITY] Fetch PurchaseOrderModel audit failed',

	FETCH_PURCHASE_ORDER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PurchaseOrderModel audits by entity id',
	FETCH_PURCHASE_ORDER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PurchaseOrderModel audits by entity id successfully',
	FETCH_PURCHASE_ORDER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PurchaseOrderModel audits by entity id failed',

	FETCH_ALL_PURCHASE_ORDER = '[ENTITY] Fetch all PurchaseOrderModel',
	FETCH_ALL_PURCHASE_ORDER_OK = '[ENTITY] Fetch all PurchaseOrderModel successfully',
	FETCH_ALL_PURCHASE_ORDER_FAIL = '[ENTITY] Fetch all PurchaseOrderModel failed',

	FETCH_PURCHASE_ORDER_WITH_QUERY = '[ENTITY] Fetch PurchaseOrderModel with query',
	FETCH_PURCHASE_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch PurchaseOrderModel with query successfully',
	FETCH_PURCHASE_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch PurchaseOrderModel with query failed',

	FETCH_LAST_PURCHASE_ORDER_WITH_QUERY = '[ENTITY] Fetch last PurchaseOrderModel with query',
	FETCH_LAST_PURCHASE_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch last PurchaseOrderModel with query successfully',
	FETCH_LAST_PURCHASE_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch last PurchaseOrderModel with query failed',

	EXPORT_PURCHASE_ORDER = '[ENTITY] Export PurchaseOrderModel',
	EXPORT_PURCHASE_ORDER_OK = '[ENTITY] Export PurchaseOrderModel successfully',
	EXPORT_PURCHASE_ORDER_FAIL = '[ENTITY] Export PurchaseOrderModel failed',

	EXPORT_ALL_PURCHASE_ORDER = '[ENTITY] Export All PurchaseOrderModels',
	EXPORT_ALL_PURCHASE_ORDER_OK = '[ENTITY] Export All PurchaseOrderModels successfully',
	EXPORT_ALL_PURCHASE_ORDER_FAIL = '[ENTITY] Export All PurchaseOrderModels failed',

	EXPORT_PURCHASE_ORDER_EXCLUDING_IDS = '[ENTITY] Export PurchaseOrderModels excluding Ids',
	EXPORT_PURCHASE_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Export PurchaseOrderModel excluding Ids successfully',
	EXPORT_PURCHASE_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Export PurchaseOrderModel excluding Ids failed',

	COUNT_PURCHASE_ORDERS = '[ENTITY] Fetch number of PurchaseOrderModel records',
	COUNT_PURCHASE_ORDERS_OK = '[ENTITY] Fetch number of PurchaseOrderModel records successfully ',
	COUNT_PURCHASE_ORDERS_FAIL = '[ENTITY] Fetch number of PurchaseOrderModel records failed',

	IMPORT_PURCHASE_ORDERS = '[ENTITY] Import PurchaseOrderModels',
	IMPORT_PURCHASE_ORDERS_OK = '[ENTITY] Import PurchaseOrderModels successfully',
	IMPORT_PURCHASE_ORDERS_FAIL = '[ENTITY] Import PurchaseOrderModels fail',


	INITIALISE_PURCHASE_ORDER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PurchaseOrderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePurchaseOrderAction implements Action {
	readonly className: string = 'PurchaseOrderModel';

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

export class PurchaseOrderAction extends BasePurchaseOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderAction here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseOrderModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderAction here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderAction here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderAction here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderAction here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderAction here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderAction here] end
}

export class PurchaseOrderActionOK extends BasePurchaseOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderActionOK here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseOrderModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PurchaseOrderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderActionOK here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderActionOK here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderActionOK here] end
}

export class PurchaseOrderActionFail extends BasePurchaseOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseOrderActionFail here] off begin
	// % protected region % [Add any additional class fields for PurchaseOrderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PurchaseOrderModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseOrderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseOrderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseOrderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseOrderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseOrderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseOrderActionFail here] end
	}

	// % protected region % [Add any additional class methods for PurchaseOrderActionFail here] off begin
	// % protected region % [Add any additional class methods for PurchaseOrderActionFail here] end
}

export function isPurchaseOrderModelAction(e: any): e is BasePurchaseOrderAction {
	return Object.values(PurchaseOrderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
