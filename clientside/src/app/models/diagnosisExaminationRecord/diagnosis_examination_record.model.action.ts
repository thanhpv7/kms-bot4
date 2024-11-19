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
import {DiagnosisExaminationRecordModel} from './diagnosis_examination_record.model';
import {DiagnosisExaminationRecordModelAudit} from './diagnosis_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnosis Examination Record model actions to be dispatched by NgRx.
 */
export enum DiagnosisExaminationRecordModelActionTypes {
	CREATE_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Create DiagnosisExaminationRecordModel',
	CREATE_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Create DiagnosisExaminationRecordModel successfully',
	CREATE_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Create DiagnosisExaminationRecordModel failed',

	CREATE_ALL_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Create All DiagnosisExaminationRecordModel',
	CREATE_ALL_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Create All DiagnosisExaminationRecordModel successfully',
	CREATE_ALL_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All DiagnosisExaminationRecordModel failed',

	DELETE_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Delete DiagnosisExaminationRecordModel',
	DELETE_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Delete DiagnosisExaminationRecordModel successfully',
	DELETE_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete DiagnosisExaminationRecordModel failed',


	DELETE_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete DiagnosisExaminationRecordModels Excluding Ids',
	DELETE_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosisExaminationRecordModels Excluding Ids successfully',
	DELETE_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosisExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Delete all DiagnosisExaminationRecordModels',
	DELETE_ALL_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Delete all DiagnosisExaminationRecordModels successfully',
	DELETE_ALL_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all DiagnosisExaminationRecordModels failed',

	UPDATE_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Update DiagnosisExaminationRecordModel',
	UPDATE_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Update DiagnosisExaminationRecordModel successfully',
	UPDATE_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Update DiagnosisExaminationRecordModel failed',

	UPDATE_ALL_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Update all DiagnosisExaminationRecordModel',
	UPDATE_ALL_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Update all DiagnosisExaminationRecordModel successfully',
	UPDATE_ALL_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all DiagnosisExaminationRecordModel failed',

	FETCH_DIAGNOSIS_EXAMINATION_RECORD= '[ENTITY] Fetch DiagnosisExaminationRecordModel',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Fetch DiagnosisExaminationRecordModel successfully',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch DiagnosisExaminationRecordModel failed',

	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch DiagnosisExaminationRecordModel audit',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch DiagnosisExaminationRecordModel audit successfully',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch DiagnosisExaminationRecordModel audit failed',

	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosisExaminationRecordModel audits by entity id',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosisExaminationRecordModel audits by entity id successfully',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosisExaminationRecordModel audits by entity id failed',

	FETCH_ALL_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Fetch all DiagnosisExaminationRecordModel',
	FETCH_ALL_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all DiagnosisExaminationRecordModel successfully',
	FETCH_ALL_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all DiagnosisExaminationRecordModel failed',

	FETCH_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch DiagnosisExaminationRecordModel with query',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosisExaminationRecordModel with query successfully',
	FETCH_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosisExaminationRecordModel with query failed',

	FETCH_LAST_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last DiagnosisExaminationRecordModel with query',
	FETCH_LAST_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosisExaminationRecordModel with query successfully',
	FETCH_LAST_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosisExaminationRecordModel with query failed',

	EXPORT_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Export DiagnosisExaminationRecordModel',
	EXPORT_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Export DiagnosisExaminationRecordModel successfully',
	EXPORT_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Export DiagnosisExaminationRecordModel failed',

	EXPORT_ALL_DIAGNOSIS_EXAMINATION_RECORD = '[ENTITY] Export All DiagnosisExaminationRecordModels',
	EXPORT_ALL_DIAGNOSIS_EXAMINATION_RECORD_OK = '[ENTITY] Export All DiagnosisExaminationRecordModels successfully',
	EXPORT_ALL_DIAGNOSIS_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All DiagnosisExaminationRecordModels failed',

	EXPORT_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export DiagnosisExaminationRecordModels excluding Ids',
	EXPORT_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosisExaminationRecordModel excluding Ids successfully',
	EXPORT_DIAGNOSIS_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosisExaminationRecordModel excluding Ids failed',

	COUNT_DIAGNOSIS_EXAMINATION_RECORDS = '[ENTITY] Fetch number of DiagnosisExaminationRecordModel records',
	COUNT_DIAGNOSIS_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of DiagnosisExaminationRecordModel records successfully ',
	COUNT_DIAGNOSIS_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of DiagnosisExaminationRecordModel records failed',

	IMPORT_DIAGNOSIS_EXAMINATION_RECORDS = '[ENTITY] Import DiagnosisExaminationRecordModels',
	IMPORT_DIAGNOSIS_EXAMINATION_RECORDS_OK = '[ENTITY] Import DiagnosisExaminationRecordModels successfully',
	IMPORT_DIAGNOSIS_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import DiagnosisExaminationRecordModels fail',


	INITIALISE_DIAGNOSIS_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosisExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosisExaminationRecordAction implements Action {
	readonly className: string = 'DiagnosisExaminationRecordModel';

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

export class DiagnosisExaminationRecordAction extends BaseDiagnosisExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosisExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordAction here] end
}

export class DiagnosisExaminationRecordActionOK extends BaseDiagnosisExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosisExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosisExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordActionOK here] end
}

export class DiagnosisExaminationRecordActionFail extends BaseDiagnosisExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosisExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosisExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosisExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosisExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosisExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosisExaminationRecordActionFail here] end
}

export function isDiagnosisExaminationRecordModelAction(e: any): e is BaseDiagnosisExaminationRecordAction {
	return Object.values(DiagnosisExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
