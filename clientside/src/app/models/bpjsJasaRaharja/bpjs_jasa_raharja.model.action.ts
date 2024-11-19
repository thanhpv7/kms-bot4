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
import {BpjsJasaRaharjaModel} from './bpjs_jasa_raharja.model';
import {BpjsJasaRaharjaModelAudit} from './bpjs_jasa_raharja.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Jasa Raharja model actions to be dispatched by NgRx.
 */
export enum BpjsJasaRaharjaModelActionTypes {
	CREATE_BPJS_JASA_RAHARJA = '[ENTITY] Create BpjsJasaRaharjaModel',
	CREATE_BPJS_JASA_RAHARJA_OK = '[ENTITY] Create BpjsJasaRaharjaModel successfully',
	CREATE_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Create BpjsJasaRaharjaModel failed',

	CREATE_ALL_BPJS_JASA_RAHARJA = '[ENTITY] Create All BpjsJasaRaharjaModel',
	CREATE_ALL_BPJS_JASA_RAHARJA_OK = '[ENTITY] Create All BpjsJasaRaharjaModel successfully',
	CREATE_ALL_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Create All BpjsJasaRaharjaModel failed',

	DELETE_BPJS_JASA_RAHARJA = '[ENTITY] Delete BpjsJasaRaharjaModel',
	DELETE_BPJS_JASA_RAHARJA_OK = '[ENTITY] Delete BpjsJasaRaharjaModel successfully',
	DELETE_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Delete BpjsJasaRaharjaModel failed',


	DELETE_BPJS_JASA_RAHARJA_EXCLUDING_IDS = '[ENTITY] Delete BpjsJasaRaharjaModels Excluding Ids',
	DELETE_BPJS_JASA_RAHARJA_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsJasaRaharjaModels Excluding Ids successfully',
	DELETE_BPJS_JASA_RAHARJA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsJasaRaharjaModels Excluding Ids failed',

	DELETE_ALL_BPJS_JASA_RAHARJA = '[ENTITY] Delete all BpjsJasaRaharjaModels',
	DELETE_ALL_BPJS_JASA_RAHARJA_OK = '[ENTITY] Delete all BpjsJasaRaharjaModels successfully',
	DELETE_ALL_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Delete all BpjsJasaRaharjaModels failed',

	UPDATE_BPJS_JASA_RAHARJA = '[ENTITY] Update BpjsJasaRaharjaModel',
	UPDATE_BPJS_JASA_RAHARJA_OK = '[ENTITY] Update BpjsJasaRaharjaModel successfully',
	UPDATE_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Update BpjsJasaRaharjaModel failed',

	UPDATE_ALL_BPJS_JASA_RAHARJA = '[ENTITY] Update all BpjsJasaRaharjaModel',
	UPDATE_ALL_BPJS_JASA_RAHARJA_OK = '[ENTITY] Update all BpjsJasaRaharjaModel successfully',
	UPDATE_ALL_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Update all BpjsJasaRaharjaModel failed',

	FETCH_BPJS_JASA_RAHARJA= '[ENTITY] Fetch BpjsJasaRaharjaModel',
	FETCH_BPJS_JASA_RAHARJA_OK = '[ENTITY] Fetch BpjsJasaRaharjaModel successfully',
	FETCH_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaModel failed',

	FETCH_BPJS_JASA_RAHARJA_AUDIT= '[ENTITY] Fetch BpjsJasaRaharjaModel audit',
	FETCH_BPJS_JASA_RAHARJA_AUDIT_OK = '[ENTITY] Fetch BpjsJasaRaharjaModel audit successfully',
	FETCH_BPJS_JASA_RAHARJA_AUDIT_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaModel audit failed',

	FETCH_BPJS_JASA_RAHARJA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsJasaRaharjaModel audits by entity id',
	FETCH_BPJS_JASA_RAHARJA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsJasaRaharjaModel audits by entity id successfully',
	FETCH_BPJS_JASA_RAHARJA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaModel audits by entity id failed',

