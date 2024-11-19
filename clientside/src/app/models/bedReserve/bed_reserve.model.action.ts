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
import {BedReserveModel} from './bed_reserve.model';
import {BedReserveModelAudit} from './bed_reserve.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Bed Reserve model actions to be dispatched by NgRx.
 */
export enum BedReserveModelActionTypes {
	CREATE_BED_RESERVE = '[ENTITY] Create BedReserveModel',
	CREATE_BED_RESERVE_OK = '[ENTITY] Create BedReserveModel successfully',
	CREATE_BED_RESERVE_FAIL = '[ENTITY] Create BedReserveModel failed',

	CREATE_ALL_BED_RESERVE = '[ENTITY] Create All BedReserveModel',
	CREATE_ALL_BED_RESERVE_OK = '[ENTITY] Create All BedReserveModel successfully',
	CREATE_ALL_BED_RESERVE_FAIL = '[ENTITY] Create All BedReserveModel failed',

	DELETE_BED_RESERVE = '[ENTITY] Delete BedReserveModel',
	DELETE_BED_RESERVE_OK = '[ENTITY] Delete BedReserveModel successfully',
	DELETE_BED_RESERVE_FAIL = '[ENTITY] Delete BedReserveModel failed',


	DELETE_BED_RESERVE_EXCLUDING_IDS = '[ENTITY] Delete BedReserveModels Excluding Ids',
	DELETE_BED_RESERVE_EXCLUDING_IDS_OK = '[ENTITY] Delete BedReserveModels Excluding Ids successfully',
	DELETE_BED_RESERVE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BedReserveModels Excluding Ids failed',

	DELETE_ALL_BED_RESERVE = '[ENTITY] Delete all BedReserveModels',
	DELETE_ALL_BED_RESERVE_OK = '[ENTITY] Delete all BedReserveModels successfully',
	DELETE_ALL_BED_RESERVE_FAIL = '[ENTITY] Delete all BedReserveModels failed',

	UPDATE_BED_RESERVE = '[ENTITY] Update BedReserveModel',
	UPDATE_BED_RESERVE_OK = '[ENTITY] Update BedReserveModel successfully',
	UPDATE_BED_RESERVE_FAIL = '[ENTITY] Update BedReserveModel failed',

	UPDATE_ALL_BED_RESERVE = '[ENTITY] Update all BedReserveModel',
	UPDATE_ALL_BED_RESERVE_OK = '[ENTITY] Update all BedReserveModel successfully',
	UPDATE_ALL_BED_RESERVE_FAIL = '[ENTITY] Update all BedReserveModel failed',

	FETCH_BED_RESERVE= '[ENTITY] Fetch BedReserveModel',
	FETCH_BED_RESERVE_OK = '[ENTITY] Fetch BedReserveModel successfully',
	FETCH_BED_RESERVE_FAIL = '[ENTITY] Fetch BedReserveModel failed',

	FETCH_BED_RESERVE_AUDIT= '[ENTITY] Fetch BedReserveModel audit',
	FETCH_BED_RESERVE_AUDIT_OK = '[ENTITY] Fetch BedReserveModel audit successfully',
	FETCH_BED_RESERVE_AUDIT_FAIL = '[ENTITY] Fetch BedReserveModel audit failed',

	FETCH_BED_RESERVE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BedReserveModel audits by entity id',
	FETCH_BED_RESERVE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BedReserveModel audits by entity id successfully',
	FETCH_BED_RESERVE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BedReserveModel audits by entity id failed',

	FETCH_ALL_BED_RESERVE = '[ENTITY] Fetch all BedReserveModel',
	FETCH_ALL_BED_RESERVE_OK = '[ENTITY] Fetch all BedReserveModel successfully',
	FETCH_ALL_BED_RESERVE_FAIL = '[ENTITY] Fetch all BedReserveModel failed',

	FETCH_BED_RESERVE_WITH_QUERY = '[ENTITY] Fetch BedReserveModel with query',
	FETCH_BED_RESERVE_WITH_QUERY_OK = '[ENTITY] Fetch BedReserveModel with query successfully',
	FETCH_BED_RESERVE_WITH_QUERY_FAIL = '[ENTITY] Fetch BedReserveModel with query failed',

