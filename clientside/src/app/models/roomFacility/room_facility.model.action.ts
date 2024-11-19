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
import {RoomFacilityModel} from './room_facility.model';
import {RoomFacilityModelAudit} from './room_facility.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Room Facility model actions to be dispatched by NgRx.
 */
export enum RoomFacilityModelActionTypes {
	CREATE_ROOM_FACILITY = '[ENTITY] Create RoomFacilityModel',
	CREATE_ROOM_FACILITY_OK = '[ENTITY] Create RoomFacilityModel successfully',
	CREATE_ROOM_FACILITY_FAIL = '[ENTITY] Create RoomFacilityModel failed',

	CREATE_ALL_ROOM_FACILITY = '[ENTITY] Create All RoomFacilityModel',
	CREATE_ALL_ROOM_FACILITY_OK = '[ENTITY] Create All RoomFacilityModel successfully',
	CREATE_ALL_ROOM_FACILITY_FAIL = '[ENTITY] Create All RoomFacilityModel failed',

	DELETE_ROOM_FACILITY = '[ENTITY] Delete RoomFacilityModel',
	DELETE_ROOM_FACILITY_OK = '[ENTITY] Delete RoomFacilityModel successfully',
	DELETE_ROOM_FACILITY_FAIL = '[ENTITY] Delete RoomFacilityModel failed',


	DELETE_ROOM_FACILITY_EXCLUDING_IDS = '[ENTITY] Delete RoomFacilityModels Excluding Ids',
	DELETE_ROOM_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Delete RoomFacilityModels Excluding Ids successfully',
	DELETE_ROOM_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RoomFacilityModels Excluding Ids failed',

	DELETE_ALL_ROOM_FACILITY = '[ENTITY] Delete all RoomFacilityModels',
	DELETE_ALL_ROOM_FACILITY_OK = '[ENTITY] Delete all RoomFacilityModels successfully',
	DELETE_ALL_ROOM_FACILITY_FAIL = '[ENTITY] Delete all RoomFacilityModels failed',

	UPDATE_ROOM_FACILITY = '[ENTITY] Update RoomFacilityModel',
	UPDATE_ROOM_FACILITY_OK = '[ENTITY] Update RoomFacilityModel successfully',
	UPDATE_ROOM_FACILITY_FAIL = '[ENTITY] Update RoomFacilityModel failed',

	UPDATE_ALL_ROOM_FACILITY = '[ENTITY] Update all RoomFacilityModel',
	UPDATE_ALL_ROOM_FACILITY_OK = '[ENTITY] Update all RoomFacilityModel successfully',
	UPDATE_ALL_ROOM_FACILITY_FAIL = '[ENTITY] Update all RoomFacilityModel failed',

	FETCH_ROOM_FACILITY= '[ENTITY] Fetch RoomFacilityModel',
	FETCH_ROOM_FACILITY_OK = '[ENTITY] Fetch RoomFacilityModel successfully',
	FETCH_ROOM_FACILITY_FAIL = '[ENTITY] Fetch RoomFacilityModel failed',

	FETCH_ROOM_FACILITY_AUDIT= '[ENTITY] Fetch RoomFacilityModel audit',
	FETCH_ROOM_FACILITY_AUDIT_OK = '[ENTITY] Fetch RoomFacilityModel audit successfully',
	FETCH_ROOM_FACILITY_AUDIT_FAIL = '[ENTITY] Fetch RoomFacilityModel audit failed',

	FETCH_ROOM_FACILITY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RoomFacilityModel audits by entity id',
	FETCH_ROOM_FACILITY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RoomFacilityModel audits by entity id successfully',
	FETCH_ROOM_FACILITY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RoomFacilityModel audits by entity id failed',

	FETCH_ALL_ROOM_FACILITY = '[ENTITY] Fetch all RoomFacilityModel',
	FETCH_ALL_ROOM_FACILITY_OK = '[ENTITY] Fetch all RoomFacilityModel successfully',
	FETCH_ALL_ROOM_FACILITY_FAIL = '[ENTITY] Fetch all RoomFacilityModel failed',

	FETCH_ROOM_FACILITY_WITH_QUERY = '[ENTITY] Fetch RoomFacilityModel with query',
	FETCH_ROOM_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch RoomFacilityModel with query successfully',
	FETCH_ROOM_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch RoomFacilityModel with query failed',

