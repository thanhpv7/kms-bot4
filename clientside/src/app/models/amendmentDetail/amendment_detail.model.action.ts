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
import {AmendmentDetailModel} from './amendment_detail.model';
import {AmendmentDetailModelAudit} from './amendment_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Amendment Detail model actions to be dispatched by NgRx.
 */
export enum AmendmentDetailModelActionTypes {
	CREATE_AMENDMENT_DETAIL = '[ENTITY] Create AmendmentDetailModel',
	CREATE_AMENDMENT_DETAIL_OK = '[ENTITY] Create AmendmentDetailModel successfully',
	CREATE_AMENDMENT_DETAIL_FAIL = '[ENTITY] Create AmendmentDetailModel failed',

	CREATE_ALL_AMENDMENT_DETAIL = '[ENTITY] Create All AmendmentDetailModel',
	CREATE_ALL_AMENDMENT_DETAIL_OK = '[ENTITY] Create All AmendmentDetailModel successfully',
	CREATE_ALL_AMENDMENT_DETAIL_FAIL = '[ENTITY] Create All AmendmentDetailModel failed',

	DELETE_AMENDMENT_DETAIL = '[ENTITY] Delete AmendmentDetailModel',
	DELETE_AMENDMENT_DETAIL_OK = '[ENTITY] Delete AmendmentDetailModel successfully',
	DELETE_AMENDMENT_DETAIL_FAIL = '[ENTITY] Delete AmendmentDetailModel failed',


	DELETE_AMENDMENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete AmendmentDetailModels Excluding Ids',
	DELETE_AMENDMENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete AmendmentDetailModels Excluding Ids successfully',
	DELETE_AMENDMENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete AmendmentDetailModels Excluding Ids failed',

	DELETE_ALL_AMENDMENT_DETAIL = '[ENTITY] Delete all AmendmentDetailModels',
	DELETE_ALL_AMENDMENT_DETAIL_OK = '[ENTITY] Delete all AmendmentDetailModels successfully',
	DELETE_ALL_AMENDMENT_DETAIL_FAIL = '[ENTITY] Delete all AmendmentDetailModels failed',

	UPDATE_AMENDMENT_DETAIL = '[ENTITY] Update AmendmentDetailModel',
	UPDATE_AMENDMENT_DETAIL_OK = '[ENTITY] Update AmendmentDetailModel successfully',
	UPDATE_AMENDMENT_DETAIL_FAIL = '[ENTITY] Update AmendmentDetailModel failed',

	UPDATE_ALL_AMENDMENT_DETAIL = '[ENTITY] Update all AmendmentDetailModel',
	UPDATE_ALL_AMENDMENT_DETAIL_OK = '[ENTITY] Update all AmendmentDetailModel successfully',
	UPDATE_ALL_AMENDMENT_DETAIL_FAIL = '[ENTITY] Update all AmendmentDetailModel failed',

	FETCH_AMENDMENT_DETAIL= '[ENTITY] Fetch AmendmentDetailModel',
	FETCH_AMENDMENT_DETAIL_OK = '[ENTITY] Fetch AmendmentDetailModel successfully',
	FETCH_AMENDMENT_DETAIL_FAIL = '[ENTITY] Fetch AmendmentDetailModel failed',

	FETCH_AMENDMENT_DETAIL_AUDIT= '[ENTITY] Fetch AmendmentDetailModel audit',
	FETCH_AMENDMENT_DETAIL_AUDIT_OK = '[ENTITY] Fetch AmendmentDetailModel audit successfully',
	FETCH_AMENDMENT_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch AmendmentDetailModel audit failed',

	FETCH_AMENDMENT_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch AmendmentDetailModel audits by entity id',
	FETCH_AMENDMENT_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch AmendmentDetailModel audits by entity id successfully',
	FETCH_AMENDMENT_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch AmendmentDetailModel audits by entity id failed',

	FETCH_ALL_AMENDMENT_DETAIL = '[ENTITY] Fetch all AmendmentDetailModel',
	FETCH_ALL_AMENDMENT_DETAIL_OK = '[ENTITY] Fetch all AmendmentDetailModel successfully',
	FETCH_ALL_AMENDMENT_DETAIL_FAIL = '[ENTITY] Fetch all AmendmentDetailModel failed',

