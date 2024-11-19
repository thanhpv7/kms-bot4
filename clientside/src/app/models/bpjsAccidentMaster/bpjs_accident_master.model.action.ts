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
import {BpjsAccidentMasterModel} from './bpjs_accident_master.model';
import {BpjsAccidentMasterModelAudit} from './bpjs_accident_master.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Accident Master model actions to be dispatched by NgRx.
 */
export enum BpjsAccidentMasterModelActionTypes {
	CREATE_BPJS_ACCIDENT_MASTER = '[ENTITY] Create BpjsAccidentMasterModel',
	CREATE_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Create BpjsAccidentMasterModel successfully',
	CREATE_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Create BpjsAccidentMasterModel failed',

	CREATE_ALL_BPJS_ACCIDENT_MASTER = '[ENTITY] Create All BpjsAccidentMasterModel',
	CREATE_ALL_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Create All BpjsAccidentMasterModel successfully',
	CREATE_ALL_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Create All BpjsAccidentMasterModel failed',

	DELETE_BPJS_ACCIDENT_MASTER = '[ENTITY] Delete BpjsAccidentMasterModel',
	DELETE_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Delete BpjsAccidentMasterModel successfully',
	DELETE_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Delete BpjsAccidentMasterModel failed',


	DELETE_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS = '[ENTITY] Delete BpjsAccidentMasterModels Excluding Ids',
	DELETE_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsAccidentMasterModels Excluding Ids successfully',
	DELETE_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsAccidentMasterModels Excluding Ids failed',

	DELETE_ALL_BPJS_ACCIDENT_MASTER = '[ENTITY] Delete all BpjsAccidentMasterModels',
	DELETE_ALL_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Delete all BpjsAccidentMasterModels successfully',
	DELETE_ALL_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Delete all BpjsAccidentMasterModels failed',

	UPDATE_BPJS_ACCIDENT_MASTER = '[ENTITY] Update BpjsAccidentMasterModel',
	UPDATE_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Update BpjsAccidentMasterModel successfully',
	UPDATE_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Update BpjsAccidentMasterModel failed',

	UPDATE_ALL_BPJS_ACCIDENT_MASTER = '[ENTITY] Update all BpjsAccidentMasterModel',
	UPDATE_ALL_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Update all BpjsAccidentMasterModel successfully',
	UPDATE_ALL_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Update all BpjsAccidentMasterModel failed',

	FETCH_BPJS_ACCIDENT_MASTER= '[ENTITY] Fetch BpjsAccidentMasterModel',
	FETCH_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Fetch BpjsAccidentMasterModel successfully',
	FETCH_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Fetch BpjsAccidentMasterModel failed',

	FETCH_BPJS_ACCIDENT_MASTER_AUDIT= '[ENTITY] Fetch BpjsAccidentMasterModel audit',
	FETCH_BPJS_ACCIDENT_MASTER_AUDIT_OK = '[ENTITY] Fetch BpjsAccidentMasterModel audit successfully',
	FETCH_BPJS_ACCIDENT_MASTER_AUDIT_FAIL = '[ENTITY] Fetch BpjsAccidentMasterModel audit failed',

	FETCH_BPJS_ACCIDENT_MASTER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsAccidentMasterModel audits by entity id',
	FETCH_BPJS_ACCIDENT_MASTER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsAccidentMasterModel audits by entity id successfully',
	FETCH_BPJS_ACCIDENT_MASTER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsAccidentMasterModel audits by entity id failed',

	FETCH_ALL_BPJS_ACCIDENT_MASTER = '[ENTITY] Fetch all BpjsAccidentMasterModel',
	FETCH_ALL_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Fetch all BpjsAccidentMasterModel successfully',
	FETCH_ALL_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Fetch all BpjsAccidentMasterModel failed',

