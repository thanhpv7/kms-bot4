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
import {StaffModel} from './staff.model';
import {StaffModelAudit} from './staff.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Staff model actions to be dispatched by NgRx.
 */
export enum StaffModelActionTypes {
	CREATE_STAFF = '[ENTITY] Create StaffModel',
	CREATE_STAFF_OK = '[ENTITY] Create StaffModel successfully',
	CREATE_STAFF_FAIL = '[ENTITY] Create StaffModel failed',

	CREATE_ALL_STAFF = '[ENTITY] Create All StaffModel',
	CREATE_ALL_STAFF_OK = '[ENTITY] Create All StaffModel successfully',
	CREATE_ALL_STAFF_FAIL = '[ENTITY] Create All StaffModel failed',

	DELETE_STAFF = '[ENTITY] Delete StaffModel',
	DELETE_STAFF_OK = '[ENTITY] Delete StaffModel successfully',
	DELETE_STAFF_FAIL = '[ENTITY] Delete StaffModel failed',


	DELETE_STAFF_EXCLUDING_IDS = '[ENTITY] Delete StaffModels Excluding Ids',
	DELETE_STAFF_EXCLUDING_IDS_OK = '[ENTITY] Delete StaffModels Excluding Ids successfully',
	DELETE_STAFF_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StaffModels Excluding Ids failed',

	DELETE_ALL_STAFF = '[ENTITY] Delete all StaffModels',
	DELETE_ALL_STAFF_OK = '[ENTITY] Delete all StaffModels successfully',
	DELETE_ALL_STAFF_FAIL = '[ENTITY] Delete all StaffModels failed',

	UPDATE_STAFF = '[ENTITY] Update StaffModel',
	UPDATE_STAFF_OK = '[ENTITY] Update StaffModel successfully',
	UPDATE_STAFF_FAIL = '[ENTITY] Update StaffModel failed',

	UPDATE_ALL_STAFF = '[ENTITY] Update all StaffModel',
	UPDATE_ALL_STAFF_OK = '[ENTITY] Update all StaffModel successfully',
	UPDATE_ALL_STAFF_FAIL = '[ENTITY] Update all StaffModel failed',

	FETCH_STAFF= '[ENTITY] Fetch StaffModel',
	FETCH_STAFF_OK = '[ENTITY] Fetch StaffModel successfully',
	FETCH_STAFF_FAIL = '[ENTITY] Fetch StaffModel failed',

	FETCH_STAFF_AUDIT= '[ENTITY] Fetch StaffModel audit',
	FETCH_STAFF_AUDIT_OK = '[ENTITY] Fetch StaffModel audit successfully',
	FETCH_STAFF_AUDIT_FAIL = '[ENTITY] Fetch StaffModel audit failed',

	FETCH_STAFF_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StaffModel audits by entity id',
	FETCH_STAFF_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StaffModel audits by entity id successfully',
	FETCH_STAFF_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StaffModel audits by entity id failed',

	FETCH_ALL_STAFF = '[ENTITY] Fetch all StaffModel',
	FETCH_ALL_STAFF_OK = '[ENTITY] Fetch all StaffModel successfully',
	FETCH_ALL_STAFF_FAIL = '[ENTITY] Fetch all StaffModel failed',

	FETCH_STAFF_WITH_QUERY = '[ENTITY] Fetch StaffModel with query',
	FETCH_STAFF_WITH_QUERY_OK = '[ENTITY] Fetch StaffModel with query successfully',
	FETCH_STAFF_WITH_QUERY_FAIL = '[ENTITY] Fetch StaffModel with query failed',

	FETCH_LAST_STAFF_WITH_QUERY = '[ENTITY] Fetch last StaffModel with query',
	FETCH_LAST_STAFF_WITH_QUERY_OK = '[ENTITY] Fetch last StaffModel with query successfully',
	FETCH_LAST_STAFF_WITH_QUERY_FAIL = '[ENTITY] Fetch last StaffModel with query failed',

	EXPORT_STAFF = '[ENTITY] Export StaffModel',
	EXPORT_STAFF_OK = '[ENTITY] Export StaffModel successfully',
	EXPORT_STAFF_FAIL = '[ENTITY] Export StaffModel failed',

	EXPORT_ALL_STAFF = '[ENTITY] Export All StaffModels',
	EXPORT_ALL_STAFF_OK = '[ENTITY] Export All StaffModels successfully',
	EXPORT_ALL_STAFF_FAIL = '[ENTITY] Export All StaffModels failed',

	EXPORT_STAFF_EXCLUDING_IDS = '[ENTITY] Export StaffModels excluding Ids',
	EXPORT_STAFF_EXCLUDING_IDS_OK = '[ENTITY] Export StaffModel excluding Ids successfully',
	EXPORT_STAFF_EXCLUDING_IDS_FAIL = '[ENTITY] Export StaffModel excluding Ids failed',

	COUNT_STAFFS = '[ENTITY] Fetch number of StaffModel records',
	COUNT_STAFFS_OK = '[ENTITY] Fetch number of StaffModel records successfully ',
	COUNT_STAFFS_FAIL = '[ENTITY] Fetch number of StaffModel records failed',

	IMPORT_STAFFS = '[ENTITY] Import StaffModels',
	IMPORT_STAFFS_OK = '[ENTITY] Import StaffModels successfully',
	IMPORT_STAFFS_FAIL = '[ENTITY] Import StaffModels fail',


	INITIALISE_STAFF_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StaffModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStaffAction implements Action {
	readonly className: string = 'StaffModel';

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

export class StaffAction extends BaseStaffAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StaffAction here] off begin
	// % protected region % [Add any additional class fields for StaffAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StaffModel>,
		// % protected region % [Add any additional constructor parameters for StaffAction here] off begin
		// % protected region % [Add any additional constructor parameters for StaffAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StaffAction here] off begin
			// % protected region % [Add any additional constructor arguments for StaffAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StaffAction here] off begin
		// % protected region % [Add any additional constructor logic for StaffAction here] end
	}

	// % protected region % [Add any additional class methods for StaffAction here] off begin
	// % protected region % [Add any additional class methods for StaffAction here] end
}

export class StaffActionOK extends BaseStaffAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StaffActionOK here] off begin
	// % protected region % [Add any additional class fields for StaffActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StaffModel>,
		// % protected region % [Add any additional constructor parameters for StaffActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StaffActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StaffModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StaffActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StaffActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StaffActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StaffActionOK here] end
	}

	// % protected region % [Add any additional class methods for StaffActionOK here] off begin
	// % protected region % [Add any additional class methods for StaffActionOK here] end
}

export class StaffActionFail extends BaseStaffAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StaffActionFail here] off begin
	// % protected region % [Add any additional class fields for StaffActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StaffModel>,
		// % protected region % [Add any additional constructor parameters for StaffActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StaffActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StaffActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StaffActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StaffActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StaffActionFail here] end
	}

	// % protected region % [Add any additional class methods for StaffActionFail here] off begin
	// % protected region % [Add any additional class methods for StaffActionFail here] end
}

export function isStaffModelAction(e: any): e is BaseStaffAction {
	return Object.values(StaffModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
