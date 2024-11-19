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
import {BpjsDiagnoseModel} from './bpjs_diagnose.model';
import {BpjsDiagnoseModelAudit} from './bpjs_diagnose.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Diagnose model actions to be dispatched by NgRx.
 */
export enum BpjsDiagnoseModelActionTypes {
	CREATE_BPJS_DIAGNOSE = '[ENTITY] Create BpjsDiagnoseModel',
	CREATE_BPJS_DIAGNOSE_OK = '[ENTITY] Create BpjsDiagnoseModel successfully',
	CREATE_BPJS_DIAGNOSE_FAIL = '[ENTITY] Create BpjsDiagnoseModel failed',

	CREATE_ALL_BPJS_DIAGNOSE = '[ENTITY] Create All BpjsDiagnoseModel',
	CREATE_ALL_BPJS_DIAGNOSE_OK = '[ENTITY] Create All BpjsDiagnoseModel successfully',
	CREATE_ALL_BPJS_DIAGNOSE_FAIL = '[ENTITY] Create All BpjsDiagnoseModel failed',

	DELETE_BPJS_DIAGNOSE = '[ENTITY] Delete BpjsDiagnoseModel',
	DELETE_BPJS_DIAGNOSE_OK = '[ENTITY] Delete BpjsDiagnoseModel successfully',
	DELETE_BPJS_DIAGNOSE_FAIL = '[ENTITY] Delete BpjsDiagnoseModel failed',


	DELETE_BPJS_DIAGNOSE_EXCLUDING_IDS = '[ENTITY] Delete BpjsDiagnoseModels Excluding Ids',
	DELETE_BPJS_DIAGNOSE_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDiagnoseModels Excluding Ids successfully',
	DELETE_BPJS_DIAGNOSE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDiagnoseModels Excluding Ids failed',

	DELETE_ALL_BPJS_DIAGNOSE = '[ENTITY] Delete all BpjsDiagnoseModels',
	DELETE_ALL_BPJS_DIAGNOSE_OK = '[ENTITY] Delete all BpjsDiagnoseModels successfully',
	DELETE_ALL_BPJS_DIAGNOSE_FAIL = '[ENTITY] Delete all BpjsDiagnoseModels failed',

	UPDATE_BPJS_DIAGNOSE = '[ENTITY] Update BpjsDiagnoseModel',
	UPDATE_BPJS_DIAGNOSE_OK = '[ENTITY] Update BpjsDiagnoseModel successfully',
	UPDATE_BPJS_DIAGNOSE_FAIL = '[ENTITY] Update BpjsDiagnoseModel failed',

	UPDATE_ALL_BPJS_DIAGNOSE = '[ENTITY] Update all BpjsDiagnoseModel',
	UPDATE_ALL_BPJS_DIAGNOSE_OK = '[ENTITY] Update all BpjsDiagnoseModel successfully',
	UPDATE_ALL_BPJS_DIAGNOSE_FAIL = '[ENTITY] Update all BpjsDiagnoseModel failed',

	FETCH_BPJS_DIAGNOSE= '[ENTITY] Fetch BpjsDiagnoseModel',
	FETCH_BPJS_DIAGNOSE_OK = '[ENTITY] Fetch BpjsDiagnoseModel successfully',
	FETCH_BPJS_DIAGNOSE_FAIL = '[ENTITY] Fetch BpjsDiagnoseModel failed',

	FETCH_BPJS_DIAGNOSE_AUDIT= '[ENTITY] Fetch BpjsDiagnoseModel audit',
	FETCH_BPJS_DIAGNOSE_AUDIT_OK = '[ENTITY] Fetch BpjsDiagnoseModel audit successfully',
	FETCH_BPJS_DIAGNOSE_AUDIT_FAIL = '[ENTITY] Fetch BpjsDiagnoseModel audit failed',

	FETCH_BPJS_DIAGNOSE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDiagnoseModel audits by entity id',
	FETCH_BPJS_DIAGNOSE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDiagnoseModel audits by entity id successfully',
	FETCH_BPJS_DIAGNOSE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDiagnoseModel audits by entity id failed',

