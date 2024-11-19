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
import {NewbornDetailModel} from './newborn_detail.model';
import {NewbornDetailModelAudit} from './newborn_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Newborn Detail model actions to be dispatched by NgRx.
 */
export enum NewbornDetailModelActionTypes {
	CREATE_NEWBORN_DETAIL = '[ENTITY] Create NewbornDetailModel',
	CREATE_NEWBORN_DETAIL_OK = '[ENTITY] Create NewbornDetailModel successfully',
	CREATE_NEWBORN_DETAIL_FAIL = '[ENTITY] Create NewbornDetailModel failed',

	CREATE_ALL_NEWBORN_DETAIL = '[ENTITY] Create All NewbornDetailModel',
	CREATE_ALL_NEWBORN_DETAIL_OK = '[ENTITY] Create All NewbornDetailModel successfully',
	CREATE_ALL_NEWBORN_DETAIL_FAIL = '[ENTITY] Create All NewbornDetailModel failed',

	DELETE_NEWBORN_DETAIL = '[ENTITY] Delete NewbornDetailModel',
	DELETE_NEWBORN_DETAIL_OK = '[ENTITY] Delete NewbornDetailModel successfully',
	DELETE_NEWBORN_DETAIL_FAIL = '[ENTITY] Delete NewbornDetailModel failed',


	DELETE_NEWBORN_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete NewbornDetailModels Excluding Ids',
	DELETE_NEWBORN_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete NewbornDetailModels Excluding Ids successfully',
	DELETE_NEWBORN_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NewbornDetailModels Excluding Ids failed',

	DELETE_ALL_NEWBORN_DETAIL = '[ENTITY] Delete all NewbornDetailModels',
	DELETE_ALL_NEWBORN_DETAIL_OK = '[ENTITY] Delete all NewbornDetailModels successfully',
	DELETE_ALL_NEWBORN_DETAIL_FAIL = '[ENTITY] Delete all NewbornDetailModels failed',

	UPDATE_NEWBORN_DETAIL = '[ENTITY] Update NewbornDetailModel',
	UPDATE_NEWBORN_DETAIL_OK = '[ENTITY] Update NewbornDetailModel successfully',
	UPDATE_NEWBORN_DETAIL_FAIL = '[ENTITY] Update NewbornDetailModel failed',

	UPDATE_ALL_NEWBORN_DETAIL = '[ENTITY] Update all NewbornDetailModel',
	UPDATE_ALL_NEWBORN_DETAIL_OK = '[ENTITY] Update all NewbornDetailModel successfully',
	UPDATE_ALL_NEWBORN_DETAIL_FAIL = '[ENTITY] Update all NewbornDetailModel failed',

	FETCH_NEWBORN_DETAIL= '[ENTITY] Fetch NewbornDetailModel',
	FETCH_NEWBORN_DETAIL_OK = '[ENTITY] Fetch NewbornDetailModel successfully',
	FETCH_NEWBORN_DETAIL_FAIL = '[ENTITY] Fetch NewbornDetailModel failed',

	FETCH_NEWBORN_DETAIL_AUDIT= '[ENTITY] Fetch NewbornDetailModel audit',
	FETCH_NEWBORN_DETAIL_AUDIT_OK = '[ENTITY] Fetch NewbornDetailModel audit successfully',
	FETCH_NEWBORN_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch NewbornDetailModel audit failed',

	FETCH_NEWBORN_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NewbornDetailModel audits by entity id',
	FETCH_NEWBORN_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NewbornDetailModel audits by entity id successfully',
	FETCH_NEWBORN_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NewbornDetailModel audits by entity id failed',

	FETCH_ALL_NEWBORN_DETAIL = '[ENTITY] Fetch all NewbornDetailModel',
	FETCH_ALL_NEWBORN_DETAIL_OK = '[ENTITY] Fetch all NewbornDetailModel successfully',
	FETCH_ALL_NEWBORN_DETAIL_FAIL = '[ENTITY] Fetch all NewbornDetailModel failed',

