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
import {PatientVisitPatientPaymentInsuranceModel} from './patient_visit_patient_payment_insurance.model';
import {PatientVisitPatientPaymentInsuranceModelAudit} from './patient_visit_patient_payment_insurance.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Visit Patient Payment Insurance model actions to be dispatched by NgRx.
 */
export enum PatientVisitPatientPaymentInsuranceModelActionTypes {
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Create PatientVisitPatientPaymentInsuranceModel',
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Create PatientVisitPatientPaymentInsuranceModel successfully',
	CREATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create PatientVisitPatientPaymentInsuranceModel failed',

	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Create All PatientVisitPatientPaymentInsuranceModel',
	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Create All PatientVisitPatientPaymentInsuranceModel successfully',
	CREATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create All PatientVisitPatientPaymentInsuranceModel failed',

	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModel',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModel successfully',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModel failed',


	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModels Excluding Ids',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModels Excluding Ids successfully',
	DELETE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientVisitPatientPaymentInsuranceModels Excluding Ids failed',

	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Delete all PatientVisitPatientPaymentInsuranceModels',
	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Delete all PatientVisitPatientPaymentInsuranceModels successfully',
	DELETE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete all PatientVisitPatientPaymentInsuranceModels failed',

	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Update PatientVisitPatientPaymentInsuranceModel',
	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Update PatientVisitPatientPaymentInsuranceModel successfully',
	UPDATE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update PatientVisitPatientPaymentInsuranceModel failed',

	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Update all PatientVisitPatientPaymentInsuranceModel',
	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Update all PatientVisitPatientPaymentInsuranceModel successfully',
	UPDATE_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update all PatientVisitPatientPaymentInsuranceModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE= '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDIT= '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audit',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDIT_OK = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audit successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDIT_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audit failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audits by entity id',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audits by entity id successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel audits by entity id failed',

	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Fetch all PatientVisitPatientPaymentInsuranceModel',
	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch all PatientVisitPatientPaymentInsuranceModel successfully',
	FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch all PatientVisitPatientPaymentInsuranceModel failed',

	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel with query',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel with query successfully',
	FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientVisitPatientPaymentInsuranceModel with query failed',

	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch last PatientVisitPatientPaymentInsuranceModel with query',
	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch last PatientVisitPatientPaymentInsuranceModel with query successfully',
	FETCH_LAST_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientVisitPatientPaymentInsuranceModel with query failed',

	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModel',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModel successfully',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModel failed',

	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE = '[ENTITY] Export All PatientVisitPatientPaymentInsuranceModels',
	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_OK = '[ENTITY] Export All PatientVisitPatientPaymentInsuranceModels successfully',
	EXPORT_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export All PatientVisitPatientPaymentInsuranceModels failed',

	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModels excluding Ids',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModel excluding Ids successfully',
	EXPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientVisitPatientPaymentInsuranceModel excluding Ids failed',

	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES = '[ENTITY] Fetch number of PatientVisitPatientPaymentInsuranceModel records',
	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_OK = '[ENTITY] Fetch number of PatientVisitPatientPaymentInsuranceModel records successfully ',
	COUNT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_FAIL = '[ENTITY] Fetch number of PatientVisitPatientPaymentInsuranceModel records failed',

	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES = '[ENTITY] Import PatientVisitPatientPaymentInsuranceModels',
	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_OK = '[ENTITY] Import PatientVisitPatientPaymentInsuranceModels successfully',
	IMPORT_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCES_FAIL = '[ENTITY] Import PatientVisitPatientPaymentInsuranceModels fail',


	INITIALISE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientVisitPatientPaymentInsuranceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientVisitPatientPaymentInsuranceAction implements Action {
	readonly className: string = 'PatientVisitPatientPaymentInsuranceModel';

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

export class PatientVisitPatientPaymentInsuranceAction extends BasePatientVisitPatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceAction here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceAction here] end
}

export class PatientVisitPatientPaymentInsuranceActionOK extends BasePatientVisitPatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientVisitPatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientVisitPatientPaymentInsuranceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceActionOK here] end
}

export class PatientVisitPatientPaymentInsuranceActionFail extends BasePatientVisitPatientPaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientVisitPatientPaymentInsuranceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientVisitPatientPaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientVisitPatientPaymentInsuranceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientVisitPatientPaymentInsuranceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientVisitPatientPaymentInsuranceActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientVisitPatientPaymentInsuranceActionFail here] end
}

export function isPatientVisitPatientPaymentInsuranceModelAction(e: any): e is BasePatientVisitPatientPaymentInsuranceAction {
	return Object.values(PatientVisitPatientPaymentInsuranceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
