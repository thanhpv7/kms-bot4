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
import {BpjsPcarePoliModel} from './bpjs_pcare_poli.model';
import {BpjsPcarePoliModelAudit} from './bpjs_pcare_poli.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Poli model actions to be dispatched by NgRx.
 */
export enum BpjsPcarePoliModelActionTypes {
	CREATE_BPJS_PCARE_POLI = '[ENTITY] Create BpjsPcarePoliModel',
	CREATE_BPJS_PCARE_POLI_OK = '[ENTITY] Create BpjsPcarePoliModel successfully',
	CREATE_BPJS_PCARE_POLI_FAIL = '[ENTITY] Create BpjsPcarePoliModel failed',

	CREATE_ALL_BPJS_PCARE_POLI = '[ENTITY] Create All BpjsPcarePoliModel',
	CREATE_ALL_BPJS_PCARE_POLI_OK = '[ENTITY] Create All BpjsPcarePoliModel successfully',
	CREATE_ALL_BPJS_PCARE_POLI_FAIL = '[ENTITY] Create All BpjsPcarePoliModel failed',

	DELETE_BPJS_PCARE_POLI = '[ENTITY] Delete BpjsPcarePoliModel',
	DELETE_BPJS_PCARE_POLI_OK = '[ENTITY] Delete BpjsPcarePoliModel successfully',
	DELETE_BPJS_PCARE_POLI_FAIL = '[ENTITY] Delete BpjsPcarePoliModel failed',


	DELETE_BPJS_PCARE_POLI_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcarePoliModels Excluding Ids',
	DELETE_BPJS_PCARE_POLI_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcarePoliModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_POLI_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcarePoliModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_POLI = '[ENTITY] Delete all BpjsPcarePoliModels',
	DELETE_ALL_BPJS_PCARE_POLI_OK = '[ENTITY] Delete all BpjsPcarePoliModels successfully',
	DELETE_ALL_BPJS_PCARE_POLI_FAIL = '[ENTITY] Delete all BpjsPcarePoliModels failed',

	UPDATE_BPJS_PCARE_POLI = '[ENTITY] Update BpjsPcarePoliModel',
	UPDATE_BPJS_PCARE_POLI_OK = '[ENTITY] Update BpjsPcarePoliModel successfully',
	UPDATE_BPJS_PCARE_POLI_FAIL = '[ENTITY] Update BpjsPcarePoliModel failed',

	UPDATE_ALL_BPJS_PCARE_POLI = '[ENTITY] Update all BpjsPcarePoliModel',
	UPDATE_ALL_BPJS_PCARE_POLI_OK = '[ENTITY] Update all BpjsPcarePoliModel successfully',
	UPDATE_ALL_BPJS_PCARE_POLI_FAIL = '[ENTITY] Update all BpjsPcarePoliModel failed',

	FETCH_BPJS_PCARE_POLI= '[ENTITY] Fetch BpjsPcarePoliModel',
	FETCH_BPJS_PCARE_POLI_OK = '[ENTITY] Fetch BpjsPcarePoliModel successfully',
	FETCH_BPJS_PCARE_POLI_FAIL = '[ENTITY] Fetch BpjsPcarePoliModel failed',

	FETCH_BPJS_PCARE_POLI_AUDIT= '[ENTITY] Fetch BpjsPcarePoliModel audit',
	FETCH_BPJS_PCARE_POLI_AUDIT_OK = '[ENTITY] Fetch BpjsPcarePoliModel audit successfully',
	FETCH_BPJS_PCARE_POLI_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcarePoliModel audit failed',

	FETCH_BPJS_PCARE_POLI_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcarePoliModel audits by entity id',
	FETCH_BPJS_PCARE_POLI_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcarePoliModel audits by entity id successfully',
	FETCH_BPJS_PCARE_POLI_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcarePoliModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_POLI = '[ENTITY] Fetch all BpjsPcarePoliModel',
	FETCH_ALL_BPJS_PCARE_POLI_OK = '[ENTITY] Fetch all BpjsPcarePoliModel successfully',
	FETCH_ALL_BPJS_PCARE_POLI_FAIL = '[ENTITY] Fetch all BpjsPcarePoliModel failed',

	FETCH_BPJS_PCARE_POLI_WITH_QUERY = '[ENTITY] Fetch BpjsPcarePoliModel with query',
	FETCH_BPJS_PCARE_POLI_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcarePoliModel with query successfully',
	FETCH_BPJS_PCARE_POLI_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcarePoliModel with query failed',

	FETCH_LAST_BPJS_PCARE_POLI_WITH_QUERY = '[ENTITY] Fetch last BpjsPcarePoliModel with query',
	FETCH_LAST_BPJS_PCARE_POLI_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcarePoliModel with query successfully',
	FETCH_LAST_BPJS_PCARE_POLI_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcarePoliModel with query failed',

	EXPORT_BPJS_PCARE_POLI = '[ENTITY] Export BpjsPcarePoliModel',
	EXPORT_BPJS_PCARE_POLI_OK = '[ENTITY] Export BpjsPcarePoliModel successfully',
	EXPORT_BPJS_PCARE_POLI_FAIL = '[ENTITY] Export BpjsPcarePoliModel failed',

	EXPORT_ALL_BPJS_PCARE_POLI = '[ENTITY] Export All BpjsPcarePoliModels',
	EXPORT_ALL_BPJS_PCARE_POLI_OK = '[ENTITY] Export All BpjsPcarePoliModels successfully',
	EXPORT_ALL_BPJS_PCARE_POLI_FAIL = '[ENTITY] Export All BpjsPcarePoliModels failed',

	EXPORT_BPJS_PCARE_POLI_EXCLUDING_IDS = '[ENTITY] Export BpjsPcarePoliModels excluding Ids',
	EXPORT_BPJS_PCARE_POLI_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcarePoliModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_POLI_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcarePoliModel excluding Ids failed',

	COUNT_BPJS_PCARE_POLIS = '[ENTITY] Fetch number of BpjsPcarePoliModel records',
	COUNT_BPJS_PCARE_POLIS_OK = '[ENTITY] Fetch number of BpjsPcarePoliModel records successfully ',
	COUNT_BPJS_PCARE_POLIS_FAIL = '[ENTITY] Fetch number of BpjsPcarePoliModel records failed',

	IMPORT_BPJS_PCARE_POLIS = '[ENTITY] Import BpjsPcarePoliModels',
	IMPORT_BPJS_PCARE_POLIS_OK = '[ENTITY] Import BpjsPcarePoliModels successfully',
	IMPORT_BPJS_PCARE_POLIS_FAIL = '[ENTITY] Import BpjsPcarePoliModels fail',


	INITIALISE_BPJS_PCARE_POLI_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcarePoliModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcarePoliAction implements Action {
	readonly className: string = 'BpjsPcarePoliModel';

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

export class BpjsPcarePoliAction extends BaseBpjsPcarePoliAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePoliAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePoliAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePoliModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePoliAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePoliAction here] end
}

export class BpjsPcarePoliActionOK extends BaseBpjsPcarePoliAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePoliActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePoliActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePoliModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcarePoliModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePoliActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePoliActionOK here] end
}

export class BpjsPcarePoliActionFail extends BaseBpjsPcarePoliAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePoliActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePoliActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcarePoliModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePoliActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePoliActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePoliActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePoliActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePoliActionFail here] end
}

export function isBpjsPcarePoliModelAction(e: any): e is BaseBpjsPcarePoliAction {
	return Object.values(BpjsPcarePoliModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
