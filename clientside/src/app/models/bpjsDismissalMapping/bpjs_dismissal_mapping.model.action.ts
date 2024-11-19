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
import {BpjsDismissalMappingModel} from './bpjs_dismissal_mapping.model';
import {BpjsDismissalMappingModelAudit} from './bpjs_dismissal_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Dismissal Mapping model actions to be dispatched by NgRx.
 */
export enum BpjsDismissalMappingModelActionTypes {
	CREATE_BPJS_DISMISSAL_MAPPING = '[ENTITY] Create BpjsDismissalMappingModel',
	CREATE_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Create BpjsDismissalMappingModel successfully',
	CREATE_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Create BpjsDismissalMappingModel failed',

	CREATE_ALL_BPJS_DISMISSAL_MAPPING = '[ENTITY] Create All BpjsDismissalMappingModel',
	CREATE_ALL_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Create All BpjsDismissalMappingModel successfully',
	CREATE_ALL_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Create All BpjsDismissalMappingModel failed',

	DELETE_BPJS_DISMISSAL_MAPPING = '[ENTITY] Delete BpjsDismissalMappingModel',
	DELETE_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Delete BpjsDismissalMappingModel successfully',
	DELETE_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Delete BpjsDismissalMappingModel failed',


	DELETE_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete BpjsDismissalMappingModels Excluding Ids',
	DELETE_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDismissalMappingModels Excluding Ids successfully',
	DELETE_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDismissalMappingModels Excluding Ids failed',

	DELETE_ALL_BPJS_DISMISSAL_MAPPING = '[ENTITY] Delete all BpjsDismissalMappingModels',
	DELETE_ALL_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Delete all BpjsDismissalMappingModels successfully',
	DELETE_ALL_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Delete all BpjsDismissalMappingModels failed',

	UPDATE_BPJS_DISMISSAL_MAPPING = '[ENTITY] Update BpjsDismissalMappingModel',
	UPDATE_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Update BpjsDismissalMappingModel successfully',
	UPDATE_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Update BpjsDismissalMappingModel failed',

	UPDATE_ALL_BPJS_DISMISSAL_MAPPING = '[ENTITY] Update all BpjsDismissalMappingModel',
	UPDATE_ALL_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Update all BpjsDismissalMappingModel successfully',
	UPDATE_ALL_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Update all BpjsDismissalMappingModel failed',

	FETCH_BPJS_DISMISSAL_MAPPING= '[ENTITY] Fetch BpjsDismissalMappingModel',
	FETCH_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Fetch BpjsDismissalMappingModel successfully',
	FETCH_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Fetch BpjsDismissalMappingModel failed',

	FETCH_BPJS_DISMISSAL_MAPPING_AUDIT= '[ENTITY] Fetch BpjsDismissalMappingModel audit',
	FETCH_BPJS_DISMISSAL_MAPPING_AUDIT_OK = '[ENTITY] Fetch BpjsDismissalMappingModel audit successfully',
	FETCH_BPJS_DISMISSAL_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch BpjsDismissalMappingModel audit failed',

	FETCH_BPJS_DISMISSAL_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDismissalMappingModel audits by entity id',
	FETCH_BPJS_DISMISSAL_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDismissalMappingModel audits by entity id successfully',
	FETCH_BPJS_DISMISSAL_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDismissalMappingModel audits by entity id failed',

	FETCH_ALL_BPJS_DISMISSAL_MAPPING = '[ENTITY] Fetch all BpjsDismissalMappingModel',
	FETCH_ALL_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Fetch all BpjsDismissalMappingModel successfully',
	FETCH_ALL_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Fetch all BpjsDismissalMappingModel failed',

	FETCH_BPJS_DISMISSAL_MAPPING_WITH_QUERY = '[ENTITY] Fetch BpjsDismissalMappingModel with query',
	FETCH_BPJS_DISMISSAL_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDismissalMappingModel with query successfully',
	FETCH_BPJS_DISMISSAL_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDismissalMappingModel with query failed',

	FETCH_LAST_BPJS_DISMISSAL_MAPPING_WITH_QUERY = '[ENTITY] Fetch last BpjsDismissalMappingModel with query',
	FETCH_LAST_BPJS_DISMISSAL_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDismissalMappingModel with query successfully',
	FETCH_LAST_BPJS_DISMISSAL_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDismissalMappingModel with query failed',

	EXPORT_BPJS_DISMISSAL_MAPPING = '[ENTITY] Export BpjsDismissalMappingModel',
	EXPORT_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Export BpjsDismissalMappingModel successfully',
	EXPORT_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Export BpjsDismissalMappingModel failed',

	EXPORT_ALL_BPJS_DISMISSAL_MAPPING = '[ENTITY] Export All BpjsDismissalMappingModels',
	EXPORT_ALL_BPJS_DISMISSAL_MAPPING_OK = '[ENTITY] Export All BpjsDismissalMappingModels successfully',
	EXPORT_ALL_BPJS_DISMISSAL_MAPPING_FAIL = '[ENTITY] Export All BpjsDismissalMappingModels failed',

	EXPORT_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS = '[ENTITY] Export BpjsDismissalMappingModels excluding Ids',
	EXPORT_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDismissalMappingModel excluding Ids successfully',
	EXPORT_BPJS_DISMISSAL_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDismissalMappingModel excluding Ids failed',

	COUNT_BPJS_DISMISSAL_MAPPINGS = '[ENTITY] Fetch number of BpjsDismissalMappingModel records',
	COUNT_BPJS_DISMISSAL_MAPPINGS_OK = '[ENTITY] Fetch number of BpjsDismissalMappingModel records successfully ',
	COUNT_BPJS_DISMISSAL_MAPPINGS_FAIL = '[ENTITY] Fetch number of BpjsDismissalMappingModel records failed',

	IMPORT_BPJS_DISMISSAL_MAPPINGS = '[ENTITY] Import BpjsDismissalMappingModels',
	IMPORT_BPJS_DISMISSAL_MAPPINGS_OK = '[ENTITY] Import BpjsDismissalMappingModels successfully',
	IMPORT_BPJS_DISMISSAL_MAPPINGS_FAIL = '[ENTITY] Import BpjsDismissalMappingModels fail',


	INITIALISE_BPJS_DISMISSAL_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDismissalMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDismissalMappingAction implements Action {
	readonly className: string = 'BpjsDismissalMappingModel';

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

export class BpjsDismissalMappingAction extends BaseBpjsDismissalMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalMappingAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDismissalMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalMappingAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalMappingAction here] end
}

export class BpjsDismissalMappingActionOK extends BaseBpjsDismissalMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDismissalMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDismissalMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalMappingActionOK here] end
}

export class BpjsDismissalMappingActionFail extends BaseBpjsDismissalMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDismissalMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalMappingActionFail here] end
}

export function isBpjsDismissalMappingModelAction(e: any): e is BaseBpjsDismissalMappingAction {
	return Object.values(BpjsDismissalMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
