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
import {InvoicePaymentSelfPayingModel} from './invoice_payment_self_paying.model';
import {InvoicePaymentSelfPayingModelAudit} from './invoice_payment_self_paying.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Payment Self Paying model actions to be dispatched by NgRx.
 */
export enum InvoicePaymentSelfPayingModelActionTypes {
	CREATE_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Create InvoicePaymentSelfPayingModel',
	CREATE_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create InvoicePaymentSelfPayingModel successfully',
	CREATE_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create InvoicePaymentSelfPayingModel failed',

	CREATE_ALL_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Create All InvoicePaymentSelfPayingModel',
	CREATE_ALL_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Create All InvoicePaymentSelfPayingModel successfully',
	CREATE_ALL_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Create All InvoicePaymentSelfPayingModel failed',

	DELETE_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Delete InvoicePaymentSelfPayingModel',
	DELETE_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete InvoicePaymentSelfPayingModel successfully',
	DELETE_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete InvoicePaymentSelfPayingModel failed',


	DELETE_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Delete InvoicePaymentSelfPayingModels Excluding Ids',
	DELETE_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoicePaymentSelfPayingModels Excluding Ids successfully',
	DELETE_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoicePaymentSelfPayingModels Excluding Ids failed',

	DELETE_ALL_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Delete all InvoicePaymentSelfPayingModels',
	DELETE_ALL_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Delete all InvoicePaymentSelfPayingModels successfully',
	DELETE_ALL_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Delete all InvoicePaymentSelfPayingModels failed',

	UPDATE_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Update InvoicePaymentSelfPayingModel',
	UPDATE_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update InvoicePaymentSelfPayingModel successfully',
	UPDATE_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update InvoicePaymentSelfPayingModel failed',

	UPDATE_ALL_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Update all InvoicePaymentSelfPayingModel',
	UPDATE_ALL_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Update all InvoicePaymentSelfPayingModel successfully',
	UPDATE_ALL_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Update all InvoicePaymentSelfPayingModel failed',

	FETCH_INVOICE_PAYMENT_SELF_PAYING= '[ENTITY] Fetch InvoicePaymentSelfPayingModel',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch InvoicePaymentSelfPayingModel successfully',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch InvoicePaymentSelfPayingModel failed',

	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDIT= '[ENTITY] Fetch InvoicePaymentSelfPayingModel audit',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDIT_OK = '[ENTITY] Fetch InvoicePaymentSelfPayingModel audit successfully',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDIT_FAIL = '[ENTITY] Fetch InvoicePaymentSelfPayingModel audit failed',

	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoicePaymentSelfPayingModel audits by entity id',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoicePaymentSelfPayingModel audits by entity id successfully',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoicePaymentSelfPayingModel audits by entity id failed',

	FETCH_ALL_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Fetch all InvoicePaymentSelfPayingModel',
	FETCH_ALL_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Fetch all InvoicePaymentSelfPayingModel successfully',
	FETCH_ALL_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Fetch all InvoicePaymentSelfPayingModel failed',

	FETCH_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch InvoicePaymentSelfPayingModel with query',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch InvoicePaymentSelfPayingModel with query successfully',
	FETCH_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoicePaymentSelfPayingModel with query failed',

	FETCH_LAST_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY = '[ENTITY] Fetch last InvoicePaymentSelfPayingModel with query',
	FETCH_LAST_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY_OK = '[ENTITY] Fetch last InvoicePaymentSelfPayingModel with query successfully',
	FETCH_LAST_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoicePaymentSelfPayingModel with query failed',

	EXPORT_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Export InvoicePaymentSelfPayingModel',
	EXPORT_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export InvoicePaymentSelfPayingModel successfully',
	EXPORT_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export InvoicePaymentSelfPayingModel failed',

	EXPORT_ALL_INVOICE_PAYMENT_SELF_PAYING = '[ENTITY] Export All InvoicePaymentSelfPayingModels',
	EXPORT_ALL_INVOICE_PAYMENT_SELF_PAYING_OK = '[ENTITY] Export All InvoicePaymentSelfPayingModels successfully',
	EXPORT_ALL_INVOICE_PAYMENT_SELF_PAYING_FAIL = '[ENTITY] Export All InvoicePaymentSelfPayingModels failed',

	EXPORT_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS = '[ENTITY] Export InvoicePaymentSelfPayingModels excluding Ids',
	EXPORT_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS_OK = '[ENTITY] Export InvoicePaymentSelfPayingModel excluding Ids successfully',
	EXPORT_INVOICE_PAYMENT_SELF_PAYING_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoicePaymentSelfPayingModel excluding Ids failed',

	COUNT_INVOICE_PAYMENT_SELF_PAYINGS = '[ENTITY] Fetch number of InvoicePaymentSelfPayingModel records',
	COUNT_INVOICE_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Fetch number of InvoicePaymentSelfPayingModel records successfully ',
	COUNT_INVOICE_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Fetch number of InvoicePaymentSelfPayingModel records failed',

	IMPORT_INVOICE_PAYMENT_SELF_PAYINGS = '[ENTITY] Import InvoicePaymentSelfPayingModels',
	IMPORT_INVOICE_PAYMENT_SELF_PAYINGS_OK = '[ENTITY] Import InvoicePaymentSelfPayingModels successfully',
	IMPORT_INVOICE_PAYMENT_SELF_PAYINGS_FAIL = '[ENTITY] Import InvoicePaymentSelfPayingModels fail',


	INITIALISE_INVOICE_PAYMENT_SELF_PAYING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoicePaymentSelfPayingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoicePaymentSelfPayingAction implements Action {
	readonly className: string = 'InvoicePaymentSelfPayingModel';

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

export class InvoicePaymentSelfPayingAction extends BaseInvoicePaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingAction here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingAction here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingAction here] end
}

export class InvoicePaymentSelfPayingActionOK extends BaseInvoicePaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoicePaymentSelfPayingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingActionOK here] end
}

export class InvoicePaymentSelfPayingActionFail extends BaseInvoicePaymentSelfPayingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentSelfPayingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoicePaymentSelfPayingModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentSelfPayingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentSelfPayingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentSelfPayingActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentSelfPayingActionFail here] end
}

export function isInvoicePaymentSelfPayingModelAction(e: any): e is BaseInvoicePaymentSelfPayingAction {
	return Object.values(InvoicePaymentSelfPayingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
