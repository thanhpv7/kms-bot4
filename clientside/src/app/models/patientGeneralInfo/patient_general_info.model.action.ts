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
import {PatientGeneralInfoModel} from './patient_general_info.model';
import {PatientGeneralInfoModelAudit} from './patient_general_info.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient General Info model actions to be dispatched by NgRx.
 */
export enum PatientGeneralInfoModelActionTypes {
	CREATE_PATIENT_GENERAL_INFO = '[ENTITY] Create PatientGeneralInfoModel',
	CREATE_PATIENT_GENERAL_INFO_OK = '[ENTITY] Create PatientGeneralInfoModel successfully',
	CREATE_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Create PatientGeneralInfoModel failed',

	CREATE_ALL_PATIENT_GENERAL_INFO = '[ENTITY] Create All PatientGeneralInfoModel',
	CREATE_ALL_PATIENT_GENERAL_INFO_OK = '[ENTITY] Create All PatientGeneralInfoModel successfully',
	CREATE_ALL_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Create All PatientGeneralInfoModel failed',

	DELETE_PATIENT_GENERAL_INFO = '[ENTITY] Delete PatientGeneralInfoModel',
	DELETE_PATIENT_GENERAL_INFO_OK = '[ENTITY] Delete PatientGeneralInfoModel successfully',
	DELETE_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Delete PatientGeneralInfoModel failed',


	DELETE_PATIENT_GENERAL_INFO_EXCLUDING_IDS = '[ENTITY] Delete PatientGeneralInfoModels Excluding Ids',
	DELETE_PATIENT_GENERAL_INFO_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientGeneralInfoModels Excluding Ids successfully',
	DELETE_PATIENT_GENERAL_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientGeneralInfoModels Excluding Ids failed',

	DELETE_ALL_PATIENT_GENERAL_INFO = '[ENTITY] Delete all PatientGeneralInfoModels',
	DELETE_ALL_PATIENT_GENERAL_INFO_OK = '[ENTITY] Delete all PatientGeneralInfoModels successfully',
	DELETE_ALL_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Delete all PatientGeneralInfoModels failed',

	UPDATE_PATIENT_GENERAL_INFO = '[ENTITY] Update PatientGeneralInfoModel',
	UPDATE_PATIENT_GENERAL_INFO_OK = '[ENTITY] Update PatientGeneralInfoModel successfully',
	UPDATE_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Update PatientGeneralInfoModel failed',

	UPDATE_ALL_PATIENT_GENERAL_INFO = '[ENTITY] Update all PatientGeneralInfoModel',
	UPDATE_ALL_PATIENT_GENERAL_INFO_OK = '[ENTITY] Update all PatientGeneralInfoModel successfully',
	UPDATE_ALL_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Update all PatientGeneralInfoModel failed',

	FETCH_PATIENT_GENERAL_INFO= '[ENTITY] Fetch PatientGeneralInfoModel',
	FETCH_PATIENT_GENERAL_INFO_OK = '[ENTITY] Fetch PatientGeneralInfoModel successfully',
	FETCH_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Fetch PatientGeneralInfoModel failed',

	FETCH_PATIENT_GENERAL_INFO_AUDIT= '[ENTITY] Fetch PatientGeneralInfoModel audit',
	FETCH_PATIENT_GENERAL_INFO_AUDIT_OK = '[ENTITY] Fetch PatientGeneralInfoModel audit successfully',
	FETCH_PATIENT_GENERAL_INFO_AUDIT_FAIL = '[ENTITY] Fetch PatientGeneralInfoModel audit failed',

	FETCH_PATIENT_GENERAL_INFO_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientGeneralInfoModel audits by entity id',
	FETCH_PATIENT_GENERAL_INFO_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientGeneralInfoModel audits by entity id successfully',
	FETCH_PATIENT_GENERAL_INFO_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientGeneralInfoModel audits by entity id failed',

	FETCH_ALL_PATIENT_GENERAL_INFO = '[ENTITY] Fetch all PatientGeneralInfoModel',
	FETCH_ALL_PATIENT_GENERAL_INFO_OK = '[ENTITY] Fetch all PatientGeneralInfoModel successfully',
	FETCH_ALL_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Fetch all PatientGeneralInfoModel failed',

