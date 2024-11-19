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
import {SupplierContactDetailModel} from './supplier_contact_detail.model';
import {SupplierContactDetailModelAudit} from './supplier_contact_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Supplier Contact Detail model actions to be dispatched by NgRx.
 */
export enum SupplierContactDetailModelActionTypes {
	CREATE_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Create SupplierContactDetailModel',
	CREATE_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Create SupplierContactDetailModel successfully',
	CREATE_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Create SupplierContactDetailModel failed',

	CREATE_ALL_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Create All SupplierContactDetailModel',
	CREATE_ALL_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Create All SupplierContactDetailModel successfully',
	CREATE_ALL_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Create All SupplierContactDetailModel failed',

	DELETE_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Delete SupplierContactDetailModel',
	DELETE_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Delete SupplierContactDetailModel successfully',
	DELETE_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Delete SupplierContactDetailModel failed',


	DELETE_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete SupplierContactDetailModels Excluding Ids',
	DELETE_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete SupplierContactDetailModels Excluding Ids successfully',
	DELETE_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SupplierContactDetailModels Excluding Ids failed',

	DELETE_ALL_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Delete all SupplierContactDetailModels',
	DELETE_ALL_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Delete all SupplierContactDetailModels successfully',
	DELETE_ALL_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Delete all SupplierContactDetailModels failed',

	UPDATE_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Update SupplierContactDetailModel',
	UPDATE_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Update SupplierContactDetailModel successfully',
	UPDATE_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Update SupplierContactDetailModel failed',

	UPDATE_ALL_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Update all SupplierContactDetailModel',
	UPDATE_ALL_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Update all SupplierContactDetailModel successfully',
	UPDATE_ALL_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Update all SupplierContactDetailModel failed',

	FETCH_SUPPLIER_CONTACT_DETAIL= '[ENTITY] Fetch SupplierContactDetailModel',
	FETCH_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Fetch SupplierContactDetailModel successfully',
	FETCH_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Fetch SupplierContactDetailModel failed',

	FETCH_SUPPLIER_CONTACT_DETAIL_AUDIT= '[ENTITY] Fetch SupplierContactDetailModel audit',
	FETCH_SUPPLIER_CONTACT_DETAIL_AUDIT_OK = '[ENTITY] Fetch SupplierContactDetailModel audit successfully',
	FETCH_SUPPLIER_CONTACT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch SupplierContactDetailModel audit failed',

	FETCH_SUPPLIER_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SupplierContactDetailModel audits by entity id',
	FETCH_SUPPLIER_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SupplierContactDetailModel audits by entity id successfully',
	FETCH_SUPPLIER_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SupplierContactDetailModel audits by entity id failed',

	FETCH_ALL_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Fetch all SupplierContactDetailModel',
	FETCH_ALL_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Fetch all SupplierContactDetailModel successfully',
	FETCH_ALL_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Fetch all SupplierContactDetailModel failed',

	FETCH_SUPPLIER_CONTACT_DETAIL_WITH_QUERY = '[ENTITY] Fetch SupplierContactDetailModel with query',
	FETCH_SUPPLIER_CONTACT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch SupplierContactDetailModel with query successfully',
	FETCH_SUPPLIER_CONTACT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch SupplierContactDetailModel with query failed',

	FETCH_LAST_SUPPLIER_CONTACT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last SupplierContactDetailModel with query',
	FETCH_LAST_SUPPLIER_CONTACT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last SupplierContactDetailModel with query successfully',
	FETCH_LAST_SUPPLIER_CONTACT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last SupplierContactDetailModel with query failed',

	EXPORT_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Export SupplierContactDetailModel',
	EXPORT_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Export SupplierContactDetailModel successfully',
	EXPORT_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Export SupplierContactDetailModel failed',

	EXPORT_ALL_SUPPLIER_CONTACT_DETAIL = '[ENTITY] Export All SupplierContactDetailModels',
	EXPORT_ALL_SUPPLIER_CONTACT_DETAIL_OK = '[ENTITY] Export All SupplierContactDetailModels successfully',
	EXPORT_ALL_SUPPLIER_CONTACT_DETAIL_FAIL = '[ENTITY] Export All SupplierContactDetailModels failed',

	EXPORT_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export SupplierContactDetailModels excluding Ids',
	EXPORT_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export SupplierContactDetailModel excluding Ids successfully',
	EXPORT_SUPPLIER_CONTACT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export SupplierContactDetailModel excluding Ids failed',

	COUNT_SUPPLIER_CONTACT_DETAILS = '[ENTITY] Fetch number of SupplierContactDetailModel records',
	COUNT_SUPPLIER_CONTACT_DETAILS_OK = '[ENTITY] Fetch number of SupplierContactDetailModel records successfully ',
	COUNT_SUPPLIER_CONTACT_DETAILS_FAIL = '[ENTITY] Fetch number of SupplierContactDetailModel records failed',

	IMPORT_SUPPLIER_CONTACT_DETAILS = '[ENTITY] Import SupplierContactDetailModels',
	IMPORT_SUPPLIER_CONTACT_DETAILS_OK = '[ENTITY] Import SupplierContactDetailModels successfully',
	IMPORT_SUPPLIER_CONTACT_DETAILS_FAIL = '[ENTITY] Import SupplierContactDetailModels fail',


	INITIALISE_SUPPLIER_CONTACT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SupplierContactDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSupplierContactDetailAction implements Action {
	readonly className: string = 'SupplierContactDetailModel';

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

export class SupplierContactDetailAction extends BaseSupplierContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierContactDetailAction here] off begin
	// % protected region % [Add any additional class fields for SupplierContactDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierContactDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for SupplierContactDetailAction here] end
	}

	// % protected region % [Add any additional class methods for SupplierContactDetailAction here] off begin
	// % protected region % [Add any additional class methods for SupplierContactDetailAction here] end
}

export class SupplierContactDetailActionOK extends BaseSupplierContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierContactDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for SupplierContactDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SupplierContactDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierContactDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SupplierContactDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for SupplierContactDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for SupplierContactDetailActionOK here] end
}

export class SupplierContactDetailActionFail extends BaseSupplierContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierContactDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for SupplierContactDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SupplierContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierContactDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierContactDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierContactDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SupplierContactDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for SupplierContactDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for SupplierContactDetailActionFail here] end
}

export function isSupplierContactDetailModelAction(e: any): e is BaseSupplierContactDetailAction {
	return Object.values(SupplierContactDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
