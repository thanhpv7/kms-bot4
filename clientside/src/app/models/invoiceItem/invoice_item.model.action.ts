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
import {InvoiceItemModel} from './invoice_item.model';
import {InvoiceItemModelAudit} from './invoice_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Item model actions to be dispatched by NgRx.
 */
export enum InvoiceItemModelActionTypes {
	CREATE_INVOICE_ITEM = '[ENTITY] Create InvoiceItemModel',
	CREATE_INVOICE_ITEM_OK = '[ENTITY] Create InvoiceItemModel successfully',
	CREATE_INVOICE_ITEM_FAIL = '[ENTITY] Create InvoiceItemModel failed',

	CREATE_ALL_INVOICE_ITEM = '[ENTITY] Create All InvoiceItemModel',
	CREATE_ALL_INVOICE_ITEM_OK = '[ENTITY] Create All InvoiceItemModel successfully',
	CREATE_ALL_INVOICE_ITEM_FAIL = '[ENTITY] Create All InvoiceItemModel failed',

	DELETE_INVOICE_ITEM = '[ENTITY] Delete InvoiceItemModel',
	DELETE_INVOICE_ITEM_OK = '[ENTITY] Delete InvoiceItemModel successfully',
	DELETE_INVOICE_ITEM_FAIL = '[ENTITY] Delete InvoiceItemModel failed',


	DELETE_INVOICE_ITEM_EXCLUDING_IDS = '[ENTITY] Delete InvoiceItemModels Excluding Ids',
	DELETE_INVOICE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoiceItemModels Excluding Ids successfully',
	DELETE_INVOICE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoiceItemModels Excluding Ids failed',

	DELETE_ALL_INVOICE_ITEM = '[ENTITY] Delete all InvoiceItemModels',
	DELETE_ALL_INVOICE_ITEM_OK = '[ENTITY] Delete all InvoiceItemModels successfully',
	DELETE_ALL_INVOICE_ITEM_FAIL = '[ENTITY] Delete all InvoiceItemModels failed',

	UPDATE_INVOICE_ITEM = '[ENTITY] Update InvoiceItemModel',
	UPDATE_INVOICE_ITEM_OK = '[ENTITY] Update InvoiceItemModel successfully',
	UPDATE_INVOICE_ITEM_FAIL = '[ENTITY] Update InvoiceItemModel failed',

	UPDATE_ALL_INVOICE_ITEM = '[ENTITY] Update all InvoiceItemModel',
	UPDATE_ALL_INVOICE_ITEM_OK = '[ENTITY] Update all InvoiceItemModel successfully',
	UPDATE_ALL_INVOICE_ITEM_FAIL = '[ENTITY] Update all InvoiceItemModel failed',

	FETCH_INVOICE_ITEM= '[ENTITY] Fetch InvoiceItemModel',
	FETCH_INVOICE_ITEM_OK = '[ENTITY] Fetch InvoiceItemModel successfully',
	FETCH_INVOICE_ITEM_FAIL = '[ENTITY] Fetch InvoiceItemModel failed',

	FETCH_INVOICE_ITEM_AUDIT= '[ENTITY] Fetch InvoiceItemModel audit',
	FETCH_INVOICE_ITEM_AUDIT_OK = '[ENTITY] Fetch InvoiceItemModel audit successfully',
	FETCH_INVOICE_ITEM_AUDIT_FAIL = '[ENTITY] Fetch InvoiceItemModel audit failed',

	FETCH_INVOICE_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoiceItemModel audits by entity id',
	FETCH_INVOICE_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoiceItemModel audits by entity id successfully',
	FETCH_INVOICE_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoiceItemModel audits by entity id failed',

	FETCH_ALL_INVOICE_ITEM = '[ENTITY] Fetch all InvoiceItemModel',
	FETCH_ALL_INVOICE_ITEM_OK = '[ENTITY] Fetch all InvoiceItemModel successfully',
	FETCH_ALL_INVOICE_ITEM_FAIL = '[ENTITY] Fetch all InvoiceItemModel failed',

	FETCH_INVOICE_ITEM_WITH_QUERY = '[ENTITY] Fetch InvoiceItemModel with query',
	FETCH_INVOICE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch InvoiceItemModel with query successfully',
	FETCH_INVOICE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoiceItemModel with query failed',

	FETCH_LAST_INVOICE_ITEM_WITH_QUERY = '[ENTITY] Fetch last InvoiceItemModel with query',
	FETCH_LAST_INVOICE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last InvoiceItemModel with query successfully',
	FETCH_LAST_INVOICE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoiceItemModel with query failed',

	EXPORT_INVOICE_ITEM = '[ENTITY] Export InvoiceItemModel',
	EXPORT_INVOICE_ITEM_OK = '[ENTITY] Export InvoiceItemModel successfully',
	EXPORT_INVOICE_ITEM_FAIL = '[ENTITY] Export InvoiceItemModel failed',

	EXPORT_ALL_INVOICE_ITEM = '[ENTITY] Export All InvoiceItemModels',
	EXPORT_ALL_INVOICE_ITEM_OK = '[ENTITY] Export All InvoiceItemModels successfully',
	EXPORT_ALL_INVOICE_ITEM_FAIL = '[ENTITY] Export All InvoiceItemModels failed',

	EXPORT_INVOICE_ITEM_EXCLUDING_IDS = '[ENTITY] Export InvoiceItemModels excluding Ids',
	EXPORT_INVOICE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export InvoiceItemModel excluding Ids successfully',
	EXPORT_INVOICE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoiceItemModel excluding Ids failed',

	COUNT_INVOICE_ITEMS = '[ENTITY] Fetch number of InvoiceItemModel records',
	COUNT_INVOICE_ITEMS_OK = '[ENTITY] Fetch number of InvoiceItemModel records successfully ',
	COUNT_INVOICE_ITEMS_FAIL = '[ENTITY] Fetch number of InvoiceItemModel records failed',

	IMPORT_INVOICE_ITEMS = '[ENTITY] Import InvoiceItemModels',
	IMPORT_INVOICE_ITEMS_OK = '[ENTITY] Import InvoiceItemModels successfully',
	IMPORT_INVOICE_ITEMS_FAIL = '[ENTITY] Import InvoiceItemModels fail',


	INITIALISE_INVOICE_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoiceItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoiceItemAction implements Action {
	readonly className: string = 'InvoiceItemModel';

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

export class InvoiceItemAction extends BaseInvoiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemAction here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceItemModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemAction here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemAction here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemAction here] end
}

export class InvoiceItemActionOK extends BaseInvoiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceItemModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoiceItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemActionOK here] end
}

export class InvoiceItemActionFail extends BaseInvoiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoiceItemModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemActionFail here] end
}

export function isInvoiceItemModelAction(e: any): e is BaseInvoiceItemAction {
	return Object.values(InvoiceItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
