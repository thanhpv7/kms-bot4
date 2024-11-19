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
import {PatientVisitPaymentSelfPayingModel} from './patient_visit_payment_self_paying.model';
import {PatientVisitPaymentSelfPayingModelAudit} from './patient_visit_payment_self_paying.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Visit Payment Self Paying model actions to be dispatched by NgRx.
 */
export enum PatientVisitPaymentSelfPayingModelActionTypes {
	CREATE_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Create PatientVisitPaymentSelfPayingModel',
	CREATE_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create PatientVisitPaymentSelfPayingModel successfully',
	CREATE_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create PatientVisitPaymentSelfPayingModel failed',

	CREATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Create All PatientVisitPaymentSelfPayingModel',
	CREATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create All PatientVisitPaymentSelfPayingModel successfully',
	CREATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create All PatientVisitPaymentSelfPayingModel failed',

	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Delete PatientVisitPaymentSelfPayingModel',
	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete PatientVisitPaymentSelfPayingModel successfully',
	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete PatientVisitPaymentSelfPayingModel failed',


	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Delete PatientVisitPaymentSelfPayingModels Excluding Ids',
	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientVisitPaymentSelfPayingModels Excluding Ids successfully',
	DELETE_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientVisitPaymentSelfPayingModels Excluding Ids failed',

	DELETE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Delete all PatientVisitPaymentSelfPayingModels',
	DELETE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete all PatientVisitPaymentSelfPayingModels successfully',
	DELETE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete all PatientVisitPaymentSelfPayingModels failed',

	UPDATE_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Update PatientVisitPaymentSelfPayingModel',
	UPDATE_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update PatientVisitPaymentSelfPayingModel successfully',
	UPDATE_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update PatientVisitPaymentSelfPayingModel failed',

	UPDATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Update all PatientVisitPaymentSelfPayingModel',
	UPDATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update all PatientVisitPaymentSelfPayingModel successfully',
	UPDATE_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update all PatientVisitPaymentSelfPayingModel failed',

	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING= '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel successfully',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel failed',

	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDIT= '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audit',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDIT_OK = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audit successfully',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDIT_FAIL = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audit failed',

	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audits by entity id',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audits by entity id successfully',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel audits by entity id failed',

	FETCH_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Fetch all PatientVisitPaymentSelfPayingModel',
	FETCH_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch all PatientVisitPaymentSelfPayingModel successfully',
	FETCH_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch all PatientVisitPaymentSelfPayingModel failed',

	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel with query',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel with query successfully',
	FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientVisitPaymentSelfPayingModel with query failed',

	FETCH_LAST_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch last PatientVisitPaymentSelfPayingModel with query',
	FETCH_LAST_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch last PatientVisitPaymentSelfPayingModel with query successfully',
	FETCH_LAST_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientVisitPaymentSelfPayingModel with query failed',

	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Export PatientVisitPaymentSelfPayingModel',
	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export PatientVisitPaymentSelfPayingModel successfully',
	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export PatientVisitPaymentSelfPayingModel failed',

	EXPORT_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING = '[ENTITY] Export All PatientVisitPaymentSelfPayingModels',
	EXPORT_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export All PatientVisitPaymentSelfPayingModels successfully',
	EXPORT_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export All PatientVisitPaymentSelfPayingModels failed',

	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Export PatientVisitPaymentSelfPayingModels excluding Ids',
	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Export PatientVisitPaymentSelfPayingModel excluding Ids successfully',
	EXPORT_PATIENT_VISIT_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientVisitPaymentSelfPayingModel excluding Ids failed',

	COUNT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS = '[ENTITY] Fetch number of PatientVisitPaymentSelfPayingModel records',
	COUNT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Fetch number of PatientVisitPaymentSelfPayingModel records successfully ',
	COUNT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Fetch number of PatientVisitPaymentSelfPayingModel records failed',

	IMPORT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS = '[ENTITY] Import PatientVisitPaymentSelfPayingModels',
	IMPORT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Import PatientVisitPaymentSelfPayingModels successfully',
	IMPORT_PATIENT_VISIT_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Import PatientVisitPaymentSelfPayingModels fail',


	INITIALISE_PATIENT_VISIT_PAYMENT_SELF_PAYING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientVisitPaymentSelfPayingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientVisitPaymentSelfPayingAction implements Action {
	readonly className: string = 'PatientVisitPaymentSelfPayingModel';

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

export class PatientVisitPaymentSelfPayingAction extends BasePatientVisitPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingAction here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingAction here] end
}

export class PatientVisitPaymentSelfPayingActionOK extends BasePatientVisitPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientVisitPaymentSelfPayingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingActionOK here] end
}

export class PatientVisitPaymentSelfPayingActionFail extends BasePatientVisitPaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPaymentSelfPayingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientVisitPaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPaymentSelfPayingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPaymentSelfPayingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPaymentSelfPayingActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPaymentSelfPayingActionFail here] end
}

export function isPatientVisitPaymentSelfPayingModelAction(e: any): e is BasePatientVisitPaymentSelfPayingAction {
	return Object.values(PatientVisitPaymentSelfPayingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
