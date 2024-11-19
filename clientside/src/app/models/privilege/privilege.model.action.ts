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
import {PrivilegeModel} from './privilege.model';
import {PrivilegeModelAudit} from './privilege.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Privilege model actions to be dispatched by NgRx.
 */
export enum PrivilegeModelActionTypes {
	CREATE_PRIVILEGE = '[ENTITY] Create PrivilegeModel',
	CREATE_PRIVILEGE_OK = '[ENTITY] Create PrivilegeModel successfully',
	CREATE_PRIVILEGE_FAIL = '[ENTITY] Create PrivilegeModel failed',

	CREATE_ALL_PRIVILEGE = '[ENTITY] Create All PrivilegeModel',
	CREATE_ALL_PRIVILEGE_OK = '[ENTITY] Create All PrivilegeModel successfully',
	CREATE_ALL_PRIVILEGE_FAIL = '[ENTITY] Create All PrivilegeModel failed',

	DELETE_PRIVILEGE = '[ENTITY] Delete PrivilegeModel',
	DELETE_PRIVILEGE_OK = '[ENTITY] Delete PrivilegeModel successfully',
	DELETE_PRIVILEGE_FAIL = '[ENTITY] Delete PrivilegeModel failed',


	DELETE_PRIVILEGE_EXCLUDING_IDS = '[ENTITY] Delete PrivilegeModels Excluding Ids',
	DELETE_PRIVILEGE_EXCLUDING_IDS_OK = '[ENTITY] Delete PrivilegeModels Excluding Ids successfully',
	DELETE_PRIVILEGE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PrivilegeModels Excluding Ids failed',

	DELETE_ALL_PRIVILEGE = '[ENTITY] Delete all PrivilegeModels',
	DELETE_ALL_PRIVILEGE_OK = '[ENTITY] Delete all PrivilegeModels successfully',
	DELETE_ALL_PRIVILEGE_FAIL = '[ENTITY] Delete all PrivilegeModels failed',

	UPDATE_PRIVILEGE = '[ENTITY] Update PrivilegeModel',
	UPDATE_PRIVILEGE_OK = '[ENTITY] Update PrivilegeModel successfully',
	UPDATE_PRIVILEGE_FAIL = '[ENTITY] Update PrivilegeModel failed',

	UPDATE_ALL_PRIVILEGE = '[ENTITY] Update all PrivilegeModel',
	UPDATE_ALL_PRIVILEGE_OK = '[ENTITY] Update all PrivilegeModel successfully',
	UPDATE_ALL_PRIVILEGE_FAIL = '[ENTITY] Update all PrivilegeModel failed',

	FETCH_PRIVILEGE= '[ENTITY] Fetch PrivilegeModel',
	FETCH_PRIVILEGE_OK = '[ENTITY] Fetch PrivilegeModel successfully',
	FETCH_PRIVILEGE_FAIL = '[ENTITY] Fetch PrivilegeModel failed',

	FETCH_PRIVILEGE_AUDIT= '[ENTITY] Fetch PrivilegeModel audit',
	FETCH_PRIVILEGE_AUDIT_OK = '[ENTITY] Fetch PrivilegeModel audit successfully',
	FETCH_PRIVILEGE_AUDIT_FAIL = '[ENTITY] Fetch PrivilegeModel audit failed',

	FETCH_PRIVILEGE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PrivilegeModel audits by entity id',
	FETCH_PRIVILEGE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PrivilegeModel audits by entity id successfully',
	FETCH_PRIVILEGE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PrivilegeModel audits by entity id failed',

	FETCH_ALL_PRIVILEGE = '[ENTITY] Fetch all PrivilegeModel',
	FETCH_ALL_PRIVILEGE_OK = '[ENTITY] Fetch all PrivilegeModel successfully',
	FETCH_ALL_PRIVILEGE_FAIL = '[ENTITY] Fetch all PrivilegeModel failed',

	FETCH_PRIVILEGE_WITH_QUERY = '[ENTITY] Fetch PrivilegeModel with query',
	FETCH_PRIVILEGE_WITH_QUERY_OK = '[ENTITY] Fetch PrivilegeModel with query successfully',
	FETCH_PRIVILEGE_WITH_QUERY_FAIL = '[ENTITY] Fetch PrivilegeModel with query failed',

