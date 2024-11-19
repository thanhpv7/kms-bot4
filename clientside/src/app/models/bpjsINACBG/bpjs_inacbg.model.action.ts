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
import {BpjsINACBGModel} from './bpjs_inacbg.model';
import {BpjsINACBGModelAudit} from './bpjs_inacbg.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS INACBG model actions to be dispatched by NgRx.
 */
export enum BpjsINACBGModelActionTypes {
	CREATE_BPJS_INACBG = '[ENTITY] Create BpjsINACBGModel',
	CREATE_BPJS_INACBG_OK = '[ENTITY] Create BpjsINACBGModel successfully',
	CREATE_BPJS_INACBG_FAIL = '[ENTITY] Create BpjsINACBGModel failed',

	CREATE_ALL_BPJS_INACBG = '[ENTITY] Create All BpjsINACBGModel',
	CREATE_ALL_BPJS_INACBG_OK = '[ENTITY] Create All BpjsINACBGModel successfully',
	CREATE_ALL_BPJS_INACBG_FAIL = '[ENTITY] Create All BpjsINACBGModel failed',

	DELETE_BPJS_INACBG = '[ENTITY] Delete BpjsINACBGModel',
	DELETE_BPJS_INACBG_OK = '[ENTITY] Delete BpjsINACBGModel successfully',
	DELETE_BPJS_INACBG_FAIL = '[ENTITY] Delete BpjsINACBGModel failed',


	DELETE_BPJS_INACBG_EXCLUDING_IDS = '[ENTITY] Delete BpjsINACBGModels Excluding Ids',
	DELETE_BPJS_INACBG_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsINACBGModels Excluding Ids successfully',
	DELETE_BPJS_INACBG_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsINACBGModels Excluding Ids failed',

	DELETE_ALL_BPJS_INACBG = '[ENTITY] Delete all BpjsINACBGModels',
	DELETE_ALL_BPJS_INACBG_OK = '[ENTITY] Delete all BpjsINACBGModels successfully',
	DELETE_ALL_BPJS_INACBG_FAIL = '[ENTITY] Delete all BpjsINACBGModels failed',

	UPDATE_BPJS_INACBG = '[ENTITY] Update BpjsINACBGModel',
	UPDATE_BPJS_INACBG_OK = '[ENTITY] Update BpjsINACBGModel successfully',
	UPDATE_BPJS_INACBG_FAIL = '[ENTITY] Update BpjsINACBGModel failed',

	UPDATE_ALL_BPJS_INACBG = '[ENTITY] Update all BpjsINACBGModel',
	UPDATE_ALL_BPJS_INACBG_OK = '[ENTITY] Update all BpjsINACBGModel successfully',
	UPDATE_ALL_BPJS_INACBG_FAIL = '[ENTITY] Update all BpjsINACBGModel failed',

	FETCH_BPJS_INACBG= '[ENTITY] Fetch BpjsINACBGModel',
	FETCH_BPJS_INACBG_OK = '[ENTITY] Fetch BpjsINACBGModel successfully',
	FETCH_BPJS_INACBG_FAIL = '[ENTITY] Fetch BpjsINACBGModel failed',

	FETCH_BPJS_INACBG_AUDIT= '[ENTITY] Fetch BpjsINACBGModel audit',
	FETCH_BPJS_INACBG_AUDIT_OK = '[ENTITY] Fetch BpjsINACBGModel audit successfully',
	FETCH_BPJS_INACBG_AUDIT_FAIL = '[ENTITY] Fetch BpjsINACBGModel audit failed',

	FETCH_BPJS_INACBG_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsINACBGModel audits by entity id',
	FETCH_BPJS_INACBG_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsINACBGModel audits by entity id successfully',
	FETCH_BPJS_INACBG_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsINACBGModel audits by entity id failed',

	FETCH_ALL_BPJS_INACBG = '[ENTITY] Fetch all BpjsINACBGModel',
	FETCH_ALL_BPJS_INACBG_OK = '[ENTITY] Fetch all BpjsINACBGModel successfully',
	FETCH_ALL_BPJS_INACBG_FAIL = '[ENTITY] Fetch all BpjsINACBGModel failed',

	FETCH_BPJS_INACBG_WITH_QUERY = '[ENTITY] Fetch BpjsINACBGModel with query',
	FETCH_BPJS_INACBG_WITH_QUERY_OK = '[ENTITY] Fetch BpjsINACBGModel with query successfully',
	FETCH_BPJS_INACBG_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsINACBGModel with query failed',

	FETCH_LAST_BPJS_INACBG_WITH_QUERY = '[ENTITY] Fetch last BpjsINACBGModel with query',
	FETCH_LAST_BPJS_INACBG_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsINACBGModel with query successfully',
	FETCH_LAST_BPJS_INACBG_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsINACBGModel with query failed',

	EXPORT_BPJS_INACBG = '[ENTITY] Export BpjsINACBGModel',
	EXPORT_BPJS_INACBG_OK = '[ENTITY] Export BpjsINACBGModel successfully',
	EXPORT_BPJS_INACBG_FAIL = '[ENTITY] Export BpjsINACBGModel failed',

	EXPORT_ALL_BPJS_INACBG = '[ENTITY] Export All BpjsINACBGModels',
	EXPORT_ALL_BPJS_INACBG_OK = '[ENTITY] Export All BpjsINACBGModels successfully',
	EXPORT_ALL_BPJS_INACBG_FAIL = '[ENTITY] Export All BpjsINACBGModels failed',

	EXPORT_BPJS_INACBG_EXCLUDING_IDS = '[ENTITY] Export BpjsINACBGModels excluding Ids',
	EXPORT_BPJS_INACBG_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsINACBGModel excluding Ids successfully',
	EXPORT_BPJS_INACBG_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsINACBGModel excluding Ids failed',

	COUNT_BPJS_INACBGS = '[ENTITY] Fetch number of BpjsINACBGModel records',
	COUNT_BPJS_INACBGS_OK = '[ENTITY] Fetch number of BpjsINACBGModel records successfully ',
	COUNT_BPJS_INACBGS_FAIL = '[ENTITY] Fetch number of BpjsINACBGModel records failed',

	IMPORT_BPJS_INACBGS = '[ENTITY] Import BpjsINACBGModels',
	IMPORT_BPJS_INACBGS_OK = '[ENTITY] Import BpjsINACBGModels successfully',
	IMPORT_BPJS_INACBGS_FAIL = '[ENTITY] Import BpjsINACBGModels fail',


	INITIALISE_BPJS_INACBG_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsINACBGModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsINACBGAction implements Action {
	readonly className: string = 'BpjsINACBGModel';

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

export class BpjsINACBGAction extends BaseBpjsINACBGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGAction here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGAction here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGAction here] end
}

export class BpjsINACBGActionOK extends BaseBpjsINACBGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsINACBGModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGActionOK here] end
}

export class BpjsINACBGActionFail extends BaseBpjsINACBGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsINACBGModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGActionFail here] end
}

export function isBpjsINACBGModelAction(e: any): e is BaseBpjsINACBGAction {
	return Object.values(BpjsINACBGModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
