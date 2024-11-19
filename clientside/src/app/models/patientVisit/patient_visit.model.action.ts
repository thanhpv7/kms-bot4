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
import {PatientVisitModel} from './patient_visit.model';
import {PatientVisitModelAudit} from './patient_visit.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Visit model actions to be dispatched by NgRx.
 */
export enum PatientVisitModelActionTypes {
	CREATE_PATIENT_VISIT = '[ENTITY] Create PatientVisitModel',
	CREATE_PATIENT_VISIT_OK = '[ENTITY] Create PatientVisitModel successfully',
	CREATE_PATIENT_VISIT_FAIL = '[ENTITY] Create PatientVisitModel failed',

	CREATE_ALL_PATIENT_VISIT = '[ENTITY] Create All PatientVisitModel',
	CREATE_ALL_PATIENT_VISIT_OK = '[ENTITY] Create All PatientVisitModel successfully',
	CREATE_ALL_PATIENT_VISIT_FAIL = '[ENTITY] Create All PatientVisitModel failed',

	DELETE_PATIENT_VISIT = '[ENTITY] Delete PatientVisitModel',
	DELETE_PATIENT_VISIT_OK = '[ENTITY] Delete PatientVisitModel successfully',
	DELETE_PATIENT_VISIT_FAIL = '[ENTITY] Delete PatientVisitModel failed',


	DELETE_PATIENT_VISIT_EXCLUDING_IDS = '[ENTITY] Delete PatientVisitModels Excluding Ids',
	DELETE_PATIENT_VISIT_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientVisitModels Excluding Ids successfully',
	DELETE_PATIENT_VISIT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientVisitModels Excluding Ids failed',

	DELETE_ALL_PATIENT_VISIT = '[ENTITY] Delete all PatientVisitModels',
	DELETE_ALL_PATIENT_VISIT_OK = '[ENTITY] Delete all PatientVisitModels successfully',
	DELETE_ALL_PATIENT_VISIT_FAIL = '[ENTITY] Delete all PatientVisitModels failed',

	UPDATE_PATIENT_VISIT = '[ENTITY] Update PatientVisitModel',
	UPDATE_PATIENT_VISIT_OK = '[ENTITY] Update PatientVisitModel successfully',
	UPDATE_PATIENT_VISIT_FAIL = '[ENTITY] Update PatientVisitModel failed',

	UPDATE_ALL_PATIENT_VISIT = '[ENTITY] Update all PatientVisitModel',
	UPDATE_ALL_PATIENT_VISIT_OK = '[ENTITY] Update all PatientVisitModel successfully',
	UPDATE_ALL_PATIENT_VISIT_FAIL = '[ENTITY] Update all PatientVisitModel failed',

	FETCH_PATIENT_VISIT= '[ENTITY] Fetch PatientVisitModel',
	FETCH_PATIENT_VISIT_OK = '[ENTITY] Fetch PatientVisitModel successfully',
	FETCH_PATIENT_VISIT_FAIL = '[ENTITY] Fetch PatientVisitModel failed',

	FETCH_PATIENT_VISIT_AUDIT= '[ENTITY] Fetch PatientVisitModel audit',
	FETCH_PATIENT_VISIT_AUDIT_OK = '[ENTITY] Fetch PatientVisitModel audit successfully',
	FETCH_PATIENT_VISIT_AUDIT_FAIL = '[ENTITY] Fetch PatientVisitModel audit failed',

	FETCH_PATIENT_VISIT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientVisitModel audits by entity id',
	FETCH_PATIENT_VISIT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientVisitModel audits by entity id successfully',
	FETCH_PATIENT_VISIT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientVisitModel audits by entity id failed',

	FETCH_ALL_PATIENT_VISIT = '[ENTITY] Fetch all PatientVisitModel',
	FETCH_ALL_PATIENT_VISIT_OK = '[ENTITY] Fetch all PatientVisitModel successfully',
	FETCH_ALL_PATIENT_VISIT_FAIL = '[ENTITY] Fetch all PatientVisitModel failed',

	FETCH_PATIENT_VISIT_WITH_QUERY = '[ENTITY] Fetch PatientVisitModel with query',
	FETCH_PATIENT_VISIT_WITH_QUERY_OK = '[ENTITY] Fetch PatientVisitModel with query successfully',
	FETCH_PATIENT_VISIT_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientVisitModel with query failed',

	FETCH_LAST_PATIENT_VISIT_WITH_QUERY = '[ENTITY] Fetch last PatientVisitModel with query',
	FETCH_LAST_PATIENT_VISIT_WITH_QUERY_OK = '[ENTITY] Fetch last PatientVisitModel with query successfully',
	FETCH_LAST_PATIENT_VISIT_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientVisitModel with query failed',

	EXPORT_PATIENT_VISIT = '[ENTITY] Export PatientVisitModel',
	EXPORT_PATIENT_VISIT_OK = '[ENTITY] Export PatientVisitModel successfully',
	EXPORT_PATIENT_VISIT_FAIL = '[ENTITY] Export PatientVisitModel failed',

	EXPORT_ALL_PATIENT_VISIT = '[ENTITY] Export All PatientVisitModels',
	EXPORT_ALL_PATIENT_VISIT_OK = '[ENTITY] Export All PatientVisitModels successfully',
	EXPORT_ALL_PATIENT_VISIT_FAIL = '[ENTITY] Export All PatientVisitModels failed',

	EXPORT_PATIENT_VISIT_EXCLUDING_IDS = '[ENTITY] Export PatientVisitModels excluding Ids',
	EXPORT_PATIENT_VISIT_EXCLUDING_IDS_OK = '[ENTITY] Export PatientVisitModel excluding Ids successfully',
	EXPORT_PATIENT_VISIT_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientVisitModel excluding Ids failed',

	COUNT_PATIENT_VISITS = '[ENTITY] Fetch number of PatientVisitModel records',
	COUNT_PATIENT_VISITS_OK = '[ENTITY] Fetch number of PatientVisitModel records successfully ',
	COUNT_PATIENT_VISITS_FAIL = '[ENTITY] Fetch number of PatientVisitModel records failed',

	IMPORT_PATIENT_VISITS = '[ENTITY] Import PatientVisitModels',
	IMPORT_PATIENT_VISITS_OK = '[ENTITY] Import PatientVisitModels successfully',
	IMPORT_PATIENT_VISITS_FAIL = '[ENTITY] Import PatientVisitModels fail',


	INITIALISE_PATIENT_VISIT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientVisitModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientVisitAction implements Action {
	readonly className: string = 'PatientVisitModel';

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

export class PatientVisitAction extends BasePatientVisitAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitAction here] off begin
	// % protected region % [Add any additional class fields for PatientVisitAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitAction here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitAction here] off begin
	// % protected region % [Add any additional class methods for PatientVisitAction here] end
}

export class PatientVisitActionOK extends BasePatientVisitAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientVisitActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientVisitModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientVisitActionOK here] end
}

export class PatientVisitActionFail extends BasePatientVisitAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientVisitActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientVisitModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientVisitActionFail here] end
}

export function isPatientVisitModelAction(e: any): e is BasePatientVisitAction {
	return Object.values(PatientVisitModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
