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
import {InvoiceModel} from './invoice.model';
import {InvoiceModelAudit} from './invoice.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice model actions to be dispatched by NgRx.
 */
export enum InvoiceModelActionTypes {
	CREATE_INVOICE = '[ENTITY] Create InvoiceModel',
	CREATE_INVOICE_OK = '[ENTITY] Create InvoiceModel successfully',
	CREATE_INVOICE_FAIL = '[ENTITY] Create InvoiceModel failed',

	CREATE_ALL_INVOICE = '[ENTITY] Create All InvoiceModel',
	CREATE_ALL_INVOICE_OK = '[ENTITY] Create All InvoiceModel successfully',
	CREATE_ALL_INVOICE_FAIL = '[ENTITY] Create All InvoiceModel failed',

	DELETE_INVOICE = '[ENTITY] Delete InvoiceModel',
	DELETE_INVOICE_OK = '[ENTITY] Delete InvoiceModel successfully',
	DELETE_INVOICE_FAIL = '[ENTITY] Delete InvoiceModel failed',


	DELETE_INVOICE_EXCLUDING_IDS = '[ENTITY] Delete InvoiceModels Excluding Ids',
	DELETE_INVOICE_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoiceModels Excluding Ids successfully',
	DELETE_INVOICE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoiceModels Excluding Ids failed',

	DELETE_ALL_INVOICE = '[ENTITY] Delete all InvoiceModels',
	DELETE_ALL_INVOICE_OK = '[ENTITY] Delete all InvoiceModels successfully',
	DELETE_ALL_INVOICE_FAIL = '[ENTITY] Delete all InvoiceModels failed',

	UPDATE_INVOICE = '[ENTITY] Update InvoiceModel',
	UPDATE_INVOICE_OK = '[ENTITY] Update InvoiceModel successfully',
	UPDATE_INVOICE_FAIL = '[ENTITY] Update InvoiceModel failed',

	UPDATE_ALL_INVOICE = '[ENTITY] Update all InvoiceModel',
	UPDATE_ALL_INVOICE_OK = '[ENTITY] Update all InvoiceModel successfully',
	UPDATE_ALL_INVOICE_FAIL = '[ENTITY] Update all InvoiceModel failed',

	FETCH_INVOICE= '[ENTITY] Fetch InvoiceModel',
	FETCH_INVOICE_OK = '[ENTITY] Fetch InvoiceModel successfully',
	FETCH_INVOICE_FAIL = '[ENTITY] Fetch InvoiceModel failed',

	FETCH_INVOICE_AUDIT= '[ENTITY] Fetch InvoiceModel audit',
	FETCH_INVOICE_AUDIT_OK = '[ENTITY] Fetch InvoiceModel audit successfully',
	FETCH_INVOICE_AUDIT_FAIL = '[ENTITY] Fetch InvoiceModel audit failed',

	FETCH_INVOICE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoiceModel audits by entity id',
	FETCH_INVOICE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoiceModel audits by entity id successfully',
	FETCH_INVOICE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoiceModel audits by entity id failed',

	FETCH_ALL_INVOICE = '[ENTITY] Fetch all InvoiceModel',
	FETCH_ALL_INVOICE_OK = '[ENTITY] Fetch all InvoiceModel successfully',
	FETCH_ALL_INVOICE_FAIL = '[ENTITY] Fetch all InvoiceModel failed',

	FETCH_INVOICE_WITH_QUERY = '[ENTITY] Fetch InvoiceModel with query',
	FETCH_INVOICE_WITH_QUERY_OK = '[ENTITY] Fetch InvoiceModel with query successfully',
	FETCH_INVOICE_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoiceModel with query failed',

	FETCH_LAST_INVOICE_WITH_QUERY = '[ENTITY] Fetch last InvoiceModel with query',
	FETCH_LAST_INVOICE_WITH_QUERY_OK = '[ENTITY] Fetch last InvoiceModel with query successfully',
	FETCH_LAST_INVOICE_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoiceModel with query failed',

	EXPORT_INVOICE = '[ENTITY] Export InvoiceModel',
	EXPORT_INVOICE_OK = '[ENTITY] Export InvoiceModel successfully',
	EXPORT_INVOICE_FAIL = '[ENTITY] Export InvoiceModel failed',

	EXPORT_ALL_INVOICE = '[ENTITY] Export All InvoiceModels',
	EXPORT_ALL_INVOICE_OK = '[ENTITY] Export All InvoiceModels successfully',
	EXPORT_ALL_INVOICE_FAIL = '[ENTITY] Export All InvoiceModels failed',

	EXPORT_INVOICE_EXCLUDING_IDS = '[ENTITY] Export InvoiceModels excluding Ids',
	EXPORT_INVOICE_EXCLUDING_IDS_OK = '[ENTITY] Export InvoiceModel excluding Ids successfully',
	EXPORT_INVOICE_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoiceModel excluding Ids failed',

	COUNT_INVOICES = '[ENTITY] Fetch number of InvoiceModel records',
	COUNT_INVOICES_OK = '[ENTITY] Fetch number of InvoiceModel records successfully ',
	COUNT_INVOICES_FAIL = '[ENTITY] Fetch number of InvoiceModel records failed',

	IMPORT_INVOICES = '[ENTITY] Import InvoiceModels',
	IMPORT_INVOICES_OK = '[ENTITY] Import InvoiceModels successfully',
	IMPORT_INVOICES_FAIL = '[ENTITY] Import InvoiceModels fail',


	INITIALISE_INVOICE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoiceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoiceAction implements Action {
	readonly className: string = 'InvoiceModel';

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

export class InvoiceAction extends BaseInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceAction here] off begin
	// % protected region % [Add any additional class fields for InvoiceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceAction here] end
	}

	// % protected region % [Add any additional class methods for InvoiceAction here] off begin
	// % protected region % [Add any additional class methods for InvoiceAction here] end
}

export class InvoiceActionOK extends BaseInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoiceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoiceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoiceActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoiceActionOK here] end
}

export class InvoiceActionFail extends BaseInvoiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoiceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoiceModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoiceActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoiceActionFail here] end
}

export function isInvoiceModelAction(e: any): e is BaseInvoiceAction {
	return Object.values(InvoiceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
