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
import {NhisServiceOutcomeModel} from './nhis_service_outcome.model';
import {NhisServiceOutcomeModelAudit} from './nhis_service_outcome.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Service Outcome model actions to be dispatched by NgRx.
 */
export enum NhisServiceOutcomeModelActionTypes {
	CREATE_NHIS_SERVICE_OUTCOME = '[ENTITY] Create NhisServiceOutcomeModel',
	CREATE_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Create NhisServiceOutcomeModel successfully',
	CREATE_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Create NhisServiceOutcomeModel failed',

	CREATE_ALL_NHIS_SERVICE_OUTCOME = '[ENTITY] Create All NhisServiceOutcomeModel',
	CREATE_ALL_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Create All NhisServiceOutcomeModel successfully',
	CREATE_ALL_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Create All NhisServiceOutcomeModel failed',

	DELETE_NHIS_SERVICE_OUTCOME = '[ENTITY] Delete NhisServiceOutcomeModel',
	DELETE_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Delete NhisServiceOutcomeModel successfully',
	DELETE_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Delete NhisServiceOutcomeModel failed',


	DELETE_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS = '[ENTITY] Delete NhisServiceOutcomeModels Excluding Ids',
	DELETE_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisServiceOutcomeModels Excluding Ids successfully',
	DELETE_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisServiceOutcomeModels Excluding Ids failed',

	DELETE_ALL_NHIS_SERVICE_OUTCOME = '[ENTITY] Delete all NhisServiceOutcomeModels',
	DELETE_ALL_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Delete all NhisServiceOutcomeModels successfully',
	DELETE_ALL_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Delete all NhisServiceOutcomeModels failed',

	UPDATE_NHIS_SERVICE_OUTCOME = '[ENTITY] Update NhisServiceOutcomeModel',
	UPDATE_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Update NhisServiceOutcomeModel successfully',
	UPDATE_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Update NhisServiceOutcomeModel failed',

	UPDATE_ALL_NHIS_SERVICE_OUTCOME = '[ENTITY] Update all NhisServiceOutcomeModel',
	UPDATE_ALL_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Update all NhisServiceOutcomeModel successfully',
	UPDATE_ALL_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Update all NhisServiceOutcomeModel failed',

	FETCH_NHIS_SERVICE_OUTCOME= '[ENTITY] Fetch NhisServiceOutcomeModel',
	FETCH_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Fetch NhisServiceOutcomeModel successfully',
	FETCH_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Fetch NhisServiceOutcomeModel failed',

	FETCH_NHIS_SERVICE_OUTCOME_AUDIT= '[ENTITY] Fetch NhisServiceOutcomeModel audit',
	FETCH_NHIS_SERVICE_OUTCOME_AUDIT_OK = '[ENTITY] Fetch NhisServiceOutcomeModel audit successfully',
	FETCH_NHIS_SERVICE_OUTCOME_AUDIT_FAIL = '[ENTITY] Fetch NhisServiceOutcomeModel audit failed',

	FETCH_NHIS_SERVICE_OUTCOME_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisServiceOutcomeModel audits by entity id',
	FETCH_NHIS_SERVICE_OUTCOME_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisServiceOutcomeModel audits by entity id successfully',
	FETCH_NHIS_SERVICE_OUTCOME_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisServiceOutcomeModel audits by entity id failed',

	FETCH_ALL_NHIS_SERVICE_OUTCOME = '[ENTITY] Fetch all NhisServiceOutcomeModel',
	FETCH_ALL_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Fetch all NhisServiceOutcomeModel successfully',
	FETCH_ALL_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Fetch all NhisServiceOutcomeModel failed',

	FETCH_NHIS_SERVICE_OUTCOME_WITH_QUERY = '[ENTITY] Fetch NhisServiceOutcomeModel with query',
	FETCH_NHIS_SERVICE_OUTCOME_WITH_QUERY_OK = '[ENTITY] Fetch NhisServiceOutcomeModel with query successfully',
	FETCH_NHIS_SERVICE_OUTCOME_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisServiceOutcomeModel with query failed',

