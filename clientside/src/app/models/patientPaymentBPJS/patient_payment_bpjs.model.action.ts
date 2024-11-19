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
import {PatientPaymentBPJSModel} from './patient_payment_bpjs.model';
import {PatientPaymentBPJSModelAudit} from './patient_payment_bpjs.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Payment BPJS model actions to be dispatched by NgRx.
 */
export enum PatientPaymentBPJSModelActionTypes {
	CREATE_PATIENT_PAYMENT_BPJS = '[ENTITY] Create PatientPaymentBPJSModel',
	CREATE_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Create PatientPaymentBPJSModel successfully',
	CREATE_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Create PatientPaymentBPJSModel failed',

	CREATE_ALL_PATIENT_PAYMENT_BPJS = '[ENTITY] Create All PatientPaymentBPJSModel',
	CREATE_ALL_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Create All PatientPaymentBPJSModel successfully',
	CREATE_ALL_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Create All PatientPaymentBPJSModel failed',

	DELETE_PATIENT_PAYMENT_BPJS = '[ENTITY] Delete PatientPaymentBPJSModel',
	DELETE_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Delete PatientPaymentBPJSModel successfully',
	DELETE_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Delete PatientPaymentBPJSModel failed',


	DELETE_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS = '[ENTITY] Delete PatientPaymentBPJSModels Excluding Ids',
	DELETE_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientPaymentBPJSModels Excluding Ids successfully',
	DELETE_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientPaymentBPJSModels Excluding Ids failed',

	DELETE_ALL_PATIENT_PAYMENT_BPJS = '[ENTITY] Delete all PatientPaymentBPJSModels',
	DELETE_ALL_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Delete all PatientPaymentBPJSModels successfully',
	DELETE_ALL_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Delete all PatientPaymentBPJSModels failed',

	UPDATE_PATIENT_PAYMENT_BPJS = '[ENTITY] Update PatientPaymentBPJSModel',
	UPDATE_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Update PatientPaymentBPJSModel successfully',
	UPDATE_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Update PatientPaymentBPJSModel failed',

	UPDATE_ALL_PATIENT_PAYMENT_BPJS = '[ENTITY] Update all PatientPaymentBPJSModel',
	UPDATE_ALL_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Update all PatientPaymentBPJSModel successfully',
	UPDATE_ALL_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Update all PatientPaymentBPJSModel failed',

	FETCH_PATIENT_PAYMENT_BPJS= '[ENTITY] Fetch PatientPaymentBPJSModel',
	FETCH_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Fetch PatientPaymentBPJSModel successfully',
	FETCH_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Fetch PatientPaymentBPJSModel failed',

	FETCH_PATIENT_PAYMENT_BPJS_AUDIT= '[ENTITY] Fetch PatientPaymentBPJSModel audit',
	FETCH_PATIENT_PAYMENT_BPJS_AUDIT_OK = '[ENTITY] Fetch PatientPaymentBPJSModel audit successfully',
	FETCH_PATIENT_PAYMENT_BPJS_AUDIT_FAIL = '[ENTITY] Fetch PatientPaymentBPJSModel audit failed',

	FETCH_PATIENT_PAYMENT_BPJS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientPaymentBPJSModel audits by entity id',
	FETCH_PATIENT_PAYMENT_BPJS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientPaymentBPJSModel audits by entity id successfully',
	FETCH_PATIENT_PAYMENT_BPJS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientPaymentBPJSModel audits by entity id failed',

	FETCH_ALL_PATIENT_PAYMENT_BPJS = '[ENTITY] Fetch all PatientPaymentBPJSModel',
	FETCH_ALL_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Fetch all PatientPaymentBPJSModel successfully',
	FETCH_ALL_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Fetch all PatientPaymentBPJSModel failed',

	FETCH_PATIENT_PAYMENT_BPJS_WITH_QUERY = '[ENTITY] Fetch PatientPaymentBPJSModel with query',
	FETCH_PATIENT_PAYMENT_BPJS_WITH_QUERY_OK = '[ENTITY] Fetch PatientPaymentBPJSModel with query successfully',
	FETCH_PATIENT_PAYMENT_BPJS_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientPaymentBPJSModel with query failed',

	FETCH_LAST_PATIENT_PAYMENT_BPJS_WITH_QUERY = '[ENTITY] Fetch last PatientPaymentBPJSModel with query',
	FETCH_LAST_PATIENT_PAYMENT_BPJS_WITH_QUERY_OK = '[ENTITY] Fetch last PatientPaymentBPJSModel with query successfully',
	FETCH_LAST_PATIENT_PAYMENT_BPJS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientPaymentBPJSModel with query failed',

	EXPORT_PATIENT_PAYMENT_BPJS = '[ENTITY] Export PatientPaymentBPJSModel',
	EXPORT_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Export PatientPaymentBPJSModel successfully',
	EXPORT_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Export PatientPaymentBPJSModel failed',

	EXPORT_ALL_PATIENT_PAYMENT_BPJS = '[ENTITY] Export All PatientPaymentBPJSModels',
	EXPORT_ALL_PATIENT_PAYMENT_BPJS_OK = '[ENTITY] Export All PatientPaymentBPJSModels successfully',
	EXPORT_ALL_PATIENT_PAYMENT_BPJS_FAIL = '[ENTITY] Export All PatientPaymentBPJSModels failed',

	EXPORT_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS = '[ENTITY] Export PatientPaymentBPJSModels excluding Ids',
	EXPORT_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS_OK = '[ENTITY] Export PatientPaymentBPJSModel excluding Ids successfully',
	EXPORT_PATIENT_PAYMENT_BPJS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientPaymentBPJSModel excluding Ids failed',

	COUNT_PATIENT_PAYMENT_BPJSS = '[ENTITY] Fetch number of PatientPaymentBPJSModel records',
	COUNT_PATIENT_PAYMENT_BPJSS_OK = '[ENTITY] Fetch number of PatientPaymentBPJSModel records successfully ',
	COUNT_PATIENT_PAYMENT_BPJSS_FAIL = '[ENTITY] Fetch number of PatientPaymentBPJSModel records failed',

	IMPORT_PATIENT_PAYMENT_BPJSS = '[ENTITY] Import PatientPaymentBPJSModels',
	IMPORT_PATIENT_PAYMENT_BPJSS_OK = '[ENTITY] Import PatientPaymentBPJSModels successfully',
	IMPORT_PATIENT_PAYMENT_BPJSS_FAIL = '[ENTITY] Import PatientPaymentBPJSModels fail',


	INITIALISE_PATIENT_PAYMENT_BPJS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientPaymentBPJSModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientPaymentBPJSAction implements Action {
	readonly className: string = 'PatientPaymentBPJSModel';

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

export class PatientPaymentBPJSAction extends BasePatientPaymentBPJSAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentBPJSAction here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentBPJSAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentBPJSModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSAction here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentBPJSAction here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentBPJSAction here] end
}

export class PatientPaymentBPJSActionOK extends BasePatientPaymentBPJSAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentBPJSActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentBPJSActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentBPJSModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientPaymentBPJSModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentBPJSActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentBPJSActionOK here] end
}

export class PatientPaymentBPJSActionFail extends BasePatientPaymentBPJSAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentBPJSActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentBPJSActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientPaymentBPJSModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentBPJSActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentBPJSActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentBPJSActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentBPJSActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentBPJSActionFail here] end
}

export function isPatientPaymentBPJSModelAction(e: any): e is BasePatientPaymentBPJSAction {
	return Object.values(PatientPaymentBPJSModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
