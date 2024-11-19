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
import {ExaminationGroupModel} from './examination_group.model';
import {ExaminationGroupModelAudit} from './examination_group.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Examination Group model actions to be dispatched by NgRx.
 */
export enum ExaminationGroupModelActionTypes {
	CREATE_EXAMINATION_GROUP = '[ENTITY] Create ExaminationGroupModel',
	CREATE_EXAMINATION_GROUP_OK = '[ENTITY] Create ExaminationGroupModel successfully',
	CREATE_EXAMINATION_GROUP_FAIL = '[ENTITY] Create ExaminationGroupModel failed',

	CREATE_ALL_EXAMINATION_GROUP = '[ENTITY] Create All ExaminationGroupModel',
	CREATE_ALL_EXAMINATION_GROUP_OK = '[ENTITY] Create All ExaminationGroupModel successfully',
	CREATE_ALL_EXAMINATION_GROUP_FAIL = '[ENTITY] Create All ExaminationGroupModel failed',

	DELETE_EXAMINATION_GROUP = '[ENTITY] Delete ExaminationGroupModel',
	DELETE_EXAMINATION_GROUP_OK = '[ENTITY] Delete ExaminationGroupModel successfully',
	DELETE_EXAMINATION_GROUP_FAIL = '[ENTITY] Delete ExaminationGroupModel failed',


	DELETE_EXAMINATION_GROUP_EXCLUDING_IDS = '[ENTITY] Delete ExaminationGroupModels Excluding Ids',
	DELETE_EXAMINATION_GROUP_EXCLUDING_IDS_OK = '[ENTITY] Delete ExaminationGroupModels Excluding Ids successfully',
	DELETE_EXAMINATION_GROUP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ExaminationGroupModels Excluding Ids failed',

	DELETE_ALL_EXAMINATION_GROUP = '[ENTITY] Delete all ExaminationGroupModels',
	DELETE_ALL_EXAMINATION_GROUP_OK = '[ENTITY] Delete all ExaminationGroupModels successfully',
	DELETE_ALL_EXAMINATION_GROUP_FAIL = '[ENTITY] Delete all ExaminationGroupModels failed',

	UPDATE_EXAMINATION_GROUP = '[ENTITY] Update ExaminationGroupModel',
	UPDATE_EXAMINATION_GROUP_OK = '[ENTITY] Update ExaminationGroupModel successfully',
	UPDATE_EXAMINATION_GROUP_FAIL = '[ENTITY] Update ExaminationGroupModel failed',

	UPDATE_ALL_EXAMINATION_GROUP = '[ENTITY] Update all ExaminationGroupModel',
	UPDATE_ALL_EXAMINATION_GROUP_OK = '[ENTITY] Update all ExaminationGroupModel successfully',
	UPDATE_ALL_EXAMINATION_GROUP_FAIL = '[ENTITY] Update all ExaminationGroupModel failed',

	FETCH_EXAMINATION_GROUP= '[ENTITY] Fetch ExaminationGroupModel',
	FETCH_EXAMINATION_GROUP_OK = '[ENTITY] Fetch ExaminationGroupModel successfully',
	FETCH_EXAMINATION_GROUP_FAIL = '[ENTITY] Fetch ExaminationGroupModel failed',

	FETCH_EXAMINATION_GROUP_AUDIT= '[ENTITY] Fetch ExaminationGroupModel audit',
	FETCH_EXAMINATION_GROUP_AUDIT_OK = '[ENTITY] Fetch ExaminationGroupModel audit successfully',
	FETCH_EXAMINATION_GROUP_AUDIT_FAIL = '[ENTITY] Fetch ExaminationGroupModel audit failed',

	FETCH_EXAMINATION_GROUP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ExaminationGroupModel audits by entity id',
	FETCH_EXAMINATION_GROUP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ExaminationGroupModel audits by entity id successfully',
	FETCH_EXAMINATION_GROUP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ExaminationGroupModel audits by entity id failed',

	FETCH_ALL_EXAMINATION_GROUP = '[ENTITY] Fetch all ExaminationGroupModel',
	FETCH_ALL_EXAMINATION_GROUP_OK = '[ENTITY] Fetch all ExaminationGroupModel successfully',
	FETCH_ALL_EXAMINATION_GROUP_FAIL = '[ENTITY] Fetch all ExaminationGroupModel failed',

	FETCH_EXAMINATION_GROUP_WITH_QUERY = '[ENTITY] Fetch ExaminationGroupModel with query',
	FETCH_EXAMINATION_GROUP_WITH_QUERY_OK = '[ENTITY] Fetch ExaminationGroupModel with query successfully',
	FETCH_EXAMINATION_GROUP_WITH_QUERY_FAIL = '[ENTITY] Fetch ExaminationGroupModel with query failed',

