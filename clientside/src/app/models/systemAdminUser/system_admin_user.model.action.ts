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
import {SystemAdminUserModel} from './system_admin_user.model';
import {SystemAdminUserModelAudit} from './system_admin_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of System Admin User model actions to be dispatched by NgRx.
 */
export enum SystemAdminUserModelActionTypes {
	CREATE_SYSTEM_ADMIN_USER = '[ENTITY] Create SystemAdminUserModel',
	CREATE_SYSTEM_ADMIN_USER_OK = '[ENTITY] Create SystemAdminUserModel successfully',
	CREATE_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Create SystemAdminUserModel failed',

	CREATE_ALL_SYSTEM_ADMIN_USER = '[ENTITY] Create All SystemAdminUserModel',
	CREATE_ALL_SYSTEM_ADMIN_USER_OK = '[ENTITY] Create All SystemAdminUserModel successfully',
	CREATE_ALL_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Create All SystemAdminUserModel failed',

	DELETE_SYSTEM_ADMIN_USER = '[ENTITY] Delete SystemAdminUserModel',
	DELETE_SYSTEM_ADMIN_USER_OK = '[ENTITY] Delete SystemAdminUserModel successfully',
	DELETE_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Delete SystemAdminUserModel failed',


	DELETE_SYSTEM_ADMIN_USER_EXCLUDING_IDS = '[ENTITY] Delete SystemAdminUserModels Excluding Ids',
	DELETE_SYSTEM_ADMIN_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete SystemAdminUserModels Excluding Ids successfully',
	DELETE_SYSTEM_ADMIN_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SystemAdminUserModels Excluding Ids failed',

	DELETE_ALL_SYSTEM_ADMIN_USER = '[ENTITY] Delete all SystemAdminUserModels',
	DELETE_ALL_SYSTEM_ADMIN_USER_OK = '[ENTITY] Delete all SystemAdminUserModels successfully',
	DELETE_ALL_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Delete all SystemAdminUserModels failed',

	UPDATE_SYSTEM_ADMIN_USER = '[ENTITY] Update SystemAdminUserModel',
	UPDATE_SYSTEM_ADMIN_USER_OK = '[ENTITY] Update SystemAdminUserModel successfully',
	UPDATE_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Update SystemAdminUserModel failed',

	UPDATE_ALL_SYSTEM_ADMIN_USER = '[ENTITY] Update all SystemAdminUserModel',
	UPDATE_ALL_SYSTEM_ADMIN_USER_OK = '[ENTITY] Update all SystemAdminUserModel successfully',
	UPDATE_ALL_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Update all SystemAdminUserModel failed',

	FETCH_SYSTEM_ADMIN_USER= '[ENTITY] Fetch SystemAdminUserModel',
	FETCH_SYSTEM_ADMIN_USER_OK = '[ENTITY] Fetch SystemAdminUserModel successfully',
	FETCH_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Fetch SystemAdminUserModel failed',

	FETCH_SYSTEM_ADMIN_USER_AUDIT= '[ENTITY] Fetch SystemAdminUserModel audit',
	FETCH_SYSTEM_ADMIN_USER_AUDIT_OK = '[ENTITY] Fetch SystemAdminUserModel audit successfully',
	FETCH_SYSTEM_ADMIN_USER_AUDIT_FAIL = '[ENTITY] Fetch SystemAdminUserModel audit failed',

	FETCH_SYSTEM_ADMIN_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SystemAdminUserModel audits by entity id',
	FETCH_SYSTEM_ADMIN_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SystemAdminUserModel audits by entity id successfully',
	FETCH_SYSTEM_ADMIN_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SystemAdminUserModel audits by entity id failed',

	FETCH_ALL_SYSTEM_ADMIN_USER = '[ENTITY] Fetch all SystemAdminUserModel',
	FETCH_ALL_SYSTEM_ADMIN_USER_OK = '[ENTITY] Fetch all SystemAdminUserModel successfully',
	FETCH_ALL_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Fetch all SystemAdminUserModel failed',

	FETCH_SYSTEM_ADMIN_USER_WITH_QUERY = '[ENTITY] Fetch SystemAdminUserModel with query',
	FETCH_SYSTEM_ADMIN_USER_WITH_QUERY_OK = '[ENTITY] Fetch SystemAdminUserModel with query successfully',
	FETCH_SYSTEM_ADMIN_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch SystemAdminUserModel with query failed',

