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
import {InternalOrderModel} from './internal_order.model';
import {InternalOrderModelAudit} from './internal_order.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Internal Order model actions to be dispatched by NgRx.
 */
export enum InternalOrderModelActionTypes {
	CREATE_INTERNAL_ORDER = '[ENTITY] Create InternalOrderModel',
	CREATE_INTERNAL_ORDER_OK = '[ENTITY] Create InternalOrderModel successfully',
	CREATE_INTERNAL_ORDER_FAIL = '[ENTITY] Create InternalOrderModel failed',

	CREATE_ALL_INTERNAL_ORDER = '[ENTITY] Create All InternalOrderModel',
	CREATE_ALL_INTERNAL_ORDER_OK = '[ENTITY] Create All InternalOrderModel successfully',
	CREATE_ALL_INTERNAL_ORDER_FAIL = '[ENTITY] Create All InternalOrderModel failed',

	DELETE_INTERNAL_ORDER = '[ENTITY] Delete InternalOrderModel',
	DELETE_INTERNAL_ORDER_OK = '[ENTITY] Delete InternalOrderModel successfully',
	DELETE_INTERNAL_ORDER_FAIL = '[ENTITY] Delete InternalOrderModel failed',


	DELETE_INTERNAL_ORDER_EXCLUDING_IDS = '[ENTITY] Delete InternalOrderModels Excluding Ids',
	DELETE_INTERNAL_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Delete InternalOrderModels Excluding Ids successfully',
	DELETE_INTERNAL_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InternalOrderModels Excluding Ids failed',

	DELETE_ALL_INTERNAL_ORDER = '[ENTITY] Delete all InternalOrderModels',
	DELETE_ALL_INTERNAL_ORDER_OK = '[ENTITY] Delete all InternalOrderModels successfully',
	DELETE_ALL_INTERNAL_ORDER_FAIL = '[ENTITY] Delete all InternalOrderModels failed',

	UPDATE_INTERNAL_ORDER = '[ENTITY] Update InternalOrderModel',
	UPDATE_INTERNAL_ORDER_OK = '[ENTITY] Update InternalOrderModel successfully',
	UPDATE_INTERNAL_ORDER_FAIL = '[ENTITY] Update InternalOrderModel failed',

	UPDATE_ALL_INTERNAL_ORDER = '[ENTITY] Update all InternalOrderModel',
	UPDATE_ALL_INTERNAL_ORDER_OK = '[ENTITY] Update all InternalOrderModel successfully',
	UPDATE_ALL_INTERNAL_ORDER_FAIL = '[ENTITY] Update all InternalOrderModel failed',

	FETCH_INTERNAL_ORDER= '[ENTITY] Fetch InternalOrderModel',
	FETCH_INTERNAL_ORDER_OK = '[ENTITY] Fetch InternalOrderModel successfully',
	FETCH_INTERNAL_ORDER_FAIL = '[ENTITY] Fetch InternalOrderModel failed',

	FETCH_INTERNAL_ORDER_AUDIT= '[ENTITY] Fetch InternalOrderModel audit',
	FETCH_INTERNAL_ORDER_AUDIT_OK = '[ENTITY] Fetch InternalOrderModel audit successfully',
	FETCH_INTERNAL_ORDER_AUDIT_FAIL = '[ENTITY] Fetch InternalOrderModel audit failed',

	FETCH_INTERNAL_ORDER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InternalOrderModel audits by entity id',
	FETCH_INTERNAL_ORDER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InternalOrderModel audits by entity id successfully',
	FETCH_INTERNAL_ORDER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InternalOrderModel audits by entity id failed',

	FETCH_ALL_INTERNAL_ORDER = '[ENTITY] Fetch all InternalOrderModel',
	FETCH_ALL_INTERNAL_ORDER_OK = '[ENTITY] Fetch all InternalOrderModel successfully',
	FETCH_ALL_INTERNAL_ORDER_FAIL = '[ENTITY] Fetch all InternalOrderModel failed',

	FETCH_INTERNAL_ORDER_WITH_QUERY = '[ENTITY] Fetch InternalOrderModel with query',
	FETCH_INTERNAL_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch InternalOrderModel with query successfully',
	FETCH_INTERNAL_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch InternalOrderModel with query failed',

	FETCH_LAST_INTERNAL_ORDER_WITH_QUERY = '[ENTITY] Fetch last InternalOrderModel with query',
	FETCH_LAST_INTERNAL_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch last InternalOrderModel with query successfully',
	FETCH_LAST_INTERNAL_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch last InternalOrderModel with query failed',

	EXPORT_INTERNAL_ORDER = '[ENTITY] Export InternalOrderModel',
	EXPORT_INTERNAL_ORDER_OK = '[ENTITY] Export InternalOrderModel successfully',
	EXPORT_INTERNAL_ORDER_FAIL = '[ENTITY] Export InternalOrderModel failed',

	EXPORT_ALL_INTERNAL_ORDER = '[ENTITY] Export All InternalOrderModels',
	EXPORT_ALL_INTERNAL_ORDER_OK = '[ENTITY] Export All InternalOrderModels successfully',
	EXPORT_ALL_INTERNAL_ORDER_FAIL = '[ENTITY] Export All InternalOrderModels failed',

	EXPORT_INTERNAL_ORDER_EXCLUDING_IDS = '[ENTITY] Export InternalOrderModels excluding Ids',
	EXPORT_INTERNAL_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Export InternalOrderModel excluding Ids successfully',
	EXPORT_INTERNAL_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Export InternalOrderModel excluding Ids failed',

	COUNT_INTERNAL_ORDERS = '[ENTITY] Fetch number of InternalOrderModel records',
	COUNT_INTERNAL_ORDERS_OK = '[ENTITY] Fetch number of InternalOrderModel records successfully ',
	COUNT_INTERNAL_ORDERS_FAIL = '[ENTITY] Fetch number of InternalOrderModel records failed',

	IMPORT_INTERNAL_ORDERS = '[ENTITY] Import InternalOrderModels',
	IMPORT_INTERNAL_ORDERS_OK = '[ENTITY] Import InternalOrderModels successfully',
	IMPORT_INTERNAL_ORDERS_FAIL = '[ENTITY] Import InternalOrderModels fail',


	INITIALISE_INTERNAL_ORDER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InternalOrderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInternalOrderAction implements Action {
	readonly className: string = 'InternalOrderModel';

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

export class InternalOrderAction extends BaseInternalOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderAction here] off begin
	// % protected region % [Add any additional class fields for InternalOrderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InternalOrderModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderAction here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderAction here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderAction here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderAction here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderAction here] off begin
	// % protected region % [Add any additional class methods for InternalOrderAction here] end
}

export class InternalOrderActionOK extends BaseInternalOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderActionOK here] off begin
	// % protected region % [Add any additional class fields for InternalOrderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InternalOrderModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InternalOrderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderActionOK here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderActionOK here] off begin
	// % protected region % [Add any additional class methods for InternalOrderActionOK here] end
}

export class InternalOrderActionFail extends BaseInternalOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderActionFail here] off begin
	// % protected region % [Add any additional class fields for InternalOrderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InternalOrderModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderActionFail here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderActionFail here] off begin
	// % protected region % [Add any additional class methods for InternalOrderActionFail here] end
}

export function isInternalOrderModelAction(e: any): e is BaseInternalOrderAction {
	return Object.values(InternalOrderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
