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
import {PatientPaymentSelfPayingModel} from './patient_payment_self_paying.model';
import {PatientPaymentSelfPayingModelAudit} from './patient_payment_self_paying.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Payment  Self Paying model actions to be dispatched by NgRx.
 */
export enum PatientPaymentSelfPayingModelActionTypes {
	CREATE_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Create PatientPaymentSelfPayingModel',
	CREATE_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create PatientPaymentSelfPayingModel successfully',
	CREATE_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create PatientPaymentSelfPayingModel failed',

	CREATE_ALL_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Create All PatientPaymentSelfPayingModel',
	CREATE_ALL_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create All PatientPaymentSelfPayingModel successfully',
	CREATE_ALL_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create All PatientPaymentSelfPayingModel failed',

	DELETE_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Delete PatientPaymentSelfPayingModel',
	DELETE_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete PatientPaymentSelfPayingModel successfully',
	DELETE_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete PatientPaymentSelfPayingModel failed',


	DELETE_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Delete PatientPaymentSelfPayingModels Excluding Ids',
	DELETE_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientPaymentSelfPayingModels Excluding Ids successfully',
	DELETE_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientPaymentSelfPayingModels Excluding Ids failed',

	DELETE_ALL_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Delete all PatientPaymentSelfPayingModels',
	DELETE_ALL_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete all PatientPaymentSelfPayingModels successfully',
	DELETE_ALL_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete all PatientPaymentSelfPayingModels failed',

	UPDATE_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Update PatientPaymentSelfPayingModel',
	UPDATE_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update PatientPaymentSelfPayingModel successfully',
	UPDATE_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update PatientPaymentSelfPayingModel failed',

	UPDATE_ALL_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Update all PatientPaymentSelfPayingModel',
	UPDATE_ALL_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update all PatientPaymentSelfPayingModel successfully',
	UPDATE_ALL_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update all PatientPaymentSelfPayingModel failed',

	FETCH_PATIENT_PAYMENT_SELF_PAYING= '[ENTITY] Fetch PatientPaymentSelfPayingModel',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch PatientPaymentSelfPayingModel successfully',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch PatientPaymentSelfPayingModel failed',

	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDIT= '[ENTITY] Fetch PatientPaymentSelfPayingModel audit',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDIT_OK = '[ENTITY] Fetch PatientPaymentSelfPayingModel audit successfully',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDIT_FAIL = '[ENTITY] Fetch PatientPaymentSelfPayingModel audit failed',

	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientPaymentSelfPayingModel audits by entity id',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientPaymentSelfPayingModel audits by entity id successfully',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientPaymentSelfPayingModel audits by entity id failed',

	FETCH_ALL_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Fetch all PatientPaymentSelfPayingModel',
	FETCH_ALL_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch all PatientPaymentSelfPayingModel successfully',
	FETCH_ALL_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch all PatientPaymentSelfPayingModel failed',

	FETCH_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch PatientPaymentSelfPayingModel with query',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch PatientPaymentSelfPayingModel with query successfully',
	FETCH_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientPaymentSelfPayingModel with query failed',

	FETCH_LAST_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch last PatientPaymentSelfPayingModel with query',
	FETCH_LAST_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch last PatientPaymentSelfPayingModel with query successfully',
	FETCH_LAST_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientPaymentSelfPayingModel with query failed',

	EXPORT_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Export PatientPaymentSelfPayingModel',
	EXPORT_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export PatientPaymentSelfPayingModel successfully',
	EXPORT_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export PatientPaymentSelfPayingModel failed',

	EXPORT_ALL_PATIENT_PAYMENT_SELF_PAYING = '[ENTITY] Export All PatientPaymentSelfPayingModels',
	EXPORT_ALL_PATIENT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export All PatientPaymentSelfPayingModels successfully',
	EXPORT_ALL_PATIENT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export All PatientPaymentSelfPayingModels failed',

	EXPORT_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Export PatientPaymentSelfPayingModels excluding Ids',
	EXPORT_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Export PatientPaymentSelfPayingModel excluding Ids successfully',
	EXPORT_PATIENT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientPaymentSelfPayingModel excluding Ids failed',

	COUNT_PATIENT_PAYMENT_SELF_PAYINGS = '[ENTITY] Fetch number of PatientPaymentSelfPayingModel records',
	COUNT_PATIENT_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Fetch number of PatientPaymentSelfPayingModel records successfully ',
	COUNT_PATIENT_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Fetch number of PatientPaymentSelfPayingModel records failed',

	IMPORT_PATIENT_PAYMENT_SELF_PAYINGS = '[ENTITY] Import PatientPaymentSelfPayingModels',
	IMPORT_PATIENT_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Import PatientPaymentSelfPayingModels successfully',
	IMPORT_PATIENT_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Import PatientPaymentSelfPayingModels fail',


	INITIALISE_PATIENT_PAYMENT_SELF_PAYING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientPaymentSelfPayingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientPaymentSelfPayingAction implements Action {
	readonly className: string = 'PatientPaymentSelfPayingModel';

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

export class PatientPaymentSelfPayingAction extends BasePatientPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingAction here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingAction here] end
}

export class PatientPaymentSelfPayingActionOK extends BasePatientPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientPaymentSelfPayingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingActionOK here] end
}

export class PatientPaymentSelfPayingActionFail extends BasePatientPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentSelfPayingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentSelfPayingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentSelfPayingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentSelfPayingActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentSelfPayingActionFail here] end
}

export function isPatientPaymentSelfPayingModelAction(e: any): e is BasePatientPaymentSelfPayingAction {
	return Object.values(PatientPaymentSelfPayingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
