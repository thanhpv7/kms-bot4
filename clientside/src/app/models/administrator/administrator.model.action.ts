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
import {AdministratorModel} from './administrator.model';
import {AdministratorModelAudit} from './administrator.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Administrator model actions to be dispatched by NgRx.
 */
export enum AdministratorModelActionTypes {
	CREATE_ADMINISTRATOR = '[ENTITY] Create AdministratorModel',
	CREATE_ADMINISTRATOR_OK = '[ENTITY] Create AdministratorModel successfully',
	CREATE_ADMINISTRATOR_FAIL = '[ENTITY] Create AdministratorModel failed',

	CREATE_ALL_ADMINISTRATOR = '[ENTITY] Create All AdministratorModel',
	CREATE_ALL_ADMINISTRATOR_OK = '[ENTITY] Create All AdministratorModel successfully',
	CREATE_ALL_ADMINISTRATOR_FAIL = '[ENTITY] Create All AdministratorModel failed',

	DELETE_ADMINISTRATOR = '[ENTITY] Delete AdministratorModel',
	DELETE_ADMINISTRATOR_OK = '[ENTITY] Delete AdministratorModel successfully',
	DELETE_ADMINISTRATOR_FAIL = '[ENTITY] Delete AdministratorModel failed',


	DELETE_ADMINISTRATOR_EXCLUDING_IDS = '[ENTITY] Delete AdministratorModels Excluding Ids',
	DELETE_ADMINISTRATOR_EXCLUDING_IDS_OK = '[ENTITY] Delete AdministratorModels Excluding Ids successfully',
	DELETE_ADMINISTRATOR_EXCLUDING_IDS_FAIL = '[ENTITY] Delete AdministratorModels Excluding Ids failed',

	DELETE_ALL_ADMINISTRATOR = '[ENTITY] Delete all AdministratorModels',
	DELETE_ALL_ADMINISTRATOR_OK = '[ENTITY] Delete all AdministratorModels successfully',
	DELETE_ALL_ADMINISTRATOR_FAIL = '[ENTITY] Delete all AdministratorModels failed',

	UPDATE_ADMINISTRATOR = '[ENTITY] Update AdministratorModel',
	UPDATE_ADMINISTRATOR_OK = '[ENTITY] Update AdministratorModel successfully',
	UPDATE_ADMINISTRATOR_FAIL = '[ENTITY] Update AdministratorModel failed',

	UPDATE_ALL_ADMINISTRATOR = '[ENTITY] Update all AdministratorModel',
	UPDATE_ALL_ADMINISTRATOR_OK = '[ENTITY] Update all AdministratorModel successfully',
	UPDATE_ALL_ADMINISTRATOR_FAIL = '[ENTITY] Update all AdministratorModel failed',

	FETCH_ADMINISTRATOR= '[ENTITY] Fetch AdministratorModel',
	FETCH_ADMINISTRATOR_OK = '[ENTITY] Fetch AdministratorModel successfully',
	FETCH_ADMINISTRATOR_FAIL = '[ENTITY] Fetch AdministratorModel failed',

	FETCH_ADMINISTRATOR_AUDIT= '[ENTITY] Fetch AdministratorModel audit',
	FETCH_ADMINISTRATOR_AUDIT_OK = '[ENTITY] Fetch AdministratorModel audit successfully',
	FETCH_ADMINISTRATOR_AUDIT_FAIL = '[ENTITY] Fetch AdministratorModel audit failed',

	FETCH_ADMINISTRATOR_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch AdministratorModel audits by entity id',
	FETCH_ADMINISTRATOR_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch AdministratorModel audits by entity id successfully',
	FETCH_ADMINISTRATOR_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch AdministratorModel audits by entity id failed',

	FETCH_ALL_ADMINISTRATOR = '[ENTITY] Fetch all AdministratorModel',
	FETCH_ALL_ADMINISTRATOR_OK = '[ENTITY] Fetch all AdministratorModel successfully',
	FETCH_ALL_ADMINISTRATOR_FAIL = '[ENTITY] Fetch all AdministratorModel failed',

	FETCH_ADMINISTRATOR_WITH_QUERY = '[ENTITY] Fetch AdministratorModel with query',
	FETCH_ADMINISTRATOR_WITH_QUERY_OK = '[ENTITY] Fetch AdministratorModel with query successfully',
	FETCH_ADMINISTRATOR_WITH_QUERY_FAIL = '[ENTITY] Fetch AdministratorModel with query failed',