	FETCH_PATIENT_GENERAL_INFO_WITH_QUERY = '[ENTITY] Fetch PatientGeneralInfoModel with query',
	FETCH_PATIENT_GENERAL_INFO_WITH_QUERY_OK = '[ENTITY] Fetch PatientGeneralInfoModel with query successfully',
	FETCH_PATIENT_GENERAL_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientGeneralInfoModel with query failed',

	FETCH_LAST_PATIENT_GENERAL_INFO_WITH_QUERY = '[ENTITY] Fetch last PatientGeneralInfoModel with query',
	FETCH_LAST_PATIENT_GENERAL_INFO_WITH_QUERY_OK = '[ENTITY] Fetch last PatientGeneralInfoModel with query successfully',
	FETCH_LAST_PATIENT_GENERAL_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientGeneralInfoModel with query failed',

	EXPORT_PATIENT_GENERAL_INFO = '[ENTITY] Export PatientGeneralInfoModel',
	EXPORT_PATIENT_GENERAL_INFO_OK = '[ENTITY] Export PatientGeneralInfoModel successfully',
	EXPORT_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Export PatientGeneralInfoModel failed',

	EXPORT_ALL_PATIENT_GENERAL_INFO = '[ENTITY] Export All PatientGeneralInfoModels',
	EXPORT_ALL_PATIENT_GENERAL_INFO_OK = '[ENTITY] Export All PatientGeneralInfoModels successfully',
	EXPORT_ALL_PATIENT_GENERAL_INFO_FAIL = '[ENTITY] Export All PatientGeneralInfoModels failed',

	EXPORT_PATIENT_GENERAL_INFO_EXCLUDING_IDS = '[ENTITY] Export PatientGeneralInfoModels excluding Ids',
	EXPORT_PATIENT_GENERAL_INFO_EXCLUDING_IDS_OK = '[ENTITY] Export PatientGeneralInfoModel excluding Ids successfully',
	EXPORT_PATIENT_GENERAL_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientGeneralInfoModel excluding Ids failed',

	COUNT_PATIENT_GENERAL_INFOS = '[ENTITY] Fetch number of PatientGeneralInfoModel records',
	COUNT_PATIENT_GENERAL_INFOS_OK = '[ENTITY] Fetch number of PatientGeneralInfoModel records successfully ',
	COUNT_PATIENT_GENERAL_INFOS_FAIL = '[ENTITY] Fetch number of PatientGeneralInfoModel records failed',

	IMPORT_PATIENT_GENERAL_INFOS = '[ENTITY] Import PatientGeneralInfoModels',
	IMPORT_PATIENT_GENERAL_INFOS_OK = '[ENTITY] Import PatientGeneralInfoModels successfully',
	IMPORT_PATIENT_GENERAL_INFOS_FAIL = '[ENTITY] Import PatientGeneralInfoModels fail',


	INITIALISE_PATIENT_GENERAL_INFO_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientGeneralInfoModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientGeneralInfoAction implements Action {
	readonly className: string = 'PatientGeneralInfoModel';

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

export class PatientGeneralInfoAction extends BasePatientGeneralInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientGeneralInfoAction here] off begin
	// % protected region % [Add any additional class fields for PatientGeneralInfoAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientGeneralInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoAction here] end
	}

	// % protected region % [Add any additional class methods for PatientGeneralInfoAction here] off begin
	// % protected region % [Add any additional class methods for PatientGeneralInfoAction here] end
}

export class PatientGeneralInfoActionOK extends BasePatientGeneralInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientGeneralInfoActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientGeneralInfoActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientGeneralInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientGeneralInfoModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientGeneralInfoActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientGeneralInfoActionOK here] end
}

export class PatientGeneralInfoActionFail extends BasePatientGeneralInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientGeneralInfoActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientGeneralInfoActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientGeneralInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientGeneralInfoActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientGeneralInfoActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientGeneralInfoActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientGeneralInfoActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientGeneralInfoActionFail here] end
}

export function isPatientGeneralInfoModelAction(e: any): e is BasePatientGeneralInfoAction {
	return Object.values(PatientGeneralInfoModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
