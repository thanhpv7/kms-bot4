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
import {PostOperativeDetailsModel} from './post_operative_details.model';
import {PostOperativeDetailsModelAudit} from './post_operative_details.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Post Operative Details model actions to be dispatched by NgRx.
 */
export enum PostOperativeDetailsModelActionTypes {
	CREATE_POST_OPERATIVE_DETAILS = '[ENTITY] Create PostOperativeDetailsModel',
	CREATE_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Create PostOperativeDetailsModel successfully',
	CREATE_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Create PostOperativeDetailsModel failed',

	CREATE_ALL_POST_OPERATIVE_DETAILS = '[ENTITY] Create All PostOperativeDetailsModel',
	CREATE_ALL_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Create All PostOperativeDetailsModel successfully',
	CREATE_ALL_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Create All PostOperativeDetailsModel failed',

	DELETE_POST_OPERATIVE_DETAILS = '[ENTITY] Delete PostOperativeDetailsModel',
	DELETE_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Delete PostOperativeDetailsModel successfully',
	DELETE_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Delete PostOperativeDetailsModel failed',


	DELETE_POST_OPERATIVE_DETAILS_EXCLUDING_IDS = '[ENTITY] Delete PostOperativeDetailsModels Excluding Ids',
	DELETE_POST_OPERATIVE_DETAILS_EXCLUDING_IDS_OK = '[ENTITY] Delete PostOperativeDetailsModels Excluding Ids successfully',
	DELETE_POST_OPERATIVE_DETAILS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PostOperativeDetailsModels Excluding Ids failed',

	DELETE_ALL_POST_OPERATIVE_DETAILS = '[ENTITY] Delete all PostOperativeDetailsModels',
	DELETE_ALL_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Delete all PostOperativeDetailsModels successfully',
	DELETE_ALL_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Delete all PostOperativeDetailsModels failed',

	UPDATE_POST_OPERATIVE_DETAILS = '[ENTITY] Update PostOperativeDetailsModel',
	UPDATE_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Update PostOperativeDetailsModel successfully',
	UPDATE_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Update PostOperativeDetailsModel failed',

	UPDATE_ALL_POST_OPERATIVE_DETAILS = '[ENTITY] Update all PostOperativeDetailsModel',
	UPDATE_ALL_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Update all PostOperativeDetailsModel successfully',
	UPDATE_ALL_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Update all PostOperativeDetailsModel failed',

	FETCH_POST_OPERATIVE_DETAILS= '[ENTITY] Fetch PostOperativeDetailsModel',
	FETCH_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Fetch PostOperativeDetailsModel successfully',
	FETCH_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Fetch PostOperativeDetailsModel failed',

	FETCH_POST_OPERATIVE_DETAILS_AUDIT= '[ENTITY] Fetch PostOperativeDetailsModel audit',
	FETCH_POST_OPERATIVE_DETAILS_AUDIT_OK = '[ENTITY] Fetch PostOperativeDetailsModel audit successfully',
	FETCH_POST_OPERATIVE_DETAILS_AUDIT_FAIL = '[ENTITY] Fetch PostOperativeDetailsModel audit failed',

	FETCH_POST_OPERATIVE_DETAILS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PostOperativeDetailsModel audits by entity id',
	FETCH_POST_OPERATIVE_DETAILS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PostOperativeDetailsModel audits by entity id successfully',
	FETCH_POST_OPERATIVE_DETAILS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PostOperativeDetailsModel audits by entity id failed',

	FETCH_ALL_POST_OPERATIVE_DETAILS = '[ENTITY] Fetch all PostOperativeDetailsModel',
	FETCH_ALL_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Fetch all PostOperativeDetailsModel successfully',
	FETCH_ALL_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Fetch all PostOperativeDetailsModel failed',

	FETCH_POST_OPERATIVE_DETAILS_WITH_QUERY = '[ENTITY] Fetch PostOperativeDetailsModel with query',
	FETCH_POST_OPERATIVE_DETAILS_WITH_QUERY_OK = '[ENTITY] Fetch PostOperativeDetailsModel with query successfully',
	FETCH_POST_OPERATIVE_DETAILS_WITH_QUERY_FAIL = '[ENTITY] Fetch PostOperativeDetailsModel with query failed',

