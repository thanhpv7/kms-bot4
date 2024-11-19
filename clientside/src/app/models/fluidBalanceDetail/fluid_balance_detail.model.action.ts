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
import {FluidBalanceDetailModel} from './fluid_balance_detail.model';
import {FluidBalanceDetailModelAudit} from './fluid_balance_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Fluid Balance Detail model actions to be dispatched by NgRx.
 */
export enum FluidBalanceDetailModelActionTypes {
	CREATE_FLUID_BALANCE_DETAIL = '[ENTITY] Create FluidBalanceDetailModel',
	CREATE_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Create FluidBalanceDetailModel successfully',
	CREATE_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Create FluidBalanceDetailModel failed',

	CREATE_ALL_FLUID_BALANCE_DETAIL = '[ENTITY] Create All FluidBalanceDetailModel',
	CREATE_ALL_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Create All FluidBalanceDetailModel successfully',
	CREATE_ALL_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Create All FluidBalanceDetailModel failed',

	DELETE_FLUID_BALANCE_DETAIL = '[ENTITY] Delete FluidBalanceDetailModel',
	DELETE_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Delete FluidBalanceDetailModel successfully',
	DELETE_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Delete FluidBalanceDetailModel failed',


	DELETE_FLUID_BALANCE_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete FluidBalanceDetailModels Excluding Ids',
	DELETE_FLUID_BALANCE_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete FluidBalanceDetailModels Excluding Ids successfully',
	DELETE_FLUID_BALANCE_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete FluidBalanceDetailModels Excluding Ids failed',

	DELETE_ALL_FLUID_BALANCE_DETAIL = '[ENTITY] Delete all FluidBalanceDetailModels',
	DELETE_ALL_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Delete all FluidBalanceDetailModels successfully',
	DELETE_ALL_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Delete all FluidBalanceDetailModels failed',

	UPDATE_FLUID_BALANCE_DETAIL = '[ENTITY] Update FluidBalanceDetailModel',
	UPDATE_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Update FluidBalanceDetailModel successfully',
	UPDATE_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Update FluidBalanceDetailModel failed',

	UPDATE_ALL_FLUID_BALANCE_DETAIL = '[ENTITY] Update all FluidBalanceDetailModel',
	UPDATE_ALL_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Update all FluidBalanceDetailModel successfully',
	UPDATE_ALL_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Update all FluidBalanceDetailModel failed',

	FETCH_FLUID_BALANCE_DETAIL= '[ENTITY] Fetch FluidBalanceDetailModel',
	FETCH_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Fetch FluidBalanceDetailModel successfully',
	FETCH_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Fetch FluidBalanceDetailModel failed',

	FETCH_FLUID_BALANCE_DETAIL_AUDIT= '[ENTITY] Fetch FluidBalanceDetailModel audit',
	FETCH_FLUID_BALANCE_DETAIL_AUDIT_OK = '[ENTITY] Fetch FluidBalanceDetailModel audit successfully',
	FETCH_FLUID_BALANCE_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch FluidBalanceDetailModel audit failed',

	FETCH_FLUID_BALANCE_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch FluidBalanceDetailModel audits by entity id',
	FETCH_FLUID_BALANCE_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch FluidBalanceDetailModel audits by entity id successfully',
	FETCH_FLUID_BALANCE_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch FluidBalanceDetailModel audits by entity id failed',

	FETCH_ALL_FLUID_BALANCE_DETAIL = '[ENTITY] Fetch all FluidBalanceDetailModel',
	FETCH_ALL_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Fetch all FluidBalanceDetailModel successfully',
	FETCH_ALL_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Fetch all FluidBalanceDetailModel failed',

	FETCH_FLUID_BALANCE_DETAIL_WITH_QUERY = '[ENTITY] Fetch FluidBalanceDetailModel with query',
	FETCH_FLUID_BALANCE_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch FluidBalanceDetailModel with query successfully',
	FETCH_FLUID_BALANCE_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch FluidBalanceDetailModel with query failed',

	FETCH_LAST_FLUID_BALANCE_DETAIL_WITH_QUERY = '[ENTITY] Fetch last FluidBalanceDetailModel with query',
	FETCH_LAST_FLUID_BALANCE_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last FluidBalanceDetailModel with query successfully',
	FETCH_LAST_FLUID_BALANCE_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last FluidBalanceDetailModel with query failed',

	EXPORT_FLUID_BALANCE_DETAIL = '[ENTITY] Export FluidBalanceDetailModel',
	EXPORT_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Export FluidBalanceDetailModel successfully',
	EXPORT_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Export FluidBalanceDetailModel failed',

	EXPORT_ALL_FLUID_BALANCE_DETAIL = '[ENTITY] Export All FluidBalanceDetailModels',
	EXPORT_ALL_FLUID_BALANCE_DETAIL_OK = '[ENTITY] Export All FluidBalanceDetailModels successfully',
	EXPORT_ALL_FLUID_BALANCE_DETAIL_FAIL = '[ENTITY] Export All FluidBalanceDetailModels failed',

	EXPORT_FLUID_BALANCE_DETAIL_EXCLUDING_IDS = '[ENTITY] Export FluidBalanceDetailModels excluding Ids',
	EXPORT_FLUID_BALANCE_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export FluidBalanceDetailModel excluding Ids successfully',
	EXPORT_FLUID_BALANCE_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export FluidBalanceDetailModel excluding Ids failed',

	COUNT_FLUID_BALANCE_DETAILS = '[ENTITY] Fetch number of FluidBalanceDetailModel records',
	COUNT_FLUID_BALANCE_DETAILS_OK = '[ENTITY] Fetch number of FluidBalanceDetailModel records successfully ',
	COUNT_FLUID_BALANCE_DETAILS_FAIL = '[ENTITY] Fetch number of FluidBalanceDetailModel records failed',

	IMPORT_FLUID_BALANCE_DETAILS = '[ENTITY] Import FluidBalanceDetailModels',
	IMPORT_FLUID_BALANCE_DETAILS_OK = '[ENTITY] Import FluidBalanceDetailModels successfully',
	IMPORT_FLUID_BALANCE_DETAILS_FAIL = '[ENTITY] Import FluidBalanceDetailModels fail',


	INITIALISE_FLUID_BALANCE_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of FluidBalanceDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseFluidBalanceDetailAction implements Action {
	readonly className: string = 'FluidBalanceDetailModel';

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

export class FluidBalanceDetailAction extends BaseFluidBalanceDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FluidBalanceDetailAction here] off begin
	// % protected region % [Add any additional class fields for FluidBalanceDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FluidBalanceDetailModel>,
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailAction here] end
	}

	// % protected region % [Add any additional class methods for FluidBalanceDetailAction here] off begin
	// % protected region % [Add any additional class methods for FluidBalanceDetailAction here] end
}

export class FluidBalanceDetailActionOK extends BaseFluidBalanceDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FluidBalanceDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for FluidBalanceDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FluidBalanceDetailModel>,
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: FluidBalanceDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for FluidBalanceDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for FluidBalanceDetailActionOK here] end
}

export class FluidBalanceDetailActionFail extends BaseFluidBalanceDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FluidBalanceDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for FluidBalanceDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<FluidBalanceDetailModel>,
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for FluidBalanceDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for FluidBalanceDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for FluidBalanceDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for FluidBalanceDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for FluidBalanceDetailActionFail here] end
}

export function isFluidBalanceDetailModelAction(e: any): e is BaseFluidBalanceDetailAction {
	return Object.values(FluidBalanceDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
