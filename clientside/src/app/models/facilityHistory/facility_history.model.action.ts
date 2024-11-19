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
import {FacilityHistoryModel} from './facility_history.model';
import {FacilityHistoryModelAudit} from './facility_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Facility History model actions to be dispatched by NgRx.
 */
export enum FacilityHistoryModelActionTypes {
	CREATE_FACILITY_HISTORY = '[ENTITY] Create FacilityHistoryModel',
	CREATE_FACILITY_HISTORY_OK = '[ENTITY] Create FacilityHistoryModel successfully',
	CREATE_FACILITY_HISTORY_FAIL = '[ENTITY] Create FacilityHistoryModel failed',

	CREATE_ALL_FACILITY_HISTORY = '[ENTITY] Create All FacilityHistoryModel',
	CREATE_ALL_FACILITY_HISTORY_OK = '[ENTITY] Create All FacilityHistoryModel successfully',
	CREATE_ALL_FACILITY_HISTORY_FAIL = '[ENTITY] Create All FacilityHistoryModel failed',

	DELETE_FACILITY_HISTORY = '[ENTITY] Delete FacilityHistoryModel',
	DELETE_FACILITY_HISTORY_OK = '[ENTITY] Delete FacilityHistoryModel successfully',
	DELETE_FACILITY_HISTORY_FAIL = '[ENTITY] Delete FacilityHistoryModel failed',


	DELETE_FACILITY_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete FacilityHistoryModels Excluding Ids',
	DELETE_FACILITY_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete FacilityHistoryModels Excluding Ids successfully',
	DELETE_FACILITY_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete FacilityHistoryModels Excluding Ids failed',

	DELETE_ALL_FACILITY_HISTORY = '[ENTITY] Delete all FacilityHistoryModels',
	DELETE_ALL_FACILITY_HISTORY_OK = '[ENTITY] Delete all FacilityHistoryModels successfully',
	DELETE_ALL_FACILITY_HISTORY_FAIL = '[ENTITY] Delete all FacilityHistoryModels failed',

	UPDATE_FACILITY_HISTORY = '[ENTITY] Update FacilityHistoryModel',
	UPDATE_FACILITY_HISTORY_OK = '[ENTITY] Update FacilityHistoryModel successfully',
	UPDATE_FACILITY_HISTORY_FAIL = '[ENTITY] Update FacilityHistoryModel failed',

	UPDATE_ALL_FACILITY_HISTORY = '[ENTITY] Update all FacilityHistoryModel',
	UPDATE_ALL_FACILITY_HISTORY_OK = '[ENTITY] Update all FacilityHistoryModel successfully',
	UPDATE_ALL_FACILITY_HISTORY_FAIL = '[ENTITY] Update all FacilityHistoryModel failed',

	FETCH_FACILITY_HISTORY= '[ENTITY] Fetch FacilityHistoryModel',
	FETCH_FACILITY_HISTORY_OK = '[ENTITY] Fetch FacilityHistoryModel successfully',
	FETCH_FACILITY_HISTORY_FAIL = '[ENTITY] Fetch FacilityHistoryModel failed',

	FETCH_FACILITY_HISTORY_AUDIT= '[ENTITY] Fetch FacilityHistoryModel audit',
	FETCH_FACILITY_HISTORY_AUDIT_OK = '[ENTITY] Fetch FacilityHistoryModel audit successfully',
	FETCH_FACILITY_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch FacilityHistoryModel audit failed',

	FETCH_FACILITY_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch FacilityHistoryModel audits by entity id',
	FETCH_FACILITY_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch FacilityHistoryModel audits by entity id successfully',
	FETCH_FACILITY_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch FacilityHistoryModel audits by entity id failed',

