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
import {RoleModel} from './role.model';
import {RoleModelAudit} from './role.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Role model actions to be dispatched by NgRx.
 */
export enum RoleModelActionTypes {
	CREATE_ROLE = '[ENTITY] Create RoleModel',
	CREATE_ROLE_OK = '[ENTITY] Create RoleModel successfully',
	CREATE_ROLE_FAIL = '[ENTITY] Create RoleModel failed',

	CREATE_ALL_ROLE = '[ENTITY] Create All RoleModel',
	CREATE_ALL_ROLE_OK = '[ENTITY] Create All RoleModel successfully',
	CREATE_ALL_ROLE_FAIL = '[ENTITY] Create All RoleModel failed',

	DELETE_ROLE = '[ENTITY] Delete RoleModel',
	DELETE_ROLE_OK = '[ENTITY] Delete RoleModel successfully',
	DELETE_ROLE_FAIL = '[ENTITY] Delete RoleModel failed',


	DELETE_ROLE_EXCLUDING_IDS = '[ENTITY] Delete RoleModels Excluding Ids',
	DELETE_ROLE_EXCLUDING_IDS_OK = '[ENTITY] Delete RoleModels Excluding Ids successfully',
	DELETE_ROLE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RoleModels Excluding Ids failed',

	DELETE_ALL_ROLE = '[ENTITY] Delete all RoleModels',
	DELETE_ALL_ROLE_OK = '[ENTITY] Delete all RoleModels successfully',
	DELETE_ALL_ROLE_FAIL = '[ENTITY] Delete all RoleModels failed',

	UPDATE_ROLE = '[ENTITY] Update RoleModel',
	UPDATE_ROLE_OK = '[ENTITY] Update RoleModel successfully',
	UPDATE_ROLE_FAIL = '[ENTITY] Update RoleModel failed',

	UPDATE_ALL_ROLE = '[ENTITY] Update all RoleModel',
	UPDATE_ALL_ROLE_OK = '[ENTITY] Update all RoleModel successfully',
	UPDATE_ALL_ROLE_FAIL = '[ENTITY] Update all RoleModel failed',

	FETCH_ROLE= '[ENTITY] Fetch RoleModel',
	FETCH_ROLE_OK = '[ENTITY] Fetch RoleModel successfully',
	FETCH_ROLE_FAIL = '[ENTITY] Fetch RoleModel failed',

	FETCH_ROLE_AUDIT= '[ENTITY] Fetch RoleModel audit',
	FETCH_ROLE_AUDIT_OK = '[ENTITY] Fetch RoleModel audit successfully',
	FETCH_ROLE_AUDIT_FAIL = '[ENTITY] Fetch RoleModel audit failed',

	FETCH_ROLE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RoleModel audits by entity id',
	FETCH_ROLE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RoleModel audits by entity id successfully',
	FETCH_ROLE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RoleModel audits by entity id failed',

	FETCH_ALL_ROLE = '[ENTITY] Fetch all RoleModel',
	FETCH_ALL_ROLE_OK = '[ENTITY] Fetch all RoleModel successfully',
	FETCH_ALL_ROLE_FAIL = '[ENTITY] Fetch all RoleModel failed',

	FETCH_ROLE_WITH_QUERY = '[ENTITY] Fetch RoleModel with query',
	FETCH_ROLE_WITH_QUERY_OK = '[ENTITY] Fetch RoleModel with query successfully',
	FETCH_ROLE_WITH_QUERY_FAIL = '[ENTITY] Fetch RoleModel with query failed',

	FETCH_LAST_ROLE_WITH_QUERY = '[ENTITY] Fetch last RoleModel with query',
	FETCH_LAST_ROLE_WITH_QUERY_OK = '[ENTITY] Fetch last RoleModel with query successfully',
	FETCH_LAST_ROLE_WITH_QUERY_FAIL = '[ENTITY] Fetch last RoleModel with query failed',

	EXPORT_ROLE = '[ENTITY] Export RoleModel',
	EXPORT_ROLE_OK = '[ENTITY] Export RoleModel successfully',
	EXPORT_ROLE_FAIL = '[ENTITY] Export RoleModel failed',

	EXPORT_ALL_ROLE = '[ENTITY] Export All RoleModels',
	EXPORT_ALL_ROLE_OK = '[ENTITY] Export All RoleModels successfully',
	EXPORT_ALL_ROLE_FAIL = '[ENTITY] Export All RoleModels failed',

	EXPORT_ROLE_EXCLUDING_IDS = '[ENTITY] Export RoleModels excluding Ids',
	EXPORT_ROLE_EXCLUDING_IDS_OK = '[ENTITY] Export RoleModel excluding Ids successfully',
	EXPORT_ROLE_EXCLUDING_IDS_FAIL = '[ENTITY] Export RoleModel excluding Ids failed',

	COUNT_ROLES = '[ENTITY] Fetch number of RoleModel records',
	COUNT_ROLES_OK = '[ENTITY] Fetch number of RoleModel records successfully ',
	COUNT_ROLES_FAIL = '[ENTITY] Fetch number of RoleModel records failed',

	IMPORT_ROLES = '[ENTITY] Import RoleModels',
	IMPORT_ROLES_OK = '[ENTITY] Import RoleModels successfully',
	IMPORT_ROLES_FAIL = '[ENTITY] Import RoleModels fail',


	INITIALISE_ROLE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RoleModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRoleAction implements Action {
	readonly className: string = 'RoleModel';

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

export class RoleAction extends BaseRoleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoleAction here] off begin
	// % protected region % [Add any additional class fields for RoleAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoleModel>,
		// % protected region % [Add any additional constructor parameters for RoleAction here] off begin
		// % protected region % [Add any additional constructor parameters for RoleAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoleAction here] off begin
			// % protected region % [Add any additional constructor arguments for RoleAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoleAction here] off begin
		// % protected region % [Add any additional constructor logic for RoleAction here] end
	}

	// % protected region % [Add any additional class methods for RoleAction here] off begin
	// % protected region % [Add any additional class methods for RoleAction here] end
}

export class RoleActionOK extends BaseRoleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoleActionOK here] off begin
	// % protected region % [Add any additional class fields for RoleActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoleModel>,
		// % protected region % [Add any additional constructor parameters for RoleActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RoleActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RoleModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoleActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RoleActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoleActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RoleActionOK here] end
	}

	// % protected region % [Add any additional class methods for RoleActionOK here] off begin
	// % protected region % [Add any additional class methods for RoleActionOK here] end
}

export class RoleActionFail extends BaseRoleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoleActionFail here] off begin
	// % protected region % [Add any additional class fields for RoleActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RoleModel>,
		// % protected region % [Add any additional constructor parameters for RoleActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RoleActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoleActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RoleActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoleActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RoleActionFail here] end
	}

	// % protected region % [Add any additional class methods for RoleActionFail here] off begin
	// % protected region % [Add any additional class methods for RoleActionFail here] end
}

export function isRoleModelAction(e: any): e is BaseRoleAction {
	return Object.values(RoleModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
