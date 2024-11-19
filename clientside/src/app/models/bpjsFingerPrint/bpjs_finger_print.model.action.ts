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
import {BpjsFingerPrintModel} from './bpjs_finger_print.model';
import {BpjsFingerPrintModelAudit} from './bpjs_finger_print.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Finger Print model actions to be dispatched by NgRx.
 */
export enum BpjsFingerPrintModelActionTypes {
	CREATE_BPJS_FINGER_PRINT = '[ENTITY] Create BpjsFingerPrintModel',
	CREATE_BPJS_FINGER_PRINT_OK = '[ENTITY] Create BpjsFingerPrintModel successfully',
	CREATE_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Create BpjsFingerPrintModel failed',

	CREATE_ALL_BPJS_FINGER_PRINT = '[ENTITY] Create All BpjsFingerPrintModel',
	CREATE_ALL_BPJS_FINGER_PRINT_OK = '[ENTITY] Create All BpjsFingerPrintModel successfully',
	CREATE_ALL_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Create All BpjsFingerPrintModel failed',

	DELETE_BPJS_FINGER_PRINT = '[ENTITY] Delete BpjsFingerPrintModel',
	DELETE_BPJS_FINGER_PRINT_OK = '[ENTITY] Delete BpjsFingerPrintModel successfully',
	DELETE_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Delete BpjsFingerPrintModel failed',


	DELETE_BPJS_FINGER_PRINT_EXCLUDING_IDS = '[ENTITY] Delete BpjsFingerPrintModels Excluding Ids',
	DELETE_BPJS_FINGER_PRINT_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsFingerPrintModels Excluding Ids successfully',
	DELETE_BPJS_FINGER_PRINT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsFingerPrintModels Excluding Ids failed',

	DELETE_ALL_BPJS_FINGER_PRINT = '[ENTITY] Delete all BpjsFingerPrintModels',
	DELETE_ALL_BPJS_FINGER_PRINT_OK = '[ENTITY] Delete all BpjsFingerPrintModels successfully',
	DELETE_ALL_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Delete all BpjsFingerPrintModels failed',

	UPDATE_BPJS_FINGER_PRINT = '[ENTITY] Update BpjsFingerPrintModel',
	UPDATE_BPJS_FINGER_PRINT_OK = '[ENTITY] Update BpjsFingerPrintModel successfully',
	UPDATE_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Update BpjsFingerPrintModel failed',

	UPDATE_ALL_BPJS_FINGER_PRINT = '[ENTITY] Update all BpjsFingerPrintModel',
	UPDATE_ALL_BPJS_FINGER_PRINT_OK = '[ENTITY] Update all BpjsFingerPrintModel successfully',
	UPDATE_ALL_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Update all BpjsFingerPrintModel failed',

	FETCH_BPJS_FINGER_PRINT= '[ENTITY] Fetch BpjsFingerPrintModel',
	FETCH_BPJS_FINGER_PRINT_OK = '[ENTITY] Fetch BpjsFingerPrintModel successfully',
	FETCH_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Fetch BpjsFingerPrintModel failed',

	FETCH_BPJS_FINGER_PRINT_AUDIT= '[ENTITY] Fetch BpjsFingerPrintModel audit',
	FETCH_BPJS_FINGER_PRINT_AUDIT_OK = '[ENTITY] Fetch BpjsFingerPrintModel audit successfully',
	FETCH_BPJS_FINGER_PRINT_AUDIT_FAIL = '[ENTITY] Fetch BpjsFingerPrintModel audit failed',

	FETCH_BPJS_FINGER_PRINT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsFingerPrintModel audits by entity id',
	FETCH_BPJS_FINGER_PRINT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsFingerPrintModel audits by entity id successfully',
	FETCH_BPJS_FINGER_PRINT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsFingerPrintModel audits by entity id failed',

	FETCH_ALL_BPJS_FINGER_PRINT = '[ENTITY] Fetch all BpjsFingerPrintModel',
	FETCH_ALL_BPJS_FINGER_PRINT_OK = '[ENTITY] Fetch all BpjsFingerPrintModel successfully',
	FETCH_ALL_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Fetch all BpjsFingerPrintModel failed',

