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
import {BpjsListTaskModel} from './bpjs_list_task.model';
import {BpjsListTaskModelAudit} from './bpjs_list_task.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS List Task model actions to be dispatched by NgRx.
 */
export enum BpjsListTaskModelActionTypes {
	CREATE_BPJS_LIST_TASK = '[ENTITY] Create BpjsListTaskModel',
	CREATE_BPJS_LIST_TASK_OK = '[ENTITY] Create BpjsListTaskModel successfully',
	CREATE_BPJS_LIST_TASK_FAIL = '[ENTITY] Create BpjsListTaskModel failed',

	CREATE_ALL_BPJS_LIST_TASK = '[ENTITY] Create All BpjsListTaskModel',
	CREATE_ALL_BPJS_LIST_TASK_OK = '[ENTITY] Create All BpjsListTaskModel successfully',
	CREATE_ALL_BPJS_LIST_TASK_FAIL = '[ENTITY] Create All BpjsListTaskModel failed',

	DELETE_BPJS_LIST_TASK = '[ENTITY] Delete BpjsListTaskModel',
	DELETE_BPJS_LIST_TASK_OK = '[ENTITY] Delete BpjsListTaskModel successfully',
	DELETE_BPJS_LIST_TASK_FAIL = '[ENTITY] Delete BpjsListTaskModel failed',


	DELETE_BPJS_LIST_TASK_EXCLUDING_IDS = '[ENTITY] Delete BpjsListTaskModels Excluding Ids',
	DELETE_BPJS_LIST_TASK_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsListTaskModels Excluding Ids successfully',
	DELETE_BPJS_LIST_TASK_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsListTaskModels Excluding Ids failed',

	DELETE_ALL_BPJS_LIST_TASK = '[ENTITY] Delete all BpjsListTaskModels',
	DELETE_ALL_BPJS_LIST_TASK_OK = '[ENTITY] Delete all BpjsListTaskModels successfully',
	DELETE_ALL_BPJS_LIST_TASK_FAIL = '[ENTITY] Delete all BpjsListTaskModels failed',

	UPDATE_BPJS_LIST_TASK = '[ENTITY] Update BpjsListTaskModel',
	UPDATE_BPJS_LIST_TASK_OK = '[ENTITY] Update BpjsListTaskModel successfully',
	UPDATE_BPJS_LIST_TASK_FAIL = '[ENTITY] Update BpjsListTaskModel failed',

	UPDATE_ALL_BPJS_LIST_TASK = '[ENTITY] Update all BpjsListTaskModel',
	UPDATE_ALL_BPJS_LIST_TASK_OK = '[ENTITY] Update all BpjsListTaskModel successfully',
	UPDATE_ALL_BPJS_LIST_TASK_FAIL = '[ENTITY] Update all BpjsListTaskModel failed',

	FETCH_BPJS_LIST_TASK= '[ENTITY] Fetch BpjsListTaskModel',
	FETCH_BPJS_LIST_TASK_OK = '[ENTITY] Fetch BpjsListTaskModel successfully',
	FETCH_BPJS_LIST_TASK_FAIL = '[ENTITY] Fetch BpjsListTaskModel failed',

	FETCH_BPJS_LIST_TASK_AUDIT= '[ENTITY] Fetch BpjsListTaskModel audit',
	FETCH_BPJS_LIST_TASK_AUDIT_OK = '[ENTITY] Fetch BpjsListTaskModel audit successfully',
	FETCH_BPJS_LIST_TASK_AUDIT_FAIL = '[ENTITY] Fetch BpjsListTaskModel audit failed',

	FETCH_BPJS_LIST_TASK_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsListTaskModel audits by entity id',
	FETCH_BPJS_LIST_TASK_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsListTaskModel audits by entity id successfully',
	FETCH_BPJS_LIST_TASK_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsListTaskModel audits by entity id failed',

	FETCH_ALL_BPJS_LIST_TASK = '[ENTITY] Fetch all BpjsListTaskModel',
	FETCH_ALL_BPJS_LIST_TASK_OK = '[ENTITY] Fetch all BpjsListTaskModel successfully',
	FETCH_ALL_BPJS_LIST_TASK_FAIL = '[ENTITY] Fetch all BpjsListTaskModel failed',

