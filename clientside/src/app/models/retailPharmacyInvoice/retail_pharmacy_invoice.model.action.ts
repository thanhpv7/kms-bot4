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
import {RetailPharmacyInvoiceModel} from './retail_pharmacy_invoice.model';
import {RetailPharmacyInvoiceModelAudit} from './retail_pharmacy_invoice.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Retail Pharmacy Invoice model actions to be dispatched by NgRx.
 */
export enum RetailPharmacyInvoiceModelActionTypes {
	CREATE_RETAIL_PHARMACY_INVOICE = '[ENTITY] Create RetailPharmacyInvoiceModel',
	CREATE_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Create RetailPharmacyInvoiceModel successfully',
	CREATE_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Create RetailPharmacyInvoiceModel failed',

	CREATE_ALL_RETAIL_PHARMACY_INVOICE = '[ENTITY] Create All RetailPharmacyInvoiceModel',
	CREATE_ALL_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Create All RetailPharmacyInvoiceModel successfully',
	CREATE_ALL_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Create All RetailPharmacyInvoiceModel failed',

	DELETE_RETAIL_PHARMACY_INVOICE = '[ENTITY] Delete RetailPharmacyInvoiceModel',
	DELETE_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Delete RetailPharmacyInvoiceModel successfully',
	DELETE_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Delete RetailPharmacyInvoiceModel failed',


	DELETE_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS = '[ENTITY] Delete RetailPharmacyInvoiceModels Excluding Ids',
	DELETE_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS_OK = '[ENTITY] Delete RetailPharmacyInvoiceModels Excluding Ids successfully',
	DELETE_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RetailPharmacyInvoiceModels Excluding Ids failed',

	DELETE_ALL_RETAIL_PHARMACY_INVOICE = '[ENTITY] Delete all RetailPharmacyInvoiceModels',
	DELETE_ALL_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Delete all RetailPharmacyInvoiceModels successfully',
	DELETE_ALL_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Delete all RetailPharmacyInvoiceModels failed',

	UPDATE_RETAIL_PHARMACY_INVOICE = '[ENTITY] Update RetailPharmacyInvoiceModel',
	UPDATE_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Update RetailPharmacyInvoiceModel successfully',
	UPDATE_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Update RetailPharmacyInvoiceModel failed',

	UPDATE_ALL_RETAIL_PHARMACY_INVOICE = '[ENTITY] Update all RetailPharmacyInvoiceModel',
	UPDATE_ALL_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Update all RetailPharmacyInvoiceModel successfully',
	UPDATE_ALL_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Update all RetailPharmacyInvoiceModel failed',

	FETCH_RETAIL_PHARMACY_INVOICE= '[ENTITY] Fetch RetailPharmacyInvoiceModel',
	FETCH_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Fetch RetailPharmacyInvoiceModel successfully',
	FETCH_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Fetch RetailPharmacyInvoiceModel failed',

	FETCH_RETAIL_PHARMACY_INVOICE_AUDIT= '[ENTITY] Fetch RetailPharmacyInvoiceModel audit',
	FETCH_RETAIL_PHARMACY_INVOICE_AUDIT_OK = '[ENTITY] Fetch RetailPharmacyInvoiceModel audit successfully',
	FETCH_RETAIL_PHARMACY_INVOICE_AUDIT_FAIL = '[ENTITY] Fetch RetailPharmacyInvoiceModel audit failed',

	FETCH_RETAIL_PHARMACY_INVOICE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RetailPharmacyInvoiceModel audits by entity id',
	FETCH_RETAIL_PHARMACY_INVOICE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RetailPharmacyInvoiceModel audits by entity id successfully',
	FETCH_RETAIL_PHARMACY_INVOICE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RetailPharmacyInvoiceModel audits by entity id failed',

	FETCH_ALL_RETAIL_PHARMACY_INVOICE = '[ENTITY] Fetch all RetailPharmacyInvoiceModel',
	FETCH_ALL_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Fetch all RetailPharmacyInvoiceModel successfully',
	FETCH_ALL_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Fetch all RetailPharmacyInvoiceModel failed',

