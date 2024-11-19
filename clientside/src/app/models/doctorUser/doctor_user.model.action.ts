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
import {DoctorUserModel} from './doctor_user.model';
import {DoctorUserModelAudit} from './doctor_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Doctor User model actions to be dispatched by NgRx.
 */
export enum DoctorUserModelActionTypes {
	CREATE_DOCTOR_USER = '[ENTITY] Create DoctorUserModel',
	CREATE_DOCTOR_USER_OK = '[ENTITY] Create DoctorUserModel successfully',
	CREATE_DOCTOR_USER_FAIL = '[ENTITY] Create DoctorUserModel failed',

	CREATE_ALL_DOCTOR_USER = '[ENTITY] Create All DoctorUserModel',
	CREATE_ALL_DOCTOR_USER_OK = '[ENTITY] Create All DoctorUserModel successfully',
	CREATE_ALL_DOCTOR_USER_FAIL = '[ENTITY] Create All DoctorUserModel failed',

	DELETE_DOCTOR_USER = '[ENTITY] Delete DoctorUserModel',
	DELETE_DOCTOR_USER_OK = '[ENTITY] Delete DoctorUserModel successfully',
	DELETE_DOCTOR_USER_FAIL = '[ENTITY] Delete DoctorUserModel failed',


	DELETE_DOCTOR_USER_EXCLUDING_IDS = '[ENTITY] Delete DoctorUserModels Excluding Ids',
	DELETE_DOCTOR_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete DoctorUserModels Excluding Ids successfully',
	DELETE_DOCTOR_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DoctorUserModels Excluding Ids failed',

	DELETE_ALL_DOCTOR_USER = '[ENTITY] Delete all DoctorUserModels',
	DELETE_ALL_DOCTOR_USER_OK = '[ENTITY] Delete all DoctorUserModels successfully',
	DELETE_ALL_DOCTOR_USER_FAIL = '[ENTITY] Delete all DoctorUserModels failed',

	UPDATE_DOCTOR_USER = '[ENTITY] Update DoctorUserModel',
	UPDATE_DOCTOR_USER_OK = '[ENTITY] Update DoctorUserModel successfully',
	UPDATE_DOCTOR_USER_FAIL = '[ENTITY] Update DoctorUserModel failed',

	UPDATE_ALL_DOCTOR_USER = '[ENTITY] Update all DoctorUserModel',
	UPDATE_ALL_DOCTOR_USER_OK = '[ENTITY] Update all DoctorUserModel successfully',
	UPDATE_ALL_DOCTOR_USER_FAIL = '[ENTITY] Update all DoctorUserModel failed',

	FETCH_DOCTOR_USER= '[ENTITY] Fetch DoctorUserModel',
	FETCH_DOCTOR_USER_OK = '[ENTITY] Fetch DoctorUserModel successfully',
	FETCH_DOCTOR_USER_FAIL = '[ENTITY] Fetch DoctorUserModel failed',

	FETCH_DOCTOR_USER_AUDIT= '[ENTITY] Fetch DoctorUserModel audit',
	FETCH_DOCTOR_USER_AUDIT_OK = '[ENTITY] Fetch DoctorUserModel audit successfully',
	FETCH_DOCTOR_USER_AUDIT_FAIL = '[ENTITY] Fetch DoctorUserModel audit failed',

	FETCH_DOCTOR_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DoctorUserModel audits by entity id',
	FETCH_DOCTOR_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DoctorUserModel audits by entity id successfully',
	FETCH_DOCTOR_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DoctorUserModel audits by entity id failed',

	FETCH_ALL_DOCTOR_USER = '[ENTITY] Fetch all DoctorUserModel',
	FETCH_ALL_DOCTOR_USER_OK = '[ENTITY] Fetch all DoctorUserModel successfully',
	FETCH_ALL_DOCTOR_USER_FAIL = '[ENTITY] Fetch all DoctorUserModel failed',

