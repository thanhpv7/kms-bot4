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
import {BpjsTreatmentClassMappingModel} from './bpjs_treatment_class_mapping.model';
import {BpjsTreatmentClassMappingModelAudit} from './bpjs_treatment_class_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Treatment Class Mapping model actions to be dispatched by NgRx.
 */
export enum BpjsTreatmentClassMappingModelActionTypes {
	CREATE_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Create BpjsTreatmentClassMappingModel',
	CREATE_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Create BpjsTreatmentClassMappingModel successfully',
	CREATE_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Create BpjsTreatmentClassMappingModel failed',

	CREATE_ALL_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Create All BpjsTreatmentClassMappingModel',
	CREATE_ALL_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Create All BpjsTreatmentClassMappingModel successfully',
	CREATE_ALL_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Create All BpjsTreatmentClassMappingModel failed',

	DELETE_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Delete BpjsTreatmentClassMappingModel',
	DELETE_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Delete BpjsTreatmentClassMappingModel successfully',
	DELETE_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Delete BpjsTreatmentClassMappingModel failed',


	DELETE_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete BpjsTreatmentClassMappingModels Excluding Ids',
	DELETE_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsTreatmentClassMappingModels Excluding Ids successfully',
	DELETE_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsTreatmentClassMappingModels Excluding Ids failed',

	DELETE_ALL_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Delete all BpjsTreatmentClassMappingModels',
	DELETE_ALL_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Delete all BpjsTreatmentClassMappingModels successfully',
	DELETE_ALL_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Delete all BpjsTreatmentClassMappingModels failed',

	UPDATE_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Update BpjsTreatmentClassMappingModel',
	UPDATE_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Update BpjsTreatmentClassMappingModel successfully',
	UPDATE_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Update BpjsTreatmentClassMappingModel failed',

	UPDATE_ALL_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Update all BpjsTreatmentClassMappingModel',
	UPDATE_ALL_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Update all BpjsTreatmentClassMappingModel successfully',
	UPDATE_ALL_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Update all BpjsTreatmentClassMappingModel failed',

	FETCH_BPJS_TREATMENT_CLASS_MAPPING= '[ENTITY] Fetch BpjsTreatmentClassMappingModel',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Fetch BpjsTreatmentClassMappingModel successfully',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Fetch BpjsTreatmentClassMappingModel failed',

	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDIT= '[ENTITY] Fetch BpjsTreatmentClassMappingModel audit',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDIT_OK = '[ENTITY] Fetch BpjsTreatmentClassMappingModel audit successfully',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch BpjsTreatmentClassMappingModel audit failed',

	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsTreatmentClassMappingModel audits by entity id',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsTreatmentClassMappingModel audits by entity id successfully',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsTreatmentClassMappingModel audits by entity id failed',

	FETCH_ALL_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Fetch all BpjsTreatmentClassMappingModel',
	FETCH_ALL_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Fetch all BpjsTreatmentClassMappingModel successfully',
	FETCH_ALL_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Fetch all BpjsTreatmentClassMappingModel failed',

	FETCH_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY = '[ENTITY] Fetch BpjsTreatmentClassMappingModel with query',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch BpjsTreatmentClassMappingModel with query successfully',
	FETCH_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsTreatmentClassMappingModel with query failed',

	FETCH_LAST_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY = '[ENTITY] Fetch last BpjsTreatmentClassMappingModel with query',
	FETCH_LAST_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsTreatmentClassMappingModel with query successfully',
	FETCH_LAST_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsTreatmentClassMappingModel with query failed',

	EXPORT_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Export BpjsTreatmentClassMappingModel',
	EXPORT_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Export BpjsTreatmentClassMappingModel successfully',
	EXPORT_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Export BpjsTreatmentClassMappingModel failed',

	EXPORT_ALL_BPJS_TREATMENT_CLASS_MAPPING = '[ENTITY] Export All BpjsTreatmentClassMappingModels',
	EXPORT_ALL_BPJS_TREATMENT_CLASS_MAPPING_OK = '[ENTITY] Export All BpjsTreatmentClassMappingModels successfully',
	EXPORT_ALL_BPJS_TREATMENT_CLASS_MAPPING_FAIL = '[ENTITY] Export All BpjsTreatmentClassMappingModels failed',

	EXPORT_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS = '[ENTITY] Export BpjsTreatmentClassMappingModels excluding Ids',
	EXPORT_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsTreatmentClassMappingModel excluding Ids successfully',
	EXPORT_BPJS_TREATMENT_CLASS_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsTreatmentClassMappingModel excluding Ids failed',

	COUNT_BPJS_TREATMENT_CLASS_MAPPINGS = '[ENTITY] Fetch number of BpjsTreatmentClassMappingModel records',
	COUNT_BPJS_TREATMENT_CLASS_MAPPINGS_OK = '[ENTITY] Fetch number of BpjsTreatmentClassMappingModel records successfully ',
	COUNT_BPJS_TREATMENT_CLASS_MAPPINGS_FAIL = '[ENTITY] Fetch number of BpjsTreatmentClassMappingModel records failed',

	IMPORT_BPJS_TREATMENT_CLASS_MAPPINGS = '[ENTITY] Import BpjsTreatmentClassMappingModels',
	IMPORT_BPJS_TREATMENT_CLASS_MAPPINGS_OK = '[ENTITY] Import BpjsTreatmentClassMappingModels successfully',
	IMPORT_BPJS_TREATMENT_CLASS_MAPPINGS_FAIL = '[ENTITY] Import BpjsTreatmentClassMappingModels fail',


	INITIALISE_BPJS_TREATMENT_CLASS_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsTreatmentClassMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsTreatmentClassMappingAction implements Action {
	readonly className: string = 'BpjsTreatmentClassMappingModel';

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

export class BpjsTreatmentClassMappingAction extends BaseBpjsTreatmentClassMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingAction here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentClassMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingAction here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingAction here] end
}

export class BpjsTreatmentClassMappingActionOK extends BaseBpjsTreatmentClassMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentClassMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsTreatmentClassMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingActionOK here] end
}

export class BpjsTreatmentClassMappingActionFail extends BaseBpjsTreatmentClassMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentClassMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsTreatmentClassMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentClassMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentClassMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentClassMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentClassMappingActionFail here] end
}

export function isBpjsTreatmentClassMappingModelAction(e: any): e is BaseBpjsTreatmentClassMappingAction {
	return Object.values(BpjsTreatmentClassMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
