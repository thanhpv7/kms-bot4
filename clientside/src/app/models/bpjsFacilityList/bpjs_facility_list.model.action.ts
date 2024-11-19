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
import {BpjsFacilityListModel} from './bpjs_facility_list.model';
import {BpjsFacilityListModelAudit} from './bpjs_facility_list.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Facility List model actions to be dispatched by NgRx.
 */
export enum BpjsFacilityListModelActionTypes {
	CREATE_BPJS_FACILITY_LIST = '[ENTITY] Create BpjsFacilityListModel',
	CREATE_BPJS_FACILITY_LIST_OK = '[ENTITY] Create BpjsFacilityListModel successfully',
	CREATE_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Create BpjsFacilityListModel failed',

	CREATE_ALL_BPJS_FACILITY_LIST = '[ENTITY] Create All BpjsFacilityListModel',
	CREATE_ALL_BPJS_FACILITY_LIST_OK = '[ENTITY] Create All BpjsFacilityListModel successfully',
	CREATE_ALL_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Create All BpjsFacilityListModel failed',

	DELETE_BPJS_FACILITY_LIST = '[ENTITY] Delete BpjsFacilityListModel',
	DELETE_BPJS_FACILITY_LIST_OK = '[ENTITY] Delete BpjsFacilityListModel successfully',
	DELETE_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Delete BpjsFacilityListModel failed',


	DELETE_BPJS_FACILITY_LIST_EXCLUDING_IDS = '[ENTITY] Delete BpjsFacilityListModels Excluding Ids',
	DELETE_BPJS_FACILITY_LIST_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsFacilityListModels Excluding Ids successfully',
	DELETE_BPJS_FACILITY_LIST_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsFacilityListModels Excluding Ids failed',

	DELETE_ALL_BPJS_FACILITY_LIST = '[ENTITY] Delete all BpjsFacilityListModels',
	DELETE_ALL_BPJS_FACILITY_LIST_OK = '[ENTITY] Delete all BpjsFacilityListModels successfully',
	DELETE_ALL_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Delete all BpjsFacilityListModels failed',

	UPDATE_BPJS_FACILITY_LIST = '[ENTITY] Update BpjsFacilityListModel',
	UPDATE_BPJS_FACILITY_LIST_OK = '[ENTITY] Update BpjsFacilityListModel successfully',
	UPDATE_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Update BpjsFacilityListModel failed',

	UPDATE_ALL_BPJS_FACILITY_LIST = '[ENTITY] Update all BpjsFacilityListModel',
	UPDATE_ALL_BPJS_FACILITY_LIST_OK = '[ENTITY] Update all BpjsFacilityListModel successfully',
	UPDATE_ALL_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Update all BpjsFacilityListModel failed',

	FETCH_BPJS_FACILITY_LIST= '[ENTITY] Fetch BpjsFacilityListModel',
	FETCH_BPJS_FACILITY_LIST_OK = '[ENTITY] Fetch BpjsFacilityListModel successfully',
	FETCH_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Fetch BpjsFacilityListModel failed',

	FETCH_BPJS_FACILITY_LIST_AUDIT= '[ENTITY] Fetch BpjsFacilityListModel audit',
	FETCH_BPJS_FACILITY_LIST_AUDIT_OK = '[ENTITY] Fetch BpjsFacilityListModel audit successfully',
	FETCH_BPJS_FACILITY_LIST_AUDIT_FAIL = '[ENTITY] Fetch BpjsFacilityListModel audit failed',

	FETCH_BPJS_FACILITY_LIST_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsFacilityListModel audits by entity id',
	FETCH_BPJS_FACILITY_LIST_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsFacilityListModel audits by entity id successfully',
	FETCH_BPJS_FACILITY_LIST_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsFacilityListModel audits by entity id failed',

	FETCH_ALL_BPJS_FACILITY_LIST = '[ENTITY] Fetch all BpjsFacilityListModel',
	FETCH_ALL_BPJS_FACILITY_LIST_OK = '[ENTITY] Fetch all BpjsFacilityListModel successfully',
	FETCH_ALL_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Fetch all BpjsFacilityListModel failed',

