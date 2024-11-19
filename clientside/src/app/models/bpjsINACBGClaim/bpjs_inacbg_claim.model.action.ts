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
import {BpjsINACBGClaimModel} from './bpjs_inacbg_claim.model';
import {BpjsINACBGClaimModelAudit} from './bpjs_inacbg_claim.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS INACBG Claim model actions to be dispatched by NgRx.
 */
export enum BpjsINACBGClaimModelActionTypes {
	CREATE_BPJS_INACBG_CLAIM = '[ENTITY] Create BpjsINACBGClaimModel',
	CREATE_BPJS_INACBG_CLAIM_OK = '[ENTITY] Create BpjsINACBGClaimModel successfully',
	CREATE_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Create BpjsINACBGClaimModel failed',

	CREATE_ALL_BPJS_INACBG_CLAIM = '[ENTITY] Create All BpjsINACBGClaimModel',
	CREATE_ALL_BPJS_INACBG_CLAIM_OK = '[ENTITY] Create All BpjsINACBGClaimModel successfully',
	CREATE_ALL_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Create All BpjsINACBGClaimModel failed',

	DELETE_BPJS_INACBG_CLAIM = '[ENTITY] Delete BpjsINACBGClaimModel',
	DELETE_BPJS_INACBG_CLAIM_OK = '[ENTITY] Delete BpjsINACBGClaimModel successfully',
	DELETE_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Delete BpjsINACBGClaimModel failed',


	DELETE_BPJS_INACBG_CLAIM_EXCLUDING_IDS = '[ENTITY] Delete BpjsINACBGClaimModels Excluding Ids',
	DELETE_BPJS_INACBG_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsINACBGClaimModels Excluding Ids successfully',
	DELETE_BPJS_INACBG_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsINACBGClaimModels Excluding Ids failed',

	DELETE_ALL_BPJS_INACBG_CLAIM = '[ENTITY] Delete all BpjsINACBGClaimModels',
	DELETE_ALL_BPJS_INACBG_CLAIM_OK = '[ENTITY] Delete all BpjsINACBGClaimModels successfully',
	DELETE_ALL_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Delete all BpjsINACBGClaimModels failed',

	UPDATE_BPJS_INACBG_CLAIM = '[ENTITY] Update BpjsINACBGClaimModel',
	UPDATE_BPJS_INACBG_CLAIM_OK = '[ENTITY] Update BpjsINACBGClaimModel successfully',
	UPDATE_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Update BpjsINACBGClaimModel failed',

	UPDATE_ALL_BPJS_INACBG_CLAIM = '[ENTITY] Update all BpjsINACBGClaimModel',
	UPDATE_ALL_BPJS_INACBG_CLAIM_OK = '[ENTITY] Update all BpjsINACBGClaimModel successfully',
	UPDATE_ALL_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Update all BpjsINACBGClaimModel failed',

	FETCH_BPJS_INACBG_CLAIM= '[ENTITY] Fetch BpjsINACBGClaimModel',
	FETCH_BPJS_INACBG_CLAIM_OK = '[ENTITY] Fetch BpjsINACBGClaimModel successfully',
	FETCH_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Fetch BpjsINACBGClaimModel failed',

	FETCH_BPJS_INACBG_CLAIM_AUDIT= '[ENTITY] Fetch BpjsINACBGClaimModel audit',
	FETCH_BPJS_INACBG_CLAIM_AUDIT_OK = '[ENTITY] Fetch BpjsINACBGClaimModel audit successfully',
	FETCH_BPJS_INACBG_CLAIM_AUDIT_FAIL = '[ENTITY] Fetch BpjsINACBGClaimModel audit failed',

	FETCH_BPJS_INACBG_CLAIM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsINACBGClaimModel audits by entity id',
	FETCH_BPJS_INACBG_CLAIM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsINACBGClaimModel audits by entity id successfully',
	FETCH_BPJS_INACBG_CLAIM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsINACBGClaimModel audits by entity id failed',

