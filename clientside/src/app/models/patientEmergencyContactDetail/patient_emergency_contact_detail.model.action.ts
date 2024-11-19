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
import {PatientEmergencyContactDetailModel} from './patient_emergency_contact_detail.model';
import {PatientEmergencyContactDetailModelAudit} from './patient_emergency_contact_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Emergency Contact Detail model actions to be dispatched by NgRx.
 */
export enum PatientEmergencyContactDetailModelActionTypes {
	CREATE_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Create PatientEmergencyContactDetailModel',
	CREATE_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Create PatientEmergencyContactDetailModel successfully',
	CREATE_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Create PatientEmergencyContactDetailModel failed',

	CREATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Create All PatientEmergencyContactDetailModel',
	CREATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Create All PatientEmergencyContactDetailModel successfully',
	CREATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Create All PatientEmergencyContactDetailModel failed',

	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Delete PatientEmergencyContactDetailModel',
	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Delete PatientEmergencyContactDetailModel successfully',
	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Delete PatientEmergencyContactDetailModel failed',


	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete PatientEmergencyContactDetailModels Excluding Ids',
	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientEmergencyContactDetailModels Excluding Ids successfully',
	DELETE_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientEmergencyContactDetailModels Excluding Ids failed',

	DELETE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Delete all PatientEmergencyContactDetailModels',
	DELETE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Delete all PatientEmergencyContactDetailModels successfully',
	DELETE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Delete all PatientEmergencyContactDetailModels failed',

	UPDATE_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Update PatientEmergencyContactDetailModel',
	UPDATE_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Update PatientEmergencyContactDetailModel successfully',
	UPDATE_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Update PatientEmergencyContactDetailModel failed',

	UPDATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Update all PatientEmergencyContactDetailModel',
	UPDATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Update all PatientEmergencyContactDetailModel successfully',
	UPDATE_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Update all PatientEmergencyContactDetailModel failed',

	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL= '[ENTITY] Fetch PatientEmergencyContactDetailModel',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Fetch PatientEmergencyContactDetailModel successfully',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Fetch PatientEmergencyContactDetailModel failed',

	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDIT= '[ENTITY] Fetch PatientEmergencyContactDetailModel audit',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDIT_OK = '[ENTITY] Fetch PatientEmergencyContactDetailModel audit successfully',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch PatientEmergencyContactDetailModel audit failed',

	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientEmergencyContactDetailModel audits by entity id',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientEmergencyContactDetailModel audits by entity id successfully',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientEmergencyContactDetailModel audits by entity id failed',

	FETCH_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Fetch all PatientEmergencyContactDetailModel',
	FETCH_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Fetch all PatientEmergencyContactDetailModel successfully',
	FETCH_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Fetch all PatientEmergencyContactDetailModel failed',

	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY = '[ENTITY] Fetch PatientEmergencyContactDetailModel with query',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch PatientEmergencyContactDetailModel with query successfully',
	FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientEmergencyContactDetailModel with query failed',

	FETCH_LAST_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last PatientEmergencyContactDetailModel with query',
	FETCH_LAST_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last PatientEmergencyContactDetailModel with query successfully',
	FETCH_LAST_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientEmergencyContactDetailModel with query failed',

	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Export PatientEmergencyContactDetailModel',
	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Export PatientEmergencyContactDetailModel successfully',
	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Export PatientEmergencyContactDetailModel failed',

	EXPORT_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL = '[ENTITY] Export All PatientEmergencyContactDetailModels',
	EXPORT_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_OK = '[ENTITY] Export All PatientEmergencyContactDetailModels successfully',
	EXPORT_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL_FAIL = '[ENTITY] Export All PatientEmergencyContactDetailModels failed',

	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export PatientEmergencyContactDetailModels excluding Ids',
	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export PatientEmergencyContactDetailModel excluding Ids successfully',
	EXPORT_PATIENT_EMERGENCY_CONTACT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientEmergencyContactDetailModel excluding Ids failed',

	COUNT_PATIENT_EMERGENCY_CONTACT_DETAILS = '[ENTITY] Fetch number of PatientEmergencyContactDetailModel records',
	COUNT_PATIENT_EMERGENCY_CONTACT_DETAILS_OK = '[ENTITY] Fetch number of PatientEmergencyContactDetailModel records successfully ',
	COUNT_PATIENT_EMERGENCY_CONTACT_DETAILS_FAIL = '[ENTITY] Fetch number of PatientEmergencyContactDetailModel records failed',

	IMPORT_PATIENT_EMERGENCY_CONTACT_DETAILS = '[ENTITY] Import PatientEmergencyContactDetailModels',
	IMPORT_PATIENT_EMERGENCY_CONTACT_DETAILS_OK = '[ENTITY] Import PatientEmergencyContactDetailModels successfully',
	IMPORT_PATIENT_EMERGENCY_CONTACT_DETAILS_FAIL = '[ENTITY] Import PatientEmergencyContactDetailModels fail',


	INITIALISE_PATIENT_EMERGENCY_CONTACT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientEmergencyContactDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientEmergencyContactDetailAction implements Action {
	readonly className: string = 'PatientEmergencyContactDetailModel';

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

export class PatientEmergencyContactDetailAction extends BasePatientEmergencyContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailAction here] off begin
	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientEmergencyContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailAction here] end
	}

	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailAction here] off begin
	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailAction here] end
}

export class PatientEmergencyContactDetailActionOK extends BasePatientEmergencyContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientEmergencyContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientEmergencyContactDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailActionOK here] end
}

export class PatientEmergencyContactDetailActionFail extends BasePatientEmergencyContactDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientEmergencyContactDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientEmergencyContactDetailModel>,
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientEmergencyContactDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientEmergencyContactDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientEmergencyContactDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientEmergencyContactDetailActionFail here] end
}

export function isPatientEmergencyContactDetailModelAction(e: any): e is BasePatientEmergencyContactDetailAction {
	return Object.values(PatientEmergencyContactDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