	FETCH_LAST_BED_RESERVE_WITH_QUERY = '[ENTITY] Fetch last BedReserveModel with query',
	FETCH_LAST_BED_RESERVE_WITH_QUERY_OK = '[ENTITY] Fetch last BedReserveModel with query successfully',
	FETCH_LAST_BED_RESERVE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BedReserveModel with query failed',

	EXPORT_BED_RESERVE = '[ENTITY] Export BedReserveModel',
	EXPORT_BED_RESERVE_OK = '[ENTITY] Export BedReserveModel successfully',
	EXPORT_BED_RESERVE_FAIL = '[ENTITY] Export BedReserveModel failed',

	EXPORT_ALL_BED_RESERVE = '[ENTITY] Export All BedReserveModels',
	EXPORT_ALL_BED_RESERVE_OK = '[ENTITY] Export All BedReserveModels successfully',
	EXPORT_ALL_BED_RESERVE_FAIL = '[ENTITY] Export All BedReserveModels failed',

	EXPORT_BED_RESERVE_EXCLUDING_IDS = '[ENTITY] Export BedReserveModels excluding Ids',
	EXPORT_BED_RESERVE_EXCLUDING_IDS_OK = '[ENTITY] Export BedReserveModel excluding Ids successfully',
	EXPORT_BED_RESERVE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BedReserveModel excluding Ids failed',

	COUNT_BED_RESERVES = '[ENTITY] Fetch number of BedReserveModel records',
	COUNT_BED_RESERVES_OK = '[ENTITY] Fetch number of BedReserveModel records successfully ',
	COUNT_BED_RESERVES_FAIL = '[ENTITY] Fetch number of BedReserveModel records failed',

	IMPORT_BED_RESERVES = '[ENTITY] Import BedReserveModels',
	IMPORT_BED_RESERVES_OK = '[ENTITY] Import BedReserveModels successfully',
	IMPORT_BED_RESERVES_FAIL = '[ENTITY] Import BedReserveModels fail',


	INITIALISE_BED_RESERVE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BedReserveModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBedReserveAction implements Action {
	readonly className: string = 'BedReserveModel';

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

export class BedReserveAction extends BaseBedReserveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedReserveAction here] off begin
	// % protected region % [Add any additional class fields for BedReserveAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BedReserveModel>,
		// % protected region % [Add any additional constructor parameters for BedReserveAction here] off begin
		// % protected region % [Add any additional constructor parameters for BedReserveAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedReserveAction here] off begin
			// % protected region % [Add any additional constructor arguments for BedReserveAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedReserveAction here] off begin
		// % protected region % [Add any additional constructor logic for BedReserveAction here] end
	}

	// % protected region % [Add any additional class methods for BedReserveAction here] off begin
	// % protected region % [Add any additional class methods for BedReserveAction here] end
}

export class BedReserveActionOK extends BaseBedReserveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedReserveActionOK here] off begin
	// % protected region % [Add any additional class fields for BedReserveActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BedReserveModel>,
		// % protected region % [Add any additional constructor parameters for BedReserveActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BedReserveActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BedReserveModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedReserveActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BedReserveActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedReserveActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BedReserveActionOK here] end
	}

	// % protected region % [Add any additional class methods for BedReserveActionOK here] off begin
	// % protected region % [Add any additional class methods for BedReserveActionOK here] end
}

export class BedReserveActionFail extends BaseBedReserveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedReserveActionFail here] off begin
	// % protected region % [Add any additional class fields for BedReserveActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BedReserveModel>,
		// % protected region % [Add any additional constructor parameters for BedReserveActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BedReserveActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedReserveActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BedReserveActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedReserveActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BedReserveActionFail here] end
	}

	// % protected region % [Add any additional class methods for BedReserveActionFail here] off begin
	// % protected region % [Add any additional class methods for BedReserveActionFail here] end
}

export function isBedReserveModelAction(e: any): e is BaseBedReserveAction {
	return Object.values(BedReserveModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
