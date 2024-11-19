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
import {BirthHistoryModel} from './birth_history.model';
import {BirthHistoryModelAudit} from './birth_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Birth History model actions to be dispatched by NgRx.
 */
export enum BirthHistoryModelActionTypes {
	CREATE_BIRTH_HISTORY = '[ENTITY] Create BirthHistoryModel',
	CREATE_BIRTH_HISTORY_OK = '[ENTITY] Create BirthHistoryModel successfully',
	CREATE_BIRTH_HISTORY_FAIL = '[ENTITY] Create BirthHistoryModel failed',

	CREATE_ALL_BIRTH_HISTORY = '[ENTITY] Create All BirthHistoryModel',
	CREATE_ALL_BIRTH_HISTORY_OK = '[ENTITY] Create All BirthHistoryModel successfully',
	CREATE_ALL_BIRTH_HISTORY_FAIL = '[ENTITY] Create All BirthHistoryModel failed',

	DELETE_BIRTH_HISTORY = '[ENTITY] Delete BirthHistoryModel',
	DELETE_BIRTH_HISTORY_OK = '[ENTITY] Delete BirthHistoryModel successfully',
	DELETE_BIRTH_HISTORY_FAIL = '[ENTITY] Delete BirthHistoryModel failed',


	DELETE_BIRTH_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete BirthHistoryModels Excluding Ids',
	DELETE_BIRTH_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete BirthHistoryModels Excluding Ids successfully',
	DELETE_BIRTH_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BirthHistoryModels Excluding Ids failed',

	DELETE_ALL_BIRTH_HISTORY = '[ENTITY] Delete all BirthHistoryModels',
	DELETE_ALL_BIRTH_HISTORY_OK = '[ENTITY] Delete all BirthHistoryModels successfully',
	DELETE_ALL_BIRTH_HISTORY_FAIL = '[ENTITY] Delete all BirthHistoryModels failed',

	UPDATE_BIRTH_HISTORY = '[ENTITY] Update BirthHistoryModel',
	UPDATE_BIRTH_HISTORY_OK = '[ENTITY] Update BirthHistoryModel successfully',
	UPDATE_BIRTH_HISTORY_FAIL = '[ENTITY] Update BirthHistoryModel failed',

	UPDATE_ALL_BIRTH_HISTORY = '[ENTITY] Update all BirthHistoryModel',
	UPDATE_ALL_BIRTH_HISTORY_OK = '[ENTITY] Update all BirthHistoryModel successfully',
	UPDATE_ALL_BIRTH_HISTORY_FAIL = '[ENTITY] Update all BirthHistoryModel failed',

	FETCH_BIRTH_HISTORY= '[ENTITY] Fetch BirthHistoryModel',
	FETCH_BIRTH_HISTORY_OK = '[ENTITY] Fetch BirthHistoryModel successfully',
	FETCH_BIRTH_HISTORY_FAIL = '[ENTITY] Fetch BirthHistoryModel failed',

	FETCH_BIRTH_HISTORY_AUDIT= '[ENTITY] Fetch BirthHistoryModel audit',
	FETCH_BIRTH_HISTORY_AUDIT_OK = '[ENTITY] Fetch BirthHistoryModel audit successfully',
	FETCH_BIRTH_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch BirthHistoryModel audit failed',

	FETCH_BIRTH_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BirthHistoryModel audits by entity id',
	FETCH_BIRTH_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BirthHistoryModel audits by entity id successfully',
	FETCH_BIRTH_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BirthHistoryModel audits by entity id failed',

	FETCH_ALL_BIRTH_HISTORY = '[ENTITY] Fetch all BirthHistoryModel',
	FETCH_ALL_BIRTH_HISTORY_OK = '[ENTITY] Fetch all BirthHistoryModel successfully',
	FETCH_ALL_BIRTH_HISTORY_FAIL = '[ENTITY] Fetch all BirthHistoryModel failed',

	FETCH_BIRTH_HISTORY_WITH_QUERY = '[ENTITY] Fetch BirthHistoryModel with query',
	FETCH_BIRTH_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch BirthHistoryModel with query successfully',
	FETCH_BIRTH_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch BirthHistoryModel with query failed',

	FETCH_LAST_BIRTH_HISTORY_WITH_QUERY = '[ENTITY] Fetch last BirthHistoryModel with query',
	FETCH_LAST_BIRTH_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last BirthHistoryModel with query successfully',
	FETCH_LAST_BIRTH_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last BirthHistoryModel with query failed',

	EXPORT_BIRTH_HISTORY = '[ENTITY] Export BirthHistoryModel',
	EXPORT_BIRTH_HISTORY_OK = '[ENTITY] Export BirthHistoryModel successfully',
	EXPORT_BIRTH_HISTORY_FAIL = '[ENTITY] Export BirthHistoryModel failed',

	EXPORT_ALL_BIRTH_HISTORY = '[ENTITY] Export All BirthHistoryModels',
	EXPORT_ALL_BIRTH_HISTORY_OK = '[ENTITY] Export All BirthHistoryModels successfully',
	EXPORT_ALL_BIRTH_HISTORY_FAIL = '[ENTITY] Export All BirthHistoryModels failed',

	EXPORT_BIRTH_HISTORY_EXCLUDING_IDS = '[ENTITY] Export BirthHistoryModels excluding Ids',
	EXPORT_BIRTH_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export BirthHistoryModel excluding Ids successfully',
	EXPORT_BIRTH_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export BirthHistoryModel excluding Ids failed',

	COUNT_BIRTH_HISTORYS = '[ENTITY] Fetch number of BirthHistoryModel records',
	COUNT_BIRTH_HISTORYS_OK = '[ENTITY] Fetch number of BirthHistoryModel records successfully ',
	COUNT_BIRTH_HISTORYS_FAIL = '[ENTITY] Fetch number of BirthHistoryModel records failed',

	IMPORT_BIRTH_HISTORYS = '[ENTITY] Import BirthHistoryModels',
	IMPORT_BIRTH_HISTORYS_OK = '[ENTITY] Import BirthHistoryModels successfully',
	IMPORT_BIRTH_HISTORYS_FAIL = '[ENTITY] Import BirthHistoryModels fail',


	INITIALISE_BIRTH_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BirthHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBirthHistoryAction implements Action {
	readonly className: string = 'BirthHistoryModel';

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

export class BirthHistoryAction extends BaseBirthHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BirthHistoryAction here] off begin
	// % protected region % [Add any additional class fields for BirthHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BirthHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BirthHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for BirthHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BirthHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for BirthHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BirthHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for BirthHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for BirthHistoryAction here] off begin
	// % protected region % [Add any additional class methods for BirthHistoryAction here] end
}

export class BirthHistoryActionOK extends BaseBirthHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BirthHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for BirthHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BirthHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BirthHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BirthHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BirthHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BirthHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BirthHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BirthHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BirthHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for BirthHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for BirthHistoryActionOK here] end
}

export class BirthHistoryActionFail extends BaseBirthHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BirthHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for BirthHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BirthHistoryModel>,
		// % protected region % [Add any additional constructor parameters for BirthHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BirthHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BirthHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BirthHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BirthHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BirthHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for BirthHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for BirthHistoryActionFail here] end
}

export function isBirthHistoryModelAction(e: any): e is BaseBirthHistoryAction {
	return Object.values(BirthHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
