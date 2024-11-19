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
import {LibraryModel} from './library.model';
import {LibraryModelAudit} from './library.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Library model actions to be dispatched by NgRx.
 */
export enum LibraryModelActionTypes {
	CREATE_LIBRARY = '[ENTITY] Create LibraryModel',
	CREATE_LIBRARY_OK = '[ENTITY] Create LibraryModel successfully',
	CREATE_LIBRARY_FAIL = '[ENTITY] Create LibraryModel failed',

	CREATE_ALL_LIBRARY = '[ENTITY] Create All LibraryModel',
	CREATE_ALL_LIBRARY_OK = '[ENTITY] Create All LibraryModel successfully',
	CREATE_ALL_LIBRARY_FAIL = '[ENTITY] Create All LibraryModel failed',

	DELETE_LIBRARY = '[ENTITY] Delete LibraryModel',
	DELETE_LIBRARY_OK = '[ENTITY] Delete LibraryModel successfully',
	DELETE_LIBRARY_FAIL = '[ENTITY] Delete LibraryModel failed',


	DELETE_LIBRARY_EXCLUDING_IDS = '[ENTITY] Delete LibraryModels Excluding Ids',
	DELETE_LIBRARY_EXCLUDING_IDS_OK = '[ENTITY] Delete LibraryModels Excluding Ids successfully',
	DELETE_LIBRARY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete LibraryModels Excluding Ids failed',

	DELETE_ALL_LIBRARY = '[ENTITY] Delete all LibraryModels',
	DELETE_ALL_LIBRARY_OK = '[ENTITY] Delete all LibraryModels successfully',
	DELETE_ALL_LIBRARY_FAIL = '[ENTITY] Delete all LibraryModels failed',

	UPDATE_LIBRARY = '[ENTITY] Update LibraryModel',
	UPDATE_LIBRARY_OK = '[ENTITY] Update LibraryModel successfully',
	UPDATE_LIBRARY_FAIL = '[ENTITY] Update LibraryModel failed',

	UPDATE_ALL_LIBRARY = '[ENTITY] Update all LibraryModel',
	UPDATE_ALL_LIBRARY_OK = '[ENTITY] Update all LibraryModel successfully',
	UPDATE_ALL_LIBRARY_FAIL = '[ENTITY] Update all LibraryModel failed',

	FETCH_LIBRARY= '[ENTITY] Fetch LibraryModel',
	FETCH_LIBRARY_OK = '[ENTITY] Fetch LibraryModel successfully',
	FETCH_LIBRARY_FAIL = '[ENTITY] Fetch LibraryModel failed',

	FETCH_LIBRARY_AUDIT= '[ENTITY] Fetch LibraryModel audit',
	FETCH_LIBRARY_AUDIT_OK = '[ENTITY] Fetch LibraryModel audit successfully',
	FETCH_LIBRARY_AUDIT_FAIL = '[ENTITY] Fetch LibraryModel audit failed',

	FETCH_LIBRARY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch LibraryModel audits by entity id',
	FETCH_LIBRARY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch LibraryModel audits by entity id successfully',
	FETCH_LIBRARY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch LibraryModel audits by entity id failed',

	FETCH_ALL_LIBRARY = '[ENTITY] Fetch all LibraryModel',
	FETCH_ALL_LIBRARY_OK = '[ENTITY] Fetch all LibraryModel successfully',
	FETCH_ALL_LIBRARY_FAIL = '[ENTITY] Fetch all LibraryModel failed',

	FETCH_LIBRARY_WITH_QUERY = '[ENTITY] Fetch LibraryModel with query',
	FETCH_LIBRARY_WITH_QUERY_OK = '[ENTITY] Fetch LibraryModel with query successfully',
	FETCH_LIBRARY_WITH_QUERY_FAIL = '[ENTITY] Fetch LibraryModel with query failed',

	FETCH_LAST_LIBRARY_WITH_QUERY = '[ENTITY] Fetch last LibraryModel with query',
	FETCH_LAST_LIBRARY_WITH_QUERY_OK = '[ENTITY] Fetch last LibraryModel with query successfully',
	FETCH_LAST_LIBRARY_WITH_QUERY_FAIL = '[ENTITY] Fetch last LibraryModel with query failed',

	EXPORT_LIBRARY = '[ENTITY] Export LibraryModel',
	EXPORT_LIBRARY_OK = '[ENTITY] Export LibraryModel successfully',
	EXPORT_LIBRARY_FAIL = '[ENTITY] Export LibraryModel failed',

	EXPORT_ALL_LIBRARY = '[ENTITY] Export All LibraryModels',
	EXPORT_ALL_LIBRARY_OK = '[ENTITY] Export All LibraryModels successfully',
	EXPORT_ALL_LIBRARY_FAIL = '[ENTITY] Export All LibraryModels failed',

	EXPORT_LIBRARY_EXCLUDING_IDS = '[ENTITY] Export LibraryModels excluding Ids',
	EXPORT_LIBRARY_EXCLUDING_IDS_OK = '[ENTITY] Export LibraryModel excluding Ids successfully',
	EXPORT_LIBRARY_EXCLUDING_IDS_FAIL = '[ENTITY] Export LibraryModel excluding Ids failed',

	COUNT_LIBRARYS = '[ENTITY] Fetch number of LibraryModel records',
	COUNT_LIBRARYS_OK = '[ENTITY] Fetch number of LibraryModel records successfully ',
	COUNT_LIBRARYS_FAIL = '[ENTITY] Fetch number of LibraryModel records failed',

	IMPORT_LIBRARYS = '[ENTITY] Import LibraryModels',
	IMPORT_LIBRARYS_OK = '[ENTITY] Import LibraryModels successfully',
	IMPORT_LIBRARYS_FAIL = '[ENTITY] Import LibraryModels fail',


	INITIALISE_LIBRARY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of LibraryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseLibraryAction implements Action {
	readonly className: string = 'LibraryModel';

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

export class LibraryAction extends BaseLibraryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LibraryAction here] off begin
	// % protected region % [Add any additional class fields for LibraryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<LibraryModel>,
		// % protected region % [Add any additional constructor parameters for LibraryAction here] off begin
		// % protected region % [Add any additional constructor parameters for LibraryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LibraryAction here] off begin
			// % protected region % [Add any additional constructor arguments for LibraryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LibraryAction here] off begin
		// % protected region % [Add any additional constructor logic for LibraryAction here] end
	}

	// % protected region % [Add any additional class methods for LibraryAction here] off begin
	// % protected region % [Add any additional class methods for LibraryAction here] end
}

export class LibraryActionOK extends BaseLibraryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LibraryActionOK here] off begin
	// % protected region % [Add any additional class fields for LibraryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<LibraryModel>,
		// % protected region % [Add any additional constructor parameters for LibraryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for LibraryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: LibraryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LibraryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for LibraryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LibraryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for LibraryActionOK here] end
	}

	// % protected region % [Add any additional class methods for LibraryActionOK here] off begin
	// % protected region % [Add any additional class methods for LibraryActionOK here] end
}

export class LibraryActionFail extends BaseLibraryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LibraryActionFail here] off begin
	// % protected region % [Add any additional class fields for LibraryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<LibraryModel>,
		// % protected region % [Add any additional constructor parameters for LibraryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for LibraryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LibraryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for LibraryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LibraryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for LibraryActionFail here] end
	}

	// % protected region % [Add any additional class methods for LibraryActionFail here] off begin
	// % protected region % [Add any additional class methods for LibraryActionFail here] end
}

export function isLibraryModelAction(e: any): e is BaseLibraryAction {
	return Object.values(LibraryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
