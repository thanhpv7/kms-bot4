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
import {CashierUserModel} from './cashier_user.model';
import {CashierUserModelAudit} from './cashier_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Cashier User model actions to be dispatched by NgRx.
 */
export enum CashierUserModelActionTypes {
	CREATE_CASHIER_USER = '[ENTITY] Create CashierUserModel',
	CREATE_CASHIER_USER_OK = '[ENTITY] Create CashierUserModel successfully',
	CREATE_CASHIER_USER_FAIL = '[ENTITY] Create CashierUserModel failed',

	CREATE_ALL_CASHIER_USER = '[ENTITY] Create All CashierUserModel',
	CREATE_ALL_CASHIER_USER_OK = '[ENTITY] Create All CashierUserModel successfully',
	CREATE_ALL_CASHIER_USER_FAIL = '[ENTITY] Create All CashierUserModel failed',

	DELETE_CASHIER_USER = '[ENTITY] Delete CashierUserModel',
	DELETE_CASHIER_USER_OK = '[ENTITY] Delete CashierUserModel successfully',
	DELETE_CASHIER_USER_FAIL = '[ENTITY] Delete CashierUserModel failed',


	DELETE_CASHIER_USER_EXCLUDING_IDS = '[ENTITY] Delete CashierUserModels Excluding Ids',
	DELETE_CASHIER_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete CashierUserModels Excluding Ids successfully',
	DELETE_CASHIER_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CashierUserModels Excluding Ids failed',

	DELETE_ALL_CASHIER_USER = '[ENTITY] Delete all CashierUserModels',
	DELETE_ALL_CASHIER_USER_OK = '[ENTITY] Delete all CashierUserModels successfully',
	DELETE_ALL_CASHIER_USER_FAIL = '[ENTITY] Delete all CashierUserModels failed',

	UPDATE_CASHIER_USER = '[ENTITY] Update CashierUserModel',
	UPDATE_CASHIER_USER_OK = '[ENTITY] Update CashierUserModel successfully',
	UPDATE_CASHIER_USER_FAIL = '[ENTITY] Update CashierUserModel failed',

	UPDATE_ALL_CASHIER_USER = '[ENTITY] Update all CashierUserModel',
	UPDATE_ALL_CASHIER_USER_OK = '[ENTITY] Update all CashierUserModel successfully',
	UPDATE_ALL_CASHIER_USER_FAIL = '[ENTITY] Update all CashierUserModel failed',

	FETCH_CASHIER_USER= '[ENTITY] Fetch CashierUserModel',
	FETCH_CASHIER_USER_OK = '[ENTITY] Fetch CashierUserModel successfully',
	FETCH_CASHIER_USER_FAIL = '[ENTITY] Fetch CashierUserModel failed',

	FETCH_CASHIER_USER_AUDIT= '[ENTITY] Fetch CashierUserModel audit',
	FETCH_CASHIER_USER_AUDIT_OK = '[ENTITY] Fetch CashierUserModel audit successfully',
	FETCH_CASHIER_USER_AUDIT_FAIL = '[ENTITY] Fetch CashierUserModel audit failed',

	FETCH_CASHIER_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CashierUserModel audits by entity id',
	FETCH_CASHIER_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CashierUserModel audits by entity id successfully',
	FETCH_CASHIER_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CashierUserModel audits by entity id failed',

	FETCH_ALL_CASHIER_USER = '[ENTITY] Fetch all CashierUserModel',
	FETCH_ALL_CASHIER_USER_OK = '[ENTITY] Fetch all CashierUserModel successfully',
	FETCH_ALL_CASHIER_USER_FAIL = '[ENTITY] Fetch all CashierUserModel failed',

	FETCH_CASHIER_USER_WITH_QUERY = '[ENTITY] Fetch CashierUserModel with query',
	FETCH_CASHIER_USER_WITH_QUERY_OK = '[ENTITY] Fetch CashierUserModel with query successfully',
	FETCH_CASHIER_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch CashierUserModel with query failed',

	FETCH_LAST_CASHIER_USER_WITH_QUERY = '[ENTITY] Fetch last CashierUserModel with query',
	FETCH_LAST_CASHIER_USER_WITH_QUERY_OK = '[ENTITY] Fetch last CashierUserModel with query successfully',
	FETCH_LAST_CASHIER_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last CashierUserModel with query failed',

	EXPORT_CASHIER_USER = '[ENTITY] Export CashierUserModel',
	EXPORT_CASHIER_USER_OK = '[ENTITY] Export CashierUserModel successfully',
	EXPORT_CASHIER_USER_FAIL = '[ENTITY] Export CashierUserModel failed',

	EXPORT_ALL_CASHIER_USER = '[ENTITY] Export All CashierUserModels',
	EXPORT_ALL_CASHIER_USER_OK = '[ENTITY] Export All CashierUserModels successfully',
	EXPORT_ALL_CASHIER_USER_FAIL = '[ENTITY] Export All CashierUserModels failed',

	EXPORT_CASHIER_USER_EXCLUDING_IDS = '[ENTITY] Export CashierUserModels excluding Ids',
	EXPORT_CASHIER_USER_EXCLUDING_IDS_OK = '[ENTITY] Export CashierUserModel excluding Ids successfully',
	EXPORT_CASHIER_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export CashierUserModel excluding Ids failed',

	COUNT_CASHIER_USERS = '[ENTITY] Fetch number of CashierUserModel records',
	COUNT_CASHIER_USERS_OK = '[ENTITY] Fetch number of CashierUserModel records successfully ',
	COUNT_CASHIER_USERS_FAIL = '[ENTITY] Fetch number of CashierUserModel records failed',

	IMPORT_CASHIER_USERS = '[ENTITY] Import CashierUserModels',
	IMPORT_CASHIER_USERS_OK = '[ENTITY] Import CashierUserModels successfully',
	IMPORT_CASHIER_USERS_FAIL = '[ENTITY] Import CashierUserModels fail',


	INITIALISE_CASHIER_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CashierUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCashierUserAction implements Action {
	readonly className: string = 'CashierUserModel';

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

export class CashierUserAction extends BaseCashierUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashierUserAction here] off begin
	// % protected region % [Add any additional class fields for CashierUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashierUserModel>,
		// % protected region % [Add any additional constructor parameters for CashierUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for CashierUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashierUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for CashierUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashierUserAction here] off begin
		// % protected region % [Add any additional constructor logic for CashierUserAction here] end
	}

	// % protected region % [Add any additional class methods for CashierUserAction here] off begin
	// % protected region % [Add any additional class methods for CashierUserAction here] end
}

export class CashierUserActionOK extends BaseCashierUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashierUserActionOK here] off begin
	// % protected region % [Add any additional class fields for CashierUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashierUserModel>,
		// % protected region % [Add any additional constructor parameters for CashierUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CashierUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CashierUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashierUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CashierUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashierUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CashierUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for CashierUserActionOK here] off begin
	// % protected region % [Add any additional class methods for CashierUserActionOK here] end
}

export class CashierUserActionFail extends BaseCashierUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashierUserActionFail here] off begin
	// % protected region % [Add any additional class fields for CashierUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CashierUserModel>,
		// % protected region % [Add any additional constructor parameters for CashierUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CashierUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashierUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CashierUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashierUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CashierUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for CashierUserActionFail here] off begin
	// % protected region % [Add any additional class methods for CashierUserActionFail here] end
}

export function isCashierUserModelAction(e: any): e is BaseCashierUserAction {
	return Object.values(CashierUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
