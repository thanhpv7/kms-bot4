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
import {ReturnSupplierModel} from './return_supplier.model';
import {ReturnSupplierModelAudit} from './return_supplier.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Return Supplier model actions to be dispatched by NgRx.
 */
export enum ReturnSupplierModelActionTypes {
	CREATE_RETURN_SUPPLIER = '[ENTITY] Create ReturnSupplierModel',
	CREATE_RETURN_SUPPLIER_OK = '[ENTITY] Create ReturnSupplierModel successfully',
	CREATE_RETURN_SUPPLIER_FAIL = '[ENTITY] Create ReturnSupplierModel failed',

	CREATE_ALL_RETURN_SUPPLIER = '[ENTITY] Create All ReturnSupplierModel',
	CREATE_ALL_RETURN_SUPPLIER_OK = '[ENTITY] Create All ReturnSupplierModel successfully',
	CREATE_ALL_RETURN_SUPPLIER_FAIL = '[ENTITY] Create All ReturnSupplierModel failed',

	DELETE_RETURN_SUPPLIER = '[ENTITY] Delete ReturnSupplierModel',
	DELETE_RETURN_SUPPLIER_OK = '[ENTITY] Delete ReturnSupplierModel successfully',
	DELETE_RETURN_SUPPLIER_FAIL = '[ENTITY] Delete ReturnSupplierModel failed',


	DELETE_RETURN_SUPPLIER_EXCLUDING_IDS = '[ENTITY] Delete ReturnSupplierModels Excluding Ids',
	DELETE_RETURN_SUPPLIER_EXCLUDING_IDS_OK = '[ENTITY] Delete ReturnSupplierModels Excluding Ids successfully',
	DELETE_RETURN_SUPPLIER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ReturnSupplierModels Excluding Ids failed',

	DELETE_ALL_RETURN_SUPPLIER = '[ENTITY] Delete all ReturnSupplierModels',
	DELETE_ALL_RETURN_SUPPLIER_OK = '[ENTITY] Delete all ReturnSupplierModels successfully',
	DELETE_ALL_RETURN_SUPPLIER_FAIL = '[ENTITY] Delete all ReturnSupplierModels failed',

	UPDATE_RETURN_SUPPLIER = '[ENTITY] Update ReturnSupplierModel',
	UPDATE_RETURN_SUPPLIER_OK = '[ENTITY] Update ReturnSupplierModel successfully',
	UPDATE_RETURN_SUPPLIER_FAIL = '[ENTITY] Update ReturnSupplierModel failed',

	UPDATE_ALL_RETURN_SUPPLIER = '[ENTITY] Update all ReturnSupplierModel',
	UPDATE_ALL_RETURN_SUPPLIER_OK = '[ENTITY] Update all ReturnSupplierModel successfully',
	UPDATE_ALL_RETURN_SUPPLIER_FAIL = '[ENTITY] Update all ReturnSupplierModel failed',

	FETCH_RETURN_SUPPLIER= '[ENTITY] Fetch ReturnSupplierModel',
	FETCH_RETURN_SUPPLIER_OK = '[ENTITY] Fetch ReturnSupplierModel successfully',
	FETCH_RETURN_SUPPLIER_FAIL = '[ENTITY] Fetch ReturnSupplierModel failed',

	FETCH_RETURN_SUPPLIER_AUDIT= '[ENTITY] Fetch ReturnSupplierModel audit',
	FETCH_RETURN_SUPPLIER_AUDIT_OK = '[ENTITY] Fetch ReturnSupplierModel audit successfully',
	FETCH_RETURN_SUPPLIER_AUDIT_FAIL = '[ENTITY] Fetch ReturnSupplierModel audit failed',

	FETCH_RETURN_SUPPLIER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ReturnSupplierModel audits by entity id',
	FETCH_RETURN_SUPPLIER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ReturnSupplierModel audits by entity id successfully',
	FETCH_RETURN_SUPPLIER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ReturnSupplierModel audits by entity id failed',

	FETCH_ALL_RETURN_SUPPLIER = '[ENTITY] Fetch all ReturnSupplierModel',
	FETCH_ALL_RETURN_SUPPLIER_OK = '[ENTITY] Fetch all ReturnSupplierModel successfully',
	FETCH_ALL_RETURN_SUPPLIER_FAIL = '[ENTITY] Fetch all ReturnSupplierModel failed',