	FETCH_DOCTOR_USER_WITH_QUERY = '[ENTITY] Fetch DoctorUserModel with query',
	FETCH_DOCTOR_USER_WITH_QUERY_OK = '[ENTITY] Fetch DoctorUserModel with query successfully',
	FETCH_DOCTOR_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch DoctorUserModel with query failed',

	FETCH_LAST_DOCTOR_USER_WITH_QUERY = '[ENTITY] Fetch last DoctorUserModel with query',
	FETCH_LAST_DOCTOR_USER_WITH_QUERY_OK = '[ENTITY] Fetch last DoctorUserModel with query successfully',
	FETCH_LAST_DOCTOR_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last DoctorUserModel with query failed',

	EXPORT_DOCTOR_USER = '[ENTITY] Export DoctorUserModel',
	EXPORT_DOCTOR_USER_OK = '[ENTITY] Export DoctorUserModel successfully',
	EXPORT_DOCTOR_USER_FAIL = '[ENTITY] Export DoctorUserModel failed',

	EXPORT_ALL_DOCTOR_USER = '[ENTITY] Export All DoctorUserModels',
	EXPORT_ALL_DOCTOR_USER_OK = '[ENTITY] Export All DoctorUserModels successfully',
	EXPORT_ALL_DOCTOR_USER_FAIL = '[ENTITY] Export All DoctorUserModels failed',

	EXPORT_DOCTOR_USER_EXCLUDING_IDS = '[ENTITY] Export DoctorUserModels excluding Ids',
	EXPORT_DOCTOR_USER_EXCLUDING_IDS_OK = '[ENTITY] Export DoctorUserModel excluding Ids successfully',
	EXPORT_DOCTOR_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export DoctorUserModel excluding Ids failed',

	COUNT_DOCTOR_USERS = '[ENTITY] Fetch number of DoctorUserModel records',
	COUNT_DOCTOR_USERS_OK = '[ENTITY] Fetch number of DoctorUserModel records successfully ',
	COUNT_DOCTOR_USERS_FAIL = '[ENTITY] Fetch number of DoctorUserModel records failed',

	IMPORT_DOCTOR_USERS = '[ENTITY] Import DoctorUserModels',
	IMPORT_DOCTOR_USERS_OK = '[ENTITY] Import DoctorUserModels successfully',
	IMPORT_DOCTOR_USERS_FAIL = '[ENTITY] Import DoctorUserModels fail',


	INITIALISE_DOCTOR_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DoctorUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDoctorUserAction implements Action {
	readonly className: string = 'DoctorUserModel';

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

export class DoctorUserAction extends BaseDoctorUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorUserAction here] off begin
	// % protected region % [Add any additional class fields for DoctorUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DoctorUserModel>,
		// % protected region % [Add any additional constructor parameters for DoctorUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorUserAction here] off begin
		// % protected region % [Add any additional constructor logic for DoctorUserAction here] end
	}

	// % protected region % [Add any additional class methods for DoctorUserAction here] off begin
	// % protected region % [Add any additional class methods for DoctorUserAction here] end
}

export class DoctorUserActionOK extends BaseDoctorUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorUserActionOK here] off begin
	// % protected region % [Add any additional class fields for DoctorUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DoctorUserModel>,
		// % protected region % [Add any additional constructor parameters for DoctorUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DoctorUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DoctorUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for DoctorUserActionOK here] off begin
	// % protected region % [Add any additional class methods for DoctorUserActionOK here] end
}

export class DoctorUserActionFail extends BaseDoctorUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorUserActionFail here] off begin
	// % protected region % [Add any additional class fields for DoctorUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DoctorUserModel>,
		// % protected region % [Add any additional constructor parameters for DoctorUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DoctorUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for DoctorUserActionFail here] off begin
	// % protected region % [Add any additional class methods for DoctorUserActionFail here] end
}

export function isDoctorUserModelAction(e: any): e is BaseDoctorUserAction {
	return Object.values(DoctorUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
