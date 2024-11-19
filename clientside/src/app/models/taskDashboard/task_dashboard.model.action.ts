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
import {TaskDashboardModel} from './task_dashboard.model';
import {TaskDashboardModelAudit} from './task_dashboard.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Task Dashboard model actions to be dispatched by NgRx.
 */
export enum TaskDashboardModelActionTypes {
	CREATE_TASK_DASHBOARD = '[ENTITY] Create TaskDashboardModel',
	CREATE_TASK_DASHBOARD_OK = '[ENTITY] Create TaskDashboardModel successfully',
	CREATE_TASK_DASHBOARD_FAIL = '[ENTITY] Create TaskDashboardModel failed',

	CREATE_ALL_TASK_DASHBOARD = '[ENTITY] Create All TaskDashboardModel',
	CREATE_ALL_TASK_DASHBOARD_OK = '[ENTITY] Create All TaskDashboardModel successfully',
	CREATE_ALL_TASK_DASHBOARD_FAIL = '[ENTITY] Create All TaskDashboardModel failed',

	DELETE_TASK_DASHBOARD = '[ENTITY] Delete TaskDashboardModel',
	DELETE_TASK_DASHBOARD_OK = '[ENTITY] Delete TaskDashboardModel successfully',
	DELETE_TASK_DASHBOARD_FAIL = '[ENTITY] Delete TaskDashboardModel failed',


	DELETE_TASK_DASHBOARD_EXCLUDING_IDS = '[ENTITY] Delete TaskDashboardModels Excluding Ids',
	DELETE_TASK_DASHBOARD_EXCLUDING_IDS_OK = '[ENTITY] Delete TaskDashboardModels Excluding Ids successfully',
	DELETE_TASK_DASHBOARD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TaskDashboardModels Excluding Ids failed',

	DELETE_ALL_TASK_DASHBOARD = '[ENTITY] Delete all TaskDashboardModels',
	DELETE_ALL_TASK_DASHBOARD_OK = '[ENTITY] Delete all TaskDashboardModels successfully',
	DELETE_ALL_TASK_DASHBOARD_FAIL = '[ENTITY] Delete all TaskDashboardModels failed',

	UPDATE_TASK_DASHBOARD = '[ENTITY] Update TaskDashboardModel',
	UPDATE_TASK_DASHBOARD_OK = '[ENTITY] Update TaskDashboardModel successfully',
	UPDATE_TASK_DASHBOARD_FAIL = '[ENTITY] Update TaskDashboardModel failed',

	UPDATE_ALL_TASK_DASHBOARD = '[ENTITY] Update all TaskDashboardModel',
	UPDATE_ALL_TASK_DASHBOARD_OK = '[ENTITY] Update all TaskDashboardModel successfully',
	UPDATE_ALL_TASK_DASHBOARD_FAIL = '[ENTITY] Update all TaskDashboardModel failed',

	FETCH_TASK_DASHBOARD= '[ENTITY] Fetch TaskDashboardModel',
	FETCH_TASK_DASHBOARD_OK = '[ENTITY] Fetch TaskDashboardModel successfully',
	FETCH_TASK_DASHBOARD_FAIL = '[ENTITY] Fetch TaskDashboardModel failed',

	FETCH_TASK_DASHBOARD_AUDIT= '[ENTITY] Fetch TaskDashboardModel audit',
	FETCH_TASK_DASHBOARD_AUDIT_OK = '[ENTITY] Fetch TaskDashboardModel audit successfully',
	FETCH_TASK_DASHBOARD_AUDIT_FAIL = '[ENTITY] Fetch TaskDashboardModel audit failed',

	FETCH_TASK_DASHBOARD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TaskDashboardModel audits by entity id',
	FETCH_TASK_DASHBOARD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TaskDashboardModel audits by entity id successfully',
	FETCH_TASK_DASHBOARD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TaskDashboardModel audits by entity id failed',

	FETCH_ALL_TASK_DASHBOARD = '[ENTITY] Fetch all TaskDashboardModel',
	FETCH_ALL_TASK_DASHBOARD_OK = '[ENTITY] Fetch all TaskDashboardModel successfully',
	FETCH_ALL_TASK_DASHBOARD_FAIL = '[ENTITY] Fetch all TaskDashboardModel failed',

	FETCH_TASK_DASHBOARD_WITH_QUERY = '[ENTITY] Fetch TaskDashboardModel with query',
	FETCH_TASK_DASHBOARD_WITH_QUERY_OK = '[ENTITY] Fetch TaskDashboardModel with query successfully',
	FETCH_TASK_DASHBOARD_WITH_QUERY_FAIL = '[ENTITY] Fetch TaskDashboardModel with query failed',

