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
import {PreoperativeRecordsModel} from './preoperative_records.model';
import {PreoperativeRecordsModelAudit} from './preoperative_records.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Preoperative Records model actions to be dispatched by NgRx.
 */
export enum PreoperativeRecordsModelActionTypes {
	CREATE_PREOPERATIVE_RECORDS = '[ENTITY] Create PreoperativeRecordsModel',
	CREATE_PREOPERATIVE_RECORDS_OK = '[ENTITY] Create PreoperativeRecordsModel successfully',
	CREATE_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Create PreoperativeRecordsModel failed',

	CREATE_ALL_PREOPERATIVE_RECORDS = '[ENTITY] Create All PreoperativeRecordsModel',
	CREATE_ALL_PREOPERATIVE_RECORDS_OK = '[ENTITY] Create All PreoperativeRecordsModel successfully',
	CREATE_ALL_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Create All PreoperativeRecordsModel failed',

	DELETE_PREOPERATIVE_RECORDS = '[ENTITY] Delete PreoperativeRecordsModel',
	DELETE_PREOPERATIVE_RECORDS_OK = '[ENTITY] Delete PreoperativeRecordsModel successfully',
	DELETE_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Delete PreoperativeRecordsModel failed',


	DELETE_PREOPERATIVE_RECORDS_EXCLUDING_IDS = '[ENTITY] Delete PreoperativeRecordsModels Excluding Ids',
	DELETE_PREOPERATIVE_RECORDS_EXCLUDING_IDS_OK = '[ENTITY] Delete PreoperativeRecordsModels Excluding Ids successfully',
	DELETE_PREOPERATIVE_RECORDS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PreoperativeRecordsModels Excluding Ids failed',

	DELETE_ALL_PREOPERATIVE_RECORDS = '[ENTITY] Delete all PreoperativeRecordsModels',
	DELETE_ALL_PREOPERATIVE_RECORDS_OK = '[ENTITY] Delete all PreoperativeRecordsModels successfully',
	DELETE_ALL_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Delete all PreoperativeRecordsModels failed',

	UPDATE_PREOPERATIVE_RECORDS = '[ENTITY] Update PreoperativeRecordsModel',
	UPDATE_PREOPERATIVE_RECORDS_OK = '[ENTITY] Update PreoperativeRecordsModel successfully',
	UPDATE_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Update PreoperativeRecordsModel failed',

	UPDATE_ALL_PREOPERATIVE_RECORDS = '[ENTITY] Update all PreoperativeRecordsModel',
	UPDATE_ALL_PREOPERATIVE_RECORDS_OK = '[ENTITY] Update all PreoperativeRecordsModel successfully',
	UPDATE_ALL_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Update all PreoperativeRecordsModel failed',

	FETCH_PREOPERATIVE_RECORDS= '[ENTITY] Fetch PreoperativeRecordsModel',
	FETCH_PREOPERATIVE_RECORDS_OK = '[ENTITY] Fetch PreoperativeRecordsModel successfully',
	FETCH_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Fetch PreoperativeRecordsModel failed',

	FETCH_PREOPERATIVE_RECORDS_AUDIT= '[ENTITY] Fetch PreoperativeRecordsModel audit',
	FETCH_PREOPERATIVE_RECORDS_AUDIT_OK = '[ENTITY] Fetch PreoperativeRecordsModel audit successfully',
	FETCH_PREOPERATIVE_RECORDS_AUDIT_FAIL = '[ENTITY] Fetch PreoperativeRecordsModel audit failed',

	FETCH_PREOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PreoperativeRecordsModel audits by entity id',
	FETCH_PREOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PreoperativeRecordsModel audits by entity id successfully',
	FETCH_PREOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PreoperativeRecordsModel audits by entity id failed',

	FETCH_ALL_PREOPERATIVE_RECORDS = '[ENTITY] Fetch all PreoperativeRecordsModel',
	FETCH_ALL_PREOPERATIVE_RECORDS_OK = '[ENTITY] Fetch all PreoperativeRecordsModel successfully',
	FETCH_ALL_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Fetch all PreoperativeRecordsModel failed',

	FETCH_PREOPERATIVE_RECORDS_WITH_QUERY = '[ENTITY] Fetch PreoperativeRecordsModel with query',
	FETCH_PREOPERATIVE_RECORDS_WITH_QUERY_OK = '[ENTITY] Fetch PreoperativeRecordsModel with query successfully',
	FETCH_PREOPERATIVE_RECORDS_WITH_QUERY_FAIL = '[ENTITY] Fetch PreoperativeRecordsModel with query failed',

