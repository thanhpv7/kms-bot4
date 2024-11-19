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
import {NhisTypeOfServiceModel} from './nhis_type_of_service.model';
import {NhisTypeOfServiceModelAudit} from './nhis_type_of_service.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Type Of Service model actions to be dispatched by NgRx.
 */
export enum NhisTypeOfServiceModelActionTypes {
	CREATE_NHIS_TYPE_OF_SERVICE = '[ENTITY] Create NhisTypeOfServiceModel',
	CREATE_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Create NhisTypeOfServiceModel successfully',
	CREATE_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Create NhisTypeOfServiceModel failed',

	CREATE_ALL_NHIS_TYPE_OF_SERVICE = '[ENTITY] Create All NhisTypeOfServiceModel',
	CREATE_ALL_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Create All NhisTypeOfServiceModel successfully',
	CREATE_ALL_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Create All NhisTypeOfServiceModel failed',

	DELETE_NHIS_TYPE_OF_SERVICE = '[ENTITY] Delete NhisTypeOfServiceModel',
	DELETE_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Delete NhisTypeOfServiceModel successfully',
	DELETE_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Delete NhisTypeOfServiceModel failed',


	DELETE_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS = '[ENTITY] Delete NhisTypeOfServiceModels Excluding Ids',
	DELETE_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisTypeOfServiceModels Excluding Ids successfully',
	DELETE_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisTypeOfServiceModels Excluding Ids failed',

	DELETE_ALL_NHIS_TYPE_OF_SERVICE = '[ENTITY] Delete all NhisTypeOfServiceModels',
	DELETE_ALL_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Delete all NhisTypeOfServiceModels successfully',
	DELETE_ALL_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Delete all NhisTypeOfServiceModels failed',

	UPDATE_NHIS_TYPE_OF_SERVICE = '[ENTITY] Update NhisTypeOfServiceModel',
	UPDATE_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Update NhisTypeOfServiceModel successfully',
	UPDATE_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Update NhisTypeOfServiceModel failed',

	UPDATE_ALL_NHIS_TYPE_OF_SERVICE = '[ENTITY] Update all NhisTypeOfServiceModel',
	UPDATE_ALL_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Update all NhisTypeOfServiceModel successfully',
	UPDATE_ALL_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Update all NhisTypeOfServiceModel failed',

	FETCH_NHIS_TYPE_OF_SERVICE= '[ENTITY] Fetch NhisTypeOfServiceModel',
	FETCH_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Fetch NhisTypeOfServiceModel successfully',
	FETCH_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Fetch NhisTypeOfServiceModel failed',

	FETCH_NHIS_TYPE_OF_SERVICE_AUDIT= '[ENTITY] Fetch NhisTypeOfServiceModel audit',
	FETCH_NHIS_TYPE_OF_SERVICE_AUDIT_OK = '[ENTITY] Fetch NhisTypeOfServiceModel audit successfully',
	FETCH_NHIS_TYPE_OF_SERVICE_AUDIT_FAIL = '[ENTITY] Fetch NhisTypeOfServiceModel audit failed',

	FETCH_NHIS_TYPE_OF_SERVICE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisTypeOfServiceModel audits by entity id',
	FETCH_NHIS_TYPE_OF_SERVICE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisTypeOfServiceModel audits by entity id successfully',
	FETCH_NHIS_TYPE_OF_SERVICE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisTypeOfServiceModel audits by entity id failed',

	FETCH_ALL_NHIS_TYPE_OF_SERVICE = '[ENTITY] Fetch all NhisTypeOfServiceModel',
	FETCH_ALL_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Fetch all NhisTypeOfServiceModel successfully',
	FETCH_ALL_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Fetch all NhisTypeOfServiceModel failed',

	FETCH_NHIS_TYPE_OF_SERVICE_WITH_QUERY = '[ENTITY] Fetch NhisTypeOfServiceModel with query',
	FETCH_NHIS_TYPE_OF_SERVICE_WITH_QUERY_OK = '[ENTITY] Fetch NhisTypeOfServiceModel with query successfully',
	FETCH_NHIS_TYPE_OF_SERVICE_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisTypeOfServiceModel with query failed',

