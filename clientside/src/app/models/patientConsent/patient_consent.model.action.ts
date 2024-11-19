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
import {PatientConsentModel} from './patient_consent.model';
import {PatientConsentModelAudit} from './patient_consent.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Consent model actions to be dispatched by NgRx.
 */
export enum PatientConsentModelActionTypes {
	CREATE_PATIENT_CONSENT = '[ENTITY] Create PatientConsentModel',
	CREATE_PATIENT_CONSENT_OK = '[ENTITY] Create PatientConsentModel successfully',
	CREATE_PATIENT_CONSENT_FAIL = '[ENTITY] Create PatientConsentModel failed',

	CREATE_ALL_PATIENT_CONSENT = '[ENTITY] Create All PatientConsentModel',
	CREATE_ALL_PATIENT_CONSENT_OK = '[ENTITY] Create All PatientConsentModel successfully',
	CREATE_ALL_PATIENT_CONSENT_FAIL = '[ENTITY] Create All PatientConsentModel failed',

	DELETE_PATIENT_CONSENT = '[ENTITY] Delete PatientConsentModel',
	DELETE_PATIENT_CONSENT_OK = '[ENTITY] Delete PatientConsentModel successfully',
	DELETE_PATIENT_CONSENT_FAIL = '[ENTITY] Delete PatientConsentModel failed',


	DELETE_PATIENT_CONSENT_EXCLUDING_IDS = '[ENTITY] Delete PatientConsentModels Excluding Ids',
	DELETE_PATIENT_CONSENT_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientConsentModels Excluding Ids successfully',
	DELETE_PATIENT_CONSENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientConsentModels Excluding Ids failed',

	DELETE_ALL_PATIENT_CONSENT = '[ENTITY] Delete all PatientConsentModels',
	DELETE_ALL_PATIENT_CONSENT_OK = '[ENTITY] Delete all PatientConsentModels successfully',
	DELETE_ALL_PATIENT_CONSENT_FAIL = '[ENTITY] Delete all PatientConsentModels failed',

	UPDATE_PATIENT_CONSENT = '[ENTITY] Update PatientConsentModel',
	UPDATE_PATIENT_CONSENT_OK = '[ENTITY] Update PatientConsentModel successfully',
	UPDATE_PATIENT_CONSENT_FAIL = '[ENTITY] Update PatientConsentModel failed',

	UPDATE_ALL_PATIENT_CONSENT = '[ENTITY] Update all PatientConsentModel',
	UPDATE_ALL_PATIENT_CONSENT_OK = '[ENTITY] Update all PatientConsentModel successfully',
	UPDATE_ALL_PATIENT_CONSENT_FAIL = '[ENTITY] Update all PatientConsentModel failed',

	FETCH_PATIENT_CONSENT= '[ENTITY] Fetch PatientConsentModel',
	FETCH_PATIENT_CONSENT_OK = '[ENTITY] Fetch PatientConsentModel successfully',
	FETCH_PATIENT_CONSENT_FAIL = '[ENTITY] Fetch PatientConsentModel failed',

	FETCH_PATIENT_CONSENT_AUDIT= '[ENTITY] Fetch PatientConsentModel audit',
	FETCH_PATIENT_CONSENT_AUDIT_OK = '[ENTITY] Fetch PatientConsentModel audit successfully',
	FETCH_PATIENT_CONSENT_AUDIT_FAIL = '[ENTITY] Fetch PatientConsentModel audit failed',

	FETCH_PATIENT_CONSENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientConsentModel audits by entity id',
	FETCH_PATIENT_CONSENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientConsentModel audits by entity id successfully',
	FETCH_PATIENT_CONSENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientConsentModel audits by entity id failed',

	FETCH_ALL_PATIENT_CONSENT = '[ENTITY] Fetch all PatientConsentModel',
	FETCH_ALL_PATIENT_CONSENT_OK = '[ENTITY] Fetch all PatientConsentModel successfully',
	FETCH_ALL_PATIENT_CONSENT_FAIL = '[ENTITY] Fetch all PatientConsentModel failed',

