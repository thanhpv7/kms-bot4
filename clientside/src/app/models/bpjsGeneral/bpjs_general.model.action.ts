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
import {BpjsGeneralModel} from './bpjs_general.model';
import {BpjsGeneralModelAudit} from './bpjs_general.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS General model actions to be dispatched by NgRx.
 */
export enum BpjsGeneralModelActionTypes {
	CREATE_BPJS_GENERAL = '[ENTITY] Create BpjsGeneralModel',
	CREATE_BPJS_GENERAL_OK = '[ENTITY] Create BpjsGeneralModel successfully',
	CREATE_BPJS_GENERAL_FAIL = '[ENTITY] Create BpjsGeneralModel failed',

	CREATE_ALL_BPJS_GENERAL = '[ENTITY] Create All BpjsGeneralModel',
	CREATE_ALL_BPJS_GENERAL_OK = '[ENTITY] Create All BpjsGeneralModel successfully',
	CREATE_ALL_BPJS_GENERAL_FAIL = '[ENTITY] Create All BpjsGeneralModel failed',

	DELETE_BPJS_GENERAL = '[ENTITY] Delete BpjsGeneralModel',
	DELETE_BPJS_GENERAL_OK = '[ENTITY] Delete BpjsGeneralModel successfully',
	DELETE_BPJS_GENERAL_FAIL = '[ENTITY] Delete BpjsGeneralModel failed',


	DELETE_BPJS_GENERAL_EXCLUDING_IDS = '[ENTITY] Delete BpjsGeneralModels Excluding Ids',
	DELETE_BPJS_GENERAL_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsGeneralModels Excluding Ids successfully',
	DELETE_BPJS_GENERAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsGeneralModels Excluding Ids failed',

	DELETE_ALL_BPJS_GENERAL = '[ENTITY] Delete all BpjsGeneralModels',
	DELETE_ALL_BPJS_GENERAL_OK = '[ENTITY] Delete all BpjsGeneralModels successfully',
	DELETE_ALL_BPJS_GENERAL_FAIL = '[ENTITY] Delete all BpjsGeneralModels failed',

	UPDATE_BPJS_GENERAL = '[ENTITY] Update BpjsGeneralModel',
	UPDATE_BPJS_GENERAL_OK = '[ENTITY] Update BpjsGeneralModel successfully',
	UPDATE_BPJS_GENERAL_FAIL = '[ENTITY] Update BpjsGeneralModel failed',

	UPDATE_ALL_BPJS_GENERAL = '[ENTITY] Update all BpjsGeneralModel',
	UPDATE_ALL_BPJS_GENERAL_OK = '[ENTITY] Update all BpjsGeneralModel successfully',
	UPDATE_ALL_BPJS_GENERAL_FAIL = '[ENTITY] Update all BpjsGeneralModel failed',

	FETCH_BPJS_GENERAL= '[ENTITY] Fetch BpjsGeneralModel',
	FETCH_BPJS_GENERAL_OK = '[ENTITY] Fetch BpjsGeneralModel successfully',
	FETCH_BPJS_GENERAL_FAIL = '[ENTITY] Fetch BpjsGeneralModel failed',

	FETCH_BPJS_GENERAL_AUDIT= '[ENTITY] Fetch BpjsGeneralModel audit',
	FETCH_BPJS_GENERAL_AUDIT_OK = '[ENTITY] Fetch BpjsGeneralModel audit successfully',
	FETCH_BPJS_GENERAL_AUDIT_FAIL = '[ENTITY] Fetch BpjsGeneralModel audit failed',

	FETCH_BPJS_GENERAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsGeneralModel audits by entity id',
	FETCH_BPJS_GENERAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsGeneralModel audits by entity id successfully',
	FETCH_BPJS_GENERAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsGeneralModel audits by entity id failed',

	FETCH_ALL_BPJS_GENERAL = '[ENTITY] Fetch all BpjsGeneralModel',
	FETCH_ALL_BPJS_GENERAL_OK = '[ENTITY] Fetch all BpjsGeneralModel successfully',
	FETCH_ALL_BPJS_GENERAL_FAIL = '[ENTITY] Fetch all BpjsGeneralModel failed',

