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
import {BpjsListFingerPrintModel} from './bpjs_list_finger_print.model';
import {BpjsListFingerPrintModelAudit} from './bpjs_list_finger_print.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS List Finger Print model actions to be dispatched by NgRx.
 */
export enum BpjsListFingerPrintModelActionTypes {
	CREATE_BPJS_LIST_FINGER_PRINT = '[ENTITY] Create BpjsListFingerPrintModel',
	CREATE_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Create BpjsListFingerPrintModel successfully',
	CREATE_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Create BpjsListFingerPrintModel failed',

	CREATE_ALL_BPJS_LIST_FINGER_PRINT = '[ENTITY] Create All BpjsListFingerPrintModel',
	CREATE_ALL_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Create All BpjsListFingerPrintModel successfully',
	CREATE_ALL_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Create All BpjsListFingerPrintModel failed',

	DELETE_BPJS_LIST_FINGER_PRINT = '[ENTITY] Delete BpjsListFingerPrintModel',
	DELETE_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Delete BpjsListFingerPrintModel successfully',
	DELETE_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Delete BpjsListFingerPrintModel failed',


	DELETE_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS = '[ENTITY] Delete BpjsListFingerPrintModels Excluding Ids',
	DELETE_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsListFingerPrintModels Excluding Ids successfully',
	DELETE_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsListFingerPrintModels Excluding Ids failed',

	DELETE_ALL_BPJS_LIST_FINGER_PRINT = '[ENTITY] Delete all BpjsListFingerPrintModels',
	DELETE_ALL_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Delete all BpjsListFingerPrintModels successfully',
	DELETE_ALL_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Delete all BpjsListFingerPrintModels failed',

	UPDATE_BPJS_LIST_FINGER_PRINT = '[ENTITY] Update BpjsListFingerPrintModel',
	UPDATE_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Update BpjsListFingerPrintModel successfully',
	UPDATE_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Update BpjsListFingerPrintModel failed',

	UPDATE_ALL_BPJS_LIST_FINGER_PRINT = '[ENTITY] Update all BpjsListFingerPrintModel',
	UPDATE_ALL_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Update all BpjsListFingerPrintModel successfully',
	UPDATE_ALL_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Update all BpjsListFingerPrintModel failed',

	FETCH_BPJS_LIST_FINGER_PRINT= '[ENTITY] Fetch BpjsListFingerPrintModel',
	FETCH_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Fetch BpjsListFingerPrintModel successfully',
	FETCH_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Fetch BpjsListFingerPrintModel failed',

	FETCH_BPJS_LIST_FINGER_PRINT_AUDIT= '[ENTITY] Fetch BpjsListFingerPrintModel audit',
	FETCH_BPJS_LIST_FINGER_PRINT_AUDIT_OK = '[ENTITY] Fetch BpjsListFingerPrintModel audit successfully',
	FETCH_BPJS_LIST_FINGER_PRINT_AUDIT_FAIL = '[ENTITY] Fetch BpjsListFingerPrintModel audit failed',

	FETCH_BPJS_LIST_FINGER_PRINT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsListFingerPrintModel audits by entity id',
	FETCH_BPJS_LIST_FINGER_PRINT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsListFingerPrintModel audits by entity id successfully',
	FETCH_BPJS_LIST_FINGER_PRINT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsListFingerPrintModel audits by entity id failed',

	FETCH_ALL_BPJS_LIST_FINGER_PRINT = '[ENTITY] Fetch all BpjsListFingerPrintModel',
	FETCH_ALL_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Fetch all BpjsListFingerPrintModel successfully',
	FETCH_ALL_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Fetch all BpjsListFingerPrintModel failed',

	FETCH_BPJS_LIST_FINGER_PRINT_WITH_QUERY = '[ENTITY] Fetch BpjsListFingerPrintModel with query',
	FETCH_BPJS_LIST_FINGER_PRINT_WITH_QUERY_OK = '[ENTITY] Fetch BpjsListFingerPrintModel with query successfully',
	FETCH_BPJS_LIST_FINGER_PRINT_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsListFingerPrintModel with query failed',

	FETCH_LAST_BPJS_LIST_FINGER_PRINT_WITH_QUERY = '[ENTITY] Fetch last BpjsListFingerPrintModel with query',
	FETCH_LAST_BPJS_LIST_FINGER_PRINT_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsListFingerPrintModel with query successfully',
	FETCH_LAST_BPJS_LIST_FINGER_PRINT_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsListFingerPrintModel with query failed',

	EXPORT_BPJS_LIST_FINGER_PRINT = '[ENTITY] Export BpjsListFingerPrintModel',
	EXPORT_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Export BpjsListFingerPrintModel successfully',
	EXPORT_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Export BpjsListFingerPrintModel failed',

	EXPORT_ALL_BPJS_LIST_FINGER_PRINT = '[ENTITY] Export All BpjsListFingerPrintModels',
	EXPORT_ALL_BPJS_LIST_FINGER_PRINT_OK = '[ENTITY] Export All BpjsListFingerPrintModels successfully',
	EXPORT_ALL_BPJS_LIST_FINGER_PRINT_FAIL = '[ENTITY] Export All BpjsListFingerPrintModels failed',

	EXPORT_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS = '[ENTITY] Export BpjsListFingerPrintModels excluding Ids',
	EXPORT_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsListFingerPrintModel excluding Ids successfully',
	EXPORT_BPJS_LIST_FINGER_PRINT_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsListFingerPrintModel excluding Ids failed',

	COUNT_BPJS_LIST_FINGER_PRINTS = '[ENTITY] Fetch number of BpjsListFingerPrintModel records',
	COUNT_BPJS_LIST_FINGER_PRINTS_OK = '[ENTITY] Fetch number of BpjsListFingerPrintModel records successfully ',
	COUNT_BPJS_LIST_FINGER_PRINTS_FAIL = '[ENTITY] Fetch number of BpjsListFingerPrintModel records failed',

	IMPORT_BPJS_LIST_FINGER_PRINTS = '[ENTITY] Import BpjsListFingerPrintModels',
	IMPORT_BPJS_LIST_FINGER_PRINTS_OK = '[ENTITY] Import BpjsListFingerPrintModels successfully',
	IMPORT_BPJS_LIST_FINGER_PRINTS_FAIL = '[ENTITY] Import BpjsListFingerPrintModels fail',


	INITIALISE_BPJS_LIST_FINGER_PRINT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsListFingerPrintModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsListFingerPrintAction implements Action {
	readonly className: string = 'BpjsListFingerPrintModel';

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

export class BpjsListFingerPrintAction extends BaseBpjsListFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListFingerPrintAction here] off begin
	// % protected region % [Add any additional class fields for BpjsListFingerPrintAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsListFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsListFingerPrintAction here] off begin
	// % protected region % [Add any additional class methods for BpjsListFingerPrintAction here] end
}

export class BpjsListFingerPrintActionOK extends BaseBpjsListFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListFingerPrintActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsListFingerPrintActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsListFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsListFingerPrintModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsListFingerPrintActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsListFingerPrintActionOK here] end
}

export class BpjsListFingerPrintActionFail extends BaseBpjsListFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsListFingerPrintActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsListFingerPrintActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsListFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsListFingerPrintActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsListFingerPrintActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsListFingerPrintActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsListFingerPrintActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsListFingerPrintActionFail here] end
}

export function isBpjsListFingerPrintModelAction(e: any): e is BaseBpjsListFingerPrintAction {
	return Object.values(BpjsListFingerPrintModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
