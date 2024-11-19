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
import {ClaimUserModel} from './claim_user.model';
import {ClaimUserModelAudit} from './claim_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Claim User model actions to be dispatched by NgRx.
 */
export enum ClaimUserModelActionTypes {
	CREATE_CLAIM_USER = '[ENTITY] Create ClaimUserModel',
	CREATE_CLAIM_USER_OK = '[ENTITY] Create ClaimUserModel successfully',
	CREATE_CLAIM_USER_FAIL = '[ENTITY] Create ClaimUserModel failed',

	CREATE_ALL_CLAIM_USER = '[ENTITY] Create All ClaimUserModel',
	CREATE_ALL_CLAIM_USER_OK = '[ENTITY] Create All ClaimUserModel successfully',
	CREATE_ALL_CLAIM_USER_FAIL = '[ENTITY] Create All ClaimUserModel failed',

	DELETE_CLAIM_USER = '[ENTITY] Delete ClaimUserModel',
	DELETE_CLAIM_USER_OK = '[ENTITY] Delete ClaimUserModel successfully',
	DELETE_CLAIM_USER_FAIL = '[ENTITY] Delete ClaimUserModel failed',


	DELETE_CLAIM_USER_EXCLUDING_IDS = '[ENTITY] Delete ClaimUserModels Excluding Ids',
	DELETE_CLAIM_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete ClaimUserModels Excluding Ids successfully',
	DELETE_CLAIM_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ClaimUserModels Excluding Ids failed',

	DELETE_ALL_CLAIM_USER = '[ENTITY] Delete all ClaimUserModels',
	DELETE_ALL_CLAIM_USER_OK = '[ENTITY] Delete all ClaimUserModels successfully',
	DELETE_ALL_CLAIM_USER_FAIL = '[ENTITY] Delete all ClaimUserModels failed',

	UPDATE_CLAIM_USER = '[ENTITY] Update ClaimUserModel',
	UPDATE_CLAIM_USER_OK = '[ENTITY] Update ClaimUserModel successfully',
	UPDATE_CLAIM_USER_FAIL = '[ENTITY] Update ClaimUserModel failed',

	UPDATE_ALL_CLAIM_USER = '[ENTITY] Update all ClaimUserModel',
	UPDATE_ALL_CLAIM_USER_OK = '[ENTITY] Update all ClaimUserModel successfully',
	UPDATE_ALL_CLAIM_USER_FAIL = '[ENTITY] Update all ClaimUserModel failed',

	FETCH_CLAIM_USER= '[ENTITY] Fetch ClaimUserModel',
	FETCH_CLAIM_USER_OK = '[ENTITY] Fetch ClaimUserModel successfully',
	FETCH_CLAIM_USER_FAIL = '[ENTITY] Fetch ClaimUserModel failed',

	FETCH_CLAIM_USER_AUDIT= '[ENTITY] Fetch ClaimUserModel audit',
	FETCH_CLAIM_USER_AUDIT_OK = '[ENTITY] Fetch ClaimUserModel audit successfully',
	FETCH_CLAIM_USER_AUDIT_FAIL = '[ENTITY] Fetch ClaimUserModel audit failed',

	FETCH_CLAIM_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ClaimUserModel audits by entity id',
	FETCH_CLAIM_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ClaimUserModel audits by entity id successfully',
	FETCH_CLAIM_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ClaimUserModel audits by entity id failed',

	FETCH_ALL_CLAIM_USER = '[ENTITY] Fetch all ClaimUserModel',
	FETCH_ALL_CLAIM_USER_OK = '[ENTITY] Fetch all ClaimUserModel successfully',
	FETCH_ALL_CLAIM_USER_FAIL = '[ENTITY] Fetch all ClaimUserModel failed',

	FETCH_CLAIM_USER_WITH_QUERY = '[ENTITY] Fetch ClaimUserModel with query',
	FETCH_CLAIM_USER_WITH_QUERY_OK = '[ENTITY] Fetch ClaimUserModel with query successfully',
	FETCH_CLAIM_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch ClaimUserModel with query failed',

