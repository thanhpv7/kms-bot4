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
import {PharmacyUserModel} from './pharmacy_user.model';
import {PharmacyUserModelAudit} from './pharmacy_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Pharmacy User model actions to be dispatched by NgRx.
 */
export enum PharmacyUserModelActionTypes {
	CREATE_PHARMACY_USER = '[ENTITY] Create PharmacyUserModel',
	CREATE_PHARMACY_USER_OK = '[ENTITY] Create PharmacyUserModel successfully',
	CREATE_PHARMACY_USER_FAIL = '[ENTITY] Create PharmacyUserModel failed',

	CREATE_ALL_PHARMACY_USER = '[ENTITY] Create All PharmacyUserModel',
	CREATE_ALL_PHARMACY_USER_OK = '[ENTITY] Create All PharmacyUserModel successfully',
	CREATE_ALL_PHARMACY_USER_FAIL = '[ENTITY] Create All PharmacyUserModel failed',

	DELETE_PHARMACY_USER = '[ENTITY] Delete PharmacyUserModel',
	DELETE_PHARMACY_USER_OK = '[ENTITY] Delete PharmacyUserModel successfully',
	DELETE_PHARMACY_USER_FAIL = '[ENTITY] Delete PharmacyUserModel failed',


	DELETE_PHARMACY_USER_EXCLUDING_IDS = '[ENTITY] Delete PharmacyUserModels Excluding Ids',
	DELETE_PHARMACY_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete PharmacyUserModels Excluding Ids successfully',
	DELETE_PHARMACY_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PharmacyUserModels Excluding Ids failed',

	DELETE_ALL_PHARMACY_USER = '[ENTITY] Delete all PharmacyUserModels',
	DELETE_ALL_PHARMACY_USER_OK = '[ENTITY] Delete all PharmacyUserModels successfully',
	DELETE_ALL_PHARMACY_USER_FAIL = '[ENTITY] Delete all PharmacyUserModels failed',

	UPDATE_PHARMACY_USER = '[ENTITY] Update PharmacyUserModel',
	UPDATE_PHARMACY_USER_OK = '[ENTITY] Update PharmacyUserModel successfully',
	UPDATE_PHARMACY_USER_FAIL = '[ENTITY] Update PharmacyUserModel failed',

	UPDATE_ALL_PHARMACY_USER = '[ENTITY] Update all PharmacyUserModel',
	UPDATE_ALL_PHARMACY_USER_OK = '[ENTITY] Update all PharmacyUserModel successfully',
	UPDATE_ALL_PHARMACY_USER_FAIL = '[ENTITY] Update all PharmacyUserModel failed',

	FETCH_PHARMACY_USER= '[ENTITY] Fetch PharmacyUserModel',
	FETCH_PHARMACY_USER_OK = '[ENTITY] Fetch PharmacyUserModel successfully',
	FETCH_PHARMACY_USER_FAIL = '[ENTITY] Fetch PharmacyUserModel failed',

	FETCH_PHARMACY_USER_AUDIT= '[ENTITY] Fetch PharmacyUserModel audit',
	FETCH_PHARMACY_USER_AUDIT_OK = '[ENTITY] Fetch PharmacyUserModel audit successfully',
	FETCH_PHARMACY_USER_AUDIT_FAIL = '[ENTITY] Fetch PharmacyUserModel audit failed',

	FETCH_PHARMACY_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PharmacyUserModel audits by entity id',
	FETCH_PHARMACY_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PharmacyUserModel audits by entity id successfully',
	FETCH_PHARMACY_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PharmacyUserModel audits by entity id failed',

	FETCH_ALL_PHARMACY_USER = '[ENTITY] Fetch all PharmacyUserModel',
	FETCH_ALL_PHARMACY_USER_OK = '[ENTITY] Fetch all PharmacyUserModel successfully',
	FETCH_ALL_PHARMACY_USER_FAIL = '[ENTITY] Fetch all PharmacyUserModel failed',

