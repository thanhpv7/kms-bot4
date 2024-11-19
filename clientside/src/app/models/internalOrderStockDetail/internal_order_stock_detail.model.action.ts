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
import {InternalOrderStockDetailModel} from './internal_order_stock_detail.model';
import {InternalOrderStockDetailModelAudit} from './internal_order_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Internal Order Stock Detail model actions to be dispatched by NgRx.
 */
export enum InternalOrderStockDetailModelActionTypes {
	CREATE_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Create InternalOrderStockDetailModel',
	CREATE_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create InternalOrderStockDetailModel successfully',
	CREATE_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create InternalOrderStockDetailModel failed',

	CREATE_ALL_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Create All InternalOrderStockDetailModel',
	CREATE_ALL_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Create All InternalOrderStockDetailModel successfully',
	CREATE_ALL_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Create All InternalOrderStockDetailModel failed',

	DELETE_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Delete InternalOrderStockDetailModel',
	DELETE_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete InternalOrderStockDetailModel successfully',
	DELETE_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete InternalOrderStockDetailModel failed',


	DELETE_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete InternalOrderStockDetailModels Excluding Ids',
	DELETE_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete InternalOrderStockDetailModels Excluding Ids successfully',
	DELETE_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InternalOrderStockDetailModels Excluding Ids failed',

	DELETE_ALL_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Delete all InternalOrderStockDetailModels',
	DELETE_ALL_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Delete all InternalOrderStockDetailModels successfully',
	DELETE_ALL_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Delete all InternalOrderStockDetailModels failed',

	UPDATE_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Update InternalOrderStockDetailModel',
	UPDATE_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update InternalOrderStockDetailModel successfully',
	UPDATE_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update InternalOrderStockDetailModel failed',

	UPDATE_ALL_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Update all InternalOrderStockDetailModel',
	UPDATE_ALL_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Update all InternalOrderStockDetailModel successfully',
	UPDATE_ALL_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Update all InternalOrderStockDetailModel failed',

	FETCH_INTERNAL_ORDER_STOCK_DETAIL= '[ENTITY] Fetch InternalOrderStockDetailModel',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch InternalOrderStockDetailModel successfully',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch InternalOrderStockDetailModel failed',

	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch InternalOrderStockDetailModel audit',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch InternalOrderStockDetailModel audit successfully',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch InternalOrderStockDetailModel audit failed',

	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InternalOrderStockDetailModel audits by entity id',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InternalOrderStockDetailModel audits by entity id successfully',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InternalOrderStockDetailModel audits by entity id failed',

	FETCH_ALL_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Fetch all InternalOrderStockDetailModel',
	FETCH_ALL_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Fetch all InternalOrderStockDetailModel successfully',
	FETCH_ALL_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all InternalOrderStockDetailModel failed',

	FETCH_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch InternalOrderStockDetailModel with query',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch InternalOrderStockDetailModel with query successfully',
	FETCH_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch InternalOrderStockDetailModel with query failed',

	FETCH_LAST_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last InternalOrderStockDetailModel with query',
	FETCH_LAST_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last InternalOrderStockDetailModel with query successfully',
	FETCH_LAST_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last InternalOrderStockDetailModel with query failed',

	EXPORT_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Export InternalOrderStockDetailModel',
	EXPORT_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export InternalOrderStockDetailModel successfully',
	EXPORT_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export InternalOrderStockDetailModel failed',

	EXPORT_ALL_INTERNAL_ORDER_STOCK_DETAIL = '[ENTITY] Export All InternalOrderStockDetailModels',
	EXPORT_ALL_INTERNAL_ORDER_STOCK_DETAIL_OK = '[ENTITY] Export All InternalOrderStockDetailModels successfully',
	EXPORT_ALL_INTERNAL_ORDER_STOCK_DETAIL_FAIL = '[ENTITY] Export All InternalOrderStockDetailModels failed',

	EXPORT_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export InternalOrderStockDetailModels excluding Ids',
	EXPORT_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export InternalOrderStockDetailModel excluding Ids successfully',
	EXPORT_INTERNAL_ORDER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export InternalOrderStockDetailModel excluding Ids failed',

	COUNT_INTERNAL_ORDER_STOCK_DETAILS = '[ENTITY] Fetch number of InternalOrderStockDetailModel records',
	COUNT_INTERNAL_ORDER_STOCK_DETAILS_OK = '[ENTITY] Fetch number of InternalOrderStockDetailModel records successfully ',
	COUNT_INTERNAL_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of InternalOrderStockDetailModel records failed',

	IMPORT_INTERNAL_ORDER_STOCK_DETAILS = '[ENTITY] Import InternalOrderStockDetailModels',
	IMPORT_INTERNAL_ORDER_STOCK_DETAILS_OK = '[ENTITY] Import InternalOrderStockDetailModels successfully',
	IMPORT_INTERNAL_ORDER_STOCK_DETAILS_FAIL = '[ENTITY] Import InternalOrderStockDetailModels fail',


	INITIALISE_INTERNAL_ORDER_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InternalOrderStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInternalOrderStockDetailAction implements Action {
	readonly className: string = 'InternalOrderStockDetailModel';

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

export class InternalOrderStockDetailAction extends BaseInternalOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for InternalOrderStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InternalOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for InternalOrderStockDetailAction here] end
}

export class InternalOrderStockDetailActionOK extends BaseInternalOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for InternalOrderStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InternalOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InternalOrderStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for InternalOrderStockDetailActionOK here] end
}

export class InternalOrderStockDetailActionFail extends BaseInternalOrderStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InternalOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for InternalOrderStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InternalOrderStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InternalOrderStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InternalOrderStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InternalOrderStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for InternalOrderStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for InternalOrderStockDetailActionFail here] end
}

export function isInternalOrderStockDetailModelAction(e: any): e is BaseInternalOrderStockDetailAction {
	return Object.values(InternalOrderStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
