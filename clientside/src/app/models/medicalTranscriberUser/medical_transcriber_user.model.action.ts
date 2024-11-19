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
import {MedicalTranscriberUserModel} from './medical_transcriber_user.model';
import {MedicalTranscriberUserModelAudit} from './medical_transcriber_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Transcriber User model actions to be dispatched by NgRx.
 */
export enum MedicalTranscriberUserModelActionTypes {
	CREATE_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Create MedicalTranscriberUserModel',
	CREATE_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Create MedicalTranscriberUserModel successfully',
	CREATE_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Create MedicalTranscriberUserModel failed',

	CREATE_ALL_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Create All MedicalTranscriberUserModel',
	CREATE_ALL_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Create All MedicalTranscriberUserModel successfully',
	CREATE_ALL_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Create All MedicalTranscriberUserModel failed',

	DELETE_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Delete MedicalTranscriberUserModel',
	DELETE_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Delete MedicalTranscriberUserModel successfully',
	DELETE_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Delete MedicalTranscriberUserModel failed',


	DELETE_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS = '[ENTITY] Delete MedicalTranscriberUserModels Excluding Ids',
	DELETE_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalTranscriberUserModels Excluding Ids successfully',
	DELETE_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalTranscriberUserModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Delete all MedicalTranscriberUserModels',
	DELETE_ALL_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Delete all MedicalTranscriberUserModels successfully',
	DELETE_ALL_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Delete all MedicalTranscriberUserModels failed',

	UPDATE_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Update MedicalTranscriberUserModel',
	UPDATE_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Update MedicalTranscriberUserModel successfully',
	UPDATE_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Update MedicalTranscriberUserModel failed',

	UPDATE_ALL_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Update all MedicalTranscriberUserModel',
	UPDATE_ALL_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Update all MedicalTranscriberUserModel successfully',
	UPDATE_ALL_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Update all MedicalTranscriberUserModel failed',

	FETCH_MEDICAL_TRANSCRIBER_USER= '[ENTITY] Fetch MedicalTranscriberUserModel',
	FETCH_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Fetch MedicalTranscriberUserModel successfully',
	FETCH_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Fetch MedicalTranscriberUserModel failed',

	FETCH_MEDICAL_TRANSCRIBER_USER_AUDIT= '[ENTITY] Fetch MedicalTranscriberUserModel audit',
	FETCH_MEDICAL_TRANSCRIBER_USER_AUDIT_OK = '[ENTITY] Fetch MedicalTranscriberUserModel audit successfully',
	FETCH_MEDICAL_TRANSCRIBER_USER_AUDIT_FAIL = '[ENTITY] Fetch MedicalTranscriberUserModel audit failed',

	FETCH_MEDICAL_TRANSCRIBER_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalTranscriberUserModel audits by entity id',
	FETCH_MEDICAL_TRANSCRIBER_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalTranscriberUserModel audits by entity id successfully',
	FETCH_MEDICAL_TRANSCRIBER_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalTranscriberUserModel audits by entity id failed',

	FETCH_ALL_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Fetch all MedicalTranscriberUserModel',
	FETCH_ALL_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Fetch all MedicalTranscriberUserModel successfully',
	FETCH_ALL_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Fetch all MedicalTranscriberUserModel failed',

	FETCH_MEDICAL_TRANSCRIBER_USER_WITH_QUERY = '[ENTITY] Fetch MedicalTranscriberUserModel with query',
	FETCH_MEDICAL_TRANSCRIBER_USER_WITH_QUERY_OK = '[ENTITY] Fetch MedicalTranscriberUserModel with query successfully',
	FETCH_MEDICAL_TRANSCRIBER_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalTranscriberUserModel with query failed',

	FETCH_LAST_MEDICAL_TRANSCRIBER_USER_WITH_QUERY = '[ENTITY] Fetch last MedicalTranscriberUserModel with query',
	FETCH_LAST_MEDICAL_TRANSCRIBER_USER_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalTranscriberUserModel with query successfully',
	FETCH_LAST_MEDICAL_TRANSCRIBER_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalTranscriberUserModel with query failed',

	EXPORT_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Export MedicalTranscriberUserModel',
	EXPORT_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Export MedicalTranscriberUserModel successfully',
	EXPORT_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Export MedicalTranscriberUserModel failed',

	EXPORT_ALL_MEDICAL_TRANSCRIBER_USER = '[ENTITY] Export All MedicalTranscriberUserModels',
	EXPORT_ALL_MEDICAL_TRANSCRIBER_USER_OK = '[ENTITY] Export All MedicalTranscriberUserModels successfully',
	EXPORT_ALL_MEDICAL_TRANSCRIBER_USER_FAIL = '[ENTITY] Export All MedicalTranscriberUserModels failed',

	EXPORT_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS = '[ENTITY] Export MedicalTranscriberUserModels excluding Ids',
	EXPORT_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalTranscriberUserModel excluding Ids successfully',
	EXPORT_MEDICAL_TRANSCRIBER_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalTranscriberUserModel excluding Ids failed',

	COUNT_MEDICAL_TRANSCRIBER_USERS = '[ENTITY] Fetch number of MedicalTranscriberUserModel records',
	COUNT_MEDICAL_TRANSCRIBER_USERS_OK = '[ENTITY] Fetch number of MedicalTranscriberUserModel records successfully ',
	COUNT_MEDICAL_TRANSCRIBER_USERS_FAIL = '[ENTITY] Fetch number of MedicalTranscriberUserModel records failed',

	IMPORT_MEDICAL_TRANSCRIBER_USERS = '[ENTITY] Import MedicalTranscriberUserModels',
	IMPORT_MEDICAL_TRANSCRIBER_USERS_OK = '[ENTITY] Import MedicalTranscriberUserModels successfully',
	IMPORT_MEDICAL_TRANSCRIBER_USERS_FAIL = '[ENTITY] Import MedicalTranscriberUserModels fail',


	INITIALISE_MEDICAL_TRANSCRIBER_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalTranscriberUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalTranscriberUserAction implements Action {
	readonly className: string = 'MedicalTranscriberUserModel';

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

export class MedicalTranscriberUserAction extends BaseMedicalTranscriberUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalTranscriberUserAction here] off begin
	// % protected region % [Add any additional class fields for MedicalTranscriberUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalTranscriberUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalTranscriberUserAction here] off begin
	// % protected region % [Add any additional class methods for MedicalTranscriberUserAction here] end
}

export class MedicalTranscriberUserActionOK extends BaseMedicalTranscriberUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalTranscriberUserActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalTranscriberUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalTranscriberUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalTranscriberUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalTranscriberUserActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalTranscriberUserActionOK here] end
}

export class MedicalTranscriberUserActionFail extends BaseMedicalTranscriberUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalTranscriberUserActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalTranscriberUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalTranscriberUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalTranscriberUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalTranscriberUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalTranscriberUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalTranscriberUserActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalTranscriberUserActionFail here] end
}

export function isMedicalTranscriberUserModelAction(e: any): e is BaseMedicalTranscriberUserAction {
	return Object.values(MedicalTranscriberUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
