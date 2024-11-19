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
import {PatientPaymentOthersModel} from './patient_payment_others.model';
import {PatientPaymentOthersModelAudit} from './patient_payment_others.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Payment Others model actions to be dispatched by NgRx.
 */
export enum PatientPaymentOthersModelActionTypes {
	CREATE_PATIENT_PAYMENT_OTHERS = '[ENTITY] Create PatientPaymentOthersModel',
	CREATE_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Create PatientPaymentOthersModel successfully',
	CREATE_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Create PatientPaymentOthersModel failed',

	CREATE_ALL_PATIENT_PAYMENT_OTHERS = '[ENTITY] Create All PatientPaymentOthersModel',
	CREATE_ALL_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Create All PatientPaymentOthersModel successfully',
	CREATE_ALL_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Create All PatientPaymentOthersModel failed',

	DELETE_PATIENT_PAYMENT_OTHERS = '[ENTITY] Delete PatientPaymentOthersModel',
	DELETE_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Delete PatientPaymentOthersModel successfully',
	DELETE_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Delete PatientPaymentOthersModel failed',


	DELETE_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS = '[ENTITY] Delete PatientPaymentOthersModels Excluding Ids',
	DELETE_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientPaymentOthersModels Excluding Ids successfully',
	DELETE_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientPaymentOthersModels Excluding Ids failed',

	DELETE_ALL_PATIENT_PAYMENT_OTHERS = '[ENTITY] Delete all PatientPaymentOthersModels',
	DELETE_ALL_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Delete all PatientPaymentOthersModels successfully',
	DELETE_ALL_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Delete all PatientPaymentOthersModels failed',

	UPDATE_PATIENT_PAYMENT_OTHERS = '[ENTITY] Update PatientPaymentOthersModel',
	UPDATE_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Update PatientPaymentOthersModel successfully',
	UPDATE_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Update PatientPaymentOthersModel failed',

	UPDATE_ALL_PATIENT_PAYMENT_OTHERS = '[ENTITY] Update all PatientPaymentOthersModel',
	UPDATE_ALL_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Update all PatientPaymentOthersModel successfully',
	UPDATE_ALL_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Update all PatientPaymentOthersModel failed',

	FETCH_PATIENT_PAYMENT_OTHERS= '[ENTITY] Fetch PatientPaymentOthersModel',
	FETCH_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Fetch PatientPaymentOthersModel successfully',
	FETCH_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Fetch PatientPaymentOthersModel failed',

	FETCH_PATIENT_PAYMENT_OTHERS_AUDIT= '[ENTITY] Fetch PatientPaymentOthersModel audit',
	FETCH_PATIENT_PAYMENT_OTHERS_AUDIT_OK = '[ENTITY] Fetch PatientPaymentOthersModel audit successfully',
	FETCH_PATIENT_PAYMENT_OTHERS_AUDIT_FAIL = '[ENTITY] Fetch PatientPaymentOthersModel audit failed',

	FETCH_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientPaymentOthersModel audits by entity id',
	FETCH_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientPaymentOthersModel audits by entity id successfully',
	FETCH_PATIENT_PAYMENT_OTHERS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientPaymentOthersModel audits by entity id failed',

	FETCH_ALL_PATIENT_PAYMENT_OTHERS = '[ENTITY] Fetch all PatientPaymentOthersModel',
	FETCH_ALL_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Fetch all PatientPaymentOthersModel successfully',
	FETCH_ALL_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Fetch all PatientPaymentOthersModel failed',

	FETCH_PATIENT_PAYMENT_OTHERS_WITH_QUERY = '[ENTITY] Fetch PatientPaymentOthersModel with query',
	FETCH_PATIENT_PAYMENT_OTHERS_WITH_QUERY_OK = '[ENTITY] Fetch PatientPaymentOthersModel with query successfully',
	FETCH_PATIENT_PAYMENT_OTHERS_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientPaymentOthersModel with query failed',

	FETCH_LAST_PATIENT_PAYMENT_OTHERS_WITH_QUERY = '[ENTITY] Fetch last PatientPaymentOthersModel with query',
	FETCH_LAST_PATIENT_PAYMENT_OTHERS_WITH_QUERY_OK = '[ENTITY] Fetch last PatientPaymentOthersModel with query successfully',
	FETCH_LAST_PATIENT_PAYMENT_OTHERS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientPaymentOthersModel with query failed',

	EXPORT_PATIENT_PAYMENT_OTHERS = '[ENTITY] Export PatientPaymentOthersModel',
	EXPORT_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Export PatientPaymentOthersModel successfully',
	EXPORT_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Export PatientPaymentOthersModel failed',

	EXPORT_ALL_PATIENT_PAYMENT_OTHERS = '[ENTITY] Export All PatientPaymentOthersModels',
	EXPORT_ALL_PATIENT_PAYMENT_OTHERS_OK = '[ENTITY] Export All PatientPaymentOthersModels successfully',
	EXPORT_ALL_PATIENT_PAYMENT_OTHERS_FAIL = '[ENTITY] Export All PatientPaymentOthersModels failed',

	EXPORT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS = '[ENTITY] Export PatientPaymentOthersModels excluding Ids',
	EXPORT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_OK = '[ENTITY] Export PatientPaymentOthersModel excluding Ids successfully',
	EXPORT_PATIENT_PAYMENT_OTHERS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientPaymentOthersModel excluding Ids failed',

	COUNT_PATIENT_PAYMENT_OTHERSS = '[ENTITY] Fetch number of PatientPaymentOthersModel records',
	COUNT_PATIENT_PAYMENT_OTHERSS_OK = '[ENTITY] Fetch number of PatientPaymentOthersModel records successfully ',
	COUNT_PATIENT_PAYMENT_OTHERSS_FAIL = '[ENTITY] Fetch number of PatientPaymentOthersModel records failed',

	IMPORT_PATIENT_PAYMENT_OTHERSS = '[ENTITY] Import PatientPaymentOthersModels',
	IMPORT_PATIENT_PAYMENT_OTHERSS_OK = '[ENTITY] Import PatientPaymentOthersModels successfully',
	IMPORT_PATIENT_PAYMENT_OTHERSS_FAIL = '[ENTITY] Import PatientPaymentOthersModels fail',


	INITIALISE_PATIENT_PAYMENT_OTHERS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientPaymentOthersModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientPaymentOthersAction implements Action {
	readonly className: string = 'PatientPaymentOthersModel';

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

export class PatientPaymentOthersAction extends BasePatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentOthersAction here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentOthersAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersAction here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentOthersAction here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentOthersAction here] end
}

export class PatientPaymentOthersActionOK extends BasePatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentOthersActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentOthersActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientPaymentOthersModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentOthersActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentOthersActionOK here] end
}

export class PatientPaymentOthersActionFail extends BasePatientPaymentOthersAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentOthersActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentOthersActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientPaymentOthersModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentOthersActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentOthersActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentOthersActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentOthersActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentOthersActionFail here] end
}

export function isPatientPaymentOthersModelAction(e: any): e is BasePatientPaymentOthersAction {
	return Object.values(PatientPaymentOthersModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
