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
import {CashAllocationModel} from './cash_allocation.model';
import {CashAllocationModelAudit} from './cash_allocation.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Cash Allocation model actions to be dispatched by NgRx.
 */
export enum CashAllocationModelActionTypes {
	CREATE_CASH_ALLOCATION = '[ENTITY] Create CashAllocationModel',
	CREATE_CASH_ALLOCATION_OK = '[ENTITY] Create CashAllocationModel successfully',
	CREATE_CASH_ALLOCATION_FAIL = '[ENTITY] Create CashAllocationModel failed',

	CREATE_ALL_CASH_ALLOCATION = '[ENTITY] Create All CashAllocationModel',
	CREATE_ALL_CASH_ALLOCATION_OK = '[ENTITY] Create All CashAllocationModel successfully',
	CREATE_ALL_CASH_ALLOCATION_FAIL = '[ENTITY] Create All CashAllocationModel failed',

	DELETE_CASH_ALLOCATION = '[ENTITY] Delete CashAllocationModel',
	DELETE_CASH_ALLOCATION_OK = '[ENTITY] Delete CashAllocationModel successfully',
	DELETE_CASH_ALLOCATION_FAIL = '[ENTITY] Delete CashAllocationModel failed',


	DELETE_CASH_ALLOCATION_EXCLUDING_IDS = '[ENTITY] Delete CashAllocationModels Excluding Ids',
	DELETE_CASH_ALLOCATION_EXCLUDING_IDS_OK = '[ENTITY] Delete CashAllocationModels Excluding Ids successfully',
	DELETE_CASH_ALLOCATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CashAllocationModels Excluding Ids failed',

	DELETE_ALL_CASH_ALLOCATION = '[ENTITY] Delete all CashAllocationModels',
	DELETE_ALL_CASH_ALLOCATION_OK = '[ENTITY] Delete all CashAllocationModels successfully',
	DELETE_ALL_CASH_ALLOCATION_FAIL = '[ENTITY] Delete all CashAllocationModels failed',

	UPDATE_CASH_ALLOCATION = '[ENTITY] Update CashAllocationModel',
	UPDATE_CASH_ALLOCATION_OK = '[ENTITY] Update CashAllocationModel successfully',
	UPDATE_CASH_ALLOCATION_FAIL = '[ENTITY] Update CashAllocationModel failed',

	UPDATE_ALL_CASH_ALLOCATION = '[ENTITY] Update all CashAllocationModel',
	UPDATE_ALL_CASH_ALLOCATION_OK = '[ENTITY] Update all CashAllocationModel successfully',
	UPDATE_ALL_CASH_ALLOCATION_FAIL = '[ENTITY] Update all CashAllocationModel failed',

	FETCH_CASH_ALLOCATION= '[ENTITY] Fetch CashAllocationModel',
	FETCH_CASH_ALLOCATION_OK = '[ENTITY] Fetch CashAllocationModel successfully',
	FETCH_CASH_ALLOCATION_FAIL = '[ENTITY] Fetch CashAllocationModel failed',

	FETCH_CASH_ALLOCATION_AUDIT= '[ENTITY] Fetch CashAllocationModel audit',
	FETCH_CASH_ALLOCATION_AUDIT_OK = '[ENTITY] Fetch CashAllocationModel audit successfully',
	FETCH_CASH_ALLOCATION_AUDIT_FAIL = '[ENTITY] Fetch CashAllocationModel audit failed',

	FETCH_CASH_ALLOCATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CashAllocationModel audits by entity id',
	FETCH_CASH_ALLOCATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CashAllocationModel audits by entity id successfully',
	FETCH_CASH_ALLOCATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CashAllocationModel audits by entity id failed',

	FETCH_ALL_CASH_ALLOCATION = '[ENTITY] Fetch all CashAllocationModel',
	FETCH_ALL_CASH_ALLOCATION_OK = '[ENTITY] Fetch all CashAllocationModel successfully',
	FETCH_ALL_CASH_ALLOCATION_FAIL = '[ENTITY] Fetch all CashAllocationModel failed',

	FETCH_CASH_ALLOCATION_WITH_QUERY = '[ENTITY] Fetch CashAllocationModel with query',
	FETCH_CASH_ALLOCATION_WITH_QUERY_OK = '[ENTITY] Fetch CashAllocationModel with query successfully',
	FETCH_CASH_ALLOCATION_WITH_QUERY_FAIL = '[ENTITY] Fetch CashAllocationModel with query failed',

