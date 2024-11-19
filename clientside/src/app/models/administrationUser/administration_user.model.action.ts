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
import {AdministrationUserModel} from './administration_user.model';
import {AdministrationUserModelAudit} from './administration_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Administration User model actions to be dispatched by NgRx.
 */
export enum AdministrationUserModelActionTypes {
	CREATE_ADMINISTRATION_USER = '[ENTITY] Create AdministrationUserModel',
	CREATE_ADMINISTRATION_USER_OK = '[ENTITY] Create AdministrationUserModel successfully',
	CREATE_ADMINISTRATION_USER_FAIL = '[ENTITY] Create AdministrationUserModel failed',

	CREATE_ALL_ADMINISTRATION_USER = '[ENTITY] Create All AdministrationUserModel',
	CREATE_ALL_ADMINISTRATION_USER_OK = '[ENTITY] Create All AdministrationUserModel successfully',
	CREATE_ALL_ADMINISTRATION_USER_FAIL = '[ENTITY] Create All AdministrationUserModel failed',

	DELETE_ADMINISTRATION_USER = '[ENTITY] Delete AdministrationUserModel',
	DELETE_ADMINISTRATION_USER_OK = '[ENTITY] Delete AdministrationUserModel successfully',
	DELETE_ADMINISTRATION_USER_FAIL = '[ENTITY] Delete AdministrationUserModel failed',


	DELETE_ADMINISTRATION_USER_EXCLUDING_IDS = '[ENTITY] Delete AdministrationUserModels Excluding Ids',
	DELETE_ADMINISTRATION_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete AdministrationUserModels Excluding Ids successfully',
	DELETE_ADMINISTRATION_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete AdministrationUserModels Excluding Ids failed',

	DELETE_ALL_ADMINISTRATION_USER = '[ENTITY] Delete all AdministrationUserModels',
	DELETE_ALL_ADMINISTRATION_USER_OK = '[ENTITY] Delete all AdministrationUserModels successfully',
	DELETE_ALL_ADMINISTRATION_USER_FAIL = '[ENTITY] Delete all AdministrationUserModels failed',

	UPDATE_ADMINISTRATION_USER = '[ENTITY] Update AdministrationUserModel',
	UPDATE_ADMINISTRATION_USER_OK = '[ENTITY] Update AdministrationUserModel successfully',
	UPDATE_ADMINISTRATION_USER_FAIL = '[ENTITY] Update AdministrationUserModel failed',

	UPDATE_ALL_ADMINISTRATION_USER = '[ENTITY] Update all AdministrationUserModel',
	UPDATE_ALL_ADMINISTRATION_USER_OK = '[ENTITY] Update all AdministrationUserModel successfully',
	UPDATE_ALL_ADMINISTRATION_USER_FAIL = '[ENTITY] Update all AdministrationUserModel failed',

	FETCH_ADMINISTRATION_USER= '[ENTITY] Fetch AdministrationUserModel',
	FETCH_ADMINISTRATION_USER_OK = '[ENTITY] Fetch AdministrationUserModel successfully',
	FETCH_ADMINISTRATION_USER_FAIL = '[ENTITY] Fetch AdministrationUserModel failed',

	FETCH_ADMINISTRATION_USER_AUDIT= '[ENTITY] Fetch AdministrationUserModel audit',
	FETCH_ADMINISTRATION_USER_AUDIT_OK = '[ENTITY] Fetch AdministrationUserModel audit successfully',
	FETCH_ADMINISTRATION_USER_AUDIT_FAIL = '[ENTITY] Fetch AdministrationUserModel audit failed',

	FETCH_ADMINISTRATION_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch AdministrationUserModel audits by entity id',
	FETCH_ADMINISTRATION_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch AdministrationUserModel audits by entity id successfully',
	FETCH_ADMINISTRATION_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch AdministrationUserModel audits by entity id failed',

	FETCH_ALL_ADMINISTRATION_USER = '[ENTITY] Fetch all AdministrationUserModel',
	FETCH_ALL_ADMINISTRATION_USER_OK = '[ENTITY] Fetch all AdministrationUserModel successfully',
	FETCH_ALL_ADMINISTRATION_USER_FAIL = '[ENTITY] Fetch all AdministrationUserModel failed',