	FETCH_LAST_TASK_DASHBOARD_WITH_QUERY = '[ENTITY] Fetch last TaskDashboardModel with query',
	FETCH_LAST_TASK_DASHBOARD_WITH_QUERY_OK = '[ENTITY] Fetch last TaskDashboardModel with query successfully',
	FETCH_LAST_TASK_DASHBOARD_WITH_QUERY_FAIL = '[ENTITY] Fetch last TaskDashboardModel with query failed',

	EXPORT_TASK_DASHBOARD = '[ENTITY] Export TaskDashboardModel',
	EXPORT_TASK_DASHBOARD_OK = '[ENTITY] Export TaskDashboardModel successfully',
	EXPORT_TASK_DASHBOARD_FAIL = '[ENTITY] Export TaskDashboardModel failed',

	EXPORT_ALL_TASK_DASHBOARD = '[ENTITY] Export All TaskDashboardModels',
	EXPORT_ALL_TASK_DASHBOARD_OK = '[ENTITY] Export All TaskDashboardModels successfully',
	EXPORT_ALL_TASK_DASHBOARD_FAIL = '[ENTITY] Export All TaskDashboardModels failed',

	EXPORT_TASK_DASHBOARD_EXCLUDING_IDS = '[ENTITY] Export TaskDashboardModels excluding Ids',
	EXPORT_TASK_DASHBOARD_EXCLUDING_IDS_OK = '[ENTITY] Export TaskDashboardModel excluding Ids successfully',
	EXPORT_TASK_DASHBOARD_EXCLUDING_IDS_FAIL = '[ENTITY] Export TaskDashboardModel excluding Ids failed',

	COUNT_TASK_DASHBOARDS = '[ENTITY] Fetch number of TaskDashboardModel records',
	COUNT_TASK_DASHBOARDS_OK = '[ENTITY] Fetch number of TaskDashboardModel records successfully ',
	COUNT_TASK_DASHBOARDS_FAIL = '[ENTITY] Fetch number of TaskDashboardModel records failed',

	IMPORT_TASK_DASHBOARDS = '[ENTITY] Import TaskDashboardModels',
	IMPORT_TASK_DASHBOARDS_OK = '[ENTITY] Import TaskDashboardModels successfully',
	IMPORT_TASK_DASHBOARDS_FAIL = '[ENTITY] Import TaskDashboardModels fail',


	INITIALISE_TASK_DASHBOARD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TaskDashboardModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTaskDashboardAction implements Action {
	readonly className: string = 'TaskDashboardModel';

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

export class TaskDashboardAction extends BaseTaskDashboardAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TaskDashboardAction here] off begin
	// % protected region % [Add any additional class fields for TaskDashboardAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TaskDashboardModel>,
		// % protected region % [Add any additional constructor parameters for TaskDashboardAction here] off begin
		// % protected region % [Add any additional constructor parameters for TaskDashboardAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TaskDashboardAction here] off begin
			// % protected region % [Add any additional constructor arguments for TaskDashboardAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TaskDashboardAction here] off begin
		// % protected region % [Add any additional constructor logic for TaskDashboardAction here] end
	}

	// % protected region % [Add any additional class methods for TaskDashboardAction here] off begin
	// % protected region % [Add any additional class methods for TaskDashboardAction here] end
}

export class TaskDashboardActionOK extends BaseTaskDashboardAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TaskDashboardActionOK here] off begin
	// % protected region % [Add any additional class fields for TaskDashboardActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TaskDashboardModel>,
		// % protected region % [Add any additional constructor parameters for TaskDashboardActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TaskDashboardActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TaskDashboardModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TaskDashboardActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TaskDashboardActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TaskDashboardActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TaskDashboardActionOK here] end
	}

	// % protected region % [Add any additional class methods for TaskDashboardActionOK here] off begin
	// % protected region % [Add any additional class methods for TaskDashboardActionOK here] end
}

export class TaskDashboardActionFail extends BaseTaskDashboardAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TaskDashboardActionFail here] off begin
	// % protected region % [Add any additional class fields for TaskDashboardActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TaskDashboardModel>,
		// % protected region % [Add any additional constructor parameters for TaskDashboardActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TaskDashboardActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TaskDashboardActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TaskDashboardActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TaskDashboardActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TaskDashboardActionFail here] end
	}

	// % protected region % [Add any additional class methods for TaskDashboardActionFail here] off begin
	// % protected region % [Add any additional class methods for TaskDashboardActionFail here] end
}

export function isTaskDashboardModelAction(e: any): e is BaseTaskDashboardAction {
	return Object.values(TaskDashboardModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
