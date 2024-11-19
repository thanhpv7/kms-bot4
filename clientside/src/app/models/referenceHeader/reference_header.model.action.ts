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
import {ReferenceHeaderModel} from './reference_header.model';
import {ReferenceHeaderModelAudit} from './reference_header.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Reference Header model actions to be dispatched by NgRx.
 */
export enum ReferenceHeaderModelActionTypes {
	CREATE_REFERENCE_HEADER = '[ENTITY] Create ReferenceHeaderModel',
	CREATE_REFERENCE_HEADER_OK = '[ENTITY] Create ReferenceHeaderModel successfully',
	CREATE_REFERENCE_HEADER_FAIL = '[ENTITY] Create ReferenceHeaderModel failed',

	CREATE_ALL_REFERENCE_HEADER = '[ENTITY] Create All ReferenceHeaderModel',
	CREATE_ALL_REFERENCE_HEADER_OK = '[ENTITY] Create All ReferenceHeaderModel successfully',
	CREATE_ALL_REFERENCE_HEADER_FAIL = '[ENTITY] Create All ReferenceHeaderModel failed',

	DELETE_REFERENCE_HEADER = '[ENTITY] Delete ReferenceHeaderModel',
	DELETE_REFERENCE_HEADER_OK = '[ENTITY] Delete ReferenceHeaderModel successfully',
	DELETE_REFERENCE_HEADER_FAIL = '[ENTITY] Delete ReferenceHeaderModel failed',


	DELETE_REFERENCE_HEADER_EXCLUDING_IDS = '[ENTITY] Delete ReferenceHeaderModels Excluding Ids',
	DELETE_REFERENCE_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Delete ReferenceHeaderModels Excluding Ids successfully',
	DELETE_REFERENCE_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ReferenceHeaderModels Excluding Ids failed',

	DELETE_ALL_REFERENCE_HEADER = '[ENTITY] Delete all ReferenceHeaderModels',
	DELETE_ALL_REFERENCE_HEADER_OK = '[ENTITY] Delete all ReferenceHeaderModels successfully',
	DELETE_ALL_REFERENCE_HEADER_FAIL = '[ENTITY] Delete all ReferenceHeaderModels failed',

	UPDATE_REFERENCE_HEADER = '[ENTITY] Update ReferenceHeaderModel',
	UPDATE_REFERENCE_HEADER_OK = '[ENTITY] Update ReferenceHeaderModel successfully',
	UPDATE_REFERENCE_HEADER_FAIL = '[ENTITY] Update ReferenceHeaderModel failed',

	UPDATE_ALL_REFERENCE_HEADER = '[ENTITY] Update all ReferenceHeaderModel',
	UPDATE_ALL_REFERENCE_HEADER_OK = '[ENTITY] Update all ReferenceHeaderModel successfully',
	UPDATE_ALL_REFERENCE_HEADER_FAIL = '[ENTITY] Update all ReferenceHeaderModel failed',

	FETCH_REFERENCE_HEADER= '[ENTITY] Fetch ReferenceHeaderModel',
	FETCH_REFERENCE_HEADER_OK = '[ENTITY] Fetch ReferenceHeaderModel successfully',
	FETCH_REFERENCE_HEADER_FAIL = '[ENTITY] Fetch ReferenceHeaderModel failed',

	FETCH_REFERENCE_HEADER_AUDIT= '[ENTITY] Fetch ReferenceHeaderModel audit',
	FETCH_REFERENCE_HEADER_AUDIT_OK = '[ENTITY] Fetch ReferenceHeaderModel audit successfully',
	FETCH_REFERENCE_HEADER_AUDIT_FAIL = '[ENTITY] Fetch ReferenceHeaderModel audit failed',

	FETCH_REFERENCE_HEADER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ReferenceHeaderModel audits by entity id',
	FETCH_REFERENCE_HEADER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ReferenceHeaderModel audits by entity id successfully',
	FETCH_REFERENCE_HEADER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ReferenceHeaderModel audits by entity id failed',

	FETCH_ALL_REFERENCE_HEADER = '[ENTITY] Fetch all ReferenceHeaderModel',
	FETCH_ALL_REFERENCE_HEADER_OK = '[ENTITY] Fetch all ReferenceHeaderModel successfully',
	FETCH_ALL_REFERENCE_HEADER_FAIL = '[ENTITY] Fetch all ReferenceHeaderModel failed',

