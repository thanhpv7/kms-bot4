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
import {BpjsTotalReferralSEPModel} from './bpjs_total_referral_sep.model';
import {BpjsTotalReferralSEPModelAudit} from './bpjs_total_referral_sep.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Total Referral SEP model actions to be dispatched by NgRx.
 */
export enum BpjsTotalReferralSEPModelActionTypes {
	CREATE_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Create BpjsTotalReferralSEPModel',
	CREATE_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Create BpjsTotalReferralSEPModel successfully',
	CREATE_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Create BpjsTotalReferralSEPModel failed',

	CREATE_ALL_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Create All BpjsTotalReferralSEPModel',
	CREATE_ALL_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Create All BpjsTotalReferralSEPModel successfully',
	CREATE_ALL_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Create All BpjsTotalReferralSEPModel failed',

	DELETE_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Delete BpjsTotalReferralSEPModel',
	DELETE_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Delete BpjsTotalReferralSEPModel successfully',
	DELETE_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Delete BpjsTotalReferralSEPModel failed',


	DELETE_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS = '[ENTITY] Delete BpjsTotalReferralSEPModels Excluding Ids',
	DELETE_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsTotalReferralSEPModels Excluding Ids successfully',
	DELETE_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsTotalReferralSEPModels Excluding Ids failed',

	DELETE_ALL_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Delete all BpjsTotalReferralSEPModels',
	DELETE_ALL_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Delete all BpjsTotalReferralSEPModels successfully',
	DELETE_ALL_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Delete all BpjsTotalReferralSEPModels failed',

	UPDATE_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Update BpjsTotalReferralSEPModel',
	UPDATE_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Update BpjsTotalReferralSEPModel successfully',
	UPDATE_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Update BpjsTotalReferralSEPModel failed',

	UPDATE_ALL_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Update all BpjsTotalReferralSEPModel',
	UPDATE_ALL_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Update all BpjsTotalReferralSEPModel successfully',
	UPDATE_ALL_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Update all BpjsTotalReferralSEPModel failed',

	FETCH_BPJS_TOTAL_REFERRAL_SEP= '[ENTITY] Fetch BpjsTotalReferralSEPModel',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Fetch BpjsTotalReferralSEPModel successfully',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Fetch BpjsTotalReferralSEPModel failed',

	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDIT= '[ENTITY] Fetch BpjsTotalReferralSEPModel audit',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDIT_OK = '[ENTITY] Fetch BpjsTotalReferralSEPModel audit successfully',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDIT_FAIL = '[ENTITY] Fetch BpjsTotalReferralSEPModel audit failed',

	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsTotalReferralSEPModel audits by entity id',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsTotalReferralSEPModel audits by entity id successfully',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsTotalReferralSEPModel audits by entity id failed',

	FETCH_ALL_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Fetch all BpjsTotalReferralSEPModel',
	FETCH_ALL_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Fetch all BpjsTotalReferralSEPModel successfully',
	FETCH_ALL_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Fetch all BpjsTotalReferralSEPModel failed',

	FETCH_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY = '[ENTITY] Fetch BpjsTotalReferralSEPModel with query',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY_OK = '[ENTITY] Fetch BpjsTotalReferralSEPModel with query successfully',
	FETCH_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsTotalReferralSEPModel with query failed',

	FETCH_LAST_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY = '[ENTITY] Fetch last BpjsTotalReferralSEPModel with query',
	FETCH_LAST_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsTotalReferralSEPModel with query successfully',
	FETCH_LAST_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsTotalReferralSEPModel with query failed',

	EXPORT_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Export BpjsTotalReferralSEPModel',
	EXPORT_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Export BpjsTotalReferralSEPModel successfully',
	EXPORT_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Export BpjsTotalReferralSEPModel failed',

	EXPORT_ALL_BPJS_TOTAL_REFERRAL_SEP = '[ENTITY] Export All BpjsTotalReferralSEPModels',
	EXPORT_ALL_BPJS_TOTAL_REFERRAL_SEP_OK = '[ENTITY] Export All BpjsTotalReferralSEPModels successfully',
	EXPORT_ALL_BPJS_TOTAL_REFERRAL_SEP_FAIL = '[ENTITY] Export All BpjsTotalReferralSEPModels failed',

	EXPORT_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS = '[ENTITY] Export BpjsTotalReferralSEPModels excluding Ids',
	EXPORT_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsTotalReferralSEPModel excluding Ids successfully',
	EXPORT_BPJS_TOTAL_REFERRAL_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsTotalReferralSEPModel excluding Ids failed',

	COUNT_BPJS_TOTAL_REFERRAL_SEPS = '[ENTITY] Fetch number of BpjsTotalReferralSEPModel records',
	COUNT_BPJS_TOTAL_REFERRAL_SEPS_OK = '[ENTITY] Fetch number of BpjsTotalReferralSEPModel records successfully ',
	COUNT_BPJS_TOTAL_REFERRAL_SEPS_FAIL = '[ENTITY] Fetch number of BpjsTotalReferralSEPModel records failed',

	IMPORT_BPJS_TOTAL_REFERRAL_SEPS = '[ENTITY] Import BpjsTotalReferralSEPModels',
	IMPORT_BPJS_TOTAL_REFERRAL_SEPS_OK = '[ENTITY] Import BpjsTotalReferralSEPModels successfully',
	IMPORT_BPJS_TOTAL_REFERRAL_SEPS_FAIL = '[ENTITY] Import BpjsTotalReferralSEPModels fail',


	INITIALISE_BPJS_TOTAL_REFERRAL_SEP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsTotalReferralSEPModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsTotalReferralSEPAction implements Action {
	readonly className: string = 'BpjsTotalReferralSEPModel';

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

export class BpjsTotalReferralSEPAction extends BaseBpjsTotalReferralSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPAction here] off begin
	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTotalReferralSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPAction here] off begin
	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPAction here] end
}

export class BpjsTotalReferralSEPActionOK extends BaseBpjsTotalReferralSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTotalReferralSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsTotalReferralSEPModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPActionOK here] end
}

export class BpjsTotalReferralSEPActionFail extends BaseBpjsTotalReferralSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsTotalReferralSEPActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsTotalReferralSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTotalReferralSEPActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTotalReferralSEPActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTotalReferralSEPActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsTotalReferralSEPActionFail here] end
}

export function isBpjsTotalReferralSEPModelAction(e: any): e is BaseBpjsTotalReferralSEPAction {
	return Object.values(BpjsTotalReferralSEPModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
