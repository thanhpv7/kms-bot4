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
import {InvoicePaymentInsuranceModel} from './invoice_payment_insurance.model';
import {InvoicePaymentInsuranceModelAudit} from './invoice_payment_insurance.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Payment Insurance model actions to be dispatched by NgRx.
 */
export enum InvoicePaymentInsuranceModelActionTypes {
	CREATE_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Create InvoicePaymentInsuranceModel',
	CREATE_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Create InvoicePaymentInsuranceModel successfully',
	CREATE_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create InvoicePaymentInsuranceModel failed',

	CREATE_ALL_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Create All InvoicePaymentInsuranceModel',
	CREATE_ALL_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Create All InvoicePaymentInsuranceModel successfully',
	CREATE_ALL_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Create All InvoicePaymentInsuranceModel failed',

	DELETE_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Delete InvoicePaymentInsuranceModel',
	DELETE_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Delete InvoicePaymentInsuranceModel successfully',
	DELETE_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete InvoicePaymentInsuranceModel failed',


	DELETE_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Delete InvoicePaymentInsuranceModels Excluding Ids',
	DELETE_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoicePaymentInsuranceModels Excluding Ids successfully',
	DELETE_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoicePaymentInsuranceModels Excluding Ids failed',

	DELETE_ALL_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Delete all InvoicePaymentInsuranceModels',
	DELETE_ALL_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Delete all InvoicePaymentInsuranceModels successfully',
	DELETE_ALL_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Delete all InvoicePaymentInsuranceModels failed',

	UPDATE_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Update InvoicePaymentInsuranceModel',
	UPDATE_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Update InvoicePaymentInsuranceModel successfully',
	UPDATE_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update InvoicePaymentInsuranceModel failed',

	UPDATE_ALL_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Update all InvoicePaymentInsuranceModel',
	UPDATE_ALL_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Update all InvoicePaymentInsuranceModel successfully',
	UPDATE_ALL_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Update all InvoicePaymentInsuranceModel failed',

	FETCH_INVOICE_PAYMENT_INSURANCE= '[ENTITY] Fetch InvoicePaymentInsuranceModel',
	FETCH_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch InvoicePaymentInsuranceModel successfully',
	FETCH_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch InvoicePaymentInsuranceModel failed',

	FETCH_INVOICE_PAYMENT_INSURANCE_AUDIT= '[ENTITY] Fetch InvoicePaymentInsuranceModel audit',
	FETCH_INVOICE_PAYMENT_INSURANCE_AUDIT_OK = '[ENTITY] Fetch InvoicePaymentInsuranceModel audit successfully',
	FETCH_INVOICE_PAYMENT_INSURANCE_AUDIT_FAIL = '[ENTITY] Fetch InvoicePaymentInsuranceModel audit failed',

	FETCH_INVOICE_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoicePaymentInsuranceModel audits by entity id',
	FETCH_INVOICE_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoicePaymentInsuranceModel audits by entity id successfully',
	FETCH_INVOICE_PAYMENT_INSURANCE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoicePaymentInsuranceModel audits by entity id failed',

	FETCH_ALL_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Fetch all InvoicePaymentInsuranceModel',
	FETCH_ALL_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Fetch all InvoicePaymentInsuranceModel successfully',
	FETCH_ALL_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Fetch all InvoicePaymentInsuranceModel failed',

	FETCH_INVOICE_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch InvoicePaymentInsuranceModel with query',
	FETCH_INVOICE_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch InvoicePaymentInsuranceModel with query successfully',
	FETCH_INVOICE_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoicePaymentInsuranceModel with query failed',

	FETCH_LAST_INVOICE_PAYMENT_INSURANCE_WITH_QUERY = '[ENTITY] Fetch last InvoicePaymentInsuranceModel with query',
	FETCH_LAST_INVOICE_PAYMENT_INSURANCE_WITH_QUERY_OK = '[ENTITY] Fetch last InvoicePaymentInsuranceModel with query successfully',
	FETCH_LAST_INVOICE_PAYMENT_INSURANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoicePaymentInsuranceModel with query failed',

	EXPORT_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Export InvoicePaymentInsuranceModel',
	EXPORT_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Export InvoicePaymentInsuranceModel successfully',
	EXPORT_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export InvoicePaymentInsuranceModel failed',

	EXPORT_ALL_INVOICE_PAYMENT_INSURANCE = '[ENTITY] Export All InvoicePaymentInsuranceModels',
	EXPORT_ALL_INVOICE_PAYMENT_INSURANCE_OK = '[ENTITY] Export All InvoicePaymentInsuranceModels successfully',
	EXPORT_ALL_INVOICE_PAYMENT_INSURANCE_FAIL = '[ENTITY] Export All InvoicePaymentInsuranceModels failed',

	EXPORT_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS = '[ENTITY] Export InvoicePaymentInsuranceModels excluding Ids',
	EXPORT_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS_OK = '[ENTITY] Export InvoicePaymentInsuranceModel excluding Ids successfully',
	EXPORT_INVOICE_PAYMENT_INSURANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoicePaymentInsuranceModel excluding Ids failed',

	COUNT_INVOICE_PAYMENT_INSURANCES = '[ENTITY] Fetch number of InvoicePaymentInsuranceModel records',
	COUNT_INVOICE_PAYMENT_INSURANCES_OK = '[ENTITY] Fetch number of InvoicePaymentInsuranceModel records successfully ',
	COUNT_INVOICE_PAYMENT_INSURANCES_FAIL = '[ENTITY] Fetch number of InvoicePaymentInsuranceModel records failed',

	IMPORT_INVOICE_PAYMENT_INSURANCES = '[ENTITY] Import InvoicePaymentInsuranceModels',
	IMPORT_INVOICE_PAYMENT_INSURANCES_OK = '[ENTITY] Import InvoicePaymentInsuranceModels successfully',
	IMPORT_INVOICE_PAYMENT_INSURANCES_FAIL = '[ENTITY] Import InvoicePaymentInsuranceModels fail',


	INITIALISE_INVOICE_PAYMENT_INSURANCE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoicePaymentInsuranceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoicePaymentInsuranceAction implements Action {
	readonly className: string = 'InvoicePaymentInsuranceModel';

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

export class InvoicePaymentInsuranceAction extends BaseInvoicePaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceAction here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceAction here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceAction here] end
}

export class InvoicePaymentInsuranceActionOK extends BaseInvoicePaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoicePaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoicePaymentInsuranceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceActionOK here] end
}

export class InvoicePaymentInsuranceActionFail extends BaseInvoicePaymentInsuranceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoicePaymentInsuranceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoicePaymentInsuranceModel>,
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoicePaymentInsuranceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoicePaymentInsuranceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoicePaymentInsuranceActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoicePaymentInsuranceActionFail here] end
}

export function isInvoicePaymentInsuranceModelAction(e: any): e is BaseInvoicePaymentInsuranceAction {
	return Object.values(InvoicePaymentInsuranceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