	FETCH_LAST_ROOM_FACILITY_WITH_QUERY = '[ENTITY] Fetch last RoomFacilityModel with query',
	FETCH_LAST_ROOM_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch last RoomFacilityModel with query successfully',
	FETCH_LAST_ROOM_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch last RoomFacilityModel with query failed',

	EXPORT_ROOM_FACILITY = '[ENTITY] Export RoomFacilityModel',
	EXPORT_ROOM_FACILITY_OK = '[ENTITY] Export RoomFacilityModel successfully',
	EXPORT_ROOM_FACILITY_FAIL = '[ENTITY] Export RoomFacilityModel failed',

	EXPORT_ALL_ROOM_FACILITY = '[ENTITY] Export All RoomFacilityModels',
	EXPORT_ALL_ROOM_FACILITY_OK = '[ENTITY] Export All RoomFacilityModels successfully',
	EXPORT_ALL_ROOM_FACILITY_FAIL = '[ENTITY] Export All RoomFacilityModels failed',

	EXPORT_ROOM_FACILITY_EXCLUDING_IDS = '[ENTITY] Export RoomFacilityModels excluding Ids',
	EXPORT_ROOM_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Export RoomFacilityModel excluding Ids successfully',
	EXPORT_ROOM_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Export RoomFacilityModel excluding Ids failed',

	COUNT_ROOM_FACILITYS = '[ENTITY] Fetch number of RoomFacilityModel records',
	COUNT_ROOM_FACILITYS_OK = '[ENTITY] Fetch number of RoomFacilityModel records successfully ',
	COUNT_ROOM_FACILITYS_FAIL = '[ENTITY] Fetch number of RoomFacilityModel records failed',

	IMPORT_ROOM_FACILITYS = '[ENTITY] Import RoomFacilityModels',
	IMPORT_ROOM_FACILITYS_OK = '[ENTITY] Import RoomFacilityModels successfully',
	IMPORT_ROOM_FACILITYS_FAIL = '[ENTITY] Import RoomFacilityModels fail',


	INITIALISE_ROOM_FACILITY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RoomFacilityModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRoomFacilityAction implements Action {
	readonly className: string = 'RoomFacilityModel';

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

export class RoomFacilityAction extends BaseRoomFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomFacilityAction here] off begin
	// % protected region % [Add any additional class fields for RoomFacilityAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoomFacilityModel>,
		// % protected region % [Add any additional constructor parameters for RoomFacilityAction here] off begin
		// % protected region % [Add any additional constructor parameters for RoomFacilityAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomFacilityAction here] off begin
			// % protected region % [Add any additional constructor arguments for RoomFacilityAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomFacilityAction here] off begin
		// % protected region % [Add any additional constructor logic for RoomFacilityAction here] end
	}

	// % protected region % [Add any additional class methods for RoomFacilityAction here] off begin
	// % protected region % [Add any additional class methods for RoomFacilityAction here] end
}

export class RoomFacilityActionOK extends BaseRoomFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomFacilityActionOK here] off begin
	// % protected region % [Add any additional class fields for RoomFacilityActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoomFacilityModel>,
		// % protected region % [Add any additional constructor parameters for RoomFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RoomFacilityActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RoomFacilityModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomFacilityActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RoomFacilityActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RoomFacilityActionOK here] end
	}

	// % protected region % [Add any additional class methods for RoomFacilityActionOK here] off begin
	// % protected region % [Add any additional class methods for RoomFacilityActionOK here] end
}

export class RoomFacilityActionFail extends BaseRoomFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomFacilityActionFail here] off begin
	// % protected region % [Add any additional class fields for RoomFacilityActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RoomFacilityModel>,
		// % protected region % [Add any additional constructor parameters for RoomFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RoomFacilityActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomFacilityActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RoomFacilityActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RoomFacilityActionFail here] end
	}

	// % protected region % [Add any additional class methods for RoomFacilityActionFail here] off begin
	// % protected region % [Add any additional class methods for RoomFacilityActionFail here] end
}

export function isRoomFacilityModelAction(e: any): e is BaseRoomFacilityAction {
	return Object.values(RoomFacilityModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
