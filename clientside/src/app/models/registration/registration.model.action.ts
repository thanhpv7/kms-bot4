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
import {RegistrationModel} from './registration.model';
import {RegistrationModelAudit} from './registration.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Registration model actions to be dispatched by NgRx.
 */
export enum RegistrationModelActionTypes {
	CREATE_REGISTRATION = '[ENTITY] Create RegistrationModel',
	CREATE_REGISTRATION_OK = '[ENTITY] Create RegistrationModel successfully',
	CREATE_REGISTRATION_FAIL = '[ENTITY] Create RegistrationModel failed',

	CREATE_ALL_REGISTRATION = '[ENTITY] Create All RegistrationModel',
	CREATE_ALL_REGISTRATION_OK = '[ENTITY] Create All RegistrationModel successfully',
	CREATE_ALL_REGISTRATION_FAIL = '[ENTITY] Create All RegistrationModel failed',

	DELETE_REGISTRATION = '[ENTITY] Delete RegistrationModel',
	DELETE_REGISTRATION_OK = '[ENTITY] Delete RegistrationModel successfully',
	DELETE_REGISTRATION_FAIL = '[ENTITY] Delete RegistrationModel failed',


	DELETE_REGISTRATION_EXCLUDING_IDS = '[ENTITY] Delete RegistrationModels Excluding Ids',
	DELETE_REGISTRATION_EXCLUDING_IDS_OK = '[ENTITY] Delete RegistrationModels Excluding Ids successfully',
	DELETE_REGISTRATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RegistrationModels Excluding Ids failed',

	DELETE_ALL_REGISTRATION = '[ENTITY] Delete all RegistrationModels',
	DELETE_ALL_REGISTRATION_OK = '[ENTITY] Delete all RegistrationModels successfully',
	DELETE_ALL_REGISTRATION_FAIL = '[ENTITY] Delete all RegistrationModels failed',

	UPDATE_REGISTRATION = '[ENTITY] Update RegistrationModel',
	UPDATE_REGISTRATION_OK = '[ENTITY] Update RegistrationModel successfully',
	UPDATE_REGISTRATION_FAIL = '[ENTITY] Update RegistrationModel failed',

	UPDATE_ALL_REGISTRATION = '[ENTITY] Update all RegistrationModel',
	UPDATE_ALL_REGISTRATION_OK = '[ENTITY] Update all RegistrationModel successfully',
	UPDATE_ALL_REGISTRATION_FAIL = '[ENTITY] Update all RegistrationModel failed',

	FETCH_REGISTRATION= '[ENTITY] Fetch RegistrationModel',
	FETCH_REGISTRATION_OK = '[ENTITY] Fetch RegistrationModel successfully',
	FETCH_REGISTRATION_FAIL = '[ENTITY] Fetch RegistrationModel failed',

	FETCH_REGISTRATION_AUDIT= '[ENTITY] Fetch RegistrationModel audit',
	FETCH_REGISTRATION_AUDIT_OK = '[ENTITY] Fetch RegistrationModel audit successfully',
	FETCH_REGISTRATION_AUDIT_FAIL = '[ENTITY] Fetch RegistrationModel audit failed',

	FETCH_REGISTRATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RegistrationModel audits by entity id',
	FETCH_REGISTRATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RegistrationModel audits by entity id successfully',
	FETCH_REGISTRATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RegistrationModel audits by entity id failed',

	FETCH_ALL_REGISTRATION = '[ENTITY] Fetch all RegistrationModel',
	FETCH_ALL_REGISTRATION_OK = '[ENTITY] Fetch all RegistrationModel successfully',
	FETCH_ALL_REGISTRATION_FAIL = '[ENTITY] Fetch all RegistrationModel failed',

	FETCH_REGISTRATION_WITH_QUERY = '[ENTITY] Fetch RegistrationModel with query',
	FETCH_REGISTRATION_WITH_QUERY_OK = '[ENTITY] Fetch RegistrationModel with query successfully',
	FETCH_REGISTRATION_WITH_QUERY_FAIL = '[ENTITY] Fetch RegistrationModel with query failed',

	FETCH_LAST_REGISTRATION_WITH_QUERY = '[ENTITY] Fetch last RegistrationModel with query',
	FETCH_LAST_REGISTRATION_WITH_QUERY_OK = '[ENTITY] Fetch last RegistrationModel with query successfully',
	FETCH_LAST_REGISTRATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last RegistrationModel with query failed',

	EXPORT_REGISTRATION = '[ENTITY] Export RegistrationModel',
	EXPORT_REGISTRATION_OK = '[ENTITY] Export RegistrationModel successfully',
	EXPORT_REGISTRATION_FAIL = '[ENTITY] Export RegistrationModel failed',

	EXPORT_ALL_REGISTRATION = '[ENTITY] Export All RegistrationModels',
	EXPORT_ALL_REGISTRATION_OK = '[ENTITY] Export All RegistrationModels successfully',
	EXPORT_ALL_REGISTRATION_FAIL = '[ENTITY] Export All RegistrationModels failed',

	EXPORT_REGISTRATION_EXCLUDING_IDS = '[ENTITY] Export RegistrationModels excluding Ids',
	EXPORT_REGISTRATION_EXCLUDING_IDS_OK = '[ENTITY] Export RegistrationModel excluding Ids successfully',
	EXPORT_REGISTRATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export RegistrationModel excluding Ids failed',

	COUNT_REGISTRATIONS = '[ENTITY] Fetch number of RegistrationModel records',
	COUNT_REGISTRATIONS_OK = '[ENTITY] Fetch number of RegistrationModel records successfully ',
	COUNT_REGISTRATIONS_FAIL = '[ENTITY] Fetch number of RegistrationModel records failed',

	IMPORT_REGISTRATIONS = '[ENTITY] Import RegistrationModels',
	IMPORT_REGISTRATIONS_OK = '[ENTITY] Import RegistrationModels successfully',
	IMPORT_REGISTRATIONS_FAIL = '[ENTITY] Import RegistrationModels fail',


	INITIALISE_REGISTRATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RegistrationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRegistrationAction implements Action {
	readonly className: string = 'RegistrationModel';

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

export class RegistrationAction extends BaseRegistrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationAction here] off begin
	// % protected region % [Add any additional class fields for RegistrationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RegistrationModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationAction here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationAction here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationAction here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationAction here] end
	}

	// % protected region % [Add any additional class methods for RegistrationAction here] off begin
	// % protected region % [Add any additional class methods for RegistrationAction here] end
}

export class RegistrationActionOK extends BaseRegistrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationActionOK here] off begin
	// % protected region % [Add any additional class fields for RegistrationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RegistrationModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RegistrationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationActionOK here] end
	}

	// % protected region % [Add any additional class methods for RegistrationActionOK here] off begin
	// % protected region % [Add any additional class methods for RegistrationActionOK here] end
}

export class RegistrationActionFail extends BaseRegistrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RegistrationActionFail here] off begin
	// % protected region % [Add any additional class fields for RegistrationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RegistrationModel>,
		// % protected region % [Add any additional constructor parameters for RegistrationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RegistrationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RegistrationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RegistrationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RegistrationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RegistrationActionFail here] end
	}

	// % protected region % [Add any additional class methods for RegistrationActionFail here] off begin
	// % protected region % [Add any additional class methods for RegistrationActionFail here] end
}

export function isRegistrationModelAction(e: any): e is BaseRegistrationAction {
	return Object.values(RegistrationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