	FETCH_LAST_PREOPERATIVE_RECORDS_WITH_QUERY = '[ENTITY] Fetch last PreoperativeRecordsModel with query',
	FETCH_LAST_PREOPERATIVE_RECORDS_WITH_QUERY_OK = '[ENTITY] Fetch last PreoperativeRecordsModel with query successfully',
	FETCH_LAST_PREOPERATIVE_RECORDS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PreoperativeRecordsModel with query failed',

	EXPORT_PREOPERATIVE_RECORDS = '[ENTITY] Export PreoperativeRecordsModel',
	EXPORT_PREOPERATIVE_RECORDS_OK = '[ENTITY] Export PreoperativeRecordsModel successfully',
	EXPORT_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Export PreoperativeRecordsModel failed',

	EXPORT_ALL_PREOPERATIVE_RECORDS = '[ENTITY] Export All PreoperativeRecordsModels',
	EXPORT_ALL_PREOPERATIVE_RECORDS_OK = '[ENTITY] Export All PreoperativeRecordsModels successfully',
	EXPORT_ALL_PREOPERATIVE_RECORDS_FAIL = '[ENTITY] Export All PreoperativeRecordsModels failed',

	EXPORT_PREOPERATIVE_RECORDS_EXCLUDING_IDS = '[ENTITY] Export PreoperativeRecordsModels excluding Ids',
	EXPORT_PREOPERATIVE_RECORDS_EXCLUDING_IDS_OK = '[ENTITY] Export PreoperativeRecordsModel excluding Ids successfully',
	EXPORT_PREOPERATIVE_RECORDS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PreoperativeRecordsModel excluding Ids failed',

	COUNT_PREOPERATIVE_RECORDSS = '[ENTITY] Fetch number of PreoperativeRecordsModel records',
	COUNT_PREOPERATIVE_RECORDSS_OK = '[ENTITY] Fetch number of PreoperativeRecordsModel records successfully ',
	COUNT_PREOPERATIVE_RECORDSS_FAIL = '[ENTITY] Fetch number of PreoperativeRecordsModel records failed',

	IMPORT_PREOPERATIVE_RECORDSS = '[ENTITY] Import PreoperativeRecordsModels',
	IMPORT_PREOPERATIVE_RECORDSS_OK = '[ENTITY] Import PreoperativeRecordsModels successfully',
	IMPORT_PREOPERATIVE_RECORDSS_FAIL = '[ENTITY] Import PreoperativeRecordsModels fail',


	INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PreoperativeRecordsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePreoperativeRecordsAction implements Action {
	readonly className: string = 'PreoperativeRecordsModel';

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

export class PreoperativeRecordsAction extends BasePreoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PreoperativeRecordsAction here] off begin
	// % protected region % [Add any additional class fields for PreoperativeRecordsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PreoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsAction here] off begin
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsAction here] off begin
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsAction here] off begin
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsAction here] end
	}

	// % protected region % [Add any additional class methods for PreoperativeRecordsAction here] off begin
	// % protected region % [Add any additional class methods for PreoperativeRecordsAction here] end
}

export class PreoperativeRecordsActionOK extends BasePreoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PreoperativeRecordsActionOK here] off begin
	// % protected region % [Add any additional class fields for PreoperativeRecordsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PreoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PreoperativeRecordsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsActionOK here] end
	}

	// % protected region % [Add any additional class methods for PreoperativeRecordsActionOK here] off begin
	// % protected region % [Add any additional class methods for PreoperativeRecordsActionOK here] end
}

export class PreoperativeRecordsActionFail extends BasePreoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PreoperativeRecordsActionFail here] off begin
	// % protected region % [Add any additional class fields for PreoperativeRecordsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PreoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PreoperativeRecordsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PreoperativeRecordsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PreoperativeRecordsActionFail here] end
	}

	// % protected region % [Add any additional class methods for PreoperativeRecordsActionFail here] off begin
	// % protected region % [Add any additional class methods for PreoperativeRecordsActionFail here] end
}

export function isPreoperativeRecordsModelAction(e: any): e is BasePreoperativeRecordsAction {
	return Object.values(PreoperativeRecordsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