	FETCH_LAST_NHIS_TYPE_OF_SERVICE_WITH_QUERY = '[ENTITY] Fetch last NhisTypeOfServiceModel with query',
	FETCH_LAST_NHIS_TYPE_OF_SERVICE_WITH_QUERY_OK = '[ENTITY] Fetch last NhisTypeOfServiceModel with query successfully',
	FETCH_LAST_NHIS_TYPE_OF_SERVICE_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisTypeOfServiceModel with query failed',

	EXPORT_NHIS_TYPE_OF_SERVICE = '[ENTITY] Export NhisTypeOfServiceModel',
	EXPORT_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Export NhisTypeOfServiceModel successfully',
	EXPORT_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Export NhisTypeOfServiceModel failed',

	EXPORT_ALL_NHIS_TYPE_OF_SERVICE = '[ENTITY] Export All NhisTypeOfServiceModels',
	EXPORT_ALL_NHIS_TYPE_OF_SERVICE_OK = '[ENTITY] Export All NhisTypeOfServiceModels successfully',
	EXPORT_ALL_NHIS_TYPE_OF_SERVICE_FAIL = '[ENTITY] Export All NhisTypeOfServiceModels failed',

	EXPORT_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS = '[ENTITY] Export NhisTypeOfServiceModels excluding Ids',
	EXPORT_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS_OK = '[ENTITY] Export NhisTypeOfServiceModel excluding Ids successfully',
	EXPORT_NHIS_TYPE_OF_SERVICE_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisTypeOfServiceModel excluding Ids failed',

	COUNT_NHIS_TYPE_OF_SERVICES = '[ENTITY] Fetch number of NhisTypeOfServiceModel records',
	COUNT_NHIS_TYPE_OF_SERVICES_OK = '[ENTITY] Fetch number of NhisTypeOfServiceModel records successfully ',
	COUNT_NHIS_TYPE_OF_SERVICES_FAIL = '[ENTITY] Fetch number of NhisTypeOfServiceModel records failed',

	IMPORT_NHIS_TYPE_OF_SERVICES = '[ENTITY] Import NhisTypeOfServiceModels',
	IMPORT_NHIS_TYPE_OF_SERVICES_OK = '[ENTITY] Import NhisTypeOfServiceModels successfully',
	IMPORT_NHIS_TYPE_OF_SERVICES_FAIL = '[ENTITY] Import NhisTypeOfServiceModels fail',


	INITIALISE_NHIS_TYPE_OF_SERVICE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisTypeOfServiceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisTypeOfServiceAction implements Action {
	readonly className: string = 'NhisTypeOfServiceModel';

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

export class NhisTypeOfServiceAction extends BaseNhisTypeOfServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisTypeOfServiceAction here] off begin
	// % protected region % [Add any additional class fields for NhisTypeOfServiceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisTypeOfServiceModel>,
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceAction here] end
	}

	// % protected region % [Add any additional class methods for NhisTypeOfServiceAction here] off begin
	// % protected region % [Add any additional class methods for NhisTypeOfServiceAction here] end
}

export class NhisTypeOfServiceActionOK extends BaseNhisTypeOfServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisTypeOfServiceActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisTypeOfServiceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisTypeOfServiceModel>,
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisTypeOfServiceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisTypeOfServiceActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisTypeOfServiceActionOK here] end
}

export class NhisTypeOfServiceActionFail extends BaseNhisTypeOfServiceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisTypeOfServiceActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisTypeOfServiceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisTypeOfServiceModel>,
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisTypeOfServiceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisTypeOfServiceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisTypeOfServiceActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisTypeOfServiceActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisTypeOfServiceActionFail here] end
}

export function isNhisTypeOfServiceModelAction(e: any): e is BaseNhisTypeOfServiceAction {
	return Object.values(NhisTypeOfServiceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
