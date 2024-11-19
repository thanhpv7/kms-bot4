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
import {JournalModel} from './journal.model';
import {JournalModelAudit} from './journal.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Journal model actions to be dispatched by NgRx.
 */
export enum JournalModelActionTypes {
	CREATE_JOURNAL = '[ENTITY] Create JournalModel',
	CREATE_JOURNAL_OK = '[ENTITY] Create JournalModel successfully',
	CREATE_JOURNAL_FAIL = '[ENTITY] Create JournalModel failed',

	CREATE_ALL_JOURNAL = '[ENTITY] Create All JournalModel',
	CREATE_ALL_JOURNAL_OK = '[ENTITY] Create All JournalModel successfully',
	CREATE_ALL_JOURNAL_FAIL = '[ENTITY] Create All JournalModel failed',

	DELETE_JOURNAL = '[ENTITY] Delete JournalModel',
	DELETE_JOURNAL_OK = '[ENTITY] Delete JournalModel successfully',
	DELETE_JOURNAL_FAIL = '[ENTITY] Delete JournalModel failed',


	DELETE_JOURNAL_EXCLUDING_IDS = '[ENTITY] Delete JournalModels Excluding Ids',
	DELETE_JOURNAL_EXCLUDING_IDS_OK = '[ENTITY] Delete JournalModels Excluding Ids successfully',
	DELETE_JOURNAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete JournalModels Excluding Ids failed',

	DELETE_ALL_JOURNAL = '[ENTITY] Delete all JournalModels',
	DELETE_ALL_JOURNAL_OK = '[ENTITY] Delete all JournalModels successfully',
	DELETE_ALL_JOURNAL_FAIL = '[ENTITY] Delete all JournalModels failed',

	UPDATE_JOURNAL = '[ENTITY] Update JournalModel',
	UPDATE_JOURNAL_OK = '[ENTITY] Update JournalModel successfully',
	UPDATE_JOURNAL_FAIL = '[ENTITY] Update JournalModel failed',

	UPDATE_ALL_JOURNAL = '[ENTITY] Update all JournalModel',
	UPDATE_ALL_JOURNAL_OK = '[ENTITY] Update all JournalModel successfully',
	UPDATE_ALL_JOURNAL_FAIL = '[ENTITY] Update all JournalModel failed',

	FETCH_JOURNAL= '[ENTITY] Fetch JournalModel',
	FETCH_JOURNAL_OK = '[ENTITY] Fetch JournalModel successfully',
	FETCH_JOURNAL_FAIL = '[ENTITY] Fetch JournalModel failed',

	FETCH_JOURNAL_AUDIT= '[ENTITY] Fetch JournalModel audit',
	FETCH_JOURNAL_AUDIT_OK = '[ENTITY] Fetch JournalModel audit successfully',
	FETCH_JOURNAL_AUDIT_FAIL = '[ENTITY] Fetch JournalModel audit failed',

	FETCH_JOURNAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch JournalModel audits by entity id',
	FETCH_JOURNAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch JournalModel audits by entity id successfully',
	FETCH_JOURNAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch JournalModel audits by entity id failed',

	FETCH_ALL_JOURNAL = '[ENTITY] Fetch all JournalModel',
	FETCH_ALL_JOURNAL_OK = '[ENTITY] Fetch all JournalModel successfully',
	FETCH_ALL_JOURNAL_FAIL = '[ENTITY] Fetch all JournalModel failed',

	FETCH_JOURNAL_WITH_QUERY = '[ENTITY] Fetch JournalModel with query',
	FETCH_JOURNAL_WITH_QUERY_OK = '[ENTITY] Fetch JournalModel with query successfully',
	FETCH_JOURNAL_WITH_QUERY_FAIL = '[ENTITY] Fetch JournalModel with query failed',

	FETCH_LAST_JOURNAL_WITH_QUERY = '[ENTITY] Fetch last JournalModel with query',
	FETCH_LAST_JOURNAL_WITH_QUERY_OK = '[ENTITY] Fetch last JournalModel with query successfully',
	FETCH_LAST_JOURNAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last JournalModel with query failed',

	EXPORT_JOURNAL = '[ENTITY] Export JournalModel',
	EXPORT_JOURNAL_OK = '[ENTITY] Export JournalModel successfully',
	EXPORT_JOURNAL_FAIL = '[ENTITY] Export JournalModel failed',

	EXPORT_ALL_JOURNAL = '[ENTITY] Export All JournalModels',
	EXPORT_ALL_JOURNAL_OK = '[ENTITY] Export All JournalModels successfully',
	EXPORT_ALL_JOURNAL_FAIL = '[ENTITY] Export All JournalModels failed',

	EXPORT_JOURNAL_EXCLUDING_IDS = '[ENTITY] Export JournalModels excluding Ids',
	EXPORT_JOURNAL_EXCLUDING_IDS_OK = '[ENTITY] Export JournalModel excluding Ids successfully',
	EXPORT_JOURNAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export JournalModel excluding Ids failed',

	COUNT_JOURNALS = '[ENTITY] Fetch number of JournalModel records',
	COUNT_JOURNALS_OK = '[ENTITY] Fetch number of JournalModel records successfully ',
	COUNT_JOURNALS_FAIL = '[ENTITY] Fetch number of JournalModel records failed',

	IMPORT_JOURNALS = '[ENTITY] Import JournalModels',
	IMPORT_JOURNALS_OK = '[ENTITY] Import JournalModels successfully',
	IMPORT_JOURNALS_FAIL = '[ENTITY] Import JournalModels fail',


	INITIALISE_JOURNAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of JournalModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseJournalAction implements Action {
	readonly className: string = 'JournalModel';

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

export class JournalAction extends BaseJournalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for JournalAction here] off begin
	// % protected region % [Add any additional class fields for JournalAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<JournalModel>,
		// % protected region % [Add any additional constructor parameters for JournalAction here] off begin
		// % protected region % [Add any additional constructor parameters for JournalAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for JournalAction here] off begin
			// % protected region % [Add any additional constructor arguments for JournalAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for JournalAction here] off begin
		// % protected region % [Add any additional constructor logic for JournalAction here] end
	}

	// % protected region % [Add any additional class methods for JournalAction here] off begin
	// % protected region % [Add any additional class methods for JournalAction here] end
}

export class JournalActionOK extends BaseJournalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for JournalActionOK here] off begin
	// % protected region % [Add any additional class fields for JournalActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<JournalModel>,
		// % protected region % [Add any additional constructor parameters for JournalActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for JournalActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: JournalModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for JournalActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for JournalActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for JournalActionOK here] off begin
		// % protected region % [Add any additional constructor logic for JournalActionOK here] end
	}

	// % protected region % [Add any additional class methods for JournalActionOK here] off begin
	// % protected region % [Add any additional class methods for JournalActionOK here] end
}

export class JournalActionFail extends BaseJournalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for JournalActionFail here] off begin
	// % protected region % [Add any additional class fields for JournalActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<JournalModel>,
		// % protected region % [Add any additional constructor parameters for JournalActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for JournalActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for JournalActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for JournalActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for JournalActionFail here] off begin
		// % protected region % [Add any additional constructor logic for JournalActionFail here] end
	}

	// % protected region % [Add any additional class methods for JournalActionFail here] off begin
	// % protected region % [Add any additional class methods for JournalActionFail here] end
}

export function isJournalModelAction(e: any): e is BaseJournalAction {
	return Object.values(JournalModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
