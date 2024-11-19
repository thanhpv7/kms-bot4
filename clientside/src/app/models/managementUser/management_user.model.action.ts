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
import {ManagementUserModel} from './management_user.model';
import {ManagementUserModelAudit} from './management_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Management User model actions to be dispatched by NgRx.
 */
export enum ManagementUserModelActionTypes {
	CREATE_MANAGEMENT_USER = '[ENTITY] Create ManagementUserModel',
	CREATE_MANAGEMENT_USER_OK = '[ENTITY] Create ManagementUserModel successfully',
	CREATE_MANAGEMENT_USER_FAIL = '[ENTITY] Create ManagementUserModel failed',

	CREATE_ALL_MANAGEMENT_USER = '[ENTITY] Create All ManagementUserModel',
	CREATE_ALL_MANAGEMENT_USER_OK = '[ENTITY] Create All ManagementUserModel successfully',
	CREATE_ALL_MANAGEMENT_USER_FAIL = '[ENTITY] Create All ManagementUserModel failed',

	DELETE_MANAGEMENT_USER = '[ENTITY] Delete ManagementUserModel',
	DELETE_MANAGEMENT_USER_OK = '[ENTITY] Delete ManagementUserModel successfully',
	DELETE_MANAGEMENT_USER_FAIL = '[ENTITY] Delete ManagementUserModel failed',


	DELETE_MANAGEMENT_USER_EXCLUDING_IDS = '[ENTITY] Delete ManagementUserModels Excluding Ids',
	DELETE_MANAGEMENT_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete ManagementUserModels Excluding Ids successfully',
	DELETE_MANAGEMENT_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ManagementUserModels Excluding Ids failed',

	DELETE_ALL_MANAGEMENT_USER = '[ENTITY] Delete all ManagementUserModels',
	DELETE_ALL_MANAGEMENT_USER_OK = '[ENTITY] Delete all ManagementUserModels successfully',
	DELETE_ALL_MANAGEMENT_USER_FAIL = '[ENTITY] Delete all ManagementUserModels failed',

	UPDATE_MANAGEMENT_USER = '[ENTITY] Update ManagementUserModel',
	UPDATE_MANAGEMENT_USER_OK = '[ENTITY] Update ManagementUserModel successfully',
	UPDATE_MANAGEMENT_USER_FAIL = '[ENTITY] Update ManagementUserModel failed',

	UPDATE_ALL_MANAGEMENT_USER = '[ENTITY] Update all ManagementUserModel',
	UPDATE_ALL_MANAGEMENT_USER_OK = '[ENTITY] Update all ManagementUserModel successfully',
	UPDATE_ALL_MANAGEMENT_USER_FAIL = '[ENTITY] Update all ManagementUserModel failed',

	FETCH_MANAGEMENT_USER= '[ENTITY] Fetch ManagementUserModel',
	FETCH_MANAGEMENT_USER_OK = '[ENTITY] Fetch ManagementUserModel successfully',
	FETCH_MANAGEMENT_USER_FAIL = '[ENTITY] Fetch ManagementUserModel failed',

	FETCH_MANAGEMENT_USER_AUDIT= '[ENTITY] Fetch ManagementUserModel audit',
	FETCH_MANAGEMENT_USER_AUDIT_OK = '[ENTITY] Fetch ManagementUserModel audit successfully',
	FETCH_MANAGEMENT_USER_AUDIT_FAIL = '[ENTITY] Fetch ManagementUserModel audit failed',

	FETCH_MANAGEMENT_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ManagementUserModel audits by entity id',
	FETCH_MANAGEMENT_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ManagementUserModel audits by entity id successfully',
	FETCH_MANAGEMENT_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ManagementUserModel audits by entity id failed',

	FETCH_ALL_MANAGEMENT_USER = '[ENTITY] Fetch all ManagementUserModel',
	FETCH_ALL_MANAGEMENT_USER_OK = '[ENTITY] Fetch all ManagementUserModel successfully',
	FETCH_ALL_MANAGEMENT_USER_FAIL = '[ENTITY] Fetch all ManagementUserModel failed',