	FETCH_RETAIL_PHARMACY_INVOICE_WITH_QUERY = '[ENTITY] Fetch RetailPharmacyInvoiceModel with query',
	FETCH_RETAIL_PHARMACY_INVOICE_WITH_QUERY_OK = '[ENTITY] Fetch RetailPharmacyInvoiceModel with query successfully',
	FETCH_RETAIL_PHARMACY_INVOICE_WITH_QUERY_FAIL = '[ENTITY] Fetch RetailPharmacyInvoiceModel with query failed',

	FETCH_LAST_RETAIL_PHARMACY_INVOICE_WITH_QUERY = '[ENTITY] Fetch last RetailPharmacyInvoiceModel with query',
	FETCH_LAST_RETAIL_PHARMACY_INVOICE_WITH_QUERY_OK = '[ENTITY] Fetch last RetailPharmacyInvoiceModel with query successfully',
	FETCH_LAST_RETAIL_PHARMACY_INVOICE_WITH_QUERY_FAIL = '[ENTITY] Fetch last RetailPharmacyInvoiceModel with query failed',

	EXPORT_RETAIL_PHARMACY_INVOICE = '[ENTITY] Export RetailPharmacyInvoiceModel',
	EXPORT_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Export RetailPharmacyInvoiceModel successfully',
	EXPORT_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Export RetailPharmacyInvoiceModel failed',

	EXPORT_ALL_RETAIL_PHARMACY_INVOICE = '[ENTITY] Export All RetailPharmacyInvoiceModels',
	EXPORT_ALL_RETAIL_PHARMACY_INVOICE_OK = '[ENTITY] Export All RetailPharmacyInvoiceModels successfully',
	EXPORT_ALL_RETAIL_PHARMACY_INVOICE_FAIL = '[ENTITY] Export All RetailPharmacyInvoiceModels failed',

	EXPORT_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS = '[ENTITY] Export RetailPharmacyInvoiceModels excluding Ids',
	EXPORT_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS_OK = '[ENTITY] Export RetailPharmacyInvoiceModel excluding Ids successfully',
	EXPORT_RETAIL_PHARMACY_INVOICE_EXCLUDING_IDS_FAIL = '[ENTITY] Export RetailPharmacyInvoiceModel excluding Ids failed',

	COUNT_RETAIL_PHARMACY_INVOICES = '[ENTITY] Fetch number of RetailPharmacyInvoiceModel records',
	COUNT_RETAIL_PHARMACY_INVOICES_OK = '[ENTITY] Fetch number of RetailPharmacyInvoiceModel records successfully ',
	COUNT_RETAIL_PHARMACY_INVOICES_FAIL = '[ENTITY] Fetch number of RetailPharmacyInvoiceModel records failed',

	IMPORT_RETAIL_PHARMACY_INVOICES = '[ENTITY] Import RetailPharmacyInvoiceModels',
	IMPORT_RETAIL_PHARMACY_INVOICES_OK = '[ENTITY] Import RetailPharmacyInvoiceModels successfully',
	IMPORT_RETAIL_PHARMACY_INVOICES_FAIL = '[ENTITY] Import RetailPharmacyInvoiceModels fail',


	INITIALISE_RETAIL_PHARMACY_INVOICE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RetailPharmacyInvoiceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRetailPharmacyInvoiceAction implements Action {
	readonly className: string = 'RetailPharmacyInvoiceModel';

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

export class RetailPharmacyInvoiceAction extends BaseRetailPharmacyInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceAction here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyInvoiceModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceAction here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceAction here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceAction here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceAction here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceAction here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceAction here] end
}

export class RetailPharmacyInvoiceActionOK extends BaseRetailPharmacyInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceActionOK here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyInvoiceModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RetailPharmacyInvoiceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceActionOK here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceActionOK here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceActionOK here] end
}

export class RetailPharmacyInvoiceActionFail extends BaseRetailPharmacyInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceActionFail here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyInvoiceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RetailPharmacyInvoiceModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyInvoiceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyInvoiceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyInvoiceActionFail here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceActionFail here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyInvoiceActionFail here] end
}

export function isRetailPharmacyInvoiceModelAction(e: any): e is BaseRetailPharmacyInvoiceAction {
	return Object.values(RetailPharmacyInvoiceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
