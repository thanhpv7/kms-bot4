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
import {RoomTransferModel} from './room_transfer.model';
import {RoomTransferModelAudit} from './room_transfer.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Room Transfer model actions to be dispatched by NgRx.
 */
export enum RoomTransferModelActionTypes {
	CREATE_ROOM_TRANSFER = '[ENTITY] Create RoomTransferModel',
	CREATE_ROOM_TRANSFER_OK = '[ENTITY] Create RoomTransferModel successfully',
	CREATE_ROOM_TRANSFER_FAIL = '[ENTITY] Create RoomTransferModel failed',

	CREATE_ALL_ROOM_TRANSFER = '[ENTITY] Create All RoomTransferModel',
	CREATE_ALL_ROOM_TRANSFER_OK = '[ENTITY] Create All RoomTransferModel successfully',
	CREATE_ALL_ROOM_TRANSFER_FAIL = '[ENTITY] Create All RoomTransferModel failed',

	DELETE_ROOM_TRANSFER = '[ENTITY] Delete RoomTransferModel',
	DELETE_ROOM_TRANSFER_OK = '[ENTITY] Delete RoomTransferModel successfully',
	DELETE_ROOM_TRANSFER_FAIL = '[ENTITY] Delete RoomTransferModel failed',


	DELETE_ROOM_TRANSFER_EXCLUDING_IDS = '[ENTITY] Delete RoomTransferModels Excluding Ids',
	DELETE_ROOM_TRANSFER_EXCLUDING_IDS_OK = '[ENTITY] Delete RoomTransferModels Excluding Ids successfully',
	DELETE_ROOM_TRANSFER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RoomTransferModels Excluding Ids failed',

	DELETE_ALL_ROOM_TRANSFER = '[ENTITY] Delete all RoomTransferModels',
	DELETE_ALL_ROOM_TRANSFER_OK = '[ENTITY] Delete all RoomTransferModels successfully',
	DELETE_ALL_ROOM_TRANSFER_FAIL = '[ENTITY] Delete all RoomTransferModels failed',

	UPDATE_ROOM_TRANSFER = '[ENTITY] Update RoomTransferModel',
	UPDATE_ROOM_TRANSFER_OK = '[ENTITY] Update RoomTransferModel successfully',
	UPDATE_ROOM_TRANSFER_FAIL = '[ENTITY] Update RoomTransferModel failed',

	UPDATE_ALL_ROOM_TRANSFER = '[ENTITY] Update all RoomTransferModel',
	UPDATE_ALL_ROOM_TRANSFER_OK = '[ENTITY] Update all RoomTransferModel successfully',
	UPDATE_ALL_ROOM_TRANSFER_FAIL = '[ENTITY] Update all RoomTransferModel failed',

	FETCH_ROOM_TRANSFER= '[ENTITY] Fetch RoomTransferModel',
	FETCH_ROOM_TRANSFER_OK = '[ENTITY] Fetch RoomTransferModel successfully',
	FETCH_ROOM_TRANSFER_FAIL = '[ENTITY] Fetch RoomTransferModel failed',

	FETCH_ROOM_TRANSFER_AUDIT= '[ENTITY] Fetch RoomTransferModel audit',
	FETCH_ROOM_TRANSFER_AUDIT_OK = '[ENTITY] Fetch RoomTransferModel audit successfully',
	FETCH_ROOM_TRANSFER_AUDIT_FAIL = '[ENTITY] Fetch RoomTransferModel audit failed',

	FETCH_ROOM_TRANSFER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RoomTransferModel audits by entity id',
	FETCH_ROOM_TRANSFER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RoomTransferModel audits by entity id successfully',
	FETCH_ROOM_TRANSFER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RoomTransferModel audits by entity id failed',

	FETCH_ALL_ROOM_TRANSFER = '[ENTITY] Fetch all RoomTransferModel',
	FETCH_ALL_ROOM_TRANSFER_OK = '[ENTITY] Fetch all RoomTransferModel successfully',
	FETCH_ALL_ROOM_TRANSFER_FAIL = '[ENTITY] Fetch all RoomTransferModel failed',

	FETCH_ROOM_TRANSFER_WITH_QUERY = '[ENTITY] Fetch RoomTransferModel with query',
	FETCH_ROOM_TRANSFER_WITH_QUERY_OK = '[ENTITY] Fetch RoomTransferModel with query successfully',
	FETCH_ROOM_TRANSFER_WITH_QUERY_FAIL = '[ENTITY] Fetch RoomTransferModel with query failed',