	FETCH_BPJS_LIST_TASK_WITH_QUERY = '[ENTITY] Fetch BpjsListTaskModel with query',
	FETCH_BPJS_LIST_TASK_WITH_QUERY_OK = '[ENTITY] Fetch BpjsListTaskModel with query successfully',
	FETCH_BPJS_LIST_TASK_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsListTaskModel with query failed',

	FETCH_LAST_BPJS_LIST_TASK_WITH_QUERY = '[ENTITY] Fetch last BpjsListTaskModel with query',
	FETCH_LAST_BPJS_LIST_TASK_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsListTaskModel with query successfully',
	FETCH_LAST_BPJS_LIST_TASK_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsListTaskModel with query failed',

	EXPORT_BPJS_LIST_TASK = '[ENTITY] Export BpjsListTaskModel',
	EXPORT_BPJS_LIST_TASK_OK = '[ENTITY] Export BpjsListTaskModel successfully',
	EXPORT_BPJS_LIST_TASK_FAIL = '[ENTITY] Export BpjsListTaskModel failed',

	EXPORT_ALL_BPJS_LIST_TASK = '[ENTITY] Export All BpjsListTaskModels',
	EXPORT_ALL_BPJS_LIST_TASK_OK = '[ENTITY] Export All BpjsListTaskModels successfully',
	EXPORT_ALL_BPJS_LIST_TASK_FAIL = '[ENTITY] Export All BpjsListTaskModels failed',

	EXPORT_BPJS_LIST_TASK_EXCLUDING_IDS = '[ENTITY] Export BpjsListTaskModels excluding Ids',
	EXPORT_BPJS_LIST_TASK_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsListTaskModel excluding Ids successfully',
	EXPORT_BPJS_LIST_TASK_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsListTaskModel excluding Ids failed',

	COUNT_BPJS_LIST_TASKS = '[ENTITY] Fetch number of BpjsListTaskModel records',
	COUNT_BPJS_LIST_TASKS_OK = '[ENTITY] Fetch number of BpjsListTaskModel records successfully ',
	COUNT_BPJS_LIST_TASKS_FAIL = '[ENTITY] Fetch number of BpjsListTaskModel records failed',

	IMPORT_BPJS_LIST_TASKS = '[ENTITY] Import BpjsListTaskModels',
	IMPORT_BPJS_LIST_TASKS_OK = '[ENTITY] Import BpjsListTaskModels successfully',
	IMPORT_BPJS_LIST_TASKS_FAIL = '[ENTITY] Import BpjsListTaskModels fail',


	INITIALISE_BPJS_LIST_TASK_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsListTaskModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsListTaskAction implements Action {
	readonly className: string = 'BpjsListTaskModel';

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

export class BpjsListTaskAction extends BaseBpjsListTaskAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListTaskAction here] off begin
	// % protected region % [Add any additional class fields for BpjsListTaskAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsListTaskModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListTaskAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListTaskAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListTaskAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListTaskAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListTaskAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListTaskAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsListTaskAction here] off begin
	// % protected region % [Add any additional class methods for BpjsListTaskAction here] end
}

export class BpjsListTaskActionOK extends BaseBpjsListTaskAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListTaskActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsListTaskActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsListTaskModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListTaskActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListTaskActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsListTaskModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListTaskActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListTaskActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListTaskActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListTaskActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsListTaskActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsListTaskActionOK here] end
}

export class BpjsListTaskActionFail extends BaseBpjsListTaskAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListTaskActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsListTaskActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsListTaskModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListTaskActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListTaskActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListTaskActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListTaskActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListTaskActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListTaskActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsListTaskActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsListTaskActionFail here] end
}

export function isBpjsListTaskModelAction(e: any): e is BaseBpjsListTaskAction {
	return Object.values(BpjsListTaskModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
