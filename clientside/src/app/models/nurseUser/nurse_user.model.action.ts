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
import {NurseUserModel} from './nurse_user.model';
import {NurseUserModelAudit} from './nurse_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Nurse User model actions to be dispatched by NgRx.
 */
export enum NurseUserModelActionTypes {
	CREATE_NURSE_USER = '[ENTITY] Create NurseUserModel',
	CREATE_NURSE_USER_OK = '[ENTITY] Create NurseUserModel successfully',
	CREATE_NURSE_USER_FAIL = '[ENTITY] Create NurseUserModel failed',

	CREATE_ALL_NURSE_USER = '[ENTITY] Create All NurseUserModel',
	CREATE_ALL_NURSE_USER_OK = '[ENTITY] Create All NurseUserModel successfully',
	CREATE_ALL_NURSE_USER_FAIL = '[ENTITY] Create All NurseUserModel failed',

	DELETE_NURSE_USER = '[ENTITY] Delete NurseUserModel',
	DELETE_NURSE_USER_OK = '[ENTITY] Delete NurseUserModel successfully',
	DELETE_NURSE_USER_FAIL = '[ENTITY] Delete NurseUserModel failed',


	DELETE_NURSE_USER_EXCLUDING_IDS = '[ENTITY] Delete NurseUserModels Excluding Ids',
	DELETE_NURSE_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete NurseUserModels Excluding Ids successfully',
	DELETE_NURSE_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NurseUserModels Excluding Ids failed',

	DELETE_ALL_NURSE_USER = '[ENTITY] Delete all NurseUserModels',
	DELETE_ALL_NURSE_USER_OK = '[ENTITY] Delete all NurseUserModels successfully',
	DELETE_ALL_NURSE_USER_FAIL = '[ENTITY] Delete all NurseUserModels failed',

	UPDATE_NURSE_USER = '[ENTITY] Update NurseUserModel',
	UPDATE_NURSE_USER_OK = '[ENTITY] Update NurseUserModel successfully',
	UPDATE_NURSE_USER_FAIL = '[ENTITY] Update NurseUserModel failed',

	UPDATE_ALL_NURSE_USER = '[ENTITY] Update all NurseUserModel',
	UPDATE_ALL_NURSE_USER_OK = '[ENTITY] Update all NurseUserModel successfully',
	UPDATE_ALL_NURSE_USER_FAIL = '[ENTITY] Update all NurseUserModel failed',

	FETCH_NURSE_USER= '[ENTITY] Fetch NurseUserModel',
	FETCH_NURSE_USER_OK = '[ENTITY] Fetch NurseUserModel successfully',
	FETCH_NURSE_USER_FAIL = '[ENTITY] Fetch NurseUserModel failed',

	FETCH_NURSE_USER_AUDIT= '[ENTITY] Fetch NurseUserModel audit',
	FETCH_NURSE_USER_AUDIT_OK = '[ENTITY] Fetch NurseUserModel audit successfully',
	FETCH_NURSE_USER_AUDIT_FAIL = '[ENTITY] Fetch NurseUserModel audit failed',

	FETCH_NURSE_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NurseUserModel audits by entity id',
	FETCH_NURSE_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NurseUserModel audits by entity id successfully',
	FETCH_NURSE_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NurseUserModel audits by entity id failed',

	FETCH_ALL_NURSE_USER = '[ENTITY] Fetch all NurseUserModel',
	FETCH_ALL_NURSE_USER_OK = '[ENTITY] Fetch all NurseUserModel successfully',
	FETCH_ALL_NURSE_USER_FAIL = '[ENTITY] Fetch all NurseUserModel failed',

	FETCH_NURSE_USER_WITH_QUERY = '[ENTITY] Fetch NurseUserModel with query',
	FETCH_NURSE_USER_WITH_QUERY_OK = '[ENTITY] Fetch NurseUserModel with query successfully',
	FETCH_NURSE_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch NurseUserModel with query failed',

	FETCH_LAST_NURSE_USER_WITH_QUERY = '[ENTITY] Fetch last NurseUserModel with query',
	FETCH_LAST_NURSE_USER_WITH_QUERY_OK = '[ENTITY] Fetch last NurseUserModel with query successfully',
	FETCH_LAST_NURSE_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last NurseUserModel with query failed',

	EXPORT_NURSE_USER = '[ENTITY] Export NurseUserModel',
	EXPORT_NURSE_USER_OK = '[ENTITY] Export NurseUserModel successfully',
	EXPORT_NURSE_USER_FAIL = '[ENTITY] Export NurseUserModel failed',

	EXPORT_ALL_NURSE_USER = '[ENTITY] Export All NurseUserModels',
	EXPORT_ALL_NURSE_USER_OK = '[ENTITY] Export All NurseUserModels successfully',
	EXPORT_ALL_NURSE_USER_FAIL = '[ENTITY] Export All NurseUserModels failed',

	EXPORT_NURSE_USER_EXCLUDING_IDS = '[ENTITY] Export NurseUserModels excluding Ids',
	EXPORT_NURSE_USER_EXCLUDING_IDS_OK = '[ENTITY] Export NurseUserModel excluding Ids successfully',
	EXPORT_NURSE_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export NurseUserModel excluding Ids failed',

	COUNT_NURSE_USERS = '[ENTITY] Fetch number of NurseUserModel records',
	COUNT_NURSE_USERS_OK = '[ENTITY] Fetch number of NurseUserModel records successfully ',
	COUNT_NURSE_USERS_FAIL = '[ENTITY] Fetch number of NurseUserModel records failed',

	IMPORT_NURSE_USERS = '[ENTITY] Import NurseUserModels',
	IMPORT_NURSE_USERS_OK = '[ENTITY] Import NurseUserModels successfully',
	IMPORT_NURSE_USERS_FAIL = '[ENTITY] Import NurseUserModels fail',


	INITIALISE_NURSE_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NurseUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNurseUserAction implements Action {
	readonly className: string = 'NurseUserModel';

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

export class NurseUserAction extends BaseNurseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseUserAction here] off begin
	// % protected region % [Add any additional class fields for NurseUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NurseUserModel>,
		// % protected region % [Add any additional constructor parameters for NurseUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for NurseUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for NurseUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseUserAction here] off begin
		// % protected region % [Add any additional constructor logic for NurseUserAction here] end
	}

	// % protected region % [Add any additional class methods for NurseUserAction here] off begin
	// % protected region % [Add any additional class methods for NurseUserAction here] end
}

export class NurseUserActionOK extends BaseNurseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseUserActionOK here] off begin
	// % protected region % [Add any additional class fields for NurseUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NurseUserModel>,
		// % protected region % [Add any additional constructor parameters for NurseUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NurseUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NurseUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NurseUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NurseUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for NurseUserActionOK here] off begin
	// % protected region % [Add any additional class methods for NurseUserActionOK here] end
}

export class NurseUserActionFail extends BaseNurseUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseUserActionFail here] off begin
	// % protected region % [Add any additional class fields for NurseUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NurseUserModel>,
		// % protected region % [Add any additional constructor parameters for NurseUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NurseUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NurseUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NurseUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for NurseUserActionFail here] off begin
	// % protected region % [Add any additional class methods for NurseUserActionFail here] end
}

export function isNurseUserModelAction(e: any): e is BaseNurseUserAction {
	return Object.values(NurseUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
