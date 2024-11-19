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
import {Icd9CMModel} from './icd_9_cm.model';
import {Icd9CMModelAudit} from './icd_9_cm.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of ICD 9 CM model actions to be dispatched by NgRx.
 */
export enum Icd9CMModelActionTypes {
	CREATE_ICD_9_CM = '[ENTITY] Create Icd9CMModel',
	CREATE_ICD_9_CM_OK = '[ENTITY] Create Icd9CMModel successfully',
	CREATE_ICD_9_CM_FAIL = '[ENTITY] Create Icd9CMModel failed',

	CREATE_ALL_ICD_9_CM = '[ENTITY] Create All Icd9CMModel',
	CREATE_ALL_ICD_9_CM_OK = '[ENTITY] Create All Icd9CMModel successfully',
	CREATE_ALL_ICD_9_CM_FAIL = '[ENTITY] Create All Icd9CMModel failed',

	DELETE_ICD_9_CM = '[ENTITY] Delete Icd9CMModel',
	DELETE_ICD_9_CM_OK = '[ENTITY] Delete Icd9CMModel successfully',
	DELETE_ICD_9_CM_FAIL = '[ENTITY] Delete Icd9CMModel failed',


	DELETE_ICD_9_CM_EXCLUDING_IDS = '[ENTITY] Delete Icd9CMModels Excluding Ids',
	DELETE_ICD_9_CM_EXCLUDING_IDS_OK = '[ENTITY] Delete Icd9CMModels Excluding Ids successfully',
	DELETE_ICD_9_CM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete Icd9CMModels Excluding Ids failed',

	DELETE_ALL_ICD_9_CM = '[ENTITY] Delete all Icd9CMModels',
	DELETE_ALL_ICD_9_CM_OK = '[ENTITY] Delete all Icd9CMModels successfully',
	DELETE_ALL_ICD_9_CM_FAIL = '[ENTITY] Delete all Icd9CMModels failed',

	UPDATE_ICD_9_CM = '[ENTITY] Update Icd9CMModel',
	UPDATE_ICD_9_CM_OK = '[ENTITY] Update Icd9CMModel successfully',
	UPDATE_ICD_9_CM_FAIL = '[ENTITY] Update Icd9CMModel failed',

	UPDATE_ALL_ICD_9_CM = '[ENTITY] Update all Icd9CMModel',
	UPDATE_ALL_ICD_9_CM_OK = '[ENTITY] Update all Icd9CMModel successfully',
	UPDATE_ALL_ICD_9_CM_FAIL = '[ENTITY] Update all Icd9CMModel failed',

	FETCH_ICD_9_CM= '[ENTITY] Fetch Icd9CMModel',
	FETCH_ICD_9_CM_OK = '[ENTITY] Fetch Icd9CMModel successfully',
	FETCH_ICD_9_CM_FAIL = '[ENTITY] Fetch Icd9CMModel failed',

	FETCH_ICD_9_CM_AUDIT= '[ENTITY] Fetch Icd9CMModel audit',
	FETCH_ICD_9_CM_AUDIT_OK = '[ENTITY] Fetch Icd9CMModel audit successfully',
	FETCH_ICD_9_CM_AUDIT_FAIL = '[ENTITY] Fetch Icd9CMModel audit failed',

	FETCH_ICD_9_CM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch Icd9CMModel audits by entity id',
	FETCH_ICD_9_CM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch Icd9CMModel audits by entity id successfully',
	FETCH_ICD_9_CM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch Icd9CMModel audits by entity id failed',

	FETCH_ALL_ICD_9_CM = '[ENTITY] Fetch all Icd9CMModel',
	FETCH_ALL_ICD_9_CM_OK = '[ENTITY] Fetch all Icd9CMModel successfully',
	FETCH_ALL_ICD_9_CM_FAIL = '[ENTITY] Fetch all Icd9CMModel failed',

	FETCH_ICD_9_CM_WITH_QUERY = '[ENTITY] Fetch Icd9CMModel with query',
	FETCH_ICD_9_CM_WITH_QUERY_OK = '[ENTITY] Fetch Icd9CMModel with query successfully',
	FETCH_ICD_9_CM_WITH_QUERY_FAIL = '[ENTITY] Fetch Icd9CMModel with query failed',

