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
import {DiagnosticExaminationResultsModel} from './diagnostic_examination_results.model';
import {DiagnosticExaminationResultsModelAudit} from './diagnostic_examination_results.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnostic Examination Results model actions to be dispatched by NgRx.
 */
export enum DiagnosticExaminationResultsModelActionTypes {
	CREATE_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Create DiagnosticExaminationResultsModel',
	CREATE_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Create DiagnosticExaminationResultsModel successfully',
	CREATE_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Create DiagnosticExaminationResultsModel failed',

	CREATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Create All DiagnosticExaminationResultsModel',
	CREATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Create All DiagnosticExaminationResultsModel successfully',
	CREATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Create All DiagnosticExaminationResultsModel failed',

	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Delete DiagnosticExaminationResultsModel',
	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Delete DiagnosticExaminationResultsModel successfully',
	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Delete DiagnosticExaminationResultsModel failed',


	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS = '[ENTITY] Delete DiagnosticExaminationResultsModels Excluding Ids',
	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosticExaminationResultsModels Excluding Ids successfully',
	DELETE_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosticExaminationResultsModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Delete all DiagnosticExaminationResultsModels',
	DELETE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Delete all DiagnosticExaminationResultsModels successfully',
	DELETE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Delete all DiagnosticExaminationResultsModels failed',

	UPDATE_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Update DiagnosticExaminationResultsModel',
	UPDATE_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Update DiagnosticExaminationResultsModel successfully',
	UPDATE_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Update DiagnosticExaminationResultsModel failed',

	UPDATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Update all DiagnosticExaminationResultsModel',
	UPDATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Update all DiagnosticExaminationResultsModel successfully',
	UPDATE_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Update all DiagnosticExaminationResultsModel failed',

	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS= '[ENTITY] Fetch DiagnosticExaminationResultsModel',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Fetch DiagnosticExaminationResultsModel successfully',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Fetch DiagnosticExaminationResultsModel failed',

	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDIT= '[ENTITY] Fetch DiagnosticExaminationResultsModel audit',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDIT_OK = '[ENTITY] Fetch DiagnosticExaminationResultsModel audit successfully',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDIT_FAIL = '[ENTITY] Fetch DiagnosticExaminationResultsModel audit failed',

	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosticExaminationResultsModel audits by entity id',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosticExaminationResultsModel audits by entity id successfully',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosticExaminationResultsModel audits by entity id failed',

	FETCH_ALL_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Fetch all DiagnosticExaminationResultsModel',
	FETCH_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Fetch all DiagnosticExaminationResultsModel successfully',
	FETCH_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Fetch all DiagnosticExaminationResultsModel failed',

	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY = '[ENTITY] Fetch DiagnosticExaminationResultsModel with query',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosticExaminationResultsModel with query successfully',
	FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosticExaminationResultsModel with query failed',

	FETCH_LAST_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY = '[ENTITY] Fetch last DiagnosticExaminationResultsModel with query',
	FETCH_LAST_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosticExaminationResultsModel with query successfully',
	FETCH_LAST_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosticExaminationResultsModel with query failed',

	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Export DiagnosticExaminationResultsModel',
	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Export DiagnosticExaminationResultsModel successfully',
	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Export DiagnosticExaminationResultsModel failed',

	EXPORT_ALL_DIAGNOSTIC_EXAMINATION_RESULTS = '[ENTITY] Export All DiagnosticExaminationResultsModels',
	EXPORT_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_OK = '[ENTITY] Export All DiagnosticExaminationResultsModels successfully',
	EXPORT_ALL_DIAGNOSTIC_EXAMINATION_RESULTS_FAIL = '[ENTITY] Export All DiagnosticExaminationResultsModels failed',

	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS = '[ENTITY] Export DiagnosticExaminationResultsModels excluding Ids',
	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosticExaminationResultsModel excluding Ids successfully',
	EXPORT_DIAGNOSTIC_EXAMINATION_RESULTS_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosticExaminationResultsModel excluding Ids failed',

	COUNT_DIAGNOSTIC_EXAMINATION_RESULTSS = '[ENTITY] Fetch number of DiagnosticExaminationResultsModel records',
	COUNT_DIAGNOSTIC_EXAMINATION_RESULTSS_OK = '[ENTITY] Fetch number of DiagnosticExaminationResultsModel records successfully ',
	COUNT_DIAGNOSTIC_EXAMINATION_RESULTSS_FAIL = '[ENTITY] Fetch number of DiagnosticExaminationResultsModel records failed',

	IMPORT_DIAGNOSTIC_EXAMINATION_RESULTSS = '[ENTITY] Import DiagnosticExaminationResultsModels',
	IMPORT_DIAGNOSTIC_EXAMINATION_RESULTSS_OK = '[ENTITY] Import DiagnosticExaminationResultsModels successfully',
	IMPORT_DIAGNOSTIC_EXAMINATION_RESULTSS_FAIL = '[ENTITY] Import DiagnosticExaminationResultsModels fail',


	INITIALISE_DIAGNOSTIC_EXAMINATION_RESULTS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosticExaminationResultsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosticExaminationResultsAction implements Action {
	readonly className: string = 'DiagnosticExaminationResultsModel';

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

export class DiagnosticExaminationResultsAction extends BaseDiagnosticExaminationResultsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticExaminationResultsModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsAction here] end
}

export class DiagnosticExaminationResultsActionOK extends BaseDiagnosticExaminationResultsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticExaminationResultsModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosticExaminationResultsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsActionOK here] end
}

export class DiagnosticExaminationResultsActionFail extends BaseDiagnosticExaminationResultsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosticExaminationResultsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosticExaminationResultsModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticExaminationResultsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticExaminationResultsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticExaminationResultsActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosticExaminationResultsActionFail here] end
}

export function isDiagnosticExaminationResultsModelAction(e: any): e is BaseDiagnosticExaminationResultsAction {
	return Object.values(DiagnosticExaminationResultsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
