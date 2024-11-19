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
import {RetailPharmacyStockDetailModel} from './retail_pharmacy_stock_detail.model';
import {RetailPharmacyStockDetailModelAudit} from './retail_pharmacy_stock_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Retail Pharmacy Stock Detail model actions to be dispatched by NgRx.
 */
export enum RetailPharmacyStockDetailModelActionTypes {
	CREATE_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Create RetailPharmacyStockDetailModel',
	CREATE_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Create RetailPharmacyStockDetailModel successfully',
	CREATE_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Create RetailPharmacyStockDetailModel failed',

	CREATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Create All RetailPharmacyStockDetailModel',
	CREATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Create All RetailPharmacyStockDetailModel successfully',
	CREATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Create All RetailPharmacyStockDetailModel failed',

	DELETE_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Delete RetailPharmacyStockDetailModel',
	DELETE_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Delete RetailPharmacyStockDetailModel successfully',
	DELETE_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Delete RetailPharmacyStockDetailModel failed',


	DELETE_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete RetailPharmacyStockDetailModels Excluding Ids',
	DELETE_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete RetailPharmacyStockDetailModels Excluding Ids successfully',
	DELETE_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RetailPharmacyStockDetailModels Excluding Ids failed',

	DELETE_ALL_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Delete all RetailPharmacyStockDetailModels',
	DELETE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Delete all RetailPharmacyStockDetailModels successfully',
	DELETE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Delete all RetailPharmacyStockDetailModels failed',

	UPDATE_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Update RetailPharmacyStockDetailModel',
	UPDATE_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Update RetailPharmacyStockDetailModel successfully',
	UPDATE_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Update RetailPharmacyStockDetailModel failed',

	UPDATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Update all RetailPharmacyStockDetailModel',
	UPDATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Update all RetailPharmacyStockDetailModel successfully',
	UPDATE_ALL_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Update all RetailPharmacyStockDetailModel failed',

	FETCH_RETAIL_PHARMACY_STOCK_DETAIL= '[ENTITY] Fetch RetailPharmacyStockDetailModel',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Fetch RetailPharmacyStockDetailModel successfully',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Fetch RetailPharmacyStockDetailModel failed',

	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDIT= '[ENTITY] Fetch RetailPharmacyStockDetailModel audit',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDIT_OK = '[ENTITY] Fetch RetailPharmacyStockDetailModel audit successfully',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch RetailPharmacyStockDetailModel audit failed',

	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RetailPharmacyStockDetailModel audits by entity id',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RetailPharmacyStockDetailModel audits by entity id successfully',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RetailPharmacyStockDetailModel audits by entity id failed',

	FETCH_ALL_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Fetch all RetailPharmacyStockDetailModel',
	FETCH_ALL_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Fetch all RetailPharmacyStockDetailModel successfully',
	FETCH_ALL_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Fetch all RetailPharmacyStockDetailModel failed',

	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch RetailPharmacyStockDetailModel with query',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch RetailPharmacyStockDetailModel with query successfully',
	FETCH_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch RetailPharmacyStockDetailModel with query failed',

	FETCH_LAST_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY = '[ENTITY] Fetch last RetailPharmacyStockDetailModel with query',
	FETCH_LAST_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last RetailPharmacyStockDetailModel with query successfully',
	FETCH_LAST_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last RetailPharmacyStockDetailModel with query failed',

	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Export RetailPharmacyStockDetailModel',
	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Export RetailPharmacyStockDetailModel successfully',
	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Export RetailPharmacyStockDetailModel failed',

	EXPORT_ALL_RETAIL_PHARMACY_STOCK_DETAIL = '[ENTITY] Export All RetailPharmacyStockDetailModels',
	EXPORT_ALL_RETAIL_PHARMACY_STOCK_DETAIL_OK = '[ENTITY] Export All RetailPharmacyStockDetailModels successfully',
	EXPORT_ALL_RETAIL_PHARMACY_STOCK_DETAIL_FAIL = '[ENTITY] Export All RetailPharmacyStockDetailModels failed',

	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS = '[ENTITY] Export RetailPharmacyStockDetailModels excluding Ids',
	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export RetailPharmacyStockDetailModel excluding Ids successfully',
	EXPORT_RETAIL_PHARMACY_STOCK_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export RetailPharmacyStockDetailModel excluding Ids failed',

	COUNT_RETAIL_PHARMACY_STOCK_DETAILS = '[ENTITY] Fetch number of RetailPharmacyStockDetailModel records',
	COUNT_RETAIL_PHARMACY_STOCK_DETAILS_OK = '[ENTITY] Fetch number of RetailPharmacyStockDetailModel records successfully ',
	COUNT_RETAIL_PHARMACY_STOCK_DETAILS_FAIL = '[ENTITY] Fetch number of RetailPharmacyStockDetailModel records failed',

	IMPORT_RETAIL_PHARMACY_STOCK_DETAILS = '[ENTITY] Import RetailPharmacyStockDetailModels',
	IMPORT_RETAIL_PHARMACY_STOCK_DETAILS_OK = '[ENTITY] Import RetailPharmacyStockDetailModels successfully',
	IMPORT_RETAIL_PHARMACY_STOCK_DETAILS_FAIL = '[ENTITY] Import RetailPharmacyStockDetailModels fail',


	INITIALISE_RETAIL_PHARMACY_STOCK_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RetailPharmacyStockDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRetailPharmacyStockDetailAction implements Action {
	readonly className: string = 'RetailPharmacyStockDetailModel';

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

export class RetailPharmacyStockDetailAction extends BaseRetailPharmacyStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailAction here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailAction here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailAction here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailAction here] end
}

export class RetailPharmacyStockDetailActionOK extends BaseRetailPharmacyStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RetailPharmacyStockDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailActionOK here] end
}

export class RetailPharmacyStockDetailActionFail extends BaseRetailPharmacyStockDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyStockDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RetailPharmacyStockDetailModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyStockDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyStockDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyStockDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyStockDetailActionFail here] end
}

export function isRetailPharmacyStockDetailModelAction(e: any): e is BaseRetailPharmacyStockDetailAction {
	return Object.values(RetailPharmacyStockDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
