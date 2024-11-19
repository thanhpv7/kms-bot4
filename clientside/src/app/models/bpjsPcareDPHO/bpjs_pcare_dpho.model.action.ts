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
import {BpjsPcareDPHOModel} from './bpjs_pcare_dpho.model';
import {BpjsPcareDPHOModelAudit} from './bpjs_pcare_dpho.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare DPHO model actions to be dispatched by NgRx.
 */
export enum BpjsPcareDPHOModelActionTypes {
	CREATE_BPJS_PCARE_DPHO = '[ENTITY] Create BpjsPcareDPHOModel',
	CREATE_BPJS_PCARE_DPHO_OK = '[ENTITY] Create BpjsPcareDPHOModel successfully',
	CREATE_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Create BpjsPcareDPHOModel failed',

	CREATE_ALL_BPJS_PCARE_DPHO = '[ENTITY] Create All BpjsPcareDPHOModel',
	CREATE_ALL_BPJS_PCARE_DPHO_OK = '[ENTITY] Create All BpjsPcareDPHOModel successfully',
	CREATE_ALL_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Create All BpjsPcareDPHOModel failed',

	DELETE_BPJS_PCARE_DPHO = '[ENTITY] Delete BpjsPcareDPHOModel',
	DELETE_BPJS_PCARE_DPHO_OK = '[ENTITY] Delete BpjsPcareDPHOModel successfully',
	DELETE_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Delete BpjsPcareDPHOModel failed',


	DELETE_BPJS_PCARE_DPHO_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareDPHOModels Excluding Ids',
	DELETE_BPJS_PCARE_DPHO_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareDPHOModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_DPHO_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareDPHOModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_DPHO = '[ENTITY] Delete all BpjsPcareDPHOModels',
	DELETE_ALL_BPJS_PCARE_DPHO_OK = '[ENTITY] Delete all BpjsPcareDPHOModels successfully',
	DELETE_ALL_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Delete all BpjsPcareDPHOModels failed',

	UPDATE_BPJS_PCARE_DPHO = '[ENTITY] Update BpjsPcareDPHOModel',
	UPDATE_BPJS_PCARE_DPHO_OK = '[ENTITY] Update BpjsPcareDPHOModel successfully',
	UPDATE_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Update BpjsPcareDPHOModel failed',

	UPDATE_ALL_BPJS_PCARE_DPHO = '[ENTITY] Update all BpjsPcareDPHOModel',
	UPDATE_ALL_BPJS_PCARE_DPHO_OK = '[ENTITY] Update all BpjsPcareDPHOModel successfully',
	UPDATE_ALL_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Update all BpjsPcareDPHOModel failed',

	FETCH_BPJS_PCARE_DPHO= '[ENTITY] Fetch BpjsPcareDPHOModel',
	FETCH_BPJS_PCARE_DPHO_OK = '[ENTITY] Fetch BpjsPcareDPHOModel successfully',
	FETCH_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Fetch BpjsPcareDPHOModel failed',

	FETCH_BPJS_PCARE_DPHO_AUDIT= '[ENTITY] Fetch BpjsPcareDPHOModel audit',
	FETCH_BPJS_PCARE_DPHO_AUDIT_OK = '[ENTITY] Fetch BpjsPcareDPHOModel audit successfully',
	FETCH_BPJS_PCARE_DPHO_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareDPHOModel audit failed',

	FETCH_BPJS_PCARE_DPHO_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareDPHOModel audits by entity id',
	FETCH_BPJS_PCARE_DPHO_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareDPHOModel audits by entity id successfully',
	FETCH_BPJS_PCARE_DPHO_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareDPHOModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_DPHO = '[ENTITY] Fetch all BpjsPcareDPHOModel',
	FETCH_ALL_BPJS_PCARE_DPHO_OK = '[ENTITY] Fetch all BpjsPcareDPHOModel successfully',
	FETCH_ALL_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Fetch all BpjsPcareDPHOModel failed',

	FETCH_BPJS_PCARE_DPHO_WITH_QUERY = '[ENTITY] Fetch BpjsPcareDPHOModel with query',
	FETCH_BPJS_PCARE_DPHO_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareDPHOModel with query successfully',
	FETCH_BPJS_PCARE_DPHO_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareDPHOModel with query failed',

	FETCH_LAST_BPJS_PCARE_DPHO_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareDPHOModel with query',
	FETCH_LAST_BPJS_PCARE_DPHO_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareDPHOModel with query successfully',
	FETCH_LAST_BPJS_PCARE_DPHO_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareDPHOModel with query failed',

	EXPORT_BPJS_PCARE_DPHO = '[ENTITY] Export BpjsPcareDPHOModel',
	EXPORT_BPJS_PCARE_DPHO_OK = '[ENTITY] Export BpjsPcareDPHOModel successfully',
	EXPORT_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Export BpjsPcareDPHOModel failed',

	EXPORT_ALL_BPJS_PCARE_DPHO = '[ENTITY] Export All BpjsPcareDPHOModels',
	EXPORT_ALL_BPJS_PCARE_DPHO_OK = '[ENTITY] Export All BpjsPcareDPHOModels successfully',
	EXPORT_ALL_BPJS_PCARE_DPHO_FAIL = '[ENTITY] Export All BpjsPcareDPHOModels failed',

	EXPORT_BPJS_PCARE_DPHO_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareDPHOModels excluding Ids',
	EXPORT_BPJS_PCARE_DPHO_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareDPHOModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_DPHO_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareDPHOModel excluding Ids failed',

	COUNT_BPJS_PCARE_DPHOS = '[ENTITY] Fetch number of BpjsPcareDPHOModel records',
	COUNT_BPJS_PCARE_DPHOS_OK = '[ENTITY] Fetch number of BpjsPcareDPHOModel records successfully ',
	COUNT_BPJS_PCARE_DPHOS_FAIL = '[ENTITY] Fetch number of BpjsPcareDPHOModel records failed',

	IMPORT_BPJS_PCARE_DPHOS = '[ENTITY] Import BpjsPcareDPHOModels',
	IMPORT_BPJS_PCARE_DPHOS_OK = '[ENTITY] Import BpjsPcareDPHOModels successfully',
	IMPORT_BPJS_PCARE_DPHOS_FAIL = '[ENTITY] Import BpjsPcareDPHOModels fail',


	INITIALISE_BPJS_PCARE_DPHO_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareDPHOModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareDPHOAction implements Action {
	readonly className: string = 'BpjsPcareDPHOModel';

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

export class BpjsPcareDPHOAction extends BaseBpjsPcareDPHOAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareDPHOAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareDPHOAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareDPHOModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareDPHOAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareDPHOAction here] end
}

export class BpjsPcareDPHOActionOK extends BaseBpjsPcareDPHOAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareDPHOActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareDPHOActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareDPHOModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareDPHOModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareDPHOActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareDPHOActionOK here] end
}

export class BpjsPcareDPHOActionFail extends BaseBpjsPcareDPHOAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareDPHOActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareDPHOActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareDPHOModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareDPHOActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareDPHOActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareDPHOActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareDPHOActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareDPHOActionFail here] end
}

export function isBpjsPcareDPHOModelAction(e: any): e is BaseBpjsPcareDPHOAction {
	return Object.values(BpjsPcareDPHOModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