	FETCH_BPJS_ACCIDENT_MASTER_WITH_QUERY = '[ENTITY] Fetch BpjsAccidentMasterModel with query',
	FETCH_BPJS_ACCIDENT_MASTER_WITH_QUERY_OK = '[ENTITY] Fetch BpjsAccidentMasterModel with query successfully',
	FETCH_BPJS_ACCIDENT_MASTER_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsAccidentMasterModel with query failed',

	FETCH_LAST_BPJS_ACCIDENT_MASTER_WITH_QUERY = '[ENTITY] Fetch last BpjsAccidentMasterModel with query',
	FETCH_LAST_BPJS_ACCIDENT_MASTER_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsAccidentMasterModel with query successfully',
	FETCH_LAST_BPJS_ACCIDENT_MASTER_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsAccidentMasterModel with query failed',

	EXPORT_BPJS_ACCIDENT_MASTER = '[ENTITY] Export BpjsAccidentMasterModel',
	EXPORT_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Export BpjsAccidentMasterModel successfully',
	EXPORT_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Export BpjsAccidentMasterModel failed',

	EXPORT_ALL_BPJS_ACCIDENT_MASTER = '[ENTITY] Export All BpjsAccidentMasterModels',
	EXPORT_ALL_BPJS_ACCIDENT_MASTER_OK = '[ENTITY] Export All BpjsAccidentMasterModels successfully',
	EXPORT_ALL_BPJS_ACCIDENT_MASTER_FAIL = '[ENTITY] Export All BpjsAccidentMasterModels failed',

	EXPORT_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS = '[ENTITY] Export BpjsAccidentMasterModels excluding Ids',
	EXPORT_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsAccidentMasterModel excluding Ids successfully',
	EXPORT_BPJS_ACCIDENT_MASTER_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsAccidentMasterModel excluding Ids failed',

	COUNT_BPJS_ACCIDENT_MASTERS = '[ENTITY] Fetch number of BpjsAccidentMasterModel records',
	COUNT_BPJS_ACCIDENT_MASTERS_OK = '[ENTITY] Fetch number of BpjsAccidentMasterModel records successfully ',
	COUNT_BPJS_ACCIDENT_MASTERS_FAIL = '[ENTITY] Fetch number of BpjsAccidentMasterModel records failed',

	IMPORT_BPJS_ACCIDENT_MASTERS = '[ENTITY] Import BpjsAccidentMasterModels',
	IMPORT_BPJS_ACCIDENT_MASTERS_OK = '[ENTITY] Import BpjsAccidentMasterModels successfully',
	IMPORT_BPJS_ACCIDENT_MASTERS_FAIL = '[ENTITY] Import BpjsAccidentMasterModels fail',


	INITIALISE_BPJS_ACCIDENT_MASTER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsAccidentMasterModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsAccidentMasterAction implements Action {
	readonly className: string = 'BpjsAccidentMasterModel';

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

export class BpjsAccidentMasterAction extends BaseBpjsAccidentMasterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsAccidentMasterAction here] off begin
	// % protected region % [Add any additional class fields for BpjsAccidentMasterAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsAccidentMasterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsAccidentMasterAction here] off begin
	// % protected region % [Add any additional class methods for BpjsAccidentMasterAction here] end
}

export class BpjsAccidentMasterActionOK extends BaseBpjsAccidentMasterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsAccidentMasterActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsAccidentMasterActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsAccidentMasterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsAccidentMasterModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsAccidentMasterActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsAccidentMasterActionOK here] end
}

export class BpjsAccidentMasterActionFail extends BaseBpjsAccidentMasterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsAccidentMasterActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsAccidentMasterActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsAccidentMasterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsAccidentMasterActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsAccidentMasterActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsAccidentMasterActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsAccidentMasterActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsAccidentMasterActionFail here] end
}

export function isBpjsAccidentMasterModelAction(e: any): e is BaseBpjsAccidentMasterAction {
	return Object.values(BpjsAccidentMasterModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