	FETCH_ALL_BPJS_DIAGNOSE = '[ENTITY] Fetch all BpjsDiagnoseModel',
	FETCH_ALL_BPJS_DIAGNOSE_OK = '[ENTITY] Fetch all BpjsDiagnoseModel successfully',
	FETCH_ALL_BPJS_DIAGNOSE_FAIL = '[ENTITY] Fetch all BpjsDiagnoseModel failed',

	FETCH_BPJS_DIAGNOSE_WITH_QUERY = '[ENTITY] Fetch BpjsDiagnoseModel with query',
	FETCH_BPJS_DIAGNOSE_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDiagnoseModel with query successfully',
	FETCH_BPJS_DIAGNOSE_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDiagnoseModel with query failed',

	FETCH_LAST_BPJS_DIAGNOSE_WITH_QUERY = '[ENTITY] Fetch last BpjsDiagnoseModel with query',
	FETCH_LAST_BPJS_DIAGNOSE_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDiagnoseModel with query successfully',
	FETCH_LAST_BPJS_DIAGNOSE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDiagnoseModel with query failed',

	EXPORT_BPJS_DIAGNOSE = '[ENTITY] Export BpjsDiagnoseModel',
	EXPORT_BPJS_DIAGNOSE_OK = '[ENTITY] Export BpjsDiagnoseModel successfully',
	EXPORT_BPJS_DIAGNOSE_FAIL = '[ENTITY] Export BpjsDiagnoseModel failed',

	EXPORT_ALL_BPJS_DIAGNOSE = '[ENTITY] Export All BpjsDiagnoseModels',
	EXPORT_ALL_BPJS_DIAGNOSE_OK = '[ENTITY] Export All BpjsDiagnoseModels successfully',
	EXPORT_ALL_BPJS_DIAGNOSE_FAIL = '[ENTITY] Export All BpjsDiagnoseModels failed',

	EXPORT_BPJS_DIAGNOSE_EXCLUDING_IDS = '[ENTITY] Export BpjsDiagnoseModels excluding Ids',
	EXPORT_BPJS_DIAGNOSE_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDiagnoseModel excluding Ids successfully',
	EXPORT_BPJS_DIAGNOSE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDiagnoseModel excluding Ids failed',

	COUNT_BPJS_DIAGNOSES = '[ENTITY] Fetch number of BpjsDiagnoseModel records',
	COUNT_BPJS_DIAGNOSES_OK = '[ENTITY] Fetch number of BpjsDiagnoseModel records successfully ',
	COUNT_BPJS_DIAGNOSES_FAIL = '[ENTITY] Fetch number of BpjsDiagnoseModel records failed',

	IMPORT_BPJS_DIAGNOSES = '[ENTITY] Import BpjsDiagnoseModels',
	IMPORT_BPJS_DIAGNOSES_OK = '[ENTITY] Import BpjsDiagnoseModels successfully',
	IMPORT_BPJS_DIAGNOSES_FAIL = '[ENTITY] Import BpjsDiagnoseModels fail',


	INITIALISE_BPJS_DIAGNOSE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDiagnoseModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDiagnoseAction implements Action {
	readonly className: string = 'BpjsDiagnoseModel';

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

export class BpjsDiagnoseAction extends BaseBpjsDiagnoseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnoseAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnoseAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDiagnoseModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnoseAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnoseAction here] end
}

export class BpjsDiagnoseActionOK extends BaseBpjsDiagnoseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnoseActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnoseActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDiagnoseModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDiagnoseModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnoseActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnoseActionOK here] end
}

export class BpjsDiagnoseActionFail extends BaseBpjsDiagnoseAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDiagnoseActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDiagnoseActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDiagnoseModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDiagnoseActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDiagnoseActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDiagnoseActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDiagnoseActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDiagnoseActionFail here] end
}

export function isBpjsDiagnoseModelAction(e: any): e is BaseBpjsDiagnoseAction {
	return Object.values(BpjsDiagnoseModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