	FETCH_LAST_POST_OPERATIVE_DETAILS_WITH_QUERY = '[ENTITY] Fetch last PostOperativeDetailsModel with query',
	FETCH_LAST_POST_OPERATIVE_DETAILS_WITH_QUERY_OK = '[ENTITY] Fetch last PostOperativeDetailsModel with query successfully',
	FETCH_LAST_POST_OPERATIVE_DETAILS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PostOperativeDetailsModel with query failed',

	EXPORT_POST_OPERATIVE_DETAILS = '[ENTITY] Export PostOperativeDetailsModel',
	EXPORT_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Export PostOperativeDetailsModel successfully',
	EXPORT_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Export PostOperativeDetailsModel failed',

	EXPORT_ALL_POST_OPERATIVE_DETAILS = '[ENTITY] Export All PostOperativeDetailsModels',
	EXPORT_ALL_POST_OPERATIVE_DETAILS_OK = '[ENTITY] Export All PostOperativeDetailsModels successfully',
	EXPORT_ALL_POST_OPERATIVE_DETAILS_FAIL = '[ENTITY] Export All PostOperativeDetailsModels failed',

	EXPORT_POST_OPERATIVE_DETAILS_EXCLUDING_IDS = '[ENTITY] Export PostOperativeDetailsModels excluding Ids',
	EXPORT_POST_OPERATIVE_DETAILS_EXCLUDING_IDS_OK = '[ENTITY] Export PostOperativeDetailsModel excluding Ids successfully',
	EXPORT_POST_OPERATIVE_DETAILS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PostOperativeDetailsModel excluding Ids failed',

	COUNT_POST_OPERATIVE_DETAILSS = '[ENTITY] Fetch number of PostOperativeDetailsModel records',
	COUNT_POST_OPERATIVE_DETAILSS_OK = '[ENTITY] Fetch number of PostOperativeDetailsModel records successfully ',
	COUNT_POST_OPERATIVE_DETAILSS_FAIL = '[ENTITY] Fetch number of PostOperativeDetailsModel records failed',

	IMPORT_POST_OPERATIVE_DETAILSS = '[ENTITY] Import PostOperativeDetailsModels',
	IMPORT_POST_OPERATIVE_DETAILSS_OK = '[ENTITY] Import PostOperativeDetailsModels successfully',
	IMPORT_POST_OPERATIVE_DETAILSS_FAIL = '[ENTITY] Import PostOperativeDetailsModels fail',


	INITIALISE_POST_OPERATIVE_DETAILS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PostOperativeDetailsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePostOperativeDetailsAction implements Action {
	readonly className: string = 'PostOperativeDetailsModel';

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

export class PostOperativeDetailsAction extends BasePostOperativeDetailsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PostOperativeDetailsAction here] off begin
	// % protected region % [Add any additional class fields for PostOperativeDetailsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PostOperativeDetailsModel>,
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsAction here] off begin
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsAction here] off begin
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsAction here] off begin
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsAction here] end
	}

	// % protected region % [Add any additional class methods for PostOperativeDetailsAction here] off begin
	// % protected region % [Add any additional class methods for PostOperativeDetailsAction here] end
}

export class PostOperativeDetailsActionOK extends BasePostOperativeDetailsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PostOperativeDetailsActionOK here] off begin
	// % protected region % [Add any additional class fields for PostOperativeDetailsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PostOperativeDetailsModel>,
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PostOperativeDetailsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsActionOK here] end
	}

	// % protected region % [Add any additional class methods for PostOperativeDetailsActionOK here] off begin
	// % protected region % [Add any additional class methods for PostOperativeDetailsActionOK here] end
}

export class PostOperativeDetailsActionFail extends BasePostOperativeDetailsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PostOperativeDetailsActionFail here] off begin
	// % protected region % [Add any additional class fields for PostOperativeDetailsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PostOperativeDetailsModel>,
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PostOperativeDetailsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PostOperativeDetailsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PostOperativeDetailsActionFail here] end
	}

	// % protected region % [Add any additional class methods for PostOperativeDetailsActionFail here] off begin
	// % protected region % [Add any additional class methods for PostOperativeDetailsActionFail here] end
}

export function isPostOperativeDetailsModelAction(e: any): e is BasePostOperativeDetailsAction {
	return Object.values(PostOperativeDetailsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