	FETCH_REFERENCE_HEADER_WITH_QUERY = '[ENTITY] Fetch ReferenceHeaderModel with query',
	FETCH_REFERENCE_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch ReferenceHeaderModel with query successfully',
	FETCH_REFERENCE_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch ReferenceHeaderModel with query failed',

	FETCH_LAST_REFERENCE_HEADER_WITH_QUERY = '[ENTITY] Fetch last ReferenceHeaderModel with query',
	FETCH_LAST_REFERENCE_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch last ReferenceHeaderModel with query successfully',
	FETCH_LAST_REFERENCE_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch last ReferenceHeaderModel with query failed',

	EXPORT_REFERENCE_HEADER = '[ENTITY] Export ReferenceHeaderModel',
	EXPORT_REFERENCE_HEADER_OK = '[ENTITY] Export ReferenceHeaderModel successfully',
	EXPORT_REFERENCE_HEADER_FAIL = '[ENTITY] Export ReferenceHeaderModel failed',

	EXPORT_ALL_REFERENCE_HEADER = '[ENTITY] Export All ReferenceHeaderModels',
	EXPORT_ALL_REFERENCE_HEADER_OK = '[ENTITY] Export All ReferenceHeaderModels successfully',
	EXPORT_ALL_REFERENCE_HEADER_FAIL = '[ENTITY] Export All ReferenceHeaderModels failed',

	EXPORT_REFERENCE_HEADER_EXCLUDING_IDS = '[ENTITY] Export ReferenceHeaderModels excluding Ids',
	EXPORT_REFERENCE_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Export ReferenceHeaderModel excluding Ids successfully',
	EXPORT_REFERENCE_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Export ReferenceHeaderModel excluding Ids failed',

	COUNT_REFERENCE_HEADERS = '[ENTITY] Fetch number of ReferenceHeaderModel records',
	COUNT_REFERENCE_HEADERS_OK = '[ENTITY] Fetch number of ReferenceHeaderModel records successfully ',
	COUNT_REFERENCE_HEADERS_FAIL = '[ENTITY] Fetch number of ReferenceHeaderModel records failed',

	IMPORT_REFERENCE_HEADERS = '[ENTITY] Import ReferenceHeaderModels',
	IMPORT_REFERENCE_HEADERS_OK = '[ENTITY] Import ReferenceHeaderModels successfully',
	IMPORT_REFERENCE_HEADERS_FAIL = '[ENTITY] Import ReferenceHeaderModels fail',


	INITIALISE_REFERENCE_HEADER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ReferenceHeaderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseReferenceHeaderAction implements Action {
	readonly className: string = 'ReferenceHeaderModel';

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

export class ReferenceHeaderAction extends BaseReferenceHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceHeaderAction here] off begin
	// % protected region % [Add any additional class fields for ReferenceHeaderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReferenceHeaderModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderAction here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderAction here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceHeaderAction here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceHeaderAction here] end
	}

	// % protected region % [Add any additional class methods for ReferenceHeaderAction here] off begin
	// % protected region % [Add any additional class methods for ReferenceHeaderAction here] end
}

export class ReferenceHeaderActionOK extends BaseReferenceHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceHeaderActionOK here] off begin
	// % protected region % [Add any additional class fields for ReferenceHeaderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReferenceHeaderModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ReferenceHeaderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceHeaderActionOK here] end
	}

	// % protected region % [Add any additional class methods for ReferenceHeaderActionOK here] off begin
	// % protected region % [Add any additional class methods for ReferenceHeaderActionOK here] end
}

export class ReferenceHeaderActionFail extends BaseReferenceHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceHeaderActionFail here] off begin
	// % protected region % [Add any additional class fields for ReferenceHeaderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ReferenceHeaderModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceHeaderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceHeaderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceHeaderActionFail here] end
	}

	// % protected region % [Add any additional class methods for ReferenceHeaderActionFail here] off begin
	// % protected region % [Add any additional class methods for ReferenceHeaderActionFail here] end
}

export function isReferenceHeaderModelAction(e: any): e is BaseReferenceHeaderAction {
	return Object.values(ReferenceHeaderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
