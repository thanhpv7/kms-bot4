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
import {ServiceFacilityCategoryModel} from './service_facility_category.model';
import {ServiceFacilityCategoryModelAudit} from './service_facility_category.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Service Facility Category model actions to be dispatched by NgRx.
 */
export enum ServiceFacilityCategoryModelActionTypes {
	CREATE_SERVICE_FACILITY_CATEGORY = '[ENTITY] Create ServiceFacilityCategoryModel',
	CREATE_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Create ServiceFacilityCategoryModel successfully',
	CREATE_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Create ServiceFacilityCategoryModel failed',

	CREATE_ALL_SERVICE_FACILITY_CATEGORY = '[ENTITY] Create All ServiceFacilityCategoryModel',
	CREATE_ALL_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Create All ServiceFacilityCategoryModel successfully',
	CREATE_ALL_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Create All ServiceFacilityCategoryModel failed',

	DELETE_SERVICE_FACILITY_CATEGORY = '[ENTITY] Delete ServiceFacilityCategoryModel',
	DELETE_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Delete ServiceFacilityCategoryModel successfully',
	DELETE_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Delete ServiceFacilityCategoryModel failed',


	DELETE_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS = '[ENTITY] Delete ServiceFacilityCategoryModels Excluding Ids',
	DELETE_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS_OK = '[ENTITY] Delete ServiceFacilityCategoryModels Excluding Ids successfully',
	DELETE_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ServiceFacilityCategoryModels Excluding Ids failed',

	DELETE_ALL_SERVICE_FACILITY_CATEGORY = '[ENTITY] Delete all ServiceFacilityCategoryModels',
	DELETE_ALL_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Delete all ServiceFacilityCategoryModels successfully',
	DELETE_ALL_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Delete all ServiceFacilityCategoryModels failed',

	UPDATE_SERVICE_FACILITY_CATEGORY = '[ENTITY] Update ServiceFacilityCategoryModel',
	UPDATE_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Update ServiceFacilityCategoryModel successfully',
	UPDATE_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Update ServiceFacilityCategoryModel failed',

	UPDATE_ALL_SERVICE_FACILITY_CATEGORY = '[ENTITY] Update all ServiceFacilityCategoryModel',
	UPDATE_ALL_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Update all ServiceFacilityCategoryModel successfully',
	UPDATE_ALL_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Update all ServiceFacilityCategoryModel failed',

	FETCH_SERVICE_FACILITY_CATEGORY= '[ENTITY] Fetch ServiceFacilityCategoryModel',
	FETCH_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Fetch ServiceFacilityCategoryModel successfully',
	FETCH_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Fetch ServiceFacilityCategoryModel failed',

	FETCH_SERVICE_FACILITY_CATEGORY_AUDIT= '[ENTITY] Fetch ServiceFacilityCategoryModel audit',
	FETCH_SERVICE_FACILITY_CATEGORY_AUDIT_OK = '[ENTITY] Fetch ServiceFacilityCategoryModel audit successfully',
	FETCH_SERVICE_FACILITY_CATEGORY_AUDIT_FAIL = '[ENTITY] Fetch ServiceFacilityCategoryModel audit failed',

	FETCH_SERVICE_FACILITY_CATEGORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ServiceFacilityCategoryModel audits by entity id',
	FETCH_SERVICE_FACILITY_CATEGORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ServiceFacilityCategoryModel audits by entity id successfully',
	FETCH_SERVICE_FACILITY_CATEGORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ServiceFacilityCategoryModel audits by entity id failed',

	FETCH_ALL_SERVICE_FACILITY_CATEGORY = '[ENTITY] Fetch all ServiceFacilityCategoryModel',
	FETCH_ALL_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Fetch all ServiceFacilityCategoryModel successfully',
	FETCH_ALL_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Fetch all ServiceFacilityCategoryModel failed',

	FETCH_SERVICE_FACILITY_CATEGORY_WITH_QUERY = '[ENTITY] Fetch ServiceFacilityCategoryModel with query',
	FETCH_SERVICE_FACILITY_CATEGORY_WITH_QUERY_OK = '[ENTITY] Fetch ServiceFacilityCategoryModel with query successfully',
	FETCH_SERVICE_FACILITY_CATEGORY_WITH_QUERY_FAIL = '[ENTITY] Fetch ServiceFacilityCategoryModel with query failed',

