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
import {VaccinationOrderModel} from './vaccination_order.model';
import {VaccinationOrderModelAudit} from './vaccination_order.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Vaccination Order model actions to be dispatched by NgRx.
 */
export enum VaccinationOrderModelActionTypes {
	CREATE_VACCINATION_ORDER = '[ENTITY] Create VaccinationOrderModel',
	CREATE_VACCINATION_ORDER_OK = '[ENTITY] Create VaccinationOrderModel successfully',
	CREATE_VACCINATION_ORDER_FAIL = '[ENTITY] Create VaccinationOrderModel failed',

	CREATE_ALL_VACCINATION_ORDER = '[ENTITY] Create All VaccinationOrderModel',
	CREATE_ALL_VACCINATION_ORDER_OK = '[ENTITY] Create All VaccinationOrderModel successfully',
	CREATE_ALL_VACCINATION_ORDER_FAIL = '[ENTITY] Create All VaccinationOrderModel failed',

	DELETE_VACCINATION_ORDER = '[ENTITY] Delete VaccinationOrderModel',
	DELETE_VACCINATION_ORDER_OK = '[ENTITY] Delete VaccinationOrderModel successfully',
	DELETE_VACCINATION_ORDER_FAIL = '[ENTITY] Delete VaccinationOrderModel failed',


	DELETE_VACCINATION_ORDER_EXCLUDING_IDS = '[ENTITY] Delete VaccinationOrderModels Excluding Ids',
	DELETE_VACCINATION_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Delete VaccinationOrderModels Excluding Ids successfully',
	DELETE_VACCINATION_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete VaccinationOrderModels Excluding Ids failed',

	DELETE_ALL_VACCINATION_ORDER = '[ENTITY] Delete all VaccinationOrderModels',
	DELETE_ALL_VACCINATION_ORDER_OK = '[ENTITY] Delete all VaccinationOrderModels successfully',
	DELETE_ALL_VACCINATION_ORDER_FAIL = '[ENTITY] Delete all VaccinationOrderModels failed',

	UPDATE_VACCINATION_ORDER = '[ENTITY] Update VaccinationOrderModel',
	UPDATE_VACCINATION_ORDER_OK = '[ENTITY] Update VaccinationOrderModel successfully',
	UPDATE_VACCINATION_ORDER_FAIL = '[ENTITY] Update VaccinationOrderModel failed',

	UPDATE_ALL_VACCINATION_ORDER = '[ENTITY] Update all VaccinationOrderModel',
	UPDATE_ALL_VACCINATION_ORDER_OK = '[ENTITY] Update all VaccinationOrderModel successfully',
	UPDATE_ALL_VACCINATION_ORDER_FAIL = '[ENTITY] Update all VaccinationOrderModel failed',

	FETCH_VACCINATION_ORDER= '[ENTITY] Fetch VaccinationOrderModel',
	FETCH_VACCINATION_ORDER_OK = '[ENTITY] Fetch VaccinationOrderModel successfully',
	FETCH_VACCINATION_ORDER_FAIL = '[ENTITY] Fetch VaccinationOrderModel failed',

	FETCH_VACCINATION_ORDER_AUDIT= '[ENTITY] Fetch VaccinationOrderModel audit',
	FETCH_VACCINATION_ORDER_AUDIT_OK = '[ENTITY] Fetch VaccinationOrderModel audit successfully',
	FETCH_VACCINATION_ORDER_AUDIT_FAIL = '[ENTITY] Fetch VaccinationOrderModel audit failed',

	FETCH_VACCINATION_ORDER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch VaccinationOrderModel audits by entity id',
	FETCH_VACCINATION_ORDER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch VaccinationOrderModel audits by entity id successfully',
	FETCH_VACCINATION_ORDER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch VaccinationOrderModel audits by entity id failed',

