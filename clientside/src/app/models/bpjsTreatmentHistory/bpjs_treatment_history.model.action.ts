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
import {BpjsTreatmentHistoryModel} from './bpjs_treatment_history.model';
import {BpjsTreatmentHistoryModelAudit} from './bpjs_treatment_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Treatment History model actions to be dispatched by NgRx.
 */
export enum BpjsTreatmentHistoryModelActionTypes {
	CREATE_BPJS_TREATMENT_HISTORY = '[ENTITY] Create BpjsTreatmentHistoryModel',
	CREATE_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Create BpjsTreatmentHistoryModel successfully',
	CREATE_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Create BpjsTreatmentHistoryModel failed',

	CREATE_ALL_BPJS_TREATMENT_HISTORY = '[ENTITY] Create All BpjsTreatmentHistoryModel',
	CREATE_ALL_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Create All BpjsTreatmentHistoryModel successfully',
	CREATE_ALL_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Create All BpjsTreatmentHistoryModel failed',

	DELETE_BPJS_TREATMENT_HISTORY = '[ENTITY] Delete BpjsTreatmentHistoryModel',
	DELETE_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Delete BpjsTreatmentHistoryModel successfully',
	DELETE_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Delete BpjsTreatmentHistoryModel failed',


	DELETE_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete BpjsTreatmentHistoryModels Excluding Ids',
	DELETE_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsTreatmentHistoryModels Excluding Ids successfully',
	DELETE_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsTreatmentHistoryModels Excluding Ids failed',

	DELETE_ALL_BPJS_TREATMENT_HISTORY = '[ENTITY] Delete all BpjsTreatmentHistoryModels',
	DELETE_ALL_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Delete all BpjsTreatmentHistoryModels successfully',
	DELETE_ALL_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Delete all BpjsTreatmentHistoryModels failed',

	UPDATE_BPJS_TREATMENT_HISTORY = '[ENTITY] Update BpjsTreatmentHistoryModel',
	UPDATE_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Update BpjsTreatmentHistoryModel successfully',
	UPDATE_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Update BpjsTreatmentHistoryModel failed',

	UPDATE_ALL_BPJS_TREATMENT_HISTORY = '[ENTITY] Update all BpjsTreatmentHistoryModel',
	UPDATE_ALL_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Update all BpjsTreatmentHistoryModel successfully',
	UPDATE_ALL_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Update all BpjsTreatmentHistoryModel failed',

	FETCH_BPJS_TREATMENT_HISTORY= '[ENTITY] Fetch BpjsTreatmentHistoryModel',
	FETCH_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Fetch BpjsTreatmentHistoryModel successfully',
	FETCH_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Fetch BpjsTreatmentHistoryModel failed',

	FETCH_BPJS_TREATMENT_HISTORY_AUDIT= '[ENTITY] Fetch BpjsTreatmentHistoryModel audit',
	FETCH_BPJS_TREATMENT_HISTORY_AUDIT_OK = '[ENTITY] Fetch BpjsTreatmentHistoryModel audit successfully',
	FETCH_BPJS_TREATMENT_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch BpjsTreatmentHistoryModel audit failed',

	FETCH_BPJS_TREATMENT_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsTreatmentHistoryModel audits by entity id',
	FETCH_BPJS_TREATMENT_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsTreatmentHistoryModel audits by entity id successfully',
	FETCH_BPJS_TREATMENT_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsTreatmentHistoryModel audits by entity id failed',

	FETCH_ALL_BPJS_TREATMENT_HISTORY = '[ENTITY] Fetch all BpjsTreatmentHistoryModel',
	FETCH_ALL_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Fetch all BpjsTreatmentHistoryModel successfully',
	FETCH_ALL_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Fetch all BpjsTreatmentHistoryModel failed',

	FETCH_BPJS_TREATMENT_HISTORY_WITH_QUERY = '[ENTITY] Fetch BpjsTreatmentHistoryModel with query',
	FETCH_BPJS_TREATMENT_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch BpjsTreatmentHistoryModel with query successfully',
	FETCH_BPJS_TREATMENT_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsTreatmentHistoryModel with query failed',

	FETCH_LAST_BPJS_TREATMENT_HISTORY_WITH_QUERY = '[ENTITY] Fetch last BpjsTreatmentHistoryModel with query',
	FETCH_LAST_BPJS_TREATMENT_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsTreatmentHistoryModel with query successfully',
	FETCH_LAST_BPJS_TREATMENT_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsTreatmentHistoryModel with query failed',

	EXPORT_BPJS_TREATMENT_HISTORY = '[ENTITY] Export BpjsTreatmentHistoryModel',
	EXPORT_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Export BpjsTreatmentHistoryModel successfully',
	EXPORT_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Export BpjsTreatmentHistoryModel failed',

	EXPORT_ALL_BPJS_TREATMENT_HISTORY = '[ENTITY] Export All BpjsTreatmentHistoryModels',
	EXPORT_ALL_BPJS_TREATMENT_HISTORY_OK = '[ENTITY] Export All BpjsTreatmentHistoryModels successfully',
	EXPORT_ALL_BPJS_TREATMENT_HISTORY_FAIL = '[ENTITY] Export All BpjsTreatmentHistoryModels failed',

	EXPORT_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS = '[ENTITY] Export BpjsTreatmentHistoryModels excluding Ids',
	EXPORT_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsTreatmentHistoryModel excluding Ids successfully',
	EXPORT_BPJS_TREATMENT_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsTreatmentHistoryModel excluding Ids failed',

	COUNT_BPJS_TREATMENT_HISTORYS = '[ENTITY] Fetch number of BpjsTreatmentHistoryModel records',
	COUNT_BPJS_TREATMENT_HISTORYS_OK = '[ENTITY] Fetch number of BpjsTreatmentHistoryModel records successfully ',
	COUNT_BPJS_TREATMENT_HISTORYS_FAIL = '[ENTITY] Fetch number of BpjsTreatmentHistoryModel records failed',

	IMPORT_BPJS_TREATMENT_HISTORYS = '[ENTITY] Import BpjsTreatmentHistoryModels',
	IMPORT_BPJS_TREATMENT_HISTORYS_OK = '[ENTITY] Import BpjsTreatmentHistoryModels successfully',
	IMPORT_BPJS_TREATMENT_HISTORYS_FAIL = '[ENTITY] Import BpjsTreatmentHistoryModels fail',


	INITIALISE_BPJS_TREATMENT_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsTreatmentHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsTreatmentHistoryAction implements Action {
	readonly className: string = 'BpjsTreatmentHistoryModel';

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

export class BpjsTreatmentHistoryAction extends BaseBpjsTreatmentHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryAction here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryAction here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryAction here] end
}

export class BpjsTreatmentHistoryActionOK extends BaseBpjsTreatmentHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsTreatmentHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsTreatmentHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryActionOK here] end
}

export class BpjsTreatmentHistoryActionFail extends BaseBpjsTreatmentHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsTreatmentHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsTreatmentHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsTreatmentHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsTreatmentHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsTreatmentHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsTreatmentHistoryActionFail here] end
}

export function isBpjsTreatmentHistoryModelAction(e: any): e is BaseBpjsTreatmentHistoryAction {
	return Object.values(BpjsTreatmentHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
