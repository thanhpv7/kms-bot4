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
import {PatientVitalInformationModel} from './patient_vital_information.model';
import {PatientVitalInformationModelAudit} from './patient_vital_information.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Vital Information model actions to be dispatched by NgRx.
 */
export enum PatientVitalInformationModelActionTypes {
	CREATE_PATIENT_VITAL_INFORMATION = '[ENTITY] Create PatientVitalInformationModel',
	CREATE_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Create PatientVitalInformationModel successfully',
	CREATE_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Create PatientVitalInformationModel failed',

	CREATE_ALL_PATIENT_VITAL_INFORMATION = '[ENTITY] Create All PatientVitalInformationModel',
	CREATE_ALL_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Create All PatientVitalInformationModel successfully',
	CREATE_ALL_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Create All PatientVitalInformationModel failed',

	DELETE_PATIENT_VITAL_INFORMATION = '[ENTITY] Delete PatientVitalInformationModel',
	DELETE_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Delete PatientVitalInformationModel successfully',
	DELETE_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Delete PatientVitalInformationModel failed',


	DELETE_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS = '[ENTITY] Delete PatientVitalInformationModels Excluding Ids',
	DELETE_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientVitalInformationModels Excluding Ids successfully',
	DELETE_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientVitalInformationModels Excluding Ids failed',

	DELETE_ALL_PATIENT_VITAL_INFORMATION = '[ENTITY] Delete all PatientVitalInformationModels',
	DELETE_ALL_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Delete all PatientVitalInformationModels successfully',
	DELETE_ALL_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Delete all PatientVitalInformationModels failed',

	UPDATE_PATIENT_VITAL_INFORMATION = '[ENTITY] Update PatientVitalInformationModel',
	UPDATE_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Update PatientVitalInformationModel successfully',
	UPDATE_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Update PatientVitalInformationModel failed',

	UPDATE_ALL_PATIENT_VITAL_INFORMATION = '[ENTITY] Update all PatientVitalInformationModel',
	UPDATE_ALL_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Update all PatientVitalInformationModel successfully',
	UPDATE_ALL_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Update all PatientVitalInformationModel failed',

	FETCH_PATIENT_VITAL_INFORMATION= '[ENTITY] Fetch PatientVitalInformationModel',
	FETCH_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Fetch PatientVitalInformationModel successfully',
	FETCH_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Fetch PatientVitalInformationModel failed',

	FETCH_PATIENT_VITAL_INFORMATION_AUDIT= '[ENTITY] Fetch PatientVitalInformationModel audit',
	FETCH_PATIENT_VITAL_INFORMATION_AUDIT_OK = '[ENTITY] Fetch PatientVitalInformationModel audit successfully',
	FETCH_PATIENT_VITAL_INFORMATION_AUDIT_FAIL = '[ENTITY] Fetch PatientVitalInformationModel audit failed',

	FETCH_PATIENT_VITAL_INFORMATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientVitalInformationModel audits by entity id',
	FETCH_PATIENT_VITAL_INFORMATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientVitalInformationModel audits by entity id successfully',
	FETCH_PATIENT_VITAL_INFORMATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientVitalInformationModel audits by entity id failed',

	FETCH_ALL_PATIENT_VITAL_INFORMATION = '[ENTITY] Fetch all PatientVitalInformationModel',
	FETCH_ALL_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Fetch all PatientVitalInformationModel successfully',
	FETCH_ALL_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Fetch all PatientVitalInformationModel failed',

	FETCH_PATIENT_VITAL_INFORMATION_WITH_QUERY = '[ENTITY] Fetch PatientVitalInformationModel with query',
	FETCH_PATIENT_VITAL_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch PatientVitalInformationModel with query successfully',
	FETCH_PATIENT_VITAL_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientVitalInformationModel with query failed',

	FETCH_LAST_PATIENT_VITAL_INFORMATION_WITH_QUERY = '[ENTITY] Fetch last PatientVitalInformationModel with query',
	FETCH_LAST_PATIENT_VITAL_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch last PatientVitalInformationModel with query successfully',
	FETCH_LAST_PATIENT_VITAL_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientVitalInformationModel with query failed',

	EXPORT_PATIENT_VITAL_INFORMATION = '[ENTITY] Export PatientVitalInformationModel',
	EXPORT_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Export PatientVitalInformationModel successfully',
	EXPORT_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Export PatientVitalInformationModel failed',

	EXPORT_ALL_PATIENT_VITAL_INFORMATION = '[ENTITY] Export All PatientVitalInformationModels',
	EXPORT_ALL_PATIENT_VITAL_INFORMATION_OK = '[ENTITY] Export All PatientVitalInformationModels successfully',
	EXPORT_ALL_PATIENT_VITAL_INFORMATION_FAIL = '[ENTITY] Export All PatientVitalInformationModels failed',

	EXPORT_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS = '[ENTITY] Export PatientVitalInformationModels excluding Ids',
	EXPORT_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Export PatientVitalInformationModel excluding Ids successfully',
	EXPORT_PATIENT_VITAL_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientVitalInformationModel excluding Ids failed',

	COUNT_PATIENT_VITAL_INFORMATIONS = '[ENTITY] Fetch number of PatientVitalInformationModel records',
	COUNT_PATIENT_VITAL_INFORMATIONS_OK = '[ENTITY] Fetch number of PatientVitalInformationModel records successfully ',
	COUNT_PATIENT_VITAL_INFORMATIONS_FAIL = '[ENTITY] Fetch number of PatientVitalInformationModel records failed',

	IMPORT_PATIENT_VITAL_INFORMATIONS = '[ENTITY] Import PatientVitalInformationModels',
	IMPORT_PATIENT_VITAL_INFORMATIONS_OK = '[ENTITY] Import PatientVitalInformationModels successfully',
	IMPORT_PATIENT_VITAL_INFORMATIONS_FAIL = '[ENTITY] Import PatientVitalInformationModels fail',


	INITIALISE_PATIENT_VITAL_INFORMATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientVitalInformationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientVitalInformationAction implements Action {
	readonly className: string = 'PatientVitalInformationModel';

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

export class PatientVitalInformationAction extends BasePatientVitalInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVitalInformationAction here] off begin
	// % protected region % [Add any additional class fields for PatientVitalInformationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVitalInformationModel>,
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVitalInformationAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientVitalInformationAction here] end
	}

	// % protected region % [Add any additional class methods for PatientVitalInformationAction here] off begin
	// % protected region % [Add any additional class methods for PatientVitalInformationAction here] end
}

export class PatientVitalInformationActionOK extends BasePatientVitalInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVitalInformationActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientVitalInformationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVitalInformationModel>,
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientVitalInformationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVitalInformationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientVitalInformationActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientVitalInformationActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientVitalInformationActionOK here] end
}

export class PatientVitalInformationActionFail extends BasePatientVitalInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVitalInformationActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientVitalInformationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientVitalInformationModel>,
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVitalInformationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVitalInformationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVitalInformationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientVitalInformationActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientVitalInformationActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientVitalInformationActionFail here] end
}

export function isPatientVitalInformationModelAction(e: any): e is BasePatientVitalInformationAction {
	return Object.values(PatientVitalInformationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
