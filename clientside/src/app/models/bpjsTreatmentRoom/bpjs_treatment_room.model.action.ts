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
import {BpjsTreatmentRoomModel} from './bpjs_treatment_room.model';
import {BpjsTreatmentRoomModelAudit} from './bpjs_treatment_room.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Treatment Room model actions to be dispatched by NgRx.
 */
export enum BpjsTreatmentRoomModelActionTypes {
	CREATE_BPJS_TREATMENT_ROOM = '[ENTITY] Create BpjsTreatmentRoomModel',
	CREATE_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Create BpjsTreatmentRoomModel successfully',
	CREATE_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Create BpjsTreatmentRoomModel failed',

	CREATE_ALL_BPJS_TREATMENT_ROOM = '[ENTITY] Create All BpjsTreatmentRoomModel',
	CREATE_ALL_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Create All BpjsTreatmentRoomModel successfully',
	CREATE_ALL_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Create All BpjsTreatmentRoomModel failed',

	DELETE_BPJS_TREATMENT_ROOM = '[ENTITY] Delete BpjsTreatmentRoomModel',
	DELETE_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Delete BpjsTreatmentRoomModel successfully',
	DELETE_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Delete BpjsTreatmentRoomModel failed',


	DELETE_BPJS_TREATMENT_ROOM_EXCLUDING_IDS = '[ENTITY] Delete BpjsTreatmentRoomModels Excluding Ids',
	DELETE_BPJS_TREATMENT_ROOM_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsTreatmentRoomModels Excluding Ids successfully',
	DELETE_BPJS_TREATMENT_ROOM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsTreatmentRoomModels Excluding Ids failed',

	DELETE_ALL_BPJS_TREATMENT_ROOM = '[ENTITY] Delete all BpjsTreatmentRoomModels',
	DELETE_ALL_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Delete all BpjsTreatmentRoomModels successfully',
	DELETE_ALL_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Delete all BpjsTreatmentRoomModels failed',

	UPDATE_BPJS_TREATMENT_ROOM = '[ENTITY] Update BpjsTreatmentRoomModel',
	UPDATE_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Update BpjsTreatmentRoomModel successfully',
	UPDATE_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Update BpjsTreatmentRoomModel failed',

	UPDATE_ALL_BPJS_TREATMENT_ROOM = '[ENTITY] Update all BpjsTreatmentRoomModel',
	UPDATE_ALL_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Update all BpjsTreatmentRoomModel successfully',
	UPDATE_ALL_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Update all BpjsTreatmentRoomModel failed',

	FETCH_BPJS_TREATMENT_ROOM= '[ENTITY] Fetch BpjsTreatmentRoomModel',
	FETCH_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Fetch BpjsTreatmentRoomModel successfully',
	FETCH_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Fetch BpjsTreatmentRoomModel failed',

	FETCH_BPJS_TREATMENT_ROOM_AUDIT= '[ENTITY] Fetch BpjsTreatmentRoomModel audit',
	FETCH_BPJS_TREATMENT_ROOM_AUDIT_OK = '[ENTITY] Fetch BpjsTreatmentRoomModel audit successfully',
	FETCH_BPJS_TREATMENT_ROOM_AUDIT_FAIL = '[ENTITY] Fetch BpjsTreatmentRoomModel audit failed',

	FETCH_BPJS_TREATMENT_ROOM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsTreatmentRoomModel audits by entity id',
	FETCH_BPJS_TREATMENT_ROOM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsTreatmentRoomModel audits by entity id successfully',
	FETCH_BPJS_TREATMENT_ROOM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsTreatmentRoomModel audits by entity id failed',

	FETCH_ALL_BPJS_TREATMENT_ROOM = '[ENTITY] Fetch all BpjsTreatmentRoomModel',
	FETCH_ALL_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Fetch all BpjsTreatmentRoomModel successfully',
	FETCH_ALL_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Fetch all BpjsTreatmentRoomModel failed',