	FETCH_PATIENT_CONSENT_WITH_QUERY = '[ENTITY] Fetch PatientConsentModel with query',
	FETCH_PATIENT_CONSENT_WITH_QUERY_OK = '[ENTITY] Fetch PatientConsentModel with query successfully',
	FETCH_PATIENT_CONSENT_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientConsentModel with query failed',

	FETCH_LAST_PATIENT_CONSENT_WITH_QUERY = '[ENTITY] Fetch last PatientConsentModel with query',
	FETCH_LAST_PATIENT_CONSENT_WITH_QUERY_OK = '[ENTITY] Fetch last PatientConsentModel with query successfully',
	FETCH_LAST_PATIENT_CONSENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientConsentModel with query failed',

	EXPORT_PATIENT_CONSENT = '[ENTITY] Export PatientConsentModel',
	EXPORT_PATIENT_CONSENT_OK = '[ENTITY] Export PatientConsentModel successfully',
	EXPORT_PATIENT_CONSENT_FAIL = '[ENTITY] Export PatientConsentModel failed',

	EXPORT_ALL_PATIENT_CONSENT = '[ENTITY] Export All PatientConsentModels',
	EXPORT_ALL_PATIENT_CONSENT_OK = '[ENTITY] Export All PatientConsentModels successfully',
	EXPORT_ALL_PATIENT_CONSENT_FAIL = '[ENTITY] Export All PatientConsentModels failed',

	EXPORT_PATIENT_CONSENT_EXCLUDING_IDS = '[ENTITY] Export PatientConsentModels excluding Ids',
	EXPORT_PATIENT_CONSENT_EXCLUDING_IDS_OK = '[ENTITY] Export PatientConsentModel excluding Ids successfully',
	EXPORT_PATIENT_CONSENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientConsentModel excluding Ids failed',

	COUNT_PATIENT_CONSENTS = '[ENTITY] Fetch number of PatientConsentModel records',
	COUNT_PATIENT_CONSENTS_OK = '[ENTITY] Fetch number of PatientConsentModel records successfully ',
	COUNT_PATIENT_CONSENTS_FAIL = '[ENTITY] Fetch number of PatientConsentModel records failed',

	IMPORT_PATIENT_CONSENTS = '[ENTITY] Import PatientConsentModels',
	IMPORT_PATIENT_CONSENTS_OK = '[ENTITY] Import PatientConsentModels successfully',
	IMPORT_PATIENT_CONSENTS_FAIL = '[ENTITY] Import PatientConsentModels fail',


	INITIALISE_PATIENT_CONSENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientConsentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientConsentAction implements Action {
	readonly className: string = 'PatientConsentModel';

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

export class PatientConsentAction extends BasePatientConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientConsentAction here] off begin
	// % protected region % [Add any additional class fields for PatientConsentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientConsentModel>,
		// % protected region % [Add any additional constructor parameters for PatientConsentAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientConsentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientConsentAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientConsentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientConsentAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientConsentAction here] end
	}

	// % protected region % [Add any additional class methods for PatientConsentAction here] off begin
	// % protected region % [Add any additional class methods for PatientConsentAction here] end
}

export class PatientConsentActionOK extends BasePatientConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientConsentActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientConsentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientConsentModel>,
		// % protected region % [Add any additional constructor parameters for PatientConsentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientConsentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientConsentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientConsentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientConsentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientConsentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientConsentActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientConsentActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientConsentActionOK here] end
}

export class PatientConsentActionFail extends BasePatientConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientConsentActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientConsentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientConsentModel>,
		// % protected region % [Add any additional constructor parameters for PatientConsentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientConsentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientConsentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientConsentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientConsentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientConsentActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientConsentActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientConsentActionFail here] end
}

export function isPatientConsentModelAction(e: any): e is BasePatientConsentAction {
	return Object.values(PatientConsentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
