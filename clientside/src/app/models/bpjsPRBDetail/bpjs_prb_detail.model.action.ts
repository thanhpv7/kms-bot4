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
import {BpjsPRBDetailModel} from './bpjs_prb_detail.model';
import {BpjsPRBDetailModelAudit} from './bpjs_prb_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS PRB Detail model actions to be dispatched by NgRx.
 */
export enum BpjsPRBDetailModelActionTypes {
	CREATE_BPJS_PRB_DETAIL = '[ENTITY] Create BpjsPRBDetailModel',
	CREATE_BPJS_PRB_DETAIL_OK = '[ENTITY] Create BpjsPRBDetailModel successfully',
	CREATE_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Create BpjsPRBDetailModel failed',

	CREATE_ALL_BPJS_PRB_DETAIL = '[ENTITY] Create All BpjsPRBDetailModel',
	CREATE_ALL_BPJS_PRB_DETAIL_OK = '[ENTITY] Create All BpjsPRBDetailModel successfully',
	CREATE_ALL_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Create All BpjsPRBDetailModel failed',

	DELETE_BPJS_PRB_DETAIL = '[ENTITY] Delete BpjsPRBDetailModel',
	DELETE_BPJS_PRB_DETAIL_OK = '[ENTITY] Delete BpjsPRBDetailModel successfully',
	DELETE_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Delete BpjsPRBDetailModel failed',


	DELETE_BPJS_PRB_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete BpjsPRBDetailModels Excluding Ids',
	DELETE_BPJS_PRB_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPRBDetailModels Excluding Ids successfully',
	DELETE_BPJS_PRB_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPRBDetailModels Excluding Ids failed',

	DELETE_ALL_BPJS_PRB_DETAIL = '[ENTITY] Delete all BpjsPRBDetailModels',
	DELETE_ALL_BPJS_PRB_DETAIL_OK = '[ENTITY] Delete all BpjsPRBDetailModels successfully',
	DELETE_ALL_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Delete all BpjsPRBDetailModels failed',

	UPDATE_BPJS_PRB_DETAIL = '[ENTITY] Update BpjsPRBDetailModel',
	UPDATE_BPJS_PRB_DETAIL_OK = '[ENTITY] Update BpjsPRBDetailModel successfully',
	UPDATE_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Update BpjsPRBDetailModel failed',

	UPDATE_ALL_BPJS_PRB_DETAIL = '[ENTITY] Update all BpjsPRBDetailModel',
	UPDATE_ALL_BPJS_PRB_DETAIL_OK = '[ENTITY] Update all BpjsPRBDetailModel successfully',
	UPDATE_ALL_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Update all BpjsPRBDetailModel failed',

	FETCH_BPJS_PRB_DETAIL= '[ENTITY] Fetch BpjsPRBDetailModel',
	FETCH_BPJS_PRB_DETAIL_OK = '[ENTITY] Fetch BpjsPRBDetailModel successfully',
	FETCH_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Fetch BpjsPRBDetailModel failed',

	FETCH_BPJS_PRB_DETAIL_AUDIT= '[ENTITY] Fetch BpjsPRBDetailModel audit',
	FETCH_BPJS_PRB_DETAIL_AUDIT_OK = '[ENTITY] Fetch BpjsPRBDetailModel audit successfully',
	FETCH_BPJS_PRB_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch BpjsPRBDetailModel audit failed',

	FETCH_BPJS_PRB_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPRBDetailModel audits by entity id',
	FETCH_BPJS_PRB_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPRBDetailModel audits by entity id successfully',
	FETCH_BPJS_PRB_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPRBDetailModel audits by entity id failed',

	FETCH_ALL_BPJS_PRB_DETAIL = '[ENTITY] Fetch all BpjsPRBDetailModel',
	FETCH_ALL_BPJS_PRB_DETAIL_OK = '[ENTITY] Fetch all BpjsPRBDetailModel successfully',
	FETCH_ALL_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Fetch all BpjsPRBDetailModel failed',

	FETCH_BPJS_PRB_DETAIL_WITH_QUERY = '[ENTITY] Fetch BpjsPRBDetailModel with query',
	FETCH_BPJS_PRB_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPRBDetailModel with query successfully',
	FETCH_BPJS_PRB_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPRBDetailModel with query failed',

	FETCH_LAST_BPJS_PRB_DETAIL_WITH_QUERY = '[ENTITY] Fetch last BpjsPRBDetailModel with query',
	FETCH_LAST_BPJS_PRB_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPRBDetailModel with query successfully',
	FETCH_LAST_BPJS_PRB_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPRBDetailModel with query failed',

	EXPORT_BPJS_PRB_DETAIL = '[ENTITY] Export BpjsPRBDetailModel',
	EXPORT_BPJS_PRB_DETAIL_OK = '[ENTITY] Export BpjsPRBDetailModel successfully',
	EXPORT_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Export BpjsPRBDetailModel failed',

	EXPORT_ALL_BPJS_PRB_DETAIL = '[ENTITY] Export All BpjsPRBDetailModels',
	EXPORT_ALL_BPJS_PRB_DETAIL_OK = '[ENTITY] Export All BpjsPRBDetailModels successfully',
	EXPORT_ALL_BPJS_PRB_DETAIL_FAIL = '[ENTITY] Export All BpjsPRBDetailModels failed',

	EXPORT_BPJS_PRB_DETAIL_EXCLUDING_IDS = '[ENTITY] Export BpjsPRBDetailModels excluding Ids',
	EXPORT_BPJS_PRB_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPRBDetailModel excluding Ids successfully',
	EXPORT_BPJS_PRB_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPRBDetailModel excluding Ids failed',

	COUNT_BPJS_PRB_DETAILS = '[ENTITY] Fetch number of BpjsPRBDetailModel records',
	COUNT_BPJS_PRB_DETAILS_OK = '[ENTITY] Fetch number of BpjsPRBDetailModel records successfully ',
	COUNT_BPJS_PRB_DETAILS_FAIL = '[ENTITY] Fetch number of BpjsPRBDetailModel records failed',

	IMPORT_BPJS_PRB_DETAILS = '[ENTITY] Import BpjsPRBDetailModels',
	IMPORT_BPJS_PRB_DETAILS_OK = '[ENTITY] Import BpjsPRBDetailModels successfully',
	IMPORT_BPJS_PRB_DETAILS_FAIL = '[ENTITY] Import BpjsPRBDetailModels fail',


	INITIALISE_BPJS_PRB_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPRBDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPRBDetailAction implements Action {
	readonly className: string = 'BpjsPRBDetailModel';

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

export class BpjsPRBDetailAction extends BaseBpjsPRBDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBDetailAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPRBDetailModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBDetailAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBDetailAction here] end
}

export class BpjsPRBDetailActionOK extends BaseBpjsPRBDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPRBDetailModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPRBDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBDetailActionOK here] end
}

export class BpjsPRBDetailActionFail extends BaseBpjsPRBDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPRBDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPRBDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPRBDetailModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPRBDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPRBDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPRBDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPRBDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPRBDetailActionFail here] end
}

export function isBpjsPRBDetailModelAction(e: any): e is BaseBpjsPRBDetailAction {
	return Object.values(BpjsPRBDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
