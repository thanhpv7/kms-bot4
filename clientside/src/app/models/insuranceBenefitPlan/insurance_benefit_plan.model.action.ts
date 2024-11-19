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
import {InsuranceBenefitPlanModel} from './insurance_benefit_plan.model';
import {InsuranceBenefitPlanModelAudit} from './insurance_benefit_plan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Insurance Benefit Plan model actions to be dispatched by NgRx.
 */
export enum InsuranceBenefitPlanModelActionTypes {
	CREATE_INSURANCE_BENEFIT_PLAN = '[ENTITY] Create InsuranceBenefitPlanModel',
	CREATE_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Create InsuranceBenefitPlanModel successfully',
	CREATE_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Create InsuranceBenefitPlanModel failed',

	CREATE_ALL_INSURANCE_BENEFIT_PLAN = '[ENTITY] Create All InsuranceBenefitPlanModel',
	CREATE_ALL_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Create All InsuranceBenefitPlanModel successfully',
	CREATE_ALL_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Create All InsuranceBenefitPlanModel failed',

	DELETE_INSURANCE_BENEFIT_PLAN = '[ENTITY] Delete InsuranceBenefitPlanModel',
	DELETE_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Delete InsuranceBenefitPlanModel successfully',
	DELETE_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Delete InsuranceBenefitPlanModel failed',


	DELETE_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS = '[ENTITY] Delete InsuranceBenefitPlanModels Excluding Ids',
	DELETE_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Delete InsuranceBenefitPlanModels Excluding Ids successfully',
	DELETE_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InsuranceBenefitPlanModels Excluding Ids failed',

	DELETE_ALL_INSURANCE_BENEFIT_PLAN = '[ENTITY] Delete all InsuranceBenefitPlanModels',
	DELETE_ALL_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Delete all InsuranceBenefitPlanModels successfully',
	DELETE_ALL_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Delete all InsuranceBenefitPlanModels failed',

	UPDATE_INSURANCE_BENEFIT_PLAN = '[ENTITY] Update InsuranceBenefitPlanModel',
	UPDATE_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Update InsuranceBenefitPlanModel successfully',
	UPDATE_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Update InsuranceBenefitPlanModel failed',

	UPDATE_ALL_INSURANCE_BENEFIT_PLAN = '[ENTITY] Update all InsuranceBenefitPlanModel',
	UPDATE_ALL_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Update all InsuranceBenefitPlanModel successfully',
	UPDATE_ALL_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Update all InsuranceBenefitPlanModel failed',

	FETCH_INSURANCE_BENEFIT_PLAN= '[ENTITY] Fetch InsuranceBenefitPlanModel',
	FETCH_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Fetch InsuranceBenefitPlanModel successfully',
	FETCH_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Fetch InsuranceBenefitPlanModel failed',

	FETCH_INSURANCE_BENEFIT_PLAN_AUDIT= '[ENTITY] Fetch InsuranceBenefitPlanModel audit',
	FETCH_INSURANCE_BENEFIT_PLAN_AUDIT_OK = '[ENTITY] Fetch InsuranceBenefitPlanModel audit successfully',
	FETCH_INSURANCE_BENEFIT_PLAN_AUDIT_FAIL = '[ENTITY] Fetch InsuranceBenefitPlanModel audit failed',

	FETCH_INSURANCE_BENEFIT_PLAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InsuranceBenefitPlanModel audits by entity id',
	FETCH_INSURANCE_BENEFIT_PLAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InsuranceBenefitPlanModel audits by entity id successfully',
	FETCH_INSURANCE_BENEFIT_PLAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InsuranceBenefitPlanModel audits by entity id failed',

	FETCH_ALL_INSURANCE_BENEFIT_PLAN = '[ENTITY] Fetch all InsuranceBenefitPlanModel',
	FETCH_ALL_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Fetch all InsuranceBenefitPlanModel successfully',
	FETCH_ALL_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Fetch all InsuranceBenefitPlanModel failed',

	FETCH_INSURANCE_BENEFIT_PLAN_WITH_QUERY = '[ENTITY] Fetch InsuranceBenefitPlanModel with query',
	FETCH_INSURANCE_BENEFIT_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch InsuranceBenefitPlanModel with query successfully',
	FETCH_INSURANCE_BENEFIT_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch InsuranceBenefitPlanModel with query failed',