	FETCH_ALL_BPJS_INACBG_CLAIM = '[ENTITY] Fetch all BpjsINACBGClaimModel',
	FETCH_ALL_BPJS_INACBG_CLAIM_OK = '[ENTITY] Fetch all BpjsINACBGClaimModel successfully',
	FETCH_ALL_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Fetch all BpjsINACBGClaimModel failed',

	FETCH_BPJS_INACBG_CLAIM_WITH_QUERY = '[ENTITY] Fetch BpjsINACBGClaimModel with query',
	FETCH_BPJS_INACBG_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch BpjsINACBGClaimModel with query successfully',
	FETCH_BPJS_INACBG_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsINACBGClaimModel with query failed',

	FETCH_LAST_BPJS_INACBG_CLAIM_WITH_QUERY = '[ENTITY] Fetch last BpjsINACBGClaimModel with query',
	FETCH_LAST_BPJS_INACBG_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsINACBGClaimModel with query successfully',
	FETCH_LAST_BPJS_INACBG_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsINACBGClaimModel with query failed',

	EXPORT_BPJS_INACBG_CLAIM = '[ENTITY] Export BpjsINACBGClaimModel',
	EXPORT_BPJS_INACBG_CLAIM_OK = '[ENTITY] Export BpjsINACBGClaimModel successfully',
	EXPORT_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Export BpjsINACBGClaimModel failed',

	EXPORT_ALL_BPJS_INACBG_CLAIM = '[ENTITY] Export All BpjsINACBGClaimModels',
	EXPORT_ALL_BPJS_INACBG_CLAIM_OK = '[ENTITY] Export All BpjsINACBGClaimModels successfully',
	EXPORT_ALL_BPJS_INACBG_CLAIM_FAIL = '[ENTITY] Export All BpjsINACBGClaimModels failed',

	EXPORT_BPJS_INACBG_CLAIM_EXCLUDING_IDS = '[ENTITY] Export BpjsINACBGClaimModels excluding Ids',
	EXPORT_BPJS_INACBG_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsINACBGClaimModel excluding Ids successfully',
	EXPORT_BPJS_INACBG_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsINACBGClaimModel excluding Ids failed',

	COUNT_BPJS_INACBG_CLAIMS = '[ENTITY] Fetch number of BpjsINACBGClaimModel records',
	COUNT_BPJS_INACBG_CLAIMS_OK = '[ENTITY] Fetch number of BpjsINACBGClaimModel records successfully ',
	COUNT_BPJS_INACBG_CLAIMS_FAIL = '[ENTITY] Fetch number of BpjsINACBGClaimModel records failed',

	IMPORT_BPJS_INACBG_CLAIMS = '[ENTITY] Import BpjsINACBGClaimModels',
	IMPORT_BPJS_INACBG_CLAIMS_OK = '[ENTITY] Import BpjsINACBGClaimModels successfully',
	IMPORT_BPJS_INACBG_CLAIMS_FAIL = '[ENTITY] Import BpjsINACBGClaimModels fail',


	INITIALISE_BPJS_INACBG_CLAIM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsINACBGClaimModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsINACBGClaimAction implements Action {
	readonly className: string = 'BpjsINACBGClaimModel';

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

export class BpjsINACBGClaimAction extends BaseBpjsINACBGClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGClaimAction here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGClaimAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGClaimAction here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGClaimAction here] end
}

export class BpjsINACBGClaimActionOK extends BaseBpjsINACBGClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGClaimActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGClaimActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsINACBGClaimModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGClaimActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGClaimActionOK here] end
}

export class BpjsINACBGClaimActionFail extends BaseBpjsINACBGClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGClaimActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGClaimActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsINACBGClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGClaimActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGClaimActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGClaimActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGClaimActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGClaimActionFail here] end
}

export function isBpjsINACBGClaimModelAction(e: any): e is BaseBpjsINACBGClaimAction {
	return Object.values(BpjsINACBGClaimModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
