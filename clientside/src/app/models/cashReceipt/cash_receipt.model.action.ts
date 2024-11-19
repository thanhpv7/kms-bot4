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
import {CashReceiptModel} from './cash_receipt.model';
import {CashReceiptModelAudit} from './cash_receipt.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Cash Receipt model actions to be dispatched by NgRx.
 */
export enum CashReceiptModelActionTypes {
	CREATE_CASH_RECEIPT = '[ENTITY] Create CashReceiptModel',
	CREATE_CASH_RECEIPT_OK = '[ENTITY] Create CashReceiptModel successfully',
	CREATE_CASH_RECEIPT_FAIL = '[ENTITY] Create CashReceiptModel failed',

	CREATE_ALL_CASH_RECEIPT = '[ENTITY] Create All CashReceiptModel',
	CREATE_ALL_CASH_RECEIPT_OK = '[ENTITY] Create All CashReceiptModel successfully',
	CREATE_ALL_CASH_RECEIPT_FAIL = '[ENTITY] Create All CashReceiptModel failed',

	DELETE_CASH_RECEIPT = '[ENTITY] Delete CashReceiptModel',
	DELETE_CASH_RECEIPT_OK = '[ENTITY] Delete CashReceiptModel successfully',
	DELETE_CASH_RECEIPT_FAIL = '[ENTITY] Delete CashReceiptModel failed',


	DELETE_CASH_RECEIPT_EXCLUDING_IDS = '[ENTITY] Delete CashReceiptModels Excluding Ids',
	DELETE_CASH_RECEIPT_EXCLUDING_IDS_OK = '[ENTITY] Delete CashReceiptModels Excluding Ids successfully',
	DELETE_CASH_RECEIPT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CashReceiptModels Excluding Ids failed',

	DELETE_ALL_CASH_RECEIPT = '[ENTITY] Delete all CashReceiptModels',
	DELETE_ALL_CASH_RECEIPT_OK = '[ENTITY] Delete all CashReceiptModels successfully',
	DELETE_ALL_CASH_RECEIPT_FAIL = '[ENTITY] Delete all CashReceiptModels failed',

	UPDATE_CASH_RECEIPT = '[ENTITY] Update CashReceiptModel',
	UPDATE_CASH_RECEIPT_OK = '[ENTITY] Update CashReceiptModel successfully',
	UPDATE_CASH_RECEIPT_FAIL = '[ENTITY] Update CashReceiptModel failed',

	UPDATE_ALL_CASH_RECEIPT = '[ENTITY] Update all CashReceiptModel',
	UPDATE_ALL_CASH_RECEIPT_OK = '[ENTITY] Update all CashReceiptModel successfully',
	UPDATE_ALL_CASH_RECEIPT_FAIL = '[ENTITY] Update all CashReceiptModel failed',

	FETCH_CASH_RECEIPT= '[ENTITY] Fetch CashReceiptModel',
	FETCH_CASH_RECEIPT_OK = '[ENTITY] Fetch CashReceiptModel successfully',
	FETCH_CASH_RECEIPT_FAIL = '[ENTITY] Fetch CashReceiptModel failed',

	FETCH_CASH_RECEIPT_AUDIT= '[ENTITY] Fetch CashReceiptModel audit',
	FETCH_CASH_RECEIPT_AUDIT_OK = '[ENTITY] Fetch CashReceiptModel audit successfully',
	FETCH_CASH_RECEIPT_AUDIT_FAIL = '[ENTITY] Fetch CashReceiptModel audit failed',

	FETCH_CASH_RECEIPT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CashReceiptModel audits by entity id',
	FETCH_CASH_RECEIPT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CashReceiptModel audits by entity id successfully',
	FETCH_CASH_RECEIPT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CashReceiptModel audits by entity id failed',

	FETCH_ALL_CASH_RECEIPT = '[ENTITY] Fetch all CashReceiptModel',
	FETCH_ALL_CASH_RECEIPT_OK = '[ENTITY] Fetch all CashReceiptModel successfully',
	FETCH_ALL_CASH_RECEIPT_FAIL = '[ENTITY] Fetch all CashReceiptModel failed',

	FETCH_CASH_RECEIPT_WITH_QUERY = '[ENTITY] Fetch CashReceiptModel with query',
	FETCH_CASH_RECEIPT_WITH_QUERY_OK = '[ENTITY] Fetch CashReceiptModel with query successfully',
	FETCH_CASH_RECEIPT_WITH_QUERY_FAIL = '[ENTITY] Fetch CashReceiptModel with query failed',

