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
import {PatientVisitPatientPaymentOthersModel} from './patient_visit_patient_payment_others.model';
import {PatientVisitPatientPaymentOthersModelAudit} from './patient_visit_patient_payment_others.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Visit Patient Payment Others model actions to be dispatched by NgRx.
 */
export enum PatientVisitPatientPaymentOthersModelActionTypes {
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Create PatientVisitPatientPaymentOthersModel',
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Create PatientVisitPatientPaymentOthersModel successfully',
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Create PatientVisitPatientPaymentOthersModel failed',

	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Create All PatientVisitPatientPaymentOthersModel',
	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Create All PatientVisitPatientPaymentOthersModel successfully',
	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Create All PatientVisitPatientPaymentOthersModel failed',

	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Delete PatientVisitPatientPaymentOthersModel',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Delete PatientVisitPatientPaymentOthersModel successfully',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Delete PatientVisitPatientPaymentOthersModel failed',


	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS = '[ENTITY] Delete PatientVisitPatientPaymentOthersModels Excluding Ids',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientVisitPatientPaymentOthersModels Excluding Ids successfully',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientVisitPatientPaymentOthersModels Excluding Ids failed',

	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Delete all PatientVisitPatientPaymentOthersModels',
	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Delete all PatientVisitPatientPaymentOthersModels successfully',
	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Delete all PatientVisitPatientPaymentOthersModels failed',

	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Update PatientVisitPatientPaymentOthersModel',
	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Update PatientVisitPatientPaymentOthersModel successfully',
	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Update PatientVisitPatientPaymentOthersModel failed',

	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Update all PatientVisitPatientPaymentOthersModel',
	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Update all PatientVisitPatientPaymentOthersModel successfully',
	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Update all PatientVisitPatientPaymentOthersModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS= '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDIT= '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audit',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDIT_OK = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audit successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDIT_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audit failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audits by entity id',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audits by entity id successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel audits by entity id failed',

	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Fetch all PatientVisitPatientPaymentOthersModel',
	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Fetch all PatientVisitPatientPaymentOthersModel successfully',
	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Fetch all PatientVisitPatientPaymentOthersModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel with query',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY_OK = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel with query successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentOthersModel with query failed',

	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY = '[ENTITY] Fetch last PatientVisitPatientPaymentOthersModel with query',
	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY_OK = '[ENTITY] Fetch last PatientVisitPatientPaymentOthersModel with query successfully',
	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientVisitPatientPaymentOthersModel with query failed',

	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Export PatientVisitPatientPaymentOthersModel',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Export PatientVisitPatientPaymentOthersModel successfully',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Export PatientVisitPatientPaymentOthersModel failed',

	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Export All PatientVisitPatientPaymentOthersModels',
	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Export All PatientVisitPatientPaymentOthersModels successfully',
	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Export All PatientVisitPatientPaymentOthersModels failed',

	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS = '[ENTITY] Export PatientVisitPatientPaymentOthersModels excluding Ids',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_OK = '[ENTITY] Export PatientVisitPatientPaymentOthersModel excluding Ids successfully',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientVisitPatientPaymentOthersModel excluding Ids failed',

	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS = '[ENTITY] Fetch number of PatientVisitPatientPaymentOthersModel records',
	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS_OK = '[ENTITY] Fetch number of PatientVisitPatientPaymentOthersModel records successfully ',
	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS_FAIL = '[ENTITY] Fetch number of PatientVisitPatientPaymentOthersModel records failed',

	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS = '[ENTITY] Import PatientVisitPatientPaymentOthersModels',
	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS_OK = '[ENTITY] Import PatientVisitPatientPaymentOthersModels successfully',
	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_OTHERSS_FAIL = '[ENTITY] Import PatientVisitPatientPaymentOthersModels fail',


	INITIALISE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientVisitPatientPaymentOthersModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientVisitPatientPaymentOthersAction implements Action {
	readonly className: string = 'PatientVisitPatientPaymentOthersModel';

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

export class PatientVisitPatientPaymentOthersAction extends BasePatientVisitPatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersAction here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersAction here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersAction here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersAction here] end
}

export class PatientVisitPatientPaymentOthersActionOK extends BasePatientVisitPatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientVisitPatientPaymentOthersModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersActionOK here] end
}

export class PatientVisitPatientPaymentOthersActionFail extends BasePatientVisitPatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentOthersActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientVisitPatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentOthersActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentOthersActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentOthersActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentOthersActionFail here] end
}

export function isPatientVisitPatientPaymentOthersModelAction(e: any): e is BasePatientVisitPatientPaymentOthersAction {
	return Object.values(PatientVisitPatientPaymentOthersModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