	FETCH_LAST_ROOM_TRANSFER_WITH_QUERY = '[ENTITY] Fetch last RoomTransferModel with query',
	FETCH_LAST_ROOM_TRANSFER_WITH_QUERY_OK = '[ENTITY] Fetch last RoomTransferModel with query successfully',
	FETCH_LAST_ROOM_TRANSFER_WITH_QUERY_FAIL = '[ENTITY] Fetch last RoomTransferModel with query failed',

	EXPORT_ROOM_TRANSFER = '[ENTITY] Export RoomTransferModel',
	EXPORT_ROOM_TRANSFER_OK = '[ENTITY] Export RoomTransferModel successfully',
	EXPORT_ROOM_TRANSFER_FAIL = '[ENTITY] Export RoomTransferModel failed',

	EXPORT_ALL_ROOM_TRANSFER = '[ENTITY] Export All RoomTransferModels',
	EXPORT_ALL_ROOM_TRANSFER_OK = '[ENTITY] Export All RoomTransferModels successfully',
	EXPORT_ALL_ROOM_TRANSFER_FAIL = '[ENTITY] Export All RoomTransferModels failed',

	EXPORT_ROOM_TRANSFER_EXCLUDING_IDS = '[ENTITY] Export RoomTransferModels excluding Ids',
	EXPORT_ROOM_TRANSFER_EXCLUDING_IDS_OK = '[ENTITY] Export RoomTransferModel excluding Ids successfully',
	EXPORT_ROOM_TRANSFER_EXCLUDING_IDS_FAIL = '[ENTITY] Export RoomTransferModel excluding Ids failed',

	COUNT_ROOM_TRANSFERS = '[ENTITY] Fetch number of RoomTransferModel records',
	COUNT_ROOM_TRANSFERS_OK = '[ENTITY] Fetch number of RoomTransferModel records successfully ',
	COUNT_ROOM_TRANSFERS_FAIL = '[ENTITY] Fetch number of RoomTransferModel records failed',

	IMPORT_ROOM_TRANSFERS = '[ENTITY] Import RoomTransferModels',
	IMPORT_ROOM_TRANSFERS_OK = '[ENTITY] Import RoomTransferModels successfully',
	IMPORT_ROOM_TRANSFERS_FAIL = '[ENTITY] Import RoomTransferModels fail',


	INITIALISE_ROOM_TRANSFER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RoomTransferModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRoomTransferAction implements Action {
	readonly className: string = 'RoomTransferModel';

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

export class RoomTransferAction extends BaseRoomTransferAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomTransferAction here] off begin
	// % protected region % [Add any additional class fields for RoomTransferAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoomTransferModel>,
		// % protected region % [Add any additional constructor parameters for RoomTransferAction here] off begin
		// % protected region % [Add any additional constructor parameters for RoomTransferAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomTransferAction here] off begin
			// % protected region % [Add any additional constructor arguments for RoomTransferAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomTransferAction here] off begin
		// % protected region % [Add any additional constructor logic for RoomTransferAction here] end
	}

	// % protected region % [Add any additional class methods for RoomTransferAction here] off begin
	// % protected region % [Add any additional class methods for RoomTransferAction here] end
}

export class RoomTransferActionOK extends BaseRoomTransferAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomTransferActionOK here] off begin
	// % protected region % [Add any additional class fields for RoomTransferActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RoomTransferModel>,
		// % protected region % [Add any additional constructor parameters for RoomTransferActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RoomTransferActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RoomTransferModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomTransferActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RoomTransferActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomTransferActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RoomTransferActionOK here] end
	}

	// % protected region % [Add any additional class methods for RoomTransferActionOK here] off begin
	// % protected region % [Add any additional class methods for RoomTransferActionOK here] end
}

export class RoomTransferActionFail extends BaseRoomTransferAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RoomTransferActionFail here] off begin
	// % protected region % [Add any additional class fields for RoomTransferActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RoomTransferModel>,
		// % protected region % [Add any additional constructor parameters for RoomTransferActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RoomTransferActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RoomTransferActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RoomTransferActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RoomTransferActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RoomTransferActionFail here] end
	}

	// % protected region % [Add any additional class methods for RoomTransferActionFail here] off begin
	// % protected region % [Add any additional class methods for RoomTransferActionFail here] end
}

export function isRoomTransferModelAction(e: any): e is BaseRoomTransferAction {
	return Object.values(RoomTransferModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
