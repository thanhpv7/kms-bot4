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
import {DailyCareCPPTModel} from './daily_care_cppt.model';
import {DailyCareCPPTModelAudit} from './daily_care_cppt.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Daily Care CPPT model actions to be dispatched by NgRx.
 */
export enum DailyCareCPPTModelActionTypes {
	CREATE_DAILY_CARE_CPPT = '[ENTITY] Create DailyCareCPPTModel',
	CREATE_DAILY_CARE_CPPT_OK = '[ENTITY] Create DailyCareCPPTModel successfully',
	CREATE_DAILY_CARE_CPPT_FAIL = '[ENTITY] Create DailyCareCPPTModel failed',

	CREATE_ALL_DAILY_CARE_CPPT = '[ENTITY] Create All DailyCareCPPTModel',
	CREATE_ALL_DAILY_CARE_CPPT_OK = '[ENTITY] Create All DailyCareCPPTModel successfully',
	CREATE_ALL_DAILY_CARE_CPPT_FAIL = '[ENTITY] Create All DailyCareCPPTModel failed',

	DELETE_DAILY_CARE_CPPT = '[ENTITY] Delete DailyCareCPPTModel',
	DELETE_DAILY_CARE_CPPT_OK = '[ENTITY] Delete DailyCareCPPTModel successfully',
	DELETE_DAILY_CARE_CPPT_FAIL = '[ENTITY] Delete DailyCareCPPTModel failed',


	DELETE_DAILY_CARE_CPPT_EXCLUDING_IDS = '[ENTITY] Delete DailyCareCPPTModels Excluding Ids',
	DELETE_DAILY_CARE_CPPT_EXCLUDING_IDS_OK = '[ENTITY] Delete DailyCareCPPTModels Excluding Ids successfully',
	DELETE_DAILY_CARE_CPPT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DailyCareCPPTModels Excluding Ids failed',

	DELETE_ALL_DAILY_CARE_CPPT = '[ENTITY] Delete all DailyCareCPPTModels',
	DELETE_ALL_DAILY_CARE_CPPT_OK = '[ENTITY] Delete all DailyCareCPPTModels successfully',
	DELETE_ALL_DAILY_CARE_CPPT_FAIL = '[ENTITY] Delete all DailyCareCPPTModels failed',

	UPDATE_DAILY_CARE_CPPT = '[ENTITY] Update DailyCareCPPTModel',
	UPDATE_DAILY_CARE_CPPT_OK = '[ENTITY] Update DailyCareCPPTModel successfully',
	UPDATE_DAILY_CARE_CPPT_FAIL = '[ENTITY] Update DailyCareCPPTModel failed',

	UPDATE_ALL_DAILY_CARE_CPPT = '[ENTITY] Update all DailyCareCPPTModel',
	UPDATE_ALL_DAILY_CARE_CPPT_OK = '[ENTITY] Update all DailyCareCPPTModel successfully',
	UPDATE_ALL_DAILY_CARE_CPPT_FAIL = '[ENTITY] Update all DailyCareCPPTModel failed',

	FETCH_DAILY_CARE_CPPT= '[ENTITY] Fetch DailyCareCPPTModel',
	FETCH_DAILY_CARE_CPPT_OK = '[ENTITY] Fetch DailyCareCPPTModel successfully',
	FETCH_DAILY_CARE_CPPT_FAIL = '[ENTITY] Fetch DailyCareCPPTModel failed',

	FETCH_DAILY_CARE_CPPT_AUDIT= '[ENTITY] Fetch DailyCareCPPTModel audit',
	FETCH_DAILY_CARE_CPPT_AUDIT_OK = '[ENTITY] Fetch DailyCareCPPTModel audit successfully',
	FETCH_DAILY_CARE_CPPT_AUDIT_FAIL = '[ENTITY] Fetch DailyCareCPPTModel audit failed',

	FETCH_DAILY_CARE_CPPT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DailyCareCPPTModel audits by entity id',
	FETCH_DAILY_CARE_CPPT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DailyCareCPPTModel audits by entity id successfully',
	FETCH_DAILY_CARE_CPPT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DailyCareCPPTModel audits by entity id failed',

	FETCH_ALL_DAILY_CARE_CPPT = '[ENTITY] Fetch all DailyCareCPPTModel',
	FETCH_ALL_DAILY_CARE_CPPT_OK = '[ENTITY] Fetch all DailyCareCPPTModel successfully',
	FETCH_ALL_DAILY_CARE_CPPT_FAIL = '[ENTITY] Fetch all DailyCareCPPTModel failed',

