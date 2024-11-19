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
import {InvoiceItemComponentModel} from './invoice_item_component.model';
import {InvoiceItemComponentModelAudit} from './invoice_item_component.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Item Component model actions to be dispatched by NgRx.
 */
export enum InvoiceItemComponentModelActionTypes {
	CREATE_INVOICE_ITEM_COMPONENT = '[ENTITY] Create InvoiceItemComponentModel',
	CREATE_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Create InvoiceItemComponentModel successfully',
	CREATE_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Create InvoiceItemComponentModel failed',

	CREATE_ALL_INVOICE_ITEM_COMPONENT = '[ENTITY] Create All InvoiceItemComponentModel',
	CREATE_ALL_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Create All InvoiceItemComponentModel successfully',
	CREATE_ALL_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Create All InvoiceItemComponentModel failed',

	DELETE_INVOICE_ITEM_COMPONENT = '[ENTITY] Delete InvoiceItemComponentModel',
	DELETE_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Delete InvoiceItemComponentModel successfully',
	DELETE_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Delete InvoiceItemComponentModel failed',


	DELETE_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS = '[ENTITY] Delete InvoiceItemComponentModels Excluding Ids',
	DELETE_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoiceItemComponentModels Excluding Ids successfully',
	DELETE_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoiceItemComponentModels Excluding Ids failed',

	DELETE_ALL_INVOICE_ITEM_COMPONENT = '[ENTITY] Delete all InvoiceItemComponentModels',
	DELETE_ALL_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Delete all InvoiceItemComponentModels successfully',
	DELETE_ALL_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Delete all InvoiceItemComponentModels failed',

	UPDATE_INVOICE_ITEM_COMPONENT = '[ENTITY] Update InvoiceItemComponentModel',
	UPDATE_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Update InvoiceItemComponentModel successfully',
	UPDATE_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Update InvoiceItemComponentModel failed',

	UPDATE_ALL_INVOICE_ITEM_COMPONENT = '[ENTITY] Update all InvoiceItemComponentModel',
	UPDATE_ALL_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Update all InvoiceItemComponentModel successfully',
	UPDATE_ALL_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Update all InvoiceItemComponentModel failed',

	FETCH_INVOICE_ITEM_COMPONENT= '[ENTITY] Fetch InvoiceItemComponentModel',
	FETCH_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Fetch InvoiceItemComponentModel successfully',
	FETCH_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Fetch InvoiceItemComponentModel failed',

	FETCH_INVOICE_ITEM_COMPONENT_AUDIT= '[ENTITY] Fetch InvoiceItemComponentModel audit',
	FETCH_INVOICE_ITEM_COMPONENT_AUDIT_OK = '[ENTITY] Fetch InvoiceItemComponentModel audit successfully',
	FETCH_INVOICE_ITEM_COMPONENT_AUDIT_FAIL = '[ENTITY] Fetch InvoiceItemComponentModel audit failed',

	FETCH_INVOICE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoiceItemComponentModel audits by entity id',
	FETCH_INVOICE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoiceItemComponentModel audits by entity id successfully',
	FETCH_INVOICE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoiceItemComponentModel audits by entity id failed',

	FETCH_ALL_INVOICE_ITEM_COMPONENT = '[ENTITY] Fetch all InvoiceItemComponentModel',
	FETCH_ALL_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Fetch all InvoiceItemComponentModel successfully',
	FETCH_ALL_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Fetch all InvoiceItemComponentModel failed',

	FETCH_INVOICE_ITEM_COMPONENT_WITH_QUERY = '[ENTITY] Fetch InvoiceItemComponentModel with query',
	FETCH_INVOICE_ITEM_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch InvoiceItemComponentModel with query successfully',
	FETCH_INVOICE_ITEM_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoiceItemComponentModel with query failed',

	FETCH_LAST_INVOICE_ITEM_COMPONENT_WITH_QUERY = '[ENTITY] Fetch last InvoiceItemComponentModel with query',
	FETCH_LAST_INVOICE_ITEM_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch last InvoiceItemComponentModel with query successfully',
	FETCH_LAST_INVOICE_ITEM_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoiceItemComponentModel with query failed',

	EXPORT_INVOICE_ITEM_COMPONENT = '[ENTITY] Export InvoiceItemComponentModel',
	EXPORT_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Export InvoiceItemComponentModel successfully',
	EXPORT_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Export InvoiceItemComponentModel failed',

	EXPORT_ALL_INVOICE_ITEM_COMPONENT = '[ENTITY] Export All InvoiceItemComponentModels',
	EXPORT_ALL_INVOICE_ITEM_COMPONENT_OK = '[ENTITY] Export All InvoiceItemComponentModels successfully',
	EXPORT_ALL_INVOICE_ITEM_COMPONENT_FAIL = '[ENTITY] Export All InvoiceItemComponentModels failed',

	EXPORT_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS = '[ENTITY] Export InvoiceItemComponentModels excluding Ids',
	EXPORT_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Export InvoiceItemComponentModel excluding Ids successfully',
	EXPORT_INVOICE_ITEM_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoiceItemComponentModel excluding Ids failed',

	COUNT_INVOICE_ITEM_COMPONENTS = '[ENTITY] Fetch number of InvoiceItemComponentModel records',
	COUNT_INVOICE_ITEM_COMPONENTS_OK = '[ENTITY] Fetch number of InvoiceItemComponentModel records successfully ',
	COUNT_INVOICE_ITEM_COMPONENTS_FAIL = '[ENTITY] Fetch number of InvoiceItemComponentModel records failed',

	IMPORT_INVOICE_ITEM_COMPONENTS = '[ENTITY] Import InvoiceItemComponentModels',
	IMPORT_INVOICE_ITEM_COMPONENTS_OK = '[ENTITY] Import InvoiceItemComponentModels successfully',
	IMPORT_INVOICE_ITEM_COMPONENTS_FAIL = '[ENTITY] Import InvoiceItemComponentModels fail',


	INITIALISE_INVOICE_ITEM_COMPONENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoiceItemComponentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoiceItemComponentAction implements Action {
	readonly className: string = 'InvoiceItemComponentModel';

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

export class InvoiceItemComponentAction extends BaseInvoiceItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemComponentAction here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemComponentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentAction here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemComponentAction here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemComponentAction here] end
}

export class InvoiceItemComponentActionOK extends BaseInvoiceItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemComponentActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemComponentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoiceItemComponentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemComponentActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemComponentActionOK here] end
}

export class InvoiceItemComponentActionFail extends BaseInvoiceItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceItemComponentActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoiceItemComponentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoiceItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceItemComponentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceItemComponentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceItemComponentActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoiceItemComponentActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoiceItemComponentActionFail here] end
}

export function isInvoiceItemComponentModelAction(e: any): e is BaseInvoiceItemComponentAction {
	return Object.values(InvoiceItemComponentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
