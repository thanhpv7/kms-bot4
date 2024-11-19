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
import {ExaminationItemDetailModel} from './examination_item_detail.model';
import {ExaminationItemDetailModelAudit} from './examination_item_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Examination Item Detail model actions to be dispatched by NgRx.
 */
export enum ExaminationItemDetailModelActionTypes {
	CREATE_EXAMINATION_ITEM_DETAIL = '[ENTITY] Create ExaminationItemDetailModel',
	CREATE_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Create ExaminationItemDetailModel successfully',
	CREATE_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Create ExaminationItemDetailModel failed',

	CREATE_ALL_EXAMINATION_ITEM_DETAIL = '[ENTITY] Create All ExaminationItemDetailModel',
	CREATE_ALL_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Create All ExaminationItemDetailModel successfully',
	CREATE_ALL_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Create All ExaminationItemDetailModel failed',

	DELETE_EXAMINATION_ITEM_DETAIL = '[ENTITY] Delete ExaminationItemDetailModel',
	DELETE_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Delete ExaminationItemDetailModel successfully',
	DELETE_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Delete ExaminationItemDetailModel failed',


	DELETE_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete ExaminationItemDetailModels Excluding Ids',
	DELETE_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete ExaminationItemDetailModels Excluding Ids successfully',
	DELETE_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ExaminationItemDetailModels Excluding Ids failed',

	DELETE_ALL_EXAMINATION_ITEM_DETAIL = '[ENTITY] Delete all ExaminationItemDetailModels',
	DELETE_ALL_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Delete all ExaminationItemDetailModels successfully',
	DELETE_ALL_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Delete all ExaminationItemDetailModels failed',

	UPDATE_EXAMINATION_ITEM_DETAIL = '[ENTITY] Update ExaminationItemDetailModel',
	UPDATE_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Update ExaminationItemDetailModel successfully',
	UPDATE_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Update ExaminationItemDetailModel failed',

	UPDATE_ALL_EXAMINATION_ITEM_DETAIL = '[ENTITY] Update all ExaminationItemDetailModel',
	UPDATE_ALL_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Update all ExaminationItemDetailModel successfully',
	UPDATE_ALL_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Update all ExaminationItemDetailModel failed',

	FETCH_EXAMINATION_ITEM_DETAIL= '[ENTITY] Fetch ExaminationItemDetailModel',
	FETCH_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Fetch ExaminationItemDetailModel successfully',
	FETCH_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Fetch ExaminationItemDetailModel failed',

	FETCH_EXAMINATION_ITEM_DETAIL_AUDIT= '[ENTITY] Fetch ExaminationItemDetailModel audit',
	FETCH_EXAMINATION_ITEM_DETAIL_AUDIT_OK = '[ENTITY] Fetch ExaminationItemDetailModel audit successfully',
	FETCH_EXAMINATION_ITEM_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch ExaminationItemDetailModel audit failed',

	FETCH_EXAMINATION_ITEM_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ExaminationItemDetailModel audits by entity id',
	FETCH_EXAMINATION_ITEM_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ExaminationItemDetailModel audits by entity id successfully',
	FETCH_EXAMINATION_ITEM_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ExaminationItemDetailModel audits by entity id failed',

	FETCH_ALL_EXAMINATION_ITEM_DETAIL = '[ENTITY] Fetch all ExaminationItemDetailModel',
	FETCH_ALL_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Fetch all ExaminationItemDetailModel successfully',
	FETCH_ALL_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Fetch all ExaminationItemDetailModel failed',

	FETCH_EXAMINATION_ITEM_DETAIL_WITH_QUERY = '[ENTITY] Fetch ExaminationItemDetailModel with query',
	FETCH_EXAMINATION_ITEM_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch ExaminationItemDetailModel with query successfully',
	FETCH_EXAMINATION_ITEM_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch ExaminationItemDetailModel with query failed',

	FETCH_LAST_EXAMINATION_ITEM_DETAIL_WITH_QUERY = '[ENTITY] Fetch last ExaminationItemDetailModel with query',
	FETCH_LAST_EXAMINATION_ITEM_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last ExaminationItemDetailModel with query successfully',
	FETCH_LAST_EXAMINATION_ITEM_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last ExaminationItemDetailModel with query failed',

	EXPORT_EXAMINATION_ITEM_DETAIL = '[ENTITY] Export ExaminationItemDetailModel',
	EXPORT_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Export ExaminationItemDetailModel successfully',
	EXPORT_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Export ExaminationItemDetailModel failed',

	EXPORT_ALL_EXAMINATION_ITEM_DETAIL = '[ENTITY] Export All ExaminationItemDetailModels',
	EXPORT_ALL_EXAMINATION_ITEM_DETAIL_OK = '[ENTITY] Export All ExaminationItemDetailModels successfully',
	EXPORT_ALL_EXAMINATION_ITEM_DETAIL_FAIL = '[ENTITY] Export All ExaminationItemDetailModels failed',

	EXPORT_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS = '[ENTITY] Export ExaminationItemDetailModels excluding Ids',
	EXPORT_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export ExaminationItemDetailModel excluding Ids successfully',
	EXPORT_EXAMINATION_ITEM_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export ExaminationItemDetailModel excluding Ids failed',

	COUNT_EXAMINATION_ITEM_DETAILS = '[ENTITY] Fetch number of ExaminationItemDetailModel records',
	COUNT_EXAMINATION_ITEM_DETAILS_OK = '[ENTITY] Fetch number of ExaminationItemDetailModel records successfully ',
	COUNT_EXAMINATION_ITEM_DETAILS_FAIL = '[ENTITY] Fetch number of ExaminationItemDetailModel records failed',

	IMPORT_EXAMINATION_ITEM_DETAILS = '[ENTITY] Import ExaminationItemDetailModels',
	IMPORT_EXAMINATION_ITEM_DETAILS_OK = '[ENTITY] Import ExaminationItemDetailModels successfully',
	IMPORT_EXAMINATION_ITEM_DETAILS_FAIL = '[ENTITY] Import ExaminationItemDetailModels fail',


	INITIALISE_EXAMINATION_ITEM_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ExaminationItemDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseExaminationItemDetailAction implements Action {
	readonly className: string = 'ExaminationItemDetailModel';

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

export class ExaminationItemDetailAction extends BaseExaminationItemDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemDetailAction here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationItemDetailModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailAction here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemDetailAction here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemDetailAction here] end
}

export class ExaminationItemDetailActionOK extends BaseExaminationItemDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationItemDetailModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ExaminationItemDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemDetailActionOK here] end
}

export class ExaminationItemDetailActionFail extends BaseExaminationItemDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ExaminationItemDetailModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemDetailActionFail here] end
}

export function isExaminationItemDetailModelAction(e: any): e is BaseExaminationItemDetailAction {
	return Object.values(ExaminationItemDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
