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
import {BpjsProcedureModel} from './bpjs_procedure.model';
import {BpjsProcedureModelAudit} from './bpjs_procedure.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Procedure model actions to be dispatched by NgRx.
 */
export enum BpjsProcedureModelActionTypes {
	CREATE_BPJS_PROCEDURE = '[ENTITY] Create BpjsProcedureModel',
	CREATE_BPJS_PROCEDURE_OK = '[ENTITY] Create BpjsProcedureModel successfully',
	CREATE_BPJS_PROCEDURE_FAIL = '[ENTITY] Create BpjsProcedureModel failed',

	CREATE_ALL_BPJS_PROCEDURE = '[ENTITY] Create All BpjsProcedureModel',
	CREATE_ALL_BPJS_PROCEDURE_OK = '[ENTITY] Create All BpjsProcedureModel successfully',
	CREATE_ALL_BPJS_PROCEDURE_FAIL = '[ENTITY] Create All BpjsProcedureModel failed',

	DELETE_BPJS_PROCEDURE = '[ENTITY] Delete BpjsProcedureModel',
	DELETE_BPJS_PROCEDURE_OK = '[ENTITY] Delete BpjsProcedureModel successfully',
	DELETE_BPJS_PROCEDURE_FAIL = '[ENTITY] Delete BpjsProcedureModel failed',


	DELETE_BPJS_PROCEDURE_EXCLUDING_IDS = '[ENTITY] Delete BpjsProcedureModels Excluding Ids',
	DELETE_BPJS_PROCEDURE_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsProcedureModels Excluding Ids successfully',
	DELETE_BPJS_PROCEDURE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsProcedureModels Excluding Ids failed',

	DELETE_ALL_BPJS_PROCEDURE = '[ENTITY] Delete all BpjsProcedureModels',
	DELETE_ALL_BPJS_PROCEDURE_OK = '[ENTITY] Delete all BpjsProcedureModels successfully',
	DELETE_ALL_BPJS_PROCEDURE_FAIL = '[ENTITY] Delete all BpjsProcedureModels failed',

	UPDATE_BPJS_PROCEDURE = '[ENTITY] Update BpjsProcedureModel',
	UPDATE_BPJS_PROCEDURE_OK = '[ENTITY] Update BpjsProcedureModel successfully',
	UPDATE_BPJS_PROCEDURE_FAIL = '[ENTITY] Update BpjsProcedureModel failed',

	UPDATE_ALL_BPJS_PROCEDURE = '[ENTITY] Update all BpjsProcedureModel',
	UPDATE_ALL_BPJS_PROCEDURE_OK = '[ENTITY] Update all BpjsProcedureModel successfully',
	UPDATE_ALL_BPJS_PROCEDURE_FAIL = '[ENTITY] Update all BpjsProcedureModel failed',

	FETCH_BPJS_PROCEDURE= '[ENTITY] Fetch BpjsProcedureModel',
	FETCH_BPJS_PROCEDURE_OK = '[ENTITY] Fetch BpjsProcedureModel successfully',
	FETCH_BPJS_PROCEDURE_FAIL = '[ENTITY] Fetch BpjsProcedureModel failed',

	FETCH_BPJS_PROCEDURE_AUDIT= '[ENTITY] Fetch BpjsProcedureModel audit',
	FETCH_BPJS_PROCEDURE_AUDIT_OK = '[ENTITY] Fetch BpjsProcedureModel audit successfully',
	FETCH_BPJS_PROCEDURE_AUDIT_FAIL = '[ENTITY] Fetch BpjsProcedureModel audit failed',

	FETCH_BPJS_PROCEDURE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsProcedureModel audits by entity id',
	FETCH_BPJS_PROCEDURE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsProcedureModel audits by entity id successfully',
	FETCH_BPJS_PROCEDURE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsProcedureModel audits by entity id failed',

	FETCH_ALL_BPJS_PROCEDURE = '[ENTITY] Fetch all BpjsProcedureModel',
	FETCH_ALL_BPJS_PROCEDURE_OK = '[ENTITY] Fetch all BpjsProcedureModel successfully',
	FETCH_ALL_BPJS_PROCEDURE_FAIL = '[ENTITY] Fetch all BpjsProcedureModel failed',

