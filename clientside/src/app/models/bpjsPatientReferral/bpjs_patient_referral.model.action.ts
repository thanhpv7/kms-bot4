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
import {BpjsPatientReferralModel} from './bpjs_patient_referral.model';
import {BpjsPatientReferralModelAudit} from './bpjs_patient_referral.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Patient Referral model actions to be dispatched by NgRx.
 */
export enum BpjsPatientReferralModelActionTypes {
	CREATE_BPJS_PATIENT_REFERRAL = '[ENTITY] Create BpjsPatientReferralModel',
	CREATE_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Create BpjsPatientReferralModel successfully',
	CREATE_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Create BpjsPatientReferralModel failed',

	CREATE_ALL_BPJS_PATIENT_REFERRAL = '[ENTITY] Create All BpjsPatientReferralModel',
	CREATE_ALL_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Create All BpjsPatientReferralModel successfully',
	CREATE_ALL_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Create All BpjsPatientReferralModel failed',

	DELETE_BPJS_PATIENT_REFERRAL = '[ENTITY] Delete BpjsPatientReferralModel',
	DELETE_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Delete BpjsPatientReferralModel successfully',
	DELETE_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Delete BpjsPatientReferralModel failed',


	DELETE_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS = '[ENTITY] Delete BpjsPatientReferralModels Excluding Ids',
	DELETE_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPatientReferralModels Excluding Ids successfully',
	DELETE_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPatientReferralModels Excluding Ids failed',

	DELETE_ALL_BPJS_PATIENT_REFERRAL = '[ENTITY] Delete all BpjsPatientReferralModels',
	DELETE_ALL_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Delete all BpjsPatientReferralModels successfully',
	DELETE_ALL_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Delete all BpjsPatientReferralModels failed',

	UPDATE_BPJS_PATIENT_REFERRAL = '[ENTITY] Update BpjsPatientReferralModel',
	UPDATE_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Update BpjsPatientReferralModel successfully',
	UPDATE_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Update BpjsPatientReferralModel failed',

	UPDATE_ALL_BPJS_PATIENT_REFERRAL = '[ENTITY] Update all BpjsPatientReferralModel',
	UPDATE_ALL_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Update all BpjsPatientReferralModel successfully',
	UPDATE_ALL_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Update all BpjsPatientReferralModel failed',

	FETCH_BPJS_PATIENT_REFERRAL= '[ENTITY] Fetch BpjsPatientReferralModel',
	FETCH_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Fetch BpjsPatientReferralModel successfully',
	FETCH_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Fetch BpjsPatientReferralModel failed',

	FETCH_BPJS_PATIENT_REFERRAL_AUDIT= '[ENTITY] Fetch BpjsPatientReferralModel audit',
	FETCH_BPJS_PATIENT_REFERRAL_AUDIT_OK = '[ENTITY] Fetch BpjsPatientReferralModel audit successfully',
	FETCH_BPJS_PATIENT_REFERRAL_AUDIT_FAIL = '[ENTITY] Fetch BpjsPatientReferralModel audit failed',

	FETCH_BPJS_PATIENT_REFERRAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPatientReferralModel audits by entity id',
	FETCH_BPJS_PATIENT_REFERRAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPatientReferralModel audits by entity id successfully',
	FETCH_BPJS_PATIENT_REFERRAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPatientReferralModel audits by entity id failed',

	FETCH_ALL_BPJS_PATIENT_REFERRAL = '[ENTITY] Fetch all BpjsPatientReferralModel',
	FETCH_ALL_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Fetch all BpjsPatientReferralModel successfully',
	FETCH_ALL_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Fetch all BpjsPatientReferralModel failed',

	FETCH_BPJS_PATIENT_REFERRAL_WITH_QUERY = '[ENTITY] Fetch BpjsPatientReferralModel with query',
	FETCH_BPJS_PATIENT_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPatientReferralModel with query successfully',
	FETCH_BPJS_PATIENT_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPatientReferralModel with query failed',

	FETCH_LAST_BPJS_PATIENT_REFERRAL_WITH_QUERY = '[ENTITY] Fetch last BpjsPatientReferralModel with query',
	FETCH_LAST_BPJS_PATIENT_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPatientReferralModel with query successfully',
	FETCH_LAST_BPJS_PATIENT_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPatientReferralModel with query failed',

	EXPORT_BPJS_PATIENT_REFERRAL = '[ENTITY] Export BpjsPatientReferralModel',
	EXPORT_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Export BpjsPatientReferralModel successfully',
	EXPORT_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Export BpjsPatientReferralModel failed',

	EXPORT_ALL_BPJS_PATIENT_REFERRAL = '[ENTITY] Export All BpjsPatientReferralModels',
	EXPORT_ALL_BPJS_PATIENT_REFERRAL_OK = '[ENTITY] Export All BpjsPatientReferralModels successfully',
	EXPORT_ALL_BPJS_PATIENT_REFERRAL_FAIL = '[ENTITY] Export All BpjsPatientReferralModels failed',

	EXPORT_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS = '[ENTITY] Export BpjsPatientReferralModels excluding Ids',
	EXPORT_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPatientReferralModel excluding Ids successfully',
	EXPORT_BPJS_PATIENT_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPatientReferralModel excluding Ids failed',

	COUNT_BPJS_PATIENT_REFERRALS = '[ENTITY] Fetch number of BpjsPatientReferralModel records',
	COUNT_BPJS_PATIENT_REFERRALS_OK = '[ENTITY] Fetch number of BpjsPatientReferralModel records successfully ',
	COUNT_BPJS_PATIENT_REFERRALS_FAIL = '[ENTITY] Fetch number of BpjsPatientReferralModel records failed',

	IMPORT_BPJS_PATIENT_REFERRALS = '[ENTITY] Import BpjsPatientReferralModels',
	IMPORT_BPJS_PATIENT_REFERRALS_OK = '[ENTITY] Import BpjsPatientReferralModels successfully',
	IMPORT_BPJS_PATIENT_REFERRALS_FAIL = '[ENTITY] Import BpjsPatientReferralModels fail',


	INITIALISE_BPJS_PATIENT_REFERRAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPatientReferralModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPatientReferralAction implements Action {
	readonly className: string = 'BpjsPatientReferralModel';

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

export class BpjsPatientReferralAction extends BaseBpjsPatientReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPatientReferralAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPatientReferralAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPatientReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPatientReferralAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPatientReferralAction here] end
}

export class BpjsPatientReferralActionOK extends BaseBpjsPatientReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPatientReferralActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPatientReferralActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPatientReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPatientReferralModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPatientReferralActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPatientReferralActionOK here] end
}

export class BpjsPatientReferralActionFail extends BaseBpjsPatientReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPatientReferralActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPatientReferralActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPatientReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPatientReferralActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPatientReferralActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPatientReferralActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPatientReferralActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPatientReferralActionFail here] end
}

export function isBpjsPatientReferralModelAction(e: any): e is BaseBpjsPatientReferralAction {
	return Object.values(BpjsPatientReferralModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
