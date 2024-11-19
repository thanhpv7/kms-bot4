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
import {BpjsVisitDataModel} from './bpjs_visit_data.model';
import {BpjsVisitDataModelAudit} from './bpjs_visit_data.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Visit Data model actions to be dispatched by NgRx.
 */
export enum BpjsVisitDataModelActionTypes {
	CREATE_BPJS_VISIT_DATA = '[ENTITY] Create BpjsVisitDataModel',
	CREATE_BPJS_VISIT_DATA_OK = '[ENTITY] Create BpjsVisitDataModel successfully',
	CREATE_BPJS_VISIT_DATA_FAIL = '[ENTITY] Create BpjsVisitDataModel failed',

	CREATE_ALL_BPJS_VISIT_DATA = '[ENTITY] Create All BpjsVisitDataModel',
	CREATE_ALL_BPJS_VISIT_DATA_OK = '[ENTITY] Create All BpjsVisitDataModel successfully',
	CREATE_ALL_BPJS_VISIT_DATA_FAIL = '[ENTITY] Create All BpjsVisitDataModel failed',

	DELETE_BPJS_VISIT_DATA = '[ENTITY] Delete BpjsVisitDataModel',
	DELETE_BPJS_VISIT_DATA_OK = '[ENTITY] Delete BpjsVisitDataModel successfully',
	DELETE_BPJS_VISIT_DATA_FAIL = '[ENTITY] Delete BpjsVisitDataModel failed',


	DELETE_BPJS_VISIT_DATA_EXCLUDING_IDS = '[ENTITY] Delete BpjsVisitDataModels Excluding Ids',
	DELETE_BPJS_VISIT_DATA_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsVisitDataModels Excluding Ids successfully',
	DELETE_BPJS_VISIT_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsVisitDataModels Excluding Ids failed',

	DELETE_ALL_BPJS_VISIT_DATA = '[ENTITY] Delete all BpjsVisitDataModels',
	DELETE_ALL_BPJS_VISIT_DATA_OK = '[ENTITY] Delete all BpjsVisitDataModels successfully',
	DELETE_ALL_BPJS_VISIT_DATA_FAIL = '[ENTITY] Delete all BpjsVisitDataModels failed',

	UPDATE_BPJS_VISIT_DATA = '[ENTITY] Update BpjsVisitDataModel',
	UPDATE_BPJS_VISIT_DATA_OK = '[ENTITY] Update BpjsVisitDataModel successfully',
	UPDATE_BPJS_VISIT_DATA_FAIL = '[ENTITY] Update BpjsVisitDataModel failed',

	UPDATE_ALL_BPJS_VISIT_DATA = '[ENTITY] Update all BpjsVisitDataModel',
	UPDATE_ALL_BPJS_VISIT_DATA_OK = '[ENTITY] Update all BpjsVisitDataModel successfully',
	UPDATE_ALL_BPJS_VISIT_DATA_FAIL = '[ENTITY] Update all BpjsVisitDataModel failed',

	FETCH_BPJS_VISIT_DATA= '[ENTITY] Fetch BpjsVisitDataModel',
	FETCH_BPJS_VISIT_DATA_OK = '[ENTITY] Fetch BpjsVisitDataModel successfully',
	FETCH_BPJS_VISIT_DATA_FAIL = '[ENTITY] Fetch BpjsVisitDataModel failed',

	FETCH_BPJS_VISIT_DATA_AUDIT= '[ENTITY] Fetch BpjsVisitDataModel audit',
	FETCH_BPJS_VISIT_DATA_AUDIT_OK = '[ENTITY] Fetch BpjsVisitDataModel audit successfully',
	FETCH_BPJS_VISIT_DATA_AUDIT_FAIL = '[ENTITY] Fetch BpjsVisitDataModel audit failed',

	FETCH_BPJS_VISIT_DATA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsVisitDataModel audits by entity id',
	FETCH_BPJS_VISIT_DATA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsVisitDataModel audits by entity id successfully',
	FETCH_BPJS_VISIT_DATA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsVisitDataModel audits by entity id failed',

