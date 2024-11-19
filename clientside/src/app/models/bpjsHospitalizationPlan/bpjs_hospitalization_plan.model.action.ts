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
import {BpjsHospitalizationPlanModel} from './bpjs_hospitalization_plan.model';
import {BpjsHospitalizationPlanModelAudit} from './bpjs_hospitalization_plan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Hospitalization Plan model actions to be dispatched by NgRx.
 */
export enum BpjsHospitalizationPlanModelActionTypes {
	CREATE_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Create BpjsHospitalizationPlanModel',
	CREATE_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Create BpjsHospitalizationPlanModel successfully',
	CREATE_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Create BpjsHospitalizationPlanModel failed',

	CREATE_ALL_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Create All BpjsHospitalizationPlanModel',
	CREATE_ALL_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Create All BpjsHospitalizationPlanModel successfully',
	CREATE_ALL_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Create All BpjsHospitalizationPlanModel failed',

	DELETE_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Delete BpjsHospitalizationPlanModel',
	DELETE_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Delete BpjsHospitalizationPlanModel successfully',
	DELETE_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Delete BpjsHospitalizationPlanModel failed',


	DELETE_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsHospitalizationPlanModels Excluding Ids',
	DELETE_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsHospitalizationPlanModels Excluding Ids successfully',
	DELETE_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsHospitalizationPlanModels Excluding Ids failed',

	DELETE_ALL_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Delete all BpjsHospitalizationPlanModels',
	DELETE_ALL_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Delete all BpjsHospitalizationPlanModels successfully',
	DELETE_ALL_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Delete all BpjsHospitalizationPlanModels failed',

	UPDATE_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Update BpjsHospitalizationPlanModel',
	UPDATE_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Update BpjsHospitalizationPlanModel successfully',
	UPDATE_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Update BpjsHospitalizationPlanModel failed',

	UPDATE_ALL_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Update all BpjsHospitalizationPlanModel',
	UPDATE_ALL_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Update all BpjsHospitalizationPlanModel successfully',
	UPDATE_ALL_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Update all BpjsHospitalizationPlanModel failed',

	FETCH_BPJS_HOSPITALIZATION_PLAN= '[ENTITY] Fetch BpjsHospitalizationPlanModel',
	FETCH_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Fetch BpjsHospitalizationPlanModel successfully',
	FETCH_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Fetch BpjsHospitalizationPlanModel failed',

	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDIT= '[ENTITY] Fetch BpjsHospitalizationPlanModel audit',
	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDIT_OK = '[ENTITY] Fetch BpjsHospitalizationPlanModel audit successfully',
	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsHospitalizationPlanModel audit failed',

	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsHospitalizationPlanModel audits by entity id',
	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsHospitalizationPlanModel audits by entity id successfully',
	FETCH_BPJS_HOSPITALIZATION_PLAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsHospitalizationPlanModel audits by entity id failed',

	FETCH_ALL_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Fetch all BpjsHospitalizationPlanModel',
	FETCH_ALL_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Fetch all BpjsHospitalizationPlanModel successfully',
	FETCH_ALL_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Fetch all BpjsHospitalizationPlanModel failed',

	FETCH_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY = '[ENTITY] Fetch BpjsHospitalizationPlanModel with query',
	FETCH_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsHospitalizationPlanModel with query successfully',
	FETCH_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsHospitalizationPlanModel with query failed',

	FETCH_LAST_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY = '[ENTITY] Fetch last BpjsHospitalizationPlanModel with query',
	FETCH_LAST_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsHospitalizationPlanModel with query successfully',
	FETCH_LAST_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsHospitalizationPlanModel with query failed',

	EXPORT_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Export BpjsHospitalizationPlanModel',
	EXPORT_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Export BpjsHospitalizationPlanModel successfully',
	EXPORT_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Export BpjsHospitalizationPlanModel failed',

	EXPORT_ALL_BPJS_HOSPITALIZATION_PLAN = '[ENTITY] Export All BpjsHospitalizationPlanModels',
	EXPORT_ALL_BPJS_HOSPITALIZATION_PLAN_OK = '[ENTITY] Export All BpjsHospitalizationPlanModels successfully',
	EXPORT_ALL_BPJS_HOSPITALIZATION_PLAN_FAIL = '[ENTITY] Export All BpjsHospitalizationPlanModels failed',

	EXPORT_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS = '[ENTITY] Export BpjsHospitalizationPlanModels excluding Ids',
	EXPORT_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsHospitalizationPlanModel excluding Ids successfully',
	EXPORT_BPJS_HOSPITALIZATION_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsHospitalizationPlanModel excluding Ids failed',

	COUNT_BPJS_HOSPITALIZATION_PLANS = '[ENTITY] Fetch number of BpjsHospitalizationPlanModel records',
	COUNT_BPJS_HOSPITALIZATION_PLANS_OK = '[ENTITY] Fetch number of BpjsHospitalizationPlanModel records successfully ',
	COUNT_BPJS_HOSPITALIZATION_PLANS_FAIL = '[ENTITY] Fetch number of BpjsHospitalizationPlanModel records failed',

	IMPORT_BPJS_HOSPITALIZATION_PLANS = '[ENTITY] Import BpjsHospitalizationPlanModels',
	IMPORT_BPJS_HOSPITALIZATION_PLANS_OK = '[ENTITY] Import BpjsHospitalizationPlanModels successfully',
	IMPORT_BPJS_HOSPITALIZATION_PLANS_FAIL = '[ENTITY] Import BpjsHospitalizationPlanModels fail',


	INITIALISE_BPJS_HOSPITALIZATION_PLAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsHospitalizationPlanModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsHospitalizationPlanAction implements Action {
	readonly className: string = 'BpjsHospitalizationPlanModel';

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

export class BpjsHospitalizationPlanAction extends BaseBpjsHospitalizationPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanAction here] off begin
	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsHospitalizationPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanAction here] off begin
	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanAction here] end
}

export class BpjsHospitalizationPlanActionOK extends BaseBpjsHospitalizationPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsHospitalizationPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsHospitalizationPlanModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanActionOK here] end
}

export class BpjsHospitalizationPlanActionFail extends BaseBpjsHospitalizationPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsHospitalizationPlanActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsHospitalizationPlanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHospitalizationPlanActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHospitalizationPlanActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHospitalizationPlanActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsHospitalizationPlanActionFail here] end
}

export function isBpjsHospitalizationPlanModelAction(e: any): e is BaseBpjsHospitalizationPlanAction {
	return Object.values(BpjsHospitalizationPlanModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