	FETCH_RETURN_SUPPLIER_WITH_QUERY = '[ENTITY] Fetch ReturnSupplierModel with query',
	FETCH_RETURN_SUPPLIER_WITH_QUERY_OK = '[ENTITY] Fetch ReturnSupplierModel with query successfully',
	FETCH_RETURN_SUPPLIER_WITH_QUERY_FAIL = '[ENTITY] Fetch ReturnSupplierModel with query failed',

	FETCH_LAST_RETURN_SUPPLIER_WITH_QUERY = '[ENTITY] Fetch last ReturnSupplierModel with query',
	FETCH_LAST_RETURN_SUPPLIER_WITH_QUERY_OK = '[ENTITY] Fetch last ReturnSupplierModel with query successfully',
	FETCH_LAST_RETURN_SUPPLIER_WITH_QUERY_FAIL = '[ENTITY] Fetch last ReturnSupplierModel with query failed',

	EXPORT_RETURN_SUPPLIER = '[ENTITY] Export ReturnSupplierModel',
	EXPORT_RETURN_SUPPLIER_OK = '[ENTITY] Export ReturnSupplierModel successfully',
	EXPORT_RETURN_SUPPLIER_FAIL = '[ENTITY] Export ReturnSupplierModel failed',

	EXPORT_ALL_RETURN_SUPPLIER = '[ENTITY] Export All ReturnSupplierModels',
	EXPORT_ALL_RETURN_SUPPLIER_OK = '[ENTITY] Export All ReturnSupplierModels successfully',
	EXPORT_ALL_RETURN_SUPPLIER_FAIL = '[ENTITY] Export All ReturnSupplierModels failed',

	EXPORT_RETURN_SUPPLIER_EXCLUDING_IDS = '[ENTITY] Export ReturnSupplierModels excluding Ids',
	EXPORT_RETURN_SUPPLIER_EXCLUDING_IDS_OK = '[ENTITY] Export ReturnSupplierModel excluding Ids successfully',
	EXPORT_RETURN_SUPPLIER_EXCLUDING_IDS_FAIL = '[ENTITY] Export ReturnSupplierModel excluding Ids failed',

	COUNT_RETURN_SUPPLIERS = '[ENTITY] Fetch number of ReturnSupplierModel records',
	COUNT_RETURN_SUPPLIERS_OK = '[ENTITY] Fetch number of ReturnSupplierModel records successfully ',
	COUNT_RETURN_SUPPLIERS_FAIL = '[ENTITY] Fetch number of ReturnSupplierModel records failed',

	IMPORT_RETURN_SUPPLIERS = '[ENTITY] Import ReturnSupplierModels',
	IMPORT_RETURN_SUPPLIERS_OK = '[ENTITY] Import ReturnSupplierModels successfully',
	IMPORT_RETURN_SUPPLIERS_FAIL = '[ENTITY] Import ReturnSupplierModels fail',


	INITIALISE_RETURN_SUPPLIER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ReturnSupplierModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseReturnSupplierAction implements Action {
	readonly className: string = 'ReturnSupplierModel';

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

export class ReturnSupplierAction extends BaseReturnSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierAction here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReturnSupplierModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierAction here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierAction here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierAction here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierAction here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierAction here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierAction here] end
}

export class ReturnSupplierActionOK extends BaseReturnSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierActionOK here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReturnSupplierModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ReturnSupplierModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierActionOK here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierActionOK here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierActionOK here] end
}

export class ReturnSupplierActionFail extends BaseReturnSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReturnSupplierActionFail here] off begin
	// % protected region % [Add any additional class fields for ReturnSupplierActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ReturnSupplierModel>,
		// % protected region % [Add any additional constructor parameters for ReturnSupplierActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ReturnSupplierActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReturnSupplierActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ReturnSupplierActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReturnSupplierActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ReturnSupplierActionFail here] end
	}

	// % protected region % [Add any additional class methods for ReturnSupplierActionFail here] off begin
	// % protected region % [Add any additional class methods for ReturnSupplierActionFail here] end
}

export function isReturnSupplierModelAction(e: any): e is BaseReturnSupplierAction {
	return Object.values(ReturnSupplierModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