	FETCH_LAST_SYSTEM_ADMIN_USER_WITH_QUERY = '[ENTITY] Fetch last SystemAdminUserModel with query',
	FETCH_LAST_SYSTEM_ADMIN_USER_WITH_QUERY_OK = '[ENTITY] Fetch last SystemAdminUserModel with query successfully',
	FETCH_LAST_SYSTEM_ADMIN_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last SystemAdminUserModel with query failed',

	EXPORT_SYSTEM_ADMIN_USER = '[ENTITY] Export SystemAdminUserModel',
	EXPORT_SYSTEM_ADMIN_USER_OK = '[ENTITY] Export SystemAdminUserModel successfully',
	EXPORT_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Export SystemAdminUserModel failed',

	EXPORT_ALL_SYSTEM_ADMIN_USER = '[ENTITY] Export All SystemAdminUserModels',
	EXPORT_ALL_SYSTEM_ADMIN_USER_OK = '[ENTITY] Export All SystemAdminUserModels successfully',
	EXPORT_ALL_SYSTEM_ADMIN_USER_FAIL = '[ENTITY] Export All SystemAdminUserModels failed',

	EXPORT_SYSTEM_ADMIN_USER_EXCLUDING_IDS = '[ENTITY] Export SystemAdminUserModels excluding Ids',
	EXPORT_SYSTEM_ADMIN_USER_EXCLUDING_IDS_OK = '[ENTITY] Export SystemAdminUserModel excluding Ids successfully',
	EXPORT_SYSTEM_ADMIN_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export SystemAdminUserModel excluding Ids failed',

	COUNT_SYSTEM_ADMIN_USERS = '[ENTITY] Fetch number of SystemAdminUserModel records',
	COUNT_SYSTEM_ADMIN_USERS_OK = '[ENTITY] Fetch number of SystemAdminUserModel records successfully ',
	COUNT_SYSTEM_ADMIN_USERS_FAIL = '[ENTITY] Fetch number of SystemAdminUserModel records failed',

	IMPORT_SYSTEM_ADMIN_USERS = '[ENTITY] Import SystemAdminUserModels',
	IMPORT_SYSTEM_ADMIN_USERS_OK = '[ENTITY] Import SystemAdminUserModels successfully',
	IMPORT_SYSTEM_ADMIN_USERS_FAIL = '[ENTITY] Import SystemAdminUserModels fail',


	INITIALISE_SYSTEM_ADMIN_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SystemAdminUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSystemAdminUserAction implements Action {
	readonly className: string = 'SystemAdminUserModel';

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

export class SystemAdminUserAction extends BaseSystemAdminUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SystemAdminUserAction here] off begin
	// % protected region % [Add any additional class fields for SystemAdminUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SystemAdminUserModel>,
		// % protected region % [Add any additional constructor parameters for SystemAdminUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for SystemAdminUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SystemAdminUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for SystemAdminUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SystemAdminUserAction here] off begin
		// % protected region % [Add any additional constructor logic for SystemAdminUserAction here] end
	}

	// % protected region % [Add any additional class methods for SystemAdminUserAction here] off begin
	// % protected region % [Add any additional class methods for SystemAdminUserAction here] end
}

export class SystemAdminUserActionOK extends BaseSystemAdminUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SystemAdminUserActionOK here] off begin
	// % protected region % [Add any additional class fields for SystemAdminUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SystemAdminUserModel>,
		// % protected region % [Add any additional constructor parameters for SystemAdminUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SystemAdminUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SystemAdminUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SystemAdminUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SystemAdminUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SystemAdminUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SystemAdminUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for SystemAdminUserActionOK here] off begin
	// % protected region % [Add any additional class methods for SystemAdminUserActionOK here] end
}

export class SystemAdminUserActionFail extends BaseSystemAdminUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SystemAdminUserActionFail here] off begin
	// % protected region % [Add any additional class fields for SystemAdminUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SystemAdminUserModel>,
		// % protected region % [Add any additional constructor parameters for SystemAdminUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SystemAdminUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SystemAdminUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SystemAdminUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SystemAdminUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SystemAdminUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for SystemAdminUserActionFail here] off begin
	// % protected region % [Add any additional class methods for SystemAdminUserActionFail here] end
}

export function isSystemAdminUserModelAction(e: any): e is BaseSystemAdminUserAction {
	return Object.values(SystemAdminUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
