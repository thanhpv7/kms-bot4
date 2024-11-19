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
import {InpatientMedicalExaminationRecordModel} from './inpatient_medical_examination_record.model';
import {InpatientMedicalExaminationRecordModelAudit} from './inpatient_medical_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Inpatient Medical Examination Record model actions to be dispatched by NgRx.
 */
export enum InpatientMedicalExaminationRecordModelActionTypes {
	CREATE_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create InpatientMedicalExaminationRecordModel',
	CREATE_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create InpatientMedicalExaminationRecordModel successfully',
	CREATE_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create InpatientMedicalExaminationRecordModel failed',

	CREATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create All InpatientMedicalExaminationRecordModel',
	CREATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create All InpatientMedicalExaminationRecordModel successfully',
	CREATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All InpatientMedicalExaminationRecordModel failed',

	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete InpatientMedicalExaminationRecordModel',
	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete InpatientMedicalExaminationRecordModel successfully',
	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete InpatientMedicalExaminationRecordModel failed',


	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete InpatientMedicalExaminationRecordModels Excluding Ids',
	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete InpatientMedicalExaminationRecordModels Excluding Ids successfully',
	DELETE_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InpatientMedicalExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete all InpatientMedicalExaminationRecordModels',
	DELETE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete all InpatientMedicalExaminationRecordModels successfully',
	DELETE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all InpatientMedicalExaminationRecordModels failed',

	UPDATE_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update InpatientMedicalExaminationRecordModel',
	UPDATE_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update InpatientMedicalExaminationRecordModel successfully',
	UPDATE_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update InpatientMedicalExaminationRecordModel failed',

	UPDATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update all InpatientMedicalExaminationRecordModel',
	UPDATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update all InpatientMedicalExaminationRecordModel successfully',
	UPDATE_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all InpatientMedicalExaminationRecordModel failed',

	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD= '[ENTITY] Fetch InpatientMedicalExaminationRecordModel',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel successfully',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel failed',

	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audit',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audit successfully',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audit failed',

	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audits by entity id',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audits by entity id successfully',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel audits by entity id failed',

	FETCH_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Fetch all InpatientMedicalExaminationRecordModel',
	FETCH_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all InpatientMedicalExaminationRecordModel successfully',
	FETCH_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all InpatientMedicalExaminationRecordModel failed',

	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel with query',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel with query successfully',
	FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch InpatientMedicalExaminationRecordModel with query failed',

	FETCH_LAST_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last InpatientMedicalExaminationRecordModel with query',
	FETCH_LAST_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last InpatientMedicalExaminationRecordModel with query successfully',
	FETCH_LAST_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last InpatientMedicalExaminationRecordModel with query failed',

	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export InpatientMedicalExaminationRecordModel',
	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export InpatientMedicalExaminationRecordModel successfully',
	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export InpatientMedicalExaminationRecordModel failed',

	EXPORT_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export All InpatientMedicalExaminationRecordModels',
	EXPORT_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export All InpatientMedicalExaminationRecordModels successfully',
	EXPORT_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All InpatientMedicalExaminationRecordModels failed',

	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export InpatientMedicalExaminationRecordModels excluding Ids',
	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export InpatientMedicalExaminationRecordModel excluding Ids successfully',
	EXPORT_INPATIENT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export InpatientMedicalExaminationRecordModel excluding Ids failed',

	COUNT_INPATIENT_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Fetch number of InpatientMedicalExaminationRecordModel records',
	COUNT_INPATIENT_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of InpatientMedicalExaminationRecordModel records successfully ',
	COUNT_INPATIENT_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of InpatientMedicalExaminationRecordModel records failed',

	IMPORT_INPATIENT_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Import InpatientMedicalExaminationRecordModels',
	IMPORT_INPATIENT_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Import InpatientMedicalExaminationRecordModels successfully',
	IMPORT_INPATIENT_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import InpatientMedicalExaminationRecordModels fail',


	INITIALISE_INPATIENT_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InpatientMedicalExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInpatientMedicalExaminationRecordAction implements Action {
	readonly className: string = 'InpatientMedicalExaminationRecordModel';

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

export class InpatientMedicalExaminationRecordAction extends BaseInpatientMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InpatientMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordAction here] end
}

export class InpatientMedicalExaminationRecordActionOK extends BaseInpatientMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InpatientMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InpatientMedicalExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordActionOK here] end
}

export class InpatientMedicalExaminationRecordActionFail extends BaseInpatientMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for InpatientMedicalExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InpatientMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InpatientMedicalExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InpatientMedicalExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InpatientMedicalExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for InpatientMedicalExaminationRecordActionFail here] end
}

export function isInpatientMedicalExaminationRecordModelAction(e: any): e is BaseInpatientMedicalExaminationRecordAction {
	return Object.values(InpatientMedicalExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