	FETCH_BPJS_TREATMENT_ROOM_WITH_QUERY = '[ENTITY] Fetch BpjsTreatmentRoomModel with query',
	FETCH_BPJS_TREATMENT_ROOM_WITH_QUERY_OK = '[ENTITY] Fetch BpjsTreatmentRoomModel with query successfully',
	FETCH_BPJS_TREATMENT_ROOM_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsTreatmentRoomModel with query failed',

	FETCH_LAST_BPJS_TREATMENT_ROOM_WITH_QUERY = '[ENTITY] Fetch last BpjsTreatmentRoomModel with query',
	FETCH_LAST_BPJS_TREATMENT_ROOM_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsTreatmentRoomModel with query successfully',
	FETCH_LAST_BPJS_TREATMENT_ROOM_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsTreatmentRoomModel with query failed',

	EXPORT_BPJS_TREATMENT_ROOM = '[ENTITY] Export BpjsTreatmentRoomModel',
	EXPORT_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Export BpjsTreatmentRoomModel successfully',
	EXPORT_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Export BpjsTreatmentRoomModel failed',

	EXPORT_ALL_BPJS_TREATMENT_ROOM = '[ENTITY] Export All BpjsTreatmentRoomModels',
	EXPORT_ALL_BPJS_TREATMENT_ROOM_OK = '[ENTITY] Export All BpjsTreatmentRoomModels successfully',
	EXPORT_ALL_BPJS_TREATMENT_ROOM_FAIL = '[ENTITY] Export All BpjsTreatmentRoomModels failed',

	EXPORT_BPJS_TREATMENT_ROOM_EXCLUDING_IDS = '[ENTITY] Export BpjsTreatmentRoomModels excluding Ids',
	EXPORT_BPJS_TREATMENT_ROOM_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsTreatmentRoomModel excluding Ids successfully',
	EXPORT_BPJS_TREATMENT_ROOM_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsTreatmentRoomModel excluding Ids failed',

	COUNT_BPJS_TREATMENT_ROOMS = '[ENTITY] Fetch number of BpjsTreatmentRoomModel records',
	COUNT_BPJS_TREATMENT_ROOMS_OK = '[ENTITY] Fetch number of BpjsTreatmentRoomModel records successfully ',
	COUNT_BPJS_TREATMENT_ROOMS_FAIL = '[ENTITY] Fetch number of BpjsTreatmentRoomModel records failed',

	IMPORT_BPJS_TREATMENT_ROOMS = '[ENTITY] Import BpjsTreatmentRoomModels',
	IMPORT_BPJS_TREATMENT_ROOMS_OK = '[ENTITY] Import BpjsTreatmentRoomModels successfully',
	IMPORT_BPJS_TREATMENT_ROOMS_FAIL = '[ENTITY] Import BpjsTreatmentRoomModels fail',


	INITIALISE_BPJS_TREATMENT_ROOM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsTreatmentRoomModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsTreatmentRoomAction implements Action {
	readonly className: string = 'BpjsTreatmentRoomModel';

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

export class BpjsTreatmentRoomAction extends BaseBpjsTreatmentRoomAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentRoomAction here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentRoomAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentRoomModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentRoomAction here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentRoomAction here] end
}

export class BpjsTreatmentRoomActionOK extends BaseBpjsTreatmentRoomAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentRoomActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentRoomActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentRoomModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsTreatmentRoomModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentRoomActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentRoomActionOK here] end
}

export class BpjsTreatmentRoomActionFail extends BaseBpjsTreatmentRoomAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentRoomActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentRoomActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsTreatmentRoomModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentRoomActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentRoomActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentRoomActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentRoomActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentRoomActionFail here] end
}

export function isBpjsTreatmentRoomModelAction(e: any): e is BaseBpjsTreatmentRoomAction {
	return Object.values(BpjsTreatmentRoomModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