	FETCH_LAST_ADMINISTRATOR_WITH_QUERY = '[ENTITY] Fetch last AdministratorModel with query',
	FETCH_LAST_ADMINISTRATOR_WITH_QUERY_OK = '[ENTITY] Fetch last AdministratorModel with query successfully',
	FETCH_LAST_ADMINISTRATOR_WITH_QUERY_FAIL = '[ENTITY] Fetch last AdministratorModel with query failed',

	EXPORT_ADMINISTRATOR = '[ENTITY] Export AdministratorModel',
	EXPORT_ADMINISTRATOR_OK = '[ENTITY] Export AdministratorModel successfully',
	EXPORT_ADMINISTRATOR_FAIL = '[ENTITY] Export AdministratorModel failed',

	EXPORT_ALL_ADMINISTRATOR = '[ENTITY] Export All AdministratorModels',
	EXPORT_ALL_ADMINISTRATOR_OK = '[ENTITY] Export All AdministratorModels successfully',
	EXPORT_ALL_ADMINISTRATOR_FAIL = '[ENTITY] Export All AdministratorModels failed',

	EXPORT_ADMINISTRATOR_EXCLUDING_IDS = '[ENTITY] Export AdministratorModels excluding Ids',
	EXPORT_ADMINISTRATOR_EXCLUDING_IDS_OK = '[ENTITY] Export AdministratorModel excluding Ids successfully',
	EXPORT_ADMINISTRATOR_EXCLUDING_IDS_FAIL = '[ENTITY] Export AdministratorModel excluding Ids failed',

	COUNT_ADMINISTRATORS = '[ENTITY] Fetch number of AdministratorModel records',
	COUNT_ADMINISTRATORS_OK = '[ENTITY] Fetch number of AdministratorModel records successfully ',
	COUNT_ADMINISTRATORS_FAIL = '[ENTITY] Fetch number of AdministratorModel records failed',

	IMPORT_ADMINISTRATORS = '[ENTITY] Import AdministratorModels',
	IMPORT_ADMINISTRATORS_OK = '[ENTITY] Import AdministratorModels successfully',
	IMPORT_ADMINISTRATORS_FAIL = '[ENTITY] Import AdministratorModels fail',


	INITIALISE_ADMINISTRATOR_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of AdministratorModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseAdministratorAction implements Action {
	readonly className: string = 'AdministratorModel';

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

export class AdministratorAction extends BaseAdministratorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministratorAction here] off begin
	// % protected region % [Add any additional class fields for AdministratorAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AdministratorModel>,
		// % protected region % [Add any additional constructor parameters for AdministratorAction here] off begin
		// % protected region % [Add any additional constructor parameters for AdministratorAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministratorAction here] off begin
			// % protected region % [Add any additional constructor arguments for AdministratorAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministratorAction here] off begin
		// % protected region % [Add any additional constructor logic for AdministratorAction here] end
	}

	// % protected region % [Add any additional class methods for AdministratorAction here] off begin
	// % protected region % [Add any additional class methods for AdministratorAction here] end
}

export class AdministratorActionOK extends BaseAdministratorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministratorActionOK here] off begin
	// % protected region % [Add any additional class fields for AdministratorActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AdministratorModel>,
		// % protected region % [Add any additional constructor parameters for AdministratorActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for AdministratorActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: AdministratorModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministratorActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for AdministratorActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministratorActionOK here] off begin
		// % protected region % [Add any additional constructor logic for AdministratorActionOK here] end
	}

	// % protected region % [Add any additional class methods for AdministratorActionOK here] off begin
	// % protected region % [Add any additional class methods for AdministratorActionOK here] end
}

export class AdministratorActionFail extends BaseAdministratorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AdministratorActionFail here] off begin
	// % protected region % [Add any additional class fields for AdministratorActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<AdministratorModel>,
		// % protected region % [Add any additional constructor parameters for AdministratorActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for AdministratorActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AdministratorActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for AdministratorActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AdministratorActionFail here] off begin
		// % protected region % [Add any additional constructor logic for AdministratorActionFail here] end
	}

	// % protected region % [Add any additional class methods for AdministratorActionFail here] off begin
	// % protected region % [Add any additional class methods for AdministratorActionFail here] end
}

export function isAdministratorModelAction(e: any): e is BaseAdministratorAction {
	return Object.values(AdministratorModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