	FETCH_ALL_FACILITY_HISTORY = '[ENTITY] Fetch all FacilityHistoryModel',
	FETCH_ALL_FACILITY_HISTORY_OK = '[ENTITY] Fetch all FacilityHistoryModel successfully',
	FETCH_ALL_FACILITY_HISTORY_FAIL = '[ENTITY] Fetch all FacilityHistoryModel failed',

	FETCH_FACILITY_HISTORY_WITH_QUERY = '[ENTITY] Fetch FacilityHistoryModel with query',
	FETCH_FACILITY_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch FacilityHistoryModel with query successfully',
	FETCH_FACILITY_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch FacilityHistoryModel with query failed',

	FETCH_LAST_FACILITY_HISTORY_WITH_QUERY = '[ENTITY] Fetch last FacilityHistoryModel with query',
	FETCH_LAST_FACILITY_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last FacilityHistoryModel with query successfully',
	FETCH_LAST_FACILITY_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last FacilityHistoryModel with query failed',

	EXPORT_FACILITY_HISTORY = '[ENTITY] Export FacilityHistoryModel',
	EXPORT_FACILITY_HISTORY_OK = '[ENTITY] Export FacilityHistoryModel successfully',
	EXPORT_FACILITY_HISTORY_FAIL = '[ENTITY] Export FacilityHistoryModel failed',

	EXPORT_ALL_FACILITY_HISTORY = '[ENTITY] Export All FacilityHistoryModels',
	EXPORT_ALL_FACILITY_HISTORY_OK = '[ENTITY] Export All FacilityHistoryModels successfully',
	EXPORT_ALL_FACILITY_HISTORY_FAIL = '[ENTITY] Export All FacilityHistoryModels failed',

	EXPORT_FACILITY_HISTORY_EXCLUDING_IDS = '[ENTITY] Export FacilityHistoryModels excluding Ids',
	EXPORT_FACILITY_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export FacilityHistoryModel excluding Ids successfully',
	EXPORT_FACILITY_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export FacilityHistoryModel excluding Ids failed',

	COUNT_FACILITY_HISTORYS = '[ENTITY] Fetch number of FacilityHistoryModel records',
	COUNT_FACILITY_HISTORYS_OK = '[ENTITY] Fetch number of FacilityHistoryModel records successfully ',
	COUNT_FACILITY_HISTORYS_FAIL = '[ENTITY] Fetch number of FacilityHistoryModel records failed',

	IMPORT_FACILITY_HISTORYS = '[ENTITY] Import FacilityHistoryModels',
	IMPORT_FACILITY_HISTORYS_OK = '[ENTITY] Import FacilityHistoryModels successfully',
	IMPORT_FACILITY_HISTORYS_FAIL = '[ENTITY] Import FacilityHistoryModels fail',


	INITIALISE_FACILITY_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of FacilityHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseFacilityHistoryAction implements Action {
	readonly className: string = 'FacilityHistoryModel';

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

export class FacilityHistoryAction extends BaseFacilityHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityHistoryAction here] off begin
	// % protected region % [Add any additional class fields for FacilityHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FacilityHistoryModel>,
		// % protected region % [Add any additional constructor parameters for FacilityHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for FacilityHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for FacilityHistoryAction here] off begin
	// % protected region % [Add any additional class methods for FacilityHistoryAction here] end
}

export class FacilityHistoryActionOK extends BaseFacilityHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for FacilityHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FacilityHistoryModel>,
		// % protected region % [Add any additional constructor parameters for FacilityHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: FacilityHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for FacilityHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for FacilityHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for FacilityHistoryActionOK here] end
}

export class FacilityHistoryActionFail extends BaseFacilityHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FacilityHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for FacilityHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<FacilityHistoryModel>,
		// % protected region % [Add any additional constructor parameters for FacilityHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for FacilityHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FacilityHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for FacilityHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FacilityHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for FacilityHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for FacilityHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for FacilityHistoryActionFail here] end
}

export function isFacilityHistoryModelAction(e: any): e is BaseFacilityHistoryAction {
	return Object.values(FacilityHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
