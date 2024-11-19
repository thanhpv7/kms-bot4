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
import {BpjsOutsideFacilityReferralModel} from './bpjs_outside_facility_referral.model';
import {BpjsOutsideFacilityReferralModelAudit} from './bpjs_outside_facility_referral.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Outside Facility Referral model actions to be dispatched by NgRx.
 */
export enum BpjsOutsideFacilityReferralModelActionTypes {
	CREATE_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Create BpjsOutsideFacilityReferralModel',
	CREATE_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Create BpjsOutsideFacilityReferralModel successfully',
	CREATE_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Create BpjsOutsideFacilityReferralModel failed',

	CREATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Create All BpjsOutsideFacilityReferralModel',
	CREATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Create All BpjsOutsideFacilityReferralModel successfully',
	CREATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Create All BpjsOutsideFacilityReferralModel failed',

	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Delete BpjsOutsideFacilityReferralModel',
	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Delete BpjsOutsideFacilityReferralModel successfully',
	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Delete BpjsOutsideFacilityReferralModel failed',


	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS = '[ENTITY] Delete BpjsOutsideFacilityReferralModels Excluding Ids',
	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsOutsideFacilityReferralModels Excluding Ids successfully',
	DELETE_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsOutsideFacilityReferralModels Excluding Ids failed',

	DELETE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Delete all BpjsOutsideFacilityReferralModels',
	DELETE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Delete all BpjsOutsideFacilityReferralModels successfully',
	DELETE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Delete all BpjsOutsideFacilityReferralModels failed',

	UPDATE_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Update BpjsOutsideFacilityReferralModel',
	UPDATE_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Update BpjsOutsideFacilityReferralModel successfully',
	UPDATE_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Update BpjsOutsideFacilityReferralModel failed',

	UPDATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Update all BpjsOutsideFacilityReferralModel',
	UPDATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Update all BpjsOutsideFacilityReferralModel successfully',
	UPDATE_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Update all BpjsOutsideFacilityReferralModel failed',

	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL= '[ENTITY] Fetch BpjsOutsideFacilityReferralModel',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel successfully',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel failed',

	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDIT= '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audit',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDIT_OK = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audit successfully',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDIT_FAIL = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audit failed',

	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audits by entity id',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audits by entity id successfully',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel audits by entity id failed',

	FETCH_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Fetch all BpjsOutsideFacilityReferralModel',
	FETCH_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Fetch all BpjsOutsideFacilityReferralModel successfully',
	FETCH_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Fetch all BpjsOutsideFacilityReferralModel failed',

	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel with query',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel with query successfully',
	FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsOutsideFacilityReferralModel with query failed',

	FETCH_LAST_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY = '[ENTITY] Fetch last BpjsOutsideFacilityReferralModel with query',
	FETCH_LAST_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsOutsideFacilityReferralModel with query successfully',
	FETCH_LAST_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsOutsideFacilityReferralModel with query failed',

	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Export BpjsOutsideFacilityReferralModel',
	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Export BpjsOutsideFacilityReferralModel successfully',
	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Export BpjsOutsideFacilityReferralModel failed',

	EXPORT_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL = '[ENTITY] Export All BpjsOutsideFacilityReferralModels',
	EXPORT_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_OK = '[ENTITY] Export All BpjsOutsideFacilityReferralModels successfully',
	EXPORT_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL_FAIL = '[ENTITY] Export All BpjsOutsideFacilityReferralModels failed',

	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS = '[ENTITY] Export BpjsOutsideFacilityReferralModels excluding Ids',
	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsOutsideFacilityReferralModel excluding Ids successfully',
	EXPORT_BPJS_OUTSIDE_FACILITY_REFERRAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsOutsideFacilityReferralModel excluding Ids failed',

	COUNT_BPJS_OUTSIDE_FACILITY_REFERRALS = '[ENTITY] Fetch number of BpjsOutsideFacilityReferralModel records',
	COUNT_BPJS_OUTSIDE_FACILITY_REFERRALS_OK = '[ENTITY] Fetch number of BpjsOutsideFacilityReferralModel records successfully ',
	COUNT_BPJS_OUTSIDE_FACILITY_REFERRALS_FAIL = '[ENTITY] Fetch number of BpjsOutsideFacilityReferralModel records failed',

	IMPORT_BPJS_OUTSIDE_FACILITY_REFERRALS = '[ENTITY] Import BpjsOutsideFacilityReferralModels',
	IMPORT_BPJS_OUTSIDE_FACILITY_REFERRALS_OK = '[ENTITY] Import BpjsOutsideFacilityReferralModels successfully',
	IMPORT_BPJS_OUTSIDE_FACILITY_REFERRALS_FAIL = '[ENTITY] Import BpjsOutsideFacilityReferralModels fail',


	INITIALISE_BPJS_OUTSIDE_FACILITY_REFERRAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsOutsideFacilityReferralModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsOutsideFacilityReferralAction implements Action {
	readonly className: string = 'BpjsOutsideFacilityReferralModel';

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

export class BpjsOutsideFacilityReferralAction extends BaseBpjsOutsideFacilityReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralAction here] off begin
	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsOutsideFacilityReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralAction here] off begin
	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralAction here] end
}

export class BpjsOutsideFacilityReferralActionOK extends BaseBpjsOutsideFacilityReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsOutsideFacilityReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsOutsideFacilityReferralModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralActionOK here] end
}

export class BpjsOutsideFacilityReferralActionFail extends BaseBpjsOutsideFacilityReferralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsOutsideFacilityReferralActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsOutsideFacilityReferralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsOutsideFacilityReferralActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsOutsideFacilityReferralActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsOutsideFacilityReferralActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsOutsideFacilityReferralActionFail here] end
}

export function isBpjsOutsideFacilityReferralModelAction(e: any): e is BaseBpjsOutsideFacilityReferralAction {
	return Object.values(BpjsOutsideFacilityReferralModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
