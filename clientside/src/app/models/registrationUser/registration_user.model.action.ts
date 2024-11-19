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
import {RegistrationUserModel} from './registration_user.model';
import {RegistrationUserModelAudit} from './registration_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Registration User model actions to be dispatched by NgRx.
 */
export enum RegistrationUserModelActionTypes {
	CREATE_REGISTRATION_USER = '[ENTITY] Create RegistrationUserModel',
	CREATE_REGISTRATION_USER_OK = '[ENTITY] Create RegistrationUserModel successfully',
	CREATE_REGISTRATION_USER_FAIL = '[ENTITY] Create RegistrationUserModel failed',

	CREATE_ALL_REGISTRATION_USER = '[ENTITY] Create All RegistrationUserModel',
	CREATE_ALL_REGISTRATION_USER_OK = '[ENTITY] Create All RegistrationUserModel successfully',
	CREATE_ALL_REGISTRATION_USER_FAIL = '[ENTITY] Create All RegistrationUserModel failed',

	DELETE_REGISTRATION_USER = '[ENTITY] Delete RegistrationUserModel',
	DELETE_REGISTRATION_USER_OK = '[ENTITY] Delete RegistrationUserModel successfully',
	DELETE_REGISTRATION_USER_FAIL = '[ENTITY] Delete RegistrationUserModel failed',


	DELETE_REGISTRATION_USER_EXCLUDING_IDS = '[ENTITY] Delete RegistrationUserModels Excluding Ids',
	DELETE_REGISTRATION_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete RegistrationUserModels Excluding Ids successfully',
	DELETE_REGISTRATION_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RegistrationUserModels Excluding Ids failed',

	DELETE_ALL_REGISTRATION_USER = '[ENTITY] Delete all RegistrationUserModels',
	DELETE_ALL_REGISTRATION_USER_OK = '[ENTITY] Delete all RegistrationUserModels successfully',
	DELETE_ALL_REGISTRATION_USER_FAIL = '[ENTITY] Delete all RegistrationUserModels failed',

	UPDATE_REGISTRATION_USER = '[ENTITY] Update RegistrationUserModel',
	UPDATE_REGISTRATION_USER_OK = '[ENTITY] Update RegistrationUserModel successfully',
	UPDATE_REGISTRATION_USER_FAIL = '[ENTITY] Update RegistrationUserModel failed',

	UPDATE_ALL_REGISTRATION_USER = '[ENTITY] Update all RegistrationUserModel',
	UPDATE_ALL_REGISTRATION_USER_OK = '[ENTITY] Update all RegistrationUserModel successfully',
	UPDATE_ALL_REGISTRATION_USER_FAIL = '[ENTITY] Update all RegistrationUserModel failed',

	FETCH_REGISTRATION_USER= '[ENTITY] Fetch RegistrationUserModel',
	FETCH_REGISTRATION_USER_OK = '[ENTITY] Fetch RegistrationUserModel successfully',
	FETCH_REGISTRATION_USER_FAIL = '[ENTITY] Fetch RegistrationUserModel failed',

	FETCH_REGISTRATION_USER_AUDIT= '[ENTITY] Fetch RegistrationUserModel audit',
	FETCH_REGISTRATION_USER_AUDIT_OK = '[ENTITY] Fetch RegistrationUserModel audit successfully',
	FETCH_REGISTRATION_USER_AUDIT_FAIL = '[ENTITY] Fetch RegistrationUserModel audit failed',

	FETCH_REGISTRATION_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RegistrationUserModel audits by entity id',
	FETCH_REGISTRATION_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RegistrationUserModel audits by entity id successfully',
	FETCH_REGISTRATION_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RegistrationUserModel audits by entity id failed',

	FETCH_ALL_REGISTRATION_USER = '[ENTITY] Fetch all RegistrationUserModel',
	FETCH_ALL_REGISTRATION_USER_OK = '[ENTITY] Fetch all RegistrationUserModel successfully',
	FETCH_ALL_REGISTRATION_USER_FAIL = '[ENTITY] Fetch all RegistrationUserModel failed',

