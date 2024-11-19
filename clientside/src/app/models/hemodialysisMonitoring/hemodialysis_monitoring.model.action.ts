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
import {HemodialysisMonitoringModel} from './hemodialysis_monitoring.model';
import {HemodialysisMonitoringModelAudit} from './hemodialysis_monitoring.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Hemodialysis Monitoring model actions to be dispatched by NgRx.
 */
export enum HemodialysisMonitoringModelActionTypes {
	CREATE_HEMODIALYSIS_MONITORING = '[ENTITY] Create HemodialysisMonitoringModel',
	CREATE_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Create HemodialysisMonitoringModel successfully',
	CREATE_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Create HemodialysisMonitoringModel failed',

	CREATE_ALL_HEMODIALYSIS_MONITORING = '[ENTITY] Create All HemodialysisMonitoringModel',
	CREATE_ALL_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Create All HemodialysisMonitoringModel successfully',
	CREATE_ALL_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Create All HemodialysisMonitoringModel failed',

	DELETE_HEMODIALYSIS_MONITORING = '[ENTITY] Delete HemodialysisMonitoringModel',
	DELETE_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Delete HemodialysisMonitoringModel successfully',
	DELETE_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Delete HemodialysisMonitoringModel failed',


	DELETE_HEMODIALYSIS_MONITORING_EXCLUDING_IDS = '[ENTITY] Delete HemodialysisMonitoringModels Excluding Ids',
	DELETE_HEMODIALYSIS_MONITORING_EXCLUDING_IDS_OK = '[ENTITY] Delete HemodialysisMonitoringModels Excluding Ids successfully',
	DELETE_HEMODIALYSIS_MONITORING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete HemodialysisMonitoringModels Excluding Ids failed',

	DELETE_ALL_HEMODIALYSIS_MONITORING = '[ENTITY] Delete all HemodialysisMonitoringModels',
	DELETE_ALL_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Delete all HemodialysisMonitoringModels successfully',
	DELETE_ALL_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Delete all HemodialysisMonitoringModels failed',

	UPDATE_HEMODIALYSIS_MONITORING = '[ENTITY] Update HemodialysisMonitoringModel',
	UPDATE_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Update HemodialysisMonitoringModel successfully',
	UPDATE_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Update HemodialysisMonitoringModel failed',

	UPDATE_ALL_HEMODIALYSIS_MONITORING = '[ENTITY] Update all HemodialysisMonitoringModel',
	UPDATE_ALL_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Update all HemodialysisMonitoringModel successfully',
	UPDATE_ALL_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Update all HemodialysisMonitoringModel failed',

	FETCH_HEMODIALYSIS_MONITORING= '[ENTITY] Fetch HemodialysisMonitoringModel',
	FETCH_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Fetch HemodialysisMonitoringModel successfully',
	FETCH_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Fetch HemodialysisMonitoringModel failed',

	FETCH_HEMODIALYSIS_MONITORING_AUDIT= '[ENTITY] Fetch HemodialysisMonitoringModel audit',
	FETCH_HEMODIALYSIS_MONITORING_AUDIT_OK = '[ENTITY] Fetch HemodialysisMonitoringModel audit successfully',
	FETCH_HEMODIALYSIS_MONITORING_AUDIT_FAIL = '[ENTITY] Fetch HemodialysisMonitoringModel audit failed',

	FETCH_HEMODIALYSIS_MONITORING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch HemodialysisMonitoringModel audits by entity id',
	FETCH_HEMODIALYSIS_MONITORING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch HemodialysisMonitoringModel audits by entity id successfully',
	FETCH_HEMODIALYSIS_MONITORING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch HemodialysisMonitoringModel audits by entity id failed',

	FETCH_ALL_HEMODIALYSIS_MONITORING = '[ENTITY] Fetch all HemodialysisMonitoringModel',
	FETCH_ALL_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Fetch all HemodialysisMonitoringModel successfully',
	FETCH_ALL_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Fetch all HemodialysisMonitoringModel failed',

	FETCH_HEMODIALYSIS_MONITORING_WITH_QUERY = '[ENTITY] Fetch HemodialysisMonitoringModel with query',
	FETCH_HEMODIALYSIS_MONITORING_WITH_QUERY_OK = '[ENTITY] Fetch HemodialysisMonitoringModel with query successfully',
	FETCH_HEMODIALYSIS_MONITORING_WITH_QUERY_FAIL = '[ENTITY] Fetch HemodialysisMonitoringModel with query failed',

