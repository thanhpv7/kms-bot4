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
import {BpjsINACBGVariableModel} from './bpjs_inacbg_variable.model';
import {BpjsINACBGVariableModelAudit} from './bpjs_inacbg_variable.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS INACBG Variable model actions to be dispatched by NgRx.
 */
export enum BpjsINACBGVariableModelActionTypes {
	CREATE_BPJS_INACBG_VARIABLE = '[ENTITY] Create BpjsINACBGVariableModel',
	CREATE_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Create BpjsINACBGVariableModel successfully',
	CREATE_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Create BpjsINACBGVariableModel failed',

	CREATE_ALL_BPJS_INACBG_VARIABLE = '[ENTITY] Create All BpjsINACBGVariableModel',
	CREATE_ALL_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Create All BpjsINACBGVariableModel successfully',
	CREATE_ALL_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Create All BpjsINACBGVariableModel failed',

	DELETE_BPJS_INACBG_VARIABLE = '[ENTITY] Delete BpjsINACBGVariableModel',
	DELETE_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Delete BpjsINACBGVariableModel successfully',
	DELETE_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Delete BpjsINACBGVariableModel failed',


	DELETE_BPJS_INACBG_VARIABLE_EXCLUDING_IDS = '[ENTITY] Delete BpjsINACBGVariableModels Excluding Ids',
	DELETE_BPJS_INACBG_VARIABLE_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsINACBGVariableModels Excluding Ids successfully',
	DELETE_BPJS_INACBG_VARIABLE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsINACBGVariableModels Excluding Ids failed',

	DELETE_ALL_BPJS_INACBG_VARIABLE = '[ENTITY] Delete all BpjsINACBGVariableModels',
	DELETE_ALL_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Delete all BpjsINACBGVariableModels successfully',
	DELETE_ALL_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Delete all BpjsINACBGVariableModels failed',

	UPDATE_BPJS_INACBG_VARIABLE = '[ENTITY] Update BpjsINACBGVariableModel',
	UPDATE_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Update BpjsINACBGVariableModel successfully',
	UPDATE_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Update BpjsINACBGVariableModel failed',

	UPDATE_ALL_BPJS_INACBG_VARIABLE = '[ENTITY] Update all BpjsINACBGVariableModel',
	UPDATE_ALL_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Update all BpjsINACBGVariableModel successfully',
	UPDATE_ALL_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Update all BpjsINACBGVariableModel failed',

	FETCH_BPJS_INACBG_VARIABLE= '[ENTITY] Fetch BpjsINACBGVariableModel',
	FETCH_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Fetch BpjsINACBGVariableModel successfully',
	FETCH_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Fetch BpjsINACBGVariableModel failed',

	FETCH_BPJS_INACBG_VARIABLE_AUDIT= '[ENTITY] Fetch BpjsINACBGVariableModel audit',
	FETCH_BPJS_INACBG_VARIABLE_AUDIT_OK = '[ENTITY] Fetch BpjsINACBGVariableModel audit successfully',
	FETCH_BPJS_INACBG_VARIABLE_AUDIT_FAIL = '[ENTITY] Fetch BpjsINACBGVariableModel audit failed',

	FETCH_BPJS_INACBG_VARIABLE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsINACBGVariableModel audits by entity id',
	FETCH_BPJS_INACBG_VARIABLE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsINACBGVariableModel audits by entity id successfully',
	FETCH_BPJS_INACBG_VARIABLE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsINACBGVariableModel audits by entity id failed',

	FETCH_ALL_BPJS_INACBG_VARIABLE = '[ENTITY] Fetch all BpjsINACBGVariableModel',
	FETCH_ALL_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Fetch all BpjsINACBGVariableModel successfully',
	FETCH_ALL_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Fetch all BpjsINACBGVariableModel failed',

	FETCH_BPJS_INACBG_VARIABLE_WITH_QUERY = '[ENTITY] Fetch BpjsINACBGVariableModel with query',
	FETCH_BPJS_INACBG_VARIABLE_WITH_QUERY_OK = '[ENTITY] Fetch BpjsINACBGVariableModel with query successfully',
	FETCH_BPJS_INACBG_VARIABLE_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsINACBGVariableModel with query failed',

	FETCH_LAST_BPJS_INACBG_VARIABLE_WITH_QUERY = '[ENTITY] Fetch last BpjsINACBGVariableModel with query',
	FETCH_LAST_BPJS_INACBG_VARIABLE_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsINACBGVariableModel with query successfully',
	FETCH_LAST_BPJS_INACBG_VARIABLE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsINACBGVariableModel with query failed',

	EXPORT_BPJS_INACBG_VARIABLE = '[ENTITY] Export BpjsINACBGVariableModel',
	EXPORT_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Export BpjsINACBGVariableModel successfully',
	EXPORT_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Export BpjsINACBGVariableModel failed',

	EXPORT_ALL_BPJS_INACBG_VARIABLE = '[ENTITY] Export All BpjsINACBGVariableModels',
	EXPORT_ALL_BPJS_INACBG_VARIABLE_OK = '[ENTITY] Export All BpjsINACBGVariableModels successfully',
	EXPORT_ALL_BPJS_INACBG_VARIABLE_FAIL = '[ENTITY] Export All BpjsINACBGVariableModels failed',

	EXPORT_BPJS_INACBG_VARIABLE_EXCLUDING_IDS = '[ENTITY] Export BpjsINACBGVariableModels excluding Ids',
	EXPORT_BPJS_INACBG_VARIABLE_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsINACBGVariableModel excluding Ids successfully',
	EXPORT_BPJS_INACBG_VARIABLE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsINACBGVariableModel excluding Ids failed',

	COUNT_BPJS_INACBG_VARIABLES = '[ENTITY] Fetch number of BpjsINACBGVariableModel records',
	COUNT_BPJS_INACBG_VARIABLES_OK = '[ENTITY] Fetch number of BpjsINACBGVariableModel records successfully ',
	COUNT_BPJS_INACBG_VARIABLES_FAIL = '[ENTITY] Fetch number of BpjsINACBGVariableModel records failed',

	IMPORT_BPJS_INACBG_VARIABLES = '[ENTITY] Import BpjsINACBGVariableModels',
	IMPORT_BPJS_INACBG_VARIABLES_OK = '[ENTITY] Import BpjsINACBGVariableModels successfully',
	IMPORT_BPJS_INACBG_VARIABLES_FAIL = '[ENTITY] Import BpjsINACBGVariableModels fail',


	INITIALISE_BPJS_INACBG_VARIABLE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsINACBGVariableModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsINACBGVariableAction implements Action {
	readonly className: string = 'BpjsINACBGVariableModel';

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

export class BpjsINACBGVariableAction extends BaseBpjsINACBGVariableAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGVariableAction here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGVariableAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGVariableModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGVariableAction here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGVariableAction here] end
}

export class BpjsINACBGVariableActionOK extends BaseBpjsINACBGVariableAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGVariableActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGVariableActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsINACBGVariableModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsINACBGVariableModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGVariableActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGVariableActionOK here] end
}

export class BpjsINACBGVariableActionFail extends BaseBpjsINACBGVariableAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsINACBGVariableActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsINACBGVariableActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsINACBGVariableModel>,
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsINACBGVariableActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsINACBGVariableActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsINACBGVariableActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsINACBGVariableActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsINACBGVariableActionFail here] end
}

export function isBpjsINACBGVariableModelAction(e: any): e is BaseBpjsINACBGVariableAction {
	return Object.values(BpjsINACBGVariableModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
