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
import {BpjsUpdateDismissalDateModel} from './bpjs_update_dismissal_date.model';
import {BpjsUpdateDismissalDateModelAudit} from './bpjs_update_dismissal_date.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Update Dismissal Date model actions to be dispatched by NgRx.
 */
export enum BpjsUpdateDismissalDateModelActionTypes {
	CREATE_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Create BpjsUpdateDismissalDateModel',
	CREATE_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Create BpjsUpdateDismissalDateModel successfully',
	CREATE_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Create BpjsUpdateDismissalDateModel failed',

	CREATE_ALL_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Create All BpjsUpdateDismissalDateModel',
	CREATE_ALL_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Create All BpjsUpdateDismissalDateModel successfully',
	CREATE_ALL_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Create All BpjsUpdateDismissalDateModel failed',

	DELETE_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Delete BpjsUpdateDismissalDateModel',
	DELETE_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Delete BpjsUpdateDismissalDateModel successfully',
	DELETE_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Delete BpjsUpdateDismissalDateModel failed',


	DELETE_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS = '[ENTITY] Delete BpjsUpdateDismissalDateModels Excluding Ids',
	DELETE_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsUpdateDismissalDateModels Excluding Ids successfully',
	DELETE_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsUpdateDismissalDateModels Excluding Ids failed',

	DELETE_ALL_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Delete all BpjsUpdateDismissalDateModels',
	DELETE_ALL_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Delete all BpjsUpdateDismissalDateModels successfully',
	DELETE_ALL_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Delete all BpjsUpdateDismissalDateModels failed',

	UPDATE_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Update BpjsUpdateDismissalDateModel',
	UPDATE_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Update BpjsUpdateDismissalDateModel successfully',
	UPDATE_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Update BpjsUpdateDismissalDateModel failed',

	UPDATE_ALL_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Update all BpjsUpdateDismissalDateModel',
	UPDATE_ALL_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Update all BpjsUpdateDismissalDateModel successfully',
	UPDATE_ALL_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Update all BpjsUpdateDismissalDateModel failed',

	FETCH_BPJS_UPDATE_DISMISSAL_DATE= '[ENTITY] Fetch BpjsUpdateDismissalDateModel',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Fetch BpjsUpdateDismissalDateModel successfully',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Fetch BpjsUpdateDismissalDateModel failed',

	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDIT= '[ENTITY] Fetch BpjsUpdateDismissalDateModel audit',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDIT_OK = '[ENTITY] Fetch BpjsUpdateDismissalDateModel audit successfully',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDIT_FAIL = '[ENTITY] Fetch BpjsUpdateDismissalDateModel audit failed',

	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsUpdateDismissalDateModel audits by entity id',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsUpdateDismissalDateModel audits by entity id successfully',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsUpdateDismissalDateModel audits by entity id failed',

	FETCH_ALL_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Fetch all BpjsUpdateDismissalDateModel',
	FETCH_ALL_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Fetch all BpjsUpdateDismissalDateModel successfully',
	FETCH_ALL_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Fetch all BpjsUpdateDismissalDateModel failed',

	FETCH_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY = '[ENTITY] Fetch BpjsUpdateDismissalDateModel with query',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY_OK = '[ENTITY] Fetch BpjsUpdateDismissalDateModel with query successfully',
	FETCH_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsUpdateDismissalDateModel with query failed',

	FETCH_LAST_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY = '[ENTITY] Fetch last BpjsUpdateDismissalDateModel with query',
	FETCH_LAST_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsUpdateDismissalDateModel with query successfully',
	FETCH_LAST_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsUpdateDismissalDateModel with query failed',

	EXPORT_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Export BpjsUpdateDismissalDateModel',
	EXPORT_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Export BpjsUpdateDismissalDateModel successfully',
	EXPORT_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Export BpjsUpdateDismissalDateModel failed',

	EXPORT_ALL_BPJS_UPDATE_DISMISSAL_DATE = '[ENTITY] Export All BpjsUpdateDismissalDateModels',
	EXPORT_ALL_BPJS_UPDATE_DISMISSAL_DATE_OK = '[ENTITY] Export All BpjsUpdateDismissalDateModels successfully',
	EXPORT_ALL_BPJS_UPDATE_DISMISSAL_DATE_FAIL = '[ENTITY] Export All BpjsUpdateDismissalDateModels failed',

	EXPORT_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS = '[ENTITY] Export BpjsUpdateDismissalDateModels excluding Ids',
	EXPORT_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsUpdateDismissalDateModel excluding Ids successfully',
	EXPORT_BPJS_UPDATE_DISMISSAL_DATE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsUpdateDismissalDateModel excluding Ids failed',

	COUNT_BPJS_UPDATE_DISMISSAL_DATES = '[ENTITY] Fetch number of BpjsUpdateDismissalDateModel records',
	COUNT_BPJS_UPDATE_DISMISSAL_DATES_OK = '[ENTITY] Fetch number of BpjsUpdateDismissalDateModel records successfully ',
	COUNT_BPJS_UPDATE_DISMISSAL_DATES_FAIL = '[ENTITY] Fetch number of BpjsUpdateDismissalDateModel records failed',

	IMPORT_BPJS_UPDATE_DISMISSAL_DATES = '[ENTITY] Import BpjsUpdateDismissalDateModels',
	IMPORT_BPJS_UPDATE_DISMISSAL_DATES_OK = '[ENTITY] Import BpjsUpdateDismissalDateModels successfully',
	IMPORT_BPJS_UPDATE_DISMISSAL_DATES_FAIL = '[ENTITY] Import BpjsUpdateDismissalDateModels fail',


	INITIALISE_BPJS_UPDATE_DISMISSAL_DATE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsUpdateDismissalDateModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsUpdateDismissalDateAction implements Action {
	readonly className: string = 'BpjsUpdateDismissalDateModel';

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

export class BpjsUpdateDismissalDateAction extends BaseBpjsUpdateDismissalDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateAction here] off begin
	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsUpdateDismissalDateModel>,
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateAction here] off begin
	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateAction here] end
}

export class BpjsUpdateDismissalDateActionOK extends BaseBpjsUpdateDismissalDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsUpdateDismissalDateModel>,
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsUpdateDismissalDateModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateActionOK here] end
}

export class BpjsUpdateDismissalDateActionFail extends BaseBpjsUpdateDismissalDateAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsUpdateDismissalDateActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsUpdateDismissalDateModel>,
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsUpdateDismissalDateActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsUpdateDismissalDateActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsUpdateDismissalDateActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsUpdateDismissalDateActionFail here] end
}

export function isBpjsUpdateDismissalDateModelAction(e: any): e is BaseBpjsUpdateDismissalDateAction {
	return Object.values(BpjsUpdateDismissalDateModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
