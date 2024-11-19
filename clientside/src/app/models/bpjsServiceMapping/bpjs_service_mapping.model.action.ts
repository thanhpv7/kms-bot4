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
import {BpjsServiceMappingModel} from './bpjs_service_mapping.model';
import {BpjsServiceMappingModelAudit} from './bpjs_service_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Service Mapping model actions to be dispatched by NgRx.
 */
export enum BpjsServiceMappingModelActionTypes {
	CREATE_BPJS_SERVICE_MAPPING = '[ENTITY] Create BpjsServiceMappingModel',
	CREATE_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Create BpjsServiceMappingModel successfully',
	CREATE_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Create BpjsServiceMappingModel failed',

	CREATE_ALL_BPJS_SERVICE_MAPPING = '[ENTITY] Create All BpjsServiceMappingModel',
	CREATE_ALL_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Create All BpjsServiceMappingModel successfully',
	CREATE_ALL_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Create All BpjsServiceMappingModel failed',

	DELETE_BPJS_SERVICE_MAPPING = '[ENTITY] Delete BpjsServiceMappingModel',
	DELETE_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Delete BpjsServiceMappingModel successfully',
	DELETE_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Delete BpjsServiceMappingModel failed',


	DELETE_BPJS_SERVICE_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete BpjsServiceMappingModels Excluding Ids',
	DELETE_BPJS_SERVICE_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsServiceMappingModels Excluding Ids successfully',
	DELETE_BPJS_SERVICE_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsServiceMappingModels Excluding Ids failed',

	DELETE_ALL_BPJS_SERVICE_MAPPING = '[ENTITY] Delete all BpjsServiceMappingModels',
	DELETE_ALL_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Delete all BpjsServiceMappingModels successfully',
	DELETE_ALL_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Delete all BpjsServiceMappingModels failed',

	UPDATE_BPJS_SERVICE_MAPPING = '[ENTITY] Update BpjsServiceMappingModel',
	UPDATE_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Update BpjsServiceMappingModel successfully',
	UPDATE_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Update BpjsServiceMappingModel failed',

	UPDATE_ALL_BPJS_SERVICE_MAPPING = '[ENTITY] Update all BpjsServiceMappingModel',
	UPDATE_ALL_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Update all BpjsServiceMappingModel successfully',
	UPDATE_ALL_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Update all BpjsServiceMappingModel failed',

	FETCH_BPJS_SERVICE_MAPPING= '[ENTITY] Fetch BpjsServiceMappingModel',
	FETCH_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Fetch BpjsServiceMappingModel successfully',
	FETCH_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Fetch BpjsServiceMappingModel failed',

	FETCH_BPJS_SERVICE_MAPPING_AUDIT= '[ENTITY] Fetch BpjsServiceMappingModel audit',
	FETCH_BPJS_SERVICE_MAPPING_AUDIT_OK = '[ENTITY] Fetch BpjsServiceMappingModel audit successfully',
	FETCH_BPJS_SERVICE_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch BpjsServiceMappingModel audit failed',

	FETCH_BPJS_SERVICE_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsServiceMappingModel audits by entity id',
	FETCH_BPJS_SERVICE_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsServiceMappingModel audits by entity id successfully',
	FETCH_BPJS_SERVICE_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsServiceMappingModel audits by entity id failed',

	FETCH_ALL_BPJS_SERVICE_MAPPING = '[ENTITY] Fetch all BpjsServiceMappingModel',
	FETCH_ALL_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Fetch all BpjsServiceMappingModel successfully',
	FETCH_ALL_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Fetch all BpjsServiceMappingModel failed',

	FETCH_BPJS_SERVICE_MAPPING_WITH_QUERY = '[ENTITY] Fetch BpjsServiceMappingModel with query',
	FETCH_BPJS_SERVICE_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch BpjsServiceMappingModel with query successfully',
	FETCH_BPJS_SERVICE_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsServiceMappingModel with query failed',

	FETCH_LAST_BPJS_SERVICE_MAPPING_WITH_QUERY = '[ENTITY] Fetch last BpjsServiceMappingModel with query',
	FETCH_LAST_BPJS_SERVICE_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsServiceMappingModel with query successfully',
	FETCH_LAST_BPJS_SERVICE_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsServiceMappingModel with query failed',

	EXPORT_BPJS_SERVICE_MAPPING = '[ENTITY] Export BpjsServiceMappingModel',
	EXPORT_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Export BpjsServiceMappingModel successfully',
	EXPORT_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Export BpjsServiceMappingModel failed',

	EXPORT_ALL_BPJS_SERVICE_MAPPING = '[ENTITY] Export All BpjsServiceMappingModels',
	EXPORT_ALL_BPJS_SERVICE_MAPPING_OK = '[ENTITY] Export All BpjsServiceMappingModels successfully',
	EXPORT_ALL_BPJS_SERVICE_MAPPING_FAIL = '[ENTITY] Export All BpjsServiceMappingModels failed',

	EXPORT_BPJS_SERVICE_MAPPING_EXCLUDING_IDS = '[ENTITY] Export BpjsServiceMappingModels excluding Ids',
	EXPORT_BPJS_SERVICE_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsServiceMappingModel excluding Ids successfully',
	EXPORT_BPJS_SERVICE_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsServiceMappingModel excluding Ids failed',

	COUNT_BPJS_SERVICE_MAPPINGS = '[ENTITY] Fetch number of BpjsServiceMappingModel records',
	COUNT_BPJS_SERVICE_MAPPINGS_OK = '[ENTITY] Fetch number of BpjsServiceMappingModel records successfully ',
	COUNT_BPJS_SERVICE_MAPPINGS_FAIL = '[ENTITY] Fetch number of BpjsServiceMappingModel records failed',

	IMPORT_BPJS_SERVICE_MAPPINGS = '[ENTITY] Import BpjsServiceMappingModels',
	IMPORT_BPJS_SERVICE_MAPPINGS_OK = '[ENTITY] Import BpjsServiceMappingModels successfully',
	IMPORT_BPJS_SERVICE_MAPPINGS_FAIL = '[ENTITY] Import BpjsServiceMappingModels fail',


	INITIALISE_BPJS_SERVICE_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsServiceMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsServiceMappingAction implements Action {
	readonly className: string = 'BpjsServiceMappingModel';

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

export class BpjsServiceMappingAction extends BaseBpjsServiceMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsServiceMappingAction here] off begin
	// % protected region % [Add any additional class fields for BpjsServiceMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsServiceMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsServiceMappingAction here] off begin
	// % protected region % [Add any additional class methods for BpjsServiceMappingAction here] end
}

export class BpjsServiceMappingActionOK extends BaseBpjsServiceMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsServiceMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsServiceMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsServiceMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsServiceMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsServiceMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsServiceMappingActionOK here] end
}

export class BpjsServiceMappingActionFail extends BaseBpjsServiceMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsServiceMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsServiceMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsServiceMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsServiceMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsServiceMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsServiceMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsServiceMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsServiceMappingActionFail here] end
}

export function isBpjsServiceMappingModelAction(e: any): e is BaseBpjsServiceMappingAction {
	return Object.values(BpjsServiceMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
