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
import {ProcessWorkflowModel} from './process_workflow.model';
import {ProcessWorkflowModelAudit} from './process_workflow.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Process Workflow model actions to be dispatched by NgRx.
 */
export enum ProcessWorkflowModelActionTypes {
	CREATE_PROCESS_WORKFLOW = '[ENTITY] Create ProcessWorkflowModel',
	CREATE_PROCESS_WORKFLOW_OK = '[ENTITY] Create ProcessWorkflowModel successfully',
	CREATE_PROCESS_WORKFLOW_FAIL = '[ENTITY] Create ProcessWorkflowModel failed',

	CREATE_ALL_PROCESS_WORKFLOW = '[ENTITY] Create All ProcessWorkflowModel',
	CREATE_ALL_PROCESS_WORKFLOW_OK = '[ENTITY] Create All ProcessWorkflowModel successfully',
	CREATE_ALL_PROCESS_WORKFLOW_FAIL = '[ENTITY] Create All ProcessWorkflowModel failed',

	DELETE_PROCESS_WORKFLOW = '[ENTITY] Delete ProcessWorkflowModel',
	DELETE_PROCESS_WORKFLOW_OK = '[ENTITY] Delete ProcessWorkflowModel successfully',
	DELETE_PROCESS_WORKFLOW_FAIL = '[ENTITY] Delete ProcessWorkflowModel failed',


	DELETE_PROCESS_WORKFLOW_EXCLUDING_IDS = '[ENTITY] Delete ProcessWorkflowModels Excluding Ids',
	DELETE_PROCESS_WORKFLOW_EXCLUDING_IDS_OK = '[ENTITY] Delete ProcessWorkflowModels Excluding Ids successfully',
	DELETE_PROCESS_WORKFLOW_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ProcessWorkflowModels Excluding Ids failed',

	DELETE_ALL_PROCESS_WORKFLOW = '[ENTITY] Delete all ProcessWorkflowModels',
	DELETE_ALL_PROCESS_WORKFLOW_OK = '[ENTITY] Delete all ProcessWorkflowModels successfully',
	DELETE_ALL_PROCESS_WORKFLOW_FAIL = '[ENTITY] Delete all ProcessWorkflowModels failed',

	UPDATE_PROCESS_WORKFLOW = '[ENTITY] Update ProcessWorkflowModel',
	UPDATE_PROCESS_WORKFLOW_OK = '[ENTITY] Update ProcessWorkflowModel successfully',
	UPDATE_PROCESS_WORKFLOW_FAIL = '[ENTITY] Update ProcessWorkflowModel failed',

	UPDATE_ALL_PROCESS_WORKFLOW = '[ENTITY] Update all ProcessWorkflowModel',
	UPDATE_ALL_PROCESS_WORKFLOW_OK = '[ENTITY] Update all ProcessWorkflowModel successfully',
	UPDATE_ALL_PROCESS_WORKFLOW_FAIL = '[ENTITY] Update all ProcessWorkflowModel failed',

	FETCH_PROCESS_WORKFLOW= '[ENTITY] Fetch ProcessWorkflowModel',
	FETCH_PROCESS_WORKFLOW_OK = '[ENTITY] Fetch ProcessWorkflowModel successfully',
	FETCH_PROCESS_WORKFLOW_FAIL = '[ENTITY] Fetch ProcessWorkflowModel failed',

	FETCH_PROCESS_WORKFLOW_AUDIT= '[ENTITY] Fetch ProcessWorkflowModel audit',
	FETCH_PROCESS_WORKFLOW_AUDIT_OK = '[ENTITY] Fetch ProcessWorkflowModel audit successfully',
	FETCH_PROCESS_WORKFLOW_AUDIT_FAIL = '[ENTITY] Fetch ProcessWorkflowModel audit failed',

	FETCH_PROCESS_WORKFLOW_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ProcessWorkflowModel audits by entity id',
	FETCH_PROCESS_WORKFLOW_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ProcessWorkflowModel audits by entity id successfully',
	FETCH_PROCESS_WORKFLOW_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ProcessWorkflowModel audits by entity id failed',

	FETCH_ALL_PROCESS_WORKFLOW = '[ENTITY] Fetch all ProcessWorkflowModel',
	FETCH_ALL_PROCESS_WORKFLOW_OK = '[ENTITY] Fetch all ProcessWorkflowModel successfully',
	FETCH_ALL_PROCESS_WORKFLOW_FAIL = '[ENTITY] Fetch all ProcessWorkflowModel failed',

	FETCH_PROCESS_WORKFLOW_WITH_QUERY = '[ENTITY] Fetch ProcessWorkflowModel with query',
	FETCH_PROCESS_WORKFLOW_WITH_QUERY_OK = '[ENTITY] Fetch ProcessWorkflowModel with query successfully',
	FETCH_PROCESS_WORKFLOW_WITH_QUERY_FAIL = '[ENTITY] Fetch ProcessWorkflowModel with query failed',