	FETCH_ALL_BPJS_JASA_RAHARJA = '[ENTITY] Fetch all BpjsJasaRaharjaModel',
	FETCH_ALL_BPJS_JASA_RAHARJA_OK = '[ENTITY] Fetch all BpjsJasaRaharjaModel successfully',
	FETCH_ALL_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Fetch all BpjsJasaRaharjaModel failed',

	FETCH_BPJS_JASA_RAHARJA_WITH_QUERY = '[ENTITY] Fetch BpjsJasaRaharjaModel with query',
	FETCH_BPJS_JASA_RAHARJA_WITH_QUERY_OK = '[ENTITY] Fetch BpjsJasaRaharjaModel with query successfully',
	FETCH_BPJS_JASA_RAHARJA_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsJasaRaharjaModel with query failed',

	FETCH_LAST_BPJS_JASA_RAHARJA_WITH_QUERY = '[ENTITY] Fetch last BpjsJasaRaharjaModel with query',
	FETCH_LAST_BPJS_JASA_RAHARJA_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsJasaRaharjaModel with query successfully',
	FETCH_LAST_BPJS_JASA_RAHARJA_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsJasaRaharjaModel with query failed',

	EXPORT_BPJS_JASA_RAHARJA = '[ENTITY] Export BpjsJasaRaharjaModel',
	EXPORT_BPJS_JASA_RAHARJA_OK = '[ENTITY] Export BpjsJasaRaharjaModel successfully',
	EXPORT_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Export BpjsJasaRaharjaModel failed',

	EXPORT_ALL_BPJS_JASA_RAHARJA = '[ENTITY] Export All BpjsJasaRaharjaModels',
	EXPORT_ALL_BPJS_JASA_RAHARJA_OK = '[ENTITY] Export All BpjsJasaRaharjaModels successfully',
	EXPORT_ALL_BPJS_JASA_RAHARJA_FAIL = '[ENTITY] Export All BpjsJasaRaharjaModels failed',

	EXPORT_BPJS_JASA_RAHARJA_EXCLUDING_IDS = '[ENTITY] Export BpjsJasaRaharjaModels excluding Ids',
	EXPORT_BPJS_JASA_RAHARJA_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsJasaRaharjaModel excluding Ids successfully',
	EXPORT_BPJS_JASA_RAHARJA_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsJasaRaharjaModel excluding Ids failed',

	COUNT_BPJS_JASA_RAHARJAS = '[ENTITY] Fetch number of BpjsJasaRaharjaModel records',
	COUNT_BPJS_JASA_RAHARJAS_OK = '[ENTITY] Fetch number of BpjsJasaRaharjaModel records successfully ',
	COUNT_BPJS_JASA_RAHARJAS_FAIL = '[ENTITY] Fetch number of BpjsJasaRaharjaModel records failed',

	IMPORT_BPJS_JASA_RAHARJAS = '[ENTITY] Import BpjsJasaRaharjaModels',
	IMPORT_BPJS_JASA_RAHARJAS_OK = '[ENTITY] Import BpjsJasaRaharjaModels successfully',
	IMPORT_BPJS_JASA_RAHARJAS_FAIL = '[ENTITY] Import BpjsJasaRaharjaModels fail',


	INITIALISE_BPJS_JASA_RAHARJA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsJasaRaharjaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsJasaRaharjaAction implements Action {
	readonly className: string = 'BpjsJasaRaharjaModel';

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

export class BpjsJasaRaharjaAction extends BaseBpjsJasaRaharjaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaAction here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsJasaRaharjaModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaAction here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaAction here] end
}

export class BpjsJasaRaharjaActionOK extends BaseBpjsJasaRaharjaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsJasaRaharjaModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsJasaRaharjaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaActionOK here] end
}

export class BpjsJasaRaharjaActionFail extends BaseBpjsJasaRaharjaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsJasaRaharjaActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsJasaRaharjaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsJasaRaharjaModel>,
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsJasaRaharjaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsJasaRaharjaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsJasaRaharjaActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsJasaRaharjaActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsJasaRaharjaActionFail here] end
}

export function isBpjsJasaRaharjaModelAction(e: any): e is BaseBpjsJasaRaharjaAction {
	return Object.values(BpjsJasaRaharjaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
