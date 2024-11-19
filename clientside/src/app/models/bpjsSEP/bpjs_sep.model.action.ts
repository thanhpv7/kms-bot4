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
import {BpjsSEPModel} from './bpjs_sep.model';
import {BpjsSEPModelAudit} from './bpjs_sep.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS SEP model actions to be dispatched by NgRx.
 */
export enum BpjsSEPModelActionTypes {
	CREATE_BPJS_SEP = '[ENTITY] Create BpjsSEPModel',
	CREATE_BPJS_SEP_OK = '[ENTITY] Create BpjsSEPModel successfully',
	CREATE_BPJS_SEP_FAIL = '[ENTITY] Create BpjsSEPModel failed',

	CREATE_ALL_BPJS_SEP = '[ENTITY] Create All BpjsSEPModel',
	CREATE_ALL_BPJS_SEP_OK = '[ENTITY] Create All BpjsSEPModel successfully',
	CREATE_ALL_BPJS_SEP_FAIL = '[ENTITY] Create All BpjsSEPModel failed',

	DELETE_BPJS_SEP = '[ENTITY] Delete BpjsSEPModel',
	DELETE_BPJS_SEP_OK = '[ENTITY] Delete BpjsSEPModel successfully',
	DELETE_BPJS_SEP_FAIL = '[ENTITY] Delete BpjsSEPModel failed',


	DELETE_BPJS_SEP_EXCLUDING_IDS = '[ENTITY] Delete BpjsSEPModels Excluding Ids',
	DELETE_BPJS_SEP_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSEPModels Excluding Ids successfully',
	DELETE_BPJS_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSEPModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEP = '[ENTITY] Delete all BpjsSEPModels',
	DELETE_ALL_BPJS_SEP_OK = '[ENTITY] Delete all BpjsSEPModels successfully',
	DELETE_ALL_BPJS_SEP_FAIL = '[ENTITY] Delete all BpjsSEPModels failed',

	UPDATE_BPJS_SEP = '[ENTITY] Update BpjsSEPModel',
	UPDATE_BPJS_SEP_OK = '[ENTITY] Update BpjsSEPModel successfully',
	UPDATE_BPJS_SEP_FAIL = '[ENTITY] Update BpjsSEPModel failed',

	UPDATE_ALL_BPJS_SEP = '[ENTITY] Update all BpjsSEPModel',
	UPDATE_ALL_BPJS_SEP_OK = '[ENTITY] Update all BpjsSEPModel successfully',
	UPDATE_ALL_BPJS_SEP_FAIL = '[ENTITY] Update all BpjsSEPModel failed',

	FETCH_BPJS_SEP= '[ENTITY] Fetch BpjsSEPModel',
	FETCH_BPJS_SEP_OK = '[ENTITY] Fetch BpjsSEPModel successfully',
	FETCH_BPJS_SEP_FAIL = '[ENTITY] Fetch BpjsSEPModel failed',

	FETCH_BPJS_SEP_AUDIT= '[ENTITY] Fetch BpjsSEPModel audit',
	FETCH_BPJS_SEP_AUDIT_OK = '[ENTITY] Fetch BpjsSEPModel audit successfully',
	FETCH_BPJS_SEP_AUDIT_FAIL = '[ENTITY] Fetch BpjsSEPModel audit failed',

	FETCH_BPJS_SEP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSEPModel audits by entity id',
	FETCH_BPJS_SEP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSEPModel audits by entity id successfully',
	FETCH_BPJS_SEP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSEPModel audits by entity id failed',

	FETCH_ALL_BPJS_SEP = '[ENTITY] Fetch all BpjsSEPModel',
	FETCH_ALL_BPJS_SEP_OK = '[ENTITY] Fetch all BpjsSEPModel successfully',
	FETCH_ALL_BPJS_SEP_FAIL = '[ENTITY] Fetch all BpjsSEPModel failed',

	FETCH_BPJS_SEP_WITH_QUERY = '[ENTITY] Fetch BpjsSEPModel with query',
	FETCH_BPJS_SEP_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSEPModel with query successfully',
	FETCH_BPJS_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSEPModel with query failed',

	FETCH_LAST_BPJS_SEP_WITH_QUERY = '[ENTITY] Fetch last BpjsSEPModel with query',
	FETCH_LAST_BPJS_SEP_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSEPModel with query successfully',
	FETCH_LAST_BPJS_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSEPModel with query failed',

	EXPORT_BPJS_SEP = '[ENTITY] Export BpjsSEPModel',
	EXPORT_BPJS_SEP_OK = '[ENTITY] Export BpjsSEPModel successfully',
	EXPORT_BPJS_SEP_FAIL = '[ENTITY] Export BpjsSEPModel failed',

	EXPORT_ALL_BPJS_SEP = '[ENTITY] Export All BpjsSEPModels',
	EXPORT_ALL_BPJS_SEP_OK = '[ENTITY] Export All BpjsSEPModels successfully',
	EXPORT_ALL_BPJS_SEP_FAIL = '[ENTITY] Export All BpjsSEPModels failed',

	EXPORT_BPJS_SEP_EXCLUDING_IDS = '[ENTITY] Export BpjsSEPModels excluding Ids',
	EXPORT_BPJS_SEP_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSEPModel excluding Ids successfully',
	EXPORT_BPJS_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSEPModel excluding Ids failed',

	COUNT_BPJS_SEPS = '[ENTITY] Fetch number of BpjsSEPModel records',
	COUNT_BPJS_SEPS_OK = '[ENTITY] Fetch number of BpjsSEPModel records successfully ',
	COUNT_BPJS_SEPS_FAIL = '[ENTITY] Fetch number of BpjsSEPModel records failed',

	IMPORT_BPJS_SEPS = '[ENTITY] Import BpjsSEPModels',
	IMPORT_BPJS_SEPS_OK = '[ENTITY] Import BpjsSEPModels successfully',
	IMPORT_BPJS_SEPS_FAIL = '[ENTITY] Import BpjsSEPModels fail',


	INITIALISE_BPJS_SEP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSEPModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSEPAction implements Action {
	readonly className: string = 'BpjsSEPModel';

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

export class BpjsSEPAction extends BaseBpjsSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPAction here] end
}

export class BpjsSEPActionOK extends BaseBpjsSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSEPModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPActionOK here] end
}

export class BpjsSEPActionFail extends BaseBpjsSEPAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSEPModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPActionFail here] end
}

export function isBpjsSEPModelAction(e: any): e is BaseBpjsSEPAction {
	return Object.values(BpjsSEPModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
