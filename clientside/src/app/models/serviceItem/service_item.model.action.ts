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
import {ServiceItemModel} from './service_item.model';
import {ServiceItemModelAudit} from './service_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Service Item model actions to be dispatched by NgRx.
 */
export enum ServiceItemModelActionTypes {
	CREATE_SERVICE_ITEM = '[ENTITY] Create ServiceItemModel',
	CREATE_SERVICE_ITEM_OK = '[ENTITY] Create ServiceItemModel successfully',
	CREATE_SERVICE_ITEM_FAIL = '[ENTITY] Create ServiceItemModel failed',

	CREATE_ALL_SERVICE_ITEM = '[ENTITY] Create All ServiceItemModel',
	CREATE_ALL_SERVICE_ITEM_OK = '[ENTITY] Create All ServiceItemModel successfully',
	CREATE_ALL_SERVICE_ITEM_FAIL = '[ENTITY] Create All ServiceItemModel failed',

	DELETE_SERVICE_ITEM = '[ENTITY] Delete ServiceItemModel',
	DELETE_SERVICE_ITEM_OK = '[ENTITY] Delete ServiceItemModel successfully',
	DELETE_SERVICE_ITEM_FAIL = '[ENTITY] Delete ServiceItemModel failed',


	DELETE_SERVICE_ITEM_EXCLUDING_IDS = '[ENTITY] Delete ServiceItemModels Excluding Ids',
	DELETE_SERVICE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete ServiceItemModels Excluding Ids successfully',
	DELETE_SERVICE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ServiceItemModels Excluding Ids failed',

	DELETE_ALL_SERVICE_ITEM = '[ENTITY] Delete all ServiceItemModels',
	DELETE_ALL_SERVICE_ITEM_OK = '[ENTITY] Delete all ServiceItemModels successfully',
	DELETE_ALL_SERVICE_ITEM_FAIL = '[ENTITY] Delete all ServiceItemModels failed',

	UPDATE_SERVICE_ITEM = '[ENTITY] Update ServiceItemModel',
	UPDATE_SERVICE_ITEM_OK = '[ENTITY] Update ServiceItemModel successfully',
	UPDATE_SERVICE_ITEM_FAIL = '[ENTITY] Update ServiceItemModel failed',

	UPDATE_ALL_SERVICE_ITEM = '[ENTITY] Update all ServiceItemModel',
	UPDATE_ALL_SERVICE_ITEM_OK = '[ENTITY] Update all ServiceItemModel successfully',
	UPDATE_ALL_SERVICE_ITEM_FAIL = '[ENTITY] Update all ServiceItemModel failed',

	FETCH_SERVICE_ITEM= '[ENTITY] Fetch ServiceItemModel',
	FETCH_SERVICE_ITEM_OK = '[ENTITY] Fetch ServiceItemModel successfully',
	FETCH_SERVICE_ITEM_FAIL = '[ENTITY] Fetch ServiceItemModel failed',

	FETCH_SERVICE_ITEM_AUDIT= '[ENTITY] Fetch ServiceItemModel audit',
	FETCH_SERVICE_ITEM_AUDIT_OK = '[ENTITY] Fetch ServiceItemModel audit successfully',
	FETCH_SERVICE_ITEM_AUDIT_FAIL = '[ENTITY] Fetch ServiceItemModel audit failed',

	FETCH_SERVICE_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ServiceItemModel audits by entity id',
	FETCH_SERVICE_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ServiceItemModel audits by entity id successfully',
	FETCH_SERVICE_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ServiceItemModel audits by entity id failed',

	FETCH_ALL_SERVICE_ITEM = '[ENTITY] Fetch all ServiceItemModel',
	FETCH_ALL_SERVICE_ITEM_OK = '[ENTITY] Fetch all ServiceItemModel successfully',
	FETCH_ALL_SERVICE_ITEM_FAIL = '[ENTITY] Fetch all ServiceItemModel failed',

	FETCH_SERVICE_ITEM_WITH_QUERY = '[ENTITY] Fetch ServiceItemModel with query',
	FETCH_SERVICE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch ServiceItemModel with query successfully',
	FETCH_SERVICE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch ServiceItemModel with query failed',

	FETCH_LAST_SERVICE_ITEM_WITH_QUERY = '[ENTITY] Fetch last ServiceItemModel with query',
	FETCH_LAST_SERVICE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last ServiceItemModel with query successfully',
	FETCH_LAST_SERVICE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last ServiceItemModel with query failed',

	EXPORT_SERVICE_ITEM = '[ENTITY] Export ServiceItemModel',
	EXPORT_SERVICE_ITEM_OK = '[ENTITY] Export ServiceItemModel successfully',
	EXPORT_SERVICE_ITEM_FAIL = '[ENTITY] Export ServiceItemModel failed',

	EXPORT_ALL_SERVICE_ITEM = '[ENTITY] Export All ServiceItemModels',
	EXPORT_ALL_SERVICE_ITEM_OK = '[ENTITY] Export All ServiceItemModels successfully',
	EXPORT_ALL_SERVICE_ITEM_FAIL = '[ENTITY] Export All ServiceItemModels failed',

	EXPORT_SERVICE_ITEM_EXCLUDING_IDS = '[ENTITY] Export ServiceItemModels excluding Ids',
	EXPORT_SERVICE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export ServiceItemModel excluding Ids successfully',
	EXPORT_SERVICE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export ServiceItemModel excluding Ids failed',

	COUNT_SERVICE_ITEMS = '[ENTITY] Fetch number of ServiceItemModel records',
	COUNT_SERVICE_ITEMS_OK = '[ENTITY] Fetch number of ServiceItemModel records successfully ',
	COUNT_SERVICE_ITEMS_FAIL = '[ENTITY] Fetch number of ServiceItemModel records failed',

	IMPORT_SERVICE_ITEMS = '[ENTITY] Import ServiceItemModels',
	IMPORT_SERVICE_ITEMS_OK = '[ENTITY] Import ServiceItemModels successfully',
	IMPORT_SERVICE_ITEMS_FAIL = '[ENTITY] Import ServiceItemModels fail',


	INITIALISE_SERVICE_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ServiceItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseServiceItemAction implements Action {
	readonly className: string = 'ServiceItemModel';

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

export class ServiceItemAction extends BaseServiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemAction here] off begin
	// % protected region % [Add any additional class fields for ServiceItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceItemModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemAction here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemAction here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemAction here] off begin
	// % protected region % [Add any additional class methods for ServiceItemAction here] end
}

export class ServiceItemActionOK extends BaseServiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemActionOK here] off begin
	// % protected region % [Add any additional class fields for ServiceItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceItemModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ServiceItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemActionOK here] off begin
	// % protected region % [Add any additional class methods for ServiceItemActionOK here] end
}

export class ServiceItemActionFail extends BaseServiceItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceItemActionFail here] off begin
	// % protected region % [Add any additional class fields for ServiceItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ServiceItemModel>,
		// % protected region % [Add any additional constructor parameters for ServiceItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ServiceItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for ServiceItemActionFail here] off begin
	// % protected region % [Add any additional class methods for ServiceItemActionFail here] end
}

export function isServiceItemModelAction(e: any): e is BaseServiceItemAction {
	return Object.values(ServiceItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
