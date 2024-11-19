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
import {PurchasingUserModel} from './purchasing_user.model';
import {PurchasingUserModelAudit} from './purchasing_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Purchasing User model actions to be dispatched by NgRx.
 */
export enum PurchasingUserModelActionTypes {
	CREATE_PURCHASING_USER = '[ENTITY] Create PurchasingUserModel',
	CREATE_PURCHASING_USER_OK = '[ENTITY] Create PurchasingUserModel successfully',
	CREATE_PURCHASING_USER_FAIL = '[ENTITY] Create PurchasingUserModel failed',

	CREATE_ALL_PURCHASING_USER = '[ENTITY] Create All PurchasingUserModel',
	CREATE_ALL_PURCHASING_USER_OK = '[ENTITY] Create All PurchasingUserModel successfully',
	CREATE_ALL_PURCHASING_USER_FAIL = '[ENTITY] Create All PurchasingUserModel failed',

	DELETE_PURCHASING_USER = '[ENTITY] Delete PurchasingUserModel',
	DELETE_PURCHASING_USER_OK = '[ENTITY] Delete PurchasingUserModel successfully',
	DELETE_PURCHASING_USER_FAIL = '[ENTITY] Delete PurchasingUserModel failed',


	DELETE_PURCHASING_USER_EXCLUDING_IDS = '[ENTITY] Delete PurchasingUserModels Excluding Ids',
	DELETE_PURCHASING_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete PurchasingUserModels Excluding Ids successfully',
	DELETE_PURCHASING_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PurchasingUserModels Excluding Ids failed',

	DELETE_ALL_PURCHASING_USER = '[ENTITY] Delete all PurchasingUserModels',
	DELETE_ALL_PURCHASING_USER_OK = '[ENTITY] Delete all PurchasingUserModels successfully',
	DELETE_ALL_PURCHASING_USER_FAIL = '[ENTITY] Delete all PurchasingUserModels failed',

	UPDATE_PURCHASING_USER = '[ENTITY] Update PurchasingUserModel',
	UPDATE_PURCHASING_USER_OK = '[ENTITY] Update PurchasingUserModel successfully',
	UPDATE_PURCHASING_USER_FAIL = '[ENTITY] Update PurchasingUserModel failed',

	UPDATE_ALL_PURCHASING_USER = '[ENTITY] Update all PurchasingUserModel',
	UPDATE_ALL_PURCHASING_USER_OK = '[ENTITY] Update all PurchasingUserModel successfully',
	UPDATE_ALL_PURCHASING_USER_FAIL = '[ENTITY] Update all PurchasingUserModel failed',

	FETCH_PURCHASING_USER= '[ENTITY] Fetch PurchasingUserModel',
	FETCH_PURCHASING_USER_OK = '[ENTITY] Fetch PurchasingUserModel successfully',
	FETCH_PURCHASING_USER_FAIL = '[ENTITY] Fetch PurchasingUserModel failed',

	FETCH_PURCHASING_USER_AUDIT= '[ENTITY] Fetch PurchasingUserModel audit',
	FETCH_PURCHASING_USER_AUDIT_OK = '[ENTITY] Fetch PurchasingUserModel audit successfully',
	FETCH_PURCHASING_USER_AUDIT_FAIL = '[ENTITY] Fetch PurchasingUserModel audit failed',

	FETCH_PURCHASING_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PurchasingUserModel audits by entity id',
	FETCH_PURCHASING_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PurchasingUserModel audits by entity id successfully',
	FETCH_PURCHASING_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PurchasingUserModel audits by entity id failed',

	FETCH_ALL_PURCHASING_USER = '[ENTITY] Fetch all PurchasingUserModel',
	FETCH_ALL_PURCHASING_USER_OK = '[ENTITY] Fetch all PurchasingUserModel successfully',
	FETCH_ALL_PURCHASING_USER_FAIL = '[ENTITY] Fetch all PurchasingUserModel failed',

	FETCH_PURCHASING_USER_WITH_QUERY = '[ENTITY] Fetch PurchasingUserModel with query',
	FETCH_PURCHASING_USER_WITH_QUERY_OK = '[ENTITY] Fetch PurchasingUserModel with query successfully',
	FETCH_PURCHASING_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch PurchasingUserModel with query failed',

