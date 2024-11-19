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
import {ServiceItemAssignmentModel} from './service_item_assignment.model';
import {ServiceItemAssignmentModelAudit} from './service_item_assignment.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Service Item Assignment model actions to be dispatched by NgRx.
 */
export enum ServiceItemAssignmentModelActionTypes {
	CREATE_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Create ServiceItemAssignmentModel',
	CREATE_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Create ServiceItemAssignmentModel successfully',
	CREATE_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Create ServiceItemAssignmentModel failed',

	CREATE_ALL_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Create All ServiceItemAssignmentModel',
	CREATE_ALL_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Create All ServiceItemAssignmentModel successfully',
	CREATE_ALL_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Create All ServiceItemAssignmentModel failed',

	DELETE_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Delete ServiceItemAssignmentModel',
	DELETE_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Delete ServiceItemAssignmentModel successfully',
	DELETE_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Delete ServiceItemAssignmentModel failed',


	DELETE_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS = '[ENTITY] Delete ServiceItemAssignmentModels Excluding Ids',
	DELETE_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete ServiceItemAssignmentModels Excluding Ids successfully',
	DELETE_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ServiceItemAssignmentModels Excluding Ids failed',

	DELETE_ALL_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Delete all ServiceItemAssignmentModels',
	DELETE_ALL_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Delete all ServiceItemAssignmentModels successfully',
	DELETE_ALL_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Delete all ServiceItemAssignmentModels failed',

	UPDATE_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Update ServiceItemAssignmentModel',
	UPDATE_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Update ServiceItemAssignmentModel successfully',
	UPDATE_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Update ServiceItemAssignmentModel failed',

	UPDATE_ALL_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Update all ServiceItemAssignmentModel',
	UPDATE_ALL_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Update all ServiceItemAssignmentModel successfully',
	UPDATE_ALL_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Update all ServiceItemAssignmentModel failed',

	FETCH_SERVICE_ITEM_ASSIGNMENT= '[ENTITY] Fetch ServiceItemAssignmentModel',
	FETCH_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Fetch ServiceItemAssignmentModel successfully',
	FETCH_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Fetch ServiceItemAssignmentModel failed',

	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDIT= '[ENTITY] Fetch ServiceItemAssignmentModel audit',
	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDIT_OK = '[ENTITY] Fetch ServiceItemAssignmentModel audit successfully',
	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDIT_FAIL = '[ENTITY] Fetch ServiceItemAssignmentModel audit failed',

	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ServiceItemAssignmentModel audits by entity id',
	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ServiceItemAssignmentModel audits by entity id successfully',
	FETCH_SERVICE_ITEM_ASSIGNMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ServiceItemAssignmentModel audits by entity id failed',

	FETCH_ALL_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Fetch all ServiceItemAssignmentModel',
	FETCH_ALL_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Fetch all ServiceItemAssignmentModel successfully',
	FETCH_ALL_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Fetch all ServiceItemAssignmentModel failed',

	FETCH_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY = '[ENTITY] Fetch ServiceItemAssignmentModel with query',
	FETCH_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY_OK = '[ENTITY] Fetch ServiceItemAssignmentModel with query successfully',
	FETCH_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch ServiceItemAssignmentModel with query failed',

	FETCH_LAST_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY = '[ENTITY] Fetch last ServiceItemAssignmentModel with query',
	FETCH_LAST_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY_OK = '[ENTITY] Fetch last ServiceItemAssignmentModel with query successfully',
	FETCH_LAST_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last ServiceItemAssignmentModel with query failed',

	EXPORT_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Export ServiceItemAssignmentModel',
	EXPORT_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Export ServiceItemAssignmentModel successfully',
	EXPORT_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Export ServiceItemAssignmentModel failed',

	EXPORT_ALL_SERVICE_ITEM_ASSIGNMENT = '[ENTITY] Export All ServiceItemAssignmentModels',
	EXPORT_ALL_SERVICE_ITEM_ASSIGNMENT_OK = '[ENTITY] Export All ServiceItemAssignmentModels successfully',
	EXPORT_ALL_SERVICE_ITEM_ASSIGNMENT_FAIL = '[ENTITY] Export All ServiceItemAssignmentModels failed',

	EXPORT_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS = '[ENTITY] Export ServiceItemAssignmentModels excluding Ids',
	EXPORT_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS_OK = '[ENTITY] Export ServiceItemAssignmentModel excluding Ids successfully',
	EXPORT_SERVICE_ITEM_ASSIGNMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export ServiceItemAssignmentModel excluding Ids failed',

	COUNT_SERVICE_ITEM_ASSIGNMENTS = '[ENTITY] Fetch number of ServiceItemAssignmentModel records',
	COUNT_SERVICE_ITEM_ASSIGNMENTS_OK = '[ENTITY] Fetch number of ServiceItemAssignmentModel records successfully ',
	COUNT_SERVICE_ITEM_ASSIGNMENTS_FAIL = '[ENTITY] Fetch number of ServiceItemAssignmentModel records failed',

	IMPORT_SERVICE_ITEM_ASSIGNMENTS = '[ENTITY] Import ServiceItemAssignmentModels',
	IMPORT_SERVICE_ITEM_ASSIGNMENTS_OK = '[ENTITY] Import ServiceItemAssignmentModels successfully',
	IMPORT_SERVICE_ITEM_ASSIGNMENTS_FAIL = '[ENTITY] Import ServiceItemAssignmentModels fail',


	INITIALISE_SERVICE_ITEM_ASSIGNMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ServiceItemAssignmentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseServiceItemAssignmentAction implements Action {
	readonly className: string = 'ServiceItemAssignmentModel';

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

export class ServiceItemAssignmentAction extends BaseServiceItemAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemAssignmentAction here] off begin
	// % protected region % [Add any additional class fields for ServiceItemAssignmentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceItemAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentAction here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentAction here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentAction here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentAction here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemAssignmentAction here] off begin
	// % protected region % [Add any additional class methods for ServiceItemAssignmentAction here] end
}

export class ServiceItemAssignmentActionOK extends BaseServiceItemAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemAssignmentActionOK here] off begin
	// % protected region % [Add any additional class fields for ServiceItemAssignmentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceItemAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ServiceItemAssignmentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentActionOK here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemAssignmentActionOK here] off begin
	// % protected region % [Add any additional class methods for ServiceItemAssignmentActionOK here] end
}

export class ServiceItemAssignmentActionFail extends BaseServiceItemAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemAssignmentActionFail here] off begin
	// % protected region % [Add any additional class fields for ServiceItemAssignmentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ServiceItemAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemAssignmentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemAssignmentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemAssignmentActionFail here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemAssignmentActionFail here] off begin
	// % protected region % [Add any additional class methods for ServiceItemAssignmentActionFail here] end
}

export function isServiceItemAssignmentModelAction(e: any): e is BaseServiceItemAssignmentAction {
	return Object.values(ServiceItemAssignmentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
