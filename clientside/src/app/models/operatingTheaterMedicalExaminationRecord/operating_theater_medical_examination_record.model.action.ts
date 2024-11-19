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
import {OperatingTheaterMedicalExaminationRecordModel} from './operating_theater_medical_examination_record.model';
import {OperatingTheaterMedicalExaminationRecordModelAudit} from './operating_theater_medical_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Operating Theater Medical Examination Record model actions to be dispatched by NgRx.
 */
export enum OperatingTheaterMedicalExaminationRecordModelActionTypes {
	CREATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create OperatingTheaterMedicalExaminationRecordModel',
	CREATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create OperatingTheaterMedicalExaminationRecordModel successfully',
	CREATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create OperatingTheaterMedicalExaminationRecordModel failed',

	CREATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create All OperatingTheaterMedicalExaminationRecordModel',
	CREATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create All OperatingTheaterMedicalExaminationRecordModel successfully',
	CREATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All OperatingTheaterMedicalExaminationRecordModel failed',

	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModel',
	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModel successfully',
	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModel failed',


	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModels Excluding Ids',
	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModels Excluding Ids successfully',
	DELETE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete OperatingTheaterMedicalExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete all OperatingTheaterMedicalExaminationRecordModels',
	DELETE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete all OperatingTheaterMedicalExaminationRecordModels successfully',
	DELETE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all OperatingTheaterMedicalExaminationRecordModels failed',

	UPDATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update OperatingTheaterMedicalExaminationRecordModel',
	UPDATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update OperatingTheaterMedicalExaminationRecordModel successfully',
	UPDATE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update OperatingTheaterMedicalExaminationRecordModel failed',

	UPDATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update all OperatingTheaterMedicalExaminationRecordModel',
	UPDATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update all OperatingTheaterMedicalExaminationRecordModel successfully',
	UPDATE_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all OperatingTheaterMedicalExaminationRecordModel failed',

	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD= '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel successfully',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel failed',

	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audit',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audit successfully',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audit failed',

	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audits by entity id',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audits by entity id successfully',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel audits by entity id failed',

	FETCH_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Fetch all OperatingTheaterMedicalExaminationRecordModel',
	FETCH_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all OperatingTheaterMedicalExaminationRecordModel successfully',
	FETCH_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all OperatingTheaterMedicalExaminationRecordModel failed',

	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel with query',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel with query successfully',
	FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch OperatingTheaterMedicalExaminationRecordModel with query failed',

	FETCH_LAST_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last OperatingTheaterMedicalExaminationRecordModel with query',
	FETCH_LAST_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last OperatingTheaterMedicalExaminationRecordModel with query successfully',
	FETCH_LAST_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last OperatingTheaterMedicalExaminationRecordModel with query failed',

	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModel',
	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModel successfully',
	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModel failed',

	EXPORT_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export All OperatingTheaterMedicalExaminationRecordModels',
	EXPORT_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export All OperatingTheaterMedicalExaminationRecordModels successfully',
	EXPORT_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All OperatingTheaterMedicalExaminationRecordModels failed',

	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModels excluding Ids',
	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModel excluding Ids successfully',
	EXPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export OperatingTheaterMedicalExaminationRecordModel excluding Ids failed',

	COUNT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Fetch number of OperatingTheaterMedicalExaminationRecordModel records',
	COUNT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of OperatingTheaterMedicalExaminationRecordModel records successfully ',
	COUNT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of OperatingTheaterMedicalExaminationRecordModel records failed',

	IMPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Import OperatingTheaterMedicalExaminationRecordModels',
	IMPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Import OperatingTheaterMedicalExaminationRecordModels successfully',
	IMPORT_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import OperatingTheaterMedicalExaminationRecordModels fail',


	INITIALISE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of OperatingTheaterMedicalExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseOperatingTheaterMedicalExaminationRecordAction implements Action {
	readonly className: string = 'OperatingTheaterMedicalExaminationRecordModel';

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

export class OperatingTheaterMedicalExaminationRecordAction extends BaseOperatingTheaterMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordAction here] end
}

export class OperatingTheaterMedicalExaminationRecordActionOK extends BaseOperatingTheaterMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: OperatingTheaterMedicalExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordActionOK here] end
}

export class OperatingTheaterMedicalExaminationRecordActionFail extends BaseOperatingTheaterMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for OperatingTheaterMedicalExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<OperatingTheaterMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for OperatingTheaterMedicalExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for OperatingTheaterMedicalExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for OperatingTheaterMedicalExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for OperatingTheaterMedicalExaminationRecordActionFail here] end
}

export function isOperatingTheaterMedicalExaminationRecordModelAction(e: any): e is BaseOperatingTheaterMedicalExaminationRecordAction {
	return Object.values(OperatingTheaterMedicalExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
