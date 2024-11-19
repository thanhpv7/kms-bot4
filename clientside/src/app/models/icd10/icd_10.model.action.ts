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
import {Icd10Model} from './icd_10.model';
import {Icd10ModelAudit} from './icd_10.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of ICD 10 model actions to be dispatched by NgRx.
 */
export enum Icd10ModelActionTypes {
	CREATE_ICD_10 = '[ENTITY] Create Icd10Model',
	CREATE_ICD_10_OK = '[ENTITY] Create Icd10Model successfully',
	CREATE_ICD_10_FAIL = '[ENTITY] Create Icd10Model failed',

	CREATE_ALL_ICD_10 = '[ENTITY] Create All Icd10Model',
	CREATE_ALL_ICD_10_OK = '[ENTITY] Create All Icd10Model successfully',
	CREATE_ALL_ICD_10_FAIL = '[ENTITY] Create All Icd10Model failed',

	DELETE_ICD_10 = '[ENTITY] Delete Icd10Model',
	DELETE_ICD_10_OK = '[ENTITY] Delete Icd10Model successfully',
	DELETE_ICD_10_FAIL = '[ENTITY] Delete Icd10Model failed',


	DELETE_ICD_10_EXCLUDING_IDS = '[ENTITY] Delete Icd10Models Excluding Ids',
	DELETE_ICD_10_EXCLUDING_IDS_OK = '[ENTITY] Delete Icd10Models Excluding Ids successfully',
	DELETE_ICD_10_EXCLUDING_IDS_FAIL = '[ENTITY] Delete Icd10Models Excluding Ids failed',

	DELETE_ALL_ICD_10 = '[ENTITY] Delete all Icd10Models',
	DELETE_ALL_ICD_10_OK = '[ENTITY] Delete all Icd10Models successfully',
	DELETE_ALL_ICD_10_FAIL = '[ENTITY] Delete all Icd10Models failed',

	UPDATE_ICD_10 = '[ENTITY] Update Icd10Model',
	UPDATE_ICD_10_OK = '[ENTITY] Update Icd10Model successfully',
	UPDATE_ICD_10_FAIL = '[ENTITY] Update Icd10Model failed',

	UPDATE_ALL_ICD_10 = '[ENTITY] Update all Icd10Model',
	UPDATE_ALL_ICD_10_OK = '[ENTITY] Update all Icd10Model successfully',
	UPDATE_ALL_ICD_10_FAIL = '[ENTITY] Update all Icd10Model failed',

	FETCH_ICD_10= '[ENTITY] Fetch Icd10Model',
	FETCH_ICD_10_OK = '[ENTITY] Fetch Icd10Model successfully',
	FETCH_ICD_10_FAIL = '[ENTITY] Fetch Icd10Model failed',

	FETCH_ICD_10_AUDIT= '[ENTITY] Fetch Icd10Model audit',
	FETCH_ICD_10_AUDIT_OK = '[ENTITY] Fetch Icd10Model audit successfully',
	FETCH_ICD_10_AUDIT_FAIL = '[ENTITY] Fetch Icd10Model audit failed',

	FETCH_ICD_10_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch Icd10Model audits by entity id',
	FETCH_ICD_10_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch Icd10Model audits by entity id successfully',
	FETCH_ICD_10_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch Icd10Model audits by entity id failed',

	FETCH_ALL_ICD_10 = '[ENTITY] Fetch all Icd10Model',
	FETCH_ALL_ICD_10_OK = '[ENTITY] Fetch all Icd10Model successfully',
	FETCH_ALL_ICD_10_FAIL = '[ENTITY] Fetch all Icd10Model failed',

	FETCH_ICD_10_WITH_QUERY = '[ENTITY] Fetch Icd10Model with query',
	FETCH_ICD_10_WITH_QUERY_OK = '[ENTITY] Fetch Icd10Model with query successfully',
	FETCH_ICD_10_WITH_QUERY_FAIL = '[ENTITY] Fetch Icd10Model with query failed',