	FETCH_LAST_CASH_ALLOCATION_WITH_QUERY = '[ENTITY] Fetch last CashAllocationModel with query',
	FETCH_LAST_CASH_ALLOCATION_WITH_QUERY_OK = '[ENTITY] Fetch last CashAllocationModel with query successfully',
	FETCH_LAST_CASH_ALLOCATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last CashAllocationModel with query failed',

	EXPORT_CASH_ALLOCATION = '[ENTITY] Export CashAllocationModel',
	EXPORT_CASH_ALLOCATION_OK = '[ENTITY] Export CashAllocationModel successfully',
	EXPORT_CASH_ALLOCATION_FAIL = '[ENTITY] Export CashAllocationModel failed',

	EXPORT_ALL_CASH_ALLOCATION = '[ENTITY] Export All CashAllocationModels',
	EXPORT_ALL_CASH_ALLOCATION_OK = '[ENTITY] Export All CashAllocationModels successfully',
	EXPORT_ALL_CASH_ALLOCATION_FAIL = '[ENTITY] Export All CashAllocationModels failed',

	EXPORT_CASH_ALLOCATION_EXCLUDING_IDS = '[ENTITY] Export CashAllocationModels excluding Ids',
	EXPORT_CASH_ALLOCATION_EXCLUDING_IDS_OK = '[ENTITY] Export CashAllocationModel excluding Ids successfully',
	EXPORT_CASH_ALLOCATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export CashAllocationModel excluding Ids failed',

	COUNT_CASH_ALLOCATIONS = '[ENTITY] Fetch number of CashAllocationModel records',
	COUNT_CASH_ALLOCATIONS_OK = '[ENTITY] Fetch number of CashAllocationModel records successfully ',
	COUNT_CASH_ALLOCATIONS_FAIL = '[ENTITY] Fetch number of CashAllocationModel records failed',

	IMPORT_CASH_ALLOCATIONS = '[ENTITY] Import CashAllocationModels',
	IMPORT_CASH_ALLOCATIONS_OK = '[ENTITY] Import CashAllocationModels successfully',
	IMPORT_CASH_ALLOCATIONS_FAIL = '[ENTITY] Import CashAllocationModels fail',


	INITIALISE_CASH_ALLOCATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CashAllocationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCashAllocationAction implements Action {
	readonly className: string = 'CashAllocationModel';

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

export class CashAllocationAction extends BaseCashAllocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashAllocationAction here] off begin
	// % protected region % [Add any additional class fields for CashAllocationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashAllocationModel>,
		// % protected region % [Add any additional constructor parameters for CashAllocationAction here] off begin
		// % protected region % [Add any additional constructor parameters for CashAllocationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashAllocationAction here] off begin
			// % protected region % [Add any additional constructor arguments for CashAllocationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashAllocationAction here] off begin
		// % protected region % [Add any additional constructor logic for CashAllocationAction here] end
	}

	// % protected region % [Add any additional class methods for CashAllocationAction here] off begin
	// % protected region % [Add any additional class methods for CashAllocationAction here] end
}

export class CashAllocationActionOK extends BaseCashAllocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashAllocationActionOK here] off begin
	// % protected region % [Add any additional class fields for CashAllocationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashAllocationModel>,
		// % protected region % [Add any additional constructor parameters for CashAllocationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CashAllocationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CashAllocationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashAllocationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CashAllocationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashAllocationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CashAllocationActionOK here] end
	}

	// % protected region % [Add any additional class methods for CashAllocationActionOK here] off begin
	// % protected region % [Add any additional class methods for CashAllocationActionOK here] end
}

export class CashAllocationActionFail extends BaseCashAllocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashAllocationActionFail here] off begin
	// % protected region % [Add any additional class fields for CashAllocationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CashAllocationModel>,
		// % protected region % [Add any additional constructor parameters for CashAllocationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CashAllocationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashAllocationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CashAllocationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashAllocationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CashAllocationActionFail here] end
	}

	// % protected region % [Add any additional class methods for CashAllocationActionFail here] off begin
	// % protected region % [Add any additional class methods for CashAllocationActionFail here] end
}

export function isCashAllocationModelAction(e: any): e is BaseCashAllocationAction {
	return Object.values(CashAllocationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