	FETCH_LAST_NHIS_SERVICE_OUTCOME_WITH_QUERY = '[ENTITY] Fetch last NhisServiceOutcomeModel with query',
	FETCH_LAST_NHIS_SERVICE_OUTCOME_WITH_QUERY_OK = '[ENTITY] Fetch last NhisServiceOutcomeModel with query successfully',
	FETCH_LAST_NHIS_SERVICE_OUTCOME_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisServiceOutcomeModel with query failed',

	EXPORT_NHIS_SERVICE_OUTCOME = '[ENTITY] Export NhisServiceOutcomeModel',
	EXPORT_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Export NhisServiceOutcomeModel successfully',
	EXPORT_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Export NhisServiceOutcomeModel failed',

	EXPORT_ALL_NHIS_SERVICE_OUTCOME = '[ENTITY] Export All NhisServiceOutcomeModels',
	EXPORT_ALL_NHIS_SERVICE_OUTCOME_OK = '[ENTITY] Export All NhisServiceOutcomeModels successfully',
	EXPORT_ALL_NHIS_SERVICE_OUTCOME_FAIL = '[ENTITY] Export All NhisServiceOutcomeModels failed',

	EXPORT_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS = '[ENTITY] Export NhisServiceOutcomeModels excluding Ids',
	EXPORT_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS_OK = '[ENTITY] Export NhisServiceOutcomeModel excluding Ids successfully',
	EXPORT_NHIS_SERVICE_OUTCOME_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisServiceOutcomeModel excluding Ids failed',

	COUNT_NHIS_SERVICE_OUTCOMES = '[ENTITY] Fetch number of NhisServiceOutcomeModel records',
	COUNT_NHIS_SERVICE_OUTCOMES_OK = '[ENTITY] Fetch number of NhisServiceOutcomeModel records successfully ',
	COUNT_NHIS_SERVICE_OUTCOMES_FAIL = '[ENTITY] Fetch number of NhisServiceOutcomeModel records failed',

	IMPORT_NHIS_SERVICE_OUTCOMES = '[ENTITY] Import NhisServiceOutcomeModels',
	IMPORT_NHIS_SERVICE_OUTCOMES_OK = '[ENTITY] Import NhisServiceOutcomeModels successfully',
	IMPORT_NHIS_SERVICE_OUTCOMES_FAIL = '[ENTITY] Import NhisServiceOutcomeModels fail',


	INITIALISE_NHIS_SERVICE_OUTCOME_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisServiceOutcomeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisServiceOutcomeAction implements Action {
	readonly className: string = 'NhisServiceOutcomeModel';

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

export class NhisServiceOutcomeAction extends BaseNhisServiceOutcomeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisServiceOutcomeAction here] off begin
	// % protected region % [Add any additional class fields for NhisServiceOutcomeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisServiceOutcomeModel>,
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeAction here] end
	}

	// % protected region % [Add any additional class methods for NhisServiceOutcomeAction here] off begin
	// % protected region % [Add any additional class methods for NhisServiceOutcomeAction here] end
}

export class NhisServiceOutcomeActionOK extends BaseNhisServiceOutcomeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisServiceOutcomeActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisServiceOutcomeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisServiceOutcomeModel>,
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisServiceOutcomeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisServiceOutcomeActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisServiceOutcomeActionOK here] end
}

export class NhisServiceOutcomeActionFail extends BaseNhisServiceOutcomeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisServiceOutcomeActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisServiceOutcomeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisServiceOutcomeModel>,
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisServiceOutcomeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisServiceOutcomeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisServiceOutcomeActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisServiceOutcomeActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisServiceOutcomeActionFail here] end
}

export function isNhisServiceOutcomeModelAction(e: any): e is BaseNhisServiceOutcomeAction {
	return Object.values(NhisServiceOutcomeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