	FETCH_LAST_CASH_RECEIPT_WITH_QUERY = '[ENTITY] Fetch last CashReceiptModel with query',
	FETCH_LAST_CASH_RECEIPT_WITH_QUERY_OK = '[ENTITY] Fetch last CashReceiptModel with query successfully',
	FETCH_LAST_CASH_RECEIPT_WITH_QUERY_FAIL = '[ENTITY] Fetch last CashReceiptModel with query failed',

	EXPORT_CASH_RECEIPT = '[ENTITY] Export CashReceiptModel',
	EXPORT_CASH_RECEIPT_OK = '[ENTITY] Export CashReceiptModel successfully',
	EXPORT_CASH_RECEIPT_FAIL = '[ENTITY] Export CashReceiptModel failed',

	EXPORT_ALL_CASH_RECEIPT = '[ENTITY] Export All CashReceiptModels',
	EXPORT_ALL_CASH_RECEIPT_OK = '[ENTITY] Export All CashReceiptModels successfully',
	EXPORT_ALL_CASH_RECEIPT_FAIL = '[ENTITY] Export All CashReceiptModels failed',

	EXPORT_CASH_RECEIPT_EXCLUDING_IDS = '[ENTITY] Export CashReceiptModels excluding Ids',
	EXPORT_CASH_RECEIPT_EXCLUDING_IDS_OK = '[ENTITY] Export CashReceiptModel excluding Ids successfully',
	EXPORT_CASH_RECEIPT_EXCLUDING_IDS_FAIL = '[ENTITY] Export CashReceiptModel excluding Ids failed',

	COUNT_CASH_RECEIPTS = '[ENTITY] Fetch number of CashReceiptModel records',
	COUNT_CASH_RECEIPTS_OK = '[ENTITY] Fetch number of CashReceiptModel records successfully ',
	COUNT_CASH_RECEIPTS_FAIL = '[ENTITY] Fetch number of CashReceiptModel records failed',

	IMPORT_CASH_RECEIPTS = '[ENTITY] Import CashReceiptModels',
	IMPORT_CASH_RECEIPTS_OK = '[ENTITY] Import CashReceiptModels successfully',
	IMPORT_CASH_RECEIPTS_FAIL = '[ENTITY] Import CashReceiptModels fail',


	INITIALISE_CASH_RECEIPT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CashReceiptModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCashReceiptAction implements Action {
	readonly className: string = 'CashReceiptModel';

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

export class CashReceiptAction extends BaseCashReceiptAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashReceiptAction here] off begin
	// % protected region % [Add any additional class fields for CashReceiptAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashReceiptModel>,
		// % protected region % [Add any additional constructor parameters for CashReceiptAction here] off begin
		// % protected region % [Add any additional constructor parameters for CashReceiptAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashReceiptAction here] off begin
			// % protected region % [Add any additional constructor arguments for CashReceiptAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashReceiptAction here] off begin
		// % protected region % [Add any additional constructor logic for CashReceiptAction here] end
	}

	// % protected region % [Add any additional class methods for CashReceiptAction here] off begin
	// % protected region % [Add any additional class methods for CashReceiptAction here] end
}

export class CashReceiptActionOK extends BaseCashReceiptAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashReceiptActionOK here] off begin
	// % protected region % [Add any additional class fields for CashReceiptActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CashReceiptModel>,
		// % protected region % [Add any additional constructor parameters for CashReceiptActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CashReceiptActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CashReceiptModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashReceiptActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CashReceiptActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashReceiptActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CashReceiptActionOK here] end
	}

	// % protected region % [Add any additional class methods for CashReceiptActionOK here] off begin
	// % protected region % [Add any additional class methods for CashReceiptActionOK here] end
}

export class CashReceiptActionFail extends BaseCashReceiptAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CashReceiptActionFail here] off begin
	// % protected region % [Add any additional class fields for CashReceiptActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CashReceiptModel>,
		// % protected region % [Add any additional constructor parameters for CashReceiptActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CashReceiptActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CashReceiptActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CashReceiptActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CashReceiptActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CashReceiptActionFail here] end
	}

	// % protected region % [Add any additional class methods for CashReceiptActionFail here] off begin
	// % protected region % [Add any additional class methods for CashReceiptActionFail here] end
}

export function isCashReceiptModelAction(e: any): e is BaseCashReceiptAction {
	return Object.values(CashReceiptModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
