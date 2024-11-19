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
import {NumberingSetupModel} from './numbering_setup.model';
import {NumberingSetupModelAudit} from './numbering_setup.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Numbering Setup model actions to be dispatched by NgRx.
 */
export enum NumberingSetupModelActionTypes {
	CREATE_NUMBERING_SETUP = '[ENTITY] Create NumberingSetupModel',
	CREATE_NUMBERING_SETUP_OK = '[ENTITY] Create NumberingSetupModel successfully',
	CREATE_NUMBERING_SETUP_FAIL = '[ENTITY] Create NumberingSetupModel failed',

	CREATE_ALL_NUMBERING_SETUP = '[ENTITY] Create All NumberingSetupModel',
	CREATE_ALL_NUMBERING_SETUP_OK = '[ENTITY] Create All NumberingSetupModel successfully',
	CREATE_ALL_NUMBERING_SETUP_FAIL = '[ENTITY] Create All NumberingSetupModel failed',

	DELETE_NUMBERING_SETUP = '[ENTITY] Delete NumberingSetupModel',
	DELETE_NUMBERING_SETUP_OK = '[ENTITY] Delete NumberingSetupModel successfully',
	DELETE_NUMBERING_SETUP_FAIL = '[ENTITY] Delete NumberingSetupModel failed',


	DELETE_NUMBERING_SETUP_EXCLUDING_IDS = '[ENTITY] Delete NumberingSetupModels Excluding Ids',
	DELETE_NUMBERING_SETUP_EXCLUDING_IDS_OK = '[ENTITY] Delete NumberingSetupModels Excluding Ids successfully',
	DELETE_NUMBERING_SETUP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NumberingSetupModels Excluding Ids failed',

	DELETE_ALL_NUMBERING_SETUP = '[ENTITY] Delete all NumberingSetupModels',
	DELETE_ALL_NUMBERING_SETUP_OK = '[ENTITY] Delete all NumberingSetupModels successfully',
	DELETE_ALL_NUMBERING_SETUP_FAIL = '[ENTITY] Delete all NumberingSetupModels failed',

	UPDATE_NUMBERING_SETUP = '[ENTITY] Update NumberingSetupModel',
	UPDATE_NUMBERING_SETUP_OK = '[ENTITY] Update NumberingSetupModel successfully',
	UPDATE_NUMBERING_SETUP_FAIL = '[ENTITY] Update NumberingSetupModel failed',

	UPDATE_ALL_NUMBERING_SETUP = '[ENTITY] Update all NumberingSetupModel',
	UPDATE_ALL_NUMBERING_SETUP_OK = '[ENTITY] Update all NumberingSetupModel successfully',
	UPDATE_ALL_NUMBERING_SETUP_FAIL = '[ENTITY] Update all NumberingSetupModel failed',

	FETCH_NUMBERING_SETUP= '[ENTITY] Fetch NumberingSetupModel',
	FETCH_NUMBERING_SETUP_OK = '[ENTITY] Fetch NumberingSetupModel successfully',
	FETCH_NUMBERING_SETUP_FAIL = '[ENTITY] Fetch NumberingSetupModel failed',

	FETCH_NUMBERING_SETUP_AUDIT= '[ENTITY] Fetch NumberingSetupModel audit',
	FETCH_NUMBERING_SETUP_AUDIT_OK = '[ENTITY] Fetch NumberingSetupModel audit successfully',
	FETCH_NUMBERING_SETUP_AUDIT_FAIL = '[ENTITY] Fetch NumberingSetupModel audit failed',

	FETCH_NUMBERING_SETUP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NumberingSetupModel audits by entity id',
	FETCH_NUMBERING_SETUP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NumberingSetupModel audits by entity id successfully',
	FETCH_NUMBERING_SETUP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NumberingSetupModel audits by entity id failed',

	FETCH_ALL_NUMBERING_SETUP = '[ENTITY] Fetch all NumberingSetupModel',
	FETCH_ALL_NUMBERING_SETUP_OK = '[ENTITY] Fetch all NumberingSetupModel successfully',
	FETCH_ALL_NUMBERING_SETUP_FAIL = '[ENTITY] Fetch all NumberingSetupModel failed',

	FETCH_NUMBERING_SETUP_WITH_QUERY = '[ENTITY] Fetch NumberingSetupModel with query',
	FETCH_NUMBERING_SETUP_WITH_QUERY_OK = '[ENTITY] Fetch NumberingSetupModel with query successfully',
	FETCH_NUMBERING_SETUP_WITH_QUERY_FAIL = '[ENTITY] Fetch NumberingSetupModel with query failed',

