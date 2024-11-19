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
import {BpjsDoctorMappingModel} from './bpjs_doctor_mapping.model';
import {BpjsDoctorMappingModelAudit} from './bpjs_doctor_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Doctor Mapping model actions to be dispatched by NgRx.
 */
export enum BpjsDoctorMappingModelActionTypes {
	CREATE_BPJS_DOCTOR_MAPPING = '[ENTITY] Create BpjsDoctorMappingModel',
	CREATE_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Create BpjsDoctorMappingModel successfully',
	CREATE_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Create BpjsDoctorMappingModel failed',

	CREATE_ALL_BPJS_DOCTOR_MAPPING = '[ENTITY] Create All BpjsDoctorMappingModel',
	CREATE_ALL_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Create All BpjsDoctorMappingModel successfully',
	CREATE_ALL_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Create All BpjsDoctorMappingModel failed',

	DELETE_BPJS_DOCTOR_MAPPING = '[ENTITY] Delete BpjsDoctorMappingModel',
	DELETE_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Delete BpjsDoctorMappingModel successfully',
	DELETE_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Delete BpjsDoctorMappingModel failed',


	DELETE_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete BpjsDoctorMappingModels Excluding Ids',
	DELETE_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDoctorMappingModels Excluding Ids successfully',
	DELETE_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDoctorMappingModels Excluding Ids failed',

	DELETE_ALL_BPJS_DOCTOR_MAPPING = '[ENTITY] Delete all BpjsDoctorMappingModels',
	DELETE_ALL_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Delete all BpjsDoctorMappingModels successfully',
	DELETE_ALL_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Delete all BpjsDoctorMappingModels failed',

	UPDATE_BPJS_DOCTOR_MAPPING = '[ENTITY] Update BpjsDoctorMappingModel',
	UPDATE_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Update BpjsDoctorMappingModel successfully',
	UPDATE_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Update BpjsDoctorMappingModel failed',

	UPDATE_ALL_BPJS_DOCTOR_MAPPING = '[ENTITY] Update all BpjsDoctorMappingModel',
	UPDATE_ALL_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Update all BpjsDoctorMappingModel successfully',
	UPDATE_ALL_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Update all BpjsDoctorMappingModel failed',

	FETCH_BPJS_DOCTOR_MAPPING= '[ENTITY] Fetch BpjsDoctorMappingModel',
	FETCH_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Fetch BpjsDoctorMappingModel successfully',
	FETCH_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Fetch BpjsDoctorMappingModel failed',

	FETCH_BPJS_DOCTOR_MAPPING_AUDIT= '[ENTITY] Fetch BpjsDoctorMappingModel audit',
	FETCH_BPJS_DOCTOR_MAPPING_AUDIT_OK = '[ENTITY] Fetch BpjsDoctorMappingModel audit successfully',
	FETCH_BPJS_DOCTOR_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch BpjsDoctorMappingModel audit failed',

	FETCH_BPJS_DOCTOR_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDoctorMappingModel audits by entity id',
	FETCH_BPJS_DOCTOR_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDoctorMappingModel audits by entity id successfully',
	FETCH_BPJS_DOCTOR_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDoctorMappingModel audits by entity id failed',

	FETCH_ALL_BPJS_DOCTOR_MAPPING = '[ENTITY] Fetch all BpjsDoctorMappingModel',
	FETCH_ALL_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Fetch all BpjsDoctorMappingModel successfully',
	FETCH_ALL_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Fetch all BpjsDoctorMappingModel failed',

	FETCH_BPJS_DOCTOR_MAPPING_WITH_QUERY = '[ENTITY] Fetch BpjsDoctorMappingModel with query',
	FETCH_BPJS_DOCTOR_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDoctorMappingModel with query successfully',
	FETCH_BPJS_DOCTOR_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDoctorMappingModel with query failed',

	FETCH_LAST_BPJS_DOCTOR_MAPPING_WITH_QUERY = '[ENTITY] Fetch last BpjsDoctorMappingModel with query',
	FETCH_LAST_BPJS_DOCTOR_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDoctorMappingModel with query successfully',
	FETCH_LAST_BPJS_DOCTOR_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDoctorMappingModel with query failed',

	EXPORT_BPJS_DOCTOR_MAPPING = '[ENTITY] Export BpjsDoctorMappingModel',
	EXPORT_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Export BpjsDoctorMappingModel successfully',
	EXPORT_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Export BpjsDoctorMappingModel failed',

	EXPORT_ALL_BPJS_DOCTOR_MAPPING = '[ENTITY] Export All BpjsDoctorMappingModels',
	EXPORT_ALL_BPJS_DOCTOR_MAPPING_OK = '[ENTITY] Export All BpjsDoctorMappingModels successfully',
	EXPORT_ALL_BPJS_DOCTOR_MAPPING_FAIL = '[ENTITY] Export All BpjsDoctorMappingModels failed',

	EXPORT_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS = '[ENTITY] Export BpjsDoctorMappingModels excluding Ids',
	EXPORT_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDoctorMappingModel excluding Ids successfully',
	EXPORT_BPJS_DOCTOR_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDoctorMappingModel excluding Ids failed',

	COUNT_BPJS_DOCTOR_MAPPINGS = '[ENTITY] Fetch number of BpjsDoctorMappingModel records',
	COUNT_BPJS_DOCTOR_MAPPINGS_OK = '[ENTITY] Fetch number of BpjsDoctorMappingModel records successfully ',
	COUNT_BPJS_DOCTOR_MAPPINGS_FAIL = '[ENTITY] Fetch number of BpjsDoctorMappingModel records failed',

	IMPORT_BPJS_DOCTOR_MAPPINGS = '[ENTITY] Import BpjsDoctorMappingModels',
	IMPORT_BPJS_DOCTOR_MAPPINGS_OK = '[ENTITY] Import BpjsDoctorMappingModels successfully',
	IMPORT_BPJS_DOCTOR_MAPPINGS_FAIL = '[ENTITY] Import BpjsDoctorMappingModels fail',


	INITIALISE_BPJS_DOCTOR_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDoctorMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDoctorMappingAction implements Action {
	readonly className: string = 'BpjsDoctorMappingModel';

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

export class BpjsDoctorMappingAction extends BaseBpjsDoctorMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorMappingAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDoctorMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorMappingAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorMappingAction here] end
}

export class BpjsDoctorMappingActionOK extends BaseBpjsDoctorMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDoctorMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDoctorMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorMappingActionOK here] end
}

export class BpjsDoctorMappingActionFail extends BaseBpjsDoctorMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDoctorMappingModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorMappingActionFail here] end
}

export function isBpjsDoctorMappingModelAction(e: any): e is BaseBpjsDoctorMappingAction {
	return Object.values(BpjsDoctorMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
