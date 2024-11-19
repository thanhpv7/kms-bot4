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
import {PatientContactInfoModel} from './patient_contact_info.model';
import {PatientContactInfoModelAudit} from './patient_contact_info.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Contact Info model actions to be dispatched by NgRx.
 */
export enum PatientContactInfoModelActionTypes {
	CREATE_PATIENT_CONTACT_INFO = '[ENTITY] Create PatientContactInfoModel',
	CREATE_PATIENT_CONTACT_INFO_OK = '[ENTITY] Create PatientContactInfoModel successfully',
	CREATE_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Create PatientContactInfoModel failed',

	CREATE_ALL_PATIENT_CONTACT_INFO = '[ENTITY] Create All PatientContactInfoModel',
	CREATE_ALL_PATIENT_CONTACT_INFO_OK = '[ENTITY] Create All PatientContactInfoModel successfully',
	CREATE_ALL_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Create All PatientContactInfoModel failed',

	DELETE_PATIENT_CONTACT_INFO = '[ENTITY] Delete PatientContactInfoModel',
	DELETE_PATIENT_CONTACT_INFO_OK = '[ENTITY] Delete PatientContactInfoModel successfully',
	DELETE_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Delete PatientContactInfoModel failed',


	DELETE_PATIENT_CONTACT_INFO_EXCLUDING_IDS = '[ENTITY] Delete PatientContactInfoModels Excluding Ids',
	DELETE_PATIENT_CONTACT_INFO_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientContactInfoModels Excluding Ids successfully',
	DELETE_PATIENT_CONTACT_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientContactInfoModels Excluding Ids failed',

	DELETE_ALL_PATIENT_CONTACT_INFO = '[ENTITY] Delete all PatientContactInfoModels',
	DELETE_ALL_PATIENT_CONTACT_INFO_OK = '[ENTITY] Delete all PatientContactInfoModels successfully',
	DELETE_ALL_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Delete all PatientContactInfoModels failed',

	UPDATE_PATIENT_CONTACT_INFO = '[ENTITY] Update PatientContactInfoModel',
	UPDATE_PATIENT_CONTACT_INFO_OK = '[ENTITY] Update PatientContactInfoModel successfully',
	UPDATE_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Update PatientContactInfoModel failed',

	UPDATE_ALL_PATIENT_CONTACT_INFO = '[ENTITY] Update all PatientContactInfoModel',
	UPDATE_ALL_PATIENT_CONTACT_INFO_OK = '[ENTITY] Update all PatientContactInfoModel successfully',
	UPDATE_ALL_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Update all PatientContactInfoModel failed',

	FETCH_PATIENT_CONTACT_INFO= '[ENTITY] Fetch PatientContactInfoModel',
	FETCH_PATIENT_CONTACT_INFO_OK = '[ENTITY] Fetch PatientContactInfoModel successfully',
	FETCH_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Fetch PatientContactInfoModel failed',

	FETCH_PATIENT_CONTACT_INFO_AUDIT= '[ENTITY] Fetch PatientContactInfoModel audit',
	FETCH_PATIENT_CONTACT_INFO_AUDIT_OK = '[ENTITY] Fetch PatientContactInfoModel audit successfully',
	FETCH_PATIENT_CONTACT_INFO_AUDIT_FAIL = '[ENTITY] Fetch PatientContactInfoModel audit failed',

	FETCH_PATIENT_CONTACT_INFO_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientContactInfoModel audits by entity id',
	FETCH_PATIENT_CONTACT_INFO_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientContactInfoModel audits by entity id successfully',
	FETCH_PATIENT_CONTACT_INFO_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientContactInfoModel audits by entity id failed',

	FETCH_ALL_PATIENT_CONTACT_INFO = '[ENTITY] Fetch all PatientContactInfoModel',
	FETCH_ALL_PATIENT_CONTACT_INFO_OK = '[ENTITY] Fetch all PatientContactInfoModel successfully',
	FETCH_ALL_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Fetch all PatientContactInfoModel failed',

