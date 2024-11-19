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
import {PatientCaseHistoryModel} from './patient_case_history.model';
import {PatientCaseHistoryModelAudit} from './patient_case_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Case History model actions to be dispatched by NgRx.
 */
export enum PatientCaseHistoryModelActionTypes {
	CREATE_PATIENT_CASE_HISTORY = '[ENTITY] Create PatientCaseHistoryModel',
	CREATE_PATIENT_CASE_HISTORY_OK = '[ENTITY] Create PatientCaseHistoryModel successfully',
	CREATE_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Create PatientCaseHistoryModel failed',

	CREATE_ALL_PATIENT_CASE_HISTORY = '[ENTITY] Create All PatientCaseHistoryModel',
	CREATE_ALL_PATIENT_CASE_HISTORY_OK = '[ENTITY] Create All PatientCaseHistoryModel successfully',
	CREATE_ALL_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Create All PatientCaseHistoryModel failed',

	DELETE_PATIENT_CASE_HISTORY = '[ENTITY] Delete PatientCaseHistoryModel',
	DELETE_PATIENT_CASE_HISTORY_OK = '[ENTITY] Delete PatientCaseHistoryModel successfully',
	DELETE_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Delete PatientCaseHistoryModel failed',


	DELETE_PATIENT_CASE_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete PatientCaseHistoryModels Excluding Ids',
	DELETE_PATIENT_CASE_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientCaseHistoryModels Excluding Ids successfully',
	DELETE_PATIENT_CASE_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientCaseHistoryModels Excluding Ids failed',

	DELETE_ALL_PATIENT_CASE_HISTORY = '[ENTITY] Delete all PatientCaseHistoryModels',
	DELETE_ALL_PATIENT_CASE_HISTORY_OK = '[ENTITY] Delete all PatientCaseHistoryModels successfully',
	DELETE_ALL_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Delete all PatientCaseHistoryModels failed',

	UPDATE_PATIENT_CASE_HISTORY = '[ENTITY] Update PatientCaseHistoryModel',
	UPDATE_PATIENT_CASE_HISTORY_OK = '[ENTITY] Update PatientCaseHistoryModel successfully',
	UPDATE_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Update PatientCaseHistoryModel failed',

	UPDATE_ALL_PATIENT_CASE_HISTORY = '[ENTITY] Update all PatientCaseHistoryModel',
	UPDATE_ALL_PATIENT_CASE_HISTORY_OK = '[ENTITY] Update all PatientCaseHistoryModel successfully',
	UPDATE_ALL_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Update all PatientCaseHistoryModel failed',

	FETCH_PATIENT_CASE_HISTORY= '[ENTITY] Fetch PatientCaseHistoryModel',
	FETCH_PATIENT_CASE_HISTORY_OK = '[ENTITY] Fetch PatientCaseHistoryModel successfully',
	FETCH_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Fetch PatientCaseHistoryModel failed',

	FETCH_PATIENT_CASE_HISTORY_AUDIT= '[ENTITY] Fetch PatientCaseHistoryModel audit',
	FETCH_PATIENT_CASE_HISTORY_AUDIT_OK = '[ENTITY] Fetch PatientCaseHistoryModel audit successfully',
	FETCH_PATIENT_CASE_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch PatientCaseHistoryModel audit failed',

	FETCH_PATIENT_CASE_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientCaseHistoryModel audits by entity id',
	FETCH_PATIENT_CASE_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientCaseHistoryModel audits by entity id successfully',
	FETCH_PATIENT_CASE_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientCaseHistoryModel audits by entity id failed',

	FETCH_ALL_PATIENT_CASE_HISTORY = '[ENTITY] Fetch all PatientCaseHistoryModel',
	FETCH_ALL_PATIENT_CASE_HISTORY_OK = '[ENTITY] Fetch all PatientCaseHistoryModel successfully',
	FETCH_ALL_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Fetch all PatientCaseHistoryModel failed',

	FETCH_PATIENT_CASE_HISTORY_WITH_QUERY = '[ENTITY] Fetch PatientCaseHistoryModel with query',
	FETCH_PATIENT_CASE_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch PatientCaseHistoryModel with query successfully',
	FETCH_PATIENT_CASE_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientCaseHistoryModel with query failed',

	FETCH_LAST_PATIENT_CASE_HISTORY_WITH_QUERY = '[ENTITY] Fetch last PatientCaseHistoryModel with query',
	FETCH_LAST_PATIENT_CASE_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last PatientCaseHistoryModel with query successfully',
	FETCH_LAST_PATIENT_CASE_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientCaseHistoryModel with query failed',

	EXPORT_PATIENT_CASE_HISTORY = '[ENTITY] Export PatientCaseHistoryModel',
	EXPORT_PATIENT_CASE_HISTORY_OK = '[ENTITY] Export PatientCaseHistoryModel successfully',
	EXPORT_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Export PatientCaseHistoryModel failed',

	EXPORT_ALL_PATIENT_CASE_HISTORY = '[ENTITY] Export All PatientCaseHistoryModels',
	EXPORT_ALL_PATIENT_CASE_HISTORY_OK = '[ENTITY] Export All PatientCaseHistoryModels successfully',
	EXPORT_ALL_PATIENT_CASE_HISTORY_FAIL = '[ENTITY] Export All PatientCaseHistoryModels failed',

	EXPORT_PATIENT_CASE_HISTORY_EXCLUDING_IDS = '[ENTITY] Export PatientCaseHistoryModels excluding Ids',
	EXPORT_PATIENT_CASE_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export PatientCaseHistoryModel excluding Ids successfully',
	EXPORT_PATIENT_CASE_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientCaseHistoryModel excluding Ids failed',

	COUNT_PATIENT_CASE_HISTORYS = '[ENTITY] Fetch number of PatientCaseHistoryModel records',
	COUNT_PATIENT_CASE_HISTORYS_OK = '[ENTITY] Fetch number of PatientCaseHistoryModel records successfully ',
	COUNT_PATIENT_CASE_HISTORYS_FAIL = '[ENTITY] Fetch number of PatientCaseHistoryModel records failed',

	IMPORT_PATIENT_CASE_HISTORYS = '[ENTITY] Import PatientCaseHistoryModels',
	IMPORT_PATIENT_CASE_HISTORYS_OK = '[ENTITY] Import PatientCaseHistoryModels successfully',
	IMPORT_PATIENT_CASE_HISTORYS_FAIL = '[ENTITY] Import PatientCaseHistoryModels fail',


	INITIALISE_PATIENT_CASE_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientCaseHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientCaseHistoryAction implements Action {
	readonly className: string = 'PatientCaseHistoryModel';

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

export class PatientCaseHistoryAction extends BasePatientCaseHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientCaseHistoryAction here] off begin
	// % protected region % [Add any additional class fields for PatientCaseHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientCaseHistoryModel>,
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for PatientCaseHistoryAction here] off begin
	// % protected region % [Add any additional class methods for PatientCaseHistoryAction here] end
}

export class PatientCaseHistoryActionOK extends BasePatientCaseHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientCaseHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientCaseHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientCaseHistoryModel>,
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientCaseHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientCaseHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientCaseHistoryActionOK here] end
}

export class PatientCaseHistoryActionFail extends BasePatientCaseHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientCaseHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientCaseHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientCaseHistoryModel>,
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientCaseHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientCaseHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientCaseHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientCaseHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientCaseHistoryActionFail here] end
}

export function isPatientCaseHistoryModelAction(e: any): e is BasePatientCaseHistoryAction {
	return Object.values(PatientCaseHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
