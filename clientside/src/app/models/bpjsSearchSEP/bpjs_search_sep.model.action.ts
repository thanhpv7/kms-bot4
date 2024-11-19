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
import {BpjsSearchSEPModel} from './bpjs_search_sep.model';
import {BpjsSearchSEPModelAudit} from './bpjs_search_sep.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Search SEP model actions to be dispatched by NgRx.
 */
export enum BpjsSearchSEPModelActionTypes {
	CREATE_BPJS_SEARCH_SEP = '[ENTITY] Create BpjsSearchSEPModel',
	CREATE_BPJS_SEARCH_SEP_OK = '[ENTITY] Create BpjsSearchSEPModel successfully',
	CREATE_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Create BpjsSearchSEPModel failed',

	CREATE_ALL_BPJS_SEARCH_SEP = '[ENTITY] Create All BpjsSearchSEPModel',
	CREATE_ALL_BPJS_SEARCH_SEP_OK = '[ENTITY] Create All BpjsSearchSEPModel successfully',
	CREATE_ALL_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Create All BpjsSearchSEPModel failed',

	DELETE_BPJS_SEARCH_SEP = '[ENTITY] Delete BpjsSearchSEPModel',
	DELETE_BPJS_SEARCH_SEP_OK = '[ENTITY] Delete BpjsSearchSEPModel successfully',
	DELETE_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Delete BpjsSearchSEPModel failed',


	DELETE_BPJS_SEARCH_SEP_EXCLUDING_IDS = '[ENTITY] Delete BpjsSearchSEPModels Excluding Ids',
	DELETE_BPJS_SEARCH_SEP_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSearchSEPModels Excluding Ids successfully',
	DELETE_BPJS_SEARCH_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSearchSEPModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEARCH_SEP = '[ENTITY] Delete all BpjsSearchSEPModels',
	DELETE_ALL_BPJS_SEARCH_SEP_OK = '[ENTITY] Delete all BpjsSearchSEPModels successfully',
	DELETE_ALL_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Delete all BpjsSearchSEPModels failed',

	UPDATE_BPJS_SEARCH_SEP = '[ENTITY] Update BpjsSearchSEPModel',
	UPDATE_BPJS_SEARCH_SEP_OK = '[ENTITY] Update BpjsSearchSEPModel successfully',
	UPDATE_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Update BpjsSearchSEPModel failed',

	UPDATE_ALL_BPJS_SEARCH_SEP = '[ENTITY] Update all BpjsSearchSEPModel',
	UPDATE_ALL_BPJS_SEARCH_SEP_OK = '[ENTITY] Update all BpjsSearchSEPModel successfully',
	UPDATE_ALL_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Update all BpjsSearchSEPModel failed',

	FETCH_BPJS_SEARCH_SEP= '[ENTITY] Fetch BpjsSearchSEPModel',
	FETCH_BPJS_SEARCH_SEP_OK = '[ENTITY] Fetch BpjsSearchSEPModel successfully',
	FETCH_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Fetch BpjsSearchSEPModel failed',

	FETCH_BPJS_SEARCH_SEP_AUDIT= '[ENTITY] Fetch BpjsSearchSEPModel audit',
	FETCH_BPJS_SEARCH_SEP_AUDIT_OK = '[ENTITY] Fetch BpjsSearchSEPModel audit successfully',
	FETCH_BPJS_SEARCH_SEP_AUDIT_FAIL = '[ENTITY] Fetch BpjsSearchSEPModel audit failed',

	FETCH_BPJS_SEARCH_SEP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSearchSEPModel audits by entity id',
	FETCH_BPJS_SEARCH_SEP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSearchSEPModel audits by entity id successfully',
	FETCH_BPJS_SEARCH_SEP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSearchSEPModel audits by entity id failed',

	FETCH_ALL_BPJS_SEARCH_SEP = '[ENTITY] Fetch all BpjsSearchSEPModel',
	FETCH_ALL_BPJS_SEARCH_SEP_OK = '[ENTITY] Fetch all BpjsSearchSEPModel successfully',
	FETCH_ALL_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Fetch all BpjsSearchSEPModel failed',

	FETCH_BPJS_SEARCH_SEP_WITH_QUERY = '[ENTITY] Fetch BpjsSearchSEPModel with query',
	FETCH_BPJS_SEARCH_SEP_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSearchSEPModel with query successfully',
	FETCH_BPJS_SEARCH_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSearchSEPModel with query failed',

	FETCH_LAST_BPJS_SEARCH_SEP_WITH_QUERY = '[ENTITY] Fetch last BpjsSearchSEPModel with query',
	FETCH_LAST_BPJS_SEARCH_SEP_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSearchSEPModel with query successfully',
	FETCH_LAST_BPJS_SEARCH_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSearchSEPModel with query failed',

	EXPORT_BPJS_SEARCH_SEP = '[ENTITY] Export BpjsSearchSEPModel',
	EXPORT_BPJS_SEARCH_SEP_OK = '[ENTITY] Export BpjsSearchSEPModel successfully',
	EXPORT_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Export BpjsSearchSEPModel failed',

	EXPORT_ALL_BPJS_SEARCH_SEP = '[ENTITY] Export All BpjsSearchSEPModels',
	EXPORT_ALL_BPJS_SEARCH_SEP_OK = '[ENTITY] Export All BpjsSearchSEPModels successfully',
	EXPORT_ALL_BPJS_SEARCH_SEP_FAIL = '[ENTITY] Export All BpjsSearchSEPModels failed',

	EXPORT_BPJS_SEARCH_SEP_EXCLUDING_IDS = '[ENTITY] Export BpjsSearchSEPModels excluding Ids',
	EXPORT_BPJS_SEARCH_SEP_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSearchSEPModel excluding Ids successfully',
	EXPORT_BPJS_SEARCH_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSearchSEPModel excluding Ids failed',

	COUNT_BPJS_SEARCH_SEPS = '[ENTITY] Fetch number of BpjsSearchSEPModel records',
	COUNT_BPJS_SEARCH_SEPS_OK = '[ENTITY] Fetch number of BpjsSearchSEPModel records successfully ',
	COUNT_BPJS_SEARCH_SEPS_FAIL = '[ENTITY] Fetch number of BpjsSearchSEPModel records failed',

	IMPORT_BPJS_SEARCH_SEPS = '[ENTITY] Import BpjsSearchSEPModels',
	IMPORT_BPJS_SEARCH_SEPS_OK = '[ENTITY] Import BpjsSearchSEPModels successfully',
	IMPORT_BPJS_SEARCH_SEPS_FAIL = '[ENTITY] Import BpjsSearchSEPModels fail',


	INITIALISE_BPJS_SEARCH_SEP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSearchSEPModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSearchSEPAction implements Action {
	readonly className: string = 'BpjsSearchSEPModel';

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

export class BpjsSearchSEPAction extends BaseBpjsSearchSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchSEPAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchSEPAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSearchSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchSEPAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchSEPAction here] end
}

export class BpjsSearchSEPActionOK extends BaseBpjsSearchSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchSEPActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchSEPActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSearchSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSearchSEPModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchSEPActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchSEPActionOK here] end
}

export class BpjsSearchSEPActionFail extends BaseBpjsSearchSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchSEPActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchSEPActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSearchSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchSEPActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchSEPActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchSEPActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchSEPActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchSEPActionFail here] end
}

export function isBpjsSearchSEPModelAction(e: any): e is BaseBpjsSearchSEPAction {
	return Object.values(BpjsSearchSEPModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
