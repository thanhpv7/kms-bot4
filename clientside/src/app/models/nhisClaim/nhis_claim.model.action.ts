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
import {NhisClaimModel} from './nhis_claim.model';
import {NhisClaimModelAudit} from './nhis_claim.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Claim model actions to be dispatched by NgRx.
 */
export enum NhisClaimModelActionTypes {
	CREATE_NHIS_CLAIM = '[ENTITY] Create NhisClaimModel',
	CREATE_NHIS_CLAIM_OK = '[ENTITY] Create NhisClaimModel successfully',
	CREATE_NHIS_CLAIM_FAIL = '[ENTITY] Create NhisClaimModel failed',

	CREATE_ALL_NHIS_CLAIM = '[ENTITY] Create All NhisClaimModel',
	CREATE_ALL_NHIS_CLAIM_OK = '[ENTITY] Create All NhisClaimModel successfully',
	CREATE_ALL_NHIS_CLAIM_FAIL = '[ENTITY] Create All NhisClaimModel failed',

	DELETE_NHIS_CLAIM = '[ENTITY] Delete NhisClaimModel',
	DELETE_NHIS_CLAIM_OK = '[ENTITY] Delete NhisClaimModel successfully',
	DELETE_NHIS_CLAIM_FAIL = '[ENTITY] Delete NhisClaimModel failed',


	DELETE_NHIS_CLAIM_EXCLUDING_IDS = '[ENTITY] Delete NhisClaimModels Excluding Ids',
	DELETE_NHIS_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisClaimModels Excluding Ids successfully',
	DELETE_NHIS_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisClaimModels Excluding Ids failed',

	DELETE_ALL_NHIS_CLAIM = '[ENTITY] Delete all NhisClaimModels',
	DELETE_ALL_NHIS_CLAIM_OK = '[ENTITY] Delete all NhisClaimModels successfully',
	DELETE_ALL_NHIS_CLAIM_FAIL = '[ENTITY] Delete all NhisClaimModels failed',

	UPDATE_NHIS_CLAIM = '[ENTITY] Update NhisClaimModel',
	UPDATE_NHIS_CLAIM_OK = '[ENTITY] Update NhisClaimModel successfully',
	UPDATE_NHIS_CLAIM_FAIL = '[ENTITY] Update NhisClaimModel failed',

	UPDATE_ALL_NHIS_CLAIM = '[ENTITY] Update all NhisClaimModel',
	UPDATE_ALL_NHIS_CLAIM_OK = '[ENTITY] Update all NhisClaimModel successfully',
	UPDATE_ALL_NHIS_CLAIM_FAIL = '[ENTITY] Update all NhisClaimModel failed',

	FETCH_NHIS_CLAIM= '[ENTITY] Fetch NhisClaimModel',
	FETCH_NHIS_CLAIM_OK = '[ENTITY] Fetch NhisClaimModel successfully',
	FETCH_NHIS_CLAIM_FAIL = '[ENTITY] Fetch NhisClaimModel failed',

	FETCH_NHIS_CLAIM_AUDIT= '[ENTITY] Fetch NhisClaimModel audit',
	FETCH_NHIS_CLAIM_AUDIT_OK = '[ENTITY] Fetch NhisClaimModel audit successfully',
	FETCH_NHIS_CLAIM_AUDIT_FAIL = '[ENTITY] Fetch NhisClaimModel audit failed',

	FETCH_NHIS_CLAIM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisClaimModel audits by entity id',
	FETCH_NHIS_CLAIM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisClaimModel audits by entity id successfully',
	FETCH_NHIS_CLAIM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisClaimModel audits by entity id failed',

	FETCH_ALL_NHIS_CLAIM = '[ENTITY] Fetch all NhisClaimModel',
	FETCH_ALL_NHIS_CLAIM_OK = '[ENTITY] Fetch all NhisClaimModel successfully',
	FETCH_ALL_NHIS_CLAIM_FAIL = '[ENTITY] Fetch all NhisClaimModel failed',

	FETCH_NHIS_CLAIM_WITH_QUERY = '[ENTITY] Fetch NhisClaimModel with query',
	FETCH_NHIS_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch NhisClaimModel with query successfully',
	FETCH_NHIS_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisClaimModel with query failed',

	FETCH_LAST_NHIS_CLAIM_WITH_QUERY = '[ENTITY] Fetch last NhisClaimModel with query',
	FETCH_LAST_NHIS_CLAIM_WITH_QUERY_OK = '[ENTITY] Fetch last NhisClaimModel with query successfully',
	FETCH_LAST_NHIS_CLAIM_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisClaimModel with query failed',

	EXPORT_NHIS_CLAIM = '[ENTITY] Export NhisClaimModel',
	EXPORT_NHIS_CLAIM_OK = '[ENTITY] Export NhisClaimModel successfully',
	EXPORT_NHIS_CLAIM_FAIL = '[ENTITY] Export NhisClaimModel failed',

	EXPORT_ALL_NHIS_CLAIM = '[ENTITY] Export All NhisClaimModels',
	EXPORT_ALL_NHIS_CLAIM_OK = '[ENTITY] Export All NhisClaimModels successfully',
	EXPORT_ALL_NHIS_CLAIM_FAIL = '[ENTITY] Export All NhisClaimModels failed',

	EXPORT_NHIS_CLAIM_EXCLUDING_IDS = '[ENTITY] Export NhisClaimModels excluding Ids',
	EXPORT_NHIS_CLAIM_EXCLUDING_IDS_OK = '[ENTITY] Export NhisClaimModel excluding Ids successfully',
	EXPORT_NHIS_CLAIM_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisClaimModel excluding Ids failed',

	COUNT_NHIS_CLAIMS = '[ENTITY] Fetch number of NhisClaimModel records',
	COUNT_NHIS_CLAIMS_OK = '[ENTITY] Fetch number of NhisClaimModel records successfully ',
	COUNT_NHIS_CLAIMS_FAIL = '[ENTITY] Fetch number of NhisClaimModel records failed',

	IMPORT_NHIS_CLAIMS = '[ENTITY] Import NhisClaimModels',
	IMPORT_NHIS_CLAIMS_OK = '[ENTITY] Import NhisClaimModels successfully',
	IMPORT_NHIS_CLAIMS_FAIL = '[ENTITY] Import NhisClaimModels fail',


	INITIALISE_NHIS_CLAIM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisClaimModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisClaimAction implements Action {
	readonly className: string = 'NhisClaimModel';

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

export class NhisClaimAction extends BaseNhisClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimAction here] off begin
	// % protected region % [Add any additional class fields for NhisClaimAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimAction here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimAction here] off begin
	// % protected region % [Add any additional class methods for NhisClaimAction here] end
}

export class NhisClaimActionOK extends BaseNhisClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisClaimActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisClaimModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisClaimActionOK here] end
}

export class NhisClaimActionFail extends BaseNhisClaimAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisClaimActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisClaimModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisClaimActionFail here] end
}

export function isNhisClaimModelAction(e: any): e is BaseNhisClaimAction {
	return Object.values(NhisClaimModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