	FETCH_LAST_NUMBERING_SETUP_WITH_QUERY = '[ENTITY] Fetch last NumberingSetupModel with query',
	FETCH_LAST_NUMBERING_SETUP_WITH_QUERY_OK = '[ENTITY] Fetch last NumberingSetupModel with query successfully',
	FETCH_LAST_NUMBERING_SETUP_WITH_QUERY_FAIL = '[ENTITY] Fetch last NumberingSetupModel with query failed',

	EXPORT_NUMBERING_SETUP = '[ENTITY] Export NumberingSetupModel',
	EXPORT_NUMBERING_SETUP_OK = '[ENTITY] Export NumberingSetupModel successfully',
	EXPORT_NUMBERING_SETUP_FAIL = '[ENTITY] Export NumberingSetupModel failed',

	EXPORT_ALL_NUMBERING_SETUP = '[ENTITY] Export All NumberingSetupModels',
	EXPORT_ALL_NUMBERING_SETUP_OK = '[ENTITY] Export All NumberingSetupModels successfully',
	EXPORT_ALL_NUMBERING_SETUP_FAIL = '[ENTITY] Export All NumberingSetupModels failed',

	EXPORT_NUMBERING_SETUP_EXCLUDING_IDS = '[ENTITY] Export NumberingSetupModels excluding Ids',
	EXPORT_NUMBERING_SETUP_EXCLUDING_IDS_OK = '[ENTITY] Export NumberingSetupModel excluding Ids successfully',
	EXPORT_NUMBERING_SETUP_EXCLUDING_IDS_FAIL = '[ENTITY] Export NumberingSetupModel excluding Ids failed',

	COUNT_NUMBERING_SETUPS = '[ENTITY] Fetch number of NumberingSetupModel records',
	COUNT_NUMBERING_SETUPS_OK = '[ENTITY] Fetch number of NumberingSetupModel records successfully ',
	COUNT_NUMBERING_SETUPS_FAIL = '[ENTITY] Fetch number of NumberingSetupModel records failed',

	IMPORT_NUMBERING_SETUPS = '[ENTITY] Import NumberingSetupModels',
	IMPORT_NUMBERING_SETUPS_OK = '[ENTITY] Import NumberingSetupModels successfully',
	IMPORT_NUMBERING_SETUPS_FAIL = '[ENTITY] Import NumberingSetupModels fail',


	INITIALISE_NUMBERING_SETUP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NumberingSetupModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNumberingSetupAction implements Action {
	readonly className: string = 'NumberingSetupModel';

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

export class NumberingSetupAction extends BaseNumberingSetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NumberingSetupAction here] off begin
	// % protected region % [Add any additional class fields for NumberingSetupAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NumberingSetupModel>,
		// % protected region % [Add any additional constructor parameters for NumberingSetupAction here] off begin
		// % protected region % [Add any additional constructor parameters for NumberingSetupAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NumberingSetupAction here] off begin
			// % protected region % [Add any additional constructor arguments for NumberingSetupAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NumberingSetupAction here] off begin
		// % protected region % [Add any additional constructor logic for NumberingSetupAction here] end
	}

	// % protected region % [Add any additional class methods for NumberingSetupAction here] off begin
	// % protected region % [Add any additional class methods for NumberingSetupAction here] end
}

export class NumberingSetupActionOK extends BaseNumberingSetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NumberingSetupActionOK here] off begin
	// % protected region % [Add any additional class fields for NumberingSetupActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NumberingSetupModel>,
		// % protected region % [Add any additional constructor parameters for NumberingSetupActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NumberingSetupActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NumberingSetupModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NumberingSetupActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NumberingSetupActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NumberingSetupActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NumberingSetupActionOK here] end
	}

	// % protected region % [Add any additional class methods for NumberingSetupActionOK here] off begin
	// % protected region % [Add any additional class methods for NumberingSetupActionOK here] end
}

export class NumberingSetupActionFail extends BaseNumberingSetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NumberingSetupActionFail here] off begin
	// % protected region % [Add any additional class fields for NumberingSetupActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NumberingSetupModel>,
		// % protected region % [Add any additional constructor parameters for NumberingSetupActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NumberingSetupActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NumberingSetupActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NumberingSetupActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NumberingSetupActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NumberingSetupActionFail here] end
	}

	// % protected region % [Add any additional class methods for NumberingSetupActionFail here] off begin
	// % protected region % [Add any additional class methods for NumberingSetupActionFail here] end
}

export function isNumberingSetupModelAction(e: any): e is BaseNumberingSetupAction {
	return Object.values(NumberingSetupModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