	FETCH_BPJS_GENERAL_WITH_QUERY = '[ENTITY] Fetch BpjsGeneralModel with query',
	FETCH_BPJS_GENERAL_WITH_QUERY_OK = '[ENTITY] Fetch BpjsGeneralModel with query successfully',
	FETCH_BPJS_GENERAL_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsGeneralModel with query failed',

	FETCH_LAST_BPJS_GENERAL_WITH_QUERY = '[ENTITY] Fetch last BpjsGeneralModel with query',
	FETCH_LAST_BPJS_GENERAL_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsGeneralModel with query successfully',
	FETCH_LAST_BPJS_GENERAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsGeneralModel with query failed',

	EXPORT_BPJS_GENERAL = '[ENTITY] Export BpjsGeneralModel',
	EXPORT_BPJS_GENERAL_OK = '[ENTITY] Export BpjsGeneralModel successfully',
	EXPORT_BPJS_GENERAL_FAIL = '[ENTITY] Export BpjsGeneralModel failed',

	EXPORT_ALL_BPJS_GENERAL = '[ENTITY] Export All BpjsGeneralModels',
	EXPORT_ALL_BPJS_GENERAL_OK = '[ENTITY] Export All BpjsGeneralModels successfully',
	EXPORT_ALL_BPJS_GENERAL_FAIL = '[ENTITY] Export All BpjsGeneralModels failed',

	EXPORT_BPJS_GENERAL_EXCLUDING_IDS = '[ENTITY] Export BpjsGeneralModels excluding Ids',
	EXPORT_BPJS_GENERAL_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsGeneralModel excluding Ids successfully',
	EXPORT_BPJS_GENERAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsGeneralModel excluding Ids failed',

	COUNT_BPJS_GENERALS = '[ENTITY] Fetch number of BpjsGeneralModel records',
	COUNT_BPJS_GENERALS_OK = '[ENTITY] Fetch number of BpjsGeneralModel records successfully ',
	COUNT_BPJS_GENERALS_FAIL = '[ENTITY] Fetch number of BpjsGeneralModel records failed',

	IMPORT_BPJS_GENERALS = '[ENTITY] Import BpjsGeneralModels',
	IMPORT_BPJS_GENERALS_OK = '[ENTITY] Import BpjsGeneralModels successfully',
	IMPORT_BPJS_GENERALS_FAIL = '[ENTITY] Import BpjsGeneralModels fail',


	INITIALISE_BPJS_GENERAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsGeneralModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsGeneralAction implements Action {
	readonly className: string = 'BpjsGeneralModel';

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

export class BpjsGeneralAction extends BaseBpjsGeneralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsGeneralAction here] off begin
	// % protected region % [Add any additional class fields for BpjsGeneralAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsGeneralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsGeneralAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsGeneralAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsGeneralAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsGeneralAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsGeneralAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsGeneralAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsGeneralAction here] off begin
	// % protected region % [Add any additional class methods for BpjsGeneralAction here] end
}

export class BpjsGeneralActionOK extends BaseBpjsGeneralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsGeneralActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsGeneralActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsGeneralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsGeneralActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsGeneralActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsGeneralModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsGeneralActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsGeneralActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsGeneralActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsGeneralActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsGeneralActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsGeneralActionOK here] end
}

export class BpjsGeneralActionFail extends BaseBpjsGeneralAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsGeneralActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsGeneralActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsGeneralModel>,
		// % protected region % [Add any additional constructor parameters for BpjsGeneralActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsGeneralActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsGeneralActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsGeneralActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsGeneralActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsGeneralActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsGeneralActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsGeneralActionFail here] end
}

export function isBpjsGeneralModelAction(e: any): e is BaseBpjsGeneralAction {
	return Object.values(BpjsGeneralModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