	FETCH_AMENDMENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch AmendmentDetailModel with query',
	FETCH_AMENDMENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch AmendmentDetailModel with query successfully',
	FETCH_AMENDMENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch AmendmentDetailModel with query failed',

	FETCH_LAST_AMENDMENT_DETAIL_WITH_QUERY = '[ENTITY] Fetch last AmendmentDetailModel with query',
	FETCH_LAST_AMENDMENT_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last AmendmentDetailModel with query successfully',
	FETCH_LAST_AMENDMENT_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last AmendmentDetailModel with query failed',

	EXPORT_AMENDMENT_DETAIL = '[ENTITY] Export AmendmentDetailModel',
	EXPORT_AMENDMENT_DETAIL_OK = '[ENTITY] Export AmendmentDetailModel successfully',
	EXPORT_AMENDMENT_DETAIL_FAIL = '[ENTITY] Export AmendmentDetailModel failed',

	EXPORT_ALL_AMENDMENT_DETAIL = '[ENTITY] Export All AmendmentDetailModels',
	EXPORT_ALL_AMENDMENT_DETAIL_OK = '[ENTITY] Export All AmendmentDetailModels successfully',
	EXPORT_ALL_AMENDMENT_DETAIL_FAIL = '[ENTITY] Export All AmendmentDetailModels failed',

	EXPORT_AMENDMENT_DETAIL_EXCLUDING_IDS = '[ENTITY] Export AmendmentDetailModels excluding Ids',
	EXPORT_AMENDMENT_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export AmendmentDetailModel excluding Ids successfully',
	EXPORT_AMENDMENT_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export AmendmentDetailModel excluding Ids failed',

	COUNT_AMENDMENT_DETAILS = '[ENTITY] Fetch number of AmendmentDetailModel records',
	COUNT_AMENDMENT_DETAILS_OK = '[ENTITY] Fetch number of AmendmentDetailModel records successfully ',
	COUNT_AMENDMENT_DETAILS_FAIL = '[ENTITY] Fetch number of AmendmentDetailModel records failed',

	IMPORT_AMENDMENT_DETAILS = '[ENTITY] Import AmendmentDetailModels',
	IMPORT_AMENDMENT_DETAILS_OK = '[ENTITY] Import AmendmentDetailModels successfully',
	IMPORT_AMENDMENT_DETAILS_FAIL = '[ENTITY] Import AmendmentDetailModels fail',


	INITIALISE_AMENDMENT_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of AmendmentDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseAmendmentDetailAction implements Action {
	readonly className: string = 'AmendmentDetailModel';

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

export class AmendmentDetailAction extends BaseAmendmentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AmendmentDetailAction here] off begin
	// % protected region % [Add any additional class fields for AmendmentDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AmendmentDetailModel>,
		// % protected region % [Add any additional constructor parameters for AmendmentDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for AmendmentDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AmendmentDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for AmendmentDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AmendmentDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for AmendmentDetailAction here] end
	}

	// % protected region % [Add any additional class methods for AmendmentDetailAction here] off begin
	// % protected region % [Add any additional class methods for AmendmentDetailAction here] end
}

export class AmendmentDetailActionOK extends BaseAmendmentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AmendmentDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for AmendmentDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<AmendmentDetailModel>,
		// % protected region % [Add any additional constructor parameters for AmendmentDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for AmendmentDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: AmendmentDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AmendmentDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for AmendmentDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AmendmentDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for AmendmentDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for AmendmentDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for AmendmentDetailActionOK here] end
}

export class AmendmentDetailActionFail extends BaseAmendmentDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for AmendmentDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for AmendmentDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<AmendmentDetailModel>,
		// % protected region % [Add any additional constructor parameters for AmendmentDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for AmendmentDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for AmendmentDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for AmendmentDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for AmendmentDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for AmendmentDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for AmendmentDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for AmendmentDetailActionFail here] end
}

export function isAmendmentDetailModelAction(e: any): e is BaseAmendmentDetailAction {
	return Object.values(AmendmentDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
