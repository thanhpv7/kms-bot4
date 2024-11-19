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
import {DiagnosticStaffExaminationSummaryModel} from './diagnostic_staff_examination_summary.model';
import {DiagnosticStaffExaminationSummaryModelAudit} from './diagnostic_staff_examination_summary.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnostic Staff Examination Summary model actions to be dispatched by NgRx.
 */
export enum DiagnosticStaffExaminationSummaryModelActionTypes {
	CREATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Create DiagnosticStaffExaminationSummaryModel',
	CREATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Create DiagnosticStaffExaminationSummaryModel successfully',
	CREATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Create DiagnosticStaffExaminationSummaryModel failed',

	CREATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Create All DiagnosticStaffExaminationSummaryModel',
	CREATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Create All DiagnosticStaffExaminationSummaryModel successfully',
	CREATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Create All DiagnosticStaffExaminationSummaryModel failed',

	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModel',
	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModel successfully',
	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModel failed',


	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModels Excluding Ids',
	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModels Excluding Ids successfully',
	DELETE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosticStaffExaminationSummaryModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Delete all DiagnosticStaffExaminationSummaryModels',
	DELETE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Delete all DiagnosticStaffExaminationSummaryModels successfully',
	DELETE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Delete all DiagnosticStaffExaminationSummaryModels failed',

	UPDATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Update DiagnosticStaffExaminationSummaryModel',
	UPDATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Update DiagnosticStaffExaminationSummaryModel successfully',
	UPDATE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Update DiagnosticStaffExaminationSummaryModel failed',

	UPDATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Update all DiagnosticStaffExaminationSummaryModel',
	UPDATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Update all DiagnosticStaffExaminationSummaryModel successfully',
	UPDATE_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Update all DiagnosticStaffExaminationSummaryModel failed',

	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY= '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel successfully',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel failed',

	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDIT= '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audit',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDIT_OK = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audit successfully',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDIT_FAIL = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audit failed',

	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audits by entity id',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audits by entity id successfully',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel audits by entity id failed',

	FETCH_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Fetch all DiagnosticStaffExaminationSummaryModel',
	FETCH_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Fetch all DiagnosticStaffExaminationSummaryModel successfully',
	FETCH_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Fetch all DiagnosticStaffExaminationSummaryModel failed',

	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel with query',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel with query successfully',
	FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosticStaffExaminationSummaryModel with query failed',

	FETCH_LAST_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY = '[ENTITY] Fetch last DiagnosticStaffExaminationSummaryModel with query',
	FETCH_LAST_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosticStaffExaminationSummaryModel with query successfully',
	FETCH_LAST_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosticStaffExaminationSummaryModel with query failed',

	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Export DiagnosticStaffExaminationSummaryModel',
	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Export DiagnosticStaffExaminationSummaryModel successfully',
	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Export DiagnosticStaffExaminationSummaryModel failed',

	EXPORT_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY = '[ENTITY] Export All DiagnosticStaffExaminationSummaryModels',
	EXPORT_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_OK = '[ENTITY] Export All DiagnosticStaffExaminationSummaryModels successfully',
	EXPORT_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_FAIL = '[ENTITY] Export All DiagnosticStaffExaminationSummaryModels failed',

	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS = '[ENTITY] Export DiagnosticStaffExaminationSummaryModels excluding Ids',
	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosticStaffExaminationSummaryModel excluding Ids successfully',
	EXPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosticStaffExaminationSummaryModel excluding Ids failed',

	COUNT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS = '[ENTITY] Fetch number of DiagnosticStaffExaminationSummaryModel records',
	COUNT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS_OK = '[ENTITY] Fetch number of DiagnosticStaffExaminationSummaryModel records successfully ',
	COUNT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS_FAIL = '[ENTITY] Fetch number of DiagnosticStaffExaminationSummaryModel records failed',

	IMPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS = '[ENTITY] Import DiagnosticStaffExaminationSummaryModels',
	IMPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS_OK = '[ENTITY] Import DiagnosticStaffExaminationSummaryModels successfully',
	IMPORT_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARYS_FAIL = '[ENTITY] Import DiagnosticStaffExaminationSummaryModels fail',


	INITIALISE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosticStaffExaminationSummaryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosticStaffExaminationSummaryAction implements Action {
	readonly className: string = 'DiagnosticStaffExaminationSummaryModel';

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

export class DiagnosticStaffExaminationSummaryAction extends BaseDiagnosticStaffExaminationSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticStaffExaminationSummaryModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryAction here] end
}

export class DiagnosticStaffExaminationSummaryActionOK extends BaseDiagnosticStaffExaminationSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticStaffExaminationSummaryModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosticStaffExaminationSummaryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryActionOK here] end
}

export class DiagnosticStaffExaminationSummaryActionFail extends BaseDiagnosticStaffExaminationSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosticStaffExaminationSummaryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosticStaffExaminationSummaryModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticStaffExaminationSummaryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticStaffExaminationSummaryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticStaffExaminationSummaryActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosticStaffExaminationSummaryActionFail here] end
}

export function isDiagnosticStaffExaminationSummaryModelAction(e: any): e is BaseDiagnosticStaffExaminationSummaryAction {
	return Object.values(DiagnosticStaffExaminationSummaryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