	FETCH_PATIENT_CONTACT_INFO_WITH_QUERY = '[ENTITY] Fetch PatientContactInfoModel with query',
	FETCH_PATIENT_CONTACT_INFO_WITH_QUERY_OK = '[ENTITY] Fetch PatientContactInfoModel with query successfully',
	FETCH_PATIENT_CONTACT_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientContactInfoModel with query failed',

	FETCH_LAST_PATIENT_CONTACT_INFO_WITH_QUERY = '[ENTITY] Fetch last PatientContactInfoModel with query',
	FETCH_LAST_PATIENT_CONTACT_INFO_WITH_QUERY_OK = '[ENTITY] Fetch last PatientContactInfoModel with query successfully',
	FETCH_LAST_PATIENT_CONTACT_INFO_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientContactInfoModel with query failed',

	EXPORT_PATIENT_CONTACT_INFO = '[ENTITY] Export PatientContactInfoModel',
	EXPORT_PATIENT_CONTACT_INFO_OK = '[ENTITY] Export PatientContactInfoModel successfully',
	EXPORT_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Export PatientContactInfoModel failed',

	EXPORT_ALL_PATIENT_CONTACT_INFO = '[ENTITY] Export All PatientContactInfoModels',
	EXPORT_ALL_PATIENT_CONTACT_INFO_OK = '[ENTITY] Export All PatientContactInfoModels successfully',
	EXPORT_ALL_PATIENT_CONTACT_INFO_FAIL = '[ENTITY] Export All PatientContactInfoModels failed',

	EXPORT_PATIENT_CONTACT_INFO_EXCLUDING_IDS = '[ENTITY] Export PatientContactInfoModels excluding Ids',
	EXPORT_PATIENT_CONTACT_INFO_EXCLUDING_IDS_OK = '[ENTITY] Export PatientContactInfoModel excluding Ids successfully',
	EXPORT_PATIENT_CONTACT_INFO_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientContactInfoModel excluding Ids failed',

	COUNT_PATIENT_CONTACT_INFOS = '[ENTITY] Fetch number of PatientContactInfoModel records',
	COUNT_PATIENT_CONTACT_INFOS_OK = '[ENTITY] Fetch number of PatientContactInfoModel records successfully ',
	COUNT_PATIENT_CONTACT_INFOS_FAIL = '[ENTITY] Fetch number of PatientContactInfoModel records failed',

	IMPORT_PATIENT_CONTACT_INFOS = '[ENTITY] Import PatientContactInfoModels',
	IMPORT_PATIENT_CONTACT_INFOS_OK = '[ENTITY] Import PatientContactInfoModels successfully',
	IMPORT_PATIENT_CONTACT_INFOS_FAIL = '[ENTITY] Import PatientContactInfoModels fail',


	INITIALISE_PATIENT_CONTACT_INFO_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientContactInfoModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientContactInfoAction implements Action {
	readonly className: string = 'PatientContactInfoModel';

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

export class PatientContactInfoAction extends BasePatientContactInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientContactInfoAction here] off begin
	// % protected region % [Add any additional class fields for PatientContactInfoAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientContactInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientContactInfoAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientContactInfoAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientContactInfoAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientContactInfoAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientContactInfoAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientContactInfoAction here] end
	}

	// % protected region % [Add any additional class methods for PatientContactInfoAction here] off begin
	// % protected region % [Add any additional class methods for PatientContactInfoAction here] end
}

export class PatientContactInfoActionOK extends BasePatientContactInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientContactInfoActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientContactInfoActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientContactInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientContactInfoActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientContactInfoActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientContactInfoModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientContactInfoActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientContactInfoActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientContactInfoActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientContactInfoActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientContactInfoActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientContactInfoActionOK here] end
}

export class PatientContactInfoActionFail extends BasePatientContactInfoAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientContactInfoActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientContactInfoActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientContactInfoModel>,
		// % protected region % [Add any additional constructor parameters for PatientContactInfoActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientContactInfoActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientContactInfoActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientContactInfoActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientContactInfoActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientContactInfoActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientContactInfoActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientContactInfoActionFail here] end
}

export function isPatientContactInfoModelAction(e: any): e is BasePatientContactInfoAction {
	return Object.values(PatientContactInfoModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