	FETCH_REGISTRATION_USER_WITH_QUERY = '[ENTITY] Fetch RegistrationUserModel with query',
	FETCH_REGISTRATION_USER_WITH_QUERY_OK = '[ENTITY] Fetch RegistrationUserModel with query successfully',
	FETCH_REGISTRATION_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch RegistrationUserModel with query failed',

	FETCH_LAST_REGISTRATION_USER_WITH_QUERY = '[ENTITY] Fetch last RegistrationUserModel with query',
	FETCH_LAST_REGISTRATION_USER_WITH_QUERY_OK = '[ENTITY] Fetch last RegistrationUserModel with query successfully',
	FETCH_LAST_REGISTRATION_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last RegistrationUserModel with query failed',

	EXPORT_REGISTRATION_USER = '[ENTITY] Export RegistrationUserModel',
	EXPORT_REGISTRATION_USER_OK = '[ENTITY] Export RegistrationUserModel successfully',
	EXPORT_REGISTRATION_USER_FAIL = '[ENTITY] Export RegistrationUserModel failed',

	EXPORT_ALL_REGISTRATION_USER = '[ENTITY] Export All RegistrationUserModels',
	EXPORT_ALL_REGISTRATION_USER_OK = '[ENTITY] Export All RegistrationUserModels successfully',
	EXPORT_ALL_REGISTRATION_USER_FAIL = '[ENTITY] Export All RegistrationUserModels failed',

	EXPORT_REGISTRATION_USER_EXCLUDING_IDS = '[ENTITY] Export RegistrationUserModels excluding Ids',
	EXPORT_REGISTRATION_USER_EXCLUDING_IDS_OK = '[ENTITY] Export RegistrationUserModel excluding Ids successfully',
	EXPORT_REGISTRATION_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export RegistrationUserModel excluding Ids failed',

	COUNT_REGISTRATION_USERS = '[ENTITY] Fetch number of RegistrationUserModel records',
	COUNT_REGISTRATION_USERS_OK = '[ENTITY] Fetch number of RegistrationUserModel records successfully ',
	COUNT_REGISTRATION_USERS_FAIL = '[ENTITY] Fetch number of RegistrationUserModel records failed',

	IMPORT_REGISTRATION_USERS = '[ENTITY] Import RegistrationUserModels',
	IMPORT_REGISTRATION_USERS_OK = '[ENTITY] Import RegistrationUserModels successfully',
	IMPORT_REGISTRATION_USERS_FAIL = '[ENTITY] Import RegistrationUserModels fail',


	INITIALISE_REGISTRATION_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RegistrationUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRegistrationUserAction implements Action {
	readonly className: string = 'RegistrationUserModel';

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

export class RegistrationUserAction extends BaseRegistrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationUserAction here] off begin
	// % protected region % [Add any additional class fields for RegistrationUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RegistrationUserModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationUserAction here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationUserAction here] end
	}

	// % protected region % [Add any additional class methods for RegistrationUserAction here] off begin
	// % protected region % [Add any additional class methods for RegistrationUserAction here] end
}

export class RegistrationUserActionOK extends BaseRegistrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationUserActionOK here] off begin
	// % protected region % [Add any additional class fields for RegistrationUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RegistrationUserModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RegistrationUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for RegistrationUserActionOK here] off begin
	// % protected region % [Add any additional class methods for RegistrationUserActionOK here] end
}

export class RegistrationUserActionFail extends BaseRegistrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationUserActionFail here] off begin
	// % protected region % [Add any additional class fields for RegistrationUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RegistrationUserModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for RegistrationUserActionFail here] off begin
	// % protected region % [Add any additional class methods for RegistrationUserActionFail here] end
}

export function isRegistrationUserModelAction(e: any): e is BaseRegistrationUserAction {
	return Object.values(RegistrationUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
