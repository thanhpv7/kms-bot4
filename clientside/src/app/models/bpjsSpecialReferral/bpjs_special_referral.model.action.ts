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
import {BpjsSpecialReferralModel} from './bpjs_special_referral.model';
import {BpjsSpecialReferralModelAudit} from './bpjs_special_referral.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Special Referral model actions to be dispatched by NgRx.
 */
export enum BpjsSpecialReferralModelActionTypes {
	CREATE_BPJS_SPECIAL_REFERRAL = '[ENTITY] Create BpjsSpecialReferralModel',
	CREATE_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Create BpjsSpecialReferralModel successfully',
	CREATE_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Create BpjsSpecialReferralModel failed',

	CREATE_ALL_BPJS_SPECIAL_REFERRAL = '[ENTITY] Create All BpjsSpecialReferralModel',
	CREATE_ALL_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Create All BpjsSpecialReferralModel successfully',
	CREATE_ALL_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Create All BpjsSpecialReferralModel failed',

	DELETE_BPJS_SPECIAL_REFERRAL = '[ENTITY] Delete BpjsSpecialReferralModel',
	DELETE_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Delete BpjsSpecialReferralModel successfully',
	DELETE_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Delete BpjsSpecialReferralModel failed',


	DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS = '[ENTITY] Delete BpjsSpecialReferralModels Excluding Ids',
	DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSpecialReferralModels Excluding Ids successfully',
	DELETE_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSpecialReferralModels Excluding Ids failed',

	DELETE_ALL_BPJS_SPECIAL_REFERRAL = '[ENTITY] Delete all BpjsSpecialReferralModels',
	DELETE_ALL_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Delete all BpjsSpecialReferralModels successfully',
	DELETE_ALL_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Delete all BpjsSpecialReferralModels failed',

	UPDATE_BPJS_SPECIAL_REFERRAL = '[ENTITY] Update BpjsSpecialReferralModel',
	UPDATE_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Update BpjsSpecialReferralModel successfully',
	UPDATE_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Update BpjsSpecialReferralModel failed',

	UPDATE_ALL_BPJS_SPECIAL_REFERRAL = '[ENTITY] Update all BpjsSpecialReferralModel',
	UPDATE_ALL_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Update all BpjsSpecialReferralModel successfully',
	UPDATE_ALL_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Update all BpjsSpecialReferralModel failed',

	FETCH_BPJS_SPECIAL_REFERRAL= '[ENTITY] Fetch BpjsSpecialReferralModel',
	FETCH_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Fetch BpjsSpecialReferralModel successfully',
	FETCH_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Fetch BpjsSpecialReferralModel failed',

	FETCH_BPJS_SPECIAL_REFERRAL_AUDIT= '[ENTITY] Fetch BpjsSpecialReferralModel audit',
	FETCH_BPJS_SPECIAL_REFERRAL_AUDIT_OK = '[ENTITY] Fetch BpjsSpecialReferralModel audit successfully',
	FETCH_BPJS_SPECIAL_REFERRAL_AUDIT_FAIL = '[ENTITY] Fetch BpjsSpecialReferralModel audit failed',

	FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSpecialReferralModel audits by entity id',
	FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSpecialReferralModel audits by entity id successfully',
	FETCH_BPJS_SPECIAL_REFERRAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSpecialReferralModel audits by entity id failed',

	FETCH_ALL_BPJS_SPECIAL_REFERRAL = '[ENTITY] Fetch all BpjsSpecialReferralModel',
	FETCH_ALL_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Fetch all BpjsSpecialReferralModel successfully',
	FETCH_ALL_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Fetch all BpjsSpecialReferralModel failed',

	FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY = '[ENTITY] Fetch BpjsSpecialReferralModel with query',
	FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSpecialReferralModel with query successfully',
	FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSpecialReferralModel with query failed',

	FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY = '[ENTITY] Fetch last BpjsSpecialReferralModel with query',
	FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSpecialReferralModel with query successfully',
	FETCH_LAST_BPJS_SPECIAL_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSpecialReferralModel with query failed',

	EXPORT_BPJS_SPECIAL_REFERRAL = '[ENTITY] Export BpjsSpecialReferralModel',
	EXPORT_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Export BpjsSpecialReferralModel successfully',
	EXPORT_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Export BpjsSpecialReferralModel failed',

	EXPORT_ALL_BPJS_SPECIAL_REFERRAL = '[ENTITY] Export All BpjsSpecialReferralModels',
	EXPORT_ALL_BPJS_SPECIAL_REFERRAL_OK = '[ENTITY] Export All BpjsSpecialReferralModels successfully',
	EXPORT_ALL_BPJS_SPECIAL_REFERRAL_FAIL = '[ENTITY] Export All BpjsSpecialReferralModels failed',

	EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS = '[ENTITY] Export BpjsSpecialReferralModels excluding Ids',
	EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSpecialReferralModel excluding Ids successfully',
	EXPORT_BPJS_SPECIAL_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSpecialReferralModel excluding Ids failed',

	COUNT_BPJS_SPECIAL_REFERRALS = '[ENTITY] Fetch number of BpjsSpecialReferralModel records',
	COUNT_BPJS_SPECIAL_REFERRALS_OK = '[ENTITY] Fetch number of BpjsSpecialReferralModel records successfully ',
	COUNT_BPJS_SPECIAL_REFERRALS_FAIL = '[ENTITY] Fetch number of BpjsSpecialReferralModel records failed',

	IMPORT_BPJS_SPECIAL_REFERRALS = '[ENTITY] Import BpjsSpecialReferralModels',
	IMPORT_BPJS_SPECIAL_REFERRALS_OK = '[ENTITY] Import BpjsSpecialReferralModels successfully',
	IMPORT_BPJS_SPECIAL_REFERRALS_FAIL = '[ENTITY] Import BpjsSpecialReferralModels fail',


	INITIALISE_BPJS_SPECIAL_REFERRAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSpecialReferralModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSpecialReferralAction implements Action {
	readonly className: string = 'BpjsSpecialReferralModel';

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

export class BpjsSpecialReferralAction extends BaseBpjsSpecialReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSpecialReferralAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSpecialReferralAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSpecialReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSpecialReferralAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSpecialReferralAction here] end
}

export class BpjsSpecialReferralActionOK extends BaseBpjsSpecialReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSpecialReferralActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSpecialReferralActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSpecialReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSpecialReferralModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSpecialReferralActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSpecialReferralActionOK here] end
}

export class BpjsSpecialReferralActionFail extends BaseBpjsSpecialReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSpecialReferralActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSpecialReferralActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSpecialReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSpecialReferralActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSpecialReferralActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSpecialReferralActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSpecialReferralActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSpecialReferralActionFail here] end
}

export function isBpjsSpecialReferralModelAction(e: any): e is BaseBpjsSpecialReferralAction {
	return Object.values(BpjsSpecialReferralModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
