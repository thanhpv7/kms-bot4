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
import {WarehouseUserModel} from './warehouse_user.model';
import {WarehouseUserModelAudit} from './warehouse_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Warehouse User model actions to be dispatched by NgRx.
 */
export enum WarehouseUserModelActionTypes {
	CREATE_WAREHOUSE_USER = '[ENTITY] Create WarehouseUserModel',
	CREATE_WAREHOUSE_USER_OK = '[ENTITY] Create WarehouseUserModel successfully',
	CREATE_WAREHOUSE_USER_FAIL = '[ENTITY] Create WarehouseUserModel failed',

	CREATE_ALL_WAREHOUSE_USER = '[ENTITY] Create All WarehouseUserModel',
	CREATE_ALL_WAREHOUSE_USER_OK = '[ENTITY] Create All WarehouseUserModel successfully',
	CREATE_ALL_WAREHOUSE_USER_FAIL = '[ENTITY] Create All WarehouseUserModel failed',

	DELETE_WAREHOUSE_USER = '[ENTITY] Delete WarehouseUserModel',
	DELETE_WAREHOUSE_USER_OK = '[ENTITY] Delete WarehouseUserModel successfully',
	DELETE_WAREHOUSE_USER_FAIL = '[ENTITY] Delete WarehouseUserModel failed',


	DELETE_WAREHOUSE_USER_EXCLUDING_IDS = '[ENTITY] Delete WarehouseUserModels Excluding Ids',
	DELETE_WAREHOUSE_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete WarehouseUserModels Excluding Ids successfully',
	DELETE_WAREHOUSE_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete WarehouseUserModels Excluding Ids failed',

	DELETE_ALL_WAREHOUSE_USER = '[ENTITY] Delete all WarehouseUserModels',
	DELETE_ALL_WAREHOUSE_USER_OK = '[ENTITY] Delete all WarehouseUserModels successfully',
	DELETE_ALL_WAREHOUSE_USER_FAIL = '[ENTITY] Delete all WarehouseUserModels failed',

	UPDATE_WAREHOUSE_USER = '[ENTITY] Update WarehouseUserModel',
	UPDATE_WAREHOUSE_USER_OK = '[ENTITY] Update WarehouseUserModel successfully',
	UPDATE_WAREHOUSE_USER_FAIL = '[ENTITY] Update WarehouseUserModel failed',

	UPDATE_ALL_WAREHOUSE_USER = '[ENTITY] Update all WarehouseUserModel',
	UPDATE_ALL_WAREHOUSE_USER_OK = '[ENTITY] Update all WarehouseUserModel successfully',
	UPDATE_ALL_WAREHOUSE_USER_FAIL = '[ENTITY] Update all WarehouseUserModel failed',

	FETCH_WAREHOUSE_USER= '[ENTITY] Fetch WarehouseUserModel',
	FETCH_WAREHOUSE_USER_OK = '[ENTITY] Fetch WarehouseUserModel successfully',
	FETCH_WAREHOUSE_USER_FAIL = '[ENTITY] Fetch WarehouseUserModel failed',

	FETCH_WAREHOUSE_USER_AUDIT= '[ENTITY] Fetch WarehouseUserModel audit',
	FETCH_WAREHOUSE_USER_AUDIT_OK = '[ENTITY] Fetch WarehouseUserModel audit successfully',
	FETCH_WAREHOUSE_USER_AUDIT_FAIL = '[ENTITY] Fetch WarehouseUserModel audit failed',

	FETCH_WAREHOUSE_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch WarehouseUserModel audits by entity id',
	FETCH_WAREHOUSE_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch WarehouseUserModel audits by entity id successfully',
	FETCH_WAREHOUSE_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch WarehouseUserModel audits by entity id failed',

	FETCH_ALL_WAREHOUSE_USER = '[ENTITY] Fetch all WarehouseUserModel',
	FETCH_ALL_WAREHOUSE_USER_OK = '[ENTITY] Fetch all WarehouseUserModel successfully',
	FETCH_ALL_WAREHOUSE_USER_FAIL = '[ENTITY] Fetch all WarehouseUserModel failed',

