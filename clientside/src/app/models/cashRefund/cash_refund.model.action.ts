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
import {CashRefundModel} from './cash_refund.model';
import {CashRefundModelAudit} from './cash_refund.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Cash Refund model actions to be dispatched by NgRx.
 */
export enum CashRefundModelActionTypes {
	CREATE_CASH_REFUND = '[ENTITY] Create CashRefundModel',
	CREATE_CASH_REFUND_OK = '[ENTITY] Create CashRefundModel successfully',
	CREATE_CASH_REFUND_FAIL = '[ENTITY] Create CashRefundModel failed',

	CREATE_ALL_CASH_REFUND = '[ENTITY] Create All CashRefundModel',
	CREATE_ALL_CASH_REFUND_OK = '[ENTITY] Create All CashRefundModel successfully',
	CREATE_ALL_CASH_REFUND_FAIL = '[ENTITY] Create All CashRefundModel failed',

	DELETE_CASH_REFUND = '[ENTITY] Delete CashRefundModel',
	DELETE_CASH_REFUND_OK = '[ENTITY] Delete CashRefundModel successfully',
	DELETE_CASH_REFUND_FAIL = '[ENTITY] Delete CashRefundModel failed',


	DELETE_CASH_REFUND_EXCLUDING_IDS = '[ENTITY] Delete CashRefundModels Excluding Ids',
	DELETE_CASH_REFUND_EXCLUDING_IDS_OK = '[ENTITY] Delete CashRefundModels Excluding Ids successfully',
	DELETE_CASH_REFUND_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CashRefundModels Excluding Ids failed',

	DELETE_ALL_CASH_REFUND = '[ENTITY] Delete all CashRefundModels',
	DELETE_ALL_CASH_REFUND_OK = '[ENTITY] Delete all CashRefundModels successfully',
	DELETE_ALL_CASH_REFUND_FAIL = '[ENTITY] Delete all CashRefundModels failed',

	UPDATE_CASH_REFUND = '[ENTITY] Update CashRefundModel',
	UPDATE_CASH_REFUND_OK = '[ENTITY] Update CashRefundModel successfully',
	UPDATE_CASH_REFUND_FAIL = '[ENTITY] Update CashRefundModel failed',

	UPDATE_ALL_CASH_REFUND = '[ENTITY] Update all CashRefundModel',
	UPDATE_ALL_CASH_REFUND_OK = '[ENTITY] Update all CashRefundModel successfully',
	UPDATE_ALL_CASH_REFUND_FAIL = '[ENTITY] Update all CashRefundModel failed',

	FETCH_CASH_REFUND= '[ENTITY] Fetch CashRefundModel',
	FETCH_CASH_REFUND_OK = '[ENTITY] Fetch CashRefundModel successfully',
	FETCH_CASH_REFUND_FAIL = '[ENTITY] Fetch CashRefundModel failed',

	FETCH_CASH_REFUND_AUDIT= '[ENTITY] Fetch CashRefundModel audit',
	FETCH_CASH_REFUND_AUDIT_OK = '[ENTITY] Fetch CashRefundModel audit successfully',
	FETCH_CASH_REFUND_AUDIT_FAIL = '[ENTITY] Fetch CashRefundModel audit failed',

	FETCH_CASH_REFUND_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CashRefundModel audits by entity id',
	FETCH_CASH_REFUND_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CashRefundModel audits by entity id successfully',
	FETCH_CASH_REFUND_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CashRefundModel audits by entity id failed',

	FETCH_ALL_CASH_REFUND = '[ENTITY] Fetch all CashRefundModel',
	FETCH_ALL_CASH_REFUND_OK = '[ENTITY] Fetch all CashRefundModel successfully',
	FETCH_ALL_CASH_REFUND_FAIL = '[ENTITY] Fetch all CashRefundModel failed',

	FETCH_CASH_REFUND_WITH_QUERY = '[ENTITY] Fetch CashRefundModel with query',
	FETCH_CASH_REFUND_WITH_QUERY_OK = '[ENTITY] Fetch CashRefundModel with query successfully',
	FETCH_CASH_REFUND_WITH_QUERY_FAIL = '[ENTITY] Fetch CashRefundModel with query failed',

