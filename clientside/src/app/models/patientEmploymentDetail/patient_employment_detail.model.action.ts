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
import {PatientEmploymentDetailModel} from './patient_employment_detail.model';
import {PatientEmploymentDetailModelAudit} from './patient_employment_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Employment Detail  model actions to be dispatched by NgRx.
 */
export enum PatientEmploymentDetailModelActionTypes {
	CREATE_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Create PatientEmploymentDetailModel',
	CREATE_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Create PatientEmploymentDetailModel successfully',
	CREATE_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Create PatientEmploymentDetailModel failed',

	CREATE_ALL_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Create All PatientEmploymentDetailModel',
	CREATE_ALL_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Create All PatientEmploymentDetailModel successfully',
	CREATE_ALL_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Create All PatientEmploymentDetailModel failed',

	DELETE_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Delete PatientEmploymentDetailModel',
	DELETE_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Delete PatientEmploymentDetailModel successfully',
	DELETE_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Delete PatientEmploymentDetailModel failed',


	DELETE_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete PatientEmploymentDetailModels Excluding Ids',
	DELETE_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientEmploymentDetailModels Excluding Ids successfully',
	DELETE_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientEmploymentDetailModels Excluding Ids failed',

	DELETE_ALL_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Delete all PatientEmploymentDetailModels',
	DELETE_ALL_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Delete all PatientEmploymentDetailModels successfully',
	DELETE_ALL_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Delete all PatientEmploymentDetailModels failed',

	UPDATE_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Update PatientEmploymentDetailModel',
	UPDATE_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Update PatientEmploymentDetailModel successfully',
	UPDATE_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Update PatientEmploymentDetailModel failed',

	UPDATE_ALL_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Update all PatientEmploymentDetailModel',
	UPDATE_ALL_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Update all PatientEmploymentDetailModel successfully',
	UPDATE_ALL_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Update all PatientEmploymentDetailModel failed',

	FETCH_PATIENT_EMPLOYMENT_DETAIL= '[ENTITY] Fetch PatientEmploymentDetailModel',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Fetch PatientEmploymentDetailModel successfully',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Fetch PatientEmploymentDetailModel failed',

	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDIT= '[ENTITY] Fetch PatientEmploymentDetailModel audit',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDIT_OK = '[ENTITY] Fetch PatientEmploymentDetailModel audit successfully',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch PatientEmploymentDetailModel audit failed',

	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientEmploymentDetailModel audits by entity id',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientEmploymentDetailModel audits by entity id successfully',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientEmploymentDetailModel audits by entity id failed',

	FETCH_ALL_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Fetch all PatientEmploymentDetailModel',
	FETCH_ALL_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Fetch all PatientEmploymentDetailModel successfully',
	FETCH_ALL_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Fetch all PatientEmploymentDetailModel failed',

	FETCH_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch PatientEmploymentDetailModel with query',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch PatientEmploymentDetailModel with query successfully',
	FETCH_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientEmploymentDetailModel with query failed',

	FETCH_LAST_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last PatientEmploymentDetailModel with query',
	FETCH_LAST_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last PatientEmploymentDetailModel with query successfully',
	FETCH_LAST_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientEmploymentDetailModel with query failed',

	EXPORT_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Export PatientEmploymentDetailModel',
	EXPORT_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Export PatientEmploymentDetailModel successfully',
	EXPORT_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Export PatientEmploymentDetailModel failed',

	EXPORT_ALL_PATIENT_EMPLOYMENT_DETAIL = '[ENTITY] Export All PatientEmploymentDetailModels',
	EXPORT_ALL_PATIENT_EMPLOYMENT_DETAIL_OK = '[ENTITY] Export All PatientEmploymentDetailModels successfully',
	EXPORT_ALL_PATIENT_EMPLOYMENT_DETAIL_FAIL = '[ENTITY] Export All PatientEmploymentDetailModels failed',

	EXPORT_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export PatientEmploymentDetailModels excluding Ids',
	EXPORT_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export PatientEmploymentDetailModel excluding Ids successfully',
	EXPORT_PATIENT_EMPLOYMENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientEmploymentDetailModel excluding Ids failed',

	COUNT_PATIENT_EMPLOYMENT_DETAILS = '[ENTITY] Fetch number of PatientEmploymentDetailModel records',
	COUNT_PATIENT_EMPLOYMENT_DETAILS_OK = '[ENTITY] Fetch number of PatientEmploymentDetailModel records successfully ',
	COUNT_PATIENT_EMPLOYMENT_DETAILS_FAIL = '[ENTITY] Fetch number of PatientEmploymentDetailModel records failed',

	IMPORT_PATIENT_EMPLOYMENT_DETAILS = '[ENTITY] Import PatientEmploymentDetailModels',
	IMPORT_PATIENT_EMPLOYMENT_DETAILS_OK = '[ENTITY] Import PatientEmploymentDetailModels successfully',
	IMPORT_PATIENT_EMPLOYMENT_DETAILS_FAIL = '[ENTITY] Import PatientEmploymentDetailModels fail',


	INITIALISE_PATIENT_EMPLOYMENT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientEmploymentDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientEmploymentDetailAction implements Action {
	readonly className: string = 'PatientEmploymentDetailModel';

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

export class PatientEmploymentDetailAction extends BasePatientEmploymentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmploymentDetailAction here] off begin
	// % protected region % [Add any additional class fields for PatientEmploymentDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientEmploymentDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailAction here] end
	}

	// % protected region % [Add any additional class methods for PatientEmploymentDetailAction here] off begin
	// % protected region % [Add any additional class methods for PatientEmploymentDetailAction here] end
}

export class PatientEmploymentDetailActionOK extends BasePatientEmploymentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmploymentDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientEmploymentDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientEmploymentDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientEmploymentDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientEmploymentDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientEmploymentDetailActionOK here] end
}

export class PatientEmploymentDetailActionFail extends BasePatientEmploymentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmploymentDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientEmploymentDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientEmploymentDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmploymentDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmploymentDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmploymentDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientEmploymentDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientEmploymentDetailActionFail here] end
}

export function isPatientEmploymentDetailModelAction(e: any): e is BasePatientEmploymentDetailAction {
	return Object.values(PatientEmploymentDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
