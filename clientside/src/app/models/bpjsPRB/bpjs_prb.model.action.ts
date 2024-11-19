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
import {BpjsPRBModel} from './bpjs_prb.model';
import {BpjsPRBModelAudit} from './bpjs_prb.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS PRB model actions to be dispatched by NgRx.
 */
export enum BpjsPRBModelActionTypes {
	CREATE_BPJS_PRB = '[ENTITY] Create BpjsPRBModel',
	CREATE_BPJS_PRB_OK = '[ENTITY] Create BpjsPRBModel successfully',
	CREATE_BPJS_PRB_FAIL = '[ENTITY] Create BpjsPRBModel failed',

	CREATE_ALL_BPJS_PRB = '[ENTITY] Create All BpjsPRBModel',
	CREATE_ALL_BPJS_PRB_OK = '[ENTITY] Create All BpjsPRBModel successfully',
	CREATE_ALL_BPJS_PRB_FAIL = '[ENTITY] Create All BpjsPRBModel failed',

	DELETE_BPJS_PRB = '[ENTITY] Delete BpjsPRBModel',
	DELETE_BPJS_PRB_OK = '[ENTITY] Delete BpjsPRBModel successfully',
	DELETE_BPJS_PRB_FAIL = '[ENTITY] Delete BpjsPRBModel failed',


	DELETE_BPJS_PRB_EXCLUDING_IDS = '[ENTITY] Delete BpjsPRBModels Excluding Ids',
	DELETE_BPJS_PRB_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPRBModels Excluding Ids successfully',
	DELETE_BPJS_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPRBModels Excluding Ids failed',

	DELETE_ALL_BPJS_PRB = '[ENTITY] Delete all BpjsPRBModels',
	DELETE_ALL_BPJS_PRB_OK = '[ENTITY] Delete all BpjsPRBModels successfully',
	DELETE_ALL_BPJS_PRB_FAIL = '[ENTITY] Delete all BpjsPRBModels failed',

	UPDATE_BPJS_PRB = '[ENTITY] Update BpjsPRBModel',
	UPDATE_BPJS_PRB_OK = '[ENTITY] Update BpjsPRBModel successfully',
	UPDATE_BPJS_PRB_FAIL = '[ENTITY] Update BpjsPRBModel failed',

	UPDATE_ALL_BPJS_PRB = '[ENTITY] Update all BpjsPRBModel',
	UPDATE_ALL_BPJS_PRB_OK = '[ENTITY] Update all BpjsPRBModel successfully',
	UPDATE_ALL_BPJS_PRB_FAIL = '[ENTITY] Update all BpjsPRBModel failed',

	FETCH_BPJS_PRB= '[ENTITY] Fetch BpjsPRBModel',
	FETCH_BPJS_PRB_OK = '[ENTITY] Fetch BpjsPRBModel successfully',
	FETCH_BPJS_PRB_FAIL = '[ENTITY] Fetch BpjsPRBModel failed',

	FETCH_BPJS_PRB_AUDIT= '[ENTITY] Fetch BpjsPRBModel audit',
	FETCH_BPJS_PRB_AUDIT_OK = '[ENTITY] Fetch BpjsPRBModel audit successfully',
	FETCH_BPJS_PRB_AUDIT_FAIL = '[ENTITY] Fetch BpjsPRBModel audit failed',

	FETCH_BPJS_PRB_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPRBModel audits by entity id',
	FETCH_BPJS_PRB_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPRBModel audits by entity id successfully',
	FETCH_BPJS_PRB_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPRBModel audits by entity id failed',

	FETCH_ALL_BPJS_PRB = '[ENTITY] Fetch all BpjsPRBModel',
	FETCH_ALL_BPJS_PRB_OK = '[ENTITY] Fetch all BpjsPRBModel successfully',
	FETCH_ALL_BPJS_PRB_FAIL = '[ENTITY] Fetch all BpjsPRBModel failed',

	FETCH_BPJS_PRB_WITH_QUERY = '[ENTITY] Fetch BpjsPRBModel with query',
	FETCH_BPJS_PRB_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPRBModel with query successfully',
	FETCH_BPJS_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPRBModel with query failed',

	FETCH_LAST_BPJS_PRB_WITH_QUERY = '[ENTITY] Fetch last BpjsPRBModel with query',
	FETCH_LAST_BPJS_PRB_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPRBModel with query successfully',
	FETCH_LAST_BPJS_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPRBModel with query failed',

	EXPORT_BPJS_PRB = '[ENTITY] Export BpjsPRBModel',
	EXPORT_BPJS_PRB_OK = '[ENTITY] Export BpjsPRBModel successfully',
	EXPORT_BPJS_PRB_FAIL = '[ENTITY] Export BpjsPRBModel failed',

	EXPORT_ALL_BPJS_PRB = '[ENTITY] Export All BpjsPRBModels',
	EXPORT_ALL_BPJS_PRB_OK = '[ENTITY] Export All BpjsPRBModels successfully',
	EXPORT_ALL_BPJS_PRB_FAIL = '[ENTITY] Export All BpjsPRBModels failed',

	EXPORT_BPJS_PRB_EXCLUDING_IDS = '[ENTITY] Export BpjsPRBModels excluding Ids',
	EXPORT_BPJS_PRB_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPRBModel excluding Ids successfully',
	EXPORT_BPJS_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPRBModel excluding Ids failed',

	COUNT_BPJS_PRBS = '[ENTITY] Fetch number of BpjsPRBModel records',
	COUNT_BPJS_PRBS_OK = '[ENTITY] Fetch number of BpjsPRBModel records successfully ',
	COUNT_BPJS_PRBS_FAIL = '[ENTITY] Fetch number of BpjsPRBModel records failed',

	IMPORT_BPJS_PRBS = '[ENTITY] Import BpjsPRBModels',
	IMPORT_BPJS_PRBS_OK = '[ENTITY] Import BpjsPRBModels successfully',
	IMPORT_BPJS_PRBS_FAIL = '[ENTITY] Import BpjsPRBModels fail',


	INITIALISE_BPJS_PRB_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPRBModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPRBAction implements Action {
	readonly className: string = 'BpjsPRBModel';

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

export class BpjsPRBAction extends BaseBpjsPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBAction here] end
}

export class BpjsPRBActionOK extends BaseBpjsPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPRBModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBActionOK here] end
}

export class BpjsPRBActionFail extends BaseBpjsPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBActionFail here] end
}

export function isBpjsPRBModelAction(e: any): e is BaseBpjsPRBAction {
	return Object.values(BpjsPRBModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
