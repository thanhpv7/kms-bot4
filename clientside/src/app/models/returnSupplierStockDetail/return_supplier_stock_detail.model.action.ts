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
import {ReturnSupplierStockDetailModel} from './return_supplier_stock_detail.model';
import {ReturnSupplierStockDetailModelAudit} from './return_supplier_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Return Supplier Stock Detail model actions to be dispatched by NgRx.
 */
export enum ReturnSupplierStockDetailModelActionTypes {
	CREATE_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Create ReturnSupplierStockDetailModel',
	CREATE_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Create ReturnSupplierStockDetailModel successfully',
	CREATE_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Create ReturnSupplierStockDetailModel failed',

	CREATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Create All ReturnSupplierStockDetailModel',
	CREATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Create All ReturnSupplierStockDetailModel successfully',
	CREATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Create All ReturnSupplierStockDetailModel failed',

	DELETE_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Delete ReturnSupplierStockDetailModel',
	DELETE_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Delete ReturnSupplierStockDetailModel successfully',
	DELETE_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Delete ReturnSupplierStockDetailModel failed',


	DELETE_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete ReturnSupplierStockDetailModels Excluding Ids',
	DELETE_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete ReturnSupplierStockDetailModels Excluding Ids successfully',
	DELETE_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ReturnSupplierStockDetailModels Excluding Ids failed',

	DELETE_ALL_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Delete all ReturnSupplierStockDetailModels',
	DELETE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Delete all ReturnSupplierStockDetailModels successfully',
	DELETE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Delete all ReturnSupplierStockDetailModels failed',

	UPDATE_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Update ReturnSupplierStockDetailModel',
	UPDATE_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Update ReturnSupplierStockDetailModel successfully',
	UPDATE_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Update ReturnSupplierStockDetailModel failed',

	UPDATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Update all ReturnSupplierStockDetailModel',
	UPDATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Update all ReturnSupplierStockDetailModel successfully',
	UPDATE_ALL_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Update all ReturnSupplierStockDetailModel failed',

	FETCH_RETURN_SUPPLIER_STOCK_DETAIL= '[ENTITY] Fetch ReturnSupplierStockDetailModel',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Fetch ReturnSupplierStockDetailModel successfully',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch ReturnSupplierStockDetailModel failed',

	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch ReturnSupplierStockDetailModel audit',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch ReturnSupplierStockDetailModel audit successfully',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch ReturnSupplierStockDetailModel audit failed',

	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ReturnSupplierStockDetailModel audits by entity id',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ReturnSupplierStockDetailModel audits by entity id successfully',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ReturnSupplierStockDetailModel audits by entity id failed',

	FETCH_ALL_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Fetch all ReturnSupplierStockDetailModel',
	FETCH_ALL_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Fetch all ReturnSupplierStockDetailModel successfully',
	FETCH_ALL_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all ReturnSupplierStockDetailModel failed',

	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch ReturnSupplierStockDetailModel with query',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch ReturnSupplierStockDetailModel with query successfully',
	FETCH_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch ReturnSupplierStockDetailModel with query failed',

	FETCH_LAST_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last ReturnSupplierStockDetailModel with query',
	FETCH_LAST_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last ReturnSupplierStockDetailModel with query successfully',
	FETCH_LAST_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last ReturnSupplierStockDetailModel with query failed',

	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Export ReturnSupplierStockDetailModel',
	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Export ReturnSupplierStockDetailModel successfully',
	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Export ReturnSupplierStockDetailModel failed',

	EXPORT_ALL_RETURN_SUPPLIER_STOCK_DETAIL = '[ENTITY] Export All ReturnSupplierStockDetailModels',
	EXPORT_ALL_RETURN_SUPPLIER_STOCK_DETAIL_OK = '[ENTITY] Export All ReturnSupplierStockDetailModels successfully',
	EXPORT_ALL_RETURN_SUPPLIER_STOCK_DETAIL_FAIL = '[ENTITY] Export All ReturnSupplierStockDetailModels failed',

	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export ReturnSupplierStockDetailModels excluding Ids',
	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export ReturnSupplierStockDetailModel excluding Ids successfully',
	EXPORT_RETURN_SUPPLIER_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export ReturnSupplierStockDetailModel excluding Ids failed',

	COUNT_RETURN_SUPPLIER_STOCK_DETAILS = '[ENTITY] Fetch number of ReturnSupplierStockDetailModel records',
	COUNT_RETURN_SUPPLIER_STOCK_DETAILS_OK = '[ENTITY] Fetch number of ReturnSupplierStockDetailModel records successfully ',
	COUNT_RETURN_SUPPLIER_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of ReturnSupplierStockDetailModel records failed',

	IMPORT_RETURN_SUPPLIER_STOCK_DETAILS = '[ENTITY] Import ReturnSupplierStockDetailModels',
	IMPORT_RETURN_SUPPLIER_STOCK_DETAILS_OK = '[ENTITY] Import ReturnSupplierStockDetailModels successfully',
	IMPORT_RETURN_SUPPLIER_STOCK_DETAILS_FAIL = '[ENTITY] Import ReturnSupplierStockDetailModels fail',


	INITIALISE_RETURN_SUPPLIER_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ReturnSupplierStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseReturnSupplierStockDetailAction implements Action {
	readonly className: string = 'ReturnSupplierStockDetailModel';

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

export class ReturnSupplierStockDetailAction extends BaseReturnSupplierStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReturnSupplierStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailAction here] end
}

export class ReturnSupplierStockDetailActionOK extends BaseReturnSupplierStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReturnSupplierStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ReturnSupplierStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailActionOK here] end
}

export class ReturnSupplierStockDetailActionFail extends BaseReturnSupplierStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ReturnSupplierStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierStockDetailActionFail here] end
}

export function isReturnSupplierStockDetailModelAction(e: any): e is BaseReturnSupplierStockDetailAction {
	return Object.values(ReturnSupplierStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
