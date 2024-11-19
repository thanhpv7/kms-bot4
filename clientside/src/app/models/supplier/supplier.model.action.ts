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
import {SupplierModel} from './supplier.model';
import {SupplierModelAudit} from './supplier.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Supplier model actions to be dispatched by NgRx.
 */
export enum SupplierModelActionTypes {
	CREATE_SUPPLIER = '[ENTITY] Create SupplierModel',
	CREATE_SUPPLIER_OK = '[ENTITY] Create SupplierModel successfully',
	CREATE_SUPPLIER_FAIL = '[ENTITY] Create SupplierModel failed',

	CREATE_ALL_SUPPLIER = '[ENTITY] Create All SupplierModel',
	CREATE_ALL_SUPPLIER_OK = '[ENTITY] Create All SupplierModel successfully',
	CREATE_ALL_SUPPLIER_FAIL = '[ENTITY] Create All SupplierModel failed',

	DELETE_SUPPLIER = '[ENTITY] Delete SupplierModel',
	DELETE_SUPPLIER_OK = '[ENTITY] Delete SupplierModel successfully',
	DELETE_SUPPLIER_FAIL = '[ENTITY] Delete SupplierModel failed',


	DELETE_SUPPLIER_EXCLUDING_IDS = '[ENTITY] Delete SupplierModels Excluding Ids',
	DELETE_SUPPLIER_EXCLUDING_IDS_OK = '[ENTITY] Delete SupplierModels Excluding Ids successfully',
	DELETE_SUPPLIER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SupplierModels Excluding Ids failed',

	DELETE_ALL_SUPPLIER = '[ENTITY] Delete all SupplierModels',
	DELETE_ALL_SUPPLIER_OK = '[ENTITY] Delete all SupplierModels successfully',
	DELETE_ALL_SUPPLIER_FAIL = '[ENTITY] Delete all SupplierModels failed',

	UPDATE_SUPPLIER = '[ENTITY] Update SupplierModel',
	UPDATE_SUPPLIER_OK = '[ENTITY] Update SupplierModel successfully',
	UPDATE_SUPPLIER_FAIL = '[ENTITY] Update SupplierModel failed',

	UPDATE_ALL_SUPPLIER = '[ENTITY] Update all SupplierModel',
	UPDATE_ALL_SUPPLIER_OK = '[ENTITY] Update all SupplierModel successfully',
	UPDATE_ALL_SUPPLIER_FAIL = '[ENTITY] Update all SupplierModel failed',

	FETCH_SUPPLIER= '[ENTITY] Fetch SupplierModel',
	FETCH_SUPPLIER_OK = '[ENTITY] Fetch SupplierModel successfully',
	FETCH_SUPPLIER_FAIL = '[ENTITY] Fetch SupplierModel failed',

	FETCH_SUPPLIER_AUDIT= '[ENTITY] Fetch SupplierModel audit',
	FETCH_SUPPLIER_AUDIT_OK = '[ENTITY] Fetch SupplierModel audit successfully',
	FETCH_SUPPLIER_AUDIT_FAIL = '[ENTITY] Fetch SupplierModel audit failed',

	FETCH_SUPPLIER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SupplierModel audits by entity id',
	FETCH_SUPPLIER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SupplierModel audits by entity id successfully',
	FETCH_SUPPLIER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SupplierModel audits by entity id failed',

	FETCH_ALL_SUPPLIER = '[ENTITY] Fetch all SupplierModel',
	FETCH_ALL_SUPPLIER_OK = '[ENTITY] Fetch all SupplierModel successfully',
	FETCH_ALL_SUPPLIER_FAIL = '[ENTITY] Fetch all SupplierModel failed',

	FETCH_SUPPLIER_WITH_QUERY = '[ENTITY] Fetch SupplierModel with query',
	FETCH_SUPPLIER_WITH_QUERY_OK = '[ENTITY] Fetch SupplierModel with query successfully',
	FETCH_SUPPLIER_WITH_QUERY_FAIL = '[ENTITY] Fetch SupplierModel with query failed',

	FETCH_LAST_SUPPLIER_WITH_QUERY = '[ENTITY] Fetch last SupplierModel with query',
	FETCH_LAST_SUPPLIER_WITH_QUERY_OK = '[ENTITY] Fetch last SupplierModel with query successfully',
	FETCH_LAST_SUPPLIER_WITH_QUERY_FAIL = '[ENTITY] Fetch last SupplierModel with query failed',

	EXPORT_SUPPLIER = '[ENTITY] Export SupplierModel',
	EXPORT_SUPPLIER_OK = '[ENTITY] Export SupplierModel successfully',
	EXPORT_SUPPLIER_FAIL = '[ENTITY] Export SupplierModel failed',

	EXPORT_ALL_SUPPLIER = '[ENTITY] Export All SupplierModels',
	EXPORT_ALL_SUPPLIER_OK = '[ENTITY] Export All SupplierModels successfully',
	EXPORT_ALL_SUPPLIER_FAIL = '[ENTITY] Export All SupplierModels failed',

	EXPORT_SUPPLIER_EXCLUDING_IDS = '[ENTITY] Export SupplierModels excluding Ids',
	EXPORT_SUPPLIER_EXCLUDING_IDS_OK = '[ENTITY] Export SupplierModel excluding Ids successfully',
	EXPORT_SUPPLIER_EXCLUDING_IDS_FAIL = '[ENTITY] Export SupplierModel excluding Ids failed',

	COUNT_SUPPLIERS = '[ENTITY] Fetch number of SupplierModel records',
	COUNT_SUPPLIERS_OK = '[ENTITY] Fetch number of SupplierModel records successfully ',
	COUNT_SUPPLIERS_FAIL = '[ENTITY] Fetch number of SupplierModel records failed',

	IMPORT_SUPPLIERS = '[ENTITY] Import SupplierModels',
	IMPORT_SUPPLIERS_OK = '[ENTITY] Import SupplierModels successfully',
	IMPORT_SUPPLIERS_FAIL = '[ENTITY] Import SupplierModels fail',


	INITIALISE_SUPPLIER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SupplierModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSupplierAction implements Action {
	readonly className: string = 'SupplierModel';

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

export class SupplierAction extends BaseSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierAction here] off begin
	// % protected region % [Add any additional class fields for SupplierAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierModel>,
		// % protected region % [Add any additional constructor parameters for SupplierAction here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierAction here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierAction here] off begin
		// % protected region % [Add any additional constructor logic for SupplierAction here] end
	}

	// % protected region % [Add any additional class methods for SupplierAction here] off begin
	// % protected region % [Add any additional class methods for SupplierAction here] end
}

export class SupplierActionOK extends BaseSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierActionOK here] off begin
	// % protected region % [Add any additional class fields for SupplierActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierModel>,
		// % protected region % [Add any additional constructor parameters for SupplierActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SupplierModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SupplierActionOK here] end
	}

	// % protected region % [Add any additional class methods for SupplierActionOK here] off begin
	// % protected region % [Add any additional class methods for SupplierActionOK here] end
}

export class SupplierActionFail extends BaseSupplierAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierActionFail here] off begin
	// % protected region % [Add any additional class fields for SupplierActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SupplierModel>,
		// % protected region % [Add any additional constructor parameters for SupplierActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SupplierActionFail here] end
	}

	// % protected region % [Add any additional class methods for SupplierActionFail here] off begin
	// % protected region % [Add any additional class methods for SupplierActionFail here] end
}

export function isSupplierModelAction(e: any): e is BaseSupplierAction {
	return Object.values(SupplierModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