	FETCH_MANAGEMENT_USER_WITH_QUERY = '[ENTITY] Fetch ManagementUserModel with query',
	FETCH_MANAGEMENT_USER_WITH_QUERY_OK = '[ENTITY] Fetch ManagementUserModel with query successfully',
	FETCH_MANAGEMENT_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch ManagementUserModel with query failed',

	FETCH_LAST_MANAGEMENT_USER_WITH_QUERY = '[ENTITY] Fetch last ManagementUserModel with query',
	FETCH_LAST_MANAGEMENT_USER_WITH_QUERY_OK = '[ENTITY] Fetch last ManagementUserModel with query successfully',
	FETCH_LAST_MANAGEMENT_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last ManagementUserModel with query failed',

	EXPORT_MANAGEMENT_USER = '[ENTITY] Export ManagementUserModel',
	EXPORT_MANAGEMENT_USER_OK = '[ENTITY] Export ManagementUserModel successfully',
	EXPORT_MANAGEMENT_USER_FAIL = '[ENTITY] Export ManagementUserModel failed',

	EXPORT_ALL_MANAGEMENT_USER = '[ENTITY] Export All ManagementUserModels',
	EXPORT_ALL_MANAGEMENT_USER_OK = '[ENTITY] Export All ManagementUserModels successfully',
	EXPORT_ALL_MANAGEMENT_USER_FAIL = '[ENTITY] Export All ManagementUserModels failed',

	EXPORT_MANAGEMENT_USER_EXCLUDING_IDS = '[ENTITY] Export ManagementUserModels excluding Ids',
	EXPORT_MANAGEMENT_USER_EXCLUDING_IDS_OK = '[ENTITY] Export ManagementUserModel excluding Ids successfully',
	EXPORT_MANAGEMENT_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export ManagementUserModel excluding Ids failed',

	COUNT_MANAGEMENT_USERS = '[ENTITY] Fetch number of ManagementUserModel records',
	COUNT_MANAGEMENT_USERS_OK = '[ENTITY] Fetch number of ManagementUserModel records successfully ',
	COUNT_MANAGEMENT_USERS_FAIL = '[ENTITY] Fetch number of ManagementUserModel records failed',

	IMPORT_MANAGEMENT_USERS = '[ENTITY] Import ManagementUserModels',
	IMPORT_MANAGEMENT_USERS_OK = '[ENTITY] Import ManagementUserModels successfully',
	IMPORT_MANAGEMENT_USERS_FAIL = '[ENTITY] Import ManagementUserModels fail',


	INITIALISE_MANAGEMENT_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ManagementUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseManagementUserAction implements Action {
	readonly className: string = 'ManagementUserModel';

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

export class ManagementUserAction extends BaseManagementUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ManagementUserAction here] off begin
	// % protected region % [Add any additional class fields for ManagementUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ManagementUserModel>,
		// % protected region % [Add any additional constructor parameters for ManagementUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for ManagementUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ManagementUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for ManagementUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ManagementUserAction here] off begin
		// % protected region % [Add any additional constructor logic for ManagementUserAction here] end
	}

	// % protected region % [Add any additional class methods for ManagementUserAction here] off begin
	// % protected region % [Add any additional class methods for ManagementUserAction here] end
}

export class ManagementUserActionOK extends BaseManagementUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ManagementUserActionOK here] off begin
	// % protected region % [Add any additional class fields for ManagementUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ManagementUserModel>,
		// % protected region % [Add any additional constructor parameters for ManagementUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ManagementUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ManagementUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ManagementUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ManagementUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ManagementUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ManagementUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for ManagementUserActionOK here] off begin
	// % protected region % [Add any additional class methods for ManagementUserActionOK here] end
}

export class ManagementUserActionFail extends BaseManagementUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ManagementUserActionFail here] off begin
	// % protected region % [Add any additional class fields for ManagementUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ManagementUserModel>,
		// % protected region % [Add any additional constructor parameters for ManagementUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ManagementUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ManagementUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ManagementUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ManagementUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ManagementUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for ManagementUserActionFail here] off begin
	// % protected region % [Add any additional class methods for ManagementUserActionFail here] end
}

export function isManagementUserModelAction(e: any): e is BaseManagementUserAction {
	return Object.values(ManagementUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
