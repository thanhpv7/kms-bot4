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
import {BpjsClaimDataModel} from './bpjs_claim_data.model';
import {BpjsClaimDataModelAudit} from './bpjs_claim_data.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Claim Data model actions to be dispatched by NgRx.
 */
export enum BpjsClaimDataModelActionTypes {
	CREATE_BPJS_CLAIM_DATA = '[ENTITY] Create BpjsClaimDataModel',
	CREATE_BPJS_CLAIM_DATA_OK = '[ENTITY] Create BpjsClaimDataModel successfully',
	CREATE_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Create BpjsClaimDataModel failed',

	CREATE_ALL_BPJS_CLAIM_DATA = '[ENTITY] Create All BpjsClaimDataModel',
	CREATE_ALL_BPJS_CLAIM_DATA_OK = '[ENTITY] Create All BpjsClaimDataModel successfully',
	CREATE_ALL_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Create All BpjsClaimDataModel failed',

	DELETE_BPJS_CLAIM_DATA = '[ENTITY] Delete BpjsClaimDataModel',
	DELETE_BPJS_CLAIM_DATA_OK = '[ENTITY] Delete BpjsClaimDataModel successfully',
	DELETE_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Delete BpjsClaimDataModel failed',


	DELETE_BPJS_CLAIM_DATA_EXCLUDING_IDS = '[ENTITY] Delete BpjsClaimDataModels Excluding Ids',
	DELETE_BPJS_CLAIM_DATA_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsClaimDataModels Excluding Ids successfully',
	DELETE_BPJS_CLAIM_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsClaimDataModels Excluding Ids failed',

	DELETE_ALL_BPJS_CLAIM_DATA = '[ENTITY] Delete all BpjsClaimDataModels',
	DELETE_ALL_BPJS_CLAIM_DATA_OK = '[ENTITY] Delete all BpjsClaimDataModels successfully',
	DELETE_ALL_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Delete all BpjsClaimDataModels failed',

	UPDATE_BPJS_CLAIM_DATA = '[ENTITY] Update BpjsClaimDataModel',
	UPDATE_BPJS_CLAIM_DATA_OK = '[ENTITY] Update BpjsClaimDataModel successfully',
	UPDATE_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Update BpjsClaimDataModel failed',

	UPDATE_ALL_BPJS_CLAIM_DATA = '[ENTITY] Update all BpjsClaimDataModel',
	UPDATE_ALL_BPJS_CLAIM_DATA_OK = '[ENTITY] Update all BpjsClaimDataModel successfully',
	UPDATE_ALL_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Update all BpjsClaimDataModel failed',

	FETCH_BPJS_CLAIM_DATA= '[ENTITY] Fetch BpjsClaimDataModel',
	FETCH_BPJS_CLAIM_DATA_OK = '[ENTITY] Fetch BpjsClaimDataModel successfully',
	FETCH_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Fetch BpjsClaimDataModel failed',

	FETCH_BPJS_CLAIM_DATA_AUDIT= '[ENTITY] Fetch BpjsClaimDataModel audit',
	FETCH_BPJS_CLAIM_DATA_AUDIT_OK = '[ENTITY] Fetch BpjsClaimDataModel audit successfully',
	FETCH_BPJS_CLAIM_DATA_AUDIT_FAIL = '[ENTITY] Fetch BpjsClaimDataModel audit failed',

	FETCH_BPJS_CLAIM_DATA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsClaimDataModel audits by entity id',
	FETCH_BPJS_CLAIM_DATA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsClaimDataModel audits by entity id successfully',
	FETCH_BPJS_CLAIM_DATA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsClaimDataModel audits by entity id failed',

	FETCH_ALL_BPJS_CLAIM_DATA = '[ENTITY] Fetch all BpjsClaimDataModel',
	FETCH_ALL_BPJS_CLAIM_DATA_OK = '[ENTITY] Fetch all BpjsClaimDataModel successfully',
	FETCH_ALL_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Fetch all BpjsClaimDataModel failed',

	FETCH_BPJS_CLAIM_DATA_WITH_QUERY = '[ENTITY] Fetch BpjsClaimDataModel with query',
	FETCH_BPJS_CLAIM_DATA_WITH_QUERY_OK = '[ENTITY] Fetch BpjsClaimDataModel with query successfully',
	FETCH_BPJS_CLAIM_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsClaimDataModel with query failed',

	FETCH_LAST_BPJS_CLAIM_DATA_WITH_QUERY = '[ENTITY] Fetch last BpjsClaimDataModel with query',
	FETCH_LAST_BPJS_CLAIM_DATA_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsClaimDataModel with query successfully',
	FETCH_LAST_BPJS_CLAIM_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsClaimDataModel with query failed',

	EXPORT_BPJS_CLAIM_DATA = '[ENTITY] Export BpjsClaimDataModel',
	EXPORT_BPJS_CLAIM_DATA_OK = '[ENTITY] Export BpjsClaimDataModel successfully',
	EXPORT_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Export BpjsClaimDataModel failed',

	EXPORT_ALL_BPJS_CLAIM_DATA = '[ENTITY] Export All BpjsClaimDataModels',
	EXPORT_ALL_BPJS_CLAIM_DATA_OK = '[ENTITY] Export All BpjsClaimDataModels successfully',
	EXPORT_ALL_BPJS_CLAIM_DATA_FAIL = '[ENTITY] Export All BpjsClaimDataModels failed',

	EXPORT_BPJS_CLAIM_DATA_EXCLUDING_IDS = '[ENTITY] Export BpjsClaimDataModels excluding Ids',
	EXPORT_BPJS_CLAIM_DATA_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsClaimDataModel excluding Ids successfully',
	EXPORT_BPJS_CLAIM_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsClaimDataModel excluding Ids failed',

	COUNT_BPJS_CLAIM_DATAS = '[ENTITY] Fetch number of BpjsClaimDataModel records',
	COUNT_BPJS_CLAIM_DATAS_OK = '[ENTITY] Fetch number of BpjsClaimDataModel records successfully ',
	COUNT_BPJS_CLAIM_DATAS_FAIL = '[ENTITY] Fetch number of BpjsClaimDataModel records failed',

	IMPORT_BPJS_CLAIM_DATAS = '[ENTITY] Import BpjsClaimDataModels',
	IMPORT_BPJS_CLAIM_DATAS_OK = '[ENTITY] Import BpjsClaimDataModels successfully',
	IMPORT_BPJS_CLAIM_DATAS_FAIL = '[ENTITY] Import BpjsClaimDataModels fail',


	INITIALISE_BPJS_CLAIM_DATA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsClaimDataModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsClaimDataAction implements Action {
	readonly className: string = 'BpjsClaimDataModel';

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

export class BpjsClaimDataAction extends BaseBpjsClaimDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimDataAction here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimDataAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsClaimDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimDataAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimDataAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimDataAction here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimDataAction here] end
}

export class BpjsClaimDataActionOK extends BaseBpjsClaimDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimDataActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimDataActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsClaimDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsClaimDataModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimDataActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimDataActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimDataActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimDataActionOK here] end
}

export class BpjsClaimDataActionFail extends BaseBpjsClaimDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimDataActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimDataActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsClaimDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimDataActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimDataActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimDataActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimDataActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimDataActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimDataActionFail here] end
}

export function isBpjsClaimDataModelAction(e: any): e is BaseBpjsClaimDataAction {
	return Object.values(BpjsClaimDataModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