	FETCH_LAST_INSURANCE_BENEFIT_PLAN_WITH_QUERY = '[ENTITY] Fetch last InsuranceBenefitPlanModel with query',
	FETCH_LAST_INSURANCE_BENEFIT_PLAN_WITH_QUERY_OK = '[ENTITY] Fetch last InsuranceBenefitPlanModel with query successfully',
	FETCH_LAST_INSURANCE_BENEFIT_PLAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last InsuranceBenefitPlanModel with query failed',

	EXPORT_INSURANCE_BENEFIT_PLAN = '[ENTITY] Export InsuranceBenefitPlanModel',
	EXPORT_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Export InsuranceBenefitPlanModel successfully',
	EXPORT_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Export InsuranceBenefitPlanModel failed',

	EXPORT_ALL_INSURANCE_BENEFIT_PLAN = '[ENTITY] Export All InsuranceBenefitPlanModels',
	EXPORT_ALL_INSURANCE_BENEFIT_PLAN_OK = '[ENTITY] Export All InsuranceBenefitPlanModels successfully',
	EXPORT_ALL_INSURANCE_BENEFIT_PLAN_FAIL = '[ENTITY] Export All InsuranceBenefitPlanModels failed',

	EXPORT_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS = '[ENTITY] Export InsuranceBenefitPlanModels excluding Ids',
	EXPORT_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS_OK = '[ENTITY] Export InsuranceBenefitPlanModel excluding Ids successfully',
	EXPORT_INSURANCE_BENEFIT_PLAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export InsuranceBenefitPlanModel excluding Ids failed',

	COUNT_INSURANCE_BENEFIT_PLANS = '[ENTITY] Fetch number of InsuranceBenefitPlanModel records',
	COUNT_INSURANCE_BENEFIT_PLANS_OK = '[ENTITY] Fetch number of InsuranceBenefitPlanModel records successfully ',
	COUNT_INSURANCE_BENEFIT_PLANS_FAIL = '[ENTITY] Fetch number of InsuranceBenefitPlanModel records failed',

	IMPORT_INSURANCE_BENEFIT_PLANS = '[ENTITY] Import InsuranceBenefitPlanModels',
	IMPORT_INSURANCE_BENEFIT_PLANS_OK = '[ENTITY] Import InsuranceBenefitPlanModels successfully',
	IMPORT_INSURANCE_BENEFIT_PLANS_FAIL = '[ENTITY] Import InsuranceBenefitPlanModels fail',


	INITIALISE_INSURANCE_BENEFIT_PLAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InsuranceBenefitPlanModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInsuranceBenefitPlanAction implements Action {
	readonly className: string = 'InsuranceBenefitPlanModel';

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

export class InsuranceBenefitPlanAction extends BaseInsuranceBenefitPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceBenefitPlanAction here] off begin
	// % protected region % [Add any additional class fields for InsuranceBenefitPlanAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InsuranceBenefitPlanModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanAction here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanAction here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanAction here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanAction here] end
	}

	// % protected region % [Add any additional class methods for InsuranceBenefitPlanAction here] off begin
	// % protected region % [Add any additional class methods for InsuranceBenefitPlanAction here] end
}

export class InsuranceBenefitPlanActionOK extends BaseInsuranceBenefitPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceBenefitPlanActionOK here] off begin
	// % protected region % [Add any additional class fields for InsuranceBenefitPlanActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InsuranceBenefitPlanModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InsuranceBenefitPlanModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanActionOK here] end
	}

	// % protected region % [Add any additional class methods for InsuranceBenefitPlanActionOK here] off begin
	// % protected region % [Add any additional class methods for InsuranceBenefitPlanActionOK here] end
}

export class InsuranceBenefitPlanActionFail extends BaseInsuranceBenefitPlanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceBenefitPlanActionFail here] off begin
	// % protected region % [Add any additional class fields for InsuranceBenefitPlanActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InsuranceBenefitPlanModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceBenefitPlanActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceBenefitPlanActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceBenefitPlanActionFail here] end
	}

	// % protected region % [Add any additional class methods for InsuranceBenefitPlanActionFail here] off begin
	// % protected region % [Add any additional class methods for InsuranceBenefitPlanActionFail here] end
}

export function isInsuranceBenefitPlanModelAction(e: any): e is BaseInsuranceBenefitPlanAction {
	return Object.values(InsuranceBenefitPlanModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
