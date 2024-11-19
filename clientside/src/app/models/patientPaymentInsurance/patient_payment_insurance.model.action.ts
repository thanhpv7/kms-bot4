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
import {PatientPaymentInsuranceModel} from './patient_payment_insurance.model';
import {PatientPaymentInsuranceModelAudit} from './patient_payment_insurance.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Payment Insurance model actions to be dispatched by NgRx.
 */
export enum PatientPaymentInsuranceModelActionTypes {
	CREATE_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Create PatientPaymentInsuranceModel',
	CREATE_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Create PatientPaymentInsuranceModel successfully',
	CREATE_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create PatientPaymentInsuranceModel failed',

	CREATE_ALL_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Create All PatientPaymentInsuranceModel',
	CREATE_ALL_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Create All PatientPaymentInsuranceModel successfully',
	CREATE_ALL_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create All PatientPaymentInsuranceModel failed',

	DELETE_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Delete PatientPaymentInsuranceModel',
	DELETE_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Delete PatientPaymentInsuranceModel successfully',
	DELETE_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete PatientPaymentInsuranceModel failed',


	DELETE_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Delete PatientPaymentInsuranceModels Excluding Ids',
	DELETE_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientPaymentInsuranceModels Excluding Ids successfully',
	DELETE_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientPaymentInsuranceModels Excluding Ids failed',

	DELETE_ALL_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Delete all PatientPaymentInsuranceModels',
	DELETE_ALL_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Delete all PatientPaymentInsuranceModels successfully',
	DELETE_ALL_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete all PatientPaymentInsuranceModels failed',

	UPDATE_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Update PatientPaymentInsuranceModel',
	UPDATE_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Update PatientPaymentInsuranceModel successfully',
	UPDATE_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update PatientPaymentInsuranceModel failed',

	UPDATE_ALL_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Update all PatientPaymentInsuranceModel',
	UPDATE_ALL_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Update all PatientPaymentInsuranceModel successfully',
	UPDATE_ALL_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update all PatientPaymentInsuranceModel failed',

	FETCH_PATIENT_PAYMENT_INSURANCE= '[ENTITY] Fetch PatientPaymentInsuranceModel',
	FETCH_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch PatientPaymentInsuranceModel successfully',
	FETCH_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch PatientPaymentInsuranceModel failed',

	FETCH_PATIENT_PAYMENT_INSURANCE_AUDIT= '[ENTITY] Fetch PatientPaymentInsuranceModel audit',
	FETCH_PATIENT_PAYMENT_INSURANCE_AUDIT_OK = '[ENTITY] Fetch PatientPaymentInsuranceModel audit successfully',
	FETCH_PATIENT_PAYMENT_INSURANCE_AUDIT_FAIL = '[ENTITY] Fetch PatientPaymentInsuranceModel audit failed',

	FETCH_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientPaymentInsuranceModel audits by entity id',
	FETCH_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientPaymentInsuranceModel audits by entity id successfully',
	FETCH_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientPaymentInsuranceModel audits by entity id failed',

	FETCH_ALL_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Fetch all PatientPaymentInsuranceModel',
	FETCH_ALL_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch all PatientPaymentInsuranceModel successfully',
	FETCH_ALL_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch all PatientPaymentInsuranceModel failed',

	FETCH_PATIENT_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch PatientPaymentInsuranceModel with query',
	FETCH_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch PatientPaymentInsuranceModel with query successfully',
	FETCH_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientPaymentInsuranceModel with query failed',

	FETCH_LAST_PATIENT_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch last PatientPaymentInsuranceModel with query',
	FETCH_LAST_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch last PatientPaymentInsuranceModel with query successfully',
	FETCH_LAST_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientPaymentInsuranceModel with query failed',

	EXPORT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Export PatientPaymentInsuranceModel',
	EXPORT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Export PatientPaymentInsuranceModel successfully',
	EXPORT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export PatientPaymentInsuranceModel failed',

	EXPORT_ALL_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Export All PatientPaymentInsuranceModels',
	EXPORT_ALL_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Export All PatientPaymentInsuranceModels successfully',
	EXPORT_ALL_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export All PatientPaymentInsuranceModels failed',

	EXPORT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Export PatientPaymentInsuranceModels excluding Ids',
	EXPORT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Export PatientPaymentInsuranceModel excluding Ids successfully',
	EXPORT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientPaymentInsuranceModel excluding Ids failed',

	COUNT_PATIENT_PAYMENT_INSURANCES = '[ENTITY] Fetch number of PatientPaymentInsuranceModel records',
	COUNT_PATIENT_PAYMENT_INSURANCES_OK = '[ENTITY] Fetch number of PatientPaymentInsuranceModel records successfully ',
	COUNT_PATIENT_PAYMENT_INSURANCES_FAIL = '[ENTITY] Fetch number of PatientPaymentInsuranceModel records failed',

	IMPORT_PATIENT_PAYMENT_INSURANCES = '[ENTITY] Import PatientPaymentInsuranceModels',
	IMPORT_PATIENT_PAYMENT_INSURANCES_OK = '[ENTITY] Import PatientPaymentInsuranceModels successfully',
	IMPORT_PATIENT_PAYMENT_INSURANCES_FAIL = '[ENTITY] Import PatientPaymentInsuranceModels fail',


	INITIALISE_PATIENT_PAYMENT_INSURANCE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientPaymentInsuranceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientPaymentInsuranceAction implements Action {
	readonly className: string = 'PatientPaymentInsuranceModel';

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

export class PatientPaymentInsuranceAction extends BasePatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentInsuranceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceAction here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentInsuranceAction here] end
}

export class PatientPaymentInsuranceActionOK extends BasePatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentInsuranceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientPaymentInsuranceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentInsuranceActionOK here] end
}

export class PatientPaymentInsuranceActionFail extends BasePatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientPaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientPaymentInsuranceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientPaymentInsuranceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientPaymentInsuranceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientPaymentInsuranceActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientPaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientPaymentInsuranceActionFail here] end
}

export function isPatientPaymentInsuranceModelAction(e: any): e is BasePatientPaymentInsuranceAction {
	return Object.values(PatientPaymentInsuranceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