	FETCH_ADMINISTRATION_USER_WITH_QUERY = '[ENTITY] Fetch AdministrationUserModel with query',
	FETCH_ADMINISTRATION_USER_WITH_QUERY_OK = '[ENTITY] Fetch AdministrationUserModel with query successfully',
	FETCH_ADMINISTRATION_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch AdministrationUserModel with query failed',

	FETCH_LAST_ADMINISTRATION_USER_WITH_QUERY = '[ENTITY] Fetch last AdministrationUserModel with query',
	FETCH_LAST_ADMINISTRATION_USER_WITH_QUERY_OK = '[ENTITY] Fetch last AdministrationUserModel with query successfully',
	FETCH_LAST_ADMINISTRATION_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last AdministrationUserModel with query failed',

	EXPORT_ADMINISTRATION_USER = '[ENTITY] Export AdministrationUserModel',
	EXPORT_ADMINISTRATION_USER_OK = '[ENTITY] Export AdministrationUserModel successfully',
	EXPORT_ADMINISTRATION_USER_FAIL = '[ENTITY] Export AdministrationUserModel failed',

	EXPORT_ALL_ADMINISTRATION_USER = '[ENTITY] Export All AdministrationUserModels',
	EXPORT_ALL_ADMINISTRATION_USER_OK = '[ENTITY] Export All AdministrationUserModels successfully',
	EXPORT_ALL_ADMINISTRATION_USER_FAIL = '[ENTITY] Export All AdministrationUserModels failed',

	EXPORT_ADMINISTRATION_USER_EXCLUDING_IDS = '[ENTITY] Export AdministrationUserModels excluding Ids',
	EXPORT_ADMINISTRATION_USER_EXCLUDING_IDS_OK = '[ENTITY] Export AdministrationUserModel excluding Ids successfully',
	EXPORT_ADMINISTRATION_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export AdministrationUserModel excluding Ids failed',

	COUNT_ADMINISTRATION_USERS = '[ENTITY] Fetch number of AdministrationUserModel records',
	COUNT_ADMINISTRATION_USERS_OK = '[ENTITY] Fetch number of AdministrationUserModel records successfully ',
	COUNT_ADMINISTRATION_USERS_FAIL = '[ENTITY] Fetch number of AdministrationUserModel records failed',

	IMPORT_ADMINISTRATION_USERS = '[ENTITY] Import AdministrationUserModels',
	IMPORT_ADMINISTRATION_USERS_OK = '[ENTITY] Import AdministrationUserModels successfully',
	IMPORT_ADMINISTRATION_USERS_FAIL = '[ENTITY] Import AdministrationUserModels fail',


	INITIALISE_ADMINISTRATION_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of AdministrationUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseAdministrationUserAction implements Action {
	readonly className: string = 'AdministrationUserModel';

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

export class AdministrationUserAction extends BaseAdministrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministrationUserAction here] off begin
	// % protected region % [Add any additional class fields for AdministrationUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AdministrationUserModel>,
		// % protected region % [Add any additional constructor parameters for AdministrationUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for AdministrationUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministrationUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for AdministrationUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministrationUserAction here] off begin
		// % protected region % [Add any additional constructor logic for AdministrationUserAction here] end
	}

	// % protected region % [Add any additional class methods for AdministrationUserAction here] off begin
	// % protected region % [Add any additional class methods for AdministrationUserAction here] end
}

export class AdministrationUserActionOK extends BaseAdministrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministrationUserActionOK here] off begin
	// % protected region % [Add any additional class fields for AdministrationUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AdministrationUserModel>,
		// % protected region % [Add any additional constructor parameters for AdministrationUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for AdministrationUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: AdministrationUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministrationUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for AdministrationUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministrationUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for AdministrationUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for AdministrationUserActionOK here] off begin
	// % protected region % [Add any additional class methods for AdministrationUserActionOK here] end
}

export class AdministrationUserActionFail extends BaseAdministrationUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministrationUserActionFail here] off begin
	// % protected region % [Add any additional class fields for AdministrationUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<AdministrationUserModel>,
		// % protected region % [Add any additional constructor parameters for AdministrationUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for AdministrationUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministrationUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for AdministrationUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministrationUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for AdministrationUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for AdministrationUserActionFail here] off begin
	// % protected region % [Add any additional class methods for AdministrationUserActionFail here] end
}

export function isAdministrationUserModelAction(e: any): e is BaseAdministrationUserAction {
	return Object.values(AdministrationUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