	FETCH_ALL_BPJS_VISIT_DATA = '[ENTITY] Fetch all BpjsVisitDataModel',
	FETCH_ALL_BPJS_VISIT_DATA_OK = '[ENTITY] Fetch all BpjsVisitDataModel successfully',
	FETCH_ALL_BPJS_VISIT_DATA_FAIL = '[ENTITY] Fetch all BpjsVisitDataModel failed',

	FETCH_BPJS_VISIT_DATA_WITH_QUERY = '[ENTITY] Fetch BpjsVisitDataModel with query',
	FETCH_BPJS_VISIT_DATA_WITH_QUERY_OK = '[ENTITY] Fetch BpjsVisitDataModel with query successfully',
	FETCH_BPJS_VISIT_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsVisitDataModel with query failed',

	FETCH_LAST_BPJS_VISIT_DATA_WITH_QUERY = '[ENTITY] Fetch last BpjsVisitDataModel with query',
	FETCH_LAST_BPJS_VISIT_DATA_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsVisitDataModel with query successfully',
	FETCH_LAST_BPJS_VISIT_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsVisitDataModel with query failed',

	EXPORT_BPJS_VISIT_DATA = '[ENTITY] Export BpjsVisitDataModel',
	EXPORT_BPJS_VISIT_DATA_OK = '[ENTITY] Export BpjsVisitDataModel successfully',
	EXPORT_BPJS_VISIT_DATA_FAIL = '[ENTITY] Export BpjsVisitDataModel failed',

	EXPORT_ALL_BPJS_VISIT_DATA = '[ENTITY] Export All BpjsVisitDataModels',
	EXPORT_ALL_BPJS_VISIT_DATA_OK = '[ENTITY] Export All BpjsVisitDataModels successfully',
	EXPORT_ALL_BPJS_VISIT_DATA_FAIL = '[ENTITY] Export All BpjsVisitDataModels failed',

	EXPORT_BPJS_VISIT_DATA_EXCLUDING_IDS = '[ENTITY] Export BpjsVisitDataModels excluding Ids',
	EXPORT_BPJS_VISIT_DATA_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsVisitDataModel excluding Ids successfully',
	EXPORT_BPJS_VISIT_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsVisitDataModel excluding Ids failed',

	COUNT_BPJS_VISIT_DATAS = '[ENTITY] Fetch number of BpjsVisitDataModel records',
	COUNT_BPJS_VISIT_DATAS_OK = '[ENTITY] Fetch number of BpjsVisitDataModel records successfully ',
	COUNT_BPJS_VISIT_DATAS_FAIL = '[ENTITY] Fetch number of BpjsVisitDataModel records failed',

	IMPORT_BPJS_VISIT_DATAS = '[ENTITY] Import BpjsVisitDataModels',
	IMPORT_BPJS_VISIT_DATAS_OK = '[ENTITY] Import BpjsVisitDataModels successfully',
	IMPORT_BPJS_VISIT_DATAS_FAIL = '[ENTITY] Import BpjsVisitDataModels fail',


	INITIALISE_BPJS_VISIT_DATA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsVisitDataModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsVisitDataAction implements Action {
	readonly className: string = 'BpjsVisitDataModel';

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

export class BpjsVisitDataAction extends BaseBpjsVisitDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsVisitDataAction here] off begin
	// % protected region % [Add any additional class fields for BpjsVisitDataAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsVisitDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsVisitDataAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsVisitDataAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsVisitDataAction here] off begin
	// % protected region % [Add any additional class methods for BpjsVisitDataAction here] end
}

export class BpjsVisitDataActionOK extends BaseBpjsVisitDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsVisitDataActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsVisitDataActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsVisitDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsVisitDataModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsVisitDataActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsVisitDataActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsVisitDataActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsVisitDataActionOK here] end
}

export class BpjsVisitDataActionFail extends BaseBpjsVisitDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsVisitDataActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsVisitDataActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsVisitDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsVisitDataActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsVisitDataActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsVisitDataActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsVisitDataActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsVisitDataActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsVisitDataActionFail here] end
}

export function isBpjsVisitDataModelAction(e: any): e is BaseBpjsVisitDataAction {
	return Object.values(BpjsVisitDataModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