	FETCH_BPJS_FACILITY_LIST_WITH_QUERY = '[ENTITY] Fetch BpjsFacilityListModel with query',
	FETCH_BPJS_FACILITY_LIST_WITH_QUERY_OK = '[ENTITY] Fetch BpjsFacilityListModel with query successfully',
	FETCH_BPJS_FACILITY_LIST_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsFacilityListModel with query failed',

	FETCH_LAST_BPJS_FACILITY_LIST_WITH_QUERY = '[ENTITY] Fetch last BpjsFacilityListModel with query',
	FETCH_LAST_BPJS_FACILITY_LIST_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsFacilityListModel with query successfully',
	FETCH_LAST_BPJS_FACILITY_LIST_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsFacilityListModel with query failed',

	EXPORT_BPJS_FACILITY_LIST = '[ENTITY] Export BpjsFacilityListModel',
	EXPORT_BPJS_FACILITY_LIST_OK = '[ENTITY] Export BpjsFacilityListModel successfully',
	EXPORT_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Export BpjsFacilityListModel failed',

	EXPORT_ALL_BPJS_FACILITY_LIST = '[ENTITY] Export All BpjsFacilityListModels',
	EXPORT_ALL_BPJS_FACILITY_LIST_OK = '[ENTITY] Export All BpjsFacilityListModels successfully',
	EXPORT_ALL_BPJS_FACILITY_LIST_FAIL = '[ENTITY] Export All BpjsFacilityListModels failed',

	EXPORT_BPJS_FACILITY_LIST_EXCLUDING_IDS = '[ENTITY] Export BpjsFacilityListModels excluding Ids',
	EXPORT_BPJS_FACILITY_LIST_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsFacilityListModel excluding Ids successfully',
	EXPORT_BPJS_FACILITY_LIST_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsFacilityListModel excluding Ids failed',

	COUNT_BPJS_FACILITY_LISTS = '[ENTITY] Fetch number of BpjsFacilityListModel records',
	COUNT_BPJS_FACILITY_LISTS_OK = '[ENTITY] Fetch number of BpjsFacilityListModel records successfully ',
	COUNT_BPJS_FACILITY_LISTS_FAIL = '[ENTITY] Fetch number of BpjsFacilityListModel records failed',

	IMPORT_BPJS_FACILITY_LISTS = '[ENTITY] Import BpjsFacilityListModels',
	IMPORT_BPJS_FACILITY_LISTS_OK = '[ENTITY] Import BpjsFacilityListModels successfully',
	IMPORT_BPJS_FACILITY_LISTS_FAIL = '[ENTITY] Import BpjsFacilityListModels fail',


	INITIALISE_BPJS_FACILITY_LIST_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsFacilityListModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsFacilityListAction implements Action {
	readonly className: string = 'BpjsFacilityListModel';

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

export class BpjsFacilityListAction extends BaseBpjsFacilityListAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFacilityListAction here] off begin
	// % protected region % [Add any additional class fields for BpjsFacilityListAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsFacilityListModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFacilityListAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFacilityListAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsFacilityListAction here] off begin
	// % protected region % [Add any additional class methods for BpjsFacilityListAction here] end
}

export class BpjsFacilityListActionOK extends BaseBpjsFacilityListAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFacilityListActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsFacilityListActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsFacilityListModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsFacilityListModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFacilityListActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFacilityListActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsFacilityListActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsFacilityListActionOK here] end
}

export class BpjsFacilityListActionFail extends BaseBpjsFacilityListAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFacilityListActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsFacilityListActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsFacilityListModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFacilityListActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFacilityListActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFacilityListActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFacilityListActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsFacilityListActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsFacilityListActionFail here] end
}

export function isBpjsFacilityListModelAction(e: any): e is BaseBpjsFacilityListAction {
	return Object.values(BpjsFacilityListModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