	FETCH_WAREHOUSE_USER_WITH_QUERY = '[ENTITY] Fetch WarehouseUserModel with query',
	FETCH_WAREHOUSE_USER_WITH_QUERY_OK = '[ENTITY] Fetch WarehouseUserModel with query successfully',
	FETCH_WAREHOUSE_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch WarehouseUserModel with query failed',

	FETCH_LAST_WAREHOUSE_USER_WITH_QUERY = '[ENTITY] Fetch last WarehouseUserModel with query',
	FETCH_LAST_WAREHOUSE_USER_WITH_QUERY_OK = '[ENTITY] Fetch last WarehouseUserModel with query successfully',
	FETCH_LAST_WAREHOUSE_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last WarehouseUserModel with query failed',

	EXPORT_WAREHOUSE_USER = '[ENTITY] Export WarehouseUserModel',
	EXPORT_WAREHOUSE_USER_OK = '[ENTITY] Export WarehouseUserModel successfully',
	EXPORT_WAREHOUSE_USER_FAIL = '[ENTITY] Export WarehouseUserModel failed',

	EXPORT_ALL_WAREHOUSE_USER = '[ENTITY] Export All WarehouseUserModels',
	EXPORT_ALL_WAREHOUSE_USER_OK = '[ENTITY] Export All WarehouseUserModels successfully',
	EXPORT_ALL_WAREHOUSE_USER_FAIL = '[ENTITY] Export All WarehouseUserModels failed',

	EXPORT_WAREHOUSE_USER_EXCLUDING_IDS = '[ENTITY] Export WarehouseUserModels excluding Ids',
	EXPORT_WAREHOUSE_USER_EXCLUDING_IDS_OK = '[ENTITY] Export WarehouseUserModel excluding Ids successfully',
	EXPORT_WAREHOUSE_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export WarehouseUserModel excluding Ids failed',

	COUNT_WAREHOUSE_USERS = '[ENTITY] Fetch number of WarehouseUserModel records',
	COUNT_WAREHOUSE_USERS_OK = '[ENTITY] Fetch number of WarehouseUserModel records successfully ',
	COUNT_WAREHOUSE_USERS_FAIL = '[ENTITY] Fetch number of WarehouseUserModel records failed',

	IMPORT_WAREHOUSE_USERS = '[ENTITY] Import WarehouseUserModels',
	IMPORT_WAREHOUSE_USERS_OK = '[ENTITY] Import WarehouseUserModels successfully',
	IMPORT_WAREHOUSE_USERS_FAIL = '[ENTITY] Import WarehouseUserModels fail',


	INITIALISE_WAREHOUSE_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of WarehouseUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseWarehouseUserAction implements Action {
	readonly className: string = 'WarehouseUserModel';

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

export class WarehouseUserAction extends BaseWarehouseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseUserAction here] off begin
	// % protected region % [Add any additional class fields for WarehouseUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseUserModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseUserAction here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseUserAction here] end
	}

	// % protected region % [Add any additional class methods for WarehouseUserAction here] off begin
	// % protected region % [Add any additional class methods for WarehouseUserAction here] end
}

export class WarehouseUserActionOK extends BaseWarehouseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseUserActionOK here] off begin
	// % protected region % [Add any additional class fields for WarehouseUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<WarehouseUserModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: WarehouseUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for WarehouseUserActionOK here] off begin
	// % protected region % [Add any additional class methods for WarehouseUserActionOK here] end
}

export class WarehouseUserActionFail extends BaseWarehouseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for WarehouseUserActionFail here] off begin
	// % protected region % [Add any additional class fields for WarehouseUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<WarehouseUserModel>,
		// % protected region % [Add any additional constructor parameters for WarehouseUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for WarehouseUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for WarehouseUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for WarehouseUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for WarehouseUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for WarehouseUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for WarehouseUserActionFail here] off begin
	// % protected region % [Add any additional class methods for WarehouseUserActionFail here] end
}

export function isWarehouseUserModelAction(e: any): e is BaseWarehouseUserAction {
	return Object.values(WarehouseUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