	FETCH_LAST_PROCESS_WORKFLOW_WITH_QUERY = '[ENTITY] Fetch last ProcessWorkflowModel with query',
	FETCH_LAST_PROCESS_WORKFLOW_WITH_QUERY_OK = '[ENTITY] Fetch last ProcessWorkflowModel with query successfully',
	FETCH_LAST_PROCESS_WORKFLOW_WITH_QUERY_FAIL = '[ENTITY] Fetch last ProcessWorkflowModel with query failed',

	EXPORT_PROCESS_WORKFLOW = '[ENTITY] Export ProcessWorkflowModel',
	EXPORT_PROCESS_WORKFLOW_OK = '[ENTITY] Export ProcessWorkflowModel successfully',
	EXPORT_PROCESS_WORKFLOW_FAIL = '[ENTITY] Export ProcessWorkflowModel failed',

	EXPORT_ALL_PROCESS_WORKFLOW = '[ENTITY] Export All ProcessWorkflowModels',
	EXPORT_ALL_PROCESS_WORKFLOW_OK = '[ENTITY] Export All ProcessWorkflowModels successfully',
	EXPORT_ALL_PROCESS_WORKFLOW_FAIL = '[ENTITY] Export All ProcessWorkflowModels failed',

	EXPORT_PROCESS_WORKFLOW_EXCLUDING_IDS = '[ENTITY] Export ProcessWorkflowModels excluding Ids',
	EXPORT_PROCESS_WORKFLOW_EXCLUDING_IDS_OK = '[ENTITY] Export ProcessWorkflowModel excluding Ids successfully',
	EXPORT_PROCESS_WORKFLOW_EXCLUDING_IDS_FAIL = '[ENTITY] Export ProcessWorkflowModel excluding Ids failed',

	COUNT_PROCESS_WORKFLOWS = '[ENTITY] Fetch number of ProcessWorkflowModel records',
	COUNT_PROCESS_WORKFLOWS_OK = '[ENTITY] Fetch number of ProcessWorkflowModel records successfully ',
	COUNT_PROCESS_WORKFLOWS_FAIL = '[ENTITY] Fetch number of ProcessWorkflowModel records failed',

	IMPORT_PROCESS_WORKFLOWS = '[ENTITY] Import ProcessWorkflowModels',
	IMPORT_PROCESS_WORKFLOWS_OK = '[ENTITY] Import ProcessWorkflowModels successfully',
	IMPORT_PROCESS_WORKFLOWS_FAIL = '[ENTITY] Import ProcessWorkflowModels fail',


	INITIALISE_PROCESS_WORKFLOW_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ProcessWorkflowModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseProcessWorkflowAction implements Action {
	readonly className: string = 'ProcessWorkflowModel';

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

export class ProcessWorkflowAction extends BaseProcessWorkflowAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ProcessWorkflowAction here] off begin
	// % protected region % [Add any additional class fields for ProcessWorkflowAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ProcessWorkflowModel>,
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowAction here] off begin
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowAction here] off begin
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ProcessWorkflowAction here] off begin
		// % protected region % [Add any additional constructor logic for ProcessWorkflowAction here] end
	}

	// % protected region % [Add any additional class methods for ProcessWorkflowAction here] off begin
	// % protected region % [Add any additional class methods for ProcessWorkflowAction here] end
}

export class ProcessWorkflowActionOK extends BaseProcessWorkflowAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ProcessWorkflowActionOK here] off begin
	// % protected region % [Add any additional class fields for ProcessWorkflowActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ProcessWorkflowModel>,
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ProcessWorkflowModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ProcessWorkflowActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ProcessWorkflowActionOK here] end
	}

	// % protected region % [Add any additional class methods for ProcessWorkflowActionOK here] off begin
	// % protected region % [Add any additional class methods for ProcessWorkflowActionOK here] end
}

export class ProcessWorkflowActionFail extends BaseProcessWorkflowAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ProcessWorkflowActionFail here] off begin
	// % protected region % [Add any additional class fields for ProcessWorkflowActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ProcessWorkflowModel>,
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ProcessWorkflowActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ProcessWorkflowActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ProcessWorkflowActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ProcessWorkflowActionFail here] end
	}

	// % protected region % [Add any additional class methods for ProcessWorkflowActionFail here] off begin
	// % protected region % [Add any additional class methods for ProcessWorkflowActionFail here] end
}

export function isProcessWorkflowModelAction(e: any): e is BaseProcessWorkflowAction {
	return Object.values(ProcessWorkflowModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
