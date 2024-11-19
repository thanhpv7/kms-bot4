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
import {SupplierProductDetailModel} from './supplier_product_detail.model';
import {SupplierProductDetailModelAudit} from './supplier_product_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Supplier Product Detail model actions to be dispatched by NgRx.
 */
export enum SupplierProductDetailModelActionTypes {
	CREATE_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Create SupplierProductDetailModel',
	CREATE_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Create SupplierProductDetailModel successfully',
	CREATE_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Create SupplierProductDetailModel failed',

	CREATE_ALL_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Create All SupplierProductDetailModel',
	CREATE_ALL_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Create All SupplierProductDetailModel successfully',
	CREATE_ALL_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Create All SupplierProductDetailModel failed',

	DELETE_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Delete SupplierProductDetailModel',
	DELETE_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Delete SupplierProductDetailModel successfully',
	DELETE_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Delete SupplierProductDetailModel failed',


	DELETE_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete SupplierProductDetailModels Excluding Ids',
	DELETE_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete SupplierProductDetailModels Excluding Ids successfully',
	DELETE_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SupplierProductDetailModels Excluding Ids failed',

	DELETE_ALL_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Delete all SupplierProductDetailModels',
	DELETE_ALL_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Delete all SupplierProductDetailModels successfully',
	DELETE_ALL_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Delete all SupplierProductDetailModels failed',

	UPDATE_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Update SupplierProductDetailModel',
	UPDATE_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Update SupplierProductDetailModel successfully',
	UPDATE_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Update SupplierProductDetailModel failed',

	UPDATE_ALL_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Update all SupplierProductDetailModel',
	UPDATE_ALL_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Update all SupplierProductDetailModel successfully',
	UPDATE_ALL_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Update all SupplierProductDetailModel failed',

	FETCH_SUPPLIER_PRODUCT_DETAIL= '[ENTITY] Fetch SupplierProductDetailModel',
	FETCH_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Fetch SupplierProductDetailModel successfully',
	FETCH_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Fetch SupplierProductDetailModel failed',

	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDIT= '[ENTITY] Fetch SupplierProductDetailModel audit',
	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDIT_OK = '[ENTITY] Fetch SupplierProductDetailModel audit successfully',
	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch SupplierProductDetailModel audit failed',

	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SupplierProductDetailModel audits by entity id',
	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SupplierProductDetailModel audits by entity id successfully',
	FETCH_SUPPLIER_PRODUCT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SupplierProductDetailModel audits by entity id failed',

	FETCH_ALL_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Fetch all SupplierProductDetailModel',
	FETCH_ALL_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Fetch all SupplierProductDetailModel successfully',
	FETCH_ALL_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Fetch all SupplierProductDetailModel failed',

	FETCH_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY = '[ENTITY] Fetch SupplierProductDetailModel with query',
	FETCH_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch SupplierProductDetailModel with query successfully',
	FETCH_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch SupplierProductDetailModel with query failed',

	FETCH_LAST_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last SupplierProductDetailModel with query',
	FETCH_LAST_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last SupplierProductDetailModel with query successfully',
	FETCH_LAST_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last SupplierProductDetailModel with query failed',

	EXPORT_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Export SupplierProductDetailModel',
	EXPORT_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Export SupplierProductDetailModel successfully',
	EXPORT_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Export SupplierProductDetailModel failed',

	EXPORT_ALL_SUPPLIER_PRODUCT_DETAIL = '[ENTITY] Export All SupplierProductDetailModels',
	EXPORT_ALL_SUPPLIER_PRODUCT_DETAIL_OK = '[ENTITY] Export All SupplierProductDetailModels successfully',
	EXPORT_ALL_SUPPLIER_PRODUCT_DETAIL_FAIL = '[ENTITY] Export All SupplierProductDetailModels failed',

	EXPORT_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export SupplierProductDetailModels excluding Ids',
	EXPORT_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export SupplierProductDetailModel excluding Ids successfully',
	EXPORT_SUPPLIER_PRODUCT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export SupplierProductDetailModel excluding Ids failed',

	COUNT_SUPPLIER_PRODUCT_DETAILS = '[ENTITY] Fetch number of SupplierProductDetailModel records',
	COUNT_SUPPLIER_PRODUCT_DETAILS_OK = '[ENTITY] Fetch number of SupplierProductDetailModel records successfully ',
	COUNT_SUPPLIER_PRODUCT_DETAILS_FAIL = '[ENTITY] Fetch number of SupplierProductDetailModel records failed',

	IMPORT_SUPPLIER_PRODUCT_DETAILS = '[ENTITY] Import SupplierProductDetailModels',
	IMPORT_SUPPLIER_PRODUCT_DETAILS_OK = '[ENTITY] Import SupplierProductDetailModels successfully',
	IMPORT_SUPPLIER_PRODUCT_DETAILS_FAIL = '[ENTITY] Import SupplierProductDetailModels fail',


	INITIALISE_SUPPLIER_PRODUCT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SupplierProductDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSupplierProductDetailAction implements Action {
	readonly className: string = 'SupplierProductDetailModel';

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

export class SupplierProductDetailAction extends BaseSupplierProductDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierProductDetailAction here] off begin
	// % protected region % [Add any additional class fields for SupplierProductDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierProductDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierProductDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for SupplierProductDetailAction here] end
	}

	// % protected region % [Add any additional class methods for SupplierProductDetailAction here] off begin
	// % protected region % [Add any additional class methods for SupplierProductDetailAction here] end
}

export class SupplierProductDetailActionOK extends BaseSupplierProductDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierProductDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for SupplierProductDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierProductDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SupplierProductDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierProductDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SupplierProductDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for SupplierProductDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for SupplierProductDetailActionOK here] end
}

export class SupplierProductDetailActionFail extends BaseSupplierProductDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierProductDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for SupplierProductDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SupplierProductDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierProductDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierProductDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierProductDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SupplierProductDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for SupplierProductDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for SupplierProductDetailActionFail here] end
}

export function isSupplierProductDetailModelAction(e: any): e is BaseSupplierProductDetailAction {
	return Object.values(SupplierProductDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
