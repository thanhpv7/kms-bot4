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
import {ExaminationItemModel} from './examination_item.model';
import {ExaminationItemModelAudit} from './examination_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Examination Item model actions to be dispatched by NgRx.
 */
export enum ExaminationItemModelActionTypes {
	CREATE_EXAMINATION_ITEM = '[ENTITY] Create ExaminationItemModel',
	CREATE_EXAMINATION_ITEM_OK = '[ENTITY] Create ExaminationItemModel successfully',
	CREATE_EXAMINATION_ITEM_FAIL = '[ENTITY] Create ExaminationItemModel failed',

	CREATE_ALL_EXAMINATION_ITEM = '[ENTITY] Create All ExaminationItemModel',
	CREATE_ALL_EXAMINATION_ITEM_OK = '[ENTITY] Create All ExaminationItemModel successfully',
	CREATE_ALL_EXAMINATION_ITEM_FAIL = '[ENTITY] Create All ExaminationItemModel failed',

	DELETE_EXAMINATION_ITEM = '[ENTITY] Delete ExaminationItemModel',
	DELETE_EXAMINATION_ITEM_OK = '[ENTITY] Delete ExaminationItemModel successfully',
	DELETE_EXAMINATION_ITEM_FAIL = '[ENTITY] Delete ExaminationItemModel failed',


	DELETE_EXAMINATION_ITEM_EXCLUDING_IDS = '[ENTITY] Delete ExaminationItemModels Excluding Ids',
	DELETE_EXAMINATION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete ExaminationItemModels Excluding Ids successfully',
	DELETE_EXAMINATION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ExaminationItemModels Excluding Ids failed',

	DELETE_ALL_EXAMINATION_ITEM = '[ENTITY] Delete all ExaminationItemModels',
	DELETE_ALL_EXAMINATION_ITEM_OK = '[ENTITY] Delete all ExaminationItemModels successfully',
	DELETE_ALL_EXAMINATION_ITEM_FAIL = '[ENTITY] Delete all ExaminationItemModels failed',

	UPDATE_EXAMINATION_ITEM = '[ENTITY] Update ExaminationItemModel',
	UPDATE_EXAMINATION_ITEM_OK = '[ENTITY] Update ExaminationItemModel successfully',
	UPDATE_EXAMINATION_ITEM_FAIL = '[ENTITY] Update ExaminationItemModel failed',

	UPDATE_ALL_EXAMINATION_ITEM = '[ENTITY] Update all ExaminationItemModel',
	UPDATE_ALL_EXAMINATION_ITEM_OK = '[ENTITY] Update all ExaminationItemModel successfully',
	UPDATE_ALL_EXAMINATION_ITEM_FAIL = '[ENTITY] Update all ExaminationItemModel failed',

	FETCH_EXAMINATION_ITEM= '[ENTITY] Fetch ExaminationItemModel',
	FETCH_EXAMINATION_ITEM_OK = '[ENTITY] Fetch ExaminationItemModel successfully',
	FETCH_EXAMINATION_ITEM_FAIL = '[ENTITY] Fetch ExaminationItemModel failed',

	FETCH_EXAMINATION_ITEM_AUDIT= '[ENTITY] Fetch ExaminationItemModel audit',
	FETCH_EXAMINATION_ITEM_AUDIT_OK = '[ENTITY] Fetch ExaminationItemModel audit successfully',
	FETCH_EXAMINATION_ITEM_AUDIT_FAIL = '[ENTITY] Fetch ExaminationItemModel audit failed',

	FETCH_EXAMINATION_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ExaminationItemModel audits by entity id',
	FETCH_EXAMINATION_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ExaminationItemModel audits by entity id successfully',
	FETCH_EXAMINATION_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ExaminationItemModel audits by entity id failed',

	FETCH_ALL_EXAMINATION_ITEM = '[ENTITY] Fetch all ExaminationItemModel',
	FETCH_ALL_EXAMINATION_ITEM_OK = '[ENTITY] Fetch all ExaminationItemModel successfully',
	FETCH_ALL_EXAMINATION_ITEM_FAIL = '[ENTITY] Fetch all ExaminationItemModel failed',

	FETCH_EXAMINATION_ITEM_WITH_QUERY = '[ENTITY] Fetch ExaminationItemModel with query',
	FETCH_EXAMINATION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch ExaminationItemModel with query successfully',
	FETCH_EXAMINATION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch ExaminationItemModel with query failed',

	FETCH_LAST_EXAMINATION_ITEM_WITH_QUERY = '[ENTITY] Fetch last ExaminationItemModel with query',
	FETCH_LAST_EXAMINATION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last ExaminationItemModel with query successfully',
	FETCH_LAST_EXAMINATION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last ExaminationItemModel with query failed',

	EXPORT_EXAMINATION_ITEM = '[ENTITY] Export ExaminationItemModel',
	EXPORT_EXAMINATION_ITEM_OK = '[ENTITY] Export ExaminationItemModel successfully',
	EXPORT_EXAMINATION_ITEM_FAIL = '[ENTITY] Export ExaminationItemModel failed',

	EXPORT_ALL_EXAMINATION_ITEM = '[ENTITY] Export All ExaminationItemModels',
	EXPORT_ALL_EXAMINATION_ITEM_OK = '[ENTITY] Export All ExaminationItemModels successfully',
	EXPORT_ALL_EXAMINATION_ITEM_FAIL = '[ENTITY] Export All ExaminationItemModels failed',

	EXPORT_EXAMINATION_ITEM_EXCLUDING_IDS = '[ENTITY] Export ExaminationItemModels excluding Ids',
	EXPORT_EXAMINATION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export ExaminationItemModel excluding Ids successfully',
	EXPORT_EXAMINATION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export ExaminationItemModel excluding Ids failed',

	COUNT_EXAMINATION_ITEMS = '[ENTITY] Fetch number of ExaminationItemModel records',
	COUNT_EXAMINATION_ITEMS_OK = '[ENTITY] Fetch number of ExaminationItemModel records successfully ',
	COUNT_EXAMINATION_ITEMS_FAIL = '[ENTITY] Fetch number of ExaminationItemModel records failed',

	IMPORT_EXAMINATION_ITEMS = '[ENTITY] Import ExaminationItemModels',
	IMPORT_EXAMINATION_ITEMS_OK = '[ENTITY] Import ExaminationItemModels successfully',
	IMPORT_EXAMINATION_ITEMS_FAIL = '[ENTITY] Import ExaminationItemModels fail',


	INITIALISE_EXAMINATION_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ExaminationItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseExaminationItemAction implements Action {
	readonly className: string = 'ExaminationItemModel';

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

export class ExaminationItemAction extends BaseExaminationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemAction here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationItemModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemAction here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemAction here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemAction here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemAction here] end
}

export class ExaminationItemActionOK extends BaseExaminationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemActionOK here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationItemModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ExaminationItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemActionOK here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemActionOK here] end
}

export class ExaminationItemActionFail extends BaseExaminationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationItemActionFail here] off begin
	// % protected region % [Add any additional class fields for ExaminationItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ExaminationItemModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for ExaminationItemActionFail here] off begin
	// % protected region % [Add any additional class methods for ExaminationItemActionFail here] end
}

export function isExaminationItemModelAction(e: any): e is BaseExaminationItemAction {
	return Object.values(ExaminationItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