	FETCH_LAST_PRIVILEGE_WITH_QUERY = '[ENTITY] Fetch last PrivilegeModel with query',
	FETCH_LAST_PRIVILEGE_WITH_QUERY_OK = '[ENTITY] Fetch last PrivilegeModel with query successfully',
	FETCH_LAST_PRIVILEGE_WITH_QUERY_FAIL = '[ENTITY] Fetch last PrivilegeModel with query failed',

	EXPORT_PRIVILEGE = '[ENTITY] Export PrivilegeModel',
	EXPORT_PRIVILEGE_OK = '[ENTITY] Export PrivilegeModel successfully',
	EXPORT_PRIVILEGE_FAIL = '[ENTITY] Export PrivilegeModel failed',

	EXPORT_ALL_PRIVILEGE = '[ENTITY] Export All PrivilegeModels',
	EXPORT_ALL_PRIVILEGE_OK = '[ENTITY] Export All PrivilegeModels successfully',
	EXPORT_ALL_PRIVILEGE_FAIL = '[ENTITY] Export All PrivilegeModels failed',

	EXPORT_PRIVILEGE_EXCLUDING_IDS = '[ENTITY] Export PrivilegeModels excluding Ids',
	EXPORT_PRIVILEGE_EXCLUDING_IDS_OK = '[ENTITY] Export PrivilegeModel excluding Ids successfully',
	EXPORT_PRIVILEGE_EXCLUDING_IDS_FAIL = '[ENTITY] Export PrivilegeModel excluding Ids failed',

	COUNT_PRIVILEGES = '[ENTITY] Fetch number of PrivilegeModel records',
	COUNT_PRIVILEGES_OK = '[ENTITY] Fetch number of PrivilegeModel records successfully ',
	COUNT_PRIVILEGES_FAIL = '[ENTITY] Fetch number of PrivilegeModel records failed',

	IMPORT_PRIVILEGES = '[ENTITY] Import PrivilegeModels',
	IMPORT_PRIVILEGES_OK = '[ENTITY] Import PrivilegeModels successfully',
	IMPORT_PRIVILEGES_FAIL = '[ENTITY] Import PrivilegeModels fail',


	INITIALISE_PRIVILEGE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PrivilegeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePrivilegeAction implements Action {
	readonly className: string = 'PrivilegeModel';

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

export class PrivilegeAction extends BasePrivilegeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrivilegeAction here] off begin
	// % protected region % [Add any additional class fields for PrivilegeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrivilegeModel>,
		// % protected region % [Add any additional constructor parameters for PrivilegeAction here] off begin
		// % protected region % [Add any additional constructor parameters for PrivilegeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrivilegeAction here] off begin
			// % protected region % [Add any additional constructor arguments for PrivilegeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrivilegeAction here] off begin
		// % protected region % [Add any additional constructor logic for PrivilegeAction here] end
	}

	// % protected region % [Add any additional class methods for PrivilegeAction here] off begin
	// % protected region % [Add any additional class methods for PrivilegeAction here] end
}

export class PrivilegeActionOK extends BasePrivilegeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrivilegeActionOK here] off begin
	// % protected region % [Add any additional class fields for PrivilegeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrivilegeModel>,
		// % protected region % [Add any additional constructor parameters for PrivilegeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PrivilegeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PrivilegeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrivilegeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PrivilegeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrivilegeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PrivilegeActionOK here] end
	}

	// % protected region % [Add any additional class methods for PrivilegeActionOK here] off begin
	// % protected region % [Add any additional class methods for PrivilegeActionOK here] end
}

export class PrivilegeActionFail extends BasePrivilegeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrivilegeActionFail here] off begin
	// % protected region % [Add any additional class fields for PrivilegeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PrivilegeModel>,
		// % protected region % [Add any additional constructor parameters for PrivilegeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PrivilegeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrivilegeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PrivilegeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrivilegeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PrivilegeActionFail here] end
	}

	// % protected region % [Add any additional class methods for PrivilegeActionFail here] off begin
	// % protected region % [Add any additional class methods for PrivilegeActionFail here] end
}

export function isPrivilegeModelAction(e: any): e is BasePrivilegeAction {
	return Object.values(PrivilegeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