	FETCH_LAST_PURCHASING_USER_WITH_QUERY = '[ENTITY] Fetch last PurchasingUserModel with query',
	FETCH_LAST_PURCHASING_USER_WITH_QUERY_OK = '[ENTITY] Fetch last PurchasingUserModel with query successfully',
	FETCH_LAST_PURCHASING_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last PurchasingUserModel with query failed',

	EXPORT_PURCHASING_USER = '[ENTITY] Export PurchasingUserModel',
	EXPORT_PURCHASING_USER_OK = '[ENTITY] Export PurchasingUserModel successfully',
	EXPORT_PURCHASING_USER_FAIL = '[ENTITY] Export PurchasingUserModel failed',

	EXPORT_ALL_PURCHASING_USER = '[ENTITY] Export All PurchasingUserModels',
	EXPORT_ALL_PURCHASING_USER_OK = '[ENTITY] Export All PurchasingUserModels successfully',
	EXPORT_ALL_PURCHASING_USER_FAIL = '[ENTITY] Export All PurchasingUserModels failed',

	EXPORT_PURCHASING_USER_EXCLUDING_IDS = '[ENTITY] Export PurchasingUserModels excluding Ids',
	EXPORT_PURCHASING_USER_EXCLUDING_IDS_OK = '[ENTITY] Export PurchasingUserModel excluding Ids successfully',
	EXPORT_PURCHASING_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export PurchasingUserModel excluding Ids failed',

	COUNT_PURCHASING_USERS = '[ENTITY] Fetch number of PurchasingUserModel records',
	COUNT_PURCHASING_USERS_OK = '[ENTITY] Fetch number of PurchasingUserModel records successfully ',
	COUNT_PURCHASING_USERS_FAIL = '[ENTITY] Fetch number of PurchasingUserModel records failed',

	IMPORT_PURCHASING_USERS = '[ENTITY] Import PurchasingUserModels',
	IMPORT_PURCHASING_USERS_OK = '[ENTITY] Import PurchasingUserModels successfully',
	IMPORT_PURCHASING_USERS_FAIL = '[ENTITY] Import PurchasingUserModels fail',


	INITIALISE_PURCHASING_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PurchasingUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePurchasingUserAction implements Action {
	readonly className: string = 'PurchasingUserModel';

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

export class PurchasingUserAction extends BasePurchasingUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchasingUserAction here] off begin
	// % protected region % [Add any additional class fields for PurchasingUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchasingUserModel>,
		// % protected region % [Add any additional constructor parameters for PurchasingUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for PurchasingUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchasingUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for PurchasingUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchasingUserAction here] off begin
		// % protected region % [Add any additional constructor logic for PurchasingUserAction here] end
	}

	// % protected region % [Add any additional class methods for PurchasingUserAction here] off begin
	// % protected region % [Add any additional class methods for PurchasingUserAction here] end
}

export class PurchasingUserActionOK extends BasePurchasingUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchasingUserActionOK here] off begin
	// % protected region % [Add any additional class fields for PurchasingUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchasingUserModel>,
		// % protected region % [Add any additional constructor parameters for PurchasingUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PurchasingUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PurchasingUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchasingUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PurchasingUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchasingUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PurchasingUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for PurchasingUserActionOK here] off begin
	// % protected region % [Add any additional class methods for PurchasingUserActionOK here] end
}

export class PurchasingUserActionFail extends BasePurchasingUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchasingUserActionFail here] off begin
	// % protected region % [Add any additional class fields for PurchasingUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PurchasingUserModel>,
		// % protected region % [Add any additional constructor parameters for PurchasingUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PurchasingUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchasingUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PurchasingUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchasingUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PurchasingUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for PurchasingUserActionFail here] off begin
	// % protected region % [Add any additional class methods for PurchasingUserActionFail here] end
}

export function isPurchasingUserModelAction(e: any): e is BasePurchasingUserAction {
	return Object.values(PurchasingUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
