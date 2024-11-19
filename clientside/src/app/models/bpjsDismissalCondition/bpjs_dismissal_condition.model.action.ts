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
import {BpjsDismissalConditionModel} from './bpjs_dismissal_condition.model';
import {BpjsDismissalConditionModelAudit} from './bpjs_dismissal_condition.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Dismissal Condition model actions to be dispatched by NgRx.
 */
export enum BpjsDismissalConditionModelActionTypes {
	CREATE_BPJS_DISMISSAL_CONDITION = '[ENTITY] Create BpjsDismissalConditionModel',
	CREATE_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Create BpjsDismissalConditionModel successfully',
	CREATE_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Create BpjsDismissalConditionModel failed',

	CREATE_ALL_BPJS_DISMISSAL_CONDITION = '[ENTITY] Create All BpjsDismissalConditionModel',
	CREATE_ALL_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Create All BpjsDismissalConditionModel successfully',
	CREATE_ALL_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Create All BpjsDismissalConditionModel failed',

	DELETE_BPJS_DISMISSAL_CONDITION = '[ENTITY] Delete BpjsDismissalConditionModel',
	DELETE_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Delete BpjsDismissalConditionModel successfully',
	DELETE_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Delete BpjsDismissalConditionModel failed',


	DELETE_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS = '[ENTITY] Delete BpjsDismissalConditionModels Excluding Ids',
	DELETE_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDismissalConditionModels Excluding Ids successfully',
	DELETE_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDismissalConditionModels Excluding Ids failed',

	DELETE_ALL_BPJS_DISMISSAL_CONDITION = '[ENTITY] Delete all BpjsDismissalConditionModels',
	DELETE_ALL_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Delete all BpjsDismissalConditionModels successfully',
	DELETE_ALL_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Delete all BpjsDismissalConditionModels failed',

	UPDATE_BPJS_DISMISSAL_CONDITION = '[ENTITY] Update BpjsDismissalConditionModel',
	UPDATE_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Update BpjsDismissalConditionModel successfully',
	UPDATE_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Update BpjsDismissalConditionModel failed',

	UPDATE_ALL_BPJS_DISMISSAL_CONDITION = '[ENTITY] Update all BpjsDismissalConditionModel',
	UPDATE_ALL_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Update all BpjsDismissalConditionModel successfully',
	UPDATE_ALL_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Update all BpjsDismissalConditionModel failed',

	FETCH_BPJS_DISMISSAL_CONDITION= '[ENTITY] Fetch BpjsDismissalConditionModel',
	FETCH_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Fetch BpjsDismissalConditionModel successfully',
	FETCH_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Fetch BpjsDismissalConditionModel failed',

	FETCH_BPJS_DISMISSAL_CONDITION_AUDIT= '[ENTITY] Fetch BpjsDismissalConditionModel audit',
	FETCH_BPJS_DISMISSAL_CONDITION_AUDIT_OK = '[ENTITY] Fetch BpjsDismissalConditionModel audit successfully',
	FETCH_BPJS_DISMISSAL_CONDITION_AUDIT_FAIL = '[ENTITY] Fetch BpjsDismissalConditionModel audit failed',

	FETCH_BPJS_DISMISSAL_CONDITION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDismissalConditionModel audits by entity id',
	FETCH_BPJS_DISMISSAL_CONDITION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDismissalConditionModel audits by entity id successfully',
	FETCH_BPJS_DISMISSAL_CONDITION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDismissalConditionModel audits by entity id failed',

	FETCH_ALL_BPJS_DISMISSAL_CONDITION = '[ENTITY] Fetch all BpjsDismissalConditionModel',
	FETCH_ALL_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Fetch all BpjsDismissalConditionModel successfully',
	FETCH_ALL_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Fetch all BpjsDismissalConditionModel failed',

	FETCH_BPJS_DISMISSAL_CONDITION_WITH_QUERY = '[ENTITY] Fetch BpjsDismissalConditionModel with query',
	FETCH_BPJS_DISMISSAL_CONDITION_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDismissalConditionModel with query successfully',
	FETCH_BPJS_DISMISSAL_CONDITION_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDismissalConditionModel with query failed',

	FETCH_LAST_BPJS_DISMISSAL_CONDITION_WITH_QUERY = '[ENTITY] Fetch last BpjsDismissalConditionModel with query',
	FETCH_LAST_BPJS_DISMISSAL_CONDITION_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDismissalConditionModel with query successfully',
	FETCH_LAST_BPJS_DISMISSAL_CONDITION_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDismissalConditionModel with query failed',

	EXPORT_BPJS_DISMISSAL_CONDITION = '[ENTITY] Export BpjsDismissalConditionModel',
	EXPORT_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Export BpjsDismissalConditionModel successfully',
	EXPORT_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Export BpjsDismissalConditionModel failed',

	EXPORT_ALL_BPJS_DISMISSAL_CONDITION = '[ENTITY] Export All BpjsDismissalConditionModels',
	EXPORT_ALL_BPJS_DISMISSAL_CONDITION_OK = '[ENTITY] Export All BpjsDismissalConditionModels successfully',
	EXPORT_ALL_BPJS_DISMISSAL_CONDITION_FAIL = '[ENTITY] Export All BpjsDismissalConditionModels failed',

	EXPORT_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS = '[ENTITY] Export BpjsDismissalConditionModels excluding Ids',
	EXPORT_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDismissalConditionModel excluding Ids successfully',
	EXPORT_BPJS_DISMISSAL_CONDITION_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDismissalConditionModel excluding Ids failed',

	COUNT_BPJS_DISMISSAL_CONDITIONS = '[ENTITY] Fetch number of BpjsDismissalConditionModel records',
	COUNT_BPJS_DISMISSAL_CONDITIONS_OK = '[ENTITY] Fetch number of BpjsDismissalConditionModel records successfully ',
	COUNT_BPJS_DISMISSAL_CONDITIONS_FAIL = '[ENTITY] Fetch number of BpjsDismissalConditionModel records failed',

	IMPORT_BPJS_DISMISSAL_CONDITIONS = '[ENTITY] Import BpjsDismissalConditionModels',
	IMPORT_BPJS_DISMISSAL_CONDITIONS_OK = '[ENTITY] Import BpjsDismissalConditionModels successfully',
	IMPORT_BPJS_DISMISSAL_CONDITIONS_FAIL = '[ENTITY] Import BpjsDismissalConditionModels fail',


	INITIALISE_BPJS_DISMISSAL_CONDITION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDismissalConditionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDismissalConditionAction implements Action {
	readonly className: string = 'BpjsDismissalConditionModel';

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

export class BpjsDismissalConditionAction extends BaseBpjsDismissalConditionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalConditionAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalConditionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDismissalConditionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalConditionAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalConditionAction here] end
}

export class BpjsDismissalConditionActionOK extends BaseBpjsDismissalConditionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalConditionActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalConditionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDismissalConditionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDismissalConditionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalConditionActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalConditionActionOK here] end
}

export class BpjsDismissalConditionActionFail extends BaseBpjsDismissalConditionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDismissalConditionActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDismissalConditionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDismissalConditionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDismissalConditionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDismissalConditionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDismissalConditionActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDismissalConditionActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDismissalConditionActionFail here] end
}

export function isBpjsDismissalConditionModelAction(e: any): e is BaseBpjsDismissalConditionAction {
	return Object.values(BpjsDismissalConditionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