	FETCH_DAILY_CARE_CPPT_WITH_QUERY = '[ENTITY] Fetch DailyCareCPPTModel with query',
	FETCH_DAILY_CARE_CPPT_WITH_QUERY_OK = '[ENTITY] Fetch DailyCareCPPTModel with query successfully',
	FETCH_DAILY_CARE_CPPT_WITH_QUERY_FAIL = '[ENTITY] Fetch DailyCareCPPTModel with query failed',

	FETCH_LAST_DAILY_CARE_CPPT_WITH_QUERY = '[ENTITY] Fetch last DailyCareCPPTModel with query',
	FETCH_LAST_DAILY_CARE_CPPT_WITH_QUERY_OK = '[ENTITY] Fetch last DailyCareCPPTModel with query successfully',
	FETCH_LAST_DAILY_CARE_CPPT_WITH_QUERY_FAIL = '[ENTITY] Fetch last DailyCareCPPTModel with query failed',

	EXPORT_DAILY_CARE_CPPT = '[ENTITY] Export DailyCareCPPTModel',
	EXPORT_DAILY_CARE_CPPT_OK = '[ENTITY] Export DailyCareCPPTModel successfully',
	EXPORT_DAILY_CARE_CPPT_FAIL = '[ENTITY] Export DailyCareCPPTModel failed',

	EXPORT_ALL_DAILY_CARE_CPPT = '[ENTITY] Export All DailyCareCPPTModels',
	EXPORT_ALL_DAILY_CARE_CPPT_OK = '[ENTITY] Export All DailyCareCPPTModels successfully',
	EXPORT_ALL_DAILY_CARE_CPPT_FAIL = '[ENTITY] Export All DailyCareCPPTModels failed',

	EXPORT_DAILY_CARE_CPPT_EXCLUDING_IDS = '[ENTITY] Export DailyCareCPPTModels excluding Ids',
	EXPORT_DAILY_CARE_CPPT_EXCLUDING_IDS_OK = '[ENTITY] Export DailyCareCPPTModel excluding Ids successfully',
	EXPORT_DAILY_CARE_CPPT_EXCLUDING_IDS_FAIL = '[ENTITY] Export DailyCareCPPTModel excluding Ids failed',

	COUNT_DAILY_CARE_CPPTS = '[ENTITY] Fetch number of DailyCareCPPTModel records',
	COUNT_DAILY_CARE_CPPTS_OK = '[ENTITY] Fetch number of DailyCareCPPTModel records successfully ',
	COUNT_DAILY_CARE_CPPTS_FAIL = '[ENTITY] Fetch number of DailyCareCPPTModel records failed',

	IMPORT_DAILY_CARE_CPPTS = '[ENTITY] Import DailyCareCPPTModels',
	IMPORT_DAILY_CARE_CPPTS_OK = '[ENTITY] Import DailyCareCPPTModels successfully',
	IMPORT_DAILY_CARE_CPPTS_FAIL = '[ENTITY] Import DailyCareCPPTModels fail',


	INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DailyCareCPPTModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDailyCareCPPTAction implements Action {
	readonly className: string = 'DailyCareCPPTModel';

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

export class DailyCareCPPTAction extends BaseDailyCareCPPTAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DailyCareCPPTAction here] off begin
	// % protected region % [Add any additional class fields for DailyCareCPPTAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DailyCareCPPTModel>,
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTAction here] off begin
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTAction here] off begin
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DailyCareCPPTAction here] off begin
		// % protected region % [Add any additional constructor logic for DailyCareCPPTAction here] end
	}

	// % protected region % [Add any additional class methods for DailyCareCPPTAction here] off begin
	// % protected region % [Add any additional class methods for DailyCareCPPTAction here] end
}

export class DailyCareCPPTActionOK extends BaseDailyCareCPPTAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DailyCareCPPTActionOK here] off begin
	// % protected region % [Add any additional class fields for DailyCareCPPTActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DailyCareCPPTModel>,
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DailyCareCPPTModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DailyCareCPPTActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DailyCareCPPTActionOK here] end
	}

	// % protected region % [Add any additional class methods for DailyCareCPPTActionOK here] off begin
	// % protected region % [Add any additional class methods for DailyCareCPPTActionOK here] end
}

export class DailyCareCPPTActionFail extends BaseDailyCareCPPTAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DailyCareCPPTActionFail here] off begin
	// % protected region % [Add any additional class fields for DailyCareCPPTActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DailyCareCPPTModel>,
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DailyCareCPPTActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DailyCareCPPTActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DailyCareCPPTActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DailyCareCPPTActionFail here] end
	}

	// % protected region % [Add any additional class methods for DailyCareCPPTActionFail here] off begin
	// % protected region % [Add any additional class methods for DailyCareCPPTActionFail here] end
}

export function isDailyCareCPPTModelAction(e: any): e is BaseDailyCareCPPTAction {
	return Object.values(DailyCareCPPTModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