	FETCH_LAST_SERVICE_FACILITY_CATEGORY_WITH_QUERY = '[ENTITY] Fetch last ServiceFacilityCategoryModel with query',
	FETCH_LAST_SERVICE_FACILITY_CATEGORY_WITH_QUERY_OK = '[ENTITY] Fetch last ServiceFacilityCategoryModel with query successfully',
	FETCH_LAST_SERVICE_FACILITY_CATEGORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last ServiceFacilityCategoryModel with query failed',

	EXPORT_SERVICE_FACILITY_CATEGORY = '[ENTITY] Export ServiceFacilityCategoryModel',
	EXPORT_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Export ServiceFacilityCategoryModel successfully',
	EXPORT_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Export ServiceFacilityCategoryModel failed',

	EXPORT_ALL_SERVICE_FACILITY_CATEGORY = '[ENTITY] Export All ServiceFacilityCategoryModels',
	EXPORT_ALL_SERVICE_FACILITY_CATEGORY_OK = '[ENTITY] Export All ServiceFacilityCategoryModels successfully',
	EXPORT_ALL_SERVICE_FACILITY_CATEGORY_FAIL = '[ENTITY] Export All ServiceFacilityCategoryModels failed',

	EXPORT_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS = '[ENTITY] Export ServiceFacilityCategoryModels excluding Ids',
	EXPORT_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS_OK = '[ENTITY] Export ServiceFacilityCategoryModel excluding Ids successfully',
	EXPORT_SERVICE_FACILITY_CATEGORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export ServiceFacilityCategoryModel excluding Ids failed',

	COUNT_SERVICE_FACILITY_CATEGORYS = '[ENTITY] Fetch number of ServiceFacilityCategoryModel records',
	COUNT_SERVICE_FACILITY_CATEGORYS_OK = '[ENTITY] Fetch number of ServiceFacilityCategoryModel records successfully ',
	COUNT_SERVICE_FACILITY_CATEGORYS_FAIL = '[ENTITY] Fetch number of ServiceFacilityCategoryModel records failed',

	IMPORT_SERVICE_FACILITY_CATEGORYS = '[ENTITY] Import ServiceFacilityCategoryModels',
	IMPORT_SERVICE_FACILITY_CATEGORYS_OK = '[ENTITY] Import ServiceFacilityCategoryModels successfully',
	IMPORT_SERVICE_FACILITY_CATEGORYS_FAIL = '[ENTITY] Import ServiceFacilityCategoryModels fail',


	INITIALISE_SERVICE_FACILITY_CATEGORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ServiceFacilityCategoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseServiceFacilityCategoryAction implements Action {
	readonly className: string = 'ServiceFacilityCategoryModel';

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

export class ServiceFacilityCategoryAction extends BaseServiceFacilityCategoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceFacilityCategoryAction here] off begin
	// % protected region % [Add any additional class fields for ServiceFacilityCategoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceFacilityCategoryModel>,
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryAction here] off begin
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryAction here] end
	}

	// % protected region % [Add any additional class methods for ServiceFacilityCategoryAction here] off begin
	// % protected region % [Add any additional class methods for ServiceFacilityCategoryAction here] end
}

export class ServiceFacilityCategoryActionOK extends BaseServiceFacilityCategoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceFacilityCategoryActionOK here] off begin
	// % protected region % [Add any additional class fields for ServiceFacilityCategoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceFacilityCategoryModel>,
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ServiceFacilityCategoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for ServiceFacilityCategoryActionOK here] off begin
	// % protected region % [Add any additional class methods for ServiceFacilityCategoryActionOK here] end
}

export class ServiceFacilityCategoryActionFail extends BaseServiceFacilityCategoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceFacilityCategoryActionFail here] off begin
	// % protected region % [Add any additional class fields for ServiceFacilityCategoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ServiceFacilityCategoryModel>,
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceFacilityCategoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceFacilityCategoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ServiceFacilityCategoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for ServiceFacilityCategoryActionFail here] off begin
	// % protected region % [Add any additional class methods for ServiceFacilityCategoryActionFail here] end
}

export function isServiceFacilityCategoryModelAction(e: any): e is BaseServiceFacilityCategoryAction {
	return Object.values(ServiceFacilityCategoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
