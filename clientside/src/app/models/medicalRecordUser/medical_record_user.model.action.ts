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
import {MedicalRecordUserModel} from './medical_record_user.model';
import {MedicalRecordUserModelAudit} from './medical_record_user.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Record user model actions to be dispatched by NgRx.
 */
export enum MedicalRecordUserModelActionTypes {
	CREATE_MEDICAL_RECORD_USER = '[ENTITY] Create MedicalRecordUserModel',
	CREATE_MEDICAL_RECORD_USER_OK = '[ENTITY] Create MedicalRecordUserModel successfully',
	CREATE_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Create MedicalRecordUserModel failed',

	CREATE_ALL_MEDICAL_RECORD_USER = '[ENTITY] Create All MedicalRecordUserModel',
	CREATE_ALL_MEDICAL_RECORD_USER_OK = '[ENTITY] Create All MedicalRecordUserModel successfully',
	CREATE_ALL_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Create All MedicalRecordUserModel failed',

	DELETE_MEDICAL_RECORD_USER = '[ENTITY] Delete MedicalRecordUserModel',
	DELETE_MEDICAL_RECORD_USER_OK = '[ENTITY] Delete MedicalRecordUserModel successfully',
	DELETE_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Delete MedicalRecordUserModel failed',


	DELETE_MEDICAL_RECORD_USER_EXCLUDING_IDS = '[ENTITY] Delete MedicalRecordUserModels Excluding Ids',
	DELETE_MEDICAL_RECORD_USER_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalRecordUserModels Excluding Ids successfully',
	DELETE_MEDICAL_RECORD_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalRecordUserModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_RECORD_USER = '[ENTITY] Delete all MedicalRecordUserModels',
	DELETE_ALL_MEDICAL_RECORD_USER_OK = '[ENTITY] Delete all MedicalRecordUserModels successfully',
	DELETE_ALL_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Delete all MedicalRecordUserModels failed',

	UPDATE_MEDICAL_RECORD_USER = '[ENTITY] Update MedicalRecordUserModel',
	UPDATE_MEDICAL_RECORD_USER_OK = '[ENTITY] Update MedicalRecordUserModel successfully',
	UPDATE_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Update MedicalRecordUserModel failed',

	UPDATE_ALL_MEDICAL_RECORD_USER = '[ENTITY] Update all MedicalRecordUserModel',
	UPDATE_ALL_MEDICAL_RECORD_USER_OK = '[ENTITY] Update all MedicalRecordUserModel successfully',
	UPDATE_ALL_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Update all MedicalRecordUserModel failed',

	FETCH_MEDICAL_RECORD_USER= '[ENTITY] Fetch MedicalRecordUserModel',
	FETCH_MEDICAL_RECORD_USER_OK = '[ENTITY] Fetch MedicalRecordUserModel successfully',
	FETCH_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Fetch MedicalRecordUserModel failed',

	FETCH_MEDICAL_RECORD_USER_AUDIT= '[ENTITY] Fetch MedicalRecordUserModel audit',
	FETCH_MEDICAL_RECORD_USER_AUDIT_OK = '[ENTITY] Fetch MedicalRecordUserModel audit successfully',
	FETCH_MEDICAL_RECORD_USER_AUDIT_FAIL = '[ENTITY] Fetch MedicalRecordUserModel audit failed',

	FETCH_MEDICAL_RECORD_USER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalRecordUserModel audits by entity id',
	FETCH_MEDICAL_RECORD_USER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalRecordUserModel audits by entity id successfully',
	FETCH_MEDICAL_RECORD_USER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalRecordUserModel audits by entity id failed',

	FETCH_ALL_MEDICAL_RECORD_USER = '[ENTITY] Fetch all MedicalRecordUserModel',
	FETCH_ALL_MEDICAL_RECORD_USER_OK = '[ENTITY] Fetch all MedicalRecordUserModel successfully',
	FETCH_ALL_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Fetch all MedicalRecordUserModel failed',

	FETCH_MEDICAL_RECORD_USER_WITH_QUERY = '[ENTITY] Fetch MedicalRecordUserModel with query',
	FETCH_MEDICAL_RECORD_USER_WITH_QUERY_OK = '[ENTITY] Fetch MedicalRecordUserModel with query successfully',
	FETCH_MEDICAL_RECORD_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalRecordUserModel with query failed',

	FETCH_LAST_MEDICAL_RECORD_USER_WITH_QUERY = '[ENTITY] Fetch last MedicalRecordUserModel with query',
	FETCH_LAST_MEDICAL_RECORD_USER_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalRecordUserModel with query successfully',
	FETCH_LAST_MEDICAL_RECORD_USER_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalRecordUserModel with query failed',

	EXPORT_MEDICAL_RECORD_USER = '[ENTITY] Export MedicalRecordUserModel',
	EXPORT_MEDICAL_RECORD_USER_OK = '[ENTITY] Export MedicalRecordUserModel successfully',
	EXPORT_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Export MedicalRecordUserModel failed',

	EXPORT_ALL_MEDICAL_RECORD_USER = '[ENTITY] Export All MedicalRecordUserModels',
	EXPORT_ALL_MEDICAL_RECORD_USER_OK = '[ENTITY] Export All MedicalRecordUserModels successfully',
	EXPORT_ALL_MEDICAL_RECORD_USER_FAIL = '[ENTITY] Export All MedicalRecordUserModels failed',

	EXPORT_MEDICAL_RECORD_USER_EXCLUDING_IDS = '[ENTITY] Export MedicalRecordUserModels excluding Ids',
	EXPORT_MEDICAL_RECORD_USER_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalRecordUserModel excluding Ids successfully',
	EXPORT_MEDICAL_RECORD_USER_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalRecordUserModel excluding Ids failed',

	COUNT_MEDICAL_RECORD_USERS = '[ENTITY] Fetch number of MedicalRecordUserModel records',
	COUNT_MEDICAL_RECORD_USERS_OK = '[ENTITY] Fetch number of MedicalRecordUserModel records successfully ',
	COUNT_MEDICAL_RECORD_USERS_FAIL = '[ENTITY] Fetch number of MedicalRecordUserModel records failed',

	IMPORT_MEDICAL_RECORD_USERS = '[ENTITY] Import MedicalRecordUserModels',
	IMPORT_MEDICAL_RECORD_USERS_OK = '[ENTITY] Import MedicalRecordUserModels successfully',
	IMPORT_MEDICAL_RECORD_USERS_FAIL = '[ENTITY] Import MedicalRecordUserModels fail',


	INITIALISE_MEDICAL_RECORD_USER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalRecordUserModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalRecordUserAction implements Action {
	readonly className: string = 'MedicalRecordUserModel';

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

export class MedicalRecordUserAction extends BaseMedicalRecordUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordUserAction here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordUserAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordUserAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordUserAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordUserAction here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordUserAction here] end
}

export class MedicalRecordUserActionOK extends BaseMedicalRecordUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordUserActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordUserActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalRecordUserModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordUserActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordUserActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordUserActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordUserActionOK here] end
}

export class MedicalRecordUserActionFail extends BaseMedicalRecordUserAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordUserActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordUserActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalRecordUserModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordUserActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordUserActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordUserActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordUserActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordUserActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordUserActionFail here] end
}

export function isMedicalRecordUserModelAction(e: any): e is BaseMedicalRecordUserAction {
	return Object.values(MedicalRecordUserModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
