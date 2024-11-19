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
import {InvoicePaymentOtherModel} from './invoice_payment_other.model';
import {InvoicePaymentOtherModelAudit} from './invoice_payment_other.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Payment Other model actions to be dispatched by NgRx.
 */
export enum InvoicePaymentOtherModelActionTypes {
	CREATE_INVOICE_PAYMENT_OTHER = '[ENTITY] Create InvoicePaymentOtherModel',
	CREATE_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Create InvoicePaymentOtherModel successfully',
	CREATE_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Create InvoicePaymentOtherModel failed',

	CREATE_ALL_INVOICE_PAYMENT_OTHER = '[ENTITY] Create All InvoicePaymentOtherModel',
	CREATE_ALL_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Create All InvoicePaymentOtherModel successfully',
	CREATE_ALL_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Create All InvoicePaymentOtherModel failed',

	DELETE_INVOICE_PAYMENT_OTHER = '[ENTITY] Delete InvoicePaymentOtherModel',
	DELETE_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Delete InvoicePaymentOtherModel successfully',
	DELETE_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Delete InvoicePaymentOtherModel failed',


	DELETE_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS = '[ENTITY] Delete InvoicePaymentOtherModels Excluding Ids',
	DELETE_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoicePaymentOtherModels Excluding Ids successfully',
	DELETE_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoicePaymentOtherModels Excluding Ids failed',

	DELETE_ALL_INVOICE_PAYMENT_OTHER = '[ENTITY] Delete all InvoicePaymentOtherModels',
	DELETE_ALL_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Delete all InvoicePaymentOtherModels successfully',
	DELETE_ALL_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Delete all InvoicePaymentOtherModels failed',

	UPDATE_INVOICE_PAYMENT_OTHER = '[ENTITY] Update InvoicePaymentOtherModel',
	UPDATE_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Update InvoicePaymentOtherModel successfully',
	UPDATE_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Update InvoicePaymentOtherModel failed',

	UPDATE_ALL_INVOICE_PAYMENT_OTHER = '[ENTITY] Update all InvoicePaymentOtherModel',
	UPDATE_ALL_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Update all InvoicePaymentOtherModel successfully',
	UPDATE_ALL_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Update all InvoicePaymentOtherModel failed',

	FETCH_INVOICE_PAYMENT_OTHER= '[ENTITY] Fetch InvoicePaymentOtherModel',
	FETCH_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Fetch InvoicePaymentOtherModel successfully',
	FETCH_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Fetch InvoicePaymentOtherModel failed',

	FETCH_INVOICE_PAYMENT_OTHER_AUDIT= '[ENTITY] Fetch InvoicePaymentOtherModel audit',
	FETCH_INVOICE_PAYMENT_OTHER_AUDIT_OK = '[ENTITY] Fetch InvoicePaymentOtherModel audit successfully',
	FETCH_INVOICE_PAYMENT_OTHER_AUDIT_FAIL = '[ENTITY] Fetch InvoicePaymentOtherModel audit failed',

	FETCH_INVOICE_PAYMENT_OTHER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoicePaymentOtherModel audits by entity id',
	FETCH_INVOICE_PAYMENT_OTHER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoicePaymentOtherModel audits by entity id successfully',
	FETCH_INVOICE_PAYMENT_OTHER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoicePaymentOtherModel audits by entity id failed',

	FETCH_ALL_INVOICE_PAYMENT_OTHER = '[ENTITY] Fetch all InvoicePaymentOtherModel',
	FETCH_ALL_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Fetch all InvoicePaymentOtherModel successfully',
	FETCH_ALL_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Fetch all InvoicePaymentOtherModel failed',

	FETCH_INVOICE_PAYMENT_OTHER_WITH_QUERY = '[ENTITY] Fetch InvoicePaymentOtherModel with query',
	FETCH_INVOICE_PAYMENT_OTHER_WITH_QUERY_OK = '[ENTITY] Fetch InvoicePaymentOtherModel with query successfully',
	FETCH_INVOICE_PAYMENT_OTHER_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoicePaymentOtherModel with query failed',

	FETCH_LAST_INVOICE_PAYMENT_OTHER_WITH_QUERY = '[ENTITY] Fetch last InvoicePaymentOtherModel with query',
	FETCH_LAST_INVOICE_PAYMENT_OTHER_WITH_QUERY_OK = '[ENTITY] Fetch last InvoicePaymentOtherModel with query successfully',
	FETCH_LAST_INVOICE_PAYMENT_OTHER_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoicePaymentOtherModel with query failed',

	EXPORT_INVOICE_PAYMENT_OTHER = '[ENTITY] Export InvoicePaymentOtherModel',
	EXPORT_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Export InvoicePaymentOtherModel successfully',
	EXPORT_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Export InvoicePaymentOtherModel failed',

	EXPORT_ALL_INVOICE_PAYMENT_OTHER = '[ENTITY] Export All InvoicePaymentOtherModels',
	EXPORT_ALL_INVOICE_PAYMENT_OTHER_OK = '[ENTITY] Export All InvoicePaymentOtherModels successfully',
	EXPORT_ALL_INVOICE_PAYMENT_OTHER_FAIL = '[ENTITY] Export All InvoicePaymentOtherModels failed',

	EXPORT_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS = '[ENTITY] Export InvoicePaymentOtherModels excluding Ids',
	EXPORT_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS_OK = '[ENTITY] Export InvoicePaymentOtherModel excluding Ids successfully',
	EXPORT_INVOICE_PAYMENT_OTHER_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoicePaymentOtherModel excluding Ids failed',

	COUNT_INVOICE_PAYMENT_OTHERS = '[ENTITY] Fetch number of InvoicePaymentOtherModel records',
	COUNT_INVOICE_PAYMENT_OTHERS_OK = '[ENTITY] Fetch number of InvoicePaymentOtherModel records successfully ',
	COUNT_INVOICE_PAYMENT_OTHERS_FAIL = '[ENTITY] Fetch number of InvoicePaymentOtherModel records failed',

	IMPORT_INVOICE_PAYMENT_OTHERS = '[ENTITY] Import InvoicePaymentOtherModels',
	IMPORT_INVOICE_PAYMENT_OTHERS_OK = '[ENTITY] Import InvoicePaymentOtherModels successfully',
	IMPORT_INVOICE_PAYMENT_OTHERS_FAIL = '[ENTITY] Import InvoicePaymentOtherModels fail',


	INITIALISE_INVOICE_PAYMENT_OTHER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoicePaymentOtherModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoicePaymentOtherAction implements Action {
	readonly className: string = 'InvoicePaymentOtherModel';

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

export class InvoicePaymentOtherAction extends BaseInvoicePaymentOtherAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentOtherAction here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentOtherAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentOtherModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherAction here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentOtherAction here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentOtherAction here] end
}

export class InvoicePaymentOtherActionOK extends BaseInvoicePaymentOtherAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentOtherActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentOtherActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentOtherModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoicePaymentOtherModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentOtherActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentOtherActionOK here] end
}

export class InvoicePaymentOtherActionFail extends BaseInvoicePaymentOtherAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentOtherActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentOtherActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoicePaymentOtherModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentOtherActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentOtherActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentOtherActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentOtherActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentOtherActionFail here] end
}

export function isInvoicePaymentOtherModelAction(e: any): e is BaseInvoicePaymentOtherAction {
	return Object.values(InvoicePaymentOtherModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