	FETCH_LAST_HEMODIALYSIS_MONITORING_WITH_QUERY = '[ENTITY] Fetch last HemodialysisMonitoringModel with query',
	FETCH_LAST_HEMODIALYSIS_MONITORING_WITH_QUERY_OK = '[ENTITY] Fetch last HemodialysisMonitoringModel with query successfully',
	FETCH_LAST_HEMODIALYSIS_MONITORING_WITH_QUERY_FAIL = '[ENTITY] Fetch last HemodialysisMonitoringModel with query failed',

	EXPORT_HEMODIALYSIS_MONITORING = '[ENTITY] Export HemodialysisMonitoringModel',
	EXPORT_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Export HemodialysisMonitoringModel successfully',
	EXPORT_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Export HemodialysisMonitoringModel failed',

	EXPORT_ALL_HEMODIALYSIS_MONITORING = '[ENTITY] Export All HemodialysisMonitoringModels',
	EXPORT_ALL_HEMODIALYSIS_MONITORING_OK = '[ENTITY] Export All HemodialysisMonitoringModels successfully',
	EXPORT_ALL_HEMODIALYSIS_MONITORING_FAIL = '[ENTITY] Export All HemodialysisMonitoringModels failed',

	EXPORT_HEMODIALYSIS_MONITORING_EXCLUDING_IDS = '[ENTITY] Export HemodialysisMonitoringModels excluding Ids',
	EXPORT_HEMODIALYSIS_MONITORING_EXCLUDING_IDS_OK = '[ENTITY] Export HemodialysisMonitoringModel excluding Ids successfully',
	EXPORT_HEMODIALYSIS_MONITORING_EXCLUDING_IDS_FAIL = '[ENTITY] Export HemodialysisMonitoringModel excluding Ids failed',

	COUNT_HEMODIALYSIS_MONITORINGS = '[ENTITY] Fetch number of HemodialysisMonitoringModel records',
	COUNT_HEMODIALYSIS_MONITORINGS_OK = '[ENTITY] Fetch number of HemodialysisMonitoringModel records successfully ',
	COUNT_HEMODIALYSIS_MONITORINGS_FAIL = '[ENTITY] Fetch number of HemodialysisMonitoringModel records failed',

	IMPORT_HEMODIALYSIS_MONITORINGS = '[ENTITY] Import HemodialysisMonitoringModels',
	IMPORT_HEMODIALYSIS_MONITORINGS_OK = '[ENTITY] Import HemodialysisMonitoringModels successfully',
	IMPORT_HEMODIALYSIS_MONITORINGS_FAIL = '[ENTITY] Import HemodialysisMonitoringModels fail',


	INITIALISE_HEMODIALYSIS_MONITORING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of HemodialysisMonitoringModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseHemodialysisMonitoringAction implements Action {
	readonly className: string = 'HemodialysisMonitoringModel';

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

export class HemodialysisMonitoringAction extends BaseHemodialysisMonitoringAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisMonitoringAction here] off begin
	// % protected region % [Add any additional class fields for HemodialysisMonitoringAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HemodialysisMonitoringModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringAction here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringAction here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringAction here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringAction here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisMonitoringAction here] off begin
	// % protected region % [Add any additional class methods for HemodialysisMonitoringAction here] end
}

export class HemodialysisMonitoringActionOK extends BaseHemodialysisMonitoringAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisMonitoringActionOK here] off begin
	// % protected region % [Add any additional class fields for HemodialysisMonitoringActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HemodialysisMonitoringModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: HemodialysisMonitoringModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringActionOK here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringActionOK here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisMonitoringActionOK here] off begin
	// % protected region % [Add any additional class methods for HemodialysisMonitoringActionOK here] end
}

export class HemodialysisMonitoringActionFail extends BaseHemodialysisMonitoringAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisMonitoringActionFail here] off begin
	// % protected region % [Add any additional class fields for HemodialysisMonitoringActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<HemodialysisMonitoringModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisMonitoringActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisMonitoringActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringActionFail here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisMonitoringActionFail here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisMonitoringActionFail here] off begin
	// % protected region % [Add any additional class methods for HemodialysisMonitoringActionFail here] end
}

export function isHemodialysisMonitoringModelAction(e: any): e is BaseHemodialysisMonitoringAction {
	return Object.values(HemodialysisMonitoringModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