	FETCH_BPJS_FINGER_PRINT_WITH_QUERY = '[ENTITY] Fetch BpjsFingerPrintModel with query',
	FETCH_BPJS_FINGER_PRINT_WITH_QUERY_OK = '[ENTITY] Fetch BpjsFingerPrintModel with query successfully',
	FETCH_BPJS_FINGER_PRINT_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsFingerPrintModel with query failed',

	FETCH_LAST_BPJS_FINGER_PRINT_WITH_QUERY = '[ENTITY] Fetch last BpjsFingerPrintModel with query',
	FETCH_LAST_BPJS_FINGER_PRINT_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsFingerPrintModel with query successfully',
	FETCH_LAST_BPJS_FINGER_PRINT_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsFingerPrintModel with query failed',

	EXPORT_BPJS_FINGER_PRINT = '[ENTITY] Export BpjsFingerPrintModel',
	EXPORT_BPJS_FINGER_PRINT_OK = '[ENTITY] Export BpjsFingerPrintModel successfully',
	EXPORT_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Export BpjsFingerPrintModel failed',

	EXPORT_ALL_BPJS_FINGER_PRINT = '[ENTITY] Export All BpjsFingerPrintModels',
	EXPORT_ALL_BPJS_FINGER_PRINT_OK = '[ENTITY] Export All BpjsFingerPrintModels successfully',
	EXPORT_ALL_BPJS_FINGER_PRINT_FAIL = '[ENTITY] Export All BpjsFingerPrintModels failed',

	EXPORT_BPJS_FINGER_PRINT_EXCLUDING_IDS = '[ENTITY] Export BpjsFingerPrintModels excluding Ids',
	EXPORT_BPJS_FINGER_PRINT_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsFingerPrintModel excluding Ids successfully',
	EXPORT_BPJS_FINGER_PRINT_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsFingerPrintModel excluding Ids failed',

	COUNT_BPJS_FINGER_PRINTS = '[ENTITY] Fetch number of BpjsFingerPrintModel records',
	COUNT_BPJS_FINGER_PRINTS_OK = '[ENTITY] Fetch number of BpjsFingerPrintModel records successfully ',
	COUNT_BPJS_FINGER_PRINTS_FAIL = '[ENTITY] Fetch number of BpjsFingerPrintModel records failed',

	IMPORT_BPJS_FINGER_PRINTS = '[ENTITY] Import BpjsFingerPrintModels',
	IMPORT_BPJS_FINGER_PRINTS_OK = '[ENTITY] Import BpjsFingerPrintModels successfully',
	IMPORT_BPJS_FINGER_PRINTS_FAIL = '[ENTITY] Import BpjsFingerPrintModels fail',


	INITIALISE_BPJS_FINGER_PRINT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsFingerPrintModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsFingerPrintAction implements Action {
	readonly className: string = 'BpjsFingerPrintModel';

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

export class BpjsFingerPrintAction extends BaseBpjsFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFingerPrintAction here] off begin
	// % protected region % [Add any additional class fields for BpjsFingerPrintAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsFingerPrintAction here] off begin
	// % protected region % [Add any additional class methods for BpjsFingerPrintAction here] end
}

export class BpjsFingerPrintActionOK extends BaseBpjsFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFingerPrintActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsFingerPrintActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsFingerPrintModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsFingerPrintActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsFingerPrintActionOK here] end
}

export class BpjsFingerPrintActionFail extends BaseBpjsFingerPrintAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsFingerPrintActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsFingerPrintActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsFingerPrintModel>,
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsFingerPrintActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsFingerPrintActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsFingerPrintActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsFingerPrintActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsFingerPrintActionFail here] end
}

export function isBpjsFingerPrintModelAction(e: any): e is BaseBpjsFingerPrintAction {
	return Object.values(BpjsFingerPrintModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
