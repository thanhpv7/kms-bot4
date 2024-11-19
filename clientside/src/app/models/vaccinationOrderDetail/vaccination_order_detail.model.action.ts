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
import {VaccinationOrderDetailModel} from './vaccination_order_detail.model';
import {VaccinationOrderDetailModelAudit} from './vaccination_order_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Vaccination Order Detail model actions to be dispatched by NgRx.
 */
export enum VaccinationOrderDetailModelActionTypes {
	CREATE_VACCINATION_ORDER_DETAIL = '[ENTITY] Create VaccinationOrderDetailModel',
	CREATE_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Create VaccinationOrderDetailModel successfully',
	CREATE_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Create VaccinationOrderDetailModel failed',

	CREATE_ALL_VACCINATION_ORDER_DETAIL = '[ENTITY] Create All VaccinationOrderDetailModel',
	CREATE_ALL_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Create All VaccinationOrderDetailModel successfully',
	CREATE_ALL_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Create All VaccinationOrderDetailModel failed',

	DELETE_VACCINATION_ORDER_DETAIL = '[ENTITY] Delete VaccinationOrderDetailModel',
	DELETE_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Delete VaccinationOrderDetailModel successfully',
	DELETE_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Delete VaccinationOrderDetailModel failed',


	DELETE_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete VaccinationOrderDetailModels Excluding Ids',
	DELETE_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete VaccinationOrderDetailModels Excluding Ids successfully',
	DELETE_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete VaccinationOrderDetailModels Excluding Ids failed',

	DELETE_ALL_VACCINATION_ORDER_DETAIL = '[ENTITY] Delete all VaccinationOrderDetailModels',
	DELETE_ALL_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Delete all VaccinationOrderDetailModels successfully',
	DELETE_ALL_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Delete all VaccinationOrderDetailModels failed',

	UPDATE_VACCINATION_ORDER_DETAIL = '[ENTITY] Update VaccinationOrderDetailModel',
	UPDATE_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Update VaccinationOrderDetailModel successfully',
	UPDATE_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Update VaccinationOrderDetailModel failed',

	UPDATE_ALL_VACCINATION_ORDER_DETAIL = '[ENTITY] Update all VaccinationOrderDetailModel',
	UPDATE_ALL_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Update all VaccinationOrderDetailModel successfully',
	UPDATE_ALL_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Update all VaccinationOrderDetailModel failed',

	FETCH_VACCINATION_ORDER_DETAIL= '[ENTITY] Fetch VaccinationOrderDetailModel',
	FETCH_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Fetch VaccinationOrderDetailModel successfully',
	FETCH_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Fetch VaccinationOrderDetailModel failed',

	FETCH_VACCINATION_ORDER_DETAIL_AUDIT= '[ENTITY] Fetch VaccinationOrderDetailModel audit',
	FETCH_VACCINATION_ORDER_DETAIL_AUDIT_OK = '[ENTITY] Fetch VaccinationOrderDetailModel audit successfully',
	FETCH_VACCINATION_ORDER_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch VaccinationOrderDetailModel audit failed',

	FETCH_VACCINATION_ORDER_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch VaccinationOrderDetailModel audits by entity id',
	FETCH_VACCINATION_ORDER_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch VaccinationOrderDetailModel audits by entity id successfully',
	FETCH_VACCINATION_ORDER_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch VaccinationOrderDetailModel audits by entity id failed',

	FETCH_ALL_VACCINATION_ORDER_DETAIL = '[ENTITY] Fetch all VaccinationOrderDetailModel',
	FETCH_ALL_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Fetch all VaccinationOrderDetailModel successfully',
	FETCH_ALL_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Fetch all VaccinationOrderDetailModel failed',

	FETCH_VACCINATION_ORDER_DETAIL_WITH_QUERY = '[ENTITY] Fetch VaccinationOrderDetailModel with query',
	FETCH_VACCINATION_ORDER_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch VaccinationOrderDetailModel with query successfully',
	FETCH_VACCINATION_ORDER_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch VaccinationOrderDetailModel with query failed',

	FETCH_LAST_VACCINATION_ORDER_DETAIL_WITH_QUERY = '[ENTITY] Fetch last VaccinationOrderDetailModel with query',
	FETCH_LAST_VACCINATION_ORDER_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last VaccinationOrderDetailModel with query successfully',
	FETCH_LAST_VACCINATION_ORDER_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last VaccinationOrderDetailModel with query failed',

	EXPORT_VACCINATION_ORDER_DETAIL = '[ENTITY] Export VaccinationOrderDetailModel',
	EXPORT_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Export VaccinationOrderDetailModel successfully',
	EXPORT_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Export VaccinationOrderDetailModel failed',

	EXPORT_ALL_VACCINATION_ORDER_DETAIL = '[ENTITY] Export All VaccinationOrderDetailModels',
	EXPORT_ALL_VACCINATION_ORDER_DETAIL_OK = '[ENTITY] Export All VaccinationOrderDetailModels successfully',
	EXPORT_ALL_VACCINATION_ORDER_DETAIL_FAIL = '[ENTITY] Export All VaccinationOrderDetailModels failed',

	EXPORT_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS = '[ENTITY] Export VaccinationOrderDetailModels excluding Ids',
	EXPORT_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export VaccinationOrderDetailModel excluding Ids successfully',
	EXPORT_VACCINATION_ORDER_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export VaccinationOrderDetailModel excluding Ids failed',

	COUNT_VACCINATION_ORDER_DETAILS = '[ENTITY] Fetch number of VaccinationOrderDetailModel records',
	COUNT_VACCINATION_ORDER_DETAILS_OK = '[ENTITY] Fetch number of VaccinationOrderDetailModel records successfully ',
	COUNT_VACCINATION_ORDER_DETAILS_FAIL = '[ENTITY] Fetch number of VaccinationOrderDetailModel records failed',

	IMPORT_VACCINATION_ORDER_DETAILS = '[ENTITY] Import VaccinationOrderDetailModels',
	IMPORT_VACCINATION_ORDER_DETAILS_OK = '[ENTITY] Import VaccinationOrderDetailModels successfully',
	IMPORT_VACCINATION_ORDER_DETAILS_FAIL = '[ENTITY] Import VaccinationOrderDetailModels fail',


	INITIALISE_VACCINATION_ORDER_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of VaccinationOrderDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseVaccinationOrderDetailAction implements Action {
	readonly className: string = 'VaccinationOrderDetailModel';

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

export class VaccinationOrderDetailAction extends BaseVaccinationOrderDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderDetailAction here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VaccinationOrderDetailModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailAction here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderDetailAction here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderDetailAction here] end
}

export class VaccinationOrderDetailActionOK extends BaseVaccinationOrderDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VaccinationOrderDetailModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: VaccinationOrderDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderDetailActionOK here] end
}

export class VaccinationOrderDetailActionFail extends BaseVaccinationOrderDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VaccinationOrderDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for VaccinationOrderDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<VaccinationOrderDetailModel>,
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for VaccinationOrderDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for VaccinationOrderDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for VaccinationOrderDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for VaccinationOrderDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for VaccinationOrderDetailActionFail here] end
}

export function isVaccinationOrderDetailModelAction(e: any): e is BaseVaccinationOrderDetailAction {
	return Object.values(VaccinationOrderDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
