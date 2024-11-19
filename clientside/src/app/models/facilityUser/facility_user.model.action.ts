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
import {FacilityUserModel} from './facility_user.model';
import {FacilityUserModelAudit} from './facility_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Facility User model actions to be dispatched by NgRx.
 */
export enum FacilityUserModelActionTypes {
	CREATE_FACILITY_USER = '[ENTITY] Create FacilityUserModel',
	CREATE_FACILITY_USER_OK = '[ENTITY] Create FacilityUserModel successfully',
	CREATE_FACILITY_USER_FAIL = '[ENTITY] Create FacilityUserModel failed',

	CREATE_ALL_FACILITY_USER = '[ENTITY] Create All FacilityUserModel',
	CREATE_ALL_FACILITY_USER_OK = '[ENTITY] Create All FacilityUserModel successfully',
	CREATE_ALL_FACILITY_USER_FAIL = '[ENTITY] Create All FacilityUserModel failed',

	DELETE_FACILITY_USER = '[ENTITY] Delete FacilityUserModel',
	DELETE_FACILITY_USER_OK = '[ENTITY] Delete FacilityUserModel successfully',
	DELETE_FACILITY_USER_FAIL = '[ENTITY] Delete FacilityUserModel failed',


	DELETE_FACILITY_USER_EXCLUDING_IDS = '[ENTITY] Delete FacilityUserModels Excluding Ids',
	DELETE_FACILITY_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete FacilityUserModels Excluding Ids successfully',
	DELETE_FACILITY_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete FacilityUserModels Excluding Ids failed',

	DELETE_ALL_FACILITY_USER = '[ENTITY] Delete all FacilityUserModels',
	DELETE_ALL_FACILITY_USER_OK = '[ENTITY] Delete all FacilityUserModels successfully',
	DELETE_ALL_FACILITY_USER_FAIL = '[ENTITY] Delete all FacilityUserModels failed',

	UPDATE_FACILITY_USER = '[ENTITY] Update FacilityUserModel',
	UPDATE_FACILITY_USER_OK = '[ENTITY] Update FacilityUserModel successfully',
	UPDATE_FACILITY_USER_FAIL = '[ENTITY] Update FacilityUserModel failed',

	UPDATE_ALL_FACILITY_USER = '[ENTITY] Update all FacilityUserModel',
	UPDATE_ALL_FACILITY_USER_OK = '[ENTITY] Update all FacilityUserModel successfully',
	UPDATE_ALL_FACILITY_USER_FAIL = '[ENTITY] Update all FacilityUserModel failed',

	FETCH_FACILITY_USER= '[ENTITY] Fetch FacilityUserModel',
	FETCH_FACILITY_USER_OK = '[ENTITY] Fetch FacilityUserModel successfully',
	FETCH_FACILITY_USER_FAIL = '[ENTITY] Fetch FacilityUserModel failed',

	FETCH_FACILITY_USER_AUDIT= '[ENTITY] Fetch FacilityUserModel audit',
	FETCH_FACILITY_USER_AUDIT_OK = '[ENTITY] Fetch FacilityUserModel audit successfully',
	FETCH_FACILITY_USER_AUDIT_FAIL = '[ENTITY] Fetch FacilityUserModel audit failed',

	FETCH_FACILITY_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch FacilityUserModel audits by entity id',
	FETCH_FACILITY_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch FacilityUserModel audits by entity id successfully',
	FETCH_FACILITY_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch FacilityUserModel audits by entity id failed',

	FETCH_ALL_FACILITY_USER = '[ENTITY] Fetch all FacilityUserModel',
	FETCH_ALL_FACILITY_USER_OK = '[ENTITY] Fetch all FacilityUserModel successfully',
	FETCH_ALL_FACILITY_USER_FAIL = '[ENTITY] Fetch all FacilityUserModel failed',

