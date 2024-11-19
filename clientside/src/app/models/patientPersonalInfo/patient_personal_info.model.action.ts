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
import {PatientPersonalInfoModel} from './patient_personal_info.model';
import {PatientPersonalInfoModelAudit} from './patient_personal_info.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Personal Info model actions to be dispatched by NgRx.
 */
export enum PatientPersonalInfoModelActionTypes {
	CREATE_PATIENT_PERSONAL_INFO = '[ENTITY] Create PatientPersonalInfoModel',
	CREATE_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Create PatientPersonalInfoModel successfully',
	CREATE_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Create PatientPersonalInfoModel failed',

	CREATE_ALL_PATIENT_PERSONAL_INFO = '[ENTITY] Create All PatientPersonalInfoModel',
	CREATE_ALL_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Create All PatientPersonalInfoModel successfully',
	CREATE_ALL_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Create All PatientPersonalInfoModel failed',

	DELETE_PATIENT_PERSONAL_INFO = '[ENTITY] Delete PatientPersonalInfoModel',
	DELETE_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Delete PatientPersonalInfoModel successfully',
	DELETE_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Delete PatientPersonalInfoModel failed',


	DELETE_PATIENT_PERSONAL_INFO_EXCLUDING_IDS = '[ENTITY] Delete PatientPersonalInfoModels Excluding Ids',
	DELETE_PATIENT_PERSONAL_INFO_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientPersonalInfoModels Excluding Ids successfully',
	DELETE_PATIENT_PERSONAL_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientPersonalInfoModels Excluding Ids failed',

	DELETE_ALL_PATIENT_PERSONAL_INFO = '[ENTITY] Delete all PatientPersonalInfoModels',
	DELETE_ALL_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Delete all PatientPersonalInfoModels successfully',
	DELETE_ALL_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Delete all PatientPersonalInfoModels failed',

	UPDATE_PATIENT_PERSONAL_INFO = '[ENTITY] Update PatientPersonalInfoModel',
	UPDATE_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Update PatientPersonalInfoModel successfully',
	UPDATE_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Update PatientPersonalInfoModel failed',

	UPDATE_ALL_PATIENT_PERSONAL_INFO = '[ENTITY] Update all PatientPersonalInfoModel',
	UPDATE_ALL_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Update all PatientPersonalInfoModel successfully',
	UPDATE_ALL_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Update all PatientPersonalInfoModel failed',

	FETCH_PATIENT_PERSONAL_INFO= '[ENTITY] Fetch PatientPersonalInfoModel',
	FETCH_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Fetch PatientPersonalInfoModel successfully',
	FETCH_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Fetch PatientPersonalInfoModel failed',

	FETCH_PATIENT_PERSONAL_INFO_AUDIT= '[ENTITY] Fetch PatientPersonalInfoModel audit',
	FETCH_PATIENT_PERSONAL_INFO_AUDIT_OK = '[ENTITY] Fetch PatientPersonalInfoModel audit successfully',
	FETCH_PATIENT_PERSONAL_INFO_AUDIT_FAIL = '[ENTITY] Fetch PatientPersonalInfoModel audit failed',

	FETCH_PATIENT_PERSONAL_INFO_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientPersonalInfoModel audits by entity id',
	FETCH_PATIENT_PERSONAL_INFO_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientPersonalInfoModel audits by entity id successfully',
	FETCH_PATIENT_PERSONAL_INFO_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientPersonalInfoModel audits by entity id failed',

	FETCH_ALL_PATIENT_PERSONAL_INFO = '[ENTITY] Fetch all PatientPersonalInfoModel',
	FETCH_ALL_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Fetch all PatientPersonalInfoModel successfully',
	FETCH_ALL_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Fetch all PatientPersonalInfoModel failed',

