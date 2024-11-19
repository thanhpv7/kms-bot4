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
import {BpjsJasaRaharjaClaimModel} from './bpjs_jasa_raharja_claim.model';
import {BpjsJasaRaharjaClaimModelAudit} from './bpjs_jasa_raharja_claim.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Jasa Raharja Claim model actions to be dispatched by NgRx.
 */
export enum BpjsJasaRaharjaClaimModelActionTypes {
	CREATE_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Create BpjsJasaRaharjaClaimModel',
	CREATE_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Create BpjsJasaRaharjaClaimModel successfully',
	CREATE_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Create BpjsJasaRaharjaClaimModel failed',

	CREATE_ALL_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Create All BpjsJasaRaharjaClaimModel',
	CREATE_ALL_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Create All BpjsJasaRaharjaClaimModel successfully',
	CREATE_ALL_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Create All BpjsJasaRaharjaClaimModel failed',

	DELETE_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Delete BpjsJasaRaharjaClaimModel',
	DELETE_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Delete BpjsJasaRaharjaClaimModel successfully',
	DELETE_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Delete BpjsJasaRaharjaClaimModel failed',


	DELETE_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS = '[ENTITY] Delete BpjsJasaRaharjaClaimModels Excluding Ids',
	DELETE_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsJasaRaharjaClaimModels Excluding Ids successfully',
	DELETE_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsJasaRaharjaClaimModels Excluding Ids failed',

	DELETE_ALL_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Delete all BpjsJasaRaharjaClaimModels',
	DELETE_ALL_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Delete all BpjsJasaRaharjaClaimModels successfully',
	DELETE_ALL_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Delete all BpjsJasaRaharjaClaimModels failed',

	UPDATE_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Update BpjsJasaRaharjaClaimModel',
	UPDATE_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Update BpjsJasaRaharjaClaimModel successfully',
	UPDATE_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Update BpjsJasaRaharjaClaimModel failed',

	UPDATE_ALL_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Update all BpjsJasaRaharjaClaimModel',
	UPDATE_ALL_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Update all BpjsJasaRaharjaClaimModel successfully',
	UPDATE_ALL_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Update all BpjsJasaRaharjaClaimModel failed',

	FETCH_BPJS_JASA_RAHARJA_CLAIM= '[ENTITY] Fetch BpjsJasaRaharjaClaimModel',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel successfully',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel failed',

	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDIT= '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audit',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDIT_OK = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audit successfully',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDIT_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audit failed',

	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audits by entity id',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audits by entity id successfully',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel audits by entity id failed',

	FETCH_ALL_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Fetch all BpjsJasaRaharjaClaimModel',
	FETCH_ALL_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Fetch all BpjsJasaRaharjaClaimModel successfully',
	FETCH_ALL_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Fetch all BpjsJasaRaharjaClaimModel failed',

	FETCH_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel with query',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel with query successfully',
	FETCH_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaClaimModel with query failed',

	FETCH_LAST_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY = '[ENTITY] Fetch last BpjsJasaRaharjaClaimModel with query',
	FETCH_LAST_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsJasaRaharjaClaimModel with query successfully',
	FETCH_LAST_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsJasaRaharjaClaimModel with query failed',

	EXPORT_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Export BpjsJasaRaharjaClaimModel',
	EXPORT_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Export BpjsJasaRaharjaClaimModel successfully',
	EXPORT_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Export BpjsJasaRaharjaClaimModel failed',

	EXPORT_ALL_BPJS_JASA_RAHARJA_CLAIM = '[ENTITY] Export All BpjsJasaRaharjaClaimModels',
	EXPORT_ALL_BPJS_JASA_RAHARJA_CLAIM_OK = '[ENTITY] Export All BpjsJasaRaharjaClaimModels successfully',
	EXPORT_ALL_BPJS_JASA_RAHARJA_CLAIM_FAIL = '[ENTITY] Export All BpjsJasaRaharjaClaimModels failed',

	EXPORT_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS = '[ENTITY] Export BpjsJasaRaharjaClaimModels excluding Ids',
	EXPORT_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsJasaRaharjaClaimModel excluding Ids successfully',
	EXPORT_BPJS_JASA_RAHARJA_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsJasaRaharjaClaimModel excluding Ids failed',

	COUNT_BPJS_JASA_RAHARJA_CLAIMS = '[ENTITY] Fetch number of BpjsJasaRaharjaClaimModel records',
	COUNT_BPJS_JASA_RAHARJA_CLAIMS_OK = '[ENTITY] Fetch number of BpjsJasaRaharjaClaimModel records successfully ',
	COUNT_BPJS_JASA_RAHARJA_CLAIMS_FAIL = '[ENTITY] Fetch number of BpjsJasaRaharjaClaimModel records failed',

	IMPORT_BPJS_JASA_RAHARJA_CLAIMS = '[ENTITY] Import BpjsJasaRaharjaClaimModels',
	IMPORT_BPJS_JASA_RAHARJA_CLAIMS_OK = '[ENTITY] Import BpjsJasaRaharjaClaimModels successfully',
	IMPORT_BPJS_JASA_RAHARJA_CLAIMS_FAIL = '[ENTITY] Import BpjsJasaRaharjaClaimModels fail',


	INITIALISE_BPJS_JASA_RAHARJA_CLAIM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsJasaRaharjaClaimModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsJasaRaharjaClaimAction implements Action {
	readonly className: string = 'BpjsJasaRaharjaClaimModel';

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

export class BpjsJasaRaharjaClaimAction extends BaseBpjsJasaRaharjaClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimAction here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsJasaRaharjaClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimAction here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimAction here] end
}

export class BpjsJasaRaharjaClaimActionOK extends BaseBpjsJasaRaharjaClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsJasaRaharjaClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsJasaRaharjaClaimModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimActionOK here] end
}

export class BpjsJasaRaharjaClaimActionFail extends BaseBpjsJasaRaharjaClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaClaimActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsJasaRaharjaClaimModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaClaimActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaClaimActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaClaimActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaClaimActionFail here] end
}

export function isBpjsJasaRaharjaClaimModelAction(e: any): e is BaseBpjsJasaRaharjaClaimAction {
	return Object.values(BpjsJasaRaharjaClaimModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
