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
import {BpjsDiagnosePRBModel} from './bpjs_diagnose_prb.model';
import {BpjsDiagnosePRBModelAudit} from './bpjs_diagnose_prb.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Diagnose PRB model actions to be dispatched by NgRx.
 */
export enum BpjsDiagnosePRBModelActionTypes {
	CREATE_BPJS_DIAGNOSE_PRB = '[ENTITY] Create BpjsDiagnosePRBModel',
	CREATE_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Create BpjsDiagnosePRBModel successfully',
	CREATE_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Create BpjsDiagnosePRBModel failed',

	CREATE_ALL_BPJS_DIAGNOSE_PRB = '[ENTITY] Create All BpjsDiagnosePRBModel',
	CREATE_ALL_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Create All BpjsDiagnosePRBModel successfully',
	CREATE_ALL_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Create All BpjsDiagnosePRBModel failed',

	DELETE_BPJS_DIAGNOSE_PRB = '[ENTITY] Delete BpjsDiagnosePRBModel',
	DELETE_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Delete BpjsDiagnosePRBModel successfully',
	DELETE_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Delete BpjsDiagnosePRBModel failed',


	DELETE_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS = '[ENTITY] Delete BpjsDiagnosePRBModels Excluding Ids',
	DELETE_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDiagnosePRBModels Excluding Ids successfully',
	DELETE_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDiagnosePRBModels Excluding Ids failed',

	DELETE_ALL_BPJS_DIAGNOSE_PRB = '[ENTITY] Delete all BpjsDiagnosePRBModels',
	DELETE_ALL_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Delete all BpjsDiagnosePRBModels successfully',
	DELETE_ALL_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Delete all BpjsDiagnosePRBModels failed',

	UPDATE_BPJS_DIAGNOSE_PRB = '[ENTITY] Update BpjsDiagnosePRBModel',
	UPDATE_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Update BpjsDiagnosePRBModel successfully',
	UPDATE_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Update BpjsDiagnosePRBModel failed',

	UPDATE_ALL_BPJS_DIAGNOSE_PRB = '[ENTITY] Update all BpjsDiagnosePRBModel',
	UPDATE_ALL_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Update all BpjsDiagnosePRBModel successfully',
	UPDATE_ALL_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Update all BpjsDiagnosePRBModel failed',

	FETCH_BPJS_DIAGNOSE_PRB= '[ENTITY] Fetch BpjsDiagnosePRBModel',
	FETCH_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Fetch BpjsDiagnosePRBModel successfully',
	FETCH_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Fetch BpjsDiagnosePRBModel failed',

	FETCH_BPJS_DIAGNOSE_PRB_AUDIT= '[ENTITY] Fetch BpjsDiagnosePRBModel audit',
	FETCH_BPJS_DIAGNOSE_PRB_AUDIT_OK = '[ENTITY] Fetch BpjsDiagnosePRBModel audit successfully',
	FETCH_BPJS_DIAGNOSE_PRB_AUDIT_FAIL = '[ENTITY] Fetch BpjsDiagnosePRBModel audit failed',

	FETCH_BPJS_DIAGNOSE_PRB_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDiagnosePRBModel audits by entity id',
	FETCH_BPJS_DIAGNOSE_PRB_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDiagnosePRBModel audits by entity id successfully',
	FETCH_BPJS_DIAGNOSE_PRB_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDiagnosePRBModel audits by entity id failed',

	FETCH_ALL_BPJS_DIAGNOSE_PRB = '[ENTITY] Fetch all BpjsDiagnosePRBModel',
	FETCH_ALL_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Fetch all BpjsDiagnosePRBModel successfully',
	FETCH_ALL_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Fetch all BpjsDiagnosePRBModel failed',

	FETCH_BPJS_DIAGNOSE_PRB_WITH_QUERY = '[ENTITY] Fetch BpjsDiagnosePRBModel with query',
	FETCH_BPJS_DIAGNOSE_PRB_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDiagnosePRBModel with query successfully',
	FETCH_BPJS_DIAGNOSE_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDiagnosePRBModel with query failed',

	FETCH_LAST_BPJS_DIAGNOSE_PRB_WITH_QUERY = '[ENTITY] Fetch last BpjsDiagnosePRBModel with query',
	FETCH_LAST_BPJS_DIAGNOSE_PRB_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDiagnosePRBModel with query successfully',
	FETCH_LAST_BPJS_DIAGNOSE_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDiagnosePRBModel with query failed',

	EXPORT_BPJS_DIAGNOSE_PRB = '[ENTITY] Export BpjsDiagnosePRBModel',
	EXPORT_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Export BpjsDiagnosePRBModel successfully',
	EXPORT_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Export BpjsDiagnosePRBModel failed',

	EXPORT_ALL_BPJS_DIAGNOSE_PRB = '[ENTITY] Export All BpjsDiagnosePRBModels',
	EXPORT_ALL_BPJS_DIAGNOSE_PRB_OK = '[ENTITY] Export All BpjsDiagnosePRBModels successfully',
	EXPORT_ALL_BPJS_DIAGNOSE_PRB_FAIL = '[ENTITY] Export All BpjsDiagnosePRBModels failed',

	EXPORT_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS = '[ENTITY] Export BpjsDiagnosePRBModels excluding Ids',
	EXPORT_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDiagnosePRBModel excluding Ids successfully',
	EXPORT_BPJS_DIAGNOSE_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDiagnosePRBModel excluding Ids failed',

	COUNT_BPJS_DIAGNOSE_PRBS = '[ENTITY] Fetch number of BpjsDiagnosePRBModel records',
	COUNT_BPJS_DIAGNOSE_PRBS_OK = '[ENTITY] Fetch number of BpjsDiagnosePRBModel records successfully ',
	COUNT_BPJS_DIAGNOSE_PRBS_FAIL = '[ENTITY] Fetch number of BpjsDiagnosePRBModel records failed',

	IMPORT_BPJS_DIAGNOSE_PRBS = '[ENTITY] Import BpjsDiagnosePRBModels',
	IMPORT_BPJS_DIAGNOSE_PRBS_OK = '[ENTITY] Import BpjsDiagnosePRBModels successfully',
	IMPORT_BPJS_DIAGNOSE_PRBS_FAIL = '[ENTITY] Import BpjsDiagnosePRBModels fail',


	INITIALISE_BPJS_DIAGNOSE_PRB_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDiagnosePRBModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDiagnosePRBAction implements Action {
	readonly className: string = 'BpjsDiagnosePRBModel';

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

export class BpjsDiagnosePRBAction extends BaseBpjsDiagnosePRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnosePRBAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnosePRBAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDiagnosePRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnosePRBAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnosePRBAction here] end
}

export class BpjsDiagnosePRBActionOK extends BaseBpjsDiagnosePRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnosePRBActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnosePRBActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDiagnosePRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDiagnosePRBModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnosePRBActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnosePRBActionOK here] end
}

export class BpjsDiagnosePRBActionFail extends BaseBpjsDiagnosePRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnosePRBActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnosePRBActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDiagnosePRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnosePRBActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnosePRBActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnosePRBActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnosePRBActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnosePRBActionFail here] end
}

export function isBpjsDiagnosePRBModelAction(e: any): e is BaseBpjsDiagnosePRBAction {
	return Object.values(BpjsDiagnosePRBModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