	FETCH_PHARMACY_USER_WITH_QUERY = '[ENTITY] Fetch PharmacyUserModel with query',
	FETCH_PHARMACY_USER_WITH_QUERY_OK = '[ENTITY] Fetch PharmacyUserModel with query successfully',
	FETCH_PHARMACY_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch PharmacyUserModel with query failed',

	FETCH_LAST_PHARMACY_USER_WITH_QUERY = '[ENTITY] Fetch last PharmacyUserModel with query',
	FETCH_LAST_PHARMACY_USER_WITH_QUERY_OK = '[ENTITY] Fetch last PharmacyUserModel with query successfully',
	FETCH_LAST_PHARMACY_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last PharmacyUserModel with query failed',

	EXPORT_PHARMACY_USER = '[ENTITY] Export PharmacyUserModel',
	EXPORT_PHARMACY_USER_OK = '[ENTITY] Export PharmacyUserModel successfully',
	EXPORT_PHARMACY_USER_FAIL = '[ENTITY] Export PharmacyUserModel failed',

	EXPORT_ALL_PHARMACY_USER = '[ENTITY] Export All PharmacyUserModels',
	EXPORT_ALL_PHARMACY_USER_OK = '[ENTITY] Export All PharmacyUserModels successfully',
	EXPORT_ALL_PHARMACY_USER_FAIL = '[ENTITY] Export All PharmacyUserModels failed',

	EXPORT_PHARMACY_USER_EXCLUDING_IDS = '[ENTITY] Export PharmacyUserModels excluding Ids',
	EXPORT_PHARMACY_USER_EXCLUDING_IDS_OK = '[ENTITY] Export PharmacyUserModel excluding Ids successfully',
	EXPORT_PHARMACY_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export PharmacyUserModel excluding Ids failed',

	COUNT_PHARMACY_USERS = '[ENTITY] Fetch number of PharmacyUserModel records',
	COUNT_PHARMACY_USERS_OK = '[ENTITY] Fetch number of PharmacyUserModel records successfully ',
	COUNT_PHARMACY_USERS_FAIL = '[ENTITY] Fetch number of PharmacyUserModel records failed',

	IMPORT_PHARMACY_USERS = '[ENTITY] Import PharmacyUserModels',
	IMPORT_PHARMACY_USERS_OK = '[ENTITY] Import PharmacyUserModels successfully',
	IMPORT_PHARMACY_USERS_FAIL = '[ENTITY] Import PharmacyUserModels fail',


	INITIALISE_PHARMACY_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PharmacyUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePharmacyUserAction implements Action {
	readonly className: string = 'PharmacyUserModel';

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

export class PharmacyUserAction extends BasePharmacyUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacyUserAction here] off begin
	// % protected region % [Add any additional class fields for PharmacyUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PharmacyUserModel>,
		// % protected region % [Add any additional constructor parameters for PharmacyUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacyUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacyUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacyUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacyUserAction here] off begin
		// % protected region % [Add any additional constructor logic for PharmacyUserAction here] end
	}

	// % protected region % [Add any additional class methods for PharmacyUserAction here] off begin
	// % protected region % [Add any additional class methods for PharmacyUserAction here] end
}

export class PharmacyUserActionOK extends BasePharmacyUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacyUserActionOK here] off begin
	// % protected region % [Add any additional class fields for PharmacyUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PharmacyUserModel>,
		// % protected region % [Add any additional constructor parameters for PharmacyUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacyUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PharmacyUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacyUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacyUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacyUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PharmacyUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for PharmacyUserActionOK here] off begin
	// % protected region % [Add any additional class methods for PharmacyUserActionOK here] end
}

export class PharmacyUserActionFail extends BasePharmacyUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacyUserActionFail here] off begin
	// % protected region % [Add any additional class fields for PharmacyUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PharmacyUserModel>,
		// % protected region % [Add any additional constructor parameters for PharmacyUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacyUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacyUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacyUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacyUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PharmacyUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for PharmacyUserActionFail here] off begin
	// % protected region % [Add any additional class methods for PharmacyUserActionFail here] end
}

export function isPharmacyUserModelAction(e: any): e is BasePharmacyUserAction {
	return Object.values(PharmacyUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