	FETCH_LAST_ICD_9_CM_WITH_QUERY = '[ENTITY] Fetch last Icd9CMModel with query',
	FETCH_LAST_ICD_9_CM_WITH_QUERY_OK = '[ENTITY] Fetch last Icd9CMModel with query successfully',
	FETCH_LAST_ICD_9_CM_WITH_QUERY_FAIL = '[ENTITY] Fetch last Icd9CMModel with query failed',

	EXPORT_ICD_9_CM = '[ENTITY] Export Icd9CMModel',
	EXPORT_ICD_9_CM_OK = '[ENTITY] Export Icd9CMModel successfully',
	EXPORT_ICD_9_CM_FAIL = '[ENTITY] Export Icd9CMModel failed',

	EXPORT_ALL_ICD_9_CM = '[ENTITY] Export All Icd9CMModels',
	EXPORT_ALL_ICD_9_CM_OK = '[ENTITY] Export All Icd9CMModels successfully',
	EXPORT_ALL_ICD_9_CM_FAIL = '[ENTITY] Export All Icd9CMModels failed',

	EXPORT_ICD_9_CM_EXCLUDING_IDS = '[ENTITY] Export Icd9CMModels excluding Ids',
	EXPORT_ICD_9_CM_EXCLUDING_IDS_OK = '[ENTITY] Export Icd9CMModel excluding Ids successfully',
	EXPORT_ICD_9_CM_EXCLUDING_IDS_FAIL = '[ENTITY] Export Icd9CMModel excluding Ids failed',

	COUNT_ICD_9_CMS = '[ENTITY] Fetch number of Icd9CMModel records',
	COUNT_ICD_9_CMS_OK = '[ENTITY] Fetch number of Icd9CMModel records successfully ',
	COUNT_ICD_9_CMS_FAIL = '[ENTITY] Fetch number of Icd9CMModel records failed',

	IMPORT_ICD_9_CMS = '[ENTITY] Import Icd9CMModels',
	IMPORT_ICD_9_CMS_OK = '[ENTITY] Import Icd9CMModels successfully',
	IMPORT_ICD_9_CMS_FAIL = '[ENTITY] Import Icd9CMModels fail',


	INITIALISE_ICD_9_CM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of Icd9CMModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseIcd9CMAction implements Action {
	readonly className: string = 'Icd9CMModel';

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

export class Icd9CMAction extends BaseIcd9CMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd9CMAction here] off begin
	// % protected region % [Add any additional class fields for Icd9CMAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<Icd9CMModel>,
		// % protected region % [Add any additional constructor parameters for Icd9CMAction here] off begin
		// % protected region % [Add any additional constructor parameters for Icd9CMAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd9CMAction here] off begin
			// % protected region % [Add any additional constructor arguments for Icd9CMAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd9CMAction here] off begin
		// % protected region % [Add any additional constructor logic for Icd9CMAction here] end
	}

	// % protected region % [Add any additional class methods for Icd9CMAction here] off begin
	// % protected region % [Add any additional class methods for Icd9CMAction here] end
}

export class Icd9CMActionOK extends BaseIcd9CMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd9CMActionOK here] off begin
	// % protected region % [Add any additional class fields for Icd9CMActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<Icd9CMModel>,
		// % protected region % [Add any additional constructor parameters for Icd9CMActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for Icd9CMActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: Icd9CMModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd9CMActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for Icd9CMActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd9CMActionOK here] off begin
		// % protected region % [Add any additional constructor logic for Icd9CMActionOK here] end
	}

	// % protected region % [Add any additional class methods for Icd9CMActionOK here] off begin
	// % protected region % [Add any additional class methods for Icd9CMActionOK here] end
}

export class Icd9CMActionFail extends BaseIcd9CMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd9CMActionFail here] off begin
	// % protected region % [Add any additional class fields for Icd9CMActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<Icd9CMModel>,
		// % protected region % [Add any additional constructor parameters for Icd9CMActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for Icd9CMActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd9CMActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for Icd9CMActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd9CMActionFail here] off begin
		// % protected region % [Add any additional constructor logic for Icd9CMActionFail here] end
	}

	// % protected region % [Add any additional class methods for Icd9CMActionFail here] off begin
	// % protected region % [Add any additional class methods for Icd9CMActionFail here] end
}

export function isIcd9CMModelAction(e: any): e is BaseIcd9CMAction {
	return Object.values(Icd9CMModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
