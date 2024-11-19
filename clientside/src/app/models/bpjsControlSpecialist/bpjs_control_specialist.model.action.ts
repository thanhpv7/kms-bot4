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
import {BpjsControlSpecialistModel} from './bpjs_control_specialist.model';
import {BpjsControlSpecialistModelAudit} from './bpjs_control_specialist.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Control Specialist model actions to be dispatched by NgRx.
 */
export enum BpjsControlSpecialistModelActionTypes {
	CREATE_BPJS_CONTROL_SPECIALIST = '[ENTITY] Create BpjsControlSpecialistModel',
	CREATE_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Create BpjsControlSpecialistModel successfully',
	CREATE_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Create BpjsControlSpecialistModel failed',

	CREATE_ALL_BPJS_CONTROL_SPECIALIST = '[ENTITY] Create All BpjsControlSpecialistModel',
	CREATE_ALL_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Create All BpjsControlSpecialistModel successfully',
	CREATE_ALL_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Create All BpjsControlSpecialistModel failed',

	DELETE_BPJS_CONTROL_SPECIALIST = '[ENTITY] Delete BpjsControlSpecialistModel',
	DELETE_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Delete BpjsControlSpecialistModel successfully',
	DELETE_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Delete BpjsControlSpecialistModel failed',


	DELETE_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS = '[ENTITY] Delete BpjsControlSpecialistModels Excluding Ids',
	DELETE_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsControlSpecialistModels Excluding Ids successfully',
	DELETE_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsControlSpecialistModels Excluding Ids failed',

	DELETE_ALL_BPJS_CONTROL_SPECIALIST = '[ENTITY] Delete all BpjsControlSpecialistModels',
	DELETE_ALL_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Delete all BpjsControlSpecialistModels successfully',
	DELETE_ALL_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Delete all BpjsControlSpecialistModels failed',

	UPDATE_BPJS_CONTROL_SPECIALIST = '[ENTITY] Update BpjsControlSpecialistModel',
	UPDATE_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Update BpjsControlSpecialistModel successfully',
	UPDATE_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Update BpjsControlSpecialistModel failed',

	UPDATE_ALL_BPJS_CONTROL_SPECIALIST = '[ENTITY] Update all BpjsControlSpecialistModel',
	UPDATE_ALL_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Update all BpjsControlSpecialistModel successfully',
	UPDATE_ALL_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Update all BpjsControlSpecialistModel failed',

	FETCH_BPJS_CONTROL_SPECIALIST= '[ENTITY] Fetch BpjsControlSpecialistModel',
	FETCH_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Fetch BpjsControlSpecialistModel successfully',
	FETCH_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Fetch BpjsControlSpecialistModel failed',

	FETCH_BPJS_CONTROL_SPECIALIST_AUDIT= '[ENTITY] Fetch BpjsControlSpecialistModel audit',
	FETCH_BPJS_CONTROL_SPECIALIST_AUDIT_OK = '[ENTITY] Fetch BpjsControlSpecialistModel audit successfully',
	FETCH_BPJS_CONTROL_SPECIALIST_AUDIT_FAIL = '[ENTITY] Fetch BpjsControlSpecialistModel audit failed',

	FETCH_BPJS_CONTROL_SPECIALIST_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsControlSpecialistModel audits by entity id',
	FETCH_BPJS_CONTROL_SPECIALIST_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsControlSpecialistModel audits by entity id successfully',
	FETCH_BPJS_CONTROL_SPECIALIST_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsControlSpecialistModel audits by entity id failed',

	FETCH_ALL_BPJS_CONTROL_SPECIALIST = '[ENTITY] Fetch all BpjsControlSpecialistModel',
	FETCH_ALL_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Fetch all BpjsControlSpecialistModel successfully',
	FETCH_ALL_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Fetch all BpjsControlSpecialistModel failed',