	FETCH_ALL_VACCINATION_ORDER = '[ENTITY] Fetch all VaccinationOrderModel',
	FETCH_ALL_VACCINATION_ORDER_OK = '[ENTITY] Fetch all VaccinationOrderModel successfully',
	FETCH_ALL_VACCINATION_ORDER_FAIL = '[ENTITY] Fetch all VaccinationOrderModel failed',

	FETCH_VACCINATION_ORDER_WITH_QUERY = '[ENTITY] Fetch VaccinationOrderModel with query',
	FETCH_VACCINATION_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch VaccinationOrderModel with query successfully',
	FETCH_VACCINATION_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch VaccinationOrderModel with query failed',

	FETCH_LAST_VACCINATION_ORDER_WITH_QUERY = '[ENTITY] Fetch last VaccinationOrderModel with query',
	FETCH_LAST_VACCINATION_ORDER_WITH_QUERY_OK = '[ENTITY] Fetch last VaccinationOrderModel with query successfully',
	FETCH_LAST_VACCINATION_ORDER_WITH_QUERY_FAIL = '[ENTITY] Fetch last VaccinationOrderModel with query failed',

	EXPORT_VACCINATION_ORDER = '[ENTITY] Export VaccinationOrderModel',
	EXPORT_VACCINATION_ORDER_OK = '[ENTITY] Export VaccinationOrderModel successfully',
	EXPORT_VACCINATION_ORDER_FAIL = '[ENTITY] Export VaccinationOrderModel failed',

	EXPORT_ALL_VACCINATION_ORDER = '[ENTITY] Export All VaccinationOrderModels',
	EXPORT_ALL_VACCINATION_ORDER_OK = '[ENTITY] Export All VaccinationOrderModels successfully',
	EXPORT_ALL_VACCINATION_ORDER_FAIL = '[ENTITY] Export All VaccinationOrderModels failed',

	EXPORT_VACCINATION_ORDER_EXCLUDING_IDS = '[ENTITY] Export VaccinationOrderModels excluding Ids',
	EXPORT_VACCINATION_ORDER_EXCLUDING_IDS_OK = '[ENTITY] Export VaccinationOrderModel excluding Ids successfully',
	EXPORT_VACCINATION_ORDER_EXCLUDING_IDS_FAIL = '[ENTITY] Export VaccinationOrderModel excluding Ids failed',

	COUNT_VACCINATION_ORDERS = '[ENTITY] Fetch number of VaccinationOrderModel records',
	COUNT_VACCINATION_ORDERS_OK = '[ENTITY] Fetch number of VaccinationOrderModel records successfully ',
	COUNT_VACCINATION_ORDERS_FAIL = '[ENTITY] Fetch number of VaccinationOrderModel records failed',

	IMPORT_VACCINATION_ORDERS = '[ENTITY] Import VaccinationOrderModels',
	IMPORT_VACCINATION_ORDERS_OK = '[ENTITY] Import VaccinationOrderModels successfully',
	IMPORT_VACCINATION_ORDERS_FAIL = '[ENTITY] Import VaccinationOrderModels fail',


	INITIALISE_VACCINATION_ORDER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of VaccinationOrderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseVaccinationOrderAction implements Action {
	readonly className: string = 'VaccinationOrderModel';

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

export class VaccinationOrderAction extends BaseVaccinationOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderAction here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VaccinationOrderModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderAction here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderAction here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderAction here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderAction here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderAction here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderAction here] end
}

export class VaccinationOrderActionOK extends BaseVaccinationOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderActionOK here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VaccinationOrderModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: VaccinationOrderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderActionOK here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderActionOK here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderActionOK here] end
}

export class VaccinationOrderActionFail extends BaseVaccinationOrderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderActionFail here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<VaccinationOrderModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderActionFail here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderActionFail here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderActionFail here] end
}

export function isVaccinationOrderModelAction(e: any): e is BaseVaccinationOrderAction {
	return Object.values(VaccinationOrderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