	FETCH_LAST_EXAMINATION_GROUP_WITH_QUERY = '[ENTITY] Fetch last ExaminationGroupModel with query',
	FETCH_LAST_EXAMINATION_GROUP_WITH_QUERY_OK = '[ENTITY] Fetch last ExaminationGroupModel with query successfully',
	FETCH_LAST_EXAMINATION_GROUP_WITH_QUERY_FAIL = '[ENTITY] Fetch last ExaminationGroupModel with query failed',

	EXPORT_EXAMINATION_GROUP = '[ENTITY] Export ExaminationGroupModel',
	EXPORT_EXAMINATION_GROUP_OK = '[ENTITY] Export ExaminationGroupModel successfully',
	EXPORT_EXAMINATION_GROUP_FAIL = '[ENTITY] Export ExaminationGroupModel failed',

	EXPORT_ALL_EXAMINATION_GROUP = '[ENTITY] Export All ExaminationGroupModels',
	EXPORT_ALL_EXAMINATION_GROUP_OK = '[ENTITY] Export All ExaminationGroupModels successfully',
	EXPORT_ALL_EXAMINATION_GROUP_FAIL = '[ENTITY] Export All ExaminationGroupModels failed',

	EXPORT_EXAMINATION_GROUP_EXCLUDING_IDS = '[ENTITY] Export ExaminationGroupModels excluding Ids',
	EXPORT_EXAMINATION_GROUP_EXCLUDING_IDS_OK = '[ENTITY] Export ExaminationGroupModel excluding Ids successfully',
	EXPORT_EXAMINATION_GROUP_EXCLUDING_IDS_FAIL = '[ENTITY] Export ExaminationGroupModel excluding Ids failed',

	COUNT_EXAMINATION_GROUPS = '[ENTITY] Fetch number of ExaminationGroupModel records',
	COUNT_EXAMINATION_GROUPS_OK = '[ENTITY] Fetch number of ExaminationGroupModel records successfully ',
	COUNT_EXAMINATION_GROUPS_FAIL = '[ENTITY] Fetch number of ExaminationGroupModel records failed',

	IMPORT_EXAMINATION_GROUPS = '[ENTITY] Import ExaminationGroupModels',
	IMPORT_EXAMINATION_GROUPS_OK = '[ENTITY] Import ExaminationGroupModels successfully',
	IMPORT_EXAMINATION_GROUPS_FAIL = '[ENTITY] Import ExaminationGroupModels fail',


	INITIALISE_EXAMINATION_GROUP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ExaminationGroupModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseExaminationGroupAction implements Action {
	readonly className: string = 'ExaminationGroupModel';

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

export class ExaminationGroupAction extends BaseExaminationGroupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationGroupAction here] off begin
	// % protected region % [Add any additional class fields for ExaminationGroupAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationGroupModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationGroupAction here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationGroupAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationGroupAction here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationGroupAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationGroupAction here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationGroupAction here] end
	}

	// % protected region % [Add any additional class methods for ExaminationGroupAction here] off begin
	// % protected region % [Add any additional class methods for ExaminationGroupAction here] end
}

export class ExaminationGroupActionOK extends BaseExaminationGroupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationGroupActionOK here] off begin
	// % protected region % [Add any additional class fields for ExaminationGroupActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ExaminationGroupModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationGroupActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationGroupActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ExaminationGroupModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationGroupActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationGroupActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationGroupActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationGroupActionOK here] end
	}

	// % protected region % [Add any additional class methods for ExaminationGroupActionOK here] off begin
	// % protected region % [Add any additional class methods for ExaminationGroupActionOK here] end
}

export class ExaminationGroupActionFail extends BaseExaminationGroupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ExaminationGroupActionFail here] off begin
	// % protected region % [Add any additional class fields for ExaminationGroupActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ExaminationGroupModel>,
		// % protected region % [Add any additional constructor parameters for ExaminationGroupActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ExaminationGroupActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ExaminationGroupActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ExaminationGroupActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ExaminationGroupActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ExaminationGroupActionFail here] end
	}

	// % protected region % [Add any additional class methods for ExaminationGroupActionFail here] off begin
	// % protected region % [Add any additional class methods for ExaminationGroupActionFail here] end
}

export function isExaminationGroupModelAction(e: any): e is BaseExaminationGroupAction {
	return Object.values(ExaminationGroupModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