	FETCH_BPJS_CONTROL_SPECIALIST_WITH_QUERY = '[ENTITY] Fetch BpjsControlSpecialistModel with query',
	FETCH_BPJS_CONTROL_SPECIALIST_WITH_QUERY_OK = '[ENTITY] Fetch BpjsControlSpecialistModel with query successfully',
	FETCH_BPJS_CONTROL_SPECIALIST_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsControlSpecialistModel with query failed',

	FETCH_LAST_BPJS_CONTROL_SPECIALIST_WITH_QUERY = '[ENTITY] Fetch last BpjsControlSpecialistModel with query',
	FETCH_LAST_BPJS_CONTROL_SPECIALIST_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsControlSpecialistModel with query successfully',
	FETCH_LAST_BPJS_CONTROL_SPECIALIST_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsControlSpecialistModel with query failed',

	EXPORT_BPJS_CONTROL_SPECIALIST = '[ENTITY] Export BpjsControlSpecialistModel',
	EXPORT_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Export BpjsControlSpecialistModel successfully',
	EXPORT_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Export BpjsControlSpecialistModel failed',

	EXPORT_ALL_BPJS_CONTROL_SPECIALIST = '[ENTITY] Export All BpjsControlSpecialistModels',
	EXPORT_ALL_BPJS_CONTROL_SPECIALIST_OK = '[ENTITY] Export All BpjsControlSpecialistModels successfully',
	EXPORT_ALL_BPJS_CONTROL_SPECIALIST_FAIL = '[ENTITY] Export All BpjsControlSpecialistModels failed',

	EXPORT_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS = '[ENTITY] Export BpjsControlSpecialistModels excluding Ids',
	EXPORT_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsControlSpecialistModel excluding Ids successfully',
	EXPORT_BPJS_CONTROL_SPECIALIST_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsControlSpecialistModel excluding Ids failed',

	COUNT_BPJS_CONTROL_SPECIALISTS = '[ENTITY] Fetch number of BpjsControlSpecialistModel records',
	COUNT_BPJS_CONTROL_SPECIALISTS_OK = '[ENTITY] Fetch number of BpjsControlSpecialistModel records successfully ',
	COUNT_BPJS_CONTROL_SPECIALISTS_FAIL = '[ENTITY] Fetch number of BpjsControlSpecialistModel records failed',

	IMPORT_BPJS_CONTROL_SPECIALISTS = '[ENTITY] Import BpjsControlSpecialistModels',
	IMPORT_BPJS_CONTROL_SPECIALISTS_OK = '[ENTITY] Import BpjsControlSpecialistModels successfully',
	IMPORT_BPJS_CONTROL_SPECIALISTS_FAIL = '[ENTITY] Import BpjsControlSpecialistModels fail',


	INITIALISE_BPJS_CONTROL_SPECIALIST_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsControlSpecialistModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsControlSpecialistAction implements Action {
	readonly className: string = 'BpjsControlSpecialistModel';

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

export class BpjsControlSpecialistAction extends BaseBpjsControlSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlSpecialistAction here] off begin
	// % protected region % [Add any additional class fields for BpjsControlSpecialistAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsControlSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlSpecialistAction here] off begin
	// % protected region % [Add any additional class methods for BpjsControlSpecialistAction here] end
}

export class BpjsControlSpecialistActionOK extends BaseBpjsControlSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlSpecialistActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsControlSpecialistActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsControlSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsControlSpecialistModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlSpecialistActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsControlSpecialistActionOK here] end
}

export class BpjsControlSpecialistActionFail extends BaseBpjsControlSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsControlSpecialistActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsControlSpecialistActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsControlSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsControlSpecialistActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsControlSpecialistActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsControlSpecialistActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsControlSpecialistActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsControlSpecialistActionFail here] end
}

export function isBpjsControlSpecialistModelAction(e: any): e is BaseBpjsControlSpecialistAction {
	return Object.values(BpjsControlSpecialistModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