	FETCH_LAST_CLAIM_USER_WITH_QUERY = '[ENTITY] Fetch last ClaimUserModel with query',
	FETCH_LAST_CLAIM_USER_WITH_QUERY_OK = '[ENTITY] Fetch last ClaimUserModel with query successfully',
	FETCH_LAST_CLAIM_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last ClaimUserModel with query failed',

	EXPORT_CLAIM_USER = '[ENTITY] Export ClaimUserModel',
	EXPORT_CLAIM_USER_OK = '[ENTITY] Export ClaimUserModel successfully',
	EXPORT_CLAIM_USER_FAIL = '[ENTITY] Export ClaimUserModel failed',

	EXPORT_ALL_CLAIM_USER = '[ENTITY] Export All ClaimUserModels',
	EXPORT_ALL_CLAIM_USER_OK = '[ENTITY] Export All ClaimUserModels successfully',
	EXPORT_ALL_CLAIM_USER_FAIL = '[ENTITY] Export All ClaimUserModels failed',

	EXPORT_CLAIM_USER_EXCLUDING_IDS = '[ENTITY] Export ClaimUserModels excluding Ids',
	EXPORT_CLAIM_USER_EXCLUDING_IDS_OK = '[ENTITY] Export ClaimUserModel excluding Ids successfully',
	EXPORT_CLAIM_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export ClaimUserModel excluding Ids failed',

	COUNT_CLAIM_USERS = '[ENTITY] Fetch number of ClaimUserModel records',
	COUNT_CLAIM_USERS_OK = '[ENTITY] Fetch number of ClaimUserModel records successfully ',
	COUNT_CLAIM_USERS_FAIL = '[ENTITY] Fetch number of ClaimUserModel records failed',

	IMPORT_CLAIM_USERS = '[ENTITY] Import ClaimUserModels',
	IMPORT_CLAIM_USERS_OK = '[ENTITY] Import ClaimUserModels successfully',
	IMPORT_CLAIM_USERS_FAIL = '[ENTITY] Import ClaimUserModels fail',


	INITIALISE_CLAIM_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ClaimUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseClaimUserAction implements Action {
	readonly className: string = 'ClaimUserModel';

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

export class ClaimUserAction extends BaseClaimUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ClaimUserAction here] off begin
	// % protected region % [Add any additional class fields for ClaimUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ClaimUserModel>,
		// % protected region % [Add any additional constructor parameters for ClaimUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for ClaimUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ClaimUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for ClaimUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ClaimUserAction here] off begin
		// % protected region % [Add any additional constructor logic for ClaimUserAction here] end
	}

	// % protected region % [Add any additional class methods for ClaimUserAction here] off begin
	// % protected region % [Add any additional class methods for ClaimUserAction here] end
}

export class ClaimUserActionOK extends BaseClaimUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ClaimUserActionOK here] off begin
	// % protected region % [Add any additional class fields for ClaimUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ClaimUserModel>,
		// % protected region % [Add any additional constructor parameters for ClaimUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ClaimUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ClaimUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ClaimUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ClaimUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ClaimUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ClaimUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for ClaimUserActionOK here] off begin
	// % protected region % [Add any additional class methods for ClaimUserActionOK here] end
}

export class ClaimUserActionFail extends BaseClaimUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ClaimUserActionFail here] off begin
	// % protected region % [Add any additional class fields for ClaimUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ClaimUserModel>,
		// % protected region % [Add any additional constructor parameters for ClaimUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ClaimUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ClaimUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ClaimUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ClaimUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ClaimUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for ClaimUserActionFail here] off begin
	// % protected region % [Add any additional class methods for ClaimUserActionFail here] end
}

export function isClaimUserModelAction(e: any): e is BaseClaimUserAction {
	return Object.values(ClaimUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