	FETCH_LAST_CASH_REFUND_WITH_QUERY = '[ENTITY] Fetch last CashRefundModel with query',
	FETCH_LAST_CASH_REFUND_WITH_QUERY_OK = '[ENTITY] Fetch last CashRefundModel with query successfully',
	FETCH_LAST_CASH_REFUND_WITH_QUERY_FAIL = '[ENTITY] Fetch last CashRefundModel with query failed',

	EXPORT_CASH_REFUND = '[ENTITY] Export CashRefundModel',
	EXPORT_CASH_REFUND_OK = '[ENTITY] Export CashRefundModel successfully',
	EXPORT_CASH_REFUND_FAIL = '[ENTITY] Export CashRefundModel failed',

	EXPORT_ALL_CASH_REFUND = '[ENTITY] Export All CashRefundModels',
	EXPORT_ALL_CASH_REFUND_OK = '[ENTITY] Export All CashRefundModels successfully',
	EXPORT_ALL_CASH_REFUND_FAIL = '[ENTITY] Export All CashRefundModels failed',

	EXPORT_CASH_REFUND_EXCLUDING_IDS = '[ENTITY] Export CashRefundModels excluding Ids',
	EXPORT_CASH_REFUND_EXCLUDING_IDS_OK = '[ENTITY] Export CashRefundModel excluding Ids successfully',
	EXPORT_CASH_REFUND_EXCLUDING_IDS_FAIL = '[ENTITY] Export CashRefundModel excluding Ids failed',

	COUNT_CASH_REFUNDS = '[ENTITY] Fetch number of CashRefundModel records',
	COUNT_CASH_REFUNDS_OK = '[ENTITY] Fetch number of CashRefundModel records successfully ',
	COUNT_CASH_REFUNDS_FAIL = '[ENTITY] Fetch number of CashRefundModel records failed',

	IMPORT_CASH_REFUNDS = '[ENTITY] Import CashRefundModels',
	IMPORT_CASH_REFUNDS_OK = '[ENTITY] Import CashRefundModels successfully',
	IMPORT_CASH_REFUNDS_FAIL = '[ENTITY] Import CashRefundModels fail',


	INITIALISE_CASH_REFUND_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CashRefundModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCashRefundAction implements Action {
	readonly className: string = 'CashRefundModel';

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

export class CashRefundAction extends BaseCashRefundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashRefundAction here] off begin
	// % protected region % [Add any additional class fields for CashRefundAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashRefundModel>,
		// % protected region % [Add any additional constructor parameters for CashRefundAction here] off begin
		// % protected region % [Add any additional constructor parameters for CashRefundAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashRefundAction here] off begin
			// % protected region % [Add any additional constructor arguments for CashRefundAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashRefundAction here] off begin
		// % protected region % [Add any additional constructor logic for CashRefundAction here] end
	}

	// % protected region % [Add any additional class methods for CashRefundAction here] off begin
	// % protected region % [Add any additional class methods for CashRefundAction here] end
}

export class CashRefundActionOK extends BaseCashRefundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashRefundActionOK here] off begin
	// % protected region % [Add any additional class fields for CashRefundActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashRefundModel>,
		// % protected region % [Add any additional constructor parameters for CashRefundActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CashRefundActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CashRefundModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashRefundActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CashRefundActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashRefundActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CashRefundActionOK here] end
	}

	// % protected region % [Add any additional class methods for CashRefundActionOK here] off begin
	// % protected region % [Add any additional class methods for CashRefundActionOK here] end
}

export class CashRefundActionFail extends BaseCashRefundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashRefundActionFail here] off begin
	// % protected region % [Add any additional class fields for CashRefundActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CashRefundModel>,
		// % protected region % [Add any additional constructor parameters for CashRefundActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CashRefundActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashRefundActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CashRefundActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashRefundActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CashRefundActionFail here] end
	}

	// % protected region % [Add any additional class methods for CashRefundActionFail here] off begin
	// % protected region % [Add any additional class methods for CashRefundActionFail here] end
}

export function isCashRefundModelAction(e: any): e is BaseCashRefundAction {
	return Object.values(CashRefundModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
