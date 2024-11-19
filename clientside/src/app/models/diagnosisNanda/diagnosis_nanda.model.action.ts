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
import {DiagnosisNandaModel} from './diagnosis_nanda.model';
import {DiagnosisNandaModelAudit} from './diagnosis_nanda.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnosis Nanda model actions to be dispatched by NgRx.
 */
export enum DiagnosisNandaModelActionTypes {
	CREATE_DIAGNOSIS_NANDA = '[ENTITY] Create DiagnosisNandaModel',
	CREATE_DIAGNOSIS_NANDA_OK = '[ENTITY] Create DiagnosisNandaModel successfully',
	CREATE_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Create DiagnosisNandaModel failed',

	CREATE_ALL_DIAGNOSIS_NANDA = '[ENTITY] Create All DiagnosisNandaModel',
	CREATE_ALL_DIAGNOSIS_NANDA_OK = '[ENTITY] Create All DiagnosisNandaModel successfully',
	CREATE_ALL_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Create All DiagnosisNandaModel failed',

	DELETE_DIAGNOSIS_NANDA = '[ENTITY] Delete DiagnosisNandaModel',
	DELETE_DIAGNOSIS_NANDA_OK = '[ENTITY] Delete DiagnosisNandaModel successfully',
	DELETE_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Delete DiagnosisNandaModel failed',


	DELETE_DIAGNOSIS_NANDA_EXCLUDING_IDS = '[ENTITY] Delete DiagnosisNandaModels Excluding Ids',
	DELETE_DIAGNOSIS_NANDA_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosisNandaModels Excluding Ids successfully',
	DELETE_DIAGNOSIS_NANDA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosisNandaModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSIS_NANDA = '[ENTITY] Delete all DiagnosisNandaModels',
	DELETE_ALL_DIAGNOSIS_NANDA_OK = '[ENTITY] Delete all DiagnosisNandaModels successfully',
	DELETE_ALL_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Delete all DiagnosisNandaModels failed',

	UPDATE_DIAGNOSIS_NANDA = '[ENTITY] Update DiagnosisNandaModel',
	UPDATE_DIAGNOSIS_NANDA_OK = '[ENTITY] Update DiagnosisNandaModel successfully',
	UPDATE_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Update DiagnosisNandaModel failed',

	UPDATE_ALL_DIAGNOSIS_NANDA = '[ENTITY] Update all DiagnosisNandaModel',
	UPDATE_ALL_DIAGNOSIS_NANDA_OK = '[ENTITY] Update all DiagnosisNandaModel successfully',
	UPDATE_ALL_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Update all DiagnosisNandaModel failed',

	FETCH_DIAGNOSIS_NANDA= '[ENTITY] Fetch DiagnosisNandaModel',
	FETCH_DIAGNOSIS_NANDA_OK = '[ENTITY] Fetch DiagnosisNandaModel successfully',
	FETCH_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Fetch DiagnosisNandaModel failed',

	FETCH_DIAGNOSIS_NANDA_AUDIT= '[ENTITY] Fetch DiagnosisNandaModel audit',
	FETCH_DIAGNOSIS_NANDA_AUDIT_OK = '[ENTITY] Fetch DiagnosisNandaModel audit successfully',
	FETCH_DIAGNOSIS_NANDA_AUDIT_FAIL = '[ENTITY] Fetch DiagnosisNandaModel audit failed',

	FETCH_DIAGNOSIS_NANDA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosisNandaModel audits by entity id',
	FETCH_DIAGNOSIS_NANDA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosisNandaModel audits by entity id successfully',
	FETCH_DIAGNOSIS_NANDA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosisNandaModel audits by entity id failed',

	FETCH_ALL_DIAGNOSIS_NANDA = '[ENTITY] Fetch all DiagnosisNandaModel',
	FETCH_ALL_DIAGNOSIS_NANDA_OK = '[ENTITY] Fetch all DiagnosisNandaModel successfully',
	FETCH_ALL_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Fetch all DiagnosisNandaModel failed',

	FETCH_DIAGNOSIS_NANDA_WITH_QUERY = '[ENTITY] Fetch DiagnosisNandaModel with query',
	FETCH_DIAGNOSIS_NANDA_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosisNandaModel with query successfully',
	FETCH_DIAGNOSIS_NANDA_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosisNandaModel with query failed',

	FETCH_LAST_DIAGNOSIS_NANDA_WITH_QUERY = '[ENTITY] Fetch last DiagnosisNandaModel with query',
	FETCH_LAST_DIAGNOSIS_NANDA_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosisNandaModel with query successfully',
	FETCH_LAST_DIAGNOSIS_NANDA_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosisNandaModel with query failed',

	EXPORT_DIAGNOSIS_NANDA = '[ENTITY] Export DiagnosisNandaModel',
	EXPORT_DIAGNOSIS_NANDA_OK = '[ENTITY] Export DiagnosisNandaModel successfully',
	EXPORT_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Export DiagnosisNandaModel failed',

	EXPORT_ALL_DIAGNOSIS_NANDA = '[ENTITY] Export All DiagnosisNandaModels',
	EXPORT_ALL_DIAGNOSIS_NANDA_OK = '[ENTITY] Export All DiagnosisNandaModels successfully',
	EXPORT_ALL_DIAGNOSIS_NANDA_FAIL = '[ENTITY] Export All DiagnosisNandaModels failed',

	EXPORT_DIAGNOSIS_NANDA_EXCLUDING_IDS = '[ENTITY] Export DiagnosisNandaModels excluding Ids',
	EXPORT_DIAGNOSIS_NANDA_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosisNandaModel excluding Ids successfully',
	EXPORT_DIAGNOSIS_NANDA_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosisNandaModel excluding Ids failed',

	COUNT_DIAGNOSIS_NANDAS = '[ENTITY] Fetch number of DiagnosisNandaModel records',
	COUNT_DIAGNOSIS_NANDAS_OK = '[ENTITY] Fetch number of DiagnosisNandaModel records successfully ',
	COUNT_DIAGNOSIS_NANDAS_FAIL = '[ENTITY] Fetch number of DiagnosisNandaModel records failed',

	IMPORT_DIAGNOSIS_NANDAS = '[ENTITY] Import DiagnosisNandaModels',
	IMPORT_DIAGNOSIS_NANDAS_OK = '[ENTITY] Import DiagnosisNandaModels successfully',
	IMPORT_DIAGNOSIS_NANDAS_FAIL = '[ENTITY] Import DiagnosisNandaModels fail',


	INITIALISE_DIAGNOSIS_NANDA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosisNandaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosisNandaAction implements Action {
	readonly className: string = 'DiagnosisNandaModel';

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

export class DiagnosisNandaAction extends BaseDiagnosisNandaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisNandaAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosisNandaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosisNandaModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisNandaAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisNandaAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisNandaAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosisNandaAction here] end
}

export class DiagnosisNandaActionOK extends BaseDiagnosisNandaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisNandaActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosisNandaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosisNandaModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosisNandaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisNandaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisNandaActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisNandaActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosisNandaActionOK here] end
}

export class DiagnosisNandaActionFail extends BaseDiagnosisNandaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisNandaActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosisNandaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosisNandaModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisNandaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisNandaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisNandaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisNandaActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisNandaActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosisNandaActionFail here] end
}

export function isDiagnosisNandaModelAction(e: any): e is BaseDiagnosisNandaAction {
	return Object.values(DiagnosisNandaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