	FETCH_FACILITY_USER_WITH_QUERY = '[ENTITY] Fetch FacilityUserModel with query',
	FETCH_FACILITY_USER_WITH_QUERY_OK = '[ENTITY] Fetch FacilityUserModel with query successfully',
	FETCH_FACILITY_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch FacilityUserModel with query failed',

	FETCH_LAST_FACILITY_USER_WITH_QUERY = '[ENTITY] Fetch last FacilityUserModel with query',
	FETCH_LAST_FACILITY_USER_WITH_QUERY_OK = '[ENTITY] Fetch last FacilityUserModel with query successfully',
	FETCH_LAST_FACILITY_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last FacilityUserModel with query failed',

	EXPORT_FACILITY_USER = '[ENTITY] Export FacilityUserModel',
	EXPORT_FACILITY_USER_OK = '[ENTITY] Export FacilityUserModel successfully',
	EXPORT_FACILITY_USER_FAIL = '[ENTITY] Export FacilityUserModel failed',

	EXPORT_ALL_FACILITY_USER = '[ENTITY] Export All FacilityUserModels',
	EXPORT_ALL_FACILITY_USER_OK = '[ENTITY] Export All FacilityUserModels successfully',
	EXPORT_ALL_FACILITY_USER_FAIL = '[ENTITY] Export All FacilityUserModels failed',

	EXPORT_FACILITY_USER_EXCLUDING_IDS = '[ENTITY] Export FacilityUserModels excluding Ids',
	EXPORT_FACILITY_USER_EXCLUDING_IDS_OK = '[ENTITY] Export FacilityUserModel excluding Ids successfully',
	EXPORT_FACILITY_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export FacilityUserModel excluding Ids failed',

	COUNT_FACILITY_USERS = '[ENTITY] Fetch number of FacilityUserModel records',
	COUNT_FACILITY_USERS_OK = '[ENTITY] Fetch number of FacilityUserModel records successfully ',
	COUNT_FACILITY_USERS_FAIL = '[ENTITY] Fetch number of FacilityUserModel records failed',

	IMPORT_FACILITY_USERS = '[ENTITY] Import FacilityUserModels',
	IMPORT_FACILITY_USERS_OK = '[ENTITY] Import FacilityUserModels successfully',
	IMPORT_FACILITY_USERS_FAIL = '[ENTITY] Import FacilityUserModels fail',


	INITIALISE_FACILITY_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of FacilityUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseFacilityUserAction implements Action {
	readonly className: string = 'FacilityUserModel';

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

export class FacilityUserAction extends BaseFacilityUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityUserAction here] off begin
	// % protected region % [Add any additional class fields for FacilityUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FacilityUserModel>,
		// % protected region % [Add any additional constructor parameters for FacilityUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityUserAction here] off begin
		// % protected region % [Add any additional constructor logic for FacilityUserAction here] end
	}

	// % protected region % [Add any additional class methods for FacilityUserAction here] off begin
	// % protected region % [Add any additional class methods for FacilityUserAction here] end
}

export class FacilityUserActionOK extends BaseFacilityUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityUserActionOK here] off begin
	// % protected region % [Add any additional class fields for FacilityUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FacilityUserModel>,
		// % protected region % [Add any additional constructor parameters for FacilityUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: FacilityUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for FacilityUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for FacilityUserActionOK here] off begin
	// % protected region % [Add any additional class methods for FacilityUserActionOK here] end
}

export class FacilityUserActionFail extends BaseFacilityUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityUserActionFail here] off begin
	// % protected region % [Add any additional class fields for FacilityUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<FacilityUserModel>,
		// % protected region % [Add any additional constructor parameters for FacilityUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for FacilityUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for FacilityUserActionFail here] off begin
	// % protected region % [Add any additional class methods for FacilityUserActionFail here] end
}

export function isFacilityUserModelAction(e: any): e is BaseFacilityUserAction {
	return Object.values(FacilityUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