	FETCH_LAST_ICD_10_WITH_QUERY = '[ENTITY] Fetch last Icd10Model with query',
	FETCH_LAST_ICD_10_WITH_QUERY_OK = '[ENTITY] Fetch last Icd10Model with query successfully',
	FETCH_LAST_ICD_10_WITH_QUERY_FAIL = '[ENTITY] Fetch last Icd10Model with query failed',

	EXPORT_ICD_10 = '[ENTITY] Export Icd10Model',
	EXPORT_ICD_10_OK = '[ENTITY] Export Icd10Model successfully',
	EXPORT_ICD_10_FAIL = '[ENTITY] Export Icd10Model failed',

	EXPORT_ALL_ICD_10 = '[ENTITY] Export All Icd10Models',
	EXPORT_ALL_ICD_10_OK = '[ENTITY] Export All Icd10Models successfully',
	EXPORT_ALL_ICD_10_FAIL = '[ENTITY] Export All Icd10Models failed',

	EXPORT_ICD_10_EXCLUDING_IDS = '[ENTITY] Export Icd10Models excluding Ids',
	EXPORT_ICD_10_EXCLUDING_IDS_OK = '[ENTITY] Export Icd10Model excluding Ids successfully',
	EXPORT_ICD_10_EXCLUDING_IDS_FAIL = '[ENTITY] Export Icd10Model excluding Ids failed',

	COUNT_ICD_10S = '[ENTITY] Fetch number of Icd10Model records',
	COUNT_ICD_10S_OK = '[ENTITY] Fetch number of Icd10Model records successfully ',
	COUNT_ICD_10S_FAIL = '[ENTITY] Fetch number of Icd10Model records failed',

	IMPORT_ICD_10S = '[ENTITY] Import Icd10Models',
	IMPORT_ICD_10S_OK = '[ENTITY] Import Icd10Models successfully',
	IMPORT_ICD_10S_FAIL = '[ENTITY] Import Icd10Models fail',


	INITIALISE_ICD_10_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of Icd10Model',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseIcd10Action implements Action {
	readonly className: string = 'Icd10Model';

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

export class Icd10Action extends BaseIcd10Action {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd10Action here] off begin
	// % protected region % [Add any additional class fields for Icd10Action here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<Icd10Model>,
		// % protected region % [Add any additional constructor parameters for Icd10Action here] off begin
		// % protected region % [Add any additional constructor parameters for Icd10Action here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd10Action here] off begin
			// % protected region % [Add any additional constructor arguments for Icd10Action here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd10Action here] off begin
		// % protected region % [Add any additional constructor logic for Icd10Action here] end
	}

	// % protected region % [Add any additional class methods for Icd10Action here] off begin
	// % protected region % [Add any additional class methods for Icd10Action here] end
}

export class Icd10ActionOK extends BaseIcd10Action {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd10ActionOK here] off begin
	// % protected region % [Add any additional class fields for Icd10ActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<Icd10Model>,
		// % protected region % [Add any additional constructor parameters for Icd10ActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for Icd10ActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: Icd10ModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd10ActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for Icd10ActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd10ActionOK here] off begin
		// % protected region % [Add any additional constructor logic for Icd10ActionOK here] end
	}

	// % protected region % [Add any additional class methods for Icd10ActionOK here] off begin
	// % protected region % [Add any additional class methods for Icd10ActionOK here] end
}

export class Icd10ActionFail extends BaseIcd10Action {

	readonly type: string;

	// % protected region % [Add any additional class fields for Icd10ActionFail here] off begin
	// % protected region % [Add any additional class fields for Icd10ActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<Icd10Model>,
		// % protected region % [Add any additional constructor parameters for Icd10ActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for Icd10ActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for Icd10ActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for Icd10ActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for Icd10ActionFail here] off begin
		// % protected region % [Add any additional constructor logic for Icd10ActionFail here] end
	}

	// % protected region % [Add any additional class methods for Icd10ActionFail here] off begin
	// % protected region % [Add any additional class methods for Icd10ActionFail here] end
}

export function isIcd10ModelAction(e: any): e is BaseIcd10Action {
	return Object.values(Icd10ModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
