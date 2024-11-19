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
import {BpjsSearchControlLetterModel} from './bpjs_search_control_letter.model';
import {BpjsSearchControlLetterModelAudit} from './bpjs_search_control_letter.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Search Control Letter model actions to be dispatched by NgRx.
 */
export enum BpjsSearchControlLetterModelActionTypes {
	CREATE_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Create BpjsSearchControlLetterModel',
	CREATE_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Create BpjsSearchControlLetterModel successfully',
	CREATE_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Create BpjsSearchControlLetterModel failed',

	CREATE_ALL_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Create All BpjsSearchControlLetterModel',
	CREATE_ALL_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Create All BpjsSearchControlLetterModel successfully',
	CREATE_ALL_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Create All BpjsSearchControlLetterModel failed',

	DELETE_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Delete BpjsSearchControlLetterModel',
	DELETE_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Delete BpjsSearchControlLetterModel successfully',
	DELETE_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Delete BpjsSearchControlLetterModel failed',


	DELETE_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS = '[ENTITY] Delete BpjsSearchControlLetterModels Excluding Ids',
	DELETE_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSearchControlLetterModels Excluding Ids successfully',
	DELETE_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSearchControlLetterModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Delete all BpjsSearchControlLetterModels',
	DELETE_ALL_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Delete all BpjsSearchControlLetterModels successfully',
	DELETE_ALL_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Delete all BpjsSearchControlLetterModels failed',

	UPDATE_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Update BpjsSearchControlLetterModel',
	UPDATE_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Update BpjsSearchControlLetterModel successfully',
	UPDATE_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Update BpjsSearchControlLetterModel failed',

	UPDATE_ALL_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Update all BpjsSearchControlLetterModel',
	UPDATE_ALL_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Update all BpjsSearchControlLetterModel successfully',
	UPDATE_ALL_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Update all BpjsSearchControlLetterModel failed',

	FETCH_BPJS_SEARCH_CONTROL_LETTER= '[ENTITY] Fetch BpjsSearchControlLetterModel',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Fetch BpjsSearchControlLetterModel successfully',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Fetch BpjsSearchControlLetterModel failed',

	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDIT= '[ENTITY] Fetch BpjsSearchControlLetterModel audit',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDIT_OK = '[ENTITY] Fetch BpjsSearchControlLetterModel audit successfully',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDIT_FAIL = '[ENTITY] Fetch BpjsSearchControlLetterModel audit failed',

	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSearchControlLetterModel audits by entity id',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSearchControlLetterModel audits by entity id successfully',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSearchControlLetterModel audits by entity id failed',

	FETCH_ALL_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Fetch all BpjsSearchControlLetterModel',
	FETCH_ALL_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Fetch all BpjsSearchControlLetterModel successfully',
	FETCH_ALL_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Fetch all BpjsSearchControlLetterModel failed',

	FETCH_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY = '[ENTITY] Fetch BpjsSearchControlLetterModel with query',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSearchControlLetterModel with query successfully',
	FETCH_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSearchControlLetterModel with query failed',

	FETCH_LAST_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY = '[ENTITY] Fetch last BpjsSearchControlLetterModel with query',
	FETCH_LAST_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSearchControlLetterModel with query successfully',
	FETCH_LAST_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSearchControlLetterModel with query failed',

	EXPORT_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Export BpjsSearchControlLetterModel',
	EXPORT_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Export BpjsSearchControlLetterModel successfully',
	EXPORT_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Export BpjsSearchControlLetterModel failed',

	EXPORT_ALL_BPJS_SEARCH_CONTROL_LETTER = '[ENTITY] Export All BpjsSearchControlLetterModels',
	EXPORT_ALL_BPJS_SEARCH_CONTROL_LETTER_OK = '[ENTITY] Export All BpjsSearchControlLetterModels successfully',
	EXPORT_ALL_BPJS_SEARCH_CONTROL_LETTER_FAIL = '[ENTITY] Export All BpjsSearchControlLetterModels failed',

	EXPORT_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS = '[ENTITY] Export BpjsSearchControlLetterModels excluding Ids',
	EXPORT_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSearchControlLetterModel excluding Ids successfully',
	EXPORT_BPJS_SEARCH_CONTROL_LETTER_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSearchControlLetterModel excluding Ids failed',

	COUNT_BPJS_SEARCH_CONTROL_LETTERS = '[ENTITY] Fetch number of BpjsSearchControlLetterModel records',
	COUNT_BPJS_SEARCH_CONTROL_LETTERS_OK = '[ENTITY] Fetch number of BpjsSearchControlLetterModel records successfully ',
	COUNT_BPJS_SEARCH_CONTROL_LETTERS_FAIL = '[ENTITY] Fetch number of BpjsSearchControlLetterModel records failed',

	IMPORT_BPJS_SEARCH_CONTROL_LETTERS = '[ENTITY] Import BpjsSearchControlLetterModels',
	IMPORT_BPJS_SEARCH_CONTROL_LETTERS_OK = '[ENTITY] Import BpjsSearchControlLetterModels successfully',
	IMPORT_BPJS_SEARCH_CONTROL_LETTERS_FAIL = '[ENTITY] Import BpjsSearchControlLetterModels fail',


	INITIALISE_BPJS_SEARCH_CONTROL_LETTER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSearchControlLetterModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSearchControlLetterAction implements Action {
	readonly className: string = 'BpjsSearchControlLetterModel';

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

export class BpjsSearchControlLetterAction extends BaseBpjsSearchControlLetterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchControlLetterAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchControlLetterAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSearchControlLetterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchControlLetterAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchControlLetterAction here] end
}

export class BpjsSearchControlLetterActionOK extends BaseBpjsSearchControlLetterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchControlLetterActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchControlLetterActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSearchControlLetterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSearchControlLetterModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchControlLetterActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchControlLetterActionOK here] end
}

export class BpjsSearchControlLetterActionFail extends BaseBpjsSearchControlLetterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSearchControlLetterActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSearchControlLetterActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSearchControlLetterModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSearchControlLetterActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSearchControlLetterActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSearchControlLetterActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSearchControlLetterActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSearchControlLetterActionFail here] end
}

export function isBpjsSearchControlLetterModelAction(e: any): e is BaseBpjsSearchControlLetterAction {
	return Object.values(BpjsSearchControlLetterModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
