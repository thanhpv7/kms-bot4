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
import {PatientDetailModel} from './patient_detail.model';
import {PatientDetailModelAudit} from './patient_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Detail model actions to be dispatched by NgRx.
 */
export enum PatientDetailModelActionTypes {
	CREATE_PATIENT_DETAIL = '[ENTITY] Create PatientDetailModel',
	CREATE_PATIENT_DETAIL_OK = '[ENTITY] Create PatientDetailModel successfully',
	CREATE_PATIENT_DETAIL_FAIL = '[ENTITY] Create PatientDetailModel failed',

	CREATE_ALL_PATIENT_DETAIL = '[ENTITY] Create All PatientDetailModel',
	CREATE_ALL_PATIENT_DETAIL_OK = '[ENTITY] Create All PatientDetailModel successfully',
	CREATE_ALL_PATIENT_DETAIL_FAIL = '[ENTITY] Create All PatientDetailModel failed',

	DELETE_PATIENT_DETAIL = '[ENTITY] Delete PatientDetailModel',
	DELETE_PATIENT_DETAIL_OK = '[ENTITY] Delete PatientDetailModel successfully',
	DELETE_PATIENT_DETAIL_FAIL = '[ENTITY] Delete PatientDetailModel failed',


	DELETE_PATIENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete PatientDetailModels Excluding Ids',
	DELETE_PATIENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientDetailModels Excluding Ids successfully',
	DELETE_PATIENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientDetailModels Excluding Ids failed',

	DELETE_ALL_PATIENT_DETAIL = '[ENTITY] Delete all PatientDetailModels',
	DELETE_ALL_PATIENT_DETAIL_OK = '[ENTITY] Delete all PatientDetailModels successfully',
	DELETE_ALL_PATIENT_DETAIL_FAIL = '[ENTITY] Delete all PatientDetailModels failed',

	UPDATE_PATIENT_DETAIL = '[ENTITY] Update PatientDetailModel',
	UPDATE_PATIENT_DETAIL_OK = '[ENTITY] Update PatientDetailModel successfully',
	UPDATE_PATIENT_DETAIL_FAIL = '[ENTITY] Update PatientDetailModel failed',

	UPDATE_ALL_PATIENT_DETAIL = '[ENTITY] Update all PatientDetailModel',
	UPDATE_ALL_PATIENT_DETAIL_OK = '[ENTITY] Update all PatientDetailModel successfully',
	UPDATE_ALL_PATIENT_DETAIL_FAIL = '[ENTITY] Update all PatientDetailModel failed',

	FETCH_PATIENT_DETAIL= '[ENTITY] Fetch PatientDetailModel',
	FETCH_PATIENT_DETAIL_OK = '[ENTITY] Fetch PatientDetailModel successfully',
	FETCH_PATIENT_DETAIL_FAIL = '[ENTITY] Fetch PatientDetailModel failed',

	FETCH_PATIENT_DETAIL_AUDIT= '[ENTITY] Fetch PatientDetailModel audit',
	FETCH_PATIENT_DETAIL_AUDIT_OK = '[ENTITY] Fetch PatientDetailModel audit successfully',
	FETCH_PATIENT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch PatientDetailModel audit failed',

	FETCH_PATIENT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientDetailModel audits by entity id',
	FETCH_PATIENT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientDetailModel audits by entity id successfully',
	FETCH_PATIENT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientDetailModel audits by entity id failed',

	FETCH_ALL_PATIENT_DETAIL = '[ENTITY] Fetch all PatientDetailModel',
	FETCH_ALL_PATIENT_DETAIL_OK = '[ENTITY] Fetch all PatientDetailModel successfully',
	FETCH_ALL_PATIENT_DETAIL_FAIL = '[ENTITY] Fetch all PatientDetailModel failed',

	FETCH_PATIENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch PatientDetailModel with query',
	FETCH_PATIENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch PatientDetailModel with query successfully',
	FETCH_PATIENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientDetailModel with query failed',

	FETCH_LAST_PATIENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last PatientDetailModel with query',
	FETCH_LAST_PATIENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last PatientDetailModel with query successfully',
	FETCH_LAST_PATIENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientDetailModel with query failed',

	EXPORT_PATIENT_DETAIL = '[ENTITY] Export PatientDetailModel',
	EXPORT_PATIENT_DETAIL_OK = '[ENTITY] Export PatientDetailModel successfully',
	EXPORT_PATIENT_DETAIL_FAIL = '[ENTITY] Export PatientDetailModel failed',

	EXPORT_ALL_PATIENT_DETAIL = '[ENTITY] Export All PatientDetailModels',
	EXPORT_ALL_PATIENT_DETAIL_OK = '[ENTITY] Export All PatientDetailModels successfully',
	EXPORT_ALL_PATIENT_DETAIL_FAIL = '[ENTITY] Export All PatientDetailModels failed',

	EXPORT_PATIENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export PatientDetailModels excluding Ids',
	EXPORT_PATIENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export PatientDetailModel excluding Ids successfully',
	EXPORT_PATIENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientDetailModel excluding Ids failed',

	COUNT_PATIENT_DETAILS = '[ENTITY] Fetch number of PatientDetailModel records',
	COUNT_PATIENT_DETAILS_OK = '[ENTITY] Fetch number of PatientDetailModel records successfully ',
	COUNT_PATIENT_DETAILS_FAIL = '[ENTITY] Fetch number of PatientDetailModel records failed',

	IMPORT_PATIENT_DETAILS = '[ENTITY] Import PatientDetailModels',
	IMPORT_PATIENT_DETAILS_OK = '[ENTITY] Import PatientDetailModels successfully',
	IMPORT_PATIENT_DETAILS_FAIL = '[ENTITY] Import PatientDetailModels fail',


	INITIALISE_PATIENT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientDetailAction implements Action {
	readonly className: string = 'PatientDetailModel';

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

export class PatientDetailAction extends BasePatientDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailAction here] off begin
	// % protected region % [Add any additional class fields for PatientDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailAction here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailAction here] off begin
	// % protected region % [Add any additional class methods for PatientDetailAction here] end
}

export class PatientDetailActionOK extends BasePatientDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientDetailActionOK here] end
}

export class PatientDetailActionFail extends BasePatientDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientDetailActionFail here] end
}

export function isPatientDetailModelAction(e: any): e is BasePatientDetailAction {
	return Object.values(PatientDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
