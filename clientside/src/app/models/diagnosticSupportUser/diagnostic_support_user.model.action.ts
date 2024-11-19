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
import {DiagnosticSupportUserModel} from './diagnostic_support_user.model';
import {DiagnosticSupportUserModelAudit} from './diagnostic_support_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnostic Support User model actions to be dispatched by NgRx.
 */
export enum DiagnosticSupportUserModelActionTypes {
	CREATE_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Create DiagnosticSupportUserModel',
	CREATE_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Create DiagnosticSupportUserModel successfully',
	CREATE_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Create DiagnosticSupportUserModel failed',

	CREATE_ALL_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Create All DiagnosticSupportUserModel',
	CREATE_ALL_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Create All DiagnosticSupportUserModel successfully',
	CREATE_ALL_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Create All DiagnosticSupportUserModel failed',

	DELETE_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Delete DiagnosticSupportUserModel',
	DELETE_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Delete DiagnosticSupportUserModel successfully',
	DELETE_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Delete DiagnosticSupportUserModel failed',


	DELETE_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS = '[ENTITY] Delete DiagnosticSupportUserModels Excluding Ids',
	DELETE_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosticSupportUserModels Excluding Ids successfully',
	DELETE_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosticSupportUserModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Delete all DiagnosticSupportUserModels',
	DELETE_ALL_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Delete all DiagnosticSupportUserModels successfully',
	DELETE_ALL_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Delete all DiagnosticSupportUserModels failed',

	UPDATE_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Update DiagnosticSupportUserModel',
	UPDATE_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Update DiagnosticSupportUserModel successfully',
	UPDATE_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Update DiagnosticSupportUserModel failed',

	UPDATE_ALL_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Update all DiagnosticSupportUserModel',
	UPDATE_ALL_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Update all DiagnosticSupportUserModel successfully',
	UPDATE_ALL_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Update all DiagnosticSupportUserModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_USER= '[ENTITY] Fetch DiagnosticSupportUserModel',
	FETCH_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Fetch DiagnosticSupportUserModel successfully',
	FETCH_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Fetch DiagnosticSupportUserModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDIT= '[ENTITY] Fetch DiagnosticSupportUserModel audit',
	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDIT_OK = '[ENTITY] Fetch DiagnosticSupportUserModel audit successfully',
	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDIT_FAIL = '[ENTITY] Fetch DiagnosticSupportUserModel audit failed',

	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosticSupportUserModel audits by entity id',
	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosticSupportUserModel audits by entity id successfully',
	FETCH_DIAGNOSTIC_SUPPORT_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosticSupportUserModel audits by entity id failed',

	FETCH_ALL_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Fetch all DiagnosticSupportUserModel',
	FETCH_ALL_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Fetch all DiagnosticSupportUserModel successfully',
	FETCH_ALL_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Fetch all DiagnosticSupportUserModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY = '[ENTITY] Fetch DiagnosticSupportUserModel with query',
	FETCH_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosticSupportUserModel with query successfully',
	FETCH_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosticSupportUserModel with query failed',

	FETCH_LAST_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY = '[ENTITY] Fetch last DiagnosticSupportUserModel with query',
	FETCH_LAST_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosticSupportUserModel with query successfully',
	FETCH_LAST_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosticSupportUserModel with query failed',

	EXPORT_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Export DiagnosticSupportUserModel',
	EXPORT_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Export DiagnosticSupportUserModel successfully',
	EXPORT_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Export DiagnosticSupportUserModel failed',

	EXPORT_ALL_DIAGNOSTIC_SUPPORT_USER = '[ENTITY] Export All DiagnosticSupportUserModels',
	EXPORT_ALL_DIAGNOSTIC_SUPPORT_USER_OK = '[ENTITY] Export All DiagnosticSupportUserModels successfully',
	EXPORT_ALL_DIAGNOSTIC_SUPPORT_USER_FAIL = '[ENTITY] Export All DiagnosticSupportUserModels failed',

	EXPORT_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS = '[ENTITY] Export DiagnosticSupportUserModels excluding Ids',
	EXPORT_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosticSupportUserModel excluding Ids successfully',
	EXPORT_DIAGNOSTIC_SUPPORT_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosticSupportUserModel excluding Ids failed',

	COUNT_DIAGNOSTIC_SUPPORT_USERS = '[ENTITY] Fetch number of DiagnosticSupportUserModel records',
	COUNT_DIAGNOSTIC_SUPPORT_USERS_OK = '[ENTITY] Fetch number of DiagnosticSupportUserModel records successfully ',
	COUNT_DIAGNOSTIC_SUPPORT_USERS_FAIL = '[ENTITY] Fetch number of DiagnosticSupportUserModel records failed',

	IMPORT_DIAGNOSTIC_SUPPORT_USERS = '[ENTITY] Import DiagnosticSupportUserModels',
	IMPORT_DIAGNOSTIC_SUPPORT_USERS_OK = '[ENTITY] Import DiagnosticSupportUserModels successfully',
	IMPORT_DIAGNOSTIC_SUPPORT_USERS_FAIL = '[ENTITY] Import DiagnosticSupportUserModels fail',


	INITIALISE_DIAGNOSTIC_SUPPORT_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosticSupportUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosticSupportUserAction implements Action {
	readonly className: string = 'DiagnosticSupportUserModel';

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

export class DiagnosticSupportUserAction extends BaseDiagnosticSupportUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportUserAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticSupportUserModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportUserAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportUserAction here] end
}

export class DiagnosticSupportUserActionOK extends BaseDiagnosticSupportUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportUserActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticSupportUserModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosticSupportUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportUserActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportUserActionOK here] end
}

export class DiagnosticSupportUserActionFail extends BaseDiagnosticSupportUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportUserActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosticSupportUserModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportUserActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportUserActionFail here] end
}

export function isDiagnosticSupportUserModelAction(e: any): e is BaseDiagnosticSupportUserAction {
	return Object.values(DiagnosticSupportUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