	FETCH_PATIENT_PERSONAL_INFO_WITH_QUERY = '[ENTITY] Fetch PatientPersonalInfoModel with query',
	FETCH_PATIENT_PERSONAL_INFO_WITH_QUERY_OK = '[ENTITY] Fetch PatientPersonalInfoModel with query successfully',
	FETCH_PATIENT_PERSONAL_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientPersonalInfoModel with query failed',

	FETCH_LAST_PATIENT_PERSONAL_INFO_WITH_QUERY = '[ENTITY] Fetch last PatientPersonalInfoModel with query',
	FETCH_LAST_PATIENT_PERSONAL_INFO_WITH_QUERY_OK = '[ENTITY] Fetch last PatientPersonalInfoModel with query successfully',
	FETCH_LAST_PATIENT_PERSONAL_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientPersonalInfoModel with query failed',

	EXPORT_PATIENT_PERSONAL_INFO = '[ENTITY] Export PatientPersonalInfoModel',
	EXPORT_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Export PatientPersonalInfoModel successfully',
	EXPORT_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Export PatientPersonalInfoModel failed',

	EXPORT_ALL_PATIENT_PERSONAL_INFO = '[ENTITY] Export All PatientPersonalInfoModels',
	EXPORT_ALL_PATIENT_PERSONAL_INFO_OK = '[ENTITY] Export All PatientPersonalInfoModels successfully',
	EXPORT_ALL_PATIENT_PERSONAL_INFO_FAIL = '[ENTITY] Export All PatientPersonalInfoModels failed',

	EXPORT_PATIENT_PERSONAL_INFO_EXCLUDING_IDS = '[ENTITY] Export PatientPersonalInfoModels excluding Ids',
	EXPORT_PATIENT_PERSONAL_INFO_EXCLUDING_IDS_OK = '[ENTITY] Export PatientPersonalInfoModel excluding Ids successfully',
	EXPORT_PATIENT_PERSONAL_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientPersonalInfoModel excluding Ids failed',

	COUNT_PATIENT_PERSONAL_INFOS = '[ENTITY] Fetch number of PatientPersonalInfoModel records',
	COUNT_PATIENT_PERSONAL_INFOS_OK = '[ENTITY] Fetch number of PatientPersonalInfoModel records successfully ',
	COUNT_PATIENT_PERSONAL_INFOS_FAIL = '[ENTITY] Fetch number of PatientPersonalInfoModel records failed',

	IMPORT_PATIENT_PERSONAL_INFOS = '[ENTITY] Import PatientPersonalInfoModels',
	IMPORT_PATIENT_PERSONAL_INFOS_OK = '[ENTITY] Import PatientPersonalInfoModels successfully',
	IMPORT_PATIENT_PERSONAL_INFOS_FAIL = '[ENTITY] Import PatientPersonalInfoModels fail',


	INITIALISE_PATIENT_PERSONAL_INFO_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientPersonalInfoModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientPersonalInfoAction implements Action {
	readonly className: string = 'PatientPersonalInfoModel';

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

export class PatientPersonalInfoAction extends BasePatientPersonalInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPersonalInfoAction here] off begin
	// % protected region % [Add any additional class fields for PatientPersonalInfoAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPersonalInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoAction here] end
	}

	// % protected region % [Add any additional class methods for PatientPersonalInfoAction here] off begin
	// % protected region % [Add any additional class methods for PatientPersonalInfoAction here] end
}

export class PatientPersonalInfoActionOK extends BasePatientPersonalInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPersonalInfoActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientPersonalInfoActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPersonalInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientPersonalInfoModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientPersonalInfoActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientPersonalInfoActionOK here] end
}

export class PatientPersonalInfoActionFail extends BasePatientPersonalInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPersonalInfoActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientPersonalInfoActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientPersonalInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPersonalInfoActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPersonalInfoActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientPersonalInfoActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientPersonalInfoActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientPersonalInfoActionFail here] end
}

export function isPatientPersonalInfoModelAction(e: any): e is BasePatientPersonalInfoAction {
	return Object.values(PatientPersonalInfoModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