	FETCH_NEWBORN_DETAIL_WITH_QUERY = '[ENTITY] Fetch NewbornDetailModel with query',
	FETCH_NEWBORN_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch NewbornDetailModel with query successfully',
	FETCH_NEWBORN_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch NewbornDetailModel with query failed',

	FETCH_LAST_NEWBORN_DETAIL_WITH_QUERY = '[ENTITY] Fetch last NewbornDetailModel with query',
	FETCH_LAST_NEWBORN_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last NewbornDetailModel with query successfully',
	FETCH_LAST_NEWBORN_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last NewbornDetailModel with query failed',

	EXPORT_NEWBORN_DETAIL = '[ENTITY] Export NewbornDetailModel',
	EXPORT_NEWBORN_DETAIL_OK = '[ENTITY] Export NewbornDetailModel successfully',
	EXPORT_NEWBORN_DETAIL_FAIL = '[ENTITY] Export NewbornDetailModel failed',

	EXPORT_ALL_NEWBORN_DETAIL = '[ENTITY] Export All NewbornDetailModels',
	EXPORT_ALL_NEWBORN_DETAIL_OK = '[ENTITY] Export All NewbornDetailModels successfully',
	EXPORT_ALL_NEWBORN_DETAIL_FAIL = '[ENTITY] Export All NewbornDetailModels failed',

	EXPORT_NEWBORN_DETAIL_EXCLUDING_IDS = '[ENTITY] Export NewbornDetailModels excluding Ids',
	EXPORT_NEWBORN_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export NewbornDetailModel excluding Ids successfully',
	EXPORT_NEWBORN_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export NewbornDetailModel excluding Ids failed',

	COUNT_NEWBORN_DETAILS = '[ENTITY] Fetch number of NewbornDetailModel records',
	COUNT_NEWBORN_DETAILS_OK = '[ENTITY] Fetch number of NewbornDetailModel records successfully ',
	COUNT_NEWBORN_DETAILS_FAIL = '[ENTITY] Fetch number of NewbornDetailModel records failed',

	IMPORT_NEWBORN_DETAILS = '[ENTITY] Import NewbornDetailModels',
	IMPORT_NEWBORN_DETAILS_OK = '[ENTITY] Import NewbornDetailModels successfully',
	IMPORT_NEWBORN_DETAILS_FAIL = '[ENTITY] Import NewbornDetailModels fail',


	INITIALISE_NEWBORN_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NewbornDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNewbornDetailAction implements Action {
	readonly className: string = 'NewbornDetailModel';

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

export class NewbornDetailAction extends BaseNewbornDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NewbornDetailAction here] off begin
	// % protected region % [Add any additional class fields for NewbornDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NewbornDetailModel>,
		// % protected region % [Add any additional constructor parameters for NewbornDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for NewbornDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NewbornDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for NewbornDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NewbornDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for NewbornDetailAction here] end
	}

	// % protected region % [Add any additional class methods for NewbornDetailAction here] off begin
	// % protected region % [Add any additional class methods for NewbornDetailAction here] end
}

export class NewbornDetailActionOK extends BaseNewbornDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NewbornDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for NewbornDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NewbornDetailModel>,
		// % protected region % [Add any additional constructor parameters for NewbornDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NewbornDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NewbornDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NewbornDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NewbornDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NewbornDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NewbornDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for NewbornDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for NewbornDetailActionOK here] end
}

export class NewbornDetailActionFail extends BaseNewbornDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NewbornDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for NewbornDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NewbornDetailModel>,
		// % protected region % [Add any additional constructor parameters for NewbornDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NewbornDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NewbornDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NewbornDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NewbornDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NewbornDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for NewbornDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for NewbornDetailActionFail here] end
}

export function isNewbornDetailModelAction(e: any): e is BaseNewbornDetailAction {
	return Object.values(NewbornDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