	FETCH_BPJS_PROCEDURE_WITH_QUERY = '[ENTITY] Fetch BpjsProcedureModel with query',
	FETCH_BPJS_PROCEDURE_WITH_QUERY_OK = '[ENTITY] Fetch BpjsProcedureModel with query successfully',
	FETCH_BPJS_PROCEDURE_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsProcedureModel with query failed',

	FETCH_LAST_BPJS_PROCEDURE_WITH_QUERY = '[ENTITY] Fetch last BpjsProcedureModel with query',
	FETCH_LAST_BPJS_PROCEDURE_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsProcedureModel with query successfully',
	FETCH_LAST_BPJS_PROCEDURE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsProcedureModel with query failed',

	EXPORT_BPJS_PROCEDURE = '[ENTITY] Export BpjsProcedureModel',
	EXPORT_BPJS_PROCEDURE_OK = '[ENTITY] Export BpjsProcedureModel successfully',
	EXPORT_BPJS_PROCEDURE_FAIL = '[ENTITY] Export BpjsProcedureModel failed',

	EXPORT_ALL_BPJS_PROCEDURE = '[ENTITY] Export All BpjsProcedureModels',
	EXPORT_ALL_BPJS_PROCEDURE_OK = '[ENTITY] Export All BpjsProcedureModels successfully',
	EXPORT_ALL_BPJS_PROCEDURE_FAIL = '[ENTITY] Export All BpjsProcedureModels failed',

	EXPORT_BPJS_PROCEDURE_EXCLUDING_IDS = '[ENTITY] Export BpjsProcedureModels excluding Ids',
	EXPORT_BPJS_PROCEDURE_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsProcedureModel excluding Ids successfully',
	EXPORT_BPJS_PROCEDURE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsProcedureModel excluding Ids failed',

	COUNT_BPJS_PROCEDURES = '[ENTITY] Fetch number of BpjsProcedureModel records',
	COUNT_BPJS_PROCEDURES_OK = '[ENTITY] Fetch number of BpjsProcedureModel records successfully ',
	COUNT_BPJS_PROCEDURES_FAIL = '[ENTITY] Fetch number of BpjsProcedureModel records failed',

	IMPORT_BPJS_PROCEDURES = '[ENTITY] Import BpjsProcedureModels',
	IMPORT_BPJS_PROCEDURES_OK = '[ENTITY] Import BpjsProcedureModels successfully',
	IMPORT_BPJS_PROCEDURES_FAIL = '[ENTITY] Import BpjsProcedureModels fail',


	INITIALISE_BPJS_PROCEDURE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsProcedureModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsProcedureAction implements Action {
	readonly className: string = 'BpjsProcedureModel';

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

export class BpjsProcedureAction extends BaseBpjsProcedureAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsProcedureAction here] off begin
	// % protected region % [Add any additional class fields for BpjsProcedureAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsProcedureModel>,
		// % protected region % [Add any additional constructor parameters for BpjsProcedureAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsProcedureAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsProcedureAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsProcedureAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsProcedureAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsProcedureAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsProcedureAction here] off begin
	// % protected region % [Add any additional class methods for BpjsProcedureAction here] end
}

export class BpjsProcedureActionOK extends BaseBpjsProcedureAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsProcedureActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsProcedureActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsProcedureModel>,
		// % protected region % [Add any additional constructor parameters for BpjsProcedureActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsProcedureActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsProcedureModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsProcedureActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsProcedureActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsProcedureActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsProcedureActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsProcedureActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsProcedureActionOK here] end
}

export class BpjsProcedureActionFail extends BaseBpjsProcedureAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsProcedureActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsProcedureActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsProcedureModel>,
		// % protected region % [Add any additional constructor parameters for BpjsProcedureActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsProcedureActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsProcedureActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsProcedureActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsProcedureActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsProcedureActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsProcedureActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsProcedureActionFail here] end
}

export function isBpjsProcedureModelAction(e: any): e is BaseBpjsProcedureAction {
	return Object.values(BpjsProcedureModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
