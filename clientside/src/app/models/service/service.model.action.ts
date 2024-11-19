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
import {ServiceModel} from './service.model';
import {ServiceModelAudit} from './service.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Service model actions to be dispatched by NgRx.
 */
export enum ServiceModelActionTypes {
	CREATE_SERVICE = '[ENTITY] Create ServiceModel',
	CREATE_SERVICE_OK = '[ENTITY] Create ServiceModel successfully',
	CREATE_SERVICE_FAIL = '[ENTITY] Create ServiceModel failed',

	CREATE_ALL_SERVICE = '[ENTITY] Create All ServiceModel',
	CREATE_ALL_SERVICE_OK = '[ENTITY] Create All ServiceModel successfully',
	CREATE_ALL_SERVICE_FAIL = '[ENTITY] Create All ServiceModel failed',

	DELETE_SERVICE = '[ENTITY] Delete ServiceModel',
	DELETE_SERVICE_OK = '[ENTITY] Delete ServiceModel successfully',
	DELETE_SERVICE_FAIL = '[ENTITY] Delete ServiceModel failed',


	DELETE_SERVICE_EXCLUDING_IDS = '[ENTITY] Delete ServiceModels Excluding Ids',
	DELETE_SERVICE_EXCLUDING_IDS_OK = '[ENTITY] Delete ServiceModels Excluding Ids successfully',
	DELETE_SERVICE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ServiceModels Excluding Ids failed',

	DELETE_ALL_SERVICE = '[ENTITY] Delete all ServiceModels',
	DELETE_ALL_SERVICE_OK = '[ENTITY] Delete all ServiceModels successfully',
	DELETE_ALL_SERVICE_FAIL = '[ENTITY] Delete all ServiceModels failed',

	UPDATE_SERVICE = '[ENTITY] Update ServiceModel',
	UPDATE_SERVICE_OK = '[ENTITY] Update ServiceModel successfully',
	UPDATE_SERVICE_FAIL = '[ENTITY] Update ServiceModel failed',

	UPDATE_ALL_SERVICE = '[ENTITY] Update all ServiceModel',
	UPDATE_ALL_SERVICE_OK = '[ENTITY] Update all ServiceModel successfully',
	UPDATE_ALL_SERVICE_FAIL = '[ENTITY] Update all ServiceModel failed',

	FETCH_SERVICE= '[ENTITY] Fetch ServiceModel',
	FETCH_SERVICE_OK = '[ENTITY] Fetch ServiceModel successfully',
	FETCH_SERVICE_FAIL = '[ENTITY] Fetch ServiceModel failed',

	FETCH_SERVICE_AUDIT= '[ENTITY] Fetch ServiceModel audit',
	FETCH_SERVICE_AUDIT_OK = '[ENTITY] Fetch ServiceModel audit successfully',
	FETCH_SERVICE_AUDIT_FAIL = '[ENTITY] Fetch ServiceModel audit failed',

	FETCH_SERVICE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ServiceModel audits by entity id',
	FETCH_SERVICE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ServiceModel audits by entity id successfully',
	FETCH_SERVICE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ServiceModel audits by entity id failed',

	FETCH_ALL_SERVICE = '[ENTITY] Fetch all ServiceModel',
	FETCH_ALL_SERVICE_OK = '[ENTITY] Fetch all ServiceModel successfully',
	FETCH_ALL_SERVICE_FAIL = '[ENTITY] Fetch all ServiceModel failed',

	FETCH_SERVICE_WITH_QUERY = '[ENTITY] Fetch ServiceModel with query',
	FETCH_SERVICE_WITH_QUERY_OK = '[ENTITY] Fetch ServiceModel with query successfully',
	FETCH_SERVICE_WITH_QUERY_FAIL = '[ENTITY] Fetch ServiceModel with query failed',

	FETCH_LAST_SERVICE_WITH_QUERY = '[ENTITY] Fetch last ServiceModel with query',
	FETCH_LAST_SERVICE_WITH_QUERY_OK = '[ENTITY] Fetch last ServiceModel with query successfully',
	FETCH_LAST_SERVICE_WITH_QUERY_FAIL = '[ENTITY] Fetch last ServiceModel with query failed',

	EXPORT_SERVICE = '[ENTITY] Export ServiceModel',
	EXPORT_SERVICE_OK = '[ENTITY] Export ServiceModel successfully',
	EXPORT_SERVICE_FAIL = '[ENTITY] Export ServiceModel failed',

	EXPORT_ALL_SERVICE = '[ENTITY] Export All ServiceModels',
	EXPORT_ALL_SERVICE_OK = '[ENTITY] Export All ServiceModels successfully',
	EXPORT_ALL_SERVICE_FAIL = '[ENTITY] Export All ServiceModels failed',

	EXPORT_SERVICE_EXCLUDING_IDS = '[ENTITY] Export ServiceModels excluding Ids',
	EXPORT_SERVICE_EXCLUDING_IDS_OK = '[ENTITY] Export ServiceModel excluding Ids successfully',
	EXPORT_SERVICE_EXCLUDING_IDS_FAIL = '[ENTITY] Export ServiceModel excluding Ids failed',

	COUNT_SERVICES = '[ENTITY] Fetch number of ServiceModel records',
	COUNT_SERVICES_OK = '[ENTITY] Fetch number of ServiceModel records successfully ',
	COUNT_SERVICES_FAIL = '[ENTITY] Fetch number of ServiceModel records failed',

	IMPORT_SERVICES = '[ENTITY] Import ServiceModels',
	IMPORT_SERVICES_OK = '[ENTITY] Import ServiceModels successfully',
	IMPORT_SERVICES_FAIL = '[ENTITY] Import ServiceModels fail',


	INITIALISE_SERVICE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ServiceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseServiceAction implements Action {
	readonly className: string = 'ServiceModel';

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

export class ServiceAction extends BaseServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceAction here] off begin
	// % protected region % [Add any additional class fields for ServiceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceModel>,
		// % protected region % [Add any additional constructor parameters for ServiceAction here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceAction here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceAction here] off begin
		// % protected region % [Add any additional constructor logic for ServiceAction here] end
	}

	// % protected region % [Add any additional class methods for ServiceAction here] off begin
	// % protected region % [Add any additional class methods for ServiceAction here] end
}

export class ServiceActionOK extends BaseServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceActionOK here] off begin
	// % protected region % [Add any additional class fields for ServiceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ServiceModel>,
		// % protected region % [Add any additional constructor parameters for ServiceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ServiceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ServiceActionOK here] end
	}

	// % protected region % [Add any additional class methods for ServiceActionOK here] off begin
	// % protected region % [Add any additional class methods for ServiceActionOK here] end
}

export class ServiceActionFail extends BaseServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ServiceActionFail here] off begin
	// % protected region % [Add any additional class fields for ServiceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ServiceModel>,
		// % protected region % [Add any additional constructor parameters for ServiceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ServiceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ServiceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ServiceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ServiceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ServiceActionFail here] end
	}

	// % protected region % [Add any additional class methods for ServiceActionFail here] off begin
	// % protected region % [Add any additional class methods for ServiceActionFail here] end
}

export function isServiceModelAction(e: any): e is BaseServiceAction {
	return Object.values(ServiceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
