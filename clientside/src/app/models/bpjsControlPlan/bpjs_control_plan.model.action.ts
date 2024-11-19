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
import {BpjsControlPlanModel} from './bpjs_control_plan.model';
import {BpjsControlPlanModelAudit} from './bpjs_control_plan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Control Plan model actions to be dispatched by NgRx.
 */
export enum BpjsControlPlanModelActionTypes {
	CREATE_BPJS_CONTROL_PLAN = '[ENTITY] Create BpjsControlPlanModel',
	CREATE_BPJS_CONTROL_PLAN_OK = '[ENTITY] Create BpjsControlPlanModel successfully',
	CREATE_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Create BpjsControlPlanModel failed',

	CREATE_ALL_BPJS_CONTROL_PLAN = '[ENTITY] Create All BpjsControlPlanModel',
	CREATE_ALL_BPJS_CONTROL_PLAN_OK = '[ENTITY] Create All BpjsControlPlanModel successfully',
	CREATE_ALL_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Create All BpjsControlPlanModel failed',

	DELETE_BPJS_CONTROL_PLAN = '[ENTITY] Delete BpjsControlPlanModel',
	DELETE_BPJS_CONTROL_PLAN_OK = '[ENTITY] Delete BpjsControlPlanModel successfully',
	DELETE_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Delete BpjsControlPlanModel failed',


	DELETE_BPJS_CONTROL_PLAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsControlPlanModels Excluding Ids',
	DELETE_BPJS_CONTROL_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsControlPlanModels Excluding Ids successfully',
	DELETE_BPJS_CONTROL_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsControlPlanModels Excluding Ids failed',

	DELETE_ALL_BPJS_CONTROL_PLAN = '[ENTITY] Delete all BpjsControlPlanModels',
	DELETE_ALL_BPJS_CONTROL_PLAN_OK = '[ENTITY] Delete all BpjsControlPlanModels successfully',
	DELETE_ALL_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Delete all BpjsControlPlanModels failed',

	UPDATE_BPJS_CONTROL_PLAN = '[ENTITY] Update BpjsControlPlanModel',
	UPDATE_BPJS_CONTROL_PLAN_OK = '[ENTITY] Update BpjsControlPlanModel successfully',
	UPDATE_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Update BpjsControlPlanModel failed',

	UPDATE_ALL_BPJS_CONTROL_PLAN = '[ENTITY] Update all BpjsControlPlanModel',
	UPDATE_ALL_BPJS_CONTROL_PLAN_OK = '[ENTITY] Update all BpjsControlPlanModel successfully',
	UPDATE_ALL_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Update all BpjsControlPlanModel failed',

	FETCH_BPJS_CONTROL_PLAN= '[ENTITY] Fetch BpjsControlPlanModel',
	FETCH_BPJS_CONTROL_PLAN_OK = '[ENTITY] Fetch BpjsControlPlanModel successfully',
	FETCH_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Fetch BpjsControlPlanModel failed',

	FETCH_BPJS_CONTROL_PLAN_AUDIT= '[ENTITY] Fetch BpjsControlPlanModel audit',
	FETCH_BPJS_CONTROL_PLAN_AUDIT_OK = '[ENTITY] Fetch BpjsControlPlanModel audit successfully',
	FETCH_BPJS_CONTROL_PLAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsControlPlanModel audit failed',

	FETCH_BPJS_CONTROL_PLAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsControlPlanModel audits by entity id',
	FETCH_BPJS_CONTROL_PLAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsControlPlanModel audits by entity id successfully',
	FETCH_BPJS_CONTROL_PLAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsControlPlanModel audits by entity id failed',

	FETCH_ALL_BPJS_CONTROL_PLAN = '[ENTITY] Fetch all BpjsControlPlanModel',
	FETCH_ALL_BPJS_CONTROL_PLAN_OK = '[ENTITY] Fetch all BpjsControlPlanModel successfully',
	FETCH_ALL_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Fetch all BpjsControlPlanModel failed',

	FETCH_BPJS_CONTROL_PLAN_WITH_QUERY = '[ENTITY] Fetch BpjsControlPlanModel with query',
	FETCH_BPJS_CONTROL_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsControlPlanModel with query successfully',
	FETCH_BPJS_CONTROL_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsControlPlanModel with query failed',

	FETCH_LAST_BPJS_CONTROL_PLAN_WITH_QUERY = '[ENTITY] Fetch last BpjsControlPlanModel with query',
	FETCH_LAST_BPJS_CONTROL_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsControlPlanModel with query successfully',
	FETCH_LAST_BPJS_CONTROL_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsControlPlanModel with query failed',

	EXPORT_BPJS_CONTROL_PLAN = '[ENTITY] Export BpjsControlPlanModel',
	EXPORT_BPJS_CONTROL_PLAN_OK = '[ENTITY] Export BpjsControlPlanModel successfully',
	EXPORT_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Export BpjsControlPlanModel failed',

	EXPORT_ALL_BPJS_CONTROL_PLAN = '[ENTITY] Export All BpjsControlPlanModels',
	EXPORT_ALL_BPJS_CONTROL_PLAN_OK = '[ENTITY] Export All BpjsControlPlanModels successfully',
	EXPORT_ALL_BPJS_CONTROL_PLAN_FAIL = '[ENTITY] Export All BpjsControlPlanModels failed',

	EXPORT_BPJS_CONTROL_PLAN_EXCLUDING_IDS = '[ENTITY] Export BpjsControlPlanModels excluding Ids',
	EXPORT_BPJS_CONTROL_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsControlPlanModel excluding Ids successfully',
	EXPORT_BPJS_CONTROL_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsControlPlanModel excluding Ids failed',

	COUNT_BPJS_CONTROL_PLANS = '[ENTITY] Fetch number of BpjsControlPlanModel records',
	COUNT_BPJS_CONTROL_PLANS_OK = '[ENTITY] Fetch number of BpjsControlPlanModel records successfully ',
	COUNT_BPJS_CONTROL_PLANS_FAIL = '[ENTITY] Fetch number of BpjsControlPlanModel records failed',

	IMPORT_BPJS_CONTROL_PLANS = '[ENTITY] Import BpjsControlPlanModels',
	IMPORT_BPJS_CONTROL_PLANS_OK = '[ENTITY] Import BpjsControlPlanModels successfully',
	IMPORT_BPJS_CONTROL_PLANS_FAIL = '[ENTITY] Import BpjsControlPlanModels fail',


	INITIALISE_BPJS_CONTROL_PLAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsControlPlanModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsControlPlanAction implements Action {
	readonly className: string = 'BpjsControlPlanModel';

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

export class BpjsControlPlanAction extends BaseBpjsControlPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlPlanAction here] off begin
	// % protected region % [Add any additional class fields for BpjsControlPlanAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsControlPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlPlanAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlPlanAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlPlanAction here] off begin
	// % protected region % [Add any additional class methods for BpjsControlPlanAction here] end
}

export class BpjsControlPlanActionOK extends BaseBpjsControlPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlPlanActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsControlPlanActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsControlPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsControlPlanModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlPlanActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlPlanActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlPlanActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsControlPlanActionOK here] end
}

export class BpjsControlPlanActionFail extends BaseBpjsControlPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlPlanActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsControlPlanActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsControlPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlPlanActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlPlanActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlPlanActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlPlanActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlPlanActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsControlPlanActionFail here] end
}

export function isBpjsControlPlanModelAction(e: any): e is BaseBpjsControlPlanAction {
	return Object.values(BpjsControlPlanModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
