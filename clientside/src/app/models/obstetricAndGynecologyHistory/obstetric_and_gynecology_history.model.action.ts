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
import {ObstetricAndGynecologyHistoryModel} from './obstetric_and_gynecology_history.model';
import {ObstetricAndGynecologyHistoryModelAudit} from './obstetric_and_gynecology_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Obstetric And Gynecology History model actions to be dispatched by NgRx.
 */
export enum ObstetricAndGynecologyHistoryModelActionTypes {
	CREATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Create ObstetricAndGynecologyHistoryModel',
	CREATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Create ObstetricAndGynecologyHistoryModel successfully',
	CREATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Create ObstetricAndGynecologyHistoryModel failed',

	CREATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Create All ObstetricAndGynecologyHistoryModel',
	CREATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Create All ObstetricAndGynecologyHistoryModel successfully',
	CREATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Create All ObstetricAndGynecologyHistoryModel failed',

	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Delete ObstetricAndGynecologyHistoryModel',
	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Delete ObstetricAndGynecologyHistoryModel successfully',
	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Delete ObstetricAndGynecologyHistoryModel failed',


	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete ObstetricAndGynecologyHistoryModels Excluding Ids',
	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete ObstetricAndGynecologyHistoryModels Excluding Ids successfully',
	DELETE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ObstetricAndGynecologyHistoryModels Excluding Ids failed',

	DELETE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Delete all ObstetricAndGynecologyHistoryModels',
	DELETE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Delete all ObstetricAndGynecologyHistoryModels successfully',
	DELETE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Delete all ObstetricAndGynecologyHistoryModels failed',

	UPDATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Update ObstetricAndGynecologyHistoryModel',
	UPDATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Update ObstetricAndGynecologyHistoryModel successfully',
	UPDATE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Update ObstetricAndGynecologyHistoryModel failed',

	UPDATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Update all ObstetricAndGynecologyHistoryModel',
	UPDATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Update all ObstetricAndGynecologyHistoryModel successfully',
	UPDATE_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Update all ObstetricAndGynecologyHistoryModel failed',

	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY= '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel successfully',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel failed',

	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDIT= '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audit',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDIT_OK = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audit successfully',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audit failed',

	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audits by entity id',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audits by entity id successfully',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel audits by entity id failed',

	FETCH_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Fetch all ObstetricAndGynecologyHistoryModel',
	FETCH_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Fetch all ObstetricAndGynecologyHistoryModel successfully',
	FETCH_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Fetch all ObstetricAndGynecologyHistoryModel failed',

	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel with query',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel with query successfully',
	FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch ObstetricAndGynecologyHistoryModel with query failed',

	FETCH_LAST_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY = '[ENTITY] Fetch last ObstetricAndGynecologyHistoryModel with query',
	FETCH_LAST_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last ObstetricAndGynecologyHistoryModel with query successfully',
	FETCH_LAST_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last ObstetricAndGynecologyHistoryModel with query failed',

	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Export ObstetricAndGynecologyHistoryModel',
	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Export ObstetricAndGynecologyHistoryModel successfully',
	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Export ObstetricAndGynecologyHistoryModel failed',

	EXPORT_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY = '[ENTITY] Export All ObstetricAndGynecologyHistoryModels',
	EXPORT_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_OK = '[ENTITY] Export All ObstetricAndGynecologyHistoryModels successfully',
	EXPORT_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY_FAIL = '[ENTITY] Export All ObstetricAndGynecologyHistoryModels failed',

	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS = '[ENTITY] Export ObstetricAndGynecologyHistoryModels excluding Ids',
	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export ObstetricAndGynecologyHistoryModel excluding Ids successfully',
	EXPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export ObstetricAndGynecologyHistoryModel excluding Ids failed',

	COUNT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS = '[ENTITY] Fetch number of ObstetricAndGynecologyHistoryModel records',
	COUNT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS_OK = '[ENTITY] Fetch number of ObstetricAndGynecologyHistoryModel records successfully ',
	COUNT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS_FAIL = '[ENTITY] Fetch number of ObstetricAndGynecologyHistoryModel records failed',

	IMPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS = '[ENTITY] Import ObstetricAndGynecologyHistoryModels',
	IMPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS_OK = '[ENTITY] Import ObstetricAndGynecologyHistoryModels successfully',
	IMPORT_OBSTETRIC_AND_GYNECOLOGY_HISTORYS_FAIL = '[ENTITY] Import ObstetricAndGynecologyHistoryModels fail',


	INITIALISE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ObstetricAndGynecologyHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseObstetricAndGynecologyHistoryAction implements Action {
	readonly className: string = 'ObstetricAndGynecologyHistoryModel';

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

export class ObstetricAndGynecologyHistoryAction extends BaseObstetricAndGynecologyHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryAction here] off begin
	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ObstetricAndGynecologyHistoryModel>,
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryAction here] off begin
	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryAction here] end
}

export class ObstetricAndGynecologyHistoryActionOK extends BaseObstetricAndGynecologyHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ObstetricAndGynecologyHistoryModel>,
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ObstetricAndGynecologyHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryActionOK here] end
}

export class ObstetricAndGynecologyHistoryActionFail extends BaseObstetricAndGynecologyHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for ObstetricAndGynecologyHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ObstetricAndGynecologyHistoryModel>,
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ObstetricAndGynecologyHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ObstetricAndGynecologyHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ObstetricAndGynecologyHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for ObstetricAndGynecologyHistoryActionFail here] end
}

export function isObstetricAndGynecologyHistoryModelAction(e: any): e is BaseObstetricAndGynecologyHistoryAction {
	return Object.values(ObstetricAndGynecologyHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
